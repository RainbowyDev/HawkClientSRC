package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityNoteFX extends EntityFX
{
    /* synthetic */ float noteParticleScale;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.6600000262260437;
        this.motionY *= 0.6600000262260437;
        this.motionZ *= 0.6600000262260437;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllIllllllIllIlllIIIl, final Entity llllllllllllllIllllllIllIllllIlI, final float llllllllllllllIllllllIllIllIllll, final float llllllllllllllIllllllIllIllllIII, final float llllllllllllllIllllllIllIlllIlll, final float llllllllllllllIllllllIllIllIllII, final float llllllllllllllIllllllIllIlllIlIl, final float llllllllllllllIllllllIllIlllIlII) {
        float llllllllllllllIllllllIllIlllIIll = (this.particleAge + llllllllllllllIllllllIllIllIllll) / this.particleMaxAge * 32.0f;
        llllllllllllllIllllllIllIlllIIll = MathHelper.clamp_float(llllllllllllllIllllllIllIlllIIll, 0.0f, 1.0f);
        this.particleScale = this.noteParticleScale * llllllllllllllIllllllIllIlllIIll;
        super.func_180434_a(llllllllllllllIllllllIllIlllIIIl, llllllllllllllIllllllIllIllllIlI, llllllllllllllIllllllIllIllIllll, llllllllllllllIllllllIllIllllIII, llllllllllllllIllllllIllIlllIlll, llllllllllllllIllllllIllIllIllII, llllllllllllllIllllllIllIlllIlIl, llllllllllllllIllllllIllIlllIlII);
    }
    
    static {
        __OBFID = "CL_00000913";
    }
    
    protected EntityNoteFX(final World llllllllllllllIllllllIlllIlIIlII, final double llllllllllllllIllllllIlllIlIIIll, final double llllllllllllllIllllllIlllIlIlIlI, final double llllllllllllllIllllllIlllIlIIIIl, final double llllllllllllllIllllllIlllIlIIIII, final double llllllllllllllIllllllIlllIIlllll, final double llllllllllllllIllllllIlllIlIIllI) {
        this(llllllllllllllIllllllIlllIlIIlII, llllllllllllllIllllllIlllIlIIIll, llllllllllllllIllllllIlllIlIlIlI, llllllllllllllIllllllIlllIlIIIIl, llllllllllllllIllllllIlllIlIIIII, llllllllllllllIllllllIlllIIlllll, llllllllllllllIllllllIlllIlIIllI, 2.0f);
    }
    
    protected EntityNoteFX(final World llllllllllllllIllllllIlllIIIllII, final double llllllllllllllIllllllIlllIIlIlII, final double llllllllllllllIllllllIlllIIIlIlI, final double llllllllllllllIllllllIlllIIIlIIl, final double llllllllllllllIllllllIlllIIlIIIl, final double llllllllllllllIllllllIlllIIlIIII, final double llllllllllllllIllllllIlllIIIllll, final float llllllllllllllIllllllIlllIIIIlll) {
        super(llllllllllllllIllllllIlllIIIllII, llllllllllllllIllllllIlllIIlIlII, llllllllllllllIllllllIlllIIIlIlI, llllllllllllllIllllllIlllIIIlIIl, 0.0, 0.0, 0.0);
        this.motionX *= 0.009999999776482582;
        this.motionY *= 0.009999999776482582;
        this.motionZ *= 0.009999999776482582;
        this.motionY += 0.2;
        this.particleRed = MathHelper.sin(((float)llllllllllllllIllllllIlllIIlIIIl + 0.0f) * 3.1415927f * 2.0f) * 0.65f + 0.35f;
        this.particleGreen = MathHelper.sin(((float)llllllllllllllIllllllIlllIIlIIIl + 0.33333334f) * 3.1415927f * 2.0f) * 0.65f + 0.35f;
        this.particleBlue = MathHelper.sin(((float)llllllllllllllIllllllIlllIIlIIIl + 0.6666667f) * 3.1415927f * 2.0f) * 0.65f + 0.35f;
        this.particleScale *= 0.75f;
        this.particleScale *= llllllllllllllIllllllIlllIIIIlll;
        this.noteParticleScale = this.particleScale;
        this.particleMaxAge = 6;
        this.noClip = false;
        this.setParticleTextureIndex(64);
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002592";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIlIllIIIllIIIIlll, final World llllllllllllllIIlIllIIIlIllllIlI, final double llllllllllllllIIlIllIIIlIllllIII, final double llllllllllllllIIlIllIIIllIIIIlII, final double llllllllllllllIIlIllIIIlIlllIlII, final double llllllllllllllIIlIllIIIlIlllIIlI, final double llllllllllllllIIlIllIIIllIIIIIII, final double llllllllllllllIIlIllIIIlIllIlllI, final int... llllllllllllllIIlIllIIIlIlllllII) {
            return new EntityNoteFX(llllllllllllllIIlIllIIIlIllllIlI, llllllllllllllIIlIllIIIlIllllIII, llllllllllllllIIlIllIIIllIIIIlII, llllllllllllllIIlIllIIIlIlllIlII, llllllllllllllIIlIllIIIlIlllIIlI, llllllllllllllIIlIllIIIllIIIIIII, llllllllllllllIIlIllIIIlIllIlllI);
        }
    }
}
