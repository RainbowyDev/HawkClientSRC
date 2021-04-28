package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.block.material.*;
import com.google.common.base.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class BlockFurnace extends BlockContainer
{
    private static /* synthetic */ boolean field_149934_M;
    public static final /* synthetic */ PropertyDirection FACING;
    private final /* synthetic */ boolean isBurning;
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIlIllIIIlIllIIIlI, final BlockPos llllllllllllllIIlIllIIIlIllIIIIl, final EnumFacing llllllllllllllIIlIllIIIlIllIIIII, final float llllllllllllllIIlIllIIIlIlIlllll, final float llllllllllllllIIlIllIIIlIlIllllI, final float llllllllllllllIIlIllIIIlIlIlllIl, final int llllllllllllllIIlIllIIIlIlIllIll, final EntityLivingBase llllllllllllllIIlIllIIIlIlIlIllI) {
        return this.getDefaultState().withProperty(BlockFurnace.FACING, llllllllllllllIIlIllIIIlIlIlIllI.func_174811_aO().getOpposite());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIlIllIIIlIIIIIlII) {
        EnumFacing llllllllllllllIIlIllIIIlIIIIIllI = EnumFacing.getFront(llllllllllllllIIlIllIIIlIIIIIlII);
        if (llllllllllllllIIlIllIIIlIIIIIllI.getAxis() == EnumFacing.Axis.Y) {
            llllllllllllllIIlIllIIIlIIIIIllI = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(BlockFurnace.FACING, llllllllllllllIIlIllIIIlIIIIIllI);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIlIllIIIIllllllll) {
        return ((EnumFacing)llllllllllllllIIlIllIIIIllllllll.getValue(BlockFurnace.FACING)).getIndex();
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIIlIllIIIlIIlIIlII, final BlockPos llllllllllllllIIlIllIIIlIIlIIIll, final IBlockState llllllllllllllIIlIllIIIlIIlIIIlI) {
        if (!BlockFurnace.field_149934_M) {
            final TileEntity llllllllllllllIIlIllIIIlIIlIIIIl = llllllllllllllIIlIllIIIlIIlIIlII.getTileEntity(llllllllllllllIIlIllIIIlIIlIIIll);
            if (llllllllllllllIIlIllIIIlIIlIIIIl instanceof TileEntityFurnace) {
                InventoryHelper.dropInventoryItems(llllllllllllllIIlIllIIIlIIlIIlII, llllllllllllllIIlIllIIIlIIlIIIll, (IInventory)llllllllllllllIIlIllIIIlIIlIIIIl);
                llllllllllllllIIlIllIIIlIIlIIlII.updateComparatorOutputLevel(llllllllllllllIIlIllIIIlIIlIIIll, this);
            }
        }
        super.breakBlock(llllllllllllllIIlIllIIIlIIlIIlII, llllllllllllllIIlIllIIIlIIlIIIll, llllllllllllllIIlIllIIIlIIlIIIlI);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockFurnace.FACING });
    }
    
    private void func_176445_e(final World llllllllllllllIIlIllIIIlllIlIlII, final BlockPos llllllllllllllIIlIllIIIlllIlIIll, final IBlockState llllllllllllllIIlIllIIIlllIIlIlI) {
        if (!llllllllllllllIIlIllIIIlllIlIlII.isRemote) {
            final Block llllllllllllllIIlIllIIIlllIlIIIl = llllllllllllllIIlIllIIIlllIlIlII.getBlockState(llllllllllllllIIlIllIIIlllIlIIll.offsetNorth()).getBlock();
            final Block llllllllllllllIIlIllIIIlllIlIIII = llllllllllllllIIlIllIIIlllIlIlII.getBlockState(llllllllllllllIIlIllIIIlllIlIIll.offsetSouth()).getBlock();
            final Block llllllllllllllIIlIllIIIlllIIllll = llllllllllllllIIlIllIIIlllIlIlII.getBlockState(llllllllllllllIIlIllIIIlllIlIIll.offsetWest()).getBlock();
            final Block llllllllllllllIIlIllIIIlllIIlllI = llllllllllllllIIlIllIIIlllIlIlII.getBlockState(llllllllllllllIIlIllIIIlllIlIIll.offsetEast()).getBlock();
            EnumFacing llllllllllllllIIlIllIIIlllIIllIl = (EnumFacing)llllllllllllllIIlIllIIIlllIIlIlI.getValue(BlockFurnace.FACING);
            if (llllllllllllllIIlIllIIIlllIIllIl == EnumFacing.NORTH && llllllllllllllIIlIllIIIlllIlIIIl.isFullBlock() && !llllllllllllllIIlIllIIIlllIlIIII.isFullBlock()) {
                llllllllllllllIIlIllIIIlllIIllIl = EnumFacing.SOUTH;
            }
            else if (llllllllllllllIIlIllIIIlllIIllIl == EnumFacing.SOUTH && llllllllllllllIIlIllIIIlllIlIIII.isFullBlock() && !llllllllllllllIIlIllIIIlllIlIIIl.isFullBlock()) {
                llllllllllllllIIlIllIIIlllIIllIl = EnumFacing.NORTH;
            }
            else if (llllllllllllllIIlIllIIIlllIIllIl == EnumFacing.WEST && llllllllllllllIIlIllIIIlllIIllll.isFullBlock() && !llllllllllllllIIlIllIIIlllIIlllI.isFullBlock()) {
                llllllllllllllIIlIllIIIlllIIllIl = EnumFacing.EAST;
            }
            else if (llllllllllllllIIlIllIIIlllIIllIl == EnumFacing.EAST && llllllllllllllIIlIllIIIlllIIlllI.isFullBlock() && !llllllllllllllIIlIllIIIlllIIllll.isFullBlock()) {
                llllllllllllllIIlIllIIIlllIIllIl = EnumFacing.WEST;
            }
            llllllllllllllIIlIllIIIlllIlIlII.setBlockState(llllllllllllllIIlIllIIIlllIlIIll, llllllllllllllIIlIllIIIlllIIlIlI.withProperty(BlockFurnace.FACING, llllllllllllllIIlIllIIIlllIIllIl), 2);
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlIllIIIllllIllII, final Random llllllllllllllIIlIllIIIllllIlIll, final int llllllllllllllIIlIllIIIllllIlIlI) {
        return Item.getItemFromBlock(Blocks.furnace);
    }
    
    @Override
    public void randomDisplayTick(final World llllllllllllllIIlIllIIIllIlllIII, final BlockPos llllllllllllllIIlIllIIIllIlIllII, final IBlockState llllllllllllllIIlIllIIIllIlIlIll, final Random llllllllllllllIIlIllIIIllIlIlIlI) {
        if (this.isBurning) {
            final EnumFacing llllllllllllllIIlIllIIIllIllIlII = (EnumFacing)llllllllllllllIIlIllIIIllIlIlIll.getValue(BlockFurnace.FACING);
            final double llllllllllllllIIlIllIIIllIllIIll = llllllllllllllIIlIllIIIllIlIllII.getX() + 0.5;
            final double llllllllllllllIIlIllIIIllIllIIlI = llllllllllllllIIlIllIIIllIlIllII.getY() + llllllllllllllIIlIllIIIllIlIlIlI.nextDouble() * 6.0 / 16.0;
            final double llllllllllllllIIlIllIIIllIllIIIl = llllllllllllllIIlIllIIIllIlIllII.getZ() + 0.5;
            final double llllllllllllllIIlIllIIIllIllIIII = 0.52;
            final double llllllllllllllIIlIllIIIllIlIllll = llllllllllllllIIlIllIIIllIlIlIlI.nextDouble() * 0.6 - 0.3;
            switch (SwitchEnumFacing.field_180356_a[llllllllllllllIIlIllIIIllIllIlII.ordinal()]) {
                case 1: {
                    llllllllllllllIIlIllIIIllIlllIII.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIIlIllIIIllIllIIll - llllllllllllllIIlIllIIIllIllIIII, llllllllllllllIIlIllIIIllIllIIlI, llllllllllllllIIlIllIIIllIllIIIl + llllllllllllllIIlIllIIIllIlIllll, 0.0, 0.0, 0.0, new int[0]);
                    llllllllllllllIIlIllIIIllIlllIII.spawnParticle(EnumParticleTypes.FLAME, llllllllllllllIIlIllIIIllIllIIll - llllllllllllllIIlIllIIIllIllIIII, llllllllllllllIIlIllIIIllIllIIlI, llllllllllllllIIlIllIIIllIllIIIl + llllllllllllllIIlIllIIIllIlIllll, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 2: {
                    llllllllllllllIIlIllIIIllIlllIII.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIIlIllIIIllIllIIll + llllllllllllllIIlIllIIIllIllIIII, llllllllllllllIIlIllIIIllIllIIlI, llllllllllllllIIlIllIIIllIllIIIl + llllllllllllllIIlIllIIIllIlIllll, 0.0, 0.0, 0.0, new int[0]);
                    llllllllllllllIIlIllIIIllIlllIII.spawnParticle(EnumParticleTypes.FLAME, llllllllllllllIIlIllIIIllIllIIll + llllllllllllllIIlIllIIIllIllIIII, llllllllllllllIIlIllIIIllIllIIlI, llllllllllllllIIlIllIIIllIllIIIl + llllllllllllllIIlIllIIIllIlIllll, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 3: {
                    llllllllllllllIIlIllIIIllIlllIII.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIIlIllIIIllIllIIll + llllllllllllllIIlIllIIIllIlIllll, llllllllllllllIIlIllIIIllIllIIlI, llllllllllllllIIlIllIIIllIllIIIl - llllllllllllllIIlIllIIIllIllIIII, 0.0, 0.0, 0.0, new int[0]);
                    llllllllllllllIIlIllIIIllIlllIII.spawnParticle(EnumParticleTypes.FLAME, llllllllllllllIIlIllIIIllIllIIll + llllllllllllllIIlIllIIIllIlIllll, llllllllllllllIIlIllIIIllIllIIlI, llllllllllllllIIlIllIIIllIllIIIl - llllllllllllllIIlIllIIIllIllIIII, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 4: {
                    llllllllllllllIIlIllIIIllIlllIII.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIIlIllIIIllIllIIll + llllllllllllllIIlIllIIIllIlIllll, llllllllllllllIIlIllIIIllIllIIlI, llllllllllllllIIlIllIIIllIllIIIl + llllllllllllllIIlIllIIIllIllIIII, 0.0, 0.0, 0.0, new int[0]);
                    llllllllllllllIIlIllIIIllIlllIII.spawnParticle(EnumParticleTypes.FLAME, llllllllllllllIIlIllIIIllIllIIll + llllllllllllllIIlIllIIIllIlIllll, llllllllllllllIIlIllIIIllIllIIlI, llllllllllllllIIlIllIIIllIllIIIl + llllllllllllllIIlIllIIIllIllIIII, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
            }
        }
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIIlIllIIIlIIIlIlll, final BlockPos llllllllllllllIIlIllIIIlIIIlIlII) {
        return Container.calcRedstoneFromInventory(llllllllllllllIIlIllIIIlIIIlIlll.getTileEntity(llllllllllllllIIlIllIIIlIIIlIlII));
    }
    
    @Override
    public IBlockState getStateForEntityRender(final IBlockState llllllllllllllIIlIllIIIlIIIIllIl) {
        return this.getDefaultState().withProperty(BlockFurnace.FACING, EnumFacing.SOUTH);
    }
    
    protected BlockFurnace(final boolean llllllllllllllIIlIllIIIlllllIIII) {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFurnace.FACING, EnumFacing.NORTH));
        this.isBurning = llllllllllllllIIlIllIIIlllllIIII;
    }
    
    static {
        __OBFID = "CL_00000248";
        FACING = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIIlIllIIIllllIIlII, final BlockPos llllllllllllllIIlIllIIIlllIlllll, final IBlockState llllllllllllllIIlIllIIIllllIIIlI) {
        this.func_176445_e(llllllllllllllIIlIllIIIllllIIlII, llllllllllllllIIlIllIIIlllIlllll, llllllllllllllIIlIllIIIllllIIIlI);
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIlIllIIIllIIlIIll, final BlockPos llllllllllllllIIlIllIIIllIIlIIlI, final IBlockState llllllllllllllIIlIllIIIllIIllIll, final EntityPlayer llllllllllllllIIlIllIIIllIIlIIIl, final EnumFacing llllllllllllllIIlIllIIIllIIllIIl, final float llllllllllllllIIlIllIIIllIIlIlll, final float llllllllllllllIIlIllIIIllIIlIllI, final float llllllllllllllIIlIllIIIllIIlIlIl) {
        if (llllllllllllllIIlIllIIIllIIlIIll.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllIIlIllIIIllIIlIlII = llllllllllllllIIlIllIIIllIIlIIll.getTileEntity(llllllllllllllIIlIllIIIllIIlIIlI);
        if (llllllllllllllIIlIllIIIllIIlIlII instanceof TileEntityFurnace) {
            llllllllllllllIIlIllIIIllIIlIIIl.displayGUIChest((IInventory)llllllllllllllIIlIllIIIllIIlIlII);
        }
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIlIllIIIlIllIIlll, final int llllllllllllllIIlIllIIIlIllIIllI) {
        return new TileEntityFurnace();
    }
    
    public static void func_176446_a(final boolean llllllllllllllIIlIllIIIlIlllIlll, final World llllllllllllllIIlIllIIIlIllIllII, final BlockPos llllllllllllllIIlIllIIIlIlllIIll) {
        final IBlockState llllllllllllllIIlIllIIIlIlllIIIl = llllllllllllllIIlIllIIIlIllIllII.getBlockState(llllllllllllllIIlIllIIIlIlllIIll);
        final TileEntity llllllllllllllIIlIllIIIlIllIllll = llllllllllllllIIlIllIIIlIllIllII.getTileEntity(llllllllllllllIIlIllIIIlIlllIIll);
        BlockFurnace.field_149934_M = true;
        if (llllllllllllllIIlIllIIIlIlllIlll) {
            llllllllllllllIIlIllIIIlIllIllII.setBlockState(llllllllllllllIIlIllIIIlIlllIIll, Blocks.lit_furnace.getDefaultState().withProperty(BlockFurnace.FACING, llllllllllllllIIlIllIIIlIlllIIIl.getValue(BlockFurnace.FACING)), 3);
            llllllllllllllIIlIllIIIlIllIllII.setBlockState(llllllllllllllIIlIllIIIlIlllIIll, Blocks.lit_furnace.getDefaultState().withProperty(BlockFurnace.FACING, llllllllllllllIIlIllIIIlIlllIIIl.getValue(BlockFurnace.FACING)), 3);
        }
        else {
            llllllllllllllIIlIllIIIlIllIllII.setBlockState(llllllllllllllIIlIllIIIlIlllIIll, Blocks.furnace.getDefaultState().withProperty(BlockFurnace.FACING, llllllllllllllIIlIllIIIlIlllIIIl.getValue(BlockFurnace.FACING)), 3);
            llllllllllllllIIlIllIIIlIllIllII.setBlockState(llllllllllllllIIlIllIIIlIlllIIll, Blocks.furnace.getDefaultState().withProperty(BlockFurnace.FACING, llllllllllllllIIlIllIIIlIlllIIIl.getValue(BlockFurnace.FACING)), 3);
        }
        BlockFurnace.field_149934_M = false;
        if (llllllllllllllIIlIllIIIlIllIllll != null) {
            llllllllllllllIIlIllIIIlIllIllll.validate();
            llllllllllllllIIlIllIIIlIllIllII.setTileEntity(llllllllllllllIIlIllIIIlIlllIIll, llllllllllllllIIlIllIIIlIllIllll);
        }
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIIlIllIIIlIIllllll, final BlockPos llllllllllllllIIlIllIIIlIIllllIl, final IBlockState llllllllllllllIIlIllIIIlIIllIIlI, final EntityLivingBase llllllllllllllIIlIllIIIlIIlllIIl, final ItemStack llllllllllllllIIlIllIIIlIIllIlll) {
        llllllllllllllIIlIllIIIlIIllllll.setBlockState(llllllllllllllIIlIllIIIlIIllllIl, llllllllllllllIIlIllIIIlIIllIIlI.withProperty(BlockFurnace.FACING, llllllllllllllIIlIllIIIlIIlllIIl.func_174811_aO().getOpposite()), 2);
        if (llllllllllllllIIlIllIIIlIIllIlll.hasDisplayName()) {
            final TileEntity llllllllllllllIIlIllIIIlIIllIlIl = llllllllllllllIIlIllIIIlIIllllll.getTileEntity(llllllllllllllIIlIllIIIlIIllllIl);
            if (llllllllllllllIIlIllIIIlIIllIlIl instanceof TileEntityFurnace) {
                ((TileEntityFurnace)llllllllllllllIIlIllIIIlIIllIlIl).setCustomInventoryName(llllllllllllllIIlIllIIIlIIllIlll.getDisplayName());
            }
        }
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIlIllIIIlIIIlIIlI, final BlockPos llllllllllllllIIlIllIIIlIIIlIIIl) {
        return Item.getItemFromBlock(Blocks.furnace);
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_180356_a;
        
        static {
            __OBFID = "CL_00002111";
            field_180356_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_180356_a[EnumFacing.WEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_180356_a[EnumFacing.EAST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_180356_a[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_180356_a[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
