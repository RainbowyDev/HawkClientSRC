package net.minecraft.pathfinding;

import net.minecraft.world.pathfinder.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class PathFinder
{
    private /* synthetic */ PathPoint[] pathOptions;
    private /* synthetic */ NodeProcessor field_176190_c;
    private /* synthetic */ Path path;
    
    public PathEntity func_180782_a(final IBlockAccess lllllllllllllllIIlIlIIllllIIllIl, final Entity lllllllllllllllIIlIlIIllllIIllII, final BlockPos lllllllllllllllIIlIlIIllllIIlIll, final float lllllllllllllllIIlIlIIllllIIllll) {
        return this.func_176189_a(lllllllllllllllIIlIlIIllllIIllIl, lllllllllllllllIIlIlIIllllIIllII, lllllllllllllllIIlIlIIllllIIlIll.getX() + 0.5f, lllllllllllllllIIlIlIIllllIIlIll.getY() + 0.5f, lllllllllllllllIIlIlIIllllIIlIll.getZ() + 0.5f, lllllllllllllllIIlIlIIllllIIllll);
    }
    
    public PathFinder(final NodeProcessor lllllllllllllllIIlIlIIlllllIlIlI) {
        this.path = new Path();
        this.pathOptions = new PathPoint[32];
        this.field_176190_c = lllllllllllllllIIlIlIIlllllIlIlI;
    }
    
    public PathEntity func_176188_a(final IBlockAccess lllllllllllllllIIlIlIIlllllIIIIl, final Entity lllllllllllllllIIlIlIIllllIllIll, final Entity lllllllllllllllIIlIlIIllllIllIlI, final float lllllllllllllllIIlIlIIllllIllllI) {
        return this.func_176189_a(lllllllllllllllIIlIlIIlllllIIIIl, lllllllllllllllIIlIlIIllllIllIll, lllllllllllllllIIlIlIIllllIllIlI.posX, lllllllllllllllIIlIlIIllllIllIlI.getEntityBoundingBox().minY, lllllllllllllllIIlIlIIllllIllIlI.posZ, lllllllllllllllIIlIlIIllllIllllI);
    }
    
    private PathEntity func_176189_a(final IBlockAccess lllllllllllllllIIlIlIIlllIllIlII, final Entity lllllllllllllllIIlIlIIlllIllIIll, final double lllllllllllllllIIlIlIIlllIllIIlI, final double lllllllllllllllIIlIlIIlllIllIIIl, final double lllllllllllllllIIlIlIIlllIlllIlI, final float lllllllllllllllIIlIlIIlllIlllIIl) {
        this.path.clearPath();
        this.field_176190_c.func_176162_a(lllllllllllllllIIlIlIIlllIllIlII, lllllllllllllllIIlIlIIlllIllIIll);
        final PathPoint lllllllllllllllIIlIlIIlllIlllIII = this.field_176190_c.func_176161_a(lllllllllllllllIIlIlIIlllIllIIll);
        final PathPoint lllllllllllllllIIlIlIIlllIllIlll = this.field_176190_c.func_176160_a(lllllllllllllllIIlIlIIlllIllIIll, lllllllllllllllIIlIlIIlllIllIIlI, lllllllllllllllIIlIlIIlllIllIIIl, lllllllllllllllIIlIlIIlllIlllIlI);
        final PathEntity lllllllllllllllIIlIlIIlllIllIllI = this.func_176187_a(lllllllllllllllIIlIlIIlllIllIIll, lllllllllllllllIIlIlIIlllIlllIII, lllllllllllllllIIlIlIIlllIllIlll, lllllllllllllllIIlIlIIlllIlllIIl);
        this.field_176190_c.func_176163_a();
        return lllllllllllllllIIlIlIIlllIllIllI;
    }
    
    private PathEntity func_176187_a(final Entity lllllllllllllllIIlIlIIlllIIlllll, final PathPoint lllllllllllllllIIlIlIIlllIIlIIll, final PathPoint lllllllllllllllIIlIlIIlllIIlllIl, final float lllllllllllllllIIlIlIIlllIIlIIIl) {
        lllllllllllllllIIlIlIIlllIIlIIll.totalPathDistance = 0.0f;
        lllllllllllllllIIlIlIIlllIIlIIll.distanceToNext = lllllllllllllllIIlIlIIlllIIlIIll.distanceToSquared(lllllllllllllllIIlIlIIlllIIlllIl);
        lllllllllllllllIIlIlIIlllIIlIIll.distanceToTarget = lllllllllllllllIIlIlIIlllIIlIIll.distanceToNext;
        this.path.clearPath();
        this.path.addPoint(lllllllllllllllIIlIlIIlllIIlIIll);
        PathPoint lllllllllllllllIIlIlIIlllIIllIll = lllllllllllllllIIlIlIIlllIIlIIll;
        while (!this.path.isPathEmpty()) {
            final PathPoint lllllllllllllllIIlIlIIlllIIllIlI = this.path.dequeue();
            if (lllllllllllllllIIlIlIIlllIIllIlI.equals(lllllllllllllllIIlIlIIlllIIlllIl)) {
                return this.createEntityPath(lllllllllllllllIIlIlIIlllIIlIIll, lllllllllllllllIIlIlIIlllIIlllIl);
            }
            if (lllllllllllllllIIlIlIIlllIIllIlI.distanceToSquared(lllllllllllllllIIlIlIIlllIIlllIl) < lllllllllllllllIIlIlIIlllIIllIll.distanceToSquared(lllllllllllllllIIlIlIIlllIIlllIl)) {
                lllllllllllllllIIlIlIIlllIIllIll = lllllllllllllllIIlIlIIlllIIllIlI;
            }
            lllllllllllllllIIlIlIIlllIIllIlI.visited = true;
            for (int lllllllllllllllIIlIlIIlllIIllIIl = this.field_176190_c.func_176164_a(this.pathOptions, lllllllllllllllIIlIlIIlllIIlllll, lllllllllllllllIIlIlIIlllIIllIlI, lllllllllllllllIIlIlIIlllIIlllIl, lllllllllllllllIIlIlIIlllIIlIIIl), lllllllllllllllIIlIlIIlllIIllIII = 0; lllllllllllllllIIlIlIIlllIIllIII < lllllllllllllllIIlIlIIlllIIllIIl; ++lllllllllllllllIIlIlIIlllIIllIII) {
                final PathPoint lllllllllllllllIIlIlIIlllIIlIlll = this.pathOptions[lllllllllllllllIIlIlIIlllIIllIII];
                final float lllllllllllllllIIlIlIIlllIIlIllI = lllllllllllllllIIlIlIIlllIIllIlI.totalPathDistance + lllllllllllllllIIlIlIIlllIIllIlI.distanceToSquared(lllllllllllllllIIlIlIIlllIIlIlll);
                if (lllllllllllllllIIlIlIIlllIIlIllI < lllllllllllllllIIlIlIIlllIIlIIIl * 2.0f && (!lllllllllllllllIIlIlIIlllIIlIlll.isAssigned() || lllllllllllllllIIlIlIIlllIIlIllI < lllllllllllllllIIlIlIIlllIIlIlll.totalPathDistance)) {
                    lllllllllllllllIIlIlIIlllIIlIlll.previous = lllllllllllllllIIlIlIIlllIIllIlI;
                    lllllllllllllllIIlIlIIlllIIlIlll.totalPathDistance = lllllllllllllllIIlIlIIlllIIlIllI;
                    lllllllllllllllIIlIlIIlllIIlIlll.distanceToNext = lllllllllllllllIIlIlIIlllIIlIlll.distanceToSquared(lllllllllllllllIIlIlIIlllIIlllIl);
                    if (lllllllllllllllIIlIlIIlllIIlIlll.isAssigned()) {
                        this.path.changeDistance(lllllllllllllllIIlIlIIlllIIlIlll, lllllllllllllllIIlIlIIlllIIlIlll.totalPathDistance + lllllllllllllllIIlIlIIlllIIlIlll.distanceToNext);
                    }
                    else {
                        lllllllllllllllIIlIlIIlllIIlIlll.distanceToTarget = lllllllllllllllIIlIlIIlllIIlIlll.totalPathDistance + lllllllllllllllIIlIlIIlllIIlIlll.distanceToNext;
                        this.path.addPoint(lllllllllllllllIIlIlIIlllIIlIlll);
                    }
                }
            }
        }
        if (lllllllllllllllIIlIlIIlllIIllIll == lllllllllllllllIIlIlIIlllIIlIIll) {
            return null;
        }
        return this.createEntityPath(lllllllllllllllIIlIlIIlllIIlIIll, lllllllllllllllIIlIlIIlllIIllIll);
    }
    
    static {
        __OBFID = "CL_00000576";
    }
    
    private PathEntity createEntityPath(final PathPoint lllllllllllllllIIlIlIIlllIIIIlIl, final PathPoint lllllllllllllllIIlIlIIlllIIIIIII) {
        int lllllllllllllllIIlIlIIlllIIIIIll = 1;
        for (PathPoint lllllllllllllllIIlIlIIlllIIIIIlI = lllllllllllllllIIlIlIIlllIIIIIII; lllllllllllllllIIlIlIIlllIIIIIlI.previous != null; lllllllllllllllIIlIlIIlllIIIIIlI = lllllllllllllllIIlIlIIlllIIIIIlI.previous) {
            ++lllllllllllllllIIlIlIIlllIIIIIll;
        }
        final PathPoint[] lllllllllllllllIIlIlIIlllIIIIIIl = new PathPoint[lllllllllllllllIIlIlIIlllIIIIIll];
        PathPoint lllllllllllllllIIlIlIIlllIIIIIlI = lllllllllllllllIIlIlIIlllIIIIIII;
        --lllllllllllllllIIlIlIIlllIIIIIll;
        lllllllllllllllIIlIlIIlllIIIIIIl[lllllllllllllllIIlIlIIlllIIIIIll] = lllllllllllllllIIlIlIIlllIIIIIII;
        while (lllllllllllllllIIlIlIIlllIIIIIlI.previous != null) {
            lllllllllllllllIIlIlIIlllIIIIIlI = lllllllllllllllIIlIlIIlllIIIIIlI.previous;
            --lllllllllllllllIIlIlIIlllIIIIIll;
            lllllllllllllllIIlIlIIlllIIIIIIl[lllllllllllllllIIlIlIIlllIIIIIll] = lllllllllllllllIIlIlIIlllIIIIIlI;
        }
        return new PathEntity(lllllllllllllllIIlIlIIlllIIIIIIl);
    }
}
