package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.passive.*;

public class RecipesArmorDyes implements IRecipe
{
    @Override
    public int getRecipeSize() {
        return 10;
    }
    
    @Override
    public boolean matches(final InventoryCrafting llllllllllllllIIIllllIlllllIIIIl, final World llllllllllllllIIIllllIlllllIlIIl) {
        ItemStack llllllllllllllIIIllllIlllllIlIII = null;
        final ArrayList llllllllllllllIIIllllIlllllIIllI = Lists.newArrayList();
        for (int llllllllllllllIIIllllIlllllIIlII = 0; llllllllllllllIIIllllIlllllIIlII < llllllllllllllIIIllllIlllllIIIIl.getSizeInventory(); ++llllllllllllllIIIllllIlllllIIlII) {
            final ItemStack llllllllllllllIIIllllIlllllIIIll = llllllllllllllIIIllllIlllllIIIIl.getStackInSlot(llllllllllllllIIIllllIlllllIIlII);
            if (llllllllllllllIIIllllIlllllIIIll != null) {
                if (llllllllllllllIIIllllIlllllIIIll.getItem() instanceof ItemArmor) {
                    final ItemArmor llllllllllllllIIIllllIlllllIIIlI = (ItemArmor)llllllllllllllIIIllllIlllllIIIll.getItem();
                    if (llllllllllllllIIIllllIlllllIIIlI.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER || llllllllllllllIIIllllIlllllIlIII != null) {
                        return false;
                    }
                    llllllllllllllIIIllllIlllllIlIII = llllllllllllllIIIllllIlllllIIIll;
                }
                else {
                    if (llllllllllllllIIIllllIlllllIIIll.getItem() != Items.dye) {
                        return false;
                    }
                    llllllllllllllIIIllllIlllllIIllI.add(llllllllllllllIIIllllIlllllIIIll);
                }
            }
        }
        return llllllllllllllIIIllllIlllllIlIII != null && !llllllllllllllIIIllllIlllllIIllI.isEmpty();
    }
    
