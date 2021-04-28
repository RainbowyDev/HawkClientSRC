package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;
import org.apache.logging.log4j.*;

public class GenLayerHills extends GenLayer
{
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ GenLayer field_151628_d;
    
    public GenLayerHills(final long llllllllllllllIIllIIlIIIIIllIIII, final GenLayer llllllllllllllIIllIIlIIIIIllIIll, final GenLayer llllllllllllllIIllIIlIIIIIllIIlI) {
        super(llllllllllllllIIllIIlIIIIIllIIII);
        this.parent = llllllllllllllIIllIIlIIIIIllIIll;
        this.field_151628_d = llllllllllllllIIllIIlIIIIIllIIlI;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIIllIIlIIIIIIIIlIl, final int llllllllllllllIIllIIlIIIIIIIIlII, final int llllllllllllllIIllIIlIIIIIIIIIll, final int llllllllllllllIIllIIlIIIIIIIIIlI) {
        final int[] llllllllllllllIIllIIlIIIIIIlIlIl = this.parent.getInts(llllllllllllllIIllIIlIIIIIIIIlIl - 1, llllllllllllllIIllIIlIIIIIIIIlII - 1, llllllllllllllIIllIIlIIIIIIIIIll + 2, llllllllllllllIIllIIlIIIIIIIIIlI + 2);
        final int[] llllllllllllllIIllIIlIIIIIIlIlII = this.field_151628_d.getInts(llllllllllllllIIllIIlIIIIIIIIlIl - 1, llllllllllllllIIllIIlIIIIIIIIlII - 1, llllllllllllllIIllIIlIIIIIIIIIll + 2, llllllllllllllIIllIIlIIIIIIIIIlI + 2);
        final int[] llllllllllllllIIllIIlIIIIIIlIIll = IntCache.getIntCache(llllllllllllllIIllIIlIIIIIIIIIll * llllllllllllllIIllIIlIIIIIIIIIlI);
        for (int llllllllllllllIIllIIlIIIIIIlIIlI = 0; llllllllllllllIIllIIlIIIIIIlIIlI < llllllllllllllIIllIIlIIIIIIIIIlI; ++llllllllllllllIIllIIlIIIIIIlIIlI) {
            for (int llllllllllllllIIllIIlIIIIIIlIIIl = 0; llllllllllllllIIllIIlIIIIIIlIIIl < llllllllllllllIIllIIlIIIIIIIIIll; ++llllllllllllllIIllIIlIIIIIIlIIIl) {
                this.initChunkSeed(llllllllllllllIIllIIlIIIIIIlIIIl + llllllllllllllIIllIIlIIIIIIIIlIl, llllllllllllllIIllIIlIIIIIIlIIlI + llllllllllllllIIllIIlIIIIIIIIlII);
                final int llllllllllllllIIllIIlIIIIIIlIIII = llllllllllllllIIllIIlIIIIIIlIlIl[llllllllllllllIIllIIlIIIIIIlIIIl + 1 + (llllllllllllllIIllIIlIIIIIIlIIlI + 1) * (llllllllllllllIIllIIlIIIIIIIIIll + 2)];
                final int llllllllllllllIIllIIlIIIIIIIllll = llllllllllllllIIllIIlIIIIIIlIlII[llllllllllllllIIllIIlIIIIIIlIIIl + 1 + (llllllllllllllIIllIIlIIIIIIlIIlI + 1) * (llllllllllllllIIllIIlIIIIIIIIIll + 2)];
                final boolean llllllllllllllIIllIIlIIIIIIIlllI = (llllllllllllllIIllIIlIIIIIIIllll - 2) % 29 == 0;
                if (llllllllllllllIIllIIlIIIIIIlIIII > 255) {
                    GenLayerHills.logger.debug(String.valueOf(new StringBuilder("old! ").append(llllllllllllllIIllIIlIIIIIIlIIII)));
                }
                if (llllllllllllllIIllIIlIIIIIIlIIII != 0 && llllllllllllllIIllIIlIIIIIIIllll >= 2 && (llllllllllllllIIllIIlIIIIIIIllll - 2) % 29 == 1 && llllllllllllllIIllIIlIIIIIIlIIII < 128) {
                    if (BiomeGenBase.getBiome(llllllllllllllIIllIIlIIIIIIlIIII + 128) != null) {
                        llllllllllllllIIllIIlIIIIIIlIIll[llllllllllllllIIllIIlIIIIIIlIIIl + llllllllllllllIIllIIlIIIIIIlIIlI * llllllllllllllIIllIIlIIIIIIIIIll] = llllllllllllllIIllIIlIIIIIIlIIII + 128;
                    }
                    else {
                        llllllllllllllIIllIIlIIIIIIlIIll[llllllllllllllIIllIIlIIIIIIlIIIl + llllllllllllllIIllIIlIIIIIIlIIlI * llllllllllllllIIllIIlIIIIIIIIIll] = llllllllllllllIIllIIlIIIIIIlIIII;
                    }
                }
                else if (this.nextInt(3) != 0 && !llllllllllllllIIllIIlIIIIIIIlllI) {
                    llllllllllllllIIllIIlIIIIIIlIIll[llllllllllllllIIllIIlIIIIIIlIIIl + llllllllllllllIIllIIlIIIIIIlIIlI * llllllllllllllIIllIIlIIIIIIIIIll] = llllllllllllllIIllIIlIIIIIIlIIII;
                }
                else {
                    int llllllllllllllIIllIIlIIIIIIIllIl;
                    if ((llllllllllllllIIllIIlIIIIIIIllIl = llllllllllllllIIllIIlIIIIIIlIIII) == BiomeGenBase.desert.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.desertHills.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.forest.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.forestHills.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.birchForest.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.birchForestHills.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.roofedForest.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.plains.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.taiga.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.taigaHills.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.megaTaiga.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.megaTaigaHills.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.coldTaiga.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.coldTaigaHills.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.plains.biomeID) {
                        if (this.nextInt(3) == 0) {
                            llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.forestHills.biomeID;
                        }
                        else {
                            llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.forest.biomeID;
                        }
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.icePlains.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.iceMountains.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.jungle.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.jungleHills.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.ocean.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.deepOcean.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.extremeHills.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.extremeHillsPlus.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.savanna.biomeID) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.savannaPlateau.biomeID;
                    }
                    else if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIIIIIlIIII, BiomeGenBase.mesaPlateau_F.biomeID)) {
                        llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.mesa.biomeID;
                    }
                    else if (llllllllllllllIIllIIlIIIIIIlIIII == BiomeGenBase.deepOcean.biomeID && this.nextInt(3) == 0) {
                        final int llllllllllllllIIllIIlIIIIIIIllII = this.nextInt(2);
                        if (llllllllllllllIIllIIlIIIIIIIllII == 0) {
                            llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.plains.biomeID;
                        }
                        else {
                            llllllllllllllIIllIIlIIIIIIIllIl = BiomeGenBase.forest.biomeID;
                        }
                    }
                    if (llllllllllllllIIllIIlIIIIIIIlllI && llllllllllllllIIllIIlIIIIIIIllIl != llllllllllllllIIllIIlIIIIIIlIIII) {
                        if (BiomeGenBase.getBiome(llllllllllllllIIllIIlIIIIIIIllIl + 128) != null) {
                            llllllllllllllIIllIIlIIIIIIIllIl += 128;
                        }
                        else {
                            llllllllllllllIIllIIlIIIIIIIllIl = llllllllllllllIIllIIlIIIIIIlIIII;
                        }
                    }
                    if (llllllllllllllIIllIIlIIIIIIIllIl == llllllllllllllIIllIIlIIIIIIlIIII) {
                        llllllllllllllIIllIIlIIIIIIlIIll[llllllllllllllIIllIIlIIIIIIlIIIl + llllllllllllllIIllIIlIIIIIIlIIlI * llllllllllllllIIllIIlIIIIIIIIIll] = llllllllllllllIIllIIlIIIIIIlIIII;
                    }
                    else {
                        final int llllllllllllllIIllIIlIIIIIIIlIll = llllllllllllllIIllIIlIIIIIIlIlIl[llllllllllllllIIllIIlIIIIIIlIIIl + 1 + (llllllllllllllIIllIIlIIIIIIlIIlI + 1 - 1) * (llllllllllllllIIllIIlIIIIIIIIIll + 2)];
                        final int llllllllllllllIIllIIlIIIIIIIlIlI = llllllllllllllIIllIIlIIIIIIlIlIl[llllllllllllllIIllIIlIIIIIIlIIIl + 1 + 1 + (llllllllllllllIIllIIlIIIIIIlIIlI + 1) * (llllllllllllllIIllIIlIIIIIIIIIll + 2)];
                        final int llllllllllllllIIllIIlIIIIIIIlIIl = llllllllllllllIIllIIlIIIIIIlIlIl[llllllllllllllIIllIIlIIIIIIlIIIl + 1 - 1 + (llllllllllllllIIllIIlIIIIIIlIIlI + 1) * (llllllllllllllIIllIIlIIIIIIIIIll + 2)];
                        final int llllllllllllllIIllIIlIIIIIIIlIII = llllllllllllllIIllIIlIIIIIIlIlIl[llllllllllllllIIllIIlIIIIIIlIIIl + 1 + (llllllllllllllIIllIIlIIIIIIlIIlI + 1 + 1) * (llllllllllllllIIllIIlIIIIIIIIIll + 2)];
                        int llllllllllllllIIllIIlIIIIIIIIlll = 0;
                        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIIIIIIlIll, llllllllllllllIIllIIlIIIIIIlIIII)) {
                            ++llllllllllllllIIllIIlIIIIIIIIlll;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIIIIIIlIlI, llllllllllllllIIllIIlIIIIIIlIIII)) {
                            ++llllllllllllllIIllIIlIIIIIIIIlll;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIIIIIIlIIl, llllllllllllllIIllIIlIIIIIIlIIII)) {
                            ++llllllllllllllIIllIIlIIIIIIIIlll;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIIIIIIlIII, llllllllllllllIIllIIlIIIIIIlIIII)) {
                            ++llllllllllllllIIllIIlIIIIIIIIlll;
                        }
                        if (llllllllllllllIIllIIlIIIIIIIIlll >= 3) {
                            llllllllllllllIIllIIlIIIIIIlIIll[llllllllllllllIIllIIlIIIIIIlIIIl + llllllllllllllIIllIIlIIIIIIlIIlI * llllllllllllllIIllIIlIIIIIIIIIll] = llllllllllllllIIllIIlIIIIIIIllIl;
                        }
                        else {
                            llllllllllllllIIllIIlIIIIIIlIIll[llllllllllllllIIllIIlIIIIIIlIIIl + llllllllllllllIIllIIlIIIIIIlIIlI * llllllllllllllIIllIIlIIIIIIIIIll] = llllllllllllllIIllIIlIIIIIIlIIII;
                        }
                    }
                }
            }
        }
        return llllllllllllllIIllIIlIIIIIIlIIll;
    }
    
    static {
        __OBFID = "CL_00000563";
        logger = LogManager.getLogger();
    }
}
