package optifine;

import java.net.*;
import java.util.regex.*;
import java.util.*;
import java.io.*;

public class HttpPipelineConnection
{
    private /* synthetic */ long keepaliveTimeoutMs;
    private /* synthetic */ int port;
    private /* synthetic */ String host;
    private /* synthetic */ HttpPipelineSender httpPipelineSender;
    private /* synthetic */ List<HttpPipelineRequest> listRequestsSend;
    private /* synthetic */ Socket socket;
    private /* synthetic */ int countRequests;
    private /* synthetic */ HttpPipelineReceiver httpPipelineReceiver;
    private /* synthetic */ Proxy proxy;
    private /* synthetic */ boolean terminated;
    private static final /* synthetic */ Pattern patternFullUrl;
    private /* synthetic */ List<HttpPipelineRequest> listRequests;
    private /* synthetic */ OutputStream outputStream;
    private /* synthetic */ InputStream inputStream;
    private /* synthetic */ int keepaliveMaxCount;
    private /* synthetic */ boolean responseReceived;
    private /* synthetic */ long timeLastActivityMs;
    
    public String getHost() {
        return this.host;
    }
    
    private void addRequest(final HttpPipelineRequest llllllllllllllIIIlIllIlIllIllllI, final List<HttpPipelineRequest> llllllllllllllIIIlIllIlIlllIIIII) {
        llllllllllllllIIIlIllIlIlllIIIII.add(llllllllllllllIIIlIllIlIllIllllI);
        this.notifyAll();
    }
    
    private synchronized void terminate(final Exception llllllllllllllIIIlIllIlIIlIIllll) {
        if (!this.terminated) {
            this.terminated = true;
            this.terminateRequests(llllllllllllllIIIlIllIlIIlIIllll);
            if (this.httpPipelineSender != null) {
                this.httpPipelineSender.interrupt();
            }
            if (this.httpPipelineReceiver != null) {
                this.httpPipelineReceiver.interrupt();
            }
            try {
                if (this.socket != null) {
                    this.socket.close();
                }
            }
            catch (IOException ex) {}
            this.socket = null;
            this.inputStream = null;
            this.outputStream = null;
        }
    }
    
    private void checkResponseHeader(final HttpResponse llllllllllllllIIIlIllIlIIllllIIl) {
        final String llllllllllllllIIIlIllIlIlIIIIIlI = llllllllllllllIIIlIllIlIIllllIIl.getHeader("Connection");
        if (llllllllllllllIIIlIllIlIlIIIIIlI != null && !llllllllllllllIIIlIllIlIlIIIIIlI.toLowerCase().equals("keep-alive")) {
            this.terminate(new EOFException("Connection not keep-alive"));
        }
        final String llllllllllllllIIIlIllIlIlIIIIIIl = llllllllllllllIIIlIllIlIIllllIIl.getHeader("Keep-Alive");
        if (llllllllllllllIIIlIllIlIlIIIIIIl != null) {
            final String[] llllllllllllllIIIlIllIlIlIIIIIII = Config.tokenize(llllllllllllllIIIlIllIlIlIIIIIIl, ",;");
            for (int llllllllllllllIIIlIllIlIIlllllll = 0; llllllllllllllIIIlIllIlIIlllllll < llllllllllllllIIIlIllIlIlIIIIIII.length; ++llllllllllllllIIIlIllIlIIlllllll) {
                final String llllllllllllllIIIlIllIlIIllllllI = llllllllllllllIIIlIllIlIlIIIIIII[llllllllllllllIIIlIllIlIIlllllll];
                final String[] llllllllllllllIIIlIllIlIIlllllIl = this.split(llllllllllllllIIIlIllIlIIllllllI, '=');
                if (llllllllllllllIIIlIllIlIIlllllIl.length >= 2) {
                    if (llllllllllllllIIIlIllIlIIlllllIl[0].equals("timeout")) {
                        final int llllllllllllllIIIlIllIlIIlllllII = Config.parseInt(llllllllllllllIIIlIllIlIIlllllIl[1], -1);
                        if (llllllllllllllIIIlIllIlIIlllllII > 0) {
                            this.keepaliveTimeoutMs = llllllllllllllIIIlIllIlIIlllllII * 1000;
                        }
                    }
                    if (llllllllllllllIIIlIllIlIIlllllIl[0].equals("max")) {
                        final int llllllllllllllIIIlIllIlIIllllIll = Config.parseInt(llllllllllllllIIIlIllIlIIlllllIl[1], -1);
                        if (llllllllllllllIIIlIllIlIIllllIll > 0) {
                            this.keepaliveMaxCount = llllllllllllllIIIlIllIlIIllllIll;
                        }
                    }
                }
            }
        }
    }
    
