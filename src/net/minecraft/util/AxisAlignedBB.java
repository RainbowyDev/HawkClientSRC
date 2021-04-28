package net.minecraft.util;

public class AxisAlignedBB
{
    public final /* synthetic */ double minZ;
    public final /* synthetic */ double minX;
    public final /* synthetic */ double maxZ;
    public final /* synthetic */ double minY;
    public final /* synthetic */ double maxX;
    public final /* synthetic */ double maxY;
    
    public AxisAlignedBB(final BlockPos llllllllllllllIllIlllllIlIlllIlI, final BlockPos llllllllllllllIllIlllllIlIllllII) {
        this.minX = llllllllllllllIllIlllllIlIlllIlI.getX();
        this.minY = llllllllllllllIllIlllllIlIlllIlI.getY();
        this.minZ = llllllllllllllIllIlllllIlIlllIlI.getZ();
        this.maxX = llllllllllllllIllIlllllIlIllllII.getX();
        this.maxY = llllllllllllllIllIlllllIlIllllII.getY();
        this.maxZ = llllllllllllllIllIlllllIlIllllII.getZ();
    }
    
    static {
        __OBFID = "CL_00000607";
    }
    
    public double calculateZOffset(final AxisAlignedBB llllllllllllllIllIlllllIIIIlIlIl, double llllllllllllllIllIlllllIIIIIllll) {
        if (llllllllllllllIllIlllllIIIIlIlIl.maxX > this.minX && llllllllllllllIllIlllllIIIIlIlIl.minX < this.maxX && llllllllllllllIllIlllllIIIIlIlIl.maxY > this.minY && llllllllllllllIllIlllllIIIIlIlIl.minY < this.maxY) {
            if (llllllllllllllIllIlllllIIIIIllll > 0.0 && llllllllllllllIllIlllllIIIIlIlIl.maxZ <= this.minZ) {
                final double llllllllllllllIllIlllllIIIIlIIll = this.minZ - llllllllllllllIllIlllllIIIIlIlIl.maxZ;
                if (llllllllllllllIllIlllllIIIIlIIll < llllllllllllllIllIlllllIIIIIllll) {
                    llllllllllllllIllIlllllIIIIIllll = llllllllllllllIllIlllllIIIIlIIll;
                }
            }
            else if (llllllllllllllIllIlllllIIIIIllll < 0.0 && llllllllllllllIllIlllllIIIIlIlIl.minZ >= this.maxZ) {
                final double llllllllllllllIllIlllllIIIIlIIlI = this.maxZ - llllllllllllllIllIlllllIIIIlIlIl.minZ;
                if (llllllllllllllIllIlllllIIIIlIIlI > llllllllllllllIllIlllllIIIIIllll) {
                    llllllllllllllIllIlllllIIIIIllll = llllllllllllllIllIlllllIIIIlIIlI;
                }
            }
            return llllllllllllllIllIlllllIIIIIllll;
        }
        return llllllllllllllIllIlllllIIIIIllll;
    }
    
    public AxisAlignedBB(final double llllllllllllllIllIlllllIllIIlllI, final double llllllllllllllIllIlllllIllIIIllI, final double llllllllllllllIllIlllllIllIIllII, final double llllllllllllllIllIlllllIllIIlIll, final double llllllllllllllIllIlllllIllIIlIlI, final double llllllllllllllIllIlllllIllIIIIlI) {
        this.minX = Math.min(llllllllllllllIllIlllllIllIIlllI, llllllllllllllIllIlllllIllIIlIll);
        this.minY = Math.min(llllllllllllllIllIlllllIllIIIllI, llllllllllllllIllIlllllIllIIlIlI);
        this.minZ = Math.min(llllllllllllllIllIlllllIllIIllII, llllllllllllllIllIlllllIllIIIIlI);
        this.maxX = Math.max(llllllllllllllIllIlllllIllIIlllI, llllllllllllllIllIlllllIllIIlIll);
        this.maxY = Math.max(llllllllllllllIllIlllllIllIIIllI, llllllllllllllIllIlllllIllIIlIlI);
        this.maxZ = Math.max(llllllllllllllIllIlllllIllIIllII, llllllllllllllIllIlllllIllIIIIlI);
    }
    
