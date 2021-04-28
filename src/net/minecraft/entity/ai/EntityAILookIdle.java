package net.minecraft.entity.ai;

import net.minecraft.entity.*;

public class EntityAILookIdle extends EntityAIBase
{
    private /* synthetic */ int idleTime;
    private /* synthetic */ double lookX;
    private /* synthetic */ double lookZ;
    private /* synthetic */ EntityLiving idleEntity;
    
    static {
        __OBFID = "CL_00001607";
    }
    
    @Override
    public boolean shouldExecute() {
        return this.idleEntity.getRNG().nextFloat() < 0.02f;
    }
    
    @Override
    public void updateTask() {
        --this.idleTime;
        this.idleEntity.getLookHelper().setLookPosition(this.idleEntity.posX + this.lookX, this.idleEntity.posY + this.idleEntity.getEyeHeight(), this.idleEntity.posZ + this.lookZ, 10.0f, (float)this.idleEntity.getVerticalFaceSpeed());
    }
    
    @Override
    public void startExecuting() {
        final double lIlIllIIllllIlI = 6.283185307179586 * this.idleEntity.getRNG().nextDouble();
        this.lookX = Math.cos(lIlIllIIllllIlI);
        this.lookZ = Math.sin(lIlIllIIllllIlI);
        this.idleTime = 20 + this.idleEntity.getRNG().nextInt(20);
    }
    
    public EntityAILookIdle(final EntityLiving lIlIllIlIIIIlII) {
        this.idleEntity = lIlIllIlIIIIlII;
        this.setMutexBits(3);
    }
    
    @Override
    public boolean continueExecuting() {
        return this.idleTime >= 0;
    }
}
