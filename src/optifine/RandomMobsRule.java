package optifine;

import net.minecraft.util.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.*;

public class RandomMobsRule
{
    private /* synthetic */ int[] weights;
    public /* synthetic */ int sumAllWeights;
    private /* synthetic */ ResourceLocation[] resourceLocations;
    private /* synthetic */ ResourceLocation baseResLoc;
    private /* synthetic */ int[] skins;
    public /* synthetic */ int[] sumWeights;
    private /* synthetic */ RangeListInt heights;
    private /* synthetic */ BiomeGenBase[] biomes;
    
    public ResourceLocation getTextureLocation(final ResourceLocation llllllllllllllIllIIllIlIIlIllIll, final int llllllllllllllIllIIllIlIIlIllIlI) {
        int llllllllllllllIllIIllIlIIlIllIIl = 0;
        if (this.weights == null) {
            llllllllllllllIllIIllIlIIlIllIIl = llllllllllllllIllIIllIlIIlIllIlI % this.resourceLocations.length;
        }
        else {
            final int llllllllllllllIllIIllIlIIlIllIII = llllllllllllllIllIIllIlIIlIllIlI % this.sumAllWeights;
            for (int llllllllllllllIllIIllIlIIlIlIlll = 0; llllllllllllllIllIIllIlIIlIlIlll < this.sumWeights.length; ++llllllllllllllIllIIllIlIIlIlIlll) {
                if (this.sumWeights[llllllllllllllIllIIllIlIIlIlIlll] > llllllllllllllIllIIllIlIIlIllIII) {
                    llllllllllllllIllIIllIlIIlIllIIl = llllllllllllllIllIIllIlIIlIlIlll;
                    break;
                }
            }
        }
        return this.resourceLocations[llllllllllllllIllIIllIlIIlIllIIl];
    }
    
    public boolean matches(final EntityLiving llllllllllllllIllIIllIlIIllIIIlI) {
        return Matches.biome(llllllllllllllIllIIllIlIIllIIIlI.spawnBiome, this.biomes) && (this.heights == null || llllllllllllllIllIIllIlIIllIIIlI.spawnPosition == null || this.heights.isInRange(llllllllllllllIllIIllIlIIllIIIlI.spawnPosition.getY()));
    }
    
