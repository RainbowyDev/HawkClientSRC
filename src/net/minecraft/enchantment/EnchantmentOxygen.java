package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentOxygen extends Enchantment
{
    @Override
    public int getMinEnchantability(final int llllllllllllllIIIlIlIIIIIlllIlll) {
        return 10 * llllllllllllllIIIlIlIIIIIlllIlll;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIIIlIlIIIIIlllIIIl) {
        return this.getMinEnchantability(llllllllllllllIIIlIlIIIIIlllIIIl) + 30;
    }
    
    static {
        __OBFID = "CL_00000120";
    }
    
    public EnchantmentOxygen(final int llllllllllllllIIIlIlIIIIIlllllIl, final ResourceLocation llllllllllllllIIIlIlIIIIlIIIIIII, final int llllllllllllllIIIlIlIIIIIllllIll) {
        super(llllllllllllllIIIlIlIIIIIlllllIl, llllllllllllllIIIlIlIIIIlIIIIIII, llllllllllllllIIIlIlIIIIIllllIll, EnumEnchantmentType.ARMOR_HEAD);
        this.setName("oxygen");
    }
}
