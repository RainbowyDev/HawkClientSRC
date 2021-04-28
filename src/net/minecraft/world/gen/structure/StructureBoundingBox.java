package net.minecraft.world.gen.structure;

import net.minecraft.util.*;
import com.google.common.base.*;
import net.minecraft.nbt.*;

public class StructureBoundingBox
{
    public /* synthetic */ int minX;
    public /* synthetic */ int minZ;
    public /* synthetic */ int maxX;
    public /* synthetic */ int maxZ;
    public /* synthetic */ int maxY;
    public /* synthetic */ int minY;
    
    public StructureBoundingBox(final Vec3i llllllllllllllIIIlIlllIlIllIIllI, final Vec3i llllllllllllllIIIlIlllIlIllIIIlI) {
        this.minX = Math.min(llllllllllllllIIIlIlllIlIllIIllI.getX(), llllllllllllllIIIlIlllIlIllIIIlI.getX());
        this.minY = Math.min(llllllllllllllIIIlIlllIlIllIIllI.getY(), llllllllllllllIIIlIlllIlIllIIIlI.getY());
        this.minZ = Math.min(llllllllllllllIIIlIlllIlIllIIllI.getZ(), llllllllllllllIIIlIlllIlIllIIIlI.getZ());
        this.maxX = Math.max(llllllllllllllIIIlIlllIlIllIIllI.getX(), llllllllllllllIIIlIlllIlIllIIIlI.getX());
        this.maxY = Math.max(llllllllllllllIIIlIlllIlIllIIllI.getY(), llllllllllllllIIIlIlllIlIllIIIlI.getY());
        this.maxZ = Math.max(llllllllllllllIIIlIlllIlIllIIllI.getZ(), llllllllllllllIIIlIlllIlIllIIIlI.getZ());
    }
    
    public int getZSize() {
        return this.maxZ - this.minZ + 1;
    }
    
    public int getYSize() {
        return this.maxY - this.minY + 1;
    }
    
    public static StructureBoundingBox func_175897_a(final int llllllllllllllIIIlIlllIllIlIlIll, final int llllllllllllllIIIlIlllIllIlIlIlI, final int llllllllllllllIIIlIlllIllIlIlIIl, final int llllllllllllllIIIlIlllIllIIllllI, final int llllllllllllllIIIlIlllIllIIlllIl, final int llllllllllllllIIIlIlllIllIIlllII, final int llllllllllllllIIIlIlllIllIIllIll, final int llllllllllllllIIIlIlllIllIIllIlI, final int llllllllllllllIIIlIlllIllIlIIIll, final EnumFacing llllllllllllllIIIlIlllIllIlIIIlI) {
        switch (SwitchEnumFacing.field_175895_a[llllllllllllllIIIlIlllIllIlIIIlI.ordinal()]) {
            case 1: {
                return new StructureBoundingBox(llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIIllllI, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl - llllllllllllllIIIlIlllIllIlIIIll + 1 + llllllllllllllIIIlIlllIllIIlllII, llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIIllIll - 1 + llllllllllllllIIIlIlllIllIIllllI, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIllIlI - 1 + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIIlllII);
            }
            case 2: {
                return new StructureBoundingBox(llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIIllllI, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIIlllII, llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIIllIll - 1 + llllllllllllllIIIlIlllIllIIllllI, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIllIlI - 1 + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIlIIIll - 1 + llllllllllllllIIIlIlllIllIIlllII);
            }
            case 3: {
                return new StructureBoundingBox(llllllllllllllIIIlIlllIllIlIlIll - llllllllllllllIIIlIlllIllIlIIIll + 1 + llllllllllllllIIIlIlllIllIIlllII, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIIllllI, llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIIlllII, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIllIlI - 1 + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIIllIll - 1 + llllllllllllllIIIlIlllIllIIllllI);
            }
            case 4: {
                return new StructureBoundingBox(llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIIlllII, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIIllllI, llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIlIIIll - 1 + llllllllllllllIIIlIlllIllIIlllII, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIllIlI - 1 + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIIllIll - 1 + llllllllllllllIIIlIlllIllIIllllI);
            }
            default: {
                return new StructureBoundingBox(llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIIllllI, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIIlllII, llllllllllllllIIIlIlllIllIlIlIll + llllllllllllllIIIlIlllIllIIllIll - 1 + llllllllllllllIIIlIlllIllIIllllI, llllllllllllllIIIlIlllIllIlIlIlI + llllllllllllllIIIlIlllIllIIllIlI - 1 + llllllllllllllIIIlIlllIllIIlllIl, llllllllllllllIIIlIlllIllIlIlIIl + llllllllllllllIIIlIlllIllIlIIIll - 1 + llllllllllllllIIIlIlllIllIIlllII);
            }
        }
    }
    
