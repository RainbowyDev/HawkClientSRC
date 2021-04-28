package net.minecraft.entity;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.network.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.item.*;
import net.minecraft.potion.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.scoreboard.*;
import net.minecraft.nbt.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.player.*;
import java.util.*;

public abstract class EntityLivingBase extends Entity
{
    private final /* synthetic */ Map activePotionsMap;
    private final /* synthetic */ CombatTracker _combatTracker;
    public /* synthetic */ float field_110154_aX;
    public /* synthetic */ float moveStrafing;
    public /* synthetic */ float limbSwing;
    private /* synthetic */ int lastAttackerTime;
    private final /* synthetic */ ItemStack[] previousEquipment;
    private /* synthetic */ int jumpTicks;
    private static final /* synthetic */ UUID sprintingSpeedBoostModifierUUID;
    private static final /* synthetic */ AttributeModifier sprintingSpeedBoostModifier;
    public /* synthetic */ float field_70768_au;
    private /* synthetic */ float field_110151_bq;
    protected /* synthetic */ int scoreValue;
    protected /* synthetic */ double newPosY;
    public /* synthetic */ float cameraPitch;
    public /* synthetic */ float prevRotationYawHead;
    public /* synthetic */ float jumpMovementFactor;
    protected /* synthetic */ double newRotationYaw;
    private /* synthetic */ float landMovementFactor;
    public /* synthetic */ int hurtTime;
    protected /* synthetic */ boolean dead;
    protected /* synthetic */ int entityAge;
    protected /* synthetic */ double newRotationPitch;
    public /* synthetic */ float rotationYawHead;
    public /* synthetic */ int maxHurtResistantTime;
    public /* synthetic */ float prevSwingProgress;
    protected /* synthetic */ double newPosX;
    public /* synthetic */ boolean isSwingInProgress;
    public /* synthetic */ int swingProgressInt;
    private /* synthetic */ EntityLivingBase entityLivingToAttack;
    public /* synthetic */ float field_70770_ap;
    private /* synthetic */ BaseAttributeMap attributeMap;
    protected /* synthetic */ int recentlyHit;
    public /* synthetic */ float prevRenderYawOffset;
    public /* synthetic */ float prevLimbSwingAmount;
    public /* synthetic */ int arrowHitTimer;
    public /* synthetic */ float prevCameraPitch;
    private /* synthetic */ int revengeTimer;
    public /* synthetic */ float field_70763_ax;
    public /* synthetic */ float swingProgress;
    protected /* synthetic */ double newPosZ;
    public /* synthetic */ float renderYawOffset;
    public /* synthetic */ int maxHurtTime;
    private /* synthetic */ EntityLivingBase lastAttacker;
    protected /* synthetic */ float lastDamage;
    public /* synthetic */ int deathTime;
    public /* synthetic */ float moveForward;
    public /* synthetic */ float limbSwingAmount;
    protected /* synthetic */ boolean isJumping;
    public /* synthetic */ float field_70769_ao;
    public /* synthetic */ float attackedAtYaw;
    protected /* synthetic */ float field_70764_aw;
    protected /* synthetic */ int newPosRotationIncrements;
    protected /* synthetic */ float randomYawVelocity;
    private /* synthetic */ boolean potionsNeedUpdate;
    protected /* synthetic */ EntityPlayer attackingPlayer;
    
    protected String getDeathSound() {
        return "game.neutral.die";
    }
    
    static {
        __OBFID = "CL_00001549";
        sprintingSpeedBoostModifierUUID = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
        sprintingSpeedBoostModifier = new AttributeModifier(EntityLivingBase.sprintingSpeedBoostModifierUUID, "Sprinting speed boost", 0.30000001192092896, 2).setSaved(false);
    }
    
    protected void updateAITick() {
        this.motionY += 0.03999999910593033;
    }
    
    protected void func_175133_bi() {
        this.dataWatcher.updateObject(8, 0);
        this.dataWatcher.updateObject(7, 0);
    }
    
    public void setAIMoveSpeed(final float lllllllllllllllIlIIllllIIIIIlIII) {
        this.landMovementFactor = lllllllllllllllIlIIllllIIIIIlIII;
    }
    
    public EntityLivingBase getAITarget() {
        return this.entityLivingToAttack;
    }
    
    @Override
    protected void func_180433_a(final double lllllllllllllllIlIlIIIIllIIIlllI, final boolean lllllllllllllllIlIlIIIIllIIlllll, final Block lllllllllllllllIlIlIIIIllIIIlIlI, final BlockPos lllllllllllllllIlIlIIIIllIIIlIII) {
        if (!this.isInWater()) {
            this.handleWaterMovement();
        }
        if (!this.worldObj.isRemote && this.fallDistance > 3.0f && lllllllllllllllIlIlIIIIllIIlllll) {
            final IBlockState lllllllllllllllIlIlIIIIllIIllIIl = this.worldObj.getBlockState(lllllllllllllllIlIlIIIIllIIIlIII);
            final Block lllllllllllllllIlIlIIIIllIIlIlll = lllllllllllllllIlIlIIIIllIIllIIl.getBlock();
            final float lllllllllllllllIlIlIIIIllIIlIlIl = (float)MathHelper.ceiling_float_int(this.fallDistance - 3.0f);
            if (lllllllllllllllIlIlIIIIllIIlIlll.getMaterial() != Material.air) {
                double lllllllllllllllIlIlIIIIllIIlIlII = Math.min(0.2f + lllllllllllllllIlIlIIIIllIIlIlIl / 15.0f, 10.0f);
                if (lllllllllllllllIlIlIIIIllIIlIlII > 2.5) {
                    lllllllllllllllIlIlIIIIllIIlIlII = 2.5;
                }
                final int lllllllllllllllIlIlIIIIllIIlIIlI = (int)(150.0 * lllllllllllllllIlIlIIIIllIIlIlII);
                ((WorldServer)this.worldObj).func_175739_a(EnumParticleTypes.BLOCK_DUST, this.posX, this.posY, this.posZ, lllllllllllllllIlIlIIIIllIIlIIlI, 0.0, 0.0, 0.0, 0.15000000596046448, Block.getStateId(lllllllllllllllIlIlIIIIllIIllIIl));
            }
        }
        super.func_180433_a(lllllllllllllllIlIlIIIIllIIIlllI, lllllllllllllllIlIlIIIIllIIlllll, lllllllllllllllIlIlIIIIllIIIlIlI, lllllllllllllllIlIlIIIIllIIIlIII);
    }
    
    protected void updateArmSwingProgress() {
        final int lllllllllllllllIlIIllllIIlllllll = this.getArmSwingAnimationEnd();
        if (this.isSwingInProgress) {
            ++this.swingProgressInt;
            if (this.swingProgressInt >= lllllllllllllllIlIIllllIIlllllll) {
                this.swingProgressInt = 0;
                this.isSwingInProgress = false;
            }
        }
        else {
            this.swingProgressInt = 0;
        }
        this.swingProgress = this.swingProgressInt / (float)lllllllllllllllIlIIllllIIlllllll;
    }
    
