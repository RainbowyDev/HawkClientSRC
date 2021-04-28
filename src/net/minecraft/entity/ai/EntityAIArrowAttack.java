package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIArrowAttack extends EntityAIBase
{
    private /* synthetic */ int maxRangedAttackTime;
    private /* synthetic */ float maxAttackDistance;
    private /* synthetic */ int field_75318_f;
    private final /* synthetic */ IRangedAttackMob rangedAttackEntityHost;
    private /* synthetic */ float field_96562_i;
    private /* synthetic */ int rangedAttackTime;
    private /* synthetic */ int field_96561_g;
    private final /* synthetic */ EntityLiving entityHost;
    private /* synthetic */ EntityLivingBase attackTarget;
    private /* synthetic */ double entityMoveSpeed;
    
    @Override
    public boolean continueExecuting() {
        return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase lllllllllllllllIlIIlIIllIIlIIIlI = this.entityHost.getAttackTarget();
        if (lllllllllllllllIlIIlIIllIIlIIIlI == null) {
            return false;
        }
        this.attackTarget = lllllllllllllllIlIIlIIllIIlIIIlI;
        return true;
    }
    
    @Override
    public void updateTask() {
        final double lllllllllllllllIlIIlIIllIIIlIIll = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.getEntityBoundingBox().minY, this.attackTarget.posZ);
        final boolean lllllllllllllllIlIIlIIllIIIlIIlI = this.entityHost.getEntitySenses().canSee(this.attackTarget);
        if (lllllllllllllllIlIIlIIllIIIlIIlI) {
            ++this.field_75318_f;
        }
        else {
            this.field_75318_f = 0;
        }
        if (lllllllllllllllIlIIlIIllIIIlIIll <= this.maxAttackDistance && this.field_75318_f >= 20) {
            this.entityHost.getNavigator().clearPathEntity();
        }
        else {
            this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
        }
        this.entityHost.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0f, 30.0f);
        final int rangedAttackTime = this.rangedAttackTime - 1;
        this.rangedAttackTime = rangedAttackTime;
        if (rangedAttackTime == 0) {
            if (lllllllllllllllIlIIlIIllIIIlIIll > this.maxAttackDistance || !lllllllllllllllIlIIlIIllIIIlIIlI) {
                return;
            }
            final float lllllllllllllllIlIIlIIllIIIlIIIl = MathHelper.sqrt_double(lllllllllllllllIlIIlIIllIIIlIIll) / this.field_96562_i;
            final float lllllllllllllllIlIIlIIllIIIIllll = MathHelper.clamp_float(lllllllllllllllIlIIlIIllIIIlIIIl, 0.1f, 1.0f);
            this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, lllllllllllllllIlIIlIIllIIIIllll);
            this.rangedAttackTime = MathHelper.floor_float(lllllllllllllllIlIIlIIllIIIlIIIl * (this.maxRangedAttackTime - this.field_96561_g) + this.field_96561_g);
        }
        else if (this.rangedAttackTime < 0) {
            final float lllllllllllllllIlIIlIIllIIIlIIII = MathHelper.sqrt_double(lllllllllllllllIlIIlIIllIIIlIIll) / this.field_96562_i;
            this.rangedAttackTime = MathHelper.floor_float(lllllllllllllllIlIIlIIllIIIlIIII * (this.maxRangedAttackTime - this.field_96561_g) + this.field_96561_g);
        }
    }
    
    public EntityAIArrowAttack(final IRangedAttackMob lllllllllllllllIlIIlIIllIIllIIII, final double lllllllllllllllIlIIlIIllIIlIllll, final int lllllllllllllllIlIIlIIllIIlIlIII, final int lllllllllllllllIlIIlIIllIIlIIlll, final float lllllllllllllllIlIIlIIllIIlIIllI) {
        this.rangedAttackTime = -1;
        if (!(lllllllllllllllIlIIlIIllIIllIIII instanceof EntityLivingBase)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }
        this.rangedAttackEntityHost = lllllllllllllllIlIIlIIllIIllIIII;
        this.entityHost = (EntityLiving)lllllllllllllllIlIIlIIllIIllIIII;
        this.entityMoveSpeed = lllllllllllllllIlIIlIIllIIlIllll;
        this.field_96561_g = lllllllllllllllIlIIlIIllIIlIlIII;
        this.maxRangedAttackTime = lllllllllllllllIlIIlIIllIIlIIlll;
        this.field_96562_i = lllllllllllllllIlIIlIIllIIlIIllI;
        this.maxAttackDistance = lllllllllllllllIlIIlIIllIIlIIllI * lllllllllllllllIlIIlIIllIIlIIllI;
        this.setMutexBits(3);
    }
    
    @Override
    public void resetTask() {
        this.attackTarget = null;
        this.field_75318_f = 0;
        this.rangedAttackTime = -1;
    }
    
    static {
        __OBFID = "CL_00001609";
    }
    
    public EntityAIArrowAttack(final IRangedAttackMob lllllllllllllllIlIIlIIllIIlllIll, final double lllllllllllllllIlIIlIIllIIlllIlI, final int lllllllllllllllIlIIlIIllIIlllllI, final float lllllllllllllllIlIIlIIllIIllllIl) {
        this(lllllllllllllllIlIIlIIllIIlllIll, lllllllllllllllIlIIlIIllIIlllIlI, lllllllllllllllIlIIlIIllIIlllllI, lllllllllllllllIlIIlIIllIIlllllI, lllllllllllllllIlIIlIIllIIllllIl);
    }
}
