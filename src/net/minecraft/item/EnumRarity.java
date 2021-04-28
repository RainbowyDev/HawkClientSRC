package net.minecraft.item;

import net.minecraft.util.*;

public enum EnumRarity
{
    EPIC("EPIC", 3, "EPIC", 3, EnumChatFormatting.LIGHT_PURPLE, "Epic"), 
    RARE("RARE", 2, "RARE", 2, EnumChatFormatting.AQUA, "Rare"), 
    UNCOMMON("UNCOMMON", 1, "UNCOMMON", 1, EnumChatFormatting.YELLOW, "Uncommon"), 
    COMMON("COMMON", 0, "COMMON", 0, EnumChatFormatting.WHITE, "Common");
    
    public final /* synthetic */ String rarityName;
    public final /* synthetic */ EnumChatFormatting rarityColor;
    
    private EnumRarity(final String llllllllllllllIlllIlIIllllIllIll, final int llllllllllllllIlllIlIIllllIllIlI, final String llllllllllllllIlllIlIIlllllIIIII, final int llllllllllllllIlllIlIIllllIlllll, final EnumChatFormatting llllllllllllllIlllIlIIllllIllllI, final String llllllllllllllIlllIlIIllllIllIII) {
        this.rarityColor = llllllllllllllIlllIlIIllllIllllI;
        this.rarityName = llllllllllllllIlllIlIIllllIllIII;
    }
    
    static {
        __OBFID = "CL_00000056";
    }
}
