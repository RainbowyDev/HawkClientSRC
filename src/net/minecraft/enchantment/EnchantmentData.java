package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentData extends WeightedRandom.Item
{
    public final /* synthetic */ int enchantmentLevel;
    public final /* synthetic */ Enchantment enchantmentobj;
    
    public EnchantmentData(final Enchantment llllllllllllllIIIIllIllIIIIlIlll, final int llllllllllllllIIIIllIllIIIIlIllI) {
        super(llllllllllllllIIIIllIllIIIIlIlll.getWeight());
        this.enchantmentobj = llllllllllllllIIIIllIllIIIIlIlll;
        this.enchantmentLevel = llllllllllllllIIIIllIllIIIIlIllI;
    }
    
    static {
        __OBFID = "CL_00000115";
    }
}
