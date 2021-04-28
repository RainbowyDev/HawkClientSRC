package net.minecraft.inventory;

import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;

public class InventoryEnderChest extends InventoryBasic
{
    private /* synthetic */ TileEntityEnderChest associatedChest;
    
    public void setChestTileEntity(final TileEntityEnderChest lIIlllIlIlllIll) {
        this.associatedChest = lIIlllIlIlllIll;
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer lIIlllIlIIllIIl) {
        return (this.associatedChest == null || this.associatedChest.func_145971_a(lIIlllIlIIllIIl)) && super.isUseableByPlayer(lIIlllIlIIllIIl);
    }
    
    static {
        __OBFID = "CL_00001759";
    }
    
    public NBTTagList saveInventoryToNBT() {
        final NBTTagList lIIlllIlIlIIlIl = new NBTTagList();
        for (int lIIlllIlIlIIlII = 0; lIIlllIlIlIIlII < this.getSizeInventory(); ++lIIlllIlIlIIlII) {
            final ItemStack lIIlllIlIlIIIll = this.getStackInSlot(lIIlllIlIlIIlII);
            if (lIIlllIlIlIIIll != null) {
                final NBTTagCompound lIIlllIlIlIIIlI = new NBTTagCompound();
                lIIlllIlIlIIIlI.setByte("Slot", (byte)lIIlllIlIlIIlII);
                lIIlllIlIlIIIll.writeToNBT(lIIlllIlIlIIIlI);
                lIIlllIlIlIIlIl.appendTag(lIIlllIlIlIIIlI);
            }
        }
        return lIIlllIlIlIIlIl;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lIIlllIlIIIllIl) {
        if (this.associatedChest != null) {
            this.associatedChest.func_145970_b();
        }
        super.closeInventory(lIIlllIlIIIllIl);
        this.associatedChest = null;
    }
    
    public InventoryEnderChest() {
        super("container.enderchest", false, 27);
    }
    
    public void loadInventoryFromNBT(final NBTTagList lIIlllIlIllIlII) {
        for (int lIIlllIlIllIIll = 0; lIIlllIlIllIIll < this.getSizeInventory(); ++lIIlllIlIllIIll) {
            this.setInventorySlotContents(lIIlllIlIllIIll, null);
        }
        for (int lIIlllIlIllIIll = 0; lIIlllIlIllIIll < lIIlllIlIllIlII.tagCount(); ++lIIlllIlIllIIll) {
            final NBTTagCompound lIIlllIlIllIIlI = lIIlllIlIllIlII.getCompoundTagAt(lIIlllIlIllIIll);
            final int lIIlllIlIllIIIl = lIIlllIlIllIIlI.getByte("Slot") & 0xFF;
            if (lIIlllIlIllIIIl >= 0 && lIIlllIlIllIIIl < this.getSizeInventory()) {
                this.setInventorySlotContents(lIIlllIlIllIIIl, ItemStack.loadItemStackFromNBT(lIIlllIlIllIIlI));
            }
        }
    }
    
    @Override
    public void openInventory(final EntityPlayer lIIlllIlIIlIIll) {
        if (this.associatedChest != null) {
            this.associatedChest.func_145969_a();
        }
        super.openInventory(lIIlllIlIIlIIll);
    }
}
