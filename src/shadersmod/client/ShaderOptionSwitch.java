package shadersmod.client;

import java.util.regex.*;
import optifine.*;

public class ShaderOptionSwitch extends ShaderOption
{
    private static final /* synthetic */ Pattern PATTERN_DEFINE;
    private static final /* synthetic */ Pattern PATTERN_IFDEF;
    
    static {
        PATTERN_DEFINE = Pattern.compile("^\\s*(//)?\\s*#define\\s+([A-Za-z0-9_]+)\\s*(//.*)?$");
        PATTERN_IFDEF = Pattern.compile("^\\s*#if(n)?def\\s+([A-Za-z0-9_]+)(\\s*)?$");
    }
    
    public static ShaderOption parseOption(final String lllllllllllllllIlIIIlIllllIlIIll, String lllllllllllllllIlIIIlIllllIlIIlI) {
        final Matcher lllllllllllllllIlIIIlIllllIllIlI = ShaderOptionSwitch.PATTERN_DEFINE.matcher(lllllllllllllllIlIIIlIllllIlIIll);
        if (!lllllllllllllllIlIIIlIllllIllIlI.matches()) {
            return null;
        }
        final String lllllllllllllllIlIIIlIllllIllIIl = lllllllllllllllIlIIIlIllllIllIlI.group(1);
        final String lllllllllllllllIlIIIlIllllIllIII = lllllllllllllllIlIIIlIllllIllIlI.group(2);
        final String lllllllllllllllIlIIIlIllllIlIlll = lllllllllllllllIlIIIlIllllIllIlI.group(3);
        if (lllllllllllllllIlIIIlIllllIllIII != null && lllllllllllllllIlIIIlIllllIllIII.length() > 0) {
            final boolean lllllllllllllllIlIIIlIllllIlIllI = Config.equals(lllllllllllllllIlIIIlIllllIllIIl, "//");
            final boolean lllllllllllllllIlIIIlIllllIlIlIl = !lllllllllllllllIlIIIlIllllIlIllI;
            lllllllllllllllIlIIIlIllllIlIIlI = (Exception)StrUtils.removePrefix((String)lllllllllllllllIlIIIlIllllIlIIlI, "/shaders/");
            final ShaderOptionSwitch lllllllllllllllIlIIIlIllllIlIlII = new ShaderOptionSwitch(lllllllllllllllIlIIIlIllllIllIII, lllllllllllllllIlIIIlIllllIlIlll, String.valueOf(lllllllllllllllIlIIIlIllllIlIlIl), (String)lllllllllllllllIlIIIlIllllIlIIlI);
            return lllllllllllllllIlIIIlIllllIlIlII;
        }
        return null;
    }
    
    @Override
    public String getValueText(final String lllllllllllllllIlIIIlIlllllIlIlI) {
        return isTrue(lllllllllllllllIlIIIlIlllllIlIlI) ? Lang.getOn() : Lang.getOff();
    }
    
    @Override
    public String getSourceLine() {
        return isTrue(this.getValue()) ? String.valueOf(new StringBuilder("#define ").append(this.getName()).append(" // Shader option ON")) : String.valueOf(new StringBuilder("//#define ").append(this.getName()).append(" // Shader option OFF"));
    }
    
    @Override
    public boolean checkUsed() {
        return true;
    }
    
    @Override
    public boolean matchesLine(final String lllllllllllllllIlIIIlIllllIIIlIl) {
        final Matcher lllllllllllllllIlIIIlIllllIIIlII = ShaderOptionSwitch.PATTERN_DEFINE.matcher(lllllllllllllllIlIIIlIllllIIIlIl);
        if (!lllllllllllllllIlIIIlIllllIIIlII.matches()) {
            return false;
        }
        final String lllllllllllllllIlIIIlIllllIIIIll = lllllllllllllllIlIIIlIllllIIIlII.group(2);
        return lllllllllllllllIlIIIlIllllIIIIll.matches(this.getName());
    }
    
    @Override
    public boolean isUsedInLine(final String lllllllllllllllIlIIIlIlllIllIlII) {
        final Matcher lllllllllllllllIlIIIlIlllIllIlll = ShaderOptionSwitch.PATTERN_IFDEF.matcher(lllllllllllllllIlIIIlIlllIllIlII);
        if (lllllllllllllllIlIIIlIlllIllIlll.matches()) {
            final String lllllllllllllllIlIIIlIlllIllIllI = lllllllllllllllIlIIIlIlllIllIlll.group(2);
            if (lllllllllllllllIlIIIlIlllIllIllI.equals(this.getName())) {
                return true;
            }
        }
        return false;
    }
    
    public ShaderOptionSwitch(final String lllllllllllllllIlIIIlIlllllllIIl, final String lllllllllllllllIlIIIlIlllllllIII, final String lllllllllllllllIlIIIlIllllllIlll, final String lllllllllllllllIlIIIlIllllllIllI) {
        super(lllllllllllllllIlIIIlIlllllllIIl, lllllllllllllllIlIIIlIlllllllIII, lllllllllllllllIlIIIlIllllllIlll, new String[] { "true", "false" }, lllllllllllllllIlIIIlIllllllIlll, lllllllllllllllIlIIIlIllllllIllI);
    }
    
    public static boolean isTrue(final String lllllllllllllllIlIIIlIlllIlIllll) {
        return Boolean.valueOf(lllllllllllllllIlIIIlIlllIlIllll);
    }
    
    @Override
    public String getValueColor(final String lllllllllllllllIlIIIlIlllllIIllI) {
        return isTrue(lllllllllllllllIlIIIlIlllllIIllI) ? "§a" : "§c";
    }
}
