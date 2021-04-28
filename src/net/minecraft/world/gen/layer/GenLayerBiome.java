package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.*;

public class GenLayerBiome extends GenLayer
{
    private /* synthetic */ BiomeGenBase[] field_151621_d;
    private /* synthetic */ BiomeGenBase[] field_151622_e;
    private final /* synthetic */ ChunkProviderSettings field_175973_g;
    private /* synthetic */ BiomeGenBase[] field_151623_c;
    private /* synthetic */ BiomeGenBase[] field_151620_f;
    
    public GenLayerBiome(final long llllllllllllllIIIIIlllIlIllIIlIl, final GenLayer llllllllllllllIIIIIlllIlIllIlIIl, final WorldType llllllllllllllIIIIIlllIlIllIlIII, final String llllllllllllllIIIIIlllIlIllIIlll) {
        super(llllllllllllllIIIIIlllIlIllIIlIl);
        this.field_151623_c = new BiomeGenBase[] { BiomeGenBase.desert, BiomeGenBase.desert, BiomeGenBase.desert, BiomeGenBase.savanna, BiomeGenBase.savanna, BiomeGenBase.plains };
        this.field_151621_d = new BiomeGenBase[] { BiomeGenBase.forest, BiomeGenBase.roofedForest, BiomeGenBase.extremeHills, BiomeGenBase.plains, BiomeGenBase.birchForest, BiomeGenBase.swampland };
        this.field_151622_e = new BiomeGenBase[] { BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.taiga, BiomeGenBase.plains };
        this.field_151620_f = new BiomeGenBase[] { BiomeGenBase.icePlains, BiomeGenBase.icePlains, BiomeGenBase.icePlains, BiomeGenBase.coldTaiga };
        this.parent = llllllllllllllIIIIIlllIlIllIlIIl;
        if (llllllllllllllIIIIIlllIlIllIlIII == WorldType.DEFAULT_1_1) {
            this.field_151623_c = new BiomeGenBase[] { BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga };
            this.field_175973_g = null;
        }
        else if (llllllllllllllIIIIIlllIlIllIlIII == WorldType.CUSTOMIZED) {
            this.field_175973_g = ChunkProviderSettings.Factory.func_177865_a(llllllllllllllIIIIIlllIlIllIIlll).func_177864_b();
        }
        else {
            this.field_175973_g = null;
        }
    }
    
    static {
        __OBFID = "CL_00000555";
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIIIIIlllIlIlIIlIlI, final int llllllllllllllIIIIIlllIlIlIlIlII, final int llllllllllllllIIIIIlllIlIlIIlIII, final int llllllllllllllIIIIIlllIlIlIIIlll) {
        final int[] llllllllllllllIIIIIlllIlIlIlIIIl = this.parent.getInts(llllllllllllllIIIIIlllIlIlIIlIlI, llllllllllllllIIIIIlllIlIlIlIlII, llllllllllllllIIIIIlllIlIlIIlIII, llllllllllllllIIIIIlllIlIlIIIlll);
        final int[] llllllllllllllIIIIIlllIlIlIlIIII = IntCache.getIntCache(llllllllllllllIIIIIlllIlIlIIlIII * llllllllllllllIIIIIlllIlIlIIIlll);
        for (int llllllllllllllIIIIIlllIlIlIIllll = 0; llllllllllllllIIIIIlllIlIlIIllll < llllllllllllllIIIIIlllIlIlIIIlll; ++llllllllllllllIIIIIlllIlIlIIllll) {
            for (int llllllllllllllIIIIIlllIlIlIIlllI = 0; llllllllllllllIIIIIlllIlIlIIlllI < llllllllllllllIIIIIlllIlIlIIlIII; ++llllllllllllllIIIIIlllIlIlIIlllI) {
                this.initChunkSeed(llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIlIlI, llllllllllllllIIIIIlllIlIlIIllll + llllllllllllllIIIIIlllIlIlIlIlII);
                int llllllllllllllIIIIIlllIlIlIIllIl = llllllllllllllIIIIIlllIlIlIlIIIl[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII];
                final int llllllllllllllIIIIIlllIlIlIIllII = (llllllllllllllIIIIIlllIlIlIIllIl & 0xF00) >> 8;
                llllllllllllllIIIIIlllIlIlIIllIl &= 0xFFFFF0FF;
                if (this.field_175973_g != null && this.field_175973_g.field_177779_F >= 0) {
                    llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = this.field_175973_g.field_177779_F;
                }
                else if (GenLayer.isBiomeOceanic(llllllllllllllIIIIIlllIlIlIIllIl)) {
                    llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = llllllllllllllIIIIIlllIlIlIIllIl;
                }
                else if (llllllllllllllIIIIIlllIlIlIIllIl == BiomeGenBase.mushroomIsland.biomeID) {
                    llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = llllllllllllllIIIIIlllIlIlIIllIl;
                }
                else if (llllllllllllllIIIIIlllIlIlIIllIl == 1) {
                    if (llllllllllllllIIIIIlllIlIlIIllII > 0) {
                        if (this.nextInt(3) == 0) {
                            llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = BiomeGenBase.mesaPlateau.biomeID;
                        }
                        else {
                            llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = BiomeGenBase.mesaPlateau_F.biomeID;
                        }
                    }
                    else {
                        llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = this.field_151623_c[this.nextInt(this.field_151623_c.length)].biomeID;
                    }
                }
                else if (llllllllllllllIIIIIlllIlIlIIllIl == 2) {
                    if (llllllllllllllIIIIIlllIlIlIIllII > 0) {
                        llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = BiomeGenBase.jungle.biomeID;
                    }
                    else {
                        llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = this.field_151621_d[this.nextInt(this.field_151621_d.length)].biomeID;
                    }
                }
                else if (llllllllllllllIIIIIlllIlIlIIllIl == 3) {
                    if (llllllllllllllIIIIIlllIlIlIIllII > 0) {
                        llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = BiomeGenBase.megaTaiga.biomeID;
                    }
                    else {
                        llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = this.field_151622_e[this.nextInt(this.field_151622_e.length)].biomeID;
                    }
                }
                else if (llllllllllllllIIIIIlllIlIlIIllIl == 4) {
                    llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = this.field_151620_f[this.nextInt(this.field_151620_f.length)].biomeID;
                }
                else {
                    llllllllllllllIIIIIlllIlIlIlIIII[llllllllllllllIIIIIlllIlIlIIlllI + llllllllllllllIIIIIlllIlIlIIllll * llllllllllllllIIIIIlllIlIlIIlIII] = BiomeGenBase.mushroomIsland.biomeID;
                }
            }
        }
        return llllllllllllllIIIIIlllIlIlIlIIII;
    }
}
