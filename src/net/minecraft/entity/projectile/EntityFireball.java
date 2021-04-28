package net.minecraft.entity.projectile;

import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.util.*;

public abstract class EntityFireball extends Entity
{
    public /* synthetic */ double accelerationZ;
    public /* synthetic */ EntityLivingBase shootingEntity;
    public /* synthetic */ double accelerationY;
    public /* synthetic */ double accelerationX;
    private /* synthetic */ boolean inGround;
    private /* synthetic */ Block field_145796_h;
    private /* synthetic */ int field_145795_e;
    private /* synthetic */ int field_145793_f;
    private /* synthetic */ int ticksAlive;
    private /* synthetic */ int field_145794_g;
    private /* synthetic */ int ticksInAir;
    
    public EntityFireball(final World lllllllllllllllIIllIIIIIlllllIll, final EntityLivingBase lllllllllllllllIIllIIIIIllllIIll, double lllllllllllllllIIllIIIIIllllIIlI, double lllllllllllllllIIllIIIIIllllIIIl, double lllllllllllllllIIllIIIIIllllIIII) {
        super(lllllllllllllllIIllIIIIIlllllIll);
        this.field_145795_e = -1;
        this.field_145793_f = -1;
        this.field_145794_g = -1;
        this.shootingEntity = lllllllllllllllIIllIIIIIllllIIll;
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(lllllllllllllllIIllIIIIIllllIIll.posX, lllllllllllllllIIllIIIIIllllIIll.posY, lllllllllllllllIIllIIIIIllllIIll.posZ, lllllllllllllllIIllIIIIIllllIIll.rotationYaw, lllllllllllllllIIllIIIIIllllIIll.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        final double motionX = 0.0;
        this.motionZ = motionX;
        this.motionY = motionX;
        this.motionX = motionX;
        lllllllllllllllIIllIIIIIllllIIlI += this.rand.nextGaussian() * 0.4;
        lllllllllllllllIIllIIIIIllllIIIl += this.rand.nextGaussian() * 0.4;
        lllllllllllllllIIllIIIIIllllIIII += (String)(this.rand.nextGaussian() * 0.4);
        final double lllllllllllllllIIllIIIIIllllIllI = MathHelper.sqrt_double((double)(lllllllllllllllIIllIIIIIllllIIlI * lllllllllllllllIIllIIIIIllllIIlI + lllllllllllllllIIllIIIIIllllIIIl * lllllllllllllllIIllIIIIIllllIIIl + lllllllllllllllIIllIIIIIllllIIII * lllllllllllllllIIllIIIIIllllIIII));
        this.accelerationX = lllllllllllllllIIllIIIIIllllIIlI / lllllllllllllllIIllIIIIIllllIllI * 0.1;
        this.accelerationY = lllllllllllllllIIllIIIIIllllIIIl / lllllllllllllllIIllIIIIIllllIllI * 0.1;
        this.accelerationZ = (double)(lllllllllllllllIIllIIIIIllllIIII / lllllllllllllllIIllIIIIIllllIllI * 0.1);
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIllIIIIIIlIIllIl) {
        this.field_145795_e = lllllllllllllllIIllIIIIIIlIIllIl.getShort("xTile");
        this.field_145793_f = lllllllllllllllIIllIIIIIIlIIllIl.getShort("yTile");
        this.field_145794_g = lllllllllllllllIIllIIIIIIlIIllIl.getShort("zTile");
        if (lllllllllllllllIIllIIIIIIlIIllIl.hasKey("inTile", 8)) {
            this.field_145796_h = Block.getBlockFromName(lllllllllllllllIIllIIIIIIlIIllIl.getString("inTile"));
        }
        else {
            this.field_145796_h = Block.getBlockById(lllllllllllllllIIllIIIIIIlIIllIl.getByte("inTile") & 0xFF);
        }
        this.inGround = (lllllllllllllllIIllIIIIIIlIIllIl.getByte("inGround") == 1);
        if (lllllllllllllllIIllIIIIIIlIIllIl.hasKey("direction", 9)) {
            final NBTTagList lllllllllllllllIIllIIIIIIlIlIIII = lllllllllllllllIIllIIIIIIlIIllIl.getTagList("direction", 6);
            this.motionX = lllllllllllllllIIllIIIIIIlIlIIII.getDouble(0);
            this.motionY = lllllllllllllllIIllIIIIIIlIlIIII.getDouble(1);
            this.motionZ = lllllllllllllllIIllIIIIIIlIlIIII.getDouble(2);
        }
        else {
            this.setDead();
        }
    }
    
    public EntityFireball(final World lllllllllllllllIIllIIIIlIIlIlIll) {
        super(lllllllllllllllIIllIIIIlIIlIlIll);
        this.field_145795_e = -1;
        this.field_145793_f = -1;
        this.field_145794_g = -1;
        this.setSize(1.0f, 1.0f);
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllllIIllIIIIIIIlIllIl) {
        return 15728880;
    }
    
    @Override
    protected void entityInit() {
    }
    
    protected float getMotionFactor() {
        return 0.95f;
    }
    
    @Override
    public float getBrightness(final float lllllllllllllllIIllIIIIIIIllIIIl) {
        return 1.0f;
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIllIIIIIIllllllI) {
        lllllllllllllllIIllIIIIIIllllllI.setShort("xTile", (short)this.field_145795_e);
        lllllllllllllllIIllIIIIIIllllllI.setShort("yTile", (short)this.field_145793_f);
        lllllllllllllllIIllIIIIIIllllllI.setShort("zTile", (short)this.field_145794_g);
        final ResourceLocation lllllllllllllllIIllIIIIIlIIIIIII = (ResourceLocation)Block.blockRegistry.getNameForObject(this.field_145796_h);
        lllllllllllllllIIllIIIIIIllllllI.setString("inTile", (lllllllllllllllIIllIIIIIlIIIIIII == null) ? "" : lllllllllllllllIIllIIIIIlIIIIIII.toString());
        lllllllllllllllIIllIIIIIIllllllI.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        lllllllllllllllIIllIIIIIIllllllI.setTag("direction", this.newDoubleNBTList(this.motionX, this.motionY, this.motionZ));
    }
    
    @Override
    public void onUpdate() {
        if (!this.worldObj.isRemote && ((this.shootingEntity != null && this.shootingEntity.isDead) || !this.worldObj.isBlockLoaded(new BlockPos(this)))) {
            this.setDead();
        }
        else {
            super.onUpdate();
            this.setFire(1);
            if (this.inGround) {
                if (this.worldObj.getBlockState(new BlockPos(this.field_145795_e, this.field_145793_f, this.field_145794_g)).getBlock() == this.field_145796_h) {
                    ++this.ticksAlive;
                    if (this.ticksAlive == 600) {
                        this.setDead();
                    }
                    return;
                }
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2f;
                this.motionY *= this.rand.nextFloat() * 0.2f;
                this.motionZ *= this.rand.nextFloat() * 0.2f;
                this.ticksAlive = 0;
                this.ticksInAir = 0;
            }
            else {
                ++this.ticksInAir;
            }
            Vec3 lllllllllllllllIIllIIIIIlIllllll = new Vec3(this.posX, this.posY, this.posZ);
            Vec3 lllllllllllllllIIllIIIIIlIlllllI = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition lllllllllllllllIIllIIIIIlIllllII = this.worldObj.rayTraceBlocks(lllllllllllllllIIllIIIIIlIllllll, lllllllllllllllIIllIIIIIlIlllllI);
            lllllllllllllllIIllIIIIIlIllllll = new Vec3(this.posX, this.posY, this.posZ);
            lllllllllllllllIIllIIIIIlIlllllI = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (lllllllllllllllIIllIIIIIlIllllII != null) {
                lllllllllllllllIIllIIIIIlIlllllI = new Vec3(lllllllllllllllIIllIIIIIlIllllII.hitVec.xCoord, lllllllllllllllIIllIIIIIlIllllII.hitVec.yCoord, lllllllllllllllIIllIIIIIlIllllII.hitVec.zCoord);
            }
            Entity lllllllllllllllIIllIIIIIlIlllIll = null;
            final List lllllllllllllllIIllIIIIIlIlllIlI = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
            double lllllllllllllllIIllIIIIIlIlllIII = 0.0;
            for (int lllllllllllllllIIllIIIIIlIllIllI = 0; lllllllllllllllIIllIIIIIlIllIllI < lllllllllllllllIIllIIIIIlIlllIlI.size(); ++lllllllllllllllIIllIIIIIlIllIllI) {
                final Entity lllllllllllllllIIllIIIIIlIllIlII = lllllllllllllllIIllIIIIIlIlllIlI.get(lllllllllllllllIIllIIIIIlIllIllI);
                if (lllllllllllllllIIllIIIIIlIllIlII.canBeCollidedWith() && (!lllllllllllllllIIllIIIIIlIllIlII.isEntityEqual(this.shootingEntity) || this.ticksInAir >= 25)) {
                    final float lllllllllllllllIIllIIIIIlIllIIlI = 0.3f;
                    final AxisAlignedBB lllllllllllllllIIllIIIIIlIllIIII = lllllllllllllllIIllIIIIIlIllIlII.getEntityBoundingBox().expand(lllllllllllllllIIllIIIIIlIllIIlI, lllllllllllllllIIllIIIIIlIllIIlI, lllllllllllllllIIllIIIIIlIllIIlI);
                    final MovingObjectPosition lllllllllllllllIIllIIIIIlIlIlllI = lllllllllllllllIIllIIIIIlIllIIII.calculateIntercept(lllllllllllllllIIllIIIIIlIllllll, lllllllllllllllIIllIIIIIlIlllllI);
                    if (lllllllllllllllIIllIIIIIlIlIlllI != null) {
                        final double lllllllllllllllIIllIIIIIlIlIllII = lllllllllllllllIIllIIIIIlIllllll.distanceTo(lllllllllllllllIIllIIIIIlIlIlllI.hitVec);
                        if (lllllllllllllllIIllIIIIIlIlIllII < lllllllllllllllIIllIIIIIlIlllIII || lllllllllllllllIIllIIIIIlIlllIII == 0.0) {
                            lllllllllllllllIIllIIIIIlIlllIll = lllllllllllllllIIllIIIIIlIllIlII;
                            lllllllllllllllIIllIIIIIlIlllIII = lllllllllllllllIIllIIIIIlIlIllII;
                        }
                    }
                }
            }
            if (lllllllllllllllIIllIIIIIlIlllIll != null) {
                lllllllllllllllIIllIIIIIlIllllII = new MovingObjectPosition(lllllllllllllllIIllIIIIIlIlllIll);
            }
            if (lllllllllllllllIIllIIIIIlIllllII != null) {
                this.onImpact(lllllllllllllllIIllIIIIIlIllllII);
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            final float lllllllllllllllIIllIIIIIlIlIlIll = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) + 90.0f;
            this.rotationPitch = (float)(Math.atan2(lllllllllllllllIIllIIIIIlIlIlIll, this.motionY) * 180.0 / 3.141592653589793) - 90.0f;
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
            float lllllllllllllllIIllIIIIIlIlIlIlI = this.getMotionFactor();
            if (this.isInWater()) {
                for (int lllllllllllllllIIllIIIIIlIlIlIIl = 0; lllllllllllllllIIllIIIIIlIlIlIIl < 4; ++lllllllllllllllIIllIIIIIlIlIlIIl) {
                    final float lllllllllllllllIIllIIIIIlIlIlIII = 0.25f;
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * lllllllllllllllIIllIIIIIlIlIlIII, this.posY - this.motionY * lllllllllllllllIIllIIIIIlIlIlIII, this.posZ - this.motionZ * lllllllllllllllIIllIIIIIlIlIlIII, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
                lllllllllllllllIIllIIIIIlIlIlIlI = 0.8f;
            }
            this.motionX += this.accelerationX;
            this.motionY += this.accelerationY;
            this.motionZ += this.accelerationZ;
            this.motionX *= lllllllllllllllIIllIIIIIlIlIlIlI;
            this.motionY *= lllllllllllllllIIllIIIIIlIlIlIlI;
            this.motionZ *= lllllllllllllllIIllIIIIIlIlIlIlI;
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0, new int[0]);
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllllIIllIIIIlIIlIIIll) {
        double lllllllllllllllIIllIIIIlIIlIIIlI = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0;
        lllllllllllllllIIllIIIIlIIlIIIlI *= 64.0;
        return lllllllllllllllIIllIIIIlIIlIIIll < lllllllllllllllIIllIIIIlIIlIIIlI * lllllllllllllllIIllIIIIlIIlIIIlI;
    }
    
    static {
        __OBFID = "CL_00001717";
    }
    
    protected abstract void onImpact(final MovingObjectPosition p0);
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIIllIIIIIIIlllIII, final float lllllllllllllllIIllIIIIIIIllllIl) {
        if (this.func_180431_b(lllllllllllllllIIllIIIIIIIlllIII)) {
            return false;
        }
        this.setBeenAttacked();
        if (lllllllllllllllIIllIIIIIIIlllIII.getEntity() != null) {
            final Vec3 lllllllllllllllIIllIIIIIIIlllIll = lllllllllllllllIIllIIIIIIIlllIII.getEntity().getLookVec();
            if (lllllllllllllllIIllIIIIIIIlllIll != null) {
                this.motionX = lllllllllllllllIIllIIIIIIIlllIll.xCoord;
                this.motionY = lllllllllllllllIIllIIIIIIIlllIll.yCoord;
                this.motionZ = lllllllllllllllIIllIIIIIIIlllIll.zCoord;
                this.accelerationX = this.motionX * 0.1;
                this.accelerationY = this.motionY * 0.1;
                this.accelerationZ = this.motionZ * 0.1;
            }
            if (lllllllllllllllIIllIIIIIIIlllIII.getEntity() instanceof EntityLivingBase) {
                this.shootingEntity = (EntityLivingBase)lllllllllllllllIIllIIIIIIIlllIII.getEntity();
            }
            return true;
        }
        return false;
    }
    
    @Override
    public float getCollisionBorderSize() {
        return 1.0f;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    public EntityFireball(final World lllllllllllllllIIllIIIIlIIIlIlII, final double lllllllllllllllIIllIIIIlIIIlIIll, final double lllllllllllllllIIllIIIIlIIIlIIlI, final double lllllllllllllllIIllIIIIlIIIlIIIl, final double lllllllllllllllIIllIIIIlIIIlIIII, final double lllllllllllllllIIllIIIIlIIIIIllI, final double lllllllllllllllIIllIIIIlIIIIlllI) {
        super(lllllllllllllllIIllIIIIlIIIlIlII);
        this.field_145795_e = -1;
        this.field_145793_f = -1;
        this.field_145794_g = -1;
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(lllllllllllllllIIllIIIIlIIIlIIll, lllllllllllllllIIllIIIIlIIIlIIlI, lllllllllllllllIIllIIIIlIIIlIIIl, this.rotationYaw, this.rotationPitch);
        this.setPosition(lllllllllllllllIIllIIIIlIIIlIIll, lllllllllllllllIIllIIIIlIIIlIIlI, lllllllllllllllIIllIIIIlIIIlIIIl);
        final double lllllllllllllllIIllIIIIlIIIIllIl = MathHelper.sqrt_double(lllllllllllllllIIllIIIIlIIIlIIII * lllllllllllllllIIllIIIIlIIIlIIII + lllllllllllllllIIllIIIIlIIIIIllI * lllllllllllllllIIllIIIIlIIIIIllI + lllllllllllllllIIllIIIIlIIIIlllI * lllllllllllllllIIllIIIIlIIIIlllI);
        this.accelerationX = lllllllllllllllIIllIIIIlIIIlIIII / lllllllllllllllIIllIIIIlIIIIllIl * 0.1;
        this.accelerationY = lllllllllllllllIIllIIIIlIIIIIllI / lllllllllllllllIIllIIIIlIIIIllIl * 0.1;
        this.accelerationZ = lllllllllllllllIIllIIIIlIIIIlllI / lllllllllllllllIIllIIIIlIIIIllIl * 0.1;
    }
}
