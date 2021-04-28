package net.minecraft.potion;

import net.minecraft.entity.ai.attributes.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;

public class Potion
{
    public final /* synthetic */ int id;
    public static final /* synthetic */ Potion regeneration;
    private final /* synthetic */ boolean isBadEffect;
    public static final /* synthetic */ Potion poison;
    public static final /* synthetic */ Potion wither;
    private /* synthetic */ int statusIconIndex;
    private /* synthetic */ boolean usable;
    private final /* synthetic */ int liquidColor;
    private static final /* synthetic */ Map field_180150_I;
    private /* synthetic */ String name;
    private /* synthetic */ double effectiveness;
    public static final /* synthetic */ Potion heal;
    public static final /* synthetic */ Potion harm;
    public static final /* synthetic */ Potion hunger;
    public static final /* synthetic */ Potion[] potionTypes;
    public static final /* synthetic */ Potion saturation;
    private final /* synthetic */ Map attributeModifierMap;
    
    public void removeAttributesModifiersFromEntity(final EntityLivingBase llllllllllllllIIIIIIlIlIIIllIIIl, final BaseAttributeMap llllllllllllllIIIIIIlIlIIIllIIII, final int llllllllllllllIIIIIIlIlIIIlIllll) {
        for (final Map.Entry llllllllllllllIIIIIIlIlIIIlIllIl : this.attributeModifierMap.entrySet()) {
            final IAttributeInstance llllllllllllllIIIIIIlIlIIIlIllII = llllllllllllllIIIIIIlIlIIIllIIII.getAttributeInstance(llllllllllllllIIIIIIlIlIIIlIllIl.getKey());
            if (llllllllllllllIIIIIIlIlIIIlIllII != null) {
                llllllllllllllIIIIIIlIlIIIlIllII.removeModifier(llllllllllllllIIIIIIlIlIIIlIllIl.getValue());
            }
        }
    }
    
    public boolean isBadEffect() {
        return this.isBadEffect;
    }
    
    protected Potion setIconIndex(final int llllllllllllllIIIIIIlIlIlIlIlIIl, final int llllllllllllllIIIIIIlIlIlIlIlIII) {
        this.statusIconIndex = llllllllllllllIIIIIIlIlIlIlIlIIl + llllllllllllllIIIIIIlIlIlIlIlIII * 8;
        return this;
    }
    
    public Map func_111186_k() {
        return this.attributeModifierMap;
    }
    
    public double getEffectiveness() {
        return this.effectiveness;
    }
    
    public int getId() {
        return this.id;
    }
    
    public boolean isInstant() {
        return false;
    }
    
    protected Potion(final int llllllllllllllIIIIIIlIlIllIIIIII, final ResourceLocation llllllllllllllIIIIIIlIlIllIIIlII, final boolean llllllllllllllIIIIIIlIlIllIIIIll, final int llllllllllllllIIIIIIlIlIlIllllIl) {
        this.attributeModifierMap = Maps.newHashMap();
        this.name = "";
        this.statusIconIndex = -1;
        this.id = llllllllllllllIIIIIIlIlIllIIIIII;
        Potion.potionTypes[llllllllllllllIIIIIIlIlIllIIIIII] = this;
        Potion.field_180150_I.put(llllllllllllllIIIIIIlIlIllIIIlII, this);
        this.isBadEffect = llllllllllllllIIIIIIlIlIllIIIIll;
        if (llllllllllllllIIIIIIlIlIllIIIIll) {
            this.effectiveness = 0.5;
        }
        else {
            this.effectiveness = 1.0;
        }
        this.liquidColor = llllllllllllllIIIIIIlIlIlIllllIl;
    }
    
