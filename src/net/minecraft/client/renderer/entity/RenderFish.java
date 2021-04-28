package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class RenderFish extends Render
{
    private static final /* synthetic */ ResourceLocation field_110792_a;
    
    protected ResourceLocation getEntityTexture(final EntityFishHook lllllllllllllllIIIllIlIllIIlIIlI) {
        return RenderFish.field_110792_a;
    }
    
    static {
        __OBFID = "CL_00000996";
        field_110792_a = new ResourceLocation("textures/particle/particles.png");
    }
    
    public void func_180558_a(final EntityFishHook lllllllllllllllIIIllIlIllIlllIII, final double lllllllllllllllIIIllIlIllIllIlll, final double lllllllllllllllIIIllIlIlllIlllIl, final double lllllllllllllllIIIllIlIllIllIlIl, final float lllllllllllllllIIIllIlIlllIllIll, final float lllllllllllllllIIIllIlIlllIllIlI) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllIIIllIlIllIllIlll, (float)lllllllllllllllIIIllIlIlllIlllIl, (float)lllllllllllllllIIIllIlIllIllIlIl);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        this.bindEntityTexture(lllllllllllllllIIIllIlIllIlllIII);
        final Tessellator lllllllllllllllIIIllIlIlllIllIIl = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllIIIllIlIlllIllIII = lllllllllllllllIIIllIlIlllIllIIl.getWorldRenderer();
        final byte lllllllllllllllIIIllIlIlllIlIlll = 1;
        final byte lllllllllllllllIIIllIlIlllIlIllI = 2;
        final float lllllllllllllllIIIllIlIlllIlIlIl = (lllllllllllllllIIIllIlIlllIlIlll * 8 + 0) / 128.0f;
        final float lllllllllllllllIIIllIlIlllIlIlII = (lllllllllllllllIIIllIlIlllIlIlll * 8 + 8) / 128.0f;
        final float lllllllllllllllIIIllIlIlllIlIIll = (lllllllllllllllIIIllIlIlllIlIllI * 8 + 0) / 128.0f;
        final float lllllllllllllllIIIllIlIlllIlIIlI = (lllllllllllllllIIIllIlIlllIlIllI * 8 + 8) / 128.0f;
        final float lllllllllllllllIIIllIlIlllIlIIIl = 1.0f;
        final float lllllllllllllllIIIllIlIlllIlIIII = 0.5f;
        final float lllllllllllllllIIIllIlIlllIIllll = 0.5f;
        GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        lllllllllllllllIIIllIlIlllIllIII.startDrawingQuads();
        lllllllllllllllIIIllIlIlllIllIII.func_178980_d(0.0f, 1.0f, 0.0f);
        lllllllllllllllIIIllIlIlllIllIII.addVertexWithUV(0.0f - lllllllllllllllIIIllIlIlllIlIIII, 0.0f - lllllllllllllllIIIllIlIlllIIllll, 0.0, lllllllllllllllIIIllIlIlllIlIlIl, lllllllllllllllIIIllIlIlllIlIIlI);
        lllllllllllllllIIIllIlIlllIllIII.addVertexWithUV(lllllllllllllllIIIllIlIlllIlIIIl - lllllllllllllllIIIllIlIlllIlIIII, 0.0f - lllllllllllllllIIIllIlIlllIIllll, 0.0, lllllllllllllllIIIllIlIlllIlIlII, lllllllllllllllIIIllIlIlllIlIIlI);
        lllllllllllllllIIIllIlIlllIllIII.addVertexWithUV(lllllllllllllllIIIllIlIlllIlIIIl - lllllllllllllllIIIllIlIlllIlIIII, 1.0f - lllllllllllllllIIIllIlIlllIIllll, 0.0, lllllllllllllllIIIllIlIlllIlIlII, lllllllllllllllIIIllIlIlllIlIIll);
        lllllllllllllllIIIllIlIlllIllIII.addVertexWithUV(0.0f - lllllllllllllllIIIllIlIlllIlIIII, 1.0f - lllllllllllllllIIIllIlIlllIIllll, 0.0, lllllllllllllllIIIllIlIlllIlIlIl, lllllllllllllllIIIllIlIlllIlIIll);
        lllllllllllllllIIIllIlIlllIllIIl.draw();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        if (lllllllllllllllIIIllIlIllIlllIII.angler != null) {
            final float lllllllllllllllIIIllIlIlllIIlllI = lllllllllllllllIIIllIlIllIlllIII.angler.getSwingProgress(lllllllllllllllIIIllIlIlllIllIlI);
            final float lllllllllllllllIIIllIlIlllIIllIl = MathHelper.sin(MathHelper.sqrt_float(lllllllllllllllIIIllIlIlllIIlllI) * 3.1415927f);
            Vec3 lllllllllllllllIIIllIlIlllIIllII = new Vec3(-0.36, 0.03, 0.35);
            lllllllllllllllIIIllIlIlllIIllII = lllllllllllllllIIIllIlIlllIIllII.rotatePitch(-(lllllllllllllllIIIllIlIllIlllIII.angler.prevRotationPitch + (lllllllllllllllIIIllIlIllIlllIII.angler.rotationPitch - lllllllllllllllIIIllIlIllIlllIII.angler.prevRotationPitch) * lllllllllllllllIIIllIlIlllIllIlI) * 3.1415927f / 180.0f);
            lllllllllllllllIIIllIlIlllIIllII = lllllllllllllllIIIllIlIlllIIllII.rotateYaw(-(lllllllllllllllIIIllIlIllIlllIII.angler.prevRotationYaw + (lllllllllllllllIIIllIlIllIlllIII.angler.rotationYaw - lllllllllllllllIIIllIlIllIlllIII.angler.prevRotationYaw) * lllllllllllllllIIIllIlIlllIllIlI) * 3.1415927f / 180.0f);
            lllllllllllllllIIIllIlIlllIIllII = lllllllllllllllIIIllIlIlllIIllII.rotateYaw(lllllllllllllllIIIllIlIlllIIllIl * 0.5f);
            lllllllllllllllIIIllIlIlllIIllII = lllllllllllllllIIIllIlIlllIIllII.rotatePitch(-lllllllllllllllIIIllIlIlllIIllIl * 0.7f);
            double lllllllllllllllIIIllIlIlllIIlIll = lllllllllllllllIIIllIlIllIlllIII.angler.prevPosX + (lllllllllllllllIIIllIlIllIlllIII.angler.posX - lllllllllllllllIIIllIlIllIlllIII.angler.prevPosX) * lllllllllllllllIIIllIlIlllIllIlI + lllllllllllllllIIIllIlIlllIIllII.xCoord;
            double lllllllllllllllIIIllIlIlllIIlIlI = lllllllllllllllIIIllIlIllIlllIII.angler.prevPosY + (lllllllllllllllIIIllIlIllIlllIII.angler.posY - lllllllllllllllIIIllIlIllIlllIII.angler.prevPosY) * lllllllllllllllIIIllIlIlllIllIlI + lllllllllllllllIIIllIlIlllIIllII.yCoord;
            double lllllllllllllllIIIllIlIlllIIlIIl = lllllllllllllllIIIllIlIllIlllIII.angler.prevPosZ + (lllllllllllllllIIIllIlIllIlllIII.angler.posZ - lllllllllllllllIIIllIlIllIlllIII.angler.prevPosZ) * lllllllllllllllIIIllIlIlllIllIlI + lllllllllllllllIIIllIlIlllIIllII.zCoord;
            double lllllllllllllllIIIllIlIlllIIlIII = lllllllllllllllIIIllIlIllIlllIII.angler.getEyeHeight();
            if ((this.renderManager.options != null && this.renderManager.options.thirdPersonView > 0) || lllllllllllllllIIIllIlIllIlllIII.angler != Minecraft.getMinecraft().thePlayer) {
                final float lllllllllllllllIIIllIlIlllIIIlll = (lllllllllllllllIIIllIlIllIlllIII.angler.prevRenderYawOffset + (lllllllllllllllIIIllIlIllIlllIII.angler.renderYawOffset - lllllllllllllllIIIllIlIllIlllIII.angler.prevRenderYawOffset) * lllllllllllllllIIIllIlIlllIllIlI) * 3.1415927f / 180.0f;
                final double lllllllllllllllIIIllIlIlllIIIllI = MathHelper.sin(lllllllllllllllIIIllIlIlllIIIlll);
                final double lllllllllllllllIIIllIlIlllIIIlIl = MathHelper.cos(lllllllllllllllIIIllIlIlllIIIlll);
                final double lllllllllllllllIIIllIlIlllIIIlII = 0.35;
                final double lllllllllllllllIIIllIlIlllIIIIll = 0.8;
                lllllllllllllllIIIllIlIlllIIlIll = lllllllllllllllIIIllIlIllIlllIII.angler.prevPosX + (lllllllllllllllIIIllIlIllIlllIII.angler.posX - lllllllllllllllIIIllIlIllIlllIII.angler.prevPosX) * lllllllllllllllIIIllIlIlllIllIlI - lllllllllllllllIIIllIlIlllIIIlIl * 0.35 - lllllllllllllllIIIllIlIlllIIIllI * 0.8;
                lllllllllllllllIIIllIlIlllIIlIlI = lllllllllllllllIIIllIlIllIlllIII.angler.prevPosY + lllllllllllllllIIIllIlIlllIIlIII + (lllllllllllllllIIIllIlIllIlllIII.angler.posY - lllllllllllllllIIIllIlIllIlllIII.angler.prevPosY) * lllllllllllllllIIIllIlIlllIllIlI - 0.45;
                lllllllllllllllIIIllIlIlllIIlIIl = lllllllllllllllIIIllIlIllIlllIII.angler.prevPosZ + (lllllllllllllllIIIllIlIllIlllIII.angler.posZ - lllllllllllllllIIIllIlIllIlllIII.angler.prevPosZ) * lllllllllllllllIIIllIlIlllIllIlI - lllllllllllllllIIIllIlIlllIIIllI * 0.35 + lllllllllllllllIIIllIlIlllIIIlIl * 0.8;
                lllllllllllllllIIIllIlIlllIIlIII = (lllllllllllllllIIIllIlIllIlllIII.angler.isSneaking() ? -0.1875 : 0.0);
            }
            final double lllllllllllllllIIIllIlIlllIIIIlI = lllllllllllllllIIIllIlIllIlllIII.prevPosX + (lllllllllllllllIIIllIlIllIlllIII.posX - lllllllllllllllIIIllIlIllIlllIII.prevPosX) * lllllllllllllllIIIllIlIlllIllIlI;
            final double lllllllllllllllIIIllIlIlllIIIIIl = lllllllllllllllIIIllIlIllIlllIII.prevPosY + (lllllllllllllllIIIllIlIllIlllIII.posY - lllllllllllllllIIIllIlIllIlllIII.prevPosY) * lllllllllllllllIIIllIlIlllIllIlI + 0.25;
            final double lllllllllllllllIIIllIlIlllIIIIII = lllllllllllllllIIIllIlIllIlllIII.prevPosZ + (lllllllllllllllIIIllIlIllIlllIII.posZ - lllllllllllllllIIIllIlIllIlllIII.prevPosZ) * lllllllllllllllIIIllIlIlllIllIlI;
            final double lllllllllllllllIIIllIlIllIllllll = (float)(lllllllllllllllIIIllIlIlllIIlIll - lllllllllllllllIIIllIlIlllIIIIlI);
            final double lllllllllllllllIIIllIlIllIlllllI = (float)(lllllllllllllllIIIllIlIlllIIlIlI - lllllllllllllllIIIllIlIlllIIIIIl) + lllllllllllllllIIIllIlIlllIIlIII;
            final double lllllllllllllllIIIllIlIllIllllIl = (float)(lllllllllllllllIIIllIlIlllIIlIIl - lllllllllllllllIIIllIlIlllIIIIII);
            GlStateManager.func_179090_x();
            GlStateManager.disableLighting();
            lllllllllllllllIIIllIlIlllIllIII.startDrawing(3);
            lllllllllllllllIIIllIlIlllIllIII.func_178991_c(0);
            final byte lllllllllllllllIIIllIlIllIllllII = 16;
            for (int lllllllllllllllIIIllIlIllIlllIll = 0; lllllllllllllllIIIllIlIllIlllIll <= lllllllllllllllIIIllIlIllIllllII; ++lllllllllllllllIIIllIlIllIlllIll) {
                final float lllllllllllllllIIIllIlIllIlllIlI = lllllllllllllllIIIllIlIllIlllIll / (float)lllllllllllllllIIIllIlIllIllllII;
                lllllllllllllllIIIllIlIlllIllIII.addVertex(lllllllllllllllIIIllIlIllIllIlll + lllllllllllllllIIIllIlIllIllllll * lllllllllllllllIIIllIlIllIlllIlI, lllllllllllllllIIIllIlIlllIlllIl + lllllllllllllllIIIllIlIllIlllllI * (lllllllllllllllIIIllIlIllIlllIlI * lllllllllllllllIIIllIlIllIlllIlI + lllllllllllllllIIIllIlIllIlllIlI) * 0.5 + 0.25, lllllllllllllllIIIllIlIllIllIlIl + lllllllllllllllIIIllIlIllIllllIl * lllllllllllllllIIIllIlIllIlllIlI);
            }
            lllllllllllllllIIIllIlIlllIllIIl.draw();
            GlStateManager.enableLighting();
            GlStateManager.func_179098_w();
            super.doRender(lllllllllllllllIIIllIlIllIlllIII, lllllllllllllllIIIllIlIllIllIlll, lllllllllllllllIIIllIlIlllIlllIl, lllllllllllllllIIIllIlIllIllIlIl, lllllllllllllllIIIllIlIlllIllIll, lllllllllllllllIIIllIlIlllIllIlI);
        }
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIIIllIlIllIIIIIll, final double lllllllllllllllIIIllIlIlIllllIll, final double lllllllllllllllIIIllIlIlIllllIlI, final double lllllllllllllllIIIllIlIllIIIIIII, final float lllllllllllllllIIIllIlIlIlllllll, final float lllllllllllllllIIIllIlIlIlllIlll) {
        this.func_180558_a((EntityFishHook)lllllllllllllllIIIllIlIllIIIIIll, lllllllllllllllIIIllIlIlIllllIll, lllllllllllllllIIIllIlIlIllllIlI, lllllllllllllllIIIllIlIllIIIIIII, lllllllllllllllIIIllIlIlIlllllll, lllllllllllllllIIIllIlIlIlllIlll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIIllIlIllIIIllII) {
        return this.getEntityTexture((EntityFishHook)lllllllllllllllIIIllIlIllIIIllII);
    }
    
    public RenderFish(final RenderManager lllllllllllllllIIIllIllIIIIIIlll) {
        super(lllllllllllllllIIIllIllIIIIIIlll);
    }
}
