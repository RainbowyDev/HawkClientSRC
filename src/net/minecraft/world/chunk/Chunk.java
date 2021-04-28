package net.minecraft.world.chunk;

import net.minecraft.world.chunk.storage.*;
import net.minecraft.entity.*;
import java.util.concurrent.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.*;
import net.minecraft.crash.*;
import net.minecraft.tileentity.*;
import org.apache.logging.log4j.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import net.minecraft.world.biome.*;
import net.minecraft.block.*;
import java.util.*;

public class Chunk
{
    private /* synthetic */ long inhabitedTime;
    private /* synthetic */ boolean field_150815_m;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ boolean[] updateSkylightColumns;
    private /* synthetic */ boolean isTerrainPopulated;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ int[] precipitationHeightMap;
    private final /* synthetic */ Map chunkTileEntityMap;
    private /* synthetic */ boolean isGapLightingUpdated;
    public final /* synthetic */ int xPosition;
    private /* synthetic */ ConcurrentLinkedQueue field_177447_w;
    public final /* synthetic */ int zPosition;
    private final /* synthetic */ ExtendedBlockStorage[] storageArrays;
    private /* synthetic */ boolean isModified;
    private final /* synthetic */ byte[] blockBiomeArray;
    private /* synthetic */ boolean isLightPopulated;
    private /* synthetic */ int heightMapMinimum;
    private /* synthetic */ boolean hasEntities;
    private final /* synthetic */ ClassInheratanceMultiMap[] entityLists;
    private /* synthetic */ int queuedLightChecks;
    private /* synthetic */ long lastSaveTime;
    private final /* synthetic */ int[] heightMap;
    private /* synthetic */ boolean isChunkLoaded;
    
    public ChunkCoordIntPair getChunkCoordIntPair() {
        return new ChunkCoordIntPair(this.xPosition, this.zPosition);
    }
    
    public void setLightPopulated(final boolean llllllllllllllIlIlIIIIIIlllIlIII) {
        this.isLightPopulated = llllllllllllllIlIlIIIIIIlllIlIII;
    }
    
    private boolean func_150811_f(final int llllllllllllllIlIlIIIIIlIIlIlIIl, final int llllllllllllllIlIlIIIIIlIIlIlIII) {
        final BlockPos llllllllllllllIlIlIIIIIlIIlIIlll = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
        final int llllllllllllllIlIlIIIIIlIIlIIllI = this.getTopFilledSegment();
        boolean llllllllllllllIlIlIIIIIlIIlIIlIl = false;
        boolean llllllllllllllIlIlIIIIIlIIlIIlII = false;
        int llllllllllllllIlIlIIIIIlIIlIIIll = llllllllllllllIlIlIIIIIlIIlIIllI + 16 - 1;
        while (true) {
            if (llllllllllllllIlIlIIIIIlIIlIIIll <= 63) {
                if (llllllllllllllIlIlIIIIIlIIlIIIll <= 0) {
                    break;
                }
                if (llllllllllllllIlIlIIIIIlIIlIIlII) {
                    break;
                }
            }
            final BlockPos llllllllllllllIlIlIIIIIlIIlIIIlI = llllllllllllllIlIlIIIIIlIIlIIlll.add(llllllllllllllIlIlIIIIIlIIlIlIIl, llllllllllllllIlIlIIIIIlIIlIIIll, llllllllllllllIlIlIIIIIlIIlIlIII);
            final int llllllllllllllIlIlIIIIIlIIlIIIII = this.getBlockLightOpacity(llllllllllllllIlIlIIIIIlIIlIIIlI);
            if (llllllllllllllIlIlIIIIIlIIlIIIII == 255 && llllllllllllllIlIlIIIIIlIIlIIIll < 63) {
                llllllllllllllIlIlIIIIIlIIlIIlII = true;
            }
            if (!llllllllllllllIlIlIIIIIlIIlIIlIl && llllllllllllllIlIlIIIIIlIIlIIIII > 0) {
                llllllllllllllIlIlIIIIIlIIlIIlIl = true;
            }
            else if (llllllllllllllIlIlIIIIIlIIlIIlIl && llllllllllllllIlIlIIIIIlIIlIIIII == 0 && !this.worldObj.checkLight(llllllllllllllIlIlIIIIIlIIlIIIlI)) {
                return false;
            }
            --llllllllllllllIlIlIIIIIlIIlIIIll;
        }
        while (llllllllllllllIlIlIIIIIlIIlIIIll > 0) {
            final BlockPos llllllllllllllIlIlIIIIIlIIlIIIIl = llllllllllllllIlIlIIIIIlIIlIIlll.add(llllllllllllllIlIlIIIIIlIIlIlIIl, llllllllllllllIlIlIIIIIlIIlIIIll, llllllllllllllIlIlIIIIIlIIlIlIII);
            if (this.getBlock(llllllllllllllIlIlIIIIIlIIlIIIIl).getLightValue() > 0) {
                this.worldObj.checkLight(llllllllllllllIlIlIIIIIlIIlIIIIl);
            }
            --llllllllllllllIlIlIIIIIlIIlIIIll;
        }
        return true;
    }
    
    public void onChunkLoad() {
        this.isChunkLoaded = true;
        this.worldObj.addTileEntities(this.chunkTileEntityMap.values());
        for (int llllllllllllllIlIlIIIIlIlIIllllI = 0; llllllllllllllIlIlIIIIlIlIIllllI < this.entityLists.length; ++llllllllllllllIlIlIIIIlIlIIllllI) {
            for (final Entity llllllllllllllIlIlIIIIlIlIIlllII : this.entityLists[llllllllllllllIlIlIIIIlIlIIllllI]) {
                llllllllllllllIlIlIIIIlIlIIlllII.onChunkLoad();
            }
            this.worldObj.loadEntities(this.entityLists[llllllllllllllIlIlIIIIlIlIIllllI]);
        }
    }
    
    public Block getBlock(final int llllllllllllllIlIlIIIIlllIllIllI, final int llllllllllllllIlIlIIIIlllIllIlIl, final int llllllllllllllIlIlIIIIlllIlIlllI) {
        try {
            return this.getBlock0(llllllllllllllIlIlIIIIlllIllIllI & 0xF, llllllllllllllIlIlIIIIlllIllIlIl, llllllllllllllIlIlIIIIlllIlIlllI & 0xF);
        }
        catch (ReportedException llllllllllllllIlIlIIIIlllIllIIll) {
            final CrashReportCategory llllllllllllllIlIlIIIIlllIllIIlI = llllllllllllllIlIlIIIIlllIllIIll.getCrashReport().makeCategory("Block being got");
            llllllllllllllIlIlIIIIlllIllIIlI.addCrashSectionCallable("Location", new Callable() {
                @Override
                public String call() {
                    return CrashReportCategory.getCoordinateInfo(new BlockPos(Chunk.this.xPosition * 16 + llllllllllllllIlIlIIIIlllIllIllI, llllllllllllllIlIlIIIIlllIllIlIl, Chunk.this.zPosition * 16 + llllllllllllllIlIlIIIIlllIlIlllI));
                }
                
                static {
                    __OBFID = "CL_00000374";
                }
            });
            throw llllllllllllllIlIlIIIIlllIllIIll;
        }
    }
    
    public int getLowestHeight() {
        return this.heightMapMinimum;
    }
    
    public boolean isLightPopulated() {
        return this.isLightPopulated;
    }
    
    private void recheckGaps(final boolean llllllllllllllIlIlIIIlIIIIlllllI) {
        this.worldObj.theProfiler.startSection("recheckGaps");
        if (this.worldObj.isAreaLoaded(new BlockPos(this.xPosition * 16 + 8, 0, this.zPosition * 16 + 8), 16)) {
            for (int llllllllllllllIlIlIIIlIIIlIIlIII = 0; llllllllllllllIlIlIIIlIIIlIIlIII < 16; ++llllllllllllllIlIlIIIlIIIlIIlIII) {
                for (int llllllllllllllIlIlIIIlIIIlIIIlll = 0; llllllllllllllIlIlIIIlIIIlIIIlll < 16; ++llllllllllllllIlIlIIIlIIIlIIIlll) {
                    if (this.updateSkylightColumns[llllllllllllllIlIlIIIlIIIlIIlIII + llllllllllllllIlIlIIIlIIIlIIIlll * 16]) {
                        this.updateSkylightColumns[llllllllllllllIlIlIIIlIIIlIIlIII + llllllllllllllIlIlIIIlIIIlIIIlll * 16] = false;
                        final int llllllllllllllIlIlIIIlIIIlIIIllI = this.getHeight(llllllllllllllIlIlIIIlIIIlIIlIII, llllllllllllllIlIlIIIlIIIlIIIlll);
                        final int llllllllllllllIlIlIIIlIIIlIIIlIl = this.xPosition * 16 + llllllllllllllIlIlIIIlIIIlIIlIII;
                        final int llllllllllllllIlIlIIIlIIIlIIIlII = this.zPosition * 16 + llllllllllllllIlIlIIIlIIIlIIIlll;
                        int llllllllllllllIlIlIIIlIIIlIIIIll = Integer.MAX_VALUE;
                        for (final EnumFacing llllllllllllllIlIlIIIlIIIlIIIIIl : EnumFacing.Plane.HORIZONTAL) {
                            llllllllllllllIlIlIIIlIIIlIIIIll = Math.min(llllllllllllllIlIlIIIlIIIlIIIIll, this.worldObj.getChunksLowestHorizon(llllllllllllllIlIlIIIlIIIlIIIlIl + llllllllllllllIlIlIIIlIIIlIIIIIl.getFrontOffsetX(), llllllllllllllIlIlIIIlIIIlIIIlII + llllllllllllllIlIlIIIlIIIlIIIIIl.getFrontOffsetZ()));
                        }
                        this.checkSkylightNeighborHeight(llllllllllllllIlIlIIIlIIIlIIIlIl, llllllllllllllIlIlIIIlIIIlIIIlII, llllllllllllllIlIlIIIlIIIlIIIIll);
                        for (final EnumFacing llllllllllllllIlIlIIIlIIIlIIIIII : EnumFacing.Plane.HORIZONTAL) {
                            this.checkSkylightNeighborHeight(llllllllllllllIlIlIIIlIIIlIIIlIl + llllllllllllllIlIlIIIlIIIlIIIIII.getFrontOffsetX(), llllllllllllllIlIlIIIlIIIlIIIlII + llllllllllllllIlIlIIIlIIIlIIIIII.getFrontOffsetZ(), llllllllllllllIlIlIIIlIIIlIIIllI);
                        }
                        if (llllllllllllllIlIlIIIlIIIIlllllI) {
                            this.worldObj.theProfiler.endSection();
                            return;
                        }
                    }
                }
            }
            this.isGapLightingUpdated = false;
        }
        this.worldObj.theProfiler.endSection();
    }
    
    public void setLastSaveTime(final long llllllllllllllIlIlIIIIIIllIlIlII) {
        this.lastSaveTime = llllllllllllllIlIlIIIIIIllIlIlII;
    }
    
    public void setLightFor(final EnumSkyBlock llllllllllllllIlIlIIIIllIIlIIlll, final BlockPos llllllllllllllIlIlIIIIllIIIllllI, final int llllllllllllllIlIlIIIIllIIIlllIl) {
        final int llllllllllllllIlIlIIIIllIIlIIlII = llllllllllllllIlIlIIIIllIIIllllI.getX() & 0xF;
        final int llllllllllllllIlIlIIIIllIIlIIIll = llllllllllllllIlIlIIIIllIIIllllI.getY();
        final int llllllllllllllIlIlIIIIllIIlIIIlI = llllllllllllllIlIlIIIIllIIIllllI.getZ() & 0xF;
        ExtendedBlockStorage llllllllllllllIlIlIIIIllIIlIIIIl = this.storageArrays[llllllllllllllIlIlIIIIllIIlIIIll >> 4];
        if (llllllllllllllIlIlIIIIllIIlIIIIl == null) {
            final ExtendedBlockStorage[] storageArrays = this.storageArrays;
            final int n = llllllllllllllIlIlIIIIllIIlIIIll >> 4;
            final ExtendedBlockStorage extendedBlockStorage = new ExtendedBlockStorage(llllllllllllllIlIlIIIIllIIlIIIll >> 4 << 4, !this.worldObj.provider.getHasNoSky());
            storageArrays[n] = extendedBlockStorage;
            llllllllllllllIlIlIIIIllIIlIIIIl = extendedBlockStorage;
            this.generateSkylightMap();
        }
        this.isModified = true;
        if (llllllllllllllIlIlIIIIllIIlIIlll == EnumSkyBlock.SKY) {
            if (!this.worldObj.provider.getHasNoSky()) {
                llllllllllllllIlIlIIIIllIIlIIIIl.setExtSkylightValue(llllllllllllllIlIlIIIIllIIlIIlII, llllllllllllllIlIlIIIIllIIlIIIll & 0xF, llllllllllllllIlIlIIIIllIIlIIIlI, llllllllllllllIlIlIIIIllIIIlllIl);
            }
        }
        else if (llllllllllllllIlIlIIIIllIIlIIlll == EnumSkyBlock.BLOCK) {
            llllllllllllllIlIlIIIIllIIlIIIIl.setExtBlocklightValue(llllllllllllllIlIlIIIIllIIlIIlII, llllllllllllllIlIlIIIIllIIlIIIll & 0xF, llllllllllllllIlIlIIIIllIIlIIIlI, llllllllllllllIlIlIIIIllIIIlllIl);
        }
    }
    
