package net.minecraft.inventory;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public interface IInventory extends IWorldNameable
{
    void openInventory(final EntityPlayer p0);
    
    void setField(final int p0, final int p1);
    
    void clearInventory();
    
    ItemStack decrStackSize(final int p0, final int p1);
    
    int getInventoryStackLimit();
    
    boolean isItemValidForSlot(final int p0, final ItemStack p1);
    
    void markDirty();
    
    ItemStack getStackInSlot(final int p0);
    
    int getSizeInventory();
    
    int getField(final int p0);
    
    int getFieldCount();
    
    boolean isUseableByPlayer(final EntityPlayer p0);
    
    ItemStack getStackInSlotOnClosing(final int p0);
    
    void closeInventory(final EntityPlayer p0);
    
    void setInventorySlotContents(final int p0, final ItemStack p1);
}
