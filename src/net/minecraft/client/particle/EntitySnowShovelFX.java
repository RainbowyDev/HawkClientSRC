package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntitySnowShovelFX extends EntityFX
{
    /* synthetic */ float snowDigParticleScale;
    
    protected EntitySnowShovelFX(final World llllllllllllllIlIIIlllllIllIllIl, final double llllllllllllllIlIIIlllllIllIllII, final double llllllllllllllIlIIIlllllIllIlIll, final double llllllllllllllIlIIIlllllIllIlIlI, final double llllllllllllllIlIIIlllllIllIlIIl, final double llllllllllllllIlIIIlllllIlllIIIl, final double llllllllllllllIlIIIlllllIllIllll) {
        this(llllllllllllllIlIIIlllllIllIllIl, llllllllllllllIlIIIlllllIllIllII, llllllllllllllIlIIIlllllIllIlIll, llllllllllllllIlIIIlllllIllIlIlI, llllllllllllllIlIIIlllllIllIlIIl, llllllllllllllIlIIIlllllIlllIIIl, llllllllllllllIlIIIlllllIllIllll, 1.0f);
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY -= 0.03;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9900000095367432;
        this.motionY *= 0.9900000095367432;
        this.motionZ *= 0.9900000095367432;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllIlIIIlllllIIlIIIll, final Entity llllllllllllllIlIIIlllllIIlIIIIl, final float llllllllllllllIlIIIlllllIIIlIIIl, final float llllllllllllllIlIIIlllllIIIIllll, final float llllllllllllllIlIIIlllllIIIIllIl, final float llllllllllllllIlIIIlllllIIIIlIll, final float llllllllllllllIlIIIlllllIIIllIIl, final float llllllllllllllIlIIIlllllIIIIIlll) {
        float llllllllllllllIlIIIlllllIIIlIlll = (this.particleAge + llllllllllllllIlIIIlllllIIIlIIIl) / this.particleMaxAge * 32.0f;
        llllllllllllllIlIIIlllllIIIlIlll = MathHelper.clamp_float(llllllllllllllIlIIIlllllIIIlIlll, 0.0f, 1.0f);
        this.particleScale = this.snowDigParticleScale * llllllllllllllIlIIIlllllIIIlIlll;
        super.func_180434_a(llllllllllllllIlIIIlllllIIlIIIll, llllllllllllllIlIIIlllllIIlIIIIl, llllllllllllllIlIIIlllllIIIlIIIl, llllllllllllllIlIIIlllllIIIIllll, llllllllllllllIlIIIlllllIIIIllIl, llllllllllllllIlIIIlllllIIIIlIll, llllllllllllllIlIIIlllllIIIllIIl, llllllllllllllIlIIIlllllIIIIIlll);
    }
    
    protected EntitySnowShovelFX(final World llllllllllllllIlIIIlllllIlIllIII, final double llllllllllllllIlIIIlllllIlIlIllI, final double llllllllllllllIlIIIlllllIlIIIIlI, final double llllllllllllllIlIIIlllllIlIIIIII, final double llllllllllllllIlIIIlllllIlIlIIII, final double llllllllllllllIlIIIlllllIlIIlllI, final double llllllllllllllIlIIIlllllIlIIllII, final float llllllllllllllIlIIIlllllIIlllIIl) {
        super(llllllllllllllIlIIIlllllIlIllIII, llllllllllllllIlIIIlllllIlIlIllI, llllllllllllllIlIIIlllllIlIIIIlI, llllllllllllllIlIIIlllllIlIIIIII, llllllllllllllIlIIIlllllIlIlIIII, llllllllllllllIlIIIlllllIlIIlllI, llllllllllllllIlIIIlllllIlIIllII);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += llllllllllllllIlIIIlllllIlIlIIII;
        this.motionY += llllllllllllllIlIIIlllllIlIIlllI;
        this.motionZ += llllllllllllllIlIIIlllllIlIIllII;
        final float particleRed = 1.0f - (float)(Math.random() * 0.30000001192092896);
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleScale *= 0.75f;
        this.particleScale *= llllllllllllllIlIIIlllllIIlllIIl;
        this.snowDigParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)llllllllllllllIlIIIlllllIIlllIIl;
        this.noClip = false;
    }
    
    static {
        __OBFID = "CL_00000925";
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002586";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIIIIlIllIlIllIlII, final World llllllllllllllIIIIIlIllIlIllIIll, final double llllllllllllllIIIIIlIllIlIllIIlI, final double llllllllllllllIIIIIlIllIlIllIIIl, final double llllllllllllllIIIIIlIllIlIllIIII, final double llllllllllllllIIIIIlIllIlIlIllll, final double llllllllllllllIIIIIlIllIlIlIIllI, final double llllllllllllllIIIIIlIllIlIlIllIl, final int... llllllllllllllIIIIIlIllIlIlIllII) {
            return new EntitySnowShovelFX(llllllllllllllIIIIIlIllIlIllIIll, llllllllllllllIIIIIlIllIlIllIIlI, llllllllllllllIIIIIlIllIlIllIIIl, llllllllllllllIIIIIlIllIlIllIIII, llllllllllllllIIIIIlIllIlIlIllll, llllllllllllllIIIIIlIllIlIlIIllI, llllllllllllllIIIIIlIllIlIlIllIl);
        }
    }
}
