package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.world.storage.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;

public class RecipesMapExtending extends ShapedRecipes
{
    @Override
    public boolean matches(final InventoryCrafting llllllllllllllIIllIIlIlIIIIlIlll, final World llllllllllllllIIllIIlIlIIIIlllIl) {
        if (!super.matches(llllllllllllllIIllIIlIlIIIIlIlll, llllllllllllllIIllIIlIlIIIIlllIl)) {
            return false;
        }
        ItemStack llllllllllllllIIllIIlIlIIIIlllII = null;
        for (int llllllllllllllIIllIIlIlIIIIllIll = 0; llllllllllllllIIllIIlIlIIIIllIll < llllllllllllllIIllIIlIlIIIIlIlll.getSizeInventory() && llllllllllllllIIllIIlIlIIIIlllII == null; ++llllllllllllllIIllIIlIlIIIIllIll) {
            final ItemStack llllllllllllllIIllIIlIlIIIIllIlI = llllllllllllllIIllIIlIlIIIIlIlll.getStackInSlot(llllllllllllllIIllIIlIlIIIIllIll);
            if (llllllllllllllIIllIIlIlIIIIllIlI != null && llllllllllllllIIllIIlIlIIIIllIlI.getItem() == Items.filled_map) {
                llllllllllllllIIllIIlIlIIIIlllII = llllllllllllllIIllIIlIlIIIIllIlI;
            }
        }
        if (llllllllllllllIIllIIlIlIIIIlllII == null) {
            return false;
        }
        final MapData llllllllllllllIIllIIlIlIIIIllIIl = Items.filled_map.getMapData(llllllllllllllIIllIIlIlIIIIlllII, llllllllllllllIIllIIlIlIIIIlllIl);
        return llllllllllllllIIllIIlIlIIIIllIIl != null && llllllllllllllIIllIIlIlIIIIllIIl.scale < 4;
    }
    
    public RecipesMapExtending() {
        super(3, 3, new ItemStack[] { new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.filled_map, 0, 32767), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper) }, new ItemStack(Items.map, 0, 0));
    }
    
    static {
        __OBFID = "CL_00000088";
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllIIllIIlIlIIIIIllIl) {
        ItemStack llllllllllllllIIllIIlIlIIIIIllII = null;
        for (int llllllllllllllIIllIIlIlIIIIIlIll = 0; llllllllllllllIIllIIlIlIIIIIlIll < llllllllllllllIIllIIlIlIIIIIllIl.getSizeInventory() && llllllllllllllIIllIIlIlIIIIIllII == null; ++llllllllllllllIIllIIlIlIIIIIlIll) {
            final ItemStack llllllllllllllIIllIIlIlIIIIIlIlI = llllllllllllllIIllIIlIlIIIIIllIl.getStackInSlot(llllllllllllllIIllIIlIlIIIIIlIll);
            if (llllllllllllllIIllIIlIlIIIIIlIlI != null && llllllllllllllIIllIIlIlIIIIIlIlI.getItem() == Items.filled_map) {
                llllllllllllllIIllIIlIlIIIIIllII = llllllllllllllIIllIIlIlIIIIIlIlI;
            }
        }
        llllllllllllllIIllIIlIlIIIIIllII = llllllllllllllIIllIIlIlIIIIIllII.copy();
        llllllllllllllIIllIIlIlIIIIIllII.stackSize = 1;
        if (llllllllllllllIIllIIlIlIIIIIllII.getTagCompound() == null) {
            llllllllllllllIIllIIlIlIIIIIllII.setTagCompound(new NBTTagCompound());
        }
        llllllllllllllIIllIIlIlIIIIIllII.getTagCompound().setBoolean("map_is_scaling", true);
        return llllllllllllllIIllIIlIlIIIIIllII;
    }
}
