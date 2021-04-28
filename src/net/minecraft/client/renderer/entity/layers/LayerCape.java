package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class LayerCape implements LayerRenderer
{
    private final /* synthetic */ RenderPlayer playerRenderer;
    
    public LayerCape(final RenderPlayer llllllllllllllIllllIIlIIIIIIlllI) {
        this.playerRenderer = llllllllllllllIllllIIlIIIIIIlllI;
    }
    
    static {
        __OBFID = "CL_00002425";
    }
    
    public void doRenderLayer(final AbstractClientPlayer llllllllllllllIllllIIIllllllllIl, final float llllllllllllllIllllIIIllllllllII, final float llllllllllllllIllllIIIlllllllIll, final float llllllllllllllIllllIIIlllllIlIIl, final float llllllllllllllIllllIIIlllllllIIl, final float llllllllllllllIllllIIIlllllllIII, final float llllllllllllllIllllIIIllllllIlll, final float llllllllllllllIllllIIIllllllIllI) {
        if (llllllllllllllIllllIIIllllllllIl.hasCape() && !llllllllllllllIllllIIIllllllllIl.isInvisible() && llllllllllllllIllllIIIllllllllIl.func_175148_a(EnumPlayerModelParts.CAPE) && llllllllllllllIllllIIIllllllllIl.getLocationCape() != null) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.playerRenderer.bindTexture(llllllllllllllIllllIIIllllllllIl.getLocationCape());
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, 0.125f);
            final double llllllllllllllIllllIIIllllllIlIl = llllllllllllllIllllIIIllllllllIl.field_71091_bM + (llllllllllllllIllllIIIllllllllIl.field_71094_bP - llllllllllllllIllllIIIllllllllIl.field_71091_bM) * llllllllllllllIllllIIIlllllIlIIl - (llllllllllllllIllllIIIllllllllIl.prevPosX + (llllllllllllllIllllIIIllllllllIl.posX - llllllllllllllIllllIIIllllllllIl.prevPosX) * llllllllllllllIllllIIIlllllIlIIl);
            final double llllllllllllllIllllIIIllllllIlII = llllllllllllllIllllIIIllllllllIl.field_71096_bN + (llllllllllllllIllllIIIllllllllIl.field_71095_bQ - llllllllllllllIllllIIIllllllllIl.field_71096_bN) * llllllllllllllIllllIIIlllllIlIIl - (llllllllllllllIllllIIIllllllllIl.prevPosY + (llllllllllllllIllllIIIllllllllIl.posY - llllllllllllllIllllIIIllllllllIl.prevPosY) * llllllllllllllIllllIIIlllllIlIIl);
            final double llllllllllllllIllllIIIllllllIIll = llllllllllllllIllllIIIllllllllIl.field_71097_bO + (llllllllllllllIllllIIIllllllllIl.field_71085_bR - llllllllllllllIllllIIIllllllllIl.field_71097_bO) * llllllllllllllIllllIIIlllllIlIIl - (llllllllllllllIllllIIIllllllllIl.prevPosZ + (llllllllllllllIllllIIIllllllllIl.posZ - llllllllllllllIllllIIIllllllllIl.prevPosZ) * llllllllllllllIllllIIIlllllIlIIl);
            final float llllllllllllllIllllIIIllllllIIlI = llllllllllllllIllllIIIllllllllIl.prevRenderYawOffset + (llllllllllllllIllllIIIllllllllIl.renderYawOffset - llllllllllllllIllllIIIllllllllIl.prevRenderYawOffset) * llllllllllllllIllllIIIlllllIlIIl;
            final double llllllllllllllIllllIIIllllllIIIl = MathHelper.sin(llllllllllllllIllllIIIllllllIIlI * 3.1415927f / 180.0f);
            final double llllllllllllllIllllIIIllllllIIII = -MathHelper.cos(llllllllllllllIllllIIIllllllIIlI * 3.1415927f / 180.0f);
            float llllllllllllllIllllIIIlllllIllll = (float)llllllllllllllIllllIIIllllllIlII * 10.0f;
            llllllllllllllIllllIIIlllllIllll = MathHelper.clamp_float(llllllllllllllIllllIIIlllllIllll, -6.0f, 32.0f);
            float llllllllllllllIllllIIIlllllIlllI = (float)(llllllllllllllIllllIIIllllllIlIl * llllllllllllllIllllIIIllllllIIIl + llllllllllllllIllllIIIllllllIIll * llllllllllllllIllllIIIllllllIIII) * 100.0f;
            final float llllllllllllllIllllIIIlllllIllIl = (float)(llllllllllllllIllllIIIllllllIlIl * llllllllllllllIllllIIIllllllIIII - llllllllllllllIllllIIIllllllIIll * llllllllllllllIllllIIIllllllIIIl) * 100.0f;
            if (llllllllllllllIllllIIIlllllIlllI < 0.0f) {
                llllllllllllllIllllIIIlllllIlllI = 0.0f;
            }
            if (llllllllllllllIllllIIIlllllIlllI > 165.0f) {
                llllllllllllllIllllIIIlllllIlllI = 165.0f;
            }
            final float llllllllllllllIllllIIIlllllIllII = llllllllllllllIllllIIIllllllllIl.prevCameraYaw + (llllllllllllllIllllIIIllllllllIl.cameraYaw - llllllllllllllIllllIIIllllllllIl.prevCameraYaw) * llllllllllllllIllllIIIlllllIlIIl;
            llllllllllllllIllllIIIlllllIllll += MathHelper.sin((llllllllllllllIllllIIIllllllllIl.prevDistanceWalkedModified + (llllllllllllllIllllIIIllllllllIl.distanceWalkedModified - llllllllllllllIllllIIIllllllllIl.prevDistanceWalkedModified) * llllllllllllllIllllIIIlllllIlIIl) * 6.0f) * 32.0f * llllllllllllllIllllIIIlllllIllII;
            if (llllllllllllllIllllIIIllllllllIl.isSneaking()) {
                llllllllllllllIllllIIIlllllIllll += 25.0f;
                GlStateManager.translate(0.0f, 0.142f, -0.0178f);
            }
            GlStateManager.rotate(6.0f + llllllllllllllIllllIIIlllllIlllI / 2.0f + llllllllllllllIllllIIIlllllIllll, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(llllllllllllllIllllIIIlllllIllIl / 2.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(-llllllllllllllIllllIIIlllllIllIl / 2.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
            this.playerRenderer.func_177136_g().func_178728_c(0.0625f);
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIllllIIIllllIlIIll, final float llllllllllllllIllllIIIllllIlIIlI, final float llllllllllllllIllllIIIllllIlIIIl, final float llllllllllllllIllllIIIllllIIIlll, final float llllllllllllllIllllIIIllllIIllll, final float llllllllllllllIllllIIIllllIIlllI, final float llllllllllllllIllllIIIllllIIIlII, final float llllllllllllllIllllIIIllllIIllII) {
        this.doRenderLayer((AbstractClientPlayer)llllllllllllllIllllIIIllllIlIIll, llllllllllllllIllllIIIllllIlIIlI, llllllllllllllIllllIIIllllIlIIIl, llllllllllllllIllllIIIllllIIIlll, llllllllllllllIllllIIIllllIIllll, llllllllllllllIllllIIIllllIIlllI, llllllllllllllIllllIIIllllIIIlII, llllllllllllllIllllIIIllllIIllII);
    }
}
