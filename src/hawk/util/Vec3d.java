package hawk.util;

import net.minecraft.util.*;

public class Vec3d
{
    public final /* synthetic */ double zCoord;
    public final /* synthetic */ double yCoord;
    public final /* synthetic */ double xCoord;
    public static final /* synthetic */ Vec3d ZERO;
    
    public Vec3d(final Vec3i lllllllllllllllllllIIIlIlIllIlII) {
        this(lllllllllllllllllllIIIlIlIllIlII.getX(), lllllllllllllllllllIIIlIlIllIlII.getY(), lllllllllllllllllllIIIlIlIllIlII.getZ());
    }
    
    public Vec3d addVector(final double lllllllllllllllllllIIIlIlIIIllII, final double lllllllllllllllllllIIIlIlIIIlIll, final double lllllllllllllllllllIIIlIlIIIlIlI) {
        return new Vec3d(this.xCoord + lllllllllllllllllllIIIlIlIIIllII, this.yCoord + lllllllllllllllllllIIIlIlIIIlIll, this.zCoord + lllllllllllllllllllIIIlIlIIIlIlI);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.xCoord).append(", ").append(this.yCoord).append(", ").append(this.zCoord).append(")"));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllllIIIlIIlIllIII) {
        if (this == lllllllllllllllllllIIIlIIlIllIII) {
            return true;
        }
        if (!(lllllllllllllllllllIIIlIIlIllIII instanceof Vec3d)) {
            return false;
        }
        final Vec3d lllllllllllllllllllIIIlIIlIllIlI = (Vec3d)lllllllllllllllllllIIIlIIlIllIII;
        return Double.compare(lllllllllllllllllllIIIlIIlIllIlI.xCoord, this.xCoord) == 0 && Double.compare(lllllllllllllllllllIIIlIIlIllIlI.yCoord, this.yCoord) == 0 && Double.compare(lllllllllllllllllllIIIlIIlIllIlI.zCoord, this.zCoord) == 0;
    }
    
    public Vec3d add(final Vec3d lllllllllllllllllllIIIlIlIIlIllI) {
        return this.addVector(lllllllllllllllllllIIIlIlIIlIllI.xCoord, lllllllllllllllllllIIIlIlIIlIllI.yCoord, lllllllllllllllllllIIIlIlIIlIllI.zCoord);
    }
    
    static {
        ZERO = new Vec3d(0.0, 0.0, 0.0);
    }
    
    public Vec3d(double lllllllllllllllllllIIIlIlIllllII, double lllllllllllllllllllIIIlIlIlllIll, double lllllllllllllllllllIIIlIlIlllIlI) {
        if (lllllllllllllllllllIIIlIlIllllII == -0.0) {
            lllllllllllllllllllIIIlIlIllllII = 0.0;
        }
        if (lllllllllllllllllllIIIlIlIlllIll == -0.0) {
            lllllllllllllllllllIIIlIlIlllIll = 0.0;
        }
        if (lllllllllllllllllllIIIlIlIlllIlI == -0.0) {
            lllllllllllllllllllIIIlIlIlllIlI = 0.0;
        }
        this.xCoord = lllllllllllllllllllIIIlIlIllllII;
        this.yCoord = lllllllllllllllllllIIIlIlIlllIll;
        this.zCoord = lllllllllllllllllllIIIlIlIlllIlI;
    }
    
    public Vec3d subtract(final Vec3d lllllllllllllllllllIIIlIlIlIlIlI) {
        return this.subtract(lllllllllllllllllllIIIlIlIlIlIlI.xCoord, lllllllllllllllllllIIIlIlIlIlIlI.yCoord, lllllllllllllllllllIIIlIlIlIlIlI.zCoord);
    }
    
    public double squareDistanceTo(final Vec3d lllllllllllllllllllIIIlIIllllllI) {
        final double lllllllllllllllllllIIIlIlIIIIIlI = lllllllllllllllllllIIIlIIllllllI.xCoord - this.xCoord;
        final double lllllllllllllllllllIIIlIlIIIIIIl = lllllllllllllllllllIIIlIIllllllI.yCoord - this.yCoord;
        final double lllllllllllllllllllIIIlIlIIIIIII = lllllllllllllllllllIIIlIIllllllI.zCoord - this.zCoord;
        return lllllllllllllllllllIIIlIlIIIIIlI * lllllllllllllllllllIIIlIlIIIIIlI + lllllllllllllllllllIIIlIlIIIIIIl * lllllllllllllllllllIIIlIlIIIIIIl + lllllllllllllllllllIIIlIlIIIIIII * lllllllllllllllllllIIIlIlIIIIIII;
    }
    
    public Vec3d subtract(final double lllllllllllllllllllIIIlIlIlIIIlI, final double lllllllllllllllllllIIIlIlIIlllIl, final double lllllllllllllllllllIIIlIlIIlllII) {
        return this.addVector(-lllllllllllllllllllIIIlIlIlIIIlI, -lllllllllllllllllllIIIlIlIIlllIl, -lllllllllllllllllllIIIlIlIIlllII);
    }
    
    public Vec3d normalize() {
        final double lllllllllllllllllllIIIlIlIllIIII = Math.sqrt(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
        return (lllllllllllllllllllIIIlIlIllIIII < 1.0E-4) ? Vec3d.ZERO : new Vec3d(this.xCoord / lllllllllllllllllllIIIlIlIllIIII, this.yCoord / lllllllllllllllllllIIIlIlIllIIII, this.zCoord / lllllllllllllllllllIIIlIlIllIIII);
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllllllllIIIlIIlIlIIlI = Double.doubleToLongBits(this.xCoord);
        int lllllllllllllllllllIIIlIIlIlIIIl = (int)(lllllllllllllllllllIIIlIIlIlIIlI ^ lllllllllllllllllllIIIlIIlIlIIlI >>> 32);
        lllllllllllllllllllIIIlIIlIlIIlI = Double.doubleToLongBits(this.yCoord);
        lllllllllllllllllllIIIlIIlIlIIIl = 31 * lllllllllllllllllllIIIlIIlIlIIIl + (int)(lllllllllllllllllllIIIlIIlIlIIlI ^ lllllllllllllllllllIIIlIIlIlIIlI >>> 32);
        lllllllllllllllllllIIIlIIlIlIIlI = Double.doubleToLongBits(this.zCoord);
        lllllllllllllllllllIIIlIIlIlIIIl = 31 * lllllllllllllllllllIIIlIIlIlIIIl + (int)(lllllllllllllllllllIIIlIIlIlIIlI ^ lllllllllllllllllllIIIlIIlIlIIlI >>> 32);
        return lllllllllllllllllllIIIlIIlIlIIIl;
    }
    
    public double squareDistanceTo(final double lllllllllllllllllllIIIlIIlllIIlI, final double lllllllllllllllllllIIIlIIllIlIlI, final double lllllllllllllllllllIIIlIIlllIIII) {
        final double lllllllllllllllllllIIIlIIllIllll = lllllllllllllllllllIIIlIIlllIIlI - this.xCoord;
        final double lllllllllllllllllllIIIlIIllIlllI = lllllllllllllllllllIIIlIIllIlIlI - this.yCoord;
        final double lllllllllllllllllllIIIlIIllIllIl = lllllllllllllllllllIIIlIIlllIIII - this.zCoord;
        return lllllllllllllllllllIIIlIIllIllll * lllllllllllllllllllIIIlIIllIllll + lllllllllllllllllllIIIlIIllIlllI * lllllllllllllllllllIIIlIIllIlllI + lllllllllllllllllllIIIlIIllIllIl * lllllllllllllllllllIIIlIIllIllIl;
    }
    
    public Vec3d scale(final double lllllllllllllllllllIIIlIIllIIIlI) {
        return new Vec3d(this.xCoord * lllllllllllllllllllIIIlIIllIIIlI, this.yCoord * lllllllllllllllllllIIIlIIllIIIlI, this.zCoord * lllllllllllllllllllIIIlIIllIIIlI);
    }
}
