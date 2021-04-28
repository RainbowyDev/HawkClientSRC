package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityTNTPrimed extends Entity
{
    private /* synthetic */ EntityLivingBase tntPlacedBy;
    public /* synthetic */ int fuse;
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    public float getEyeHeight() {
        return 0.0f;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIlIlIlIIIIlIllllIl) {
        llllllllllllllIlIlIlIIIIlIllllIl.setByte("Fuse", (byte)this.fuse);
    }
    
    public EntityLivingBase getTntPlacedBy() {
        return this.tntPlacedBy;
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIlIlIlIIIIlIllIlll) {
        this.fuse = llllllllllllllIlIlIlIIIIlIllIlll.getByte("Fuse");
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
            this.motionY *= -0.5;
        }
        if (this.fuse-- <= 0) {
            this.setDead();
            if (!this.worldObj.isRemote) {
                this.explode();
            }
        }
        else {
            this.handleWaterMovement();
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    public EntityTNTPrimed(final World llllllllllllllIlIlIlIIIIllIlllIl, final double llllllllllllllIlIlIlIIIIllIlllII, final double llllllllllllllIlIlIlIIIIllIllIll, final double llllllllllllllIlIlIlIIIIllIllIlI, final EntityLivingBase llllllllllllllIlIlIlIIIIllIllIIl) {
        this(llllllllllllllIlIlIlIIIIllIlllIl);
        this.setPosition(llllllllllllllIlIlIlIIIIllIlllII, llllllllllllllIlIlIlIIIIllIllIll, llllllllllllllIlIlIlIIIIllIllIlI);
        final float llllllllllllllIlIlIlIIIIllIllIII = (float)(Math.random() * 3.141592653589793 * 2.0);
        this.motionX = -(float)Math.sin(llllllllllllllIlIlIlIIIIllIllIII) * 0.02f;
        this.motionY = 0.20000000298023224;
        this.motionZ = -(float)Math.cos(llllllllllllllIlIlIlIIIIllIllIII) * 0.02f;
        this.fuse = 80;
        this.prevPosX = llllllllllllllIlIlIlIIIIllIlllII;
        this.prevPosY = llllllllllllllIlIlIlIIIIllIllIll;
        this.prevPosZ = llllllllllllllIlIlIlIIIIllIllIlI;
        this.tntPlacedBy = llllllllllllllIlIlIlIIIIllIllIIl;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    private void explode() {
        final float llllllllllllllIlIlIlIIIIllIIIlIl = 4.0f;
        this.worldObj.createExplosion(this, this.posX, this.posY + this.height / 2.0f, this.posZ, llllllllllllllIlIlIlIIIIllIIIlIl, true);
    }
    
    static {
        __OBFID = "CL_00001681";
    }
    
    public EntityTNTPrimed(final World llllllllllllllIlIlIlIIIIlllIlIII) {
        super(llllllllllllllIlIlIlIIIIlllIlIII);
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.98f);
    }
}
