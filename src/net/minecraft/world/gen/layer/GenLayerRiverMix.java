package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;

public class GenLayerRiverMix extends GenLayer
{
    private /* synthetic */ GenLayer riverPatternGeneratorChain;
    private /* synthetic */ GenLayer biomePatternGeneratorChain;
    
    @Override
    public int[] getInts(final int lllllllllllllllIIlIlIIIllIlIIlIl, final int lllllllllllllllIIlIlIIIllIlIllIl, final int lllllllllllllllIIlIlIIIllIlIllII, final int lllllllllllllllIIlIlIIIllIlIlIll) {
        final int[] lllllllllllllllIIlIlIIIllIlIlIlI = this.biomePatternGeneratorChain.getInts(lllllllllllllllIIlIlIIIllIlIIlIl, lllllllllllllllIIlIlIIIllIlIllIl, lllllllllllllllIIlIlIIIllIlIllII, lllllllllllllllIIlIlIIIllIlIlIll);
        final int[] lllllllllllllllIIlIlIIIllIlIlIIl = this.riverPatternGeneratorChain.getInts(lllllllllllllllIIlIlIIIllIlIIlIl, lllllllllllllllIIlIlIIIllIlIllIl, lllllllllllllllIIlIlIIIllIlIllII, lllllllllllllllIIlIlIIIllIlIlIll);
        final int[] lllllllllllllllIIlIlIIIllIlIlIII = IntCache.getIntCache(lllllllllllllllIIlIlIIIllIlIllII * lllllllllllllllIIlIlIIIllIlIlIll);
        for (int lllllllllllllllIIlIlIIIllIlIIlll = 0; lllllllllllllllIIlIlIIIllIlIIlll < lllllllllllllllIIlIlIIIllIlIllII * lllllllllllllllIIlIlIIIllIlIlIll; ++lllllllllllllllIIlIlIIIllIlIIlll) {
            if (lllllllllllllllIIlIlIIIllIlIlIlI[lllllllllllllllIIlIlIIIllIlIIlll] != BiomeGenBase.ocean.biomeID && lllllllllllllllIIlIlIIIllIlIlIlI[lllllllllllllllIIlIlIIIllIlIIlll] != BiomeGenBase.deepOcean.biomeID) {
                if (lllllllllllllllIIlIlIIIllIlIlIIl[lllllllllllllllIIlIlIIIllIlIIlll] == BiomeGenBase.river.biomeID) {
                    if (lllllllllllllllIIlIlIIIllIlIlIlI[lllllllllllllllIIlIlIIIllIlIIlll] == BiomeGenBase.icePlains.biomeID) {
                        lllllllllllllllIIlIlIIIllIlIlIII[lllllllllllllllIIlIlIIIllIlIIlll] = BiomeGenBase.frozenRiver.biomeID;
                    }
                    else if (lllllllllllllllIIlIlIIIllIlIlIlI[lllllllllllllllIIlIlIIIllIlIIlll] != BiomeGenBase.mushroomIsland.biomeID && lllllllllllllllIIlIlIIIllIlIlIlI[lllllllllllllllIIlIlIIIllIlIIlll] != BiomeGenBase.mushroomIslandShore.biomeID) {
                        lllllllllllllllIIlIlIIIllIlIlIII[lllllllllllllllIIlIlIIIllIlIIlll] = (lllllllllllllllIIlIlIIIllIlIlIIl[lllllllllllllllIIlIlIIIllIlIIlll] & 0xFF);
                    }
                    else {
                        lllllllllllllllIIlIlIIIllIlIlIII[lllllllllllllllIIlIlIIIllIlIIlll] = BiomeGenBase.mushroomIslandShore.biomeID;
                    }
                }
                else {
                    lllllllllllllllIIlIlIIIllIlIlIII[lllllllllllllllIIlIlIIIllIlIIlll] = lllllllllllllllIIlIlIIIllIlIlIlI[lllllllllllllllIIlIlIIIllIlIIlll];
                }
            }
            else {
                lllllllllllllllIIlIlIIIllIlIlIII[lllllllllllllllIIlIlIIIllIlIIlll] = lllllllllllllllIIlIlIIIllIlIlIlI[lllllllllllllllIIlIlIIIllIlIIlll];
            }
        }
        return lllllllllllllllIIlIlIIIllIlIlIII;
    }
    
    public GenLayerRiverMix(final long lllllllllllllllIIlIlIIIlllIIIlIl, final GenLayer lllllllllllllllIIlIlIIIlllIIIIII, final GenLayer lllllllllllllllIIlIlIIIllIllllll) {
        super(lllllllllllllllIIlIlIIIlllIIIlIl);
        this.biomePatternGeneratorChain = lllllllllllllllIIlIlIIIlllIIIIII;
        this.riverPatternGeneratorChain = lllllllllllllllIIlIlIIIllIllllll;
    }
    
    static {
        __OBFID = "CL_00000567";
    }
    
    @Override
    public void initWorldGenSeed(final long lllllllllllllllIIlIlIIIllIlllIll) {
        this.biomePatternGeneratorChain.initWorldGenSeed(lllllllllllllllIIlIlIIIllIlllIll);
        this.riverPatternGeneratorChain.initWorldGenSeed(lllllllllllllllIIlIlIIIllIlllIll);
        super.initWorldGenSeed(lllllllllllllllIIlIlIIIllIlllIll);
    }
}
