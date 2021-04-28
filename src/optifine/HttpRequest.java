package optifine;

import java.net.*;
import java.util.*;

public class HttpRequest
{
    private /* synthetic */ int port;
    private /* synthetic */ String http;
    private /* synthetic */ String file;
    private /* synthetic */ String method;
    private /* synthetic */ Map<String, String> headers;
    private /* synthetic */ int redirects;
    private /* synthetic */ Proxy proxy;
    private /* synthetic */ byte[] body;
    private /* synthetic */ String host;
    
    public int getPort() {
        return this.port;
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public String getHttp() {
        return this.http;
    }
    
    public byte[] getBody() {
        return this.body;
    }
    
    static {
        HTTP_1_1 = "HTTP/1.1";
        HTTP_1_0 = "HTTP/1.0";
        METHOD_HEAD = "HEAD";
        METHOD_GET = "GET";
        METHOD_POST = "POST";
    }
    
    public String getHost() {
        return this.host;
    }
    
    public void setRedirects(final int llIIllllIlII) {
        this.redirects = llIIllllIlII;
    }
    
    public Map<String, String> getHeaders() {
        return this.headers;
    }
    
    public HttpRequest(final String llIlIIIlIlll, final int llIlIIIlIllI, final Proxy llIlIIIlIlIl, final String llIlIIIlIlII, final String llIlIIIlIIll, final String llIlIIIllIll, final Map<String, String> llIlIIIllIlI, final byte[] llIlIIIllIIl) {
        this.host = null;
        this.port = 0;
        this.proxy = Proxy.NO_PROXY;
        this.method = null;
        this.file = null;
        this.http = null;
        this.headers = new LinkedHashMap<String, String>();
        this.body = null;
        this.redirects = 0;
        this.host = llIlIIIlIlll;
        this.port = llIlIIIlIllI;
        this.proxy = llIlIIIlIlIl;
        this.method = llIlIIIlIlII;
        this.file = llIlIIIlIIll;
        this.http = llIlIIIllIll;
        this.headers = llIlIIIllIlI;
        this.body = llIlIIIllIIl;
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    public String getFile() {
        return this.file;
    }
    
    public int getRedirects() {
        return this.redirects;
    }
}
