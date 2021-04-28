package net.minecraft.inventory;

import net.minecraft.item.*;
import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;

public class InventoryBasic implements IInventory
{
    private /* synthetic */ ItemStack[] inventoryContents;
    private /* synthetic */ int slotsCount;
    private /* synthetic */ String inventoryTitle;
    private /* synthetic */ List field_70480_d;
    private /* synthetic */ boolean hasCustomName;
    
    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public void setField(final int llllllllllllllIlllIlIIllIIIllIIl, final int llllllllllllllIlllIlIIllIIIllIII) {
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public void markDirty() {
        if (this.field_70480_d != null) {
            for (int llllllllllllllIlllIlIIllIIlIlIII = 0; llllllllllllllIlllIlIIllIIlIlIII < this.field_70480_d.size(); ++llllllllllllllIlllIlIIllIIlIlIII) {
                this.field_70480_d.get(llllllllllllllIlllIlIIllIIlIlIII).onInventoryChanged(this);
            }
        }
    }
    
    @Override
    public String getName() {
        return this.inventoryTitle;
    }
    
    public void func_110134_a(final IInvBasic llllllllllllllIlllIlIIlllIIIIIIl) {
        if (this.field_70480_d == null) {
            this.field_70480_d = Lists.newArrayList();
        }
        this.field_70480_d.add(llllllllllllllIlllIlIIlllIIIIIIl);
    }
    
    @Override
    public int getSizeInventory() {
        return this.slotsCount;
    }
    
    public InventoryBasic(final String llllllllllllllIlllIlIIlllIIlIlII, final boolean llllllllllllllIlllIlIIlllIIlIIll, final int llllllllllllllIlllIlIIlllIIIlllI) {
        this.inventoryTitle = llllllllllllllIlllIlIIlllIIlIlII;
        this.hasCustomName = llllllllllllllIlllIlIIlllIIlIIll;
        this.slotsCount = llllllllllllllIlllIlIIlllIIIlllI;
        this.inventoryContents = new ItemStack[llllllllllllllIlllIlIIlllIIIlllI];
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllIlllIlIIllIlllIIll) {
        return (llllllllllllllIlllIlIIllIlllIIll >= 0 && llllllllllllllIlllIlIIllIlllIIll < this.inventoryContents.length) ? this.inventoryContents[llllllllllllllIlllIlIIllIlllIIll] : null;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllIlllIlIIllIlIIIIll, final ItemStack llllllllllllllIlllIlIIllIIllllll) {
        this.inventoryContents[llllllllllllllIlllIlIIllIlIIIIll] = llllllllllllllIlllIlIIllIIllllll;
        if (llllllllllllllIlllIlIIllIIllllll != null && llllllllllllllIlllIlIIllIIllllll.stackSize > this.getInventoryStackLimit()) {
            llllllllllllllIlllIlIIllIIllllll.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIlllIlIIllIllIlIII, final int llllllllllllllIlllIlIIllIllIllII) {
        if (this.inventoryContents[llllllllllllllIlllIlIIllIllIlIII] == null) {
            return null;
        }
        if (this.inventoryContents[llllllllllllllIlllIlIIllIllIlIII].stackSize <= llllllllllllllIlllIlIIllIllIllII) {
            final ItemStack llllllllllllllIlllIlIIllIllIlIll = this.inventoryContents[llllllllllllllIlllIlIIllIllIlIII];
            this.inventoryContents[llllllllllllllIlllIlIIllIllIlIII] = null;
            this.markDirty();
            return llllllllllllllIlllIlIIllIllIlIll;
        }
        final ItemStack llllllllllllllIlllIlIIllIllIlIlI = this.inventoryContents[llllllllllllllIlllIlIIllIllIlIII].splitStack(llllllllllllllIlllIlIIllIllIllII);
        if (this.inventoryContents[llllllllllllllIlllIlIIllIllIlIII].stackSize == 0) {
            this.inventoryContents[llllllllllllllIlllIlIIllIllIlIII] = null;
        }
        this.markDirty();
        return llllllllllllllIlllIlIIllIllIlIlI;
    }
    
    @Override
    public int getField(final int llllllllllllllIlllIlIIllIIIllIll) {
        return 0;
    }
    
    public void func_110133_a(final String llllllllllllllIlllIlIIllIIllIIlI) {
        this.hasCustomName = true;
        this.inventoryTitle = llllllllllllllIlllIlIIllIIllIIlI;
    }
    
    static {
        __OBFID = "CL_00001514";
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIlllIlIIllIIlIIIlI) {
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIlllIlIIllIIlIIIII) {
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIlllIlIIllIIIllllI, final ItemStack llllllllllllllIlllIlIIllIIIlllIl) {
        return true;
    }
    
    public ItemStack func_174894_a(final ItemStack llllllllllllllIlllIlIIllIlIlIllI) {
        final ItemStack llllllllllllllIlllIlIIllIlIlllII = llllllllllllllIlllIlIIllIlIlIllI.copy();
        for (int llllllllllllllIlllIlIIllIlIllIll = 0; llllllllllllllIlllIlIIllIlIllIll < this.slotsCount; ++llllllllllllllIlllIlIIllIlIllIll) {
            final ItemStack llllllllllllllIlllIlIIllIlIllIlI = this.getStackInSlot(llllllllllllllIlllIlIIllIlIllIll);
            if (llllllllllllllIlllIlIIllIlIllIlI == null) {
                this.setInventorySlotContents(llllllllllllllIlllIlIIllIlIllIll, llllllllllllllIlllIlIIllIlIlllII);
                this.markDirty();
                return null;
            }
            if (ItemStack.areItemsEqual(llllllllllllllIlllIlIIllIlIllIlI, llllllllllllllIlllIlIIllIlIlllII)) {
                final int llllllllllllllIlllIlIIllIlIllIIl = Math.min(this.getInventoryStackLimit(), llllllllllllllIlllIlIIllIlIllIlI.getMaxStackSize());
                final int llllllllllllllIlllIlIIllIlIllIII = Math.min(llllllllllllllIlllIlIIllIlIlllII.stackSize, llllllllllllllIlllIlIIllIlIllIIl - llllllllllllllIlllIlIIllIlIllIlI.stackSize);
                if (llllllllllllllIlllIlIIllIlIllIII > 0) {
                    final ItemStack itemStack = llllllllllllllIlllIlIIllIlIllIlI;
                    itemStack.stackSize += llllllllllllllIlllIlIIllIlIllIII;
                    final ItemStack itemStack2 = llllllllllllllIlllIlIIllIlIlllII;
                    itemStack2.stackSize -= llllllllllllllIlllIlIIllIlIllIII;
                    if (llllllllllllllIlllIlIIllIlIlllII.stackSize <= 0) {
                        this.markDirty();
                        return null;
                    }
                }
            }
        }
        if (llllllllllllllIlllIlIIllIlIlllII.stackSize != llllllllllllllIlllIlIIllIlIlIllI.stackSize) {
            this.markDirty();
        }
        return llllllllllllllIlllIlIIllIlIlllII;
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllllllllllIlllIlIIllIlIIlIIl) {
        if (this.inventoryContents[llllllllllllllIlllIlIIllIlIIlIIl] != null) {
            final ItemStack llllllllllllllIlllIlIIllIlIIlIll = this.inventoryContents[llllllllllllllIlllIlIIllIlIIlIIl];
            this.inventoryContents[llllllllllllllIlllIlIIllIlIIlIIl] = null;
            return llllllllllllllIlllIlIIllIlIIlIll;
        }
        return null;
    }
    
    public InventoryBasic(final IChatComponent llllllllllllllIlllIlIIlllIIIIllI, final int llllllllllllllIlllIlIIlllIIIlIII) {
        this(llllllllllllllIlllIlIIlllIIIIllI.getUnformattedText(), true, llllllllllllllIlllIlIIlllIIIlIII);
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllIlllIlIIllIIlIIlII) {
        return true;
    }
    
    @Override
    public void clearInventory() {
        for (int llllllllllllllIlllIlIIllIIIlIIll = 0; llllllllllllllIlllIlIIllIIIlIIll < this.inventoryContents.length; ++llllllllllllllIlllIlIIllIIIlIIll) {
            this.inventoryContents[llllllllllllllIlllIlIIllIIIlIIll] = null;
        }
    }
    
    @Override
    public boolean hasCustomName() {
        return this.hasCustomName;
    }
    
    public void func_110132_b(final IInvBasic llllllllllllllIlllIlIIllIllllIIl) {
        this.field_70480_d.remove(llllllllllllllIlllIlIIllIllllIIl);
    }
}
