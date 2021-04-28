package net.minecraft.util;

import com.google.common.base.*;

public class Vec3i implements Comparable
{
    private final /* synthetic */ int z;
    private final /* synthetic */ int y;
    private final /* synthetic */ int x;
    
    @Override
    public String toString() {
        return Objects.toStringHelper((Object)this).add("x", this.getX()).add("y", this.getY()).add("z", this.getZ()).toString();
    }
    
    public double distanceSqToCenter(final double llllllllllllllllIlIlIlIlIllIllII, final double llllllllllllllllIlIlIlIlIllIlIll, final double llllllllllllllllIlIlIlIlIllIlIlI) {
        final double llllllllllllllllIlIlIlIlIlllIIII = this.getX() + 0.5 - llllllllllllllllIlIlIlIlIllIllII;
        final double llllllllllllllllIlIlIlIlIllIllll = this.getY() + 0.5 - llllllllllllllllIlIlIlIlIllIlIll;
        final double llllllllllllllllIlIlIlIlIllIlllI = this.getZ() + 0.5 - llllllllllllllllIlIlIlIlIllIlIlI;
        return llllllllllllllllIlIlIlIlIlllIIII * llllllllllllllllIlIlIlIlIlllIIII + llllllllllllllllIlIlIlIlIllIllll * llllllllllllllllIlIlIlIlIllIllll + llllllllllllllllIlIlIlIlIllIlllI * llllllllllllllllIlIlIlIlIllIlllI;
    }
    
    public int compareTo(final Vec3i llllllllllllllllIlIlIlIllIlIIIlI) {
        return (this.getY() == llllllllllllllllIlIlIlIllIlIIIlI.getY()) ? ((this.getZ() == llllllllllllllllIlIlIlIllIlIIIlI.getZ()) ? (this.getX() - llllllllllllllllIlIlIlIllIlIIIlI.getX()) : (this.getZ() - llllllllllllllllIlIlIlIllIlIIIlI.getZ())) : (this.getY() - llllllllllllllllIlIlIlIllIlIIIlI.getY());
    }
    
    static {
        __OBFID = "CL_00002315";
        NULL_VECTOR = new Vec3i(0, 0, 0);
    }
    
    public int getX() {
        return this.x;
    }
    
    @Override
    public int hashCode() {
        return (this.getY() + this.getZ() * 31) * 31 + this.getX();
    }
    
    public int getZ() {
        return this.z;
    }
    
    public double distanceSq(final double llllllllllllllllIlIlIlIllIIIlIII, final double llllllllllllllllIlIlIlIllIIIIIII, final double llllllllllllllllIlIlIlIlIlllllll) {
        final double llllllllllllllllIlIlIlIllIIIIlIl = this.getX() - llllllllllllllllIlIlIlIllIIIlIII;
        final double llllllllllllllllIlIlIlIllIIIIlII = this.getY() - llllllllllllllllIlIlIlIllIIIIIII;
        final double llllllllllllllllIlIlIlIllIIIIIll = this.getZ() - llllllllllllllllIlIlIlIlIlllllll;
        return llllllllllllllllIlIlIlIllIIIIlIl * llllllllllllllllIlIlIlIllIIIIlIl + llllllllllllllllIlIlIlIllIIIIlII * llllllllllllllllIlIlIlIllIIIIlII + llllllllllllllllIlIlIlIllIIIIIll * llllllllllllllllIlIlIlIllIIIIIll;
    }
    
    public int getY() {
        return this.y;
    }
    
    public Vec3i(final double llllllllllllllllIlIlIlIllIllIlII, final double llllllllllllllllIlIlIlIllIllIlll, final double llllllllllllllllIlIlIlIllIllIllI) {
        this(MathHelper.floor_double(llllllllllllllllIlIlIlIllIllIlII), MathHelper.floor_double(llllllllllllllllIlIlIlIllIllIlll), MathHelper.floor_double(llllllllllllllllIlIlIlIllIllIllI));
    }
    
    @Override
    public int compareTo(final Object llllllllllllllllIlIlIlIlIlIllIII) {
        return this.compareTo((Vec3i)llllllllllllllllIlIlIlIlIlIllIII);
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIlIlIlIllIlIllIl) {
        if (this == llllllllllllllllIlIlIlIllIlIllIl) {
            return true;
        }
        if (!(llllllllllllllllIlIlIlIllIlIllIl instanceof Vec3i)) {
            return false;
        }
        final Vec3i llllllllllllllllIlIlIlIllIlIllII = (Vec3i)llllllllllllllllIlIlIlIllIlIllIl;
        return this.getX() == llllllllllllllllIlIlIlIllIlIllII.getX() && this.getY() == llllllllllllllllIlIlIlIllIlIllII.getY() && this.getZ() == llllllllllllllllIlIlIlIllIlIllII.getZ();
    }
    
    public Vec3i crossProduct(final Vec3i llllllllllllllllIlIlIlIllIIlIIll) {
        return new Vec3i(this.getY() * llllllllllllllllIlIlIlIllIIlIIll.getZ() - this.getZ() * llllllllllllllllIlIlIlIllIIlIIll.getY(), this.getZ() * llllllllllllllllIlIlIlIllIIlIIll.getX() - this.getX() * llllllllllllllllIlIlIlIllIIlIIll.getZ(), this.getX() * llllllllllllllllIlIlIlIllIIlIIll.getY() - this.getY() * llllllllllllllllIlIlIlIllIIlIIll.getX());
    }
    
    public Vec3i(final int llllllllllllllllIlIlIlIlllIIIIII, final int llllllllllllllllIlIlIlIllIllllll, final int llllllllllllllllIlIlIlIllIlllllI) {
        this.x = llllllllllllllllIlIlIlIlllIIIIII;
        this.y = llllllllllllllllIlIlIlIllIllllll;
        this.z = llllllllllllllllIlIlIlIllIlllllI;
    }
    
    public double distanceSq(final Vec3i llllllllllllllllIlIlIlIlIllIIIIl) {
        return this.distanceSq(llllllllllllllllIlIlIlIlIllIIIIl.getX(), llllllllllllllllIlIlIlIlIllIIIIl.getY(), llllllllllllllllIlIlIlIlIllIIIIl.getZ());
    }
}
