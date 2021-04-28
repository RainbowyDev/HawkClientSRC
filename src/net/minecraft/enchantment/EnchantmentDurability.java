package net.minecraft.enchantment;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class EnchantmentDurability extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    static {
        __OBFID = "CL_00000103";
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIlIlIIlIlIlIllllIl) {
        return 5 + (llllllllllllllIlIlIIlIlIlIllllIl - 1) * 8;
    }
    
    @Override
    public boolean canApply(final ItemStack llllllllllllllIlIlIIlIlIlIlIIllI) {
        return llllllllllllllIlIlIIlIlIlIlIIllI.isItemStackDamageable() || super.canApply(llllllllllllllIlIlIIlIlIlIlIIllI);
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIlIlIIlIlIlIllIIIl) {
        return super.getMinEnchantability(llllllllllllllIlIlIIlIlIlIllIIIl) + 50;
    }
    
    public static boolean negateDamage(final ItemStack llllllllllllllIlIlIIlIlIlIIlIlII, final int llllllllllllllIlIlIIlIlIlIIlIIll, final Random llllllllllllllIlIlIIlIlIlIIlIllI) {
        return (!(llllllllllllllIlIlIIlIlIlIIlIlII.getItem() instanceof ItemArmor) || llllllllllllllIlIlIIlIlIlIIlIllI.nextFloat() >= 0.6f) && llllllllllllllIlIlIIlIlIlIIlIllI.nextInt(llllllllllllllIlIlIIlIlIlIIlIIll + 1) > 0;
    }
    
    protected EnchantmentDurability(final int llllllllllllllIlIlIIlIlIllIIlllI, final ResourceLocation llllllllllllllIlIlIIlIlIllIIIlII, final int llllllllllllllIlIlIIlIlIllIIlIlI) {
        super(llllllllllllllIlIlIIlIlIllIIlllI, llllllllllllllIlIlIIlIlIllIIIlII, llllllllllllllIlIlIIlIlIllIIlIlI, EnumEnchantmentType.BREAKABLE);
        this.setName("durability");
    }
}
