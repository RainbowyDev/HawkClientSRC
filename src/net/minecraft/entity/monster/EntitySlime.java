package net.minecraft.entity.monster;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.pathfinding.*;

public class EntitySlime extends EntityLiving implements IMob
{
    public /* synthetic */ float prevSquishFactor;
    public /* synthetic */ float squishFactor;
    public /* synthetic */ float squishAmount;
    private /* synthetic */ boolean field_175452_bi;
    
    public int getSlimeSize() {
        return this.dataWatcher.getWatchableObjectByte(16);
    }
    
    @Override
    protected Item getDropItem() {
        return (this.getSlimeSize() == 1) ? Items.slime_ball : null;
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance lllllllllllllllIIIlIllIllIlIllIl, final IEntityLivingData lllllllllllllllIIIlIllIllIlIllII) {
        int lllllllllllllllIIIlIllIllIllIIII = this.rand.nextInt(3);
        if (lllllllllllllllIIIlIllIllIllIIII < 2 && this.rand.nextFloat() < 0.5f * lllllllllllllllIIIlIllIllIlIllIl.func_180170_c()) {
            ++lllllllllllllllIIIlIllIllIllIIII;
        }
        final int lllllllllllllllIIIlIllIllIlIllll = 1 << lllllllllllllllIIIlIllIllIllIIII;
        this.setSlimeSize(lllllllllllllllIIIlIllIllIlIllll);
        return super.func_180482_a(lllllllllllllllIIIlIllIllIlIllIl, lllllllllllllllIIIlIllIllIlIllII);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        final Chunk lllllllllllllllIIIlIllIlllIIlllI = this.worldObj.getChunkFromBlockCoords(new BlockPos(MathHelper.floor_double(this.posX), 0, MathHelper.floor_double(this.posZ)));
        if (this.worldObj.getWorldInfo().getTerrainType() == WorldType.FLAT && this.rand.nextInt(4) != 1) {
            return false;
        }
        if (this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL) {
            final BiomeGenBase lllllllllllllllIIIlIllIlllIIllIl = this.worldObj.getBiomeGenForCoords(new BlockPos(MathHelper.floor_double(this.posX), 0, MathHelper.floor_double(this.posZ)));
            if (lllllllllllllllIIIlIllIlllIIllIl == BiomeGenBase.swampland && this.posY > 50.0 && this.posY < 70.0 && this.rand.nextFloat() < 0.5f && this.rand.nextFloat() < this.worldObj.getCurrentMoonPhaseFactor() && this.worldObj.getLightFromNeighbors(new BlockPos(this)) <= this.rand.nextInt(8)) {
                return super.getCanSpawnHere();
            }
            if (this.rand.nextInt(10) == 0 && lllllllllllllllIIIlIllIlllIIlllI.getRandomWithSeed(987234911L).nextInt(10) == 0 && this.posY < 40.0) {
                return super.getCanSpawnHere();
            }
        }
        return false;
    }
    
    public EntitySlime(final World lllllllllllllllIIIlIlllIlIIIIIlI) {
        super(lllllllllllllllIIIlIlllIlIIIIIlI);
        this.moveHelper = new SlimeMoveHelper();
        this.tasks.addTask(1, new AISlimeFloat());
        this.tasks.addTask(2, new AISlimeAttack());
        this.tasks.addTask(3, new AISlimeFaceRandom());
        this.tasks.addTask(5, new AISlimeHop());
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
        this.targetTasks.addTask(3, new EntityAIFindEntityNearest(this, EntityIronGolem.class));
    }
    
    protected boolean makesSoundOnJump() {
        return this.getSlimeSize() > 0;
    }
    
    @Override
    public float getEyeHeight() {
        return 0.625f * this.height;
    }
    
