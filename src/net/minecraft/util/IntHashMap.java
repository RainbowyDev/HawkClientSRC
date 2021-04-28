package net.minecraft.util;

public class IntHashMap
{
    private transient /* synthetic */ Entry[] slots;
    private transient /* synthetic */ int count;
    private /* synthetic */ int threshold;
    
    final Entry lookupEntry(final int lllllllllllllllIlIlllIlIlIlllIll) {
        final int lllllllllllllllIlIlllIlIlIlllllI = computeHash(lllllllllllllllIlIlllIlIlIlllIll);
        for (Entry lllllllllllllllIlIlllIlIlIllllIl = this.slots[getSlotIndex(lllllllllllllllIlIlllIlIlIlllllI, this.slots.length)]; lllllllllllllllIlIlllIlIlIllllIl != null; lllllllllllllllIlIlllIlIlIllllIl = lllllllllllllllIlIlllIlIlIllllIl.nextEntry) {
            if (lllllllllllllllIlIlllIlIlIllllIl.hashEntry == lllllllllllllllIlIlllIlIlIlllIll) {
                return lllllllllllllllIlIlllIlIlIllllIl;
            }
        }
        return null;
    }
    
    public Object removeObject(final int lllllllllllllllIlIlllIlIIllllIll) {
        final Entry lllllllllllllllIlIlllIlIIllllIlI = this.removeEntry(lllllllllllllllIlIlllIlIIllllIll);
        return (lllllllllllllllIlIlllIlIIllllIlI == null) ? null : lllllllllllllllIlIlllIlIIllllIlI.valueEntry;
    }
    
    private static int computeHash(int lllllllllllllllIlIlllIlIllIlllIl) {
        lllllllllllllllIlIlllIlIllIlllIl ^= (lllllllllllllllIlIlllIlIllIlllIl >>> 20 ^ lllllllllllllllIlIlllIlIllIlllIl >>> 12);
        return lllllllllllllllIlIlllIlIllIlllIl ^ lllllllllllllllIlIlllIlIllIlllIl >>> 7 ^ lllllllllllllllIlIlllIlIllIlllIl >>> 4;
    }
    
    public Object lookup(final int lllllllllllllllIlIlllIlIllIlIIIl) {
        final int lllllllllllllllIlIlllIlIllIlIIII = computeHash(lllllllllllllllIlIlllIlIllIlIIIl);
        for (Entry lllllllllllllllIlIlllIlIllIIllll = this.slots[getSlotIndex(lllllllllllllllIlIlllIlIllIlIIII, this.slots.length)]; lllllllllllllllIlIlllIlIllIIllll != null; lllllllllllllllIlIlllIlIllIIllll = lllllllllllllllIlIlllIlIllIIllll.nextEntry) {
            if (lllllllllllllllIlIlllIlIllIIllll.hashEntry == lllllllllllllllIlIlllIlIllIlIIIl) {
                return lllllllllllllllIlIlllIlIllIIllll.valueEntry;
            }
        }
        return null;
    }
    
    private void insert(final int lllllllllllllllIlIlllIlIIlIIlIll, final int lllllllllllllllIlIlllIlIIlIIlIlI, final Object lllllllllllllllIlIlllIlIIlIIlIIl, final int lllllllllllllllIlIlllIlIIlIIlllI) {
        final Entry lllllllllllllllIlIlllIlIIlIIllIl = this.slots[lllllllllllllllIlIlllIlIIlIIlllI];
        this.slots[lllllllllllllllIlIlllIlIIlIIlllI] = new Entry(lllllllllllllllIlIlllIlIIlIIlIll, lllllllllllllllIlIlllIlIIlIIlIlI, lllllllllllllllIlIlllIlIIlIIlIIl, lllllllllllllllIlIlllIlIIlIIllIl);
        if (this.count++ >= this.threshold) {
            this.grow(2 * this.slots.length);
        }
    }
    
    private static int getSlotIndex(final int lllllllllllllllIlIlllIlIllIllIlI, final int lllllllllllllllIlIlllIlIllIlIlll) {
        return lllllllllllllllIlIlllIlIllIllIlI & lllllllllllllllIlIlllIlIllIlIlll - 1;
    }
    
