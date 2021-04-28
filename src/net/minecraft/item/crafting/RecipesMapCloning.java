package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class RecipesMapCloning implements IRecipe
{
    @Override
    public boolean matches(final InventoryCrafting llllllllllllllIIllIlllIllIlIIIIl, final World llllllllllllllIIllIlllIllIlIIllI) {
        int llllllllllllllIIllIlllIllIlIIlIl = 0;
        ItemStack llllllllllllllIIllIlllIllIlIIlII = null;
        for (int llllllllllllllIIllIlllIllIlIIIll = 0; llllllllllllllIIllIlllIllIlIIIll < llllllllllllllIIllIlllIllIlIIIIl.getSizeInventory(); ++llllllllllllllIIllIlllIllIlIIIll) {
            final ItemStack llllllllllllllIIllIlllIllIlIIIlI = llllllllllllllIIllIlllIllIlIIIIl.getStackInSlot(llllllllllllllIIllIlllIllIlIIIll);
            if (llllllllllllllIIllIlllIllIlIIIlI != null) {
                if (llllllllllllllIIllIlllIllIlIIIlI.getItem() == Items.filled_map) {
                    if (llllllllllllllIIllIlllIllIlIIlII != null) {
                        return false;
                    }
                    llllllllllllllIIllIlllIllIlIIlII = llllllllllllllIIllIlllIllIlIIIlI;
                }
                else {
                    if (llllllllllllllIIllIlllIllIlIIIlI.getItem() != Items.map) {
                        return false;
                    }
                    ++llllllllllllllIIllIlllIllIlIIlIl;
                }
            }
        }
        return llllllllllllllIIllIlllIllIlIIlII != null && llllllllllllllIIllIlllIllIlIIlIl > 0;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
    
    @Override
    public int getRecipeSize() {
        return 9;
    }
    
    @Override
    public ItemStack[] func_179532_b(final InventoryCrafting llllllllllllllIIllIlllIllIIIIlII) {
        final ItemStack[] llllllllllllllIIllIlllIllIIIIIll = new ItemStack[llllllllllllllIIllIlllIllIIIIlII.getSizeInventory()];
        for (int llllllllllllllIIllIlllIllIIIIIlI = 0; llllllllllllllIIllIlllIllIIIIIlI < llllllllllllllIIllIlllIllIIIIIll.length; ++llllllllllllllIIllIlllIllIIIIIlI) {
            final ItemStack llllllllllllllIIllIlllIllIIIIIIl = llllllllllllllIIllIlllIllIIIIlII.getStackInSlot(llllllllllllllIIllIlllIllIIIIIlI);
            if (llllllllllllllIIllIlllIllIIIIIIl != null && llllllllllllllIIllIlllIllIIIIIIl.getItem().hasContainerItem()) {
                llllllllllllllIIllIlllIllIIIIIll[llllllllllllllIIllIlllIllIIIIIlI] = new ItemStack(llllllllllllllIIllIlllIllIIIIIIl.getItem().getContainerItem());
            }
        }
        return llllllllllllllIIllIlllIllIIIIIll;
    }
    
    static {
        __OBFID = "CL_00000087";
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllIIllIlllIllIIlIllI) {
        int llllllllllllllIIllIlllIllIIlIlIl = 0;
        ItemStack llllllllllllllIIllIlllIllIIlIlII = null;
        for (int llllllllllllllIIllIlllIllIIlIIll = 0; llllllllllllllIIllIlllIllIIlIIll < llllllllllllllIIllIlllIllIIlIllI.getSizeInventory(); ++llllllllllllllIIllIlllIllIIlIIll) {
            final ItemStack llllllllllllllIIllIlllIllIIlIIlI = llllllllllllllIIllIlllIllIIlIllI.getStackInSlot(llllllllllllllIIllIlllIllIIlIIll);
            if (llllllllllllllIIllIlllIllIIlIIlI != null) {
                if (llllllllllllllIIllIlllIllIIlIIlI.getItem() == Items.filled_map) {
                    if (llllllllllllllIIllIlllIllIIlIlII != null) {
                        return null;
                    }
                    llllllllllllllIIllIlllIllIIlIlII = llllllllllllllIIllIlllIllIIlIIlI;
                }
                else {
                    if (llllllllllllllIIllIlllIllIIlIIlI.getItem() != Items.map) {
                        return null;
                    }
                    ++llllllllllllllIIllIlllIllIIlIlIl;
                }
            }
        }
        if (llllllllllllllIIllIlllIllIIlIlII != null && llllllllllllllIIllIlllIllIIlIlIl >= 1) {
            final ItemStack llllllllllllllIIllIlllIllIIlIIIl = new ItemStack(Items.filled_map, llllllllllllllIIllIlllIllIIlIlIl + 1, llllllllllllllIIllIlllIllIIlIlII.getMetadata());
            if (llllllllllllllIIllIlllIllIIlIlII.hasDisplayName()) {
                llllllllllllllIIllIlllIllIIlIIIl.setStackDisplayName(llllllllllllllIIllIlllIllIIlIlII.getDisplayName());
            }
            return llllllllllllllIIllIlllIllIIlIIIl;
        }
        return null;
    }
}
