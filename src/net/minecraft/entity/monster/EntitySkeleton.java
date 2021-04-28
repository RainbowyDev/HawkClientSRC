package net.minecraft.entity.monster;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.ai.*;
import net.minecraft.potion.*;

public class EntitySkeleton extends EntityMob implements IRangedAttackMob
{
    private /* synthetic */ EntityAIArrowAttack aiArrowAttack;
    private /* synthetic */ EntityAIAttackOnCollide aiAttackOnCollide;
    
    @Override
    protected Item getDropItem() {
        return Items.arrow;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllIIllIIllllI) {
        super.readEntityFromNBT(llllIIllIIllllI);
        if (llllIIllIIllllI.hasKey("SkeletonType", 99)) {
            final byte llllIIllIlIIIII = llllIIllIIllllI.getByte("SkeletonType");
            this.setSkeletonType(llllIIllIlIIIII);
        }
        this.setCombatTask();
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.skeleton.death";
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance llllIlIIlIllIIl, IEntityLivingData llllIlIIlIllIII) {
        llllIlIIlIllIII = (String)super.func_180482_a(llllIlIIlIllIIl, (IEntityLivingData)llllIlIIlIllIII);
        if (this.worldObj.provider instanceof WorldProviderHell && this.getRNG().nextInt(5) > 0) {
            this.tasks.addTask(4, this.aiAttackOnCollide);
            this.setSkeletonType(1);
            this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
        }
        else {
            this.tasks.addTask(4, this.aiArrowAttack);
            this.func_180481_a(llllIlIIlIllIIl);
            this.func_180483_b(llllIlIIlIllIIl);
        }
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55f * llllIlIIlIllIIl.func_180170_c());
        if (this.getEquipmentInSlot(4) == null) {
            final Calendar llllIlIIlIllIll = this.worldObj.getCurrentDate();
            if (llllIlIIlIllIll.get(2) + 1 == 10 && llllIlIIlIllIll.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
                this.setCurrentItemOrArmor(4, new ItemStack((this.rand.nextFloat() < 0.1f) ? Blocks.lit_pumpkin : Blocks.pumpkin));
                this.equipmentDropChances[4] = 0.0f;
            }
        }
        return (IEntityLivingData)llllIlIIlIllIII;
    }
    
    @Override
    public void setCurrentItemOrArmor(final int llllIIllIIlIIlI, final ItemStack llllIIllIIlIIIl) {
        super.setCurrentItemOrArmor(llllIIllIIlIIlI, llllIIllIIlIIIl);
        if (!this.worldObj.isRemote && llllIIllIIlIIlI == 0) {
            this.setCombatTask();
        }
    }
    
    @Override
    public double getYOffset() {
        return super.getYOffset() - 0.5;
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    @Override
    protected void func_180429_a(final BlockPos llllIlIlIlIlIIl, final Block llllIlIlIlIlIII) {
        this.playSound("mob.skeleton.step", 0.15f, 1.0f);
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase llllIIllIllIIll, final float llllIIllIllIIlI) {
        final EntityArrow llllIIllIllIlll = new EntityArrow(this.worldObj, this, llllIIllIllIIll, 1.6f, (float)(14 - this.worldObj.getDifficulty().getDifficultyId() * 4));
        final int llllIIllIllIllI = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
        final int llllIIllIllIlIl = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
        llllIIllIllIlll.setDamage(llllIIllIllIIlI * 2.0f + this.rand.nextGaussian() * 0.25 + this.worldObj.getDifficulty().getDifficultyId() * 0.11f);
        if (llllIIllIllIllI > 0) {
            llllIIllIllIlll.setDamage(llllIIllIllIlll.getDamage() + llllIIllIllIllI * 0.5 + 0.5);
        }
        if (llllIIllIllIlIl > 0) {
            llllIIllIllIlll.setKnockbackStrength(llllIIllIllIlIl);
        }
        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0 || this.getSkeletonType() == 1) {
            llllIIllIllIlll.setFire(100);
        }
        this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(llllIIllIllIlll);
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance llllIlIIllIIlIl) {
        super.func_180481_a(llllIlIIllIIlIl);
        this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
    }
    
    @Override
    public float getEyeHeight() {
        return (this.getSkeletonType() == 1) ? super.getEyeHeight() : 1.74f;
    }
    
    @Override
    public void onDeath(final DamageSource llllIlIIlllllll) {
        super.onDeath(llllIlIIlllllll);
        if (llllIlIIlllllll.getSourceOfDamage() instanceof EntityArrow && llllIlIIlllllll.getEntity() instanceof EntityPlayer) {
            final EntityPlayer llllIlIlIIIIIll = (EntityPlayer)llllIlIIlllllll.getEntity();
            final double llllIlIlIIIIIlI = llllIlIlIIIIIll.posX - this.posX;
            final double llllIlIlIIIIIIl = llllIlIlIIIIIll.posZ - this.posZ;
            if (llllIlIlIIIIIlI * llllIlIlIIIIIlI + llllIlIlIIIIIIl * llllIlIlIIIIIIl >= 2500.0) {
                llllIlIlIIIIIll.triggerAchievement(AchievementList.snipeSkeleton);
            }
        }
        else if (llllIlIIlllllll.getEntity() instanceof EntityCreeper && ((EntityCreeper)llllIlIIlllllll.getEntity()).getPowered() && ((EntityCreeper)llllIlIIlllllll.getEntity()).isAIEnabled()) {
            ((EntityCreeper)llllIlIIlllllll.getEntity()).func_175493_co();
            this.entityDropItem(new ItemStack(Items.skull, 1, (int)((this.getSkeletonType() == 1) ? 1 : 0)), 0.0f);
        }
    }
    
    public void setCombatTask() {
        this.tasks.removeTask(this.aiAttackOnCollide);
        this.tasks.removeTask(this.aiArrowAttack);
        final ItemStack llllIlIIlIlIIll = this.getHeldItem();
        if (llllIlIIlIlIIll != null && llllIlIIlIlIIll.getItem() == Items.bow) {
            this.tasks.addTask(4, this.aiArrowAttack);
        }
        else {
            this.tasks.addTask(4, this.aiAttackOnCollide);
        }
    }
    
    public EntitySkeleton(final World llllIlIlIllIlll) {
        super(llllIlIlIllIlll);
        this.aiArrowAttack = new EntityAIArrowAttack(this, 1.0, 20, 60, 15.0f);
        this.aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2, false);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIRestrictSun(this));
        this.tasks.addTask(2, this.field_175455_a);
        this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00002203";
            }
            
            public boolean func_179945_a(final Entity lllllllllllllllIlIlIIllIllIIlIll) {
                return lllllllllllllllIlIlIIllIllIIlIll instanceof EntityWolf;
            }
            
            public boolean apply(final Object lllllllllllllllIlIlIIllIllIIIllI) {
                return this.func_179945_a((Entity)lllllllllllllllIlIlIIllIllIIIllI);
            }
        }, 6.0f, 1.0, 1.2));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
        if (llllIlIlIllIlll != null && !llllIlIlIllIlll.isRemote) {
            this.setCombatTask();
        }
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllIlIlIlIIIll) {
        if (super.attackEntityAsMob(llllIlIlIlIIIll)) {
            if (this.getSkeletonType() == 1 && llllIlIlIlIIIll instanceof EntityLivingBase) {
                ((EntityLivingBase)llllIlIlIlIIIll).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
            final float llllIlIlIIllIIl = this.getBrightness(1.0f);
            final BlockPos llllIlIlIIllIII = new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ);
            if (llllIlIlIIllIIl > 0.5f && this.rand.nextFloat() * 30.0f < (llllIlIlIIllIIl - 0.4f) * 2.0f && this.worldObj.isAgainstSky(llllIlIlIIllIII)) {
                boolean llllIlIlIIlIlll = true;
                final ItemStack llllIlIlIIlIllI = this.getEquipmentInSlot(4);
                if (llllIlIlIIlIllI != null) {
                    if (llllIlIlIIlIllI.isItemStackDamageable()) {
                        llllIlIlIIlIllI.setItemDamage(llllIlIlIIlIllI.getItemDamage() + this.rand.nextInt(2));
                        if (llllIlIlIIlIllI.getItemDamage() >= llllIlIlIIlIllI.getMaxDamage()) {
                            this.renderBrokenItemStack(llllIlIlIIlIllI);
                            this.setCurrentItemOrArmor(4, null);
                        }
                    }
                    llllIlIlIIlIlll = false;
                }
                if (llllIlIlIIlIlll) {
                    this.setFire(8);
                }
            }
        }
        if (this.worldObj.isRemote && this.getSkeletonType() == 1) {
            this.setSize(0.72f, 2.535f);
        }
        super.onLivingUpdate();
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.skeleton.say";
    }
    
    @Override
    public void updateRidden() {
        super.updateRidden();
        if (this.ridingEntity instanceof EntityCreature) {
            final EntityCreature llllIlIlIIIllIl = (EntityCreature)this.ridingEntity;
            this.renderYawOffset = llllIlIlIIIllIl.renderYawOffset;
        }
    }
    
    @Override
    protected void dropFewItems(final boolean llllIlIIlllIlIl, final int llllIlIIlllIlII) {
        if (this.getSkeletonType() == 1) {
            for (int llllIlIIlllIIll = this.rand.nextInt(3 + llllIlIIlllIlII) - 1, llllIlIIlllIIIl = 0; llllIlIIlllIIIl < llllIlIIlllIIll; ++llllIlIIlllIIIl) {
                this.dropItem(Items.coal, 1);
            }
        }
        else {
            for (int llllIlIIlllIIlI = this.rand.nextInt(3 + llllIlIIlllIlII), llllIlIIlllIIII = 0; llllIlIIlllIIII < llllIlIIlllIIlI; ++llllIlIIlllIIII) {
                this.dropItem(Items.arrow, 1);
            }
        }
        for (int llllIlIIlllIIlI = this.rand.nextInt(3 + llllIlIIlllIlII), llllIlIIlllIIII = 0; llllIlIIlllIIII < llllIlIIlllIIlI; ++llllIlIIlllIIII) {
            this.dropItem(Items.bone, 1);
        }
    }
    
    static {
        __OBFID = "CL_00001697";
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllIIllIIlIlll) {
        super.writeEntityToNBT(llllIIllIIlIlll);
        llllIIllIIlIlll.setByte("SkeletonType", (byte)this.getSkeletonType());
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, new Byte((byte)0));
    }
    
    @Override
    protected void addRandomArmor() {
        if (this.getSkeletonType() == 1) {
            this.entityDropItem(new ItemStack(Items.skull, 1, 1), 0.0f);
        }
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.skeleton.hurt";
    }
    
    public int getSkeletonType() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }
    
    public void setSkeletonType(final int llllIIllIlIlIII) {
        this.dataWatcher.updateObject(13, (byte)llllIIllIlIlIII);
        this.isImmuneToFire = (llllIIllIlIlIII == 1);
        if (llllIIllIlIlIII == 1) {
            this.setSize(0.72f, 2.535f);
        }
        else {
            this.setSize(0.6f, 1.95f);
        }
    }
}
