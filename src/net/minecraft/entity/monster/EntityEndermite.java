package net.minecraft.entity.monster;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;

public class EntityEndermite extends EntityMob
{
    private /* synthetic */ boolean playerSpawned;
    private /* synthetic */ int lifetime;
    
    @Override
    public boolean getCanSpawnHere() {
        if (super.getCanSpawnHere()) {
            final EntityPlayer lllllllllllllllIIIlIIlIIlIlIIIll = this.worldObj.getClosestPlayerToEntity(this, 5.0);
            return lllllllllllllllIIIlIIlIIlIlIIIll == null;
        }
        return false;
    }
    
    public void setSpawnedByPlayer(final boolean lllllllllllllllIIIlIIlIIlIllIIII) {
        this.playerSpawned = lllllllllllllllIIIlIIlIIlIllIIII;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    static {
        __OBFID = "CL_00002219";
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.silverfish.hit";
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.silverfish.kill";
    }
    
    @Override
    public float getEyeHeight() {
        return 0.1f;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.worldObj.isRemote) {
            for (int lllllllllllllllIIIlIIlIIlIlIlIlI = 0; lllllllllllllllIIIlIIlIIlIlIlIlI < 2; ++lllllllllllllllIIIlIIlIIlIlIlIlI) {
                this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
        else {
            if (!this.isNoDespawnRequired()) {
                ++this.lifetime;
            }
            if (this.lifetime >= 2400) {
                this.setDead();
            }
        }
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.silverfish.say";
    }
    
    @Override
    public void onUpdate() {
        this.renderYawOffset = this.rotationYaw;
        super.onUpdate();
    }
    
    public EntityEndermite(final World lllllllllllllllIIIlIIlIIllIlIlII) {
        super(lllllllllllllllIIIlIIlIIllIlIlII);
        this.lifetime = 0;
        this.playerSpawned = false;
        this.experienceValue = 3;
        this.setSize(0.4f, 0.3f);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, false));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    @Override
    protected Item getDropItem() {
        return null;
    }
    
    @Override
    protected void func_180429_a(final BlockPos lllllllllllllllIIIlIIlIIllIIlIIl, final Block lllllllllllllllIIIlIIlIIllIIlIII) {
        this.playSound("mob.silverfish.step", 0.15f, 1.0f);
    }
    
    public boolean isSpawnedByPlayer() {
        return this.playerSpawned;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIIlIIlIIlIllllII) {
        super.writeEntityToNBT(lllllllllllllllIIIlIIlIIlIllllII);
        lllllllllllllllIIIlIIlIIlIllllII.setInteger("Lifetime", this.lifetime);
        lllllllllllllllIIIlIIlIIlIllllII.setBoolean("PlayerSpawned", this.playerSpawned);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIIlIIlIIllIIIIII) {
        super.readEntityFromNBT(lllllllllllllllIIIlIIlIIllIIIIII);
        this.lifetime = lllllllllllllllIIIlIIlIIllIIIIII.getInteger("Lifetime");
        this.playerSpawned = lllllllllllllllIIIlIIlIIllIIIIII.getBoolean("PlayerSpawned");
    }
}
