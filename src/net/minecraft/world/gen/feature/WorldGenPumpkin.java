package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;

public class WorldGenPumpkin extends WorldGenerator
{
    static {
        __OBFID = "CL_00000428";
    }
    
    @Override
    public boolean generate(final World lIIIlIIIIlIIlll, final Random lIIIlIIIIlIIllI, final BlockPos lIIIlIIIIlIIlIl) {
        for (int lIIIlIIIIlIIlII = 0; lIIIlIIIIlIIlII < 64; ++lIIIlIIIIlIIlII) {
            final BlockPos lIIIlIIIIlIIIll = lIIIlIIIIlIIlIl.add(lIIIlIIIIlIIllI.nextInt(8) - lIIIlIIIIlIIllI.nextInt(8), lIIIlIIIIlIIllI.nextInt(4) - lIIIlIIIIlIIllI.nextInt(4), lIIIlIIIIlIIllI.nextInt(8) - lIIIlIIIIlIIllI.nextInt(8));
            if (lIIIlIIIIlIIlll.isAirBlock(lIIIlIIIIlIIIll) && lIIIlIIIIlIIlll.getBlockState(lIIIlIIIIlIIIll.offsetDown()).getBlock() == Blocks.grass && Blocks.pumpkin.canPlaceBlockAt(lIIIlIIIIlIIlll, lIIIlIIIIlIIIll)) {
                lIIIlIIIIlIIlll.setBlockState(lIIIlIIIIlIIIll, Blocks.pumpkin.getDefaultState().withProperty(BlockPumpkin.AGE, EnumFacing.Plane.HORIZONTAL.random(lIIIlIIIIlIIllI)), 2);
            }
        }
        return true;
    }
}
