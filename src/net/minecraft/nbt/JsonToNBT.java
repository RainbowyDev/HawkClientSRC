package net.minecraft.nbt;

import java.util.regex.*;
import org.apache.logging.log4j.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;

public class JsonToNBT
{
    private static final /* synthetic */ Pattern field_179273_b;
    
    private static String func_150314_a(final String lllllllllllllllIlIIIlIIllIIIIlll, final boolean lllllllllllllllIlIIIlIIllIIIIIlI) throws NBTException {
        int lllllllllllllllIlIIIlIIllIIIIlIl = func_150312_a(lllllllllllllllIlIIIlIIllIIIIlll, ':');
        final int lllllllllllllllIlIIIlIIllIIIIlII = func_150312_a(lllllllllllllllIlIIIlIIllIIIIlll, ',');
        if (lllllllllllllllIlIIIlIIllIIIIIlI) {
            if (lllllllllllllllIlIIIlIIllIIIIlIl == -1) {
                throw new NBTException(String.valueOf(new StringBuilder("Unable to locate name/value separator for string: ").append(lllllllllllllllIlIIIlIIllIIIIlll)));
            }
            if (lllllllllllllllIlIIIlIIllIIIIlII != -1 && lllllllllllllllIlIIIlIIllIIIIlII < lllllllllllllllIlIIIlIIllIIIIlIl) {
                throw new NBTException(String.valueOf(new StringBuilder("Name error at: ").append(lllllllllllllllIlIIIlIIllIIIIlll)));
            }
        }
        else if (lllllllllllllllIlIIIlIIllIIIIlIl == -1 || lllllllllllllllIlIIIlIIllIIIIlIl > lllllllllllllllIlIIIlIIllIIIIlII) {
            lllllllllllllllIlIIIlIIllIIIIlIl = -1;
        }
        return func_179269_a(lllllllllllllllIlIIIlIIllIIIIlll, lllllllllllllllIlIIIlIIllIIIIlIl);
    }
    
    private static int func_150312_a(final String lllllllllllllllIlIIIlIIlIlIIlIII, final char lllllllllllllllIlIIIlIIlIlIIIlll) {
        int lllllllllllllllIlIIIlIIlIlIIlIll = 0;
        boolean lllllllllllllllIlIIIlIIlIlIIlIlI = true;
        while (lllllllllllllllIlIIIlIIlIlIIlIll < lllllllllllllllIlIIIlIIlIlIIlIII.length()) {
            final char lllllllllllllllIlIIIlIIlIlIIlIIl = lllllllllllllllIlIIIlIIlIlIIlIII.charAt(lllllllllllllllIlIIIlIIlIlIIlIll);
            if (lllllllllllllllIlIIIlIIlIlIIlIIl == '\"') {
                if (!func_179271_b(lllllllllllllllIlIIIlIIlIlIIlIII, lllllllllllllllIlIIIlIIlIlIIlIll)) {
                    lllllllllllllllIlIIIlIIlIlIIlIlI = !lllllllllllllllIlIIIlIIlIlIIlIlI;
                }
            }
            else if (lllllllllllllllIlIIIlIIlIlIIlIlI) {
                if (lllllllllllllllIlIIIlIIlIlIIlIIl == lllllllllllllllIlIIIlIIlIlIIIlll) {
                    return lllllllllllllllIlIIIlIIlIlIIlIll;
                }
                if (lllllllllllllllIlIIIlIIlIlIIlIIl == '{' || lllllllllllllllIlIIIlIIlIlIIlIIl == '[') {
                    return -1;
                }
            }
            ++lllllllllllllllIlIIIlIIlIlIIlIll;
        }
        return -1;
    }
    
