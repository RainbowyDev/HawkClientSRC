package net.minecraft.item;

import net.minecraft.block.material.*;
import net.minecraft.util.*;

public enum EnumDyeColor implements IStringSerializable
{
    LIGHT_BLUE("LIGHT_BLUE", 3, "LIGHT_BLUE", 3, 3, 12, "light_blue", "lightBlue", MapColor.lightBlueColor, EnumChatFormatting.BLUE);
    
    private final /* synthetic */ MapColor field_176784_w;
    
    RED("RED", 14, "RED", 14, 14, 1, "red", "red", MapColor.redColor, EnumChatFormatting.DARK_RED), 
    GRAY("GRAY", 7, "GRAY", 7, 7, 8, "gray", "gray", MapColor.grayColor, EnumChatFormatting.DARK_GRAY), 
    BROWN("BROWN", 12, "BROWN", 12, 12, 3, "brown", "brown", MapColor.brownColor, EnumChatFormatting.GOLD), 
    MAGENTA("MAGENTA", 2, "MAGENTA", 2, 2, 13, "magenta", "magenta", MapColor.magentaColor, EnumChatFormatting.AQUA);
    
    private final /* synthetic */ String field_176785_v;
    
    BLUE("BLUE", 11, "BLUE", 11, 11, 4, "blue", "blue", MapColor.blueColor, EnumChatFormatting.DARK_BLUE), 
    GREEN("GREEN", 13, "GREEN", 13, 13, 2, "green", "green", MapColor.greenColor, EnumChatFormatting.DARK_GREEN), 
    LIME("LIME", 5, "LIME", 5, 5, 10, "lime", "lime", MapColor.limeColor, EnumChatFormatting.GREEN), 
    WHITE("WHITE", 0, "WHITE", 0, 0, 15, "white", "white", MapColor.snowColor, EnumChatFormatting.WHITE), 
    PURPLE("PURPLE", 10, "PURPLE", 10, 10, 5, "purple", "purple", MapColor.purpleColor, EnumChatFormatting.DARK_PURPLE), 
    YELLOW("YELLOW", 4, "YELLOW", 4, 4, 11, "yellow", "yellow", MapColor.yellowColor, EnumChatFormatting.YELLOW);
    
    private static final /* synthetic */ EnumDyeColor[] field_176789_r;
    
    CYAN("CYAN", 9, "CYAN", 9, 9, 6, "cyan", "cyan", MapColor.cyanColor, EnumChatFormatting.DARK_AQUA), 
    BLACK("BLACK", 15, "BLACK", 15, 15, 0, "black", "black", MapColor.blackColor, EnumChatFormatting.BLACK);
    
    private final /* synthetic */ EnumChatFormatting field_176793_x;
    
    ORANGE("ORANGE", 1, "ORANGE", 1, 1, 14, "orange", "orange", MapColor.adobeColor, EnumChatFormatting.GOLD), 
    SILVER("SILVER", 8, "SILVER", 8, 8, 7, "silver", "silver", MapColor.silverColor, EnumChatFormatting.GRAY), 
    PINK("PINK", 6, "PINK", 6, 6, 9, "pink", "pink", MapColor.pinkColor, EnumChatFormatting.LIGHT_PURPLE);
    
    private static final /* synthetic */ EnumDyeColor[] field_176790_q;
    private final /* synthetic */ int field_176788_s;
    private final /* synthetic */ int field_176787_t;
    private final /* synthetic */ String field_176786_u;
    
    private EnumDyeColor(final String llllllllllllllllllIlIIIlIllIlllI, final int llllllllllllllllllIlIIIlIllIllIl, final String llllllllllllllllllIlIIIlIlllIlll, final int llllllllllllllllllIlIIIlIlllIllI, final int llllllllllllllllllIlIIIlIlllIlIl, final int llllllllllllllllllIlIIIlIlllIlII, final String llllllllllllllllllIlIIIlIlllIIll, final String llllllllllllllllllIlIIIlIllIlIIl, final MapColor llllllllllllllllllIlIIIlIlllIIIl, final EnumChatFormatting llllllllllllllllllIlIIIlIllIIlll) {
        this.field_176788_s = llllllllllllllllllIlIIIlIlllIlIl;
        this.field_176787_t = llllllllllllllllllIlIIIlIlllIlII;
        this.field_176786_u = llllllllllllllllllIlIIIlIlllIIll;
        this.field_176785_v = llllllllllllllllllIlIIIlIllIlIIl;
        this.field_176784_w = llllllllllllllllllIlIIIlIlllIIIl;
        this.field_176793_x = llllllllllllllllllIlIIIlIllIIlll;
    }
    
    public static EnumDyeColor func_176764_b(int llllllllllllllllllIlIIIlIlIlIlIl) {
        if (llllllllllllllllllIlIIIlIlIlIlIl < 0 || llllllllllllllllllIlIIIlIlIlIlIl >= EnumDyeColor.field_176790_q.length) {
            llllllllllllllllllIlIIIlIlIlIlIl = 0;
        }
        return EnumDyeColor.field_176790_q[llllllllllllllllllIlIIIlIlIlIlIl];
    }
    
    public MapColor func_176768_e() {
        return this.field_176784_w;
    }
    
    public int getDyeColorDamage() {
        return this.field_176787_t;
    }
    
    public static EnumDyeColor func_176766_a(int llllllllllllllllllIlIIIlIlIllIII) {
        if (llllllllllllllllllIlIIIlIlIllIII < 0 || llllllllllllllllllIlIIIlIlIllIII >= EnumDyeColor.field_176789_r.length) {
            llllllllllllllllllIlIIIlIlIllIII = 0;
        }
        return EnumDyeColor.field_176789_r[llllllllllllllllllIlIIIlIlIllIII];
    }
    
    public String func_176762_d() {
        return this.field_176785_v;
    }
    
    public int func_176765_a() {
        return this.field_176788_s;
    }
    
    static {
        __OBFID = "CL_00002180";
        field_176790_q = new EnumDyeColor[values().length];
        field_176789_r = new EnumDyeColor[values().length];
        for (final EnumDyeColor llllllllllllllllllIlIIIllIIIIllI : values()) {
            EnumDyeColor.field_176790_q[llllllllllllllllllIlIIIllIIIIllI.func_176765_a()] = llllllllllllllllllIlIIIllIIIIllI;
            EnumDyeColor.field_176789_r[llllllllllllllllllIlIIIllIIIIllI.getDyeColorDamage()] = llllllllllllllllllIlIIIllIIIIllI;
        }
    }
    
    @Override
    public String getName() {
        return this.field_176786_u;
    }
    
    @Override
    public String toString() {
        return this.field_176785_v;
    }
}
