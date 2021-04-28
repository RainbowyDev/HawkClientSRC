package net.minecraft.util;

public class LongHashMap
{
    private /* synthetic */ int capacity;
    private /* synthetic */ int field_180201_c;
    private transient volatile /* synthetic */ int modCount;
    private transient /* synthetic */ Entry[] hashArray;
    private transient /* synthetic */ int numHashElements;
    
    public Object remove(final long lIIlIlllIlIIlI) {
        final Entry lIIlIlllIlIIIl = this.removeKey(lIIlIlllIlIIlI);
        return (lIIlIlllIlIIIl == null) ? null : lIIlIlllIlIIIl.value;
    }
    
    public Object getValueByKey(final long lIIllIIIlIIlll) {
        final int lIIllIIIlIlIlI = getHashedKey(lIIllIIIlIIlll);
        for (Entry lIIllIIIlIlIIl = this.hashArray[getHashIndex(lIIllIIIlIlIlI, this.field_180201_c)]; lIIllIIIlIlIIl != null; lIIllIIIlIlIIl = lIIllIIIlIlIIl.nextEntry) {
            if (lIIllIIIlIlIIl.key == lIIllIIIlIIlll) {
                return lIIllIIIlIlIIl.value;
            }
        }
        return null;
    }
    
    public LongHashMap() {
        this.hashArray = new Entry[4096];
        this.capacity = 3072;
        this.field_180201_c = this.hashArray.length - 1;
    }
    
    static {
        __OBFID = "CL_00001492";
    }
    
    public int getNumHashElements() {
        return this.numHashElements;
    }
    
    public boolean containsItem(final long lIIllIIIlIIIIl) {
        return this.getEntry(lIIllIIIlIIIIl) != null;
    }
    
    private static int getHashIndex(final int lIIllIIIllIlIl, final int lIIllIIIllIlII) {
        return lIIllIIIllIlIl & lIIllIIIllIlII;
    }
    
    public void add(final long lIIllIIIIIlIll, final Object lIIllIIIIIIlII) {
        final int lIIllIIIIIlIIl = getHashedKey(lIIllIIIIIlIll);
        final int lIIllIIIIIlIII = getHashIndex(lIIllIIIIIlIIl, this.field_180201_c);
        for (Entry lIIllIIIIIIlll = this.hashArray[lIIllIIIIIlIII]; lIIllIIIIIIlll != null; lIIllIIIIIIlll = lIIllIIIIIIlll.nextEntry) {
            if (lIIllIIIIIIlll.key == lIIllIIIIIlIll) {
                lIIllIIIIIIlll.value = lIIllIIIIIIlII;
                return;
            }
        }
        ++this.modCount;
        this.createKey(lIIllIIIIIlIIl, lIIllIIIIIlIll, lIIllIIIIIIlII, lIIllIIIIIlIII);
    }
    
    public double getKeyDistribution() {
        int lIIlIllIlIIIlI = 0;
        for (int lIIlIllIlIIIIl = 0; lIIlIllIlIIIIl < this.hashArray.length; ++lIIlIllIlIIIIl) {
            if (this.hashArray[lIIlIllIlIIIIl] != null) {
                ++lIIlIllIlIIIlI;
            }
        }
        return 1.0 * lIIlIllIlIIIlI / this.numHashElements;
    }
    
    private static int getHashedKey(final long lIIllIIIllllIl) {
        return (int)(lIIllIIIllllIl ^ lIIllIIIllllIl >>> 27);
    }
    
    private static int hash(int lIIllIIIlllIlI) {
        lIIllIIIlllIlI ^= (lIIllIIIlllIlI >>> 20 ^ lIIllIIIlllIlI >>> 12);
        return lIIllIIIlllIlI ^ lIIllIIIlllIlI >>> 7 ^ lIIllIIIlllIlI >>> 4;
    }
    
    private void copyHashTableTo(final Entry[] lIIlIllllIIlIl) {
        final Entry[] lIIlIllllIIlII = this.hashArray;
        final int lIIlIllllIIIll = lIIlIllllIIlIl.length;
        for (int lIIlIllllIIIlI = 0; lIIlIllllIIIlI < lIIlIllllIIlII.length; ++lIIlIllllIIIlI) {
            Entry lIIlIllllIIIIl = lIIlIllllIIlII[lIIlIllllIIIlI];
            if (lIIlIllllIIIIl != null) {
                lIIlIllllIIlII[lIIlIllllIIIlI] = null;
                Entry lIIlIllllIIIII;
                do {
                    lIIlIllllIIIII = lIIlIllllIIIIl.nextEntry;
                    final int lIIlIlllIlllll = getHashIndex(lIIlIllllIIIIl.hash, lIIlIllllIIIll - 1);
                    lIIlIllllIIIIl.nextEntry = lIIlIllllIIlIl[lIIlIlllIlllll];
                    lIIlIllllIIlIl[lIIlIlllIlllll] = lIIlIllllIIIIl;
                } while ((lIIlIllllIIIIl = lIIlIllllIIIII) != null);
            }
        }
    }
    
    private void createKey(final int lIIlIllIllIIIl, final long lIIlIllIlIlIlI, final Object lIIlIllIlIllll, final int lIIlIllIlIlIII) {
        final Entry lIIlIllIlIllIl = this.hashArray[lIIlIllIlIlIII];
        this.hashArray[lIIlIllIlIlIII] = new Entry(lIIlIllIllIIIl, lIIlIllIlIlIlI, lIIlIllIlIllll, lIIlIllIlIllIl);
        if (this.numHashElements++ >= this.capacity) {
            this.resizeTable(2 * this.hashArray.length);
        }
    }
    