    public void addKey(final int lllllllllllllllIlIlllIlIlIllIIIl, final Object lllllllllllllllIlIlllIlIlIlIlIlI) {
        final int lllllllllllllllIlIlllIlIlIlIllll = computeHash(lllllllllllllllIlIlllIlIlIllIIIl);
        final int lllllllllllllllIlIlllIlIlIlIlllI = getSlotIndex(lllllllllllllllIlIlllIlIlIlIllll, this.slots.length);
        for (Entry lllllllllllllllIlIlllIlIlIlIllIl = this.slots[lllllllllllllllIlIlllIlIlIlIlllI]; lllllllllllllllIlIlllIlIlIlIllIl != null; lllllllllllllllIlIlllIlIlIlIllIl = lllllllllllllllIlIlllIlIlIlIllIl.nextEntry) {
            if (lllllllllllllllIlIlllIlIlIlIllIl.hashEntry == lllllllllllllllIlIlllIlIlIllIIIl) {
                lllllllllllllllIlIlllIlIlIlIllIl.valueEntry = lllllllllllllllIlIlllIlIlIlIlIlI;
                return;
            }
        }
        this.insert(lllllllllllllllIlIlllIlIlIlIllll, lllllllllllllllIlIlllIlIlIllIIIl, lllllllllllllllIlIlllIlIlIlIlIlI, lllllllllllllllIlIlllIlIlIlIlllI);
    }
    
    public void clearMap() {
        final Entry[] lllllllllllllllIlIlllIlIIlIlllIl = this.slots;
        for (int lllllllllllllllIlIlllIlIIlIlllII = 0; lllllllllllllllIlIlllIlIIlIlllII < lllllllllllllllIlIlllIlIIlIlllIl.length; ++lllllllllllllllIlIlllIlIIlIlllII) {
            lllllllllllllllIlIlllIlIIlIlllIl[lllllllllllllllIlIlllIlIIlIlllII] = null;
        }
        this.count = 0;
    }
    
    static {
        __OBFID = "CL_00001490";
    }
    
    final Entry removeEntry(final int lllllllllllllllIlIlllIlIIllIIlll) {
        final int lllllllllllllllIlIlllIlIIllIllIl = computeHash(lllllllllllllllIlIlllIlIIllIIlll);
        final int lllllllllllllllIlIlllIlIIllIllII = getSlotIndex(lllllllllllllllIlIlllIlIIllIllIl, this.slots.length);
        Entry lllllllllllllllIlIlllIlIIllIlIlI;
        Entry lllllllllllllllIlIlllIlIIllIlIIl;
        for (Entry lllllllllllllllIlIlllIlIIllIlIll = lllllllllllllllIlIlllIlIIllIlIlI = this.slots[lllllllllllllllIlIlllIlIIllIllII]; lllllllllllllllIlIlllIlIIllIlIlI != null; lllllllllllllllIlIlllIlIIllIlIlI = lllllllllllllllIlIlllIlIIllIlIIl) {
            lllllllllllllllIlIlllIlIIllIlIIl = lllllllllllllllIlIlllIlIIllIlIlI.nextEntry;
            if (lllllllllllllllIlIlllIlIIllIlIlI.hashEntry == lllllllllllllllIlIlllIlIIllIIlll) {
                --this.count;
                if (lllllllllllllllIlIlllIlIIllIlIll == lllllllllllllllIlIlllIlIIllIlIlI) {
                    this.slots[lllllllllllllllIlIlllIlIIllIllII] = lllllllllllllllIlIlllIlIIllIlIIl;
                }
                else {
                    lllllllllllllllIlIlllIlIIllIlIll.nextEntry = lllllllllllllllIlIlllIlIIllIlIIl;
                }
                return lllllllllllllllIlIlllIlIIllIlIlI;
            }
            lllllllllllllllIlIlllIlIIllIlIll = lllllllllllllllIlIlllIlIIllIlIlI;
        }
        return lllllllllllllllIlIlllIlIIllIlIlI;
    }
    
    public IntHashMap() {
        this.slots = new Entry[16];
        this.threshold = 12;
    }
    
    private void copyTo(final Entry[] lllllllllllllllIlIlllIlIlIIIlllI) {
        final Entry[] lllllllllllllllIlIlllIlIlIIIllIl = this.slots;
        final int lllllllllllllllIlIlllIlIlIIIllII = lllllllllllllllIlIlllIlIlIIIlllI.length;
        for (int lllllllllllllllIlIlllIlIlIIIlIll = 0; lllllllllllllllIlIlllIlIlIIIlIll < lllllllllllllllIlIlllIlIlIIIllIl.length; ++lllllllllllllllIlIlllIlIlIIIlIll) {
            Entry lllllllllllllllIlIlllIlIlIIIlIlI = lllllllllllllllIlIlllIlIlIIIllIl[lllllllllllllllIlIlllIlIlIIIlIll];
            if (lllllllllllllllIlIlllIlIlIIIlIlI != null) {
                lllllllllllllllIlIlllIlIlIIIllIl[lllllllllllllllIlIlllIlIlIIIlIll] = null;
                Entry lllllllllllllllIlIlllIlIlIIIlIIl;
                do {
                    lllllllllllllllIlIlllIlIlIIIlIIl = lllllllllllllllIlIlllIlIlIIIlIlI.nextEntry;
                    final int lllllllllllllllIlIlllIlIlIIIlIII = getSlotIndex(lllllllllllllllIlIlllIlIlIIIlIlI.slotHash, lllllllllllllllIlIlllIlIlIIIllII);
                    lllllllllllllllIlIlllIlIlIIIlIlI.nextEntry = lllllllllllllllIlIlllIlIlIIIlllI[lllllllllllllllIlIlllIlIlIIIlIII];
                    lllllllllllllllIlIlllIlIlIIIlllI[lllllllllllllllIlIlllIlIlIIIlIII] = lllllllllllllllIlIlllIlIlIIIlIlI;
                } while ((lllllllllllllllIlIlllIlIlIIIlIlI = lllllllllllllllIlIlllIlIlIIIlIIl) != null);
            }
        }
    }
    
