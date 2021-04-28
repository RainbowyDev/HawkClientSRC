package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.village.*;
import net.minecraft.util.*;

public class InventoryMerchant implements IInventory
{
    private final /* synthetic */ EntityPlayer thePlayer;
    private /* synthetic */ int currentRecipeIndex;
    private final /* synthetic */ IMerchant theMerchant;
    private /* synthetic */ MerchantRecipe currentRecipe;
    private /* synthetic */ ItemStack[] theInventory;
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer lllllllllllllllllllIlIIllIlllIll) {
        return this.theMerchant.getCustomer() == lllllllllllllllllllIlIIllIlllIll;
    }
    
    @Override
    public void clearInventory() {
        for (int lllllllllllllllllllIlIIllIIIllIl = 0; lllllllllllllllllllIlIIllIIIllIl < this.theInventory.length; ++lllllllllllllllllllIlIIllIIIllIl) {
            this.theInventory[lllllllllllllllllllIlIIllIIIllIl] = null;
        }
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllllllllIlIIllllIlIIl) {
        return this.theInventory[lllllllllllllllllllIlIIllllIlIIl];
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    public void setCurrentRecipeIndex(final int lllllllllllllllllllIlIIllIIllIIl) {
        this.currentRecipeIndex = lllllllllllllllllllIlIIllIIllIIl;
        this.resetRecipeAndSlots();
    }
    
    public void resetRecipeAndSlots() {
        this.currentRecipe = null;
        ItemStack lllllllllllllllllllIlIIllIlIlIII = this.theInventory[0];
        ItemStack lllllllllllllllllllIlIIllIlIIlll = this.theInventory[1];
        if (lllllllllllllllllllIlIIllIlIlIII == null) {
            lllllllllllllllllllIlIIllIlIlIII = lllllllllllllllllllIlIIllIlIIlll;
            lllllllllllllllllllIlIIllIlIIlll = null;
        }
        if (lllllllllllllllllllIlIIllIlIlIII == null) {
            this.setInventorySlotContents(2, null);
        }
        else {
            final MerchantRecipeList lllllllllllllllllllIlIIllIlIIllI = this.theMerchant.getRecipes(this.thePlayer);
            if (lllllllllllllllllllIlIIllIlIIllI != null) {
                MerchantRecipe lllllllllllllllllllIlIIllIlIIlIl = lllllllllllllllllllIlIIllIlIIllI.canRecipeBeUsed(lllllllllllllllllllIlIIllIlIlIII, lllllllllllllllllllIlIIllIlIIlll, this.currentRecipeIndex);
                if (lllllllllllllllllllIlIIllIlIIlIl != null && !lllllllllllllllllllIlIIllIlIIlIl.isRecipeDisabled()) {
                    this.currentRecipe = lllllllllllllllllllIlIIllIlIIlIl;
                    this.setInventorySlotContents(2, lllllllllllllllllllIlIIllIlIIlIl.getItemToSell().copy());
                }
                else if (lllllllllllllllllllIlIIllIlIIlll != null) {
                    lllllllllllllllllllIlIIllIlIIlIl = lllllllllllllllllllIlIIllIlIIllI.canRecipeBeUsed(lllllllllllllllllllIlIIllIlIIlll, lllllllllllllllllllIlIIllIlIlIII, this.currentRecipeIndex);
                    if (lllllllllllllllllllIlIIllIlIIlIl != null && !lllllllllllllllllllIlIIllIlIIlIl.isRecipeDisabled()) {
                        this.currentRecipe = lllllllllllllllllllIlIIllIlIIlIl;
                        this.setInventorySlotContents(2, lllllllllllllllllllIlIIllIlIIlIl.getItemToSell().copy());
                    }
                    else {
                        this.setInventorySlotContents(2, null);
                    }
                }
                else {
                    this.setInventorySlotContents(2, null);
                }
            }
        }
        this.theMerchant.verifySellingItem(this.getStackInSlot(2));
    }
    
    @Override
    public int getSizeInventory() {
        return this.theInventory.length;
    }
    
    @Override
    public void markDirty() {
        this.resetRecipeAndSlots();
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllllllllIlIIllIllIlll) {
    }
    
    private boolean inventoryResetNeededOnSlotChange(final int lllllllllllllllllllIlIIlllIlIlll) {
        return lllllllllllllllllllIlIIlllIlIlll == 0 || lllllllllllllllllllIlIIlllIlIlll == 1;
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllllllllIlIIlllIlllIl, final int lllllllllllllllllllIlIIllllIIIlI) {
        if (this.theInventory[lllllllllllllllllllIlIIlllIlllIl] == null) {
            return null;
        }
        if (lllllllllllllllllllIlIIlllIlllIl == 2) {
            final ItemStack lllllllllllllllllllIlIIllllIIIIl = this.theInventory[lllllllllllllllllllIlIIlllIlllIl];
            this.theInventory[lllllllllllllllllllIlIIlllIlllIl] = null;
            return lllllllllllllllllllIlIIllllIIIIl;
        }
        if (this.theInventory[lllllllllllllllllllIlIIlllIlllIl].stackSize <= lllllllllllllllllllIlIIllllIIIlI) {
            final ItemStack lllllllllllllllllllIlIIllllIIIII = this.theInventory[lllllllllllllllllllIlIIlllIlllIl];
            this.theInventory[lllllllllllllllllllIlIIlllIlllIl] = null;
            if (this.inventoryResetNeededOnSlotChange(lllllllllllllllllllIlIIlllIlllIl)) {
                this.resetRecipeAndSlots();
            }
            return lllllllllllllllllllIlIIllllIIIII;
        }
        final ItemStack lllllllllllllllllllIlIIlllIlllll = this.theInventory[lllllllllllllllllllIlIIlllIlllIl].splitStack(lllllllllllllllllllIlIIllllIIIlI);
        if (this.theInventory[lllllllllllllllllllIlIIlllIlllIl].stackSize == 0) {
            this.theInventory[lllllllllllllllllllIlIIlllIlllIl] = null;
        }
        if (this.inventoryResetNeededOnSlotChange(lllllllllllllllllllIlIIlllIlllIl)) {
            this.resetRecipeAndSlots();
        }
        return lllllllllllllllllllIlIIlllIlllll;
    }
    
    public InventoryMerchant(final EntityPlayer lllllllllllllllllllIlIIlllllIIll, final IMerchant lllllllllllllllllllIlIIlllllIlIl) {
        this.theInventory = new ItemStack[3];
        this.thePlayer = lllllllllllllllllllIlIIlllllIIll;
        this.theMerchant = lllllllllllllllllllIlIIlllllIlIl;
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int lllllllllllllllllllIlIIlllIlIIlI) {
        if (this.theInventory[lllllllllllllllllllIlIIlllIlIIlI] != null) {
            final ItemStack lllllllllllllllllllIlIIlllIlIIIl = this.theInventory[lllllllllllllllllllIlIIlllIlIIlI];
            this.theInventory[lllllllllllllllllllIlIIlllIlIIlI] = null;
            return lllllllllllllllllllIlIIlllIlIIIl;
        }
        return null;
    }
    
    @Override
    public void setField(final int lllllllllllllllllllIlIIllIIlIIll, final int lllllllllllllllllllIlIIllIIlIIlI) {
    }
    
    @Override
    public String getName() {
        return "mob.villager";
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public int getField(final int lllllllllllllllllllIlIIllIIlIlIl) {
        return 0;
    }
    
    public MerchantRecipe getCurrentRecipe() {
        return this.currentRecipe;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllllllllIlIIllIllIIll, final ItemStack lllllllllllllllllllIlIIllIllIIlI) {
        return true;
    }
    
    static {
        __OBFID = "CL_00001756";
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllllllllIlIIllIllIlIl) {
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllllllllIlIIlllIIIllI, final ItemStack lllllllllllllllllllIlIIlllIIIlIl) {
        this.theInventory[lllllllllllllllllllIlIIlllIIIllI] = lllllllllllllllllllIlIIlllIIIlIl;
        if (lllllllllllllllllllIlIIlllIIIlIl != null && lllllllllllllllllllIlIIlllIIIlIl.stackSize > this.getInventoryStackLimit()) {
            lllllllllllllllllllIlIIlllIIIlIl.stackSize = this.getInventoryStackLimit();
        }
        if (this.inventoryResetNeededOnSlotChange(lllllllllllllllllllIlIIlllIIIllI)) {
            this.resetRecipeAndSlots();
        }
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }
}
