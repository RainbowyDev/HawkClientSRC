package optifine;

import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import java.util.*;

public class PlayerItemsLayer implements LayerRenderer
{
    private /* synthetic */ RenderPlayer renderPlayer;
    
    protected void renderEquippedItems(final EntityLivingBase llllllllllllllIlllIlIllIllllIlll, final float llllllllllllllIlllIlIllIllllIllI, final float llllllllllllllIlllIlIllIllllIlIl) {
        if (Config.isShowCapes() && llllllllllllllIlllIlIllIllllIlll instanceof AbstractClientPlayer) {
            final AbstractClientPlayer llllllllllllllIlllIlIllIlllllIlI = (AbstractClientPlayer)llllllllllllllIlllIlIllIllllIlll;
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableRescaleNormal();
            final ModelBiped llllllllllllllIlllIlIllIlllllIIl = (ModelBiped)this.renderPlayer.getMainModel();
            PlayerConfigurations.renderPlayerItems(llllllllllllllIlllIlIllIlllllIIl, llllllllllllllIlllIlIllIlllllIlI, llllllllllllllIlllIlIllIllllIllI, llllllllllllllIlllIlIllIllllIlIl);
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public PlayerItemsLayer(final RenderPlayer llllllllllllllIlllIlIlllIIIllIII) {
        this.renderPlayer = null;
        this.renderPlayer = llllllllllllllIlllIlIlllIIIllIII;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIlllIlIlllIIIlIIII, final float llllllllllllllIlllIlIlllIIIIllll, final float llllllllllllllIlllIlIlllIIIIlllI, final float llllllllllllllIlllIlIlllIIIIllIl, final float llllllllllllllIlllIlIlllIIIIllII, final float llllllllllllllIlllIlIlllIIIIlIll, final float llllllllllllllIlllIlIlllIIIIlIlI, final float llllllllllllllIlllIlIlllIIIIIlIl) {
        this.renderEquippedItems(llllllllllllllIlllIlIlllIIIlIIII, llllllllllllllIlllIlIlllIIIIIlIl, llllllllllllllIlllIlIlllIIIIllIl);
    }
    
    public static void register(final Map llllllllllllllIlllIlIllIlllIlIlI) {
        final Set llllllllllllllIlllIlIllIlllIlIIl = llllllllllllllIlllIlIllIlllIlIlI.keySet();
        boolean llllllllllllllIlllIlIllIlllIlIII = false;
        for (final Object llllllllllllllIlllIlIllIlllIIllI : llllllllllllllIlllIlIllIlllIlIIl) {
            final Object llllllllllllllIlllIlIllIlllIIlIl = llllllllllllllIlllIlIllIlllIlIlI.get(llllllllllllllIlllIlIllIlllIIllI);
            if (llllllllllllllIlllIlIllIlllIIlIl instanceof RenderPlayer) {
                final RenderPlayer llllllllllllllIlllIlIllIlllIIlII = (RenderPlayer)llllllllllllllIlllIlIllIlllIIlIl;
                llllllllllllllIlllIlIllIlllIIlII.addLayer(new PlayerItemsLayer(llllllllllllllIlllIlIllIlllIIlII));
                llllllllllllllIlllIlIllIlllIlIII = true;
            }
        }
        if (!llllllllllllllIlllIlIllIlllIlIII) {
            Config.warn("PlayerItemsLayer not registered");
        }
    }
}
