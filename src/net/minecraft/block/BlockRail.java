package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class BlockRail extends BlockRailBase
{
    public static final /* synthetic */ PropertyEnum field_176565_b;
    
    static {
        __OBFID = "CL_00000293";
        field_176565_b = PropertyEnum.create("shape", EnumRailDirection.class);
    }
    
    protected BlockRail() {
        super(false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRail.field_176565_b, EnumRailDirection.NORTH_SOUTH));
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockRail.field_176565_b });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIllIllllllIIIIllIl) {
        return this.getDefaultState().withProperty(BlockRail.field_176565_b, EnumRailDirection.func_177016_a(llllllllllllllIllIllllllIIIIllIl));
    }
    
    @Override
    public IProperty func_176560_l() {
        return BlockRail.field_176565_b;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIllIllllllIIIIlIlI) {
        return ((EnumRailDirection)llllllllllllllIllIllllllIIIIlIlI.getValue(BlockRail.field_176565_b)).func_177015_a();
    }
    
    @Override
    protected void func_176561_b(final World llllllllllllllIllIllllllIIIlllII, final BlockPos llllllllllllllIllIllllllIIIlIllI, final IBlockState llllllllllllllIllIllllllIIIllIlI, final Block llllllllllllllIllIllllllIIIlIlII) {
        if (llllllllllllllIllIllllllIIIlIlII.canProvidePower() && new Rail(llllllllllllllIllIllllllIIIlllII, llllllllllllllIllIllllllIIIlIllI, llllllllllllllIllIllllllIIIllIlI).countAdjacentRails() == 3) {
            this.func_176564_a(llllllllllllllIllIllllllIIIlllII, llllllllllllllIllIllllllIIIlIllI, llllllllllllllIllIllllllIIIllIlI, false);
        }
    }
}
