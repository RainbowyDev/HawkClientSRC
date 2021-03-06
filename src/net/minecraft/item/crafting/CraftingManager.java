package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import java.util.*;

public class CraftingManager
{
    private static final /* synthetic */ CraftingManager instance;
    private final /* synthetic */ List recipes;
    
    public ItemStack findMatchingRecipe(final InventoryCrafting llllllllllllllIIIIlIIlIIIlIllllI, final World llllllllllllllIIIIlIIlIIIlIlllIl) {
        for (final IRecipe llllllllllllllIIIIlIIlIIIllIIIII : this.recipes) {
            if (llllllllllllllIIIIlIIlIIIllIIIII.matches(llllllllllllllIIIIlIIlIIIlIllllI, llllllllllllllIIIIlIIlIIIlIlllIl)) {
                return llllllllllllllIIIIlIIlIIIllIIIII.getCraftingResult(llllllllllllllIIIIlIIlIIIlIllllI);
            }
        }
        return null;
    }
    
    static {
        __OBFID = "CL_00000090";
        instance = new CraftingManager();
    }
    
    public static CraftingManager getInstance() {
        return CraftingManager.instance;
    }
    
    public List getRecipeList() {
        return this.recipes;
    }
    
    public void addShapelessRecipe(final ItemStack llllllllllllllIIIIlIIlIIIllllllI, final Object... llllllllllllllIIIIlIIlIIIlllllIl) {
        final ArrayList llllllllllllllIIIIlIIlIIIlllllII = Lists.newArrayList();
        final Object[] llllllllllllllIIIIlIIlIIIllllIll = llllllllllllllIIIIlIIlIIIlllllIl;
        for (int llllllllllllllIIIIlIIlIIIllllIlI = llllllllllllllIIIIlIIlIIIlllllIl.length, llllllllllllllIIIIlIIlIIIllllIIl = 0; llllllllllllllIIIIlIIlIIIllllIIl < llllllllllllllIIIIlIIlIIIllllIlI; ++llllllllllllllIIIIlIIlIIIllllIIl) {
            final Object llllllllllllllIIIIlIIlIIIllllIII = llllllllllllllIIIIlIIlIIIllllIll[llllllllllllllIIIIlIIlIIIllllIIl];
            if (llllllllllllllIIIIlIIlIIIllllIII instanceof ItemStack) {
                llllllllllllllIIIIlIIlIIIlllllII.add(((ItemStack)llllllllllllllIIIIlIIlIIIllllIII).copy());
            }
            else if (llllllllllllllIIIIlIIlIIIllllIII instanceof Item) {
                llllllllllllllIIIIlIIlIIIlllllII.add(new ItemStack((Item)llllllllllllllIIIIlIIlIIIllllIII));
            }
            else {
                if (!(llllllllllllllIIIIlIIlIIIllllIII instanceof Block)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid shapeless recipe: unknown type ").append(llllllllllllllIIIIlIIlIIIllllIII.getClass().getName()).append("!")));
                }
                llllllllllllllIIIIlIIlIIIlllllII.add(new ItemStack((Block)llllllllllllllIIIIlIIlIIIllllIII));
            }
        }
        this.recipes.add(new ShapelessRecipes(llllllllllllllIIIIlIIlIIIllllllI, llllllllllllllIIIIlIIlIIIlllllII));
    }
    
    public void func_180302_a(final IRecipe llllllllllllllIIIIlIIlIIIllIllII) {
        this.recipes.add(llllllllllllllIIIIlIIlIIIllIllII);
    }
    