    public synchronized boolean isClosed() {
        return this.terminated || this.countRequests >= this.keepaliveMaxCount;
    }
    
    public synchronized HttpPipelineRequest getNextRequestSend() throws IOException, InterruptedException {
        if (this.listRequestsSend.size() <= 0 && this.outputStream != null) {
            this.outputStream.flush();
        }
        return this.getNextRequest(this.listRequestsSend, true);
    }
    
    public synchronized boolean hasActiveRequests() {
        return this.listRequests.size() > 0;
    }
    
    public HttpPipelineConnection(final String llllllllllllllIIIlIllIlIllllIIlI, final int llllllllllllllIIIlIllIlIlllIllIl, final Proxy llllllllllllllIIIlIllIlIllllIIII) {
        this.host = null;
        this.port = 0;
        this.proxy = Proxy.NO_PROXY;
        this.listRequests = new LinkedList<HttpPipelineRequest>();
        this.listRequestsSend = new LinkedList<HttpPipelineRequest>();
        this.socket = null;
        this.inputStream = null;
        this.outputStream = null;
        this.httpPipelineSender = null;
        this.httpPipelineReceiver = null;
        this.countRequests = 0;
        this.responseReceived = false;
        this.keepaliveTimeoutMs = 5000L;
        this.keepaliveMaxCount = 1000;
        this.timeLastActivityMs = System.currentTimeMillis();
        this.terminated = false;
        this.host = llllllllllllllIIIlIllIlIllllIIlI;
        this.port = llllllllllllllIIIlIllIlIlllIllIl;
        this.proxy = llllllllllllllIIIlIllIlIllllIIII;
        this.httpPipelineSender = new HttpPipelineSender(this);
        this.httpPipelineSender.start();
        this.httpPipelineReceiver = new HttpPipelineReceiver(this);
        this.httpPipelineReceiver.start();
    }
    
    public int getCountRequests() {
        return this.countRequests;
    }
    
