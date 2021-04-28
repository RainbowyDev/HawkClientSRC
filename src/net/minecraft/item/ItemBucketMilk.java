package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;

public class ItemBucketMilk extends Item
{
    @Override
    public ItemStack onItemUseFinish(final ItemStack llllllllllllllIlIIIIllIllIllIlIl, final World llllllllllllllIlIIIIllIllIllIIII, final EntityPlayer llllllllllllllIlIIIIllIllIlIllll) {
        if (!llllllllllllllIlIIIIllIllIlIllll.capabilities.isCreativeMode) {
            --llllllllllllllIlIIIIllIllIllIlIl.stackSize;
        }
        if (!llllllllllllllIlIIIIllIllIllIIII.isRemote) {
            llllllllllllllIlIIIIllIllIlIllll.clearActivePotions();
        }
        llllllllllllllIlIIIIllIllIlIllll.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return (llllllllllllllIlIIIIllIllIllIlIl.stackSize <= 0) ? new ItemStack(Items.bucket) : llllllllllllllIlIIIIllIllIllIlIl;
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack llllllllllllllIlIIIIllIllIlIlIll) {
        return EnumAction.DRINK;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack llllllllllllllIlIIIIllIllIlIllIl) {
        return 32;
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIlIIIIllIllIlIIllI, final World llllllllllllllIlIIIIllIllIlIIlIl, final EntityPlayer llllllllllllllIlIIIIllIllIlIIIIl) {
        llllllllllllllIlIIIIllIllIlIIIIl.setItemInUse(llllllllllllllIlIIIIllIllIlIIllI, this.getMaxItemUseDuration(llllllllllllllIlIIIIllIllIlIIllI));
        return llllllllllllllIlIIIIllIllIlIIllI;
    }
    
    public ItemBucketMilk() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    static {
        __OBFID = "CL_00000048";
    }
}
