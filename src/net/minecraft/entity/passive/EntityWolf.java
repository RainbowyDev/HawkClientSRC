package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import net.minecraft.entity.ai.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.init.*;

public class EntityWolf extends EntityTameable
{
    private /* synthetic */ float headRotationCourseOld;
    private /* synthetic */ float headRotationCourse;
    private /* synthetic */ boolean isShaking;
    private /* synthetic */ float timeWolfIsShaking;
    private /* synthetic */ boolean isWet;
    private /* synthetic */ float prevTimeWolfIsShaking;
    
    @Override
    public void handleHealthUpdate(final byte lllIIIllIllIIl) {
        if (lllIIIllIllIIl == 8) {
            this.isShaking = true;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
        }
        else {
            super.handleHealthUpdate(lllIIIllIllIIl);
        }
    }
    
    @Override
    public boolean allowLeashing() {
        return !this.isAngry() && super.allowLeashing();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896);
        if (this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0);
        }
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
    }
    
    public void func_175547_a(final EnumDyeColor lllIIIlIlllIlI) {
        this.dataWatcher.updateObject(20, (byte)(lllIIIlIlllIlI.getDyeColorDamage() & 0xF));
    }
    
    @Override
    protected Item getDropItem() {
        return Item.getItemById(-1);
    }
    
    static {
        __OBFID = "CL_00001654";
    }
    
    @Override
    public EntityWolf createChild(final EntityAgeable lllIIIlIllIlIl) {
        final EntityWolf lllIIIlIllIlII = new EntityWolf(this.worldObj);
        final String lllIIIlIllIIll = this.func_152113_b();
        if (lllIIIlIllIIll != null && lllIIIlIllIIll.trim().length() > 0) {
            lllIIIlIllIlII.func_152115_b(lllIIIlIllIIll);
            lllIIIlIllIlII.setTamed(true);
        }
        return lllIIIlIllIlII;
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal lllIIIlIlIIlIl) {
        if (lllIIIlIlIIlIl == this) {
            return false;
        }
        if (!this.isTamed()) {
            return false;
        }
        if (!(lllIIIlIlIIlIl instanceof EntityWolf)) {
            return false;
        }
        final EntityWolf lllIIIlIlIIlII = (EntityWolf)lllIIIlIlIIlIl;
        return lllIIIlIlIIlII.isTamed() && !lllIIIlIlIIlII.isSitting() && (this.isInLove() && lllIIIlIlIIlII.isInLove());
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.wolf.hurt";
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround) {
            this.isShaking = true;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
            this.worldObj.setEntityState(this, (byte)8);
        }
        if (!this.worldObj.isRemote && this.getAttackTarget() == null && this.isAngry()) {
            this.setAngry(false);
        }
    }
    
    public float getInterestedAngle(final float lllIIlIIIIlIll) {
        return (this.headRotationCourseOld + (this.headRotationCourse - this.headRotationCourseOld) * lllIIlIIIIlIll) * 0.15f * 3.1415927f;
    }
    
    @Override
    public int getVerticalFaceSpeed() {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllIIIlllllIll, float lllIIIlllllIlI) {
        if (this.func_180431_b(lllIIIlllllIll)) {
            return false;
        }
        final Entity lllIIIllllllIl = lllIIIlllllIll.getEntity();
        this.aiSit.setSitting(false);
        if (lllIIIllllllIl != null && !(lllIIIllllllIl instanceof EntityPlayer) && !(lllIIIllllllIl instanceof EntityArrow)) {
            lllIIIlllllIlI = (lllIIIlllllIlI + 1.0f) / 2.0f;
        }
        return super.attackEntityFrom(lllIIIlllllIll, (float)lllIIIlllllIlI);
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }
    
    @Override
    public float getEyeHeight() {
        return this.height * 0.8f;
    }
    
    @Override
    protected String getLivingSound() {
        return this.isAngry() ? "mob.wolf.growl" : ((this.rand.nextInt(3) == 0) ? ((this.isTamed() && this.dataWatcher.getWatchableObjectFloat(18) < 10.0f) ? "mob.wolf.whine" : "mob.wolf.panting") : "mob.wolf.bark");
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.wolf.death";
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, new Float(this.getHealth()));
        this.dataWatcher.addObject(19, new Byte((byte)0));
        this.dataWatcher.addObject(20, new Byte((byte)EnumDyeColor.RED.func_176765_a()));
    }
    
    public void setAngry(final boolean lllIIIllIIIlll) {
        final byte lllIIIllIIIllI = this.dataWatcher.getWatchableObjectByte(16);
        if (lllIIIllIIIlll) {
            this.dataWatcher.updateObject(16, (byte)(lllIIIllIIIllI | 0x2));
        }
        else {
            this.dataWatcher.updateObject(16, (byte)(lllIIIllIIIllI & 0xFFFFFFFD));
        }
    }
    
    @Override
    protected boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }
    
    public float getShakeAngle(final float lllIIlIIIlIIll, final float lllIIlIIIlIllI) {
        float lllIIlIIIlIlIl = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * lllIIlIIIlIIll + lllIIlIIIlIllI) / 1.8f;
        if (lllIIlIIIlIlIl < 0.0f) {
            lllIIlIIIlIlIl = 0.0f;
        }
        else if (lllIIlIIIlIlIl > 1.0f) {
            lllIIlIIIlIlIl = 1.0f;
        }
        return MathHelper.sin(lllIIlIIIlIlIl * 3.1415927f) * MathHelper.sin(lllIIlIIIlIlIl * 3.1415927f * 11.0f) * 0.15f * 3.1415927f;
    }
    
    @Override
    public void setTamed(final boolean lllIIIlllIllII) {
        super.setTamed(lllIIIlllIllII);
        if (lllIIIlllIllII) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0);
        }
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllIIlIlIIIlII) {
        super.readEntityFromNBT(lllIIlIlIIIlII);
        this.setAngry(lllIIlIlIIIlII.getBoolean("Angry"));
        if (lllIIlIlIIIlII.hasKey("CollarColor", 99)) {
            this.func_175547_a(EnumDyeColor.func_176766_a(lllIIlIlIIIlII.getByte("CollarColor")));
        }
    }
    
    @Override
    public void setAttackTarget(final EntityLivingBase lllIIlIlIllIIl) {
        super.setAttackTarget(lllIIlIlIllIIl);
        if (lllIIlIlIllIIl == null) {
            this.setAngry(false);
        }
        else if (!this.isTamed()) {
            this.setAngry(true);
        }
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllIIIllllIIIl) {
        final boolean lllIIIllllIIll = lllIIIllllIIIl.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(int)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
        if (lllIIIllllIIll) {
            this.func_174815_a(this, lllIIIllllIIIl);
        }
        return lllIIIllllIIll;
    }
    
    public boolean isAngry() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x2) != 0x0;
    }
    
    public void func_70918_i(final boolean lllIIIlIlIlIlI) {
        if (lllIIIlIlIlIlI) {
            this.dataWatcher.updateObject(19, 1);
        }
        else {
            this.dataWatcher.updateObject(19, 0);
        }
    }
    
    public EntityWolf(final World lllIIlIllIIIlI) {
        super(lllIIlIllIIIlI);
        this.setSize(0.6f, 0.8f);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4f));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0, 10.0f, 2.0f));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0));
        this.tasks.addTask(8, new EntityAIBeg(this, 8.0f));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityAnimal.class, false, (Predicate)new Predicate() {
            public boolean apply(final Object lllllllllllllllIIlllIIIIlIlIIlll) {
                return this.func_180094_a((Entity)lllllllllllllllIIlllIIIIlIlIIlll);
            }
            
            public boolean func_180094_a(final Entity lllllllllllllllIIlllIIIIlIlIllII) {
                return lllllllllllllllIIlllIIIIlIlIllII instanceof EntitySheep || lllllllllllllllIIlllIIIIlIlIllII instanceof EntityRabbit;
            }
            
            static {
                __OBFID = "CL_00002229";
            }
        }));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, false));
        this.setTamed(false);
    }
    
    public boolean isWolfWet() {
        return this.isWet;
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack lllIIIllIlIIIl) {
        return lllIIIllIlIIIl != null && lllIIIllIlIIIl.getItem() instanceof ItemFood && ((ItemFood)lllIIIllIlIIIl.getItem()).isWolfsFavoriteMeat();
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllIIlIlIIlIII) {
        super.writeEntityToNBT(lllIIlIlIIlIII);
        lllIIlIlIIlIII.setBoolean("Angry", this.isAngry());
        lllIIlIlIIlIII.setByte("CollarColor", (byte)this.func_175546_cu().getDyeColorDamage());
    }
    
    @Override
    protected void func_180429_a(final BlockPos lllIIlIlIlIIII, final Block lllIIlIlIIllll) {
        this.playSound("mob.wolf.step", 0.15f, 1.0f);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.headRotationCourseOld = this.headRotationCourse;
        if (this.func_70922_bv()) {
            this.headRotationCourse += (1.0f - this.headRotationCourse) * 0.4f;
        }
        else {
            this.headRotationCourse += (0.0f - this.headRotationCourse) * 0.4f;
        }
        if (this.isWet()) {
            this.isWet = true;
            this.isShaking = false;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
        }
        else if ((this.isWet || this.isShaking) && this.isShaking) {
            if (this.timeWolfIsShaking == 0.0f) {
                this.playSound("mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05f;
            if (this.prevTimeWolfIsShaking >= 2.0f) {
                this.isWet = false;
                this.isShaking = false;
                this.prevTimeWolfIsShaking = 0.0f;
                this.timeWolfIsShaking = 0.0f;
            }
            if (this.timeWolfIsShaking > 0.4f) {
                final float lllIIlIIllIIII = (float)this.getEntityBoundingBox().minY;
                for (int lllIIlIIlIllll = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4f) * 3.1415927f) * 7.0f), lllIIlIIlIlllI = 0; lllIIlIIlIlllI < lllIIlIIlIllll; ++lllIIlIIlIlllI) {
                    final float lllIIlIIlIllIl = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width * 0.5f;
                    final float lllIIlIIlIllII = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width * 0.5f;
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + lllIIlIIlIllIl, lllIIlIIllIIII + 0.8f, this.posZ + lllIIlIIlIllII, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
            }
        }
    }
    
    public float getTailRotation() {
        return this.isAngry() ? 1.5393804f : (this.isTamed() ? ((0.55f - (20.0f - this.dataWatcher.getWatchableObjectFloat(18)) * 0.02f) * 3.1415927f) : 0.62831855f);
    }
    
    public boolean func_70922_bv() {
        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }
    
    @Override
    public boolean func_142018_a(final EntityLivingBase lllIIIlIIlIllI, final EntityLivingBase lllIIIlIIlIlIl) {
        if (!(lllIIIlIIlIllI instanceof EntityCreeper) && !(lllIIIlIIlIllI instanceof EntityGhast)) {
            if (lllIIIlIIlIllI instanceof EntityWolf) {
                final EntityWolf lllIIIlIIlIlII = (EntityWolf)lllIIIlIIlIllI;
                if (lllIIIlIIlIlII.isTamed() && lllIIIlIIlIlII.func_180492_cm() == lllIIIlIIlIlIl) {
                    return false;
                }
            }
            return (!(lllIIIlIIlIllI instanceof EntityPlayer) || !(lllIIIlIIlIlIl instanceof EntityPlayer) || ((EntityPlayer)lllIIIlIIlIlIl).canAttackPlayer((EntityPlayer)lllIIIlIIlIllI)) && (!(lllIIIlIIlIllI instanceof EntityHorse) || !((EntityHorse)lllIIIlIIlIllI).isTame());
        }
        return false;
    }
    
    @Override
    public boolean interact(final EntityPlayer lllIIIllIlllll) {
        final ItemStack lllIIIlllIIIll = lllIIIllIlllll.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (lllIIIlllIIIll != null) {
                if (lllIIIlllIIIll.getItem() instanceof ItemFood) {
                    final ItemFood lllIIIlllIIIlI = (ItemFood)lllIIIlllIIIll.getItem();
                    if (lllIIIlllIIIlI.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0f) {
                        if (!lllIIIllIlllll.capabilities.isCreativeMode) {
                            final ItemStack itemStack = lllIIIlllIIIll;
                            --itemStack.stackSize;
                        }
                        this.heal((float)lllIIIlllIIIlI.getHealAmount(lllIIIlllIIIll));
                        if (lllIIIlllIIIll.stackSize <= 0) {
                            lllIIIllIlllll.inventory.setInventorySlotContents(lllIIIllIlllll.inventory.currentItem, null);
                        }
                        return true;
                    }
                }
                else if (lllIIIlllIIIll.getItem() == Items.dye) {
                    final EnumDyeColor lllIIIlllIIIIl = EnumDyeColor.func_176766_a(lllIIIlllIIIll.getMetadata());
                    if (lllIIIlllIIIIl != this.func_175546_cu()) {
                        this.func_175547_a(lllIIIlllIIIIl);
                        if (!lllIIIllIlllll.capabilities.isCreativeMode) {
                            final ItemStack itemStack2 = lllIIIlllIIIll;
                            if (--itemStack2.stackSize <= 0) {
                                lllIIIllIlllll.inventory.setInventorySlotContents(lllIIIllIlllll.inventory.currentItem, null);
                            }
                        }
                        return true;
                    }
                }
            }
            if (this.func_152114_e(lllIIIllIlllll) && !this.worldObj.isRemote && !this.isBreedingItem(lllIIIlllIIIll)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPathEntity();
                this.setAttackTarget(null);
            }
        }
        else if (lllIIIlllIIIll != null && lllIIIlllIIIll.getItem() == Items.bone && !this.isAngry()) {
            if (!lllIIIllIlllll.capabilities.isCreativeMode) {
                final ItemStack itemStack3 = lllIIIlllIIIll;
                --itemStack3.stackSize;
            }
            if (lllIIIlllIIIll.stackSize <= 0) {
                lllIIIllIlllll.inventory.setInventorySlotContents(lllIIIllIlllll.inventory.currentItem, null);
            }
            if (!this.worldObj.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.navigator.clearPathEntity();
                    this.setAttackTarget(null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0f);
                    this.func_152115_b(lllIIIllIlllll.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
                else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.interact(lllIIIllIlllll);
    }
    
    @Override
    public int getMaxSpawnedInChunk() {
        return 8;
    }
    
    @Override
    protected void updateAITasks() {
        this.dataWatcher.updateObject(18, this.getHealth());
    }
    
    public EnumDyeColor func_175546_cu() {
        return EnumDyeColor.func_176766_a(this.dataWatcher.getWatchableObjectByte(20) & 0xF);
    }
    
    public float getShadingWhileWet(final float lllIIlIIIlllll) {
        return 0.75f + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * lllIIlIIIlllll) / 2.0f * 0.25f;
    }
}