    protected EnumParticleTypes func_180487_n() {
        return EnumParticleTypes.SLIME;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIIlIlllIIllIlIll) {
        super.readEntityFromNBT(lllllllllllllllIIIlIlllIIllIlIll);
        int lllllllllllllllIIIlIlllIIllIlIlI = lllllllllllllllIIIlIlllIIllIlIll.getInteger("Size");
        if (lllllllllllllllIIIlIlllIIllIlIlI < 0) {
            lllllllllllllllIIIlIlllIIllIlIlI = 0;
        }
        this.setSlimeSize(lllllllllllllllIIIlIlllIIllIlIlI + 1);
        this.field_175452_bi = lllllllllllllllIIIlIlllIIllIlIll.getBoolean("wasOnGround");
    }
    
    @Override
    protected String getHurtSound() {
        return String.valueOf(new StringBuilder("mob.slime.").append((this.getSlimeSize() > 1) ? "big" : "small"));
    }
    
    @Override
    public void onUpdate() {
        if (!this.worldObj.isRemote && this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0) {
            this.isDead = true;
        }
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5f;
        this.prevSquishFactor = this.squishFactor;
        super.onUpdate();
        if (this.onGround && !this.field_175452_bi) {
            for (int lllllllllllllllIIIlIlllIIlIlIllI = this.getSlimeSize(), lllllllllllllllIIIlIlllIIlIlIlIl = 0; lllllllllllllllIIIlIlllIIlIlIlIl < lllllllllllllllIIIlIlllIIlIlIllI * 8; ++lllllllllllllllIIIlIlllIIlIlIlIl) {
                final float lllllllllllllllIIIlIlllIIlIlIlII = this.rand.nextFloat() * 3.1415927f * 2.0f;
                final float lllllllllllllllIIIlIlllIIlIlIIll = this.rand.nextFloat() * 0.5f + 0.5f;
                final float lllllllllllllllIIIlIlllIIlIlIIlI = MathHelper.sin(lllllllllllllllIIIlIlllIIlIlIlII) * lllllllllllllllIIIlIlllIIlIlIllI * 0.5f * lllllllllllllllIIIlIlllIIlIlIIll;
                final float lllllllllllllllIIIlIlllIIlIlIIIl = MathHelper.cos(lllllllllllllllIIIlIlllIIlIlIlII) * lllllllllllllllIIIlIlllIIlIlIllI * 0.5f * lllllllllllllllIIIlIlllIIlIlIIll;
                final World lllllllllllllllIIIlIlllIIlIlIIII = this.worldObj;
                final EnumParticleTypes lllllllllllllllIIIlIlllIIlIIllll = this.func_180487_n();
                final double lllllllllllllllIIIlIlllIIlIIlllI = this.posX + lllllllllllllllIIIlIlllIIlIlIIlI;
                final double lllllllllllllllIIIlIlllIIlIIllIl = this.posZ + lllllllllllllllIIIlIlllIIlIlIIIl;
                lllllllllllllllIIIlIlllIIlIlIIII.spawnParticle(lllllllllllllllIIIlIlllIIlIIllll, lllllllllllllllIIIlIlllIIlIIlllI, this.getEntityBoundingBox().minY, lllllllllllllllIIIlIlllIIlIIllIl, 0.0, 0.0, 0.0, new int[0]);
            }
            if (this.makesSoundOnLand()) {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            }
            this.squishAmount = -0.5f;
        }
        else if (!this.onGround && this.field_175452_bi) {
            this.squishAmount = 1.0f;
        }
        this.field_175452_bi = this.onGround;
        this.alterSquishAmount();
    }
    
    protected void alterSquishAmount() {
        this.squishAmount *= 0.6f;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f * this.getSlimeSize();
    }
    
    protected String getJumpSound() {
        return String.valueOf(new StringBuilder("mob.slime.").append((this.getSlimeSize() > 1) ? "big" : "small"));
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIIlIlllIIlllIIlI) {
        super.writeEntityToNBT(lllllllllllllllIIIlIlllIIlllIIlI);
        lllllllllllllllIIIlIlllIIlllIIlI.setInteger("Size", this.getSlimeSize() - 1);
        lllllllllllllllIIIlIlllIIlllIIlI.setBoolean("wasOnGround", this.field_175452_bi);
    }
    
    @Override
    protected void jump() {
        this.motionY = 0.41999998688697815;
        this.isAirBorne = true;
    }
    
