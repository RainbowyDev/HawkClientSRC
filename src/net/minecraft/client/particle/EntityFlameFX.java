package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityFlameFX extends EntityFX
{
    private /* synthetic */ float flameScale;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void func_180434_a(final WorldRenderer lllllllllllllllllIlIIlIlllIllIIl, final Entity lllllllllllllllllIlIIlIlllIllIII, final float lllllllllllllllllIlIIlIllllIIIIl, final float lllllllllllllllllIlIIlIlllIlIllI, final float lllllllllllllllllIlIIlIlllIlllll, final float lllllllllllllllllIlIIlIlllIlIlII, final float lllllllllllllllllIlIIlIlllIlllIl, final float lllllllllllllllllIlIIlIlllIlllII) {
        final float lllllllllllllllllIlIIlIlllIllIll = (this.particleAge + lllllllllllllllllIlIIlIllllIIIIl) / this.particleMaxAge;
        this.particleScale = this.flameScale * (1.0f - lllllllllllllllllIlIIlIlllIllIll * lllllllllllllllllIlIIlIlllIllIll * 0.5f);
        super.func_180434_a(lllllllllllllllllIlIIlIlllIllIIl, lllllllllllllllllIlIIlIlllIllIII, lllllllllllllllllIlIIlIllllIIIIl, lllllllllllllllllIlIIlIlllIlIllI, lllllllllllllllllIlIIlIlllIlllll, lllllllllllllllllIlIIlIlllIlIlII, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIlllIlllII);
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllllllIlIIlIlllIIIIll) {
        float lllllllllllllllllIlIIlIlllIIlIII = (this.particleAge + lllllllllllllllllIlIIlIlllIIIIll) / this.particleMaxAge;
        lllllllllllllllllIlIIlIlllIIlIII = MathHelper.clamp_float(lllllllllllllllllIlIIlIlllIIlIII, 0.0f, 1.0f);
        final int lllllllllllllllllIlIIlIlllIIIlll = super.getBrightnessForRender(lllllllllllllllllIlIIlIlllIIIIll);
        int lllllllllllllllllIlIIlIlllIIIllI = lllllllllllllllllIlIIlIlllIIIlll & 0xFF;
        final int lllllllllllllllllIlIIlIlllIIIlIl = lllllllllllllllllIlIIlIlllIIIlll >> 16 & 0xFF;
        lllllllllllllllllIlIIlIlllIIIllI += (int)(lllllllllllllllllIlIIlIlllIIlIII * 15.0f * 16.0f);
        if (lllllllllllllllllIlIIlIlllIIIllI > 240) {
            lllllllllllllllllIlIIlIlllIIIllI = 240;
        }
        return lllllllllllllllllIlIIlIlllIIIllI | lllllllllllllllllIlIIlIlllIIIlIl << 16;
    }
    
    @Override
    public float getBrightness(final float lllllllllllllllllIlIIlIllIlllIIl) {
        float lllllllllllllllllIlIIlIllIlllIII = (this.particleAge + lllllllllllllllllIlIIlIllIlllIIl) / this.particleMaxAge;
        lllllllllllllllllIlIIlIllIlllIII = MathHelper.clamp_float(lllllllllllllllllIlIIlIllIlllIII, 0.0f, 1.0f);
        final float lllllllllllllllllIlIIlIllIllIlll = super.getBrightness(lllllllllllllllllIlIIlIllIlllIIl);
        return lllllllllllllllllIlIIlIllIllIlll * lllllllllllllllllIlIIlIllIlllIII + (1.0f - lllllllllllllllllIlIIlIllIlllIII);
    }
    
    protected EntityFlameFX(final World lllllllllllllllllIlIIlIlllllIllI, final double lllllllllllllllllIlIIlIllllllllI, final double lllllllllllllllllIlIIlIlllllllIl, final double lllllllllllllllllIlIIlIlllllIIll, final double lllllllllllllllllIlIIlIlllllIIlI, final double lllllllllllllllllIlIIlIllllllIlI, final double lllllllllllllllllIlIIlIlllllIIII) {
        super(lllllllllllllllllIlIIlIlllllIllI, lllllllllllllllllIlIIlIllllllllI, lllllllllllllllllIlIIlIlllllllIl, lllllllllllllllllIlIIlIlllllIIll, lllllllllllllllllIlIIlIlllllIIlI, lllllllllllllllllIlIIlIllllllIlI, lllllllllllllllllIlIIlIlllllIIII);
        this.motionX = this.motionX * 0.009999999776482582 + lllllllllllllllllIlIIlIlllllIIlI;
        this.motionY = this.motionY * 0.009999999776482582 + lllllllllllllllllIlIIlIllllllIlI;
        this.motionZ = this.motionZ * 0.009999999776482582 + lllllllllllllllllIlIIlIlllllIIII;
        double lllllllllllllllllIlIIlIllllllIII = lllllllllllllllllIlIIlIllllllllI + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        lllllllllllllllllIlIIlIllllllIII = lllllllllllllllllIlIIlIlllllllIl + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        lllllllllllllllllIlIIlIllllllIII = lllllllllllllllllIlIIlIlllllIIll + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        this.flameScale = this.particleScale;
        final float particleRed = 1.0f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.noClip = true;
        this.setParticleTextureIndex(48);
    }
    
    static {
        __OBFID = "CL_00000907";
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIlIIIlIlllIIIIllI, final World llllllllllllllIIlIIIlIllIlllllIl, final double llllllllllllllIIlIIIlIlllIIIIlII, final double llllllllllllllIIlIIIlIllIllllIll, final double llllllllllllllIIlIIIlIlllIIIIIlI, final double llllllllllllllIIlIIIlIlllIIIIIIl, final double llllllllllllllIIlIIIlIllIllllIII, final double llllllllllllllIIlIIIlIllIlllIlll, final int... llllllllllllllIIlIIIlIllIllllllI) {
            return new EntityFlameFX(llllllllllllllIIlIIIlIllIlllllIl, llllllllllllllIIlIIIlIlllIIIIlII, llllllllllllllIIlIIIlIllIllllIll, llllllllllllllIIlIIIlIlllIIIIIlI, llllllllllllllIIlIIIlIlllIIIIIIl, llllllllllllllIIlIIIlIllIllllIII, llllllllllllllIIlIIIlIllIlllIlll);
        }
        
        static {
            __OBFID = "CL_00002602";
        }
    }
}
