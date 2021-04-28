package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class ChunkProviderFlat implements IChunkProvider
{
    private final /* synthetic */ List structureGenerators;
    private /* synthetic */ WorldGenLakes waterLakeGenerator;
    private final /* synthetic */ FlatGeneratorInfo flatWorldGenInfo;
    private /* synthetic */ WorldGenLakes lavaLakeGenerator;
    private /* synthetic */ World worldObj;
    private /* synthetic */ Random random;
    private final /* synthetic */ boolean hasDungeons;
    private final /* synthetic */ boolean hasDecoration;
    private final /* synthetic */ IBlockState[] cachedBlockIDs;
    
    @Override
    public String makeString() {
        return "FlatLevelSource";
    }
    
    @Override
    public void populate(final IChunkProvider llllllllllllllIIIIlIlIlIllIIIlll, final int llllllllllllllIIIIlIlIlIllIIIllI, final int llllllllllllllIIIIlIlIlIlIllIlIl) {
        final int llllllllllllllIIIIlIlIlIllIIIlII = llllllllllllllIIIIlIlIlIllIIIllI * 16;
        final int llllllllllllllIIIIlIlIlIllIIIIll = llllllllllllllIIIIlIlIlIlIllIlIl * 16;
        final BlockPos llllllllllllllIIIIlIlIlIllIIIIlI = new BlockPos(llllllllllllllIIIIlIlIlIllIIIlII, 0, llllllllllllllIIIIlIlIlIllIIIIll);
        final BiomeGenBase llllllllllllllIIIIlIlIlIllIIIIIl = this.worldObj.getBiomeGenForCoords(new BlockPos(llllllllllllllIIIIlIlIlIllIIIlII + 16, 0, llllllllllllllIIIIlIlIlIllIIIIll + 16));
        boolean llllllllllllllIIIIlIlIlIllIIIIII = false;
        this.random.setSeed(this.worldObj.getSeed());
        final long llllllllllllllIIIIlIlIlIlIllllll = this.random.nextLong() / 2L * 2L + 1L;
        final long llllllllllllllIIIIlIlIlIlIlllllI = this.random.nextLong() / 2L * 2L + 1L;
        this.random.setSeed(llllllllllllllIIIIlIlIlIllIIIllI * llllllllllllllIIIIlIlIlIlIllllll + llllllllllllllIIIIlIlIlIlIllIlIl * llllllllllllllIIIIlIlIlIlIlllllI ^ this.worldObj.getSeed());
        final ChunkCoordIntPair llllllllllllllIIIIlIlIlIlIllllIl = new ChunkCoordIntPair(llllllllllllllIIIIlIlIlIllIIIllI, llllllllllllllIIIIlIlIlIlIllIlIl);
        for (final MapGenStructure llllllllllllllIIIIlIlIlIlIlllIll : this.structureGenerators) {
            final boolean llllllllllllllIIIIlIlIlIlIlllIlI = llllllllllllllIIIIlIlIlIlIlllIll.func_175794_a(this.worldObj, this.random, llllllllllllllIIIIlIlIlIlIllllIl);
            if (llllllllllllllIIIIlIlIlIlIlllIll instanceof MapGenVillage) {
                llllllllllllllIIIIlIlIlIllIIIIII |= llllllllllllllIIIIlIlIlIlIlllIlI;
            }
        }
        if (this.waterLakeGenerator != null && !llllllllllllllIIIIlIlIlIllIIIIII && this.random.nextInt(4) == 0) {
            this.waterLakeGenerator.generate(this.worldObj, this.random, llllllllllllllIIIIlIlIlIllIIIIlI.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
        }
        if (this.lavaLakeGenerator != null && !llllllllllllllIIIIlIlIlIllIIIIII && this.random.nextInt(8) == 0) {
            final BlockPos llllllllllllllIIIIlIlIlIlIlllIIl = llllllllllllllIIIIlIlIlIllIIIIlI.add(this.random.nextInt(16) + 8, this.random.nextInt(this.random.nextInt(248) + 8), this.random.nextInt(16) + 8);
            if (llllllllllllllIIIIlIlIlIlIlllIIl.getY() < 63 || this.random.nextInt(10) == 0) {
                this.lavaLakeGenerator.generate(this.worldObj, this.random, llllllllllllllIIIIlIlIlIlIlllIIl);
            }
        }
        if (this.hasDungeons) {
            for (int llllllllllllllIIIIlIlIlIlIlllIII = 0; llllllllllllllIIIIlIlIlIlIlllIII < 8; ++llllllllllllllIIIIlIlIlIlIlllIII) {
                new WorldGenDungeons().generate(this.worldObj, this.random, llllllllllllllIIIIlIlIlIllIIIIlI.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
            }
        }
        if (this.hasDecoration) {
            llllllllllllllIIIIlIlIlIllIIIIIl.func_180624_a(this.worldObj, this.random, new BlockPos(llllllllllllllIIIIlIlIlIllIIIlII, 0, llllllllllllllIIIIlIlIlIllIIIIll));
        }
    }
    
    static {
        __OBFID = "CL_00000391";
    }
    
    @Override
    public Chunk provideChunk(final int llllllllllllllIIIIlIlIlIlllIllll, final int llllllllllllllIIIIlIlIlIlllIIIII) {
        final ChunkPrimer llllllllllllllIIIIlIlIlIlllIllIl = new ChunkPrimer();
        for (int llllllllllllllIIIIlIlIlIlllIlIlI = 0; llllllllllllllIIIIlIlIlIlllIlIlI < this.cachedBlockIDs.length; ++llllllllllllllIIIIlIlIlIlllIlIlI) {
            final IBlockState llllllllllllllIIIIlIlIlIlllIlIIl = this.cachedBlockIDs[llllllllllllllIIIIlIlIlIlllIlIlI];
            if (llllllllllllllIIIIlIlIlIlllIlIIl != null) {
                for (int llllllllllllllIIIIlIlIlIlllIlIII = 0; llllllllllllllIIIIlIlIlIlllIlIII < 16; ++llllllllllllllIIIIlIlIlIlllIlIII) {
                    for (int llllllllllllllIIIIlIlIlIlllIllII = 0; llllllllllllllIIIIlIlIlIlllIllII < 16; ++llllllllllllllIIIIlIlIlIlllIllII) {
                        llllllllllllllIIIIlIlIlIlllIllIl.setBlockState(llllllllllllllIIIIlIlIlIlllIlIII, llllllllllllllIIIIlIlIlIlllIlIlI, llllllllllllllIIIIlIlIlIlllIllII, llllllllllllllIIIIlIlIlIlllIlIIl);
                    }
                }
            }
        }
        for (final MapGenBase llllllllllllllIIIIlIlIlIlllIIllI : this.structureGenerators) {
            llllllllllllllIIIIlIlIlIlllIIllI.func_175792_a(this, this.worldObj, llllllllllllllIIIIlIlIlIlllIllll, llllllllllllllIIIIlIlIlIlllIIIII, llllllllllllllIIIIlIlIlIlllIllIl);
        }
        final Chunk llllllllllllllIIIIlIlIlIlllIIlIl = new Chunk(this.worldObj, llllllllllllllIIIIlIlIlIlllIllIl, llllllllllllllIIIIlIlIlIlllIllll, llllllllllllllIIIIlIlIlIlllIIIII);
        final BiomeGenBase[] llllllllllllllIIIIlIlIlIlllIIlII = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, llllllllllllllIIIIlIlIlIlllIllll * 16, llllllllllllllIIIIlIlIlIlllIIIII * 16, 16, 16);
        final byte[] llllllllllllllIIIIlIlIlIlllIIIll = llllllllllllllIIIIlIlIlIlllIIlIl.getBiomeArray();
        for (int llllllllllllllIIIIlIlIlIlllIlIll = 0; llllllllllllllIIIIlIlIlIlllIlIll < llllllllllllllIIIIlIlIlIlllIIIll.length; ++llllllllllllllIIIIlIlIlIlllIlIll) {
            llllllllllllllIIIIlIlIlIlllIIIll[llllllllllllllIIIIlIlIlIlllIlIll] = (byte)llllllllllllllIIIIlIlIlIlllIIlII[llllllllllllllIIIIlIlIlIlllIlIll].biomeID;
        }
        llllllllllllllIIIIlIlIlIlllIIlIl.generateSkylightMap();
        return llllllllllllllIIIIlIlIlIlllIIlIl;
    }
    
    @Override
    public BlockPos func_180513_a(final World llllllllllllllIIIIlIlIlIlIIIlIlI, final String llllllllllllllIIIIlIlIlIlIIIIIll, final BlockPos llllllllllllllIIIIlIlIlIlIIIIIlI) {
        if ("Stronghold".equals(llllllllllllllIIIIlIlIlIlIIIIIll)) {
            for (final MapGenStructure llllllllllllllIIIIlIlIlIlIIIIllI : this.structureGenerators) {
                if (llllllllllllllIIIIlIlIlIlIIIIllI instanceof MapGenStronghold) {
                    return llllllllllllllIIIIlIlIlIlIIIIllI.func_180706_b(llllllllllllllIIIIlIlIlIlIIIlIlI, llllllllllllllIIIIlIlIlIlIIIIIlI);
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean chunkExists(final int llllllllllllllIIIIlIlIlIllIllIII, final int llllllllllllllIIIIlIlIlIllIlIlll) {
        return true;
    }
    
    @Override
    public Chunk func_177459_a(final BlockPos llllllllllllllIIIIlIlIlIIllIlIll) {
        return this.provideChunk(llllllllllllllIIIIlIlIlIIllIlIll.getX() >> 4, llllllllllllllIIIIlIlIlIIllIlIll.getZ() >> 4);
    }
    
    @Override
    public int getLoadedChunkCount() {
        return 0;
    }
    
    @Override
    public void saveExtraData() {
    }
    
    @Override
    public List func_177458_a(final EnumCreatureType llllllllllllllIIIIlIlIlIlIIllIII, final BlockPos llllllllllllllIIIIlIlIlIlIIlIIll) {
        final BiomeGenBase llllllllllllllIIIIlIlIlIlIIlIllI = this.worldObj.getBiomeGenForCoords(llllllllllllllIIIIlIlIlIlIIlIIll);
        return llllllllllllllIIIIlIlIlIlIIlIllI.getSpawnableList(llllllllllllllIIIIlIlIlIlIIllIII);
    }
    
    @Override
    public boolean saveChunks(final boolean llllllllllllllIIIIlIlIlIlIlIIIll, final IProgressUpdate llllllllllllllIIIIlIlIlIlIlIIIlI) {
        return true;
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    public ChunkProviderFlat(final World llllllllllllllIIIIlIlIllIIIIlllI, final long llllllllllllllIIIIlIlIllIIIIllIl, final boolean llllllllllllllIIIIlIlIllIIIIIIII, final String llllllllllllllIIIIlIlIllIIIIlIll) {
        this.cachedBlockIDs = new IBlockState[256];
        this.structureGenerators = Lists.newArrayList();
        this.worldObj = llllllllllllllIIIIlIlIllIIIIlllI;
        this.random = new Random(llllllllllllllIIIIlIlIllIIIIllIl);
        this.flatWorldGenInfo = FlatGeneratorInfo.createFlatGeneratorFromString(llllllllllllllIIIIlIlIllIIIIlIll);
        if (llllllllllllllIIIIlIlIllIIIIIIII) {
            final Map llllllllllllllIIIIlIlIllIIIIlIlI = this.flatWorldGenInfo.getWorldFeatures();
            if (llllllllllllllIIIIlIlIllIIIIlIlI.containsKey("village")) {
                final Map llllllllllllllIIIIlIlIllIIIIlIIl = llllllllllllllIIIIlIlIllIIIIlIlI.get("village");
                if (!llllllllllllllIIIIlIlIllIIIIlIIl.containsKey("size")) {
                    llllllllllllllIIIIlIlIllIIIIlIIl.put("size", "1");
                }
                this.structureGenerators.add(new MapGenVillage(llllllllllllllIIIIlIlIllIIIIlIIl));
            }
            if (llllllllllllllIIIIlIlIllIIIIlIlI.containsKey("biome_1")) {
                this.structureGenerators.add(new MapGenScatteredFeature(llllllllllllllIIIIlIlIllIIIIlIlI.get("biome_1")));
            }
            if (llllllllllllllIIIIlIlIllIIIIlIlI.containsKey("mineshaft")) {
                this.structureGenerators.add(new MapGenMineshaft(llllllllllllllIIIIlIlIllIIIIlIlI.get("mineshaft")));
            }
            if (llllllllllllllIIIIlIlIllIIIIlIlI.containsKey("stronghold")) {
                this.structureGenerators.add(new MapGenStronghold(llllllllllllllIIIIlIlIllIIIIlIlI.get("stronghold")));
            }
            if (llllllllllllllIIIIlIlIllIIIIlIlI.containsKey("oceanmonument")) {
                this.structureGenerators.add(new StructureOceanMonument(llllllllllllllIIIIlIlIllIIIIlIlI.get("oceanmonument")));
            }
        }
        if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lake")) {
            this.waterLakeGenerator = new WorldGenLakes(Blocks.water);
        }
        if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lava_lake")) {
            this.lavaLakeGenerator = new WorldGenLakes(Blocks.lava);
        }
        this.hasDungeons = this.flatWorldGenInfo.getWorldFeatures().containsKey("dungeon");
        boolean llllllllllllllIIIIlIlIllIIIIlIII = true;
        for (final FlatLayerInfo llllllllllllllIIIIlIlIllIIIIIllI : this.flatWorldGenInfo.getFlatLayers()) {
            for (int llllllllllllllIIIIlIlIllIIIIIlIl = llllllllllllllIIIIlIlIllIIIIIllI.getMinY(); llllllllllllllIIIIlIlIllIIIIIlIl < llllllllllllllIIIIlIlIllIIIIIllI.getMinY() + llllllllllllllIIIIlIlIllIIIIIllI.getLayerCount(); ++llllllllllllllIIIIlIlIllIIIIIlIl) {
                final IBlockState llllllllllllllIIIIlIlIllIIIIIlII = llllllllllllllIIIIlIlIllIIIIIllI.func_175900_c();
                if (llllllllllllllIIIIlIlIllIIIIIlII.getBlock() != Blocks.air) {
                    llllllllllllllIIIIlIlIllIIIIlIII = false;
                    this.cachedBlockIDs[llllllllllllllIIIIlIlIllIIIIIlIl] = llllllllllllllIIIIlIlIllIIIIIlII;
                }
            }
        }
        this.hasDecoration = (!llllllllllllllIIIIlIlIllIIIIlIII && this.flatWorldGenInfo.getWorldFeatures().containsKey("decoration"));
    }
    
    @Override
    public boolean func_177460_a(final IChunkProvider llllllllllllllIIIIlIlIlIlIlIlIII, final Chunk llllllllllllllIIIIlIlIlIlIlIIlll, final int llllllllllllllIIIIlIlIlIlIlIIllI, final int llllllllllllllIIIIlIlIlIlIlIIlIl) {
        return false;
    }
    
    @Override
    public boolean canSave() {
        return true;
    }
    
    @Override
    public void func_180514_a(final Chunk llllllllllllllIIIIlIlIlIIllllIII, final int llllllllllllllIIIIlIlIlIIlllIlll, final int llllllllllllllIIIIlIlIlIIlllIIIl) {
        for (final MapGenStructure llllllllllllllIIIIlIlIlIIlllIlII : this.structureGenerators) {
            llllllllllllllIIIIlIlIlIIlllIlII.func_175792_a(this, this.worldObj, llllllllllllllIIIIlIlIlIIlllIlll, llllllllllllllIIIIlIlIlIIlllIIIl, null);
        }
    }
}
