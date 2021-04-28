package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class EntityLavaFX extends EntityFX
{
    private /* synthetic */ float lavaParticleScale;
    
    @Override
    public void func_180434_a(final WorldRenderer lllllllllllllllIIllIIlIIlIIIlIlI, final Entity lllllllllllllllIIllIIlIIlIIIlIIl, final float lllllllllllllllIIllIIlIIlIIIlIII, final float lllllllllllllllIIllIIlIIlIIlIIIl, final float lllllllllllllllIIllIIlIIlIIIIllI, final float lllllllllllllllIIllIIlIIlIIIllll, final float lllllllllllllllIIllIIlIIlIIIIlII, final float lllllllllllllllIIllIIlIIlIIIllIl) {
        final float lllllllllllllllIIllIIlIIlIIIllII = (this.particleAge + lllllllllllllllIIllIIlIIlIIIlIII) / this.particleMaxAge;
        this.particleScale = this.lavaParticleScale * (1.0f - lllllllllllllllIIllIIlIIlIIIllII * lllllllllllllllIIllIIlIIlIIIllII);
        super.func_180434_a(lllllllllllllllIIllIIlIIlIIIlIlI, lllllllllllllllIIllIIlIIlIIIlIIl, lllllllllllllllIIllIIlIIlIIIlIII, lllllllllllllllIIllIIlIIlIIlIIIl, lllllllllllllllIIllIIlIIlIIIIllI, lllllllllllllllIIllIIlIIlIIIllll, lllllllllllllllIIllIIlIIlIIIIlII, lllllllllllllllIIllIIlIIlIIIllIl);
    }
    
    protected EntityLavaFX(final World lllllllllllllllIIllIIlIIlIllIlll, final double lllllllllllllllIIllIIlIIlIllIllI, final double lllllllllllllllIIllIIlIIlIlllIlI, final double lllllllllllllllIIllIIlIIlIlllIIl) {
        super(lllllllllllllllIIllIIlIIlIllIlll, lllllllllllllllIIllIIlIIlIllIllI, lllllllllllllllIIllIIlIIlIlllIlI, lllllllllllllllIIllIIlIIlIlllIIl, 0.0, 0.0, 0.0);
        this.motionX *= 0.800000011920929;
        this.motionY *= 0.800000011920929;
        this.motionZ *= 0.800000011920929;
        this.motionY = this.rand.nextFloat() * 0.4f + 0.05f;
        final float particleRed = 1.0f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleScale *= this.rand.nextFloat() * 2.0f + 0.2f;
        this.lavaParticleScale = this.particleScale;
        this.particleMaxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.noClip = false;
        this.setParticleTextureIndex(49);
    }
    
    @Override
    public float getBrightness(final float lllllllllllllllIIllIIlIIlIlIIIII) {
        return 1.0f;
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllllIIllIIlIIlIlIllII) {
        float lllllllllllllllIIllIIlIIlIlIlIll = (this.particleAge + lllllllllllllllIIllIIlIIlIlIllII) / this.particleMaxAge;
        lllllllllllllllIIllIIlIIlIlIlIll = MathHelper.clamp_float(lllllllllllllllIIllIIlIIlIlIlIll, 0.0f, 1.0f);
        final int lllllllllllllllIIllIIlIIlIlIlIlI = super.getBrightnessForRender(lllllllllllllllIIllIIlIIlIlIllII);
        final short lllllllllllllllIIllIIlIIlIlIlIIl = 240;
        final int lllllllllllllllIIllIIlIIlIlIlIII = lllllllllllllllIIllIIlIIlIlIlIlI >> 16 & 0xFF;
        return lllllllllllllllIIllIIlIIlIlIlIIl | lllllllllllllllIIllIIlIIlIlIlIII << 16;
    }
    
    static {
        __OBFID = "CL_00000912";
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        final float lllllllllllllllIIllIIlIIIllllllI = this.particleAge / (float)this.particleMaxAge;
        if (this.rand.nextFloat() > lllllllllllllllIIllIIlIIIllllllI) {
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ, new int[0]);
        }
        this.motionY -= 0.03;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9990000128746033;
        this.motionY *= 0.9990000128746033;
        this.motionZ *= 0.9990000128746033;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIIIIIlIIIlIlIlIII, final World llllllllllllllIIIIIIlIIIlIIlllll, final double llllllllllllllIIIIIIlIIIlIIllllI, final double llllllllllllllIIIIIIlIIIlIlIIlIl, final double llllllllllllllIIIIIIlIIIlIlIIlII, final double llllllllllllllIIIIIIlIIIlIlIIIll, final double llllllllllllllIIIIIIlIIIlIlIIIlI, final double llllllllllllllIIIIIIlIIIlIlIIIIl, final int... llllllllllllllIIIIIIlIIIlIlIIIII) {
            return new EntityLavaFX(llllllllllllllIIIIIIlIIIlIIlllll, llllllllllllllIIIIIIlIIIlIIllllI, llllllllllllllIIIIIIlIIIlIlIIlIl, llllllllllllllIIIIIIlIIIlIlIIlII);
        }
        
        static {
            __OBFID = "CL_00002595";
        }
    }
}
