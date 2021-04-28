package net.minecraft.entity;

import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public abstract class EntityAgeable extends EntityCreature
{
    private /* synthetic */ float field_98056_d;
    protected /* synthetic */ int field_175503_c;
    private /* synthetic */ float field_98057_e;
    protected /* synthetic */ int field_175502_b;
    protected /* synthetic */ int field_175504_a;
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIllllIllIIIllIlIl) {
        super.readEntityFromNBT(lllllllllllllllIllllIllIIIllIlIl);
        this.setGrowingAge(lllllllllllllllIllllIllIIIllIlIl.getInteger("Age"));
        this.field_175502_b = lllllllllllllllIllllIllIIIllIlIl.getInteger("ForcedAge");
    }
    
    public int getGrowingAge() {
        return this.worldObj.isRemote ? this.dataWatcher.getWatchableObjectByte(12) : this.field_175504_a;
    }
    
    public void func_175501_a(final int lllllllllllllllIllllIllIIlIIllll, final boolean lllllllllllllllIllllIllIIlIIlllI) {
        final int lllllllllllllllIllllIllIIlIlIIlI;
        int lllllllllllllllIllllIllIIlIlIIll = lllllllllllllllIllllIllIIlIlIIlI = this.getGrowingAge();
        lllllllllllllllIllllIllIIlIlIIll += lllllllllllllllIllllIllIIlIIllll * 20;
        if (lllllllllllllllIllllIllIIlIlIIll > 0) {
            lllllllllllllllIllllIllIIlIlIIll = 0;
            if (lllllllllllllllIllllIllIIlIlIIlI < 0) {
                this.func_175500_n();
            }
        }
        final int lllllllllllllllIllllIllIIlIlIIIl = lllllllllllllllIllllIllIIlIlIIll - lllllllllllllllIllllIllIIlIlIIlI;
        this.setGrowingAge(lllllllllllllllIllllIllIIlIlIIll);
        if (lllllllllllllllIllllIllIIlIIlllI) {
            this.field_175502_b += lllllllllllllllIllllIllIIlIlIIIl;
            if (this.field_175503_c == 0) {
                this.field_175503_c = 40;
            }
        }
        if (this.getGrowingAge() == 0) {
            this.setGrowingAge(this.field_175502_b);
        }
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.worldObj.isRemote) {
            if (this.field_175503_c > 0) {
                if (this.field_175503_c % 4 == 0) {
                    this.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, 0.0, 0.0, 0.0, new int[0]);
                }
                --this.field_175503_c;
            }
            this.setScaleForAge(this.isChild());
        }
        else {
            int lllllllllllllllIllllIllIIIlIllll = this.getGrowingAge();
            if (lllllllllllllllIllllIllIIIlIllll < 0) {
                ++lllllllllllllllIllllIllIIIlIllll;
                this.setGrowingAge(lllllllllllllllIllllIllIIIlIllll);
                if (lllllllllllllllIllllIllIIIlIllll == 0) {
                    this.func_175500_n();
                }
            }
            else if (lllllllllllllllIllllIllIIIlIllll > 0) {
                --lllllllllllllllIllllIllIIIlIllll;
                this.setGrowingAge(lllllllllllllllIllllIllIIIlIllll);
            }
        }
    }
    
    public void addGrowth(final int lllllllllllllllIllllIllIIlIIIlll) {
        this.func_175501_a(lllllllllllllllIllllIllIIlIIIlll, false);
    }
    
    @Override
    public boolean isChild() {
        return this.getGrowingAge() < 0;
    }
    
    public boolean interact(final EntityPlayer lllllllllllllllIllllIllIIllIlIll) {
        final ItemStack lllllllllllllllIllllIllIIllIlIlI = lllllllllllllllIllllIllIIllIlIll.inventory.getCurrentItem();
        if (lllllllllllllllIllllIllIIllIlIlI != null && lllllllllllllllIllllIllIIllIlIlI.getItem() == Items.spawn_egg) {
            if (!this.worldObj.isRemote) {
                final Class lllllllllllllllIllllIllIIllIlIIl = EntityList.getClassFromID(lllllllllllllllIllllIllIIllIlIlI.getMetadata());
                if (lllllllllllllllIllllIllIIllIlIIl != null && this.getClass() == lllllllllllllllIllllIllIIllIlIIl) {
                    final EntityAgeable lllllllllllllllIllllIllIIllIlIII = this.createChild(this);
                    if (lllllllllllllllIllllIllIIllIlIII != null) {
                        lllllllllllllllIllllIllIIllIlIII.setGrowingAge(-24000);
                        lllllllllllllllIllllIllIIllIlIII.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
                        this.worldObj.spawnEntityInWorld(lllllllllllllllIllllIllIIllIlIII);
                        if (lllllllllllllllIllllIllIIllIlIlI.hasDisplayName()) {
                            lllllllllllllllIllllIllIIllIlIII.setCustomNameTag(lllllllllllllllIllllIllIIllIlIlI.getDisplayName());
                        }
                        if (!lllllllllllllllIllllIllIIllIlIll.capabilities.isCreativeMode) {
                            final ItemStack itemStack = lllllllllllllllIllllIllIIllIlIlI;
                            --itemStack.stackSize;
                            if (lllllllllllllllIllllIllIIllIlIlI.stackSize <= 0) {
                                lllllllllllllllIllllIllIIllIlIll.inventory.setInventorySlotContents(lllllllllllllllIllllIllIIllIlIll.inventory.currentItem, null);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected final void setSize(final float lllllllllllllllIllllIllIIIIlllIl, final float lllllllllllllllIllllIllIIIIllIII) {
        final boolean lllllllllllllllIllllIllIIIIllIll = this.field_98056_d > 0.0f;
        this.field_98056_d = lllllllllllllllIllllIllIIIIlllIl;
        this.field_98057_e = lllllllllllllllIllllIllIIIIllIII;
        if (!lllllllllllllllIllllIllIIIIllIll) {
            this.setScale(1.0f);
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(12, 0);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIllllIllIIIlllIIl) {
        super.writeEntityToNBT(lllllllllllllllIllllIllIIIlllIIl);
        lllllllllllllllIllllIllIIIlllIIl.setInteger("Age", this.getGrowingAge());
        lllllllllllllllIllllIllIIIlllIIl.setInteger("ForcedAge", this.field_175502_b);
    }
    
    public EntityAgeable(final World lllllllllllllllIllllIllIIlllIIlI) {
        super(lllllllllllllllIllllIllIIlllIIlI);
        this.field_98056_d = -1.0f;
    }
    
    static {
        __OBFID = "CL_00001530";
    }
    
    public void setScaleForAge(final boolean lllllllllllllllIllllIllIIIlIIlIl) {
        this.setScale(lllllllllllllllIllllIllIIIlIIlIl ? 0.5f : 1.0f);
    }
    
    protected void func_175500_n() {
    }
    
    public void setGrowingAge(final int lllllllllllllllIllllIllIIIllllll) {
        this.dataWatcher.updateObject(12, (byte)MathHelper.clamp_int(lllllllllllllllIllllIllIIIllllll, -1, 1));
        this.field_175504_a = lllllllllllllllIllllIllIIIllllll;
        this.setScaleForAge(this.isChild());
    }
    
    protected final void setScale(final float lllllllllllllllIllllIllIIIIlIIll) {
        super.setSize(this.field_98056_d * lllllllllllllllIllllIllIIIIlIIll, this.field_98057_e * lllllllllllllllIllllIllIIIIlIIll);
    }
    
    public abstract EntityAgeable createChild(final EntityAgeable p0);
}
