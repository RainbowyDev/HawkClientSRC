package net.minecraft.entity.projectile;

import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.*;

public abstract class EntityThrowable extends Entity implements IProjectile
{
    private /* synthetic */ EntityLivingBase thrower;
    private /* synthetic */ String throwerName;
    private /* synthetic */ Block field_174853_f;
    private /* synthetic */ int ticksInGround;
    private /* synthetic */ int yTile;
    private /* synthetic */ int zTile;
    private /* synthetic */ int ticksInAir;
    private /* synthetic */ int xTile;
    protected /* synthetic */ boolean field_174854_a;
    public /* synthetic */ int throwableShake;
    
    @Override
    public void setThrowableHeading(double llllllllllllllIIIlIlIIllIIIIIIll, double llllllllllllllIIIlIlIIllIIIIIIlI, double llllllllllllllIIIlIlIIlIlllllIIl, final float llllllllllllllIIIlIlIIllIIIIIIII, final float llllllllllllllIIIlIlIIlIllllllll) {
        final float llllllllllllllIIIlIlIIlIlllllllI = MathHelper.sqrt_double(llllllllllllllIIIlIlIIllIIIIIIll * llllllllllllllIIIlIlIIllIIIIIIll + llllllllllllllIIIlIlIIllIIIIIIlI * llllllllllllllIIIlIlIIllIIIIIIlI + llllllllllllllIIIlIlIIlIlllllIIl * llllllllllllllIIIlIlIIlIlllllIIl);
        llllllllllllllIIIlIlIIllIIIIIIll /= llllllllllllllIIIlIlIIlIlllllllI;
        llllllllllllllIIIlIlIIllIIIIIIlI /= llllllllllllllIIIlIlIIlIlllllllI;
        llllllllllllllIIIlIlIIlIlllllIIl /= llllllllllllllIIIlIlIIlIlllllllI;
        llllllllllllllIIIlIlIIllIIIIIIll += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIIIlIlIIlIllllllll;
        llllllllllllllIIIlIlIIllIIIIIIlI += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIIIlIlIIlIllllllll;
        llllllllllllllIIIlIlIIlIlllllIIl += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIIIlIlIIlIllllllll;
        llllllllllllllIIIlIlIIllIIIIIIll *= llllllllllllllIIIlIlIIllIIIIIIII;
        llllllllllllllIIIlIlIIllIIIIIIlI *= llllllllllllllIIIlIlIIllIIIIIIII;
        llllllllllllllIIIlIlIIlIlllllIIl *= llllllllllllllIIIlIlIIllIIIIIIII;
        this.motionX = llllllllllllllIIIlIlIIllIIIIIIll;
        this.motionY = llllllllllllllIIIlIlIIllIIIIIIlI;
        this.motionZ = llllllllllllllIIIlIlIIlIlllllIIl;
        final float llllllllllllllIIIlIlIIlIllllllIl = MathHelper.sqrt_double(llllllllllllllIIIlIlIIllIIIIIIll * llllllllllllllIIIlIlIIllIIIIIIll + llllllllllllllIIIlIlIIlIlllllIIl * llllllllllllllIIIlIlIIlIlllllIIl);
        final float n = (float)(Math.atan2(llllllllllllllIIIlIlIIllIIIIIIll, llllllllllllllIIIlIlIIlIlllllIIl) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float)(Math.atan2(llllllllllllllIIIlIlIIllIIIIIIlI, llllllllllllllIIIlIlIIlIllllllIl) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
        this.ticksInGround = 0;
    }
    
    @Override
    public void setVelocity(final double llllllllllllllIIIlIlIIlIlllIlllI, final double llllllllllllllIIIlIlIIlIlllIllIl, final double llllllllllllllIIIlIlIIlIlllIIlll) {
        this.motionX = llllllllllllllIIIlIlIIlIlllIlllI;
        this.motionY = llllllllllllllIIIlIlIIlIlllIllIl;
        this.motionZ = llllllllllllllIIIlIlIIlIlllIIlll;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float llllllllllllllIIIlIlIIlIlllIlIll = MathHelper.sqrt_double(llllllllllllllIIIlIlIIlIlllIlllI * llllllllllllllIIIlIlIIlIlllIlllI + llllllllllllllIIIlIlIIlIlllIIlll * llllllllllllllIIIlIlIIlIlllIIlll);
            final float n = (float)(Math.atan2(llllllllllllllIIIlIlIIlIlllIlllI, llllllllllllllIIIlIlIIlIlllIIlll) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float)(Math.atan2(llllllllllllllIIIlIlIIlIlllIllIl, llllllllllllllIIIlIlIIlIlllIlIll) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
        }
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIIlIlIIlIlIlIIlll) {
        this.xTile = llllllllllllllIIIlIlIIlIlIlIIlll.getShort("xTile");
        this.yTile = llllllllllllllIIIlIlIIlIlIlIIlll.getShort("yTile");
        this.zTile = llllllllllllllIIIlIlIIlIlIlIIlll.getShort("zTile");
        if (llllllllllllllIIIlIlIIlIlIlIIlll.hasKey("inTile", 8)) {
            this.field_174853_f = Block.getBlockFromName(llllllllllllllIIIlIlIIlIlIlIIlll.getString("inTile"));
        }
        else {
            this.field_174853_f = Block.getBlockById(llllllllllllllIIIlIlIIlIlIlIIlll.getByte("inTile") & 0xFF);
        }
        this.throwableShake = (llllllllllllllIIIlIlIIlIlIlIIlll.getByte("shake") & 0xFF);
        this.field_174854_a = (llllllllllllllIIIlIlIIlIlIlIIlll.getByte("inGround") == 1);
        this.throwerName = llllllllllllllIIIlIlIIlIlIlIIlll.getString("ownerName");
        if (this.throwerName != null && this.throwerName.length() == 0) {
            this.throwerName = null;
        }
    }
    
    public EntityThrowable(final World llllllllllllllIIIlIlIIllIIllIllI) {
        super(llllllllllllllIIIlIlIIllIIllIllI);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.setSize(0.25f, 0.25f);
    }
    
    public EntityThrowable(final World llllllllllllllIIIlIlIIllIIIlIIlI, final double llllllllllllllIIIlIlIIllIIIlIllI, final double llllllllllllllIIIlIlIIllIIIlIlIl, final double llllllllllllllIIIlIlIIllIIIlIlII) {
        super(llllllllllllllIIIlIlIIllIIIlIIlI);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.ticksInGround = 0;
        this.setSize(0.25f, 0.25f);
        this.setPosition(llllllllllllllIIIlIlIIllIIIlIllI, llllllllllllllIIIlIlIIllIIIlIlIl, llllllllllllllIIIlIlIIllIIIlIlII);
    }
    
    @Override
    protected void entityInit() {
    }
    
    public EntityThrowable(final World llllllllllllllIIIlIlIIllIIlIIIII, final EntityLivingBase llllllllllllllIIIlIlIIllIIlIIIll) {
        super(llllllllllllllIIIlIlIIllIIlIIIII);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.thrower = llllllllllllllIIIlIlIIllIIlIIIll;
        this.setSize(0.25f, 0.25f);
        this.setLocationAndAngles(llllllllllllllIIIlIlIIllIIlIIIll.posX, llllllllllllllIIIlIlIIllIIlIIIll.posY + llllllllllllllIIIlIlIIllIIlIIIll.getEyeHeight(), llllllllllllllIIIlIlIIllIIlIIIll.posZ, llllllllllllllIIIlIlIIllIIlIIIll.rotationYaw, llllllllllllllIIIlIlIIllIIlIIIll.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        final float llllllllllllllIIIlIlIIllIIlIIIlI = 0.4f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * llllllllllllllIIIlIlIIllIIlIIIlI;
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * llllllllllllllIIIlIlIIllIIlIIIlI;
        this.motionY = -MathHelper.sin((this.rotationPitch + this.func_70183_g()) / 180.0f * 3.1415927f) * llllllllllllllIIIlIlIIllIIlIIIlI;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.func_70182_d(), 1.0f);
    }
    
    protected abstract void onImpact(final MovingObjectPosition p0);
    
    protected float getGravityVelocity() {
        return 0.03f;
    }
    
    protected float func_70182_d() {
        return 1.5f;
    }
    
    protected float func_70183_g() {
        return 0.0f;
    }
    
    public EntityLivingBase getThrower() {
        if (this.thrower == null && this.throwerName != null && this.throwerName.length() > 0) {
            this.thrower = this.worldObj.getPlayerEntityByName(this.throwerName);
        }
        return this.thrower;
    }
    
    static {
        __OBFID = "CL_00001723";
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double llllllllllllllIIIlIlIIllIIlIlllI) {
        double llllllllllllllIIIlIlIIllIIlIllIl = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0;
        llllllllllllllIIIlIlIIllIIlIllIl *= 64.0;
        return llllllllllllllIIIlIlIIllIIlIlllI < llllllllllllllIIIlIlIIllIIlIllIl * llllllllllllllIIIlIlIIllIIlIllIl;
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIIlIlIIlIlIlIllII) {
        llllllllllllllIIIlIlIIlIlIlIllII.setShort("xTile", (short)this.xTile);
        llllllllllllllIIIlIlIIlIlIlIllII.setShort("yTile", (short)this.yTile);
        llllllllllllllIIIlIlIIlIlIlIllII.setShort("zTile", (short)this.zTile);
        final ResourceLocation llllllllllllllIIIlIlIIlIlIlIlllI = (ResourceLocation)Block.blockRegistry.getNameForObject(this.field_174853_f);
        llllllllllllllIIIlIlIIlIlIlIllII.setString("inTile", (llllllllllllllIIIlIlIIlIlIlIlllI == null) ? "" : llllllllllllllIIIlIlIIlIlIlIlllI.toString());
        llllllllllllllIIIlIlIIlIlIlIllII.setByte("shake", (byte)this.throwableShake);
        llllllllllllllIIIlIlIIlIlIlIllII.setByte("inGround", (byte)(this.field_174854_a ? 1 : 0));
        if ((this.throwerName == null || this.throwerName.length() == 0) && this.thrower instanceof EntityPlayer) {
            this.throwerName = this.thrower.getName();
        }
        llllllllllllllIIIlIlIIlIlIlIllII.setString("ownerName", (this.throwerName == null) ? "" : this.throwerName);
    }
    
    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        if (this.throwableShake > 0) {
            --this.throwableShake;
        }
        if (this.field_174854_a) {
            if (this.worldObj.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock() == this.field_174853_f) {
                ++this.ticksInGround;
                if (this.ticksInGround == 1200) {
                    this.setDead();
                }
                return;
            }
            this.field_174854_a = false;
            this.motionX *= this.rand.nextFloat() * 0.2f;
            this.motionY *= this.rand.nextFloat() * 0.2f;
            this.motionZ *= this.rand.nextFloat() * 0.2f;
            this.ticksInGround = 0;
            this.ticksInAir = 0;
        }
        else {
            ++this.ticksInAir;
        }
        Vec3 llllllllllllllIIIlIlIIlIllIlIlIl = new Vec3(this.posX, this.posY, this.posZ);
        Vec3 llllllllllllllIIIlIlIIlIllIlIlII = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition llllllllllllllIIIlIlIIlIllIlIIll = this.worldObj.rayTraceBlocks(llllllllllllllIIIlIlIIlIllIlIlIl, llllllllllllllIIIlIlIIlIllIlIlII);
        llllllllllllllIIIlIlIIlIllIlIlIl = new Vec3(this.posX, this.posY, this.posZ);
        llllllllllllllIIIlIlIIlIllIlIlII = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (llllllllllllllIIIlIlIIlIllIlIIll != null) {
            llllllllllllllIIIlIlIIlIllIlIlII = new Vec3(llllllllllllllIIIlIlIIlIllIlIIll.hitVec.xCoord, llllllllllllllIIIlIlIIlIllIlIIll.hitVec.yCoord, llllllllllllllIIIlIlIIlIllIlIIll.hitVec.zCoord);
        }
        if (!this.worldObj.isRemote) {
            Entity llllllllllllllIIIlIlIIlIllIlIIlI = null;
            final List llllllllllllllIIIlIlIIlIllIlIIIl = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
            double llllllllllllllIIIlIlIIlIllIlIIII = 0.0;
            final EntityLivingBase llllllllllllllIIIlIlIIlIllIIllll = this.getThrower();
            for (int llllllllllllllIIIlIlIIlIllIIlllI = 0; llllllllllllllIIIlIlIIlIllIIlllI < llllllllllllllIIIlIlIIlIllIlIIIl.size(); ++llllllllllllllIIIlIlIIlIllIIlllI) {
                final Entity llllllllllllllIIIlIlIIlIllIIllIl = llllllllllllllIIIlIlIIlIllIlIIIl.get(llllllllllllllIIIlIlIIlIllIIlllI);
                if (llllllllllllllIIIlIlIIlIllIIllIl.canBeCollidedWith() && (llllllllllllllIIIlIlIIlIllIIllIl != llllllllllllllIIIlIlIIlIllIIllll || this.ticksInAir >= 5)) {
                    final float llllllllllllllIIIlIlIIlIllIIllII = 0.3f;
                    final AxisAlignedBB llllllllllllllIIIlIlIIlIllIIlIll = llllllllllllllIIIlIlIIlIllIIllIl.getEntityBoundingBox().expand(llllllllllllllIIIlIlIIlIllIIllII, llllllllllllllIIIlIlIIlIllIIllII, llllllllllllllIIIlIlIIlIllIIllII);
                    final MovingObjectPosition llllllllllllllIIIlIlIIlIllIIlIlI = llllllllllllllIIIlIlIIlIllIIlIll.calculateIntercept(llllllllllllllIIIlIlIIlIllIlIlIl, llllllllllllllIIIlIlIIlIllIlIlII);
                    if (llllllllllllllIIIlIlIIlIllIIlIlI != null) {
                        final double llllllllllllllIIIlIlIIlIllIIlIIl = llllllllllllllIIIlIlIIlIllIlIlIl.distanceTo(llllllllllllllIIIlIlIIlIllIIlIlI.hitVec);
                        if (llllllllllllllIIIlIlIIlIllIIlIIl < llllllllllllllIIIlIlIIlIllIlIIII || llllllllllllllIIIlIlIIlIllIlIIII == 0.0) {
                            llllllllllllllIIIlIlIIlIllIlIIlI = llllllllllllllIIIlIlIIlIllIIllIl;
                            llllllllllllllIIIlIlIIlIllIlIIII = llllllllllllllIIIlIlIIlIllIIlIIl;
                        }
                    }
                }
            }
            if (llllllllllllllIIIlIlIIlIllIlIIlI != null) {
                llllllllllllllIIIlIlIIlIllIlIIll = new MovingObjectPosition(llllllllllllllIIIlIlIIlIllIlIIlI);
            }
        }
        if (llllllllllllllIIIlIlIIlIllIlIIll != null) {
            if (llllllllllllllIIIlIlIIlIllIlIIll.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.worldObj.getBlockState(llllllllllllllIIIlIlIIlIllIlIIll.func_178782_a()).getBlock() == Blocks.portal) {
                this.setInPortal();
            }
            else {
                this.onImpact(llllllllllllllIIIlIlIIlIllIlIIll);
            }
        }
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        final float llllllllllllllIIIlIlIIlIllIIlIII = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
        this.rotationPitch = (float)(Math.atan2(this.motionY, llllllllllllllIIIlIlIIlIllIIlIII) * 180.0 / 3.141592653589793);
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
        float llllllllllllllIIIlIlIIlIllIIIlll = 0.99f;
        final float llllllllllllllIIIlIlIIlIllIIIllI = this.getGravityVelocity();
        if (this.isInWater()) {
            for (int llllllllllllllIIIlIlIIlIllIIIlIl = 0; llllllllllllllIIIlIlIIlIllIIIlIl < 4; ++llllllllllllllIIIlIlIIlIllIIIlIl) {
                final float llllllllllllllIIIlIlIIlIllIIIlII = 0.25f;
                this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * llllllllllllllIIIlIlIIlIllIIIlII, this.posY - this.motionY * llllllllllllllIIIlIlIIlIllIIIlII, this.posZ - this.motionZ * llllllllllllllIIIlIlIIlIllIIIlII, this.motionX, this.motionY, this.motionZ, new int[0]);
            }
            llllllllllllllIIIlIlIIlIllIIIlll = 0.8f;
        }
        this.motionX *= llllllllllllllIIIlIlIIlIllIIIlll;
        this.motionY *= llllllllllllllIIIlIlIIlIllIIIlll;
        this.motionZ *= llllllllllllllIIIlIlIIlIllIIIlll;
        this.motionY -= llllllllllllllIIIlIlIIlIllIIIllI;
        this.setPosition(this.posX, this.posY, this.posZ);
    }
}
