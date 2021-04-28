package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class WorldGenFire extends WorldGenerator
{
    static {
        __OBFID = "CL_00000412";
    }
    
    @Override
    public boolean generate(final World llllllllllllllIIlllIIIIIlIIIIIll, final Random llllllllllllllIIlllIIIIIlIIIIIlI, final BlockPos llllllllllllllIIlllIIIIIlIIIIIIl) {
        for (int llllllllllllllIIlllIIIIIlIIIIlIl = 0; llllllllllllllIIlllIIIIIlIIIIlIl < 64; ++llllllllllllllIIlllIIIIIlIIIIlIl) {
            final BlockPos llllllllllllllIIlllIIIIIlIIIIlII = llllllllllllllIIlllIIIIIlIIIIIIl.add(llllllllllllllIIlllIIIIIlIIIIIlI.nextInt(8) - llllllllllllllIIlllIIIIIlIIIIIlI.nextInt(8), llllllllllllllIIlllIIIIIlIIIIIlI.nextInt(4) - llllllllllllllIIlllIIIIIlIIIIIlI.nextInt(4), llllllllllllllIIlllIIIIIlIIIIIlI.nextInt(8) - llllllllllllllIIlllIIIIIlIIIIIlI.nextInt(8));
            if (llllllllllllllIIlllIIIIIlIIIIIll.isAirBlock(llllllllllllllIIlllIIIIIlIIIIlII) && llllllllllllllIIlllIIIIIlIIIIIll.getBlockState(llllllllllllllIIlllIIIIIlIIIIlII.offsetDown()).getBlock() == Blocks.netherrack) {
                llllllllllllllIIlllIIIIIlIIIIIll.setBlockState(llllllllllllllIIlllIIIIIlIIIIlII, Blocks.fire.getDefaultState(), 2);
            }
        }
        return true;
    }
}
