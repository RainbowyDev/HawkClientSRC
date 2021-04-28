package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class ItemFireball extends Item
{
    static {
        __OBFID = "CL_00000029";
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIIIlIlIIlIIlIIlIII, final EntityPlayer llllllllllllllIIIlIlIIlIIIllllll, final World llllllllllllllIIIlIlIIlIIIlllllI, BlockPos llllllllllllllIIIlIlIIlIIIllllIl, final EnumFacing llllllllllllllIIIlIlIIlIIlIIIlII, final float llllllllllllllIIIlIlIIlIIlIIIIll, final float llllllllllllllIIIlIlIIlIIlIIIIlI, final float llllllllllllllIIIlIlIIlIIlIIIIIl) {
        if (llllllllllllllIIIlIlIIlIIIlllllI.isRemote) {
            return true;
        }
        llllllllllllllIIIlIlIIlIIIllllIl = (char)((BlockPos)llllllllllllllIIIlIlIIlIIIllllIl).offset(llllllllllllllIIIlIlIIlIIlIIIlII);
        if (!llllllllllllllIIIlIlIIlIIIllllll.func_175151_a((BlockPos)llllllllllllllIIIlIlIIlIIIllllIl, llllllllllllllIIIlIlIIlIIlIIIlII, llllllllllllllIIIlIlIIlIIlIIlIII)) {
            return false;
        }
        if (llllllllllllllIIIlIlIIlIIIlllllI.getBlockState((BlockPos)llllllllllllllIIIlIlIIlIIIllllIl).getBlock().getMaterial() == Material.air) {
            llllllllllllllIIIlIlIIlIIIlllllI.playSoundEffect(((Vec3i)llllllllllllllIIIlIlIIlIIIllllIl).getX() + 0.5, ((Vec3i)llllllllllllllIIIlIlIIlIIIllllIl).getY() + 0.5, ((Vec3i)llllllllllllllIIIlIlIIlIIIllllIl).getZ() + 0.5, "item.fireCharge.use", 1.0f, (ItemFireball.itemRand.nextFloat() - ItemFireball.itemRand.nextFloat()) * 0.2f + 1.0f);
            llllllllllllllIIIlIlIIlIIIlllllI.setBlockState((BlockPos)llllllllllllllIIIlIlIIlIIIllllIl, Blocks.fire.getDefaultState());
        }
        if (!llllllllllllllIIIlIlIIlIIIllllll.capabilities.isCreativeMode) {
            --llllllllllllllIIIlIlIIlIIlIIlIII.stackSize;
        }
        return true;
    }
    
    public ItemFireball() {
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
}
