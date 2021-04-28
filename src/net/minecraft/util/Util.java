package net.minecraft.util;

public class Util
{
    public static EnumOS getOSType() {
        final String lllllllllllllllIIlllIIlllIIllIIl = System.getProperty("os.name").toLowerCase();
        return lllllllllllllllIIlllIIlllIIllIIl.contains("win") ? EnumOS.WINDOWS : (lllllllllllllllIIlllIIlllIIllIIl.contains("mac") ? EnumOS.OSX : (lllllllllllllllIIlllIIlllIIllIIl.contains("solaris") ? EnumOS.SOLARIS : (lllllllllllllllIIlllIIlllIIllIIl.contains("sunos") ? EnumOS.SOLARIS : (lllllllllllllllIIlllIIlllIIllIIl.contains("linux") ? EnumOS.LINUX : (lllllllllllllllIIlllIIlllIIllIIl.contains("unix") ? EnumOS.LINUX : EnumOS.UNKNOWN)))));
    }
    
    static {
        __OBFID = "CL_00001633";
    }
    
    public enum EnumOS
    {
        LINUX("LINUX", 0, "LINUX", 0), 
        SOLARIS("SOLARIS", 1, "SOLARIS", 1), 
        OSX("OSX", 3, "OSX", 3), 
        WINDOWS("WINDOWS", 2, "WINDOWS", 2), 
        UNKNOWN("UNKNOWN", 4, "UNKNOWN", 4);
        
        private EnumOS(final String llllllllllllllIIllllIllIIlIlIIIl, final int llllllllllllllIIllllIllIIlIlIIII, final String llllllllllllllIIllllIllIIlIlIlII, final int llllllllllllllIIllllIllIIlIlIIll) {
        }
        
        static {
            __OBFID = "CL_00001660";
        }
    }
}
