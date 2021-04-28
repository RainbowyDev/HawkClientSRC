package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class ContainerBeacon extends Container
{
    private final /* synthetic */ BeaconSlot beaconSlot;
    private /* synthetic */ IInventory tileBeacon;
    
    public ContainerBeacon(final IInventory llllllllllllllIIlllIIllllIllIllI, final IInventory llllllllllllllIIlllIIllllIllIlIl) {
        this.tileBeacon = llllllllllllllIIlllIIllllIllIlIl;
        final BeaconSlot beaconSlot = new BeaconSlot(llllllllllllllIIlllIIllllIllIlIl, 0, 136, 110);
        this.beaconSlot = beaconSlot;
        this.addSlotToContainer(beaconSlot);
        final byte llllllllllllllIIlllIIllllIlllIll = 36;
        final short llllllllllllllIIlllIIllllIlllIlI = 137;
        for (int llllllllllllllIIlllIIllllIlllIIl = 0; llllllllllllllIIlllIIllllIlllIIl < 3; ++llllllllllllllIIlllIIllllIlllIIl) {
            for (int llllllllllllllIIlllIIllllIlllIII = 0; llllllllllllllIIlllIIllllIlllIII < 9; ++llllllllllllllIIlllIIllllIlllIII) {
                this.addSlotToContainer(new Slot(llllllllllllllIIlllIIllllIllIllI, llllllllllllllIIlllIIllllIlllIII + llllllllllllllIIlllIIllllIlllIIl * 9 + 9, llllllllllllllIIlllIIllllIlllIll + llllllllllllllIIlllIIllllIlllIII * 18, llllllllllllllIIlllIIllllIlllIlI + llllllllllllllIIlllIIllllIlllIIl * 18));
            }
        }
        for (int llllllllllllllIIlllIIllllIlllIIl = 0; llllllllllllllIIlllIIllllIlllIIl < 9; ++llllllllllllllIIlllIIllllIlllIIl) {
            this.addSlotToContainer(new Slot(llllllllllllllIIlllIIllllIllIllI, llllllllllllllIIlllIIllllIlllIIl, llllllllllllllIIlllIIllllIlllIll + llllllllllllllIIlllIIllllIlllIIl * 18, 58 + llllllllllllllIIlllIIllllIlllIlI));
        }
    }
    
    @Override
    public void onCraftGuiOpened(final ICrafting llllllllllllllIIlllIIllllIlIlIll) {
        super.onCraftGuiOpened(llllllllllllllIIlllIIllllIlIlIll);
        llllllllllllllIIlllIIllllIlIlIll.func_175173_a(this, this.tileBeacon);
    }
    
    public IInventory func_180611_e() {
        return this.tileBeacon;
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIIlllIIllllIIlIIIl, final int llllllllllllllIIlllIIllllIIIlIlI) {
        ItemStack llllllllllllllIIlllIIllllIIIllll = null;
        final Slot llllllllllllllIIlllIIllllIIIlllI = this.inventorySlots.get(llllllllllllllIIlllIIllllIIIlIlI);
        if (llllllllllllllIIlllIIllllIIIlllI != null && llllllllllllllIIlllIIllllIIIlllI.getHasStack()) {
            final ItemStack llllllllllllllIIlllIIllllIIIllIl = llllllllllllllIIlllIIllllIIIlllI.getStack();
            llllllllllllllIIlllIIllllIIIllll = llllllllllllllIIlllIIllllIIIllIl.copy();
            if (llllllllllllllIIlllIIllllIIIlIlI == 0) {
                if (!this.mergeItemStack(llllllllllllllIIlllIIllllIIIllIl, 1, 37, true)) {
                    return null;
                }
                llllllllllllllIIlllIIllllIIIlllI.onSlotChange(llllllllllllllIIlllIIllllIIIllIl, llllllllllllllIIlllIIllllIIIllll);
            }
            else if (!this.beaconSlot.getHasStack() && this.beaconSlot.isItemValid(llllllllllllllIIlllIIllllIIIllIl) && llllllllllllllIIlllIIllllIIIllIl.stackSize == 1) {
                if (!this.mergeItemStack(llllllllllllllIIlllIIllllIIIllIl, 0, 1, false)) {
                    return null;
                }
            }
            else if (llllllllllllllIIlllIIllllIIIlIlI >= 1 && llllllllllllllIIlllIIllllIIIlIlI < 28) {
                if (!this.mergeItemStack(llllllllllllllIIlllIIllllIIIllIl, 28, 37, false)) {
                    return null;
                }
            }
            else if (llllllllllllllIIlllIIllllIIIlIlI >= 28 && llllllllllllllIIlllIIllllIIIlIlI < 37) {
                if (!this.mergeItemStack(llllllllllllllIIlllIIllllIIIllIl, 1, 28, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllIIlllIIllllIIIllIl, 1, 37, false)) {
                return null;
            }
            if (llllllllllllllIIlllIIllllIIIllIl.stackSize == 0) {
                llllllllllllllIIlllIIllllIIIlllI.putStack(null);
            }
            else {
                llllllllllllllIIlllIIllllIIIlllI.onSlotChanged();
            }
            if (llllllllllllllIIlllIIllllIIIllIl.stackSize == llllllllllllllIIlllIIllllIIIllll.stackSize) {
                return null;
            }
            llllllllllllllIIlllIIllllIIIlllI.onPickupFromSlot(llllllllllllllIIlllIIllllIIlIIIl, llllllllllllllIIlllIIllllIIIllIl);
        }
        return llllllllllllllIIlllIIllllIIIllll;
    }
    
    @Override
    public void updateProgressBar(final int llllllllllllllIIlllIIllllIlIIllI, final int llllllllllllllIIlllIIllllIlIIlIl) {
        this.tileBeacon.setField(llllllllllllllIIlllIIllllIlIIllI, llllllllllllllIIlllIIllllIlIIlIl);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllIIlllIIllllIIllIIl) {
        return this.tileBeacon.isUseableByPlayer(llllllllllllllIIlllIIllllIIllIIl);
    }
    
    static {
        __OBFID = "CL_00001735";
    }
    
    class BeaconSlot extends Slot
    {
        @Override
        public boolean isItemValid(final ItemStack llllllllllllllIIIlIlIlIllIllllIl) {
            return llllllllllllllIIIlIlIlIllIllllIl != null && (llllllllllllllIIIlIlIlIllIllllIl.getItem() == Items.emerald || llllllllllllllIIIlIlIlIllIllllIl.getItem() == Items.diamond || llllllllllllllIIIlIlIlIllIllllIl.getItem() == Items.gold_ingot || llllllllllllllIIIlIlIlIllIllllIl.getItem() == Items.iron_ingot);
        }
        
        @Override
        public int getSlotStackLimit() {
            return 1;
        }
        
        public BeaconSlot(final IInventory llllllllllllllIIIlIlIlIlllIIIlII, final int llllllllllllllIIIlIlIlIlllIIIIll, final int llllllllllllllIIIlIlIlIlllIIlIII, final int llllllllllllllIIIlIlIlIlllIIIlll) {
            super(llllllllllllllIIIlIlIlIlllIIIlII, llllllllllllllIIIlIlIlIlllIIIIll, llllllllllllllIIIlIlIlIlllIIlIII, llllllllllllllIIIlIlIlIlllIIIlll);
        }
        
        static {
            __OBFID = "CL_00001736";
        }
    }
}
