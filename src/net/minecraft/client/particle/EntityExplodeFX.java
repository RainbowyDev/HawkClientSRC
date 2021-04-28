package net.minecraft.client.particle;

import net.minecraft.world.*;

public class EntityExplodeFX extends EntityFX
{
    static {
        __OBFID = "CL_00000903";
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
        this.motionY += 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.8999999761581421;
        this.motionY *= 0.8999999761581421;
        this.motionZ *= 0.8999999761581421;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected EntityExplodeFX(final World llllllllllllllIIIlIIlIIlllIlllll, final double llllllllllllllIIIlIIlIIllllIIllI, final double llllllllllllllIIIlIIlIIllllIIlIl, final double llllllllllllllIIIlIIlIIlllIlllII, final double llllllllllllllIIIlIIlIIllllIIIll, final double llllllllllllllIIIlIIlIIlllIllIlI, final double llllllllllllllIIIlIIlIIlllIllIIl) {
        super(llllllllllllllIIIlIIlIIlllIlllll, llllllllllllllIIIlIIlIIllllIIllI, llllllllllllllIIIlIIlIIllllIIlIl, llllllllllllllIIIlIIlIIlllIlllII, llllllllllllllIIIlIIlIIllllIIIll, llllllllllllllIIIlIIlIIlllIllIlI, llllllllllllllIIIlIIlIIlllIllIIl);
        this.motionX = llllllllllllllIIIlIIlIIllllIIIll + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        this.motionY = llllllllllllllIIIlIIlIIlllIllIlI + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        this.motionZ = llllllllllllllIIIlIIlIIlllIllIIl + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        final float particleRed = this.rand.nextFloat() * 0.3f + 0.7f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleScale = this.rand.nextFloat() * this.rand.nextFloat() * 6.0f + 1.0f;
        this.particleMaxAge = (int)(16.0 / (this.rand.nextFloat() * 0.8 + 0.2)) + 2;
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002604";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIllIIIIIIIllllIIl, final World llllllllllllllIIllIIIIIIIlllIIII, final double llllllllllllllIIllIIIIIIIlllIlll, final double llllllllllllllIIllIIIIIIIlllIllI, final double llllllllllllllIIllIIIIIIIllIllIl, final double llllllllllllllIIllIIIIIIIlllIlII, final double llllllllllllllIIllIIIIIIIlllIIll, final double llllllllllllllIIllIIIIIIIllIlIlI, final int... llllllllllllllIIllIIIIIIIlllIIIl) {
            return new EntityExplodeFX(llllllllllllllIIllIIIIIIIlllIIII, llllllllllllllIIllIIIIIIIlllIlll, llllllllllllllIIllIIIIIIIlllIllI, llllllllllllllIIllIIIIIIIllIllIl, llllllllllllllIIllIIIIIIIlllIlII, llllllllllllllIIllIIIIIIIlllIIll, llllllllllllllIIllIIIIIIIllIlIlI);
        }
    }
}
