package net.minecraft.world.chunk.storage;

import java.io.*;
import net.minecraft.world.storage.*;
import net.minecraft.world.chunk.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import org.apache.logging.log4j.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;

public class AnvilChunkLoader implements IChunkLoader, IThreadedFileIO
{
    private /* synthetic */ List chunksToRemove;
    private /* synthetic */ Object syncLockObject;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ File chunkSaveLocation;
    private /* synthetic */ Set pendingAnvilChunksCoordinates;
    
    private void writeChunkNBTTags(final PendingChunk llllllllllllllllIIIllIlllIIlIIIl) throws IOException {
        final DataOutputStream llllllllllllllllIIIllIlllIIlIIll = RegionFileCache.getChunkOutputStream(this.chunkSaveLocation, llllllllllllllllIIIllIlllIIlIIIl.chunkCoordinate.chunkXPos, llllllllllllllllIIIllIlllIIlIIIl.chunkCoordinate.chunkZPos);
        CompressedStreamTools.write(llllllllllllllllIIIllIlllIIlIIIl.nbtTags, llllllllllllllllIIIllIlllIIlIIll);
        llllllllllllllllIIIllIlllIIlIIll.close();
    }
    
    @Override
    public Chunk loadChunk(final World llllllllllllllllIIIllIlllllIlIII, final int llllllllllllllllIIIllIlllllIIlll, final int llllllllllllllllIIIllIlllllIIllI) throws IOException {
        NBTTagCompound llllllllllllllllIIIllIlllllIIlIl = null;
        final ChunkCoordIntPair llllllllllllllllIIIllIlllllIIlII = new ChunkCoordIntPair(llllllllllllllllIIIllIlllllIIlll, llllllllllllllllIIIllIlllllIIllI);
        final Object llllllllllllllllIIIllIlllllIIIll = this.syncLockObject;
        synchronized (this.syncLockObject) {
            if (this.pendingAnvilChunksCoordinates.contains(llllllllllllllllIIIllIlllllIIlII)) {
                for (int llllllllllllllllIIIllIlllllIIIlI = 0; llllllllllllllllIIIllIlllllIIIlI < this.chunksToRemove.size(); ++llllllllllllllllIIIllIlllllIIIlI) {
                    if (this.chunksToRemove.get(llllllllllllllllIIIllIlllllIIIlI).chunkCoordinate.equals(llllllllllllllllIIIllIlllllIIlII)) {
                        llllllllllllllllIIIllIlllllIIlIl = this.chunksToRemove.get(llllllllllllllllIIIllIlllllIIIlI).nbtTags;
                        break;
                    }
                }
            }
        }
        // monitorexit(this.syncLockObject)
        if (llllllllllllllllIIIllIlllllIIlIl == null) {
            final DataInputStream llllllllllllllllIIIllIlllllIIIIl = RegionFileCache.getChunkInputStream(this.chunkSaveLocation, llllllllllllllllIIIllIlllllIIlll, llllllllllllllllIIIllIlllllIIllI);
            if (llllllllllllllllIIIllIlllllIIIIl == null) {
                return null;
            }
            llllllllllllllllIIIllIlllllIIlIl = CompressedStreamTools.read(llllllllllllllllIIIllIlllllIIIIl);
        }
        return this.checkedReadChunkFromNBT(llllllllllllllllIIIllIlllllIlIII, llllllllllllllllIIIllIlllllIIlll, llllllllllllllllIIIllIlllllIIllI, llllllllllllllllIIIllIlllllIIlIl);
    }
    
    @Override
    public void saveChunk(final World llllllllllllllllIIIllIlllIllllll, final Chunk llllllllllllllllIIIllIlllIlllIII) throws MinecraftException, IOException {
        llllllllllllllllIIIllIlllIllllll.checkSessionLock();
        try {
            final NBTTagCompound llllllllllllllllIIIllIlllIllllIl = new NBTTagCompound();
            final NBTTagCompound llllllllllllllllIIIllIlllIllllII = new NBTTagCompound();
            llllllllllllllllIIIllIlllIllllIl.setTag("Level", llllllllllllllllIIIllIlllIllllII);
            this.writeChunkToNBT(llllllllllllllllIIIllIlllIlllIII, llllllllllllllllIIIllIlllIllllll, llllllllllllllllIIIllIlllIllllII);
            this.addChunkToPending(llllllllllllllllIIIllIlllIlllIII.getChunkCoordIntPair(), llllllllllllllllIIIllIlllIllllIl);
        }
        catch (Exception llllllllllllllllIIIllIlllIlllIll) {
            llllllllllllllllIIIllIlllIlllIll.printStackTrace();
        }
    }
    
