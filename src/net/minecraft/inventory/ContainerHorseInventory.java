package net.minecraft.inventory;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class ContainerHorseInventory extends Container
{
    private /* synthetic */ IInventory field_111243_a;
    private /* synthetic */ EntityHorse theHorse;
    
    static {
        __OBFID = "CL_00001751";
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllllIllllllllIIlllIl) {
        return this.field_111243_a.isUseableByPlayer(llllllllllllllllIllllllllIIlllIl) && this.theHorse.isEntityAlive() && this.theHorse.getDistanceToEntity(llllllllllllllllIllllllllIIlllIl) < 8.0f;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllllIlllllllIllllIII) {
        super.onContainerClosed(llllllllllllllllIlllllllIllllIII);
        this.field_111243_a.closeInventory(llllllllllllllllIlllllllIllllIII);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllllIllllllllIIIlIlI, final int llllllllllllllllIllllllllIIIlIIl) {
        ItemStack llllllllllllllllIllllllllIIIlIII = null;
        final Slot llllllllllllllllIllllllllIIIIlll = this.inventorySlots.get(llllllllllllllllIllllllllIIIlIIl);
        if (llllllllllllllllIllllllllIIIIlll != null && llllllllllllllllIllllllllIIIIlll.getHasStack()) {
            final ItemStack llllllllllllllllIllllllllIIIIllI = llllllllllllllllIllllllllIIIIlll.getStack();
            llllllllllllllllIllllllllIIIlIII = llllllllllllllllIllllllllIIIIllI.copy();
            if (llllllllllllllllIllllllllIIIlIIl < this.field_111243_a.getSizeInventory()) {
                if (!this.mergeItemStack(llllllllllllllllIllllllllIIIIllI, this.field_111243_a.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return null;
                }
            }
            else if (this.getSlot(1).isItemValid(llllllllllllllllIllllllllIIIIllI) && !this.getSlot(1).getHasStack()) {
                if (!this.mergeItemStack(llllllllllllllllIllllllllIIIIllI, 1, 2, false)) {
                    return null;
                }
            }
            else if (this.getSlot(0).isItemValid(llllllllllllllllIllllllllIIIIllI)) {
                if (!this.mergeItemStack(llllllllllllllllIllllllllIIIIllI, 0, 1, false)) {
                    return null;
                }
            }
            else if (this.field_111243_a.getSizeInventory() <= 2 || !this.mergeItemStack(llllllllllllllllIllllllllIIIIllI, 2, this.field_111243_a.getSizeInventory(), false)) {
                return null;
            }
            if (llllllllllllllllIllllllllIIIIllI.stackSize == 0) {
                llllllllllllllllIllllllllIIIIlll.putStack(null);
            }
            else {
                llllllllllllllllIllllllllIIIIlll.onSlotChanged();
            }
        }
        return llllllllllllllllIllllllllIIIlIII;
    }
    
    public ContainerHorseInventory(final IInventory llllllllllllllllIlllllllllIIIllI, final IInventory llllllllllllllllIlllllllllIIIlIl, final EntityHorse llllllllllllllllIllllllllIllIlll, final EntityPlayer llllllllllllllllIlllllllllIIIIll) {
        this.field_111243_a = llllllllllllllllIlllllllllIIIlIl;
        this.theHorse = llllllllllllllllIllllllllIllIlll;
        final byte llllllllllllllllIlllllllllIIIIlI = 3;
        llllllllllllllllIlllllllllIIIlIl.openInventory(llllllllllllllllIlllllllllIIIIll);
        final int llllllllllllllllIlllllllllIIIIIl = (llllllllllllllllIlllllllllIIIIlI - 4) * 18;
        this.addSlotToContainer(new Slot(llllllllllllllllIlllllllllIIIlIl, 0, 8, 18) {
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllllIIIIIIIIlIIllIllI) {
                return super.isItemValid(lllllllllllllllIIIIIIIIlIIllIllI) && lllllllllllllllIIIIIIIIlIIllIllI.getItem() == Items.saddle && !this.getHasStack();
            }
            
            static {
                __OBFID = "CL_00001752";
            }
        });
        this.addSlotToContainer(new Slot(llllllllllllllllIlllllllllIIIlIl, 1, 8, 36) {
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllllIlIIIllIlIlIIIlIl) {
                return super.isItemValid(lllllllllllllllIlIIIllIlIlIIIlIl) && llllllllllllllllIllllllllIllIlll.canWearArmor() && EntityHorse.func_146085_a(lllllllllllllllIlIIIllIlIlIIIlIl.getItem());
            }
            
            @Override
            public boolean canBeHovered() {
                return llllllllllllllllIllllllllIllIlll.canWearArmor();
            }
            
            static {
                __OBFID = "CL_00001753";
            }
        });
        if (llllllllllllllllIllllllllIllIlll.isChested()) {
            for (int llllllllllllllllIlllllllllIIIIII = 0; llllllllllllllllIlllllllllIIIIII < llllllllllllllllIlllllllllIIIIlI; ++llllllllllllllllIlllllllllIIIIII) {
                for (int llllllllllllllllIllllllllIlllllI = 0; llllllllllllllllIllllllllIlllllI < 5; ++llllllllllllllllIllllllllIlllllI) {
                    this.addSlotToContainer(new Slot(llllllllllllllllIlllllllllIIIlIl, 2 + llllllllllllllllIllllllllIlllllI + llllllllllllllllIlllllllllIIIIII * 5, 80 + llllllllllllllllIllllllllIlllllI * 18, 18 + llllllllllllllllIlllllllllIIIIII * 18));
                }
            }
        }
        for (int llllllllllllllllIllllllllIllllll = 0; llllllllllllllllIllllllllIllllll < 3; ++llllllllllllllllIllllllllIllllll) {
            for (int llllllllllllllllIllllllllIllllIl = 0; llllllllllllllllIllllllllIllllIl < 9; ++llllllllllllllllIllllllllIllllIl) {
                this.addSlotToContainer(new Slot(llllllllllllllllIlllllllllIIIllI, llllllllllllllllIllllllllIllllIl + llllllllllllllllIllllllllIllllll * 9 + 9, 8 + llllllllllllllllIllllllllIllllIl * 18, 102 + llllllllllllllllIllllllllIllllll * 18 + llllllllllllllllIlllllllllIIIIIl));
            }
        }
        for (int llllllllllllllllIllllllllIllllll = 0; llllllllllllllllIllllllllIllllll < 9; ++llllllllllllllllIllllllllIllllll) {
            this.addSlotToContainer(new Slot(llllllllllllllllIlllllllllIIIllI, llllllllllllllllIllllllllIllllll, 8 + llllllllllllllllIllllllllIllllll * 18, 160 + llllllllllllllllIlllllllllIIIIIl));
        }
    }
}
