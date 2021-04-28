package net.minecraft.pathfinding;

import net.minecraft.util.*;
import net.minecraft.entity.*;

public class PathEntity
{
    private /* synthetic */ int currentPathIndex;
    private final /* synthetic */ PathPoint[] points;
    private /* synthetic */ int pathLength;
    
    public PathPoint getFinalPathPoint() {
        return (this.pathLength > 0) ? this.points[this.pathLength - 1] : null;
    }
    
    public PathEntity(final PathPoint[] lllllllllllllllIIIlllllIIIIllllI) {
        this.points = lllllllllllllllIIIlllllIIIIllllI;
        this.pathLength = lllllllllllllllIIIlllllIIIIllllI.length;
    }
    
    public PathPoint getPathPointFromIndex(final int lllllllllllllllIIIlllllIIIIIllIl) {
        return this.points[lllllllllllllllIIIlllllIIIIIllIl];
    }
    
    public boolean isSamePath(final PathEntity lllllllllllllllIIIllllIlllIllllI) {
        if (lllllllllllllllIIIllllIlllIllllI == null) {
            return false;
        }
        if (lllllllllllllllIIIllllIlllIllllI.points.length != this.points.length) {
            return false;
        }
        for (int lllllllllllllllIIIllllIlllIlllIl = 0; lllllllllllllllIIIllllIlllIlllIl < this.points.length; ++lllllllllllllllIIIllllIlllIlllIl) {
            if (this.points[lllllllllllllllIIIllllIlllIlllIl].xCoord != lllllllllllllllIIIllllIlllIllllI.points[lllllllllllllllIIIllllIlllIlllIl].xCoord || this.points[lllllllllllllllIIIllllIlllIlllIl].yCoord != lllllllllllllllIIIllllIlllIllllI.points[lllllllllllllllIIIllllIlllIlllIl].yCoord || this.points[lllllllllllllllIIIllllIlllIlllIl].zCoord != lllllllllllllllIIIllllIlllIllllI.points[lllllllllllllllIIIllllIlllIlllIl].zCoord) {
                return false;
            }
        }
        return true;
    }
    
    public int getCurrentPathIndex() {
        return this.currentPathIndex;
    }
    
    public boolean isDestinationSame(final Vec3 lllllllllllllllIIIllllIlllIlIlIl) {
        final PathPoint lllllllllllllllIIIllllIlllIlIlII = this.getFinalPathPoint();
        return lllllllllllllllIIIllllIlllIlIlII != null && (lllllllllllllllIIIllllIlllIlIlII.xCoord == (int)lllllllllllllllIIIllllIlllIlIlIl.xCoord && lllllllllllllllIIIllllIlllIlIlII.zCoord == (int)lllllllllllllllIIIllllIlllIlIlIl.zCoord);
    }
    
    static {
        __OBFID = "CL_00000575";
    }
    
    public void setCurrentPathLength(final int lllllllllllllllIIIlllllIIIIIIllI) {
        this.pathLength = lllllllllllllllIIIlllllIIIIIIllI;
    }
    
    public boolean isFinished() {
        return this.currentPathIndex >= this.pathLength;
    }
    
    public void setCurrentPathIndex(final int lllllllllllllllIIIllllIlllllllIl) {
        this.currentPathIndex = lllllllllllllllIIIllllIlllllllIl;
    }
    
    public Vec3 getPosition(final Entity lllllllllllllllIIIllllIllllIIlIl) {
        return this.getVectorFromIndex(lllllllllllllllIIIllllIllllIIlIl, this.currentPathIndex);
    }
    
    public void incrementPathIndex() {
        ++this.currentPathIndex;
    }
    
    public int getCurrentPathLength() {
        return this.pathLength;
    }
    
    public Vec3 getVectorFromIndex(final Entity lllllllllllllllIIIllllIlllllIIll, final int lllllllllllllllIIIllllIlllllIIlI) {
        final double lllllllllllllllIIIllllIlllllIIIl = this.points[lllllllllllllllIIIllllIlllllIIlI].xCoord + (int)(lllllllllllllllIIIllllIlllllIIll.width + 1.0f) * 0.5;
        final double lllllllllllllllIIIllllIlllllIIII = this.points[lllllllllllllllIIIllllIlllllIIlI].yCoord;
        final double lllllllllllllllIIIllllIllllIllll = this.points[lllllllllllllllIIIllllIlllllIIlI].zCoord + (int)(lllllllllllllllIIIllllIlllllIIll.width + 1.0f) * 0.5;
        return new Vec3(lllllllllllllllIIIllllIlllllIIIl, lllllllllllllllIIIllllIlllllIIII, lllllllllllllllIIIllllIllllIllll);
    }
}
