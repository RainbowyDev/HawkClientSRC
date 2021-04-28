package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;

public class EntityFireworkRocket extends Entity
{
    private /* synthetic */ int fireworkAge;
    private /* synthetic */ int lifetime;
    
    @Override
    public void handleHealthUpdate(final byte lllllllllllllllIIIllIIIllIllIlII) {
        if (lllllllllllllllIIIllIIIllIllIlII == 17 && this.worldObj.isRemote) {
            final ItemStack lllllllllllllllIIIllIIIllIllIIll = this.dataWatcher.getWatchableObjectItemStack(8);
            NBTTagCompound lllllllllllllllIIIllIIIllIllIIlI = null;
            if (lllllllllllllllIIIllIIIllIllIIll != null && lllllllllllllllIIIllIIIllIllIIll.hasTagCompound()) {
                lllllllllllllllIIIllIIIllIllIIlI = lllllllllllllllIIIllIIIllIllIIll.getTagCompound().getCompoundTag("Fireworks");
            }
            this.worldObj.makeFireworks(this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ, lllllllllllllllIIIllIIIllIllIIlI);
        }
        super.handleHealthUpdate(lllllllllllllllIIIllIIIllIllIlII);
    }
    
    @Override
    protected void entityInit() {
        this.dataWatcher.addObjectByDataType(8, 5);
    }
    
