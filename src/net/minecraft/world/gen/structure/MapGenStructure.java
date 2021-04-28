package net.minecraft.world.gen.structure;

import net.minecraft.world.gen.*;
import optifine.*;
import net.minecraft.world.storage.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;

public abstract class MapGenStructure extends MapGenBase
{
    private /* synthetic */ MapGenStructureData field_143029_e;
    protected /* synthetic */ Map structureMap;
    private /* synthetic */ LongHashMap structureLongMap;
    
    protected StructureStart func_175797_c(final BlockPos llllllllllllllIIlIIIllIIlIlIIIll) {
        for (final StructureStart llllllllllllllIIlIIIllIIlIlIIIIl : this.structureMap.values()) {
            if (llllllllllllllIIlIIIllIIlIlIIIIl.isSizeableStructure() && llllllllllllllIIlIIIllIIlIlIIIIl.getBoundingBox().func_175898_b(llllllllllllllIIlIIIllIIlIlIIIll)) {
                for (final StructureComponent llllllllllllllIIlIIIllIIlIIlllll : llllllllllllllIIlIIIllIIlIlIIIIl.getComponents()) {
                    if (llllllllllllllIIlIIIllIIlIIlllll.getBoundingBox().func_175898_b(llllllllllllllIIlIIIllIIlIlIIIll)) {
                        return llllllllllllllIIlIIIllIIlIlIIIIl;
                    }
                }
            }
        }
        return null;
    }
    
    static {
        __OBFID = "CL_00000505";
    }
    
    public boolean func_175795_b(final BlockPos llllllllllllllIIlIIIllIIlIlIlIll) {
        this.func_143027_a(this.worldObj);
        return this.func_175797_c(llllllllllllllIIlIIIllIIlIlIlIll) != null;
    }
    
    protected List getCoordList() {
        return null;
    }
    
