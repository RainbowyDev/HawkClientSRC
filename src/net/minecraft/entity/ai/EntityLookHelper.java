package net.minecraft.entity.ai;

import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityLookHelper
{
    private /* synthetic */ double posX;
    private /* synthetic */ EntityLiving entity;
    private /* synthetic */ float deltaLookYaw;
    private /* synthetic */ float deltaLookPitch;
    private /* synthetic */ double posY;
    private /* synthetic */ double posZ;
    private /* synthetic */ boolean isLooking;
    
    private float updateRotation(final float lIIllIIlIIlIl, final float lIIllIIlIIlII, final float lIIllIIlIIIll) {
        float lIIllIIlIIllI = MathHelper.wrapAngleTo180_float(lIIllIIlIIlII - lIIllIIlIIlIl);
        if (lIIllIIlIIllI > lIIllIIlIIIll) {
            lIIllIIlIIllI = lIIllIIlIIIll;
        }
        if (lIIllIIlIIllI < -lIIllIIlIIIll) {
            lIIllIIlIIllI = -lIIllIIlIIIll;
        }
        return lIIllIIlIIlIl + lIIllIIlIIllI;
    }
    
    public double func_180422_f() {
        return this.posY;
    }
    
    static {
        __OBFID = "CL_00001572";
    }
    
    public void onUpdateLook() {
        this.entity.rotationPitch = 0.0f;
        if (this.isLooking) {
            this.isLooking = false;
            final double lIIllIIllllII = this.posX - this.entity.posX;
            final double lIIllIIlllIll = this.posY - (this.entity.posY + this.entity.getEyeHeight());
            final double lIIllIIlllIlI = this.posZ - this.entity.posZ;
            final double lIIllIIlllIIl = MathHelper.sqrt_double(lIIllIIllllII * lIIllIIllllII + lIIllIIlllIlI * lIIllIIlllIlI);
            final float lIIllIIlllIII = (float)(Math.atan2(lIIllIIlllIlI, lIIllIIllllII) * 180.0 / 3.141592653589793) - 90.0f;
            final float lIIllIIllIlll = (float)(-(Math.atan2(lIIllIIlllIll, lIIllIIlllIIl) * 180.0 / 3.141592653589793));
            this.entity.rotationPitch = this.updateRotation(this.entity.rotationPitch, lIIllIIllIlll, this.deltaLookPitch);
            this.entity.rotationYawHead = this.updateRotation(this.entity.rotationYawHead, lIIllIIlllIII, this.deltaLookYaw);
        }
        else {
            this.entity.rotationYawHead = this.updateRotation(this.entity.rotationYawHead, this.entity.renderYawOffset, 10.0f);
        }
        final float lIIllIIllIllI = MathHelper.wrapAngleTo180_float(this.entity.rotationYawHead - this.entity.renderYawOffset);
        if (!this.entity.getNavigator().noPath()) {
            if (lIIllIIllIllI < -75.0f) {
                this.entity.rotationYawHead = this.entity.renderYawOffset - 75.0f;
            }
            if (lIIllIIllIllI > 75.0f) {
                this.entity.rotationYawHead = this.entity.renderYawOffset + 75.0f;
            }
        }
    }
    
    public void setLookPosition(final double lIIllIlIIllll, final double lIIllIlIIlllI, final double lIIllIlIIIlll, final float lIIllIlIIIllI, final float lIIllIlIIIlIl) {
        this.posX = lIIllIlIIllll;
        this.posY = lIIllIlIIlllI;
        this.posZ = lIIllIlIIIlll;
        this.deltaLookYaw = lIIllIlIIIllI;
        this.deltaLookPitch = lIIllIlIIIlIl;
        this.isLooking = true;
    }
    
    public double func_180421_g() {
        return this.posZ;
    }
    
    public void setLookPositionWithEntity(final Entity lIIllIlIllIIl, final float lIIllIlIlllII, final float lIIllIlIlIlll) {
        this.posX = lIIllIlIllIIl.posX;
        if (lIIllIlIllIIl instanceof EntityLivingBase) {
            this.posY = lIIllIlIllIIl.posY + lIIllIlIllIIl.getEyeHeight();
        }
        else {
            this.posY = (lIIllIlIllIIl.getEntityBoundingBox().minY + lIIllIlIllIIl.getEntityBoundingBox().maxY) / 2.0;
        }
        this.posZ = lIIllIlIllIIl.posZ;
        this.deltaLookYaw = lIIllIlIlllII;
        this.deltaLookPitch = lIIllIlIlIlll;
        this.isLooking = true;
    }
    
    public double func_180423_e() {
        return this.posX;
    }
    
    public boolean func_180424_b() {
        return this.isLooking;
    }
    
    public EntityLookHelper(final EntityLiving lIIllIllIIlIl) {
        this.entity = lIIllIllIIlIl;
    }
}
