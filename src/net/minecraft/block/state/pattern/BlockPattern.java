package net.minecraft.block.state.pattern;

import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import com.google.common.cache.*;
import java.util.*;
import net.minecraft.block.state.*;

public class BlockPattern
{
    private final /* synthetic */ int field_177688_c;
    private final /* synthetic */ int field_177686_d;
    private final /* synthetic */ Predicate[][][] field_177689_a;
    private final /* synthetic */ int field_177687_b;
    
    public int func_177684_c() {
        return this.field_177686_d;
    }
    
    static {
        __OBFID = "CL_00002024";
    }
    
    public BlockPattern(final Predicate[][][] lllllllllllllllIIlllIIIIIIlIIlll) {
        this.field_177689_a = lllllllllllllllIIlllIIIIIIlIIlll;
        this.field_177687_b = lllllllllllllllIIlllIIIIIIlIIlll.length;
        if (this.field_177687_b > 0) {
            this.field_177688_c = lllllllllllllllIIlllIIIIIIlIIlll[0].length;
            if (this.field_177688_c > 0) {
                this.field_177686_d = lllllllllllllllIIlllIIIIIIlIIlll[0][0].length;
            }
            else {
                this.field_177686_d = 0;
            }
        }
        else {
            this.field_177688_c = 0;
            this.field_177686_d = 0;
        }
    }
    
    public int func_177685_b() {
        return this.field_177688_c;
    }
    
    private PatternHelper func_177682_a(final BlockPos lllllllllllllllIIlllIIIIIIIlIlIl, final EnumFacing lllllllllllllllIIlllIIIIIIIIllII, final EnumFacing lllllllllllllllIIlllIIIIIIIlIIll, final LoadingCache lllllllllllllllIIlllIIIIIIIlIIlI) {
        for (int lllllllllllllllIIlllIIIIIIIlIIIl = 0; lllllllllllllllIIlllIIIIIIIlIIIl < this.field_177686_d; ++lllllllllllllllIIlllIIIIIIIlIIIl) {
            for (int lllllllllllllllIIlllIIIIIIIlIIII = 0; lllllllllllllllIIlllIIIIIIIlIIII < this.field_177688_c; ++lllllllllllllllIIlllIIIIIIIlIIII) {
                for (int lllllllllllllllIIlllIIIIIIIIllll = 0; lllllllllllllllIIlllIIIIIIIIllll < this.field_177687_b; ++lllllllllllllllIIlllIIIIIIIIllll) {
                    if (!this.field_177689_a[lllllllllllllllIIlllIIIIIIIIllll][lllllllllllllllIIlllIIIIIIIlIIII][lllllllllllllllIIlllIIIIIIIlIIIl].apply(lllllllllllllllIIlllIIIIIIIlIIlI.getUnchecked((Object)func_177683_a(lllllllllllllllIIlllIIIIIIIlIlIl, lllllllllllllllIIlllIIIIIIIIllII, lllllllllllllllIIlllIIIIIIIlIIll, lllllllllllllllIIlllIIIIIIIlIIIl, lllllllllllllllIIlllIIIIIIIlIIII, lllllllllllllllIIlllIIIIIIIIllll)))) {
                        return null;
                    }
                }
            }
        }
        return new PatternHelper(lllllllllllllllIIlllIIIIIIIlIlIl, lllllllllllllllIIlllIIIIIIIIllII, lllllllllllllllIIlllIIIIIIIlIIll, lllllllllllllllIIlllIIIIIIIlIIlI);
    }
    
    protected static BlockPos func_177683_a(final BlockPos lllllllllllllllIIllIllllllIIIlII, final EnumFacing lllllllllllllllIIllIllllllIIllII, final EnumFacing lllllllllllllllIIllIllllllIIIIlI, final int lllllllllllllllIIllIllllllIIlIlI, final int lllllllllllllllIIllIllllllIIIIII, final int lllllllllllllllIIllIlllllIllllll) {
        if (lllllllllllllllIIllIllllllIIllII != lllllllllllllllIIllIllllllIIIIlI && lllllllllllllllIIllIllllllIIllII != lllllllllllllllIIllIllllllIIIIlI.getOpposite()) {
            final Vec3i lllllllllllllllIIllIllllllIIIlll = new Vec3i(lllllllllllllllIIllIllllllIIllII.getFrontOffsetX(), lllllllllllllllIIllIllllllIIllII.getFrontOffsetY(), lllllllllllllllIIllIllllllIIllII.getFrontOffsetZ());
            final Vec3i lllllllllllllllIIllIllllllIIIllI = new Vec3i(lllllllllllllllIIllIllllllIIIIlI.getFrontOffsetX(), lllllllllllllllIIllIllllllIIIIlI.getFrontOffsetY(), lllllllllllllllIIllIllllllIIIIlI.getFrontOffsetZ());
            final Vec3i lllllllllllllllIIllIllllllIIIlIl = lllllllllllllllIIllIllllllIIIlll.crossProduct(lllllllllllllllIIllIllllllIIIllI);
            return lllllllllllllllIIllIllllllIIIlII.add(lllllllllllllllIIllIllllllIIIllI.getX() * -lllllllllllllllIIllIllllllIIIIII + lllllllllllllllIIllIllllllIIIlIl.getX() * lllllllllllllllIIllIllllllIIlIlI + lllllllllllllllIIllIllllllIIIlll.getX() * lllllllllllllllIIllIlllllIllllll, lllllllllllllllIIllIllllllIIIllI.getY() * -lllllllllllllllIIllIllllllIIIIII + lllllllllllllllIIllIllllllIIIlIl.getY() * lllllllllllllllIIllIllllllIIlIlI + lllllllllllllllIIllIllllllIIIlll.getY() * lllllllllllllllIIllIlllllIllllll, lllllllllllllllIIllIllllllIIIllI.getZ() * -lllllllllllllllIIllIllllllIIIIII + lllllllllllllllIIllIllllllIIIlIl.getZ() * lllllllllllllllIIllIllllllIIlIlI + lllllllllllllllIIllIllllllIIIlll.getZ() * lllllllllllllllIIllIlllllIllllll);
        }
        throw new IllegalArgumentException("Invalid forwards & up combination");
    }
    
