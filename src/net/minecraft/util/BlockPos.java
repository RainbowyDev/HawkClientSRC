package net.minecraft.util;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;

public class BlockPos extends Vec3i
{
    private static final /* synthetic */ long field_177993_j;
    private static final /* synthetic */ int field_177989_d;
    private static final /* synthetic */ int field_177988_g;
    private static final /* synthetic */ int field_177987_f;
    private static final /* synthetic */ int field_177991_c;
    private static final /* synthetic */ long field_177995_i;
    private static final /* synthetic */ long field_177994_h;
    private static final /* synthetic */ int field_177990_b;
    
    public long toLong() {
        return ((long)this.getX() & BlockPos.field_177994_h) << BlockPos.field_177988_g | ((long)this.getY() & BlockPos.field_177995_i) << BlockPos.field_177987_f | ((long)this.getZ() & BlockPos.field_177993_j) << 0;
    }
    
    public BlockPos offsetSouth() {
        return this.offsetSouth(1);
    }
    
    public BlockPos add(final double llllllllllllllIlIIllIIlIllIIIllI, final double llllllllllllllIlIIllIIlIllIIIIIl, final double llllllllllllllIlIIllIIlIllIIIIII) {
        return new BlockPos(this.getX() + llllllllllllllIlIIllIIlIllIIIllI, this.getY() + llllllllllllllIlIIllIIlIllIIIIIl, this.getZ() + llllllllllllllIlIIllIIlIllIIIIII);
    }
    
    public BlockPos add(final int llllllllllllllIlIIllIIlIlIllIIll, final int llllllllllllllIlIIllIIlIlIllIIIl, final int llllllllllllllIlIIllIIlIlIlIllll) {
        return new BlockPos(this.getX() + llllllllllllllIlIIllIIlIlIllIIll, this.getY() + llllllllllllllIlIIllIIlIlIllIIIl, this.getZ() + llllllllllllllIlIIllIIlIlIlIllll);
    }
    
    public BlockPos offsetNorth(final int llllllllllllllIlIIllIIlIIlIlIIII) {
        return this.offset(EnumFacing.NORTH, llllllllllllllIlIIllIIlIIlIlIIII);
    }
    
    public BlockPos offsetNorth() {
        return this.offsetNorth(1);
    }
    
    public BlockPos(final Vec3i llllllllllllllIlIIllIIlIllIIlllI) {
        this(llllllllllllllIlIIllIIlIllIIlllI.getX(), llllllllllllllIlIIllIIlIllIIlllI.getY(), llllllllllllllIlIIllIIlIllIIlllI.getZ());
    }
    
