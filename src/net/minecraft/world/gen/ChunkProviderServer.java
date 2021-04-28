package net.minecraft.world.gen;

import net.minecraft.world.chunk.storage.*;
import org.apache.logging.log4j.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import net.minecraft.world.chunk.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;

public class ChunkProviderServer implements IChunkProvider
{
    private /* synthetic */ IChunkProvider serverChunkGenerator;
    private /* synthetic */ WorldServer worldObj;
    public /* synthetic */ boolean chunkLoadOverride;
    private /* synthetic */ IChunkLoader chunkLoader;
    private /* synthetic */ LongHashMap id2ChunkMap;
    private /* synthetic */ List loadedChunks;
    private /* synthetic */ Set droppedChunksSet;
    private /* synthetic */ Chunk dummyChunk;
    private static final /* synthetic */ Logger logger;
    
    static {
        __OBFID = "CL_00001436";
        logger = LogManager.getLogger();
    }
    
    @Override
    public void func_180514_a(final Chunk lllllllllllllllIIlllIlllIlIIllII, final int lllllllllllllllIIlllIlllIlIIlIll, final int lllllllllllllllIIlllIlllIlIIlIlI) {
    }
    
    private Chunk loadChunkFromFile(final int lllllllllllllllIIlllIlllllIIIIIl, final int lllllllllllllllIIlllIlllllIIIlIl) {
        if (this.chunkLoader == null) {
            return null;
        }
        try {
            final Chunk lllllllllllllllIIlllIlllllIIIlII = this.chunkLoader.loadChunk(this.worldObj, lllllllllllllllIIlllIlllllIIIIIl, lllllllllllllllIIlllIlllllIIIlIl);
            if (lllllllllllllllIIlllIlllllIIIlII != null) {
                lllllllllllllllIIlllIlllllIIIlII.setLastSaveTime(this.worldObj.getTotalWorldTime());
                if (this.serverChunkGenerator != null) {
                    this.serverChunkGenerator.func_180514_a(lllllllllllllllIIlllIlllllIIIlII, lllllllllllllllIIlllIlllllIIIIIl, lllllllllllllllIIlllIlllllIIIlIl);
                }
            }
            return lllllllllllllllIIlllIlllllIIIlII;
        }
        catch (Exception lllllllllllllllIIlllIlllllIIIIll) {
            ChunkProviderServer.logger.error("Couldn't load chunk", (Throwable)lllllllllllllllIIlllIlllllIIIIll);
            return null;
        }
    }
    
    @Override
    public boolean chunkExists(final int lllllllllllllllIIllllIIIIIIIIllI, final int lllllllllllllllIIllllIIIIIIIlIII) {
        return this.id2ChunkMap.containsItem(ChunkCoordIntPair.chunkXZ2Int(lllllllllllllllIIllllIIIIIIIIllI, lllllllllllllllIIllllIIIIIIIlIII));
    }
    
    public List func_152380_a() {
        return this.loadedChunks;
    }
    
    public ChunkProviderServer(final WorldServer lllllllllllllllIIllllIIIIIIlIIII, final IChunkLoader lllllllllllllllIIllllIIIIIIlIIll, final IChunkProvider lllllllllllllllIIllllIIIIIIIlllI) {
        this.droppedChunksSet = Collections.newSetFromMap(new ConcurrentHashMap<Object, Boolean>());
        this.chunkLoadOverride = true;
        this.id2ChunkMap = new LongHashMap();
        this.loadedChunks = Lists.newArrayList();
        this.dummyChunk = new EmptyChunk(lllllllllllllllIIllllIIIIIIlIIII, 0, 0);
        this.worldObj = lllllllllllllllIIllllIIIIIIlIIII;
        this.chunkLoader = lllllllllllllllIIllllIIIIIIlIIll;
        this.serverChunkGenerator = lllllllllllllllIIllllIIIIIIIlllI;
    }
    
