package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.enchantment.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.creativetab.*;

public class ItemBow extends Item
{
    @Override
    public void onPlayerStoppedUsing(final ItemStack llllllllllllllllIllllIlIIIIIllIl, final World llllllllllllllllIllllIlIIIIIllII, final EntityPlayer llllllllllllllllIllllIlIIIIlIllI, final int llllllllllllllllIllllIlIIIIIlIlI) {
        final boolean llllllllllllllllIllllIlIIIIlIlII = llllllllllllllllIllllIlIIIIlIllI.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, llllllllllllllllIllllIlIIIIIllIl) > 0;
        if (llllllllllllllllIllllIlIIIIlIlII || llllllllllllllllIllllIlIIIIlIllI.inventory.hasItem(Items.arrow)) {
            final int llllllllllllllllIllllIlIIIIlIIll = this.getMaxItemUseDuration(llllllllllllllllIllllIlIIIIIllIl) - llllllllllllllllIllllIlIIIIIlIlI;
            float llllllllllllllllIllllIlIIIIlIIlI = llllllllllllllllIllllIlIIIIlIIll / 20.0f;
            llllllllllllllllIllllIlIIIIlIIlI = (llllllllllllllllIllllIlIIIIlIIlI * llllllllllllllllIllllIlIIIIlIIlI + llllllllllllllllIllllIlIIIIlIIlI * 2.0f) / 3.0f;
            if (llllllllllllllllIllllIlIIIIlIIlI < 0.1) {
                return;
            }
            if (llllllllllllllllIllllIlIIIIlIIlI > 1.0f) {
                llllllllllllllllIllllIlIIIIlIIlI = 1.0f;
            }
            final EntityArrow llllllllllllllllIllllIlIIIIlIIIl = new EntityArrow(llllllllllllllllIllllIlIIIIIllII, llllllllllllllllIllllIlIIIIlIllI, llllllllllllllllIllllIlIIIIlIIlI * 2.0f);
            if (llllllllllllllllIllllIlIIIIlIIlI == 1.0f) {
                llllllllllllllllIllllIlIIIIlIIIl.setIsCritical(true);
            }
            final int llllllllllllllllIllllIlIIIIlIIII = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, llllllllllllllllIllllIlIIIIIllIl);
            if (llllllllllllllllIllllIlIIIIlIIII > 0) {
                llllllllllllllllIllllIlIIIIlIIIl.setDamage(llllllllllllllllIllllIlIIIIlIIIl.getDamage() + llllllllllllllllIllllIlIIIIlIIII * 0.5 + 0.5);
            }
            final int llllllllllllllllIllllIlIIIIIllll = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, llllllllllllllllIllllIlIIIIIllIl);
            if (llllllllllllllllIllllIlIIIIIllll > 0) {
                llllllllllllllllIllllIlIIIIlIIIl.setKnockbackStrength(llllllllllllllllIllllIlIIIIIllll);
            }
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, llllllllllllllllIllllIlIIIIIllIl) > 0) {
                llllllllllllllllIllllIlIIIIlIIIl.setFire(100);
            }
            llllllllllllllllIllllIlIIIIIllIl.damageItem(1, llllllllllllllllIllllIlIIIIlIllI);
            llllllllllllllllIllllIlIIIIIllII.playSoundAtEntity(llllllllllllllllIllllIlIIIIlIllI, "random.bow", 1.0f, 1.0f / (ItemBow.itemRand.nextFloat() * 0.4f + 1.2f) + llllllllllllllllIllllIlIIIIlIIlI * 0.5f);
            if (llllllllllllllllIllllIlIIIIlIlII) {
                llllllllllllllllIllllIlIIIIlIIIl.canBePickedUp = 2;
            }
            else {
                llllllllllllllllIllllIlIIIIlIllI.inventory.consumeInventoryItem(Items.arrow);
            }
            llllllllllllllllIllllIlIIIIlIllI.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
            if (!llllllllllllllllIllllIlIIIIIllII.isRemote) {
                llllllllllllllllIllllIlIIIIIllII.spawnEntityInWorld(llllllllllllllllIllllIlIIIIlIIIl);
            }
        }
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllllIllllIIlllllIIIl, final World llllllllllllllllIllllIIlllllIlII, final EntityPlayer llllllllllllllllIllllIIlllllIIII) {
        if (llllllllllllllllIllllIIlllllIIII.capabilities.isCreativeMode || llllllllllllllllIllllIIlllllIIII.inventory.hasItem(Items.arrow)) {
            llllllllllllllllIllllIIlllllIIII.setItemInUse(llllllllllllllllIllllIIlllllIIIl, this.getMaxItemUseDuration(llllllllllllllllIllllIIlllllIIIl));
        }
        return llllllllllllllllIllllIIlllllIIIl;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack llllllllllllllllIllllIIlllllllII) {
        return 72000;
    }
    
    public ItemBow() {
        this.maxStackSize = 1;
        this.setMaxDamage(384);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }
    
    @Override
    public ItemStack onItemUseFinish(final ItemStack llllllllllllllllIllllIIllllllllI, final World llllllllllllllllIllllIlIIIIIIIII, final EntityPlayer llllllllllllllllIllllIIlllllllll) {
        return llllllllllllllllIllllIIllllllllI;
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack llllllllllllllllIllllIIllllllIlI) {
        return EnumAction.BOW;
    }
    
    static {
        __OBFID = "CL_00001777";
        bowPullIconNameArray = new String[] { "pulling_0", "pulling_1", "pulling_2" };
    }
    
    @Override
    public int getItemEnchantability() {
        return 1;
    }
}
