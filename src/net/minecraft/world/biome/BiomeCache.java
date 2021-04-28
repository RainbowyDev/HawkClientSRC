package net.minecraft.world.biome;

import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.server.*;

public class BiomeCache
{
    private /* synthetic */ long lastCleanupTime;
    private /* synthetic */ List cache;
    private final /* synthetic */ WorldChunkManager chunkManager;
    private /* synthetic */ LongHashMap cacheMap;
    
    public BiomeCache(final WorldChunkManager lllllllllllllllllIlIIIIlIIllIlIl) {
        this.cacheMap = new LongHashMap();
        this.cache = Lists.newArrayList();
        this.chunkManager = lllllllllllllllllIlIIIIlIIllIlIl;
    }
    
    static {
        __OBFID = "CL_00000162";
    }
    
    public Block getBiomeCacheBlock(int lllllllllllllllllIlIIIIlIIlIlIIl, int lllllllllllllllllIlIIIIlIIlIlIII) {
        lllllllllllllllllIlIIIIlIIlIlIIl >>= 4;
        lllllllllllllllllIlIIIIlIIlIlIII >>= 4;
        final long lllllllllllllllllIlIIIIlIIlIllII = ((long)lllllllllllllllllIlIIIIlIIlIlIIl & 0xFFFFFFFFL) | ((long)lllllllllllllllllIlIIIIlIIlIlIII & 0xFFFFFFFFL) << 32;
        Block lllllllllllllllllIlIIIIlIIlIlIll = (Block)this.cacheMap.getValueByKey(lllllllllllllllllIlIIIIlIIlIllII);
        if (lllllllllllllllllIlIIIIlIIlIlIll == null) {
            lllllllllllllllllIlIIIIlIIlIlIll = new Block((int)lllllllllllllllllIlIIIIlIIlIlIIl, lllllllllllllllllIlIIIIlIIlIlIII);
            this.cacheMap.add(lllllllllllllllllIlIIIIlIIlIllII, lllllllllllllllllIlIIIIlIIlIlIll);
            this.cache.add(lllllllllllllllllIlIIIIlIIlIlIll);
        }
        lllllllllllllllllIlIIIIlIIlIlIll.lastAccessTime = MinecraftServer.getCurrentTimeMillis();
        return lllllllllllllllllIlIIIIlIIlIlIll;
    }
    
    public BiomeGenBase[] getCachedBiomes(final int lllllllllllllllllIlIIIIIlllllIlI, final int lllllllllllllllllIlIIIIIllllIllI) {
        return this.getBiomeCacheBlock(lllllllllllllllllIlIIIIIlllllIlI, lllllllllllllllllIlIIIIIllllIllI).biomes;
    }
    
    public void cleanupCache() {
        final long lllllllllllllllllIlIIIIlIIIIlllI = MinecraftServer.getCurrentTimeMillis();
        final long lllllllllllllllllIlIIIIlIIIIllIl = lllllllllllllllllIlIIIIlIIIIlllI - this.lastCleanupTime;
        if (lllllllllllllllllIlIIIIlIIIIllIl > 7500L || lllllllllllllllllIlIIIIlIIIIllIl < 0L) {
            this.lastCleanupTime = lllllllllllllllllIlIIIIlIIIIlllI;
            for (int lllllllllllllllllIlIIIIlIIIIllII = 0; lllllllllllllllllIlIIIIlIIIIllII < this.cache.size(); ++lllllllllllllllllIlIIIIlIIIIllII) {
                final Block lllllllllllllllllIlIIIIlIIIIlIll = this.cache.get(lllllllllllllllllIlIIIIlIIIIllII);
                final long lllllllllllllllllIlIIIIlIIIIlIlI = lllllllllllllllllIlIIIIlIIIIlllI - lllllllllllllllllIlIIIIlIIIIlIll.lastAccessTime;
                if (lllllllllllllllllIlIIIIlIIIIlIlI > 30000L || lllllllllllllllllIlIIIIlIIIIlIlI < 0L) {
                    this.cache.remove(lllllllllllllllllIlIIIIlIIIIllII--);
                    final long lllllllllllllllllIlIIIIlIIIIlIIl = ((long)lllllllllllllllllIlIIIIlIIIIlIll.xPosition & 0xFFFFFFFFL) | ((long)lllllllllllllllllIlIIIIlIIIIlIll.zPosition & 0xFFFFFFFFL) << 32;
                    this.cacheMap.remove(lllllllllllllllllIlIIIIlIIIIlIIl);
                }
            }
        }
    }
    
    public BiomeGenBase func_180284_a(final int lllllllllllllllllIlIIIIlIIIllIlI, final int lllllllllllllllllIlIIIIlIIIllllI, final BiomeGenBase lllllllllllllllllIlIIIIlIIIlllIl) {
        final BiomeGenBase lllllllllllllllllIlIIIIlIIIlllII = this.getBiomeCacheBlock(lllllllllllllllllIlIIIIlIIIllIlI, lllllllllllllllllIlIIIIlIIIllllI).getBiomeGenAt(lllllllllllllllllIlIIIIlIIIllIlI, lllllllllllllllllIlIIIIlIIIllllI);
        return (lllllllllllllllllIlIIIIlIIIlllII == null) ? lllllllllllllllllIlIIIIlIIIlllIl : lllllllllllllllllIlIIIIlIIIlllII;
    }
    
    public class Block
    {
        public /* synthetic */ int zPosition;
        public /* synthetic */ long lastAccessTime;
        public /* synthetic */ float[] rainfallValues;
        public /* synthetic */ BiomeGenBase[] biomes;
        public /* synthetic */ int xPosition;
        
        public Block(final int lllllllllllllllllllIlIlllIlIlllI, final int lllllllllllllllllllIlIlllIllIIIl) {
            this.rainfallValues = new float[256];
            this.biomes = new BiomeGenBase[256];
            this.xPosition = lllllllllllllllllllIlIlllIlIlllI;
            this.zPosition = lllllllllllllllllllIlIlllIllIIIl;
            BiomeCache.this.chunkManager.getRainfall(this.rainfallValues, lllllllllllllllllllIlIlllIlIlllI << 4, lllllllllllllllllllIlIlllIllIIIl << 4, 16, 16);
            BiomeCache.this.chunkManager.getBiomeGenAt(this.biomes, lllllllllllllllllllIlIlllIlIlllI << 4, lllllllllllllllllllIlIlllIllIIIl << 4, 16, 16, false);
        }
        
        public BiomeGenBase getBiomeGenAt(final int lllllllllllllllllllIlIlllIlIlIII, final int lllllllllllllllllllIlIlllIlIIlII) {
            return this.biomes[(lllllllllllllllllllIlIlllIlIlIII & 0xF) | (lllllllllllllllllllIlIlllIlIIlII & 0xF) << 4];
        }
        
        static {
            __OBFID = "CL_00000163";
        }
    }
}
