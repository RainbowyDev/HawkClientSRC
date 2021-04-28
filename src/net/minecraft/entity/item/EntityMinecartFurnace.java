package net.minecraft.entity.item;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;

public class EntityMinecartFurnace extends EntityMinecart
{
    private /* synthetic */ int fuel;
    public /* synthetic */ double pushX;
    public /* synthetic */ double pushZ;
    
    public EntityMinecartFurnace(final World llllllllllllllIIlIIIlIIIIlIlIIll) {
        super(llllllllllllllIIlIIIlIIIIlIlIIll);
    }
    
    static {
        __OBFID = "CL_00001675";
    }
    
    protected boolean isMinecartPowered() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    @Override
    protected double func_174898_m() {
        return 0.2;
    }
    
    @Override
    protected void applyDrag() {
        double llllllllllllllIIlIIIlIIIIIlIIIlI = this.pushX * this.pushX + this.pushZ * this.pushZ;
        if (llllllllllllllIIlIIIlIIIIIlIIIlI > 1.0E-4) {
            llllllllllllllIIlIIIlIIIIIlIIIlI = MathHelper.sqrt_double(llllllllllllllIIlIIIlIIIIIlIIIlI);
            this.pushX /= llllllllllllllIIlIIIlIIIIIlIIIlI;
            this.pushZ /= llllllllllllllIIlIIIlIIIIIlIIIlI;
            final double llllllllllllllIIlIIIlIIIIIlIIIIl = 1.0;
            this.motionX *= 0.800000011920929;
            this.motionY *= 0.0;
            this.motionZ *= 0.800000011920929;
            this.motionX += this.pushX * llllllllllllllIIlIIIlIIIIIlIIIIl;
            this.motionZ += this.pushZ * llllllllllllllIIlIIIlIIIIIlIIIIl;
        }
        else {
            this.motionX *= 0.9800000190734863;
            this.motionY *= 0.0;
            this.motionZ *= 0.9800000190734863;
        }
        super.applyDrag();
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    public EntityMinecartFurnace(final World llllllllllllllIIlIIIlIIIIlIIIlll, final double llllllllllllllIIlIIIlIIIIlIIlIll, final double llllllllllllllIIlIIIlIIIIlIIlIlI, final double llllllllllllllIIlIIIlIIIIlIIlIIl) {
        super(llllllllllllllIIlIIIlIIIIlIIIlll, llllllllllllllIIlIIIlIIIIlIIlIll, llllllllllllllIIlIIIlIIIIlIIlIlI, llllllllllllllIIlIIIlIIIIlIIlIIl);
    }
    
    @Override
    protected void func_180460_a(final BlockPos llllllllllllllIIlIIIlIIIIIlIllll, final IBlockState llllllllllllllIIlIIIlIIIIIlIlllI) {
        super.func_180460_a(llllllllllllllIIlIIIlIIIIIlIllll, llllllllllllllIIlIIIlIIIIIlIlllI);
        double llllllllllllllIIlIIIlIIIIIlIllIl = this.pushX * this.pushX + this.pushZ * this.pushZ;
        if (llllllllllllllIIlIIIlIIIIIlIllIl > 1.0E-4 && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.001) {
            llllllllllllllIIlIIIlIIIIIlIllIl = MathHelper.sqrt_double(llllllllllllllIIlIIIlIIIIIlIllIl);
            this.pushX /= llllllllllllllIIlIIIlIIIIIlIllIl;
            this.pushZ /= llllllllllllllIIlIIIlIIIIIlIllIl;
            if (this.pushX * this.motionX + this.pushZ * this.motionZ < 0.0) {
                this.pushX = 0.0;
                this.pushZ = 0.0;
            }
            else {
                final double llllllllllllllIIlIIIlIIIIIlIllII = llllllllllllllIIlIIIlIIIIIlIllIl / this.func_174898_m();
                this.pushX *= llllllllllllllIIlIIIlIIIIIlIllII;
                this.pushZ *= llllllllllllllIIlIIIlIIIIIlIllII;
            }
        }
    }
    
    @Override
    public IBlockState func_180457_u() {
        return (this.isMinecartPowered() ? Blocks.lit_furnace : Blocks.furnace).getDefaultState().withProperty(BlockFurnace.FACING, EnumFacing.NORTH);
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlIIIlIIIIIIIlIll) {
        super.readEntityFromNBT(llllllllllllllIIlIIIlIIIIIIIlIll);
        this.pushX = llllllllllllllIIlIIIlIIIIIIIlIll.getDouble("PushX");
        this.pushZ = llllllllllllllIIlIIIlIIIIIIIlIll.getDouble("PushZ");
        this.fuel = llllllllllllllIIlIIIlIIIIIIIlIll.getShort("Fuel");
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.fuel > 0) {
            --this.fuel;
        }
        if (this.fuel <= 0) {
            final double n = 0.0;
            this.pushZ = n;
            this.pushX = n;
        }
        this.setMinecartPowered(this.fuel > 0);
        if (this.isMinecartPowered() && this.rand.nextInt(4) == 0) {
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 0.8, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlIIIlIIIIIIIllll) {
        super.writeEntityToNBT(llllllllllllllIIlIIIlIIIIIIIllll);
        llllllllllllllIIlIIIlIIIIIIIllll.setDouble("PushX", this.pushX);
        llllllllllllllIIlIIIlIIIIIIIllll.setDouble("PushZ", this.pushZ);
        llllllllllllllIIlIIIlIIIIIIIllll.setShort("Fuel", (short)this.fuel);
    }
    
    protected void setMinecartPowered(final boolean llllllllllllllIIlIIIlIIIIIIIIIII) {
        if (llllllllllllllIIlIIIlIIIIIIIIIII) {
            this.dataWatcher.updateObject(16, (byte)(this.dataWatcher.getWatchableObjectByte(16) | 0x1));
        }
        else {
            this.dataWatcher.updateObject(16, (byte)(this.dataWatcher.getWatchableObjectByte(16) & 0xFFFFFFFE));
        }
    }
    
    @Override
    public EnumMinecartType func_180456_s() {
        return EnumMinecartType.FURNACE;
    }
    
    @Override
    public void killMinecart(final DamageSource llllllllllllllIIlIIIlIIIIIlllIII) {
        super.killMinecart(llllllllllllllIIlIIIlIIIIIlllIII);
        if (!llllllllllllllIIlIIIlIIIIIlllIII.isExplosion()) {
            this.entityDropItem(new ItemStack(Blocks.furnace, 1), 0.0f);
        }
    }
    
    @Override
    public boolean interactFirst(final EntityPlayer llllllllllllllIIlIIIlIIIIIIlIllI) {
        final ItemStack llllllllllllllIIlIIIlIIIIIIllIII = llllllllllllllIIlIIIlIIIIIIlIllI.inventory.getCurrentItem();
        if (llllllllllllllIIlIIIlIIIIIIllIII != null && llllllllllllllIIlIIIlIIIIIIllIII.getItem() == Items.coal) {
            if (!llllllllllllllIIlIIIlIIIIIIlIllI.capabilities.isCreativeMode) {
                final ItemStack itemStack = llllllllllllllIIlIIIlIIIIIIllIII;
                if (--itemStack.stackSize == 0) {
                    llllllllllllllIIlIIIlIIIIIIlIllI.inventory.setInventorySlotContents(llllllllllllllIIlIIIlIIIIIIlIllI.inventory.currentItem, null);
                }
            }
            this.fuel += 3600;
        }
        this.pushX = this.posX - llllllllllllllIIlIIIlIIIIIIlIllI.posX;
        this.pushZ = this.posZ - llllllllllllllIIlIIIlIIIIIIlIllI.posZ;
        return true;
    }
}
