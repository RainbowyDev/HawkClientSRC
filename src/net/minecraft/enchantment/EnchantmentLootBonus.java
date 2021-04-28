package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentLootBonus extends Enchantment
{
    @Override
    public int getMaxEnchantability(final int llllllllllllllllIllIIllIIllllIll) {
        return super.getMinEnchantability(llllllllllllllllIllIIllIIllllIll) + 50;
    }
    
    static {
        __OBFID = "CL_00000119";
    }
    
    @Override
    public boolean canApplyTogether(final Enchantment llllllllllllllllIllIIllIIlllIllI) {
        return super.canApplyTogether(llllllllllllllllIllIIllIIlllIllI) && llllllllllllllllIllIIllIIlllIllI.effectId != EnchantmentLootBonus.silkTouch.effectId;
    }
    
    protected EnchantmentLootBonus(final int llllllllllllllllIllIIllIlIIIllIl, final ResourceLocation llllllllllllllllIllIIllIlIIIIlll, final int llllllllllllllllIllIIllIlIIIlIll, final EnumEnchantmentType llllllllllllllllIllIIllIlIIIIlIl) {
        super(llllllllllllllllIllIIllIlIIIllIl, llllllllllllllllIllIIllIlIIIIlll, llllllllllllllllIllIIllIlIIIlIll, llllllllllllllllIllIIllIlIIIIlIl);
        if (llllllllllllllllIllIIllIlIIIIlIl == EnumEnchantmentType.DIGGER) {
            this.setName("lootBonusDigger");
        }
        else if (llllllllllllllllIllIIllIlIIIIlIl == EnumEnchantmentType.FISHING_ROD) {
            this.setName("lootBonusFishing");
        }
        else {
            this.setName("lootBonus");
        }
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllllIllIIllIlIIIIIlI) {
        return 15 + (llllllllllllllllIllIIllIlIIIIIlI - 1) * 9;
    }
}
