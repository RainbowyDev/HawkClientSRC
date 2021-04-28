package net.minecraft.entity.item;

import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public class EntityBoat extends Entity
{
    private /* synthetic */ double boatYaw;
    private /* synthetic */ boolean isBoatEmpty;
    private /* synthetic */ double velocityX;
    private /* synthetic */ double boatX;
    private /* synthetic */ double boatY;
    private /* synthetic */ double velocityY;
    private /* synthetic */ double boatZ;
    private /* synthetic */ double boatPitch;
    private /* synthetic */ double velocityZ;
    private /* synthetic */ double speedMultiplier;
    private /* synthetic */ int boatPosRotationIncrements;
    
    @Override
    public AxisAlignedBB getCollisionBox(final Entity llllllllllllllIIlllIIlIIlIIlIIII) {
        return llllllllllllllIIlllIIlIIlIIlIIII.getEntityBoundingBox();
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    public void setIsBoatEmpty(final boolean llllllllllllllIIlllIIIlllIlIlIIl) {
        this.isBoatEmpty = llllllllllllllIIlllIIIlllIlIlIIl;
    }
    
    public int getTimeSinceHit() {
        return this.dataWatcher.getWatchableObjectInt(17);
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlllIIIllllIllllI) {
    }
    
    @Override
    public void performHurtAnimation() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0f);
    }
    
    static {
        __OBFID = "CL_00001667";
    }
    
    @Override
    public AxisAlignedBB getBoundingBox() {
        return this.getEntityBoundingBox();
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getTimeSinceHit() > 0) {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        if (this.getDamageTaken() > 0.0f) {
            this.setDamageTaken(this.getDamageTaken() - 1.0f);
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        final byte llllllllllllllIIlllIIlIIIIlIIlII = 5;
        double llllllllllllllIIlllIIlIIIIlIIIll = 0.0;
        for (int llllllllllllllIIlllIIlIIIIlIIIlI = 0; llllllllllllllIIlllIIlIIIIlIIIlI < llllllllllllllIIlllIIlIIIIlIIlII; ++llllllllllllllIIlllIIlIIIIlIIIlI) {
            final double llllllllllllllIIlllIIlIIIIlIIIIl = this.getEntityBoundingBox().minY + (this.getEntityBoundingBox().maxY - this.getEntityBoundingBox().minY) * (llllllllllllllIIlllIIlIIIIlIIIlI + 0) / llllllllllllllIIlllIIlIIIIlIIlII - 0.125;
            final double llllllllllllllIIlllIIlIIIIlIIIII = this.getEntityBoundingBox().minY + (this.getEntityBoundingBox().maxY - this.getEntityBoundingBox().minY) * (llllllllllllllIIlllIIlIIIIlIIIlI + 1) / llllllllllllllIIlllIIlIIIIlIIlII - 0.125;
            final AxisAlignedBB llllllllllllllIIlllIIlIIIIIlllll = new AxisAlignedBB(this.getEntityBoundingBox().minX, llllllllllllllIIlllIIlIIIIlIIIIl, this.getEntityBoundingBox().minZ, this.getEntityBoundingBox().maxX, llllllllllllllIIlllIIlIIIIlIIIII, this.getEntityBoundingBox().maxZ);
            if (this.worldObj.isAABBInMaterial(llllllllllllllIIlllIIlIIIIIlllll, Material.water)) {
                llllllllllllllIIlllIIlIIIIlIIIll += 1.0 / llllllllllllllIIlllIIlIIIIlIIlII;
            }
        }
        final double llllllllllllllIIlllIIlIIIIIllllI = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (llllllllllllllIIlllIIlIIIIIllllI > 0.2975) {
            final double llllllllllllllIIlllIIlIIIIIlllIl = Math.cos(this.rotationYaw * 3.141592653589793 / 180.0);
            final double llllllllllllllIIlllIIlIIIIIllIII = Math.sin(this.rotationYaw * 3.141592653589793 / 180.0);
            for (int llllllllllllllIIlllIIlIIIIIlIIll = 0; llllllllllllllIIlllIIlIIIIIlIIll < 1.0 + llllllllllllllIIlllIIlIIIIIllllI * 60.0; ++llllllllllllllIIlllIIlIIIIIlIIll) {
                final double llllllllllllllIIlllIIlIIIIIlIIIl = this.rand.nextFloat() * 2.0f - 1.0f;
                final double llllllllllllllIIlllIIlIIIIIlIIII = (this.rand.nextInt(2) * 2 - 1) * 0.7;
                if (this.rand.nextBoolean()) {
                    final double llllllllllllllIIlllIIlIIIIIIllll = this.posX - llllllllllllllIIlllIIlIIIIIlllIl * llllllllllllllIIlllIIlIIIIIlIIIl * 0.8 + llllllllllllllIIlllIIlIIIIIllIII * llllllllllllllIIlllIIlIIIIIlIIII;
                    final double llllllllllllllIIlllIIlIIIIIIllIl = this.posZ - llllllllllllllIIlllIIlIIIIIllIII * llllllllllllllIIlllIIlIIIIIlIIIl * 0.8 - llllllllllllllIIlllIIlIIIIIlllIl * llllllllllllllIIlllIIlIIIIIlIIII;
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, llllllllllllllIIlllIIlIIIIIIllll, this.posY - 0.125, llllllllllllllIIlllIIlIIIIIIllIl, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
                else {
                    final double llllllllllllllIIlllIIlIIIIIIlllI = this.posX + llllllllllllllIIlllIIlIIIIIlllIl + llllllllllllllIIlllIIlIIIIIllIII * llllllllllllllIIlllIIlIIIIIlIIIl * 0.7;
                    final double llllllllllllllIIlllIIlIIIIIIllII = this.posZ + llllllllllllllIIlllIIlIIIIIllIII - llllllllllllllIIlllIIlIIIIIlllIl * llllllllllllllIIlllIIlIIIIIlIIIl * 0.7;
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, llllllllllllllIIlllIIlIIIIIIlllI, this.posY - 0.125, llllllllllllllIIlllIIlIIIIIIllII, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
            }
        }
        if (this.worldObj.isRemote && this.isBoatEmpty) {
            if (this.boatPosRotationIncrements > 0) {
                final double llllllllllllllIIlllIIlIIIIIlllII = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
                final double llllllllllllllIIlllIIlIIIIIlIlll = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
                final double llllllllllllllIIlllIIlIIIIIIlIll = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
                final double llllllllllllllIIlllIIlIIIIIIlIII = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
                this.rotationYaw += (float)(llllllllllllllIIlllIIlIIIIIIlIII / this.boatPosRotationIncrements);
                this.rotationPitch += (float)((this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
                --this.boatPosRotationIncrements;
                this.setPosition(llllllllllllllIIlllIIlIIIIIlllII, llllllllllllllIIlllIIlIIIIIlIlll, llllllllllllllIIlllIIlIIIIIIlIll);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
            else {
                final double llllllllllllllIIlllIIlIIIIIllIll = this.posX + this.motionX;
                final double llllllllllllllIIlllIIlIIIIIlIllI = this.posY + this.motionY;
                final double llllllllllllllIIlllIIlIIIIIIlIlI = this.posZ + this.motionZ;
                this.setPosition(llllllllllllllIIlllIIlIIIIIllIll, llllllllllllllIIlllIIlIIIIIlIllI, llllllllllllllIIlllIIlIIIIIIlIlI);
                if (this.onGround) {
                    this.motionX *= 0.5;
                    this.motionY *= 0.5;
                    this.motionZ *= 0.5;
                }
                this.motionX *= 0.9900000095367432;
                this.motionY *= 0.949999988079071;
                this.motionZ *= 0.9900000095367432;
            }
        }
        else {
            if (llllllllllllllIIlllIIlIIIIlIIIll < 1.0) {
                final double llllllllllllllIIlllIIlIIIIIllIlI = llllllllllllllIIlllIIlIIIIlIIIll * 2.0 - 1.0;
                this.motionY += 0.03999999910593033 * llllllllllllllIIlllIIlIIIIIllIlI;
            }
            else {
                if (this.motionY < 0.0) {
                    this.motionY /= 2.0;
                }
                this.motionY += 0.007000000216066837;
            }
            if (this.riddenByEntity instanceof EntityLivingBase) {
                final EntityLivingBase llllllllllllllIIlllIIlIIIIIIIllI = (EntityLivingBase)this.riddenByEntity;
                final float llllllllllllllIIlllIIlIIIIIIIlIl = this.riddenByEntity.rotationYaw + -llllllllllllllIIlllIIlIIIIIIIllI.moveStrafing * 90.0f;
                this.motionX += -Math.sin(llllllllllllllIIlllIIlIIIIIIIlIl * 3.1415927f / 180.0f) * this.speedMultiplier * llllllllllllllIIlllIIlIIIIIIIllI.moveForward * 0.05000000074505806;
                this.motionZ += Math.cos(llllllllllllllIIlllIIlIIIIIIIlIl * 3.1415927f / 180.0f) * this.speedMultiplier * llllllllllllllIIlllIIlIIIIIIIllI.moveForward * 0.05000000074505806;
            }
            double llllllllllllllIIlllIIlIIIIIllIIl = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (llllllllllllllIIlllIIlIIIIIllIIl > 0.35) {
                final double llllllllllllllIIlllIIlIIIIIlIlIl = 0.35 / llllllllllllllIIlllIIlIIIIIllIIl;
                this.motionX *= llllllllllllllIIlllIIlIIIIIlIlIl;
                this.motionZ *= llllllllllllllIIlllIIlIIIIIlIlIl;
                llllllllllllllIIlllIIlIIIIIllIIl = 0.35;
            }
            if (llllllllllllllIIlllIIlIIIIIllIIl > llllllllllllllIIlllIIlIIIIIllllI && this.speedMultiplier < 0.35) {
                this.speedMultiplier += (0.35 - this.speedMultiplier) / 35.0;
                if (this.speedMultiplier > 0.35) {
                    this.speedMultiplier = 0.35;
                }
            }
            else {
                this.speedMultiplier -= (this.speedMultiplier - 0.07) / 35.0;
                if (this.speedMultiplier < 0.07) {
                    this.speedMultiplier = 0.07;
                }
            }
            for (int llllllllllllllIIlllIIlIIIIIIIlII = 0; llllllllllllllIIlllIIlIIIIIIIlII < 4; ++llllllllllllllIIlllIIlIIIIIIIlII) {
                final int llllllllllllllIIlllIIlIIIIIIIIll = MathHelper.floor_double(this.posX + (llllllllllllllIIlllIIlIIIIIIIlII % 2 - 0.5) * 0.8);
                final int llllllllllllllIIlllIIlIIIIIlIIlI = MathHelper.floor_double(this.posZ + (llllllllllllllIIlllIIlIIIIIIIlII / 2 - 0.5) * 0.8);
                for (int llllllllllllllIIlllIIlIIIIIIIIlI = 0; llllllllllllllIIlllIIlIIIIIIIIlI < 2; ++llllllllllllllIIlllIIlIIIIIIIIlI) {
                    final int llllllllllllllIIlllIIlIIIIIIIIIl = MathHelper.floor_double(this.posY) + llllllllllllllIIlllIIlIIIIIIIIlI;
                    final BlockPos llllllllllllllIIlllIIlIIIIIIIIII = new BlockPos(llllllllllllllIIlllIIlIIIIIIIIll, llllllllllllllIIlllIIlIIIIIIIIIl, llllllllllllllIIlllIIlIIIIIlIIlI);
                    final Block llllllllllllllIIlllIIIllllllllll = this.worldObj.getBlockState(llllllllllllllIIlllIIlIIIIIIIIII).getBlock();
                    if (llllllllllllllIIlllIIIllllllllll == Blocks.snow_layer) {
                        this.worldObj.setBlockToAir(llllllllllllllIIlllIIlIIIIIIIIII);
                        this.isCollidedHorizontally = false;
                    }
                    else if (llllllllllllllIIlllIIIllllllllll == Blocks.waterlily) {
                        this.worldObj.destroyBlock(llllllllllllllIIlllIIlIIIIIIIIII, true);
                        this.isCollidedHorizontally = false;
                    }
                }
            }
            if (this.onGround) {
                this.motionX *= 0.5;
                this.motionY *= 0.5;
                this.motionZ *= 0.5;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.isCollidedHorizontally && llllllllllllllIIlllIIlIIIIIllllI > 0.2) {
                if (!this.worldObj.isRemote && !this.isDead) {
                    this.setDead();
                    for (int llllllllllllllIIlllIIlIIIIIIIlII = 0; llllllllllllllIIlllIIlIIIIIIIlII < 3; ++llllllllllllllIIlllIIlIIIIIIIlII) {
                        this.dropItemWithOffset(Item.getItemFromBlock(Blocks.planks), 1, 0.0f);
                    }
                    for (int llllllllllllllIIlllIIlIIIIIIIlII = 0; llllllllllllllIIlllIIlIIIIIIIlII < 2; ++llllllllllllllIIlllIIlIIIIIIIlII) {
                        this.dropItemWithOffset(Items.stick, 1, 0.0f);
                    }
                }
            }
            else {
                this.motionX *= 0.9900000095367432;
                this.motionY *= 0.949999988079071;
                this.motionZ *= 0.9900000095367432;
            }
            this.rotationPitch = 0.0f;
            double llllllllllllllIIlllIIlIIIIIlIlII = this.rotationYaw;
            final double llllllllllllllIIlllIIlIIIIIIlIIl = this.prevPosX - this.posX;
            final double llllllllllllllIIlllIIlIIIIIIIlll = this.prevPosZ - this.posZ;
            if (llllllllllllllIIlllIIlIIIIIIlIIl * llllllllllllllIIlllIIlIIIIIIlIIl + llllllllllllllIIlllIIlIIIIIIIlll * llllllllllllllIIlllIIlIIIIIIIlll > 0.001) {
                llllllllllllllIIlllIIlIIIIIlIlII = (float)(Math.atan2(llllllllllllllIIlllIIlIIIIIIIlll, llllllllllllllIIlllIIlIIIIIIlIIl) * 180.0 / 3.141592653589793);
            }
            double llllllllllllllIIlllIIIlllllllllI = MathHelper.wrapAngleTo180_double(llllllllllllllIIlllIIlIIIIIlIlII - this.rotationYaw);
            if (llllllllllllllIIlllIIIlllllllllI > 20.0) {
                llllllllllllllIIlllIIIlllllllllI = 20.0;
            }
            if (llllllllllllllIIlllIIIlllllllllI < -20.0) {
                llllllllllllllIIlllIIIlllllllllI = -20.0;
            }
            this.rotationYaw += (float)llllllllllllllIIlllIIIlllllllllI;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            if (!this.worldObj.isRemote) {
                final List llllllllllllllIIlllIIIllllllllIl = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.20000000298023224, 0.0, 0.20000000298023224));
                if (llllllllllllllIIlllIIIllllllllIl != null && !llllllllllllllIIlllIIIllllllllIl.isEmpty()) {
                    for (int llllllllllllllIIlllIIIllllllllII = 0; llllllllllllllIIlllIIIllllllllII < llllllllllllllIIlllIIIllllllllIl.size(); ++llllllllllllllIIlllIIIllllllllII) {
                        final Entity llllllllllllllIIlllIIIlllllllIll = llllllllllllllIIlllIIIllllllllIl.get(llllllllllllllIIlllIIIllllllllII);
                        if (llllllllllllllIIlllIIIlllllllIll != this.riddenByEntity && llllllllllllllIIlllIIIlllllllIll.canBePushed() && llllllllllllllIIlllIIIlllllllIll instanceof EntityBoat) {
                            llllllllllllllIIlllIIIlllllllIll.applyEntityCollision(this);
                        }
                    }
                }
                if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                    this.riddenByEntity = null;
                }
            }
        }
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public double getMountedYOffset() {
        return this.height * 0.0 - 0.30000001192092896;
    }
    
    public int getForwardDirection() {
        return this.dataWatcher.getWatchableObjectInt(18);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIIlllIIlIIIlllIlII, final float llllllllllllllIIlllIIlIIIllIllll) {
        if (this.func_180431_b(llllllllllllllIIlllIIlIIIlllIlII)) {
            return false;
        }
        if (this.worldObj.isRemote || this.isDead) {
            return true;
        }
        if (this.riddenByEntity != null && this.riddenByEntity == llllllllllllllIIlllIIlIIIlllIlII.getEntity() && llllllllllllllIIlllIIlIIIlllIlII instanceof EntityDamageSourceIndirect) {
            return false;
        }
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() + llllllllllllllIIlllIIlIIIllIllll * 10.0f);
        this.setBeenAttacked();
        final boolean llllllllllllllIIlllIIlIIIlllIIlI = llllllllllllllIIlllIIlIIIlllIlII.getEntity() instanceof EntityPlayer && ((EntityPlayer)llllllllllllllIIlllIIlIIIlllIlII.getEntity()).capabilities.isCreativeMode;
        if (llllllllllllllIIlllIIlIIIlllIIlI || this.getDamageTaken() > 40.0f) {
            if (this.riddenByEntity != null) {
                this.riddenByEntity.mountEntity(this);
            }
            if (!llllllllllllllIIlllIIlIIIlllIIlI) {
                this.dropItemWithOffset(Items.boat, 1, 0.0f);
            }
            this.setDead();
        }
        return true;
    }
    
    public EntityBoat(final World llllllllllllllIIlllIIlIIlIIllIII) {
        super(llllllllllllllIIlllIIlIIlIIllIII);
        this.isBoatEmpty = true;
        this.speedMultiplier = 0.07;
        this.preventEntitySpawning = true;
        this.setSize(1.5f, 0.6f);
    }
    
    public void setTimeSinceHit(final int llllllllllllllIIlllIIIlllIlllIIl) {
        this.dataWatcher.updateObject(17, llllllllllllllIIlllIIIlllIlllIIl);
    }
    
    @Override
    protected void func_180433_a(final double llllllllllllllIIlllIIIllllIlIIII, final boolean llllllllllllllIIlllIIIllllIIlIIl, final Block llllllllllllllIIlllIIIllllIIlllI, final BlockPos llllllllllllllIIlllIIIllllIIllIl) {
        if (llllllllllllllIIlllIIIllllIIlIIl) {
            if (this.fallDistance > 3.0f) {
                this.fall(this.fallDistance, 1.0f);
                if (!this.worldObj.isRemote && !this.isDead) {
                    this.setDead();
                    for (int llllllllllllllIIlllIIIllllIIllII = 0; llllllllllllllIIlllIIIllllIIllII < 3; ++llllllllllllllIIlllIIIllllIIllII) {
                        this.dropItemWithOffset(Item.getItemFromBlock(Blocks.planks), 1, 0.0f);
                    }
                    for (int llllllllllllllIIlllIIIllllIIllII = 0; llllllllllllllIIlllIIIllllIIllII < 2; ++llllllllllllllIIlllIIIllllIIllII) {
                        this.dropItemWithOffset(Items.stick, 1, 0.0f);
                    }
                }
                this.fallDistance = 0.0f;
            }
        }
        else if (this.worldObj.getBlockState(new BlockPos(this).offsetDown()).getBlock().getMaterial() != Material.water && llllllllllllllIIlllIIIllllIlIIII < 0.0) {
            this.fallDistance -= (float)llllllllllllllIIlllIIIllllIlIIII;
        }
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlllIIIllllIlllII) {
    }
    
    @Override
    public boolean canBePushed() {
        return true;
    }
    
    @Override
    public void func_180426_a(final double llllllllllllllIIlllIIlIIIlIllIlI, final double llllllllllllllIIlllIIlIIIlIIllII, final double llllllllllllllIIlllIIlIIIlIIlIll, final float llllllllllllllIIlllIIlIIIlIlIlll, final float llllllllllllllIIlllIIlIIIlIIlIIl, final int llllllllllllllIIlllIIlIIIlIIlIII, final boolean llllllllllllllIIlllIIlIIIlIlIlII) {
        if (llllllllllllllIIlllIIlIIIlIlIlII && this.riddenByEntity != null) {
            this.posX = llllllllllllllIIlllIIlIIIlIllIlI;
            this.prevPosX = llllllllllllllIIlllIIlIIIlIllIlI;
            this.posY = llllllllllllllIIlllIIlIIIlIIllII;
            this.prevPosY = llllllllllllllIIlllIIlIIIlIIllII;
            this.posZ = llllllllllllllIIlllIIlIIIlIIlIll;
            this.prevPosZ = llllllllllllllIIlllIIlIIIlIIlIll;
            this.rotationYaw = llllllllllllllIIlllIIlIIIlIlIlll;
            this.rotationPitch = llllllllllllllIIlllIIlIIIlIIlIIl;
            this.boatPosRotationIncrements = 0;
            this.setPosition(llllllllllllllIIlllIIlIIIlIllIlI, llllllllllllllIIlllIIlIIIlIIllII, llllllllllllllIIlllIIlIIIlIIlIll);
            final double n = 0.0;
            this.velocityX = n;
            this.motionX = n;
            final double n2 = 0.0;
            this.velocityY = n2;
            this.motionY = n2;
            final double n3 = 0.0;
            this.velocityZ = n3;
            this.motionZ = n3;
        }
        else {
            if (this.isBoatEmpty) {
                this.boatPosRotationIncrements = llllllllllllllIIlllIIlIIIlIIlIII + 5;
            }
            else {
                final double llllllllllllllIIlllIIlIIIlIlIIll = llllllllllllllIIlllIIlIIIlIllIlI - this.posX;
                final double llllllllllllllIIlllIIlIIIlIlIIlI = llllllllllllllIIlllIIlIIIlIIllII - this.posY;
                final double llllllllllllllIIlllIIlIIIlIlIIIl = llllllllllllllIIlllIIlIIIlIIlIll - this.posZ;
                final double llllllllllllllIIlllIIlIIIlIlIIII = llllllllllllllIIlllIIlIIIlIlIIll * llllllllllllllIIlllIIlIIIlIlIIll + llllllllllllllIIlllIIlIIIlIlIIlI * llllllllllllllIIlllIIlIIIlIlIIlI + llllllllllllllIIlllIIlIIIlIlIIIl * llllllllllllllIIlllIIlIIIlIlIIIl;
                if (llllllllllllllIIlllIIlIIIlIlIIII <= 1.0) {
                    return;
                }
                this.boatPosRotationIncrements = 3;
            }
            this.boatX = llllllllllllllIIlllIIlIIIlIllIlI;
            this.boatY = llllllllllllllIIlllIIlIIIlIIllII;
            this.boatZ = llllllllllllllIIlllIIlIIIlIIlIll;
            this.boatYaw = llllllllllllllIIlllIIlIIIlIlIlll;
            this.boatPitch = llllllllllllllIIlllIIlIIIlIIlIIl;
            this.motionX = this.velocityX;
            this.motionY = this.velocityY;
            this.motionZ = this.velocityZ;
        }
    }
    
    public void setForwardDirection(final int llllllllllllllIIlllIIIlllIllIIII) {
        this.dataWatcher.updateObject(18, llllllllllllllIIlllIIIlllIllIIII);
    }
    
    public void setDamageTaken(final float llllllllllllllIIlllIIIllllIIIIlI) {
        this.dataWatcher.updateObject(19, llllllllllllllIIlllIIIllllIIIIlI);
    }
    
    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(17, new Integer(0));
        this.dataWatcher.addObject(18, new Integer(1));
        this.dataWatcher.addObject(19, new Float(0.0f));
    }
    
    @Override
    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            final double llllllllllllllIIlllIIIlllllIIlII = Math.cos(this.rotationYaw * 3.141592653589793 / 180.0) * 0.4;
            final double llllllllllllllIIlllIIIlllllIIIll = Math.sin(this.rotationYaw * 3.141592653589793 / 180.0) * 0.4;
            this.riddenByEntity.setPosition(this.posX + llllllllllllllIIlllIIIlllllIIlII, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + llllllllllllllIIlllIIIlllllIIIll);
        }
    }
    
    public EntityBoat(final World llllllllllllllIIlllIIlIIlIIIIIII, final double llllllllllllllIIlllIIlIIlIIIIlII, final double llllllllllllllIIlllIIlIIIllllllI, final double llllllllllllllIIlllIIlIIIlllllIl) {
        this(llllllllllllllIIlllIIlIIlIIIIIII);
        this.setPosition(llllllllllllllIIlllIIlIIlIIIIlII, llllllllllllllIIlllIIlIIIllllllI, llllllllllllllIIlllIIlIIIlllllIl);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = llllllllllllllIIlllIIlIIlIIIIlII;
        this.prevPosY = llllllllllllllIIlllIIlIIIllllllI;
        this.prevPosZ = llllllllllllllIIlllIIlIIIlllllIl;
    }
    
    @Override
    public boolean interactFirst(final EntityPlayer llllllllllllllIIlllIIIllllIllIII) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != llllllllllllllIIlllIIIllllIllIII) {
            return true;
        }
        if (!this.worldObj.isRemote) {
            llllllllllllllIIlllIIIllllIllIII.mountEntity(this);
        }
        return true;
    }
    
    public float getDamageTaken() {
        return this.dataWatcher.getWatchableObjectFloat(19);
    }
    
    @Override
    public void setVelocity(final double llllllllllllllIIlllIIlIIIIlllIlI, final double llllllllllllllIIlllIIlIIIIllllIl, final double llllllllllllllIIlllIIlIIIIlllIII) {
        this.motionX = llllllllllllllIIlllIIlIIIIlllIlI;
        this.velocityX = llllllllllllllIIlllIIlIIIIlllIlI;
        this.motionY = llllllllllllllIIlllIIlIIIIllllIl;
        this.velocityY = llllllllllllllIIlllIIlIIIIllllIl;
        this.motionZ = llllllllllllllIIlllIIlIIIIlllIII;
        this.velocityZ = llllllllllllllIIlllIIlIIIIlllIII;
    }
}
