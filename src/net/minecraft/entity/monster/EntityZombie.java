package net.minecraft.entity.monster;

import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.command.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.potion.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.ai.*;
import net.minecraft.item.*;

public class EntityZombie extends EntityMob
{
    private final /* synthetic */ EntityAIBreakDoor field_146075_bs;
    private /* synthetic */ boolean field_146076_bu;
    private /* synthetic */ float field_146073_bw;
    private /* synthetic */ float field_146074_bv;
    protected static final /* synthetic */ IAttribute field_110186_bp;
    private /* synthetic */ int conversionTime;
    private static final /* synthetic */ UUID babySpeedBoostUUID;
    private static final /* synthetic */ AttributeModifier babySpeedBoostModifier;
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlllllIlllllIllIII) {
        super.writeEntityToNBT(llllllllllllllIlllllIlllllIllIII);
        if (this.isChild()) {
            llllllllllllllIlllllIlllllIllIII.setBoolean("IsBaby", true);
        }
        if (this.isVillager()) {
            llllllllllllllIlllllIlllllIllIII.setBoolean("IsVillager", true);
        }
        llllllllllllllIlllllIlllllIllIII.setInteger("ConversionTime", this.isConverting() ? this.conversionTime : -1);
        llllllllllllllIlllllIlllllIllIII.setBoolean("CanBreakDoors", this.func_146072_bX());
    }
    
    @Override
    public void onUpdate() {
        if (!this.worldObj.isRemote && this.isConverting()) {
            final int llllllllllllllIllllllIIIIIIlIIII = this.getConversionTimeBoost();
            this.conversionTime -= llllllllllllllIllllllIIIIIIlIIII;
            if (this.conversionTime <= 0) {
                this.convertToVillager();
            }
        }
        super.onUpdate();
    }
    
    @Override
    protected final void setSize(final float llllllllllllllIlllllIlllIIlllllI, final float llllllllllllllIlllllIlllIlIIIIIl) {
        final boolean llllllllllllllIlllllIlllIlIIIIII = this.field_146074_bv > 0.0f && this.field_146073_bw > 0.0f;
        this.field_146074_bv = llllllllllllllIlllllIlllIIlllllI;
        this.field_146073_bw = llllllllllllllIlllllIlllIlIIIIIl;
        if (!llllllllllllllIlllllIlllIlIIIIII) {
            this.func_146069_a(1.0f);
        }
    }
    
    @Override
    protected boolean canDespawn() {
        return !this.isConverting();
    }
    
    @Override
    public double getYOffset() {
        return super.getYOffset() - 0.5;
    }
    
    @Override
    public void handleHealthUpdate(final byte llllllllllllllIlllllIlllIlllIIIl) {
        if (llllllllllllllIlllllIlllIlllIIIl == 16) {
            if (!this.isSlient()) {
                this.worldObj.playSound(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "mob.zombie.remedy", 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        else {
            super.handleHealthUpdate(llllllllllllllIlllllIlllIlllIIIl);
        }
    }
    
    public void func_146070_a(final boolean llllllllllllllIllllllIIIIllIIlII) {
        if (this.field_146076_bu != llllllllllllllIllllllIIIIllIIlII) {
            this.field_146076_bu = llllllllllllllIllllllIIIIllIIlII;
            if (llllllllllllllIllllllIIIIllIIlII) {
                this.tasks.addTask(1, this.field_146075_bs);
            }
            else {
                this.tasks.removeTask(this.field_146075_bs);
            }
        }
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer llllllllllllllIllllllIIIIlIllIll) {
        if (this.isChild()) {
            this.experienceValue *= (int)2.5f;
        }
        return super.getExperiencePoints(llllllllllllllIllllllIIIIlIllIll);
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance llllllllllllllIlllllIllllllIIllI) {
        super.func_180481_a(llllllllllllllIlllllIllllllIIllI);
        if (this.rand.nextFloat() < ((this.worldObj.getDifficulty() == EnumDifficulty.HARD) ? 0.05f : 0.01f)) {
            final int llllllllllllllIlllllIllllllIlIlI = this.rand.nextInt(3);
            if (llllllllllllllIlllllIllllllIlIlI == 0) {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
            }
            else {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_shovel));
            }
        }
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllllIllllllIIIIIIIIlII) {
        final boolean llllllllllllllIllllllIIIIIIIIlll = super.attackEntityAsMob(llllllllllllllIllllllIIIIIIIIlII);
        if (llllllllllllllIllllllIIIIIIIIlll) {
            final int llllllllllllllIllllllIIIIIIIIllI = this.worldObj.getDifficulty().getDifficultyId();
            if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < llllllllllllllIllllllIIIIIIIIllI * 0.3f) {
                llllllllllllllIllllllIIIIIIIIlII.setFire(2 * llllllllllllllIllllllIIIIIIIIllI);
            }
        }
        return llllllllllllllIllllllIIIIIIIIlll;
    }
    
    @Override
    protected boolean func_175448_a(final ItemStack llllllllllllllIlllllIllllIIlllll) {
        return (llllllllllllllIlllllIllllIIlllll.getItem() != Items.egg || !this.isChild() || !this.isRiding()) && super.func_175448_a(llllllllllllllIlllllIllllIIlllll);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
        this.getAttributeMap().registerAttribute(EntityZombie.field_110186_bp).setBaseValue(this.rand.nextDouble() * 0.10000000149011612);
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    @Override
    public void onKillEntity(final EntityLivingBase llllllllllllllIlllllIllllIlllllI) {
        super.onKillEntity(llllllllllllllIlllllIllllIlllllI);
        if ((this.worldObj.getDifficulty() == EnumDifficulty.NORMAL || this.worldObj.getDifficulty() == EnumDifficulty.HARD) && llllllllllllllIlllllIllllIlllllI instanceof EntityVillager) {
            if (this.worldObj.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean()) {
                return;
            }
            final EntityZombie llllllllllllllIlllllIllllIllllII = new EntityZombie(this.worldObj);
            llllllllllllllIlllllIllllIllllII.copyLocationAndAnglesFrom(llllllllllllllIlllllIllllIlllllI);
            this.worldObj.removeEntity(llllllllllllllIlllllIllllIlllllI);
            llllllllllllllIlllllIllllIllllII.func_180482_a(this.worldObj.getDifficultyForLocation(new BlockPos(llllllllllllllIlllllIllllIllllII)), null);
            llllllllllllllIlllllIllllIllllII.setVillager(true);
            if (llllllllllllllIlllllIllllIlllllI.isChild()) {
                llllllllllllllIlllllIllllIllllII.setChild(true);
            }
            this.worldObj.spawnEntityInWorld(llllllllllllllIlllllIllllIllllII);
            this.worldObj.playAuxSFXAtEntity(null, 1016, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
        }
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.zombie.say";
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance llllllllllllllIlllllIllllIIIlIlI, final IEntityLivingData llllllllllllllIlllllIllllIIIlIIl) {
        Object llllllllllllllIlllllIllllIIlIIll = super.func_180482_a(llllllllllllllIlllllIllllIIIlIlI, llllllllllllllIlllllIllllIIIlIIl);
        final float llllllllllllllIlllllIllllIIlIIlI = llllllllllllllIlllllIllllIIIlIlI.func_180170_c();
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55f * llllllllllllllIlllllIllllIIlIIlI);
        if (llllllllllllllIlllllIllllIIlIIll == null) {
            llllllllllllllIlllllIllllIIlIIll = new GroupData(this.worldObj.rand.nextFloat() < 0.05f, this.worldObj.rand.nextFloat() < 0.05f, null);
        }
        if (llllllllllllllIlllllIllllIIlIIll instanceof GroupData) {
            final GroupData llllllllllllllIlllllIllllIIlIIIl = (GroupData)llllllllllllllIlllllIllllIIlIIll;
            if (llllllllllllllIlllllIllllIIlIIIl.field_142046_b) {
                this.setVillager(true);
            }
            if (llllllllllllllIlllllIllllIIlIIIl.field_142048_a) {
                this.setChild(true);
                if (this.worldObj.rand.nextFloat() < 0.05) {
                    final List llllllllllllllIlllllIllllIIlIIII = this.worldObj.func_175647_a(EntityChicken.class, this.getEntityBoundingBox().expand(5.0, 3.0, 5.0), IEntitySelector.field_152785_b);
                    if (!llllllllllllllIlllllIllllIIlIIII.isEmpty()) {
                        final EntityChicken llllllllllllllIlllllIllllIIIllll = llllllllllllllIlllllIllllIIlIIII.get(0);
                        llllllllllllllIlllllIllllIIIllll.func_152117_i(true);
                        this.mountEntity(llllllllllllllIlllllIllllIIIllll);
                    }
                }
                else if (this.worldObj.rand.nextFloat() < 0.05) {
                    final EntityChicken llllllllllllllIlllllIllllIIIlllI = new EntityChicken(this.worldObj);
                    llllllllllllllIlllllIllllIIIlllI.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    llllllllllllllIlllllIllllIIIlllI.func_180482_a(llllllllllllllIlllllIllllIIIlIlI, null);
                    llllllllllllllIlllllIllllIIIlllI.func_152117_i(true);
                    this.worldObj.spawnEntityInWorld(llllllllllllllIlllllIllllIIIlllI);
                    this.mountEntity(llllllllllllllIlllllIllllIIIlllI);
                }
            }
        }
        this.func_146070_a(this.rand.nextFloat() < llllllllllllllIlllllIllllIIlIIlI * 0.1f);
        this.func_180481_a(llllllllllllllIlllllIllllIIIlIlI);
        this.func_180483_b(llllllllllllllIlllllIllllIIIlIlI);
        if (this.getEquipmentInSlot(4) == null) {
            final Calendar llllllllllllllIlllllIllllIIIllIl = this.worldObj.getCurrentDate();
            if (llllllllllllllIlllllIllllIIIllIl.get(2) + 1 == 10 && llllllllllllllIlllllIllllIIIllIl.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
                this.setCurrentItemOrArmor(4, new ItemStack((this.rand.nextFloat() < 0.1f) ? Blocks.lit_pumpkin : Blocks.pumpkin));
                this.equipmentDropChances[4] = 0.0f;
            }
        }
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806, 0));
        final double llllllllllllllIlllllIllllIIIllII = this.rand.nextDouble() * 1.5 * llllllllllllllIlllllIllllIIlIIlI;
        if (llllllllllllllIlllllIllllIIIllII > 1.0) {
            this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random zombie-spawn bonus", llllllllllllllIlllllIllllIIIllII, 2));
        }
        if (this.rand.nextFloat() < llllllllllllllIlllllIllllIIlIIlI * 0.05f) {
            this.getEntityAttribute(EntityZombie.field_110186_bp).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25 + 0.5, 0));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0 + 1.0, 2));
            this.func_146070_a(true);
        }
        return (IEntityLivingData)llllllllllllllIlllllIllllIIlIIll;
    }
    
    @Override
    public int getTotalArmorValue() {
        int llllllllllllllIllllllIIIIllIllIl = super.getTotalArmorValue() + 2;
        if (llllllllllllllIllllllIIIIllIllIl > 20) {
            llllllllllllllIllllllIIIIllIllIl = 20;
        }
        return llllllllllllllIllllllIIIIllIllIl;
    }
    
    protected void startConversion(final int llllllllllllllIlllllIlllIlllIlIl) {
        this.conversionTime = llllllllllllllIlllllIlllIlllIlIl;
        this.getDataWatcher().updateObject(14, 1);
        this.removePotionEffect(Potion.weakness.id);
        this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, llllllllllllllIlllllIlllIlllIlIl, Math.min(this.worldObj.getDifficulty().getDifficultyId() - 1, 0)));
        this.worldObj.setEntityState(this, (byte)16);
    }
    
    public void setChild(final boolean llllllllllllllIllllllIIIIlIlIIIl) {
        this.getDataWatcher().updateObject(12, (byte)(byte)(llllllllllllllIllllllIIIIlIlIIIl ? 1 : 0));
        if (this.worldObj != null && !this.worldObj.isRemote) {
            final IAttributeInstance llllllllllllllIllllllIIIIlIlIIll = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            llllllllllllllIllllllIIIIlIlIIll.removeModifier(EntityZombie.babySpeedBoostModifier);
            if (llllllllllllllIllllllIIIIlIlIIIl) {
                llllllllllllllIllllllIIIIlIlIIll.applyModifier(EntityZombie.babySpeedBoostModifier);
            }
        }
        this.func_146071_k(llllllllllllllIllllllIIIIlIlIIIl);
    }
    
    protected void func_175456_n() {
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0, true));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityIronGolem.class, 1.0, true));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] { EntityPigZombie.class }));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }
    
    static {
        __OBFID = "CL_00001702";
        field_110186_bp = new RangedAttribute(null, "zombie.spawnReinforcements", 0.0, 0.0, 1.0).setDescription("Spawn Reinforcements Chance");
        babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
        babySpeedBoostModifier = new AttributeModifier(EntityZombie.babySpeedBoostUUID, "Baby speed boost", 0.5, 1);
    }
    
    protected void convertToVillager() {
        final EntityVillager llllllllllllllIlllllIlllIllIIlIl = new EntityVillager(this.worldObj);
        llllllllllllllIlllllIlllIllIIlIl.copyLocationAndAnglesFrom(this);
        llllllllllllllIlllllIlllIllIIlIl.func_180482_a(this.worldObj.getDifficultyForLocation(new BlockPos(llllllllllllllIlllllIlllIllIIlIl)), null);
        llllllllllllllIlllllIlllIllIIlIl.setLookingForHome();
        if (this.isChild()) {
            llllllllllllllIlllllIlllIllIIlIl.setGrowingAge(-24000);
        }
        this.worldObj.removeEntity(this);
        this.worldObj.spawnEntityInWorld(llllllllllllllIlllllIlllIllIIlIl);
        llllllllllllllIlllllIlllIllIIlIl.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
        this.worldObj.playAuxSFXAtEntity(null, 1017, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
    }
    
    @Override
    protected void func_180429_a(final BlockPos llllllllllllllIlllllIlllllllllII, final Block llllllllllllllIlllllIllllllllIll) {
        this.playSound("mob.zombie.step", 0.15f, 1.0f);
    }
    
    public boolean func_146072_bX() {
        return this.field_146076_bu;
    }
    
    @Override
    protected void addRandomArmor() {
        switch (this.rand.nextInt(3)) {
            case 0: {
                this.dropItem(Items.iron_ingot, 1);
                break;
            }
            case 1: {
                this.dropItem(Items.carrot, 1);
                break;
            }
            case 2: {
                this.dropItem(Items.potato, 1);
                break;
            }
        }
    }
    
    @Override
    public boolean isChild() {
        return this.getDataWatcher().getWatchableObjectByte(12) == 1;
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.zombie.death";
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlllllIlllllIIlIll) {
        super.readEntityFromNBT(llllllllllllllIlllllIlllllIIlIll);
        if (llllllllllllllIlllllIlllllIIlIll.getBoolean("IsBaby")) {
            this.setChild(true);
        }
        if (llllllllllllllIlllllIlllllIIlIll.getBoolean("IsVillager")) {
            this.setVillager(true);
        }
        if (llllllllllllllIlllllIlllllIIlIll.hasKey("ConversionTime", 99) && llllllllllllllIlllllIlllllIIlIll.getInteger("ConversionTime") > -1) {
            this.startConversion(llllllllllllllIlllllIlllllIIlIll.getInteger("ConversionTime"));
        }
        this.func_146070_a(llllllllllllllIlllllIlllllIIlIll.getBoolean("CanBreakDoors"));
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllIlllllIlllIIlIllIl) {
        super.onDeath(llllllllllllllIlllllIlllIIlIllIl);
        if (llllllllllllllIlllllIlllIIlIllIl.getEntity() instanceof EntityCreeper && !(this instanceof EntityPigZombie) && ((EntityCreeper)llllllllllllllIlllllIlllIIlIllIl.getEntity()).getPowered() && ((EntityCreeper)llllllllllllllIlllllIlllIIlIllIl.getEntity()).isAIEnabled()) {
            ((EntityCreeper)llllllllllllllIlllllIlllIIlIllIl.getEntity()).func_175493_co();
            this.entityDropItem(new ItemStack(Items.skull, 1, 2), 0.0f);
        }
    }
    
    protected int getConversionTimeBoost() {
        int llllllllllllllIlllllIlllIlIllIlI = 1;
        if (this.rand.nextFloat() < 0.01f) {
            for (int llllllllllllllIlllllIlllIlIllIIl = 0, llllllllllllllIlllllIlllIlIllIII = (int)this.posX - 4; llllllllllllllIlllllIlllIlIllIII < (int)this.posX + 4 && llllllllllllllIlllllIlllIlIllIIl < 14; ++llllllllllllllIlllllIlllIlIllIII) {
                for (int llllllllllllllIlllllIlllIlIlIlll = (int)this.posY - 4; llllllllllllllIlllllIlllIlIlIlll < (int)this.posY + 4 && llllllllllllllIlllllIlllIlIllIIl < 14; ++llllllllllllllIlllllIlllIlIlIlll) {
                    for (int llllllllllllllIlllllIlllIlIlIllI = (int)this.posZ - 4; llllllllllllllIlllllIlllIlIlIllI < (int)this.posZ + 4 && llllllllllllllIlllllIlllIlIllIIl < 14; ++llllllllllllllIlllllIlllIlIlIllI) {
                        final Block llllllllllllllIlllllIlllIlIlIlIl = this.worldObj.getBlockState(new BlockPos(llllllllllllllIlllllIlllIlIllIII, llllllllllllllIlllllIlllIlIlIlll, llllllllllllllIlllllIlllIlIlIllI)).getBlock();
                        if (llllllllllllllIlllllIlllIlIlIlIl == Blocks.iron_bars || llllllllllllllIlllllIlllIlIlIlIl == Blocks.bed) {
                            if (this.rand.nextFloat() < 0.3f) {
                                ++llllllllllllllIlllllIlllIlIllIlI;
                            }
                            ++llllllllllllllIlllllIlllIlIllIIl;
                        }
                    }
                }
            }
        }
        return llllllllllllllIlllllIlllIlIllIlI;
    }
    
    public boolean isVillager() {
        return this.getDataWatcher().getWatchableObjectByte(13) == 1;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIllllllIIIIIIllllI, final float llllllllllllllIllllllIIIIIlIlIIl) {
        if (super.attackEntityFrom(llllllllllllllIllllllIIIIIIllllI, llllllllllllllIllllllIIIIIlIlIIl)) {
            EntityLivingBase llllllllllllllIllllllIIIIIlIlIII = this.getAttackTarget();
            if (llllllllllllllIllllllIIIIIlIlIII == null && llllllllllllllIllllllIIIIIIllllI.getEntity() instanceof EntityLivingBase) {
                llllllllllllllIllllllIIIIIlIlIII = (EntityLivingBase)llllllllllllllIllllllIIIIIIllllI.getEntity();
            }
            if (llllllllllllllIllllllIIIIIlIlIII != null && this.worldObj.getDifficulty() == EnumDifficulty.HARD && this.rand.nextFloat() < this.getEntityAttribute(EntityZombie.field_110186_bp).getAttributeValue()) {
                final int llllllllllllllIllllllIIIIIlIIlll = MathHelper.floor_double(this.posX);
                final int llllllllllllllIllllllIIIIIlIIllI = MathHelper.floor_double(this.posY);
                final int llllllllllllllIllllllIIIIIlIIlIl = MathHelper.floor_double(this.posZ);
                final EntityZombie llllllllllllllIllllllIIIIIlIIlII = new EntityZombie(this.worldObj);
                for (int llllllllllllllIllllllIIIIIlIIIll = 0; llllllllllllllIllllllIIIIIlIIIll < 50; ++llllllllllllllIllllllIIIIIlIIIll) {
                    final int llllllllllllllIllllllIIIIIlIIIlI = llllllllllllllIllllllIIIIIlIIlll + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
                    final int llllllllllllllIllllllIIIIIlIIIIl = llllllllllllllIllllllIIIIIlIIllI + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
                    final int llllllllllllllIllllllIIIIIlIIIII = llllllllllllllIllllllIIIIIlIIlIl + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
                    if (World.doesBlockHaveSolidTopSurface(this.worldObj, new BlockPos(llllllllllllllIllllllIIIIIlIIIlI, llllllllllllllIllllllIIIIIlIIIIl - 1, llllllllllllllIllllllIIIIIlIIIII)) && this.worldObj.getLightFromNeighbors(new BlockPos(llllllllllllllIllllllIIIIIlIIIlI, llllllllllllllIllllllIIIIIlIIIIl, llllllllllllllIllllllIIIIIlIIIII)) < 10) {
                        llllllllllllllIllllllIIIIIlIIlII.setPosition(llllllllllllllIllllllIIIIIlIIIlI, llllllllllllllIllllllIIIIIlIIIIl, llllllllllllllIllllllIIIIIlIIIII);
                        if (!this.worldObj.func_175636_b(llllllllllllllIllllllIIIIIlIIIlI, llllllllllllllIllllllIIIIIlIIIIl, llllllllllllllIllllllIIIIIlIIIII, 7.0) && this.worldObj.checkNoEntityCollision(llllllllllllllIllllllIIIIIlIIlII.getEntityBoundingBox(), llllllllllllllIllllllIIIIIlIIlII) && this.worldObj.getCollidingBoundingBoxes(llllllllllllllIllllllIIIIIlIIlII, llllllllllllllIllllllIIIIIlIIlII.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(llllllllllllllIllllllIIIIIlIIlII.getEntityBoundingBox())) {
                            this.worldObj.spawnEntityInWorld(llllllllllllllIllllllIIIIIlIIlII);
                            llllllllllllllIllllllIIIIIlIIlII.setAttackTarget(llllllllllllllIllllllIIIIIlIlIII);
                            llllllllllllllIllllllIIIIIlIIlII.func_180482_a(this.worldObj.getDifficultyForLocation(new BlockPos(llllllllllllllIllllllIIIIIlIIlII)), null);
                            this.getEntityAttribute(EntityZombie.field_110186_bp).applyModifier(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806, 0));
                            llllllllllllllIllllllIIIIIlIIlII.getEntityAttribute(EntityZombie.field_110186_bp).applyModifier(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806, 0));
                            break;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean isConverting() {
        return this.getDataWatcher().getWatchableObjectByte(14) == 1;
    }
    
    public EntityZombie(final World llllllllllllllIllllllIIIIllllIlI) {
        super(llllllllllllllIllllllIIIIllllIlI);
        this.field_146075_bs = new EntityAIBreakDoor(this);
        this.field_146076_bu = false;
        this.field_146074_bv = -1.0f;
        ((PathNavigateGround)this.getNavigator()).func_179688_b(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, false));
        this.tasks.addTask(2, this.field_175455_a);
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.func_175456_n();
        this.setSize(0.6f, 1.95f);
    }
    
    public void func_146071_k(final boolean llllllllllllllIlllllIlllIlIIlIlI) {
        this.func_146069_a(llllllllllllllIlllllIlllIlIIlIlI ? 0.5f : 1.0f);
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild()) {
            final float llllllllllllllIllllllIIIIlIIIIII = this.getBrightness(1.0f);
            final BlockPos llllllllllllllIllllllIIIIIllllll = new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ);
            if (llllllllllllllIllllllIIIIlIIIIII > 0.5f && this.rand.nextFloat() * 30.0f < (llllllllllllllIllllllIIIIlIIIIII - 0.4f) * 2.0f && this.worldObj.isAgainstSky(llllllllllllllIllllllIIIIIllllll)) {
                boolean llllllllllllllIllllllIIIIIlllllI = true;
                final ItemStack llllllllllllllIllllllIIIIIllllIl = this.getEquipmentInSlot(4);
                if (llllllllllllllIllllllIIIIIllllIl != null) {
                    if (llllllllllllllIllllllIIIIIllllIl.isItemStackDamageable()) {
                        llllllllllllllIllllllIIIIIllllIl.setItemDamage(llllllllllllllIllllllIIIIIllllIl.getItemDamage() + this.rand.nextInt(2));
                        if (llllllllllllllIllllllIIIIIllllIl.getItemDamage() >= llllllllllllllIllllllIIIIIllllIl.getMaxDamage()) {
                            this.renderBrokenItemStack(llllllllllllllIllllllIIIIIllllIl);
                            this.setCurrentItemOrArmor(4, null);
                        }
                    }
                    llllllllllllllIllllllIIIIIlllllI = false;
                }
                if (llllllllllllllIllllllIIIIIlllllI) {
                    this.setFire(8);
                }
            }
        }
        if (this.isRiding() && this.getAttackTarget() != null && this.ridingEntity instanceof EntityChicken) {
            ((EntityLiving)this.ridingEntity).getNavigator().setPath(this.getNavigator().getPath(), 1.5);
        }
        super.onLivingUpdate();
    }
    
    public void setVillager(final boolean llllllllllllllIllllllIIIIlIIIlll) {
        this.getDataWatcher().updateObject(13, (byte)(byte)(llllllllllllllIllllllIIIIlIIIlll ? 1 : 0));
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(12, 0);
        this.getDataWatcher().addObject(13, 0);
        this.getDataWatcher().addObject(14, 0);
    }
    
    protected final void func_146069_a(final float llllllllllllllIlllllIlllIIlllIII) {
        super.setSize(this.field_146074_bv * llllllllllllllIlllllIlllIIlllIII, this.field_146073_bw * llllllllllllllIlllllIlllIIlllIII);
    }
    
    public boolean interact(final EntityPlayer llllllllllllllIlllllIlllIlllllll) {
        final ItemStack llllllllllllllIlllllIlllIllllllI = llllllllllllllIlllllIlllIlllllll.getCurrentEquippedItem();
        if (llllllllllllllIlllllIlllIllllllI != null && llllllllllllllIlllllIlllIllllllI.getItem() == Items.golden_apple && llllllllllllllIlllllIlllIllllllI.getMetadata() == 0 && this.isVillager() && this.isPotionActive(Potion.weakness)) {
            if (!llllllllllllllIlllllIlllIlllllll.capabilities.isCreativeMode) {
                final ItemStack itemStack = llllllllllllllIlllllIlllIllllllI;
                --itemStack.stackSize;
            }
            if (llllllllllllllIlllllIlllIllllllI.stackSize <= 0) {
                llllllllllllllIlllllIlllIlllllll.inventory.setInventorySlotContents(llllllllllllllIlllllIlllIlllllll.inventory.currentItem, null);
            }
            if (!this.worldObj.isRemote) {
                this.startConversion(this.rand.nextInt(2401) + 3600);
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }
    
    @Override
    protected Item getDropItem() {
        return Items.rotten_flesh;
    }
    
    @Override
    public float getEyeHeight() {
        float llllllllllllllIlllllIllllIllIIIl = 1.74f;
        if (this.isChild()) {
            llllllllllllllIlllllIllllIllIIIl -= (float)0.81;
        }
        return llllllllllllllIlllllIllllIllIIIl;
    }
    
    class GroupData implements IEntityLivingData
    {
        public /* synthetic */ boolean field_142046_b;
        public /* synthetic */ boolean field_142048_a;
        
        private GroupData(final boolean lllllllllllllllIIIIllllIIIIlllII, final boolean lllllllllllllllIIIIllllIIIIllIll) {
            this.field_142048_a = false;
            this.field_142046_b = false;
            this.field_142048_a = lllllllllllllllIIIIllllIIIIlllII;
            this.field_142046_b = lllllllllllllllIIIIllllIIIIllIll;
        }
        
        static {
            __OBFID = "CL_00001704";
        }
        
        GroupData(final EntityZombie lllllllllllllllIIIIllllIIIIIllIl, final boolean lllllllllllllllIIIIllllIIIIIllII, final boolean lllllllllllllllIIIIllllIIIIlIIII, final Object lllllllllllllllIIIIllllIIIIIllll) {
            this(lllllllllllllllIIIIllllIIIIIllIl, lllllllllllllllIIIIllllIIIIIllII, lllllllllllllllIIIIllllIIIIlIIII);
        }
    }
}
