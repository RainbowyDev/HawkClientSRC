package net.minecraft.entity;

import net.minecraft.entity.player.*;
import net.minecraft.village.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public interface IMerchant
{
    void useRecipe(final MerchantRecipe p0);
    
    MerchantRecipeList getRecipes(final EntityPlayer p0);
    
    void setCustomer(final EntityPlayer p0);
    
    void verifySellingItem(final ItemStack p0);
    
    EntityPlayer getCustomer();
    
    void setRecipes(final MerchantRecipeList p0);
    
    IChatComponent getDisplayName();
}