    public PatternHelper func_177681_a(final World lllllllllllllllIIllIlllllllIIlIl, final BlockPos lllllllllllllllIIllIlllllllIIlII) {
        final LoadingCache lllllllllllllllIIllIllllllllIIll = CacheBuilder.newBuilder().build((com.google.common.cache.CacheLoader)new CacheLoader(lllllllllllllllIIllIlllllllIIlIl));
        final int lllllllllllllllIIllIllllllllIIlI = Math.max(Math.max(this.field_177686_d, this.field_177688_c), this.field_177687_b);
        for (final BlockPos lllllllllllllllIIllIllllllllIIII : BlockPos.getAllInBox(lllllllllllllllIIllIlllllllIIlII, lllllllllllllllIIllIlllllllIIlII.add(lllllllllllllllIIllIllllllllIIlI - 1, lllllllllllllllIIllIllllllllIIlI - 1, lllllllllllllllIIllIllllllllIIlI - 1))) {
            for (final EnumFacing lllllllllllllllIIllIlllllllIllII : EnumFacing.values()) {
                for (final EnumFacing lllllllllllllllIIllIlllllllIlIII : EnumFacing.values()) {
                    if (lllllllllllllllIIllIlllllllIlIII != lllllllllllllllIIllIlllllllIllII && lllllllllllllllIIllIlllllllIlIII != lllllllllllllllIIllIlllllllIllII.getOpposite()) {
                        final PatternHelper lllllllllllllllIIllIlllllllIIlll = this.func_177682_a(lllllllllllllllIIllIllllllllIIII, lllllllllllllllIIllIlllllllIllII, lllllllllllllllIIllIlllllllIlIII, lllllllllllllllIIllIllllllllIIll);
                        if (lllllllllllllllIIllIlllllllIIlll != null) {
                            return lllllllllllllllIIllIlllllllIIlll;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static class PatternHelper
    {
        private final /* synthetic */ EnumFacing field_177672_b;
        private final /* synthetic */ LoadingCache field_177671_d;
        private final /* synthetic */ EnumFacing field_177673_c;
        private final /* synthetic */ BlockPos field_177674_a;
        
        public EnumFacing func_177668_c() {
            return this.field_177673_c;
        }
        
        static {
            __OBFID = "CL_00002022";
        }
        
        public BlockWorldState func_177670_a(final int llllllllllllllllIllIIlIllIIlllll, final int llllllllllllllllIllIIlIllIIllllI, final int llllllllllllllllIllIIlIllIIllIIl) {
            return (BlockWorldState)this.field_177671_d.getUnchecked((Object)BlockPattern.func_177683_a(this.field_177674_a, this.func_177669_b(), this.func_177668_c(), llllllllllllllllIllIIlIllIIlllll, llllllllllllllllIllIIlIllIIllllI, llllllllllllllllIllIIlIllIIllIIl));
        }
        
        public EnumFacing func_177669_b() {
            return this.field_177672_b;
        }
        
        public PatternHelper(final BlockPos llllllllllllllllIllIIlIllIllIIll, final EnumFacing llllllllllllllllIllIIlIllIllIIlI, final EnumFacing llllllllllllllllIllIIlIllIlIllII, final LoadingCache llllllllllllllllIllIIlIllIllIIII) {
            this.field_177674_a = llllllllllllllllIllIIlIllIllIIll;
            this.field_177672_b = llllllllllllllllIllIIlIllIllIIlI;
            this.field_177673_c = llllllllllllllllIllIIlIllIlIllII;
            this.field_177671_d = llllllllllllllllIllIIlIllIllIIII;
        }
    }
    
    static class CacheLoader extends com.google.common.cache.CacheLoader
    {
        private final /* synthetic */ World field_177680_a;
        
        public Object load(final Object lllllllllllllllllllIllllIIlIIlII) {
            return this.func_177679_a((BlockPos)lllllllllllllllllllIllllIIlIIlII);
        }
        
        static {
            __OBFID = "CL_00002023";
        }
        
        public CacheLoader(final World lllllllllllllllllllIllllIIllIIlI) {
            this.field_177680_a = lllllllllllllllllllIllllIIllIIlI;
        }
        
        public BlockWorldState func_177679_a(final BlockPos lllllllllllllllllllIllllIIlIllII) {
            return new BlockWorldState(this.field_177680_a, lllllllllllllllllllIllllIIlIllII);
        }
    }
}
