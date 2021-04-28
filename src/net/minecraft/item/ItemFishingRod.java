package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.stats.*;

public class ItemFishingRod extends Item
{
    @Override
    public int getItemEnchantability() {
        return 1;
    }
    
    public ItemFishingRod() {
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack lllllllllllllllIIlIllllllIIIlllI, final World lllllllllllllllIIlIllllllIIlIIlI, final EntityPlayer lllllllllllllllIIlIllllllIIIllII) {
        if (lllllllllllllllIIlIllllllIIIllII.fishEntity != null) {
            final int lllllllllllllllIIlIllllllIIlIIII = lllllllllllllllIIlIllllllIIIllII.fishEntity.handleHookRetraction();
            lllllllllllllllIIlIllllllIIIlllI.damageItem(lllllllllllllllIIlIllllllIIlIIII, lllllllllllllllIIlIllllllIIIllII);
            lllllllllllllllIIlIllllllIIIllII.swingItem();
        }
        else {
            lllllllllllllllIIlIllllllIIlIIlI.playSoundAtEntity(lllllllllllllllIIlIllllllIIIllII, "random.bow", 0.5f, 0.4f / (ItemFishingRod.itemRand.nextFloat() * 0.4f + 0.8f));
            if (!lllllllllllllllIIlIllllllIIlIIlI.isRemote) {
                lllllllllllllllIIlIllllllIIlIIlI.spawnEntityInWorld(new EntityFishHook(lllllllllllllllIIlIllllllIIlIIlI, lllllllllllllllIIlIllllllIIIllII));
            }
            lllllllllllllllIIlIllllllIIIllII.swingItem();
            lllllllllllllllIIlIllllllIIIllII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        }
        return lllllllllllllllIIlIllllllIIIlllI;
    }
    
    @Override
    public boolean isItemTool(final ItemStack lllllllllllllllIIlIllllllIIIIlll) {
        return super.isItemTool(lllllllllllllllIIlIllllllIIIIlll);
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    static {
        __OBFID = "CL_00000034";
    }
}
