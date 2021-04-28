package net.minecraft.item.crafting;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.inventory.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;

public class RecipesBanners
{
    void func_179534_a(final CraftingManager llllllllllllllIIlIllIllIIIIlllII) {
        for (final EnumDyeColor llllllllllllllIIlIllIllIIIIllIII : EnumDyeColor.values()) {
            llllllllllllllIIlIllIllIIIIlllII.addRecipe(new ItemStack(Items.banner, 1, llllllllllllllIIlIllIllIIIIllIII.getDyeColorDamage()), "###", "###", " | ", '#', new ItemStack(Blocks.wool, 1, llllllllllllllIIlIllIllIIIIllIII.func_176765_a()), '|', Items.stick);
        }
        llllllllllllllIIlIllIllIIIIlllII.func_180302_a(new RecipeDuplicatePattern(null));
        llllllllllllllIIlIllIllIIIIlllII.func_180302_a(new RecipeAddPattern(null));
    }
    
    static {
        __OBFID = "CL_00002160";
    }
    
    static class RecipeAddPattern implements IRecipe
    {
        private RecipeAddPattern() {
        }
        
        @Override
        public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllIlIIIllIlIlIlIIIIl) {
            ItemStack llllllllllllllIlIIIllIlIlIlIIIII = null;
            for (int llllllllllllllIlIIIllIlIlIIlllll = 0; llllllllllllllIlIIIllIlIlIIlllll < llllllllllllllIlIIIllIlIlIlIIIIl.getSizeInventory(); ++llllllllllllllIlIIIllIlIlIIlllll) {
                final ItemStack llllllllllllllIlIIIllIlIlIIllllI = llllllllllllllIlIIIllIlIlIlIIIIl.getStackInSlot(llllllllllllllIlIIIllIlIlIIlllll);
                if (llllllllllllllIlIIIllIlIlIIllllI != null && llllllllllllllIlIIIllIlIlIIllllI.getItem() == Items.banner) {
                    llllllllllllllIlIIIllIlIlIlIIIII = llllllllllllllIlIIIllIlIlIIllllI.copy();
                    llllllllllllllIlIIIllIlIlIlIIIII.stackSize = 1;
                    break;
                }
            }
            final TileEntityBanner.EnumBannerPattern llllllllllllllIlIIIllIlIlIIlllIl = this.func_179533_c(llllllllllllllIlIIIllIlIlIlIIIIl);
            if (llllllllllllllIlIIIllIlIlIIlllIl != null) {
                int llllllllllllllIlIIIllIlIlIIlllII = 0;
                for (int llllllllllllllIlIIIllIlIlIIllIIl = 0; llllllllllllllIlIIIllIlIlIIllIIl < llllllllllllllIlIIIllIlIlIlIIIIl.getSizeInventory(); ++llllllllllllllIlIIIllIlIlIIllIIl) {
                    final ItemStack llllllllllllllIlIIIllIlIlIIllIll = llllllllllllllIlIIIllIlIlIlIIIIl.getStackInSlot(llllllllllllllIlIIIllIlIlIIllIIl);
                    if (llllllllllllllIlIIIllIlIlIIllIll != null && llllllllllllllIlIIIllIlIlIIllIll.getItem() == Items.dye) {
                        llllllllllllllIlIIIllIlIlIIlllII = llllllllllllllIlIIIllIlIlIIllIll.getMetadata();
                        break;
                    }
                }
                final NBTTagCompound llllllllllllllIlIIIllIlIlIIllIII = llllllllllllllIlIIIllIlIlIlIIIII.getSubCompound("BlockEntityTag", true);
                final ItemStack llllllllllllllIlIIIllIlIlIIllIlI = null;
                NBTTagList llllllllllllllIlIIIllIlIlIIlIllI = null;
                if (llllllllllllllIlIIIllIlIlIIllIII.hasKey("Patterns", 9)) {
                    final NBTTagList llllllllllllllIlIIIllIlIlIIlIlll = llllllllllllllIlIIIllIlIlIIllIII.getTagList("Patterns", 10);
                }
                else {
                    llllllllllllllIlIIIllIlIlIIlIllI = new NBTTagList();
                    llllllllllllllIlIIIllIlIlIIllIII.setTag("Patterns", llllllllllllllIlIIIllIlIlIIlIllI);
                }
                final NBTTagCompound llllllllllllllIlIIIllIlIlIIlIlIl = new NBTTagCompound();
                llllllllllllllIlIIIllIlIlIIlIlIl.setString("Pattern", llllllllllllllIlIIIllIlIlIIlllIl.func_177273_b());
                llllllllllllllIlIIIllIlIlIIlIlIl.setInteger("Color", llllllllllllllIlIIIllIlIlIIlllII);
                llllllllllllllIlIIIllIlIlIIlIllI.appendTag(llllllllllllllIlIIIllIlIlIIlIlIl);
            }
            return llllllllllllllIlIIIllIlIlIlIIIII;
        }
        
