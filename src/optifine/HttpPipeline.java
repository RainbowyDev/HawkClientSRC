package optifine;

import java.net.*;
import java.util.*;
import java.io.*;

public class HttpPipeline
{
    private static /* synthetic */ Map mapConnections;
    
    public static HttpRequest makeRequest(final String lllllllllllllllllIlllIIlIIIIIIII, final Proxy lllllllllllllllllIlllIIIllllllll) throws IOException {
        final URL lllllllllllllllllIlllIIIlllllllI = new URL(lllllllllllllllllIlllIIlIIIIIIII);
        if (!lllllllllllllllllIlllIIIlllllllI.getProtocol().equals("http")) {
            throw new IOException(String.valueOf(new StringBuilder("Only protocol http is supported: ").append(lllllllllllllllllIlllIIIlllllllI)));
        }
        final String lllllllllllllllllIlllIIIllllllIl = lllllllllllllllllIlllIIIlllllllI.getFile();
        final String lllllllllllllllllIlllIIIllllllII = lllllllllllllllllIlllIIIlllllllI.getHost();
        int lllllllllllllllllIlllIIIlllllIll = lllllllllllllllllIlllIIIlllllllI.getPort();
        if (lllllllllllllllllIlllIIIlllllIll <= 0) {
            lllllllllllllllllIlllIIIlllllIll = 80;
        }
        final String lllllllllllllllllIlllIIIlllllIlI = "GET";
        final String lllllllllllllllllIlllIIIlllllIIl = "HTTP/1.1";
        final LinkedHashMap lllllllllllllllllIlllIIIlllllIII = new LinkedHashMap();
        lllllllllllllllllIlllIIIlllllIII.put("User-Agent", String.valueOf(new StringBuilder("Java/").append(System.getProperty("java.version"))));
        lllllllllllllllllIlllIIIlllllIII.put("Host", lllllllllllllllllIlllIIIllllllII);
        lllllllllllllllllIlllIIIlllllIII.put("Accept", "text/html, image/gif, image/png");
        lllllllllllllllllIlllIIIlllllIII.put("Connection", "keep-alive");
        final byte[] lllllllllllllllllIlllIIIllllIlll = new byte[0];
        final HttpRequest lllllllllllllllllIlllIIIllllIllI = new HttpRequest(lllllllllllllllllIlllIIIllllllII, lllllllllllllllllIlllIIIlllllIll, lllllllllllllllllIlllIIIllllllll, lllllllllllllllllIlllIIIlllllIlI, lllllllllllllllllIlllIIIllllllIl, lllllllllllllllllIlllIIIlllllIIl, lllllllllllllllllIlllIIIlllllIII, lllllllllllllllllIlllIIIllllIlll);
        return lllllllllllllllllIlllIIIllllIllI;
    }
    
    public static boolean hasActiveRequests() {
        final Collection lllllllllllllllllIlllIIIlIIIIlll = HttpPipeline.mapConnections.values();
        for (final HttpPipelineConnection lllllllllllllllllIlllIIIlIIIIlIl : lllllllllllllllllIlllIIIlIIIIlll) {
            if (lllllllllllllllllIlllIIIlIIIIlIl.hasActiveRequests()) {
                return true;
            }
        }
        return false;
    }
    
    public static void addRequest(final String lllllllllllllllllIlllIIlIIIlIlIl, final HttpListener lllllllllllllllllIlllIIlIIIlIlII, final Proxy lllllllllllllllllIlllIIlIIIIlllI) throws IOException {
        final HttpRequest lllllllllllllllllIlllIIlIIIlIIlI = makeRequest(lllllllllllllllllIlllIIlIIIlIlIl, lllllllllllllllllIlllIIlIIIIlllI);
        final HttpPipelineRequest lllllllllllllllllIlllIIlIIIlIIIl = new HttpPipelineRequest(lllllllllllllllllIlllIIlIIIlIIlI, lllllllllllllllllIlllIIlIIIlIlII);
        addRequest(lllllllllllllllllIlllIIlIIIlIIIl);
    }
    
    public static void addRequest(final String lllllllllllllllllIlllIIlIIIllllI, final HttpListener lllllllllllllllllIlllIIlIIIllIll) throws IOException {
        addRequest(lllllllllllllllllIlllIIlIIIllllI, lllllllllllllllllIlllIIlIIIllIll, Proxy.NO_PROXY);
    }
    