    public void func_152112_bu() {
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    @Override
    public abstract ItemStack[] getInventory();
    
    public boolean isOnSameTeam(final EntityLivingBase lllllllllllllllIlIIlllIlIIllllII) {
        return this.isOnTeam(lllllllllllllllIlIIlllIlIIllllII.getTeam());
    }
    
    public void setAbsorptionAmount(float lllllllllllllllIlIIlllIlIlIIIIll) {
        if (lllllllllllllllIlIIlllIlIlIIIIll < 0.0f) {
            lllllllllllllllIlIIlllIlIlIIIIll = 0.0f;
        }
        this.field_110151_bq = lllllllllllllllIlIIlllIlIlIIIIll;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            final int lllllllllllllllIlIIlllIlllllIlII = this.getArrowCountInEntity();
            if (lllllllllllllllIlIIlllIlllllIlII > 0) {
                if (this.arrowHitTimer <= 0) {
                    this.arrowHitTimer = 20 * (30 - lllllllllllllllIlIIlllIlllllIlII);
                }
                --this.arrowHitTimer;
                if (this.arrowHitTimer <= 0) {
                    this.setArrowCountInEntity(lllllllllllllllIlIIlllIlllllIlII - 1);
                }
            }
            for (int lllllllllllllllIlIIlllIlllllIIll = 0; lllllllllllllllIlIIlllIlllllIIll < 5; ++lllllllllllllllIlIIlllIlllllIIll) {
                final ItemStack lllllllllllllllIlIIlllIlllllIIlI = this.previousEquipment[lllllllllllllllIlIIlllIlllllIIll];
                final ItemStack lllllllllllllllIlIIlllIlllllIIIl = this.getEquipmentInSlot(lllllllllllllllIlIIlllIlllllIIll);
                if (!ItemStack.areItemStacksEqual(lllllllllllllllIlIIlllIlllllIIIl, lllllllllllllllIlIIlllIlllllIIlI)) {
                    ((WorldServer)this.worldObj).getEntityTracker().sendToAllTrackingEntity(this, new S04PacketEntityEquipment(this.getEntityId(), lllllllllllllllIlIIlllIlllllIIll, lllllllllllllllIlIIlllIlllllIIIl));
                    if (lllllllllllllllIlIIlllIlllllIIlI != null) {
                        this.attributeMap.removeAttributeModifiers(lllllllllllllllIlIIlllIlllllIIlI.getAttributeModifiers());
                    }
                    if (lllllllllllllllIlIIlllIlllllIIIl != null) {
                        this.attributeMap.applyAttributeModifiers(lllllllllllllllIlIIlllIlllllIIIl.getAttributeModifiers());
                    }
                    this.previousEquipment[lllllllllllllllIlIIlllIlllllIIll] = ((lllllllllllllllIlIIlllIlllllIIIl == null) ? null : lllllllllllllllIlIIlllIlllllIIIl.copy());
                }
            }
            if (this.ticksExisted % 20 == 0) {
                this.getCombatTracker().func_94549_h();
            }
        }
        this.onLivingUpdate();
        final double lllllllllllllllIlIIlllIlllllIIII = this.posX - this.prevPosX;
        final double lllllllllllllllIlIIlllIllllIllll = this.posZ - this.prevPosZ;
        final float lllllllllllllllIlIIlllIllllIlllI = (float)(lllllllllllllllIlIIlllIlllllIIII * lllllllllllllllIlIIlllIlllllIIII + lllllllllllllllIlIIlllIllllIllll * lllllllllllllllIlIIlllIllllIllll);
        float lllllllllllllllIlIIlllIllllIllIl = this.renderYawOffset;
        float lllllllllllllllIlIIlllIllllIllII = 0.0f;
        this.field_70768_au = this.field_110154_aX;
        float lllllllllllllllIlIIlllIllllIlIll = 0.0f;
        if (lllllllllllllllIlIIlllIllllIlllI > 0.0025000002f) {
            lllllllllllllllIlIIlllIllllIlIll = 1.0f;
            lllllllllllllllIlIIlllIllllIllII = (float)Math.sqrt(lllllllllllllllIlIIlllIllllIlllI) * 3.0f;
            lllllllllllllllIlIIlllIllllIllIl = (float)Math.atan2(lllllllllllllllIlIIlllIllllIllll, lllllllllllllllIlIIlllIlllllIIII) * 180.0f / 3.1415927f - 90.0f;
        }
        if (this.swingProgress > 0.0f) {
            lllllllllllllllIlIIlllIllllIllIl = this.rotationYaw;
        }
        if (!this.onGround) {
            lllllllllllllllIlIIlllIllllIlIll = 0.0f;
        }
        this.field_110154_aX += (lllllllllllllllIlIIlllIllllIlIll - this.field_110154_aX) * 0.3f;
        this.worldObj.theProfiler.startSection("headTurn");
        lllllllllllllllIlIIlllIllllIllII = this.func_110146_f(lllllllllllllllIlIIlllIllllIllIl, lllllllllllllllIlIIlllIllllIllII);
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("rangeChecks");
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset < -180.0f) {
            this.prevRenderYawOffset -= 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset >= 180.0f) {
            this.prevRenderYawOffset += 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYawHead - this.prevRotationYawHead < -180.0f) {
            this.prevRotationYawHead -= 360.0f;
        }
        while (this.rotationYawHead - this.prevRotationYawHead >= 180.0f) {
            this.prevRotationYawHead += 360.0f;
        }
        this.worldObj.theProfiler.endSection();
        this.field_70764_aw += lllllllllllllllIlIIlllIllllIllII;
    }
    
    public void removePotionEffectClient(final int lllllllllllllllIlIlIIIIIlIIIlIlI) {
        this.activePotionsMap.remove(lllllllllllllllIlIlIIIIIlIIIlIlI);
    }
    
    public void moveEntityWithHeading(final float lllllllllllllllIlIIllllIIIIlIlll, final float lllllllllllllllIlIIllllIIIlIIlll) {
        if (this.isServerWorld()) {
            if (this.isInWater() && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).capabilities.isFlying)) {
                final double lllllllllllllllIlIIllllIIIlIIllI = this.posY;
                float lllllllllllllllIlIIllllIIIlIIIIl = 0.8f;
                float lllllllllllllllIlIIllllIIIIllllI = 0.02f;
                float lllllllllllllllIlIIllllIIIlIIIll = (float)EnchantmentHelper.func_180318_b(this);
                if (lllllllllllllllIlIIllllIIIlIIIll > 3.0f) {
                    lllllllllllllllIlIIllllIIIlIIIll = 3.0f;
                }
                if (!this.onGround) {
                    lllllllllllllllIlIIllllIIIlIIIll *= 0.5f;
                }
                if (lllllllllllllllIlIIllllIIIlIIIll > 0.0f) {
                    lllllllllllllllIlIIllllIIIlIIIIl += (0.54600006f - lllllllllllllllIlIIllllIIIlIIIIl) * lllllllllllllllIlIIllllIIIlIIIll / 3.0f;
                    lllllllllllllllIlIIllllIIIIllllI += (this.getAIMoveSpeed() * 1.0f - lllllllllllllllIlIIllllIIIIllllI) * lllllllllllllllIlIIllllIIIlIIIll / 3.0f;
                }
                this.moveFlying(lllllllllllllllIlIIllllIIIIlIlll, lllllllllllllllIlIIllllIIIlIIlll, lllllllllllllllIlIIllllIIIIllllI);
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= lllllllllllllllIlIIllllIIIlIIIIl;
                this.motionY *= 0.800000011920929;
                this.motionZ *= lllllllllllllllIlIIllllIIIlIIIIl;
                this.motionY -= 0.02;
                if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579 - this.posY + lllllllllllllllIlIIllllIIIlIIllI, this.motionZ)) {
                    this.motionY = 0.30000001192092896;
                }
            }
            else if (this.func_180799_ab() && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).capabilities.isFlying)) {
                final double lllllllllllllllIlIIllllIIIlIIlIl = this.posY;
                this.moveFlying(lllllllllllllllIlIIllllIIIIlIlll, lllllllllllllllIlIIllllIIIlIIlll, 0.02f);
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= 0.5;
                this.motionY *= 0.5;
                this.motionZ *= 0.5;
                this.motionY -= 0.02;
                if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579 - this.posY + lllllllllllllllIlIIllllIIIlIIlIl, this.motionZ)) {
                    this.motionY = 0.30000001192092896;
                }
            }
            else {
                float lllllllllllllllIlIIllllIIIIlllII = 0.91f;
                if (this.onGround) {
                    lllllllllllllllIlIIllllIIIIlllII = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91f;
                }
                final float lllllllllllllllIlIIllllIIIIllIll = 0.16277136f / (lllllllllllllllIlIIllllIIIIlllII * lllllllllllllllIlIIllllIIIIlllII * lllllllllllllllIlIIllllIIIIlllII);
                float lllllllllllllllIlIIllllIIIIlllll = 0.0f;
                if (this.onGround) {
                    final float lllllllllllllllIlIIllllIIIlIIIII = this.getAIMoveSpeed() * lllllllllllllllIlIIllllIIIIllIll;
                }
                else {
                    lllllllllllllllIlIIllllIIIIlllll = this.jumpMovementFactor;
                }
                this.moveFlying(lllllllllllllllIlIIllllIIIIlIlll, lllllllllllllllIlIIllllIIIlIIlll, lllllllllllllllIlIIllllIIIIlllll);
                lllllllllllllllIlIIllllIIIIlllII = 0.91f;
                if (this.onGround) {
                    lllllllllllllllIlIIllllIIIIlllII = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91f;
                }
                if (this.isOnLadder()) {
                    final float lllllllllllllllIlIIllllIIIIlllIl = 0.15f;
                    this.motionX = MathHelper.clamp_double(this.motionX, -lllllllllllllllIlIIllllIIIIlllIl, lllllllllllllllIlIIllllIIIIlllIl);
                    this.motionZ = MathHelper.clamp_double(this.motionZ, -lllllllllllllllIlIIllllIIIIlllIl, lllllllllllllllIlIIllllIIIIlllIl);
                    this.fallDistance = 0.0f;
                    if (this.motionY < -0.15) {
                        this.motionY = -0.15;
                    }
                    final boolean lllllllllllllllIlIIllllIIIIllIlI = this.isSneaking() && this instanceof EntityPlayer;
                    if (lllllllllllllllIlIIllllIIIIllIlI && this.motionY < 0.0) {
                        this.motionY = 0.0;
                    }
                }
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                if (this.isCollidedHorizontally && this.isOnLadder()) {
                    this.motionY = 0.2;
                }
                if (this.worldObj.isRemote && (!this.worldObj.isBlockLoaded(new BlockPos((int)this.posX, 0, (int)this.posZ)) || !this.worldObj.getChunkFromBlockCoords(new BlockPos((int)this.posX, 0, (int)this.posZ)).isLoaded())) {
                    if (this.posY > 0.0) {
                        this.motionY = -0.1;
                    }
                    else {
                        this.motionY = 0.0;
                    }
                }
                else {
                    this.motionY -= 0.08;
                }
                this.motionY *= 0.9800000190734863;
                this.motionX *= lllllllllllllllIlIIllllIIIIlllII;
                this.motionZ *= lllllllllllllllIlIIllllIIIIlllII;
            }
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double lllllllllllllllIlIIllllIIIlIIlII = this.posX - this.prevPosX;
        final double lllllllllllllllIlIIllllIIIIllIIl = this.posZ - this.prevPosZ;
        float lllllllllllllllIlIIllllIIIlIIIlI = MathHelper.sqrt_double(lllllllllllllllIlIIllllIIIlIIlII * lllllllllllllllIlIIllllIIIlIIlII + lllllllllllllllIlIIllllIIIIllIIl * lllllllllllllllIlIIllllIIIIllIIl) * 4.0f;
        if (lllllllllllllllIlIIllllIIIlIIIlI > 1.0f) {
            lllllllllllllllIlIIllllIIIlIIIlI = 1.0f;
        }
        this.limbSwingAmount += (lllllllllllllllIlIIllllIIIlIIIlI - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }
    
    @Override
    public void mountEntity(final Entity lllllllllllllllIlIIlllIllIlIlIlI) {
        if (this.ridingEntity != null && lllllllllllllllIlIIlllIllIlIlIlI == null) {
            if (!this.worldObj.isRemote) {
                this.dismountEntity(this.ridingEntity);
            }
            if (this.ridingEntity != null) {
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = null;
        }
        else {
            super.mountEntity(lllllllllllllllIlIIlllIllIlIlIlI);
        }
    }
    
    public boolean isPlayerSleeping() {
        return false;
    }
    
    public void onLivingUpdate() {
        if (this.jumpTicks > 0) {
            --this.jumpTicks;
        }
        if (this.newPosRotationIncrements > 0) {
            final double lllllllllllllllIlIIlllIlllIIlIIl = this.posX + (this.newPosX - this.posX) / this.newPosRotationIncrements;
            final double lllllllllllllllIlIIlllIlllIIlIII = this.posY + (this.newPosY - this.posY) / this.newPosRotationIncrements;
            final double lllllllllllllllIlIIlllIlllIIIlll = this.posZ + (this.newPosZ - this.posZ) / this.newPosRotationIncrements;
            final double lllllllllllllllIlIIlllIlllIIIllI = MathHelper.wrapAngleTo180_double(this.newRotationYaw - this.rotationYaw);
            this.rotationYaw += (float)(lllllllllllllllIlIIlllIlllIIIllI / this.newPosRotationIncrements);
            this.rotationPitch += (float)((this.newRotationPitch - this.rotationPitch) / this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.setPosition(lllllllllllllllIlIIlllIlllIIlIIl, lllllllllllllllIlIIlllIlllIIlIII, lllllllllllllllIlIIlllIlllIIIlll);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        else if (!this.isServerWorld()) {
            this.motionX *= 0.98;
            this.motionY *= 0.98;
            this.motionZ *= 0.98;
        }
        if (Math.abs(this.motionX) < 0.005) {
            this.motionX = 0.0;
        }
        if (Math.abs(this.motionY) < 0.005) {
            this.motionY = 0.0;
        }
        if (Math.abs(this.motionZ) < 0.005) {
            this.motionZ = 0.0;
        }
        this.worldObj.theProfiler.startSection("ai");
        if (this.isMovementBlocked()) {
            this.isJumping = false;
            this.moveStrafing = 0.0f;
            this.moveForward = 0.0f;
            this.randomYawVelocity = 0.0f;
        }
        else if (this.isServerWorld()) {
            this.worldObj.theProfiler.startSection("newAi");
            this.updateEntityActionState();
            this.worldObj.theProfiler.endSection();
        }
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("jump");
        if (this.isJumping) {
            if (this.isInWater()) {
                this.updateAITick();
            }
            else if (this.func_180799_ab()) {
                this.func_180466_bG();
            }
            else if (this.onGround && this.jumpTicks == 0) {
                this.jump();
                this.jumpTicks = 10;
            }
        }
        else {
            this.jumpTicks = 0;
        }
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("travel");
        this.moveStrafing *= 0.98f;
        this.moveForward *= 0.98f;
        this.randomYawVelocity *= 0.9f;
        this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("push");
        if (!this.worldObj.isRemote) {
            this.collideWithNearbyEntities();
        }
        this.worldObj.theProfiler.endSection();
    }
    
    protected boolean isMovementBlocked() {
        return this.getHealth() <= 0.0f;
    }
    
    @Override
    protected void setBeenAttacked() {
        this.velocityChanged = (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue());
    }
    
    protected int decreaseAirSupply(final int lllllllllllllllIlIlIIIIlIlIIIlII) {
        final int lllllllllllllllIlIlIIIIlIlIIIIll = EnchantmentHelper.func_180319_a(this);
        return (lllllllllllllllIlIlIIIIlIlIIIIll > 0 && this.rand.nextInt(lllllllllllllllIlIlIIIIlIlIIIIll + 1) > 0) ? lllllllllllllllIlIlIIIIlIlIIIlII : (lllllllllllllllIlIlIIIIlIlIIIlII - 1);
    }
    
    public boolean isPotionActive(final int lllllllllllllllIlIlIIIIIlIlllIlI) {
        return this.activePotionsMap.containsKey(lllllllllllllllIlIlIIIIIlIlllIlI);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIlIIlllllllllIlIl, float lllllllllllllllIlIIlllllllllIlII) {
        if (this.func_180431_b(lllllllllllllllIlIIlllllllllIlIl)) {
            return false;
        }
        if (this.worldObj.isRemote) {
            return false;
        }
        this.entityAge = 0;
        if (this.getHealth() <= 0.0f) {
            return false;
        }
        if (lllllllllllllllIlIIlllllllllIlIl.isFireDamage() && this.isPotionActive(Potion.fireResistance)) {
            return false;
        }
        if ((lllllllllllllllIlIIlllllllllIlIl == DamageSource.anvil || lllllllllllllllIlIIlllllllllIlIl == DamageSource.fallingBlock) && this.getEquipmentInSlot(4) != null) {
            this.getEquipmentInSlot(4).damageItem((int)(lllllllllllllllIlIIlllllllllIlII * 4.0f + this.rand.nextFloat() * lllllllllllllllIlIIlllllllllIlII * 2.0f), this);
            lllllllllllllllIlIIlllllllllIlII *= 0.75f;
        }
        this.limbSwingAmount = 1.5f;
        boolean lllllllllllllllIlIlIIIIIIIIIIIIl = true;
        if (this.hurtResistantTime > this.maxHurtResistantTime / 2.0f) {
            if (lllllllllllllllIlIIlllllllllIlII <= this.lastDamage) {
                return false;
            }
            this.damageEntity(lllllllllllllllIlIIlllllllllIlIl, lllllllllllllllIlIIlllllllllIlII - this.lastDamage);
            this.lastDamage = lllllllllllllllIlIIlllllllllIlII;
            lllllllllllllllIlIlIIIIIIIIIIIIl = false;
        }
        else {
            this.lastDamage = lllllllllllllllIlIIlllllllllIlII;
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.damageEntity(lllllllllllllllIlIIlllllllllIlIl, lllllllllllllllIlIIlllllllllIlII);
            final int n = 10;
            this.maxHurtTime = n;
            this.hurtTime = n;
        }
        this.attackedAtYaw = 0.0f;
        final Entity lllllllllllllllIlIIlllllllllllll = lllllllllllllllIlIIlllllllllIlIl.getEntity();
        if (lllllllllllllllIlIIlllllllllllll != null) {
            if (lllllllllllllllIlIIlllllllllllll instanceof EntityLivingBase) {
                this.setRevengeTarget((EntityLivingBase)lllllllllllllllIlIIlllllllllllll);
            }
            if (lllllllllllllllIlIIlllllllllllll instanceof EntityPlayer) {
                this.recentlyHit = 100;
                this.attackingPlayer = (EntityPlayer)lllllllllllllllIlIIlllllllllllll;
            }
            else if (lllllllllllllllIlIIlllllllllllll instanceof EntityWolf) {
                final EntityWolf lllllllllllllllIlIIlllllllllllIl = (EntityWolf)lllllllllllllllIlIIlllllllllllll;
                if (lllllllllllllllIlIIlllllllllllIl.isTamed()) {
                    this.recentlyHit = 100;
                    this.attackingPlayer = null;
                }
            }
        }
        if (lllllllllllllllIlIlIIIIIIIIIIIIl) {
            this.worldObj.setEntityState(this, (byte)2);
            if (lllllllllllllllIlIIlllllllllIlIl != DamageSource.drown) {
                this.setBeenAttacked();
            }
            if (lllllllllllllllIlIIlllllllllllll != null) {
                double lllllllllllllllIlIIllllllllllIll;
                double lllllllllllllllIlIIllllllllllIIl;
                for (lllllllllllllllIlIIllllllllllIll = lllllllllllllllIlIIlllllllllllll.posX - this.posX, lllllllllllllllIlIIllllllllllIIl = lllllllllllllllIlIIlllllllllllll.posZ - this.posZ; lllllllllllllllIlIIllllllllllIll * lllllllllllllllIlIIllllllllllIll + lllllllllllllllIlIIllllllllllIIl * lllllllllllllllIlIIllllllllllIIl < 1.0E-4; lllllllllllllllIlIIllllllllllIll = (Math.random() - Math.random()) * 0.01, lllllllllllllllIlIIllllllllllIIl = (Math.random() - Math.random()) * 0.01) {}
                this.attackedAtYaw = (float)(Math.atan2(lllllllllllllllIlIIllllllllllIIl, lllllllllllllllIlIIllllllllllIll) * 180.0 / 3.141592653589793 - this.rotationYaw);
                this.knockBack(lllllllllllllllIlIIlllllllllllll, lllllllllllllllIlIIlllllllllIlII, lllllllllllllllIlIIllllllllllIll, lllllllllllllllIlIIllllllllllIIl);
            }
            else {
                this.attackedAtYaw = (float)((int)(Math.random() * 2.0) * 180);
            }
        }
        if (this.getHealth() <= 0.0f) {
            final String lllllllllllllllIlIIllllllllllIII = this.getDeathSound();
            if (lllllllllllllllIlIlIIIIIIIIIIIIl && lllllllllllllllIlIIllllllllllIII != null) {
                this.playSound(lllllllllllllllIlIIllllllllllIII, this.getSoundVolume(), this.getSoundPitch());
            }
            this.onDeath(lllllllllllllllIlIIlllllllllIlIl);
        }
        else {
            final String lllllllllllllllIlIIlllllllllIlll = this.getHurtSound();
            if (lllllllllllllllIlIlIIIIIIIIIIIIl && lllllllllllllllIlIIlllllllllIlll != null) {
                this.playSound(lllllllllllllllIlIIlllllllllIlll, this.getSoundVolume(), this.getSoundPitch());
            }
        }
        return true;
    }
    
    public CombatTracker getCombatTracker() {
        return this._combatTracker;
    }
    
    protected float getSoundVolume() {
        return 1.0f;
    }
    
    public BaseAttributeMap getAttributeMap() {
        if (this.attributeMap == null) {
            this.attributeMap = new ServersideAttributeMap();
        }
        return this.attributeMap;
    }
    
    @Override
    public void func_174812_G() {
        this.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
    }
    
    protected void damageEntity(final DamageSource lllllllllllllllIlIIllllIlIllIIII, float lllllllllllllllIlIIllllIlIlIllll) {
        if (!this.func_180431_b(lllllllllllllllIlIIllllIlIllIIII)) {
            lllllllllllllllIlIIllllIlIlIllll = this.applyArmorCalculations(lllllllllllllllIlIIllllIlIllIIII, lllllllllllllllIlIIllllIlIlIllll);
            final float lllllllllllllllIlIIllllIlIlIlllI;
            lllllllllllllllIlIIllllIlIlIllll = (lllllllllllllllIlIIllllIlIlIlllI = this.applyPotionDamageCalculations(lllllllllllllllIlIIllllIlIllIIII, lllllllllllllllIlIIllllIlIlIllll));
            lllllllllllllllIlIIllllIlIlIllll = Math.max(lllllllllllllllIlIIllllIlIlIllll - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (lllllllllllllllIlIIllllIlIlIlllI - lllllllllllllllIlIIllllIlIlIllll));
            if (lllllllllllllllIlIIllllIlIlIllll != 0.0f) {
                final float lllllllllllllllIlIIllllIlIlIllIl = this.getHealth();
                this.setHealth(lllllllllllllllIlIIllllIlIlIllIl - lllllllllllllllIlIIllllIlIlIllll);
                this.getCombatTracker().func_94547_a(lllllllllllllllIlIIllllIlIllIIII, lllllllllllllllIlIIllllIlIlIllIl, lllllllllllllllIlIIllllIlIlIllll);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - lllllllllllllllIlIIllllIlIlIllll);
            }
        }
    }
    
    @Override
    public boolean canBePushed() {
        return !this.isDead;
    }
    
    public boolean canBreatheUnderwater() {
        return false;
    }
    
    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return false;
    }
    
    public void onItemPickup(final Entity lllllllllllllllIlIIlllIllIIIIlII, final int lllllllllllllllIlIIlllIllIIIIIll) {
        if (!lllllllllllllllIlIIlllIllIIIIlII.isDead && !this.worldObj.isRemote) {
            final EntityTracker lllllllllllllllIlIIlllIllIIIIIlI = ((WorldServer)this.worldObj).getEntityTracker();
            if (lllllllllllllllIlIIlllIllIIIIlII instanceof EntityItem) {
                lllllllllllllllIlIIlllIllIIIIIlI.sendToAllTrackingEntity(lllllllllllllllIlIIlllIllIIIIlII, new S0DPacketCollectItem(lllllllllllllllIlIIlllIllIIIIlII.getEntityId(), this.getEntityId()));
            }
            if (lllllllllllllllIlIIlllIllIIIIlII instanceof EntityArrow) {
                lllllllllllllllIlIIlllIllIIIIIlI.sendToAllTrackingEntity(lllllllllllllllIlIIlllIllIIIIlII, new S0DPacketCollectItem(lllllllllllllllIlIIlllIllIIIIlII.getEntityId(), this.getEntityId()));
            }
            if (lllllllllllllllIlIIlllIllIIIIlII instanceof EntityXPOrb) {
                lllllllllllllllIlIIlllIllIIIIIlI.sendToAllTrackingEntity(lllllllllllllllIlIIlllIllIIIIlII, new S0DPacketCollectItem(lllllllllllllllIlIIlllIllIIIIlII.getEntityId(), this.getEntityId()));
            }
        }
    }
    
    protected void updatePotionEffects() {
        final Iterator lllllllllllllllIlIlIIIIIlllIIllI = this.activePotionsMap.keySet().iterator();
        while (lllllllllllllllIlIlIIIIIlllIIllI.hasNext()) {
            final Integer lllllllllllllllIlIlIIIIIlllIIlIl = lllllllllllllllIlIlIIIIIlllIIllI.next();
            final PotionEffect lllllllllllllllIlIlIIIIIlllIIlII = this.activePotionsMap.get(lllllllllllllllIlIlIIIIIlllIIlIl);
            if (!lllllllllllllllIlIlIIIIIlllIIlII.onUpdate(this)) {
                if (this.worldObj.isRemote) {
                    continue;
                }
                lllllllllllllllIlIlIIIIIlllIIllI.remove();
                this.onFinishedPotionEffect(lllllllllllllllIlIlIIIIIlllIIlII);
            }
            else {
                if (lllllllllllllllIlIlIIIIIlllIIlII.getDuration() % 600 != 0) {
                    continue;
                }
                this.onChangedPotionEffect(lllllllllllllllIlIlIIIIIlllIIlII, false);
            }
        }
        if (this.potionsNeedUpdate) {
            if (!this.worldObj.isRemote) {
                this.func_175135_B();
            }
            this.potionsNeedUpdate = false;
        }
        final int lllllllllllllllIlIlIIIIIlllIIIll = this.dataWatcher.getWatchableObjectInt(7);
        final boolean lllllllllllllllIlIlIIIIIlllIIIlI = this.dataWatcher.getWatchableObjectByte(8) > 0;
        if (lllllllllllllllIlIlIIIIIlllIIIll > 0) {
            boolean lllllllllllllllIlIlIIIIIlllIIIIl = false;
            if (!this.isInvisible()) {
                lllllllllllllllIlIlIIIIIlllIIIIl = this.rand.nextBoolean();
            }
            else {
                lllllllllllllllIlIlIIIIIlllIIIIl = (this.rand.nextInt(15) == 0);
            }
            if (lllllllllllllllIlIlIIIIIlllIIIlI) {
                lllllllllllllllIlIlIIIIIlllIIIIl &= (this.rand.nextInt(5) == 0);
            }
            if (lllllllllllllllIlIlIIIIIlllIIIIl && lllllllllllllllIlIlIIIIIlllIIIll > 0) {
                final double lllllllllllllllIlIlIIIIIlllIIIII = (lllllllllllllllIlIlIIIIIlllIIIll >> 16 & 0xFF) / 255.0;
                final double lllllllllllllllIlIlIIIIIllIlllll = (lllllllllllllllIlIlIIIIIlllIIIll >> 8 & 0xFF) / 255.0;
                final double lllllllllllllllIlIlIIIIIllIllllI = (lllllllllllllllIlIlIIIIIlllIIIll >> 0 & 0xFF) / 255.0;
                this.worldObj.spawnParticle(lllllllllllllllIlIlIIIIIlllIIIlI ? EnumParticleTypes.SPELL_MOB_AMBIENT : EnumParticleTypes.SPELL_MOB, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, lllllllllllllllIlIlIIIIIlllIIIII, lllllllllllllllIlIlIIIIIllIlllll, lllllllllllllllIlIlIIIIIllIllllI, new int[0]);
            }
        }
    }
    
    protected void func_175135_B() {
        if (this.activePotionsMap.isEmpty()) {
            this.func_175133_bi();
            this.setInvisible(false);
        }
        else {
            final int lllllllllllllllIlIlIIIIIllIlIIlI = PotionHelper.calcPotionLiquidColor(this.activePotionsMap.values());
            this.dataWatcher.updateObject(8, (byte)(byte)(PotionHelper.func_82817_b(this.activePotionsMap.values()) ? 1 : 0));
            this.dataWatcher.updateObject(7, lllllllllllllllIlIlIIIIIllIlIIlI);
            this.setInvisible(this.isPotionActive(Potion.invisibility.id));
        }
    }
    
    @Override
    public boolean isEntityAlive() {
        return !this.isDead && this.getHealth() > 0.0f;
    }
    
    protected void jump() {
        this.motionY = this.func_175134_bD();
        if (this.isPotionActive(Potion.jump)) {
            this.motionY += (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1f;
        }
        if (this.isSprinting()) {
            final float lllllllllllllllIlIIllllIIIllllII = this.rotationYaw * 0.017453292f;
            this.motionX -= MathHelper.sin(lllllllllllllllIlIIllllIIIllllII) * 0.2f;
            this.motionZ += MathHelper.cos(lllllllllllllllIlIIllllIIIllllII) * 0.2f;
        }
        this.isAirBorne = true;
    }
    
    public boolean attackEntityAsMob(final Entity lllllllllllllllIlIIllllIIIIIIIII) {
        this.setLastAttacker(lllllllllllllllIlIIllllIIIIIIIII);
        return false;
    }
    
    protected boolean func_146066_aG() {
        return !this.isChild();
    }
    
    protected void onChangedPotionEffect(final PotionEffect lllllllllllllllIlIlIIIIIIllIlIII, final boolean lllllllllllllllIlIlIIIIIIllIIlII) {
        this.potionsNeedUpdate = true;
        if (lllllllllllllllIlIlIIIIIIllIIlII && !this.worldObj.isRemote) {
            Potion.potionTypes[lllllllllllllllIlIlIIIIIIllIlIII.getPotionID()].removeAttributesModifiersFromEntity(this, this.getAttributeMap(), lllllllllllllllIlIlIIIIIIllIlIII.getAmplifier());
            Potion.potionTypes[lllllllllllllllIlIlIIIIIIllIlIII.getPotionID()].applyAttributesModifiersToEntity(this, this.getAttributeMap(), lllllllllllllllIlIlIIIIIIllIlIII.getAmplifier());
        }
    }
    
    public boolean isOnLadder() {
        final int lllllllllllllllIlIIlllllIllIIIlI = MathHelper.floor_double(this.posX);
        final int lllllllllllllllIlIIlllllIllIIIII = MathHelper.floor_double(this.getEntityBoundingBox().minY);
        final int lllllllllllllllIlIIlllllIlIllllI = MathHelper.floor_double(this.posZ);
        final Block lllllllllllllllIlIIlllllIlIlllII = this.worldObj.getBlockState(new BlockPos(lllllllllllllllIlIIlllllIllIIIlI, lllllllllllllllIlIIlllllIllIIIII, lllllllllllllllIlIIlllllIlIllllI)).getBlock();
        return (lllllllllllllllIlIIlllllIlIlllII == Blocks.ladder || lllllllllllllllIlIIlllllIlIlllII == Blocks.vine) && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).func_175149_v());
    }
    
    public abstract ItemStack getEquipmentInSlot(final int p0);
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    public PotionEffect getActivePotionEffect(final Potion lllllllllllllllIlIlIIIIIlIlIlllI) {
        return this.activePotionsMap.get(lllllllllllllllIlIlIIIIIlIlIlllI.id);
    }
    
    public void func_152111_bt() {
    }
    
    public void addPotionEffect(final PotionEffect lllllllllllllllIlIlIIIIIlIlIIllI) {
        if (this.isPotionApplicable(lllllllllllllllIlIlIIIIIlIlIIllI)) {
            if (this.activePotionsMap.containsKey(lllllllllllllllIlIlIIIIIlIlIIllI.getPotionID())) {
                this.activePotionsMap.get(lllllllllllllllIlIlIIIIIlIlIIllI.getPotionID()).combine(lllllllllllllllIlIlIIIIIlIlIIllI);
                this.onChangedPotionEffect(this.activePotionsMap.get(lllllllllllllllIlIlIIIIIlIlIIllI.getPotionID()), true);
            }
            else {
                this.activePotionsMap.put(lllllllllllllllIlIlIIIIIlIlIIllI.getPotionID(), lllllllllllllllIlIlIIIIIlIlIIllI);
                this.onNewPotionEffect(lllllllllllllllIlIlIIIIIlIlIIllI);
            }
        }
    }
    
    @Override
    public void setRotationYawHead(final float lllllllllllllllIlIIlllIlIlIIlllI) {
        this.rotationYawHead = lllllllllllllllIlIIlllIlIlIIlllI;
    }
    
    protected String getHurtSound() {
        return "game.neutral.hurt";
    }
    
    @Override
    public Vec3 getLook(final float lllllllllllllllIlIIlllIlIllIllII) {
        if (lllllllllllllllIlIIlllIlIllIllII == 1.0f) {
            return this.func_174806_f(this.rotationPitch, this.rotationYawHead);
        }
        final float lllllllllllllllIlIIlllIlIllIllll = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * lllllllllllllllIlIIlllIlIllIllII;
        final float lllllllllllllllIlIIlllIlIllIlllI = this.prevRotationYawHead + (this.rotationYawHead - this.prevRotationYawHead) * lllllllllllllllIlIIlllIlIllIllII;
        return this.func_174806_f(lllllllllllllllIlIIlllIlIllIllll, lllllllllllllllIlIIlllIlIllIlllI);
    }
    
    public void dismountEntity(final Entity lllllllllllllllIlIIllllIIlIlIllI) {
        double lllllllllllllllIlIIllllIIlIlIlIl = lllllllllllllllIlIIllllIIlIlIllI.posX;
        double lllllllllllllllIlIIllllIIlIlIlII = lllllllllllllllIlIIllllIIlIlIllI.getEntityBoundingBox().minY + lllllllllllllllIlIIllllIIlIlIllI.height;
        double lllllllllllllllIlIIllllIIlIlIIll = lllllllllllllllIlIIllllIIlIlIllI.posZ;
        final byte lllllllllllllllIlIIllllIIlIlIIlI = 1;
        for (int lllllllllllllllIlIIllllIIlIlIIIl = -lllllllllllllllIlIIllllIIlIlIIlI; lllllllllllllllIlIIllllIIlIlIIIl <= lllllllllllllllIlIIllllIIlIlIIlI; ++lllllllllllllllIlIIllllIIlIlIIIl) {
            for (int lllllllllllllllIlIIllllIIlIlIIII = -lllllllllllllllIlIIllllIIlIlIIlI; lllllllllllllllIlIIllllIIlIlIIII < lllllllllllllllIlIIllllIIlIlIIlI; ++lllllllllllllllIlIIllllIIlIlIIII) {
                if (lllllllllllllllIlIIllllIIlIlIIIl != 0 || lllllllllllllllIlIIllllIIlIlIIII != 0) {
                    final int lllllllllllllllIlIIllllIIlIIllll = (int)(this.posX + lllllllllllllllIlIIllllIIlIlIIIl);
                    final int lllllllllllllllIlIIllllIIlIIlllI = (int)(this.posZ + lllllllllllllllIlIIllllIIlIlIIII);
                    final AxisAlignedBB lllllllllllllllIlIIllllIIlIIllIl = this.getEntityBoundingBox().offset(lllllllllllllllIlIIllllIIlIlIIIl, 1.0, lllllllllllllllIlIIllllIIlIlIIII);
                    if (this.worldObj.func_147461_a(lllllllllllllllIlIIllllIIlIIllIl).isEmpty()) {
                        if (World.doesBlockHaveSolidTopSurface(this.worldObj, new BlockPos(lllllllllllllllIlIIllllIIlIIllll, (int)this.posY, lllllllllllllllIlIIllllIIlIIlllI))) {
                            this.setPositionAndUpdate(this.posX + lllllllllllllllIlIIllllIIlIlIIIl, this.posY + 1.0, this.posZ + lllllllllllllllIlIIllllIIlIlIIII);
                            return;
                        }
                        if (World.doesBlockHaveSolidTopSurface(this.worldObj, new BlockPos(lllllllllllllllIlIIllllIIlIIllll, (int)this.posY - 1, lllllllllllllllIlIIllllIIlIIlllI)) || this.worldObj.getBlockState(new BlockPos(lllllllllllllllIlIIllllIIlIIllll, (int)this.posY - 1, lllllllllllllllIlIIllllIIlIIlllI)).getBlock().getMaterial() == Material.water) {
                            lllllllllllllllIlIIllllIIlIlIlIl = this.posX + lllllllllllllllIlIIllllIIlIlIIIl;
                            lllllllllllllllIlIIllllIIlIlIlII = this.posY + 1.0;
                            lllllllllllllllIlIIllllIIlIlIIll = this.posZ + lllllllllllllllIlIIllllIIlIlIIII;
                        }
                    }
                }
            }
        }
        this.setPositionAndUpdate(lllllllllllllllIlIIllllIIlIlIlIl, lllllllllllllllIlIIllllIIlIlIlII, lllllllllllllllIlIIllllIIlIlIIll);
    }
    
    protected float applyPotionDamageCalculations(final DamageSource lllllllllllllllIlIIllllIlIlllIll, float lllllllllllllllIlIIllllIlIlllIlI) {
        if (lllllllllllllllIlIIllllIlIlllIll.isDamageAbsolute()) {
            return lllllllllllllllIlIIllllIlIlllIlI;
        }
        if (this.isPotionActive(Potion.resistance) && lllllllllllllllIlIIllllIlIlllIll != DamageSource.outOfWorld) {
            final int lllllllllllllllIlIIllllIllIIIIlI = (this.getActivePotionEffect(Potion.resistance).getAmplifier() + 1) * 5;
            final int lllllllllllllllIlIIllllIllIIIIII = 25 - lllllllllllllllIlIIllllIllIIIIlI;
            final float lllllllllllllllIlIIllllIlIlllllI = lllllllllllllllIlIIllllIlIlllIlI * lllllllllllllllIlIIllllIllIIIIII;
            lllllllllllllllIlIIllllIlIlllIlI = lllllllllllllllIlIIllllIlIlllllI / 25.0f;
        }
        if (lllllllllllllllIlIIllllIlIlllIlI <= 0.0f) {
            return 0.0f;
        }
        int lllllllllllllllIlIIllllIllIIIIIl = EnchantmentHelper.getEnchantmentModifierDamage(this.getInventory(), lllllllllllllllIlIIllllIlIlllIll);
        if (lllllllllllllllIlIIllllIllIIIIIl > 20) {
            lllllllllllllllIlIIllllIllIIIIIl = 20;
        }
        if (lllllllllllllllIlIIllllIllIIIIIl > 0 && lllllllllllllllIlIIllllIllIIIIIl <= 20) {
            final int lllllllllllllllIlIIllllIlIllllll = 25 - lllllllllllllllIlIIllllIllIIIIIl;
            final float lllllllllllllllIlIIllllIlIllllIl = lllllllllllllllIlIIllllIlIlllIlI * lllllllllllllllIlIIllllIlIllllll;
            lllllllllllllllIlIIllllIlIlllIlI = lllllllllllllllIlIIllllIlIllllIl / 25.0f;
        }
        return lllllllllllllllIlIIllllIlIlllIlI;
    }
    
    public EntityLivingBase getLastAttacker() {
        return this.lastAttacker;
    }
    
    public void setJumping(final boolean lllllllllllllllIlIIlllIllIIIlIIl) {
        this.isJumping = lllllllllllllllIlIIlllIllIIIlIIl;
    }
    
    protected void dropFewItems(final boolean lllllllllllllllIlIIlllllIllllllI, final int lllllllllllllllIlIIlllllIlllllII) {
    }
    
    @Override
    public void handleHealthUpdate(final byte lllllllllllllllIlIIllllIlIIIlIll) {
        if (lllllllllllllllIlIIllllIlIIIlIll == 2) {
            this.limbSwingAmount = 1.5f;
            this.hurtResistantTime = this.maxHurtResistantTime;
            final int n = 10;
            this.maxHurtTime = n;
            this.hurtTime = n;
            this.attackedAtYaw = 0.0f;
            final String lllllllllllllllIlIIllllIlIIIlIlI = this.getHurtSound();
            if (lllllllllllllllIlIIllllIlIIIlIlI != null) {
                this.playSound(this.getHurtSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.attackEntityFrom(DamageSource.generic, 0.0f);
        }
        else if (lllllllllllllllIlIIllllIlIIIlIll == 3) {
            final String lllllllllllllllIlIIllllIlIIIlIIl = this.getDeathSound();
            if (lllllllllllllllIlIIllllIlIIIlIIl != null) {
                this.playSound(this.getDeathSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.setHealth(0.0f);
            this.onDeath(DamageSource.generic);
        }
        else {
            super.handleHealthUpdate(lllllllllllllllIlIIllllIlIIIlIll);
        }
    }
    
    public EntityLivingBase func_94060_bK() {
        return (this._combatTracker.func_94550_c() != null) ? this._combatTracker.func_94550_c() : ((this.attackingPlayer != null) ? this.attackingPlayer : ((this.entityLivingToAttack != null) ? this.entityLivingToAttack : null));
    }
    
    protected float func_110146_f(final float lllllllllllllllIlIIlllIlllIllIlI, float lllllllllllllllIlIIlllIlllIlIIll) {
        final float lllllllllllllllIlIIlllIlllIllIII = MathHelper.wrapAngleTo180_float(lllllllllllllllIlIIlllIlllIllIlI - this.renderYawOffset);
        this.renderYawOffset += lllllllllllllllIlIIlllIlllIllIII * 0.3f;
        float lllllllllllllllIlIIlllIlllIlIlll = MathHelper.wrapAngleTo180_float(this.rotationYaw - this.renderYawOffset);
        final boolean lllllllllllllllIlIIlllIlllIlIllI = lllllllllllllllIlIIlllIlllIlIlll < -90.0f || lllllllllllllllIlIIlllIlllIlIlll >= 90.0f;
        if (lllllllllllllllIlIIlllIlllIlIlll < -75.0f) {
            lllllllllllllllIlIIlllIlllIlIlll = -75.0f;
        }
        if (lllllllllllllllIlIIlllIlllIlIlll >= 75.0f) {
            lllllllllllllllIlIIlllIlllIlIlll = 75.0f;
        }
        this.renderYawOffset = this.rotationYaw - lllllllllllllllIlIIlllIlllIlIlll;
        if (lllllllllllllllIlIIlllIlllIlIlll * lllllllllllllllIlIIlllIlllIlIlll > 2500.0f) {
            this.renderYawOffset += lllllllllllllllIlIIlllIlllIlIlll * 0.2f;
        }
        if (lllllllllllllllIlIIlllIlllIlIllI) {
            lllllllllllllllIlIIlllIlllIlIIll *= -1.0f;
        }
        return lllllllllllllllIlIIlllIlllIlIIll;
    }
    
    @Override
    public void func_180426_a(final double lllllllllllllllIlIIlllIllIIlllII, final double lllllllllllllllIlIIlllIllIIllIll, final double lllllllllllllllIlIIlllIllIIllIlI, final float lllllllllllllllIlIIlllIllIIllIIl, final float lllllllllllllllIlIIlllIllIIlIIII, final int lllllllllllllllIlIIlllIllIIIllll, final boolean lllllllllllllllIlIIlllIllIIlIllI) {
        this.newPosX = lllllllllllllllIlIIlllIllIIlllII;
        this.newPosY = lllllllllllllllIlIIlllIllIIllIll;
        this.newPosZ = lllllllllllllllIlIIlllIllIIllIlI;
        this.newRotationYaw = lllllllllllllllIlIIlllIllIIllIIl;
        this.newRotationPitch = lllllllllllllllIlIIlllIllIIlIIII;
        this.newPosRotationIncrements = lllllllllllllllIlIIlllIllIIIllll;
    }
    
    public EntityLivingBase(final World lllllllllllllllIlIlIIIIlllIIlIll) {
        super(lllllllllllllllIlIlIIIIlllIIlIll);
        this._combatTracker = new CombatTracker(this);
        this.activePotionsMap = Maps.newHashMap();
        this.previousEquipment = new ItemStack[5];
        this.maxHurtResistantTime = 20;
        this.jumpMovementFactor = 0.02f;
        this.potionsNeedUpdate = true;
        this.applyEntityAttributes();
        this.setHealth(this.getMaxHealth());
        this.preventEntitySpawning = true;
        this.field_70770_ap = (float)((Math.random() + 1.0) * 0.009999999776482582);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.field_70769_ao = (float)Math.random() * 12398.0f;
        this.rotationYaw = (float)(Math.random() * 3.141592653589793 * 2.0);
        this.rotationYawHead = this.rotationYaw;
        this.stepHeight = 0.6f;
    }
    
    public abstract ItemStack getCurrentArmor(final int p0);
    
    public int getTotalArmorValue() {
        int lllllllllllllllIlIIllllIlllIllIl = 0;
        for (final ItemStack lllllllllllllllIlIIllllIlllIIlll : this.getInventory()) {
            if (lllllllllllllllIlIIllllIlllIIlll != null && lllllllllllllllIlIIllllIlllIIlll.getItem() instanceof ItemArmor) {
                final int lllllllllllllllIlIIllllIlllIIllI = ((ItemArmor)lllllllllllllllIlIIllllIlllIIlll.getItem()).damageReduceAmount;
                lllllllllllllllIlIIllllIlllIllIl += lllllllllllllllIlIIllllIlllIIllI;
            }
        }
        return lllllllllllllllIlIIllllIlllIllIl;
    }
    
    @Override
    protected void kill() {
        this.attackEntityFrom(DamageSource.outOfWorld, 4.0f);
    }
    
    @Override
    public void updateRidden() {
        super.updateRidden();
        this.field_70768_au = this.field_110154_aX;
        this.field_110154_aX = 0.0f;
        this.fallDistance = 0.0f;
    }
    
    protected void updateEntityActionState() {
    }
    
    protected void onNewPotionEffect(final PotionEffect lllllllllllllllIlIlIIIIIIllIllIl) {
        this.potionsNeedUpdate = true;
        if (!this.worldObj.isRemote) {
            Potion.potionTypes[lllllllllllllllIlIlIIIIIIllIllIl.getPotionID()].applyAttributesModifiersToEntity(this, this.getAttributeMap(), lllllllllllllllIlIlIIIIIIllIllIl.getAmplifier());
        }
    }
    
    public void setRevengeTarget(final EntityLivingBase lllllllllllllllIlIlIIIIlIIlIlllI) {
        this.entityLivingToAttack = lllllllllllllllIlIlIIIIlIIlIlllI;
        this.revengeTimer = this.ticksExisted;
    }
    
    protected float applyArmorCalculations(final DamageSource lllllllllllllllIlIIllllIllIlIlII, float lllllllllllllllIlIIllllIllIIlllI) {
        if (!lllllllllllllllIlIIllllIllIlIlII.isUnblockable()) {
            final int lllllllllllllllIlIIllllIllIlIIlI = 25 - this.getTotalArmorValue();
            final float lllllllllllllllIlIIllllIllIlIIIl = lllllllllllllllIlIIllllIllIIlllI * lllllllllllllllIlIIllllIllIlIIlI;
            this.damageArmor(lllllllllllllllIlIIllllIllIIlllI);
            lllllllllllllllIlIIllllIllIIlllI = lllllllllllllllIlIIllllIllIlIIIl / 25.0f;
        }
        return lllllllllllllllIlIIllllIllIIlllI;
    }
    
    protected void addRandomArmor() {
    }
    
    public void renderBrokenItemStack(final ItemStack lllllllllllllllIlIIlllllllIllllI) {
        this.playSound("random.break", 0.8f, 0.8f + this.worldObj.rand.nextFloat() * 0.4f);
        for (int lllllllllllllllIlIIlllllllIlllII = 0; lllllllllllllllIlIIlllllllIlllII < 5; ++lllllllllllllllIlIIlllllllIlllII) {
            Vec3 lllllllllllllllIlIIlllllllIllIlI = new Vec3((this.rand.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
            lllllllllllllllIlIIlllllllIllIlI = lllllllllllllllIlIIlllllllIllIlI.rotatePitch(-this.rotationPitch * 3.1415927f / 180.0f);
            lllllllllllllllIlIIlllllllIllIlI = lllllllllllllllIlIIlllllllIllIlI.rotateYaw(-this.rotationYaw * 3.1415927f / 180.0f);
            final double lllllllllllllllIlIIlllllllIllIII = -this.rand.nextFloat() * 0.6 - 0.3;
            Vec3 lllllllllllllllIlIIlllllllIlIllI = new Vec3((this.rand.nextFloat() - 0.5) * 0.3, lllllllllllllllIlIIlllllllIllIII, 0.6);
            lllllllllllllllIlIIlllllllIlIllI = lllllllllllllllIlIIlllllllIlIllI.rotatePitch(-this.rotationPitch * 3.1415927f / 180.0f);
            lllllllllllllllIlIIlllllllIlIllI = lllllllllllllllIlIIlllllllIlIllI.rotateYaw(-this.rotationYaw * 3.1415927f / 180.0f);
            lllllllllllllllIlIIlllllllIlIllI = lllllllllllllllIlIIlllllllIlIllI.addVector(this.posX, this.posY + this.getEyeHeight(), this.posZ);
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, lllllllllllllllIlIIlllllllIlIllI.xCoord, lllllllllllllllIlIIlllllllIlIllI.yCoord, lllllllllllllllIlIIlllllllIlIllI.zCoord, lllllllllllllllIlIIlllllllIllIlI.xCoord, lllllllllllllllIlIIlllllllIllIlI.yCoord + 0.05, lllllllllllllllIlIIlllllllIllIlI.zCoord, Item.getIdFromItem(lllllllllllllllIlIIlllllllIllllI.getItem()));
        }
    }
    
    public IAttributeInstance getEntityAttribute(final IAttribute lllllllllllllllIlIIllllIIllllIIl) {
        return this.getAttributeMap().getAttributeInstance(lllllllllllllllIlIIllllIIllllIIl);
    }
    
    @Override
    public void setSprinting(final boolean lllllllllllllllIlIIllllIIllIlIll) {
        super.setSprinting(lllllllllllllllIlIIllllIIllIlIll);
        final IAttributeInstance lllllllllllllllIlIIllllIIllIllIl = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
        if (lllllllllllllllIlIIllllIIllIllIl.getModifier(EntityLivingBase.sprintingSpeedBoostModifierUUID) != null) {
            lllllllllllllllIlIIllllIIllIllIl.removeModifier(EntityLivingBase.sprintingSpeedBoostModifier);
        }
        if (lllllllllllllllIlIIllllIIllIlIll) {
            lllllllllllllllIlIIllllIIllIllIl.applyModifier(EntityLivingBase.sprintingSpeedBoostModifier);
        }
    }
    
    public void setHealth(final float lllllllllllllllIlIlIIIIIIIlllIIl) {
        this.dataWatcher.updateObject(6, MathHelper.clamp_float(lllllllllllllllIlIlIIIIIIIlllIIl, 0.0f, this.getMaxHealth()));
    }
    
    protected float func_175134_bD() {
        return 0.42f;
    }
    
    public boolean canEntityBeSeen(final Entity lllllllllllllllIlIIlllIlIllllIll) {
        return this.worldObj.rayTraceBlocks(new Vec3(this.posX, this.posY + this.getEyeHeight(), this.posZ), new Vec3(lllllllllllllllIlIIlllIlIllllIll.posX, lllllllllllllllIlIIlllIlIllllIll.posY + lllllllllllllllIlIIlllIlIllllIll.getEyeHeight(), lllllllllllllllIlIIlllIlIllllIll.posZ)) == null;
    }
    
    public final float getMaxHealth() {
        return (float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
    }
    
    protected void onFinishedPotionEffect(final PotionEffect lllllllllllllllIlIlIIIIIIllIIIII) {
        this.potionsNeedUpdate = true;
        if (!this.worldObj.isRemote) {
            Potion.potionTypes[lllllllllllllllIlIlIIIIIIllIIIII.getPotionID()].removeAttributesModifiersFromEntity(this, this.getAttributeMap(), lllllllllllllllIlIlIIIIIIllIIIII.getAmplifier());
        }
    }
    
    protected void damageArmor(final float lllllllllllllllIlIIllllIllIllIll) {
    }
    
    public float getAIMoveSpeed() {
        return this.landMovementFactor;
    }
    
    protected void onDeathUpdate() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            if (!this.worldObj.isRemote && (this.recentlyHit > 0 || this.isPlayer()) && this.func_146066_aG() && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                int lllllllllllllllIlIlIIIIlIlIlIllI = this.getExperiencePoints(this.attackingPlayer);
                while (lllllllllllllllIlIlIIIIlIlIlIllI > 0) {
                    final int lllllllllllllllIlIlIIIIlIlIlIlII = EntityXPOrb.getXPSplit(lllllllllllllllIlIlIIIIlIlIlIllI);
                    lllllllllllllllIlIlIIIIlIlIlIllI -= lllllllllllllllIlIlIIIIlIlIlIlII;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, lllllllllllllllIlIlIIIIlIlIlIlII));
                }
            }
            this.setDead();
            for (int lllllllllllllllIlIlIIIIlIlIlIlIl = 0; lllllllllllllllIlIlIIIIlIlIlIlIl < 20; ++lllllllllllllllIlIlIIIIlIlIlIlIl) {
                final double lllllllllllllllIlIlIIIIlIlIlIIll = this.rand.nextGaussian() * 0.02;
                final double lllllllllllllllIlIlIIIIlIlIlIIlI = this.rand.nextGaussian() * 0.02;
                final double lllllllllllllllIlIlIIIIlIlIlIIIl = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, lllllllllllllllIlIlIIIIlIlIlIIll, lllllllllllllllIlIlIIIIlIlIlIIlI, lllllllllllllllIlIlIIIIlIlIlIIIl, new int[0]);
            }
        }
    }
    
    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(7, 0);
        this.dataWatcher.addObject(8, 0);
        this.dataWatcher.addObject(9, 0);
        this.dataWatcher.addObject(6, 1.0f);
    }
    
    public float getSwingProgress(final float lllllllllllllllIlIIlllIlIllIIlIl) {
        float lllllllllllllllIlIIlllIlIllIIlII = this.swingProgress - this.prevSwingProgress;
        if (lllllllllllllllIlIIlllIlIllIIlII < 0.0f) {
            ++lllllllllllllllIlIIlllIlIllIIlII;
        }
        return this.prevSwingProgress + lllllllllllllllIlIIlllIlIllIIlII * lllllllllllllllIlIIlllIlIllIIlIl;
    }
    
    @Override
    public void fall(final float lllllllllllllllIlIIlllllIIllIllI, final float lllllllllllllllIlIIlllllIIllIlII) {
        super.fall(lllllllllllllllIlIIlllllIIllIllI, lllllllllllllllIlIIlllllIIllIlII);
        final PotionEffect lllllllllllllllIlIIlllllIIllIIlI = this.getActivePotionEffect(Potion.jump);
        final float lllllllllllllllIlIIlllllIIllIIII = (lllllllllllllllIlIIlllllIIllIIlI != null) ? ((float)(lllllllllllllllIlIIlllllIIllIIlI.getAmplifier() + 1)) : 0.0f;
        final int lllllllllllllllIlIIlllllIIlIlllI = MathHelper.ceiling_float_int((lllllllllllllllIlIIlllllIIllIllI - 3.0f - lllllllllllllllIlIIlllllIIllIIII) * lllllllllllllllIlIIlllllIIllIlII);
        if (lllllllllllllllIlIIlllllIIlIlllI > 0) {
            this.playSound(this.func_146067_o(lllllllllllllllIlIIlllllIIlIlllI), 1.0f, 1.0f);
            this.attackEntityFrom(DamageSource.fall, (float)lllllllllllllllIlIIlllllIIlIlllI);
            final int lllllllllllllllIlIIlllllIIlIllII = MathHelper.floor_double(this.posX);
            final int lllllllllllllllIlIIlllllIIlIlIlI = MathHelper.floor_double(this.posY - 0.20000000298023224);
            final int lllllllllllllllIlIIlllllIIlIlIII = MathHelper.floor_double(this.posZ);
            final Block lllllllllllllllIlIIlllllIIlIIllI = this.worldObj.getBlockState(new BlockPos(lllllllllllllllIlIIlllllIIlIllII, lllllllllllllllIlIIlllllIIlIlIlI, lllllllllllllllIlIIlllllIIlIlIII)).getBlock();
            if (lllllllllllllllIlIIlllllIIlIIllI.getMaterial() != Material.air) {
                final Block.SoundType lllllllllllllllIlIIlllllIIlIIlII = lllllllllllllllIlIIlllllIIlIIllI.stepSound;
                this.playSound(lllllllllllllllIlIIlllllIIlIIlII.getStepSound(), lllllllllllllllIlIIlllllIIlIIlII.getVolume() * 0.5f, lllllllllllllllIlIIlllllIIlIIlII.getFrequency() * 0.75f);
            }
        }
    }
    
    public abstract ItemStack getHeldItem();
    
    @Override
    public float getRotationYawHead() {
        return this.rotationYawHead;
    }
    
    public boolean isOnTeam(final Team lllllllllllllllIlIIlllIlIIllIlII) {
        return this.getTeam() != null && this.getTeam().isSameTeam(lllllllllllllllIlIIlllIlIIllIlII);
    }
    
    public int getAge() {
        return this.entityAge;
    }
    
    public boolean isServerWorld() {
        return !this.worldObj.isRemote;
    }
    
    public final int getArrowCountInEntity() {
        return this.dataWatcher.getWatchableObjectByte(9);
    }
    
    public void heal(final float lllllllllllllllIlIlIIIIIIlIIlIll) {
        final float lllllllllllllllIlIlIIIIIIlIIllll = this.getHealth();
        if (lllllllllllllllIlIlIIIIIIlIIllll > 0.0f) {
            this.setHealth(lllllllllllllllIlIlIIIIIIlIIllll + lllllllllllllllIlIlIIIIIIlIIlIll);
        }
    }
    
    public void clearActivePotions() {
        final Iterator lllllllllllllllIlIlIIIIIllIIIlll = this.activePotionsMap.keySet().iterator();
        while (lllllllllllllllIlIlIIIIIllIIIlll.hasNext()) {
            final Integer lllllllllllllllIlIlIIIIIllIIIllI = lllllllllllllllIlIlIIIIIllIIIlll.next();
            final PotionEffect lllllllllllllllIlIlIIIIIllIIIlIl = this.activePotionsMap.get(lllllllllllllllIlIlIIIIIllIIIllI);
            if (!this.worldObj.isRemote) {
                lllllllllllllllIlIlIIIIIllIIIlll.remove();
                this.onFinishedPotionEffect(lllllllllllllllIlIlIIIIIllIIIlIl);
            }
        }
    }
    
    protected void func_180466_bG() {
        this.motionY += 0.03999999910593033;
    }
    
    private int getArmSwingAnimationEnd() {
        return this.isPotionActive(Potion.digSpeed) ? (6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1) : (this.isPotionActive(Potion.digSlowdown) ? (6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2) : 6);
    }
    
    @Override
    public abstract void setCurrentItemOrArmor(final int p0, final ItemStack p1);
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIlIlIIIIlIIIIlIlI) {
        lllllllllllllllIlIlIIIIlIIIIlIlI.setFloat("HealF", this.getHealth());
        lllllllllllllllIlIlIIIIlIIIIlIlI.setShort("Health", (short)Math.ceil(this.getHealth()));
        lllllllllllllllIlIlIIIIlIIIIlIlI.setShort("HurtTime", (short)this.hurtTime);
        lllllllllllllllIlIlIIIIlIIIIlIlI.setInteger("HurtByTimestamp", this.revengeTimer);
        lllllllllllllllIlIlIIIIlIIIIlIlI.setShort("DeathTime", (short)this.deathTime);
        lllllllllllllllIlIlIIIIlIIIIlIlI.setFloat("AbsorptionAmount", this.getAbsorptionAmount());
        for (final ItemStack lllllllllllllllIlIlIIIIlIIIlIIII : this.getInventory()) {
            if (lllllllllllllllIlIlIIIIlIIIlIIII != null) {
                this.attributeMap.removeAttributeModifiers(lllllllllllllllIlIlIIIIlIIIlIIII.getAttributeModifiers());
            }
        }
        lllllllllllllllIlIlIIIIlIIIIlIlI.setTag("Attributes", SharedMonsterAttributes.writeBaseAttributeMapToNBT(this.getAttributeMap()));
        for (final ItemStack lllllllllllllllIlIlIIIIlIIIIllll : this.getInventory()) {
            if (lllllllllllllllIlIlIIIIlIIIIllll != null) {
                this.attributeMap.applyAttributeModifiers(lllllllllllllllIlIlIIIIlIIIIllll.getAttributeModifiers());
            }
        }
        if (!this.activePotionsMap.isEmpty()) {
            final NBTTagList lllllllllllllllIlIlIIIIlIIIIlllI = new NBTTagList();
            for (final PotionEffect lllllllllllllllIlIlIIIIlIIIIllII : this.activePotionsMap.values()) {
                lllllllllllllllIlIlIIIIlIIIIlllI.appendTag(lllllllllllllllIlIlIIIIlIIIIllII.writeCustomPotionEffectToNBT(new NBTTagCompound()));
            }
            lllllllllllllllIlIlIIIIlIIIIlIlI.setTag("ActiveEffects", lllllllllllllllIlIlIIIIlIIIIlllI);
        }
    }
    
    protected void func_175136_bO() {
        this.potionsNeedUpdate = true;
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIlIlIIIIIllllIlII) {
        this.setAbsorptionAmount(lllllllllllllllIlIlIIIIIllllIlII.getFloat("AbsorptionAmount"));
        if (lllllllllllllllIlIlIIIIIllllIlII.hasKey("Attributes", 9) && this.worldObj != null && !this.worldObj.isRemote) {
            SharedMonsterAttributes.func_151475_a(this.getAttributeMap(), lllllllllllllllIlIlIIIIIllllIlII.getTagList("Attributes", 10));
        }
        if (lllllllllllllllIlIlIIIIIllllIlII.hasKey("ActiveEffects", 9)) {
            final NBTTagList lllllllllllllllIlIlIIIIIlllllIlI = lllllllllllllllIlIlIIIIIllllIlII.getTagList("ActiveEffects", 10);
            for (int lllllllllllllllIlIlIIIIIlllllIIl = 0; lllllllllllllllIlIlIIIIIlllllIIl < lllllllllllllllIlIlIIIIIlllllIlI.tagCount(); ++lllllllllllllllIlIlIIIIIlllllIIl) {
                final NBTTagCompound lllllllllllllllIlIlIIIIIlllllIII = lllllllllllllllIlIlIIIIIlllllIlI.getCompoundTagAt(lllllllllllllllIlIlIIIIIlllllIIl);
                final PotionEffect lllllllllllllllIlIlIIIIIllllIlll = PotionEffect.readCustomPotionEffectFromNBT(lllllllllllllllIlIlIIIIIlllllIII);
                if (lllllllllllllllIlIlIIIIIllllIlll != null) {
                    this.activePotionsMap.put(lllllllllllllllIlIlIIIIIllllIlll.getPotionID(), lllllllllllllllIlIlIIIIIllllIlll);
                }
            }
        }
        if (lllllllllllllllIlIlIIIIIllllIlII.hasKey("HealF", 99)) {
            this.setHealth(lllllllllllllllIlIlIIIIIllllIlII.getFloat("HealF"));
        }
        else {
            final NBTBase lllllllllllllllIlIlIIIIIllllIllI = lllllllllllllllIlIlIIIIIllllIlII.getTag("Health");
            if (lllllllllllllllIlIlIIIIIllllIllI == null) {
                this.setHealth(this.getMaxHealth());
            }
            else if (lllllllllllllllIlIlIIIIIllllIllI.getId() == 5) {
                this.setHealth(((NBTTagFloat)lllllllllllllllIlIlIIIIIllllIllI).getFloat());
            }
            else if (lllllllllllllllIlIlIIIIIllllIllI.getId() == 2) {
                this.setHealth(((NBTTagShort)lllllllllllllllIlIlIIIIIllllIllI).getShort());
            }
        }
        this.hurtTime = lllllllllllllllIlIlIIIIIllllIlII.getShort("HurtTime");
        this.deathTime = lllllllllllllllIlIlIIIIIllllIlII.getShort("DeathTime");
        this.revengeTimer = lllllllllllllllIlIlIIIIIllllIlII.getInteger("HurtByTimestamp");
    }
    
    public final void setArrowCountInEntity(final int lllllllllllllllIlIIllllIlIIlIllI) {
        this.dataWatcher.updateObject(9, (byte)lllllllllllllllIlIIllllIlIIlIllI);
    }
    
    protected String func_146067_o(final int lllllllllllllllIlIIlllllIIIIlIll) {
        return (lllllllllllllllIlIIlllllIIIIlIll > 4) ? "game.neutral.hurt.fall.big" : "game.neutral.hurt.fall.small";
    }
    
    public void removePotionEffect(final int lllllllllllllllIlIlIIIIIlIIIIIII) {
        final PotionEffect lllllllllllllllIlIlIIIIIIlllllll = this.activePotionsMap.remove(lllllllllllllllIlIlIIIIIlIIIIIII);
        if (lllllllllllllllIlIlIIIIIIlllllll != null) {
            this.onFinishedPotionEffect(lllllllllllllllIlIlIIIIIIlllllll);
        }
    }
    
    protected int getExperiencePoints(final EntityPlayer lllllllllllllllIlIlIIIIlIIlllllI) {
        return 0;
    }
    
    protected boolean isPlayer() {
        return false;
    }
    
    public void knockBack(final Entity lllllllllllllllIlIIllllllIIllllI, final float lllllllllllllllIlIIllllllIIlllIl, final double lllllllllllllllIlIIllllllIIlIIll, final double lllllllllllllllIlIIllllllIIlIIIl) {
        if (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue()) {
            this.isAirBorne = true;
            final float lllllllllllllllIlIIllllllIIllIIl = MathHelper.sqrt_double(lllllllllllllllIlIIllllllIIlIIll * lllllllllllllllIlIIllllllIIlIIll + lllllllllllllllIlIIllllllIIlIIIl * lllllllllllllllIlIIllllllIIlIIIl);
            final float lllllllllllllllIlIIllllllIIlIlll = 0.4f;
            this.motionX /= 2.0;
            this.motionY /= 2.0;
            this.motionZ /= 2.0;
            this.motionX -= lllllllllllllllIlIIllllllIIlIIll / lllllllllllllllIlIIllllllIIllIIl * lllllllllllllllIlIIllllllIIlIlll;
            this.motionY += lllllllllllllllIlIIllllllIIlIlll;
            this.motionZ -= lllllllllllllllIlIIllllllIIlIIIl / lllllllllllllllIlIIllllllIIllIIl * lllllllllllllllIlIIllllllIIlIlll;
            if (this.motionY > 0.4000000059604645) {
                this.motionY = 0.4000000059604645;
            }
        }
    }
    
    public void swingItem() {
        if (!this.isSwingInProgress || this.swingProgressInt >= this.getArmSwingAnimationEnd() / 2 || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwingInProgress = true;
            if (this.worldObj instanceof WorldServer) {
                ((WorldServer)this.worldObj).getEntityTracker().sendToAllTrackingEntity(this, new S0BPacketAnimation(this, 0));
            }
        }
    }
    
    public boolean isChild() {
        return false;
    }
    
    @Override
    public void onEntityUpdate() {
        this.prevSwingProgress = this.swingProgress;
        super.onEntityUpdate();
        this.worldObj.theProfiler.startSection("livingEntityBaseTick");
        final boolean lllllllllllllllIlIlIIIIlIllIlIll = this instanceof EntityPlayer;
        if (this.isEntityAlive()) {
            if (this.isEntityInsideOpaqueBlock()) {
                this.attackEntityFrom(DamageSource.inWall, 1.0f);
            }
            else if (lllllllllllllllIlIlIIIIlIllIlIll && !this.worldObj.getWorldBorder().contains(this.getEntityBoundingBox())) {
                final double lllllllllllllllIlIlIIIIlIllIlIlI = this.worldObj.getWorldBorder().getClosestDistance(this) + this.worldObj.getWorldBorder().getDamageBuffer();
                if (lllllllllllllllIlIlIIIIlIllIlIlI < 0.0) {
                    this.attackEntityFrom(DamageSource.inWall, (float)Math.max(1, MathHelper.floor_double(-lllllllllllllllIlIlIIIIlIllIlIlI * this.worldObj.getWorldBorder().func_177727_n())));
                }
            }
        }
        if (this.isImmuneToFire() || this.worldObj.isRemote) {
            this.extinguish();
        }
        final boolean lllllllllllllllIlIlIIIIlIllIlIIl = lllllllllllllllIlIlIIIIlIllIlIll && ((EntityPlayer)this).capabilities.disableDamage;
        if (this.isEntityAlive() && this.isInsideOfMaterial(Material.water)) {
            if (!this.canBreatheUnderwater() && !this.isPotionActive(Potion.waterBreathing.id) && !lllllllllllllllIlIlIIIIlIllIlIIl) {
                this.setAir(this.decreaseAirSupply(this.getAir()));
                if (this.getAir() == -20) {
                    this.setAir(0);
                    for (int lllllllllllllllIlIlIIIIlIllIlIII = 0; lllllllllllllllIlIlIIIIlIllIlIII < 8; ++lllllllllllllllIlIlIIIIlIllIlIII) {
                        final float lllllllllllllllIlIlIIIIlIllIIlll = this.rand.nextFloat() - this.rand.nextFloat();
                        final float lllllllllllllllIlIlIIIIlIllIIllI = this.rand.nextFloat() - this.rand.nextFloat();
                        final float lllllllllllllllIlIlIIIIlIllIIlIl = this.rand.nextFloat() - this.rand.nextFloat();
                        this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + lllllllllllllllIlIlIIIIlIllIIlll, this.posY + lllllllllllllllIlIlIIIIlIllIIllI, this.posZ + lllllllllllllllIlIlIIIIlIllIIlIl, this.motionX, this.motionY, this.motionZ, new int[0]);
                    }
                    this.attackEntityFrom(DamageSource.drown, 2.0f);
                }
            }
            if (!this.worldObj.isRemote && this.isRiding() && this.ridingEntity instanceof EntityLivingBase) {
                this.mountEntity(null);
            }
        }
        else {
            this.setAir(300);
        }
        if (this.isEntityAlive() && this.isWet()) {
            this.extinguish();
        }
        this.prevCameraPitch = this.cameraPitch;
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
        if (this.hurtResistantTime > 0 && !(this instanceof EntityPlayerMP)) {
            --this.hurtResistantTime;
        }
        if (this.getHealth() <= 0.0f) {
            this.onDeathUpdate();
        }
        if (this.recentlyHit > 0) {
            --this.recentlyHit;
        }
        else {
            this.attackingPlayer = null;
        }
        if (this.lastAttacker != null && !this.lastAttacker.isEntityAlive()) {
            this.lastAttacker = null;
        }
        if (this.entityLivingToAttack != null) {
            if (!this.entityLivingToAttack.isEntityAlive()) {
                this.setRevengeTarget(null);
            }
            else if (this.ticksExisted - this.revengeTimer > 100) {
                this.setRevengeTarget(null);
            }
        }
        this.updatePotionEffects();
        this.field_70763_ax = this.field_70764_aw;
        this.prevRenderYawOffset = this.renderYawOffset;
        this.prevRotationYawHead = this.rotationYawHead;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.worldObj.theProfiler.endSection();
    }
    
    public void setLastAttacker(final Entity lllllllllllllllIlIlIIIIlIIlIIIlI) {
        if (lllllllllllllllIlIlIIIIlIIlIIIlI instanceof EntityLivingBase) {
            this.lastAttacker = (EntityLivingBase)lllllllllllllllIlIlIIIIlIIlIIIlI;
        }
        else {
            this.lastAttacker = null;
        }
        this.lastAttackerTime = this.ticksExisted;
    }
    
    public boolean isPotionActive(final Potion lllllllllllllllIlIlIIIIIlIllIlII) {
        return this.activePotionsMap.containsKey(lllllllllllllllIlIlIIIIIlIllIlII.id);
    }
    
    protected void collideWithNearbyEntities() {
        final List lllllllllllllllIlIIlllIllIlllIlI = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.20000000298023224, 0.0, 0.20000000298023224));
        if (lllllllllllllllIlIIlllIllIlllIlI != null && !lllllllllllllllIlIIlllIllIlllIlI.isEmpty()) {
            for (int lllllllllllllllIlIIlllIllIlllIIl = 0; lllllllllllllllIlIIlllIllIlllIIl < lllllllllllllllIlIIlllIllIlllIlI.size(); ++lllllllllllllllIlIIlllIllIlllIIl) {
                final Entity lllllllllllllllIlIIlllIllIlllIII = lllllllllllllllIlIIlllIllIlllIlI.get(lllllllllllllllIlIIlllIllIlllIIl);
                if (lllllllllllllllIlIIlllIllIlllIII.canBePushed()) {
                    this.collideWithEntity(lllllllllllllllIlIIlllIllIlllIII);
                }
            }
        }
    }
    
    @Override
    public Vec3 getLookVec() {
        return this.getLook(1.0f);
    }
    
    protected void collideWithEntity(final Entity lllllllllllllllIlIIlllIllIlIlllI) {
        lllllllllllllllIlIIlllIllIlIlllI.applyEntityCollision(this);
    }
    
    public void onDeath(final DamageSource lllllllllllllllIlIIllllllIlIllll) {
        final Entity lllllllllllllllIlIIllllllIllIlll = lllllllllllllllIlIIllllllIlIllll.getEntity();
        final EntityLivingBase lllllllllllllllIlIIllllllIllIlIl = this.func_94060_bK();
        if (this.scoreValue >= 0 && lllllllllllllllIlIIllllllIllIlIl != null) {
            lllllllllllllllIlIIllllllIllIlIl.addToPlayerScore(this, this.scoreValue);
        }
        if (lllllllllllllllIlIIllllllIllIlll != null) {
            lllllllllllllllIlIIllllllIllIlll.onKillEntity(this);
        }
        this.dead = true;
        this.getCombatTracker().func_94549_h();
        if (!this.worldObj.isRemote) {
            int lllllllllllllllIlIIllllllIllIIll = 0;
            if (lllllllllllllllIlIIllllllIllIlll instanceof EntityPlayer) {
                lllllllllllllllIlIIllllllIllIIll = EnchantmentHelper.getLootingModifier((EntityLivingBase)lllllllllllllllIlIIllllllIllIlll);
            }
            if (this.func_146066_aG() && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
                this.dropFewItems(this.recentlyHit > 0, lllllllllllllllIlIIllllllIllIIll);
                this.dropEquipment(this.recentlyHit > 0, lllllllllllllllIlIIllllllIllIIll);
                if (this.recentlyHit > 0 && this.rand.nextFloat() < 0.025f + lllllllllllllllIlIIllllllIllIIll * 0.01f) {
                    this.addRandomArmor();
                }
            }
        }
        this.worldObj.setEntityState(this, (byte)3);
    }
    
    public final float getHealth() {
        return this.dataWatcher.getWatchableObjectFloat(6);
    }
    
    protected void dropEquipment(final boolean lllllllllllllllIlIIllllllIlIIllI, final int lllllllllllllllIlIIllllllIlIIlIl) {
    }
    
    public Team getTeam() {
        return this.worldObj.getScoreboard().getPlayersTeam(this.getUniqueID().toString());
    }
    
    public float getAbsorptionAmount() {
        return this.field_110151_bq;
    }
    
    public Random getRNG() {
        return this.rand;
    }
    
    @Override
    public void performHurtAnimation() {
        final int n = 10;
        this.maxHurtTime = n;
        this.hurtTime = n;
        this.attackedAtYaw = 0.0f;
    }
    
    protected float getSoundPitch() {
        return this.isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.5f) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
    }
    
    public boolean isEntityUndead() {
        return this.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD;
    }
    
    public int getRevengeTimer() {
        return this.revengeTimer;
    }
    
    protected void applyEntityAttributes() {
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.maxHealth);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.knockbackResistance);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.movementSpeed);
    }
    
    public Collection getActivePotionEffects() {
        return this.activePotionsMap.values();
    }
    
    public boolean isPotionApplicable(final PotionEffect lllllllllllllllIlIlIIIIIlIlIIIII) {
        if (this.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
            final int lllllllllllllllIlIlIIIIIlIIlllll = lllllllllllllllIlIlIIIIIlIlIIIII.getPotionID();
            if (lllllllllllllllIlIlIIIIIlIIlllll == Potion.regeneration.id || lllllllllllllllIlIlIIIIIlIIlllll == Potion.poison.id) {
                return false;
            }
        }
        return true;
    }
    
    public int getLastAttackerTime() {
        return this.lastAttackerTime;
    }
}
