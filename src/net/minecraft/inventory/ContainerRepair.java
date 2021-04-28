package net.minecraft.inventory;

import net.minecraft.util.*;
import net.minecraft.world.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import org.apache.commons.lang3.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;

public class ContainerRepair extends Container
{
    private /* synthetic */ int materialCost;
    private /* synthetic */ BlockPos field_178156_j;
    public /* synthetic */ int maximumCost;
    private final /* synthetic */ EntityPlayer thePlayer;
    private /* synthetic */ IInventory inputSlots;
    private /* synthetic */ IInventory outputSlot;
    private /* synthetic */ String repairedItemName;
    private /* synthetic */ World theWorld;
    
    static {
        __OBFID = "CL_00001732";
        logger = LogManager.getLogger();
    }
    
    public ContainerRepair(final InventoryPlayer llllllllllllllIllIIlIlIIIlIIIlIl, final World llllllllllllllIllIIlIlIIIlIIIlII, final EntityPlayer llllllllllllllIllIIlIlIIIlIIIlll) {
        this(llllllllllllllIllIIlIlIIIlIIIlIl, llllllllllllllIllIIlIlIIIlIIIlII, BlockPos.ORIGIN, llllllllllllllIllIIlIlIIIlIIIlll);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllIllIIlIIlllIlIlIIl) {
        return this.theWorld.getBlockState(this.field_178156_j).getBlock() == Blocks.anvil && llllllllllllllIllIIlIIlllIlIlIIl.getDistanceSq(this.field_178156_j.getX() + 0.5, this.field_178156_j.getY() + 0.5, this.field_178156_j.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllIllIIlIIlllIllIIll) {
        super.onContainerClosed(llllllllllllllIllIIlIIlllIllIIll);
        if (!this.theWorld.isRemote) {
            for (int llllllllllllllIllIIlIIlllIllIIlI = 0; llllllllllllllIllIIlIIlllIllIIlI < this.inputSlots.getSizeInventory(); ++llllllllllllllIllIIlIIlllIllIIlI) {
                final ItemStack llllllllllllllIllIIlIIlllIllIIIl = this.inputSlots.getStackInSlotOnClosing(llllllllllllllIllIIlIIlllIllIIlI);
                if (llllllllllllllIllIIlIIlllIllIIIl != null) {
                    llllllllllllllIllIIlIIlllIllIIll.dropPlayerItemWithRandomChoice(llllllllllllllIllIIlIIlllIllIIIl, false);
                }
            }
        }
    }
    
    @Override
    public void onCraftGuiOpened(final ICrafting llllllllllllllIllIIlIIllllIIIlII) {
        super.onCraftGuiOpened(llllllllllllllIllIIlIIllllIIIlII);
        llllllllllllllIllIIlIIllllIIIlII.sendProgressBarUpdate(this, 0, this.maximumCost);
    }
    
    public void updateRepairOutput() {
        final boolean llllllllllllllIllIIlIlIIIIIIlIIl = false;
        final boolean llllllllllllllIllIIlIlIIIIIIlIII = true;
        final boolean llllllllllllllIllIIlIlIIIIIIIlll = true;
        final boolean llllllllllllllIllIIlIlIIIIIIIllI = true;
        final boolean llllllllllllllIllIIlIlIIIIIIIlIl = true;
        final boolean llllllllllllllIllIIlIlIIIIIIIlII = true;
        final boolean llllllllllllllIllIIlIlIIIIIIIIll = true;
        final ItemStack llllllllllllllIllIIlIlIIIIIIIIlI = this.inputSlots.getStackInSlot(0);
        this.maximumCost = 1;
        int llllllllllllllIllIIlIlIIIIIIIIIl = 0;
        final byte llllllllllllllIllIIlIlIIIIIIIIII = 0;
        byte llllllllllllllIllIIlIIllllllllll = 0;
        if (llllllllllllllIllIIlIlIIIIIIIIlI == null) {
            this.outputSlot.setInventorySlotContents(0, null);
            this.maximumCost = 0;
        }
        else {
            ItemStack llllllllllllllIllIIlIIlllllllllI = llllllllllllllIllIIlIlIIIIIIIIlI.copy();
            final ItemStack llllllllllllllIllIIlIIllllllllIl = this.inputSlots.getStackInSlot(1);
            final Map llllllllllllllIllIIlIIllllllllII = EnchantmentHelper.getEnchantments(llllllllllllllIllIIlIIlllllllllI);
            boolean llllllllllllllIllIIlIIlllllllIll = false;
            final int llllllllllllllIllIIlIIlllllllIlI = llllllllllllllIllIIlIlIIIIIIIIII + llllllllllllllIllIIlIlIIIIIIIIlI.getRepairCost() + ((llllllllllllllIllIIlIIllllllllIl == null) ? 0 : llllllllllllllIllIIlIIllllllllIl.getRepairCost());
            this.materialCost = 0;
            if (llllllllllllllIllIIlIIllllllllIl != null) {
                llllllllllllllIllIIlIIlllllllIll = (llllllllllllllIllIIlIIllllllllIl.getItem() == Items.enchanted_book && Items.enchanted_book.func_92110_g(llllllllllllllIllIIlIIllllllllIl).tagCount() > 0);
                if (llllllllllllllIllIIlIIlllllllllI.isItemStackDamageable() && llllllllllllllIllIIlIIlllllllllI.getItem().getIsRepairable(llllllllllllllIllIIlIlIIIIIIIIlI, llllllllllllllIllIIlIIllllllllIl)) {
                    int llllllllllllllIllIIlIIlllllllIIl = Math.min(llllllllllllllIllIIlIIlllllllllI.getItemDamage(), llllllllllllllIllIIlIIlllllllllI.getMaxDamage() / 4);
                    if (llllllllllllllIllIIlIIlllllllIIl <= 0) {
                        this.outputSlot.setInventorySlotContents(0, null);
                        this.maximumCost = 0;
                        return;
                    }
                    int llllllllllllllIllIIlIIllllllIllI;
                    for (llllllllllllllIllIIlIIllllllIllI = 0; llllllllllllllIllIIlIIlllllllIIl > 0 && llllllllllllllIllIIlIIllllllIllI < llllllllllllllIllIIlIIllllllllIl.stackSize; llllllllllllllIllIIlIIlllllllIIl = Math.min(llllllllllllllIllIIlIIlllllllllI.getItemDamage(), llllllllllllllIllIIlIIlllllllllI.getMaxDamage() / 4), ++llllllllllllllIllIIlIIllllllIllI) {
                        final int llllllllllllllIllIIlIIllllllIlII = llllllllllllllIllIIlIIlllllllllI.getItemDamage() - llllllllllllllIllIIlIIlllllllIIl;
                        llllllllllllllIllIIlIIlllllllllI.setItemDamage(llllllllllllllIllIIlIIllllllIlII);
                        ++llllllllllllllIllIIlIlIIIIIIIIIl;
                    }
                    this.materialCost = llllllllllllllIllIIlIIllllllIllI;
                }
                else {
                    if (!llllllllllllllIllIIlIIlllllllIll && (llllllllllllllIllIIlIIlllllllllI.getItem() != llllllllllllllIllIIlIIllllllllIl.getItem() || !llllllllllllllIllIIlIIlllllllllI.isItemStackDamageable())) {
                        this.outputSlot.setInventorySlotContents(0, null);
                        this.maximumCost = 0;
                        return;
                    }
                    if (llllllllllllllIllIIlIIlllllllllI.isItemStackDamageable() && !llllllllllllllIllIIlIIlllllllIll) {
                        final int llllllllllllllIllIIlIIlllllllIII = llllllllllllllIllIIlIlIIIIIIIIlI.getMaxDamage() - llllllllllllllIllIIlIlIIIIIIIIlI.getItemDamage();
                        final int llllllllllllllIllIIlIIllllllIlIl = llllllllllllllIllIIlIIllllllllIl.getMaxDamage() - llllllllllllllIllIIlIIllllllllIl.getItemDamage();
                        final int llllllllllllllIllIIlIIllllllIIll = llllllllllllllIllIIlIIllllllIlIl + llllllllllllllIllIIlIIlllllllllI.getMaxDamage() * 12 / 100;
                        final int llllllllllllllIllIIlIIlllllIllll = llllllllllllllIllIIlIIlllllllIII + llllllllllllllIllIIlIIllllllIIll;
                        int llllllllllllllIllIIlIIllllllIIIl = llllllllllllllIllIIlIIlllllllllI.getMaxDamage() - llllllllllllllIllIIlIIlllllIllll;
                        if (llllllllllllllIllIIlIIllllllIIIl < 0) {
                            llllllllllllllIllIIlIIllllllIIIl = 0;
                        }
                        if (llllllllllllllIllIIlIIllllllIIIl < llllllllllllllIllIIlIIlllllllllI.getMetadata()) {
                            llllllllllllllIllIIlIIlllllllllI.setItemDamage(llllllllllllllIllIIlIIllllllIIIl);
                            llllllllllllllIllIIlIlIIIIIIIIIl += 2;
                        }
                    }
                    final Map llllllllllllllIllIIlIIlllllIlllI = EnchantmentHelper.getEnchantments(llllllllllllllIllIIlIIllllllllIl);
                    for (final int llllllllllllllIllIIlIIllllllIIlI : llllllllllllllIllIIlIIlllllIlllI.keySet()) {
                        final Enchantment llllllllllllllIllIIlIIlllllIllII = Enchantment.func_180306_c(llllllllllllllIllIIlIIllllllIIlI);
                        if (llllllllllllllIllIIlIIlllllIllII != null) {
                            final int llllllllllllllIllIIlIIllllllIIII = llllllllllllllIllIIlIIllllllllII.containsKey(llllllllllllllIllIIlIIllllllIIlI) ? llllllllllllllIllIIlIIllllllllII.get(llllllllllllllIllIIlIIllllllIIlI) : 0;
                            int llllllllllllllIllIIlIIlllllIlIll = llllllllllllllIllIIlIIlllllIlllI.get(llllllllllllllIllIIlIIllllllIIlI);
                            int llllllllllllllIllIIlIIlllllIlIIl = 0;
                            if (llllllllllllllIllIIlIIllllllIIII == llllllllllllllIllIIlIIlllllIlIll) {
                                final int llllllllllllllIllIIlIIlllllIlIlI = ++llllllllllllllIllIIlIIlllllIlIll;
                            }
                            else {
                                llllllllllllllIllIIlIIlllllIlIIl = Math.max(llllllllllllllIllIIlIIlllllIlIll, llllllllllllllIllIIlIIllllllIIII);
                            }
                            llllllllllllllIllIIlIIlllllIlIll = llllllllllllllIllIIlIIlllllIlIIl;
                            boolean llllllllllllllIllIIlIIlllllIlIII = llllllllllllllIllIIlIIlllllIllII.canApply(llllllllllllllIllIIlIlIIIIIIIIlI);
                            if (this.thePlayer.capabilities.isCreativeMode || llllllllllllllIllIIlIlIIIIIIIIlI.getItem() == Items.enchanted_book) {
                                llllllllllllllIllIIlIIlllllIlIII = true;
                            }
                            for (final int llllllllllllllIllIIlIIlllllIIllI : llllllllllllllIllIIlIIllllllllII.keySet()) {
                                if (llllllllllllllIllIIlIIlllllIIllI != llllllllllllllIllIIlIIllllllIIlI && !llllllllllllllIllIIlIIlllllIllII.canApplyTogether(Enchantment.func_180306_c(llllllllllllllIllIIlIIlllllIIllI))) {
                                    llllllllllllllIllIIlIIlllllIlIII = false;
                                    ++llllllllllllllIllIIlIlIIIIIIIIIl;
                                }
                            }
                            if (!llllllllllllllIllIIlIIlllllIlIII) {
                                continue;
                            }
                            if (llllllllllllllIllIIlIIlllllIlIll > llllllllllllllIllIIlIIlllllIllII.getMaxLevel()) {
                                llllllllllllllIllIIlIIlllllIlIll = llllllllllllllIllIIlIIlllllIllII.getMaxLevel();
                            }
                            llllllllllllllIllIIlIIllllllllII.put(llllllllllllllIllIIlIIllllllIIlI, llllllllllllllIllIIlIIlllllIlIll);
                            int llllllllllllllIllIIlIIlllllIIlIl = 0;
                            switch (llllllllllllllIllIIlIIlllllIllII.getWeight()) {
                                case 1: {
                                    llllllllllllllIllIIlIIlllllIIlIl = 8;
                                    break;
                                }
                                case 2: {
                                    llllllllllllllIllIIlIIlllllIIlIl = 4;
                                    break;
                                }
                                case 5: {
                                    llllllllllllllIllIIlIIlllllIIlIl = 2;
                                    break;
                                }
                                case 10: {
                                    llllllllllllllIllIIlIIlllllIIlIl = 1;
                                    break;
                                }
                            }
                            if (llllllllllllllIllIIlIIlllllllIll) {
                                llllllllllllllIllIIlIIlllllIIlIl = Math.max(1, llllllllllllllIllIIlIIlllllIIlIl / 2);
                            }
                            llllllllllllllIllIIlIlIIIIIIIIIl += llllllllllllllIllIIlIIlllllIIlIl * llllllllllllllIllIIlIIlllllIlIll;
                        }
                    }
                }
            }
            if (StringUtils.isBlank((CharSequence)this.repairedItemName)) {
                if (llllllllllllllIllIIlIlIIIIIIIIlI.hasDisplayName()) {
                    llllllllllllllIllIIlIIllllllllll = 1;
                    llllllllllllllIllIIlIlIIIIIIIIIl += llllllllllllllIllIIlIIllllllllll;
                    llllllllllllllIllIIlIIlllllllllI.clearCustomName();
                }
            }
            else if (!this.repairedItemName.equals(llllllllllllllIllIIlIlIIIIIIIIlI.getDisplayName())) {
                llllllllllllllIllIIlIIllllllllll = 1;
                llllllllllllllIllIIlIlIIIIIIIIIl += llllllllllllllIllIIlIIllllllllll;
                llllllllllllllIllIIlIIlllllllllI.setStackDisplayName(this.repairedItemName);
            }
            this.maximumCost = llllllllllllllIllIIlIIlllllllIlI + llllllllllllllIllIIlIlIIIIIIIIIl;
            if (llllllllllllllIllIIlIlIIIIIIIIIl <= 0) {
                llllllllllllllIllIIlIIlllllllllI = null;
            }
            if (llllllllllllllIllIIlIIllllllllll == llllllllllllllIllIIlIlIIIIIIIIIl && llllllllllllllIllIIlIIllllllllll > 0 && this.maximumCost >= 40) {
                this.maximumCost = 39;
            }
            if (this.maximumCost >= 40 && !this.thePlayer.capabilities.isCreativeMode) {
                llllllllllllllIllIIlIIlllllllllI = null;
            }
            if (llllllllllllllIllIIlIIlllllllllI != null) {
                int llllllllllllllIllIIlIIllllllIlll = llllllllllllllIllIIlIIlllllllllI.getRepairCost();
                if (llllllllllllllIllIIlIIllllllllIl != null && llllllllllllllIllIIlIIllllllIlll < llllllllllllllIllIIlIIllllllllIl.getRepairCost()) {
                    llllllllllllllIllIIlIIllllllIlll = llllllllllllllIllIIlIIllllllllIl.getRepairCost();
                }
                llllllllllllllIllIIlIIllllllIlll = llllllllllllllIllIIlIIllllllIlll * 2 + 1;
                llllllllllllllIllIIlIIlllllllllI.setRepairCost(llllllllllllllIllIIlIIllllllIlll);
                EnchantmentHelper.setEnchantments(llllllllllllllIllIIlIIllllllllII, llllllllllllllIllIIlIIlllllllllI);
            }
            this.outputSlot.setInventorySlotContents(0, llllllllllllllIllIIlIIlllllllllI);
            this.detectAndSendChanges();
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIllIIlIIlllIIlllll, final int llllllllllllllIllIIlIIlllIIllllI) {
        ItemStack llllllllllllllIllIIlIIlllIIlllIl = null;
        final Slot llllllllllllllIllIIlIIlllIIlllII = this.inventorySlots.get(llllllllllllllIllIIlIIlllIIllllI);
        if (llllllllllllllIllIIlIIlllIIlllII != null && llllllllllllllIllIIlIIlllIIlllII.getHasStack()) {
            final ItemStack llllllllllllllIllIIlIIlllIIllIll = llllllllllllllIllIIlIIlllIIlllII.getStack();
            llllllllllllllIllIIlIIlllIIlllIl = llllllllllllllIllIIlIIlllIIllIll.copy();
            if (llllllllllllllIllIIlIIlllIIllllI == 2) {
                if (!this.mergeItemStack(llllllllllllllIllIIlIIlllIIllIll, 3, 39, true)) {
                    return null;
                }
                llllllllllllllIllIIlIIlllIIlllII.onSlotChange(llllllllllllllIllIIlIIlllIIllIll, llllllllllllllIllIIlIIlllIIlllIl);
            }
            else if (llllllllllllllIllIIlIIlllIIllllI != 0 && llllllllllllllIllIIlIIlllIIllllI != 1) {
                if (llllllllllllllIllIIlIIlllIIllllI >= 3 && llllllllllllllIllIIlIIlllIIllllI < 39 && !this.mergeItemStack(llllllllllllllIllIIlIIlllIIllIll, 0, 2, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllIllIIlIIlllIIllIll, 3, 39, false)) {
                return null;
            }
            if (llllllllllllllIllIIlIIlllIIllIll.stackSize == 0) {
                llllllllllllllIllIIlIIlllIIlllII.putStack(null);
            }
            else {
                llllllllllllllIllIIlIIlllIIlllII.onSlotChanged();
            }
            if (llllllllllllllIllIIlIIlllIIllIll.stackSize == llllllllllllllIllIIlIIlllIIlllIl.stackSize) {
                return null;
            }
            llllllllllllllIllIIlIIlllIIlllII.onPickupFromSlot(llllllllllllllIllIIlIIlllIIlllll, llllllllllllllIllIIlIIlllIIllIll);
        }
        return llllllllllllllIllIIlIIlllIIlllIl;
    }
    
    public ContainerRepair(final InventoryPlayer llllllllllllllIllIIlIlIIIIllIIll, final World llllllllllllllIllIIlIlIIIIlllIIl, final BlockPos llllllllllllllIllIIlIlIIIIlllIII, final EntityPlayer llllllllllllllIllIIlIlIIIIllIlll) {
        this.outputSlot = new InventoryCraftResult();
        this.inputSlots = new InventoryBasic("Repair", true, 2) {
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerRepair.this.onCraftMatrixChanged(this);
            }
            
            static {
                __OBFID = "CL_00001733";
            }
        };
        this.field_178156_j = llllllllllllllIllIIlIlIIIIlllIII;
        this.theWorld = llllllllllllllIllIIlIlIIIIlllIIl;
        this.thePlayer = llllllllllllllIllIIlIlIIIIllIlll;
        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47));
        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47));
        this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47) {
            @Override
            public void onPickupFromSlot(final EntityPlayer llllllllllllllIIIllIlIIllIIlllll, final ItemStack llllllllllllllIIIllIlIIllIIllllI) {
                if (!llllllllllllllIIIllIlIIllIIlllll.capabilities.isCreativeMode) {
                    llllllllllllllIIIllIlIIllIIlllll.addExperienceLevel(-ContainerRepair.this.maximumCost);
                }
                ContainerRepair.this.inputSlots.setInventorySlotContents(0, null);
                if (ContainerRepair.this.materialCost > 0) {
                    final ItemStack llllllllllllllIIIllIlIIllIIlllIl = ContainerRepair.this.inputSlots.getStackInSlot(1);
                    if (llllllllllllllIIIllIlIIllIIlllIl != null && llllllllllllllIIIllIlIIllIIlllIl.stackSize > ContainerRepair.this.materialCost) {
                        final ItemStack itemStack = llllllllllllllIIIllIlIIllIIlllIl;
                        itemStack.stackSize -= ContainerRepair.this.materialCost;
                        ContainerRepair.this.inputSlots.setInventorySlotContents(1, llllllllllllllIIIllIlIIllIIlllIl);
                    }
                    else {
                        ContainerRepair.this.inputSlots.setInventorySlotContents(1, null);
                    }
                }
                else {
                    ContainerRepair.this.inputSlots.setInventorySlotContents(1, null);
                }
                ContainerRepair.this.maximumCost = 0;
                final IBlockState llllllllllllllIIIllIlIIllIIlllII = llllllllllllllIllIIlIlIIIIlllIIl.getBlockState(llllllllllllllIllIIlIlIIIIlllIII);
                if (!llllllllllllllIIIllIlIIllIIlllll.capabilities.isCreativeMode && !llllllllllllllIllIIlIlIIIIlllIIl.isRemote && llllllllllllllIIIllIlIIllIIlllII.getBlock() == Blocks.anvil && llllllllllllllIIIllIlIIllIIlllll.getRNG().nextFloat() < 0.12f) {
                    int llllllllllllllIIIllIlIIllIIllIll = (int)llllllllllllllIIIllIlIIllIIlllII.getValue(BlockAnvil.DAMAGE);
                    if (++llllllllllllllIIIllIlIIllIIllIll > 2) {
                        llllllllllllllIllIIlIlIIIIlllIIl.setBlockToAir(llllllllllllllIllIIlIlIIIIlllIII);
                        llllllllllllllIllIIlIlIIIIlllIIl.playAuxSFX(1020, llllllllllllllIllIIlIlIIIIlllIII, 0);
                    }
                    else {
                        llllllllllllllIllIIlIlIIIIlllIIl.setBlockState(llllllllllllllIllIIlIlIIIIlllIII, llllllllllllllIIIllIlIIllIIlllII.withProperty(BlockAnvil.DAMAGE, llllllllllllllIIIllIlIIllIIllIll), 2);
                        llllllllllllllIllIIlIlIIIIlllIIl.playAuxSFX(1021, llllllllllllllIllIIlIlIIIIlllIII, 0);
                    }
                }
                else if (!llllllllllllllIllIIlIlIIIIlllIIl.isRemote) {
                    llllllllllllllIllIIlIlIIIIlllIIl.playAuxSFX(1021, llllllllllllllIllIIlIlIIIIlllIII, 0);
                }
            }
            
            @Override
            public boolean canTakeStack(final EntityPlayer llllllllllllllIIIllIlIIllIlIIlIl) {
                return (llllllllllllllIIIllIlIIllIlIIlIl.capabilities.isCreativeMode || llllllllllllllIIIllIlIIllIlIIlIl.experienceLevel >= ContainerRepair.this.maximumCost) && ContainerRepair.this.maximumCost > 0 && this.getHasStack();
            }
            
            @Override
            public boolean isItemValid(final ItemStack llllllllllllllIIIllIlIIllIlIlIll) {
                return false;
            }
            
            static {
                __OBFID = "CL_00001734";
            }
        });
        for (int llllllllllllllIllIIlIlIIIIllIllI = 0; llllllllllllllIllIIlIlIIIIllIllI < 3; ++llllllllllllllIllIIlIlIIIIllIllI) {
            for (int llllllllllllllIllIIlIlIIIIllIlIl = 0; llllllllllllllIllIIlIlIIIIllIlIl < 9; ++llllllllllllllIllIIlIlIIIIllIlIl) {
                this.addSlotToContainer(new Slot(llllllllllllllIllIIlIlIIIIllIIll, llllllllllllllIllIIlIlIIIIllIlIl + llllllllllllllIllIIlIlIIIIllIllI * 9 + 9, 8 + llllllllllllllIllIIlIlIIIIllIlIl * 18, 84 + llllllllllllllIllIIlIlIIIIllIllI * 18));
            }
        }
        for (int llllllllllllllIllIIlIlIIIIllIllI = 0; llllllllllllllIllIIlIlIIIIllIllI < 9; ++llllllllllllllIllIIlIlIIIIllIllI) {
            this.addSlotToContainer(new Slot(llllllllllllllIllIIlIlIIIIllIIll, llllllllllllllIllIIlIlIIIIllIllI, 8 + llllllllllllllIllIIlIlIIIIllIllI * 18, 142));
        }
    }
    
    @Override
    public void updateProgressBar(final int llllllllllllllIllIIlIIlllIllllIl, final int llllllllllllllIllIIlIIlllIlllIIl) {
        if (llllllllllllllIllIIlIIlllIllllIl == 0) {
            this.maximumCost = llllllllllllllIllIIlIIlllIlllIIl;
        }
    }
    
    public void updateItemName(final String llllllllllllllIllIIlIIlllIIIllIl) {
        this.repairedItemName = llllllllllllllIllIIlIIlllIIIllIl;
        if (this.getSlot(2).getHasStack()) {
            final ItemStack llllllllllllllIllIIlIIlllIIIllll = this.getSlot(2).getStack();
            if (StringUtils.isBlank((CharSequence)llllllllllllllIllIIlIIlllIIIllIl)) {
                llllllllllllllIllIIlIIlllIIIllll.clearCustomName();
            }
            else {
                llllllllllllllIllIIlIIlllIIIllll.setStackDisplayName(this.repairedItemName);
            }
        }
        this.updateRepairOutput();
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory llllllllllllllIllIIlIlIIIIlIlIlI) {
        super.onCraftMatrixChanged(llllllllllllllIllIIlIlIIIIlIlIlI);
        if (llllllllllllllIllIIlIlIIIIlIlIlI == this.inputSlots) {
            this.updateRepairOutput();
        }
    }
}
