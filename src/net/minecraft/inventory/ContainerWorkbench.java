package net.minecraft.inventory;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.crafting.*;
import net.minecraft.item.*;

public class ContainerWorkbench extends Container
{
    public /* synthetic */ InventoryCrafting craftMatrix;
    private /* synthetic */ BlockPos field_178145_h;
    private /* synthetic */ World worldObj;
    public /* synthetic */ IInventory craftResult;
    
    public ContainerWorkbench(final InventoryPlayer lllllllllllllllIlIIIllllllIIIIIl, final World lllllllllllllllIlIIIllllllIIIlll, final BlockPos lllllllllllllllIlIIIlllllIllllll) {
        this.craftMatrix = new InventoryCrafting(this, 3, 3);
        this.craftResult = new InventoryCraftResult();
        this.worldObj = lllllllllllllllIlIIIllllllIIIlll;
        this.field_178145_h = lllllllllllllllIlIIIlllllIllllll;
        this.addSlotToContainer(new SlotCrafting(lllllllllllllllIlIIIllllllIIIIIl.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        for (int lllllllllllllllIlIIIllllllIIIlIl = 0; lllllllllllllllIlIIIllllllIIIlIl < 3; ++lllllllllllllllIlIIIllllllIIIlIl) {
            for (int lllllllllllllllIlIIIllllllIIIlII = 0; lllllllllllllllIlIIIllllllIIIlII < 3; ++lllllllllllllllIlIIIllllllIIIlII) {
                this.addSlotToContainer(new Slot(this.craftMatrix, lllllllllllllllIlIIIllllllIIIlII + lllllllllllllllIlIIIllllllIIIlIl * 3, 30 + lllllllllllllllIlIIIllllllIIIlII * 18, 17 + lllllllllllllllIlIIIllllllIIIlIl * 18));
            }
        }
        for (int lllllllllllllllIlIIIllllllIIIlIl = 0; lllllllllllllllIlIIIllllllIIIlIl < 3; ++lllllllllllllllIlIIIllllllIIIlIl) {
            for (int lllllllllllllllIlIIIllllllIIIIll = 0; lllllllllllllllIlIIIllllllIIIIll < 9; ++lllllllllllllllIlIIIllllllIIIIll) {
                this.addSlotToContainer(new Slot(lllllllllllllllIlIIIllllllIIIIIl, lllllllllllllllIlIIIllllllIIIIll + lllllllllllllllIlIIIllllllIIIlIl * 9 + 9, 8 + lllllllllllllllIlIIIllllllIIIIll * 18, 84 + lllllllllllllllIlIIIllllllIIIlIl * 18));
            }
        }
        for (int lllllllllllllllIlIIIllllllIIIlIl = 0; lllllllllllllllIlIIIllllllIIIlIl < 9; ++lllllllllllllllIlIIIllllllIIIlIl) {
            this.addSlotToContainer(new Slot(lllllllllllllllIlIIIllllllIIIIIl, lllllllllllllllIlIIIllllllIIIlIl, 8 + lllllllllllllllIlIIIllllllIIIlIl * 18, 142));
        }
        this.onCraftMatrixChanged(this.craftMatrix);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllllIlIIIlllllIlIIlll) {
        return this.worldObj.getBlockState(this.field_178145_h).getBlock() == Blocks.crafting_table && lllllllllllllllIlIIIlllllIlIIlll.getDistanceSq(this.field_178145_h.getX() + 0.5, this.field_178145_h.getY() + 0.5, this.field_178145_h.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllllllIlIIIlllllIlllIlI) {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
    
    @Override
    public boolean func_94530_a(final ItemStack lllllllllllllllIlIIIlllllIIIllIl, final Slot lllllllllllllllIlIIIlllllIIIllll) {
        return lllllllllllllllIlIIIlllllIIIllll.inventory != this.craftResult && super.func_94530_a(lllllllllllllllIlIIIlllllIIIllIl, lllllllllllllllIlIIIlllllIIIllll);
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllllIlIIIlllllIlIllll) {
        super.onContainerClosed(lllllllllllllllIlIIIlllllIlIllll);
        if (!this.worldObj.isRemote) {
            for (int lllllllllllllllIlIIIlllllIllIIlI = 0; lllllllllllllllIlIIIlllllIllIIlI < 9; ++lllllllllllllllIlIIIlllllIllIIlI) {
                final ItemStack lllllllllllllllIlIIIlllllIllIIIl = this.craftMatrix.getStackInSlotOnClosing(lllllllllllllllIlIIIlllllIllIIlI);
                if (lllllllllllllllIlIIIlllllIllIIIl != null) {
                    lllllllllllllllIlIIIlllllIlIllll.dropPlayerItemWithRandomChoice(lllllllllllllllIlIIIlllllIllIIIl, false);
                }
            }
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllllIlIIIlllllIIlllll, final int lllllllllllllllIlIIIlllllIIllllI) {
        ItemStack lllllllllllllllIlIIIlllllIIlllIl = null;
        final Slot lllllllllllllllIlIIIlllllIIlllII = this.inventorySlots.get(lllllllllllllllIlIIIlllllIIllllI);
        if (lllllllllllllllIlIIIlllllIIlllII != null && lllllllllllllllIlIIIlllllIIlllII.getHasStack()) {
            final ItemStack lllllllllllllllIlIIIlllllIIllIll = lllllllllllllllIlIIIlllllIIlllII.getStack();
            lllllllllllllllIlIIIlllllIIlllIl = lllllllllllllllIlIIIlllllIIllIll.copy();
            if (lllllllllllllllIlIIIlllllIIllllI == 0) {
                if (!this.mergeItemStack(lllllllllllllllIlIIIlllllIIllIll, 10, 46, true)) {
                    return null;
                }
                lllllllllllllllIlIIIlllllIIlllII.onSlotChange(lllllllllllllllIlIIIlllllIIllIll, lllllllllllllllIlIIIlllllIIlllIl);
            }
            else if (lllllllllllllllIlIIIlllllIIllllI >= 10 && lllllllllllllllIlIIIlllllIIllllI < 37) {
                if (!this.mergeItemStack(lllllllllllllllIlIIIlllllIIllIll, 37, 46, false)) {
                    return null;
                }
            }
            else if (lllllllllllllllIlIIIlllllIIllllI >= 37 && lllllllllllllllIlIIIlllllIIllllI < 46) {
                if (!this.mergeItemStack(lllllllllllllllIlIIIlllllIIllIll, 10, 37, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllllIlIIIlllllIIllIll, 10, 46, false)) {
                return null;
            }
            if (lllllllllllllllIlIIIlllllIIllIll.stackSize == 0) {
                lllllllllllllllIlIIIlllllIIlllII.putStack(null);
            }
            else {
                lllllllllllllllIlIIIlllllIIlllII.onSlotChanged();
            }
            if (lllllllllllllllIlIIIlllllIIllIll.stackSize == lllllllllllllllIlIIIlllllIIlllIl.stackSize) {
                return null;
            }
            lllllllllllllllIlIIIlllllIIlllII.onPickupFromSlot(lllllllllllllllIlIIIlllllIIlllll, lllllllllllllllIlIIIlllllIIllIll);
        }
        return lllllllllllllllIlIIIlllllIIlllIl;
    }
    
    static {
        __OBFID = "CL_00001744";
    }
}
