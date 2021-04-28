package net.minecraft.pathfinding;

public class Path
{
    private /* synthetic */ int count;
    private /* synthetic */ PathPoint[] pathPoints;
    
    public Path() {
        this.pathPoints = new PathPoint[1024];
    }
    
    static {
        __OBFID = "CL_00000573";
    }
    
    private void sortBack(int lllllllllllllllllIlIIIlIlIIIlIll) {
        final PathPoint lllllllllllllllllIlIIIlIlIIlIIII = this.pathPoints[lllllllllllllllllIlIIIlIlIIIlIll];
        final float lllllllllllllllllIlIIIlIlIIIlllI = lllllllllllllllllIlIIIlIlIIlIIII.distanceToTarget;
        while (lllllllllllllllllIlIIIlIlIIIlIll > 0) {
            final int lllllllllllllllllIlIIIlIlIIIllll = (int)(lllllllllllllllllIlIIIlIlIIIlIll - 1 >> 1);
            final PathPoint lllllllllllllllllIlIIIlIlIIIllIl = this.pathPoints[lllllllllllllllllIlIIIlIlIIIllll];
            if (lllllllllllllllllIlIIIlIlIIIlllI >= lllllllllllllllllIlIIIlIlIIIllIl.distanceToTarget) {
                break;
            }
            this.pathPoints[lllllllllllllllllIlIIIlIlIIIlIll] = lllllllllllllllllIlIIIlIlIIIllIl;
            lllllllllllllllllIlIIIlIlIIIllIl.index = (int)lllllllllllllllllIlIIIlIlIIIlIll;
            lllllllllllllllllIlIIIlIlIIIlIll = lllllllllllllllllIlIIIlIlIIIllll;
        }
        this.pathPoints[lllllllllllllllllIlIIIlIlIIIlIll] = lllllllllllllllllIlIIIlIlIIlIIII;
        lllllllllllllllllIlIIIlIlIIlIIII.index = (int)lllllllllllllllllIlIIIlIlIIIlIll;
    }
    
    public PathPoint dequeue() {
        final PathPoint lllllllllllllllllIlIIIlIlIlIIlll = this.pathPoints[0];
        final PathPoint[] pathPoints = this.pathPoints;
        final int n = 0;
        final PathPoint[] pathPoints2 = this.pathPoints;
        final int count = this.count - 1;
        this.count = count;
        pathPoints[n] = pathPoints2[count];
        this.pathPoints[this.count] = null;
        if (this.count > 0) {
            this.sortForward(0);
        }
        lllllllllllllllllIlIIIlIlIlIIlll.index = -1;
        return lllllllllllllllllIlIIIlIlIlIIlll;
    }
    
