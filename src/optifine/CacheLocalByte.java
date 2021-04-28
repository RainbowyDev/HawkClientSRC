package optifine;

public class CacheLocalByte
{
    private /* synthetic */ int maxY;
    private /* synthetic */ int offsetZ;
    private /* synthetic */ int maxX;
    private /* synthetic */ int lastDz;
    private /* synthetic */ byte[][][] cache;
    private /* synthetic */ byte[] lastZs;
    private /* synthetic */ int maxZ;
    private /* synthetic */ int offsetY;
    private /* synthetic */ int offsetX;
    
    public CacheLocalByte(final int llllllllllllllllIlIlIlIIllIIlIII, final int llllllllllllllllIlIlIlIIllIIIlll, final int llllllllllllllllIlIlIlIIllIIIllI) {
        this.maxX = 18;
        this.maxY = 128;
        this.maxZ = 18;
        this.offsetX = 0;
        this.offsetY = 0;
        this.offsetZ = 0;
        this.cache = null;
        this.lastZs = null;
        this.lastDz = 0;
        this.maxX = llllllllllllllllIlIlIlIIllIIlIII;
        this.maxY = llllllllllllllllIlIlIlIIllIIIlll;
        this.maxZ = llllllllllllllllIlIlIlIIllIIIllI;
        this.cache = new byte[llllllllllllllllIlIlIlIIllIIlIII][llllllllllllllllIlIlIlIIllIIIlll][llllllllllllllllIlIlIlIIllIIIllI];
        this.resetCache();
    }
    
    public void setOffset(final int llllllllllllllllIlIlIlIIlIlIIllI, final int llllllllllllllllIlIlIlIIlIlIlIIl, final int llllllllllllllllIlIlIlIIlIlIlIII) {
        this.offsetX = llllllllllllllllIlIlIlIIlIlIIllI;
        this.offsetY = llllllllllllllllIlIlIlIIlIlIlIIl;
        this.offsetZ = llllllllllllllllIlIlIlIIlIlIlIII;
        this.resetCache();
    }
    
    public byte get(final int llllllllllllllllIlIlIlIIlIIllIII, final int llllllllllllllllIlIlIlIIlIIlIlll, final int llllllllllllllllIlIlIlIIlIIlIllI) {
        try {
            this.lastZs = this.cache[llllllllllllllllIlIlIlIIlIIllIII - this.offsetX][llllllllllllllllIlIlIlIIlIIlIlll - this.offsetY];
            this.lastDz = llllllllllllllllIlIlIlIIlIIlIllI - this.offsetZ;
            return this.lastZs[this.lastDz];
        }
        catch (ArrayIndexOutOfBoundsException llllllllllllllllIlIlIlIIlIIllIlI) {
            llllllllllllllllIlIlIlIIlIIllIlI.printStackTrace();
            return -1;
        }
    }
    
    public void resetCache() {
        for (int llllllllllllllllIlIlIlIIlIlllIlI = 0; llllllllllllllllIlIlIlIIlIlllIlI < this.maxX; ++llllllllllllllllIlIlIlIIlIlllIlI) {
            final byte[][] llllllllllllllllIlIlIlIIlIlllIIl = this.cache[llllllllllllllllIlIlIlIIlIlllIlI];
            for (int llllllllllllllllIlIlIlIIlIlllIII = 0; llllllllllllllllIlIlIlIIlIlllIII < this.maxY; ++llllllllllllllllIlIlIlIIlIlllIII) {
                final byte[] llllllllllllllllIlIlIlIIlIllIlll = llllllllllllllllIlIlIlIIlIlllIIl[llllllllllllllllIlIlIlIIlIlllIII];
                for (int llllllllllllllllIlIlIlIIlIllIllI = 0; llllllllllllllllIlIlIlIIlIllIllI < this.maxZ; ++llllllllllllllllIlIlIlIIlIllIllI) {
                    llllllllllllllllIlIlIlIIlIllIlll[llllllllllllllllIlIlIlIIlIllIllI] = -1;
                }
            }
        }
    }
    
    public void setLast(final byte llllllllllllllllIlIlIlIIlIIlIIII) {
        try {
            this.lastZs[this.lastDz] = llllllllllllllllIlIlIlIIlIIlIIII;
        }
        catch (Exception llllllllllllllllIlIlIlIIlIIIllll) {
            llllllllllllllllIlIlIlIIlIIIllll.printStackTrace();
        }
    }
}