    public Chunk loadChunk(final int lllllllllllllllIIlllIllllllIIllI, final int lllllllllllllllIIlllIlllllIlllIl) {
        final long lllllllllllllllIIlllIllllllIIlII = ChunkCoordIntPair.chunkXZ2Int(lllllllllllllllIIlllIllllllIIllI, lllllllllllllllIIlllIlllllIlllIl);
        this.droppedChunksSet.remove(lllllllllllllllIIlllIllllllIIlII);
        Chunk lllllllllllllllIIlllIllllllIIIll = (Chunk)this.id2ChunkMap.getValueByKey(lllllllllllllllIIlllIllllllIIlII);
        if (lllllllllllllllIIlllIllllllIIIll == null) {
            lllllllllllllllIIlllIllllllIIIll = this.loadChunkFromFile(lllllllllllllllIIlllIllllllIIllI, lllllllllllllllIIlllIlllllIlllIl);
            if (lllllllllllllllIIlllIllllllIIIll == null) {
                if (this.serverChunkGenerator == null) {
                    lllllllllllllllIIlllIllllllIIIll = this.dummyChunk;
                }
                else {
                    try {
                        lllllllllllllllIIlllIllllllIIIll = this.serverChunkGenerator.provideChunk(lllllllllllllllIIlllIllllllIIllI, lllllllllllllllIIlllIlllllIlllIl);
                    }
                    catch (Throwable lllllllllllllllIIlllIllllllIIIlI) {
                        final CrashReport lllllllllllllllIIlllIllllllIIIIl = CrashReport.makeCrashReport(lllllllllllllllIIlllIllllllIIIlI, "Exception generating new chunk");
                        final CrashReportCategory lllllllllllllllIIlllIllllllIIIII = lllllllllllllllIIlllIllllllIIIIl.makeCategory("Chunk to be generated");
                        lllllllllllllllIIlllIllllllIIIII.addCrashSection("Location", String.format("%d,%d", lllllllllllllllIIlllIllllllIIllI, lllllllllllllllIIlllIlllllIlllIl));
                        lllllllllllllllIIlllIllllllIIIII.addCrashSection("Position hash", lllllllllllllllIIlllIllllllIIlII);
                        lllllllllllllllIIlllIllllllIIIII.addCrashSection("Generator", this.serverChunkGenerator.makeString());
                        throw new ReportedException(lllllllllllllllIIlllIllllllIIIIl);
                    }
                }
            }
            this.id2ChunkMap.add(lllllllllllllllIIlllIllllllIIlII, lllllllllllllllIIlllIllllllIIIll);
            this.loadedChunks.add(lllllllllllllllIIlllIllllllIIIll);
            lllllllllllllllIIlllIllllllIIIll.onChunkLoad();
            lllllllllllllllIIlllIllllllIIIll.populateChunk(this, this, lllllllllllllllIIlllIllllllIIllI, lllllllllllllllIIlllIlllllIlllIl);
        }
        return lllllllllllllllIIlllIllllllIIIll;
    }
    
    @Override
    public int getLoadedChunkCount() {
        return this.id2ChunkMap.getNumHashElements();
    }
    
    private void saveChunkExtraData(final Chunk lllllllllllllllIIlllIllllIlllIlI) {
        if (this.chunkLoader != null) {
            try {
                this.chunkLoader.saveExtraChunkData(this.worldObj, lllllllllllllllIIlllIllllIlllIlI);
            }
            catch (Exception lllllllllllllllIIlllIllllIlllIIl) {
                ChunkProviderServer.logger.error("Couldn't save entities", (Throwable)lllllllllllllllIIlllIllllIlllIIl);
            }
        }
    }
    
    @Override
    public void saveExtraData() {
        if (this.chunkLoader != null) {
            this.chunkLoader.saveExtraData();
        }
    }
    
    @Override
    public Chunk func_177459_a(final BlockPos lllllllllllllllIIlllIlllIlIIIllI) {
        return this.provideChunk(lllllllllllllllIIlllIlllIlIIIllI.getX() >> 4, lllllllllllllllIIlllIlllIlIIIllI.getZ() >> 4);
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllIIlllIlllllIIlllI, final int lllllllllllllllIIlllIlllllIlIIIl) {
        final Chunk lllllllllllllllIIlllIlllllIlIIII = (Chunk)this.id2ChunkMap.getValueByKey(ChunkCoordIntPair.chunkXZ2Int(lllllllllllllllIIlllIlllllIIlllI, lllllllllllllllIIlllIlllllIlIIIl));
        return (lllllllllllllllIIlllIlllllIlIIII == null) ? ((!this.worldObj.isFindingSpawnPoint() && !this.chunkLoadOverride) ? this.dummyChunk : this.loadChunk(lllllllllllllllIIlllIlllllIIlllI, lllllllllllllllIIlllIlllllIlIIIl)) : lllllllllllllllIIlllIlllllIlIIII;
    }
    
