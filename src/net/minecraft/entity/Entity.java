package net.minecraft.entity;

import net.minecraft.command.*;
import net.minecraft.block.material.*;
import net.minecraft.crash.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.server.*;
import hawk.modules.movement.*;
import hawk.*;
import hawk.modules.player.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import java.util.concurrent.*;
import net.minecraft.event.*;
import net.minecraft.entity.effect.*;
import net.minecraft.nbt.*;

public abstract class Entity implements ICommandSender
{
    public /* synthetic */ float prevRotationYaw;
    public /* synthetic */ double prevPosZ;
    public /* synthetic */ float height;
    protected /* synthetic */ DataWatcher dataWatcher;
    public /* synthetic */ World worldObj;
    private /* synthetic */ boolean isOutsideBorder;
    public /* synthetic */ float stepHeight;
    public /* synthetic */ float entityCollisionReduction;
    public /* synthetic */ float width;
    public /* synthetic */ boolean noClip;
    protected /* synthetic */ boolean isImmuneToFire;
    public /* synthetic */ double renderDistanceWeight;
    public /* synthetic */ double motionZ;
    protected /* synthetic */ boolean firstUpdate;
    private /* synthetic */ double entityRiderPitchDelta;
    public /* synthetic */ float distanceWalkedModified;
    public /* synthetic */ boolean isCollided;
    private static final /* synthetic */ AxisAlignedBB field_174836_a;
    public /* synthetic */ int dimension;
    public /* synthetic */ boolean isAirBorne;
    private /* synthetic */ int entityId;
    public /* synthetic */ double posY;
    private /* synthetic */ int fire;
    public /* synthetic */ int timeUntilPortal;
    public /* synthetic */ float fallDistance;
    private static /* synthetic */ int nextEntityID;
    public /* synthetic */ double motionX;
    public /* synthetic */ double posX;
    public /* synthetic */ double lastTickPosX;
    public /* synthetic */ boolean velocityChanged;
    private final /* synthetic */ CommandResultStats field_174837_as;
    public /* synthetic */ boolean isCollidedHorizontally;
    public /* synthetic */ AxisAlignedBB boundingBox;
    protected /* synthetic */ int portalCounter;
    public /* synthetic */ Entity ridingEntity;
    private /* synthetic */ boolean invulnerable;
    protected /* synthetic */ boolean inPortal;
    public /* synthetic */ double prevPosY;
    public /* synthetic */ float distanceWalkedOnStepModified;
    protected /* synthetic */ UUID entityUniqueID;
    public /* synthetic */ double posZ;
    public /* synthetic */ float prevDistanceWalkedModified;
    public /* synthetic */ Entity riddenByEntity;
    protected /* synthetic */ int teleportDirection;
    public /* synthetic */ float rotationPitch;
    private /* synthetic */ double entityRiderYawDelta;
    public /* synthetic */ double prevPosX;
    public /* synthetic */ double motionY;
    protected /* synthetic */ boolean inWater;
    public /* synthetic */ boolean isCollidedVertically;
    private /* synthetic */ int nextStepDistance;
    protected /* synthetic */ boolean isInWeb;
    public /* synthetic */ double lastTickPosZ;
    public /* synthetic */ boolean isDead;
    public /* synthetic */ int fireResistance;
    public /* synthetic */ float rotationYaw;
    public /* synthetic */ boolean onGround;
    protected /* synthetic */ Random rand;
    public /* synthetic */ float prevRotationPitch;
    public /* synthetic */ double lastTickPosY;
    
    public void extinguish() {
        this.fire = 0;
    }
    
    public UUID getUniqueID() {
        return this.entityUniqueID;
    }
    
