package net.minecraft.inventory;

import net.minecraft.util.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class ContainerEnchantment extends Container
{
    public /* synthetic */ IInventory tableInventory;
    public /* synthetic */ int[] field_178151_h;
    private /* synthetic */ BlockPos field_178150_j;
    public /* synthetic */ int[] enchantLevels;
    private /* synthetic */ World worldPointer;
    public /* synthetic */ int field_178149_f;
    private /* synthetic */ Random rand;
    
    @Override
    public boolean enchantItem(final EntityPlayer lllllllllllllllIllIllIlIlllIlIIl, final int lllllllllllllllIllIllIlIllllIIlI) {
        final ItemStack lllllllllllllllIllIllIlIllllIIIl = this.tableInventory.getStackInSlot(0);
        final ItemStack lllllllllllllllIllIllIlIllllIIII = this.tableInventory.getStackInSlot(1);
        final int lllllllllllllllIllIllIlIlllIllll = lllllllllllllllIllIllIlIllllIIlI + 1;
        if ((lllllllllllllllIllIllIlIllllIIII == null || lllllllllllllllIllIllIlIllllIIII.stackSize < lllllllllllllllIllIllIlIlllIllll) && !lllllllllllllllIllIllIlIlllIlIIl.capabilities.isCreativeMode) {
            return false;
        }
        if (this.enchantLevels[lllllllllllllllIllIllIlIllllIIlI] > 0 && lllllllllllllllIllIllIlIllllIIIl != null && ((lllllllllllllllIllIllIlIlllIlIIl.experienceLevel >= lllllllllllllllIllIllIlIlllIllll && lllllllllllllllIllIllIlIlllIlIIl.experienceLevel >= this.enchantLevels[lllllllllllllllIllIllIlIllllIIlI]) || lllllllllllllllIllIllIlIlllIlIIl.capabilities.isCreativeMode)) {
            if (!this.worldPointer.isRemote) {
                final List lllllllllllllllIllIllIlIlllIlllI = this.func_178148_a(lllllllllllllllIllIllIlIllllIIIl, lllllllllllllllIllIllIlIllllIIlI, this.enchantLevels[lllllllllllllllIllIllIlIllllIIlI]);
                final boolean lllllllllllllllIllIllIlIlllIllIl = lllllllllllllllIllIllIlIllllIIIl.getItem() == Items.book;
                if (lllllllllllllllIllIllIlIlllIlllI != null) {
                    lllllllllllllllIllIllIlIlllIlIIl.func_71013_b(lllllllllllllllIllIllIlIlllIllll);
                    if (lllllllllllllllIllIllIlIlllIllIl) {
                        lllllllllllllllIllIllIlIllllIIIl.setItem(Items.enchanted_book);
                    }
                    for (int lllllllllllllllIllIllIlIlllIllII = 0; lllllllllllllllIllIllIlIlllIllII < lllllllllllllllIllIllIlIlllIlllI.size(); ++lllllllllllllllIllIllIlIlllIllII) {
                        final EnchantmentData lllllllllllllllIllIllIlIlllIlIll = lllllllllllllllIllIllIlIlllIlllI.get(lllllllllllllllIllIllIlIlllIllII);
                        if (lllllllllllllllIllIllIlIlllIllIl) {
                            Items.enchanted_book.addEnchantment(lllllllllllllllIllIllIlIllllIIIl, lllllllllllllllIllIllIlIlllIlIll);
                        }
                        else {
                            lllllllllllllllIllIllIlIllllIIIl.addEnchantment(lllllllllllllllIllIllIlIlllIlIll.enchantmentobj, lllllllllllllllIllIllIlIlllIlIll.enchantmentLevel);
                        }
                    }
                    if (!lllllllllllllllIllIllIlIlllIlIIl.capabilities.isCreativeMode) {
                        final ItemStack itemStack = lllllllllllllllIllIllIlIllllIIII;
                        itemStack.stackSize -= lllllllllllllllIllIllIlIlllIllll;
                        if (lllllllllllllllIllIllIlIllllIIII.stackSize <= 0) {
                            this.tableInventory.setInventorySlotContents(1, null);
                        }
                    }
                    this.tableInventory.markDirty();
                    this.field_178149_f = lllllllllllllllIllIllIlIlllIlIIl.func_175138_ci();
                    this.onCraftMatrixChanged(this.tableInventory);
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllllllIllIllIllIIIIIlII) {
        if (lllllllllllllllIllIllIllIIIIIlII == this.tableInventory) {
            final ItemStack lllllllllllllllIllIllIllIIIIllII = lllllllllllllllIllIllIllIIIIIlII.getStackInSlot(0);
            if (lllllllllllllllIllIllIllIIIIllII != null && lllllllllllllllIllIllIllIIIIllII.isItemEnchantable()) {
                if (!this.worldPointer.isRemote) {
                    int lllllllllllllllIllIllIllIIIIlIll = 0;
                    for (int lllllllllllllllIllIllIllIIIIlIIl = -1; lllllllllllllllIllIllIllIIIIlIIl <= 1; ++lllllllllllllllIllIllIllIIIIlIIl) {
                        for (int lllllllllllllllIllIllIllIIIIlIII = -1; lllllllllllllllIllIllIllIIIIlIII <= 1; ++lllllllllllllllIllIllIllIIIIlIII) {
                            if ((lllllllllllllllIllIllIllIIIIlIIl != 0 || lllllllllllllllIllIllIllIIIIlIII != 0) && this.worldPointer.isAirBlock(this.field_178150_j.add(lllllllllllllllIllIllIllIIIIlIII, 0, lllllllllllllllIllIllIllIIIIlIIl)) && this.worldPointer.isAirBlock(this.field_178150_j.add(lllllllllllllllIllIllIllIIIIlIII, 1, lllllllllllllllIllIllIllIIIIlIIl))) {
                                if (this.worldPointer.getBlockState(this.field_178150_j.add(lllllllllllllllIllIllIllIIIIlIII * 2, 0, lllllllllllllllIllIllIllIIIIlIIl * 2)).getBlock() == Blocks.bookshelf) {
                                    ++lllllllllllllllIllIllIllIIIIlIll;
                                }
                                if (this.worldPointer.getBlockState(this.field_178150_j.add(lllllllllllllllIllIllIllIIIIlIII * 2, 1, lllllllllllllllIllIllIllIIIIlIIl * 2)).getBlock() == Blocks.bookshelf) {
                                    ++lllllllllllllllIllIllIllIIIIlIll;
                                }
                                if (lllllllllllllllIllIllIllIIIIlIII != 0 && lllllllllllllllIllIllIllIIIIlIIl != 0) {
                                    if (this.worldPointer.getBlockState(this.field_178150_j.add(lllllllllllllllIllIllIllIIIIlIII * 2, 0, lllllllllllllllIllIllIllIIIIlIIl)).getBlock() == Blocks.bookshelf) {
                                        ++lllllllllllllllIllIllIllIIIIlIll;
                                    }
                                    if (this.worldPointer.getBlockState(this.field_178150_j.add(lllllllllllllllIllIllIllIIIIlIII * 2, 1, lllllllllllllllIllIllIllIIIIlIIl)).getBlock() == Blocks.bookshelf) {
                                        ++lllllllllllllllIllIllIllIIIIlIll;
                                    }
                                    if (this.worldPointer.getBlockState(this.field_178150_j.add(lllllllllllllllIllIllIllIIIIlIII, 0, lllllllllllllllIllIllIllIIIIlIIl * 2)).getBlock() == Blocks.bookshelf) {
                                        ++lllllllllllllllIllIllIllIIIIlIll;
                                    }
                                    if (this.worldPointer.getBlockState(this.field_178150_j.add(lllllllllllllllIllIllIllIIIIlIII, 1, lllllllllllllllIllIllIllIIIIlIIl * 2)).getBlock() == Blocks.bookshelf) {
                                        ++lllllllllllllllIllIllIllIIIIlIll;
                                    }
                                }
                            }
                        }
                    }
                    this.rand.setSeed(this.field_178149_f);
                    for (int lllllllllllllllIllIllIllIIIIlIIl = 0; lllllllllllllllIllIllIllIIIIlIIl < 3; ++lllllllllllllllIllIllIllIIIIlIIl) {
                        this.enchantLevels[lllllllllllllllIllIllIllIIIIlIIl] = EnchantmentHelper.calcItemStackEnchantability(this.rand, lllllllllllllllIllIllIllIIIIlIIl, lllllllllllllllIllIllIllIIIIlIll, lllllllllllllllIllIllIllIIIIllII);
                        this.field_178151_h[lllllllllllllllIllIllIllIIIIlIIl] = -1;
                        if (this.enchantLevels[lllllllllllllllIllIllIllIIIIlIIl] < lllllllllllllllIllIllIllIIIIlIIl + 1) {
                            this.enchantLevels[lllllllllllllllIllIllIllIIIIlIIl] = 0;
                        }
                    }
                    for (int lllllllllllllllIllIllIllIIIIlIIl = 0; lllllllllllllllIllIllIllIIIIlIIl < 3; ++lllllllllllllllIllIllIllIIIIlIIl) {
                        if (this.enchantLevels[lllllllllllllllIllIllIllIIIIlIIl] > 0) {
                            final List lllllllllllllllIllIllIllIIIIIlll = this.func_178148_a(lllllllllllllllIllIllIllIIIIllII, lllllllllllllllIllIllIllIIIIlIIl, this.enchantLevels[lllllllllllllllIllIllIllIIIIlIIl]);
                            if (lllllllllllllllIllIllIllIIIIIlll != null && !lllllllllllllllIllIllIllIIIIIlll.isEmpty()) {
                                final EnchantmentData lllllllllllllllIllIllIllIIIIIllI = lllllllllllllllIllIllIllIIIIIlll.get(this.rand.nextInt(lllllllllllllllIllIllIllIIIIIlll.size()));
                                this.field_178151_h[lllllllllllllllIllIllIllIIIIlIIl] = (lllllllllllllllIllIllIllIIIIIllI.enchantmentobj.effectId | lllllllllllllllIllIllIllIIIIIllI.enchantmentLevel << 8);
                            }
                        }
                    }
                    this.detectAndSendChanges();
                }
            }
            else {
                for (int lllllllllllllllIllIllIllIIIIlIlI = 0; lllllllllllllllIllIllIllIIIIlIlI < 3; ++lllllllllllllllIllIllIllIIIIlIlI) {
                    this.enchantLevels[lllllllllllllllIllIllIllIIIIlIlI] = 0;
                    this.field_178151_h[lllllllllllllllIllIllIllIIIIlIlI] = -1;
                }
            }
        }
    }
    
    @Override
    public void updateProgressBar(final int lllllllllllllllIllIllIllIIIllIlI, final int lllllllllllllllIllIllIllIIIllIIl) {
        if (lllllllllllllllIllIllIllIIIllIlI >= 0 && lllllllllllllllIllIllIllIIIllIlI <= 2) {
            this.enchantLevels[lllllllllllllllIllIllIllIIIllIlI] = lllllllllllllllIllIllIllIIIllIIl;
        }
        else if (lllllllllllllllIllIllIllIIIllIlI == 3) {
            this.field_178149_f = lllllllllllllllIllIllIllIIIllIIl;
        }
        else if (lllllllllllllllIllIllIllIIIllIlI >= 4 && lllllllllllllllIllIllIllIIIllIlI <= 6) {
            this.field_178151_h[lllllllllllllllIllIllIllIIIllIlI - 4] = lllllllllllllllIllIllIllIIIllIIl;
        }
        else {
            super.updateProgressBar(lllllllllllllllIllIllIllIIIllIlI, lllllllllllllllIllIllIllIIIllIIl);
        }
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllllIllIllIlIllIIIIlI) {
        super.onContainerClosed(lllllllllllllllIllIllIlIllIIIIlI);
        if (!this.worldPointer.isRemote) {
            for (int lllllllllllllllIllIllIlIllIIIlIl = 0; lllllllllllllllIllIllIlIllIIIlIl < this.tableInventory.getSizeInventory(); ++lllllllllllllllIllIllIlIllIIIlIl) {
                final ItemStack lllllllllllllllIllIllIlIllIIIlII = this.tableInventory.getStackInSlotOnClosing(lllllllllllllllIllIllIlIllIIIlIl);
                if (lllllllllllllllIllIllIlIllIIIlII != null) {
                    lllllllllllllllIllIllIlIllIIIIlI.dropPlayerItemWithRandomChoice(lllllllllllllllIllIllIlIllIIIlII, false);
                }
            }
        }
    }
    
    public int func_178147_e() {
        final ItemStack lllllllllllllllIllIllIlIllIIlllI = this.tableInventory.getStackInSlot(1);
        return (lllllllllllllllIllIllIlIllIIlllI == null) ? 0 : lllllllllllllllIllIllIlIllIIlllI.stackSize;
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllllIllIllIlIlIlIllII, final int lllllllllllllllIllIllIlIlIllIIIl) {
        ItemStack lllllllllllllllIllIllIlIlIllIIII = null;
        final Slot lllllllllllllllIllIllIlIlIlIllll = this.inventorySlots.get(lllllllllllllllIllIllIlIlIllIIIl);
        if (lllllllllllllllIllIllIlIlIlIllll != null && lllllllllllllllIllIllIlIlIlIllll.getHasStack()) {
            final ItemStack lllllllllllllllIllIllIlIlIlIlllI = lllllllllllllllIllIllIlIlIlIllll.getStack();
            lllllllllllllllIllIllIlIlIllIIII = lllllllllllllllIllIllIlIlIlIlllI.copy();
            if (lllllllllllllllIllIllIlIlIllIIIl == 0) {
                if (!this.mergeItemStack(lllllllllllllllIllIllIlIlIlIlllI, 2, 38, true)) {
                    return null;
                }
            }
            else if (lllllllllllllllIllIllIlIlIllIIIl == 1) {
                if (!this.mergeItemStack(lllllllllllllllIllIllIlIlIlIlllI, 2, 38, true)) {
                    return null;
                }
            }
            else if (lllllllllllllllIllIllIlIlIlIlllI.getItem() == Items.dye && EnumDyeColor.func_176766_a(lllllllllllllllIllIllIlIlIlIlllI.getMetadata()) == EnumDyeColor.BLUE) {
                if (!this.mergeItemStack(lllllllllllllllIllIllIlIlIlIlllI, 1, 2, true)) {
                    return null;
                }
            }
            else {
                if (this.inventorySlots.get(0).getHasStack() || !this.inventorySlots.get(0).isItemValid(lllllllllllllllIllIllIlIlIlIlllI)) {
                    return null;
                }
                if (lllllllllllllllIllIllIlIlIlIlllI.hasTagCompound() && lllllllllllllllIllIllIlIlIlIlllI.stackSize == 1) {
                    this.inventorySlots.get(0).putStack(lllllllllllllllIllIllIlIlIlIlllI.copy());
                    lllllllllllllllIllIllIlIlIlIlllI.stackSize = 0;
                }
                else if (lllllllllllllllIllIllIlIlIlIlllI.stackSize >= 1) {
                    this.inventorySlots.get(0).putStack(new ItemStack(lllllllllllllllIllIllIlIlIlIlllI.getItem(), 1, lllllllllllllllIllIllIlIlIlIlllI.getMetadata()));
                    final ItemStack itemStack = lllllllllllllllIllIllIlIlIlIlllI;
                    --itemStack.stackSize;
                }
            }
            if (lllllllllllllllIllIllIlIlIlIlllI.stackSize == 0) {
                lllllllllllllllIllIllIlIlIlIllll.putStack(null);
            }
            else {
                lllllllllllllllIllIllIlIlIlIllll.onSlotChanged();
            }
            if (lllllllllllllllIllIllIlIlIlIlllI.stackSize == lllllllllllllllIllIllIlIlIllIIII.stackSize) {
                return null;
            }
            lllllllllllllllIllIllIlIlIlIllll.onPickupFromSlot(lllllllllllllllIllIllIlIlIlIllII, lllllllllllllllIllIllIlIlIlIlllI);
        }
        return lllllllllllllllIllIllIlIlIllIIII;
    }
    
    static {
        __OBFID = "CL_00001745";
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int lllllllllllllllIllIllIllIIlIIIll = 0; lllllllllllllllIllIllIllIIlIIIll < this.crafters.size(); ++lllllllllllllllIllIllIllIIlIIIll) {
            final ICrafting lllllllllllllllIllIllIllIIlIIIlI = this.crafters.get(lllllllllllllllIllIllIllIIlIIIll);
            lllllllllllllllIllIllIllIIlIIIlI.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
            lllllllllllllllIllIllIllIIlIIIlI.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
            lllllllllllllllIllIllIllIIlIIIlI.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
            lllllllllllllllIllIllIllIIlIIIlI.sendProgressBarUpdate(this, 3, this.field_178149_f & 0xFFFFFFF0);
            lllllllllllllllIllIllIllIIlIIIlI.sendProgressBarUpdate(this, 4, this.field_178151_h[0]);
            lllllllllllllllIllIllIllIIlIIIlI.sendProgressBarUpdate(this, 5, this.field_178151_h[1]);
            lllllllllllllllIllIllIllIIlIIIlI.sendProgressBarUpdate(this, 6, this.field_178151_h[2]);
        }
    }
    
    @Override
    public void onCraftGuiOpened(final ICrafting lllllllllllllllIllIllIllIIlIlIlI) {
        super.onCraftGuiOpened(lllllllllllllllIllIllIllIIlIlIlI);
        lllllllllllllllIllIllIllIIlIlIlI.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
        lllllllllllllllIllIllIllIIlIlIlI.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
        lllllllllllllllIllIllIllIIlIlIlI.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
        lllllllllllllllIllIllIllIIlIlIlI.sendProgressBarUpdate(this, 3, this.field_178149_f & 0xFFFFFFF0);
        lllllllllllllllIllIllIllIIlIlIlI.sendProgressBarUpdate(this, 4, this.field_178151_h[0]);
        lllllllllllllllIllIllIllIIlIlIlI.sendProgressBarUpdate(this, 5, this.field_178151_h[1]);
        lllllllllllllllIllIllIllIIlIlIlI.sendProgressBarUpdate(this, 6, this.field_178151_h[2]);
    }
    
    public ContainerEnchantment(final InventoryPlayer lllllllllllllllIllIllIllIIlllIII, final World lllllllllllllllIllIllIllIIllIlll, final BlockPos lllllllllllllllIllIllIllIIllIIII) {
        this.tableInventory = new InventoryBasic("Enchant", true, 2) {
            @Override
            public int getInventoryStackLimit() {
                return 64;
            }
            
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerEnchantment.this.onCraftMatrixChanged(this);
            }
            
            static {
                __OBFID = "CL_00001746";
            }
        };
        this.rand = new Random();
        this.enchantLevels = new int[3];
        this.field_178151_h = new int[] { -1, -1, -1 };
        this.worldPointer = lllllllllllllllIllIllIllIIllIlll;
        this.field_178150_j = lllllllllllllllIllIllIllIIllIIII;
        this.field_178149_f = lllllllllllllllIllIllIllIIlllIII.player.func_175138_ci();
        this.addSlotToContainer(new Slot(this.tableInventory, 0, 15, 47) {
            static {
                __OBFID = "CL_00001747";
            }
            
            @Override
            public int getSlotStackLimit() {
                return 1;
            }
            
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllIlllllllIIllIIIlllI) {
                return true;
            }
        });
        this.addSlotToContainer(new Slot(this.tableInventory, 1, 35, 47) {
            @Override
            public boolean isItemValid(final ItemStack llllllIlIlIIlII) {
                return llllllIlIlIIlII.getItem() == Items.dye && EnumDyeColor.func_176766_a(llllllIlIlIIlII.getMetadata()) == EnumDyeColor.BLUE;
            }
            
            static {
                __OBFID = "CL_00002185";
            }
        });
        for (int lllllllllllllllIllIllIllIIllIlIl = 0; lllllllllllllllIllIllIllIIllIlIl < 3; ++lllllllllllllllIllIllIllIIllIlIl) {
            for (int lllllllllllllllIllIllIllIIllIlII = 0; lllllllllllllllIllIllIllIIllIlII < 9; ++lllllllllllllllIllIllIllIIllIlII) {
                this.addSlotToContainer(new Slot(lllllllllllllllIllIllIllIIlllIII, lllllllllllllllIllIllIllIIllIlII + lllllllllllllllIllIllIllIIllIlIl * 9 + 9, 8 + lllllllllllllllIllIllIllIIllIlII * 18, 84 + lllllllllllllllIllIllIllIIllIlIl * 18));
            }
        }
        for (int lllllllllllllllIllIllIllIIllIlIl = 0; lllllllllllllllIllIllIllIIllIlIl < 9; ++lllllllllllllllIllIllIllIIllIlIl) {
            this.addSlotToContainer(new Slot(lllllllllllllllIllIllIllIIlllIII, lllllllllllllllIllIllIllIIllIlIl, 8 + lllllllllllllllIllIllIllIIllIlIl * 18, 142));
        }
    }
    
    private List func_178148_a(final ItemStack lllllllllllllllIllIllIlIllIllIlI, final int lllllllllllllllIllIllIlIllIlIlII, final int lllllllllllllllIllIllIlIllIllIII) {
        this.rand.setSeed(this.field_178149_f + lllllllllllllllIllIllIlIllIlIlII);
        final List lllllllllllllllIllIllIlIllIlIlll = EnchantmentHelper.buildEnchantmentList(this.rand, lllllllllllllllIllIllIlIllIllIlI, lllllllllllllllIllIllIlIllIllIII);
        if (lllllllllllllllIllIllIlIllIllIlI.getItem() == Items.book && lllllllllllllllIllIllIlIllIlIlll != null && lllllllllllllllIllIllIlIllIlIlll.size() > 1) {
            lllllllllllllllIllIllIlIllIlIlll.remove(this.rand.nextInt(lllllllllllllllIllIllIlIllIlIlll.size()));
        }
        return lllllllllllllllIllIllIlIllIlIlll;
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllllIllIllIlIlIllllII) {
        return this.worldPointer.getBlockState(this.field_178150_j).getBlock() == Blocks.enchanting_table && lllllllllllllllIllIllIlIlIllllII.getDistanceSq(this.field_178150_j.getX() + 0.5, this.field_178150_j.getY() + 0.5, this.field_178150_j.getZ() + 0.5) <= 64.0;
    }
    
    public ContainerEnchantment(final InventoryPlayer lllllllllllllllIllIllIllIlIIIlII, final World lllllllllllllllIllIllIllIlIIIIII) {
        this(lllllllllllllllIllIllIllIlIIIlII, lllllllllllllllIllIllIllIlIIIIII, BlockPos.ORIGIN);
    }
}
