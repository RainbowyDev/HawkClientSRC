package net.minecraft.entity;

import net.minecraft.world.biome.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.pathfinding.*;
import net.minecraft.world.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.entity.passive.*;
import optifine.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraft.entity.monster.*;
import net.minecraft.enchantment.*;
import net.minecraft.init.*;

public abstract class EntityLiving extends EntityLivingBase
{
    public /* synthetic */ BiomeGenBase spawnBiome;
    public /* synthetic */ int livingSoundTime;
    private /* synthetic */ boolean canPickUpLoot;
    protected /* synthetic */ EntityMoveHelper moveHelper;
    private /* synthetic */ EntityLookHelper lookHelper;
    public /* synthetic */ int randomMobsId;
    protected /* synthetic */ float[] equipmentDropChances;
    private /* synthetic */ ItemStack[] equipment;
    private /* synthetic */ EntityBodyHelper bodyHelper;
    private /* synthetic */ boolean isLeashed;
    private /* synthetic */ boolean persistenceRequired;
    protected /* synthetic */ int experienceValue;
    protected /* synthetic */ EntityJumpHelper jumpHelper;
    protected /* synthetic */ PathNavigate navigator;
    protected final /* synthetic */ EntityAITasks targetTasks;
    private /* synthetic */ NBTTagCompound leashNBTTag;
    private /* synthetic */ Entity leashedToEntity;
    protected final /* synthetic */ EntityAITasks tasks;
    public /* synthetic */ BlockPos spawnPosition;
    private /* synthetic */ EntitySenses senses;
    private /* synthetic */ EntityLivingBase attackTarget;
    
    public void setMoveForward(final float llllllllllllllIIIIllIIlIlIlIllIl) {
        this.moveForward = llllllllllllllIIIIllIIlIlIlIllIl;
    }
    
    public void setAttackTarget(final EntityLivingBase llllllllllllllIIIIllIIllIIlIlIIl) {
        this.attackTarget = llllllllllllllIIIIllIIllIIlIlIIl;
        Reflector.callVoid(Reflector.ForgeHooks_onLivingSetAttackTarget, this, llllllllllllllIIIIllIIllIIlIlIIl);
    }
    
    public boolean isNoDespawnRequired() {
        return this.persistenceRequired;
    }
    
