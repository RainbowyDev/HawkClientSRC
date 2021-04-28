package net.minecraft.util;

import java.util.regex.*;
import java.util.*;
import com.google.common.collect.*;

public enum EnumChatFormatting
{
    private final /* synthetic */ String controlString;
    private static final /* synthetic */ Pattern formattingCodePattern;
    
    BLUE("BLUE", 9, "BLUE", 9, "BLUE", '9', 9), 
    WHITE("WHITE", 15, "WHITE", 15, "WHITE", 'f', 15), 
    DARK_GRAY("DARK_GRAY", 8, "DARK_GRAY", 8, "DARK_GRAY", '8', 8), 
    DARK_BLUE("DARK_BLUE", 1, "DARK_BLUE", 1, "DARK_BLUE", '1', 1), 
    DARK_PURPLE("DARK_PURPLE", 5, "DARK_PURPLE", 5, "DARK_PURPLE", '5', 5), 
    YELLOW("YELLOW", 14, "YELLOW", 14, "YELLOW", 'e', 14), 
    OBFUSCATED("OBFUSCATED", 16, "OBFUSCATED", 16, "OBFUSCATED", 'k', true), 
    RED("RED", 12, "RED", 12, "RED", 'c', 12), 
    DARK_GREEN("DARK_GREEN", 2, "DARK_GREEN", 2, "DARK_GREEN", '2', 2);
    
    private final /* synthetic */ char formattingCode;
    
    BLACK("BLACK", 0, "BLACK", 0, "BLACK", '0', 0);
    
    private final /* synthetic */ int field_175747_C;
    private static final /* synthetic */ Map nameMapping;
    
    UNDERLINE("UNDERLINE", 19, "UNDERLINE", 19, "UNDERLINE", 'n', true), 
    AQUA("AQUA", 11, "AQUA", 11, "AQUA", 'b', 11), 
    LIGHT_PURPLE("LIGHT_PURPLE", 13, "LIGHT_PURPLE", 13, "LIGHT_PURPLE", 'd', 13), 
    DARK_RED("DARK_RED", 4, "DARK_RED", 4, "DARK_RED", '4', 4), 
    STRIKETHROUGH("STRIKETHROUGH", 18, "STRIKETHROUGH", 18, "STRIKETHROUGH", 'm', true), 
    GREEN("GREEN", 10, "GREEN", 10, "GREEN", 'a', 10), 
    ITALIC("ITALIC", 20, "ITALIC", 20, "ITALIC", 'o', true), 
    GOLD("GOLD", 6, "GOLD", 6, "GOLD", '6', 6);
    
    private final /* synthetic */ boolean fancyStyling;
    
    RESET("RESET", 21, "RESET", 21, "RESET", 'r', -1), 
    BOLD("BOLD", 17, "BOLD", 17, "BOLD", 'l', true);
    
    private final /* synthetic */ String field_175748_y;
    
    DARK_AQUA("DARK_AQUA", 3, "DARK_AQUA", 3, "DARK_AQUA", '3', 3), 
    GRAY("GRAY", 7, "GRAY", 7, "GRAY", '7', 7);
    
    public static Collection getValidValues(final boolean llllllllllllllIIlIIIlIIlIIlllIlI, final boolean llllllllllllllIIlIIIlIIlIIllIIlI) {
        final ArrayList llllllllllllllIIlIIIlIIlIIlllIII = Lists.newArrayList();
        for (final EnumChatFormatting llllllllllllllIIlIIIlIIlIIllIlII : values()) {
            if ((!llllllllllllllIIlIIIlIIlIIllIlII.isColor() || llllllllllllllIIlIIIlIIlIIlllIlI) && (!llllllllllllllIIlIIIlIIlIIllIlII.isFancyStyling() || llllllllllllllIIlIIIlIIlIIllIIlI)) {
                llllllllllllllIIlIIIlIIlIIlllIII.add(llllllllllllllIIlIIIlIIlIIllIlII.getFriendlyName());
            }
        }
        return llllllllllllllIIlIIIlIIlIIlllIII;
    }
    
    @Override
    public String toString() {
        return this.controlString;
    }
    
    private EnumChatFormatting(final String llllllllllllllIIlIIIlIIlIllIlIll, final int llllllllllllllIIlIIIlIIlIllIlIlI, final String llllllllllllllIIlIIIlIIlIlllIIlI, final int llllllllllllllIIlIIIlIIlIlllIIIl, final String llllllllllllllIIlIIIlIIlIlllIIII, final char llllllllllllllIIlIIIlIIlIllIlIII, final boolean llllllllllllllIIlIIIlIIlIllIIlll, final int llllllllllllllIIlIIIlIIlIllIIllI) {
        this.field_175748_y = llllllllllllllIIlIIIlIIlIlllIIII;
        this.formattingCode = llllllllllllllIIlIIIlIIlIllIlIII;
        this.fancyStyling = llllllllllllllIIlIIIlIIlIllIIlll;
        this.field_175747_C = llllllllllllllIIlIIIlIIlIllIIllI;
        this.controlString = String.valueOf(new StringBuilder("§").append(llllllllllllllIIlIIIlIIlIllIlIII));
    }
    
