package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentArrowDamage extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIIlIIIlIIllllllIIl) {
        return 1 + (llllllllllllllIIlIIIlIIllllllIIl - 1) * 10;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIIlIIIlIIlllllIIll) {
        return this.getMinEnchantability(llllllllllllllIIlIIIlIIlllllIIll) + 15;
    }
    
    public EnchantmentArrowDamage(final int llllllllllllllIIlIIIlIIlllllllll, final ResourceLocation llllllllllllllIIlIIIlIlIIIIIIIlI, final int llllllllllllllIIlIIIlIlIIIIIIIIl) {
        super(llllllllllllllIIlIIIlIIlllllllll, llllllllllllllIIlIIIlIlIIIIIIIlI, llllllllllllllIIlIIIlIlIIIIIIIIl, EnumEnchantmentType.BOW);
        this.setName("arrowDamage");
    }
    
    static {
        __OBFID = "CL_00000098";
    }
}