    public static byte[] get(final String lllllllllllllllllIlllIIIlIlIlIIl, final Proxy lllllllllllllllllIlllIIIlIlIlIII) throws IOException {
        final HttpRequest lllllllllllllllllIlllIIIlIlIlIll = makeRequest(lllllllllllllllllIlllIIIlIlIlIIl, lllllllllllllllllIlllIIIlIlIlIII);
        final HttpResponse lllllllllllllllllIlllIIIlIlIlIlI = executeRequest(lllllllllllllllllIlllIIIlIlIlIll);
        if (lllllllllllllllllIlllIIIlIlIlIlI.getStatus() / 100 != 2) {
            throw new IOException(String.valueOf(new StringBuilder("HTTP response: ").append(lllllllllllllllllIlllIIIlIlIlIlI.getStatus())));
        }
        return lllllllllllllllllIlllIIIlIlIlIlI.getBody();
    }
    
    private static synchronized HttpPipelineConnection getConnection(final String lllllllllllllllllIlllIIIllIlIlll, final int lllllllllllllllllIlllIIIllIlIllI, final Proxy lllllllllllllllllIlllIIIllIllIlI) {
        final String lllllllllllllllllIlllIIIllIllIIl = makeConnectionKey(lllllllllllllllllIlllIIIllIlIlll, lllllllllllllllllIlllIIIllIlIllI, lllllllllllllllllIlllIIIllIllIlI);
        HttpPipelineConnection lllllllllllllllllIlllIIIllIllIII = HttpPipeline.mapConnections.get(lllllllllllllllllIlllIIIllIllIIl);
        if (lllllllllllllllllIlllIIIllIllIII == null) {
            lllllllllllllllllIlllIIIllIllIII = new HttpPipelineConnection(lllllllllllllllllIlllIIIllIlIlll, lllllllllllllllllIlllIIIllIlIllI, lllllllllllllllllIlllIIIllIllIlI);
            HttpPipeline.mapConnections.put(lllllllllllllllllIlllIIIllIllIIl, lllllllllllllllllIlllIIIllIllIII);
        }
        return lllllllllllllllllIlllIIIllIllIII;
    }
    
    static {
        HEADER_ACCEPT = "Accept";
        HEADER_LOCATION = "Location";
        HEADER_TRANSFER_ENCODING = "Transfer-Encoding";
        HEADER_VALUE_KEEP_ALIVE = "keep-alive";
        HEADER_CONNECTION = "Connection";
        HEADER_HOST = "Host";
        HEADER_VALUE_CHUNKED = "chunked";
        HEADER_KEEP_ALIVE = "Keep-Alive";
        HEADER_USER_AGENT = "User-Agent";
        HttpPipeline.mapConnections = new HashMap();
    }
    
    public static byte[] get(final String lllllllllllllllllIlllIIIlIllIIlI) throws IOException {
        return get(lllllllllllllllllIlllIIIlIllIIlI, Proxy.NO_PROXY);
    }
    
    public static void addRequest(final HttpPipelineRequest lllllllllllllllllIlllIIIlllIIlll) {
        final HttpRequest lllllllllllllllllIlllIIIlllIIllI = lllllllllllllllllIlllIIIlllIIlll.getHttpRequest();
        for (HttpPipelineConnection lllllllllllllllllIlllIIIlllIIlIl = getConnection(lllllllllllllllllIlllIIIlllIIllI.getHost(), lllllllllllllllllIlllIIIlllIIllI.getPort(), lllllllllllllllllIlllIIIlllIIllI.getProxy()); !lllllllllllllllllIlllIIIlllIIlIl.addRequest(lllllllllllllllllIlllIIIlllIIlll); lllllllllllllllllIlllIIIlllIIlIl = getConnection(lllllllllllllllllIlllIIIlllIIllI.getHost(), lllllllllllllllllIlllIIIlllIIllI.getPort(), lllllllllllllllllIlllIIIlllIIllI.getProxy())) {
            removeConnection(lllllllllllllllllIlllIIIlllIIllI.getHost(), lllllllllllllllllIlllIIIlllIIllI.getPort(), lllllllllllllllllIlllIIIlllIIllI.getProxy(), lllllllllllllllllIlllIIIlllIIlIl);
        }
    }
    
    private static synchronized void removeConnection(final String lllllllllllllllllIlllIIIllIIllII, final int lllllllllllllllllIlllIIIllIIIlIl, final Proxy lllllllllllllllllIlllIIIllIIlIlI, final HttpPipelineConnection lllllllllllllllllIlllIIIllIIlIIl) {
        final String lllllllllllllllllIlllIIIllIIlIII = makeConnectionKey(lllllllllllllllllIlllIIIllIIllII, lllllllllllllllllIlllIIIllIIIlIl, lllllllllllllllllIlllIIIllIIlIlI);
        final HttpPipelineConnection lllllllllllllllllIlllIIIllIIIlll = HttpPipeline.mapConnections.get(lllllllllllllllllIlllIIIllIIlIII);
        if (lllllllllllllllllIlllIIIllIIIlll == lllllllllllllllllIlllIIIllIIlIIl) {
            HttpPipeline.mapConnections.remove(lllllllllllllllllIlllIIIllIIlIII);
        }
    }
    
