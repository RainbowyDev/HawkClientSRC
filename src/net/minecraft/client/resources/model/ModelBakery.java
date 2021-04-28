package net.minecraft.client.resources.model;

import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;
import com.google.common.base.*;
import net.minecraft.client.resources.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.block.model.*;
import org.apache.commons.io.*;
import java.io.*;

public class ModelBakery
{
    private static final /* synthetic */ ModelBlock MODEL_GENERATED;
    private final /* synthetic */ Map models;
    private static final /* synthetic */ Joiner field_177601_e;
    private static final /* synthetic */ ModelBlock MODEL_CLOCK;
    private final /* synthetic */ TextureMap textureMap;
    private static final /* synthetic */ Set field_177602_b;
    private /* synthetic */ Map itemLocations;
    protected static final /* synthetic */ ModelResourceLocation MODEL_MISSING;
    private final /* synthetic */ BlockModelShapes blockModelShapes;
    private final /* synthetic */ IResourceManager resourceManager;
    private /* synthetic */ RegistrySimple bakedRegistry;
    private static final /* synthetic */ ModelBlock MODEL_COMPASS;
    private static final /* synthetic */ ModelBlock MODEL_ENTITY;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Map field_177614_t;
    private final /* synthetic */ Map variants;
    private /* synthetic */ Map variantNames;
    private static final /* synthetic */ Map BUILT_IN_MODELS;
    private final /* synthetic */ Map field_177599_g;
    private final /* synthetic */ FaceBakery field_177607_l;
    private final /* synthetic */ ItemModelGenerator itemModelGenerator;
    
    private void registerVariant(final ModelBlockDefinition llllllllllllllIlIIlIlIIIIIIllIII, final ModelResourceLocation llllllllllllllIlIIlIlIIIIIIlIlll) {
        this.variants.put(llllllllllllllIlIIlIlIIIIIIlIlll, llllllllllllllIlIIlIlIIIIIIllIII.func_178330_b(llllllllllllllIlIIlIlIIIIIIlIlll.func_177518_c()));
    }
    
    private List func_177573_e(final ResourceLocation llllllllllllllIlIIlIIllIllIlllIl) {
        final ArrayList llllllllllllllIlIIlIIllIllIlllII = Lists.newArrayList((Object[])new ResourceLocation[] { llllllllllllllIlIIlIIllIllIlllIl });
        ResourceLocation llllllllllllllIlIIlIIllIllIllIll = llllllllllllllIlIIlIIllIllIlllIl;
        while ((llllllllllllllIlIIlIIllIllIllIll = this.func_177576_f(llllllllllllllIlIIlIIllIllIllIll)) != null) {
            llllllllllllllIlIIlIIllIllIlllII.add(0, llllllllllllllIlIIlIIllIllIllIll);
        }
        return llllllllllllllIlIIlIIllIllIlllII;
    }
    
    private ResourceLocation getBlockStateLocation(final ResourceLocation llllllllllllllIlIIlIIlllllllIlII) {
        return new ResourceLocation(llllllllllllllIlIIlIIlllllllIlII.getResourceDomain(), String.valueOf(new StringBuilder("blockstates/").append(llllllllllllllIlIIlIIlllllllIlII.getResourcePath()).append(".json")));
    }
    
    private void func_177595_c() {
        for (final ModelResourceLocation llllllllllllllIlIIlIIllllllIlIlI : this.variants.keySet()) {
            for (final ModelBlockDefinition.Variant llllllllllllllIlIIlIIllllllIlIII : this.variants.get(llllllllllllllIlIIlIIllllllIlIlI).getVariants()) {
                final ResourceLocation llllllllllllllIlIIlIIllllllIIlll = llllllllllllllIlIIlIIllllllIlIII.getModelLocation();
                if (this.models.get(llllllllllllllIlIIlIIllllllIIlll) == null) {
                    try {
                        final ModelBlock llllllllllllllIlIIlIIllllllIIllI = this.loadModel(llllllllllllllIlIIlIIllllllIIlll);
                        this.models.put(llllllllllllllIlIIlIIllllllIIlll, llllllllllllllIlIIlIIllllllIIllI);
                    }
                    catch (Exception llllllllllllllIlIIlIIllllllIIlIl) {
                        ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Unable to load block model: '").append(llllllllllllllIlIIlIIllllllIIlll).append("' for variant: '").append(llllllllllllllIlIIlIIllllllIlIlI).append("'")), (Throwable)llllllllllllllIlIIlIIllllllIIlIl);
                    }
                }
            }
        }
    }
    
    private boolean func_177581_b(final ModelBlock llllllllllllllIlIIlIIllIlIIIIIII) {
        if (llllllllllllllIlIIlIIllIlIIIIIII == null) {
            return false;
        }
        final ModelBlock llllllllllllllIlIIlIIllIlIIIIIIl = llllllllllllllIlIIlIIllIlIIIIIII.getRootModel();
        return llllllllllllllIlIIlIIllIlIIIIIIl == ModelBakery.MODEL_GENERATED || llllllllllllllIlIIlIIllIlIIIIIIl == ModelBakery.MODEL_COMPASS || llllllllllllllIlIIlIIllIlIIIIIIl == ModelBakery.MODEL_CLOCK;
    }
    
    private void func_177577_b() {
        this.loadVariants(this.blockModelShapes.getBlockStateMapper().func_178446_a().values());
        this.variants.put(ModelBakery.MODEL_MISSING, new ModelBlockDefinition.Variants(ModelBakery.MODEL_MISSING.func_177518_c(), Lists.newArrayList((Object[])new ModelBlockDefinition.Variant[] { new ModelBlockDefinition.Variant(new ResourceLocation(ModelBakery.MODEL_MISSING.getResourcePath()), ModelRotation.X0_Y0, false, 1) })));
        final ResourceLocation llllllllllllllIlIIlIlIIIIIllIlll = new ResourceLocation("item_frame");
        final ModelBlockDefinition llllllllllllllIlIIlIlIIIIIllIllI = this.getModelBlockDefinition(llllllllllllllIlIIlIlIIIIIllIlll);
        this.registerVariant(llllllllllllllIlIIlIlIIIIIllIllI, new ModelResourceLocation(llllllllllllllIlIIlIlIIIIIllIlll, "normal"));
        this.registerVariant(llllllllllllllIlIIlIlIIIIIllIllI, new ModelResourceLocation(llllllllllllllIlIIlIlIIIIIllIlll, "map"));
        this.func_177595_c();
        this.loadItemModels();
    }
    