    @Override
    public void onCollideWithPlayer(final EntityPlayer lllllllllllllllIIIlIlllIIIIlIIIl) {
        if (this.canDamagePlayer()) {
            this.func_175451_e(lllllllllllllllIIIlIlllIIIIlIIIl);
        }
    }
    
    protected boolean makesSoundOnLand() {
        return this.getSlimeSize() > 2;
    }
    
    protected void func_175451_e(final EntityLivingBase lllllllllllllllIIIlIlllIIIIIlIlI) {
        final int lllllllllllllllIIIlIlllIIIIIlIIl = this.getSlimeSize();
        if (this.canEntityBeSeen(lllllllllllllllIIIlIlllIIIIIlIlI) && this.getDistanceSqToEntity(lllllllllllllllIIIlIlllIIIIIlIlI) < 0.6 * lllllllllllllllIIIlIlllIIIIIlIIl * 0.6 * lllllllllllllllIIIlIlllIIIIIlIIl && lllllllllllllllIIIlIlllIIIIIlIlI.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.getAttackStrength())) {
            this.playSound("mob.attack", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.func_174815_a(this, lllllllllllllllIIIlIlllIIIIIlIlI);
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 1);
    }
    
    @Override
    public void setDead() {
        final int lllllllllllllllIIIlIlllIIIlIIlll = this.getSlimeSize();
        if (!this.worldObj.isRemote && lllllllllllllllIIIlIlllIIIlIIlll > 1 && this.getHealth() <= 0.0f) {
            for (int lllllllllllllllIIIlIlllIIIlIIllI = 2 + this.rand.nextInt(3), lllllllllllllllIIIlIlllIIIlIIlIl = 0; lllllllllllllllIIIlIlllIIIlIIlIl < lllllllllllllllIIIlIlllIIIlIIllI; ++lllllllllllllllIIIlIlllIIIlIIlIl) {
                final float lllllllllllllllIIIlIlllIIIlIIlII = (lllllllllllllllIIIlIlllIIIlIIlIl % 2 - 0.5f) * lllllllllllllllIIIlIlllIIIlIIlll / 4.0f;
                final float lllllllllllllllIIIlIlllIIIlIIIll = (lllllllllllllllIIIlIlllIIIlIIlIl / 2 - 0.5f) * lllllllllllllllIIIlIlllIIIlIIlll / 4.0f;
                final EntitySlime lllllllllllllllIIIlIlllIIIlIIIlI = this.createInstance();
                if (this.hasCustomName()) {
                    lllllllllllllllIIIlIlllIIIlIIIlI.setCustomNameTag(this.getCustomNameTag());
                }
                if (this.isNoDespawnRequired()) {
                    lllllllllllllllIIIlIlllIIIlIIIlI.enablePersistence();
                }
                lllllllllllllllIIIlIlllIIIlIIIlI.setSlimeSize(lllllllllllllllIIIlIlllIIIlIIlll / 2);
                lllllllllllllllIIIlIlllIIIlIIIlI.setLocationAndAngles(this.posX + lllllllllllllllIIIlIlllIIIlIIlII, this.posY + 0.5, this.posZ + lllllllllllllllIIIlIlllIIIlIIIll, this.rand.nextFloat() * 360.0f, 0.0f);
                this.worldObj.spawnEntityInWorld(lllllllllllllllIIIlIlllIIIlIIIlI);
            }
        }
        super.setDead();
    }
    
    protected EntitySlime createInstance() {
        return new EntitySlime(this.worldObj);
    }
    
    protected boolean canDamagePlayer() {
        return this.getSlimeSize() > 1;
    }
    
    static {
        __OBFID = "CL_00001698";
    }
    
    protected int getAttackStrength() {
        return this.getSlimeSize();
    }
    
    @Override
    public int getVerticalFaceSpeed() {
        return 0;
    }
    
    protected int getJumpDelay() {
        return this.rand.nextInt(20) + 10;
    }
    
