package net.minecraft.enchantment;

import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class EnchantmentDamage extends Enchantment
{
    private static final /* synthetic */ int[] baseEnchantability;
    private static final /* synthetic */ String[] protectionName;
    public final /* synthetic */ int damageType;
    private static final /* synthetic */ int[] levelEnchantability;
    private static final /* synthetic */ int[] thresholdEnchantability;
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllllllIlllllIIllIlIIl) {
        return this.getMinEnchantability(lllllllllllllllllIlllllIIllIlIIl) + EnchantmentDamage.thresholdEnchantability[this.damageType];
    }
    
    @Override
    public float func_152376_a(final int lllllllllllllllllIlllllIIlIllllI, final EnumCreatureAttribute lllllllllllllllllIlllllIIllIIIII) {
        return (this.damageType == 0) ? (lllllllllllllllllIlllllIIlIllllI * 1.25f) : ((this.damageType == 1 && lllllllllllllllllIlllllIIllIIIII == EnumCreatureAttribute.UNDEAD) ? (lllllllllllllllllIlllllIIlIllllI * 2.5f) : ((this.damageType == 2 && lllllllllllllllllIlllllIIllIIIII == EnumCreatureAttribute.ARTHROPOD) ? (lllllllllllllllllIlllllIIlIllllI * 2.5f) : 0.0f));
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    @Override
    public void func_151368_a(final EntityLivingBase lllllllllllllllllIlllllIIlIIlIII, final Entity lllllllllllllllllIlllllIIlIIIlll, final int lllllllllllllllllIlllllIIlIIIllI) {
        if (lllllllllllllllllIlllllIIlIIIlll instanceof EntityLivingBase) {
            final EntityLivingBase lllllllllllllllllIlllllIIlIIIlIl = (EntityLivingBase)lllllllllllllllllIlllllIIlIIIlll;
            if (this.damageType == 2 && lllllllllllllllllIlllllIIlIIIlIl.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) {
                final int lllllllllllllllllIlllllIIlIIIlII = 20 + lllllllllllllllllIlllllIIlIIlIII.getRNG().nextInt(10 * lllllllllllllllllIlllllIIlIIIllI);
                lllllllllllllllllIlllllIIlIIIlIl.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, lllllllllllllllllIlllllIIlIIIlII, 3));
            }
        }
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllllllIlllllIIllIllIl) {
        return EnchantmentDamage.baseEnchantability[this.damageType] + (lllllllllllllllllIlllllIIllIllIl - 1) * EnchantmentDamage.levelEnchantability[this.damageType];
    }
    
    public EnchantmentDamage(final int lllllllllllllllllIlllllIIlllIllI, final ResourceLocation lllllllllllllllllIlllllIIllllIlI, final int lllllllllllllllllIlllllIIlllIlII, final int lllllllllllllllllIlllllIIlllIIll) {
        super(lllllllllllllllllIlllllIIlllIllI, lllllllllllllllllIlllllIIllllIlI, lllllllllllllllllIlllllIIlllIlII, EnumEnchantmentType.WEAPON);
        this.damageType = lllllllllllllllllIlllllIIlllIIll;
    }
    
    static {
        __OBFID = "CL_00000102";
        protectionName = new String[] { "all", "undead", "arthropods" };
        baseEnchantability = new int[] { 1, 5, 5 };
        levelEnchantability = new int[] { 11, 8, 8 };
        thresholdEnchantability = new int[] { 20, 20, 20 };
    }
    
    @Override
    public boolean canApplyTogether(final Enchantment lllllllllllllllllIlllllIIlIlIllI) {
        return !(lllllllllllllllllIlllllIIlIlIllI instanceof EnchantmentDamage);
    }
    
    @Override
    public boolean canApply(final ItemStack lllllllllllllllllIlllllIIlIlIIlI) {
        return lllllllllllllllllIlllllIIlIlIIlI.getItem() instanceof ItemAxe || super.canApply(lllllllllllllllllIlllllIIlIlIIlI);
    }
    
    @Override
    public String getName() {
        return String.valueOf(new StringBuilder("enchantment.damage.").append(EnchantmentDamage.protectionName[this.damageType]));
    }
}