    public void performEffect(final EntityLivingBase llllllllllllllIIIIIIlIlIlIIllIlI, final int llllllllllllllIIIIIIlIlIlIIlllII) {
        if (this.id == Potion.regeneration.id) {
            if (llllllllllllllIIIIIIlIlIlIIllIlI.getHealth() < llllllllllllllIIIIIIlIlIlIIllIlI.getMaxHealth()) {
                llllllllllllllIIIIIIlIlIlIIllIlI.heal(1.0f);
            }
        }
        else if (this.id == Potion.poison.id) {
            if (llllllllllllllIIIIIIlIlIlIIllIlI.getHealth() > 1.0f) {
                llllllllllllllIIIIIIlIlIlIIllIlI.attackEntityFrom(DamageSource.magic, 1.0f);
            }
        }
        else if (this.id == Potion.wither.id) {
            llllllllllllllIIIIIIlIlIlIIllIlI.attackEntityFrom(DamageSource.wither, 1.0f);
        }
        else if (this.id == Potion.hunger.id && llllllllllllllIIIIIIlIlIlIIllIlI instanceof EntityPlayer) {
            ((EntityPlayer)llllllllllllllIIIIIIlIlIlIIllIlI).addExhaustion(0.025f * (llllllllllllllIIIIIIlIlIlIIlllII + 1));
        }
        else if (this.id == Potion.saturation.id && llllllllllllllIIIIIIlIlIlIIllIlI instanceof EntityPlayer) {
            if (!llllllllllllllIIIIIIlIlIlIIllIlI.worldObj.isRemote) {
                ((EntityPlayer)llllllllllllllIIIIIIlIlIlIIllIlI).getFoodStats().addStats(llllllllllllllIIIIIIlIlIlIIlllII + 1, 1.0f);
            }
        }
        else if ((this.id != Potion.heal.id || llllllllllllllIIIIIIlIlIlIIllIlI.isEntityUndead()) && (this.id != Potion.harm.id || !llllllllllllllIIIIIIlIlIlIIllIlI.isEntityUndead())) {
            if ((this.id == Potion.harm.id && !llllllllllllllIIIIIIlIlIlIIllIlI.isEntityUndead()) || (this.id == Potion.heal.id && llllllllllllllIIIIIIlIlIlIIllIlI.isEntityUndead())) {
                llllllllllllllIIIIIIlIlIlIIllIlI.attackEntityFrom(DamageSource.magic, (float)(6 << llllllllllllllIIIIIIlIlIlIIlllII));
            }
        }
        else {
            llllllllllllllIIIIIIlIlIlIIllIlI.heal((float)Math.max(4 << llllllllllllllIIIIIIlIlIlIIlllII, 0));
        }
    }
    
    public double func_111183_a(final int llllllllllllllIIIIIIlIlIIIIIllIl, final AttributeModifier llllllllllllllIIIIIIlIlIIIIIlIlI) {
        return llllllllllllllIIIIIIlIlIIIIIlIlI.getAmount() * (llllllllllllllIIIIIIlIlIIIIIllIl + 1);
    }
    
    public int getStatusIconIndex() {
        return this.statusIconIndex;
    }
    
    protected Potion setEffectiveness(final double llllllllllllllIIIIIIlIlIIlIllIII) {
        this.effectiveness = llllllllllllllIIIIIIlIlIIlIllIII;
        return this;
    }
    
