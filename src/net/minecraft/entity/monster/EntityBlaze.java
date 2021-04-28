package net.minecraft.entity.monster;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;

public class EntityBlaze extends EntityMob
{
    private /* synthetic */ float heightOffset;
    private /* synthetic */ int heightOffsetUpdateTime;
    
    public void func_70844_e(final boolean llllllllllllllIllllIlIIIIIIlIIII) {
        byte llllllllllllllIllllIlIIIIIIlIIlI = this.dataWatcher.getWatchableObjectByte(16);
        if (llllllllllllllIllllIlIIIIIIlIIII) {
            llllllllllllllIllllIlIIIIIIlIIlI |= 0x1;
        }
        else {
            llllllllllllllIllllIlIIIIIIlIIlI &= 0xFFFFFFFE;
        }
        this.dataWatcher.updateObject(16, llllllllllllllIllllIlIIIIIIlIIlI);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(48.0);
    }
    
    public EntityBlaze(final World llllllllllllllIllllIlIIIIlIIllII) {
        super(llllllllllllllIllllIlIIIIlIIllII);
        this.heightOffset = 0.5f;
        this.isImmuneToFire = true;
        this.experienceValue = 10;
        this.tasks.addTask(4, new AIFireballAttack());
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    @Override
    public void fall(final float llllllllllllllIllllIlIIIIIlIllll, final float llllllllllllllIllllIlIIIIIlIlllI) {
    }
    
    @Override
    public boolean isBurning() {
        return this.func_70845_n();
    }
    
    @Override
    protected Item getDropItem() {
        return Items.blaze_rod;
    }
    
    public boolean func_70845_n() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    @Override
    protected void updateAITasks() {
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        --this.heightOffsetUpdateTime;
        if (this.heightOffsetUpdateTime <= 0) {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5f + (float)this.rand.nextGaussian() * 3.0f;
        }
        final EntityLivingBase llllllllllllllIllllIlIIIIIllIIll = this.getAttackTarget();
        if (llllllllllllllIllllIlIIIIIllIIll != null && llllllllllllllIllllIlIIIIIllIIll.posY + llllllllllllllIllllIlIIIIIllIIll.getEyeHeight() > this.posY + this.getEyeHeight() + this.heightOffset) {
            this.motionY += (0.30000001192092896 - this.motionY) * 0.30000001192092896;
            this.isAirBorne = true;
        }
        super.updateAITasks();
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.blaze.hit";
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllllIllllIlIIIIIllllll) {
        return 15728880;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    @Override
    public void onLivingUpdate() {
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        if (this.worldObj.isRemote) {
            if (this.rand.nextInt(24) == 0 && !this.isSlient()) {
                this.worldObj.playSound(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "fire.fire", 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f, false);
            }
            for (int llllllllllllllIllllIlIIIIIlllIIl = 0; llllllllllllllIllllIlIIIIIlllIIl < 2; ++llllllllllllllIllllIlIIIIIlllIIl) {
                this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, 0.0, 0.0, 0.0, new int[0]);
            }
        }
        super.onLivingUpdate();
    }
    
    @Override
    public float getBrightness(final float llllllllllllllIllllIlIIIIIllllIl) {
        return 1.0f;
    }
    
    static {
        __OBFID = "CL_00001682";
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllIllllIlIIIIIIllllI, final int llllllllllllllIllllIlIIIIIlIIIlI) {
        if (llllllllllllllIllllIlIIIIIIllllI) {
            for (int llllllllllllllIllllIlIIIIIlIIIIl = this.rand.nextInt(2 + llllllllllllllIllllIlIIIIIlIIIlI), llllllllllllllIllllIlIIIIIlIIIII = 0; llllllllllllllIllllIlIIIIIlIIIII < llllllllllllllIllllIlIIIIIlIIIIl; ++llllllllllllllIllllIlIIIIIlIIIII) {
                this.dropItem(Items.blaze_rod, 1);
            }
        }
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.blaze.death";
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.blaze.breathe";
    }
    
    class AIFireballAttack extends EntityAIBase
    {
        private /* synthetic */ int field_179468_c;
        private /* synthetic */ int field_179467_b;
        
        static {
            __OBFID = "CL_00002225";
        }
        
        @Override
        public void updateTask() {
            --this.field_179468_c;
            final EntityLivingBase lllllllllllllllllllIlIIlIIlIIIll = EntityBlaze.this.getAttackTarget();
            final double lllllllllllllllllllIlIIlIIlIIIlI = EntityBlaze.this.getDistanceSqToEntity(lllllllllllllllllllIlIIlIIlIIIll);
            if (lllllllllllllllllllIlIIlIIlIIIlI < 4.0) {
                if (this.field_179468_c <= 0) {
                    this.field_179468_c = 20;
                    EntityBlaze.this.attackEntityAsMob(lllllllllllllllllllIlIIlIIlIIIll);
                }
                EntityBlaze.this.getMoveHelper().setMoveTo(lllllllllllllllllllIlIIlIIlIIIll.posX, lllllllllllllllllllIlIIlIIlIIIll.posY, lllllllllllllllllllIlIIlIIlIIIll.posZ, 1.0);
            }
            else if (lllllllllllllllllllIlIIlIIlIIIlI < 256.0) {
                final double lllllllllllllllllllIlIIlIIlIIIIl = lllllllllllllllllllIlIIlIIlIIIll.posX - EntityBlaze.this.posX;
                final double lllllllllllllllllllIlIIlIIlIIIII = lllllllllllllllllllIlIIlIIlIIIll.getEntityBoundingBox().minY + lllllllllllllllllllIlIIlIIlIIIll.height / 2.0f - (EntityBlaze.this.posY + EntityBlaze.this.height / 2.0f);
                final double lllllllllllllllllllIlIIlIIIlllll = lllllllllllllllllllIlIIlIIlIIIll.posZ - EntityBlaze.this.posZ;
                if (this.field_179468_c <= 0) {
                    ++this.field_179467_b;
                    if (this.field_179467_b == 1) {
                        this.field_179468_c = 60;
                        EntityBlaze.this.func_70844_e(true);
                    }
                    else if (this.field_179467_b <= 4) {
                        this.field_179468_c = 6;
                    }
                    else {
                        this.field_179468_c = 100;
                        this.field_179467_b = 0;
                        EntityBlaze.this.func_70844_e(false);
                    }
                    if (this.field_179467_b > 1) {
                        final float lllllllllllllllllllIlIIlIIIllllI = MathHelper.sqrt_float(MathHelper.sqrt_double(lllllllllllllllllllIlIIlIIlIIIlI)) * 0.5f;
                        EntityBlaze.this.worldObj.playAuxSFXAtEntity(null, 1009, new BlockPos((int)EntityBlaze.this.posX, (int)EntityBlaze.this.posY, (int)EntityBlaze.this.posZ), 0);
                        for (int lllllllllllllllllllIlIIlIIIlllIl = 0; lllllllllllllllllllIlIIlIIIlllIl < 1; ++lllllllllllllllllllIlIIlIIIlllIl) {
                            final EntitySmallFireball lllllllllllllllllllIlIIlIIIlllII = new EntitySmallFireball(EntityBlaze.this.worldObj, EntityBlaze.this, lllllllllllllllllllIlIIlIIlIIIIl + EntityBlaze.this.getRNG().nextGaussian() * lllllllllllllllllllIlIIlIIIllllI, lllllllllllllllllllIlIIlIIlIIIII, lllllllllllllllllllIlIIlIIIlllll + EntityBlaze.this.getRNG().nextGaussian() * lllllllllllllllllllIlIIlIIIllllI);
                            lllllllllllllllllllIlIIlIIIlllII.posY = EntityBlaze.this.posY + EntityBlaze.this.height / 2.0f + 0.5;
                            EntityBlaze.this.worldObj.spawnEntityInWorld(lllllllllllllllllllIlIIlIIIlllII);
                        }
                    }
                }
                EntityBlaze.this.getLookHelper().setLookPositionWithEntity(lllllllllllllllllllIlIIlIIlIIIll, 10.0f, 10.0f);
            }
            else {
                EntityBlaze.this.getNavigator().clearPathEntity();
                EntityBlaze.this.getMoveHelper().setMoveTo(lllllllllllllllllllIlIIlIIlIIIll.posX, lllllllllllllllllllIlIIlIIlIIIll.posY, lllllllllllllllllllIlIIlIIlIIIll.posZ, 1.0);
            }
            super.updateTask();
        }
        
        @Override
        public void resetTask() {
            EntityBlaze.this.func_70844_e(false);
        }
        
        @Override
        public boolean shouldExecute() {
            final EntityLivingBase lllllllllllllllllllIlIIlIIllIllI = EntityBlaze.this.getAttackTarget();
            return lllllllllllllllllllIlIIlIIllIllI != null && lllllllllllllllllllIlIIlIIllIllI.isEntityAlive();
        }
        
        @Override
        public void startExecuting() {
            this.field_179467_b = 0;
        }
        
        public AIFireballAttack() {
            this.setMutexBits(3);
        }
    }
}
