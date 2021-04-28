package net.minecraft.enchantment;

import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class EnchantmentDigging extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllllIIlIllllIIIlIlIl) {
        return super.getMinEnchantability(llllllllllllllllIIlIllllIIIlIlIl) + 50;
    }
    
    protected EnchantmentDigging(final int llllllllllllllllIIlIllllIIIlllll, final ResourceLocation llllllllllllllllIIlIllllIIIllllI, final int llllllllllllllllIIlIllllIIIlllIl) {
        super(llllllllllllllllIIlIllllIIIlllll, llllllllllllllllIIlIllllIIIllllI, llllllllllllllllIIlIllllIIIlllIl, EnumEnchantmentType.DIGGER);
        this.setName("digging");
    }
    
    @Override
    public boolean canApply(final ItemStack llllllllllllllllIIlIllllIIIIllII) {
        return llllllllllllllllIIlIllllIIIIllII.getItem() == Items.shears || super.canApply(llllllllllllllllIIlIllllIIIIllII);
    }
    
    static {
        __OBFID = "CL_00000104";
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllllIIlIllllIIIllIlI) {
        return 1 + 10 * (llllllllllllllllIIlIllllIIIllIlI - 1);
    }
}
