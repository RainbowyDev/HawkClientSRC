package net.minecraft.entity.item;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.command.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class EntityMinecartHopper extends EntityMinecartContainer implements IHopper
{
    private /* synthetic */ int transferTicker;
    private /* synthetic */ boolean isBlocked;
    private /* synthetic */ BlockPos field_174900_c;
    
    public EntityMinecartHopper(final World llllllllllllllIIllIllllIlIllIIll) {
        super(llllllllllllllIIllIllllIlIllIIll);
        this.isBlocked = true;
        this.transferTicker = -1;
        this.field_174900_c = BlockPos.ORIGIN;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:hopper";
    }
    
    @Override
    public World getWorld() {
        return this.worldObj;
    }
    
    @Override
    public double getZPos() {
        return this.posZ;
    }
    
    @Override
    public IBlockState func_180457_u() {
        return Blocks.hopper.getDefaultState();
    }
    
    @Override
    public void killMinecart(final DamageSource llllllllllllllIIllIllllIIllIIlll) {
        super.killMinecart(llllllllllllllIIllIllllIIllIIlll);
        this.dropItemWithOffset(Item.getItemFromBlock(Blocks.hopper), 1, 0.0f);
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIIllIllllIIlIllIll) {
        super.readEntityFromNBT(llllllllllllllIIllIllllIIlIllIll);
        this.transferTicker = llllllllllllllIIllIllllIIlIllIll.getInteger("TransferCooldown");
    }
    
    public boolean getBlocked() {
        return this.isBlocked;
    }
    
    public void setBlocked(final boolean llllllllllllllIIllIllllIlIIIIIll) {
        this.isBlocked = llllllllllllllIIllIllllIlIIIIIll;
    }
    
    @Override
    public double getYPos() {
        return this.posY;
    }
    
    public boolean func_96112_aD() {
        if (TileEntityHopper.func_145891_a(this)) {
            return true;
        }
        final List llllllllllllllIIllIllllIIllIllIl = this.worldObj.func_175647_a(EntityItem.class, this.getEntityBoundingBox().expand(0.25, 0.0, 0.25), IEntitySelector.selectAnything);
        if (llllllllllllllIIllIllllIIllIllIl.size() > 0) {
            TileEntityHopper.func_145898_a(this, llllllllllllllIIllIllllIIllIllIl.get(0));
        }
        return false;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.isEntityAlive() && this.getBlocked()) {
            final BlockPos llllllllllllllIIllIllllIIlllIIll = new BlockPos(this);
            if (llllllllllllllIIllIllllIIlllIIll.equals(this.field_174900_c)) {
                --this.transferTicker;
            }
            else {
                this.setTransferTicker(0);
            }
            if (!this.canTransfer()) {
                this.setTransferTicker(0);
                if (this.func_96112_aD()) {
                    this.setTransferTicker(4);
                    this.markDirty();
                }
            }
        }
    }
    
    @Override
    public boolean interactFirst(final EntityPlayer llllllllllllllIIllIllllIlIIllIlI) {
        if (!this.worldObj.isRemote) {
            llllllllllllllIIllIllllIlIIllIlI.displayGUIChest(this);
        }
        return true;
    }
    
    @Override
    public EnumMinecartType func_180456_s() {
        return EnumMinecartType.HOPPER;
    }
    
    public boolean canTransfer() {
        return this.transferTicker > 0;
    }
    
    public EntityMinecartHopper(final World llllllllllllllIIllIllllIlIlIIlIl, final double llllllllllllllIIllIllllIlIlIIlII, final double llllllllllllllIIllIllllIlIlIIIll, final double llllllllllllllIIllIllllIlIlIIlll) {
        super(llllllllllllllIIllIllllIlIlIIlIl, llllllllllllllIIllIllllIlIlIIlII, llllllllllllllIIllIllllIlIlIIIll, llllllllllllllIIllIllllIlIlIIlll);
        this.isBlocked = true;
        this.transferTicker = -1;
        this.field_174900_c = BlockPos.ORIGIN;
    }
    
    @Override
    public int getSizeInventory() {
        return 5;
    }
    
    @Override
    public void onActivatorRailPass(final int llllllllllllllIIllIllllIlIIlIIll, final int llllllllllllllIIllIllllIlIIlIIlI, final int llllllllllllllIIllIllllIlIIlIIIl, final boolean llllllllllllllIIllIllllIlIIlIIII) {
        final boolean llllllllllllllIIllIllllIlIIIllll = !llllllllllllllIIllIllllIlIIlIIII;
        if (llllllllllllllIIllIllllIlIIIllll != this.getBlocked()) {
            this.setBlocked(llllllllllllllIIllIllllIlIIIllll);
        }
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIIllIllllIIllIIIIl) {
        super.writeEntityToNBT(llllllllllllllIIllIllllIIllIIIIl);
        llllllllllllllIIllIllllIIllIIIIl.setInteger("TransferCooldown", this.transferTicker);
    }
    
    @Override
    public int getDefaultDisplayTileOffset() {
        return 1;
    }
    
    @Override
    public double getXPos() {
        return this.posX;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIIllIllllIIlIIlIlI, final EntityPlayer llllllllllllllIIllIllllIIlIIlIIl) {
        return new ContainerHopper(llllllllllllllIIllIllllIIlIIlIlI, this, llllllllllllllIIllIllllIIlIIlIIl);
    }
    
    public void setTransferTicker(final int llllllllllllllIIllIllllIIlIlIIll) {
        this.transferTicker = llllllllllllllIIllIllllIIlIlIIll;
    }
    
    static {
        __OBFID = "CL_00001676";
    }
}
