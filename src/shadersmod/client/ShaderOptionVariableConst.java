package shadersmod.client;

import optifine.*;
import java.util.regex.*;

public class ShaderOptionVariableConst extends ShaderOptionVariable
{
    private /* synthetic */ String type;
    private static final /* synthetic */ Pattern PATTERN_CONST;
    
    public static ShaderOption parseOption(final String llllllllllllllIIIIIIlIIlIIlllIlI, String llllllllllllllIIIIIIlIIlIIlllIIl) {
        final Matcher llllllllllllllIIIIIIlIIlIlIIIIlI = ShaderOptionVariableConst.PATTERN_CONST.matcher(llllllllllllllIIIIIIlIIlIIlllIlI);
        if (!llllllllllllllIIIIIIlIIlIlIIIIlI.matches()) {
            return null;
        }
        final String llllllllllllllIIIIIIlIIlIlIIIIIl = llllllllllllllIIIIIIlIIlIlIIIIlI.group(1);
        final String llllllllllllllIIIIIIlIIlIlIIIIII = llllllllllllllIIIIIIlIIlIlIIIIlI.group(2);
        final String llllllllllllllIIIIIIlIIlIIllllll = llllllllllllllIIIIIIlIIlIlIIIIlI.group(3);
        String llllllllllllllIIIIIIlIIlIIlllllI = llllllllllllllIIIIIIlIIlIlIIIIlI.group(4);
        final String llllllllllllllIIIIIIlIIlIIllllIl = StrUtils.getSegment(llllllllllllllIIIIIIlIIlIIlllllI, "[", "]");
        if (llllllllllllllIIIIIIlIIlIIllllIl != null && llllllllllllllIIIIIIlIIlIIllllIl.length() > 0) {
            llllllllllllllIIIIIIlIIlIIlllllI = llllllllllllllIIIIIIlIIlIIlllllI.replace(llllllllllllllIIIIIIlIIlIIllllIl, "").trim();
        }
        final String[] llllllllllllllIIIIIIlIIlIIllllII = ShaderOptionVariable.parseValues(llllllllllllllIIIIIIlIIlIIllllll, llllllllllllllIIIIIIlIIlIIllllIl);
        if (llllllllllllllIIIIIIlIIlIlIIIIII != null && llllllllllllllIIIIIIlIIlIlIIIIII.length() > 0) {
            llllllllllllllIIIIIIlIIlIIlllIIl = StrUtils.removePrefix(llllllllllllllIIIIIIlIIlIIlllIIl, "/shaders/");
            final ShaderOptionVariableConst llllllllllllllIIIIIIlIIlIIlllIll = new ShaderOptionVariableConst(llllllllllllllIIIIIIlIIlIlIIIIII, llllllllllllllIIIIIIlIIlIlIIIIIl, llllllllllllllIIIIIIlIIlIIlllllI, llllllllllllllIIIIIIlIIlIIllllll, llllllllllllllIIIIIIlIIlIIllllII, llllllllllllllIIIIIIlIIlIIlllIIl);
            return llllllllllllllIIIIIIlIIlIIlllIll;
        }
        return null;
    }
    
    @Override
    public boolean matchesLine(final String llllllllllllllIIIIIIlIIlIlIlIIIl) {
        final Matcher llllllllllllllIIIIIIlIIlIlIlIlII = ShaderOptionVariableConst.PATTERN_CONST.matcher(llllllllllllllIIIIIIlIIlIlIlIIIl);
        if (!llllllllllllllIIIIIIlIIlIlIlIlII.matches()) {
            return false;
        }
        final String llllllllllllllIIIIIIlIIlIlIlIIll = llllllllllllllIIIIIIlIIlIlIlIlII.group(2);
        return llllllllllllllIIIIIIlIIlIlIlIIll.matches(this.getName());
    }
    
    @Override
    public String getSourceLine() {
        return String.valueOf(new StringBuilder("const ").append(this.type).append(" ").append(this.getName()).append(" = ").append(this.getValue()).append("; // Shader option ").append(this.getValue()));
    }
    
    public ShaderOptionVariableConst(final String llllllllllllllIIIIIIlIIlIllIlIlI, final String llllllllllllllIIIIIIlIIlIllIlIIl, final String llllllllllllllIIIIIIlIIlIllIIIIl, final String llllllllllllllIIIIIIlIIlIllIIlll, final String[] llllllllllllllIIIIIIlIIlIllIIllI, final String llllllllllllllIIIIIIlIIlIlIllllI) {
        super(llllllllllllllIIIIIIlIIlIllIlIlI, llllllllllllllIIIIIIlIIlIllIIIIl, llllllllllllllIIIIIIlIIlIllIIlll, llllllllllllllIIIIIIlIIlIllIIllI, llllllllllllllIIIIIIlIIlIlIllllI);
        this.type = null;
        this.type = llllllllllllllIIIIIIlIIlIllIlIIl;
    }
    
    static {
        PATTERN_CONST = Pattern.compile("^\\s*const\\s*(float|int)\\s*([A-Za-z0-9_]+)\\s*=\\s*(-?[0-9\\.]+f?F?)\\s*;\\s*(//.*)?$");
    }
}
