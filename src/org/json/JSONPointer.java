package org.json;

import java.io.*;
import java.net.*;
import java.util.*;

public class JSONPointer
{
    private final /* synthetic */ List<String> refTokens;
    
    private static String unescape(final String lllllllllllllllIlllIllllllIllIll) {
        return lllllllllllllllIlllIllllllIllIll.replace("~1", "/").replace("~0", "~").replace("\\\"", "\"").replace("\\\\", "\\");
    }
    
    private static String escape(final String lllllllllllllllIlllIlllllIllIIII) {
        return lllllllllllllllIlllIlllllIllIIII.replace("~", "~0").replace("/", "~1").replace("\\", "\\\\").replace("\"", "\\\"");
    }
    
    public Object queryFrom(final Object lllllllllllllllIlllIllllllIlIIll) throws JSONPointerException {
        if (this.refTokens.isEmpty()) {
            return lllllllllllllllIlllIllllllIlIIll;
        }
        Object lllllllllllllllIlllIllllllIlIIlI = lllllllllllllllIlllIllllllIlIIll;
        for (final String lllllllllllllllIlllIllllllIlIlIl : this.refTokens) {
            if (lllllllllllllllIlllIllllllIlIIlI instanceof JSONObject) {
                lllllllllllllllIlllIllllllIlIIlI = ((JSONObject)lllllllllllllllIlllIllllllIlIIlI).opt(unescape(lllllllllllllllIlllIllllllIlIlIl));
            }
            else {
                if (!(lllllllllllllllIlllIllllllIlIIlI instanceof JSONArray)) {
                    throw new JSONPointerException(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", lllllllllllllllIlllIllllllIlIIlI, lllllllllllllllIlllIllllllIlIlIl));
                }
                lllllllllllllllIlllIllllllIlIIlI = readByIndexToken(lllllllllllllllIlllIllllllIlIIlI, lllllllllllllllIlllIllllllIlIlIl);
            }
        }
        return lllllllllllllllIlllIllllllIlIIlI;
    }
    
    static {
        ENCODING = "utf-8";
    }
    
    public JSONPointer(final String lllllllllllllllIlllIlllllllIllIl) {
        if (lllllllllllllllIlllIlllllllIllIl == null) {
            throw new NullPointerException("pointer cannot be null");
        }
        if (lllllllllllllllIlllIlllllllIllIl.isEmpty() || lllllllllllllllIlllIlllllllIllIl.equals("#")) {
            this.refTokens = Collections.emptyList();
            return;
        }
        Label_0105: {
            if (lllllllllllllllIlllIlllllllIllIl.startsWith("#/")) {
                String lllllllllllllllIlllIllllllllIIlI = lllllllllllllllIlllIlllllllIllIl.substring(2);
                try {
                    lllllllllllllllIlllIllllllllIIlI = URLDecoder.decode(lllllllllllllllIlllIllllllllIIlI, "utf-8");
                    break Label_0105;
                }
                catch (UnsupportedEncodingException lllllllllllllllIlllIllllllllIIll) {
                    throw new RuntimeException(lllllllllllllllIlllIllllllllIIll);
                }
            }
            if (!lllllllllllllllIlllIlllllllIllIl.startsWith("/")) {
                throw new IllegalArgumentException("a JSON pointer should start with '/' or '#/'");
            }
            final String lllllllllllllllIlllIllllllllIIIl = lllllllllllllllIlllIlllllllIllIl.substring(1);
        }
        this.refTokens = new ArrayList<String>();
        int lllllllllllllllIlllIlllllllIlIll = -1;
        int lllllllllllllllIlllIlllllllIlIlI = 0;
        do {
            lllllllllllllllIlllIlllllllIlIlI = lllllllllllllllIlllIlllllllIlIll + 1;
            final String lllllllllllllllIlllIlllllllIllII;
            lllllllllllllllIlllIlllllllIlIll = lllllllllllllllIlllIlllllllIllII.indexOf(47, lllllllllllllllIlllIlllllllIlIlI);
            if (lllllllllllllllIlllIlllllllIlIlI == lllllllllllllllIlllIlllllllIlIll || lllllllllllllllIlllIlllllllIlIlI == lllllllllllllllIlllIlllllllIllII.length()) {
                this.refTokens.add("");
            }
            else if (lllllllllllllllIlllIlllllllIlIll >= 0) {
                final String lllllllllllllllIlllIllllllllIIII = lllllllllllllllIlllIlllllllIllII.substring(lllllllllllllllIlllIlllllllIlIlI, lllllllllllllllIlllIlllllllIlIll);
                this.refTokens.add(unescape(lllllllllllllllIlllIllllllllIIII));
            }
            else {
                final String lllllllllllllllIlllIlllllllIllll = lllllllllllllllIlllIlllllllIllII.substring(lllllllllllllllIlllIlllllllIlIlI);
                this.refTokens.add(unescape(lllllllllllllllIlllIlllllllIllll));
            }
        } while (lllllllllllllllIlllIlllllllIlIll >= 0);
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllllIlllIlllllIllIllI = new StringBuilder("");
        for (final String lllllllllllllllIlllIlllllIlllIII : this.refTokens) {
            lllllllllllllllIlllIlllllIllIllI.append('/').append(escape(lllllllllllllllIlllIlllllIlllIII));
        }
        return String.valueOf(lllllllllllllllIlllIlllllIllIllI);
    }
    
    public String toURIFragment() {
        try {
            final StringBuilder lllllllllllllllIlllIlllllIlIlIIl = new StringBuilder("#");
            for (final String lllllllllllllllIlllIlllllIlIlIlI : this.refTokens) {
                lllllllllllllllIlllIlllllIlIlIIl.append('/').append(URLEncoder.encode(lllllllllllllllIlllIlllllIlIlIlI, "utf-8"));
            }
            return String.valueOf(lllllllllllllllIlllIlllllIlIlIIl);
        }
        catch (UnsupportedEncodingException lllllllllllllllIlllIlllllIlIlIII) {
            throw new RuntimeException(lllllllllllllllIlllIlllllIlIlIII);
        }
    }
    
    private static Object readByIndexToken(final Object lllllllllllllllIlllIllllllIIIIIl, final String lllllllllllllllIlllIllllllIIIIII) throws JSONPointerException {
        try {
            final int lllllllllllllllIlllIllllllIIIllI = Integer.parseInt(lllllllllllllllIlllIllllllIIIIII);
            final JSONArray lllllllllllllllIlllIllllllIIIlIl = (JSONArray)lllllllllllllllIlllIllllllIIIIIl;
            if (lllllllllllllllIlllIllllllIIIllI >= lllllllllllllllIlllIllllllIIIlIl.length()) {
                throw new JSONPointerException(String.format("index %s is out of bounds - the array has %d elements", lllllllllllllllIlllIllllllIIIIII, lllllllllllllllIlllIllllllIIIlIl.length()));
            }
            try {
                return lllllllllllllllIlllIllllllIIIlIl.get(lllllllllllllllIlllIllllllIIIllI);
            }
            catch (JSONException lllllllllllllllIlllIllllllIIIlll) {
                throw new JSONPointerException(String.valueOf(new StringBuilder().append("Error reading value at index position ").append(lllllllllllllllIlllIllllllIIIllI)), lllllllllllllllIlllIllllllIIIlll);
            }
        }
        catch (NumberFormatException lllllllllllllllIlllIllllllIIIlII) {
            throw new JSONPointerException(String.format("%s is not an array index", lllllllllllllllIlllIllllllIIIIII), lllllllllllllllIlllIllllllIIIlII);
        }
    }
    
    public JSONPointer(final List<String> lllllllllllllllIlllIllllllIllllI) {
        this.refTokens = new ArrayList<String>(lllllllllllllllIlllIllllllIllllI);
    }
    
    public static class Builder
    {
        private final /* synthetic */ List<String> refTokens;
        
        public Builder append(final int lllllIllIIllIIl) {
            this.refTokens.add(String.valueOf(lllllIllIIllIIl));
            return this;
        }
        
        public JSONPointer build() {
            return new JSONPointer(this.refTokens);
        }
        
        public Builder() {
            this.refTokens = new ArrayList<String>();
        }
        
        public Builder append(final String lllllIllIIlllll) {
            if (lllllIllIIlllll == null) {
                throw new NullPointerException("token cannot be null");
            }
            this.refTokens.add(lllllIllIIlllll);
            return this;
        }
    }
}
