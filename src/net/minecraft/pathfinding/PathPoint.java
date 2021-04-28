package net.minecraft.pathfinding;

import net.minecraft.util.*;

public class PathPoint
{
    /* synthetic */ int index;
    public final /* synthetic */ int xCoord;
    private final /* synthetic */ int hash;
    public final /* synthetic */ int yCoord;
    public final /* synthetic */ int zCoord;
    
    @Override
    public boolean equals(final Object llllllllllllllllllIIIIllIIlIlIlI) {
        if (!(llllllllllllllllllIIIIllIIlIlIlI instanceof PathPoint)) {
            return false;
        }
        final PathPoint llllllllllllllllllIIIIllIIlIllII = (PathPoint)llllllllllllllllllIIIIllIIlIlIlI;
        return this.hash == llllllllllllllllllIIIIllIIlIllII.hash && this.xCoord == llllllllllllllllllIIIIllIIlIllII.xCoord && this.yCoord == llllllllllllllllllIIIIllIIlIllII.yCoord && this.zCoord == llllllllllllllllllIIIIllIIlIllII.zCoord;
    }
    
    public PathPoint(final int llllllllllllllllllIIIIllIlIlllll, final int llllllllllllllllllIIIIllIlIllllI, final int llllllllllllllllllIIIIllIlIllIIl) {
        this.index = -1;
        this.xCoord = llllllllllllllllllIIIIllIlIlllll;
        this.yCoord = llllllllllllllllllIIIIllIlIllllI;
        this.zCoord = llllllllllllllllllIIIIllIlIllIIl;
        this.hash = makeHash(llllllllllllllllllIIIIllIlIlllll, llllllllllllllllllIIIIllIlIllllI, llllllllllllllllllIIIIllIlIllIIl);
    }
    
    public boolean isAssigned() {
        return this.index >= 0;
    }
    
    public float distanceToSquared(final PathPoint llllllllllllllllllIIIIllIIllIlIl) {
        final float llllllllllllllllllIIIIllIIlllIIl = (float)(llllllllllllllllllIIIIllIIllIlIl.xCoord - this.xCoord);
        final float llllllllllllllllllIIIIllIIlllIII = (float)(llllllllllllllllllIIIIllIIllIlIl.yCoord - this.yCoord);
        final float llllllllllllllllllIIIIllIIllIlll = (float)(llllllllllllllllllIIIIllIIllIlIl.zCoord - this.zCoord);
        return llllllllllllllllllIIIIllIIlllIIl * llllllllllllllllllIIIIllIIlllIIl + llllllllllllllllllIIIIllIIlllIII * llllllllllllllllllIIIIllIIlllIII + llllllllllllllllllIIIIllIIllIlll * llllllllllllllllllIIIIllIIllIlll;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.xCoord)).append(", ").append(this.yCoord).append(", ").append(this.zCoord));
    }
    
    public static int makeHash(final int llllllllllllllllllIIIIllIlIlIlIl, final int llllllllllllllllllIIIIllIlIlIIIl, final int llllllllllllllllllIIIIllIlIlIIII) {
        return (llllllllllllllllllIIIIllIlIlIIIl & 0xFF) | (llllllllllllllllllIIIIllIlIlIlIl & 0x7FFF) << 8 | (llllllllllllllllllIIIIllIlIlIIII & 0x7FFF) << 24 | ((llllllllllllllllllIIIIllIlIlIlIl < 0) ? Integer.MIN_VALUE : 0) | ((llllllllllllllllllIIIIllIlIlIIII < 0) ? 32768 : 0);
    }
    
    @Override
    public int hashCode() {
        return this.hash;
    }
    
    public float distanceTo(final PathPoint llllllllllllllllllIIIIllIlIIlIIl) {
        final float llllllllllllllllllIIIIllIlIIlIII = (float)(llllllllllllllllllIIIIllIlIIlIIl.xCoord - this.xCoord);
        final float llllllllllllllllllIIIIllIlIIIlll = (float)(llllllllllllllllllIIIIllIlIIlIIl.yCoord - this.yCoord);
        final float llllllllllllllllllIIIIllIlIIIllI = (float)(llllllllllllllllllIIIIllIlIIlIIl.zCoord - this.zCoord);
        return MathHelper.sqrt_float(llllllllllllllllllIIIIllIlIIlIII * llllllllllllllllllIIIIllIlIIlIII + llllllllllllllllllIIIIllIlIIIlll * llllllllllllllllllIIIIllIlIIIlll + llllllllllllllllllIIIIllIlIIIllI * llllllllllllllllllIIIIllIlIIIllI);
    }
    
    static {
        __OBFID = "CL_00000574";
    }
}
