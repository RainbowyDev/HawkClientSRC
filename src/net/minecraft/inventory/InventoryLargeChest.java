package net.minecraft.inventory;

import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;

public class InventoryLargeChest implements ILockableContainer
{
    private /* synthetic */ ILockableContainer upperChest;
    private /* synthetic */ String name;
    private /* synthetic */ ILockableContainer lowerChest;
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllllIIlIIIIIlIIIllII) {
        this.upperChest.openInventory(llllllllllllllllIIlIIIIIlIIIllII);
        this.lowerChest.openInventory(llllllllllllllllIIlIIIIIlIIIllII);
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllllIIlIIIIIlIIIIlII) {
        this.upperChest.closeInventory(llllllllllllllllIIlIIIIIlIIIIlII);
        this.lowerChest.closeInventory(llllllllllllllllIIlIIIIIlIIIIlII);
    }
    
    @Override
    public int getSizeInventory() {
        return this.upperChest.getSizeInventory() + this.lowerChest.getSizeInventory();
    }
    
    public boolean isPartOfLargeChest(final IInventory llllllllllllllllIIlIIIIIllIIIIll) {
        return this.upperChest == llllllllllllllllIIlIIIIIllIIIIll || this.lowerChest == llllllllllllllllIIlIIIIIllIIIIll;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return this.upperChest.getInventoryStackLimit();
    }
    
    @Override
    public boolean isLocked() {
        return this.upperChest.isLocked() || this.lowerChest.isLocked();
    }
    
    @Override
    public LockCode getLockCode() {
        return this.upperChest.getLockCode();
    }
    
    @Override
    public boolean hasCustomName() {
        return this.upperChest.hasCustomName() || this.lowerChest.hasCustomName();
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllllIIlIIIIIlIIIIIlI, final ItemStack llllllllllllllllIIlIIIIIlIIIIIIl) {
        return true;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllllIIlIIIIIlIlIIIII, final ItemStack llllllllllllllllIIlIIIIIlIIlllII) {
        if (llllllllllllllllIIlIIIIIlIlIIIII >= this.upperChest.getSizeInventory()) {
            this.lowerChest.setInventorySlotContents(llllllllllllllllIIlIIIIIlIlIIIII - this.upperChest.getSizeInventory(), llllllllllllllllIIlIIIIIlIIlllII);
        }
        else {
            this.upperChest.setInventorySlotContents(llllllllllllllllIIlIIIIIlIlIIIII, llllllllllllllllIIlIIIIIlIIlllII);
        }
    }
    
    @Override
    public void setField(final int llllllllllllllllIIlIIIIIIlllllIl, final int llllllllllllllllIIlIIIIIIlllllII) {
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public void markDirty() {
        this.upperChest.markDirty();
        this.lowerChest.markDirty();
    }
    
    @Override
    public String getName() {
        return this.upperChest.hasCustomName() ? this.upperChest.getName() : (this.lowerChest.hasCustomName() ? this.lowerChest.getName() : this.name);
    }
    
    static {
        __OBFID = "CL_00001507";
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllllIIlIIIIIlIllIllI) {
        return (llllllllllllllllIIlIIIIIlIllIllI >= this.upperChest.getSizeInventory()) ? this.lowerChest.getStackInSlot(llllllllllllllllIIlIIIIIlIllIllI - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlot(llllllllllllllllIIlIIIIIlIllIllI);
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllllIIlIIIIIlIlIllll, final int llllllllllllllllIIlIIIIIlIlIlllI) {
        return (llllllllllllllllIIlIIIIIlIlIllll >= this.upperChest.getSizeInventory()) ? this.lowerChest.decrStackSize(llllllllllllllllIIlIIIIIlIlIllll - this.upperChest.getSizeInventory(), llllllllllllllllIIlIIIIIlIlIlllI) : this.upperChest.decrStackSize(llllllllllllllllIIlIIIIIlIlIllll, llllllllllllllllIIlIIIIIlIlIlllI);
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllllIIlIIIIIIllIIlII, final EntityPlayer llllllllllllllllIIlIIIIIIllIIllI) {
        return new ContainerChest(llllllllllllllllIIlIIIIIIllIIlII, this, llllllllllllllllIIlIIIIIIllIIllI);
    }
    
    @Override
    public void setLockCode(final LockCode llllllllllllllllIIlIIIIIIlllIIlI) {
        this.upperChest.setLockCode(llllllllllllllllIIlIIIIIIlllIIlI);
        this.lowerChest.setLockCode(llllllllllllllllIIlIIIIIIlllIIlI);
    }
    
    @Override
    public String getGuiID() {
        return this.upperChest.getGuiID();
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllllIIlIIIIIlIIlIIII) {
        return this.upperChest.isUseableByPlayer(llllllllllllllllIIlIIIIIlIIlIIII) && this.lowerChest.isUseableByPlayer(llllllllllllllllIIlIIIIIlIIlIIII);
    }
    
    @Override
    public void clearInventory() {
        this.upperChest.clearInventory();
        this.lowerChest.clearInventory();
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public int getField(final int llllllllllllllllIIlIIIIIIlllllll) {
        return 0;
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllllllllllllIIlIIIIIlIlIIlll) {
        return (llllllllllllllllIIlIIIIIlIlIIlll >= this.upperChest.getSizeInventory()) ? this.lowerChest.getStackInSlotOnClosing(llllllllllllllllIIlIIIIIlIlIIlll - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlotOnClosing(llllllllllllllllIIlIIIIIlIlIIlll);
    }
    
    public InventoryLargeChest(final String llllllllllllllllIIlIIIIIllIIlllI, ILockableContainer llllllllllllllllIIlIIIIIllIIllIl, ILockableContainer llllllllllllllllIIlIIIIIllIIllII) {
        this.name = llllllllllllllllIIlIIIIIllIIlllI;
        if (llllllllllllllllIIlIIIIIllIIllIl == null) {
            llllllllllllllllIIlIIIIIllIIllIl = llllllllllllllllIIlIIIIIllIIllII;
        }
        if (llllllllllllllllIIlIIIIIllIIllII == null) {
            llllllllllllllllIIlIIIIIllIIllII = llllllllllllllllIIlIIIIIllIIllIl;
        }
        this.upperChest = (ILockableContainer)llllllllllllllllIIlIIIIIllIIllIl;
        this.lowerChest = (ILockableContainer)llllllllllllllllIIlIIIIIllIIllII;
        if (((ILockableContainer)llllllllllllllllIIlIIIIIllIIllIl).isLocked()) {
            ((ILockableContainer)llllllllllllllllIIlIIIIIllIIllII).setLockCode(((ILockableContainer)llllllllllllllllIIlIIIIIllIIllIl).getLockCode());
        }
        else if (((ILockableContainer)llllllllllllllllIIlIIIIIllIIllII).isLocked()) {
            ((ILockableContainer)llllllllllllllllIIlIIIIIllIIllIl).setLockCode(((ILockableContainer)llllllllllllllllIIlIIIIIllIIllII).getLockCode());
        }
    }
}
