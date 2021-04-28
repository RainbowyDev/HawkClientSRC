package net.minecraft.item.crafting;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class RecipesIngots
{
    private /* synthetic */ Object[][] recipeItems;
    
    public void addRecipes(final CraftingManager llllllllllllllllIIlIlIlIllIlIIIl) {
        for (int llllllllllllllllIIlIlIlIllIlIlIl = 0; llllllllllllllllIIlIlIlIllIlIlIl < this.recipeItems.length; ++llllllllllllllllIIlIlIlIllIlIlIl) {
            final Block llllllllllllllllIIlIlIlIllIlIlII = (Block)this.recipeItems[llllllllllllllllIIlIlIlIllIlIlIl][0];
            final ItemStack llllllllllllllllIIlIlIlIllIlIIll = (ItemStack)this.recipeItems[llllllllllllllllIIlIlIlIllIlIlIl][1];
            llllllllllllllllIIlIlIlIllIlIIIl.addRecipe(new ItemStack(llllllllllllllllIIlIlIlIllIlIlII), "###", "###", "###", '#', llllllllllllllllIIlIlIlIllIlIIll);
            llllllllllllllllIIlIlIlIllIlIIIl.addRecipe(llllllllllllllllIIlIlIlIllIlIIll, "#", '#', llllllllllllllllIIlIlIlIllIlIlII);
        }
        llllllllllllllllIIlIlIlIllIlIIIl.addRecipe(new ItemStack(Items.gold_ingot), "###", "###", "###", '#', Items.gold_nugget);
        llllllllllllllllIIlIlIlIllIlIIIl.addRecipe(new ItemStack(Items.gold_nugget, 9), "#", '#', Items.gold_ingot);
    }
    
    static {
        __OBFID = "CL_00000089";
    }
    
    public RecipesIngots() {
        this.recipeItems = new Object[][] { { Blocks.gold_block, new ItemStack(Items.gold_ingot, 9) }, { Blocks.iron_block, new ItemStack(Items.iron_ingot, 9) }, { Blocks.diamond_block, new ItemStack(Items.diamond, 9) }, { Blocks.emerald_block, new ItemStack(Items.emerald, 9) }, { Blocks.lapis_block, new ItemStack(Items.dye, 9, EnumDyeColor.BLUE.getDyeColorDamage()) }, { Blocks.redstone_block, new ItemStack(Items.redstone, 9) }, { Blocks.coal_block, new ItemStack(Items.coal, 9, 0) }, { Blocks.hay_block, new ItemStack(Items.wheat, 9) }, { Blocks.slime_block, new ItemStack(Items.slime_ball, 9) } };
    }
}