        @Override
        public ItemStack getRecipeOutput() {
            return null;
        }
        
        @Override
        public ItemStack[] func_179532_b(final InventoryCrafting llllllllllllllIlIIIllIlIlIIIIlII) {
            final ItemStack[] llllllllllllllIlIIIllIlIlIIIIIll = new ItemStack[llllllllllllllIlIIIllIlIlIIIIlII.getSizeInventory()];
            for (int llllllllllllllIlIIIllIlIlIIIIIlI = 0; llllllllllllllIlIIIllIlIlIIIIIlI < llllllllllllllIlIIIllIlIlIIIIIll.length; ++llllllllllllllIlIIIllIlIlIIIIIlI) {
                final ItemStack llllllllllllllIlIIIllIlIlIIIIIIl = llllllllllllllIlIIIllIlIlIIIIlII.getStackInSlot(llllllllllllllIlIIIllIlIlIIIIIlI);
                if (llllllllllllllIlIIIllIlIlIIIIIIl != null && llllllllllllllIlIIIllIlIlIIIIIIl.getItem().hasContainerItem()) {
                    llllllllllllllIlIIIllIlIlIIIIIll[llllllllllllllIlIIIllIlIlIIIIIlI] = new ItemStack(llllllllllllllIlIIIllIlIlIIIIIIl.getItem().getContainerItem());
                }
            }
            return llllllllllllllIlIIIllIlIlIIIIIll;
        }
        
