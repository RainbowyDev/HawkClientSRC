package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIRunAroundLikeCrazy extends EntityAIBase
{
    private /* synthetic */ EntityHorse horseHost;
    private /* synthetic */ double field_111179_c;
    private /* synthetic */ double field_111178_b;
    private /* synthetic */ double field_111177_e;
    private /* synthetic */ double field_111176_d;
    
    static {
        __OBFID = "CL_00001612";
    }
    
    @Override
    public void startExecuting() {
        this.horseHost.getNavigator().tryMoveToXYZ(this.field_111179_c, this.field_111176_d, this.field_111177_e, this.field_111178_b);
    }
    
    @Override
    public void updateTask() {
        if (this.horseHost.getRNG().nextInt(50) == 0) {
            if (this.horseHost.riddenByEntity instanceof EntityPlayer) {
                final int llllllllllllllIllIIIIIIlllIIlIII = this.horseHost.getTemper();
                final int llllllllllllllIllIIIIIIlllIIIlll = this.horseHost.getMaxTemper();
                if (llllllllllllllIllIIIIIIlllIIIlll > 0 && this.horseHost.getRNG().nextInt(llllllllllllllIllIIIIIIlllIIIlll) < llllllllllllllIllIIIIIIlllIIlIII) {
                    this.horseHost.setTamedBy((EntityPlayer)this.horseHost.riddenByEntity);
                    this.horseHost.worldObj.setEntityState(this.horseHost, (byte)7);
                    return;
                }
                this.horseHost.increaseTemper(5);
            }
            this.horseHost.riddenByEntity.mountEntity(null);
            this.horseHost.riddenByEntity = null;
            this.horseHost.makeHorseRearWithSound();
            this.horseHost.worldObj.setEntityState(this.horseHost, (byte)6);
        }
    }
    
    public EntityAIRunAroundLikeCrazy(final EntityHorse llllllllllllllIllIIIIIIlllIlllIl, final double llllllllllllllIllIIIIIIlllIlllII) {
        this.horseHost = llllllllllllllIllIIIIIIlllIlllIl;
        this.field_111178_b = llllllllllllllIllIIIIIIlllIlllII;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.horseHost.getNavigator().noPath() && this.horseHost.riddenByEntity != null;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.horseHost.isTame() || this.horseHost.riddenByEntity == null) {
            return false;
        }
        final Vec3 llllllllllllllIllIIIIIIlllIlIlIl = RandomPositionGenerator.findRandomTarget(this.horseHost, 5, 4);
        if (llllllllllllllIllIIIIIIlllIlIlIl == null) {
            return false;
        }
        this.field_111179_c = llllllllllllllIllIIIIIIlllIlIlIl.xCoord;
        this.field_111176_d = llllllllllllllIllIIIIIIlllIlIlIl.yCoord;
        this.field_111177_e = llllllllllllllIllIIIIIIlllIlIlIl.zCoord;
        return true;
    }
}
