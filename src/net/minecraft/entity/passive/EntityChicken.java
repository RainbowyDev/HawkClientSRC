package net.minecraft.entity.passive;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class EntityChicken extends EntityAnimal
{
    public /* synthetic */ float destPos;
    public /* synthetic */ boolean field_152118_bv;
    public /* synthetic */ float field_70888_h;
    public /* synthetic */ int timeUntilNextEgg;
    public /* synthetic */ float field_70884_g;
    public /* synthetic */ float field_70889_i;
    public /* synthetic */ float field_70886_e;
    
    static {
        __OBFID = "CL_00001639";
    }
    
    @Override
    protected void func_180429_a(final BlockPos lllllllllllllllllllllIIIIIIlllII, final Block lllllllllllllllllllllIIIIIIllIll) {
        this.playSound("mob.chicken.step", 0.15f, 1.0f);
    }
    
    @Override
    protected Item getDropItem() {
        return Items.feather;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllllllllIIIIIIIIIII) {
        super.readEntityFromNBT(lllllllllllllllllllllIIIIIIIIIII);
        this.field_152118_bv = lllllllllllllllllllllIIIIIIIIIII.getBoolean("IsChickenJockey");
        if (lllllllllllllllllllllIIIIIIIIIII.hasKey("EggLayTime")) {
            this.timeUntilNextEgg = lllllllllllllllllllllIIIIIIIIIII.getInteger("EggLayTime");
        }
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.chicken.hurt";
    }
    
    @Override
    public float getEyeHeight() {
        return this.height;
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.chicken.hurt";
    }
    
    public EntityChicken(final World lllllllllllllllllllllIIIIIllIIII) {
        super(lllllllllllllllllllllIIIIIllIIII);
        this.field_70889_i = 1.0f;
        this.setSize(0.4f, 0.7f);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0, Items.wheat_seeds, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    
    @Override
    public void updateRiderPosition() {
        super.updateRiderPosition();
        final float llllllllllllllllllllIllllllIlIII = MathHelper.sin(this.renderYawOffset * 3.1415927f / 180.0f);
        final float llllllllllllllllllllIllllllIIlll = MathHelper.cos(this.renderYawOffset * 3.1415927f / 180.0f);
        final float llllllllllllllllllllIllllllIIllI = 0.1f;
        final float llllllllllllllllllllIllllllIIlIl = 0.0f;
        this.riddenByEntity.setPosition(this.posX + llllllllllllllllllllIllllllIIllI * llllllllllllllllllllIllllllIlIII, this.posY + this.height * 0.5f + this.riddenByEntity.getYOffset() + llllllllllllllllllllIllllllIIlIl, this.posZ - llllllllllllllllllllIllllllIIllI * llllllllllllllllllllIllllllIIlll);
        if (this.riddenByEntity instanceof EntityLivingBase) {
            ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
        }
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable llllllllllllllllllllIlllllIlIIIl) {
        return this.createChild1(llllllllllllllllllllIlllllIlIIIl);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllllllIlllllllIIlI) {
        super.writeEntityToNBT(llllllllllllllllllllIlllllllIIlI);
        llllllllllllllllllllIlllllllIIlI.setBoolean("IsChickenJockey", this.field_152118_bv);
        llllllllllllllllllllIlllllllIIlI.setInteger("EggLayTime", this.timeUntilNextEgg);
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.chicken.say";
    }
    
    public EntityChicken createChild1(final EntityAgeable lllllllllllllllllllllIIIIIIIlIIl) {
        return new EntityChicken(this.worldObj);
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer llllllllllllllllllllIllllllllIII) {
        return this.func_152116_bZ() ? 10 : super.getExperiencePoints(llllllllllllllllllllIllllllllIII);
    }
    
    @Override
    public void fall(final float lllllllllllllllllllllIIIIIlIIIll, final float lllllllllllllllllllllIIIIIlIIIlI) {
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack lllllllllllllllllllllIIIIIIIIlII) {
        return lllllllllllllllllllllIIIIIIIIlII != null && lllllllllllllllllllllIIIIIIIIlII.getItem() == Items.wheat_seeds;
    }
    
    public boolean func_152116_bZ() {
        return this.field_152118_bv;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;
        this.destPos += (float)((this.onGround ? -1 : 4) * 0.3);
        this.destPos = MathHelper.clamp_float(this.destPos, 0.0f, 1.0f);
        if (!this.onGround && this.field_70889_i < 1.0f) {
            this.field_70889_i = 1.0f;
        }
        this.field_70889_i *= (float)0.9;
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        this.field_70886_e += this.field_70889_i * 2.0f;
        if (!this.worldObj.isRemote && !this.isChild() && !this.func_152116_bZ() && --this.timeUntilNextEgg <= 0) {
            this.playSound("mob.chicken.plop", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(Items.egg, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }
    
    @Override
    protected void dropFewItems(final boolean lllllllllllllllllllllIIIIIIlIIll, final int lllllllllllllllllllllIIIIIIlIIlI) {
        for (int lllllllllllllllllllllIIIIIIlIIIl = this.rand.nextInt(3) + this.rand.nextInt(1 + lllllllllllllllllllllIIIIIIlIIlI), lllllllllllllllllllllIIIIIIlIIII = 0; lllllllllllllllllllllIIIIIIlIIII < lllllllllllllllllllllIIIIIIlIIIl; ++lllllllllllllllllllllIIIIIIlIIII) {
            this.dropItem(Items.feather, 1);
        }
        if (this.isBurning()) {
            this.dropItem(Items.cooked_chicken, 1);
        }
        else {
            this.dropItem(Items.chicken, 1);
        }
    }
    
    @Override
    protected boolean canDespawn() {
        return this.func_152116_bZ() && this.riddenByEntity == null;
    }
    
    public void func_152117_i(final boolean llllllllllllllllllllIlllllIlIlll) {
        this.field_152118_bv = llllllllllllllllllllIlllllIlIlll;
    }
}
