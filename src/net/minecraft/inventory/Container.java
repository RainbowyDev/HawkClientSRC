package net.minecraft.inventory;

import net.minecraft.tileentity.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import java.util.*;

public abstract class Container
{
    private final /* synthetic */ Set dragSlots;
    public /* synthetic */ List inventoryItemStacks;
    private /* synthetic */ int dragEvent;
    private /* synthetic */ short transactionID;
    public /* synthetic */ List inventorySlots;
    protected /* synthetic */ List crafters;
    private /* synthetic */ int dragMode;
    private /* synthetic */ Set playerList;
    
    public void removeCraftingFromCrafters(final ICrafting llllllllllllllllIIIIlIIllllllIll) {
        this.crafters.remove(llllllllllllllllIIIIlIIllllllIll);
    }
    
    public static int calcRedstoneFromInventory(final TileEntity llllllllllllllllIIIIlIIIllIIlllI) {
        return (llllllllllllllllIIIIlIIIllIIlllI instanceof IInventory) ? calcRedstoneFromInventory((IInventory)llllllllllllllllIIIIlIIIllIIlllI) : 0;
    }
    
    public static boolean func_180610_a(final int llllllllllllllllIIIIlIIIllllIlII, final EntityPlayer llllllllllllllllIIIIlIIIllllIIll) {
        return llllllllllllllllIIIIlIIIllllIlII == 0 || llllllllllllllllIIIIlIIIllllIlII == 1 || (llllllllllllllllIIIIlIIIllllIlII == 2 && llllllllllllllllIIIIlIIIllllIIll.capabilities.isCreativeMode);
    }
    
    public Container() {
        this.inventoryItemStacks = Lists.newArrayList();
        this.inventorySlots = Lists.newArrayList();
        this.dragMode = -1;
        this.dragSlots = Sets.newHashSet();
        this.crafters = Lists.newArrayList();
        this.playerList = Sets.newHashSet();
    }
    
    public boolean canDragIntoSlot(final Slot llllllllllllllllIIIIlIIIllIlIIIl) {
        return true;
    }
    
