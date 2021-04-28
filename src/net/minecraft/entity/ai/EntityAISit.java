package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class EntityAISit extends EntityAIBase
{
    private /* synthetic */ EntityTameable theEntity;
    private /* synthetic */ boolean isSitting;
    
    @Override
    public boolean shouldExecute() {
        if (!this.theEntity.isTamed()) {
            return false;
        }
        if (this.theEntity.isInWater()) {
            return false;
        }
        if (!this.theEntity.onGround) {
            return false;
        }
        final EntityLivingBase llllllllllllllIIIIIIIIlIlllIllll = this.theEntity.func_180492_cm();
        return llllllllllllllIIIIIIIIlIlllIllll == null || ((this.theEntity.getDistanceSqToEntity(llllllllllllllIIIIIIIIlIlllIllll) >= 144.0 || llllllllllllllIIIIIIIIlIlllIllll.getAITarget() == null) && this.isSitting);
    }
    
    static {
        __OBFID = "CL_00001613";
    }
    
    @Override
    public void resetTask() {
        this.theEntity.setSitting(false);
    }
    
    public void setSitting(final boolean llllllllllllllIIIIIIIIlIlllIIIll) {
        this.isSitting = llllllllllllllIIIIIIIIlIlllIIIll;
    }
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().clearPathEntity();
        this.theEntity.setSitting(true);
    }
    
    public EntityAISit(final EntityTameable llllllllllllllIIIIIIIIlIllllIIll) {
        this.theEntity = llllllllllllllIIIIIIIIlIllllIIll;
        this.setMutexBits(5);
    }
}
