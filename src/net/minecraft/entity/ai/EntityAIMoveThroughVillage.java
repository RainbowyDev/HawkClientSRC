package net.minecraft.entity.ai;

import net.minecraft.village.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIMoveThroughVillage extends EntityAIBase
{
    private /* synthetic */ VillageDoorInfo doorInfo;
    private /* synthetic */ boolean isNocturnal;
    private /* synthetic */ List doorList;
    private /* synthetic */ PathEntity entityPathNavigate;
    private /* synthetic */ EntityCreature theEntity;
    private /* synthetic */ double movementSpeed;
    
    @Override
    public boolean continueExecuting() {
        if (this.theEntity.getNavigator().noPath()) {
            return false;
        }
        final float llllllllllllllIIIIIIllIIIllIIIlI = this.theEntity.width + 4.0f;
        return this.theEntity.getDistanceSq(this.doorInfo.func_179852_d()) > llllllllllllllIIIIIIllIIIllIIIlI * llllllllllllllIIIIIIllIIIllIIIlI;
    }
    
    private VillageDoorInfo func_75412_a(final Village llllllllllllllIIIIIIllIIIlIIlIII) {
        VillageDoorInfo llllllllllllllIIIIIIllIIIlIIllll = null;
        int llllllllllllllIIIIIIllIIIlIIlllI = Integer.MAX_VALUE;
        final List llllllllllllllIIIIIIllIIIlIIllIl = llllllllllllllIIIIIIllIIIlIIlIII.getVillageDoorInfoList();
        for (final VillageDoorInfo llllllllllllllIIIIIIllIIIlIIlIll : llllllllllllllIIIIIIllIIIlIIllIl) {
            final int llllllllllllllIIIIIIllIIIlIIlIlI = llllllllllllllIIIIIIllIIIlIIlIll.getDistanceSquared(MathHelper.floor_double(this.theEntity.posX), MathHelper.floor_double(this.theEntity.posY), MathHelper.floor_double(this.theEntity.posZ));
            if (llllllllllllllIIIIIIllIIIlIIlIlI < llllllllllllllIIIIIIllIIIlIIlllI && !this.func_75413_a(llllllllllllllIIIIIIllIIIlIIlIll)) {
                llllllllllllllIIIIIIllIIIlIIllll = llllllllllllllIIIIIIllIIIlIIlIll;
                llllllllllllllIIIIIIllIIIlIIlllI = llllllllllllllIIIIIIllIIIlIIlIlI;
            }
        }
        return llllllllllllllIIIIIIllIIIlIIllll;
    }
    
    public EntityAIMoveThroughVillage(final EntityCreature llllllllllllllIIIIIIllIIIlllIlll, final double llllllllllllllIIIIIIllIIIlllIllI, final boolean llllllllllllllIIIIIIllIIIllllIIl) {
        this.doorList = Lists.newArrayList();
        this.theEntity = llllllllllllllIIIIIIllIIIlllIlll;
        this.movementSpeed = llllllllllllllIIIIIIllIIIlllIllI;
        this.isNocturnal = llllllllllllllIIIIIIllIIIllllIIl;
        this.setMutexBits(1);
        if (!(llllllllllllllIIIIIIllIIIlllIlll.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob for MoveThroughVillageGoal");
        }
    }
    
    private void func_75414_f() {
        if (this.doorList.size() > 15) {
            this.doorList.remove(0);
        }
    }
    
    @Override
    public boolean shouldExecute() {
        this.func_75414_f();
        if (this.isNocturnal && this.theEntity.worldObj.isDaytime()) {
            return false;
        }
        final Village llllllllllllllIIIIIIllIIIllIlllI = this.theEntity.worldObj.getVillageCollection().func_176056_a(new BlockPos(this.theEntity), 0);
        if (llllllllllllllIIIIIIllIIIllIlllI == null) {
            return false;
        }
        this.doorInfo = this.func_75412_a(llllllllllllllIIIIIIllIIIllIlllI);
        if (this.doorInfo == null) {
            return false;
        }
        final PathNavigateGround llllllllllllllIIIIIIllIIIllIllIl = (PathNavigateGround)this.theEntity.getNavigator();
        final boolean llllllllllllllIIIIIIllIIIllIllII = llllllllllllllIIIIIIllIIIllIllIl.func_179686_g();
        llllllllllllllIIIIIIllIIIllIllIl.func_179688_b(false);
        this.entityPathNavigate = llllllllllllllIIIIIIllIIIllIllIl.func_179680_a(this.doorInfo.func_179852_d());
        llllllllllllllIIIIIIllIIIllIllIl.func_179688_b(llllllllllllllIIIIIIllIIIllIllII);
        if (this.entityPathNavigate != null) {
            return true;
        }
        final Vec3 llllllllllllllIIIIIIllIIIllIlIll = RandomPositionGenerator.findRandomTargetBlockTowards(this.theEntity, 10, 7, new Vec3(this.doorInfo.func_179852_d().getX(), this.doorInfo.func_179852_d().getY(), this.doorInfo.func_179852_d().getZ()));
        if (llllllllllllllIIIIIIllIIIllIlIll == null) {
            return false;
        }
        llllllllllllllIIIIIIllIIIllIllIl.func_179688_b(false);
        this.entityPathNavigate = this.theEntity.getNavigator().getPathToXYZ(llllllllllllllIIIIIIllIIIllIlIll.xCoord, llllllllllllllIIIIIIllIIIllIlIll.yCoord, llllllllllllllIIIIIIllIIIllIlIll.zCoord);
        llllllllllllllIIIIIIllIIIllIllIl.func_179688_b(llllllllllllllIIIIIIllIIIllIllII);
        return this.entityPathNavigate != null;
    }
    
    static {
        __OBFID = "CL_00001597";
    }
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().setPath(this.entityPathNavigate, this.movementSpeed);
    }
    
    private boolean func_75413_a(final VillageDoorInfo llllllllllllllIIIIIIllIIIIlllIII) {
        for (final VillageDoorInfo llllllllllllllIIIIIIllIIIIlllIlI : this.doorList) {
            if (llllllllllllllIIIIIIllIIIIlllIII.func_179852_d().equals(llllllllllllllIIIIIIllIIIIlllIlI.func_179852_d())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void resetTask() {
        if (this.theEntity.getNavigator().noPath() || this.theEntity.getDistanceSq(this.doorInfo.func_179852_d()) < 16.0) {
            this.doorList.add(this.doorInfo);
        }
    }
}
