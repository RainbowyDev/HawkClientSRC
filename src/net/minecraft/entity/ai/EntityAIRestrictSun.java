package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;

public class EntityAIRestrictSun extends EntityAIBase
{
    private /* synthetic */ EntityCreature theEntity;
    
    static {
        __OBFID = "CL_00001611";
    }
    
    @Override
    public boolean shouldExecute() {
        return this.theEntity.worldObj.isDaytime();
    }
    
    @Override
    public void resetTask() {
        ((PathNavigateGround)this.theEntity.getNavigator()).func_179685_e(false);
    }
    
    @Override
    public void startExecuting() {
        ((PathNavigateGround)this.theEntity.getNavigator()).func_179685_e(true);
    }
    
    public EntityAIRestrictSun(final EntityCreature lllllllllllllllllIlIllllIlIIIIll) {
        this.theEntity = lllllllllllllllllIlIllllIlIIIIll;
    }
}
