package optifine;

import java.util.*;

public class StrUtils
{
    public static String removePrefixSuffix(final String llllllllllllllIlIIIIllllIlllIlIl, final String llllllllllllllIlIIIIllllIlllIlll, final String llllllllllllllIlIIIIllllIlllIIll) {
        return removePrefixSuffix(llllllllllllllIlIIIIllllIlllIlIl, new String[] { llllllllllllllIlIIIIllllIlllIlll }, new String[] { llllllllllllllIlIIIIllllIlllIIll });
    }
    
    public static boolean isEmpty(final String llllllllllllllIlIIIlIIIIIIlllIII) {
        return llllllllllllllIlIIIlIIIIIIlllIII == null || llllllllllllllIlIIIlIIIIIIlllIII.trim().length() <= 0;
    }
    
    public static int parseInt(final String llllllllllllllIlIIIlIIIIIIlIIlll, final int llllllllllllllIlIIIlIIIIIIlIIllI) {
        if (llllllllllllllIlIIIlIIIIIIlIIlll == null) {
            return llllllllllllllIlIIIlIIIIIIlIIllI;
        }
        try {
            return Integer.parseInt(llllllllllllllIlIIIlIIIIIIlIIlll);
        }
        catch (NumberFormatException llllllllllllllIlIIIlIIIIIIlIlIII) {
            return llllllllllllllIlIIIlIIIIIIlIIllI;
        }
    }
    
