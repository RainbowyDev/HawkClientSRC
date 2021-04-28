package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerMooshroomMushroom implements LayerRenderer
{
    private final /* synthetic */ RenderMooshroom field_177205_a;
    
    static {
        __OBFID = "CL_00002415";
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    public void func_177204_a(final EntityMooshroom lIIIIIlIIlIIlII, final float lIIIIIlIIlIIIll, final float lIIIIIlIIlIIIlI, final float lIIIIIlIIlIIIIl, final float lIIIIIlIIlIIIII, final float lIIIIIlIIIlllll, final float lIIIIIlIIIllllI, final float lIIIIIlIIIlllIl) {
        if (!lIIIIIlIIlIIlII.isChild() && !lIIIIIlIIlIIlII.isInvisible()) {
            final BlockRendererDispatcher lIIIIIlIIIlllII = Minecraft.getMinecraft().getBlockRendererDispatcher();
            this.field_177205_a.bindTexture(TextureMap.locationBlocksTexture);
            GlStateManager.enableCull();
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f, -1.0f, 1.0f);
            GlStateManager.translate(0.2f, 0.35f, 0.5f);
            GlStateManager.rotate(42.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lIIIIIlIIIlllII.func_175016_a(Blocks.red_mushroom.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.1f, 0.0f, -0.6f);
            GlStateManager.rotate(42.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lIIIIIlIIIlllII.func_175016_a(Blocks.red_mushroom.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            ((ModelQuadruped)this.field_177205_a.getMainModel()).head.postRender(0.0625f);
            GlStateManager.scale(1.0f, -1.0f, 1.0f);
            GlStateManager.translate(0.0f, 0.7f, -0.2f);
            GlStateManager.rotate(12.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lIIIIIlIIIlllII.func_175016_a(Blocks.red_mushroom.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.disableCull();
        }
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lIIIIIlIIIIIlII, final float lIIIIIlIIIIllII, final float lIIIIIlIIIIlIll, final float lIIIIIlIIIIlIlI, final float lIIIIIlIIIIIIII, final float lIIIIIlIIIIlIII, final float lIIIIIlIIIIIlll, final float lIIIIIlIIIIIllI) {
        this.func_177204_a((EntityMooshroom)lIIIIIlIIIIIlII, lIIIIIlIIIIllII, lIIIIIlIIIIlIll, lIIIIIlIIIIlIlI, lIIIIIlIIIIIIII, lIIIIIlIIIIlIII, lIIIIIlIIIIIlll, lIIIIIlIIIIIllI);
    }
    
    public LayerMooshroomMushroom(final RenderMooshroom lIIIIIlIIlIlIll) {
        this.field_177205_a = lIIIIIlIIlIlIll;
    }
}
