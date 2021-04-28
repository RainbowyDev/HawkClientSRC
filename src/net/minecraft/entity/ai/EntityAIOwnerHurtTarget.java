package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class EntityAIOwnerHurtTarget extends EntityAITarget
{
    /* synthetic */ EntityLivingBase theTarget;
    /* synthetic */ EntityTameable theEntityTameable;
    private /* synthetic */ int field_142050_e;
    
    static {
        __OBFID = "CL_00001625";
    }
    
    public EntityAIOwnerHurtTarget(final EntityTameable llllllllllllllIllIlIlIIIlIIllllI) {
        super(llllllllllllllIllIlIlIIIlIIllllI, false);
        this.theEntityTameable = llllllllllllllIllIlIlIIIlIIllllI;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theEntityTameable.isTamed()) {
            return false;
        }
        final EntityLivingBase llllllllllllllIllIlIlIIIlIIllIIl = this.theEntityTameable.func_180492_cm();
        if (llllllllllllllIllIlIlIIIlIIllIIl == null) {
            return false;
        }
        this.theTarget = llllllllllllllIllIlIlIIIlIIllIIl.getLastAttacker();
        final int llllllllllllllIllIlIlIIIlIIllIII = llllllllllllllIllIlIlIIIlIIllIIl.getLastAttackerTime();
        return llllllllllllllIllIlIlIIIlIIllIII != this.field_142050_e && this.isSuitableTarget(this.theTarget, false) && this.theEntityTameable.func_142018_a(this.theTarget, llllllllllllllIllIlIlIIIlIIllIIl);
    }
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.theTarget);
        final EntityLivingBase llllllllllllllIllIlIlIIIlIIlIIIl = this.theEntityTameable.func_180492_cm();
        if (llllllllllllllIllIlIlIIIlIIlIIIl != null) {
            this.field_142050_e = llllllllllllllIllIlIlIIIlIIlIIIl.getLastAttackerTime();
        }
        super.startExecuting();
    }
}
