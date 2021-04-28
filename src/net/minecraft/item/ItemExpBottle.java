package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;

public class ItemExpBottle extends Item
{
    public ItemExpBottle() {
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack lllIIIllIIlIlll, final World lllIIIllIIllIlI, final EntityPlayer lllIIIllIIlIlIl) {
        if (!lllIIIllIIlIlIl.capabilities.isCreativeMode) {
            --lllIIIllIIlIlll.stackSize;
        }
        lllIIIllIIllIlI.playSoundAtEntity(lllIIIllIIlIlIl, "random.bow", 0.5f, 0.4f / (ItemExpBottle.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!lllIIIllIIllIlI.isRemote) {
            lllIIIllIIllIlI.spawnEntityInWorld(new EntityExpBottle(lllIIIllIIllIlI, lllIIIllIIlIlIl));
        }
        lllIIIllIIlIlIl.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return lllIIIllIIlIlll;
    }
    
    static {
        __OBFID = "CL_00000028";
    }
    
    @Override
    public boolean hasEffect(final ItemStack lllIIIllIlIIIIl) {
        return true;
    }
}
