package net.minecraft.tileentity;

import net.minecraft.server.gui.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.command.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;

public class TileEntityHopper extends TileEntityLockable implements IUpdatePlayerListBox, IHopper
{
    private /* synthetic */ String customName;
    private /* synthetic */ ItemStack[] inventory;
    private /* synthetic */ int transferCooldown;
    
    @Override
    public int getSizeInventory() {
        return this.inventory.length;
    }
    
    public static ItemStack func_174918_a(final IInventory lIIIllIlIIIIlIl, ItemStack lIIIllIlIIIIlII, final EnumFacing lIIIllIlIIIIIll) {
        if (lIIIllIlIIIIlIl instanceof ISidedInventory && lIIIllIlIIIIIll != null) {
            final ISidedInventory lIIIllIlIIIlIlI = (ISidedInventory)lIIIllIlIIIIlIl;
            final int[] lIIIllIlIIIlIIl = lIIIllIlIIIlIlI.getSlotsForFace(lIIIllIlIIIIIll);
            for (int lIIIllIlIIIlIII = 0; lIIIllIlIIIlIII < lIIIllIlIIIlIIl.length && lIIIllIlIIIIlII != null; lIIIllIlIIIIlII = func_174916_c(lIIIllIlIIIIlIl, lIIIllIlIIIIlII, lIIIllIlIIIlIIl[lIIIllIlIIIlIII], lIIIllIlIIIIIll), ++lIIIllIlIIIlIII) {
                if (lIIIllIlIIIIlII.stackSize <= 0) {
                    break;
                }
            }
        }
        else {
            for (int lIIIllIlIIIIlll = lIIIllIlIIIIlIl.getSizeInventory(), lIIIllIlIIIIllI = 0; lIIIllIlIIIIllI < lIIIllIlIIIIlll && lIIIllIlIIIIlII != null && lIIIllIlIIIIlII.stackSize > 0; lIIIllIlIIIIlII = func_174916_c(lIIIllIlIIIIlIl, lIIIllIlIIIIlII, lIIIllIlIIIIllI, lIIIllIlIIIIIll), ++lIIIllIlIIIIllI) {}
        }
        if (lIIIllIlIIIIlII != null && lIIIllIlIIIIlII.stackSize == 0) {
            lIIIllIlIIIIlII = null;
        }
        return lIIIllIlIIIIlII;
    }
    
    private IInventory func_145895_l() {
        final EnumFacing lIIIllIIlIIlIll = BlockHopper.func_176428_b(this.getBlockMetadata());
        return func_145893_b(this.getWorld(), this.pos.getX() + lIIIllIIlIIlIll.getFrontOffsetX(), this.pos.getY() + lIIIllIIlIIlIll.getFrontOffsetY(), this.pos.getZ() + lIIIllIIlIIlIll.getFrontOffsetZ());
    }
    
    private boolean func_145883_k() {
        final IInventory lIIIllIlllllllI = this.func_145895_l();
        if (lIIIllIlllllllI == null) {
            return false;
        }
        final EnumFacing lIIIllIllllllIl = BlockHopper.func_176428_b(this.getBlockMetadata()).getOpposite();
        if (this.func_174919_a(lIIIllIlllllllI, lIIIllIllllllIl)) {
            return false;
        }
        for (int lIIIllIllllllII = 0; lIIIllIllllllII < this.getSizeInventory(); ++lIIIllIllllllII) {
            if (this.getStackInSlot(lIIIllIllllllII) != null) {
                final ItemStack lIIIllIlllllIll = this.getStackInSlot(lIIIllIllllllII).copy();
                final ItemStack lIIIllIlllllIlI = func_174918_a(lIIIllIlllllllI, this.decrStackSize(lIIIllIllllllII, 1), lIIIllIllllllIl);
                if (lIIIllIlllllIlI == null || lIIIllIlllllIlI.stackSize == 0) {
                    lIIIllIlllllllI.markDirty();
                    return true;
                }
                this.setInventorySlotContents(lIIIllIllllllII, lIIIllIlllllIll);
            }
        }
        return false;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lIIIlIlllllIIIl, final EntityPlayer lIIIlIlllllIIII) {
        return new ContainerHopper(lIIIlIlllllIIIl, this, lIIIlIlllllIIII);
    }
    
    public void setCustomName(final String lIIIlllIIllllIl) {
        this.customName = lIIIlllIIllllIl;
    }
    
