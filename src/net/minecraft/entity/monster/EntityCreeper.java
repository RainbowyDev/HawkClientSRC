package net.minecraft.entity.monster;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import com.google.common.base.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.effect.*;

public class EntityCreeper extends EntityMob
{
    private /* synthetic */ int fuseTime;
    private /* synthetic */ int explosionRadius;
    private /* synthetic */ int lastActiveTime;
    private /* synthetic */ int field_175494_bm;
    private /* synthetic */ int timeSinceIgnited;
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIlIlIlllIIIIIIlI) {
        super.writeEntityToNBT(llllllllllllllllIlIlIlllIIIIIIlI);
        if (this.dataWatcher.getWatchableObjectByte(17) == 1) {
            llllllllllllllllIlIlIlllIIIIIIlI.setBoolean("powered", true);
        }
        llllllllllllllllIlIlIlllIIIIIIlI.setShort("Fuse", (short)this.fuseTime);
        llllllllllllllllIlIlIlllIIIIIIlI.setByte("ExplosionRadius", (byte)this.explosionRadius);
        llllllllllllllllIlIlIlllIIIIIIlI.setBoolean("ignited", this.func_146078_ca());
    }
    
    private void func_146077_cc() {
        if (!this.worldObj.isRemote) {
            final boolean llllllllllllllllIlIlIllIlIllllII = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
            final float llllllllllllllllIlIlIllIlIlllIll = this.getPowered() ? 2.0f : 1.0f;
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius * llllllllllllllllIlIlIllIlIlllIll, llllllllllllllllIlIlIllIlIllllII);
            this.setDead();
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, -1);
        this.dataWatcher.addObject(17, 0);
        this.dataWatcher.addObject(18, 0);
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.creeper.death";
    }
    
    public EntityCreeper(final World llllllllllllllllIlIlIlllIIIlllII) {
        super(llllllllllllllllIlIlIlllIIIlllII);
        this.fuseTime = 30;
        this.explosionRadius = 3;
        this.field_175494_bm = 0;
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICreeperSwell(this));
        this.tasks.addTask(2, this.field_175455_a);
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, (Predicate)new Predicate() {
            public boolean func_179958_a(final Entity llllllllllllllIIIlIIIIIlIIIIIIll) {
                return llllllllllllllIIIlIIIIIlIIIIIIll instanceof EntityOcelot;
            }
            
            static {
                __OBFID = "CL_00002224";
            }
            
            public boolean apply(final Object llllllllllllllIIIlIIIIIIlllllllI) {
                return this.func_179958_a((Entity)llllllllllllllIIIlIIIIIIlllllllI);
            }
        }, 6.0f, 1.0, 1.2));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0, false));
        this.tasks.addTask(5, new EntityAIWander(this, 0.8));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }
    
    public boolean func_146078_ca() {
        return this.dataWatcher.getWatchableObjectByte(18) != 0;
    }
    
    @Override
    protected boolean interact(final EntityPlayer llllllllllllllllIlIlIllIllIIIlIl) {
        final ItemStack llllllllllllllllIlIlIllIllIIIlII = llllllllllllllllIlIlIllIllIIIlIl.inventory.getCurrentItem();
        if (llllllllllllllllIlIlIllIllIIIlII != null && llllllllllllllllIlIlIllIllIIIlII.getItem() == Items.flint_and_steel) {
            this.worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "fire.ignite", 1.0f, this.rand.nextFloat() * 0.4f + 0.8f);
            llllllllllllllllIlIlIllIllIIIlIl.swingItem();
            if (!this.worldObj.isRemote) {
                this.func_146079_cb();
                llllllllllllllllIlIlIllIllIIIlII.damageItem(1, llllllllllllllllIlIlIllIllIIIlIl);
                return true;
            }
        }
        return super.interact(llllllllllllllllIlIlIllIllIIIlIl);
    }
    
    public void func_146079_cb() {
        this.dataWatcher.updateObject(18, 1);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllllllIlIlIllIlllIIIll) {
        return true;
    }
    
    public float getCreeperFlashIntensity(final float llllllllllllllllIlIlIllIllIllIlI) {
        return (this.lastActiveTime + (this.timeSinceIgnited - this.lastActiveTime) * llllllllllllllllIlIlIllIllIllIlI) / (this.fuseTime - 2);
    }
    
    public void setCreeperState(final int llllllllllllllllIlIlIllIllIlIIII) {
        this.dataWatcher.updateObject(16, (byte)llllllllllllllllIlIlIllIllIlIIII);
    }
    
    @Override
    protected Item getDropItem() {
        return Items.gunpowder;
    }
    
    @Override
    public int getMaxFallHeight() {
        return (this.getAttackTarget() == null) ? 3 : (3 + (int)(this.getHealth() - 1.0f));
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllllIlIlIllIlllIlIII) {
        super.onDeath(llllllllllllllllIlIlIllIlllIlIII);
        if (llllllllllllllllIlIlIllIlllIlIII.getEntity() instanceof EntitySkeleton) {
            final int llllllllllllllllIlIlIllIlllIllII = Item.getIdFromItem(Items.record_13);
            final int llllllllllllllllIlIlIllIlllIlIll = Item.getIdFromItem(Items.record_wait);
            final int llllllllllllllllIlIlIllIlllIlIlI = llllllllllllllllIlIlIllIlllIllII + this.rand.nextInt(llllllllllllllllIlIlIllIlllIlIll - llllllllllllllllIlIlIllIlllIllII + 1);
            this.dropItem(Item.getItemById(llllllllllllllllIlIlIllIlllIlIlI), 1);
        }
        else if (llllllllllllllllIlIlIllIlllIlIII.getEntity() instanceof EntityCreeper && llllllllllllllllIlIlIllIlllIlIII.getEntity() != this && ((EntityCreeper)llllllllllllllllIlIlIllIlllIlIII.getEntity()).getPowered() && ((EntityCreeper)llllllllllllllllIlIlIllIlllIlIII.getEntity()).isAIEnabled()) {
            ((EntityCreeper)llllllllllllllllIlIlIllIlllIlIII.getEntity()).func_175493_co();
            this.entityDropItem(new ItemStack(Items.skull, 1, 4), 0.0f);
        }
    }
    
    public boolean isAIEnabled() {
        return this.field_175494_bm < 1 && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot");
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.creeper.say";
    }
    
    public void func_175493_co() {
        ++this.field_175494_bm;
    }
    
    @Override
    public void fall(final float llllllllllllllllIlIlIlllIIIIllII, final float llllllllllllllllIlIlIlllIIIIlIll) {
        super.fall(llllllllllllllllIlIlIlllIIIIllII, llllllllllllllllIlIlIlllIIIIlIll);
        this.timeSinceIgnited += (int)(llllllllllllllllIlIlIlllIIIIllII * 1.5f);
        if (this.timeSinceIgnited > this.fuseTime - 5) {
            this.timeSinceIgnited = this.fuseTime - 5;
        }
    }
    
    public int getCreeperState() {
        return this.dataWatcher.getWatchableObjectByte(16);
    }
    
    @Override
    public void onUpdate() {
        if (this.isEntityAlive()) {
            this.lastActiveTime = this.timeSinceIgnited;
            if (this.func_146078_ca()) {
                this.setCreeperState(1);
            }
            final int llllllllllllllllIlIlIllIlllllIII = this.getCreeperState();
            if (llllllllllllllllIlIlIllIlllllIII > 0 && this.timeSinceIgnited == 0) {
                this.playSound("creeper.primed", 1.0f, 0.5f);
            }
            this.timeSinceIgnited += llllllllllllllllIlIlIllIlllllIII;
            if (this.timeSinceIgnited < 0) {
                this.timeSinceIgnited = 0;
            }
            if (this.timeSinceIgnited >= this.fuseTime) {
                this.timeSinceIgnited = this.fuseTime;
                this.func_146077_cc();
            }
        }
        super.onUpdate();
    }
    
    public boolean getPowered() {
        return this.dataWatcher.getWatchableObjectByte(17) == 1;
    }
    
    @Override
    public void onStruckByLightning(final EntityLightningBolt llllllllllllllllIlIlIllIllIIllII) {
        super.onStruckByLightning(llllllllllllllllIlIlIllIllIIllII);
        this.dataWatcher.updateObject(17, 1);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIlIlIllIlllllllI) {
        super.readEntityFromNBT(llllllllllllllllIlIlIllIlllllllI);
        this.dataWatcher.updateObject(17, (byte)(byte)(llllllllllllllllIlIlIllIlllllllI.getBoolean("powered") ? 1 : 0));
        if (llllllllllllllllIlIlIllIlllllllI.hasKey("Fuse", 99)) {
            this.fuseTime = llllllllllllllllIlIlIllIlllllllI.getShort("Fuse");
        }
        if (llllllllllllllllIlIlIllIlllllllI.hasKey("ExplosionRadius", 99)) {
            this.explosionRadius = llllllllllllllllIlIlIllIlllllllI.getByte("ExplosionRadius");
        }
        if (llllllllllllllllIlIlIllIlllllllI.getBoolean("ignited")) {
            this.func_146079_cb();
        }
    }
    
    static {
        __OBFID = "CL_00001684";
    }
}
