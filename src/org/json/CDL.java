package org.json;

public class CDL
{
    public static JSONArray toJSONArray(final JSONTokener llllllllllllllIlllIllllIIIIllIlI) throws JSONException {
        return toJSONArray(rowToJSONArray(llllllllllllllIlllIllllIIIIllIlI), llllllllllllllIlllIllllIIIIllIlI);
    }
    
    public static String toString(final JSONArray llllllllllllllIlllIllllIIIIIIIII) throws JSONException {
        final JSONObject llllllllllllllIlllIllllIIIIIIIIl = llllllllllllllIlllIllllIIIIIIIII.optJSONObject(0);
        if (llllllllllllllIlllIllllIIIIIIIIl != null) {
            final JSONArray llllllllllllllIlllIllllIIIIIIIll = llllllllllllllIlllIllllIIIIIIIIl.names();
            if (llllllllllllllIlllIllllIIIIIIIll != null) {
                return String.valueOf(new StringBuilder().append(rowToString(llllllllllllllIlllIllllIIIIIIIll)).append(toString(llllllllllllllIlllIllllIIIIIIIll, llllllllllllllIlllIllllIIIIIIIII)));
            }
        }
        return null;
    }
    
    public static JSONArray toJSONArray(final JSONArray llllllllllllllIlllIllllIIIIIlIlI, final JSONTokener llllllllllllllIlllIllllIIIIIlIIl) throws JSONException {
        if (llllllllllllllIlllIllllIIIIIlIlI == null || llllllllllllllIlllIllllIIIIIlIlI.length() == 0) {
            return null;
        }
        final JSONArray llllllllllllllIlllIllllIIIIIlIll = new JSONArray();
        while (true) {
            final JSONObject llllllllllllllIlllIllllIIIIIlllI = rowToJSONObject(llllllllllllllIlllIllllIIIIIlIlI, llllllllllllllIlllIllllIIIIIlIIl);
            if (llllllllllllllIlllIllllIIIIIlllI == null) {
                break;
            }
            llllllllllllllIlllIllllIIIIIlIll.put(llllllllllllllIlllIllllIIIIIlllI);
        }
        if (llllllllllllllIlllIllllIIIIIlIll.length() == 0) {
            return null;
        }
        return llllllllllllllIlllIllllIIIIIlIll;
    }
    
    public static String toString(final JSONArray llllllllllllllIlllIlllIlllllIIll, final JSONArray llllllllllllllIlllIlllIlllllIlIl) throws JSONException {
        if (llllllllllllllIlllIlllIlllllIIll == null || llllllllllllllIlllIlllIlllllIIll.length() == 0) {
            return null;
        }
        final StringBuilder llllllllllllllIlllIlllIlllllIlII = new StringBuilder();
        for (int llllllllllllllIlllIlllIlllllIlll = 0; llllllllllllllIlllIlllIlllllIlll < llllllllllllllIlllIlllIlllllIlIl.length(); ++llllllllllllllIlllIlllIlllllIlll) {
            final JSONObject llllllllllllllIlllIlllIllllllIII = llllllllllllllIlllIlllIlllllIlIl.optJSONObject(llllllllllllllIlllIlllIlllllIlll);
            if (llllllllllllllIlllIlllIllllllIII != null) {
                llllllllllllllIlllIlllIlllllIlII.append(rowToString(llllllllllllllIlllIlllIllllllIII.toJSONArray(llllllllllllllIlllIlllIlllllIIll)));
            }
        }
        return String.valueOf(llllllllllllllIlllIlllIlllllIlII);
    }
    