    public AxisAlignedBB addCoord(final double llllllllllllllIllIlllllIlIlIllIl, final double llllllllllllllIllIlllllIlIlIIIIl, final double llllllllllllllIllIlllllIlIlIlIll) {
        double llllllllllllllIllIlllllIlIlIlIlI = this.minX;
        double llllllllllllllIllIlllllIlIlIlIIl = this.minY;
        double llllllllllllllIllIlllllIlIlIlIII = this.minZ;
        double llllllllllllllIllIlllllIlIlIIlll = this.maxX;
        double llllllllllllllIllIlllllIlIlIIllI = this.maxY;
        double llllllllllllllIllIlllllIlIlIIlIl = this.maxZ;
        if (llllllllllllllIllIlllllIlIlIllIl < 0.0) {
            llllllllllllllIllIlllllIlIlIlIlI += llllllllllllllIllIlllllIlIlIllIl;
        }
        else if (llllllllllllllIllIlllllIlIlIllIl > 0.0) {
            llllllllllllllIllIlllllIlIlIIlll += llllllllllllllIllIlllllIlIlIllIl;
        }
        if (llllllllllllllIllIlllllIlIlIIIIl < 0.0) {
            llllllllllllllIllIlllllIlIlIlIIl += llllllllllllllIllIlllllIlIlIIIIl;
        }
        else if (llllllllllllllIllIlllllIlIlIIIIl > 0.0) {
            llllllllllllllIllIlllllIlIlIIllI += llllllllllllllIllIlllllIlIlIIIIl;
        }
        if (llllllllllllllIllIlllllIlIlIlIll < 0.0) {
            llllllllllllllIllIlllllIlIlIlIII += llllllllllllllIllIlllllIlIlIlIll;
        }
        else if (llllllllllllllIllIlllllIlIlIlIll > 0.0) {
            llllllllllllllIllIlllllIlIlIIlIl += llllllllllllllIllIlllllIlIlIlIll;
        }
        return new AxisAlignedBB(llllllllllllllIllIlllllIlIlIlIlI, llllllllllllllIllIlllllIlIlIlIIl, llllllllllllllIllIlllllIlIlIlIII, llllllllllllllIllIlllllIlIlIIlll, llllllllllllllIllIlllllIlIlIIllI, llllllllllllllIllIlllllIlIlIIlIl);
    }
    
    public static AxisAlignedBB fromBounds(final double llllllllllllllIllIlllllIIlIllIII, final double llllllllllllllIllIlllllIIlIlIlll, final double llllllllllllllIllIlllllIIlIIlIII, final double llllllllllllllIllIlllllIIlIlIlIl, final double llllllllllllllIllIlllllIIlIIIlII, final double llllllllllllllIllIlllllIIlIIIIll) {
        final double llllllllllllllIllIlllllIIlIlIIlI = Math.min(llllllllllllllIllIlllllIIlIllIII, llllllllllllllIllIlllllIIlIlIlIl);
        final double llllllllllllllIllIlllllIIlIlIIIl = Math.min(llllllllllllllIllIlllllIIlIlIlll, llllllllllllllIllIlllllIIlIIIlII);
        final double llllllllllllllIllIlllllIIlIlIIII = Math.min(llllllllllllllIllIlllllIIlIIlIII, llllllllllllllIllIlllllIIlIIIIll);
        final double llllllllllllllIllIlllllIIlIIllll = Math.max(llllllllllllllIllIlllllIIlIllIII, llllllllllllllIllIlllllIIlIlIlIl);
        final double llllllllllllllIllIlllllIIlIIlllI = Math.max(llllllllllllllIllIlllllIIlIlIlll, llllllllllllllIllIlllllIIlIIIlII);
        final double llllllllllllllIllIlllllIIlIIllIl = Math.max(llllllllllllllIllIlllllIIlIIlIII, llllllllllllllIllIlllllIIlIIIIll);
        return new AxisAlignedBB(llllllllllllllIllIlllllIIlIlIIlI, llllllllllllllIllIlllllIIlIlIIIl, llllllllllllllIllIlllllIIlIlIIII, llllllllllllllIllIlllllIIlIIllll, llllllllllllllIllIlllllIIlIIlllI, llllllllllllllIllIlllllIIlIIllIl);
    }
    
