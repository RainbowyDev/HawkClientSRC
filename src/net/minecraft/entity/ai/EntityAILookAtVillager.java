package net.minecraft.entity.ai;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class EntityAILookAtVillager extends EntityAIBase
{
    private /* synthetic */ int lookTime;
    private /* synthetic */ EntityIronGolem theGolem;
    private /* synthetic */ EntityVillager theVillager;
    
    @Override
    public void updateTask() {
        this.theGolem.getLookHelper().setLookPositionWithEntity(this.theVillager, 30.0f, 30.0f);
        --this.lookTime;
    }
    
    @Override
    public void startExecuting() {
        this.lookTime = 400;
        this.theGolem.setHoldingRose(true);
    }
    
    @Override
    public void resetTask() {
        this.theGolem.setHoldingRose(false);
        this.theVillager = null;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.lookTime > 0;
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theGolem.worldObj.isDaytime()) {
            return false;
        }
        if (this.theGolem.getRNG().nextInt(8000) != 0) {
            return false;
        }
        this.theVillager = (EntityVillager)this.theGolem.worldObj.findNearestEntityWithinAABB(EntityVillager.class, this.theGolem.getEntityBoundingBox().expand(6.0, 2.0, 6.0), this.theGolem);
        return this.theVillager != null;
    }
    
    public EntityAILookAtVillager(final EntityIronGolem llllllllllllllllIIllIlIlIIIlllIl) {
        this.theGolem = llllllllllllllllIIllIlIlIIIlllIl;
        this.setMutexBits(3);
    }
    
    static {
        __OBFID = "CL_00001602";
    }
}