    private EnumChatFormatting(final String llllllllllllllIIlIIIlIIllIIIIIIl, final int llllllllllllllIIlIIIlIIllIIIIIII, final String llllllllllllllIIlIIIlIIlIlllllll, final int llllllllllllllIIlIIIlIIlIllllllI, final String llllllllllllllIIlIIIlIIllIIIIlIl, final char llllllllllllllIIlIIIlIIllIIIIlII, final boolean llllllllllllllIIlIIIlIIlIllllIll) {
        this(llllllllllllllIIlIIIlIIllIIIIIIl, llllllllllllllIIlIIIlIIllIIIIIII, llllllllllllllIIlIIIlIIlIlllllll, llllllllllllllIIlIIIlIIlIllllllI, llllllllllllllIIlIIIlIIllIIIIlIl, llllllllllllllIIlIIIlIIllIIIIlII, llllllllllllllIIlIIIlIIlIllllIll, -1);
    }
    
    public static EnumChatFormatting getValueByName(final String llllllllllllllIIlIIIlIIlIlIlIIIl) {
        return (llllllllllllllIIlIIIlIIlIlIlIIIl == null) ? null : EnumChatFormatting.nameMapping.get(func_175745_c(llllllllllllllIIlIIIlIIlIlIlIIIl));
    }
    
    public int func_175746_b() {
        return this.field_175747_C;
    }
    
    static {
        __OBFID = "CL_00000342";
        nameMapping = Maps.newHashMap();
        formattingCodePattern = Pattern.compile(String.valueOf(new StringBuilder("(?i)").append(String.valueOf('§')).append("[0-9A-FK-OR]")));
        for (final EnumChatFormatting llllllllllllllIIlIIIlIIllIlIlllI : values()) {
            EnumChatFormatting.nameMapping.put(func_175745_c(llllllllllllllIIlIIIlIIllIlIlllI.field_175748_y), llllllllllllllIIlIIIlIIllIlIlllI);
        }
    }
    
    public static String getTextWithoutFormattingCodes(final String llllllllllllllIIlIIIlIIlIlIlIlIl) {
        return (llllllllllllllIIlIIIlIIlIlIlIlIl == null) ? null : EnumChatFormatting.formattingCodePattern.matcher(llllllllllllllIIlIIIlIIlIlIlIlIl).replaceAll("");
    }
    
    private static String func_175745_c(final String llllllllllllllIIlIIIlIIllIlIIlll) {
        return llllllllllllllIIlIIIlIIllIlIIlll.toLowerCase().replaceAll("[^a-z]", "");
    }
    
    public boolean isColor() {
        return !this.fancyStyling && this != EnumChatFormatting.RESET;
    }
    
    private EnumChatFormatting(final String llllllllllllllIIlIIIlIIllIIlIlll, final int llllllllllllllIIlIIIlIIllIIlIllI, final String llllllllllllllIIlIIIlIIllIIlIlIl, final int llllllllllllllIIlIIIlIIllIIlIlII, final String llllllllllllllIIlIIIlIIllIIlIIll, final char llllllllllllllIIlIIIlIIllIIlIIlI, final int llllllllllllllIIlIIIlIIllIIlIIIl) {
        this(llllllllllllllIIlIIIlIIllIIlIlll, llllllllllllllIIlIIIlIIllIIlIllI, llllllllllllllIIlIIIlIIllIIlIlIl, llllllllllllllIIlIIIlIIllIIlIlII, llllllllllllllIIlIIIlIIllIIlIIll, llllllllllllllIIlIIIlIIllIIlIIlI, false, llllllllllllllIIlIIIlIIllIIlIIIl);
    }
    
    public static EnumChatFormatting func_175744_a(final int llllllllllllllIIlIIIlIIlIlIIlIll) {
        if (llllllllllllllIIlIIIlIIlIlIIlIll < 0) {
            return EnumChatFormatting.RESET;
        }
        for (final EnumChatFormatting llllllllllllllIIlIIIlIIlIlIIIlll : values()) {
            if (llllllllllllllIIlIIIlIIlIlIIIlll.func_175746_b() == llllllllllllllIIlIIIlIIlIlIIlIll) {
                return llllllllllllllIIlIIIlIIlIlIIIlll;
            }
        }
        return null;
    }
    
    public String getFriendlyName() {
        return this.name().toLowerCase();
    }
    
    public boolean isFancyStyling() {
        return this.fancyStyling;
    }
}
