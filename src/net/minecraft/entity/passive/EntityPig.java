package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public class EntityPig extends EntityAnimal
{
    private final /* synthetic */ EntityAIControlledByPlayer aiControlledByPlayer;
    
    @Override
    public void fall(final float llllllllllllllllIIIIlIlllllIIIll, final float llllllllllllllllIIIIlIlllllIIIIl) {
        super.fall(llllllllllllllllIIIIlIlllllIIIll, llllllllllllllllIIIIlIlllllIIIIl);
        if (llllllllllllllllIIIIlIlllllIIIll > 5.0f && this.riddenByEntity instanceof EntityPlayer) {
            ((EntityPlayer)this.riddenByEntity).triggerAchievement(AchievementList.flyPig);
        }
    }
    
    @Override
    public EntityPig createChild(final EntityAgeable llllllllllllllllIIIIlIllllIllIlI) {
        return new EntityPig(this.worldObj);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIIIllIIIIllIllI) {
        super.writeEntityToNBT(llllllllllllllllIIIIllIIIIllIllI);
        llllllllllllllllIIIIllIIIIllIllI.setBoolean("Saddle", this.getSaddled());
    }
    
    @Override
    public boolean canBeSteered() {
        final ItemStack llllllllllllllllIIIIllIIIlIIIIIl = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return llllllllllllllllIIIIllIIIlIIIIIl != null && llllllllllllllllIIIIllIIIlIIIIIl.getItem() == Items.carrot_on_a_stick;
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.pig.death";
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }
    
    @Override
    public void onStruckByLightning(final EntityLightningBolt llllllllllllllllIIIIlIlllllllIlI) {
        if (!this.worldObj.isRemote) {
            final EntityPigZombie llllllllllllllllIIIIlIlllllllIII = new EntityPigZombie(this.worldObj);
            llllllllllllllllIIIIlIlllllllIII.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
            llllllllllllllllIIIIlIlllllllIII.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(llllllllllllllllIIIIlIlllllllIII);
            this.setDead();
        }
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack llllllllllllllllIIIIlIllllIlIlII) {
        return llllllllllllllllIIIIlIllllIlIlII != null && llllllllllllllllIIIIlIllllIlIlII.getItem() == Items.carrot;
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.pig.say";
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.pig.say";
    }
    
    @Override
    protected Item getDropItem() {
        return this.isBurning() ? Items.cooked_porkchop : Items.porkchop;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }
    
    public EntityAIControlledByPlayer getAIControlledByPlayer() {
        return this.aiControlledByPlayer;
    }
    
    public void setSaddled(final boolean llllllllllllllllIIIIllIIIIIIIlIl) {
        if (llllllllllllllllIIIIllIIIIIIIlIl) {
            this.dataWatcher.updateObject(16, 1);
        }
        else {
            this.dataWatcher.updateObject(16, 0);
        }
    }
    
    public EntityPig(final World llllllllllllllllIIIIllIIIlIIlIII) {
        super(llllllllllllllllIIIIllIIIlIIlIII);
        this.setSize(0.9f, 0.9f);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25));
        final EntityAITasks tasks = this.tasks;
        final int llllllllllllllllIIIlIllIIlIllllI = 2;
        final EntityAIControlledByPlayer entityAIControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3f);
        this.aiControlledByPlayer = entityAIControlledByPlayer;
        tasks.addTask(llllllllllllllllIIIlIllIIlIllllI, entityAIControlledByPlayer);
        this.tasks.addTask(3, new EntityAIMate(this, 1.0));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2, Items.carrot_on_a_stick, false));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2, Items.carrot, false));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllllIIIIllIIIIIllIIl, final int llllllllllllllllIIIIllIIIIIllIII) {
        for (int llllllllllllllllIIIIllIIIIIlIlll = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + llllllllllllllllIIIIllIIIIIllIII), llllllllllllllllIIIIllIIIIIlIlIl = 0; llllllllllllllllIIIIllIIIIIlIlIl < llllllllllllllllIIIIllIIIIIlIlll; ++llllllllllllllllIIIIllIIIIIlIlIl) {
            if (this.isBurning()) {
                this.dropItem(Items.cooked_porkchop, 1);
            }
            else {
                this.dropItem(Items.porkchop, 1);
            }
        }
        if (this.getSaddled()) {
            this.dropItem(Items.saddle, 1);
        }
    }
    
    public boolean getSaddled() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    @Override
    public boolean interact(final EntityPlayer llllllllllllllllIIIIllIIIIlIIlII) {
        if (super.interact(llllllllllllllllIIIIllIIIIlIIlII)) {
            return true;
        }
        if (this.getSaddled() && !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == llllllllllllllllIIIIllIIIIlIIlII)) {
            llllllllllllllllIIIIllIIIIlIIlII.mountEntity(this);
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00001647";
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIIIllIIIIllIIlI) {
        super.readEntityFromNBT(llllllllllllllllIIIIllIIIIllIIlI);
        this.setSaddled(llllllllllllllllIIIIllIIIIllIIlI.getBoolean("Saddle"));
    }
    
    @Override
    protected void func_180429_a(final BlockPos llllllllllllllllIIIIllIIIIlIlIlI, final Block llllllllllllllllIIIIllIIIIlIlIIl) {
        this.playSound("mob.pig.step", 0.15f, 1.0f);
    }
}
