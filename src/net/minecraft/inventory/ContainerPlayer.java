package net.minecraft.inventory;

import net.minecraft.item.crafting.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class ContainerPlayer extends Container
{
    private final /* synthetic */ EntityPlayer thePlayer;
    public /* synthetic */ InventoryCrafting craftMatrix;
    public /* synthetic */ boolean isLocalWorld;
    public /* synthetic */ IInventory craftResult;
    
    @Override
    public boolean func_94530_a(final ItemStack lllllllllllllllIIllIIllllIlIIlll, final Slot lllllllllllllllIIllIIllllIlIIllI) {
        return lllllllllllllllIIllIIllllIlIIllI.inventory != this.craftResult && super.func_94530_a(lllllllllllllllIIllIIllllIlIIlll, lllllllllllllllIIllIIllllIlIIllI);
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllllllIIllIIlllllIlIIII) {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.thePlayer.worldObj));
    }
    
    public ContainerPlayer(final InventoryPlayer lllllllllllllllIIllIIllllllIIIII, final boolean lllllllllllllllIIllIIlllllIlllll, final EntityPlayer lllllllllllllllIIllIIlllllIlIllI) {
        this.craftMatrix = new InventoryCrafting(this, 2, 2);
        this.craftResult = new InventoryCraftResult();
        this.isLocalWorld = lllllllllllllllIIllIIlllllIlllll;
        this.thePlayer = lllllllllllllllIIllIIlllllIlIllI;
        this.addSlotToContainer(new SlotCrafting(lllllllllllllllIIllIIllllllIIIII.player, this.craftMatrix, this.craftResult, 0, 144, 36));
        for (int lllllllllllllllIIllIIlllllIlllIl = 0; lllllllllllllllIIllIIlllllIlllIl < 2; ++lllllllllllllllIIllIIlllllIlllIl) {
            for (int lllllllllllllllIIllIIlllllIlllII = 0; lllllllllllllllIIllIIlllllIlllII < 2; ++lllllllllllllllIIllIIlllllIlllII) {
                this.addSlotToContainer(new Slot(this.craftMatrix, lllllllllllllllIIllIIlllllIlllII + lllllllllllllllIIllIIlllllIlllIl * 2, 88 + lllllllllllllllIIllIIlllllIlllII * 18, 26 + lllllllllllllllIIllIIlllllIlllIl * 18));
            }
        }
        for (int lllllllllllllllIIllIIlllllIlllIl = 0; lllllllllllllllIIllIIlllllIlllIl < 4; ++lllllllllllllllIIllIIlllllIlllIl) {
            final int lllllllllllllllIIllIIlllllIllIlI = lllllllllllllllIIllIIlllllIlllIl;
            this.addSlotToContainer(new Slot(lllllllllllllllIIllIIllllllIIIII, lllllllllllllllIIllIIllllllIIIII.getSizeInventory() - 1 - lllllllllllllllIIllIIlllllIlllIl, 8, 8 + lllllllllllllllIIllIIlllllIlllIl * 18) {
                static {
                    __OBFID = "CL_00001755";
                }
                
                @Override
                public String func_178171_c() {
                    return ItemArmor.EMPTY_SLOT_NAMES[lllllllllllllllIIllIIlllllIllIlI];
                }
                
                @Override
                public boolean isItemValid(final ItemStack llIIllIIIIIIll) {
                    return llIIllIIIIIIll != null && ((llIIllIIIIIIll.getItem() instanceof ItemArmor) ? (((ItemArmor)llIIllIIIIIIll.getItem()).armorType == lllllllllllllllIIllIIlllllIllIlI) : ((llIIllIIIIIIll.getItem() == Item.getItemFromBlock(Blocks.pumpkin) || llIIllIIIIIIll.getItem() == Items.skull) && lllllllllllllllIIllIIlllllIllIlI == 0));
                }
                
                @Override
                public int getSlotStackLimit() {
                    return 1;
                }
            });
        }
        for (int lllllllllllllllIIllIIlllllIlllIl = 0; lllllllllllllllIIllIIlllllIlllIl < 3; ++lllllllllllllllIIllIIlllllIlllIl) {
            for (int lllllllllllllllIIllIIlllllIllIll = 0; lllllllllllllllIIllIIlllllIllIll < 9; ++lllllllllllllllIIllIIlllllIllIll) {
                this.addSlotToContainer(new Slot(lllllllllllllllIIllIIllllllIIIII, lllllllllllllllIIllIIlllllIllIll + (lllllllllllllllIIllIIlllllIlllIl + 1) * 9, 8 + lllllllllllllllIIllIIlllllIllIll * 18, 84 + lllllllllllllllIIllIIlllllIlllIl * 18));
            }
        }
        for (int lllllllllllllllIIllIIlllllIlllIl = 0; lllllllllllllllIIllIIlllllIlllIl < 9; ++lllllllllllllllIIllIIlllllIlllIl) {
            this.addSlotToContainer(new Slot(lllllllllllllllIIllIIllllllIIIII, lllllllllllllllIIllIIlllllIlllIl, 8 + lllllllllllllllIIllIIlllllIlllIl * 18, 142));
        }
        this.onCraftMatrixChanged(this.craftMatrix);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllllIIllIIllllIllIIIl, final int lllllllllllllllIIllIIllllIllIlll) {
        ItemStack lllllllllllllllIIllIIllllIllIllI = null;
        final Slot lllllllllllllllIIllIIllllIllIlIl = this.inventorySlots.get(lllllllllllllllIIllIIllllIllIlll);
        if (lllllllllllllllIIllIIllllIllIlIl != null && lllllllllllllllIIllIIllllIllIlIl.getHasStack()) {
            final ItemStack lllllllllllllllIIllIIllllIllIlII = lllllllllllllllIIllIIllllIllIlIl.getStack();
            lllllllllllllllIIllIIllllIllIllI = lllllllllllllllIIllIIllllIllIlII.copy();
            if (lllllllllllllllIIllIIllllIllIlll == 0) {
                if (!this.mergeItemStack(lllllllllllllllIIllIIllllIllIlII, 9, 45, true)) {
                    return null;
                }
                lllllllllllllllIIllIIllllIllIlIl.onSlotChange(lllllllllllllllIIllIIllllIllIlII, lllllllllllllllIIllIIllllIllIllI);
            }
            else if (lllllllllllllllIIllIIllllIllIlll >= 1 && lllllllllllllllIIllIIllllIllIlll < 5) {
                if (!this.mergeItemStack(lllllllllllllllIIllIIllllIllIlII, 9, 45, false)) {
                    return null;
                }
            }
            else if (lllllllllllllllIIllIIllllIllIlll >= 5 && lllllllllllllllIIllIIllllIllIlll < 9) {
                if (!this.mergeItemStack(lllllllllllllllIIllIIllllIllIlII, 9, 45, false)) {
                    return null;
                }
            }
            else if (lllllllllllllllIIllIIllllIllIllI.getItem() instanceof ItemArmor && !this.inventorySlots.get(5 + ((ItemArmor)lllllllllllllllIIllIIllllIllIllI.getItem()).armorType).getHasStack()) {
                final int lllllllllllllllIIllIIllllIllIIll = 5 + ((ItemArmor)lllllllllllllllIIllIIllllIllIllI.getItem()).armorType;
                if (!this.mergeItemStack(lllllllllllllllIIllIIllllIllIlII, lllllllllllllllIIllIIllllIllIIll, lllllllllllllllIIllIIllllIllIIll + 1, false)) {
                    return null;
                }
            }
            else if (lllllllllllllllIIllIIllllIllIlll >= 9 && lllllllllllllllIIllIIllllIllIlll < 36) {
                if (!this.mergeItemStack(lllllllllllllllIIllIIllllIllIlII, 36, 45, false)) {
                    return null;
                }
            }
            else if (lllllllllllllllIIllIIllllIllIlll >= 36 && lllllllllllllllIIllIIllllIllIlll < 45) {
                if (!this.mergeItemStack(lllllllllllllllIIllIIllllIllIlII, 9, 36, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllllIIllIIllllIllIlII, 9, 45, false)) {
                return null;
            }
            if (lllllllllllllllIIllIIllllIllIlII.stackSize == 0) {
                lllllllllllllllIIllIIllllIllIlIl.putStack(null);
            }
            else {
                lllllllllllllllIIllIIllllIllIlIl.onSlotChanged();
            }
            if (lllllllllllllllIIllIIllllIllIlII.stackSize == lllllllllllllllIIllIIllllIllIllI.stackSize) {
                return null;
            }
            lllllllllllllllIIllIIllllIllIlIl.onPickupFromSlot(lllllllllllllllIIllIIllllIllIIIl, lllllllllllllllIIllIIllllIllIlII);
        }
        return lllllllllllllllIIllIIllllIllIllI;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllllIIllIIlllllIIlIIl) {
        super.onContainerClosed(lllllllllllllllIIllIIlllllIIlIIl);
        for (int lllllllllllllllIIllIIlllllIIlIII = 0; lllllllllllllllIIllIIlllllIIlIII < 4; ++lllllllllllllllIIllIIlllllIIlIII) {
            final ItemStack lllllllllllllllIIllIIlllllIIIlll = this.craftMatrix.getStackInSlotOnClosing(lllllllllllllllIIllIIlllllIIlIII);
            if (lllllllllllllllIIllIIlllllIIIlll != null) {
                lllllllllllllllIIllIIlllllIIlIIl.dropPlayerItemWithRandomChoice(lllllllllllllllIIllIIlllllIIIlll, false);
            }
        }
        this.craftResult.setInventorySlotContents(0, null);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllllIIllIIlllllIIIIIl) {
        return true;
    }
    
    static {
        __OBFID = "CL_00001754";
    }
}
