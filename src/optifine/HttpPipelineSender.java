package optifine;

import java.nio.charset.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class HttpPipelineSender extends Thread
{
    private /* synthetic */ HttpPipelineConnection httpPipelineConnection;
    private static /* synthetic */ Charset ASCII;
    
    private void writeRequest(final HttpRequest lllllllllllllllIlIIlIlIlIIllIlIl, final OutputStream lllllllllllllllIlIIlIlIlIIllIlII) throws IOException {
        this.write(lllllllllllllllIlIIlIlIlIIllIlII, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIlIlIlIIllIlIl.getMethod())).append(" ").append(lllllllllllllllIlIIlIlIlIIllIlIl.getFile()).append(" ").append(lllllllllllllllIlIIlIlIlIIllIlIl.getHttp()).append("\r\n")));
        final Map lllllllllllllllIlIIlIlIlIIllIIll = lllllllllllllllIlIIlIlIlIIllIlIl.getHeaders();
        final Set lllllllllllllllIlIIlIlIlIIllIIlI = lllllllllllllllIlIIlIlIlIIllIIll.keySet();
        for (final String lllllllllllllllIlIIlIlIlIIllIIII : lllllllllllllllIlIIlIlIlIIllIIlI) {
            final String lllllllllllllllIlIIlIlIlIIlIllll = lllllllllllllllIlIIlIlIlIIllIlIl.getHeaders().get(lllllllllllllllIlIIlIlIlIIllIIII);
            this.write(lllllllllllllllIlIIlIlIlIIllIlII, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIlIlIlIIllIIII)).append(": ").append(lllllllllllllllIlIIlIlIlIIlIllll).append("\r\n")));
        }
        this.write(lllllllllllllllIlIIlIlIlIIllIlII, "\r\n");
    }
    
    private void write(final OutputStream lllllllllllllllIlIIlIlIlIIIlllll, final String lllllllllllllllIlIIlIlIlIIIllllI) throws IOException {
        final byte[] lllllllllllllllIlIIlIlIlIIlIIIII = lllllllllllllllIlIIlIlIlIIIllllI.getBytes(HttpPipelineSender.ASCII);
        lllllllllllllllIlIIlIlIlIIIlllll.write(lllllllllllllllIlIIlIlIlIIlIIIII);
    }
    
    public HttpPipelineSender(final HttpPipelineConnection lllllllllllllllIlIIlIlIlIlIllllI) {
        super("HttpPipelineSender");
        this.httpPipelineConnection = null;
        this.httpPipelineConnection = lllllllllllllllIlIIlIlIlIlIllllI;
    }
    
    static {
        CRLF = "\r\n";
        HttpPipelineSender.ASCII = Charset.forName("ASCII");
    }
    
    private void connect() throws IOException {
        final String lllllllllllllllIlIIlIlIlIlIIIlll = this.httpPipelineConnection.getHost();
        final int lllllllllllllllIlIIlIlIlIlIIIllI = this.httpPipelineConnection.getPort();
        final Proxy lllllllllllllllIlIIlIlIlIlIIIlIl = this.httpPipelineConnection.getProxy();
        final Socket lllllllllllllllIlIIlIlIlIlIIIlII = new Socket(lllllllllllllllIlIIlIlIlIlIIIlIl);
        lllllllllllllllIlIIlIlIlIlIIIlII.connect(new InetSocketAddress(lllllllllllllllIlIIlIlIlIlIIIlll, lllllllllllllllIlIIlIlIlIlIIIllI), 5000);
        this.httpPipelineConnection.setSocket(lllllllllllllllIlIIlIlIlIlIIIlII);
    }
    
    @Override
    public void run() {
        HttpPipelineRequest lllllllllllllllIlIIlIlIlIlIlIllI = null;
        try {
            this.connect();
            while (!Thread.interrupted()) {
                lllllllllllllllIlIIlIlIlIlIlIllI = this.httpPipelineConnection.getNextRequestSend();
                final HttpRequest lllllllllllllllIlIIlIlIlIlIlIlIl = lllllllllllllllIlIIlIlIlIlIlIllI.getHttpRequest();
                final OutputStream lllllllllllllllIlIIlIlIlIlIlIlII = this.httpPipelineConnection.getOutputStream();
                this.writeRequest(lllllllllllllllIlIIlIlIlIlIlIlIl, lllllllllllllllIlIIlIlIlIlIlIlII);
                this.httpPipelineConnection.onRequestSent(lllllllllllllllIlIIlIlIlIlIlIllI);
            }
        }
        catch (InterruptedException lllllllllllllllIlIIlIlIlIlIlIIll) {}
        catch (Exception lllllllllllllllIlIIlIlIlIlIlIIlI) {
            this.httpPipelineConnection.onExceptionSend(lllllllllllllllIlIIlIlIlIlIlIllI, lllllllllllllllIlIIlIlIlIlIlIIlI);
        }
    }
}
