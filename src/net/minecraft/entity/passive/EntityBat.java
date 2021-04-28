package net.minecraft.entity.passive;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class EntityBat extends EntityAmbientCreature
{
    private /* synthetic */ BlockPos spawnPosition;
    
    @Override
    protected float getSoundVolume() {
        return 0.1f;
    }
    
    @Override
    protected void collideWithNearbyEntities() {
    }
    
    private boolean func_175569_a(final Calendar llllllllllllllllIlllIllllllIIIIl) {
        return (llllllllllllllllIlllIllllllIIIIl.get(2) + 1 == 10 && llllllllllllllllIlllIllllllIIIIl.get(5) >= 20) || (llllllllllllllllIlllIllllllIIIIl.get(2) + 1 == 11 && llllllllllllllllIlllIllllllIIIIl.get(5) <= 3);
    }
    
    @Override
    protected void func_180433_a(final double llllllllllllllllIllllIIIIIIIlIIl, final boolean llllllllllllllllIllllIIIIIIIlIII, final Block llllllllllllllllIllllIIIIIIIIlll, final BlockPos llllllllllllllllIllllIIIIIIIIllI) {
    }
    
    @Override
    public float getEyeHeight() {
        return this.height / 2.0f;
    }
    
    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        final BlockPos llllllllllllllllIllllIIIIIIlllIl = new BlockPos(this);
        final BlockPos llllllllllllllllIllllIIIIIIlllII = llllllllllllllllIllllIIIIIIlllIl.offsetUp();
        if (this.getIsBatHanging()) {
            if (!this.worldObj.getBlockState(llllllllllllllllIllllIIIIIIlllII).getBlock().isNormalCube()) {
                this.setIsBatHanging(false);
                this.worldObj.playAuxSFXAtEntity(null, 1015, llllllllllllllllIllllIIIIIIlllIl, 0);
            }
            else {
                if (this.rand.nextInt(200) == 0) {
                    this.rotationYawHead = (float)this.rand.nextInt(360);
                }
                if (this.worldObj.getClosestPlayerToEntity(this, 4.0) != null) {
                    this.setIsBatHanging(false);
                    this.worldObj.playAuxSFXAtEntity(null, 1015, llllllllllllllllIllllIIIIIIlllIl, 0);
                }
            }
        }
        else {
            if (this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
                this.spawnPosition = null;
            }
            if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0) {
                this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
            }
            final double llllllllllllllllIllllIIIIIIllIll = this.spawnPosition.getX() + 0.5 - this.posX;
            final double llllllllllllllllIllllIIIIIIllIlI = this.spawnPosition.getY() + 0.1 - this.posY;
            final double llllllllllllllllIllllIIIIIIllIIl = this.spawnPosition.getZ() + 0.5 - this.posZ;
            this.motionX += (Math.signum(llllllllllllllllIllllIIIIIIllIll) * 0.5 - this.motionX) * 0.10000000149011612;
            this.motionY += (Math.signum(llllllllllllllllIllllIIIIIIllIlI) * 0.699999988079071 - this.motionY) * 0.10000000149011612;
            this.motionZ += (Math.signum(llllllllllllllllIllllIIIIIIllIIl) * 0.5 - this.motionZ) * 0.10000000149011612;
            final float llllllllllllllllIllllIIIIIIllIII = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
            final float llllllllllllllllIllllIIIIIIlIlll = MathHelper.wrapAngleTo180_float(llllllllllllllllIllllIIIIIIllIII - this.rotationYaw);
            this.moveForward = 0.5f;
            this.rotationYaw += llllllllllllllllIllllIIIIIIlIlll;
            if (this.rand.nextInt(100) == 0 && this.worldObj.getBlockState(llllllllllllllllIllllIIIIIIlllII).getBlock().isNormalCube()) {
                this.setIsBatHanging(true);
            }
        }
    }
    
    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95f;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIlllIlllllllIllI) {
        super.readEntityFromNBT(llllllllllllllllIlllIlllllllIllI);
        this.dataWatcher.updateObject(16, llllllllllllllllIlllIlllllllIllI.getByte("BatFlags"));
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIllllIIIIIIIIIII, final float llllllllllllllllIlllIlllllllllll) {
        if (this.func_180431_b(llllllllllllllllIllllIIIIIIIIIII)) {
            return false;
        }
        if (!this.worldObj.isRemote && this.getIsBatHanging()) {
            this.setIsBatHanging(false);
        }
        return super.attackEntityFrom(llllllllllllllllIllllIIIIIIIIIII, llllllllllllllllIlllIlllllllllll);
    }
    
    @Override
    protected String getLivingSound() {
        return (this.getIsBatHanging() && this.rand.nextInt(4) != 0) ? null : "mob.bat.idle";
    }
    
    public boolean getIsBatHanging() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIlllIlllllllIIlI) {
        super.writeEntityToNBT(llllllllllllllllIlllIlllllllIIlI);
        llllllllllllllllIlllIlllllllIIlI.setByte("BatFlags", this.dataWatcher.getWatchableObjectByte(16));
    }
    
    public void setIsBatHanging(final boolean llllllllllllllllIllllIIIIIlIlllI) {
        final byte llllllllllllllllIllllIIIIIlIllIl = this.dataWatcher.getWatchableObjectByte(16);
        if (llllllllllllllllIllllIIIIIlIlllI) {
            this.dataWatcher.updateObject(16, (byte)(llllllllllllllllIllllIIIIIlIllIl | 0x1));
        }
        else {
            this.dataWatcher.updateObject(16, (byte)(llllllllllllllllIllllIIIIIlIllIl & 0xFFFFFFFE));
        }
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.bat.hurt";
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0);
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.bat.death";
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getIsBatHanging()) {
            final double motionX = 0.0;
            this.motionZ = motionX;
            this.motionY = motionX;
            this.motionX = motionX;
            this.posY = MathHelper.floor_double(this.posY) + 1.0 - this.height;
        }
        else {
            this.motionY *= 0.6000000238418579;
        }
    }
    
    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
    
    @Override
    public void fall(final float llllllllllllllllIllllIIIIIIIllII, final float llllllllllllllllIllllIIIIIIIlIll) {
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    public EntityBat(final World llllllllllllllllIllllIIIIlIIlIIl) {
        super(llllllllllllllllIllllIIIIlIIlIIl);
        this.setSize(0.5f, 0.9f);
        this.setIsBatHanging(true);
    }
    
    static {
        __OBFID = "CL_00001637";
    }
    
    @Override
    public boolean canBePushed() {
        return false;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    protected void collideWithEntity(final Entity llllllllllllllllIllllIIIIIlllIlI) {
    }
    
    @Override
    public boolean getCanSpawnHere() {
        final BlockPos llllllllllllllllIlllIllllllIlIlI = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
        if (llllllllllllllllIlllIllllllIlIlI.getY() >= 63) {
            return false;
        }
        final int llllllllllllllllIlllIllllllIlIIl = this.worldObj.getLightFromNeighbors(llllllllllllllllIlllIllllllIlIlI);
        byte llllllllllllllllIlllIllllllIlIII = 4;
        if (this.func_175569_a(this.worldObj.getCurrentDate())) {
            llllllllllllllllIlllIllllllIlIII = 7;
        }
        else if (this.rand.nextBoolean()) {
            return false;
        }
        return llllllllllllllllIlllIllllllIlIIl <= this.rand.nextInt(llllllllllllllllIlllIllllllIlIII) && super.getCanSpawnHere();
    }
}
