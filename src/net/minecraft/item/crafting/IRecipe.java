package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public interface IRecipe
{
    ItemStack[] func_179532_b(final InventoryCrafting p0);
    
    boolean matches(final InventoryCrafting p0, final World p1);
    
    int getRecipeSize();
    
    ItemStack getRecipeOutput();
    
    ItemStack getCraftingResult(final InventoryCrafting p0);
}
