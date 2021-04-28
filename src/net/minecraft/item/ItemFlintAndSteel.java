package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;

public class ItemFlintAndSteel extends Item
{
    static {
        __OBFID = "CL_00000035";
    }
    
    public ItemFlintAndSteel() {
        this.maxStackSize = 1;
        this.setMaxDamage(64);
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIllIIlIlIlIllIIIII, final EntityPlayer llllllllllllllIllIIlIlIlIlIlllll, final World llllllllllllllIllIIlIlIlIlIllllI, BlockPos llllllllllllllIllIIlIlIlIlIlllIl, final EnumFacing llllllllllllllIllIIlIlIlIllIIlII, final float llllllllllllllIllIIlIlIlIllIIIll, final float llllllllllllllIllIIlIlIlIllIIIlI, final float llllllllllllllIllIIlIlIlIllIIIIl) {
        llllllllllllllIllIIlIlIlIlIlllIl = llllllllllllllIllIIlIlIlIlIlllIl.offset(llllllllllllllIllIIlIlIlIllIIlII);
        if (!llllllllllllllIllIIlIlIlIlIlllll.func_175151_a(llllllllllllllIllIIlIlIlIlIlllIl, llllllllllllllIllIIlIlIlIllIIlII, llllllllllllllIllIIlIlIlIllIIIII)) {
            return false;
        }
        if (llllllllllllllIllIIlIlIlIlIllllI.getBlockState(llllllllllllllIllIIlIlIlIlIlllIl).getBlock().getMaterial() == Material.air) {
            llllllllllllllIllIIlIlIlIlIllllI.playSoundEffect(llllllllllllllIllIIlIlIlIlIlllIl.getX() + 0.5, llllllllllllllIllIIlIlIlIlIlllIl.getY() + 0.5, llllllllllllllIllIIlIlIlIlIlllIl.getZ() + 0.5, "fire.ignite", 1.0f, ItemFlintAndSteel.itemRand.nextFloat() * 0.4f + 0.8f);
            llllllllllllllIllIIlIlIlIlIllllI.setBlockState(llllllllllllllIllIIlIlIlIlIlllIl, Blocks.fire.getDefaultState());
        }
        llllllllllllllIllIIlIlIlIllIIIII.damageItem(1, llllllllllllllIllIIlIlIlIlIlllll);
        return true;
    }
}
