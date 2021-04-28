package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;

public class RecipeBookCloning implements IRecipe
{
    @Override
    public int getRecipeSize() {
        return 9;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllllIIIIllIIlllllIlIl) {
        int lllllllllllllllIIIIllIIllllllIlI = 0;
        ItemStack lllllllllllllllIIIIllIIllllllIIl = null;
        for (int lllllllllllllllIIIIllIIllllllIII = 0; lllllllllllllllIIIIllIIllllllIII < lllllllllllllllIIIIllIIlllllIlIl.getSizeInventory(); ++lllllllllllllllIIIIllIIllllllIII) {
            final ItemStack lllllllllllllllIIIIllIIlllllIlll = lllllllllllllllIIIIllIIlllllIlIl.getStackInSlot(lllllllllllllllIIIIllIIllllllIII);
            if (lllllllllllllllIIIIllIIlllllIlll != null) {
                if (lllllllllllllllIIIIllIIlllllIlll.getItem() == Items.written_book) {
                    if (lllllllllllllllIIIIllIIllllllIIl != null) {
                        return null;
                    }
                    lllllllllllllllIIIIllIIllllllIIl = lllllllllllllllIIIIllIIlllllIlll;
                }
                else {
                    if (lllllllllllllllIIIIllIIlllllIlll.getItem() != Items.writable_book) {
                        return null;
                    }
                    ++lllllllllllllllIIIIllIIllllllIlI;
                }
            }
        }
        if (lllllllllllllllIIIIllIIllllllIIl != null && lllllllllllllllIIIIllIIllllllIlI >= 1 && ItemEditableBook.func_179230_h(lllllllllllllllIIIIllIIllllllIIl) < 2) {
            final ItemStack lllllllllllllllIIIIllIIlllllIllI = new ItemStack(Items.written_book, lllllllllllllllIIIIllIIllllllIlI);
            lllllllllllllllIIIIllIIlllllIllI.setTagCompound((NBTTagCompound)lllllllllllllllIIIIllIIllllllIIl.getTagCompound().copy());
            lllllllllllllllIIIIllIIlllllIllI.getTagCompound().setInteger("generation", ItemEditableBook.func_179230_h(lllllllllllllllIIIIllIIllllllIIl) + 1);
            if (lllllllllllllllIIIIllIIllllllIIl.hasDisplayName()) {
                lllllllllllllllIIIIllIIlllllIllI.setStackDisplayName(lllllllllllllllIIIIllIIllllllIIl.getDisplayName());
            }
            return lllllllllllllllIIIIllIIlllllIllI;
        }
        return null;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
    
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllllIIIIllIlIIIIIIllI, final World lllllllllllllllIIIIllIlIIIIIlIll) {
        int lllllllllllllllIIIIllIlIIIIIlIlI = 0;
        ItemStack lllllllllllllllIIIIllIlIIIIIlIIl = null;
        for (int lllllllllllllllIIIIllIlIIIIIlIII = 0; lllllllllllllllIIIIllIlIIIIIlIII < lllllllllllllllIIIIllIlIIIIIIllI.getSizeInventory(); ++lllllllllllllllIIIIllIlIIIIIlIII) {
            final ItemStack lllllllllllllllIIIIllIlIIIIIIlll = lllllllllllllllIIIIllIlIIIIIIllI.getStackInSlot(lllllllllllllllIIIIllIlIIIIIlIII);
            if (lllllllllllllllIIIIllIlIIIIIIlll != null) {
                if (lllllllllllllllIIIIllIlIIIIIIlll.getItem() == Items.written_book) {
                    if (lllllllllllllllIIIIllIlIIIIIlIIl != null) {
                        return false;
                    }
                    lllllllllllllllIIIIllIlIIIIIlIIl = lllllllllllllllIIIIllIlIIIIIIlll;
                }
                else {
                    if (lllllllllllllllIIIIllIlIIIIIIlll.getItem() != Items.writable_book) {
                        return false;
                    }
                    ++lllllllllllllllIIIIllIlIIIIIlIlI;
                }
            }
        }
        return lllllllllllllllIIIIllIlIIIIIlIIl != null && lllllllllllllllIIIIllIlIIIIIlIlI > 0;
    }
    
    @Override
    public ItemStack[] func_179532_b(final InventoryCrafting lllllllllllllllIIIIllIIllllIlIIl) {
        final ItemStack[] lllllllllllllllIIIIllIIllllIlIII = new ItemStack[lllllllllllllllIIIIllIIllllIlIIl.getSizeInventory()];
        for (int lllllllllllllllIIIIllIIllllIIlll = 0; lllllllllllllllIIIIllIIllllIIlll < lllllllllllllllIIIIllIIllllIlIII.length; ++lllllllllllllllIIIIllIIllllIIlll) {
            final ItemStack lllllllllllllllIIIIllIIllllIIllI = lllllllllllllllIIIIllIIllllIlIIl.getStackInSlot(lllllllllllllllIIIIllIIllllIIlll);
            if (lllllllllllllllIIIIllIIllllIIllI != null && lllllllllllllllIIIIllIIllllIIllI.getItem() instanceof ItemEditableBook) {
                lllllllllllllllIIIIllIIllllIlIII[lllllllllllllllIIIIllIIllllIIlll] = lllllllllllllllIIIIllIIllllIIllI;
                break;
            }
        }
        return lllllllllllllllIIIIllIIllllIlIII;
    }
    
    static {
        __OBFID = "CL_00000081";
    }
}