    public ItemStack slotClick(final int llllllllllllllllIIIIlIIllIlIIIIl, final int llllllllllllllllIIIIlIIllIlIIIII, final int llllllllllllllllIIIIlIIllIIlllll, final EntityPlayer llllllllllllllllIIIIlIIllIIllllI) {
        ItemStack llllllllllllllllIIIIlIIllIIlllIl = null;
        final InventoryPlayer llllllllllllllllIIIIlIIllIIlllII = llllllllllllllllIIIIlIIllIIllllI.inventory;
        if (llllllllllllllllIIIIlIIllIIlllll == 5) {
            final int llllllllllllllllIIIIlIIllIIlIIlI = this.dragEvent;
            this.dragEvent = getDragEvent(llllllllllllllllIIIIlIIllIlIIIII);
            if ((llllllllllllllllIIIIlIIllIIlIIlI != 1 || this.dragEvent != 2) && llllllllllllllllIIIIlIIllIIlIIlI != this.dragEvent) {
                this.resetDrag();
            }
            else if (llllllllllllllllIIIIlIIllIIlllII.getItemStack() == null) {
                this.resetDrag();
            }
            else if (this.dragEvent == 0) {
                this.dragMode = extractDragMode(llllllllllllllllIIIIlIIllIlIIIII);
                if (func_180610_a(this.dragMode, llllllllllllllllIIIIlIIllIIllllI)) {
                    this.dragEvent = 1;
                    this.dragSlots.clear();
                }
                else {
                    this.resetDrag();
                }
            }
            else if (this.dragEvent == 1) {
                final Slot llllllllllllllllIIIIlIIllIIlIIIl = this.inventorySlots.get(llllllllllllllllIIIIlIIllIlIIIIl);
                if (llllllllllllllllIIIIlIIllIIlIIIl != null && canAddItemToSlot(llllllllllllllllIIIIlIIllIIlIIIl, llllllllllllllllIIIIlIIllIIlllII.getItemStack(), true) && llllllllllllllllIIIIlIIllIIlIIIl.isItemValid(llllllllllllllllIIIIlIIllIIlllII.getItemStack()) && llllllllllllllllIIIIlIIllIIlllII.getItemStack().stackSize > this.dragSlots.size() && this.canDragIntoSlot(llllllllllllllllIIIIlIIllIIlIIIl)) {
                    this.dragSlots.add(llllllllllllllllIIIIlIIllIIlIIIl);
                }
            }
            else if (this.dragEvent == 2) {
                if (!this.dragSlots.isEmpty()) {
                    ItemStack llllllllllllllllIIIIlIIllIIllIIl = llllllllllllllllIIIIlIIllIIlllII.getItemStack().copy();
                    int llllllllllllllllIIIIlIIllIIllIll = llllllllllllllllIIIIlIIllIIlllII.getItemStack().stackSize;
                    for (final Slot llllllllllllllllIIIIlIIllIIIllll : this.dragSlots) {
                        if (llllllllllllllllIIIIlIIllIIIllll != null && canAddItemToSlot(llllllllllllllllIIIIlIIllIIIllll, llllllllllllllllIIIIlIIllIIlllII.getItemStack(), true) && llllllllllllllllIIIIlIIllIIIllll.isItemValid(llllllllllllllllIIIIlIIllIIlllII.getItemStack()) && llllllllllllllllIIIIlIIllIIlllII.getItemStack().stackSize >= this.dragSlots.size() && this.canDragIntoSlot(llllllllllllllllIIIIlIIllIIIllll)) {
                            final ItemStack llllllllllllllllIIIIlIIllIIIlllI = llllllllllllllllIIIIlIIllIIllIIl.copy();
                            final int llllllllllllllllIIIIlIIllIIIllIl = llllllllllllllllIIIIlIIllIIIllll.getHasStack() ? llllllllllllllllIIIIlIIllIIIllll.getStack().stackSize : 0;
                            computeStackSize(this.dragSlots, this.dragMode, llllllllllllllllIIIIlIIllIIIlllI, llllllllllllllllIIIIlIIllIIIllIl);
                            if (llllllllllllllllIIIIlIIllIIIlllI.stackSize > llllllllllllllllIIIIlIIllIIIlllI.getMaxStackSize()) {
                                llllllllllllllllIIIIlIIllIIIlllI.stackSize = llllllllllllllllIIIIlIIllIIIlllI.getMaxStackSize();
                            }
                            if (llllllllllllllllIIIIlIIllIIIlllI.stackSize > llllllllllllllllIIIIlIIllIIIllll.func_178170_b(llllllllllllllllIIIIlIIllIIIlllI)) {
                                llllllllllllllllIIIIlIIllIIIlllI.stackSize = llllllllllllllllIIIIlIIllIIIllll.func_178170_b(llllllllllllllllIIIIlIIllIIIlllI);
                            }
                            llllllllllllllllIIIIlIIllIIllIll -= llllllllllllllllIIIIlIIllIIIlllI.stackSize - llllllllllllllllIIIIlIIllIIIllIl;
                            llllllllllllllllIIIIlIIllIIIllll.putStack(llllllllllllllllIIIIlIIllIIIlllI);
                        }
                    }
                    llllllllllllllllIIIIlIIllIIllIIl.stackSize = llllllllllllllllIIIIlIIllIIllIll;
                    if (llllllllllllllllIIIIlIIllIIllIIl.stackSize <= 0) {
                        llllllllllllllllIIIIlIIllIIllIIl = null;
                    }
                    llllllllllllllllIIIIlIIllIIlllII.setItemStack(llllllllllllllllIIIIlIIllIIllIIl);
                }
                this.resetDrag();
            }
            else {
                this.resetDrag();
            }
        }
        else if (this.dragEvent != 0) {
            this.resetDrag();
        }
        else if ((llllllllllllllllIIIIlIIllIIlllll == 0 || llllllllllllllllIIIIlIIllIIlllll == 1) && (llllllllllllllllIIIIlIIllIlIIIII == 0 || llllllllllllllllIIIIlIIllIlIIIII == 1)) {
            if (llllllllllllllllIIIIlIIllIlIIIIl == -999) {
                if (llllllllllllllllIIIIlIIllIIlllII.getItemStack() != null) {
                    if (llllllllllllllllIIIIlIIllIlIIIII == 0) {
                        llllllllllllllllIIIIlIIllIIllllI.dropPlayerItemWithRandomChoice(llllllllllllllllIIIIlIIllIIlllII.getItemStack(), true);
                        llllllllllllllllIIIIlIIllIIlllII.setItemStack(null);
                    }
                    if (llllllllllllllllIIIIlIIllIlIIIII == 1) {
                        llllllllllllllllIIIIlIIllIIllllI.dropPlayerItemWithRandomChoice(llllllllllllllllIIIIlIIllIIlllII.getItemStack().splitStack(1), true);
                        if (llllllllllllllllIIIIlIIllIIlllII.getItemStack().stackSize == 0) {
                            llllllllllllllllIIIIlIIllIIlllII.setItemStack(null);
                        }
                    }
                }
            }
            else if (llllllllllllllllIIIIlIIllIIlllll == 1) {
                if (llllllllllllllllIIIIlIIllIlIIIIl < 0) {
                    return null;
                }
                final Slot llllllllllllllllIIIIlIIllIIIllII = this.inventorySlots.get(llllllllllllllllIIIIlIIllIlIIIIl);
                if (llllllllllllllllIIIIlIIllIIIllII != null && llllllllllllllllIIIIlIIllIIIllII.canTakeStack(llllllllllllllllIIIIlIIllIIllllI)) {
                    final ItemStack llllllllllllllllIIIIlIIllIIllIII = this.transferStackInSlot(llllllllllllllllIIIIlIIllIIllllI, llllllllllllllllIIIIlIIllIlIIIIl);
                    if (llllllllllllllllIIIIlIIllIIllIII != null) {
                        final Item llllllllllllllllIIIIlIIlIllllllI = llllllllllllllllIIIIlIIllIIllIII.getItem();
                        llllllllllllllllIIIIlIIllIIlllIl = llllllllllllllllIIIIlIIllIIllIII.copy();
                        if (llllllllllllllllIIIIlIIllIIIllII.getStack() != null && llllllllllllllllIIIIlIIllIIIllII.getStack().getItem() == llllllllllllllllIIIIlIIlIllllllI) {
                            this.retrySlotClick(llllllllllllllllIIIIlIIllIlIIIIl, llllllllllllllllIIIIlIIllIlIIIII, true, llllllllllllllllIIIIlIIllIIllllI);
                        }
                    }
                }
            }
            else {
                if (llllllllllllllllIIIIlIIllIlIIIIl < 0) {
                    return null;
                }
                final Slot llllllllllllllllIIIIlIIllIIIlIll = this.inventorySlots.get(llllllllllllllllIIIIlIIllIlIIIIl);
                if (llllllllllllllllIIIIlIIllIIIlIll != null) {
                    ItemStack llllllllllllllllIIIIlIIllIIlIlll = llllllllllllllllIIIIlIIllIIIlIll.getStack();
                    final ItemStack llllllllllllllllIIIIlIIlIlllllIl = llllllllllllllllIIIIlIIllIIlllII.getItemStack();
                    if (llllllllllllllllIIIIlIIllIIlIlll != null) {
                        llllllllllllllllIIIIlIIllIIlllIl = llllllllllllllllIIIIlIIllIIlIlll.copy();
                    }
                    if (llllllllllllllllIIIIlIIllIIlIlll == null) {
                        if (llllllllllllllllIIIIlIIlIlllllIl != null && llllllllllllllllIIIIlIIllIIIlIll.isItemValid(llllllllllllllllIIIIlIIlIlllllIl)) {
                            int llllllllllllllllIIIIlIIllIIIIllI = (llllllllllllllllIIIIlIIllIlIIIII == 0) ? llllllllllllllllIIIIlIIlIlllllIl.stackSize : 1;
                            if (llllllllllllllllIIIIlIIllIIIIllI > llllllllllllllllIIIIlIIllIIIlIll.func_178170_b(llllllllllllllllIIIIlIIlIlllllIl)) {
                                llllllllllllllllIIIIlIIllIIIIllI = llllllllllllllllIIIIlIIllIIIlIll.func_178170_b(llllllllllllllllIIIIlIIlIlllllIl);
                            }
                            if (llllllllllllllllIIIIlIIlIlllllIl.stackSize >= llllllllllllllllIIIIlIIllIIIIllI) {
                                llllllllllllllllIIIIlIIllIIIlIll.putStack(llllllllllllllllIIIIlIIlIlllllIl.splitStack(llllllllllllllllIIIIlIIllIIIIllI));
                            }
                            if (llllllllllllllllIIIIlIIlIlllllIl.stackSize == 0) {
                                llllllllllllllllIIIIlIIllIIlllII.setItemStack(null);
                            }
                        }
                    }
                    else if (llllllllllllllllIIIIlIIllIIIlIll.canTakeStack(llllllllllllllllIIIIlIIllIIllllI)) {
                        if (llllllllllllllllIIIIlIIlIlllllIl == null) {
                            final int llllllllllllllllIIIIlIIllIIIIlIl = (llllllllllllllllIIIIlIIllIlIIIII == 0) ? llllllllllllllllIIIIlIIllIIlIlll.stackSize : ((llllllllllllllllIIIIlIIllIIlIlll.stackSize + 1) / 2);
                            final ItemStack llllllllllllllllIIIIlIIllIIIIIII = llllllllllllllllIIIIlIIllIIIlIll.decrStackSize(llllllllllllllllIIIIlIIllIIIIlIl);
                            llllllllllllllllIIIIlIIllIIlllII.setItemStack(llllllllllllllllIIIIlIIllIIIIIII);
                            if (llllllllllllllllIIIIlIIllIIlIlll.stackSize == 0) {
                                llllllllllllllllIIIIlIIllIIIlIll.putStack(null);
                            }
                            llllllllllllllllIIIIlIIllIIIlIll.onPickupFromSlot(llllllllllllllllIIIIlIIllIIllllI, llllllllllllllllIIIIlIIllIIlllII.getItemStack());
                        }
                        else if (llllllllllllllllIIIIlIIllIIIlIll.isItemValid(llllllllllllllllIIIIlIIlIlllllIl)) {
                            if (llllllllllllllllIIIIlIIllIIlIlll.getItem() == llllllllllllllllIIIIlIIlIlllllIl.getItem() && llllllllllllllllIIIIlIIllIIlIlll.getMetadata() == llllllllllllllllIIIIlIIlIlllllIl.getMetadata() && ItemStack.areItemStackTagsEqual(llllllllllllllllIIIIlIIllIIlIlll, llllllllllllllllIIIIlIIlIlllllIl)) {
                                int llllllllllllllllIIIIlIIllIIIIlII = (llllllllllllllllIIIIlIIllIlIIIII == 0) ? llllllllllllllllIIIIlIIlIlllllIl.stackSize : 1;
                                if (llllllllllllllllIIIIlIIllIIIIlII > llllllllllllllllIIIIlIIllIIIlIll.func_178170_b(llllllllllllllllIIIIlIIlIlllllIl) - llllllllllllllllIIIIlIIllIIlIlll.stackSize) {
                                    llllllllllllllllIIIIlIIllIIIIlII = llllllllllllllllIIIIlIIllIIIlIll.func_178170_b(llllllllllllllllIIIIlIIlIlllllIl) - llllllllllllllllIIIIlIIllIIlIlll.stackSize;
                                }
                                if (llllllllllllllllIIIIlIIllIIIIlII > llllllllllllllllIIIIlIIlIlllllIl.getMaxStackSize() - llllllllllllllllIIIIlIIllIIlIlll.stackSize) {
                                    llllllllllllllllIIIIlIIllIIIIlII = llllllllllllllllIIIIlIIlIlllllIl.getMaxStackSize() - llllllllllllllllIIIIlIIllIIlIlll.stackSize;
                                }
                                llllllllllllllllIIIIlIIlIlllllIl.splitStack(llllllllllllllllIIIIlIIllIIIIlII);
                                if (llllllllllllllllIIIIlIIlIlllllIl.stackSize == 0) {
                                    llllllllllllllllIIIIlIIllIIlllII.setItemStack(null);
                                }
                                final ItemStack itemStack = llllllllllllllllIIIIlIIllIIlIlll;
                                itemStack.stackSize += llllllllllllllllIIIIlIIllIIIIlII;
                            }
                            else if (llllllllllllllllIIIIlIIlIlllllIl.stackSize <= llllllllllllllllIIIIlIIllIIIlIll.func_178170_b(llllllllllllllllIIIIlIIlIlllllIl)) {
                                llllllllllllllllIIIIlIIllIIIlIll.putStack(llllllllllllllllIIIIlIIlIlllllIl);
                                llllllllllllllllIIIIlIIllIIlllII.setItemStack(llllllllllllllllIIIIlIIllIIlIlll);
                            }
                        }
                        else if (llllllllllllllllIIIIlIIllIIlIlll.getItem() == llllllllllllllllIIIIlIIlIlllllIl.getItem() && llllllllllllllllIIIIlIIlIlllllIl.getMaxStackSize() > 1 && (!llllllllllllllllIIIIlIIllIIlIlll.getHasSubtypes() || llllllllllllllllIIIIlIIllIIlIlll.getMetadata() == llllllllllllllllIIIIlIIlIlllllIl.getMetadata()) && ItemStack.areItemStackTagsEqual(llllllllllllllllIIIIlIIllIIlIlll, llllllllllllllllIIIIlIIlIlllllIl)) {
                            final int llllllllllllllllIIIIlIIllIIIIIll = llllllllllllllllIIIIlIIllIIlIlll.stackSize;
                            if (llllllllllllllllIIIIlIIllIIIIIll > 0 && llllllllllllllllIIIIlIIllIIIIIll + llllllllllllllllIIIIlIIlIlllllIl.stackSize <= llllllllllllllllIIIIlIIlIlllllIl.getMaxStackSize()) {
                                final ItemStack itemStack2 = llllllllllllllllIIIIlIIlIlllllIl;
                                itemStack2.stackSize += llllllllllllllllIIIIlIIllIIIIIll;
                                llllllllllllllllIIIIlIIllIIlIlll = llllllllllllllllIIIIlIIllIIIlIll.decrStackSize(llllllllllllllllIIIIlIIllIIIIIll);
                                if (llllllllllllllllIIIIlIIllIIlIlll.stackSize == 0) {
                                    llllllllllllllllIIIIlIIllIIIlIll.putStack(null);
                                }
                                llllllllllllllllIIIIlIIllIIIlIll.onPickupFromSlot(llllllllllllllllIIIIlIIllIIllllI, llllllllllllllllIIIIlIIllIIlllII.getItemStack());
                            }
                        }
                    }
                    llllllllllllllllIIIIlIIllIIIlIll.onSlotChanged();
                }
            }
        }
        else if (llllllllllllllllIIIIlIIllIIlllll == 2 && llllllllllllllllIIIIlIIllIlIIIII >= 0 && llllllllllllllllIIIIlIIllIlIIIII < 9) {
            final Slot llllllllllllllllIIIIlIIllIIIlIlI = this.inventorySlots.get(llllllllllllllllIIIIlIIllIlIIIIl);
            if (llllllllllllllllIIIIlIIllIIIlIlI.canTakeStack(llllllllllllllllIIIIlIIllIIllllI)) {
                final ItemStack llllllllllllllllIIIIlIIllIIlIllI = llllllllllllllllIIIIlIIllIIlllII.getStackInSlot(llllllllllllllllIIIIlIIllIlIIIII);
                boolean llllllllllllllllIIIIlIIlIlllllII = llllllllllllllllIIIIlIIllIIlIllI == null || (llllllllllllllllIIIIlIIllIIIlIlI.inventory == llllllllllllllllIIIIlIIllIIlllII && llllllllllllllllIIIIlIIllIIIlIlI.isItemValid(llllllllllllllllIIIIlIIllIIlIllI));
                int llllllllllllllllIIIIlIIllIIIIIlI = -1;
                if (!llllllllllllllllIIIIlIIlIlllllII) {
                    llllllllllllllllIIIIlIIllIIIIIlI = llllllllllllllllIIIIlIIllIIlllII.getFirstEmptyStack();
                    llllllllllllllllIIIIlIIlIlllllII |= (llllllllllllllllIIIIlIIllIIIIIlI > -1);
                }
                if (llllllllllllllllIIIIlIIllIIIlIlI.getHasStack() && llllllllllllllllIIIIlIIlIlllllII) {
                    final ItemStack llllllllllllllllIIIIlIIlIlllllll = llllllllllllllllIIIIlIIllIIIlIlI.getStack();
                    llllllllllllllllIIIIlIIllIIlllII.setInventorySlotContents(llllllllllllllllIIIIlIIllIlIIIII, llllllllllllllllIIIIlIIlIlllllll.copy());
                    if ((llllllllllllllllIIIIlIIllIIIlIlI.inventory != llllllllllllllllIIIIlIIllIIlllII || !llllllllllllllllIIIIlIIllIIIlIlI.isItemValid(llllllllllllllllIIIIlIIllIIlIllI)) && llllllllllllllllIIIIlIIllIIlIllI != null) {
                        if (llllllllllllllllIIIIlIIllIIIIIlI > -1) {
                            llllllllllllllllIIIIlIIllIIlllII.addItemStackToInventory(llllllllllllllllIIIIlIIllIIlIllI);
                            llllllllllllllllIIIIlIIllIIIlIlI.decrStackSize(llllllllllllllllIIIIlIIlIlllllll.stackSize);
                            llllllllllllllllIIIIlIIllIIIlIlI.putStack(null);
                            llllllllllllllllIIIIlIIllIIIlIlI.onPickupFromSlot(llllllllllllllllIIIIlIIllIIllllI, llllllllllllllllIIIIlIIlIlllllll);
                        }
                    }
                    else {
                        llllllllllllllllIIIIlIIllIIIlIlI.decrStackSize(llllllllllllllllIIIIlIIlIlllllll.stackSize);
                        llllllllllllllllIIIIlIIllIIIlIlI.putStack(llllllllllllllllIIIIlIIllIIlIllI);
                        llllllllllllllllIIIIlIIllIIIlIlI.onPickupFromSlot(llllllllllllllllIIIIlIIllIIllllI, llllllllllllllllIIIIlIIlIlllllll);
                    }
                }
                else if (!llllllllllllllllIIIIlIIllIIIlIlI.getHasStack() && llllllllllllllllIIIIlIIllIIlIllI != null && llllllllllllllllIIIIlIIllIIIlIlI.isItemValid(llllllllllllllllIIIIlIIllIIlIllI)) {
                    llllllllllllllllIIIIlIIllIIlllII.setInventorySlotContents(llllllllllllllllIIIIlIIllIlIIIII, null);
                    llllllllllllllllIIIIlIIllIIIlIlI.putStack(llllllllllllllllIIIIlIIllIIlIllI);
                }
            }
        }
        else if (llllllllllllllllIIIIlIIllIIlllll == 3 && llllllllllllllllIIIIlIIllIIllllI.capabilities.isCreativeMode && llllllllllllllllIIIIlIIllIIlllII.getItemStack() == null && llllllllllllllllIIIIlIIllIlIIIIl >= 0) {
            final Slot llllllllllllllllIIIIlIIllIIIlIIl = this.inventorySlots.get(llllllllllllllllIIIIlIIllIlIIIIl);
            if (llllllllllllllllIIIIlIIllIIIlIIl != null && llllllllllllllllIIIIlIIllIIIlIIl.getHasStack()) {
                final ItemStack llllllllllllllllIIIIlIIllIIlIlIl = llllllllllllllllIIIIlIIllIIIlIIl.getStack().copy();
                llllllllllllllllIIIIlIIllIIlIlIl.stackSize = llllllllllllllllIIIIlIIllIIlIlIl.getMaxStackSize();
                llllllllllllllllIIIIlIIllIIlllII.setItemStack(llllllllllllllllIIIIlIIllIIlIlIl);
            }
        }
        else if (llllllllllllllllIIIIlIIllIIlllll == 4 && llllllllllllllllIIIIlIIllIIlllII.getItemStack() == null && llllllllllllllllIIIIlIIllIlIIIIl >= 0) {
            final Slot llllllllllllllllIIIIlIIllIIIlIII = this.inventorySlots.get(llllllllllllllllIIIIlIIllIlIIIIl);
            if (llllllllllllllllIIIIlIIllIIIlIII != null && llllllllllllllllIIIIlIIllIIIlIII.getHasStack() && llllllllllllllllIIIIlIIllIIIlIII.canTakeStack(llllllllllllllllIIIIlIIllIIllllI)) {
                final ItemStack llllllllllllllllIIIIlIIllIIlIlII = llllllllllllllllIIIIlIIllIIIlIII.decrStackSize((llllllllllllllllIIIIlIIllIlIIIII == 0) ? 1 : llllllllllllllllIIIIlIIllIIIlIII.getStack().stackSize);
                llllllllllllllllIIIIlIIllIIIlIII.onPickupFromSlot(llllllllllllllllIIIIlIIllIIllllI, llllllllllllllllIIIIlIIllIIlIlII);
                llllllllllllllllIIIIlIIllIIllllI.dropPlayerItemWithRandomChoice(llllllllllllllllIIIIlIIllIIlIlII, true);
            }
        }
        else if (llllllllllllllllIIIIlIIllIIlllll == 6 && llllllllllllllllIIIIlIIllIlIIIIl >= 0) {
            final Slot llllllllllllllllIIIIlIIllIIIIlll = this.inventorySlots.get(llllllllllllllllIIIIlIIllIlIIIIl);
            final ItemStack llllllllllllllllIIIIlIIllIIlIIll = llllllllllllllllIIIIlIIllIIlllII.getItemStack();
            if (llllllllllllllllIIIIlIIllIIlIIll != null && (llllllllllllllllIIIIlIIllIIIIlll == null || !llllllllllllllllIIIIlIIllIIIIlll.getHasStack() || !llllllllllllllllIIIIlIIllIIIIlll.canTakeStack(llllllllllllllllIIIIlIIllIIllllI))) {
                final int llllllllllllllllIIIIlIIllIIllIlI = (llllllllllllllllIIIIlIIllIlIIIII == 0) ? 0 : (this.inventorySlots.size() - 1);
                final int llllllllllllllllIIIIlIIllIIIIIIl = (llllllllllllllllIIIIlIIllIlIIIII == 0) ? 1 : -1;
                for (int llllllllllllllllIIIIlIIlIllllIll = 0; llllllllllllllllIIIIlIIlIllllIll < 2; ++llllllllllllllllIIIIlIIlIllllIll) {
                    for (int llllllllllllllllIIIIlIIlIllllIlI = llllllllllllllllIIIIlIIllIIllIlI; llllllllllllllllIIIIlIIlIllllIlI >= 0 && llllllllllllllllIIIIlIIlIllllIlI < this.inventorySlots.size() && llllllllllllllllIIIIlIIllIIlIIll.stackSize < llllllllllllllllIIIIlIIllIIlIIll.getMaxStackSize(); llllllllllllllllIIIIlIIlIllllIlI += llllllllllllllllIIIIlIIllIIIIIIl) {
                        final Slot llllllllllllllllIIIIlIIlIllllIIl = this.inventorySlots.get(llllllllllllllllIIIIlIIlIllllIlI);
                        if (llllllllllllllllIIIIlIIlIllllIIl.getHasStack() && canAddItemToSlot(llllllllllllllllIIIIlIIlIllllIIl, llllllllllllllllIIIIlIIllIIlIIll, true) && llllllllllllllllIIIIlIIlIllllIIl.canTakeStack(llllllllllllllllIIIIlIIllIIllllI) && this.func_94530_a(llllllllllllllllIIIIlIIllIIlIIll, llllllllllllllllIIIIlIIlIllllIIl) && (llllllllllllllllIIIIlIIlIllllIll != 0 || llllllllllllllllIIIIlIIlIllllIIl.getStack().stackSize != llllllllllllllllIIIIlIIlIllllIIl.getStack().getMaxStackSize())) {
                            final int llllllllllllllllIIIIlIIlIllllIII = Math.min(llllllllllllllllIIIIlIIllIIlIIll.getMaxStackSize() - llllllllllllllllIIIIlIIllIIlIIll.stackSize, llllllllllllllllIIIIlIIlIllllIIl.getStack().stackSize);
                            final ItemStack llllllllllllllllIIIIlIIlIlllIlll = llllllllllllllllIIIIlIIlIllllIIl.decrStackSize(llllllllllllllllIIIIlIIlIllllIII);
                            final ItemStack itemStack3 = llllllllllllllllIIIIlIIllIIlIIll;
                            itemStack3.stackSize += llllllllllllllllIIIIlIIlIllllIII;
                            if (llllllllllllllllIIIIlIIlIlllIlll.stackSize <= 0) {
                                llllllllllllllllIIIIlIIlIllllIIl.putStack(null);
                            }
                            llllllllllllllllIIIIlIIlIllllIIl.onPickupFromSlot(llllllllllllllllIIIIlIIllIIllllI, llllllllllllllllIIIIlIIlIlllIlll);
                        }
                    }
                }
            }
            this.detectAndSendChanges();
        }
        return llllllllllllllllIIIIlIIllIIlllIl;
    }
    