    public static Iterable getAllInBox(final BlockPos llllllllllllllIlIIllIIIlllllllIl, final BlockPos llllllllllllllIlIIllIIIlllllllII) {
        final BlockPos llllllllllllllIlIIllIIIllllllIll = new BlockPos(Math.min(llllllllllllllIlIIllIIIlllllllIl.getX(), llllllllllllllIlIIllIIIlllllllII.getX()), Math.min(llllllllllllllIlIIllIIIlllllllIl.getY(), llllllllllllllIlIIllIIIlllllllII.getY()), Math.min(llllllllllllllIlIIllIIIlllllllIl.getZ(), llllllllllllllIlIIllIIIlllllllII.getZ()));
        final BlockPos llllllllllllllIlIIllIIIllllllIlI = new BlockPos(Math.max(llllllllllllllIlIIllIIIlllllllIl.getX(), llllllllllllllIlIIllIIIlllllllII.getX()), Math.max(llllllllllllllIlIIllIIIlllllllIl.getY(), llllllllllllllIlIIllIIIlllllllII.getY()), Math.max(llllllllllllllIlIIllIIIlllllllIl.getZ(), llllllllllllllIlIIllIIIlllllllII.getZ()));
        return new Iterable() {
            static {
                __OBFID = "CL_00002333";
            }
            
            @Override
            public Iterator iterator() {
                return (Iterator)new AbstractIterator() {
                    private /* synthetic */ BlockPos lastReturned = null;
                    
                    static {
                        __OBFID = "CL_00002332";
                    }
                    
                    protected Object computeNext() {
                        return this.computeNext0();
                    }
                    
                    protected BlockPos computeNext0() {
                        if (this.lastReturned == null) {
                            this.lastReturned = llllllllllllllIlIIllIIIllllllIll;
                            return this.lastReturned;
                        }
                        if (this.lastReturned.equals(llllllllllllllIlIIllIIIllllllIlI)) {
                            return (BlockPos)this.endOfData();
                        }
                        int llllllllllllllllllllIIllllllIlII = this.lastReturned.getX();
                        int llllllllllllllllllllIIllllllIIlI = this.lastReturned.getY();
                        int llllllllllllllllllllIIllllllIIIl = this.lastReturned.getZ();
                        if (llllllllllllllllllllIIllllllIlII < llllllllllllllIlIIllIIIllllllIlI.getX()) {
                            ++llllllllllllllllllllIIllllllIlII;
                        }
                        else if (llllllllllllllllllllIIllllllIIlI < llllllllllllllIlIIllIIIllllllIlI.getY()) {
                            llllllllllllllllllllIIllllllIlII = llllllllllllllIlIIllIIIllllllIll.getX();
                            ++llllllllllllllllllllIIllllllIIlI;
                        }
                        else if (llllllllllllllllllllIIllllllIIIl < llllllllllllllIlIIllIIIllllllIlI.getZ()) {
                            llllllllllllllllllllIIllllllIlII = llllllllllllllIlIIllIIIllllllIll.getX();
                            llllllllllllllllllllIIllllllIIlI = llllllllllllllIlIIllIIIllllllIll.getY();
                            ++llllllllllllllllllllIIllllllIIIl;
                        }
                        this.lastReturned = new BlockPos(llllllllllllllllllllIIllllllIlII, llllllllllllllllllllIIllllllIIlI, llllllllllllllllllllIIllllllIIIl);
                        return this.lastReturned;
                    }
                };
            }
        };
    }
    
    public BlockPos(final Entity llllllllllllllIlIIllIIlIlllIIIll) {
        this(llllllllllllllIlIIllIIlIlllIIIll.posX, llllllllllllllIlIIllIIlIlllIIIll.posY, llllllllllllllIlIIllIIlIlllIIIll.posZ);
    }
    
    public BlockPos(final double llllllllllllllIlIIllIIlIllllIIII, final double llllllllllllllIlIIllIIlIlllIllll, final double llllllllllllllIlIIllIIlIlllIlllI) {
        super(llllllllllllllIlIIllIIlIllllIIII, llllllllllllllIlIIllIIlIlllIllll, llllllllllllllIlIIllIIlIlllIlllI);
    }
    
    public BlockPos crossProductBP(final Vec3i llllllllllllllIlIIllIIlIIIIlIIll) {
        return new BlockPos(this.getY() * llllllllllllllIlIIllIIlIIIIlIIll.getZ() - this.getZ() * llllllllllllllIlIIllIIlIIIIlIIll.getY(), this.getZ() * llllllllllllllIlIIllIIlIIIIlIIll.getX() - this.getX() * llllllllllllllIlIIllIIlIIIIlIIll.getZ(), this.getX() * llllllllllllllIlIIllIIlIIIIlIIll.getY() - this.getY() * llllllllllllllIlIIllIIlIIIIlIIll.getX());
    }
    
    public BlockPos offsetDown() {
        return this.offsetDown(1);
    }
    
    public BlockPos offset(final EnumFacing llllllllllllllIlIIllIIlIIIlIIIII) {
        return this.offset(llllllllllllllIlIIllIIlIIIlIIIII, 1);
    }
    
