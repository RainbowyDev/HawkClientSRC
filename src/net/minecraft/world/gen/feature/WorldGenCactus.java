package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class WorldGenCactus extends WorldGenerator
{
    static {
        __OBFID = "CL_00000404";
    }
    
    @Override
    public boolean generate(final World llllllllllllllIlIIIIIIlIIIlllllI, final Random llllllllllllllIlIIIIIIlIIIllllIl, final BlockPos llllllllllllllIlIIIIIIlIIlIIIIll) {
        for (int llllllllllllllIlIIIIIIlIIlIIIIlI = 0; llllllllllllllIlIIIIIIlIIlIIIIlI < 10; ++llllllllllllllIlIIIIIIlIIlIIIIlI) {
            final BlockPos llllllllllllllIlIIIIIIlIIlIIIIIl = llllllllllllllIlIIIIIIlIIlIIIIll.add(llllllllllllllIlIIIIIIlIIIllllIl.nextInt(8) - llllllllllllllIlIIIIIIlIIIllllIl.nextInt(8), llllllllllllllIlIIIIIIlIIIllllIl.nextInt(4) - llllllllllllllIlIIIIIIlIIIllllIl.nextInt(4), llllllllllllllIlIIIIIIlIIIllllIl.nextInt(8) - llllllllllllllIlIIIIIIlIIIllllIl.nextInt(8));
            if (llllllllllllllIlIIIIIIlIIIlllllI.isAirBlock(llllllllllllllIlIIIIIIlIIlIIIIIl)) {
                for (int llllllllllllllIlIIIIIIlIIlIIIIII = 1 + llllllllllllllIlIIIIIIlIIIllllIl.nextInt(llllllllllllllIlIIIIIIlIIIllllIl.nextInt(3) + 1), llllllllllllllIlIIIIIIlIIIllllll = 0; llllllllllllllIlIIIIIIlIIIllllll < llllllllllllllIlIIIIIIlIIlIIIIII; ++llllllllllllllIlIIIIIIlIIIllllll) {
                    if (Blocks.cactus.canBlockStay(llllllllllllllIlIIIIIIlIIIlllllI, llllllllllllllIlIIIIIIlIIlIIIIIl)) {
                        llllllllllllllIlIIIIIIlIIIlllllI.setBlockState(llllllllllllllIlIIIIIIlIIlIIIIIl.offsetUp(llllllllllllllIlIIIIIIlIIIllllll), Blocks.cactus.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
