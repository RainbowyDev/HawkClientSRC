package net.minecraft.entity.ai;

import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityMoveHelper
{
    protected /* synthetic */ boolean update;
    protected /* synthetic */ double posZ;
    protected /* synthetic */ EntityLiving entity;
    protected /* synthetic */ double speed;
    protected /* synthetic */ double posX;
    protected /* synthetic */ double posY;
    
    public double func_179917_d() {
        return this.posX;
    }
    
    protected float limitAngle(final float lllllllllllllllllIlIIIlllIlIllll, final float lllllllllllllllllIlIIIlllIlIIIll, final float lllllllllllllllllIlIIIlllIlIIIIl) {
        float lllllllllllllllllIlIIIlllIlIlIIl = MathHelper.wrapAngleTo180_float(lllllllllllllllllIlIIIlllIlIIIll - lllllllllllllllllIlIIIlllIlIllll);
        if (lllllllllllllllllIlIIIlllIlIlIIl > lllllllllllllllllIlIIIlllIlIIIIl) {
            lllllllllllllllllIlIIIlllIlIlIIl = lllllllllllllllllIlIIIlllIlIIIIl;
        }
        if (lllllllllllllllllIlIIIlllIlIlIIl < -lllllllllllllllllIlIIIlllIlIIIIl) {
            lllllllllllllllllIlIIIlllIlIlIIl = -lllllllllllllllllIlIIIlllIlIIIIl;
        }
        float lllllllllllllllllIlIIIlllIlIIlll = lllllllllllllllllIlIIIlllIlIllll + lllllllllllllllllIlIIIlllIlIlIIl;
        if (lllllllllllllllllIlIIIlllIlIIlll < 0.0f) {
            lllllllllllllllllIlIIIlllIlIIlll += 360.0f;
        }
        else if (lllllllllllllllllIlIIIlllIlIIlll > 360.0f) {
            lllllllllllllllllIlIIIlllIlIIlll -= 360.0f;
        }
        return lllllllllllllllllIlIIIlllIlIIlll;
    }
    
    public void setMoveTo(final double lllllllllllllllllIlIIIllllllIIIl, final double lllllllllllllllllIlIIIllllllIIII, final double lllllllllllllllllIlIIIlllllIIlll, final double lllllllllllllllllIlIIIlllllIIlIl) {
        this.posX = lllllllllllllllllIlIIIllllllIIIl;
        this.posY = lllllllllllllllllIlIIIllllllIIII;
        this.posZ = lllllllllllllllllIlIIIlllllIIlll;
        this.speed = lllllllllllllllllIlIIIlllllIIlIl;
        this.update = true;
    }
    
    public double func_179918_f() {
        return this.posZ;
    }
    
    static {
        __OBFID = "CL_00001573";
    }
    
    public double getSpeed() {
        return this.speed;
    }
    
    public boolean isUpdating() {
        return this.update;
    }
    
    public double func_179919_e() {
        return this.posY;
    }
    
    public EntityMoveHelper(final EntityLiving lllllllllllllllllIlIIlIIIIIIllII) {
        this.entity = lllllllllllllllllIlIIlIIIIIIllII;
        this.posX = lllllllllllllllllIlIIlIIIIIIllII.posX;
        this.posY = lllllllllllllllllIlIIlIIIIIIllII.posY;
        this.posZ = lllllllllllllllllIlIIlIIIIIIllII.posZ;
    }
    
    public void onUpdateMoveHelper() {
        this.entity.setMoveForward(0.0f);
        if (this.update) {
            this.update = false;
            final int lllllllllllllllllIlIIIllllIlIIIl = MathHelper.floor_double(this.entity.getEntityBoundingBox().minY + 0.5);
            final double lllllllllllllllllIlIIIllllIIllll = this.posX - this.entity.posX;
            final double lllllllllllllllllIlIIIllllIIllIl = this.posZ - this.entity.posZ;
            final double lllllllllllllllllIlIIIllllIIllII = this.posY - lllllllllllllllllIlIIIllllIlIIIl;
            final double lllllllllllllllllIlIIIllllIIlIll = lllllllllllllllllIlIIIllllIIllll * lllllllllllllllllIlIIIllllIIllll + lllllllllllllllllIlIIIllllIIllII * lllllllllllllllllIlIIIllllIIllII + lllllllllllllllllIlIIIllllIIllIl * lllllllllllllllllIlIIIllllIIllIl;
            if (lllllllllllllllllIlIIIllllIIlIll >= 2.500000277905201E-7) {
                final float lllllllllllllllllIlIIIllllIIlIlI = (float)(Math.atan2(lllllllllllllllllIlIIIllllIIllIl, lllllllllllllllllIlIIIllllIIllll) * 180.0 / 3.141592653589793) - 90.0f;
                this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, lllllllllllllllllIlIIIllllIIlIlI, 30.0f);
                this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()));
                if (lllllllllllllllllIlIIIllllIIllII > 0.0 && lllllllllllllllllIlIIIllllIIllll * lllllllllllllllllIlIIIllllIIllll + lllllllllllllllllIlIIIllllIIllIl * lllllllllllllllllIlIIIllllIIllIl < 1.0) {
                    this.entity.getJumpHelper().setJumping();
                }
            }
        }
    }
}
