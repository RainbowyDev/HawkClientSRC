package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentWaterWorker extends Enchantment
{
    static {
        __OBFID = "CL_00000124";
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    public EnchantmentWaterWorker(final int lllIllIIIIlIlIl, final ResourceLocation lllIllIIIIllIII, final int lllIllIIIIlIIll) {
        super(lllIllIIIIlIlIl, lllIllIIIIllIII, lllIllIIIIlIIll, EnumEnchantmentType.ARMOR_HEAD);
        this.setName("waterWorker");
    }
    
    @Override
    public int getMaxEnchantability(final int lllIllIIIIIllIl) {
        return this.getMinEnchantability(lllIllIIIIIllIl) + 40;
    }
    
    @Override
    public int getMinEnchantability(final int lllIllIIIIlIIIl) {
        return 1;
    }
}
