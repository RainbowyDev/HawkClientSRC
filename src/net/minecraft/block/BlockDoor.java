package net.minecraft.block;

import net.minecraft.item.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import java.util.*;
import com.google.common.base.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockDoor extends Block
{
    public static final /* synthetic */ PropertyEnum HINGEPOSITION_PROP;
    public static final /* synthetic */ PropertyBool OPEN_PROP;
    public static final /* synthetic */ PropertyBool POWERED_PROP;
    public static final /* synthetic */ PropertyDirection FACING_PROP;
    public static final /* synthetic */ PropertyEnum HALF_PROP;
    
    @Override
    public Item getItem(final World lllIlIIllIlIlII, final BlockPos lllIlIIllIlIIll) {
        return this.func_176509_j();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockDoor.HALF_PROP, BlockDoor.FACING_PROP, BlockDoor.OPEN_PROP, BlockDoor.HINGEPOSITION_PROP, BlockDoor.POWERED_PROP });
    }
    
    public static boolean func_176514_f(final IBlockAccess lllIlIIlIIlIlIl, final BlockPos lllIlIIlIIlIIlI) {
        return func_176516_g(func_176515_e(lllIlIIlIIlIlIl, lllIlIIlIIlIIlI));
    }
    
    protected BlockDoor(final Material lllIlIllIlIIlIl) {
        super(lllIlIllIlIIlIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDoor.FACING_PROP, EnumFacing.NORTH).withProperty(BlockDoor.OPEN_PROP, false).withProperty(BlockDoor.HINGEPOSITION_PROP, EnumHingePosition.LEFT).withProperty(BlockDoor.POWERED_PROP, false).withProperty(BlockDoor.HALF_PROP, EnumDoorHalf.LOWER));
    }
    
    public static EnumFacing func_176511_f(final int lllIlIIlIIIlIIl) {
        return EnumFacing.getHorizontal(lllIlIIlIIIlIIl & 0x3).rotateYCCW();
    }
    
    public static int func_176515_e(final IBlockAccess lllIlIIllllIIII, final BlockPos lllIlIIlllIIIlI) {
        final IBlockState lllIlIIlllIlllI = lllIlIIllllIIII.getBlockState(lllIlIIlllIIIlI);
        final int lllIlIIlllIllIl = lllIlIIlllIlllI.getBlock().getMetaFromState(lllIlIIlllIlllI);
        final boolean lllIlIIlllIllII = func_176518_i(lllIlIIlllIllIl);
        final IBlockState lllIlIIlllIlIll = lllIlIIllllIIII.getBlockState(lllIlIIlllIIIlI.offsetDown());
        final int lllIlIIlllIlIlI = lllIlIIlllIlIll.getBlock().getMetaFromState(lllIlIIlllIlIll);
        final int lllIlIIlllIlIIl = lllIlIIlllIllII ? lllIlIIlllIlIlI : lllIlIIlllIllIl;
        final IBlockState lllIlIIlllIlIII = lllIlIIllllIIII.getBlockState(lllIlIIlllIIIlI.offsetUp());
        final int lllIlIIlllIIlll = lllIlIIlllIlIII.getBlock().getMetaFromState(lllIlIIlllIlIII);
        final int lllIlIIlllIIllI = lllIlIIlllIllII ? lllIlIIlllIllIl : lllIlIIlllIIlll;
        final boolean lllIlIIlllIIlIl = (lllIlIIlllIIllI & 0x1) != 0x0;
        final boolean lllIlIIlllIIlII = (lllIlIIlllIIllI & 0x2) != 0x0;
        return func_176510_b(lllIlIIlllIlIIl) | (lllIlIIlllIllII ? 8 : 0) | (lllIlIIlllIIlIl ? 16 : 0) | (lllIlIIlllIIlII ? 32 : 0);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllIlIlIIIIIIll, final BlockPos lllIlIlIIIIIIlI) {
        return lllIlIlIIIIIIlI.getY() < 255 && (World.doesBlockHaveSolidTopSurface(lllIlIlIIIIIIll, lllIlIlIIIIIIlI.offsetDown()) && super.canPlaceBlockAt(lllIlIlIIIIIIll, lllIlIlIIIIIIlI) && super.canPlaceBlockAt(lllIlIlIIIIIIll, lllIlIlIIIIIIlI.offsetUp()));
    }
    
    @Override
    public boolean onBlockActivated(final World lllIlIlIllIIIIl, final BlockPos lllIlIlIlIlIlIl, IBlockState lllIlIlIlIlllll, final EntityPlayer lllIlIlIlIlIIll, final EnumFacing lllIlIlIlIlllIl, final float lllIlIlIlIlllII, final float lllIlIlIlIllIll, final float lllIlIlIlIllIlI) {
        if (this.blockMaterial == Material.iron) {
            return true;
        }
        final BlockPos lllIlIlIlIllIIl = (lllIlIlIlIlllll.getValue(BlockDoor.HALF_PROP) == EnumDoorHalf.LOWER) ? lllIlIlIlIlIlIl : lllIlIlIlIlIlIl.offsetDown();
        final IBlockState lllIlIlIlIllIII = lllIlIlIlIlIlIl.equals(lllIlIlIlIllIIl) ? lllIlIlIlIlllll : lllIlIlIllIIIIl.getBlockState(lllIlIlIlIllIIl);
        if (lllIlIlIlIllIII.getBlock() != this) {
            return false;
        }
        lllIlIlIlIlllll = lllIlIlIlIllIII.cycleProperty(BlockDoor.OPEN_PROP);
        lllIlIlIllIIIIl.setBlockState(lllIlIlIlIllIIl, lllIlIlIlIlllll, 2);
        lllIlIlIllIIIIl.markBlockRangeForRenderUpdate(lllIlIlIlIllIIl, lllIlIlIlIlIlIl);
        lllIlIlIllIIIIl.playAuxSFXAtEntity(lllIlIlIlIlIIll, ((boolean)lllIlIlIlIlllll.getValue(BlockDoor.OPEN_PROP)) ? 1003 : 1006, lllIlIlIlIlIlIl, 0);
        return true;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllIlIlIIIlIlll, final Random lllIlIlIIIllIlI, final int lllIlIlIIIllIIl) {
        return (lllIlIlIIIlIlll.getValue(BlockDoor.HALF_PROP) == EnumDoorHalf.UPPER) ? null : this.func_176509_j();
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllIlIllIIIIlll, final BlockPos lllIlIllIIIlIlI, final IBlockState lllIlIllIIIIlIl) {
        this.setBlockBoundsBasedOnState(lllIlIllIIIIlll, lllIlIllIIIlIlI);
        return super.getCollisionBoundingBox(lllIlIllIIIIlll, lllIlIllIIIlIlI, lllIlIllIIIIlIl);
    }
    
    public static EnumFacing func_176517_h(final IBlockAccess lllIlIIlIIIllIl, final BlockPos lllIlIIlIIIllII) {
        return func_176511_f(func_176515_e(lllIlIIlIIIllIl, lllIlIIlIIIllII));
    }
    
    @Override
    public int getMobilityFlag() {
        return 1;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllIlIlIlllllIl, final BlockPos lllIlIlIlllllII) {
        this.func_150011_b(func_176515_e(lllIlIlIlllllIl, lllIlIlIlllllII));
    }
    
    protected static int func_176510_b(final int lllIlIIlIIllIIl) {
        return lllIlIIlIIllIIl & 0x7;
    }
    
    protected static boolean func_176513_j(final int lllIlIIlIIIIIIl) {
        return (lllIlIIlIIIIIIl & 0x10) != 0x0;
    }
    
    @Override
    public void onNeighborBlockChange(final World lllIlIlIIllIIIl, final BlockPos lllIlIlIIllIIII, final IBlockState lllIlIlIIlIllll, final Block lllIlIlIIlIlllI) {
        if (lllIlIlIIlIllll.getValue(BlockDoor.HALF_PROP) == EnumDoorHalf.UPPER) {
            final BlockPos lllIlIlIIlIllIl = lllIlIlIIllIIII.offsetDown();
            final IBlockState lllIlIlIIlIllII = lllIlIlIIllIIIl.getBlockState(lllIlIlIIlIllIl);
            if (lllIlIlIIlIllII.getBlock() != this) {
                lllIlIlIIllIIIl.setBlockToAir(lllIlIlIIllIIII);
            }
            else if (lllIlIlIIlIlllI != this) {
                this.onNeighborBlockChange(lllIlIlIIllIIIl, lllIlIlIIlIllIl, lllIlIlIIlIllII, lllIlIlIIlIlllI);
            }
        }
        else {
            boolean lllIlIlIIlIlIll = false;
            final BlockPos lllIlIlIIlIlIlI = lllIlIlIIllIIII.offsetUp();
            final IBlockState lllIlIlIIlIlIIl = lllIlIlIIllIIIl.getBlockState(lllIlIlIIlIlIlI);
            if (lllIlIlIIlIlIIl.getBlock() != this) {
                lllIlIlIIllIIIl.setBlockToAir(lllIlIlIIllIIII);
                lllIlIlIIlIlIll = true;
            }
            if (!World.doesBlockHaveSolidTopSurface(lllIlIlIIllIIIl, lllIlIlIIllIIII.offsetDown())) {
                lllIlIlIIllIIIl.setBlockToAir(lllIlIlIIllIIII);
                lllIlIlIIlIlIll = true;
                if (lllIlIlIIlIlIIl.getBlock() == this) {
                    lllIlIlIIllIIIl.setBlockToAir(lllIlIlIIlIlIlI);
                }
            }
            if (lllIlIlIIlIlIll) {
                if (!lllIlIlIIllIIIl.isRemote) {
                    this.dropBlockAsItem(lllIlIlIIllIIIl, lllIlIlIIllIIII, lllIlIlIIlIllll, 0);
                }
            }
            else {
                final boolean lllIlIlIIlIlIII = lllIlIlIIllIIIl.isBlockPowered(lllIlIlIIllIIII) || lllIlIlIIllIIIl.isBlockPowered(lllIlIlIIlIlIlI);
                if ((lllIlIlIIlIlIII || lllIlIlIIlIlllI.canProvidePower()) && lllIlIlIIlIlllI != this && lllIlIlIIlIlIII != (boolean)lllIlIlIIlIlIIl.getValue(BlockDoor.POWERED_PROP)) {
                    lllIlIlIIllIIIl.setBlockState(lllIlIlIIlIlIlI, lllIlIlIIlIlIIl.withProperty(BlockDoor.POWERED_PROP, lllIlIlIIlIlIII), 2);
                    if (lllIlIlIIlIlIII != (boolean)lllIlIlIIlIllll.getValue(BlockDoor.OPEN_PROP)) {
                        lllIlIlIIllIIIl.setBlockState(lllIlIlIIllIIII, lllIlIlIIlIllll.withProperty(BlockDoor.OPEN_PROP, lllIlIlIIlIlIII), 2);
                        lllIlIlIIllIIIl.markBlockRangeForRenderUpdate(lllIlIlIIllIIII, lllIlIlIIllIIII);
                        lllIlIlIIllIIIl.playAuxSFXAtEntity(null, lllIlIlIIlIlIII ? 1003 : 1006, lllIlIlIIllIIII, 0);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllIlIllIIlllII, final BlockPos lllIlIllIIlllIl) {
        return func_176516_g(func_176515_e(lllIlIllIIlllII, lllIlIllIIlllIl));
    }
    
    protected static boolean func_176518_i(final int lllIlIIlIIIIIll) {
        return (lllIlIIlIIIIIll & 0x8) != 0x0;
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World lllIlIllIIlIlIl, final BlockPos lllIlIllIIlIlII) {
        this.setBlockBoundsBasedOnState(lllIlIllIIlIlIl, lllIlIllIIlIlII);
        return super.getSelectedBoundingBox(lllIlIllIIlIlIl, lllIlIllIIlIlII);
    }
    
    static {
        __OBFID = "CL_00000230";
        FACING_PROP = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
        OPEN_PROP = PropertyBool.create("open");
        HINGEPOSITION_PROP = PropertyEnum.create("hinge", EnumHingePosition.class);
        POWERED_PROP = PropertyBool.create("powered");
        HALF_PROP = PropertyEnum.create("half", EnumDoorHalf.class);
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllIlIIlIlIllll, final IBlockAccess lllIlIIlIllIlII, final BlockPos lllIlIIlIllIIll) {
        if (((IBlockState)lllIlIIlIlIllll).getValue(BlockDoor.HALF_PROP) == EnumDoorHalf.LOWER) {
            final IBlockState lllIlIIlIllIIlI = lllIlIIlIllIlII.getBlockState(lllIlIIlIllIIll.offsetUp());
            if (lllIlIIlIllIIlI.getBlock() == this) {
                lllIlIIlIlIllll = ((IBlockState)lllIlIIlIlIllll).withProperty(BlockDoor.HINGEPOSITION_PROP, lllIlIIlIllIIlI.getValue(BlockDoor.HINGEPOSITION_PROP)).withProperty(BlockDoor.POWERED_PROP, lllIlIIlIllIIlI.getValue(BlockDoor.POWERED_PROP));
            }
        }
        else {
            final IBlockState lllIlIIlIllIIIl = lllIlIIlIllIlII.getBlockState(lllIlIIlIllIIll.offsetDown());
            if (lllIlIIlIllIIIl.getBlock() == this) {
                lllIlIIlIlIllll = ((IBlockState)lllIlIIlIlIllll).withProperty(BlockDoor.FACING_PROP, lllIlIIlIllIIIl.getValue(BlockDoor.FACING_PROP)).withProperty(BlockDoor.OPEN_PROP, lllIlIIlIllIIIl.getValue(BlockDoor.OPEN_PROP));
            }
        }
        return (IBlockState)lllIlIIlIlIllll;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    public void func_176512_a(final World lllIlIlIlIIIIIl, final BlockPos lllIlIlIlIIIIII, final boolean lllIlIlIlIIIllI) {
        final IBlockState lllIlIlIlIIIlIl = lllIlIlIlIIIIIl.getBlockState(lllIlIlIlIIIIII);
        if (lllIlIlIlIIIlIl.getBlock() == this) {
            final BlockPos lllIlIlIlIIIlII = (lllIlIlIlIIIlIl.getValue(BlockDoor.HALF_PROP) == EnumDoorHalf.LOWER) ? lllIlIlIlIIIIII : lllIlIlIlIIIIII.offsetDown();
            final IBlockState lllIlIlIlIIIIll = (lllIlIlIlIIIIII == lllIlIlIlIIIlII) ? lllIlIlIlIIIlIl : lllIlIlIlIIIIIl.getBlockState(lllIlIlIlIIIlII);
            if (lllIlIlIlIIIIll.getBlock() == this && (boolean)lllIlIlIlIIIIll.getValue(BlockDoor.OPEN_PROP) != lllIlIlIlIIIllI) {
                lllIlIlIlIIIIIl.setBlockState(lllIlIlIlIIIlII, lllIlIlIlIIIIll.withProperty(BlockDoor.OPEN_PROP, lllIlIlIlIIIllI), 2);
                lllIlIlIlIIIIIl.markBlockRangeForRenderUpdate(lllIlIlIlIIIlII, lllIlIlIlIIIIII);
                lllIlIlIlIIIIIl.playAuxSFXAtEntity(null, lllIlIlIlIIIllI ? 1003 : 1006, lllIlIlIlIIIIII, 0);
            }
        }
    }
    
    private Item func_176509_j() {
        return (this == Blocks.iron_door) ? Items.iron_door : ((this == Blocks.spruce_door) ? Items.spruce_door : ((this == Blocks.birch_door) ? Items.birch_door : ((this == Blocks.jungle_door) ? Items.jungle_door : ((this == Blocks.acacia_door) ? Items.acacia_door : ((this == Blocks.dark_oak_door) ? Items.dark_oak_door : Items.oak_door)))));
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllIlIIlIlIIllI) {
        return ((lllIlIIlIlIIllI & 0x8) > 0) ? this.getDefaultState().withProperty(BlockDoor.HALF_PROP, EnumDoorHalf.UPPER).withProperty(BlockDoor.HINGEPOSITION_PROP, ((lllIlIIlIlIIllI & 0x1) > 0) ? EnumHingePosition.RIGHT : EnumHingePosition.LEFT).withProperty(BlockDoor.POWERED_PROP, (lllIlIIlIlIIllI & 0x2) > 0) : this.getDefaultState().withProperty(BlockDoor.HALF_PROP, EnumDoorHalf.LOWER).withProperty(BlockDoor.FACING_PROP, EnumFacing.getHorizontal(lllIlIIlIlIIllI & 0x3).rotateYCCW()).withProperty(BlockDoor.OPEN_PROP, (lllIlIIlIlIIllI & 0x4) > 0);
    }
    
    @Override
    public MovingObjectPosition collisionRayTrace(final World lllIlIlIIIIlIll, final BlockPos lllIlIlIIIIllll, final Vec3 lllIlIlIIIIlllI, final Vec3 lllIlIlIIIIlIII) {
        this.setBlockBoundsBasedOnState(lllIlIlIIIIlIll, lllIlIlIIIIllll);
        return super.collisionRayTrace(lllIlIlIIIIlIll, lllIlIlIIIIllll, lllIlIlIIIIlllI, lllIlIlIIIIlIII);
    }
    
    protected static boolean func_176516_g(final int lllIlIIlIIIIlll) {
        return (lllIlIIlIIIIlll & 0x4) != 0x0;
    }
    
    private void func_150011_b(final int lllIlIlIlllIlII) {
        final float lllIlIlIlllIIll = 0.1875f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        final EnumFacing lllIlIlIlllIIlI = func_176511_f(lllIlIlIlllIlII);
        final boolean lllIlIlIlllIIIl = func_176516_g(lllIlIlIlllIlII);
        final boolean lllIlIlIlllIIII = func_176513_j(lllIlIlIlllIlII);
        if (lllIlIlIlllIIIl) {
            if (lllIlIlIlllIIlI == EnumFacing.EAST) {
                if (!lllIlIlIlllIIII) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, lllIlIlIlllIIll);
                }
                else {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - lllIlIlIlllIIll, 1.0f, 1.0f, 1.0f);
                }
            }
            else if (lllIlIlIlllIIlI == EnumFacing.SOUTH) {
                if (!lllIlIlIlllIIII) {
                    this.setBlockBounds(1.0f - lllIlIlIlllIIll, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
                else {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, lllIlIlIlllIIll, 1.0f, 1.0f);
                }
            }
            else if (lllIlIlIlllIIlI == EnumFacing.WEST) {
                if (!lllIlIlIlllIIII) {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - lllIlIlIlllIIll, 1.0f, 1.0f, 1.0f);
                }
                else {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, lllIlIlIlllIIll);
                }
            }
            else if (lllIlIlIlllIIlI == EnumFacing.NORTH) {
                if (!lllIlIlIlllIIII) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, lllIlIlIlllIIll, 1.0f, 1.0f);
                }
                else {
                    this.setBlockBounds(1.0f - lllIlIlIlllIIll, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
            }
        }
        else if (lllIlIlIlllIIlI == EnumFacing.EAST) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, lllIlIlIlllIIll, 1.0f, 1.0f);
        }
        else if (lllIlIlIlllIIlI == EnumFacing.SOUTH) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, lllIlIlIlllIIll);
        }
        else if (lllIlIlIlllIIlI == EnumFacing.WEST) {
            this.setBlockBounds(1.0f - lllIlIlIlllIIll, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        else if (lllIlIlIlllIIlI == EnumFacing.NORTH) {
            this.setBlockBounds(0.0f, 0.0f, 1.0f - lllIlIlIlllIIll, 1.0f, 1.0f, 1.0f);
        }
    }
    
    @Override
    public void onBlockHarvested(final World lllIlIIllIIIlll, final BlockPos lllIlIIllIIIIII, final IBlockState lllIlIIlIllllll, final EntityPlayer lllIlIIllIIIlII) {
        final BlockPos lllIlIIllIIIIll = lllIlIIllIIIIII.offsetDown();
        if (lllIlIIllIIIlII.capabilities.isCreativeMode && lllIlIIlIllllll.getValue(BlockDoor.HALF_PROP) == EnumDoorHalf.UPPER && lllIlIIllIIIlll.getBlockState(lllIlIIllIIIIll).getBlock() == this) {
            lllIlIIllIIIlll.setBlockToAir(lllIlIIllIIIIll);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllIlIIlIIlllIl) {
        final byte lllIlIIlIlIIIII = 0;
        int lllIlIIlIIllllI = 0;
        if (lllIlIIlIIlllIl.getValue(BlockDoor.HALF_PROP) == EnumDoorHalf.UPPER) {
            int lllIlIIlIIlllll = lllIlIIlIlIIIII | 0x8;
            if (lllIlIIlIIlllIl.getValue(BlockDoor.HINGEPOSITION_PROP) == EnumHingePosition.RIGHT) {
                lllIlIIlIIlllll |= 0x1;
            }
            if (lllIlIIlIIlllIl.getValue(BlockDoor.POWERED_PROP)) {
                lllIlIIlIIlllll |= 0x2;
            }
        }
        else {
            lllIlIIlIIllllI = (lllIlIIlIlIIIII | ((EnumFacing)lllIlIIlIIlllIl.getValue(BlockDoor.FACING_PROP)).rotateY().getHorizontalIndex());
            if (lllIlIIlIIlllIl.getValue(BlockDoor.OPEN_PROP)) {
                lllIlIIlIIllllI |= 0x4;
            }
        }
        return lllIlIIlIIllllI;
    }
    
    public enum EnumDoorHalf implements IStringSerializable
    {
        UPPER("UPPER", 0, "UPPER", 0), 
        LOWER("LOWER", 1, "LOWER", 1);
        
        @Override
        public String getName() {
            return (this == EnumDoorHalf.UPPER) ? "upper" : "lower";
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        private EnumDoorHalf(final String llllllllllllllIlIlIlllIlIllIlIII, final int llllllllllllllIlIlIlllIlIllIIlll, final String llllllllllllllIlIlIlllIlIllIlIll, final int llllllllllllllIlIlIlllIlIllIlIlI) {
        }
        
        static {
            __OBFID = "CL_00002124";
        }
    }
    
    public enum EnumHingePosition implements IStringSerializable
    {
        RIGHT("RIGHT", 1, "RIGHT", 1), 
        LEFT("LEFT", 0, "LEFT", 0);
        
        private EnumHingePosition(final String llllllllllllllIIlIlIllIllIlIlIII, final int llllllllllllllIIlIlIllIllIlIIlll, final String llllllllllllllIIlIlIllIllIlIlIll, final int llllllllllllllIIlIlIllIllIlIlIlI) {
        }
        
        static {
            __OBFID = "CL_00002123";
        }
        
        @Override
        public String getName() {
            return (this == EnumHingePosition.LEFT) ? "left" : "right";
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
    }
}
