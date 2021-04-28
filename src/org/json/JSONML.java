package org.json;

public class JSONML
{
    public static JSONObject toJSONObject(final XMLTokener llllllllllllllIllIIIlllIIlIlIlII, final boolean llllllllllllllIllIIIlllIIlIlIIIl) throws JSONException {
        return (JSONObject)parse(llllllllllllllIllIIIlllIIlIlIlII, false, null, llllllllllllllIllIIIlllIIlIlIIIl);
    }
    
    public static JSONObject toJSONObject(final XMLTokener llllllllllllllIllIIIlllIIlIllIII) throws JSONException {
        return (JSONObject)parse(llllllllllllllIllIIIlllIIlIllIII, false, null, false);
    }
    
    public static JSONArray toJSONArray(final XMLTokener llllllllllllllIllIIIlllIIllIIlII) throws JSONException {
        return (JSONArray)parse(llllllllllllllIllIIIlllIIllIIlII, true, null, false);
    }
    
    public static String toString(final JSONObject llllllllllllllIllIIIlllIIIIlllll) throws JSONException {
        final StringBuilder llllllllllllllIllIIIlllIIIlIIIlI = new StringBuilder();
        String llllllllllllllIllIIIlllIIIlIIIII = llllllllllllllIllIIIlllIIIIlllll.optString("tagName");
        if (llllllllllllllIllIIIlllIIIlIIIII == null) {
            return XML.escape(llllllllllllllIllIIIlllIIIIlllll.toString());
        }
        XML.noSpace(llllllllllllllIllIIIlllIIIlIIIII);
        llllllllllllllIllIIIlllIIIlIIIII = XML.escape(llllllllllllllIllIIIlllIIIlIIIII);
        llllllllllllllIllIIIlllIIIlIIIlI.append('<');
        llllllllllllllIllIIIlllIIIlIIIlI.append(llllllllllllllIllIIIlllIIIlIIIII);
        for (final String llllllllllllllIllIIIlllIIIlIIlll : llllllllllllllIllIIIlllIIIIlllll.keySet()) {
            if (!"tagName".equals(llllllllllllllIllIIIlllIIIlIIlll) && !"childNodes".equals(llllllllllllllIllIIIlllIIIlIIlll)) {
                XML.noSpace(llllllllllllllIllIIIlllIIIlIIlll);
                final Object llllllllllllllIllIIIlllIIIlIlIII = llllllllllllllIllIIIlllIIIIlllll.opt(llllllllllllllIllIIIlllIIIlIIlll);
                if (llllllllllllllIllIIIlllIIIlIlIII == null) {
                    continue;
                }
                llllllllllllllIllIIIlllIIIlIIIlI.append(' ');
                llllllllllllllIllIIIlllIIIlIIIlI.append(XML.escape(llllllllllllllIllIIIlllIIIlIIlll));
                llllllllllllllIllIIIlllIIIlIIIlI.append('=');
                llllllllllllllIllIIIlllIIIlIIIlI.append('\"');
                llllllllllllllIllIIIlllIIIlIIIlI.append(XML.escape(llllllllllllllIllIIIlllIIIlIlIII.toString()));
                llllllllllllllIllIIIlllIIIlIIIlI.append('\"');
            }
        }
        final JSONArray llllllllllllllIllIIIlllIIIlIIIIl = llllllllllllllIllIIIlllIIIIlllll.optJSONArray("childNodes");
        if (llllllllllllllIllIIIlllIIIlIIIIl == null) {
            llllllllllllllIllIIIlllIIIlIIIlI.append('/');
            llllllllllllllIllIIIlllIIIlIIIlI.append('>');
        }
        else {
            llllllllllllllIllIIIlllIIIlIIIlI.append('>');
            for (int llllllllllllllIllIIIlllIIIlIIlII = llllllllllllllIllIIIlllIIIlIIIIl.length(), llllllllllllllIllIIIlllIIIlIIlIl = 0; llllllllllllllIllIIIlllIIIlIIlIl < llllllllllllllIllIIIlllIIIlIIlII; ++llllllllllllllIllIIIlllIIIlIIlIl) {
                final Object llllllllllllllIllIIIlllIIIlIIllI = llllllllllllllIllIIIlllIIIlIIIIl.get(llllllllllllllIllIIIlllIIIlIIlIl);
                if (llllllllllllllIllIIIlllIIIlIIllI != null) {
                    if (llllllllllllllIllIIIlllIIIlIIllI instanceof String) {
                        llllllllllllllIllIIIlllIIIlIIIlI.append(XML.escape(llllllllllllllIllIIIlllIIIlIIllI.toString()));
                    }
                    else if (llllllllllllllIllIIIlllIIIlIIllI instanceof JSONObject) {
                        llllllllllllllIllIIIlllIIIlIIIlI.append(toString((JSONObject)llllllllllllllIllIIIlllIIIlIIllI));
                    }
                    else if (llllllllllllllIllIIIlllIIIlIIllI instanceof JSONArray) {
                        llllllllllllllIllIIIlllIIIlIIIlI.append(toString((JSONArray)llllllllllllllIllIIIlllIIIlIIllI));
                    }
                    else {
                        llllllllllllllIllIIIlllIIIlIIIlI.append(llllllllllllllIllIIIlllIIIlIIllI.toString());
                    }
                }
            }
            llllllllllllllIllIIIlllIIIlIIIlI.append('<');
            llllllllllllllIllIIIlllIIIlIIIlI.append('/');
            llllllllllllllIllIIIlllIIIlIIIlI.append(llllllllllllllIllIIIlllIIIlIIIII);
            llllllllllllllIllIIIlllIIIlIIIlI.append('>');
        }
        return String.valueOf(llllllllllllllIllIIIlllIIIlIIIlI);
    }
    
