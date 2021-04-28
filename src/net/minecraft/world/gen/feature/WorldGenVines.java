package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class WorldGenVines extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllllIIIIIIIllllIlIllll, final Random llllllllllllllIIIIIIIllllIllIllI, BlockPos llllllllllllllIIIIIIIllllIlIllIl) {
        while (((Vec3i)llllllllllllllIIIIIIIllllIlIllIl).getY() < 128) {
            if (llllllllllllllIIIIIIIllllIlIllll.isAirBlock((BlockPos)llllllllllllllIIIIIIIllllIlIllIl)) {
                for (final EnumFacing llllllllllllllIIIIIIIllllIllIIIl : EnumFacing.Plane.HORIZONTAL.facings()) {
                    if (Blocks.vine.canPlaceBlockOnSide(llllllllllllllIIIIIIIllllIlIllll, (BlockPos)llllllllllllllIIIIIIIllllIlIllIl, llllllllllllllIIIIIIIllllIllIIIl)) {
                        final IBlockState llllllllllllllIIIIIIIllllIllIIII = Blocks.vine.getDefaultState().withProperty(BlockVine.field_176273_b, llllllllllllllIIIIIIIllllIllIIIl == EnumFacing.NORTH).withProperty(BlockVine.field_176278_M, llllllllllllllIIIIIIIllllIllIIIl == EnumFacing.EAST).withProperty(BlockVine.field_176279_N, llllllllllllllIIIIIIIllllIllIIIl == EnumFacing.SOUTH).withProperty(BlockVine.field_176280_O, llllllllllllllIIIIIIIllllIllIIIl == EnumFacing.WEST);
                        llllllllllllllIIIIIIIllllIlIllll.setBlockState((BlockPos)llllllllllllllIIIIIIIllllIlIllIl, llllllllllllllIIIIIIIllllIllIIII, 2);
                        break;
                    }
                }
            }
            else {
                llllllllllllllIIIIIIIllllIlIllIl = (Comparable<Double>)((BlockPos)llllllllllllllIIIIIIIllllIlIllIl).add(llllllllllllllIIIIIIIllllIllIllI.nextInt(4) - llllllllllllllIIIIIIIllllIllIllI.nextInt(4), 0, llllllllllllllIIIIIIIllllIllIllI.nextInt(4) - llllllllllllllIIIIIIIllllIllIllI.nextInt(4));
            }
            llllllllllllllIIIIIIIllllIlIllIl = (Comparable<Double>)((BlockPos)llllllllllllllIIIIIIIllllIlIllIl).offsetUp();
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00000439";
    }
}
