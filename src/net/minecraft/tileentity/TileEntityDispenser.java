package net.minecraft.tileentity;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class TileEntityDispenser extends TileEntityLockable implements IInventory
{
    private static final /* synthetic */ Random field_174913_f;
    protected /* synthetic */ String field_146020_a;
    private /* synthetic */ ItemStack[] field_146022_i;
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIIIIllIllIlIIllIII) {
        super.writeToNBT(llllllllllllllIIIIllIllIlIIllIII);
        final NBTTagList llllllllllllllIIIIllIllIlIIlIlll = new NBTTagList();
        for (int llllllllllllllIIIIllIllIlIIlIllI = 0; llllllllllllllIIIIllIllIlIIlIllI < this.field_146022_i.length; ++llllllllllllllIIIIllIllIlIIlIllI) {
            if (this.field_146022_i[llllllllllllllIIIIllIllIlIIlIllI] != null) {
                final NBTTagCompound llllllllllllllIIIIllIllIlIIlIlIl = new NBTTagCompound();
                llllllllllllllIIIIllIllIlIIlIlIl.setByte("Slot", (byte)llllllllllllllIIIIllIllIlIIlIllI);
                this.field_146022_i[llllllllllllllIIIIllIllIlIIlIllI].writeToNBT(llllllllllllllIIIIllIllIlIIlIlIl);
                llllllllllllllIIIIllIllIlIIlIlll.appendTag(llllllllllllllIIIIllIllIlIIlIlIl);
            }
        }
        llllllllllllllIIIIllIllIlIIllIII.setTag("Items", llllllllllllllIIIIllIllIlIIlIlll);
        if (this.hasCustomName()) {
            llllllllllllllIIIIllIllIlIIllIII.setString("CustomName", this.field_146020_a);
        }
    }
    
    @Override
    public int getField(final int llllllllllllllIIIIllIllIIllllIII) {
        return 0;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIIIIllIllIlllIIllI, final int llllllllllllllIIIIllIllIlllIlIlI) {
        if (this.field_146022_i[llllllllllllllIIIIllIllIlllIIllI] == null) {
            return null;
        }
        if (this.field_146022_i[llllllllllllllIIIIllIllIlllIIllI].stackSize <= llllllllllllllIIIIllIllIlllIlIlI) {
            final ItemStack llllllllllllllIIIIllIllIlllIlIIl = this.field_146022_i[llllllllllllllIIIIllIllIlllIIllI];
            this.field_146022_i[llllllllllllllIIIIllIllIlllIIllI] = null;
            this.markDirty();
            return llllllllllllllIIIIllIllIlllIlIIl;
        }
        final ItemStack llllllllllllllIIIIllIllIlllIlIII = this.field_146022_i[llllllllllllllIIIIllIllIlllIIllI].splitStack(llllllllllllllIIIIllIllIlllIlIlI);
        if (this.field_146022_i[llllllllllllllIIIIllIllIlllIIllI].stackSize == 0) {
            this.field_146022_i[llllllllllllllIIIIllIllIlllIIllI] = null;
        }
        this.markDirty();
        return llllllllllllllIIIIllIllIlllIlIII;
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllIIIIllIllIllllIIll) {
        return this.field_146022_i[llllllllllllllIIIIllIllIllllIIll];
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIIIIllIllIlIIIIIll, final ItemStack llllllllllllllIIIIllIllIlIIIIIlI) {
        return true;
    }
    
    public int func_146017_i() {
        int llllllllllllllIIIIllIllIllIlIlIl = -1;
        int llllllllllllllIIIIllIllIllIlIlII = 1;
        for (int llllllllllllllIIIIllIllIllIlIIll = 0; llllllllllllllIIIIllIllIllIlIIll < this.field_146022_i.length; ++llllllllllllllIIIIllIllIllIlIIll) {
            if (this.field_146022_i[llllllllllllllIIIIllIllIllIlIIll] != null && TileEntityDispenser.field_174913_f.nextInt(llllllllllllllIIIIllIllIllIlIlII++) == 0) {
                llllllllllllllIIIIllIllIllIlIlIl = llllllllllllllIIIIllIllIllIlIIll;
            }
        }
        return llllllllllllllIIIIllIllIllIlIlIl;
    }
    
    public TileEntityDispenser() {
        this.field_146022_i = new ItemStack[9];
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIIllIllIlIlIlIIl) {
        super.readFromNBT(llllllllllllllIIIIllIllIlIlIlIIl);
        final NBTTagList llllllllllllllIIIIllIllIlIlIlIII = llllllllllllllIIIIllIllIlIlIlIIl.getTagList("Items", 10);
        this.field_146022_i = new ItemStack[this.getSizeInventory()];
        for (int llllllllllllllIIIIllIllIlIlIIlll = 0; llllllllllllllIIIIllIllIlIlIIlll < llllllllllllllIIIIllIllIlIlIlIII.tagCount(); ++llllllllllllllIIIIllIllIlIlIIlll) {
            final NBTTagCompound llllllllllllllIIIIllIllIlIlIIllI = llllllllllllllIIIIllIllIlIlIlIII.getCompoundTagAt(llllllllllllllIIIIllIllIlIlIIlll);
            final int llllllllllllllIIIIllIllIlIlIIlIl = llllllllllllllIIIIllIllIlIlIIllI.getByte("Slot") & 0xFF;
            if (llllllllllllllIIIIllIllIlIlIIlIl >= 0 && llllllllllllllIIIIllIllIlIlIIlIl < this.field_146022_i.length) {
                this.field_146022_i[llllllllllllllIIIIllIllIlIlIIlIl] = ItemStack.loadItemStackFromNBT(llllllllllllllIIIIllIllIlIlIIllI);
            }
        }
        if (llllllllllllllIIIIllIllIlIlIlIIl.hasKey("CustomName", 8)) {
            this.field_146020_a = llllllllllllllIIIIllIllIlIlIlIIl.getString("CustomName");
        }
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIIIIllIllIlIIIIlll) {
    }
    
    @Override
    public int getSizeInventory() {
        return 9;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public void clearInventory() {
        for (int llllllllllllllIIIIllIllIIlllIIII = 0; llllllllllllllIIIIllIllIIlllIIII < this.field_146022_i.length; ++llllllllllllllIIIIllIllIIlllIIII) {
            this.field_146022_i[llllllllllllllIIIIllIllIIlllIIII] = null;
        }
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_146020_a : "container.dispenser";
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIIIIllIllIIllllIlI, final EntityPlayer llllllllllllllIIIIllIllIIlllllII) {
        return new ContainerDispenser(llllllllllllllIIIIllIllIIllllIlI, this);
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllllllllllIIIIllIllIllIlllII) {
        if (this.field_146022_i[llllllllllllllIIIIllIllIllIlllII] != null) {
            final ItemStack llllllllllllllIIIIllIllIllIllllI = this.field_146022_i[llllllllllllllIIIIllIllIllIlllII];
            this.field_146022_i[llllllllllllllIIIIllIllIllIlllII] = null;
            return llllllllllllllIIIIllIllIllIllllI;
        }
        return null;
    }
    
    public int func_146019_a(final ItemStack llllllllllllllIIIIllIllIlIlllllI) {
        for (int llllllllllllllIIIIllIllIllIIIIII = 0; llllllllllllllIIIIllIllIllIIIIII < this.field_146022_i.length; ++llllllllllllllIIIIllIllIllIIIIII) {
            if (this.field_146022_i[llllllllllllllIIIIllIllIllIIIIII] == null || this.field_146022_i[llllllllllllllIIIIllIllIllIIIIII].getItem() == null) {
                this.setInventorySlotContents(llllllllllllllIIIIllIllIllIIIIII, llllllllllllllIIIIllIllIlIlllllI);
                return llllllllllllllIIIIllIllIllIIIIII;
            }
        }
        return -1;
    }
    
    static {
        __OBFID = "CL_00000352";
        field_174913_f = new Random();
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:dispenser";
    }
    
    @Override
    public boolean hasCustomName() {
        return this.field_146020_a != null;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllIIIIllIllIllIIIlll, final ItemStack llllllllllllllIIIIllIllIllIIIllI) {
        this.field_146022_i[llllllllllllllIIIIllIllIllIIIlll] = llllllllllllllIIIIllIllIllIIIllI;
        if (llllllllllllllIIIIllIllIllIIIllI != null && llllllllllllllIIIIllIllIllIIIllI.stackSize > this.getInventoryStackLimit()) {
            llllllllllllllIIIIllIllIllIIIllI.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllllllllllIIIIllIllIlIIIlIll) {
        return this.worldObj.getTileEntity(this.pos) == this && llllllllllllllIIIIllIllIlIIIlIll.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIIIIllIllIlIIIIlIl) {
    }
    
    @Override
    public void setField(final int llllllllllllllIIIIllIllIIlllIllI, final int llllllllllllllIIIIllIllIIlllIlIl) {
    }
    
    public void func_146018_a(final String llllllllllllllIIIIllIllIlIllIlII) {
        this.field_146020_a = llllllllllllllIIIIllIllIlIllIlII;
    }
}
