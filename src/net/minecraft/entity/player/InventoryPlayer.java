package net.minecraft.entity.player;

import net.minecraft.inventory.*;
import net.minecraft.item.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import net.minecraft.command.server.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;

public class InventoryPlayer implements IInventory
{
    public /* synthetic */ boolean inventoryChanged;
    private /* synthetic */ ItemStack itemStack;
    public /* synthetic */ EntityPlayer player;
    public /* synthetic */ int currentItem;
    public /* synthetic */ ItemStack[] mainInventory;
    public /* synthetic */ ItemStack[] armorInventory;
    
    public void dropAllItems() {
        for (int llllllllllllllIIIIlIIIIIllIIllIl = 0; llllllllllllllIIIIlIIIIIllIIllIl < this.mainInventory.length; ++llllllllllllllIIIIlIIIIIllIIllIl) {
            if (this.mainInventory[llllllllllllllIIIIlIIIIIllIIllIl] != null) {
                this.player.func_146097_a(this.mainInventory[llllllllllllllIIIIlIIIIIllIIllIl], true, false);
                this.mainInventory[llllllllllllllIIIIlIIIIIllIIllIl] = null;
            }
        }
        for (int llllllllllllllIIIIlIIIIIllIIllIl = 0; llllllllllllllIIIIlIIIIIllIIllIl < this.armorInventory.length; ++llllllllllllllIIIIlIIIIIllIIllIl) {
            if (this.armorInventory[llllllllllllllIIIIlIIIIIllIIllIl] != null) {
                this.player.func_146097_a(this.armorInventory[llllllllllllllIIIIlIIIIIllIIllIl], true, false);
                this.armorInventory[llllllllllllllIIIIlIIIIIllIIllIl] = null;
            }
        }
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }
    
    public int getTotalArmorValue() {
        int llllllllllllllIIIIlIIIIIlllIIIII = 0;
        for (int llllllllllllllIIIIlIIIIIllIlllll = 0; llllllllllllllIIIIlIIIIIllIlllll < this.armorInventory.length; ++llllllllllllllIIIIlIIIIIllIlllll) {
            if (this.armorInventory[llllllllllllllIIIIlIIIIIllIlllll] != null && this.armorInventory[llllllllllllllIIIIlIIIIIllIlllll].getItem() instanceof ItemArmor) {
                final int llllllllllllllIIIIlIIIIIllIllllI = ((ItemArmor)this.armorInventory[llllllllllllllIIIIlIIIIIllIlllll].getItem()).damageReduceAmount;
                llllllllllllllIIIIlIIIIIlllIIIII += llllllllllllllIIIIlIIIIIllIllllI;
            }
        }
        return llllllllllllllIIIIlIIIIIlllIIIII;
    }
    
    @Override
    public ItemStack getStackInSlot(int llllllllllllllIIIIlIIIIIllllllll) {
        ItemStack[] llllllllllllllIIIIlIIIIIlllllllI = this.mainInventory;
        if (llllllllllllllIIIIlIIIIIllllllll >= llllllllllllllIIIIlIIIIIlllllllI.length) {
            llllllllllllllIIIIlIIIIIllllllll -= llllllllllllllIIIIlIIIIIlllllllI.length;
            llllllllllllllIIIIlIIIIIlllllllI = this.armorInventory;
        }
        return llllllllllllllIIIIlIIIIIlllllllI[llllllllllllllIIIIlIIIIIllllllll];
    }
    
    private int getInventorySlotContainItemAndDamage(final Item llllllllllllllIIIIlIIIIllllIlIIl, final int llllllllllllllIIIIlIIIIllllIIlII) {
        for (int llllllllllllllIIIIlIIIIllllIIlll = 0; llllllllllllllIIIIlIIIIllllIIlll < this.mainInventory.length; ++llllllllllllllIIIIlIIIIllllIIlll) {
            if (this.mainInventory[llllllllllllllIIIIlIIIIllllIIlll] != null && this.mainInventory[llllllllllllllIIIIlIIIIllllIIlll].getItem() == llllllllllllllIIIIlIIIIllllIlIIl && this.mainInventory[llllllllllllllIIIIlIIIIllllIIlll].getMetadata() == llllllllllllllIIIIlIIIIllllIIlII) {
                return llllllllllllllIIIIlIIIIllllIIlll;
            }
        }
        return -1;
    }
    
    public void changeCurrentItem(int llllllllllllllIIIIlIIIIllIlIllll) {
        if (llllllllllllllIIIIlIIIIllIlIllll > 0) {
            llllllllllllllIIIIlIIIIllIlIllll = 1;
        }
        if (llllllllllllllIIIIlIIIIllIlIllll < 0) {
            llllllllllllllIIIIlIIIIllIlIllll = -1;
        }
        this.currentItem -= (int)llllllllllllllIIIIlIIIIllIlIllll;
        while (this.currentItem < 0) {
            this.currentItem += 9;
        }
        while (this.currentItem >= 9) {
            this.currentItem -= 9;
        }
    }
    
    public void setItemStack(final ItemStack llllllllllllllIIIIlIIIIIllIIIIlI) {
        this.itemStack = llllllllllllllIIIIlIIIIIllIIIIlI;
    }
    
