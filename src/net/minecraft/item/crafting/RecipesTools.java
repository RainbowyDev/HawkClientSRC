package net.minecraft.item.crafting;

import net.minecraft.item.*;
import net.minecraft.init.*;

public class RecipesTools
{
    private /* synthetic */ String[][] recipePatterns;
    private /* synthetic */ Object[][] recipeItems;
    
    static {
        __OBFID = "CL_00000096";
    }
    
    public void addRecipes(final CraftingManager llllllllllllllllIIIlIIIIIlllIIII) {
        for (int llllllllllllllllIIIlIIIIIllIllll = 0; llllllllllllllllIIIlIIIIIllIllll < this.recipeItems[0].length; ++llllllllllllllllIIIlIIIIIllIllll) {
            final Object llllllllllllllllIIIlIIIIIllIlllI = this.recipeItems[0][llllllllllllllllIIIlIIIIIllIllll];
            for (int llllllllllllllllIIIlIIIIIllIllIl = 0; llllllllllllllllIIIlIIIIIllIllIl < this.recipeItems.length - 1; ++llllllllllllllllIIIlIIIIIllIllIl) {
                final Item llllllllllllllllIIIlIIIIIllIllII = (Item)this.recipeItems[llllllllllllllllIIIlIIIIIllIllIl + 1][llllllllllllllllIIIlIIIIIllIllll];
                llllllllllllllllIIIlIIIIIlllIIII.addRecipe(new ItemStack(llllllllllllllllIIIlIIIIIllIllII), this.recipePatterns[llllllllllllllllIIIlIIIIIllIllIl], '#', Items.stick, 'X', llllllllllllllllIIIlIIIIIllIlllI);
            }
        }
        llllllllllllllllIIIlIIIIIlllIIII.addRecipe(new ItemStack(Items.shears), " #", "# ", '#', Items.iron_ingot);
    }
    
    public RecipesTools() {
        this.recipePatterns = new String[][] { { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
        this.recipeItems = new Object[][] { { Blocks.planks, Blocks.cobblestone, Items.iron_ingot, Items.diamond, Items.gold_ingot }, { Items.wooden_pickaxe, Items.stone_pickaxe, Items.iron_pickaxe, Items.diamond_pickaxe, Items.golden_pickaxe }, { Items.wooden_shovel, Items.stone_shovel, Items.iron_shovel, Items.diamond_shovel, Items.golden_shovel }, { Items.wooden_axe, Items.stone_axe, Items.iron_axe, Items.diamond_axe, Items.golden_axe }, { Items.wooden_hoe, Items.stone_hoe, Items.iron_hoe, Items.diamond_hoe, Items.golden_hoe } };
    }
}
