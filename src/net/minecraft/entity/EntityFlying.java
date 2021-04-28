package net.minecraft.entity;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public abstract class EntityFlying extends EntityLiving
{
    @Override
    public void fall(final float lIIIIlIIIIIII, final float lIIIIIlllllll) {
    }
    
    public EntityFlying(final World lIIIIlIIIIlII) {
        super(lIIIIlIIIIlII);
    }
    
    static {
        __OBFID = "CL_00001545";
    }
    
    @Override
    public void moveEntityWithHeading(final float lIIIIIllIlIIl, final float lIIIIIllIlIII) {
        if (this.isInWater()) {
            this.moveFlying(lIIIIIllIlIIl, lIIIIIllIlIII, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929;
            this.motionY *= 0.800000011920929;
            this.motionZ *= 0.800000011920929;
        }
        else if (this.func_180799_ab()) {
            this.moveFlying(lIIIIIllIlIIl, lIIIIIllIlIII, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
        else {
            float lIIIIIllIllll = 0.91f;
            if (this.onGround) {
                lIIIIIllIllll = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91f;
            }
            final float lIIIIIllIlllI = 0.16277136f / (lIIIIIllIllll * lIIIIIllIllll * lIIIIIllIllll);
            this.moveFlying(lIIIIIllIlIIl, lIIIIIllIlIII, this.onGround ? (0.1f * lIIIIIllIlllI) : 0.02f);
            lIIIIIllIllll = 0.91f;
            if (this.onGround) {
                lIIIIIllIllll = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91f;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= lIIIIIllIllll;
            this.motionY *= lIIIIIllIllll;
            this.motionZ *= lIIIIIllIllll;
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double lIIIIIllIllIl = this.posX - this.prevPosX;
        final double lIIIIIllIllII = this.posZ - this.prevPosZ;
        float lIIIIIllIlIll = MathHelper.sqrt_double(lIIIIIllIllIl * lIIIIIllIllIl + lIIIIIllIllII * lIIIIIllIllII) * 4.0f;
        if (lIIIIIllIlIll > 1.0f) {
            lIIIIIllIlIll = 1.0f;
        }
        this.limbSwingAmount += (lIIIIIllIlIll - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }
    
    @Override
    protected void func_180433_a(final double lIIIIIlllllIl, final boolean lIIIIIlllllII, final Block lIIIIIllllIll, final BlockPos lIIIIIllllIlI) {
    }
    
    @Override
    public boolean isOnLadder() {
        return false;
    }
}
