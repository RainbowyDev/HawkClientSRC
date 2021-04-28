package optifine;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.biome.*;

public class RandomMobsProperties
{
    public /* synthetic */ String basePath;
    public /* synthetic */ String name;
    public /* synthetic */ RandomMobsRule[] rules;
    public /* synthetic */ ResourceLocation[] resourceLocations;
    
    public ResourceLocation getTextureLocation(final ResourceLocation llllllllllllllllIlIIIIIlllllIIlI, final EntityLiving llllllllllllllllIlIIIIIllllllIII) {
        if (this.rules != null) {
            for (int llllllllllllllllIlIIIIIlllllIlll = 0; llllllllllllllllIlIIIIIlllllIlll < this.rules.length; ++llllllllllllllllIlIIIIIlllllIlll) {
                final RandomMobsRule llllllllllllllllIlIIIIIlllllIlIl = this.rules[llllllllllllllllIlIIIIIlllllIlll];
                if (llllllllllllllllIlIIIIIlllllIlIl.matches(llllllllllllllllIlIIIIIllllllIII)) {
                    return llllllllllllllllIlIIIIIlllllIlIl.getTextureLocation(llllllllllllllllIlIIIIIlllllIIlI, llllllllllllllllIlIIIIIllllllIII.randomMobsId);
                }
            }
        }
        if (this.resourceLocations != null) {
            final int llllllllllllllllIlIIIIIlllllIllI = llllllllllllllllIlIIIIIllllllIII.randomMobsId;
            final int llllllllllllllllIlIIIIIlllllIlII = llllllllllllllllIlIIIIIlllllIllI % this.resourceLocations.length;
            return this.resourceLocations[llllllllllllllllIlIIIIIlllllIlII];
        }
        return llllllllllllllllIlIIIIIlllllIIlI;
    }
    
    public RandomMobsProperties(final String llllllllllllllllIlIIIIlIIIIlIIIl, final ResourceLocation[] llllllllllllllllIlIIIIlIIIIlIIII) {
        this.name = null;
        this.basePath = null;
        this.resourceLocations = null;
        this.rules = null;
        final ConnectedParser llllllllllllllllIlIIIIlIIIIlIIll = new ConnectedParser("RandomMobs");
        this.name = llllllllllllllllIlIIIIlIIIIlIIll.parseName(llllllllllllllllIlIIIIlIIIIlIIIl);
        this.basePath = llllllllllllllllIlIIIIlIIIIlIIll.parseBasePath(llllllllllllllllIlIIIIlIIIIlIIIl);
        this.resourceLocations = llllllllllllllllIlIIIIlIIIIlIIII;
    }
    
    private RandomMobsRule[] parseRules(final Properties llllllllllllllllIlIIIIIlllIlIIII, final ResourceLocation llllllllllllllllIlIIIIIlllIllllI, final ConnectedParser llllllllllllllllIlIIIIIlllIlllIl) {
        final ArrayList llllllllllllllllIlIIIIIlllIlllII = new ArrayList();
        for (int llllllllllllllllIlIIIIIlllIllIll = llllllllllllllllIlIIIIIlllIlIIII.size(), llllllllllllllllIlIIIIIlllIllIlI = 0; llllllllllllllllIlIIIIIlllIllIlI < llllllllllllllllIlIIIIIlllIllIll; ++llllllllllllllllIlIIIIIlllIllIlI) {
            final int llllllllllllllllIlIIIIIlllIllIIl = llllllllllllllllIlIIIIIlllIllIlI + 1;
            final String llllllllllllllllIlIIIIIlllIllIII = llllllllllllllllIlIIIIIlllIlIIII.getProperty(String.valueOf(new StringBuilder("skins.").append(llllllllllllllllIlIIIIIlllIllIIl)));
            if (llllllllllllllllIlIIIIIlllIllIII != null) {
                final int[] llllllllllllllllIlIIIIIlllIlIlll = llllllllllllllllIlIIIIIlllIlllIl.parseIntList(llllllllllllllllIlIIIIIlllIllIII);
                final int[] llllllllllllllllIlIIIIIlllIlIllI = llllllllllllllllIlIIIIIlllIlllIl.parseIntList(llllllllllllllllIlIIIIIlllIlIIII.getProperty(String.valueOf(new StringBuilder("weights.").append(llllllllllllllllIlIIIIIlllIllIIl))));
                final BiomeGenBase[] llllllllllllllllIlIIIIIlllIlIlIl = llllllllllllllllIlIIIIIlllIlllIl.parseBiomes(llllllllllllllllIlIIIIIlllIlIIII.getProperty(String.valueOf(new StringBuilder("biomes.").append(llllllllllllllllIlIIIIIlllIllIIl))));
                RangeListInt llllllllllllllllIlIIIIIlllIlIlII = llllllllllllllllIlIIIIIlllIlllIl.parseRangeListInt(llllllllllllllllIlIIIIIlllIlIIII.getProperty(String.valueOf(new StringBuilder("heights.").append(llllllllllllllllIlIIIIIlllIllIIl))));
                if (llllllllllllllllIlIIIIIlllIlIlII == null) {
                    llllllllllllllllIlIIIIIlllIlIlII = this.parseMinMaxHeight(llllllllllllllllIlIIIIIlllIlIIII, llllllllllllllllIlIIIIIlllIllIIl);
                }
                final RandomMobsRule llllllllllllllllIlIIIIIlllIlIIll = new RandomMobsRule(llllllllllllllllIlIIIIIlllIllllI, llllllllllllllllIlIIIIIlllIlIlll, llllllllllllllllIlIIIIIlllIlIllI, llllllllllllllllIlIIIIIlllIlIlIl, llllllllllllllllIlIIIIIlllIlIlII);
                llllllllllllllllIlIIIIIlllIlllII.add(llllllllllllllllIlIIIIIlllIlIIll);
            }
        }
        final RandomMobsRule[] llllllllllllllllIlIIIIIlllIlIIlI = llllllllllllllllIlIIIIIlllIlllII.toArray(new RandomMobsRule[llllllllllllllllIlIIIIIlllIlllII.size()]);
        return llllllllllllllllIlIIIIIlllIlIIlI;
    }
    
