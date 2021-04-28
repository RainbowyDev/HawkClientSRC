package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class WorldGenDeadBush extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllllIIlIIlIIIllIIIlIII, final Random llllllllllllllIIlIIlIIIllIIIlllI, BlockPos llllllllllllllIIlIIlIIIllIIIIllI) {
        Block llllllllllllllIIlIIlIIIllIIIlIll;
        while (((llllllllllllllIIlIIlIIIllIIIlIll = llllllllllllllIIlIIlIIIllIIIlIII.getBlockState(llllllllllllllIIlIIlIIIllIIIIllI).getBlock()).getMaterial() == Material.air || llllllllllllllIIlIIlIIIllIIIlIll.getMaterial() == Material.leaves) && llllllllllllllIIlIIlIIIllIIIIllI.getY() > 0) {
            llllllllllllllIIlIIlIIIllIIIIllI = llllllllllllllIIlIIlIIIllIIIIllI.offsetDown();
        }
        for (int llllllllllllllIIlIIlIIIllIIIlIlI = 0; llllllllllllllIIlIIlIIIllIIIlIlI < 4; ++llllllllllllllIIlIIlIIIllIIIlIlI) {
            final BlockPos llllllllllllllIIlIIlIIIllIIIlIIl = llllllllllllllIIlIIlIIIllIIIIllI.add(llllllllllllllIIlIIlIIIllIIIlllI.nextInt(8) - llllllllllllllIIlIIlIIIllIIIlllI.nextInt(8), llllllllllllllIIlIIlIIIllIIIlllI.nextInt(4) - llllllllllllllIIlIIlIIIllIIIlllI.nextInt(4), llllllllllllllIIlIIlIIIllIIIlllI.nextInt(8) - llllllllllllllIIlIIlIIIllIIIlllI.nextInt(8));
            if (llllllllllllllIIlIIlIIIllIIIlIII.isAirBlock(llllllllllllllIIlIIlIIIllIIIlIIl) && Blocks.deadbush.canBlockStay(llllllllllllllIIlIIlIIIllIIIlIII, llllllllllllllIIlIIlIIIllIIIlIIl, Blocks.deadbush.getDefaultState())) {
                llllllllllllllIIlIIlIIIllIIIlIII.setBlockState(llllllllllllllIIlIIlIIIllIIIlIIl, Blocks.deadbush.getDefaultState(), 2);
            }
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00000406";
    }
}