    public void setChunkModified() {
        this.isModified = true;
    }
    
    public IBlockState getBlockState(final BlockPos llllllllllllllIlIlIIIIlllIIllIII) {
        if (this.worldObj.getWorldType() == WorldType.DEBUG_WORLD) {
            IBlockState llllllllllllllIlIlIIIIlllIIlIlll = null;
            if (llllllllllllllIlIlIIIIlllIIllIII.getY() == 60) {
                llllllllllllllIlIlIIIIlllIIlIlll = Blocks.barrier.getDefaultState();
            }
            if (llllllllllllllIlIlIIIIlllIIllIII.getY() == 70) {
                llllllllllllllIlIlIIIIlllIIlIlll = ChunkProviderDebug.func_177461_b(llllllllllllllIlIlIIIIlllIIllIII.getX(), llllllllllllllIlIlIIIIlllIIllIII.getZ());
            }
            return (llllllllllllllIlIlIIIIlllIIlIlll == null) ? Blocks.air.getDefaultState() : llllllllllllllIlIlIIIIlllIIlIlll;
        }
        try {
            if (llllllllllllllIlIlIIIIlllIIllIII.getY() >= 0 && llllllllllllllIlIlIIIIlllIIllIII.getY() >> 4 < this.storageArrays.length) {
                final ExtendedBlockStorage llllllllllllllIlIlIIIIlllIIlIllI = this.storageArrays[llllllllllllllIlIlIIIIlllIIllIII.getY() >> 4];
                if (llllllllllllllIlIlIIIIlllIIlIllI != null) {
                    final int llllllllllllllIlIlIIIIlllIIlIlIl = llllllllllllllIlIlIIIIlllIIllIII.getX() & 0xF;
                    final int llllllllllllllIlIlIIIIlllIIlIlII = llllllllllllllIlIlIIIIlllIIllIII.getY() & 0xF;
                    final int llllllllllllllIlIlIIIIlllIIlIIll = llllllllllllllIlIlIIIIlllIIllIII.getZ() & 0xF;
                    return llllllllllllllIlIlIIIIlllIIlIllI.get(llllllllllllllIlIlIIIIlllIIlIlIl, llllllllllllllIlIlIIIIlllIIlIlII, llllllllllllllIlIlIIIIlllIIlIIll);
                }
            }
            return Blocks.air.getDefaultState();
        }
        catch (Throwable llllllllllllllIlIlIIIIlllIIlIIlI) {
            final CrashReport llllllllllllllIlIlIIIIlllIIlIIIl = CrashReport.makeCrashReport(llllllllllllllIlIlIIIIlllIIlIIlI, "Getting block state");
            final CrashReportCategory llllllllllllllIlIlIIIIlllIIlIIII = llllllllllllllIlIlIIIIlllIIlIIIl.makeCategory("Block being got");
            llllllllllllllIlIlIIIIlllIIlIIII.addCrashSectionCallable("Location", new Callable() {
                @Override
                public Object call() {
                    return this.func_177448_a();
                }
                
                static {
                    __OBFID = "CL_00002010";
                }
                
                public String func_177448_a() {
                    return CrashReportCategory.getCoordinateInfo(llllllllllllllIlIlIIIIlllIIllIII);
                }
            });
            throw new ReportedException(llllllllllllllIlIlIIIIlllIIlIIIl);
        }
    }
    
    public TileEntity func_177424_a(final BlockPos llllllllllllllIlIlIIIIlIllIIIIlI, final EnumCreateEntityType llllllllllllllIlIlIIIIlIlIllllIl) {
        TileEntity llllllllllllllIlIlIIIIlIllIIIIII = this.chunkTileEntityMap.get(llllllllllllllIlIlIIIIlIllIIIIlI);
        if (llllllllllllllIlIlIIIIlIllIIIIII == null) {
            if (llllllllllllllIlIlIIIIlIlIllllIl == EnumCreateEntityType.IMMEDIATE) {
                llllllllllllllIlIlIIIIlIllIIIIII = this.createNewTileEntity(llllllllllllllIlIlIIIIlIllIIIIlI);
                this.worldObj.setTileEntity(llllllllllllllIlIlIIIIlIllIIIIlI, llllllllllllllIlIlIIIIlIllIIIIII);
            }
            else if (llllllllllllllIlIlIIIIlIlIllllIl == EnumCreateEntityType.QUEUED) {
                this.field_177447_w.add(llllllllllllllIlIlIIIIlIllIIIIlI);
            }
        }
        else if (llllllllllllllIlIlIIIIlIllIIIIII.isInvalid()) {
            this.chunkTileEntityMap.remove(llllllllllllllIlIlIIIIlIllIIIIlI);
            return null;
        }
        return llllllllllllllIlIlIIIIlIllIIIIII;
    }
    
