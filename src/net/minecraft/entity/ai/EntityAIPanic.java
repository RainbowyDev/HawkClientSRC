package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIPanic extends EntityAIBase
{
    private /* synthetic */ EntityCreature theEntityCreature;
    private /* synthetic */ double randPosX;
    private /* synthetic */ double randPosZ;
    protected /* synthetic */ double speed;
    private /* synthetic */ double randPosY;
    
    public EntityAIPanic(final EntityCreature llllllllllllllIIIlIlllIllllIIIlI, final double llllllllllllllIIIlIlllIllllIIIIl) {
        this.theEntityCreature = llllllllllllllIIIlIlllIllllIIIlI;
        this.speed = llllllllllllllIIIlIlllIllllIIIIl;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.theEntityCreature.getNavigator().noPath();
    }
    
    @Override
    public void startExecuting() {
        this.theEntityCreature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.theEntityCreature.getAITarget() == null && !this.theEntityCreature.isBurning()) {
            return false;
        }
        final Vec3 llllllllllllllIIIlIlllIlllIllIlI = RandomPositionGenerator.findRandomTarget(this.theEntityCreature, 5, 4);
        if (llllllllllllllIIIlIlllIlllIllIlI == null) {
            return false;
        }
        this.randPosX = llllllllllllllIIIlIlllIlllIllIlI.xCoord;
        this.randPosY = llllllllllllllIIIlIlllIlllIllIlI.yCoord;
        this.randPosZ = llllllllllllllIIIlIlllIlllIllIlI.zCoord;
        return true;
    }
    
    static {
        __OBFID = "CL_00001604";
    }
}
