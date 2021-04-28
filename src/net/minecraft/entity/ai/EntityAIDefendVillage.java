package net.minecraft.entity.ai;

import net.minecraft.entity.monster.*;
import net.minecraft.village.*;
import net.minecraft.entity.*;

public class EntityAIDefendVillage extends EntityAITarget
{
    /* synthetic */ EntityIronGolem irongolem;
    /* synthetic */ EntityLivingBase villageAgressorTarget;
    
    @Override
    public boolean shouldExecute() {
        final Village lllllllllllllllIllIllIlIlIIIIlII = this.irongolem.getVillage();
        if (lllllllllllllllIllIllIlIlIIIIlII == null) {
            return false;
        }
        this.villageAgressorTarget = lllllllllllllllIllIllIlIlIIIIlII.findNearestVillageAggressor(this.irongolem);
        if (this.isSuitableTarget(this.villageAgressorTarget, false)) {
            return true;
        }
        if (this.taskOwner.getRNG().nextInt(20) == 0) {
            this.villageAgressorTarget = lllllllllllllllIllIllIlIlIIIIlII.func_82685_c(this.irongolem);
            return this.isSuitableTarget(this.villageAgressorTarget, false);
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00001618";
    }
    
    public EntityAIDefendVillage(final EntityIronGolem lllllllllllllllIllIllIlIlIIlIlIl) {
        super(lllllllllllllllIllIllIlIlIIlIlIl, false, true);
        this.irongolem = lllllllllllllllIllIllIlIlIIlIlIl;
        this.setMutexBits(1);
    }
    
    @Override
    public void startExecuting() {
        this.irongolem.setAttackTarget(this.villageAgressorTarget);
        super.startExecuting();
    }
}
