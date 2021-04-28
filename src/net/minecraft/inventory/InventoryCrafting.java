package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class InventoryCrafting implements IInventory
{
    private final /* synthetic */ ItemStack[] stackList;
    private final /* synthetic */ int inventoryWidth;
    private final /* synthetic */ int field_174924_c;
    private final /* synthetic */ Container eventHandler;
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIlIlIlIIIlIlIlIllI) {
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllIlIlIlIIIlIllIIllI, final ItemStack llllllllllllllIlIlIlIIIlIllIIlIl) {
        this.stackList[llllllllllllllIlIlIlIIIlIllIIllI] = llllllllllllllIlIlIlIIIlIllIIlIl;
        this.eventHandler.onCraftMatrixChanged(this);
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIlIlIlIIIlIlIlIlII, final ItemStack llllllllllllllIlIlIlIIIlIlIlIIll) {
        return true;
    }
    
    @Override
    public void clearInventory() {
        for (int llllllllllllllIlIlIlIIIlIIllllIl = 0; llllllllllllllIlIlIlIIIlIIllllIl < this.stackList.length; ++llllllllllllllIlIlIlIIIlIIllllIl) {
            this.stackList[llllllllllllllIlIlIlIIIlIIllllIl] = null;
        }
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllIlIlIlIIIlIlIllIlI) {
        return true;
    }
    
    @Override
    public void setField(final int llllllllllllllIlIlIlIIIlIlIIllll, final int llllllllllllllIlIlIlIIIlIlIIlllI) {
    }
    
    static {
        __OBFID = "CL_00001743";
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllIlIlIlIIIllIIIllll) {
        return (llllllllllllllIlIlIlIIIllIIIllll >= this.getSizeInventory()) ? null : this.stackList[llllllllllllllIlIlIlIIIllIIIllll];
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIlIlIlIIIlIlIllIII) {
    }
    
    @Override
    public int getField(final int llllllllllllllIlIlIlIIIlIlIlIIIl) {
        return 0;
    }
    
    public int func_174923_h() {
        return this.field_174924_c;
    }
    
    public int func_174922_i() {
        return this.inventoryWidth;
    }
    
    @Override
    public String getName() {
        return "container.crafting";
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public ItemStack getStackInRowAndColumn(final int llllllllllllllIlIlIlIIIllIIIIlll, final int llllllllllllllIlIlIlIIIllIIIIllI) {
        return (llllllllllllllIlIlIlIIIllIIIIlll >= 0 && llllllllllllllIlIlIlIIIllIIIIlll < this.inventoryWidth && llllllllllllllIlIlIlIIIllIIIIllI >= 0 && llllllllllllllIlIlIlIIIllIIIIllI <= this.field_174924_c) ? this.getStackInSlot(llllllllllllllIlIlIlIIIllIIIIlll + llllllllllllllIlIlIlIIIllIIIIllI * this.inventoryWidth) : null;
    }
    
    @Override
    public void markDirty() {
    }
    
    @Override
    public int getSizeInventory() {
        return this.stackList.length;
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllllllllllIlIlIlIIIlIlllllII) {
        if (this.stackList[llllllllllllllIlIlIlIIIlIlllllII] != null) {
            final ItemStack llllllllllllllIlIlIlIIIlIllllIll = this.stackList[llllllllllllllIlIlIlIIIlIlllllII];
            this.stackList[llllllllllllllIlIlIlIIIlIlllllII] = null;
            return llllllllllllllIlIlIlIIIlIllllIll;
        }
        return null;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIlIlIlIIIlIllIllIl, final int llllllllllllllIlIlIlIIIlIllIllII) {
        if (this.stackList[llllllllllllllIlIlIlIIIlIllIllIl] == null) {
            return null;
        }
        if (this.stackList[llllllllllllllIlIlIlIIIlIllIllIl].stackSize <= llllllllllllllIlIlIlIIIlIllIllII) {
            final ItemStack llllllllllllllIlIlIlIIIlIlllIIII = this.stackList[llllllllllllllIlIlIlIIIlIllIllIl];
            this.stackList[llllllllllllllIlIlIlIIIlIllIllIl] = null;
            this.eventHandler.onCraftMatrixChanged(this);
            return llllllllllllllIlIlIlIIIlIlllIIII;
        }
        final ItemStack llllllllllllllIlIlIlIIIlIllIllll = this.stackList[llllllllllllllIlIlIlIIIlIllIllIl].splitStack(llllllllllllllIlIlIlIIIlIllIllII);
        if (this.stackList[llllllllllllllIlIlIlIIIlIllIllIl].stackSize == 0) {
            this.stackList[llllllllllllllIlIlIlIIIlIllIllIl] = null;
        }
        this.eventHandler.onCraftMatrixChanged(this);
        return llllllllllllllIlIlIlIIIlIllIllll;
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    public InventoryCrafting(final Container llllllllllllllIlIlIlIIIllIlIIIII, final int llllllllllllllIlIlIlIIIllIIlllll, final int llllllllllllllIlIlIlIIIllIIllllI) {
        final int llllllllllllllIlIlIlIIIllIIlllIl = llllllllllllllIlIlIlIIIllIIlllll * llllllllllllllIlIlIlIIIllIIllllI;
        this.stackList = new ItemStack[llllllllllllllIlIlIlIIIllIIlllIl];
        this.eventHandler = llllllllllllllIlIlIlIIIllIlIIIII;
        this.inventoryWidth = llllllllllllllIlIlIlIIIllIIlllll;
        this.field_174924_c = llllllllllllllIlIlIlIIIllIIllllI;
    }
}
