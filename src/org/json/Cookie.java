package org.json;

public class Cookie
{
    public static String toString(final JSONObject lllllllllllllllIIIIllIlllIIlIlII) throws JSONException {
        final StringBuilder lllllllllllllllIIIIllIlllIIlIlIl = new StringBuilder();
        lllllllllllllllIIIIllIlllIIlIlIl.append(escape(lllllllllllllllIIIIllIlllIIlIlII.getString("name")));
        lllllllllllllllIIIIllIlllIIlIlIl.append("=");
        lllllllllllllllIIIIllIlllIIlIlIl.append(escape(lllllllllllllllIIIIllIlllIIlIlII.getString("value")));
        if (lllllllllllllllIIIIllIlllIIlIlII.has("expires")) {
            lllllllllllllllIIIIllIlllIIlIlIl.append(";expires=");
            lllllllllllllllIIIIllIlllIIlIlIl.append(lllllllllllllllIIIIllIlllIIlIlII.getString("expires"));
        }
        if (lllllllllllllllIIIIllIlllIIlIlII.has("domain")) {
            lllllllllllllllIIIIllIlllIIlIlIl.append(";domain=");
            lllllllllllllllIIIIllIlllIIlIlIl.append(escape(lllllllllllllllIIIIllIlllIIlIlII.getString("domain")));
        }
        if (lllllllllllllllIIIIllIlllIIlIlII.has("path")) {
            lllllllllllllllIIIIllIlllIIlIlIl.append(";path=");
            lllllllllllllllIIIIllIlllIIlIlIl.append(escape(lllllllllllllllIIIIllIlllIIlIlII.getString("path")));
        }
        if (lllllllllllllllIIIIllIlllIIlIlII.optBoolean("secure")) {
            lllllllllllllllIIIIllIlllIIlIlIl.append(";secure");
        }
        return String.valueOf(lllllllllllllllIIIIllIlllIIlIlIl);
    }
    
    public static String unescape(final String lllllllllllllllIIIIllIlllIIIIlll) {
        final int lllllllllllllllIIIIllIlllIIIIllI = lllllllllllllllIIIIllIlllIIIIlll.length();
        final StringBuilder lllllllllllllllIIIIllIlllIIIIlIl = new StringBuilder(lllllllllllllllIIIIllIlllIIIIllI);
        for (int lllllllllllllllIIIIllIlllIIIlIII = 0; lllllllllllllllIIIIllIlllIIIlIII < lllllllllllllllIIIIllIlllIIIIllI; ++lllllllllllllllIIIIllIlllIIIlIII) {
            char lllllllllllllllIIIIllIlllIIIlIIl = lllllllllllllllIIIIllIlllIIIIlll.charAt(lllllllllllllllIIIIllIlllIIIlIII);
            if (lllllllllllllllIIIIllIlllIIIlIIl == '+') {
                lllllllllllllllIIIIllIlllIIIlIIl = ' ';
            }
            else if (lllllllllllllllIIIIllIlllIIIlIIl == '%' && lllllllllllllllIIIIllIlllIIIlIII + 2 < lllllllllllllllIIIIllIlllIIIIllI) {
                final int lllllllllllllllIIIIllIlllIIIlIll = JSONTokener.dehexchar(lllllllllllllllIIIIllIlllIIIIlll.charAt(lllllllllllllllIIIIllIlllIIIlIII + 1));
                final int lllllllllllllllIIIIllIlllIIIlIlI = JSONTokener.dehexchar(lllllllllllllllIIIIllIlllIIIIlll.charAt(lllllllllllllllIIIIllIlllIIIlIII + 2));
                if (lllllllllllllllIIIIllIlllIIIlIll >= 0 && lllllllllllllllIIIIllIlllIIIlIlI >= 0) {
                    lllllllllllllllIIIIllIlllIIIlIIl = (char)(lllllllllllllllIIIIllIlllIIIlIll * 16 + lllllllllllllllIIIIllIlllIIIlIlI);
                    lllllllllllllllIIIIllIlllIIIlIII += 2;
                }
            }
            lllllllllllllllIIIIllIlllIIIIlIl.append(lllllllllllllllIIIIllIlllIIIlIIl);
        }
        return String.valueOf(lllllllllllllllIIIIllIlllIIIIlIl);
    }
    
