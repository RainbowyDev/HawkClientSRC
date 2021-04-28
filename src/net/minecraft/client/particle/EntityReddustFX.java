package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityReddustFX extends EntityFX
{
    /* synthetic */ float reddustParticleScale;
    
    protected EntityReddustFX(final World lllllllllllllllIIllIlIIlllIIlIII, final double lllllllllllllllIIllIlIIlllIIIlll, final double lllllllllllllllIIllIlIIllIllllII, final double lllllllllllllllIIllIlIIllIlllIll, final float lllllllllllllllIIllIlIIlllIIIlII, float lllllllllllllllIIllIlIIllIlllIIl, final float lllllllllllllllIIllIlIIllIlllIII, final float lllllllllllllllIIllIlIIllIllIlll) {
        super(lllllllllllllllIIllIlIIlllIIlIII, lllllllllllllllIIllIlIIlllIIIlll, lllllllllllllllIIllIlIIllIllllII, lllllllllllllllIIllIlIIllIlllIll, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        if (lllllllllllllllIIllIlIIllIlllIIl == 0.0f) {
            lllllllllllllllIIllIlIIllIlllIIl = 1.0f;
        }
        final float lllllllllllllllIIllIlIIlllIIIIII = (float)Math.random() * 0.4f + 0.6f;
        this.particleRed = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIllIlIIllIlllIIl * lllllllllllllllIIllIlIIlllIIIIII;
        this.particleGreen = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIllIlIIllIlllIII * lllllllllllllllIIllIlIIlllIIIIII;
        this.particleBlue = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIllIlIIllIllIlll * lllllllllllllllIIllIlIIlllIIIIII;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllllIIllIlIIlllIIIlII;
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)lllllllllllllllIIllIlIIlllIIIlII;
        this.noClip = false;
    }
    
    static {
        __OBFID = "CL_00000923";
    }
    
    @Override
    public void func_180434_a(final WorldRenderer lllllllllllllllIIllIlIIllIlIlIlI, final Entity lllllllllllllllIIllIlIIllIIlllll, final float lllllllllllllllIIllIlIIllIlIlIII, final float lllllllllllllllIIllIlIIllIlIIlll, final float lllllllllllllllIIllIlIIllIlIIllI, final float lllllllllllllllIIllIlIIllIIllIll, final float lllllllllllllllIIllIlIIllIIllIlI, final float lllllllllllllllIIllIlIIllIIllIIl) {
        float lllllllllllllllIIllIlIIllIlIIIlI = (this.particleAge + lllllllllllllllIIllIlIIllIlIlIII) / this.particleMaxAge * 32.0f;
        lllllllllllllllIIllIlIIllIlIIIlI = MathHelper.clamp_float(lllllllllllllllIIllIlIIllIlIIIlI, 0.0f, 1.0f);
        this.particleScale = this.reddustParticleScale * lllllllllllllllIIllIlIIllIlIIIlI;
        super.func_180434_a(lllllllllllllllIIllIlIIllIlIlIlI, lllllllllllllllIIllIlIIllIIlllll, lllllllllllllllIIllIlIIllIlIlIII, lllllllllllllllIIllIlIIllIlIIlll, lllllllllllllllIIllIlIIllIlIIllI, lllllllllllllllIIllIlIIllIIllIll, lllllllllllllllIIllIlIIllIIllIlI, lllllllllllllllIIllIlIIllIIllIIl);
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
    
    protected EntityReddustFX(final World lllllllllllllllIIllIlIIlllIllIlI, final double lllllllllllllllIIllIlIIlllIllIIl, final double lllllllllllllllIIllIlIIlllIllIII, final double lllllllllllllllIIllIlIIlllIlllll, final float lllllllllllllllIIllIlIIlllIlIllI, final float lllllllllllllllIIllIlIIlllIlIlIl, final float lllllllllllllllIIllIlIIlllIlIlII) {
        this(lllllllllllllllIIllIlIIlllIllIlI, lllllllllllllllIIllIlIIlllIllIIl, lllllllllllllllIIllIlIIlllIllIII, lllllllllllllllIIllIlIIlllIlllll, 1.0f, lllllllllllllllIIllIlIIlllIlIllI, lllllllllllllllIIllIlIIlllIlIlIl, lllllllllllllllIIllIlIIlllIlIlII);
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002589";
        }
        
        @Override
        public EntityFX func_178902_a(final int lllllllllllllllIIlIIIlllllIIlIlI, final World lllllllllllllllIIlIIIlllllIIlIIl, final double lllllllllllllllIIlIIIlllllIIIIII, final double lllllllllllllllIIlIIIlllllIIIlll, final double lllllllllllllllIIlIIIlllllIIIllI, final double lllllllllllllllIIlIIIlllllIIIlIl, final double lllllllllllllllIIlIIIllllIllllII, final double lllllllllllllllIIlIIIlllllIIIIll, final int... lllllllllllllllIIlIIIlllllIIIIlI) {
            return new EntityReddustFX(lllllllllllllllIIlIIIlllllIIlIIl, lllllllllllllllIIlIIIlllllIIIIII, lllllllllllllllIIlIIIlllllIIIlll, lllllllllllllllIIlIIIlllllIIIllI, (float)lllllllllllllllIIlIIIlllllIIIlIl, (float)lllllllllllllllIIlIIIllllIllllII, (float)lllllllllllllllIIlIIIlllllIIIIll);
        }
    }
}
