package net.minecraft.enchantment;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class EnchantmentHelper
{
    private static final /* synthetic */ DamageIterator field_151389_e;
    private static final /* synthetic */ Random enchantmentRand;
    private static final /* synthetic */ HurtIterator field_151388_d;
    private static final /* synthetic */ ModifierDamage enchantmentModifierDamage;
    private static final /* synthetic */ ModifierLiving enchantmentModifierLiving;
    
    public static boolean getSilkTouchModifier(final EntityLivingBase llllllllllllllllIlllIIIllIlIIlll) {
        return getEnchantmentLevel(Enchantment.silkTouch.effectId, llllllllllllllllIlllIIIllIlIIlll.getHeldItem()) > 0;
    }
    
    public static int getFortuneModifier(final EntityLivingBase llllllllllllllllIlllIIIllIlIIlII) {
        return getEnchantmentLevel(Enchantment.fortune.effectId, llllllllllllllllIlllIIIllIlIIlII.getHeldItem());
    }
    
    public static int getFireAspectModifier(final EntityLivingBase llllllllllllllllIlllIIIllIllIIll) {
        return getEnchantmentLevel(Enchantment.fireAspect.effectId, llllllllllllllllIlllIIIllIllIIll.getHeldItem());
    }
    
    public static int calcItemStackEnchantability(final Random llllllllllllllllIlllIIIlIlllIlll, final int llllllllllllllllIlllIIIlIlllllIl, int llllllllllllllllIlllIIIlIlllIlIl, final ItemStack llllllllllllllllIlllIIIlIlllIlII) {
        final Item llllllllllllllllIlllIIIlIllllIlI = llllllllllllllllIlllIIIlIlllIlII.getItem();
        final int llllllllllllllllIlllIIIlIllllIIl = llllllllllllllllIlllIIIlIllllIlI.getItemEnchantability();
        if (llllllllllllllllIlllIIIlIllllIIl <= 0) {
            return 0;
        }
        if (llllllllllllllllIlllIIIlIlllIlIl > 15) {
            llllllllllllllllIlllIIIlIlllIlIl = 15;
        }
        final int llllllllllllllllIlllIIIlIllllIII = llllllllllllllllIlllIIIlIlllIlll.nextInt(8) + 1 + (llllllllllllllllIlllIIIlIlllIlIl >> 1) + llllllllllllllllIlllIIIlIlllIlll.nextInt(llllllllllllllllIlllIIIlIlllIlIl + 1);
        return (llllllllllllllllIlllIIIlIlllllIl == 0) ? Math.max(llllllllllllllllIlllIIIlIllllIII / 3, 1) : ((llllllllllllllllIlllIIIlIlllllIl == 1) ? (llllllllllllllllIlllIIIlIllllIII * 2 / 3 + 1) : Math.max(llllllllllllllllIlllIIIlIllllIII, llllllllllllllllIlllIIIlIlllIlIl * 2));
    }
    
    public static int getRespiration(final EntityLivingBase llllllllllllllllIlllIIIllIllIllI) {
        return getEnchantmentLevel(Enchantment.field_180313_o.effectId, llllllllllllllllIlllIIIllIllIllI.getHeldItem());
    }
    
    public static void func_151384_a(final EntityLivingBase llllllllllllllllIlllIIIlllIIIIlI, final Entity llllllllllllllllIlllIIIllIllllll) {
        EnchantmentHelper.field_151388_d.field_151363_b = llllllllllllllllIlllIIIllIllllll;
        EnchantmentHelper.field_151388_d.field_151364_a = llllllllllllllllIlllIIIlllIIIIlI;
        if (llllllllllllllllIlllIIIlllIIIIlI != null) {
            applyEnchantmentModifierArray(EnchantmentHelper.field_151388_d, llllllllllllllllIlllIIIlllIIIIlI.getInventory());
        }
        if (llllllllllllllllIlllIIIllIllllll instanceof EntityPlayer) {
            applyEnchantmentModifier(EnchantmentHelper.field_151388_d, llllllllllllllllIlllIIIlllIIIIlI.getHeldItem());
        }
    }
    
    public static int getEnchantmentModifierDamage(final ItemStack[] llllllllllllllllIlllIIIlllIIllII, final DamageSource llllllllllllllllIlllIIIlllIIllIl) {
        EnchantmentHelper.enchantmentModifierDamage.damageModifier = 0;
        EnchantmentHelper.enchantmentModifierDamage.source = llllllllllllllllIlllIIIlllIIllIl;
        applyEnchantmentModifierArray(EnchantmentHelper.enchantmentModifierDamage, llllllllllllllllIlllIIIlllIIllII);
        if (EnchantmentHelper.enchantmentModifierDamage.damageModifier > 25) {
            EnchantmentHelper.enchantmentModifierDamage.damageModifier = 25;
        }
        return (EnchantmentHelper.enchantmentModifierDamage.damageModifier + 1 >> 1) + EnchantmentHelper.enchantmentRand.nextInt((EnchantmentHelper.enchantmentModifierDamage.damageModifier >> 1) + 1);
    }
    
    public static int func_180319_a(final Entity llllllllllllllllIlllIIIllIllIIII) {
        return getMaxEnchantmentLevel(Enchantment.field_180317_h.effectId, llllllllllllllllIlllIIIllIllIIII.getInventory());
    }
    
    public static int getMaxEnchantmentLevel(final int llllllllllllllllIlllIIIlllllllII, final ItemStack[] llllllllllllllllIlllIIlIIIIIIIll) {
        if (llllllllllllllllIlllIIlIIIIIIIll == null) {
            return 0;
        }
        int llllllllllllllllIlllIIlIIIIIIIlI = 0;
        final ItemStack[] llllllllllllllllIlllIIlIIIIIIIIl = llllllllllllllllIlllIIlIIIIIIIll;
        for (int llllllllllllllllIlllIIlIIIIIIIII = llllllllllllllllIlllIIlIIIIIIIll.length, llllllllllllllllIlllIIIlllllllll = 0; llllllllllllllllIlllIIIlllllllll < llllllllllllllllIlllIIlIIIIIIIII; ++llllllllllllllllIlllIIIlllllllll) {
            final ItemStack llllllllllllllllIlllIIIllllllllI = llllllllllllllllIlllIIlIIIIIIIIl[llllllllllllllllIlllIIIlllllllll];
            final int llllllllllllllllIlllIIIlllllllIl = getEnchantmentLevel(llllllllllllllllIlllIIIlllllllII, llllllllllllllllIlllIIIllllllllI);
            if (llllllllllllllllIlllIIIlllllllIl > llllllllllllllllIlllIIlIIIIIIIlI) {
                llllllllllllllllIlllIIlIIIIIIIlI = llllllllllllllllIlllIIIlllllllIl;
            }
        }
        return llllllllllllllllIlllIIlIIIIIIIlI;
    }
    
    public static int func_180318_b(final Entity llllllllllllllllIlllIIIllIlIllIl) {
        return getMaxEnchantmentLevel(Enchantment.field_180316_k.effectId, llllllllllllllllIlllIIIllIlIllIl.getInventory());
    }
    
    public static void setEnchantments(final Map llllllllllllllllIlllIIlIIIIlIIll, final ItemStack llllllllllllllllIlllIIlIIIIlIIlI) {
        final NBTTagList llllllllllllllllIlllIIlIIIIllIII = new NBTTagList();
        for (final int llllllllllllllllIlllIIlIIIIlIllI : llllllllllllllllIlllIIlIIIIlIIll.keySet()) {
            final Enchantment llllllllllllllllIlllIIlIIIIlIlIl = Enchantment.func_180306_c(llllllllllllllllIlllIIlIIIIlIllI);
            if (llllllllllllllllIlllIIlIIIIlIlIl != null) {
                final NBTTagCompound llllllllllllllllIlllIIlIIIIlIlII = new NBTTagCompound();
                llllllllllllllllIlllIIlIIIIlIlII.setShort("id", (short)llllllllllllllllIlllIIlIIIIlIllI);
                llllllllllllllllIlllIIlIIIIlIlII.setShort("lvl", (short)(int)llllllllllllllllIlllIIlIIIIlIIll.get(llllllllllllllllIlllIIlIIIIlIllI));
                llllllllllllllllIlllIIlIIIIllIII.appendTag(llllllllllllllllIlllIIlIIIIlIlII);
                if (llllllllllllllllIlllIIlIIIIlIIlI.getItem() != Items.enchanted_book) {
                    continue;
                }
                Items.enchanted_book.addEnchantment(llllllllllllllllIlllIIlIIIIlIIlI, new EnchantmentData(llllllllllllllllIlllIIlIIIIlIlIl, llllllllllllllllIlllIIlIIIIlIIll.get(llllllllllllllllIlllIIlIIIIlIllI)));
            }
        }
        if (llllllllllllllllIlllIIlIIIIllIII.tagCount() > 0) {
            if (llllllllllllllllIlllIIlIIIIlIIlI.getItem() != Items.enchanted_book) {
                llllllllllllllllIlllIIlIIIIlIIlI.setTagInfo("ench", llllllllllllllllIlllIIlIIIIllIII);
            }
        }
        else if (llllllllllllllllIlllIIlIIIIlIIlI.hasTagCompound()) {
            llllllllllllllllIlllIIlIIIIlIIlI.getTagCompound().removeTag("ench");
        }
    }
    
    public static ItemStack addRandomEnchantment(final Random llllllllllllllllIlllIIIlIllIIIlI, final ItemStack llllllllllllllllIlllIIIlIllIIIIl, final int llllllllllllllllIlllIIIlIllIIlll) {
        final List llllllllllllllllIlllIIIlIllIIllI = buildEnchantmentList(llllllllllllllllIlllIIIlIllIIIlI, llllllllllllllllIlllIIIlIllIIIIl, llllllllllllllllIlllIIIlIllIIlll);
        final boolean llllllllllllllllIlllIIIlIllIIlIl = llllllllllllllllIlllIIIlIllIIIIl.getItem() == Items.book;
        if (llllllllllllllllIlllIIIlIllIIlIl) {
            llllllllllllllllIlllIIIlIllIIIIl.setItem(Items.enchanted_book);
        }
        if (llllllllllllllllIlllIIIlIllIIllI != null) {
            for (final EnchantmentData llllllllllllllllIlllIIIlIllIIIll : llllllllllllllllIlllIIIlIllIIllI) {
                if (llllllllllllllllIlllIIIlIllIIlIl) {
                    Items.enchanted_book.addEnchantment(llllllllllllllllIlllIIIlIllIIIIl, llllllllllllllllIlllIIIlIllIIIll);
                }
                else {
                    llllllllllllllllIlllIIIlIllIIIIl.addEnchantment(llllllllllllllllIlllIIIlIllIIIll.enchantmentobj, llllllllllllllllIlllIIIlIllIIIll.enchantmentLevel);
                }
            }
        }
        return llllllllllllllllIlllIIIlIllIIIIl;
    }
    
    public static Map mapEnchantmentData(final int llllllllllllllllIlllIIIlIIIlllIl, final ItemStack llllllllllllllllIlllIIIlIIIlllII) {
        final Item llllllllllllllllIlllIIIlIIIllIll = llllllllllllllllIlllIIIlIIIlllII.getItem();
        HashMap llllllllllllllllIlllIIIlIIIllIlI = null;
        final boolean llllllllllllllllIlllIIIlIIIllIIl = llllllllllllllllIlllIIIlIIIlllII.getItem() == Items.book;
        for (final Enchantment llllllllllllllllIlllIIIlIIIlIlIl : Enchantment.enchantmentsList) {
            if (llllllllllllllllIlllIIIlIIIlIlIl != null && (llllllllllllllllIlllIIIlIIIlIlIl.type.canEnchantItem(llllllllllllllllIlllIIIlIIIllIll) || llllllllllllllllIlllIIIlIIIllIIl)) {
                for (int llllllllllllllllIlllIIIlIIIlIlII = llllllllllllllllIlllIIIlIIIlIlIl.getMinLevel(); llllllllllllllllIlllIIIlIIIlIlII <= llllllllllllllllIlllIIIlIIIlIlIl.getMaxLevel(); ++llllllllllllllllIlllIIIlIIIlIlII) {
                    if (llllllllllllllllIlllIIIlIIIlllIl >= llllllllllllllllIlllIIIlIIIlIlIl.getMinEnchantability(llllllllllllllllIlllIIIlIIIlIlII) && llllllllllllllllIlllIIIlIIIlllIl <= llllllllllllllllIlllIIIlIIIlIlIl.getMaxEnchantability(llllllllllllllllIlllIIIlIIIlIlII)) {
                        if (llllllllllllllllIlllIIIlIIIllIlI == null) {
                            llllllllllllllllIlllIIIlIIIllIlI = Maps.newHashMap();
                        }
                        llllllllllllllllIlllIIIlIIIllIlI.put(llllllllllllllllIlllIIIlIIIlIlIl.effectId, new EnchantmentData(llllllllllllllllIlllIIIlIIIlIlIl, llllllllllllllllIlllIIIlIIIlIlII));
                    }
                }
            }
        }
        return llllllllllllllllIlllIIIlIIIllIlI;
    }
    
    public static int getEfficiencyModifier(final EntityLivingBase llllllllllllllllIlllIIIllIlIlIll) {
        return getEnchantmentLevel(Enchantment.efficiency.effectId, llllllllllllllllIlllIIIllIlIlIll.getHeldItem());
    }
    
    public static ItemStack func_92099_a(final Enchantment llllllllllllllllIlllIIIllIIlIIIl, final EntityLivingBase llllllllllllllllIlllIIIllIIIlIlI) {
        for (final ItemStack llllllllllllllllIlllIIIllIIIllII : llllllllllllllllIlllIIIllIIIlIlI.getInventory()) {
            if (llllllllllllllllIlllIIIllIIIllII != null && getEnchantmentLevel(llllllllllllllllIlllIIIllIIlIIIl.effectId, llllllllllllllllIlllIIIllIIIllII) > 0) {
                return llllllllllllllllIlllIIIllIIIllII;
            }
        }
        return null;
    }
    
    public static boolean getAquaAffinityModifier(final EntityLivingBase llllllllllllllllIlllIIIllIIllIIl) {
        return getMaxEnchantmentLevel(Enchantment.aquaAffinity.effectId, llllllllllllllllIlllIIIllIIllIIl.getInventory()) > 0;
    }
    
    public static int func_151386_g(final EntityLivingBase llllllllllllllllIlllIIIllIlIIIlI) {
        return getEnchantmentLevel(Enchantment.luckOfTheSea.effectId, llllllllllllllllIlllIIIllIlIIIlI.getHeldItem());
    }
    
    public static Map getEnchantments(final ItemStack llllllllllllllllIlllIIlIIIlIIlll) {
        final LinkedHashMap llllllllllllllllIlllIIlIIIlIllII = Maps.newLinkedHashMap();
        final NBTTagList llllllllllllllllIlllIIlIIIlIlIll = (llllllllllllllllIlllIIlIIIlIIlll.getItem() == Items.enchanted_book) ? Items.enchanted_book.func_92110_g(llllllllllllllllIlllIIlIIIlIIlll) : llllllllllllllllIlllIIlIIIlIIlll.getEnchantmentTagList();
        if (llllllllllllllllIlllIIlIIIlIlIll != null) {
            for (int llllllllllllllllIlllIIlIIIlIlIlI = 0; llllllllllllllllIlllIIlIIIlIlIlI < llllllllllllllllIlllIIlIIIlIlIll.tagCount(); ++llllllllllllllllIlllIIlIIIlIlIlI) {
                final short llllllllllllllllIlllIIlIIIlIlIIl = llllllllllllllllIlllIIlIIIlIlIll.getCompoundTagAt(llllllllllllllllIlllIIlIIIlIlIlI).getShort("id");
                final short llllllllllllllllIlllIIlIIIlIlIII = llllllllllllllllIlllIIlIIIlIlIll.getCompoundTagAt(llllllllllllllllIlllIIlIIIlIlIlI).getShort("lvl");
                llllllllllllllllIlllIIlIIIlIllII.put((int)llllllllllllllllIlllIIlIIIlIlIIl, (int)llllllllllllllllIlllIIlIIIlIlIII);
            }
        }
        return llllllllllllllllIlllIIlIIIlIllII;
    }
    
    public static float func_152377_a(final ItemStack llllllllllllllllIlllIIIlllIIlIII, final EnumCreatureAttribute llllllllllllllllIlllIIIlllIIIlIl) {
        EnchantmentHelper.enchantmentModifierLiving.livingModifier = 0.0f;
        EnchantmentHelper.enchantmentModifierLiving.entityLiving = llllllllllllllllIlllIIIlllIIIlIl;
        applyEnchantmentModifier(EnchantmentHelper.enchantmentModifierLiving, llllllllllllllllIlllIIIlllIIlIII);
        return EnchantmentHelper.enchantmentModifierLiving.livingModifier;
    }
    
    private static void applyEnchantmentModifier(final IModifier llllllllllllllllIlllIIIllllIlllI, final ItemStack llllllllllllllllIlllIIIllllIllIl) {
        if (llllllllllllllllIlllIIIllllIllIl != null) {
            final NBTTagList llllllllllllllllIlllIIIllllIllII = llllllllllllllllIlllIIIllllIllIl.getEnchantmentTagList();
            if (llllllllllllllllIlllIIIllllIllII != null) {
                for (int llllllllllllllllIlllIIIllllIlIll = 0; llllllllllllllllIlllIIIllllIlIll < llllllllllllllllIlllIIIllllIllII.tagCount(); ++llllllllllllllllIlllIIIllllIlIll) {
                    final short llllllllllllllllIlllIIIllllIlIlI = llllllllllllllllIlllIIIllllIllII.getCompoundTagAt(llllllllllllllllIlllIIIllllIlIll).getShort("id");
                    final short llllllllllllllllIlllIIIllllIlIIl = llllllllllllllllIlllIIIllllIllII.getCompoundTagAt(llllllllllllllllIlllIIIllllIlIll).getShort("lvl");
                    if (Enchantment.func_180306_c(llllllllllllllllIlllIIIllllIlIlI) != null) {
                        llllllllllllllllIlllIIIllllIlllI.calculateModifier(Enchantment.func_180306_c(llllllllllllllllIlllIIIllllIlIlI), llllllllllllllllIlllIIIllllIlIIl);
                    }
                }
            }
        }
    }
    
    public static int getEnchantmentLevel(final int llllllllllllllllIlllIIlIIIllllll, final ItemStack llllllllllllllllIlllIIlIIIlllllI) {
        if (llllllllllllllllIlllIIlIIIlllllI == null) {
            return 0;
        }
        final NBTTagList llllllllllllllllIlllIIlIIIllllIl = llllllllllllllllIlllIIlIIIlllllI.getEnchantmentTagList();
        if (llllllllllllllllIlllIIlIIIllllIl == null) {
            return 0;
        }
        for (int llllllllllllllllIlllIIlIIIllllII = 0; llllllllllllllllIlllIIlIIIllllII < llllllllllllllllIlllIIlIIIllllIl.tagCount(); ++llllllllllllllllIlllIIlIIIllllII) {
            final short llllllllllllllllIlllIIlIIIlllIll = llllllllllllllllIlllIIlIIIllllIl.getCompoundTagAt(llllllllllllllllIlllIIlIIIllllII).getShort("id");
            final short llllllllllllllllIlllIIlIIIlllIlI = llllllllllllllllIlllIIlIIIllllIl.getCompoundTagAt(llllllllllllllllIlllIIlIIIllllII).getShort("lvl");
            if (llllllllllllllllIlllIIlIIIlllIll == llllllllllllllllIlllIIlIIIllllll) {
                return llllllllllllllllIlllIIlIIIlllIlI;
            }
        }
        return 0;
    }
    
    private static void applyEnchantmentModifierArray(final IModifier llllllllllllllllIlllIIIlllIlIllI, final ItemStack[] llllllllllllllllIlllIIIlllIllIll) {
        final ItemStack[] llllllllllllllllIlllIIIlllIllIlI = llllllllllllllllIlllIIIlllIllIll;
        for (int llllllllllllllllIlllIIIlllIllIIl = llllllllllllllllIlllIIIlllIllIll.length, llllllllllllllllIlllIIIlllIllIII = 0; llllllllllllllllIlllIIIlllIllIII < llllllllllllllllIlllIIIlllIllIIl; ++llllllllllllllllIlllIIIlllIllIII) {
            final ItemStack llllllllllllllllIlllIIIlllIlIlll = llllllllllllllllIlllIIIlllIllIlI[llllllllllllllllIlllIIIlllIllIII];
            applyEnchantmentModifier(llllllllllllllllIlllIIIlllIlIllI, llllllllllllllllIlllIIIlllIlIlll);
        }
    }
    
    public static void func_151385_b(final EntityLivingBase llllllllllllllllIlllIIIllIlllIlI, final Entity llllllllllllllllIlllIIIllIlllIll) {
        EnchantmentHelper.field_151389_e.field_151366_a = llllllllllllllllIlllIIIllIlllIlI;
        EnchantmentHelper.field_151389_e.field_151365_b = llllllllllllllllIlllIIIllIlllIll;
        if (llllllllllllllllIlllIIIllIlllIlI != null) {
            applyEnchantmentModifierArray(EnchantmentHelper.field_151389_e, llllllllllllllllIlllIIIllIlllIlI.getInventory());
        }
        if (llllllllllllllllIlllIIIllIlllIlI instanceof EntityPlayer) {
            applyEnchantmentModifier(EnchantmentHelper.field_151389_e, llllllllllllllllIlllIIIllIlllIlI.getHeldItem());
        }
    }
    
    static {
        __OBFID = "CL_00000107";
        enchantmentRand = new Random();
        enchantmentModifierDamage = new ModifierDamage(null);
        enchantmentModifierLiving = new ModifierLiving(null);
        field_151388_d = new HurtIterator(null);
        field_151389_e = new DamageIterator(null);
    }
    
    public static int func_151387_h(final EntityLivingBase llllllllllllllllIlllIIIllIIlllll) {
        return getEnchantmentLevel(Enchantment.lure.effectId, llllllllllllllllIlllIIIllIIlllll.getHeldItem());
    }
    
    public static List buildEnchantmentList(final Random llllllllllllllllIlllIIIlIlIIlIlI, final ItemStack llllllllllllllllIlllIIIlIIllIlll, final int llllllllllllllllIlllIIIlIlIIlIII) {
        final Item llllllllllllllllIlllIIIlIlIIIlll = llllllllllllllllIlllIIIlIIllIlll.getItem();
        int llllllllllllllllIlllIIIlIlIIIllI = llllllllllllllllIlllIIIlIlIIIlll.getItemEnchantability();
        if (llllllllllllllllIlllIIIlIlIIIllI <= 0) {
            return null;
        }
        llllllllllllllllIlllIIIlIlIIIllI /= 2;
        llllllllllllllllIlllIIIlIlIIIllI = 1 + llllllllllllllllIlllIIIlIlIIlIlI.nextInt((llllllllllllllllIlllIIIlIlIIIllI >> 1) + 1) + llllllllllllllllIlllIIIlIlIIlIlI.nextInt((llllllllllllllllIlllIIIlIlIIIllI >> 1) + 1);
        final int llllllllllllllllIlllIIIlIlIIIlIl = llllllllllllllllIlllIIIlIlIIIllI + llllllllllllllllIlllIIIlIlIIlIII;
        final float llllllllllllllllIlllIIIlIlIIIlII = (llllllllllllllllIlllIIIlIlIIlIlI.nextFloat() + llllllllllllllllIlllIIIlIlIIlIlI.nextFloat() - 1.0f) * 0.15f;
        int llllllllllllllllIlllIIIlIlIIIIll = (int)(llllllllllllllllIlllIIIlIlIIIlIl * (1.0f + llllllllllllllllIlllIIIlIlIIIlII) + 0.5f);
        if (llllllllllllllllIlllIIIlIlIIIIll < 1) {
            llllllllllllllllIlllIIIlIlIIIIll = 1;
        }
        ArrayList llllllllllllllllIlllIIIlIlIIIIlI = null;
        final Map llllllllllllllllIlllIIIlIlIIIIIl = mapEnchantmentData(llllllllllllllllIlllIIIlIlIIIIll, llllllllllllllllIlllIIIlIIllIlll);
        if (llllllllllllllllIlllIIIlIlIIIIIl != null && !llllllllllllllllIlllIIIlIlIIIIIl.isEmpty()) {
            final EnchantmentData llllllllllllllllIlllIIIlIlIIIIII = (EnchantmentData)WeightedRandom.getRandomItem(llllllllllllllllIlllIIIlIlIIlIlI, llllllllllllllllIlllIIIlIlIIIIIl.values());
            if (llllllllllllllllIlllIIIlIlIIIIII != null) {
                llllllllllllllllIlllIIIlIlIIIIlI = Lists.newArrayList();
                llllllllllllllllIlllIIIlIlIIIIlI.add(llllllllllllllllIlllIIIlIlIIIIII);
                for (int llllllllllllllllIlllIIIlIIllllll = llllllllllllllllIlllIIIlIlIIIIll; llllllllllllllllIlllIIIlIlIIlIlI.nextInt(50) <= llllllllllllllllIlllIIIlIIllllll; llllllllllllllllIlllIIIlIIllllll >>= 1) {
                    final Iterator llllllllllllllllIlllIIIlIIlllllI = llllllllllllllllIlllIIIlIlIIIIIl.keySet().iterator();
                    while (llllllllllllllllIlllIIIlIIlllllI.hasNext()) {
                        final Integer llllllllllllllllIlllIIIlIIllllIl = llllllllllllllllIlllIIIlIIlllllI.next();
                        boolean llllllllllllllllIlllIIIlIIllllII = true;
                        for (final EnchantmentData llllllllllllllllIlllIIIlIIlllIlI : llllllllllllllllIlllIIIlIlIIIIlI) {
                            if (llllllllllllllllIlllIIIlIIlllIlI.enchantmentobj.canApplyTogether(Enchantment.func_180306_c(llllllllllllllllIlllIIIlIIllllIl))) {
                                continue;
                            }
                            llllllllllllllllIlllIIIlIIllllII = false;
                            break;
                        }
                        if (!llllllllllllllllIlllIIIlIIllllII) {
                            llllllllllllllllIlllIIIlIIlllllI.remove();
                        }
                    }
                    if (!llllllllllllllllIlllIIIlIlIIIIIl.isEmpty()) {
                        final EnchantmentData llllllllllllllllIlllIIIlIIlllIIl = (EnchantmentData)WeightedRandom.getRandomItem(llllllllllllllllIlllIIIlIlIIlIlI, llllllllllllllllIlllIIIlIlIIIIIl.values());
                        llllllllllllllllIlllIIIlIlIIIIlI.add(llllllllllllllllIlllIIIlIIlllIIl);
                    }
                }
            }
        }
        return llllllllllllllllIlllIIIlIlIIIIlI;
    }
    
    public static int getLootingModifier(final EntityLivingBase llllllllllllllllIlllIIIllIIlllII) {
        return getEnchantmentLevel(Enchantment.looting.effectId, llllllllllllllllIlllIIIllIIlllII.getHeldItem());
    }
    
    interface IModifier
    {
        void calculateModifier(final Enchantment p0, final int p1);
    }
    
    static final class ModifierDamage implements IModifier
    {
        public /* synthetic */ DamageSource source;
        public /* synthetic */ int damageModifier;
        
        static {
            __OBFID = "CL_00000114";
        }
        
        @Override
        public void calculateModifier(final Enchantment lIlIlIlIIlIl, final int lIlIlIlIIlII) {
            this.damageModifier += lIlIlIlIIlIl.calcModifierDamage(lIlIlIlIIlII, this.source);
        }
        
        ModifierDamage(final Object lIlIlIIllllI) {
            this();
        }
        
        private ModifierDamage() {
        }
    }
    
    static final class ModifierLiving implements IModifier
    {
        public /* synthetic */ float livingModifier;
        public /* synthetic */ EnumCreatureAttribute entityLiving;
        
        @Override
        public void calculateModifier(final Enchantment llllllllllllllIllIlIllIlIIllIIlI, final int llllllllllllllIllIlIllIlIIlIlllI) {
            this.livingModifier += llllllllllllllIllIlIllIlIIllIIlI.func_152376_a(llllllllllllllIllIlIllIlIIlIlllI, this.entityLiving);
        }
        
        ModifierLiving(final Object llllllllllllllIllIlIllIlIIlIlIll) {
            this();
        }
        
        private ModifierLiving() {
        }
        
        static {
            __OBFID = "CL_00000112";
        }
    }
    
    static final class DamageIterator implements IModifier
    {
        public /* synthetic */ EntityLivingBase field_151366_a;
        public /* synthetic */ Entity field_151365_b;
        
        DamageIterator(final Object llllllllllllllIIIIlllIlIlllllIII) {
            this();
        }
        
        static {
            __OBFID = "CL_00000109";
        }
        
        @Override
        public void calculateModifier(final Enchantment llllllllllllllIIIIlllIlIllllllll, final int llllllllllllllIIIIlllIlIlllllllI) {
            llllllllllllllIIIIlllIlIllllllll.func_151368_a(this.field_151366_a, this.field_151365_b, llllllllllllllIIIIlllIlIlllllllI);
        }
        
        private DamageIterator() {
        }
    }
    
    static final class HurtIterator implements IModifier
    {
        public /* synthetic */ EntityLivingBase field_151364_a;
        public /* synthetic */ Entity field_151363_b;
        
        HurtIterator(final Object llllllllllllllIlIIIIIIIIllIIlllI) {
            this();
        }
        
        static {
            __OBFID = "CL_00000110";
        }
        
        private HurtIterator() {
        }
        
        @Override
        public void calculateModifier(final Enchantment llllllllllllllIlIIIIIIIIllIlIIlI, final int llllllllllllllIlIIIIIIIIllIlIIIl) {
            llllllllllllllIlIIIIIIIIllIlIIlI.func_151367_b(this.field_151364_a, this.field_151363_b, llllllllllllllIlIIIIIIIIllIlIIIl);
        }
    }
}
