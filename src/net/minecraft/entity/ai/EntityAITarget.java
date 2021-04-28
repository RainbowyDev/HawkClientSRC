package net.minecraft.entity.ai;

import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;
import net.minecraft.entity.*;
import org.apache.commons.lang3.*;
import net.minecraft.util.*;
import net.minecraft.pathfinding.*;

public abstract class EntityAITarget extends EntityAIBase
{
    private /* synthetic */ boolean nearbyOnly;
    private /* synthetic */ int targetUnseenTicks;
    private /* synthetic */ int targetSearchDelay;
    protected /* synthetic */ boolean shouldCheckSight;
    protected final /* synthetic */ EntityCreature taskOwner;
    private /* synthetic */ int targetSearchStatus;
    
    static {
        __OBFID = "CL_00001626";
    }
    
    protected double getTargetDistance() {
        final IAttributeInstance llllllllllllllllIIIIIIIIllIllIlI = this.taskOwner.getEntityAttribute(SharedMonsterAttributes.followRange);
        return (llllllllllllllllIIIIIIIIllIllIlI == null) ? 16.0 : llllllllllllllllIIIIIIIIllIllIlI.getAttributeValue();
    }
    
    public EntityAITarget(final EntityCreature llllllllllllllllIIIIIIIIllllIIll, final boolean llllllllllllllllIIIIIIIIlllIlllI, final boolean llllllllllllllllIIIIIIIIllllIIIl) {
        this.taskOwner = llllllllllllllllIIIIIIIIllllIIll;
        this.shouldCheckSight = llllllllllllllllIIIIIIIIlllIlllI;
        this.nearbyOnly = llllllllllllllllIIIIIIIIllllIIIl;
    }
    
