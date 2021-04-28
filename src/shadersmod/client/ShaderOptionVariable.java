package shadersmod.client;

import optifine.*;
import java.util.*;
import java.util.regex.*;

public class ShaderOptionVariable extends ShaderOption
{
    private static final /* synthetic */ Pattern PATTERN_VARIABLE;
    
    public static String[] parseValues(final String lllllllllllllllllllIIlIIlIllllII, String lllllllllllllllllllIIlIIlIllIlll) {
        final String[] lllllllllllllllllllIIlIIlIlllIlI = { lllllllllllllllllllIIlIIlIllllII };
        if (lllllllllllllllllllIIlIIlIllIlll == null) {
            return lllllllllllllllllllIIlIIlIlllIlI;
        }
        lllllllllllllllllllIIlIIlIllIlll = lllllllllllllllllllIIlIIlIllIlll.trim();
        lllllllllllllllllllIIlIIlIllIlll = StrUtils.removePrefix(lllllllllllllllllllIIlIIlIllIlll, "[");
        lllllllllllllllllllIIlIIlIllIlll = StrUtils.removeSuffix(lllllllllllllllllllIIlIIlIllIlll, "]");
        lllllllllllllllllllIIlIIlIllIlll = lllllllllllllllllllIIlIIlIllIlll.trim();
        if (lllllllllllllllllllIIlIIlIllIlll.length() <= 0) {
            return lllllllllllllllllllIIlIIlIlllIlI;
        }
        String[] lllllllllllllllllllIIlIIlIlllIIl = Config.tokenize(lllllllllllllllllllIIlIIlIllIlll, " ");
        if (lllllllllllllllllllIIlIIlIlllIIl.length <= 0) {
            return lllllllllllllllllllIIlIIlIlllIlI;
        }
        if (!Arrays.asList(lllllllllllllllllllIIlIIlIlllIIl).contains(lllllllllllllllllllIIlIIlIllllII)) {
            lllllllllllllllllllIIlIIlIlllIIl = (String[])Config.addObjectToArray(lllllllllllllllllllIIlIIlIlllIIl, lllllllllllllllllllIIlIIlIllllII, 0);
        }
        return lllllllllllllllllllIIlIIlIlllIIl;
    }
    
    public static ShaderOption parseOption(final String lllllllllllllllllllIIlIIllIIlIIl, String lllllllllllllllllllIIlIIllIIlIII) {
        final Matcher lllllllllllllllllllIIlIIllIlIIII = ShaderOptionVariable.PATTERN_VARIABLE.matcher(lllllllllllllllllllIIlIIllIIlIIl);
        if (!lllllllllllllllllllIIlIIllIlIIII.matches()) {
            return null;
        }
        final String lllllllllllllllllllIIlIIllIIllll = lllllllllllllllllllIIlIIllIlIIII.group(1);
        final String lllllllllllllllllllIIlIIllIIlllI = lllllllllllllllllllIIlIIllIlIIII.group(2);
        String lllllllllllllllllllIIlIIllIIllIl = lllllllllllllllllllIIlIIllIlIIII.group(3);
        final String lllllllllllllllllllIIlIIllIIllII = StrUtils.getSegment(lllllllllllllllllllIIlIIllIIllIl, "[", "]");
        if (lllllllllllllllllllIIlIIllIIllII != null && lllllllllllllllllllIIlIIllIIllII.length() > 0) {
            lllllllllllllllllllIIlIIllIIllIl = lllllllllllllllllllIIlIIllIIllIl.replace(lllllllllllllllllllIIlIIllIIllII, "").trim();
        }
        final String[] lllllllllllllllllllIIlIIllIIlIll = parseValues(lllllllllllllllllllIIlIIllIIlllI, lllllllllllllllllllIIlIIllIIllII);
        if (lllllllllllllllllllIIlIIllIIllll != null && lllllllllllllllllllIIlIIllIIllll.length() > 0) {
            lllllllllllllllllllIIlIIllIIlIII = (long)StrUtils.removePrefix((String)lllllllllllllllllllIIlIIllIIlIII, "/shaders/");
            final ShaderOptionVariable lllllllllllllllllllIIlIIllIIlIlI = new ShaderOptionVariable(lllllllllllllllllllIIlIIllIIllll, lllllllllllllllllllIIlIIllIIllIl, lllllllllllllllllllIIlIIllIIlllI, lllllllllllllllllllIIlIIllIIlIll, (String)lllllllllllllllllllIIlIIllIIlIII);
            return lllllllllllllllllllIIlIIllIIlIlI;
        }
        return null;
    }
    
    @Override
    public boolean matchesLine(final String lllllllllllllllllllIIlIIllIllllI) {
        final Matcher lllllllllllllllllllIIlIIlllIIIIl = ShaderOptionVariable.PATTERN_VARIABLE.matcher(lllllllllllllllllllIIlIIllIllllI);
        if (!lllllllllllllllllllIIlIIlllIIIIl.matches()) {
            return false;
        }
        final String lllllllllllllllllllIIlIIlllIIIII = lllllllllllllllllllIIlIIlllIIIIl.group(1);
        return lllllllllllllllllllIIlIIlllIIIII.matches(this.getName());
    }
    
    public ShaderOptionVariable(final String lllllllllllllllllllIIlIIllllIIIl, final String lllllllllllllllllllIIlIIllllIIII, final String lllllllllllllllllllIIlIIlllIllll, final String[] lllllllllllllllllllIIlIIlllIlllI, final String lllllllllllllllllllIIlIIlllIllIl) {
        super(lllllllllllllllllllIIlIIllllIIIl, lllllllllllllllllllIIlIIllllIIII, lllllllllllllllllllIIlIIlllIllll, lllllllllllllllllllIIlIIlllIlllI, lllllllllllllllllllIIlIIlllIllll, lllllllllllllllllllIIlIIlllIllIl);
        this.setVisible(this.getValues().length > 1);
    }
    
    @Override
    public String getSourceLine() {
        return String.valueOf(new StringBuilder("#define ").append(this.getName()).append(" ").append(this.getValue()).append(" // Shader option ").append(this.getValue()));
    }
    
    @Override
    public String getValueColor(final String lllllllllllllllllllIIlIIlllIlIII) {
        return "§a";
    }
    
    static {
        PATTERN_VARIABLE = Pattern.compile("^\\s*#define\\s+([A-Za-z0-9_]+)\\s+(-?[0-9\\.]*)F?f?\\s*(//.*)?$");
    }
}
