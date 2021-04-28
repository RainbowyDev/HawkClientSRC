package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;
import java.util.*;
import com.google.common.base.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class BlockStairs extends Block
{
    public static final /* synthetic */ PropertyEnum SHAPE;
    private /* synthetic */ int field_150153_O;
    public static final /* synthetic */ PropertyEnum HALF;
    public static final /* synthetic */ PropertyDirection FACING;
    private final /* synthetic */ Block modelBlock;
    private final /* synthetic */ IBlockState modelState;
    private /* synthetic */ boolean field_150152_N;
    private static final /* synthetic */ int[][] field_150150_a;
    
    @Override
    public void onBlockDestroyedByExplosion(final World lIIIIlIIIIIlII, final BlockPos lIIIIlIIIIIIll, final Explosion lIIIIlIIIIIllI) {
        this.modelBlock.onBlockDestroyedByExplosion(lIIIIlIIIIIlII, lIIIIlIIIIIIll, lIIIIlIIIIIllI);
    }
    
    public static boolean isSameStair(final IBlockAccess lIIIlIlIlIlIII, final BlockPos lIIIlIlIlIlllI, final IBlockState lIIIlIlIlIIllI) {
        final IBlockState lIIIlIlIlIlIll = lIIIlIlIlIlIII.getBlockState(lIIIlIlIlIlllI);
        final Block lIIIlIlIlIlIlI = lIIIlIlIlIlIll.getBlock();
        return isBlockStairs(lIIIlIlIlIlIlI) && lIIIlIlIlIlIll.getValue(BlockStairs.HALF) == lIIIlIlIlIIllI.getValue(BlockStairs.HALF) && lIIIlIlIlIlIll.getValue(BlockStairs.FACING) == lIIIlIlIlIIllI.getValue(BlockStairs.FACING);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lIIIIIllllllll) {
        return this.modelBlock.getMapColor(this.modelState);
    }
    
    @Override
    public Vec3 modifyAcceleration(final World lIIIIlIllIlIll, final BlockPos lIIIIlIllIlIlI, final Entity lIIIIlIllIlIIl, final Vec3 lIIIIlIllIlIII) {
        return this.modelBlock.modifyAcceleration(lIIIIlIllIlIll, lIIIIlIllIlIlI, lIIIIlIllIlIIl, lIIIIlIllIlIII);
    }
    
    @Override
    public int getMixedBrightnessForBlock(final IBlockAccess lIIIIllIIIlIll, final BlockPos lIIIIllIIIlIlI) {
        return this.modelBlock.getMixedBrightnessForBlock(lIIIIllIIIlIll, lIIIIllIIIlIlI);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lIIIIlIlIIllll, final BlockPos lIIIIlIlIIlllI) {
        return this.modelBlock.canPlaceBlockAt(lIIIIlIlIIllll, lIIIIlIlIIlllI);
    }
    
    @Override
    public float getExplosionResistance(final Entity lIIIIllIIIIllI) {
        return this.modelBlock.getExplosionResistance(lIIIIllIIIIllI);
    }
    
    @Override
    public void updateTick(final World lIIIIlIIlIIIlI, final BlockPos lIIIIlIIlIIIIl, final IBlockState lIIIIlIIlIIlIl, final Random lIIIIlIIlIIlII) {
        this.modelBlock.updateTick(lIIIIlIIlIIIlI, lIIIIlIIlIIIIl, lIIIIlIIlIIlIl, lIIIIlIIlIIlII);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockStairs.FACING, BlockStairs.HALF, BlockStairs.SHAPE });
    }
    
    @Override
    public void onBlockAdded(final World lIIIIlIlIIIlIl, final BlockPos lIIIIlIlIIIlII, final IBlockState lIIIIlIlIIIlll) {
        this.onNeighborBlockChange(lIIIIlIlIIIlIl, lIIIIlIlIIIlII, this.modelState, Blocks.air);
        this.modelBlock.onBlockAdded(lIIIIlIlIIIlIl, lIIIIlIlIIIlII, this.modelState);
    }
    
    @Override
    public boolean isCollidable() {
        return this.modelBlock.isCollidable();
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lIIIlIllIllIll, final BlockPos lIIIlIllIllIlI) {
        if (this.field_150152_N) {
            this.setBlockBounds(0.5f * (this.field_150153_O % 2), 0.5f * (this.field_150153_O / 4 % 2), 0.5f * (this.field_150153_O / 2 % 2), 0.5f + 0.5f * (this.field_150153_O % 2), 0.5f + 0.5f * (this.field_150153_O / 4 % 2), 0.5f + 0.5f * (this.field_150153_O / 2 % 2));
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lIIIIIllllIIlI, final BlockPos lIIIIIllllIIIl, final EnumFacing lIIIIIllllIIII, final float lIIIIIlllIIlIl, final float lIIIIIlllIIlII, final float lIIIIIlllIIIll, final int lIIIIIlllIIIlI, final EntityLivingBase lIIIIIlllIlIll) {
        IBlockState lIIIIIlllIlIlI = super.onBlockPlaced(lIIIIIllllIIlI, lIIIIIllllIIIl, lIIIIIllllIIII, lIIIIIlllIIlIl, lIIIIIlllIIlII, lIIIIIlllIIIll, lIIIIIlllIIIlI, lIIIIIlllIlIll);
        lIIIIIlllIlIlI = lIIIIIlllIlIlI.withProperty(BlockStairs.FACING, lIIIIIlllIlIll.func_174811_aO()).withProperty(BlockStairs.SHAPE, EnumShape.STRAIGHT);
        return (lIIIIIllllIIII != EnumFacing.DOWN && (lIIIIIllllIIII == EnumFacing.UP || lIIIIIlllIIlII <= 0.5)) ? lIIIIIlllIlIlI.withProperty(BlockStairs.HALF, EnumHalf.BOTTOM) : lIIIIIlllIlIlI.withProperty(BlockStairs.HALF, EnumHalf.TOP);
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World lIIIIllIIllIIl, final BlockPos lIIIIllIIllIII, final IBlockState lIIIIllIIlIlll) {
        this.modelBlock.onBlockDestroyedByPlayer(lIIIIllIIllIIl, lIIIIllIIllIII, lIIIIllIIlIlll);
    }
    
    @Override
    public void breakBlock(final World lIIIIlIIllllll, final BlockPos lIIIIlIIlllIlI, final IBlockState lIIIIlIIllllIl) {
        this.modelBlock.breakBlock(lIIIIlIIllllll, lIIIIlIIlllIlI, this.modelState);
    }
    
    protected BlockStairs(final IBlockState lIIIlIlllIllIl) {
        super(lIIIlIlllIllIl.getBlock().blockMaterial);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStairs.FACING, EnumFacing.NORTH).withProperty(BlockStairs.HALF, EnumHalf.BOTTOM).withProperty(BlockStairs.SHAPE, EnumShape.STRAIGHT));
        this.modelBlock = lIIIlIlllIllIl.getBlock();
        this.modelState = lIIIlIlllIllIl;
        this.setHardness(this.modelBlock.blockHardness);
        this.setResistance(this.modelBlock.blockResistance / 3.0f);
        this.setStepSound(this.modelBlock.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int tickRate(final World lIIIIlIllllIll) {
        return this.modelBlock.tickRate(lIIIIlIllllIll);
    }
    
    public void setBaseCollisionBounds(final IBlockAccess lIIIlIllIIllII, final BlockPos lIIIlIllIIIlII) {
        if (lIIIlIllIIllII.getBlockState(lIIIlIllIIIlII).getValue(BlockStairs.HALF) == EnumHalf.TOP) {
            this.setBlockBounds(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
    }
    
    @Override
    public MovingObjectPosition collisionRayTrace(final World lIIIIIllIIlIll, final BlockPos lIIIIIlIllIlII, final Vec3 lIIIIIlIllIIll, final Vec3 lIIIIIlIllIIlI) {
        final MovingObjectPosition[] lIIIIIllIIIlll = new MovingObjectPosition[8];
        final IBlockState lIIIIIllIIIllI = lIIIIIllIIlIll.getBlockState(lIIIIIlIllIlII);
        final int lIIIIIllIIIlIl = ((EnumFacing)lIIIIIllIIIllI.getValue(BlockStairs.FACING)).getHorizontalIndex();
        final boolean lIIIIIllIIIlII = lIIIIIllIIIllI.getValue(BlockStairs.HALF) == EnumHalf.TOP;
        final int[] lIIIIIllIIIIll = BlockStairs.field_150150_a[lIIIIIllIIIlIl + (lIIIIIllIIIlII ? 4 : 0)];
        this.field_150152_N = true;
        for (int lIIIIIllIIIIlI = 0; lIIIIIllIIIIlI < 8; ++lIIIIIllIIIIlI) {
            this.field_150153_O = lIIIIIllIIIIlI;
            if (Arrays.binarySearch(lIIIIIllIIIIll, lIIIIIllIIIIlI) < 0) {
                lIIIIIllIIIlll[lIIIIIllIIIIlI] = super.collisionRayTrace(lIIIIIllIIlIll, lIIIIIlIllIlII, lIIIIIlIllIIll, lIIIIIlIllIIlI);
            }
        }
        final int[] lIIIIIllIIIIIl = lIIIIIllIIIIll;
        for (int lIIIIIllIIIIII = lIIIIIllIIIIll.length, lIIIIIlIllllll = 0; lIIIIIlIllllll < lIIIIIllIIIIII; ++lIIIIIlIllllll) {
            final int lIIIIIlIlllllI = lIIIIIllIIIIIl[lIIIIIlIllllll];
            lIIIIIllIIIlll[lIIIIIlIlllllI] = null;
        }
        MovingObjectPosition lIIIIIlIllllIl = null;
        double lIIIIIlIllllII = 0.0;
        final MovingObjectPosition[] lIIIIIlIlllIll = lIIIIIllIIIlll;
        for (int lIIIIIlIlllIlI = lIIIIIllIIIlll.length, lIIIIIlIlllIIl = 0; lIIIIIlIlllIIl < lIIIIIlIlllIlI; ++lIIIIIlIlllIIl) {
            final MovingObjectPosition lIIIIIlIlllIII = lIIIIIlIlllIll[lIIIIIlIlllIIl];
            if (lIIIIIlIlllIII != null) {
                final double lIIIIIlIllIlll = lIIIIIlIlllIII.hitVec.squareDistanceTo(lIIIIIlIllIIlI);
                if (lIIIIIlIllIlll > lIIIIIlIllllII) {
                    lIIIIIlIllllIl = lIIIIIlIlllIII;
                    lIIIIIlIllllII = lIIIIIlIllIlll;
                }
            }
        }
        return lIIIIIlIllllIl;
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World lIIIIlIlllIllI, final BlockPos lIIIIlIlllIlIl) {
        return this.modelBlock.getSelectedBoundingBox(lIIIIlIlllIllI, lIIIIlIlllIlIl);
    }
    
    @Override
    public void addCollisionBoxesToList(final World lIIIIlllIIlIII, final BlockPos lIIIIllIllllll, final IBlockState lIIIIlllIIIllI, final AxisAlignedBB lIIIIllIllllIl, final List lIIIIlllIIIlII, final Entity lIIIIllIlllIll) {
        this.setBaseCollisionBounds(lIIIIlllIIlIII, lIIIIllIllllll);
        super.addCollisionBoxesToList(lIIIIlllIIlIII, lIIIIllIllllll, lIIIIlllIIIllI, lIIIIllIllllIl, lIIIIlllIIIlII, lIIIIllIlllIll);
        final boolean lIIIIlllIIIIlI = this.func_176306_h(lIIIIlllIIlIII, lIIIIllIllllll);
        super.addCollisionBoxesToList(lIIIIlllIIlIII, lIIIIllIllllll, lIIIIlllIIIllI, lIIIIllIllllIl, lIIIIlllIIIlII, lIIIIllIlllIll);
        if (lIIIIlllIIIIlI && this.func_176304_i(lIIIIlllIIlIII, lIIIIllIllllll)) {
            super.addCollisionBoxesToList(lIIIIlllIIlIII, lIIIIllIllllll, lIIIIlllIIIllI, lIIIIllIllllIl, lIIIIlllIIIlII, lIIIIllIlllIll);
        }
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public boolean func_176306_h(final IBlockAccess lIIIlIIIIlllIl, final BlockPos lIIIlIIIIlllII) {
        final IBlockState lIIIlIIIllIlIl = lIIIlIIIIlllIl.getBlockState(lIIIlIIIIlllII);
        final EnumFacing lIIIlIIIllIlII = (EnumFacing)lIIIlIIIllIlIl.getValue(BlockStairs.FACING);
        final EnumHalf lIIIlIIIllIIll = (EnumHalf)lIIIlIIIllIlIl.getValue(BlockStairs.HALF);
        final boolean lIIIlIIIllIIlI = lIIIlIIIllIIll == EnumHalf.TOP;
        float lIIIlIIIllIIIl = 0.5f;
        float lIIIlIIIllIIII = 1.0f;
        if (lIIIlIIIllIIlI) {
            lIIIlIIIllIIIl = 0.0f;
            lIIIlIIIllIIII = 0.5f;
        }
        float lIIIlIIIlIllll = 0.0f;
        float lIIIlIIIlIlllI = 1.0f;
        float lIIIlIIIlIllIl = 0.0f;
        float lIIIlIIIlIllII = 0.5f;
        boolean lIIIlIIIlIlIll = true;
        if (lIIIlIIIllIlII == EnumFacing.EAST) {
            lIIIlIIIlIllll = 0.5f;
            lIIIlIIIlIllII = 1.0f;
            final IBlockState lIIIlIIIlIlIlI = lIIIlIIIIlllIl.getBlockState(lIIIlIIIIlllII.offsetEast());
            final Block lIIIlIIIlIIllI = lIIIlIIIlIlIlI.getBlock();
            if (isBlockStairs(lIIIlIIIlIIllI) && lIIIlIIIllIIll == lIIIlIIIlIlIlI.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIIlIIIlI = (EnumFacing)lIIIlIIIlIlIlI.getValue(BlockStairs.FACING);
                if (lIIIlIIIlIIIlI == EnumFacing.NORTH && !isSameStair(lIIIlIIIIlllIl, lIIIlIIIIlllII.offsetSouth(), lIIIlIIIllIlIl)) {
                    lIIIlIIIlIllII = 0.5f;
                    lIIIlIIIlIlIll = false;
                }
                else if (lIIIlIIIlIIIlI == EnumFacing.SOUTH && !isSameStair(lIIIlIIIIlllIl, lIIIlIIIIlllII.offsetNorth(), lIIIlIIIllIlIl)) {
                    lIIIlIIIlIllIl = 0.5f;
                    lIIIlIIIlIlIll = false;
                }
            }
        }
        else if (lIIIlIIIllIlII == EnumFacing.WEST) {
            lIIIlIIIlIlllI = 0.5f;
            lIIIlIIIlIllII = 1.0f;
            final IBlockState lIIIlIIIlIlIIl = lIIIlIIIIlllIl.getBlockState(lIIIlIIIIlllII.offsetWest());
            final Block lIIIlIIIlIIlIl = lIIIlIIIlIlIIl.getBlock();
            if (isBlockStairs(lIIIlIIIlIIlIl) && lIIIlIIIllIIll == lIIIlIIIlIlIIl.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIIlIIIIl = (EnumFacing)lIIIlIIIlIlIIl.getValue(BlockStairs.FACING);
                if (lIIIlIIIlIIIIl == EnumFacing.NORTH && !isSameStair(lIIIlIIIIlllIl, lIIIlIIIIlllII.offsetSouth(), lIIIlIIIllIlIl)) {
                    lIIIlIIIlIllII = 0.5f;
                    lIIIlIIIlIlIll = false;
                }
                else if (lIIIlIIIlIIIIl == EnumFacing.SOUTH && !isSameStair(lIIIlIIIIlllIl, lIIIlIIIIlllII.offsetNorth(), lIIIlIIIllIlIl)) {
                    lIIIlIIIlIllIl = 0.5f;
                    lIIIlIIIlIlIll = false;
                }
            }
        }
        else if (lIIIlIIIllIlII == EnumFacing.SOUTH) {
            lIIIlIIIlIllIl = 0.5f;
            lIIIlIIIlIllII = 1.0f;
            final IBlockState lIIIlIIIlIlIII = lIIIlIIIIlllIl.getBlockState(lIIIlIIIIlllII.offsetSouth());
            final Block lIIIlIIIlIIlII = lIIIlIIIlIlIII.getBlock();
            if (isBlockStairs(lIIIlIIIlIIlII) && lIIIlIIIllIIll == lIIIlIIIlIlIII.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIIlIIIII = (EnumFacing)lIIIlIIIlIlIII.getValue(BlockStairs.FACING);
                if (lIIIlIIIlIIIII == EnumFacing.WEST && !isSameStair(lIIIlIIIIlllIl, lIIIlIIIIlllII.offsetEast(), lIIIlIIIllIlIl)) {
                    lIIIlIIIlIlllI = 0.5f;
                    lIIIlIIIlIlIll = false;
                }
                else if (lIIIlIIIlIIIII == EnumFacing.EAST && !isSameStair(lIIIlIIIIlllIl, lIIIlIIIIlllII.offsetWest(), lIIIlIIIllIlIl)) {
                    lIIIlIIIlIllll = 0.5f;
                    lIIIlIIIlIlIll = false;
                }
            }
        }
        else if (lIIIlIIIllIlII == EnumFacing.NORTH) {
            final IBlockState lIIIlIIIlIIlll = lIIIlIIIIlllIl.getBlockState(lIIIlIIIIlllII.offsetNorth());
            final Block lIIIlIIIlIIIll = lIIIlIIIlIIlll.getBlock();
            if (isBlockStairs(lIIIlIIIlIIIll) && lIIIlIIIllIIll == lIIIlIIIlIIlll.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIIIlllll = (EnumFacing)lIIIlIIIlIIlll.getValue(BlockStairs.FACING);
                if (lIIIlIIIIlllll == EnumFacing.WEST && !isSameStair(lIIIlIIIIlllIl, lIIIlIIIIlllII.offsetEast(), lIIIlIIIllIlIl)) {
                    lIIIlIIIlIlllI = 0.5f;
                    lIIIlIIIlIlIll = false;
                }
                else if (lIIIlIIIIlllll == EnumFacing.EAST && !isSameStair(lIIIlIIIIlllIl, lIIIlIIIIlllII.offsetWest(), lIIIlIIIllIlIl)) {
                    lIIIlIIIlIllll = 0.5f;
                    lIIIlIIIlIlIll = false;
                }
            }
        }
        this.setBlockBounds(lIIIlIIIlIllll, lIIIlIIIllIIIl, lIIIlIIIlIllIl, lIIIlIIIlIlllI, lIIIlIIIllIIII, lIIIlIIIlIllII);
        return lIIIlIIIlIlIll;
    }
    
    static {
        __OBFID = "CL_00000314";
        FACING = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
        HALF = PropertyEnum.create("half", EnumHalf.class);
        SHAPE = PropertyEnum.create("shape", EnumShape.class);
        field_150150_a = new int[][] { { 4, 5 }, { 5, 7 }, { 6, 7 }, { 4, 6 }, { 0, 1 }, { 1, 3 }, { 2, 3 }, { 0, 2 } };
    }
    
    public boolean func_176304_i(final IBlockAccess lIIIIllllIIIIl, final BlockPos lIIIIllllllIlI) {
        final IBlockState lIIIIllllllIIl = lIIIIllllIIIIl.getBlockState(lIIIIllllllIlI);
        final EnumFacing lIIIIllllllIII = (EnumFacing)lIIIIllllllIIl.getValue(BlockStairs.FACING);
        final EnumHalf lIIIIlllllIlll = (EnumHalf)lIIIIllllllIIl.getValue(BlockStairs.HALF);
        final boolean lIIIIlllllIllI = lIIIIlllllIlll == EnumHalf.TOP;
        float lIIIIlllllIlIl = 0.5f;
        float lIIIIlllllIlII = 1.0f;
        if (lIIIIlllllIllI) {
            lIIIIlllllIlIl = 0.0f;
            lIIIIlllllIlII = 0.5f;
        }
        float lIIIIlllllIIll = 0.0f;
        float lIIIIlllllIIlI = 0.5f;
        float lIIIIlllllIIIl = 0.5f;
        float lIIIIlllllIIII = 1.0f;
        boolean lIIIIllllIllll = false;
        if (lIIIIllllllIII == EnumFacing.EAST) {
            final IBlockState lIIIIllllIlllI = lIIIIllllIIIIl.getBlockState(lIIIIllllllIlI.offsetWest());
            final Block lIIIIllllIlIlI = lIIIIllllIlllI.getBlock();
            if (isBlockStairs(lIIIIllllIlIlI) && lIIIIlllllIlll == lIIIIllllIlllI.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIIllllIIllI = (EnumFacing)lIIIIllllIlllI.getValue(BlockStairs.FACING);
                if (lIIIIllllIIllI == EnumFacing.NORTH && !isSameStair(lIIIIllllIIIIl, lIIIIllllllIlI.offsetNorth(), lIIIIllllllIIl)) {
                    lIIIIlllllIIIl = 0.0f;
                    lIIIIlllllIIII = 0.5f;
                    lIIIIllllIllll = true;
                }
                else if (lIIIIllllIIllI == EnumFacing.SOUTH && !isSameStair(lIIIIllllIIIIl, lIIIIllllllIlI.offsetSouth(), lIIIIllllllIIl)) {
                    lIIIIlllllIIIl = 0.5f;
                    lIIIIlllllIIII = 1.0f;
                    lIIIIllllIllll = true;
                }
            }
        }
        else if (lIIIIllllllIII == EnumFacing.WEST) {
            final IBlockState lIIIIllllIllIl = lIIIIllllIIIIl.getBlockState(lIIIIllllllIlI.offsetEast());
            final Block lIIIIllllIlIIl = lIIIIllllIllIl.getBlock();
            if (isBlockStairs(lIIIIllllIlIIl) && lIIIIlllllIlll == lIIIIllllIllIl.getValue(BlockStairs.HALF)) {
                lIIIIlllllIIll = 0.5f;
                lIIIIlllllIIlI = 1.0f;
                final EnumFacing lIIIIllllIIlIl = (EnumFacing)lIIIIllllIllIl.getValue(BlockStairs.FACING);
                if (lIIIIllllIIlIl == EnumFacing.NORTH && !isSameStair(lIIIIllllIIIIl, lIIIIllllllIlI.offsetNorth(), lIIIIllllllIIl)) {
                    lIIIIlllllIIIl = 0.0f;
                    lIIIIlllllIIII = 0.5f;
                    lIIIIllllIllll = true;
                }
                else if (lIIIIllllIIlIl == EnumFacing.SOUTH && !isSameStair(lIIIIllllIIIIl, lIIIIllllllIlI.offsetSouth(), lIIIIllllllIIl)) {
                    lIIIIlllllIIIl = 0.5f;
                    lIIIIlllllIIII = 1.0f;
                    lIIIIllllIllll = true;
                }
            }
        }
        else if (lIIIIllllllIII == EnumFacing.SOUTH) {
            final IBlockState lIIIIllllIllII = lIIIIllllIIIIl.getBlockState(lIIIIllllllIlI.offsetNorth());
            final Block lIIIIllllIlIII = lIIIIllllIllII.getBlock();
            if (isBlockStairs(lIIIIllllIlIII) && lIIIIlllllIlll == lIIIIllllIllII.getValue(BlockStairs.HALF)) {
                lIIIIlllllIIIl = 0.0f;
                lIIIIlllllIIII = 0.5f;
                final EnumFacing lIIIIllllIIlII = (EnumFacing)lIIIIllllIllII.getValue(BlockStairs.FACING);
                if (lIIIIllllIIlII == EnumFacing.WEST && !isSameStair(lIIIIllllIIIIl, lIIIIllllllIlI.offsetWest(), lIIIIllllllIIl)) {
                    lIIIIllllIllll = true;
                }
                else if (lIIIIllllIIlII == EnumFacing.EAST && !isSameStair(lIIIIllllIIIIl, lIIIIllllllIlI.offsetEast(), lIIIIllllllIIl)) {
                    lIIIIlllllIIll = 0.5f;
                    lIIIIlllllIIlI = 1.0f;
                    lIIIIllllIllll = true;
                }
            }
        }
        else if (lIIIIllllllIII == EnumFacing.NORTH) {
            final IBlockState lIIIIllllIlIll = lIIIIllllIIIIl.getBlockState(lIIIIllllllIlI.offsetSouth());
            final Block lIIIIllllIIlll = lIIIIllllIlIll.getBlock();
            if (isBlockStairs(lIIIIllllIIlll) && lIIIIlllllIlll == lIIIIllllIlIll.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIIllllIIIll = (EnumFacing)lIIIIllllIlIll.getValue(BlockStairs.FACING);
                if (lIIIIllllIIIll == EnumFacing.WEST && !isSameStair(lIIIIllllIIIIl, lIIIIllllllIlI.offsetWest(), lIIIIllllllIIl)) {
                    lIIIIllllIllll = true;
                }
                else if (lIIIIllllIIIll == EnumFacing.EAST && !isSameStair(lIIIIllllIIIIl, lIIIIllllllIlI.offsetEast(), lIIIIllllllIIl)) {
                    lIIIIlllllIIll = 0.5f;
                    lIIIIlllllIIlI = 1.0f;
                    lIIIIllllIllll = true;
                }
            }
        }
        if (lIIIIllllIllll) {
            this.setBlockBounds(lIIIIlllllIIll, lIIIIlllllIlIl, lIIIIlllllIIIl, lIIIIlllllIIlI, lIIIIlllllIlII, lIIIIlllllIIII);
        }
        return lIIIIllllIllll;
    }
    
    @Override
    public IBlockState getActualState(IBlockState lIIIIIlIIIlIlI, final IBlockAccess lIIIIIlIIIllIl, final BlockPos lIIIIIlIIIlIII) {
        if (this.func_176306_h(lIIIIIlIIIllIl, lIIIIIlIIIlIII)) {
            switch (this.func_176305_g(lIIIIIlIIIllIl, lIIIIIlIIIlIII)) {
                case 0: {
                    lIIIIIlIIIlIlI = lIIIIIlIIIlIlI.withProperty(BlockStairs.SHAPE, EnumShape.STRAIGHT);
                    break;
                }
                case 1: {
                    lIIIIIlIIIlIlI = lIIIIIlIIIlIlI.withProperty(BlockStairs.SHAPE, EnumShape.INNER_RIGHT);
                    break;
                }
                case 2: {
                    lIIIIIlIIIlIlI = lIIIIIlIIIlIlI.withProperty(BlockStairs.SHAPE, EnumShape.INNER_LEFT);
                    break;
                }
            }
        }
        else {
            switch (this.func_176307_f(lIIIIIlIIIllIl, lIIIIIlIIIlIII)) {
                case 0: {
                    lIIIIIlIIIlIlI = lIIIIIlIIIlIlI.withProperty(BlockStairs.SHAPE, EnumShape.STRAIGHT);
                    break;
                }
                case 1: {
                    lIIIIIlIIIlIlI = lIIIIIlIIIlIlI.withProperty(BlockStairs.SHAPE, EnumShape.OUTER_RIGHT);
                    break;
                }
                case 2: {
                    lIIIIIlIIIlIlI = lIIIIIlIIIlIlI.withProperty(BlockStairs.SHAPE, EnumShape.OUTER_LEFT);
                    break;
                }
            }
        }
        return lIIIIIlIIIlIlI;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIIIIIlIIlIlll) {
        int lIIIIIlIIlIllI = 0;
        if (lIIIIIlIIlIlll.getValue(BlockStairs.HALF) == EnumHalf.TOP) {
            lIIIIIlIIlIllI |= 0x4;
        }
        lIIIIIlIIlIllI |= 5 - ((EnumFacing)lIIIIIlIIlIlll.getValue(BlockStairs.FACING)).getIndex();
        return lIIIIIlIIlIllI;
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState lIIIIlIlIllIll, final boolean lIIIIlIlIllIlI) {
        return this.modelBlock.canCollideCheck(lIIIIlIlIllIll, lIIIIlIlIllIlI);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lIIIIlIIllIlII, final BlockPos lIIIIlIIlIllll, final Entity lIIIIlIIllIIlI) {
        this.modelBlock.onEntityCollidedWithBlock(lIIIIlIIllIlII, lIIIIlIIlIllll, lIIIIlIIllIIlI);
    }
    
    public int func_176307_f(final IBlockAccess lIIIlIlIIIlIIl, final BlockPos lIIIlIIlllIllI) {
        final IBlockState lIIIlIlIIIIlll = lIIIlIlIIIlIIl.getBlockState(lIIIlIIlllIllI);
        final EnumFacing lIIIlIlIIIIllI = (EnumFacing)lIIIlIlIIIIlll.getValue(BlockStairs.FACING);
        final EnumHalf lIIIlIlIIIIlIl = (EnumHalf)lIIIlIlIIIIlll.getValue(BlockStairs.HALF);
        final boolean lIIIlIlIIIIlII = lIIIlIlIIIIlIl == EnumHalf.TOP;
        if (lIIIlIlIIIIllI == EnumFacing.EAST) {
            final IBlockState lIIIlIlIIIIIll = lIIIlIlIIIlIIl.getBlockState(lIIIlIIlllIllI.offsetEast());
            final Block lIIIlIIlllllll = lIIIlIlIIIIIll.getBlock();
            if (isBlockStairs(lIIIlIIlllllll) && lIIIlIlIIIIlIl == lIIIlIlIIIIIll.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIllllIll = (EnumFacing)lIIIlIlIIIIIll.getValue(BlockStairs.FACING);
                if (lIIIlIIllllIll == EnumFacing.NORTH && !isSameStair(lIIIlIlIIIlIIl, lIIIlIIlllIllI.offsetSouth(), lIIIlIlIIIIlll)) {
                    return lIIIlIlIIIIlII ? 1 : 2;
                }
                if (lIIIlIIllllIll == EnumFacing.SOUTH && !isSameStair(lIIIlIlIIIlIIl, lIIIlIIlllIllI.offsetNorth(), lIIIlIlIIIIlll)) {
                    return lIIIlIlIIIIlII ? 2 : 1;
                }
            }
        }
        else if (lIIIlIlIIIIllI == EnumFacing.WEST) {
            final IBlockState lIIIlIlIIIIIlI = lIIIlIlIIIlIIl.getBlockState(lIIIlIIlllIllI.offsetWest());
            final Block lIIIlIIllllllI = lIIIlIlIIIIIlI.getBlock();
            if (isBlockStairs(lIIIlIIllllllI) && lIIIlIlIIIIlIl == lIIIlIlIIIIIlI.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIllllIlI = (EnumFacing)lIIIlIlIIIIIlI.getValue(BlockStairs.FACING);
                if (lIIIlIIllllIlI == EnumFacing.NORTH && !isSameStair(lIIIlIlIIIlIIl, lIIIlIIlllIllI.offsetSouth(), lIIIlIlIIIIlll)) {
                    return lIIIlIlIIIIlII ? 2 : 1;
                }
                if (lIIIlIIllllIlI == EnumFacing.SOUTH && !isSameStair(lIIIlIlIIIlIIl, lIIIlIIlllIllI.offsetNorth(), lIIIlIlIIIIlll)) {
                    return lIIIlIlIIIIlII ? 1 : 2;
                }
            }
        }
        else if (lIIIlIlIIIIllI == EnumFacing.SOUTH) {
            final IBlockState lIIIlIlIIIIIIl = lIIIlIlIIIlIIl.getBlockState(lIIIlIIlllIllI.offsetSouth());
            final Block lIIIlIIlllllIl = lIIIlIlIIIIIIl.getBlock();
            if (isBlockStairs(lIIIlIIlllllIl) && lIIIlIlIIIIlIl == lIIIlIlIIIIIIl.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIllllIIl = (EnumFacing)lIIIlIlIIIIIIl.getValue(BlockStairs.FACING);
                if (lIIIlIIllllIIl == EnumFacing.WEST && !isSameStair(lIIIlIlIIIlIIl, lIIIlIIlllIllI.offsetEast(), lIIIlIlIIIIlll)) {
                    return lIIIlIlIIIIlII ? 2 : 1;
                }
                if (lIIIlIIllllIIl == EnumFacing.EAST && !isSameStair(lIIIlIlIIIlIIl, lIIIlIIlllIllI.offsetWest(), lIIIlIlIIIIlll)) {
                    return lIIIlIlIIIIlII ? 1 : 2;
                }
            }
        }
        else if (lIIIlIlIIIIllI == EnumFacing.NORTH) {
            final IBlockState lIIIlIlIIIIIII = lIIIlIlIIIlIIl.getBlockState(lIIIlIIlllIllI.offsetNorth());
            final Block lIIIlIIlllllII = lIIIlIlIIIIIII.getBlock();
            if (isBlockStairs(lIIIlIIlllllII) && lIIIlIlIIIIlIl == lIIIlIlIIIIIII.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIllllIII = (EnumFacing)lIIIlIlIIIIIII.getValue(BlockStairs.FACING);
                if (lIIIlIIllllIII == EnumFacing.WEST && !isSameStair(lIIIlIlIIIlIIl, lIIIlIIlllIllI.offsetEast(), lIIIlIlIIIIlll)) {
                    return lIIIlIlIIIIlII ? 1 : 2;
                }
                if (lIIIlIIllllIII == EnumFacing.EAST && !isSameStair(lIIIlIlIIIlIIl, lIIIlIIlllIllI.offsetWest(), lIIIlIlIIIIlll)) {
                    return lIIIlIlIIIIlII ? 2 : 1;
                }
            }
        }
        return 0;
    }
    
    @Override
    public boolean onBlockActivated(final World lIIIIlIIIllIIl, final BlockPos lIIIIlIIIllIII, final IBlockState lIIIIlIIIlIlll, final EntityPlayer lIIIIlIIIlIllI, final EnumFacing lIIIIlIIIlIlIl, final float lIIIIlIIIlIlII, final float lIIIIlIIIlIIll, final float lIIIIlIIIlIIlI) {
        return this.modelBlock.onBlockActivated(lIIIIlIIIllIIl, lIIIIlIIIllIII, this.modelState, lIIIIlIIIlIllI, EnumFacing.DOWN, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return this.modelBlock.getBlockLayer();
    }
    
    @Override
    public void onBlockClicked(final World lIIIIllIlIIlIl, final BlockPos lIIIIllIlIIIII, final EntityPlayer lIIIIllIIlllll) {
        this.modelBlock.onBlockClicked(lIIIIllIlIIlIl, lIIIIllIlIIIII, lIIIIllIIlllll);
    }
    
    public static boolean isBlockStairs(final Block lIIIlIlIlllllI) {
        return lIIIlIlIlllllI instanceof BlockStairs;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIIIIlIIlllll) {
        IBlockState lIIIIIlIIllllI = this.getDefaultState().withProperty(BlockStairs.HALF, ((lIIIIIlIIlllll & 0x4) > 0) ? EnumHalf.TOP : EnumHalf.BOTTOM);
        lIIIIIlIIllllI = lIIIIIlIIllllI.withProperty(BlockStairs.FACING, EnumFacing.getFront(5 - (lIIIIIlIIlllll & 0x3)));
        return lIIIIIlIIllllI;
    }
    
    public int func_176305_g(final IBlockAccess lIIIlIIllIIlII, final BlockPos lIIIlIIlIlIIIl) {
        final IBlockState lIIIlIIllIIIlI = lIIIlIIllIIlII.getBlockState(lIIIlIIlIlIIIl);
        final EnumFacing lIIIlIIllIIIIl = (EnumFacing)lIIIlIIllIIIlI.getValue(BlockStairs.FACING);
        final EnumHalf lIIIlIIllIIIII = (EnumHalf)lIIIlIIllIIIlI.getValue(BlockStairs.HALF);
        final boolean lIIIlIIlIlllll = lIIIlIIllIIIII == EnumHalf.TOP;
        if (lIIIlIIllIIIIl == EnumFacing.EAST) {
            final IBlockState lIIIlIIlIllllI = lIIIlIIllIIlII.getBlockState(lIIIlIIlIlIIIl.offsetWest());
            final Block lIIIlIIlIllIlI = lIIIlIIlIllllI.getBlock();
            if (isBlockStairs(lIIIlIIlIllIlI) && lIIIlIIllIIIII == lIIIlIIlIllllI.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIlIlIllI = (EnumFacing)lIIIlIIlIllllI.getValue(BlockStairs.FACING);
                if (lIIIlIIlIlIllI == EnumFacing.NORTH && !isSameStair(lIIIlIIllIIlII, lIIIlIIlIlIIIl.offsetNorth(), lIIIlIIllIIIlI)) {
                    return lIIIlIIlIlllll ? 1 : 2;
                }
                if (lIIIlIIlIlIllI == EnumFacing.SOUTH && !isSameStair(lIIIlIIllIIlII, lIIIlIIlIlIIIl.offsetSouth(), lIIIlIIllIIIlI)) {
                    return lIIIlIIlIlllll ? 2 : 1;
                }
            }
        }
        else if (lIIIlIIllIIIIl == EnumFacing.WEST) {
            final IBlockState lIIIlIIlIlllIl = lIIIlIIllIIlII.getBlockState(lIIIlIIlIlIIIl.offsetEast());
            final Block lIIIlIIlIllIIl = lIIIlIIlIlllIl.getBlock();
            if (isBlockStairs(lIIIlIIlIllIIl) && lIIIlIIllIIIII == lIIIlIIlIlllIl.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIlIlIlIl = (EnumFacing)lIIIlIIlIlllIl.getValue(BlockStairs.FACING);
                if (lIIIlIIlIlIlIl == EnumFacing.NORTH && !isSameStair(lIIIlIIllIIlII, lIIIlIIlIlIIIl.offsetNorth(), lIIIlIIllIIIlI)) {
                    return lIIIlIIlIlllll ? 2 : 1;
                }
                if (lIIIlIIlIlIlIl == EnumFacing.SOUTH && !isSameStair(lIIIlIIllIIlII, lIIIlIIlIlIIIl.offsetSouth(), lIIIlIIllIIIlI)) {
                    return lIIIlIIlIlllll ? 1 : 2;
                }
            }
        }
        else if (lIIIlIIllIIIIl == EnumFacing.SOUTH) {
            final IBlockState lIIIlIIlIlllII = lIIIlIIllIIlII.getBlockState(lIIIlIIlIlIIIl.offsetNorth());
            final Block lIIIlIIlIllIII = lIIIlIIlIlllII.getBlock();
            if (isBlockStairs(lIIIlIIlIllIII) && lIIIlIIllIIIII == lIIIlIIlIlllII.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIlIlIlII = (EnumFacing)lIIIlIIlIlllII.getValue(BlockStairs.FACING);
                if (lIIIlIIlIlIlII == EnumFacing.WEST && !isSameStair(lIIIlIIllIIlII, lIIIlIIlIlIIIl.offsetWest(), lIIIlIIllIIIlI)) {
                    return lIIIlIIlIlllll ? 2 : 1;
                }
                if (lIIIlIIlIlIlII == EnumFacing.EAST && !isSameStair(lIIIlIIllIIlII, lIIIlIIlIlIIIl.offsetEast(), lIIIlIIllIIIlI)) {
                    return lIIIlIIlIlllll ? 1 : 2;
                }
            }
        }
        else if (lIIIlIIllIIIIl == EnumFacing.NORTH) {
            final IBlockState lIIIlIIlIllIll = lIIIlIIllIIlII.getBlockState(lIIIlIIlIlIIIl.offsetSouth());
            final Block lIIIlIIlIlIlll = lIIIlIIlIllIll.getBlock();
            if (isBlockStairs(lIIIlIIlIlIlll) && lIIIlIIllIIIII == lIIIlIIlIllIll.getValue(BlockStairs.HALF)) {
                final EnumFacing lIIIlIIlIlIIll = (EnumFacing)lIIIlIIlIllIll.getValue(BlockStairs.FACING);
                if (lIIIlIIlIlIIll == EnumFacing.WEST && !isSameStair(lIIIlIIllIIlII, lIIIlIIlIlIIIl.offsetWest(), lIIIlIIllIIIlI)) {
                    return lIIIlIIlIlllll ? 1 : 2;
                }
                if (lIIIlIIlIlIIll == EnumFacing.EAST && !isSameStair(lIIIlIIllIIlII, lIIIlIIlIlIIIl.offsetEast(), lIIIlIIllIIIlI)) {
                    return lIIIlIIlIlllll ? 2 : 1;
                }
            }
        }
        return 0;
    }
    
    @Override
    public void randomDisplayTick(final World lIIIIllIlIlllI, final BlockPos lIIIIllIlIllIl, final IBlockState lIIIIllIllIIIl, final Random lIIIIllIlIlIll) {
        this.modelBlock.randomDisplayTick(lIIIIllIlIlllI, lIIIIllIlIllIl, lIIIIllIllIIIl, lIIIIllIlIlIll);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    public enum EnumShape implements IStringSerializable
    {
        OUTER_LEFT("OUTER_LEFT", 3, "OUTER_LEFT", 3, "outer_left");
        
        private final /* synthetic */ String field_176699_f;
        
        STRAIGHT("STRAIGHT", 0, "STRAIGHT", 0, "straight"), 
        INNER_LEFT("INNER_LEFT", 1, "INNER_LEFT", 1, "inner_left"), 
        INNER_RIGHT("INNER_RIGHT", 2, "INNER_RIGHT", 2, "inner_right"), 
        OUTER_RIGHT("OUTER_RIGHT", 4, "OUTER_RIGHT", 4, "outer_right");
        
        @Override
        public String toString() {
            return this.field_176699_f;
        }
        
        private EnumShape(final String lllllllllllllllIllllIlIIIlllIllI, final int lllllllllllllllIllllIlIIIlllIlIl, final String lllllllllllllllIllllIlIIIllllIlI, final int lllllllllllllllIllllIlIIIllllIIl, final String lllllllllllllllIllllIlIIIlllIlII) {
            this.field_176699_f = lllllllllllllllIllllIlIIIlllIlII;
        }
        
        static {
            __OBFID = "CL_00002061";
        }
        
        @Override
        public String getName() {
            return this.field_176699_f;
        }
    }
    
    public enum EnumHalf implements IStringSerializable
    {
        TOP("TOP", 0, "TOP", 0, "top"), 
        BOTTOM("BOTTOM", 1, "BOTTOM", 1, "bottom");
        
        private final /* synthetic */ String field_176709_c;
        
        @Override
        public String getName() {
            return this.field_176709_c;
        }
        
        static {
            __OBFID = "CL_00002062";
        }
        
        private EnumHalf(final String llllllllllllllIlllIllIIlllIIlllI, final int llllllllllllllIlllIllIIlllIIllIl, final String llllllllllllllIlllIllIIlllIlIIlI, final int llllllllllllllIlllIllIIlllIlIIIl, final String llllllllllllllIlllIllIIlllIIllII) {
            this.field_176709_c = llllllllllllllIlllIllIIlllIIllII;
        }
        
        @Override
        public String toString() {
            return this.field_176709_c;
        }
    }
}
