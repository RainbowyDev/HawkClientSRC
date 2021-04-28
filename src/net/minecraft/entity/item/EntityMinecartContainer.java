package net.minecraft.entity.item;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public abstract class EntityMinecartContainer extends EntityMinecart implements ILockableContainer
{
    private /* synthetic */ ItemStack[] minecartContainerItems;
    private /* synthetic */ boolean dropContentsWhenDead;
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    static {
        __OBFID = "CL_00001674";
    }
    
    @Override
    public void travelToDimension(final int lllllllllllllllllIIIIlIlIIllIIII) {
        this.dropContentsWhenDead = false;
        super.travelToDimension(lllllllllllllllllIIIIlIlIIllIIII);
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllllllIIIIlIlIlIIllII, final ItemStack lllllllllllllllllIIIIlIlIlIIlIII) {
        this.minecartContainerItems[lllllllllllllllllIIIIlIlIlIIllII] = lllllllllllllllllIIIIlIlIlIIlIII;
        if (lllllllllllllllllIIIIlIlIlIIlIII != null && lllllllllllllllllIIIIlIlIlIIlIII.stackSize > this.getInventoryStackLimit()) {
            lllllllllllllllllIIIIlIlIlIIlIII.stackSize = this.getInventoryStackLimit();
        }
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllllllIIIIlIlIllIIIIl, final int lllllllllllllllllIIIIlIlIllIIIII) {
        if (this.minecartContainerItems[lllllllllllllllllIIIIlIlIllIIIIl] == null) {
            return null;
        }
        if (this.minecartContainerItems[lllllllllllllllllIIIIlIlIllIIIIl].stackSize <= lllllllllllllllllIIIIlIlIllIIIII) {
            final ItemStack lllllllllllllllllIIIIlIlIlIlllll = this.minecartContainerItems[lllllllllllllllllIIIIlIlIllIIIIl];
            this.minecartContainerItems[lllllllllllllllllIIIIlIlIllIIIIl] = null;
            return lllllllllllllllllIIIIlIlIlIlllll;
        }
        final ItemStack lllllllllllllllllIIIIlIlIlIllllI = this.minecartContainerItems[lllllllllllllllllIIIIlIlIllIIIIl].splitStack(lllllllllllllllllIIIIlIlIllIIIII);
        if (this.minecartContainerItems[lllllllllllllllllIIIIlIlIllIIIIl].stackSize == 0) {
            this.minecartContainerItems[lllllllllllllllllIIIIlIlIllIIIIl] = null;
        }
        return lllllllllllllllllIIIIlIlIlIllllI;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllllllIIIIlIlIIllllIl) {
    }
    
    @Override
    public void setField(final int lllllllllllllllllIIIIlIIlllllIIl, final int lllllllllllllllllIIIIlIIlllllIII) {
    }
    
    @Override
    public void setDead() {
        if (this.dropContentsWhenDead) {
            InventoryHelper.func_180176_a(this.worldObj, this, this);
        }
        super.setDead();
    }
    
    @Override
    public void markDirty() {
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.getCustomNameTag() : "container.minecart";
    }
    
    @Override
    protected void applyDrag() {
        final int lllllllllllllllllIIIIlIlIIIIIIIl = 15 - Container.calcRedstoneFromInventory(this);
        final float lllllllllllllllllIIIIlIlIIIIIIII = 0.98f + lllllllllllllllllIIIIlIlIIIIIIIl * 0.001f;
        this.motionX *= lllllllllllllllllIIIIlIlIIIIIIII;
        this.motionY *= 0.0;
        this.motionZ *= lllllllllllllllllIIIIlIlIIIIIIII;
    }
    
    @Override
    public boolean isLocked() {
        return false;
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllllllIIIIlIlIIIlIllI) {
        super.readEntityFromNBT(lllllllllllllllllIIIIlIlIIIlIllI);
        final NBTTagList lllllllllllllllllIIIIlIlIIIlIlIl = lllllllllllllllllIIIIlIlIIIlIllI.getTagList("Items", 10);
        this.minecartContainerItems = new ItemStack[this.getSizeInventory()];
        for (int lllllllllllllllllIIIIlIlIIIlIlII = 0; lllllllllllllllllIIIIlIlIIIlIlII < lllllllllllllllllIIIIlIlIIIlIlIl.tagCount(); ++lllllllllllllllllIIIIlIlIIIlIlII) {
            final NBTTagCompound lllllllllllllllllIIIIlIlIIIlIIll = lllllllllllllllllIIIIlIlIIIlIlIl.getCompoundTagAt(lllllllllllllllllIIIIlIlIIIlIlII);
            final int lllllllllllllllllIIIIlIlIIIlIIlI = lllllllllllllllllIIIIlIlIIIlIIll.getByte("Slot") & 0xFF;
            if (lllllllllllllllllIIIIlIlIIIlIIlI >= 0 && lllllllllllllllllIIIIlIlIIIlIIlI < this.minecartContainerItems.length) {
                this.minecartContainerItems[lllllllllllllllllIIIIlIlIIIlIIlI] = ItemStack.loadItemStackFromNBT(lllllllllllllllllIIIIlIlIIIlIIll);
            }
        }
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllllllIIIIlIlIIlIIIIl) {
        super.writeEntityToNBT(lllllllllllllllllIIIIlIlIIlIIIIl);
        final NBTTagList lllllllllllllllllIIIIlIlIIlIIlIl = new NBTTagList();
        for (int lllllllllllllllllIIIIlIlIIlIIlII = 0; lllllllllllllllllIIIIlIlIIlIIlII < this.minecartContainerItems.length; ++lllllllllllllllllIIIIlIlIIlIIlII) {
            if (this.minecartContainerItems[lllllllllllllllllIIIIlIlIIlIIlII] != null) {
                final NBTTagCompound lllllllllllllllllIIIIlIlIIlIIIll = new NBTTagCompound();
                lllllllllllllllllIIIIlIlIIlIIIll.setByte("Slot", (byte)lllllllllllllllllIIIIlIlIIlIIlII);
                this.minecartContainerItems[lllllllllllllllllIIIIlIlIIlIIlII].writeToNBT(lllllllllllllllllIIIIlIlIIlIIIll);
                lllllllllllllllllIIIIlIlIIlIIlIl.appendTag(lllllllllllllllllIIIIlIlIIlIIIll);
            }
        }
        lllllllllllllllllIIIIlIlIIlIIIIl.setTag("Items", lllllllllllllllllIIIIlIlIIlIIlIl);
    }
    
    @Override
    public void killMinecart(final DamageSource lllllllllllllllllIIIIlIlIllIllll) {
        super.killMinecart(lllllllllllllllllIIIIlIlIllIllll);
        InventoryHelper.func_180176_a(this.worldObj, this, this);
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllllllIIIIlIlIIllllll) {
    }
    
    @Override
    public LockCode getLockCode() {
        return LockCode.EMPTY_CODE;
    }
    
    public EntityMinecartContainer(final World lllllllllllllllllIIIIlIlIlllIllI, final double lllllllllllllllllIIIIlIlIllllIlI, final double lllllllllllllllllIIIIlIlIlllIlII, final double lllllllllllllllllIIIIlIlIlllIIll) {
        super(lllllllllllllllllIIIIlIlIlllIllI, lllllllllllllllllIIIIlIlIllllIlI, lllllllllllllllllIIIIlIlIlllIlII, lllllllllllllllllIIIIlIlIlllIIll);
        this.minecartContainerItems = new ItemStack[36];
        this.dropContentsWhenDead = true;
    }
    
    @Override
    public void clearInventory() {
        for (int lllllllllllllllllIIIIlIIlllIllll = 0; lllllllllllllllllIIIIlIIlllIllll < this.minecartContainerItems.length; ++lllllllllllllllllIIIIlIIlllIllll) {
            this.minecartContainerItems[lllllllllllllllllIIIIlIIlllIllll] = null;
        }
    }
    
    public EntityMinecartContainer(final World lllllllllllllllllIIIIlIllIIIIIlI) {
        super(lllllllllllllllllIIIIlIllIIIIIlI);
        this.minecartContainerItems = new ItemStack[36];
        this.dropContentsWhenDead = true;
    }
    
    @Override
    public int getField(final int lllllllllllllllllIIIIlIIlllllIll) {
        return 0;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllllllIIIIlIlIIlllIll, final ItemStack lllllllllllllllllIIIIlIlIIlllIlI) {
        return true;
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer lllllllllllllllllIIIIlIlIlIIIIll) {
        return !this.isDead && lllllllllllllllllIIIIlIlIlIIIIll.getDistanceSqToEntity(this) <= 64.0;
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int lllllllllllllllllIIIIlIlIlIlIlIl) {
        if (this.minecartContainerItems[lllllllllllllllllIIIIlIlIlIlIlIl] != null) {
            final ItemStack lllllllllllllllllIIIIlIlIlIlIlII = this.minecartContainerItems[lllllllllllllllllIIIIlIlIlIlIlIl];
            this.minecartContainerItems[lllllllllllllllllIIIIlIlIlIlIlIl] = null;
            return lllllllllllllllllIIIIlIlIlIlIlII;
        }
        return null;
    }
    
    @Override
    public boolean interactFirst(final EntityPlayer lllllllllllllllllIIIIlIlIIIIIllI) {
        if (!this.worldObj.isRemote) {
            lllllllllllllllllIIIIlIlIIIIIllI.displayGUIChest(this);
        }
        return true;
    }
    
    @Override
    public void setLockCode(final LockCode lllllllllllllllllIIIIlIIllllIlII) {
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllllllIIIIlIlIllIlIIl) {
        return this.minecartContainerItems[lllllllllllllllllIIIIlIlIllIlIIl];
    }
}
