package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;

public class ItemEgg extends Item
{
    public ItemEgg() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIlIllIlIIlIIIIlIlI, final World llllllllllllllIlIllIlIIlIIIIllIl, final EntityPlayer llllllllllllllIlIllIlIIlIIIIlIII) {
        if (!llllllllllllllIlIllIlIIlIIIIlIII.capabilities.isCreativeMode) {
            --llllllllllllllIlIllIlIIlIIIIlIlI.stackSize;
        }
        llllllllllllllIlIllIlIIlIIIIllIl.playSoundAtEntity(llllllllllllllIlIllIlIIlIIIIlIII, "random.bow", 0.5f, 0.4f / (ItemEgg.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!llllllllllllllIlIllIlIIlIIIIllIl.isRemote) {
            llllllllllllllIlIllIlIIlIIIIllIl.spawnEntityInWorld(new EntityEgg(llllllllllllllIlIllIlIIlIIIIllIl, llllllllllllllIlIllIlIIlIIIIlIII));
        }
        llllllllllllllIlIllIlIIlIIIIlIII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return llllllllllllllIlIllIlIIlIIIIlIlI;
    }
    
    static {
        __OBFID = "CL_00000023";
    }
}
