package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentArrowFire extends Enchantment
{
    static {
        __OBFID = "CL_00000099";
    }
    
    public EnchantmentArrowFire(final int llllllllllllllIlllIlllIIlIIIIIII, final ResourceLocation llllllllllllllIlllIlllIIIlllllll, final int llllllllllllllIlllIlllIIIllllllI) {
        super(llllllllllllllIlllIlllIIlIIIIIII, llllllllllllllIlllIlllIIIlllllll, llllllllllllllIlllIlllIIIllllllI, EnumEnchantmentType.BOW);
        this.setName("arrowFire");
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIlllIlllIIIllllIlI) {
        return 50;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIlllIlllIIIlllllII) {
        return 20;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
