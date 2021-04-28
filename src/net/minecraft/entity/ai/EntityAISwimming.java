package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;

public class EntityAISwimming extends EntityAIBase
{
    private /* synthetic */ EntityLiving theEntity;
    
    public EntityAISwimming(final EntityLiving lllllllllllllllIllIIllIllIlIllll) {
        this.theEntity = lllllllllllllllIllIIllIllIlIllll;
        this.setMutexBits(4);
        ((PathNavigateGround)lllllllllllllllIllIIllIllIlIllll.getNavigator()).func_179693_d(true);
    }
    
    @Override
    public boolean shouldExecute() {
        return this.theEntity.isInWater() || this.theEntity.func_180799_ab();
    }
    
    @Override
    public void updateTask() {
        if (this.theEntity.getRNG().nextFloat() < 0.8f) {
            this.theEntity.getJumpHelper().setJumping();
        }
    }
    
    static {
        __OBFID = "CL_00001584";
    }
}
