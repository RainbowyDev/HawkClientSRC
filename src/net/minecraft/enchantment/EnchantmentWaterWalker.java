package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentWaterWalker extends Enchantment
{
    public EnchantmentWaterWalker(final int lIIIIlIIlIllIII, final ResourceLocation lIIIIlIIlIlIIll, final int lIIIIlIIlIlIIlI) {
        super(lIIIIlIIlIllIII, lIIIIlIIlIlIIll, lIIIIlIIlIlIIlI, EnumEnchantmentType.ARMOR_FEET);
        this.setName("waterWalker");
    }
    
    static {
        __OBFID = "CL_00002155";
    }
    
    @Override
    public int getMaxEnchantability(final int lIIIIlIIlIIlIlI) {
        return this.getMinEnchantability(lIIIIlIIlIIlIlI) + 15;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMinEnchantability(final int lIIIIlIIlIIlllI) {
        return lIIIIlIIlIIlllI * 10;
    }
}
