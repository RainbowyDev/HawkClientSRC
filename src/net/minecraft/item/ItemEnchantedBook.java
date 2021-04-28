package net.minecraft.item;

import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;

public class ItemEnchantedBook extends Item
{
    static {
        __OBFID = "CL_00000025";
    }
    
    @Override
    public boolean hasEffect(final ItemStack llllllllllllllIlIlIIlIIlllIIlIIl) {
        return true;
    }
    
    public void func_92113_a(final Enchantment llllllllllllllIlIlIIlIIlIllllIlI, final List llllllllllllllIlIlIIlIIlIllllIIl) {
        for (int llllllllllllllIlIlIIlIIlIllllIII = llllllllllllllIlIlIIlIIlIllllIlI.getMinLevel(); llllllllllllllIlIlIIlIIlIllllIII <= llllllllllllllIlIlIIlIIlIllllIlI.getMaxLevel(); ++llllllllllllllIlIlIIlIIlIllllIII) {
            llllllllllllllIlIlIIlIIlIllllIIl.add(this.getEnchantedItemStack(new EnchantmentData(llllllllllllllIlIlIIlIIlIllllIlI, llllllllllllllIlIlIIlIIlIllllIII)));
        }
    }
    
    public void addEnchantment(final ItemStack llllllllllllllIlIlIIlIIllIIIlllI, final EnchantmentData llllllllllllllIlIlIIlIIllIIIllIl) {
        final NBTTagList llllllllllllllIlIlIIlIIllIIlIlII = this.func_92110_g(llllllllllllllIlIlIIlIIllIIIlllI);
        boolean llllllllllllllIlIlIIlIIllIIlIIll = true;
        for (int llllllllllllllIlIlIIlIIllIIlIIlI = 0; llllllllllllllIlIlIIlIIllIIlIIlI < llllllllllllllIlIlIIlIIllIIlIlII.tagCount(); ++llllllllllllllIlIlIIlIIllIIlIIlI) {
            final NBTTagCompound llllllllllllllIlIlIIlIIllIIlIIIl = llllllllllllllIlIlIIlIIllIIlIlII.getCompoundTagAt(llllllllllllllIlIlIIlIIllIIlIIlI);
            if (llllllllllllllIlIlIIlIIllIIlIIIl.getShort("id") == llllllllllllllIlIlIIlIIllIIIllIl.enchantmentobj.effectId) {
                if (llllllllllllllIlIlIIlIIllIIlIIIl.getShort("lvl") < llllllllllllllIlIlIIlIIllIIIllIl.enchantmentLevel) {
                    llllllllllllllIlIlIIlIIllIIlIIIl.setShort("lvl", (short)llllllllllllllIlIlIIlIIllIIIllIl.enchantmentLevel);
                }
                llllllllllllllIlIlIIlIIllIIlIIll = false;
                break;
            }
        }
        if (llllllllllllllIlIlIIlIIllIIlIIll) {
            final NBTTagCompound llllllllllllllIlIlIIlIIllIIlIIII = new NBTTagCompound();
            llllllllllllllIlIlIIlIIllIIlIIII.setShort("id", (short)llllllllllllllIlIlIIlIIllIIIllIl.enchantmentobj.effectId);
            llllllllllllllIlIlIIlIIllIIlIIII.setShort("lvl", (short)llllllllllllllIlIlIIlIIllIIIllIl.enchantmentLevel);
            llllllllllllllIlIlIIlIIllIIlIlII.appendTag(llllllllllllllIlIlIIlIIllIIlIIII);
        }
        if (!llllllllllllllIlIlIIlIIllIIIlllI.hasTagCompound()) {
            llllllllllllllIlIlIIlIIllIIIlllI.setTagCompound(new NBTTagCompound());
        }
        llllllllllllllIlIlIIlIIllIIIlllI.getTagCompound().setTag("StoredEnchantments", llllllllllllllIlIlIIlIIllIIlIlII);
    }
    
    @Override
    public EnumRarity getRarity(final ItemStack llllllllllllllIlIlIIlIIlllIIIIll) {
        return (this.func_92110_g(llllllllllllllIlIlIIlIIlllIIIIll).tagCount() > 0) ? EnumRarity.UNCOMMON : super.getRarity(llllllllllllllIlIlIIlIIlllIIIIll);
    }
    