    protected Slot addSlotToContainer(final Slot llllllllllllllllIIIIlIlIIIIlIIIl) {
        llllllllllllllllIIIIlIlIIIIlIIIl.slotNumber = this.inventorySlots.size();
        this.inventorySlots.add(llllllllllllllllIIIIlIlIIIIlIIIl);
        this.inventoryItemStacks.add(null);
        return llllllllllllllllIIIIlIlIIIIlIIIl;
    }
    
    public boolean enchantItem(final EntityPlayer llllllllllllllllIIIIlIIlllIlIlII, final int llllllllllllllllIIIIlIIlllIlIIll) {
        return false;
    }
    
    public static int calcRedstoneFromInventory(final IInventory llllllllllllllllIIIIlIIIllIIIIll) {
        if (llllllllllllllllIIIIlIIIllIIIIll == null) {
            return 0;
        }
        int llllllllllllllllIIIIlIIIllIIIlll = 0;
        float llllllllllllllllIIIIlIIIllIIIllI = 0.0f;
        for (int llllllllllllllllIIIIlIIIllIIIlIl = 0; llllllllllllllllIIIIlIIIllIIIlIl < llllllllllllllllIIIIlIIIllIIIIll.getSizeInventory(); ++llllllllllllllllIIIIlIIIllIIIlIl) {
            final ItemStack llllllllllllllllIIIIlIIIllIIIlII = llllllllllllllllIIIIlIIIllIIIIll.getStackInSlot(llllllllllllllllIIIIlIIIllIIIlIl);
            if (llllllllllllllllIIIIlIIIllIIIlII != null) {
                llllllllllllllllIIIIlIIIllIIIllI += llllllllllllllllIIIIlIIIllIIIlII.stackSize / (float)Math.min(llllllllllllllllIIIIlIIIllIIIIll.getInventoryStackLimit(), llllllllllllllllIIIIlIIIllIIIlII.getMaxStackSize());
                ++llllllllllllllllIIIIlIIIllIIIlll;
            }
        }
        llllllllllllllllIIIIlIIIllIIIllI /= llllllllllllllllIIIIlIIIllIIIIll.getSizeInventory();
        return MathHelper.floor_float(llllllllllllllllIIIIlIIIllIIIllI * 14.0f) + ((llllllllllllllllIIIIlIIIllIIIlll > 0) ? 1 : 0);
    }
    