    private static String getValue(final JSONTokener llllllllllllllIlllIllllIIlIlIlII) throws JSONException {
        char llllllllllllllIlllIllllIIlIlIIll;
        do {
            llllllllllllllIlllIllllIIlIlIIll = llllllllllllllIlllIllllIIlIlIlII.next();
        } while (llllllllllllllIlllIllllIIlIlIIll == ' ' || llllllllllllllIlllIllllIIlIlIIll == '\t');
        switch (llllllllllllllIlllIllllIIlIlIIll) {
            case '\0': {
                return null;
            }
            case '\"':
            case '\'': {
                final char llllllllllllllIlllIllllIIlIlIIlI = llllllllllllllIlllIllllIIlIlIIll;
                final StringBuilder llllllllllllllIlllIllllIIlIlIIIl = new StringBuilder();
                while (true) {
                    llllllllllllllIlllIllllIIlIlIIll = llllllllllllllIlllIllllIIlIlIlII.next();
                    if (llllllllllllllIlllIllllIIlIlIIll == llllllllllllllIlllIllllIIlIlIIlI) {
                        final char llllllllllllllIlllIllllIIlIlIlIl = llllllllllllllIlllIllllIIlIlIlII.next();
                        if (llllllllllllllIlllIllllIIlIlIlIl != '\"') {
                            if (llllllllllllllIlllIllllIIlIlIlIl > '\0') {
                                llllllllllllllIlllIllllIIlIlIlII.back();
                            }
                            return String.valueOf(llllllllllllllIlllIllllIIlIlIIIl);
                        }
                    }
                    if (llllllllllllllIlllIllllIIlIlIIll == '\0' || llllllllllllllIlllIllllIIlIlIIll == '\n' || llllllllllllllIlllIllllIIlIlIIll == '\r') {
                        throw llllllllllllllIlllIllllIIlIlIlII.syntaxError(String.valueOf(new StringBuilder().append("Missing close quote '").append(llllllllllllllIlllIllllIIlIlIIlI).append("'.")));
                    }
                    llllllllllllllIlllIllllIIlIlIIIl.append(llllllllllllllIlllIllllIIlIlIIll);
                }
                break;
            }
            case ',': {
                llllllllllllllIlllIllllIIlIlIlII.back();
                return "";
            }
            default: {
                llllllllllllllIlllIllllIIlIlIlII.back();
                return llllllllllllllIlllIllllIIlIlIlII.nextTo(',');
            }
        }
    }
    
    public static JSONArray toJSONArray(final JSONArray llllllllllllllIlllIllllIIIIlIllI, final String llllllllllllllIlllIllllIIIIlIlIl) throws JSONException {
        return toJSONArray(llllllllllllllIlllIllllIIIIlIllI, new JSONTokener(llllllllllllllIlllIllllIIIIlIlIl));
    }
    
    public static String rowToString(final JSONArray llllllllllllllIlllIllllIIIlIIllI) {
        final StringBuilder llllllllllllllIlllIllllIIIlIIlll = new StringBuilder();
        for (int llllllllllllllIlllIllllIIIlIlIIl = 0; llllllllllllllIlllIllllIIIlIlIIl < llllllllllllllIlllIllllIIIlIIllI.length(); ++llllllllllllllIlllIllllIIIlIlIIl) {
            if (llllllllllllllIlllIllllIIIlIlIIl > 0) {
                llllllllllllllIlllIllllIIIlIIlll.append(',');
            }
            final Object llllllllllllllIlllIllllIIIlIlIlI = llllllllllllllIlllIllllIIIlIIllI.opt(llllllllllllllIlllIllllIIIlIlIIl);
            if (llllllllllllllIlllIllllIIIlIlIlI != null) {
                final String llllllllllllllIlllIllllIIIlIlIll = llllllllllllllIlllIllllIIIlIlIlI.toString();
                if (llllllllllllllIlllIllllIIIlIlIll.length() > 0 && (llllllllllllllIlllIllllIIIlIlIll.indexOf(44) >= 0 || llllllllllllllIlllIllllIIIlIlIll.indexOf(10) >= 0 || llllllllllllllIlllIllllIIIlIlIll.indexOf(13) >= 0 || llllllllllllllIlllIllllIIIlIlIll.indexOf(0) >= 0 || llllllllllllllIlllIllllIIIlIlIll.charAt(0) == '\"')) {
                    llllllllllllllIlllIllllIIIlIIlll.append('\"');
                    for (int llllllllllllllIlllIllllIIIlIllII = llllllllllllllIlllIllllIIIlIlIll.length(), llllllllllllllIlllIllllIIIlIllIl = 0; llllllllllllllIlllIllllIIIlIllIl < llllllllllllllIlllIllllIIIlIllII; ++llllllllllllllIlllIllllIIIlIllIl) {
                        final char llllllllllllllIlllIllllIIIlIlllI = llllllllllllllIlllIllllIIIlIlIll.charAt(llllllllllllllIlllIllllIIIlIllIl);
                        if (llllllllllllllIlllIllllIIIlIlllI >= ' ' && llllllllllllllIlllIllllIIIlIlllI != '\"') {
                            llllllllllllllIlllIllllIIIlIIlll.append(llllllllllllllIlllIllllIIIlIlllI);
                        }
                    }
                    llllllllllllllIlllIllllIIIlIIlll.append('\"');
                }
                else {
                    llllllllllllllIlllIllllIIIlIIlll.append(llllllllllllllIlllIllllIIIlIlIll);
                }
            }
        }
        llllllllllllllIlllIllllIIIlIIlll.append('\n');
        return String.valueOf(llllllllllllllIlllIllllIIIlIIlll);
    }
    
