package net.minecraft.tileentity;

import net.minecraft.server.gui.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class TileEntityFurnace extends TileEntityLockable implements ISidedInventory, IUpdatePlayerListBox
{
    private /* synthetic */ int furnaceBurnTime;
    private /* synthetic */ int field_174906_k;
    private static final /* synthetic */ int[] slotsBottom;
    private /* synthetic */ ItemStack[] furnaceItemStacks;
    private /* synthetic */ String furnaceCustomName;
    private static final /* synthetic */ int[] slotsTop;
    private static final /* synthetic */ int[] slotsSides;
    private /* synthetic */ int currentItemBurnTime;
    private /* synthetic */ int field_174905_l;
    
    @Override
    public void clearInventory() {
        for (int llllllllllllllIIIlIIIlIIIlIIlIll = 0; llllllllllllllIIIlIIIlIIIlIIlIll < this.furnaceItemStacks.length; ++llllllllllllllIIIlIIIlIIIlIIlIll) {
            this.furnaceItemStacks[llllllllllllllIIIlIIIlIIIlIIlIll] = null;
        }
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIlIIIlIIllIllIIl) {
        super.readFromNBT(llllllllllllllIIIlIIIlIIllIllIIl);
        final NBTTagList llllllllllllllIIIlIIIlIIllIllIII = llllllllllllllIIIlIIIlIIllIllIIl.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
        for (int llllllllllllllIIIlIIIlIIllIlIlll = 0; llllllllllllllIIIlIIIlIIllIlIlll < llllllllllllllIIIlIIIlIIllIllIII.tagCount(); ++llllllllllllllIIIlIIIlIIllIlIlll) {
            final NBTTagCompound llllllllllllllIIIlIIIlIIllIlIllI = llllllllllllllIIIlIIIlIIllIllIII.getCompoundTagAt(llllllllllllllIIIlIIIlIIllIlIlll);
            final byte llllllllllllllIIIlIIIlIIllIlIlIl = llllllllllllllIIIlIIIlIIllIlIllI.getByte("Slot");
            if (llllllllllllllIIIlIIIlIIllIlIlIl >= 0 && llllllllllllllIIIlIIIlIIllIlIlIl < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[llllllllllllllIIIlIIIlIIllIlIlIl] = ItemStack.loadItemStackFromNBT(llllllllllllllIIIlIIIlIIllIlIllI);
            }
        }
        this.furnaceBurnTime = llllllllllllllIIIlIIIlIIllIllIIl.getShort("BurnTime");
        this.field_174906_k = llllllllllllllIIIlIIIlIIllIllIIl.getShort("CookTime");
        this.field_174905_l = llllllllllllllIIIlIIIlIIllIllIIl.getShort("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
        if (llllllllllllllIIIlIIIlIIllIllIIl.hasKey("CustomName", 8)) {
            this.furnaceCustomName = llllllllllllllIIIlIIIlIIllIllIIl.getString("CustomName");
        }
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIIIlIIIlIIlIIIlIIl) {
    }
    
    public static int getItemBurnTime(final ItemStack llllllllllllllIIIlIIIlIIlIIllIll) {
        if (llllllllllllllIIIlIIIlIIlIIllIll == null) {
            return 0;
        }
        final Item llllllllllllllIIIlIIIlIIlIIllIlI = llllllllllllllIIIlIIIlIIlIIllIll.getItem();
        if (llllllllllllllIIIlIIIlIIlIIllIlI instanceof ItemBlock && Block.getBlockFromItem(llllllllllllllIIIlIIIlIIlIIllIlI) != Blocks.air) {
            final Block llllllllllllllIIIlIIIlIIlIIllIIl = Block.getBlockFromItem(llllllllllllllIIIlIIIlIIlIIllIlI);
            if (llllllllllllllIIIlIIIlIIlIIllIIl == Blocks.wooden_slab) {
                return 150;
            }
            if (llllllllllllllIIIlIIIlIIlIIllIIl.getMaterial() == Material.wood) {
                return 300;
            }
            if (llllllllllllllIIIlIIIlIIlIIllIIl == Blocks.coal_block) {
                return 16000;
            }
        }
        return (llllllllllllllIIIlIIIlIIlIIllIlI instanceof ItemTool && ((ItemTool)llllllllllllllIIIlIIIlIIlIIllIlI).getToolMaterialName().equals("WOOD")) ? 200 : ((llllllllllllllIIIlIIIlIIlIIllIlI instanceof ItemSword && ((ItemSword)llllllllllllllIIIlIIIlIIlIIllIlI).getToolMaterialName().equals("WOOD")) ? 200 : ((llllllllllllllIIIlIIIlIIlIIllIlI instanceof ItemHoe && ((ItemHoe)llllllllllllllIIIlIIIlIIlIIllIlI).getMaterialName().equals("WOOD")) ? 200 : ((llllllllllllllIIIlIIIlIIlIIllIlI == Items.stick) ? 100 : ((llllllllllllllIIIlIIIlIIlIIllIlI == Items.coal) ? 1600 : ((llllllllllllllIIIlIIIlIIlIIllIlI == Items.lava_bucket) ? 20000 : ((llllllllllllllIIIlIIIlIIlIIllIlI == Item.getItemFromBlock(Blocks.sapling)) ? 100 : ((llllllllllllllIIIlIIIlIIlIIllIlI == Items.blaze_rod) ? 2400 : 0)))))));
    }
    
    @Override
    public boolean canExtractItem(final int llllllllllllllIIIlIIIlIIIllIlIlI, final ItemStack llllllllllllllIIIlIIIlIIIllIlIIl, final EnumFacing llllllllllllllIIIlIIIlIIIllIllII) {
        if (llllllllllllllIIIlIIIlIIIllIllII == EnumFacing.DOWN && llllllllllllllIIIlIIIlIIIllIlIlI == 1) {
            final Item llllllllllllllIIIlIIIlIIIllIlIll = llllllllllllllIIIlIIIlIIIllIlIIl.getItem();
            if (llllllllllllllIIIlIIIlIIIllIlIll != Items.water_bucket && llllllllllllllIIIlIIIlIIIllIlIll != Items.bucket) {
                return false;
            }
        }
        return true;
    }
    
    public void setCustomInventoryName(final String llllllllllllllIIIlIIIlIIlllIIIIl) {
        this.furnaceCustomName = llllllllllllllIIIlIIIlIIlllIIIIl;
    }
    
    @Override
    public int getField(final int llllllllllllllIIIlIIIlIIIlIllIIl) {
        switch (llllllllllllllIIIlIIIlIIIlIllIIl) {
            case 0: {
                return this.furnaceBurnTime;
            }
            case 1: {
                return this.currentItemBurnTime;
            }
            case 2: {
                return this.field_174906_k;
            }
            case 3: {
                return this.field_174905_l;
            }
            default: {
                return 0;
            }
        }
    }
    
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIIIlIIIlIIlIIIlIll) {
    }
    
    @Override
    public void setField(final int llllllllllllllIIIlIIIlIIIlIlIIIl, final int llllllllllllllIIIlIIIlIIIlIlIIII) {
        switch (llllllllllllllIIIlIIIlIIIlIlIIIl) {
            case 0: {
                this.furnaceBurnTime = llllllllllllllIIIlIIIlIIIlIlIIII;
                break;
            }
            case 1: {
                this.currentItemBurnTime = llllllllllllllIIIlIIIlIIIlIlIIII;
                break;
            }
            case 2: {
                this.field_174906_k = llllllllllllllIIIlIIIlIIIlIlIIII;
                break;
            }
            case 3: {
                this.field_174905_l = llllllllllllllIIIlIIIlIIIlIlIIII;
                break;
            }
        }
    }
    
    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        }
        final ItemStack llllllllllllllIIIlIIIlIIlIlIIlll = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0]);
        return llllllllllllllIIIlIIIlIIlIlIIlll != null && (this.furnaceItemStacks[2] == null || (this.furnaceItemStacks[2].isItemEqual(llllllllllllllIIIlIIIlIIlIlIIlll) && ((this.furnaceItemStacks[2].stackSize < this.getInventoryStackLimit() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize()) || this.furnaceItemStacks[2].stackSize < llllllllllllllIIIlIIIlIIlIlIIlll.getMaxStackSize())));
    }
    
    static {
        __OBFID = "CL_00000357";
        slotsTop = new int[1];
        slotsBottom = new int[] { 2, 1 };
        slotsSides = new int[] { 1 };
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIIIlIIIlIIlIIIIIll, final ItemStack llllllllllllllIIIlIIIlIIlIIIIlII) {
        return llllllllllllllIIIlIIIlIIlIIIIIll != 2 && (llllllllllllllIIIlIIIlIIlIIIIIll != 1 || isItemFuel(llllllllllllllIIIlIIIlIIlIIIIlII) || SlotFurnaceFuel.func_178173_c_(llllllllllllllIIIlIIIlIIlIIIIlII));
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.furnaceCustomName : "container.furnace";
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllIIIlIIIlIIlIIIllIl) {
        return this.worldObj.getTileEntity(this.pos) == this && llllllllllllllIIIlIIIlIIlIIIllIl.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:furnace";
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllIIIlIIIlIlIIIIllll) {
        return this.furnaceItemStacks[llllllllllllllIIIlIIIlIlIIIIllll];
    }
    
    @Override
    public boolean canInsertItem(final int llllllllllllllIIIlIIIlIIIllllIIl, final ItemStack llllllllllllllIIIlIIIlIIIlllIlII, final EnumFacing llllllllllllllIIIlIIIlIIIlllIlll) {
        return this.isItemValidForSlot(llllllllllllllIIIlIIIlIIIllllIIl, llllllllllllllIIIlIIIlIIIlllIlII);
    }
    
    public int func_174904_a(final ItemStack llllllllllllllIIIlIIIlIIlIlIlIll) {
        return 200;
    }
    
    @Override
    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing llllllllllllllIIIlIIIlIIIlllllll) {
        return (llllllllllllllIIIlIIIlIIIlllllll == EnumFacing.DOWN) ? TileEntityFurnace.slotsBottom : ((llllllllllllllIIIlIIIlIIIlllllll == EnumFacing.UP) ? TileEntityFurnace.slotsTop : TileEntityFurnace.slotsSides);
    }
    
    public static boolean func_174903_a(final IInventory llllllllllllllIIIlIIIlIIlIlllIlI) {
        return llllllllllllllIIIlIIIlIIlIlllIlI.getField(0) > 0;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.furnaceCustomName != null && this.furnaceCustomName.length() > 0;
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIIIlIIIlIIllIIlIII) {
        super.writeToNBT(llllllllllllllIIIlIIIlIIllIIlIII);
        llllllllllllllIIIlIIIlIIllIIlIII.setShort("BurnTime", (short)this.furnaceBurnTime);
        llllllllllllllIIIlIIIlIIllIIlIII.setShort("CookTime", (short)this.field_174906_k);
        llllllllllllllIIIlIIIlIIllIIlIII.setShort("CookTimeTotal", (short)this.field_174905_l);
        final NBTTagList llllllllllllllIIIlIIIlIIllIIIlll = new NBTTagList();
        for (int llllllllllllllIIIlIIIlIIllIIIllI = 0; llllllllllllllIIIlIIIlIIllIIIllI < this.furnaceItemStacks.length; ++llllllllllllllIIIlIIIlIIllIIIllI) {
            if (this.furnaceItemStacks[llllllllllllllIIIlIIIlIIllIIIllI] != null) {
                final NBTTagCompound llllllllllllllIIIlIIIlIIllIIIlIl = new NBTTagCompound();
                llllllllllllllIIIlIIIlIIllIIIlIl.setByte("Slot", (byte)llllllllllllllIIIlIIIlIIllIIIllI);
                this.furnaceItemStacks[llllllllllllllIIIlIIIlIIllIIIllI].writeToNBT(llllllllllllllIIIlIIIlIIllIIIlIl);
                llllllllllllllIIIlIIIlIIllIIIlll.appendTag(llllllllllllllIIIlIIIlIIllIIIlIl);
            }
        }
        llllllllllllllIIIlIIIlIIllIIlIII.setTag("Items", llllllllllllllIIIlIIIlIIllIIIlll);
        if (this.hasCustomName()) {
            llllllllllllllIIIlIIIlIIllIIlIII.setString("CustomName", this.furnaceCustomName);
        }
    }
    
    @Override
    public void update() {
        final boolean llllllllllllllIIIlIIIlIIlIllIIll = this.isBurning();
        boolean llllllllllllllIIIlIIIlIIlIllIIlI = false;
        if (this.isBurning()) {
            --this.furnaceBurnTime;
        }
        if (!this.worldObj.isRemote) {
            if (!this.isBurning() && (this.furnaceItemStacks[1] == null || this.furnaceItemStacks[0] == null)) {
                if (!this.isBurning() && this.field_174906_k > 0) {
                    this.field_174906_k = MathHelper.clamp_int(this.field_174906_k - 2, 0, this.field_174905_l);
                }
            }
            else {
                if (!this.isBurning() && this.canSmelt()) {
                    final int itemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
                    this.furnaceBurnTime = itemBurnTime;
                    this.currentItemBurnTime = itemBurnTime;
                    if (this.isBurning()) {
                        llllllllllllllIIIlIIIlIIlIllIIlI = true;
                        if (this.furnaceItemStacks[1] != null) {
                            final ItemStack itemStack = this.furnaceItemStacks[1];
                            --itemStack.stackSize;
                            if (this.furnaceItemStacks[1].stackSize == 0) {
                                final Item llllllllllllllIIIlIIIlIIlIllIIIl = this.furnaceItemStacks[1].getItem().getContainerItem();
                                this.furnaceItemStacks[1] = ((llllllllllllllIIIlIIIlIIlIllIIIl != null) ? new ItemStack(llllllllllllllIIIlIIIlIIlIllIIIl) : null);
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt()) {
                    ++this.field_174906_k;
                    if (this.field_174906_k == this.field_174905_l) {
                        this.field_174906_k = 0;
                        this.field_174905_l = this.func_174904_a(this.furnaceItemStacks[0]);
                        this.smeltItem();
                        llllllllllllllIIIlIIIlIIlIllIIlI = true;
                    }
                }
                else {
                    this.field_174906_k = 0;
                }
            }
            if (llllllllllllllIIIlIIIlIIlIllIIll != this.isBurning()) {
                llllllllllllllIIIlIIIlIIlIllIIlI = true;
                BlockFurnace.func_176446_a(this.isBurning(), this.worldObj, this.pos);
            }
        }
        if (llllllllllllllIIIlIIIlIIlIllIIlI) {
            this.markDirty();
        }
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public void smeltItem() {
        if (this.canSmelt()) {
            final ItemStack llllllllllllllIIIlIIIlIIlIlIIIIl = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0]);
            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = llllllllllllllIIIlIIIlIIlIlIIIIl.copy();
            }
            else if (this.furnaceItemStacks[2].getItem() == llllllllllllllIIIlIIIlIIlIlIIIIl.getItem()) {
                final ItemStack itemStack = this.furnaceItemStacks[2];
                ++itemStack.stackSize;
            }
            if (this.furnaceItemStacks[0].getItem() == Item.getItemFromBlock(Blocks.sponge) && this.furnaceItemStacks[0].getMetadata() == 1 && this.furnaceItemStacks[1] != null && this.furnaceItemStacks[1].getItem() == Items.bucket) {
                this.furnaceItemStacks[1] = new ItemStack(Items.water_bucket);
            }
            final ItemStack itemStack2 = this.furnaceItemStacks[0];
            --itemStack2.stackSize;
            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
            }
        }
    }
    
    @Override
    public int getFieldCount() {
        return 4;
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllllllllllIIIlIIIlIIlllllIlI) {
        if (this.furnaceItemStacks[llllllllllllllIIIlIIIlIIlllllIlI] != null) {
            final ItemStack llllllllllllllIIIlIIIlIIllllllII = this.furnaceItemStacks[llllllllllllllIIIlIIIlIIlllllIlI];
            this.furnaceItemStacks[llllllllllllllIIIlIIIlIIlllllIlI] = null;
            return llllllllllllllIIIlIIIlIIllllllII;
        }
        return null;
    }
    
    public TileEntityFurnace() {
        this.furnaceItemStacks = new ItemStack[3];
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIIIlIIIlIlIIIIlIIl, final int llllllllllllllIIIlIIIlIlIIIIlIII) {
        if (this.furnaceItemStacks[llllllllllllllIIIlIIIlIlIIIIlIIl] == null) {
            return null;
        }
        if (this.furnaceItemStacks[llllllllllllllIIIlIIIlIlIIIIlIIl].stackSize <= llllllllllllllIIIlIIIlIlIIIIlIII) {
            final ItemStack llllllllllllllIIIlIIIlIlIIIIIlll = this.furnaceItemStacks[llllllllllllllIIIlIIIlIlIIIIlIIl];
            this.furnaceItemStacks[llllllllllllllIIIlIIIlIlIIIIlIIl] = null;
            return llllllllllllllIIIlIIIlIlIIIIIlll;
        }
        final ItemStack llllllllllllllIIIlIIIlIlIIIIIllI = this.furnaceItemStacks[llllllllllllllIIIlIIIlIlIIIIlIIl].splitStack(llllllllllllllIIIlIIIlIlIIIIlIII);
        if (this.furnaceItemStacks[llllllllllllllIIIlIIIlIlIIIIlIIl].stackSize == 0) {
            this.furnaceItemStacks[llllllllllllllIIIlIIIlIlIIIIlIIl] = null;
        }
        return llllllllllllllIIIlIIIlIlIIIIIllI;
    }
    
    public static boolean isItemFuel(final ItemStack llllllllllllllIIIlIIIlIIlIIlIIll) {
        return getItemBurnTime(llllllllllllllIIIlIIIlIIlIIlIIll) > 0;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllIIIlIIIlIIllllIIll, final ItemStack llllllllllllllIIIlIIIlIIllllIIlI) {
        final boolean llllllllllllllIIIlIIIlIIllllIIIl = llllllllllllllIIIlIIIlIIllllIIlI != null && llllllllllllllIIIlIIIlIIllllIIlI.isItemEqual(this.furnaceItemStacks[llllllllllllllIIIlIIIlIIllllIIll]) && ItemStack.areItemStackTagsEqual(llllllllllllllIIIlIIIlIIllllIIlI, this.furnaceItemStacks[llllllllllllllIIIlIIIlIIllllIIll]);
        this.furnaceItemStacks[llllllllllllllIIIlIIIlIIllllIIll] = llllllllllllllIIIlIIIlIIllllIIlI;
        if (llllllllllllllIIIlIIIlIIllllIIlI != null && llllllllllllllIIIlIIIlIIllllIIlI.stackSize > this.getInventoryStackLimit()) {
            llllllllllllllIIIlIIIlIIllllIIlI.stackSize = this.getInventoryStackLimit();
        }
        if (llllllllllllllIIIlIIIlIIllllIIll == 0 && !llllllllllllllIIIlIIIlIIllllIIIl) {
            this.field_174905_l = this.func_174904_a(llllllllllllllIIIlIIIlIIllllIIlI);
            this.field_174906_k = 0;
            this.markDirty();
        }
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIIIlIIIlIIIllIIIlI, final EntityPlayer llllllllllllllIIIlIIIlIIIllIIIIl) {
        return new ContainerFurnace(llllllllllllllIIIlIIIlIIIllIIIlI, this);
    }
}
