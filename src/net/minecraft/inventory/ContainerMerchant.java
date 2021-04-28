package net.minecraft.inventory;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerMerchant extends Container
{
    private final /* synthetic */ World theWorld;
    private /* synthetic */ InventoryMerchant merchantInventory;
    private /* synthetic */ IMerchant theMerchant;
    
    static {
        __OBFID = "CL_00001757";
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllllIllIIIlllIlIIIlI) {
        return this.theMerchant.getCustomer() == llllllllllllllllIllIIIlllIlIIIlI;
    }
    
    public ContainerMerchant(final InventoryPlayer llllllllllllllllIllIIIllllIIlIll, final IMerchant llllllllllllllllIllIIIllllIIlIlI, final World llllllllllllllllIllIIIllllIIIIll) {
        this.theMerchant = llllllllllllllllIllIIIllllIIlIlI;
        this.theWorld = llllllllllllllllIllIIIllllIIIIll;
        this.merchantInventory = new InventoryMerchant(llllllllllllllllIllIIIllllIIlIll.player, llllllllllllllllIllIIIllllIIlIlI);
        this.addSlotToContainer(new Slot(this.merchantInventory, 0, 36, 53));
        this.addSlotToContainer(new Slot(this.merchantInventory, 1, 62, 53));
        this.addSlotToContainer(new SlotMerchantResult(llllllllllllllllIllIIIllllIIlIll.player, llllllllllllllllIllIIIllllIIlIlI, this.merchantInventory, 2, 120, 53));
        for (int llllllllllllllllIllIIIllllIIlIII = 0; llllllllllllllllIllIIIllllIIlIII < 3; ++llllllllllllllllIllIIIllllIIlIII) {
            for (int llllllllllllllllIllIIIllllIIIlll = 0; llllllllllllllllIllIIIllllIIIlll < 9; ++llllllllllllllllIllIIIllllIIIlll) {
                this.addSlotToContainer(new Slot(llllllllllllllllIllIIIllllIIlIll, llllllllllllllllIllIIIllllIIIlll + llllllllllllllllIllIIIllllIIlIII * 9 + 9, 8 + llllllllllllllllIllIIIllllIIIlll * 18, 84 + llllllllllllllllIllIIIllllIIlIII * 18));
            }
        }
        for (int llllllllllllllllIllIIIllllIIlIII = 0; llllllllllllllllIllIIIllllIIlIII < 9; ++llllllllllllllllIllIIIllllIIlIII) {
            this.addSlotToContainer(new Slot(llllllllllllllllIllIIIllllIIlIll, llllllllllllllllIllIIIllllIIlIII, 8 + llllllllllllllllIllIIIllllIIlIII * 18, 142));
        }
    }
    
    @Override
    public void onCraftGuiOpened(final ICrafting llllllllllllllllIllIIIlllIlllIlI) {
        super.onCraftGuiOpened(llllllllllllllllIllIIIlllIlllIlI);
    }
    
    public InventoryMerchant getMerchantInventory() {
        return this.merchantInventory;
    }
    
    @Override
    public void updateProgressBar(final int llllllllllllllllIllIIIlllIlIIlll, final int llllllllllllllllIllIIIlllIlIIllI) {
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory llllllllllllllllIllIIIlllIlIllll) {
        this.merchantInventory.resetRecipeAndSlots();
        super.onCraftMatrixChanged(llllllllllllllllIllIIIlllIlIllll);
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllllIllIIIlllIIIlIIl) {
        super.onContainerClosed(llllllllllllllllIllIIIlllIIIlIIl);
        this.theMerchant.setCustomer(null);
        super.onContainerClosed(llllllllllllllllIllIIIlllIIIlIIl);
        if (!this.theWorld.isRemote) {
            ItemStack llllllllllllllllIllIIIlllIIIlIII = this.merchantInventory.getStackInSlotOnClosing(0);
            if (llllllllllllllllIllIIIlllIIIlIII != null) {
                llllllllllllllllIllIIIlllIIIlIIl.dropPlayerItemWithRandomChoice(llllllllllllllllIllIIIlllIIIlIII, false);
            }
            llllllllllllllllIllIIIlllIIIlIII = this.merchantInventory.getStackInSlotOnClosing(1);
            if (llllllllllllllllIllIIIlllIIIlIII != null) {
                llllllllllllllllIllIIIlllIIIlIIl.dropPlayerItemWithRandomChoice(llllllllllllllllIllIIIlllIIIlIII, false);
            }
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllllIllIIIlllIIllIII, final int llllllllllllllllIllIIIlllIIlIIIl) {
        ItemStack llllllllllllllllIllIIIlllIIlIllI = null;
        final Slot llllllllllllllllIllIIIlllIIlIlIl = this.inventorySlots.get(llllllllllllllllIllIIIlllIIlIIIl);
        if (llllllllllllllllIllIIIlllIIlIlIl != null && llllllllllllllllIllIIIlllIIlIlIl.getHasStack()) {
            final ItemStack llllllllllllllllIllIIIlllIIlIlII = llllllllllllllllIllIIIlllIIlIlIl.getStack();
            llllllllllllllllIllIIIlllIIlIllI = llllllllllllllllIllIIIlllIIlIlII.copy();
            if (llllllllllllllllIllIIIlllIIlIIIl == 2) {
                if (!this.mergeItemStack(llllllllllllllllIllIIIlllIIlIlII, 3, 39, true)) {
                    return null;
                }
                llllllllllllllllIllIIIlllIIlIlIl.onSlotChange(llllllllllllllllIllIIIlllIIlIlII, llllllllllllllllIllIIIlllIIlIllI);
            }
            else if (llllllllllllllllIllIIIlllIIlIIIl != 0 && llllllllllllllllIllIIIlllIIlIIIl != 1) {
                if (llllllllllllllllIllIIIlllIIlIIIl >= 3 && llllllllllllllllIllIIIlllIIlIIIl < 30) {
                    if (!this.mergeItemStack(llllllllllllllllIllIIIlllIIlIlII, 30, 39, false)) {
                        return null;
                    }
                }
                else if (llllllllllllllllIllIIIlllIIlIIIl >= 30 && llllllllllllllllIllIIIlllIIlIIIl < 39 && !this.mergeItemStack(llllllllllllllllIllIIIlllIIlIlII, 3, 30, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllllIllIIIlllIIlIlII, 3, 39, false)) {
                return null;
            }
            if (llllllllllllllllIllIIIlllIIlIlII.stackSize == 0) {
                llllllllllllllllIllIIIlllIIlIlIl.putStack(null);
            }
            else {
                llllllllllllllllIllIIIlllIIlIlIl.onSlotChanged();
            }
            if (llllllllllllllllIllIIIlllIIlIlII.stackSize == llllllllllllllllIllIIIlllIIlIllI.stackSize) {
                return null;
            }
            llllllllllllllllIllIIIlllIIlIlIl.onPickupFromSlot(llllllllllllllllIllIIIlllIIllIII, llllllllllllllllIllIIIlllIIlIlII);
        }
        return llllllllllllllllIllIIIlllIIlIllI;
    }
    
    public void setCurrentRecipeIndex(final int llllllllllllllllIllIIIlllIlIlIIl) {
        this.merchantInventory.setCurrentRecipeIndex(llllllllllllllllIllIIIlllIlIlIIl);
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }
}