    public void func_180793_a(final Entity llllllllllllllIIIIIIlIlIlIIlIIII, final Entity llllllllllllllIIIIIIlIlIlIIIllll, final EntityLivingBase llllllllllllllIIIIIIlIlIlIIIlllI, final int llllllllllllllIIIIIIlIlIlIIIIlIl, final double llllllllllllllIIIIIIlIlIlIIIIlII) {
        if ((this.id != Potion.heal.id || llllllllllllllIIIIIIlIlIlIIIlllI.isEntityUndead()) && (this.id != Potion.harm.id || !llllllllllllllIIIIIIlIlIlIIIlllI.isEntityUndead())) {
            if ((this.id == Potion.harm.id && !llllllllllllllIIIIIIlIlIlIIIlllI.isEntityUndead()) || (this.id == Potion.heal.id && llllllllllllllIIIIIIlIlIlIIIlllI.isEntityUndead())) {
                final int llllllllllllllIIIIIIlIlIlIIIlIll = (int)(llllllllllllllIIIIIIlIlIlIIIIlII * (6 << llllllllllllllIIIIIIlIlIlIIIIlIl) + 0.5);
                if (llllllllllllllIIIIIIlIlIlIIlIIII == null) {
                    llllllllllllllIIIIIIlIlIlIIIlllI.attackEntityFrom(DamageSource.magic, (float)llllllllllllllIIIIIIlIlIlIIIlIll);
                }
                else {
                    llllllllllllllIIIIIIlIlIlIIIlllI.attackEntityFrom(DamageSource.causeIndirectMagicDamage(llllllllllllllIIIIIIlIlIlIIlIIII, llllllllllllllIIIIIIlIlIlIIIllll), (float)llllllllllllllIIIIIIlIlIlIIIlIll);
                }
            }
        }
        else {
            final int llllllllllllllIIIIIIlIlIlIIIlIlI = (int)(llllllllllllllIIIIIIlIlIlIIIIlII * (4 << llllllllllllllIIIIIIlIlIlIIIIlIl) + 0.5);
            llllllllllllllIIIIIIlIlIlIIIlllI.heal((float)llllllllllllllIIIIIIlIlIlIIIlIlI);
        }
    }
    
    static {
        __OBFID = "CL_00001528";
        potionTypes = new Potion[32];
        field_180150_I = Maps.newHashMap();
        field_180151_b = null;
        moveSpeed = new Potion(1, new ResourceLocation("speed"), false, 8171462).setPotionName("potion.moveSpeed").setIconIndex(0, 0).registerPotionAttributeModifier(SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224, 2);
        moveSlowdown = new Potion(2, new ResourceLocation("slowness"), true, 5926017).setPotionName("potion.moveSlowdown").setIconIndex(1, 0).registerPotionAttributeModifier(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448, 2);
        digSpeed = new Potion(3, new ResourceLocation("haste"), false, 14270531).setPotionName("potion.digSpeed").setIconIndex(2, 0).setEffectiveness(1.5);
        digSlowdown = new Potion(4, new ResourceLocation("mining_fatigue"), true, 4866583).setPotionName("potion.digSlowDown").setIconIndex(3, 0);
        damageBoost = new PotionAttackDamage(5, new ResourceLocation("strength"), false, 9643043).setPotionName("potion.damageBoost").setIconIndex(4, 0).registerPotionAttributeModifier(SharedMonsterAttributes.attackDamage, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.5, 2);
        heal = new PotionHealth(6, new ResourceLocation("instant_health"), false, 16262179).setPotionName("potion.heal");
        harm = new PotionHealth(7, new ResourceLocation("instant_damage"), true, 4393481).setPotionName("potion.harm");
        jump = new Potion(8, new ResourceLocation("jump_boost"), false, 2293580).setPotionName("potion.jump").setIconIndex(2, 1);
        confusion = new Potion(9, new ResourceLocation("nausea"), true, 5578058).setPotionName("potion.confusion").setIconIndex(3, 1).setEffectiveness(0.25);
        regeneration = new Potion(10, new ResourceLocation("regeneration"), false, 13458603).setPotionName("potion.regeneration").setIconIndex(7, 0).setEffectiveness(0.25);
        resistance = new Potion(11, new ResourceLocation("resistance"), false, 10044730).setPotionName("potion.resistance").setIconIndex(6, 1);
        fireResistance = new Potion(12, new ResourceLocation("fire_resistance"), false, 14981690).setPotionName("potion.fireResistance").setIconIndex(7, 1);
        waterBreathing = new Potion(13, new ResourceLocation("water_breathing"), false, 3035801).setPotionName("potion.waterBreathing").setIconIndex(0, 2);
        invisibility = new Potion(14, new ResourceLocation("invisibility"), false, 8356754).setPotionName("potion.invisibility").setIconIndex(0, 1);
        blindness = new Potion(15, new ResourceLocation("blindness"), true, 2039587).setPotionName("potion.blindness").setIconIndex(5, 1).setEffectiveness(0.25);
        nightVision = new Potion(16, new ResourceLocation("night_vision"), false, 2039713).setPotionName("potion.nightVision").setIconIndex(4, 1);
        hunger = new Potion(17, new ResourceLocation("hunger"), true, 5797459).setPotionName("potion.hunger").setIconIndex(1, 1);
        weakness = new PotionAttackDamage(18, new ResourceLocation("weakness"), true, 4738376).setPotionName("potion.weakness").setIconIndex(5, 0).registerPotionAttributeModifier(SharedMonsterAttributes.attackDamage, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0, 0);
        poison = new Potion(19, new ResourceLocation("poison"), true, 5149489).setPotionName("potion.poison").setIconIndex(6, 0).setEffectiveness(0.25);
        wither = new Potion(20, new ResourceLocation("wither"), true, 3484199).setPotionName("potion.wither").setIconIndex(1, 2).setEffectiveness(0.25);
        field_180152_w = new PotionHealthBoost(21, new ResourceLocation("health_boost"), false, 16284963).setPotionName("potion.healthBoost").setIconIndex(2, 2).registerPotionAttributeModifier(SharedMonsterAttributes.maxHealth, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0, 0);
        absorption = new PotionAbsoption(22, new ResourceLocation("absorption"), false, 2445989).setPotionName("potion.absorption").setIconIndex(2, 2);
        saturation = new PotionHealth(23, new ResourceLocation("saturation"), false, 16262179).setPotionName("potion.saturation");
        field_180153_z = null;
        field_180147_A = null;
        field_180148_B = null;
        field_180149_C = null;
        field_180143_D = null;
        field_180144_E = null;
        field_180145_F = null;
        field_180146_G = null;
    }
    
