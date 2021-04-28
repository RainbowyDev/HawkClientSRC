package net.minecraft.entity.ai;

public abstract class EntityAIBase
{
    private /* synthetic */ int mutexBits;
    
    public void updateTask() {
    }
    
    public int getMutexBits() {
        return this.mutexBits;
    }
    
    public boolean isInterruptible() {
        return true;
    }
    
    static {
        __OBFID = "CL_00001587";
    }
    
    public void resetTask() {
    }
    
    public abstract boolean shouldExecute();
    
    public boolean continueExecuting() {
        return this.shouldExecute();
    }
    
    public void startExecuting() {
    }
    
    public void setMutexBits(final int lllllllllllllllllIllIIIIIlllllIl) {
        this.mutexBits = lllllllllllllllllIllIIIIIlllllIl;
    }
}