    public static String escape(final String lllllllllllllllIIIIllIlllIlIlllI) {
        final String lllllllllllllllIIIIllIlllIllIIIl = lllllllllllllllIIIIllIlllIlIlllI.trim();
        final int lllllllllllllllIIIIllIlllIllIIII = lllllllllllllllIIIIllIlllIllIIIl.length();
        final StringBuilder lllllllllllllllIIIIllIlllIlIllll = new StringBuilder(lllllllllllllllIIIIllIlllIllIIII);
        for (int lllllllllllllllIIIIllIlllIllIIll = 0; lllllllllllllllIIIIllIlllIllIIll < lllllllllllllllIIIIllIlllIllIIII; ++lllllllllllllllIIIIllIlllIllIIll) {
            final char lllllllllllllllIIIIllIlllIllIlII = lllllllllllllllIIIIllIlllIllIIIl.charAt(lllllllllllllllIIIIllIlllIllIIll);
            if (lllllllllllllllIIIIllIlllIllIlII < ' ' || lllllllllllllllIIIIllIlllIllIlII == '+' || lllllllllllllllIIIIllIlllIllIlII == '%' || lllllllllllllllIIIIllIlllIllIlII == '=' || lllllllllllllllIIIIllIlllIllIlII == ';') {
                lllllllllllllllIIIIllIlllIlIllll.append('%');
                lllllllllllllllIIIIllIlllIlIllll.append(Character.forDigit((char)(lllllllllllllllIIIIllIlllIllIlII >>> 4 & 0xF), 16));
                lllllllllllllllIIIIllIlllIlIllll.append(Character.forDigit((char)(lllllllllllllllIIIIllIlllIllIlII & '\u000f'), 16));
            }
            else {
                lllllllllllllllIIIIllIlllIlIllll.append(lllllllllllllllIIIIllIlllIllIlII);
            }
        }
        return String.valueOf(lllllllllllllllIIIIllIlllIlIllll);
    }
    
    public static JSONObject toJSONObject(final String lllllllllllllllIIIIllIlllIlIIIII) throws JSONException {
        final JSONObject lllllllllllllllIIIIllIlllIIlllll = new JSONObject();
        final JSONTokener lllllllllllllllIIIIllIlllIIllllI = new JSONTokener(lllllllllllllllIIIIllIlllIlIIIII);
        lllllllllllllllIIIIllIlllIIlllll.put("name", lllllllllllllllIIIIllIlllIIllllI.nextTo('='));
        lllllllllllllllIIIIllIlllIIllllI.next('=');
        lllllllllllllllIIIIllIlllIIlllll.put("value", lllllllllllllllIIIIllIlllIIllllI.nextTo(';'));
        lllllllllllllllIIIIllIlllIIllllI.next();
        while (lllllllllllllllIIIIllIlllIIllllI.more()) {
            final String lllllllllllllllIIIIllIlllIlIIIlI = unescape(lllllllllllllllIIIIllIlllIIllllI.nextTo("=;"));
            Object lllllllllllllllIIIIllIlllIlIIIIl = null;
            if (lllllllllllllllIIIIllIlllIIllllI.next() != '=') {
                if (!lllllllllllllllIIIIllIlllIlIIIlI.equals("secure")) {
                    throw lllllllllllllllIIIIllIlllIIllllI.syntaxError("Missing '=' in cookie parameter.");
                }
                final Object lllllllllllllllIIIIllIlllIlIIIll = Boolean.TRUE;
            }
            else {
                lllllllllllllllIIIIllIlllIlIIIIl = unescape(lllllllllllllllIIIIllIlllIIllllI.nextTo(';'));
                lllllllllllllllIIIIllIlllIIllllI.next();
            }
            lllllllllllllllIIIIllIlllIIlllll.put(lllllllllllllllIIIIllIlllIlIIIlI, lllllllllllllllIIIIllIlllIlIIIIl);
        }
        return lllllllllllllllIIIIllIlllIIlllll;
    }
}
