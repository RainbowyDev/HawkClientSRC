package net.minecraft.util;

import com.google.common.collect.*;
import java.util.*;

public enum EnumParticleTypes
{
    ITEM_TAKE("ITEM_TAKE", 40, "ITEM_TAKE", 40, "take", 40, false), 
    SUSPENDED("SUSPENDED", 7, "SUSPENDED", 7, "suspended", 7, false), 
    SUSPENDED_DEPTH("SUSPENDED_DEPTH", 8, "SUSPENDED_DEPTH", 8, "depthsuspend", 8, false), 
    VILLAGER_HAPPY("VILLAGER_HAPPY", 21, "VILLAGER_HAPPY", 21, "happyVillager", 21, false), 
    SMOKE_LARGE("SMOKE_LARGE", 12, "SMOKE_LARGE", 12, "largesmoke", 12, false);
    
    private final /* synthetic */ String field_179369_Q;
    private final /* synthetic */ int field_179372_R;
    
    DRIP_LAVA("DRIP_LAVA", 19, "DRIP_LAVA", 19, "dripLava", 19, false), 
    CLOUD("CLOUD", 29, "CLOUD", 29, "cloud", 29, false), 
    SPELL_MOB_AMBIENT("SPELL_MOB_AMBIENT", 16, "SPELL_MOB_AMBIENT", 16, "mobSpellAmbient", 16, false), 
    ENCHANTMENT_TABLE("ENCHANTMENT_TABLE", 25, "ENCHANTMENT_TABLE", 25, "enchantmenttable", 25, false), 
    SMOKE_NORMAL("SMOKE_NORMAL", 11, "SMOKE_NORMAL", 11, "smoke", 11, false);
    
    private final /* synthetic */ int field_179366_T;
    
    BLOCK_DUST("BLOCK_DUST", 38, "BLOCK_DUST", 38, "blockdust_", 38, false, 1), 
    VILLAGER_ANGRY("VILLAGER_ANGRY", 20, "VILLAGER_ANGRY", 20, "angryVillager", 20, false), 
    EXPLOSION_NORMAL("EXPLOSION_NORMAL", 0, "EXPLOSION_NORMAL", 0, "explode", 0, true), 
    SPELL_WITCH("SPELL_WITCH", 17, "SPELL_WITCH", 17, "witchMagic", 17, false), 
    LAVA("LAVA", 27, "LAVA", 27, "lava", 27, false);
    
    private static final /* synthetic */ String[] field_179368_V;
    
    SNOW_SHOVEL("SNOW_SHOVEL", 32, "SNOW_SHOVEL", 32, "snowshovel", 32, false), 
    EXPLOSION_HUGE("EXPLOSION_HUGE", 2, "EXPLOSION_HUGE", 2, "hugeexplosion", 2, true), 
    CRIT_MAGIC("CRIT_MAGIC", 10, "CRIT_MAGIC", 10, "magicCrit", 10, false);
    
    private final /* synthetic */ boolean field_179371_S;
    
    SLIME("SLIME", 33, "SLIME", 33, "slime", 33, false);
    
    private static final /* synthetic */ Map field_179365_U;
    
    NOTE("NOTE", 23, "NOTE", 23, "note", 23, false), 
    TOWN_AURA("TOWN_AURA", 22, "TOWN_AURA", 22, "townaura", 22, false), 
    WATER_WAKE("WATER_WAKE", 6, "WATER_WAKE", 6, "wake", 6, false), 
    EXPLOSION_LARGE("EXPLOSION_LARGE", 1, "EXPLOSION_LARGE", 1, "largeexplode", 1, true), 
    SPELL_MOB("SPELL_MOB", 15, "SPELL_MOB", 15, "mobSpell", 15, false), 
    FIREWORKS_SPARK("FIREWORKS_SPARK", 3, "FIREWORKS_SPARK", 3, "fireworksSpark", 3, false), 
    CRIT("CRIT", 9, "CRIT", 9, "crit", 9, false), 
    BLOCK_CRACK("BLOCK_CRACK", 37, "BLOCK_CRACK", 37, "blockcrack_", 37, false, 1), 
    PORTAL("PORTAL", 24, "PORTAL", 24, "portal", 24, false), 
    HEART("HEART", 34, "HEART", 34, "heart", 34, false), 
    BARRIER("BARRIER", 35, "BARRIER", 35, "barrier", 35, false), 
    MOB_APPEARANCE("MOB_APPEARANCE", 41, "MOB_APPEARANCE", 41, "mobappearance", 41, true), 
    REDSTONE("REDSTONE", 30, "REDSTONE", 30, "reddust", 30, false), 
    SNOWBALL("SNOWBALL", 31, "SNOWBALL", 31, "snowballpoof", 31, false), 
    DRIP_WATER("DRIP_WATER", 18, "DRIP_WATER", 18, "dripWater", 18, false), 
    WATER_BUBBLE("WATER_BUBBLE", 4, "WATER_BUBBLE", 4, "bubble", 4, false), 
    ITEM_CRACK("ITEM_CRACK", 36, "ITEM_CRACK", 36, "iconcrack_", 36, false, 2), 
    FOOTSTEP("FOOTSTEP", 28, "FOOTSTEP", 28, "footstep", 28, false), 
    WATER_DROP("WATER_DROP", 39, "WATER_DROP", 39, "droplet", 39, false), 
    SPELL_INSTANT("SPELL_INSTANT", 14, "SPELL_INSTANT", 14, "instantSpell", 14, false), 
    SPELL("SPELL", 13, "SPELL", 13, "spell", 13, false), 
    WATER_SPLASH("WATER_SPLASH", 5, "WATER_SPLASH", 5, "splash", 5, false), 
    FLAME("FLAME", 26, "FLAME", 26, "flame", 26, false);
    
