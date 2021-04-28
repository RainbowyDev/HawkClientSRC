package optifine;

import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;

public class RandomMobs
{
    private static /* synthetic */ boolean working;
    private static /* synthetic */ Map locationProperties;
    private static /* synthetic */ Random random;
    private static final /* synthetic */ String[] DEPENDANT_SUFFIXES;
    private static /* synthetic */ boolean initialized;
    private static /* synthetic */ RenderGlobal renderGlobal;
    
    private static ResourceLocation getPropertyLocation(final ResourceLocation llllllllllllllIIlllIlllIlIIlIIII) {
        final ResourceLocation llllllllllllllIIlllIlllIlIIllIII = getMcpatcherLocation(llllllllllllllIIlllIlllIlIIlIIII);
        if (llllllllllllllIIlllIlllIlIIllIII == null) {
            return null;
        }
        final String llllllllllllllIIlllIlllIlIIlIlll = llllllllllllllIIlllIlllIlIIllIII.getResourceDomain();
        String llllllllllllllIIlllIlllIlIIlIlIl;
        final String llllllllllllllIIlllIlllIlIIlIllI = llllllllllllllIIlllIlllIlIIlIlIl = llllllllllllllIIlllIlllIlIIllIII.getResourcePath();
        if (llllllllllllllIIlllIlllIlIIlIllI.endsWith(".png")) {
            llllllllllllllIIlllIlllIlIIlIlIl = llllllllllllllIIlllIlllIlIIlIllI.substring(0, llllllllllllllIIlllIlllIlIIlIllI.length() - ".png".length());
        }
        final String llllllllllllllIIlllIlllIlIIlIlII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlllIlllIlIIlIlIl)).append(".properties"));
        final ResourceLocation llllllllllllllIIlllIlllIlIIlIIll = new ResourceLocation(llllllllllllllIIlllIlllIlIIlIlll, llllllllllllllIIlllIlllIlIIlIlII);
        if (Config.hasResource(llllllllllllllIIlllIlllIlIIlIIll)) {
            return llllllllllllllIIlllIlllIlIIlIIll;
        }
        final String llllllllllllllIIlllIlllIlIIlIIlI = getParentPath(llllllllllllllIIlllIlllIlIIlIlIl);
        if (llllllllllllllIIlllIlllIlIIlIIlI == null) {
            return null;
        }
        final ResourceLocation llllllllllllllIIlllIlllIlIIlIIIl = new ResourceLocation(llllllllllllllIIlllIlllIlIIlIlll, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlllIlllIlIIlIIlI)).append(".properties")));
        return Config.hasResource(llllllllllllllIIlllIlllIlIIlIIIl) ? llllllllllllllIIlllIlllIlIIlIIIl : null;
    }
    
    private static RandomMobsProperties makeProperties(final ResourceLocation llllllllllllllIIlllIlllIlIllllll) {
        final String llllllllllllllIIlllIlllIlIlllllI = llllllllllllllIIlllIlllIlIllllll.getResourcePath();
        final ResourceLocation llllllllllllllIIlllIlllIlIllllIl = getPropertyLocation(llllllllllllllIIlllIlllIlIllllll);
        if (llllllllllllllIIlllIlllIlIllllIl != null) {
            final RandomMobsProperties llllllllllllllIIlllIlllIlIllllII = parseProperties(llllllllllllllIIlllIlllIlIllllIl, llllllllllllllIIlllIlllIlIllllll);
            if (llllllllllllllIIlllIlllIlIllllII != null) {
                return llllllllllllllIIlllIlllIlIllllII;
            }
        }
        final ResourceLocation[] llllllllllllllIIlllIlllIlIlllIll = getTextureVariants(llllllllllllllIIlllIlllIlIllllll);
        return new RandomMobsProperties(llllllllllllllIIlllIlllIlIlllllI, llllllllllllllIIlllIlllIlIlllIll);
    }
    
    private static ResourceLocation[] getTextureVariants(final ResourceLocation llllllllllllllIIlllIlllIIlIlIlII) {
        final ArrayList llllllllllllllIIlllIlllIIlIlIIll = new ArrayList();
        llllllllllllllIIlllIlllIIlIlIIll.add(llllllllllllllIIlllIlllIIlIlIlII);
        final ResourceLocation llllllllllllllIIlllIlllIIlIlIIlI = getMcpatcherLocation(llllllllllllllIIlllIlllIIlIlIlII);
        if (llllllllllllllIIlllIlllIIlIlIIlI == null) {
            return null;
        }
        for (int llllllllllllllIIlllIlllIIlIlIIIl = 1; llllllllllllllIIlllIlllIIlIlIIIl < llllllllllllllIIlllIlllIIlIlIIll.size() + 10; ++llllllllllllllIIlllIlllIIlIlIIIl) {
            final int llllllllllllllIIlllIlllIIlIlIIII = llllllllllllllIIlllIlllIIlIlIIIl + 1;
            final ResourceLocation llllllllllllllIIlllIlllIIlIIllll = getLocationIndexed(llllllllllllllIIlllIlllIIlIlIIlI, llllllllllllllIIlllIlllIIlIlIIII);
            if (Config.hasResource(llllllllllllllIIlllIlllIIlIIllll)) {
                llllllllllllllIIlllIlllIIlIlIIll.add(llllllllllllllIIlllIlllIIlIIllll);
            }
        }
        if (llllllllllllllIIlllIlllIIlIlIIll.size() <= 1) {
            return null;
        }
        final ResourceLocation[] llllllllllllllIIlllIlllIIlIIlllI = llllllllllllllIIlllIlllIIlIlIIll.toArray(new ResourceLocation[llllllllllllllIIlllIlllIIlIlIIll.size()]);
        Config.dbg(String.valueOf(new StringBuilder("RandomMobs: ").append(llllllllllllllIIlllIlllIIlIlIlII.getResourcePath()).append(", variants: ").append(llllllllllllllIIlllIlllIIlIIlllI.length)));
        return llllllllllllllIIlllIlllIIlIIlllI;
    }
    
    private static RandomMobsProperties parseProperties(final ResourceLocation llllllllllllllIIlllIlllIlIlIlIII, final ResourceLocation llllllllllllllIIlllIlllIlIlIIlll) {
        try {
            final String llllllllllllllIIlllIlllIlIlIlllI = llllllllllllllIIlllIlllIlIlIlIII.getResourcePath();
            Config.dbg(String.valueOf(new StringBuilder("RandomMobs: ").append(llllllllllllllIIlllIlllIlIlIIlll.getResourcePath()).append(", variants: ").append(llllllllllllllIIlllIlllIlIlIlllI)));
            final InputStream llllllllllllllIIlllIlllIlIlIllIl = Config.getResourceStream(llllllllllllllIIlllIlllIlIlIlIII);
            if (llllllllllllllIIlllIlllIlIlIllIl == null) {
                Config.warn(String.valueOf(new StringBuilder("RandomMobs properties not found: ").append(llllllllllllllIIlllIlllIlIlIlllI)));
                return null;
            }
            final Properties llllllllllllllIIlllIlllIlIlIllII = new Properties();
            llllllllllllllIIlllIlllIlIlIllII.load(llllllllllllllIIlllIlllIlIlIllIl);
            llllllllllllllIIlllIlllIlIlIllIl.close();
            final RandomMobsProperties llllllllllllllIIlllIlllIlIlIlIll = new RandomMobsProperties(llllllllllllllIIlllIlllIlIlIllII, llllllllllllllIIlllIlllIlIlIlllI, llllllllllllllIIlllIlllIlIlIIlll);
            return llllllllllllllIIlllIlllIlIlIlIll.isValid(llllllllllllllIIlllIlllIlIlIlllI) ? llllllllllllllIIlllIlllIlIlIlIll : null;
        }
        catch (FileNotFoundException llllllllllllllIIlllIlllIlIlIlIlI) {
            Config.warn(String.valueOf(new StringBuilder("RandomMobs file not found: ").append(llllllllllllllIIlllIlllIlIlIIlll.getResourcePath())));
            return null;
        }
        catch (IOException llllllllllllllIIlllIlllIlIlIlIIl) {
            llllllllllllllIIlllIlllIlIlIlIIl.printStackTrace();
            return null;
        }
    }
    
    public static void worldChanged(final World llllllllllllllIIlllIlllIllllIIII, final World llllllllllllllIIlllIlllIlllIlIll) {
        if (llllllllllllllIIlllIlllIlllIlIll != null) {
            final List llllllllllllllIIlllIlllIlllIlllI = llllllllllllllIIlllIlllIlllIlIll.getLoadedEntityList();
            for (int llllllllllllllIIlllIlllIlllIllIl = 0; llllllllllllllIIlllIlllIlllIllIl < llllllllllllllIIlllIlllIlllIlllI.size(); ++llllllllllllllIIlllIlllIlllIllIl) {
                final Entity llllllllllllllIIlllIlllIlllIllII = llllllllllllllIIlllIlllIlllIlllI.get(llllllllllllllIIlllIlllIlllIllIl);
                entityLoaded(llllllllllllllIIlllIlllIlllIllII, llllllllllllllIIlllIlllIlllIlIll);
            }
        }
    }
    
    public static ResourceLocation getLocationIndexed(final ResourceLocation llllllllllllllIIlllIlllIIlllIllI, final int llllllllllllllIIlllIlllIIllIllIl) {
        if (llllllllllllllIIlllIlllIIlllIllI == null) {
            return null;
        }
        final String llllllllllllllIIlllIlllIIlllIlII = llllllllllllllIIlllIlllIIlllIllI.getResourcePath();
        final int llllllllllllllIIlllIlllIIlllIIll = llllllllllllllIIlllIlllIIlllIlII.lastIndexOf(46);
        if (llllllllllllllIIlllIlllIIlllIIll < 0) {
            return null;
        }
        final String llllllllllllllIIlllIlllIIlllIIlI = llllllllllllllIIlllIlllIIlllIlII.substring(0, llllllllllllllIIlllIlllIIlllIIll);
        final String llllllllllllllIIlllIlllIIlllIIIl = llllllllllllllIIlllIlllIIlllIlII.substring(llllllllllllllIIlllIlllIIlllIIll);
        final String llllllllllllllIIlllIlllIIlllIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlllIlllIIlllIIlI)).append(llllllllllllllIIlllIlllIIllIllIl).append(llllllllllllllIIlllIlllIIlllIIIl));
        final ResourceLocation llllllllllllllIIlllIlllIIllIllll = new ResourceLocation(llllllllllllllIIlllIlllIIlllIllI.getResourceDomain(), llllllllllllllIIlllIlllIIlllIIII);
        return llllllllllllllIIlllIlllIIllIllll;
    }
    
    public static ResourceLocation getTextureLocation(final ResourceLocation llllllllllllllIIlllIlllIllIlIlII) {
        if (RandomMobs.working) {
            return llllllllllllllIIlllIlllIllIlIlII;
        }
        try {
            RandomMobs.working = true;
            if (!RandomMobs.initialized) {
                initialize();
            }
            if (RandomMobs.renderGlobal == null) {
                final Exception llllllllllllllIIlllIlllIllIIllIl;
                final ResourceLocation llllllllllllllIIlllIlllIllIllIll = (ResourceLocation)(llllllllllllllIIlllIlllIllIIllIl = (Exception)llllllllllllllIIlllIlllIllIlIlII);
                return (ResourceLocation)llllllllllllllIIlllIlllIllIIllIl;
            }
            final Entity llllllllllllllIIlllIlllIllIllIlI = RandomMobs.renderGlobal.renderedEntity;
            if (!(llllllllllllllIIlllIlllIllIllIlI instanceof EntityLiving)) {
                final Exception llllllllllllllIIlllIlllIllIIllIl;
                final ResourceLocation llllllllllllllIIlllIlllIllIllIIl = (ResourceLocation)(llllllllllllllIIlllIlllIllIIllIl = (Exception)llllllllllllllIIlllIlllIllIlIlII);
                return (ResourceLocation)llllllllllllllIIlllIlllIllIIllIl;
            }
            final EntityLiving llllllllllllllIIlllIlllIllIllIII = (EntityLiving)llllllllllllllIIlllIlllIllIllIlI;
            final String llllllllllllllIIlllIlllIllIlIlll = llllllllllllllIIlllIlllIllIlIlII.getResourcePath();
            if (!llllllllllllllIIlllIlllIllIlIlll.startsWith("textures/entity/")) {
                final Exception llllllllllllllIIlllIlllIllIIllIl;
                final ResourceLocation llllllllllllllIIlllIlllIllIlIllI = (ResourceLocation)(llllllllllllllIIlllIlllIllIIllIl = (Exception)llllllllllllllIIlllIlllIllIlIlII);
                return (ResourceLocation)llllllllllllllIIlllIlllIllIIllIl;
            }
            final RandomMobsProperties llllllllllllllIIlllIlllIllIlIlIl = getProperties(llllllllllllllIIlllIlllIllIlIlII);
            if (llllllllllllllIIlllIlllIllIlIlIl != null) {
                final Exception llllllllllllllIIlllIlllIllIIllIl;
                final ResourceLocation llllllllllllllIIlllIlllIllIllllI = (ResourceLocation)(llllllllllllllIIlllIlllIllIIllIl = (Exception)llllllllllllllIIlllIlllIllIlIlIl.getTextureLocation(llllllllllllllIIlllIlllIllIlIlII, llllllllllllllIIlllIlllIllIllIII));
                return (ResourceLocation)llllllllllllllIIlllIlllIllIIllIl;
            }
            final ResourceLocation llllllllllllllIIlllIlllIllIlllIl = llllllllllllllIIlllIlllIllIlIlII;
        }
        finally {
            RandomMobs.working = false;
        }
        RandomMobs.working = false;
        final ResourceLocation llllllllllllllIIlllIlllIllIlllII;
        return llllllllllllllIIlllIlllIllIlllII;
    }
    
    public static void entityLoaded(final Entity llllllllllllllIIlllIlllIllllllIl, final World llllllllllllllIIlllIllllIIIIIlIl) {
        if (llllllllllllllIIlllIlllIllllllIl instanceof EntityLiving && llllllllllllllIIlllIllllIIIIIlIl != null) {
            final EntityLiving llllllllllllllIIlllIllllIIIIIlII = (EntityLiving)llllllllllllllIIlllIlllIllllllIl;
            llllllllllllllIIlllIllllIIIIIlII.spawnPosition = llllllllllllllIIlllIllllIIIIIlII.getPosition();
            llllllllllllllIIlllIllllIIIIIlII.spawnBiome = llllllllllllllIIlllIllllIIIIIlIl.getBiomeGenForCoords(llllllllllllllIIlllIllllIIIIIlII.spawnPosition);
            final WorldServer llllllllllllllIIlllIllllIIIIIIll = Config.getWorldServer();
            if (llllllllllllllIIlllIllllIIIIIIll != null) {
                final Entity llllllllllllllIIlllIllllIIIIIIlI = llllllllllllllIIlllIllllIIIIIIll.getEntityByID(llllllllllllllIIlllIlllIllllllIl.getEntityId());
                if (llllllllllllllIIlllIllllIIIIIIlI instanceof EntityLiving) {
                    final EntityLiving llllllllllllllIIlllIllllIIIIIIIl = (EntityLiving)llllllllllllllIIlllIllllIIIIIIlI;
                    final UUID llllllllllllllIIlllIllllIIIIIIII = llllllllllllllIIlllIllllIIIIIIIl.getUniqueID();
                    final long llllllllllllllIIlllIlllIllllllll = llllllllllllllIIlllIllllIIIIIIII.getLeastSignificantBits();
                    final int llllllllllllllIIlllIlllIlllllllI = (int)(llllllllllllllIIlllIlllIllllllll & 0x7FFFFFFFL);
                    llllllllllllllIIlllIllllIIIIIlII.randomMobsId = llllllllllllllIIlllIlllIlllllllI;
                }
            }
        }
    }
    
    public static ResourceLocation getMcpatcherLocation(final ResourceLocation llllllllllllllIIlllIlllIlIIIIIIl) {
        final String llllllllllllllIIlllIlllIlIIIIIll = llllllllllllllIIlllIlllIlIIIIIIl.getResourcePath();
        if (!llllllllllllllIIlllIlllIlIIIIIll.startsWith("textures/entity/")) {
            return null;
        }
        final String llllllllllllllIIlllIlllIlIIIIIlI = String.valueOf(new StringBuilder("mcpatcher/mob/").append(llllllllllllllIIlllIlllIlIIIIIll.substring("textures/entity/".length())));
        return new ResourceLocation(llllllllllllllIIlllIlllIlIIIIIIl.getResourceDomain(), llllllllllllllIIlllIlllIlIIIIIlI);
    }
    
    public static void resetTextures() {
        RandomMobs.locationProperties.clear();
        if (Config.isRandomMobs()) {
            initialize();
        }
    }
    
    private static void initialize() {
        RandomMobs.renderGlobal = Config.getRenderGlobal();
        if (RandomMobs.renderGlobal != null) {
            RandomMobs.initialized = true;
            final ArrayList llllllllllllllIIlllIlllIIlIIIIlI = new ArrayList();
            llllllllllllllIIlllIlllIIlIIIIlI.add("bat");
            llllllllllllllIIlllIlllIIlIIIIlI.add("blaze");
            llllllllllllllIIlllIlllIIlIIIIlI.add("cat/black");
            llllllllllllllIIlllIlllIIlIIIIlI.add("cat/ocelot");
            llllllllllllllIIlllIlllIIlIIIIlI.add("cat/red");
            llllllllllllllIIlllIlllIIlIIIIlI.add("cat/siamese");
            llllllllllllllIIlllIlllIIlIIIIlI.add("chicken");
            llllllllllllllIIlllIlllIIlIIIIlI.add("cow/cow");
            llllllllllllllIIlllIlllIIlIIIIlI.add("cow/mooshroom");
            llllllllllllllIIlllIlllIIlIIIIlI.add("creeper/creeper");
            llllllllllllllIIlllIlllIIlIIIIlI.add("enderman/enderman");
            llllllllllllllIIlllIlllIIlIIIIlI.add("enderman/enderman_eyes");
            llllllllllllllIIlllIlllIIlIIIIlI.add("ghast/ghast");
            llllllllllllllIIlllIlllIIlIIIIlI.add("ghast/ghast_shooting");
            llllllllllllllIIlllIlllIIlIIIIlI.add("iron_golem");
            llllllllllllllIIlllIlllIIlIIIIlI.add("pig/pig");
            llllllllllllllIIlllIlllIIlIIIIlI.add("sheep/sheep");
            llllllllllllllIIlllIlllIIlIIIIlI.add("sheep/sheep_fur");
            llllllllllllllIIlllIlllIIlIIIIlI.add("silverfish");
            llllllllllllllIIlllIlllIIlIIIIlI.add("skeleton/skeleton");
            llllllllllllllIIlllIlllIIlIIIIlI.add("skeleton/wither_skeleton");
            llllllllllllllIIlllIlllIIlIIIIlI.add("slime/slime");
            llllllllllllllIIlllIlllIIlIIIIlI.add("slime/magmacube");
            llllllllllllllIIlllIlllIIlIIIIlI.add("snowman");
            llllllllllllllIIlllIlllIIlIIIIlI.add("spider/cave_spider");
            llllllllllllllIIlllIlllIIlIIIIlI.add("spider/spider");
            llllllllllllllIIlllIlllIIlIIIIlI.add("spider_eyes");
            llllllllllllllIIlllIlllIIlIIIIlI.add("squid");
            llllllllllllllIIlllIlllIIlIIIIlI.add("villager/villager");
            llllllllllllllIIlllIlllIIlIIIIlI.add("villager/butcher");
            llllllllllllllIIlllIlllIIlIIIIlI.add("villager/farmer");
            llllllllllllllIIlllIlllIIlIIIIlI.add("villager/librarian");
            llllllllllllllIIlllIlllIIlIIIIlI.add("villager/priest");
            llllllllllllllIIlllIlllIIlIIIIlI.add("villager/smith");
            llllllllllllllIIlllIlllIIlIIIIlI.add("wither/wither");
            llllllllllllllIIlllIlllIIlIIIIlI.add("wither/wither_armor");
            llllllllllllllIIlllIlllIIlIIIIlI.add("wither/wither_invulnerable");
            llllllllllllllIIlllIlllIIlIIIIlI.add("wolf/wolf");
            llllllllllllllIIlllIlllIIlIIIIlI.add("wolf/wolf_angry");
            llllllllllllllIIlllIlllIIlIIIIlI.add("wolf/wolf_collar");
            llllllllllllllIIlllIlllIIlIIIIlI.add("wolf/wolf_tame");
            llllllllllllllIIlllIlllIIlIIIIlI.add("zombie_pigman");
            llllllllllllllIIlllIlllIIlIIIIlI.add("zombie/zombie");
            llllllllllllllIIlllIlllIIlIIIIlI.add("zombie/zombie_villager");
            for (int llllllllllllllIIlllIlllIIlIIIIIl = 0; llllllllllllllIIlllIlllIIlIIIIIl < llllllllllllllIIlllIlllIIlIIIIlI.size(); ++llllllllllllllIIlllIlllIIlIIIIIl) {
                final String llllllllllllllIIlllIlllIIlIIIIII = llllllllllllllIIlllIlllIIlIIIIlI.get(llllllllllllllIIlllIlllIIlIIIIIl);
                final String llllllllllllllIIlllIlllIIIllllll = String.valueOf(new StringBuilder("textures/entity/").append(llllllllllllllIIlllIlllIIlIIIIII).append(".png"));
                final ResourceLocation llllllllllllllIIlllIlllIIIlllllI = new ResourceLocation(llllllllllllllIIlllIlllIIIllllll);
                if (!Config.hasResource(llllllllllllllIIlllIlllIIIlllllI)) {
                    Config.warn(String.valueOf(new StringBuilder("Not found: ").append(llllllllllllllIIlllIlllIIIlllllI)));
                }
                getProperties(llllllllllllllIIlllIlllIIIlllllI);
            }
        }
    }
    
    private static RandomMobsProperties getProperties(final ResourceLocation llllllllllllllIIlllIlllIllIIIllI) {
        final String llllllllllllllIIlllIlllIllIIlIII = llllllllllllllIIlllIlllIllIIIllI.getResourcePath();
        RandomMobsProperties llllllllllllllIIlllIlllIllIIIlll = RandomMobs.locationProperties.get(llllllllllllllIIlllIlllIllIIlIII);
        if (llllllllllllllIIlllIlllIllIIIlll == null) {
            llllllllllllllIIlllIlllIllIIIlll = makeProperties(llllllllllllllIIlllIlllIllIIIllI);
            RandomMobs.locationProperties.put(llllllllllllllIIlllIlllIllIIlIII, llllllllllllllIIlllIlllIllIIIlll);
        }
        return llllllllllllllIIlllIlllIllIIIlll;
    }
    
    static {
        PREFIX_TEXTURES_ENTITY = "textures/entity/";
        PREFIX_MCPATCHER_MOB = "mcpatcher/mob/";
        SUFFIX_PNG = ".png";
        SUFFIX_PROPERTIES = ".properties";
        RandomMobs.locationProperties = new HashMap();
        RandomMobs.renderGlobal = null;
        RandomMobs.initialized = false;
        RandomMobs.random = new Random();
        RandomMobs.working = false;
        DEPENDANT_SUFFIXES = new String[] { "_armor", "_eyes", "_exploding", "_shooting", "_fur", "_eyes", "_invulnerable", "_angry", "_tame", "_collar" };
    }
    
    private static String getParentPath(final String llllllllllllllIIlllIlllIIlIllllI) {
        for (int llllllllllllllIIlllIlllIIllIIIIl = 0; llllllllllllllIIlllIlllIIllIIIIl < RandomMobs.DEPENDANT_SUFFIXES.length; ++llllllllllllllIIlllIlllIIllIIIIl) {
            final String llllllllllllllIIlllIlllIIllIIIII = RandomMobs.DEPENDANT_SUFFIXES[llllllllllllllIIlllIlllIIllIIIIl];
            if (llllllllllllllIIlllIlllIIlIllllI.endsWith(llllllllllllllIIlllIlllIIllIIIII)) {
                final String llllllllllllllIIlllIlllIIlIlllll = llllllllllllllIIlllIlllIIlIllllI.substring(0, llllllllllllllIIlllIlllIIlIllllI.length() - llllllllllllllIIlllIlllIIllIIIII.length());
                return llllllllllllllIIlllIlllIIlIlllll;
            }
        }
        return null;
    }
}
