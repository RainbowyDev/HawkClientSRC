package net.minecraft.enchantment;

import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EnchantmentProtection extends Enchantment
{
    private static final /* synthetic */ int[] thresholdEnchantability;
    private static final /* synthetic */ String[] protectionName;
    private static final /* synthetic */ int[] levelEnchantability;
    public final /* synthetic */ int protectionType;
    private static final /* synthetic */ int[] baseEnchantability;
    
    static {
        __OBFID = "CL_00000121";
        protectionName = new String[] { "all", "fire", "fall", "explosion", "projectile" };
        baseEnchantability = new int[] { 1, 10, 5, 5, 3 };
        levelEnchantability = new int[] { 11, 8, 6, 8, 6 };
        thresholdEnchantability = new int[] { 20, 12, 10, 12, 15 };
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIlIIIIIIIllllIIIIl) {
        return this.getMinEnchantability(llllllllllllllIlIIIIIIIllllIIIIl) + EnchantmentProtection.thresholdEnchantability[this.protectionType];
    }
    
    @Override
    public String getName() {
        return String.valueOf(new StringBuilder("enchantment.protect.").append(EnchantmentProtection.protectionName[this.protectionType]));
    }
    
    public EnchantmentProtection(final int llllllllllllllIlIIIIIIIlllllIIll, final ResourceLocation llllllllllllllIlIIIIIIIlllllIIlI, final int llllllllllllllIlIIIIIIIlllllIIIl, final int llllllllllllllIlIIIIIIIlllllIIII) {
        super(llllllllllllllIlIIIIIIIlllllIIll, llllllllllllllIlIIIIIIIlllllIIlI, llllllllllllllIlIIIIIIIlllllIIIl, EnumEnchantmentType.ARMOR);
        this.protectionType = llllllllllllllIlIIIIIIIlllllIIII;
        if (llllllllllllllIlIIIIIIIlllllIIII == 2) {
            this.type = EnumEnchantmentType.ARMOR_FEET;
        }
    }
    
    @Override
    public boolean canApplyTogether(final Enchantment llllllllllllllIlIIIIIIIlllIIlIlI) {
        if (llllllllllllllIlIIIIIIIlllIIlIlI instanceof EnchantmentProtection) {
            final EnchantmentProtection llllllllllllllIlIIIIIIIlllIIlIIl = (EnchantmentProtection)llllllllllllllIlIIIIIIIlllIIlIlI;
            return llllllllllllllIlIIIIIIIlllIIlIIl.protectionType != this.protectionType && (this.protectionType == 2 || llllllllllllllIlIIIIIIIlllIIlIIl.protectionType == 2);
        }
        return super.canApplyTogether(llllllllllllllIlIIIIIIIlllIIlIlI);
    }
    
    @Override
    public int calcModifierDamage(final int llllllllllllllIlIIIIIIIlllIllIII, final DamageSource llllllllllllllIlIIIIIIIlllIlIlll) {
        if (llllllllllllllIlIIIIIIIlllIlIlll.canHarmInCreative()) {
            return 0;
        }
        final float llllllllllllllIlIIIIIIIlllIlIllI = (6 + llllllllllllllIlIIIIIIIlllIllIII * llllllllllllllIlIIIIIIIlllIllIII) / 3.0f;
        return (this.protectionType == 0) ? MathHelper.floor_float(llllllllllllllIlIIIIIIIlllIlIllI * 0.75f) : ((this.protectionType == 1 && llllllllllllllIlIIIIIIIlllIlIlll.isFireDamage()) ? MathHelper.floor_float(llllllllllllllIlIIIIIIIlllIlIllI * 1.25f) : ((this.protectionType == 2 && llllllllllllllIlIIIIIIIlllIlIlll == DamageSource.fall) ? MathHelper.floor_float(llllllllllllllIlIIIIIIIlllIlIllI * 2.5f) : ((this.protectionType == 3 && llllllllllllllIlIIIIIIIlllIlIlll.isExplosion()) ? MathHelper.floor_float(llllllllllllllIlIIIIIIIlllIlIllI * 1.5f) : ((this.protectionType == 4 && llllllllllllllIlIIIIIIIlllIlIlll.isProjectile()) ? MathHelper.floor_float(llllllllllllllIlIIIIIIIlllIlIllI * 1.5f) : 0))));
    }
    
    public static double func_92092_a(final Entity llllllllllllllIlIIIIIIIllIlllIIl, double llllllllllllllIlIIIIIIIllIllIlIl) {
        final int llllllllllllllIlIIIIIIIllIllIlll = EnchantmentHelper.getMaxEnchantmentLevel(Enchantment.blastProtection.effectId, llllllllllllllIlIIIIIIIllIlllIIl.getInventory());
        if (llllllllllllllIlIIIIIIIllIllIlll > 0) {
            llllllllllllllIlIIIIIIIllIllIlIl -= MathHelper.floor_double(llllllllllllllIlIIIIIIIllIllIlIl * (llllllllllllllIlIIIIIIIllIllIlll * 0.15f));
        }
        return llllllllllllllIlIIIIIIIllIllIlIl;
    }
    
    @Override
    public int getMaxLevel() {
        return 4;
    }
    
    public static int getFireTimeForEntity(final Entity llllllllllllllIlIIIIIIIllIllllll, int llllllllllllllIlIIIIIIIllIlllllI) {
        final int llllllllllllllIlIIIIIIIlllIIIIII = EnchantmentHelper.getMaxEnchantmentLevel(Enchantment.fireProtection.effectId, llllllllllllllIlIIIIIIIllIllllll.getInventory());
        if (llllllllllllllIlIIIIIIIlllIIIIII > 0) {
            llllllllllllllIlIIIIIIIllIlllllI -= MathHelper.floor_float(llllllllllllllIlIIIIIIIllIlllllI * (float)llllllllllllllIlIIIIIIIlllIIIIII * 0.15f);
        }
        return llllllllllllllIlIIIIIIIllIlllllI;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIlIIIIIIIllllIIlIl) {
        return EnchantmentProtection.baseEnchantability[this.protectionType] + (llllllllllllllIlIIIIIIIllllIIlIl - 1) * EnchantmentProtection.levelEnchantability[this.protectionType];
    }
}
