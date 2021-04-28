package net.minecraft.client.particle;

import net.minecraft.world.*;

public class EntitySplashFX extends EntityRainFX
{
    protected EntitySplashFX(final World llllllllllllllIlIIlIlIIlllllIlll, final double llllllllllllllIlIIlIlIIlllllIllI, final double llllllllllllllIlIIlIlIIlllllllIl, final double llllllllllllllIlIIlIlIIlllllIlII, final double llllllllllllllIlIIlIlIIllllllIll, final double llllllllllllllIlIIlIlIIlllllIIlI, final double llllllllllllllIlIIlIlIIlllllIIIl) {
        super(llllllllllllllIlIIlIlIIlllllIlll, llllllllllllllIlIIlIlIIlllllIllI, llllllllllllllIlIIlIlIIlllllllIl, llllllllllllllIlIIlIlIIlllllIlII);
        this.particleGravity = 0.04f;
        this.nextTextureIndexX();
        if (llllllllllllllIlIIlIlIIlllllIIlI == 0.0 && (llllllllllllllIlIIlIlIIllllllIll != 0.0 || llllllllllllllIlIIlIlIIlllllIIIl != 0.0)) {
            this.motionX = llllllllllllllIlIIlIlIIllllllIll;
            this.motionY = llllllllllllllIlIIlIlIIlllllIIlI + 0.1;
            this.motionZ = llllllllllllllIlIIlIlIIlllllIIIl;
        }
    }
    
    static {
        __OBFID = "CL_00000927";
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int lllllllllllllllIIIIIIllllllIIIll, final World lllllllllllllllIIIIIIllllllIIIlI, final double lllllllllllllllIIIIIIlllllIllIIl, final double lllllllllllllllIIIIIIlllllIllIII, final double lllllllllllllllIIIIIIlllllIlllll, final double lllllllllllllllIIIIIIlllllIlIllI, final double lllllllllllllllIIIIIIlllllIlllIl, final double lllllllllllllllIIIIIIlllllIlIlII, final int... lllllllllllllllIIIIIIlllllIllIll) {
            return new EntitySplashFX(lllllllllllllllIIIIIIllllllIIIlI, lllllllllllllllIIIIIIlllllIllIIl, lllllllllllllllIIIIIIlllllIllIII, lllllllllllllllIIIIIIlllllIlllll, lllllllllllllllIIIIIIlllllIlIllI, lllllllllllllllIIIIIIlllllIlllIl, lllllllllllllllIIIIIIlllllIlIlII);
        }
        
        static {
            __OBFID = "CL_00002580";
        }
    }
}
