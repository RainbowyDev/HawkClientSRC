package net.minecraft.client.multiplayer;

import net.minecraft.entity.*;
import org.apache.logging.log4j.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.world.chunk.*;
import java.util.*;

public class ChunkProviderClient implements IChunkProvider
{
    private /* synthetic */ List chunkListing;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ Chunk blankChunk;
    private /* synthetic */ World worldObj;
    private /* synthetic */ LongHashMap chunkMapping;
    
    @Override
    public int getLoadedChunkCount() {
        return this.chunkListing.size();
    }
    
    @Override
    public List func_177458_a(final EnumCreatureType llllllllllllllIIIIllIlIIllIllIll, final BlockPos llllllllllllllIIIIllIlIIllIllIlI) {
        return null;
    }
    
    @Override
    public boolean func_177460_a(final IChunkProvider llllllllllllllIIIIllIlIIlllIIIll, final Chunk llllllllllllllIIIIllIlIIlllIIIlI, final int llllllllllllllIIIIllIlIIlllIIIIl, final int llllllllllllllIIIIllIlIIlllIIIII) {
        return false;
    }
    
    @Override
    public void populate(final IChunkProvider llllllllllllllIIIIllIlIIlllIIlll, final int llllllllllllllIIIIllIlIIlllIIllI, final int llllllllllllllIIIIllIlIIlllIIlIl) {
    }
    
    @Override
    public boolean canSave() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000880";
        logger = LogManager.getLogger();
    }
    
    @Override
    public void saveExtraData() {
    }
    
    @Override
    public Chunk provideChunk(final int llllllllllllllIIIIllIlIIllllllII, final int llllllllllllllIIIIllIlIIllllllll) {
        final Chunk llllllllllllllIIIIllIlIIlllllllI = (Chunk)this.chunkMapping.getValueByKey(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIIIllIlIIllllllII, llllllllllllllIIIIllIlIIllllllll));
        return (llllllllllllllIIIIllIlIIlllllllI == null) ? this.blankChunk : llllllllllllllIIIIllIlIIlllllllI;
    }
    
    @Override
    public boolean saveChunks(final boolean llllllllllllllIIIIllIlIIlllllIII, final IProgressUpdate llllllllllllllIIIIllIlIIllllIlll) {
        return true;
    }
    
    public ChunkProviderClient(final World llllllllllllllIIIIllIlIlIIlIIIll) {
        this.chunkMapping = new LongHashMap();
        this.chunkListing = Lists.newArrayList();
        this.blankChunk = new EmptyChunk(llllllllllllllIIIIllIlIlIIlIIIll, 0, 0);
        this.worldObj = llllllllllllllIIIIllIlIlIIlIIIll;
    }
    
    @Override
    public Chunk func_177459_a(final BlockPos llllllllllllllIIIIllIlIIllIIlIll) {
        return this.provideChunk(llllllllllllllIIIIllIlIIllIIlIll.getX() >> 4, llllllllllllllIIIIllIlIIllIIlIll.getZ() >> 4);
    }
    
    public Chunk loadChunk(final int llllllllllllllIIIIllIlIlIIIIlIII, final int llllllllllllllIIIIllIlIlIIIIlIll) {
        final Chunk llllllllllllllIIIIllIlIlIIIIlIlI = new Chunk(this.worldObj, llllllllllllllIIIIllIlIlIIIIlIII, llllllllllllllIIIIllIlIlIIIIlIll);
        this.chunkMapping.add(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIIIllIlIlIIIIlIII, llllllllllllllIIIIllIlIlIIIIlIll), llllllllllllllIIIIllIlIlIIIIlIlI);
        this.chunkListing.add(llllllllllllllIIIIllIlIlIIIIlIlI);
        llllllllllllllIIIIllIlIlIIIIlIlI.func_177417_c(true);
        return llllllllllllllIIIIllIlIlIIIIlIlI;
    }
    
    @Override
    public String makeString() {
        return String.valueOf(new StringBuilder("MultiplayerChunkCache: ").append(this.chunkMapping.getNumHashElements()).append(", ").append(this.chunkListing.size()));
    }
    
    @Override
    public void func_180514_a(final Chunk llllllllllllllIIIIllIlIIllIlIIIl, final int llllllllllllllIIIIllIlIIllIlIIII, final int llllllllllllllIIIIllIlIIllIIllll) {
    }
    
    public void unloadChunk(final int llllllllllllllIIIIllIlIlIIIllIII, final int llllllllllllllIIIIllIlIlIIIlIlll) {
        final Chunk llllllllllllllIIIIllIlIlIIIlIllI = this.provideChunk(llllllllllllllIIIIllIlIlIIIllIII, llllllllllllllIIIIllIlIlIIIlIlll);
        if (!llllllllllllllIIIIllIlIlIIIlIllI.isEmpty()) {
            llllllllllllllIIIIllIlIlIIIlIllI.onChunkUnload();
        }
        this.chunkMapping.remove(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIIIllIlIlIIIllIII, llllllllllllllIIIIllIlIlIIIlIlll));
        this.chunkListing.remove(llllllllllllllIIIIllIlIlIIIlIllI);
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        final long llllllllllllllIIIIllIlIIllllIIII = System.currentTimeMillis();
        for (final Chunk llllllllllllllIIIIllIlIIlllIlllI : this.chunkListing) {
            llllllllllllllIIIIllIlIIlllIlllI.func_150804_b(System.currentTimeMillis() - llllllllllllllIIIIllIlIIllllIIII > 5L);
        }
        if (System.currentTimeMillis() - llllllllllllllIIIIllIlIIllllIIII > 100L) {
            ChunkProviderClient.logger.info("Warning: Clientside chunk ticking took {} ms", new Object[] { System.currentTimeMillis() - llllllllllllllIIIIllIlIIllllIIII });
        }
        return false;
    }
    
    @Override
    public BlockPos func_180513_a(final World llllllllllllllIIIIllIlIIllIllIII, final String llllllllllllllIIIIllIlIIllIlIlll, final BlockPos llllllllllllllIIIIllIlIIllIlIllI) {
        return null;
    }
    
    @Override
    public boolean chunkExists(final int llllllllllllllIIIIllIlIlIIIlllll, final int llllllllllllllIIIIllIlIlIIIllllI) {
        return true;
    }
}