    private void resizeTable(final int lIIlIlllllIIll) {
        final Entry[] lIIlIllllllIII = this.hashArray;
        final int lIIlIlllllIlll = lIIlIllllllIII.length;
        if (lIIlIlllllIlll == 1073741824) {
            this.capacity = Integer.MAX_VALUE;
        }
        else {
            final Entry[] lIIlIlllllIllI = new Entry[lIIlIlllllIIll];
            this.copyHashTableTo(lIIlIlllllIllI);
            this.hashArray = lIIlIlllllIllI;
            this.field_180201_c = this.hashArray.length - 1;
            final float lIIlIlllllIlIl = (float)lIIlIlllllIIll;
            this.getClass();
            this.capacity = (int)(lIIlIlllllIlIl * 0.75f);
        }
    }
    
    final Entry getEntry(final long lIIllIIIIlIlIl) {
        final int lIIllIIIIllIII = getHashedKey(lIIllIIIIlIlIl);
        for (Entry lIIllIIIIlIlll = this.hashArray[getHashIndex(lIIllIIIIllIII, this.field_180201_c)]; lIIllIIIIlIlll != null; lIIllIIIIlIlll = lIIllIIIIlIlll.nextEntry) {
            if (lIIllIIIIlIlll.key == lIIllIIIIlIlIl) {
                return lIIllIIIIlIlll;
            }
        }
        return null;
    }
    
    final Entry removeKey(final long lIIlIlllIIIlIl) {
        final int lIIlIlllIIIlII = getHashedKey(lIIlIlllIIIlIl);
        final int lIIlIlllIIIIll = getHashIndex(lIIlIlllIIIlII, this.field_180201_c);
        Entry lIIlIlllIIIIIl;
        Entry lIIlIlllIIIIII;
        for (Entry lIIlIlllIIIIlI = lIIlIlllIIIIIl = this.hashArray[lIIlIlllIIIIll]; lIIlIlllIIIIIl != null; lIIlIlllIIIIIl = lIIlIlllIIIIII) {
            lIIlIlllIIIIII = lIIlIlllIIIIIl.nextEntry;
            if (lIIlIlllIIIIIl.key == lIIlIlllIIIlIl) {
                ++this.modCount;
                --this.numHashElements;
                if (lIIlIlllIIIIlI == lIIlIlllIIIIIl) {
                    this.hashArray[lIIlIlllIIIIll] = lIIlIlllIIIIII;
                }
                else {
                    lIIlIlllIIIIlI.nextEntry = lIIlIlllIIIIII;
                }
                return lIIlIlllIIIIIl;
            }
            lIIlIlllIIIIlI = lIIlIlllIIIIIl;
        }
        return lIIlIlllIIIIIl;
    }
    
    static class Entry
    {
        /* synthetic */ Entry nextEntry;
        /* synthetic */ Object value;
        final /* synthetic */ int hash;
        final /* synthetic */ long key;
        
        Entry(final int llllllllllllllIlIIlIlIllllIlIIll, final long llllllllllllllIlIIlIlIllllIlIlll, final Object llllllllllllllIlIIlIlIllllIlIllI, final Entry llllllllllllllIlIIlIlIllllIlIlIl) {
            this.value = llllllllllllllIlIIlIlIllllIlIllI;
            this.nextEntry = llllllllllllllIlIIlIlIllllIlIlIl;
            this.key = llllllllllllllIlIIlIlIllllIlIlll;
            this.hash = llllllllllllllIlIIlIlIllllIlIIll;
        }
        
        @Override
        public final boolean equals(final Object llllllllllllllIlIIlIlIlllIlllIlI) {
            if (!(llllllllllllllIlIIlIlIlllIlllIlI instanceof Entry)) {
                return false;
            }
            final Entry llllllllllllllIlIIlIlIllllIIIIII = (Entry)llllllllllllllIlIIlIlIlllIlllIlI;
            final Long llllllllllllllIlIIlIlIlllIllllll = this.getKey();
            final Long llllllllllllllIlIIlIlIlllIlllllI = llllllllllllllIlIIlIlIllllIIIIII.getKey();
            if (llllllllllllllIlIIlIlIlllIllllll == llllllllllllllIlIIlIlIlllIlllllI || (llllllllllllllIlIIlIlIlllIllllll != null && llllllllllllllIlIIlIlIlllIllllll.equals(llllllllllllllIlIIlIlIlllIlllllI))) {
                final Object llllllllllllllIlIIlIlIlllIllllIl = this.getValue();
                final Object llllllllllllllIlIIlIlIlllIllllII = llllllllllllllIlIIlIlIllllIIIIII.getValue();
                if (llllllllllllllIlIIlIlIlllIllllIl == llllllllllllllIlIIlIlIlllIllllII || (llllllllllllllIlIIlIlIlllIllllIl != null && llllllllllllllIlIIlIlIlllIllllIl.equals(llllllllllllllIlIIlIlIlllIllllII))) {
                    return true;
                }
            }
            return false;
        }
        
        static {
            __OBFID = "CL_00001493";
        }
        
        public final Object getValue() {
            return this.value;
        }
        
        @Override
        public final String toString() {
            return String.valueOf(new StringBuilder(String.valueOf(this.getKey())).append("=").append(this.getValue()));
        }
        
        @Override
        public final int hashCode() {
            return getHashedKey(this.key);
        }
        
        public final long getKey() {
            return this.key;
        }
    }
}
