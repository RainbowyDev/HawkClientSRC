package net.minecraft.entity.ai;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.village.*;

public class EntityAIMoveIndoors extends EntityAIBase
{
    private /* synthetic */ int insidePosX;
    private /* synthetic */ VillageDoorInfo doorInfo;
    private /* synthetic */ EntityCreature entityObj;
    private /* synthetic */ int insidePosZ;
    
    @Override
    public boolean continueExecuting() {
        return !this.entityObj.getNavigator().noPath();
    }
    
    public EntityAIMoveIndoors(final EntityCreature llllllllllllllllIllIIIIIIlIlIIlI) {
        this.insidePosX = -1;
        this.insidePosZ = -1;
        this.entityObj = llllllllllllllllIllIIIIIIlIlIIlI;
        this.setMutexBits(1);
    }
    
    @Override
    public void resetTask() {
        this.insidePosX = this.doorInfo.func_179856_e().getX();
        this.insidePosZ = this.doorInfo.func_179856_e().getZ();
        this.doorInfo = null;
    }
    
    static {
        __OBFID = "CL_00001596";
    }
    
    @Override
    public void startExecuting() {
        this.insidePosX = -1;
        final BlockPos llllllllllllllllIllIIIIIIIlllllI = this.doorInfo.func_179856_e();
        final int llllllllllllllllIllIIIIIIIllllIl = llllllllllllllllIllIIIIIIIlllllI.getX();
        final int llllllllllllllllIllIIIIIIIllllII = llllllllllllllllIllIIIIIIIlllllI.getY();
        final int llllllllllllllllIllIIIIIIIlllIll = llllllllllllllllIllIIIIIIIlllllI.getZ();
        if (this.entityObj.getDistanceSq(llllllllllllllllIllIIIIIIIlllllI) > 256.0) {
            final Vec3 llllllllllllllllIllIIIIIIIlllIlI = RandomPositionGenerator.findRandomTargetBlockTowards(this.entityObj, 14, 3, new Vec3(llllllllllllllllIllIIIIIIIllllIl + 0.5, llllllllllllllllIllIIIIIIIllllII, llllllllllllllllIllIIIIIIIlllIll + 0.5));
            if (llllllllllllllllIllIIIIIIIlllIlI != null) {
                this.entityObj.getNavigator().tryMoveToXYZ(llllllllllllllllIllIIIIIIIlllIlI.xCoord, llllllllllllllllIllIIIIIIIlllIlI.yCoord, llllllllllllllllIllIIIIIIIlllIlI.zCoord, 1.0);
            }
        }
        else {
            this.entityObj.getNavigator().tryMoveToXYZ(llllllllllllllllIllIIIIIIIllllIl + 0.5, llllllllllllllllIllIIIIIIIllllII, llllllllllllllllIllIIIIIIIlllIll + 0.5, 1.0);
        }
    }
    
    @Override
    public boolean shouldExecute() {
        final BlockPos llllllllllllllllIllIIIIIIlIIllIl = new BlockPos(this.entityObj);
        if ((this.entityObj.worldObj.isDaytime() && (!this.entityObj.worldObj.isRaining() || this.entityObj.worldObj.getBiomeGenForCoords(llllllllllllllllIllIIIIIIlIIllIl).canSpawnLightningBolt())) || this.entityObj.worldObj.provider.getHasNoSky()) {
            return false;
        }
        if (this.entityObj.getRNG().nextInt(50) != 0) {
            return false;
        }
        if (this.insidePosX != -1 && this.entityObj.getDistanceSq(this.insidePosX, this.entityObj.posY, this.insidePosZ) < 4.0) {
            return false;
        }
        final Village llllllllllllllllIllIIIIIIlIIllII = this.entityObj.worldObj.getVillageCollection().func_176056_a(llllllllllllllllIllIIIIIIlIIllIl, 14);
        if (llllllllllllllllIllIIIIIIlIIllII == null) {
            return false;
        }
        this.doorInfo = llllllllllllllllIllIIIIIIlIIllII.func_179863_c(llllllllllllllllIllIIIIIIlIIllIl);
        return this.doorInfo != null;
    }
}
