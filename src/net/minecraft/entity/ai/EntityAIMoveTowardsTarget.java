package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIMoveTowardsTarget extends EntityAIBase
{
    private /* synthetic */ double movePosY;
    private /* synthetic */ double speed;
    private /* synthetic */ double movePosZ;
    private /* synthetic */ EntityCreature theEntity;
    private /* synthetic */ float maxTargetDistance;
    private /* synthetic */ double movePosX;
    private /* synthetic */ EntityLivingBase targetEntity;
    
    @Override
    public void resetTask() {
        this.targetEntity = null;
    }
    
    @Override
    public boolean shouldExecute() {
        this.targetEntity = this.theEntity.getAttackTarget();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.targetEntity.getDistanceSqToEntity(this.theEntity) > this.maxTargetDistance * this.maxTargetDistance) {
            return false;
        }
        final Vec3 lllllllllllllllIlIIlIIlIllIIIIll = RandomPositionGenerator.findRandomTargetBlockTowards(this.theEntity, 16, 7, new Vec3(this.targetEntity.posX, this.targetEntity.posY, this.targetEntity.posZ));
        if (lllllllllllllllIlIIlIIlIllIIIIll == null) {
            return false;
        }
        this.movePosX = lllllllllllllllIlIIlIIlIllIIIIll.xCoord;
        this.movePosY = lllllllllllllllIlIIlIIlIllIIIIll.yCoord;
        this.movePosZ = lllllllllllllllIlIIlIIlIllIIIIll.zCoord;
        return true;
    }
    
    static {
        __OBFID = "CL_00001599";
    }
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, this.speed);
    }
    
    public EntityAIMoveTowardsTarget(final EntityCreature lllllllllllllllIlIIlIIlIllIIlIIl, final double lllllllllllllllIlIIlIIlIllIIlIII, final float lllllllllllllllIlIIlIIlIllIIIlll) {
        this.theEntity = lllllllllllllllIlIIlIIlIllIIlIIl;
        this.speed = lllllllllllllllIlIIlIIlIllIIlIII;
        this.maxTargetDistance = lllllllllllllllIlIIlIIlIllIIIlll;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.theEntity.getNavigator().noPath() && this.targetEntity.isEntityAlive() && this.targetEntity.getDistanceSqToEntity(this.theEntity) < this.maxTargetDistance * this.maxTargetDistance;
    }
}
