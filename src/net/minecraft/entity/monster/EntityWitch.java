package net.minecraft.entity.monster;

import net.minecraft.entity.projectile.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;

public class EntityWitch extends EntityMob implements IRangedAttackMob
{
    private /* synthetic */ int witchAttackTimer;
    private static final /* synthetic */ Item[] witchDrops;
    private static final /* synthetic */ AttributeModifier field_110185_bq;
    private static final /* synthetic */ UUID field_110184_bp;
    
    @Override
    protected String getLivingSound() {
        return null;
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase lIlIlIIIIIllIlI, final float lIlIlIIIIIllIIl) {
        if (!this.getAggressive()) {
            final EntityPotion lIlIlIIIIIllIII = new EntityPotion(this.worldObj, this, 32732);
            final double lIlIlIIIIIlIlll = lIlIlIIIIIllIlI.posY + lIlIlIIIIIllIlI.getEyeHeight() - 1.100000023841858;
            final EntityPotion entityPotion = lIlIlIIIIIllIII;
            entityPotion.rotationPitch += 20.0f;
            final double lIlIlIIIIIlIllI = lIlIlIIIIIllIlI.posX + lIlIlIIIIIllIlI.motionX - this.posX;
            final double lIlIlIIIIIlIlIl = lIlIlIIIIIlIlll - this.posY;
            final double lIlIlIIIIIlIlII = lIlIlIIIIIllIlI.posZ + lIlIlIIIIIllIlI.motionZ - this.posZ;
            final float lIlIlIIIIIlIIll = MathHelper.sqrt_double(lIlIlIIIIIlIllI * lIlIlIIIIIlIllI + lIlIlIIIIIlIlII * lIlIlIIIIIlIlII);
            if (lIlIlIIIIIlIIll >= 8.0f && !lIlIlIIIIIllIlI.isPotionActive(Potion.moveSlowdown)) {
                lIlIlIIIIIllIII.setPotionDamage(32698);
            }
            else if (lIlIlIIIIIllIlI.getHealth() >= 8.0f && !lIlIlIIIIIllIlI.isPotionActive(Potion.poison)) {
                lIlIlIIIIIllIII.setPotionDamage(32660);
            }
            else if (lIlIlIIIIIlIIll <= 3.0f && !lIlIlIIIIIllIlI.isPotionActive(Potion.weakness) && this.rand.nextFloat() < 0.25f) {
                lIlIlIIIIIllIII.setPotionDamage(32696);
            }
            lIlIlIIIIIllIII.setThrowableHeading(lIlIlIIIIIlIllI, lIlIlIIIIIlIlIl + lIlIlIIIIIlIIll * 0.2f, lIlIlIIIIIlIlII, 0.75f, 8.0f);
            this.worldObj.spawnEntityInWorld(lIlIlIIIIIllIII);
        }
    }
    
    @Override
    protected String getDeathSound() {
        return null;
    }
    
    static {
        __OBFID = "CL_00001701";
        field_110184_bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
        field_110185_bq = new AttributeModifier(EntityWitch.field_110184_bp, "Drinking speed penalty", -0.25, 0).setSaved(false);
        witchDrops = new Item[] { Items.glowstone_dust, Items.sugar, Items.redstone, Items.spider_eye, Items.glass_bottle, Items.gunpowder, Items.stick, Items.stick };
    }
    
    @Override
    protected String getHurtSound() {
        return null;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
    }
    
