package net.minecraft.item.crafting;

import net.minecraft.init.*;
import net.minecraft.item.*;

public class RecipesWeapons
{
    private /* synthetic */ Object[][] recipeItems;
    private /* synthetic */ String[][] recipePatterns;
    
    public RecipesWeapons() {
        this.recipePatterns = new String[][] { { "X", "X", "#" } };
        this.recipeItems = new Object[][] { { Blocks.planks, Blocks.cobblestone, Items.iron_ingot, Items.diamond, Items.gold_ingot }, { Items.wooden_sword, Items.stone_sword, Items.iron_sword, Items.diamond_sword, Items.golden_sword } };
    }
    
    static {
        __OBFID = "CL_00000097";
    }
    
    public void addRecipes(final CraftingManager llllllllllllllllIllIIIlIlIIllIlI) {
        for (int llllllllllllllllIllIIIlIlIIllIIl = 0; llllllllllllllllIllIIIlIlIIllIIl < this.recipeItems[0].length; ++llllllllllllllllIllIIIlIlIIllIIl) {
            final Object llllllllllllllllIllIIIlIlIIllIII = this.recipeItems[0][llllllllllllllllIllIIIlIlIIllIIl];
            for (int llllllllllllllllIllIIIlIlIIlIlll = 0; llllllllllllllllIllIIIlIlIIlIlll < this.recipeItems.length - 1; ++llllllllllllllllIllIIIlIlIIlIlll) {
                final Item llllllllllllllllIllIIIlIlIIlIllI = (Item)this.recipeItems[llllllllllllllllIllIIIlIlIIlIlll + 1][llllllllllllllllIllIIIlIlIIllIIl];
                llllllllllllllllIllIIIlIlIIllIlI.addRecipe(new ItemStack(llllllllllllllllIllIIIlIlIIlIllI), this.recipePatterns[llllllllllllllllIllIIIlIlIIlIlll], '#', Items.stick, 'X', llllllllllllllllIllIIIlIlIIllIII);
            }
        }
        llllllllllllllllIllIIIlIlIIllIlI.addRecipe(new ItemStack(Items.bow, 1), " #X", "# X", " #X", 'X', Items.string, '#', Items.stick);
        llllllllllllllllIllIIIlIlIIllIlI.addRecipe(new ItemStack(Items.arrow, 4), "X", "#", "Y", 'Y', Items.feather, 'X', Items.flint, '#', Items.stick);
    }
}