    public BlockPos offsetWest(final int llllllllllllllIlIIllIIlIIIllIIIl) {
        return this.offset(EnumFacing.WEST, llllllllllllllIlIIllIIlIIIllIIIl);
    }
    
    public BlockPos multiply(final int llllllllllllllIlIIllIIlIlIIIlIlI) {
        return new BlockPos(this.getX() * llllllllllllllIlIIllIIlIlIIIlIlI, this.getY() * llllllllllllllIlIIllIIlIlIIIlIlI, this.getZ() * llllllllllllllIlIIllIIlIlIIIlIlI);
    }
    
    public BlockPos offsetDown(final int llllllllllllllIlIIllIIlIIlIllllI) {
        return this.offset(EnumFacing.DOWN, llllllllllllllIlIIllIIlIIlIllllI);
    }
    
    public static BlockPos fromLong(final long llllllllllllllIlIIllIIlIIIIIlIIl) {
        final int llllllllllllllIlIIllIIlIIIIIlIII = (int)(llllllllllllllIlIIllIIlIIIIIlIIl << 64 - BlockPos.field_177988_g - BlockPos.field_177990_b >> 64 - BlockPos.field_177990_b);
        final int llllllllllllllIlIIllIIlIIIIIIlll = (int)(llllllllllllllIlIIllIIlIIIIIlIIl << 64 - BlockPos.field_177987_f - BlockPos.field_177989_d >> 64 - BlockPos.field_177989_d);
        final int llllllllllllllIlIIllIIlIIIIIIllI = (int)(llllllllllllllIlIIllIIlIIIIIlIIl << 64 - BlockPos.field_177991_c >> 64 - BlockPos.field_177991_c);
        return new BlockPos(llllllllllllllIlIIllIIlIIIIIlIII, llllllllllllllIlIIllIIlIIIIIIlll, llllllllllllllIlIIllIIlIIIIIIllI);
    }
    
    static {
        __OBFID = "CL_00002334";
        ORIGIN = new BlockPos(0, 0, 0);
        field_177990_b = 1 + MathHelper.calculateLogBaseTwo(MathHelper.roundUpToPowerOfTwo(30000000));
        field_177991_c = BlockPos.field_177990_b;
        field_177989_d = 64 - BlockPos.field_177990_b - BlockPos.field_177991_c;
        field_177987_f = 0 + BlockPos.field_177991_c;
        field_177988_g = BlockPos.field_177987_f + BlockPos.field_177989_d;
        field_177994_h = (1L << BlockPos.field_177990_b) - 1L;
        field_177995_i = (1L << BlockPos.field_177989_d) - 1L;
        field_177993_j = (1L << BlockPos.field_177991_c) - 1L;
    }
    
    public BlockPos(final int llllllllllllllIlIIllIIllIIIIlIlI, final int llllllllllllllIlIIllIIllIIIIlIII, final int llllllllllllllIlIIllIIllIIIIlllI) {
        super(llllllllllllllIlIIllIIllIIIIlIlI, llllllllllllllIlIIllIIllIIIIlIII, llllllllllllllIlIIllIIllIIIIlllI);
    }
    
    public BlockPos offset(final EnumFacing llllllllllllllIlIIllIIlIIIIllIll, final int llllllllllllllIlIIllIIlIIIIllIlI) {
        return new BlockPos(this.getX() + llllllllllllllIlIIllIIlIIIIllIll.getFrontOffsetX() * llllllllllllllIlIIllIIlIIIIllIlI, this.getY() + llllllllllllllIlIIllIIlIIIIllIll.getFrontOffsetY() * llllllllllllllIlIIllIIlIIIIllIlI, this.getZ() + llllllllllllllIlIIllIIlIIIIllIll.getFrontOffsetZ() * llllllllllllllIlIIllIIlIIIIllIlI);
    }
    
