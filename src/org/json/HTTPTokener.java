package org.json;

public class HTTPTokener extends JSONTokener
{
    public String nextToken() throws JSONException {
        final StringBuilder llllllllllllllIllIlIIIllllIIIlIl = new StringBuilder();
        char llllllllllllllIllIlIIIllllIIIllI;
        do {
            llllllllllllllIllIlIIIllllIIIllI = this.next();
        } while (Character.isWhitespace(llllllllllllllIllIlIIIllllIIIllI));
        if (llllllllllllllIllIlIIIllllIIIllI != '\"' && llllllllllllllIllIlIIIllllIIIllI != '\'') {
            while (llllllllllllllIllIlIIIllllIIIllI != '\0' && !Character.isWhitespace(llllllllllllllIllIlIIIllllIIIllI)) {
                llllllllllllllIllIlIIIllllIIIlIl.append(llllllllllllllIllIlIIIllllIIIllI);
                llllllllllllllIllIlIIIllllIIIllI = this.next();
            }
            return String.valueOf(llllllllllllllIllIlIIIllllIIIlIl);
        }
        final char llllllllllllllIllIlIIIllllIIlIII = llllllllllllllIllIlIIIllllIIIllI;
        while (true) {
            llllllllllllllIllIlIIIllllIIIllI = this.next();
            if (llllllllllllllIllIlIIIllllIIIllI < ' ') {
                throw this.syntaxError("Unterminated string.");
            }
            if (llllllllllllllIllIlIIIllllIIIllI == llllllllllllllIllIlIIIllllIIlIII) {
                return String.valueOf(llllllllllllllIllIlIIIllllIIIlIl);
            }
            llllllllllllllIllIlIIIllllIIIlIl.append(llllllllllllllIllIlIIIllllIIIllI);
        }
    }
    
    public HTTPTokener(final String llllllllllllllIllIlIIIllllIIllll) {
        super(llllllllllllllIllIlIIIllllIIllll);
    }
}
