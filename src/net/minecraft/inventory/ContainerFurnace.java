package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;

public class ContainerFurnace extends Container
{
    private /* synthetic */ int field_178153_g;
    private final /* synthetic */ IInventory tileFurnace;
    private /* synthetic */ int field_178152_f;
    private /* synthetic */ int field_178154_h;
    private /* synthetic */ int field_178155_i;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllllIIIlIlllIIIllIIl, final int llllllllllllllllIIIlIlllIIIllIII) {
        ItemStack llllllllllllllllIIIlIlllIIIlllIl = null;
        final Slot llllllllllllllllIIIlIlllIIIlllII = this.inventorySlots.get(llllllllllllllllIIIlIlllIIIllIII);
        if (llllllllllllllllIIIlIlllIIIlllII != null && llllllllllllllllIIIlIlllIIIlllII.getHasStack()) {
            final ItemStack llllllllllllllllIIIlIlllIIIllIll = llllllllllllllllIIIlIlllIIIlllII.getStack();
            llllllllllllllllIIIlIlllIIIlllIl = llllllllllllllllIIIlIlllIIIllIll.copy();
            if (llllllllllllllllIIIlIlllIIIllIII == 2) {
                if (!this.mergeItemStack(llllllllllllllllIIIlIlllIIIllIll, 3, 39, true)) {
                    return null;
                }
                llllllllllllllllIIIlIlllIIIlllII.onSlotChange(llllllllllllllllIIIlIlllIIIllIll, llllllllllllllllIIIlIlllIIIlllIl);
            }
            else if (llllllllllllllllIIIlIlllIIIllIII != 1 && llllllllllllllllIIIlIlllIIIllIII != 0) {
                if (FurnaceRecipes.instance().getSmeltingResult(llllllllllllllllIIIlIlllIIIllIll) != null) {
                    if (!this.mergeItemStack(llllllllllllllllIIIlIlllIIIllIll, 0, 1, false)) {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(llllllllllllllllIIIlIlllIIIllIll)) {
                    if (!this.mergeItemStack(llllllllllllllllIIIlIlllIIIllIll, 1, 2, false)) {
                        return null;
                    }
                }
                else if (llllllllllllllllIIIlIlllIIIllIII >= 3 && llllllllllllllllIIIlIlllIIIllIII < 30) {
                    if (!this.mergeItemStack(llllllllllllllllIIIlIlllIIIllIll, 30, 39, false)) {
                        return null;
                    }
                }
                else if (llllllllllllllllIIIlIlllIIIllIII >= 30 && llllllllllllllllIIIlIlllIIIllIII < 39 && !this.mergeItemStack(llllllllllllllllIIIlIlllIIIllIll, 3, 30, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllllIIIlIlllIIIllIll, 3, 39, false)) {
                return null;
            }
            if (llllllllllllllllIIIlIlllIIIllIll.stackSize == 0) {
                llllllllllllllllIIIlIlllIIIlllII.putStack(null);
            }
            else {
                llllllllllllllllIIIlIlllIIIlllII.onSlotChanged();
            }
            if (llllllllllllllllIIIlIlllIIIllIll.stackSize == llllllllllllllllIIIlIlllIIIlllIl.stackSize) {
                return null;
            }
            llllllllllllllllIIIlIlllIIIlllII.onPickupFromSlot(llllllllllllllllIIIlIlllIIIllIIl, llllllllllllllllIIIlIlllIIIllIll);
        }
        return llllllllllllllllIIIlIlllIIIlllIl;
    }
    
    @Override
    public void updateProgressBar(final int llllllllllllllllIIIlIlllIIllIIIl, final int llllllllllllllllIIIlIlllIIllIIII) {
        this.tileFurnace.setField(llllllllllllllllIIIlIlllIIllIIIl, llllllllllllllllIIIlIlllIIllIIII);
    }
    
    @Override
    public void onCraftGuiOpened(final ICrafting llllllllllllllllIIIlIlllIIllllll) {
        super.onCraftGuiOpened(llllllllllllllllIIIlIlllIIllllll);
        llllllllllllllllIIIlIlllIIllllll.func_175173_a(this, this.tileFurnace);
    }
    
    public ContainerFurnace(final InventoryPlayer llllllllllllllllIIIlIlllIlIIlIII, final IInventory llllllllllllllllIIIlIlllIlIIIlll) {
        this.tileFurnace = llllllllllllllllIIIlIlllIlIIIlll;
        this.addSlotToContainer(new Slot(llllllllllllllllIIIlIlllIlIIIlll, 0, 56, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(llllllllllllllllIIIlIlllIlIIIlll, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(llllllllllllllllIIIlIlllIlIIlIII.player, llllllllllllllllIIIlIlllIlIIIlll, 2, 116, 35));
        for (int llllllllllllllllIIIlIlllIlIIlIll = 0; llllllllllllllllIIIlIlllIlIIlIll < 3; ++llllllllllllllllIIIlIlllIlIIlIll) {
            for (int llllllllllllllllIIIlIlllIlIIlIlI = 0; llllllllllllllllIIIlIlllIlIIlIlI < 9; ++llllllllllllllllIIIlIlllIlIIlIlI) {
                this.addSlotToContainer(new Slot(llllllllllllllllIIIlIlllIlIIlIII, llllllllllllllllIIIlIlllIlIIlIlI + llllllllllllllllIIIlIlllIlIIlIll * 9 + 9, 8 + llllllllllllllllIIIlIlllIlIIlIlI * 18, 84 + llllllllllllllllIIIlIlllIlIIlIll * 18));
            }
        }
        for (int llllllllllllllllIIIlIlllIlIIlIll = 0; llllllllllllllllIIIlIlllIlIIlIll < 9; ++llllllllllllllllIIIlIlllIlIIlIll) {
            this.addSlotToContainer(new Slot(llllllllllllllllIIIlIlllIlIIlIII, llllllllllllllllIIIlIlllIlIIlIll, 8 + llllllllllllllllIIIlIlllIlIIlIll * 18, 142));
        }
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int llllllllllllllllIIIlIlllIIlllIlI = 0; llllllllllllllllIIIlIlllIIlllIlI < this.crafters.size(); ++llllllllllllllllIIIlIlllIIlllIlI) {
            final ICrafting llllllllllllllllIIIlIlllIIlllIIl = this.crafters.get(llllllllllllllllIIIlIlllIIlllIlI);
            if (this.field_178152_f != this.tileFurnace.getField(2)) {
                llllllllllllllllIIIlIlllIIlllIIl.sendProgressBarUpdate(this, 2, this.tileFurnace.getField(2));
            }
            if (this.field_178154_h != this.tileFurnace.getField(0)) {
                llllllllllllllllIIIlIlllIIlllIIl.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
            }
            if (this.field_178155_i != this.tileFurnace.getField(1)) {
                llllllllllllllllIIIlIlllIIlllIIl.sendProgressBarUpdate(this, 1, this.tileFurnace.getField(1));
            }
            if (this.field_178153_g != this.tileFurnace.getField(3)) {
                llllllllllllllllIIIlIlllIIlllIIl.sendProgressBarUpdate(this, 3, this.tileFurnace.getField(3));
            }
        }
        this.field_178152_f = this.tileFurnace.getField(2);
        this.field_178154_h = this.tileFurnace.getField(0);
        this.field_178155_i = this.tileFurnace.getField(1);
        this.field_178153_g = this.tileFurnace.getField(3);
    }
    
    static {
        __OBFID = "CL_00001748";
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllllIIIlIlllIIlIIlll) {
        return this.tileFurnace.isUseableByPlayer(llllllllllllllllIIIlIlllIIlIIlll);
    }
}
