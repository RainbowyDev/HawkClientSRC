package net.minecraft.util;

public class ChatAllowedCharacters
{
    static {
        __OBFID = "CL_00001606";
        allowedCharactersArray = new char[] { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
    }
    
    public static String filterAllowedCharacters(final String lllllllllllllllIllIIIlllIIlllIlI) {
        final StringBuilder lllllllllllllllIllIIIlllIIllllll = new StringBuilder();
        for (final char lllllllllllllllIllIIIlllIIlllIll : lllllllllllllllIllIIIlllIIlllIlI.toCharArray()) {
            if (isAllowedCharacter(lllllllllllllllIllIIIlllIIlllIll)) {
                lllllllllllllllIllIIIlllIIllllll.append(lllllllllllllllIllIIIlllIIlllIll);
            }
        }
        return String.valueOf(lllllllllllllllIllIIIlllIIllllll);
    }
    
    public static boolean isAllowedCharacter(final char lllllllllllllllIllIIIlllIlIIIlll) {
        return lllllllllllllllIllIIIlllIlIIIlll != '§' && lllllllllllllllIllIIIlllIlIIIlll >= ' ' && lllllllllllllllIllIIIlllIlIIIlll != '\u007f';
    }
}