    protected boolean isSuitableTarget(final EntityLivingBase llllllllllllllllIIIIIIIIlIlllIII, final boolean llllllllllllllllIIIIIIIIlIlllIlI) {
        if (!func_179445_a(this.taskOwner, llllllllllllllllIIIIIIIIlIlllIII, llllllllllllllllIIIIIIIIlIlllIlI, this.shouldCheckSight)) {
            return false;
        }
        if (!this.taskOwner.func_180485_d(new BlockPos(llllllllllllllllIIIIIIIIlIlllIII))) {
            return false;
        }
        if (this.nearbyOnly) {
            if (--this.targetSearchDelay <= 0) {
                this.targetSearchStatus = 0;
            }
            if (this.targetSearchStatus == 0) {
                this.targetSearchStatus = (this.canEasilyReach(llllllllllllllllIIIIIIIIlIlllIII) ? 1 : 2);
            }
            if (this.targetSearchStatus == 2) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean continueExecuting() {
        final EntityLivingBase llllllllllllllllIIIIIIIIlllIIllI = this.taskOwner.getAttackTarget();
        if (llllllllllllllllIIIIIIIIlllIIllI == null) {
            return false;
        }
        if (!llllllllllllllllIIIIIIIIlllIIllI.isEntityAlive()) {
            return false;
        }
        final Team llllllllllllllllIIIIIIIIlllIIlIl = this.taskOwner.getTeam();
        final Team llllllllllllllllIIIIIIIIlllIIlII = llllllllllllllllIIIIIIIIlllIIllI.getTeam();
        if (llllllllllllllllIIIIIIIIlllIIlIl != null && llllllllllllllllIIIIIIIIlllIIlII == llllllllllllllllIIIIIIIIlllIIlIl) {
            return false;
        }
        final double llllllllllllllllIIIIIIIIlllIIIll = this.getTargetDistance();
        if (this.taskOwner.getDistanceSqToEntity(llllllllllllllllIIIIIIIIlllIIllI) > llllllllllllllllIIIIIIIIlllIIIll * llllllllllllllllIIIIIIIIlllIIIll) {
            return false;
        }
        if (this.shouldCheckSight) {
            if (this.taskOwner.getEntitySenses().canSee(llllllllllllllllIIIIIIIIlllIIllI)) {
                this.targetUnseenTicks = 0;
            }
            else if (++this.targetUnseenTicks > 60) {
                return false;
            }
        }
        return !(llllllllllllllllIIIIIIIIlllIIllI instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllllIIIIIIIIlllIIllI).capabilities.disableDamage;
    }
    
    public static boolean func_179445_a(final EntityLiving llllllllllllllllIIIIIIIIllIIlIll, final EntityLivingBase llllllllllllllllIIIIIIIIllIIlIlI, final boolean llllllllllllllllIIIIIIIIllIIIIll, final boolean llllllllllllllllIIIIIIIIllIIlIII) {
        if (llllllllllllllllIIIIIIIIllIIlIlI == null) {
            return false;
        }
        if (llllllllllllllllIIIIIIIIllIIlIlI == llllllllllllllllIIIIIIIIllIIlIll) {
            return false;
        }
        if (!llllllllllllllllIIIIIIIIllIIlIlI.isEntityAlive()) {
            return false;
        }
        if (!llllllllllllllllIIIIIIIIllIIlIll.canAttackClass(llllllllllllllllIIIIIIIIllIIlIlI.getClass())) {
            return false;
        }
        final Team llllllllllllllllIIIIIIIIllIIIlll = llllllllllllllllIIIIIIIIllIIlIll.getTeam();
        final Team llllllllllllllllIIIIIIIIllIIIllI = llllllllllllllllIIIIIIIIllIIlIlI.getTeam();
        if (llllllllllllllllIIIIIIIIllIIIlll != null && llllllllllllllllIIIIIIIIllIIIllI == llllllllllllllllIIIIIIIIllIIIlll) {
            return false;
        }
        if (llllllllllllllllIIIIIIIIllIIlIll instanceof IEntityOwnable && StringUtils.isNotEmpty((CharSequence)((IEntityOwnable)llllllllllllllllIIIIIIIIllIIlIll).func_152113_b())) {
            if (llllllllllllllllIIIIIIIIllIIlIlI instanceof IEntityOwnable && ((IEntityOwnable)llllllllllllllllIIIIIIIIllIIlIll).func_152113_b().equals(((IEntityOwnable)llllllllllllllllIIIIIIIIllIIlIlI).func_152113_b())) {
                return false;
            }
            if (llllllllllllllllIIIIIIIIllIIlIlI == ((IEntityOwnable)llllllllllllllllIIIIIIIIllIIlIll).getOwner()) {
                return false;
            }
        }
        else if (llllllllllllllllIIIIIIIIllIIlIlI instanceof EntityPlayer && !llllllllllllllllIIIIIIIIllIIIIll && ((EntityPlayer)llllllllllllllllIIIIIIIIllIIlIlI).capabilities.disableDamage) {
            return false;
        }
        return !llllllllllllllllIIIIIIIIllIIlIII || llllllllllllllllIIIIIIIIllIIlIll.getEntitySenses().canSee(llllllllllllllllIIIIIIIIllIIlIlI);
    }
    
    @Override
    public void startExecuting() {
        this.targetSearchStatus = 0;
        this.targetSearchDelay = 0;
        this.targetUnseenTicks = 0;
    }
    
    @Override
    public void resetTask() {
        this.taskOwner.setAttackTarget(null);
    }
    
    public EntityAITarget(final EntityCreature llllllllllllllllIIIIIIIIlllllIlI, final boolean llllllllllllllllIIIIIIIIllllllII) {
        this(llllllllllllllllIIIIIIIIlllllIlI, llllllllllllllllIIIIIIIIllllllII, false);
    }
    
    private boolean canEasilyReach(final EntityLivingBase llllllllllllllllIIIIIIIIlIlIlIIl) {
        this.targetSearchDelay = 10 + this.taskOwner.getRNG().nextInt(5);
        final PathEntity llllllllllllllllIIIIIIIIlIlIlllI = this.taskOwner.getNavigator().getPathToEntityLiving(llllllllllllllllIIIIIIIIlIlIlIIl);
        if (llllllllllllllllIIIIIIIIlIlIlllI == null) {
            return false;
        }
        final PathPoint llllllllllllllllIIIIIIIIlIlIllIl = llllllllllllllllIIIIIIIIlIlIlllI.getFinalPathPoint();
        if (llllllllllllllllIIIIIIIIlIlIllIl == null) {
            return false;
        }
        final int llllllllllllllllIIIIIIIIlIlIllII = llllllllllllllllIIIIIIIIlIlIllIl.xCoord - MathHelper.floor_double(llllllllllllllllIIIIIIIIlIlIlIIl.posX);
        final int llllllllllllllllIIIIIIIIlIlIlIll = llllllllllllllllIIIIIIIIlIlIllIl.zCoord - MathHelper.floor_double(llllllllllllllllIIIIIIIIlIlIlIIl.posZ);
        return llllllllllllllllIIIIIIIIlIlIllII * llllllllllllllllIIIIIIIIlIlIllII + llllllllllllllllIIIIIIIIlIlIlIll * llllllllllllllllIIIIIIIIlIlIlIll <= 2.25;
    }
}