    @Override
    public boolean canAttackWithItem() {
        return false;
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllllIIIllIIIllIIIllII) {
        return super.getBrightnessForRender(lllllllllllllllIIIllIIIllIIIllII);
    }
    
    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        this.motionX *= 1.15;
        this.motionZ *= 1.15;
        this.motionY += 0.04;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        final float lllllllllllllllIIIllIIIllIllllII = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
        this.rotationPitch = (float)(Math.atan2(this.motionY, lllllllllllllllIIIllIIIllIllllII) * 180.0 / 3.141592653589793);
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
        if (this.fireworkAge == 0 && !this.isSlient()) {
            this.worldObj.playSoundAtEntity(this, "fireworks.launch", 3.0f, 1.0f);
        }
        ++this.fireworkAge;
        if (this.worldObj.isRemote && this.fireworkAge % 2 < 2) {
            this.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, this.posX, this.posY - 0.3, this.posZ, this.rand.nextGaussian() * 0.05, -this.motionY * 0.5, this.rand.nextGaussian() * 0.05, new int[0]);
        }
        if (!this.worldObj.isRemote && this.fireworkAge > this.lifetime) {
            this.worldObj.setEntityState(this, (byte)17);
            this.setDead();
        }
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIIllIIIllIIlllII) {
        this.fireworkAge = lllllllllllllllIIIllIIIllIIlllII.getInteger("Life");
        this.lifetime = lllllllllllllllIIIllIIIllIIlllII.getInteger("LifeTime");
        final NBTTagCompound lllllllllllllllIIIllIIIllIIllIll = lllllllllllllllIIIllIIIllIIlllII.getCompoundTag("FireworksItem");
        if (lllllllllllllllIIIllIIIllIIllIll != null) {
            final ItemStack lllllllllllllllIIIllIIIllIIllIlI = ItemStack.loadItemStackFromNBT(lllllllllllllllIIIllIIIllIIllIll);
            if (lllllllllllllllIIIllIIIllIIllIlI != null) {
                this.dataWatcher.updateObject(8, lllllllllllllllIIIllIIIllIIllIlI);
            }
        }
    }
    
    @Override
    public void setVelocity(final double lllllllllllllllIIIllIIIlllIIlIII, final double lllllllllllllllIIIllIIIlllIIIIlI, final double lllllllllllllllIIIllIIIlllIIIIIl) {
        this.motionX = lllllllllllllllIIIllIIIlllIIlIII;
        this.motionY = lllllllllllllllIIIllIIIlllIIIIlI;
        this.motionZ = lllllllllllllllIIIllIIIlllIIIIIl;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float lllllllllllllllIIIllIIIlllIIIlIl = MathHelper.sqrt_double(lllllllllllllllIIIllIIIlllIIlIII * lllllllllllllllIIIllIIIlllIIlIII + lllllllllllllllIIIllIIIlllIIIIIl * lllllllllllllllIIIllIIIlllIIIIIl);
            final float n = (float)(Math.atan2(lllllllllllllllIIIllIIIlllIIlIII, lllllllllllllllIIIllIIIlllIIIIIl) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float)(Math.atan2(lllllllllllllllIIIllIIIlllIIIIlI, lllllllllllllllIIIllIIIlllIIIlIl) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIIllIIIllIlIIlII) {
        lllllllllllllllIIIllIIIllIlIIlII.setInteger("Life", this.fireworkAge);
        lllllllllllllllIIIllIIIllIlIIlII.setInteger("LifeTime", this.lifetime);
        final ItemStack lllllllllllllllIIIllIIIllIlIIlll = this.dataWatcher.getWatchableObjectItemStack(8);
        if (lllllllllllllllIIIllIIIllIlIIlll != null) {
            final NBTTagCompound lllllllllllllllIIIllIIIllIlIIllI = new NBTTagCompound();
            lllllllllllllllIIIllIIIllIlIIlll.writeToNBT(lllllllllllllllIIIllIIIllIlIIllI);
            lllllllllllllllIIIllIIIllIlIIlII.setTag("FireworksItem", lllllllllllllllIIIllIIIllIlIIllI);
        }
    }
    
    public EntityFireworkRocket(final World lllllllllllllllIIIllIIIlllllIIIl) {
        super(lllllllllllllllIIIllIIIlllllIIIl);
        this.setSize(0.25f, 0.25f);
    }
    
    public EntityFireworkRocket(final World lllllllllllllllIIIllIIIlllIlIllI, final double lllllllllllllllIIIllIIIlllIllllI, final double lllllllllllllllIIIllIIIlllIlIlII, final double lllllllllllllllIIIllIIIlllIlllII, final ItemStack lllllllllllllllIIIllIIIlllIllIll) {
        super(lllllllllllllllIIIllIIIlllIlIllI);
        this.fireworkAge = 0;
        this.setSize(0.25f, 0.25f);
        this.setPosition(lllllllllllllllIIIllIIIlllIllllI, lllllllllllllllIIIllIIIlllIlIlII, lllllllllllllllIIIllIIIlllIlllII);
        int lllllllllllllllIIIllIIIlllIllIlI = 1;
        if (lllllllllllllllIIIllIIIlllIllIll != null && lllllllllllllllIIIllIIIlllIllIll.hasTagCompound()) {
            this.dataWatcher.updateObject(8, lllllllllllllllIIIllIIIlllIllIll);
            final NBTTagCompound lllllllllllllllIIIllIIIlllIllIIl = lllllllllllllllIIIllIIIlllIllIll.getTagCompound();
            final NBTTagCompound lllllllllllllllIIIllIIIlllIllIII = lllllllllllllllIIIllIIIlllIllIIl.getCompoundTag("Fireworks");
            if (lllllllllllllllIIIllIIIlllIllIII != null) {
                lllllllllllllllIIIllIIIlllIllIlI += lllllllllllllllIIIllIIIlllIllIII.getByte("Flight");
            }
        }
        this.motionX = this.rand.nextGaussian() * 0.001;
        this.motionZ = this.rand.nextGaussian() * 0.001;
        this.motionY = 0.05;
        this.lifetime = 10 * lllllllllllllllIIIllIIIlllIllIlI + this.rand.nextInt(6) + this.rand.nextInt(7);
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllllIIIllIIIllllIlIll) {
        return lllllllllllllllIIIllIIIllllIlIll < 4096.0;
    }
    
    @Override
    public float getBrightness(final float lllllllllllllllIIIllIIIllIIlIIlI) {
        return super.getBrightness(lllllllllllllllIIIllIIIllIIlIIlI);
    }
    
    static {
        __OBFID = "CL_00001718";
    }
}
