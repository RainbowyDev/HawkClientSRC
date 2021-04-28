package net.minecraft.block;

import com.google.common.base.*;
import net.minecraft.entity.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;

public class BlockLadder extends Block
{
    public static final /* synthetic */ PropertyDirection field_176382_a;
    
    static {
        __OBFID = "CL_00000262";
        field_176382_a = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllllIllIIIlIlIIIIIl, final BlockPos lllllllllllllllllIllIIIlIIllIlIl, final EnumFacing lllllllllllllllllIllIIIlIIllllll, final float lllllllllllllllllIllIIIlIIlllllI, final float lllllllllllllllllIllIIIlIIllllIl, final float lllllllllllllllllIllIIIlIIllllII, final int lllllllllllllllllIllIIIlIIlllIll, final EntityLivingBase lllllllllllllllllIllIIIlIIlllIlI) {
        if (lllllllllllllllllIllIIIlIIllllll.getAxis().isHorizontal() && this.func_176381_b(lllllllllllllllllIllIIIlIlIIIIIl, lllllllllllllllllIllIIIlIIllIlIl, lllllllllllllllllIllIIIlIIllllll)) {
            return this.getDefaultState().withProperty(BlockLadder.field_176382_a, lllllllllllllllllIllIIIlIIllllll);
        }
        for (final EnumFacing lllllllllllllllllIllIIIlIIlllIII : EnumFacing.Plane.HORIZONTAL) {
            if (this.func_176381_b(lllllllllllllllllIllIIIlIlIIIIIl, lllllllllllllllllIllIIIlIIllIlIl, lllllllllllllllllIllIIIlIIlllIII)) {
                return this.getDefaultState().withProperty(BlockLadder.field_176382_a, lllllllllllllllllIllIIIlIIlllIII);
            }
        }
        return this.getDefaultState();
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllllIllIIIlIlIIllII, final BlockPos lllllllllllllllllIllIIIlIlIIlIIl) {
        return lllllllllllllllllIllIIIlIlIIllII.getBlockState(lllllllllllllllllIllIIIlIlIIlIIl.offsetWest()).getBlock().isNormalCube() || lllllllllllllllllIllIIIlIlIIllII.getBlockState(lllllllllllllllllIllIIIlIlIIlIIl.offsetEast()).getBlock().isNormalCube() || lllllllllllllllllIllIIIlIlIIllII.getBlockState(lllllllllllllllllIllIIIlIlIIlIIl.offsetNorth()).getBlock().isNormalCube() || lllllllllllllllllIllIIIlIlIIllII.getBlockState(lllllllllllllllllIllIIIlIlIIlIIl.offsetSouth()).getBlock().isNormalCube();
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World lllllllllllllllllIllIIIlIllIIIlI, final BlockPos lllllllllllllllllIllIIIlIllIIIIl) {
        this.setBlockBoundsBasedOnState(lllllllllllllllllIllIIIlIllIIIlI, lllllllllllllllllIllIIIlIllIIIIl);
        return super.getSelectedBoundingBox(lllllllllllllllllIllIIIlIllIIIlI, lllllllllllllllllIllIIIlIllIIIIl);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllllIllIIIlIllIllII, final BlockPos lllllllllllllllllIllIIIlIllIllll, final IBlockState lllllllllllllllllIllIIIlIllIlllI) {
        this.setBlockBoundsBasedOnState(lllllllllllllllllIllIIIlIllIllII, lllllllllllllllllIllIIIlIllIllll);
        return super.getCollisionBoundingBox(lllllllllllllllllIllIIIlIllIllII, lllllllllllllllllIllIIIlIllIllll, lllllllllllllllllIllIIIlIllIlllI);
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllllIllIIIlIIlIlIlI, final BlockPos lllllllllllllllllIllIIIlIIlIlIIl, final IBlockState lllllllllllllllllIllIIIlIIlIIIlI, final Block lllllllllllllllllIllIIIlIIlIIlll) {
        final EnumFacing lllllllllllllllllIllIIIlIIlIIllI = (EnumFacing)lllllllllllllllllIllIIIlIIlIIIlI.getValue(BlockLadder.field_176382_a);
        if (!this.func_176381_b(lllllllllllllllllIllIIIlIIlIlIlI, lllllllllllllllllIllIIIlIIlIlIIl, lllllllllllllllllIllIIIlIIlIIllI)) {
            this.dropBlockAsItem(lllllllllllllllllIllIIIlIIlIlIlI, lllllllllllllllllIllIIIlIIlIlIIl, lllllllllllllllllIllIIIlIIlIIIlI, 0);
            lllllllllllllllllIllIIIlIIlIlIlI.setBlockToAir(lllllllllllllllllIllIIIlIIlIlIIl);
        }
        super.onNeighborBlockChange(lllllllllllllllllIllIIIlIIlIlIlI, lllllllllllllllllIllIIIlIIlIlIIl, lllllllllllllllllIllIIIlIIlIIIlI, lllllllllllllllllIllIIIlIIlIIlll);
    }
    
    protected BlockLadder() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockLadder.field_176382_a, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllllIllIIIlIlIllIlI, final BlockPos lllllllllllllllllIllIIIlIlIlIlII) {
        final IBlockState lllllllllllllllllIllIIIlIlIllIII = lllllllllllllllllIllIIIlIlIllIlI.getBlockState(lllllllllllllllllIllIIIlIlIlIlII);
        if (lllllllllllllllllIllIIIlIlIllIII.getBlock() == this) {
            final float lllllllllllllllllIllIIIlIlIlIlll = 0.125f;
            switch (SwitchEnumFacing.field_180190_a[((EnumFacing)lllllllllllllllllIllIIIlIlIllIII.getValue(BlockLadder.field_176382_a)).ordinal()]) {
                case 1: {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - lllllllllllllllllIllIIIlIlIlIlll, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 2: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, lllllllllllllllllIllIIIlIlIlIlll);
                    break;
                }
                case 3: {
                    this.setBlockBounds(1.0f - lllllllllllllllllIllIIIlIlIlIlll, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                default: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, lllllllllllllllllIllIIIlIlIlIlll, 1.0f, 1.0f);
                    break;
                }
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIllIIIlIIIIllIl) {
        EnumFacing lllllllllllllllllIllIIIlIIIIllll = EnumFacing.getFront(lllllllllllllllllIllIIIlIIIIllIl);
        if (lllllllllllllllllIllIIIlIIIIllll.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllllllIllIIIlIIIIllll = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(BlockLadder.field_176382_a, lllllllllllllllllIllIIIlIIIIllll);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockLadder.field_176382_a });
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    protected boolean func_176381_b(final World lllllllllllllllllIllIIIlIIIllIII, final BlockPos lllllllllllllllllIllIIIlIIIlIlll, final EnumFacing lllllllllllllllllIllIIIlIIIlIllI) {
        return lllllllllllllllllIllIIIlIIIllIII.getBlockState(lllllllllllllllllIllIIIlIIIlIlll.offset(lllllllllllllllllIllIIIlIIIlIllI.getOpposite())).getBlock().isNormalCube();
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIllIIIlIIIIlIIl) {
        return ((EnumFacing)lllllllllllllllllIllIIIlIIIIlIIl.getValue(BlockLadder.field_176382_a)).getIndex();
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_180190_a;
        
        static {
            __OBFID = "CL_00002104";
            field_180190_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_180190_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_180190_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_180190_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_180190_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