    protected void addChunkToPending(final ChunkCoordIntPair llllllllllllllllIIIllIlllIlIlllI, final NBTTagCompound llllllllllllllllIIIllIlllIlIllIl) {
        final Object llllllllllllllllIIIllIlllIlIllII = this.syncLockObject;
        synchronized (this.syncLockObject) {
            if (this.pendingAnvilChunksCoordinates.contains(llllllllllllllllIIIllIlllIlIlllI)) {
                for (int llllllllllllllllIIIllIlllIlIlIll = 0; llllllllllllllllIIIllIlllIlIlIll < this.chunksToRemove.size(); ++llllllllllllllllIIIllIlllIlIlIll) {
                    if (this.chunksToRemove.get(llllllllllllllllIIIllIlllIlIlIll).chunkCoordinate.equals(llllllllllllllllIIIllIlllIlIlllI)) {
                        this.chunksToRemove.set(llllllllllllllllIIIllIlllIlIlIll, new PendingChunk(llllllllllllllllIIIllIlllIlIlllI, llllllllllllllllIIIllIlllIlIllIl));
                        // monitorexit(this.syncLockObject)
                        return;
                    }
                }
            }
            this.chunksToRemove.add(new PendingChunk(llllllllllllllllIIIllIlllIlIlllI, llllllllllllllllIIIllIlllIlIllIl));
            this.pendingAnvilChunksCoordinates.add(llllllllllllllllIIIllIlllIlIlllI);
            ThreadedFileIOBase.func_178779_a().queueIO(this);
        }
        // monitorexit(this.syncLockObject)
    }
    
