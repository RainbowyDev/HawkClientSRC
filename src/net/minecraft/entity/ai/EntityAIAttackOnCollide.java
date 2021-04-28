package net.minecraft.entity.ai;

import net.minecraft.pathfinding.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIAttackOnCollide extends EntityAIBase
{
    private /* synthetic */ int field_75445_i;
    /* synthetic */ PathEntity entityPathEntity;
    protected /* synthetic */ EntityCreature attacker;
    private /* synthetic */ double field_151495_j;
    /* synthetic */ double speedTowardsTarget;
    private /* synthetic */ double field_151497_i;
    /* synthetic */ int attackTick;
    /* synthetic */ World worldObj;
    /* synthetic */ Class classTarget;
    private /* synthetic */ double field_151496_k;
    /* synthetic */ boolean longMemory;
    
    @Override
    public void updateTask() {
        final EntityLivingBase llllllllllllllllllIIIIlllIIIllII = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(llllllllllllllllllIIIIlllIIIllII, 30.0f, 30.0f);
        final double llllllllllllllllllIIIIlllIIIlIll = this.attacker.getDistanceSq(llllllllllllllllllIIIIlllIIIllII.posX, llllllllllllllllllIIIIlllIIIllII.getEntityBoundingBox().minY, llllllllllllllllllIIIIlllIIIllII.posZ);
        final double llllllllllllllllllIIIIlllIIIlIlI = this.func_179512_a(llllllllllllllllllIIIIlllIIIllII);
        --this.field_75445_i;
        if ((this.longMemory || this.attacker.getEntitySenses().canSee(llllllllllllllllllIIIIlllIIIllII)) && this.field_75445_i <= 0 && ((this.field_151497_i == 0.0 && this.field_151495_j == 0.0 && this.field_151496_k == 0.0) || llllllllllllllllllIIIIlllIIIllII.getDistanceSq(this.field_151497_i, this.field_151495_j, this.field_151496_k) >= 1.0 || this.attacker.getRNG().nextFloat() < 0.05f)) {
            this.field_151497_i = llllllllllllllllllIIIIlllIIIllII.posX;
            this.field_151495_j = llllllllllllllllllIIIIlllIIIllII.getEntityBoundingBox().minY;
            this.field_151496_k = llllllllllllllllllIIIIlllIIIllII.posZ;
            this.field_75445_i = 4 + this.attacker.getRNG().nextInt(7);
            if (llllllllllllllllllIIIIlllIIIlIll > 1024.0) {
                this.field_75445_i += 10;
            }
            else if (llllllllllllllllllIIIIlllIIIlIll > 256.0) {
                this.field_75445_i += 5;
            }
            if (!this.attacker.getNavigator().tryMoveToEntityLiving(llllllllllllllllllIIIIlllIIIllII, this.speedTowardsTarget)) {
                this.field_75445_i += 15;
            }
        }
        this.attackTick = Math.max(this.attackTick - 1, 0);
        if (llllllllllllllllllIIIIlllIIIlIll <= llllllllllllllllllIIIIlllIIIlIlI && this.attackTick <= 0) {
            this.attackTick = 20;
            if (this.attacker.getHeldItem() != null) {
                this.attacker.swingItem();
            }
            this.attacker.attackEntityAsMob(llllllllllllllllllIIIIlllIIIllII);
        }
    }
    
    @Override
    public void resetTask() {
        this.attacker.getNavigator().clearPathEntity();
    }
    
    @Override
    public boolean continueExecuting() {
        final EntityLivingBase llllllllllllllllllIIIIlllIIllIlI = this.attacker.getAttackTarget();
        return llllllllllllllllllIIIIlllIIllIlI != null && llllllllllllllllllIIIIlllIIllIlI.isEntityAlive() && (this.longMemory ? this.attacker.func_180485_d(new BlockPos(llllllllllllllllllIIIIlllIIllIlI)) : (!this.attacker.getNavigator().noPath()));
    }
    
    public EntityAIAttackOnCollide(final EntityCreature llllllllllllllllllIIIIlllIlIIllI, final double llllllllllllllllllIIIIlllIlIIlIl, final boolean llllllllllllllllllIIIIlllIlIIlII) {
        this.attacker = llllllllllllllllllIIIIlllIlIIllI;
        this.worldObj = llllllllllllllllllIIIIlllIlIIllI.worldObj;
        this.speedTowardsTarget = llllllllllllllllllIIIIlllIlIIlIl;
        this.longMemory = llllllllllllllllllIIIIlllIlIIlII;
        this.setMutexBits(3);
    }
    
    @Override
    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
        this.field_75445_i = 0;
    }
    
    public EntityAIAttackOnCollide(final EntityCreature llllllllllllllllllIIIIlllIllIIll, final Class llllllllllllllllllIIIIlllIllIIlI, final double llllllllllllllllllIIIIlllIllIIIl, final boolean llllllllllllllllllIIIIlllIllIlIl) {
        this(llllllllllllllllllIIIIlllIllIIll, llllllllllllllllllIIIIlllIllIIIl, llllllllllllllllllIIIIlllIllIlIl);
        this.classTarget = llllllllllllllllllIIIIlllIllIIlI;
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase llllllllllllllllllIIIIlllIlIIIII = this.attacker.getAttackTarget();
        if (llllllllllllllllllIIIIlllIlIIIII == null) {
            return false;
        }
        if (!llllllllllllllllllIIIIlllIlIIIII.isEntityAlive()) {
            return false;
        }
        if (this.classTarget != null && !this.classTarget.isAssignableFrom(llllllllllllllllllIIIIlllIlIIIII.getClass())) {
            return false;
        }
        this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(llllllllllllllllllIIIIlllIlIIIII);
        return this.entityPathEntity != null;
    }
    
    static {
        __OBFID = "CL_00001595";
    }
    
    protected double func_179512_a(final EntityLivingBase llllllllllllllllllIIIIlllIIIIIlI) {
        return this.attacker.width * 2.0f * this.attacker.width * 2.0f + llllllllllllllllllIIIIlllIIIIIlI.width;
    }
}