    private static String func_179269_a(final String lllllllllllllllIlIIIlIIlIlllIllI, final int lllllllllllllllIlIIIlIIlIllIllII) throws NBTException {
        final Stack lllllllllllllllIlIIIlIIlIlllIlII = new Stack();
        int lllllllllllllllIlIIIlIIlIlllIIll = lllllllllllllllIlIIIlIIlIllIllII + 1;
        boolean lllllllllllllllIlIIIlIIlIlllIIlI = false;
        boolean lllllllllllllllIlIIIlIIlIlllIIIl = false;
        boolean lllllllllllllllIlIIIlIIlIlllIIII = false;
        int lllllllllllllllIlIIIlIIlIllIllll = 0;
        while (lllllllllllllllIlIIIlIIlIlllIIll < lllllllllllllllIlIIIlIIlIlllIllI.length()) {
            final char lllllllllllllllIlIIIlIIlIllIlllI = lllllllllllllllIlIIIlIIlIlllIllI.charAt(lllllllllllllllIlIIIlIIlIlllIIll);
            if (lllllllllllllllIlIIIlIIlIllIlllI == '\"') {
                if (func_179271_b(lllllllllllllllIlIIIlIIlIlllIllI, lllllllllllllllIlIIIlIIlIlllIIll)) {
                    if (!lllllllllllllllIlIIIlIIlIlllIIlI) {
                        throw new NBTException(String.valueOf(new StringBuilder("Illegal use of \\\": ").append(lllllllllllllllIlIIIlIIlIlllIllI)));
                    }
                }
                else {
                    lllllllllllllllIlIIIlIIlIlllIIlI = !lllllllllllllllIlIIIlIIlIlllIIlI;
                    if (lllllllllllllllIlIIIlIIlIlllIIlI && !lllllllllllllllIlIIIlIIlIlllIIII) {
                        lllllllllllllllIlIIIlIIlIlllIIIl = true;
                    }
                    if (!lllllllllllllllIlIIIlIIlIlllIIlI) {
                        lllllllllllllllIlIIIlIIlIllIllll = lllllllllllllllIlIIIlIIlIlllIIll;
                    }
                }
            }
            else if (!lllllllllllllllIlIIIlIIlIlllIIlI) {
                if (lllllllllllllllIlIIIlIIlIllIlllI != '{' && lllllllllllllllIlIIIlIIlIllIlllI != '[') {
                    if (lllllllllllllllIlIIIlIIlIllIlllI == '}' && (lllllllllllllllIlIIIlIIlIlllIlII.isEmpty() || lllllllllllllllIlIIIlIIlIlllIlII.pop() != '{')) {
                        throw new NBTException(String.valueOf(new StringBuilder("Unbalanced curly brackets {}: ").append(lllllllllllllllIlIIIlIIlIlllIllI)));
                    }
                    if (lllllllllllllllIlIIIlIIlIllIlllI == ']' && (lllllllllllllllIlIIIlIIlIlllIlII.isEmpty() || lllllllllllllllIlIIIlIIlIlllIlII.pop() != '[')) {
                        throw new NBTException(String.valueOf(new StringBuilder("Unbalanced square brackets []: ").append(lllllllllllllllIlIIIlIIlIlllIllI)));
                    }
                    if (lllllllllllllllIlIIIlIIlIllIlllI == ',' && lllllllllllllllIlIIIlIIlIlllIlII.isEmpty()) {
                        return lllllllllllllllIlIIIlIIlIlllIllI.substring(0, lllllllllllllllIlIIIlIIlIlllIIll);
                    }
                }
                else {
                    lllllllllllllllIlIIIlIIlIlllIlII.push(lllllllllllllllIlIIIlIIlIllIlllI);
                }
            }
            if (!Character.isWhitespace(lllllllllllllllIlIIIlIIlIllIlllI)) {
                if (!lllllllllllllllIlIIIlIIlIlllIIlI && lllllllllllllllIlIIIlIIlIlllIIIl && lllllllllllllllIlIIIlIIlIllIllll != lllllllllllllllIlIIIlIIlIlllIIll) {
                    return lllllllllllllllIlIIIlIIlIlllIllI.substring(0, lllllllllllllllIlIIIlIIlIllIllll + 1);
                }
                lllllllllllllllIlIIIlIIlIlllIIII = true;
            }
            ++lllllllllllllllIlIIIlIIlIlllIIll;
        }
        return lllllllllllllllIlIIIlIIlIlllIllI.substring(0, lllllllllllllllIlIIIlIIlIlllIIll);
    }
    
    static {
        __OBFID = "CL_00001232";
        logger = LogManager.getLogger();
        field_179273_b = Pattern.compile("\\[[-+\\d|,\\s]+\\]");
    }
    
