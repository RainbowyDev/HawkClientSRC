package optifine;

import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;

public class BlockPosM extends BlockPos
{
    private /* synthetic */ BlockPosM[] facings;
    private /* synthetic */ int my;
    private /* synthetic */ int mx;
    private /* synthetic */ int mz;
    private /* synthetic */ boolean needsUpdate;
    private /* synthetic */ int level;
    
    @Override
    public int getX() {
        return this.mx;
    }
    
    @Override
    public BlockPos offset(final EnumFacing llllllllllllllllIlIIlllllIllIllI, final int llllllllllllllllIlIIlllllIllIlIl) {
        return (llllllllllllllllIlIIlllllIllIlIl == 1) ? this.offset(llllllllllllllllIlIIlllllIllIllI) : super.offset(llllllllllllllllIlIIlllllIllIllI, llllllllllllllllIlIIlllllIllIlIl);
    }
    
    public void setXyz(final double llllllllllllllllIlIIllllllIlIlIl, final double llllllllllllllllIlIIllllllIllIII, final double llllllllllllllllIlIIllllllIlIlll) {
        this.setXyz(MathHelper.floor_double(llllllllllllllllIlIIllllllIlIlIl), MathHelper.floor_double(llllllllllllllllIlIIllllllIllIII), MathHelper.floor_double(llllllllllllllllIlIIllllllIlIlll));
    }
    
    @Override
    public BlockPos offset(final EnumFacing llllllllllllllllIlIIllllllIIIIll) {
        if (this.level <= 0) {
            return super.offset(llllllllllllllllIlIIllllllIIIIll, 1);
        }
        if (this.facings == null) {
            this.facings = new BlockPosM[EnumFacing.VALUES.length];
        }
        if (this.needsUpdate) {
            this.update();
        }
        final int llllllllllllllllIlIIllllllIIlIIl = llllllllllllllllIlIIllllllIIIIll.getIndex();
        BlockPosM llllllllllllllllIlIIllllllIIlIII = this.facings[llllllllllllllllIlIIllllllIIlIIl];
        if (llllllllllllllllIlIIllllllIIlIII == null) {
            final int llllllllllllllllIlIIllllllIIIlll = this.mx + llllllllllllllllIlIIllllllIIIIll.getFrontOffsetX();
            final int llllllllllllllllIlIIllllllIIIllI = this.my + llllllllllllllllIlIIllllllIIIIll.getFrontOffsetY();
            final int llllllllllllllllIlIIllllllIIIlIl = this.mz + llllllllllllllllIlIIllllllIIIIll.getFrontOffsetZ();
            llllllllllllllllIlIIllllllIIlIII = new BlockPosM(llllllllllllllllIlIIllllllIIIlll, llllllllllllllllIlIIllllllIIIllI, llllllllllllllllIlIIllllllIIIlIl, this.level - 1);
            this.facings[llllllllllllllllIlIIllllllIIlIIl] = llllllllllllllllIlIIllllllIIlIII;
        }
        return llllllllllllllllIlIIllllllIIlIII;
    }
    
    public BlockPos getImmutable() {
        return new BlockPos(this.getX(), this.getY(), this.getZ());
    }
    
    @Override
    public int getY() {
        return this.my;
    }
    
    public BlockPosM(final double llllllllllllllllIlIlIIIIIIIIlIIl, final double llllllllllllllllIlIlIIIIIIIIIlII, final double llllllllllllllllIlIlIIIIIIIIIIll) {
        this(MathHelper.floor_double(llllllllllllllllIlIlIIIIIIIIlIIl), MathHelper.floor_double(llllllllllllllllIlIlIIIIIIIIIlII), MathHelper.floor_double(llllllllllllllllIlIlIIIIIIIIIIll));
    }
    
    private void update() {
        for (int llllllllllllllllIlIIlllllIlIllII = 0; llllllllllllllllIlIIlllllIlIllII < 6; ++llllllllllllllllIlIIlllllIlIllII) {
            final BlockPosM llllllllllllllllIlIIlllllIlIlIll = this.facings[llllllllllllllllIlIIlllllIlIllII];
            if (llllllllllllllllIlIIlllllIlIlIll != null) {
                final EnumFacing llllllllllllllllIlIIlllllIlIlIlI = EnumFacing.VALUES[llllllllllllllllIlIIlllllIlIllII];
                final int llllllllllllllllIlIIlllllIlIlIIl = this.mx + llllllllllllllllIlIIlllllIlIlIlI.getFrontOffsetX();
                final int llllllllllllllllIlIIlllllIlIlIII = this.my + llllllllllllllllIlIIlllllIlIlIlI.getFrontOffsetY();
                final int llllllllllllllllIlIIlllllIlIIlll = this.mz + llllllllllllllllIlIIlllllIlIlIlI.getFrontOffsetZ();
                llllllllllllllllIlIIlllllIlIlIll.setXyz(llllllllllllllllIlIIlllllIlIlIIl, llllllllllllllllIlIIlllllIlIlIII, llllllllllllllllIlIIlllllIlIIlll);
            }
        }
        this.needsUpdate = false;
    }
    
