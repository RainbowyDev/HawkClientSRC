package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.creativetab.*;
import java.util.*;

public class ItemAppleGold extends ItemFood
{
    @Override
    protected void onFoodEaten(final ItemStack llllllllllllllIllllIIlllIIIIIIll, final World llllllllllllllIllllIIllIlllllllI, final EntityPlayer llllllllllllllIllllIIlllIIIIIIIl) {
        if (!llllllllllllllIllllIIllIlllllllI.isRemote) {
            llllllllllllllIllllIIlllIIIIIIIl.addPotionEffect(new PotionEffect(Potion.absorption.id, 2400, 0));
        }
        if (llllllllllllllIllllIIlllIIIIIIll.getMetadata() > 0) {
            if (!llllllllllllllIllllIIllIlllllllI.isRemote) {
                llllllllllllllIllllIIlllIIIIIIIl.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
                llllllllllllllIllllIIlllIIIIIIIl.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
                llllllllllllllIllllIIlllIIIIIIIl.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
            }
        }
        else {
            super.onFoodEaten(llllllllllllllIllllIIlllIIIIIIll, llllllllllllllIllllIIllIlllllllI, llllllllllllllIllllIIlllIIIIIIIl);
        }
    }
    
    public ItemAppleGold(final int llllllllllllllIllllIIlllIIIlIIll, final float llllllllllllllIllllIIlllIIIlIIlI, final boolean llllllllllllllIllllIIlllIIIlIIIl) {
        super(llllllllllllllIllllIIlllIIIlIIll, llllllllllllllIllllIIlllIIIlIIlI, llllllllllllllIllllIIlllIIIlIIIl);
        this.setHasSubtypes(true);
    }
    
    static {
        __OBFID = "CL_00000037";
    }
    
    @Override
    public EnumRarity getRarity(final ItemStack llllllllllllllIllllIIlllIIIIlIlI) {
        return (llllllllllllllIllllIIlllIIIIlIlI.getMetadata() == 0) ? EnumRarity.RARE : EnumRarity.EPIC;
    }
    
    @Override
    public boolean hasEffect(final ItemStack llllllllllllllIllllIIlllIIIIllIl) {
        return llllllllllllllIllllIIlllIIIIllIl.getMetadata() > 0;
    }
    
    @Override
    public void getSubItems(final Item llllllllllllllIllllIIllIlllllIIl, final CreativeTabs llllllllllllllIllllIIllIlllllIII, final List llllllllllllllIllllIIllIllllIlll) {
        llllllllllllllIllllIIllIllllIlll.add(new ItemStack(llllllllllllllIllllIIllIlllllIIl, 1, 0));
        llllllllllllllIllllIIllIllllIlll.add(new ItemStack(llllllllllllllIllllIIllIlllllIIl, 1, 1));
    }
}
