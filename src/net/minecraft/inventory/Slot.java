package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class Slot
{
    private final /* synthetic */ int slotIndex;
    public /* synthetic */ int xDisplayPosition;
    public final /* synthetic */ IInventory inventory;
    public /* synthetic */ int yDisplayPosition;
    
    static {
        __OBFID = "CL_00001762";
    }
    
    public boolean canTakeStack(final EntityPlayer llllllllllllllIIlIllllIlllIIlIll) {
        return true;
    }
    
    public boolean canBeHovered() {
        return true;
    }
    
    public int func_178170_b(final ItemStack llllllllllllllIIlIllllIlllIllllI) {
        return this.getSlotStackLimit();
    }
    
    public boolean isItemValid(final ItemStack llllllllllllllIIlIllllIlllllIIll) {
        return true;
    }
    
    protected void onCrafting(final ItemStack llllllllllllllIIlIllllIlllllllIl, final int llllllllllllllIIlIllllIlllllllII) {
    }
    
    public boolean getHasStack() {
        return this.getStack() != null;
    }
    
    public void onSlotChange(final ItemStack llllllllllllllIIlIlllllIIIIIIIIl, final ItemStack llllllllllllllIIlIlllllIIIIIIIII) {
        if (llllllllllllllIIlIlllllIIIIIIIIl != null && llllllllllllllIIlIlllllIIIIIIIII != null && llllllllllllllIIlIlllllIIIIIIIIl.getItem() == llllllllllllllIIlIlllllIIIIIIIII.getItem()) {
            final int llllllllllllllIIlIlllllIIIIIIIll = llllllllllllllIIlIlllllIIIIIIIII.stackSize - llllllllllllllIIlIlllllIIIIIIIIl.stackSize;
            if (llllllllllllllIIlIlllllIIIIIIIll > 0) {
                this.onCrafting(llllllllllllllIIlIlllllIIIIIIIIl, llllllllllllllIIlIlllllIIIIIIIll);
            }
        }
    }
    
    public boolean isHere(final IInventory llllllllllllllIIlIllllIlllIlIIIl, final int llllllllllllllIIlIllllIlllIIllIl) {
        return llllllllllllllIIlIllllIlllIlIIIl == this.inventory && llllllllllllllIIlIllllIlllIIllIl == this.slotIndex;
    }
    
    public String func_178171_c() {
        return null;
    }
    
    public void onPickupFromSlot(final EntityPlayer llllllllllllllIIlIllllIlllllIlll, final ItemStack llllllllllllllIIlIllllIlllllIllI) {
        this.onSlotChanged();
    }
    
    public ItemStack getStack() {
        return this.inventory.getStackInSlot(this.slotIndex);
    }
    
    public void onSlotChanged() {
        this.inventory.markDirty();
    }
    
    protected void onCrafting(final ItemStack llllllllllllllIIlIllllIllllllIlI) {
    }
    
    public void putStack(final ItemStack llllllllllllllIIlIllllIllllIlIIl) {
        this.inventory.setInventorySlotContents(this.slotIndex, llllllllllllllIIlIllllIllllIlIIl);
        this.onSlotChanged();
    }
    
    public int getSlotStackLimit() {
        return this.inventory.getInventoryStackLimit();
    }
    
    public ItemStack decrStackSize(final int llllllllllllllIIlIllllIlllIllIII) {
        return this.inventory.decrStackSize(this.slotIndex, llllllllllllllIIlIllllIlllIllIII);
    }
    
    public Slot(final IInventory llllllllllllllIIlIlllllIIIIIlllI, final int llllllllllllllIIlIlllllIIIIIllIl, final int llllllllllllllIIlIlllllIIIIlIIIl, final int llllllllllllllIIlIlllllIIIIlIIII) {
        this.inventory = llllllllllllllIIlIlllllIIIIIlllI;
        this.slotIndex = llllllllllllllIIlIlllllIIIIIllIl;
        this.xDisplayPosition = llllllllllllllIIlIlllllIIIIlIIIl;
        this.yDisplayPosition = llllllllllllllIIlIlllllIIIIlIIII;
    }
}
