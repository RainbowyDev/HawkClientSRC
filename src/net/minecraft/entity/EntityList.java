package net.minecraft.entity;

import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.effect.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.item.*;
import net.minecraft.stats.*;

public class EntityList
{
    private static final /* synthetic */ Map classToIDMapping;
    public static final /* synthetic */ Map entityEggs;
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ Map idToClassMapping;
    private static final /* synthetic */ Map classToStringMapping;
    private static final /* synthetic */ Map field_180126_g;
    private static final /* synthetic */ Map stringToClassMapping;
    
    public static String getEntityString(final Entity lllllllllllllllIIlIlIIlIIllIlIll) {
        return EntityList.classToStringMapping.get(lllllllllllllllIIlIlIIlIIllIlIll.getClass());
    }
    
    public static int getEntityID(final Entity lllllllllllllllIIlIlIIlIIlllIlII) {
        final Integer lllllllllllllllIIlIlIIlIIlllIIll = EntityList.classToIDMapping.get(lllllllllllllllIIlIlIIlIIlllIlII.getClass());
        return (lllllllllllllllIIlIlIIlIIlllIIll == null) ? 0 : lllllllllllllllIIlIlIIlIIlllIIll;
    }
    
    public static List func_180124_b() {
        final Set lllllllllllllllIIlIlIIlIIlIlllII = EntityList.stringToClassMapping.keySet();
        final ArrayList lllllllllllllllIIlIlIIlIIlIllIll = Lists.newArrayList();
        for (final String lllllllllllllllIIlIlIIlIIlIllIIl : lllllllllllllllIIlIlIIlIIlIlllII) {
            final Class lllllllllllllllIIlIlIIlIIlIllIII = EntityList.stringToClassMapping.get(lllllllllllllllIIlIlIIlIIlIllIIl);
            if ((lllllllllllllllIIlIlIIlIIlIllIII.getModifiers() & 0x400) != 0x400) {
                lllllllllllllllIIlIlIIlIIlIllIll.add(lllllllllllllllIIlIlIIlIIlIllIIl);
            }
        }
        lllllllllllllllIIlIlIIlIIlIllIll.add("LightningBolt");
        return lllllllllllllllIIlIlIIlIIlIllIll;
    }
    
    public static int func_180122_a(final String lllllllllllllllIIlIlIIlIIllIIllI) {
        final Integer lllllllllllllllIIlIlIIlIIllIIlll = EntityList.field_180126_g.get(lllllllllllllllIIlIlIIlIIllIIllI);
        return (lllllllllllllllIIlIlIIlIIllIIlll == null) ? 90 : lllllllllllllllIIlIlIIlIIllIIlll;
    }
    
    public static boolean func_180123_a(final Entity lllllllllllllllIIlIlIIlIIlIIllII, final String lllllllllllllllIIlIlIIlIIlIIlllI) {
        String lllllllllllllllIIlIlIIlIIlIIllIl = getEntityString(lllllllllllllllIIlIlIIlIIlIIllII);
        if (lllllllllllllllIIlIlIIlIIlIIllIl == null && lllllllllllllllIIlIlIIlIIlIIllII instanceof EntityPlayer) {
            lllllllllllllllIIlIlIIlIIlIIllIl = "Player";
        }
        else if (lllllllllllllllIIlIlIIlIIlIIllIl == null && lllllllllllllllIIlIlIIlIIlIIllII instanceof EntityLightningBolt) {
            lllllllllllllllIIlIlIIlIIlIIllIl = "LightningBolt";
        }
        return lllllllllllllllIIlIlIIlIIlIIlllI.equals(lllllllllllllllIIlIlIIlIIlIIllIl);
    }
    
    public static Entity createEntityByName(final String lllllllllllllllIIlIlIIlIlIllIllI, final World lllllllllllllllIIlIlIIlIlIllIlII) {
        Entity lllllllllllllllIIlIlIIlIlIllllII = null;
        try {
            final Class lllllllllllllllIIlIlIIlIlIlllIlI = EntityList.stringToClassMapping.get(lllllllllllllllIIlIlIIlIlIllIllI);
            if (lllllllllllllllIIlIlIIlIlIlllIlI != null) {
                lllllllllllllllIIlIlIIlIlIllllII = lllllllllllllllIIlIlIIlIlIlllIlI.getConstructor(World.class).newInstance(lllllllllllllllIIlIlIIlIlIllIlII);
            }
        }
        catch (Exception lllllllllllllllIIlIlIIlIlIlllIII) {
            lllllllllllllllIIlIlIIlIlIlllIII.printStackTrace();
        }
        return lllllllllllllllIIlIlIIlIlIllllII;
    }
    
