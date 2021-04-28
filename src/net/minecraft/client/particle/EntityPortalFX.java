package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class EntityPortalFX extends EntityFX
{
    private /* synthetic */ double portalPosY;
    private /* synthetic */ float portalParticleScale;
    private /* synthetic */ double portalPosZ;
    private /* synthetic */ double portalPosX;
    
    @Override
    public float getBrightness(final float lllllllllllllIlllllllIlllIllIlIl) {
        final float lllllllllllllIlllllllIlllIllIlII = super.getBrightness(lllllllllllllIlllllllIlllIllIlIl);
        float lllllllllllllIlllllllIlllIllIIll = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllIlllllllIlllIllIIll *= lllllllllllllIlllllllIlllIllIIll * lllllllllllllIlllllllIlllIllIIll * lllllllllllllIlllllllIlllIllIIll;
        return lllllllllllllIlllllllIlllIllIlII * (1.0f - lllllllllllllIlllllllIlllIllIIll) + lllllllllllllIlllllllIlllIllIIll;
    }
    
    static {
        __OBFID = "CL_00000921";
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        final float lllllllllllllIlllllllIlllIlIlIIl;
        float lllllllllllllIlllllllIlllIlIlIlI = lllllllllllllIlllllllIlllIlIlIIl = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllIlllllllIlllIlIlIlI = -lllllllllllllIlllllllIlllIlIlIlI + lllllllllllllIlllllllIlllIlIlIlI * lllllllllllllIlllllllIlllIlIlIlI * 2.0f;
        lllllllllllllIlllllllIlllIlIlIlI = 1.0f - lllllllllllllIlllllllIlllIlIlIlI;
        this.posX = this.portalPosX + this.motionX * lllllllllllllIlllllllIlllIlIlIlI;
        this.posY = this.portalPosY + this.motionY * lllllllllllllIlllllllIlllIlIlIlI + (1.0f - lllllllllllllIlllllllIlllIlIlIIl);
        this.posZ = this.portalPosZ + this.motionZ * lllllllllllllIlllllllIlllIlIlIlI;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
    }
    
    @Override
    public void func_180434_a(final WorldRenderer lllllllllllllIlllllllIllllIlIlIl, final Entity lllllllllllllIlllllllIllllIlIlII, final float lllllllllllllIlllllllIllllIlIIll, final float lllllllllllllIlllllllIllllIlllII, final float lllllllllllllIlllllllIllllIlIIIl, final float lllllllllllllIlllllllIllllIllIlI, final float lllllllllllllIlllllllIllllIIllll, final float lllllllllllllIlllllllIllllIIlllI) {
        float lllllllllllllIlllllllIllllIlIlll = (this.particleAge + lllllllllllllIlllllllIllllIlIIll) / this.particleMaxAge;
        lllllllllllllIlllllllIllllIlIlll = 1.0f - lllllllllllllIlllllllIllllIlIlll;
        lllllllllllllIlllllllIllllIlIlll *= lllllllllllllIlllllllIllllIlIlll;
        lllllllllllllIlllllllIllllIlIlll = 1.0f - lllllllllllllIlllllllIllllIlIlll;
        this.particleScale = this.portalParticleScale * lllllllllllllIlllllllIllllIlIlll;
        super.func_180434_a(lllllllllllllIlllllllIllllIlIlIl, lllllllllllllIlllllllIllllIlIlII, lllllllllllllIlllllllIllllIlIIll, lllllllllllllIlllllllIllllIlllII, lllllllllllllIlllllllIllllIlIIIl, lllllllllllllIlllllllIllllIllIlI, lllllllllllllIlllllllIllllIIllll, lllllllllllllIlllllllIllllIIlllI);
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllIlllllllIlllIllllll) {
        final int lllllllllllllIlllllllIllllIIIlII = super.getBrightnessForRender(lllllllllllllIlllllllIlllIllllll);
        float lllllllllllllIlllllllIllllIIIIll = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllIlllllllIllllIIIIll *= lllllllllllllIlllllllIllllIIIIll;
        lllllllllllllIlllllllIllllIIIIll *= lllllllllllllIlllllllIllllIIIIll;
        final int lllllllllllllIlllllllIllllIIIIlI = lllllllllllllIlllllllIllllIIIlII & 0xFF;
        int lllllllllllllIlllllllIllllIIIIIl = lllllllllllllIlllllllIllllIIIlII >> 16 & 0xFF;
        lllllllllllllIlllllllIllllIIIIIl += (int)(lllllllllllllIlllllllIllllIIIIll * 15.0f * 16.0f);
        if (lllllllllllllIlllllllIllllIIIIIl > 240) {
            lllllllllllllIlllllllIllllIIIIIl = 240;
        }
        return lllllllllllllIlllllllIllllIIIIlI | lllllllllllllIlllllllIllllIIIIIl << 16;
    }
    
    protected EntityPortalFX(final World lllllllllllllIlllllllIlllllllIll, final double lllllllllllllIlllllllIlllllllIlI, final double lllllllllllllIlllllllIllllllIIII, final double lllllllllllllIlllllllIlllllllIII, final double lllllllllllllIlllllllIlllllIlllI, final double lllllllllllllIlllllllIlllllIllIl, final double lllllllllllllIlllllllIllllllIlIl) {
        super(lllllllllllllIlllllllIlllllllIll, lllllllllllllIlllllllIlllllllIlI, lllllllllllllIlllllllIllllllIIII, lllllllllllllIlllllllIlllllllIII, lllllllllllllIlllllllIlllllIlllI, lllllllllllllIlllllllIlllllIllIl, lllllllllllllIlllllllIllllllIlIl);
        this.motionX = lllllllllllllIlllllllIlllllIlllI;
        this.motionY = lllllllllllllIlllllllIlllllIllIl;
        this.motionZ = lllllllllllllIlllllllIllllllIlIl;
        this.posX = lllllllllllllIlllllllIlllllllIlI;
        this.portalPosX = lllllllllllllIlllllllIlllllllIlI;
        this.posY = lllllllllllllIlllllllIllllllIIII;
        this.portalPosY = lllllllllllllIlllllllIllllllIIII;
        this.posZ = lllllllllllllIlllllllIlllllllIII;
        this.portalPosZ = lllllllllllllIlllllllIlllllllIII;
        final float lllllllllllllIlllllllIllllllIlII = this.rand.nextFloat() * 0.6f + 0.4f;
        final float n = this.rand.nextFloat() * 0.2f + 0.5f;
        this.particleScale = n;
        this.portalParticleScale = n;
        final float particleRed = 1.0f * lllllllllllllIlllllllIllllllIlII;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleGreen *= 0.3f;
        this.particleRed *= 0.9f;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 40;
        this.noClip = true;
        this.setParticleTextureIndex((int)(Math.random() * 8.0));
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIllIIIIlIlIIIIlII, final World llllllllllllllIIllIIIIlIlIIIIIll, final double llllllllllllllIIllIIIIlIIllllIlI, final double llllllllllllllIIllIIIIlIIllllIIl, final double llllllllllllllIIllIIIIlIlIIIIIII, final double llllllllllllllIIllIIIIlIIlllIlll, final double llllllllllllllIIllIIIIlIIllllllI, final double llllllllllllllIIllIIIIlIIlllIlIl, final int... llllllllllllllIIllIIIIlIIlllllII) {
            return new EntityPortalFX(llllllllllllllIIllIIIIlIlIIIIIll, llllllllllllllIIllIIIIlIIllllIlI, llllllllllllllIIllIIIIlIIllllIIl, llllllllllllllIIllIIIIlIlIIIIIII, llllllllllllllIIllIIIIlIIlllIlll, llllllllllllllIIllIIIIlIIllllllI, llllllllllllllIIllIIIIlIIlllIlIl);
        }
        
        static {
            __OBFID = "CL_00002590";
        }
    }
}