    static Any func_150316_a(final String lllllllllllllllIlIIIlIIllIlIIlll, String lllllllllllllllIlIIIlIIllIIlllII) throws NBTException {
        lllllllllllllllIlIIIlIIllIIlllII = lllllllllllllllIlIIIlIIllIIlllII.trim();
        if (lllllllllllllllIlIIIlIIllIIlllII.startsWith("{")) {
            lllllllllllllllIlIIIlIIllIIlllII = lllllllllllllllIlIIIlIIllIIlllII.substring(1, lllllllllllllllIlIIIlIIllIIlllII.length() - 1);
            final Compound lllllllllllllllIlIIIlIIllIIlllll = new Compound(lllllllllllllllIlIIIlIIllIlIIlll);
            while (lllllllllllllllIlIIIlIIllIIlllII.length() > 0) {
                final String lllllllllllllllIlIIIlIIllIlIIlIl = func_150314_a(lllllllllllllllIlIIIlIIllIIlllII, true);
                if (lllllllllllllllIlIIIlIIllIlIIlIl.length() > 0) {
                    final boolean lllllllllllllllIlIIIlIIllIlIIIll = false;
                    lllllllllllllllIlIIIlIIllIIlllll.field_150491_b.add(func_179270_a(lllllllllllllllIlIIIlIIllIlIIlIl, lllllllllllllllIlIIIlIIllIlIIIll));
                }
                if (lllllllllllllllIlIIIlIIllIIlllII.length() < lllllllllllllllIlIIIlIIllIlIIlIl.length() + 1) {
                    break;
                }
                final char lllllllllllllllIlIIIlIIllIlIIIIl = lllllllllllllllIlIIIlIIllIIlllII.charAt(lllllllllllllllIlIIIlIIllIlIIlIl.length());
                if (lllllllllllllllIlIIIlIIllIlIIIIl != ',' && lllllllllllllllIlIIIlIIllIlIIIIl != '{' && lllllllllllllllIlIIIlIIllIlIIIIl != '}' && lllllllllllllllIlIIIlIIllIlIIIIl != '[' && lllllllllllllllIlIIIlIIllIlIIIIl != ']') {
                    throw new NBTException(String.valueOf(new StringBuilder("Unexpected token '").append(lllllllllllllllIlIIIlIIllIlIIIIl).append("' at: ").append(lllllllllllllllIlIIIlIIllIIlllII.substring(lllllllllllllllIlIIIlIIllIlIIlIl.length()))));
                }
                lllllllllllllllIlIIIlIIllIIlllII = lllllllllllllllIlIIIlIIllIIlllII.substring(lllllllllllllllIlIIIlIIllIlIIlIl.length() + 1);
            }
            return lllllllllllllllIlIIIlIIllIIlllll;
        }
        if (lllllllllllllllIlIIIlIIllIIlllII.startsWith("[") && !JsonToNBT.field_179273_b.matcher(lllllllllllllllIlIIIlIIllIIlllII).matches()) {
            lllllllllllllllIlIIIlIIllIIlllII = lllllllllllllllIlIIIlIIllIIlllII.substring(1, lllllllllllllllIlIIIlIIllIIlllII.length() - 1);
            final List lllllllllllllllIlIIIlIIllIIllllI = new List(lllllllllllllllIlIIIlIIllIlIIlll);
            while (lllllllllllllllIlIIIlIIllIIlllII.length() > 0) {
                final String lllllllllllllllIlIIIlIIllIlIIlII = func_150314_a(lllllllllllllllIlIIIlIIllIIlllII, false);
                if (lllllllllllllllIlIIIlIIllIlIIlII.length() > 0) {
                    final boolean lllllllllllllllIlIIIlIIllIlIIIlI = true;
                    lllllllllllllllIlIIIlIIllIIllllI.field_150492_b.add(func_179270_a(lllllllllllllllIlIIIlIIllIlIIlII, lllllllllllllllIlIIIlIIllIlIIIlI));
                }
                if (lllllllllllllllIlIIIlIIllIIlllII.length() < lllllllllllllllIlIIIlIIllIlIIlII.length() + 1) {
                    break;
                }
                final char lllllllllllllllIlIIIlIIllIlIIIII = lllllllllllllllIlIIIlIIllIIlllII.charAt(lllllllllllllllIlIIIlIIllIlIIlII.length());
                if (lllllllllllllllIlIIIlIIllIlIIIII != ',' && lllllllllllllllIlIIIlIIllIlIIIII != '{' && lllllllllllllllIlIIIlIIllIlIIIII != '}' && lllllllllllllllIlIIIlIIllIlIIIII != '[' && lllllllllllllllIlIIIlIIllIlIIIII != ']') {
                    throw new NBTException(String.valueOf(new StringBuilder("Unexpected token '").append(lllllllllllllllIlIIIlIIllIlIIIII).append("' at: ").append(lllllllllllllllIlIIIlIIllIIlllII.substring(lllllllllllllllIlIIIlIIllIlIIlII.length()))));
                }
                lllllllllllllllIlIIIlIIllIIlllII = lllllllllllllllIlIIIlIIllIIlllII.substring(lllllllllllllllIlIIIlIIllIlIIlII.length() + 1);
            }
            return lllllllllllllllIlIIIlIIllIIllllI;
        }
        return new Primitive(lllllllllllllllIlIIIlIIllIlIIlll, lllllllllllllllIlIIIlIIllIIlllII);
    }
    