    public boolean isValid(final String llllllllllllllIllIIllIlIIllIllIl) {
        this.resourceLocations = new ResourceLocation[this.skins.length];
        final ResourceLocation llllllllllllllIllIIllIlIIlllIlll = RandomMobs.getMcpatcherLocation(this.baseResLoc);
        if (llllllllllllllIllIIllIlIIlllIlll == null) {
            Config.warn(String.valueOf(new StringBuilder("Invalid path: ").append(this.baseResLoc.getResourcePath())));
            return false;
        }
        for (int llllllllllllllIllIIllIlIIlllIllI = 0; llllllllllllllIllIIllIlIIlllIllI < this.resourceLocations.length; ++llllllllllllllIllIIllIlIIlllIllI) {
            final int llllllllllllllIllIIllIlIIlllIlIl = this.skins[llllllllllllllIllIIllIlIIlllIllI];
            if (llllllllllllllIllIIllIlIIlllIlIl <= 1) {
                this.resourceLocations[llllllllllllllIllIIllIlIIlllIllI] = this.baseResLoc;
            }
            else {
                final ResourceLocation llllllllllllllIllIIllIlIIlllIIlI = RandomMobs.getLocationIndexed(llllllllllllllIllIIllIlIIlllIlll, llllllllllllllIllIIllIlIIlllIlIl);
                if (llllllllllllllIllIIllIlIIlllIIlI == null) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid path: ").append(this.baseResLoc.getResourcePath())));
                    return false;
                }
                if (!Config.hasResource(llllllllllllllIllIIllIlIIlllIIlI)) {
                    Config.warn(String.valueOf(new StringBuilder("Texture not found: ").append(llllllllllllllIllIIllIlIIlllIIlI.getResourcePath())));
                    return false;
                }
                this.resourceLocations[llllllllllllllIllIIllIlIIlllIllI] = llllllllllllllIllIIllIlIIlllIIlI;
            }
        }
        if (this.weights != null) {
            if (this.weights.length > this.resourceLocations.length) {
                Config.warn(String.valueOf(new StringBuilder("More weights defined than skins, trimming weights: ").append(llllllllllllllIllIIllIlIIllIllIl)));
                final int[] llllllllllllllIllIIllIlIIlllIIIl = new int[this.resourceLocations.length];
                System.arraycopy(this.weights, 0, llllllllllllllIllIIllIlIIlllIIIl, 0, llllllllllllllIllIIllIlIIlllIIIl.length);
                this.weights = llllllllllllllIllIIllIlIIlllIIIl;
            }
            if (this.weights.length < this.resourceLocations.length) {
                Config.warn(String.valueOf(new StringBuilder("Less weights defined than skins, expanding weights: ").append(llllllllllllllIllIIllIlIIllIllIl)));
                final int[] llllllllllllllIllIIllIlIIlllIIII = new int[this.resourceLocations.length];
                System.arraycopy(this.weights, 0, llllllllllllllIllIIllIlIIlllIIII, 0, this.weights.length);
                final int llllllllllllllIllIIllIlIIlllIlII = MathUtils.getAverage(this.weights);
                for (int llllllllllllllIllIIllIlIIllIllll = this.weights.length; llllllllllllllIllIIllIlIIllIllll < llllllllllllllIllIIllIlIIlllIIII.length; ++llllllllllllllIllIIllIlIIllIllll) {
                    llllllllllllllIllIIllIlIIlllIIII[llllllllllllllIllIIllIlIIllIllll] = llllllllllllllIllIIllIlIIlllIlII;
                }
                this.weights = llllllllllllllIllIIllIlIIlllIIII;
            }
            this.sumWeights = new int[this.weights.length];
            int llllllllllllllIllIIllIlIIlllIllI = 0;
            for (int llllllllllllllIllIIllIlIIlllIIll = 0; llllllllllllllIllIIllIlIIlllIIll < this.weights.length; ++llllllllllllllIllIIllIlIIlllIIll) {
                if (this.weights[llllllllllllllIllIIllIlIIlllIIll] < 0) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid weight: ").append(this.weights[llllllllllllllIllIIllIlIIlllIIll])));
                    return false;
                }
                llllllllllllllIllIIllIlIIlllIllI += this.weights[llllllllllllllIllIIllIlIIlllIIll];
                this.sumWeights[llllllllllllllIllIIllIlIIlllIIll] = llllllllllllllIllIIllIlIIlllIllI;
            }
            this.sumAllWeights = llllllllllllllIllIIllIlIIlllIllI;
            if (this.sumAllWeights <= 0) {
                Config.warn(String.valueOf(new StringBuilder("Invalid sum of all weights: ").append(llllllllllllllIllIIllIlIIlllIllI)));
                this.sumAllWeights = 1;
            }
        }
        return true;
    }
    
    public RandomMobsRule(final ResourceLocation llllllllllllllIllIIllIlIlIIIlIll, final int[] llllllllllllllIllIIllIlIlIIIlIlI, final int[] llllllllllllllIllIIllIlIlIIIlIIl, final BiomeGenBase[] llllllllllllllIllIIllIlIlIIIIIlI, final RangeListInt llllllllllllllIllIIllIlIlIIIIlll) {
        this.baseResLoc = null;
        this.skins = null;
        this.resourceLocations = null;
        this.weights = null;
        this.biomes = null;
        this.heights = null;
        this.sumWeights = null;
        this.sumAllWeights = 1;
        this.baseResLoc = llllllllllllllIllIIllIlIlIIIlIll;
        this.skins = llllllllllllllIllIIllIlIlIIIlIlI;
        this.weights = llllllllllllllIllIIllIlIlIIIlIIl;
        this.biomes = llllllllllllllIllIIllIlIlIIIIIlI;
        this.heights = llllllllllllllIllIIllIlIlIIIIlll;
    }
}