    @Override
    public Vec3i crossProduct(final Vec3i llllllllllllllIlIIllIIIllllIIllI) {
        return this.crossProductBP(llllllllllllllIlIIllIIIllllIIllI);
    }
    
    public BlockPos offsetUp() {
        return this.offsetUp(1);
    }
    
    public BlockPos offsetSouth(final int llllllllllllllIlIIllIIlIIlIIIIlI) {
        return this.offset(EnumFacing.SOUTH, llllllllllllllIlIIllIIlIIlIIIIlI);
    }
    
    public BlockPos add(final Vec3i llllllllllllllIlIIllIIlIlIIlIlll) {
        return new BlockPos(this.getX() + llllllllllllllIlIIllIIlIlIIlIlll.getX(), this.getY() + llllllllllllllIlIIllIIlIlIIlIlll.getY(), this.getZ() + llllllllllllllIlIIllIIlIlIIlIlll.getZ());
    }
    
    public BlockPos offsetEast() {
        return this.offsetEast(1);
    }
    
    public BlockPos offsetWest() {
        return this.offsetWest(1);
    }
    
    public BlockPos offsetUp(final int llllllllllllllIlIIllIIlIIlllIlll) {
        return this.offset(EnumFacing.UP, llllllllllllllIlIIllIIlIIlllIlll);
    }
    
    public static Iterable getAllInBoxMutable(final BlockPos llllllllllllllIlIIllIIIllllIllIl, final BlockPos llllllllllllllIlIIllIIIllllIllII) {
        final BlockPos llllllllllllllIlIIllIIIllllIllll = new BlockPos(Math.min(llllllllllllllIlIIllIIIllllIllIl.getX(), llllllllllllllIlIIllIIIllllIllII.getX()), Math.min(llllllllllllllIlIIllIIIllllIllIl.getY(), llllllllllllllIlIIllIIIllllIllII.getY()), Math.min(llllllllllllllIlIIllIIIllllIllIl.getZ(), llllllllllllllIlIIllIIIllllIllII.getZ()));
        final BlockPos llllllllllllllIlIIllIIIllllIlllI = new BlockPos(Math.max(llllllllllllllIlIIllIIIllllIllIl.getX(), llllllllllllllIlIIllIIIllllIllII.getX()), Math.max(llllllllllllllIlIIllIIIllllIllIl.getY(), llllllllllllllIlIIllIIIllllIllII.getY()), Math.max(llllllllllllllIlIIllIIIllllIllIl.getZ(), llllllllllllllIlIIllIIIllllIllII.getZ()));
        return new Iterable() {
            @Override
            public Iterator iterator() {
                return (Iterator)new AbstractIterator() {
                    private /* synthetic */ MutableBlockPos theBlockPos = null;
                    
                    protected Object computeNext() {
                        return this.computeNext0();
                    }
                    
                    protected MutableBlockPos computeNext0() {
                        if (this.theBlockPos == null) {
                            this.theBlockPos = new MutableBlockPos(llllllllllllllIlIIllIIIllllIllll.getX(), llllllllllllllIlIIllIIIllllIllll.getY(), llllllllllllllIlIIllIIIllllIllll.getZ(), null);
                            return this.theBlockPos;
                        }
                        if (this.theBlockPos.equals(llllllllllllllIlIIllIIIllllIlllI)) {
                            return (MutableBlockPos)this.endOfData();
                        }
                        int llllllllllllllllIIIIIlIllIIIllll = this.theBlockPos.getX();
                        int llllllllllllllllIIIIIlIllIIIlllI = this.theBlockPos.getY();
                        int llllllllllllllllIIIIIlIllIIIllIl = this.theBlockPos.getZ();
                        if (llllllllllllllllIIIIIlIllIIIllll < llllllllllllllIlIIllIIIllllIlllI.getX()) {
                            ++llllllllllllllllIIIIIlIllIIIllll;
                        }
                        else if (llllllllllllllllIIIIIlIllIIIlllI < llllllllllllllIlIIllIIIllllIlllI.getY()) {
                            llllllllllllllllIIIIIlIllIIIllll = llllllllllllllIlIIllIIIllllIllll.getX();
                            ++llllllllllllllllIIIIIlIllIIIlllI;
                        }
                        else if (llllllllllllllllIIIIIlIllIIIllIl < llllllllllllllIlIIllIIIllllIlllI.getZ()) {
                            llllllllllllllllIIIIIlIllIIIllll = llllllllllllllIlIIllIIIllllIllll.getX();
                            llllllllllllllllIIIIIlIllIIIlllI = llllllllllllllIlIIllIIIllllIllll.getY();
                            ++llllllllllllllllIIIIIlIllIIIllIl;
                        }
                        this.theBlockPos.x = llllllllllllllllIIIIIlIllIIIllll;
                        this.theBlockPos.y = llllllllllllllllIIIIIlIllIIIlllI;
                        this.theBlockPos.z = llllllllllllllllIIIIIlIllIIIllIl;
                        return this.theBlockPos;
                    }
                    
                    static {
                        __OBFID = "CL_00002330";
                    }
                };
            }
            
            static {
                __OBFID = "CL_00002331";
            }
        };
    }
    
