package net.minecraft.enchantment;

import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public abstract class Enchantment
{
    public /* synthetic */ EnumEnchantmentType type;
    public final /* synthetic */ int effectId;
    private static final /* synthetic */ Map field_180307_E;
    private static final /* synthetic */ Enchantment[] field_180311_a;
    protected /* synthetic */ String name;
    private final /* synthetic */ int weight;
    
    public static String[] func_180304_c() {
        final String[] lllllllllllllllllIIlllIllIllllll = new String[Enchantment.field_180307_E.size()];
        int lllllllllllllllllIIlllIllIlllllI = 0;
        for (final ResourceLocation lllllllllllllllllIIlllIllIllllIl : Enchantment.field_180307_E.keySet()) {
            lllllllllllllllllIIlllIllIllllll[lllllllllllllllllIIlllIllIlllllI++] = lllllllllllllllllIIlllIllIllllIl.toString();
        }
        return lllllllllllllllllIIlllIllIllllll;
    }
    
    public int getMaxEnchantability(final int lllllllllllllllllIIlllIllIlIlIIl) {
        return this.getMinEnchantability(lllllllllllllllllIIlllIllIlIlIIl) + 5;
    }
    
    public boolean canApply(final ItemStack lllllllllllllllllIIlllIllIIIIlIl) {
        return this.type.canEnchantItem(lllllllllllllllllIIlllIllIIIIlIl.getItem());
    }
    
    public void func_151367_b(final EntityLivingBase lllllllllllllllllIIlllIlIlllllll, final Entity lllllllllllllllllIIlllIlIllllllI, final int lllllllllllllllllIIlllIlIlllllIl) {
    }
    
    public float func_152376_a(final int lllllllllllllllllIIlllIllIlIIlII, final EnumCreatureAttribute lllllllllllllllllIIlllIllIlIIIll) {
        return 0.0f;
    }
    
    protected Enchantment(final int lllllllllllllllllIIlllIlllIIllll, final ResourceLocation lllllllllllllllllIIlllIlllIIlIIl, final int lllllllllllllllllIIlllIlllIIllIl, final EnumEnchantmentType lllllllllllllllllIIlllIlllIIIlll) {
        this.effectId = lllllllllllllllllIIlllIlllIIllll;
        this.weight = lllllllllllllllllIIlllIlllIIllIl;
        this.type = lllllllllllllllllIIlllIlllIIIlll;
        if (Enchantment.field_180311_a[lllllllllllllllllIIlllIlllIIllll] != null) {
            throw new IllegalArgumentException("Duplicate enchantment id!");
        }
        Enchantment.field_180311_a[lllllllllllllllllIIlllIlllIIllll] = this;
        Enchantment.field_180307_E.put(lllllllllllllllllIIlllIlllIIlIIl, this);
    }
    
    public String getName() {
        return String.valueOf(new StringBuilder("enchantment.").append(this.name));
    }
    
    public void func_151368_a(final EntityLivingBase lllllllllllllllllIIlllIllIIIIIll, final Entity lllllllllllllllllIIlllIllIIIIIlI, final int lllllllllllllllllIIlllIllIIIIIIl) {
    }
    
    public int getMinEnchantability(final int lllllllllllllllllIIlllIllIlIllll) {
        return 1 + lllllllllllllllllIIlllIllIlIllll * 10;
    }
    
    public boolean canApplyTogether(final Enchantment lllllllllllllllllIIlllIllIIlllll) {
        return this != lllllllllllllllllIIlllIllIIlllll;
    }
    
    public String getTranslatedName(final int lllllllllllllllllIIlllIllIIIllll) {
        final String lllllllllllllllllIIlllIllIIIlllI = StatCollector.translateToLocal(this.getName());
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIlllIllIIIlllI)).append(" ").append(StatCollector.translateToLocal(String.valueOf(new StringBuilder("enchantment.level.").append(lllllllllllllllllIIlllIllIIIllll)))));
    }
    
    public Enchantment setName(final String lllllllllllllllllIIlllIllIIlIlll) {
        this.name = lllllllllllllllllIIlllIllIIlIlll;
        return this;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public static Enchantment func_180305_b(final String lllllllllllllllllIIlllIlllIIIlIl) {
        return Enchantment.field_180307_E.get(new ResourceLocation(lllllllllllllllllIIlllIlllIIIlIl));
    }
    
    public int getMinLevel() {
        return 1;
    }
    
    public static Enchantment func_180306_c(final int lllllllllllllllllIIlllIlllIlIllI) {
        return (lllllllllllllllllIIlllIlllIlIllI >= 0 && lllllllllllllllllIIlllIlllIlIllI < Enchantment.field_180311_a.length) ? Enchantment.field_180311_a[lllllllllllllllllIIlllIlllIlIllI] : null;
    }
    
    public int calcModifierDamage(final int lllllllllllllllllIIlllIllIlIIlll, final DamageSource lllllllllllllllllIIlllIllIlIIllI) {
        return 0;
    }
    
    static {
        __OBFID = "CL_00000105";
        field_180311_a = new Enchantment[256];
        field_180307_E = Maps.newHashMap();
        field_180310_c = new EnchantmentProtection(0, new ResourceLocation("protection"), 10, 0);
        fireProtection = new EnchantmentProtection(1, new ResourceLocation("fire_protection"), 5, 1);
        field_180309_e = new EnchantmentProtection(2, new ResourceLocation("feather_falling"), 5, 2);
        blastProtection = new EnchantmentProtection(3, new ResourceLocation("blast_protection"), 2, 3);
        field_180308_g = new EnchantmentProtection(4, new ResourceLocation("projectile_protection"), 5, 4);
        field_180317_h = new EnchantmentOxygen(5, new ResourceLocation("respiration"), 2);
        aquaAffinity = new EnchantmentWaterWorker(6, new ResourceLocation("aqua_affinity"), 2);
        thorns = new EnchantmentThorns(7, new ResourceLocation("thorns"), 1);
        field_180316_k = new EnchantmentWaterWalker(8, new ResourceLocation("depth_strider"), 2);
        field_180314_l = new EnchantmentDamage(16, new ResourceLocation("sharpness"), 10, 0);
        field_180315_m = new EnchantmentDamage(17, new ResourceLocation("smite"), 5, 1);
        field_180312_n = new EnchantmentDamage(18, new ResourceLocation("bane_of_arthropods"), 5, 2);
        field_180313_o = new EnchantmentKnockback(19, new ResourceLocation("knockback"), 5);
        fireAspect = new EnchantmentFireAspect(20, new ResourceLocation("fire_aspect"), 2);
        looting = new EnchantmentLootBonus(21, new ResourceLocation("looting"), 2, EnumEnchantmentType.WEAPON);
        efficiency = new EnchantmentDigging(32, new ResourceLocation("efficiency"), 10);
        silkTouch = new EnchantmentUntouching(33, new ResourceLocation("silk_touch"), 1);
        unbreaking = new EnchantmentDurability(34, new ResourceLocation("unbreaking"), 5);
        fortune = new EnchantmentLootBonus(35, new ResourceLocation("fortune"), 2, EnumEnchantmentType.DIGGER);
        power = new EnchantmentArrowDamage(48, new ResourceLocation("power"), 10);
        punch = new EnchantmentArrowKnockback(49, new ResourceLocation("punch"), 2);
        flame = new EnchantmentArrowFire(50, new ResourceLocation("flame"), 2);
        infinity = new EnchantmentArrowInfinite(51, new ResourceLocation("infinity"), 1);
        luckOfTheSea = new EnchantmentLootBonus(61, new ResourceLocation("luck_of_the_sea"), 2, EnumEnchantmentType.FISHING_ROD);
        lure = new EnchantmentFishingSpeed(62, new ResourceLocation("lure"), 2, EnumEnchantmentType.FISHING_ROD);
        final ArrayList lllllllllllllllllIIlllIllllIIIlI = Lists.newArrayList();
        for (final Enchantment lllllllllllllllllIIlllIlllIllllI : Enchantment.field_180311_a) {
            if (lllllllllllllllllIIlllIlllIllllI != null) {
                lllllllllllllllllIIlllIllllIIIlI.add(lllllllllllllllllIIlllIlllIllllI);
            }
        }
        enchantmentsList = lllllllllllllllllIIlllIllllIIIlI.toArray(new Enchantment[lllllllllllllllllIIlllIllllIIIlI.size()]);
    }
    
    public int getMaxLevel() {
        return 1;
    }
}
