package net.minecraft.stats;

import net.minecraft.item.crafting.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class StatList
{
    public static /* synthetic */ StatBase distanceByBoatStat;
    public static final /* synthetic */ StatBase[] objectBreakStats;
    public static /* synthetic */ StatBase distanceFallenStat;
    public static /* synthetic */ List allStats;
    public static /* synthetic */ StatBase timeSinceDeathStat;
    public static /* synthetic */ StatBase distanceCrouchedStat;
    public static /* synthetic */ StatBase deathsStat;
    public static /* synthetic */ StatBase playerKillsStat;
    public static /* synthetic */ StatBase minutesPlayedStat;
    public static final /* synthetic */ StatBase[] mineBlockStatArray;
    public static /* synthetic */ StatBase damageDealtStat;
    public static /* synthetic */ StatBase distanceByHorseStat;
    public static /* synthetic */ StatBase dropStat;
    public static /* synthetic */ List itemStats;
    protected static /* synthetic */ Map oneShotStats;
    public static /* synthetic */ StatBase damageTakenStat;
    public static /* synthetic */ StatBase timesTalkedToVillagerStat;
    public static /* synthetic */ StatBase treasureFishedStat;
    public static /* synthetic */ StatBase leaveGameStat;
    public static /* synthetic */ StatBase distanceSprintedStat;
    public static /* synthetic */ StatBase fishCaughtStat;
    public static /* synthetic */ StatBase distanceFlownStat;
    public static /* synthetic */ StatBase junkFishedStat;
    public static /* synthetic */ StatBase distanceDoveStat;
    public static /* synthetic */ StatBase jumpStat;
    public static /* synthetic */ StatBase distanceWalkedStat;
    public static final /* synthetic */ StatBase[] objectUseStats;
    public static final /* synthetic */ StatBase[] objectCraftStats;
    public static /* synthetic */ StatBase animalsBredStat;
    public static /* synthetic */ StatBase distanceByMinecartStat;
    public static /* synthetic */ List objectMineStats;
    public static /* synthetic */ StatBase mobKillsStat;
    public static /* synthetic */ List generalStats;
    public static /* synthetic */ StatBase distanceByPigStat;
    public static /* synthetic */ StatBase distanceClimbedStat;
    public static /* synthetic */ StatBase distanceSwumStat;
    public static /* synthetic */ StatBase timesTradedWithVillagerStat;
    
    private static void initCraftableStats() {
        final HashSet lllllllllllllllllIlIIllIlIlIllll = Sets.newHashSet();
        for (final IRecipe lllllllllllllllllIlIIllIlIlIllII : CraftingManager.getInstance().getRecipeList()) {
            if (lllllllllllllllllIlIIllIlIlIllII.getRecipeOutput() != null) {
                lllllllllllllllllIlIIllIlIlIllll.add(lllllllllllllllllIlIIllIlIlIllII.getRecipeOutput().getItem());
            }
        }
        for (final ItemStack lllllllllllllllllIlIIllIlIlIlIll : FurnaceRecipes.instance().getSmeltingList().values()) {
            lllllllllllllllllIlIIllIlIlIllll.add(lllllllllllllllllIlIIllIlIlIlIll.getItem());
        }
        for (final Item lllllllllllllllllIlIIllIlIlIlIlI : lllllllllllllllllIlIIllIlIlIllll) {
            if (lllllllllllllllllIlIIllIlIlIlIlI != null) {
                final int lllllllllllllllllIlIIllIlIlIlIIl = Item.getIdFromItem(lllllllllllllllllIlIIllIlIlIlIlI);
                final String lllllllllllllllllIlIIllIlIlIlIII = func_180204_a(lllllllllllllllllIlIIllIlIlIlIlI);
                if (lllllllllllllllllIlIIllIlIlIlIII == null) {
                    continue;
                }
                StatList.objectCraftStats[lllllllllllllllllIlIIllIlIlIlIIl] = new StatCrafting("stat.craftItem.", lllllllllllllllllIlIIllIlIlIlIII, new ChatComponentTranslation("stat.craftItem", new Object[] { new ItemStack(lllllllllllllllllIlIIllIlIlIlIlI).getChatComponent() }), lllllllllllllllllIlIIllIlIlIlIlI).registerStat();
            }
        }
        replaceAllSimilarBlocks(StatList.objectCraftStats);
    }
    
    private static String func_180204_a(final Item lllllllllllllllllIlIIllIIllIlIlI) {
        final ResourceLocation lllllllllllllllllIlIIllIIllIlIll = (ResourceLocation)Item.itemRegistry.getNameForObject(lllllllllllllllllIlIIllIIllIlIlI);
        return (lllllllllllllllllIlIIllIIllIlIll != null) ? lllllllllllllllllIlIIllIIllIlIll.toString().replace(':', '.') : null;
    }
    
    private static void func_151180_a(final StatBase[] lllllllllllllllllIlIIllIIlIllIll, final Block lllllllllllllllllIlIIllIIlIlllll, final Block lllllllllllllllllIlIIllIIlIllIIl) {
        final int lllllllllllllllllIlIIllIIlIlllIl = Block.getIdFromBlock(lllllllllllllllllIlIIllIIlIlllll);
        final int lllllllllllllllllIlIIllIIlIlllII = Block.getIdFromBlock(lllllllllllllllllIlIIllIIlIllIIl);
        if (lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllIl] != null && lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllII] == null) {
            lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllII] = lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllIl];
        }
        else {
            StatList.allStats.remove(lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllIl]);
            StatList.objectMineStats.remove(lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllIl]);
            StatList.generalStats.remove(lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllIl]);
            lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllIl] = lllllllllllllllllIlIIllIIlIllIll[lllllllllllllllllIlIIllIIlIlllII];
        }
    }
    
    private static void func_151181_c() {
        for (final Block lllllllllllllllllIlIIllIlIIIllll : Block.blockRegistry) {
            final Item lllllllllllllllllIlIIllIlIIIlllI = Item.getItemFromBlock(lllllllllllllllllIlIIllIlIIIllll);
            if (lllllllllllllllllIlIIllIlIIIlllI != null) {
                final int lllllllllllllllllIlIIllIlIIIllIl = Block.getIdFromBlock(lllllllllllllllllIlIIllIlIIIllll);
                final String lllllllllllllllllIlIIllIlIIIllII = func_180204_a(lllllllllllllllllIlIIllIlIIIlllI);
                if (lllllllllllllllllIlIIllIlIIIllII == null || !lllllllllllllllllIlIIllIlIIIllll.getEnableStats()) {
                    continue;
                }
                StatList.mineBlockStatArray[lllllllllllllllllIlIIllIlIIIllIl] = new StatCrafting("stat.mineBlock.", lllllllllllllllllIlIIllIlIIIllII, new ChatComponentTranslation("stat.mineBlock", new Object[] { new ItemStack(lllllllllllllllllIlIIllIlIIIllll).getChatComponent() }), lllllllllllllllllIlIIllIlIIIlllI).registerStat();
                StatList.objectMineStats.add(StatList.mineBlockStatArray[lllllllllllllllllIlIIllIlIIIllIl]);
            }
        }
        replaceAllSimilarBlocks(StatList.mineBlockStatArray);
    }
    
    public static StatBase func_151176_b(final EntityList.EntityEggInfo lllllllllllllllllIlIIllIIlIIlllI) {
        final String lllllllllllllllllIlIIllIIlIIllIl = EntityList.getStringFromID(lllllllllllllllllIlIIllIIlIIlllI.spawnedID);
        return (lllllllllllllllllIlIIllIIlIIllIl == null) ? null : new StatBase(String.valueOf(new StringBuilder("stat.entityKilledBy.").append(lllllllllllllllllIlIIllIIlIIllIl)), new ChatComponentTranslation("stat.entityKilledBy", new Object[] { new ChatComponentTranslation(String.valueOf(new StringBuilder("entity.").append(lllllllllllllllllIlIIllIIlIIllIl).append(".name")), new Object[0]) })).registerStat();
    }
    
    static {
        __OBFID = "CL_00001480";
        StatList.oneShotStats = Maps.newHashMap();
        StatList.allStats = Lists.newArrayList();
        StatList.generalStats = Lists.newArrayList();
        StatList.itemStats = Lists.newArrayList();
        StatList.objectMineStats = Lists.newArrayList();
        StatList.leaveGameStat = new StatBasic("stat.leaveGame", new ChatComponentTranslation("stat.leaveGame", new Object[0])).initIndependentStat().registerStat();
        StatList.minutesPlayedStat = new StatBasic("stat.playOneMinute", new ChatComponentTranslation("stat.playOneMinute", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
        StatList.timeSinceDeathStat = new StatBasic("stat.timeSinceDeath", new ChatComponentTranslation("stat.timeSinceDeath", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
        StatList.distanceWalkedStat = new StatBasic("stat.walkOneCm", new ChatComponentTranslation("stat.walkOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceCrouchedStat = new StatBasic("stat.crouchOneCm", new ChatComponentTranslation("stat.crouchOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceSprintedStat = new StatBasic("stat.sprintOneCm", new ChatComponentTranslation("stat.sprintOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceSwumStat = new StatBasic("stat.swimOneCm", new ChatComponentTranslation("stat.swimOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceFallenStat = new StatBasic("stat.fallOneCm", new ChatComponentTranslation("stat.fallOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceClimbedStat = new StatBasic("stat.climbOneCm", new ChatComponentTranslation("stat.climbOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceFlownStat = new StatBasic("stat.flyOneCm", new ChatComponentTranslation("stat.flyOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceDoveStat = new StatBasic("stat.diveOneCm", new ChatComponentTranslation("stat.diveOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceByMinecartStat = new StatBasic("stat.minecartOneCm", new ChatComponentTranslation("stat.minecartOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceByBoatStat = new StatBasic("stat.boatOneCm", new ChatComponentTranslation("stat.boatOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceByPigStat = new StatBasic("stat.pigOneCm", new ChatComponentTranslation("stat.pigOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.distanceByHorseStat = new StatBasic("stat.horseOneCm", new ChatComponentTranslation("stat.horseOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        StatList.jumpStat = new StatBasic("stat.jump", new ChatComponentTranslation("stat.jump", new Object[0])).initIndependentStat().registerStat();
        StatList.dropStat = new StatBasic("stat.drop", new ChatComponentTranslation("stat.drop", new Object[0])).initIndependentStat().registerStat();
        StatList.damageDealtStat = new StatBasic("stat.damageDealt", new ChatComponentTranslation("stat.damageDealt", new Object[0]), StatBase.field_111202_k).registerStat();
        StatList.damageTakenStat = new StatBasic("stat.damageTaken", new ChatComponentTranslation("stat.damageTaken", new Object[0]), StatBase.field_111202_k).registerStat();
        StatList.deathsStat = new StatBasic("stat.deaths", new ChatComponentTranslation("stat.deaths", new Object[0])).registerStat();
        StatList.mobKillsStat = new StatBasic("stat.mobKills", new ChatComponentTranslation("stat.mobKills", new Object[0])).registerStat();
        StatList.animalsBredStat = new StatBasic("stat.animalsBred", new ChatComponentTranslation("stat.animalsBred", new Object[0])).registerStat();
        StatList.playerKillsStat = new StatBasic("stat.playerKills", new ChatComponentTranslation("stat.playerKills", new Object[0])).registerStat();
        StatList.fishCaughtStat = new StatBasic("stat.fishCaught", new ChatComponentTranslation("stat.fishCaught", new Object[0])).registerStat();
        StatList.junkFishedStat = new StatBasic("stat.junkFished", new ChatComponentTranslation("stat.junkFished", new Object[0])).registerStat();
        StatList.treasureFishedStat = new StatBasic("stat.treasureFished", new ChatComponentTranslation("stat.treasureFished", new Object[0])).registerStat();
        StatList.timesTalkedToVillagerStat = new StatBasic("stat.talkedToVillager", new ChatComponentTranslation("stat.talkedToVillager", new Object[0])).registerStat();
        StatList.timesTradedWithVillagerStat = new StatBasic("stat.tradedWithVillager", new ChatComponentTranslation("stat.tradedWithVillager", new Object[0])).registerStat();
        mineBlockStatArray = new StatBase[4096];
        objectCraftStats = new StatBase[32000];
        objectUseStats = new StatBase[32000];
        objectBreakStats = new StatBase[32000];
    }
    
    public static StatBase getOneShotStat(final String lllllllllllllllllIlIIllIIlIIlIII) {
        return StatList.oneShotStats.get(lllllllllllllllllIlIIllIIlIIlIII);
    }
    
    public static void func_151178_a() {
        func_151181_c();
        initStats();
        func_151179_e();
        initCraftableStats();
        AchievementList.init();
        EntityList.func_151514_a();
    }
    
    private static void replaceAllSimilarBlocks(final StatBase[] lllllllllllllllllIlIIllIIllIIllI) {
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.water, Blocks.flowing_water);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.lava, Blocks.flowing_lava);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.lit_pumpkin, Blocks.pumpkin);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.lit_furnace, Blocks.furnace);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.lit_redstone_ore, Blocks.redstone_ore);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.powered_repeater, Blocks.unpowered_repeater);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.powered_comparator, Blocks.unpowered_comparator);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.redstone_torch, Blocks.unlit_redstone_torch);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.lit_redstone_lamp, Blocks.redstone_lamp);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.double_stone_slab, Blocks.stone_slab);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.double_wooden_slab, Blocks.wooden_slab);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.double_stone_slab2, Blocks.stone_slab2);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.grass, Blocks.dirt);
        func_151180_a(lllllllllllllllllIlIIllIIllIIllI, Blocks.farmland, Blocks.dirt);
    }
    
    private static void initStats() {
        for (final Item lllllllllllllllllIlIIllIlIIIIIIl : Item.itemRegistry) {
            if (lllllllllllllllllIlIIllIlIIIIIIl != null) {
                final int lllllllllllllllllIlIIllIlIIIIIII = Item.getIdFromItem(lllllllllllllllllIlIIllIlIIIIIIl);
                final String lllllllllllllllllIlIIllIIlllllll = func_180204_a(lllllllllllllllllIlIIllIlIIIIIIl);
                if (lllllllllllllllllIlIIllIIlllllll == null) {
                    continue;
                }
                StatList.objectUseStats[lllllllllllllllllIlIIllIlIIIIIII] = new StatCrafting("stat.useItem.", lllllllllllllllllIlIIllIIlllllll, new ChatComponentTranslation("stat.useItem", new Object[] { new ItemStack(lllllllllllllllllIlIIllIlIIIIIIl).getChatComponent() }), lllllllllllllllllIlIIllIlIIIIIIl).registerStat();
                if (lllllllllllllllllIlIIllIlIIIIIIl instanceof ItemBlock) {
                    continue;
                }
                StatList.itemStats.add(StatList.objectUseStats[lllllllllllllllllIlIIllIlIIIIIII]);
            }
        }
        replaceAllSimilarBlocks(StatList.objectUseStats);
    }
    
    private static void func_151179_e() {
        for (final Item lllllllllllllllllIlIIllIIlllIlIl : Item.itemRegistry) {
            if (lllllllllllllllllIlIIllIIlllIlIl != null) {
                final int lllllllllllllllllIlIIllIIlllIlII = Item.getIdFromItem(lllllllllllllllllIlIIllIIlllIlIl);
                final String lllllllllllllllllIlIIllIIlllIIll = func_180204_a(lllllllllllllllllIlIIllIIlllIlIl);
                if (lllllllllllllllllIlIIllIIlllIIll == null || !lllllllllllllllllIlIIllIIlllIlIl.isDamageable()) {
                    continue;
                }
                StatList.objectBreakStats[lllllllllllllllllIlIIllIIlllIlII] = new StatCrafting("stat.breakItem.", lllllllllllllllllIlIIllIIlllIIll, new ChatComponentTranslation("stat.breakItem", new Object[] { new ItemStack(lllllllllllllllllIlIIllIIlllIlIl).getChatComponent() }), lllllllllllllllllIlIIllIIlllIlIl).registerStat();
            }
        }
        replaceAllSimilarBlocks(StatList.objectBreakStats);
    }
    
    public static StatBase func_151182_a(final EntityList.EntityEggInfo lllllllllllllllllIlIIllIIlIlIlII) {
        final String lllllllllllllllllIlIIllIIlIlIIll = EntityList.getStringFromID(lllllllllllllllllIlIIllIIlIlIlII.spawnedID);
        return (lllllllllllllllllIlIIllIIlIlIIll == null) ? null : new StatBase(String.valueOf(new StringBuilder("stat.killEntity.").append(lllllllllllllllllIlIIllIIlIlIIll)), new ChatComponentTranslation("stat.entityKill", new Object[] { new ChatComponentTranslation(String.valueOf(new StringBuilder("entity.").append(lllllllllllllllllIlIIllIIlIlIIll).append(".name")), new Object[0]) })).registerStat();
    }
}
