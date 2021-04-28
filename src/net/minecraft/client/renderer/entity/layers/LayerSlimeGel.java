package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerSlimeGel implements LayerRenderer
{
    private final /* synthetic */ RenderSlime slimeRenderer;
    private final /* synthetic */ ModelBase slimeModel;
    
    public LayerSlimeGel(final RenderSlime llllllllllllllIIIIllllllIlIIllII) {
        this.slimeModel = new ModelSlime(0);
        this.slimeRenderer = llllllllllllllIIIIllllllIlIIllII;
    }
    
    static {
        __OBFID = "CL_00002412";
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIIIIllllllIIIllllI, final float llllllllllllllIIIIllllllIIlIIllI, final float llllllllllllllIIIIllllllIIIlllII, final float llllllllllllllIIIIllllllIIIllIll, final float llllllllllllllIIIIllllllIIIllIlI, final float llllllllllllllIIIIllllllIIIllIIl, final float llllllllllllllIIIIllllllIIIllIII, final float llllllllllllllIIIIllllllIIIlIlll) {
        this.doRenderLayer((EntitySlime)llllllllllllllIIIIllllllIIIllllI, llllllllllllllIIIIllllllIIlIIllI, llllllllllllllIIIIllllllIIIlllII, llllllllllllllIIIIllllllIIIllIll, llllllllllllllIIIIllllllIIIllIlI, llllllllllllllIIIIllllllIIIllIIl, llllllllllllllIIIIllllllIIIllIII, llllllllllllllIIIIllllllIIIlIlll);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    public void doRenderLayer(final EntitySlime llllllllllllllIIIIllllllIIlllIIl, final float llllllllllllllIIIIllllllIlIIIIIl, final float llllllllllllllIIIIllllllIIllIlll, final float llllllllllllllIIIIllllllIIllllll, final float llllllllllllllIIIIllllllIIllIllI, final float llllllllllllllIIIIllllllIIllIlIl, final float llllllllllllllIIIIllllllIIllllII, final float llllllllllllllIIIIllllllIIlllIll) {
        if (!llllllllllllllIIIIllllllIIlllIIl.isInvisible()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            this.slimeModel.setModelAttributes(this.slimeRenderer.getMainModel());
            this.slimeModel.render(llllllllllllllIIIIllllllIIlllIIl, llllllllllllllIIIIllllllIlIIIIIl, llllllllllllllIIIIllllllIIllIlll, llllllllllllllIIIIllllllIIllIllI, llllllllllllllIIIIllllllIIllIlIl, llllllllllllllIIIIllllllIIllllII, llllllllllllllIIIIllllllIIlllIll);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }
}