    public double calculateXOffset(final AxisAlignedBB llllllllllllllIllIlllllIIIlIllll, double llllllllllllllIllIlllllIIIlIlIIl) {
        if (llllllllllllllIllIlllllIIIlIllll.maxY > this.minY && llllllllllllllIllIlllllIIIlIllll.minY < this.maxY && llllllllllllllIllIlllllIIIlIllll.maxZ > this.minZ && llllllllllllllIllIlllllIIIlIllll.minZ < this.maxZ) {
            if (llllllllllllllIllIlllllIIIlIlIIl > 0.0 && llllllllllllllIllIlllllIIIlIllll.maxX <= this.minX) {
                final double llllllllllllllIllIlllllIIIlIllIl = this.minX - llllllllllllllIllIlllllIIIlIllll.maxX;
                if (llllllllllllllIllIlllllIIIlIllIl < llllllllllllllIllIlllllIIIlIlIIl) {
                    llllllllllllllIllIlllllIIIlIlIIl = llllllllllllllIllIlllllIIIlIllIl;
                }
            }
            else if (llllllllllllllIllIlllllIIIlIlIIl < 0.0 && llllllllllllllIllIlllllIIIlIllll.minX >= this.maxX) {
                final double llllllllllllllIllIlllllIIIlIllII = this.maxX - llllllllllllllIllIlllllIIIlIllll.minX;
                if (llllllllllllllIllIlllllIIIlIllII > llllllllllllllIllIlllllIIIlIlIIl) {
                    llllllllllllllIllIlllllIIIlIlIIl = llllllllllllllIllIlllllIIIlIllII;
                }
            }
            return llllllllllllllIllIlllllIIIlIlIIl;
        }
        return llllllllllllllIllIlllllIIIlIlIIl;
    }
    
    private boolean isVecInYZ(final Vec3 llllllllllllllIllIllllIllIllIIll) {
        return llllllllllllllIllIllllIllIllIIll != null && (llllllllllllllIllIllllIllIllIIll.yCoord >= this.minY && llllllllllllllIllIllllIllIllIIll.yCoord <= this.maxY && llllllllllllllIllIllllIllIllIIll.zCoord >= this.minZ && llllllllllllllIllIllllIllIllIIll.zCoord <= this.maxZ);
    }
    
    public double getAverageEdgeLength() {
        final double llllllllllllllIllIllllIlllllllII = this.maxX - this.minX;
        final double llllllllllllllIllIllllIllllllIll = this.maxY - this.minY;
        final double llllllllllllllIllIllllIllllllIlI = this.maxZ - this.minZ;
        return (llllllllllllllIllIllllIlllllllII + llllllllllllllIllIllllIllllllIll + llllllllllllllIllIllllIllllllIlI) / 3.0;
    }
    
    public boolean intersectsWith(final AxisAlignedBB llllllllllllllIllIlllllIIIIIlIII) {
        return llllllllllllllIllIlllllIIIIIlIII.maxX > this.minX && llllllllllllllIllIlllllIIIIIlIII.minX < this.maxX && (llllllllllllllIllIlllllIIIIIlIII.maxY > this.minY && llllllllllllllIllIlllllIIIIIlIII.minY < this.maxY) && (llllllllllllllIllIlllllIIIIIlIII.maxZ > this.minZ && llllllllllllllIllIlllllIIIIIlIII.minZ < this.maxZ);
    }
    
    public AxisAlignedBB expand(final double llllllllllllllIllIlllllIlIIIllll, final double llllllllllllllIllIlllllIlIIIIIll, final double llllllllllllllIllIlllllIlIIIllIl) {
        final double llllllllllllllIllIlllllIlIIIllII = this.minX - llllllllllllllIllIlllllIlIIIllll;
        final double llllllllllllllIllIlllllIlIIIlIll = this.minY - llllllllllllllIllIlllllIlIIIIIll;
        final double llllllllllllllIllIlllllIlIIIlIlI = this.minZ - llllllllllllllIllIlllllIlIIIllIl;
        final double llllllllllllllIllIlllllIlIIIlIIl = this.maxX + llllllllllllllIllIlllllIlIIIllll;
        final double llllllllllllllIllIlllllIlIIIlIII = this.maxY + llllllllllllllIllIlllllIlIIIIIll;
        final double llllllllllllllIllIlllllIlIIIIlll = this.maxZ + llllllllllllllIllIlllllIlIIIllIl;
        return new AxisAlignedBB(llllllllllllllIllIlllllIlIIIllII, llllllllllllllIllIlllllIlIIIlIll, llllllllllllllIllIlllllIlIIIlIlI, llllllllllllllIllIlllllIlIIIlIIl, llllllllllllllIllIlllllIlIIIlIII, llllllllllllllIllIlllllIlIIIIlll);
    }
    
