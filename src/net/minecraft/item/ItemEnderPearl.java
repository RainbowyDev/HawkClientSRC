package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;

public class ItemEnderPearl extends Item
{
    static {
        __OBFID = "CL_00000027";
    }
    
    public ItemEnderPearl() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack lllllllllllllllIIllIlIlIIlllIllI, final World lllllllllllllllIIllIlIlIIlllIlIl, final EntityPlayer lllllllllllllllIIllIlIlIIllIlllI) {
        if (lllllllllllllllIIllIlIlIIllIlllI.capabilities.isCreativeMode) {
            return lllllllllllllllIIllIlIlIIlllIllI;
        }
        --lllllllllllllllIIllIlIlIIlllIllI.stackSize;
        lllllllllllllllIIllIlIlIIlllIlIl.playSoundAtEntity(lllllllllllllllIIllIlIlIIllIlllI, "random.bow", 0.5f, 0.4f / (ItemEnderPearl.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!lllllllllllllllIIllIlIlIIlllIlIl.isRemote) {
            lllllllllllllllIIllIlIlIIlllIlIl.spawnEntityInWorld(new EntityEnderPearl(lllllllllllllllIIllIlIlIIlllIlIl, lllllllllllllllIIllIlIlIIllIlllI));
        }
        lllllllllllllllIIllIlIlIIllIlllI.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return lllllllllllllllIIllIlIlIIlllIllI;
    }
}
