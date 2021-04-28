package net.minecraft.tileentity;

import net.minecraft.world.*;
import net.minecraft.server.gui.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;

public class TileEntityEnchantmentTable extends TileEntity implements IInteractionObject, IUpdatePlayerListBox
{
    public /* synthetic */ int tickCount;
    public /* synthetic */ float bookRotation;
    public /* synthetic */ float field_145929_l;
    private /* synthetic */ String field_145922_s;
    public /* synthetic */ float field_145932_k;
    public /* synthetic */ float bookRotationPrev;
    public /* synthetic */ float bookSpreadPrev;
    public /* synthetic */ float pageFlip;
    public /* synthetic */ float field_145924_q;
    public /* synthetic */ float bookSpread;
    public /* synthetic */ float pageFlipPrev;
    private static /* synthetic */ Random field_145923_r;
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_145922_s : "container.enchant";
    }
    
    public void func_145920_a(final String llllllllllllllllIllIllIlIlIIIlll) {
        this.field_145922_s = llllllllllllllllIllIllIlIlIIIlll;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllllIllIllIlIllIIlIl) {
        super.readFromNBT(llllllllllllllllIllIllIlIllIIlIl);
        if (llllllllllllllllIllIllIlIllIIlIl.hasKey("CustomName", 8)) {
            this.field_145922_s = llllllllllllllllIllIllIlIllIIlIl.getString("CustomName");
        }
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllllIllIllIlIIlllIll, final EntityPlayer llllllllllllllllIllIllIlIIllllIl) {
        return new ContainerEnchantment(llllllllllllllllIllIllIlIIlllIll, this.worldObj, this.pos);
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:enchanting_table";
    }
    
    @Override
    public boolean hasCustomName() {
        return this.field_145922_s != null && this.field_145922_s.length() > 0;
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllllIllIllIlIllIllIl) {
        super.writeToNBT(llllllllllllllllIllIllIlIllIllIl);
        if (this.hasCustomName()) {
            llllllllllllllllIllIllIlIllIllIl.setString("CustomName", this.field_145922_s);
        }
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public void update() {
        this.bookSpreadPrev = this.bookSpread;
        this.bookRotationPrev = this.bookRotation;
        final EntityPlayer llllllllllllllllIllIllIlIlIlllIl = this.worldObj.getClosestPlayer(this.pos.getX() + 0.5f, this.pos.getY() + 0.5f, this.pos.getZ() + 0.5f, 3.0);
        if (llllllllllllllllIllIllIlIlIlllIl != null) {
            final double llllllllllllllllIllIllIlIlIlllII = llllllllllllllllIllIllIlIlIlllIl.posX - (this.pos.getX() + 0.5f);
            final double llllllllllllllllIllIllIlIlIllIll = llllllllllllllllIllIllIlIlIlllIl.posZ - (this.pos.getZ() + 0.5f);
            this.field_145924_q = (float)Math.atan2(llllllllllllllllIllIllIlIlIllIll, llllllllllllllllIllIllIlIlIlllII);
            this.bookSpread += 0.1f;
            if (this.bookSpread < 0.5f || TileEntityEnchantmentTable.field_145923_r.nextInt(40) == 0) {
                final float llllllllllllllllIllIllIlIlIllIlI = this.field_145932_k;
                do {
                    this.field_145932_k += TileEntityEnchantmentTable.field_145923_r.nextInt(4) - TileEntityEnchantmentTable.field_145923_r.nextInt(4);
                } while (llllllllllllllllIllIllIlIlIllIlI == this.field_145932_k);
            }
        }
        else {
            this.field_145924_q += 0.02f;
            this.bookSpread -= 0.1f;
        }
        while (this.bookRotation >= 3.1415927f) {
            this.bookRotation -= 6.2831855f;
        }
        while (this.bookRotation < -3.1415927f) {
            this.bookRotation += 6.2831855f;
        }
        while (this.field_145924_q >= 3.1415927f) {
            this.field_145924_q -= 6.2831855f;
        }
        while (this.field_145924_q < -3.1415927f) {
            this.field_145924_q += 6.2831855f;
        }
        float llllllllllllllllIllIllIlIlIllIIl;
        for (llllllllllllllllIllIllIlIlIllIIl = this.field_145924_q - this.bookRotation; llllllllllllllllIllIllIlIlIllIIl >= 3.1415927f; llllllllllllllllIllIllIlIlIllIIl -= 6.2831855f) {}
        while (llllllllllllllllIllIllIlIlIllIIl < -3.1415927f) {
            llllllllllllllllIllIllIlIlIllIIl += 6.2831855f;
        }
        this.bookRotation += llllllllllllllllIllIllIlIlIllIIl * 0.4f;
        this.bookSpread = MathHelper.clamp_float(this.bookSpread, 0.0f, 1.0f);
        ++this.tickCount;
        this.pageFlipPrev = this.pageFlip;
        float llllllllllllllllIllIllIlIlIllIII = (this.field_145932_k - this.pageFlip) * 0.4f;
        final float llllllllllllllllIllIllIlIlIlIlll = 0.2f;
        llllllllllllllllIllIllIlIlIllIII = MathHelper.clamp_float(llllllllllllllllIllIllIlIlIllIII, -llllllllllllllllIllIllIlIlIlIlll, llllllllllllllllIllIllIlIlIlIlll);
        this.field_145929_l += (llllllllllllllllIllIllIlIlIllIII - this.field_145929_l) * 0.9f;
        this.pageFlip += this.field_145929_l;
    }
    
    static {
        __OBFID = "CL_00000354";
        TileEntityEnchantmentTable.field_145923_r = new Random();
    }
}