    public void detectAndSendChanges() {
        for (int llllllllllllllllIIIIlIIlllIllllI = 0; llllllllllllllllIIIIlIIlllIllllI < this.inventorySlots.size(); ++llllllllllllllllIIIIlIIlllIllllI) {
            final ItemStack llllllllllllllllIIIIlIIlllIlllIl = this.inventorySlots.get(llllllllllllllllIIIIlIIlllIllllI).getStack();
            ItemStack llllllllllllllllIIIIlIIlllIlllII = this.inventoryItemStacks.get(llllllllllllllllIIIIlIIlllIllllI);
            if (!ItemStack.areItemStacksEqual(llllllllllllllllIIIIlIIlllIlllII, llllllllllllllllIIIIlIIlllIlllIl)) {
                llllllllllllllllIIIIlIIlllIlllII = ((llllllllllllllllIIIIlIIlllIlllIl == null) ? null : llllllllllllllllIIIIlIIlllIlllIl.copy());
                this.inventoryItemStacks.set(llllllllllllllllIIIIlIIlllIllllI, llllllllllllllllIIIIlIIlllIlllII);
                for (int llllllllllllllllIIIIlIIlllIllIll = 0; llllllllllllllllIIIIlIIlllIllIll < this.crafters.size(); ++llllllllllllllllIIIIlIIlllIllIll) {
                    this.crafters.get(llllllllllllllllIIIIlIIlllIllIll).sendSlotContents(this, llllllllllllllllIIIIlIIlllIllllI, llllllllllllllllIIIIlIIlllIlllII);
                }
            }
        }
    }
    