    @Override
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
            if (this.getAggressive()) {
                if (this.witchAttackTimer-- <= 0) {
                    this.setAggressive(false);
                    final ItemStack lIlIlIIIlIlIllI = this.getHeldItem();
                    this.setCurrentItemOrArmor(0, null);
                    if (lIlIlIIIlIlIllI != null && lIlIlIIIlIlIllI.getItem() == Items.potionitem) {
                        final List lIlIlIIIlIlIlIl = Items.potionitem.getEffects(lIlIlIIIlIlIllI);
                        if (lIlIlIIIlIlIlIl != null) {
                            for (final PotionEffect lIlIlIIIlIlIIll : lIlIlIIIlIlIlIl) {
                                this.addPotionEffect(new PotionEffect(lIlIlIIIlIlIIll));
                            }
                        }
                    }
                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeModifier(EntityWitch.field_110185_bq);
                }
            }
            else {
                short lIlIlIIIlIlIIlI = -1;
                if (this.rand.nextFloat() < 0.15f && this.isInsideOfMaterial(Material.water) && !this.isPotionActive(Potion.waterBreathing)) {
                    lIlIlIIIlIlIIlI = 8237;
                }
                else if (this.rand.nextFloat() < 0.15f && this.isBurning() && !this.isPotionActive(Potion.fireResistance)) {
                    lIlIlIIIlIlIIlI = 16307;
                }
                else if (this.rand.nextFloat() < 0.05f && this.getHealth() < this.getMaxHealth()) {
                    lIlIlIIIlIlIIlI = 16341;
                }
                else if (this.rand.nextFloat() < 0.25f && this.getAttackTarget() != null && !this.isPotionActive(Potion.moveSpeed) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0) {
                    lIlIlIIIlIlIIlI = 16274;
                }
                else if (this.rand.nextFloat() < 0.25f && this.getAttackTarget() != null && !this.isPotionActive(Potion.moveSpeed) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0) {
                    lIlIlIIIlIlIIlI = 16274;
                }
                if (lIlIlIIIlIlIIlI > -1) {
                    this.setCurrentItemOrArmor(0, new ItemStack(Items.potionitem, 1, lIlIlIIIlIlIIlI));
                    this.witchAttackTimer = this.getHeldItem().getMaxItemUseDuration();
                    this.setAggressive(true);
                    final IAttributeInstance lIlIlIIIlIlIIIl = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    lIlIlIIIlIlIIIl.removeModifier(EntityWitch.field_110185_bq);
                    lIlIlIIIlIlIIIl.applyModifier(EntityWitch.field_110185_bq);
                }
            }
            if (this.rand.nextFloat() < 7.5E-4f) {
                this.worldObj.setEntityState(this, (byte)15);
            }
        }
        super.onLivingUpdate();
    }
    
    @Override
    protected float applyPotionDamageCalculations(final DamageSource lIlIlIIIIlllIll, float lIlIlIIIIlllIlI) {
        lIlIlIIIIlllIlI = super.applyPotionDamageCalculations(lIlIlIIIIlllIll, lIlIlIIIIlllIlI);
        if (lIlIlIIIIlllIll.getEntity() == this) {
            lIlIlIIIIlllIlI = 0.0f;
        }
        if (lIlIlIIIIlllIll.isMagicDamage()) {
            lIlIlIIIIlllIlI *= (float)0.15;
        }
        return lIlIlIIIIlllIlI;
    }
    
    @Override
    public void handleHealthUpdate(final byte lIlIlIIIlIIIlII) {
        if (lIlIlIIIlIIIlII == 15) {
            for (int lIlIlIIIlIIIllI = 0; lIlIlIIIlIIIllI < this.rand.nextInt(35) + 10; ++lIlIlIIIlIIIllI) {
                this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX + this.rand.nextGaussian() * 0.12999999523162842, this.getEntityBoundingBox().maxY + 0.5 + this.rand.nextGaussian() * 0.12999999523162842, this.posZ + this.rand.nextGaussian() * 0.12999999523162842, 0.0, 0.0, 0.0, new int[0]);
            }
        }
        else {
            super.handleHealthUpdate(lIlIlIIIlIIIlII);
        }
    }
    
    @Override
    public float getEyeHeight() {
        return 1.62f;
    }
    
    public void setAggressive(final boolean lIlIlIIIllIIlIl) {
        this.getDataWatcher().updateObject(21, (byte)(byte)(lIlIlIIIllIIlIl ? 1 : 0));
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(21, 0);
    }
    
    @Override
    protected void dropFewItems(final boolean lIlIlIIIIllIIIl, final int lIlIlIIIIlIlIIl) {
        for (int lIlIlIIIIlIllll = this.rand.nextInt(3) + 1, lIlIlIIIIlIlllI = 0; lIlIlIIIIlIlllI < lIlIlIIIIlIllll; ++lIlIlIIIIlIlllI) {
            int lIlIlIIIIlIllIl = this.rand.nextInt(3);
            final Item lIlIlIIIIlIllII = EntityWitch.witchDrops[this.rand.nextInt(EntityWitch.witchDrops.length)];
            if (lIlIlIIIIlIlIIl > 0) {
                lIlIlIIIIlIllIl += this.rand.nextInt(lIlIlIIIIlIlIIl + 1);
            }
            for (int lIlIlIIIIlIlIll = 0; lIlIlIIIIlIlIll < lIlIlIIIIlIllIl; ++lIlIlIIIIlIlIll) {
                this.dropItem(lIlIlIIIIlIllII, 1);
            }
        }
    }
    
    public EntityWitch(final World lIlIlIIIllIllll) {
        super(lIlIlIIIllIllll);
        this.setSize(0.6f, 1.95f);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0, 60, 10.0f));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0));
        this.tasks.addTask(2, this.field_175455_a);
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
    
    public boolean getAggressive() {
        return this.getDataWatcher().getWatchableObjectByte(21) == 1;
    }
}
