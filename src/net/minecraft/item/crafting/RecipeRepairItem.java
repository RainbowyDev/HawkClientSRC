package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class RecipeRepairItem implements IRecipe
{
    @Override
    public ItemStack[] func_179532_b(final InventoryCrafting llllllllllllllIIlIlIIlIIlIllllll) {
        final ItemStack[] llllllllllllllIIlIlIIlIIllIIIlIl = new ItemStack[llllllllllllllIIlIlIIlIIlIllllll.getSizeInventory()];
        for (int llllllllllllllIIlIlIIlIIllIIIIll = 0; llllllllllllllIIlIlIIlIIllIIIIll < llllllllllllllIIlIlIIlIIllIIIlIl.length; ++llllllllllllllIIlIlIIlIIllIIIIll) {
            final ItemStack llllllllllllllIIlIlIIlIIllIIIIIl = llllllllllllllIIlIlIIlIIlIllllll.getStackInSlot(llllllllllllllIIlIlIIlIIllIIIIll);
            if (llllllllllllllIIlIlIIlIIllIIIIIl != null && llllllllllllllIIlIlIIlIIllIIIIIl.getItem().hasContainerItem()) {
                llllllllllllllIIlIlIIlIIllIIIlIl[llllllllllllllIIlIlIIlIIllIIIIll] = new ItemStack(llllllllllllllIIlIlIIlIIllIIIIIl.getItem().getContainerItem());
            }
        }
        return llllllllllllllIIlIlIIlIIllIIIlIl;
    }
    
    static {
        __OBFID = "CL_00002156";
    }
    
    @Override
    public int getRecipeSize() {
        return 4;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllIIlIlIIlIIllllllII) {
        final ArrayList llllllllllllllIIlIlIIlIIlllllIll = Lists.newArrayList();
        for (int llllllllllllllIIlIlIIlIIllllIlIl = 0; llllllllllllllIIlIlIIlIIllllIlIl < llllllllllllllIIlIlIIlIIllllllII.getSizeInventory(); ++llllllllllllllIIlIlIIlIIllllIlIl) {
            final ItemStack llllllllllllllIIlIlIIlIIlllllIIl = llllllllllllllIIlIlIIlIIllllllII.getStackInSlot(llllllllllllllIIlIlIIlIIllllIlIl);
            if (llllllllllllllIIlIlIIlIIlllllIIl != null) {
                llllllllllllllIIlIlIIlIIlllllIll.add(llllllllllllllIIlIlIIlIIlllllIIl);
                if (llllllllllllllIIlIlIIlIIlllllIll.size() > 1) {
                    final ItemStack llllllllllllllIIlIlIIlIIllllIIll = llllllllllllllIIlIlIIlIIlllllIll.get(0);
                    if (llllllllllllllIIlIlIIlIIlllllIIl.getItem() != llllllllllllllIIlIlIIlIIllllIIll.getItem() || llllllllllllllIIlIlIIlIIllllIIll.stackSize != 1 || llllllllllllllIIlIlIIlIIlllllIIl.stackSize != 1 || !llllllllllllllIIlIlIIlIIllllIIll.getItem().isDamageable()) {
                        return null;
                    }
                }
            }
        }
        if (llllllllllllllIIlIlIIlIIlllllIll.size() == 2) {
            final ItemStack llllllllllllllIIlIlIIlIIllllIIIl = llllllllllllllIIlIlIIlIIlllllIll.get(0);
            final ItemStack llllllllllllllIIlIlIIlIIllllIlll = llllllllllllllIIlIlIIlIIlllllIll.get(1);
            if (llllllllllllllIIlIlIIlIIllllIIIl.getItem() == llllllllllllllIIlIlIIlIIllllIlll.getItem() && llllllllllllllIIlIlIIlIIllllIIIl.stackSize == 1 && llllllllllllllIIlIlIIlIIllllIlll.stackSize == 1 && llllllllllllllIIlIlIIlIIllllIIIl.getItem().isDamageable()) {
                final Item llllllllllllllIIlIlIIlIIlllIllll = llllllllllllllIIlIlIIlIIllllIIIl.getItem();
                final int llllllllllllllIIlIlIIlIIlllIlllI = llllllllllllllIIlIlIIlIIlllIllll.getMaxDamage() - llllllllllllllIIlIlIIlIIllllIIIl.getItemDamage();
                final int llllllllllllllIIlIlIIlIIlllIllIl = llllllllllllllIIlIlIIlIIlllIllll.getMaxDamage() - llllllllllllllIIlIlIIlIIllllIlll.getItemDamage();
                final int llllllllllllllIIlIlIIlIIlllIlIll = llllllllllllllIIlIlIIlIIlllIlllI + llllllllllllllIIlIlIIlIIlllIllIl + llllllllllllllIIlIlIIlIIlllIllll.getMaxDamage() * 5 / 100;
                int llllllllllllllIIlIlIIlIIlllIlIIl = llllllllllllllIIlIlIIlIIlllIllll.getMaxDamage() - llllllllllllllIIlIlIIlIIlllIlIll;
                if (llllllllllllllIIlIlIIlIIlllIlIIl < 0) {
                    llllllllllllllIIlIlIIlIIlllIlIIl = 0;
                }
                return new ItemStack(llllllllllllllIIlIlIIlIIllllIIIl.getItem(), 1, llllllllllllllIIlIlIIlIIlllIlIIl);
            }
        }
        return null;
    }
    
    @Override
    public boolean matches(final InventoryCrafting llllllllllllllIIlIlIIlIlIIlIllII, final World llllllllllllllIIlIlIIlIlIIlIlIll) {
        final ArrayList llllllllllllllIIlIlIIlIlIIlIlIlI = Lists.newArrayList();
        for (int llllllllllllllIIlIlIIlIlIIlIlIIl = 0; llllllllllllllIIlIlIIlIlIIlIlIIl < llllllllllllllIIlIlIIlIlIIlIllII.getSizeInventory(); ++llllllllllllllIIlIlIIlIlIIlIlIIl) {
            final ItemStack llllllllllllllIIlIlIIlIlIIlIlIII = llllllllllllllIIlIlIIlIlIIlIllII.getStackInSlot(llllllllllllllIIlIlIIlIlIIlIlIIl);
            if (llllllllllllllIIlIlIIlIlIIlIlIII != null) {
                llllllllllllllIIlIlIIlIlIIlIlIlI.add(llllllllllllllIIlIlIIlIlIIlIlIII);
                if (llllllllllllllIIlIlIIlIlIIlIlIlI.size() > 1) {
                    final ItemStack llllllllllllllIIlIlIIlIlIIlIIllI = llllllllllllllIIlIlIIlIlIIlIlIlI.get(0);
                    if (llllllllllllllIIlIlIIlIlIIlIlIII.getItem() != llllllllllllllIIlIlIIlIlIIlIIllI.getItem() || llllllllllllllIIlIlIIlIlIIlIIllI.stackSize != 1 || llllllllllllllIIlIlIIlIlIIlIlIII.stackSize != 1 || !llllllllllllllIIlIlIIlIlIIlIIllI.getItem().isDamageable()) {
                        return false;
                    }
                }
            }
        }
        return llllllllllllllIIlIlIIlIlIIlIlIlI.size() == 2;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}