    private boolean isVecInXY(final Vec3 llllllllllllllIllIllllIllIlIIlll) {
        return llllllllllllllIllIllllIllIlIIlll != null && (llllllllllllllIllIllllIllIlIIlll.xCoord >= this.minX && llllllllllllllIllIllllIllIlIIlll.xCoord <= this.maxX && llllllllllllllIllIllllIllIlIIlll.yCoord >= this.minY && llllllllllllllIllIllllIllIlIIlll.yCoord <= this.maxY);
    }
    
    public AxisAlignedBB contract(final double llllllllllllllIllIllllIllllIIIII, final double llllllllllllllIllIllllIlllIllllI, final double llllllllllllllIllIllllIlllIlllIl) {
        final double llllllllllllllIllIllllIllllIIlll = this.minX + llllllllllllllIllIllllIllllIIIII;
        final double llllllllllllllIllIllllIllllIIllI = this.minY + llllllllllllllIllIllllIlllIllllI;
        final double llllllllllllllIllIllllIllllIIlIl = this.minZ + llllllllllllllIllIllllIlllIlllIl;
        final double llllllllllllllIllIllllIllllIIlII = this.maxX - llllllllllllllIllIllllIllllIIIII;
        final double llllllllllllllIllIllllIllllIIIll = this.maxY - llllllllllllllIllIllllIlllIllllI;
        final double llllllllllllllIllIllllIllllIIIlI = this.maxZ - llllllllllllllIllIllllIlllIlllIl;
        return new AxisAlignedBB(llllllllllllllIllIllllIllllIIlll, llllllllllllllIllIllllIllllIIllI, llllllllllllllIllIllllIllllIIlIl, llllllllllllllIllIllllIllllIIlII, llllllllllllllIllIllllIllllIIIll, llllllllllllllIllIllllIllllIIIlI);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("box[").append(this.minX).append(", ").append(this.minY).append(", ").append(this.minZ).append(" -> ").append(this.maxX).append(", ").append(this.maxY).append(", ").append(this.maxZ).append("]"));
    }
    
    public AxisAlignedBB union(final AxisAlignedBB llllllllllllllIllIlllllIIlllIIll) {
        final double llllllllllllllIllIlllllIIlllIIlI = Math.min(this.minX, llllllllllllllIllIlllllIIlllIIll.minX);
        final double llllllllllllllIllIlllllIIlllIIIl = Math.min(this.minY, llllllllllllllIllIlllllIIlllIIll.minY);
        final double llllllllllllllIllIlllllIIlllIIII = Math.min(this.minZ, llllllllllllllIllIlllllIIlllIIll.minZ);
        final double llllllllllllllIllIlllllIIllIllll = Math.max(this.maxX, llllllllllllllIllIlllllIIlllIIll.maxX);
        final double llllllllllllllIllIlllllIIllIlllI = Math.max(this.maxY, llllllllllllllIllIlllllIIlllIIll.maxY);
        final double llllllllllllllIllIlllllIIllIllIl = Math.max(this.maxZ, llllllllllllllIllIlllllIIlllIIll.maxZ);
        return new AxisAlignedBB(llllllllllllllIllIlllllIIlllIIlI, llllllllllllllIllIlllllIIlllIIIl, llllllllllllllIllIlllllIIlllIIII, llllllllllllllIllIlllllIIllIllll, llllllllllllllIllIlllllIIllIlllI, llllllllllllllIllIlllllIIllIllIl);
    }
    
    public AxisAlignedBB offset(final double llllllllllllllIllIlllllIIIllIlll, final double llllllllllllllIllIlllllIIIlllIlI, final double llllllllllllllIllIlllllIIIllIlIl) {
        return new AxisAlignedBB(this.minX + llllllllllllllIllIlllllIIIllIlll, this.minY + llllllllllllllIllIlllllIIIlllIlI, this.minZ + llllllllllllllIllIlllllIIIllIlIl, this.maxX + llllllllllllllIllIlllllIIIllIlll, this.maxY + llllllllllllllIllIlllllIIIlllIlI, this.maxZ + llllllllllllllIllIlllllIIIllIlIl);
    }
    
    private boolean isVecInXZ(final Vec3 llllllllllllllIllIllllIllIlIllIl) {
        return llllllllllllllIllIllllIllIlIllIl != null && (llllllllllllllIllIllllIllIlIllIl.xCoord >= this.minX && llllllllllllllIllIllllIllIlIllIl.xCoord <= this.maxX && llllllllllllllIllIllllIllIlIllIl.zCoord >= this.minZ && llllllllllllllIllIllllIllIlIllIl.zCoord <= this.maxZ);
    }
    
    public boolean isVecInside(final Vec3 llllllllllllllIllIlllllIIIIIIIlI) {
        return llllllllllllllIllIlllllIIIIIIIlI.xCoord > this.minX && llllllllllllllIllIlllllIIIIIIIlI.xCoord < this.maxX && (llllllllllllllIllIlllllIIIIIIIlI.yCoord > this.minY && llllllllllllllIllIlllllIIIIIIIlI.yCoord < this.maxY) && (llllllllllllllIllIlllllIIIIIIIlI.zCoord > this.minZ && llllllllllllllIllIlllllIIIIIIIlI.zCoord < this.maxZ);
    }
    
    public double calculateYOffset(final AxisAlignedBB llllllllllllllIllIlllllIIIlIIIlI, double llllllllllllllIllIlllllIIIIlllII) {
        if (llllllllllllllIllIlllllIIIlIIIlI.maxX > this.minX && llllllllllllllIllIlllllIIIlIIIlI.minX < this.maxX && llllllllllllllIllIlllllIIIlIIIlI.maxZ > this.minZ && llllllllllllllIllIlllllIIIlIIIlI.minZ < this.maxZ) {
            if (llllllllllllllIllIlllllIIIIlllII > 0.0 && llllllllllllllIllIlllllIIIlIIIlI.maxY <= this.minY) {
                final double llllllllllllllIllIlllllIIIlIIIII = this.minY - llllllllllllllIllIlllllIIIlIIIlI.maxY;
                if (llllllllllllllIllIlllllIIIlIIIII < llllllllllllllIllIlllllIIIIlllII) {
                    llllllllllllllIllIlllllIIIIlllII = llllllllllllllIllIlllllIIIlIIIII;
                }
            }
            else if (llllllllllllllIllIlllllIIIIlllII < 0.0 && llllllllllllllIllIlllllIIIlIIIlI.minY >= this.maxY) {
                final double llllllllllllllIllIlllllIIIIlllll = this.maxY - llllllllllllllIllIlllllIIIlIIIlI.minY;
                if (llllllllllllllIllIlllllIIIIlllll > llllllllllllllIllIlllllIIIIlllII) {
                    llllllllllllllIllIlllllIIIIlllII = llllllllllllllIllIlllllIIIIlllll;
                }
            }
            return (double)llllllllllllllIllIlllllIIIIlllII;
        }
        return (double)llllllllllllllIllIlllllIIIIlllII;
    }
    
    public MovingObjectPosition calculateIntercept(final Vec3 llllllllllllllIllIllllIlllIIIIII, final Vec3 llllllllllllllIllIllllIlllIIlIlI) {
        Vec3 llllllllllllllIllIllllIlllIIlIIl = llllllllllllllIllIllllIlllIIIIII.getIntermediateWithXValue(llllllllllllllIllIllllIlllIIlIlI, this.minX);
        Vec3 llllllllllllllIllIllllIlllIIlIII = llllllllllllllIllIllllIlllIIIIII.getIntermediateWithXValue(llllllllllllllIllIllllIlllIIlIlI, this.maxX);
        Vec3 llllllllllllllIllIllllIlllIIIlll = llllllllllllllIllIllllIlllIIIIII.getIntermediateWithYValue(llllllllllllllIllIllllIlllIIlIlI, this.minY);
        Vec3 llllllllllllllIllIllllIlllIIIllI = llllllllllllllIllIllllIlllIIIIII.getIntermediateWithYValue(llllllllllllllIllIllllIlllIIlIlI, this.maxY);
        Vec3 llllllllllllllIllIllllIlllIIIlIl = llllllllllllllIllIllllIlllIIIIII.getIntermediateWithZValue(llllllllllllllIllIllllIlllIIlIlI, this.minZ);
        Vec3 llllllllllllllIllIllllIlllIIIlII = llllllllllllllIllIllllIlllIIIIII.getIntermediateWithZValue(llllllllllllllIllIllllIlllIIlIlI, this.maxZ);
        if (!this.isVecInYZ(llllllllllllllIllIllllIlllIIlIIl)) {
            llllllllllllllIllIllllIlllIIlIIl = null;
        }
        if (!this.isVecInYZ(llllllllllllllIllIllllIlllIIlIII)) {
            llllllllllllllIllIllllIlllIIlIII = null;
        }
        if (!this.isVecInXZ(llllllllllllllIllIllllIlllIIIlll)) {
            llllllllllllllIllIllllIlllIIIlll = null;
        }
        if (!this.isVecInXZ(llllllllllllllIllIllllIlllIIIllI)) {
            llllllllllllllIllIllllIlllIIIllI = null;
        }
        if (!this.isVecInXY(llllllllllllllIllIllllIlllIIIlIl)) {
            llllllllllllllIllIllllIlllIIIlIl = null;
        }
        if (!this.isVecInXY(llllllllllllllIllIllllIlllIIIlII)) {
            llllllllllllllIllIllllIlllIIIlII = null;
        }
        Vec3 llllllllllllllIllIllllIlllIIIIll = null;
        if (llllllllllllllIllIllllIlllIIlIIl != null) {
            llllllllllllllIllIllllIlllIIIIll = llllllllllllllIllIllllIlllIIlIIl;
        }
        if (llllllllllllllIllIllllIlllIIlIII != null && (llllllllllllllIllIllllIlllIIIIll == null || llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIlIII) < llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIIll))) {
            llllllllllllllIllIllllIlllIIIIll = llllllllllllllIllIllllIlllIIlIII;
        }
        if (llllllllllllllIllIllllIlllIIIlll != null && (llllllllllllllIllIllllIlllIIIIll == null || llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIlll) < llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIIll))) {
            llllllllllllllIllIllllIlllIIIIll = llllllllllllllIllIllllIlllIIIlll;
        }
        if (llllllllllllllIllIllllIlllIIIllI != null && (llllllllllllllIllIllllIlllIIIIll == null || llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIllI) < llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIIll))) {
            llllllllllllllIllIllllIlllIIIIll = llllllllllllllIllIllllIlllIIIllI;
        }
        if (llllllllllllllIllIllllIlllIIIlIl != null && (llllllllllllllIllIllllIlllIIIIll == null || llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIlIl) < llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIIll))) {
            llllllllllllllIllIllllIlllIIIIll = llllllllllllllIllIllllIlllIIIlIl;
        }
        if (llllllllllllllIllIllllIlllIIIlII != null && (llllllllllllllIllIllllIlllIIIIll == null || llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIlII) < llllllllllllllIllIllllIlllIIIIII.squareDistanceTo(llllllllllllllIllIllllIlllIIIIll))) {
            llllllllllllllIllIllllIlllIIIIll = llllllllllllllIllIllllIlllIIIlII;
        }
        if (llllllllllllllIllIllllIlllIIIIll == null) {
            return null;
        }
        EnumFacing llllllllllllllIllIllllIlllIIIIlI = null;
        if (llllllllllllllIllIllllIlllIIIIll == llllllllllllllIllIllllIlllIIlIIl) {
            llllllllllllllIllIllllIlllIIIIlI = EnumFacing.WEST;
        }
        else if (llllllllllllllIllIllllIlllIIIIll == llllllllllllllIllIllllIlllIIlIII) {
            llllllllllllllIllIllllIlllIIIIlI = EnumFacing.EAST;
        }
        else if (llllllllllllllIllIllllIlllIIIIll == llllllllllllllIllIllllIlllIIIlll) {
            llllllllllllllIllIllllIlllIIIIlI = EnumFacing.DOWN;
        }
        else if (llllllllllllllIllIllllIlllIIIIll == llllllllllllllIllIllllIlllIIIllI) {
            llllllllllllllIllIllllIlllIIIIlI = EnumFacing.UP;
        }
        else if (llllllllllllllIllIllllIlllIIIIll == llllllllllllllIllIllllIlllIIIlIl) {
            llllllllllllllIllIllllIlllIIIIlI = EnumFacing.NORTH;
        }
        else {
            llllllllllllllIllIllllIlllIIIIlI = EnumFacing.SOUTH;
        }
        return new MovingObjectPosition(llllllllllllllIllIllllIlllIIIIll, llllllllllllllIllIllllIlllIIIIlI);
    }
}
