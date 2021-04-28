package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.world.storage.*;
import net.minecraft.world.*;
import net.minecraft.stats.*;

public class ItemEmptyMap extends ItemMapBase
{
    protected ItemEmptyMap() {
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    static {
        __OBFID = "CL_00000024";
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack lllllllllllllllIllIIlIIlIlIIIIIl, final World lllllllllllllllIllIIlIIlIIlllIIl, final EntityPlayer lllllllllllllllIllIIlIIlIIlllIII) {
        final ItemStack lllllllllllllllIllIIlIIlIIlllllI = new ItemStack(Items.filled_map, 1, lllllllllllllllIllIIlIIlIIlllIIl.getUniqueDataId("map"));
        final String lllllllllllllllIllIIlIIlIIllllIl = String.valueOf(new StringBuilder("map_").append(lllllllllllllllIllIIlIIlIIlllllI.getMetadata()));
        final MapData lllllllllllllllIllIIlIIlIIllllII = new MapData(lllllllllllllllIllIIlIIlIIllllIl);
        lllllllllllllllIllIIlIIlIIlllIIl.setItemData(lllllllllllllllIllIIlIIlIIllllIl, lllllllllllllllIllIIlIIlIIllllII);
        lllllllllllllllIllIIlIIlIIllllII.scale = 0;
        lllllllllllllllIllIIlIIlIIllllII.func_176054_a(lllllllllllllllIllIIlIIlIIlllIII.posX, lllllllllllllllIllIIlIIlIIlllIII.posZ, lllllllllllllllIllIIlIIlIIllllII.scale);
        lllllllllllllllIllIIlIIlIIllllII.dimension = (byte)lllllllllllllllIllIIlIIlIIlllIIl.provider.getDimensionId();
        lllllllllllllllIllIIlIIlIIllllII.markDirty();
        --lllllllllllllllIllIIlIIlIlIIIIIl.stackSize;
        if (lllllllllllllllIllIIlIIlIlIIIIIl.stackSize <= 0) {
            return lllllllllllllllIllIIlIIlIIlllllI;
        }
        if (!lllllllllllllllIllIIlIIlIIlllIII.inventory.addItemStackToInventory(lllllllllllllllIllIIlIIlIIlllllI.copy())) {
            lllllllllllllllIllIIlIIlIIlllIII.dropPlayerItemWithRandomChoice(lllllllllllllllIllIIlIIlIIlllllI, false);
        }
        lllllllllllllllIllIIlIIlIIlllIII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return lllllllllllllllIllIIlIIlIlIIIIIl;
    }
}
