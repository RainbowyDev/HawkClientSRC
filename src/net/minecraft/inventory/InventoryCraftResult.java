package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;

public class InventoryCraftResult implements IInventory
{
    private /* synthetic */ ItemStack[] stackResult;
    
    @Override
    public void markDirty() {
    }
    
    @Override
    public int getField(final int llllllllllllllIIlIIlIIlIIIIIIIIl) {
        return 0;
    }
    
    @Override
    public String getName() {
        return "Result";
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllIIlIIlIIlIIIIlIIIl, final ItemStack llllllllllllllIIlIIlIIlIIIIlIIII) {
        this.stackResult[0] = llllllllllllllIIlIIlIIlIIIIlIIII;
    }
    
    @Override
    public void setField(final int llllllllllllllIIlIIlIIIlllllllll, final int llllllllllllllIIlIIlIIIllllllllI) {
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIIlIIlIIlIIIlIIIII, final int llllllllllllllIIlIIlIIlIIIIlllll) {
        if (this.stackResult[0] != null) {
            final ItemStack llllllllllllllIIlIIlIIlIIIIllllI = this.stackResult[0];
            this.stackResult[0] = null;
            return llllllllllllllIIlIIlIIlIIIIllllI;
        }
        return null;
    }
    
    public InventoryCraftResult() {
        this.stackResult = new ItemStack[1];
    }
    
    static {
        __OBFID = "CL_00001760";
    }
    
    @Override
    public int getSizeInventory() {
        return 1;
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllIIlIIlIIlIIIIIlIlI) {
        return true;
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIIlIIlIIlIIIIIIlII, final ItemStack llllllllllllllIIlIIlIIlIIIIIIIll) {
        return true;
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllIIlIIlIIlIIIlIlIlI) {
        return this.stackResult[0];
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllllllllllIIlIIlIIlIIIIllIII) {
        if (this.stackResult[0] != null) {
            final ItemStack llllllllllllllIIlIIlIIlIIIIlIlll = this.stackResult[0];
            this.stackResult[0] = null;
            return llllllllllllllIIlIIlIIlIIIIlIlll;
        }
        return null;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIIlIIlIIlIIIIIIllI) {
    }
    
    @Override
    public void clearInventory() {
        for (int llllllllllllllIIlIIlIIIllllllIIl = 0; llllllllllllllIIlIIlIIIllllllIIl < this.stackResult.length; ++llllllllllllllIIlIIlIIIllllllIIl) {
            this.stackResult[llllllllllllllIIlIIlIIIllllllIIl] = null;
        }
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIIlIIlIIlIIIIIlIII) {
    }
}
