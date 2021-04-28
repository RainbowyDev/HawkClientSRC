package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;

public class WorldGenReed extends WorldGenerator
{
    static {
        __OBFID = "CL_00000429";
    }
    
    @Override
    public boolean generate(final World llllllllllllllllIlIlIIIIllllllII, final Random llllllllllllllllIlIlIIIlIIIIIlIl, final BlockPos llllllllllllllllIlIlIIIlIIIIIlII) {
        for (int llllllllllllllllIlIlIIIlIIIIIIll = 0; llllllllllllllllIlIlIIIlIIIIIIll < 20; ++llllllllllllllllIlIlIIIlIIIIIIll) {
            final BlockPos llllllllllllllllIlIlIIIlIIIIIIlI = llllllllllllllllIlIlIIIlIIIIIlII.add(llllllllllllllllIlIlIIIlIIIIIlIl.nextInt(4) - llllllllllllllllIlIlIIIlIIIIIlIl.nextInt(4), 0, llllllllllllllllIlIlIIIlIIIIIlIl.nextInt(4) - llllllllllllllllIlIlIIIlIIIIIlIl.nextInt(4));
            if (llllllllllllllllIlIlIIIIllllllII.isAirBlock(llllllllllllllllIlIlIIIlIIIIIIlI)) {
                final BlockPos llllllllllllllllIlIlIIIlIIIIIIII = llllllllllllllllIlIlIIIlIIIIIIlI.offsetDown();
                if (llllllllllllllllIlIlIIIIllllllII.getBlockState(llllllllllllllllIlIlIIIlIIIIIIII.offsetWest()).getBlock().getMaterial() == Material.water || llllllllllllllllIlIlIIIIllllllII.getBlockState(llllllllllllllllIlIlIIIlIIIIIIII.offsetEast()).getBlock().getMaterial() == Material.water || llllllllllllllllIlIlIIIIllllllII.getBlockState(llllllllllllllllIlIlIIIlIIIIIIII.offsetNorth()).getBlock().getMaterial() == Material.water || llllllllllllllllIlIlIIIIllllllII.getBlockState(llllllllllllllllIlIlIIIlIIIIIIII.offsetSouth()).getBlock().getMaterial() == Material.water) {
                    for (int llllllllllllllllIlIlIIIIllllllll = 2 + llllllllllllllllIlIlIIIlIIIIIlIl.nextInt(llllllllllllllllIlIlIIIlIIIIIlIl.nextInt(3) + 1), llllllllllllllllIlIlIIIIlllllllI = 0; llllllllllllllllIlIlIIIIlllllllI < llllllllllllllllIlIlIIIIllllllll; ++llllllllllllllllIlIlIIIIlllllllI) {
                        if (Blocks.reeds.func_176354_d(llllllllllllllllIlIlIIIIllllllII, llllllllllllllllIlIlIIIlIIIIIIlI)) {
                            llllllllllllllllIlIlIIIIllllllII.setBlockState(llllllllllllllllIlIlIIIlIIIIIIlI.offsetUp(llllllllllllllllIlIlIIIIlllllllI), Blocks.reeds.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
