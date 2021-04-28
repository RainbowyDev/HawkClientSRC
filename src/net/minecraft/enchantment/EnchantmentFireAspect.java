package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentFireAspect extends Enchantment
{
    protected EnchantmentFireAspect(final int llllllllllllllIIIllIllIllIIIIlIl, final ResourceLocation llllllllllllllIIIllIllIllIIIIlII, final int llllllllllllllIIIllIllIllIIIIIll) {
        super(llllllllllllllIIIllIllIllIIIIlIl, llllllllllllllIIIllIllIllIIIIlII, llllllllllllllIIIllIllIllIIIIIll, EnumEnchantmentType.WEAPON);
        this.setName("fire");
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    static {
        __OBFID = "CL_00000116";
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIIIllIllIlIllIllll) {
        return super.getMinEnchantability(llllllllllllllIIIllIllIlIllIllll) + 50;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIIIllIllIlIlllllII) {
        return 10 + 20 * (llllllllllllllIIIllIllIlIlllllII - 1);
    }
}
