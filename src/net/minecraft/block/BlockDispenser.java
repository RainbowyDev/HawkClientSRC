package net.minecraft.block;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.inventory.*;
import net.minecraft.block.state.*;
import net.minecraft.dispenser.*;

public class BlockDispenser extends BlockContainer
{
    public static final /* synthetic */ RegistryDefaulted dispenseBehaviorRegistry;
    public static final /* synthetic */ PropertyBool TRIGGERED;
    protected /* synthetic */ Random rand;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public void updateTick(final World llllllllllllllIlIlllIIIlIlllIIlI, final BlockPos llllllllllllllIlIlllIIIlIlllIIIl, final IBlockState llllllllllllllIlIlllIIIlIlllIIII, final Random llllllllllllllIlIlllIIIlIllIllll) {
        if (!llllllllllllllIlIlllIIIlIlllIIlI.isRemote) {
            this.func_176439_d(llllllllllllllIlIlllIIIlIlllIIlI, llllllllllllllIlIlllIIIlIlllIIIl);
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIlIlllIIIlIllIlIlI, final int llllllllllllllIlIlllIIIlIllIlIIl) {
        return new TileEntityDispenser();
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIlIlllIIIlIlIlIIII, final BlockPos llllllllllllllIlIlllIIIlIlIIllll, final IBlockState llllllllllllllIlIlllIIIlIlIIlIII, final EntityLivingBase llllllllllllllIlIlllIIIlIlIIIlll, final ItemStack llllllllllllllIlIlllIIIlIlIIllII) {
        llllllllllllllIlIlllIIIlIlIlIIII.setBlockState(llllllllllllllIlIlllIIIlIlIIllll, llllllllllllllIlIlllIIIlIlIIlIII.withProperty(BlockDispenser.FACING, BlockPistonBase.func_180695_a(llllllllllllllIlIlllIIIlIlIlIIII, llllllllllllllIlIlllIIIlIlIIllll, llllllllllllllIlIlllIIIlIlIIIlll)), 2);
        if (llllllllllllllIlIlllIIIlIlIIllII.hasDisplayName()) {
            final TileEntity llllllllllllllIlIlllIIIlIlIIlIll = llllllllllllllIlIlllIIIlIlIlIIII.getTileEntity(llllllllllllllIlIlllIIIlIlIIllll);
            if (llllllllllllllIlIlllIIIlIlIIlIll instanceof TileEntityDispenser) {
                ((TileEntityDispenser)llllllllllllllIlIlllIIIlIlIIlIll).func_146018_a(llllllllllllllIlIlllIIIlIlIIllII.getDisplayName());
            }
        }
    }
    
    private void setDefaultDirection(final World llllllllllllllIlIlllIIIlllIIlIlI, final BlockPos llllllllllllllIlIlllIIIlllIIIIIl, final IBlockState llllllllllllllIlIlllIIIlllIIIIII) {
        if (!llllllllllllllIlIlllIIIlllIIlIlI.isRemote) {
            EnumFacing llllllllllllllIlIlllIIIlllIIIlll = (EnumFacing)llllllllllllllIlIlllIIIlllIIIIII.getValue(BlockDispenser.FACING);
            final boolean llllllllllllllIlIlllIIIlllIIIllI = llllllllllllllIlIlllIIIlllIIlIlI.getBlockState(llllllllllllllIlIlllIIIlllIIIIIl.offsetNorth()).getBlock().isFullBlock();
            final boolean llllllllllllllIlIlllIIIlllIIIlIl = llllllllllllllIlIlllIIIlllIIlIlI.getBlockState(llllllllllllllIlIlllIIIlllIIIIIl.offsetSouth()).getBlock().isFullBlock();
            if (llllllllllllllIlIlllIIIlllIIIlll == EnumFacing.NORTH && llllllllllllllIlIlllIIIlllIIIllI && !llllllllllllllIlIlllIIIlllIIIlIl) {
                llllllllllllllIlIlllIIIlllIIIlll = EnumFacing.SOUTH;
            }
            else if (llllllllllllllIlIlllIIIlllIIIlll == EnumFacing.SOUTH && llllllllllllllIlIlllIIIlllIIIlIl && !llllllllllllllIlIlllIIIlllIIIllI) {
                llllllllllllllIlIlllIIIlllIIIlll = EnumFacing.NORTH;
            }
            else {
                final boolean llllllllllllllIlIlllIIIlllIIIlII = llllllllllllllIlIlllIIIlllIIlIlI.getBlockState(llllllllllllllIlIlllIIIlllIIIIIl.offsetWest()).getBlock().isFullBlock();
                final boolean llllllllllllllIlIlllIIIlllIIIIll = llllllllllllllIlIlllIIIlllIIlIlI.getBlockState(llllllllllllllIlIlllIIIlllIIIIIl.offsetEast()).getBlock().isFullBlock();
                if (llllllllllllllIlIlllIIIlllIIIlll == EnumFacing.WEST && llllllllllllllIlIlllIIIlllIIIlII && !llllllllllllllIlIlllIIIlllIIIIll) {
                    llllllllllllllIlIlllIIIlllIIIlll = EnumFacing.EAST;
                }
                else if (llllllllllllllIlIlllIIIlllIIIlll == EnumFacing.EAST && llllllllllllllIlIlllIIIlllIIIIll && !llllllllllllllIlIlllIIIlllIIIlII) {
                    llllllllllllllIlIlllIIIlllIIIlll = EnumFacing.WEST;
                }
            }
            llllllllllllllIlIlllIIIlllIIlIlI.setBlockState(llllllllllllllIlIlllIIIlllIIIIIl, llllllllllllllIlIlllIIIlllIIIIII.withProperty(BlockDispenser.FACING, llllllllllllllIlIlllIIIlllIIIlll).withProperty(BlockDispenser.TRIGGERED, false), 2);
        }
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlIlllIIIllIllIlIl, final BlockPos llllllllllllllIlIlllIIIllIllIlII, final IBlockState llllllllllllllIlIlllIIIllIllIIll, final EntityPlayer llllllllllllllIlIlllIIIllIllIIlI, final EnumFacing llllllllllllllIlIlllIIIllIllIIIl, final float llllllllllllllIlIlllIIIllIllIIII, final float llllllllllllllIlIlllIIIllIlIllll, final float llllllllllllllIlIlllIIIllIlIlllI) {
        if (llllllllllllllIlIlllIIIllIllIlIl.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllIlIlllIIIllIlIllIl = llllllllllllllIlIlllIIIllIllIlIl.getTileEntity(llllllllllllllIlIlllIIIllIllIlII);
        if (llllllllllllllIlIlllIIIllIlIllIl instanceof TileEntityDispenser) {
            llllllllllllllIlIlllIIIllIllIIlI.displayGUIChest((IInventory)llllllllllllllIlIlllIIIllIlIllIl);
        }
        return true;
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIlIlllIIIlIIIlllIl, final BlockPos llllllllllllllIlIlllIIIlIIIllllI) {
        return Container.calcRedstoneFromInventory(llllllllllllllIlIlllIIIlIIIlllIl.getTileEntity(llllllllllllllIlIlllIIIlIIIllllI));
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIlIlllIIIlllIlIllI, final BlockPos llllllllllllllIlIlllIIIlllIlIlIl, final IBlockState llllllllllllllIlIlllIIIlllIllIII) {
        super.onBlockAdded(llllllllllllllIlIlllIIIlllIlIllI, llllllllllllllIlIlllIIIlllIlIlIl, llllllllllllllIlIlllIIIlllIllIII);
        this.setDefaultDirection(llllllllllllllIlIlllIIIlllIlIllI, llllllllllllllIlIlllIIIlllIlIlIl, llllllllllllllIlIlllIIIlllIllIII);
    }
    
    public static EnumFacing getFacing(final int llllllllllllllIlIlllIIIlIIlIIlII) {
        return EnumFacing.getFront(llllllllllllllIlIlllIIIlIIlIIlII & 0x7);
    }
    
    static {
        __OBFID = "CL_00000229";
        FACING = PropertyDirection.create("facing");
        TRIGGERED = PropertyBool.create("triggered");
        dispenseBehaviorRegistry = new RegistryDefaulted(new BehaviorDefaultDispenseItem());
    }
    
    protected BlockDispenser() {
        super(Material.rock);
        this.rand = new Random();
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDispenser.FACING, EnumFacing.NORTH).withProperty(BlockDispenser.TRIGGERED, false));
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    protected void func_176439_d(final World llllllllllllllIlIlllIIIllIIllllI, final BlockPos llllllllllllllIlIlllIIIllIIlllIl) {
        final BlockSourceImpl llllllllllllllIlIlllIIIllIIlllII = new BlockSourceImpl(llllllllllllllIlIlllIIIllIIllllI, llllllllllllllIlIlllIIIllIIlllIl);
        final TileEntityDispenser llllllllllllllIlIlllIIIllIIllIll = (TileEntityDispenser)llllllllllllllIlIlllIIIllIIlllII.getBlockTileEntity();
        if (llllllllllllllIlIlllIIIllIIllIll != null) {
            final int llllllllllllllIlIlllIIIllIIllIlI = llllllllllllllIlIlllIIIllIIllIll.func_146017_i();
            if (llllllllllllllIlIlllIIIllIIllIlI < 0) {
                llllllllllllllIlIlllIIIllIIllllI.playAuxSFX(1001, llllllllllllllIlIlllIIIllIIlllIl, 0);
            }
            else {
                final ItemStack llllllllllllllIlIlllIIIllIIllIIl = llllllllllllllIlIlllIIIllIIllIll.getStackInSlot(llllllllllllllIlIlllIIIllIIllIlI);
                final IBehaviorDispenseItem llllllllllllllIlIlllIIIllIIllIII = this.func_149940_a(llllllllllllllIlIlllIIIllIIllIIl);
                if (llllllllllllllIlIlllIIIllIIllIII != IBehaviorDispenseItem.itemDispenseBehaviorProvider) {
                    final ItemStack llllllllllllllIlIlllIIIllIIlIlll = llllllllllllllIlIlllIIIllIIllIII.dispense(llllllllllllllIlIlllIIIllIIlllII, llllllllllllllIlIlllIIIllIIllIIl);
                    llllllllllllllIlIlllIIIllIIllIll.setInventorySlotContents(llllllllllllllIlIlllIIIllIIllIlI, (llllllllllllllIlIlllIIIllIIlIlll.stackSize == 0) ? null : llllllllllllllIlIlllIIIllIIlIlll);
                }
            }
        }
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIlIlllIIIlIIlllIIl, final BlockPos llllllllllllllIlIlllIIIlIIllllIl, final IBlockState llllllllllllllIlIlllIIIlIIllIlll) {
        final TileEntity llllllllllllllIlIlllIIIlIIlllIll = llllllllllllllIlIlllIIIlIIlllIIl.getTileEntity(llllllllllllllIlIlllIIIlIIllllIl);
        if (llllllllllllllIlIlllIIIlIIlllIll instanceof TileEntityDispenser) {
            InventoryHelper.dropInventoryItems(llllllllllllllIlIlllIIIlIIlllIIl, llllllllllllllIlIlllIIIlIIllllIl, (IInventory)llllllllllllllIlIlllIIIlIIlllIll);
            llllllllllllllIlIlllIIIlIIlllIIl.updateComparatorOutputLevel(llllllllllllllIlIlllIIIlIIllllIl, this);
        }
        super.breakBlock(llllllllllllllIlIlllIIIlIIlllIIl, llllllllllllllIlIlllIIIlIIllllIl, llllllllllllllIlIlllIIIlIIllIlll);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIlIlllIIIlIllIIIll, final BlockPos llllllllllllllIlIlllIIIlIllIIIlI, final EnumFacing llllllllllllllIlIlllIIIlIllIIIIl, final float llllllllllllllIlIlllIIIlIllIIIII, final float llllllllllllllIlIlllIIIlIlIlllll, final float llllllllllllllIlIlllIIIlIlIllllI, final int llllllllllllllIlIlllIIIlIlIlllIl, final EntityLivingBase llllllllllllllIlIlllIIIlIlIlllII) {
        return this.getDefaultState().withProperty(BlockDispenser.FACING, BlockPistonBase.func_180695_a(llllllllllllllIlIlllIIIlIllIIIll, llllllllllllllIlIlllIIIlIllIIIlI, llllllllllllllIlIlllIIIlIlIlllII)).withProperty(BlockDispenser.TRIGGERED, false);
    }
    
    @Override
    public int tickRate(final World llllllllllllllIlIlllIIIllllIIIII) {
        return 4;
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIlIlllIIIlIllllIll, final BlockPos llllllllllllllIlIlllIIIlIllllIlI, final IBlockState llllllllllllllIlIlllIIIllIIIIIII, final Block llllllllllllllIlIlllIIIlIlllllll) {
        final boolean llllllllllllllIlIlllIIIlIllllllI = llllllllllllllIlIlllIIIlIllllIll.isBlockPowered(llllllllllllllIlIlllIIIlIllllIlI) || llllllllllllllIlIlllIIIlIllllIll.isBlockPowered(llllllllllllllIlIlllIIIlIllllIlI.offsetUp());
        final boolean llllllllllllllIlIlllIIIlIlllllIl = (boolean)llllllllllllllIlIlllIIIllIIIIIII.getValue(BlockDispenser.TRIGGERED);
        if (llllllllllllllIlIlllIIIlIllllllI && !llllllllllllllIlIlllIIIlIlllllIl) {
            llllllllllllllIlIlllIIIlIllllIll.scheduleUpdate(llllllllllllllIlIlllIIIlIllllIlI, this, this.tickRate(llllllllllllllIlIlllIIIlIllllIll));
            llllllllllllllIlIlllIIIlIllllIll.setBlockState(llllllllllllllIlIlllIIIlIllllIlI, llllllllllllllIlIlllIIIllIIIIIII.withProperty(BlockDispenser.TRIGGERED, true), 4);
        }
        else if (!llllllllllllllIlIlllIIIlIllllllI && llllllllllllllIlIlllIIIlIlllllIl) {
            llllllllllllllIlIlllIIIlIllllIll.setBlockState(llllllllllllllIlIlllIIIlIllllIlI, llllllllllllllIlIlllIIIllIIIIIII.withProperty(BlockDispenser.TRIGGERED, false), 4);
        }
    }
    
    protected IBehaviorDispenseItem func_149940_a(final ItemStack llllllllllllllIlIlllIIIllIIIlIlI) {
        return (IBehaviorDispenseItem)BlockDispenser.dispenseBehaviorRegistry.getObject((llllllllllllllIlIlllIIIllIIIlIlI == null) ? null : llllllllllllllIlIlllIIIllIIIlIlI.getItem());
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockDispenser.FACING, BlockDispenser.TRIGGERED });
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIlllIIIlIIIlIIIl) {
        return this.getDefaultState().withProperty(BlockDispenser.FACING, getFacing(llllllllllllllIlIlllIIIlIIIlIIIl)).withProperty(BlockDispenser.TRIGGERED, (llllllllllllllIlIlllIIIlIIIlIIIl & 0x8) > 0);
    }
    
    @Override
    public IBlockState getStateForEntityRender(final IBlockState llllllllllllllIlIlllIIIlIIIllIII) {
        return this.getDefaultState().withProperty(BlockDispenser.FACING, EnumFacing.SOUTH);
    }
    
    public static IPosition getDispensePosition(final IBlockSource llllllllllllllIlIlllIIIlIIllIIII) {
        final EnumFacing llllllllllllllIlIlllIIIlIIlIllll = getFacing(llllllllllllllIlIlllIIIlIIllIIII.getBlockMetadata());
        final double llllllllllllllIlIlllIIIlIIlIlllI = llllllllllllllIlIlllIIIlIIllIIII.getX() + 0.7 * llllllllllllllIlIlllIIIlIIlIllll.getFrontOffsetX();
        final double llllllllllllllIlIlllIIIlIIlIllIl = llllllllllllllIlIlllIIIlIIllIIII.getY() + 0.7 * llllllllllllllIlIlllIIIlIIlIllll.getFrontOffsetY();
        final double llllllllllllllIlIlllIIIlIIlIllII = llllllllllllllIlIlllIIIlIIllIIII.getZ() + 0.7 * llllllllllllllIlIlllIIIlIIlIllll.getFrontOffsetZ();
        return new PositionImpl(llllllllllllllIlIlllIIIlIIlIlllI, llllllllllllllIlIlllIIIlIIlIllIl, llllllllllllllIlIlllIIIlIIlIllII);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlllIIIlIIIIlIIl) {
        final byte llllllllllllllIlIlllIIIlIIIIlIll = 0;
        int llllllllllllllIlIlllIIIlIIIIlIlI = llllllllllllllIlIlllIIIlIIIIlIll | ((EnumFacing)llllllllllllllIlIlllIIIlIIIIlIIl.getValue(BlockDispenser.FACING)).getIndex();
        if (llllllllllllllIlIlllIIIlIIIIlIIl.getValue(BlockDispenser.TRIGGERED)) {
            llllllllllllllIlIlllIIIlIIIIlIlI |= 0x8;
        }
        return llllllllllllllIlIlllIIIlIIIIlIlI;
    }
}
