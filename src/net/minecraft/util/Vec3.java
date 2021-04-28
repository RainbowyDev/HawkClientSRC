package net.minecraft.util;

public class Vec3
{
    public final /* synthetic */ double zCoord;
    public final /* synthetic */ double yCoord;
    public final /* synthetic */ double xCoord;
    
    public Vec3 crossProduct(final Vec3 lIlllllIIlIIllI) {
        return new Vec3(this.yCoord * lIlllllIIlIIllI.zCoord - this.zCoord * lIlllllIIlIIllI.yCoord, this.zCoord * lIlllllIIlIIllI.xCoord - this.xCoord * lIlllllIIlIIllI.zCoord, this.xCoord * lIlllllIIlIIllI.yCoord - this.yCoord * lIlllllIIlIIllI.xCoord);
    }
    
    public Vec3 getIntermediateWithZValue(final Vec3 lIllllIlIlIIlIl, final double lIllllIlIlIIlII) {
        final double lIllllIlIlIlIlI = lIllllIlIlIIlIl.xCoord - this.xCoord;
        final double lIllllIlIlIlIIl = lIllllIlIlIIlIl.yCoord - this.yCoord;
        final double lIllllIlIlIlIII = lIllllIlIlIIlIl.zCoord - this.zCoord;
        if (lIllllIlIlIlIII * lIllllIlIlIlIII < 1.0000000116860974E-7) {
            return null;
        }
        final double lIllllIlIlIIlll = (lIllllIlIlIIlII - this.zCoord) / lIllllIlIlIlIII;
        return (lIllllIlIlIIlll >= 0.0 && lIllllIlIlIIlll <= 1.0) ? new Vec3(this.xCoord + lIllllIlIlIlIlI * lIllllIlIlIIlll, this.yCoord + lIllllIlIlIlIIl * lIllllIlIlIIlll, this.zCoord + lIllllIlIlIlIII * lIllllIlIlIIlll) : null;
    }
    
    public Vec3(double lIlllllIIlllllI, double lIlllllIIllllIl, double lIlllllIIllllII) {
        if (lIlllllIIlllllI == -0.0) {
            lIlllllIIlllllI = 0.0;
        }
        if (lIlllllIIllllIl == -0.0) {
            lIlllllIIllllIl = 0.0;
        }
        if (lIlllllIIllllII == -0.0) {
            lIlllllIIllllII = 0.0;
        }
        this.xCoord = lIlllllIIlllllI;
        this.yCoord = lIlllllIIllllIl;
        this.zCoord = lIlllllIIllllII;
    }
    
    public Vec3 subtract(final double lIlllllIIIlIlII, final double lIlllllIIIlIIll, final double lIlllllIIIlIllI) {
        return this.addVector(-lIlllllIIIlIlII, -lIlllllIIIlIIll, -lIlllllIIIlIllI);
    }
    
    public Vec3 rotatePitch(final float lIllllIlIIIllIl) {
        final float lIllllIlIIlIIll = MathHelper.cos(lIllllIlIIIllIl);
        final float lIllllIlIIlIIlI = MathHelper.sin(lIllllIlIIIllIl);
        final double lIllllIlIIlIIIl = this.xCoord;
        final double lIllllIlIIlIIII = this.yCoord * lIllllIlIIlIIll + this.zCoord * lIllllIlIIlIIlI;
        final double lIllllIlIIIllll = this.zCoord * lIllllIlIIlIIll - this.yCoord * lIllllIlIIlIIlI;
        return new Vec3(lIllllIlIIlIIIl, lIllllIlIIlIIII, lIllllIlIIIllll);
    }
    
    public Vec3 add(final Vec3 lIlllllIIIIllII) {
        return this.addVector(lIlllllIIIIllII.xCoord, lIlllllIIIIllII.yCoord, lIlllllIIIIllII.zCoord);
    }
    