    private static Any func_179270_a(final String lllllllllllllllIlIIIlIIllIIlIIll, final boolean lllllllllllllllIlIIIlIIllIIlIIlI) throws NBTException {
        final String lllllllllllllllIlIIIlIIllIIlIIIl = func_150313_b(lllllllllllllllIlIIIlIIllIIlIIll, lllllllllllllllIlIIIlIIllIIlIIlI);
        final String lllllllllllllllIlIIIlIIllIIlIIII = func_150311_c(lllllllllllllllIlIIIlIIllIIlIIll, lllllllllllllllIlIIIlIIllIIlIIlI);
        return func_179272_a(lllllllllllllllIlIIIlIIllIIlIIIl, lllllllllllllllIlIIIlIIllIIlIIII);
    }
    
    public static NBTTagCompound func_180713_a(String lllllllllllllllIlIIIlIIlllIIIIll) throws NBTException {
        lllllllllllllllIlIIIlIIlllIIIIll = lllllllllllllllIlIIIlIIlllIIIIll.trim();
        if (!lllllllllllllllIlIIIlIIlllIIIIll.startsWith("{")) {
            throw new NBTException("Invalid tag encountered, expected '{' as first char.");
        }
        if (func_150310_b(lllllllllllllllIlIIIlIIlllIIIIll) != 1) {
            throw new NBTException("Encountered multiple top tags, only one expected");
        }
        return (NBTTagCompound)func_150316_a("tag", lllllllllllllllIlIIIlIIlllIIIIll).func_150489_a();
    }
    
    static int func_150310_b(final String lllllllllllllllIlIIIlIIllIllllII) throws NBTException {
        int lllllllllllllllIlIIIlIIllIlllIll = 0;
        boolean lllllllllllllllIlIIIlIIllIlllIlI = false;
        final Stack lllllllllllllllIlIIIlIIllIlllIIl = new Stack();
        for (int lllllllllllllllIlIIIlIIllIlllIII = 0; lllllllllllllllIlIIIlIIllIlllIII < lllllllllllllllIlIIIlIIllIllllII.length(); ++lllllllllllllllIlIIIlIIllIlllIII) {
            final char lllllllllllllllIlIIIlIIllIllIlll = lllllllllllllllIlIIIlIIllIllllII.charAt(lllllllllllllllIlIIIlIIllIlllIII);
            if (lllllllllllllllIlIIIlIIllIllIlll == '\"') {
                if (func_179271_b(lllllllllllllllIlIIIlIIllIllllII, lllllllllllllllIlIIIlIIllIlllIII)) {
                    if (!lllllllllllllllIlIIIlIIllIlllIlI) {
                        throw new NBTException(String.valueOf(new StringBuilder("Illegal use of \\\": ").append(lllllllllllllllIlIIIlIIllIllllII)));
                    }
                }
                else {
                    lllllllllllllllIlIIIlIIllIlllIlI = !lllllllllllllllIlIIIlIIllIlllIlI;
                }
            }
            else if (!lllllllllllllllIlIIIlIIllIlllIlI) {
                if (lllllllllllllllIlIIIlIIllIllIlll != '{' && lllllllllllllllIlIIIlIIllIllIlll != '[') {
                    if (lllllllllllllllIlIIIlIIllIllIlll == '}' && (lllllllllllllllIlIIIlIIllIlllIIl.isEmpty() || lllllllllllllllIlIIIlIIllIlllIIl.pop() != '{')) {
                        throw new NBTException(String.valueOf(new StringBuilder("Unbalanced curly brackets {}: ").append(lllllllllllllllIlIIIlIIllIllllII)));
                    }
                    if (lllllllllllllllIlIIIlIIllIllIlll == ']' && (lllllllllllllllIlIIIlIIllIlllIIl.isEmpty() || lllllllllllllllIlIIIlIIllIlllIIl.pop() != '[')) {
                        throw new NBTException(String.valueOf(new StringBuilder("Unbalanced square brackets []: ").append(lllllllllllllllIlIIIlIIllIllllII)));
                    }
                }
                else {
                    if (lllllllllllllllIlIIIlIIllIlllIIl.isEmpty()) {
                        ++lllllllllllllllIlIIIlIIllIlllIll;
                    }
                    lllllllllllllllIlIIIlIIllIlllIIl.push(lllllllllllllllIlIIIlIIllIllIlll);
                }
            }
        }
        if (lllllllllllllllIlIIIlIIllIlllIlI) {
            throw new NBTException(String.valueOf(new StringBuilder("Unbalanced quotation: ").append(lllllllllllllllIlIIIlIIllIllllII)));
        }
        if (!lllllllllllllllIlIIIlIIllIlllIIl.isEmpty()) {
            throw new NBTException(String.valueOf(new StringBuilder("Unbalanced brackets: ").append(lllllllllllllllIlIIIlIIllIllllII)));
        }
        if (lllllllllllllllIlIIIlIIllIlllIll == 0 && !lllllllllllllllIlIIIlIIllIllllII.isEmpty()) {
            lllllllllllllllIlIIIlIIllIlllIll = 1;
        }
        return lllllllllllllllIlIIIlIIllIlllIll;
    }
    
