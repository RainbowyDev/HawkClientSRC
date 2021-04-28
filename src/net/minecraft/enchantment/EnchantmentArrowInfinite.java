package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentArrowInfinite extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllllllIIIlIllllllIlII) {
        return 20;
    }
    
    static {
        __OBFID = "CL_00000100";
    }
    
    public EnchantmentArrowInfinite(final int lllllllllllllllllIIIlIllllllllII, final ResourceLocation lllllllllllllllllIIIlIlllllllIll, final int lllllllllllllllllIIIlIlllllllIlI) {
        super(lllllllllllllllllIIIlIllllllllII, lllllllllllllllllIIIlIlllllllIll, lllllllllllllllllIIIlIlllllllIlI, EnumEnchantmentType.BOW);
        this.setName("arrowInfinite");
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllllllIIIlIllllllIIlI) {
        return 50;
    }
}