    @Override
    public ItemStack[] func_179532_b(final InventoryCrafting llllllllllllllIIIllllIllIlIIllll) {
        final ItemStack[] llllllllllllllIIIllllIllIlIIlllI = new ItemStack[llllllllllllllIIIllllIllIlIIllll.getSizeInventory()];
        for (int llllllllllllllIIIllllIllIlIIllII = 0; llllllllllllllIIIllllIllIlIIllII < llllllllllllllIIIllllIllIlIIlllI.length; ++llllllllllllllIIIllllIllIlIIllII) {
            final ItemStack llllllllllllllIIIllllIllIlIIlIlI = llllllllllllllIIIllllIllIlIIllll.getStackInSlot(llllllllllllllIIIllllIllIlIIllII);
            if (llllllllllllllIIIllllIllIlIIlIlI != null && llllllllllllllIIIllllIllIlIIlIlI.getItem().hasContainerItem()) {
                llllllllllllllIIIllllIllIlIIlllI[llllllllllllllIIIllllIllIlIIllII] = new ItemStack(llllllllllllllIIIllllIllIlIIlIlI.getItem().getContainerItem());
            }
        }
        return llllllllllllllIIIllllIllIlIIlllI;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
    
    static {
        __OBFID = "CL_00000079";
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllIIIllllIlllIlIIIIl) {
        ItemStack llllllllllllllIIIllllIlllIlIIIII = null;
        final int[] llllllllllllllIIIllllIlllIIlllll = new int[3];
        int llllllllllllllIIIllllIlllIIllllI = 0;
        int llllllllllllllIIIllllIlllIIlllIl = 0;
        ItemArmor llllllllllllllIIIllllIlllIIlllII = null;
        for (int llllllllllllllIIIllllIlllIIllIll = 0; llllllllllllllIIIllllIlllIIllIll < llllllllllllllIIIllllIlllIlIIIIl.getSizeInventory(); ++llllllllllllllIIIllllIlllIIllIll) {
            final ItemStack llllllllllllllIIIllllIlllIIIllIl = llllllllllllllIIIllllIlllIlIIIIl.getStackInSlot(llllllllllllllIIIllllIlllIIllIll);
            if (llllllllllllllIIIllllIlllIIIllIl != null) {
                if (llllllllllllllIIIllllIlllIIIllIl.getItem() instanceof ItemArmor) {
                    llllllllllllllIIIllllIlllIIlllII = (ItemArmor)llllllllllllllIIIllllIlllIIIllIl.getItem();
                    if (llllllllllllllIIIllllIlllIIlllII.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER || llllllllllllllIIIllllIlllIlIIIII != null) {
                        return null;
                    }
                    llllllllllllllIIIllllIlllIlIIIII = llllllllllllllIIIllllIlllIIIllIl.copy();
                    llllllllllllllIIIllllIlllIlIIIII.stackSize = 1;
                    if (llllllllllllllIIIllllIlllIIlllII.hasColor(llllllllllllllIIIllllIlllIIIllIl)) {
                        final int llllllllllllllIIIllllIlllIIllIlI = llllllllllllllIIIllllIlllIIlllII.getColor(llllllllllllllIIIllllIlllIlIIIII);
                        final float llllllllllllllIIIllllIlllIIllIII = (llllllllllllllIIIllllIlllIIllIlI >> 16 & 0xFF) / 255.0f;
                        final float llllllllllllllIIIllllIlllIIlIlIl = (llllllllllllllIIIllllIlllIIllIlI >> 8 & 0xFF) / 255.0f;
                        final float llllllllllllllIIIllllIlllIIIlIll = (llllllllllllllIIIllllIlllIIllIlI & 0xFF) / 255.0f;
                        llllllllllllllIIIllllIlllIIllllI += (int)(Math.max(llllllllllllllIIIllllIlllIIllIII, Math.max(llllllllllllllIIIllllIlllIIlIlIl, llllllllllllllIIIllllIlllIIIlIll)) * 255.0f);
                        llllllllllllllIIIllllIlllIIlllll[0] += (int)(llllllllllllllIIIllllIlllIIllIII * 255.0f);
                        llllllllllllllIIIllllIlllIIlllll[1] += (int)(llllllllllllllIIIllllIlllIIlIlIl * 255.0f);
                        llllllllllllllIIIllllIlllIIlllll[2] += (int)(llllllllllllllIIIllllIlllIIIlIll * 255.0f);
                        ++llllllllllllllIIIllllIlllIIlllIl;
                    }
                }
                else {
                    if (llllllllllllllIIIllllIlllIIIllIl.getItem() != Items.dye) {
                        return null;
                    }
                    final float[] llllllllllllllIIIllllIlllIIIlIIl = EntitySheep.func_175513_a(EnumDyeColor.func_176766_a(llllllllllllllIIIllllIlllIIIllIl.getMetadata()));
                    final int llllllllllllllIIIllllIlllIIIIlll = (int)(llllllllllllllIIIllllIlllIIIlIIl[0] * 255.0f);
                    final int llllllllllllllIIIllllIlllIIIIlIl = (int)(llllllllllllllIIIllllIlllIIIlIIl[1] * 255.0f);
                    final int llllllllllllllIIIllllIlllIIlIIIl = (int)(llllllllllllllIIIllllIlllIIIlIIl[2] * 255.0f);
                    llllllllllllllIIIllllIlllIIllllI += Math.max(llllllllllllllIIIllllIlllIIIIlll, Math.max(llllllllllllllIIIllllIlllIIIIlIl, llllllllllllllIIIllllIlllIIlIIIl));
                    final int[] array = llllllllllllllIIIllllIlllIIlllll;
                    final int n = 0;
                    array[n] += llllllllllllllIIIllllIlllIIIIlll;
                    final int[] array2 = llllllllllllllIIIllllIlllIIlllll;
                    final int n2 = 1;
                    array2[n2] += llllllllllllllIIIllllIlllIIIIlIl;
                    final int[] array3 = llllllllllllllIIIllllIlllIIlllll;
                    final int n3 = 2;
                    array3[n3] += llllllllllllllIIIllllIlllIIlIIIl;
                    ++llllllllllllllIIIllllIlllIIlllIl;
                }
            }
        }
        if (llllllllllllllIIIllllIlllIIlllII == null) {
            return null;
        }
        int llllllllllllllIIIllllIlllIIllIll = llllllllllllllIIIllllIlllIIlllll[0] / llllllllllllllIIIllllIlllIIlllIl;
        int llllllllllllllIIIllllIlllIIIIIll = llllllllllllllIIIllllIlllIIlllll[1] / llllllllllllllIIIllllIlllIIlllIl;
        int llllllllllllllIIIllllIlllIIllIIl = llllllllllllllIIIllllIlllIIlllll[2] / llllllllllllllIIIllllIlllIIlllIl;
        final float llllllllllllllIIIllllIlllIIlIlll = llllllllllllllIIIllllIlllIIllllI / (float)llllllllllllllIIIllllIlllIIlllIl;
        final float llllllllllllllIIIllllIlllIIlIIll = (float)Math.max(llllllllllllllIIIllllIlllIIllIll, Math.max(llllllllllllllIIIllllIlllIIIIIll, llllllllllllllIIIllllIlllIIllIIl));
        llllllllllllllIIIllllIlllIIllIll = (int)(llllllllllllllIIIllllIlllIIllIll * llllllllllllllIIIllllIlllIIlIlll / llllllllllllllIIIllllIlllIIlIIll);
        llllllllllllllIIIllllIlllIIIIIll = (int)(llllllllllllllIIIllllIlllIIIIIll * llllllllllllllIIIllllIlllIIlIlll / llllllllllllllIIIllllIlllIIlIIll);
        llllllllllllllIIIllllIlllIIllIIl = (int)(llllllllllllllIIIllllIlllIIllIIl * llllllllllllllIIIllllIlllIIlIlll / llllllllllllllIIIllllIlllIIlIIll);
        int llllllllllllllIIIllllIlllIIIllll = (llllllllllllllIIIllllIlllIIllIll << 8) + llllllllllllllIIIllllIlllIIIIIll;
        llllllllllllllIIIllllIlllIIIllll = (llllllllllllllIIIllllIlllIIIllll << 8) + llllllllllllllIIIllllIlllIIllIIl;
        llllllllllllllIIIllllIlllIIlllII.func_82813_b(llllllllllllllIIIllllIlllIlIIIII, llllllllllllllIIIllllIlllIIIllll);
        return llllllllllllllIIIllllIlllIlIIIII;
    }
}
