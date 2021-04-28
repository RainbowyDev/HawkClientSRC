package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;

public abstract class EntityAnimal extends EntityAgeable implements IAnimals
{
    private /* synthetic */ EntityPlayer playerInLove;
    protected /* synthetic */ Block field_175506_bl;
    private /* synthetic */ int inLove;
    
    static {
        __OBFID = "CL_00001638";
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer llllllllllllllIlIIIIlllIIlIIIIll) {
        return 1 + this.worldObj.rand.nextInt(3);
    }
    
    @Override
    protected void updateAITasks() {
        if (this.getGrowingAge() != 0) {
            this.inLove = 0;
        }
        super.updateAITasks();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIlIIIIlllIIllIlIlI, final float llllllllllllllIlIIIIlllIIllIlIIl) {
        if (this.func_180431_b(llllllllllllllIlIIIIlllIIllIlIlI)) {
            return false;
        }
        this.inLove = 0;
        return super.attackEntityFrom(llllllllllllllIlIIIIlllIIllIlIlI, llllllllllllllIlIIIIlllIIllIlIIl);
    }
    
    protected void func_175505_a(final EntityPlayer llllllllllllllIlIIIIlllIIIllIIIl, final ItemStack llllllllllllllIlIIIIlllIIIllIIII) {
        if (!llllllllllllllIlIIIIlllIIIllIIIl.capabilities.isCreativeMode) {
            --llllllllllllllIlIIIIlllIIIllIIII.stackSize;
            if (llllllllllllllIlIIIIlllIIIllIIII.stackSize <= 0) {
                llllllllllllllIlIIIIlllIIIllIIIl.inventory.setInventorySlotContents(llllllllllllllIlIIIIlllIIIllIIIl.inventory.currentItem, null);
            }
        }
    }
    
    public EntityPlayer func_146083_cb() {
        return this.playerInLove;
    }
    
    public boolean isInLove() {
        return this.inLove > 0;
    }
    
    @Override
    public int getTalkInterval() {
        return 120;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        final int llllllllllllllIlIIIIlllIIlIlIIII = MathHelper.floor_double(this.posX);
        final int llllllllllllllIlIIIIlllIIlIIllll = MathHelper.floor_double(this.getEntityBoundingBox().minY);
        final int llllllllllllllIlIIIIlllIIlIIlllI = MathHelper.floor_double(this.posZ);
        final BlockPos llllllllllllllIlIIIIlllIIlIIllIl = new BlockPos(llllllllllllllIlIIIIlllIIlIlIIII, llllllllllllllIlIIIIlllIIlIIllll, llllllllllllllIlIIIIlllIIlIIlllI);
        return this.worldObj.getBlockState(llllllllllllllIlIIIIlllIIlIIllIl.offsetDown()).getBlock() == this.field_175506_bl && this.worldObj.getLight(llllllllllllllIlIIIIlllIIlIIllIl) > 8 && super.getCanSpawnHere();
    }
    
    public EntityAnimal(final World llllllllllllllIlIIIIlllIlIIIIIll) {
        super(llllllllllllllIlIIIIlllIlIIIIIll);
        this.field_175506_bl = Blocks.grass;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getGrowingAge() != 0) {
            this.inLove = 0;
        }
        if (this.inLove > 0) {
            --this.inLove;
            if (this.inLove % 10 == 0) {
                final double llllllllllllllIlIIIIlllIIllllIII = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIlIIIIlllIIlllIlll = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIlIIIIlllIIlllIllI = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle(EnumParticleTypes.HEART, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, llllllllllllllIlIIIIlllIIllllIII, llllllllllllllIlIIIIlllIIlllIlll, llllllllllllllIlIIIIlllIIlllIllI, new int[0]);
            }
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlIIIIlllIIlIlIlll) {
        super.readEntityFromNBT(llllllllllllllIlIIIIlllIIlIlIlll);
        this.inLove = llllllllllllllIlIIIIlllIIlIlIlll.getInteger("InLove");
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlIIIIlllIIlIlllll) {
        super.writeEntityToNBT(llllllllllllllIlIIIIlllIIlIlllll);
        llllllllllllllIlIIIIlllIIlIlllll.setInteger("InLove", this.inLove);
    }
    
