package net.minecraft.client.particle;

import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.monster.*;

public class MobAppearance extends EntityFX
{
    private /* synthetic */ EntityLivingBase field_174844_a;
    
    @Override
    public void func_180434_a(final WorldRenderer llIlllIlIIIIllI, final Entity llIlllIlIIIIlIl, final float llIlllIIlllIlll, final float llIlllIlIIIIIll, final float llIlllIlIIIIIlI, final float llIlllIlIIIIIIl, final float llIlllIlIIIIIII, final float llIlllIIlllllll) {
        if (this.field_174844_a != null) {
            final RenderManager llIlllIIllllllI = Minecraft.getMinecraft().getRenderManager();
            llIlllIIllllllI.func_178628_a(EntityFX.interpPosX, EntityFX.interpPosY, EntityFX.interpPosZ);
            final float llIlllIIlllllIl = 0.42553192f;
            final float llIlllIIlllllII = (this.particleAge + llIlllIIlllIlll) / this.particleMaxAge;
            GlStateManager.depthMask(true);
            GlStateManager.enableBlend();
            GlStateManager.enableDepth();
            GlStateManager.blendFunc(770, 771);
            final float llIlllIIllllIll = 240.0f;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llIlllIIllllIll, llIlllIIllllIll);
            GlStateManager.pushMatrix();
            final float llIlllIIllllIlI = 0.05f + 0.5f * MathHelper.sin(llIlllIIlllllII * 3.1415927f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, llIlllIIllllIlI);
            GlStateManager.translate(0.0f, 1.8f, 0.0f);
            GlStateManager.rotate(180.0f - llIlllIlIIIIlIl.rotationYaw, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(60.0f - 150.0f * llIlllIIlllllII - llIlllIlIIIIlIl.rotationPitch, 1.0f, 0.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.4f, -1.5f);
            GlStateManager.scale(llIlllIIlllllIl, llIlllIIlllllIl, llIlllIIlllllIl);
            final EntityLivingBase field_174844_a = this.field_174844_a;
            final EntityLivingBase field_174844_a2 = this.field_174844_a;
            final float n = 0.0f;
            field_174844_a2.prevRotationYaw = n;
            field_174844_a.rotationYaw = n;
            final EntityLivingBase field_174844_a3 = this.field_174844_a;
            final EntityLivingBase field_174844_a4 = this.field_174844_a;
            final float n2 = 0.0f;
            field_174844_a4.prevRotationYawHead = n2;
            field_174844_a3.rotationYawHead = n2;
            llIlllIIllllllI.renderEntityWithPosYaw(this.field_174844_a, 0.0, 0.0, 0.0, 0.0f, llIlllIIlllIlll);
            GlStateManager.popMatrix();
            GlStateManager.enableDepth();
        }
    }
    
    protected MobAppearance(final World llIlllIlIIllIlI, final double llIlllIlIIllIIl, final double llIlllIlIIllIII, final double llIlllIlIIlllII) {
        super(llIlllIlIIllIlI, llIlllIlIIllIIl, llIlllIlIIllIII, llIlllIlIIlllII, 0.0, 0.0, 0.0);
        final float particleRed = 1.0f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        final double motionX = 0.0;
        this.motionZ = motionX;
        this.motionY = motionX;
        this.motionX = motionX;
        this.particleGravity = 0.0f;
        this.particleMaxAge = 30;
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.field_174844_a == null) {
            final EntityGuardian llIlllIlIIlIIlI = new EntityGuardian(this.worldObj);
            llIlllIlIIlIIlI.func_175465_cm();
            this.field_174844_a = llIlllIlIIlIIlI;
        }
    }
    
    static {
        __OBFID = "CL_00002594";
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002593";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllllIllIIIlIlllllllI, final World llllllllllllllllIllIIIlIllllllIl, final double llllllllllllllllIllIIIlIllllllII, final double llllllllllllllllIllIIIlIlllllIll, final double llllllllllllllllIllIIIlIlllllIlI, final double llllllllllllllllIllIIIlIlllllIIl, final double llllllllllllllllIllIIIlIlllllIII, final double llllllllllllllllIllIIIlIllllIlll, final int... llllllllllllllllIllIIIlIllllIllI) {
            return new MobAppearance(llllllllllllllllIllIIIlIllllllIl, llllllllllllllllIllIIIlIllllllII, llllllllllllllllIllIIIlIlllllIll, llllllllllllllllIllIIIlIlllllIlI);
        }
    }
}