    public ModelBakery(final IResourceManager llllllllllllllIlIIlIlIIIIlIIIIIl, final TextureMap llllllllllllllIlIIlIlIIIIlIIIlII, final BlockModelShapes llllllllllllllIlIIlIlIIIIlIIIIll) {
        this.field_177599_g = Maps.newHashMap();
        this.models = Maps.newLinkedHashMap();
        this.variants = Maps.newLinkedHashMap();
        this.field_177607_l = new FaceBakery();
        this.itemModelGenerator = new ItemModelGenerator();
        this.bakedRegistry = new RegistrySimple();
        this.itemLocations = Maps.newLinkedHashMap();
        this.field_177614_t = Maps.newHashMap();
        this.variantNames = Maps.newIdentityHashMap();
        this.resourceManager = llllllllllllllIlIIlIlIIIIlIIIIIl;
        this.textureMap = llllllllllllllIlIIlIlIIIIlIIIlII;
        this.blockModelShapes = llllllllllllllIlIIlIlIIIIlIIIIll;
    }
    
    static {
        __OBFID = "CL_00002391";
        field_177602_b = Sets.newHashSet((Object[])new ResourceLocation[] { new ResourceLocation("blocks/water_flow"), new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/lava_flow"), new ResourceLocation("blocks/lava_still"), new ResourceLocation("blocks/destroy_stage_0"), new ResourceLocation("blocks/destroy_stage_1"), new ResourceLocation("blocks/destroy_stage_2"), new ResourceLocation("blocks/destroy_stage_3"), new ResourceLocation("blocks/destroy_stage_4"), new ResourceLocation("blocks/destroy_stage_5"), new ResourceLocation("blocks/destroy_stage_6"), new ResourceLocation("blocks/destroy_stage_7"), new ResourceLocation("blocks/destroy_stage_8"), new ResourceLocation("blocks/destroy_stage_9"), new ResourceLocation("items/empty_armor_slot_helmet"), new ResourceLocation("items/empty_armor_slot_chestplate"), new ResourceLocation("items/empty_armor_slot_leggings"), new ResourceLocation("items/empty_armor_slot_boots") });
        LOGGER = LogManager.getLogger();
        MODEL_MISSING = new ModelResourceLocation("builtin/missing", "missing");
        (BUILT_IN_MODELS = Maps.newHashMap()).put("missing", "{ \"textures\": {   \"particle\": \"missingno\",   \"missingno\": \"missingno\"}, \"elements\": [ {     \"from\": [ 0, 0, 0 ],     \"to\": [ 16, 16, 16 ],     \"faces\": {         \"down\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"down\", \"texture\": \"#missingno\" },         \"up\":    { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"up\", \"texture\": \"#missingno\" },         \"north\": { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"north\", \"texture\": \"#missingno\" },         \"south\": { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"south\", \"texture\": \"#missingno\" },         \"west\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"west\", \"texture\": \"#missingno\" },         \"east\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"east\", \"texture\": \"#missingno\" }    }}]}");
        field_177601_e = Joiner.on(" -> ");
        MODEL_GENERATED = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
        MODEL_COMPASS = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
        MODEL_CLOCK = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
        MODEL_ENTITY = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
        ModelBakery.MODEL_GENERATED.field_178317_b = "generation marker";
        ModelBakery.MODEL_COMPASS.field_178317_b = "compass generation marker";
        ModelBakery.MODEL_CLOCK.field_178317_b = "class generation marker";
        ModelBakery.MODEL_ENTITY.field_178317_b = "block entity marker";
    }
    
    private ModelBlock loadModel(final ResourceLocation llllllllllllllIlIIlIIlllllIIlIlI) throws IOException {
        final String llllllllllllllIlIIlIIlllllIlIlII = llllllllllllllIlIIlIIlllllIIlIlI.getResourcePath();
        if ("builtin/generated".equals(llllllllllllllIlIIlIIlllllIlIlII)) {
            return ModelBakery.MODEL_GENERATED;
        }
        if ("builtin/compass".equals(llllllllllllllIlIIlIIlllllIlIlII)) {
            return ModelBakery.MODEL_COMPASS;
        }
        if ("builtin/clock".equals(llllllllllllllIlIIlIIlllllIlIlII)) {
            return ModelBakery.MODEL_CLOCK;
        }
        if ("builtin/entity".equals(llllllllllllllIlIIlIIlllllIlIlII)) {
            return ModelBakery.MODEL_ENTITY;
        }
        Object llllllllllllllIlIIlIIlllllIlIIlI;
        if (llllllllllllllIlIIlIIlllllIlIlII.startsWith("builtin/")) {
            final String llllllllllllllIlIIlIIlllllIlIIIl = llllllllllllllIlIIlIIlllllIlIlII.substring("builtin/".length());
            final String llllllllllllllIlIIlIIlllllIlIIII = ModelBakery.BUILT_IN_MODELS.get(llllllllllllllIlIIlIIlllllIlIIIl);
            if (llllllllllllllIlIIlIIlllllIlIIII == null) {
                throw new FileNotFoundException(llllllllllllllIlIIlIIlllllIIlIlI.toString());
            }
            final Object llllllllllllllIlIIlIIlllllIlIIll = new StringReader(llllllllllllllIlIIlIIlllllIlIIII);
        }
        else {
            final IResource llllllllllllllIlIIlIIlllllIIllll = this.resourceManager.getResource(this.getModelLocation(llllllllllllllIlIIlIIlllllIIlIlI));
            llllllllllllllIlIIlIIlllllIlIIlI = new InputStreamReader(llllllllllllllIlIIlIIlllllIIllll.getInputStream(), Charsets.UTF_8);
        }
        try {
            final ModelBlock llllllllllllllIlIIlIIlllllIIllII = ModelBlock.deserialize((Reader)llllllllllllllIlIIlIIlllllIlIIlI);
            llllllllllllllIlIIlIIlllllIIllII.field_178317_b = llllllllllllllIlIIlIIlllllIIlIlI.toString();
            final ModelBlock llllllllllllllIlIIlIIlllllIIlllI = llllllllllllllIlIIlIIlllllIIllII;
        }
        finally {
            ((Reader)llllllllllllllIlIIlIIlllllIlIIlI).close();
        }
        ((Reader)llllllllllllllIlIIlIIlllllIlIIlI).close();
        final ModelBlock llllllllllllllIlIIlIIlllllIIllIl;
        return llllllllllllllIlIIlIIlllllIIllIl;
    }
    
    private ResourceLocation getItemLocation(final String llllllllllllllIlIIlIIlllIlllIlll) {
        final ResourceLocation llllllllllllllIlIIlIIlllIlllIllI = new ResourceLocation(llllllllllllllIlIIlIIlllIlllIlll);
        return new ResourceLocation(llllllllllllllIlIIlIIlllIlllIllI.getResourceDomain(), String.valueOf(new StringBuilder("item/").append(llllllllllllllIlIIlIIlllIlllIllI.getResourcePath())));
    }
    
    private void registerVariantNames() {
        this.variantNames.put(Item.getItemFromBlock(Blocks.stone), Lists.newArrayList((Object[])new String[] { "stone", "granite", "granite_smooth", "diorite", "diorite_smooth", "andesite", "andesite_smooth" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.dirt), Lists.newArrayList((Object[])new String[] { "dirt", "coarse_dirt", "podzol" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.planks), Lists.newArrayList((Object[])new String[] { "oak_planks", "spruce_planks", "birch_planks", "jungle_planks", "acacia_planks", "dark_oak_planks" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.sapling), Lists.newArrayList((Object[])new String[] { "oak_sapling", "spruce_sapling", "birch_sapling", "jungle_sapling", "acacia_sapling", "dark_oak_sapling" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.sand), Lists.newArrayList((Object[])new String[] { "sand", "red_sand" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.log), Lists.newArrayList((Object[])new String[] { "oak_log", "spruce_log", "birch_log", "jungle_log" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.leaves), Lists.newArrayList((Object[])new String[] { "oak_leaves", "spruce_leaves", "birch_leaves", "jungle_leaves" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.sponge), Lists.newArrayList((Object[])new String[] { "sponge", "sponge_wet" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.sandstone), Lists.newArrayList((Object[])new String[] { "sandstone", "chiseled_sandstone", "smooth_sandstone" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.red_sandstone), Lists.newArrayList((Object[])new String[] { "red_sandstone", "chiseled_red_sandstone", "smooth_red_sandstone" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.tallgrass), Lists.newArrayList((Object[])new String[] { "dead_bush", "tall_grass", "fern" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.deadbush), Lists.newArrayList((Object[])new String[] { "dead_bush" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.wool), Lists.newArrayList((Object[])new String[] { "black_wool", "red_wool", "green_wool", "brown_wool", "blue_wool", "purple_wool", "cyan_wool", "silver_wool", "gray_wool", "pink_wool", "lime_wool", "yellow_wool", "light_blue_wool", "magenta_wool", "orange_wool", "white_wool" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.yellow_flower), Lists.newArrayList((Object[])new String[] { "dandelion" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.red_flower), Lists.newArrayList((Object[])new String[] { "poppy", "blue_orchid", "allium", "houstonia", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stone_slab), Lists.newArrayList((Object[])new String[] { "stone_slab", "sandstone_slab", "cobblestone_slab", "brick_slab", "stone_brick_slab", "nether_brick_slab", "quartz_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stone_slab2), Lists.newArrayList((Object[])new String[] { "red_sandstone_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stained_glass), Lists.newArrayList((Object[])new String[] { "black_stained_glass", "red_stained_glass", "green_stained_glass", "brown_stained_glass", "blue_stained_glass", "purple_stained_glass", "cyan_stained_glass", "silver_stained_glass", "gray_stained_glass", "pink_stained_glass", "lime_stained_glass", "yellow_stained_glass", "light_blue_stained_glass", "magenta_stained_glass", "orange_stained_glass", "white_stained_glass" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.monster_egg), Lists.newArrayList((Object[])new String[] { "stone_monster_egg", "cobblestone_monster_egg", "stone_brick_monster_egg", "mossy_brick_monster_egg", "cracked_brick_monster_egg", "chiseled_brick_monster_egg" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stonebrick), Lists.newArrayList((Object[])new String[] { "stonebrick", "mossy_stonebrick", "cracked_stonebrick", "chiseled_stonebrick" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.wooden_slab), Lists.newArrayList((Object[])new String[] { "oak_slab", "spruce_slab", "birch_slab", "jungle_slab", "acacia_slab", "dark_oak_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.cobblestone_wall), Lists.newArrayList((Object[])new String[] { "cobblestone_wall", "mossy_cobblestone_wall" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.anvil), Lists.newArrayList((Object[])new String[] { "anvil_intact", "anvil_slightly_damaged", "anvil_very_damaged" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.quartz_block), Lists.newArrayList((Object[])new String[] { "quartz_block", "chiseled_quartz_block", "quartz_column" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stained_hardened_clay), Lists.newArrayList((Object[])new String[] { "black_stained_hardened_clay", "red_stained_hardened_clay", "green_stained_hardened_clay", "brown_stained_hardened_clay", "blue_stained_hardened_clay", "purple_stained_hardened_clay", "cyan_stained_hardened_clay", "silver_stained_hardened_clay", "gray_stained_hardened_clay", "pink_stained_hardened_clay", "lime_stained_hardened_clay", "yellow_stained_hardened_clay", "light_blue_stained_hardened_clay", "magenta_stained_hardened_clay", "orange_stained_hardened_clay", "white_stained_hardened_clay" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stained_glass_pane), Lists.newArrayList((Object[])new String[] { "black_stained_glass_pane", "red_stained_glass_pane", "green_stained_glass_pane", "brown_stained_glass_pane", "blue_stained_glass_pane", "purple_stained_glass_pane", "cyan_stained_glass_pane", "silver_stained_glass_pane", "gray_stained_glass_pane", "pink_stained_glass_pane", "lime_stained_glass_pane", "yellow_stained_glass_pane", "light_blue_stained_glass_pane", "magenta_stained_glass_pane", "orange_stained_glass_pane", "white_stained_glass_pane" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.leaves2), Lists.newArrayList((Object[])new String[] { "acacia_leaves", "dark_oak_leaves" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.log2), Lists.newArrayList((Object[])new String[] { "acacia_log", "dark_oak_log" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.prismarine), Lists.newArrayList((Object[])new String[] { "prismarine", "prismarine_bricks", "dark_prismarine" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.carpet), Lists.newArrayList((Object[])new String[] { "black_carpet", "red_carpet", "green_carpet", "brown_carpet", "blue_carpet", "purple_carpet", "cyan_carpet", "silver_carpet", "gray_carpet", "pink_carpet", "lime_carpet", "yellow_carpet", "light_blue_carpet", "magenta_carpet", "orange_carpet", "white_carpet" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.double_plant), Lists.newArrayList((Object[])new String[] { "sunflower", "syringa", "double_grass", "double_fern", "double_rose", "paeonia" }));
        this.variantNames.put(Items.bow, Lists.newArrayList((Object[])new String[] { "bow", "bow_pulling_0", "bow_pulling_1", "bow_pulling_2" }));
        this.variantNames.put(Items.coal, Lists.newArrayList((Object[])new String[] { "coal", "charcoal" }));
        this.variantNames.put(Items.fishing_rod, Lists.newArrayList((Object[])new String[] { "fishing_rod", "fishing_rod_cast" }));
        this.variantNames.put(Items.fish, Lists.newArrayList((Object[])new String[] { "cod", "salmon", "clownfish", "pufferfish" }));
        this.variantNames.put(Items.cooked_fish, Lists.newArrayList((Object[])new String[] { "cooked_cod", "cooked_salmon" }));
        this.variantNames.put(Items.dye, Lists.newArrayList((Object[])new String[] { "dye_black", "dye_red", "dye_green", "dye_brown", "dye_blue", "dye_purple", "dye_cyan", "dye_silver", "dye_gray", "dye_pink", "dye_lime", "dye_yellow", "dye_light_blue", "dye_magenta", "dye_orange", "dye_white" }));
        this.variantNames.put(Items.potionitem, Lists.newArrayList((Object[])new String[] { "bottle_drinkable", "bottle_splash" }));
        this.variantNames.put(Items.skull, Lists.newArrayList((Object[])new String[] { "skull_skeleton", "skull_wither", "skull_zombie", "skull_char", "skull_creeper" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.oak_fence_gate), Lists.newArrayList((Object[])new String[] { "oak_fence_gate" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.oak_fence), Lists.newArrayList((Object[])new String[] { "oak_fence" }));
        this.variantNames.put(Items.oak_door, Lists.newArrayList((Object[])new String[] { "oak_door" }));
    }
    
    private void func_177597_h() {
        this.func_177574_i();
        for (final ModelBlock llllllllllllllIlIIlIIllIlllllllI : this.models.values()) {
            llllllllllllllIlIIlIIllIlllllllI.getParentFromMap(this.models);
        }
        ModelBlock.func_178312_b(this.models);
    }
    
    private void func_177574_i() {
        final ArrayDeque llllllllllllllIlIIlIIllIllllIIlI = Queues.newArrayDeque();
        final HashSet llllllllllllllIlIIlIIllIllllIIIl = Sets.newHashSet();
        for (final ResourceLocation llllllllllllllIlIIlIIllIlllIllIl : this.models.keySet()) {
            llllllllllllllIlIIlIIllIllllIIIl.add(llllllllllllllIlIIlIIllIlllIllIl);
            final ResourceLocation llllllllllllllIlIIlIIllIlllIllll = this.models.get(llllllllllllllIlIIlIIllIlllIllIl).getParentLocation();
            if (llllllllllllllIlIIlIIllIlllIllll != null) {
                llllllllllllllIlIIlIIllIllllIIlI.add(llllllllllllllIlIIlIIllIlllIllll);
            }
        }
        while (!llllllllllllllIlIIlIIllIllllIIlI.isEmpty()) {
            final ResourceLocation llllllllllllllIlIIlIIllIlllIllII = llllllllllllllIlIIlIIllIllllIIlI.pop();
            try {
                if (this.models.get(llllllllllllllIlIIlIIllIlllIllII) != null) {
                    continue;
                }
                final ModelBlock llllllllllllllIlIIlIIllIlllIlIll = this.loadModel(llllllllllllllIlIIlIIllIlllIllII);
                this.models.put(llllllllllllllIlIIlIIllIlllIllII, llllllllllllllIlIIlIIllIlllIlIll);
                final ResourceLocation llllllllllllllIlIIlIIllIlllIlllI = llllllllllllllIlIIlIIllIlllIlIll.getParentLocation();
                if (llllllllllllllIlIIlIIllIlllIlllI != null && !llllllllllllllIlIIlIIllIllllIIIl.contains(llllllllllllllIlIIlIIllIlllIlllI)) {
                    llllllllllllllIlIIlIIllIllllIIlI.add(llllllllllllllIlIIlIIllIlllIlllI);
                }
            }
            catch (Exception llllllllllllllIlIIlIIllIlllIlIlI) {
                ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("In parent chain: ").append(ModelBakery.field_177601_e.join((Iterable)this.func_177573_e(llllllllllllllIlIIlIIllIlllIllII))).append("; unable to load model: '").append(llllllllllllllIlIIlIIllIlllIllII).append("'")), (Throwable)llllllllllllllIlIIlIIllIlllIlIlI);
            }
            llllllllllllllIlIIlIIllIllllIIIl.add(llllllllllllllIlIIlIIllIlllIllII);
        }
    }
    
    private boolean isCustomRenderer(final ModelBlock llllllllllllllIlIIlIIllIIllllIIl) {
        if (llllllllllllllIlIIlIIllIIllllIIl == null) {
            return false;
        }
        final ModelBlock llllllllllllllIlIIlIIllIIllllIlI = llllllllllllllIlIIlIIllIIllllIIl.getRootModel();
        return llllllllllllllIlIIlIIllIIllllIlI == ModelBakery.MODEL_ENTITY;
    }
    
    private void bakeItemModels() {
        for (final ResourceLocation llllllllllllllIlIIlIIllIIlllIIII : this.itemLocations.values()) {
            final ModelBlock llllllllllllllIlIIlIIllIIllIllll = this.models.get(llllllllllllllIlIIlIIllIIlllIIII);
            if (this.func_177581_b(llllllllllllllIlIIlIIllIIllIllll)) {
                final ModelBlock llllllllllllllIlIIlIIllIIllIlllI = this.func_177582_d(llllllllllllllIlIIlIIllIIllIllll);
                if (llllllllllllllIlIIlIIllIIllIlllI != null) {
                    llllllllllllllIlIIlIIllIIllIlllI.field_178317_b = llllllllllllllIlIIlIIllIIlllIIII.toString();
                }
                this.models.put(llllllllllllllIlIIlIIllIIlllIIII, llllllllllllllIlIIlIIllIIllIlllI);
            }
            else {
                if (!this.isCustomRenderer(llllllllllllllIlIIlIIllIIllIllll)) {
                    continue;
                }
                this.models.put(llllllllllllllIlIIlIIllIIlllIIII, llllllllllllllIlIIlIIllIIllIllll);
            }
        }
        for (final TextureAtlasSprite llllllllllllllIlIIlIIllIIllIllIl : this.field_177599_g.values()) {
            if (!llllllllllllllIlIIlIIllIIllIllIl.hasAnimationMetadata()) {
                llllllllllllllIlIIlIIllIIllIllIl.clearFramesTextureData();
            }
        }
    }
    
    private void bakeBlockModels() {
        for (final ModelResourceLocation llllllllllllllIlIIlIIlllIllIlIIl : this.variants.keySet()) {
            final WeightedBakedModel.Builder llllllllllllllIlIIlIIlllIllIlIII = new WeightedBakedModel.Builder();
            int llllllllllllllIlIIlIIlllIllIIlll = 0;
            for (final ModelBlockDefinition.Variant llllllllllllllIlIIlIIlllIllIIlIl : this.variants.get(llllllllllllllIlIIlIIlllIllIlIIl).getVariants()) {
                final ModelBlock llllllllllllllIlIIlIIlllIllIIlII = this.models.get(llllllllllllllIlIIlIIlllIllIIlIl.getModelLocation());
                if (llllllllllllllIlIIlIIlllIllIIlII != null && llllllllllllllIlIIlIIlllIllIIlII.isResolved()) {
                    ++llllllllllllllIlIIlIIlllIllIIlll;
                    llllllllllllllIlIIlIIlllIllIlIII.add(this.bakeModel(llllllllllllllIlIIlIIlllIllIIlII, llllllllllllllIlIIlIIlllIllIIlIl.getRotation(), llllllllllllllIlIIlIIlllIllIIlIl.isUvLocked()), llllllllllllllIlIIlIIlllIllIIlIl.getWeight());
                }
                else {
                    ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Missing model for: ").append(llllllllllllllIlIIlIIlllIllIlIIl)));
                }
            }
            if (llllllllllllllIlIIlIIlllIllIIlll == 0) {
                ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("No weighted models for: ").append(llllllllllllllIlIIlIIlllIllIlIIl)));
            }
            else if (llllllllllllllIlIIlIIlllIllIIlll == 1) {
                this.bakedRegistry.putObject(llllllllllllllIlIIlIIlllIllIlIIl, llllllllllllllIlIIlIIlllIllIlIII.first());
            }
            else {
                this.bakedRegistry.putObject(llllllllllllllIlIIlIIlllIllIlIIl, llllllllllllllIlIIlIIlllIllIlIII.build());
            }
        }
        for (final Map.Entry llllllllllllllIlIIlIIlllIllIIIll : this.itemLocations.entrySet()) {
            final ResourceLocation llllllllllllllIlIIlIIlllIllIIIlI = llllllllllllllIlIIlIIlllIllIIIll.getValue();
            final ModelResourceLocation llllllllllllllIlIIlIIlllIllIIIIl = new ModelResourceLocation(llllllllllllllIlIIlIIlllIllIIIll.getKey(), "inventory");
            final ModelBlock llllllllllllllIlIIlIIlllIllIIIII = this.models.get(llllllllllllllIlIIlIIlllIllIIIlI);
            if (llllllllllllllIlIIlIIlllIllIIIII != null && llllllllllllllIlIIlIIlllIllIIIII.isResolved()) {
                if (this.isCustomRenderer(llllllllllllllIlIIlIIlllIllIIIII)) {
                    this.bakedRegistry.putObject(llllllllllllllIlIIlIIlllIllIIIIl, new BuiltInModel(new ItemCameraTransforms(llllllllllllllIlIIlIIlllIllIIIII.getThirdPersonTransform(), llllllllllllllIlIIlIIlllIllIIIII.getFirstPersonTransform(), llllllllllllllIlIIlIIlllIllIIIII.getHeadTransform(), llllllllllllllIlIIlIIlllIllIIIII.getInGuiTransform())));
                }
                else {
                    this.bakedRegistry.putObject(llllllllllllllIlIIlIIlllIllIIIIl, this.bakeModel(llllllllllllllIlIIlIIlllIllIIIII, ModelRotation.X0_Y0, false));
                }
            }
            else {
                ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Missing model for: ").append(llllllllllllllIlIIlIIlllIllIIIlI)));
            }
        }
    }
    
    private List getVariantNames(final Item llllllllllllllIlIIlIIlllIlllllII) {
        List llllllllllllllIlIIlIIlllIllllllI = this.variantNames.get(llllllllllllllIlIIlIIlllIlllllII);
        if (llllllllllllllIlIIlIIlllIllllllI == null) {
            llllllllllllllIlIIlIIlllIllllllI = Collections.singletonList(((ResourceLocation)Item.itemRegistry.getNameForObject(llllllllllllllIlIIlIIlllIlllllII)).toString());
        }
        return llllllllllllllIlIIlIIlllIllllllI;
    }
    
    private Set func_177575_g() {
        final HashSet llllllllllllllIlIIlIIlllIlIIllIl = Sets.newHashSet();
        final ArrayList llllllllllllllIlIIlIIlllIlIIllII = Lists.newArrayList((Iterable)this.variants.keySet());
        Collections.sort((List<Object>)llllllllllllllIlIIlIIlllIlIIllII, new Comparator() {
            static {
                __OBFID = "CL_00002390";
            }
            
            @Override
            public int compare(final Object lllllllllllllllIlllIllllIIlIlIll, final Object lllllllllllllllIlllIllllIIlIllIl) {
                return this.func_177505_a((ModelResourceLocation)lllllllllllllllIlllIllllIIlIlIll, (ModelResourceLocation)lllllllllllllllIlllIllllIIlIllIl);
            }
            
            public int func_177505_a(final ModelResourceLocation lllllllllllllllIlllIllllIIllIlII, final ModelResourceLocation lllllllllllllllIlllIllllIIllIlIl) {
                return lllllllllllllllIlllIllllIIllIlII.toString().compareTo(lllllllllllllllIlllIllllIIllIlIl.toString());
            }
        });
        for (final ModelResourceLocation llllllllllllllIlIIlIIlllIlIIlIlI : llllllllllllllIlIIlIIlllIlIIllII) {
            final ModelBlockDefinition.Variants llllllllllllllIlIIlIIlllIlIIlIIl = this.variants.get(llllllllllllllIlIIlIIlllIlIIlIlI);
            for (final ModelBlockDefinition.Variant llllllllllllllIlIIlIIlllIlIIIlll : llllllllllllllIlIIlIIlllIlIIlIIl.getVariants()) {
                final ModelBlock llllllllllllllIlIIlIIlllIlIIIllI = this.models.get(llllllllllllllIlIIlIIlllIlIIIlll.getModelLocation());
                if (llllllllllllllIlIIlIIlllIlIIIllI == null) {
                    ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Missing model for: ").append(llllllllllllllIlIIlIIlllIlIIlIlI)));
                }
                else {
                    llllllllllllllIlIIlIIlllIlIIllIl.addAll(this.func_177585_a(llllllllllllllIlIIlIIlllIlIIIllI));
                }
            }
        }
        llllllllllllllIlIIlIIlllIlIIllIl.addAll(ModelBakery.field_177602_b);
        return llllllllllllllIlIIlIIlllIlIIllIl;
    }
    
    private IBakedModel bakeModel(final ModelBlock llllllllllllllIlIIlIIlllIIlIIIll, final ModelRotation llllllllllllllIlIIlIIlllIIlIIIlI, final boolean llllllllllllllIlIIlIIlllIIlIIIIl) {
        final TextureAtlasSprite llllllllllllllIlIIlIIlllIIlIllII = this.field_177599_g.get(new ResourceLocation(llllllllllllllIlIIlIIlllIIlIIIll.resolveTextureName("particle")));
        final SimpleBakedModel.Builder llllllllllllllIlIIlIIlllIIlIlIll = new SimpleBakedModel.Builder(llllllllllllllIlIIlIIlllIIlIIIll).func_177646_a(llllllllllllllIlIIlIIlllIIlIllII);
        for (final BlockPart llllllllllllllIlIIlIIlllIIlIlIIl : llllllllllllllIlIIlIIlllIIlIIIll.getElements()) {
            for (final EnumFacing llllllllllllllIlIIlIIlllIIlIIlll : llllllllllllllIlIIlIIlllIIlIlIIl.field_178240_c.keySet()) {
                final BlockPartFace llllllllllllllIlIIlIIlllIIlIIllI = llllllllllllllIlIIlIIlllIIlIlIIl.field_178240_c.get(llllllllllllllIlIIlIIlllIIlIIlll);
                final TextureAtlasSprite llllllllllllllIlIIlIIlllIIlIIlIl = this.field_177599_g.get(new ResourceLocation(llllllllllllllIlIIlIIlllIIlIIIll.resolveTextureName(llllllllllllllIlIIlIIlllIIlIIllI.field_178242_d)));
                if (llllllllllllllIlIIlIIlllIIlIIllI.field_178244_b == null) {
                    llllllllllllllIlIIlIIlllIIlIlIll.func_177648_a(this.func_177589_a(llllllllllllllIlIIlIIlllIIlIlIIl, llllllllllllllIlIIlIIlllIIlIIllI, llllllllllllllIlIIlIIlllIIlIIlIl, llllllllllllllIlIIlIIlllIIlIIlll, llllllllllllllIlIIlIIlllIIlIIIlI, llllllllllllllIlIIlIIlllIIlIIIIl));
                }
                else {
                    llllllllllllllIlIIlIIlllIIlIlIll.func_177650_a(llllllllllllllIlIIlIIlllIIlIIIlI.func_177523_a(llllllllllllllIlIIlIIlllIIlIIllI.field_178244_b), this.func_177589_a(llllllllllllllIlIIlIIlllIIlIlIIl, llllllllllllllIlIIlIIlllIIlIIllI, llllllllllllllIlIIlIIlllIIlIIlIl, llllllllllllllIlIIlIIlllIIlIIlll, llllllllllllllIlIIlIIlllIIlIIIlI, llllllllllllllIlIIlIIlllIIlIIIIl));
                }
            }
        }
        return llllllllllllllIlIIlIIlllIIlIlIll.func_177645_b();
    }
    
    private void func_177572_j() {
        final Set llllllllllllllIlIIlIIllIlIlIllIl = this.func_177575_g();
        llllllllllllllIlIIlIIllIlIlIllIl.addAll(this.func_177571_k());
        llllllllllllllIlIIlIIllIlIlIllIl.remove(TextureMap.field_174945_f);
        final IIconCreator llllllllllllllIlIIlIIllIlIlIllII = new IIconCreator() {
            @Override
            public void func_177059_a(final TextureMap llllllllllllllllIIIlllIIIlIlIllI) {
                for (final ResourceLocation llllllllllllllllIIIlllIIIlIllIIl : llllllllllllllIlIIlIIllIlIlIllIl) {
                    final TextureAtlasSprite llllllllllllllllIIIlllIIIlIllIII = llllllllllllllllIIIlllIIIlIlIllI.func_174942_a(llllllllllllllllIIIlllIIIlIllIIl);
                    ModelBakery.this.field_177599_g.put(llllllllllllllllIIIlllIIIlIllIIl, llllllllllllllllIIIlllIIIlIllIII);
                }
            }
            
            static {
                __OBFID = "CL_00002389";
            }
        };
        this.textureMap.func_174943_a(this.resourceManager, llllllllllllllIlIIlIIllIlIlIllII);
        this.field_177599_g.put(new ResourceLocation("missingno"), this.textureMap.func_174944_f());
    }
    
    private ModelBlock func_177582_d(final ModelBlock llllllllllllllIlIIlIIllIIllIIlII) {
        return this.itemModelGenerator.func_178392_a(this.textureMap, llllllllllllllIlIIlIIllIIllIIlII);
    }
    
    private void loadItemModels() {
        this.registerVariantNames();
        for (final Item llllllllllllllIlIIlIIllllIllIllI : Item.itemRegistry) {
            final List llllllllllllllIlIIlIIllllIllIlIl = this.getVariantNames(llllllllllllllIlIIlIIllllIllIllI);
            for (final String llllllllllllllIlIIlIIllllIllIIll : llllllllllllllIlIIlIIllllIllIlIl) {
                final ResourceLocation llllllllllllllIlIIlIIllllIllIIlI = this.getItemLocation(llllllllllllllIlIIlIIllllIllIIll);
                this.itemLocations.put(llllllllllllllIlIIlIIllllIllIIll, llllllllllllllIlIIlIIllllIllIIlI);
                if (this.models.get(llllllllllllllIlIIlIIllllIllIIlI) == null) {
                    try {
                        final ModelBlock llllllllllllllIlIIlIIllllIllIIIl = this.loadModel(llllllllllllllIlIIlIIllllIllIIlI);
                        this.models.put(llllllllllllllIlIIlIIllllIllIIlI, llllllllllllllIlIIlIIllllIllIIIl);
                    }
                    catch (Exception llllllllllllllIlIIlIIllllIllIIII) {
                        ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Unable to load item model: '").append(llllllllllllllIlIIlIIllllIllIIlI).append("' for item: '").append(Item.itemRegistry.getNameForObject(llllllllllllllIlIIlIIllllIllIllI)).append("'")), (Throwable)llllllllllllllIlIIlIIllllIllIIII);
                    }
                }
            }
        }
    }
    
    public IRegistry setupModelRegistry() {
        this.func_177577_b();
        this.func_177597_h();
        this.func_177572_j();
        this.bakeItemModels();
        this.bakeBlockModels();
        return this.bakedRegistry;
    }
    
    private BakedQuad func_177589_a(final BlockPart llllllllllllllIlIIlIIlllIIIlIIII, final BlockPartFace llllllllllllllIlIIlIIlllIIIIllll, final TextureAtlasSprite llllllllllllllIlIIlIIlllIIIIlllI, final EnumFacing llllllllllllllIlIIlIIlllIIIIllIl, final ModelRotation llllllllllllllIlIIlIIlllIIIIIlIl, final boolean llllllllllllllIlIIlIIlllIIIIIlII) {
        return this.field_177607_l.func_178414_a(llllllllllllllIlIIlIIlllIIIlIIII.field_178241_a, llllllllllllllIlIIlIIlllIIIlIIII.field_178239_b, llllllllllllllIlIIlIIlllIIIIllll, llllllllllllllIlIIlIIlllIIIIlllI, llllllllllllllIlIIlIIlllIIIIllIl, llllllllllllllIlIIlIIlllIIIIIlIl, llllllllllllllIlIIlIIlllIIIlIIII.field_178237_d, llllllllllllllIlIIlIIlllIIIIIlII, llllllllllllllIlIIlIIlllIIIlIIII.field_178238_e);
    }
    
    private Set func_177571_k() {
        final HashSet llllllllllllllIlIIlIIllIlIIlllII = Sets.newHashSet();
        for (final ResourceLocation llllllllllllllIlIIlIIllIlIIllIlI : this.itemLocations.values()) {
            final ModelBlock llllllllllllllIlIIlIIllIlIIllIIl = this.models.get(llllllllllllllIlIIlIIllIlIIllIlI);
            if (llllllllllllllIlIIlIIllIlIIllIIl != null) {
                llllllllllllllIlIIlIIllIlIIlllII.add(new ResourceLocation(llllllllllllllIlIIlIIllIlIIllIIl.resolveTextureName("particle")));
                if (this.func_177581_b(llllllllllllllIlIIlIIllIlIIllIIl)) {
                    for (final String llllllllllllllIlIIlIIllIlIIlIlIl : ItemModelGenerator.LAYERS) {
                        final ResourceLocation llllllllllllllIlIIlIIllIlIIlIllI = new ResourceLocation(llllllllllllllIlIIlIIllIlIIllIIl.resolveTextureName(llllllllllllllIlIIlIIllIlIIlIlIl));
                        if (llllllllllllllIlIIlIIllIlIIllIIl.getRootModel() == ModelBakery.MODEL_COMPASS && !TextureMap.field_174945_f.equals(llllllllllllllIlIIlIIllIlIIlIllI)) {
                            TextureAtlasSprite.func_176603_b(llllllllllllllIlIIlIIllIlIIlIllI.toString());
                        }
                        else if (llllllllllllllIlIIlIIllIlIIllIIl.getRootModel() == ModelBakery.MODEL_CLOCK && !TextureMap.field_174945_f.equals(llllllllllllllIlIIlIIllIlIIlIllI)) {
                            TextureAtlasSprite.func_176602_a(llllllllllllllIlIIlIIllIlIIlIllI.toString());
                        }
                        llllllllllllllIlIIlIIllIlIIlllII.add(llllllllllllllIlIIlIIllIlIIlIllI);
                    }
                }
                else {
                    if (this.isCustomRenderer(llllllllllllllIlIIlIIllIlIIllIIl)) {
                        continue;
                    }
                    for (final BlockPart llllllllllllllIlIIlIIllIlIIlIlII : llllllllllllllIlIIlIIllIlIIllIIl.getElements()) {
                        for (final BlockPartFace llllllllllllllIlIIlIIllIlIIlIIlI : llllllllllllllIlIIlIIllIlIIlIlII.field_178240_c.values()) {
                            final ResourceLocation llllllllllllllIlIIlIIllIlIIlIIIl = new ResourceLocation(llllllllllllllIlIIlIIllIlIIllIIl.resolveTextureName(llllllllllllllIlIIlIIllIlIIlIIlI.field_178242_d));
                            llllllllllllllIlIIlIIllIlIIlllII.add(llllllllllllllIlIIlIIllIlIIlIIIl);
                        }
                    }
                }
            }
        }
        return llllllllllllllIlIIlIIllIlIIlllII;
    }
    
    private ResourceLocation func_177576_f(final ResourceLocation llllllllllllllIlIIlIIllIllIIlIll) {
        for (final Map.Entry llllllllllllllIlIIlIIllIllIIlllI : this.models.entrySet()) {
            final ModelBlock llllllllllllllIlIIlIIllIllIIllIl = llllllllllllllIlIIlIIllIllIIlllI.getValue();
            if (llllllllllllllIlIIlIIllIllIIllIl != null && llllllllllllllIlIIlIIllIllIIlIll.equals(llllllllllllllIlIIlIIllIllIIllIl.getParentLocation())) {
                return llllllllllllllIlIIlIIllIllIIlllI.getKey();
            }
        }
        return null;
    }
    
    private Set func_177585_a(final ModelBlock llllllllllllllIlIIlIIllIlIlllIII) {
        final HashSet llllllllllllllIlIIlIIllIlIlllllI = Sets.newHashSet();
        for (final BlockPart llllllllllllllIlIIlIIllIlIllllII : llllllllllllllIlIIlIIllIlIlllIII.getElements()) {
            for (final BlockPartFace llllllllllllllIlIIlIIllIlIlllIlI : llllllllllllllIlIIlIIllIlIllllII.field_178240_c.values()) {
                final ResourceLocation llllllllllllllIlIIlIIllIlIlllIIl = new ResourceLocation(llllllllllllllIlIIlIIllIlIlllIII.resolveTextureName(llllllllllllllIlIIlIIllIlIlllIlI.field_178242_d));
                llllllllllllllIlIIlIIllIlIlllllI.add(llllllllllllllIlIIlIIllIlIlllIIl);
            }
        }
        llllllllllllllIlIIlIIllIlIlllllI.add(new ResourceLocation(llllllllllllllIlIIlIIllIlIlllIII.resolveTextureName("particle")));
        return llllllllllllllIlIIlIIllIlIlllllI;
    }
    
    private ModelBlockDefinition getModelBlockDefinition(final ResourceLocation llllllllllllllIlIIlIlIIIIIIIlIll) {
        final ResourceLocation llllllllllllllIlIIlIlIIIIIIIlIlI = this.getBlockStateLocation(llllllllllllllIlIIlIlIIIIIIIlIll);
        ModelBlockDefinition llllllllllllllIlIIlIlIIIIIIIlIIl = this.field_177614_t.get(llllllllllllllIlIIlIlIIIIIIIlIlI);
        if (llllllllllllllIlIIlIlIIIIIIIlIIl == null) {
            final ArrayList llllllllllllllIlIIlIlIIIIIIIlIII = Lists.newArrayList();
            try {
                for (final IResource llllllllllllllIlIIlIlIIIIIIIIllI : this.resourceManager.getAllResources(llllllllllllllIlIIlIlIIIIIIIlIlI)) {
                    InputStream llllllllllllllIlIIlIlIIIIIIIIlIl = null;
                    try {
                        llllllllllllllIlIIlIlIIIIIIIIlIl = llllllllllllllIlIIlIlIIIIIIIIllI.getInputStream();
                        final ModelBlockDefinition llllllllllllllIlIIlIlIIIIIIIIlII = ModelBlockDefinition.func_178331_a(new InputStreamReader(llllllllllllllIlIIlIlIIIIIIIIlIl, Charsets.UTF_8));
                        llllllllllllllIlIIlIlIIIIIIIlIII.add(llllllllllllllIlIIlIlIIIIIIIIlII);
                    }
                    catch (Exception llllllllllllllIlIIlIlIIIIIIIIIll) {
                        throw new RuntimeException(String.valueOf(new StringBuilder("Encountered an exception when loading model definition of '").append(llllllllllllllIlIIlIlIIIIIIIlIll).append("' from: '").append(llllllllllllllIlIIlIlIIIIIIIIllI.func_177241_a()).append("' in resourcepack: '").append(llllllllllllllIlIIlIlIIIIIIIIllI.func_177240_d()).append("'")), llllllllllllllIlIIlIlIIIIIIIIIll);
                    }
                    finally {
                        IOUtils.closeQuietly(llllllllllllllIlIIlIlIIIIIIIIlIl);
                    }
                    IOUtils.closeQuietly(llllllllllllllIlIIlIlIIIIIIIIlIl);
                }
            }
            catch (IOException llllllllllllllIlIIlIlIIIIIIIIIlI) {
                throw new RuntimeException(String.valueOf(new StringBuilder("Encountered an exception when loading model definition of model ").append(llllllllllllllIlIIlIlIIIIIIIlIlI.toString())), llllllllllllllIlIIlIlIIIIIIIIIlI);
            }
            llllllllllllllIlIIlIlIIIIIIIlIIl = new ModelBlockDefinition(llllllllllllllIlIIlIlIIIIIIIlIII);
            this.field_177614_t.put(llllllllllllllIlIIlIlIIIIIIIlIlI, llllllllllllllIlIIlIlIIIIIIIlIIl);
        }
        return llllllllllllllIlIIlIlIIIIIIIlIIl;
    }
    
    private void loadVariants(final Collection llllllllllllllIlIIlIlIIIIIlIIlII) {
        for (final ModelResourceLocation llllllllllllllIlIIlIlIIIIIlIlIIl : llllllllllllllIlIIlIlIIIIIlIIlII) {
            try {
                final ModelBlockDefinition llllllllllllllIlIIlIlIIIIIlIlIII = this.getModelBlockDefinition(llllllllllllllIlIIlIlIIIIIlIlIIl);
                try {
                    this.registerVariant(llllllllllllllIlIIlIlIIIIIlIlIII, llllllllllllllIlIIlIlIIIIIlIlIIl);
                }
                catch (Exception llllllllllllllIlIIlIlIIIIIlIIlll) {
                    ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Unable to load variant: ").append(llllllllllllllIlIIlIlIIIIIlIlIIl.func_177518_c()).append(" from ").append(llllllllllllllIlIIlIlIIIIIlIlIIl)));
                }
            }
            catch (Exception llllllllllllllIlIIlIlIIIIIlIIllI) {
                ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Unable to load definition ").append(llllllllllllllIlIIlIlIIIIIlIlIIl)), (Throwable)llllllllllllllIlIIlIlIIIIIlIIllI);
            }
        }
    }
    
    private ResourceLocation getModelLocation(final ResourceLocation llllllllllllllIlIIlIIlllllIIIIlI) {
        return new ResourceLocation(llllllllllllllIlIIlIIlllllIIIIlI.getResourceDomain(), String.valueOf(new StringBuilder("models/").append(llllllllllllllIlIIlIIlllllIIIIlI.getResourcePath()).append(".json")));
    }
}
