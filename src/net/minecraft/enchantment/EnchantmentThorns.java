package net.minecraft.enchantment;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EnchantmentThorns extends Enchantment
{
    public static boolean func_92094_a(final int llllllllllllllIIIllIlIIlIlIIIIlI, final Random llllllllllllllIIIllIlIIlIlIIIIIl) {
        return llllllllllllllIIIllIlIIlIlIIIIlI > 0 && llllllllllllllIIIllIlIIlIlIIIIIl.nextFloat() < 0.15f * llllllllllllllIIIllIlIIlIlIIIIlI;
    }
    
    static {
        __OBFID = "CL_00000122";
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    public static int func_92095_b(final int llllllllllllllIIIllIlIIlIIllllII, final Random llllllllllllllIIIllIlIIlIIlllIll) {
        return (llllllllllllllIIIllIlIIlIIllllII > 10) ? (llllllllllllllIIIllIlIIlIIllllII - 10) : (1 + llllllllllllllIIIllIlIIlIIlllIll.nextInt(4));
    }
    
    @Override
    public boolean canApply(final ItemStack llllllllllllllIIIllIlIIlIlIlIlll) {
        return llllllllllllllIIIllIlIIlIlIlIlll.getItem() instanceof ItemArmor || super.canApply(llllllllllllllIIIllIlIIlIlIlIlll);
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIIIllIlIIlIlIllllI) {
        return super.getMinEnchantability(llllllllllllllIIIllIlIIlIlIllllI) + 50;
    }
    
    @Override
    public void func_151367_b(final EntityLivingBase llllllllllllllIIIllIlIIlIlIIlIll, final Entity llllllllllllllIIIllIlIIlIlIIlIlI, final int llllllllllllllIIIllIlIIlIlIIlllI) {
        final Random llllllllllllllIIIllIlIIlIlIIllIl = llllllllllllllIIIllIlIIlIlIIlIll.getRNG();
        final ItemStack llllllllllllllIIIllIlIIlIlIIllII = EnchantmentHelper.func_92099_a(Enchantment.thorns, llllllllllllllIIIllIlIIlIlIIlIll);
        if (func_92094_a(llllllllllllllIIIllIlIIlIlIIlllI, llllllllllllllIIIllIlIIlIlIIllIl)) {
            llllllllllllllIIIllIlIIlIlIIlIlI.attackEntityFrom(DamageSource.causeThornsDamage(llllllllllllllIIIllIlIIlIlIIlIll), (float)func_92095_b(llllllllllllllIIIllIlIIlIlIIlllI, llllllllllllllIIIllIlIIlIlIIllIl));
            llllllllllllllIIIllIlIIlIlIIlIlI.playSound("damage.thorns", 0.5f, 1.0f);
            if (llllllllllllllIIIllIlIIlIlIIllII != null) {
                llllllllllllllIIIllIlIIlIlIIllII.damageItem(3, llllllllllllllIIIllIlIIlIlIIlIll);
            }
        }
        else if (llllllllllllllIIIllIlIIlIlIIllII != null) {
            llllllllllllllIIIllIlIIlIlIIllII.damageItem(1, llllllllllllllIIIllIlIIlIlIIlIll);
        }
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIIIllIlIIlIllIIlII) {
        return 10 + 20 * (llllllllllllllIIIllIlIIlIllIIlII - 1);
    }
    
    public EnchantmentThorns(final int llllllllllllllIIIllIlIIlIllIlIlI, final ResourceLocation llllllllllllllIIIllIlIIlIllIlIIl, final int llllllllllllllIIIllIlIIlIllIlIII) {
        super(llllllllllllllIIIllIlIIlIllIlIlI, llllllllllllllIIIllIlIIlIllIlIIl, llllllllllllllIIIllIlIIlIllIlIII, EnumEnchantmentType.ARMOR_TORSO);
        this.setName("thorns");
    }
}