    @Override
    public void update() {
        if (this.worldObj != null && !this.worldObj.isRemote) {
            --this.transferCooldown;
            if (!this.isOnTransferCooldown()) {
                this.setTransferCooldown(0);
                this.func_145887_i();
            }
        }
    }
    
    private boolean func_152105_l() {
        for (final ItemStack lIIIlllIIIIlIll : this.inventory) {
            if (lIIIlllIIIIlIll == null || lIIIlllIIIIlIll.stackSize != lIIIlllIIIIlIll.getMaxStackSize()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public void setInventorySlotContents(final int lIIIlllIlIIlIII, final ItemStack lIIIlllIlIIlIlI) {
        this.inventory[lIIIlllIlIIlIII] = lIIIlllIlIIlIlI;
        if (lIIIlllIlIIlIlI != null && lIIIlllIlIIlIlI.stackSize > this.getInventoryStackLimit()) {
            lIIIlllIlIIlIlI.stackSize = this.getInventoryStackLimit();
        }
    }
    
    private static boolean func_174920_a(final IInventory lIIIllIIllllIll, final ItemStack lIIIllIIllllIlI, final int lIIIllIIllllIIl, final EnumFacing lIIIllIIlllIlII) {
        return lIIIllIIllllIll.isItemValidForSlot(lIIIllIIllllIIl, lIIIllIIllllIlI) && (!(lIIIllIIllllIll instanceof ISidedInventory) || ((ISidedInventory)lIIIllIIllllIll).canInsertItem(lIIIllIIllllIIl, lIIIllIIllllIlI, lIIIllIIlllIlII));
    }
    
    @Override
    public int getField(final int lIIIlIllllIlllI) {
        return 0;
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound lIIIlllIlllIlIl) {
        super.writeToNBT(lIIIlllIlllIlIl);
        final NBTTagList lIIIlllIllllIIl = new NBTTagList();
        for (int lIIIlllIllllIII = 0; lIIIlllIllllIII < this.inventory.length; ++lIIIlllIllllIII) {
            if (this.inventory[lIIIlllIllllIII] != null) {
                final NBTTagCompound lIIIlllIlllIlll = new NBTTagCompound();
                lIIIlllIlllIlll.setByte("Slot", (byte)lIIIlllIllllIII);
                this.inventory[lIIIlllIllllIII].writeToNBT(lIIIlllIlllIlll);
                lIIIlllIllllIIl.appendTag(lIIIlllIlllIlll);
            }
        }
        lIIIlllIlllIlIl.setTag("Items", lIIIlllIllllIIl);
        lIIIlllIlllIlIl.setInteger("TransferCooldown", this.transferCooldown);
        if (this.hasCustomName()) {
            lIIIlllIlllIlIl.setString("CustomName", this.customName);
        }
    }
    
    public void setTransferCooldown(final int lIIIllIIIIIIIlI) {
        this.transferCooldown = lIIIllIIIIIIIlI;
    }
    
    private static ItemStack func_174916_c(final IInventory lIIIllIIlIlIllI, ItemStack lIIIllIIlIlIlIl, final int lIIIllIIlIlllIl, final EnumFacing lIIIllIIlIlIIll) {
        final ItemStack lIIIllIIlIllIll = lIIIllIIlIlIllI.getStackInSlot(lIIIllIIlIlllIl);
        if (func_174920_a(lIIIllIIlIlIllI, lIIIllIIlIlIlIl, lIIIllIIlIlllIl, lIIIllIIlIlIIll)) {
            boolean lIIIllIIlIllIlI = false;
            if (lIIIllIIlIllIll == null) {
                lIIIllIIlIlIllI.setInventorySlotContents(lIIIllIIlIlllIl, lIIIllIIlIlIlIl);
                lIIIllIIlIlIlIl = null;
                lIIIllIIlIllIlI = true;
            }
            else if (canCombine(lIIIllIIlIllIll, lIIIllIIlIlIlIl)) {
                final int lIIIllIIlIllIIl = lIIIllIIlIlIlIl.getMaxStackSize() - lIIIllIIlIllIll.stackSize;
                final int lIIIllIIlIllIII = Math.min(lIIIllIIlIlIlIl.stackSize, lIIIllIIlIllIIl);
                final ItemStack itemStack = lIIIllIIlIlIlIl;
                itemStack.stackSize -= lIIIllIIlIllIII;
                final ItemStack itemStack2 = lIIIllIIlIllIll;
                itemStack2.stackSize += lIIIllIIlIllIII;
                lIIIllIIlIllIlI = (lIIIllIIlIllIII > 0);
            }
            if (lIIIllIIlIllIlI) {
                if (lIIIllIIlIlIllI instanceof TileEntityHopper) {
                    final TileEntityHopper lIIIllIIlIlIlll = (TileEntityHopper)lIIIllIIlIlIllI;
                    if (lIIIllIIlIlIlll.mayTransfer()) {
                        lIIIllIIlIlIlll.setTransferCooldown(8);
                    }
                    lIIIllIIlIlIllI.markDirty();
                }
                lIIIllIIlIlIllI.markDirty();
            }
        }
        return lIIIllIIlIlIlIl;
    }
    
    public boolean func_145887_i() {
        if (this.worldObj != null && !this.worldObj.isRemote) {
            if (!this.isOnTransferCooldown() && BlockHopper.getActiveStateFromMetadata(this.getBlockMetadata())) {
                boolean lIIIlllIIlIIllI = false;
                if (!this.func_152104_k()) {
                    lIIIlllIIlIIllI = this.func_145883_k();
                }
                if (!this.func_152105_l()) {
                    lIIIlllIIlIIllI = (func_145891_a(this) || lIIIlllIIlIIllI);
                }
                if (lIIIlllIIlIIllI) {
                    this.setTransferCooldown(8);
                    this.markDirty();
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }
    
    @Override
    public double getYPos() {
        return this.pos.getY();
    }
    
    public TileEntityHopper() {
        this.inventory = new ItemStack[5];
        this.transferCooldown = -1;
    }
    
    @Override
    public ItemStack getStackInSlot(final int lIIIlllIllIlIII) {
        return this.inventory[lIIIlllIllIlIII];
    }
    
    @Override
    public void setField(final int lIIIlIllllIllII, final int lIIIlIllllIlIll) {
    }
    
    public static EntityItem func_145897_a(final World lIIIllIIIlllIll, final double lIIIllIIIlllIlI, final double lIIIllIIIlllllI, final double lIIIllIIIlllIII) {
        final List lIIIllIIIllllII = lIIIllIIIlllIll.func_175647_a(EntityItem.class, new AxisAlignedBB(lIIIllIIIlllIlI, lIIIllIIIlllllI, lIIIllIIIlllIII, lIIIllIIIlllIlI + 1.0, lIIIllIIIlllllI + 1.0, lIIIllIIIlllIII + 1.0), IEntitySelector.selectAnything);
        return (lIIIllIIIllllII.size() > 0) ? lIIIllIIIllllII.get(0) : null;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:hopper";
    }
    
    @Override
    public void clearInventory() {
        for (int lIIIlIllllIIllI = 0; lIIIlIllllIIllI < this.inventory.length; ++lIIIlIllllIIllI) {
            this.inventory[lIIIlIllllIIllI] = null;
        }
    }
    
    private static boolean func_174915_a(final IHopper lIIIllIlIllIIII, final IInventory lIIIllIlIlIlIII, final int lIIIllIlIlIIlll, final EnumFacing lIIIllIlIlIIllI) {
        final ItemStack lIIIllIlIlIllII = lIIIllIlIlIlIII.getStackInSlot(lIIIllIlIlIIlll);
        if (lIIIllIlIlIllII != null && func_174921_b(lIIIllIlIlIlIII, lIIIllIlIlIllII, lIIIllIlIlIIlll, lIIIllIlIlIIllI)) {
            final ItemStack lIIIllIlIlIlIll = lIIIllIlIlIllII.copy();
            final ItemStack lIIIllIlIlIlIlI = func_174918_a(lIIIllIlIllIIII, lIIIllIlIlIlIII.decrStackSize(lIIIllIlIlIIlll, 1), null);
            if (lIIIllIlIlIlIlI == null || lIIIllIlIlIlIlI.stackSize == 0) {
                lIIIllIlIlIlIII.markDirty();
                return true;
            }
            lIIIllIlIlIlIII.setInventorySlotContents(lIIIllIlIlIIlll, lIIIllIlIlIlIll);
        }
        return false;
    }
    
    public boolean mayTransfer() {
        return this.transferCooldown <= 1;
    }
    
    static {
        __OBFID = "CL_00000359";
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int lIIIlllIlIlIIIl) {
        if (this.inventory[lIIIlllIlIlIIIl] != null) {
            final ItemStack lIIIlllIlIlIIll = this.inventory[lIIIlllIlIlIIIl];
            this.inventory[lIIIlllIlIlIIIl] = null;
            return lIIIlllIlIlIIll;
        }
        return null;
    }
    
    @Override
    public double getXPos() {
        return this.pos.getX();
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer lIIIlllIIllIllI) {
        return this.worldObj.getTileEntity(this.pos) == this && lIIIlllIIllIllI.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void markDirty() {
        super.markDirty();
    }
    
    public static IInventory func_145893_b(final World lIIIllIIIIlllll, final double lIIIllIIIlIlIlI, final double lIIIllIIIIlllIl, final double lIIIllIIIIlllII) {
        Object lIIIllIIIlIIlll = null;
        final int lIIIllIIIlIIllI = MathHelper.floor_double(lIIIllIIIlIlIlI);
        final int lIIIllIIIlIIlIl = MathHelper.floor_double(lIIIllIIIIlllIl);
        final int lIIIllIIIlIIlII = MathHelper.floor_double(lIIIllIIIIlllII);
        final BlockPos lIIIllIIIlIIIll = new BlockPos(lIIIllIIIlIIllI, lIIIllIIIlIIlIl, lIIIllIIIlIIlII);
        final TileEntity lIIIllIIIlIIIlI = lIIIllIIIIlllll.getTileEntity(new BlockPos(lIIIllIIIlIIllI, lIIIllIIIlIIlIl, lIIIllIIIlIIlII));
        if (lIIIllIIIlIIIlI instanceof IInventory) {
            lIIIllIIIlIIlll = lIIIllIIIlIIIlI;
            if (lIIIllIIIlIIlll instanceof TileEntityChest) {
                final Block lIIIllIIIlIIIIl = lIIIllIIIIlllll.getBlockState(new BlockPos(lIIIllIIIlIIllI, lIIIllIIIlIIlIl, lIIIllIIIlIIlII)).getBlock();
                if (lIIIllIIIlIIIIl instanceof BlockChest) {
                    lIIIllIIIlIIlll = ((BlockChest)lIIIllIIIlIIIIl).getLockableContainer(lIIIllIIIIlllll, lIIIllIIIlIIIll);
                }
            }
        }
        if (lIIIllIIIlIIlll == null) {
            final List lIIIllIIIlIIIII = lIIIllIIIIlllll.func_175674_a(null, new AxisAlignedBB(lIIIllIIIlIlIlI, lIIIllIIIIlllIl, lIIIllIIIIlllII, lIIIllIIIlIlIlI + 1.0, lIIIllIIIIlllIl + 1.0, lIIIllIIIIlllII + 1.0), IEntitySelector.selectInventories);
            if (lIIIllIIIlIIIII.size() > 0) {
                lIIIllIIIlIIlll = lIIIllIIIlIIIII.get(lIIIllIIIIlllll.rand.nextInt(lIIIllIIIlIIIII.size()));
            }
        }
        return (IInventory)lIIIllIIIlIIlll;
    }
    
    public static IInventory func_145884_b(final IHopper lIIIllIIlIIIllI) {
        return func_145893_b(lIIIllIIlIIIllI.getWorld(), lIIIllIIlIIIllI.getXPos(), lIIIllIIlIIIllI.getYPos() + 1.0, lIIIllIIlIIIllI.getZPos());
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.hopper";
    }
    
    private boolean func_174919_a(final IInventory lIIIllIlllIllII, final EnumFacing lIIIllIlllIIIlI) {
        if (lIIIllIlllIllII instanceof ISidedInventory) {
            final ISidedInventory lIIIllIlllIlIlI = (ISidedInventory)lIIIllIlllIllII;
            final int[] lIIIllIlllIlIIl = lIIIllIlllIlIlI.getSlotsForFace(lIIIllIlllIIIlI);
            for (int lIIIllIlllIlIII = 0; lIIIllIlllIlIII < lIIIllIlllIlIIl.length; ++lIIIllIlllIlIII) {
                final ItemStack lIIIllIlllIIlll = lIIIllIlllIlIlI.getStackInSlot(lIIIllIlllIlIIl[lIIIllIlllIlIII]);
                if (lIIIllIlllIIlll == null || lIIIllIlllIIlll.stackSize != lIIIllIlllIIlll.getMaxStackSize()) {
                    return false;
                }
            }
        }
        else {
            for (int lIIIllIlllIIllI = lIIIllIlllIllII.getSizeInventory(), lIIIllIlllIIlIl = 0; lIIIllIlllIIlIl < lIIIllIlllIIllI; ++lIIIllIlllIIlIl) {
                final ItemStack lIIIllIlllIIlII = lIIIllIlllIllII.getStackInSlot(lIIIllIlllIIlIl);
                if (lIIIllIlllIIlII == null || lIIIllIlllIIlII.stackSize != lIIIllIlllIIlII.getMaxStackSize()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isOnTransferCooldown() {
        return this.transferCooldown > 0;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    private boolean func_152104_k() {
        for (final ItemStack lIIIlllIIIllIlI : this.inventory) {
            if (lIIIlllIIIllIlI != null) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public double getZPos() {
        return this.pos.getZ();
    }
    
    @Override
    public boolean isItemValidForSlot(final int lIIIlllIIlIlllI, final ItemStack lIIIlllIIlIllIl) {
        return true;
    }
    
    @Override
    public ItemStack decrStackSize(final int lIIIlllIllIIIII, final int lIIIlllIlIllIlI) {
        if (this.inventory[lIIIlllIllIIIII] == null) {
            return null;
        }
        if (this.inventory[lIIIlllIllIIIII].stackSize <= lIIIlllIlIllIlI) {
            final ItemStack lIIIlllIlIllllI = this.inventory[lIIIlllIllIIIII];
            this.inventory[lIIIlllIllIIIII] = null;
            return lIIIlllIlIllllI;
        }
        final ItemStack lIIIlllIlIlllIl = this.inventory[lIIIlllIllIIIII].splitStack(lIIIlllIlIllIlI);
        if (this.inventory[lIIIlllIllIIIII].stackSize == 0) {
            this.inventory[lIIIlllIllIIIII] = null;
        }
        return lIIIlllIlIlllIl;
    }
    
    @Override
    public void openInventory(final EntityPlayer lIIIlllIIllIIlI) {
    }
    
    public static boolean func_145898_a(final IInventory lIIIllIlIIlllIl, final EntityItem lIIIllIlIIlIlll) {
        boolean lIIIllIlIIllIll = false;
        if (lIIIllIlIIlIlll == null) {
            return false;
        }
        final ItemStack lIIIllIlIIllIlI = lIIIllIlIIlIlll.getEntityItem().copy();
        final ItemStack lIIIllIlIIllIIl = func_174918_a(lIIIllIlIIlllIl, lIIIllIlIIllIlI, null);
        if (lIIIllIlIIllIIl != null && lIIIllIlIIllIIl.stackSize != 0) {
            lIIIllIlIIlIlll.setEntityItemStack(lIIIllIlIIllIIl);
        }
        else {
            lIIIllIlIIllIll = true;
            lIIIllIlIIlIlll.setDead();
        }
        return lIIIllIlIIllIll;
    }
    
    private static boolean func_174921_b(final IInventory lIIIllIIllIlIll, final ItemStack lIIIllIIllIlllI, final int lIIIllIIllIllIl, final EnumFacing lIIIllIIllIlIII) {
        return !(lIIIllIIllIlIll instanceof ISidedInventory) || ((ISidedInventory)lIIIllIIllIlIll).canExtractItem(lIIIllIIllIllIl, lIIIllIIllIlllI, lIIIllIIllIlIII);
    }
    
    @Override
    public void closeInventory(final EntityPlayer lIIIlllIIllIIII) {
    }
    
    private static boolean func_174917_b(final IInventory lIIIllIllIlIIIl, final EnumFacing lIIIllIllIlIIII) {
        if (lIIIllIllIlIIIl instanceof ISidedInventory) {
            final ISidedInventory lIIIllIllIlIllI = (ISidedInventory)lIIIllIllIlIIIl;
            final int[] lIIIllIllIlIlIl = lIIIllIllIlIllI.getSlotsForFace(lIIIllIllIlIIII);
            for (int lIIIllIllIlIlII = 0; lIIIllIllIlIlII < lIIIllIllIlIlIl.length; ++lIIIllIllIlIlII) {
                if (lIIIllIllIlIllI.getStackInSlot(lIIIllIllIlIlIl[lIIIllIllIlIlII]) != null) {
                    return false;
                }
            }
        }
        else {
            for (int lIIIllIllIlIIll = lIIIllIllIlIIIl.getSizeInventory(), lIIIllIllIlIIlI = 0; lIIIllIllIlIIlI < lIIIllIllIlIIll; ++lIIIllIllIlIIlI) {
                if (lIIIllIllIlIIIl.getStackInSlot(lIIIllIllIlIIlI) != null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean func_145891_a(final IHopper lIIIllIlIllllIl) {
        final IInventory lIIIllIllIIIlIl = func_145884_b(lIIIllIlIllllIl);
        if (lIIIllIllIIIlIl != null) {
            final EnumFacing lIIIllIllIIIlII = EnumFacing.DOWN;
            if (func_174917_b(lIIIllIllIIIlIl, lIIIllIllIIIlII)) {
                return false;
            }
            if (lIIIllIllIIIlIl instanceof ISidedInventory) {
                final ISidedInventory lIIIllIllIIIIll = (ISidedInventory)lIIIllIllIIIlIl;
                final int[] lIIIllIllIIIIlI = lIIIllIllIIIIll.getSlotsForFace(lIIIllIllIIIlII);
                for (int lIIIllIllIIIIIl = 0; lIIIllIllIIIIIl < lIIIllIllIIIIlI.length; ++lIIIllIllIIIIIl) {
                    if (func_174915_a(lIIIllIlIllllIl, lIIIllIllIIIlIl, lIIIllIllIIIIlI[lIIIllIllIIIIIl], lIIIllIllIIIlII)) {
                        return true;
                    }
                }
            }
            else {
                for (int lIIIllIllIIIIII = lIIIllIllIIIlIl.getSizeInventory(), lIIIllIlIllllll = 0; lIIIllIlIllllll < lIIIllIllIIIIII; ++lIIIllIlIllllll) {
                    if (func_174915_a(lIIIllIlIllllIl, lIIIllIllIIIlIl, lIIIllIlIllllll, lIIIllIllIIIlII)) {
                        return true;
                    }
                }
            }
        }
        else {
            final EntityItem lIIIllIlIlllllI = func_145897_a(lIIIllIlIllllIl.getWorld(), lIIIllIlIllllIl.getXPos(), lIIIllIlIllllIl.getYPos() + 1.0, lIIIllIlIllllIl.getZPos());
            if (lIIIllIlIlllllI != null) {
                return func_145898_a(lIIIllIlIllllIl, lIIIllIlIlllllI);
            }
        }
        return false;
    }
    
    private static boolean canCombine(final ItemStack lIIIllIIIIlIIII, final ItemStack lIIIllIIIIIllll) {
        return lIIIllIIIIlIIII.getItem() == lIIIllIIIIIllll.getItem() && lIIIllIIIIlIIII.getMetadata() == lIIIllIIIIIllll.getMetadata() && lIIIllIIIIlIIII.stackSize <= lIIIllIIIIlIIII.getMaxStackSize() && ItemStack.areItemStackTagsEqual(lIIIllIIIIlIIII, lIIIllIIIIIllll);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lIIIllllIIIIlIl) {
        super.readFromNBT(lIIIllllIIIIlIl);
        final NBTTagList lIIIllllIIIlIlI = lIIIllllIIIIlIl.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];
        if (lIIIllllIIIIlIl.hasKey("CustomName", 8)) {
            this.customName = lIIIllllIIIIlIl.getString("CustomName");
        }
        this.transferCooldown = lIIIllllIIIIlIl.getInteger("TransferCooldown");
        for (int lIIIllllIIIlIIl = 0; lIIIllllIIIlIIl < lIIIllllIIIlIlI.tagCount(); ++lIIIllllIIIlIIl) {
            final NBTTagCompound lIIIllllIIIlIII = lIIIllllIIIlIlI.getCompoundTagAt(lIIIllllIIIlIIl);
            final byte lIIIllllIIIIlll = lIIIllllIIIlIII.getByte("Slot");
            if (lIIIllllIIIIlll >= 0 && lIIIllllIIIIlll < this.inventory.length) {
                this.inventory[lIIIllllIIIIlll] = ItemStack.loadItemStackFromNBT(lIIIllllIIIlIII);
            }
        }
    }
}