    public BlockPos(final Vec3 llllllllllllllIlIIllIIlIllIllIlI) {
        this(llllllllllllllIlIIllIIlIllIllIlI.xCoord, llllllllllllllIlIIllIIlIllIllIlI.yCoord, llllllllllllllIlIIllIIlIllIllIlI.zCoord);
    }
    
    public BlockPos offsetEast(final int llllllllllllllIlIIllIIlIIIlIIllI) {
        return this.offset(EnumFacing.EAST, llllllllllllllIlIIllIIlIIIlIIllI);
    }
    
    public BlockPos subtract(final Vec3i llllllllllllllIlIIllIIlIlIIIlllI) {
        return new BlockPos(this.getX() - llllllllllllllIlIIllIIlIlIIIlllI.getX(), this.getY() - llllllllllllllIlIIllIIlIlIIIlllI.getY(), this.getZ() - llllllllllllllIlIIllIIlIlIIIlllI.getZ());
    }
    
    public static final class MutableBlockPos extends BlockPos
    {
        public /* synthetic */ int z;
        public /* synthetic */ int y;
        public /* synthetic */ int x;
        
        @Override
        public int getX() {
            return this.x;
        }
        
        private MutableBlockPos(final int llllllllllllllIlIIlIIlIllllIIIlI, final int llllllllllllllIlIIlIIlIlllIlllIl, final int llllllllllllllIlIIlIIlIlllIlllII) {
            super(0, 0, 0);
            this.x = llllllllllllllIlIIlIIlIllllIIIlI;
            this.y = llllllllllllllIlIIlIIlIlllIlllIl;
            this.z = llllllllllllllIlIIlIIlIlllIlllII;
        }
        
        @Override
        public int getZ() {
            return this.z;
        }
        
        @Override
        public int getY() {
            return this.y;
        }
        
        static {
            __OBFID = "CL_00002329";
        }
        
        MutableBlockPos(final int llllllllllllllIlIIlIIlIlllIIIIlI, final int llllllllllllllIlIIlIIlIlllIIIllI, final int llllllllllllllIlIIlIIlIlllIIIlIl, final Object llllllllllllllIlIIlIIlIlllIIIlII) {
            this(llllllllllllllIlIIlIIlIlllIIIIlI, llllllllllllllIlIIlIIlIlllIIIllI, llllllllllllllIlIIlIIlIlllIIIlIl);
        }
        
        @Override
        public Vec3i crossProduct(final Vec3i llllllllllllllIlIIlIIlIlllIIllll) {
            return super.crossProductBP(llllllllllllllIlIIlIIlIlllIIllll);
        }
    }
}
