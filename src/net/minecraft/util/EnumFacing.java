package net.minecraft.util;

import com.google.common.base.*;
import java.util.*;
import com.google.common.collect.*;

public enum EnumFacing implements IStringSerializable
{
    SOUTH("SOUTH", 3, "SOUTH", 3, 3, 2, 0, "south", AxisDirection.POSITIVE, Axis.Z, new Vec3i(0, 0, 1));
    
    private static final /* synthetic */ EnumFacing[] HORIZONTALS;
    
    UP("UP", 1, "UP", 1, 1, 0, -1, "up", AxisDirection.POSITIVE, Axis.Y, new Vec3i(0, 1, 0));
    
    private final /* synthetic */ int horizontalIndex;
    
    NORTH("NORTH", 2, "NORTH", 2, 2, 3, 2, "north", AxisDirection.NEGATIVE, Axis.Z, new Vec3i(0, 0, -1));
    
    private static final /* synthetic */ Map NAME_LOOKUP;
    private final /* synthetic */ Axis axis;
    
    WEST("WEST", 4, "WEST", 4, 4, 5, 1, "west", AxisDirection.NEGATIVE, Axis.X, new Vec3i(-1, 0, 0));
    
    private final /* synthetic */ AxisDirection axisDirection;
    private final /* synthetic */ String name;
    
    EAST("EAST", 5, "EAST", 5, 5, 4, 3, "east", AxisDirection.POSITIVE, Axis.X, new Vec3i(1, 0, 0)), 
    DOWN("DOWN", 0, "DOWN", 0, 0, 1, -1, "down", AxisDirection.NEGATIVE, Axis.Y, new Vec3i(0, -1, 0));
    
    private final /* synthetic */ Vec3i directionVec;
    private final /* synthetic */ int index;
    public static final /* synthetic */ EnumFacing[] VALUES;
    private final /* synthetic */ int opposite;
    
    public Vec3i getDirectionVec() {
        return this.directionVec;
    }
    
    public int getFrontOffsetX() {
        return (this.axis == Axis.X) ? this.axisDirection.getOffset() : 0;
    }
    
    public int getFrontOffsetY() {
        return (this.axis == Axis.Y) ? this.axisDirection.getOffset() : 0;
    }
    
    public static EnumFacing getHorizontal(final int llllllllllllllIIIlIlIIlllIllIlll) {
        return EnumFacing.HORIZONTALS[MathHelper.abs_int(llllllllllllllIIIlIlIIlllIllIlll % EnumFacing.HORIZONTALS.length)];
    }
    
    public Axis getAxis() {
        return this.axis;
    }
    
    public AxisDirection getAxisDirection() {
        return this.axisDirection;
    }
    
    public int getHorizontalIndex() {
        return this.horizontalIndex;
    }
    
    private EnumFacing(final String llllllllllllllIIIlIlIIllllllIlIl, final int llllllllllllllIIIlIlIIllllllIlII, final String llllllllllllllIIIlIlIIllllllllll, final int llllllllllllllIIIlIlIIlllllllllI, final int llllllllllllllIIIlIlIIllllllllIl, final int llllllllllllllIIIlIlIIllllllIIlI, final int llllllllllllllIIIlIlIIlllllllIll, final String llllllllllllllIIIlIlIIlllllllIlI, final AxisDirection llllllllllllllIIIlIlIIlllllIllll, final Axis llllllllllllllIIIlIlIIlllllIlllI, final Vec3i llllllllllllllIIIlIlIIlllllIllIl) {
        this.index = llllllllllllllIIIlIlIIllllllllIl;
        this.horizontalIndex = llllllllllllllIIIlIlIIlllllllIll;
        this.opposite = llllllllllllllIIIlIlIIllllllIIlI;
        this.name = llllllllllllllIIIlIlIIlllllllIlI;
        this.axis = llllllllllllllIIIlIlIIlllllIlllI;
        this.axisDirection = llllllllllllllIIIlIlIIlllllIllll;
        this.directionVec = llllllllllllllIIIlIlIIlllllIllIl;
    }
    
    public int getFrontOffsetZ() {
        return (this.axis == Axis.Z) ? this.axisDirection.getOffset() : 0;
    }
    
    private EnumFacing rotateX() {
        switch (SwitchPlane.FACING_LOOKUP[this.ordinal()]) {
            case 1: {
                return EnumFacing.DOWN;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get X-rotated facing of ").append(this)));
            }
            case 3: {
                return EnumFacing.UP;
            }
            case 5: {
                return EnumFacing.NORTH;
            }
            case 6: {
                return EnumFacing.SOUTH;
            }
        }
    }
    