    public NBTTagList func_92110_g(final ItemStack llllllllllllllIlIlIIlIIllIllllIl) {
        final NBTTagCompound llllllllllllllIlIlIIlIIllIllllII = llllllllllllllIlIlIIlIIllIllllIl.getTagCompound();
        return (NBTTagList)((llllllllllllllIlIlIIlIIllIllllII != null && llllllllllllllIlIlIIlIIllIllllII.hasKey("StoredEnchantments", 9)) ? llllllllllllllIlIlIIlIIllIllllII.getTag("StoredEnchantments") : new NBTTagList());
    }
    
    public ItemStack getEnchantedItemStack(final EnchantmentData llllllllllllllIlIlIIlIIllIIIIlII) {
        final ItemStack llllllllllllllIlIlIIlIIllIIIIIll = new ItemStack(this);
        this.addEnchantment(llllllllllllllIlIlIIlIIllIIIIIll, llllllllllllllIlIlIIlIIllIIIIlII);
        return llllllllllllllIlIlIIlIIllIIIIIll;
    }
    
    public WeightedRandomChestContent func_92112_a(final Random llllllllllllllIlIlIIlIIlIllIIlll, final int llllllllllllllIlIlIIlIIlIllIIIIl, final int llllllllllllllIlIlIIlIIlIllIIlIl, final int llllllllllllllIlIlIIlIIlIlIlllll) {
        final ItemStack llllllllllllllIlIlIIlIIlIllIIIll = new ItemStack(Items.book, 1, 0);
        EnchantmentHelper.addRandomEnchantment(llllllllllllllIlIlIIlIIlIllIIlll, llllllllllllllIlIlIIlIIlIllIIIll, 30);
        return new WeightedRandomChestContent(llllllllllllllIlIlIIlIIlIllIIIll, llllllllllllllIlIlIIlIIlIllIIIIl, llllllllllllllIlIlIIlIIlIllIIlIl, llllllllllllllIlIlIIlIIlIlIlllll);
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllllIlIlIIlIIllIlIIllI, final EntityPlayer llllllllllllllIlIlIIlIIllIlIlllI, final List llllllllllllllIlIlIIlIIllIlIIlII, final boolean llllllllllllllIlIlIIlIIllIlIIIll) {
        super.addInformation(llllllllllllllIlIlIIlIIllIlIIllI, llllllllllllllIlIlIIlIIllIlIlllI, llllllllllllllIlIlIIlIIllIlIIlII, llllllllllllllIlIlIIlIIllIlIIIll);
        final NBTTagList llllllllllllllIlIlIIlIIllIlIlIll = this.func_92110_g(llllllllllllllIlIlIIlIIllIlIIllI);
        if (llllllllllllllIlIlIIlIIllIlIlIll != null) {
            for (int llllllllllllllIlIlIIlIIllIlIlIlI = 0; llllllllllllllIlIlIIlIIllIlIlIlI < llllllllllllllIlIlIIlIIllIlIlIll.tagCount(); ++llllllllllllllIlIlIIlIIllIlIlIlI) {
                final short llllllllllllllIlIlIIlIIllIlIlIIl = llllllllllllllIlIlIIlIIllIlIlIll.getCompoundTagAt(llllllllllllllIlIlIIlIIllIlIlIlI).getShort("id");
                final short llllllllllllllIlIlIIlIIllIlIlIII = llllllllllllllIlIlIIlIIllIlIlIll.getCompoundTagAt(llllllllllllllIlIlIIlIIllIlIlIlI).getShort("lvl");
                if (Enchantment.func_180306_c(llllllllllllllIlIlIIlIIllIlIlIIl) != null) {
                    llllllllllllllIlIlIIlIIllIlIIlII.add(Enchantment.func_180306_c(llllllllllllllIlIlIIlIIllIlIlIIl).getTranslatedName(llllllllllllllIlIlIIlIIllIlIlIII));
                }
            }
        }
    }
    
    public WeightedRandomChestContent getRandomEnchantedBook(final Random llllllllllllllIlIlIIlIIlIlllIIII) {
        return this.func_92112_a(llllllllllllllIlIlIIlIIlIlllIIII, 1, 1, 1);
    }
    
    @Override
    public boolean isItemTool(final ItemStack llllllllllllllIlIlIIlIIlllIIIlll) {
        return false;
    }
}
