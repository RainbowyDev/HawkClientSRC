package net.minecraft.world.chunk.storage;

import java.util.*;
import java.io.*;
import com.google.common.collect.*;

public class RegionFileCache
{
    private static final /* synthetic */ Map regionsByFilename;
    
    public static DataOutputStream getChunkOutputStream(final File lIllIIIIlIIllI, final int lIllIIIIlIIlIl, final int lIllIIIIlIlIII) {
        final RegionFile lIllIIIIlIIlll = createOrLoadRegionFile(lIllIIIIlIIllI, lIllIIIIlIIlIl, lIllIIIIlIlIII);
        return lIllIIIIlIIlll.getChunkDataOutputStream(lIllIIIIlIIlIl & 0x1F, lIllIIIIlIlIII & 0x1F);
    }
    
    public static synchronized void clearRegionFileReferences() {
        for (final RegionFile lIllIIIIllllll : RegionFileCache.regionsByFilename.values()) {
            try {
                if (lIllIIIIllllll == null) {
                    continue;
                }
                lIllIIIIllllll.close();
            }
            catch (IOException lIllIIIIlllllI) {
                lIllIIIIlllllI.printStackTrace();
            }
        }
        RegionFileCache.regionsByFilename.clear();
    }
    
    public static synchronized RegionFile createOrLoadRegionFile(final File lIllIIIlIIlIlI, final int lIllIIIlIIlIIl, final int lIllIIIlIIllll) {
        final File lIllIIIlIIlllI = new File(lIllIIIlIIlIlI, "region");
        final File lIllIIIlIIllIl = new File(lIllIIIlIIlllI, String.valueOf(new StringBuilder("r.").append(lIllIIIlIIlIIl >> 5).append(".").append(lIllIIIlIIllll >> 5).append(".mca")));
        final RegionFile lIllIIIlIIllII = RegionFileCache.regionsByFilename.get(lIllIIIlIIllIl);
        if (lIllIIIlIIllII != null) {
            return lIllIIIlIIllII;
        }
        if (!lIllIIIlIIlllI.exists()) {
            lIllIIIlIIlllI.mkdirs();
        }
        if (RegionFileCache.regionsByFilename.size() >= 256) {
            clearRegionFileReferences();
        }
        final RegionFile lIllIIIlIIlIll = new RegionFile(lIllIIIlIIllIl);
        RegionFileCache.regionsByFilename.put(lIllIIIlIIllIl, lIllIIIlIIlIll);
        return lIllIIIlIIlIll;
    }
    
    public static DataInputStream getChunkInputStream(final File lIllIIIIllIIlI, final int lIllIIIIllIlIl, final int lIllIIIIllIlII) {
        final RegionFile lIllIIIIllIIll = createOrLoadRegionFile(lIllIIIIllIIlI, lIllIIIIllIlIl, lIllIIIIllIlII);
        return lIllIIIIllIIll.getChunkDataInputStream(lIllIIIIllIlIl & 0x1F, lIllIIIIllIlII & 0x1F);
    }
    
    static {
        __OBFID = "CL_00000383";
        regionsByFilename = Maps.newHashMap();
    }
}
