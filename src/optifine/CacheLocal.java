package optifine;

public class CacheLocal
{
    private /* synthetic */ int[] lastZs;
    private /* synthetic */ int maxX;
    private /* synthetic */ int maxY;
    private /* synthetic */ int offsetY;
    private /* synthetic */ int offsetX;
    private /* synthetic */ int lastDz;
    private /* synthetic */ int[][][] cache;
    private /* synthetic */ int offsetZ;
    private /* synthetic */ int maxZ;
    
    public CacheLocal(final int llllllllllllllIlIllllIllIIIllIIl, final int llllllllllllllIlIllllIllIIIlllll, final int llllllllllllllIlIllllIllIIIlIlIl) {
        this.maxX = 18;
        this.maxY = 128;
        this.maxZ = 18;
        this.offsetX = 0;
        this.offsetY = 0;
        this.offsetZ = 0;
        this.cache = null;
        this.lastZs = null;
        this.lastDz = 0;
        this.maxX = llllllllllllllIlIllllIllIIIllIIl;
        this.maxY = llllllllllllllIlIllllIllIIIlllll;
        this.maxZ = llllllllllllllIlIllllIllIIIlIlIl;
        this.cache = new int[llllllllllllllIlIllllIllIIIllIIl][llllllllllllllIlIllllIllIIIlllll][llllllllllllllIlIllllIllIIIlIlIl];
        this.resetCache();
    }
    
    public int get(final int llllllllllllllIlIllllIlIllIIIllI, final int llllllllllllllIlIllllIlIllIIlIlI, final int llllllllllllllIlIllllIlIllIIlIIl) {
        try {
            this.lastZs = this.cache[llllllllllllllIlIllllIlIllIIIllI - this.offsetX][llllllllllllllIlIllllIlIllIIlIlI - this.offsetY];
            this.lastDz = llllllllllllllIlIllllIlIllIIlIIl - this.offsetZ;
            return this.lastZs[this.lastDz];
        }
        catch (ArrayIndexOutOfBoundsException llllllllllllllIlIllllIlIllIIlIII) {
            llllllllllllllIlIllllIlIllIIlIII.printStackTrace();
            return -1;
        }
    }
    
    public void resetCache() {
        for (int llllllllllllllIlIllllIllIIIIIlIl = 0; llllllllllllllIlIllllIllIIIIIlIl < this.maxX; ++llllllllllllllIlIllllIllIIIIIlIl) {
            final int[][] llllllllllllllIlIllllIllIIIIIIll = this.cache[llllllllllllllIlIllllIllIIIIIlIl];
            for (int llllllllllllllIlIllllIllIIIIIIIl = 0; llllllllllllllIlIllllIllIIIIIIIl < this.maxY; ++llllllllllllllIlIllllIllIIIIIIIl) {
                final int[] llllllllllllllIlIllllIlIllllllll = llllllllllllllIlIllllIllIIIIIIll[llllllllllllllIlIllllIllIIIIIIIl];
                for (int llllllllllllllIlIllllIlIllllllIl = 0; llllllllllllllIlIllllIlIllllllIl < this.maxZ; ++llllllllllllllIlIllllIlIllllllIl) {
                    llllllllllllllIlIllllIlIllllllll[llllllllllllllIlIllllIlIllllllIl] = -1;
                }
            }
        }
    }
    
    public void setLast(final int llllllllllllllIlIllllIlIlIllIlII) {
        try {
            this.lastZs[this.lastDz] = llllllllllllllIlIllllIlIlIllIlII;
        }
        catch (Exception llllllllllllllIlIllllIlIlIllIllI) {
            llllllllllllllIlIllllIlIlIllIllI.printStackTrace();
        }
    }
    
    public void setOffset(final int llllllllllllllIlIllllIlIlllIIIll, final int llllllllllllllIlIllllIlIllIllllI, final int llllllllllllllIlIllllIlIllIlllII) {
        this.offsetX = llllllllllllllIlIllllIlIlllIIIll;
        this.offsetY = llllllllllllllIlIllllIlIllIllllI;
        this.offsetZ = llllllllllllllIlIllllIlIllIlllII;
        this.resetCache();
    }
}