    public Potion registerPotionAttributeModifier(final IAttribute llllllllllllllIIIIIIlIlIIlIIIlIl, final String llllllllllllllIIIIIIlIlIIIlllllI, final double llllllllllllllIIIIIIlIlIIlIIIIll, final int llllllllllllllIIIIIIlIlIIlIIIIlI) {
        final AttributeModifier llllllllllllllIIIIIIlIlIIlIIIIIl = new AttributeModifier(UUID.fromString(llllllllllllllIIIIIIlIlIIIlllllI), this.getName(), llllllllllllllIIIIIIlIlIIlIIIIll, llllllllllllllIIIIIIlIlIIlIIIIlI);
        this.attributeModifierMap.put(llllllllllllllIIIIIIlIlIIlIIIlIl, llllllllllllllIIIIIIlIlIIlIIIIIl);
        return this;
    }
    
    public boolean hasStatusIcon() {
        return this.statusIconIndex >= 0;
    }
    
    public int getLiquidColor() {
        return this.liquidColor;
    }
    
    public boolean isUsable() {
        return this.usable;
    }
    
    public static String[] func_180141_c() {
        final String[] llllllllllllllIIIIIIlIlIlIllIlIl = new String[Potion.field_180150_I.size()];
        int llllllllllllllIIIIIIlIlIlIllIlII = 0;
        for (final ResourceLocation llllllllllllllIIIIIIlIlIlIllIIll : Potion.field_180150_I.keySet()) {
            llllllllllllllIIIIIIlIlIlIllIlIl[llllllllllllllIIIIIIlIlIlIllIlII++] = llllllllllllllIIIIIIlIlIlIllIIll.toString();
        }
        return llllllllllllllIIIIIIlIlIlIllIlIl;
    }
    
