package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class WorldGenMelon extends WorldGenerator
{
    static {
        __OBFID = "CL_00000424";
    }
    
    @Override
    public boolean generate(final World llllllllllllllIIllIIIlllIIIllIlI, final Random llllllllllllllIIllIIIlllIIIllllI, final BlockPos llllllllllllllIIllIIIlllIIIllIII) {
        for (int llllllllllllllIIllIIIlllIIIlllII = 0; llllllllllllllIIllIIIlllIIIlllII < 64; ++llllllllllllllIIllIIIlllIIIlllII) {
            final BlockPos llllllllllllllIIllIIIlllIIIllIll = llllllllllllllIIllIIIlllIIIllIII.add(llllllllllllllIIllIIIlllIIIllllI.nextInt(8) - llllllllllllllIIllIIIlllIIIllllI.nextInt(8), llllllllllllllIIllIIIlllIIIllllI.nextInt(4) - llllllllllllllIIllIIIlllIIIllllI.nextInt(4), llllllllllllllIIllIIIlllIIIllllI.nextInt(8) - llllllllllllllIIllIIIlllIIIllllI.nextInt(8));
            if (Blocks.melon_block.canPlaceBlockAt(llllllllllllllIIllIIIlllIIIllIlI, llllllllllllllIIllIIIlllIIIllIll) && llllllllllllllIIllIIIlllIIIllIlI.getBlockState(llllllllllllllIIllIIIlllIIIllIll.offsetDown()).getBlock() == Blocks.grass) {
                llllllllllllllIIllIIIlllIIIllIlI.setBlockState(llllllllllllllIIllIIIlllIIIllIll, Blocks.melon_block.getDefaultState(), 2);
            }
        }
        return true;
    }
}