    private void sortForward(int lllllllllllllllllIlIIIlIIllIllII) {
        final PathPoint lllllllllllllllllIlIIIlIIlllIlll = this.pathPoints[lllllllllllllllllIlIIIlIIllIllII];
        final float lllllllllllllllllIlIIIlIIlllIllI = lllllllllllllllllIlIIIlIIlllIlll.distanceToTarget;
        while (true) {
            final int lllllllllllllllllIlIIIlIIlllIlIl = (int)(1 + (lllllllllllllllllIlIIIlIIllIllII << 1));
            final int lllllllllllllllllIlIIIlIIlllIlII = lllllllllllllllllIlIIIlIIlllIlIl + 1;
            if (lllllllllllllllllIlIIIlIIlllIlIl >= this.count) {
                break;
            }
            final PathPoint lllllllllllllllllIlIIIlIIlllIIll = this.pathPoints[lllllllllllllllllIlIIIlIIlllIlIl];
            final float lllllllllllllllllIlIIIlIIlllIIlI = lllllllllllllllllIlIIIlIIlllIIll.distanceToTarget;
            PathPoint lllllllllllllllllIlIIIlIIlllIIII = null;
            float lllllllllllllllllIlIIIlIIllIlllI = 0.0f;
            if (lllllllllllllllllIlIIIlIIlllIlII >= this.count) {
                final PathPoint lllllllllllllllllIlIIIlIIlllIIIl = null;
                final float lllllllllllllllllIlIIIlIIllIllll = Float.POSITIVE_INFINITY;
            }
            else {
                lllllllllllllllllIlIIIlIIlllIIII = this.pathPoints[lllllllllllllllllIlIIIlIIlllIlII];
                lllllllllllllllllIlIIIlIIllIlllI = lllllllllllllllllIlIIIlIIlllIIII.distanceToTarget;
            }
            if (lllllllllllllllllIlIIIlIIlllIIlI < lllllllllllllllllIlIIIlIIllIlllI) {
                if (lllllllllllllllllIlIIIlIIlllIIlI >= lllllllllllllllllIlIIIlIIlllIllI) {
                    break;
                }
                this.pathPoints[lllllllllllllllllIlIIIlIIllIllII] = lllllllllllllllllIlIIIlIIlllIIll;
                lllllllllllllllllIlIIIlIIlllIIll.index = (int)lllllllllllllllllIlIIIlIIllIllII;
                lllllllllllllllllIlIIIlIIllIllII = lllllllllllllllllIlIIIlIIlllIlIl;
            }
            else {
                if (lllllllllllllllllIlIIIlIIllIlllI >= lllllllllllllllllIlIIIlIIlllIllI) {
                    break;
                }
                this.pathPoints[lllllllllllllllllIlIIIlIIllIllII] = lllllllllllllllllIlIIIlIIlllIIII;
                lllllllllllllllllIlIIIlIIlllIIII.index = (int)lllllllllllllllllIlIIIlIIllIllII;
                lllllllllllllllllIlIIIlIIllIllII = lllllllllllllllllIlIIIlIIlllIlII;
            }
        }
        this.pathPoints[lllllllllllllllllIlIIIlIIllIllII] = lllllllllllllllllIlIIIlIIlllIlll;
        lllllllllllllllllIlIIIlIIlllIlll.index = (int)lllllllllllllllllIlIIIlIIllIllII;
    }
    
    public boolean isPathEmpty() {
        return this.count == 0;
    }
    
    public PathPoint addPoint(final PathPoint lllllllllllllllllIlIIIlIlIllIIlI) {
        if (lllllllllllllllllIlIIIlIlIllIIlI.index >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        }
        if (this.count == this.pathPoints.length) {
            final PathPoint[] lllllllllllllllllIlIIIlIlIllIIIl = new PathPoint[this.count << 1];
            System.arraycopy(this.pathPoints, 0, lllllllllllllllllIlIIIlIlIllIIIl, 0, this.count);
            this.pathPoints = lllllllllllllllllIlIIIlIlIllIIIl;
        }
        this.pathPoints[this.count] = lllllllllllllllllIlIIIlIlIllIIlI;
        lllllllllllllllllIlIIIlIlIllIIlI.index = this.count;
        this.sortBack(this.count++);
        return lllllllllllllllllIlIIIlIlIllIIlI;
    }
    
    public void clearPath() {
        this.count = 0;
    }
    
    public void changeDistance(final PathPoint lllllllllllllllllIlIIIlIlIIlllll, final float lllllllllllllllllIlIIIlIlIIllllI) {
        final float lllllllllllllllllIlIIIlIlIIlllIl = lllllllllllllllllIlIIIlIlIIlllll.distanceToTarget;
        lllllllllllllllllIlIIIlIlIIlllll.distanceToTarget = lllllllllllllllllIlIIIlIlIIllllI;
        if (lllllllllllllllllIlIIIlIlIIllllI < lllllllllllllllllIlIIIlIlIIlllIl) {
            this.sortBack(lllllllllllllllllIlIIIlIlIIlllll.index);
        }
        else {
            this.sortForward(lllllllllllllllllIlIIIlIlIIlllll.index);
        }
    }
}
