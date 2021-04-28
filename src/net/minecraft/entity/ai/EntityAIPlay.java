package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class EntityAIPlay extends EntityAIBase
{
    private /* synthetic */ EntityVillager villagerObj;
    private /* synthetic */ double field_75261_c;
    private /* synthetic */ EntityLivingBase targetVillager;
    private /* synthetic */ int playTime;
    
    @Override
    public void updateTask() {
        --this.playTime;
        if (this.targetVillager != null) {
            if (this.villagerObj.getDistanceSqToEntity(this.targetVillager) > 4.0) {
                this.villagerObj.getNavigator().tryMoveToEntityLiving(this.targetVillager, this.field_75261_c);
            }
        }
        else if (this.villagerObj.getNavigator().noPath()) {
            final Vec3 lIIlIllIllIII = RandomPositionGenerator.findRandomTarget(this.villagerObj, 16, 3);
            if (lIIlIllIllIII == null) {
                return;
            }
            this.villagerObj.getNavigator().tryMoveToXYZ(lIIlIllIllIII.xCoord, lIIlIllIllIII.yCoord, lIIlIllIllIII.zCoord, this.field_75261_c);
        }
    }
    
    @Override
    public void resetTask() {
        this.villagerObj.setPlaying(false);
        this.targetVillager = null;
    }
    
    static {
        __OBFID = "CL_00001605";
    }
    
    @Override
    public boolean continueExecuting() {
        return this.playTime > 0;
    }
    
    public EntityAIPlay(final EntityVillager lIIlIllllllII, final double lIIlIlllllIll) {
        this.villagerObj = lIIlIllllllII;
        this.field_75261_c = lIIlIlllllIll;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.villagerObj.getGrowingAge() >= 0) {
            return false;
        }
        if (this.villagerObj.getRNG().nextInt(400) != 0) {
            return false;
        }
        final List lIIlIllllIIII = this.villagerObj.worldObj.getEntitiesWithinAABB(EntityVillager.class, this.villagerObj.getEntityBoundingBox().expand(6.0, 3.0, 6.0));
        double lIIlIlllIllll = Double.MAX_VALUE;
        for (final EntityVillager lIIlIlllIllIl : lIIlIllllIIII) {
            if (lIIlIlllIllIl != this.villagerObj && !lIIlIlllIllIl.isPlaying() && lIIlIlllIllIl.getGrowingAge() < 0) {
                final double lIIlIlllIllII = lIIlIlllIllIl.getDistanceSqToEntity(this.villagerObj);
                if (lIIlIlllIllII > lIIlIlllIllll) {
                    continue;
                }
                lIIlIlllIllll = lIIlIlllIllII;
                this.targetVillager = lIIlIlllIllIl;
            }
        }
        if (this.targetVillager == null) {
            final Vec3 lIIlIlllIlIll = RandomPositionGenerator.findRandomTarget(this.villagerObj, 16, 3);
            if (lIIlIlllIlIll == null) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void startExecuting() {
        if (this.targetVillager != null) {
            this.villagerObj.setPlaying(true);
        }
        this.playTime = 1000;
    }
}
