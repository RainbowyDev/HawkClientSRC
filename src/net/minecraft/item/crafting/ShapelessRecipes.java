package net.minecraft.item.crafting;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import java.util.*;

public class ShapelessRecipes implements IRecipe
{
    private final /* synthetic */ List recipeItems;
    private final /* synthetic */ ItemStack recipeOutput;
    
    @Override
    public ItemStack[] func_179532_b(final InventoryCrafting lllllllllllllllllIlIllllIIIIIllI) {
        final ItemStack[] lllllllllllllllllIlIllllIIIIlIIl = new ItemStack[lllllllllllllllllIlIllllIIIIIllI.getSizeInventory()];
        for (int lllllllllllllllllIlIllllIIIIlIII = 0; lllllllllllllllllIlIllllIIIIlIII < lllllllllllllllllIlIllllIIIIlIIl.length; ++lllllllllllllllllIlIllllIIIIlIII) {
            final ItemStack lllllllllllllllllIlIllllIIIIIlll = lllllllllllllllllIlIllllIIIIIllI.getStackInSlot(lllllllllllllllllIlIllllIIIIlIII);
            if (lllllllllllllllllIlIllllIIIIIlll != null && lllllllllllllllllIlIllllIIIIIlll.getItem().hasContainerItem()) {
                lllllllllllllllllIlIllllIIIIlIIl[lllllllllllllllllIlIllllIIIIlIII] = new ItemStack(lllllllllllllllllIlIllllIIIIIlll.getItem().getContainerItem());
            }
        }
        return lllllllllllllllllIlIllllIIIIlIIl;
    }
    
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllllllIlIlllIlllIlllI, final World lllllllllllllllllIlIlllIllllIlll) {
        final ArrayList lllllllllllllllllIlIlllIllllIllI = Lists.newArrayList((Iterable)this.recipeItems);
        for (int lllllllllllllllllIlIlllIllllIlIl = 0; lllllllllllllllllIlIlllIllllIlIl < lllllllllllllllllIlIlllIlllIlllI.func_174923_h(); ++lllllllllllllllllIlIlllIllllIlIl) {
            for (int lllllllllllllllllIlIlllIllllIlII = 0; lllllllllllllllllIlIlllIllllIlII < lllllllllllllllllIlIlllIlllIlllI.func_174922_i(); ++lllllllllllllllllIlIlllIllllIlII) {
                final ItemStack lllllllllllllllllIlIlllIllllIIll = lllllllllllllllllIlIlllIlllIlllI.getStackInRowAndColumn(lllllllllllllllllIlIlllIllllIlII, lllllllllllllllllIlIlllIllllIlIl);
                if (lllllllllllllllllIlIlllIllllIIll != null) {
                    boolean lllllllllllllllllIlIlllIllllIIlI = false;
                    for (final ItemStack lllllllllllllllllIlIlllIllllIIII : lllllllllllllllllIlIlllIllllIllI) {
                        if (lllllllllllllllllIlIlllIllllIIll.getItem() == lllllllllllllllllIlIlllIllllIIII.getItem() && (lllllllllllllllllIlIlllIllllIIII.getMetadata() == 32767 || lllllllllllllllllIlIlllIllllIIll.getMetadata() == lllllllllllllllllIlIlllIllllIIII.getMetadata())) {
                            lllllllllllllllllIlIlllIllllIIlI = true;
                            lllllllllllllllllIlIlllIllllIllI.remove(lllllllllllllllllIlIlllIllllIIII);
                            break;
                        }
                    }
                    if (!lllllllllllllllllIlIlllIllllIIlI) {
                        return false;
                    }
                }
            }
        }
        return lllllllllllllllllIlIlllIllllIllI.isEmpty();
    }
    
    public ShapelessRecipes(final ItemStack lllllllllllllllllIlIllllIIIlIlll, final List lllllllllllllllllIlIllllIIIlIllI) {
        this.recipeOutput = lllllllllllllllllIlIllllIIIlIlll;
        this.recipeItems = lllllllllllllllllIlIllllIIIlIllI;
    }
    
    @Override
    public int getRecipeSize() {
        return this.recipeItems.size();
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllllllIlIlllIlllIIlII) {
        return this.recipeOutput.copy();
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }
    
    static {
        __OBFID = "CL_00000094";
    }
}