    private void relightBlock(final int llllllllllllllIlIlIIIlIIIIIIIllI, final int llllllllllllllIlIlIIIIllllllIIlI, final int llllllllllllllIlIlIIIlIIIIIIIlII) {
        int llllllllllllllIlIlIIIlIIIIIIIIlI;
        final int llllllllllllllIlIlIIIlIIIIIIIIll = llllllllllllllIlIlIIIlIIIIIIIIlI = (this.heightMap[llllllllllllllIlIlIIIlIIIIIIIlII << 4 | llllllllllllllIlIlIIIlIIIIIIIllI] & 0xFF);
        if (llllllllllllllIlIlIIIIllllllIIlI > llllllllllllllIlIlIIIlIIIIIIIIll) {
            llllllllllllllIlIlIIIlIIIIIIIIlI = llllllllllllllIlIlIIIIllllllIIlI;
        }
        while (llllllllllllllIlIlIIIlIIIIIIIIlI > 0 && this.getBlockLightOpacity(llllllllllllllIlIlIIIlIIIIIIIllI, llllllllllllllIlIlIIIlIIIIIIIIlI - 1, llllllllllllllIlIlIIIlIIIIIIIlII) == 0) {
            --llllllllllllllIlIlIIIlIIIIIIIIlI;
        }
        if (llllllllllllllIlIlIIIlIIIIIIIIlI != llllllllllllllIlIlIIIlIIIIIIIIll) {
            this.worldObj.markBlocksDirtyVertical(llllllllllllllIlIlIIIlIIIIIIIllI + this.xPosition * 16, llllllllllllllIlIlIIIlIIIIIIIlII + this.zPosition * 16, llllllllllllllIlIlIIIlIIIIIIIIlI, llllllllllllllIlIlIIIlIIIIIIIIll);
            this.heightMap[llllllllllllllIlIlIIIlIIIIIIIlII << 4 | llllllllllllllIlIlIIIlIIIIIIIllI] = llllllllllllllIlIlIIIlIIIIIIIIlI;
            final int llllllllllllllIlIlIIIlIIIIIIIIIl = this.xPosition * 16 + llllllllllllllIlIlIIIlIIIIIIIllI;
            final int llllllllllllllIlIlIIIlIIIIIIIIII = this.zPosition * 16 + llllllllllllllIlIlIIIlIIIIIIIlII;
            if (!this.worldObj.provider.getHasNoSky()) {
                if (llllllllllllllIlIlIIIlIIIIIIIIlI < llllllllllllllIlIlIIIlIIIIIIIIll) {
                    for (int llllllllllllllIlIlIIIIllllllllll = llllllllllllllIlIlIIIlIIIIIIIIlI; llllllllllllllIlIlIIIIllllllllll < llllllllllllllIlIlIIIlIIIIIIIIll; ++llllllllllllllIlIlIIIIllllllllll) {
                        final ExtendedBlockStorage llllllllllllllIlIlIIIIlllllllIlI = this.storageArrays[llllllllllllllIlIlIIIIllllllllll >> 4];
                        if (llllllllllllllIlIlIIIIlllllllIlI != null) {
                            llllllllllllllIlIlIIIIlllllllIlI.setExtSkylightValue(llllllllllllllIlIlIIIlIIIIIIIllI, llllllllllllllIlIlIIIIllllllllll & 0xF, llllllllllllllIlIlIIIlIIIIIIIlII, 15);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + llllllllllllllIlIlIIIlIIIIIIIllI, llllllllllllllIlIlIIIIllllllllll, (this.zPosition << 4) + llllllllllllllIlIlIIIlIIIIIIIlII));
                        }
                    }
                }
                else {
                    for (int llllllllllllllIlIlIIIIlllllllllI = llllllllllllllIlIlIIIlIIIIIIIIll; llllllllllllllIlIlIIIIlllllllllI < llllllllllllllIlIlIIIlIIIIIIIIlI; ++llllllllllllllIlIlIIIIlllllllllI) {
                        final ExtendedBlockStorage llllllllllllllIlIlIIIIlllllllIIl = this.storageArrays[llllllllllllllIlIlIIIIlllllllllI >> 4];
                        if (llllllllllllllIlIlIIIIlllllllIIl != null) {
                            llllllllllllllIlIlIIIIlllllllIIl.setExtSkylightValue(llllllllllllllIlIlIIIlIIIIIIIllI, llllllllllllllIlIlIIIIlllllllllI & 0xF, llllllllllllllIlIlIIIlIIIIIIIlII, 0);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + llllllllllllllIlIlIIIlIIIIIIIllI, llllllllllllllIlIlIIIIlllllllllI, (this.zPosition << 4) + llllllllllllllIlIlIIIlIIIIIIIlII));
                        }
                    }
                }
                int llllllllllllllIlIlIIIIlllllllllI = 15;
                while (llllllllllllllIlIlIIIlIIIIIIIIlI > 0 && llllllllllllllIlIlIIIIlllllllllI > 0) {
                    --llllllllllllllIlIlIIIlIIIIIIIIlI;
                    int llllllllllllllIlIlIIIIllllllllII = this.getBlockLightOpacity(llllllllllllllIlIlIIIlIIIIIIIllI, llllllllllllllIlIlIIIlIIIIIIIIlI, llllllllllllllIlIlIIIlIIIIIIIlII);
                    if (llllllllllllllIlIlIIIIllllllllII == 0) {
                        llllllllllllllIlIlIIIIllllllllII = 1;
                    }
                    llllllllllllllIlIlIIIIlllllllllI -= llllllllllllllIlIlIIIIllllllllII;
                    if (llllllllllllllIlIlIIIIlllllllllI < 0) {
                        llllllllllllllIlIlIIIIlllllllllI = 0;
                    }
                    final ExtendedBlockStorage llllllllllllllIlIlIIIIlllllllIII = this.storageArrays[llllllllllllllIlIlIIIlIIIIIIIIlI >> 4];
                    if (llllllllllllllIlIlIIIIlllllllIII != null) {
                        llllllllllllllIlIlIIIIlllllllIII.setExtSkylightValue(llllllllllllllIlIlIIIlIIIIIIIllI, llllllllllllllIlIlIIIlIIIIIIIIlI & 0xF, llllllllllllllIlIlIIIlIIIIIIIlII, llllllllllllllIlIlIIIIlllllllllI);
                    }
                }
            }
            final int llllllllllllllIlIlIIIIllllllllIl = this.heightMap[llllllllllllllIlIlIIIlIIIIIIIlII << 4 | llllllllllllllIlIlIIIlIIIIIIIllI];
            int llllllllllllllIlIlIIIIllllllIlll;
            int llllllllllllllIlIlIIIIlllllllIll;
            if ((llllllllllllllIlIlIIIIllllllIlll = llllllllllllllIlIlIIIIllllllllIl) < (llllllllllllllIlIlIIIIlllllllIll = llllllllllllllIlIlIIIlIIIIIIIIll)) {
                llllllllllllllIlIlIIIIlllllllIll = llllllllllllllIlIlIIIIllllllllIl;
                llllllllllllllIlIlIIIIllllllIlll = llllllllllllllIlIlIIIlIIIIIIIIll;
            }
            if (llllllllllllllIlIlIIIIllllllllIl < this.heightMapMinimum) {
                this.heightMapMinimum = llllllllllllllIlIlIIIIllllllllIl;
            }
            if (!this.worldObj.provider.getHasNoSky()) {
                for (final EnumFacing llllllllllllllIlIlIIIIllllllIlIl : EnumFacing.Plane.HORIZONTAL) {
                    this.updateSkylightNeighborHeight(llllllllllllllIlIlIIIlIIIIIIIIIl + llllllllllllllIlIlIIIIllllllIlIl.getFrontOffsetX(), llllllllllllllIlIlIIIlIIIIIIIIII + llllllllllllllIlIlIIIIllllllIlIl.getFrontOffsetZ(), llllllllllllllIlIlIIIIlllllllIll, llllllllllllllIlIlIIIIllllllIlll);
                }
                this.updateSkylightNeighborHeight(llllllllllllllIlIlIIIlIIIIIIIIIl, llllllllllllllIlIlIIIlIIIIIIIIII, llllllllllllllIlIlIIIIlllllllIll, llllllllllllllIlIlIIIIllllllIlll);
            }
            this.isModified = true;
        }
    }
    
    static {
        __OBFID = "CL_00000373";
        logger = LogManager.getLogger();
    }
    
    public boolean isAtLocation(final int llllllllllllllIlIlIIIlIIlIlIIIIl, final int llllllllllllllIlIlIIIlIIlIlIIIll) {
        return llllllllllllllIlIlIIIlIIlIlIIIIl == this.xPosition && llllllllllllllIlIlIIIlIIlIlIIIll == this.zPosition;
    }
    
    public void addEntity(final Entity llllllllllllllIlIlIIIIlIllllIIlI) {
        this.hasEntities = true;
        final int llllllllllllllIlIlIIIIlIllllIllI = MathHelper.floor_double(llllllllllllllIlIlIIIIlIllllIIlI.posX / 16.0);
        final int llllllllllllllIlIlIIIIlIllllIlIl = MathHelper.floor_double(llllllllllllllIlIlIIIIlIllllIIlI.posZ / 16.0);
        if (llllllllllllllIlIlIIIIlIllllIllI != this.xPosition || llllllllllllllIlIlIIIIlIllllIlIl != this.zPosition) {
            Chunk.logger.warn(String.valueOf(new StringBuilder("Wrong location! (").append(llllllllllllllIlIlIIIIlIllllIllI).append(", ").append(llllllllllllllIlIlIIIIlIllllIlIl).append(") should be (").append(this.xPosition).append(", ").append(this.zPosition).append("), ").append(llllllllllllllIlIlIIIIlIllllIIlI)), new Object[] { llllllllllllllIlIlIIIIlIllllIIlI });
            llllllllllllllIlIlIIIIlIllllIIlI.setDead();
        }
        int llllllllllllllIlIlIIIIlIllllIlII = MathHelper.floor_double(llllllllllllllIlIlIIIIlIllllIIlI.posY / 16.0);
        if (llllllllllllllIlIlIIIIlIllllIlII < 0) {
            llllllllllllllIlIlIIIIlIllllIlII = 0;
        }
        if (llllllllllllllIlIlIIIIlIllllIlII >= this.entityLists.length) {
            llllllllllllllIlIlIIIIlIllllIlII = this.entityLists.length - 1;
        }
        llllllllllllllIlIlIIIIlIllllIIlI.addedToChunk = true;
        llllllllllllllIlIlIIIIlIllllIIlI.chunkCoordX = this.xPosition;
        llllllllllllllIlIlIIIIlIllllIIlI.chunkCoordY = llllllllllllllIlIlIIIIlIllllIlII;
        llllllllllllllIlIlIIIIlIllllIIlI.chunkCoordZ = this.zPosition;
        this.entityLists[llllllllllllllIlIlIIIIlIllllIlII].add(llllllllllllllIlIlIIIIlIllllIIlI);
    }
    
    public Chunk(final World llllllllllllllIlIlIIIlIIllIIIIIl, final ChunkPrimer llllllllllllllIlIlIIIlIIllIIIIII, final int llllllllllllllIlIlIIIlIIlIllIIlI, final int llllllllllllllIlIlIIIlIIlIlllllI) {
        this(llllllllllllllIlIlIIIlIIllIIIIIl, llllllllllllllIlIlIIIlIIlIllIIlI, llllllllllllllIlIlIIIlIIlIlllllI);
        final short llllllllllllllIlIlIIIlIIlIllllIl = 256;
        final boolean llllllllllllllIlIlIIIlIIlIllllII = !llllllllllllllIlIlIIIlIIllIIIIIl.provider.getHasNoSky();
        for (int llllllllllllllIlIlIIIlIIlIlllIll = 0; llllllllllllllIlIlIIIlIIlIlllIll < 16; ++llllllllllllllIlIlIIIlIIlIlllIll) {
            for (int llllllllllllllIlIlIIIlIIlIlllIlI = 0; llllllllllllllIlIlIIIlIIlIlllIlI < 16; ++llllllllllllllIlIlIIIlIIlIlllIlI) {
                for (int llllllllllllllIlIlIIIlIIlIlllIIl = 0; llllllllllllllIlIlIIIlIIlIlllIIl < llllllllllllllIlIlIIIlIIlIllllIl; ++llllllllllllllIlIlIIIlIIlIlllIIl) {
                    final int llllllllllllllIlIlIIIlIIlIlllIII = llllllllllllllIlIlIIIlIIlIlllIll * llllllllllllllIlIlIIIlIIlIllllIl * 16 | llllllllllllllIlIlIIIlIIlIlllIlI * llllllllllllllIlIlIIIlIIlIllllIl | llllllllllllllIlIlIIIlIIlIlllIIl;
                    final IBlockState llllllllllllllIlIlIIIlIIlIllIlll = llllllllllllllIlIlIIIlIIllIIIIII.getBlockState(llllllllllllllIlIlIIIlIIlIlllIII);
                    if (llllllllllllllIlIlIIIlIIlIllIlll.getBlock().getMaterial() != Material.air) {
                        final int llllllllllllllIlIlIIIlIIlIllIllI = llllllllllllllIlIlIIIlIIlIlllIIl >> 4;
                        if (this.storageArrays[llllllllllllllIlIlIIIlIIlIllIllI] == null) {
                            this.storageArrays[llllllllllllllIlIlIIIlIIlIllIllI] = new ExtendedBlockStorage(llllllllllllllIlIlIIIlIIlIllIllI << 4, llllllllllllllIlIlIIIlIIlIllllII);
                        }
                        this.storageArrays[llllllllllllllIlIlIIIlIIlIllIllI].set(llllllllllllllIlIlIIIlIIlIlllIll, llllllllllllllIlIlIIIlIIlIlllIIl & 0xF, llllllllllllllIlIlIIIlIIlIlllIlI, llllllllllllllIlIlIIIlIIlIllIlll);
                    }
                }
            }
        }
    }
    
    public void func_177414_a(final Entity llllllllllllllIlIlIIIIlIIlllllIl, final AxisAlignedBB llllllllllllllIlIlIIIIlIIlllllII, final List llllllllllllllIlIlIIIIlIIllIllll, final Predicate llllllllllllllIlIlIIIIlIIllIlllI) {
        int llllllllllllllIlIlIIIIlIIllllIIl = MathHelper.floor_double((llllllllllllllIlIlIIIIlIIlllllII.minY - 2.0) / 16.0);
        int llllllllllllllIlIlIIIIlIIllllIII = MathHelper.floor_double((llllllllllllllIlIlIIIIlIIlllllII.maxY + 2.0) / 16.0);
        llllllllllllllIlIlIIIIlIIllllIIl = MathHelper.clamp_int(llllllllllllllIlIlIIIIlIIllllIIl, 0, this.entityLists.length - 1);
        llllllllllllllIlIlIIIIlIIllllIII = MathHelper.clamp_int(llllllllllllllIlIlIIIIlIIllllIII, 0, this.entityLists.length - 1);
        for (int llllllllllllllIlIlIIIIlIIlllIlll = llllllllllllllIlIlIIIIlIIllllIIl; llllllllllllllIlIlIIIIlIIlllIlll <= llllllllllllllIlIlIIIIlIIllllIII; ++llllllllllllllIlIlIIIIlIIlllIlll) {
            for (Entity llllllllllllllIlIlIIIIlIIlllIlIl : this.entityLists[llllllllllllllIlIlIIIIlIIlllIlll]) {
                if (llllllllllllllIlIlIIIIlIIlllIlIl != llllllllllllllIlIlIIIIlIIlllllIl && llllllllllllllIlIlIIIIlIIlllIlIl.getEntityBoundingBox().intersectsWith(llllllllllllllIlIlIIIIlIIlllllII) && (llllllllllllllIlIlIIIIlIIllIlllI == null || llllllllllllllIlIlIIIIlIIllIlllI.apply((Object)llllllllllllllIlIlIIIIlIIlllIlIl))) {
                    llllllllllllllIlIlIIIIlIIllIllll.add(llllllllllllllIlIlIIIIlIIlllIlIl);
                    final Entity[] llllllllllllllIlIlIIIIlIIlllIlII = llllllllllllllIlIlIIIIlIIlllIlIl.getParts();
                    if (llllllllllllllIlIlIIIIlIIlllIlII == null) {
                        continue;
                    }
                    for (int llllllllllllllIlIlIIIIlIIlllIIll = 0; llllllllllllllIlIlIIIIlIIlllIIll < llllllllllllllIlIlIIIIlIIlllIlII.length; ++llllllllllllllIlIlIIIIlIIlllIIll) {
                        llllllllllllllIlIlIIIIlIIlllIlIl = llllllllllllllIlIlIIIIlIIlllIlII[llllllllllllllIlIlIIIIlIIlllIIll];
                        if (llllllllllllllIlIlIIIIlIIlllIlIl != llllllllllllllIlIlIIIIlIIlllllIl && llllllllllllllIlIlIIIIlIIlllIlIl.getEntityBoundingBox().intersectsWith(llllllllllllllIlIlIIIIlIIlllllII) && (llllllllllllllIlIlIIIIlIIllIlllI == null || llllllllllllllIlIlIIIIlIIllIlllI.apply((Object)llllllllllllllIlIlIIIIlIIlllIlIl))) {
                            llllllllllllllIlIlIIIIlIIllIllll.add(llllllllllllllIlIlIIIIlIIlllIlIl);
                        }
                    }
                }
            }
        }
    }
    
    public void func_150809_p() {
        this.isTerrainPopulated = true;
        this.isLightPopulated = true;
        final BlockPos llllllllllllllIlIlIIIIIlIlIlIIIl = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
        if (!this.worldObj.provider.getHasNoSky()) {
            if (this.worldObj.isAreaLoaded(llllllllllllllIlIlIIIIIlIlIlIIIl.add(-1, 0, -1), llllllllllllllIlIlIIIIIlIlIlIIIl.add(16, 63, 16))) {
            Label_0116:
                for (int llllllllllllllIlIlIIIIIlIlIlIIII = 0; llllllllllllllIlIlIIIIIlIlIlIIII < 16; ++llllllllllllllIlIlIIIIIlIlIlIIII) {
                    for (int llllllllllllllIlIlIIIIIlIlIIllll = 0; llllllllllllllIlIlIIIIIlIlIIllll < 16; ++llllllllllllllIlIlIIIIIlIlIIllll) {
                        if (!this.func_150811_f(llllllllllllllIlIlIIIIIlIlIlIIII, llllllllllllllIlIlIIIIIlIlIIllll)) {
                            this.isLightPopulated = false;
                            break Label_0116;
                        }
                    }
                }
                if (this.isLightPopulated) {
                    for (final EnumFacing llllllllllllllIlIlIIIIIlIlIIllIl : EnumFacing.Plane.HORIZONTAL) {
                        final int llllllllllllllIlIlIIIIIlIlIIllII = (llllllllllllllIlIlIIIIIlIlIIllIl.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? 16 : 1;
                        this.worldObj.getChunkFromBlockCoords(llllllllllllllIlIlIIIIIlIlIlIIIl.offset(llllllllllllllIlIlIIIIIlIlIIllIl, llllllllllllllIlIlIIIIIlIlIIllII)).func_180700_a(llllllllllllllIlIlIIIIIlIlIIllIl.getOpposite());
                    }
                    this.func_177441_y();
                }
            }
            else {
                this.isLightPopulated = false;
            }
        }
    }
    
    public boolean canSeeSky(final BlockPos llllllllllllllIlIlIIIIlIllIllIIl) {
        final int llllllllllllllIlIlIIIIlIllIllIII = llllllllllllllIlIlIIIIlIllIllIIl.getX() & 0xF;
        final int llllllllllllllIlIlIIIIlIllIlIlll = llllllllllllllIlIlIIIIlIllIllIIl.getY();
        final int llllllllllllllIlIlIIIIlIllIlIllI = llllllllllllllIlIlIIIIlIllIllIIl.getZ() & 0xF;
        return llllllllllllllIlIlIIIIlIllIlIlll >= this.heightMap[llllllllllllllIlIlIIIIlIllIlIllI << 4 | llllllllllllllIlIlIIIIlIllIllIII];
    }
    
    private void checkSkylightNeighborHeight(final int llllllllllllllIlIlIIIlIIIIlIllll, final int llllllllllllllIlIlIIIlIIIIlIlllI, final int llllllllllllllIlIlIIIlIIIIlIllIl) {
        final int llllllllllllllIlIlIIIlIIIIlIllII = this.worldObj.getHorizon(new BlockPos(llllllllllllllIlIlIIIlIIIIlIllll, 0, llllllllllllllIlIlIIIlIIIIlIlllI)).getY();
        if (llllllllllllllIlIlIIIlIIIIlIllII > llllllllllllllIlIlIIIlIIIIlIllIl) {
            this.updateSkylightNeighborHeight(llllllllllllllIlIlIIIlIIIIlIllll, llllllllllllllIlIlIIIlIIIIlIlllI, llllllllllllllIlIlIIIlIIIIlIllIl, llllllllllllllIlIlIIIlIIIIlIllII + 1);
        }
        else if (llllllllllllllIlIlIIIlIIIIlIllII < llllllllllllllIlIlIIIlIIIIlIllIl) {
            this.updateSkylightNeighborHeight(llllllllllllllIlIlIIIlIIIIlIllll, llllllllllllllIlIlIIIlIIIIlIlllI, llllllllllllllIlIlIIIlIIIIlIllII, llllllllllllllIlIlIIIlIIIIlIllIl + 1);
        }
    }
    
    public boolean getAreLevelsEmpty(int llllllllllllllIlIlIIIIIlllIlIlII, int llllllllllllllIlIlIIIIIlllIlIIll) {
        if (llllllllllllllIlIlIIIIIlllIlIlII < 0) {
            llllllllllllllIlIlIIIIIlllIlIlII = 0;
        }
        if (llllllllllllllIlIlIIIIIlllIlIIll >= 256) {
            llllllllllllllIlIlIIIIIlllIlIIll = 255;
        }
        for (int llllllllllllllIlIlIIIIIlllIlIlll = llllllllllllllIlIlIIIIIlllIlIlII; llllllllllllllIlIlIIIIIlllIlIlll <= llllllllllllllIlIlIIIIIlllIlIIll; llllllllllllllIlIlIIIIIlllIlIlll += 16) {
            final ExtendedBlockStorage llllllllllllllIlIlIIIIIlllIlIllI = this.storageArrays[llllllllllllllIlIlIIIIIlllIlIlll >> 4];
            if (llllllllllllllIlIlIIIIIlllIlIllI != null && !llllllllllllllIlIlIIIIIlllIlIllI.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public int getHeight(final int llllllllllllllIlIlIIIlIIlIIlIlIl, final int llllllllllllllIlIlIIIlIIlIIlIlII) {
        return this.heightMap[llllllllllllllIlIlIIIlIIlIIlIlII << 4 | llllllllllllllIlIlIIIlIIlIIlIlIl];
    }
    
    public void onChunkUnload() {
        this.isChunkLoaded = false;
        for (final TileEntity llllllllllllllIlIlIIIIlIlIIlIIlI : this.chunkTileEntityMap.values()) {
            this.worldObj.markTileEntityForRemoval(llllllllllllllIlIlIIIIlIlIIlIIlI);
        }
        for (int llllllllllllllIlIlIIIIlIlIIlIIIl = 0; llllllllllllllIlIlIIIIlIlIIlIIIl < this.entityLists.length; ++llllllllllllllIlIlIIIIlIlIIlIIIl) {
            this.worldObj.unloadEntities(this.entityLists[llllllllllllllIlIlIIIIlIlIIlIIIl]);
        }
    }
    
    public Block getBlock(final BlockPos llllllllllllllIlIlIIIIlllIlIIllI) {
        try {
            return this.getBlock0(llllllllllllllIlIlIIIIlllIlIIllI.getX() & 0xF, llllllllllllllIlIlIIIIlllIlIIllI.getY(), llllllllllllllIlIlIIIIlllIlIIllI.getZ() & 0xF);
        }
        catch (ReportedException llllllllllllllIlIlIIIIlllIlIIlIl) {
            final CrashReportCategory llllllllllllllIlIlIIIIlllIlIIlII = llllllllllllllIlIlIIIIlllIlIIlIl.getCrashReport().makeCategory("Block being got");
            llllllllllllllIlIlIIIIlllIlIIlII.addCrashSectionCallable("Location", new Callable() {
                public String func_177455_a() {
                    return CrashReportCategory.getCoordinateInfo(llllllllllllllIlIlIIIIlllIlIIllI);
                }
                
                static {
                    __OBFID = "CL_00002011";
                }
                
                @Override
                public Object call() {
                    return this.func_177455_a();
                }
            });
            throw llllllllllllllIlIlIIIIlllIlIIlIl;
        }
    }
    
    public int[] getHeightMap() {
        return this.heightMap;
    }
    
    public boolean isTerrainPopulated() {
        return this.isTerrainPopulated;
    }
    
    public Chunk(final World llllllllllllllIlIlIIIlIIllIlIIll, final int llllllllllllllIlIlIIIlIIllIlIlll, final int llllllllllllllIlIlIIIlIIllIlIllI) {
        this.storageArrays = new ExtendedBlockStorage[16];
        this.blockBiomeArray = new byte[256];
        this.precipitationHeightMap = new int[256];
        this.updateSkylightColumns = new boolean[256];
        this.chunkTileEntityMap = Maps.newHashMap();
        this.queuedLightChecks = 4096;
        this.field_177447_w = Queues.newConcurrentLinkedQueue();
        this.entityLists = new ClassInheratanceMultiMap[16];
        this.worldObj = llllllllllllllIlIlIIIlIIllIlIIll;
        this.xPosition = llllllllllllllIlIlIIIlIIllIlIlll;
        this.zPosition = llllllllllllllIlIlIIIlIIllIlIllI;
        this.heightMap = new int[256];
        for (int llllllllllllllIlIlIIIlIIllIlIlIl = 0; llllllllllllllIlIlIIIlIIllIlIlIl < this.entityLists.length; ++llllllllllllllIlIlIIIlIIllIlIlIl) {
            this.entityLists[llllllllllllllIlIlIIIlIIllIlIlIl] = new ClassInheratanceMultiMap(Entity.class);
        }
        Arrays.fill(this.precipitationHeightMap, -999);
        Arrays.fill(this.blockBiomeArray, (byte)(-1));
    }
    
    public void func_177430_a(final Class llllllllllllllIlIlIIIIlIIlIlIIIl, final AxisAlignedBB llllllllllllllIlIlIIIIlIIlIllIlI, final List llllllllllllllIlIlIIIIlIIlIllIIl, final Predicate llllllllllllllIlIlIIIIlIIlIllIII) {
        int llllllllllllllIlIlIIIIlIIlIlIlll = MathHelper.floor_double((llllllllllllllIlIlIIIIlIIlIllIlI.minY - 2.0) / 16.0);
        int llllllllllllllIlIlIIIIlIIlIlIllI = MathHelper.floor_double((llllllllllllllIlIlIIIIlIIlIllIlI.maxY + 2.0) / 16.0);
        llllllllllllllIlIlIIIIlIIlIlIlll = MathHelper.clamp_int(llllllllllllllIlIlIIIIlIIlIlIlll, 0, this.entityLists.length - 1);
        llllllllllllllIlIlIIIIlIIlIlIllI = MathHelper.clamp_int(llllllllllllllIlIlIIIIlIIlIlIllI, 0, this.entityLists.length - 1);
        for (int llllllllllllllIlIlIIIIlIIlIlIlIl = llllllllllllllIlIlIIIIlIIlIlIlll; llllllllllllllIlIlIIIIlIIlIlIlIl <= llllllllllllllIlIlIIIIlIIlIlIllI; ++llllllllllllllIlIlIIIIlIIlIlIlIl) {
            for (final Entity llllllllllllllIlIlIIIIlIIlIlIIll : this.entityLists[llllllllllllllIlIlIIIIlIIlIlIlIl].func_180215_b(llllllllllllllIlIlIIIIlIIlIlIIIl)) {
                if (llllllllllllllIlIlIIIIlIIlIlIIll.getEntityBoundingBox().intersectsWith(llllllllllllllIlIlIIIIlIIlIllIlI) && (llllllllllllllIlIlIIIIlIIlIllIII == null || llllllllllllllIlIlIIIIlIIlIllIII.apply((Object)llllllllllllllIlIlIIIIlIIlIlIIll))) {
                    llllllllllllllIlIlIIIIlIIlIllIIl.add(llllllllllllllIlIlIIIIlIIlIlIIll);
                }
            }
        }
    }
    
    public BlockPos func_177440_h(final BlockPos llllllllllllllIlIlIIIIlIIIIIIlII) {
        final int llllllllllllllIlIlIIIIlIIIIIIIll = llllllllllllllIlIlIIIIlIIIIIIlII.getX() & 0xF;
        final int llllllllllllllIlIlIIIIlIIIIIIIlI = llllllllllllllIlIlIIIIlIIIIIIlII.getZ() & 0xF;
        final int llllllllllllllIlIlIIIIlIIIIIIIIl = llllllllllllllIlIlIIIIlIIIIIIIll | llllllllllllllIlIlIIIIlIIIIIIIlI << 4;
        BlockPos llllllllllllllIlIlIIIIlIIIIIIIII = new BlockPos(llllllllllllllIlIlIIIIlIIIIIIlII.getX(), this.precipitationHeightMap[llllllllllllllIlIlIIIIlIIIIIIIIl], llllllllllllllIlIlIIIIlIIIIIIlII.getZ());
        if (llllllllllllllIlIlIIIIlIIIIIIIII.getY() == -999) {
            final int llllllllllllllIlIlIIIIIlllllllll = this.getTopFilledSegment() + 15;
            llllllllllllllIlIlIIIIlIIIIIIIII = new BlockPos(llllllllllllllIlIlIIIIlIIIIIIlII.getX(), llllllllllllllIlIlIIIIIlllllllll, llllllllllllllIlIlIIIIlIIIIIIlII.getZ());
            int llllllllllllllIlIlIIIIIllllllllI = -1;
            while (llllllllllllllIlIlIIIIlIIIIIIIII.getY() > 0 && llllllllllllllIlIlIIIIIllllllllI == -1) {
                final Block llllllllllllllIlIlIIIIIlllllllIl = this.getBlock(llllllllllllllIlIlIIIIlIIIIIIIII);
                final Material llllllllllllllIlIlIIIIIlllllllII = llllllllllllllIlIlIIIIIlllllllIl.getMaterial();
                if (!llllllllllllllIlIlIIIIIlllllllII.blocksMovement() && !llllllllllllllIlIlIIIIIlllllllII.isLiquid()) {
                    llllllllllllllIlIlIIIIlIIIIIIIII = llllllllllllllIlIlIIIIlIIIIIIIII.offsetDown();
                }
                else {
                    llllllllllllllIlIlIIIIIllllllllI = llllllllllllllIlIlIIIIlIIIIIIIII.getY() + 1;
                }
            }
            this.precipitationHeightMap[llllllllllllllIlIlIIIIlIIIIIIIIl] = llllllllllllllIlIlIIIIIllllllllI;
        }
        return new BlockPos(llllllllllllllIlIlIIIIlIIIIIIlII.getX(), this.precipitationHeightMap[llllllllllllllIlIlIIIIlIIIIIIIIl], llllllllllllllIlIlIIIIlIIIIIIlII.getZ());
    }
    
    public void enqueueRelightChecks() {
        final BlockPos llllllllllllllIlIlIIIIIlIlllIIlI = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
        for (int llllllllllllllIlIlIIIIIlIlllIIIl = 0; llllllllllllllIlIlIIIIIlIlllIIIl < 8; ++llllllllllllllIlIlIIIIIlIlllIIIl) {
            if (this.queuedLightChecks >= 4096) {
                return;
            }
            final int llllllllllllllIlIlIIIIIlIlllIIII = this.queuedLightChecks % 16;
            final int llllllllllllllIlIlIIIIIlIllIllll = this.queuedLightChecks / 16 % 16;
            final int llllllllllllllIlIlIIIIIlIllIlllI = this.queuedLightChecks / 256;
            ++this.queuedLightChecks;
            for (int llllllllllllllIlIlIIIIIlIllIllIl = 0; llllllllllllllIlIlIIIIIlIllIllIl < 16; ++llllllllllllllIlIlIIIIIlIllIllIl) {
                final BlockPos llllllllllllllIlIlIIIIIlIllIllII = llllllllllllllIlIlIIIIIlIlllIIlI.add(llllllllllllllIlIlIIIIIlIllIllll, (llllllllllllllIlIlIIIIIlIlllIIII << 4) + llllllllllllllIlIlIIIIIlIllIllIl, llllllllllllllIlIlIIIIIlIllIlllI);
                final boolean llllllllllllllIlIlIIIIIlIllIlIll = llllllllllllllIlIlIIIIIlIllIllIl == 0 || llllllllllllllIlIlIIIIIlIllIllIl == 15 || llllllllllllllIlIlIIIIIlIllIllll == 0 || llllllllllllllIlIlIIIIIlIllIllll == 15 || llllllllllllllIlIlIIIIIlIllIlllI == 0 || llllllllllllllIlIlIIIIIlIllIlllI == 15;
                if ((this.storageArrays[llllllllllllllIlIlIIIIIlIlllIIII] == null && llllllllllllllIlIlIIIIIlIllIlIll) || (this.storageArrays[llllllllllllllIlIlIIIIIlIlllIIII] != null && this.storageArrays[llllllllllllllIlIlIIIIIlIlllIIII].getBlockByExtId(llllllllllllllIlIlIIIIIlIllIllll, llllllllllllllIlIlIIIIIlIllIllIl, llllllllllllllIlIlIIIIIlIllIlllI).getMaterial() == Material.air)) {
                    for (final EnumFacing llllllllllllllIlIlIIIIIlIllIIlll : EnumFacing.values()) {
                        final BlockPos llllllllllllllIlIlIIIIIlIllIIllI = llllllllllllllIlIlIIIIIlIllIllII.offset(llllllllllllllIlIlIIIIIlIllIIlll);
                        if (this.worldObj.getBlockState(llllllllllllllIlIlIIIIIlIllIIllI).getBlock().getLightValue() > 0) {
                            this.worldObj.checkLight(llllllllllllllIlIlIIIIIlIllIIllI);
                        }
                    }
                    this.worldObj.checkLight(llllllllllllllIlIlIIIIIlIllIllII);
                }
            }
        }
    }
    
    public int getBlockMetadata(final BlockPos llllllllllllllIlIlIIIIllIlllIlIl) {
        return this.getBlockMetadata(llllllllllllllIlIlIIIIllIlllIlIl.getX() & 0xF, llllllllllllllIlIlIIIIllIlllIlIl.getY(), llllllllllllllIlIlIIIIllIlllIlIl.getZ() & 0xF);
    }
    
    public boolean isPopulated() {
        return this.field_150815_m && this.isTerrainPopulated && this.isLightPopulated;
    }
    
    public void removeEntity(final Entity llllllllllllllIlIlIIIIlIlllIlIIl) {
        this.removeEntityAtIndex(llllllllllllllIlIlIIIIlIlllIlIIl, llllllllllllllIlIlIIIIlIlllIlIIl.chunkCoordY);
    }
    
    public BiomeGenBase getBiome(final BlockPos llllllllllllllIlIlIIIIIllIIllllI, final WorldChunkManager llllllllllllllIlIlIIIIIllIIlllIl) {
        final int llllllllllllllIlIlIIIIIllIIlllII = llllllllllllllIlIlIIIIIllIIllllI.getX() & 0xF;
        final int llllllllllllllIlIlIIIIIllIIllIll = llllllllllllllIlIlIIIIIllIIllllI.getZ() & 0xF;
        int llllllllllllllIlIlIIIIIllIIllIlI = this.blockBiomeArray[llllllllllllllIlIlIIIIIllIIllIll << 4 | llllllllllllllIlIlIIIIIllIIlllII] & 0xFF;
        if (llllllllllllllIlIlIIIIIllIIllIlI == 255) {
            final BiomeGenBase llllllllllllllIlIlIIIIIllIIllIIl = llllllllllllllIlIlIIIIIllIIlllIl.func_180300_a(llllllllllllllIlIlIIIIIllIIllllI, BiomeGenBase.plains);
            llllllllllllllIlIlIIIIIllIIllIlI = llllllllllllllIlIlIIIIIllIIllIIl.biomeID;
            this.blockBiomeArray[llllllllllllllIlIlIIIIIllIIllIll << 4 | llllllllllllllIlIlIIIIIllIIlllII] = (byte)(llllllllllllllIlIlIIIIIllIIllIlI & 0xFF);
        }
        final BiomeGenBase llllllllllllllIlIlIIIIIllIIllIII = BiomeGenBase.getBiome(llllllllllllllIlIlIIIIIllIIllIlI);
        return (llllllllllllllIlIlIIIIIllIIllIII == null) ? BiomeGenBase.plains : llllllllllllllIlIlIIIIIllIIllIII;
    }
    
    public IBlockState setBlockState(final BlockPos llllllllllllllIlIlIIIIllIlIlIIll, final IBlockState llllllllllllllIlIlIIIIllIlIlIIlI) {
        final int llllllllllllllIlIlIIIIllIllIIIlI = llllllllllllllIlIlIIIIllIlIlIIll.getX() & 0xF;
        final int llllllllllllllIlIlIIIIllIllIIIIl = llllllllllllllIlIlIIIIllIlIlIIll.getY();
        final int llllllllllllllIlIlIIIIllIllIIIII = llllllllllllllIlIlIIIIllIlIlIIll.getZ() & 0xF;
        final int llllllllllllllIlIlIIIIllIlIlllll = llllllllllllllIlIlIIIIllIllIIIII << 4 | llllllllllllllIlIlIIIIllIllIIIlI;
        if (llllllllllllllIlIlIIIIllIllIIIIl >= this.precipitationHeightMap[llllllllllllllIlIlIIIIllIlIlllll] - 1) {
            this.precipitationHeightMap[llllllllllllllIlIlIIIIllIlIlllll] = -999;
        }
        final int llllllllllllllIlIlIIIIllIlIllllI = this.heightMap[llllllllllllllIlIlIIIIllIlIlllll];
        final IBlockState llllllllllllllIlIlIIIIllIlIlllIl = this.getBlockState(llllllllllllllIlIlIIIIllIlIlIIll);
        if (llllllllllllllIlIlIIIIllIlIlllIl == llllllllllllllIlIlIIIIllIlIlIIlI) {
            return null;
        }
        final Block llllllllllllllIlIlIIIIllIlIlllII = llllllllllllllIlIlIIIIllIlIlIIlI.getBlock();
        final Block llllllllllllllIlIlIIIIllIlIllIll = llllllllllllllIlIlIIIIllIlIlllIl.getBlock();
        ExtendedBlockStorage llllllllllllllIlIlIIIIllIlIllIlI = this.storageArrays[llllllllllllllIlIlIIIIllIllIIIIl >> 4];
        boolean llllllllllllllIlIlIIIIllIlIllIIl = false;
        if (llllllllllllllIlIlIIIIllIlIllIlI == null) {
            if (llllllllllllllIlIlIIIIllIlIlllII == Blocks.air) {
                return null;
            }
            final ExtendedBlockStorage[] storageArrays = this.storageArrays;
            final int n = llllllllllllllIlIlIIIIllIllIIIIl >> 4;
            final ExtendedBlockStorage extendedBlockStorage = new ExtendedBlockStorage(llllllllllllllIlIlIIIIllIllIIIIl >> 4 << 4, !this.worldObj.provider.getHasNoSky());
            storageArrays[n] = extendedBlockStorage;
            llllllllllllllIlIlIIIIllIlIllIlI = extendedBlockStorage;
            llllllllllllllIlIlIIIIllIlIllIIl = (llllllllllllllIlIlIIIIllIllIIIIl >= llllllllllllllIlIlIIIIllIlIllllI);
        }
        llllllllllllllIlIlIIIIllIlIllIlI.set(llllllllllllllIlIlIIIIllIllIIIlI, llllllllllllllIlIlIIIIllIllIIIIl & 0xF, llllllllllllllIlIlIIIIllIllIIIII, llllllllllllllIlIlIIIIllIlIlIIlI);
        if (llllllllllllllIlIlIIIIllIlIllIll != llllllllllllllIlIlIIIIllIlIlllII) {
            if (!this.worldObj.isRemote) {
                llllllllllllllIlIlIIIIllIlIllIll.breakBlock(this.worldObj, llllllllllllllIlIlIIIIllIlIlIIll, llllllllllllllIlIlIIIIllIlIlllIl);
            }
            else if (llllllllllllllIlIlIIIIllIlIllIll instanceof ITileEntityProvider) {
                this.worldObj.removeTileEntity(llllllllllllllIlIlIIIIllIlIlIIll);
            }
        }
        if (llllllllllllllIlIlIIIIllIlIllIlI.getBlockByExtId(llllllllllllllIlIlIIIIllIllIIIlI, llllllllllllllIlIlIIIIllIllIIIIl & 0xF, llllllllllllllIlIlIIIIllIllIIIII) != llllllllllllllIlIlIIIIllIlIlllII) {
            return null;
        }
        if (llllllllllllllIlIlIIIIllIlIllIIl) {
            this.generateSkylightMap();
        }
        else {
            final int llllllllllllllIlIlIIIIllIlIllIII = llllllllllllllIlIlIIIIllIlIlllII.getLightOpacity();
            final int llllllllllllllIlIlIIIIllIlIlIlll = llllllllllllllIlIlIIIIllIlIllIll.getLightOpacity();
            if (llllllllllllllIlIlIIIIllIlIllIII > 0) {
                if (llllllllllllllIlIlIIIIllIllIIIIl >= llllllllllllllIlIlIIIIllIlIllllI) {
                    this.relightBlock(llllllllllllllIlIlIIIIllIllIIIlI, llllllllllllllIlIlIIIIllIllIIIIl + 1, llllllllllllllIlIlIIIIllIllIIIII);
                }
            }
            else if (llllllllllllllIlIlIIIIllIllIIIIl == llllllllllllllIlIlIIIIllIlIllllI - 1) {
                this.relightBlock(llllllllllllllIlIlIIIIllIllIIIlI, llllllllllllllIlIlIIIIllIllIIIIl, llllllllllllllIlIlIIIIllIllIIIII);
            }
            if (llllllllllllllIlIlIIIIllIlIllIII != llllllllllllllIlIlIIIIllIlIlIlll && (llllllllllllllIlIlIIIIllIlIllIII < llllllllllllllIlIlIIIIllIlIlIlll || this.getLightFor(EnumSkyBlock.SKY, llllllllllllllIlIlIIIIllIlIlIIll) > 0 || this.getLightFor(EnumSkyBlock.BLOCK, llllllllllllllIlIlIIIIllIlIlIIll) > 0)) {
                this.propagateSkylightOcclusion(llllllllllllllIlIlIIIIllIllIIIlI, llllllllllllllIlIlIIIIllIllIIIII);
            }
        }
        if (llllllllllllllIlIlIIIIllIlIllIll instanceof ITileEntityProvider) {
            final TileEntity llllllllllllllIlIlIIIIllIlIlIllI = this.func_177424_a(llllllllllllllIlIlIIIIllIlIlIIll, EnumCreateEntityType.CHECK);
            if (llllllllllllllIlIlIIIIllIlIlIllI != null) {
                llllllllllllllIlIlIIIIllIlIlIllI.updateContainingBlockInfo();
            }
        }
        if (!this.worldObj.isRemote && llllllllllllllIlIlIIIIllIlIllIll != llllllllllllllIlIlIIIIllIlIlllII) {
            llllllllllllllIlIlIIIIllIlIlllII.onBlockAdded(this.worldObj, llllllllllllllIlIlIIIIllIlIlIIll, llllllllllllllIlIlIIIIllIlIlIIlI);
        }
        if (llllllllllllllIlIlIIIIllIlIlllII instanceof ITileEntityProvider) {
            TileEntity llllllllllllllIlIlIIIIllIlIlIlIl = this.func_177424_a(llllllllllllllIlIlIIIIllIlIlIIll, EnumCreateEntityType.CHECK);
            if (llllllllllllllIlIlIIIIllIlIlIlIl == null) {
                llllllllllllllIlIlIIIIllIlIlIlIl = ((ITileEntityProvider)llllllllllllllIlIlIIIIllIlIlllII).createNewTileEntity(this.worldObj, llllllllllllllIlIlIIIIllIlIlllII.getMetaFromState(llllllllllllllIlIlIIIIllIlIlIIlI));
                this.worldObj.setTileEntity(llllllllllllllIlIlIIIIllIlIlIIll, llllllllllllllIlIlIIIIllIlIlIlIl);
            }
            if (llllllllllllllIlIlIIIIllIlIlIlIl != null) {
                llllllllllllllIlIlIIIIllIlIlIlIl.updateContainingBlockInfo();
            }
        }
        this.isModified = true;
        return llllllllllllllIlIlIIIIllIlIlllIl;
    }
    
    public Random getRandomWithSeed(final long llllllllllllllIlIlIIIIlIIIllllIl) {
        return new Random(this.worldObj.getSeed() + this.xPosition * this.xPosition * 4987142 + this.xPosition * 5947611 + this.zPosition * this.zPosition * 4392871L + this.zPosition * 389711 ^ llllllllllllllIlIlIIIIlIIIllllIl);
    }
    
    public long getInhabitedTime() {
        return this.inhabitedTime;
    }
    
    public void setInhabitedTime(final long llllllllllllllIlIlIIIIIIllIIlIII) {
        this.inhabitedTime = llllllllllllllIlIlIIIIIIllIIlIII;
    }
    
    public void func_177439_a(final byte[] llllllllllllllIlIlIIIIIllIllllII, final int llllllllllllllIlIlIIIIIllIlllIll, final boolean llllllllllllllIlIlIIIIIllIlllIlI) {
        int llllllllllllllIlIlIIIIIllIlllIIl = 0;
        final boolean llllllllllllllIlIlIIIIIllIlllIII = !this.worldObj.provider.getHasNoSky();
        for (int llllllllllllllIlIlIIIIIllIllIlll = 0; llllllllllllllIlIlIIIIIllIllIlll < this.storageArrays.length; ++llllllllllllllIlIlIIIIIllIllIlll) {
            if ((llllllllllllllIlIlIIIIIllIlllIll & 1 << llllllllllllllIlIlIIIIIllIllIlll) != 0x0) {
                if (this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll] == null) {
                    this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll] = new ExtendedBlockStorage(llllllllllllllIlIlIIIIIllIllIlll << 4, llllllllllllllIlIlIIIIIllIlllIII);
                }
                final char[] llllllllllllllIlIlIIIIIllIllIllI = this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll].getData();
                for (int llllllllllllllIlIlIIIIIllIllIlIl = 0; llllllllllllllIlIlIIIIIllIllIlIl < llllllllllllllIlIlIIIIIllIllIllI.length; ++llllllllllllllIlIlIIIIIllIllIlIl) {
                    llllllllllllllIlIlIIIIIllIllIllI[llllllllllllllIlIlIIIIIllIllIlIl] = (char)((llllllllllllllIlIlIIIIIllIllllII[llllllllllllllIlIlIIIIIllIlllIIl + 1] & 0xFF) << 8 | (llllllllllllllIlIlIIIIIllIllllII[llllllllllllllIlIlIIIIIllIlllIIl] & 0xFF));
                    llllllllllllllIlIlIIIIIllIlllIIl += 2;
                }
            }
            else if (llllllllllllllIlIlIIIIIllIlllIlI && this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll] != null) {
                this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll] = null;
            }
        }
        for (int llllllllllllllIlIlIIIIIllIllIlll = 0; llllllllllllllIlIlIIIIIllIllIlll < this.storageArrays.length; ++llllllllllllllIlIlIIIIIllIllIlll) {
            if ((llllllllllllllIlIlIIIIIllIlllIll & 1 << llllllllllllllIlIlIIIIIllIllIlll) != 0x0 && this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll] != null) {
                final NibbleArray llllllllllllllIlIlIIIIIllIllIlII = this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll].getBlocklightArray();
                System.arraycopy(llllllllllllllIlIlIIIIIllIllllII, llllllllllllllIlIlIIIIIllIlllIIl, llllllllllllllIlIlIIIIIllIllIlII.getData(), 0, llllllllllllllIlIlIIIIIllIllIlII.getData().length);
                llllllllllllllIlIlIIIIIllIlllIIl += llllllllllllllIlIlIIIIIllIllIlII.getData().length;
            }
        }
        if (llllllllllllllIlIlIIIIIllIlllIII) {
            for (int llllllllllllllIlIlIIIIIllIllIlll = 0; llllllllllllllIlIlIIIIIllIllIlll < this.storageArrays.length; ++llllllllllllllIlIlIIIIIllIllIlll) {
                if ((llllllllllllllIlIlIIIIIllIlllIll & 1 << llllllllllllllIlIlIIIIIllIllIlll) != 0x0 && this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll] != null) {
                    final NibbleArray llllllllllllllIlIlIIIIIllIllIIll = this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll].getSkylightArray();
                    System.arraycopy(llllllllllllllIlIlIIIIIllIllllII, llllllllllllllIlIlIIIIIllIlllIIl, llllllllllllllIlIlIIIIIllIllIIll.getData(), 0, llllllllllllllIlIlIIIIIllIllIIll.getData().length);
                    llllllllllllllIlIlIIIIIllIlllIIl += llllllllllllllIlIlIIIIIllIllIIll.getData().length;
                }
            }
        }
        if (llllllllllllllIlIlIIIIIllIlllIlI) {
            System.arraycopy(llllllllllllllIlIlIIIIIllIllllII, llllllllllllllIlIlIIIIIllIlllIIl, this.blockBiomeArray, 0, this.blockBiomeArray.length);
            final int n = llllllllllllllIlIlIIIIIllIlllIIl + this.blockBiomeArray.length;
        }
        for (int llllllllllllllIlIlIIIIIllIllIlll = 0; llllllllllllllIlIlIIIIIllIllIlll < this.storageArrays.length; ++llllllllllllllIlIlIIIIIllIllIlll) {
            if (this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll] != null && (llllllllllllllIlIlIIIIIllIlllIll & 1 << llllllllllllllIlIlIIIIIllIllIlll) != 0x0) {
                this.storageArrays[llllllllllllllIlIlIIIIIllIllIlll].removeInvalidBlocks();
            }
        }
        this.isLightPopulated = true;
        this.isTerrainPopulated = true;
        this.generateHeightMap();
        for (final TileEntity llllllllllllllIlIlIIIIIllIllIIIl : this.chunkTileEntityMap.values()) {
            llllllllllllllIlIlIIIIIllIllIIIl.updateContainingBlockInfo();
        }
    }
    
    private void func_180700_a(final EnumFacing llllllllllllllIlIlIIIIIlIIllllII) {
        if (this.isTerrainPopulated) {
            if (llllllllllllllIlIlIIIIIlIIllllII == EnumFacing.EAST) {
                for (int llllllllllllllIlIlIIIIIlIIlllIll = 0; llllllllllllllIlIlIIIIIlIIlllIll < 16; ++llllllllllllllIlIlIIIIIlIIlllIll) {
                    this.func_150811_f(15, llllllllllllllIlIlIIIIIlIIlllIll);
                }
            }
            else if (llllllllllllllIlIlIIIIIlIIllllII == EnumFacing.WEST) {
                for (int llllllllllllllIlIlIIIIIlIIlllIlI = 0; llllllllllllllIlIlIIIIIlIIlllIlI < 16; ++llllllllllllllIlIlIIIIIlIIlllIlI) {
                    this.func_150811_f(0, llllllllllllllIlIlIIIIIlIIlllIlI);
                }
            }
            else if (llllllllllllllIlIlIIIIIlIIllllII == EnumFacing.SOUTH) {
                for (int llllllllllllllIlIlIIIIIlIIlllIIl = 0; llllllllllllllIlIlIIIIIlIIlllIIl < 16; ++llllllllllllllIlIlIIIIIlIIlllIIl) {
                    this.func_150811_f(llllllllllllllIlIlIIIIIlIIlllIIl, 15);
                }
            }
            else if (llllllllllllllIlIlIIIIIlIIllllII == EnumFacing.NORTH) {
                for (int llllllllllllllIlIlIIIIIlIIlllIII = 0; llllllllllllllIlIlIIIIIlIIlllIII < 16; ++llllllllllllllIlIlIIIIIlIIlllIII) {
                    this.func_150811_f(llllllllllllllIlIlIIIIIlIIlllIII, 0);
                }
            }
        }
    }
    
    public void setTerrainPopulated(final boolean llllllllllllllIlIlIIIIIIlllIllll) {
        this.isTerrainPopulated = llllllllllllllIlIlIIIIIIlllIllll;
    }
    
    private void propagateSkylightOcclusion(final int llllllllllllllIlIlIIIlIIIlIlIllI, final int llllllllllllllIlIlIIIlIIIlIllIII) {
        this.updateSkylightColumns[llllllllllllllIlIlIIIlIIIlIlIllI + llllllllllllllIlIlIIIlIIIlIllIII * 16] = true;
        this.isGapLightingUpdated = true;
    }
    
    public void addTileEntity(final TileEntity llllllllllllllIlIlIIIIlIlIllIllI) {
        this.addTileEntity(llllllllllllllIlIlIIIIlIlIllIllI.getPos(), llllllllllllllIlIlIIIIlIlIllIllI);
        if (this.isChunkLoaded) {
            this.worldObj.addTileEntity(llllllllllllllIlIlIIIIlIlIllIllI);
        }
    }
    
    public void setHeightMap(final int[] llllllllllllllIlIlIIIIIlIIIIIIlI) {
        if (this.heightMap.length != llllllllllllllIlIlIIIIIlIIIIIIlI.length) {
            Chunk.logger.warn(String.valueOf(new StringBuilder("Could not set level chunk heightmap, array length is ").append(llllllllllllllIlIlIIIIIlIIIIIIlI.length).append(" instead of ").append(this.heightMap.length)));
        }
        else {
            for (int llllllllllllllIlIlIIIIIlIIIIIIIl = 0; llllllllllllllIlIlIIIIIlIIIIIIIl < this.heightMap.length; ++llllllllllllllIlIlIIIIIlIIIIIIIl) {
                this.heightMap[llllllllllllllIlIlIIIIIlIIIIIIIl] = llllllllllllllIlIlIIIIIlIIIIIIlI[llllllllllllllIlIlIIIIIlIIIIIIIl];
            }
        }
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    private void updateSkylightNeighborHeight(final int llllllllllllllIlIlIIIlIIIIIllIIl, final int llllllllllllllIlIlIIIlIIIIIllllI, final int llllllllllllllIlIlIIIlIIIIIlllIl, final int llllllllllllllIlIlIIIlIIIIIlllII) {
        if (llllllllllllllIlIlIIIlIIIIIlllII > llllllllllllllIlIlIIIlIIIIIlllIl && this.worldObj.isAreaLoaded(new BlockPos(llllllllllllllIlIlIIIlIIIIIllIIl, 0, llllllllllllllIlIlIIIlIIIIIllllI), 16)) {
            for (int llllllllllllllIlIlIIIlIIIIIllIll = llllllllllllllIlIlIIIlIIIIIlllIl; llllllllllllllIlIlIIIlIIIIIllIll < llllllllllllllIlIlIIIlIIIIIlllII; ++llllllllllllllIlIlIIIlIIIIIllIll) {
                this.worldObj.checkLightFor(EnumSkyBlock.SKY, new BlockPos(llllllllllllllIlIlIIIlIIIIIllIIl, llllllllllllllIlIlIIIlIIIIIllIll, llllllllllllllIlIlIIIlIIIIIllllI));
            }
            this.isModified = true;
        }
    }
    
    private Block getBlock0(final int llllllllllllllIlIlIIIIllllIIIlII, final int llllllllllllllIlIlIIIIllllIIIIll, final int llllllllllllllIlIlIIIIllllIIlIlI) {
        Block llllllllllllllIlIlIIIIllllIIlIIl = Blocks.air;
        if (llllllllllllllIlIlIIIIllllIIIIll >= 0 && llllllllllllllIlIlIIIIllllIIIIll >> 4 < this.storageArrays.length) {
            final ExtendedBlockStorage llllllllllllllIlIlIIIIllllIIlIII = this.storageArrays[llllllllllllllIlIlIIIIllllIIIIll >> 4];
            if (llllllllllllllIlIlIIIIllllIIlIII != null) {
                try {
                    llllllllllllllIlIlIIIIllllIIlIIl = llllllllllllllIlIlIIIIllllIIlIII.getBlockByExtId(llllllllllllllIlIlIIIIllllIIIlII, llllllllllllllIlIlIIIIllllIIIIll & 0xF, llllllllllllllIlIlIIIIllllIIlIlI);
                }
                catch (Throwable llllllllllllllIlIlIIIIllllIIIlll) {
                    final CrashReport llllllllllllllIlIlIIIIllllIIIllI = CrashReport.makeCrashReport(llllllllllllllIlIlIIIIllllIIIlll, "Getting block");
                    throw new ReportedException(llllllllllllllIlIlIIIIllllIIIllI);
                }
            }
        }
        return llllllllllllllIlIlIIIIllllIIlIIl;
    }
    
    private void func_177441_y() {
        for (int llllllllllllllIlIlIIIIIlIlIIIIll = 0; llllllllllllllIlIlIIIIIlIlIIIIll < this.updateSkylightColumns.length; ++llllllllllllllIlIlIIIIIlIlIIIIll) {
            this.updateSkylightColumns[llllllllllllllIlIlIIIIIlIlIIIIll] = true;
        }
        this.recheckGaps(false);
    }
    
    public void populateChunk(final IChunkProvider llllllllllllllIlIlIIIIlIIIIlllII, final IChunkProvider llllllllllllllIlIlIIIIlIIIIllIll, final int llllllllllllllIlIlIIIIlIIIlIlIlI, final int llllllllllllllIlIlIIIIlIIIIllIIl) {
        final boolean llllllllllllllIlIlIIIIlIIIlIlIII = llllllllllllllIlIlIIIIlIIIIlllII.chunkExists(llllllllllllllIlIlIIIIlIIIlIlIlI, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
        final boolean llllllllllllllIlIlIIIIlIIIlIIlll = llllllllllllllIlIlIIIIlIIIIlllII.chunkExists(llllllllllllllIlIlIIIIlIIIlIlIlI + 1, llllllllllllllIlIlIIIIlIIIIllIIl);
        final boolean llllllllllllllIlIlIIIIlIIIlIIllI = llllllllllllllIlIlIIIIlIIIIlllII.chunkExists(llllllllllllllIlIlIIIIlIIIlIlIlI, llllllllllllllIlIlIIIIlIIIIllIIl + 1);
        final boolean llllllllllllllIlIlIIIIlIIIlIIlIl = llllllllllllllIlIlIIIIlIIIIlllII.chunkExists(llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl);
        final boolean llllllllllllllIlIlIIIIlIIIlIIlII = llllllllllllllIlIlIIIIlIIIIlllII.chunkExists(llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
        final boolean llllllllllllllIlIlIIIIlIIIlIIIll = llllllllllllllIlIlIIIIlIIIIlllII.chunkExists(llllllllllllllIlIlIIIIlIIIlIlIlI + 1, llllllllllllllIlIlIIIIlIIIIllIIl + 1);
        final boolean llllllllllllllIlIlIIIIlIIIlIIIlI = llllllllllllllIlIlIIIIlIIIIlllII.chunkExists(llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl + 1);
        final boolean llllllllllllllIlIlIIIIlIIIlIIIIl = llllllllllllllIlIlIIIIlIIIIlllII.chunkExists(llllllllllllllIlIlIIIIlIIIlIlIlI + 1, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
        if (llllllllllllllIlIlIIIIlIIIlIIlll && llllllllllllllIlIlIIIIlIIIlIIllI && llllllllllllllIlIlIIIIlIIIlIIIll) {
            if (!this.isTerrainPopulated) {
                llllllllllllllIlIlIIIIlIIIIlllII.populate(llllllllllllllIlIlIIIIlIIIIllIll, llllllllllllllIlIlIIIIlIIIlIlIlI, llllllllllllllIlIlIIIIlIIIIllIIl);
            }
            else {
                llllllllllllllIlIlIIIIlIIIIlllII.func_177460_a(llllllllllllllIlIlIIIIlIIIIllIll, this, llllllllllllllIlIlIIIIlIIIlIlIlI, llllllllllllllIlIlIIIIlIIIIllIIl);
            }
        }
        if (llllllllllllllIlIlIIIIlIIIlIIlIl && llllllllllllllIlIlIIIIlIIIlIIllI && llllllllllllllIlIlIIIIlIIIlIIIlI) {
            final Chunk llllllllllllllIlIlIIIIlIIIlIIIII = llllllllllllllIlIlIIIIlIIIIlllII.provideChunk(llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl);
            if (!llllllllllllllIlIlIIIIlIIIlIIIII.isTerrainPopulated) {
                llllllllllllllIlIlIIIIlIIIIlllII.populate(llllllllllllllIlIlIIIIlIIIIllIll, llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl);
            }
            else {
                llllllllllllllIlIlIIIIlIIIIlllII.func_177460_a(llllllllllllllIlIlIIIIlIIIIllIll, llllllllllllllIlIlIIIIlIIIlIIIII, llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl);
            }
        }
        if (llllllllllllllIlIlIIIIlIIIlIlIII && llllllllllllllIlIlIIIIlIIIlIIlll && llllllllllllllIlIlIIIIlIIIlIIIIl) {
            final Chunk llllllllllllllIlIlIIIIlIIIIlllll = llllllllllllllIlIlIIIIlIIIIlllII.provideChunk(llllllllllllllIlIlIIIIlIIIlIlIlI, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
            if (!llllllllllllllIlIlIIIIlIIIIlllll.isTerrainPopulated) {
                llllllllllllllIlIlIIIIlIIIIlllII.populate(llllllllllllllIlIlIIIIlIIIIllIll, llllllllllllllIlIlIIIIlIIIlIlIlI, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
            }
            else {
                llllllllllllllIlIlIIIIlIIIIlllII.func_177460_a(llllllllllllllIlIlIIIIlIIIIllIll, llllllllllllllIlIlIIIIlIIIIlllll, llllllllllllllIlIlIIIIlIIIlIlIlI, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
            }
        }
        if (llllllllllllllIlIlIIIIlIIIlIIlII && llllllllllllllIlIlIIIIlIIIlIlIII && llllllllllllllIlIlIIIIlIIIlIIlIl) {
            final Chunk llllllllllllllIlIlIIIIlIIIIllllI = llllllllllllllIlIlIIIIlIIIIlllII.provideChunk(llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
            if (!llllllllllllllIlIlIIIIlIIIIllllI.isTerrainPopulated) {
                llllllllllllllIlIlIIIIlIIIIlllII.populate(llllllllllllllIlIlIIIIlIIIIllIll, llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
            }
            else {
                llllllllllllllIlIlIIIIlIIIIlllII.func_177460_a(llllllllllllllIlIlIIIIlIIIIllIll, llllllllllllllIlIlIIIIlIIIIllllI, llllllllllllllIlIlIIIIlIIIlIlIlI - 1, llllllllllllllIlIlIIIIlIIIIllIIl - 1);
            }
        }
    }
    
    public void setModified(final boolean llllllllllllllIlIlIIIIIIlllIIIII) {
        this.isModified = llllllllllllllIlIlIIIIIIlllIIIII;
    }
    
    public void resetRelightChecks() {
        this.queuedLightChecks = 0;
    }
    
    public int setLight(final BlockPos llllllllllllllIlIlIIIIllIIIIIlIl, final int llllllllllllllIlIlIIIIllIIIIllIl) {
        final int llllllllllllllIlIlIIIIllIIIIllII = llllllllllllllIlIlIIIIllIIIIIlIl.getX() & 0xF;
        final int llllllllllllllIlIlIIIIllIIIIlIll = llllllllllllllIlIlIIIIllIIIIIlIl.getY();
        final int llllllllllllllIlIlIIIIllIIIIlIlI = llllllllllllllIlIlIIIIllIIIIIlIl.getZ() & 0xF;
        final ExtendedBlockStorage llllllllllllllIlIlIIIIllIIIIlIIl = this.storageArrays[llllllllllllllIlIlIIIIllIIIIlIll >> 4];
        if (llllllllllllllIlIlIIIIllIIIIlIIl == null) {
            return (!this.worldObj.provider.getHasNoSky() && llllllllllllllIlIlIIIIllIIIIllIl < EnumSkyBlock.SKY.defaultLightValue) ? (EnumSkyBlock.SKY.defaultLightValue - llllllllllllllIlIlIIIIllIIIIllIl) : 0;
        }
        int llllllllllllllIlIlIIIIllIIIIlIII = this.worldObj.provider.getHasNoSky() ? 0 : llllllllllllllIlIlIIIIllIIIIlIIl.getExtSkylightValue(llllllllllllllIlIlIIIIllIIIIllII, llllllllllllllIlIlIIIIllIIIIlIll & 0xF, llllllllllllllIlIlIIIIllIIIIlIlI);
        llllllllllllllIlIlIIIIllIIIIlIII -= llllllllllllllIlIlIIIIllIIIIllIl;
        final int llllllllllllllIlIlIIIIllIIIIIlll = llllllllllllllIlIlIIIIllIIIIlIIl.getExtBlocklightValue(llllllllllllllIlIlIIIIllIIIIllII, llllllllllllllIlIlIIIIllIIIIlIll & 0xF, llllllllllllllIlIlIIIIllIIIIlIlI);
        if (llllllllllllllIlIlIIIIllIIIIIlll > llllllllllllllIlIlIIIIllIIIIlIII) {
            llllllllllllllIlIlIIIIllIIIIlIII = llllllllllllllIlIlIIIIllIIIIIlll;
        }
        return llllllllllllllIlIlIIIIllIIIIlIII;
    }
    
    private TileEntity createNewTileEntity(final BlockPos llllllllllllllIlIlIIIIlIllIIllII) {
        final Block llllllllllllllIlIlIIIIlIllIIlIll = this.getBlock(llllllllllllllIlIlIIIIlIllIIllII);
        return llllllllllllllIlIlIIIIlIllIIlIll.hasTileEntity() ? ((ITileEntityProvider)llllllllllllllIlIlIIIIlIllIIlIll).createNewTileEntity(this.worldObj, this.getBlockMetadata(llllllllllllllIlIlIIIIlIllIIllII)) : null;
    }
    
    public ClassInheratanceMultiMap[] getEntityLists() {
        return this.entityLists;
    }
    
    public byte[] getBiomeArray() {
        return this.blockBiomeArray;
    }
    
    public ExtendedBlockStorage[] getBlockStorageArray() {
        return this.storageArrays;
    }
    
    public void func_150804_b(final boolean llllllllllllllIlIlIIIIIllllIlIII) {
        if (this.isGapLightingUpdated && !this.worldObj.provider.getHasNoSky() && !llllllllllllllIlIlIIIIIllllIlIII) {
            this.recheckGaps(this.worldObj.isRemote);
        }
        this.field_150815_m = true;
        if (!this.isLightPopulated && this.isTerrainPopulated) {
            this.func_150809_p();
        }
        while (!this.field_177447_w.isEmpty()) {
            final BlockPos llllllllllllllIlIlIIIIIllllIlIll = this.field_177447_w.poll();
            if (this.func_177424_a(llllllllllllllIlIlIIIIIllllIlIll, EnumCreateEntityType.CHECK) == null && this.getBlock(llllllllllllllIlIlIIIIIllllIlIll).hasTileEntity()) {
                final TileEntity llllllllllllllIlIlIIIIIllllIlIlI = this.createNewTileEntity(llllllllllllllIlIlIIIIIllllIlIll);
                this.worldObj.setTileEntity(llllllllllllllIlIlIIIIIllllIlIll, llllllllllllllIlIlIIIIIllllIlIlI);
                this.worldObj.markBlockRangeForRenderUpdate(llllllllllllllIlIlIIIIIllllIlIll, llllllllllllllIlIlIIIIIllllIlIll);
            }
        }
    }
    
    public void removeEntityAtIndex(final Entity llllllllllllllIlIlIIIIlIlllIIlII, int llllllllllllllIlIlIIIIlIlllIIIII) {
        if (llllllllllllllIlIlIIIIlIlllIIIII < 0) {
            llllllllllllllIlIlIIIIlIlllIIIII = 0;
        }
        if (llllllllllllllIlIlIIIIlIlllIIIII >= this.entityLists.length) {
            llllllllllllllIlIlIIIIlIlllIIIII = this.entityLists.length - 1;
        }
        this.entityLists[llllllllllllllIlIlIIIIlIlllIIIII].remove(llllllllllllllIlIlIIIIlIlllIIlII);
    }
    
    private int getBlockMetadata(final int llllllllllllllIlIlIIIIllIllllllI, final int llllllllllllllIlIlIIIIlllIIIIIlI, final int llllllllllllllIlIlIIIIlllIIIIIIl) {
        if (llllllllllllllIlIlIIIIlllIIIIIlI >> 4 >= this.storageArrays.length) {
            return 0;
        }
        final ExtendedBlockStorage llllllllllllllIlIlIIIIlllIIIIIII = this.storageArrays[llllllllllllllIlIlIIIIlllIIIIIlI >> 4];
        return (llllllllllllllIlIlIIIIlllIIIIIII != null) ? llllllllllllllIlIlIIIIlllIIIIIII.getExtBlockMetadata(llllllllllllllIlIlIIIIllIllllllI, llllllllllllllIlIlIIIIlllIIIIIlI & 0xF, llllllllllllllIlIlIIIIlllIIIIIIl) : 0;
    }
    
    public Map getTileEntityMap() {
        return this.chunkTileEntityMap;
    }
    
    public void setBiomeArray(final byte[] llllllllllllllIlIlIIIIIllIIIIllI) {
        if (this.blockBiomeArray.length != llllllllllllllIlIlIIIIIllIIIIllI.length) {
            Chunk.logger.warn(String.valueOf(new StringBuilder("Could not set level chunk biomes, array length is ").append(llllllllllllllIlIlIIIIIllIIIIllI.length).append(" instead of ").append(this.blockBiomeArray.length)));
        }
        else {
            for (int llllllllllllllIlIlIIIIIllIIIlIII = 0; llllllllllllllIlIlIIIIIllIIIlIII < this.blockBiomeArray.length; ++llllllllllllllIlIlIIIIIllIIIlIII) {
                this.blockBiomeArray[llllllllllllllIlIlIIIIIllIIIlIII] = llllllllllllllIlIlIIIIIllIIIIllI[llllllllllllllIlIlIIIIIllIIIlIII];
            }
        }
    }
    
    public boolean needsSaving(final boolean llllllllllllllIlIlIIIIlIIlIIIIll) {
        if (llllllllllllllIlIlIIIIlIIlIIIIll) {
            if ((this.hasEntities && this.worldObj.getTotalWorldTime() != this.lastSaveTime) || this.isModified) {
                return true;
            }
        }
        else if (this.hasEntities && this.worldObj.getTotalWorldTime() >= this.lastSaveTime + 600L) {
            return true;
        }
        return this.isModified;
    }
    
    public World getWorld() {
        return this.worldObj;
    }
    
    public int getTopFilledSegment() {
        for (int llllllllllllllIlIlIIIlIIlIIIllIl = this.storageArrays.length - 1; llllllllllllllIlIlIIIlIIlIIIllIl >= 0; --llllllllllllllIlIlIIIlIIlIIIllIl) {
            if (this.storageArrays[llllllllllllllIlIlIIIlIIlIIIllIl] != null) {
                return this.storageArrays[llllllllllllllIlIlIIIlIIlIIIllIl].getYLocation();
            }
        }
        return 0;
    }
    
    public void setStorageArrays(final ExtendedBlockStorage[] llllllllllllllIlIlIIIIIlllIIlIIl) {
        if (this.storageArrays.length != llllllllllllllIlIlIIIIIlllIIlIIl.length) {
            Chunk.logger.warn(String.valueOf(new StringBuilder("Could not set level chunk sections, array length is ").append(llllllllllllllIlIlIIIIIlllIIlIIl.length).append(" instead of ").append(this.storageArrays.length)));
        }
        else {
            for (int llllllllllllllIlIlIIIIIlllIIlIll = 0; llllllllllllllIlIlIIIIIlllIIlIll < this.storageArrays.length; ++llllllllllllllIlIlIIIIIlllIIlIll) {
                this.storageArrays[llllllllllllllIlIlIIIIIlllIIlIll] = llllllllllllllIlIlIIIIIlllIIlIIl[llllllllllllllIlIlIIIIIlllIIlIll];
            }
        }
    }
    
    public int getHeight(final BlockPos llllllllllllllIlIlIIIlIIlIIlllII) {
        return this.getHeight(llllllllllllllIlIlIIIlIIlIIlllII.getX() & 0xF, llllllllllllllIlIlIIIlIIlIIlllII.getZ() & 0xF);
    }
    
    public void func_177417_c(final boolean llllllllllllllIlIlIIIIIlIIIIllIl) {
        this.isChunkLoaded = llllllllllllllIlIlIIIIIlIIIIllIl;
    }
    
    protected void generateHeightMap() {
        final int llllllllllllllIlIlIIIlIIlIIIIIII = this.getTopFilledSegment();
        this.heightMapMinimum = Integer.MAX_VALUE;
        for (int llllllllllllllIlIlIIIlIIIlllllll = 0; llllllllllllllIlIlIIIlIIIlllllll < 16; ++llllllllllllllIlIlIIIlIIIlllllll) {
            for (int llllllllllllllIlIlIIIlIIIllllllI = 0; llllllllllllllIlIlIIIlIIIllllllI < 16; ++llllllllllllllIlIlIIIlIIIllllllI) {
                this.precipitationHeightMap[llllllllllllllIlIlIIIlIIIlllllll + (llllllllllllllIlIlIIIlIIIllllllI << 4)] = -999;
                int llllllllllllllIlIlIIIlIIIlllllIl = llllllllllllllIlIlIIIlIIlIIIIIII + 16;
                while (llllllllllllllIlIlIIIlIIIlllllIl > 0) {
                    final Block llllllllllllllIlIlIIIlIIIlllllII = this.getBlock0(llllllllllllllIlIlIIIlIIIlllllll, llllllllllllllIlIlIIIlIIIlllllIl - 1, llllllllllllllIlIlIIIlIIIllllllI);
                    if (llllllllllllllIlIlIIIlIIIlllllII.getLightOpacity() == 0) {
                        --llllllllllllllIlIlIIIlIIIlllllIl;
                    }
                    else {
                        if ((this.heightMap[llllllllllllllIlIlIIIlIIIllllllI << 4 | llllllllllllllIlIlIIIlIIIlllllll] = llllllllllllllIlIlIIIlIIIlllllIl) < this.heightMapMinimum) {
                            this.heightMapMinimum = llllllllllllllIlIlIIIlIIIlllllIl;
                            break;
                        }
                        break;
                    }
                }
            }
        }
        this.isModified = true;
    }
    
    public int getBlockLightOpacity(final BlockPos llllllllllllllIlIlIIIIlllllIIIlI) {
        return this.getBlock(llllllllllllllIlIlIIIIlllllIIIlI).getLightOpacity();
    }
    
    public void removeTileEntity(final BlockPos llllllllllllllIlIlIIIIlIlIlIIlIl) {
        if (this.isChunkLoaded) {
            final TileEntity llllllllllllllIlIlIIIIlIlIlIIlll = this.chunkTileEntityMap.remove(llllllllllllllIlIlIIIIlIlIlIIlIl);
            if (llllllllllllllIlIlIIIIlIlIlIIlll != null) {
                llllllllllllllIlIlIIIIlIlIlIIlll.invalidate();
            }
        }
    }
    
    public int getLightFor(final EnumSkyBlock llllllllllllllIlIlIIIIllIIllllIl, final BlockPos llllllllllllllIlIlIIIIllIIllllII) {
        final int llllllllllllllIlIlIIIIllIIlllIll = llllllllllllllIlIlIIIIllIIllllII.getX() & 0xF;
        final int llllllllllllllIlIlIIIIllIIlllIlI = llllllllllllllIlIlIIIIllIIllllII.getY();
        final int llllllllllllllIlIlIIIIllIIlllIIl = llllllllllllllIlIlIIIIllIIllllII.getZ() & 0xF;
        final ExtendedBlockStorage llllllllllllllIlIlIIIIllIIlllIII = this.storageArrays[llllllllllllllIlIlIIIIllIIlllIlI >> 4];
        return (llllllllllllllIlIlIIIIllIIlllIII == null) ? (this.canSeeSky(llllllllllllllIlIlIIIIllIIllllII) ? llllllllllllllIlIlIIIIllIIllllIl.defaultLightValue : 0) : ((llllllllllllllIlIlIIIIllIIllllIl == EnumSkyBlock.SKY) ? (this.worldObj.provider.getHasNoSky() ? 0 : llllllllllllllIlIlIIIIllIIlllIII.getExtSkylightValue(llllllllllllllIlIlIIIIllIIlllIll, llllllllllllllIlIlIIIIllIIlllIlI & 0xF, llllllllllllllIlIlIIIIllIIlllIIl)) : ((llllllllllllllIlIlIIIIllIIllllIl == EnumSkyBlock.BLOCK) ? llllllllllllllIlIlIIIIllIIlllIII.getExtBlocklightValue(llllllllllllllIlIlIIIIllIIlllIll, llllllllllllllIlIlIIIIllIIlllIlI & 0xF, llllllllllllllIlIlIIIIllIIlllIIl) : llllllllllllllIlIlIIIIllIIllllIl.defaultLightValue));
    }
    
    public void setHasEntities(final boolean llllllllllllllIlIlIIIIIIllIlllII) {
        this.hasEntities = llllllllllllllIlIlIIIIIIllIlllII;
    }
    
    public void generateSkylightMap() {
        final int llllllllllllllIlIlIIIlIIIllIllII = this.getTopFilledSegment();
        this.heightMapMinimum = Integer.MAX_VALUE;
        for (int llllllllllllllIlIlIIIlIIIllIlIll = 0; llllllllllllllIlIlIIIlIIIllIlIll < 16; ++llllllllllllllIlIlIIIlIIIllIlIll) {
            for (int llllllllllllllIlIlIIIlIIIllIlIlI = 0; llllllllllllllIlIlIIIlIIIllIlIlI < 16; ++llllllllllllllIlIlIIIlIIIllIlIlI) {
                this.precipitationHeightMap[llllllllllllllIlIlIIIlIIIllIlIll + (llllllllllllllIlIlIIIlIIIllIlIlI << 4)] = -999;
                int llllllllllllllIlIlIIIlIIIllIlIIl = llllllllllllllIlIlIIIlIIIllIllII + 16;
                while (llllllllllllllIlIlIIIlIIIllIlIIl > 0) {
                    if (this.getBlockLightOpacity(llllllllllllllIlIlIIIlIIIllIlIll, llllllllllllllIlIlIIIlIIIllIlIIl - 1, llllllllllllllIlIlIIIlIIIllIlIlI) == 0) {
                        --llllllllllllllIlIlIIIlIIIllIlIIl;
                    }
                    else {
                        if ((this.heightMap[llllllllllllllIlIlIIIlIIIllIlIlI << 4 | llllllllllllllIlIlIIIlIIIllIlIll] = llllllllllllllIlIlIIIlIIIllIlIIl) < this.heightMapMinimum) {
                            this.heightMapMinimum = llllllllllllllIlIlIIIlIIIllIlIIl;
                            break;
                        }
                        break;
                    }
                }
                if (!this.worldObj.provider.getHasNoSky()) {
                    llllllllllllllIlIlIIIlIIIllIlIIl = 15;
                    int llllllllllllllIlIlIIIlIIIllIlIII = llllllllllllllIlIlIIIlIIIllIllII + 16 - 1;
                    do {
                        int llllllllllllllIlIlIIIlIIIllIIlll = this.getBlockLightOpacity(llllllllllllllIlIlIIIlIIIllIlIll, llllllllllllllIlIlIIIlIIIllIlIII, llllllllllllllIlIlIIIlIIIllIlIlI);
                        if (llllllllllllllIlIlIIIlIIIllIIlll == 0 && llllllllllllllIlIlIIIlIIIllIlIIl != 15) {
                            llllllllllllllIlIlIIIlIIIllIIlll = 1;
                        }
                        llllllllllllllIlIlIIIlIIIllIlIIl -= llllllllllllllIlIlIIIlIIIllIIlll;
                        if (llllllllllllllIlIlIIIlIIIllIlIIl > 0) {
                            final ExtendedBlockStorage llllllllllllllIlIlIIIlIIIllIIllI = this.storageArrays[llllllllllllllIlIlIIIlIIIllIlIII >> 4];
                            if (llllllllllllllIlIlIIIlIIIllIIllI == null) {
                                continue;
                            }
                            llllllllllllllIlIlIIIlIIIllIIllI.setExtSkylightValue(llllllllllllllIlIlIIIlIIIllIlIll, llllllllllllllIlIlIIIlIIIllIlIII & 0xF, llllllllllllllIlIlIIIlIIIllIlIlI, llllllllllllllIlIlIIIlIIIllIlIIl);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + llllllllllllllIlIlIIIlIIIllIlIll, llllllllllllllIlIlIIIlIIIllIlIII, (this.zPosition << 4) + llllllllllllllIlIlIIIlIIIllIlIlI));
                        }
                    } while (--llllllllllllllIlIlIIIlIIIllIlIII > 0 && llllllllllllllIlIlIIIlIIIllIlIIl > 0);
                }
            }
        }
        this.isModified = true;
    }
    
    public void addTileEntity(final BlockPos llllllllllllllIlIlIIIIlIlIllIIIl, final TileEntity llllllllllllllIlIlIIIIlIlIlIllIl) {
        llllllllllllllIlIlIIIIlIlIlIllIl.setWorldObj(this.worldObj);
        llllllllllllllIlIlIIIIlIlIlIllIl.setPos(llllllllllllllIlIlIIIIlIlIllIIIl);
        if (this.getBlock(llllllllllllllIlIlIIIIlIlIllIIIl) instanceof ITileEntityProvider) {
            if (this.chunkTileEntityMap.containsKey(llllllllllllllIlIlIIIIlIlIllIIIl)) {
                this.chunkTileEntityMap.get(llllllllllllllIlIlIIIIlIlIllIIIl).invalidate();
            }
            llllllllllllllIlIlIIIIlIlIlIllIl.validate();
            this.chunkTileEntityMap.put(llllllllllllllIlIlIIIIlIlIllIIIl, llllllllllllllIlIlIIIIlIlIlIllIl);
        }
    }
    
    public boolean isLoaded() {
        return this.isChunkLoaded;
    }
    
    private int getBlockLightOpacity(final int llllllllllllllIlIlIIIIllllIllIII, final int llllllllllllllIlIlIIIIllllIllIll, final int llllllllllllllIlIlIIIIllllIlIllI) {
        return this.getBlock0(llllllllllllllIlIlIIIIllllIllIII, llllllllllllllIlIlIIIIllllIllIll, llllllllllllllIlIlIIIIllllIlIllI).getLightOpacity();
    }
    
    public enum EnumCreateEntityType
    {
        QUEUED("QUEUED", 1, "QUEUED", 1), 
        CHECK("CHECK", 2, "CHECK", 2), 
        IMMEDIATE("IMMEDIATE", 0, "IMMEDIATE", 0);
        
        private EnumCreateEntityType(final String lllllllllllllllllIIllIIIIIlIIIIl, final int lllllllllllllllllIIllIIIIIlIIIII, final String lllllllllllllllllIIllIIIIIlIIlII, final int lllllllllllllllllIIllIIIIIlIIIll) {
        }
        
        static {
            __OBFID = "CL_00002009";
        }
    }
}
