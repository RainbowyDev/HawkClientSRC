package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntitySmokeFX extends EntityFX
{
    /* synthetic */ float smokeParticleScale;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY += 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    EntitySmokeFX(final World llllllllllllllllIIlIlllIlIIlIIII, final double llllllllllllllllIIlIlllIlIIIllll, final double llllllllllllllllIIlIlllIlIIIlllI, final double llllllllllllllllIIlIlllIlIIIIlII, final double llllllllllllllllIIlIlllIlIIIIIll, final double llllllllllllllllIIlIlllIlIIIIIlI, final double llllllllllllllllIIlIlllIlIIIIIIl, final Object llllllllllllllllIIlIlllIlIIIlIIl) {
        this(llllllllllllllllIIlIlllIlIIlIIII, llllllllllllllllIIlIlllIlIIIllll, llllllllllllllllIIlIlllIlIIIlllI, llllllllllllllllIIlIlllIlIIIIlII, llllllllllllllllIIlIlllIlIIIIIll, llllllllllllllllIIlIlllIlIIIIIlI, llllllllllllllllIIlIlllIlIIIIIIl);
    }
    
    static {
        __OBFID = "CL_00000924";
    }
    
    protected EntitySmokeFX(final World llllllllllllllllIIlIlllIllIIIIlI, final double llllllllllllllllIIlIlllIllIIlIlI, final double llllllllllllllllIIlIlllIllIIlIIl, final double llllllllllllllllIIlIlllIlIllllll, final double llllllllllllllllIIlIlllIllIIIlll, final double llllllllllllllllIIlIlllIllIIIllI, final double llllllllllllllllIIlIlllIllIIIlIl, final float llllllllllllllllIIlIlllIlIlllIll) {
        super(llllllllllllllllIIlIlllIllIIIIlI, llllllllllllllllIIlIlllIllIIlIlI, llllllllllllllllIIlIlllIllIIlIIl, llllllllllllllllIIlIlllIlIllllll, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += llllllllllllllllIIlIlllIllIIIlll;
        this.motionY += llllllllllllllllIIlIlllIllIIIllI;
        this.motionZ += llllllllllllllllIIlIlllIllIIIlIl;
        final float particleRed = (float)(Math.random() * 0.30000001192092896);
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleScale *= 0.75f;
        this.particleScale *= llllllllllllllllIIlIlllIlIlllIll;
        this.smokeParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)llllllllllllllllIIlIlllIlIlllIll;
        this.noClip = false;
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllllIIlIlllIlIlIllll, final Entity llllllllllllllllIIlIlllIlIlIIlII, final float llllllllllllllllIIlIlllIlIlIIIll, final float llllllllllllllllIIlIlllIlIlIIIlI, final float llllllllllllllllIIlIlllIlIlIIIIl, final float llllllllllllllllIIlIlllIlIlIlIlI, final float llllllllllllllllIIlIlllIlIlIlIIl, final float llllllllllllllllIIlIlllIlIIllllI) {
        float llllllllllllllllIIlIlllIlIlIIlll = (this.particleAge + llllllllllllllllIIlIlllIlIlIIIll) / this.particleMaxAge * 32.0f;
        llllllllllllllllIIlIlllIlIlIIlll = MathHelper.clamp_float(llllllllllllllllIIlIlllIlIlIIlll, 0.0f, 1.0f);
        this.particleScale = this.smokeParticleScale * llllllllllllllllIIlIlllIlIlIIlll;
        super.func_180434_a(llllllllllllllllIIlIlllIlIlIllll, llllllllllllllllIIlIlllIlIlIIlII, llllllllllllllllIIlIlllIlIlIIIll, llllllllllllllllIIlIlllIlIlIIIlI, llllllllllllllllIIlIlllIlIlIIIIl, llllllllllllllllIIlIlllIlIlIlIlI, llllllllllllllllIIlIlllIlIlIlIIl, llllllllllllllllIIlIlllIlIIllllI);
    }
    
    private EntitySmokeFX(final World llllllllllllllllIIlIlllIlllIIlII, final double llllllllllllllllIIlIlllIllIllIll, final double llllllllllllllllIIlIlllIlllIIIlI, final double llllllllllllllllIIlIlllIlllIIIIl, final double llllllllllllllllIIlIlllIlllIIIII, final double llllllllllllllllIIlIlllIllIlllll, final double llllllllllllllllIIlIlllIllIlIllI) {
        this(llllllllllllllllIIlIlllIlllIIlII, llllllllllllllllIIlIlllIllIllIll, llllllllllllllllIIlIlllIlllIIIlI, llllllllllllllllIIlIlllIlllIIIIl, llllllllllllllllIIlIlllIlllIIIII, llllllllllllllllIIlIlllIllIlllll, llllllllllllllllIIlIlllIllIlIllI, 1.0f);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllllIllllIlIlIIIlIll, final World llllllllllllllllIllllIlIlIIIIIlI, final double llllllllllllllllIllllIlIlIIIIIIl, final double llllllllllllllllIllllIlIlIIIIIII, final double llllllllllllllllIllllIlIIlllllll, final double llllllllllllllllIllllIlIIllllllI, final double llllllllllllllllIllllIlIIlllllIl, final double llllllllllllllllIllllIlIlIIIIlII, final int... llllllllllllllllIllllIlIlIIIIIll) {
            return new EntitySmokeFX(llllllllllllllllIllllIlIlIIIIIlI, llllllllllllllllIllllIlIlIIIIIIl, llllllllllllllllIllllIlIlIIIIIII, llllllllllllllllIllllIlIIlllllll, llllllllllllllllIllllIlIIllllllI, llllllllllllllllIllllIlIIlllllIl, llllllllllllllllIllllIlIlIIIIlII, null);
        }
        
        static {
            __OBFID = "CL_00002587";
        }
    }
}
