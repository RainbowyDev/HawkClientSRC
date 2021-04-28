package net.minecraft.enchantment;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class EnchantmentUntouching extends Enchantment
{
    @Override
    public boolean canApplyTogether(final Enchantment lllllllllllllllIllIIlIllllIIlIIl) {
        return super.canApplyTogether(lllllllllllllllIllIIlIllllIIlIIl) && lllllllllllllllIllIIlIllllIIlIIl.effectId != EnchantmentUntouching.fortune.effectId;
    }
    
    static {
        __OBFID = "CL_00000123";
    }
    
    @Override
    public boolean canApply(final ItemStack lllllllllllllllIllIIlIllllIIIIll) {
        return lllllllllllllllIllIIlIllllIIIIll.getItem() == Items.shears || super.canApply(lllllllllllllllIllIIlIllllIIIIll);
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    protected EnchantmentUntouching(final int lllllllllllllllIllIIlIllllIllIII, final ResourceLocation lllllllllllllllIllIIlIllllIlIlll, final int lllllllllllllllIllIIlIllllIllIlI) {
        super(lllllllllllllllIllIIlIllllIllIII, lllllllllllllllIllIIlIllllIlIlll, lllllllllllllllIllIIlIllllIllIlI, EnumEnchantmentType.DIGGER);
        this.setName("untouching");
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllllIllIIlIllllIIlllI) {
        return super.getMinEnchantability(lllllllllllllllIllIIlIllllIIlllI) + 50;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllllIllIIlIllllIlIlII) {
        return 15;
    }
}
