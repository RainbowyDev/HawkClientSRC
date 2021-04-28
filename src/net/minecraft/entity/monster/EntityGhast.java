package net.minecraft.entity.monster;

import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;

public class EntityGhast extends EntityFlying implements IMob
{
    private /* synthetic */ int explosionStrength;
    
    public EntityGhast(final World llllllllllllllIlIIlllIIlIlIIllll) {
        super(llllllllllllllIlIIlllIIlIlIIllll);
        this.explosionStrength = 1;
        this.setSize(4.0f, 4.0f);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
        this.moveHelper = new GhastMoveHelper();
        this.tasks.addTask(5, new AIRandomFly());
        this.tasks.addTask(7, new AILookAround());
        this.tasks.addTask(7, new AIFireballAttack());
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
    }
    
    public boolean func_110182_bF() {
        return this.dataWatcher.getWatchableObjectByte(16) != 0;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlIIlllIIlIIIlIlll) {
        super.writeEntityToNBT(llllllllllllllIlIIlllIIlIIIlIlll);
        llllllllllllllIlIIlllIIlIIIlIlll.setInteger("ExplosionPower", this.explosionStrength);
    }
    
    public void func_175454_a(final boolean llllllllllllllIlIIlllIIlIlIIlIII) {
        this.dataWatcher.updateObject(16, (byte)(byte)(llllllllllllllIlIIlllIIlIlIIlIII ? 1 : 0));
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllIlIIlllIIlIIlIIlll, final int llllllllllllllIlIIlllIIlIIlIIIlI) {
        for (int llllllllllllllIlIIlllIIlIIlIIlIl = this.rand.nextInt(2) + this.rand.nextInt(1 + llllllllllllllIlIIlllIIlIIlIIIlI), llllllllllllllIlIIlllIIlIIlIIlII = 0; llllllllllllllIlIIlllIIlIIlIIlII < llllllllllllllIlIIlllIIlIIlIIlIl; ++llllllllllllllIlIIlllIIlIIlIIlII) {
            this.dropItem(Items.ghast_tear, 1);
        }
        for (int llllllllllllllIlIIlllIIlIIlIIlIl = this.rand.nextInt(3) + this.rand.nextInt(1 + llllllllllllllIlIIlllIIlIIlIIIlI), llllllllllllllIlIIlllIIlIIlIIlII = 0; llllllllllllllIlIIlllIIlIIlIIlII < llllllllllllllIlIIlllIIlIIlIIlIl; ++llllllllllllllIlIIlllIIlIIlIIlII) {
            this.dropItem(Items.gunpowder, 1);
        }
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.ghast.moan";
    }
    
    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0);
    }
    
    @Override
    public float getEyeHeight() {
        return 2.6f;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlIIlllIIlIIIIllll) {
        super.readEntityFromNBT(llllllllllllllIlIIlllIIlIIIIllll);
        if (llllllllllllllIlIIlllIIlIIIIllll.hasKey("ExplosionPower", 99)) {
            this.explosionStrength = llllllllllllllIlIIlllIIlIIIIllll.getInteger("ExplosionPower");
        }
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.ghast.scream";
    }
    
    @Override
    protected Item getDropItem() {
        return Items.gunpowder;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
    }
    
    public int func_175453_cd() {
        return this.explosionStrength;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIlIIlllIIlIIlllIll, final float llllllllllllllIlIIlllIIlIIlllIlI) {
        if (this.func_180431_b(llllllllllllllIlIIlllIIlIIlllIll)) {
            return false;
        }
        if ("fireball".equals(llllllllllllllIlIIlllIIlIIlllIll.getDamageType()) && llllllllllllllIlIIlllIIlIIlllIll.getEntity() instanceof EntityPlayer) {
            super.attackEntityFrom(llllllllllllllIlIIlllIIlIIlllIll, 1000.0f);
            ((EntityPlayer)llllllllllllllIlIIlllIIlIIlllIll.getEntity()).triggerAchievement(AchievementList.ghast);
            return true;
        }
        return super.attackEntityFrom(llllllllllllllIlIIlllIIlIIlllIll, llllllllllllllIlIIlllIIlIIlllIlI);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.ghast.death";
    }
    
    @Override
    protected float getSoundVolume() {
        return 10.0f;
    }
    
    static {
        __OBFID = "CL_00001689";
    }
    
    class AIFireballAttack extends EntityAIBase
    {
        public /* synthetic */ int field_179471_a;
        
        static {
            __OBFID = "CL_00002215";
        }
        
        @Override
        public boolean shouldExecute() {
            return EntityGhast.this.getAttackTarget() != null;
        }
        
        @Override
        public void startExecuting() {
            this.field_179471_a = 0;
        }
        
        @Override
        public void updateTask() {
            final EntityLivingBase llllllllllllllIIIlIllIIlllIIIIlI = EntityGhast.this.getAttackTarget();
            final double llllllllllllllIIIlIllIIlllIIIIIl = 64.0;
            if (llllllllllllllIIIlIllIIlllIIIIlI.getDistanceSqToEntity(EntityGhast.this) < llllllllllllllIIIlIllIIlllIIIIIl * llllllllllllllIIIlIllIIlllIIIIIl && EntityGhast.this.canEntityBeSeen(llllllllllllllIIIlIllIIlllIIIIlI)) {
                final World llllllllllllllIIIlIllIIlllIIIIII = EntityGhast.this.worldObj;
                ++this.field_179471_a;
                if (this.field_179471_a == 10) {
                    llllllllllllllIIIlIllIIlllIIIIII.playAuxSFXAtEntity(null, 1007, new BlockPos(EntityGhast.this), 0);
                }
                if (this.field_179471_a == 20) {
                    final double llllllllllllllIIIlIllIIllIllllll = 4.0;
                    final Vec3 llllllllllllllIIIlIllIIllIlllllI = EntityGhast.this.getLook(1.0f);
                    final double llllllllllllllIIIlIllIIllIllllIl = llllllllllllllIIIlIllIIlllIIIIlI.posX - (EntityGhast.this.posX + llllllllllllllIIIlIllIIllIlllllI.xCoord * llllllllllllllIIIlIllIIllIllllll);
                    final double llllllllllllllIIIlIllIIllIllllII = llllllllllllllIIIlIllIIlllIIIIlI.getEntityBoundingBox().minY + llllllllllllllIIIlIllIIlllIIIIlI.height / 2.0f - (0.5 + EntityGhast.this.posY + EntityGhast.this.height / 2.0f);
                    final double llllllllllllllIIIlIllIIllIlllIll = llllllllllllllIIIlIllIIlllIIIIlI.posZ - (EntityGhast.this.posZ + llllllllllllllIIIlIllIIllIlllllI.zCoord * llllllllllllllIIIlIllIIllIllllll);
                    llllllllllllllIIIlIllIIlllIIIIII.playAuxSFXAtEntity(null, 1008, new BlockPos(EntityGhast.this), 0);
                    final EntityLargeFireball llllllllllllllIIIlIllIIllIlllIlI = new EntityLargeFireball(llllllllllllllIIIlIllIIlllIIIIII, EntityGhast.this, llllllllllllllIIIlIllIIllIllllIl, llllllllllllllIIIlIllIIllIllllII, llllllllllllllIIIlIllIIllIlllIll);
                    llllllllllllllIIIlIllIIllIlllIlI.field_92057_e = EntityGhast.this.func_175453_cd();
                    llllllllllllllIIIlIllIIllIlllIlI.posX = EntityGhast.this.posX + llllllllllllllIIIlIllIIllIlllllI.xCoord * llllllllllllllIIIlIllIIllIllllll;
                    llllllllllllllIIIlIllIIllIlllIlI.posY = EntityGhast.this.posY + EntityGhast.this.height / 2.0f + 0.5;
                    llllllllllllllIIIlIllIIllIlllIlI.posZ = EntityGhast.this.posZ + llllllllllllllIIIlIllIIllIlllllI.zCoord * llllllllllllllIIIlIllIIllIllllll;
                    llllllllllllllIIIlIllIIlllIIIIII.spawnEntityInWorld(llllllllllllllIIIlIllIIllIlllIlI);
                    this.field_179471_a = -40;
                }
            }
            else if (this.field_179471_a > 0) {
                --this.field_179471_a;
            }
            EntityGhast.this.func_175454_a(this.field_179471_a > 10);
        }
        
        @Override
        public void resetTask() {
            EntityGhast.this.func_175454_a(false);
        }
    }
    
    class AIRandomFly extends EntityAIBase
    {
        @Override
        public void startExecuting() {
            final Random llllllllllllllllIIlIIlIIllIIlIll = EntityGhast.this.getRNG();
            final double llllllllllllllllIIlIIlIIllIIlIlI = EntityGhast.this.posX + (llllllllllllllllIIlIIlIIllIIlIll.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double llllllllllllllllIIlIIlIIllIIlIIl = EntityGhast.this.posY + (llllllllllllllllIIlIIlIIllIIlIll.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double llllllllllllllllIIlIIlIIllIIlIII = EntityGhast.this.posZ + (llllllllllllllllIIlIIlIIllIIlIll.nextFloat() * 2.0f - 1.0f) * 16.0f;
            EntityGhast.this.getMoveHelper().setMoveTo(llllllllllllllllIIlIIlIIllIIlIlI, llllllllllllllllIIlIIlIIllIIlIIl, llllllllllllllllIIlIIlIIllIIlIII, 1.0);
        }
        
        @Override
        public boolean shouldExecute() {
            final EntityMoveHelper llllllllllllllllIIlIIlIIllIlllIl = EntityGhast.this.getMoveHelper();
            if (!llllllllllllllllIIlIIlIIllIlllIl.isUpdating()) {
                return true;
            }
            final double llllllllllllllllIIlIIlIIllIlllII = llllllllllllllllIIlIIlIIllIlllIl.func_179917_d() - EntityGhast.this.posX;
            final double llllllllllllllllIIlIIlIIllIllIll = llllllllllllllllIIlIIlIIllIlllIl.func_179919_e() - EntityGhast.this.posY;
            final double llllllllllllllllIIlIIlIIllIllIlI = llllllllllllllllIIlIIlIIllIlllIl.func_179918_f() - EntityGhast.this.posZ;
            final double llllllllllllllllIIlIIlIIllIllIIl = llllllllllllllllIIlIIlIIllIlllII * llllllllllllllllIIlIIlIIllIlllII + llllllllllllllllIIlIIlIIllIllIll * llllllllllllllllIIlIIlIIllIllIll + llllllllllllllllIIlIIlIIllIllIlI * llllllllllllllllIIlIIlIIllIllIlI;
            return llllllllllllllllIIlIIlIIllIllIIl < 1.0 || llllllllllllllllIIlIIlIIllIllIIl > 3600.0;
        }
        
        static {
            __OBFID = "CL_00002214";
        }
        
        public AIRandomFly() {
            this.setMutexBits(1);
        }
        
        @Override
        public boolean continueExecuting() {
            return false;
        }
    }
    
    class GhastMoveHelper extends EntityMoveHelper
    {
        private /* synthetic */ int field_179928_h;
        
        @Override
        public void onUpdateMoveHelper() {
            if (this.update) {
                final double llllllllllllllIlIllllIlllllIIIll = this.posX - EntityGhast.this.posX;
                final double llllllllllllllIlIllllIlllllIIIlI = this.posY - EntityGhast.this.posY;
                final double llllllllllllllIlIllllIlllllIIIIl = this.posZ - EntityGhast.this.posZ;
                double llllllllllllllIlIllllIlllllIIIII = llllllllllllllIlIllllIlllllIIIll * llllllllllllllIlIllllIlllllIIIll + llllllllllllllIlIllllIlllllIIIlI * llllllllllllllIlIllllIlllllIIIlI + llllllllllllllIlIllllIlllllIIIIl * llllllllllllllIlIllllIlllllIIIIl;
                if (this.field_179928_h-- <= 0) {
                    this.field_179928_h += EntityGhast.this.getRNG().nextInt(5) + 2;
                    llllllllllllllIlIllllIlllllIIIII = MathHelper.sqrt_double(llllllllllllllIlIllllIlllllIIIII);
                    if (this.func_179926_b(this.posX, this.posY, this.posZ, llllllllllllllIlIllllIlllllIIIII)) {
                        final EntityGhast field_179927_g = EntityGhast.this;
                        field_179927_g.motionX += llllllllllllllIlIllllIlllllIIIll / llllllllllllllIlIllllIlllllIIIII * 0.1;
                        final EntityGhast field_179927_g2 = EntityGhast.this;
                        field_179927_g2.motionY += llllllllllllllIlIllllIlllllIIIlI / llllllllllllllIlIllllIlllllIIIII * 0.1;
                        final EntityGhast field_179927_g3 = EntityGhast.this;
                        field_179927_g3.motionZ += llllllllllllllIlIllllIlllllIIIIl / llllllllllllllIlIllllIlllllIIIII * 0.1;
                    }
                    else {
                        this.update = false;
                    }
                }
            }
        }
        
        public GhastMoveHelper() {
            super(EntityGhast.this);
        }
        
        private boolean func_179926_b(final double llllllllllllllIlIllllIllllIIIlII, final double llllllllllllllIlIllllIllllIIIIll, final double llllllllllllllIlIllllIllllIIllIl, final double llllllllllllllIlIllllIllllIIIIIl) {
            final double llllllllllllllIlIllllIllllIIlIll = (llllllllllllllIlIllllIllllIIIlII - EntityGhast.this.posX) / llllllllllllllIlIllllIllllIIIIIl;
            final double llllllllllllllIlIllllIllllIIlIlI = (llllllllllllllIlIllllIllllIIIIll - EntityGhast.this.posY) / llllllllllllllIlIllllIllllIIIIIl;
            final double llllllllllllllIlIllllIllllIIlIIl = (llllllllllllllIlIllllIllllIIllIl - EntityGhast.this.posZ) / llllllllllllllIlIllllIllllIIIIIl;
            AxisAlignedBB llllllllllllllIlIllllIllllIIlIII = EntityGhast.this.getEntityBoundingBox();
            for (int llllllllllllllIlIllllIllllIIIlll = 1; llllllllllllllIlIllllIllllIIIlll < llllllllllllllIlIllllIllllIIIIIl; ++llllllllllllllIlIllllIllllIIIlll) {
                llllllllllllllIlIllllIllllIIlIII = llllllllllllllIlIllllIllllIIlIII.offset(llllllllllllllIlIllllIllllIIlIll, llllllllllllllIlIllllIllllIIlIlI, llllllllllllllIlIllllIllllIIlIIl);
                if (!EntityGhast.this.worldObj.getCollidingBoundingBoxes(EntityGhast.this, llllllllllllllIlIllllIllllIIlIII).isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00002216";
        }
    }
    
    class AILookAround extends EntityAIBase
    {
        @Override
        public void updateTask() {
            if (EntityGhast.this.getAttackTarget() == null) {
                final EntityGhast field_179472_a = EntityGhast.this;
                final EntityGhast field_179472_a2 = EntityGhast.this;
                final float n = -(float)Math.atan2(EntityGhast.this.motionX, EntityGhast.this.motionZ) * 180.0f / 3.1415927f;
                field_179472_a2.rotationYaw = n;
                field_179472_a.renderYawOffset = n;
            }
            else {
                final EntityLivingBase llIIlIIllIIlll = EntityGhast.this.getAttackTarget();
                final double llIIlIIllIIllI = 64.0;
                if (llIIlIIllIIlll.getDistanceSqToEntity(EntityGhast.this) < llIIlIIllIIllI * llIIlIIllIIllI) {
                    final double llIIlIIllIIlIl = llIIlIIllIIlll.posX - EntityGhast.this.posX;
                    final double llIIlIIllIIlII = llIIlIIllIIlll.posZ - EntityGhast.this.posZ;
                    final EntityGhast field_179472_a3 = EntityGhast.this;
                    final EntityGhast field_179472_a4 = EntityGhast.this;
                    final float n2 = -(float)Math.atan2(llIIlIIllIIlIl, llIIlIIllIIlII) * 180.0f / 3.1415927f;
                    field_179472_a4.rotationYaw = n2;
                    field_179472_a3.renderYawOffset = n2;
                }
            }
        }
        
        public AILookAround() {
            this.setMutexBits(2);
        }
        
        static {
            __OBFID = "CL_00002217";
        }
        
        @Override
        public boolean shouldExecute() {
            return true;
        }
    }
}
