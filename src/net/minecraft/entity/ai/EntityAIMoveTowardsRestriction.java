package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIMoveTowardsRestriction extends EntityAIBase
{
    private /* synthetic */ double movePosX;
    private /* synthetic */ double movementSpeed;
    private /* synthetic */ EntityCreature theEntity;
    private /* synthetic */ double movePosY;
    private /* synthetic */ double movePosZ;
    
    public EntityAIMoveTowardsRestriction(final EntityCreature llllllllllllllIlIlIIllIIIIIlIlIl, final double llllllllllllllIlIlIIllIIIIIlIlII) {
        this.theEntity = llllllllllllllIlIlIIllIIIIIlIlIl;
        this.movementSpeed = llllllllllllllIlIlIIllIIIIIlIlII;
        this.setMutexBits(1);
    }
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, this.movementSpeed);
    }
    
    static {
        __OBFID = "CL_00001598";
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.theEntity.getNavigator().noPath();
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.theEntity.isWithinHomeDistanceCurrentPosition()) {
            return false;
        }
        final BlockPos llllllllllllllIlIlIIllIIIIIIllII = this.theEntity.func_180486_cf();
        final Vec3 llllllllllllllIlIlIIllIIIIIIlIll = RandomPositionGenerator.findRandomTargetBlockTowards(this.theEntity, 16, 7, new Vec3(llllllllllllllIlIlIIllIIIIIIllII.getX(), llllllllllllllIlIlIIllIIIIIIllII.getY(), llllllllllllllIlIlIIllIIIIIIllII.getZ()));
        if (llllllllllllllIlIlIIllIIIIIIlIll == null) {
            return false;
        }
        this.movePosX = llllllllllllllIlIlIIllIIIIIIlIll.xCoord;
        this.movePosY = llllllllllllllIlIlIIllIIIIIIlIll.yCoord;
        this.movePosZ = llllllllllllllIlIlIIllIIIIIIlIll.zCoord;
        return true;
    }
}
