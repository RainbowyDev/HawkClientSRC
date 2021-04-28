package net.minecraft.client.particle;

import net.minecraft.world.*;

public class EntityFishWakeFX extends EntityFX
{
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        final int lllllllllllllllIllIIllIlIllIllII = 60 - this.particleMaxAge;
        final float lllllllllllllllIllIIllIlIllIlIll = lllllllllllllllIllIIllIlIllIllII * 0.001f;
        this.setSize(lllllllllllllllIllIIllIlIllIlIll, lllllllllllllllIllIIllIlIllIlIll);
        this.setParticleTextureIndex(19 + lllllllllllllllIllIIllIlIllIllII % 4);
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
    }
    
    static {
        __OBFID = "CL_00000933";
    }
    
    protected EntityFishWakeFX(final World lllllllllllllllIllIIllIlIlllllll, final double lllllllllllllllIllIIllIlIlllIllI, final double lllllllllllllllIllIIllIlIlllIlIl, final double lllllllllllllllIllIIllIlIlllIlII, final double lllllllllllllllIllIIllIlIlllIIll, final double lllllllllllllllIllIIllIlIllllIlI, final double lllllllllllllllIllIIllIlIllllIIl) {
        super(lllllllllllllllIllIIllIlIlllllll, lllllllllllllllIllIIllIlIlllIllI, lllllllllllllllIllIIllIlIlllIlIl, lllllllllllllllIllIIllIlIlllIlII, 0.0, 0.0, 0.0);
        this.motionX *= 0.30000001192092896;
        this.motionY = Math.random() * 0.20000000298023224 + 0.10000000149011612;
        this.motionZ *= 0.30000001192092896;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(19);
        this.setSize(0.01f, 0.01f);
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleGravity = 0.0f;
        this.motionX = lllllllllllllllIllIIllIlIlllIIll;
        this.motionY = lllllllllllllllIllIIllIlIllllIlI;
        this.motionZ = lllllllllllllllIllIIllIlIllllIIl;
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002573";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIlllIIlIllllIllllI, final World llllllllllllllIlllIIlIllllIlllIl, final double llllllllllllllIlllIIlIllllIlIlII, final double llllllllllllllIlllIIlIllllIllIll, final double llllllllllllllIlllIIlIllllIllIlI, final double llllllllllllllIlllIIlIllllIlIIIl, final double llllllllllllllIlllIIlIllllIlIIII, final double llllllllllllllIlllIIlIllllIIllll, final int... llllllllllllllIlllIIlIllllIlIllI) {
            return new EntityFishWakeFX(llllllllllllllIlllIIlIllllIlllIl, llllllllllllllIlllIIlIllllIlIlII, llllllllllllllIlllIIlIllllIllIll, llllllllllllllIlllIIlIllllIllIlI, llllllllllllllIlllIIlIllllIlIIIl, llllllllllllllIlllIIlIllllIlIIII, llllllllllllllIlllIIlIllllIIllll);
        }
    }
}