    @Override
    public void func_145781_i(final int lllllllllllllllIIIlIlllIIIllIIIl) {
        if (lllllllllllllllIIIlIlllIIIllIIIl == 16) {
            final int lllllllllllllllIIIlIlllIIIllIIll = this.getSlimeSize();
            this.setSize(0.51000005f * lllllllllllllllIIIlIlllIIIllIIll, 0.51000005f * lllllllllllllllIIIlIlllIIIllIIll);
            this.rotationYaw = this.rotationYawHead;
            this.renderYawOffset = this.rotationYawHead;
            if (this.isInWater() && this.rand.nextInt(20) == 0) {
                this.resetHeight();
            }
        }
        super.func_145781_i(lllllllllllllllIIIlIlllIIIllIIIl);
    }
    
    protected void setSlimeSize(final int lllllllllllllllIIIlIlllIIllllIll) {
        this.dataWatcher.updateObject(16, (byte)lllllllllllllllIIIlIlllIIllllIll);
        this.setSize(0.51000005f * lllllllllllllllIIIlIlllIIllllIll, 0.51000005f * lllllllllllllllIIIlIlllIIllllIll);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(lllllllllllllllIIIlIlllIIllllIll * lllllllllllllllIIIlIlllIIllllIll);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2f + 0.1f * lllllllllllllllIIIlIlllIIllllIll);
        this.setHealth(this.getMaxHealth());
        this.experienceValue = lllllllllllllllIIIlIlllIIllllIll;
    }
    
    @Override
    protected String getDeathSound() {
        return String.valueOf(new StringBuilder("mob.slime.").append((this.getSlimeSize() > 1) ? "big" : "small"));
    }
    
    @Override
    public void applyEntityCollision(final Entity lllllllllllllllIIIlIlllIIIIlIlll) {
        super.applyEntityCollision(lllllllllllllllIIIlIlllIIIIlIlll);
        if (lllllllllllllllIIIlIlllIIIIlIlll instanceof EntityIronGolem && this.canDamagePlayer()) {
            this.func_175451_e((EntityLivingBase)lllllllllllllllIIIlIlllIIIIlIlll);
        }
    }
    
    class SlimeMoveHelper extends EntityMoveHelper
    {
        private /* synthetic */ int field_179924_h;
        private /* synthetic */ boolean field_179923_j;
        private /* synthetic */ float field_179922_g;
        
        static {
            __OBFID = "CL_00002199";
        }
        
        public void func_179921_a(final double llllllllllllllIlIllIlIllIIllIIIl) {
            this.speed = llllllllllllllIlIllIlIllIIllIIIl;
            this.update = true;
        }
        
        public SlimeMoveHelper() {
            super(EntitySlime.this);
        }
        
        @Override
        public void onUpdateMoveHelper() {
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.field_179922_g, 30.0f);
            this.entity.rotationYawHead = this.entity.rotationYaw;
            this.entity.renderYawOffset = this.entity.rotationYaw;
            if (!this.update) {
                this.entity.setMoveForward(0.0f);
            }
            else {
                this.update = false;
                if (this.entity.onGround) {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()));
                    if (this.field_179924_h-- <= 0) {
                        this.field_179924_h = EntitySlime.this.getJumpDelay();
                        if (this.field_179923_j) {
                            this.field_179924_h /= 3;
                        }
                        EntitySlime.this.getJumpHelper().setJumping();
                        if (EntitySlime.this.makesSoundOnJump()) {
                            EntitySlime.this.playSound(EntitySlime.this.getJumpSound(), EntitySlime.this.getSoundVolume(), ((EntitySlime.this.getRNG().nextFloat() - EntitySlime.this.getRNG().nextFloat()) * 0.2f + 1.0f) * 0.8f);
                        }
                    }
                    else {
                        final EntitySlime field_179925_i = EntitySlime.this;
                        final EntitySlime field_179925_i2 = EntitySlime.this;
                        final float n = 0.0f;
                        field_179925_i2.moveForward = n;
                        field_179925_i.moveStrafing = n;
                        this.entity.setAIMoveSpeed(0.0f);
                    }
                }
                else {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()));
                }
            }
        }
        
        public void func_179920_a(final float llllllllllllllIlIllIlIllIIlllIll, final boolean llllllllllllllIlIllIlIllIIlllIlI) {
            this.field_179922_g = llllllllllllllIlIllIlIllIIlllIll;
            this.field_179923_j = llllllllllllllIlIllIlIllIIlllIlI;
        }
    }
    
    class AISlimeHop extends EntityAIBase
    {
        @Override
        public boolean shouldExecute() {
            return true;
        }
        
        public AISlimeHop() {
            this.setMutexBits(5);
        }
        
        @Override
        public void updateTask() {
            ((SlimeMoveHelper)EntitySlime.this.getMoveHelper()).func_179921_a(1.0);
        }
        
        static {
            __OBFID = "CL_00002200";
        }
    }
    
    class AISlimeAttack extends EntityAIBase
    {
        private /* synthetic */ int field_179465_b;
        
        @Override
        public void startExecuting() {
            this.field_179465_b = 300;
            super.startExecuting();
        }
        
        @Override
        public boolean shouldExecute() {
            final EntityLivingBase llllllllllllllIlIIllIIIlllIIlllI = EntitySlime.this.getAttackTarget();
            return llllllllllllllIlIIllIIIlllIIlllI != null && llllllllllllllIlIIllIIIlllIIlllI.isEntityAlive();
        }
        
        @Override
        public boolean continueExecuting() {
            final EntityLivingBase llllllllllllllIlIIllIIIlllIIIlIl = EntitySlime.this.getAttackTarget();
            boolean b;
            if (llllllllllllllIlIIllIIIlllIIIlIl == null) {
                b = false;
            }
            else if (!llllllllllllllIlIIllIIIlllIIIlIl.isEntityAlive()) {
                b = false;
            }
            else {
                final int field_179465_b = this.field_179465_b - 1;
                this.field_179465_b = field_179465_b;
                b = (field_179465_b > 0);
            }
            return b;
        }
        
        static {
            __OBFID = "CL_00002202";
        }
        
        @Override
        public void updateTask() {
            EntitySlime.this.faceEntity(EntitySlime.this.getAttackTarget(), 10.0f, 10.0f);
            ((SlimeMoveHelper)EntitySlime.this.getMoveHelper()).func_179920_a(EntitySlime.this.rotationYaw, EntitySlime.this.canDamagePlayer());
        }
        
        public AISlimeAttack() {
            this.setMutexBits(2);
        }
    }
    
    class AISlimeFloat extends EntityAIBase
    {
        static {
            __OBFID = "CL_00002201";
        }
        
        @Override
        public void updateTask() {
            if (EntitySlime.this.getRNG().nextFloat() < 0.8f) {
                EntitySlime.this.getJumpHelper().setJumping();
            }
            ((SlimeMoveHelper)EntitySlime.this.getMoveHelper()).func_179921_a(1.2);
        }
        
        @Override
        public boolean shouldExecute() {
            return EntitySlime.this.isInWater() || EntitySlime.this.func_180799_ab();
        }
        
        public AISlimeFloat() {
            this.setMutexBits(5);
            ((PathNavigateGround)EntitySlime.this.getNavigator()).func_179693_d(true);
        }
    }
    
    class AISlimeFaceRandom extends EntityAIBase
    {
        private /* synthetic */ int field_179460_c;
        private /* synthetic */ float field_179459_b;
        
        public AISlimeFaceRandom() {
            this.setMutexBits(2);
        }
        
        @Override
        public boolean shouldExecute() {
            return EntitySlime.this.getAttackTarget() == null && (EntitySlime.this.onGround || EntitySlime.this.isInWater() || EntitySlime.this.func_180799_ab());
        }
        
        static {
            __OBFID = "CL_00002198";
        }
        
        @Override
        public void updateTask() {
            final int field_179460_c = this.field_179460_c - 1;
            this.field_179460_c = field_179460_c;
            if (field_179460_c <= 0) {
                this.field_179460_c = 40 + EntitySlime.this.getRNG().nextInt(60);
                this.field_179459_b = (float)EntitySlime.this.getRNG().nextInt(360);
            }
            ((SlimeMoveHelper)EntitySlime.this.getMoveHelper()).func_179920_a(this.field_179459_b, false);
        }
    }
}