        private TileEntityBanner.EnumBannerPattern func_179533_c(final InventoryCrafting llllllllllllllIlIIIllIlIIlllIIII) {
            for (final TileEntityBanner.EnumBannerPattern llllllllllllllIlIIIllIlIIllIllII : TileEntityBanner.EnumBannerPattern.values()) {
                if (llllllllllllllIlIIIllIlIIllIllII.func_177270_d()) {
                    boolean llllllllllllllIlIIIllIlIIllIlIll = true;
                    if (llllllllllllllIlIIIllIlIIllIllII.func_177269_e()) {
                        boolean llllllllllllllIlIIIllIlIIllIlIII = false;
                        boolean llllllllllllllIlIIIllIlIIllIIlll = false;
                        for (int llllllllllllllIlIIIllIlIIllIlIlI = 0; llllllllllllllIlIIIllIlIIllIlIlI < llllllllllllllIlIIIllIlIIlllIIII.getSizeInventory() && llllllllllllllIlIIIllIlIIllIlIll; ++llllllllllllllIlIIIllIlIIllIlIlI) {
                            final ItemStack llllllllllllllIlIIIllIlIIllIIllI = llllllllllllllIlIIIllIlIIlllIIII.getStackInSlot(llllllllllllllIlIIIllIlIIllIlIlI);
                            if (llllllllllllllIlIIIllIlIIllIIllI != null && llllllllllllllIlIIIllIlIIllIIllI.getItem() != Items.banner) {
                                if (llllllllllllllIlIIIllIlIIllIIllI.getItem() == Items.dye) {
                                    if (llllllllllllllIlIIIllIlIIllIIlll) {
                                        llllllllllllllIlIIIllIlIIllIlIll = false;
                                        break;
                                    }
                                    llllllllllllllIlIIIllIlIIllIIlll = true;
                                }
                                else {
                                    if (llllllllllllllIlIIIllIlIIllIlIII || !llllllllllllllIlIIIllIlIIllIIllI.isItemEqual(llllllllllllllIlIIIllIlIIllIllII.func_177272_f())) {
                                        llllllllllllllIlIIIllIlIIllIlIll = false;
                                        break;
                                    }
                                    llllllllllllllIlIIIllIlIIllIlIII = true;
                                }
                            }
                        }
                        if (!llllllllllllllIlIIIllIlIIllIlIII) {
                            llllllllllllllIlIIIllIlIIllIlIll = false;
                        }
                    }
                    else if (llllllllllllllIlIIIllIlIIlllIIII.getSizeInventory() != llllllllllllllIlIIIllIlIIllIllII.func_177267_c().length * llllllllllllllIlIIIllIlIIllIllII.func_177267_c()[0].length()) {
                        llllllllllllllIlIIIllIlIIllIlIll = false;
                    }
                    else {
                        int llllllllllllllIlIIIllIlIIllIIlIl = -1;
                        for (int llllllllllllllIlIIIllIlIIllIIlII = 0; llllllllllllllIlIIIllIlIIllIIlII < llllllllllllllIlIIIllIlIIlllIIII.getSizeInventory() && llllllllllllllIlIIIllIlIIllIlIll; ++llllllllllllllIlIIIllIlIIllIIlII) {
                            final int llllllllllllllIlIIIllIlIIllIlIIl = llllllllllllllIlIIIllIlIIllIIlII / 3;
                            final int llllllllllllllIlIIIllIlIIllIIIll = llllllllllllllIlIIIllIlIIllIIlII % 3;
                            final ItemStack llllllllllllllIlIIIllIlIIllIIIlI = llllllllllllllIlIIIllIlIIlllIIII.getStackInSlot(llllllllllllllIlIIIllIlIIllIIlII);
                            if (llllllllllllllIlIIIllIlIIllIIIlI != null && llllllllllllllIlIIIllIlIIllIIIlI.getItem() != Items.banner) {
                                if (llllllllllllllIlIIIllIlIIllIIIlI.getItem() != Items.dye) {
                                    llllllllllllllIlIIIllIlIIllIlIll = false;
                                    break;
                                }
                                if (llllllllllllllIlIIIllIlIIllIIlIl != -1 && llllllllllllllIlIIIllIlIIllIIlIl != llllllllllllllIlIIIllIlIIllIIIlI.getMetadata()) {
                                    llllllllllllllIlIIIllIlIIllIlIll = false;
                                    break;
                                }
                                if (llllllllllllllIlIIIllIlIIllIllII.func_177267_c()[llllllllllllllIlIIIllIlIIllIlIIl].charAt(llllllllllllllIlIIIllIlIIllIIIll) == ' ') {
                                    llllllllllllllIlIIIllIlIIllIlIll = false;
                                    break;
                                }
                                llllllllllllllIlIIIllIlIIllIIlIl = llllllllllllllIlIIIllIlIIllIIIlI.getMetadata();
                            }
                            else if (llllllllllllllIlIIIllIlIIllIllII.func_177267_c()[llllllllllllllIlIIIllIlIIllIlIIl].charAt(llllllllllllllIlIIIllIlIIllIIIll) != ' ') {
                                llllllllllllllIlIIIllIlIIllIlIll = false;
                                break;
                            }
                        }
                    }
                    if (llllllllllllllIlIIIllIlIIllIlIll) {
                        return llllllllllllllIlIIIllIlIIllIllII;
                    }
                }
            }
            return null;
        }
        
        RecipeAddPattern(final Object llllllllllllllIlIIIllIlIIlIlIlII) {
            this();
        }
        
