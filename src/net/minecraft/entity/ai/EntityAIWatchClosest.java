package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class EntityAIWatchClosest extends EntityAIBase
{
    private /* synthetic */ int lookTime;
    protected /* synthetic */ float maxDistanceForPlayer;
    protected /* synthetic */ EntityLiving theWatcher;
    protected /* synthetic */ Class watchedClass;
    protected /* synthetic */ Entity closestEntity;
    private /* synthetic */ float field_75331_e;
    
    @Override
    public void startExecuting() {
        this.lookTime = 40 + this.theWatcher.getRNG().nextInt(40);
    }
    
    static {
        __OBFID = "CL_00001592";
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.theWatcher.getRNG().nextFloat() >= this.field_75331_e) {
            return false;
        }
        if (this.theWatcher.getAttackTarget() != null) {
            this.closestEntity = this.theWatcher.getAttackTarget();
        }
        if (this.watchedClass == EntityPlayer.class) {
            this.closestEntity = this.theWatcher.worldObj.getClosestPlayerToEntity(this.theWatcher, this.maxDistanceForPlayer);
        }
        else {
            this.closestEntity = this.theWatcher.worldObj.findNearestEntityWithinAABB(this.watchedClass, this.theWatcher.getEntityBoundingBox().expand(this.maxDistanceForPlayer, 3.0, this.maxDistanceForPlayer), this.theWatcher);
        }
        return this.closestEntity != null;
    }
    
    public EntityAIWatchClosest(final EntityLiving lllllllllllllllIlIIllIlIIIIlIllI, final Class lllllllllllllllIlIIllIlIIIIlIlIl, final float lllllllllllllllIlIIllIlIIIIlIlII, final float lllllllllllllllIlIIllIlIIIIIlllI) {
        this.theWatcher = lllllllllllllllIlIIllIlIIIIlIllI;
        this.watchedClass = lllllllllllllllIlIIllIlIIIIlIlIl;
        this.maxDistanceForPlayer = lllllllllllllllIlIIllIlIIIIlIlII;
        this.field_75331_e = lllllllllllllllIlIIllIlIIIIIlllI;
        this.setMutexBits(2);
    }
    
    public EntityAIWatchClosest(final EntityLiving lllllllllllllllIlIIllIlIIIIlllll, final Class lllllllllllllllIlIIllIlIIIIllllI, final float lllllllllllllllIlIIllIlIIIIlllIl) {
        this.theWatcher = lllllllllllllllIlIIllIlIIIIlllll;
        this.watchedClass = lllllllllllllllIlIIllIlIIIIllllI;
        this.maxDistanceForPlayer = lllllllllllllllIlIIllIlIIIIlllIl;
        this.field_75331_e = 0.02f;
        this.setMutexBits(2);
    }
    
    @Override
    public void resetTask() {
        this.closestEntity = null;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.closestEntity.isEntityAlive() && this.theWatcher.getDistanceSqToEntity(this.closestEntity) <= this.maxDistanceForPlayer * this.maxDistanceForPlayer && this.lookTime > 0;
    }
    
    @Override
    public void updateTask() {
        this.theWatcher.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 10.0f, (float)this.theWatcher.getVerticalFaceSpeed());
        --this.lookTime;
    }
}