    public boolean isValid(final String llllllllllllllllIlIIIIIllIIIIllI) {
        if (this.resourceLocations == null && this.rules == null) {
            Config.warn(String.valueOf(new StringBuilder("No skins specified: ").append(llllllllllllllllIlIIIIIllIIIIllI)));
            return false;
        }
        if (this.rules != null) {
            for (int llllllllllllllllIlIIIIIllIIIIlIl = 0; llllllllllllllllIlIIIIIllIIIIlIl < this.rules.length; ++llllllllllllllllIlIIIIIllIIIIlIl) {
                final RandomMobsRule llllllllllllllllIlIIIIIllIIIIIll = this.rules[llllllllllllllllIlIIIIIllIIIIlIl];
                if (!llllllllllllllllIlIIIIIllIIIIIll.isValid(llllllllllllllllIlIIIIIllIIIIllI)) {
                    return false;
                }
            }
        }
        if (this.resourceLocations != null) {
            for (int llllllllllllllllIlIIIIIllIIIIlII = 0; llllllllllllllllIlIIIIIllIIIIlII < this.resourceLocations.length; ++llllllllllllllllIlIIIIIllIIIIlII) {
                final ResourceLocation llllllllllllllllIlIIIIIllIIIIIlI = this.resourceLocations[llllllllllllllllIlIIIIIllIIIIlII];
                if (!Config.hasResource(llllllllllllllllIlIIIIIllIIIIIlI)) {
                    Config.warn(String.valueOf(new StringBuilder("Texture not found: ").append(llllllllllllllllIlIIIIIllIIIIIlI.getResourcePath())));
                    return false;
                }
            }
        }
        return true;
    }
    
    public RandomMobsProperties(final Properties llllllllllllllllIlIIIIlIIIIIlIII, final String llllllllllllllllIlIIIIlIIIIIIlll, final ResourceLocation llllllllllllllllIlIIIIlIIIIIIIIl) {
        this.name = null;
        this.basePath = null;
        this.resourceLocations = null;
        this.rules = null;
        final ConnectedParser llllllllllllllllIlIIIIlIIIIIIlIl = new ConnectedParser("RandomMobs");
        this.name = llllllllllllllllIlIIIIlIIIIIIlIl.parseName(llllllllllllllllIlIIIIlIIIIIIlll);
        this.basePath = llllllllllllllllIlIIIIlIIIIIIlIl.parseBasePath(llllllllllllllllIlIIIIlIIIIIIlll);
        this.rules = this.parseRules(llllllllllllllllIlIIIIlIIIIIlIII, llllllllllllllllIlIIIIlIIIIIIIIl, llllllllllllllllIlIIIIlIIIIIIlIl);
    }
    
    private RangeListInt parseMinMaxHeight(final Properties llllllllllllllllIlIIIIIllIIllIIl, final int llllllllllllllllIlIIIIIllIIlIIIl) {
        final String llllllllllllllllIlIIIIIllIIlIlll = llllllllllllllllIlIIIIIllIIllIIl.getProperty(String.valueOf(new StringBuilder("minHeight.").append(llllllllllllllllIlIIIIIllIIlIIIl)));
        final String llllllllllllllllIlIIIIIllIIlIllI = llllllllllllllllIlIIIIIllIIllIIl.getProperty(String.valueOf(new StringBuilder("maxHeight.").append(llllllllllllllllIlIIIIIllIIlIIIl)));
        if (llllllllllllllllIlIIIIIllIIlIlll == null && llllllllllllllllIlIIIIIllIIlIllI == null) {
            return null;
        }
        int llllllllllllllllIlIIIIIllIIlIlIl = 0;
        if (llllllllllllllllIlIIIIIllIIlIlll != null) {
            llllllllllllllllIlIIIIIllIIlIlIl = Config.parseInt(llllllllllllllllIlIIIIIllIIlIlll, -1);
            if (llllllllllllllllIlIIIIIllIIlIlIl < 0) {
                Config.warn(String.valueOf(new StringBuilder("Invalid minHeight: ").append(llllllllllllllllIlIIIIIllIIlIlll)));
                return null;
            }
        }
        int llllllllllllllllIlIIIIIllIIlIlII = 256;
        if (llllllllllllllllIlIIIIIllIIlIllI != null) {
            llllllllllllllllIlIIIIIllIIlIlII = Config.parseInt(llllllllllllllllIlIIIIIllIIlIllI, -1);
            if (llllllllllllllllIlIIIIIllIIlIlII < 0) {
                Config.warn(String.valueOf(new StringBuilder("Invalid maxHeight: ").append(llllllllllllllllIlIIIIIllIIlIllI)));
                return null;
            }
        }
        if (llllllllllllllllIlIIIIIllIIlIlII < 0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid minHeight, maxHeight: ").append(llllllllllllllllIlIIIIIllIIlIlll).append(", ").append(llllllllllllllllIlIIIIIllIIlIllI)));
            return null;
        }
        final RangeListInt llllllllllllllllIlIIIIIllIIlIIll = new RangeListInt();
        llllllllllllllllIlIIIIIllIIlIIll.addRange(new RangeInt(llllllllllllllllIlIIIIIllIIlIlIl, llllllllllllllllIlIIIIIllIIlIlII));
        return llllllllllllllllIlIIIIIllIIlIIll;
    }
}
