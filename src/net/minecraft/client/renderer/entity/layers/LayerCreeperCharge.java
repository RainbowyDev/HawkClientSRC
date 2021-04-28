package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerCreeperCharge implements LayerRenderer
{
    private final /* synthetic */ ModelCreeper creeperModel;
    private final /* synthetic */ RenderCreeper creeperRenderer;
    private static final /* synthetic */ ResourceLocation LIGHTNING_TEXTURE;
    
    static {
        __OBFID = "CL_00002423";
        LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllllllIlllIIllllIIIIl, final float lllllllllllllllllIlllIIllllIIIII, final float lllllllllllllllllIlllIIlllIlllll, final float lllllllllllllllllIlllIIlllIlIlIl, final float lllllllllllllllllIlllIIlllIlllIl, final float lllllllllllllllllIlllIIlllIlIIll, final float lllllllllllllllllIlllIIlllIllIll, final float lllllllllllllllllIlllIIlllIllIlI) {
        this.doRenderLayer((EntityCreeper)lllllllllllllllllIlllIIllllIIIIl, lllllllllllllllllIlllIIllllIIIII, lllllllllllllllllIlllIIlllIlllll, lllllllllllllllllIlllIIlllIlIlIl, lllllllllllllllllIlllIIlllIlllIl, lllllllllllllllllIlllIIlllIlIIll, lllllllllllllllllIlllIIlllIllIll, lllllllllllllllllIlllIIlllIllIlI);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerCreeperCharge(final RenderCreeper lllllllllllllllllIlllIlIIIIlIIII) {
        this.creeperModel = new ModelCreeper(2.0f);
        this.creeperRenderer = lllllllllllllllllIlllIlIIIIlIIII;
    }
    
    public void doRenderLayer(final EntityCreeper lllllllllllllllllIlllIlIIIIIIIIl, final float lllllllllllllllllIlllIIlllllIlIl, final float lllllllllllllllllIlllIIlllllllll, final float lllllllllllllllllIlllIIllllllllI, final float lllllllllllllllllIlllIIlllllllIl, final float lllllllllllllllllIlllIIlllllIIIl, final float lllllllllllllllllIlllIIllllllIll, final float lllllllllllllllllIlllIIllllllIlI) {
        if (lllllllllllllllllIlllIlIIIIIIIIl.getPowered()) {
            GlStateManager.depthMask(!lllllllllllllllllIlllIlIIIIIIIIl.isInvisible());
            this.creeperRenderer.bindTexture(LayerCreeperCharge.LIGHTNING_TEXTURE);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            final float lllllllllllllllllIlllIIllllllIIl = lllllllllllllllllIlllIlIIIIIIIIl.ticksExisted + lllllllllllllllllIlllIIllllllllI;
            GlStateManager.translate(lllllllllllllllllIlllIIllllllIIl * 0.01f, lllllllllllllllllIlllIIllllllIIl * 0.01f, 0.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            final float lllllllllllllllllIlllIIllllllIII = 0.5f;
            GlStateManager.color(lllllllllllllllllIlllIIllllllIII, lllllllllllllllllIlllIIllllllIII, lllllllllllllllllIlllIIllllllIII, 1.0f);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(1, 1);
            this.creeperModel.setModelAttributes(this.creeperRenderer.getMainModel());
            this.creeperModel.render(lllllllllllllllllIlllIlIIIIIIIIl, lllllllllllllllllIlllIIlllllIlIl, lllllllllllllllllIlllIIlllllllll, lllllllllllllllllIlllIIlllllllIl, lllllllllllllllllIlllIIlllllIIIl, lllllllllllllllllIlllIIllllllIll, lllllllllllllllllIlllIIllllllIlI);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
        }
    }
}
