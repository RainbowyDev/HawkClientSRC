package shadersmod.client;

import optifine.*;

public class ShaderUtils
{
    public static ShaderOption getShaderOption(final String llllllllllllllIIIlllIllIlIlllllI, final ShaderOption[] llllllllllllllIIIlllIllIlIllllIl) {
        if (llllllllllllllIIIlllIllIlIllllIl == null) {
            return null;
        }
        for (int llllllllllllllIIIlllIllIlIllllII = 0; llllllllllllllIIIlllIllIlIllllII < llllllllllllllIIIlllIllIlIllllIl.length; ++llllllllllllllIIIlllIllIlIllllII) {
            final ShaderOption llllllllllllllIIIlllIllIlIlllIll = llllllllllllllIIIlllIllIlIllllIl[llllllllllllllIIIlllIllIlIllllII];
            if (llllllllllllllIIIlllIllIlIlllIll.getName().equals(llllllllllllllIIIlllIllIlIlllllI)) {
                return llllllllllllllIIIlllIllIlIlllIll;
            }
        }
        return null;
    }
    
    public static ShaderProfile detectProfile(final ShaderProfile[] llllllllllllllIIIlllIllIlIllIIIl, final ShaderOption[] llllllllllllllIIIlllIllIlIllIIII, final boolean llllllllllllllIIIlllIllIlIlIllll) {
        if (llllllllllllllIIIlllIllIlIllIIIl == null) {
            return null;
        }
        for (int llllllllllllllIIIlllIllIlIlIlllI = 0; llllllllllllllIIIlllIllIlIlIlllI < llllllllllllllIIIlllIllIlIllIIIl.length; ++llllllllllllllIIIlllIllIlIlIlllI) {
            final ShaderProfile llllllllllllllIIIlllIllIlIlIllIl = llllllllllllllIIIlllIllIlIllIIIl[llllllllllllllIIIlllIllIlIlIlllI];
            if (matchProfile(llllllllllllllIIIlllIllIlIlIllIl, llllllllllllllIIIlllIllIlIllIIII, llllllllllllllIIIlllIllIlIlIllll)) {
                return llllllllllllllIIIlllIllIlIlIllIl;
            }
        }
        return null;
    }
    
    public static boolean matchProfile(final ShaderProfile llllllllllllllIIIlllIllIlIIlIlIl, final ShaderOption[] llllllllllllllIIIlllIllIlIIlIlII, final boolean llllllllllllllIIIlllIllIlIIlIIll) {
        if (llllllllllllllIIIlllIllIlIIlIlIl == null) {
            return false;
        }
        if (llllllllllllllIIIlllIllIlIIlIlII == null) {
            return false;
        }
        final String[] llllllllllllllIIIlllIllIlIIllIll = llllllllllllllIIIlllIllIlIIlIlIl.getOptions();
        for (int llllllllllllllIIIlllIllIlIIllIlI = 0; llllllllllllllIIIlllIllIlIIllIlI < llllllllllllllIIIlllIllIlIIllIll.length; ++llllllllllllllIIIlllIllIlIIllIlI) {
            final String llllllllllllllIIIlllIllIlIIllIIl = llllllllllllllIIIlllIllIlIIllIll[llllllllllllllIIIlllIllIlIIllIlI];
            final ShaderOption llllllllllllllIIIlllIllIlIIllIII = getShaderOption(llllllllllllllIIIlllIllIlIIllIIl, llllllllllllllIIIlllIllIlIIlIlII);
            if (llllllllllllllIIIlllIllIlIIllIII != null) {
                final String llllllllllllllIIIlllIllIlIIlIlll = llllllllllllllIIIlllIllIlIIlIIll ? llllllllllllllIIIlllIllIlIIllIII.getValueDefault() : llllllllllllllIIIlllIllIlIIllIII.getValue();
                final String llllllllllllllIIIlllIllIlIIlIllI = llllllllllllllIIIlllIllIlIIlIlIl.getValue(llllllllllllllIIIlllIllIlIIllIIl);
                if (!Config.equals(llllllllllllllIIIlllIllIlIIlIlll, llllllllllllllIIIlllIllIlIIlIllI)) {
                    return false;
                }
            }
        }
        return true;
    }
}
