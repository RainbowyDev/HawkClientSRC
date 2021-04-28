package org.json;

import java.io.*;
import java.util.*;

public class XML
{
    public static final /* synthetic */ Character LT;
    public static final /* synthetic */ Character BANG;
    public static final /* synthetic */ Character QUEST;
    public static final /* synthetic */ Character SLASH;
    public static final /* synthetic */ Character EQ;
    public static final /* synthetic */ Character GT;
    
    public static Object stringToValue(final String llllllllllllllIllIlllIIIlIlllllI) {
        if (llllllllllllllIllIlllIIIlIlllllI.equals("")) {
            return llllllllllllllIllIlllIIIlIlllllI;
        }
        if (llllllllllllllIllIlllIIIlIlllllI.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (llllllllllllllIllIlllIIIlIlllllI.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (llllllllllllllIllIlllIIIlIlllllI.equalsIgnoreCase("null")) {
            return JSONObject.NULL;
        }
        final char llllllllllllllIllIlllIIIlIllllll = llllllllllllllIllIlllIIIlIlllllI.charAt(0);
        if (llllllllllllllIllIlllIIIlIllllll < '0' || llllllllllllllIllIlllIIIlIllllll > '9') {
            if (llllllllllllllIllIlllIIIlIllllll != '-') {
                return llllllllllllllIllIlllIIIlIlllllI;
            }
        }
        try {
            if (llllllllllllllIllIlllIIIlIlllllI.indexOf(46) > -1 || llllllllllllllIllIlllIIIlIlllllI.indexOf(101) > -1 || llllllllllllllIllIlllIIIlIlllllI.indexOf(69) > -1 || "-0".equals(llllllllllllllIllIlllIIIlIlllllI)) {
                final Double llllllllllllllIllIlllIIIllIIIIll = Double.valueOf(llllllllllllllIllIlllIIIlIlllllI);
                if (!llllllllllllllIllIlllIIIllIIIIll.isInfinite() && !llllllllllllllIllIlllIIIllIIIIll.isNaN()) {
                    return llllllllllllllIllIlllIIIllIIIIll;
                }
            }
            else {
                final Long llllllllllllllIllIlllIIIllIIIIlI = Long.valueOf(llllllllllllllIllIlllIIIlIlllllI);
                if (llllllllllllllIllIlllIIIlIlllllI.equals(llllllllllllllIllIlllIIIllIIIIlI.toString())) {
                    if (llllllllllllllIllIlllIIIllIIIIlI == llllllllllllllIllIlllIIIllIIIIlI.intValue()) {
                        return llllllllllllllIllIlllIIIllIIIIlI.intValue();
                    }
                    return llllllllllllllIllIlllIIIllIIIIlI;
                }
            }
        }
        catch (Exception ex) {}
        return llllllllllllllIllIlllIIIlIlllllI;
    }
    
    public static String toString(final Object llllllllllllllIllIlllIIIlIIlIlIl) throws JSONException {
        return toString(llllllllllllllIllIlllIIIlIIlIlIl, null, XMLParserConfiguration.ORIGINAL);
    }
    
    private static boolean parse(final XMLTokener llllllllllllllIllIlllIIIllIllIII, final JSONObject llllllllllllllIllIlllIIIllIlIlll, final String llllllllllllllIllIlllIIIllIlIllI, final XMLParserConfiguration llllllllllllllIllIlllIIIllIIlllI) throws JSONException {
        JSONObject llllllllllllllIllIlllIIIllIlIlII = null;
        Object llllllllllllllIllIlllIIIllIlIIlI = llllllllllllllIllIlllIIIllIllIII.nextToken();
        if (llllllllllllllIllIlllIIIllIlIIlI == XML.BANG) {
            final char llllllllllllllIllIlllIIIllIlllIl = llllllllllllllIllIlllIIIllIllIII.next();
            if (llllllllllllllIllIlllIIIllIlllIl == '-') {
                if (llllllllllllllIllIlllIIIllIllIII.next() == '-') {
                    llllllllllllllIllIlllIIIllIllIII.skipPast("-->");
                    return false;
                }
                llllllllllllllIllIlllIIIllIllIII.back();
            }
            else if (llllllllllllllIllIlllIIIllIlllIl == '[') {
                llllllllllllllIllIlllIIIllIlIIlI = llllllllllllllIllIlllIIIllIllIII.nextToken();
                if ("CDATA".equals(llllllllllllllIllIlllIIIllIlIIlI) && llllllllllllllIllIlllIIIllIllIII.next() == '[') {
                    final String llllllllllllllIllIlllIIIllIllllI = llllllllllllllIllIlllIIIllIllIII.nextCDATA();
                    if (llllllllllllllIllIlllIIIllIllllI.length() > 0) {
                        llllllllllllllIllIlllIIIllIlIlll.accumulate(llllllllllllllIllIlllIIIllIIlllI.cDataTagName, llllllllllllllIllIlllIIIllIllllI);
                    }
                    return false;
                }
                throw llllllllllllllIllIlllIIIllIllIII.syntaxError("Expected 'CDATA['");
            }
            int llllllllllllllIllIlllIIIllIlllII = 1;
            do {
                llllllllllllllIllIlllIIIllIlIIlI = llllllllllllllIllIlllIIIllIllIII.nextMeta();
                if (llllllllllllllIllIlllIIIllIlIIlI == null) {
                    throw llllllllllllllIllIlllIIIllIllIII.syntaxError("Missing '>' after '<!'.");
                }
                if (llllllllllllllIllIlllIIIllIlIIlI == XML.LT) {
                    ++llllllllllllllIllIlllIIIllIlllII;
                }
                else {
                    if (llllllllllllllIllIlllIIIllIlIIlI != XML.GT) {
                        continue;
                    }
                    --llllllllllllllIllIlllIIIllIlllII;
                }
            } while (llllllllllllllIllIlllIIIllIlllII > 0);
            return false;
        }
        if (llllllllllllllIllIlllIIIllIlIIlI == XML.QUEST) {
            llllllllllllllIllIlllIIIllIllIII.skipPast("?>");
            return false;
        }
        if (llllllllllllllIllIlllIIIllIlIIlI == XML.SLASH) {
            llllllllllllllIllIlllIIIllIlIIlI = llllllllllllllIllIlllIIIllIllIII.nextToken();
            if (llllllllllllllIllIlllIIIllIlIllI == null) {
                throw llllllllllllllIllIlllIIIllIllIII.syntaxError(String.valueOf(new StringBuilder().append("Mismatched close tag ").append(llllllllllllllIllIlllIIIllIlIIlI)));
            }
            if (!llllllllllllllIllIlllIIIllIlIIlI.equals(llllllllllllllIllIlllIIIllIlIllI)) {
                throw llllllllllllllIllIlllIIIllIllIII.syntaxError(String.valueOf(new StringBuilder().append("Mismatched ").append(llllllllllllllIllIlllIIIllIlIllI).append(" and ").append(llllllllllllllIllIlllIIIllIlIIlI)));
            }
            if (llllllllllllllIllIlllIIIllIllIII.nextToken() != XML.GT) {
                throw llllllllllllllIllIlllIIIllIllIII.syntaxError("Misshaped close tag");
            }
            return true;
        }
        else {
            if (llllllllllllllIllIlllIIIllIlIIlI instanceof Character) {
                throw llllllllllllllIllIlllIIIllIllIII.syntaxError("Misshaped tag");
            }
            final String llllllllllllllIllIlllIIIllIlIIll = (String)llllllllllllllIllIlllIIIllIlIIlI;
            llllllllllllllIllIlllIIIllIlIIlI = null;
            llllllllllllllIllIlllIIIllIlIlII = new JSONObject();
            boolean llllllllllllllIllIlllIIIllIllIIl = false;
            while (true) {
                if (llllllllllllllIllIlllIIIllIlIIlI == null) {
                    llllllllllllllIllIlllIIIllIlIIlI = llllllllllllllIllIlllIIIllIllIII.nextToken();
                }
                if (llllllllllllllIllIlllIIIllIlIIlI instanceof String) {
                    final String llllllllllllllIllIlllIIIllIllIll = (String)llllllllllllllIllIlllIIIllIlIIlI;
                    llllllllllllllIllIlllIIIllIlIIlI = llllllllllllllIllIlllIIIllIllIII.nextToken();
                    if (llllllllllllllIllIlllIIIllIlIIlI == XML.EQ) {
                        llllllllllllllIllIlllIIIllIlIIlI = llllllllllllllIllIlllIIIllIllIII.nextToken();
                        if (!(llllllllllllllIllIlllIIIllIlIIlI instanceof String)) {
                            throw llllllllllllllIllIlllIIIllIllIII.syntaxError("Missing value");
                        }
                        if (llllllllllllllIllIlllIIIllIIlllI.convertNilAttributeToNull && "xsi:nil".equals(llllllllllllllIllIlllIIIllIllIll) && Boolean.parseBoolean((String)llllllllllllllIllIlllIIIllIlIIlI)) {
                            llllllllllllllIllIlllIIIllIllIIl = true;
                        }
                        else if (!llllllllllllllIllIlllIIIllIllIIl) {
                            llllllllllllllIllIlllIIIllIlIlII.accumulate(llllllllllllllIllIlllIIIllIllIll, llllllllllllllIllIlllIIIllIIlllI.keepStrings ? ((String)llllllllllllllIllIlllIIIllIlIIlI) : stringToValue((String)llllllllllllllIllIlllIIIllIlIIlI));
                        }
                        llllllllllllllIllIlllIIIllIlIIlI = null;
                    }
                    else {
                        llllllllllllllIllIlllIIIllIlIlII.accumulate(llllllllllllllIllIlllIIIllIllIll, "");
                    }
                }
                else if (llllllllllllllIllIlllIIIllIlIIlI == XML.SLASH) {
                    if (llllllllllllllIllIlllIIIllIllIII.nextToken() != XML.GT) {
                        throw llllllllllllllIllIlllIIIllIllIII.syntaxError("Misshaped tag");
                    }
                    if (llllllllllllllIllIlllIIIllIllIIl) {
                        llllllllllllllIllIlllIIIllIlIlll.accumulate(llllllllllllllIllIlllIIIllIlIIll, JSONObject.NULL);
                    }
                    else if (llllllllllllllIllIlllIIIllIlIlII.length() > 0) {
                        llllllllllllllIllIlllIIIllIlIlll.accumulate(llllllllllllllIllIlllIIIllIlIIll, llllllllllllllIllIlllIIIllIlIlII);
                    }
                    else {
                        llllllllllllllIllIlllIIIllIlIlll.accumulate(llllllllllllllIllIlllIIIllIlIIll, "");
                    }
                    return false;
                }
                else {
                    if (llllllllllllllIllIlllIIIllIlIIlI != XML.GT) {
                        throw llllllllllllllIllIlllIIIllIllIII.syntaxError("Misshaped tag");
                    }
                    while (true) {
                        llllllllllllllIllIlllIIIllIlIIlI = llllllllllllllIllIlllIIIllIllIII.nextContent();
                        if (llllllllllllllIllIlllIIIllIlIIlI == null) {
                            if (llllllllllllllIllIlllIIIllIlIIll != null) {
                                throw llllllllllllllIllIlllIIIllIllIII.syntaxError(String.valueOf(new StringBuilder().append("Unclosed tag ").append(llllllllllllllIllIlllIIIllIlIIll)));
                            }
                            return false;
                        }
                        else if (llllllllllllllIllIlllIIIllIlIIlI instanceof String) {
                            final String llllllllllllllIllIlllIIIllIllIlI = (String)llllllllllllllIllIlllIIIllIlIIlI;
                            if (llllllllllllllIllIlllIIIllIllIlI.length() <= 0) {
                                continue;
                            }
                            llllllllllllllIllIlllIIIllIlIlII.accumulate(llllllllllllllIllIlllIIIllIIlllI.cDataTagName, llllllllllllllIllIlllIIIllIIlllI.keepStrings ? llllllllllllllIllIlllIIIllIllIlI : stringToValue(llllllllllllllIllIlllIIIllIllIlI));
                        }
                        else {
                            if (llllllllllllllIllIlllIIIllIlIIlI == XML.LT && parse(llllllllllllllIllIlllIIIllIllIII, llllllllllllllIllIlllIIIllIlIlII, llllllllllllllIllIlllIIIllIlIIll, llllllllllllllIllIlllIIIllIIlllI)) {
                                if (llllllllllllllIllIlllIIIllIlIlII.length() == 0) {
                                    llllllllllllllIllIlllIIIllIlIlll.accumulate(llllllllllllllIllIlllIIIllIlIIll, "");
                                }
                                else if (llllllllllllllIllIlllIIIllIlIlII.length() == 1 && llllllllllllllIllIlllIIIllIlIlII.opt(llllllllllllllIllIlllIIIllIIlllI.cDataTagName) != null) {
                                    llllllllllllllIllIlllIIIllIlIlll.accumulate(llllllllllllllIllIlllIIIllIlIIll, llllllllllllllIllIlllIIIllIlIlII.opt(llllllllllllllIllIlllIIIllIIlllI.cDataTagName));
                                }
                                else {
                                    llllllllllllllIllIlllIIIllIlIlll.accumulate(llllllllllllllIllIlllIIIllIlIIll, llllllllllllllIllIlllIIIllIlIlII);
                                }
                                return false;
                            }
                            continue;
                        }
                    }
                }
            }
        }
    }
    
    public static String unescape(final String llllllllllllllIllIlllIIIlllllIIl) {
        final StringBuilder llllllllllllllIllIlllIIIlllllIlI = new StringBuilder(llllllllllllllIllIlllIIIlllllIIl.length());
        for (int llllllllllllllIllIlllIIIllllllIl = 0, llllllllllllllIllIlllIIIllllllII = llllllllllllllIllIlllIIIlllllIIl.length(); llllllllllllllIllIlllIIIllllllIl < llllllllllllllIllIlllIIIllllllII; ++llllllllllllllIllIlllIIIllllllIl) {
            final char llllllllllllllIllIlllIIIlllllllI = llllllllllllllIllIlllIIIlllllIIl.charAt(llllllllllllllIllIlllIIIllllllIl);
            if (llllllllllllllIllIlllIIIlllllllI == '&') {
                final int llllllllllllllIllIlllIIIllllllll = llllllllllllllIllIlllIIIlllllIIl.indexOf(59, llllllllllllllIllIlllIIIllllllIl);
                if (llllllllllllllIllIlllIIIllllllll > llllllllllllllIllIlllIIIllllllIl) {
                    final String llllllllllllllIllIlllIIlIIIIIIII = llllllllllllllIllIlllIIIlllllIIl.substring(llllllllllllllIllIlllIIIllllllIl + 1, llllllllllllllIllIlllIIIllllllll);
                    llllllllllllllIllIlllIIIlllllIlI.append(XMLTokener.unescapeEntity(llllllllllllllIllIlllIIlIIIIIIII));
                    llllllllllllllIllIlllIIIllllllIl += llllllllllllllIllIlllIIlIIIIIIII.length() + 1;
                }
                else {
                    llllllllllllllIllIlllIIIlllllIlI.append(llllllllllllllIllIlllIIIlllllllI);
                }
            }
            else {
                llllllllllllllIllIlllIIIlllllIlI.append(llllllllllllllIllIlllIIIlllllllI);
            }
        }
        return String.valueOf(llllllllllllllIllIlllIIIlllllIlI);
    }
    
    public static JSONObject toJSONObject(final String llllllllllllllIllIlllIIIlIlIIIIl, final boolean llllllllllllllIllIlllIIIlIlIIIII) throws JSONException {
        return toJSONObject(new StringReader(llllllllllllllIllIlllIIIlIlIIIIl), llllllllllllllIllIlllIIIlIlIIIII);
    }
    
    public static JSONObject toJSONObject(final String llllllllllllllIllIlllIIIlIlllIlI) throws JSONException {
        return toJSONObject(llllllllllllllIllIlllIIIlIlllIlI, XMLParserConfiguration.ORIGINAL);
    }
    
    public static JSONObject toJSONObject(final String llllllllllllllIllIlllIIIlIIllIll, final XMLParserConfiguration llllllllllllllIllIlllIIIlIIllIII) throws JSONException {
        return toJSONObject(new StringReader(llllllllllllllIllIlllIIIlIIllIll), llllllllllllllIllIlllIIIlIIllIII);
    }
    
    static {
        NULL_ATTR = "xsi:nil";
        AMP = '&';
        APOS = '\'';
        BANG = '!';
        EQ = '=';
        GT = '>';
        LT = '<';
        QUEST = '?';
        QUOT = '\"';
        SLASH = '/';
    }
    
    public static JSONObject toJSONObject(final Reader llllllllllllllIllIlllIIIlIllIIIl, final boolean llllllllllllllIllIlllIIIlIllIIlI) throws JSONException {
        if (llllllllllllllIllIlllIIIlIllIIlI) {
            return toJSONObject(llllllllllllllIllIlllIIIlIllIIIl, XMLParserConfiguration.KEEP_STRINGS);
        }
        return toJSONObject(llllllllllllllIllIlllIIIlIllIIIl, XMLParserConfiguration.ORIGINAL);
    }
    
    private static Iterable<Integer> codePointIterator(final String llllllllllllllIllIlllIIlIIIlIllI) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    private /* synthetic */ int length = llllllllllllllIllIlllIIlIIIlIllI.length();
                    private /* synthetic */ int nextIndex = 0;
                    
                    @Override
                    public Integer next() {
                        final int llllllllllllllIIIIIIllllIIlIlIIl = llllllllllllllIllIlllIIlIIIlIllI.codePointAt(this.nextIndex);
                        this.nextIndex += Character.charCount(llllllllllllllIIIIIIllllIIlIlIIl);
                        return llllllllllllllIIIIIIllllIIlIlIIl;
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.nextIndex < this.length;
                    }
                    
                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
    
    public static JSONObject toJSONObject(final Reader llllllllllllllIllIlllIIIlIllIlll) throws JSONException {
        return toJSONObject(llllllllllllllIllIlllIIIlIllIlll, XMLParserConfiguration.ORIGINAL);
    }
    
    public static JSONObject toJSONObject(final Reader llllllllllllllIllIlllIIIlIlIlIll, final XMLParserConfiguration llllllllllllllIllIlllIIIlIlIlIlI) throws JSONException {
        final JSONObject llllllllllllllIllIlllIIIlIlIlIIl = new JSONObject();
        final XMLTokener llllllllllllllIllIlllIIIlIlIlIII = new XMLTokener(llllllllllllllIllIlllIIIlIlIlIll);
        while (llllllllllllllIllIlllIIIlIlIlIII.more()) {
            llllllllllllllIllIlllIIIlIlIlIII.skipPast("<");
            if (llllllllllllllIllIlllIIIlIlIlIII.more()) {
                parse(llllllllllllllIllIlllIIIlIlIlIII, llllllllllllllIllIlllIIIlIlIlIIl, null, llllllllllllllIllIlllIIIlIlIlIlI);
            }
        }
        return llllllllllllllIllIlllIIIlIlIlIIl;
    }
    
    public static void noSpace(final String llllllllllllllIllIlllIIIlllIllll) throws JSONException {
        final int llllllllllllllIllIlllIIIlllIllIl = llllllllllllllIllIlllIIIlllIllll.length();
        if (llllllllllllllIllIlllIIIlllIllIl == 0) {
            throw new JSONException("Empty string.");
        }
        for (int llllllllllllllIllIlllIIIlllIlllI = 0; llllllllllllllIllIlllIIIlllIlllI < llllllllllllllIllIlllIIIlllIllIl; ++llllllllllllllIllIlllIIIlllIlllI) {
            if (Character.isWhitespace(llllllllllllllIllIlllIIIlllIllll.charAt(llllllllllllllIllIlllIIIlllIlllI))) {
                throw new JSONException(String.valueOf(new StringBuilder().append("'").append(llllllllllllllIllIlllIIIlllIllll).append("' contains a space character.")));
            }
        }
    }
    
    private static boolean mustEscape(final int llllllllllllllIllIlllIIlIIIIlIII) {
        return (Character.isISOControl(llllllllllllllIllIlllIIlIIIIlIII) && llllllllllllllIllIlllIIlIIIIlIII != 9 && llllllllllllllIllIlllIIlIIIIlIII != 10 && llllllllllllllIllIlllIIlIIIIlIII != 13) || ((llllllllllllllIllIlllIIlIIIIlIII < 32 || llllllllllllllIllIlllIIlIIIIlIII > 55295) && (llllllllllllllIllIlllIIlIIIIlIII < 57344 || llllllllllllllIllIlllIIlIIIIlIII > 65533) && (llllllllllllllIllIlllIIlIIIIlIII < 65536 || llllllllllllllIllIlllIIlIIIIlIII > 1114111));
    }
    
    public static String toString(final Object llllllllllllllIllIlllIIIlIIlIIII, final String llllllllllllllIllIlllIIIlIIlIIIl) {
        return toString(llllllllllllllIllIlllIIIlIIlIIII, llllllllllllllIllIlllIIIlIIlIIIl, XMLParserConfiguration.ORIGINAL);
    }
    
    public static String escape(final String llllllllllllllIllIlllIIlIIIlIIII) {
        final StringBuilder llllllllllllllIllIlllIIlIIIIllll = new StringBuilder(llllllllllllllIllIlllIIlIIIlIIII.length());
        for (final int llllllllllllllIllIlllIIlIIIlIIIl : codePointIterator(llllllllllllllIllIlllIIlIIIlIIII)) {
            switch (llllllllllllllIllIlllIIlIIIlIIIl) {
                case 38: {
                    llllllllllllllIllIlllIIlIIIIllll.append("&amp;");
                    continue;
                }
                case 60: {
                    llllllllllllllIllIlllIIlIIIIllll.append("&lt;");
                    continue;
                }
                case 62: {
                    llllllllllllllIllIlllIIlIIIIllll.append("&gt;");
                    continue;
                }
                case 34: {
                    llllllllllllllIllIlllIIlIIIIllll.append("&quot;");
                    continue;
                }
                case 39: {
                    llllllllllllllIllIlllIIlIIIIllll.append("&apos;");
                    continue;
                }
                default: {
                    if (mustEscape(llllllllllllllIllIlllIIlIIIlIIIl)) {
                        llllllllllllllIllIlllIIlIIIIllll.append("&#x");
                        llllllllllllllIllIlllIIlIIIIllll.append(Integer.toHexString(llllllllllllllIllIlllIIlIIIlIIIl));
                        llllllllllllllIllIlllIIlIIIIllll.append(';');
                        continue;
                    }
                    llllllllllllllIllIlllIIlIIIIllll.appendCodePoint(llllllllllllllIllIlllIIlIIIlIIIl);
                    continue;
                }
            }
        }
        return String.valueOf(llllllllllllllIllIlllIIlIIIIllll);
    }
    
    public static String toString(final Object llllllllllllllIllIlllIIIIlllIIIl, final String llllllllllllllIllIlllIIIIllIlIll, final XMLParserConfiguration llllllllllllllIllIlllIIIIllIllll) throws JSONException {
        final StringBuilder llllllllllllllIllIlllIIIIllIlllI = new StringBuilder();
        if (llllllllllllllIllIlllIIIIlllIIIl instanceof JSONObject) {
            if (llllllllllllllIllIlllIIIIllIlIll != null) {
                llllllllllllllIllIlllIIIIllIlllI.append('<');
                llllllllllllllIllIlllIIIIllIlllI.append(llllllllllllllIllIlllIIIIllIlIll);
                llllllllllllllIllIlllIIIIllIlllI.append('>');
            }
            final JSONObject llllllllllllllIllIlllIIIIlllIlll = (JSONObject)llllllllllllllIllIlllIIIIlllIIIl;
            for (final String llllllllllllllIllIlllIIIIllllIII : llllllllllllllIllIlllIIIIlllIlll.keySet()) {
                Object llllllllllllllIllIlllIIIIllllIIl = llllllllllllllIllIlllIIIIlllIlll.opt(llllllllllllllIllIlllIIIIllllIII);
                if (llllllllllllllIllIlllIIIIllllIIl == null) {
                    llllllllllllllIllIlllIIIIllllIIl = "";
                }
                else if (llllllllllllllIllIlllIIIIllllIIl.getClass().isArray()) {
                    llllllllllllllIllIlllIIIIllllIIl = new JSONArray(llllllllllllllIllIlllIIIIllllIIl);
                }
                if (llllllllllllllIllIlllIIIIllllIII.equals(llllllllllllllIllIlllIIIIllIllll.cDataTagName)) {
                    if (llllllllllllllIllIlllIIIIllllIIl instanceof JSONArray) {
                        final JSONArray llllllllllllllIllIlllIIIIllllllI = (JSONArray)llllllllllllllIllIlllIIIIllllIIl;
                        for (int llllllllllllllIllIlllIIIIlllllll = llllllllllllllIllIlllIIIIllllllI.length(), llllllllllllllIllIlllIIIlIIIIIII = 0; llllllllllllllIllIlllIIIlIIIIIII < llllllllllllllIllIlllIIIIlllllll; ++llllllllllllllIllIlllIIIlIIIIIII) {
                            if (llllllllllllllIllIlllIIIlIIIIIII > 0) {
                                llllllllllllllIllIlllIIIIllIlllI.append('\n');
                            }
                            final Object llllllllllllllIllIlllIIIlIIIIIIl = llllllllllllllIllIlllIIIIllllllI.opt(llllllllllllllIllIlllIIIlIIIIIII);
                            llllllllllllllIllIlllIIIIllIlllI.append(escape(llllllllllllllIllIlllIIIlIIIIIIl.toString()));
                        }
                    }
                    else {
                        llllllllllllllIllIlllIIIIllIlllI.append(escape(llllllllllllllIllIlllIIIIllllIIl.toString()));
                    }
                }
                else if (llllllllllllllIllIlllIIIIllllIIl instanceof JSONArray) {
                    final JSONArray llllllllllllllIllIlllIIIIllllIlI = (JSONArray)llllllllllllllIllIlllIIIIllllIIl;
                    for (int llllllllllllllIllIlllIIIIllllIll = llllllllllllllIllIlllIIIIllllIlI.length(), llllllllllllllIllIlllIIIIlllllII = 0; llllllllllllllIllIlllIIIIlllllII < llllllllllllllIllIlllIIIIllllIll; ++llllllllllllllIllIlllIIIIlllllII) {
                        final Object llllllllllllllIllIlllIIIIlllllIl = llllllllllllllIllIlllIIIIllllIlI.opt(llllllllllllllIllIlllIIIIlllllII);
                        if (llllllllllllllIllIlllIIIIlllllIl instanceof JSONArray) {
                            llllllllllllllIllIlllIIIIllIlllI.append('<');
                            llllllllllllllIllIlllIIIIllIlllI.append(llllllllllllllIllIlllIIIIllllIII);
                            llllllllllllllIllIlllIIIIllIlllI.append('>');
                            llllllllllllllIllIlllIIIIllIlllI.append(toString(llllllllllllllIllIlllIIIIlllllIl, null, llllllllllllllIllIlllIIIIllIllll));
                            llllllllllllllIllIlllIIIIllIlllI.append("</");
                            llllllllllllllIllIlllIIIIllIlllI.append(llllllllllllllIllIlllIIIIllllIII);
                            llllllllllllllIllIlllIIIIllIlllI.append('>');
                        }
                        else {
                            llllllllllllllIllIlllIIIIllIlllI.append(toString(llllllllllllllIllIlllIIIIlllllIl, llllllllllllllIllIlllIIIIllllIII, llllllllllllllIllIlllIIIIllIllll));
                        }
                    }
                }
                else if ("".equals(llllllllllllllIllIlllIIIIllllIIl)) {
                    llllllllllllllIllIlllIIIIllIlllI.append('<');
                    llllllllllllllIllIlllIIIIllIlllI.append(llllllllllllllIllIlllIIIIllllIII);
                    llllllllllllllIllIlllIIIIllIlllI.append("/>");
                }
                else {
                    llllllllllllllIllIlllIIIIllIlllI.append(toString(llllllllllllllIllIlllIIIIllllIIl, llllllllllllllIllIlllIIIIllllIII, llllllllllllllIllIlllIIIIllIllll));
                }
            }
            if (llllllllllllllIllIlllIIIIllIlIll != null) {
                llllllllllllllIllIlllIIIIllIlllI.append("</");
                llllllllllllllIllIlllIIIIllIlllI.append(llllllllllllllIllIlllIIIIllIlIll);
                llllllllllllllIllIlllIIIIllIlllI.append('>');
            }
            return String.valueOf(llllllllllllllIllIlllIIIIllIlllI);
        }
        if (llllllllllllllIllIlllIIIIlllIIIl != null && (llllllllllllllIllIlllIIIIlllIIIl instanceof JSONArray || llllllllllllllIllIlllIIIIlllIIIl.getClass().isArray())) {
            JSONArray llllllllllllllIllIlllIIIIlllIIlI = null;
            if (llllllllllllllIllIlllIIIIlllIIIl.getClass().isArray()) {
                final JSONArray llllllllllllllIllIlllIIIIlllIllI = new JSONArray(llllllllllllllIllIlllIIIIlllIIIl);
            }
            else {
                llllllllllllllIllIlllIIIIlllIIlI = (JSONArray)llllllllllllllIllIlllIIIIlllIIIl;
            }
            for (int llllllllllllllIllIlllIIIIlllIIll = llllllllllllllIllIlllIIIIlllIIlI.length(), llllllllllllllIllIlllIIIIlllIlII = 0; llllllllllllllIllIlllIIIIlllIlII < llllllllllllllIllIlllIIIIlllIIll; ++llllllllllllllIllIlllIIIIlllIlII) {
                final Object llllllllllllllIllIlllIIIIlllIlIl = llllllllllllllIllIlllIIIIlllIIlI.opt(llllllllllllllIllIlllIIIIlllIlII);
                llllllllllllllIllIlllIIIIllIlllI.append(toString(llllllllllllllIllIlllIIIIlllIlIl, (llllllllllllllIllIlllIIIIllIlIll == null) ? "array" : llllllllllllllIllIlllIIIIllIlIll, llllllllllllllIllIlllIIIIllIllll));
            }
            return String.valueOf(llllllllllllllIllIlllIIIIllIlllI);
        }
        final String llllllllllllllIllIlllIIIIllIllIl = (llllllllllllllIllIlllIIIIlllIIIl == null) ? "null" : escape(llllllllllllllIllIlllIIIIlllIIIl.toString());
        return (llllllllllllllIllIlllIIIIllIlIll == null) ? String.valueOf(new StringBuilder().append("\"").append(llllllllllllllIllIlllIIIIllIllIl).append("\"")) : ((llllllllllllllIllIlllIIIIllIllIl.length() == 0) ? String.valueOf(new StringBuilder().append("<").append(llllllllllllllIllIlllIIIIllIlIll).append("/>")) : String.valueOf(new StringBuilder().append("<").append(llllllllllllllIllIlllIIIIllIlIll).append(">").append(llllllllllllllIllIlllIIIIllIllIl).append("</").append(llllllllllllllIllIlllIIIIllIlIll).append(">")));
    }
}