    static {
        __OBFID = "CL_00000442";
    }
    
    public Vec3i func_175896_b() {
        return new Vec3i(this.maxX - this.minX, this.maxY - this.minY, this.maxZ - this.minZ);
    }
    
    public boolean func_175898_b(final Vec3i llllllllllllllIIIlIlllIlIIlIlIII) {
        return llllllllllllllIIIlIlllIlIIlIlIII.getX() >= this.minX && llllllllllllllIIIlIlllIlIIlIlIII.getX() <= this.maxX && llllllllllllllIIIlIlllIlIIlIlIII.getZ() >= this.minZ && llllllllllllllIIIlIlllIlIIlIlIII.getZ() <= this.maxZ && llllllllllllllIIIlIlllIlIIlIlIII.getY() >= this.minY && llllllllllllllIIIlIlllIlIIlIlIII.getY() <= this.maxY;
    }
    
    public StructureBoundingBox(final int llllllllllllllIIIlIlllIlIlIlIllI, final int llllllllllllllIIIlIlllIlIlIlIlIl, final int llllllllllllllIIIlIlllIlIlIlIlII, final int llllllllllllllIIIlIlllIlIlIlIIll) {
        this.minX = llllllllllllllIIIlIlllIlIlIlIllI;
        this.minZ = llllllllllllllIIIlIlllIlIlIlIlIl;
        this.maxX = llllllllllllllIIIlIlllIlIlIlIlII;
        this.maxZ = llllllllllllllIIIlIlllIlIlIlIIll;
        this.minY = 1;
        this.maxY = 512;
    }
    
    public boolean intersectsWith(final StructureBoundingBox llllllllllllllIIIlIlllIlIlIIllll) {
        return this.maxX >= llllllllllllllIIIlIlllIlIlIIllll.minX && this.minX <= llllllllllllllIIIlIlllIlIlIIllll.maxX && this.maxZ >= llllllllllllllIIIlIlllIlIlIIllll.minZ && this.minZ <= llllllllllllllIIIlIlllIlIlIIllll.maxZ && this.maxY >= llllllllllllllIIIlIlllIlIlIIllll.minY && this.minY <= llllllllllllllIIIlIlllIlIlIIllll.maxY;
    }
    
    public Vec3i func_180717_f() {
        return new BlockPos(this.minX + (this.maxX - this.minX + 1) / 2, this.minY + (this.maxY - this.minY + 1) / 2, this.minZ + (this.maxZ - this.minZ + 1) / 2);
    }
    
    public StructureBoundingBox() {
    }
    
    public StructureBoundingBox(final int llllllllllllllIIIlIlllIlIlllIIII, final int llllllllllllllIIIlIlllIlIlllIllI, final int llllllllllllllIIIlIlllIlIllIlllI, final int llllllllllllllIIIlIlllIlIllIllIl, final int llllllllllllllIIIlIlllIlIllIllII, final int llllllllllllllIIIlIlllIlIlllIIlI) {
        this.minX = llllllllllllllIIIlIlllIlIlllIIII;
        this.minY = llllllllllllllIIIlIlllIlIlllIllI;
        this.minZ = llllllllllllllIIIlIlllIlIllIlllI;
        this.maxX = llllllllllllllIIIlIlllIlIllIllIl;
        this.maxY = llllllllllllllIIIlIlllIlIllIllII;
        this.maxZ = llllllllllllllIIIlIlllIlIlllIIlI;
    }
    
    public void expandTo(final StructureBoundingBox llllllllllllllIIIlIlllIlIIlllIII) {
        this.minX = Math.min(this.minX, llllllllllllllIIIlIlllIlIIlllIII.minX);
        this.minY = Math.min(this.minY, llllllllllllllIIIlIlllIlIIlllIII.minY);
        this.minZ = Math.min(this.minZ, llllllllllllllIIIlIlllIlIIlllIII.minZ);
        this.maxX = Math.max(this.maxX, llllllllllllllIIIlIlllIlIIlllIII.maxX);
        this.maxY = Math.max(this.maxY, llllllllllllllIIIlIlllIlIIlllIII.maxY);
        this.maxZ = Math.max(this.maxZ, llllllllllllllIIIlIlllIlIIlllIII.maxZ);
    }
    