    public static JSONObject rowToJSONObject(final JSONArray llllllllllllllIlllIllllIIIllllII, final JSONTokener llllllllllllllIlllIllllIIIlllIII) throws JSONException {
        final JSONArray llllllllllllllIlllIllllIIIlllIlI = rowToJSONArray(llllllllllllllIlllIllllIIIlllIII);
        return (llllllllllllllIlllIllllIIIlllIlI != null) ? llllllllllllllIlllIllllIIIlllIlI.toJSONObject(llllllllllllllIlllIllllIIIllllII) : null;
    }
    
    public static JSONArray rowToJSONArray(final JSONTokener llllllllllllllIlllIllllIIlIIIlIl) throws JSONException {
        final JSONArray llllllllllllllIlllIllllIIlIIIlII = new JSONArray();
        while (true) {
            final String llllllllllllllIlllIllllIIlIIIlll = getValue(llllllllllllllIlllIllllIIlIIIlIl);
            char llllllllllllllIlllIllllIIlIIIllI = llllllllllllllIlllIllllIIlIIIlIl.next();
            if (llllllllllllllIlllIllllIIlIIIlll == null || (llllllllllllllIlllIllllIIlIIIlII.length() == 0 && llllllllllllllIlllIllllIIlIIIlll.length() == 0 && llllllllllllllIlllIllllIIlIIIllI != ',')) {
                return null;
            }
            llllllllllllllIlllIllllIIlIIIlII.put(llllllllllllllIlllIllllIIlIIIlll);
            while (llllllllllllllIlllIllllIIlIIIllI != ',') {
                if (llllllllllllllIlllIllllIIlIIIllI != ' ') {
                    if (llllllllllllllIlllIllllIIlIIIllI == '\n' || llllllllllllllIlllIllllIIlIIIllI == '\r' || llllllllllllllIlllIllllIIlIIIllI == '\0') {
                        return llllllllllllllIlllIllllIIlIIIlII;
                    }
                    throw llllllllllllllIlllIllllIIlIIIlIl.syntaxError(String.valueOf(new StringBuilder().append("Bad character '").append(llllllllllllllIlllIllllIIlIIIllI).append("' (").append((int)llllllllllllllIlllIllllIIlIIIllI).append(").")));
                }
                else {
                    llllllllllllllIlllIllllIIlIIIllI = llllllllllllllIlllIllllIIlIIIlIl.next();
                }
            }
        }
    }
    
    public static JSONArray toJSONArray(final String llllllllllllllIlllIllllIIIIlllII) throws JSONException {
        return toJSONArray(new JSONTokener(llllllllllllllIlllIllllIIIIlllII));
    }
}