    private static String func_150311_c(String lllllllllllllllIlIIIlIIlIlIlIlIl, final boolean lllllllllllllllIlIIIlIIlIlIlIlII) throws NBTException {
        if (lllllllllllllllIlIIIlIIlIlIlIlII) {
            lllllllllllllllIlIIIlIIlIlIlIlIl = lllllllllllllllIlIIIlIIlIlIlIlIl.trim();
            if (lllllllllllllllIlIIIlIIlIlIlIlIl.startsWith("{") || lllllllllllllllIlIIIlIIlIlIlIlIl.startsWith("[")) {
                return lllllllllllllllIlIIIlIIlIlIlIlIl;
            }
        }
        final int lllllllllllllllIlIIIlIIlIlIlIllI = func_150312_a(lllllllllllllllIlIIIlIIlIlIlIlIl, ':');
        if (lllllllllllllllIlIIIlIIlIlIlIllI != -1) {
            return lllllllllllllllIlIIIlIIlIlIlIlIl.substring(lllllllllllllllIlIIIlIIlIlIlIllI + 1).trim();
        }
        if (lllllllllllllllIlIIIlIIlIlIlIlII) {
            return lllllllllllllllIlIIIlIIlIlIlIlIl;
        }
        throw new NBTException(String.valueOf(new StringBuilder("Unable to locate name/value separator for string: ").append(lllllllllllllllIlIIIlIIlIlIlIlIl)));
    }
    
    static Any func_179272_a(final String... lllllllllllllllIlIIIlIIllIlIlllI) throws NBTException {
        return func_150316_a(lllllllllllllllIlIIIlIIllIlIlllI[0], lllllllllllllllIlIIIlIIllIlIlllI[1]);
    }
    
    private static String func_150313_b(String lllllllllllllllIlIIIlIIlIlIllllI, final boolean lllllllllllllllIlIIIlIIlIlIlllIl) throws NBTException {
        if (lllllllllllllllIlIIIlIIlIlIlllIl) {
            lllllllllllllllIlIIIlIIlIlIllllI = lllllllllllllllIlIIIlIIlIlIllllI.trim();
            if (lllllllllllllllIlIIIlIIlIlIllllI.startsWith("{") || lllllllllllllllIlIIIlIIlIlIllllI.startsWith("[")) {
                return "";
            }
        }
        final int lllllllllllllllIlIIIlIIlIlIlllll = func_150312_a(lllllllllllllllIlIIIlIIlIlIllllI, ':');
        if (lllllllllllllllIlIIIlIIlIlIlllll != -1) {
            return lllllllllllllllIlIIIlIIlIlIllllI.substring(0, lllllllllllllllIlIIIlIIlIlIlllll).trim();
        }
        if (lllllllllllllllIlIIIlIIlIlIlllIl) {
            return "";
        }
        throw new NBTException(String.valueOf(new StringBuilder("Unable to locate name/value separator for string: ").append(lllllllllllllllIlIIIlIIlIlIllllI)));
    }
    
