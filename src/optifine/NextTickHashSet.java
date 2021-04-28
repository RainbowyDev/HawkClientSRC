package optifine;

import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import java.util.*;

public class NextTickHashSet extends TreeSet
{
    private /* synthetic */ int minX;
    private /* synthetic */ int minZ;
    private /* synthetic */ LongHashMap longHashMap;
    private /* synthetic */ int maxZ;
    private /* synthetic */ int maxX;
    
    @Override
    public boolean remove(final Object llllllllllllllIIlIlIIlIIIIIIIIIl) {
        if (!(llllllllllllllIIlIlIIlIIIIIIIIIl instanceof NextTickListEntry)) {
            return false;
        }
        final NextTickListEntry llllllllllllllIIlIlIIlIIIIIIIIII = (NextTickListEntry)llllllllllllllIIlIlIIlIIIIIIIIIl;
        final Set llllllllllllllIIlIlIIIllllllllll = this.getSubSet(llllllllllllllIIlIlIIlIIIIIIIIII, false);
        if (llllllllllllllIIlIlIIIllllllllll == null) {
            return false;
        }
        final boolean llllllllllllllIIlIlIIIlllllllllI = llllllllllllllIIlIlIIIllllllllll.remove(llllllllllllllIIlIlIIlIIIIIIIIII);
        final boolean llllllllllllllIIlIlIIIllllllllIl = super.remove(llllllllllllllIIlIlIIlIIIIIIIIII);
        if (llllllllllllllIIlIlIIIlllllllllI != llllllllllllllIIlIlIIIllllllllIl) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Added: ").append(llllllllllllllIIlIlIIIlllllllllI).append(", addedParent: ").append(llllllllllllllIIlIlIIIllllllllIl)));
        }
        return llllllllllllllIIlIlIIIllllllllIl;
    }
    
    @Override
    public boolean contains(final Object llllllllllllllIIlIlIIlIIIIlIIIIl) {
        if (!(llllllllllllllIIlIlIIlIIIIlIIIIl instanceof NextTickListEntry)) {
            return false;
        }
        final NextTickListEntry llllllllllllllIIlIlIIlIIIIlIIIII = (NextTickListEntry)llllllllllllllIIlIlIIlIIIIlIIIIl;
        final Set llllllllllllllIIlIlIIlIIIIIlllll = this.getSubSet(llllllllllllllIIlIlIIlIIIIlIIIII, false);
        return llllllllllllllIIlIlIIlIIIIIlllll != null && llllllllllllllIIlIlIIlIIIIIlllll.contains(llllllllllllllIIlIlIIlIIIIlIIIII);
    }
    
    @Override
    public boolean add(final Object llllllllllllllIIlIlIIlIIIIIIllIl) {
        if (!(llllllllllllllIIlIlIIlIIIIIIllIl instanceof NextTickListEntry)) {
            return false;
        }
        final NextTickListEntry llllllllllllllIIlIlIIlIIIIIlIIlI = (NextTickListEntry)llllllllllllllIIlIlIIlIIIIIIllIl;
        if (llllllllllllllIIlIlIIlIIIIIlIIlI == null) {
            return false;
        }
        final Set llllllllllllllIIlIlIIlIIIIIlIIIl = this.getSubSet(llllllllllllllIIlIlIIlIIIIIlIIlI, true);
        final boolean llllllllllllllIIlIlIIlIIIIIlIIII = llllllllllllllIIlIlIIlIIIIIlIIIl.add(llllllllllllllIIlIlIIlIIIIIlIIlI);
        final boolean llllllllllllllIIlIlIIlIIIIIIllll = super.add(llllllllllllllIIlIlIIlIIIIIIllIl);
        if (llllllllllllllIIlIlIIlIIIIIlIIII != llllllllllllllIIlIlIIlIIIIIIllll) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Added: ").append(llllllllllllllIIlIlIIlIIIIIlIIII).append(", addedParent: ").append(llllllllllllllIIlIlIIlIIIIIIllll)));
        }
        return llllllllllllllIIlIlIIlIIIIIIllll;
    }
    
    public NextTickHashSet(final Set llllllllllllllIIlIlIIlIIIIlIlIIl) {
        this.longHashMap = new LongHashMap();
        this.minX = Integer.MIN_VALUE;
        this.minZ = Integer.MIN_VALUE;
        this.maxX = Integer.MIN_VALUE;
        this.maxZ = Integer.MIN_VALUE;
        for (final Object llllllllllllllIIlIlIIlIIIIlIlIll : llllllllllllllIIlIlIIlIIIIlIlIIl) {
            this.add(llllllllllllllIIlIlIIlIIIIlIlIll);
        }
    }
    
    private Set getSubSet(final NextTickListEntry llllllllllllllIIlIlIIIlllllIlIIl, final boolean llllllllllllllIIlIlIIIlllllIlllI) {
        if (llllllllllllllIIlIlIIIlllllIlIIl == null) {
            return null;
        }
        final BlockPos llllllllllllllIIlIlIIIlllllIllIl = llllllllllllllIIlIlIIIlllllIlIIl.field_180282_a;
        final int llllllllllllllIIlIlIIIlllllIllII = llllllllllllllIIlIlIIIlllllIllIl.getX() >> 4;
        final int llllllllllllllIIlIlIIIlllllIlIll = llllllllllllllIIlIlIIIlllllIllIl.getZ() >> 4;
        return this.getSubSet(llllllllllllllIIlIlIIIlllllIllII, llllllllllllllIIlIlIIIlllllIlIll, llllllllllllllIIlIlIIIlllllIlllI);
    }
    
    static {
        UNDEFINED = Integer.MIN_VALUE;
    }
    
    public void setIteratorLimits(final int llllllllllllllIIlIlIIIlllIlIllII, final int llllllllllllllIIlIlIIIlllIllIIII, final int llllllllllllllIIlIlIIIlllIlIlIlI, final int llllllllllllllIIlIlIIIlllIlIlIIl) {
        this.minX = Math.min(llllllllllllllIIlIlIIIlllIlIllII, llllllllllllllIIlIlIIIlllIlIlIlI);
        this.minZ = Math.min(llllllllllllllIIlIlIIIlllIllIIII, llllllllllllllIIlIlIIIlllIlIlIIl);
        this.maxX = Math.max(llllllllllllllIIlIlIIIlllIlIllII, llllllllllllllIIlIlIIIlllIlIlIlI);
        this.maxZ = Math.max(llllllllllllllIIlIlIIIlllIllIIII, llllllllllllllIIlIlIIIlllIlIlIIl);
    }
    
    @Override
    public Iterator iterator() {
        if (this.minX == Integer.MIN_VALUE) {
            return super.iterator();
        }
        if (this.size() <= 0) {
            return (Iterator)Iterators.emptyIterator();
        }
        final int llllllllllllllIIlIlIIIllllIIlIII = this.minX >> 4;
        final int llllllllllllllIIlIlIIIllllIIIlll = this.minZ >> 4;
        final int llllllllllllllIIlIlIIIllllIIIllI = this.maxX >> 4;
        final int llllllllllllllIIlIlIIIllllIIIlIl = this.maxZ >> 4;
        final ArrayList llllllllllllllIIlIlIIIllllIIIlII = new ArrayList();
        for (int llllllllllllllIIlIlIIIllllIIIIll = llllllllllllllIIlIlIIIllllIIlIII; llllllllllllllIIlIlIIIllllIIIIll <= llllllllllllllIIlIlIIIllllIIIllI; ++llllllllllllllIIlIlIIIllllIIIIll) {
            for (int llllllllllllllIIlIlIIIllllIIIIlI = llllllllllllllIIlIlIIIllllIIIlll; llllllllllllllIIlIlIIIllllIIIIlI <= llllllllllllllIIlIlIIIllllIIIlIl; ++llllllllllllllIIlIlIIIllllIIIIlI) {
                final Set llllllllllllllIIlIlIIIllllIIIIIl = this.getSubSet(llllllllllllllIIlIlIIIllllIIIIll, llllllllllllllIIlIlIIIllllIIIIlI, false);
                if (llllllllllllllIIlIlIIIllllIIIIIl != null) {
                    llllllllllllllIIlIlIIIllllIIIlII.add(llllllllllllllIIlIlIIIllllIIIIIl.iterator());
                }
            }
        }
        if (llllllllllllllIIlIlIIIllllIIIlII.size() <= 0) {
            return (Iterator)Iterators.emptyIterator();
        }
        if (llllllllllllllIIlIlIIIllllIIIlII.size() == 1) {
            return llllllllllllllIIlIlIIIllllIIIlII.get(0);
        }
        return Iterators.concat((Iterator)llllllllllllllIIlIlIIIllllIIIlII.iterator());
    }
    
    public void clearIteratorLimits() {
        this.minX = Integer.MIN_VALUE;
        this.minZ = Integer.MIN_VALUE;
        this.maxX = Integer.MIN_VALUE;
        this.maxZ = Integer.MIN_VALUE;
    }
    
    private Set getSubSet(final int llllllllllllllIIlIlIIIllllIlIlll, final int llllllllllllllIIlIlIIIllllIlllII, final boolean llllllllllllllIIlIlIIIllllIlIlIl) {
        final long llllllllllllllIIlIlIIIllllIllIlI = ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIlIlIIIllllIlIlll, llllllllllllllIIlIlIIIllllIlllII);
        HashSet llllllllllllllIIlIlIIIllllIllIIl = (HashSet)this.longHashMap.getValueByKey(llllllllllllllIIlIlIIIllllIllIlI);
        if (llllllllllllllIIlIlIIIllllIllIIl == null && llllllllllllllIIlIlIIIllllIlIlIl) {
            llllllllllllllIIlIlIIIllllIllIIl = new HashSet();
            this.longHashMap.add(llllllllllllllIIlIlIIIllllIllIlI, llllllllllllllIIlIlIIIllllIllIIl);
        }
        return llllllllllllllIIlIlIIIllllIllIIl;
    }
}
