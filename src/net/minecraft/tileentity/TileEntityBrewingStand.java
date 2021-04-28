package net.minecraft.tileentity;

import net.minecraft.server.gui.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;

public class TileEntityBrewingStand extends TileEntityLockable implements ISidedInventory, IUpdatePlayerListBox
{
    private /* synthetic */ Item ingredientID;
    private /* synthetic */ ItemStack[] brewingItemStacks;
    private static final /* synthetic */ int[] inputSlots;
    private /* synthetic */ int brewTime;
    private /* synthetic */ boolean[] filledSlots;
    private /* synthetic */ String field_145942_n;
    private static final /* synthetic */ int[] outputSlots;
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIIIIllIlllllllIllI) {
        super.writeToNBT(llllllllllllllIIIIllIlllllllIllI);
        llllllllllllllIIIIllIlllllllIllI.setShort("BrewTime", (short)this.brewTime);
        final NBTTagList llllllllllllllIIIIllIlllllllIlIl = new NBTTagList();
        for (int llllllllllllllIIIIllIlllllllIlII = 0; llllllllllllllIIIIllIlllllllIlII < this.brewingItemStacks.length; ++llllllllllllllIIIIllIlllllllIlII) {
            if (this.brewingItemStacks[llllllllllllllIIIIllIlllllllIlII] != null) {
                final NBTTagCompound llllllllllllllIIIIllIlllllllIIll = new NBTTagCompound();
                llllllllllllllIIIIllIlllllllIIll.setByte("Slot", (byte)llllllllllllllIIIIllIlllllllIlII);
                this.brewingItemStacks[llllllllllllllIIIIllIlllllllIlII].writeToNBT(llllllllllllllIIIIllIlllllllIIll);
                llllllllllllllIIIIllIlllllllIlIl.appendTag(llllllllllllllIIIIllIlllllllIIll);
            }
        }
        llllllllllllllIIIIllIlllllllIllI.setTag("Items", llllllllllllllIIIIllIlllllllIlIl);
        if (this.hasCustomName()) {
            llllllllllllllIIIIllIlllllllIllI.setString("CustomName", this.field_145942_n);
        }
    }
    
    public TileEntityBrewingStand() {
        this.brewingItemStacks = new ItemStack[4];
    }
    
    static {
        __OBFID = "CL_00000345";
        inputSlots = new int[] { 3 };
        outputSlots = new int[] { 0, 1, 2 };
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIIIIllIlllllIIIIIl) {
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllllllllllIIIIllIlllllIlIllI) {
        if (llllllllllllllIIIIllIlllllIlIllI >= 0 && llllllllllllllIIIIllIlllllIlIllI < this.brewingItemStacks.length) {
            final ItemStack llllllllllllllIIIIllIlllllIllIII = this.brewingItemStacks[llllllllllllllIIIIllIlllllIlIllI];
            this.brewingItemStacks[llllllllllllllIIIIllIlllllIlIllI] = null;
            return llllllllllllllIIIIllIlllllIllIII;
        }
        return null;
    }
    
    @Override
    public void setField(final int llllllllllllllIIIIllIllllIIIllII, final int llllllllllllllIIIIllIllllIIIlIll) {
        switch (llllllllllllllIIIIllIllllIIIllII) {
            case 0: {
                this.brewTime = llllllllllllllIIIIllIllllIIIlIll;
                break;
            }
        }
    }
    
    @Override
    public void clearInventory() {
        for (int llllllllllllllIIIIllIllllIIIIIll = 0; llllllllllllllIIIIllIllllIIIIIll < this.brewingItemStacks.length; ++llllllllllllllIIIIllIllllIIIIIll) {
            this.brewingItemStacks[llllllllllllllIIIIllIllllIIIIIll] = null;
        }
    }
    
    private void brewPotions() {
        if (this.canBrew()) {
            final ItemStack llllllllllllllIIIIlllIIIIIlIIIlI = this.brewingItemStacks[3];
            for (int llllllllllllllIIIIlllIIIIIlIIIIl = 0; llllllllllllllIIIIlllIIIIIlIIIIl < 3; ++llllllllllllllIIIIlllIIIIIlIIIIl) {
                if (this.brewingItemStacks[llllllllllllllIIIIlllIIIIIlIIIIl] != null && this.brewingItemStacks[llllllllllllllIIIIlllIIIIIlIIIIl].getItem() == Items.potionitem) {
                    final int llllllllllllllIIIIlllIIIIIlIIIII = this.brewingItemStacks[llllllllllllllIIIIlllIIIIIlIIIIl].getMetadata();
                    final int llllllllllllllIIIIlllIIIIIIlllll = this.func_145936_c(llllllllllllllIIIIlllIIIIIlIIIII, llllllllllllllIIIIlllIIIIIlIIIlI);
                    final List llllllllllllllIIIIlllIIIIIIllllI = Items.potionitem.getEffects(llllllllllllllIIIIlllIIIIIlIIIII);
                    final List llllllllllllllIIIIlllIIIIIIlllIl = Items.potionitem.getEffects(llllllllllllllIIIIlllIIIIIIlllll);
                    if ((llllllllllllllIIIIlllIIIIIlIIIII <= 0 || llllllllllllllIIIIlllIIIIIIllllI != llllllllllllllIIIIlllIIIIIIlllIl) && (llllllllllllllIIIIlllIIIIIIllllI == null || (!llllllllllllllIIIIlllIIIIIIllllI.equals(llllllllllllllIIIIlllIIIIIIlllIl) && llllllllllllllIIIIlllIIIIIIlllIl != null))) {
                        if (llllllllllllllIIIIlllIIIIIlIIIII != llllllllllllllIIIIlllIIIIIIlllll) {
                            this.brewingItemStacks[llllllllllllllIIIIlllIIIIIlIIIIl].setItemDamage(llllllllllllllIIIIlllIIIIIIlllll);
                        }
                    }
                    else if (!ItemPotion.isSplash(llllllllllllllIIIIlllIIIIIlIIIII) && ItemPotion.isSplash(llllllllllllllIIIIlllIIIIIIlllll)) {
                        this.brewingItemStacks[llllllllllllllIIIIlllIIIIIlIIIIl].setItemDamage(llllllllllllllIIIIlllIIIIIIlllll);
                    }
                }
            }
            if (llllllllllllllIIIIlllIIIIIlIIIlI.getItem().hasContainerItem()) {
                this.brewingItemStacks[3] = new ItemStack(llllllllllllllIIIIlllIIIIIlIIIlI.getItem().getContainerItem());
            }
            else {
                final ItemStack itemStack = this.brewingItemStacks[3];
                --itemStack.stackSize;
                if (this.brewingItemStacks[3].stackSize <= 0) {
                    this.brewingItemStacks[3] = null;
                }
            }
        }
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllIIIIllIllllllIlIII) {
        return (llllllllllllllIIIIllIllllllIlIII >= 0 && llllllllllllllIIIIllIllllllIlIII < this.brewingItemStacks.length) ? this.brewingItemStacks[llllllllllllllIIIIllIllllllIlIII] : null;
    }
    
    @Override
    public boolean canExtractItem(final int llllllllllllllIIIIllIllllIlIIIIl, final ItemStack llllllllllllllIIIIllIllllIlIIIII, final EnumFacing llllllllllllllIIIIllIllllIIlllll) {
        return true;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIIlllIIIIIIIIIIl) {
        super.readFromNBT(llllllllllllllIIIIlllIIIIIIIIIIl);
        final NBTTagList llllllllllllllIIIIlllIIIIIIIIllI = llllllllllllllIIIIlllIIIIIIIIIIl.getTagList("Items", 10);
        this.brewingItemStacks = new ItemStack[this.getSizeInventory()];
        for (int llllllllllllllIIIIlllIIIIIIIIlIl = 0; llllllllllllllIIIIlllIIIIIIIIlIl < llllllllllllllIIIIlllIIIIIIIIllI.tagCount(); ++llllllllllllllIIIIlllIIIIIIIIlIl) {
            final NBTTagCompound llllllllllllllIIIIlllIIIIIIIIlII = llllllllllllllIIIIlllIIIIIIIIllI.getCompoundTagAt(llllllllllllllIIIIlllIIIIIIIIlIl);
            final byte llllllllllllllIIIIlllIIIIIIIIIll = llllllllllllllIIIIlllIIIIIIIIlII.getByte("Slot");
            if (llllllllllllllIIIIlllIIIIIIIIIll >= 0 && llllllllllllllIIIIlllIIIIIIIIIll < this.brewingItemStacks.length) {
                this.brewingItemStacks[llllllllllllllIIIIlllIIIIIIIIIll] = ItemStack.loadItemStackFromNBT(llllllllllllllIIIIlllIIIIIIIIlII);
            }
        }
        this.brewTime = llllllllllllllIIIIlllIIIIIIIIIIl.getShort("BrewTime");
        if (llllllllllllllIIIIlllIIIIIIIIIIl.hasKey("CustomName", 8)) {
            this.field_145942_n = llllllllllllllIIIIlllIIIIIIIIIIl.getString("CustomName");
        }
    }
    
    @Override
    public int getFieldCount() {
        return 1;
    }
    
    private int func_145936_c(final int llllllllllllllIIIIlllIIIIIIlIIII, final ItemStack llllllllllllllIIIIlllIIIIIIIllll) {
        return (llllllllllllllIIIIlllIIIIIIIllll == null) ? llllllllllllllIIIIlllIIIIIIlIIII : (llllllllllllllIIIIlllIIIIIIIllll.getItem().isPotionIngredient(llllllllllllllIIIIlllIIIIIIIllll) ? PotionHelper.applyIngredient(llllllllllllllIIIIlllIIIIIIlIIII, llllllllllllllIIIIlllIIIIIIIllll.getItem().getPotionEffect(llllllllllllllIIIIlllIIIIIIIllll)) : llllllllllllllIIIIlllIIIIIIlIIII);
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_145942_n : "container.brewing";
    }
    
    @Override
    public boolean canInsertItem(final int llllllllllllllIIIIllIllllIlIIlII, final ItemStack llllllllllllllIIIIllIllllIlIIlll, final EnumFacing llllllllllllllIIIIllIllllIlIIllI) {
        return this.isItemValidForSlot(llllllllllllllIIIIllIllllIlIIlII, llllllllllllllIIIIllIllllIlIIlll);
    }
    
    @Override
    public int getSizeInventory() {
        return this.brewingItemStacks.length;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIIIIllIllllIIllIlI, final EntityPlayer llllllllllllllIIIIllIllllIIllIIl) {
        return new ContainerBrewingStand(llllllllllllllIIIIllIllllIIllIlI, this);
    }
    
    public void func_145937_a(final String llllllllllllllIIIIlllIIIIlIlIIlI) {
        this.field_145942_n = llllllllllllllIIIIlllIIIIlIlIIlI;
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIIIIllIlllllIIIIll) {
    }
    
    @Override
    public int getField(final int llllllllllllllIIIIllIllllIIlIIll) {
        switch (llllllllllllllIIIIllIllllIIlIIll) {
            case 0: {
                return this.brewTime;
            }
            default: {
                return 0;
            }
        }
    }
    
    private boolean canBrew() {
        if (this.brewingItemStacks[3] == null || this.brewingItemStacks[3].stackSize <= 0) {
            return false;
        }
        final ItemStack llllllllllllllIIIIlllIIIIIlllIIl = this.brewingItemStacks[3];
        if (!llllllllllllllIIIIlllIIIIIlllIIl.getItem().isPotionIngredient(llllllllllllllIIIIlllIIIIIlllIIl)) {
            return false;
        }
        boolean llllllllllllllIIIIlllIIIIIlllIII = false;
        for (int llllllllllllllIIIIlllIIIIIllIlll = 0; llllllllllllllIIIIlllIIIIIllIlll < 3; ++llllllllllllllIIIIlllIIIIIllIlll) {
            if (this.brewingItemStacks[llllllllllllllIIIIlllIIIIIllIlll] != null && this.brewingItemStacks[llllllllllllllIIIIlllIIIIIllIlll].getItem() == Items.potionitem) {
                final int llllllllllllllIIIIlllIIIIIllIllI = this.brewingItemStacks[llllllllllllllIIIIlllIIIIIllIlll].getMetadata();
                final int llllllllllllllIIIIlllIIIIIllIlIl = this.func_145936_c(llllllllllllllIIIIlllIIIIIllIllI, llllllllllllllIIIIlllIIIIIlllIIl);
                if (!ItemPotion.isSplash(llllllllllllllIIIIlllIIIIIllIllI) && ItemPotion.isSplash(llllllllllllllIIIIlllIIIIIllIlIl)) {
                    llllllllllllllIIIIlllIIIIIlllIII = true;
                    break;
                }
                final List llllllllllllllIIIIlllIIIIIllIlII = Items.potionitem.getEffects(llllllllllllllIIIIlllIIIIIllIllI);
                final List llllllllllllllIIIIlllIIIIIllIIll = Items.potionitem.getEffects(llllllllllllllIIIIlllIIIIIllIlIl);
                if ((llllllllllllllIIIIlllIIIIIllIllI <= 0 || llllllllllllllIIIIlllIIIIIllIlII != llllllllllllllIIIIlllIIIIIllIIll) && (llllllllllllllIIIIlllIIIIIllIlII == null || (!llllllllllllllIIIIlllIIIIIllIlII.equals(llllllllllllllIIIIlllIIIIIllIIll) && llllllllllllllIIIIlllIIIIIllIIll != null)) && llllllllllllllIIIIlllIIIIIllIllI != llllllllllllllIIIIlllIIIIIllIlIl) {
                    llllllllllllllIIIIlllIIIIIlllIII = true;
                    break;
                }
            }
        }
        return llllllllllllllIIIIlllIIIIIlllIII;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllIIIIllIlllllIlIIII, final ItemStack llllllllllllllIIIIllIlllllIIllll) {
        if (llllllllllllllIIIIllIlllllIlIIII >= 0 && llllllllllllllIIIIllIlllllIlIIII < this.brewingItemStacks.length) {
            this.brewingItemStacks[llllllllllllllIIIIllIlllllIlIIII] = llllllllllllllIIIIllIlllllIIllll;
        }
    }
    
    @Override
    public boolean hasCustomName() {
        return this.field_145942_n != null && this.field_145942_n.length() > 0;
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllIIIIllIlllllIIIlIl) {
        return this.worldObj.getTileEntity(this.pos) == this && llllllllllllllIIIIllIlllllIIIlIl.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIIIIllIllllllIIIll, final int llllllllllllllIIIIllIllllllIIIlI) {
        if (llllllllllllllIIIIllIllllllIIIll >= 0 && llllllllllllllIIIIllIllllllIIIll < this.brewingItemStacks.length) {
            final ItemStack llllllllllllllIIIIllIllllllIIIIl = this.brewingItemStacks[llllllllllllllIIIIllIllllllIIIll];
            this.brewingItemStacks[llllllllllllllIIIIllIllllllIIIll] = null;
            return llllllllllllllIIIIllIllllllIIIIl;
        }
        return null;
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIIIIllIllllIlllIll, final ItemStack llllllllllllllIIIIllIllllIllllII) {
        return (llllllllllllllIIIIllIllllIlllIll == 3) ? llllllllllllllIIIIllIllllIllllII.getItem().isPotionIngredient(llllllllllllllIIIIllIllllIllllII) : (llllllllllllllIIIIllIllllIllllII.getItem() == Items.potionitem || llllllllllllllIIIIllIllllIllllII.getItem() == Items.glass_bottle);
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:brewing_stand";
    }
    
    @Override
    public void update() {
        if (this.brewTime > 0) {
            --this.brewTime;
            if (this.brewTime == 0) {
                this.brewPotions();
                this.markDirty();
            }
            else if (!this.canBrew()) {
                this.brewTime = 0;
                this.markDirty();
            }
            else if (this.ingredientID != this.brewingItemStacks[3].getItem()) {
                this.brewTime = 0;
                this.markDirty();
            }
        }
        else if (this.canBrew()) {
            this.brewTime = 400;
            this.ingredientID = this.brewingItemStacks[3].getItem();
        }
        if (!this.worldObj.isRemote) {
            final boolean[] llllllllllllllIIIIlllIIIIlIIlIIl = this.func_174902_m();
            if (!Arrays.equals(llllllllllllllIIIIlllIIIIlIIlIIl, this.filledSlots)) {
                this.filledSlots = llllllllllllllIIIIlllIIIIlIIlIIl;
                IBlockState llllllllllllllIIIIlllIIIIlIIlIII = this.worldObj.getBlockState(this.getPos());
                if (!(llllllllllllllIIIIlllIIIIlIIlIII.getBlock() instanceof BlockBrewingStand)) {
                    return;
                }
                for (int llllllllllllllIIIIlllIIIIlIIIlll = 0; llllllllllllllIIIIlllIIIIlIIIlll < BlockBrewingStand.BOTTLE_PROPS.length; ++llllllllllllllIIIIlllIIIIlIIIlll) {
                    llllllllllllllIIIIlllIIIIlIIlIII = llllllllllllllIIIIlllIIIIlIIlIII.withProperty(BlockBrewingStand.BOTTLE_PROPS[llllllllllllllIIIIlllIIIIlIIIlll], llllllllllllllIIIIlllIIIIlIIlIIl[llllllllllllllIIIIlllIIIIlIIIlll]);
                }
                this.worldObj.setBlockState(this.pos, llllllllllllllIIIIlllIIIIlIIlIII, 2);
            }
        }
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing llllllllllllllIIIIllIllllIlIllIl) {
        return (llllllllllllllIIIIllIllllIlIllIl == EnumFacing.UP) ? TileEntityBrewingStand.inputSlots : TileEntityBrewingStand.outputSlots;
    }
    
    public boolean[] func_174902_m() {
        final boolean[] llllllllllllllIIIIllIllllIllIlIl = new boolean[3];
        for (int llllllllllllllIIIIllIllllIllIlII = 0; llllllllllllllIIIIllIllllIllIlII < 3; ++llllllllllllllIIIIllIllllIllIlII) {
            if (this.brewingItemStacks[llllllllllllllIIIIllIllllIllIlII] != null) {
                llllllllllllllIIIIllIllllIllIlIl[llllllllllllllIIIIllIllllIllIlII] = true;
            }
        }
        return llllllllllllllIIIIllIllllIllIlIl;
    }
}
