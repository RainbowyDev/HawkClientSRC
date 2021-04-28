package net.minecraft.entity.ai;

import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.pathfinding.*;

public class EntityAITempt extends EntityAIBase
{
    private /* synthetic */ EntityCreature temptedEntity;
    private /* synthetic */ double targetZ;
    private /* synthetic */ int delayTemptCounter;
    private /* synthetic */ EntityPlayer temptingPlayer;
    private /* synthetic */ boolean scaredByPlayerMovement;
    private /* synthetic */ boolean field_75286_m;
    private /* synthetic */ double targetX;
    private /* synthetic */ double field_75279_g;
    private /* synthetic */ boolean isRunning;
    private /* synthetic */ Item field_151484_k;
    private /* synthetic */ double targetY;
    private /* synthetic */ double field_75282_b;
    private /* synthetic */ double field_75278_f;
    
    static {
        __OBFID = "CL_00001616";
    }
    
    @Override
    public void updateTask() {
        this.temptedEntity.getLookHelper().setLookPositionWithEntity(this.temptingPlayer, 30.0f, (float)this.temptedEntity.getVerticalFaceSpeed());
        if (this.temptedEntity.getDistanceSqToEntity(this.temptingPlayer) < 6.25) {
            this.temptedEntity.getNavigator().clearPathEntity();
        }
        else {
            this.temptedEntity.getNavigator().tryMoveToEntityLiving(this.temptingPlayer, this.field_75282_b);
        }
    }
    
    @Override
    public boolean continueExecuting() {
        if (this.scaredByPlayerMovement) {
            if (this.temptedEntity.getDistanceSqToEntity(this.temptingPlayer) < 36.0) {
                if (this.temptingPlayer.getDistanceSq(this.targetX, this.targetY, this.targetZ) > 0.010000000000000002) {
                    return false;
                }
                if (Math.abs(this.temptingPlayer.rotationPitch - this.field_75278_f) > 5.0 || Math.abs(this.temptingPlayer.rotationYaw - this.field_75279_g) > 5.0) {
                    return false;
                }
            }
            else {
                this.targetX = this.temptingPlayer.posX;
                this.targetY = this.temptingPlayer.posY;
                this.targetZ = this.temptingPlayer.posZ;
            }
            this.field_75278_f = this.temptingPlayer.rotationPitch;
            this.field_75279_g = this.temptingPlayer.rotationYaw;
        }
        return this.shouldExecute();
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingPlayer = this.temptedEntity.worldObj.getClosestPlayerToEntity(this.temptedEntity, 10.0);
        if (this.temptingPlayer == null) {
            return false;
        }
        final ItemStack llllllllllllllIlIIIlllIllIllIIlI = this.temptingPlayer.getCurrentEquippedItem();
        return llllllllllllllIlIIIlllIllIllIIlI != null && llllllllllllllIlIIIlllIllIllIIlI.getItem() == this.field_151484_k;
    }
    
    @Override
    public void resetTask() {
        this.temptingPlayer = null;
        this.temptedEntity.getNavigator().clearPathEntity();
        this.delayTemptCounter = 100;
        this.isRunning = false;
        ((PathNavigateGround)this.temptedEntity.getNavigator()).func_179690_a(this.field_75286_m);
    }
    
    public EntityAITempt(final EntityCreature llllllllllllllIlIIIlllIllIlllIIl, final double llllllllllllllIlIIIlllIllIllllIl, final Item llllllllllllllIlIIIlllIllIllllII, final boolean llllllllllllllIlIIIlllIllIllIllI) {
        this.temptedEntity = llllllllllllllIlIIIlllIllIlllIIl;
        this.field_75282_b = llllllllllllllIlIIIlllIllIllllIl;
        this.field_151484_k = llllllllllllllIlIIIlllIllIllllII;
        this.scaredByPlayerMovement = llllllllllllllIlIIIlllIllIllIllI;
        this.setMutexBits(3);
        if (!(llllllllllllllIlIIIlllIllIlllIIl.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
        }
    }
    
    @Override
    public void startExecuting() {
        this.targetX = this.temptingPlayer.posX;
        this.targetY = this.temptingPlayer.posY;
        this.targetZ = this.temptingPlayer.posZ;
        this.isRunning = true;
        this.field_75286_m = ((PathNavigateGround)this.temptedEntity.getNavigator()).func_179689_e();
        ((PathNavigateGround)this.temptedEntity.getNavigator()).func_179690_a(false);
    }
    
    public boolean isRunning() {
        return this.isRunning;
    }
}