    @Override
    public boolean interact(final EntityPlayer llllllllllllllIlIIIIlllIIIllIllI) {
        final ItemStack llllllllllllllIlIIIIlllIIIlllIII = llllllllllllllIlIIIIlllIIIllIllI.inventory.getCurrentItem();
        if (llllllllllllllIlIIIIlllIIIlllIII != null) {
            if (this.isBreedingItem(llllllllllllllIlIIIIlllIIIlllIII) && this.getGrowingAge() == 0 && this.inLove <= 0) {
                this.func_175505_a(llllllllllllllIlIIIIlllIIIllIllI, llllllllllllllIlIIIIlllIIIlllIII);
                this.setInLove(llllllllllllllIlIIIIlllIIIllIllI);
                return true;
            }
            if (this.isChild() && this.isBreedingItem(llllllllllllllIlIIIIlllIIIlllIII)) {
                this.func_175505_a(llllllllllllllIlIIIIlllIIIllIllI, llllllllllllllIlIIIIlllIIIlllIII);
                this.func_175501_a((int)(-this.getGrowingAge() / 20 * 0.1f), true);
                return true;
            }
        }
        return super.interact(llllllllllllllIlIIIIlllIIIllIllI);
    }
    
    @Override
    public float func_180484_a(final BlockPos llllllllllllllIlIIIIlllIIllIIlIl) {
        return (this.worldObj.getBlockState(llllllllllllllIlIIIIlllIIllIIlIl.offsetDown()).getBlock() == Blocks.grass) ? 10.0f : (this.worldObj.getLightBrightness(llllllllllllllIlIIIIlllIIllIIlIl) - 0.5f);
    }
    
    @Override
    public void handleHealthUpdate(final byte llllllllllllllIlIIIIlllIIIIIlIll) {
        if (llllllllllllllIlIIIIlllIIIIIlIll == 18) {
            for (int llllllllllllllIlIIIIlllIIIIlIIII = 0; llllllllllllllIlIIIIlllIIIIlIIII < 7; ++llllllllllllllIlIIIIlllIIIIlIIII) {
                final double llllllllllllllIlIIIIlllIIIIIllll = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIlIIIIlllIIIIIlllI = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIlIIIIlllIIIIIllIl = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle(EnumParticleTypes.HEART, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, llllllllllllllIlIIIIlllIIIIIllll, llllllllllllllIlIIIIlllIIIIIlllI, llllllllllllllIlIIIIlllIIIIIllIl, new int[0]);
            }
        }
        else {
            super.handleHealthUpdate(llllllllllllllIlIIIIlllIIIIIlIll);
        }
    }
    
    public void resetInLove() {
        this.inLove = 0;
    }
    
    public boolean canMateWith(final EntityAnimal llllllllllllllIlIIIIlllIIIIllIll) {
        return llllllllllllllIlIIIIlllIIIIllIll != this && llllllllllllllIlIIIIlllIIIIllIll.getClass() == this.getClass() && (this.isInLove() && llllllllllllllIlIIIIlllIIIIllIll.isInLove());
    }
    
    public void setInLove(final EntityPlayer llllllllllllllIlIIIIlllIIIlIlIII) {
        this.inLove = 600;
        this.playerInLove = llllllllllllllIlIIIIlllIIIlIlIII;
        this.worldObj.setEntityState(this, (byte)18);
    }
    
    @Override
    protected boolean canDespawn() {
        return false;
    }
    
    public boolean isBreedingItem(final ItemStack llllllllllllllIlIIIIlllIIIllllll) {
        return llllllllllllllIlIIIIlllIIIllllll != null && llllllllllllllIlIIIIlllIIIllllll.getItem() == Items.wheat;
    }
}