    private static boolean func_179271_b(final String lllllllllllllllIlIIIlIIlIlIIIIIl, final int lllllllllllllllIlIIIlIIlIlIIIIII) {
        return lllllllllllllllIlIIIlIIlIlIIIIII > 0 && lllllllllllllllIlIIIlIIlIlIIIIIl.charAt(lllllllllllllllIlIIIlIIlIlIIIIII - 1) == '\\' && !func_179271_b(lllllllllllllllIlIIIlIIlIlIIIIIl, lllllllllllllllIlIIIlIIlIlIIIIII - 1);
    }
    
    static class Compound extends Any
    {
        protected /* synthetic */ java.util.List field_150491_b;
        
        static {
            __OBFID = "CL_00001234";
        }
        
        @Override
        public NBTBase func_150489_a() {
            final NBTTagCompound llllllllllllllIllIlIIIlllllIlIII = new NBTTagCompound();
            for (final Any llllllllllllllIllIlIIIlllllIIllI : this.field_150491_b) {
                llllllllllllllIllIlIIIlllllIlIII.setTag(llllllllllllllIllIlIIIlllllIIllI.field_150490_a, llllllllllllllIllIlIIIlllllIIllI.func_150489_a());
            }
            return llllllllllllllIllIlIIIlllllIlIII;
        }
        
        public Compound(final String llllllllllllllIllIlIIIlllllIlllI) {
            this.field_150491_b = Lists.newArrayList();
            this.field_150490_a = llllllllllllllIllIlIIIlllllIlllI;
        }
    }
    
    abstract static class Any
    {
        protected /* synthetic */ String field_150490_a;
        
        static {
            __OBFID = "CL_00001233";
        }
        
        public abstract NBTBase func_150489_a();
    }
    
    static class List extends Any
    {
        protected /* synthetic */ java.util.List field_150492_b;
        
        static {
            __OBFID = "CL_00001235";
        }
        
        public List(final String llllllllllllllIlIIlIIllllIlIIIlI) {
            this.field_150492_b = Lists.newArrayList();
            this.field_150490_a = llllllllllllllIlIIlIIllllIlIIIlI;
        }
        
        @Override
        public NBTBase func_150489_a() {
            final NBTTagList llllllllllllllIlIIlIIllllIIlllII = new NBTTagList();
            for (final Any llllllllllllllIlIIlIIllllIIllIlI : this.field_150492_b) {
                llllllllllllllIlIIlIIllllIIlllII.appendTag(llllllllllllllIlIIlIIllllIIllIlI.func_150489_a());
            }
            return llllllllllllllIlIIlIIllllIIlllII;
        }
    }
    
    static class Primitive extends Any
    {
        private static final /* synthetic */ Pattern field_179262_g;
        private static final /* synthetic */ Pattern field_179265_c;
        private static final /* synthetic */ Pattern field_179268_i;
        private static final /* synthetic */ Pattern field_179264_e;
        private static final /* synthetic */ Splitter field_179266_j;
        private static final /* synthetic */ Pattern field_179261_f;
        private static final /* synthetic */ Pattern field_179267_h;
        private static final /* synthetic */ Pattern field_179263_d;
        protected /* synthetic */ String field_150493_b;
        
        public Primitive(final String lllIlllIllIIIl, final String lllIlllIllIIII) {
            this.field_150490_a = lllIlllIllIIIl;
            this.field_150493_b = lllIlllIllIIII;
        }
        
        static {
            __OBFID = "CL_00001236";
            field_179265_c = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[d|D]");
            field_179263_d = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[f|F]");
            field_179264_e = Pattern.compile("[-+]?[0-9]+[b|B]");
            field_179261_f = Pattern.compile("[-+]?[0-9]+[l|L]");
            field_179262_g = Pattern.compile("[-+]?[0-9]+[s|S]");
            field_179267_h = Pattern.compile("[-+]?[0-9]+");
            field_179268_i = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
            field_179266_j = Splitter.on(',').omitEmptyStrings();
        }
        
