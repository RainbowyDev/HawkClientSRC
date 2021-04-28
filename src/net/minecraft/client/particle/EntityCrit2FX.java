package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityCrit2FX extends EntityFX
{
    /* synthetic */ float field_174839_a;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.particleGreen *= (float)0.96;
        this.particleBlue *= (float)0.9;
        this.motionX *= 0.699999988079071;
        this.motionY *= 0.699999988079071;
        this.motionZ *= 0.699999988079071;
        this.motionY -= 0.019999999552965164;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    static {
        __OBFID = "CL_00000899";
    }
    
    protected EntityCrit2FX(final World lllllllllllllllIllIIIlIlllllIlll, final double lllllllllllllllIllIIIlIlllllIllI, final double lllllllllllllllIllIIIlIlllllllIl, final double lllllllllllllllIllIIIlIlllllIlII, final double lllllllllllllllIllIIIlIlllllIIll, final double lllllllllllllllIllIIIlIlllllIIlI, final double lllllllllllllllIllIIIlIllllllIIl) {
        this(lllllllllllllllIllIIIlIlllllIlll, lllllllllllllllIllIIIlIlllllIllI, lllllllllllllllIllIIIlIlllllllIl, lllllllllllllllIllIIIlIlllllIlII, lllllllllllllllIllIIIlIlllllIIll, lllllllllllllllIllIIIlIlllllIIlI, lllllllllllllllIllIIIlIllllllIIl, 1.0f);
    }
    
    @Override
    public void func_180434_a(final WorldRenderer lllllllllllllllIllIIIlIlllIIlIlI, final Entity lllllllllllllllIllIIIlIllIllllll, final float lllllllllllllllIllIIIlIllIlllllI, final float lllllllllllllllIllIIIlIllIllllIl, final float lllllllllllllllIllIIIlIllIllllII, final float lllllllllllllllIllIIIlIlllIIIlIl, final float lllllllllllllllIllIIIlIlllIIIlII, final float lllllllllllllllIllIIIlIlllIIIIll) {
        float lllllllllllllllIllIIIlIlllIIIIlI = (this.particleAge + lllllllllllllllIllIIIlIllIlllllI) / this.particleMaxAge * 32.0f;
        lllllllllllllllIllIIIlIlllIIIIlI = MathHelper.clamp_float(lllllllllllllllIllIIIlIlllIIIIlI, 0.0f, 1.0f);
        this.particleScale = this.field_174839_a * lllllllllllllllIllIIIlIlllIIIIlI;
        super.func_180434_a(lllllllllllllllIllIIIlIlllIIlIlI, lllllllllllllllIllIIIlIllIllllll, lllllllllllllllIllIIIlIllIlllllI, lllllllllllllllIllIIIlIllIllllIl, lllllllllllllllIllIIIlIllIllllII, lllllllllllllllIllIIIlIlllIIIlIl, lllllllllllllllIllIIIlIlllIIIlII, lllllllllllllllIllIIIlIlllIIIIll);
    }
    
    protected EntityCrit2FX(final World lllllllllllllllIllIIIlIllllIIllI, final double lllllllllllllllIllIIIlIlllIlllII, final double lllllllllllllllIllIIIlIllllIIlII, final double lllllllllllllllIllIIIlIlllIllIlI, final double lllllllllllllllIllIIIlIlllIllIIl, final double lllllllllllllllIllIIIlIllllIIIIl, final double lllllllllllllllIllIIIlIllllIIIII, final float lllllllllllllllIllIIIlIlllIlIllI) {
        super(lllllllllllllllIllIIIlIllllIIllI, lllllllllllllllIllIIIlIlllIlllII, lllllllllllllllIllIIIlIllllIIlII, lllllllllllllllIllIIIlIlllIllIlI, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllllllIllIIIlIlllIllIIl * 0.4;
        this.motionY += lllllllllllllllIllIIIlIllllIIIIl * 0.4;
        this.motionZ += lllllllllllllllIllIIIlIllllIIIII * 0.4;
        final float particleRed = (float)(Math.random() * 0.30000001192092896 + 0.6000000238418579);
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllllIllIIIlIlllIlIllI;
        this.field_174839_a = this.particleScale;
        this.particleMaxAge = (int)(6.0 / (Math.random() * 0.8 + 0.6));
        this.particleMaxAge *= (int)lllllllllllllllIllIIIlIlllIlIllI;
        this.noClip = false;
        this.setParticleTextureIndex(65);
        this.onUpdate();
    }
    
    public static class MagicFactory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002609";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIlIlllIllIlIlllII, final World llllllllllllllIIlIlllIllIlIlIIIl, final double llllllllllllllIIlIlllIllIlIlIIII, final double llllllllllllllIIlIlllIllIlIllIIl, final double llllllllllllllIIlIlllIllIlIIlllI, final double llllllllllllllIIlIlllIllIlIIllIl, final double llllllllllllllIIlIlllIllIlIIllII, final double llllllllllllllIIlIlllIllIlIIlIll, final int... llllllllllllllIIlIlllIllIlIlIlII) {
            final EntityCrit2FX llllllllllllllIIlIlllIllIlIlIIll = new EntityCrit2FX(llllllllllllllIIlIlllIllIlIlIIIl, llllllllllllllIIlIlllIllIlIlIIII, llllllllllllllIIlIlllIllIlIllIIl, llllllllllllllIIlIlllIllIlIIlllI, llllllllllllllIIlIlllIllIlIIllIl, llllllllllllllIIlIlllIllIlIIllII, llllllllllllllIIlIlllIllIlIIlIll);
            llllllllllllllIIlIlllIllIlIlIIll.setRBGColorF(llllllllllllllIIlIlllIllIlIlIIll.getRedColorF() * 0.3f, llllllllllllllIIlIlllIllIlIlIIll.getGreenColorF() * 0.8f, llllllllllllllIIlIlllIllIlIlIIll.getBlueColorF());
            llllllllllllllIIlIlllIllIlIlIIll.nextTextureIndexX();
            return llllllllllllllIIlIlllIllIlIlIIll;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002608";
        }
        
        @Override
        public EntityFX func_178902_a(final int lllllllllllllllllIIlIlIIIllllIIl, final World lllllllllllllllllIIlIlIIIllllIII, final double lllllllllllllllllIIlIlIIIlllIlll, final double lllllllllllllllllIIlIlIIIlllIllI, final double lllllllllllllllllIIlIlIIIlllIlIl, final double lllllllllllllllllIIlIlIIIllIllII, final double lllllllllllllllllIIlIlIIIllIlIll, final double lllllllllllllllllIIlIlIIIllIlIlI, final int... lllllllllllllllllIIlIlIIIlllIIIl) {
            return new EntityCrit2FX(lllllllllllllllllIIlIlIIIllllIII, lllllllllllllllllIIlIlIIIlllIlll, lllllllllllllllllIIlIlIIIlllIllI, lllllllllllllllllIIlIlIIIlllIlIl, lllllllllllllllllIIlIlIIIllIllII, lllllllllllllllllIIlIlIIIllIlIll, lllllllllllllllllIIlIlIIIllIlIlI);
        }
    }
}