    public InventoryPlayer(final EntityPlayer llllllllllllllIIIIlIIIIllllllIll) {
        this.mainInventory = new ItemStack[36];
        this.armorInventory = new ItemStack[4];
        this.player = llllllllllllllIIIIlIIIIllllllIll;
    }
    
    public void decrementAnimations() {
        for (int llllllllllllllIIIIlIIIIlIlllllII = 0; llllllllllllllIIIIlIIIIlIlllllII < this.mainInventory.length; ++llllllllllllllIIIIlIIIIlIlllllII) {
            if (this.mainInventory[llllllllllllllIIIIlIIIIlIlllllII] != null) {
                this.mainInventory[llllllllllllllIIIIlIIIIlIlllllII].updateAnimation(this.player.worldObj, this.player, llllllllllllllIIIIlIIIIlIlllllII, this.currentItem == llllllllllllllIIIIlIIIIlIlllllII);
            }
        }
    }
    
    public boolean addItemStackToInventory(final ItemStack llllllllllllllIIIIlIIIIlIlIllIlI) {
        if (llllllllllllllIIIIlIIIIlIlIllIlI != null && llllllllllllllIIIIlIIIIlIlIllIlI.stackSize != 0 && llllllllllllllIIIIlIIIIlIlIllIlI.getItem() != null) {
            try {
                if (llllllllllllllIIIIlIIIIlIlIllIlI.isItemDamaged()) {
                    final int llllllllllllllIIIIlIIIIlIllIIIII = this.getFirstEmptyStack();
                    if (llllllllllllllIIIIlIIIIlIllIIIII >= 0) {
                        this.mainInventory[llllllllllllllIIIIlIIIIlIllIIIII] = ItemStack.copyItemStack(llllllllllllllIIIIlIIIIlIlIllIlI);
                        this.mainInventory[llllllllllllllIIIIlIIIIlIllIIIII].animationsToGo = 5;
                        llllllllllllllIIIIlIIIIlIlIllIlI.stackSize = 0;
                        return true;
                    }
                    if (this.player.capabilities.isCreativeMode) {
                        llllllllllllllIIIIlIIIIlIlIllIlI.stackSize = 0;
                        return true;
                    }
                    return false;
                }
                else {
                    int llllllllllllllIIIIlIIIIlIlIlllll;
                    do {
                        llllllllllllllIIIIlIIIIlIlIlllll = llllllllllllllIIIIlIIIIlIlIllIlI.stackSize;
                        llllllllllllllIIIIlIIIIlIlIllIlI.stackSize = this.storePartialItemStack(llllllllllllllIIIIlIIIIlIlIllIlI);
                    } while (llllllllllllllIIIIlIIIIlIlIllIlI.stackSize > 0 && llllllllllllllIIIIlIIIIlIlIllIlI.stackSize < llllllllllllllIIIIlIIIIlIlIlllll);
                    if (llllllllllllllIIIIlIIIIlIlIllIlI.stackSize == llllllllllllllIIIIlIIIIlIlIlllll && this.player.capabilities.isCreativeMode) {
                        llllllllllllllIIIIlIIIIlIlIllIlI.stackSize = 0;
                        return true;
                    }
                    return llllllllllllllIIIIlIIIIlIlIllIlI.stackSize < llllllllllllllIIIIlIIIIlIlIlllll;
                }
            }
            catch (Throwable llllllllllllllIIIIlIIIIlIlIllllI) {
                final CrashReport llllllllllllllIIIIlIIIIlIlIlllIl = CrashReport.makeCrashReport(llllllllllllllIIIIlIIIIlIlIllllI, "Adding item to inventory");
                final CrashReportCategory llllllllllllllIIIIlIIIIlIlIlllII = llllllllllllllIIIIlIIIIlIlIlllIl.makeCategory("Item being added");
                llllllllllllllIIIIlIIIIlIlIlllII.addCrashSection("Item ID", Item.getIdFromItem(llllllllllllllIIIIlIIIIlIlIllIlI.getItem()));
                llllllllllllllIIIIlIIIIlIlIlllII.addCrashSection("Item data", llllllllllllllIIIIlIIIIlIlIllIlI.getMetadata());
                llllllllllllllIIIIlIIIIlIlIlllII.addCrashSectionCallable("Item name", new Callable() {
                    @Override
                    public String call() {
                        return llllllllllllllIIIIlIIIIlIlIllIlI.getDisplayName();
                    }
                    
                    static {
                        __OBFID = "CL_00001710";
                    }
                });
                throw new ReportedException(llllllllllllllIIIIlIIIIlIlIlllIl);
            }
        }
        return false;
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    public boolean consumeInventoryItem(final Item llllllllllllllIIIIlIIIIlIlllIIlI) {
        final int llllllllllllllIIIIlIIIIlIlllIlII = this.getInventorySlotContainItem(llllllllllllllIIIIlIIIIlIlllIIlI);
        if (llllllllllllllIIIIlIIIIlIlllIlII < 0) {
            return false;
        }
        final ItemStack itemStack = this.mainInventory[llllllllllllllIIIIlIIIIlIlllIlII];
        if (--itemStack.stackSize <= 0) {
            this.mainInventory[llllllllllllllIIIIlIIIIlIlllIlII] = null;
        }
        return true;
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllIIIIlIIIIIlIlllIIl) {
        return !this.player.isDead && llllllllllllllIIIIlIIIIIlIlllIIl.getDistanceSqToEntity(this.player) <= 64.0;
    }
    
    static {
        __OBFID = "CL_00001709";
    }
    
    public int getFirstEmptyStack() {
        for (int llllllllllllllIIIIlIIIIlllIlIllI = 0; llllllllllllllIIIIlIIIIlllIlIllI < this.mainInventory.length; ++llllllllllllllIIIIlIIIIlllIlIllI) {
            if (this.mainInventory[llllllllllllllIIIIlIIIIlllIlIllI] == null) {
                return llllllllllllllIIIIlIIIIlllIlIllI;
            }
        }
        return -1;
    }
    
    public static int getHotbarSize() {
        return 9;
    }
    
    private int storePartialItemStack(final ItemStack llllllllllllllIIIIlIIIIllIIIIlII) {
        final Item llllllllllllllIIIIlIIIIllIIIlIIl = llllllllllllllIIIIlIIIIllIIIIlII.getItem();
        int llllllllllllllIIIIlIIIIllIIIlIII = llllllllllllllIIIIlIIIIllIIIIlII.stackSize;
        int llllllllllllllIIIIlIIIIllIIIIlll = this.storeItemStack(llllllllllllllIIIIlIIIIllIIIIlII);
        if (llllllllllllllIIIIlIIIIllIIIIlll < 0) {
            llllllllllllllIIIIlIIIIllIIIIlll = this.getFirstEmptyStack();
        }
        if (llllllllllllllIIIIlIIIIllIIIIlll < 0) {
            return llllllllllllllIIIIlIIIIllIIIlIII;
        }
        if (this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll] == null) {
            this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll] = new ItemStack(llllllllllllllIIIIlIIIIllIIIlIIl, 0, llllllllllllllIIIIlIIIIllIIIIlII.getMetadata());
            if (llllllllllllllIIIIlIIIIllIIIIlII.hasTagCompound()) {
                this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll].setTagCompound((NBTTagCompound)llllllllllllllIIIIlIIIIllIIIIlII.getTagCompound().copy());
            }
        }
        int llllllllllllllIIIIlIIIIllIIIIllI;
        if ((llllllllllllllIIIIlIIIIllIIIIllI = llllllllllllllIIIIlIIIIllIIIlIII) > this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll].getMaxStackSize() - this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll].stackSize) {
            llllllllllllllIIIIlIIIIllIIIIllI = this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll].getMaxStackSize() - this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll].stackSize;
        }
        if (llllllllllllllIIIIlIIIIllIIIIllI > this.getInventoryStackLimit() - this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll].stackSize) {
            llllllllllllllIIIIlIIIIllIIIIllI = this.getInventoryStackLimit() - this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll].stackSize;
        }
        if (llllllllllllllIIIIlIIIIllIIIIllI == 0) {
            return llllllllllllllIIIIlIIIIllIIIlIII;
        }
        llllllllllllllIIIIlIIIIllIIIlIII -= llllllllllllllIIIIlIIIIllIIIIllI;
        final ItemStack itemStack = this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll];
        itemStack.stackSize += llllllllllllllIIIIlIIIIllIIIIllI;
        this.mainInventory[llllllllllllllIIIIlIIIIllIIIIlll].animationsToGo = 5;
        return llllllllllllllIIIIlIIIIllIIIlIII;
    }
    
    public ItemStack getCurrentItem() {
        return (this.currentItem < 9 && this.currentItem >= 0) ? this.mainInventory[this.currentItem] : null;
    }
    
    @Override
    public void markDirty() {
        this.inventoryChanged = true;
    }
    
    public int func_174925_a(final Item llllllllllllllIIIIlIIIIllIlIIlII, final int llllllllllllllIIIIlIIIIllIIllIII, final int llllllllllllllIIIIlIIIIllIlIIIlI, final NBTTagCompound llllllllllllllIIIIlIIIIllIIlIllI) {
        int llllllllllllllIIIIlIIIIllIlIIIII = 0;
        for (int llllllllllllllIIIIlIIIIllIIlllll = 0; llllllllllllllIIIIlIIIIllIIlllll < this.mainInventory.length; ++llllllllllllllIIIIlIIIIllIIlllll) {
            final ItemStack llllllllllllllIIIIlIIIIllIIllllI = this.mainInventory[llllllllllllllIIIIlIIIIllIIlllll];
            if (llllllllllllllIIIIlIIIIllIIllllI != null && (llllllllllllllIIIIlIIIIllIlIIlII == null || llllllllllllllIIIIlIIIIllIIllllI.getItem() == llllllllllllllIIIIlIIIIllIlIIlII) && (llllllllllllllIIIIlIIIIllIIllIII <= -1 || llllllllllllllIIIIlIIIIllIIllllI.getMetadata() == llllllllllllllIIIIlIIIIllIIllIII) && (llllllllllllllIIIIlIIIIllIIlIllI == null || CommandTestForBlock.func_175775_a(llllllllllllllIIIIlIIIIllIIlIllI, llllllllllllllIIIIlIIIIllIIllllI.getTagCompound(), true))) {
                final int llllllllllllllIIIIlIIIIllIIlllII = (llllllllllllllIIIIlIIIIllIlIIIlI <= 0) ? llllllllllllllIIIIlIIIIllIIllllI.stackSize : Math.min(llllllllllllllIIIIlIIIIllIlIIIlI - llllllllllllllIIIIlIIIIllIlIIIII, llllllllllllllIIIIlIIIIllIIllllI.stackSize);
                llllllllllllllIIIIlIIIIllIlIIIII += llllllllllllllIIIIlIIIIllIIlllII;
                if (llllllllllllllIIIIlIIIIllIlIIIlI != 0) {
                    final ItemStack itemStack = this.mainInventory[llllllllllllllIIIIlIIIIllIIlllll];
                    itemStack.stackSize -= llllllllllllllIIIIlIIIIllIIlllII;
                    if (this.mainInventory[llllllllllllllIIIIlIIIIllIIlllll].stackSize == 0) {
                        this.mainInventory[llllllllllllllIIIIlIIIIllIIlllll] = null;
                    }
                    if (llllllllllllllIIIIlIIIIllIlIIIlI > 0 && llllllllllllllIIIIlIIIIllIlIIIII >= llllllllllllllIIIIlIIIIllIlIIIlI) {
                        return llllllllllllllIIIIlIIIIllIlIIIII;
                    }
                }
            }
        }
        for (int llllllllllllllIIIIlIIIIllIIlllll = 0; llllllllllllllIIIIlIIIIllIIlllll < this.armorInventory.length; ++llllllllllllllIIIIlIIIIllIIlllll) {
            final ItemStack llllllllllllllIIIIlIIIIllIIlllIl = this.armorInventory[llllllllllllllIIIIlIIIIllIIlllll];
            if (llllllllllllllIIIIlIIIIllIIlllIl != null && (llllllllllllllIIIIlIIIIllIlIIlII == null || llllllllllllllIIIIlIIIIllIIlllIl.getItem() == llllllllllllllIIIIlIIIIllIlIIlII) && (llllllllllllllIIIIlIIIIllIIllIII <= -1 || llllllllllllllIIIIlIIIIllIIlllIl.getMetadata() == llllllllllllllIIIIlIIIIllIIllIII) && (llllllllllllllIIIIlIIIIllIIlIllI == null || CommandTestForBlock.func_175775_a(llllllllllllllIIIIlIIIIllIIlIllI, llllllllllllllIIIIlIIIIllIIlllIl.getTagCompound(), false))) {
                final int llllllllllllllIIIIlIIIIllIIllIll = (llllllllllllllIIIIlIIIIllIlIIIlI <= 0) ? llllllllllllllIIIIlIIIIllIIlllIl.stackSize : Math.min(llllllllllllllIIIIlIIIIllIlIIIlI - llllllllllllllIIIIlIIIIllIlIIIII, llllllllllllllIIIIlIIIIllIIlllIl.stackSize);
                llllllllllllllIIIIlIIIIllIlIIIII += llllllllllllllIIIIlIIIIllIIllIll;
                if (llllllllllllllIIIIlIIIIllIlIIIlI != 0) {
                    final ItemStack itemStack2 = this.armorInventory[llllllllllllllIIIIlIIIIllIIlllll];
                    itemStack2.stackSize -= llllllllllllllIIIIlIIIIllIIllIll;
                    if (this.armorInventory[llllllllllllllIIIIlIIIIllIIlllll].stackSize == 0) {
                        this.armorInventory[llllllllllllllIIIIlIIIIllIIlllll] = null;
                    }
                    if (llllllllllllllIIIIlIIIIllIlIIIlI > 0 && llllllllllllllIIIIlIIIIllIlIIIII >= llllllllllllllIIIIlIIIIllIlIIIlI) {
                        return llllllllllllllIIIIlIIIIllIlIIIII;
                    }
                }
            }
        }
        if (this.itemStack != null) {
            if (llllllllllllllIIIIlIIIIllIlIIlII != null && this.itemStack.getItem() != llllllllllllllIIIIlIIIIllIlIIlII) {
                return llllllllllllllIIIIlIIIIllIlIIIII;
            }
            if (llllllllllllllIIIIlIIIIllIIllIII > -1 && this.itemStack.getMetadata() != llllllllllllllIIIIlIIIIllIIllIII) {
                return llllllllllllllIIIIlIIIIllIlIIIII;
            }
            if (llllllllllllllIIIIlIIIIllIIlIllI != null && !CommandTestForBlock.func_175775_a(llllllllllllllIIIIlIIIIllIIlIllI, this.itemStack.getTagCompound(), false)) {
                return llllllllllllllIIIIlIIIIllIlIIIII;
            }
            final int llllllllllllllIIIIlIIIIllIIlllll = (llllllllllllllIIIIlIIIIllIlIIIlI <= 0) ? this.itemStack.stackSize : Math.min(llllllllllllllIIIIlIIIIllIlIIIlI - llllllllllllllIIIIlIIIIllIlIIIII, this.itemStack.stackSize);
            llllllllllllllIIIIlIIIIllIlIIIII += llllllllllllllIIIIlIIIIllIIlllll;
            if (llllllllllllllIIIIlIIIIllIlIIIlI != 0) {
                final ItemStack itemStack3 = this.itemStack;
                itemStack3.stackSize -= llllllllllllllIIIIlIIIIllIIlllll;
                if (this.itemStack.stackSize == 0) {
                    this.itemStack = null;
                }
                if (llllllllllllllIIIIlIIIIllIlIIIlI > 0 && llllllllllllllIIIIlIIIIllIlIIIII >= llllllllllllllIIIIlIIIIllIlIIIlI) {
                    return llllllllllllllIIIIlIIIIllIlIIIII;
                }
            }
        }
        return llllllllllllllIIIIlIIIIllIlIIIII;
    }
    
    @Override
    public void clearInventory() {
        for (int llllllllllllllIIIIlIIIIIlIIlIllI = 0; llllllllllllllIIIIlIIIIIlIIlIllI < this.mainInventory.length; ++llllllllllllllIIIIlIIIIIlIIlIllI) {
            this.mainInventory[llllllllllllllIIIIlIIIIIlIIlIllI] = null;
        }
        for (int llllllllllllllIIIIlIIIIIlIIlIllI = 0; llllllllllllllIIIIlIIIIIlIIlIllI < this.armorInventory.length; ++llllllllllllllIIIIlIIIIIlIIlIllI) {
            this.armorInventory[llllllllllllllIIIIlIIIIIlIIlIllI] = null;
        }
    }
    
    @Override
    public void setField(final int llllllllllllllIIIIlIIIIIlIIlllII, final int llllllllllllllIIIIlIIIIIlIIllIll) {
    }
    
    public ItemStack getItemStack() {
        return this.itemStack;
    }
    
    @Override
    public String getName() {
        return "container.inventory";
    }
    
    @Override
    public int getField(final int llllllllllllllIIIIlIIIIIlIIllllI) {
        return 0;
    }
    
    @Override
    public void setInventorySlotContents(int llllllllllllllIIIIlIIIIlIIllIIIl, final ItemStack llllllllllllllIIIIlIIIIlIIllIlII) {
        ItemStack[] llllllllllllllIIIIlIIIIlIIllIIll = this.mainInventory;
        if (llllllllllllllIIIIlIIIIlIIllIIIl >= llllllllllllllIIIIlIIIIlIIllIIll.length) {
            llllllllllllllIIIIlIIIIlIIllIIIl -= llllllllllllllIIIIlIIIIlIIllIIll.length;
            llllllllllllllIIIIlIIIIlIIllIIll = this.armorInventory;
        }
        llllllllllllllIIIIlIIIIlIIllIIll[llllllllllllllIIIIlIIIIlIIllIIIl] = llllllllllllllIIIIlIIIIlIIllIlII;
    }
    
    @Override
    public ItemStack decrStackSize(int llllllllllllllIIIIlIIIIlIlIIlIlI, final int llllllllllllllIIIIlIIIIlIlIIllll) {
        ItemStack[] llllllllllllllIIIIlIIIIlIlIIlllI = this.mainInventory;
        if (llllllllllllllIIIIlIIIIlIlIIlIlI >= this.mainInventory.length) {
            llllllllllllllIIIIlIIIIlIlIIlllI = this.armorInventory;
            llllllllllllllIIIIlIIIIlIlIIlIlI -= this.mainInventory.length;
        }
        if (llllllllllllllIIIIlIIIIlIlIIlllI[llllllllllllllIIIIlIIIIlIlIIlIlI] == null) {
            return null;
        }
        if (llllllllllllllIIIIlIIIIlIlIIlllI[llllllllllllllIIIIlIIIIlIlIIlIlI].stackSize <= llllllllllllllIIIIlIIIIlIlIIllll) {
            final ItemStack llllllllllllllIIIIlIIIIlIlIIllIl = llllllllllllllIIIIlIIIIlIlIIlllI[llllllllllllllIIIIlIIIIlIlIIlIlI];
            llllllllllllllIIIIlIIIIlIlIIlllI[llllllllllllllIIIIlIIIIlIlIIlIlI] = null;
            return llllllllllllllIIIIlIIIIlIlIIllIl;
        }
        final ItemStack llllllllllllllIIIIlIIIIlIlIIllII = llllllllllllllIIIIlIIIIlIlIIlllI[llllllllllllllIIIIlIIIIlIlIIlIlI].splitStack(llllllllllllllIIIIlIIIIlIlIIllll);
        if (llllllllllllllIIIIlIIIIlIlIIlllI[llllllllllllllIIIIlIIIIlIlIIlIlI].stackSize == 0) {
            llllllllllllllIIIIlIIIIlIlIIlllI[llllllllllllllIIIIlIIIIlIlIIlIlI] = null;
        }
        return llllllllllllllIIIIlIIIIlIlIIllII;
    }
    
    public void copyInventory(final InventoryPlayer llllllllllllllIIIIlIIIIIlIlIIlII) {
        for (int llllllllllllllIIIIlIIIIIlIlIIIll = 0; llllllllllllllIIIIlIIIIIlIlIIIll < this.mainInventory.length; ++llllllllllllllIIIIlIIIIIlIlIIIll) {
            this.mainInventory[llllllllllllllIIIIlIIIIIlIlIIIll] = ItemStack.copyItemStack(llllllllllllllIIIIlIIIIIlIlIIlII.mainInventory[llllllllllllllIIIIlIIIIIlIlIIIll]);
        }
        for (int llllllllllllllIIIIlIIIIIlIlIIIll = 0; llllllllllllllIIIIlIIIIIlIlIIIll < this.armorInventory.length; ++llllllllllllllIIIIlIIIIIlIlIIIll) {
            this.armorInventory[llllllllllllllIIIIlIIIIIlIlIIIll] = ItemStack.copyItemStack(llllllllllllllIIIIlIIIIIlIlIIlII.armorInventory[llllllllllllllIIIIlIIIIIlIlIIIll]);
        }
        this.currentItem = llllllllllllllIIIIlIIIIIlIlIIlII.currentItem;
    }
    
    public ItemStack armorItemInSlot(final int llllllllllllllIIIIlIIIIIlllIIllI) {
        return this.armorInventory[llllllllllllllIIIIlIIIIIlllIIllI];
    }
    
    private int getInventorySlotContainItem(final Item llllllllllllllIIIIlIIIIlllllIIll) {
        for (int llllllllllllllIIIIlIIIIlllllIIlI = 0; llllllllllllllIIIIlIIIIlllllIIlI < this.mainInventory.length; ++llllllllllllllIIIIlIIIIlllllIIlI) {
            if (this.mainInventory[llllllllllllllIIIIlIIIIlllllIIlI] != null && this.mainInventory[llllllllllllllIIIIlIIIIlllllIIlI].getItem() == llllllllllllllIIIIlIIIIlllllIIll) {
                return llllllllllllllIIIIlIIIIlllllIIlI;
            }
        }
        return -1;
    }
    
    public void readFromNBT(final NBTTagList llllllllllllllIIIIlIIIIlIIIIlIll) {
        this.mainInventory = new ItemStack[36];
        this.armorInventory = new ItemStack[4];
        for (int llllllllllllllIIIIlIIIIlIIIlIIII = 0; llllllllllllllIIIIlIIIIlIIIlIIII < llllllllllllllIIIIlIIIIlIIIIlIll.tagCount(); ++llllllllllllllIIIIlIIIIlIIIlIIII) {
            final NBTTagCompound llllllllllllllIIIIlIIIIlIIIIllll = llllllllllllllIIIIlIIIIlIIIIlIll.getCompoundTagAt(llllllllllllllIIIIlIIIIlIIIlIIII);
            final int llllllllllllllIIIIlIIIIlIIIIlllI = llllllllllllllIIIIlIIIIlIIIIllll.getByte("Slot") & 0xFF;
            final ItemStack llllllllllllllIIIIlIIIIlIIIIllIl = ItemStack.loadItemStackFromNBT(llllllllllllllIIIIlIIIIlIIIIllll);
            if (llllllllllllllIIIIlIIIIlIIIIllIl != null) {
                if (llllllllllllllIIIIlIIIIlIIIIlllI >= 0 && llllllllllllllIIIIlIIIIlIIIIlllI < this.mainInventory.length) {
                    this.mainInventory[llllllllllllllIIIIlIIIIlIIIIlllI] = llllllllllllllIIIIlIIIIlIIIIllIl;
                }
                if (llllllllllllllIIIIlIIIIlIIIIlllI >= 100 && llllllllllllllIIIIlIIIIlIIIIlllI < this.armorInventory.length + 100) {
                    this.armorInventory[llllllllllllllIIIIlIIIIlIIIIlllI - 100] = llllllllllllllIIIIlIIIIlIIIIllIl;
                }
            }
        }
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(int llllllllllllllIIIIlIIIIlIIllllIl) {
        ItemStack[] llllllllllllllIIIIlIIIIlIlIIIIII = this.mainInventory;
        if (llllllllllllllIIIIlIIIIlIIllllIl >= this.mainInventory.length) {
            llllllllllllllIIIIlIIIIlIlIIIIII = this.armorInventory;
            llllllllllllllIIIIlIIIIlIIllllIl -= this.mainInventory.length;
        }
        if (llllllllllllllIIIIlIIIIlIlIIIIII[llllllllllllllIIIIlIIIIlIIllllIl] != null) {
            final ItemStack llllllllllllllIIIIlIIIIlIIllllll = llllllllllllllIIIIlIIIIlIlIIIIII[llllllllllllllIIIIlIIIIlIIllllIl];
            llllllllllllllIIIIlIIIIlIlIIIIII[llllllllllllllIIIIlIIIIlIIllllIl] = null;
            return llllllllllllllIIIIlIIIIlIIllllll;
        }
        return null;
    }
    
    public void setCurrentItem(final Item llllllllllllllIIIIlIIIIlllIIlIII, final int llllllllllllllIIIIlIIIIlllIIIlll, final boolean llllllllllllllIIIIlIIIIlllIIIllI, final boolean llllllllllllllIIIIlIIIIlllIIIlIl) {
        final ItemStack llllllllllllllIIIIlIIIIlllIIIlII = this.getCurrentItem();
        final int llllllllllllllIIIIlIIIIlllIIIIll = llllllllllllllIIIIlIIIIlllIIIllI ? this.getInventorySlotContainItemAndDamage(llllllllllllllIIIIlIIIIlllIIlIII, llllllllllllllIIIIlIIIIlllIIIlll) : this.getInventorySlotContainItem(llllllllllllllIIIIlIIIIlllIIlIII);
        if (llllllllllllllIIIIlIIIIlllIIIIll >= 0 && llllllllllllllIIIIlIIIIlllIIIIll < 9) {
            this.currentItem = llllllllllllllIIIIlIIIIlllIIIIll;
        }
        else if (llllllllllllllIIIIlIIIIlllIIIlIl && llllllllllllllIIIIlIIIIlllIIlIII != null) {
            final int llllllllllllllIIIIlIIIIlllIIIIlI = this.getFirstEmptyStack();
            if (llllllllllllllIIIIlIIIIlllIIIIlI >= 0 && llllllllllllllIIIIlIIIIlllIIIIlI < 9) {
                this.currentItem = llllllllllllllIIIIlIIIIlllIIIIlI;
            }
            if (llllllllllllllIIIIlIIIIlllIIIlII == null || !llllllllllllllIIIIlIIIIlllIIIlII.isItemEnchantable() || this.getInventorySlotContainItemAndDamage(llllllllllllllIIIIlIIIIlllIIIlII.getItem(), llllllllllllllIIIIlIIIIlllIIIlII.getItemDamage()) != this.currentItem) {
                final int llllllllllllllIIIIlIIIIlllIIIIIl = this.getInventorySlotContainItemAndDamage(llllllllllllllIIIIlIIIIlllIIlIII, llllllllllllllIIIIlIIIIlllIIIlll);
                int llllllllllllllIIIIlIIIIllIllllll = 0;
                if (llllllllllllllIIIIlIIIIlllIIIIIl >= 0) {
                    final int llllllllllllllIIIIlIIIIlllIIIIII = this.mainInventory[llllllllllllllIIIIlIIIIlllIIIIIl].stackSize;
                    this.mainInventory[llllllllllllllIIIIlIIIIlllIIIIIl] = this.mainInventory[this.currentItem];
                }
                else {
                    llllllllllllllIIIIlIIIIllIllllll = 1;
                }
                this.mainInventory[this.currentItem] = new ItemStack(llllllllllllllIIIIlIIIIlllIIlIII, llllllllllllllIIIIlIIIIllIllllll, llllllllllllllIIIIlIIIIlllIIIlll);
            }
        }
    }
    
    public void damageArmor(float llllllllllllllIIIIlIIIIIllIlIIlI) {
        llllllllllllllIIIIlIIIIIllIlIIlI /= 4.0f;
        if (llllllllllllllIIIIlIIIIIllIlIIlI < 1.0f) {
            llllllllllllllIIIIlIIIIIllIlIIlI = 1.0f;
        }
        for (int llllllllllllllIIIIlIIIIIllIlIlII = 0; llllllllllllllIIIIlIIIIIllIlIlII < this.armorInventory.length; ++llllllllllllllIIIIlIIIIIllIlIlII) {
            if (this.armorInventory[llllllllllllllIIIIlIIIIIllIlIlII] != null && this.armorInventory[llllllllllllllIIIIlIIIIIllIlIlII].getItem() instanceof ItemArmor) {
                this.armorInventory[llllllllllllllIIIIlIIIIIllIlIlII].damageItem((int)llllllllllllllIIIIlIIIIIllIlIIlI, this.player);
                if (this.armorInventory[llllllllllllllIIIIlIIIIIllIlIlII].stackSize == 0) {
                    this.armorInventory[llllllllllllllIIIIlIIIIIllIlIlII] = null;
                }
            }
        }
    }
    
    public float getStrVsBlock(final Block llllllllllllllIIIIlIIIIlIIlIIlll) {
        float llllllllllllllIIIIlIIIIlIIlIlIIl = 1.0f;
        if (this.mainInventory[this.currentItem] != null) {
            llllllllllllllIIIIlIIIIlIIlIlIIl *= this.mainInventory[this.currentItem].getStrVsBlock(llllllllllllllIIIIlIIIIlIIlIIlll);
        }
        return llllllllllllllIIIIlIIIIlIIlIlIIl;
    }
    
    public boolean hasItem(final Item llllllllllllllIIIIlIIIIlIllIlIIl) {
        final int llllllllllllllIIIIlIIIIlIllIlIll = this.getInventorySlotContainItem(llllllllllllllIIIIlIIIIlIllIlIIl);
        return llllllllllllllIIIIlIIIIlIllIlIll >= 0;
    }
    
    public boolean func_146025_b(final Block llllllllllllllIIIIlIIIIIlllIllIl) {
        if (llllllllllllllIIIIlIIIIIlllIllIl.getMaterial().isToolNotRequired()) {
            return true;
        }
        final ItemStack llllllllllllllIIIIlIIIIIlllIllll = this.getStackInSlot(this.currentItem);
        return llllllllllllllIIIIlIIIIIlllIllll != null && llllllllllllllIIIIlIIIIIlllIllll.canHarvestBlock(llllllllllllllIIIIlIIIIIlllIllIl);
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIIIIlIIIIIlIlIlllI) {
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIIIIlIIIIIlIlIllII) {
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIIIIlIIIIIlIlIlIlI, final ItemStack llllllllllllllIIIIlIIIIIlIlIlIIl) {
        return true;
    }
    
    private int storeItemStack(final ItemStack llllllllllllllIIIIlIIIIlllIllIll) {
        for (int llllllllllllllIIIIlIIIIlllIlllIl = 0; llllllllllllllIIIIlIIIIlllIlllIl < this.mainInventory.length; ++llllllllllllllIIIIlIIIIlllIlllIl) {
            if (this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl] != null && this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl].getItem() == llllllllllllllIIIIlIIIIlllIllIll.getItem() && this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl].isStackable() && this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl].stackSize < this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl].getMaxStackSize() && this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl].stackSize < this.getInventoryStackLimit() && (!this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl].getHasSubtypes() || this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl].getMetadata() == llllllllllllllIIIIlIIIIlllIllIll.getMetadata()) && ItemStack.areItemStackTagsEqual(this.mainInventory[llllllllllllllIIIIlIIIIlllIlllIl], llllllllllllllIIIIlIIIIlllIllIll)) {
                return llllllllllllllIIIIlIIIIlllIlllIl;
            }
        }
        return -1;
    }
    
    @Override
    public int getSizeInventory() {
        return this.mainInventory.length + 4;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public boolean hasItemStack(final ItemStack llllllllllllllIIIIlIIIIIlIllIIIl) {
        for (int llllllllllllllIIIIlIIIIIlIllIIll = 0; llllllllllllllIIIIlIIIIIlIllIIll < this.armorInventory.length; ++llllllllllllllIIIIlIIIIIlIllIIll) {
            if (this.armorInventory[llllllllllllllIIIIlIIIIIlIllIIll] != null && this.armorInventory[llllllllllllllIIIIlIIIIIlIllIIll].isItemEqual(llllllllllllllIIIIlIIIIIlIllIIIl)) {
                return true;
            }
        }
        for (int llllllllllllllIIIIlIIIIIlIllIIll = 0; llllllllllllllIIIIlIIIIIlIllIIll < this.mainInventory.length; ++llllllllllllllIIIIlIIIIIlIllIIll) {
            if (this.mainInventory[llllllllllllllIIIIlIIIIIlIllIIll] != null && this.mainInventory[llllllllllllllIIIIlIIIIIlIllIIll].isItemEqual(llllllllllllllIIIIlIIIIIlIllIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    public NBTTagList writeToNBT(final NBTTagList llllllllllllllIIIIlIIIIlIIIllIll) {
        for (int llllllllllllllIIIIlIIIIlIIIlllll = 0; llllllllllllllIIIIlIIIIlIIIlllll < this.mainInventory.length; ++llllllllllllllIIIIlIIIIlIIIlllll) {
            if (this.mainInventory[llllllllllllllIIIIlIIIIlIIIlllll] != null) {
                final NBTTagCompound llllllllllllllIIIIlIIIIlIIIllllI = new NBTTagCompound();
                llllllllllllllIIIIlIIIIlIIIllllI.setByte("Slot", (byte)llllllllllllllIIIIlIIIIlIIIlllll);
                this.mainInventory[llllllllllllllIIIIlIIIIlIIIlllll].writeToNBT(llllllllllllllIIIIlIIIIlIIIllllI);
                llllllllllllllIIIIlIIIIlIIIllIll.appendTag(llllllllllllllIIIIlIIIIlIIIllllI);
            }
        }
        for (int llllllllllllllIIIIlIIIIlIIIlllll = 0; llllllllllllllIIIIlIIIIlIIIlllll < this.armorInventory.length; ++llllllllllllllIIIIlIIIIlIIIlllll) {
            if (this.armorInventory[llllllllllllllIIIIlIIIIlIIIlllll] != null) {
                final NBTTagCompound llllllllllllllIIIIlIIIIlIIIlllIl = new NBTTagCompound();
                llllllllllllllIIIIlIIIIlIIIlllIl.setByte("Slot", (byte)(llllllllllllllIIIIlIIIIlIIIlllll + 100));
                this.armorInventory[llllllllllllllIIIIlIIIIlIIIlllll].writeToNBT(llllllllllllllIIIIlIIIIlIIIlllIl);
                llllllllllllllIIIIlIIIIlIIIllIll.appendTag(llllllllllllllIIIIlIIIIlIIIlllIl);
            }
        }
        return llllllllllllllIIIIlIIIIlIIIllIll;
    }
}
