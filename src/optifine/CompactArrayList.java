package optifine;

import java.util.*;

public class CompactArrayList
{
    private /* synthetic */ int countValid;
    private /* synthetic */ int initialCapacity;
    private /* synthetic */ float loadFactor;
    private /* synthetic */ ArrayList list;
    
    public void add(final int llllllllllllllIllllIlIllIIIIllII, final Object llllllllllllllIllllIlIllIIIIlIII) {
        if (llllllllllllllIllllIlIllIIIIlIII != null) {
            ++this.countValid;
        }
        this.list.add(llllllllllllllIllllIlIllIIIIllII, llllllllllllllIllllIlIllIIIIlIII);
    }
    
    public CompactArrayList() {
        this(10, 0.75f);
    }
    
    public void clear() {
        this.list.clear();
        this.countValid = 0;
    }
    
    public boolean contains(final Object llllllllllllllIllllIlIlIllIlIlll) {
        return this.list.contains(llllllllllllllIllllIlIlIllIlIlll);
    }
    
    public Object remove(final int llllllllllllllIllllIlIlIlllIlllI) {
        final Object llllllllllllllIllllIlIlIllllIIII = this.list.remove(llllllllllllllIllllIlIlIlllIlllI);
        if (llllllllllllllIllllIlIlIllllIIII != null) {
            --this.countValid;
        }
        return llllllllllllllIllllIlIlIllllIIII;
    }
    
    public Object set(final int llllllllllllllIllllIlIlIllllllII, final Object llllllllllllllIllllIlIlIllllIlll) {
        final Object llllllllllllllIllllIlIlIlllllIlI = this.list.set(llllllllllllllIllllIlIlIllllllII, llllllllllllllIllllIlIlIllllIlll);
        if (llllllllllllllIllllIlIlIllllIlll != llllllllllllllIllllIlIlIlllllIlI) {
            if (llllllllllllllIllllIlIlIlllllIlI == null) {
                ++this.countValid;
            }
            if (llllllllllllllIllllIlIlIllllIlll == null) {
                --this.countValid;
            }
        }
        return llllllllllllllIllllIlIlIlllllIlI;
    }
    
    public Object get(final int llllllllllllllIllllIlIlIllIIllll) {
        return this.list.get(llllllllllllllIllllIlIlIllIIllll);
    }
    
    public boolean add(final Object llllllllllllllIllllIlIllIIIIIlII) {
        if (llllllllllllllIllllIlIllIIIIIlII != null) {
            ++this.countValid;
        }
        return this.list.add(llllllllllllllIllllIlIllIIIIIlII);
    }
    
    public CompactArrayList(final int llllllllllllllIllllIlIllIIIlIIlI, final float llllllllllllllIllllIlIllIIIlIIIl) {
        this.list = null;
        this.initialCapacity = 0;
        this.loadFactor = 1.0f;
        this.countValid = 0;
        this.list = new ArrayList(llllllllllllllIllllIlIllIIIlIIlI);
        this.initialCapacity = llllllllllllllIllllIlIllIIIlIIlI;
        this.loadFactor = llllllllllllllIllllIlIllIIIlIIIl;
    }
    
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    
    public int size() {
        return this.list.size();
    }
    
    public void compact() {
        if (this.countValid <= 0 && this.list.size() <= 0) {
            this.clear();
        }
        else if (this.list.size() > this.initialCapacity) {
            final float llllllllllllllIllllIlIlIlllIIIll = this.countValid * 1.0f / this.list.size();
            if (llllllllllllllIllllIlIlIlllIIIll <= this.loadFactor) {
                int llllllllllllllIllllIlIlIlllIIIlI = 0;
                for (int llllllllllllllIllllIlIlIlllIIIIl = 0; llllllllllllllIllllIlIlIlllIIIIl < this.list.size(); ++llllllllllllllIllllIlIlIlllIIIIl) {
                    final Object llllllllllllllIllllIlIlIlllIIIII = this.list.get(llllllllllllllIllllIlIlIlllIIIIl);
                    if (llllllllllllllIllllIlIlIlllIIIII != null) {
                        if (llllllllllllllIllllIlIlIlllIIIIl != llllllllllllllIllllIlIlIlllIIIlI) {
                            this.list.set(llllllllllllllIllllIlIlIlllIIIlI, llllllllllllllIllllIlIlIlllIIIII);
                        }
                        ++llllllllllllllIllllIlIlIlllIIIlI;
                    }
                }
                for (int llllllllllllllIllllIlIlIlllIIIIl = this.list.size() - 1; llllllllllllllIllllIlIlIlllIIIIl >= llllllllllllllIllllIlIlIlllIIIlI; --llllllllllllllIllllIlIlIlllIIIIl) {
                    this.list.remove(llllllllllllllIllllIlIlIlllIIIIl);
                }
            }
        }
    }
    
    public CompactArrayList(final int llllllllllllllIllllIlIllIIIllIlI) {
        this(llllllllllllllIllllIlIllIIIllIlI, 0.75f);
    }
    
    public int getCountValid() {
        return this.countValid;
    }
}