    public BlockPosM(final int llllllllllllllllIlIIllllllllllII, final int llllllllllllllllIlIIllllllllIllI, final int llllllllllllllllIlIIllllllllIlIl, final int llllllllllllllllIlIIllllllllIlII) {
        super(0, 0, 0);
        this.mx = llllllllllllllllIlIIllllllllllII;
        this.my = llllllllllllllllIlIIllllllllIllI;
        this.mz = llllllllllllllllIlIIllllllllIlIl;
        this.level = llllllllllllllllIlIIllllllllIlII;
    }
    
    public BlockPosM(final int llllllllllllllllIlIlIIIIIIIlIIIl, final int llllllllllllllllIlIlIIIIIIIlIlII, final int llllllllllllllllIlIlIIIIIIIIllll) {
        this(llllllllllllllllIlIlIIIIIIIlIIIl, llllllllllllllllIlIlIIIIIIIlIlII, llllllllllllllllIlIlIIIIIIIIllll, 0);
    }
    
    public void setXyz(final int llllllllllllllllIlIIlllllllIIIIl, final int llllllllllllllllIlIIlllllllIIIII, final int llllllllllllllllIlIIllllllIlllll) {
        this.mx = llllllllllllllllIlIIlllllllIIIIl;
        this.my = llllllllllllllllIlIIlllllllIIIII;
        this.mz = llllllllllllllllIlIIllllllIlllll;
        this.needsUpdate = true;
    }
    
    @Override
    public int getZ() {
        return this.mz;
    }
    
    public static Iterable getAllInBoxMutable(final BlockPos llllllllllllllllIlIIlllllIIllIll, final BlockPos llllllllllllllllIlIIlllllIIllIlI) {
        final BlockPos llllllllllllllllIlIIlllllIIllIIl = new BlockPos(Math.min(llllllllllllllllIlIIlllllIIllIll.getX(), llllllllllllllllIlIIlllllIIllIlI.getX()), Math.min(llllllllllllllllIlIIlllllIIllIll.getY(), llllllllllllllllIlIIlllllIIllIlI.getY()), Math.min(llllllllllllllllIlIIlllllIIllIll.getZ(), llllllllllllllllIlIIlllllIIllIlI.getZ()));
        final BlockPos llllllllllllllllIlIIlllllIIllIII = new BlockPos(Math.max(llllllllllllllllIlIIlllllIIllIll.getX(), llllllllllllllllIlIIlllllIIllIlI.getX()), Math.max(llllllllllllllllIlIIlllllIIllIll.getY(), llllllllllllllllIlIIlllllIIllIlI.getY()), Math.max(llllllllllllllllIlIIlllllIIllIll.getZ(), llllllllllllllllIlIIlllllIIllIlI.getZ()));
        return new Iterable() {
            @Override
            public Iterator iterator() {
                return (Iterator)new AbstractIterator() {
                    private /* synthetic */ BlockPosM theBlockPosM = null;
                    
                    protected Object computeNext() {
                        return this.computeNext0();
                    }
                    
                    protected BlockPosM computeNext0() {
                        if (this.theBlockPosM == null) {
                            this.theBlockPosM = new BlockPosM(llllllllllllllllIlIIlllllIIllIIl.getX(), llllllllllllllllIlIIlllllIIllIIl.getY(), llllllllllllllllIlIIlllllIIllIIl.getZ(), 3);
                            return this.theBlockPosM;
                        }
                        if (this.theBlockPosM.equals(llllllllllllllllIlIIlllllIIllIII)) {
                            return (BlockPosM)this.endOfData();
                        }
                        int llllllllllllllIIlIlIllIlllIIIIIl = this.theBlockPosM.getX();
                        int llllllllllllllIIlIlIllIlllIIIIII = this.theBlockPosM.getY();
                        int llllllllllllllIIlIlIllIllIllllll = this.theBlockPosM.getZ();
                        if (llllllllllllllIIlIlIllIlllIIIIIl < llllllllllllllllIlIIlllllIIllIII.getX()) {
                            ++llllllllllllllIIlIlIllIlllIIIIIl;
                        }
                        else if (llllllllllllllIIlIlIllIlllIIIIII < llllllllllllllllIlIIlllllIIllIII.getY()) {
                            llllllllllllllIIlIlIllIlllIIIIIl = llllllllllllllllIlIIlllllIIllIIl.getX();
                            ++llllllllllllllIIlIlIllIlllIIIIII;
                        }
                        else if (llllllllllllllIIlIlIllIllIllllll < llllllllllllllllIlIIlllllIIllIII.getZ()) {
                            llllllllllllllIIlIlIllIlllIIIIIl = llllllllllllllllIlIIlllllIIllIIl.getX();
                            llllllllllllllIIlIlIllIlllIIIIII = llllllllllllllllIlIIlllllIIllIIl.getY();
                            ++llllllllllllllIIlIlIllIllIllllll;
                        }
                        this.theBlockPosM.setXyz(llllllllllllllIIlIlIllIlllIIIIIl, llllllllllllllIIlIlIllIlllIIIIII, llllllllllllllIIlIlIllIllIllllll);
                        return this.theBlockPosM;
                    }
                };
            }
        };
    }
}
