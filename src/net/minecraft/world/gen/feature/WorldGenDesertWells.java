package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import com.google.common.base.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class WorldGenDesertWells extends WorldGenerator
{
    private final /* synthetic */ IBlockState field_175911_b;
    private static final /* synthetic */ BlockStateHelper field_175913_a;
    private final /* synthetic */ IBlockState field_175912_c;
    private final /* synthetic */ IBlockState field_175910_d;
    
    @Override
    public boolean generate(final World llllllllllllllllIIlIIIlIIIIlIIIl, final Random llllllllllllllllIIlIIIlIIIIlllII, BlockPos llllllllllllllllIIlIIIlIIIIlIIII) {
        while (llllllllllllllllIIlIIIlIIIIlIIIl.isAirBlock((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII) && ((Vec3i)llllllllllllllllIIlIIIlIIIIlIIII).getY() > 2) {
            llllllllllllllllIIlIIIlIIIIlIIII = (Comparable<Byte>)((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).offsetDown();
        }
        if (!WorldGenDesertWells.field_175913_a.func_177639_a(llllllllllllllllIIlIIIlIIIIlIIIl.getBlockState((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII))) {
            return false;
        }
        for (int llllllllllllllllIIlIIIlIIIIllIlI = -2; llllllllllllllllIIlIIIlIIIIllIlI <= 2; ++llllllllllllllllIIlIIIlIIIIllIlI) {
            for (int llllllllllllllllIIlIIIlIIIIllIIl = -2; llllllllllllllllIIlIIIlIIIIllIIl <= 2; ++llllllllllllllllIIlIIIlIIIIllIIl) {
                if (llllllllllllllllIIlIIIlIIIIlIIIl.isAirBlock(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(llllllllllllllllIIlIIIlIIIIllIlI, -1, llllllllllllllllIIlIIIlIIIIllIIl)) && llllllllllllllllIIlIIIlIIIIlIIIl.isAirBlock(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(llllllllllllllllIIlIIIlIIIIllIlI, -2, llllllllllllllllIIlIIIlIIIIllIIl))) {
                    return false;
                }
            }
        }
        for (int llllllllllllllllIIlIIIlIIIIllIlI = -1; llllllllllllllllIIlIIIlIIIIllIlI <= 0; ++llllllllllllllllIIlIIIlIIIIllIlI) {
            for (int llllllllllllllllIIlIIIlIIIIllIII = -2; llllllllllllllllIIlIIIlIIIIllIII <= 2; ++llllllllllllllllIIlIIIlIIIIllIII) {
                for (int llllllllllllllllIIlIIIlIIIIlIlIl = -2; llllllllllllllllIIlIIIlIIIIlIlIl <= 2; ++llllllllllllllllIIlIIIlIIIIlIlIl) {
                    llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(llllllllllllllllIIlIIIlIIIIllIII, llllllllllllllllIIlIIIlIIIIllIlI, llllllllllllllllIIlIIIlIIIIlIlIl), this.field_175912_c, 2);
                }
            }
        }
        llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII, this.field_175910_d, 2);
        for (final EnumFacing llllllllllllllllIIlIIIlIIIIlIIll : EnumFacing.Plane.HORIZONTAL) {
            llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).offset(llllllllllllllllIIlIIIlIIIIlIIll), this.field_175910_d, 2);
        }
        for (int llllllllllllllllIIlIIIlIIIIllIlI = -2; llllllllllllllllIIlIIIlIIIIllIlI <= 2; ++llllllllllllllllIIlIIIlIIIIllIlI) {
            for (int llllllllllllllllIIlIIIlIIIIlIlll = -2; llllllllllllllllIIlIIIlIIIIlIlll <= 2; ++llllllllllllllllIIlIIIlIIIIlIlll) {
                if (llllllllllllllllIIlIIIlIIIIllIlI == -2 || llllllllllllllllIIlIIIlIIIIllIlI == 2 || llllllllllllllllIIlIIIlIIIIlIlll == -2 || llllllllllllllllIIlIIIlIIIIlIlll == 2) {
                    llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(llllllllllllllllIIlIIIlIIIIllIlI, 1, llllllllllllllllIIlIIIlIIIIlIlll), this.field_175912_c, 2);
                }
            }
        }
        llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(2, 1, 0), this.field_175911_b, 2);
        llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(-2, 1, 0), this.field_175911_b, 2);
        llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(0, 1, 2), this.field_175911_b, 2);
        llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(0, 1, -2), this.field_175911_b, 2);
        for (int llllllllllllllllIIlIIIlIIIIllIlI = -1; llllllllllllllllIIlIIIlIIIIllIlI <= 1; ++llllllllllllllllIIlIIIlIIIIllIlI) {
            for (int llllllllllllllllIIlIIIlIIIIlIllI = -1; llllllllllllllllIIlIIIlIIIIlIllI <= 1; ++llllllllllllllllIIlIIIlIIIIlIllI) {
                if (llllllllllllllllIIlIIIlIIIIllIlI == 0 && llllllllllllllllIIlIIIlIIIIlIllI == 0) {
                    llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(llllllllllllllllIIlIIIlIIIIllIlI, 4, llllllllllllllllIIlIIIlIIIIlIllI), this.field_175912_c, 2);
                }
                else {
                    llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(llllllllllllllllIIlIIIlIIIIllIlI, 4, llllllllllllllllIIlIIIlIIIIlIllI), this.field_175911_b, 2);
                }
            }
        }
        for (int llllllllllllllllIIlIIIlIIIIllIlI = 1; llllllllllllllllIIlIIIlIIIIllIlI <= 3; ++llllllllllllllllIIlIIIlIIIIllIlI) {
            llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(-1, llllllllllllllllIIlIIIlIIIIllIlI, -1), this.field_175912_c, 2);
            llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(-1, llllllllllllllllIIlIIIlIIIIllIlI, 1), this.field_175912_c, 2);
            llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(1, llllllllllllllllIIlIIIlIIIIllIlI, -1), this.field_175912_c, 2);
            llllllllllllllllIIlIIIlIIIIlIIIl.setBlockState(((BlockPos)llllllllllllllllIIlIIIlIIIIlIIII).add(1, llllllllllllllllIIlIIIlIIIIllIlI, 1), this.field_175912_c, 2);
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00000407";
        field_175913_a = BlockStateHelper.forBlock(Blocks.sand).func_177637_a(BlockSand.VARIANT_PROP, Predicates.equalTo((Object)BlockSand.EnumType.SAND));
    }
    
    public WorldGenDesertWells() {
        this.field_175911_b = Blocks.stone_slab.getDefaultState().withProperty(BlockStoneSlab.field_176556_M, BlockStoneSlab.EnumType.SAND).withProperty(BlockSlab.HALF_PROP, BlockSlab.EnumBlockHalf.BOTTOM);
        this.field_175912_c = Blocks.sandstone.getDefaultState();
        this.field_175910_d = Blocks.flowing_water.getDefaultState();
    }
}