    public abstract boolean canInteractWith(final EntityPlayer p0);
    
    public Slot getSlot(final int llllllllllllllllIIIIlIIlllIIIIII) {
        return this.inventorySlots.get(llllllllllllllllIIIIlIIlllIIIIII);
    }
    
    public static int func_94534_d(final int llllllllllllllllIIIIlIIIlllllIlI, final int llllllllllllllllIIIIlIIIlllllIIl) {
        return (llllllllllllllllIIIIlIIIlllllIlI & 0x3) | (llllllllllllllllIIIIlIIIlllllIIl & 0x3) << 2;
    }
    
    public static void computeStackSize(final Set llllllllllllllllIIIIlIIIllIlIllI, final int llllllllllllllllIIIIlIIIllIlIlIl, final ItemStack llllllllllllllllIIIIlIIIllIlIlII, final int llllllllllllllllIIIIlIIIllIlIIll) {
        switch (llllllllllllllllIIIIlIIIllIlIlIl) {
            case 0: {
                llllllllllllllllIIIIlIIIllIlIlII.stackSize = MathHelper.floor_float(llllllllllllllllIIIIlIIIllIlIlII.stackSize / (float)llllllllllllllllIIIIlIIIllIlIllI.size());
                break;
            }
            case 1: {
                llllllllllllllllIIIIlIIIllIlIlII.stackSize = 1;
                break;
            }
            case 2: {
                llllllllllllllllIIIIlIIIllIlIlII.stackSize = llllllllllllllllIIIIlIIIllIlIlII.getItem().getItemStackLimit();
                break;
            }
        }
        llllllllllllllllIIIIlIIIllIlIlII.stackSize += llllllllllllllllIIIIlIIIllIlIIll;
    }
    
