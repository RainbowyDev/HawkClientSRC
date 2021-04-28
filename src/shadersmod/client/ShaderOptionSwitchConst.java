package shadersmod.client;

import java.util.regex.*;
import optifine.*;

public class ShaderOptionSwitchConst extends ShaderOptionSwitch
{
    private static final /* synthetic */ Pattern PATTERN_CONST;
    
    static {
        PATTERN_CONST = Pattern.compile("^\\s*const\\s*bool\\s*([A-Za-z0-9_]+)\\s*=\\s*(true|false)\\s*;\\s*(//.*)?$");
    }
    
    public ShaderOptionSwitchConst(final String lllllllllllllllllIllIlIlIIlllIlI, final String lllllllllllllllllIllIlIlIIlllllI, final String lllllllllllllllllIllIlIlIIllllIl, final String lllllllllllllllllIllIlIlIIllIlll) {
        super(lllllllllllllllllIllIlIlIIlllIlI, lllllllllllllllllIllIlIlIIlllllI, lllllllllllllllllIllIlIlIIllllIl, lllllllllllllllllIllIlIlIIllIlll);
    }
    
    @Override
    public boolean checkUsed() {
        return false;
    }
    
    @Override
    public boolean matchesLine(final String lllllllllllllllllIllIlIlIIIlIlIl) {
        final Matcher lllllllllllllllllIllIlIlIIIllIII = ShaderOptionSwitchConst.PATTERN_CONST.matcher(lllllllllllllllllIllIlIlIIIlIlIl);
        if (!lllllllllllllllllIllIlIlIIIllIII.matches()) {
            return false;
        }
        final String lllllllllllllllllIllIlIlIIIlIlll = lllllllllllllllllIllIlIlIIIllIII.group(1);
        return lllllllllllllllllIllIlIlIIIlIlll.matches(this.getName());
    }
    
    @Override
    public String getSourceLine() {
        return String.valueOf(new StringBuilder("const bool ").append(this.getName()).append(" = ").append(this.getValue()).append("; // Shader option ").append(this.getValue()));
    }
    
    public static ShaderOption parseOption(final String lllllllllllllllllIllIlIlIIlIIlIl, String lllllllllllllllllIllIlIlIIlIIlII) {
        final Matcher lllllllllllllllllIllIlIlIIlIlIlI = ShaderOptionSwitchConst.PATTERN_CONST.matcher(lllllllllllllllllIllIlIlIIlIIlIl);
        if (!lllllllllllllllllIllIlIlIIlIlIlI.matches()) {
            return null;
        }
        final String lllllllllllllllllIllIlIlIIlIlIIl = lllllllllllllllllIllIlIlIIlIlIlI.group(1);
        final String lllllllllllllllllIllIlIlIIlIlIII = lllllllllllllllllIllIlIlIIlIlIlI.group(2);
        final String lllllllllllllllllIllIlIlIIlIIlll = lllllllllllllllllIllIlIlIIlIlIlI.group(3);
        if (lllllllllllllllllIllIlIlIIlIlIIl != null && lllllllllllllllllIllIlIlIIlIlIIl.length() > 0) {
            lllllllllllllllllIllIlIlIIlIIlII = StrUtils.removePrefix(lllllllllllllllllIllIlIlIIlIIlII, "/shaders/");
            final ShaderOptionSwitchConst lllllllllllllllllIllIlIlIIlIIllI = new ShaderOptionSwitchConst(lllllllllllllllllIllIlIlIIlIlIIl, lllllllllllllllllIllIlIlIIlIIlll, lllllllllllllllllIllIlIlIIlIlIII, lllllllllllllllllIllIlIlIIlIIlII);
            lllllllllllllllllIllIlIlIIlIIllI.setVisible(false);
            return lllllllllllllllllIllIlIlIIlIIllI;
        }
        return null;
    }
}
