package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAILeapAtTarget extends EntityAIBase
{
    /* synthetic */ EntityLivingBase leapTarget;
    /* synthetic */ EntityLiving leaper;
    /* synthetic */ float leapMotionY;
    
    @Override
    public boolean continueExecuting() {
        return !this.leaper.onGround;
    }
    
    @Override
    public boolean shouldExecute() {
        this.leapTarget = this.leaper.getAttackTarget();
        if (this.leapTarget == null) {
            return false;
        }
        final double lllllllllllllllIIlIllIIIlIIIlIlI = this.leaper.getDistanceSqToEntity(this.leapTarget);
        return lllllllllllllllIIlIllIIIlIIIlIlI >= 4.0 && lllllllllllllllIIlIllIIIlIIIlIlI <= 16.0 && this.leaper.onGround && this.leaper.getRNG().nextInt(5) == 0;
    }
    
    static {
        __OBFID = "CL_00001591";
    }
    
    public EntityAILeapAtTarget(final EntityLiving lllllllllllllllIIlIllIIIlIIIllll, final float lllllllllllllllIIlIllIIIlIIIlllI) {
        this.leaper = lllllllllllllllIIlIllIIIlIIIllll;
        this.leapMotionY = lllllllllllllllIIlIllIIIlIIIlllI;
        this.setMutexBits(5);
    }
    
    @Override
    public void startExecuting() {
        final double lllllllllllllllIIlIllIIIIlllllll = this.leapTarget.posX - this.leaper.posX;
        final double lllllllllllllllIIlIllIIIIllllllI = this.leapTarget.posZ - this.leaper.posZ;
        final float lllllllllllllllIIlIllIIIIlllllIl = MathHelper.sqrt_double(lllllllllllllllIIlIllIIIIlllllll * lllllllllllllllIIlIllIIIIlllllll + lllllllllllllllIIlIllIIIIllllllI * lllllllllllllllIIlIllIIIIllllllI);
        final EntityLiving leaper = this.leaper;
        leaper.motionX += lllllllllllllllIIlIllIIIIlllllll / lllllllllllllllIIlIllIIIIlllllIl * 0.5 * 0.800000011920929 + this.leaper.motionX * 0.20000000298023224;
        final EntityLiving leaper2 = this.leaper;
        leaper2.motionZ += lllllllllllllllIIlIllIIIIllllllI / lllllllllllllllIIlIllIIIIlllllIl * 0.5 * 0.800000011920929 + this.leaper.motionZ * 0.20000000298023224;
        this.leaper.motionY = this.leapMotionY;
    }
}