    public void onCraftGuiOpened(final ICrafting llllllllllllllllIIIIlIlIIIIIlIII) {
        if (this.crafters.contains(llllllllllllllllIIIIlIlIIIIIlIII)) {
            throw new IllegalArgumentException("Listener already listening");
        }
        this.crafters.add(llllllllllllllllIIIIlIlIIIIIlIII);
        llllllllllllllllIIIIlIlIIIIIlIII.updateCraftingInventory(this, this.getInventory());
        this.detectAndSendChanges();
    }
    
    protected boolean mergeItemStack(final ItemStack llllllllllllllllIIIIlIIlIIIlIlll, final int llllllllllllllllIIIIlIIlIIIIlIlI, final int llllllllllllllllIIIIlIIlIIIlIlIl, final boolean llllllllllllllllIIIIlIIlIIIlIlII) {
        boolean llllllllllllllllIIIIlIIlIIIlIIll = false;
        int llllllllllllllllIIIIlIIlIIIlIIlI = llllllllllllllllIIIIlIIlIIIIlIlI;
        if (llllllllllllllllIIIIlIIlIIIlIlII) {
            llllllllllllllllIIIIlIIlIIIlIIlI = llllllllllllllllIIIIlIIlIIIlIlIl - 1;
        }
        if (llllllllllllllllIIIIlIIlIIIlIlll.isStackable()) {
            while (llllllllllllllllIIIIlIIlIIIlIlll.stackSize > 0 && ((!llllllllllllllllIIIIlIIlIIIlIlII && llllllllllllllllIIIIlIIlIIIlIIlI < llllllllllllllllIIIIlIIlIIIlIlIl) || (llllllllllllllllIIIIlIIlIIIlIlII && llllllllllllllllIIIIlIIlIIIlIIlI >= llllllllllllllllIIIIlIIlIIIIlIlI))) {
                final Slot llllllllllllllllIIIIlIIlIIIlIIIl = this.inventorySlots.get(llllllllllllllllIIIIlIIlIIIlIIlI);
                final ItemStack llllllllllllllllIIIIlIIlIIIIllll = llllllllllllllllIIIIlIIlIIIlIIIl.getStack();
                if (llllllllllllllllIIIIlIIlIIIIllll != null && llllllllllllllllIIIIlIIlIIIIllll.getItem() == llllllllllllllllIIIIlIIlIIIlIlll.getItem() && (!llllllllllllllllIIIIlIIlIIIlIlll.getHasSubtypes() || llllllllllllllllIIIIlIIlIIIlIlll.getMetadata() == llllllllllllllllIIIIlIIlIIIIllll.getMetadata()) && ItemStack.areItemStackTagsEqual(llllllllllllllllIIIIlIIlIIIlIlll, llllllllllllllllIIIIlIIlIIIIllll)) {
                    final int llllllllllllllllIIIIlIIlIIIIllIl = llllllllllllllllIIIIlIIlIIIIllll.stackSize + llllllllllllllllIIIIlIIlIIIlIlll.stackSize;
                    if (llllllllllllllllIIIIlIIlIIIIllIl <= llllllllllllllllIIIIlIIlIIIlIlll.getMaxStackSize()) {
                        llllllllllllllllIIIIlIIlIIIlIlll.stackSize = 0;
                        llllllllllllllllIIIIlIIlIIIIllll.stackSize = llllllllllllllllIIIIlIIlIIIIllIl;
                        llllllllllllllllIIIIlIIlIIIlIIIl.onSlotChanged();
                        llllllllllllllllIIIIlIIlIIIlIIll = true;
                    }
                    else if (llllllllllllllllIIIIlIIlIIIIllll.stackSize < llllllllllllllllIIIIlIIlIIIlIlll.getMaxStackSize()) {
                        llllllllllllllllIIIIlIIlIIIlIlll.stackSize -= llllllllllllllllIIIIlIIlIIIlIlll.getMaxStackSize() - llllllllllllllllIIIIlIIlIIIIllll.stackSize;
                        llllllllllllllllIIIIlIIlIIIIllll.stackSize = llllllllllllllllIIIIlIIlIIIlIlll.getMaxStackSize();
                        llllllllllllllllIIIIlIIlIIIlIIIl.onSlotChanged();
                        llllllllllllllllIIIIlIIlIIIlIIll = true;
                    }
                }
                if (llllllllllllllllIIIIlIIlIIIlIlII) {
                    --llllllllllllllllIIIIlIIlIIIlIIlI;
                }
                else {
                    ++llllllllllllllllIIIIlIIlIIIlIIlI;
                }
            }
        }
        if (llllllllllllllllIIIIlIIlIIIlIlll.stackSize > 0) {
            if (llllllllllllllllIIIIlIIlIIIlIlII) {
                llllllllllllllllIIIIlIIlIIIlIIlI = llllllllllllllllIIIIlIIlIIIlIlIl - 1;
            }
            else {
                llllllllllllllllIIIIlIIlIIIlIIlI = llllllllllllllllIIIIlIIlIIIIlIlI;
            }
            while ((!llllllllllllllllIIIIlIIlIIIlIlII && llllllllllllllllIIIIlIIlIIIlIIlI < llllllllllllllllIIIIlIIlIIIlIlIl) || (llllllllllllllllIIIIlIIlIIIlIlII && llllllllllllllllIIIIlIIlIIIlIIlI >= llllllllllllllllIIIIlIIlIIIIlIlI)) {
                final Slot llllllllllllllllIIIIlIIlIIIlIIII = this.inventorySlots.get(llllllllllllllllIIIIlIIlIIIlIIlI);
                final ItemStack llllllllllllllllIIIIlIIlIIIIlllI = llllllllllllllllIIIIlIIlIIIlIIII.getStack();
                if (llllllllllllllllIIIIlIIlIIIIlllI == null) {
                    llllllllllllllllIIIIlIIlIIIlIIII.putStack(llllllllllllllllIIIIlIIlIIIlIlll.copy());
                    llllllllllllllllIIIIlIIlIIIlIIII.onSlotChanged();
                    llllllllllllllllIIIIlIIlIIIlIlll.stackSize = 0;
                    llllllllllllllllIIIIlIIlIIIlIIll = true;
                    break;
                }
                if (llllllllllllllllIIIIlIIlIIIlIlII) {
                    --llllllllllllllllIIIIlIIlIIIlIIlI;
                }
                else {
                    ++llllllllllllllllIIIIlIIlIIIlIIlI;
                }
            }
        }
        return llllllllllllllllIIIIlIIlIIIlIIll;
    }
    
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllllIIIIlIIllIlllIIl, final int llllllllllllllllIIIIlIIllIlllIII) {
        final Slot llllllllllllllllIIIIlIIllIllIlll = this.inventorySlots.get(llllllllllllllllIIIIlIIllIlllIII);
        return (llllllllllllllllIIIIlIIllIllIlll != null) ? llllllllllllllllIIIIlIIllIllIlll.getStack() : null;
    }
    
    public void putStackInSlot(final int llllllllllllllllIIIIlIIlIlIIIIll, final ItemStack llllllllllllllllIIIIlIIlIlIIIIlI) {
        this.getSlot(llllllllllllllllIIIIlIIlIlIIIIll).putStack(llllllllllllllllIIIIlIIlIlIIIIlI);
    }
    
    protected void resetDrag() {
        this.dragEvent = 0;
        this.dragSlots.clear();
    }
    
    public void setCanCraft(final EntityPlayer llllllllllllllllIIIIlIIlIIlIIlll, final boolean llllllllllllllllIIIIlIIlIIlIIIll) {
        if (llllllllllllllllIIIIlIIlIIlIIIll) {
            this.playerList.remove(llllllllllllllllIIIIlIIlIIlIIlll);
        }
        else {
            this.playerList.add(llllllllllllllllIIIIlIIlIIlIIlll);
        }
    }
    
    public boolean getCanCraft(final EntityPlayer llllllllllllllllIIIIlIIlIIlIllII) {
        return !this.playerList.contains(llllllllllllllllIIIIlIIlIIlIllII);
    }
    
    static {
        __OBFID = "CL_00001730";
    }
    
    public void putStacksInSlots(final ItemStack[] llllllllllllllllIIIIlIIlIIlllIlI) {
        for (int llllllllllllllllIIIIlIIlIIllllII = 0; llllllllllllllllIIIIlIIlIIllllII < llllllllllllllllIIIIlIIlIIlllIlI.length; ++llllllllllllllllIIIIlIIlIIllllII) {
            this.getSlot(llllllllllllllllIIIIlIIlIIllllII).putStack(llllllllllllllllIIIIlIIlIIlllIlI[llllllllllllllllIIIIlIIlIIllllII]);
        }
    }
    
    public short getNextTransactionID(final InventoryPlayer llllllllllllllllIIIIlIIlIIllIIll) {
        ++this.transactionID;
        return this.transactionID;
    }
    
    public static int extractDragMode(final int llllllllllllllllIIIIlIIlIIIIIIIl) {
        return llllllllllllllllIIIIlIIlIIIIIIIl >> 2 & 0x3;
    }
    
    public Slot getSlotFromInventory(final IInventory llllllllllllllllIIIIlIIlllIIIlll, final int llllllllllllllllIIIIlIIlllIIIllI) {
        for (int llllllllllllllllIIIIlIIlllIIlIlI = 0; llllllllllllllllIIIIlIIlllIIlIlI < this.inventorySlots.size(); ++llllllllllllllllIIIIlIIlllIIlIlI) {
            final Slot llllllllllllllllIIIIlIIlllIIlIIl = this.inventorySlots.get(llllllllllllllllIIIIlIIlllIIlIlI);
            if (llllllllllllllllIIIIlIIlllIIlIIl.isHere(llllllllllllllllIIIIlIIlllIIIlll, llllllllllllllllIIIIlIIlllIIIllI)) {
                return llllllllllllllllIIIIlIIlllIIlIIl;
            }
        }
        return null;
    }
    
    public List getInventory() {
        final ArrayList llllllllllllllllIIIIlIIllllIlIlI = Lists.newArrayList();
        for (int llllllllllllllllIIIIlIIllllIlIII = 0; llllllllllllllllIIIIlIIllllIlIII < this.inventorySlots.size(); ++llllllllllllllllIIIIlIIllllIlIII) {
            llllllllllllllllIIIIlIIllllIlIlI.add(this.inventorySlots.get(llllllllllllllllIIIIlIIllllIlIII).getStack());
        }
        return llllllllllllllllIIIIlIIllllIlIlI;
    }
    
    public void onCraftMatrixChanged(final IInventory llllllllllllllllIIIIlIIlIlIIllII) {
        this.detectAndSendChanges();
    }
    
    public static boolean canAddItemToSlot(final Slot llllllllllllllllIIIIlIIIlllIIIll, final ItemStack llllllllllllllllIIIIlIIIlllIIlll, final boolean llllllllllllllllIIIIlIIIlllIIllI) {
        boolean llllllllllllllllIIIIlIIIlllIIlIl = llllllllllllllllIIIIlIIIlllIIIll == null || !llllllllllllllllIIIIlIIIlllIIIll.getHasStack();
        if (llllllllllllllllIIIIlIIIlllIIIll != null && llllllllllllllllIIIIlIIIlllIIIll.getHasStack() && llllllllllllllllIIIIlIIIlllIIlll != null && llllllllllllllllIIIIlIIIlllIIlll.isItemEqual(llllllllllllllllIIIIlIIIlllIIIll.getStack()) && ItemStack.areItemStackTagsEqual(llllllllllllllllIIIIlIIIlllIIIll.getStack(), llllllllllllllllIIIIlIIIlllIIlll)) {
            final int llllllllllllllllIIIIlIIIlllIIlII = llllllllllllllllIIIIlIIIlllIIllI ? 0 : llllllllllllllllIIIIlIIIlllIIlll.stackSize;
            llllllllllllllllIIIIlIIIlllIIlIl |= (llllllllllllllllIIIIlIIIlllIIIll.getStack().stackSize + llllllllllllllllIIIIlIIIlllIIlII <= llllllllllllllllIIIIlIIIlllIIlll.getMaxStackSize());
        }
        return llllllllllllllllIIIIlIIIlllIIlIl;
    }
    
    public void onContainerClosed(final EntityPlayer llllllllllllllllIIIIlIIlIlIlIIII) {
        final InventoryPlayer llllllllllllllllIIIIlIIlIlIlIIIl = llllllllllllllllIIIIlIIlIlIlIIII.inventory;
        if (llllllllllllllllIIIIlIIlIlIlIIIl.getItemStack() != null) {
            llllllllllllllllIIIIlIIlIlIlIIII.dropPlayerItemWithRandomChoice(llllllllllllllllIIIIlIIlIlIlIIIl.getItemStack(), false);
            llllllllllllllllIIIIlIIlIlIlIIIl.setItemStack(null);
        }
    }
    
    protected void retrySlotClick(final int llllllllllllllllIIIIlIIlIlIlllIl, final int llllllllllllllllIIIIlIIlIlIlllII, final boolean llllllllllllllllIIIIlIIlIlIllIll, final EntityPlayer llllllllllllllllIIIIlIIlIlIllIlI) {
        this.slotClick(llllllllllllllllIIIIlIIlIlIlllIl, llllllllllllllllIIIIlIIlIlIlllII, 1, llllllllllllllllIIIIlIIlIlIllIlI);
    }
    
    public static int getDragEvent(final int llllllllllllllllIIIIlIIIlllllllI) {
        return llllllllllllllllIIIIlIIIlllllllI & 0x3;
    }
    
    public void updateProgressBar(final int llllllllllllllllIIIIlIIlIIllIlll, final int llllllllllllllllIIIIlIIlIIllIllI) {
    }
    
    public boolean func_94530_a(final ItemStack llllllllllllllllIIIIlIIlIllIIlII, final Slot llllllllllllllllIIIIlIIlIllIIIll) {
        return true;
    }
}
