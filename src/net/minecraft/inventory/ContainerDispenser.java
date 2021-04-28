package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerDispenser extends Container
{
    private /* synthetic */ IInventory field_178146_a;
    
    static {
        __OBFID = "CL_00001763";
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllIlIlllIllIlI) {
        return this.field_178146_a.isUseableByPlayer(lllIlIlllIllIlI);
    }
    
    public ContainerDispenser(final IInventory lllIlIllllIlIIl, final IInventory lllIlIllllIIIlI) {
        this.field_178146_a = lllIlIllllIIIlI;
        for (int lllIlIllllIIlll = 0; lllIlIllllIIlll < 3; ++lllIlIllllIIlll) {
            for (int lllIlIllllIIllI = 0; lllIlIllllIIllI < 3; ++lllIlIllllIIllI) {
                this.addSlotToContainer(new Slot(lllIlIllllIIIlI, lllIlIllllIIllI + lllIlIllllIIlll * 3, 62 + lllIlIllllIIllI * 18, 17 + lllIlIllllIIlll * 18));
            }
        }
        for (int lllIlIllllIIlll = 0; lllIlIllllIIlll < 3; ++lllIlIllllIIlll) {
            for (int lllIlIllllIIlIl = 0; lllIlIllllIIlIl < 9; ++lllIlIllllIIlIl) {
                this.addSlotToContainer(new Slot(lllIlIllllIlIIl, lllIlIllllIIlIl + lllIlIllllIIlll * 9 + 9, 8 + lllIlIllllIIlIl * 18, 84 + lllIlIllllIIlll * 18));
            }
        }
        for (int lllIlIllllIIlll = 0; lllIlIllllIIlll < 9; ++lllIlIllllIIlll) {
            this.addSlotToContainer(new Slot(lllIlIllllIlIIl, lllIlIllllIIlll, 8 + lllIlIllllIIlll * 18, 142));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllIlIlllIlIIlI, final int lllIlIlllIIlIll) {
        ItemStack lllIlIlllIlIIII = null;
        final Slot lllIlIlllIIllll = this.inventorySlots.get(lllIlIlllIIlIll);
        if (lllIlIlllIIllll != null && lllIlIlllIIllll.getHasStack()) {
            final ItemStack lllIlIlllIIlllI = lllIlIlllIIllll.getStack();
            lllIlIlllIlIIII = lllIlIlllIIlllI.copy();
            if (lllIlIlllIIlIll < 9) {
                if (!this.mergeItemStack(lllIlIlllIIlllI, 9, 45, true)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(lllIlIlllIIlllI, 0, 9, false)) {
                return null;
            }
            if (lllIlIlllIIlllI.stackSize == 0) {
                lllIlIlllIIllll.putStack(null);
            }
            else {
                lllIlIlllIIllll.onSlotChanged();
            }
            if (lllIlIlllIIlllI.stackSize == lllIlIlllIlIIII.stackSize) {
                return null;
            }
            lllIlIlllIIllll.onPickupFromSlot(lllIlIlllIlIIlI, lllIlIlllIIlllI);
        }
        return lllIlIlllIlIIII;
    }
}
