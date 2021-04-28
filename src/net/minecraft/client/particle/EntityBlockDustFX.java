package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class EntityBlockDustFX extends EntityDiggingFX
{
    static {
        __OBFID = "CL_00000931";
    }
    
    protected EntityBlockDustFX(final World llllllllllllllIlIIlIIIlIllIIllll, final double llllllllllllllIlIIlIIIlIllIlIlll, final double llllllllllllllIlIIlIIIlIllIlIllI, final double llllllllllllllIlIIlIIIlIllIlIlIl, final double llllllllllllllIlIIlIIIlIllIlIlII, final double llllllllllllllIlIIlIIIlIllIlIIll, final double llllllllllllllIlIIlIIIlIllIlIIlI, final IBlockState llllllllllllllIlIIlIIIlIllIlIIIl) {
        super(llllllllllllllIlIIlIIIlIllIIllll, llllllllllllllIlIIlIIIlIllIlIlll, llllllllllllllIlIIlIIIlIllIlIllI, llllllllllllllIlIIlIIIlIllIlIlIl, llllllllllllllIlIIlIIIlIllIlIlII, llllllllllllllIlIIlIIIlIllIlIIll, llllllllllllllIlIIlIIIlIllIlIIlI, llllllllllllllIlIIlIIIlIllIlIIIl);
        this.motionX = llllllllllllllIlIIlIIIlIllIlIlII;
        this.motionY = llllllllllllllIlIIlIIIlIllIlIIll;
        this.motionZ = llllllllllllllIlIIlIIIlIllIlIIlI;
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002576";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllllIlllIlllIlIIIlIl, final World llllllllllllllllIlllIlllIIlllIlI, final double llllllllllllllllIlllIlllIlIIIIll, final double llllllllllllllllIlllIlllIlIIIIlI, final double llllllllllllllllIlllIlllIIllIlll, final double llllllllllllllllIlllIlllIlIIIIII, final double llllllllllllllllIlllIlllIIllIlIl, final double llllllllllllllllIlllIlllIIllIlII, final int... llllllllllllllllIlllIlllIIllllIl) {
            final IBlockState llllllllllllllllIlllIlllIIllllII = Block.getStateById(llllllllllllllllIlllIlllIIllllIl[0]);
            return (llllllllllllllllIlllIlllIIllllII.getBlock().getRenderType() == -1) ? null : new EntityBlockDustFX(llllllllllllllllIlllIlllIIlllIlI, llllllllllllllllIlllIlllIlIIIIll, llllllllllllllllIlllIlllIlIIIIlI, llllllllllllllllIlllIlllIIllIlll, llllllllllllllllIlllIlllIlIIIIII, llllllllllllllllIlllIlllIIllIlIl, llllllllllllllllIlllIlllIIllIlII, llllllllllllllllIlllIlllIIllllII).func_174845_l();
        }
    }
}
