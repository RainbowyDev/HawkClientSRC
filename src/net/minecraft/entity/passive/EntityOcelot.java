package net.minecraft.entity.passive;

import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import com.google.common.base.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;

public class EntityOcelot extends EntityTameable
{
    private /* synthetic */ EntityAITempt aiTempt;
    private /* synthetic */ EntityAIAvoidEntity field_175545_bm;
    
    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.rand.nextInt(3) != 0;
    }
    
    public void setTameSkin(final int llllllllllllllIIlIIIIIllIlIllIIl) {
        this.dataWatcher.updateObject(18, (byte)llllllllllllllIIlIIIIIllIlIllIIl);
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack llllllllllllllIIlIIIIIllIllIllII) {
        return llllllllllllllIIlIIIIIllIllIllII != null && llllllllllllllIIlIIIIIllIllIllII.getItem() == Items.fish;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896);
    }
    
    @Override
    protected String getLivingSound() {
        return this.isTamed() ? (this.isInLove() ? "mob.cat.purr" : ((this.rand.nextInt(4) == 0) ? "mob.cat.purreow" : "mob.cat.meow")) : "";
    }
    
    @Override
    public boolean handleLavaMovement() {
        if (this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox())) {
            final BlockPos llllllllllllllIIlIIIIIllIlIlIIIl = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
            if (llllllllllllllIIlIIIIIllIlIlIIIl.getY() < 63) {
                return false;
            }
            final Block llllllllllllllIIlIIIIIllIlIlIIII = this.worldObj.getBlockState(llllllllllllllIIlIIIIIllIlIlIIIl.offsetDown()).getBlock();
            if (llllllllllllllIIlIIIIIllIlIlIIII == Blocks.grass || llllllllllllllIIlIIIIIllIlIlIIII.getMaterial() == Material.leaves) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void setTamed(final boolean llllllllllllllIIlIIIIIllIlIIIlII) {
        super.setTamed(llllllllllllllIIlIIIIIllIlIIIlII);
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance llllllllllllllIIlIIIIIllIIllIlIl, IEntityLivingData llllllllllllllIIlIIIIIllIIllIlII) {
        llllllllllllllIIlIIIIIllIIllIlII = (String)super.func_180482_a(llllllllllllllIIlIIIIIllIIllIlIl, (IEntityLivingData)llllllllllllllIIlIIIIIllIIllIlII);
        if (this.worldObj.rand.nextInt(7) == 0) {
            for (int llllllllllllllIIlIIIIIllIIlllIII = 0; llllllllllllllIIlIIIIIllIIlllIII < 2; ++llllllllllllllIIlIIIIIllIIlllIII) {
                final EntityOcelot llllllllllllllIIlIIIIIllIIllIlll = new EntityOcelot(this.worldObj);
                llllllllllllllIIlIIIIIllIIllIlll.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                llllllllllllllIIlIIIIIllIIllIlll.setGrowingAge(-24000);
                this.worldObj.spawnEntityInWorld(llllllllllllllIIlIIIIIllIIllIlll);
            }
        }
        return (IEntityLivingData)llllllllllllllIIlIIIIIllIIllIlII;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlIIIIIlllIlIIIII) {
        super.writeEntityToNBT(llllllllllllllIIlIIIIIlllIlIIIII);
        llllllllllllllIIlIIIIIlllIlIIIII.setInteger("CatType", this.getTameSkin());
    }
    
    @Override
    public void fall(final float llllllllllllllIIlIIIIIlllIlIIlIl, final float llllllllllllllIIlIIIIIlllIlIIlII) {
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlIIIIIlllIIllIlI) {
        super.readEntityFromNBT(llllllllllllllIIlIIIIIlllIIllIlI);
        this.setTameSkin(llllllllllllllIIlIIIIIlllIIllIlI.getInteger("CatType"));
    }
    
    public EntityOcelot func_180493_b(final EntityAgeable llllllllllllllIIlIIIIIllIlllIIlI) {
        final EntityOcelot llllllllllllllIIlIIIIIllIlllIIIl = new EntityOcelot(this.worldObj);
        if (this.isTamed()) {
            llllllllllllllIIlIIIIIllIlllIIIl.func_152115_b(this.func_152113_b());
            llllllllllllllIIlIIIIIllIlllIIIl.setTamed(true);
            llllllllllllllIIlIIIIIllIlllIIIl.setTameSkin(this.getTameSkin());
        }
        return llllllllllllllIIlIIIIIllIlllIIIl;
    }
    
    @Override
    public boolean interact(final EntityPlayer llllllllllllllIIlIIIIIllIllllIlI) {
        final ItemStack llllllllllllllIIlIIIIIllIllllIIl = llllllllllllllIIlIIIIIllIllllIlI.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (this.func_152114_e(llllllllllllllIIlIIIIIllIllllIlI) && !this.worldObj.isRemote && !this.isBreedingItem(llllllllllllllIIlIIIIIllIllllIIl)) {
                this.aiSit.setSitting(!this.isSitting());
            }
        }
        else if (this.aiTempt.isRunning() && llllllllllllllIIlIIIIIllIllllIIl != null && llllllllllllllIIlIIIIIllIllllIIl.getItem() == Items.fish && llllllllllllllIIlIIIIIllIllllIlI.getDistanceSqToEntity(this) < 9.0) {
            if (!llllllllllllllIIlIIIIIllIllllIlI.capabilities.isCreativeMode) {
                final ItemStack itemStack = llllllllllllllIIlIIIIIllIllllIIl;
                --itemStack.stackSize;
            }
            if (llllllllllllllIIlIIIIIllIllllIIl.stackSize <= 0) {
                llllllllllllllIIlIIIIIllIllllIlI.inventory.setInventorySlotContents(llllllllllllllIIlIIIIIllIllllIlI.inventory.currentItem, null);
            }
            if (!this.worldObj.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setTameSkin(1 + this.worldObj.rand.nextInt(3));
                    this.func_152115_b(llllllllllllllIIlIIIIIllIllllIlI.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.aiSit.setSitting(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
                else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.interact(llllllllllllllIIlIIIIIllIllllIlI);
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }
    
    @Override
    protected void func_175544_ck() {
        if (this.field_175545_bm == null) {
            this.field_175545_bm = new EntityAIAvoidEntity(this, (Predicate)new Predicate() {
                static {
                    __OBFID = "CL_00002243";
                }
                
                public boolean apply(final Object llllllllllllllIIlllIlIlllIIllllI) {
                    return this.func_179874_a((Entity)llllllllllllllIIlllIlIlllIIllllI);
                }
                
                public boolean func_179874_a(final Entity llllllllllllllIIlllIlIlllIlIIIll) {
                    return llllllllllllllIIlllIlIlllIlIIIll instanceof EntityPlayer;
                }
            }, 16.0f, 0.8, 1.33);
        }
        this.tasks.removeTask(this.field_175545_bm);
        if (!this.isTamed()) {
            this.tasks.addTask(4, this.field_175545_bm);
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, 0);
    }
    
    public void updateAITasks() {
        if (this.getMoveHelper().isUpdating()) {
            final double llllllllllllllIIlIIIIIlllIlIllll = this.getMoveHelper().getSpeed();
            if (llllllllllllllIIlIIIIIlllIlIllll == 0.6) {
                this.setSneaking(true);
                this.setSprinting(false);
            }
            else if (llllllllllllllIIlIIIIIlllIlIllll == 1.33) {
                this.setSneaking(false);
                this.setSprinting(true);
            }
            else {
                this.setSneaking(false);
                this.setSprinting(false);
            }
        }
        else {
            this.setSneaking(false);
            this.setSprinting(false);
        }
    }
    
    @Override
    protected boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal llllllllllllllIIlIIIIIllIllIIIll) {
        if (llllllllllllllIIlIIIIIllIllIIIll == this) {
            return false;
        }
        if (!this.isTamed()) {
            return false;
        }
        if (!(llllllllllllllIIlIIIIIllIllIIIll instanceof EntityOcelot)) {
            return false;
        }
        final EntityOcelot llllllllllllllIIlIIIIIllIllIIlIl = (EntityOcelot)llllllllllllllIIlIIIIIllIllIIIll;
        return llllllllllllllIIlIIIIIllIllIIlIl.isTamed() && (this.isInLove() && llllllllllllllIIlIIIIIllIllIIlIl.isInLove());
    }
    
    public int getTameSkin() {
        return this.dataWatcher.getWatchableObjectByte(18);
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.cat.hitt";
    }
    
    @Override
    protected Item getDropItem() {
        return Items.leather;
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable llllllllllllllIIlIIIIIllIIlIllII) {
        return this.func_180493_b(llllllllllllllIIlIIIIIllIIlIllII);
    }
    
    static {
        __OBFID = "CL_00001646";
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllIIlIIIIIlllIIIIIII, final int llllllllllllllIIlIIIIIllIlllllll) {
    }
    
    public EntityOcelot(final World llllllllllllllIIlIIIIIlllIlllIII) {
        super(llllllllllllllIIlIIIIIlllIlllIII);
        this.setSize(0.6f, 0.7f);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        final EntityAITasks tasks = this.tasks;
        final int llllllllllllllllIIIlIllIIlIllllI = 3;
        final EntityAITempt entityAITempt = new EntityAITempt(this, 0.6, Items.fish, true);
        this.aiTempt = entityAITempt;
        tasks.addTask(llllllllllllllllIIIlIllIIlIllllI, entityAITempt);
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0, 10.0f, 5.0f));
        this.tasks.addTask(6, new EntityAIOcelotSit(this, 0.8));
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3f));
        this.tasks.addTask(8, new EntityAIOcelotAttack(this));
        this.tasks.addTask(9, new EntityAIMate(this, 0.8));
        this.tasks.addTask(10, new EntityAIWander(this, 0.8));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0f));
        this.targetTasks.addTask(1, new EntityAITargetNonTamed(this, EntityChicken.class, false, null));
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllllIIlIIIIIlllIIIllIl) {
        return llllllllllllllIIlIIIIIlllIIIllIl.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.getCustomNameTag() : (this.isTamed() ? StatCollector.translateToLocal("entity.Cat.name") : super.getName());
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.cat.hitt";
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIIlIIIIIlllIIIIllI, final float llllllllllllllIIlIIIIIlllIIIIIlI) {
        if (this.func_180431_b(llllllllllllllIIlIIIIIlllIIIIllI)) {
            return false;
        }
        this.aiSit.setSitting(false);
        return super.attackEntityFrom(llllllllllllllIIlIIIIIlllIIIIllI, llllllllllllllIIlIIIIIlllIIIIIlI);
    }
}
