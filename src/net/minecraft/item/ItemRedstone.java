package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;

public class ItemRedstone extends Item
{
    static {
        __OBFID = "CL_00000058";
    }
    
    @Override
    public boolean onItemUse(final ItemStack lIlIlllllllIl, final EntityPlayer lIllIIIIIIlll, final World lIlIllllllIll, final BlockPos lIlIllllllIlI, final EnumFacing lIlIllllllIIl, final float lIllIIIIIIIll, final float lIllIIIIIIIlI, final float lIllIIIIIIIIl) {
        final boolean lIllIIIIIIIII = lIlIllllllIll.getBlockState(lIlIllllllIlI).getBlock().isReplaceable(lIlIllllllIll, lIlIllllllIlI);
        final BlockPos lIlIlllllllll = lIllIIIIIIIII ? lIlIllllllIlI : lIlIllllllIlI.offset(lIlIllllllIIl);
        if (!lIllIIIIIIlll.func_175151_a(lIlIlllllllll, lIlIllllllIIl, lIlIlllllllIl)) {
            return false;
        }
        final Block lIlIllllllllI = lIlIllllllIll.getBlockState(lIlIlllllllll).getBlock();
        if (!lIlIllllllIll.canBlockBePlaced(lIlIllllllllI, lIlIlllllllll, false, lIlIllllllIIl, null, lIlIlllllllIl)) {
            return false;
        }
        if (Blocks.redstone_wire.canPlaceBlockAt(lIlIllllllIll, lIlIlllllllll)) {
            --lIlIlllllllIl.stackSize;
            lIlIllllllIll.setBlockState(lIlIlllllllll, Blocks.redstone_wire.getDefaultState());
            return true;
        }
        return false;
    }
    
    public ItemRedstone() {
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
}
