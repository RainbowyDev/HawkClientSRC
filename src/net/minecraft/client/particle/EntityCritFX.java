package net.minecraft.client.particle;

import net.minecraft.world.*;

public class EntityCritFX extends EntitySmokeFX
{
    static {
        __OBFID = "CL_00000900";
    }
    
    protected EntityCritFX(final World llllllllllllllllIllIIIlllllIlllI, final double llllllllllllllllIllIIIlllllIllIl, final double llllllllllllllllIllIIIlllllIllII, final double llllllllllllllllIllIIIlllllIIIll, final double llllllllllllllllIllIIIlllllIIIlI, final double llllllllllllllllIllIIIlllllIIIIl, final double llllllllllllllllIllIIIlllllIIIII) {
        super(llllllllllllllllIllIIIlllllIlllI, llllllllllllllllIllIIIlllllIllIl, llllllllllllllllIllIIIlllllIllII, llllllllllllllllIllIIIlllllIIIll, llllllllllllllllIllIIIlllllIIIlI, llllllllllllllllIllIIIlllllIIIIl, llllllllllllllllIllIIIlllllIIIII, 2.5f);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int lllllllllllllllIIlIlllIlIlllIlIl, final World lllllllllllllllIIlIlllIlIlllIlII, final double lllllllllllllllIIlIlllIlIlllIIll, final double lllllllllllllllIIlIlllIlIlllIIlI, final double lllllllllllllllIIlIlllIlIlllIIIl, final double lllllllllllllllIIlIlllIlIllIlIII, final double lllllllllllllllIIlIlllIlIllIllll, final double lllllllllllllllIIlIlllIlIllIlllI, final int... lllllllllllllllIIlIlllIlIllIllIl) {
            return new EntityCritFX(lllllllllllllllIIlIlllIlIlllIlII, lllllllllllllllIIlIlllIlIlllIIll, lllllllllllllllIIlIlllIlIlllIIlI, lllllllllllllllIIlIlllIlIlllIIIl, lllllllllllllllIIlIlllIlIllIlIII, lllllllllllllllIIlIlllIlIllIllll, lllllllllllllllIIlIlllIlIllIlllI);
        }
        
        static {
            __OBFID = "CL_00002596";
        }
    }
}
