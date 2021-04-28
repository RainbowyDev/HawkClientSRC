package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class WorldGenWaterlily extends WorldGenerator
{
    static {
        __OBFID = "CL_00000189";
    }
    
    @Override
    public boolean generate(final World llllllllllllllllIIIllIIIlllllIII, final Random llllllllllllllllIIIllIIIlllllllI, final BlockPos llllllllllllllllIIIllIIIllllIllI) {
        for (int llllllllllllllllIIIllIIIllllllII = 0; llllllllllllllllIIIllIIIllllllII < 10; ++llllllllllllllllIIIllIIIllllllII) {
            final int llllllllllllllllIIIllIIIlllllIll = llllllllllllllllIIIllIIIllllIllI.getX() + llllllllllllllllIIIllIIIlllllllI.nextInt(8) - llllllllllllllllIIIllIIIlllllllI.nextInt(8);
            final int llllllllllllllllIIIllIIIlllllIlI = llllllllllllllllIIIllIIIllllIllI.getY() + llllllllllllllllIIIllIIIlllllllI.nextInt(4) - llllllllllllllllIIIllIIIlllllllI.nextInt(4);
            final int llllllllllllllllIIIllIIIlllllIIl = llllllllllllllllIIIllIIIllllIllI.getZ() + llllllllllllllllIIIllIIIlllllllI.nextInt(8) - llllllllllllllllIIIllIIIlllllllI.nextInt(8);
            if (llllllllllllllllIIIllIIIlllllIII.isAirBlock(new BlockPos(llllllllllllllllIIIllIIIlllllIll, llllllllllllllllIIIllIIIlllllIlI, llllllllllllllllIIIllIIIlllllIIl)) && Blocks.waterlily.canPlaceBlockAt(llllllllllllllllIIIllIIIlllllIII, new BlockPos(llllllllllllllllIIIllIIIlllllIll, llllllllllllllllIIIllIIIlllllIlI, llllllllllllllllIIIllIIIlllllIIl))) {
                llllllllllllllllIIIllIIIlllllIII.setBlockState(new BlockPos(llllllllllllllllIIIllIIIlllllIll, llllllllllllllllIIIllIIIlllllIlI, llllllllllllllllIIIllIIIlllllIIl), Blocks.waterlily.getDefaultState(), 2);
            }
        }
        return true;
    }
}
