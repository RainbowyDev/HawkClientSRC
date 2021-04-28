package optifine;

public class HttpPipelineRequest
{
    private /* synthetic */ HttpListener httpListener;
    private /* synthetic */ HttpRequest httpRequest;
    private /* synthetic */ boolean closed;
    
    public HttpListener getHttpListener() {
        return this.httpListener;
    }
    
    public void setClosed(final boolean llllllllllllllIIIlllllIIIlIlIllI) {
        this.closed = llllllllllllllIIIlllllIIIlIlIllI;
    }
    
    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }
    
    public boolean isClosed() {
        return this.closed;
    }
    
    public HttpPipelineRequest(final HttpRequest llllllllllllllIIIlllllIIIllIIlII, final HttpListener llllllllllllllIIIlllllIIIllIIIll) {
        this.httpRequest = null;
        this.httpListener = null;
        this.closed = false;
        this.httpRequest = llllllllllllllIIIlllllIIIllIIlII;
        this.httpListener = llllllllllllllIIIlllllIIIllIIIll;
    }
}
