package net.minecraft.entity.monster;

import java.util.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;

public class EntityPigZombie extends EntityZombie
{
    private static final /* synthetic */ UUID field_110189_bq;
    private /* synthetic */ UUID field_175459_bn;
    private /* synthetic */ int angerLevel;
    private static final /* synthetic */ AttributeModifier field_110190_br;
    private /* synthetic */ int randomSoundDelay;
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllllIlIIIlIllIllIIll, final int llllllllllllllllIlIIIlIllIlIlllI) {
        for (int llllllllllllllllIlIIIlIllIllIIIl = this.rand.nextInt(2 + llllllllllllllllIlIIIlIllIlIlllI), llllllllllllllllIlIIIlIllIllIIII = 0; llllllllllllllllIlIIIlIllIllIIII < llllllllllllllllIlIIIlIllIllIIIl; ++llllllllllllllllIlIIIlIllIllIIII) {
            this.dropItem(Items.rotten_flesh, 1);
        }
        for (int llllllllllllllllIlIIIlIllIllIIIl = this.rand.nextInt(2 + llllllllllllllllIlIIIlIllIlIlllI), llllllllllllllllIlIIIlIllIllIIII = 0; llllllllllllllllIlIIIlIllIllIIII < llllllllllllllllIlIIIlIllIllIIIl; ++llllllllllllllllIlIIIlIllIllIIII) {
            this.dropItem(Items.gold_nugget, 1);
        }
    }
    
    @Override
    protected void addRandomArmor() {
        this.dropItem(Items.gold_ingot, 1);
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.zombiepig.zpig";
    }
    
    static {
        __OBFID = "CL_00001693";
        field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
        field_110190_br = new AttributeModifier(EntityPigZombie.field_110189_bq, "Attacking speed boost", 0.05, 0).setSaved(false);
    }
    
    private void becomeAngryAt(final Entity llllllllllllllllIlIIIlIlllIIIlIl) {
        this.angerLevel = 400 + this.rand.nextInt(400);
        this.randomSoundDelay = this.rand.nextInt(40);
        if (llllllllllllllllIlIIIlIlllIIIlIl instanceof EntityLivingBase) {
            this.setRevengeTarget((EntityLivingBase)llllllllllllllllIlIIIlIlllIIIlIl);
        }
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIlIIIlIllllIIIll) {
        super.writeEntityToNBT(llllllllllllllllIlIIIlIllllIIIll);
        llllllllllllllllIlIIIlIllllIIIll.setShort("Anger", (short)this.angerLevel);
        if (this.field_175459_bn != null) {
            llllllllllllllllIlIIIlIllllIIIll.setString("HurtBy", this.field_175459_bn.toString());
        }
        else {
            llllllllllllllllIlIIIlIllllIIIll.setString("HurtBy", "");
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIlIIIlIlllIIllll, final float llllllllllllllllIlIIIlIlllIIlIlI) {
        if (this.func_180431_b(llllllllllllllllIlIIIlIlllIIllll)) {
            return false;
        }
        final Entity llllllllllllllllIlIIIlIlllIIllIl = llllllllllllllllIlIIIlIlllIIllll.getEntity();
        if (llllllllllllllllIlIIIlIlllIIllIl instanceof EntityPlayer) {
            this.becomeAngryAt(llllllllllllllllIlIIIlIlllIIllIl);
        }
        return super.attackEntityFrom(llllllllllllllllIlIIIlIlllIIllll, llllllllllllllllIlIIIlIlllIIlIlI);
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.zombiepig.zpigdeath";
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(EntityPigZombie.field_110186_bp).setBaseValue(0.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0);
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.zombiepig.zpighurt";
    }
    
    public EntityPigZombie(final World llllllllllllllllIlIIIllIIIIIIlll) {
        super(llllllllllllllllIlIIIllIIIIIIlll);
        this.isImmuneToFire = true;
    }
    
    @Override
    public boolean interact(final EntityPlayer llllllllllllllllIlIIIlIllIlIIllI) {
        return false;
    }
    
    @Override
    public void setRevengeTarget(final EntityLivingBase llllllllllllllllIlIIIllIIIIIIIIl) {
        super.setRevengeTarget(llllllllllllllllIlIIIllIIIIIIIIl);
        if (llllllllllllllllIlIIIllIIIIIIIIl != null) {
            this.field_175459_bn = llllllllllllllllIlIIIllIIIIIIIIl.getUniqueID();
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIlIIIlIlllIlIlll) {
        super.readEntityFromNBT(llllllllllllllllIlIIIlIlllIlIlll);
        this.angerLevel = llllllllllllllllIlIIIlIlllIlIlll.getShort("Anger");
        final String llllllllllllllllIlIIIlIlllIllIlI = llllllllllllllllIlIIIlIlllIlIlll.getString("HurtBy");
        if (llllllllllllllllIlIIIlIlllIllIlI.length() > 0) {
            this.field_175459_bn = UUID.fromString(llllllllllllllllIlIIIlIlllIllIlI);
            final EntityPlayer llllllllllllllllIlIIIlIlllIllIIl = this.worldObj.getPlayerEntityByUUID(this.field_175459_bn);
            this.setRevengeTarget(llllllllllllllllIlIIIlIlllIllIIl);
            if (llllllllllllllllIlIIIlIlllIllIIl != null) {
                this.attackingPlayer = llllllllllllllllIlIIIlIlllIllIIl;
                this.recentlyHit = this.getRevengeTimer();
            }
        }
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance llllllllllllllllIlIIIlIllIIlIlll) {
        this.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
    }
    
    @Override
    protected void updateAITasks() {
        final IAttributeInstance llllllllllllllllIlIIIlIlllllIIIl = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
        if (this.func_175457_ck()) {
            if (!this.isChild() && !llllllllllllllllIlIIIlIlllllIIIl.func_180374_a(EntityPigZombie.field_110190_br)) {
                llllllllllllllllIlIIIlIlllllIIIl.applyModifier(EntityPigZombie.field_110190_br);
            }
            --this.angerLevel;
        }
        else if (llllllllllllllllIlIIIlIlllllIIIl.func_180374_a(EntityPigZombie.field_110190_br)) {
            llllllllllllllllIlIIIlIlllllIIIl.removeModifier(EntityPigZombie.field_110190_br);
        }
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound("mob.zombiepig.zpigangry", this.getSoundVolume() * 2.0f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 1.8f);
        }
        if (this.angerLevel > 0 && this.field_175459_bn != null && this.getAITarget() == null) {
            final EntityPlayer llllllllllllllllIlIIIlIlllllIIII = this.worldObj.getPlayerEntityByUUID(this.field_175459_bn);
            this.setRevengeTarget(llllllllllllllllIlIIIlIlllllIIII);
            this.attackingPlayer = llllllllllllllllIlIIIlIlllllIIII;
            this.recentlyHit = this.getRevengeTimer();
        }
        super.updateAITasks();
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance llllllllllllllllIlIIIlIllIIIlllI, final IEntityLivingData llllllllllllllllIlIIIlIllIIIllIl) {
        super.func_180482_a(llllllllllllllllIlIIIlIllIIIlllI, llllllllllllllllIlIIIlIllIIIllIl);
        this.setVillager(false);
        return llllllllllllllllIlIIIlIllIIIllIl;
    }
    
    @Override
    protected void func_175456_n() {
        this.targetTasks.addTask(1, new AIHurtByAggressor());
        this.targetTasks.addTask(2, new AITargetAggressor());
    }
    
    @Override
    public boolean handleLavaMovement() {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox());
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
    }
    
    public boolean func_175457_ck() {
        return this.angerLevel > 0;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
    }
    
    class AITargetAggressor extends EntityAINearestAttackableTarget
    {
        @Override
        public boolean shouldExecute() {
            return ((EntityPigZombie)this.taskOwner).func_175457_ck() && super.shouldExecute();
        }
        
        public AITargetAggressor() {
            super(EntityPigZombie.this, EntityPlayer.class, true);
        }
        
        static {
            __OBFID = "CL_00002207";
        }
    }
    
    class AIHurtByAggressor extends EntityAIHurtByTarget
    {
        static {
            __OBFID = "CL_00002206";
        }
        
        public AIHurtByAggressor() {
            super(EntityPigZombie.this, true, new Class[0]);
        }
        
        @Override
        protected void func_179446_a(final EntityCreature llllllllllllllIlllIlllllIIIIIllI, final EntityLivingBase llllllllllllllIlllIlllllIIIIlIIl) {
            super.func_179446_a(llllllllllllllIlllIlllllIIIIIllI, llllllllllllllIlllIlllllIIIIlIIl);
            if (llllllllllllllIlllIlllllIIIIIllI instanceof EntityPigZombie) {
                ((EntityPigZombie)llllllllllllllIlllIlllllIIIIIllI).becomeAngryAt(llllllllllllllIlllIlllllIIIIlIIl);
            }
        }
    }
}
