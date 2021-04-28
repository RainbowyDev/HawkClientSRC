package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;

public class ItemSnowball extends Item
{
    static {
        __OBFID = "CL_00000069";
    }
    
    public ItemSnowball() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIIlIIlIIlIlIIIlIlI, final World llllllllllllllIIlIIlIIlIlIIIlIIl, final EntityPlayer llllllllllllllIIlIIlIIlIlIIIllII) {
        if (!llllllllllllllIIlIIlIIlIlIIIllII.capabilities.isCreativeMode) {
            --llllllllllllllIIlIIlIIlIlIIIlIlI.stackSize;
        }
        llllllllllllllIIlIIlIIlIlIIIlIIl.playSoundAtEntity(llllllllllllllIIlIIlIIlIlIIIllII, "random.bow", 0.5f, 0.4f / (ItemSnowball.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!llllllllllllllIIlIIlIIlIlIIIlIIl.isRemote) {
            llllllllllllllIIlIIlIIlIlIIIlIIl.spawnEntityInWorld(new EntitySnowball(llllllllllllllIIlIIlIIlIlIIIlIIl, llllllllllllllIIlIIlIIlIlIIIllII));
        }
        llllllllllllllIIlIIlIIlIlIIIllII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return llllllllllllllIIlIIlIIlIlIIIlIlI;
    }
}
