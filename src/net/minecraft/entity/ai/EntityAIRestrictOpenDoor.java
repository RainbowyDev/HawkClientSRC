package net.minecraft.entity.ai;

import net.minecraft.pathfinding.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.village.*;

public class EntityAIRestrictOpenDoor extends EntityAIBase
{
    private /* synthetic */ EntityCreature entityObj;
    private /* synthetic */ VillageDoorInfo frontDoor;
    
    @Override
    public void updateTask() {
        this.frontDoor.incrementDoorOpeningRestrictionCounter();
    }
    
    public EntityAIRestrictOpenDoor(final EntityCreature llllllllllllllIIIIIlllllIIIIIIII) {
        this.entityObj = llllllllllllllIIIIIlllllIIIIIIII;
        if (!(llllllllllllllIIIIIlllllIIIIIIII.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob type for RestrictOpenDoorGoal");
        }
    }
    
    @Override
    public void startExecuting() {
        ((PathNavigateGround)this.entityObj.getNavigator()).func_179688_b(false);
        ((PathNavigateGround)this.entityObj.getNavigator()).func_179691_c(false);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.entityObj.worldObj.isDaytime() && (!this.frontDoor.func_179851_i() && this.frontDoor.func_179850_c(new BlockPos(this.entityObj)));
    }
    
    @Override
    public void resetTask() {
        ((PathNavigateGround)this.entityObj.getNavigator()).func_179688_b(true);
        ((PathNavigateGround)this.entityObj.getNavigator()).func_179691_c(true);
        this.frontDoor = null;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.entityObj.worldObj.isDaytime()) {
            return false;
        }
        final BlockPos llllllllllllllIIIIIllllIlllllIIl = new BlockPos(this.entityObj);
        final Village llllllllllllllIIIIIllllIlllllIII = this.entityObj.worldObj.getVillageCollection().func_176056_a(llllllllllllllIIIIIllllIlllllIIl, 16);
        if (llllllllllllllIIIIIllllIlllllIII == null) {
            return false;
        }
        this.frontDoor = llllllllllllllIIIIIllllIlllllIII.func_179865_b(llllllllllllllIIIIIllllIlllllIIl);
        return this.frontDoor != null && this.frontDoor.func_179846_b(llllllllllllllIIIIIllllIlllllIIl) < 2.25;
    }
    
    static {
        __OBFID = "CL_00001610";
    }
}
