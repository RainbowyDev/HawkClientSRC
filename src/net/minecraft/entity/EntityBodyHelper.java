package net.minecraft.entity;

import net.minecraft.util.*;

public class EntityBodyHelper
{
    private /* synthetic */ int rotationTickCounter;
    private /* synthetic */ float prevRenderYawHead;
    private /* synthetic */ EntityLivingBase theLiving;
    
    public EntityBodyHelper(final EntityLivingBase llllllllllllllllllllllIIIlIIlIll) {
        this.theLiving = llllllllllllllllllllllIIIlIIlIll;
    }
    
    static {
        __OBFID = "CL_00001570";
    }
    
    public void updateRenderAngles() {
        final double llllllllllllllllllllllIIIlIIIIlI = this.theLiving.posX - this.theLiving.prevPosX;
        final double llllllllllllllllllllllIIIlIIIIIl = this.theLiving.posZ - this.theLiving.prevPosZ;
        if (llllllllllllllllllllllIIIlIIIIlI * llllllllllllllllllllllIIIlIIIIlI + llllllllllllllllllllllIIIlIIIIIl * llllllllllllllllllllllIIIlIIIIIl > 2.500000277905201E-7) {
            this.theLiving.renderYawOffset = this.theLiving.rotationYaw;
            this.theLiving.rotationYawHead = this.computeAngleWithBound(this.theLiving.renderYawOffset, this.theLiving.rotationYawHead, 75.0f);
            this.prevRenderYawHead = this.theLiving.rotationYawHead;
            this.rotationTickCounter = 0;
        }
        else {
            float llllllllllllllllllllllIIIlIIIIII = 75.0f;
            if (Math.abs(this.theLiving.rotationYawHead - this.prevRenderYawHead) > 15.0f) {
                this.rotationTickCounter = 0;
                this.prevRenderYawHead = this.theLiving.rotationYawHead;
            }
            else {
                ++this.rotationTickCounter;
                final boolean llllllllllllllllllllllIIIIllllll = true;
                if (this.rotationTickCounter > 10) {
                    llllllllllllllllllllllIIIlIIIIII = Math.max(1.0f - (this.rotationTickCounter - 10) / 10.0f, 0.0f) * 75.0f;
                }
            }
            this.theLiving.renderYawOffset = this.computeAngleWithBound(this.theLiving.rotationYawHead, this.theLiving.renderYawOffset, llllllllllllllllllllllIIIlIIIIII);
        }
    }
    
    private float computeAngleWithBound(final float llllllllllllllllllllllIIIIllIlII, final float llllllllllllllllllllllIIIIlIllll, final float llllllllllllllllllllllIIIIlIlllI) {
        float llllllllllllllllllllllIIIIllIIIl = MathHelper.wrapAngleTo180_float(llllllllllllllllllllllIIIIllIlII - llllllllllllllllllllllIIIIlIllll);
        if (llllllllllllllllllllllIIIIllIIIl < -llllllllllllllllllllllIIIIlIlllI) {
            llllllllllllllllllllllIIIIllIIIl = -llllllllllllllllllllllIIIIlIlllI;
        }
        if (llllllllllllllllllllllIIIIllIIIl >= llllllllllllllllllllllIIIIlIlllI) {
            llllllllllllllllllllllIIIIllIIIl = llllllllllllllllllllllIIIIlIlllI;
        }
        return llllllllllllllllllllllIIIIllIlII - llllllllllllllllllllllIIIIllIIIl;
    }
}