    @Override
    public void populate(final IChunkProvider lllllllllllllllIIlllIllllIlIIIII, final int lllllllllllllllIIlllIllllIIlllll, final int lllllllllllllllIIlllIllllIIllllI) {
        final Chunk lllllllllllllllIIlllIllllIlIIIlI = this.provideChunk(lllllllllllllllIIlllIllllIIlllll, lllllllllllllllIIlllIllllIIllllI);
        if (!lllllllllllllllIIlllIllllIlIIIlI.isTerrainPopulated()) {
            lllllllllllllllIIlllIllllIlIIIlI.func_150809_p();
            if (this.serverChunkGenerator != null) {
                this.serverChunkGenerator.populate(lllllllllllllllIIlllIllllIlIIIII, lllllllllllllllIIlllIllllIIlllll, lllllllllllllllIIlllIllllIIllllI);
                lllllllllllllllIIlllIllllIlIIIlI.setChunkModified();
            }
        }
    }
    
    @Override
    public boolean saveChunks(final boolean lllllllllllllllIIlllIllllIIIIlII, final IProgressUpdate lllllllllllllllIIlllIllllIIIIIll) {
        int lllllllllllllllIIlllIllllIIIIIlI = 0;
        for (int lllllllllllllllIIlllIllllIIIIIIl = 0; lllllllllllllllIIlllIllllIIIIIIl < this.loadedChunks.size(); ++lllllllllllllllIIlllIllllIIIIIIl) {
            final Chunk lllllllllllllllIIlllIllllIIIIIII = this.loadedChunks.get(lllllllllllllllIIlllIllllIIIIIIl);
            if (lllllllllllllllIIlllIllllIIIIlII) {
                this.saveChunkExtraData(lllllllllllllllIIlllIllllIIIIIII);
            }
            if (lllllllllllllllIIlllIllllIIIIIII.needsSaving(lllllllllllllllIIlllIllllIIIIlII)) {
                this.saveChunkData(lllllllllllllllIIlllIllllIIIIIII);
                lllllllllllllllIIlllIllllIIIIIII.setModified(false);
                if (++lllllllllllllllIIlllIllllIIIIIlI == 24 && !lllllllllllllllIIlllIllllIIIIlII) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void saveChunkData(final Chunk lllllllllllllllIIlllIllllIlIllIl) {
        if (this.chunkLoader != null) {
            try {
                lllllllllllllllIIlllIllllIlIllIl.setLastSaveTime(this.worldObj.getTotalWorldTime());
                this.chunkLoader.saveChunk(this.worldObj, lllllllllllllllIIlllIllllIlIllIl);
            }
            catch (IOException lllllllllllllllIIlllIllllIllIIII) {
                ChunkProviderServer.logger.error("Couldn't save chunk", (Throwable)lllllllllllllllIIlllIllllIllIIII);
            }
            catch (MinecraftException lllllllllllllllIIlllIllllIlIllll) {
                ChunkProviderServer.logger.error("Couldn't save chunk; already in use by another instance of Minecraft?", (Throwable)lllllllllllllllIIlllIllllIlIllll);
            }
        }
    }
    
    @Override
    public String makeString() {
        return String.valueOf(new StringBuilder("ServerChunkCache: ").append(this.id2ChunkMap.getNumHashElements()).append(" Drop: ").append(this.droppedChunksSet.size()));
    }
    
    @Override
    public List func_177458_a(final EnumCreatureType lllllllllllllllIIlllIlllIllIIIIl, final BlockPos lllllllllllllllIIlllIlllIllIIIII) {
        return this.serverChunkGenerator.func_177458_a(lllllllllllllllIIlllIlllIllIIIIl, lllllllllllllllIIlllIlllIllIIIII);
    }
    
    public void unloadAllChunks() {
        for (final Chunk lllllllllllllllIIlllIlllllllIIll : this.loadedChunks) {
            this.dropChunk(lllllllllllllllIIlllIlllllllIIll.xPosition, lllllllllllllllIIlllIlllllllIIll.zPosition);
        }
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        if (!this.worldObj.disableLevelSaving) {
            for (int lllllllllllllllIIlllIlllIlllIIlI = 0; lllllllllllllllIIlllIlllIlllIIlI < 100; ++lllllllllllllllIIlllIlllIlllIIlI) {
                if (!this.droppedChunksSet.isEmpty()) {
                    final Long lllllllllllllllIIlllIlllIlllIIIl = this.droppedChunksSet.iterator().next();
                    final Chunk lllllllllllllllIIlllIlllIlllIIII = (Chunk)this.id2ChunkMap.getValueByKey(lllllllllllllllIIlllIlllIlllIIIl);
                    if (lllllllllllllllIIlllIlllIlllIIII != null) {
                        lllllllllllllllIIlllIlllIlllIIII.onChunkUnload();
                        this.saveChunkData(lllllllllllllllIIlllIlllIlllIIII);
                        this.saveChunkExtraData(lllllllllllllllIIlllIlllIlllIIII);
                        this.id2ChunkMap.remove(lllllllllllllllIIlllIlllIlllIIIl);
                        this.loadedChunks.remove(lllllllllllllllIIlllIlllIlllIIII);
                    }
                    this.droppedChunksSet.remove(lllllllllllllllIIlllIlllIlllIIIl);
                }
            }
            if (this.chunkLoader != null) {
                this.chunkLoader.chunkTick();
            }
        }
        return this.serverChunkGenerator.unloadQueuedChunks();
    }
    
    @Override
    public boolean func_177460_a(final IChunkProvider lllllllllllllllIIlllIllllIIIllll, final Chunk lllllllllllllllIIlllIllllIIIlllI, final int lllllllllllllllIIlllIllllIIIllIl, final int lllllllllllllllIIlllIllllIIIllII) {
        if (this.serverChunkGenerator != null && this.serverChunkGenerator.func_177460_a(lllllllllllllllIIlllIllllIIIllll, lllllllllllllllIIlllIllllIIIlllI, lllllllllllllllIIlllIllllIIIllIl, lllllllllllllllIIlllIllllIIIllII)) {
            final Chunk lllllllllllllllIIlllIllllIIlIIIl = this.provideChunk(lllllllllllllllIIlllIllllIIIllIl, lllllllllllllllIIlllIllllIIIllII);
            lllllllllllllllIIlllIllllIIlIIIl.setChunkModified();
            return true;
        }
        return false;
    }
    
    public void dropChunk(final int lllllllllllllllIIlllIllllllllIlI, final int lllllllllllllllIIlllIlllllllllII) {
        if (this.worldObj.provider.canRespawnHere()) {
            if (!this.worldObj.chunkExists(lllllllllllllllIIlllIllllllllIlI, lllllllllllllllIIlllIlllllllllII)) {
                this.droppedChunksSet.add(ChunkCoordIntPair.chunkXZ2Int(lllllllllllllllIIlllIllllllllIlI, lllllllllllllllIIlllIlllllllllII));
            }
        }
        else {
            this.droppedChunksSet.add(ChunkCoordIntPair.chunkXZ2Int(lllllllllllllllIIlllIllllllllIlI, lllllllllllllllIIlllIlllllllllII));
        }
    }
    
    @Override
    public BlockPos func_180513_a(final World lllllllllllllllIIlllIlllIlIlIlll, final String lllllllllllllllIIlllIlllIlIlIllI, final BlockPos lllllllllllllllIIlllIlllIlIlIIIl) {
        return this.serverChunkGenerator.func_180513_a(lllllllllllllllIIlllIlllIlIlIlll, lllllllllllllllIIlllIlllIlIlIllI, lllllllllllllllIIlllIlllIlIlIIIl);
    }
    
    @Override
    public boolean canSave() {
        return !this.worldObj.disableLevelSaving;
    }
}
