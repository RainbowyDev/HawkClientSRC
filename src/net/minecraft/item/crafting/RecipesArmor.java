package net.minecraft.item.crafting;

import net.minecraft.init.*;
import net.minecraft.item.*;

public class RecipesArmor
{
    private /* synthetic */ Item[][] recipeItems;
    private /* synthetic */ String[][] recipePatterns;
    
    public RecipesArmor() {
        this.recipePatterns = new String[][] { { "XXX", "X X" }, { "X X", "XXX", "XXX" }, { "XXX", "X X", "X X" }, { "X X", "X X" } };
        this.recipeItems = new Item[][] { { Items.leather, Items.iron_ingot, Items.diamond, Items.gold_ingot }, { Items.leather_helmet, Items.iron_helmet, Items.diamond_helmet, Items.golden_helmet }, { Items.leather_chestplate, Items.iron_chestplate, Items.diamond_chestplate, Items.golden_chestplate }, { Items.leather_leggings, Items.iron_leggings, Items.diamond_leggings, Items.golden_leggings }, { Items.leather_boots, Items.iron_boots, Items.diamond_boots, Items.golden_boots } };
    }
    
    public void addRecipes(final CraftingManager llllllllllllllIIIIIIlIIllIllIIIl) {
        for (int llllllllllllllIIIIIIlIIllIllIllI = 0; llllllllllllllIIIIIIlIIllIllIllI < this.recipeItems[0].length; ++llllllllllllllIIIIIIlIIllIllIllI) {
            final Item llllllllllllllIIIIIIlIIllIllIlIl = this.recipeItems[0][llllllllllllllIIIIIIlIIllIllIllI];
            for (int llllllllllllllIIIIIIlIIllIllIlII = 0; llllllllllllllIIIIIIlIIllIllIlII < this.recipeItems.length - 1; ++llllllllllllllIIIIIIlIIllIllIlII) {
                final Item llllllllllllllIIIIIIlIIllIllIIll = this.recipeItems[llllllllllllllIIIIIIlIIllIllIlII + 1][llllllllllllllIIIIIIlIIllIllIllI];
                llllllllllllllIIIIIIlIIllIllIIIl.addRecipe(new ItemStack(llllllllllllllIIIIIIlIIllIllIIll), this.recipePatterns[llllllllllllllIIIIIIlIIllIllIlII], 'X', llllllllllllllIIIIIIlIIllIllIlIl);
            }
        }
    }
    
    static {
        __OBFID = "CL_00000080";
    }
}
