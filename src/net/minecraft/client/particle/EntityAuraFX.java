package net.minecraft.client.particle;

import net.minecraft.world.*;

public class EntityAuraFX extends EntityFX
{
    static {
        __OBFID = "CL_00000929";
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.99;
        this.motionY *= 0.99;
        this.motionZ *= 0.99;
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
    }
    
    protected EntityAuraFX(final World llllllllllllllIlIlIllIlIIIlIIIIl, final double llllllllllllllIlIlIllIlIIIlIlIIl, final double llllllllllllllIlIlIllIlIIIIlllll, final double llllllllllllllIlIlIllIlIIIlIIlll, final double llllllllllllllIlIlIllIlIIIlIIllI, final double llllllllllllllIlIlIllIlIIIIlllII, final double llllllllllllllIlIlIllIlIIIIllIll) {
        super(llllllllllllllIlIlIllIlIIIlIIIIl, llllllllllllllIlIlIllIlIIIlIlIIl, llllllllllllllIlIlIllIlIIIIlllll, llllllllllllllIlIlIllIlIIIlIIlll, llllllllllllllIlIlIllIlIIIlIIllI, llllllllllllllIlIlIllIlIIIIlllII, llllllllllllllIlIlIllIlIIIIllIll);
        final float llllllllllllllIlIlIllIlIIIlIIIll = this.rand.nextFloat() * 0.1f + 0.2f;
        this.particleRed = llllllllllllllIlIlIllIlIIIlIIIll;
        this.particleGreen = llllllllllllllIlIlIllIlIIIlIIIll;
        this.particleBlue = llllllllllllllIlIlIllIlIIIlIIIll;
        this.setParticleTextureIndex(0);
        this.setSize(0.02f, 0.02f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.5f;
        this.motionX *= 0.019999999552965164;
        this.motionY *= 0.019999999552965164;
        this.motionZ *= 0.019999999552965164;
        this.particleMaxAge = (int)(20.0 / (Math.random() * 0.8 + 0.2));
        this.noClip = true;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int lllllllllllllIllllllllIlIlIIllIl, final World lllllllllllllIllllllllIlIlIIllII, final double lllllllllllllIllllllllIlIlIIlIll, final double lllllllllllllIllllllllIlIlIIlIlI, final double lllllllllllllIllllllllIlIlIIIIIl, final double lllllllllllllIllllllllIlIlIIlIII, final double lllllllllllllIllllllllIlIlIIIlll, final double lllllllllllllIllllllllIlIIlllllI, final int... lllllllllllllIllllllllIlIlIIIlIl) {
            return new EntityAuraFX(lllllllllllllIllllllllIlIlIIllII, lllllllllllllIllllllllIlIlIIlIll, lllllllllllllIllllllllIlIlIIlIlI, lllllllllllllIllllllllIlIlIIIIIl, lllllllllllllIllllllllIlIlIIlIII, lllllllllllllIllllllllIlIlIIIlll, lllllllllllllIllllllllIlIIlllllI);
        }
        
        static {
            __OBFID = "CL_00002577";
        }
    }
    
    public static class HappyVillagerFactory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIIlllIIIlllllllIl, final World llllllllllllllIIIlllIIIlllllllII, final double llllllllllllllIIIlllIIIlllllIIIl, final double llllllllllllllIIIlllIIIllllllIlI, final double llllllllllllllIIIlllIIIllllllIIl, final double llllllllllllllIIIlllIIIllllllIII, final double llllllllllllllIIIlllIIIllllIllIl, final double llllllllllllllIIIlllIIIlllllIllI, final int... llllllllllllllIIIlllIIIlllllIlIl) {
            final EntityAuraFX llllllllllllllIIIlllIIIlllllIlII = new EntityAuraFX(llllllllllllllIIIlllIIIlllllllII, llllllllllllllIIIlllIIIlllllIIIl, llllllllllllllIIIlllIIIllllllIlI, llllllllllllllIIIlllIIIllllllIIl, llllllllllllllIIIlllIIIllllllIII, llllllllllllllIIIlllIIIllllIllIl, llllllllllllllIIIlllIIIlllllIllI);
            llllllllllllllIIIlllIIIlllllIlII.setParticleTextureIndex(82);
            llllllllllllllIIIlllIIIlllllIlII.setRBGColorF(1.0f, 1.0f, 1.0f);
            return llllllllllllllIIIlllIIIlllllIlII;
        }
        
        static {
            __OBFID = "CL_00002578";
        }
    }
}