    public synchronized void onResponseReceived(final HttpPipelineRequest llllllllllllllIIIlIllIlIlIlIIIlI, final HttpResponse llllllllllllllIIIlIllIlIlIlIlIIl) {
        if (!this.terminated) {
            this.responseReceived = true;
            this.onActivity();
            if (this.listRequests.size() <= 0 || this.listRequests.get(0) != llllllllllllllIIIlIllIlIlIlIIIlI) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Response out of order: ").append(llllllllllllllIIIlIllIlIlIlIIIlI)));
            }
            this.listRequests.remove(0);
            llllllllllllllIIIlIllIlIlIlIIIlI.setClosed(true);
            String llllllllllllllIIIlIllIlIlIlIlIII = llllllllllllllIIIlIllIlIlIlIlIIl.getHeader("Location");
            if (llllllllllllllIIIlIllIlIlIlIlIIl.getStatus() / 100 == 3 && llllllllllllllIIIlIllIlIlIlIlIII != null && llllllllllllllIIIlIllIlIlIlIIIlI.getHttpRequest().getRedirects() < 5) {
                try {
                    llllllllllllllIIIlIllIlIlIlIlIII = this.normalizeUrl(llllllllllllllIIIlIllIlIlIlIlIII, llllllllllllllIIIlIllIlIlIlIIIlI.getHttpRequest());
                    final HttpRequest llllllllllllllIIIlIllIlIlIlIIlll = HttpPipeline.makeRequest(llllllllllllllIIIlIllIlIlIlIlIII, llllllllllllllIIIlIllIlIlIlIIIlI.getHttpRequest().getProxy());
                    llllllllllllllIIIlIllIlIlIlIIlll.setRedirects(llllllllllllllIIIlIllIlIlIlIIIlI.getHttpRequest().getRedirects() + 1);
                    final HttpPipelineRequest llllllllllllllIIIlIllIlIlIlIIllI = new HttpPipelineRequest(llllllllllllllIIIlIllIlIlIlIIlll, llllllllllllllIIIlIllIlIlIlIIIlI.getHttpListener());
                    HttpPipeline.addRequest(llllllllllllllIIIlIllIlIlIlIIllI);
                }
                catch (IOException llllllllllllllIIIlIllIlIlIlIIlIl) {
                    llllllllllllllIIIlIllIlIlIlIIIlI.getHttpListener().failed(llllllllllllllIIIlIllIlIlIlIIIlI.getHttpRequest(), llllllllllllllIIIlIllIlIlIlIIlIl);
                }
            }
            else {
                final HttpListener llllllllllllllIIIlIllIlIlIlIIlII = llllllllllllllIIIlIllIlIlIlIIIlI.getHttpListener();
                llllllllllllllIIIlIllIlIlIlIIlII.finished(llllllllllllllIIIlIllIlIlIlIIIlI.getHttpRequest(), llllllllllllllIIIlIllIlIlIlIlIIl);
            }
            this.checkResponseHeader(llllllllllllllIIIlIllIlIlIlIlIIl);
        }
    }
    
    private void checkTimeout() {
        if (this.socket != null) {
            long llllllllllllllIIIlIllIlIlIllllIl = this.keepaliveTimeoutMs;
            if (this.listRequests.size() > 0) {
                llllllllllllllIIIlIllIlIlIllllIl = 5000L;
            }
            final long llllllllllllllIIIlIllIlIlIllllII = System.currentTimeMillis();
            if (llllllllllllllIIIlIllIlIlIllllII > this.timeLastActivityMs + llllllllllllllIIIlIllIlIlIllllIl) {
                this.terminate(new InterruptedException(String.valueOf(new StringBuilder("Timeout ").append(llllllllllllllIIIlIllIlIlIllllIl))));
            }
        }
    }
    
    public synchronized OutputStream getOutputStream() throws IOException, InterruptedException {
        while (this.outputStream == null) {
            this.checkTimeout();
            this.wait(1000L);
        }
        return this.outputStream;
    }
    
    private String[] split(final String llllllllllllllIIIlIllIlIIllIlIll, final char llllllllllllllIIIlIllIlIIllIIlIl) {
        final int llllllllllllllIIIlIllIlIIllIlIIl = llllllllllllllIIIlIllIlIIllIlIll.indexOf(llllllllllllllIIIlIllIlIIllIIlIl);
        if (llllllllllllllIIIlIllIlIIllIlIIl < 0) {
            return new String[] { llllllllllllllIIIlIllIlIIllIlIll };
        }
        final String llllllllllllllIIIlIllIlIIllIlIII = llllllllllllllIIIlIllIlIIllIlIll.substring(0, llllllllllllllIIIlIllIlIIllIlIIl);
        final String llllllllllllllIIIlIllIlIIllIIlll = llllllllllllllIIIlIllIlIIllIlIll.substring(llllllllllllllIIIlIllIlIIllIlIIl + 1);
        return new String[] { llllllllllllllIIIlIllIlIIllIlIII, llllllllllllllIIIlIllIlIIllIIlll };
    }
    
    private HttpPipelineRequest getNextRequest(final List<HttpPipelineRequest> llllllllllllllIIIlIllIlIllIIIllI, final boolean llllllllllllllIIIlIllIlIllIIIlIl) throws InterruptedException {
        while (llllllllllllllIIIlIllIlIllIIIllI.size() <= 0) {
            this.checkTimeout();
            this.wait(1000L);
        }
        this.onActivity();
        if (llllllllllllllIIIlIllIlIllIIIlIl) {
            return llllllllllllllIIIlIllIlIllIIIllI.remove(0);
        }
        return llllllllllllllIIIlIllIlIllIIIllI.get(0);
    }
    
    public int getPort() {
        return this.port;
    }
    
    public synchronized HttpPipelineRequest getNextRequestReceive() throws InterruptedException {
        return this.getNextRequest(this.listRequests, false);
    }
    
    public synchronized void onRequestSent(final HttpPipelineRequest llllllllllllllIIIlIllIlIlIllIIll) {
        if (!this.terminated) {
            this.onActivity();
        }
    }
    
    public HttpPipelineConnection(final String llllllllllllllIIIlIllIlIlllllIIl, final int llllllllllllllIIIlIllIlIlllllIll) {
        this(llllllllllllllIIIlIllIlIlllllIIl, llllllllllllllIIIlIllIlIlllllIll, Proxy.NO_PROXY);
    }
    
    private void onActivity() {
        this.timeLastActivityMs = System.currentTimeMillis();
    }
    
    public synchronized boolean addRequest(final HttpPipelineRequest llllllllllllllIIIlIllIlIlllIIllI) {
        if (this.isClosed()) {
            return false;
        }
        this.addRequest(llllllllllllllIIIlIllIlIlllIIllI, this.listRequests);
        this.addRequest(llllllllllllllIIIlIllIlIlllIIllI, this.listRequestsSend);
        ++this.countRequests;
        return true;
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    public synchronized void setSocket(final Socket llllllllllllllIIIlIllIlIllIllIIl) throws IOException {
        if (!this.terminated) {
            if (this.socket != null) {
                throw new IllegalArgumentException("Already connected");
            }
            this.socket = llllllllllllllIIIlIllIlIllIllIIl;
            this.socket.setTcpNoDelay(true);
            this.inputStream = this.socket.getInputStream();
            this.outputStream = new BufferedOutputStream(this.socket.getOutputStream());
            this.onActivity();
            this.notifyAll();
        }
    }
    
    public synchronized void onExceptionSend(final HttpPipelineRequest llllllllllllllIIIlIllIlIIlIllllI, final Exception llllllllllllllIIIlIllIlIIlIllIll) {
        this.terminate(llllllllllllllIIIlIllIlIIlIllIll);
    }
    
    private String normalizeUrl(final String llllllllllllllIIIlIllIlIlIIlIIlI, final HttpRequest llllllllllllllIIIlIllIlIlIIlIllI) {
        if (HttpPipelineConnection.patternFullUrl.matcher(llllllllllllllIIIlIllIlIlIIlIIlI).matches()) {
            return llllllllllllllIIIlIllIlIlIIlIIlI;
        }
        if (llllllllllllllIIIlIllIlIlIIlIIlI.startsWith("//")) {
            return String.valueOf(new StringBuilder("http:").append(llllllllllllllIIIlIllIlIlIIlIIlI));
        }
        String llllllllllllllIIIlIllIlIlIIlIlIl = llllllllllllllIIIlIllIlIlIIlIllI.getHost();
        if (llllllllllllllIIIlIllIlIlIIlIllI.getPort() != 80) {
            llllllllllllllIIIlIllIlIlIIlIlIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIllIlIlIIlIlIl)).append(":").append(llllllllllllllIIIlIllIlIlIIlIllI.getPort()));
        }
        if (llllllllllllllIIIlIllIlIlIIlIIlI.startsWith("/")) {
            return String.valueOf(new StringBuilder("http://").append(llllllllllllllIIIlIllIlIlIIlIlIl).append(llllllllllllllIIIlIllIlIlIIlIIlI));
        }
        final String llllllllllllllIIIlIllIlIlIIlIlII = llllllllllllllIIIlIllIlIlIIlIllI.getFile();
        final int llllllllllllllIIIlIllIlIlIIlIIll = llllllllllllllIIIlIllIlIlIIlIlII.lastIndexOf("/");
        return (llllllllllllllIIIlIllIlIlIIlIIll >= 0) ? String.valueOf(new StringBuilder("http://").append(llllllllllllllIIIlIllIlIlIIlIlIl).append(llllllllllllllIIIlIllIlIlIIlIlII.substring(0, llllllllllllllIIIlIllIlIlIIlIIll + 1)).append(llllllllllllllIIIlIllIlIlIIlIIlI)) : String.valueOf(new StringBuilder("http://").append(llllllllllllllIIIlIllIlIlIIlIlIl).append("/").append(llllllllllllllIIIlIllIlIlIIlIIlI));
    }
    
    private void terminateRequests(final Exception llllllllllllllIIIlIllIlIIlIIIIll) {
        if (this.listRequests.size() > 0) {
            if (!this.responseReceived) {
                final HttpPipelineRequest llllllllllllllIIIlIllIlIIlIIIllI = this.listRequests.remove(0);
                llllllllllllllIIIlIllIlIIlIIIllI.getHttpListener().failed(llllllllllllllIIIlIllIlIIlIIIllI.getHttpRequest(), llllllllllllllIIIlIllIlIIlIIIIll);
                llllllllllllllIIIlIllIlIIlIIIllI.setClosed(true);
            }
            while (this.listRequests.size() > 0) {
                final HttpPipelineRequest llllllllllllllIIIlIllIlIIlIIIlIl = this.listRequests.remove(0);
                HttpPipeline.addRequest(llllllllllllllIIIlIllIlIIlIIIlIl);
            }
        }
    }
    
    public synchronized InputStream getInputStream() throws InterruptedException, IOException {
        while (this.inputStream == null) {
            this.checkTimeout();
            this.wait(1000L);
        }
        return this.inputStream;
    }
    
    public synchronized void onExceptionReceive(final HttpPipelineRequest llllllllllllllIIIlIllIlIIlIlIlll, final Exception llllllllllllllIIIlIllIlIIlIlIlII) {
        this.terminate(llllllllllllllIIIlIllIlIIlIlIlII);
    }
    
    static {
        TIMEOUT_READ_MS = 5000;
        TIMEOUT_CONNECT_MS = 5000;
        LF = "\n";
        patternFullUrl = Pattern.compile("^[a-zA-Z]+://.*");
    }
}