    public void spawnExplosionParticle() {
        if (this.worldObj.isRemote) {
            for (int llllllllllllllIIIIllIIllIIIIIIlI = 0; llllllllllllllIIIIllIIllIIIIIIlI < 20; ++llllllllllllllIIIIllIIllIIIIIIlI) {
                final double llllllllllllllIIIIllIIllIIIIIIIl = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIIIIllIIllIIIIIIII = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIIIIllIIlIllllllll = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIIIIllIIlIlllllllI = 10.0;
                this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width - llllllllllllllIIIIllIIllIIIIIIIl * llllllllllllllIIIIllIIlIlllllllI, this.posY + this.rand.nextFloat() * this.height - llllllllllllllIIIIllIIllIIIIIIII * llllllllllllllIIIIllIIlIlllllllI, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width - llllllllllllllIIIIllIIlIllllllll * llllllllllllllIIIIllIIlIlllllllI, llllllllllllllIIIIllIIllIIIIIIIl, llllllllllllllIIIIllIIllIIIIIIII, llllllllllllllIIIIllIIlIllllllll, new int[0]);
            }
        }
        else {
            this.worldObj.setEntityState(this, (byte)20);
        }
    }
    
    protected void setNoAI(final boolean llllllllllllllIIIIllIIIlIlIlIlII) {
        this.dataWatcher.updateObject(15, (byte)(byte)(llllllllllllllIIIIllIIIlIlIlIlII ? 1 : 0));
    }
    
    public EntityMoveHelper getMoveHelper() {
        return this.moveHelper;
    }
    
    public boolean allowLeashing() {
        return !this.getLeashed() && !(this instanceof IMob);
    }
    
    public void eatGrassBonus() {
    }
    
    public void playLivingSound() {
        final String llllllllllllllIIIIllIIllIIIlllII = this.getLivingSound();
        if (llllllllllllllIIIIllIIllIIIlllII != null) {
            this.playSound(llllllllllllllIIIIllIIllIIIlllII, this.getSoundVolume(), this.getSoundPitch());
        }
    }
    
    public float getRenderSizeModifier() {
        return 1.0f;
    }
    
    protected void updateLeashedState() {
        if (this.leashNBTTag != null) {
            this.recreateLeash();
        }
        if (this.isLeashed) {
            if (!this.isEntityAlive()) {
                this.clearLeashed(true, true);
            }
            if (this.leashedToEntity == null || this.leashedToEntity.isDead) {
                this.clearLeashed(true, true);
            }
        }
    }
    
    @Override
    public ItemStack getEquipmentInSlot(final int llllllllllllllIIIIllIIlIIIIllIll) {
        return this.equipment[llllllllllllllIIIIllIIlIIIIllIll];
    }
    
    @Override
    public void setAIMoveSpeed(final float llllllllllllllIIIIllIIlIlIlIlIIl) {
        super.setAIMoveSpeed(llllllllllllllIIIIllIIlIlIlIlIIl);
        this.setMoveForward(llllllllllllllIIIIllIIlIlIlIlIIl);
    }
    
    public boolean handleLavaMovement() {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox());
    }
    
    @Override
    public void onUpdate() {
        if (Config.isSmoothWorld() && this.canSkipUpdate()) {
            this.onUpdateMinimal();
        }
        else {
            super.onUpdate();
            if (!this.worldObj.isRemote) {
                this.updateLeashedState();
            }
        }
    }
    
    public void enablePersistence() {
        this.persistenceRequired = true;
    }
    
    public static Item getArmorItemForSlot(final int llllllllllllllIIIIllIIIlllIlIllI, final int llllllllllllllIIIIllIIIlllIlIIll) {
        switch (llllllllllllllIIIIllIIIlllIlIllI) {
            case 4: {
                if (llllllllllllllIIIIllIIIlllIlIIll == 0) {
                    return Items.leather_helmet;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 1) {
                    return Items.golden_helmet;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 2) {
                    return Items.chainmail_helmet;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 3) {
                    return Items.iron_helmet;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 4) {
                    return Items.diamond_helmet;
                }
            }
            case 3: {
                if (llllllllllllllIIIIllIIIlllIlIIll == 0) {
                    return Items.leather_chestplate;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 1) {
                    return Items.golden_chestplate;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 2) {
                    return Items.chainmail_chestplate;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 3) {
                    return Items.iron_chestplate;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 4) {
                    return Items.diamond_chestplate;
                }
            }
            case 2: {
                if (llllllllllllllIIIIllIIIlllIlIIll == 0) {
                    return Items.leather_leggings;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 1) {
                    return Items.golden_leggings;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 2) {
                    return Items.chainmail_leggings;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 3) {
                    return Items.iron_leggings;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 4) {
                    return Items.diamond_leggings;
                }
            }
            case 1: {
                if (llllllllllllllIIIIllIIIlllIlIIll == 0) {
                    return Items.leather_boots;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 1) {
                    return Items.golden_boots;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 2) {
                    return Items.chainmail_boots;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 3) {
                    return Items.iron_boots;
                }
                if (llllllllllllllIIIIllIIIlllIlIIll == 4) {
                    return Items.diamond_boots;
                }
                break;
            }
        }
        return null;
    }
    
    @Override
    public void handleHealthUpdate(final byte llllllllllllllIIIIllIIlIllllIlII) {
        if (llllllllllllllIIIIllIIlIllllIlII == 20) {
            this.spawnExplosionParticle();
        }
        else {
            super.handleHealthUpdate(llllllllllllllIIIIllIIlIllllIlII);
        }
    }
    
    public boolean canBeSteered() {
        return false;
    }
    
    public void faceEntity(final Entity llllllllllllllIIIIllIIlIIlIlIIIl, final float llllllllllllllIIIIllIIlIIlIIIlII, final float llllllllllllllIIIIllIIlIIlIIIIll) {
        final double llllllllllllllIIIIllIIlIIlIIlllI = llllllllllllllIIIIllIIlIIlIlIIIl.posX - this.posX;
        final double llllllllllllllIIIIllIIlIIlIIllIl = llllllllllllllIIIIllIIlIIlIlIIIl.posZ - this.posZ;
        double llllllllllllllIIIIllIIlIIlIIlIll = 0.0;
        if (llllllllllllllIIIIllIIlIIlIlIIIl instanceof EntityLivingBase) {
            final EntityLivingBase llllllllllllllIIIIllIIlIIlIIlIlI = (EntityLivingBase)llllllllllllllIIIIllIIlIIlIlIIIl;
            final double llllllllllllllIIIIllIIlIIlIIllII = llllllllllllllIIIIllIIlIIlIIlIlI.posY + llllllllllllllIIIIllIIlIIlIIlIlI.getEyeHeight() - (this.posY + this.getEyeHeight());
        }
        else {
            llllllllllllllIIIIllIIlIIlIIlIll = (llllllllllllllIIIIllIIlIIlIlIIIl.getEntityBoundingBox().minY + llllllllllllllIIIIllIIlIIlIlIIIl.getEntityBoundingBox().maxY) / 2.0 - (this.posY + this.getEyeHeight());
        }
        final double llllllllllllllIIIIllIIlIIlIIlIIl = MathHelper.sqrt_double(llllllllllllllIIIIllIIlIIlIIlllI * llllllllllllllIIIIllIIlIIlIIlllI + llllllllllllllIIIIllIIlIIlIIllIl * llllllllllllllIIIIllIIlIIlIIllIl);
        final float llllllllllllllIIIIllIIlIIlIIlIII = (float)(Math.atan2(llllllllllllllIIIIllIIlIIlIIllIl, llllllllllllllIIIIllIIlIIlIIlllI) * 180.0 / 3.141592653589793) - 90.0f;
        final float llllllllllllllIIIIllIIlIIlIIIlll = (float)(-(Math.atan2(llllllllllllllIIIIllIIlIIlIIlIll, llllllllllllllIIIIllIIlIIlIIlIIl) * 180.0 / 3.141592653589793));
        this.rotationPitch = this.updateRotation(this.rotationPitch, llllllllllllllIIIIllIIlIIlIIIlll, llllllllllllllIIIIllIIlIIlIIIIll);
        this.rotationYaw = this.updateRotation(this.rotationYaw, llllllllllllllIIIIllIIlIIlIIlIII, llllllllllllllIIIIllIIlIIlIIIlII);
    }
    
    public EntityLiving(final World llllllllllllllIIIIllIIllIlIlIIIl) {
        super(llllllllllllllIIIIllIIllIlIlIIIl);
        this.equipment = new ItemStack[5];
        this.equipmentDropChances = new float[5];
        this.randomMobsId = 0;
        this.spawnBiome = null;
        this.spawnPosition = null;
        this.tasks = new EntityAITasks((llllllllllllllIIIIllIIllIlIlIIIl != null && llllllllllllllIIIIllIIllIlIlIIIl.theProfiler != null) ? llllllllllllllIIIIllIIllIlIlIIIl.theProfiler : null);
        this.targetTasks = new EntityAITasks((llllllllllllllIIIIllIIllIlIlIIIl != null && llllllllllllllIIIIllIIllIlIlIIIl.theProfiler != null) ? llllllllllllllIIIIllIIllIlIlIIIl.theProfiler : null);
        this.lookHelper = new EntityLookHelper(this);
        this.moveHelper = new EntityMoveHelper(this);
        this.jumpHelper = new EntityJumpHelper(this);
        this.bodyHelper = new EntityBodyHelper(this);
        this.navigator = this.func_175447_b(llllllllllllllIIIIllIIllIlIlIIIl);
        this.senses = new EntitySenses(this);
        for (int llllllllllllllIIIIllIIllIlIlIIII = 0; llllllllllllllIIIIllIIllIlIlIIII < this.equipmentDropChances.length; ++llllllllllllllIIIIllIIllIlIlIIII) {
            this.equipmentDropChances[llllllllllllllIIIIllIIllIlIlIIII] = 0.085f;
        }
        final UUID llllllllllllllIIIIllIIllIlIIllll = this.getUniqueID();
        final long llllllllllllllIIIIllIIllIlIIlllI = llllllllllllllIIIIllIIllIlIIllll.getLeastSignificantBits();
        this.randomMobsId = (int)(llllllllllllllIIIIllIIllIlIIlllI & 0x7FFFFFFFL);
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.worldObj.theProfiler.startSection("looting");
        if (!this.worldObj.isRemote && this.canPickUpLoot() && !this.dead && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
            final List llllllllllllllIIIIllIIlIlIlIIIIl = this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox().expand(1.0, 0.0, 1.0));
            for (final EntityItem llllllllllllllIIIIllIIlIlIIlllll : llllllllllllllIIIIllIIlIlIlIIIIl) {
                if (!llllllllllllllIIIIllIIlIlIIlllll.isDead && llllllllllllllIIIIllIIlIlIIlllll.getEntityItem() != null && !llllllllllllllIIIIllIIlIlIIlllll.func_174874_s()) {
                    this.func_175445_a(llllllllllllllIIIIllIIlIlIIlllll);
                }
            }
        }
        this.worldObj.theProfiler.endSection();
    }
    
    protected void despawnEntity() {
        Object llllllllllllllIIIIllIIlIIlllIIlI = null;
        final Object llllllllllllllIIIIllIIlIIlllIIIl = Reflector.getFieldValue(Reflector.Event_Result_DEFAULT);
        final Object llllllllllllllIIIIllIIlIIlllIIII = Reflector.getFieldValue(Reflector.Event_Result_DENY);
        if (this.persistenceRequired) {
            this.entityAge = 0;
        }
        else if ((this.entityAge & 0x1F) == 0x1F && (llllllllllllllIIIIllIIlIIlllIIlI = Reflector.call(Reflector.ForgeEventFactory_canEntityDespawn, this)) != llllllllllllllIIIIllIIlIIlllIIIl) {
            if (llllllllllllllIIIIllIIlIIlllIIlI == llllllllllllllIIIIllIIlIIlllIIII) {
                this.entityAge = 0;
            }
            else {
                this.setDead();
            }
        }
        else {
            final EntityPlayer llllllllllllllIIIIllIIlIIllIllll = this.worldObj.getClosestPlayerToEntity(this, -1.0);
            if (llllllllllllllIIIIllIIlIIllIllll != null) {
                final double llllllllllllllIIIIllIIlIIllIlllI = llllllllllllllIIIIllIIlIIllIllll.posX - this.posX;
                final double llllllllllllllIIIIllIIlIIllIllIl = llllllllllllllIIIIllIIlIIllIllll.posY - this.posY;
                final double llllllllllllllIIIIllIIlIIllIllII = llllllllllllllIIIIllIIlIIllIllll.posZ - this.posZ;
                final double llllllllllllllIIIIllIIlIIllIlIll = llllllllllllllIIIIllIIlIIllIlllI * llllllllllllllIIIIllIIlIIllIlllI + llllllllllllllIIIIllIIlIIllIllIl * llllllllllllllIIIIllIIlIIllIllIl + llllllllllllllIIIIllIIlIIllIllII * llllllllllllllIIIIllIIlIIllIllII;
                if (this.canDespawn() && llllllllllllllIIIIllIIlIIllIlIll > 16384.0) {
                    this.setDead();
                }
                if (this.entityAge > 600 && this.rand.nextInt(800) == 0 && llllllllllllllIIIIllIIlIIllIlIll > 1024.0 && this.canDespawn()) {
                    this.setDead();
                }
                else if (llllllllllllllIIIIllIIlIIllIlIll < 1024.0) {
                    this.entityAge = 0;
                }
            }
        }
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIIIllIIlIllIIlllI) {
        super.writeEntityToNBT(llllllllllllllIIIIllIIlIllIIlllI);
        llllllllllllllIIIIllIIlIllIIlllI.setBoolean("CanPickUpLoot", this.canPickUpLoot());
        llllllllllllllIIIIllIIlIllIIlllI.setBoolean("PersistenceRequired", this.persistenceRequired);
        final NBTTagList llllllllllllllIIIIllIIlIllIIllIl = new NBTTagList();
        for (int llllllllllllllIIIIllIIlIllIIlIlI = 0; llllllllllllllIIIIllIIlIllIIlIlI < this.equipment.length; ++llllllllllllllIIIIllIIlIllIIlIlI) {
            final NBTTagCompound llllllllllllllIIIIllIIlIllIIllII = new NBTTagCompound();
            if (this.equipment[llllllllllllllIIIIllIIlIllIIlIlI] != null) {
                this.equipment[llllllllllllllIIIIllIIlIllIIlIlI].writeToNBT(llllllllllllllIIIIllIIlIllIIllII);
            }
            llllllllllllllIIIIllIIlIllIIllIl.appendTag(llllllllllllllIIIIllIIlIllIIllII);
        }
        llllllllllllllIIIIllIIlIllIIlllI.setTag("Equipment", llllllllllllllIIIIllIIlIllIIllIl);
        final NBTTagList llllllllllllllIIIIllIIlIllIIlIIl = new NBTTagList();
        for (int llllllllllllllIIIIllIIlIllIIlIII = 0; llllllllllllllIIIIllIIlIllIIlIII < this.equipmentDropChances.length; ++llllllllllllllIIIIllIIlIllIIlIII) {
            llllllllllllllIIIIllIIlIllIIlIIl.appendTag(new NBTTagFloat(this.equipmentDropChances[llllllllllllllIIIIllIIlIllIIlIII]));
        }
        llllllllllllllIIIIllIIlIllIIlllI.setTag("DropChances", llllllllllllllIIIIllIIlIllIIlIIl);
        llllllllllllllIIIIllIIlIllIIlllI.setBoolean("Leashed", this.isLeashed);
        if (this.leashedToEntity != null) {
            final NBTTagCompound llllllllllllllIIIIllIIlIllIIlIll = new NBTTagCompound();
            if (this.leashedToEntity instanceof EntityLivingBase) {
                llllllllllllllIIIIllIIlIllIIlIll.setLong("UUIDMost", this.leashedToEntity.getUniqueID().getMostSignificantBits());
                llllllllllllllIIIIllIIlIllIIlIll.setLong("UUIDLeast", this.leashedToEntity.getUniqueID().getLeastSignificantBits());
            }
            else if (this.leashedToEntity instanceof EntityHanging) {
                final BlockPos llllllllllllllIIIIllIIlIllIIIlll = ((EntityHanging)this.leashedToEntity).func_174857_n();
                llllllllllllllIIIIllIIlIllIIlIll.setInteger("X", llllllllllllllIIIIllIIlIllIIIlll.getX());
                llllllllllllllIIIIllIIlIllIIlIll.setInteger("Y", llllllllllllllIIIIllIIlIllIIIlll.getY());
                llllllllllllllIIIIllIIlIllIIlIll.setInteger("Z", llllllllllllllIIIIllIIlIllIIIlll.getZ());
            }
            llllllllllllllIIIIllIIlIllIIlllI.setTag("Leash", llllllllllllllIIIIllIIlIllIIlIll);
        }
        if (this.isAIDisabled()) {
            llllllllllllllIIIIllIIlIllIIlllI.setBoolean("NoAI", this.isAIDisabled());
        }
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer llllllllllllllIIIIllIIllIIIlIIIl) {
        if (this.experienceValue > 0) {
            int llllllllllllllIIIIllIIllIIIlIIII = this.experienceValue;
            final ItemStack[] llllllllllllllIIIIllIIllIIIIllll = this.getInventory();
            for (int llllllllllllllIIIIllIIllIIIIlllI = 0; llllllllllllllIIIIllIIllIIIIlllI < llllllllllllllIIIIllIIllIIIIllll.length; ++llllllllllllllIIIIllIIllIIIIlllI) {
                if (llllllllllllllIIIIllIIllIIIIllll[llllllllllllllIIIIllIIllIIIIlllI] != null && this.equipmentDropChances[llllllllllllllIIIIllIIllIIIIlllI] <= 1.0f) {
                    llllllllllllllIIIIllIIllIIIlIIII += 1 + this.rand.nextInt(3);
                }
            }
            return llllllllllllllIIIIllIIllIIIlIIII;
        }
        return this.experienceValue;
    }
    
    public void setEquipmentDropChance(final int llllllllllllllIIIIllIIIllIllIIIl, final float llllllllllllllIIIIllIIIllIllIIll) {
        this.equipmentDropChances[llllllllllllllIIIIllIIIllIllIIIl] = llllllllllllllIIIIllIIIllIllIIll;
    }
    
    protected void func_180481_a(final DifficultyInstance llllllllllllllIIIIllIIIllllIIIIl) {
        if (this.rand.nextFloat() < 0.15f * llllllllllllllIIIIllIIIllllIIIIl.func_180170_c()) {
            int llllllllllllllIIIIllIIIllllIIlll = this.rand.nextInt(2);
            final float llllllllllllllIIIIllIIIllllIIllI = (this.worldObj.getDifficulty() == EnumDifficulty.HARD) ? 0.1f : 0.25f;
            if (this.rand.nextFloat() < 0.095f) {
                ++llllllllllllllIIIIllIIIllllIIlll;
            }
            if (this.rand.nextFloat() < 0.095f) {
                ++llllllllllllllIIIIllIIIllllIIlll;
            }
            if (this.rand.nextFloat() < 0.095f) {
                ++llllllllllllllIIIIllIIIllllIIlll;
            }
            for (int llllllllllllllIIIIllIIIllllIIlIl = 3; llllllllllllllIIIIllIIIllllIIlIl >= 0; --llllllllllllllIIIIllIIIllllIIlIl) {
                final ItemStack llllllllllllllIIIIllIIIllllIIlII = this.getCurrentArmor(llllllllllllllIIIIllIIIllllIIlIl);
                if (llllllllllllllIIIIllIIIllllIIlIl < 3 && this.rand.nextFloat() < llllllllllllllIIIIllIIIllllIIllI) {
                    break;
                }
                if (llllllllllllllIIIIllIIIllllIIlII == null) {
                    final Item llllllllllllllIIIIllIIIllllIIIll = getArmorItemForSlot(llllllllllllllIIIIllIIIllllIIlIl + 1, llllllllllllllIIIIllIIIllllIIlll);
                    if (llllllllllllllIIIIllIIIllllIIIll != null) {
                        this.setCurrentItemOrArmor(llllllllllllllIIIIllIIIllllIIlIl + 1, new ItemStack(llllllllllllllIIIIllIIIllllIIIll));
                    }
                }
            }
        }
    }
    
    public EntityJumpHelper getJumpHelper() {
        return this.jumpHelper;
    }
    
    @Override
    public boolean func_174820_d(final int llllllllllllllIIIIllIIIlIllIIlII, final ItemStack llllllllllllllIIIIllIIIlIlIllllI) {
        int llllllllllllllIIIIllIIIlIllIIIIl = 0;
        if (llllllllllllllIIIIllIIIlIllIIlII == 99) {
            final int llllllllllllllIIIIllIIIlIllIIIlI = 0;
        }
        else {
            llllllllllllllIIIIllIIIlIllIIIIl = llllllllllllllIIIIllIIIlIllIIlII - 100 + 1;
            if (llllllllllllllIIIIllIIIlIllIIIIl < 0 || llllllllllllllIIIIllIIIlIllIIIIl >= this.equipment.length) {
                return false;
            }
        }
        if (llllllllllllllIIIIllIIIlIlIllllI != null && getArmorPosition(llllllllllllllIIIIllIIIlIlIllllI) != llllllllllllllIIIIllIIIlIllIIIIl && (llllllllllllllIIIIllIIIlIllIIIIl != 4 || !(llllllllllllllIIIIllIIIlIlIllllI.getItem() instanceof ItemBlock))) {
            return false;
        }
        this.setCurrentItemOrArmor(llllllllllllllIIIIllIIIlIllIIIIl, llllllllllllllIIIIllIIIlIlIllllI);
        return true;
    }
    
    private void onUpdateMinimal() {
        ++this.entityAge;
        if (this instanceof EntityMob) {
            final float llllllllllllllIIIIllIIIlIIlIlIIl = this.getBrightness(1.0f);
            if (llllllllllllllIIIIllIIIlIIlIlIIl > 0.5f) {
                this.entityAge += 2;
            }
        }
        this.despawnEntity();
    }
    
    protected void updateAITasks() {
    }
    
    public boolean getCanSpawnHere() {
        return true;
    }
    
    @Override
    protected void dropEquipment(final boolean llllllllllllllIIIIllIIIlllllIlll, final int llllllllllllllIIIIllIIIllllllllI) {
        for (int llllllllllllllIIIIllIIIlllllllIl = 0; llllllllllllllIIIIllIIIlllllllIl < this.getInventory().length; ++llllllllllllllIIIIllIIIlllllllIl) {
            final ItemStack llllllllllllllIIIIllIIIlllllllII = this.getEquipmentInSlot(llllllllllllllIIIIllIIIlllllllIl);
            final boolean llllllllllllllIIIIllIIIllllllIll = this.equipmentDropChances[llllllllllllllIIIIllIIIlllllllIl] > 1.0f;
            if (llllllllllllllIIIIllIIIlllllllII != null && (llllllllllllllIIIIllIIIlllllIlll || llllllllllllllIIIIllIIIllllllIll) && this.rand.nextFloat() - llllllllllllllIIIIllIIIllllllllI * 0.01f < this.equipmentDropChances[llllllllllllllIIIIllIIIlllllllIl]) {
                if (!llllllllllllllIIIIllIIIllllllIll && llllllllllllllIIIIllIIIlllllllII.isItemStackDamageable()) {
                    final int llllllllllllllIIIIllIIIllllllIlI = Math.max(llllllllllllllIIIIllIIIlllllllII.getMaxDamage() - 25, 1);
                    int llllllllllllllIIIIllIIIllllllIIl = llllllllllllllIIIIllIIIlllllllII.getMaxDamage() - this.rand.nextInt(this.rand.nextInt(llllllllllllllIIIIllIIIllllllIlI) + 1);
                    if (llllllllllllllIIIIllIIIllllllIIl > llllllllllllllIIIIllIIIllllllIlI) {
                        llllllllllllllIIIIllIIIllllllIIl = llllllllllllllIIIIllIIIllllllIlI;
                    }
                    if (llllllllllllllIIIIllIIIllllllIIl < 1) {
                        llllllllllllllIIIIllIIIllllllIIl = 1;
                    }
                    llllllllllllllIIIIllIIIlllllllII.setItemDamage(llllllllllllllIIIIllIIIllllllIIl);
                }
                this.entityDropItem(llllllllllllllIIIIllIIIlllllllII, 0.0f);
            }
        }
    }
    
    @Override
    public void setCurrentItemOrArmor(final int llllllllllllllIIIIllIIlIIIIlIIII, final ItemStack llllllllllllllIIIIllIIlIIIIIllII) {
        this.equipment[llllllllllllllIIIIllIIlIIIIlIIII] = llllllllllllllIIIIllIIlIIIIIllII;
    }
    
    protected PathNavigate func_175447_b(final World llllllllllllllIIIIllIIllIlIIIIIl) {
        return new PathNavigateGround(this, llllllllllllllIIIIllIIllIlIIIIIl);
    }
    
    public void clearLeashed(final boolean llllllllllllllIIIIllIIIllIIlIIIl, final boolean llllllllllllllIIIIllIIIllIIIllIl) {
        if (this.isLeashed) {
            this.isLeashed = false;
            this.leashedToEntity = null;
            if (!this.worldObj.isRemote && llllllllllllllIIIIllIIIllIIIllIl) {
                this.dropItem(Items.lead, 1);
            }
            if (!this.worldObj.isRemote && llllllllllllllIIIIllIIIllIIlIIIl && this.worldObj instanceof WorldServer) {
                ((WorldServer)this.worldObj).getEntityTracker().sendToAllTrackingEntity(this, new S1BPacketEntityAttach(1, this, null));
            }
        }
    }
    
    public void setLeashedToEntity(final Entity llllllllllllllIIIIllIIIlIlllllll, final boolean llllllllllllllIIIIllIIIlIllllllI) {
        this.isLeashed = true;
        this.leashedToEntity = llllllllllllllIIIIllIIIlIlllllll;
        if (!this.worldObj.isRemote && llllllllllllllIIIIllIIIlIllllllI && this.worldObj instanceof WorldServer) {
            ((WorldServer)this.worldObj).getEntityTracker().sendToAllTrackingEntity(this, new S1BPacketEntityAttach(1, this, this.leashedToEntity));
        }
    }
    
    protected String getLivingSound() {
        return null;
    }
    
    @Override
    public final boolean interactFirst(final EntityPlayer llllllllllllllIIIIllIIIllIIlllII) {
        if (this.getLeashed() && this.getLeashedToEntity() == llllllllllllllIIIIllIIIllIIlllII) {
            this.clearLeashed(true, !llllllllllllllIIIIllIIIllIIlllII.capabilities.isCreativeMode);
            return true;
        }
        final ItemStack llllllllllllllIIIIllIIIllIIllllI = llllllllllllllIIIIllIIIllIIlllII.inventory.getCurrentItem();
        if (llllllllllllllIIIIllIIIllIIllllI != null && llllllllllllllIIIIllIIIllIIllllI.getItem() == Items.lead && this.allowLeashing()) {
            if (!(this instanceof EntityTameable) || !((EntityTameable)this).isTamed()) {
                this.setLeashedToEntity(llllllllllllllIIIIllIIIllIIlllII, true);
                final ItemStack itemStack = llllllllllllllIIIIllIIIllIIllllI;
                --itemStack.stackSize;
                return true;
            }
            if (((EntityTameable)this).func_152114_e(llllllllllllllIIIIllIIIllIIlllII)) {
                this.setLeashedToEntity(llllllllllllllIIIIllIIIllIIlllII, true);
                final ItemStack itemStack2 = llllllllllllllIIIIllIIIllIIllllI;
                --itemStack2.stackSize;
                return true;
            }
        }
        return this.interact(llllllllllllllIIIIllIIIllIIlllII) || super.interactFirst(llllllllllllllIIIIllIIIllIIlllII);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0);
    }
    
    public Entity getLeashedToEntity() {
        return this.leashedToEntity;
    }
    
    public int getMaxSpawnedInChunk() {
        return 4;
    }
    
    @Override
    public ItemStack getHeldItem() {
        return this.equipment[0];
    }
    
    private float updateRotation(final float llllllllllllllIIIIllIIlIIIllIlll, final float llllllllllllllIIIIllIIlIIIllIllI, final float llllllllllllllIIIIllIIlIIIllIIIl) {
        float llllllllllllllIIIIllIIlIIIllIlII = MathHelper.wrapAngleTo180_float(llllllllllllllIIIIllIIlIIIllIllI - llllllllllllllIIIIllIIlIIIllIlll);
        if (llllllllllllllIIIIllIIlIIIllIlII > llllllllllllllIIIIllIIlIIIllIIIl) {
            llllllllllllllIIIIllIIlIIIllIlII = llllllllllllllIIIIllIIlIIIllIIIl;
        }
        if (llllllllllllllIIIIllIIlIIIllIlII < -llllllllllllllIIIIllIIlIIIllIIIl) {
            llllllllllllllIIIIllIIlIIIllIlII = -llllllllllllllIIIIllIIlIIIllIIIl;
        }
        return llllllllllllllIIIIllIIlIIIllIlll + llllllllllllllIIIIllIIlIIIllIlII;
    }
    
    @Override
    public boolean isServerWorld() {
        return super.isServerWorld() && !this.isAIDisabled();
    }
    
    protected Item getDropItem() {
        return null;
    }
    
    @Override
    public boolean isEntityInsideOpaqueBlock() {
        if (this.noClip) {
            return false;
        }
        final BlockPosM llllllllllllllIIIIllIIIlIlIIlIIl = new BlockPosM(0, 0, 0);
        for (int llllllllllllllIIIIllIIIlIlIIlIII = 0; llllllllllllllIIIIllIIIlIlIIlIII < 8; ++llllllllllllllIIIIllIIIlIlIIlIII) {
            final double llllllllllllllIIIIllIIIlIlIIIlll = this.posX + ((llllllllllllllIIIIllIIIlIlIIlIII >> 0) % 2 - 0.5f) * this.width * 0.8f;
            final double llllllllllllllIIIIllIIIlIlIIIllI = this.posY + ((llllllllllllllIIIIllIIIlIlIIlIII >> 1) % 2 - 0.5f) * 0.1f;
            final double llllllllllllllIIIIllIIIlIlIIIlIl = this.posZ + ((llllllllllllllIIIIllIIIlIlIIlIII >> 2) % 2 - 0.5f) * this.width * 0.8f;
            llllllllllllllIIIIllIIIlIlIIlIIl.setXyz(llllllllllllllIIIIllIIIlIlIIIlll, llllllllllllllIIIIllIIIlIlIIIllI + this.getEyeHeight(), llllllllllllllIIIIllIIIlIlIIIlIl);
            if (this.worldObj.getBlockState(llllllllllllllIIIIllIIIlIlIIlIIl).getBlock().isVisuallyOpaque()) {
                return true;
            }
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00001550";
    }
    
    private boolean canSkipUpdate() {
        if (this.isChild()) {
            return false;
        }
        if (this.hurtTime > 0) {
            return false;
        }
        if (this.ticksExisted < 20) {
            return false;
        }
        final World llllllllllllllIIIIllIIIlIIllIlll = this.getEntityWorld();
        if (llllllllllllllIIIIllIIIlIIllIlll == null) {
            return false;
        }
        if (llllllllllllllIIIIllIIIlIIllIlll.playerEntities.size() != 1) {
            return false;
        }
        final Entity llllllllllllllIIIIllIIIlIIllIllI = llllllllllllllIIIIllIIIlIIllIlll.playerEntities.get(0);
        final double llllllllllllllIIIIllIIIlIIllIlIl = Math.max(Math.abs(this.posX - llllllllllllllIIIIllIIIlIIllIllI.posX) - 16.0, 0.0);
        final double llllllllllllllIIIIllIIIlIIllIlII = Math.max(Math.abs(this.posZ - llllllllllllllIIIIllIIIlIIllIllI.posZ) - 16.0, 0.0);
        final double llllllllllllllIIIIllIIIlIIllIIll = llllllllllllllIIIIllIIIlIIllIlIl * llllllllllllllIIIIllIIIlIIllIlIl + llllllllllllllIIIIllIIIlIIllIlII * llllllllllllllIIIIllIIIlIIllIlII;
        return !this.isInRangeToRenderDist(llllllllllllllIIIIllIIIlIIllIIll);
    }
    
    public EntityLookHelper getLookHelper() {
        return this.lookHelper;
    }
    
    public int getVerticalFaceSpeed() {
        return 40;
    }
    
    public PathNavigate getNavigator() {
        return this.navigator;
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance llllllllllllllIIIIllIIIlllIIIIII, final IEntityLivingData llllllllllllllIIIIllIIIllIllllll) {
        this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * 0.05, 1));
        return llllllllllllllIIIIllIIIllIllllll;
    }
    
    public boolean getLeashed() {
        return this.isLeashed;
    }
    
    @Override
    protected float func_110146_f(final float llllllllllllllIIIIllIIlIlllIlIll, final float llllllllllllllIIIIllIIlIlllIlIII) {
        this.bodyHelper.updateRenderAngles();
        return llllllllllllllIIIIllIIlIlllIlIII;
    }
    
    @Override
    public int getMaxFallHeight() {
        if (this.getAttackTarget() == null) {
            return 3;
        }
        int llllllllllllllIIIIllIIlIIIlIIllI = (int)(this.getHealth() - this.getMaxHealth() * 0.33f);
        llllllllllllllIIIIllIIlIIIlIIllI -= (3 - this.worldObj.getDifficulty().getDifficultyId()) * 4;
        if (llllllllllllllIIIIllIIlIIIlIIllI < 0) {
            llllllllllllllIIIIllIIlIIIlIIllI = 0;
        }
        return llllllllllllllIIIIllIIlIIIlIIllI + 3;
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllIIIIllIIlIllIlllll, final int llllllllllllllIIIIllIIlIllIllllI) {
        final Item llllllllllllllIIIIllIIlIllIlllIl = this.getDropItem();
        if (llllllllllllllIIIIllIIlIllIlllIl != null) {
            int llllllllllllllIIIIllIIlIllIlllII = this.rand.nextInt(3);
            if (llllllllllllllIIIIllIIlIllIllllI > 0) {
                llllllllllllllIIIIllIIlIllIlllII += this.rand.nextInt(llllllllllllllIIIIllIIlIllIllllI + 1);
            }
            for (int llllllllllllllIIIIllIIlIllIllIll = 0; llllllllllllllIIIIllIIlIllIllIll < llllllllllllllIIIIllIIlIllIlllII; ++llllllllllllllIIIIllIIlIllIllIll) {
                this.dropItem(llllllllllllllIIIIllIIlIllIlllIl, 1);
            }
        }
    }
    
    public EntitySenses getEntitySenses() {
        return this.senses;
    }
    
    protected void func_175445_a(final EntityItem llllllllllllllIIIIllIIlIlIIlIIIl) {
        final ItemStack llllllllllllllIIIIllIIlIlIIlIIII = llllllllllllllIIIIllIIlIlIIlIIIl.getEntityItem();
        final int llllllllllllllIIIIllIIlIlIIIllll = getArmorPosition(llllllllllllllIIIIllIIlIlIIlIIII);
        if (llllllllllllllIIIIllIIlIlIIIllll > -1) {
            boolean llllllllllllllIIIIllIIlIlIIIlllI = true;
            final ItemStack llllllllllllllIIIIllIIlIlIIIllIl = this.getEquipmentInSlot(llllllllllllllIIIIllIIlIlIIIllll);
            if (llllllllllllllIIIIllIIlIlIIIllIl != null) {
                if (llllllllllllllIIIIllIIlIlIIIllll == 0) {
                    if (llllllllllllllIIIIllIIlIlIIlIIII.getItem() instanceof ItemSword && !(llllllllllllllIIIIllIIlIlIIIllIl.getItem() instanceof ItemSword)) {
                        llllllllllllllIIIIllIIlIlIIIlllI = true;
                    }
                    else if (llllllllllllllIIIIllIIlIlIIlIIII.getItem() instanceof ItemSword && llllllllllllllIIIIllIIlIlIIIllIl.getItem() instanceof ItemSword) {
                        final ItemSword llllllllllllllIIIIllIIlIlIIIllII = (ItemSword)llllllllllllllIIIIllIIlIlIIlIIII.getItem();
                        final ItemSword llllllllllllllIIIIllIIlIlIIIlIll = (ItemSword)llllllllllllllIIIIllIIlIlIIIllIl.getItem();
                        if (llllllllllllllIIIIllIIlIlIIIllII.func_150931_i() == llllllllllllllIIIIllIIlIlIIIlIll.func_150931_i()) {
                            llllllllllllllIIIIllIIlIlIIIlllI = (llllllllllllllIIIIllIIlIlIIlIIII.getMetadata() > llllllllllllllIIIIllIIlIlIIIllIl.getMetadata() || (llllllllllllllIIIIllIIlIlIIlIIII.hasTagCompound() && !llllllllllllllIIIIllIIlIlIIIllIl.hasTagCompound()));
                        }
                        else {
                            llllllllllllllIIIIllIIlIlIIIlllI = (llllllllllllllIIIIllIIlIlIIIllII.func_150931_i() > llllllllllllllIIIIllIIlIlIIIlIll.func_150931_i());
                        }
                    }
                    else {
                        llllllllllllllIIIIllIIlIlIIIlllI = (llllllllllllllIIIIllIIlIlIIlIIII.getItem() instanceof ItemBow && llllllllllllllIIIIllIIlIlIIIllIl.getItem() instanceof ItemBow && llllllllllllllIIIIllIIlIlIIlIIII.hasTagCompound() && !llllllllllllllIIIIllIIlIlIIIllIl.hasTagCompound());
                    }
                }
                else if (llllllllllllllIIIIllIIlIlIIlIIII.getItem() instanceof ItemArmor && !(llllllllllllllIIIIllIIlIlIIIllIl.getItem() instanceof ItemArmor)) {
                    llllllllllllllIIIIllIIlIlIIIlllI = true;
                }
                else if (llllllllllllllIIIIllIIlIlIIlIIII.getItem() instanceof ItemArmor && llllllllllllllIIIIllIIlIlIIIllIl.getItem() instanceof ItemArmor) {
                    final ItemArmor llllllllllllllIIIIllIIlIlIIIlIlI = (ItemArmor)llllllllllllllIIIIllIIlIlIIlIIII.getItem();
                    final ItemArmor llllllllllllllIIIIllIIlIlIIIlIIl = (ItemArmor)llllllllllllllIIIIllIIlIlIIIllIl.getItem();
                    if (llllllllllllllIIIIllIIlIlIIIlIlI.damageReduceAmount == llllllllllllllIIIIllIIlIlIIIlIIl.damageReduceAmount) {
                        llllllllllllllIIIIllIIlIlIIIlllI = (llllllllllllllIIIIllIIlIlIIlIIII.getMetadata() > llllllllllllllIIIIllIIlIlIIIllIl.getMetadata() || (llllllllllllllIIIIllIIlIlIIlIIII.hasTagCompound() && !llllllllllllllIIIIllIIlIlIIIllIl.hasTagCompound()));
                    }
                    else {
                        llllllllllllllIIIIllIIlIlIIIlllI = (llllllllllllllIIIIllIIlIlIIIlIlI.damageReduceAmount > llllllllllllllIIIIllIIlIlIIIlIIl.damageReduceAmount);
                    }
                }
                else {
                    llllllllllllllIIIIllIIlIlIIIlllI = false;
                }
            }
            if (llllllllllllllIIIIllIIlIlIIIlllI && this.func_175448_a(llllllllllllllIIIIllIIlIlIIlIIII)) {
                if (llllllllllllllIIIIllIIlIlIIIllIl != null && this.rand.nextFloat() - 0.1f < this.equipmentDropChances[llllllllllllllIIIIllIIlIlIIIllll]) {
                    this.entityDropItem(llllllllllllllIIIIllIIlIlIIIllIl, 0.0f);
                }
                if (llllllllllllllIIIIllIIlIlIIlIIII.getItem() == Items.diamond && llllllllllllllIIIIllIIlIlIIlIIIl.getThrower() != null) {
                    final EntityPlayer llllllllllllllIIIIllIIlIlIIIlIII = this.worldObj.getPlayerEntityByName(llllllllllllllIIIIllIIlIlIIlIIIl.getThrower());
                    if (llllllllllllllIIIIllIIlIlIIIlIII != null) {
                        llllllllllllllIIIIllIIlIlIIIlIII.triggerAchievement(AchievementList.diamondsToYou);
                    }
                }
                this.setCurrentItemOrArmor(llllllllllllllIIIIllIIlIlIIIllll, llllllllllllllIIIIllIIlIlIIlIIII);
                this.equipmentDropChances[llllllllllllllIIIIllIIlIlIIIllll] = 2.0f;
                this.persistenceRequired = true;
                this.onItemPickup(llllllllllllllIIIIllIIlIlIIlIIIl, 1);
                llllllllllllllIIIIllIIlIlIIlIIIl.setDead();
            }
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIIIllIIlIlIlllIll) {
        super.readEntityFromNBT(llllllllllllllIIIIllIIlIlIlllIll);
        if (llllllllllllllIIIIllIIlIlIlllIll.hasKey("CanPickUpLoot", 1)) {
            this.setCanPickUpLoot(llllllllllllllIIIIllIIlIlIlllIll.getBoolean("CanPickUpLoot"));
        }
        this.persistenceRequired = llllllllllllllIIIIllIIlIlIlllIll.getBoolean("PersistenceRequired");
        if (llllllllllllllIIIIllIIlIlIlllIll.hasKey("Equipment", 9)) {
            final NBTTagList llllllllllllllIIIIllIIlIlIlllIlI = llllllllllllllIIIIllIIlIlIlllIll.getTagList("Equipment", 10);
            for (int llllllllllllllIIIIllIIlIlIlllIII = 0; llllllllllllllIIIIllIIlIlIlllIII < this.equipment.length; ++llllllllllllllIIIIllIIlIlIlllIII) {
                this.equipment[llllllllllllllIIIIllIIlIlIlllIII] = ItemStack.loadItemStackFromNBT(llllllllllllllIIIIllIIlIlIlllIlI.getCompoundTagAt(llllllllllllllIIIIllIIlIlIlllIII));
            }
        }
        if (llllllllllllllIIIIllIIlIlIlllIll.hasKey("DropChances", 9)) {
            final NBTTagList llllllllllllllIIIIllIIlIlIlllIIl = llllllllllllllIIIIllIIlIlIlllIll.getTagList("DropChances", 5);
            for (int llllllllllllllIIIIllIIlIlIllIlll = 0; llllllllllllllIIIIllIIlIlIllIlll < llllllllllllllIIIIllIIlIlIlllIIl.tagCount(); ++llllllllllllllIIIIllIIlIlIllIlll) {
                this.equipmentDropChances[llllllllllllllIIIIllIIlIlIllIlll] = llllllllllllllIIIIllIIlIlIlllIIl.getFloat(llllllllllllllIIIIllIIlIlIllIlll);
            }
        }
        this.isLeashed = llllllllllllllIIIIllIIlIlIlllIll.getBoolean("Leashed");
        if (this.isLeashed && llllllllllllllIIIIllIIlIlIlllIll.hasKey("Leash", 10)) {
            this.leashNBTTag = llllllllllllllIIIIllIIlIlIlllIll.getCompoundTag("Leash");
        }
        this.setNoAI(llllllllllllllIIIIllIIlIlIlllIll.getBoolean("NoAI"));
    }
    
    protected boolean canDespawn() {
        return true;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(15, 0);
    }
    
    public boolean canPickUpLoot() {
        return this.canPickUpLoot;
    }
    
    public void setCanPickUpLoot(final boolean llllllllllllllIIIIllIIIllIlIIlll) {
        this.canPickUpLoot = llllllllllllllIIIIllIIIllIlIIlll;
    }
    
    public EntityLivingBase getAttackTarget() {
        return this.attackTarget;
    }
    
    public boolean canAttackClass(final Class llllllllllllllIIIIllIIllIIlIIllI) {
        return llllllllllllllIIIIllIIllIIlIIllI != EntityGhast.class;
    }
    
    protected boolean func_175448_a(final ItemStack llllllllllllllIIIIllIIlIIllllllI) {
        return true;
    }
    
    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        this.worldObj.theProfiler.startSection("mobBaseTick");
        if (this.isEntityAlive() && this.rand.nextInt(1000) < this.livingSoundTime++) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playLivingSound();
        }
        this.worldObj.theProfiler.endSection();
    }
    
    public int getTalkInterval() {
        return 80;
    }
    
    protected void func_180483_b(final DifficultyInstance llllllllllllllIIIIllIIIlllIIIlll) {
        final float llllllllllllllIIIIllIIIlllIIlIll = llllllllllllllIIIIllIIIlllIIIlll.func_180170_c();
        if (this.getHeldItem() != null && this.rand.nextFloat() < 0.25f * llllllllllllllIIIIllIIIlllIIlIll) {
            EnchantmentHelper.addRandomEnchantment(this.rand, this.getHeldItem(), (int)(5.0f + llllllllllllllIIIIllIIIlllIIlIll * this.rand.nextInt(18)));
        }
        for (int llllllllllllllIIIIllIIIlllIIlIlI = 0; llllllllllllllIIIIllIIIlllIIlIlI < 4; ++llllllllllllllIIIIllIIIlllIIlIlI) {
            final ItemStack llllllllllllllIIIIllIIIlllIIlIIl = this.getCurrentArmor(llllllllllllllIIIIllIIIlllIIlIlI);
            if (llllllllllllllIIIIllIIIlllIIlIIl != null && this.rand.nextFloat() < 0.5f * llllllllllllllIIIIllIIIlllIIlIll) {
                EnchantmentHelper.addRandomEnchantment(this.rand, llllllllllllllIIIIllIIIlllIIlIIl, (int)(5.0f + llllllllllllllIIIIllIIIlllIIlIll * this.rand.nextInt(18)));
            }
        }
    }
    
    @Override
    public ItemStack getCurrentArmor(final int llllllllllllllIIIIllIIlIIIIlIlll) {
        return this.equipment[llllllllllllllIIIIllIIlIIIIlIlll + 1];
    }
    
    @Override
    protected final void updateEntityActionState() {
        ++this.entityAge;
        this.worldObj.theProfiler.startSection("checkDespawn");
        this.despawnEntity();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("sensing");
        this.senses.clearSensingCache();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("targetSelector");
        this.targetTasks.onUpdateTasks();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("goalSelector");
        this.tasks.onUpdateTasks();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("navigation");
        this.navigator.onUpdateNavigation();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("mob tick");
        this.updateAITasks();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("controls");
        this.worldObj.theProfiler.startSection("move");
        this.moveHelper.onUpdateMoveHelper();
        this.worldObj.theProfiler.endStartSection("look");
        this.lookHelper.onUpdateLook();
        this.worldObj.theProfiler.endStartSection("jump");
        this.jumpHelper.doJump();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.endSection();
    }
    
    protected boolean interact(final EntityPlayer llllllllllllllIIIIllIIIllIIllIIl) {
        return false;
    }
    
    private boolean isAIDisabled() {
        return this.dataWatcher.getWatchableObjectByte(15) != 0;
    }
    
    public static int getArmorPosition(final ItemStack llllllllllllllIIIIllIIIlllIllIIl) {
        if (llllllllllllllIIIIllIIIlllIllIIl.getItem() != Item.getItemFromBlock(Blocks.pumpkin) && llllllllllllllIIIIllIIIlllIllIIl.getItem() != Items.skull) {
            if (llllllllllllllIIIIllIIIlllIllIIl.getItem() instanceof ItemArmor) {
                switch (((ItemArmor)llllllllllllllIIIIllIIIlllIllIIl.getItem()).armorType) {
                    case 0: {
                        return 4;
                    }
                    case 1: {
                        return 3;
                    }
                    case 2: {
                        return 2;
                    }
                    case 3: {
                        return 1;
                    }
                }
            }
            return 0;
        }
        return 4;
    }
    
    @Override
    public ItemStack[] getInventory() {
        return this.equipment;
    }
    
    private void recreateLeash() {
        if (this.isLeashed && this.leashNBTTag != null) {
            if (this.leashNBTTag.hasKey("UUIDMost", 4) && this.leashNBTTag.hasKey("UUIDLeast", 4)) {
                final UUID llllllllllllllIIIIllIIIlIlllIlII = new UUID(this.leashNBTTag.getLong("UUIDMost"), this.leashNBTTag.getLong("UUIDLeast"));
                final List llllllllllllllIIIIllIIIlIlllIIll = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(10.0, 10.0, 10.0));
                for (final EntityLivingBase llllllllllllllIIIIllIIIlIlllIIIl : llllllllllllllIIIIllIIIlIlllIIll) {
                    if (llllllllllllllIIIIllIIIlIlllIIIl.getUniqueID().equals(llllllllllllllIIIIllIIIlIlllIlII)) {
                        this.leashedToEntity = llllllllllllllIIIIllIIIlIlllIIIl;
                        break;
                    }
                }
            }
            else if (this.leashNBTTag.hasKey("X", 99) && this.leashNBTTag.hasKey("Y", 99) && this.leashNBTTag.hasKey("Z", 99)) {
                final BlockPos llllllllllllllIIIIllIIIlIlllIIII = new BlockPos(this.leashNBTTag.getInteger("X"), this.leashNBTTag.getInteger("Y"), this.leashNBTTag.getInteger("Z"));
                EntityLeashKnot llllllllllllllIIIIllIIIlIllIllll = EntityLeashKnot.func_174863_b(this.worldObj, llllllllllllllIIIIllIIIlIlllIIII);
                if (llllllllllllllIIIIllIIIlIllIllll == null) {
                    llllllllllllllIIIIllIIIlIllIllll = EntityLeashKnot.func_174862_a(this.worldObj, llllllllllllllIIIIllIIIlIlllIIII);
                }
                this.leashedToEntity = llllllllllllllIIIIllIIIlIllIllll;
            }
            else {
                this.clearLeashed(false, true);
            }
        }
        this.leashNBTTag = null;
    }
    
    public enum SpawnPlacementType
    {
        ON_GROUND("ON_GROUND", 0, "ON_GROUND", 0, "ON_GROUND", 0), 
        IN_WATER("IN_WATER", 2, "IN_WATER", 2, "IN_WATER", 2), 
        IN_AIR("IN_AIR", 1, "IN_AIR", 1, "IN_AIR", 1);
        
        static {
            __OBFID = "CL_00002255";
        }
        
        private SpawnPlacementType(final String lllllllllllllllIIlllIlllIIIlIIlI, final int lllllllllllllllIIlllIlllIIIlIIIl, final String lllllllllllllllIIlllIlllIIIlIlll, final int lllllllllllllllIIlllIlllIIIlIllI, final String lllllllllllllllIIlllIlllIIIlIlIl, final int lllllllllllllllIIlllIlllIIIlIlII) {
        }
    }
}