    private Chunk readChunkFromNBT(final World llllllllllllllllIIIllIllIIIIIIII, final NBTTagCompound llllllllllllllllIIIllIlIllllllll) {
        final int llllllllllllllllIIIllIllIIlIIlII = llllllllllllllllIIIllIlIllllllll.getInteger("xPos");
        final int llllllllllllllllIIIllIllIIlIIIll = llllllllllllllllIIIllIlIllllllll.getInteger("zPos");
        final Chunk llllllllllllllllIIIllIllIIlIIIlI = new Chunk(llllllllllllllllIIIllIllIIIIIIII, llllllllllllllllIIIllIllIIlIIlII, llllllllllllllllIIIllIllIIlIIIll);
        llllllllllllllllIIIllIllIIlIIIlI.setHeightMap(llllllllllllllllIIIllIlIllllllll.getIntArray("HeightMap"));
        llllllllllllllllIIIllIllIIlIIIlI.setTerrainPopulated(llllllllllllllllIIIllIlIllllllll.getBoolean("TerrainPopulated"));
        llllllllllllllllIIIllIllIIlIIIlI.setLightPopulated(llllllllllllllllIIIllIlIllllllll.getBoolean("LightPopulated"));
        llllllllllllllllIIIllIllIIlIIIlI.setInhabitedTime(llllllllllllllllIIIllIlIllllllll.getLong("InhabitedTime"));
        final NBTTagList llllllllllllllllIIIllIllIIlIIIIl = llllllllllllllllIIIllIlIllllllll.getTagList("Sections", 10);
        final byte llllllllllllllllIIIllIllIIlIIIII = 16;
        final ExtendedBlockStorage[] llllllllllllllllIIIllIllIIIlllll = new ExtendedBlockStorage[llllllllllllllllIIIllIllIIlIIIII];
        final boolean llllllllllllllllIIIllIllIIIllllI = !llllllllllllllllIIIllIllIIIIIIII.provider.getHasNoSky();
        for (int llllllllllllllllIIIllIllIIIlllIl = 0; llllllllllllllllIIIllIllIIIlllIl < llllllllllllllllIIIllIllIIlIIIIl.tagCount(); ++llllllllllllllllIIIllIllIIIlllIl) {
            final NBTTagCompound llllllllllllllllIIIllIllIIIlllII = llllllllllllllllIIIllIllIIlIIIIl.getCompoundTagAt(llllllllllllllllIIIllIllIIIlllIl);
            final byte llllllllllllllllIIIllIllIIIllIll = llllllllllllllllIIIllIllIIIlllII.getByte("Y");
            final ExtendedBlockStorage llllllllllllllllIIIllIllIIIllIlI = new ExtendedBlockStorage(llllllllllllllllIIIllIllIIIllIll << 4, llllllllllllllllIIIllIllIIIllllI);
            final byte[] llllllllllllllllIIIllIllIIIllIIl = llllllllllllllllIIIllIllIIIlllII.getByteArray("Blocks");
            final NibbleArray llllllllllllllllIIIllIllIIIllIII = new NibbleArray(llllllllllllllllIIIllIllIIIlllII.getByteArray("Data"));
            final NibbleArray llllllllllllllllIIIllIllIIIlIlll = llllllllllllllllIIIllIllIIIlllII.hasKey("Add", 7) ? new NibbleArray(llllllllllllllllIIIllIllIIIlllII.getByteArray("Add")) : null;
            final char[] llllllllllllllllIIIllIllIIIlIllI = new char[llllllllllllllllIIIllIllIIIllIIl.length];
            for (int llllllllllllllllIIIllIllIIIlIlIl = 0; llllllllllllllllIIIllIllIIIlIlIl < llllllllllllllllIIIllIllIIIlIllI.length; ++llllllllllllllllIIIllIllIIIlIlIl) {
                final int llllllllllllllllIIIllIllIIIlIlII = llllllllllllllllIIIllIllIIIlIlIl & 0xF;
                final int llllllllllllllllIIIllIllIIIlIIll = llllllllllllllllIIIllIllIIIlIlIl >> 8 & 0xF;
                final int llllllllllllllllIIIllIllIIIlIIlI = llllllllllllllllIIIllIllIIIlIlIl >> 4 & 0xF;
                final int llllllllllllllllIIIllIllIIIlIIIl = (llllllllllllllllIIIllIllIIIlIlll != null) ? llllllllllllllllIIIllIllIIIlIlll.get(llllllllllllllllIIIllIllIIIlIlII, llllllllllllllllIIIllIllIIIlIIll, llllllllllllllllIIIllIllIIIlIIlI) : 0;
                llllllllllllllllIIIllIllIIIlIllI[llllllllllllllllIIIllIllIIIlIlIl] = (char)(llllllllllllllllIIIllIllIIIlIIIl << 12 | (llllllllllllllllIIIllIllIIIllIIl[llllllllllllllllIIIllIllIIIlIlIl] & 0xFF) << 4 | llllllllllllllllIIIllIllIIIllIII.get(llllllllllllllllIIIllIllIIIlIlII, llllllllllllllllIIIllIllIIIlIIll, llllllllllllllllIIIllIllIIIlIIlI));
            }
            llllllllllllllllIIIllIllIIIllIlI.setData(llllllllllllllllIIIllIllIIIlIllI);
            llllllllllllllllIIIllIllIIIllIlI.setBlocklightArray(new NibbleArray(llllllllllllllllIIIllIllIIIlllII.getByteArray("BlockLight")));
            if (llllllllllllllllIIIllIllIIIllllI) {
                llllllllllllllllIIIllIllIIIllIlI.setSkylightArray(new NibbleArray(llllllllllllllllIIIllIllIIIlllII.getByteArray("SkyLight")));
            }
            llllllllllllllllIIIllIllIIIllIlI.removeInvalidBlocks();
            llllllllllllllllIIIllIllIIIlllll[llllllllllllllllIIIllIllIIIllIll] = llllllllllllllllIIIllIllIIIllIlI;
        }
        llllllllllllllllIIIllIllIIlIIIlI.setStorageArrays(llllllllllllllllIIIllIllIIIlllll);
        if (llllllllllllllllIIIllIlIllllllll.hasKey("Biomes", 7)) {
            llllllllllllllllIIIllIllIIlIIIlI.setBiomeArray(llllllllllllllllIIIllIlIllllllll.getByteArray("Biomes"));
        }
        final NBTTagList llllllllllllllllIIIllIllIIIlIIII = llllllllllllllllIIIllIlIllllllll.getTagList("Entities", 10);
        if (llllllllllllllllIIIllIllIIIlIIII != null) {
            for (int llllllllllllllllIIIllIllIIIIllll = 0; llllllllllllllllIIIllIllIIIIllll < llllllllllllllllIIIllIllIIIlIIII.tagCount(); ++llllllllllllllllIIIllIllIIIIllll) {
                final NBTTagCompound llllllllllllllllIIIllIllIIIIlllI = llllllllllllllllIIIllIllIIIlIIII.getCompoundTagAt(llllllllllllllllIIIllIllIIIIllll);
                final Entity llllllllllllllllIIIllIllIIIIllIl = EntityList.createEntityFromNBT(llllllllllllllllIIIllIllIIIIlllI, llllllllllllllllIIIllIllIIIIIIII);
                llllllllllllllllIIIllIllIIlIIIlI.setHasEntities(true);
                if (llllllllllllllllIIIllIllIIIIllIl != null) {
                    llllllllllllllllIIIllIllIIlIIIlI.addEntity(llllllllllllllllIIIllIllIIIIllIl);
                    Entity llllllllllllllllIIIllIllIIIIllII = llllllllllllllllIIIllIllIIIIllIl;
                    for (NBTTagCompound llllllllllllllllIIIllIllIIIIlIll = llllllllllllllllIIIllIllIIIIlllI; llllllllllllllllIIIllIllIIIIlIll.hasKey("Riding", 10); llllllllllllllllIIIllIllIIIIlIll = llllllllllllllllIIIllIllIIIIlIll.getCompoundTag("Riding")) {
                        final Entity llllllllllllllllIIIllIllIIIIlIlI = EntityList.createEntityFromNBT(llllllllllllllllIIIllIllIIIIlIll.getCompoundTag("Riding"), llllllllllllllllIIIllIllIIIIIIII);
                        if (llllllllllllllllIIIllIllIIIIlIlI != null) {
                            llllllllllllllllIIIllIllIIlIIIlI.addEntity(llllllllllllllllIIIllIllIIIIlIlI);
                            llllllllllllllllIIIllIllIIIIllII.mountEntity(llllllllllllllllIIIllIllIIIIlIlI);
                        }
                        llllllllllllllllIIIllIllIIIIllII = llllllllllllllllIIIllIllIIIIlIlI;
                    }
                }
            }
        }
        final NBTTagList llllllllllllllllIIIllIllIIIIlIIl = llllllllllllllllIIIllIlIllllllll.getTagList("TileEntities", 10);
        if (llllllllllllllllIIIllIllIIIIlIIl != null) {
            for (int llllllllllllllllIIIllIllIIIIlIII = 0; llllllllllllllllIIIllIllIIIIlIII < llllllllllllllllIIIllIllIIIIlIIl.tagCount(); ++llllllllllllllllIIIllIllIIIIlIII) {
                final NBTTagCompound llllllllllllllllIIIllIllIIIIIlll = llllllllllllllllIIIllIllIIIIlIIl.getCompoundTagAt(llllllllllllllllIIIllIllIIIIlIII);
                final TileEntity llllllllllllllllIIIllIllIIIIIllI = TileEntity.createAndLoadEntity(llllllllllllllllIIIllIllIIIIIlll);
                if (llllllllllllllllIIIllIllIIIIIllI != null) {
                    llllllllllllllllIIIllIllIIlIIIlI.addTileEntity(llllllllllllllllIIIllIllIIIIIllI);
                }
            }
        }
        if (llllllllllllllllIIIllIlIllllllll.hasKey("TileTicks", 9)) {
            final NBTTagList llllllllllllllllIIIllIllIIIIIlIl = llllllllllllllllIIIllIlIllllllll.getTagList("TileTicks", 10);
            if (llllllllllllllllIIIllIllIIIIIlIl != null) {
                for (int llllllllllllllllIIIllIllIIIIIlII = 0; llllllllllllllllIIIllIllIIIIIlII < llllllllllllllllIIIllIllIIIIIlIl.tagCount(); ++llllllllllllllllIIIllIllIIIIIlII) {
                    final NBTTagCompound llllllllllllllllIIIllIllIIIIIIll = llllllllllllllllIIIllIllIIIIIlIl.getCompoundTagAt(llllllllllllllllIIIllIllIIIIIlII);
                    Block llllllllllllllllIIIllIllIIIIIIIl = null;
                    if (llllllllllllllllIIIllIllIIIIIIll.hasKey("i", 8)) {
                        final Block llllllllllllllllIIIllIllIIIIIIlI = Block.getBlockFromName(llllllllllllllllIIIllIllIIIIIIll.getString("i"));
                    }
                    else {
                        llllllllllllllllIIIllIllIIIIIIIl = Block.getBlockById(llllllllllllllllIIIllIllIIIIIIll.getInteger("i"));
                    }
                    llllllllllllllllIIIllIllIIIIIIII.func_180497_b(new BlockPos(llllllllllllllllIIIllIllIIIIIIll.getInteger("x"), llllllllllllllllIIIllIllIIIIIIll.getInteger("y"), llllllllllllllllIIIllIllIIIIIIll.getInteger("z")), llllllllllllllllIIIllIllIIIIIIIl, llllllllllllllllIIIllIllIIIIIIll.getInteger("t"), llllllllllllllllIIIllIllIIIIIIll.getInteger("p"));
                }
            }
        }
        return llllllllllllllllIIIllIllIIlIIIlI;
    }
    
