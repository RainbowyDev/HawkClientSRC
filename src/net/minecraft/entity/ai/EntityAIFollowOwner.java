package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityAIFollowOwner extends EntityAIBase
{
    /* synthetic */ World theWorld;
    /* synthetic */ float maxDist;
    /* synthetic */ float minDist;
    private /* synthetic */ PathNavigate petPathfinder;
    private /* synthetic */ double field_75336_f;
    private /* synthetic */ boolean field_75344_i;
    private /* synthetic */ int field_75343_h;
    private /* synthetic */ EntityLivingBase theOwner;
    private /* synthetic */ EntityTameable thePet;
    
    @Override
    public void startExecuting() {
        this.field_75343_h = 0;
        this.field_75344_i = ((PathNavigateGround)this.thePet.getNavigator()).func_179689_e();
        ((PathNavigateGround)this.thePet.getNavigator()).func_179690_a(false);
    }
    
    static {
        __OBFID = "CL_00001585";
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.petPathfinder.noPath() && this.thePet.getDistanceSqToEntity(this.theOwner) > this.maxDist * this.maxDist && !this.thePet.isSitting();
    }
    
    @Override
    public void updateTask() {
        this.thePet.getLookHelper().setLookPositionWithEntity(this.theOwner, 10.0f, (float)this.thePet.getVerticalFaceSpeed());
        if (!this.thePet.isSitting() && --this.field_75343_h <= 0) {
            this.field_75343_h = 10;
            if (!this.petPathfinder.tryMoveToEntityLiving(this.theOwner, this.field_75336_f) && !this.thePet.getLeashed() && this.thePet.getDistanceSqToEntity(this.theOwner) >= 144.0) {
                final int llIlIlIlIlIIIlI = MathHelper.floor_double(this.theOwner.posX) - 2;
                final int llIlIlIlIlIIIIl = MathHelper.floor_double(this.theOwner.posZ) - 2;
                final int llIlIlIlIlIIIII = MathHelper.floor_double(this.theOwner.getEntityBoundingBox().minY);
                for (int llIlIlIlIIlllll = 0; llIlIlIlIIlllll <= 4; ++llIlIlIlIIlllll) {
                    for (int llIlIlIlIIllllI = 0; llIlIlIlIIllllI <= 4; ++llIlIlIlIIllllI) {
                        if ((llIlIlIlIIlllll < 1 || llIlIlIlIIllllI < 1 || llIlIlIlIIlllll > 3 || llIlIlIlIIllllI > 3) && World.doesBlockHaveSolidTopSurface(this.theWorld, new BlockPos(llIlIlIlIlIIIlI + llIlIlIlIIlllll, llIlIlIlIlIIIII - 1, llIlIlIlIlIIIIl + llIlIlIlIIllllI)) && !this.theWorld.getBlockState(new BlockPos(llIlIlIlIlIIIlI + llIlIlIlIIlllll, llIlIlIlIlIIIII, llIlIlIlIlIIIIl + llIlIlIlIIllllI)).getBlock().isFullCube() && !this.theWorld.getBlockState(new BlockPos(llIlIlIlIlIIIlI + llIlIlIlIIlllll, llIlIlIlIlIIIII + 1, llIlIlIlIlIIIIl + llIlIlIlIIllllI)).getBlock().isFullCube()) {
                            this.thePet.setLocationAndAngles(llIlIlIlIlIIIlI + llIlIlIlIIlllll + 0.5f, llIlIlIlIlIIIII, llIlIlIlIlIIIIl + llIlIlIlIIllllI + 0.5f, this.thePet.rotationYaw, this.thePet.rotationPitch);
                            this.petPathfinder.clearPathEntity();
                            return;
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void resetTask() {
        this.theOwner = null;
        this.petPathfinder.clearPathEntity();
        ((PathNavigateGround)this.thePet.getNavigator()).func_179690_a(true);
    }
    
    public EntityAIFollowOwner(final EntityTameable llIlIlIlIllllII, final double llIlIlIllIIIIII, final float llIlIlIlIllllll, final float llIlIlIlIlllllI) {
        this.thePet = llIlIlIlIllllII;
        this.theWorld = llIlIlIlIllllII.worldObj;
        this.field_75336_f = llIlIlIllIIIIII;
        this.petPathfinder = llIlIlIlIllllII.getNavigator();
        this.minDist = llIlIlIlIllllll;
        this.maxDist = llIlIlIlIlllllI;
        this.setMutexBits(3);
        if (!(llIlIlIlIllllII.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
        }
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase llIlIlIlIllIlIl = this.thePet.func_180492_cm();
        if (llIlIlIlIllIlIl == null) {
            return false;
        }
        if (this.thePet.isSitting()) {
            return false;
        }
        if (this.thePet.getDistanceSqToEntity(llIlIlIlIllIlIl) < this.minDist * this.minDist) {
            return false;
        }
        this.theOwner = llIlIlIlIllIlIl;
        return true;
    }
}
