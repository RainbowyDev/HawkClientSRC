package org.json;

import java.util.*;

public class HTTP
{
    static {
        CRLF = "\r\n";
    }
    
    public static JSONObject toJSONObject(final String llllllllllllllIIlIllIlllIlllIIII) throws JSONException {
        final JSONObject llllllllllllllIIlIllIlllIllIllll = new JSONObject();
        final HTTPTokener llllllllllllllIIlIllIlllIllIlllI = new HTTPTokener(llllllllllllllIIlIllIlllIlllIIII);
        final String llllllllllllllIIlIllIlllIllIllIl = llllllllllllllIIlIllIlllIllIlllI.nextToken();
        if (llllllllllllllIIlIllIlllIllIllIl.toUpperCase(Locale.ROOT).startsWith("HTTP")) {
            llllllllllllllIIlIllIlllIllIllll.put("HTTP-Version", llllllllllllllIIlIllIlllIllIllIl);
            llllllllllllllIIlIllIlllIllIllll.put("Status-Code", llllllllllllllIIlIllIlllIllIlllI.nextToken());
            llllllllllllllIIlIllIlllIllIllll.put("Reason-Phrase", llllllllllllllIIlIllIlllIllIlllI.nextTo('\0'));
            llllllllllllllIIlIllIlllIllIlllI.next();
        }
        else {
            llllllllllllllIIlIllIlllIllIllll.put("Method", llllllllllllllIIlIllIlllIllIllIl);
            llllllllllllllIIlIllIlllIllIllll.put("Request-URI", llllllllllllllIIlIllIlllIllIlllI.nextToken());
            llllllllllllllIIlIllIlllIllIllll.put("HTTP-Version", llllllllllllllIIlIllIlllIllIlllI.nextToken());
        }
        while (llllllllllllllIIlIllIlllIllIlllI.more()) {
            final String llllllllllllllIIlIllIlllIlllIIIl = llllllllllllllIIlIllIlllIllIlllI.nextTo(':');
            llllllllllllllIIlIllIlllIllIlllI.next(':');
            llllllllllllllIIlIllIlllIllIllll.put(llllllllllllllIIlIllIlllIlllIIIl, llllllllllllllIIlIllIlllIllIlllI.nextTo('\0'));
            llllllllllllllIIlIllIlllIllIlllI.next();
        }
        return llllllllllllllIIlIllIlllIllIllll;
    }
    
    public static String toString(final JSONObject llllllllllllllIIlIllIlllIllIIIII) throws JSONException {
        final StringBuilder llllllllllllllIIlIllIlllIlIlllll = new StringBuilder();
        if (llllllllllllllIIlIllIlllIllIIIII.has("Status-Code") && llllllllllllllIIlIllIlllIllIIIII.has("Reason-Phrase")) {
            llllllllllllllIIlIllIlllIlIlllll.append(llllllllllllllIIlIllIlllIllIIIII.getString("HTTP-Version"));
            llllllllllllllIIlIllIlllIlIlllll.append(' ');
            llllllllllllllIIlIllIlllIlIlllll.append(llllllllllllllIIlIllIlllIllIIIII.getString("Status-Code"));
            llllllllllllllIIlIllIlllIlIlllll.append(' ');
            llllllllllllllIIlIllIlllIlIlllll.append(llllllllllllllIIlIllIlllIllIIIII.getString("Reason-Phrase"));
        }
        else {
            if (!llllllllllllllIIlIllIlllIllIIIII.has("Method") || !llllllllllllllIIlIllIlllIllIIIII.has("Request-URI")) {
                throw new JSONException("Not enough material for an HTTP header.");
            }
            llllllllllllllIIlIllIlllIlIlllll.append(llllllllllllllIIlIllIlllIllIIIII.getString("Method"));
            llllllllllllllIIlIllIlllIlIlllll.append(' ');
            llllllllllllllIIlIllIlllIlIlllll.append('\"');
            llllllllllllllIIlIllIlllIlIlllll.append(llllllllllllllIIlIllIlllIllIIIII.getString("Request-URI"));
            llllllllllllllIIlIllIlllIlIlllll.append('\"');
            llllllllllllllIIlIllIlllIlIlllll.append(' ');
            llllllllllllllIIlIllIlllIlIlllll.append(llllllllllllllIIlIllIlllIllIIIII.getString("HTTP-Version"));
        }
        llllllllllllllIIlIllIlllIlIlllll.append("\r\n");
        for (final String llllllllllllllIIlIllIlllIllIIIIl : llllllllllllllIIlIllIlllIllIIIII.keySet()) {
            final String llllllllllllllIIlIllIlllIllIIIlI = llllllllllllllIIlIllIlllIllIIIII.optString(llllllllllllllIIlIllIlllIllIIIIl);
            if (!"HTTP-Version".equals(llllllllllllllIIlIllIlllIllIIIIl) && !"Status-Code".equals(llllllllllllllIIlIllIlllIllIIIIl) && !"Reason-Phrase".equals(llllllllllllllIIlIllIlllIllIIIIl) && !"Method".equals(llllllllllllllIIlIllIlllIllIIIIl) && !"Request-URI".equals(llllllllllllllIIlIllIlllIllIIIIl) && !JSONObject.NULL.equals(llllllllllllllIIlIllIlllIllIIIlI)) {
                llllllllllllllIIlIllIlllIlIlllll.append(llllllllllllllIIlIllIlllIllIIIIl);
                llllllllllllllIIlIllIlllIlIlllll.append(": ");
                llllllllllllllIIlIllIlllIlIlllll.append(llllllllllllllIIlIllIlllIllIIIII.optString(llllllllllllllIIlIllIlllIllIIIIl));
                llllllllllllllIIlIllIlllIlIlllll.append("\r\n");
            }
        }
        llllllllllllllIIlIllIlllIlIlllll.append("\r\n");
        return String.valueOf(llllllllllllllIIlIllIlllIlIlllll);
    }
}