    public static JSONObject toJSONObject(final String llllllllllllllIllIIIlllIIllIIIII) throws JSONException {
        return (JSONObject)parse(new XMLTokener(llllllllllllllIllIIIlllIIllIIIII), false, null, false);
    }
    
    public static JSONArray toJSONArray(final String llllllllllllllIllIIIlllIIlllIIlI) throws JSONException {
        return (JSONArray)parse(new XMLTokener(llllllllllllllIllIIIlllIIlllIIlI), true, null, false);
    }
    
    private static Object parse(final XMLTokener llllllllllllllIllIIIlllIlIIIIIII, final boolean llllllllllllllIllIIIlllIIlllllll, final JSONArray llllllllllllllIllIIIlllIIllllllI, final boolean llllllllllllllIllIIIlllIlIIIIllI) throws JSONException {
        String llllllllllllllIllIIIlllIlIIIIlIl = null;
        JSONArray llllllllllllllIllIIIlllIlIIIIlII = null;
        JSONObject llllllllllllllIllIIIlllIlIIIIIll = null;
        String llllllllllllllIllIIIlllIlIIIIIIl = null;
        while (llllllllllllllIllIIIlllIlIIIIIII.more()) {
            Object llllllllllllllIllIIIlllIlIIIIIlI = llllllllllllllIllIIIlllIlIIIIIII.nextContent();
            if (llllllllllllllIllIIIlllIlIIIIIlI == XML.LT) {
                llllllllllllllIllIIIlllIlIIIIIlI = llllllllllllllIllIIIlllIlIIIIIII.nextToken();
                if (llllllllllllllIllIIIlllIlIIIIIlI instanceof Character) {
                    if (llllllllllllllIllIIIlllIlIIIIIlI == XML.SLASH) {
                        llllllllllllllIllIIIlllIlIIIIIlI = llllllllllllllIllIIIlllIlIIIIIII.nextToken();
                        if (!(llllllllllllllIllIIIlllIlIIIIIlI instanceof String)) {
                            throw new JSONException(String.valueOf(new StringBuilder().append("Expected a closing name instead of '").append(llllllllllllllIllIIIlllIlIIIIIlI).append("'.")));
                        }
                        if (llllllllllllllIllIIIlllIlIIIIIII.nextToken() != XML.GT) {
                            throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Misshaped close tag");
                        }
                        return llllllllllllllIllIIIlllIlIIIIIlI;
                    }
                    else if (llllllllllllllIllIIIlllIlIIIIIlI == XML.BANG) {
                        final char llllllllllllllIllIIIlllIlIIIllII = llllllllllllllIllIIIlllIlIIIIIII.next();
                        if (llllllllllllllIllIIIlllIlIIIllII == '-') {
                            if (llllllllllllllIllIIIlllIlIIIIIII.next() == '-') {
                                llllllllllllllIllIIIlllIlIIIIIII.skipPast("-->");
                            }
                            else {
                                llllllllllllllIllIIIlllIlIIIIIII.back();
                            }
                        }
                        else if (llllllllllllllIllIIIlllIlIIIllII == '[') {
                            llllllllllllllIllIIIlllIlIIIIIlI = llllllllllllllIllIIIlllIlIIIIIII.nextToken();
                            if (!llllllllllllllIllIIIlllIlIIIIIlI.equals("CDATA") || llllllllllllllIllIIIlllIlIIIIIII.next() != '[') {
                                throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Expected 'CDATA['");
                            }
                            if (llllllllllllllIllIIIlllIIllllllI == null) {
                                continue;
                            }
                            llllllllllllllIllIIIlllIIllllllI.put(llllllllllllllIllIIIlllIlIIIIIII.nextCDATA());
                        }
                        else {
                            int llllllllllllllIllIIIlllIlIIIlIll = 1;
                            do {
                                llllllllllllllIllIIIlllIlIIIIIlI = llllllllllllllIllIIIlllIlIIIIIII.nextMeta();
                                if (llllllllllllllIllIIIlllIlIIIIIlI == null) {
                                    throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Missing '>' after '<!'.");
                                }
                                if (llllllllllllllIllIIIlllIlIIIIIlI == XML.LT) {
                                    ++llllllllllllllIllIIIlllIlIIIlIll;
                                }
                                else {
                                    if (llllllllllllllIllIIIlllIlIIIIIlI != XML.GT) {
                                        continue;
                                    }
                                    --llllllllllllllIllIIIlllIlIIIlIll;
                                }
                            } while (llllllllllllllIllIIIlllIlIIIlIll > 0);
                        }
                    }
                    else {
                        if (llllllllllllllIllIIIlllIlIIIIIlI != XML.QUEST) {
                            throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Misshaped tag");
                        }
                        llllllllllllllIllIIIlllIlIIIIIII.skipPast("?>");
                    }
                }
                else {
                    if (!(llllllllllllllIllIIIlllIlIIIIIlI instanceof String)) {
                        throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError(String.valueOf(new StringBuilder().append("Bad tagName '").append(llllllllllllllIllIIIlllIlIIIIIlI).append("'.")));
                    }
                    llllllllllllllIllIIIlllIlIIIIIIl = (String)llllllllllllllIllIIIlllIlIIIIIlI;
                    llllllllllllllIllIIIlllIlIIIIlII = new JSONArray();
                    llllllllllllllIllIIIlllIlIIIIIll = new JSONObject();
                    if (llllllllllllllIllIIIlllIIlllllll) {
                        llllllllllllllIllIIIlllIlIIIIlII.put(llllllllllllllIllIIIlllIlIIIIIIl);
                        if (llllllllllllllIllIIIlllIIllllllI != null) {
                            llllllllllllllIllIIIlllIIllllllI.put(llllllllllllllIllIIIlllIlIIIIlII);
                        }
                    }
                    else {
                        llllllllllllllIllIIIlllIlIIIIIll.put("tagName", llllllllllllllIllIIIlllIlIIIIIIl);
                        if (llllllllllllllIllIIIlllIIllllllI != null) {
                            llllllllllllllIllIIIlllIIllllllI.put(llllllllllllllIllIIIlllIlIIIIIll);
                        }
                    }
                    llllllllllllllIllIIIlllIlIIIIIlI = null;
                    while (true) {
                        if (llllllllllllllIllIIIlllIlIIIIIlI == null) {
                            llllllllllllllIllIIIlllIlIIIIIlI = llllllllllllllIllIIIlllIlIIIIIII.nextToken();
                        }
                        if (llllllllllllllIllIIIlllIlIIIIIlI == null) {
                            throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Misshaped tag");
                        }
                        if (!(llllllllllllllIllIIIlllIlIIIIIlI instanceof String)) {
                            if (llllllllllllllIllIIIlllIIlllllll && llllllllllllllIllIIIlllIlIIIIIll.length() > 0) {
                                llllllllllllllIllIIIlllIlIIIIlII.put(llllllllllllllIllIIIlllIlIIIIIll);
                            }
                            if (llllllllllllllIllIIIlllIlIIIIIlI == XML.SLASH) {
                                if (llllllllllllllIllIIIlllIlIIIIIII.nextToken() != XML.GT) {
                                    throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Misshaped tag");
                                }
                                if (llllllllllllllIllIIIlllIIllllllI != null) {
                                    break;
                                }
                                if (llllllllllllllIllIIIlllIIlllllll) {
                                    return llllllllllllllIllIIIlllIlIIIIlII;
                                }
                                return llllllllllllllIllIIIlllIlIIIIIll;
                            }
                            else {
                                if (llllllllllllllIllIIIlllIlIIIIIlI != XML.GT) {
                                    throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Misshaped tag");
                                }
                                llllllllllllllIllIIIlllIlIIIIlIl = (String)parse(llllllllllllllIllIIIlllIlIIIIIII, llllllllllllllIllIIIlllIIlllllll, llllllllllllllIllIIIlllIlIIIIlII, llllllllllllllIllIIIlllIlIIIIllI);
                                if (llllllllllllllIllIIIlllIlIIIIlIl == null) {
                                    break;
                                }
                                if (!llllllllllllllIllIIIlllIlIIIIlIl.equals(llllllllllllllIllIIIlllIlIIIIIIl)) {
                                    throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError(String.valueOf(new StringBuilder().append("Mismatched '").append(llllllllllllllIllIIIlllIlIIIIIIl).append("' and '").append(llllllllllllllIllIIIlllIlIIIIlIl).append("'")));
                                }
                                llllllllllllllIllIIIlllIlIIIIIIl = null;
                                if (!llllllllllllllIllIIIlllIIlllllll && llllllllllllllIllIIIlllIlIIIIlII.length() > 0) {
                                    llllllllllllllIllIIIlllIlIIIIIll.put("childNodes", llllllllllllllIllIIIlllIlIIIIlII);
                                }
                                if (llllllllllllllIllIIIlllIIllllllI != null) {
                                    break;
                                }
                                if (llllllllllllllIllIIIlllIIlllllll) {
                                    return llllllllllllllIllIIIlllIlIIIIlII;
                                }
                                return llllllllllllllIllIIIlllIlIIIIIll;
                            }
                        }
                        else {
                            final String llllllllllllllIllIIIlllIlIIIlIlI = (String)llllllllllllllIllIIIlllIlIIIIIlI;
                            if (!llllllllllllllIllIIIlllIIlllllll && ("tagName".equals(llllllllllllllIllIIIlllIlIIIlIlI) || "childNode".equals(llllllllllllllIllIIIlllIlIIIlIlI))) {
                                throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Reserved attribute.");
                            }
                            llllllllllllllIllIIIlllIlIIIIIlI = llllllllllllllIllIIIlllIlIIIIIII.nextToken();
                            if (llllllllllllllIllIIIlllIlIIIIIlI == XML.EQ) {
                                llllllllllllllIllIIIlllIlIIIIIlI = llllllllllllllIllIIIlllIlIIIIIII.nextToken();
                                if (!(llllllllllllllIllIIIlllIlIIIIIlI instanceof String)) {
                                    throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Missing value");
                                }
                                llllllllllllllIllIIIlllIlIIIIIll.accumulate(llllllllllllllIllIIIlllIlIIIlIlI, llllllllllllllIllIIIlllIlIIIIllI ? ((String)llllllllllllllIllIIIlllIlIIIIIlI) : XML.stringToValue((String)llllllllllllllIllIIIlllIlIIIIIlI));
                                llllllllllllllIllIIIlllIlIIIIIlI = null;
                            }
                            else {
                                llllllllllllllIllIIIlllIlIIIIIll.accumulate(llllllllllllllIllIIIlllIlIIIlIlI, "");
                            }
                        }
                    }
                }
            }
            else {
                if (llllllllllllllIllIIIlllIIllllllI == null) {
                    continue;
                }
                llllllllllllllIllIIIlllIIllllllI.put((llllllllllllllIllIIIlllIlIIIIIlI instanceof String) ? (llllllllllllllIllIIIlllIlIIIIllI ? XML.unescape((String)llllllllllllllIllIIIlllIlIIIIIlI) : XML.stringToValue((String)llllllllllllllIllIIIlllIlIIIIIlI)) : llllllllllllllIllIIIlllIlIIIIIlI);
            }
        }
        throw llllllllllllllIllIIIlllIlIIIIIII.syntaxError("Bad XML");
    }
    