    public String getName2() {
        return this.name;
    }
    
    public static EnumFacing byName(final String llllllllllllllIIIlIlIIlllIlllllI) {
        return (llllllllllllllIIIlIlIIlllIlllllI == null) ? null : EnumFacing.NAME_LOOKUP.get(llllllllllllllIIIlIlIIlllIlllllI.toLowerCase());
    }
    
    public int getIndex() {
        return this.index;
    }
    
    static {
        __OBFID = "CL_00001201";
        VALUES = new EnumFacing[6];
        HORIZONTALS = new EnumFacing[4];
        NAME_LOOKUP = Maps.newHashMap();
        for (final EnumFacing llllllllllllllIIIlIlIlIIIIIIllll : values()) {
            EnumFacing.VALUES[llllllllllllllIIIlIlIlIIIIIIllll.index] = llllllllllllllIIIlIlIlIIIIIIllll;
            if (llllllllllllllIIIlIlIlIIIIIIllll.getAxis().isHorizontal()) {
                EnumFacing.HORIZONTALS[llllllllllllllIIIlIlIlIIIIIIllll.horizontalIndex] = llllllllllllllIIIlIlIlIIIIIIllll;
            }
            EnumFacing.NAME_LOOKUP.put(llllllllllllllIIIlIlIlIIIIIIllll.getName2().toLowerCase(), llllllllllllllIIIlIlIlIIIIIIllll);
        }
    }
    
    public EnumFacing rotateY() {
        switch (SwitchPlane.FACING_LOOKUP[this.ordinal()]) {
            case 1: {
                return EnumFacing.EAST;
            }
            case 2: {
                return EnumFacing.SOUTH;
            }
            case 3: {
                return EnumFacing.WEST;
            }
            case 4: {
                return EnumFacing.NORTH;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get Y-rotated facing of ").append(this)));
            }
        }
    }
    
