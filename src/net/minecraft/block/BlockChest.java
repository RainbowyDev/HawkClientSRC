package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import com.google.common.base.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class BlockChest extends BlockContainer
{
    private final /* synthetic */ Random rand;
    public static final /* synthetic */ PropertyDirection FACING_PROP;
    public final /* synthetic */ int chestType;
    
    public IBlockState checkForSurroundingChests(final World llllllllllllllIllIlllIllIlIIlIII, final BlockPos llllllllllllllIllIlllIllIlIIIlll, IBlockState llllllllllllllIllIlllIllIlIIIllI) {
        if (llllllllllllllIllIlllIllIlIIlIII.isRemote) {
            return llllllllllllllIllIlllIllIlIIIllI;
        }
        final IBlockState llllllllllllllIllIlllIllIllIIIlI = llllllllllllllIllIlllIllIlIIlIII.getBlockState(llllllllllllllIllIlllIllIlIIIlll.offsetNorth());
        final IBlockState llllllllllllllIllIlllIllIllIIIIl = llllllllllllllIllIlllIllIlIIlIII.getBlockState(llllllllllllllIllIlllIllIlIIIlll.offsetSouth());
        final IBlockState llllllllllllllIllIlllIllIllIIIII = llllllllllllllIllIlllIllIlIIlIII.getBlockState(llllllllllllllIllIlllIllIlIIIlll.offsetWest());
        final IBlockState llllllllllllllIllIlllIllIlIlllll = llllllllllllllIllIlllIllIlIIlIII.getBlockState(llllllllllllllIllIlllIllIlIIIlll.offsetEast());
        EnumFacing llllllllllllllIllIlllIllIlIllllI = (EnumFacing)llllllllllllllIllIlllIllIlIIIllI.getValue(BlockChest.FACING_PROP);
        final Block llllllllllllllIllIlllIllIlIlllIl = llllllllllllllIllIlllIllIllIIIlI.getBlock();
        final Block llllllllllllllIllIlllIllIlIlllII = llllllllllllllIllIlllIllIllIIIIl.getBlock();
        final Block llllllllllllllIllIlllIllIlIllIll = llllllllllllllIllIlllIllIllIIIII.getBlock();
        final Block llllllllllllllIllIlllIllIlIllIlI = llllllllllllllIllIlllIllIlIlllll.getBlock();
        if (llllllllllllllIllIlllIllIlIlllIl != this && llllllllllllllIllIlllIllIlIlllII != this) {
            final boolean llllllllllllllIllIlllIllIlIllIIl = llllllllllllllIllIlllIllIlIlllIl.isFullBlock();
            final boolean llllllllllllllIllIlllIllIlIllIII = llllllllllllllIllIlllIllIlIlllII.isFullBlock();
            if (llllllllllllllIllIlllIllIlIllIll == this || llllllllllllllIllIlllIllIlIllIlI == this) {
                final BlockPos llllllllllllllIllIlllIllIlIlIlll = (llllllllllllllIllIlllIllIlIllIll == this) ? llllllllllllllIllIlllIllIlIIIlll.offsetWest() : llllllllllllllIllIlllIllIlIIIlll.offsetEast();
                final IBlockState llllllllllllllIllIlllIllIlIlIllI = llllllllllllllIllIlllIllIlIIlIII.getBlockState(llllllllllllllIllIlllIllIlIlIlll.offsetNorth());
                final IBlockState llllllllllllllIllIlllIllIlIlIlIl = llllllllllllllIllIlllIllIlIIlIII.getBlockState(llllllllllllllIllIlllIllIlIlIlll.offsetSouth());
                llllllllllllllIllIlllIllIlIllllI = EnumFacing.SOUTH;
                EnumFacing llllllllllllllIllIlllIllIlIlIIll = null;
                if (llllllllllllllIllIlllIllIlIllIll == this) {
                    final EnumFacing llllllllllllllIllIlllIllIlIlIlII = (EnumFacing)llllllllllllllIllIlllIllIllIIIII.getValue(BlockChest.FACING_PROP);
                }
                else {
                    llllllllllllllIllIlllIllIlIlIIll = (EnumFacing)llllllllllllllIllIlllIllIlIlllll.getValue(BlockChest.FACING_PROP);
                }
                if (llllllllllllllIllIlllIllIlIlIIll == EnumFacing.NORTH) {
                    llllllllllllllIllIlllIllIlIllllI = EnumFacing.NORTH;
                }
                final Block llllllllllllllIllIlllIllIlIlIIlI = llllllllllllllIllIlllIllIlIlIllI.getBlock();
                final Block llllllllllllllIllIlllIllIlIlIIIl = llllllllllllllIllIlllIllIlIlIlIl.getBlock();
                if ((llllllllllllllIllIlllIllIlIllIIl || llllllllllllllIllIlllIllIlIlIIlI.isFullBlock()) && !llllllllllllllIllIlllIllIlIllIII && !llllllllllllllIllIlllIllIlIlIIIl.isFullBlock()) {
                    llllllllllllllIllIlllIllIlIllllI = EnumFacing.SOUTH;
                }
                if ((llllllllllllllIllIlllIllIlIllIII || llllllllllllllIllIlllIllIlIlIIIl.isFullBlock()) && !llllllllllllllIllIlllIllIlIllIIl && !llllllllllllllIllIlllIllIlIlIIlI.isFullBlock()) {
                    llllllllllllllIllIlllIllIlIllllI = EnumFacing.NORTH;
                }
            }
        }
        else {
            final BlockPos llllllllllllllIllIlllIllIlIlIIII = (llllllllllllllIllIlllIllIlIlllIl == this) ? llllllllllllllIllIlllIllIlIIIlll.offsetNorth() : llllllllllllllIllIlllIllIlIIIlll.offsetSouth();
            final IBlockState llllllllllllllIllIlllIllIlIIllll = llllllllllllllIllIlllIllIlIIlIII.getBlockState(llllllllllllllIllIlllIllIlIlIIII.offsetWest());
            final IBlockState llllllllllllllIllIlllIllIlIIlllI = llllllllllllllIllIlllIllIlIIlIII.getBlockState(llllllllllllllIllIlllIllIlIlIIII.offsetEast());
            llllllllllllllIllIlllIllIlIllllI = EnumFacing.EAST;
            EnumFacing llllllllllllllIllIlllIllIlIIllII = null;
            if (llllllllllllllIllIlllIllIlIlllIl == this) {
                final EnumFacing llllllllllllllIllIlllIllIlIIllIl = (EnumFacing)llllllllllllllIllIlllIllIllIIIlI.getValue(BlockChest.FACING_PROP);
            }
            else {
                llllllllllllllIllIlllIllIlIIllII = (EnumFacing)llllllllllllllIllIlllIllIllIIIIl.getValue(BlockChest.FACING_PROP);
            }
            if (llllllllllllllIllIlllIllIlIIllII == EnumFacing.WEST) {
                llllllllllllllIllIlllIllIlIllllI = EnumFacing.WEST;
            }
            final Block llllllllllllllIllIlllIllIlIIlIll = llllllllllllllIllIlllIllIlIIllll.getBlock();
            final Block llllllllllllllIllIlllIllIlIIlIlI = llllllllllllllIllIlllIllIlIIlllI.getBlock();
            if ((llllllllllllllIllIlllIllIlIllIll.isFullBlock() || llllllllllllllIllIlllIllIlIIlIll.isFullBlock()) && !llllllllllllllIllIlllIllIlIllIlI.isFullBlock() && !llllllllllllllIllIlllIllIlIIlIlI.isFullBlock()) {
                llllllllllllllIllIlllIllIlIllllI = EnumFacing.EAST;
            }
            if ((llllllllllllllIllIlllIllIlIllIlI.isFullBlock() || llllllllllllllIllIlllIllIlIIlIlI.isFullBlock()) && !llllllllllllllIllIlllIllIlIllIll.isFullBlock() && !llllllllllllllIllIlllIllIlIIlIll.isFullBlock()) {
                llllllllllllllIllIlllIllIlIllllI = EnumFacing.WEST;
            }
        }
        llllllllllllllIllIlllIllIlIIIllI = llllllllllllllIllIlllIllIlIIIllI.withProperty(BlockChest.FACING_PROP, llllllllllllllIllIlllIllIlIllllI);
        llllllllllllllIllIlllIllIlIIlIII.setBlockState(llllllllllllllIllIlllIllIlIIIlll, llllllllllllllIllIlllIllIlIIIllI, 3);
        return llllllllllllllIllIlllIllIlIIIllI;
    }
    
    public ILockableContainer getLockableContainer(final World llllllllllllllIllIlllIlIlIlIlIlI, final BlockPos llllllllllllllIllIlllIlIlIllIIll) {
        final TileEntity llllllllllllllIllIlllIlIlIllIIlI = llllllllllllllIllIlllIlIlIlIlIlI.getTileEntity(llllllllllllllIllIlllIlIlIllIIll);
        if (!(llllllllllllllIllIlllIlIlIllIIlI instanceof TileEntityChest)) {
            return null;
        }
        Object llllllllllllllIllIlllIlIlIllIIIl = llllllllllllllIllIlllIlIlIllIIlI;
        if (this.cannotOpenChest(llllllllllllllIllIlllIlIlIlIlIlI, llllllllllllllIllIlllIlIlIllIIll)) {
            return null;
        }
        for (final EnumFacing llllllllllllllIllIlllIlIlIlIllll : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos llllllllllllllIllIlllIlIlIlIlllI = llllllllllllllIllIlllIlIlIllIIll.offset(llllllllllllllIllIlllIlIlIlIllll);
            final Block llllllllllllllIllIlllIlIlIlIllIl = llllllllllllllIllIlllIlIlIlIlIlI.getBlockState(llllllllllllllIllIlllIlIlIlIlllI).getBlock();
            if (llllllllllllllIllIlllIlIlIlIllIl == this) {
                if (this.cannotOpenChest(llllllllllllllIllIlllIlIlIlIlIlI, llllllllllllllIllIlllIlIlIlIlllI)) {
                    return null;
                }
                final TileEntity llllllllllllllIllIlllIlIlIlIllII = llllllllllllllIllIlllIlIlIlIlIlI.getTileEntity(llllllllllllllIllIlllIlIlIlIlllI);
                if (!(llllllllllllllIllIlllIlIlIlIllII instanceof TileEntityChest)) {
                    continue;
                }
                if (llllllllllllllIllIlllIlIlIlIllll != EnumFacing.WEST && llllllllllllllIllIlllIlIlIlIllll != EnumFacing.NORTH) {
                    llllllllllllllIllIlllIlIlIllIIIl = new InventoryLargeChest("container.chestDouble", (ILockableContainer)llllllllllllllIllIlllIlIlIllIIIl, (ILockableContainer)llllllllllllllIllIlllIlIlIlIllII);
                }
                else {
                    llllllllllllllIllIlllIlIlIllIIIl = new InventoryLargeChest("container.chestDouble", (ILockableContainer)llllllllllllllIllIlllIlIlIlIllII, (ILockableContainer)llllllllllllllIllIlllIlIlIllIIIl);
                }
            }
        }
        return (ILockableContainer)llllllllllllllIllIlllIlIlIllIIIl;
    }
    
    private boolean cannotOpenChest(final World llllllllllllllIllIlllIlIIlllIlll, final BlockPos llllllllllllllIllIlllIlIIlllIIll) {
        return this.isBelowSolidBlock(llllllllllllllIllIlllIlIIlllIlll, llllllllllllllIllIlllIlIIlllIIll) || this.isOcelotSittingOnChest(llllllllllllllIllIlllIlIIlllIlll, llllllllllllllIllIlllIlIIlllIIll);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIllIlllIllIIIIlIlI, final BlockPos llllllllllllllIllIlllIllIIIIlIIl) {
        int llllllllllllllIllIlllIllIIIlIIII = 0;
        final BlockPos llllllllllllllIllIlllIllIIIIllll = llllllllllllllIllIlllIllIIIIlIIl.offsetWest();
        final BlockPos llllllllllllllIllIlllIllIIIIlllI = llllllllllllllIllIlllIllIIIIlIIl.offsetEast();
        final BlockPos llllllllllllllIllIlllIllIIIIllIl = llllllllllllllIllIlllIllIIIIlIIl.offsetNorth();
        final BlockPos llllllllllllllIllIlllIllIIIIllII = llllllllllllllIllIlllIllIIIIlIIl.offsetSouth();
        if (llllllllllllllIllIlllIllIIIIlIlI.getBlockState(llllllllllllllIllIlllIllIIIIllll).getBlock() == this) {
            if (this.isSurroundingBlockChest(llllllllllllllIllIlllIllIIIIlIlI, llllllllllllllIllIlllIllIIIIllll)) {
                return false;
            }
            ++llllllllllllllIllIlllIllIIIlIIII;
        }
        if (llllllllllllllIllIlllIllIIIIlIlI.getBlockState(llllllllllllllIllIlllIllIIIIlllI).getBlock() == this) {
            if (this.isSurroundingBlockChest(llllllllllllllIllIlllIllIIIIlIlI, llllllllllllllIllIlllIllIIIIlllI)) {
                return false;
            }
            ++llllllllllllllIllIlllIllIIIlIIII;
        }
        if (llllllllllllllIllIlllIllIIIIlIlI.getBlockState(llllllllllllllIllIlllIllIIIIllIl).getBlock() == this) {
            if (this.isSurroundingBlockChest(llllllllllllllIllIlllIllIIIIlIlI, llllllllllllllIllIlllIllIIIIllIl)) {
                return false;
            }
            ++llllllllllllllIllIlllIllIIIlIIII;
        }
        if (llllllllllllllIllIlllIllIIIIlIlI.getBlockState(llllllllllllllIllIlllIllIIIIllII).getBlock() == this) {
            if (this.isSurroundingBlockChest(llllllllllllllIllIlllIllIIIIlIlI, llllllllllllllIllIlllIllIIIIllII)) {
                return false;
            }
            ++llllllllllllllIllIlllIllIIIlIIII;
        }
        return llllllllllllllIllIlllIllIIIlIIII <= 1;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIllIlllIlIllIIllIl, final BlockPos llllllllllllllIllIlllIlIllIIllII, final IBlockState llllllllllllllIllIlllIlIllIIlIll, final EntityPlayer llllllllllllllIllIlllIlIllIIIIIl, final EnumFacing llllllllllllllIllIlllIlIllIIlIIl, final float llllllllllllllIllIlllIlIllIIlIII, final float llllllllllllllIllIlllIlIllIIIlll, final float llllllllllllllIllIlllIlIllIIIllI) {
        if (llllllllllllllIllIlllIlIllIIllIl.isRemote) {
            return true;
        }
        final ILockableContainer llllllllllllllIllIlllIlIllIIIlIl = this.getLockableContainer(llllllllllllllIllIlllIlIllIIllIl, llllllllllllllIllIlllIlIllIIllII);
        if (llllllllllllllIllIlllIlIllIIIlIl != null) {
            llllllllllllllIllIlllIlIllIIIIIl.displayGUIChest(llllllllllllllIllIlllIlIllIIIlIl);
        }
        return true;
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIllIlllIlIIlIlIllI, final BlockPos llllllllllllllIllIlllIlIIlIlIIlI) {
        return Container.calcRedstoneFromInventory(this.getLockableContainer(llllllllllllllIllIlllIlIIlIlIllI, llllllllllllllIllIlllIlIIlIlIIlI));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIllIlllIlIIlIIllIl) {
        EnumFacing llllllllllllllIllIlllIlIIlIIllII = EnumFacing.getFront(llllllllllllllIllIlllIlIIlIIllIl);
        if (llllllllllllllIllIlllIlIIlIIllII.getAxis() == EnumFacing.Axis.Y) {
            llllllllllllllIllIlllIlIIlIIllII = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(BlockChest.FACING_PROP, llllllllllllllIllIlllIlIIlIIllII);
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIllIlllIlllIIIlIlI, final BlockPos llllllllllllllIllIlllIlllIIllIIl, IBlockState llllllllllllllIllIlllIlllIIIlIII, final EntityLivingBase llllllllllllllIllIlllIlllIIlIlll, final ItemStack llllllllllllllIllIlllIlllIIIIllI) {
        final EnumFacing llllllllllllllIllIlllIlllIIlIlIl = EnumFacing.getHorizontal(MathHelper.floor_double(llllllllllllllIllIlllIlllIIlIlll.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3).getOpposite();
        llllllllllllllIllIlllIlllIIIlIII = llllllllllllllIllIlllIlllIIIlIII.withProperty(BlockChest.FACING_PROP, llllllllllllllIllIlllIlllIIlIlIl);
        final BlockPos llllllllllllllIllIlllIlllIIlIlII = llllllllllllllIllIlllIlllIIllIIl.offsetNorth();
        final BlockPos llllllllllllllIllIlllIlllIIlIIll = llllllllllllllIllIlllIlllIIllIIl.offsetSouth();
        final BlockPos llllllllllllllIllIlllIlllIIlIIlI = llllllllllllllIllIlllIlllIIllIIl.offsetWest();
        final BlockPos llllllllllllllIllIlllIlllIIlIIIl = llllllllllllllIllIlllIlllIIllIIl.offsetEast();
        final boolean llllllllllllllIllIlllIlllIIlIIII = this == llllllllllllllIllIlllIlllIIIlIlI.getBlockState(llllllllllllllIllIlllIlllIIlIlII).getBlock();
        final boolean llllllllllllllIllIlllIlllIIIllll = this == llllllllllllllIllIlllIlllIIIlIlI.getBlockState(llllllllllllllIllIlllIlllIIlIIll).getBlock();
        final boolean llllllllllllllIllIlllIlllIIIlllI = this == llllllllllllllIllIlllIlllIIIlIlI.getBlockState(llllllllllllllIllIlllIlllIIlIIlI).getBlock();
        final boolean llllllllllllllIllIlllIlllIIIllIl = this == llllllllllllllIllIlllIlllIIIlIlI.getBlockState(llllllllllllllIllIlllIlllIIlIIIl).getBlock();
        if (!llllllllllllllIllIlllIlllIIlIIII && !llllllllllllllIllIlllIlllIIIllll && !llllllllllllllIllIlllIlllIIIlllI && !llllllllllllllIllIlllIlllIIIllIl) {
            llllllllllllllIllIlllIlllIIIlIlI.setBlockState(llllllllllllllIllIlllIlllIIllIIl, llllllllllllllIllIlllIlllIIIlIII, 3);
        }
        else if (llllllllllllllIllIlllIlllIIlIlIl.getAxis() == EnumFacing.Axis.X && (llllllllllllllIllIlllIlllIIlIIII || llllllllllllllIllIlllIlllIIIllll)) {
            if (llllllllllllllIllIlllIlllIIlIIII) {
                llllllllllllllIllIlllIlllIIIlIlI.setBlockState(llllllllllllllIllIlllIlllIIlIlII, llllllllllllllIllIlllIlllIIIlIII, 3);
            }
            else {
                llllllllllllllIllIlllIlllIIIlIlI.setBlockState(llllllllllllllIllIlllIlllIIlIIll, llllllllllllllIllIlllIlllIIIlIII, 3);
            }
            llllllllllllllIllIlllIlllIIIlIlI.setBlockState(llllllllllllllIllIlllIlllIIllIIl, llllllllllllllIllIlllIlllIIIlIII, 3);
        }
        else if (llllllllllllllIllIlllIlllIIlIlIl.getAxis() == EnumFacing.Axis.Z && (llllllllllllllIllIlllIlllIIIlllI || llllllllllllllIllIlllIlllIIIllIl)) {
            if (llllllllllllllIllIlllIlllIIIlllI) {
                llllllllllllllIllIlllIlllIIIlIlI.setBlockState(llllllllllllllIllIlllIlllIIlIIlI, llllllllllllllIllIlllIlllIIIlIII, 3);
            }
            else {
                llllllllllllllIllIlllIlllIIIlIlI.setBlockState(llllllllllllllIllIlllIlllIIlIIIl, llllllllllllllIllIlllIlllIIIlIII, 3);
            }
            llllllllllllllIllIlllIlllIIIlIlI.setBlockState(llllllllllllllIllIlllIlllIIllIIl, llllllllllllllIllIlllIlllIIIlIII, 3);
        }
        if (llllllllllllllIllIlllIlllIIIIllI.hasDisplayName()) {
            final TileEntity llllllllllllllIllIlllIlllIIIllII = llllllllllllllIllIlllIlllIIIlIlI.getTileEntity(llllllllllllllIllIlllIlllIIllIIl);
            if (llllllllllllllIllIlllIlllIIIllII instanceof TileEntityChest) {
                ((TileEntityChest)llllllllllllllIllIlllIlllIIIllII).setCustomName(llllllllllllllIllIlllIlllIIIIllI.getDisplayName());
            }
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIllIlllIlIlIlIIIII, final int llllllllllllllIllIlllIlIlIIlllll) {
        return new TileEntityChest();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockChest.FACING_PROP });
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess llllllllllllllIllIlllIlIlIIIIlII, final BlockPos llllllllllllllIllIlllIlIlIIIIIll, final IBlockState llllllllllllllIllIlllIlIlIIIIIlI, final EnumFacing llllllllllllllIllIlllIlIlIIIIIIl) {
        return (llllllllllllllIllIlllIlIlIIIIIIl == EnumFacing.UP) ? this.isProvidingWeakPower(llllllllllllllIllIlllIlIlIIIIlII, llllllllllllllIllIlllIlIlIIIIIll, llllllllllllllIllIlllIlIlIIIIIlI, llllllllllllllIllIlllIlIlIIIIIIl) : 0;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIllIlllIllllIIIlll, final BlockPos llllllllllllllIllIlllIllllIIIllI, final IBlockState llllllllllllllIllIlllIlllIllllIl) {
        this.checkForSurroundingChests(llllllllllllllIllIlllIllllIIIlll, llllllllllllllIllIlllIllllIIIllI, llllllllllllllIllIlllIlllIllllIl);
        for (final EnumFacing llllllllllllllIllIlllIllllIIIIll : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos llllllllllllllIllIlllIllllIIIIlI = llllllllllllllIllIlllIllllIIIllI.offset(llllllllllllllIllIlllIllllIIIIll);
            final IBlockState llllllllllllllIllIlllIllllIIIIIl = llllllllllllllIllIlllIllllIIIlll.getBlockState(llllllllllllllIllIlllIllllIIIIlI);
            if (llllllllllllllIllIlllIllllIIIIIl.getBlock() == this) {
                this.checkForSurroundingChests(llllllllllllllIllIlllIllllIIIlll, llllllllllllllIllIlllIllllIIIIlI, llllllllllllllIllIlllIllllIIIIIl);
            }
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIllIlllIllllIlIlIl, final BlockPos llllllllllllllIllIlllIllllIlIIIl) {
        if (llllllllllllllIllIlllIllllIlIlIl.getBlockState(llllllllllllllIllIlllIllllIlIIIl.offsetNorth()).getBlock() == this) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0f, 0.9375f, 0.875f, 0.9375f);
        }
        else if (llllllllllllllIllIlllIllllIlIlIl.getBlockState(llllllllllllllIllIlllIllllIlIIIl.offsetSouth()).getBlock() == this) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 1.0f);
        }
        else if (llllllllllllllIllIlllIllllIlIlIl.getBlockState(llllllllllllllIllIlllIllllIlIIIl.offsetWest()).getBlock() == this) {
            this.setBlockBounds(0.0f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
        }
        else if (llllllllllllllIllIlllIllllIlIlIl.getBlockState(llllllllllllllIllIlllIllllIlIIIl.offsetEast()).getBlock() == this) {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 1.0f, 0.875f, 0.9375f);
        }
        else {
            this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
        }
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIllIlllIlIllIlIlll, final BlockPos llllllllllllllIllIlllIlIllIlIllI, final IBlockState llllllllllllllIllIlllIlIllIlIlIl) {
        final TileEntity llllllllllllllIllIlllIlIllIllIIl = llllllllllllllIllIlllIlIllIlIlll.getTileEntity(llllllllllllllIllIlllIlIllIlIllI);
        if (llllllllllllllIllIlllIlIllIllIIl instanceof IInventory) {
            InventoryHelper.dropInventoryItems(llllllllllllllIllIlllIlIllIlIlll, llllllllllllllIllIlllIlIllIlIllI, (IInventory)llllllllllllllIllIlllIlIllIllIIl);
            llllllllllllllIllIlllIlIllIlIlll.updateComparatorOutputLevel(llllllllllllllIllIlllIlIllIlIllI, this);
        }
        super.breakBlock(llllllllllllllIllIlllIlIllIlIlll, llllllllllllllIllIlllIlIllIlIllI, llllllllllllllIllIlllIlIllIlIlIl);
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess llllllllllllllIllIlllIlIlIIIlllI, final BlockPos llllllllllllllIllIlllIlIlIIlIlII, final IBlockState llllllllllllllIllIlllIlIlIIlIIll, final EnumFacing llllllllllllllIllIlllIlIlIIlIIlI) {
        if (!this.canProvidePower()) {
            return 0;
        }
        int llllllllllllllIllIlllIlIlIIlIIIl = 0;
        final TileEntity llllllllllllllIllIlllIlIlIIlIIII = llllllllllllllIllIlllIlIlIIIlllI.getTileEntity(llllllllllllllIllIlllIlIlIIlIlII);
        if (llllllllllllllIllIlllIlIlIIlIIII instanceof TileEntityChest) {
            llllllllllllllIllIlllIlIlIIlIIIl = ((TileEntityChest)llllllllllllllIllIlllIlIlIIlIIII).numPlayersUsing;
        }
        return MathHelper.clamp_int(llllllllllllllIllIlllIlIlIIlIIIl, 0, 15);
    }
    
    @Override
    public int getRenderType() {
        return 2;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIllIlllIlllIllIlIl, final BlockPos llllllllllllllIllIlllIlllIllIlII, final EnumFacing llllllllllllllIllIlllIlllIllIIll, final float llllllllllllllIllIlllIlllIllIIlI, final float llllllllllllllIllIlllIlllIllIIIl, final float llllllllllllllIllIlllIlllIllIIII, final int llllllllllllllIllIlllIlllIlIllll, final EntityLivingBase llllllllllllllIllIlllIlllIlIllII) {
        return this.getDefaultState().withProperty(BlockChest.FACING_PROP, llllllllllllllIllIlllIlllIlIllII.func_174811_aO());
    }
    
    @Override
    public boolean canProvidePower() {
        return this.chestType == 1;
    }
    
    private boolean isBelowSolidBlock(final World llllllllllllllIllIlllIlIIllIllIl, final BlockPos llllllllllllllIllIlllIlIIllIllII) {
        return llllllllllllllIllIlllIlIIllIllIl.getBlockState(llllllllllllllIllIlllIlIIllIllII.offsetUp()).getBlock().isNormalCube();
    }
    
    protected BlockChest(final int llllllllllllllIllIlllIllllIlllll) {
        super(Material.wood);
        this.rand = new Random();
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockChest.FACING_PROP, EnumFacing.NORTH));
        this.chestType = llllllllllllllIllIlllIllllIlllll;
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
    }
    
    static {
        __OBFID = "CL_00000214";
        FACING_PROP = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
    }
    
    public IBlockState func_176458_f(final World llllllllllllllIllIlllIllIIlIlIll, final BlockPos llllllllllllllIllIlllIllIIlIIIIl, final IBlockState llllllllllllllIllIlllIllIIlIlIIl) {
        EnumFacing llllllllllllllIllIlllIllIIlIlIII = null;
        for (final EnumFacing llllllllllllllIllIlllIllIIlIIllI : EnumFacing.Plane.HORIZONTAL) {
            final IBlockState llllllllllllllIllIlllIllIIlIIlIl = llllllllllllllIllIlllIllIIlIlIll.getBlockState(llllllllllllllIllIlllIllIIlIIIIl.offset(llllllllllllllIllIlllIllIIlIIllI));
            if (llllllllllllllIllIlllIllIIlIIlIl.getBlock() == this) {
                return llllllllllllllIllIlllIllIIlIlIIl;
            }
            if (!llllllllllllllIllIlllIllIIlIIlIl.getBlock().isFullBlock()) {
                continue;
            }
            if (llllllllllllllIllIlllIllIIlIlIII != null) {
                llllllllllllllIllIlllIllIIlIlIII = null;
                break;
            }
            llllllllllllllIllIlllIllIIlIlIII = llllllllllllllIllIlllIllIIlIIllI;
        }
        if (llllllllllllllIllIlllIllIIlIlIII != null) {
            return llllllllllllllIllIlllIllIIlIlIIl.withProperty(BlockChest.FACING_PROP, llllllllllllllIllIlllIllIIlIlIII.getOpposite());
        }
        EnumFacing llllllllllllllIllIlllIllIIlIIlII = (EnumFacing)llllllllllllllIllIlllIllIIlIlIIl.getValue(BlockChest.FACING_PROP);
        if (llllllllllllllIllIlllIllIIlIlIll.getBlockState(llllllllllllllIllIlllIllIIlIIIIl.offset(llllllllllllllIllIlllIllIIlIIlII)).getBlock().isFullBlock()) {
            llllllllllllllIllIlllIllIIlIIlII = llllllllllllllIllIlllIllIIlIIlII.getOpposite();
        }
        if (llllllllllllllIllIlllIllIIlIlIll.getBlockState(llllllllllllllIllIlllIllIIlIIIIl.offset(llllllllllllllIllIlllIllIIlIIlII)).getBlock().isFullBlock()) {
            llllllllllllllIllIlllIllIIlIIlII = llllllllllllllIllIlllIllIIlIIlII.rotateY();
        }
        if (llllllllllllllIllIlllIllIIlIlIll.getBlockState(llllllllllllllIllIlllIllIIlIIIIl.offset(llllllllllllllIllIlllIllIIlIIlII)).getBlock().isFullBlock()) {
            llllllllllllllIllIlllIllIIlIIlII = llllllllllllllIllIlllIllIIlIIlII.getOpposite();
        }
        return llllllllllllllIllIlllIllIIlIlIIl.withProperty(BlockChest.FACING_PROP, llllllllllllllIllIlllIllIIlIIlII);
    }
    
    private boolean isSurroundingBlockChest(final World llllllllllllllIllIlllIlIllllllIl, final BlockPos llllllllllllllIllIlllIlIllllllII) {
        if (llllllllllllllIllIlllIlIllllllIl.getBlockState(llllllllllllllIllIlllIlIllllllII).getBlock() != this) {
            return false;
        }
        for (final EnumFacing llllllllllllllIllIlllIlIlllllIlI : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllllllIllIlllIlIllllllIl.getBlockState(llllllllllllllIllIlllIlIllllllII.offset(llllllllllllllIllIlllIlIlllllIlI)).getBlock() == this) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIllIlllIlIIlIIIlIl) {
        return ((EnumFacing)llllllllllllllIllIlllIlIIlIIIlIl.getValue(BlockChest.FACING_PROP)).getIndex();
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIllIlllIlIlllIIlll, final BlockPos llllllllllllllIllIlllIlIlllIllII, final IBlockState llllllllllllllIllIlllIlIlllIlIll, final Block llllllllllllllIllIlllIlIlllIIlII) {
        super.onNeighborBlockChange(llllllllllllllIllIlllIlIlllIIlll, llllllllllllllIllIlllIlIlllIllII, llllllllllllllIllIlllIlIlllIlIll, llllllllllllllIllIlllIlIlllIIlII);
        final TileEntity llllllllllllllIllIlllIlIlllIlIIl = llllllllllllllIllIlllIlIlllIIlll.getTileEntity(llllllllllllllIllIlllIlIlllIllII);
        if (llllllllllllllIllIlllIlIlllIlIIl instanceof TileEntityChest) {
            llllllllllllllIllIlllIlIlllIlIIl.updateContainingBlockInfo();
        }
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    private boolean isOcelotSittingOnChest(final World llllllllllllllIllIlllIlIIllIIlIl, final BlockPos llllllllllllllIllIlllIlIIllIIlII) {
        for (final Entity llllllllllllllIllIlllIlIIllIIIIl : llllllllllllllIllIlllIlIIllIIlIl.getEntitiesWithinAABB(EntityOcelot.class, new AxisAlignedBB(llllllllllllllIllIlllIlIIllIIlII.getX(), llllllllllllllIllIlllIlIIllIIlII.getY() + 1, llllllllllllllIllIlllIlIIllIIlII.getZ(), llllllllllllllIllIlllIlIIllIIlII.getX() + 1, llllllllllllllIllIlllIlIIllIIlII.getY() + 2, llllllllllllllIllIlllIlIIllIIlII.getZ() + 1))) {
            final EntityOcelot llllllllllllllIllIlllIlIIllIIIlI = (EntityOcelot)llllllllllllllIllIlllIlIIllIIIIl;
            if (llllllllllllllIllIlllIlIIllIIIlI.isSitting()) {
                return true;
            }
        }
        return false;
    }
}