    private static void addMapping(final Class lllllllllllllllIIlIlIIlIllIlIlIl, final String lllllllllllllllIIlIlIIlIllIllIIl, final int lllllllllllllllIIlIlIIlIllIllIII, final int lllllllllllllllIIlIlIIlIllIlIlll, final int lllllllllllllllIIlIlIIlIllIlIllI) {
        addMapping(lllllllllllllllIIlIlIIlIllIlIlIl, lllllllllllllllIIlIlIIlIllIllIIl, lllllllllllllllIIlIlIIlIllIllIII);
        EntityList.entityEggs.put(lllllllllllllllIIlIlIIlIllIllIII, new EntityEggInfo(lllllllllllllllIIlIlIIlIllIllIII, lllllllllllllllIIlIlIIlIllIlIlll, lllllllllllllllIIlIlIIlIllIlIllI));
    }
    
    private static void addMapping(final Class lllllllllllllllIIlIlIIlIllllIIIl, final String lllllllllllllllIIlIlIIlIllllIIII, final int lllllllllllllllIIlIlIIlIlllIllll) {
        if (EntityList.stringToClassMapping.containsKey(lllllllllllllllIIlIlIIlIllllIIII)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("ID is already registered: ").append(lllllllllllllllIIlIlIIlIllllIIII)));
        }
        if (EntityList.idToClassMapping.containsKey(lllllllllllllllIIlIlIIlIlllIllll)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("ID is already registered: ").append(lllllllllllllllIIlIlIIlIlllIllll)));
        }
        if (lllllllllllllllIIlIlIIlIlllIllll == 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Cannot register to reserved id: ").append(lllllllllllllllIIlIlIIlIlllIllll)));
        }
        if (lllllllllllllllIIlIlIIlIllllIIIl == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Cannot register null clazz for id: ").append(lllllllllllllllIIlIlIIlIlllIllll)));
        }
        EntityList.stringToClassMapping.put(lllllllllllllllIIlIlIIlIllllIIII, lllllllllllllllIIlIlIIlIllllIIIl);
        EntityList.classToStringMapping.put(lllllllllllllllIIlIlIIlIllllIIIl, lllllllllllllllIIlIlIIlIllllIIII);
        EntityList.idToClassMapping.put(lllllllllllllllIIlIlIIlIlllIllll, lllllllllllllllIIlIlIIlIllllIIIl);
        EntityList.classToIDMapping.put(lllllllllllllllIIlIlIIlIllllIIIl, lllllllllllllllIIlIlIIlIlllIllll);
        EntityList.field_180126_g.put(lllllllllllllllIIlIlIIlIllllIIII, lllllllllllllllIIlIlIIlIlllIllll);
    }
    
    public static Entity createEntityByID(final int lllllllllllllllIIlIlIIlIIlllllIl, final World lllllllllllllllIIlIlIIlIlIIIIIll) {
        Entity lllllllllllllllIIlIlIIlIlIIIIIlI = null;
        try {
            final Class lllllllllllllllIIlIlIIlIlIIIIIIl = getClassFromID(lllllllllllllllIIlIlIIlIIlllllIl);
            if (lllllllllllllllIIlIlIIlIlIIIIIIl != null) {
                lllllllllllllllIIlIlIIlIlIIIIIlI = lllllllllllllllIIlIlIIlIlIIIIIIl.getConstructor(World.class).newInstance(lllllllllllllllIIlIlIIlIlIIIIIll);
            }
        }
        catch (Exception lllllllllllllllIIlIlIIlIIlllllll) {
            lllllllllllllllIIlIlIIlIIlllllll.printStackTrace();
        }
        if (lllllllllllllllIIlIlIIlIlIIIIIlI == null) {
            EntityList.logger.warn(String.valueOf(new StringBuilder("Skipping Entity with id ").append(lllllllllllllllIIlIlIIlIIlllllIl)));
        }
        return lllllllllllllllIIlIlIIlIlIIIIIlI;
    }
    
    public static boolean func_180125_b(final String lllllllllllllllIIlIlIIlIIlIIlIII) {
        return "Player".equals(lllllllllllllllIIlIlIIlIIlIIlIII) || func_180124_b().contains(lllllllllllllllIIlIlIIlIIlIIlIII);
    }
    
    public static void func_151514_a() {
    }
    
    public static String getStringFromID(final int lllllllllllllllIIlIlIIlIIllIIIll) {
        return EntityList.classToStringMapping.get(getClassFromID(lllllllllllllllIIlIlIIlIIllIIIll));
    }
    
    public static Entity createEntityFromNBT(final NBTTagCompound lllllllllllllllIIlIlIIlIlIIllIll, final World lllllllllllllllIIlIlIIlIlIIllIlI) {
        Entity lllllllllllllllIIlIlIIlIlIIllIIl = null;
        if ("Minecart".equals(lllllllllllllllIIlIlIIlIlIIllIll.getString("id"))) {
            lllllllllllllllIIlIlIIlIlIIllIll.setString("id", EntityMinecart.EnumMinecartType.func_180038_a(lllllllllllllllIIlIlIIlIlIIllIll.getInteger("Type")).func_180040_b());
            lllllllllllllllIIlIlIIlIlIIllIll.removeTag("Type");
        }
        try {
            final Class lllllllllllllllIIlIlIIlIlIIllIII = EntityList.stringToClassMapping.get(lllllllllllllllIIlIlIIlIlIIllIll.getString("id"));
            if (lllllllllllllllIIlIlIIlIlIIllIII != null) {
                lllllllllllllllIIlIlIIlIlIIllIIl = lllllllllllllllIIlIlIIlIlIIllIII.getConstructor(World.class).newInstance(lllllllllllllllIIlIlIIlIlIIllIlI);
            }
        }
        catch (Exception lllllllllllllllIIlIlIIlIlIIlIlll) {
            lllllllllllllllIIlIlIIlIlIIlIlll.printStackTrace();
        }
        if (lllllllllllllllIIlIlIIlIlIIllIIl != null) {
            lllllllllllllllIIlIlIIlIlIIllIIl.readFromNBT(lllllllllllllllIIlIlIIlIlIIllIll);
        }
        else {
            EntityList.logger.warn(String.valueOf(new StringBuilder("Skipping Entity with id ").append(lllllllllllllllIIlIlIIlIlIIllIll.getString("id"))));
        }
        return lllllllllllllllIIlIlIIlIlIIllIIl;
    }
    
    public static Class getClassFromID(final int lllllllllllllllIIlIlIIlIIllIlllI) {
        return EntityList.idToClassMapping.get(lllllllllllllllIIlIlIIlIIllIlllI);
    }
    
    static {
        __OBFID = "CL_00001538";
        logger = LogManager.getLogger();
        stringToClassMapping = Maps.newHashMap();
        classToStringMapping = Maps.newHashMap();
        idToClassMapping = Maps.newHashMap();
        classToIDMapping = Maps.newHashMap();
        field_180126_g = Maps.newHashMap();
        entityEggs = Maps.newLinkedHashMap();
        addMapping(EntityItem.class, "Item", 1);
        addMapping(EntityXPOrb.class, "XPOrb", 2);
        addMapping(EntityLeashKnot.class, "LeashKnot", 8);
        addMapping(EntityPainting.class, "Painting", 9);
        addMapping(EntityArrow.class, "Arrow", 10);
        addMapping(EntitySnowball.class, "Snowball", 11);
        addMapping(EntityLargeFireball.class, "Fireball", 12);
        addMapping(EntitySmallFireball.class, "SmallFireball", 13);
        addMapping(EntityEnderPearl.class, "ThrownEnderpearl", 14);
        addMapping(EntityEnderEye.class, "EyeOfEnderSignal", 15);
        addMapping(EntityPotion.class, "ThrownPotion", 16);
        addMapping(EntityExpBottle.class, "ThrownExpBottle", 17);
        addMapping(EntityItemFrame.class, "ItemFrame", 18);
        addMapping(EntityWitherSkull.class, "WitherSkull", 19);
        addMapping(EntityTNTPrimed.class, "PrimedTnt", 20);
        addMapping(EntityFallingBlock.class, "FallingSand", 21);
        addMapping(EntityFireworkRocket.class, "FireworksRocketEntity", 22);
        addMapping(EntityArmorStand.class, "ArmorStand", 30);
        addMapping(EntityBoat.class, "Boat", 41);
        addMapping(EntityMinecartEmpty.class, EntityMinecart.EnumMinecartType.RIDEABLE.func_180040_b(), 42);
        addMapping(EntityMinecartChest.class, EntityMinecart.EnumMinecartType.CHEST.func_180040_b(), 43);
        addMapping(EntityMinecartFurnace.class, EntityMinecart.EnumMinecartType.FURNACE.func_180040_b(), 44);
        addMapping(EntityMinecartTNT.class, EntityMinecart.EnumMinecartType.TNT.func_180040_b(), 45);
        addMapping(EntityMinecartHopper.class, EntityMinecart.EnumMinecartType.HOPPER.func_180040_b(), 46);
        addMapping(EntityMinecartMobSpawner.class, EntityMinecart.EnumMinecartType.SPAWNER.func_180040_b(), 47);
        addMapping(EntityMinecartCommandBlock.class, EntityMinecart.EnumMinecartType.COMMAND_BLOCK.func_180040_b(), 40);
        addMapping(EntityLiving.class, "Mob", 48);
        addMapping(EntityMob.class, "Monster", 49);
        addMapping(EntityCreeper.class, "Creeper", 50, 894731, 0);
        addMapping(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
        addMapping(EntitySpider.class, "Spider", 52, 3419431, 11013646);
        addMapping(EntityGiantZombie.class, "Giant", 53);
        addMapping(EntityZombie.class, "Zombie", 54, 44975, 7969893);
        addMapping(EntitySlime.class, "Slime", 55, 5349438, 8306542);
        addMapping(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
        addMapping(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
        addMapping(EntityEnderman.class, "Enderman", 58, 1447446, 0);
        addMapping(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
        addMapping(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
        addMapping(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
        addMapping(EntityMagmaCube.class, "LavaSlime", 62, 3407872, 16579584);
        addMapping(EntityDragon.class, "EnderDragon", 63);
        addMapping(EntityWither.class, "WitherBoss", 64);
        addMapping(EntityBat.class, "Bat", 65, 4996656, 986895);
        addMapping(EntityWitch.class, "Witch", 66, 3407872, 5349438);
        addMapping(EntityEndermite.class, "Endermite", 67, 1447446, 7237230);
        addMapping(EntityGuardian.class, "Guardian", 68, 5931634, 15826224);
        addMapping(EntityPig.class, "Pig", 90, 15771042, 14377823);
        addMapping(EntitySheep.class, "Sheep", 91, 15198183, 16758197);
        addMapping(EntityCow.class, "Cow", 92, 4470310, 10592673);
        addMapping(EntityChicken.class, "Chicken", 93, 10592673, 16711680);
        addMapping(EntitySquid.class, "Squid", 94, 2243405, 7375001);
        addMapping(EntityWolf.class, "Wolf", 95, 14144467, 13545366);
        addMapping(EntityMooshroom.class, "MushroomCow", 96, 10489616, 12040119);
        addMapping(EntitySnowman.class, "SnowMan", 97);
        addMapping(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
        addMapping(EntityIronGolem.class, "VillagerGolem", 99);
        addMapping(EntityHorse.class, "EntityHorse", 100, 12623485, 15656192);
        addMapping(EntityRabbit.class, "Rabbit", 101, 10051392, 7555121);
        addMapping(EntityVillager.class, "Villager", 120, 5651507, 12422002);
        addMapping(EntityEnderCrystal.class, "EnderCrystal", 200);
    }
    
    public static class EntityEggInfo
    {
        public final /* synthetic */ int primaryColor;
        public final /* synthetic */ StatBase field_151512_d;
        public final /* synthetic */ int spawnedID;
        public final /* synthetic */ int secondaryColor;
        public final /* synthetic */ StatBase field_151513_e;
        
        static {
            __OBFID = "CL_00001539";
        }
        
        public EntityEggInfo(final int lllllllllllllllIIllIIllIllIlIIlI, final int lllllllllllllllIIllIIllIllIlIlIl, final int lllllllllllllllIIllIIllIllIlIIII) {
            this.spawnedID = lllllllllllllllIIllIIllIllIlIIlI;
            this.primaryColor = lllllllllllllllIIllIIllIllIlIlIl;
            this.secondaryColor = lllllllllllllllIIllIIllIllIlIIII;
            this.field_151512_d = StatList.func_151182_a(this);
            this.field_151513_e = StatList.func_151176_b(this);
        }
    }
}