    public static String addIfNotContains(String llllllllllllllIlIIIlIIIIIIIllIll, final String llllllllllllllIlIIIlIIIIIIIlllIl) {
        for (int llllllllllllllIlIIIlIIIIIIIlllII = 0; llllllllllllllIlIIIlIIIIIIIlllII < llllllllllllllIlIIIlIIIIIIIlllIl.length(); ++llllllllllllllIlIIIlIIIIIIIlllII) {
            if (llllllllllllllIlIIIlIIIIIIIllIll.indexOf(llllllllllllllIlIIIlIIIIIIIlllIl.charAt(llllllllllllllIlIIIlIIIIIIIlllII)) < 0) {
                llllllllllllllIlIIIlIIIIIIIllIll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIIlIIIIIIIllIll)).append(llllllllllllllIlIIIlIIIIIIIlllIl.charAt(llllllllllllllIlIIIlIIIIIIIlllII)));
            }
        }
        return llllllllllllllIlIIIlIIIIIIIllIll;
    }
    
    private static boolean equalsMaskSingle(final String llllllllllllllIlIIIlIIIIllIIIIIl, final String llllllllllllllIlIIIlIIIIlIlllIll, final char llllllllllllllIlIIIlIIIIlIlllIlI) {
        if (llllllllllllllIlIIIlIIIIllIIIIIl == null || llllllllllllllIlIIIlIIIIlIlllIll == null) {
            return llllllllllllllIlIIIlIIIIllIIIIIl == llllllllllllllIlIIIlIIIIlIlllIll;
        }
        if (llllllllllllllIlIIIlIIIIllIIIIIl.length() != llllllllllllllIlIIIlIIIIlIlllIll.length()) {
            return false;
        }
        for (int llllllllllllllIlIIIlIIIIlIlllllI = 0; llllllllllllllIlIIIlIIIIlIlllllI < llllllllllllllIlIIIlIIIIlIlllIll.length(); ++llllllllllllllIlIIIlIIIIlIlllllI) {
            final char llllllllllllllIlIIIlIIIIlIllllIl = llllllllllllllIlIIIlIIIIlIlllIll.charAt(llllllllllllllIlIIIlIIIIlIlllllI);
            if (llllllllllllllIlIIIlIIIIlIllllIl != llllllllllllllIlIIIlIIIIlIlllIlI && llllllllllllllIlIIIlIIIIllIIIIIl.charAt(llllllllllllllIlIIIlIIIIlIlllllI) != llllllllllllllIlIIIlIIIIlIllllIl) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean equalsMask(final String llllllllllllllIlIIIlIIIIlIIIlIII, final String[] llllllllllllllIlIIIlIIIIlIIIIIlI, final char llllllllllllllIlIIIlIIIIlIIIIIIl) {
        for (int llllllllllllllIlIIIlIIIIlIIIIlIl = 0; llllllllllllllIlIIIlIIIIlIIIIlIl < llllllllllllllIlIIIlIIIIlIIIIIlI.length; ++llllllllllllllIlIIIlIIIIlIIIIlIl) {
            final String llllllllllllllIlIIIlIIIIlIIIIlII = llllllllllllllIlIIIlIIIIlIIIIIlI[llllllllllllllIlIIIlIIIIlIIIIlIl];
            if (equalsMask(llllllllllllllIlIIIlIIIIlIIIlIII, llllllllllllllIlIIIlIIIIlIIIIlII, llllllllllllllIlIIIlIIIIlIIIIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean equalsTrim(String llllllllllllllIlIIIlIIIIIIlllIll, String llllllllllllllIlIIIlIIIIIIlllIlI) {
        if (llllllllllllllIlIIIlIIIIIIlllIll != null) {
            llllllllllllllIlIIIlIIIIIIlllIll = llllllllllllllIlIIIlIIIIIIlllIll.trim();
        }
        if (llllllllllllllIlIIIlIIIIIIlllIlI != null) {
            llllllllllllllIlIIIlIIIIIIlllIlI = ((String)llllllllllllllIlIIIlIIIIIIlllIlI).trim();
        }
        return equals(llllllllllllllIlIIIlIIIIIIlllIll, llllllllllllllIlIIIlIIIIIIlllIlI);
    }
    
    public static boolean startsWith(final String llllllllllllllIlIIIIllllllllIIlI, final String[] llllllllllllllIlIIIIllllllllIlIl) {
        if (llllllllllllllIlIIIIllllllllIIlI == null) {
            return false;
        }
        if (llllllllllllllIlIIIIllllllllIlIl == null) {
            return false;
        }
        for (int llllllllllllllIlIIIIllllllllIlII = 0; llllllllllllllIlIIIIllllllllIlII < llllllllllllllIlIIIIllllllllIlIl.length; ++llllllllllllllIlIIIIllllllllIlII) {
            final String llllllllllllllIlIIIIllllllllIIll = llllllllllllllIlIIIIllllllllIlIl[llllllllllllllIlIIIIllllllllIlII];
            if (llllllllllllllIlIIIIllllllllIIlI.startsWith(llllllllllllllIlIIIIllllllllIIll)) {
                return true;
            }
        }
        return false;
    }
    
    public static int findPrefix(final String[] llllllllllllllIlIIIIllllllIIlIIl, final String llllllllllllllIlIIIIllllllIIIlII) {
        if (llllllllllllllIlIIIIllllllIIlIIl != null && llllllllllllllIlIIIIllllllIIIlII != null) {
            for (int llllllllllllllIlIIIIllllllIIIlll = 0; llllllllllllllIlIIIIllllllIIIlll < llllllllllllllIlIIIIllllllIIlIIl.length; ++llllllllllllllIlIIIIllllllIIIlll) {
                final String llllllllllllllIlIIIIllllllIIIllI = llllllllllllllIlIIIIllllllIIlIIl[llllllllllllllIlIIIIllllllIIIlll];
                if (llllllllllllllIlIIIIllllllIIIllI.startsWith(llllllllllllllIlIIIIllllllIIIlII)) {
                    return llllllllllllllIlIIIIllllllIIIlll;
                }
            }
            return -1;
        }
        return -1;
    }
    
    public static String removePrefix(String llllllllllllllIlIIIIlllllIIIlIIl, final String[] llllllllllllllIlIIIIlllllIIIllIl) {
        if (llllllllllllllIlIIIIlllllIIIlIIl != null && llllllllllllllIlIIIIlllllIIIllIl != null) {
            final int llllllllllllllIlIIIIlllllIIIllII = ((String)llllllllllllllIlIIIIlllllIIIlIIl).length();
            for (int llllllllllllllIlIIIIlllllIIIlIll = 0; llllllllllllllIlIIIIlllllIIIlIll < llllllllllllllIlIIIIlllllIIIllIl.length; ++llllllllllllllIlIIIIlllllIIIlIll) {
                final String llllllllllllllIlIIIIlllllIIIlIlI = llllllllllllllIlIIIIlllllIIIllIl[llllllllllllllIlIIIIlllllIIIlIll];
                llllllllllllllIlIIIIlllllIIIlIIl = removePrefix((String)llllllllllllllIlIIIIlllllIIIlIIl, llllllllllllllIlIIIIlllllIIIlIlI);
                if (((String)llllllllllllllIlIIIIlllllIIIlIIl).length() != llllllllllllllIlIIIIlllllIIIllII) {
                    break;
                }
            }
            return (String)llllllllllllllIlIIIIlllllIIIlIIl;
        }
        return (String)llllllllllllllIlIIIIlllllIIIlIIl;
    }
    
    private static int indexOfMaskSingle(final String llllllllllllllIlIIIlIIIIlIlIlIll, final String llllllllllllllIlIIIlIIIIlIllIIII, final int llllllllllllllIlIIIlIIIIlIlIlIIl, final char llllllllllllllIlIIIlIIIIlIlIlIII) {
        if (llllllllllllllIlIIIlIIIIlIlIlIll == null || llllllllllllllIlIIIlIIIIlIllIIII == null) {
            return -1;
        }
        if (llllllllllllllIlIIIlIIIIlIlIlIIl < 0 || llllllllllllllIlIIIlIIIIlIlIlIIl > llllllllllllllIlIIIlIIIIlIlIlIll.length()) {
            return -1;
        }
        if (llllllllllllllIlIIIlIIIIlIlIlIll.length() < llllllllllllllIlIIIlIIIIlIlIlIIl + llllllllllllllIlIIIlIIIIlIllIIII.length()) {
            return -1;
        }
        for (int llllllllllllllIlIIIlIIIIlIlIllIl = llllllllllllllIlIIIlIIIIlIlIlIIl; llllllllllllllIlIIIlIIIIlIlIllIl + llllllllllllllIlIIIlIIIIlIllIIII.length() <= llllllllllllllIlIIIlIIIIlIlIlIll.length(); ++llllllllllllllIlIIIlIIIIlIlIllIl) {
            final String llllllllllllllIlIIIlIIIIlIlIllII = llllllllllllllIlIIIlIIIIlIlIlIll.substring(llllllllllllllIlIIIlIIIIlIlIllIl, llllllllllllllIlIIIlIIIIlIlIllIl + llllllllllllllIlIIIlIIIIlIllIIII.length());
            if (equalsMaskSingle(llllllllllllllIlIIIlIIIIlIlIllII, llllllllllllllIlIIIlIIIIlIllIIII, llllllllllllllIlIIIlIIIIlIlIlIII)) {
                return llllllllllllllIlIIIlIIIIlIlIllIl;
            }
        }
        return -1;
    }
    
    public static boolean isFilled(final String llllllllllllllIlIIIlIIIIIIlIIIlI) {
        return !isEmpty(llllllllllllllIlIIIlIIIIIIlIIIlI);
    }
    
    public static String replaceSuffix(String llllllllllllllIlIIIIllllllIlIIll, final String llllllllllllllIlIIIIllllllIlIIlI, String llllllllllllllIlIIIIllllllIIlllI) {
        if (llllllllllllllIlIIIIllllllIlIIll != null && llllllllllllllIlIIIIllllllIlIIlI != null) {
            if (llllllllllllllIlIIIIllllllIIlllI == null) {
                llllllllllllllIlIIIIllllllIIlllI = "";
            }
            if (llllllllllllllIlIIIIllllllIlIIll.endsWith(llllllllllllllIlIIIIllllllIlIIlI)) {
                llllllllllllllIlIIIIllllllIlIIll = llllllllllllllIlIIIIllllllIlIIll.substring(0, llllllllllllllIlIIIIllllllIlIIll.length() - llllllllllllllIlIIIIllllllIlIIlI.length());
            }
            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIIIllllllIlIIll)).append((String)llllllllllllllIlIIIIllllllIIlllI));
        }
        return llllllllllllllIlIIIIllllllIlIIll;
    }
    
    public static String fillRight(String llllllllllllllIlIIIlIIIIIIIIIlII, final int llllllllllllllIlIIIlIIIIIIIIIlll, final char llllllllllllllIlIIIlIIIIIIIIIIlI) {
        if (llllllllllllllIlIIIlIIIIIIIIIlII == null) {
            llllllllllllllIlIIIlIIIIIIIIIlII = "";
        }
        if (((String)llllllllllllllIlIIIlIIIIIIIIIlII).length() >= llllllllllllllIlIIIlIIIIIIIIIlll) {
            return (String)llllllllllllllIlIIIlIIIIIIIIIlII;
        }
        final StringBuffer llllllllllllllIlIIIlIIIIIIIIIlIl = new StringBuffer((String)llllllllllllllIlIIIlIIIIIIIIIlII);
        while (llllllllllllllIlIIIlIIIIIIIIIlIl.length() < llllllllllllllIlIIIlIIIIIIIIIlll) {
            llllllllllllllIlIIIlIIIIIIIIIlIl.append(llllllllllllllIlIIIlIIIIIIIIIIlI);
        }
        return llllllllllllllIlIIIlIIIIIIIIIlIl.toString();
    }
    
    public static String stringInc(final String llllllllllllllIlIIIlIIIIIIllIIll) {
        int llllllllllllllIlIIIlIIIIIIllIIlI = parseInt(llllllllllllllIlIIIlIIIIIIllIIll, -1);
        if (llllllllllllllIlIIIlIIIIIIllIIlI == -1) {
            return "";
        }
        ++llllllllllllllIlIIIlIIIIIIllIIlI;
        final String llllllllllllllIlIIIlIIIIIIllIIIl = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIlIIIIIIllIIlI));
        return (llllllllllllllIlIIIlIIIIIIllIIIl.length() > llllllllllllllIlIIIlIIIIIIllIIll.length()) ? "" : fillLeft(String.valueOf(new StringBuilder().append(llllllllllllllIlIIIlIIIIIIllIIlI)), llllllllllllllIlIIIlIIIIIIllIIll.length(), '0');
    }
    
    public static boolean equals(final Object llllllllllllllIlIIIIllllllllllII, final Object llllllllllllllIlIIIIllllllllllIl) {
        return llllllllllllllIlIIIIllllllllllII == llllllllllllllIlIIIIllllllllllIl || (llllllllllllllIlIIIIllllllllllII != null && llllllllllllllIlIIIIllllllllllII.equals(llllllllllllllIlIIIIllllllllllIl)) || (llllllllllllllIlIIIIllllllllllIl != null && llllllllllllllIlIIIIllllllllllIl.equals(llllllllllllllIlIIIIllllllllllII));
    }
    
    private static boolean equals(final char llllllllllllllIlIIIlIIIIIlIIIlIl, final String llllllllllllllIlIIIlIIIIIlIIIIIl) {
        for (int llllllllllllllIlIIIlIIIIIlIIIIll = 0; llllllllllllllIlIIIlIIIIIlIIIIll < llllllllllllllIlIIIlIIIIIlIIIIIl.length(); ++llllllllllllllIlIIIlIIIIIlIIIIll) {
            if (llllllllllllllIlIIIlIIIIIlIIIIIl.charAt(llllllllllllllIlIIIlIIIIIlIIIIll) == llllllllllllllIlIIIlIIIIIlIIIlIl) {
                return true;
            }
        }
        return false;
    }
    
    public static String removePrefix(String llllllllllllllIlIIIIllllllIllllI, final String llllllllllllllIlIIIIllllllIlllll) {
        if (llllllllllllllIlIIIIllllllIllllI != null && llllllllllllllIlIIIIllllllIlllll != null) {
            if (llllllllllllllIlIIIIllllllIllllI.startsWith(llllllllllllllIlIIIIllllllIlllll)) {
                llllllllllllllIlIIIIllllllIllllI = llllllllllllllIlIIIIllllllIllllI.substring(llllllllllllllIlIIIIllllllIlllll.length());
            }
            return llllllllllllllIlIIIIllllllIllllI;
        }
        return llllllllllllllIlIIIIllllllIllllI;
    }
    
    public static boolean equalsMask(final String llllllllllllllIlIIIlIIIIllIlIIll, final String llllllllllllllIlIIIlIIIIllIlllll, final char llllllllllllllIlIIIlIIIIllIllllI, final char llllllllllllllIlIIIlIIIIllIlllIl) {
        if (llllllllllllllIlIIIlIIIIllIlllll == null || llllllllllllllIlIIIlIIIIllIlIIll == null) {
            return llllllllllllllIlIIIlIIIIllIlllll == llllllllllllllIlIIIlIIIIllIlIIll;
        }
        if (llllllllllllllIlIIIlIIIIllIlllll.indexOf(llllllllllllllIlIIIlIIIIllIllllI) < 0) {
            return (llllllllllllllIlIIIlIIIIllIlllll.indexOf(llllllllllllllIlIIIlIIIIllIlllIl) < 0) ? llllllllllllllIlIIIlIIIIllIlllll.equals(llllllllllllllIlIIIlIIIIllIlIIll) : equalsMaskSingle(llllllllllllllIlIIIlIIIIllIlIIll, llllllllllllllIlIIIlIIIIllIlllll, llllllllllllllIlIIIlIIIIllIlllIl);
        }
        final ArrayList llllllllllllllIlIIIlIIIIllIlllII = new ArrayList();
        final String llllllllllllllIlIIIlIIIIllIllIll = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIlIIIIllIllllI));
        if (llllllllllllllIlIIIlIIIIllIlllll.startsWith(llllllllllllllIlIIIlIIIIllIllIll)) {
            llllllllllllllIlIIIlIIIIllIlllII.add("");
        }
        final StringTokenizer llllllllllllllIlIIIlIIIIllIllIlI = new StringTokenizer(llllllllllllllIlIIIlIIIIllIlllll, llllllllllllllIlIIIlIIIIllIllIll);
        while (llllllllllllllIlIIIlIIIIllIllIlI.hasMoreElements()) {
            llllllllllllllIlIIIlIIIIllIlllII.add(llllllllllllllIlIIIlIIIIllIllIlI.nextToken());
        }
        if (llllllllllllllIlIIIlIIIIllIlllll.endsWith(llllllllllllllIlIIIlIIIIllIllIll)) {
            llllllllllllllIlIIIlIIIIllIlllII.add("");
        }
        final String llllllllllllllIlIIIlIIIIllIllIIl = llllllllllllllIlIIIlIIIIllIlllII.get(0);
        if (!startsWithMaskSingle(llllllllllllllIlIIIlIIIIllIlIIll, llllllllllllllIlIIIlIIIIllIllIIl, llllllllllllllIlIIIlIIIIllIlllIl)) {
            return false;
        }
        final String llllllllllllllIlIIIlIIIIllIllIII = llllllllllllllIlIIIlIIIIllIlllII.get(llllllllllllllIlIIIlIIIIllIlllII.size() - 1);
        if (!endsWithMaskSingle(llllllllllllllIlIIIlIIIIllIlIIll, llllllllllllllIlIIIlIIIIllIllIII, llllllllllllllIlIIIlIIIIllIlllIl)) {
            return false;
        }
        int llllllllllllllIlIIIlIIIIllIlIlll = 0;
        for (int llllllllllllllIlIIIlIIIIllIlIllI = 0; llllllllllllllIlIIIlIIIIllIlIllI < llllllllllllllIlIIIlIIIIllIlllII.size(); ++llllllllllllllIlIIIlIIIIllIlIllI) {
            final String llllllllllllllIlIIIlIIIIllIlIlIl = llllllllllllllIlIIIlIIIIllIlllII.get(llllllllllllllIlIIIlIIIIllIlIllI);
            if (llllllllllllllIlIIIlIIIIllIlIlIl.length() > 0) {
                final int llllllllllllllIlIIIlIIIIllIlIlII = indexOfMaskSingle(llllllllllllllIlIIIlIIIIllIlIIll, llllllllllllllIlIIIlIIIIllIlIlIl, llllllllllllllIlIIIlIIIIllIlIlll, llllllllllllllIlIIIlIIIIllIlllIl);
                if (llllllllllllllIlIIIlIIIIllIlIlII < 0) {
                    return false;
                }
                llllllllllllllIlIIIlIIIIllIlIlll = llllllllllllllIlIIIlIIIIllIlIlII + llllllllllllllIlIIIlIIIIllIlIlIl.length();
            }
        }
        return true;
    }
    
    public static int findSuffix(final String[] llllllllllllllIlIIIIlllllIllllIl, final String llllllllllllllIlIIIIlllllIlllIII) {
        if (llllllllllllllIlIIIIlllllIllllIl != null && llllllllllllllIlIIIIlllllIlllIII != null) {
            for (int llllllllllllllIlIIIIlllllIlllIll = 0; llllllllllllllIlIIIIlllllIlllIll < llllllllllllllIlIIIIlllllIllllIl.length; ++llllllllllllllIlIIIIlllllIlllIll) {
                final String llllllllllllllIlIIIIlllllIlllIlI = llllllllllllllIlIIIIlllllIllllIl[llllllllllllllIlIIIIlllllIlllIll];
                if (llllllllllllllIlIIIIlllllIlllIlI.endsWith(llllllllllllllIlIIIIlllllIlllIII)) {
                    return llllllllllllllIlIIIIlllllIlllIll;
                }
            }
            return -1;
        }
        return -1;
    }
    
    private static boolean startsWithMaskSingle(final String llllllllllllllIlIIIlIIIIlIIlIIIl, final String llllllllllllllIlIIIlIIIIlIIlIlII, final char llllllllllllllIlIIIlIIIIlIIIllll) {
        if (llllllllllllllIlIIIlIIIIlIIlIIIl == null || llllllllllllllIlIIIlIIIIlIIlIlII == null) {
            return llllllllllllllIlIIIlIIIIlIIlIIIl == llllllllllllllIlIIIlIIIIlIIlIlII;
        }
        if (llllllllllllllIlIIIlIIIIlIIlIIIl.length() < llllllllllllllIlIIIlIIIIlIIlIlII.length()) {
            return false;
        }
        final String llllllllllllllIlIIIlIIIIlIIlIIlI = llllllllllllllIlIIIlIIIIlIIlIIIl.substring(0, llllllllllllllIlIIIlIIIIlIIlIlII.length());
        return equalsMaskSingle(llllllllllllllIlIIIlIIIIlIIlIIlI, llllllllllllllIlIIIlIIIIlIIlIlII, llllllllllllllIlIIIlIIIIlIIIllll);
    }
    
    public static String fillLeft(String llllllllllllllIlIIIlIIIIIIIlIIII, final int llllllllllllllIlIIIlIIIIIIIlIIll, final char llllllllllllllIlIIIlIIIIIIIIlllI) {
        if (llllllllllllllIlIIIlIIIIIIIlIIII == null) {
            llllllllllllllIlIIIlIIIIIIIlIIII = "";
        }
        if (llllllllllllllIlIIIlIIIIIIIlIIII.length() >= llllllllllllllIlIIIlIIIIIIIlIIll) {
            return llllllllllllllIlIIIlIIIIIIIlIIII;
        }
        final StringBuffer llllllllllllllIlIIIlIIIIIIIlIIIl = new StringBuffer(llllllllllllllIlIIIlIIIIIIIlIIII);
        while (llllllllllllllIlIIIlIIIIIIIlIIIl.length() < llllllllllllllIlIIIlIIIIIIIlIIll) {
            llllllllllllllIlIIIlIIIIIIIlIIIl.insert(0, llllllllllllllIlIIIlIIIIIIIIlllI);
        }
        return llllllllllllllIlIIIlIIIIIIIlIIIl.toString();
    }
    
    public static boolean endsWith(final String llllllllllllllIlIIIIlllllllIlIlI, final String[] llllllllllllllIlIIIIlllllllIIlIl) {
        if (llllllllllllllIlIIIIlllllllIlIlI == null) {
            return false;
        }
        if (llllllllllllllIlIIIIlllllllIIlIl == null) {
            return false;
        }
        for (int llllllllllllllIlIIIIlllllllIlIII = 0; llllllllllllllIlIIIIlllllllIlIII < llllllllllllllIlIIIIlllllllIIlIl.length; ++llllllllllllllIlIIIIlllllllIlIII) {
            final String llllllllllllllIlIIIIlllllllIIlll = llllllllllllllIlIIIIlllllllIIlIl[llllllllllllllIlIIIIlllllllIlIII];
            if (llllllllllllllIlIIIIlllllllIlIlI.endsWith(llllllllllllllIlIIIIlllllllIIlll)) {
                return true;
            }
        }
        return false;
    }
    
    public static String[] remove(final String[] llllllllllllllIlIIIIlllllIlIlIII, final int llllllllllllllIlIIIIlllllIlIlllI, final int llllllllllllllIlIIIIlllllIlIllIl) {
        if (llllllllllllllIlIIIIlllllIlIlIII == null) {
            return llllllllllllllIlIIIIlllllIlIlIII;
        }
        if (llllllllllllllIlIIIIlllllIlIllIl <= 0 || llllllllllllllIlIIIIlllllIlIlllI >= llllllllllllllIlIIIIlllllIlIlIII.length) {
            return llllllllllllllIlIIIIlllllIlIlIII;
        }
        if (llllllllllllllIlIIIIlllllIlIlllI >= llllllllllllllIlIIIIlllllIlIllIl) {
            return llllllllllllllIlIIIIlllllIlIlIII;
        }
        final ArrayList llllllllllllllIlIIIIlllllIlIllII = new ArrayList(llllllllllllllIlIIIIlllllIlIlIII.length);
        for (int llllllllllllllIlIIIIlllllIlIlIll = 0; llllllllllllllIlIIIIlllllIlIlIll < llllllllllllllIlIIIIlllllIlIlIII.length; ++llllllllllllllIlIIIIlllllIlIlIll) {
            final String llllllllllllllIlIIIIlllllIlIlIlI = llllllllllllllIlIIIIlllllIlIlIII[llllllllllllllIlIIIIlllllIlIlIll];
            if (llllllllllllllIlIIIIlllllIlIlIll < llllllllllllllIlIIIIlllllIlIlllI || llllllllllllllIlIIIIlllllIlIlIll >= llllllllllllllIlIIIIlllllIlIllIl) {
                llllllllllllllIlIIIIlllllIlIllII.add(llllllllllllllIlIIIIlllllIlIlIlI);
            }
        }
        final String[] llllllllllllllIlIIIIlllllIlIlIIl = llllllllllllllIlIIIIlllllIlIllII.toArray(new String[llllllllllllllIlIIIIlllllIlIllII.size()]);
        return llllllllllllllIlIIIIlllllIlIlIIl;
    }
    
    private static boolean endsWithMaskSingle(final String llllllllllllllIlIIIlIIIIlIIlllIl, final String llllllllllllllIlIIIlIIIIlIlIIIII, final char llllllllllllllIlIIIlIIIIlIIlllll) {
        if (llllllllllllllIlIIIlIIIIlIIlllIl == null || llllllllllllllIlIIIlIIIIlIlIIIII == null) {
            return llllllllllllllIlIIIlIIIIlIIlllIl == llllllllllllllIlIIIlIIIIlIlIIIII;
        }
        if (llllllllllllllIlIIIlIIIIlIIlllIl.length() < llllllllllllllIlIIIlIIIIlIlIIIII.length()) {
            return false;
        }
        final String llllllllllllllIlIIIlIIIIlIIllllI = llllllllllllllIlIIIlIIIIlIIlllIl.substring(llllllllllllllIlIIIlIIIIlIIlllIl.length() - llllllllllllllIlIIIlIIIIlIlIIIII.length(), llllllllllllllIlIIIlIIIIlIIlllIl.length());
        return equalsMaskSingle(llllllllllllllIlIIIlIIIIlIIllllI, llllllllllllllIlIIIlIIIIlIlIIIII, llllllllllllllIlIIIlIIIIlIIlllll);
    }
    
    public static String removeSuffix(String llllllllllllllIlIIIIllllllIllIII, final String llllllllllllllIlIIIIllllllIlIlll) {
        if (llllllllllllllIlIIIIllllllIllIII != null && llllllllllllllIlIIIIllllllIlIlll != null) {
            if (((String)llllllllllllllIlIIIIllllllIllIII).endsWith(llllllllllllllIlIIIIllllllIlIlll)) {
                llllllllllllllIlIIIIllllllIllIII = ((String)llllllllllllllIlIIIIllllllIllIII).substring(0, ((String)llllllllllllllIlIIIIllllllIllIII).length() - llllllllllllllIlIIIIllllllIlIlll.length());
            }
            return (String)llllllllllllllIlIIIIllllllIllIII;
        }
        return (String)llllllllllllllIlIIIIllllllIllIII;
    }
    
    public static String[] split(final String llllllllllllllIlIIIlIIIIIlIIlllI, final String llllllllllllllIlIIIlIIIIIlIIllIl) {
        if (llllllllllllllIlIIIlIIIIIlIIlllI == null || llllllllllllllIlIIIlIIIIIlIIlllI.length() <= 0) {
            return new String[0];
        }
        if (llllllllllllllIlIIIlIIIIIlIIllIl == null) {
            return new String[] { llllllllllllllIlIIIlIIIIIlIIlllI };
        }
        final ArrayList llllllllllllllIlIIIlIIIIIlIlIIlI = new ArrayList();
        int llllllllllllllIlIIIlIIIIIlIlIIIl = 0;
        for (int llllllllllllllIlIIIlIIIIIlIlIIII = 0; llllllllllllllIlIIIlIIIIIlIlIIII < llllllllllllllIlIIIlIIIIIlIIlllI.length(); ++llllllllllllllIlIIIlIIIIIlIlIIII) {
            final char llllllllllllllIlIIIlIIIIIlIIllll = llllllllllllllIlIIIlIIIIIlIIlllI.charAt(llllllllllllllIlIIIlIIIIIlIlIIII);
            if (equals(llllllllllllllIlIIIlIIIIIlIIllll, llllllllllllllIlIIIlIIIIIlIIllIl)) {
                llllllllllllllIlIIIlIIIIIlIlIIlI.add(llllllllllllllIlIIIlIIIIIlIIlllI.substring(llllllllllllllIlIIIlIIIIIlIlIIIl, llllllllllllllIlIIIlIIIIIlIlIIII));
                llllllllllllllIlIIIlIIIIIlIlIIIl = llllllllllllllIlIIIlIIIIIlIlIIII + 1;
            }
        }
        llllllllllllllIlIIIlIIIIIlIlIIlI.add(llllllllllllllIlIIIlIIIIIlIIlllI.substring(llllllllllllllIlIIIlIIIIIlIlIIIl, llllllllllllllIlIIIlIIIIIlIIlllI.length()));
        return llllllllllllllIlIIIlIIIIIlIlIIlI.toArray(new String[llllllllllllllIlIIIlIIIIIlIlIIlI.size()]);
    }
    
    public static String removePrefixSuffix(String llllllllllllllIlIIIIllllIllllllI, final String[] llllllllllllllIlIIIIlllllIIIIIII, final String[] llllllllllllllIlIIIIllllIlllllll) {
        llllllllllllllIlIIIIllllIllllllI = (Exception)removePrefix((String)llllllllllllllIlIIIIllllIllllllI, llllllllllllllIlIIIIlllllIIIIIII);
        llllllllllllllIlIIIIllllIllllllI = (Exception)removeSuffix((String)llllllllllllllIlIIIIllllIllllllI, llllllllllllllIlIIIIllllIlllllll);
        return (String)llllllllllllllIlIIIIllllIllllllI;
    }
    
    public static String getSegment(final String llllllllllllllIlIIIIllllIllIllIl, final String llllllllllllllIlIIIIllllIllIIlll, final String llllllllllllllIlIIIIllllIllIIllI) {
        if (llllllllllllllIlIIIIllllIllIllIl == null || llllllllllllllIlIIIIllllIllIIlll == null || llllllllllllllIlIIIIllllIllIIllI == null) {
            return null;
        }
        final int llllllllllllllIlIIIIllllIllIlIlI = llllllllllllllIlIIIIllllIllIllIl.indexOf(llllllllllllllIlIIIIllllIllIIlll);
        if (llllllllllllllIlIIIIllllIllIlIlI < 0) {
            return null;
        }
        final int llllllllllllllIlIIIIllllIllIlIIl = llllllllllllllIlIIIIllllIllIllIl.indexOf(llllllllllllllIlIIIIllllIllIIllI, llllllllllllllIlIIIIllllIllIlIlI);
        return (llllllllllllllIlIIIIllllIllIlIIl < 0) ? null : llllllllllllllIlIIIIllllIllIllIl.substring(llllllllllllllIlIIIIllllIllIlIlI, llllllllllllllIlIIIIllllIllIlIIl + llllllllllllllIlIIIIllllIllIIllI.length());
    }
    
    public static String removeSuffix(String llllllllllllllIlIIIIlllllIIllIII, final String[] llllllllllllllIlIIIIlllllIIlllII) {
        if (llllllllllllllIlIIIIlllllIIllIII != null && llllllllllllllIlIIIIlllllIIlllII != null) {
            final int llllllllllllllIlIIIIlllllIIllIll = ((String)llllllllllllllIlIIIIlllllIIllIII).length();
            for (int llllllllllllllIlIIIIlllllIIllIlI = 0; llllllllllllllIlIIIIlllllIIllIlI < llllllllllllllIlIIIIlllllIIlllII.length; ++llllllllllllllIlIIIIlllllIIllIlI) {
                final String llllllllllllllIlIIIIlllllIIllIIl = llllllllllllllIlIIIIlllllIIlllII[llllllllllllllIlIIIIlllllIIllIlI];
                llllllllllllllIlIIIIlllllIIllIII = removeSuffix((String)llllllllllllllIlIIIIlllllIIllIII, llllllllllllllIlIIIIlllllIIllIIl);
                if (((String)llllllllllllllIlIIIIlllllIIllIII).length() != llllllllllllllIlIIIIlllllIIllIll) {
                    break;
                }
            }
            return (String)llllllllllllllIlIIIIlllllIIllIII;
        }
        return (String)llllllllllllllIlIIIIlllllIIllIII;
    }
    
    public static boolean equalsMask(final String llllllllllllllIlIIIlIIIIIlllIIlI, final String llllllllllllllIlIIIlIIIIIlllIIIl, final char llllllllllllllIlIIIlIIIIIlllIIII) {
        if (llllllllllllllIlIIIlIIIIIlllIIIl == null || llllllllllllllIlIIIlIIIIIlllIIlI == null) {
            return llllllllllllllIlIIIlIIIIIlllIIIl == llllllllllllllIlIIIlIIIIIlllIIlI;
        }
        if (llllllllllllllIlIIIlIIIIIlllIIIl.indexOf(llllllllllllllIlIIIlIIIIIlllIIII) < 0) {
            return llllllllllllllIlIIIlIIIIIlllIIIl.equals(llllllllllllllIlIIIlIIIIIlllIIlI);
        }
        final ArrayList llllllllllllllIlIIIlIIIIIllIllll = new ArrayList();
        final String llllllllllllllIlIIIlIIIIIllIlllI = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIlIIIIIlllIIII));
        if (llllllllllllllIlIIIlIIIIIlllIIIl.startsWith(llllllllllllllIlIIIlIIIIIllIlllI)) {
            llllllllllllllIlIIIlIIIIIllIllll.add("");
        }
        final StringTokenizer llllllllllllllIlIIIlIIIIIllIllIl = new StringTokenizer(llllllllllllllIlIIIlIIIIIlllIIIl, llllllllllllllIlIIIlIIIIIllIlllI);
        while (llllllllllllllIlIIIlIIIIIllIllIl.hasMoreElements()) {
            llllllllllllllIlIIIlIIIIIllIllll.add(llllllllllllllIlIIIlIIIIIllIllIl.nextToken());
        }
        if (llllllllllllllIlIIIlIIIIIlllIIIl.endsWith(llllllllllllllIlIIIlIIIIIllIlllI)) {
            llllllllllllllIlIIIlIIIIIllIllll.add("");
        }
        final String llllllllllllllIlIIIlIIIIIllIllII = llllllllllllllIlIIIlIIIIIllIllll.get(0);
        if (!llllllllllllllIlIIIlIIIIIlllIIlI.startsWith(llllllllllllllIlIIIlIIIIIllIllII)) {
            return false;
        }
        final String llllllllllllllIlIIIlIIIIIllIlIll = llllllllllllllIlIIIlIIIIIllIllll.get(llllllllllllllIlIIIlIIIIIllIllll.size() - 1);
        if (!llllllllllllllIlIIIlIIIIIlllIIlI.endsWith(llllllllllllllIlIIIlIIIIIllIlIll)) {
            return false;
        }
        int llllllllllllllIlIIIlIIIIIllIlIlI = 0;
        for (int llllllllllllllIlIIIlIIIIIllIlIIl = 0; llllllllllllllIlIIIlIIIIIllIlIIl < llllllllllllllIlIIIlIIIIIllIllll.size(); ++llllllllllllllIlIIIlIIIIIllIlIIl) {
            final String llllllllllllllIlIIIlIIIIIllIlIII = llllllllllllllIlIIIlIIIIIllIllll.get(llllllllllllllIlIIIlIIIIIllIlIIl);
            if (llllllllllllllIlIIIlIIIIIllIlIII.length() > 0) {
                final int llllllllllllllIlIIIlIIIIIllIIlll = llllllllllllllIlIIIlIIIIIlllIIlI.indexOf(llllllllllllllIlIIIlIIIIIllIlIII, llllllllllllllIlIIIlIIIIIllIlIlI);
                if (llllllllllllllIlIIIlIIIIIllIIlll < 0) {
                    return false;
                }
                llllllllllllllIlIIIlIIIIIllIlIlI = llllllllllllllIlIIIlIIIIIllIIlll + llllllllllllllIlIIIlIIIIIllIlIII.length();
            }
        }
        return true;
    }
}
