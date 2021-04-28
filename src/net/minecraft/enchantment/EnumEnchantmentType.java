package net.minecraft.enchantment;

import net.minecraft.item.*;

public enum EnumEnchantmentType
{
    DIGGER("DIGGER", 7, "DIGGER", 7), 
    ARMOR_TORSO("ARMOR_TORSO", 4, "ARMOR_TORSO", 4), 
    ARMOR_HEAD("ARMOR_HEAD", 5, "ARMOR_HEAD", 5), 
    ARMOR_LEGS("ARMOR_LEGS", 3, "ARMOR_LEGS", 3), 
    ALL("ALL", 0, "ALL", 0), 
    ARMOR_FEET("ARMOR_FEET", 2, "ARMOR_FEET", 2), 
    BREAKABLE("BREAKABLE", 9, "BREAKABLE", 9), 
    BOW("BOW", 10, "BOW", 10), 
    FISHING_ROD("FISHING_ROD", 8, "FISHING_ROD", 8), 
    ARMOR("ARMOR", 1, "ARMOR", 1), 
    WEAPON("WEAPON", 6, "WEAPON", 6);
    
    private EnumEnchantmentType(final String llllllllllllllIlIllIlIIIIIIlIllI, final int llllllllllllllIlIllIlIIIIIIlIlIl, final String llllllllllllllIlIllIlIIIIIIllIIl, final int llllllllllllllIlIllIlIIIIIIllIII) {
    }
    
    public boolean canEnchantItem(final Item llllllllllllllIlIllIlIIIIIIlIIII) {
        if (this == EnumEnchantmentType.ALL) {
            return true;
        }
        if (this == EnumEnchantmentType.BREAKABLE && llllllllllllllIlIllIlIIIIIIlIIII.isDamageable()) {
            return true;
        }
        if (!(llllllllllllllIlIllIlIIIIIIlIIII instanceof ItemArmor)) {
            return (llllllllllllllIlIllIlIIIIIIlIIII instanceof ItemSword) ? (this == EnumEnchantmentType.WEAPON) : ((llllllllllllllIlIllIlIIIIIIlIIII instanceof ItemTool) ? (this == EnumEnchantmentType.DIGGER) : ((llllllllllllllIlIllIlIIIIIIlIIII instanceof ItemBow) ? (this == EnumEnchantmentType.BOW) : (llllllllllllllIlIllIlIIIIIIlIIII instanceof ItemFishingRod && this == EnumEnchantmentType.FISHING_ROD)));
        }
        if (this == EnumEnchantmentType.ARMOR) {
            return true;
        }
        final ItemArmor llllllllllllllIlIllIlIIIIIIIllll = (ItemArmor)llllllllllllllIlIllIlIIIIIIlIIII;
        return (llllllllllllllIlIllIlIIIIIIIllll.armorType == 0) ? (this == EnumEnchantmentType.ARMOR_HEAD) : ((llllllllllllllIlIllIlIIIIIIIllll.armorType == 2) ? (this == EnumEnchantmentType.ARMOR_LEGS) : ((llllllllllllllIlIllIlIIIIIIIllll.armorType == 1) ? (this == EnumEnchantmentType.ARMOR_TORSO) : (llllllllllllllIlIllIlIIIIIIIllll.armorType == 3 && this == EnumEnchantmentType.ARMOR_FEET)));
    }
    
    static {
        __OBFID = "CL_00000106";
    }
}
