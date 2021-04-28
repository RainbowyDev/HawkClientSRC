package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;

public class ContainerBrewingStand extends Container
{
    private final /* synthetic */ Slot theSlot;
    private /* synthetic */ int brewTime;
    private /* synthetic */ IInventory tileBrewingStand;
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int llllllllllllllllIIllIIlIIllIIlIl = 0; llllllllllllllllIIllIIlIIllIIlIl < this.crafters.size(); ++llllllllllllllllIIllIIlIIllIIlIl) {
            final ICrafting llllllllllllllllIIllIIlIIllIIlII = this.crafters.get(llllllllllllllllIIllIIlIIllIIlIl);
            if (this.brewTime != this.tileBrewingStand.getField(0)) {
                llllllllllllllllIIllIIlIIllIIlII.sendProgressBarUpdate(this, 0, this.tileBrewingStand.getField(0));
            }
        }
        this.brewTime = this.tileBrewingStand.getField(0);
    }
    
    @Override
    public void updateProgressBar(final int llllllllllllllllIIllIIlIIlIllIIl, final int llllllllllllllllIIllIIlIIlIllIll) {
        this.tileBrewingStand.setField(llllllllllllllllIIllIIlIIlIllIIl, llllllllllllllllIIllIIlIIlIllIll);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllllIIllIIlIIlIlIIlI) {
        return this.tileBrewingStand.isUseableByPlayer(llllllllllllllllIIllIIlIIlIlIIlI);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllllIIllIIlIIlIIIlII, final int llllllllllllllllIIllIIlIIlIIlIIl) {
        ItemStack llllllllllllllllIIllIIlIIlIIlIII = null;
        final Slot llllllllllllllllIIllIIlIIlIIIlll = this.inventorySlots.get(llllllllllllllllIIllIIlIIlIIlIIl);
        if (llllllllllllllllIIllIIlIIlIIIlll != null && llllllllllllllllIIllIIlIIlIIIlll.getHasStack()) {
            final ItemStack llllllllllllllllIIllIIlIIlIIIllI = llllllllllllllllIIllIIlIIlIIIlll.getStack();
            llllllllllllllllIIllIIlIIlIIlIII = llllllllllllllllIIllIIlIIlIIIllI.copy();
            if ((llllllllllllllllIIllIIlIIlIIlIIl < 0 || llllllllllllllllIIllIIlIIlIIlIIl > 2) && llllllllllllllllIIllIIlIIlIIlIIl != 3) {
                if (!this.theSlot.getHasStack() && this.theSlot.isItemValid(llllllllllllllllIIllIIlIIlIIIllI)) {
                    if (!this.mergeItemStack(llllllllllllllllIIllIIlIIlIIIllI, 3, 4, false)) {
                        return null;
                    }
                }
                else if (Potion.canHoldPotion(llllllllllllllllIIllIIlIIlIIlIII)) {
                    if (!this.mergeItemStack(llllllllllllllllIIllIIlIIlIIIllI, 0, 3, false)) {
                        return null;
                    }
                }
                else if (llllllllllllllllIIllIIlIIlIIlIIl >= 4 && llllllllllllllllIIllIIlIIlIIlIIl < 31) {
                    if (!this.mergeItemStack(llllllllllllllllIIllIIlIIlIIIllI, 31, 40, false)) {
                        return null;
                    }
                }
                else if (llllllllllllllllIIllIIlIIlIIlIIl >= 31 && llllllllllllllllIIllIIlIIlIIlIIl < 40) {
                    if (!this.mergeItemStack(llllllllllllllllIIllIIlIIlIIIllI, 4, 31, false)) {
                        return null;
                    }
                }
                else if (!this.mergeItemStack(llllllllllllllllIIllIIlIIlIIIllI, 4, 40, false)) {
                    return null;
                }
            }
            else {
                if (!this.mergeItemStack(llllllllllllllllIIllIIlIIlIIIllI, 4, 40, true)) {
                    return null;
                }
                llllllllllllllllIIllIIlIIlIIIlll.onSlotChange(llllllllllllllllIIllIIlIIlIIIllI, llllllllllllllllIIllIIlIIlIIlIII);
            }
            if (llllllllllllllllIIllIIlIIlIIIllI.stackSize == 0) {
                llllllllllllllllIIllIIlIIlIIIlll.putStack(null);
            }
            else {
                llllllllllllllllIIllIIlIIlIIIlll.onSlotChanged();
            }
            if (llllllllllllllllIIllIIlIIlIIIllI.stackSize == llllllllllllllllIIllIIlIIlIIlIII.stackSize) {
                return null;
            }
            llllllllllllllllIIllIIlIIlIIIlll.onPickupFromSlot(llllllllllllllllIIllIIlIIlIIIlII, llllllllllllllllIIllIIlIIlIIIllI);
        }
        return llllllllllllllllIIllIIlIIlIIlIII;
    }
    
    public ContainerBrewingStand(final InventoryPlayer llllllllllllllllIIllIIlIIlllIIll, final IInventory llllllllllllllllIIllIIlIIlllIlll) {
        this.tileBrewingStand = llllllllllllllllIIllIIlIIlllIlll;
        this.addSlotToContainer(new Potion(llllllllllllllllIIllIIlIIlllIIll.player, llllllllllllllllIIllIIlIIlllIlll, 0, 56, 46));
        this.addSlotToContainer(new Potion(llllllllllllllllIIllIIlIIlllIIll.player, llllllllllllllllIIllIIlIIlllIlll, 1, 79, 53));
        this.addSlotToContainer(new Potion(llllllllllllllllIIllIIlIIlllIIll.player, llllllllllllllllIIllIIlIIlllIlll, 2, 102, 46));
        this.theSlot = this.addSlotToContainer(new Ingredient(llllllllllllllllIIllIIlIIlllIlll, 3, 79, 17));
        for (int llllllllllllllllIIllIIlIIlllIllI = 0; llllllllllllllllIIllIIlIIlllIllI < 3; ++llllllllllllllllIIllIIlIIlllIllI) {
            for (int llllllllllllllllIIllIIlIIlllIlIl = 0; llllllllllllllllIIllIIlIIlllIlIl < 9; ++llllllllllllllllIIllIIlIIlllIlIl) {
                this.addSlotToContainer(new Slot(llllllllllllllllIIllIIlIIlllIIll, llllllllllllllllIIllIIlIIlllIlIl + llllllllllllllllIIllIIlIIlllIllI * 9 + 9, 8 + llllllllllllllllIIllIIlIIlllIlIl * 18, 84 + llllllllllllllllIIllIIlIIlllIllI * 18));
            }
        }
        for (int llllllllllllllllIIllIIlIIlllIllI = 0; llllllllllllllllIIllIIlIIlllIllI < 9; ++llllllllllllllllIIllIIlIIlllIllI) {
            this.addSlotToContainer(new Slot(llllllllllllllllIIllIIlIIlllIIll, llllllllllllllllIIllIIlIIlllIllI, 8 + llllllllllllllllIIllIIlIIlllIllI * 18, 142));
        }
    }
    
    @Override
    public void onCraftGuiOpened(final ICrafting llllllllllllllllIIllIIlIIllIlIlI) {
        super.onCraftGuiOpened(llllllllllllllllIIllIIlIIllIlIlI);
        llllllllllllllllIIllIIlIIllIlIlI.func_175173_a(this, this.tileBrewingStand);
    }
    
    static {
        __OBFID = "CL_00001737";
    }
    
    class Ingredient extends Slot
    {
        @Override
        public boolean isItemValid(final ItemStack llllllllllllllllIIIlIllllIIIlIll) {
            return llllllllllllllllIIIlIllllIIIlIll != null && llllllllllllllllIIIlIllllIIIlIll.getItem().isPotionIngredient(llllllllllllllllIIIlIllllIIIlIll);
        }
        
        @Override
        public int getSlotStackLimit() {
            return 64;
        }
        
        static {
            __OBFID = "CL_00001738";
        }
        
        public Ingredient(final IInventory llllllllllllllllIIIlIllllIIlIIIl, final int llllllllllllllllIIIlIllllIIlIIII, final int llllllllllllllllIIIlIllllIIlIlIl, final int llllllllllllllllIIIlIllllIIIlllI) {
            super(llllllllllllllllIIIlIllllIIlIIIl, llllllllllllllllIIIlIllllIIlIIII, llllllllllllllllIIIlIllllIIlIlIl, llllllllllllllllIIIlIllllIIIlllI);
        }
    }
    
    static class Potion extends Slot
    {
        private /* synthetic */ EntityPlayer player;
        
        static {
            __OBFID = "CL_00001740";
        }
        
        @Override
        public boolean isItemValid(final ItemStack lllllllllllllllIllIlIllllIllIlll) {
            return canHoldPotion(lllllllllllllllIllIlIllllIllIlll);
        }
        
        @Override
        public void onPickupFromSlot(final EntityPlayer lllllllllllllllIllIlIllllIllIIIl, final ItemStack lllllllllllllllIllIlIllllIlIllIl) {
            if (lllllllllllllllIllIlIllllIlIllIl.getItem() == Items.potionitem && lllllllllllllllIllIlIllllIlIllIl.getMetadata() > 0) {
                this.player.triggerAchievement(AchievementList.potion);
            }
            super.onPickupFromSlot(lllllllllllllllIllIlIllllIllIIIl, lllllllllllllllIllIlIllllIlIllIl);
        }
        
        public Potion(final EntityPlayer lllllllllllllllIllIlIlllllIIIlIl, final IInventory lllllllllllllllIllIlIllllIlllllI, final int lllllllllllllllIllIlIlllllIIIIll, final int lllllllllllllllIllIlIlllllIIIIlI, final int lllllllllllllllIllIlIlllllIIIIIl) {
            super(lllllllllllllllIllIlIllllIlllllI, lllllllllllllllIllIlIlllllIIIIll, lllllllllllllllIllIlIlllllIIIIlI, lllllllllllllllIllIlIlllllIIIIIl);
            this.player = lllllllllllllllIllIlIlllllIIIlIl;
        }
        
        @Override
        public int getSlotStackLimit() {
            return 1;
        }
        
        public static boolean canHoldPotion(final ItemStack lllllllllllllllIllIlIllllIlIlIll) {
            return lllllllllllllllIllIlIllllIlIlIll != null && (lllllllllllllllIllIlIllllIlIlIll.getItem() == Items.potionitem || lllllllllllllllIllIlIllllIlIlIll.getItem() == Items.glass_bottle);
        }
    }
}
