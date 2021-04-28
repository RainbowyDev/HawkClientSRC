package net.minecraft.world.gen.layer;

import com.google.common.collect.*;
import java.util.*;

public class IntCache
{
    private static /* synthetic */ List freeLargeArrays;
    private static /* synthetic */ int intCacheSize;
    private static /* synthetic */ List inUseSmallArrays;
    private static /* synthetic */ List inUseLargeArrays;
    private static /* synthetic */ List freeSmallArrays;
    
    public static synchronized int[] getIntCache(final int llllllllllllllIIlIlllIlIlIIIIIlI) {
        if (llllllllllllllIIlIlllIlIlIIIIIlI <= 256) {
            if (IntCache.freeSmallArrays.isEmpty()) {
                final int[] llllllllllllllIIlIlllIlIlIIIIlll = new int[256];
                IntCache.inUseSmallArrays.add(llllllllllllllIIlIlllIlIlIIIIlll);
                return llllllllllllllIIlIlllIlIlIIIIlll;
            }
            final int[] llllllllllllllIIlIlllIlIlIIIIllI = IntCache.freeSmallArrays.remove(IntCache.freeSmallArrays.size() - 1);
            IntCache.inUseSmallArrays.add(llllllllllllllIIlIlllIlIlIIIIllI);
            return llllllllllllllIIlIlllIlIlIIIIllI;
        }
        else {
            if (llllllllllllllIIlIlllIlIlIIIIIlI > IntCache.intCacheSize) {
                IntCache.intCacheSize = llllllllllllllIIlIlllIlIlIIIIIlI;
                IntCache.freeLargeArrays.clear();
                IntCache.inUseLargeArrays.clear();
                final int[] llllllllllllllIIlIlllIlIlIIIIlIl = new int[IntCache.intCacheSize];
                IntCache.inUseLargeArrays.add(llllllllllllllIIlIlllIlIlIIIIlIl);
                return llllllllllllllIIlIlllIlIlIIIIlIl;
            }
            if (IntCache.freeLargeArrays.isEmpty()) {
                final int[] llllllllllllllIIlIlllIlIlIIIIlII = new int[IntCache.intCacheSize];
                IntCache.inUseLargeArrays.add(llllllllllllllIIlIlllIlIlIIIIlII);
                return llllllllllllllIIlIlllIlIlIIIIlII;
            }
            final int[] llllllllllllllIIlIlllIlIlIIIIIll = IntCache.freeLargeArrays.remove(IntCache.freeLargeArrays.size() - 1);
            IntCache.inUseLargeArrays.add(llllllllllllllIIlIlllIlIlIIIIIll);
            return llllllllllllllIIlIlllIlIlIIIIIll;
        }
    }
    
    public static synchronized String getCacheSizes() {
        return String.valueOf(new StringBuilder("cache: ").append(IntCache.freeLargeArrays.size()).append(", tcache: ").append(IntCache.freeSmallArrays.size()).append(", allocated: ").append(IntCache.inUseLargeArrays.size()).append(", tallocated: ").append(IntCache.inUseSmallArrays.size()));
    }
    
    static {
        __OBFID = "CL_00000557";
        IntCache.intCacheSize = 256;
        IntCache.freeSmallArrays = Lists.newArrayList();
        IntCache.inUseSmallArrays = Lists.newArrayList();
        IntCache.freeLargeArrays = Lists.newArrayList();
        IntCache.inUseLargeArrays = Lists.newArrayList();
    }
    
    public static synchronized void resetIntCache() {
        if (!IntCache.freeLargeArrays.isEmpty()) {
            IntCache.freeLargeArrays.remove(IntCache.freeLargeArrays.size() - 1);
        }
        if (!IntCache.freeSmallArrays.isEmpty()) {
            IntCache.freeSmallArrays.remove(IntCache.freeSmallArrays.size() - 1);
        }
        IntCache.freeLargeArrays.addAll(IntCache.inUseLargeArrays);
        IntCache.freeSmallArrays.addAll(IntCache.inUseSmallArrays);
        IntCache.inUseLargeArrays.clear();
        IntCache.inUseSmallArrays.clear();
    }
}