    static {
        __OBFID = "CL_00002317";
        field_179365_U = Maps.newHashMap();
        final ArrayList llllllllllllllIlIlllIIllIlIlIlll = Lists.newArrayList();
        for (final EnumParticleTypes llllllllllllllIlIlllIIllIlIlIIll : values()) {
            EnumParticleTypes.field_179365_U.put(llllllllllllllIlIlllIIllIlIlIIll.func_179348_c(), llllllllllllllIlIlllIIllIlIlIIll);
            if (!llllllllllllllIlIlllIIllIlIlIIll.func_179346_b().endsWith("_")) {
                llllllllllllllIlIlllIIllIlIlIlll.add(llllllllllllllIlIlllIIllIlIlIIll.func_179346_b());
            }
        }
        field_179368_V = llllllllllllllIlIlllIIllIlIlIlll.toArray(new String[llllllllllllllIlIlllIIllIlIlIlll.size()]);
    }
    
    public int func_179345_d() {
        return this.field_179366_T;
    }
    
    public boolean func_179343_f() {
        return this.field_179366_T > 0;
    }
    
    public String func_179346_b() {
        return this.field_179369_Q;
    }
    
    public boolean func_179344_e() {
        return this.field_179371_S;
    }
    
    public static String[] func_179349_a() {
        return EnumParticleTypes.field_179368_V;
    }
    
    private EnumParticleTypes(final String llllllllllllllIlIlllIIllIIlllllI, final int llllllllllllllIlIlllIIllIIllllIl, final String llllllllllllllIlIlllIIllIlIIIlIl, final int llllllllllllllIlIlllIIllIlIIIlII, final String llllllllllllllIlIlllIIllIIllllII, final int llllllllllllllIlIlllIIllIIlllIll, final boolean llllllllllllllIlIlllIIllIlIIIIIl, final int llllllllllllllIlIlllIIllIlIIIIII) {
        this.field_179369_Q = llllllllllllllIlIlllIIllIIllllII;
        this.field_179372_R = llllllllllllllIlIlllIIllIIlllIll;
        this.field_179371_S = llllllllllllllIlIlllIIllIlIIIIIl;
        this.field_179366_T = llllllllllllllIlIlllIIllIlIIIIII;
    }
    
    public int func_179348_c() {
        return this.field_179372_R;
    }
    
    private EnumParticleTypes(final String llllllllllllllIlIlllIIllIIlIlIIl, final int llllllllllllllIlIlllIIllIIlIlIII, final String llllllllllllllIlIlllIIllIIlIIlll, final int llllllllllllllIlIlllIIllIIlIIllI, final String llllllllllllllIlIlllIIllIIlIllIl, final int llllllllllllllIlIlllIIllIIlIllII, final boolean llllllllllllllIlIlllIIllIIlIIIll) {
        this(llllllllllllllIlIlllIIllIIlIlIIl, llllllllllllllIlIlllIIllIIlIlIII, llllllllllllllIlIlllIIllIIlIIlll, llllllllllllllIlIlllIIllIIlIIllI, llllllllllllllIlIlllIIllIIlIllIl, llllllllllllllIlIlllIIllIIlIllII, llllllllllllllIlIlllIIllIIlIIIll, 0);
    }
    
    public static EnumParticleTypes func_179342_a(final int llllllllllllllIlIlllIIllIIIlIIlI) {
        return EnumParticleTypes.field_179365_U.get(llllllllllllllIlIlllIIllIIIlIIlI);
    }
}
