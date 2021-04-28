package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentFishingSpeed extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    static {
        __OBFID = "CL_00000117";
    }
    
    protected EnchantmentFishingSpeed(final int llllllllllllllIIlIlllIllIIllIIlI, final ResourceLocation llllllllllllllIIlIlllIllIIllIIIl, final int llllllllllllllIIlIlllIllIIllIIII, final EnumEnchantmentType llllllllllllllIIlIlllIllIIlIllll) {
        super(llllllllllllllIIlIlllIllIIllIIlI, llllllllllllllIIlIlllIllIIllIIIl, llllllllllllllIIlIlllIllIIllIIII, llllllllllllllIIlIlllIllIIlIllll);
        this.setName("fishingSpeed");
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIIlIlllIllIIlIlIll) {
        return 15 + (llllllllllllllIIlIlllIllIIlIlIll - 1) * 9;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIIlIlllIllIIlIIlIl) {
        return super.getMinEnchantability(llllllllllllllIIlIlllIllIIlIIlIl) + 50;
    }
}