    private CraftingManager() {
        this.recipes = Lists.newArrayList();
        new RecipesTools().addRecipes(this);
        new RecipesWeapons().addRecipes(this);
        new RecipesIngots().addRecipes(this);
        new RecipesFood().addRecipes(this);
        new RecipesCrafting().addRecipes(this);
        new RecipesArmor().addRecipes(this);
        new RecipesDyes().addRecipes(this);
        this.recipes.add(new RecipesArmorDyes());
        this.recipes.add(new RecipeBookCloning());
        this.recipes.add(new RecipesMapCloning());
        this.recipes.add(new RecipesMapExtending());
        this.recipes.add(new RecipeFireworks());
        this.recipes.add(new RecipeRepairItem());
        new RecipesBanners().func_179534_a(this);
        this.addRecipe(new ItemStack(Items.paper, 3), "###", '#', Items.reeds);
        this.addShapelessRecipe(new ItemStack(Items.book, 1), Items.paper, Items.paper, Items.paper, Items.leather);
        this.addShapelessRecipe(new ItemStack(Items.writable_book, 1), Items.book, new ItemStack(Items.dye, 1, EnumDyeColor.BLACK.getDyeColorDamage()), Items.feather);
        this.addRecipe(new ItemStack(Blocks.oak_fence, 3), "W#W", "W#W", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.birch_fence, 3), "W#W", "W#W", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.spruce_fence, 3), "W#W", "W#W", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.jungle_fence, 3), "W#W", "W#W", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.acacia_fence, 3), "W#W", "W#W", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, 4 + BlockPlanks.EnumType.ACACIA.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Blocks.dark_oak_fence, 3), "W#W", "W#W", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, 4 + BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, BlockWall.EnumType.NORMAL.func_176657_a()), "###", "###", '#', Blocks.cobblestone);
        this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, BlockWall.EnumType.MOSSY.func_176657_a()), "###", "###", '#', Blocks.mossy_cobblestone);
        this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 6), "###", "###", '#', Blocks.nether_brick);
        this.addRecipe(new ItemStack(Blocks.oak_fence_gate, 1), "#W#", "#W#", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.birch_fence_gate, 1), "#W#", "#W#", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.spruce_fence_gate, 1), "#W#", "#W#", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.jungle_fence_gate, 1), "#W#", "#W#", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.acacia_fence_gate, 1), "#W#", "#W#", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, 4 + BlockPlanks.EnumType.ACACIA.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Blocks.dark_oak_fence_gate, 1), "#W#", "#W#", '#', Items.stick, 'W', new ItemStack(Blocks.planks, 1, 4 + BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Blocks.jukebox, 1), "###", "#X#", "###", '#', Blocks.planks, 'X', Items.diamond);
        this.addRecipe(new ItemStack(Items.lead, 2), "~~ ", "~O ", "  ~", '~', Items.string, 'O', Items.slime_ball);
        this.addRecipe(new ItemStack(Blocks.noteblock, 1), "###", "#X#", "###", '#', Blocks.planks, 'X', Items.redstone);
        this.addRecipe(new ItemStack(Blocks.bookshelf, 1), "###", "XXX", "###", '#', Blocks.planks, 'X', Items.book);
        this.addRecipe(new ItemStack(Blocks.snow, 1), "##", "##", '#', Items.snowball);
        this.addRecipe(new ItemStack(Blocks.snow_layer, 6), "###", '#', Blocks.snow);
        this.addRecipe(new ItemStack(Blocks.clay, 1), "##", "##", '#', Items.clay_ball);
        this.addRecipe(new ItemStack(Blocks.brick_block, 1), "##", "##", '#', Items.brick);
        this.addRecipe(new ItemStack(Blocks.glowstone, 1), "##", "##", '#', Items.glowstone_dust);
        this.addRecipe(new ItemStack(Blocks.quartz_block, 1), "##", "##", '#', Items.quartz);
        this.addRecipe(new ItemStack(Blocks.wool, 1), "##", "##", '#', Items.string);
        this.addRecipe(new ItemStack(Blocks.tnt, 1), "X#X", "#X#", "X#X", 'X', Items.gunpowder, '#', Blocks.sand);
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, BlockStoneSlab.EnumType.COBBLESTONE.func_176624_a()), "###", '#', Blocks.cobblestone);
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, BlockStoneSlab.EnumType.STONE.func_176624_a()), "###", '#', new ItemStack(Blocks.stone, BlockStone.EnumType.STONE.getMetaFromState()));
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, BlockStoneSlab.EnumType.SAND.func_176624_a()), "###", '#', Blocks.sandstone);
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, BlockStoneSlab.EnumType.BRICK.func_176624_a()), "###", '#', Blocks.brick_block);
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), "###", '#', Blocks.stonebrick);
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, BlockStoneSlab.EnumType.NETHERBRICK.func_176624_a()), "###", '#', Blocks.nether_brick);
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, BlockStoneSlab.EnumType.QUARTZ.func_176624_a()), "###", '#', Blocks.quartz_block);
        this.addRecipe(new ItemStack(Blocks.stone_slab2, 6, BlockStoneSlabNew.EnumType.RED_SANDSTONE.func_176915_a()), "###", '#', Blocks.red_sandstone);
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 0), "###", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, BlockPlanks.EnumType.BIRCH.func_176839_a()), "###", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, BlockPlanks.EnumType.SPRUCE.func_176839_a()), "###", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, BlockPlanks.EnumType.JUNGLE.func_176839_a()), "###", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 4 + BlockPlanks.EnumType.ACACIA.func_176839_a() - 4), "###", '#', new ItemStack(Blocks.planks, 1, 4 + BlockPlanks.EnumType.ACACIA.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 4 + BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4), "###", '#', new ItemStack(Blocks.planks, 1, 4 + BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Blocks.ladder, 3), "# #", "###", "# #", '#', Items.stick);
        this.addRecipe(new ItemStack(Items.oak_door, 3), "##", "##", "##", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
        this.addRecipe(new ItemStack(Items.spruce_door, 3), "##", "##", "##", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
        this.addRecipe(new ItemStack(Items.birch_door, 3), "##", "##", "##", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
        this.addRecipe(new ItemStack(Items.jungle_door, 3), "##", "##", "##", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
        this.addRecipe(new ItemStack(Items.acacia_door, 3), "##", "##", "##", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.ACACIA.func_176839_a()));
        this.addRecipe(new ItemStack(Items.dark_oak_door, 3), "##", "##", "##", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.DARK_OAK.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.trapdoor, 2), "###", "###", '#', Blocks.planks);
        this.addRecipe(new ItemStack(Items.iron_door, 3), "##", "##", "##", '#', Items.iron_ingot);
        this.addRecipe(new ItemStack(Blocks.iron_trapdoor, 1), "##", "##", '#', Items.iron_ingot);
        this.addRecipe(new ItemStack(Items.sign, 3), "###", "###", " X ", '#', Blocks.planks, 'X', Items.stick);
        this.addRecipe(new ItemStack(Items.cake, 1), "AAA", "BEB", "CCC", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.wheat, 'E', Items.egg);
        this.addRecipe(new ItemStack(Items.sugar, 1), "#", '#', Items.reeds);
        this.addRecipe(new ItemStack(Blocks.planks, 4, BlockPlanks.EnumType.OAK.func_176839_a()), "#", '#', new ItemStack(Blocks.log, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.planks, 4, BlockPlanks.EnumType.SPRUCE.func_176839_a()), "#", '#', new ItemStack(Blocks.log, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.planks, 4, BlockPlanks.EnumType.BIRCH.func_176839_a()), "#", '#', new ItemStack(Blocks.log, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.planks, 4, BlockPlanks.EnumType.JUNGLE.func_176839_a()), "#", '#', new ItemStack(Blocks.log, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.planks, 4, 4 + BlockPlanks.EnumType.ACACIA.func_176839_a() - 4), "#", '#', new ItemStack(Blocks.log2, 1, BlockPlanks.EnumType.ACACIA.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Blocks.planks, 4, 4 + BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4), "#", '#', new ItemStack(Blocks.log2, 1, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Items.stick, 4), "#", "#", '#', Blocks.planks);
        this.addRecipe(new ItemStack(Blocks.torch, 4), "X", "#", 'X', Items.coal, '#', Items.stick);
        this.addRecipe(new ItemStack(Blocks.torch, 4), "X", "#", 'X', new ItemStack(Items.coal, 1, 1), '#', Items.stick);
        this.addRecipe(new ItemStack(Items.bowl, 4), "# #", " # ", '#', Blocks.planks);
        this.addRecipe(new ItemStack(Items.glass_bottle, 3), "# #", " # ", '#', Blocks.glass);
        this.addRecipe(new ItemStack(Blocks.rail, 16), "X X", "X#X", "X X", 'X', Items.iron_ingot, '#', Items.stick);
        this.addRecipe(new ItemStack(Blocks.golden_rail, 6), "X X", "X#X", "XRX", 'X', Items.gold_ingot, 'R', Items.redstone, '#', Items.stick);
        this.addRecipe(new ItemStack(Blocks.activator_rail, 6), "XSX", "X#X", "XSX", 'X', Items.iron_ingot, '#', Blocks.redstone_torch, 'S', Items.stick);
        this.addRecipe(new ItemStack(Blocks.detector_rail, 6), "X X", "X#X", "XRX", 'X', Items.iron_ingot, 'R', Items.redstone, '#', Blocks.stone_pressure_plate);
        this.addRecipe(new ItemStack(Items.minecart, 1), "# #", "###", '#', Items.iron_ingot);
        this.addRecipe(new ItemStack(Items.cauldron, 1), "# #", "# #", "###", '#', Items.iron_ingot);
        this.addRecipe(new ItemStack(Items.brewing_stand, 1), " B ", "###", '#', Blocks.cobblestone, 'B', Items.blaze_rod);
        this.addRecipe(new ItemStack(Blocks.lit_pumpkin, 1), "A", "B", 'A', Blocks.pumpkin, 'B', Blocks.torch);
        this.addRecipe(new ItemStack(Items.chest_minecart, 1), "A", "B", 'A', Blocks.chest, 'B', Items.minecart);
        this.addRecipe(new ItemStack(Items.furnace_minecart, 1), "A", "B", 'A', Blocks.furnace, 'B', Items.minecart);
        this.addRecipe(new ItemStack(Items.tnt_minecart, 1), "A", "B", 'A', Blocks.tnt, 'B', Items.minecart);
        this.addRecipe(new ItemStack(Items.hopper_minecart, 1), "A", "B", 'A', Blocks.hopper, 'B', Items.minecart);
        this.addRecipe(new ItemStack(Items.boat, 1), "# #", "###", '#', Blocks.planks);
        this.addRecipe(new ItemStack(Items.bucket, 1), "# #", " # ", '#', Items.iron_ingot);
        this.addRecipe(new ItemStack(Items.flower_pot, 1), "# #", " # ", '#', Items.brick);
        this.addShapelessRecipe(new ItemStack(Items.flint_and_steel, 1), new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.flint, 1));
        this.addRecipe(new ItemStack(Items.bread, 1), "###", '#', Items.wheat);
        this.addRecipe(new ItemStack(Blocks.oak_stairs, 4), "#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.birch_stairs, 4), "#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.spruce_stairs, 4), "#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.jungle_stairs, 4), "#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
        this.addRecipe(new ItemStack(Blocks.acacia_stairs, 4), "#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 4 + BlockPlanks.EnumType.ACACIA.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Blocks.dark_oak_stairs, 4), "#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 4 + BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4));
        this.addRecipe(new ItemStack(Items.fishing_rod, 1), "  #", " #X", "# X", '#', Items.stick, 'X', Items.string);
        this.addRecipe(new ItemStack(Items.carrot_on_a_stick, 1), "# ", " X", '#', Items.fishing_rod, 'X', Items.carrot).func_92100_c();
        this.addRecipe(new ItemStack(Blocks.stone_stairs, 4), "#  ", "## ", "###", '#', Blocks.cobblestone);
        this.addRecipe(new ItemStack(Blocks.brick_stairs, 4), "#  ", "## ", "###", '#', Blocks.brick_block);
        this.addRecipe(new ItemStack(Blocks.stone_brick_stairs, 4), "#  ", "## ", "###", '#', Blocks.stonebrick);
        this.addRecipe(new ItemStack(Blocks.nether_brick_stairs, 4), "#  ", "## ", "###", '#', Blocks.nether_brick);
        this.addRecipe(new ItemStack(Blocks.sandstone_stairs, 4), "#  ", "## ", "###", '#', Blocks.sandstone);
        this.addRecipe(new ItemStack(Blocks.red_sandstone_stairs, 4), "#  ", "## ", "###", '#', Blocks.red_sandstone);
        this.addRecipe(new ItemStack(Blocks.quartz_stairs, 4), "#  ", "## ", "###", '#', Blocks.quartz_block);
        this.addRecipe(new ItemStack(Items.painting, 1), "###", "#X#", "###", '#', Items.stick, 'X', Blocks.wool);
        this.addRecipe(new ItemStack(Items.item_frame, 1), "###", "#X#", "###", '#', Items.stick, 'X', Items.leather);
        this.addRecipe(new ItemStack(Items.golden_apple, 1, 0), "###", "#X#", "###", '#', Items.gold_ingot, 'X', Items.apple);
        this.addRecipe(new ItemStack(Items.golden_apple, 1, 1), "###", "#X#", "###", '#', Blocks.gold_block, 'X', Items.apple);
        this.addRecipe(new ItemStack(Items.golden_carrot, 1, 0), "###", "#X#", "###", '#', Items.gold_nugget, 'X', Items.carrot);
        this.addRecipe(new ItemStack(Items.speckled_melon, 1), "###", "#X#", "###", '#', Items.gold_nugget, 'X', Items.melon);
        this.addRecipe(new ItemStack(Blocks.lever, 1), "X", "#", '#', Blocks.cobblestone, 'X', Items.stick);
        this.addRecipe(new ItemStack(Blocks.tripwire_hook, 2), "I", "S", "#", '#', Blocks.planks, 'S', Items.stick, 'I', Items.iron_ingot);
        this.addRecipe(new ItemStack(Blocks.redstone_torch, 1), "X", "#", '#', Items.stick, 'X', Items.redstone);
        this.addRecipe(new ItemStack(Items.repeater, 1), "#X#", "III", '#', Blocks.redstone_torch, 'X', Items.redstone, 'I', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.STONE.getMetaFromState()));
        this.addRecipe(new ItemStack(Items.comparator, 1), " # ", "#X#", "III", '#', Blocks.redstone_torch, 'X', Items.quartz, 'I', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.STONE.getMetaFromState()));
        this.addRecipe(new ItemStack(Items.clock, 1), " # ", "#X#", " # ", '#', Items.gold_ingot, 'X', Items.redstone);
        this.addRecipe(new ItemStack(Items.compass, 1), " # ", "#X#", " # ", '#', Items.iron_ingot, 'X', Items.redstone);
        this.addRecipe(new ItemStack(Items.map, 1), "###", "#X#", "###", '#', Items.paper, 'X', Items.compass);
        this.addRecipe(new ItemStack(Blocks.stone_button, 1), "#", '#', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.STONE.getMetaFromState()));
        this.addRecipe(new ItemStack(Blocks.wooden_button, 1), "#", '#', Blocks.planks);
        this.addRecipe(new ItemStack(Blocks.stone_pressure_plate, 1), "##", '#', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.STONE.getMetaFromState()));
        this.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), "##", '#', Blocks.planks);
        this.addRecipe(new ItemStack(Blocks.heavy_weighted_pressure_plate, 1), "##", '#', Items.iron_ingot);
        this.addRecipe(new ItemStack(Blocks.light_weighted_pressure_plate, 1), "##", '#', Items.gold_ingot);
        this.addRecipe(new ItemStack(Blocks.dispenser, 1), "###", "#X#", "#R#", '#', Blocks.cobblestone, 'X', Items.bow, 'R', Items.redstone);
        this.addRecipe(new ItemStack(Blocks.dropper, 1), "###", "# #", "#R#", '#', Blocks.cobblestone, 'R', Items.redstone);
        this.addRecipe(new ItemStack(Blocks.piston, 1), "TTT", "#X#", "#R#", '#', Blocks.cobblestone, 'X', Items.iron_ingot, 'R', Items.redstone, 'T', Blocks.planks);
        this.addRecipe(new ItemStack(Blocks.sticky_piston, 1), "S", "P", 'S', Items.slime_ball, 'P', Blocks.piston);
        this.addRecipe(new ItemStack(Items.bed, 1), "###", "XXX", '#', Blocks.wool, 'X', Blocks.planks);
        this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), " B ", "D#D", "###", '#', Blocks.obsidian, 'B', Items.book, 'D', Items.diamond);
        this.addRecipe(new ItemStack(Blocks.anvil, 1), "III", " i ", "iii", 'I', Blocks.iron_block, 'i', Items.iron_ingot);
        this.addRecipe(new ItemStack(Items.leather), "##", "##", '#', Items.rabbit_hide);
        this.addShapelessRecipe(new ItemStack(Items.ender_eye, 1), Items.ender_pearl, Items.blaze_powder);
        this.addShapelessRecipe(new ItemStack(Items.fire_charge, 3), Items.gunpowder, Items.blaze_powder, Items.coal);
        this.addShapelessRecipe(new ItemStack(Items.fire_charge, 3), Items.gunpowder, Items.blaze_powder, new ItemStack(Items.coal, 1, 1));
        this.addRecipe(new ItemStack(Blocks.daylight_detector), "GGG", "QQQ", "WWW", 'G', Blocks.glass, 'Q', Items.quartz, 'W', Blocks.wooden_slab);
        this.addRecipe(new ItemStack(Blocks.hopper), "I I", "ICI", " I ", 'I', Items.iron_ingot, 'C', Blocks.chest);
        this.addRecipe(new ItemStack(Items.armor_stand, 1), "///", " / ", "/_/", '/', Items.stick, '_', new ItemStack(Blocks.stone_slab, 1, BlockStoneSlab.EnumType.STONE.func_176624_a()));
        Collections.sort((List<Object>)this.recipes, new Comparator() {
            static {
                __OBFID = "CL_00000091";
            }
            
            @Override
            public int compare(final Object llllllllllllllIIIIIIIllllllIIlll, final Object llllllllllllllIIIIIIIllllllIIllI) {
                return this.compare((IRecipe)llllllllllllllIIIIIIIllllllIIlll, (IRecipe)llllllllllllllIIIIIIIllllllIIllI);
            }
            
            public int compare(final IRecipe llllllllllllllIIIIIIIlllllllIIII, final IRecipe llllllllllllllIIIIIIIlllllllIIIl) {
                return (llllllllllllllIIIIIIIlllllllIIII instanceof ShapelessRecipes && llllllllllllllIIIIIIIlllllllIIIl instanceof ShapedRecipes) ? 1 : ((llllllllllllllIIIIIIIlllllllIIIl instanceof ShapelessRecipes && llllllllllllllIIIIIIIlllllllIIII instanceof ShapedRecipes) ? -1 : ((llllllllllllllIIIIIIIlllllllIIIl.getRecipeSize() < llllllllllllllIIIIIIIlllllllIIII.getRecipeSize()) ? -1 : ((llllllllllllllIIIIIIIlllllllIIIl.getRecipeSize() > llllllllllllllIIIIIIIlllllllIIII.getRecipeSize()) ? 1 : 0)));
            }
        });
    }
    
    public ShapedRecipes addRecipe(final ItemStack llllllllllllllIIIIlIIlIIlIlIIIll, final Object... llllllllllllllIIIIlIIlIIlIlIIIlI) {
        String llllllllllllllIIIIlIIlIIlIlIIIIl = "";
        int llllllllllllllIIIIlIIlIIlIlIIIII = 0;
        int llllllllllllllIIIIlIIlIIlIIlllll = 0;
        int llllllllllllllIIIIlIIlIIlIIllllI = 0;
        if (llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII] instanceof String[]) {
            final String[] llllllllllllllIIIIlIIlIIlIIlllIl = (String[])llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII++];
            for (int llllllllllllllIIIIlIIlIIlIIlllII = 0; llllllllllllllIIIIlIIlIIlIIlllII < llllllllllllllIIIIlIIlIIlIIlllIl.length; ++llllllllllllllIIIIlIIlIIlIIlllII) {
                final String llllllllllllllIIIIlIIlIIlIIllIll = llllllllllllllIIIIlIIlIIlIIlllIl[llllllllllllllIIIIlIIlIIlIIlllII];
                ++llllllllllllllIIIIlIIlIIlIIllllI;
                llllllllllllllIIIIlIIlIIlIIlllll = llllllllllllllIIIIlIIlIIlIIllIll.length();
                llllllllllllllIIIIlIIlIIlIlIIIIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIlIIlIIlIlIIIIl)).append(llllllllllllllIIIIlIIlIIlIIllIll));
            }
        }
        else {
            while (llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII] instanceof String) {
                final String llllllllllllllIIIIlIIlIIlIIllIlI = (String)llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII++];
                ++llllllllllllllIIIIlIIlIIlIIllllI;
                llllllllllllllIIIIlIIlIIlIIlllll = llllllllllllllIIIIlIIlIIlIIllIlI.length();
                llllllllllllllIIIIlIIlIIlIlIIIIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIlIIlIIlIlIIIIl)).append(llllllllllllllIIIIlIIlIIlIIllIlI));
            }
        }
        final HashMap llllllllllllllIIIIlIIlIIlIIllIIl = Maps.newHashMap();
        while (llllllllllllllIIIIlIIlIIlIlIIIII < llllllllllllllIIIIlIIlIIlIlIIIlI.length) {
            final Character llllllllllllllIIIIlIIlIIlIIllIII = (Character)llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII];
            ItemStack llllllllllllllIIIIlIIlIIlIIlIlll = null;
            if (llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII + 1] instanceof Item) {
                llllllllllllllIIIIlIIlIIlIIlIlll = new ItemStack((Item)llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII + 1]);
            }
            else if (llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII + 1] instanceof Block) {
                llllllllllllllIIIIlIIlIIlIIlIlll = new ItemStack((Block)llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII + 1], 1, 32767);
            }
            else if (llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII + 1] instanceof ItemStack) {
                llllllllllllllIIIIlIIlIIlIIlIlll = (ItemStack)llllllllllllllIIIIlIIlIIlIlIIIlI[llllllllllllllIIIIlIIlIIlIlIIIII + 1];
            }
            llllllllllllllIIIIlIIlIIlIIllIIl.put(llllllllllllllIIIIlIIlIIlIIllIII, llllllllllllllIIIIlIIlIIlIIlIlll);
            llllllllllllllIIIIlIIlIIlIlIIIII += 2;
        }
        final ItemStack[] llllllllllllllIIIIlIIlIIlIIlIllI = new ItemStack[llllllllllllllIIIIlIIlIIlIIlllll * llllllllllllllIIIIlIIlIIlIIllllI];
        for (int llllllllllllllIIIIlIIlIIlIIlIlIl = 0; llllllllllllllIIIIlIIlIIlIIlIlIl < llllllllllllllIIIIlIIlIIlIIlllll * llllllllllllllIIIIlIIlIIlIIllllI; ++llllllllllllllIIIIlIIlIIlIIlIlIl) {
            final char llllllllllllllIIIIlIIlIIlIIlIlII = llllllllllllllIIIIlIIlIIlIlIIIIl.charAt(llllllllllllllIIIIlIIlIIlIIlIlIl);
            if (llllllllllllllIIIIlIIlIIlIIllIIl.containsKey(llllllllllllllIIIIlIIlIIlIIlIlII)) {
                llllllllllllllIIIIlIIlIIlIIlIllI[llllllllllllllIIIIlIIlIIlIIlIlIl] = llllllllllllllIIIIlIIlIIlIIllIIl.get(llllllllllllllIIIIlIIlIIlIIlIlII).copy();
            }
            else {
                llllllllllllllIIIIlIIlIIlIIlIllI[llllllllllllllIIIIlIIlIIlIIlIlIl] = null;
            }
        }
        final ShapedRecipes llllllllllllllIIIIlIIlIIlIIlIIll = new ShapedRecipes(llllllllllllllIIIIlIIlIIlIIlllll, llllllllllllllIIIIlIIlIIlIIllllI, llllllllllllllIIIIlIIlIIlIIlIllI, llllllllllllllIIIIlIIlIIlIlIIIll);
        this.recipes.add(llllllllllllllIIIIlIIlIIlIIlIIll);
        return llllllllllllllIIIIlIIlIIlIIlIIll;
    }
    
    public ItemStack[] func_180303_b(final InventoryCrafting llllllllllllllIIIIlIIlIIIlIIllII, final World llllllllllllllIIIIlIIlIIIlIlIIlI) {
        for (final IRecipe llllllllllllllIIIIlIIlIIIlIlIIII : this.recipes) {
            if (llllllllllllllIIIIlIIlIIIlIlIIII.matches(llllllllllllllIIIIlIIlIIIlIIllII, llllllllllllllIIIIlIIlIIIlIlIIlI)) {
                return llllllllllllllIIIIlIIlIIIlIlIIII.func_179532_b(llllllllllllllIIIIlIIlIIIlIIllII);
            }
        }
        final ItemStack[] llllllllllllllIIIIlIIlIIIlIIllll = new ItemStack[llllllllllllllIIIIlIIlIIIlIIllII.getSizeInventory()];
        for (int llllllllllllllIIIIlIIlIIIlIIlllI = 0; llllllllllllllIIIIlIIlIIIlIIlllI < llllllllllllllIIIIlIIlIIIlIIllll.length; ++llllllllllllllIIIIlIIlIIIlIIlllI) {
            llllllllllllllIIIIlIIlIIIlIIllll[llllllllllllllIIIIlIIlIIIlIIlllI] = llllllllllllllIIIIlIIlIIIlIIllII.getStackInSlot(llllllllllllllIIIIlIIlIIIlIIlllI);
        }
        return llllllllllllllIIIIlIIlIIIlIIllll;
    }
}
