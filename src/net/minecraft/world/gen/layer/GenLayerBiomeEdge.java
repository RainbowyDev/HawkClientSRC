package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;

public class GenLayerBiomeEdge extends GenLayer
{
    private boolean replaceBiomeEdge(final int[] llllllllllllllIlllIIIIlIIIllIIll, final int[] llllllllllllllIlllIIIIlIIIlIIllI, final int llllllllllllllIlllIIIIlIIIlIIlIl, final int llllllllllllllIlllIIIIlIIIllIIII, final int llllllllllllllIlllIIIIlIIIlIIIll, final int llllllllllllllIlllIIIIlIIIlIlllI, final int llllllllllllllIlllIIIIlIIIlIllIl, final int llllllllllllllIlllIIIIlIIIlIllII) {
        if (llllllllllllllIlllIIIIlIIIlIlllI != llllllllllllllIlllIIIIlIIIlIllIl) {
            return false;
        }
        final int llllllllllllllIlllIIIIlIIIlIlIll = llllllllllllllIlllIIIIlIIIllIIll[llllllllllllllIlllIIIIlIIIlIIlIl + 1 + (llllllllllllllIlllIIIIlIIIllIIII + 1 - 1) * (llllllllllllllIlllIIIIlIIIlIIIll + 2)];
        final int llllllllllllllIlllIIIIlIIIlIlIlI = llllllllllllllIlllIIIIlIIIllIIll[llllllllllllllIlllIIIIlIIIlIIlIl + 1 + 1 + (llllllllllllllIlllIIIIlIIIllIIII + 1) * (llllllllllllllIlllIIIIlIIIlIIIll + 2)];
        final int llllllllllllllIlllIIIIlIIIlIlIIl = llllllllllllllIlllIIIIlIIIllIIll[llllllllllllllIlllIIIIlIIIlIIlIl + 1 - 1 + (llllllllllllllIlllIIIIlIIIllIIII + 1) * (llllllllllllllIlllIIIIlIIIlIIIll + 2)];
        final int llllllllllllllIlllIIIIlIIIlIlIII = llllllllllllllIlllIIIIlIIIllIIll[llllllllllllllIlllIIIIlIIIlIIlIl + 1 + (llllllllllllllIlllIIIIlIIIllIIII + 1 + 1) * (llllllllllllllIlllIIIIlIIIlIIIll + 2)];
        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIlllIIIIlIIIlIlIll, llllllllllllllIlllIIIIlIIIlIllIl) && GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIlllIIIIlIIIlIlIlI, llllllllllllllIlllIIIIlIIIlIllIl) && GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIlllIIIIlIIIlIlIIl, llllllllllllllIlllIIIIlIIIlIllIl) && GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIlllIIIIlIIIlIlIII, llllllllllllllIlllIIIIlIIIlIllIl)) {
            llllllllllllllIlllIIIIlIIIlIIllI[llllllllllllllIlllIIIIlIIIlIIlIl + llllllllllllllIlllIIIIlIIIllIIII * llllllllllllllIlllIIIIlIIIlIIIll] = llllllllllllllIlllIIIIlIIIlIlllI;
        }
        else {
            llllllllllllllIlllIIIIlIIIlIIllI[llllllllllllllIlllIIIIlIIIlIIlIl + llllllllllllllIlllIIIIlIIIllIIII * llllllllllllllIlllIIIIlIIIlIIIll] = llllllllllllllIlllIIIIlIIIlIllII;
        }
        return true;
    }
    
    private boolean canBiomesBeNeighbors(final int llllllllllllllIlllIIIIlIIIIlIlII, final int llllllllllllllIlllIIIIlIIIIlIIll) {
        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIlllIIIIlIIIIlIlII, llllllllllllllIlllIIIIlIIIIlIIll)) {
            return true;
        }
        final BiomeGenBase llllllllllllllIlllIIIIlIIIIlIIlI = BiomeGenBase.getBiome(llllllllllllllIlllIIIIlIIIIlIlII);
        final BiomeGenBase llllllllllllllIlllIIIIlIIIIlIIIl = BiomeGenBase.getBiome(llllllllllllllIlllIIIIlIIIIlIIll);
        if (llllllllllllllIlllIIIIlIIIIlIIlI != null && llllllllllllllIlllIIIIlIIIIlIIIl != null) {
            final BiomeGenBase.TempCategory llllllllllllllIlllIIIIlIIIIlIIII = llllllllllllllIlllIIIIlIIIIlIIlI.getTempCategory();
            final BiomeGenBase.TempCategory llllllllllllllIlllIIIIlIIIIIllll = llllllllllllllIlllIIIIlIIIIlIIIl.getTempCategory();
            return llllllllllllllIlllIIIIlIIIIlIIII == llllllllllllllIlllIIIIlIIIIIllll || llllllllllllllIlllIIIIlIIIIlIIII == BiomeGenBase.TempCategory.MEDIUM || llllllllllllllIlllIIIIlIIIIIllll == BiomeGenBase.TempCategory.MEDIUM;
        }
        return false;
    }
    
    private boolean replaceBiomeEdgeIfNecessary(final int[] llllllllllllllIlllIIIIlIIlIIllII, final int[] llllllllllllllIlllIIIIlIIlIIlIll, final int llllllllllllllIlllIIIIlIIlIIlIlI, final int llllllllllllllIlllIIIIlIIlIIlIIl, final int llllllllllllllIlllIIIIlIIlIlIlIl, final int llllllllllllllIlllIIIIlIIlIlIlII, final int llllllllllllllIlllIIIIlIIlIIIllI, final int llllllllllllllIlllIIIIlIIlIIIlIl) {
        if (!GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIlllIIIIlIIlIlIlII, llllllllllllllIlllIIIIlIIlIIIllI)) {
            return false;
        }
        final int llllllllllllllIlllIIIIlIIlIlIIIl = llllllllllllllIlllIIIIlIIlIIllII[llllllllllllllIlllIIIIlIIlIIlIlI + 1 + (llllllllllllllIlllIIIIlIIlIIlIIl + 1 - 1) * (llllllllllllllIlllIIIIlIIlIlIlIl + 2)];
        final int llllllllllllllIlllIIIIlIIlIlIIII = llllllllllllllIlllIIIIlIIlIIllII[llllllllllllllIlllIIIIlIIlIIlIlI + 1 + 1 + (llllllllllllllIlllIIIIlIIlIIlIIl + 1) * (llllllllllllllIlllIIIIlIIlIlIlIl + 2)];
        final int llllllllllllllIlllIIIIlIIlIIllll = llllllllllllllIlllIIIIlIIlIIllII[llllllllllllllIlllIIIIlIIlIIlIlI + 1 - 1 + (llllllllllllllIlllIIIIlIIlIIlIIl + 1) * (llllllllllllllIlllIIIIlIIlIlIlIl + 2)];
        final int llllllllllllllIlllIIIIlIIlIIlllI = llllllllllllllIlllIIIIlIIlIIllII[llllllllllllllIlllIIIIlIIlIIlIlI + 1 + (llllllllllllllIlllIIIIlIIlIIlIIl + 1 + 1) * (llllllllllllllIlllIIIIlIIlIlIlIl + 2)];
        if (this.canBiomesBeNeighbors(llllllllllllllIlllIIIIlIIlIlIIIl, llllllllllllllIlllIIIIlIIlIIIllI) && this.canBiomesBeNeighbors(llllllllllllllIlllIIIIlIIlIlIIII, llllllllllllllIlllIIIIlIIlIIIllI) && this.canBiomesBeNeighbors(llllllllllllllIlllIIIIlIIlIIllll, llllllllllllllIlllIIIIlIIlIIIllI) && this.canBiomesBeNeighbors(llllllllllllllIlllIIIIlIIlIIlllI, llllllllllllllIlllIIIIlIIlIIIllI)) {
            llllllllllllllIlllIIIIlIIlIIlIll[llllllllllllllIlllIIIIlIIlIIlIlI + llllllllllllllIlllIIIIlIIlIIlIIl * llllllllllllllIlllIIIIlIIlIlIlIl] = llllllllllllllIlllIIIIlIIlIlIlII;
        }
        else {
            llllllllllllllIlllIIIIlIIlIIlIll[llllllllllllllIlllIIIIlIIlIIlIlI + llllllllllllllIlllIIIIlIIlIIlIIl * llllllllllllllIlllIIIIlIIlIlIlIl] = llllllllllllllIlllIIIIlIIlIIIlIl;
        }
        return true;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIlllIIIIlIIlllIlII, final int llllllllllllllIlllIIIIlIlIIIIlIl, final int llllllllllllllIlllIIIIlIlIIIIlII, final int llllllllllllllIlllIIIIlIlIIIIIll) {
        final int[] llllllllllllllIlllIIIIlIlIIIIIlI = this.parent.getInts(llllllllllllllIlllIIIIlIIlllIlII - 1, llllllllllllllIlllIIIIlIlIIIIlIl - 1, llllllllllllllIlllIIIIlIlIIIIlII + 2, llllllllllllllIlllIIIIlIlIIIIIll + 2);
        final int[] llllllllllllllIlllIIIIlIlIIIIIIl = IntCache.getIntCache(llllllllllllllIlllIIIIlIlIIIIlII * llllllllllllllIlllIIIIlIlIIIIIll);
        for (int llllllllllllllIlllIIIIlIlIIIIIII = 0; llllllllllllllIlllIIIIlIlIIIIIII < llllllllllllllIlllIIIIlIlIIIIIll; ++llllllllllllllIlllIIIIlIlIIIIIII) {
            for (int llllllllllllllIlllIIIIlIIlllllll = 0; llllllllllllllIlllIIIIlIIlllllll < llllllllllllllIlllIIIIlIlIIIIlII; ++llllllllllllllIlllIIIIlIIlllllll) {
                this.initChunkSeed(llllllllllllllIlllIIIIlIIlllllll + llllllllllllllIlllIIIIlIIlllIlII, llllllllllllllIlllIIIIlIlIIIIIII + llllllllllllllIlllIIIIlIlIIIIlIl);
                final int llllllllllllllIlllIIIIlIIllllllI = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                if (!this.replaceBiomeEdgeIfNecessary(llllllllllllllIlllIIIIlIlIIIIIlI, llllllllllllllIlllIIIIlIlIIIIIIl, llllllllllllllIlllIIIIlIIlllllll, llllllllllllllIlllIIIIlIlIIIIIII, llllllllllllllIlllIIIIlIlIIIIlII, llllllllllllllIlllIIIIlIIllllllI, BiomeGenBase.extremeHills.biomeID, BiomeGenBase.extremeHillsEdge.biomeID) && !this.replaceBiomeEdge(llllllllllllllIlllIIIIlIlIIIIIlI, llllllllllllllIlllIIIIlIlIIIIIIl, llllllllllllllIlllIIIIlIIlllllll, llllllllllllllIlllIIIIlIlIIIIIII, llllllllllllllIlllIIIIlIlIIIIlII, llllllllllllllIlllIIIIlIIllllllI, BiomeGenBase.mesaPlateau_F.biomeID, BiomeGenBase.mesa.biomeID) && !this.replaceBiomeEdge(llllllllllllllIlllIIIIlIlIIIIIlI, llllllllllllllIlllIIIIlIlIIIIIIl, llllllllllllllIlllIIIIlIIlllllll, llllllllllllllIlllIIIIlIlIIIIIII, llllllllllllllIlllIIIIlIlIIIIlII, llllllllllllllIlllIIIIlIIllllllI, BiomeGenBase.mesaPlateau.biomeID, BiomeGenBase.mesa.biomeID) && !this.replaceBiomeEdge(llllllllllllllIlllIIIIlIlIIIIIlI, llllllllllllllIlllIIIIlIlIIIIIIl, llllllllllllllIlllIIIIlIIlllllll, llllllllllllllIlllIIIIlIlIIIIIII, llllllllllllllIlllIIIIlIlIIIIlII, llllllllllllllIlllIIIIlIIllllllI, BiomeGenBase.megaTaiga.biomeID, BiomeGenBase.taiga.biomeID)) {
                    if (llllllllllllllIlllIIIIlIIllllllI == BiomeGenBase.desert.biomeID) {
                        final int llllllllllllllIlllIIIIlIIlllllIl = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1 - 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                        final int llllllllllllllIlllIIIIlIIllllIll = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 + 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                        final int llllllllllllllIlllIIIIlIIllllIIl = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 - 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                        final int llllllllllllllIlllIIIIlIIlllIlll = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1 + 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                        if (llllllllllllllIlllIIIIlIIlllllIl != BiomeGenBase.icePlains.biomeID && llllllllllllllIlllIIIIlIIllllIll != BiomeGenBase.icePlains.biomeID && llllllllllllllIlllIIIIlIIllllIIl != BiomeGenBase.icePlains.biomeID && llllllllllllllIlllIIIIlIIlllIlll != BiomeGenBase.icePlains.biomeID) {
                            llllllllllllllIlllIIIIlIlIIIIIIl[llllllllllllllIlllIIIIlIIlllllll + llllllllllllllIlllIIIIlIlIIIIIII * llllllllllllllIlllIIIIlIlIIIIlII] = llllllllllllllIlllIIIIlIIllllllI;
                        }
                        else {
                            llllllllllllllIlllIIIIlIlIIIIIIl[llllllllllllllIlllIIIIlIIlllllll + llllllllllllllIlllIIIIlIlIIIIIII * llllllllllllllIlllIIIIlIlIIIIlII] = BiomeGenBase.extremeHillsPlus.biomeID;
                        }
                    }
                    else if (llllllllllllllIlllIIIIlIIllllllI == BiomeGenBase.swampland.biomeID) {
                        final int llllllllllllllIlllIIIIlIIlllllII = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1 - 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                        final int llllllllllllllIlllIIIIlIIllllIlI = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 + 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                        final int llllllllllllllIlllIIIIlIIllllIII = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 - 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                        final int llllllllllllllIlllIIIIlIIlllIllI = llllllllllllllIlllIIIIlIlIIIIIlI[llllllllllllllIlllIIIIlIIlllllll + 1 + (llllllllllllllIlllIIIIlIlIIIIIII + 1 + 1) * (llllllllllllllIlllIIIIlIlIIIIlII + 2)];
                        if (llllllllllllllIlllIIIIlIIlllllII != BiomeGenBase.desert.biomeID && llllllllllllllIlllIIIIlIIllllIlI != BiomeGenBase.desert.biomeID && llllllllllllllIlllIIIIlIIllllIII != BiomeGenBase.desert.biomeID && llllllllllllllIlllIIIIlIIlllIllI != BiomeGenBase.desert.biomeID && llllllllllllllIlllIIIIlIIlllllII != BiomeGenBase.coldTaiga.biomeID && llllllllllllllIlllIIIIlIIllllIlI != BiomeGenBase.coldTaiga.biomeID && llllllllllllllIlllIIIIlIIllllIII != BiomeGenBase.coldTaiga.biomeID && llllllllllllllIlllIIIIlIIlllIllI != BiomeGenBase.coldTaiga.biomeID && llllllllllllllIlllIIIIlIIlllllII != BiomeGenBase.icePlains.biomeID && llllllllllllllIlllIIIIlIIllllIlI != BiomeGenBase.icePlains.biomeID && llllllllllllllIlllIIIIlIIllllIII != BiomeGenBase.icePlains.biomeID && llllllllllllllIlllIIIIlIIlllIllI != BiomeGenBase.icePlains.biomeID) {
                            if (llllllllllllllIlllIIIIlIIlllllII != BiomeGenBase.jungle.biomeID && llllllllllllllIlllIIIIlIIlllIllI != BiomeGenBase.jungle.biomeID && llllllllllllllIlllIIIIlIIllllIlI != BiomeGenBase.jungle.biomeID && llllllllllllllIlllIIIIlIIllllIII != BiomeGenBase.jungle.biomeID) {
                                llllllllllllllIlllIIIIlIlIIIIIIl[llllllllllllllIlllIIIIlIIlllllll + llllllllllllllIlllIIIIlIlIIIIIII * llllllllllllllIlllIIIIlIlIIIIlII] = llllllllllllllIlllIIIIlIIllllllI;
                            }
                            else {
                                llllllllllllllIlllIIIIlIlIIIIIIl[llllllllllllllIlllIIIIlIIlllllll + llllllllllllllIlllIIIIlIlIIIIIII * llllllllllllllIlllIIIIlIlIIIIlII] = BiomeGenBase.jungleEdge.biomeID;
                            }
                        }
                        else {
                            llllllllllllllIlllIIIIlIlIIIIIIl[llllllllllllllIlllIIIIlIIlllllll + llllllllllllllIlllIIIIlIlIIIIIII * llllllllllllllIlllIIIIlIlIIIIlII] = BiomeGenBase.plains.biomeID;
                        }
                    }
                    else {
                        llllllllllllllIlllIIIIlIlIIIIIIl[llllllllllllllIlllIIIIlIIlllllll + llllllllllllllIlllIIIIlIlIIIIIII * llllllllllllllIlllIIIIlIlIIIIlII] = llllllllllllllIlllIIIIlIIllllllI;
                    }
                }
            }
        }
        return llllllllllllllIlllIIIIlIlIIIIIIl;
    }
    
    static {
        __OBFID = "CL_00000554";
    }
    
    public GenLayerBiomeEdge(final long llllllllllllllIlllIIIIlIlIIllIlI, final GenLayer llllllllllllllIlllIIIIlIlIIlIllI) {
        super(llllllllllllllIlllIIIIlIlIIllIlI);
        this.parent = llllllllllllllIlllIIIIlIlIIlIllI;
    }
}
