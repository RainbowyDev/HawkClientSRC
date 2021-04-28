package net.minecraft.world.chunk.storage;

import net.minecraft.world.chunk.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.world.biome.*;

public class ChunkLoader
{
    public static void convertToAnvilFormat(final AnvilConverterData lIIllllIlllIll, final NBTTagCompound lIIllllIlllIlI, final WorldChunkManager lIIllllIlllIIl) {
        lIIllllIlllIlI.setInteger("xPos", lIIllllIlllIll.x);
        lIIllllIlllIlI.setInteger("zPos", lIIllllIlllIll.z);
        lIIllllIlllIlI.setLong("LastUpdate", lIIllllIlllIll.lastUpdated);
        final int[] lIIllllIlllIII = new int[lIIllllIlllIll.heightmap.length];
        for (int lIIllllIllIlll = 0; lIIllllIllIlll < lIIllllIlllIll.heightmap.length; ++lIIllllIllIlll) {
            lIIllllIlllIII[lIIllllIllIlll] = lIIllllIlllIll.heightmap[lIIllllIllIlll];
        }
        lIIllllIlllIlI.setIntArray("HeightMap", lIIllllIlllIII);
        lIIllllIlllIlI.setBoolean("TerrainPopulated", lIIllllIlllIll.terrainPopulated);
        final NBTTagList lIIllllIllIllI = new NBTTagList();
        for (int lIIllllIllIIll = 0; lIIllllIllIIll < 8; ++lIIllllIllIIll) {
            boolean lIIllllIllIIlI = true;
            for (int lIIllllIllIlIl = 0; lIIllllIllIlIl < 16 && lIIllllIllIIlI; ++lIIllllIllIlIl) {
                for (int lIIllllIllIIIl = 0; lIIllllIllIIIl < 16 && lIIllllIllIIlI; ++lIIllllIllIIIl) {
                    for (int lIIllllIllIIII = 0; lIIllllIllIIII < 16; ++lIIllllIllIIII) {
                        final int lIIllllIlIllll = lIIllllIllIlIl << 11 | lIIllllIllIIII << 7 | lIIllllIllIIIl + (lIIllllIllIIll << 4);
                        final byte lIIllllIlIlllI = lIIllllIlllIll.blocks[lIIllllIlIllll];
                        if (lIIllllIlIlllI != 0) {
                            lIIllllIllIIlI = false;
                            break;
                        }
                    }
                }
            }
            if (!lIIllllIllIIlI) {
                final byte[] lIIllllIlIllIl = new byte[4096];
                final NibbleArray lIIllllIlIllII = new NibbleArray();
                final NibbleArray lIIllllIlIlIll = new NibbleArray();
                final NibbleArray lIIllllIlIlIlI = new NibbleArray();
                for (int lIIllllIlIlIIl = 0; lIIllllIlIlIIl < 16; ++lIIllllIlIlIIl) {
                    for (int lIIllllIlIlIII = 0; lIIllllIlIlIII < 16; ++lIIllllIlIlIII) {
                        for (int lIIllllIlIIlll = 0; lIIllllIlIIlll < 16; ++lIIllllIlIIlll) {
                            final int lIIllllIlIIllI = lIIllllIlIlIIl << 11 | lIIllllIlIIlll << 7 | lIIllllIlIlIII + (lIIllllIllIIll << 4);
                            final byte lIIllllIlIIlIl = lIIllllIlllIll.blocks[lIIllllIlIIllI];
                            lIIllllIlIllIl[lIIllllIlIlIII << 8 | lIIllllIlIIlll << 4 | lIIllllIlIlIIl] = (byte)(lIIllllIlIIlIl & 0xFF);
                            lIIllllIlIllII.set(lIIllllIlIlIIl, lIIllllIlIlIII, lIIllllIlIIlll, lIIllllIlllIll.data.get(lIIllllIlIlIIl, lIIllllIlIlIII + (lIIllllIllIIll << 4), lIIllllIlIIlll));
                            lIIllllIlIlIll.set(lIIllllIlIlIIl, lIIllllIlIlIII, lIIllllIlIIlll, lIIllllIlllIll.skyLight.get(lIIllllIlIlIIl, lIIllllIlIlIII + (lIIllllIllIIll << 4), lIIllllIlIIlll));
                            lIIllllIlIlIlI.set(lIIllllIlIlIIl, lIIllllIlIlIII, lIIllllIlIIlll, lIIllllIlllIll.blockLight.get(lIIllllIlIlIIl, lIIllllIlIlIII + (lIIllllIllIIll << 4), lIIllllIlIIlll));
                        }
                    }
                }
                final NBTTagCompound lIIllllIlIIlII = new NBTTagCompound();
                lIIllllIlIIlII.setByte("Y", (byte)(lIIllllIllIIll & 0xFF));
                lIIllllIlIIlII.setByteArray("Blocks", lIIllllIlIllIl);
                lIIllllIlIIlII.setByteArray("Data", lIIllllIlIllII.getData());
                lIIllllIlIIlII.setByteArray("SkyLight", lIIllllIlIlIll.getData());
                lIIllllIlIIlII.setByteArray("BlockLight", lIIllllIlIlIlI.getData());
                lIIllllIllIllI.appendTag(lIIllllIlIIlII);
            }
        }
        lIIllllIlllIlI.setTag("Sections", lIIllllIllIllI);
        final byte[] lIIllllIlIIIll = new byte[256];
        for (int lIIllllIlIIIlI = 0; lIIllllIlIIIlI < 16; ++lIIllllIlIIIlI) {
            for (int lIIllllIllIlII = 0; lIIllllIllIlII < 16; ++lIIllllIllIlII) {
                lIIllllIlIIIll[lIIllllIllIlII << 4 | lIIllllIlIIIlI] = (byte)(lIIllllIlllIIl.func_180300_a(new BlockPos(lIIllllIlllIll.x << 4 | lIIllllIlIIIlI, 0, lIIllllIlllIll.z << 4 | lIIllllIllIlII), BiomeGenBase.field_180279_ad).biomeID & 0xFF);
            }
        }
        lIIllllIlllIlI.setByteArray("Biomes", lIIllllIlIIIll);
        lIIllllIlllIlI.setTag("Entities", lIIllllIlllIll.entities);
        lIIllllIlllIlI.setTag("TileEntities", lIIllllIlllIll.tileEntities);
        if (lIIllllIlllIll.tileTicks != null) {
            lIIllllIlllIlI.setTag("TileTicks", lIIllllIlllIll.tileTicks);
        }
    }
    