    protected Chunk checkedReadChunkFromNBT(final World llllllllllllllllIIIllIllllIlIIII, final int llllllllllllllllIIIllIllllIIllll, final int llllllllllllllllIIIllIllllIIlIII, final NBTTagCompound llllllllllllllllIIIllIllllIIIlll) {
        if (!llllllllllllllllIIIllIllllIIIlll.hasKey("Level", 10)) {
            AnvilChunkLoader.logger.error(String.valueOf(new StringBuilder("Chunk file at ").append(llllllllllllllllIIIllIllllIIllll).append(",").append(llllllllllllllllIIIllIllllIIlIII).append(" is missing level data, skipping")));
            return null;
        }
        if (!llllllllllllllllIIIllIllllIIIlll.getCompoundTag("Level").hasKey("Sections", 9)) {
            AnvilChunkLoader.logger.error(String.valueOf(new StringBuilder("Chunk file at ").append(llllllllllllllllIIIllIllllIIllll).append(",").append(llllllllllllllllIIIllIllllIIlIII).append(" is missing block data, skipping")));
            return null;
        }
        Chunk llllllllllllllllIIIllIllllIIllII = this.readChunkFromNBT(llllllllllllllllIIIllIllllIlIIII, llllllllllllllllIIIllIllllIIIlll.getCompoundTag("Level"));
        if (!llllllllllllllllIIIllIllllIIllII.isAtLocation(llllllllllllllllIIIllIllllIIllll, llllllllllllllllIIIllIllllIIlIII)) {
            AnvilChunkLoader.logger.error(String.valueOf(new StringBuilder("Chunk file at ").append(llllllllllllllllIIIllIllllIIllll).append(",").append(llllllllllllllllIIIllIllllIIlIII).append(" is in the wrong location; relocating. (Expected ").append(llllllllllllllllIIIllIllllIIllll).append(", ").append(llllllllllllllllIIIllIllllIIlIII).append(", got ").append(llllllllllllllllIIIllIllllIIllII.xPosition).append(", ").append(llllllllllllllllIIIllIllllIIllII.zPosition).append(")")));
            llllllllllllllllIIIllIllllIIIlll.setInteger("xPos", llllllllllllllllIIIllIllllIIllll);
            llllllllllllllllIIIllIllllIIIlll.setInteger("zPos", llllllllllllllllIIIllIllllIIlIII);
            llllllllllllllllIIIllIllllIIllII = this.readChunkFromNBT(llllllllllllllllIIIllIllllIlIIII, llllllllllllllllIIIllIllllIIIlll.getCompoundTag("Level"));
        }
        return llllllllllllllllIIIllIllllIIllII;
    }
    