    public static JSONArray toJSONArray(final String llllllllllllllIllIIIlllIIllIllIl, final boolean llllllllllllllIllIIIlllIIllIllII) throws JSONException {
        return (JSONArray)parse(new XMLTokener(llllllllllllllIllIIIlllIIllIllIl), true, null, llllllllllllllIllIIIlllIIllIllII);
    }
    
    public static JSONArray toJSONArray(final XMLTokener llllllllllllllIllIIIlllIIllIIlll, final boolean llllllllllllllIllIIIlllIIllIIllI) throws JSONException {
        return (JSONArray)parse(llllllllllllllIllIIIlllIIllIIlll, true, null, llllllllllllllIllIIIlllIIllIIllI);
    }
    
    public static String toString(final JSONArray llllllllllllllIllIIIlllIIIllllII) throws JSONException {
        final StringBuilder llllllllllllllIllIIIlllIIIlllllI = new StringBuilder();
        String llllllllllllllIllIIIlllIIIllllIl = llllllllllllllIllIIIlllIIIllllII.getString(0);
        XML.noSpace(llllllllllllllIllIIIlllIIIllllIl);
        llllllllllllllIllIIIlllIIIllllIl = XML.escape(llllllllllllllIllIIIlllIIIllllIl);
        llllllllllllllIllIIIlllIIIlllllI.append('<');
        llllllllllllllIllIIIlllIIIlllllI.append(llllllllllllllIllIIIlllIIIllllIl);
        Object llllllllllllllIllIIIlllIIIllllll = llllllllllllllIllIIIlllIIIllllII.opt(1);
        int llllllllllllllIllIIIlllIIlIIIIIl;
        if (llllllllllllllIllIIIlllIIIllllll instanceof JSONObject) {
            final int llllllllllllllIllIIIlllIIlIIIlII = 2;
            final JSONObject llllllllllllllIllIIIlllIIlIIIIll = (JSONObject)llllllllllllllIllIIIlllIIIllllll;
            for (final String llllllllllllllIllIIIlllIIlIIIlIl : llllllllllllllIllIIIlllIIlIIIIll.keySet()) {
                final Object llllllllllllllIllIIIlllIIlIIIllI = llllllllllllllIllIIIlllIIlIIIIll.opt(llllllllllllllIllIIIlllIIlIIIlIl);
                XML.noSpace(llllllllllllllIllIIIlllIIlIIIlIl);
                if (llllllllllllllIllIIIlllIIlIIIllI != null) {
                    llllllllllllllIllIIIlllIIIlllllI.append(' ');
                    llllllllllllllIllIIIlllIIIlllllI.append(XML.escape(llllllllllllllIllIIIlllIIlIIIlIl));
                    llllllllllllllIllIIIlllIIIlllllI.append('=');
                    llllllllllllllIllIIIlllIIIlllllI.append('\"');
                    llllllllllllllIllIIIlllIIIlllllI.append(XML.escape(llllllllllllllIllIIIlllIIlIIIllI.toString()));
                    llllllllllllllIllIIIlllIIIlllllI.append('\"');
                }
            }
        }
        else {
            llllllllllllllIllIIIlllIIlIIIIIl = 1;
        }
        final int llllllllllllllIllIIIlllIIlIIIIII = llllllllllllllIllIIIlllIIIllllII.length();
        if (llllllllllllllIllIIIlllIIlIIIIIl >= llllllllllllllIllIIIlllIIlIIIIII) {
            llllllllllllllIllIIIlllIIIlllllI.append('/');
            llllllllllllllIllIIIlllIIIlllllI.append('>');
        }
        else {
            llllllllllllllIllIIIlllIIIlllllI.append('>');
            do {
                llllllllllllllIllIIIlllIIIllllll = llllllllllllllIllIIIlllIIIllllII.get(llllllllllllllIllIIIlllIIlIIIIIl);
                ++llllllllllllllIllIIIlllIIlIIIIIl;
                if (llllllllllllllIllIIIlllIIIllllll != null) {
                    if (llllllllllllllIllIIIlllIIIllllll instanceof String) {
                        llllllllllllllIllIIIlllIIIlllllI.append(XML.escape(llllllllllllllIllIIIlllIIIllllll.toString()));
                    }
                    else if (llllllllllllllIllIIIlllIIIllllll instanceof JSONObject) {
                        llllllllllllllIllIIIlllIIIlllllI.append(toString((JSONObject)llllllllllllllIllIIIlllIIIllllll));
                    }
                    else if (llllllllllllllIllIIIlllIIIllllll instanceof JSONArray) {
                        llllllllllllllIllIIIlllIIIlllllI.append(toString((JSONArray)llllllllllllllIllIIIlllIIIllllll));
                    }
                    else {
                        llllllllllllllIllIIIlllIIIlllllI.append(llllllllllllllIllIIIlllIIIllllll.toString());
                    }
                }
            } while (llllllllllllllIllIIIlllIIlIIIIIl < llllllllllllllIllIIIlllIIlIIIIII);
            llllllllllllllIllIIIlllIIIlllllI.append('<');
            llllllllllllllIllIIIlllIIIlllllI.append('/');
            llllllllllllllIllIIIlllIIIlllllI.append(llllllllllllllIllIIIlllIIIllllIl);
            llllllllllllllIllIIIlllIIIlllllI.append('>');
        }
        return String.valueOf(llllllllllllllIllIIIlllIIIlllllI);
    }
    
    public static JSONObject toJSONObject(final String llllllllllllllIllIIIlllIIlIllIll, final boolean llllllllllllllIllIIIlllIIlIlllII) throws JSONException {
        return (JSONObject)parse(new XMLTokener(llllllllllllllIllIIIlllIIlIllIll), false, null, llllllllllllllIllIIIlllIIlIlllII);
    }
}
