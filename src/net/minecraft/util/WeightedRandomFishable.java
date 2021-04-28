package net.minecraft.util;

import net.minecraft.item.*;
import java.util.*;
import net.minecraft.enchantment.*;

public class WeightedRandomFishable extends WeightedRandom.Item
{
    private /* synthetic */ float maxDamagePercent;
    private /* synthetic */ boolean enchantable;
    private final /* synthetic */ ItemStack returnStack;
    
    static {
        __OBFID = "CL_00001664";
    }
    
    public WeightedRandomFishable setMaxDamagePercent(final float lllllllllllllllIIllIIllIlIlIIlIl) {
        this.maxDamagePercent = lllllllllllllllIIllIIllIlIlIIlIl;
        return this;
    }
    
    public ItemStack getItemStack(final Random lllllllllllllllIIllIIllIlIllIIll) {
        final ItemStack lllllllllllllllIIllIIllIlIllIIlI = this.returnStack.copy();
        if (this.maxDamagePercent > 0.0f) {
            final int lllllllllllllllIIllIIllIlIllIIIl = (int)(this.maxDamagePercent * this.returnStack.getMaxDamage());
            int lllllllllllllllIIllIIllIlIllIIII = lllllllllllllllIIllIIllIlIllIIlI.getMaxDamage() - lllllllllllllllIIllIIllIlIllIIll.nextInt(lllllllllllllllIIllIIllIlIllIIll.nextInt(lllllllllllllllIIllIIllIlIllIIIl) + 1);
            if (lllllllllllllllIIllIIllIlIllIIII > lllllllllllllllIIllIIllIlIllIIIl) {
                lllllllllllllllIIllIIllIlIllIIII = lllllllllllllllIIllIIllIlIllIIIl;
            }
            if (lllllllllllllllIIllIIllIlIllIIII < 1) {
                lllllllllllllllIIllIIllIlIllIIII = 1;
            }
            lllllllllllllllIIllIIllIlIllIIlI.setItemDamage(lllllllllllllllIIllIIllIlIllIIII);
        }
        if (this.enchantable) {
            EnchantmentHelper.addRandomEnchantment(lllllllllllllllIIllIIllIlIllIIll, lllllllllllllllIIllIIllIlIllIIlI, 30);
        }
        return lllllllllllllllIIllIIllIlIllIIlI;
    }
    
    public WeightedRandomFishable setEnchantable() {
        this.enchantable = true;
        return this;
    }
    
    public WeightedRandomFishable(final ItemStack lllllllllllllllIIllIIllIlIlllllI, final int lllllllllllllllIIllIIllIlIllllIl) {
        super(lllllllllllllllIIllIIllIlIllllIl);
        this.returnStack = lllllllllllllllIIllIIllIlIlllllI;
    }
}
