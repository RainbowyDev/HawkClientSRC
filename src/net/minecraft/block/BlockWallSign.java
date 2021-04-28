package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import com.google.common.base.*;
import net.minecraft.world.*;

public class BlockWallSign extends BlockSign
{
    public static final /* synthetic */ PropertyDirection field_176412_a;
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockWallSign.field_176412_a });
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIIllIllllllllIlll, final BlockPos llllllllllllllIIIllIllllllllIllI) {
        final EnumFacing llllllllllllllIIIllIlllllllllllI = (EnumFacing)llllllllllllllIIIllIllllllllIlll.getBlockState(llllllllllllllIIIllIllllllllIllI).getValue(BlockWallSign.field_176412_a);
        final float llllllllllllllIIIllIllllllllllIl = 0.28125f;
        final float llllllllllllllIIIllIllllllllllII = 0.78125f;
        final float llllllllllllllIIIllIlllllllllIll = 0.0f;
        final float llllllllllllllIIIllIlllllllllIlI = 1.0f;
        final float llllllllllllllIIIllIlllllllllIIl = 0.125f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        switch (SwitchEnumFacing.field_177331_a[llllllllllllllIIIllIlllllllllllI.ordinal()]) {
            case 1: {
                this.setBlockBounds(llllllllllllllIIIllIlllllllllIll, llllllllllllllIIIllIllllllllllIl, 1.0f - llllllllllllllIIIllIlllllllllIIl, llllllllllllllIIIllIlllllllllIlI, llllllllllllllIIIllIllllllllllII, 1.0f);
                break;
            }
            case 2: {
                this.setBlockBounds(llllllllllllllIIIllIlllllllllIll, llllllllllllllIIIllIllllllllllIl, 0.0f, llllllllllllllIIIllIlllllllllIlI, llllllllllllllIIIllIllllllllllII, llllllllllllllIIIllIlllllllllIIl);
                break;
            }
            case 3: {
                this.setBlockBounds(1.0f - llllllllllllllIIIllIlllllllllIIl, llllllllllllllIIIllIllllllllllIl, llllllllllllllIIIllIlllllllllIll, 1.0f, llllllllllllllIIIllIllllllllllII, llllllllllllllIIIllIlllllllllIlI);
                break;
            }
            case 4: {
                this.setBlockBounds(0.0f, llllllllllllllIIIllIllllllllllIl, llllllllllllllIIIllIlllllllllIll, llllllllllllllIIIllIlllllllllIIl, llllllllllllllIIIllIllllllllllII, llllllllllllllIIIllIlllllllllIlI);
                break;
            }
        }
    }
    
    public BlockWallSign() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockWallSign.field_176412_a, EnumFacing.NORTH));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIllIllllllIlIIlI) {
        return ((EnumFacing)llllllllllllllIIIllIllllllIlIIlI.getValue(BlockWallSign.field_176412_a)).getIndex();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIllIllllllIlIllI) {
        EnumFacing llllllllllllllIIIllIllllllIllIII = EnumFacing.getFront(llllllllllllllIIIllIllllllIlIllI);
        if (llllllllllllllIIIllIllllllIllIII.getAxis() == EnumFacing.Axis.Y) {
            llllllllllllllIIIllIllllllIllIII = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(BlockWallSign.field_176412_a, llllllllllllllIIIllIllllllIllIII);
    }
    
    static {
        __OBFID = "CL_00002047";
        field_176412_a = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIIllIlllllllIIIlI, final BlockPos llllllllllllllIIIllIlllllllIIlll, final IBlockState llllllllllllllIIIllIlllllllIIllI, final Block llllllllllllllIIIllIlllllllIIlIl) {
        final EnumFacing llllllllllllllIIIllIlllllllIIlII = (EnumFacing)llllllllllllllIIIllIlllllllIIllI.getValue(BlockWallSign.field_176412_a);
        if (!llllllllllllllIIIllIlllllllIIIlI.getBlockState(llllllllllllllIIIllIlllllllIIlll.offset(llllllllllllllIIIllIlllllllIIlII.getOpposite())).getBlock().getMaterial().isSolid()) {
            this.dropBlockAsItem(llllllllllllllIIIllIlllllllIIIlI, llllllllllllllIIIllIlllllllIIlll, llllllllllllllIIIllIlllllllIIllI, 0);
            llllllllllllllIIIllIlllllllIIIlI.setBlockToAir(llllllllllllllIIIllIlllllllIIlll);
        }
        super.onNeighborBlockChange(llllllllllllllIIIllIlllllllIIIlI, llllllllllllllIIIllIlllllllIIlll, llllllllllllllIIIllIlllllllIIllI, llllllllllllllIIIllIlllllllIIlIl);
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_177331_a;
        
        static {
            __OBFID = "CL_00002046";
            field_177331_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_177331_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_177331_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_177331_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_177331_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
