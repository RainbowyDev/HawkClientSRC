package org.json;

public class JSONException extends RuntimeException
{
    public JSONException(final String llllllllllllllIllIlllIllllllIlII) {
        super(llllllllllllllIllIlllIllllllIlII);
    }
    
    public JSONException(final String llllllllllllllIllIlllIlllllIllIl, final Throwable llllllllllllllIllIlllIlllllIllII) {
        super(llllllllllllllIllIlllIlllllIllIl, llllllllllllllIllIlllIlllllIllII);
    }
    
    public JSONException(final Throwable llllllllllllllIllIlllIlllllIIlIl) {
        super(llllllllllllllIllIlllIlllllIIlIl.getMessage(), llllllllllllllIllIlllIlllllIIlIl);
    }
}
