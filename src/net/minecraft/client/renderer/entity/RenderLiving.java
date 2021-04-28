package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.culling.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public abstract class RenderLiving extends RendererLivingEntity
{
    public boolean func_177104_a(final EntityLiving llllllllllllllIlllllIllIIIlIIIII, final ICamera llllllllllllllIlllllIllIIIIlllll, final double llllllllllllllIlllllIllIIIIlIlll, final double llllllllllllllIlllllIllIIIIlIllI, final double llllllllllllllIlllllIllIIIIlIlIl) {
        if (super.func_177071_a(llllllllllllllIlllllIllIIIlIIIII, llllllllllllllIlllllIllIIIIlllll, llllllllllllllIlllllIllIIIIlIlll, llllllllllllllIlllllIllIIIIlIllI, llllllllllllllIlllllIllIIIIlIlIl)) {
            return true;
        }
        if (llllllllllllllIlllllIllIIIlIIIII.getLeashed() && llllllllllllllIlllllIllIIIlIIIII.getLeashedToEntity() != null) {
            final Entity llllllllllllllIlllllIllIIIIllIll = llllllllllllllIlllllIllIIIlIIIII.getLeashedToEntity();
            return llllllllllllllIlllllIllIIIIlllll.isBoundingBoxInFrustum(llllllllllllllIlllllIllIIIIllIll.getEntityBoundingBox());
        }
        return false;
    }
    
    public void func_177105_a(final EntityLiving llllllllllllllIlllllIlIlllllIIll, final float llllllllllllllIlllllIlIlllllIlll) {
        final int llllllllllllllIlllllIlIlllllIllI = llllllllllllllIlllllIlIlllllIIll.getBrightnessForRender(llllllllllllllIlllllIlIlllllIlll);
        final int llllllllllllllIlllllIlIlllllIlIl = llllllllllllllIlllllIlIlllllIllI % 65536;
        final int llllllllllllllIlllllIlIlllllIlII = llllllllllllllIlllllIlIlllllIllI / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllIlllllIlIlllllIlIl / 1.0f, llllllllllllllIlllllIlIlllllIlII / 1.0f);
    }
    
    @Override
    protected boolean func_177070_b(final Entity llllllllllllllIlllllIlIlIllIlIll) {
        return this.canRenderName((EntityLiving)llllllllllllllIlllllIlIlIllIlIll);
    }
    
    protected void func_110827_b(final EntityLiving llllllllllllllIlllllIlIllIlIIlll, double llllllllllllllIlllllIlIllIlIIllI, double llllllllllllllIlllllIlIllIlIIlIl, double llllllllllllllIlllllIlIlllIIIIll, final float llllllllllllllIlllllIlIlllIIIIlI, final float llllllllllllllIlllllIlIlllIIIIIl) {
        if (!Config.isShaders() || !Shaders.isShadowPass) {
            final Entity llllllllllllllIlllllIlIlllIIIIII = llllllllllllllIlllllIlIllIlIIlll.getLeashedToEntity();
            if (llllllllllllllIlllllIlIlllIIIIII != null) {
                llllllllllllllIlllllIlIllIlIIlIl -= (byte)((1.6 - llllllllllllllIlllllIlIllIlIIlll.height) * 0.5);
                final Tessellator llllllllllllllIlllllIlIllIllllll = Tessellator.getInstance();
                final WorldRenderer llllllllllllllIlllllIlIllIlllllI = llllllllllllllIlllllIlIllIllllll.getWorldRenderer();
                final double llllllllllllllIlllllIlIllIllllIl = this.func_110828_a(llllllllllllllIlllllIlIlllIIIIII.prevRotationYaw, llllllllllllllIlllllIlIlllIIIIII.rotationYaw, llllllllllllllIlllllIlIlllIIIIIl * 0.5f) * 0.01745329238474369;
                final double llllllllllllllIlllllIlIllIllllII = this.func_110828_a(llllllllllllllIlllllIlIlllIIIIII.prevRotationPitch, llllllllllllllIlllllIlIlllIIIIII.rotationPitch, llllllllllllllIlllllIlIlllIIIIIl * 0.5f) * 0.01745329238474369;
                double llllllllllllllIlllllIlIllIlllIll = Math.cos(llllllllllllllIlllllIlIllIllllIl);
                double llllllllllllllIlllllIlIllIlllIlI = Math.sin(llllllllllllllIlllllIlIllIllllIl);
                double llllllllllllllIlllllIlIllIlllIIl = Math.sin(llllllllllllllIlllllIlIllIllllII);
                if (llllllllllllllIlllllIlIlllIIIIII instanceof EntityHanging) {
                    llllllllllllllIlllllIlIllIlllIll = 0.0;
                    llllllllllllllIlllllIlIllIlllIlI = 0.0;
                    llllllllllllllIlllllIlIllIlllIIl = -1.0;
                }
                final double llllllllllllllIlllllIlIllIlllIII = Math.cos(llllllllllllllIlllllIlIllIllllII);
                final double llllllllllllllIlllllIlIllIllIlll = this.func_110828_a(llllllllllllllIlllllIlIlllIIIIII.prevPosX, llllllllllllllIlllllIlIlllIIIIII.posX, llllllllllllllIlllllIlIlllIIIIIl) - llllllllllllllIlllllIlIllIlllIll * 0.7 - llllllllllllllIlllllIlIllIlllIlI * 0.5 * llllllllllllllIlllllIlIllIlllIII;
                final double llllllllllllllIlllllIlIllIllIllI = this.func_110828_a(llllllllllllllIlllllIlIlllIIIIII.prevPosY + llllllllllllllIlllllIlIlllIIIIII.getEyeHeight() * 0.7, llllllllllllllIlllllIlIlllIIIIII.posY + llllllllllllllIlllllIlIlllIIIIII.getEyeHeight() * 0.7, llllllllllllllIlllllIlIlllIIIIIl) - llllllllllllllIlllllIlIllIlllIIl * 0.5 - 0.25;
                final double llllllllllllllIlllllIlIllIllIlIl = this.func_110828_a(llllllllllllllIlllllIlIlllIIIIII.prevPosZ, llllllllllllllIlllllIlIlllIIIIII.posZ, llllllllllllllIlllllIlIlllIIIIIl) - llllllllllllllIlllllIlIllIlllIlI * 0.7 + llllllllllllllIlllllIlIllIlllIll * 0.5 * llllllllllllllIlllllIlIllIlllIII;
                final double llllllllllllllIlllllIlIllIllIlII = this.func_110828_a(llllllllllllllIlllllIlIllIlIIlll.prevRenderYawOffset, llllllllllllllIlllllIlIllIlIIlll.renderYawOffset, llllllllllllllIlllllIlIlllIIIIIl) * 0.01745329238474369 + 1.5707963267948966;
                llllllllllllllIlllllIlIllIlllIll = Math.cos(llllllllllllllIlllllIlIllIllIlII) * llllllllllllllIlllllIlIllIlIIlll.width * 0.4;
                llllllllllllllIlllllIlIllIlllIlI = Math.sin(llllllllllllllIlllllIlIllIllIlII) * llllllllllllllIlllllIlIllIlIIlll.width * 0.4;
                final double llllllllllllllIlllllIlIllIllIIll = this.func_110828_a(llllllllllllllIlllllIlIllIlIIlll.prevPosX, llllllllllllllIlllllIlIllIlIIlll.posX, llllllllllllllIlllllIlIlllIIIIIl) + llllllllllllllIlllllIlIllIlllIll;
                final double llllllllllllllIlllllIlIllIllIIlI = this.func_110828_a(llllllllllllllIlllllIlIllIlIIlll.prevPosY, llllllllllllllIlllllIlIllIlIIlll.posY, llllllllllllllIlllllIlIlllIIIIIl);
                final double llllllllllllllIlllllIlIllIllIIIl = this.func_110828_a(llllllllllllllIlllllIlIllIlIIlll.prevPosZ, llllllllllllllIlllllIlIllIlIIlll.posZ, llllllllllllllIlllllIlIlllIIIIIl) + llllllllllllllIlllllIlIllIlllIlI;
                llllllllllllllIlllllIlIllIlIIllI += llllllllllllllIlllllIlIllIlllIll;
                llllllllllllllIlllllIlIlllIIIIll += llllllllllllllIlllllIlIllIlllIlI;
                final double llllllllllllllIlllllIlIllIllIIII = (float)(llllllllllllllIlllllIlIllIllIlll - llllllllllllllIlllllIlIllIllIIll);
                final double llllllllllllllIlllllIlIllIlIllll = (float)(llllllllllllllIlllllIlIllIllIllI - llllllllllllllIlllllIlIllIllIIlI);
                final double llllllllllllllIlllllIlIllIlIlllI = (float)(llllllllllllllIlllllIlIllIllIlIl - llllllllllllllIlllllIlIllIllIIIl);
                GlStateManager.func_179090_x();
                GlStateManager.disableLighting();
                GlStateManager.disableCull();
                if (Config.isShaders()) {
                    Shaders.beginLeash();
                }
                final boolean llllllllllllllIlllllIlIllIlIllIl = true;
                final double llllllllllllllIlllllIlIllIlIllII = 0.025;
                llllllllllllllIlllllIlIllIlllllI.startDrawing(5);
                for (int llllllllllllllIlllllIlIllIlIlIll = 0; llllllllllllllIlllllIlIllIlIlIll <= 24; ++llllllllllllllIlllllIlIllIlIlIll) {
                    if (llllllllllllllIlllllIlIllIlIlIll % 2 == 0) {
                        llllllllllllllIlllllIlIllIlllllI.func_178960_a(0.5f, 0.4f, 0.3f, 1.0f);
                    }
                    else {
                        llllllllllllllIlllllIlIllIlllllI.func_178960_a(0.35f, 0.28f, 0.21000001f, 1.0f);
                    }
                    final float llllllllllllllIlllllIlIllIlIlIlI = llllllllllllllIlllllIlIllIlIlIll / 24.0f;
                    llllllllllllllIlllllIlIllIlllllI.addVertex(llllllllllllllIlllllIlIllIlIIllI + llllllllllllllIlllllIlIllIllIIII * llllllllllllllIlllllIlIllIlIlIlI + 0.0, llllllllllllllIlllllIlIllIlIIlIl + llllllllllllllIlllllIlIllIlIllll * (llllllllllllllIlllllIlIllIlIlIlI * llllllllllllllIlllllIlIllIlIlIlI + llllllllllllllIlllllIlIllIlIlIlI) * 0.5 + ((24.0f - llllllllllllllIlllllIlIllIlIlIll) / 18.0f + 0.125f), llllllllllllllIlllllIlIlllIIIIll + llllllllllllllIlllllIlIllIlIlllI * llllllllllllllIlllllIlIllIlIlIlI);
                    llllllllllllllIlllllIlIllIlllllI.addVertex(llllllllllllllIlllllIlIllIlIIllI + llllllllllllllIlllllIlIllIllIIII * llllllllllllllIlllllIlIllIlIlIlI + 0.025, llllllllllllllIlllllIlIllIlIIlIl + llllllllllllllIlllllIlIllIlIllll * (llllllllllllllIlllllIlIllIlIlIlI * llllllllllllllIlllllIlIllIlIlIlI + llllllllllllllIlllllIlIllIlIlIlI) * 0.5 + ((24.0f - llllllllllllllIlllllIlIllIlIlIll) / 18.0f + 0.125f) + 0.025, llllllllllllllIlllllIlIlllIIIIll + llllllllllllllIlllllIlIllIlIlllI * llllllllllllllIlllllIlIllIlIlIlI);
                }
                llllllllllllllIlllllIlIllIllllll.draw();
                llllllllllllllIlllllIlIllIlllllI.startDrawing(5);
                for (int llllllllllllllIlllllIlIllIlIlIll = 0; llllllllllllllIlllllIlIllIlIlIll <= 24; ++llllllllllllllIlllllIlIllIlIlIll) {
                    if (llllllllllllllIlllllIlIllIlIlIll % 2 == 0) {
                        llllllllllllllIlllllIlIllIlllllI.func_178960_a(0.5f, 0.4f, 0.3f, 1.0f);
                    }
                    else {
                        llllllllllllllIlllllIlIllIlllllI.func_178960_a(0.35f, 0.28f, 0.21000001f, 1.0f);
                    }
                    final float llllllllllllllIlllllIlIllIlIlIIl = llllllllllllllIlllllIlIllIlIlIll / 24.0f;
                    llllllllllllllIlllllIlIllIlllllI.addVertex(llllllllllllllIlllllIlIllIlIIllI + llllllllllllllIlllllIlIllIllIIII * llllllllllllllIlllllIlIllIlIlIIl + 0.0, llllllllllllllIlllllIlIllIlIIlIl + llllllllllllllIlllllIlIllIlIllll * (llllllllllllllIlllllIlIllIlIlIIl * llllllllllllllIlllllIlIllIlIlIIl + llllllllllllllIlllllIlIllIlIlIIl) * 0.5 + ((24.0f - llllllllllllllIlllllIlIllIlIlIll) / 18.0f + 0.125f) + 0.025, llllllllllllllIlllllIlIlllIIIIll + llllllllllllllIlllllIlIllIlIlllI * llllllllllllllIlllllIlIllIlIlIIl);
                    llllllllllllllIlllllIlIllIlllllI.addVertex(llllllllllllllIlllllIlIllIlIIllI + llllllllllllllIlllllIlIllIllIIII * llllllllllllllIlllllIlIllIlIlIIl + 0.025, llllllllllllllIlllllIlIllIlIIlIl + llllllllllllllIlllllIlIllIlIllll * (llllllllllllllIlllllIlIllIlIlIIl * llllllllllllllIlllllIlIllIlIlIIl + llllllllllllllIlllllIlIllIlIlIIl) * 0.5 + ((24.0f - llllllllllllllIlllllIlIllIlIlIll) / 18.0f + 0.125f), llllllllllllllIlllllIlIlllIIIIll + llllllllllllllIlllllIlIllIlIlllI * llllllllllllllIlllllIlIllIlIlIIl + 0.025);
                }
                llllllllllllllIlllllIlIllIllllll.draw();
                if (Config.isShaders()) {
                    Shaders.endLeash();
                }
                GlStateManager.enableLighting();
                GlStateManager.func_179098_w();
                GlStateManager.enableCull();
            }
        }
    }
    
    public RenderLiving(final RenderManager llllllllllllllIlllllIllIIIllIlIl, final ModelBase llllllllllllllIlllllIllIIIllIIII, final float llllllllllllllIlllllIllIIIlIllll) {
        super(llllllllllllllIlllllIllIIIllIlIl, llllllllllllllIlllllIllIIIllIIII, llllllllllllllIlllllIllIIIlIllll);
    }
    
    protected boolean canRenderName(final EntityLiving llllllllllllllIlllllIllIIIlIlIll) {
        return super.canRenderName(llllllllllllllIlllllIllIIIlIlIll) && (llllllllllllllIlllllIllIIIlIlIll.getAlwaysRenderNameTagForRender() || (llllllllllllllIlllllIllIIIlIlIll.hasCustomName() && llllllllllllllIlllllIllIIIlIlIll == this.renderManager.field_147941_i));
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIlllllIlIlIlIllIll, final double llllllllllllllIlllllIlIlIlIllIlI, final double llllllllllllllIlllllIlIlIllIIIII, final double llllllllllllllIlllllIlIlIlIlllll, final float llllllllllllllIlllllIlIlIlIlIlll, final float llllllllllllllIlllllIlIlIlIlIllI) {
        this.doRender((EntityLiving)llllllllllllllIlllllIlIlIlIllIll, llllllllllllllIlllllIlIlIlIllIlI, llllllllllllllIlllllIlIlIllIIIII, llllllllllllllIlllllIlIlIlIlllll, llllllllllllllIlllllIlIlIlIlIlll, llllllllllllllIlllllIlIlIlIlIllI);
    }
    
    @Override
    public boolean func_177071_a(final Entity llllllllllllllIlllllIlIlIlIIlllI, final ICamera llllllllllllllIlllllIlIlIlIIllIl, final double llllllllllllllIlllllIlIlIlIIIllI, final double llllllllllllllIlllllIlIlIlIIIlIl, final double llllllllllllllIlllllIlIlIlIIlIlI) {
        return this.func_177104_a((EntityLiving)llllllllllllllIlllllIlIlIlIIlllI, llllllllllllllIlllllIlIlIlIIllIl, llllllllllllllIlllllIlIlIlIIIllI, llllllllllllllIlllllIlIlIlIIIlIl, llllllllllllllIlllllIlIlIlIIlIlI);
    }
    
    @Override
    public void doRender(final EntityLivingBase llllllllllllllIlllllIlIlIlllIllI, final double llllllllllllllIlllllIlIlIlllllII, final double llllllllllllllIlllllIlIlIlllIlII, final double llllllllllllllIlllllIlIlIlllIIll, final float llllllllllllllIlllllIlIlIllllIIl, final float llllllllllllllIlllllIlIlIlllIIIl) {
        this.doRender((EntityLiving)llllllllllllllIlllllIlIlIlllIllI, llllllllllllllIlllllIlIlIlllllII, llllllllllllllIlllllIlIlIlllIlII, llllllllllllllIlllllIlIlIlllIIll, llllllllllllllIlllllIlIlIllllIIl, llllllllllllllIlllllIlIlIlllIIIl);
    }
    
    @Override
    protected boolean canRenderName(final EntityLivingBase llllllllllllllIlllllIlIllIIIIllI) {
        return this.canRenderName((EntityLiving)llllllllllllllIlllllIlIllIIIIllI);
    }
    
    public void doRender(final EntityLiving llllllllllllllIlllllIllIIIIIlIll, final double llllllllllllllIlllllIllIIIIIlIlI, final double llllllllllllllIlllllIllIIIIIlIIl, final double llllllllllllllIlllllIllIIIIIlIII, final float llllllllllllllIlllllIllIIIIIIlll, final float llllllllllllllIlllllIllIIIIIIllI) {
        super.doRender(llllllllllllllIlllllIllIIIIIlIll, llllllllllllllIlllllIllIIIIIlIlI, llllllllllllllIlllllIllIIIIIlIIl, llllllllllllllIlllllIllIIIIIlIII, llllllllllllllIlllllIllIIIIIIlll, llllllllllllllIlllllIllIIIIIIllI);
        this.func_110827_b(llllllllllllllIlllllIllIIIIIlIll, llllllllllllllIlllllIllIIIIIlIlI, llllllllllllllIlllllIllIIIIIlIIl, llllllllllllllIlllllIllIIIIIlIII, llllllllllllllIlllllIllIIIIIIlll, llllllllllllllIlllllIllIIIIIIllI);
    }
    
    private double func_110828_a(final double llllllllllllllIlllllIlIllllIlIlI, final double llllllllllllllIlllllIlIllllIIllI, final double llllllllllllllIlllllIlIllllIIlIl) {
        return llllllllllllllIlllllIlIllllIlIlI + (llllllllllllllIlllllIlIllllIIllI - llllllllllllllIlllllIlIllllIlIlI) * llllllllllllllIlllllIlIllllIIlIl;
    }
    
    static {
        __OBFID = "CL_00001015";
    }
}
