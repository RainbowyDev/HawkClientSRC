package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;

public class GenLayerShore extends GenLayer
{
    private void func_151632_a(final int[] llllllllllllllIlIIlllIIIIlIlIllI, final int[] llllllllllllllIlIIlllIIIIlIlIlIl, final int llllllllllllllIlIIlllIIIIlIlIlII, final int llllllllllllllIlIIlllIIIIlIIlIII, final int llllllllllllllIlIIlllIIIIlIlIIlI, final int llllllllllllllIlIIlllIIIIlIIIllI, final int llllllllllllllIlIIlllIIIIlIIIlIl) {
        if (GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlIIIllI)) {
            llllllllllllllIlIIlllIIIIlIlIlIl[llllllllllllllIlIIlllIIIIlIlIlII + llllllllllllllIlIIlllIIIIlIIlIII * llllllllllllllIlIIlllIIIIlIlIIlI] = llllllllllllllIlIIlllIIIIlIIIllI;
        }
        else {
            final int llllllllllllllIlIIlllIIIIlIIllll = llllllllllllllIlIIlllIIIIlIlIllI[llllllllllllllIlIIlllIIIIlIlIlII + 1 + (llllllllllllllIlIIlllIIIIlIIlIII + 1 - 1) * (llllllllllllllIlIIlllIIIIlIlIIlI + 2)];
            final int llllllllllllllIlIIlllIIIIlIIlllI = llllllllllllllIlIIlllIIIIlIlIllI[llllllllllllllIlIIlllIIIIlIlIlII + 1 + 1 + (llllllllllllllIlIIlllIIIIlIIlIII + 1) * (llllllllllllllIlIIlllIIIIlIlIIlI + 2)];
            final int llllllllllllllIlIIlllIIIIlIIllIl = llllllllllllllIlIIlllIIIIlIlIllI[llllllllllllllIlIIlllIIIIlIlIlII + 1 - 1 + (llllllllllllllIlIIlllIIIIlIIlIII + 1) * (llllllllllllllIlIIlllIIIIlIlIIlI + 2)];
            final int llllllllllllllIlIIlllIIIIlIIllII = llllllllllllllIlIIlllIIIIlIlIllI[llllllllllllllIlIIlllIIIIlIlIlII + 1 + (llllllllllllllIlIIlllIIIIlIIlIII + 1 + 1) * (llllllllllllllIlIIlllIIIIlIlIIlI + 2)];
            if (!GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlIIllll) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlIIlllI) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlIIllIl) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlIIllII)) {
                llllllllllllllIlIIlllIIIIlIlIlIl[llllllllllllllIlIIlllIIIIlIlIlII + llllllllllllllIlIIlllIIIIlIIlIII * llllllllllllllIlIIlllIIIIlIlIIlI] = llllllllllllllIlIIlllIIIIlIIIllI;
            }
            else {
                llllllllllllllIlIIlllIIIIlIlIlIl[llllllllllllllIlIIlllIIIIlIlIlII + llllllllllllllIlIIlllIIIIlIIlIII * llllllllllllllIlIIlllIIIIlIlIIlI] = llllllllllllllIlIIlllIIIIlIIIlIl;
            }
        }
    }
    
    private boolean func_151631_c(final int llllllllllllllIlIIlllIIIIIlllllI) {
        return (BiomeGenBase.getBiome(llllllllllllllIlIIlllIIIIIlllllI) != null && BiomeGenBase.getBiome(llllllllllllllIlIIlllIIIIIlllllI).getBiomeClass() == BiomeGenJungle.class) || llllllllllllllIlIIlllIIIIIlllllI == BiomeGenBase.jungleEdge.biomeID || llllllllllllllIlIIlllIIIIIlllllI == BiomeGenBase.jungle.biomeID || llllllllllllllIlIIlllIIIIIlllllI == BiomeGenBase.jungleHills.biomeID || llllllllllllllIlIIlllIIIIIlllllI == BiomeGenBase.forest.biomeID || llllllllllllllIlIIlllIIIIIlllllI == BiomeGenBase.taiga.biomeID || GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIIlllllI);
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIlIIlllIIIIlllIIII, final int llllllllllllllIlIIlllIIIlIIIlIlI, final int llllllllllllllIlIIlllIIIIllIlllI, final int llllllllllllllIlIIlllIIIlIIIlIII) {
        final int[] llllllllllllllIlIIlllIIIlIIIIlll = this.parent.getInts(llllllllllllllIlIIlllIIIIlllIIII - 1, llllllllllllllIlIIlllIIIlIIIlIlI - 1, llllllllllllllIlIIlllIIIIllIlllI + 2, llllllllllllllIlIIlllIIIlIIIlIII + 2);
        final int[] llllllllllllllIlIIlllIIIlIIIIllI = IntCache.getIntCache(llllllllllllllIlIIlllIIIIllIlllI * llllllllllllllIlIIlllIIIlIIIlIII);
        for (int llllllllllllllIlIIlllIIIlIIIIlIl = 0; llllllllllllllIlIIlllIIIlIIIIlIl < llllllllllllllIlIIlllIIIlIIIlIII; ++llllllllllllllIlIIlllIIIlIIIIlIl) {
            for (int llllllllllllllIlIIlllIIIlIIIIlII = 0; llllllllllllllIlIIlllIIIlIIIIlII < llllllllllllllIlIIlllIIIIllIlllI; ++llllllllllllllIlIIlllIIIlIIIIlII) {
                this.initChunkSeed(llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIIlllIIII, llllllllllllllIlIIlllIIIlIIIIlIl + llllllllllllllIlIIlllIIIlIIIlIlI);
                final int llllllllllllllIlIIlllIIIlIIIIIll = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                final BiomeGenBase llllllllllllllIlIIlllIIIlIIIIIlI = BiomeGenBase.getBiome(llllllllllllllIlIIlllIIIlIIIIIll);
                if (llllllllllllllIlIIlllIIIlIIIIIll == BiomeGenBase.mushroomIsland.biomeID) {
                    final int llllllllllllllIlIIlllIIIlIIIIIIl = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1 - 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                    final int llllllllllllllIlIIlllIIIIlllllIl = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                    final int llllllllllllllIlIIlllIIIIllllIIl = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 - 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                    final int llllllllllllllIlIIlllIIIIlllIlIl = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1 + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                    if (llllllllllllllIlIIlllIIIlIIIIIIl != BiomeGenBase.ocean.biomeID && llllllllllllllIlIIlllIIIIlllllIl != BiomeGenBase.ocean.biomeID && llllllllllllllIlIIlllIIIIllllIIl != BiomeGenBase.ocean.biomeID && llllllllllllllIlIIlllIIIIlllIlIl != BiomeGenBase.ocean.biomeID) {
                        llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = llllllllllllllIlIIlllIIIlIIIIIll;
                    }
                    else {
                        llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = BiomeGenBase.mushroomIslandShore.biomeID;
                    }
                }
                else if (llllllllllllllIlIIlllIIIlIIIIIlI != null && llllllllllllllIlIIlllIIIlIIIIIlI.getBiomeClass() == BiomeGenJungle.class) {
                    final int llllllllllllllIlIIlllIIIlIIIIIII = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1 - 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                    final int llllllllllllllIlIIlllIIIIlllllII = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                    final int llllllllllllllIlIIlllIIIIllllIII = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 - 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                    final int llllllllllllllIlIIlllIIIIlllIlII = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1 + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                    if (this.func_151631_c(llllllllllllllIlIIlllIIIlIIIIIII) && this.func_151631_c(llllllllllllllIlIIlllIIIIlllllII) && this.func_151631_c(llllllllllllllIlIIlllIIIIllllIII) && this.func_151631_c(llllllllllllllIlIIlllIIIIlllIlII)) {
                        if (!GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIlIIIIIII) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlllllII) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIllllIII) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlllIlII)) {
                            llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = llllllllllllllIlIIlllIIIlIIIIIll;
                        }
                        else {
                            llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = BiomeGenBase.beach.biomeID;
                        }
                    }
                    else {
                        llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = BiomeGenBase.jungleEdge.biomeID;
                    }
                }
                else if (llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.extremeHills.biomeID && llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.extremeHillsPlus.biomeID && llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.extremeHillsEdge.biomeID) {
                    if (llllllllllllllIlIIlllIIIlIIIIIlI != null && llllllllllllllIlIIlllIIIlIIIIIlI.isSnowyBiome()) {
                        this.func_151632_a(llllllllllllllIlIIlllIIIlIIIIlll, llllllllllllllIlIIlllIIIlIIIIllI, llllllllllllllIlIIlllIIIlIIIIlII, llllllllllllllIlIIlllIIIlIIIIlIl, llllllllllllllIlIIlllIIIIllIlllI, llllllllllllllIlIIlllIIIlIIIIIll, BiomeGenBase.coldBeach.biomeID);
                    }
                    else if (llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.mesa.biomeID && llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.mesaPlateau_F.biomeID) {
                        if (llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.ocean.biomeID && llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.deepOcean.biomeID && llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.river.biomeID && llllllllllllllIlIIlllIIIlIIIIIll != BiomeGenBase.swampland.biomeID) {
                            final int llllllllllllllIlIIlllIIIIlllllll = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1 - 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                            final int llllllllllllllIlIIlllIIIIllllIll = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                            final int llllllllllllllIlIIlllIIIIlllIlll = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 - 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                            final int llllllllllllllIlIIlllIIIIlllIIll = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1 + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                            if (!GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlllllll) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIllllIll) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlllIlll) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlllIIll)) {
                                llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = llllllllllllllIlIIlllIIIlIIIIIll;
                            }
                            else {
                                llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = BiomeGenBase.beach.biomeID;
                            }
                        }
                        else {
                            llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = llllllllllllllIlIIlllIIIlIIIIIll;
                        }
                    }
                    else {
                        final int llllllllllllllIlIIlllIIIIllllllI = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1 - 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                        final int llllllllllllllIlIIlllIIIIllllIlI = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                        final int llllllllllllllIlIIlllIIIIlllIllI = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 - 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                        final int llllllllllllllIlIIlllIIIIlllIIlI = llllllllllllllIlIIlllIIIlIIIIlll[llllllllllllllIlIIlllIIIlIIIIlII + 1 + (llllllllllllllIlIIlllIIIlIIIIlIl + 1 + 1) * (llllllllllllllIlIIlllIIIIllIlllI + 2)];
                        if (!GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIllllllI) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIllllIlI) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlllIllI) && !GenLayer.isBiomeOceanic(llllllllllllllIlIIlllIIIIlllIIlI)) {
                            if (this.func_151633_d(llllllllllllllIlIIlllIIIIllllllI) && this.func_151633_d(llllllllllllllIlIIlllIIIIllllIlI) && this.func_151633_d(llllllllllllllIlIIlllIIIIlllIllI) && this.func_151633_d(llllllllllllllIlIIlllIIIIlllIIlI)) {
                                llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = llllllllllllllIlIIlllIIIlIIIIIll;
                            }
                            else {
                                llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = BiomeGenBase.desert.biomeID;
                            }
                        }
                        else {
                            llllllllllllllIlIIlllIIIlIIIIllI[llllllllllllllIlIIlllIIIlIIIIlII + llllllllllllllIlIIlllIIIlIIIIlIl * llllllllllllllIlIIlllIIIIllIlllI] = llllllllllllllIlIIlllIIIlIIIIIll;
                        }
                    }
                }
                else {
                    this.func_151632_a(llllllllllllllIlIIlllIIIlIIIIlll, llllllllllllllIlIIlllIIIlIIIIllI, llllllllllllllIlIIlllIIIlIIIIlII, llllllllllllllIlIIlllIIIlIIIIlIl, llllllllllllllIlIIlllIIIIllIlllI, llllllllllllllIlIIlllIIIlIIIIIll, BiomeGenBase.stoneBeach.biomeID);
                }
            }
        }
        return llllllllllllllIlIIlllIIIlIIIIllI;
    }
    
    static {
        __OBFID = "CL_00000568";
    }
    
    public GenLayerShore(final long llllllllllllllIlIIlllIIIlIIlllIl, final GenLayer llllllllllllllIlIIlllIIIlIIlllll) {
        super(llllllllllllllIlIIlllIIIlIIlllIl);
        this.parent = llllllllllllllIlIIlllIIIlIIlllll;
    }
    
    private boolean func_151633_d(final int llllllllllllllIlIIlllIIIIIlllIIl) {
        return BiomeGenBase.getBiome(llllllllllllllIlIIlllIIIIIlllIIl) instanceof BiomeGenMesa;
    }
}