    static {
        __OBFID = "CL_00000379";
    }
    
    public static AnvilConverterData load(final NBTTagCompound lIIlllllIlIIIl) {
        final int lIIlllllIlIlIl = lIIlllllIlIIIl.getInteger("xPos");
        final int lIIlllllIlIlII = lIIlllllIlIIIl.getInteger("zPos");
        final AnvilConverterData lIIlllllIlIIll = new AnvilConverterData(lIIlllllIlIlIl, lIIlllllIlIlII);
        lIIlllllIlIIll.blocks = lIIlllllIlIIIl.getByteArray("Blocks");
        lIIlllllIlIIll.data = new NibbleArrayReader(lIIlllllIlIIIl.getByteArray("Data"), 7);
        lIIlllllIlIIll.skyLight = new NibbleArrayReader(lIIlllllIlIIIl.getByteArray("SkyLight"), 7);
        lIIlllllIlIIll.blockLight = new NibbleArrayReader(lIIlllllIlIIIl.getByteArray("BlockLight"), 7);
        lIIlllllIlIIll.heightmap = lIIlllllIlIIIl.getByteArray("HeightMap");
        lIIlllllIlIIll.terrainPopulated = lIIlllllIlIIIl.getBoolean("TerrainPopulated");
        lIIlllllIlIIll.entities = lIIlllllIlIIIl.getTagList("Entities", 10);
        lIIlllllIlIIll.tileEntities = lIIlllllIlIIIl.getTagList("TileEntities", 10);
        lIIlllllIlIIll.tileTicks = lIIlllllIlIIIl.getTagList("TileTicks", 10);
        try {
            lIIlllllIlIIll.lastUpdated = lIIlllllIlIIIl.getLong("LastUpdate");
        }
        catch (ClassCastException lIIlllllIlIIlI) {
            lIIlllllIlIIll.lastUpdated = lIIlllllIlIIIl.getInteger("LastUpdate");
        }
        return lIIlllllIlIIll;
    }
    
    public static class AnvilConverterData
    {
        public /* synthetic */ NBTTagList tileTicks;
        public /* synthetic */ boolean terrainPopulated;
        public /* synthetic */ NibbleArrayReader data;
        public /* synthetic */ long lastUpdated;
        public /* synthetic */ NBTTagList tileEntities;
        public /* synthetic */ NibbleArrayReader skyLight;
        public /* synthetic */ NibbleArrayReader blockLight;
        public final /* synthetic */ int z;
        public /* synthetic */ byte[] blocks;
        public /* synthetic */ byte[] heightmap;
        public /* synthetic */ NBTTagList entities;
        public final /* synthetic */ int x;
        
        public AnvilConverterData(final int lIlIllIIllIll, final int lIlIllIIlllIl) {
            this.x = lIlIllIIllIll;
            this.z = lIlIllIIlllIl;
        }
        
        static {
            __OBFID = "CL_00000380";
        }
    }
}