    public static String getDurationString(final PotionEffect llllllllllllllIIIIIIlIlIIlIlllIl) {
        if (llllllllllllllIIIIIIlIlIIlIlllIl.getIsPotionDurationMax()) {
            return "**:**";
        }
        final int llllllllllllllIIIIIIlIlIIlIllllI = llllllllllllllIIIIIIlIlIIlIlllIl.getDuration();
        return StringUtils.ticksToElapsedTime(llllllllllllllIIIIIIlIlIIlIllllI);
    }
    
    public static Potion func_180142_b(final String llllllllllllllIIIIIIlIlIlIlllIlI) {
        return Potion.field_180150_I.get(new ResourceLocation(llllllllllllllIIIIIIlIlIlIlllIlI));
    }
    
    public boolean isReady(final int llllllllllllllIIIIIIlIlIIlllllII, final int llllllllllllllIIIIIIlIlIIllllIll) {
        if (this.id == Potion.regeneration.id) {
            final int llllllllllllllIIIIIIlIlIIllllIlI = 50 >> llllllllllllllIIIIIIlIlIIllllIll;
            return llllllllllllllIIIIIIlIlIIllllIlI <= 0 || llllllllllllllIIIIIIlIlIIlllllII % llllllllllllllIIIIIIlIlIIllllIlI == 0;
        }
        if (this.id == Potion.poison.id) {
            final int llllllllllllllIIIIIIlIlIIllllIIl = 25 >> llllllllllllllIIIIIIlIlIIllllIll;
            return llllllllllllllIIIIIIlIlIIllllIIl <= 0 || llllllllllllllIIIIIIlIlIIlllllII % llllllllllllllIIIIIIlIlIIllllIIl == 0;
        }
        if (this.id == Potion.wither.id) {
            final int llllllllllllllIIIIIIlIlIIllllIII = 40 >> llllllllllllllIIIIIIlIlIIllllIll;
            return llllllllllllllIIIIIIlIlIIllllIII <= 0 || llllllllllllllIIIIIIlIlIIlllllII % llllllllllllllIIIIIIlIlIIllllIII == 0;
        }
        return this.id == Potion.hunger.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void applyAttributesModifiersToEntity(final EntityLivingBase llllllllllllllIIIIIIlIlIIIIllllI, final BaseAttributeMap llllllllllllllIIIIIIlIlIIIIlIllI, final int llllllllllllllIIIIIIlIlIIIIlllII) {
        for (final Map.Entry llllllllllllllIIIIIIlIlIIIIllIlI : this.attributeModifierMap.entrySet()) {
            final IAttributeInstance llllllllllllllIIIIIIlIlIIIIllIIl = llllllllllllllIIIIIIlIlIIIIlIllI.getAttributeInstance(llllllllllllllIIIIIIlIlIIIIllIlI.getKey());
            if (llllllllllllllIIIIIIlIlIIIIllIIl != null) {
                final AttributeModifier llllllllllllllIIIIIIlIlIIIIllIII = llllllllllllllIIIIIIlIlIIIIllIlI.getValue();
                llllllllllllllIIIIIIlIlIIIIllIIl.removeModifier(llllllllllllllIIIIIIlIlIIIIllIII);
                llllllllllllllIIIIIIlIlIIIIllIIl.applyModifier(new AttributeModifier(llllllllllllllIIIIIIlIlIIIIllIII.getID(), String.valueOf(new StringBuilder(String.valueOf(this.getName())).append(" ").append(llllllllllllllIIIIIIlIlIIIIlllII)), this.func_111183_a(llllllllllllllIIIIIIlIlIIIIlllII, llllllllllllllIIIIIIlIlIIIIllIII), llllllllllllllIIIIIIlIlIIIIllIII.getOperation()));
            }
        }
    }
    
    public Potion setPotionName(final String llllllllllllllIIIIIIlIlIIllIlllI) {
        this.name = llllllllllllllIIIIIIlIlIIllIlllI;
        return this;
    }
}
