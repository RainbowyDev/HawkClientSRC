package shadersmod.client;

import java.util.regex.*;
import optifine.*;
import java.io.*;
import java.util.*;

public class ShaderPackParser
{
    private static final /* synthetic */ Pattern PATTERN_INCLUDE;
    private static final /* synthetic */ Set<String> setConstNames;
    
    public static BufferedReader resolveIncludes(final BufferedReader llllllllllllllllIIlIlIIllIIIIIll, final String llllllllllllllllIIlIlIIlIlllIlIl, final IShaderPack llllllllllllllllIIlIlIIlIlllIlII, final int llllllllllllllllIIlIlIIlIlllIIll) throws IOException {
        String llllllllllllllllIIlIlIIlIlllllll = "/";
        final int llllllllllllllllIIlIlIIlIllllllI = llllllllllllllllIIlIlIIlIlllIlIl.lastIndexOf("/");
        if (llllllllllllllllIIlIlIIlIllllllI >= 0) {
            llllllllllllllllIIlIlIIlIlllllll = llllllllllllllllIIlIlIIlIlllIlIl.substring(0, llllllllllllllllIIlIlIIlIllllllI);
        }
        final CharArrayWriter llllllllllllllllIIlIlIIlIlllllIl = new CharArrayWriter();
        while (true) {
            String llllllllllllllllIIlIlIIlIlllllII = llllllllllllllllIIlIlIIllIIIIIll.readLine();
            if (llllllllllllllllIIlIlIIlIlllllII == null) {
                final CharArrayReader llllllllllllllllIIlIlIIlIllllIll = new CharArrayReader(llllllllllllllllIIlIlIIlIlllllIl.toCharArray());
                return new BufferedReader(llllllllllllllllIIlIlIIlIllllIll);
            }
            final Matcher llllllllllllllllIIlIlIIlIllllIlI = ShaderPackParser.PATTERN_INCLUDE.matcher(llllllllllllllllIIlIlIIlIlllllII);
            if (llllllllllllllllIIlIlIIlIllllIlI.matches()) {
                final String llllllllllllllllIIlIlIIlIllllIIl = llllllllllllllllIIlIlIIlIllllIlI.group(1);
                final boolean llllllllllllllllIIlIlIIlIllllIII = llllllllllllllllIIlIlIIlIllllIIl.startsWith("/");
                final String llllllllllllllllIIlIlIIlIlllIlll = llllllllllllllllIIlIlIIlIllllIII ? String.valueOf(new StringBuilder("/shaders").append(llllllllllllllllIIlIlIIlIllllIIl)) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIlIlIIlIlllllll)).append("/").append(llllllllllllllllIIlIlIIlIllllIIl));
                llllllllllllllllIIlIlIIlIlllllII = loadFile(llllllllllllllllIIlIlIIlIlllIlll, llllllllllllllllIIlIlIIlIlllIlII, llllllllllllllllIIlIlIIlIlllIIll);
                if (llllllllllllllllIIlIlIIlIlllllII == null) {
                    throw new IOException(String.valueOf(new StringBuilder("Included file not found: ").append(llllllllllllllllIIlIlIIlIlllIlIl)));
                }
            }
            llllllllllllllllIIlIlIIlIlllllIl.write(llllllllllllllllIIlIlIIlIlllllII);
            llllllllllllllllIIlIlIIlIlllllIl.write("\n");
        }
    }
    
    private static ShaderOption getShaderOption(final String llllllllllllllllIIlIlIlIIIlIIlII, final String llllllllllllllllIIlIlIlIIIlIIIll) {
        ShaderOption llllllllllllllllIIlIlIlIIIlIIIlI = null;
        if (llllllllllllllllIIlIlIlIIIlIIIlI == null) {
            llllllllllllllllIIlIlIlIIIlIIIlI = ShaderOptionSwitch.parseOption(llllllllllllllllIIlIlIlIIIlIIlII, llllllllllllllllIIlIlIlIIIlIIIll);
        }
        if (llllllllllllllllIIlIlIlIIIlIIIlI == null) {
            llllllllllllllllIIlIlIlIIIlIIIlI = ShaderOptionVariable.parseOption(llllllllllllllllIIlIlIlIIIlIIlII, llllllllllllllllIIlIlIlIIIlIIIll);
        }
        if (llllllllllllllllIIlIlIlIIIlIIIlI != null) {
            return llllllllllllllllIIlIlIlIIIlIIIlI;
        }
        if (llllllllllllllllIIlIlIlIIIlIIIlI == null) {
            llllllllllllllllIIlIlIlIIIlIIIlI = ShaderOptionSwitchConst.parseOption(llllllllllllllllIIlIlIlIIIlIIlII, llllllllllllllllIIlIlIlIIIlIIIll);
        }
        if (llllllllllllllllIIlIlIlIIIlIIIlI == null) {
            llllllllllllllllIIlIlIlIIIlIIIlI = ShaderOptionVariableConst.parseOption(llllllllllllllllIIlIlIlIIIlIIlII, llllllllllllllllIIlIlIlIIIlIIIll);
        }
        return (llllllllllllllllIIlIlIlIIIlIIIlI != null && ShaderPackParser.setConstNames.contains(llllllllllllllllIIlIlIlIIIlIIIlI.getName())) ? llllllllllllllllIIlIlIlIIIlIIIlI : null;
    }
    
    private static boolean isOptionUsed(final ShaderOption llllllllllllllllIIlIlIlIIIllllll, final String[] llllllllllllllllIIlIlIlIIIlllIlI) {
        for (int llllllllllllllllIIlIlIlIIIllllIl = 0; llllllllllllllllIIlIlIlIIIllllIl < llllllllllllllllIIlIlIlIIIlllIlI.length; ++llllllllllllllllIIlIlIlIIIllllIl) {
            final String llllllllllllllllIIlIlIlIIIllllII = llllllllllllllllIIlIlIlIIIlllIlI[llllllllllllllllIIlIlIlIIIllllIl];
            if (llllllllllllllllIIlIlIlIIIllllll.isUsedInLine(llllllllllllllllIIlIlIlIIIllllII)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean parseGuiScreen(final String llllllllllllllllIIlIlIIllIIlllII, final Properties llllllllllllllllIIlIlIIllIlIllII, final Map<String, ShaderOption[]> llllllllllllllllIIlIlIIllIlIlIll, final ShaderProfile[] llllllllllllllllIIlIlIIllIlIlIlI, final ShaderOption[] llllllllllllllllIIlIlIIllIIllIII) {
        final String llllllllllllllllIIlIlIIllIlIlIII = llllllllllllllllIIlIlIIllIlIllII.getProperty(llllllllllllllllIIlIlIIllIIlllII);
        if (llllllllllllllllIIlIlIIllIlIlIII == null) {
            return false;
        }
        final ArrayList llllllllllllllllIIlIlIIllIlIIlll = new ArrayList();
        final HashSet llllllllllllllllIIlIlIIllIlIIllI = new HashSet();
        final String[] llllllllllllllllIIlIlIIllIlIIlIl = Config.tokenize(llllllllllllllllIIlIlIIllIlIlIII, " ");
        for (int llllllllllllllllIIlIlIIllIlIIlII = 0; llllllllllllllllIIlIlIIllIlIIlII < llllllllllllllllIIlIlIIllIlIIlIl.length; ++llllllllllllllllIIlIlIIllIlIIlII) {
            final String llllllllllllllllIIlIlIIllIlIIIll = llllllllllllllllIIlIlIIllIlIIlIl[llllllllllllllllIIlIlIIllIlIIlII];
            if (llllllllllllllllIIlIlIIllIlIIIll.equals("<empty>")) {
                llllllllllllllllIIlIlIIllIlIIlll.add(null);
            }
            else if (llllllllllllllllIIlIlIIllIlIIllI.contains(llllllllllllllllIIlIlIIllIlIIIll)) {
                Config.warn(String.valueOf(new StringBuilder("[Shaders] Duplicate option: ").append(llllllllllllllllIIlIlIIllIlIIIll).append(", key: ").append(llllllllllllllllIIlIlIIllIIlllII)));
            }
            else {
                llllllllllllllllIIlIlIIllIlIIllI.add(llllllllllllllllIIlIlIIllIlIIIll);
                if (llllllllllllllllIIlIlIIllIlIIIll.equals("<profile>")) {
                    if (llllllllllllllllIIlIlIIllIlIlIlI == null) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Option profile can not be used, no profiles defined: ").append(llllllllllllllllIIlIlIIllIlIIIll).append(", key: ").append(llllllllllllllllIIlIlIIllIIlllII)));
                    }
                    else {
                        final ShaderOptionProfile llllllllllllllllIIlIlIIllIlIIIlI = new ShaderOptionProfile(llllllllllllllllIIlIlIIllIlIlIlI, llllllllllllllllIIlIlIIllIIllIII);
                        llllllllllllllllIIlIlIIllIlIIlll.add(llllllllllllllllIIlIlIIllIlIIIlI);
                    }
                }
                else if (llllllllllllllllIIlIlIIllIlIIIll.equals("*")) {
                    final ShaderOptionRest llllllllllllllllIIlIlIIllIlIIIIl = new ShaderOptionRest("<rest>");
                    llllllllllllllllIIlIlIIllIlIIlll.add(llllllllllllllllIIlIlIIllIlIIIIl);
                }
                else if (llllllllllllllllIIlIlIIllIlIIIll.startsWith("[") && llllllllllllllllIIlIlIIllIlIIIll.endsWith("]")) {
                    final String llllllllllllllllIIlIlIIllIlIIIII = StrUtils.removePrefixSuffix(llllllllllllllllIIlIlIIllIlIIIll, "[", "]");
                    if (!llllllllllllllllIIlIlIIllIlIIIII.matches("^[a-zA-Z0-9_]+$")) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid screen: ").append(llllllllllllllllIIlIlIIllIlIIIll).append(", key: ").append(llllllllllllllllIIlIlIIllIIlllII)));
                    }
                    else if (!parseGuiScreen(String.valueOf(new StringBuilder("screen.").append(llllllllllllllllIIlIlIIllIlIIIII)), llllllllllllllllIIlIlIIllIlIllII, llllllllllllllllIIlIlIIllIlIlIll, llllllllllllllllIIlIlIIllIlIlIlI, llllllllllllllllIIlIlIIllIIllIII)) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid screen: ").append(llllllllllllllllIIlIlIIllIlIIIll).append(", key: ").append(llllllllllllllllIIlIlIIllIIlllII)));
                    }
                    else {
                        final ShaderOptionScreen llllllllllllllllIIlIlIIllIIlllll = new ShaderOptionScreen(llllllllllllllllIIlIlIIllIlIIIII);
                        llllllllllllllllIIlIlIIllIlIIlll.add(llllllllllllllllIIlIlIIllIIlllll);
                    }
                }
                else {
                    final ShaderOption llllllllllllllllIIlIlIIllIIllllI = ShaderUtils.getShaderOption(llllllllllllllllIIlIlIIllIlIIIll, llllllllllllllllIIlIlIIllIIllIII);
                    if (llllllllllllllllIIlIlIIllIIllllI == null) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid option: ").append(llllllllllllllllIIlIlIIllIlIIIll).append(", key: ").append(llllllllllllllllIIlIlIIllIIlllII)));
                        llllllllllllllllIIlIlIIllIlIIlll.add(null);
                    }
                    else {
                        llllllllllllllllIIlIlIIllIIllllI.setVisible(true);
                        llllllllllllllllIIlIlIIllIlIIlll.add(llllllllllllllllIIlIlIIllIIllllI);
                    }
                }
            }
        }
        final ShaderOption[] llllllllllllllllIIlIlIIllIIlllIl = llllllllllllllllIIlIlIIllIlIIlll.toArray(new ShaderOption[llllllllllllllllIIlIlIIllIlIIlll.size()]);
        llllllllllllllllIIlIlIIllIlIlIll.put(llllllllllllllllIIlIlIIllIIlllII, llllllllllllllllIIlIlIIllIIlllIl);
        return true;
    }
    
    private static ShaderProfile parseProfile(final String llllllllllllllllIIlIlIIllllIllII, final Properties llllllllllllllllIIlIlIIlllIlIlIl, final Set<String> llllllllllllllllIIlIlIIllllIlIlI, final ShaderOption[] llllllllllllllllIIlIlIIlllIlIIll) {
        final String llllllllllllllllIIlIlIIllllIlIII = "profile.";
        final String llllllllllllllllIIlIlIIllllIIlll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIlIlIIllllIlIII)).append(llllllllllllllllIIlIlIIllllIllII));
        if (llllllllllllllllIIlIlIIllllIlIlI.contains(llllllllllllllllIIlIlIIllllIIlll)) {
            Config.warn(String.valueOf(new StringBuilder("[Shaders] Profile already parsed: ").append(llllllllllllllllIIlIlIIllllIllII)));
            return null;
        }
        llllllllllllllllIIlIlIIllllIlIlI.add(llllllllllllllllIIlIlIIllllIllII);
        final ShaderProfile llllllllllllllllIIlIlIIllllIIllI = new ShaderProfile(llllllllllllllllIIlIlIIllllIllII);
        final String llllllllllllllllIIlIlIIllllIIlIl = llllllllllllllllIIlIlIIlllIlIlIl.getProperty(llllllllllllllllIIlIlIIllllIIlll);
        final String[] llllllllllllllllIIlIlIIllllIIlII = Config.tokenize(llllllllllllllllIIlIlIIllllIIlIl, " ");
        for (int llllllllllllllllIIlIlIIllllIIIll = 0; llllllllllllllllIIlIlIIllllIIIll < llllllllllllllllIIlIlIIllllIIlII.length; ++llllllllllllllllIIlIlIIllllIIIll) {
            final String llllllllllllllllIIlIlIIllllIIIlI = llllllllllllllllIIlIlIIllllIIlII[llllllllllllllllIIlIlIIllllIIIll];
            if (llllllllllllllllIIlIlIIllllIIIlI.startsWith(llllllllllllllllIIlIlIIllllIlIII)) {
                final String llllllllllllllllIIlIlIIllllIIIIl = llllllllllllllllIIlIlIIllllIIIlI.substring(llllllllllllllllIIlIlIIllllIlIII.length());
                final ShaderProfile llllllllllllllllIIlIlIIllllIIIII = parseProfile(llllllllllllllllIIlIlIIllllIIIIl, llllllllllllllllIIlIlIIlllIlIlIl, llllllllllllllllIIlIlIIllllIlIlI, llllllllllllllllIIlIlIIlllIlIIll);
                if (llllllllllllllllIIlIlIIllllIIllI != null) {
                    llllllllllllllllIIlIlIIllllIIllI.addOptionValues(llllllllllllllllIIlIlIIllllIIIII);
                    llllllllllllllllIIlIlIIllllIIllI.addDisabledPrograms(llllllllllllllllIIlIlIIllllIIIII.getDisabledPrograms());
                }
            }
            else {
                final String[] llllllllllllllllIIlIlIIlllIlllll = Config.tokenize(llllllllllllllllIIlIlIIllllIIIlI, ":=");
                if (llllllllllllllllIIlIlIIlllIlllll.length == 1) {
                    String llllllllllllllllIIlIlIIlllIllllI = llllllllllllllllIIlIlIIlllIlllll[0];
                    boolean llllllllllllllllIIlIlIIlllIlllII = true;
                    if (llllllllllllllllIIlIlIIlllIllllI.startsWith("!")) {
                        llllllllllllllllIIlIlIIlllIlllII = false;
                        llllllllllllllllIIlIlIIlllIllllI = llllllllllllllllIIlIlIIlllIllllI.substring(1);
                    }
                    final String llllllllllllllllIIlIlIIlllIllIll = "program.";
                    if (!llllllllllllllllIIlIlIIlllIlllII && llllllllllllllllIIlIlIIlllIllllI.startsWith("program.")) {
                        final String llllllllllllllllIIlIlIIlllIllIlI = llllllllllllllllIIlIlIIlllIllllI.substring(llllllllllllllllIIlIlIIlllIllIll.length());
                        if (!Shaders.isProgramPath(llllllllllllllllIIlIlIIlllIllIlI)) {
                            Config.warn(String.valueOf(new StringBuilder("Invalid program: ").append(llllllllllllllllIIlIlIIlllIllIlI).append(" in profile: ").append(llllllllllllllllIIlIlIIllllIIllI.getName())));
                        }
                        else {
                            llllllllllllllllIIlIlIIllllIIllI.addDisabledProgram(llllllllllllllllIIlIlIIlllIllIlI);
                        }
                    }
                    else {
                        final ShaderOption llllllllllllllllIIlIlIIlllIllIIl = ShaderUtils.getShaderOption(llllllllllllllllIIlIlIIlllIllllI, llllllllllllllllIIlIlIIlllIlIIll);
                        if (!(llllllllllllllllIIlIlIIlllIllIIl instanceof ShaderOptionSwitch)) {
                            Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid option: ").append(llllllllllllllllIIlIlIIlllIllllI)));
                        }
                        else {
                            llllllllllllllllIIlIlIIllllIIllI.addOptionValue(llllllllllllllllIIlIlIIlllIllllI, String.valueOf(llllllllllllllllIIlIlIIlllIlllII));
                            llllllllllllllllIIlIlIIlllIllIIl.setVisible(true);
                        }
                    }
                }
                else if (llllllllllllllllIIlIlIIlllIlllll.length != 2) {
                    Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid option value: ").append(llllllllllllllllIIlIlIIllllIIIlI)));
                }
                else {
                    final String llllllllllllllllIIlIlIIlllIlllIl = llllllllllllllllIIlIlIIlllIlllll[0];
                    final String llllllllllllllllIIlIlIIlllIllIII = llllllllllllllllIIlIlIIlllIlllll[1];
                    final ShaderOption llllllllllllllllIIlIlIIlllIlIlll = ShaderUtils.getShaderOption(llllllllllllllllIIlIlIIlllIlllIl, llllllllllllllllIIlIlIIlllIlIIll);
                    if (llllllllllllllllIIlIlIIlllIlIlll == null) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid option: ").append(llllllllllllllllIIlIlIIllllIIIlI)));
                    }
                    else if (!llllllllllllllllIIlIlIIlllIlIlll.isValidValue(llllllllllllllllIIlIlIIlllIllIII)) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid value: ").append(llllllllllllllllIIlIlIIllllIIIlI)));
                    }
                    else {
                        llllllllllllllllIIlIlIIlllIlIlll.setVisible(true);
                        llllllllllllllllIIlIlIIllllIIllI.addOptionValue(llllllllllllllllIIlIlIIlllIlllIl, llllllllllllllllIIlIlIIlllIllIII);
                    }
                }
            }
        }
        return llllllllllllllllIIlIlIIllllIIllI;
    }
    
    private static String[] getLines(final IShaderPack llllllllllllllllIIlIlIlIIIllIIlI, final String llllllllllllllllIIlIlIlIIIllIIIl) {
        try {
            final String llllllllllllllllIIlIlIlIIIllIIII = loadFile(llllllllllllllllIIlIlIlIIIllIIIl, llllllllllllllllIIlIlIlIIIllIIlI, 0);
            if (llllllllllllllllIIlIlIlIIIllIIII == null) {
                return new String[0];
            }
            final ByteArrayInputStream llllllllllllllllIIlIlIlIIIlIllll = new ByteArrayInputStream(llllllllllllllllIIlIlIlIIIllIIII.getBytes());
            final String[] llllllllllllllllIIlIlIlIIIlIlllI = Config.readLines(llllllllllllllllIIlIlIlIIIlIllll);
            return llllllllllllllllIIlIlIlIIIlIlllI;
        }
        catch (IOException llllllllllllllllIIlIlIlIIIlIllIl) {
            Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIlIlIlIIIlIllIl.getClass().getName())).append(": ").append(llllllllllllllllIIlIlIlIIIlIllIl.getMessage())));
            return new String[0];
        }
    }
    
    private static void collectShaderOptions(final IShaderPack llllllllllllllllIIlIlIlIIllIIllI, final String llllllllllllllllIIlIlIlIIllIIlIl, final String[] llllllllllllllllIIlIlIlIIllIllII, final Map<String, ShaderOption> llllllllllllllllIIlIlIlIIllIIIll) {
        for (int llllllllllllllllIIlIlIlIIllIlIlI = 0; llllllllllllllllIIlIlIlIIllIlIlI < llllllllllllllllIIlIlIlIIllIllII.length; ++llllllllllllllllIIlIlIlIIllIlIlI) {
            final String llllllllllllllllIIlIlIlIIllIlIIl = llllllllllllllllIIlIlIlIIllIllII[llllllllllllllllIIlIlIlIIllIlIlI];
            if (!llllllllllllllllIIlIlIlIIllIlIIl.equals("")) {
                final String llllllllllllllllIIlIlIlIIllIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIlIlIlIIllIIlIl)).append("/").append(llllllllllllllllIIlIlIlIIllIlIIl).append(".vsh"));
                final String llllllllllllllllIIlIlIlIIllIIlll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIlIlIlIIllIIlIl)).append("/").append(llllllllllllllllIIlIlIlIIllIlIIl).append(".fsh"));
                collectShaderOptions(llllllllllllllllIIlIlIlIIllIIllI, llllllllllllllllIIlIlIlIIllIlIII, llllllllllllllllIIlIlIlIIllIIIll);
                collectShaderOptions(llllllllllllllllIIlIlIlIIllIIllI, llllllllllllllllIIlIlIlIIllIIlll, llllllllllllllllIIlIlIlIIllIIIll);
            }
        }
    }
    
    private static String loadFile(final String llllllllllllllllIIlIlIIlIllIIIlI, final IShaderPack llllllllllllllllIIlIlIIlIlIllIIl, int llllllllllllllllIIlIlIIlIllIIIII) throws IOException {
        if (llllllllllllllllIIlIlIIlIllIIIII >= 10) {
            throw new IOException(String.valueOf(new StringBuilder("#include depth exceeded: ").append(llllllllllllllllIIlIlIIlIllIIIII).append(", file: ").append(llllllllllllllllIIlIlIIlIllIIIlI)));
        }
        ++llllllllllllllllIIlIlIIlIllIIIII;
        final InputStream llllllllllllllllIIlIlIIlIlIlllll = llllllllllllllllIIlIlIIlIlIllIIl.getResourceAsStream(llllllllllllllllIIlIlIIlIllIIIlI);
        if (llllllllllllllllIIlIlIIlIlIlllll == null) {
            return null;
        }
        final InputStreamReader llllllllllllllllIIlIlIIlIlIllllI = new InputStreamReader(llllllllllllllllIIlIlIIlIlIlllll, "ASCII");
        BufferedReader llllllllllllllllIIlIlIIlIlIlllIl = new BufferedReader(llllllllllllllllIIlIlIIlIlIllllI);
        llllllllllllllllIIlIlIIlIlIlllIl = resolveIncludes(llllllllllllllllIIlIlIIlIlIlllIl, llllllllllllllllIIlIlIIlIllIIIlI, llllllllllllllllIIlIlIIlIlIllIIl, llllllllllllllllIIlIlIIlIllIIIII);
        final CharArrayWriter llllllllllllllllIIlIlIIlIlIlllII = new CharArrayWriter();
        while (true) {
            final String llllllllllllllllIIlIlIIlIlIllIll = llllllllllllllllIIlIlIIlIlIlllIl.readLine();
            if (llllllllllllllllIIlIlIIlIlIllIll == null) {
                break;
            }
            llllllllllllllllIIlIlIIlIlIlllII.write(llllllllllllllllIIlIlIIlIlIllIll);
            llllllllllllllllIIlIlIIlIlIlllII.write("\n");
        }
        return llllllllllllllllIIlIlIIlIlIlllII.toString();
    }
    
    static {
        PATTERN_INCLUDE = Pattern.compile("^\\s*#include\\s+\"([A-Za-z0-9_/\\.]+)\".*$");
        setConstNames = makeSetConstNames();
    }
    
    private static void collectShaderOptions(final IShaderPack llllllllllllllllIIlIlIlIIlIlIlIl, final String llllllllllllllllIIlIlIlIIlIlIlII, final Map<String, ShaderOption> llllllllllllllllIIlIlIlIIlIlIIll) {
        final String[] llllllllllllllllIIlIlIlIIlIlIIlI = getLines(llllllllllllllllIIlIlIlIIlIlIlIl, llllllllllllllllIIlIlIlIIlIlIlII);
        for (int llllllllllllllllIIlIlIlIIlIlIIIl = 0; llllllllllllllllIIlIlIlIIlIlIIIl < llllllllllllllllIIlIlIlIIlIlIIlI.length; ++llllllllllllllllIIlIlIlIIlIlIIIl) {
            final String llllllllllllllllIIlIlIlIIlIlIIII = llllllllllllllllIIlIlIlIIlIlIIlI[llllllllllllllllIIlIlIlIIlIlIIIl];
            final ShaderOption llllllllllllllllIIlIlIlIIlIIllll = getShaderOption(llllllllllllllllIIlIlIlIIlIlIIII, llllllllllllllllIIlIlIlIIlIlIlII);
            if (llllllllllllllllIIlIlIlIIlIIllll != null && (!llllllllllllllllIIlIlIlIIlIIllll.checkUsed() || isOptionUsed(llllllllllllllllIIlIlIlIIlIIllll, llllllllllllllllIIlIlIlIIlIlIIlI))) {
                final String llllllllllllllllIIlIlIlIIlIIlllI = llllllllllllllllIIlIlIlIIlIIllll.getName();
                final ShaderOption llllllllllllllllIIlIlIlIIlIIllIl = llllllllllllllllIIlIlIlIIlIlIIll.get(llllllllllllllllIIlIlIlIIlIIlllI);
                if (llllllllllllllllIIlIlIlIIlIIllIl != null) {
                    if (!Config.equals(llllllllllllllllIIlIlIlIIlIIllIl.getValueDefault(), llllllllllllllllIIlIlIlIIlIIllll.getValueDefault())) {
                        Config.warn(String.valueOf(new StringBuilder("Ambiguous shader option: ").append(llllllllllllllllIIlIlIlIIlIIllll.getName())));
                        Config.warn(String.valueOf(new StringBuilder(" - in ").append(Config.arrayToString(llllllllllllllllIIlIlIlIIlIIllIl.getPaths())).append(": ").append(llllllllllllllllIIlIlIlIIlIIllIl.getValueDefault())));
                        Config.warn(String.valueOf(new StringBuilder(" - in ").append(Config.arrayToString(llllllllllllllllIIlIlIlIIlIIllll.getPaths())).append(": ").append(llllllllllllllllIIlIlIlIIlIIllll.getValueDefault())));
                        llllllllllllllllIIlIlIlIIlIIllIl.setEnabled(false);
                    }
                    if (llllllllllllllllIIlIlIlIIlIIllIl.getDescription() == null || llllllllllllllllIIlIlIlIIlIIllIl.getDescription().length() <= 0) {
                        llllllllllllllllIIlIlIlIIlIIllIl.setDescription(llllllllllllllllIIlIlIlIIlIIllll.getDescription());
                    }
                    llllllllllllllllIIlIlIlIIlIIllIl.addPaths(llllllllllllllllIIlIlIlIIlIIllll.getPaths());
                }
                else {
                    llllllllllllllllIIlIlIlIIlIlIIll.put(llllllllllllllllIIlIlIlIIlIIlllI, llllllllllllllllIIlIlIlIIlIIllll);
                }
            }
        }
    }
    
    public static ShaderOption[] parseShaderPackOptions(final IShaderPack llllllllllllllllIIlIlIlIIllllllI, final String[] llllllllllllllllIIlIlIlIlIIIIlll, final List<Integer> llllllllllllllllIIlIlIlIIlllllII) {
        if (llllllllllllllllIIlIlIlIIllllllI == null) {
            return new ShaderOption[0];
        }
        final HashMap llllllllllllllllIIlIlIlIlIIIIlIl = new HashMap();
        collectShaderOptions(llllllllllllllllIIlIlIlIIllllllI, "/shaders", llllllllllllllllIIlIlIlIlIIIIlll, llllllllllllllllIIlIlIlIlIIIIlIl);
        for (final int llllllllllllllllIIlIlIlIlIIIIIll : llllllllllllllllIIlIlIlIIlllllII) {
            final String llllllllllllllllIIlIlIlIlIIIIIlI = String.valueOf(new StringBuilder("/shaders/world").append(llllllllllllllllIIlIlIlIlIIIIIll));
            collectShaderOptions(llllllllllllllllIIlIlIlIIllllllI, llllllllllllllllIIlIlIlIlIIIIIlI, llllllllllllllllIIlIlIlIlIIIIlll, llllllllllllllllIIlIlIlIlIIIIlIl);
        }
        final Collection llllllllllllllllIIlIlIlIlIIIIIIl = llllllllllllllllIIlIlIlIlIIIIlIl.values();
        final ShaderOption[] llllllllllllllllIIlIlIlIlIIIIIII = llllllllllllllllIIlIlIlIlIIIIIIl.toArray(new ShaderOption[llllllllllllllllIIlIlIlIlIIIIIIl.size()]);
        final Comparator llllllllllllllllIIlIlIlIIlllllll = new Comparator() {
            @Override
            public int compare(final Object lllllllllllllllIlIllIIIIIllllIII, final Object lllllllllllllllIlIllIIIIIllllIlI) {
                return this.compare((ShaderOption)lllllllllllllllIlIllIIIIIllllIII, (ShaderOption)lllllllllllllllIlIllIIIIIllllIlI);
            }
            
            public int compare(final ShaderOption lllllllllllllllIlIllIIIIlIIIIIIl, final ShaderOption lllllllllllllllIlIllIIIIlIIIIIII) {
                return lllllllllllllllIlIllIIIIlIIIIIIl.getName().compareToIgnoreCase(lllllllllllllllIlIllIIIIlIIIIIII.getName());
            }
        };
        Arrays.sort(llllllllllllllllIIlIlIlIlIIIIIII, llllllllllllllllIIlIlIlIIlllllll);
        return llllllllllllllllIIlIlIlIlIIIIIII;
    }
    
    private static Set<String> makeSetConstNames() {
        final HashSet llllllllllllllllIIlIlIlIIIIlllIl = new HashSet();
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowMapResolution");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowDistance");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowIntervalSize");
        llllllllllllllllIIlIlIlIIIIlllIl.add("generateShadowMipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("generateShadowColorMipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowHardwareFiltering");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowHardwareFiltering0");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowHardwareFiltering1");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowtex0Mipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowtexMipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowtex1Mipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowcolor0Mipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowColor0Mipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowcolor1Mipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowColor1Mipmap");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowtex0Nearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowtexNearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadow0MinMagNearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowtex1Nearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadow1MinMagNearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowcolor0Nearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowColor0Nearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowColor0MinMagNearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowcolor1Nearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowColor1Nearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("shadowColor1MinMagNearest");
        llllllllllllllllIIlIlIlIIIIlllIl.add("wetnessHalflife");
        llllllllllllllllIIlIlIlIIIIlllIl.add("drynessHalflife");
        llllllllllllllllIIlIlIlIIIIlllIl.add("eyeBrightnessHalflife");
        llllllllllllllllIIlIlIlIIIIlllIl.add("centerDepthHalflife");
        llllllllllllllllIIlIlIlIIIIlllIl.add("sunPathRotation");
        llllllllllllllllIIlIlIlIIIIlllIl.add("ambientOcclusionLevel");
        llllllllllllllllIIlIlIlIIIIlllIl.add("superSamplingLevel");
        llllllllllllllllIIlIlIlIIIIlllIl.add("noiseTextureResolution");
        return (Set<String>)llllllllllllllllIIlIlIlIIIIlllIl;
    }
    
    public static Map<String, ShaderOption[]> parseGuiScreens(final Properties llllllllllllllllIIlIlIIllIlllllI, final ShaderProfile[] llllllllllllllllIIlIlIIlllIIIIIl, final ShaderOption[] llllllllllllllllIIlIlIIlllIIIIII) {
        final HashMap llllllllllllllllIIlIlIIllIllllll = new HashMap();
        parseGuiScreen("screen", llllllllllllllllIIlIlIIllIlllllI, llllllllllllllllIIlIlIIllIllllll, llllllllllllllllIIlIlIIlllIIIIIl, llllllllllllllllIIlIlIIlllIIIIII);
        return (Map<String, ShaderOption[]>)(llllllllllllllllIIlIlIIllIllllll.isEmpty() ? null : llllllllllllllllIIlIlIIllIllllll);
    }
    
    public static ShaderProfile[] parseProfiles(final Properties llllllllllllllllIIlIlIlIIIIlIIIl, final ShaderOption[] llllllllllllllllIIlIlIlIIIIIIlIl) {
        final String llllllllllllllllIIlIlIlIIIIIllll = "profile.";
        final ArrayList llllllllllllllllIIlIlIlIIIIIlllI = new ArrayList();
        final Set llllllllllllllllIIlIlIlIIIIIllIl = llllllllllllllllIIlIlIlIIIIlIIIl.keySet();
        for (final String llllllllllllllllIIlIlIlIIIIIlIll : llllllllllllllllIIlIlIlIIIIIllIl) {
            if (llllllllllllllllIIlIlIlIIIIIlIll.startsWith(llllllllllllllllIIlIlIlIIIIIllll)) {
                final String llllllllllllllllIIlIlIlIIIIIlIlI = llllllllllllllllIIlIlIlIIIIIlIll.substring(llllllllllllllllIIlIlIlIIIIIllll.length());
                llllllllllllllllIIlIlIlIIIIlIIIl.getProperty(llllllllllllllllIIlIlIlIIIIIlIll);
                final HashSet llllllllllllllllIIlIlIlIIIIIlIIl = new HashSet();
                final ShaderProfile llllllllllllllllIIlIlIlIIIIIlIII = parseProfile(llllllllllllllllIIlIlIlIIIIIlIlI, llllllllllllllllIIlIlIlIIIIlIIIl, llllllllllllllllIIlIlIlIIIIIlIIl, llllllllllllllllIIlIlIlIIIIIIlIl);
                if (llllllllllllllllIIlIlIlIIIIIlIII == null) {
                    continue;
                }
                llllllllllllllllIIlIlIlIIIIIlllI.add(llllllllllllllllIIlIlIlIIIIIlIII);
            }
        }
        if (llllllllllllllllIIlIlIlIIIIIlllI.size() <= 0) {
            return null;
        }
        final ShaderProfile[] llllllllllllllllIIlIlIlIIIIIIlll = llllllllllllllllIIlIlIlIIIIIlllI.toArray(new ShaderProfile[llllllllllllllllIIlIlIlIIIIIlllI.size()]);
        return llllllllllllllllIIlIlIlIIIIIIlll;
    }
}
