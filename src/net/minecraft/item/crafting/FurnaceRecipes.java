package net.minecraft.item.crafting;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class FurnaceRecipes
{
    private /* synthetic */ Map experienceList;
    private /* synthetic */ Map smeltingList;
    private static final /* synthetic */ FurnaceRecipes smeltingBase;
    
    public void addSmelting(final Item lllllllllllllllIlIlIIllllIlllIll, final ItemStack lllllllllllllllIlIlIIllllIlllllI, final float lllllllllllllllIlIlIIllllIllllIl) {
        this.addSmeltingRecipe(new ItemStack(lllllllllllllllIlIlIIllllIlllIll, 1, 32767), lllllllllllllllIlIlIIllllIlllllI, lllllllllllllllIlIlIIllllIllllIl);
    }
    
    public void addSmeltingRecipe(final ItemStack lllllllllllllllIlIlIIllllIlIllll, final ItemStack lllllllllllllllIlIlIIllllIllIIlI, final float lllllllllllllllIlIlIIllllIllIIIl) {
        this.smeltingList.put(lllllllllllllllIlIlIIllllIlIllll, lllllllllllllllIlIlIIllllIllIIlI);
        this.experienceList.put(lllllllllllllllIlIlIIllllIllIIlI, lllllllllllllllIlIlIIllllIllIIIl);
    }
    
    public static FurnaceRecipes instance() {
        return FurnaceRecipes.smeltingBase;
    }
    
    static {
        __OBFID = "CL_00000085";
        smeltingBase = new FurnaceRecipes();
    }
    
    public Map getSmeltingList() {
        return this.smeltingList;
    }
    
    public float getSmeltingExperience(final ItemStack lllllllllllllllIlIlIIllllIIlIIIl) {
        for (final Map.Entry lllllllllllllllIlIlIIllllIIIllll : this.experienceList.entrySet()) {
            if (this.func_151397_a(lllllllllllllllIlIlIIllllIIlIIIl, lllllllllllllllIlIlIIllllIIIllll.getKey())) {
                return lllllllllllllllIlIlIIllllIIIllll.getValue();
            }
        }
        return 0.0f;
    }
    
    private FurnaceRecipes() {
        this.smeltingList = Maps.newHashMap();
        this.experienceList = Maps.newHashMap();
        this.addSmeltingRecipeForBlock(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7f);
        this.addSmeltingRecipeForBlock(Blocks.gold_ore, new ItemStack(Items.gold_ingot), 1.0f);
        this.addSmeltingRecipeForBlock(Blocks.diamond_ore, new ItemStack(Items.diamond), 1.0f);
        this.addSmeltingRecipeForBlock(Blocks.sand, new ItemStack(Blocks.glass), 0.1f);
        this.addSmelting(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.35f);
        this.addSmelting(Items.beef, new ItemStack(Items.cooked_beef), 0.35f);
        this.addSmelting(Items.chicken, new ItemStack(Items.cooked_chicken), 0.35f);
        this.addSmelting(Items.rabbit, new ItemStack(Items.cooked_rabbit), 0.35f);
        this.addSmelting(Items.mutton, new ItemStack(Items.cooked_mutton), 0.35f);
        this.addSmeltingRecipeForBlock(Blocks.cobblestone, new ItemStack(Blocks.stone), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.DEFAULT_META), new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.CRACKED_META), 0.1f);
        this.addSmelting(Items.clay_ball, new ItemStack(Items.brick), 0.3f);
        this.addSmeltingRecipeForBlock(Blocks.clay, new ItemStack(Blocks.hardened_clay), 0.35f);
        this.addSmeltingRecipeForBlock(Blocks.cactus, new ItemStack(Items.dye, 1, EnumDyeColor.GREEN.getDyeColorDamage()), 0.2f);
        this.addSmeltingRecipeForBlock(Blocks.log, new ItemStack(Items.coal, 1, 1), 0.15f);
        this.addSmeltingRecipeForBlock(Blocks.log2, new ItemStack(Items.coal, 1, 1), 0.15f);
        this.addSmeltingRecipeForBlock(Blocks.emerald_ore, new ItemStack(Items.emerald), 1.0f);
        this.addSmelting(Items.potato, new ItemStack(Items.baked_potato), 0.35f);
        this.addSmeltingRecipeForBlock(Blocks.netherrack, new ItemStack(Items.netherbrick), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.sponge, 1, 1), new ItemStack(Blocks.sponge, 1, 0), 0.15f);
        for (final ItemFishFood.FishType lllllllllllllllIlIlIIlllllIlIllI : ItemFishFood.FishType.values()) {
            if (lllllllllllllllIlIlIIlllllIlIllI.getCookable()) {
                this.addSmeltingRecipe(new ItemStack(Items.fish, 1, lllllllllllllllIlIlIIlllllIlIllI.getItemDamage()), new ItemStack(Items.cooked_fish, 1, lllllllllllllllIlIlIIlllllIlIllI.getItemDamage()), 0.35f);
            }
        }
        this.addSmeltingRecipeForBlock(Blocks.coal_ore, new ItemStack(Items.coal), 0.1f);
        this.addSmeltingRecipeForBlock(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7f);
        this.addSmeltingRecipeForBlock(Blocks.lapis_ore, new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeColorDamage()), 0.2f);
        this.addSmeltingRecipeForBlock(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2f);
    }
    
    private boolean func_151397_a(final ItemStack lllllllllllllllIlIlIIllllIIllIll, final ItemStack lllllllllllllllIlIlIIllllIIlllII) {
        return lllllllllllllllIlIlIIllllIIlllII.getItem() == lllllllllllllllIlIlIIllllIIllIll.getItem() && (lllllllllllllllIlIlIIllllIIlllII.getMetadata() == 32767 || lllllllllllllllIlIlIIllllIIlllII.getMetadata() == lllllllllllllllIlIlIIllllIIllIll.getMetadata());
    }
    
    public void addSmeltingRecipeForBlock(final Block lllllllllllllllIlIlIIlllllIIlIll, final ItemStack lllllllllllllllIlIlIIlllllIIIllI, final float lllllllllllllllIlIlIIlllllIIIlIl) {
        this.addSmelting(Item.getItemFromBlock(lllllllllllllllIlIlIIlllllIIlIll), lllllllllllllllIlIlIIlllllIIIllI, lllllllllllllllIlIlIIlllllIIIlIl);
    }
    
    public ItemStack getSmeltingResult(final ItemStack lllllllllllllllIlIlIIllllIlIIlll) {
        for (final Map.Entry lllllllllllllllIlIlIIllllIlIIlIl : this.smeltingList.entrySet()) {
            if (this.func_151397_a(lllllllllllllllIlIlIIllllIlIIlll, lllllllllllllllIlIlIIllllIlIIlIl.getKey())) {
                return lllllllllllllllIlIlIIllllIlIIlIl.getValue();
            }
        }
        return null;
    }
}
