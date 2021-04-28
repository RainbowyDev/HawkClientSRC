package optifine;

public class IntegerCache
{
    private static final /* synthetic */ Integer[] cache;
    
    private static Integer[] makeCache(final int llllllllllllllIlIlllllIIllIlIlll) {
        final Integer[] llllllllllllllIlIlllllIIllIlIllI = new Integer[llllllllllllllIlIlllllIIllIlIlll];
        for (int llllllllllllllIlIlllllIIllIlIlIl = 0; llllllllllllllIlIlllllIIllIlIlIl < llllllllllllllIlIlllllIIllIlIlll; ++llllllllllllllIlIlllllIIllIlIlIl) {
            llllllllllllllIlIlllllIIllIlIllI[llllllllllllllIlIlllllIIllIlIlIl] = new Integer(llllllllllllllIlIlllllIIllIlIlIl);
        }
        return llllllllllllllIlIlllllIIllIlIllI;
    }
    
    static {
        CACHE_SIZE = 4096;
        cache = makeCache(4096);
    }
    
    public static Integer valueOf(final int llllllllllllllIlIlllllIIllIlIIII) {
        return (llllllllllllllIlIlllllIIllIlIIII >= 0 && llllllllllllllIlIlllllIIllIlIIII < 4096) ? IntegerCache.cache[llllllllllllllIlIlllllIIllIlIIII] : new Integer(llllllllllllllIlIlllllIIllIlIIII);
    }
}
