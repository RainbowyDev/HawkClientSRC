package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerChest extends Container
{
    public /* synthetic */ IInventory lowerChestInventory;
    private /* synthetic */ int numRows;
    
    public ContainerChest(final IInventory llllllllllllllIIIllIIlllIlIIIlIl, final IInventory llllllllllllllIIIllIIlllIIllllII, final EntityPlayer llllllllllllllIIIllIIlllIlIIIIll) {
        this.lowerChestInventory = llllllllllllllIIIllIIlllIIllllII;
        this.numRows = llllllllllllllIIIllIIlllIIllllII.getSizeInventory() / 9;
        llllllllllllllIIIllIIlllIIllllII.openInventory(llllllllllllllIIIllIIlllIlIIIIll);
        final int llllllllllllllIIIllIIlllIlIIIIlI = (this.numRows - 4) * 18;
        for (int llllllllllllllIIIllIIlllIlIIIIIl = 0; llllllllllllllIIIllIIlllIlIIIIIl < this.numRows; ++llllllllllllllIIIllIIlllIlIIIIIl) {
            for (int llllllllllllllIIIllIIlllIlIIIIII = 0; llllllllllllllIIIllIIlllIlIIIIII < 9; ++llllllllllllllIIIllIIlllIlIIIIII) {
                this.addSlotToContainer(new Slot(llllllllllllllIIIllIIlllIIllllII, llllllllllllllIIIllIIlllIlIIIIII + llllllllllllllIIIllIIlllIlIIIIIl * 9, 8 + llllllllllllllIIIllIIlllIlIIIIII * 18, 18 + llllllllllllllIIIllIIlllIlIIIIIl * 18));
            }
        }
        for (int llllllllllllllIIIllIIlllIlIIIIIl = 0; llllllllllllllIIIllIIlllIlIIIIIl < 3; ++llllllllllllllIIIllIIlllIlIIIIIl) {
            for (int llllllllllllllIIIllIIlllIIllllll = 0; llllllllllllllIIIllIIlllIIllllll < 9; ++llllllllllllllIIIllIIlllIIllllll) {
                this.addSlotToContainer(new Slot(llllllllllllllIIIllIIlllIlIIIlIl, llllllllllllllIIIllIIlllIIllllll + llllllllllllllIIIllIIlllIlIIIIIl * 9 + 9, 8 + llllllllllllllIIIllIIlllIIllllll * 18, 103 + llllllllllllllIIIllIIlllIlIIIIIl * 18 + llllllllllllllIIIllIIlllIlIIIIlI));
            }
        }
        for (int llllllllllllllIIIllIIlllIlIIIIIl = 0; llllllllllllllIIIllIIlllIlIIIIIl < 9; ++llllllllllllllIIIllIIlllIlIIIIIl) {
            this.addSlotToContainer(new Slot(llllllllllllllIIIllIIlllIlIIIlIl, llllllllllllllIIIllIIlllIlIIIIIl, 8 + llllllllllllllIIIllIIlllIlIIIIIl * 18, 161 + llllllllllllllIIIllIIlllIlIIIIlI));
        }
    }
    
    public IInventory getLowerChestInventory() {
        return this.lowerChestInventory;
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIIIllIIlllIIlIlIll, final int llllllllllllllIIIllIIlllIIlIIlIl) {
        ItemStack llllllllllllllIIIllIIlllIIlIlIIl = null;
        final Slot llllllllllllllIIIllIIlllIIlIlIII = this.inventorySlots.get(llllllllllllllIIIllIIlllIIlIIlIl);
        if (llllllllllllllIIIllIIlllIIlIlIII != null && llllllllllllllIIIllIIlllIIlIlIII.getHasStack()) {
            final ItemStack llllllllllllllIIIllIIlllIIlIIlll = llllllllllllllIIIllIIlllIIlIlIII.getStack();
            llllllllllllllIIIllIIlllIIlIlIIl = llllllllllllllIIIllIIlllIIlIIlll.copy();
            if (llllllllllllllIIIllIIlllIIlIIlIl < this.numRows * 9) {
                if (!this.mergeItemStack(llllllllllllllIIIllIIlllIIlIIlll, this.numRows * 9, this.inventorySlots.size(), true)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllIIIllIIlllIIlIIlll, 0, this.numRows * 9, false)) {
                return null;
            }
            if (llllllllllllllIIIllIIlllIIlIIlll.stackSize == 0) {
                llllllllllllllIIIllIIlllIIlIlIII.putStack(null);
            }
            else {
                llllllllllllllIIIllIIlllIIlIlIII.onSlotChanged();
            }
        }
        return llllllllllllllIIIllIIlllIIlIlIIl;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllIIIllIIlllIIIllllI) {
        super.onContainerClosed(llllllllllllllIIIllIIlllIIIllllI);
        this.lowerChestInventory.closeInventory(llllllllllllllIIIllIIlllIIIllllI);
    }
    
    static {
        __OBFID = "CL_00001742";
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllIIIllIIlllIIllIIlI) {
        return this.lowerChestInventory.isUseableByPlayer(llllllllllllllIIIllIIlllIIllIIlI);
    }
}