    public int getXSize() {
        return this.maxX - this.minX + 1;
    }
    
    public void offset(final int llllllllllllllIIIlIlllIlIIllIIlI, final int llllllllllllllIIIlIlllIlIIlIllIl, final int llllllllllllllIIIlIlllIlIIlIllII) {
        this.minX += llllllllllllllIIIlIlllIlIIllIIlI;
        this.minY += llllllllllllllIIIlIlllIlIIlIllIl;
        this.minZ += llllllllllllllIIIlIlllIlIIlIllII;
        this.maxX += llllllllllllllIIIlIlllIlIIllIIlI;
        this.maxY += llllllllllllllIIIlIlllIlIIlIllIl;
        this.maxZ += llllllllllllllIIIlIlllIlIIlIllII;
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper((Object)this).add("x0", this.minX).add("y0", this.minY).add("z0", this.minZ).add("x1", this.maxX).add("y1", this.maxY).add("z1", this.maxZ).toString();
    }
    
    public NBTTagIntArray func_151535_h() {
        return new NBTTagIntArray(new int[] { this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ });
    }
    
    public boolean intersectsWith(final int llllllllllllllIIIlIlllIlIlIIIllI, final int llllllllllllllIIIlIlllIlIlIIIlIl, final int llllllllllllllIIIlIlllIlIlIIIlII, final int llllllllllllllIIIlIlllIlIIlllllI) {
        return this.maxX >= llllllllllllllIIIlIlllIlIlIIIllI && this.minX <= llllllllllllllIIIlIlllIlIlIIIlII && this.maxZ >= llllllllllllllIIIlIlllIlIlIIIlIl && this.minZ <= llllllllllllllIIIlIlllIlIIlllllI;
    }
    
    public StructureBoundingBox(final int[] llllllllllllllIIIlIlllIllIllIllI) {
        if (llllllllllllllIIIlIlllIllIllIllI.length == 6) {
            this.minX = llllllllllllllIIIlIlllIllIllIllI[0];
            this.minY = llllllllllllllIIIlIlllIllIllIllI[1];
            this.minZ = llllllllllllllIIIlIlllIllIllIllI[2];
            this.maxX = llllllllllllllIIIlIlllIllIllIllI[3];
            this.maxY = llllllllllllllIIIlIlllIllIllIllI[4];
            this.maxZ = llllllllllllllIIIlIlllIllIllIllI[5];
        }
    }
    
    public static StructureBoundingBox func_175899_a(final int llllllllllllllIIIlIlllIllIIIlIll, final int llllllllllllllIIIlIlllIllIIIlIlI, final int llllllllllllllIIIlIlllIllIIIllll, final int llllllllllllllIIIlIlllIllIIIlllI, final int llllllllllllllIIIlIlllIllIIIIlll, final int llllllllllllllIIIlIlllIllIIIllII) {
        return new StructureBoundingBox(Math.min(llllllllllllllIIIlIlllIllIIIlIll, llllllllllllllIIIlIlllIllIIIlllI), Math.min(llllllllllllllIIIlIlllIllIIIlIlI, llllllllllllllIIIlIlllIllIIIIlll), Math.min(llllllllllllllIIIlIlllIllIIIllll, llllllllllllllIIIlIlllIllIIIllII), Math.max(llllllllllllllIIIlIlllIllIIIlIll, llllllllllllllIIIlIlllIllIIIlllI), Math.max(llllllllllllllIIIlIlllIllIIIlIlI, llllllllllllllIIIlIlllIllIIIIlll), Math.max(llllllllllllllIIIlIlllIllIIIllll, llllllllllllllIIIlIlllIllIIIllII));
    }
    
    public static StructureBoundingBox getNewBoundingBox() {
        return new StructureBoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    public StructureBoundingBox(final StructureBoundingBox llllllllllllllIIIlIlllIllIIIIIlI) {
        this.minX = llllllllllllllIIIlIlllIllIIIIIlI.minX;
        this.minY = llllllllllllllIIIlIlllIllIIIIIlI.minY;
        this.minZ = llllllllllllllIIIlIlllIllIIIIIlI.minZ;
        this.maxX = llllllllllllllIIIlIlllIllIIIIIlI.maxX;
        this.maxY = llllllllllllllIIIlIlllIllIIIIIlI.maxY;
        this.maxZ = llllllllllllllIIIlIlllIllIIIIIlI.maxZ;
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_175895_a;
        
        static {
            __OBFID = "CL_00001999";
            field_175895_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_175895_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_175895_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_175895_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_175895_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