    @Override
    public void chunkTick() {
    }
    
    static {
        __OBFID = "CL_00000384";
        logger = LogManager.getLogger();
    }
    
    private void writeChunkToNBT(final Chunk llllllllllllllllIIIllIllIlIlIIIl, final World llllllllllllllllIIIllIllIlIlIIII, final NBTTagCompound llllllllllllllllIIIllIllIlllIIIl) {
        llllllllllllllllIIIllIllIlllIIIl.setByte("V", (byte)1);
        llllllllllllllllIIIllIllIlllIIIl.setInteger("xPos", llllllllllllllllIIIllIllIlIlIIIl.xPosition);
        llllllllllllllllIIIllIllIlllIIIl.setInteger("zPos", llllllllllllllllIIIllIllIlIlIIIl.zPosition);
        llllllllllllllllIIIllIllIlllIIIl.setLong("LastUpdate", llllllllllllllllIIIllIllIlIlIIII.getTotalWorldTime());
        llllllllllllllllIIIllIllIlllIIIl.setIntArray("HeightMap", llllllllllllllllIIIllIllIlIlIIIl.getHeightMap());
        llllllllllllllllIIIllIllIlllIIIl.setBoolean("TerrainPopulated", llllllllllllllllIIIllIllIlIlIIIl.isTerrainPopulated());
        llllllllllllllllIIIllIllIlllIIIl.setBoolean("LightPopulated", llllllllllllllllIIIllIllIlIlIIIl.isLightPopulated());
        llllllllllllllllIIIllIllIlllIIIl.setLong("InhabitedTime", llllllllllllllllIIIllIllIlIlIIIl.getInhabitedTime());
        final ExtendedBlockStorage[] llllllllllllllllIIIllIllIlllIIII = llllllllllllllllIIIllIllIlIlIIIl.getBlockStorageArray();
        final NBTTagList llllllllllllllllIIIllIllIllIllll = new NBTTagList();
        final boolean llllllllllllllllIIIllIllIllIlllI = !llllllllllllllllIIIllIllIlIlIIII.provider.getHasNoSky();
        final ExtendedBlockStorage[] llllllllllllllllIIIllIllIllIllIl = llllllllllllllllIIIllIllIlllIIII;
        for (int llllllllllllllllIIIllIllIllIllII = llllllllllllllllIIIllIllIlllIIII.length, llllllllllllllllIIIllIllIllIlIII = 0; llllllllllllllllIIIllIllIllIlIII < llllllllllllllllIIIllIllIllIllII; ++llllllllllllllllIIIllIllIllIlIII) {
            final ExtendedBlockStorage llllllllllllllllIIIllIllIllIIlll = llllllllllllllllIIIllIllIllIllIl[llllllllllllllllIIIllIllIllIlIII];
            if (llllllllllllllllIIIllIllIllIIlll != null) {
                final NBTTagCompound llllllllllllllllIIIllIllIllIlIll = new NBTTagCompound();
                llllllllllllllllIIIllIllIllIlIll.setByte("Y", (byte)(llllllllllllllllIIIllIllIllIIlll.getYLocation() >> 4 & 0xFF));
                final byte[] llllllllllllllllIIIllIllIllIIllI = new byte[llllllllllllllllIIIllIllIllIIlll.getData().length];
                final NibbleArray llllllllllllllllIIIllIllIllIIlIl = new NibbleArray();
                NibbleArray llllllllllllllllIIIllIllIllIIlII = null;
                for (int llllllllllllllllIIIllIllIllIIIll = 0; llllllllllllllllIIIllIllIllIIIll < llllllllllllllllIIIllIllIllIIlll.getData().length; ++llllllllllllllllIIIllIllIllIIIll) {
                    final char llllllllllllllllIIIllIllIllIIIlI = llllllllllllllllIIIllIllIllIIlll.getData()[llllllllllllllllIIIllIllIllIIIll];
                    final int llllllllllllllllIIIllIllIllIIIIl = llllllllllllllllIIIllIllIllIIIll & 0xF;
                    final int llllllllllllllllIIIllIllIllIIIII = llllllllllllllllIIIllIllIllIIIll >> 8 & 0xF;
                    final int llllllllllllllllIIIllIllIlIlllll = llllllllllllllllIIIllIllIllIIIll >> 4 & 0xF;
                    if (llllllllllllllllIIIllIllIllIIIlI >> 12 != 0) {
                        if (llllllllllllllllIIIllIllIllIIlII == null) {
                            llllllllllllllllIIIllIllIllIIlII = new NibbleArray();
                        }
                        llllllllllllllllIIIllIllIllIIlII.set(llllllllllllllllIIIllIllIllIIIIl, llllllllllllllllIIIllIllIllIIIII, llllllllllllllllIIIllIllIlIlllll, llllllllllllllllIIIllIllIllIIIlI >> 12);
                    }
                    llllllllllllllllIIIllIllIllIIllI[llllllllllllllllIIIllIllIllIIIll] = (byte)(llllllllllllllllIIIllIllIllIIIlI >> 4 & 0xFF);
                    llllllllllllllllIIIllIllIllIIlIl.set(llllllllllllllllIIIllIllIllIIIIl, llllllllllllllllIIIllIllIllIIIII, llllllllllllllllIIIllIllIlIlllll, llllllllllllllllIIIllIllIllIIIlI & '\u000f');
                }
                llllllllllllllllIIIllIllIllIlIll.setByteArray("Blocks", llllllllllllllllIIIllIllIllIIllI);
                llllllllllllllllIIIllIllIllIlIll.setByteArray("Data", llllllllllllllllIIIllIllIllIIlIl.getData());
                if (llllllllllllllllIIIllIllIllIIlII != null) {
                    llllllllllllllllIIIllIllIllIlIll.setByteArray("Add", llllllllllllllllIIIllIllIllIIlII.getData());
                }
                llllllllllllllllIIIllIllIllIlIll.setByteArray("BlockLight", llllllllllllllllIIIllIllIllIIlll.getBlocklightArray().getData());
                if (llllllllllllllllIIIllIllIllIlllI) {
                    llllllllllllllllIIIllIllIllIlIll.setByteArray("SkyLight", llllllllllllllllIIIllIllIllIIlll.getSkylightArray().getData());
                }
                else {
                    llllllllllllllllIIIllIllIllIlIll.setByteArray("SkyLight", new byte[llllllllllllllllIIIllIllIllIIlll.getBlocklightArray().getData().length]);
                }
                llllllllllllllllIIIllIllIllIllll.appendTag(llllllllllllllllIIIllIllIllIlIll);
            }
        }
        llllllllllllllllIIIllIllIlllIIIl.setTag("Sections", llllllllllllllllIIIllIllIllIllll);
        llllllllllllllllIIIllIllIlllIIIl.setByteArray("Biomes", llllllllllllllllIIIllIllIlIlIIIl.getBiomeArray());
        llllllllllllllllIIIllIllIlIlIIIl.setHasEntities(false);
        final NBTTagList llllllllllllllllIIIllIllIlIllllI = new NBTTagList();
        for (int llllllllllllllllIIIllIllIllIllII = 0; llllllllllllllllIIIllIllIllIllII < llllllllllllllllIIIllIllIlIlIIIl.getEntityLists().length; ++llllllllllllllllIIIllIllIllIllII) {
            for (final Entity llllllllllllllllIIIllIllIlIllIll : llllllllllllllllIIIllIllIlIlIIIl.getEntityLists()[llllllllllllllllIIIllIllIllIllII]) {
                final NBTTagCompound llllllllllllllllIIIllIllIllIlIlI = new NBTTagCompound();
                if (llllllllllllllllIIIllIllIlIllIll.writeToNBTOptional(llllllllllllllllIIIllIllIllIlIlI)) {
                    llllllllllllllllIIIllIllIlIlIIIl.setHasEntities(true);
                    llllllllllllllllIIIllIllIlIllllI.appendTag(llllllllllllllllIIIllIllIllIlIlI);
                }
            }
        }
        llllllllllllllllIIIllIllIlllIIIl.setTag("Entities", llllllllllllllllIIIllIllIlIllllI);
        final NBTTagList llllllllllllllllIIIllIllIlIllIlI = new NBTTagList();
        for (final TileEntity llllllllllllllllIIIllIllIlIllIIl : llllllllllllllllIIIllIllIlIlIIIl.getTileEntityMap().values()) {
            final NBTTagCompound llllllllllllllllIIIllIllIllIlIIl = new NBTTagCompound();
            llllllllllllllllIIIllIllIlIllIIl.writeToNBT(llllllllllllllllIIIllIllIllIlIIl);
            llllllllllllllllIIIllIllIlIllIlI.appendTag(llllllllllllllllIIIllIllIllIlIIl);
        }
        llllllllllllllllIIIllIllIlllIIIl.setTag("TileEntities", llllllllllllllllIIIllIllIlIllIlI);
        final List llllllllllllllllIIIllIllIlIllIII = llllllllllllllllIIIllIllIlIlIIII.getPendingBlockUpdates(llllllllllllllllIIIllIllIlIlIIIl, false);
        if (llllllllllllllllIIIllIllIlIllIII != null) {
            final long llllllllllllllllIIIllIllIlIlIlll = llllllllllllllllIIIllIllIlIlIIII.getTotalWorldTime();
            final NBTTagList llllllllllllllllIIIllIllIlIlIllI = new NBTTagList();
            for (final NextTickListEntry llllllllllllllllIIIllIllIlIlIlII : llllllllllllllllIIIllIllIlIllIII) {
                final NBTTagCompound llllllllllllllllIIIllIllIlIlIIll = new NBTTagCompound();
                final ResourceLocation llllllllllllllllIIIllIllIlIlIIlI = (ResourceLocation)Block.blockRegistry.getNameForObject(llllllllllllllllIIIllIllIlIlIlII.func_151351_a());
                llllllllllllllllIIIllIllIlIlIIll.setString("i", (llllllllllllllllIIIllIllIlIlIIlI == null) ? "" : llllllllllllllllIIIllIllIlIlIIlI.toString());
                llllllllllllllllIIIllIllIlIlIIll.setInteger("x", llllllllllllllllIIIllIllIlIlIlII.field_180282_a.getX());
                llllllllllllllllIIIllIllIlIlIIll.setInteger("y", llllllllllllllllIIIllIllIlIlIlII.field_180282_a.getY());
                llllllllllllllllIIIllIllIlIlIIll.setInteger("z", llllllllllllllllIIIllIllIlIlIlII.field_180282_a.getZ());
                llllllllllllllllIIIllIllIlIlIIll.setInteger("t", (int)(llllllllllllllllIIIllIllIlIlIlII.scheduledTime - llllllllllllllllIIIllIllIlIlIlll));
                llllllllllllllllIIIllIllIlIlIIll.setInteger("p", llllllllllllllllIIIllIllIlIlIlII.priority);
                llllllllllllllllIIIllIllIlIlIllI.appendTag(llllllllllllllllIIIllIllIlIlIIll);
            }
            llllllllllllllllIIIllIllIlllIIIl.setTag("TileTicks", llllllllllllllllIIIllIllIlIlIllI);
        }
    }
    
