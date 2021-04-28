package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class EntityAIHurtByTarget extends EntityAITarget
{
    private /* synthetic */ int revengeTimerOld;
    private final /* synthetic */ Class[] field_179447_c;
    private /* synthetic */ boolean entityCallsForHelp;
    
    protected void func_179446_a(final EntityCreature llllllllllllllIlIlIIllIllIIIIlII, final EntityLivingBase llllllllllllllIlIlIIllIllIIIIIll) {
        llllllllllllllIlIlIIllIllIIIIlII.setAttackTarget(llllllllllllllIlIlIIllIllIIIIIll);
    }
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.taskOwner.getAITarget());
        this.revengeTimerOld = this.taskOwner.getRevengeTimer();
        if (this.entityCallsForHelp) {
            final double llllllllllllllIlIlIIllIllIIlllII = this.getTargetDistance();
            final List llllllllllllllIlIlIIllIllIIllIll = this.taskOwner.worldObj.getEntitiesWithinAABB(this.taskOwner.getClass(), new AxisAlignedBB(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0, this.taskOwner.posY + 1.0, this.taskOwner.posZ + 1.0).expand(llllllllllllllIlIlIIllIllIIlllII, 10.0, llllllllllllllIlIlIIllIllIIlllII));
            for (final EntityCreature llllllllllllllIlIlIIllIllIIllIIl : llllllllllllllIlIlIIllIllIIllIll) {
                if (this.taskOwner != llllllllllllllIlIlIIllIllIIllIIl && llllllllllllllIlIlIIllIllIIllIIl.getAttackTarget() == null && !llllllllllllllIlIlIIllIllIIllIIl.isOnSameTeam(this.taskOwner.getAITarget())) {
                    boolean llllllllllllllIlIlIIllIllIIllIII = false;
                    for (final Class llllllllllllllIlIlIIllIllIIlIlII : this.field_179447_c) {
                        if (llllllllllllllIlIlIIllIllIIllIIl.getClass() == llllllllllllllIlIlIIllIllIIlIlII) {
                            llllllllllllllIlIlIIllIllIIllIII = true;
                            break;
                        }
                    }
                    if (llllllllllllllIlIlIIllIllIIllIII) {
                        continue;
                    }
                    this.func_179446_a(llllllllllllllIlIlIIllIllIIllIIl, this.taskOwner.getAITarget());
                }
            }
        }
        super.startExecuting();
    }
    
    static {
        __OBFID = "CL_00001619";
    }
    
    @Override
    public boolean shouldExecute() {
        final int llllllllllllllIlIlIIllIllIlIlIlI = this.taskOwner.getRevengeTimer();
        return llllllllllllllIlIlIIllIllIlIlIlI != this.revengeTimerOld && this.isSuitableTarget(this.taskOwner.getAITarget(), false);
    }
    
    public EntityAIHurtByTarget(final EntityCreature llllllllllllllIlIlIIllIllIllIIII, final boolean llllllllllllllIlIlIIllIllIlIllll, final Class... llllllllllllllIlIlIIllIllIlIlllI) {
        super(llllllllllllllIlIlIIllIllIllIIII, false);
        this.entityCallsForHelp = llllllllllllllIlIlIIllIllIlIllll;
        this.field_179447_c = llllllllllllllIlIlIIllIllIlIlllI;
        this.setMutexBits(1);
    }
}
