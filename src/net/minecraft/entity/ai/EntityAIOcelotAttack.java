package net.minecraft.entity.ai;

import net.minecraft.world.*;
import net.minecraft.entity.*;

public class EntityAIOcelotAttack extends EntityAIBase
{
    /* synthetic */ int attackCountdown;
    /* synthetic */ World theWorld;
    /* synthetic */ EntityLivingBase theVictim;
    /* synthetic */ EntityLiving theEntity;
    
    @Override
    public boolean continueExecuting() {
        return this.theVictim.isEntityAlive() && this.theEntity.getDistanceSqToEntity(this.theVictim) <= 225.0 && (!this.theEntity.getNavigator().noPath() || this.shouldExecute());
    }
    
    @Override
    public void updateTask() {
        this.theEntity.getLookHelper().setLookPositionWithEntity(this.theVictim, 30.0f, 30.0f);
        final double lllllllllllllllllllIllIllIlIllll = this.theEntity.width * 2.0f * this.theEntity.width * 2.0f;
        final double lllllllllllllllllllIllIllIlIlllI = this.theEntity.getDistanceSq(this.theVictim.posX, this.theVictim.getEntityBoundingBox().minY, this.theVictim.posZ);
        double lllllllllllllllllllIllIllIlIllIl = 0.8;
        if (lllllllllllllllllllIllIllIlIlllI > lllllllllllllllllllIllIllIlIllll && lllllllllllllllllllIllIllIlIlllI < 16.0) {
            lllllllllllllllllllIllIllIlIllIl = 1.33;
        }
        else if (lllllllllllllllllllIllIllIlIlllI < 225.0) {
            lllllllllllllllllllIllIllIlIllIl = 0.6;
        }
        this.theEntity.getNavigator().tryMoveToEntityLiving(this.theVictim, lllllllllllllllllllIllIllIlIllIl);
        this.attackCountdown = Math.max(this.attackCountdown - 1, 0);
        if (lllllllllllllllllllIllIllIlIlllI <= lllllllllllllllllllIllIllIlIllll && this.attackCountdown <= 0) {
            this.attackCountdown = 20;
            this.theEntity.attackEntityAsMob(this.theVictim);
        }
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase lllllllllllllllllllIllIllIllllIl = this.theEntity.getAttackTarget();
        if (lllllllllllllllllllIllIllIllllIl == null) {
            return false;
        }
        this.theVictim = lllllllllllllllllllIllIllIllllIl;
        return true;
    }
    
    public EntityAIOcelotAttack(final EntityLiving lllllllllllllllllllIllIlllIIIIll) {
        this.theEntity = lllllllllllllllllllIllIlllIIIIll;
        this.theWorld = lllllllllllllllllllIllIlllIIIIll.worldObj;
        this.setMutexBits(3);
    }
    
    @Override
    public void resetTask() {
        this.theVictim = null;
        this.theEntity.getNavigator().clearPathEntity();
    }
    
    static {
        __OBFID = "CL_00001600";
    }
}