    @Override
    public boolean writeNextIO() {
        PendingChunk llllllllllllllllIIIllIlllIIlllll = null;
        final Object llllllllllllllllIIIllIlllIIllllI = this.syncLockObject;
        synchronized (this.syncLockObject) {
            if (this.chunksToRemove.isEmpty()) {
                // monitorexit(this.syncLockObject)
                return false;
            }
            llllllllllllllllIIIllIlllIIlllll = this.chunksToRemove.remove(0);
            this.pendingAnvilChunksCoordinates.remove(llllllllllllllllIIIllIlllIIlllll.chunkCoordinate);
        }
        // monitorexit(this.syncLockObject)
        if (llllllllllllllllIIIllIlllIIlllll != null) {
            try {
                this.writeChunkNBTTags(llllllllllllllllIIIllIlllIIlllll);
            }
            catch (Exception llllllllllllllllIIIllIlllIIlllIl) {
                llllllllllllllllIIIllIlllIIlllIl.printStackTrace();
            }
        }
        return true;
    }
    
    public AnvilChunkLoader(final File llllllllllllllllIIIllIllllllIlIl) {
        this.chunksToRemove = Lists.newArrayList();
        this.pendingAnvilChunksCoordinates = Sets.newHashSet();
        this.syncLockObject = new Object();
        this.chunkSaveLocation = llllllllllllllllIIIllIllllllIlIl;
    }
    
    @Override
    public void saveExtraChunkData(final World llllllllllllllllIIIllIlllIIIlllI, final Chunk llllllllllllllllIIIllIlllIIIllIl) {
    }
    
    @Override
    public void saveExtraData() {
        while (this.writeNextIO()) {}
    }
    
    static class PendingChunk
    {
        public final /* synthetic */ NBTTagCompound nbtTags;
        public final /* synthetic */ ChunkCoordIntPair chunkCoordinate;
        
        public PendingChunk(final ChunkCoordIntPair lllIlIIIIlIlIIl, final NBTTagCompound lllIlIIIIlIlIll) {
            this.chunkCoordinate = lllIlIIIIlIlIIl;
            this.nbtTags = lllIlIIIIlIlIll;
        }
        
        static {
            __OBFID = "CL_00000385";
        }
    }
}