    public boolean handleWaterMovement() {
        if (this.worldObj.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0, -0.4000000059604645, 0.0).contract(0.001, 0.001, 0.001), Material.water, this)) {
            if (!this.inWater && !this.firstUpdate) {
                this.resetHeight();
            }
            this.fallDistance = 0.0f;
            this.inWater = true;
            this.fire = 0;
        }
        else {
            this.inWater = false;
        }
        return this.inWater;
    }
    
    protected final String getEntityString() {
        return EntityList.getEntityString(this);
    }
    
    private void func_174829_m() {
        this.posX = (this.getEntityBoundingBox().minX + this.getEntityBoundingBox().maxX) / 2.0;
        this.posY = this.getEntityBoundingBox().minY;
        this.posZ = (this.getEntityBoundingBox().minZ + this.getEntityBoundingBox().maxZ) / 2.0;
    }
    
    public boolean canAttackWithItem() {
        return true;
    }
    
    @Override
    public World getEntityWorld() {
        return this.worldObj;
    }
    
    public void setRotationYawHead(final float lllllllllllllllIIIllIlllllIIIlII) {
    }
    
    public void setSneaking(final boolean lllllllllllllllIIIlllIIIIIllllll) {
        this.setFlag(1, lllllllllllllllIIIlllIIIIIllllll);
    }
    
    public void copyLocationAndAnglesFrom(final Entity lllllllllllllllIIIllIllllIllIlII) {
        this.setLocationAndAngles(lllllllllllllllIIIllIllllIllIlII.posX, lllllllllllllllIIIllIllllIllIlII.posY, lllllllllllllllIIIllIllllIllIlII.posZ, lllllllllllllllIIIllIllllIllIlII.rotationYaw, lllllllllllllllIIIllIllllIllIlII.rotationPitch);
    }
    
    public boolean hitByEntity(final Entity lllllllllllllllIIIllIlllllIIIIIl) {
        return false;
    }
    
    public int getMaxFallHeight() {
        return 3;
    }
    
    public boolean func_180427_aV() {
        return false;
    }
    
    public void func_174834_g(final NBTTagCompound lllllllllllllllIIIllIllIllllIlll) {
    }
    
    public void writeToNBT(final NBTTagCompound lllllllllllllllIIIlllIlIIIlIlIll) {
        try {
            lllllllllllllllIIIlllIlIIIlIlIll.setTag("Pos", this.newDoubleNBTList(this.posX, this.posY, this.posZ));
            lllllllllllllllIIIlllIlIIIlIlIll.setTag("Motion", this.newDoubleNBTList(this.motionX, this.motionY, this.motionZ));
            lllllllllllllllIIIlllIlIIIlIlIll.setTag("Rotation", this.newFloatNBTList(this.rotationYaw, this.rotationPitch));
            lllllllllllllllIIIlllIlIIIlIlIll.setFloat("FallDistance", this.fallDistance);
            lllllllllllllllIIIlllIlIIIlIlIll.setShort("Fire", (short)this.fire);
            lllllllllllllllIIIlllIlIIIlIlIll.setShort("Air", (short)this.getAir());
            lllllllllllllllIIIlllIlIIIlIlIll.setBoolean("OnGround", this.onGround);
            lllllllllllllllIIIlllIlIIIlIlIll.setInteger("Dimension", this.dimension);
            lllllllllllllllIIIlllIlIIIlIlIll.setBoolean("Invulnerable", this.invulnerable);
            lllllllllllllllIIIlllIlIIIlIlIll.setInteger("PortalCooldown", this.timeUntilPortal);
            lllllllllllllllIIIlllIlIIIlIlIll.setLong("UUIDMost", this.getUniqueID().getMostSignificantBits());
            lllllllllllllllIIIlllIlIIIlIlIll.setLong("UUIDLeast", this.getUniqueID().getLeastSignificantBits());
            if (this.getCustomNameTag() != null && this.getCustomNameTag().length() > 0) {
                lllllllllllllllIIIlllIlIIIlIlIll.setString("CustomName", this.getCustomNameTag());
                lllllllllllllllIIIlllIlIIIlIlIll.setBoolean("CustomNameVisible", this.getAlwaysRenderNameTag());
            }
            this.field_174837_as.func_179670_b(lllllllllllllllIIIlllIlIIIlIlIll);
            if (this.isSlient()) {
                lllllllllllllllIIIlllIlIIIlIlIll.setBoolean("Silent", this.isSlient());
            }
            this.writeEntityToNBT(lllllllllllllllIIIlllIlIIIlIlIll);
            if (this.ridingEntity != null) {
                final NBTTagCompound lllllllllllllllIIIlllIlIIIllIIII = new NBTTagCompound();
                if (this.ridingEntity.writeMountToNBT(lllllllllllllllIIIlllIlIIIllIIII)) {
                    lllllllllllllllIIIlllIlIIIlIlIll.setTag("Riding", lllllllllllllllIIIlllIlIIIllIIII);
                }
            }
        }
        catch (Throwable lllllllllllllllIIIlllIlIIIlIllll) {
            final CrashReport lllllllllllllllIIIlllIlIIIlIlllI = CrashReport.makeCrashReport(lllllllllllllllIIIlllIlIIIlIllll, "Saving entity NBT");
            final CrashReportCategory lllllllllllllllIIIlllIlIIIlIllIl = lllllllllllllllIIIlllIlIIIlIlllI.makeCategory("Entity being saved");
            this.addEntityCrashInfo(lllllllllllllllIIIlllIlIIIlIllIl);
            throw new ReportedException(lllllllllllllllIIIlllIlIIIlIlllI);
        }
    }
    
    public String getCustomNameTag() {
        return this.dataWatcher.getWatchableObjectString(2);
    }
    
    public boolean isSprinting() {
        return this.getFlag(3);
    }
    
    public boolean func_174816_a(final Explosion lllllllllllllllIIIllIllllIIIIllI, final World lllllllllllllllIIIllIllllIIIIlIl, final BlockPos lllllllllllllllIIIllIllllIIIIlII, final IBlockState lllllllllllllllIIIllIllllIIIIIll, final float lllllllllllllllIIIllIllllIIIIIlI) {
        return true;
    }
    
    public int getAir() {
        return this.dataWatcher.getWatchableObjectShort(1);
    }
    
    public float getRotationYawHead() {
        return 0.0f;
    }
    
    private boolean func_174809_b(final AxisAlignedBB lllllllllllllllIIIllllIIlllIllIl) {
        return this.worldObj.getCollidingBoundingBoxes(this, lllllllllllllllIIIllllIIlllIllIl).isEmpty() && !this.worldObj.isAnyLiquid(lllllllllllllllIIIllllIIlllIllIl);
    }
    
    public void onCollideWithPlayer(final EntityPlayer lllllllllllllllIIIlllIlIllIllIII) {
    }
    
    public void func_174826_a(final AxisAlignedBB lllllllllllllllIIIllIlllIIlIllll) {
        this.boundingBox = lllllllllllllllIIIllIlllIIlIllll;
    }
    
    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }
    
    protected boolean getFlag(final int lllllllllllllllIIIlllIIIIIIlIllI) {
        return (this.dataWatcher.getWatchableObjectByte(0) & 1 << lllllllllllllllIIIlllIIIIIIlIllI) != 0x0;
    }
    
    public void setSprinting(final boolean lllllllllllllllIIIlllIIIIIllIllI) {
        this.setFlag(3, lllllllllllllllIIIlllIIIIIllIllI);
    }
    
    protected void setSize(final float lllllllllllllllIIIllllIlIlIlIlIl, final float lllllllllllllllIIIllllIlIlIlIIII) {
        if (lllllllllllllllIIIllllIlIlIlIlIl != this.width || lllllllllllllllIIIllllIlIlIlIIII != this.height) {
            final float lllllllllllllllIIIllllIlIlIlIIll = this.width;
            this.width = lllllllllllllllIIIllllIlIlIlIlIl;
            this.height = lllllllllllllllIIIllllIlIlIlIIII;
            this.func_174826_a(new AxisAlignedBB(this.getEntityBoundingBox().minX, this.getEntityBoundingBox().minY, this.getEntityBoundingBox().minZ, this.getEntityBoundingBox().minX + this.width, this.getEntityBoundingBox().minY + this.height, this.getEntityBoundingBox().minZ + this.width));
            if (this.width > lllllllllllllllIIIllllIlIlIlIIll && !this.firstUpdate && !this.worldObj.isRemote) {
                this.moveEntity(lllllllllllllllIIIllllIlIlIlIIll - this.width, 0.0, lllllllllllllllIIIllllIlIlIlIIll - this.width);
            }
        }
    }
    
    protected final Vec3 func_174806_f(final float lllllllllllllllIIIlllIlIlIIlIllI, final float lllllllllllllllIIIlllIlIlIIlIlIl) {
        final float lllllllllllllllIIIlllIlIlIIllIlI = MathHelper.cos(-lllllllllllllllIIIlllIlIlIIlIlIl * 0.017453292f - 3.1415927f);
        final float lllllllllllllllIIIlllIlIlIIllIIl = MathHelper.sin(-lllllllllllllllIIIlllIlIlIIlIlIl * 0.017453292f - 3.1415927f);
        final float lllllllllllllllIIIlllIlIlIIllIII = -MathHelper.cos(-lllllllllllllllIIIlllIlIlIIlIllI * 0.017453292f);
        final float lllllllllllllllIIIlllIlIlIIlIlll = MathHelper.sin(-lllllllllllllllIIIlllIlIlIIlIllI * 0.017453292f);
        return new Vec3(lllllllllllllllIIIlllIlIlIIllIIl * lllllllllllllllIIIlllIlIlIIllIII, lllllllllllllllIIIlllIlIlIIlIlll, lllllllllllllllIIIlllIlIlIIllIlI * lllllllllllllllIIIlllIlIlIIllIII);
    }
    
    protected abstract void readEntityFromNBT(final NBTTagCompound p0);
    
    public void addVelocity(final double lllllllllllllllIIIlllIlIllIIIIII, final double lllllllllllllllIIIlllIlIlIllllll, final double lllllllllllllllIIIlllIlIlIlllIlI) {
        this.motionX += lllllllllllllllIIIlllIlIllIIIIII;
        this.motionY += lllllllllllllllIIIlllIlIlIllllll;
        this.motionZ += lllllllllllllllIIIlllIlIlIlllIlI;
        this.isAirBorne = true;
    }
    
    public boolean isEntityAlive() {
        return !this.isDead;
    }
    
    public Vec3 getLookVec() {
        return null;
    }
    
    public void setCurrentItemOrArmor(final int lllllllllllllllIIIlllIIIIlIlIIII, final ItemStack lllllllllllllllIIIlllIIIIlIIllll) {
    }
    
    public void func_174830_Y() {
        if (this.isSprinting() && !this.isInWater()) {
            this.func_174808_Z();
        }
    }
    
    public void setPositionAndUpdate(final double lllllllllllllllIIIllIlllIlIIllll, final double lllllllllllllllIIIllIlllIlIIlIlI, final double lllllllllllllllIIIllIlllIlIIllIl) {
        this.setLocationAndAngles(lllllllllllllllIIIllIlllIlIIllll, lllllllllllllllIIIllIlllIlIIlIlI, lllllllllllllllIIIllIlllIlIIllIl, this.rotationYaw, this.rotationPitch);
    }
    
    public double getMountedYOffset() {
        return this.height * 0.75;
    }
    
    public void performHurtAnimation() {
    }
    
    public void applyEntityCollision(final Entity lllllllllllllllIIIlllIlIllIIlIlI) {
        if (lllllllllllllllIIIlllIlIllIIlIlI.riddenByEntity != this && lllllllllllllllIIIlllIlIllIIlIlI.ridingEntity != this && !lllllllllllllllIIIlllIlIllIIlIlI.noClip && !this.noClip) {
            double lllllllllllllllIIIlllIlIllIIllll = lllllllllllllllIIIlllIlIllIIlIlI.posX - this.posX;
            double lllllllllllllllIIIlllIlIllIIlllI = lllllllllllllllIIIlllIlIllIIlIlI.posZ - this.posZ;
            double lllllllllllllllIIIlllIlIllIIllIl = MathHelper.abs_max(lllllllllllllllIIIlllIlIllIIllll, lllllllllllllllIIIlllIlIllIIlllI);
            if (lllllllllllllllIIIlllIlIllIIllIl >= 0.009999999776482582) {
                lllllllllllllllIIIlllIlIllIIllIl = MathHelper.sqrt_double(lllllllllllllllIIIlllIlIllIIllIl);
                lllllllllllllllIIIlllIlIllIIllll /= lllllllllllllllIIIlllIlIllIIllIl;
                lllllllllllllllIIIlllIlIllIIlllI /= lllllllllllllllIIIlllIlIllIIllIl;
                double lllllllllllllllIIIlllIlIllIIllII = 1.0 / lllllllllllllllIIIlllIlIllIIllIl;
                if (lllllllllllllllIIIlllIlIllIIllII > 1.0) {
                    lllllllllllllllIIIlllIlIllIIllII = 1.0;
                }
                lllllllllllllllIIIlllIlIllIIllll *= lllllllllllllllIIIlllIlIllIIllII;
                lllllllllllllllIIIlllIlIllIIlllI *= lllllllllllllllIIIlllIlIllIIllII;
                lllllllllllllllIIIlllIlIllIIllll *= 0.05000000074505806;
                lllllllllllllllIIIlllIlIllIIlllI *= 0.05000000074505806;
                lllllllllllllllIIIlllIlIllIIllll *= 1.0f - this.entityCollisionReduction;
                lllllllllllllllIIIlllIlIllIIlllI *= 1.0f - this.entityCollisionReduction;
                if (this.riddenByEntity == null) {
                    this.addVelocity(-lllllllllllllllIIIlllIlIllIIllll, 0.0, -lllllllllllllllIIIlllIlIllIIlllI);
                }
                if (lllllllllllllllIIIlllIlIllIIlIlI.riddenByEntity == null) {
                    lllllllllllllllIIIlllIlIllIIlIlI.addVelocity(lllllllllllllllIIIlllIlIllIIllll, 0.0, lllllllllllllllIIIlllIlIllIIlllI);
                }
            }
        }
    }
    
    protected void func_174808_Z() {
        final int lllllllllllllllIIIlllIllllIIIIIl = MathHelper.floor_double(this.posX);
        final int lllllllllllllllIIIlllIllllIIIIII = MathHelper.floor_double(this.posY - 0.20000000298023224);
        final int lllllllllllllllIIIlllIlllIllllll = MathHelper.floor_double(this.posZ);
        final BlockPos lllllllllllllllIIIlllIlllIlllllI = new BlockPos(lllllllllllllllIIIlllIllllIIIIIl, lllllllllllllllIIIlllIllllIIIIII, lllllllllllllllIIIlllIlllIllllll);
        final IBlockState lllllllllllllllIIIlllIlllIllllIl = this.worldObj.getBlockState(lllllllllllllllIIIlllIlllIlllllI);
        final Block lllllllllllllllIIIlllIlllIllllII = lllllllllllllllIIIlllIlllIllllIl.getBlock();
        if (lllllllllllllllIIIlllIlllIllllII.getRenderType() != -1) {
            this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + (this.rand.nextFloat() - 0.5) * this.width, this.getEntityBoundingBox().minY + 0.1, this.posZ + (this.rand.nextFloat() - 0.5) * this.width, -this.motionX * 4.0, 1.5, -this.motionZ * 4.0, Block.getStateId(lllllllllllllllIIIlllIlllIllllIl));
        }
    }
    
    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }
    
    public boolean func_174827_a(final EntityPlayerMP lllllllllllllllIIIllIlllIIllIllI) {
        return true;
    }
    
    protected void func_180433_a(final double lllllllllllllllIIIllllIIIIIIIlIl, final boolean lllllllllllllllIIIllllIIIIIIIlII, final Block lllllllllllllllIIIllllIIIIIIIIll, final BlockPos lllllllllllllllIIIlllIllllllllIl) {
        if (lllllllllllllllIIIllllIIIIIIIlII) {
            if (this.fallDistance > 0.0f) {
                if (lllllllllllllllIIIllllIIIIIIIIll != null) {
                    lllllllllllllllIIIllllIIIIIIIIll.onFallenUpon(this.worldObj, lllllllllllllllIIIlllIllllllllIl, this, this.fallDistance);
                }
                else {
                    this.fall(this.fallDistance, 1.0f);
                }
                this.fallDistance = 0.0f;
            }
        }
        else if (lllllllllllllllIIIllllIIIIIIIlIl < 0.0) {
            this.fallDistance -= (float)lllllllllllllllIIIllllIIIIIIIlIl;
        }
    }
    
    public boolean isEntityEqual(final Entity lllllllllllllllIIIllIlllllIIlIIl) {
        return this == lllllllllllllllIIIllIlllllIIlIIl;
    }
    
    public float getDistanceToEntity(final Entity lllllllllllllllIIIlllIllIIlIIIlI) {
        final float lllllllllllllllIIIlllIllIIlIIllI = (float)(this.posX - lllllllllllllllIIIlllIllIIlIIIlI.posX);
        final float lllllllllllllllIIIlllIllIIlIIlIl = (float)(this.posY - lllllllllllllllIIIlllIllIIlIIIlI.posY);
        final float lllllllllllllllIIIlllIllIIlIIlII = (float)(this.posZ - lllllllllllllllIIIlllIllIIlIIIlI.posZ);
        return MathHelper.sqrt_float(lllllllllllllllIIIlllIllIIlIIllI * lllllllllllllllIIIlllIllIIlIIllI + lllllllllllllllIIIlllIllIIlIIlIl * lllllllllllllllIIIlllIllIIlIIlIl + lllllllllllllllIIIlllIllIIlIIlII * lllllllllllllllIIIlllIllIIlIIlII);
    }
    
    public void setDead() {
        this.isDead = true;
    }
    
    public boolean canRenderOnFire() {
        return this.isBurning();
    }
    
    protected boolean pushOutOfBlocks(final double lllllllllllllllIIIllIllllllIIIII, final double lllllllllllllllIIIllIllllllIllII, final double lllllllllllllllIIIllIlllllIlllIl) {
        final BlockPos lllllllllllllllIIIllIllllllIlIlI = new BlockPos(lllllllllllllllIIIllIllllllIIIII, lllllllllllllllIIIllIllllllIllII, lllllllllllllllIIIllIlllllIlllIl);
        final double lllllllllllllllIIIllIllllllIlIIl = lllllllllllllllIIIllIllllllIIIII - lllllllllllllllIIIllIllllllIlIlI.getX();
        final double lllllllllllllllIIIllIllllllIlIII = lllllllllllllllIIIllIllllllIllII - lllllllllllllllIIIllIllllllIlIlI.getY();
        final double lllllllllllllllIIIllIllllllIIlll = lllllllllllllllIIIllIlllllIlllIl - lllllllllllllllIIIllIllllllIlIlI.getZ();
        final List lllllllllllllllIIIllIllllllIIllI = this.worldObj.func_147461_a(this.getEntityBoundingBox());
        if (lllllllllllllllIIIllIllllllIIllI.isEmpty() && !this.worldObj.func_175665_u(lllllllllllllllIIIllIllllllIlIlI)) {
            return false;
        }
        byte lllllllllllllllIIIllIllllllIIlIl = 3;
        double lllllllllllllllIIIllIllllllIIlII = 9999.0;
        if (!this.worldObj.func_175665_u(lllllllllllllllIIIllIllllllIlIlI.offsetWest()) && lllllllllllllllIIIllIllllllIlIIl < lllllllllllllllIIIllIllllllIIlII) {
            lllllllllllllllIIIllIllllllIIlII = lllllllllllllllIIIllIllllllIlIIl;
            lllllllllllllllIIIllIllllllIIlIl = 0;
        }
        if (!this.worldObj.func_175665_u(lllllllllllllllIIIllIllllllIlIlI.offsetEast()) && 1.0 - lllllllllllllllIIIllIllllllIlIIl < lllllllllllllllIIIllIllllllIIlII) {
            lllllllllllllllIIIllIllllllIIlII = 1.0 - lllllllllllllllIIIllIllllllIlIIl;
            lllllllllllllllIIIllIllllllIIlIl = 1;
        }
        if (!this.worldObj.func_175665_u(lllllllllllllllIIIllIllllllIlIlI.offsetUp()) && 1.0 - lllllllllllllllIIIllIllllllIlIII < lllllllllllllllIIIllIllllllIIlII) {
            lllllllllllllllIIIllIllllllIIlII = 1.0 - lllllllllllllllIIIllIllllllIlIII;
            lllllllllllllllIIIllIllllllIIlIl = 3;
        }
        if (!this.worldObj.func_175665_u(lllllllllllllllIIIllIllllllIlIlI.offsetNorth()) && lllllllllllllllIIIllIllllllIIlll < lllllllllllllllIIIllIllllllIIlII) {
            lllllllllllllllIIIllIllllllIIlII = lllllllllllllllIIIllIllllllIIlll;
            lllllllllllllllIIIllIllllllIIlIl = 4;
        }
        if (!this.worldObj.func_175665_u(lllllllllllllllIIIllIllllllIlIlI.offsetSouth()) && 1.0 - lllllllllllllllIIIllIllllllIIlll < lllllllllllllllIIIllIllllllIIlII) {
            lllllllllllllllIIIllIllllllIIlII = 1.0 - lllllllllllllllIIIllIllllllIIlll;
            lllllllllllllllIIIllIllllllIIlIl = 5;
        }
        final float lllllllllllllllIIIllIllllllIIIll = this.rand.nextFloat() * 0.2f + 0.1f;
        if (lllllllllllllllIIIllIllllllIIlIl == 0) {
            this.motionX = -lllllllllllllllIIIllIllllllIIIll;
        }
        if (lllllllllllllllIIIllIllllllIIlIl == 1) {
            this.motionX = lllllllllllllllIIIllIllllllIIIll;
        }
        if (lllllllllllllllIIIllIllllllIIlIl == 3) {
            this.motionY = lllllllllllllllIIIllIllllllIIIll;
        }
        if (lllllllllllllllIIIllIllllllIIlIl == 4) {
            this.motionZ = -lllllllllllllllIIIllIllllllIIIll;
        }
        if (lllllllllllllllIIIllIllllllIIlIl == 5) {
            this.motionZ = lllllllllllllllIIIllIllllllIIIll;
        }
        return true;
    }
    
    public EntityItem dropItemWithOffset(final Item lllllllllllllllIIIlllIIIllIlIIlI, final int lllllllllllllllIIIlllIIIllIlIlIl, final float lllllllllllllllIIIlllIIIllIlIIII) {
        return this.entityDropItem(new ItemStack(lllllllllllllllIIIlllIIIllIlIIlI, lllllllllllllllIIIlllIIIllIlIlIl, 0), lllllllllllllllIIIlllIIIllIlIIII);
    }
    
    public void func_174812_G() {
        this.setDead();
    }
    
    protected void setFlag(final int lllllllllllllllIIIlllIIIIIIlIIII, final boolean lllllllllllllllIIIlllIIIIIIIlIll) {
        final byte lllllllllllllllIIIlllIIIIIIIlllI = this.dataWatcher.getWatchableObjectByte(0);
        if (lllllllllllllllIIIlllIIIIIIIlIll) {
            this.dataWatcher.updateObject(0, (byte)(lllllllllllllllIIIlllIIIIIIIlllI | 1 << lllllllllllllllIIIlllIIIIIIlIIII));
        }
        else {
            this.dataWatcher.updateObject(0, (byte)(lllllllllllllllIIIlllIIIIIIIlllI & ~(1 << lllllllllllllllIIIlllIIIIIIlIIII)));
        }
    }
    
    protected void setBeenAttacked() {
        this.velocityChanged = true;
    }
    
    public void setWorld(final World lllllllllllllllIIIlllIllIllIIIIl) {
        this.worldObj = lllllllllllllllIIIlllIllIllIIIIl;
    }
    
    public void func_174817_o(final Entity lllllllllllllllIIIllIllIlllllIlI) {
        this.field_174837_as.func_179671_a(lllllllllllllllIIIllIllIlllllIlI.func_174807_aT());
    }
    
    public boolean isBurning() {
        final boolean lllllllllllllllIIIlllIIIIlIIlIll = this.worldObj != null && this.worldObj.isRemote;
        return !this.isImmuneToFire && (this.fire > 0 || (lllllllllllllllIIIlllIIIIlIIlIll && this.getFlag(0)));
    }
    
    public void onUpdate() {
        this.onEntityUpdate();
    }
    
    public EntityItem entityDropItem(final ItemStack lllllllllllllllIIIlllIIIllIIIllI, final float lllllllllllllllIIIlllIIIllIIlIIl) {
        if (lllllllllllllllIIIlllIIIllIIIllI.stackSize != 0 && lllllllllllllllIIIlllIIIllIIIllI.getItem() != null) {
            final EntityItem lllllllllllllllIIIlllIIIllIIlIII = new EntityItem(this.worldObj, this.posX, this.posY + lllllllllllllllIIIlllIIIllIIlIIl, this.posZ, lllllllllllllllIIIlllIIIllIIIllI);
            lllllllllllllllIIIlllIIIllIIlIII.setDefaultPickupDelay();
            this.worldObj.spawnEntityInWorld(lllllllllllllllIIIlllIIIllIIlIII);
            return lllllllllllllllIIIlllIIIllIIlIII;
        }
        return null;
    }
    
    @Override
    public Vec3 getPositionVector() {
        return new Vec3(this.posX, this.posY, this.posZ);
    }
    
    public boolean writeToNBTOptional(final NBTTagCompound lllllllllllllllIIIlllIlIIIllllII) {
        final String lllllllllllllllIIIlllIlIIIlllIll = this.getEntityString();
        if (!this.isDead && lllllllllllllllIIIlllIlIIIlllIll != null && this.riddenByEntity == null) {
            lllllllllllllllIIIlllIlIIIllllII.setString("id", lllllllllllllllIIIlllIlIIIlllIll);
            this.writeToNBT(lllllllllllllllIIIlllIlIIIllllII);
            return true;
        }
        return false;
    }
    
    public boolean canBePushed() {
        return false;
    }
    
    @Override
    public IChatComponent getDisplayName() {
        final ChatComponentText lllllllllllllllIIIllIlllIllIllII = new ChatComponentText(this.getName());
        lllllllllllllllIIIllIlllIllIllII.getChatStyle().setChatHoverEvent(this.func_174823_aP());
        lllllllllllllllIIIllIlllIllIllII.getChatStyle().setInsertion(this.getUniqueID().toString());
        return lllllllllllllllIIIllIlllIllIllII;
    }
    
    public void setFire(final int lllllllllllllllIIIllllIlIIIIllII) {
        int lllllllllllllllIIIllllIlIIIIlIll = lllllllllllllllIIIllllIlIIIIllII * 20;
        lllllllllllllllIIIllllIlIIIIlIll = EnchantmentProtection.getFireTimeForEntity(this, lllllllllllllllIIIllllIlIIIIlIll);
        if (this.fire < lllllllllllllllIIIllllIlIIIIlIll) {
            this.fire = lllllllllllllllIIIllllIlIIIIlIll;
        }
    }
    
    public void setOutsideBorder(final boolean lllllllllllllllIIIllIlllIIlIIIll) {
        this.isOutsideBorder = lllllllllllllllIIIllIlllIIlIIIll;
    }
    
    public void func_180426_a(final double lllllllllllllllIIIlllIIIlIIIIllI, double lllllllllllllllIIIlllIIIIllllIIl, final double lllllllllllllllIIIlllIIIlIIIIlII, final float lllllllllllllllIIIlllIIIlIIIIIll, final float lllllllllllllllIIIlllIIIlIIIIIlI, final int lllllllllllllllIIIlllIIIlIIIIIIl, final boolean lllllllllllllllIIIlllIIIlIIIIIII) {
        this.setPosition(lllllllllllllllIIIlllIIIlIIIIllI, lllllllllllllllIIIlllIIIIllllIIl, lllllllllllllllIIIlllIIIlIIIIlII);
        this.setRotation(lllllllllllllllIIIlllIIIlIIIIIll, lllllllllllllllIIIlllIIIlIIIIIlI);
        final List lllllllllllllllIIIlllIIIIlllllll = this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().contract(0.03125, 0.0, 0.03125));
        if (!lllllllllllllllIIIlllIIIIlllllll.isEmpty()) {
            double lllllllllllllllIIIlllIIIIllllllI = 0.0;
            for (final AxisAlignedBB lllllllllllllllIIIlllIIIIlllllII : lllllllllllllllIIIlllIIIIlllllll) {
                if (lllllllllllllllIIIlllIIIIlllllII.maxY > lllllllllllllllIIIlllIIIIllllllI) {
                    lllllllllllllllIIIlllIIIIllllllI = lllllllllllllllIIIlllIIIIlllllII.maxY;
                }
            }
            lllllllllllllllIIIlllIIIIllllIIl += lllllllllllllllIIIlllIIIIllllllI - this.getEntityBoundingBox().minY;
            this.setPosition(lllllllllllllllIIIlllIIIlIIIIllI, lllllllllllllllIIIlllIIIIllllIIl, lllllllllllllllIIIlllIIIlIIIIlII);
        }
    }
    
    public Vec3 func_174824_e(final float lllllllllllllllIIIlllIlIlIIIIlIl) {
        if (lllllllllllllllIIIlllIlIlIIIIlIl == 1.0f) {
            return new Vec3(this.posX, this.posY + this.getEyeHeight(), this.posZ);
        }
        final double lllllllllllllllIIIlllIlIlIIIlIIl = this.prevPosX + (this.posX - this.prevPosX) * lllllllllllllllIIIlllIlIlIIIIlIl;
        final double lllllllllllllllIIIlllIlIlIIIlIII = this.prevPosY + (this.posY - this.prevPosY) * lllllllllllllllIIIlllIlIlIIIIlIl + this.getEyeHeight();
        final double lllllllllllllllIIIlllIlIlIIIIlll = this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllllllIIIlllIlIlIIIIlIl;
        return new Vec3(lllllllllllllllIIIlllIlIlIIIlIIl, lllllllllllllllIIIlllIlIlIIIlIII, lllllllllllllllIIIlllIlIlIIIIlll);
    }
    
    protected void setOnFireFromLava() {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.lava, 4.0f);
            this.setFire(15);
        }
    }
    
    public void onChunkLoad() {
    }
    
    public void onEntityUpdate() {
        this.worldObj.theProfiler.startSection("entityBaseTick");
        if (this.ridingEntity != null && this.ridingEntity.isDead) {
            this.ridingEntity = null;
        }
        this.prevDistanceWalkedModified = this.distanceWalkedModified;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYaw = this.rotationYaw;
        if (!this.worldObj.isRemote && this.worldObj instanceof WorldServer) {
            this.worldObj.theProfiler.startSection("portal");
            final MinecraftServer lllllllllllllllIIIllllIlIIIlllII = ((WorldServer)this.worldObj).func_73046_m();
            final int lllllllllllllllIIIllllIlIIIllIll = this.getMaxInPortalTime();
            if (this.inPortal) {
                if (lllllllllllllllIIIllllIlIIIlllII.getAllowNether()) {
                    if (this.ridingEntity == null && this.portalCounter++ >= lllllllllllllllIIIllllIlIIIllIll) {
                        this.portalCounter = lllllllllllllllIIIllllIlIIIllIll;
                        this.timeUntilPortal = this.getPortalCooldown();
                        byte lllllllllllllllIIIllllIlIIIllIIl = 0;
                        if (this.worldObj.provider.getDimensionId() == -1) {
                            final byte lllllllllllllllIIIllllIlIIIllIlI = 0;
                        }
                        else {
                            lllllllllllllllIIIllllIlIIIllIIl = -1;
                        }
                        this.travelToDimension(lllllllllllllllIIIllllIlIIIllIIl);
                    }
                    this.inPortal = false;
                }
            }
            else {
                if (this.portalCounter > 0) {
                    this.portalCounter -= 4;
                }
                if (this.portalCounter < 0) {
                    this.portalCounter = 0;
                }
            }
            if (this.timeUntilPortal > 0) {
                --this.timeUntilPortal;
            }
            this.worldObj.theProfiler.endSection();
        }
        this.func_174830_Y();
        this.handleWaterMovement();
        if (this.worldObj.isRemote) {
            this.fire = 0;
        }
        else if (this.fire > 0) {
            if (this.isImmuneToFire) {
                this.fire -= 4;
                if (this.fire < 0) {
                    this.fire = 0;
                }
            }
            else {
                if (this.fire % 20 == 0) {
                    this.attackEntityFrom(DamageSource.onFire, 1.0f);
                }
                --this.fire;
            }
        }
        if (this.func_180799_ab()) {
            this.setOnFireFromLava();
            this.fallDistance *= 0.5f;
        }
        if (this.posY < -64.0) {
            this.kill();
        }
        if (!this.worldObj.isRemote) {
            this.setFlag(0, this.fire > 0);
        }
        this.firstUpdate = false;
        this.worldObj.theProfiler.endSection();
    }
    
    protected void kill() {
        this.setDead();
    }
    
    public void setPosition(final double lllllllllllllllIIIllllIlIIlllIII, final double lllllllllllllllIIIllllIlIIllIlll, final double lllllllllllllllIIIllllIlIIllllII) {
        this.posX = lllllllllllllllIIIllllIlIIlllIII;
        this.posY = lllllllllllllllIIIllllIlIIllIlll;
        this.posZ = lllllllllllllllIIIllllIlIIllllII;
        final float lllllllllllllllIIIllllIlIIlllIll = this.width / 2.0f;
        final float lllllllllllllllIIIllllIlIIlllIlI = this.height;
        this.func_174826_a(new AxisAlignedBB(lllllllllllllllIIIllllIlIIlllIII - lllllllllllllllIIIllllIlIIlllIll, lllllllllllllllIIIllllIlIIllIlll, lllllllllllllllIIIllllIlIIllllII - lllllllllllllllIIIllllIlIIlllIll, lllllllllllllllIIIllllIlIIlllIII + lllllllllllllllIIIllllIlIIlllIll, lllllllllllllllIIIllllIlIIllIlll + lllllllllllllllIIIllllIlIIlllIlI, lllllllllllllllIIIllllIlIIllllII + lllllllllllllllIIIllllIlIIlllIll));
    }
    
    public boolean isInsideOfMaterial(final Material lllllllllllllllIIIlllIlllIlIlIIl) {
        final double lllllllllllllllIIIlllIlllIlIlIII = this.posY + this.getEyeHeight();
        final BlockPos lllllllllllllllIIIlllIlllIlIIlll = new BlockPos(this.posX, lllllllllllllllIIIlllIlllIlIlIII, this.posZ);
        final IBlockState lllllllllllllllIIIlllIlllIlIIllI = this.worldObj.getBlockState(lllllllllllllllIIIlllIlllIlIIlll);
        final Block lllllllllllllllIIIlllIlllIlIIlIl = lllllllllllllllIIIlllIlllIlIIllI.getBlock();
        if (lllllllllllllllIIIlllIlllIlIIlIl.getMaterial() == lllllllllllllllIIIlllIlllIlIlIIl) {
            final float lllllllllllllllIIIlllIlllIlIIlII = BlockLiquid.getLiquidHeightPercent(lllllllllllllllIIIlllIlllIlIIllI.getBlock().getMetaFromState(lllllllllllllllIIIlllIlllIlIIllI)) - 0.11111111f;
            final float lllllllllllllllIIIlllIlllIlIIIll = lllllllllllllllIIIlllIlllIlIIlll.getY() + 1 - lllllllllllllllIIIlllIlllIlIIlII;
            final boolean lllllllllllllllIIIlllIlllIlIIIlI = lllllllllllllllIIIlllIlllIlIlIII < lllllllllllllllIIIlllIlllIlIIIll;
            return (lllllllllllllllIIIlllIlllIlIIIlI || !(this instanceof EntityPlayer)) && lllllllllllllllIIIlllIlllIlIIIlI;
        }
        return false;
    }
    
    public AxisAlignedBB getEntityBoundingBox() {
        return this.boundingBox;
    }
    
    protected void preparePlayerToSpawn() {
        if (this.worldObj != null) {
            while (this.posY > 0.0 && this.posY < 256.0) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty()) {
                    break;
                }
                ++this.posY;
            }
            final double motionX = 0.0;
            this.motionZ = motionX;
            this.motionY = motionX;
            this.motionX = motionX;
            this.rotationPitch = 0.0f;
        }
    }
    
    public void playSound(final String lllllllllllllllIIIllllIIIIIllIII, final float lllllllllllllllIIIllllIIIIIlIlll, final float lllllllllllllllIIIllllIIIIIllIlI) {
        if (!this.isSlient()) {
            this.worldObj.playSoundAtEntity(this, lllllllllllllllIIIllllIIIIIllIII, lllllllllllllllIIIllllIIIIIlIlll, lllllllllllllllIIIllllIIIIIllIlI);
        }
    }
    
    public void travelToDimension(final int lllllllllllllllIIIllIllllIIlIlll) {
        if (!this.worldObj.isRemote && !this.isDead) {
            this.worldObj.theProfiler.startSection("changeDimension");
            final MinecraftServer lllllllllllllllIIIllIllllIIllllI = MinecraftServer.getServer();
            final int lllllllllllllllIIIllIllllIIlllIl = this.dimension;
            final WorldServer lllllllllllllllIIIllIllllIIlllII = lllllllllllllllIIIllIllllIIllllI.worldServerForDimension(lllllllllllllllIIIllIllllIIlllIl);
            WorldServer lllllllllllllllIIIllIllllIIllIll = lllllllllllllllIIIllIllllIIllllI.worldServerForDimension(lllllllllllllllIIIllIllllIIlIlll);
            this.dimension = lllllllllllllllIIIllIllllIIlIlll;
            if (lllllllllllllllIIIllIllllIIlllIl == 1 && lllllllllllllllIIIllIllllIIlIlll == 1) {
                lllllllllllllllIIIllIllllIIllIll = lllllllllllllllIIIllIllllIIllllI.worldServerForDimension(0);
                this.dimension = 0;
            }
            this.worldObj.removeEntity(this);
            this.isDead = false;
            this.worldObj.theProfiler.startSection("reposition");
            lllllllllllllllIIIllIllllIIllllI.getConfigurationManager().transferEntityToWorld(this, lllllllllllllllIIIllIllllIIlllIl, lllllllllllllllIIIllIllllIIlllII, lllllllllllllllIIIllIllllIIllIll);
            this.worldObj.theProfiler.endStartSection("reloading");
            final Entity lllllllllllllllIIIllIllllIIllIlI = EntityList.createEntityByName(EntityList.getEntityString(this), lllllllllllllllIIIllIllllIIllIll);
            if (lllllllllllllllIIIllIllllIIllIlI != null) {
                lllllllllllllllIIIllIllllIIllIlI.func_180432_n(this);
                if (lllllllllllllllIIIllIllllIIlllIl == 1 && lllllllllllllllIIIllIllllIIlIlll == 1) {
                    final BlockPos lllllllllllllllIIIllIllllIIllIIl = this.worldObj.func_175672_r(lllllllllllllllIIIllIllllIIllIll.getSpawnPoint());
                    lllllllllllllllIIIllIllllIIllIlI.func_174828_a(lllllllllllllllIIIllIllllIIllIIl, lllllllllllllllIIIllIllllIIllIlI.rotationYaw, lllllllllllllllIIIllIllllIIllIlI.rotationPitch);
                }
                lllllllllllllllIIIllIllllIIllIll.spawnEntityInWorld(lllllllllllllllIIIllIllllIIllIlI);
            }
            this.isDead = true;
            this.worldObj.theProfiler.endSection();
            lllllllllllllllIIIllIllllIIlllII.resetUpdateEntityTick();
            lllllllllllllllIIIllIllllIIllIll.resetUpdateEntityTick();
            this.worldObj.theProfiler.endSection();
        }
    }
    
    public boolean func_180431_b(final DamageSource lllllllllllllllIIIllIllllIlllIlI) {
        return this.invulnerable && lllllllllllllllIIIllIllllIlllIlI != DamageSource.outOfWorld && !lllllllllllllllIIIllIllllIlllIlI.func_180136_u();
    }
    
    public MovingObjectPosition func_174822_a(final double lllllllllllllllIIIlllIlIIllllIlI, final float lllllllllllllllIIIlllIlIIllllIIl) {
        final Vec3 lllllllllllllllIIIlllIlIIllllIII = this.func_174824_e(lllllllllllllllIIIlllIlIIllllIIl);
        final Vec3 lllllllllllllllIIIlllIlIIlllIlll = this.getLook(lllllllllllllllIIIlllIlIIllllIIl);
        final Vec3 lllllllllllllllIIIlllIlIIlllIllI = lllllllllllllllIIIlllIlIIllllIII.addVector(lllllllllllllllIIIlllIlIIlllIlll.xCoord * lllllllllllllllIIIlllIlIIllllIlI, lllllllllllllllIIIlllIlIIlllIlll.yCoord * lllllllllllllllIIIlllIlIIllllIlI, lllllllllllllllIIIlllIlIIlllIlll.zCoord * lllllllllllllllIIIlllIlIIllllIlI);
        return this.worldObj.rayTraceBlocks(lllllllllllllllIIIlllIlIIllllIII, lllllllllllllllIIIlllIlIIlllIllI, false, false, true);
    }
    
    @Override
    public String toString() {
        return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", this.getClass().getSimpleName(), this.getName(), this.entityId, (this.worldObj == null) ? "~NULL~" : this.worldObj.getWorldInfo().getWorldName(), this.posX, this.posY, this.posZ);
    }
    
    public EnumFacing func_174811_aO() {
        return EnumFacing.getHorizontal(MathHelper.floor_double(this.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3);
    }
    
    public boolean func_180799_ab() {
        return this.worldObj.isMaterialInBB(this.getEntityBoundingBox().expand(-0.10000000149011612, -0.4000000059604645, -0.10000000149011612), Material.lava);
    }
    
    public void setEating(final boolean lllllllllllllllIIIlllIIIIIIllllI) {
        this.setFlag(4, lllllllllllllllIIIlllIIIIIIllllI);
    }
    
    public AxisAlignedBB getCollisionBox(final Entity lllllllllllllllIIIlllIIIlIlIlllI) {
        return null;
    }
    
    public void fall(final float lllllllllllllllIIIlllIlllllIlIll, final float lllllllllllllllIIIlllIlllllIllIl) {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.fall(lllllllllllllllIIIlllIlllllIlIll, lllllllllllllllIIIlllIlllllIllIl);
        }
    }
    
    @Override
    public boolean sendCommandFeedback() {
        return false;
    }
    
    protected abstract void entityInit();
    
    public void moveEntity(double lllllllllllllllIIIllllIIlIlllllI, double lllllllllllllllIIIllllIIlIllllIl, double lllllllllllllllIIIllllIIIlllllII) {
        if (this.noClip) {
            this.func_174826_a(this.getEntityBoundingBox().offset(lllllllllllllllIIIllllIIlIlllllI, lllllllllllllllIIIllllIIlIllllIl, lllllllllllllllIIIllllIIIlllllII));
            this.func_174829_m();
        }
        else {
            this.worldObj.theProfiler.startSection("move");
            final double lllllllllllllllIIIllllIIlIlllIll = this.posX;
            final double lllllllllllllllIIIllllIIlIlllIlI = this.posY;
            final double lllllllllllllllIIIllllIIlIlllIIl = this.posZ;
            if (this.isInWeb) {
                this.isInWeb = false;
                lllllllllllllllIIIllllIIlIlllllI *= 0.25;
                lllllllllllllllIIIllllIIlIllllIl *= 0.05000000074505806;
                lllllllllllllllIIIllllIIIlllllII *= 0.25;
                this.motionX = 0.0;
                this.motionY = 0.0;
                this.motionZ = 0.0;
            }
            double lllllllllllllllIIIllllIIlIlllIII = lllllllllllllllIIIllllIIlIlllllI;
            final double lllllllllllllllIIIllllIIlIllIlll = lllllllllllllllIIIllllIIlIllllIl;
            double lllllllllllllllIIIllllIIlIllIllI = lllllllllllllllIIIllllIIIlllllII;
            final boolean lllllllllllllllIIIllllIIlIllIlIl = (this.onGround && this.isSneaking() && this instanceof EntityPlayer) || ((Safewalk.isEnabled || (Client.scaffold.safewalk.enabled && ScaffoldHopeItWorks.isEnabled)) && Minecraft.getMinecraft().thePlayer.onGround);
            if (lllllllllllllllIIIllllIIlIllIlIl) {
                final double lllllllllllllllIIIllllIIlIllIlII = 0.05;
                while (lllllllllllllllIIIllllIIlIlllllI != 0.0) {
                    if (!this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(lllllllllllllllIIIllllIIlIlllllI, -1.0, 0.0)).isEmpty()) {
                        break;
                    }
                    if (lllllllllllllllIIIllllIIlIlllllI < lllllllllllllllIIIllllIIlIllIlII && lllllllllllllllIIIllllIIlIlllllI >= -lllllllllllllllIIIllllIIlIllIlII) {
                        lllllllllllllllIIIllllIIlIlllllI = 0.0;
                    }
                    else if (lllllllllllllllIIIllllIIlIlllllI > 0.0) {
                        lllllllllllllllIIIllllIIlIlllllI -= lllllllllllllllIIIllllIIlIllIlII;
                    }
                    else {
                        lllllllllllllllIIIllllIIlIlllllI += lllllllllllllllIIIllllIIlIllIlII;
                    }
                    lllllllllllllllIIIllllIIlIlllIII = lllllllllllllllIIIllllIIlIlllllI;
                }
                while (lllllllllllllllIIIllllIIIlllllII != 0.0) {
                    if (!this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(0.0, -1.0, lllllllllllllllIIIllllIIIlllllII)).isEmpty()) {
                        break;
                    }
                    if (lllllllllllllllIIIllllIIIlllllII < lllllllllllllllIIIllllIIlIllIlII && lllllllllllllllIIIllllIIIlllllII >= -lllllllllllllllIIIllllIIlIllIlII) {
                        lllllllllllllllIIIllllIIIlllllII = 0.0;
                    }
                    else if (lllllllllllllllIIIllllIIIlllllII > 0.0) {
                        lllllllllllllllIIIllllIIIlllllII -= lllllllllllllllIIIllllIIlIllIlII;
                    }
                    else {
                        lllllllllllllllIIIllllIIIlllllII += lllllllllllllllIIIllllIIlIllIlII;
                    }
                    lllllllllllllllIIIllllIIlIllIllI = lllllllllllllllIIIllllIIIlllllII;
                }
                while (lllllllllllllllIIIllllIIlIlllllI != 0.0 && lllllllllllllllIIIllllIIIlllllII != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(lllllllllllllllIIIllllIIlIlllllI, -1.0, lllllllllllllllIIIllllIIIlllllII)).isEmpty()) {
                    if (lllllllllllllllIIIllllIIlIlllllI < lllllllllllllllIIIllllIIlIllIlII && lllllllllllllllIIIllllIIlIlllllI >= -lllllllllllllllIIIllllIIlIllIlII) {
                        lllllllllllllllIIIllllIIlIlllllI = 0.0;
                    }
                    else if (lllllllllllllllIIIllllIIlIlllllI > 0.0) {
                        lllllllllllllllIIIllllIIlIlllllI -= lllllllllllllllIIIllllIIlIllIlII;
                    }
                    else {
                        lllllllllllllllIIIllllIIlIlllllI += lllllllllllllllIIIllllIIlIllIlII;
                    }
                    lllllllllllllllIIIllllIIlIlllIII = lllllllllllllllIIIllllIIlIlllllI;
                    if (lllllllllllllllIIIllllIIIlllllII < lllllllllllllllIIIllllIIlIllIlII && lllllllllllllllIIIllllIIIlllllII >= -lllllllllllllllIIIllllIIlIllIlII) {
                        lllllllllllllllIIIllllIIIlllllII = 0.0;
                    }
                    else if (lllllllllllllllIIIllllIIIlllllII > 0.0) {
                        lllllllllllllllIIIllllIIIlllllII -= lllllllllllllllIIIllllIIlIllIlII;
                    }
                    else {
                        lllllllllllllllIIIllllIIIlllllII += lllllllllllllllIIIllllIIlIllIlII;
                    }
                    lllllllllllllllIIIllllIIlIllIllI = lllllllllllllllIIIllllIIIlllllII;
                }
            }
            final List lllllllllllllllIIIllllIIlIllIIll = this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().addCoord(lllllllllllllllIIIllllIIlIlllllI, lllllllllllllllIIIllllIIlIllllIl, lllllllllllllllIIIllllIIIlllllII));
            final AxisAlignedBB lllllllllllllllIIIllllIIlIllIIlI = this.getEntityBoundingBox();
            for (final AxisAlignedBB lllllllllllllllIIIllllIIlIllIIIl : lllllllllllllllIIIllllIIlIllIIll) {
                lllllllllllllllIIIllllIIlIllllIl = lllllllllllllllIIIllllIIlIllIIIl.calculateYOffset(this.getEntityBoundingBox(), lllllllllllllllIIIllllIIlIllllIl);
            }
            this.func_174826_a(this.getEntityBoundingBox().offset(0.0, lllllllllllllllIIIllllIIlIllllIl, 0.0));
            final boolean lllllllllllllllIIIllllIIlIlIllll = this.onGround || (lllllllllllllllIIIllllIIlIllIlll != lllllllllllllllIIIllllIIlIllllIl && lllllllllllllllIIIllllIIlIllIlll < 0.0);
            for (final AxisAlignedBB lllllllllllllllIIIllllIIlIlIlllI : lllllllllllllllIIIllllIIlIllIIll) {
                lllllllllllllllIIIllllIIlIlllllI = lllllllllllllllIIIllllIIlIlIlllI.calculateXOffset(this.getEntityBoundingBox(), lllllllllllllllIIIllllIIlIlllllI);
            }
            this.func_174826_a(this.getEntityBoundingBox().offset(lllllllllllllllIIIllllIIlIlllllI, 0.0, 0.0));
            for (final AxisAlignedBB lllllllllllllllIIIllllIIlIlIllIl : lllllllllllllllIIIllllIIlIllIIll) {
                lllllllllllllllIIIllllIIIlllllII = lllllllllllllllIIIllllIIlIlIllIl.calculateZOffset(this.getEntityBoundingBox(), lllllllllllllllIIIllllIIIlllllII);
            }
            this.func_174826_a(this.getEntityBoundingBox().offset(0.0, 0.0, lllllllllllllllIIIllllIIIlllllII));
            if (this.stepHeight > 0.0f && lllllllllllllllIIIllllIIlIlIllll && (lllllllllllllllIIIllllIIlIlllIII != lllllllllllllllIIIllllIIlIlllllI || lllllllllllllllIIIllllIIlIllIllI != lllllllllllllllIIIllllIIIlllllII)) {
                final double lllllllllllllllIIIllllIIlIlIlIll = lllllllllllllllIIIllllIIlIlllllI;
                final double lllllllllllllllIIIllllIIlIlIlIlI = lllllllllllllllIIIllllIIlIllllIl;
                final double lllllllllllllllIIIllllIIlIlIlIIl = lllllllllllllllIIIllllIIIlllllII;
                final AxisAlignedBB lllllllllllllllIIIllllIIlIlIlIII = this.getEntityBoundingBox();
                this.func_174826_a(lllllllllllllllIIIllllIIlIllIIlI);
                lllllllllllllllIIIllllIIlIllllIl = this.stepHeight;
                final List lllllllllllllllIIIllllIIlIlIIlll = this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().addCoord(lllllllllllllllIIIllllIIlIlllIII, lllllllllllllllIIIllllIIlIllllIl, lllllllllllllllIIIllllIIlIllIllI));
                AxisAlignedBB lllllllllllllllIIIllllIIlIlIIllI = this.getEntityBoundingBox();
                final AxisAlignedBB lllllllllllllllIIIllllIIlIlIIlIl = lllllllllllllllIIIllllIIlIlIIllI.addCoord(lllllllllllllllIIIllllIIlIlllIII, 0.0, lllllllllllllllIIIllllIIlIllIllI);
                double lllllllllllllllIIIllllIIlIlIIlII = lllllllllllllllIIIllllIIlIllllIl;
                for (final AxisAlignedBB lllllllllllllllIIIllllIIlIlIIIll : lllllllllllllllIIIllllIIlIlIIlll) {
                    lllllllllllllllIIIllllIIlIlIIlII = lllllllllllllllIIIllllIIlIlIIIll.calculateYOffset(lllllllllllllllIIIllllIIlIlIIlIl, lllllllllllllllIIIllllIIlIlIIlII);
                }
                lllllllllllllllIIIllllIIlIlIIllI = lllllllllllllllIIIllllIIlIlIIllI.offset(0.0, lllllllllllllllIIIllllIIlIlIIlII, 0.0);
                double lllllllllllllllIIIllllIIlIlIIIIl = lllllllllllllllIIIllllIIlIlllIII;
                for (final AxisAlignedBB lllllllllllllllIIIllllIIlIlIIIII : lllllllllllllllIIIllllIIlIlIIlll) {
                    lllllllllllllllIIIllllIIlIlIIIIl = lllllllllllllllIIIllllIIlIlIIIII.calculateXOffset(lllllllllllllllIIIllllIIlIlIIllI, lllllllllllllllIIIllllIIlIlIIIIl);
                }
                lllllllllllllllIIIllllIIlIlIIllI = lllllllllllllllIIIllllIIlIlIIllI.offset(lllllllllllllllIIIllllIIlIlIIIIl, 0.0, 0.0);
                double lllllllllllllllIIIllllIIlIIllllI = lllllllllllllllIIIllllIIlIllIllI;
                for (final AxisAlignedBB lllllllllllllllIIIllllIIlIIlllIl : lllllllllllllllIIIllllIIlIlIIlll) {
                    lllllllllllllllIIIllllIIlIIllllI = lllllllllllllllIIIllllIIlIIlllIl.calculateZOffset(lllllllllllllllIIIllllIIlIlIIllI, lllllllllllllllIIIllllIIlIIllllI);
                }
                lllllllllllllllIIIllllIIlIlIIllI = lllllllllllllllIIIllllIIlIlIIllI.offset(0.0, 0.0, lllllllllllllllIIIllllIIlIIllllI);
                AxisAlignedBB lllllllllllllllIIIllllIIlIIllIll = this.getEntityBoundingBox();
                double lllllllllllllllIIIllllIIlIIllIlI = lllllllllllllllIIIllllIIlIllllIl;
                for (final AxisAlignedBB lllllllllllllllIIIllllIIlIIllIIl : lllllllllllllllIIIllllIIlIlIIlll) {
                    lllllllllllllllIIIllllIIlIIllIlI = lllllllllllllllIIIllllIIlIIllIIl.calculateYOffset(lllllllllllllllIIIllllIIlIIllIll, lllllllllllllllIIIllllIIlIIllIlI);
                }
                lllllllllllllllIIIllllIIlIIllIll = lllllllllllllllIIIllllIIlIIllIll.offset(0.0, lllllllllllllllIIIllllIIlIIllIlI, 0.0);
                double lllllllllllllllIIIllllIIlIIlIlll = lllllllllllllllIIIllllIIlIlllIII;
                for (final AxisAlignedBB lllllllllllllllIIIllllIIlIIlIllI : lllllllllllllllIIIllllIIlIlIIlll) {
                    lllllllllllllllIIIllllIIlIIlIlll = lllllllllllllllIIIllllIIlIIlIllI.calculateXOffset(lllllllllllllllIIIllllIIlIIllIll, lllllllllllllllIIIllllIIlIIlIlll);
                }
                lllllllllllllllIIIllllIIlIIllIll = lllllllllllllllIIIllllIIlIIllIll.offset(lllllllllllllllIIIllllIIlIIlIlll, 0.0, 0.0);
                double lllllllllllllllIIIllllIIlIIlIlII = lllllllllllllllIIIllllIIlIllIllI;
                for (final AxisAlignedBB lllllllllllllllIIIllllIIlIIlIIll : lllllllllllllllIIIllllIIlIlIIlll) {
                    lllllllllllllllIIIllllIIlIIlIlII = lllllllllllllllIIIllllIIlIIlIIll.calculateZOffset(lllllllllllllllIIIllllIIlIIllIll, lllllllllllllllIIIllllIIlIIlIlII);
                }
                lllllllllllllllIIIllllIIlIIllIll = lllllllllllllllIIIllllIIlIIllIll.offset(0.0, 0.0, lllllllllllllllIIIllllIIlIIlIlII);
                final double lllllllllllllllIIIllllIIlIIlIIIl = lllllllllllllllIIIllllIIlIlIIIIl * lllllllllllllllIIIllllIIlIlIIIIl + lllllllllllllllIIIllllIIlIIllllI * lllllllllllllllIIIllllIIlIIllllI;
                final double lllllllllllllllIIIllllIIlIIlIIII = lllllllllllllllIIIllllIIlIIlIlll * lllllllllllllllIIIllllIIlIIlIlll + lllllllllllllllIIIllllIIlIIlIlII * lllllllllllllllIIIllllIIlIIlIlII;
                if (lllllllllllllllIIIllllIIlIIlIIIl > lllllllllllllllIIIllllIIlIIlIIII) {
                    lllllllllllllllIIIllllIIlIlllllI = lllllllllllllllIIIllllIIlIlIIIIl;
                    lllllllllllllllIIIllllIIIlllllII = lllllllllllllllIIIllllIIlIIllllI;
                    this.func_174826_a(lllllllllllllllIIIllllIIlIlIIllI);
                }
                else {
                    lllllllllllllllIIIllllIIlIlllllI = lllllllllllllllIIIllllIIlIIlIlll;
                    lllllllllllllllIIIllllIIIlllllII = lllllllllllllllIIIllllIIlIIlIlII;
                    this.func_174826_a(lllllllllllllllIIIllllIIlIIllIll);
                }
                lllllllllllllllIIIllllIIlIllllIl = -this.stepHeight;
                for (final AxisAlignedBB lllllllllllllllIIIllllIIlIIIllll : lllllllllllllllIIIllllIIlIlIIlll) {
                    lllllllllllllllIIIllllIIlIllllIl = lllllllllllllllIIIllllIIlIIIllll.calculateYOffset(this.getEntityBoundingBox(), lllllllllllllllIIIllllIIlIllllIl);
                }
                this.func_174826_a(this.getEntityBoundingBox().offset(0.0, lllllllllllllllIIIllllIIlIllllIl, 0.0));
                if (lllllllllllllllIIIllllIIlIlIlIll * lllllllllllllllIIIllllIIlIlIlIll + lllllllllllllllIIIllllIIlIlIlIIl * lllllllllllllllIIIllllIIlIlIlIIl >= lllllllllllllllIIIllllIIlIlllllI * lllllllllllllllIIIllllIIlIlllllI + lllllllllllllllIIIllllIIIlllllII * lllllllllllllllIIIllllIIIlllllII) {
                    lllllllllllllllIIIllllIIlIlllllI = lllllllllllllllIIIllllIIlIlIlIll;
                    lllllllllllllllIIIllllIIlIllllIl = lllllllllllllllIIIllllIIlIlIlIlI;
                    lllllllllllllllIIIllllIIIlllllII = lllllllllllllllIIIllllIIlIlIlIIl;
                    this.func_174826_a(lllllllllllllllIIIllllIIlIlIlIII);
                }
            }
            this.worldObj.theProfiler.endSection();
            this.worldObj.theProfiler.startSection("rest");
            this.func_174829_m();
            this.isCollidedHorizontally = (lllllllllllllllIIIllllIIlIlllIII != lllllllllllllllIIIllllIIlIlllllI || lllllllllllllllIIIllllIIlIllIllI != lllllllllllllllIIIllllIIIlllllII);
            this.isCollidedVertically = (lllllllllllllllIIIllllIIlIllIlll != lllllllllllllllIIIllllIIlIllllIl);
            this.onGround = (this.isCollidedVertically && lllllllllllllllIIIllllIIlIllIlll < 0.0);
            this.isCollided = (this.isCollidedHorizontally || this.isCollidedVertically);
            final int lllllllllllllllIIIllllIIlIIIllIl = MathHelper.floor_double(this.posX);
            final int lllllllllllllllIIIllllIIlIIIllII = MathHelper.floor_double(this.posY - 0.20000000298023224);
            final int lllllllllllllllIIIllllIIlIIIlIll = MathHelper.floor_double(this.posZ);
            BlockPos lllllllllllllllIIIllllIIlIIIlIlI = new BlockPos(lllllllllllllllIIIllllIIlIIIllIl, lllllllllllllllIIIllllIIlIIIllII, lllllllllllllllIIIllllIIlIIIlIll);
            Block lllllllllllllllIIIllllIIlIIIlIIl = this.worldObj.getBlockState(lllllllllllllllIIIllllIIlIIIlIlI).getBlock();
            if (lllllllllllllllIIIllllIIlIIIlIIl.getMaterial() == Material.air) {
                final Block lllllllllllllllIIIllllIIlIIIlIII = this.worldObj.getBlockState(lllllllllllllllIIIllllIIlIIIlIlI.offsetDown()).getBlock();
                if (lllllllllllllllIIIllllIIlIIIlIII instanceof BlockFence || lllllllllllllllIIIllllIIlIIIlIII instanceof BlockWall || lllllllllllllllIIIllllIIlIIIlIII instanceof BlockFenceGate) {
                    lllllllllllllllIIIllllIIlIIIlIIl = lllllllllllllllIIIllllIIlIIIlIII;
                    lllllllllllllllIIIllllIIlIIIlIlI = lllllllllllllllIIIllllIIlIIIlIlI.offsetDown();
                }
            }
            this.func_180433_a(lllllllllllllllIIIllllIIlIllllIl, this.onGround, lllllllllllllllIIIllllIIlIIIlIIl, lllllllllllllllIIIllllIIlIIIlIlI);
            if (lllllllllllllllIIIllllIIlIlllIII != lllllllllllllllIIIllllIIlIlllllI) {
                this.motionX = 0.0;
            }
            if (lllllllllllllllIIIllllIIlIllIllI != lllllllllllllllIIIllllIIIlllllII) {
                this.motionZ = 0.0;
            }
            if (lllllllllllllllIIIllllIIlIllIlll != lllllllllllllllIIIllllIIlIllllIl) {
                lllllllllllllllIIIllllIIlIIIlIIl.onLanded(this.worldObj, this);
            }
            if (this.canTriggerWalking() && !lllllllllllllllIIIllllIIlIllIlIl && this.ridingEntity == null) {
                final double lllllllllllllllIIIllllIIlIIIIlll = this.posX - lllllllllllllllIIIllllIIlIlllIll;
                double lllllllllllllllIIIllllIIlIIIIllI = this.posY - lllllllllllllllIIIllllIIlIlllIlI;
                final double lllllllllllllllIIIllllIIlIIIIlIl = this.posZ - lllllllllllllllIIIllllIIlIlllIIl;
                if (lllllllllllllllIIIllllIIlIIIlIIl != Blocks.ladder) {
                    lllllllllllllllIIIllllIIlIIIIllI = 0.0;
                }
                if (lllllllllllllllIIIllllIIlIIIlIIl != null && this.onGround) {
                    lllllllllllllllIIIllllIIlIIIlIIl.onEntityCollidedWithBlock(this.worldObj, lllllllllllllllIIIllllIIlIIIlIlI, this);
                }
                this.distanceWalkedModified += (float)(MathHelper.sqrt_double(lllllllllllllllIIIllllIIlIIIIlll * lllllllllllllllIIIllllIIlIIIIlll + lllllllllllllllIIIllllIIlIIIIlIl * lllllllllllllllIIIllllIIlIIIIlIl) * 0.6);
                this.distanceWalkedOnStepModified += (float)(MathHelper.sqrt_double(lllllllllllllllIIIllllIIlIIIIlll * lllllllllllllllIIIllllIIlIIIIlll + lllllllllllllllIIIllllIIlIIIIllI * lllllllllllllllIIIllllIIlIIIIllI + lllllllllllllllIIIllllIIlIIIIlIl * lllllllllllllllIIIllllIIlIIIIlIl) * 0.6);
                if (this.distanceWalkedOnStepModified > this.nextStepDistance && lllllllllllllllIIIllllIIlIIIlIIl.getMaterial() != Material.air) {
                    this.nextStepDistance = (int)this.distanceWalkedOnStepModified + 1;
                    if (this.isInWater()) {
                        float lllllllllllllllIIIllllIIlIIIIlII = MathHelper.sqrt_double(this.motionX * this.motionX * 0.20000000298023224 + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224) * 0.35f;
                        if (lllllllllllllllIIIllllIIlIIIIlII > 1.0f) {
                            lllllllllllllllIIIllllIIlIIIIlII = 1.0f;
                        }
                        this.playSound(this.getSwimSound(), lllllllllllllllIIIllllIIlIIIIlII, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                    }
                    this.func_180429_a(lllllllllllllllIIIllllIIlIIIlIlI, lllllllllllllllIIIllllIIlIIIlIIl);
                }
            }
            try {
                this.doBlockCollisions();
            }
            catch (Throwable lllllllllllllllIIIllllIIlIIIIIll) {
                final CrashReport lllllllllllllllIIIllllIIlIIIIIlI = CrashReport.makeCrashReport(lllllllllllllllIIIllllIIlIIIIIll, "Checking entity block collision");
                final CrashReportCategory lllllllllllllllIIIllllIIlIIIIIIl = lllllllllllllllIIIllllIIlIIIIIlI.makeCategory("Entity being checked for collision");
                this.addEntityCrashInfo(lllllllllllllllIIIllllIIlIIIIIIl);
                throw new ReportedException(lllllllllllllllIIIllllIIlIIIIIlI);
            }
            final boolean lllllllllllllllIIIllllIIlIIIIIII = this.isWet();
            if (this.worldObj.func_147470_e(this.getEntityBoundingBox().contract(0.001, 0.001, 0.001))) {
                this.dealFireDamage(1);
                if (!lllllllllllllllIIIllllIIlIIIIIII) {
                    ++this.fire;
                    if (this.fire == 0) {
                        this.setFire(8);
                    }
                }
            }
            else if (this.fire <= 0) {
                this.fire = -this.fireResistance;
            }
            if (lllllllllllllllIIIllllIIlIIIIIII && this.fire > 0) {
                this.playSound("random.fizz", 0.7f, 1.6f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                this.fire = -this.fireResistance;
            }
            this.worldObj.theProfiler.endSection();
        }
    }
    
    public void func_174810_b(final boolean lllllllllllllllIIIllllIIIIIIllll) {
        this.dataWatcher.updateObject(4, (byte)(byte)(lllllllllllllllIIIllllIIIIIIllll ? 1 : 0));
    }
    
    public boolean isOffsetPositionInLiquid(final double lllllllllllllllIIIllllIIlllllIll, final double lllllllllllllllIIIllllIIllllIlIl, final double lllllllllllllllIIIllllIIlllllIIl) {
        final AxisAlignedBB lllllllllllllllIIIllllIIlllllIII = this.getEntityBoundingBox().offset(lllllllllllllllIIIllllIIlllllIll, lllllllllllllllIIIllllIIllllIlIl, lllllllllllllllIIIllllIIlllllIIl);
        return this.func_174809_b(lllllllllllllllIIIllllIIlllllIII);
    }
    
    public void updateRidden() {
        if (this.ridingEntity.isDead) {
            this.ridingEntity = null;
        }
        else {
            this.motionX = 0.0;
            this.motionY = 0.0;
            this.motionZ = 0.0;
            this.onUpdate();
            if (this.ridingEntity != null) {
                this.ridingEntity.updateRiderPosition();
                this.entityRiderYawDelta += this.ridingEntity.rotationYaw - this.ridingEntity.prevRotationYaw;
                this.entityRiderPitchDelta += this.ridingEntity.rotationPitch - this.ridingEntity.prevRotationPitch;
                while (this.entityRiderYawDelta >= 180.0) {
                    this.entityRiderYawDelta -= 360.0;
                }
                while (this.entityRiderYawDelta < -180.0) {
                    this.entityRiderYawDelta += 360.0;
                }
                while (this.entityRiderPitchDelta >= 180.0) {
                    this.entityRiderPitchDelta -= 360.0;
                }
                while (this.entityRiderPitchDelta < -180.0) {
                    this.entityRiderPitchDelta += 360.0;
                }
                double lllllllllllllllIIIlllIIIlIlIlIII = this.entityRiderYawDelta * 0.5;
                double lllllllllllllllIIIlllIIIlIlIIlll = this.entityRiderPitchDelta * 0.5;
                final float lllllllllllllllIIIlllIIIlIlIIllI = 10.0f;
                if (lllllllllllllllIIIlllIIIlIlIlIII > lllllllllllllllIIIlllIIIlIlIIllI) {
                    lllllllllllllllIIIlllIIIlIlIlIII = lllllllllllllllIIIlllIIIlIlIIllI;
                }
                if (lllllllllllllllIIIlllIIIlIlIlIII < -lllllllllllllllIIIlllIIIlIlIIllI) {
                    lllllllllllllllIIIlllIIIlIlIlIII = -lllllllllllllllIIIlllIIIlIlIIllI;
                }
                if (lllllllllllllllIIIlllIIIlIlIIlll > lllllllllllllllIIIlllIIIlIlIIllI) {
                    lllllllllllllllIIIlllIIIlIlIIlll = lllllllllllllllIIIlllIIIlIlIIllI;
                }
                if (lllllllllllllllIIIlllIIIlIlIIlll < -lllllllllllllllIIIlllIIIlIlIIllI) {
                    lllllllllllllllIIIlllIIIlIlIIlll = -lllllllllllllllIIIlllIIIlIlIIllI;
                }
                this.entityRiderYawDelta -= lllllllllllllllIIIlllIIIlIlIlIII;
                this.entityRiderPitchDelta -= lllllllllllllllIIIlllIIIlIlIIlll;
            }
        }
    }
    
    public boolean hasCustomName() {
        return this.dataWatcher.getWatchableObjectString(2).length() > 0;
    }
    
    protected boolean shouldSetPosAfterLoading() {
        return true;
    }
    
    public void addToPlayerScore(final Entity lllllllllllllllIIIlllIlIIllIllII, final int lllllllllllllllIIIlllIlIIllIlIll) {
    }
    
    public void setEntityId(final int lllllllllllllllIIIllllIlIlllIllI) {
        this.entityId = lllllllllllllllIIIllllIlIlllIllI;
    }
    
    protected void dealFireDamage(final int lllllllllllllllIIIlllIllllllIllI) {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.inFire, (float)lllllllllllllllIIIlllIllllllIllI);
        }
    }
    
    protected void resetHeight() {
        float lllllllllllllllIIIlllIllllIllIIl = MathHelper.sqrt_double(this.motionX * this.motionX * 0.20000000298023224 + this.motionY * this.motionY + this.motionZ * this.motionZ * 0.20000000298023224) * 0.2f;
        if (lllllllllllllllIIIlllIllllIllIIl > 1.0f) {
            lllllllllllllllIIIlllIllllIllIIl = 1.0f;
        }
        this.playSound(this.getSplashSound(), lllllllllllllllIIIlllIllllIllIIl, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
        final float lllllllllllllllIIIlllIllllIllIII = (float)MathHelper.floor_double(this.getEntityBoundingBox().minY);
        for (int lllllllllllllllIIIlllIllllIlIlll = 0; lllllllllllllllIIIlllIllllIlIlll < 1.0f + this.width * 20.0f; ++lllllllllllllllIIIlllIllllIlIlll) {
            final float lllllllllllllllIIIlllIllllIlIllI = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            final float lllllllllllllllIIIlllIllllIlIlII = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + lllllllllllllllIIIlllIllllIlIllI, lllllllllllllllIIIlllIllllIllIII + 1.0f, this.posZ + lllllllllllllllIIIlllIllllIlIlII, this.motionX, this.motionY - this.rand.nextFloat() * 0.2f, this.motionZ, new int[0]);
        }
        for (int lllllllllllllllIIIlllIllllIlIlll = 0; lllllllllllllllIIIlllIllllIlIlll < 1.0f + this.width * 20.0f; ++lllllllllllllllIIIlllIllllIlIlll) {
            final float lllllllllllllllIIIlllIllllIlIlIl = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            final float lllllllllllllllIIIlllIllllIlIIll = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + lllllllllllllllIIIlllIllllIlIlIl, lllllllllllllllIIIlllIllllIllIII + 1.0f, this.posZ + lllllllllllllllIIIlllIllllIlIIll, this.motionX, this.motionY, this.motionZ, new int[0]);
        }
    }
    
    public void func_145781_i(final int lllllllllllllllIIIllIlllIlIIIlII) {
    }
    
    protected void func_174815_a(final EntityLivingBase lllllllllllllllIIIllIllIlllIllIl, final Entity lllllllllllllllIIIllIllIlllIlllI) {
        if (lllllllllllllllIIIllIllIlllIlllI instanceof EntityLivingBase) {
            EnchantmentHelper.func_151384_a((EntityLivingBase)lllllllllllllllIIIllIllIlllIlllI, lllllllllllllllIIIllIllIlllIllIl);
        }
        EnchantmentHelper.func_151385_b(lllllllllllllllIIIllIllIlllIllIl, lllllllllllllllIIIllIllIlllIlllI);
    }
    
    public CommandResultStats func_174807_aT() {
        return this.field_174837_as;
    }
    
    public void setPositionAndRotation(final double lllllllllllllllIIIlllIllIlIlIIIl, final double lllllllllllllllIIIlllIllIlIlIlll, final double lllllllllllllllIIIlllIllIlIlIllI, final float lllllllllllllllIIIlllIllIlIlIlIl, final float lllllllllllllllIIIlllIllIlIlIlII) {
        this.posX = lllllllllllllllIIIlllIllIlIlIIIl;
        this.prevPosX = lllllllllllllllIIIlllIllIlIlIIIl;
        this.posY = lllllllllllllllIIIlllIllIlIlIlll;
        this.prevPosY = lllllllllllllllIIIlllIllIlIlIlll;
        this.posZ = lllllllllllllllIIIlllIllIlIlIllI;
        this.prevPosZ = lllllllllllllllIIIlllIllIlIlIllI;
        this.rotationYaw = lllllllllllllllIIIlllIllIlIlIlIl;
        this.prevRotationYaw = lllllllllllllllIIIlllIllIlIlIlIl;
        this.rotationPitch = lllllllllllllllIIIlllIllIlIlIlII;
        this.prevRotationPitch = lllllllllllllllIIIlllIllIlIlIlII;
        final double lllllllllllllllIIIlllIllIlIlIIll = this.prevRotationYaw - lllllllllllllllIIIlllIllIlIlIlIl;
        if (lllllllllllllllIIIlllIllIlIlIIll < -180.0) {
            this.prevRotationYaw += 360.0f;
        }
        if (lllllllllllllllIIIlllIllIlIlIIll >= 180.0) {
            this.prevRotationYaw -= 360.0f;
        }
        this.setPosition(this.posX, this.posY, this.posZ);
        this.setRotation(lllllllllllllllIIIlllIllIlIlIlIl, lllllllllllllllIIIlllIllIlIlIlII);
    }
    
    public Vec3 getLook(final float lllllllllllllllIIIlllIlIlIlIlIlI) {
        if (lllllllllllllllIIIlllIlIlIlIlIlI == 1.0f) {
            return this.func_174806_f(this.rotationPitch, this.rotationYaw);
        }
        final float lllllllllllllllIIIlllIlIlIlIlIIl = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * lllllllllllllllIIIlllIlIlIlIlIlI;
        final float lllllllllllllllIIIlllIlIlIlIlIII = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * lllllllllllllllIIIlllIlIlIlIlIlI;
        return this.func_174806_f(lllllllllllllllIIIlllIlIlIlIlIIl, lllllllllllllllIIIlllIlIlIlIlIII);
    }
    
    public void setAlwaysRenderNameTag(final boolean lllllllllllllllIIIllIlllIlIllIII) {
        this.dataWatcher.updateObject(3, (byte)(byte)(lllllllllllllllIIIllIlllIlIllIII ? 1 : 0));
    }
    
    public boolean writeMountToNBT(final NBTTagCompound lllllllllllllllIIIlllIlIIlIIIlIl) {
        final String lllllllllllllllIIIlllIlIIlIIIlII = this.getEntityString();
        if (!this.isDead && lllllllllllllllIIIlllIlIIlIIIlII != null) {
            lllllllllllllllIIIlllIlIIlIIIlIl.setString("id", lllllllllllllllIIIlllIlIIlIIIlII);
            this.writeToNBT(lllllllllllllllIIIlllIlIIlIIIlIl);
            return true;
        }
        return false;
    }
    
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIIIlllIlIlIllIIII, final float lllllllllllllllIIIlllIlIlIllIIlI) {
        if (this.func_180431_b(lllllllllllllllIIIlllIlIlIllIIII)) {
            return false;
        }
        this.setBeenAttacked();
        return false;
    }
    
    public int getPortalCooldown() {
        return 300;
    }
    
    public void setInvisible(final boolean lllllllllllllllIIIlllIIIIIlIIlll) {
        this.setFlag(5, lllllllllllllllIIIlllIIIIIlIIlll);
    }
    
    @Override
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        }
        String lllllllllllllllIIIllIlllllIlIIII = EntityList.getEntityString(this);
        if (lllllllllllllllIIIllIlllllIlIIII == null) {
            lllllllllllllllIIIllIlllllIlIIII = "generic";
        }
        return StatCollector.translateToLocal(String.valueOf(new StringBuilder("entity.").append(lllllllllllllllIIIllIlllllIlIIII).append(".name")));
    }
    
    public void setInPortal() {
        if (this.timeUntilPortal > 0) {
            this.timeUntilPortal = this.getPortalCooldown();
        }
        else {
            final double lllllllllllllllIIIlllIIIIllIlIlI = this.prevPosX - this.posX;
            final double lllllllllllllllIIIlllIIIIllIlIIl = this.prevPosZ - this.posZ;
            if (!this.worldObj.isRemote && !this.inPortal) {
                int lllllllllllllllIIIlllIIIIllIIlll = 0;
                if (MathHelper.abs((float)lllllllllllllllIIIlllIIIIllIlIlI) > MathHelper.abs((float)lllllllllllllllIIIlllIIIIllIlIIl)) {
                    final int lllllllllllllllIIIlllIIIIllIlIII = (lllllllllllllllIIIlllIIIIllIlIlI > 0.0) ? EnumFacing.WEST.getHorizontalIndex() : EnumFacing.EAST.getHorizontalIndex();
                }
                else {
                    lllllllllllllllIIIlllIIIIllIIlll = ((lllllllllllllllIIIlllIIIIllIlIIl > 0.0) ? EnumFacing.NORTH.getHorizontalIndex() : EnumFacing.SOUTH.getHorizontalIndex());
                }
                this.teleportDirection = lllllllllllllllIIIlllIIIIllIIlll;
            }
            this.inPortal = true;
        }
    }
    
    public DataWatcher getDataWatcher() {
        return this.dataWatcher;
    }
    
    @Override
    public void func_174794_a(final CommandResultStats.Type lllllllllllllllIIIllIlllIIIIIlII, final int lllllllllllllllIIIllIlllIIIIIIll) {
        this.field_174837_as.func_179672_a(this, lllllllllllllllIIIllIlllIIIIIlII, lllllllllllllllIIIllIlllIIIIIIll);
    }
    
    protected String getSwimSound() {
        return "game.neutral.swim";
    }
    
    public boolean func_174825_a(final EntityPlayer lllllllllllllllIIIllIllIllllIlIl, final Vec3 lllllllllllllllIIIllIllIllllIlII) {
        return false;
    }
    
    public float getEyeHeight() {
        return this.height * 0.85f;
    }
    
    public void setVelocity(final double lllllllllllllllIIIlllIIIIlIllIII, final double lllllllllllllllIIIlllIIIIlIllIll, final double lllllllllllllllIIIlllIIIIlIlIllI) {
        this.motionX = lllllllllllllllIIIlllIIIIlIllIII;
        this.motionY = lllllllllllllllIIIlllIIIIlIllIll;
        this.motionZ = lllllllllllllllIIIlllIIIIlIlIllI;
    }
    
    public double getDistanceSq(final BlockPos lllllllllllllllIIIlllIllIIIIIllI) {
        return lllllllllllllllIIIlllIllIIIIIllI.distanceSq(this.posX, this.posY, this.posZ);
    }
    
    public ItemStack[] getInventory() {
        return null;
    }
    
    public int getMaxInPortalTime() {
        return 0;
    }
    
    public boolean isWet() {
        return this.inWater || this.worldObj.func_175727_C(new BlockPos(this.posX, this.posY, this.posZ)) || this.worldObj.func_175727_C(new BlockPos(this.posX, this.posY + this.height, this.posZ));
    }
    
    public void onKillEntity(final EntityLivingBase lllllllllllllllIIIllIllllllllIll) {
    }
    
    public boolean isInWater() {
        return this.inWater;
    }
    
    public double func_174831_c(final BlockPos lllllllllllllllIIIlllIllIIIIIIII) {
        return lllllllllllllllIIIlllIllIIIIIIII.distanceSqToCenter(this.posX, this.posY, this.posZ);
    }
    
    public boolean func_174820_d(final int lllllllllllllllIIIllIlllIIIlllll, final ItemStack lllllllllllllllIIIllIlllIIIllllI) {
        return false;
    }
    
    public float getExplosionResistance(final Explosion lllllllllllllllIIIllIllllIIIllIl, final World lllllllllllllllIIIllIllllIIIllII, final BlockPos lllllllllllllllIIIllIllllIIIlIll, final IBlockState lllllllllllllllIIIllIllllIIIlIlI) {
        return lllllllllllllllIIIllIllllIIIlIlI.getBlock().getExplosionResistance(this);
    }
    
    public boolean isInRangeToRenderDist(final double lllllllllllllllIIIlllIlIIlIIlIll) {
        double lllllllllllllllIIIlllIlIIlIIllIl = this.getEntityBoundingBox().getAverageEdgeLength();
        lllllllllllllllIIIlllIlIIlIIllIl *= 64.0 * this.renderDistanceWeight;
        return lllllllllllllllIIIlllIlIIlIIlIll < lllllllllllllllIIIlllIlIIlIIllIl * lllllllllllllllIIIlllIlIIlIIllIl;
    }
    
    public void addEntityCrashInfo(final CrashReportCategory lllllllllllllllIIIllIlllIllllIIl) {
        lllllllllllllllIIIllIlllIllllIIl.addCrashSectionCallable("Entity Type", new Callable() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(EntityList.getEntityString(Entity.this))).append(" (").append(Entity.this.getClass().getCanonicalName()).append(")"));
            }
            
            static {
                __OBFID = "CL_00001534";
            }
        });
        lllllllllllllllIIIllIlllIllllIIl.addCrashSection("Entity ID", this.entityId);
        lllllllllllllllIIIllIlllIllllIIl.addCrashSectionCallable("Entity Name", new Callable() {
            @Override
            public String call() {
                return Entity.this.getName();
            }
            
            static {
                __OBFID = "CL_00001535";
            }
        });
        lllllllllllllllIIIllIlllIllllIIl.addCrashSection("Entity's Exact location", String.format("%.2f, %.2f, %.2f", this.posX, this.posY, this.posZ));
        lllllllllllllllIIIllIlllIllllIIl.addCrashSection("Entity's Block location", CrashReportCategory.getCoordinateInfo(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)));
        lllllllllllllllIIIllIlllIllllIIl.addCrashSection("Entity's Momentum", String.format("%.2f, %.2f, %.2f", this.motionX, this.motionY, this.motionZ));
        lllllllllllllllIIIllIlllIllllIIl.addCrashSectionCallable("Entity's Rider", new Callable() {
            public String func_180118_a() {
                return Entity.this.riddenByEntity.toString();
            }
            
            @Override
            public Object call() {
                return this.func_180118_a();
            }
            
            static {
                __OBFID = "CL_00002259";
            }
        });
        lllllllllllllllIIIllIlllIllllIIl.addCrashSectionCallable("Entity's Vehicle", new Callable() {
            static {
                __OBFID = "CL_00002258";
            }
            
            public String func_180116_a() {
                return Entity.this.ridingEntity.toString();
            }
            
            @Override
            public Object call() {
                return this.func_180116_a();
            }
        });
    }
    
    public boolean isOutsideBorder() {
        return this.isOutsideBorder;
    }
    
    public boolean isPushedByWater() {
        return true;
    }
    
    public Entity[] getParts() {
        return null;
    }
    
    public NBTTagCompound func_174819_aU() {
        return null;
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX, this.posY + 0.5, this.posZ);
    }
    
    public int getTeleportDirection() {
        return this.teleportDirection;
    }
    
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIIlllIlIIIIllIIl) {
        try {
            final NBTTagList lllllllllllllllIIIlllIlIIIlIIIII = lllllllllllllllIIIlllIlIIIIllIIl.getTagList("Pos", 6);
            final NBTTagList lllllllllllllllIIIlllIlIIIIlllll = lllllllllllllllIIIlllIlIIIIllIIl.getTagList("Motion", 6);
            final NBTTagList lllllllllllllllIIIlllIlIIIIllllI = lllllllllllllllIIIlllIlIIIIllIIl.getTagList("Rotation", 5);
            this.motionX = lllllllllllllllIIIlllIlIIIIlllll.getDouble(0);
            this.motionY = lllllllllllllllIIIlllIlIIIIlllll.getDouble(1);
            this.motionZ = lllllllllllllllIIIlllIlIIIIlllll.getDouble(2);
            if (Math.abs(this.motionX) > 10.0) {
                this.motionX = 0.0;
            }
            if (Math.abs(this.motionY) > 10.0) {
                this.motionY = 0.0;
            }
            if (Math.abs(this.motionZ) > 10.0) {
                this.motionZ = 0.0;
            }
            final double double1 = lllllllllllllllIIIlllIlIIIlIIIII.getDouble(0);
            this.posX = double1;
            this.lastTickPosX = double1;
            this.prevPosX = double1;
            final double double2 = lllllllllllllllIIIlllIlIIIlIIIII.getDouble(1);
            this.posY = double2;
            this.lastTickPosY = double2;
            this.prevPosY = double2;
            final double double3 = lllllllllllllllIIIlllIlIIIlIIIII.getDouble(2);
            this.posZ = double3;
            this.lastTickPosZ = double3;
            this.prevPosZ = double3;
            final float float1 = lllllllllllllllIIIlllIlIIIIllllI.getFloat(0);
            this.rotationYaw = float1;
            this.prevRotationYaw = float1;
            final float float2 = lllllllllllllllIIIlllIlIIIIllllI.getFloat(1);
            this.rotationPitch = float2;
            this.prevRotationPitch = float2;
            this.fallDistance = lllllllllllllllIIIlllIlIIIIllIIl.getFloat("FallDistance");
            this.fire = lllllllllllllllIIIlllIlIIIIllIIl.getShort("Fire");
            this.setAir(lllllllllllllllIIIlllIlIIIIllIIl.getShort("Air"));
            this.onGround = lllllllllllllllIIIlllIlIIIIllIIl.getBoolean("OnGround");
            this.dimension = lllllllllllllllIIIlllIlIIIIllIIl.getInteger("Dimension");
            this.invulnerable = lllllllllllllllIIIlllIlIIIIllIIl.getBoolean("Invulnerable");
            this.timeUntilPortal = lllllllllllllllIIIlllIlIIIIllIIl.getInteger("PortalCooldown");
            if (lllllllllllllllIIIlllIlIIIIllIIl.hasKey("UUIDMost", 4) && lllllllllllllllIIIlllIlIIIIllIIl.hasKey("UUIDLeast", 4)) {
                this.entityUniqueID = new UUID(lllllllllllllllIIIlllIlIIIIllIIl.getLong("UUIDMost"), lllllllllllllllIIIlllIlIIIIllIIl.getLong("UUIDLeast"));
            }
            else if (lllllllllllllllIIIlllIlIIIIllIIl.hasKey("UUID", 8)) {
                this.entityUniqueID = UUID.fromString(lllllllllllllllIIIlllIlIIIIllIIl.getString("UUID"));
            }
            this.setPosition(this.posX, this.posY, this.posZ);
            this.setRotation(this.rotationYaw, this.rotationPitch);
            if (lllllllllllllllIIIlllIlIIIIllIIl.hasKey("CustomName", 8) && lllllllllllllllIIIlllIlIIIIllIIl.getString("CustomName").length() > 0) {
                this.setCustomNameTag(lllllllllllllllIIIlllIlIIIIllIIl.getString("CustomName"));
            }
            this.setAlwaysRenderNameTag(lllllllllllllllIIIlllIlIIIIllIIl.getBoolean("CustomNameVisible"));
            this.field_174837_as.func_179668_a(lllllllllllllllIIIlllIlIIIIllIIl);
            this.func_174810_b(lllllllllllllllIIIlllIlIIIIllIIl.getBoolean("Silent"));
            this.readEntityFromNBT(lllllllllllllllIIIlllIlIIIIllIIl);
            if (this.shouldSetPosAfterLoading()) {
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
        catch (Throwable lllllllllllllllIIIlllIlIIIIlllIl) {
            final CrashReport lllllllllllllllIIIlllIlIIIIlllII = CrashReport.makeCrashReport(lllllllllllllllIIIlllIlIIIIlllIl, "Loading entity NBT");
            final CrashReportCategory lllllllllllllllIIIlllIlIIIIllIll = lllllllllllllllIIIlllIlIIIIlllII.makeCategory("Entity being loaded");
            this.addEntityCrashInfo(lllllllllllllllIIIlllIlIIIIllIll);
            throw new ReportedException(lllllllllllllllIIIlllIlIIIIlllII);
        }
    }
    
    protected void func_180429_a(final BlockPos lllllllllllllllIIIllllIIIIlIlIII, final Block lllllllllllllllIIIllllIIIIlIIIll) {
        Block.SoundType lllllllllllllllIIIllllIIIIlIIllI = lllllllllllllllIIIllllIIIIlIIIll.stepSound;
        if (this.worldObj.getBlockState(lllllllllllllllIIIllllIIIIlIlIII.offsetUp()).getBlock() == Blocks.snow_layer) {
            lllllllllllllllIIIllllIIIIlIIllI = Blocks.snow_layer.stepSound;
            this.playSound(lllllllllllllllIIIllllIIIIlIIllI.getStepSound(), lllllllllllllllIIIllllIIIIlIIllI.getVolume() * 0.15f, lllllllllllllllIIIllllIIIIlIIllI.getFrequency());
        }
        else if (!lllllllllllllllIIIllllIIIIlIIIll.getMaterial().isLiquid()) {
            this.playSound(lllllllllllllllIIIllllIIIIlIIllI.getStepSound(), lllllllllllllllIIIllllIIIIlIIllI.getVolume() * 0.15f, lllllllllllllllIIIllllIIIIlIIllI.getFrequency());
        }
    }
    
    protected void doBlockCollisions() {
        final BlockPos lllllllllllllllIIIllllIIIlIIIIlI = new BlockPos(this.getEntityBoundingBox().minX + 0.001, this.getEntityBoundingBox().minY + 0.001, this.getEntityBoundingBox().minZ + 0.001);
        final BlockPos lllllllllllllllIIIllllIIIlIIIIIl = new BlockPos(this.getEntityBoundingBox().maxX - 0.001, this.getEntityBoundingBox().maxY - 0.001, this.getEntityBoundingBox().maxZ - 0.001);
        if (this.worldObj.isAreaLoaded(lllllllllllllllIIIllllIIIlIIIIlI, lllllllllllllllIIIllllIIIlIIIIIl)) {
            for (int lllllllllllllllIIIllllIIIlIIIIII = lllllllllllllllIIIllllIIIlIIIIlI.getX(); lllllllllllllllIIIllllIIIlIIIIII <= lllllllllllllllIIIllllIIIlIIIIIl.getX(); ++lllllllllllllllIIIllllIIIlIIIIII) {
                for (int lllllllllllllllIIIllllIIIIllllll = lllllllllllllllIIIllllIIIlIIIIlI.getY(); lllllllllllllllIIIllllIIIIllllll <= lllllllllllllllIIIllllIIIlIIIIIl.getY(); ++lllllllllllllllIIIllllIIIIllllll) {
                    for (int lllllllllllllllIIIllllIIIIlllllI = lllllllllllllllIIIllllIIIlIIIIlI.getZ(); lllllllllllllllIIIllllIIIIlllllI <= lllllllllllllllIIIllllIIIlIIIIIl.getZ(); ++lllllllllllllllIIIllllIIIIlllllI) {
                        final BlockPos lllllllllllllllIIIllllIIIIllllIl = new BlockPos(lllllllllllllllIIIllllIIIlIIIIII, lllllllllllllllIIIllllIIIIllllll, lllllllllllllllIIIllllIIIIlllllI);
                        final IBlockState lllllllllllllllIIIllllIIIIllllII = this.worldObj.getBlockState(lllllllllllllllIIIllllIIIIllllIl);
                        try {
                            lllllllllllllllIIIllllIIIIllllII.getBlock().onEntityCollidedWithBlock(this.worldObj, lllllllllllllllIIIllllIIIIllllIl, lllllllllllllllIIIllllIIIIllllII, this);
                        }
                        catch (Throwable lllllllllllllllIIIllllIIIIlllIll) {
                            final CrashReport lllllllllllllllIIIllllIIIIlllIlI = CrashReport.makeCrashReport(lllllllllllllllIIIllllIIIIlllIll, "Colliding entity with block");
                            final CrashReportCategory lllllllllllllllIIIllllIIIIlllIIl = lllllllllllllllIIIllllIIIIlllIlI.makeCategory("Block being collided with");
                            CrashReportCategory.addBlockInfo(lllllllllllllllIIIllllIIIIlllIIl, lllllllllllllllIIIllllIIIIllllIl, lllllllllllllllIIIllllIIIIllllII);
                            throw new ReportedException(lllllllllllllllIIIllllIIIIlllIlI);
                        }
                    }
                }
            }
        }
    }
    
    public float getBrightness(final float lllllllllllllllIIIlllIllIllIlllI) {
        final BlockPos lllllllllllllllIIIlllIllIllIllIl = new BlockPos(this.posX, 0.0, this.posZ);
        if (this.worldObj.isBlockLoaded(lllllllllllllllIIIlllIllIllIllIl)) {
            final double lllllllllllllllIIIlllIllIllIllII = (this.getEntityBoundingBox().maxY - this.getEntityBoundingBox().minY) * 0.66;
            final int lllllllllllllllIIIlllIllIllIlIll = MathHelper.floor_double(this.posY + lllllllllllllllIIIlllIllIllIllII);
            return this.worldObj.getLightBrightness(lllllllllllllllIIIlllIllIllIllIl.offsetUp(lllllllllllllllIIIlllIllIllIlIll));
        }
        return 0.0f;
    }
    
    public void mountEntity(final Entity lllllllllllllllIIIlllIIIlIIlIIll) {
        this.entityRiderPitchDelta = 0.0;
        this.entityRiderYawDelta = 0.0;
        if (lllllllllllllllIIIlllIIIlIIlIIll == null) {
            if (this.ridingEntity != null) {
                this.setLocationAndAngles(this.ridingEntity.posX, this.ridingEntity.getEntityBoundingBox().minY + this.ridingEntity.height, this.ridingEntity.posZ, this.rotationYaw, this.rotationPitch);
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = null;
        }
        else {
            if (this.ridingEntity != null) {
                this.ridingEntity.riddenByEntity = null;
            }
            if (lllllllllllllllIIIlllIIIlIIlIIll != null) {
                for (Entity lllllllllllllllIIIlllIIIlIIlIlIl = lllllllllllllllIIIlllIIIlIIlIIll.ridingEntity; lllllllllllllllIIIlllIIIlIIlIlIl != null; lllllllllllllllIIIlllIIIlIIlIlIl = lllllllllllllllIIIlllIIIlIIlIlIl.ridingEntity) {
                    if (lllllllllllllllIIIlllIIIlIIlIlIl == this) {
                        return;
                    }
                }
            }
            this.ridingEntity = lllllllllllllllIIIlllIIIlIIlIIll;
            lllllllllllllllIIIlllIIIlIIlIIll.riddenByEntity = this;
        }
    }
    
    static {
        __OBFID = "CL_00001533";
        field_174836_a = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }
    
    @Override
    public void addChatMessage(final IChatComponent lllllllllllllllIIIllIlllIIIlllII) {
    }
    
    public Entity(final World lllllllllllllllIIIllllIlIllIllll) {
        this.entityId = Entity.nextEntityID++;
        this.renderDistanceWeight = 1.0;
        this.boundingBox = Entity.field_174836_a;
        this.width = 0.6f;
        this.height = 1.8f;
        this.nextStepDistance = 1;
        this.rand = new Random();
        this.fireResistance = 1;
        this.firstUpdate = true;
        this.entityUniqueID = MathHelper.func_180182_a(this.rand);
        this.field_174837_as = new CommandResultStats();
        this.worldObj = lllllllllllllllIIIllllIlIllIllll;
        this.setPosition(0.0, 0.0, 0.0);
        if (lllllllllllllllIIIllllIlIllIllll != null) {
            this.dimension = lllllllllllllllIIIllllIlIllIllll.provider.getDimensionId();
        }
        this.dataWatcher = new DataWatcher(this);
        this.dataWatcher.addObject(0, 0);
        this.dataWatcher.addObject(1, 300);
        this.dataWatcher.addObject(3, 0);
        this.dataWatcher.addObject(2, "");
        this.dataWatcher.addObject(4, 0);
        this.entityInit();
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllllllIIIllIlllIIIllIlI, final String lllllllllllllllIIIllIlllIIIllIIl) {
        return true;
    }
    
    public final boolean isImmuneToFire() {
        return this.isImmuneToFire;
    }
    
    public double getYOffset() {
        return 0.0;
    }
    
    public boolean interactFirst(final EntityPlayer lllllllllllllllIIIlllIIIlIllIIII) {
        return false;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIllllIlIllIIllI) {
        return lllllllllllllllIIIllllIlIllIIllI instanceof Entity && ((Entity)lllllllllllllllIIIllllIlIllIIllI).entityId == this.entityId;
    }
    
    public boolean isRiding() {
        return this.ridingEntity != null;
    }
    
    public boolean isInvisibleToPlayer(final EntityPlayer lllllllllllllllIIIlllIIIIIlIlIll) {
        return !lllllllllllllllIIIlllIIIIIlIlIll.func_175149_v() && this.isInvisible();
    }
    
    public boolean isInvisible() {
        return this.getFlag(5);
    }
    
    public double getDistance(final double lllllllllllllllIIIlllIlIlllIlllI, final double lllllllllllllllIIIlllIlIllllIlII, final double lllllllllllllllIIIlllIlIlllIllII) {
        final double lllllllllllllllIIIlllIlIllllIIlI = this.posX - lllllllllllllllIIIlllIlIlllIlllI;
        final double lllllllllllllllIIIlllIlIllllIIIl = this.posY - lllllllllllllllIIIlllIlIllllIlII;
        final double lllllllllllllllIIIlllIlIllllIIII = this.posZ - lllllllllllllllIIIlllIlIlllIllII;
        return MathHelper.sqrt_double(lllllllllllllllIIIlllIlIllllIIlI * lllllllllllllllIIIlllIlIllllIIlI + lllllllllllllllIIIlllIlIllllIIIl * lllllllllllllllIIIlllIlIllllIIIl + lllllllllllllllIIIlllIlIllllIIII * lllllllllllllllIIIlllIlIllllIIII);
    }
    
    public void func_180432_n(final Entity lllllllllllllllIIIllIllllIlIllIl) {
        final NBTTagCompound lllllllllllllllIIIllIllllIlIllII = new NBTTagCompound();
        lllllllllllllllIIIllIllllIlIllIl.writeToNBT(lllllllllllllllIIIllIllllIlIllII);
        this.readFromNBT(lllllllllllllllIIIllIllllIlIllII);
        this.timeUntilPortal = lllllllllllllllIIIllIllllIlIllIl.timeUntilPortal;
        this.teleportDirection = lllllllllllllllIIIllIllllIlIllIl.teleportDirection;
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public float getCollisionBorderSize() {
        return 0.1f;
    }
    
    public boolean isEating() {
        return this.getFlag(4);
    }
    
    protected HoverEvent func_174823_aP() {
        final NBTTagCompound lllllllllllllllIIIllIlllIIllllII = new NBTTagCompound();
        final String lllllllllllllllIIIllIlllIIlllIll = EntityList.getEntityString(this);
        lllllllllllllllIIIllIlllIIllllII.setString("id", this.getUniqueID().toString());
        if (lllllllllllllllIIIllIlllIIlllIll != null) {
            lllllllllllllllIIIllIlllIIllllII.setString("type", lllllllllllllllIIIllIlllIIlllIll);
        }
        lllllllllllllllIIIllIlllIIllllII.setString("name", this.getName());
        return new HoverEvent(HoverEvent.Action.SHOW_ENTITY, new ChatComponentText(lllllllllllllllIIIllIlllIIllllII.toString()));
    }
    
    public boolean isSneaking() {
        return this.getFlag(1);
    }
    
    public boolean isSlient() {
        return this.dataWatcher.getWatchableObjectByte(4) == 1;
    }
    
    public void setCustomNameTag(final String lllllllllllllllIIIllIlllIllIIlII) {
        this.dataWatcher.updateObject(2, lllllllllllllllIIIllIlllIllIIlII);
    }
    
    public boolean getAlwaysRenderNameTagForRender() {
        return this.getAlwaysRenderNameTag();
    }
    
    public boolean canBeCollidedWith() {
        return false;
    }
    
    public void setAir(final int lllllllllllllllIIIlllIIIIIIIIIIl) {
        this.dataWatcher.updateObject(1, (short)lllllllllllllllIIIlllIIIIIIIIIIl);
    }
    
    public void moveFlying(float lllllllllllllllIIIlllIlllIIIllIl, float lllllllllllllllIIIlllIlllIIIllII, final float lllllllllllllllIIIlllIlllIIIIlII) {
        float lllllllllllllllIIIlllIlllIIIlIlI = lllllllllllllllIIIlllIlllIIIllIl * lllllllllllllllIIIlllIlllIIIllIl + lllllllllllllllIIIlllIlllIIIllII * lllllllllllllllIIIlllIlllIIIllII;
        if (lllllllllllllllIIIlllIlllIIIlIlI >= 1.0E-4f) {
            lllllllllllllllIIIlllIlllIIIlIlI = MathHelper.sqrt_float(lllllllllllllllIIIlllIlllIIIlIlI);
            if (lllllllllllllllIIIlllIlllIIIlIlI < 1.0f) {
                lllllllllllllllIIIlllIlllIIIlIlI = 1.0f;
            }
            lllllllllllllllIIIlllIlllIIIlIlI = lllllllllllllllIIIlllIlllIIIIlII / lllllllllllllllIIIlllIlllIIIlIlI;
            lllllllllllllllIIIlllIlllIIIllIl *= lllllllllllllllIIIlllIlllIIIlIlI;
            lllllllllllllllIIIlllIlllIIIllII *= lllllllllllllllIIIlllIlllIIIlIlI;
            final float lllllllllllllllIIIlllIlllIIIlIIl = MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f);
            final float lllllllllllllllIIIlllIlllIIIlIII = MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f);
            this.motionX += lllllllllllllllIIIlllIlllIIIllIl * lllllllllllllllIIIlllIlllIIIlIII - lllllllllllllllIIIlllIlllIIIllII * lllllllllllllllIIIlllIlllIIIlIIl;
            this.motionZ += lllllllllllllllIIIlllIlllIIIllII * lllllllllllllllIIIlllIlllIIIlIII + lllllllllllllllIIIlllIlllIIIllIl * lllllllllllllllIIIlllIlllIIIlIIl;
        }
    }
    
    @Override
    public int hashCode() {
        return this.entityId;
    }
    
    protected abstract void writeEntityToNBT(final NBTTagCompound p0);
    
    public int getBrightnessForRender(final float lllllllllllllllIIIlllIllIllllIll) {
        final BlockPos lllllllllllllllIIIlllIllIllllIlI = new BlockPos(this.posX, 0.0, this.posZ);
        if (this.worldObj.isBlockLoaded(lllllllllllllllIIIlllIllIllllIlI)) {
            final double lllllllllllllllIIIlllIllIllllIIl = (this.getEntityBoundingBox().maxY - this.getEntityBoundingBox().minY) * 0.66;
            final int lllllllllllllllIIIlllIllIllllIII = MathHelper.floor_double(this.posY + lllllllllllllllIIIlllIllIllllIIl);
            return this.worldObj.getCombinedLight(lllllllllllllllIIIlllIllIllllIlI.offsetUp(lllllllllllllllIIIlllIllIllllIII), 0);
        }
        return 0;
    }
    
    public double getDistanceSqToEntity(final Entity lllllllllllllllIIIlllIlIlllIIIlI) {
        final double lllllllllllllllIIIlllIlIlllIIIIl = this.posX - lllllllllllllllIIIlllIlIlllIIIlI.posX;
        final double lllllllllllllllIIIlllIlIlllIIIII = this.posY - lllllllllllllllIIIlllIlIlllIIIlI.posY;
        final double lllllllllllllllIIIlllIlIllIlllll = this.posZ - lllllllllllllllIIIlllIlIlllIIIlI.posZ;
        return lllllllllllllllIIIlllIlIlllIIIIl * lllllllllllllllIIIlllIlIlllIIIIl + lllllllllllllllIIIlllIlIlllIIIII * lllllllllllllllIIIlllIlIlllIIIII + lllllllllllllllIIIlllIlIllIlllll * lllllllllllllllIIIlllIlIllIlllll;
    }
    
    public boolean isInRangeToRender3d(final double lllllllllllllllIIIlllIlIIlIllIIl, final double lllllllllllllllIIIlllIlIIlIllIII, final double lllllllllllllllIIIlllIlIIlIlllll) {
        final double lllllllllllllllIIIlllIlIIlIllllI = this.posX - lllllllllllllllIIIlllIlIIlIllIIl;
        final double lllllllllllllllIIIlllIlIIlIlllIl = this.posY - lllllllllllllllIIIlllIlIIlIllIII;
        final double lllllllllllllllIIIlllIlIIlIlllII = this.posZ - lllllllllllllllIIIlllIlIIlIlllll;
        final double lllllllllllllllIIIlllIlIIlIllIll = lllllllllllllllIIIlllIlIIlIllllI * lllllllllllllllIIIlllIlIIlIllllI + lllllllllllllllIIIlllIlIIlIlllIl * lllllllllllllllIIIlllIlIIlIlllIl + lllllllllllllllIIIlllIlIIlIlllII * lllllllllllllllIIIlllIlIIlIlllII;
        return this.isInRangeToRenderDist(lllllllllllllllIIIlllIlIIlIllIll);
    }
    
    public void onStruckByLightning(final EntityLightningBolt lllllllllllllllIIIllIllllllllllI) {
        this.attackEntityFrom(DamageSource.field_180137_b, 5.0f);
        ++this.fire;
        if (this.fire == 0) {
            this.setFire(8);
        }
    }
    
    protected NBTTagList newDoubleNBTList(final double... lllllllllllllllIIIlllIlIIIIIlIIl) {
        final NBTTagList lllllllllllllllIIIlllIlIIIIIlIII = new NBTTagList();
        final double[] lllllllllllllllIIIlllIlIIIIIIlll = lllllllllllllllIIIlllIlIIIIIlIIl;
        for (int lllllllllllllllIIIlllIlIIIIIIllI = lllllllllllllllIIIlllIlIIIIIlIIl.length, lllllllllllllllIIIlllIlIIIIIIlIl = 0; lllllllllllllllIIIlllIlIIIIIIlIl < lllllllllllllllIIIlllIlIIIIIIllI; ++lllllllllllllllIIIlllIlIIIIIIlIl) {
            final double lllllllllllllllIIIlllIlIIIIIIlII = lllllllllllllllIIIlllIlIIIIIIlll[lllllllllllllllIIIlllIlIIIIIIlIl];
            lllllllllllllllIIIlllIlIIIIIlIII.appendTag(new NBTTagDouble(lllllllllllllllIIIlllIlIIIIIIlII));
        }
        return lllllllllllllllIIIlllIlIIIIIlIII;
    }
    
    protected void setRotation(final float lllllllllllllllIIIllllIlIlIIIlll, final float lllllllllllllllIIIllllIlIlIIIllI) {
        this.rotationYaw = lllllllllllllllIIIllllIlIlIIIlll % 360.0f;
        this.rotationPitch = lllllllllllllllIIIllllIlIlIIIllI % 360.0f;
    }
    
    public boolean isEntityInsideOpaqueBlock() {
        if (this.noClip) {
            return false;
        }
        for (int lllllllllllllllIIIlllIIIlIlllIlI = 0; lllllllllllllllIIIlllIIIlIlllIlI < 8; ++lllllllllllllllIIIlllIIIlIlllIlI) {
            final double lllllllllllllllIIIlllIIIlIlllIIl = this.posX + ((lllllllllllllllIIIlllIIIlIlllIlI >> 0) % 2 - 0.5f) * this.width * 0.8f;
            final double lllllllllllllllIIIlllIIIlIlllIII = this.posY + ((lllllllllllllllIIIlllIIIlIlllIlI >> 1) % 2 - 0.5f) * 0.1f;
            final double lllllllllllllllIIIlllIIIlIllIlll = this.posZ + ((lllllllllllllllIIIlllIIIlIlllIlI >> 2) % 2 - 0.5f) * this.width * 0.8f;
            if (this.worldObj.getBlockState(new BlockPos(lllllllllllllllIIIlllIIIlIlllIIl, lllllllllllllllIIIlllIIIlIlllIII + this.getEyeHeight(), lllllllllllllllIIIlllIIIlIllIlll)).getBlock().isVisuallyOpaque()) {
                return true;
            }
        }
        return false;
    }
    
    public EntityItem dropItem(final Item lllllllllllllllIIIlllIIllllIIIll, final int lllllllllllllllIIIlllIIllllIIIlI) {
        return this.dropItemWithOffset(lllllllllllllllIIIlllIIllllIIIll, lllllllllllllllIIIlllIIllllIIIlI, 0.0f);
    }
    
    public void func_174828_a(final BlockPos lllllllllllllllIIIlllIllIlIIIllI, final float lllllllllllllllIIIlllIllIlIIIIIl, final float lllllllllllllllIIIlllIllIlIIIIII) {
        this.setLocationAndAngles(lllllllllllllllIIIlllIllIlIIIllI.getX() + 0.5, lllllllllllllllIIIlllIllIlIIIllI.getY(), lllllllllllllllIIIlllIllIlIIIllI.getZ() + 0.5, lllllllllllllllIIIlllIllIlIIIIIl, lllllllllllllllIIIlllIllIlIIIIII);
    }
    
    public void handleHealthUpdate(final byte lllllllllllllllIIIlllIIIIlIlIlII) {
    }
    
    @Override
    public Entity getCommandSenderEntity() {
        return this;
    }
    
    protected String getSplashSound() {
        return "game.neutral.swim.splash";
    }
    
    public void setInWeb() {
        this.isInWeb = true;
        this.fallDistance = 0.0f;
    }
    
    public void setAngles(final float lllllllllllllllIIIllllIlIIlIllIl, final float lllllllllllllllIIIllllIlIIlIllII) {
        final float lllllllllllllllIIIllllIlIIlIlIll = this.rotationPitch;
        final float lllllllllllllllIIIllllIlIIlIlIlI = this.rotationYaw;
        this.rotationYaw += (float)(lllllllllllllllIIIllllIlIIlIllIl * 0.15);
        this.rotationPitch -= (float)(lllllllllllllllIIIllllIlIIlIllII * 0.15);
        this.rotationPitch = MathHelper.clamp_float(this.rotationPitch, -90.0f, 90.0f);
        this.prevRotationPitch += this.rotationPitch - lllllllllllllllIIIllllIlIIlIlIll;
        this.prevRotationYaw += this.rotationYaw - lllllllllllllllIIIllllIlIIlIlIlI;
    }
    
    protected boolean canTriggerWalking() {
        return true;
    }
    
    protected NBTTagList newFloatNBTList(final float... lllllllllllllllIIIlllIIlllllIIII) {
        final NBTTagList lllllllllllllllIIIlllIIlllllIlIl = new NBTTagList();
        final float[] lllllllllllllllIIIlllIIlllllIlII = lllllllllllllllIIIlllIIlllllIIII;
        for (int lllllllllllllllIIIlllIIlllllIIll = lllllllllllllllIIIlllIIlllllIIII.length, lllllllllllllllIIIlllIIlllllIIlI = 0; lllllllllllllllIIIlllIIlllllIIlI < lllllllllllllllIIIlllIIlllllIIll; ++lllllllllllllllIIIlllIIlllllIIlI) {
            final float lllllllllllllllIIIlllIIlllllIIIl = lllllllllllllllIIIlllIIlllllIlII[lllllllllllllllIIIlllIIlllllIIlI];
            lllllllllllllllIIIlllIIlllllIlIl.appendTag(new NBTTagFloat(lllllllllllllllIIIlllIIlllllIIIl));
        }
        return lllllllllllllllIIIlllIIlllllIlIl;
    }
    
    public boolean getAlwaysRenderNameTag() {
        return this.dataWatcher.getWatchableObjectByte(3) == 1;
    }
    
    public double getDistanceSq(final double lllllllllllllllIIIlllIllIIIlIllI, final double lllllllllllllllIIIlllIllIIIlIlIl, final double lllllllllllllllIIIlllIllIIIlIlII) {
        final double lllllllllllllllIIIlllIllIIIlIIll = this.posX - lllllllllllllllIIIlllIllIIIlIllI;
        final double lllllllllllllllIIIlllIllIIIlIIlI = this.posY - lllllllllllllllIIIlllIllIIIlIlIl;
        final double lllllllllllllllIIIlllIllIIIlIIIl = this.posZ - lllllllllllllllIIIlllIllIIIlIlII;
        return lllllllllllllllIIIlllIllIIIlIIll * lllllllllllllllIIIlllIllIIIlIIll + lllllllllllllllIIIlllIllIIIlIIlI * lllllllllllllllIIIlllIllIIIlIIlI + lllllllllllllllIIIlllIllIIIlIIIl * lllllllllllllllIIIlllIllIIIlIIIl;
    }
    
    public AxisAlignedBB getBoundingBox() {
        return null;
    }
    
    public void setLocationAndAngles(final double lllllllllllllllIIIlllIllIIlllIII, final double lllllllllllllllIIIlllIllIIllIlll, final double lllllllllllllllIIIlllIllIIllIIII, final float lllllllllllllllIIIlllIllIIllIlIl, final float lllllllllllllllIIIlllIllIIlIlllI) {
        this.posX = lllllllllllllllIIIlllIllIIlllIII;
        this.prevPosX = lllllllllllllllIIIlllIllIIlllIII;
        this.lastTickPosX = lllllllllllllllIIIlllIllIIlllIII;
        this.posY = lllllllllllllllIIIlllIllIIllIlll;
        this.prevPosY = lllllllllllllllIIIlllIllIIllIlll;
        this.lastTickPosY = lllllllllllllllIIIlllIllIIllIlll;
        this.posZ = lllllllllllllllIIIlllIllIIllIIII;
        this.prevPosZ = lllllllllllllllIIIlllIllIIllIIII;
        this.lastTickPosZ = lllllllllllllllIIIlllIllIIllIIII;
        this.rotationYaw = lllllllllllllllIIIlllIllIIllIlIl;
        this.rotationPitch = lllllllllllllllIIIlllIllIIlIlllI;
        this.setPosition(this.posX, this.posY, this.posZ);
    }
}
