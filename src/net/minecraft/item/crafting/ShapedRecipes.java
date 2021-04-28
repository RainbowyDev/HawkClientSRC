package net.minecraft.item.crafting;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;

public class ShapedRecipes implements IRecipe
{
    private final /* synthetic */ ItemStack[] recipeItems;
    private final /* synthetic */ int recipeHeight;
    private /* synthetic */ boolean field_92101_f;
    private final /* synthetic */ ItemStack recipeOutput;
    private final /* synthetic */ int recipeWidth;
    
    public ShapedRecipes(final int lIIIllIIIllII, final int lIIIllIIIlIll, final ItemStack[] lIIIllIIIIlIl, final ItemStack lIIIllIIIIlII) {
        this.recipeWidth = lIIIllIIIllII;
        this.recipeHeight = lIIIllIIIlIll;
        this.recipeItems = lIIIllIIIIlIl;
        this.recipeOutput = lIIIllIIIIlII;
    }
    
    @Override
    public int getRecipeSize() {
        return this.recipeWidth * this.recipeHeight;
    }
    
    public ShapedRecipes func_92100_c() {
        this.field_92101_f = true;
        return this;
    }
    
    @Override
    public ItemStack[] func_179532_b(final InventoryCrafting lIIIlIlllIlll) {
        final ItemStack[] lIIIlIllllIlI = new ItemStack[lIIIlIlllIlll.getSizeInventory()];
        for (int lIIIlIllllIIl = 0; lIIIlIllllIIl < lIIIlIllllIlI.length; ++lIIIlIllllIIl) {
            final ItemStack lIIIlIllllIII = lIIIlIlllIlll.getStackInSlot(lIIIlIllllIIl);
            if (lIIIlIllllIII != null && lIIIlIllllIII.getItem().hasContainerItem()) {
                lIIIlIllllIlI[lIIIlIllllIIl] = new ItemStack(lIIIlIllllIII.getItem().getContainerItem());
            }
        }
        return lIIIlIllllIlI;
    }
    
    private boolean checkMatch(final InventoryCrafting lIIIlIlIllIlI, final int lIIIlIlIllIIl, final int lIIIlIlIIllIl, final boolean lIIIlIlIlIlll) {
        for (int lIIIlIlIlIllI = 0; lIIIlIlIlIllI < 3; ++lIIIlIlIlIllI) {
            for (int lIIIlIlIlIlIl = 0; lIIIlIlIlIlIl < 3; ++lIIIlIlIlIlIl) {
                final int lIIIlIlIlIlII = lIIIlIlIlIllI - lIIIlIlIllIIl;
                final int lIIIlIlIlIIll = lIIIlIlIlIlIl - lIIIlIlIIllIl;
                ItemStack lIIIlIlIlIIlI = null;
                if (lIIIlIlIlIlII >= 0 && lIIIlIlIlIIll >= 0 && lIIIlIlIlIlII < this.recipeWidth && lIIIlIlIlIIll < this.recipeHeight) {
                    if (lIIIlIlIlIlll) {
                        lIIIlIlIlIIlI = this.recipeItems[this.recipeWidth - lIIIlIlIlIlII - 1 + lIIIlIlIlIIll * this.recipeWidth];
                    }
                    else {
                        lIIIlIlIlIIlI = this.recipeItems[lIIIlIlIlIlII + lIIIlIlIlIIll * this.recipeWidth];
                    }
                }
                final ItemStack lIIIlIlIlIIIl = lIIIlIlIllIlI.getStackInRowAndColumn(lIIIlIlIlIllI, lIIIlIlIlIlIl);
                if (lIIIlIlIlIIIl != null || lIIIlIlIlIIlI != null) {
                    if ((lIIIlIlIlIIIl == null && lIIIlIlIlIIlI != null) || (lIIIlIlIlIIIl != null && lIIIlIlIlIIlI == null)) {
                        return false;
                    }
                    if (lIIIlIlIlIIlI.getItem() != lIIIlIlIlIIIl.getItem()) {
                        return false;
                    }
                    if (lIIIlIlIlIIlI.getMetadata() != 32767 && lIIIlIlIlIIlI.getMetadata() != lIIIlIlIlIIIl.getMetadata()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lIIIlIIlllIlI) {
        final ItemStack lIIIlIIlllllI = this.getRecipeOutput().copy();
        if (this.field_92101_f) {
            for (int lIIIlIIllllIl = 0; lIIIlIIllllIl < lIIIlIIlllIlI.getSizeInventory(); ++lIIIlIIllllIl) {
                final ItemStack lIIIlIIllllII = lIIIlIIlllIlI.getStackInSlot(lIIIlIIllllIl);
                if (lIIIlIIllllII != null && lIIIlIIllllII.hasTagCompound()) {
                    lIIIlIIlllllI.setTagCompound((NBTTagCompound)lIIIlIIllllII.getTagCompound().copy());
                }
            }
        }
        return lIIIlIIlllllI;
    }
    
    @Override
    public boolean matches(final InventoryCrafting lIIIlIllIlIIl, final World lIIIlIllIllIl) {
        for (int lIIIlIllIllII = 0; lIIIlIllIllII <= 3 - this.recipeWidth; ++lIIIlIllIllII) {
            for (int lIIIlIllIlIll = 0; lIIIlIllIlIll <= 3 - this.recipeHeight; ++lIIIlIllIlIll) {
                if (this.checkMatch(lIIIlIllIlIIl, lIIIlIllIllII, lIIIlIllIlIll, true)) {
                    return true;
                }
                if (this.checkMatch(lIIIlIllIlIIl, lIIIlIllIllII, lIIIlIllIlIll, false)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }
    
    static {
        __OBFID = "CL_00000093";
    }
}
