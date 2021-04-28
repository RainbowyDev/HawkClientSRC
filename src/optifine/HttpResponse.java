package optifine;

import java.util.*;

public class HttpResponse
{
    private /* synthetic */ byte[] body;
    private /* synthetic */ Map<String, String> headers;
    private /* synthetic */ String statusLine;
    private /* synthetic */ int status;
    
    public HttpResponse(final int lllllllllllllllIIIIIIIllllIllIIl, final String lllllllllllllllIIIIIIIllllIlllIl, final Map lllllllllllllllIIIIIIIllllIlIlll, final byte[] lllllllllllllllIIIIIIIllllIllIll) {
        this.status = 0;
        this.statusLine = null;
        this.headers = new LinkedHashMap<String, String>();
        this.body = null;
        this.status = lllllllllllllllIIIIIIIllllIllIIl;
        this.statusLine = lllllllllllllllIIIIIIIllllIlllIl;
        this.headers = (Map<String, String>)lllllllllllllllIIIIIIIllllIlIlll;
        this.body = lllllllllllllllIIIIIIIllllIllIll;
    }
    
    public byte[] getBody() {
        return this.body;
    }
    
    public Map getHeaders() {
        return this.headers;
    }
    
    public String getHeader(final String lllllllllllllllIIIIIIIllllIIIlll) {
        return this.headers.get(lllllllllllllllIIIIIIIllllIIIlll);
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public String getStatusLine() {
        return this.statusLine;
    }
}
