package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;

public class EntityEnderEye extends Entity
{
    private /* synthetic */ double targetY;
    private /* synthetic */ int despawnTimer;
    private /* synthetic */ double targetX;
    private /* synthetic */ boolean shatterOrDrop;
    private /* synthetic */ double targetZ;
    
    public void func_180465_a(final BlockPos lllllllllllllllllIIIllIlIIlIllII) {
        final double lllllllllllllllllIIIllIlIIllIIll = lllllllllllllllllIIIllIlIIlIllII.getX();
        final int lllllllllllllllllIIIllIlIIllIIlI = lllllllllllllllllIIIllIlIIlIllII.getY();
        final double lllllllllllllllllIIIllIlIIllIIIl = lllllllllllllllllIIIllIlIIlIllII.getZ();
        final double lllllllllllllllllIIIllIlIIllIIII = lllllllllllllllllIIIllIlIIllIIll - this.posX;
        final double lllllllllllllllllIIIllIlIIlIllll = lllllllllllllllllIIIllIlIIllIIIl - this.posZ;
        final float lllllllllllllllllIIIllIlIIlIlllI = MathHelper.sqrt_double(lllllllllllllllllIIIllIlIIllIIII * lllllllllllllllllIIIllIlIIllIIII + lllllllllllllllllIIIllIlIIlIllll * lllllllllllllllllIIIllIlIIlIllll);
        if (lllllllllllllllllIIIllIlIIlIlllI > 12.0f) {
            this.targetX = this.posX + lllllllllllllllllIIIllIlIIllIIII / lllllllllllllllllIIIllIlIIlIlllI * 12.0;
            this.targetZ = this.posZ + lllllllllllllllllIIIllIlIIlIllll / lllllllllllllllllIIIllIlIIlIlllI * 12.0;
            this.targetY = this.posY + 8.0;
        }
        else {
            this.targetX = lllllllllllllllllIIIllIlIIllIIll;
            this.targetY = lllllllllllllllllIIIllIlIIllIIlI;
            this.targetZ = lllllllllllllllllIIIllIlIIllIIIl;
        }
        this.despawnTimer = 0;
        this.shatterOrDrop = (this.rand.nextInt(5) > 0);
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllllllIIIllIlIlIlIIIl) {
        double lllllllllllllllllIIIllIlIlIlIIII = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0;
        lllllllllllllllllIIIllIlIlIlIIII *= 64.0;
        return lllllllllllllllllIIIllIlIlIlIIIl < lllllllllllllllllIIIllIlIlIlIIII * lllllllllllllllllIIIllIlIlIlIIII;
    }
    
    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        final float lllllllllllllllllIIIllIlIIIIllIl = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
        this.rotationPitch = (float)(Math.atan2(this.motionY, lllllllllllllllllIIIllIlIIIIllIl) * 180.0 / 3.141592653589793);
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
        if (!this.worldObj.isRemote) {
            final double lllllllllllllllllIIIllIlIIIIllII = this.targetX - this.posX;
            final double lllllllllllllllllIIIllIlIIIIlIll = this.targetZ - this.posZ;
            final float lllllllllllllllllIIIllIlIIIIlIlI = (float)Math.sqrt(lllllllllllllllllIIIllIlIIIIllII * lllllllllllllllllIIIllIlIIIIllII + lllllllllllllllllIIIllIlIIIIlIll * lllllllllllllllllIIIllIlIIIIlIll);
            final float lllllllllllllllllIIIllIlIIIIlIIl = (float)Math.atan2(lllllllllllllllllIIIllIlIIIIlIll, lllllllllllllllllIIIllIlIIIIllII);
            double lllllllllllllllllIIIllIlIIIIlIII = lllllllllllllllllIIIllIlIIIIllIl + (lllllllllllllllllIIIllIlIIIIlIlI - lllllllllllllllllIIIllIlIIIIllIl) * 0.0025;
            if (lllllllllllllllllIIIllIlIIIIlIlI < 1.0f) {
                lllllllllllllllllIIIllIlIIIIlIII *= 0.8;
                this.motionY *= 0.8;
            }
            this.motionX = Math.cos(lllllllllllllllllIIIllIlIIIIlIIl) * lllllllllllllllllIIIllIlIIIIlIII;
            this.motionZ = Math.sin(lllllllllllllllllIIIllIlIIIIlIIl) * lllllllllllllllllIIIllIlIIIIlIII;
            if (this.posY < this.targetY) {
                this.motionY += (1.0 - this.motionY) * 0.014999999664723873;
            }
            else {
                this.motionY += (-1.0 - this.motionY) * 0.014999999664723873;
            }
        }
        final float lllllllllllllllllIIIllIlIIIIIlll = 0.25f;
        if (this.isInWater()) {
            for (int lllllllllllllllllIIIllIlIIIIIllI = 0; lllllllllllllllllIIIllIlIIIIIllI < 4; ++lllllllllllllllllIIIllIlIIIIIllI) {
                this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * lllllllllllllllllIIIllIlIIIIIlll, this.posY - this.motionY * lllllllllllllllllIIIllIlIIIIIlll, this.posZ - this.motionZ * lllllllllllllllllIIIllIlIIIIIlll, this.motionX, this.motionY, this.motionZ, new int[0]);
            }
        }
        else {
            this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX - this.motionX * lllllllllllllllllIIIllIlIIIIIlll + this.rand.nextDouble() * 0.6 - 0.3, this.posY - this.motionY * lllllllllllllllllIIIllIlIIIIIlll - 0.5, this.posZ - this.motionZ * lllllllllllllllllIIIllIlIIIIIlll + this.rand.nextDouble() * 0.6 - 0.3, this.motionX, this.motionY, this.motionZ, new int[0]);
        }
        if (!this.worldObj.isRemote) {
            this.setPosition(this.posX, this.posY, this.posZ);
            ++this.despawnTimer;
            if (this.despawnTimer > 80 && !this.worldObj.isRemote) {
                this.setDead();
                if (this.shatterOrDrop) {
                    this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Items.ender_eye)));
                }
                else {
                    this.worldObj.playAuxSFX(2003, new BlockPos(this), 0);
                }
            }
        }
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllllllIIIllIIllllIllI) {
        return 15728880;
    }
    
    public EntityEnderEye(final World lllllllllllllllllIIIllIlIlIllIIl) {
        super(lllllllllllllllllIIIllIlIlIllIIl);
        this.setSize(0.25f, 0.25f);
    }
    
    @Override
    public void setVelocity(final double lllllllllllllllllIIIllIlIIIllIlI, final double lllllllllllllllllIIIllIlIIIllllI, final double lllllllllllllllllIIIllIlIIIllIII) {
        this.motionX = lllllllllllllllllIIIllIlIIIllIlI;
        this.motionY = lllllllllllllllllIIIllIlIIIllllI;
        this.motionZ = lllllllllllllllllIIIllIlIIIllIII;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float lllllllllllllllllIIIllIlIIIlllII = MathHelper.sqrt_double(lllllllllllllllllIIIllIlIIIllIlI * lllllllllllllllllIIIllIlIIIllIlI + lllllllllllllllllIIIllIlIIIllIII * lllllllllllllllllIIIllIlIIIllIII);
            final float n = (float)(Math.atan2(lllllllllllllllllIIIllIlIIIllIlI, lllllllllllllllllIIIllIlIIIllIII) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float)(Math.atan2(lllllllllllllllllIIIllIlIIIllllI, lllllllllllllllllIIIllIlIIIlllII) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllllIIIllIIllllllII) {
    }
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    public float getBrightness(final float lllllllllllllllllIIIllIIlllllIII) {
        return 1.0f;
    }
    
    @Override
    public boolean canAttackWithItem() {
        return false;
    }
    
    static {
        __OBFID = "CL_00001716";
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllllIIIllIIlllllIlI) {
    }
    
    public EntityEnderEye(final World lllllllllllllllllIIIllIlIlIIIIIl, final double lllllllllllllllllIIIllIlIlIIIIII, final double lllllllllllllllllIIIllIlIlIIIlII, final double lllllllllllllllllIIIllIlIIlllllI) {
        super(lllllllllllllllllIIIllIlIlIIIIIl);
        this.despawnTimer = 0;
        this.setSize(0.25f, 0.25f);
        this.setPosition(lllllllllllllllllIIIllIlIlIIIIII, lllllllllllllllllIIIllIlIlIIIlII, lllllllllllllllllIIIllIlIIlllllI);
    }
}
