package net.minecraft.pathfinding;

import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public abstract class PathNavigate
{
    private final /* synthetic */ PathFinder field_179681_j;
    private /* synthetic */ int totalTicks;
    protected /* synthetic */ PathEntity currentPath;
    protected /* synthetic */ double speed;
    private final /* synthetic */ IAttributeInstance pathSearchRange;
    protected /* synthetic */ EntityLiving theEntity;
    private /* synthetic */ Vec3 lastPosCheck;
    protected /* synthetic */ World worldObj;
    private /* synthetic */ int ticksAtLastPos;
    private /* synthetic */ float field_179682_i;
    
    public void clearPathEntity() {
        this.currentPath = null;
    }
    
    public float getPathSearchRange() {
        return (float)this.pathSearchRange.getAttributeValue();
    }
    
    public void setSpeed(final double llllllllllllllIlIIlIIlIIIlIllllI) {
        this.speed = llllllllllllllIlIIlIIlIIIlIllllI;
    }
    
    public PathNavigate(final EntityLiving llllllllllllllIlIIlIIlIIIllIIllI, final World llllllllllllllIlIIlIIlIIIllIIIlI) {
        this.lastPosCheck = new Vec3(0.0, 0.0, 0.0);
        this.field_179682_i = 1.0f;
        this.theEntity = llllllllllllllIlIIlIIlIIIllIIllI;
        this.worldObj = llllllllllllllIlIIlIIlIIIllIIIlI;
        this.pathSearchRange = llllllllllllllIlIIlIIlIIIllIIllI.getEntityAttribute(SharedMonsterAttributes.followRange);
        this.field_179681_j = this.func_179679_a();
    }
    
    protected abstract boolean canNavigate();
    
    public boolean tryMoveToEntityLiving(final Entity llllllllllllllIlIIlIIlIIIIIIIIIl, final double llllllllllllllIlIIlIIlIIIIIIIIII) {
        final PathEntity llllllllllllllIlIIlIIlIIIIIIIIll = this.getPathToEntityLiving(llllllllllllllIlIIlIIlIIIIIIIIIl);
        return llllllllllllllIlIIlIIlIIIIIIIIll != null && this.setPath(llllllllllllllIlIIlIIlIIIIIIIIll, llllllllllllllIlIIlIIlIIIIIIIIII);
    }
    
    public void onUpdateNavigation() {
        ++this.totalTicks;
        if (!this.noPath()) {
            if (this.canNavigate()) {
                this.pathFollow();
            }
            else if (this.currentPath != null && this.currentPath.getCurrentPathIndex() < this.currentPath.getCurrentPathLength()) {
                final Vec3 llllllllllllllIlIIlIIIlllllIlIll = this.getEntityPosition();
                final Vec3 llllllllllllllIlIIlIIIlllllIlIIl = this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex());
                if (llllllllllllllIlIIlIIIlllllIlIll.yCoord > llllllllllllllIlIIlIIIlllllIlIIl.yCoord && !this.theEntity.onGround && MathHelper.floor_double(llllllllllllllIlIIlIIIlllllIlIll.xCoord) == MathHelper.floor_double(llllllllllllllIlIIlIIIlllllIlIIl.xCoord) && MathHelper.floor_double(llllllllllllllIlIIlIIIlllllIlIll.zCoord) == MathHelper.floor_double(llllllllllllllIlIIlIIIlllllIlIIl.zCoord)) {
                    this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
                }
            }
            if (!this.noPath()) {
                final Vec3 llllllllllllllIlIIlIIIlllllIlIlI = this.currentPath.getPosition(this.theEntity);
                if (llllllllllllllIlIIlIIIlllllIlIlI != null) {
                    this.theEntity.getMoveHelper().setMoveTo(llllllllllllllIlIIlIIIlllllIlIlI.xCoord, llllllllllllllIlIIlIIIlllllIlIlI.yCoord, llllllllllllllIlIIlIIIlllllIlIlI.zCoord, this.speed);
                }
            }
        }
    }
    
    protected boolean isInLiquid() {
        return this.theEntity.isInWater() || this.theEntity.func_180799_ab();
    }
    
    protected abstract PathFinder func_179679_a();
    
    protected void func_179677_a(final Vec3 llllllllllllllIlIIlIIIllllIIlIII) {
        if (this.totalTicks - this.ticksAtLastPos > 100) {
            if (llllllllllllllIlIIlIIIllllIIlIII.squareDistanceTo(this.lastPosCheck) < 2.25) {
                this.clearPathEntity();
            }
            this.ticksAtLastPos = this.totalTicks;
            this.lastPosCheck = llllllllllllllIlIIlIIIllllIIlIII;
        }
    }
    
    public PathEntity getPath() {
        return this.currentPath;
    }
    
    protected void pathFollow() {
        final Vec3 llllllllllllllIlIIlIIIllllIlllII = this.getEntityPosition();
        int llllllllllllllIlIIlIIIllllIllIll = this.currentPath.getCurrentPathLength();
        for (int llllllllllllllIlIIlIIIllllIllIlI = this.currentPath.getCurrentPathIndex(); llllllllllllllIlIIlIIIllllIllIlI < this.currentPath.getCurrentPathLength(); ++llllllllllllllIlIIlIIIllllIllIlI) {
            if (this.currentPath.getPathPointFromIndex(llllllllllllllIlIIlIIIllllIllIlI).yCoord != (int)llllllllllllllIlIIlIIIllllIlllII.yCoord) {
                llllllllllllllIlIIlIIIllllIllIll = llllllllllllllIlIIlIIIllllIllIlI;
                break;
            }
        }
        final float llllllllllllllIlIIlIIIllllIllIIl = this.theEntity.width * this.theEntity.width * this.field_179682_i;
        for (int llllllllllllllIlIIlIIIllllIllIII = this.currentPath.getCurrentPathIndex(); llllllllllllllIlIIlIIIllllIllIII < llllllllllllllIlIIlIIIllllIllIll; ++llllllllllllllIlIIlIIIllllIllIII) {
            final Vec3 llllllllllllllIlIIlIIIllllIlIlll = this.currentPath.getVectorFromIndex(this.theEntity, llllllllllllllIlIIlIIIllllIllIII);
            if (llllllllllllllIlIIlIIIllllIlllII.squareDistanceTo(llllllllllllllIlIIlIIIllllIlIlll) < llllllllllllllIlIIlIIIllllIllIIl) {
                this.currentPath.setCurrentPathIndex(llllllllllllllIlIIlIIIllllIllIII + 1);
            }
        }
        int llllllllllllllIlIIlIIIllllIllIII = MathHelper.ceiling_float_int(this.theEntity.width);
        final int llllllllllllllIlIIlIIIllllIlIllI = (int)this.theEntity.height + 1;
        final int llllllllllllllIlIIlIIIllllIlIlIl = llllllllllllllIlIIlIIIllllIllIII;
        for (int llllllllllllllIlIIlIIIllllIlIlII = llllllllllllllIlIIlIIIllllIllIll - 1; llllllllllllllIlIIlIIIllllIlIlII >= this.currentPath.getCurrentPathIndex(); --llllllllllllllIlIIlIIIllllIlIlII) {
            if (this.isDirectPathBetweenPoints(llllllllllllllIlIIlIIIllllIlllII, this.currentPath.getVectorFromIndex(this.theEntity, llllllllllllllIlIIlIIIllllIlIlII), llllllllllllllIlIIlIIIllllIllIII, llllllllllllllIlIIlIIIllllIlIllI, llllllllllllllIlIIlIIIllllIlIlIl)) {
                this.currentPath.setCurrentPathIndex(llllllllllllllIlIIlIIIllllIlIlII);
                break;
            }
        }
        this.func_179677_a(llllllllllllllIlIIlIIIllllIlllII);
    }
    
    protected void removeSunnyPath() {
    }
    
    public boolean noPath() {
        return this.currentPath == null || this.currentPath.isFinished();
    }
    
    public boolean setPath(final PathEntity llllllllllllllIlIIlIIIllllllIlIl, final double llllllllllllllIlIIlIIIlllllllIII) {
        if (llllllllllllllIlIIlIIIllllllIlIl == null) {
            this.currentPath = null;
            return false;
        }
        if (!llllllllllllllIlIIlIIIllllllIlIl.isSamePath(this.currentPath)) {
            this.currentPath = llllllllllllllIlIIlIIIllllllIlIl;
        }
        this.removeSunnyPath();
        if (this.currentPath.getCurrentPathLength() == 0) {
            return false;
        }
        this.speed = llllllllllllllIlIIlIIIlllllllIII;
        final Vec3 llllllllllllllIlIIlIIIllllllIlll = this.getEntityPosition();
        this.ticksAtLastPos = this.totalTicks;
        this.lastPosCheck = llllllllllllllIlIIlIIIllllllIlll;
        return true;
    }
    
    public void func_179678_a(final float llllllllllllllIlIIlIIlIIIIlIIIlI) {
        this.field_179682_i = llllllllllllllIlIIlIIlIIIIlIIIlI;
    }
    
    public PathEntity func_179680_a(final BlockPos llllllllllllllIlIIlIIlIIIlIIIlII) {
        if (!this.canNavigate()) {
            return null;
        }
        final float llllllllllllllIlIIlIIlIIIlIIIIll = this.getPathSearchRange();
        this.worldObj.theProfiler.startSection("pathfind");
        final BlockPos llllllllllllllIlIIlIIlIIIlIIIIlI = new BlockPos(this.theEntity);
        final int llllllllllllllIlIIlIIlIIIlIIIIIl = (int)(llllllllllllllIlIIlIIlIIIlIIIIll + 8.0f);
        final ChunkCache llllllllllllllIlIIlIIlIIIlIIIIII = new ChunkCache(this.worldObj, llllllllllllllIlIIlIIlIIIlIIIIlI.add(-llllllllllllllIlIIlIIlIIIlIIIIIl, -llllllllllllllIlIIlIIlIIIlIIIIIl, -llllllllllllllIlIIlIIlIIIlIIIIIl), llllllllllllllIlIIlIIlIIIlIIIIlI.add(llllllllllllllIlIIlIIlIIIlIIIIIl, llllllllllllllIlIIlIIlIIIlIIIIIl, llllllllllllllIlIIlIIlIIIlIIIIIl), 0);
        final PathEntity llllllllllllllIlIIlIIlIIIIllllll = this.field_179681_j.func_180782_a(llllllllllllllIlIIlIIlIIIlIIIIII, this.theEntity, llllllllllllllIlIIlIIlIIIlIIIlII, llllllllllllllIlIIlIIlIIIlIIIIll);
        this.worldObj.theProfiler.endSection();
        return llllllllllllllIlIIlIIlIIIIllllll;
    }
    
    static {
        __OBFID = "CL_00001627";
    }
    
    protected abstract Vec3 getEntityPosition();
    
    public final PathEntity getPathToXYZ(final double llllllllllllllIlIIlIIlIIIlIIllll, final double llllllllllllllIlIIlIIlIIIlIlIIlI, final double llllllllllllllIlIIlIIlIIIlIIllIl) {
        return this.func_179680_a(new BlockPos(MathHelper.floor_double(llllllllllllllIlIIlIIlIIIlIIllll), (int)llllllllllllllIlIIlIIlIIIlIlIIlI, MathHelper.floor_double(llllllllllllllIlIIlIIlIIIlIIllIl)));
    }
    
    public PathEntity getPathToEntityLiving(final Entity llllllllllllllIlIIlIIlIIIIIlIIII) {
        if (!this.canNavigate()) {
            return null;
        }
        final float llllllllllllllIlIIlIIlIIIIIlIllI = this.getPathSearchRange();
        this.worldObj.theProfiler.startSection("pathfind");
        final BlockPos llllllllllllllIlIIlIIlIIIIIlIlIl = new BlockPos(this.theEntity).offsetUp();
        final int llllllllllllllIlIIlIIlIIIIIlIlII = (int)(llllllllllllllIlIIlIIlIIIIIlIllI + 16.0f);
        final ChunkCache llllllllllllllIlIIlIIlIIIIIlIIll = new ChunkCache(this.worldObj, llllllllllllllIlIIlIIlIIIIIlIlIl.add(-llllllllllllllIlIIlIIlIIIIIlIlII, -llllllllllllllIlIIlIIlIIIIIlIlII, -llllllllllllllIlIIlIIlIIIIIlIlII), llllllllllllllIlIIlIIlIIIIIlIlIl.add(llllllllllllllIlIIlIIlIIIIIlIlII, llllllllllllllIlIIlIIlIIIIIlIlII, llllllllllllllIlIIlIIlIIIIIlIlII), 0);
        final PathEntity llllllllllllllIlIIlIIlIIIIIlIIlI = this.field_179681_j.func_176188_a(llllllllllllllIlIIlIIlIIIIIlIIll, this.theEntity, llllllllllllllIlIIlIIlIIIIIlIIII, llllllllllllllIlIIlIIlIIIIIlIllI);
        this.worldObj.theProfiler.endSection();
        return llllllllllllllIlIIlIIlIIIIIlIIlI;
    }
    
    public boolean tryMoveToXYZ(final double llllllllllllllIlIIlIIlIIIIllIIII, final double llllllllllllllIlIIlIIlIIIIlIllll, final double llllllllllllllIlIIlIIlIIIIlIlIII, final double llllllllllllllIlIIlIIlIIIIlIllIl) {
        final PathEntity llllllllllllllIlIIlIIlIIIIlIllII = this.getPathToXYZ(MathHelper.floor_double(llllllllllllllIlIIlIIlIIIIllIIII), (int)llllllllllllllIlIIlIIlIIIIlIllll, MathHelper.floor_double(llllllllllllllIlIIlIIlIIIIlIlIII));
        return this.setPath(llllllllllllllIlIIlIIlIIIIlIllII, llllllllllllllIlIIlIIlIIIIlIllIl);
    }
    
    protected abstract boolean isDirectPathBetweenPoints(final Vec3 p0, final Vec3 p1, final int p2, final int p3, final int p4);
}
