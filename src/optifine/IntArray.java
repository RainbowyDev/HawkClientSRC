package optifine;

public class IntArray
{
    private /* synthetic */ int limit;
    private /* synthetic */ int[] array;
    private /* synthetic */ int position;
    
    public int getPosition() {
        return this.position;
    }
    
    public void put(final int llllllllllllllllIllIlIlllIIIllIl, final int llllllllllllllllIllIlIlllIIIllll) {
        this.array[llllllllllllllllIllIlIlllIIIllIl] = llllllllllllllllIllIlIlllIIIllll;
        if (this.limit < llllllllllllllllIllIlIlllIIIllIl) {
            this.limit = llllllllllllllllIllIlIlllIIIllIl;
        }
    }
    
    public int[] getArray() {
        return this.array;
    }
    
    public int getLimit() {
        return this.limit;
    }
    
    public void clear() {
        this.position = 0;
        this.limit = 0;
    }
    
    public IntArray(final int llllllllllllllllIllIlIlllIIllIll) {
        this.array = null;
        this.position = 0;
        this.limit = 0;
        this.array = new int[llllllllllllllllIllIlIlllIIllIll];
    }
    
    public void put(final int[] llllllllllllllllIllIlIllIlllllII) {
        for (int llllllllllllllllIllIlIllIlllllll = llllllllllllllllIllIlIllIlllllII.length, llllllllllllllllIllIlIllIllllllI = 0; llllllllllllllllIllIlIllIllllllI < llllllllllllllllIllIlIllIlllllll; ++llllllllllllllllIllIlIllIllllllI) {
            this.array[this.position] = llllllllllllllllIllIlIllIlllllII[llllllllllllllllIllIlIllIllllllI];
            ++this.position;
        }
        if (this.limit < this.position) {
            this.limit = this.position;
        }
    }
    
    public int get(final int llllllllllllllllIllIlIllIlllIlII) {
        return this.array[llllllllllllllllIllIlIllIlllIlII];
    }
    
    public void put(final int llllllllllllllllIllIlIlllIIlIlIl) {
        this.array[this.position] = llllllllllllllllIllIlIlllIIlIlIl;
        ++this.position;
        if (this.limit < this.position) {
            this.limit = this.position;
        }
    }
    
    public void position(final int llllllllllllllllIllIlIlllIIIlIII) {
        this.position = llllllllllllllllIllIlIlllIIIlIII;
    }
}
