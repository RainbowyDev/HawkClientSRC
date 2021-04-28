package net.minecraft.util;

public class ChatComponentTranslationFormatException extends IllegalArgumentException
{
    public ChatComponentTranslationFormatException(final ChatComponentTranslation llllllllllllllllIlIIlllIllllIlIl, final String llllllllllllllllIlIIlllIllllIlll) {
        super(String.format("Error parsing: %s: %s", llllllllllllllllIlIIlllIllllIlIl, llllllllllllllllIlIIlllIllllIlll));
    }
    
    public ChatComponentTranslationFormatException(final ChatComponentTranslation llllllllllllllllIlIIlllIlllIllll, final int llllllllllllllllIlIIlllIlllIlIll) {
        super(String.format("Invalid index %d requested for %s", llllllllllllllllIlIIlllIlllIlIll, llllllllllllllllIlIIlllIlllIllll));
    }
    
    public ChatComponentTranslationFormatException(final ChatComponentTranslation llllllllllllllllIlIIlllIlllIIIll, final Throwable llllllllllllllllIlIIlllIlllIIlIl) {
        super(String.format("Error while parsing: %s", llllllllllllllllIlIIlllIlllIIIll), llllllllllllllllIlIIlllIlllIIlIl);
    }
    
    static {
        __OBFID = "CL_00001271";
    }
}
