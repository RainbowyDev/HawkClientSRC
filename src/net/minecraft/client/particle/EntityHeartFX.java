package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityHeartFX extends EntityFX
{
    /* synthetic */ float particleScaleOverTime;
    
    static {
        __OBFID = "CL_00000909";
    }
    
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
        this.motionX *= 0.8600000143051147;
        this.motionY *= 0.8600000143051147;
        this.motionZ *= 0.8600000143051147;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llIIIIIIIIlIlll, final Entity llIIIIIIIIIllII, final float llIIIIIIIIlIlIl, final float llIIIIIIIIlIlII, final float llIIIIIIIIIlIIl, final float llIIIIIIIIIlIII, final float llIIIIIIIIlIIIl, final float llIIIIIIIIlIIII) {
        float llIIIIIIIIIllll = (this.particleAge + llIIIIIIIIlIlIl) / this.particleMaxAge * 32.0f;
        llIIIIIIIIIllll = MathHelper.clamp_float(llIIIIIIIIIllll, 0.0f, 1.0f);
        this.particleScale = this.particleScaleOverTime * llIIIIIIIIIllll;
        super.func_180434_a(llIIIIIIIIlIlll, llIIIIIIIIIllII, llIIIIIIIIlIlIl, llIIIIIIIIlIlII, llIIIIIIIIIlIIl, llIIIIIIIIIlIII, llIIIIIIIIlIIIl, llIIIIIIIIlIIII);
    }
    
    protected EntityHeartFX(final World llIIIIIIlIIIllI, final double llIIIIIIIllllIl, final double llIIIIIIlIIIlII, final double llIIIIIIIlllIll, final double llIIIIIIIlllIlI, final double llIIIIIIIlllIIl, final double llIIIIIIIlllIII) {
        this(llIIIIIIlIIIllI, llIIIIIIIllllIl, llIIIIIIlIIIlII, llIIIIIIIlllIll, llIIIIIIIlllIlI, llIIIIIIIlllIIl, llIIIIIIIlllIII, 2.0f);
    }
    
    protected EntityHeartFX(final World llIIIIIIIlIIlll, final double llIIIIIIIlIIllI, final double llIIIIIIIlIlllI, final double llIIIIIIIlIIlII, final double llIIIIIIIlIllII, final double llIIIIIIIlIlIll, final double llIIIIIIIlIlIlI, final float llIIIIIIIlIIIll) {
        super(llIIIIIIIlIIlll, llIIIIIIIlIIllI, llIIIIIIIlIlllI, llIIIIIIIlIIlII, 0.0, 0.0, 0.0);
        this.motionX *= 0.009999999776482582;
        this.motionY *= 0.009999999776482582;
        this.motionZ *= 0.009999999776482582;
        this.motionY += 0.1;
        this.particleScale *= 0.75f;
        this.particleScale *= llIIIIIIIlIIIll;
        this.particleScaleOverTime = this.particleScale;
        this.particleMaxAge = 16;
        this.noClip = false;
        this.setParticleTextureIndex(80);
    }
    
    public static class AngryVillagerFactory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002600";
        }
        
        @Override
        public EntityFX func_178902_a(final int lIlllIlllllIlll, final World lIlllIllllIllII, final double lIlllIllllIlIll, final double lIlllIllllIlIlI, final double lIlllIllllIlIIl, final double lIlllIlllllIIlI, final double lIlllIllllIIlll, final double lIlllIllllIIllI, final int... lIlllIllllIllll) {
            final EntityHeartFX lIlllIllllIlllI = new EntityHeartFX(lIlllIllllIllII, lIlllIllllIlIll, lIlllIllllIlIlI + 0.5, lIlllIllllIlIIl, lIlllIlllllIIlI, lIlllIllllIIlll, lIlllIllllIIllI);
            lIlllIllllIlllI.setParticleTextureIndex(81);
            lIlllIllllIlllI.setRBGColorF(1.0f, 1.0f, 1.0f);
            return lIlllIllllIlllI;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIIIlIIIIIIIlIIllI, final World llllllllllllllIIIIlIIIIIIIlIIlIl, final double llllllllllllllIIIIlIIIIIIIlIIlII, final double llllllllllllllIIIIlIIIIIIIIllIll, final double llllllllllllllIIIIlIIIIIIIIllIlI, final double llllllllllllllIIIIlIIIIIIIlIIIIl, final double llllllllllllllIIIIlIIIIIIIIllIII, final double llllllllllllllIIIIlIIIIIIIIlllll, final int... llllllllllllllIIIIlIIIIIIIIllllI) {
            return new EntityHeartFX(llllllllllllllIIIIlIIIIIIIlIIlIl, llllllllllllllIIIIlIIIIIIIlIIlII, llllllllllllllIIIIlIIIIIIIIllIll, llllllllllllllIIIIlIIIIIIIIllIlI, llllllllllllllIIIIlIIIIIIIlIIIIl, llllllllllllllIIIIlIIIIIIIIllIII, llllllllllllllIIIIlIIIIIIIIlllll);
        }
        
        static {
            __OBFID = "CL_00002599";
        }
    }
}
