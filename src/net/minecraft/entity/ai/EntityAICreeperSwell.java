package net.minecraft.entity.ai;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;

public class EntityAICreeperSwell extends EntityAIBase
{
    /* synthetic */ EntityLivingBase creeperAttackTarget;
    /* synthetic */ EntityCreeper swellingCreeper;
    
    public EntityAICreeperSwell(final EntityCreeper llllllllllllllIIlllIllllIIlllIll) {
        this.swellingCreeper = llllllllllllllIIlllIllllIIlllIll;
        this.setMutexBits(1);
    }
    
    @Override
    public void startExecuting() {
        this.swellingCreeper.getNavigator().clearPathEntity();
        this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase llllllllllllllIIlllIllllIIllIlll = this.swellingCreeper.getAttackTarget();
        return this.swellingCreeper.getCreeperState() > 0 || (llllllllllllllIIlllIllllIIllIlll != null && this.swellingCreeper.getDistanceSqToEntity(llllllllllllllIIlllIllllIIllIlll) < 9.0);
    }
    
    @Override
    public void resetTask() {
        this.creeperAttackTarget = null;
    }
    
    static {
        __OBFID = "CL_00001614";
    }
    
    @Override
    public void updateTask() {
        if (this.creeperAttackTarget == null) {
            this.swellingCreeper.setCreeperState(-1);
        }
        else if (this.swellingCreeper.getDistanceSqToEntity(this.creeperAttackTarget) > 49.0) {
            this.swellingCreeper.setCreeperState(-1);
        }
        else if (!this.swellingCreeper.getEntitySenses().canSee(this.creeperAttackTarget)) {
            this.swellingCreeper.setCreeperState(-1);
        }
        else {
            this.swellingCreeper.setCreeperState(1);
        }
    }
}
