package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class ItemGlassBottle extends Item
{
    public ItemGlassBottle() {
        this.setCreativeTab(CreativeTabs.tabBrewing);
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIIllllllIlIlllllIl, final World llllllllllllllIIllllllIlIlllIllI, final EntityPlayer llllllllllllllIIllllllIlIlllIlIl) {
        final MovingObjectPosition llllllllllllllIIllllllIlIllllIlI = this.getMovingObjectPositionFromPlayer(llllllllllllllIIllllllIlIlllIllI, llllllllllllllIIllllllIlIlllIlIl, true);
        if (llllllllllllllIIllllllIlIllllIlI == null) {
            return llllllllllllllIIllllllIlIlllllIl;
        }
        if (llllllllllllllIIllllllIlIllllIlI.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final BlockPos llllllllllllllIIllllllIlIllllIIl = llllllllllllllIIllllllIlIllllIlI.func_178782_a();
            if (!llllllllllllllIIllllllIlIlllIllI.isBlockModifiable(llllllllllllllIIllllllIlIlllIlIl, llllllllllllllIIllllllIlIllllIIl)) {
                return llllllllllllllIIllllllIlIlllllIl;
            }
            if (!llllllllllllllIIllllllIlIlllIlIl.func_175151_a(llllllllllllllIIllllllIlIllllIIl.offset(llllllllllllllIIllllllIlIllllIlI.field_178784_b), llllllllllllllIIllllllIlIllllIlI.field_178784_b, llllllllllllllIIllllllIlIlllllIl)) {
                return llllllllllllllIIllllllIlIlllllIl;
            }
            if (llllllllllllllIIllllllIlIlllIllI.getBlockState(llllllllllllllIIllllllIlIllllIIl).getBlock().getMaterial() == Material.water) {
                --llllllllllllllIIllllllIlIlllllIl.stackSize;
                llllllllllllllIIllllllIlIlllIlIl.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                if (llllllllllllllIIllllllIlIlllllIl.stackSize <= 0) {
                    return new ItemStack(Items.potionitem);
                }
                if (!llllllllllllllIIllllllIlIlllIlIl.inventory.addItemStackToInventory(new ItemStack(Items.potionitem))) {
                    llllllllllllllIIllllllIlIlllIlIl.dropPlayerItemWithRandomChoice(new ItemStack(Items.potionitem, 1, 0), false);
                }
            }
        }
        return llllllllllllllIIllllllIlIlllllIl;
    }
    
    static {
        __OBFID = "CL_00001776";
    }
}
