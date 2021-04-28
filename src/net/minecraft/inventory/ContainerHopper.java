package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerHopper extends Container
{
    private final /* synthetic */ IInventory field_94538_a;
    
    public ContainerHopper(final InventoryPlayer lllllllllllllllIllllIllllIIllIlI, final IInventory lllllllllllllllIllllIllllIIlIIlI, final EntityPlayer lllllllllllllllIllllIllllIIlIIIl) {
        this.field_94538_a = lllllllllllllllIllllIllllIIlIIlI;
        lllllllllllllllIllllIllllIIlIIlI.openInventory(lllllllllllllllIllllIllllIIlIIIl);
        final byte lllllllllllllllIllllIllllIIlIlll = 51;
        for (int lllllllllllllllIllllIllllIIlIllI = 0; lllllllllllllllIllllIllllIIlIllI < lllllllllllllllIllllIllllIIlIIlI.getSizeInventory(); ++lllllllllllllllIllllIllllIIlIllI) {
            this.addSlotToContainer(new Slot(lllllllllllllllIllllIllllIIlIIlI, lllllllllllllllIllllIllllIIlIllI, 44 + lllllllllllllllIllllIllllIIlIllI * 18, 20));
        }
        for (int lllllllllllllllIllllIllllIIlIllI = 0; lllllllllllllllIllllIllllIIlIllI < 3; ++lllllllllllllllIllllIllllIIlIllI) {
            for (int lllllllllllllllIllllIllllIIlIlIl = 0; lllllllllllllllIllllIllllIIlIlIl < 9; ++lllllllllllllllIllllIllllIIlIlIl) {
                this.addSlotToContainer(new Slot(lllllllllllllllIllllIllllIIllIlI, lllllllllllllllIllllIllllIIlIlIl + lllllllllllllllIllllIllllIIlIllI * 9 + 9, 8 + lllllllllllllllIllllIllllIIlIlIl * 18, lllllllllllllllIllllIllllIIlIllI * 18 + lllllllllllllllIllllIllllIIlIlll));
            }
        }
        for (int lllllllllllllllIllllIllllIIlIllI = 0; lllllllllllllllIllllIllllIIlIllI < 9; ++lllllllllllllllIllllIllllIIlIllI) {
            this.addSlotToContainer(new Slot(lllllllllllllllIllllIllllIIllIlI, lllllllllllllllIllllIllllIIlIllI, 8 + lllllllllllllllIllllIllllIIlIllI * 18, 58 + lllllllllllllllIllllIllllIIlIlll));
        }
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllllIllllIlllIlllIlII) {
        super.onContainerClosed(lllllllllllllllIllllIlllIlllIlII);
        this.field_94538_a.closeInventory(lllllllllllllllIllllIlllIlllIlII);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllllIllllIllllIIIlIII) {
        return this.field_94538_a.isUseableByPlayer(lllllllllllllllIllllIllllIIIlIII);
    }
    
    static {
        __OBFID = "CL_00001750";
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllllIllllIllllIIIIIIl, final int lllllllllllllllIllllIlllIllllIll) {
        ItemStack lllllllllllllllIllllIlllIlllllll = null;
        final Slot lllllllllllllllIllllIlllIllllllI = this.inventorySlots.get(lllllllllllllllIllllIlllIllllIll);
        if (lllllllllllllllIllllIlllIllllllI != null && lllllllllllllllIllllIlllIllllllI.getHasStack()) {
            final ItemStack lllllllllllllllIllllIlllIlllllIl = lllllllllllllllIllllIlllIllllllI.getStack();
            lllllllllllllllIllllIlllIlllllll = lllllllllllllllIllllIlllIlllllIl.copy();
            if (lllllllllllllllIllllIlllIllllIll < this.field_94538_a.getSizeInventory()) {
                if (!this.mergeItemStack(lllllllllllllllIllllIlllIlllllIl, this.field_94538_a.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllllIllllIlllIlllllIl, 0, this.field_94538_a.getSizeInventory(), false)) {
                return null;
            }
            if (lllllllllllllllIllllIlllIlllllIl.stackSize == 0) {
                lllllllllllllllIllllIlllIllllllI.putStack(null);
            }
            else {
                lllllllllllllllIllllIlllIllllllI.onSlotChanged();
            }
        }
        return lllllllllllllllIllllIlllIlllllll;
    }
}