        static {
            __OBFID = "CL_00002158";
        }
        
        @Override
        public int getRecipeSize() {
            return 10;
        }
        
        @Override
        public boolean matches(final InventoryCrafting llllllllllllllIlIIIllIlIlIllIlIl, final World llllllllllllllIlIIIllIlIlIllIlII) {
            boolean llllllllllllllIlIIIllIlIlIllIIll = false;
            for (int llllllllllllllIlIIIllIlIlIllIIlI = 0; llllllllllllllIlIIIllIlIlIllIIlI < llllllllllllllIlIIIllIlIlIllIlIl.getSizeInventory(); ++llllllllllllllIlIIIllIlIlIllIIlI) {
                final ItemStack llllllllllllllIlIIIllIlIlIllIIIl = llllllllllllllIlIIIllIlIlIllIlIl.getStackInSlot(llllllllllllllIlIIIllIlIlIllIIlI);
                if (llllllllllllllIlIIIllIlIlIllIIIl != null && llllllllllllllIlIIIllIlIlIllIIIl.getItem() == Items.banner) {
                    if (llllllllllllllIlIIIllIlIlIllIIll) {
                        return false;
                    }
                    if (TileEntityBanner.func_175113_c(llllllllllllllIlIIIllIlIlIllIIIl) >= 6) {
                        return false;
                    }
                    llllllllllllllIlIIIllIlIlIllIIll = true;
                }
            }
            return llllllllllllllIlIIIllIlIlIllIIll && this.func_179533_c(llllllllllllllIlIIIllIlIlIllIlIl) != null;
        }
    }
    
    static class RecipeDuplicatePattern implements IRecipe
    {
        @Override
        public boolean matches(final InventoryCrafting lllllllllllllllllIIIIIlllIIllIII, final World lllllllllllllllllIIIIIlllIIlllll) {
            ItemStack lllllllllllllllllIIIIIlllIIllllI = null;
            ItemStack lllllllllllllllllIIIIIlllIIlllIl = null;
            for (int lllllllllllllllllIIIIIlllIIlllII = 0; lllllllllllllllllIIIIIlllIIlllII < lllllllllllllllllIIIIIlllIIllIII.getSizeInventory(); ++lllllllllllllllllIIIIIlllIIlllII) {
                final ItemStack lllllllllllllllllIIIIIlllIIllIll = lllllllllllllllllIIIIIlllIIllIII.getStackInSlot(lllllllllllllllllIIIIIlllIIlllII);
                if (lllllllllllllllllIIIIIlllIIllIll != null) {
                    if (lllllllllllllllllIIIIIlllIIllIll.getItem() != Items.banner) {
                        return false;
                    }
                    if (lllllllllllllllllIIIIIlllIIllllI != null && lllllllllllllllllIIIIIlllIIlllIl != null) {
                        return false;
                    }
                    final int lllllllllllllllllIIIIIlllIIllIlI = TileEntityBanner.getBaseColor(lllllllllllllllllIIIIIlllIIllIll);
                    final boolean lllllllllllllllllIIIIIlllIIllIIl = TileEntityBanner.func_175113_c(lllllllllllllllllIIIIIlllIIllIll) > 0;
                    if (lllllllllllllllllIIIIIlllIIllllI != null) {
                        if (lllllllllllllllllIIIIIlllIIllIIl) {
                            return false;
                        }
                        if (lllllllllllllllllIIIIIlllIIllIlI != TileEntityBanner.getBaseColor(lllllllllllllllllIIIIIlllIIllllI)) {
                            return false;
                        }
                        lllllllllllllllllIIIIIlllIIlllIl = lllllllllllllllllIIIIIlllIIllIll;
                    }
                    else if (lllllllllllllllllIIIIIlllIIlllIl != null) {
                        if (!lllllllllllllllllIIIIIlllIIllIIl) {
                            return false;
                        }
                        if (lllllllllllllllllIIIIIlllIIllIlI != TileEntityBanner.getBaseColor(lllllllllllllllllIIIIIlllIIlllIl)) {
                            return false;
                        }
                        lllllllllllllllllIIIIIlllIIllllI = lllllllllllllllllIIIIIlllIIllIll;
                    }
                    else if (lllllllllllllllllIIIIIlllIIllIIl) {
                        lllllllllllllllllIIIIIlllIIllllI = lllllllllllllllllIIIIIlllIIllIll;
                    }
                    else {
                        lllllllllllllllllIIIIIlllIIlllIl = lllllllllllllllllIIIIIlllIIllIll;
                    }
                }
            }
            return lllllllllllllllllIIIIIlllIIllllI != null && lllllllllllllllllIIIIIlllIIlllIl != null;
        }
        
        RecipeDuplicatePattern(final Object lllllllllllllllllIIIIIllIlllIIll) {
            this();
        }
        
        @Override
        public int getRecipeSize() {
            return 2;
        }
        
        @Override
        public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllllllIIIIIlllIIIlIII) {
            for (int lllllllllllllllllIIIIIlllIIIlIll = 0; lllllllllllllllllIIIIIlllIIIlIll < lllllllllllllllllIIIIIlllIIIlIII.getSizeInventory(); ++lllllllllllllllllIIIIIlllIIIlIll) {
                final ItemStack lllllllllllllllllIIIIIlllIIIlIlI = lllllllllllllllllIIIIIlllIIIlIII.getStackInSlot(lllllllllllllllllIIIIIlllIIIlIll);
                if (lllllllllllllllllIIIIIlllIIIlIlI != null && TileEntityBanner.func_175113_c(lllllllllllllllllIIIIIlllIIIlIlI) > 0) {
                    final ItemStack lllllllllllllllllIIIIIlllIIIlIIl = lllllllllllllllllIIIIIlllIIIlIlI.copy();
                    lllllllllllllllllIIIIIlllIIIlIIl.stackSize = 1;
                    return lllllllllllllllllIIIIIlllIIIlIIl;
                }
            }
            return null;
        }
        
        static {
            __OBFID = "CL_00002157";
        }
        
        private RecipeDuplicatePattern() {
        }
        
        @Override
        public ItemStack getRecipeOutput() {
            return null;
        }
        
        @Override
        public ItemStack[] func_179532_b(final InventoryCrafting lllllllllllllllllIIIIIllIlllllIl) {
            final ItemStack[] lllllllllllllllllIIIIIllIlllllII = new ItemStack[lllllllllllllllllIIIIIllIlllllIl.getSizeInventory()];
            for (int lllllllllllllllllIIIIIllIllllIll = 0; lllllllllllllllllIIIIIllIllllIll < lllllllllllllllllIIIIIllIlllllII.length; ++lllllllllllllllllIIIIIllIllllIll) {
                final ItemStack lllllllllllllllllIIIIIllIllllIlI = lllllllllllllllllIIIIIllIlllllIl.getStackInSlot(lllllllllllllllllIIIIIllIllllIll);
                if (lllllllllllllllllIIIIIllIllllIlI != null) {
                    if (lllllllllllllllllIIIIIllIllllIlI.getItem().hasContainerItem()) {
                        lllllllllllllllllIIIIIllIlllllII[lllllllllllllllllIIIIIllIllllIll] = new ItemStack(lllllllllllllllllIIIIIllIllllIlI.getItem().getContainerItem());
                    }
                    else if (lllllllllllllllllIIIIIllIllllIlI.hasTagCompound() && TileEntityBanner.func_175113_c(lllllllllllllllllIIIIIllIllllIlI) > 0) {
                        lllllllllllllllllIIIIIllIlllllII[lllllllllllllllllIIIIIllIllllIll] = lllllllllllllllllIIIIIllIllllIlI.copy();
                        lllllllllllllllllIIIIIllIlllllII[lllllllllllllllllIIIIIllIllllIll].stackSize = 1;
                    }
                }
            }
            return lllllllllllllllllIIIIIllIlllllII;
        }
    }
}