        @Override
        public NBTBase func_150489_a() {
            try {
                if (Primitive.field_179265_c.matcher(this.field_150493_b).matches()) {
                    return new NBTTagDouble(Double.parseDouble(this.field_150493_b.substring(0, this.field_150493_b.length() - 1)));
                }
                if (Primitive.field_179263_d.matcher(this.field_150493_b).matches()) {
                    return new NBTTagFloat(Float.parseFloat(this.field_150493_b.substring(0, this.field_150493_b.length() - 1)));
                }
                if (Primitive.field_179264_e.matcher(this.field_150493_b).matches()) {
                    return new NBTTagByte(Byte.parseByte(this.field_150493_b.substring(0, this.field_150493_b.length() - 1)));
                }
                if (Primitive.field_179261_f.matcher(this.field_150493_b).matches()) {
                    return new NBTTagLong(Long.parseLong(this.field_150493_b.substring(0, this.field_150493_b.length() - 1)));
                }
                if (Primitive.field_179262_g.matcher(this.field_150493_b).matches()) {
                    return new NBTTagShort(Short.parseShort(this.field_150493_b.substring(0, this.field_150493_b.length() - 1)));
                }
                if (Primitive.field_179267_h.matcher(this.field_150493_b).matches()) {
                    return new NBTTagInt(Integer.parseInt(this.field_150493_b));
                }
                if (Primitive.field_179268_i.matcher(this.field_150493_b).matches()) {
                    return new NBTTagDouble(Double.parseDouble(this.field_150493_b));
                }
                if (this.field_150493_b.equalsIgnoreCase("true") || this.field_150493_b.equalsIgnoreCase("false")) {
                    return new NBTTagByte((byte)(Boolean.parseBoolean(this.field_150493_b) ? 1 : 0));
                }
            }
            catch (NumberFormatException lllIlllIlIlIIl) {
                this.field_150493_b = this.field_150493_b.replaceAll("\\\\\"", "\"");
                return new NBTTagString(this.field_150493_b);
            }
            if (this.field_150493_b.startsWith("[") && this.field_150493_b.endsWith("]")) {
                final String lllIlllIlIlIII = this.field_150493_b.substring(1, this.field_150493_b.length() - 1);
                final String[] lllIlllIlIIlll = (String[])Iterables.toArray(Primitive.field_179266_j.split((CharSequence)lllIlllIlIlIII), (Class)String.class);
                try {
                    final int[] lllIlllIlIIllI = new int[lllIlllIlIIlll.length];
                    for (int lllIlllIlIIlIl = 0; lllIlllIlIIlIl < lllIlllIlIIlll.length; ++lllIlllIlIIlIl) {
                        lllIlllIlIIllI[lllIlllIlIIlIl] = Integer.parseInt(lllIlllIlIIlll[lllIlllIlIIlIl].trim());
                    }
                    return new NBTTagIntArray(lllIlllIlIIllI);
                }
                catch (NumberFormatException lllIlllIlIIlII) {
                    return new NBTTagString(this.field_150493_b);
                }
            }
            if (this.field_150493_b.startsWith("\"") && this.field_150493_b.endsWith("\"")) {
                this.field_150493_b = this.field_150493_b.substring(1, this.field_150493_b.length() - 1);
            }
            this.field_150493_b = this.field_150493_b.replaceAll("\\\\\"", "\"");
            final StringBuilder lllIlllIlIIIll = new StringBuilder();
            for (int lllIlllIlIIIlI = 0; lllIlllIlIIIlI < this.field_150493_b.length(); ++lllIlllIlIIIlI) {
                if (lllIlllIlIIIlI < this.field_150493_b.length() - 1 && this.field_150493_b.charAt(lllIlllIlIIIlI) == '\\' && this.field_150493_b.charAt(lllIlllIlIIIlI + 1) == '\\') {
                    lllIlllIlIIIll.append('\\');
                    ++lllIlllIlIIIlI;
                }
                else {
                    lllIlllIlIIIll.append(this.field_150493_b.charAt(lllIlllIlIIIlI));
                }
            }
            return new NBTTagString(String.valueOf(lllIlllIlIIIll));
        }
    }
}
