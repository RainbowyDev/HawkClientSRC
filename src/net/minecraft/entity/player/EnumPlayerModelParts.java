package net.minecraft.entity.player;

import net.minecraft.util.*;

public enum EnumPlayerModelParts
{
    private final /* synthetic */ String field_179338_j;
    
    LEFT_SLEEVE("LEFT_SLEEVE", 2, "LEFT_SLEEVE", 2, 2, "left_sleeve"), 
    CAPE("CAPE", 0, "CAPE", 0, 0, "cape"), 
    JACKET("JACKET", 1, "JACKET", 1, 1, "jacket");
    
    private final /* synthetic */ int field_179341_i;
    
    RIGHT_PANTS_LEG("RIGHT_PANTS_LEG", 5, "RIGHT_PANTS_LEG", 5, 5, "right_pants_leg");
    
    private final /* synthetic */ IChatComponent field_179339_k;
    private final /* synthetic */ int field_179340_h;
    
    HAT("HAT", 6, "HAT", 6, 6, "hat"), 
    RIGHT_SLEEVE("RIGHT_SLEEVE", 3, "RIGHT_SLEEVE", 3, 3, "right_sleeve"), 
    LEFT_PANTS_LEG("LEFT_PANTS_LEG", 4, "LEFT_PANTS_LEG", 4, 4, "left_pants_leg");
    
    public String func_179329_c() {
        return this.field_179338_j;
    }
    
    public int func_179328_b() {
        return this.field_179340_h;
    }
    
    public int func_179327_a() {
        return this.field_179341_i;
    }
    
    static {
        __OBFID = "CL_00002187";
    }
    
    private EnumPlayerModelParts(final String llIlIIIllIIlll, final int llIlIIIllIIlIl, final String llIlIIIlllIIIl, final int llIlIIIllIllll, final int llIlIIIllIllIl, final String llIlIIIllIlIll) {
        this.field_179340_h = llIlIIIllIllIl;
        this.field_179341_i = 1 << llIlIIIllIllIl;
        this.field_179338_j = llIlIIIllIlIll;
        this.field_179339_k = new ChatComponentTranslation(String.valueOf(new StringBuilder("options.modelPart.").append(llIlIIIllIlIll)), new Object[0]);
    }
    
    public IChatComponent func_179326_d() {
        return this.field_179339_k;
    }
}