    private void grow(final int lllllllllllllllIlIlllIlIlIIllIll) {
        final Entry[] lllllllllllllllIlIlllIlIlIIlllll = this.slots;
        final int lllllllllllllllIlIlllIlIlIIllllI = lllllllllllllllIlIlllIlIlIIlllll.length;
        if (lllllllllllllllIlIlllIlIlIIllllI == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
        }
        else {
            final Entry[] lllllllllllllllIlIlllIlIlIIlllIl = new Entry[lllllllllllllllIlIlllIlIlIIllIll];
            this.copyTo(lllllllllllllllIlIlllIlIlIIlllIl);
            this.slots = lllllllllllllllIlIlllIlIlIIlllIl;
            this.threshold = (int)(lllllllllllllllIlIlllIlIlIIllIll * 0.75f);
        }
    }
    
    public boolean containsItem(final int lllllllllllllllIlIlllIlIllIIIlIl) {
        return this.lookupEntry(lllllllllllllllIlIlllIlIllIIIlIl) != null;
    }
    
    static class Entry
    {
        /* synthetic */ Object valueEntry;
        final /* synthetic */ int hashEntry;
        final /* synthetic */ int slotHash;
        /* synthetic */ Entry nextEntry;
        
        @Override
        public final int hashCode() {
            return computeHash(this.hashEntry);
        }
        
        Entry(final int llllllllllllllIllIlIlIIlllIIllIl, final int llllllllllllllIllIlIlIIlllIIllII, final Object llllllllllllllIllIlIlIIlllIIIllI, final Entry llllllllllllllIllIlIlIIlllIIlIlI) {
            this.valueEntry = llllllllllllllIllIlIlIIlllIIIllI;
            this.nextEntry = llllllllllllllIllIlIlIIlllIIlIlI;
            this.hashEntry = llllllllllllllIllIlIlIIlllIIllII;
            this.slotHash = llllllllllllllIllIlIlIIlllIIllIl;
        }
        
        public final int getHash() {
            return this.hashEntry;
        }
        
        @Override
        public final String toString() {
            return String.valueOf(new StringBuilder(String.valueOf(this.getHash())).append("=").append(this.getValue()));
        }
        
        static {
            __OBFID = "CL_00001491";
        }
        
        @Override
        public final boolean equals(final Object llllllllllllllIllIlIlIIllIllIllI) {
            if (!(llllllllllllllIllIlIlIIllIllIllI instanceof Entry)) {
                return false;
            }
            final Entry llllllllllllllIllIlIlIIllIllIlIl = (Entry)llllllllllllllIllIlIlIIllIllIllI;
            final Integer llllllllllllllIllIlIlIIllIllIlII = this.getHash();
            final Integer llllllllllllllIllIlIlIIllIllIIll = llllllllllllllIllIlIlIIllIllIlIl.getHash();
            if (llllllllllllllIllIlIlIIllIllIlII == llllllllllllllIllIlIlIIllIllIIll || (llllllllllllllIllIlIlIIllIllIlII != null && llllllllllllllIllIlIlIIllIllIlII.equals(llllllllllllllIllIlIlIIllIllIIll))) {
                final Object llllllllllllllIllIlIlIIllIllIIlI = this.getValue();
                final Object llllllllllllllIllIlIlIIllIllIIIl = llllllllllllllIllIlIlIIllIllIlIl.getValue();
                if (llllllllllllllIllIlIlIIllIllIIlI == llllllllllllllIllIlIlIIllIllIIIl || (llllllllllllllIllIlIlIIllIllIIlI != null && llllllllllllllIllIlIlIIllIllIIlI.equals(llllllllllllllIllIlIlIIllIllIIIl))) {
                    return true;
                }
            }
            return false;
        }
        
        public final Object getValue() {
            return this.valueEntry;
        }
    }
}
