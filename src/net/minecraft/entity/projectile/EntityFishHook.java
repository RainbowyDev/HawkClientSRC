package net.minecraft.entity.projectile;

import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.stats.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;

public class EntityFishHook extends Entity
{
    private /* synthetic */ int ticksCaughtDelay;
    private /* synthetic */ boolean inGround;
    public /* synthetic */ int shake;
    private static final /* synthetic */ List VALUABLES;
    private /* synthetic */ int fishPosRotationIncrements;
    private /* synthetic */ int xTile;
    private /* synthetic */ double fishY;
    private /* synthetic */ double fishYaw;
    private /* synthetic */ double clientMotionY;
    private static final /* synthetic */ List FISH;
    private /* synthetic */ int yTile;
    private static final /* synthetic */ List JUNK;
    private /* synthetic */ double fishZ;
    private /* synthetic */ int zTile;
    private /* synthetic */ double fishX;
    private /* synthetic */ int ticksCatchable;
    private /* synthetic */ double clientMotionZ;
    private /* synthetic */ double fishPitch;
    private /* synthetic */ Block inTile;
    private /* synthetic */ double clientMotionX;
    private /* synthetic */ int ticksCatchableDelay;
    public /* synthetic */ Entity caughtEntity;
    private /* synthetic */ int ticksInAir;
    public /* synthetic */ EntityPlayer angler;
    private /* synthetic */ float fishApproachAngle;
    private /* synthetic */ int ticksInGround;
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.fishPosRotationIncrements > 0) {
            final double llllllllllllllIlIllIIIIlllIlIIIl = this.posX + (this.fishX - this.posX) / this.fishPosRotationIncrements;
            final double llllllllllllllIlIllIIIIlllIlIIII = this.posY + (this.fishY - this.posY) / this.fishPosRotationIncrements;
            final double llllllllllllllIlIllIIIIlllIIllll = this.posZ + (this.fishZ - this.posZ) / this.fishPosRotationIncrements;
            final double llllllllllllllIlIllIIIIlllIIlllI = MathHelper.wrapAngleTo180_double(this.fishYaw - this.rotationYaw);
            this.rotationYaw += (float)(llllllllllllllIlIllIIIIlllIIlllI / this.fishPosRotationIncrements);
            this.rotationPitch += (float)((this.fishPitch - this.rotationPitch) / this.fishPosRotationIncrements);
            --this.fishPosRotationIncrements;
            this.setPosition(llllllllllllllIlIllIIIIlllIlIIIl, llllllllllllllIlIllIIIIlllIlIIII, llllllllllllllIlIllIIIIlllIIllll);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        else {
            if (!this.worldObj.isRemote) {
                final ItemStack llllllllllllllIlIllIIIIlllIIllIl = this.angler.getCurrentEquippedItem();
                if (this.angler.isDead || !this.angler.isEntityAlive() || llllllllllllllIlIllIIIIlllIIllIl == null || llllllllllllllIlIllIIIIlllIIllIl.getItem() != Items.fishing_rod || this.getDistanceSqToEntity(this.angler) > 1024.0) {
                    this.setDead();
                    this.angler.fishEntity = null;
                    return;
                }
                if (this.caughtEntity != null) {
                    if (!this.caughtEntity.isDead) {
                        this.posX = this.caughtEntity.posX;
                        final double llllllllllllllIlIllIIIIlllIIllII = this.caughtEntity.height;
                        this.posY = this.caughtEntity.getEntityBoundingBox().minY + llllllllllllllIlIllIIIIlllIIllII * 0.8;
                        this.posZ = this.caughtEntity.posZ;
                        return;
                    }
                    this.caughtEntity = null;
                }
            }
            if (this.shake > 0) {
                --this.shake;
            }
            if (this.inGround) {
                if (this.worldObj.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock() == this.inTile) {
                    ++this.ticksInGround;
                    if (this.ticksInGround == 1200) {
                        this.setDead();
                    }
                    return;
                }
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2f;
                this.motionY *= this.rand.nextFloat() * 0.2f;
                this.motionZ *= this.rand.nextFloat() * 0.2f;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
            else {
                ++this.ticksInAir;
            }
            Vec3 llllllllllllllIlIllIIIIlllIIlIll = new Vec3(this.posX, this.posY, this.posZ);
            Vec3 llllllllllllllIlIllIIIIlllIIlIlI = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition llllllllllllllIlIllIIIIlllIIlIIl = this.worldObj.rayTraceBlocks(llllllllllllllIlIllIIIIlllIIlIll, llllllllllllllIlIllIIIIlllIIlIlI);
            llllllllllllllIlIllIIIIlllIIlIll = new Vec3(this.posX, this.posY, this.posZ);
            llllllllllllllIlIllIIIIlllIIlIlI = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (llllllllllllllIlIllIIIIlllIIlIIl != null) {
                llllllllllllllIlIllIIIIlllIIlIlI = new Vec3(llllllllllllllIlIllIIIIlllIIlIIl.hitVec.xCoord, llllllllllllllIlIllIIIIlllIIlIIl.hitVec.yCoord, llllllllllllllIlIllIIIIlllIIlIIl.hitVec.zCoord);
            }
            Entity llllllllllllllIlIllIIIIlllIIlIII = null;
            final List llllllllllllllIlIllIIIIlllIIIlll = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
            double llllllllllllllIlIllIIIIlllIIIllI = 0.0;
            for (int llllllllllllllIlIllIIIIlllIIIIll = 0; llllllllllllllIlIllIIIIlllIIIIll < llllllllllllllIlIllIIIIlllIIIlll.size(); ++llllllllllllllIlIllIIIIlllIIIIll) {
                final Entity llllllllllllllIlIllIIIIlllIIIIlI = llllllllllllllIlIllIIIIlllIIIlll.get(llllllllllllllIlIllIIIIlllIIIIll);
                if (llllllllllllllIlIllIIIIlllIIIIlI.canBeCollidedWith() && (llllllllllllllIlIllIIIIlllIIIIlI != this.angler || this.ticksInAir >= 5)) {
                    final float llllllllllllllIlIllIIIIlllIIIIIl = 0.3f;
                    final AxisAlignedBB llllllllllllllIlIllIIIIlllIIIIII = llllllllllllllIlIllIIIIlllIIIIlI.getEntityBoundingBox().expand(llllllllllllllIlIllIIIIlllIIIIIl, llllllllllllllIlIllIIIIlllIIIIIl, llllllllllllllIlIllIIIIlllIIIIIl);
                    final MovingObjectPosition llllllllllllllIlIllIIIIllIllllll = llllllllllllllIlIllIIIIlllIIIIII.calculateIntercept(llllllllllllllIlIllIIIIlllIIlIll, llllllllllllllIlIllIIIIlllIIlIlI);
                    if (llllllllllllllIlIllIIIIllIllllll != null) {
                        final double llllllllllllllIlIllIIIIlllIIIlIl = llllllllllllllIlIllIIIIlllIIlIll.distanceTo(llllllllllllllIlIllIIIIllIllllll.hitVec);
                        if (llllllllllllllIlIllIIIIlllIIIlIl < llllllllllllllIlIllIIIIlllIIIllI || llllllllllllllIlIllIIIIlllIIIllI == 0.0) {
                            llllllllllllllIlIllIIIIlllIIlIII = llllllllllllllIlIllIIIIlllIIIIlI;
                            llllllllllllllIlIllIIIIlllIIIllI = llllllllllllllIlIllIIIIlllIIIlIl;
                        }
                    }
                }
            }
            if (llllllllllllllIlIllIIIIlllIIlIII != null) {
                llllllllllllllIlIllIIIIlllIIlIIl = new MovingObjectPosition(llllllllllllllIlIllIIIIlllIIlIII);
            }
            if (llllllllllllllIlIllIIIIlllIIlIIl != null) {
                if (llllllllllllllIlIllIIIIlllIIlIIl.entityHit != null) {
                    if (llllllllllllllIlIllIIIIlllIIlIIl.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.angler), 0.0f)) {
                        this.caughtEntity = llllllllllllllIlIllIIIIlllIIlIIl.entityHit;
                    }
                }
                else {
                    this.inGround = true;
                }
            }
            if (!this.inGround) {
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                final float llllllllllllllIlIllIIIIllIlllllI = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
                this.rotationPitch = (float)(Math.atan2(this.motionY, llllllllllllllIlIllIIIIllIlllllI) * 180.0 / 3.141592653589793);
                while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
                    this.prevRotationPitch -= 360.0f;
                }
                while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
                    this.prevRotationPitch += 360.0f;
                }
                while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
                    this.prevRotationYaw -= 360.0f;
                }
                while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
                    this.prevRotationYaw += 360.0f;
                }
                this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
                this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
                float llllllllllllllIlIllIIIIllIllllIl = 0.92f;
                if (this.onGround || this.isCollidedHorizontally) {
                    llllllllllllllIlIllIIIIllIllllIl = 0.5f;
                }
                final byte llllllllllllllIlIllIIIIllIllllII = 5;
                double llllllllllllllIlIllIIIIllIlllIll = 0.0;
                for (int llllllllllllllIlIllIIIIllIllIlll = 0; llllllllllllllIlIllIIIIllIllIlll < llllllllllllllIlIllIIIIllIllllII; ++llllllllllllllIlIllIIIIllIllIlll) {
                    final AxisAlignedBB llllllllllllllIlIllIIIIllIllIllI = this.getEntityBoundingBox();
                    final double llllllllllllllIlIllIIIIllIllIlIl = llllllllllllllIlIllIIIIllIllIllI.maxY - llllllllllllllIlIllIIIIllIllIllI.minY;
                    final double llllllllllllllIlIllIIIIllIllIlII = llllllllllllllIlIllIIIIllIllIllI.minY + llllllllllllllIlIllIIIIllIllIlIl * llllllllllllllIlIllIIIIllIllIlll / llllllllllllllIlIllIIIIllIllllII;
                    final double llllllllllllllIlIllIIIIllIlllIlI = llllllllllllllIlIllIIIIllIllIllI.minY + llllllllllllllIlIllIIIIllIllIlIl * (llllllllllllllIlIllIIIIllIllIlll + 1) / llllllllllllllIlIllIIIIllIllllII;
                    final AxisAlignedBB llllllllllllllIlIllIIIIllIllIIll = new AxisAlignedBB(llllllllllllllIlIllIIIIllIllIllI.minX, llllllllllllllIlIllIIIIllIllIlII, llllllllllllllIlIllIIIIllIllIllI.minZ, llllllllllllllIlIllIIIIllIllIllI.maxX, llllllllllllllIlIllIIIIllIlllIlI, llllllllllllllIlIllIIIIllIllIllI.maxZ);
                    if (this.worldObj.isAABBInMaterial(llllllllllllllIlIllIIIIllIllIIll, Material.water)) {
                        llllllllllllllIlIllIIIIllIlllIll += 1.0 / llllllllllllllIlIllIIIIllIllllII;
                    }
                }
                if (!this.worldObj.isRemote && llllllllllllllIlIllIIIIllIlllIll > 0.0) {
                    final WorldServer llllllllllllllIlIllIIIIllIllIIlI = (WorldServer)this.worldObj;
                    int llllllllllllllIlIllIIIIllIllIIIl = 1;
                    final BlockPos llllllllllllllIlIllIIIIllIllIIII = new BlockPos(this).offsetUp();
                    if (this.rand.nextFloat() < 0.25f && this.worldObj.func_175727_C(llllllllllllllIlIllIIIIllIllIIII)) {
                        llllllllllllllIlIllIIIIllIllIIIl = 2;
                    }
                    if (this.rand.nextFloat() < 0.5f && !this.worldObj.isAgainstSky(llllllllllllllIlIllIIIIllIllIIII)) {
                        --llllllllllllllIlIllIIIIllIllIIIl;
                    }
                    if (this.ticksCatchable > 0) {
                        --this.ticksCatchable;
                        if (this.ticksCatchable <= 0) {
                            this.ticksCaughtDelay = 0;
                            this.ticksCatchableDelay = 0;
                        }
                    }
                    else if (this.ticksCatchableDelay > 0) {
                        this.ticksCatchableDelay -= llllllllllllllIlIllIIIIllIllIIIl;
                        if (this.ticksCatchableDelay <= 0) {
                            this.motionY -= 0.20000000298023224;
                            this.playSound("random.splash", 0.25f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                            final float llllllllllllllIlIllIIIIllIlIllll = (float)MathHelper.floor_double(this.getEntityBoundingBox().minY);
                            llllllllllllllIlIllIIIIllIllIIlI.func_175739_a(EnumParticleTypes.WATER_BUBBLE, this.posX, llllllllllllllIlIllIIIIllIlIllll + 1.0f, this.posZ, (int)(1.0f + this.width * 20.0f), this.width, 0.0, this.width, 0.20000000298023224, new int[0]);
                            llllllllllllllIlIllIIIIllIllIIlI.func_175739_a(EnumParticleTypes.WATER_WAKE, this.posX, llllllllllllllIlIllIIIIllIlIllll + 1.0f, this.posZ, (int)(1.0f + this.width * 20.0f), this.width, 0.0, this.width, 0.20000000298023224, new int[0]);
                            this.ticksCatchable = MathHelper.getRandomIntegerInRange(this.rand, 10, 30);
                        }
                        else {
                            this.fishApproachAngle += (float)(this.rand.nextGaussian() * 4.0);
                            final float llllllllllllllIlIllIIIIllIlIlllI = this.fishApproachAngle * 0.017453292f;
                            final float llllllllllllllIlIllIIIIllIlIlIII = MathHelper.sin(llllllllllllllIlIllIIIIllIlIlllI);
                            final float llllllllllllllIlIllIIIIllIlIllII = MathHelper.cos(llllllllllllllIlIllIIIIllIlIlllI);
                            final double llllllllllllllIlIllIIIIllIlllIIl = this.posX + llllllllllllllIlIllIIIIllIlIlIII * this.ticksCatchableDelay * 0.1f;
                            final double llllllllllllllIlIllIIIIllIlIIllI = MathHelper.floor_double(this.getEntityBoundingBox().minY) + 1.0f;
                            final double llllllllllllllIlIllIIIIllIlIlIlI = this.posZ + llllllllllllllIlIllIIIIllIlIllII * this.ticksCatchableDelay * 0.1f;
                            if (this.rand.nextFloat() < 0.15f) {
                                llllllllllllllIlIllIIIIllIllIIlI.func_175739_a(EnumParticleTypes.WATER_BUBBLE, llllllllllllllIlIllIIIIllIlllIIl, llllllllllllllIlIllIIIIllIlIIllI - 0.10000000149011612, llllllllllllllIlIllIIIIllIlIlIlI, 1, llllllllllllllIlIllIIIIllIlIlIII, 0.1, llllllllllllllIlIllIIIIllIlIllII, 0.0, new int[0]);
                            }
                            final float llllllllllllllIlIllIIIIllIlIIlII = llllllllllllllIlIllIIIIllIlIlIII * 0.04f;
                            final float llllllllllllllIlIllIIIIllIlIIIll = llllllllllllllIlIllIIIIllIlIllII * 0.04f;
                            llllllllllllllIlIllIIIIllIllIIlI.func_175739_a(EnumParticleTypes.WATER_WAKE, llllllllllllllIlIllIIIIllIlllIIl, llllllllllllllIlIllIIIIllIlIIllI, llllllllllllllIlIllIIIIllIlIlIlI, 0, llllllllllllllIlIllIIIIllIlIIIll, 0.01, -llllllllllllllIlIllIIIIllIlIIlII, 1.0, new int[0]);
                            llllllllllllllIlIllIIIIllIllIIlI.func_175739_a(EnumParticleTypes.WATER_WAKE, llllllllllllllIlIllIIIIllIlllIIl, llllllllllllllIlIllIIIIllIlIIllI, llllllllllllllIlIllIIIIllIlIlIlI, 0, -llllllllllllllIlIllIIIIllIlIIIll, 0.01, llllllllllllllIlIllIIIIllIlIIlII, 1.0, new int[0]);
                        }
                    }
                    else if (this.ticksCaughtDelay > 0) {
                        this.ticksCaughtDelay -= llllllllllllllIlIllIIIIllIllIIIl;
                        float llllllllllllllIlIllIIIIllIlIllIl = 0.15f;
                        if (this.ticksCaughtDelay < 20) {
                            llllllllllllllIlIllIIIIllIlIllIl += (float)((20 - this.ticksCaughtDelay) * 0.05);
                        }
                        else if (this.ticksCaughtDelay < 40) {
                            llllllllllllllIlIllIIIIllIlIllIl += (float)((40 - this.ticksCaughtDelay) * 0.02);
                        }
                        else if (this.ticksCaughtDelay < 60) {
                            llllllllllllllIlIllIIIIllIlIllIl += (float)((60 - this.ticksCaughtDelay) * 0.01);
                        }
                        if (this.rand.nextFloat() < llllllllllllllIlIllIIIIllIlIllIl) {
                            final float llllllllllllllIlIllIIIIllIlIIlll = MathHelper.randomFloatClamp(this.rand, 0.0f, 360.0f) * 0.017453292f;
                            final float llllllllllllllIlIllIIIIllIlIlIll = MathHelper.randomFloatClamp(this.rand, 25.0f, 60.0f);
                            final double llllllllllllllIlIllIIIIllIlllIII = this.posX + MathHelper.sin(llllllllllllllIlIllIIIIllIlIIlll) * llllllllllllllIlIllIIIIllIlIlIll * 0.1f;
                            final double llllllllllllllIlIllIIIIllIlIIlIl = MathHelper.floor_double(this.getEntityBoundingBox().minY) + 1.0f;
                            final double llllllllllllllIlIllIIIIllIlIlIIl = this.posZ + MathHelper.cos(llllllllllllllIlIllIIIIllIlIIlll) * llllllllllllllIlIllIIIIllIlIlIll * 0.1f;
                            llllllllllllllIlIllIIIIllIllIIlI.func_175739_a(EnumParticleTypes.WATER_SPLASH, llllllllllllllIlIllIIIIllIlllIII, llllllllllllllIlIllIIIIllIlIIlIl, llllllllllllllIlIllIIIIllIlIlIIl, 2 + this.rand.nextInt(2), 0.10000000149011612, 0.0, 0.10000000149011612, 0.0, new int[0]);
                        }
                        if (this.ticksCaughtDelay <= 0) {
                            this.fishApproachAngle = MathHelper.randomFloatClamp(this.rand, 0.0f, 360.0f);
                            this.ticksCatchableDelay = MathHelper.getRandomIntegerInRange(this.rand, 20, 80);
                        }
                    }
                    else {
                        this.ticksCaughtDelay = MathHelper.getRandomIntegerInRange(this.rand, 100, 900);
                        this.ticksCaughtDelay -= EnchantmentHelper.func_151387_h(this.angler) * 20 * 5;
                    }
                    if (this.ticksCatchable > 0) {
                        this.motionY -= this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat() * 0.2;
                    }
                }
                final double llllllllllllllIlIllIIIIlllIIIlII = llllllllllllllIlIllIIIIllIlllIll * 2.0 - 1.0;
                this.motionY += 0.03999999910593033 * llllllllllllllIlIllIIIIlllIIIlII;
                if (llllllllllllllIlIllIIIIllIlllIll > 0.0) {
                    llllllllllllllIlIllIIIIllIllllIl *= (float)0.9;
                    this.motionY *= 0.8;
                }
                this.motionX *= llllllllllllllIlIllIIIIllIllllIl;
                this.motionY *= llllllllllllllIlIllIIIIllIllllIl;
                this.motionZ *= llllllllllllllIlIllIIIIllIllllIl;
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
    }
    
    @Override
    protected void entityInit() {
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlIllIIIIlIlllllII) {
        this.xTile = llllllllllllllIlIllIIIIlIlllllII.getShort("xTile");
        this.yTile = llllllllllllllIlIllIIIIlIlllllII.getShort("yTile");
        this.zTile = llllllllllllllIlIllIIIIlIlllllII.getShort("zTile");
        if (llllllllllllllIlIllIIIIlIlllllII.hasKey("inTile", 8)) {
            this.inTile = Block.getBlockFromName(llllllllllllllIlIllIIIIlIlllllII.getString("inTile"));
        }
        else {
            this.inTile = Block.getBlockById(llllllllllllllIlIllIIIIlIlllllII.getByte("inTile") & 0xFF);
        }
        this.shake = (llllllllllllllIlIllIIIIlIlllllII.getByte("shake") & 0xFF);
        this.inGround = (llllllllllllllIlIllIIIIlIlllllII.getByte("inGround") == 1);
    }
    
    @Override
    public void setVelocity(final double llllllllllllllIlIllIIIIlllllIIll, final double llllllllllllllIlIllIIIIlllllIIlI, final double llllllllllllllIlIllIIIIllllIllIl) {
        this.motionX = llllllllllllllIlIllIIIIlllllIIll;
        this.clientMotionX = llllllllllllllIlIllIIIIlllllIIll;
        this.motionY = llllllllllllllIlIllIIIIlllllIIlI;
        this.clientMotionY = llllllllllllllIlIllIIIIlllllIIlI;
        this.motionZ = llllllllllllllIlIllIIIIllllIllIl;
        this.clientMotionZ = llllllllllllllIlIllIIIIllllIllIl;
    }
    
    public void handleHookCasting(double llllllllllllllIlIllIIIlIIIIlllIl, double llllllllllllllIlIllIIIlIIIIlIlII, double llllllllllllllIlIllIIIlIIIIlIIll, final float llllllllllllllIlIllIIIlIIIIlIIlI, final float llllllllllllllIlIllIIIlIIIIlIIIl) {
        final float llllllllllllllIlIllIIIlIIIIllIII = MathHelper.sqrt_double(llllllllllllllIlIllIIIlIIIIlllIl * llllllllllllllIlIllIIIlIIIIlllIl + llllllllllllllIlIllIIIlIIIIlIlII * llllllllllllllIlIllIIIlIIIIlIlII + llllllllllllllIlIllIIIlIIIIlIIll * llllllllllllllIlIllIIIlIIIIlIIll);
        llllllllllllllIlIllIIIlIIIIlllIl /= llllllllllllllIlIllIIIlIIIIllIII;
        llllllllllllllIlIllIIIlIIIIlIlII /= llllllllllllllIlIllIIIlIIIIllIII;
        llllllllllllllIlIllIIIlIIIIlIIll /= llllllllllllllIlIllIIIlIIIIllIII;
        llllllllllllllIlIllIIIlIIIIlllIl += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIlIllIIIlIIIIlIIIl;
        llllllllllllllIlIllIIIlIIIIlIlII += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIlIllIIIlIIIIlIIIl;
        llllllllllllllIlIllIIIlIIIIlIIll += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIlIllIIIlIIIIlIIIl;
        llllllllllllllIlIllIIIlIIIIlllIl *= llllllllllllllIlIllIIIlIIIIlIIlI;
        llllllllllllllIlIllIIIlIIIIlIlII *= llllllllllllllIlIllIIIlIIIIlIIlI;
        llllllllllllllIlIllIIIlIIIIlIIll *= llllllllllllllIlIllIIIlIIIIlIIlI;
        this.motionX = llllllllllllllIlIllIIIlIIIIlllIl;
        this.motionY = llllllllllllllIlIllIIIlIIIIlIlII;
        this.motionZ = llllllllllllllIlIllIIIlIIIIlIIll;
        final float llllllllllllllIlIllIIIlIIIIlIlll = MathHelper.sqrt_double(llllllllllllllIlIllIIIlIIIIlllIl * llllllllllllllIlIllIIIlIIIIlllIl + llllllllllllllIlIllIIIlIIIIlIIll * llllllllllllllIlIllIIIlIIIIlIIll);
        final float n = (float)(Math.atan2(llllllllllllllIlIllIIIlIIIIlllIl, llllllllllllllIlIllIIIlIIIIlIIll) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float)(Math.atan2(llllllllllllllIlIllIIIlIIIIlIlII, llllllllllllllIlIllIIIlIIIIlIlll) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
        this.ticksInGround = 0;
    }
    
    @Override
    public void func_180426_a(final double llllllllllllllIlIllIIIlIIIIIIllI, final double llllllllllllllIlIllIIIlIIIIIIlIl, final double llllllllllllllIlIllIIIlIIIIIIlII, final float llllllllllllllIlIllIIIIllllllIll, final float llllllllllllllIlIllIIIlIIIIIIIlI, final int llllllllllllllIlIllIIIIllllllIIl, final boolean llllllllllllllIlIllIIIlIIIIIIIII) {
        this.fishX = llllllllllllllIlIllIIIlIIIIIIllI;
        this.fishY = llllllllllllllIlIllIIIlIIIIIIlIl;
        this.fishZ = llllllllllllllIlIllIIIlIIIIIIlII;
        this.fishYaw = llllllllllllllIlIllIIIIllllllIll;
        this.fishPitch = llllllllllllllIlIllIIIlIIIIIIIlI;
        this.fishPosRotationIncrements = llllllllllllllIlIllIIIIllllllIIl;
        this.motionX = this.clientMotionX;
        this.motionY = this.clientMotionY;
        this.motionZ = this.clientMotionZ;
    }
    
    private ItemStack func_146033_f() {
        float llllllllllllllIlIllIIIIlIlIIllII = this.worldObj.rand.nextFloat();
        final int llllllllllllllIlIllIIIIlIlIIlIll = EnchantmentHelper.func_151386_g(this.angler);
        final int llllllllllllllIlIllIIIIlIlIIlIlI = EnchantmentHelper.func_151387_h(this.angler);
        float llllllllllllllIlIllIIIIlIlIIlIIl = 0.1f - llllllllllllllIlIllIIIIlIlIIlIll * 0.025f - llllllllllllllIlIllIIIIlIlIIlIlI * 0.01f;
        float llllllllllllllIlIllIIIIlIlIIlIII = 0.05f + llllllllllllllIlIllIIIIlIlIIlIll * 0.01f - llllllllllllllIlIllIIIIlIlIIlIlI * 0.01f;
        llllllllllllllIlIllIIIIlIlIIlIIl = MathHelper.clamp_float(llllllllllllllIlIllIIIIlIlIIlIIl, 0.0f, 1.0f);
        llllllllllllllIlIllIIIIlIlIIlIII = MathHelper.clamp_float(llllllllllllllIlIllIIIIlIlIIlIII, 0.0f, 1.0f);
        if (llllllllllllllIlIllIIIIlIlIIllII < llllllllllllllIlIllIIIIlIlIIlIIl) {
            this.angler.triggerAchievement(StatList.junkFishedStat);
            return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, EntityFishHook.JUNK)).getItemStack(this.rand);
        }
        llllllllllllllIlIllIIIIlIlIIllII -= llllllllllllllIlIllIIIIlIlIIlIIl;
        if (llllllllllllllIlIllIIIIlIlIIllII < llllllllllllllIlIllIIIIlIlIIlIII) {
            this.angler.triggerAchievement(StatList.treasureFishedStat);
            return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, EntityFishHook.VALUABLES)).getItemStack(this.rand);
        }
        final float llllllllllllllIlIllIIIIlIlIIIlll = llllllllllllllIlIllIIIIlIlIIllII - llllllllllllllIlIllIIIIlIlIIlIII;
        this.angler.triggerAchievement(StatList.fishCaughtStat);
        return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, EntityFishHook.FISH)).getItemStack(this.rand);
    }
    
    public EntityFishHook(final World llllllllllllllIlIllIIIlIIlIIIlll, final double llllllllllllllIlIllIIIlIIlIIIIII, final double llllllllllllllIlIllIIIlIIIllllll, final double llllllllllllllIlIllIIIlIIlIIIlII, final EntityPlayer llllllllllllllIlIllIIIlIIlIIIIll) {
        this(llllllllllllllIlIllIIIlIIlIIIlll);
        this.setPosition(llllllllllllllIlIllIIIlIIlIIIIII, llllllllllllllIlIllIIIlIIIllllll, llllllllllllllIlIllIIIlIIlIIIlII);
        this.ignoreFrustumCheck = true;
        this.angler = llllllllllllllIlIllIIIlIIlIIIIll;
        llllllllllllllIlIllIIIlIIlIIIIll.fishEntity = this;
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlIllIIIIllIIIIIIl) {
        llllllllllllllIlIllIIIIllIIIIIIl.setShort("xTile", (short)this.xTile);
        llllllllllllllIlIllIIIIllIIIIIIl.setShort("yTile", (short)this.yTile);
        llllllllllllllIlIllIIIIllIIIIIIl.setShort("zTile", (short)this.zTile);
        final ResourceLocation llllllllllllllIlIllIIIIllIIIIIll = (ResourceLocation)Block.blockRegistry.getNameForObject(this.inTile);
        llllllllllllllIlIllIIIIllIIIIIIl.setString("inTile", (llllllllllllllIlIllIIIIllIIIIIll == null) ? "" : llllllllllllllIlIllIIIIllIIIIIll.toString());
        llllllllllllllIlIllIIIIllIIIIIIl.setByte("shake", (byte)this.shake);
        llllllllllllllIlIllIIIIllIIIIIIl.setByte("inGround", (byte)(this.inGround ? 1 : 0));
    }
    
    public EntityFishHook(final World llllllllllllllIlIllIIIlIIlIIllll) {
        super(llllllllllllllIlIllIIIlIIlIIllll);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.setSize(0.25f, 0.25f);
        this.ignoreFrustumCheck = true;
    }
    
    static {
        __OBFID = "CL_00001663";
        JUNK = Arrays.asList(new WeightedRandomFishable(new ItemStack(Items.leather_boots), 10).setMaxDamagePercent(0.9f), new WeightedRandomFishable(new ItemStack(Items.leather), 10), new WeightedRandomFishable(new ItemStack(Items.bone), 10), new WeightedRandomFishable(new ItemStack(Items.potionitem), 10), new WeightedRandomFishable(new ItemStack(Items.string), 5), new WeightedRandomFishable(new ItemStack(Items.fishing_rod), 2).setMaxDamagePercent(0.9f), new WeightedRandomFishable(new ItemStack(Items.bowl), 10), new WeightedRandomFishable(new ItemStack(Items.stick), 5), new WeightedRandomFishable(new ItemStack(Items.dye, 10, EnumDyeColor.BLACK.getDyeColorDamage()), 1), new WeightedRandomFishable(new ItemStack(Blocks.tripwire_hook), 10), new WeightedRandomFishable(new ItemStack(Items.rotten_flesh), 10));
        VALUABLES = Arrays.asList(new WeightedRandomFishable(new ItemStack(Blocks.waterlily), 1), new WeightedRandomFishable(new ItemStack(Items.name_tag), 1), new WeightedRandomFishable(new ItemStack(Items.saddle), 1), new WeightedRandomFishable(new ItemStack(Items.bow), 1).setMaxDamagePercent(0.25f).setEnchantable(), new WeightedRandomFishable(new ItemStack(Items.fishing_rod), 1).setMaxDamagePercent(0.25f).setEnchantable(), new WeightedRandomFishable(new ItemStack(Items.book), 1).setEnchantable());
        FISH = Arrays.asList(new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.COD.getItemDamage()), 60), new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.SALMON.getItemDamage()), 25), new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.CLOWNFISH.getItemDamage()), 2), new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.PUFFERFISH.getItemDamage()), 13));
    }
    
    public static List func_174855_j() {
        return EntityFishHook.FISH;
    }
    
    public int handleHookRetraction() {
        if (this.worldObj.isRemote) {
            return 0;
        }
        byte llllllllllllllIlIllIIIIlIllIllII = 0;
        if (this.caughtEntity != null) {
            final double llllllllllllllIlIllIIIIlIllIlIll = this.angler.posX - this.posX;
            final double llllllllllllllIlIllIIIIlIllIlIlI = this.angler.posY - this.posY;
            final double llllllllllllllIlIllIIIIlIllIlIIl = this.angler.posZ - this.posZ;
            final double llllllllllllllIlIllIIIIlIllIlIII = MathHelper.sqrt_double(llllllllllllllIlIllIIIIlIllIlIll * llllllllllllllIlIllIIIIlIllIlIll + llllllllllllllIlIllIIIIlIllIlIlI * llllllllllllllIlIllIIIIlIllIlIlI + llllllllllllllIlIllIIIIlIllIlIIl * llllllllllllllIlIllIIIIlIllIlIIl);
            final double llllllllllllllIlIllIIIIlIllIIlll = 0.1;
            final Entity caughtEntity = this.caughtEntity;
            caughtEntity.motionX += llllllllllllllIlIllIIIIlIllIlIll * llllllllllllllIlIllIIIIlIllIIlll;
            final Entity caughtEntity2 = this.caughtEntity;
            caughtEntity2.motionY += llllllllllllllIlIllIIIIlIllIlIlI * llllllllllllllIlIllIIIIlIllIIlll + MathHelper.sqrt_double(llllllllllllllIlIllIIIIlIllIlIII) * 0.08;
            final Entity caughtEntity3 = this.caughtEntity;
            caughtEntity3.motionZ += llllllllllllllIlIllIIIIlIllIlIIl * llllllllllllllIlIllIIIIlIllIIlll;
            llllllllllllllIlIllIIIIlIllIllII = 3;
        }
        else if (this.ticksCatchable > 0) {
            final EntityItem llllllllllllllIlIllIIIIlIllIIllI = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.func_146033_f());
            final double llllllllllllllIlIllIIIIlIllIIlIl = this.angler.posX - this.posX;
            final double llllllllllllllIlIllIIIIlIllIIlII = this.angler.posY - this.posY;
            final double llllllllllllllIlIllIIIIlIllIIIll = this.angler.posZ - this.posZ;
            final double llllllllllllllIlIllIIIIlIllIIIlI = MathHelper.sqrt_double(llllllllllllllIlIllIIIIlIllIIlIl * llllllllllllllIlIllIIIIlIllIIlIl + llllllllllllllIlIllIIIIlIllIIlII * llllllllllllllIlIllIIIIlIllIIlII + llllllllllllllIlIllIIIIlIllIIIll * llllllllllllllIlIllIIIIlIllIIIll);
            final double llllllllllllllIlIllIIIIlIllIIIIl = 0.1;
            llllllllllllllIlIllIIIIlIllIIllI.motionX = llllllllllllllIlIllIIIIlIllIIlIl * llllllllllllllIlIllIIIIlIllIIIIl;
            llllllllllllllIlIllIIIIlIllIIllI.motionY = llllllllllllllIlIllIIIIlIllIIlII * llllllllllllllIlIllIIIIlIllIIIIl + MathHelper.sqrt_double(llllllllllllllIlIllIIIIlIllIIIlI) * 0.08;
            llllllllllllllIlIllIIIIlIllIIllI.motionZ = llllllllllllllIlIllIIIIlIllIIIll * llllllllllllllIlIllIIIIlIllIIIIl;
            this.worldObj.spawnEntityInWorld(llllllllllllllIlIllIIIIlIllIIllI);
            this.angler.worldObj.spawnEntityInWorld(new EntityXPOrb(this.angler.worldObj, this.angler.posX, this.angler.posY + 0.5, this.angler.posZ + 0.5, this.rand.nextInt(6) + 1));
            llllllllllllllIlIllIIIIlIllIllII = 1;
        }
        if (this.inGround) {
            llllllllllllllIlIllIIIIlIllIllII = 2;
        }
        this.setDead();
        this.angler.fishEntity = null;
        return llllllllllllllIlIllIIIIlIllIllII;
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double llllllllllllllIlIllIIIlIIIlIlIII) {
        double llllllllllllllIlIllIIIlIIIlIlIlI = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0;
        llllllllllllllIlIllIIIlIIIlIlIlI *= 64.0;
        return llllllllllllllIlIllIIIlIIIlIlIII < llllllllllllllIlIllIIIlIIIlIlIlI * llllllllllllllIlIllIIIlIIIlIlIlI;
    }
    
    public EntityFishHook(final World llllllllllllllIlIllIIIlIIIllIIll, final EntityPlayer llllllllllllllIlIllIIIlIIIllIllI) {
        super(llllllllllllllIlIllIIIlIIIllIIll);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.ignoreFrustumCheck = true;
        this.angler = llllllllllllllIlIllIIIlIIIllIllI;
        this.angler.fishEntity = this;
        this.setSize(0.25f, 0.25f);
        this.setLocationAndAngles(llllllllllllllIlIllIIIlIIIllIllI.posX, llllllllllllllIlIllIIIlIIIllIllI.posY + llllllllllllllIlIllIIIlIIIllIllI.getEyeHeight(), llllllllllllllIlIllIIIlIIIllIllI.posZ, llllllllllllllIlIllIIIlIIIllIllI.rotationYaw, llllllllllllllIlIllIIIlIIIllIllI.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        final float llllllllllllllIlIllIIIlIIIllIlIl = 0.4f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * llllllllllllllIlIllIIIlIIIllIlIl;
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * llllllllllllllIlIllIIIlIIIllIlIl;
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.1415927f) * llllllllllllllIlIllIIIlIIIllIlIl;
        this.handleHookCasting(this.motionX, this.motionY, this.motionZ, 1.5f, 1.0f);
    }
    
    @Override
    public void setDead() {
        super.setDead();
        if (this.angler != null) {
            this.angler.fishEntity = null;
        }
    }
}
