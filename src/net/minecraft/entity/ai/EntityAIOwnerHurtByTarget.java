package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class EntityAIOwnerHurtByTarget extends EntityAITarget
{
    /* synthetic */ EntityLivingBase theOwnerAttacker;
    /* synthetic */ EntityTameable theDefendingTameable;
    private /* synthetic */ int field_142051_e;
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.theOwnerAttacker);
        final EntityLivingBase llIIIIIIllIlIll = this.theDefendingTameable.func_180492_cm();
        if (llIIIIIIllIlIll != null) {
            this.field_142051_e = llIIIIIIllIlIll.getRevengeTimer();
        }
        super.startExecuting();
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theDefendingTameable.isTamed()) {
            return false;
        }
        final EntityLivingBase llIIIIIIlllIIll = this.theDefendingTameable.func_180492_cm();
        if (llIIIIIIlllIIll == null) {
            return false;
        }
        this.theOwnerAttacker = llIIIIIIlllIIll.getAITarget();
        final int llIIIIIIlllIIlI = llIIIIIIlllIIll.getRevengeTimer();
        return llIIIIIIlllIIlI != this.field_142051_e && this.isSuitableTarget(this.theOwnerAttacker, false) && this.theDefendingTameable.func_142018_a(this.theOwnerAttacker, llIIIIIIlllIIll);
    }
    
    public EntityAIOwnerHurtByTarget(final EntityTameable llIIIIIIllllIII) {
        super(llIIIIIIllllIII, false);
        this.theDefendingTameable = llIIIIIIllllIII;
        this.setMutexBits(1);
    }
    
    static {
        __OBFID = "CL_00001624";
    }
}
