package net.minecraft.tileentity;

import net.minecraft.server.gui.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.nbt.*;

public class TileEntityChest extends TileEntityLockable implements IUpdatePlayerListBox, IInventory
{
    public /* synthetic */ int numPlayersUsing;
    private /* synthetic */ int cachedChestType;
    private /* synthetic */ String customName;
    public /* synthetic */ float prevLidAngle;
    public /* synthetic */ boolean adjacentChestChecked;
    public /* synthetic */ float lidAngle;
    private /* synthetic */ int ticksSinceSync;
    public /* synthetic */ TileEntityChest adjacentChestXNeg;
    public /* synthetic */ TileEntityChest adjacentChestZPos;
    public /* synthetic */ TileEntityChest adjacentChestZNeg;
    public /* synthetic */ TileEntityChest adjacentChestXPos;
    private /* synthetic */ ItemStack[] chestContents;
    
    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        this.adjacentChestChecked = false;
    }
    
    private void func_174910_a(final TileEntityChest llllllllllllllIIIlIIlllIlllIlIIl, final EnumFacing llllllllllllllIIIlIIlllIlllIlIll) {
        if (llllllllllllllIIIlIIlllIlllIlIIl.isInvalid()) {
            this.adjacentChestChecked = false;
        }
        else if (this.adjacentChestChecked) {
            switch (SwitchEnumFacing.field_177366_a[llllllllllllllIIIlIIlllIlllIlIll.ordinal()]) {
                case 1: {
                    if (this.adjacentChestZNeg != llllllllllllllIIIlIIlllIlllIlIIl) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 2: {
                    if (this.adjacentChestZPos != llllllllllllllIIIlIIlllIlllIlIIl) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 3: {
                    if (this.adjacentChestXPos != llllllllllllllIIIlIIlllIlllIlIIl) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 4: {
                    if (this.adjacentChestXNeg != llllllllllllllIIIlIIlllIlllIlIIl) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllIIIlIIllllIIlIlIIl, final ItemStack llllllllllllllIIIlIIllllIIlIlIII) {
        this.chestContents[llllllllllllllIIIlIIllllIIlIlIIl] = llllllllllllllIIIlIIllllIIlIlIII;
        if (llllllllllllllIIIlIIllllIIlIlIII != null && llllllllllllllIIIlIIllllIIlIlIII.stackSize > this.getInventoryStackLimit()) {
            llllllllllllllIIIlIIllllIIlIlIII.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllllllllllIIIlIIllllIIllIlIl) {
        if (this.chestContents[llllllllllllllIIIlIIllllIIllIlIl] != null) {
            final ItemStack llllllllllllllIIIlIIllllIIllIlII = this.chestContents[llllllllllllllIIIlIIllllIIllIlIl];
            this.chestContents[llllllllllllllIIIlIIllllIIllIlIl] = null;
            return llllllllllllllIIIlIIllllIIllIlII;
        }
        return null;
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIIIlIIlllIlIIlIIlI, final ItemStack llllllllllllllIIIlIIlllIlIIlIIIl) {
        return true;
    }
    
    protected TileEntityChest func_174911_a(final EnumFacing llllllllllllllIIIlIIlllIllIllllI) {
        final BlockPos llllllllllllllIIIlIIlllIllIlllIl = this.pos.offset(llllllllllllllIIIlIIlllIllIllllI);
        if (this.func_174912_b(llllllllllllllIIIlIIlllIllIlllIl)) {
            final TileEntity llllllllllllllIIIlIIlllIllIlllII = this.worldObj.getTileEntity(llllllllllllllIIIlIIlllIllIlllIl);
            if (llllllllllllllIIIlIIlllIllIlllII instanceof TileEntityChest) {
                final TileEntityChest llllllllllllllIIIlIIlllIllIllIll = (TileEntityChest)llllllllllllllIIIlIIlllIllIlllII;
                llllllllllllllIIIlIIlllIllIllIll.func_174910_a(this, llllllllllllllIIIlIIlllIllIllllI.getOpposite());
                return llllllllllllllIIIlIIlllIllIllIll;
            }
        }
        return null;
    }
    
    private boolean func_174912_b(final BlockPos llllllllllllllIIIlIIlllIllIIlllI) {
        if (this.worldObj == null) {
            return false;
        }
        final Block llllllllllllllIIIlIIlllIllIlIIII = this.worldObj.getBlockState(llllllllllllllIIIlIIlllIllIIlllI).getBlock();
        return llllllllllllllIIIlIIlllIllIlIIII instanceof BlockChest && ((BlockChest)llllllllllllllIIIlIIlllIllIlIIII).chestType == this.getChestType();
    }
    
    @Override
    public void setField(final int llllllllllllllIIIlIIlllIIlllllIl, final int llllllllllllllIIIlIIlllIIlllllII) {
    }
    
    public void setCustomName(final String llllllllllllllIIIlIIllllIIIllllI) {
        this.customName = llllllllllllllIIIlIIllllIIIllllI;
    }
    
    @Override
    public void update() {
        this.checkForAdjacentChests();
        final int llllllllllllllIIIlIIlllIllIIIIIl = this.pos.getX();
        final int llllllllllllllIIIlIIlllIllIIIIII = this.pos.getY();
        final int llllllllllllllIIIlIIlllIlIllllll = this.pos.getZ();
        ++this.ticksSinceSync;
        if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + llllllllllllllIIIlIIlllIllIIIIIl + llllllllllllllIIIlIIlllIllIIIIII + llllllllllllllIIIlIIlllIlIllllll) % 200 == 0) {
            this.numPlayersUsing = 0;
            final float llllllllllllllIIIlIIlllIlIlllllI = 5.0f;
            final List llllllllllllllIIIlIIlllIlIllllII = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(llllllllllllllIIIlIIlllIllIIIIIl - llllllllllllllIIIlIIlllIlIlllllI, llllllllllllllIIIlIIlllIllIIIIII - llllllllllllllIIIlIIlllIlIlllllI, llllllllllllllIIIlIIlllIlIllllll - llllllllllllllIIIlIIlllIlIlllllI, llllllllllllllIIIlIIlllIllIIIIIl + 1 + llllllllllllllIIIlIIlllIlIlllllI, llllllllllllllIIIlIIlllIllIIIIII + 1 + llllllllllllllIIIlIIlllIlIlllllI, llllllllllllllIIIlIIlllIlIllllll + 1 + llllllllllllllIIIlIIlllIlIlllllI));
            for (final EntityPlayer llllllllllllllIIIlIIlllIlIlllIlI : llllllllllllllIIIlIIlllIlIllllII) {
                if (llllllllllllllIIIlIIlllIlIlllIlI.openContainer instanceof ContainerChest) {
                    final IInventory llllllllllllllIIIlIIlllIlIlllIIl = ((ContainerChest)llllllllllllllIIIlIIlllIlIlllIlI.openContainer).getLowerChestInventory();
                    if (llllllllllllllIIIlIIlllIlIlllIIl != this && (!(llllllllllllllIIIlIIlllIlIlllIIl instanceof InventoryLargeChest) || !((InventoryLargeChest)llllllllllllllIIIlIIlllIlIlllIIl).isPartOfLargeChest(this))) {
                        continue;
                    }
                    ++this.numPlayersUsing;
                }
            }
        }
        this.prevLidAngle = this.lidAngle;
        final float llllllllllllllIIIlIIlllIlIllllIl = 0.1f;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0f && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
            double llllllllllllllIIIlIIlllIlIllIllI = llllllllllllllIIIlIIlllIllIIIIIl + 0.5;
            double llllllllllllllIIIlIIlllIlIlllIII = llllllllllllllIIIlIIlllIlIllllll + 0.5;
            if (this.adjacentChestZPos != null) {
                llllllllllllllIIIlIIlllIlIlllIII += 0.5;
            }
            if (this.adjacentChestXPos != null) {
                llllllllllllllIIIlIIlllIlIllIllI += 0.5;
            }
            this.worldObj.playSoundEffect(llllllllllllllIIIlIIlllIlIllIllI, llllllllllllllIIIlIIlllIllIIIIII + 0.5, llllllllllllllIIIlIIlllIlIlllIII, "random.chestopen", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
        }
        if ((this.numPlayersUsing == 0 && this.lidAngle > 0.0f) || (this.numPlayersUsing > 0 && this.lidAngle < 1.0f)) {
            final float llllllllllllllIIIlIIlllIlIllIlIl = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += llllllllllllllIIIlIIlllIlIllllIl;
            }
            else {
                this.lidAngle -= llllllllllllllIIIlIIlllIlIllllIl;
            }
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            final float llllllllllllllIIIlIIlllIlIllIlII = 0.5f;
            if (this.lidAngle < llllllllllllllIIIlIIlllIlIllIlII && llllllllllllllIIIlIIlllIlIllIlIl >= llllllllllllllIIIlIIlllIlIllIlII && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
                double llllllllllllllIIIlIIlllIlIllIlll = llllllllllllllIIIlIIlllIllIIIIIl + 0.5;
                double llllllllllllllIIIlIIlllIlIllIIll = llllllllllllllIIIlIIlllIlIllllll + 0.5;
                if (this.adjacentChestZPos != null) {
                    llllllllllllllIIIlIIlllIlIllIIll += 0.5;
                }
                if (this.adjacentChestXPos != null) {
                    llllllllllllllIIIlIIlllIlIllIlll += 0.5;
                }
                this.worldObj.playSoundEffect(llllllllllllllIIIlIIlllIlIllIlll, llllllllllllllIIIlIIlllIllIIIIII + 0.5, llllllllllllllIIIlIIlllIlIllIIll, "random.chestclosed", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.chest";
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIIIlIIlllIlIIllIlI) {
        if (!llllllllllllllIIIlIIlllIlIIllIlI.func_175149_v()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyNeighborsOfStateChange(this.pos, this.getBlockType());
            this.worldObj.notifyNeighborsOfStateChange(this.pos.offsetDown(), this.getBlockType());
        }
    }
    
    public void checkForAdjacentChests() {
        if (!this.adjacentChestChecked) {
            this.adjacentChestChecked = true;
            this.adjacentChestXNeg = this.func_174911_a(EnumFacing.WEST);
            this.adjacentChestXPos = this.func_174911_a(EnumFacing.EAST);
            this.adjacentChestZNeg = this.func_174911_a(EnumFacing.NORTH);
            this.adjacentChestZPos = this.func_174911_a(EnumFacing.SOUTH);
        }
    }
    
    @Override
    public void clearInventory() {
        for (int llllllllllllllIIIlIIlllIIlllIlll = 0; llllllllllllllIIIlIIlllIIlllIlll < this.chestContents.length; ++llllllllllllllIIIlIIlllIIlllIlll) {
            this.chestContents[llllllllllllllIIIlIIlllIIlllIlll] = null;
        }
    }
    
    @Override
    public int getSizeInventory() {
        return 27;
    }
    
    public TileEntityChest(final int llllllllllllllIIIlIIllllIlIIlllI) {
        this.chestContents = new ItemStack[27];
        this.cachedChestType = llllllllllllllIIIlIIllllIlIIlllI;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIIIlIIlllIlIIIIlIl, final EntityPlayer llllllllllllllIIIlIIlllIlIIIIIIl) {
        return new ContainerChest(llllllllllllllIIIlIIlllIlIIIIlIl, this, llllllllllllllIIIlIIlllIlIIIIIIl);
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllIIIlIIlllIllllIlII) {
        return this.worldObj.getTileEntity(this.pos) == this && llllllllllllllIIIlIIlllIllllIlII.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    public int getChestType() {
        if (this.cachedChestType == -1) {
            if (this.worldObj == null || !(this.getBlockType() instanceof BlockChest)) {
                return 0;
            }
            this.cachedChestType = ((BlockChest)this.getBlockType()).chestType;
        }
        return this.cachedChestType;
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllIIIlIIllllIlIIIlll) {
        return this.chestContents[llllllllllllllIIIlIIllllIlIIIlll];
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIlIIllllIIIIlllI) {
        super.readFromNBT(llllllllllllllIIIlIIllllIIIIlllI);
        final NBTTagList llllllllllllllIIIlIIllllIIIlIIll = llllllllllllllIIIlIIllllIIIIlllI.getTagList("Items", 10);
        this.chestContents = new ItemStack[this.getSizeInventory()];
        if (llllllllllllllIIIlIIllllIIIIlllI.hasKey("CustomName", 8)) {
            this.customName = llllllllllllllIIIlIIllllIIIIlllI.getString("CustomName");
        }
        for (int llllllllllllllIIIlIIllllIIIlIIlI = 0; llllllllllllllIIIlIIllllIIIlIIlI < llllllllllllllIIIlIIllllIIIlIIll.tagCount(); ++llllllllllllllIIIlIIllllIIIlIIlI) {
            final NBTTagCompound llllllllllllllIIIlIIllllIIIlIIIl = llllllllllllllIIIlIIllllIIIlIIll.getCompoundTagAt(llllllllllllllIIIlIIllllIIIlIIlI);
            final int llllllllllllllIIIlIIllllIIIlIIII = llllllllllllllIIIlIIllllIIIlIIIl.getByte("Slot") & 0xFF;
            if (llllllllllllllIIIlIIllllIIIlIIII >= 0 && llllllllllllllIIIlIIllllIIIlIIII < this.chestContents.length) {
                this.chestContents[llllllllllllllIIIlIIllllIIIlIIII] = ItemStack.loadItemStackFromNBT(llllllllllllllIIIlIIllllIIIlIIIl);
            }
        }
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIIIlIIllllIIllllII, final int llllllllllllllIIIlIIllllIIlllIll) {
        if (this.chestContents[llllllllllllllIIIlIIllllIIllllII] == null) {
            return null;
        }
        if (this.chestContents[llllllllllllllIIIlIIllllIIllllII].stackSize <= llllllllllllllIIIlIIllllIIlllIll) {
            final ItemStack llllllllllllllIIIlIIllllIIllllll = this.chestContents[llllllllllllllIIIlIIllllIIllllII];
            this.chestContents[llllllllllllllIIIlIIllllIIllllII] = null;
            this.markDirty();
            return llllllllllllllIIIlIIllllIIllllll;
        }
        final ItemStack llllllllllllllIIIlIIllllIIlllllI = this.chestContents[llllllllllllllIIIlIIllllIIllllII].splitStack(llllllllllllllIIIlIIllllIIlllIll);
        if (this.chestContents[llllllllllllllIIIlIIllllIIllllII].stackSize == 0) {
            this.chestContents[llllllllllllllIIIlIIllllIIllllII] = null;
        }
        this.markDirty();
        return llllllllllllllIIIlIIllllIIlllllI;
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIIIlIIllllIIIIIIll) {
        super.writeToNBT(llllllllllllllIIIlIIllllIIIIIIll);
        final NBTTagList llllllllllllllIIIlIIllllIIIIIIlI = new NBTTagList();
        for (int llllllllllllllIIIlIIllllIIIIIIIl = 0; llllllllllllllIIIlIIllllIIIIIIIl < this.chestContents.length; ++llllllllllllllIIIlIIllllIIIIIIIl) {
            if (this.chestContents[llllllllllllllIIIlIIllllIIIIIIIl] != null) {
                final NBTTagCompound llllllllllllllIIIlIIllllIIIIIIII = new NBTTagCompound();
                llllllllllllllIIIlIIllllIIIIIIII.setByte("Slot", (byte)llllllllllllllIIIlIIllllIIIIIIIl);
                this.chestContents[llllllllllllllIIIlIIllllIIIIIIIl].writeToNBT(llllllllllllllIIIlIIllllIIIIIIII);
                llllllllllllllIIIlIIllllIIIIIIlI.appendTag(llllllllllllllIIIlIIllllIIIIIIII);
            }
        }
        llllllllllllllIIIlIIllllIIIIIIll.setTag("Items", llllllllllllllIIIlIIllllIIIIIIlI);
        if (this.hasCustomName()) {
            llllllllllllllIIIlIIllllIIIIIIll.setString("CustomName", this.customName);
        }
    }
    
    @Override
    public void invalidate() {
        super.invalidate();
        this.updateContainingBlockInfo();
        this.checkForAdjacentChests();
    }
    
    @Override
    public int getField(final int llllllllllllllIIIlIIlllIIlllllll) {
        return 0;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIIIlIIlllIlIIlIllI) {
        if (!llllllllllllllIIIlIIlllIlIIlIllI.func_175149_v() && this.getBlockType() instanceof BlockChest) {
            --this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyNeighborsOfStateChange(this.pos, this.getBlockType());
            this.worldObj.notifyNeighborsOfStateChange(this.pos.offsetDown(), this.getBlockType());
        }
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:chest";
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    static {
        __OBFID = "CL_00000346";
    }
    
    @Override
    public boolean receiveClientEvent(final int llllllllllllllIIIlIIlllIlIlIIIIl, final int llllllllllllllIIIlIIlllIlIlIIIII) {
        if (llllllllllllllIIIlIIlllIlIlIIIIl == 1) {
            this.numPlayersUsing = llllllllllllllIIIlIIlllIlIlIIIII;
            return true;
        }
        return super.receiveClientEvent(llllllllllllllIIIlIIlllIlIlIIIIl, llllllllllllllIIIlIIlllIlIlIIIII);
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public TileEntityChest() {
        this.chestContents = new ItemStack[27];
        this.cachedChestType = -1;
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_177366_a;
        
        static {
            __OBFID = "CL_00002041";
            field_177366_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_177366_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_177366_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_177366_a[EnumFacing.EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_177366_a[EnumFacing.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