    public static EnumFacing fromAngle(final double llllllllllllllIIIlIlIIlllIllIlIl) {
        return getHorizontal(MathHelper.floor_double(llllllllllllllIIIlIlIIlllIllIlIl / 90.0 + 0.5) & 0x3);
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    public EnumFacing rotateAround(final Axis llllllllllllllIIIlIlIIllllIlllIl) {
        switch (SwitchPlane.AXIS_LOOKUP[llllllllllllllIIIlIlIIllllIlllIl.ordinal()]) {
            case 1: {
                if (this != EnumFacing.WEST && this != EnumFacing.EAST) {
                    return this.rotateX();
                }
                return this;
            }
            case 2: {
                if (this != EnumFacing.UP && this != EnumFacing.DOWN) {
                    return this.rotateY();
                }
                return this;
            }
            case 3: {
                if (this != EnumFacing.NORTH && this != EnumFacing.SOUTH) {
                    return this.rotateZ();
                }
                return this;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get CW facing for axis ").append(llllllllllllllIIIlIlIIllllIlllIl)));
            }
        }
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    private EnumFacing rotateZ() {
        switch (SwitchPlane.FACING_LOOKUP[this.ordinal()]) {
            case 2: {
                return EnumFacing.DOWN;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get Z-rotated facing of ").append(this)));
            }
            case 4: {
                return EnumFacing.UP;
            }
            case 5: {
                return EnumFacing.EAST;
            }
            case 6: {
                return EnumFacing.WEST;
            }
        }
    }
    
    public static EnumFacing getFront(final int llllllllllllllIIIlIlIIlllIlllIll) {
        return EnumFacing.VALUES[MathHelper.abs_int(llllllllllllllIIIlIlIIlllIlllIll % EnumFacing.VALUES.length)];
    }
    
    public static EnumFacing func_176737_a(final float llllllllllllllIIIlIlIIlllIlIIllI, final float llllllllllllllIIIlIlIIlllIIllIll, final float llllllllllllllIIIlIlIIlllIIllIlI) {
        EnumFacing llllllllllllllIIIlIlIIlllIlIIIll = EnumFacing.NORTH;
        float llllllllllllllIIIlIlIIlllIlIIIlI = Float.MIN_VALUE;
        for (final EnumFacing llllllllllllllIIIlIlIIlllIIllllI : values()) {
            final float llllllllllllllIIIlIlIIlllIIlllIl = llllllllllllllIIIlIlIIlllIlIIllI * llllllllllllllIIIlIlIIlllIIllllI.directionVec.getX() + llllllllllllllIIIlIlIIlllIIllIll * llllllllllllllIIIlIlIIlllIIllllI.directionVec.getY() + llllllllllllllIIIlIlIIlllIIllIlI * llllllllllllllIIIlIlIIlllIIllllI.directionVec.getZ();
            if (llllllllllllllIIIlIlIIlllIIlllIl > llllllllllllllIIIlIlIIlllIlIIIlI) {
                llllllllllllllIIIlIlIIlllIlIIIlI = llllllllllllllIIIlIlIIlllIIlllIl;
                llllllllllllllIIIlIlIIlllIlIIIll = llllllllllllllIIIlIlIIlllIIllllI;
            }
        }
        return llllllllllllllIIIlIlIIlllIlIIIll;
    }
    
    public EnumFacing getOpposite() {
        return EnumFacing.VALUES[this.opposite];
    }
    
    public static EnumFacing random(final Random llllllllllllllIIIlIlIIlllIllIIIl) {
        return values()[llllllllllllllIIIlIlIIlllIllIIIl.nextInt(values().length)];
    }
    
    public EnumFacing rotateYCCW() {
        switch (SwitchPlane.FACING_LOOKUP[this.ordinal()]) {
            case 1: {
                return EnumFacing.WEST;
            }
            case 2: {
                return EnumFacing.NORTH;
            }
            case 3: {
                return EnumFacing.EAST;
            }
            case 4: {
                return EnumFacing.SOUTH;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get CCW facing of ").append(this)));
            }
        }
    }
    
    public enum Plane implements Predicate, Iterable
    {
        HORIZONTAL("HORIZONTAL", 0, "HORIZONTAL", 0, "HORIZONTAL", 0), 
        VERTICAL("VERTICAL", 1, "VERTICAL", 1, "VERTICAL", 1);
        
        public boolean apply(final EnumFacing llllllllllllllllIlIIlIllIllIllII) {
            return llllllllllllllllIlIIlIllIllIllII != null && llllllllllllllllIlIIlIllIllIllII.getAxis().getPlane() == this;
        }
        
        static {
            __OBFID = "CL_00002319";
        }
        
        public EnumFacing[] facings() {
            switch (SwitchPlane.PLANE_LOOKUP[this.ordinal()]) {
                case 1: {
                    return new EnumFacing[] { EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST };
                }
                case 2: {
                    return new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN };
                }
                default: {
                    throw new Error("Someone's been tampering with the universe!");
                }
            }
        }
        
        public boolean apply(final Object llllllllllllllllIlIIlIllIllIIIIl) {
            return this.apply((EnumFacing)llllllllllllllllIlIIlIllIllIIIIl);
        }
        
        public EnumFacing random(final Random llllllllllllllllIlIIlIllIlllIlII) {
            final EnumFacing[] llllllllllllllllIlIIlIllIlllIIll = this.facings();
            return llllllllllllllllIlIIlIllIlllIIll[llllllllllllllllIlIIlIllIlllIlII.nextInt(llllllllllllllllIlIIlIllIlllIIll.length)];
        }
        
        public Iterator iterator() {
            return (Iterator)Iterators.forArray((Object[])this.facings());
        }
        
        private Plane(final String llllllllllllllllIlIIlIllIlllllIl, final int llllllllllllllllIlIIlIllIlllllII, final String llllllllllllllllIlIIlIlllIIIIIlI, final int llllllllllllllllIlIIlIlllIIIIIIl, final String llllllllllllllllIlIIlIlllIIIIIII, final int llllllllllllllllIlIIlIllIlllllll) {
        }
    }
    
    static final class SwitchPlane
    {
        static final /* synthetic */ int[] AXIS_LOOKUP;
        static final /* synthetic */ int[] PLANE_LOOKUP;
        static final /* synthetic */ int[] FACING_LOOKUP;
        
        static {
            __OBFID = "CL_00002322";
            PLANE_LOOKUP = new int[Plane.values().length];
            try {
                SwitchPlane.PLANE_LOOKUP[Plane.HORIZONTAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchPlane.PLANE_LOOKUP[Plane.VERTICAL.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            FACING_LOOKUP = new int[EnumFacing.values().length];
            try {
                SwitchPlane.FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchPlane.FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchPlane.FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchPlane.FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchPlane.FACING_LOOKUP[EnumFacing.UP.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchPlane.FACING_LOOKUP[EnumFacing.DOWN.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            AXIS_LOOKUP = new int[Axis.values().length];
            try {
                SwitchPlane.AXIS_LOOKUP[Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchPlane.AXIS_LOOKUP[Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            try {
                SwitchPlane.AXIS_LOOKUP[Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
        }
    }
    
    public enum Axis implements Predicate, IStringSerializable
    {
        private static final /* synthetic */ Map NAME_LOOKUP;
        private final /* synthetic */ String name;
        private final /* synthetic */ Plane plane;
        
        X("X", 0, "X", 0, "X", 0, "x", Plane.HORIZONTAL), 
        Y("Y", 1, "Y", 1, "Y", 1, "y", Plane.VERTICAL), 
        Z("Z", 2, "Z", 2, "Z", 2, "z", Plane.HORIZONTAL);
        
        public static Axis byName(final String llllllllllllllllIIIlIlIlIlllIIII) {
            return (llllllllllllllllIIIlIlIlIlllIIII == null) ? null : Axis.NAME_LOOKUP.get(llllllllllllllllIIIlIlIlIlllIIII.toLowerCase());
        }
        
        private Axis(final String llllllllllllllllIIIlIlIlIlllIlIl, final int llllllllllllllllIIIlIlIlIlllIlII, final String llllllllllllllllIIIlIlIlIlllllII, final int llllllllllllllllIIIlIlIlIllllIll, final String llllllllllllllllIIIlIlIlIllllIlI, final int llllllllllllllllIIIlIlIlIllllIIl, final String llllllllllllllllIIIlIlIlIllllIII, final Plane llllllllllllllllIIIlIlIlIlllIlll) {
            this.name = llllllllllllllllIIIlIlIlIllllIII;
            this.plane = llllllllllllllllIIIlIlIlIlllIlll;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public String getName2() {
            return this.name;
        }
        
        public boolean isVertical() {
            return this.plane == Plane.VERTICAL;
        }
        
        public boolean isHorizontal() {
            return this.plane == Plane.HORIZONTAL;
        }
        
        public boolean apply(final Object llllllllllllllllIIIlIlIlIlIlIIll) {
            return this.apply((EnumFacing)llllllllllllllllIIIlIlIlIlIlIIll);
        }
        
        public String getName() {
            return this.name;
        }
        
        static {
            __OBFID = "CL_00002321";
            NAME_LOOKUP = Maps.newHashMap();
            $VALUES$ = new Axis[] { Axis.X, Axis.Y, Axis.Z };
            for (final Axis llllllllllllllllIIIlIlIllIIIIlll : values()) {
                Axis.NAME_LOOKUP.put(llllllllllllllllIIIlIlIllIIIIlll.getName2().toLowerCase(), llllllllllllllllIIIlIlIllIIIIlll);
            }
        }
        
        public Plane getPlane() {
            return this.plane;
        }
        
        public boolean apply(final EnumFacing llllllllllllllllIIIlIlIlIlIlllIl) {
            return llllllllllllllllIIIlIlIlIlIlllIl != null && llllllllllllllllIIIlIlIlIlIlllIl.getAxis() == this;
        }
    }
    
    public enum AxisDirection
    {
        NEGATIVE("NEGATIVE", 1, "NEGATIVE", 1, "NEGATIVE", 1, -1, "Towards negative"), 
        POSITIVE("POSITIVE", 0, "POSITIVE", 0, "POSITIVE", 0, 1, "Towards positive");
        
        private final /* synthetic */ int offset;
        private final /* synthetic */ String description;
        
        @Override
        public String toString() {
            return this.description;
        }
        
        static {
            __OBFID = "CL_00002320";
        }
        
        private AxisDirection(final String lllllllllllllllIlllIllIlllIIIlIl, final int lllllllllllllllIlllIllIlllIIIlII, final String lllllllllllllllIlllIllIlllIIllII, final int lllllllllllllllIlllIllIlllIIlIll, final String lllllllllllllllIlllIllIlllIIlIlI, final int lllllllllllllllIlllIllIlllIIlIIl, final int lllllllllllllllIlllIllIlllIIlIII, final String lllllllllllllllIlllIllIlllIIIlll) {
            this.offset = lllllllllllllllIlllIllIlllIIlIII;
            this.description = lllllllllllllllIlllIllIlllIIIlll;
        }
        
        public int getOffset() {
            return this.offset;
        }
    }
}