    private static String makeConnectionKey(final String lllllllllllllllllIlllIIIlIlllIII, final int lllllllllllllllllIlllIIIlIllIlll, final Proxy lllllllllllllllllIlllIIIlIllIllI) {
        final String lllllllllllllllllIlllIIIlIlllIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIlllIIIlIlllIII)).append(":").append(lllllllllllllllllIlllIIIlIllIlll).append("-").append(lllllllllllllllllIlllIIIlIllIllI));
        return lllllllllllllllllIlllIIIlIlllIIl;
    }
    
    public static HttpResponse executeRequest(final HttpRequest lllllllllllllllllIlllIIIlIIlIIll) throws IOException {
        final HashMap lllllllllllllllllIlllIIIlIIllIll = new HashMap();
        final String lllllllllllllllllIlllIIIlIIllIlI = "Response";
        final String lllllllllllllllllIlllIIIlIIllIIl = "Exception";
        final HttpListener lllllllllllllllllIlllIIIlIIllIII = new HttpListener() {
            @Override
            public void failed(final HttpRequest llllllllllllllllllllIllIIIIllIll, final Exception llllllllllllllllllllIllIIIIlIlll) {
                final Map llllllllllllllllllllIllIIIIllIIl = lllllllllllllllllIlllIIIlIIllIll;
                synchronized (lllllllllllllllllIlllIIIlIIllIll) {
                    lllllllllllllllllIlllIIIlIIllIll.put("Exception", llllllllllllllllllllIllIIIIlIlll);
                    lllllllllllllllllIlllIIIlIIllIll.notifyAll();
                }
                // monitorexit(this.val$map)
            }
            
            @Override
            public void finished(final HttpRequest llllllllllllllllllllIllIIIlIIlll, final HttpResponse llllllllllllllllllllIllIIIlIIllI) {
                final Map llllllllllllllllllllIllIIIlIIlIl = lllllllllllllllllIlllIIIlIIllIll;
                synchronized (lllllllllllllllllIlllIIIlIIllIll) {
                    lllllllllllllllllIlllIIIlIIllIll.put("Response", llllllllllllllllllllIllIIIlIIllI);
                    lllllllllllllllllIlllIIIlIIllIll.notifyAll();
                }
                // monitorexit(this.val$map)
            }
        };
        synchronized (lllllllllllllllllIlllIIIlIIllIll) {
            final HttpPipelineRequest lllllllllllllllllIlllIIIlIIlIlll = new HttpPipelineRequest(lllllllllllllllllIlllIIIlIIlIIll, lllllllllllllllllIlllIIIlIIllIII);
            addRequest(lllllllllllllllllIlllIIIlIIlIlll);
            try {
                lllllllllllllllllIlllIIIlIIllIll.wait();
            }
            catch (InterruptedException lllllllllllllllllIlllIIIlIIlIllI) {
                throw new InterruptedIOException("Interrupted");
            }
            final Exception lllllllllllllllllIlllIIIlIIlIlIl = lllllllllllllllllIlllIIIlIIllIll.get("Exception");
            if (lllllllllllllllllIlllIIIlIIlIlIl != null) {
                if (lllllllllllllllllIlllIIIlIIlIlIl instanceof IOException) {
                    throw (IOException)lllllllllllllllllIlllIIIlIIlIlIl;
                }
                if (lllllllllllllllllIlllIIIlIIlIlIl instanceof RuntimeException) {
                    throw (RuntimeException)lllllllllllllllllIlllIIIlIIlIlIl;
                }
                throw new RuntimeException(lllllllllllllllllIlllIIIlIIlIlIl.getMessage(), lllllllllllllllllIlllIIIlIIlIlIl);
            }
            else {
                final HttpResponse lllllllllllllllllIlllIIIlIIlIlII = lllllllllllllllllIlllIIIlIIllIll.get("Response");
                if (lllllllllllllllllIlllIIIlIIlIlII == null) {
                    throw new IOException("Response is null");
                }
                // monitorexit(lllllllllllllllllIlllIIIlIIllIll)
                return lllllllllllllllllIlllIIIlIIlIlII;
            }
        }
    }
}