    private void func_143027_a(final World llllllllllllllIIlIIIllIIIlIIlIll) {
        if (this.field_143029_e == null) {
            if (Reflector.ForgeWorld_getPerWorldStorage.exists()) {
                final MapStorage llllllllllllllIIlIIIllIIIlIIlIlI = (MapStorage)Reflector.call(llllllllllllllIIlIIIllIIIlIIlIll, Reflector.ForgeWorld_getPerWorldStorage, new Object[0]);
                this.field_143029_e = (MapGenStructureData)llllllllllllllIIlIIIllIIIlIIlIlI.loadData(MapGenStructureData.class, this.getStructureName());
            }
            else {
                this.field_143029_e = (MapGenStructureData)llllllllllllllIIlIIIllIIIlIIlIll.loadItemData(MapGenStructureData.class, this.getStructureName());
            }
            if (this.field_143029_e == null) {
                this.field_143029_e = new MapGenStructureData(this.getStructureName());
                if (Reflector.ForgeWorld_getPerWorldStorage.exists()) {
                    final MapStorage llllllllllllllIIlIIIllIIIlIIlIIl = (MapStorage)Reflector.call(llllllllllllllIIlIIIllIIIlIIlIll, Reflector.ForgeWorld_getPerWorldStorage, new Object[0]);
                    llllllllllllllIIlIIIllIIIlIIlIIl.setData(this.getStructureName(), this.field_143029_e);
                }
                else {
                    llllllllllllllIIlIIIllIIIlIIlIll.setItemData(this.getStructureName(), this.field_143029_e);
                }
            }
            else {
                final NBTTagCompound llllllllllllllIIlIIIllIIIlIIlIII = this.field_143029_e.func_143041_a();
                for (final String llllllllllllllIIlIIIllIIIlIIIllI : llllllllllllllIIlIIIllIIIlIIlIII.getKeySet()) {
                    final NBTBase llllllllllllllIIlIIIllIIIlIIIlIl = llllllllllllllIIlIIIllIIIlIIlIII.getTag(llllllllllllllIIlIIIllIIIlIIIllI);
                    if (llllllllllllllIIlIIIllIIIlIIIlIl.getId() == 10) {
                        final NBTTagCompound llllllllllllllIIlIIIllIIIlIIIlII = (NBTTagCompound)llllllllllllllIIlIIIllIIIlIIIlIl;
                        if (!llllllllllllllIIlIIIllIIIlIIIlII.hasKey("ChunkX") || !llllllllllllllIIlIIIllIIIlIIIlII.hasKey("ChunkZ")) {
                            continue;
                        }
                        final int llllllllllllllIIlIIIllIIIlIIIIll = llllllllllllllIIlIIIllIIIlIIIlII.getInteger("ChunkX");
                        final int llllllllllllllIIlIIIllIIIlIIIIlI = llllllllllllllIIlIIIllIIIlIIIlII.getInteger("ChunkZ");
                        final StructureStart llllllllllllllIIlIIIllIIIlIIIIIl = MapGenStructureIO.func_143035_a(llllllllllllllIIlIIIllIIIlIIIlII, llllllllllllllIIlIIIllIIIlIIlIll);
                        if (llllllllllllllIIlIIIllIIIlIIIIIl == null) {
                            continue;
                        }
                        this.structureMap.put(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIlIIIllIIIlIIIIll, llllllllllllllIIlIIIllIIIlIIIIlI), llllllllllllllIIlIIIllIIIlIIIIIl);
                        this.structureLongMap.add(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIlIIIllIIIlIIIIll, llllllllllllllIIlIIIllIIIlIIIIlI), llllllllllllllIIlIIIllIIIlIIIIIl);
                    }
                }
            }
        }
    }
    
    protected abstract boolean canSpawnStructureAtCoords(final int p0, final int p1);
    
    protected abstract StructureStart getStructureStart(final int p0, final int p1);
    
    private void func_143026_a(final int llllllllllllllIIlIIIllIIIIlIllII, final int llllllllllllllIIlIIIllIIIIlIllll, final StructureStart llllllllllllllIIlIIIllIIIIlIlIlI) {
        this.field_143029_e.func_143043_a(llllllllllllllIIlIIIllIIIIlIlIlI.func_143021_a(llllllllllllllIIlIIIllIIIIlIllII, llllllllllllllIIlIIIllIIIIlIllll), llllllllllllllIIlIIIllIIIIlIllII, llllllllllllllIIlIIIllIIIIlIllll);
        this.field_143029_e.markDirty();
    }
    
    public boolean func_175794_a(final World llllllllllllllIIlIIIllIIllIIIIIl, final Random llllllllllllllIIlIIIllIIlIllIlll, final ChunkCoordIntPair llllllllllllllIIlIIIllIIlIllIllI) {
        this.func_143027_a(llllllllllllllIIlIIIllIIllIIIIIl);
        final int llllllllllllllIIlIIIllIIlIlllllI = (llllllllllllllIIlIIIllIIlIllIllI.chunkXPos << 4) + 8;
        final int llllllllllllllIIlIIIllIIlIllllIl = (llllllllllllllIIlIIIllIIlIllIllI.chunkZPos << 4) + 8;
        boolean llllllllllllllIIlIIIllIIlIllllII = false;
        for (final StructureStart llllllllllllllIIlIIIllIIlIlllIlI : this.structureMap.values()) {
            if (llllllllllllllIIlIIIllIIlIlllIlI.isSizeableStructure() && llllllllllllllIIlIIIllIIlIlllIlI.func_175788_a(llllllllllllllIIlIIIllIIlIllIllI) && llllllllllllllIIlIIIllIIlIlllIlI.getBoundingBox().intersectsWith(llllllllllllllIIlIIIllIIlIlllllI, llllllllllllllIIlIIIllIIlIllllIl, llllllllllllllIIlIIIllIIlIlllllI + 15, llllllllllllllIIlIIIllIIlIllllIl + 15)) {
                llllllllllllllIIlIIIllIIlIlllIlI.generateStructure(llllllllllllllIIlIIIllIIllIIIIIl, llllllllllllllIIlIIIllIIlIllIlll, new StructureBoundingBox(llllllllllllllIIlIIIllIIlIlllllI, llllllllllllllIIlIIIllIIlIllllIl, llllllllllllllIIlIIIllIIlIlllllI + 15, llllllllllllllIIlIIIllIIlIllllIl + 15));
                llllllllllllllIIlIIIllIIlIlllIlI.func_175787_b(llllllllllllllIIlIIIllIIlIllIllI);
                llllllllllllllIIlIIIllIIlIllllII = true;
                this.func_143026_a(llllllllllllllIIlIIIllIIlIlllIlI.func_143019_e(), llllllllllllllIIlIIIllIIlIlllIlI.func_143018_f(), llllllllllllllIIlIIIllIIlIlllIlI);
            }
        }
        return llllllllllllllIIlIIIllIIlIllllII;
    }
    
    public BlockPos func_180706_b(final World llllllllllllllIIlIIIllIIIllllIIl, final BlockPos llllllllllllllIIlIIIllIIIllIIlIl) {
        this.worldObj = llllllllllllllIIlIIIllIIIllllIIl;
        this.func_143027_a(llllllllllllllIIlIIIllIIIllllIIl);
        this.rand.setSeed(llllllllllllllIIlIIIllIIIllllIIl.getSeed());
        final long llllllllllllllIIlIIIllIIIlllIlll = this.rand.nextLong();
        final long llllllllllllllIIlIIIllIIIlllIllI = this.rand.nextLong();
        final long llllllllllllllIIlIIIllIIIlllIlIl = (llllllllllllllIIlIIIllIIIllIIlIl.getX() >> 4) * llllllllllllllIIlIIIllIIIlllIlll;
        final long llllllllllllllIIlIIIllIIIlllIlII = (llllllllllllllIIlIIIllIIIllIIlIl.getZ() >> 4) * llllllllllllllIIlIIIllIIIlllIllI;
        this.rand.setSeed(llllllllllllllIIlIIIllIIIlllIlIl ^ llllllllllllllIIlIIIllIIIlllIlII ^ llllllllllllllIIlIIIllIIIllllIIl.getSeed());
        this.func_180701_a(llllllllllllllIIlIIIllIIIllllIIl, llllllllllllllIIlIIIllIIIllIIlIl.getX() >> 4, llllllllllllllIIlIIIllIIIllIIlIl.getZ() >> 4, 0, 0, null);
        double llllllllllllllIIlIIIllIIIlllIIll = Double.MAX_VALUE;
        BlockPos llllllllllllllIIlIIIllIIIlllIIlI = null;
        for (final StructureStart llllllllllllllIIlIIIllIIIllIllII : this.structureMap.values()) {
            if (llllllllllllllIIlIIIllIIIllIllII.isSizeableStructure()) {
                final StructureComponent llllllllllllllIIlIIIllIIIllIlIll = llllllllllllllIIlIIIllIIIllIllII.getComponents().get(0);
                final BlockPos llllllllllllllIIlIIIllIIIlllIIII = llllllllllllllIIlIIIllIIIllIlIll.func_180776_a();
                final double llllllllllllllIIlIIIllIIIllIlllI = llllllllllllllIIlIIIllIIIlllIIII.distanceSq(llllllllllllllIIlIIIllIIIllIIlIl);
                if (llllllllllllllIIlIIIllIIIllIlllI >= llllllllllllllIIlIIIllIIIlllIIll) {
                    continue;
                }
                llllllllllllllIIlIIIllIIIlllIIll = llllllllllllllIIlIIIllIIIllIlllI;
                llllllllllllllIIlIIIllIIIlllIIlI = llllllllllllllIIlIIIllIIIlllIIII;
            }
        }
        if (llllllllllllllIIlIIIllIIIlllIIlI != null) {
            return llllllllllllllIIlIIIllIIIlllIIlI;
        }
        final List llllllllllllllIIlIIIllIIIllIlIlI = this.getCoordList();
        if (llllllllllllllIIlIIIllIIIllIlIlI != null) {
            BlockPos llllllllllllllIIlIIIllIIIllIlIIl = null;
            for (final BlockPos llllllllllllllIIlIIIllIIIllIllll : llllllllllllllIIlIIIllIIIllIlIlI) {
                final double llllllllllllllIIlIIIllIIIllIllIl = llllllllllllllIIlIIIllIIIllIllll.distanceSq(llllllllllllllIIlIIIllIIIllIIlIl);
                if (llllllllllllllIIlIIIllIIIllIllIl < llllllllllllllIIlIIIllIIIlllIIll) {
                    llllllllllllllIIlIIIllIIIlllIIll = llllllllllllllIIlIIIllIIIllIllIl;
                    llllllllllllllIIlIIIllIIIllIlIIl = llllllllllllllIIlIIIllIIIllIllll;
                }
            }
            return llllllllllllllIIlIIIllIIIllIlIIl;
        }
        return null;
    }
    
    public abstract String getStructureName();
    
    @Override
    protected final void func_180701_a(final World llllllllllllllIIlIIIllIIllIlIIIl, final int llllllllllllllIIlIIIllIIllIlIIII, final int llllllllllllllIIlIIIllIIllIIllll, final int llllllllllllllIIlIIIllIIllIllIIl, final int llllllllllllllIIlIIIllIIllIllIII, final ChunkPrimer llllllllllllllIIlIIIllIIllIlIlll) {
        this.func_143027_a(llllllllllllllIIlIIIllIIllIlIIIl);
        if (!this.structureLongMap.containsItem(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll))) {
            this.rand.nextInt();
            try {
                if (this.canSpawnStructureAtCoords(llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll)) {
                    final StructureStart llllllllllllllIIlIIIllIIllIlIllI = this.getStructureStart(llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll);
                    this.structureMap.put(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll), llllllllllllllIIlIIIllIIllIlIllI);
                    this.structureLongMap.add(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll), llllllllllllllIIlIIIllIIllIlIllI);
                    this.func_143026_a(llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll, llllllllllllllIIlIIIllIIllIlIllI);
                }
            }
            catch (Throwable llllllllllllllIIlIIIllIIllIlIlIl) {
                final CrashReport llllllllllllllIIlIIIllIIllIlIlII = CrashReport.makeCrashReport(llllllllllllllIIlIIIllIIllIlIlIl, "Exception preparing structure feature");
                final CrashReportCategory llllllllllllllIIlIIIllIIllIlIIll = llllllllllllllIIlIIIllIIllIlIlII.makeCategory("Feature being prepared");
                llllllllllllllIIlIIIllIIllIlIIll.addCrashSectionCallable("Is feature chunk", new Callable() {
                    @Override
                    public String call() {
                        return MapGenStructure.this.canSpawnStructureAtCoords(llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll) ? "True" : "False";
                    }
                    
                    static {
                        __OBFID = "CL_00000506";
                    }
                });
                llllllllllllllIIlIIIllIIllIlIIll.addCrashSection("Chunk location", String.format("%d,%d", llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll));
                llllllllllllllIIlIIIllIIllIlIIll.addCrashSectionCallable("Chunk pos hash", new Callable() {
                    @Override
                    public String call() {
                        return String.valueOf(ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIlIIIllIIllIlIIII, llllllllllllllIIlIIIllIIllIIllll));
                    }
                    
                    static {
                        __OBFID = "CL_00000507";
                    }
                });
                llllllllllllllIIlIIIllIIllIlIIll.addCrashSectionCallable("Structure type", new Callable() {
                    @Override
                    public String call() {
                        return MapGenStructure.this.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(llllllllllllllIIlIIIllIIllIlIlII);
            }
        }
    }
    
    public boolean func_175796_a(final World llllllllllllllIIlIIIllIIlIIlIIlI, final BlockPos llllllllllllllIIlIIIllIIlIIIllII) {
        this.func_143027_a(llllllllllllllIIlIIIllIIlIIlIIlI);
        for (final StructureStart llllllllllllllIIlIIIllIIlIIIllll : this.structureMap.values()) {
            if (llllllllllllllIIlIIIllIIlIIIllll.isSizeableStructure() && llllllllllllllIIlIIIllIIlIIIllll.getBoundingBox().func_175898_b(llllllllllllllIIlIIIllIIlIIIllII)) {
                return true;
            }
        }
        return false;
    }
    
    public MapGenStructure() {
        this.structureMap = Maps.newHashMap();
        this.structureLongMap = new LongHashMap();
    }
}
