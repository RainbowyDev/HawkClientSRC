package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentArrowKnockback extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    public EnchantmentArrowKnockback(final int lllllllllllllllIllIIllIlllIIllll, final ResourceLocation lllllllllllllllIllIIllIlllIIlllI, final int lllllllllllllllIllIIllIlllIIllIl) {
        super(lllllllllllllllIllIIllIlllIIllll, lllllllllllllllIllIIllIlllIIlllI, lllllllllllllllIllIIllIlllIIllIl, EnumEnchantmentType.BOW);
        this.setName("arrowKnockback");
    }
    
    static {
        __OBFID = "CL_00000101";
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllllIllIIllIlllIIIIll) {
        return this.getMinEnchantability(lllllllllllllllIllIIllIlllIIIIll) + 25;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllllIllIIllIlllIIlIlI) {
        return 12 + (lllllllllllllllIllIIllIlllIIlIlI - 1) * 20;
    }
}