    public Vec3 getIntermediateWithYValue(final Vec3 lIllllIllIIIIIl, final double lIllllIlIlllIIl) {
        final double lIllllIlIllllll = lIllllIllIIIIIl.xCoord - this.xCoord;
        final double lIllllIlIlllllI = lIllllIllIIIIIl.yCoord - this.yCoord;
        final double lIllllIlIllllIl = lIllllIllIIIIIl.zCoord - this.zCoord;
        if (lIllllIlIlllllI * lIllllIlIlllllI < 1.0000000116860974E-7) {
            return null;
        }
        final double lIllllIlIllllII = (lIllllIlIlllIIl - this.yCoord) / lIllllIlIlllllI;
        return (lIllllIlIllllII >= 0.0 && lIllllIlIllllII <= 1.0) ? new Vec3(this.xCoord + lIllllIlIllllll * lIllllIlIllllII, this.yCoord + lIllllIlIlllllI * lIllllIlIllllII, this.zCoord + lIllllIlIllllIl * lIllllIlIllllII) : null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.xCoord).append(", ").append(this.yCoord).append(", ").append(this.zCoord).append(")"));
    }
    
    public double distanceTo(final Vec3 lIllllIlllllIIl) {
        final double lIllllIlllllIII = lIllllIlllllIIl.xCoord - this.xCoord;
        final double lIllllIllllIlll = lIllllIlllllIIl.yCoord - this.yCoord;
        final double lIllllIllllIllI = lIllllIlllllIIl.zCoord - this.zCoord;
        return MathHelper.sqrt_double(lIllllIlllllIII * lIllllIlllllIII + lIllllIllllIlll * lIllllIllllIlll + lIllllIllllIllI * lIllllIllllIllI);
    }
    
    public Vec3 getIntermediateWithXValue(final Vec3 lIllllIllIlIllI, final double lIllllIllIIlllI) {
        final double lIllllIllIlIlII = lIllllIllIlIllI.xCoord - this.xCoord;
        final double lIllllIllIlIIll = lIllllIllIlIllI.yCoord - this.yCoord;
        final double lIllllIllIlIIlI = lIllllIllIlIllI.zCoord - this.zCoord;
        if (lIllllIllIlIlII * lIllllIllIlIlII < 1.0000000116860974E-7) {
            return null;
        }
        final double lIllllIllIlIIIl = (lIllllIllIIlllI - this.xCoord) / lIllllIllIlIlII;
        return (lIllllIllIlIIIl >= 0.0 && lIllllIllIlIIIl <= 1.0) ? new Vec3(this.xCoord + lIllllIllIlIlII * lIllllIllIlIIIl, this.yCoord + lIllllIllIlIIll * lIllllIllIlIIIl, this.zCoord + lIllllIllIlIIlI * lIllllIllIlIIIl) : null;
    }
    
    public double dotProduct(final Vec3 lIlllllIIlIllII) {
        return this.xCoord * lIlllllIIlIllII.xCoord + this.yCoord * lIlllllIIlIllII.yCoord + this.zCoord * lIlllllIIlIllII.zCoord;
    }
    
    public double squareDistanceTo(final Vec3 lIllllIlllIIlIl) {
        final double lIllllIlllIlIIl = lIllllIlllIIlIl.xCoord - this.xCoord;
        final double lIllllIlllIlIII = lIllllIlllIIlIl.yCoord - this.yCoord;
        final double lIllllIlllIIlll = lIllllIlllIIlIl.zCoord - this.zCoord;
        return lIllllIlllIlIIl * lIllllIlllIlIIl + lIllllIlllIlIII * lIllllIlllIlIII + lIllllIlllIIlll * lIllllIlllIIlll;
    }
    
    public double lengthVector() {
        return MathHelper.sqrt_double(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
    }
    
    public Vec3 normalize() {
        final double lIlllllIIllIIlI = MathHelper.sqrt_double(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
        return (lIlllllIIllIIlI < 1.0E-4) ? new Vec3(0.0, 0.0, 0.0) : new Vec3(this.xCoord / lIlllllIIllIIlI, this.yCoord / lIlllllIIllIIlI, this.zCoord / lIlllllIIllIIlI);
    }
    
    public Vec3 subtract(final Vec3 lIlllllIIlIIIII) {
        return this.subtract(lIlllllIIlIIIII.xCoord, lIlllllIIlIIIII.yCoord, lIlllllIIlIIIII.zCoord);
    }
    
    static {
        __OBFID = "CL_00000612";
    }
    
    public Vec3 subtractReverse(final Vec3 lIlllllIIllIllI) {
        return new Vec3(lIlllllIIllIllI.xCoord - this.xCoord, lIlllllIIllIllI.yCoord - this.yCoord, lIlllllIIllIllI.zCoord - this.zCoord);
    }
    
    public Vec3 rotateYaw(final float lIllllIIllllIII) {
        final float lIllllIIllllllI = MathHelper.cos(lIllllIIllllIII);
        final float lIllllIIlllllIl = MathHelper.sin(lIllllIIllllIII);
        final double lIllllIIlllllII = this.xCoord * lIllllIIllllllI + this.zCoord * lIllllIIlllllIl;
        final double lIllllIIllllIll = this.yCoord;
        final double lIllllIIllllIlI = this.zCoord * lIllllIIllllllI - this.xCoord * lIllllIIlllllIl;
        return new Vec3(lIllllIIlllllII, lIllllIIllllIll, lIllllIIllllIlI);
    }
    
    public Vec3 addVector(final double lIlllllIIIIIIlI, final double lIlllllIIIIIlIl, final double lIlllllIIIIIlII) {
        return new Vec3(this.xCoord + lIlllllIIIIIIlI, this.yCoord + lIlllllIIIIIlIl, this.zCoord + lIlllllIIIIIlII);
    }
}
