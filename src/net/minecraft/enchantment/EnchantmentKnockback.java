package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentKnockback extends Enchantment
{
    static {
        __OBFID = "CL_00000118";
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllllIIlIIIIllIlllIlII) {
        return 5 + 20 * (lllllllllllllllIIlIIIIllIlllIlII - 1);
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllllIIlIIIIllIllIlIIl) {
        return super.getMinEnchantability(lllllllllllllllIIlIIIIllIllIlIIl) + 50;
    }
    
    protected EnchantmentKnockback(final int lllllllllllllllIIlIIIIlllIIIIIlI, final ResourceLocation lllllllllllllllIIlIIIIlllIIIIIII, final int lllllllllllllllIIlIIIIllIllllllI) {
        super(lllllllllllllllIIlIIIIlllIIIIIlI, lllllllllllllllIIlIIIIlllIIIIIII, lllllllllllllllIIlIIIIllIllllllI, EnumEnchantmentType.WEAPON);
        this.setName("knockback");
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
}
