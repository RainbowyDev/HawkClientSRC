package optifine;

import java.nio.charset.*;
import java.util.*;
import java.io.*;

public class HttpPipelineReceiver extends Thread
{
    private /* synthetic */ HttpPipelineConnection httpPipelineConnection;
    private static final /* synthetic */ Charset ASCII;
    
    public HttpPipelineReceiver(final HttpPipelineConnection llllllllllllllIIIIIlIIllllIIlIll) {
        super("HttpPipelineReceiver");
        this.httpPipelineConnection = null;
        this.httpPipelineConnection = llllllllllllllIIIIIlIIllllIIlIll;
    }
    
    static {
        CR = '\r';
        HEADER_CONTENT_LENGTH = "Content-Length";
        LF = '\n';
        ASCII = Charset.forName("ASCII");
    }
    
    private HttpResponse readResponse(final InputStream llllllllllllllIIIIIlIIlllIIllllI) throws IOException {
        final String llllllllllllllIIIIIlIIlllIlIllIl = this.readLine(llllllllllllllIIIIIlIIlllIIllllI);
        final String[] llllllllllllllIIIIIlIIlllIlIllII = Config.tokenize(llllllllllllllIIIIIlIIlllIlIllIl, " ");
        if (llllllllllllllIIIIIlIIlllIlIllII.length < 3) {
            throw new IOException(String.valueOf(new StringBuilder("Invalid status line: ").append(llllllllllllllIIIIIlIIlllIlIllIl)));
        }
        final String llllllllllllllIIIIIlIIlllIlIlIll = llllllllllllllIIIIIlIIlllIlIllII[0];
        final int llllllllllllllIIIIIlIIlllIlIlIlI = Config.parseInt(llllllllllllllIIIIIlIIlllIlIllII[1], 0);
        final String llllllllllllllIIIIIlIIlllIlIlIIl = llllllllllllllIIIIIlIIlllIlIllII[2];
        final LinkedHashMap llllllllllllllIIIIIlIIlllIlIlIII = new LinkedHashMap();
        while (true) {
            final String llllllllllllllIIIIIlIIlllIlIIlll = this.readLine(llllllllllllllIIIIIlIIlllIIllllI);
            if (llllllllllllllIIIIIlIIlllIlIIlll.length() <= 0) {
                break;
            }
            final int llllllllllllllIIIIIlIIlllIlIIIIl = llllllllllllllIIIIIlIIlllIlIIlll.indexOf(":");
            if (llllllllllllllIIIIIlIIlllIlIIIIl <= 0) {
                continue;
            }
            final String llllllllllllllIIIIIlIIlllIlIIlIl = llllllllllllllIIIIIlIIlllIlIIlll.substring(0, llllllllllllllIIIIIlIIlllIlIIIIl).trim();
            final String llllllllllllllIIIIIlIIlllIlIIIII = llllllllllllllIIIIIlIIlllIlIIlll.substring(llllllllllllllIIIIIlIIlllIlIIIIl + 1).trim();
            llllllllllllllIIIIIlIIlllIlIlIII.put(llllllllllllllIIIIIlIIlllIlIIlIl, llllllllllllllIIIIIlIIlllIlIIIII);
        }
        byte[] llllllllllllllIIIIIlIIlllIlIIlII = null;
        final String llllllllllllllIIIIIlIIlllIlIIIll = llllllllllllllIIIIIlIIlllIlIlIII.get("Content-Length");
        if (llllllllllllllIIIIIlIIlllIlIIIll != null) {
            final int llllllllllllllIIIIIlIIlllIlIIIlI = Config.parseInt(llllllllllllllIIIIIlIIlllIlIIIll, -1);
            if (llllllllllllllIIIIIlIIlllIlIIIlI > 0) {
                llllllllllllllIIIIIlIIlllIlIIlII = new byte[llllllllllllllIIIIIlIIlllIlIIIlI];
                this.readFull(llllllllllllllIIIIIlIIlllIlIIlII, llllllllllllllIIIIIlIIlllIIllllI);
            }
        }
        else {
            final String llllllllllllllIIIIIlIIlllIlIIllI = llllllllllllllIIIIIlIIlllIlIlIII.get("Transfer-Encoding");
            if (Config.equals(llllllllllllllIIIIIlIIlllIlIIllI, "chunked")) {
                llllllllllllllIIIIIlIIlllIlIIlII = this.readContentChunked(llllllllllllllIIIIIlIIlllIIllllI);
            }
        }
        return new HttpResponse(llllllllllllllIIIIIlIIlllIlIlIlI, llllllllllllllIIIIIlIIlllIlIllIl, llllllllllllllIIIIIlIIlllIlIlIII, llllllllllllllIIIIIlIIlllIlIIlII);
    }
    
    private byte[] readContentChunked(final InputStream llllllllllllllIIIIIlIIlllIIIlIlI) throws IOException {
        final ByteArrayOutputStream llllllllllllllIIIIIlIIlllIIIlIIl = new ByteArrayOutputStream();
        int llllllllllllllIIIIIlIIlllIIIlIII;
        do {
            final String llllllllllllllIIIIIlIIlllIIIIlll = this.readLine(llllllllllllllIIIIIlIIlllIIIlIlI);
            final String[] llllllllllllllIIIIIlIIlllIIIIllI = Config.tokenize(llllllllllllllIIIIIlIIlllIIIIlll, "; ");
            llllllllllllllIIIIIlIIlllIIIlIII = Integer.parseInt(llllllllllllllIIIIIlIIlllIIIIllI[0], 16);
            final byte[] llllllllllllllIIIIIlIIlllIIIIlIl = new byte[llllllllllllllIIIIIlIIlllIIIlIII];
            this.readFull(llllllllllllllIIIIIlIIlllIIIIlIl, llllllllllllllIIIIIlIIlllIIIlIlI);
            llllllllllllllIIIIIlIIlllIIIlIIl.write(llllllllllllllIIIIIlIIlllIIIIlIl);
            this.readLine(llllllllllllllIIIIIlIIlllIIIlIlI);
        } while (llllllllllllllIIIIIlIIlllIIIlIII != 0);
        return llllllllllllllIIIIIlIIlllIIIlIIl.toByteArray();
    }
    
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            HttpPipelineRequest llllllllllllllIIIIIlIIllllIIIlIl = null;
            try {
                llllllllllllllIIIIIlIIllllIIIlIl = this.httpPipelineConnection.getNextRequestReceive();
                final InputStream llllllllllllllIIIIIlIIllllIIIlII = this.httpPipelineConnection.getInputStream();
                final HttpResponse llllllllllllllIIIIIlIIllllIIIIll = this.readResponse(llllllllllllllIIIIIlIIllllIIIlII);
                this.httpPipelineConnection.onResponseReceived(llllllllllllllIIIIIlIIllllIIIlIl, llllllllllllllIIIIIlIIllllIIIIll);
            }
            catch (InterruptedException llllllllllllllIIIIIlIIllllIIIIlI) {}
            catch (Exception llllllllllllllIIIIIlIIllllIIIIIl) {
                this.httpPipelineConnection.onExceptionReceive(llllllllllllllIIIIIlIIllllIIIlIl, llllllllllllllIIIIIlIIllllIIIIIl);
            }
        }
    }
    
    private String readLine(final InputStream llllllllllllllIIIIIlIIllIllIIIlI) throws IOException {
        final ByteArrayOutputStream llllllllllllllIIIIIlIIllIllIlIII = new ByteArrayOutputStream();
        int llllllllllllllIIIIIlIIllIllIIlll = -1;
        boolean llllllllllllllIIIIIlIIllIllIIllI = false;
        while (true) {
            final int llllllllllllllIIIIIlIIllIllIIlIl = llllllllllllllIIIIIlIIllIllIIIlI.read();
            if (llllllllllllllIIIIIlIIllIllIIlIl < 0) {
                break;
            }
            llllllllllllllIIIIIlIIllIllIlIII.write(llllllllllllllIIIIIlIIllIllIIlIl);
            if (llllllllllllllIIIIIlIIllIllIIlll == 13 && llllllllllllllIIIIIlIIllIllIIlIl == 10) {
                llllllllllllllIIIIIlIIllIllIIllI = true;
                break;
            }
            llllllllllllllIIIIIlIIllIllIIlll = llllllllllllllIIIIIlIIllIllIIlIl;
        }
        final byte[] llllllllllllllIIIIIlIIllIllIIlII = llllllllllllllIIIIIlIIllIllIlIII.toByteArray();
        String llllllllllllllIIIIIlIIllIllIIIll = new String(llllllllllllllIIIIIlIIllIllIIlII, HttpPipelineReceiver.ASCII);
        if (llllllllllllllIIIIIlIIllIllIIllI) {
            llllllllllllllIIIIIlIIllIllIIIll = llllllllllllllIIIIIlIIllIllIIIll.substring(0, llllllllllllllIIIIIlIIllIllIIIll.length() - 2);
        }
        return llllllllllllllIIIIIlIIllIllIIIll;
    }
    
    private void readFull(final byte[] llllllllllllllIIIIIlIIllIllllIII, final InputStream llllllllllllllIIIIIlIIllIlllIlll) throws IOException {
        int llllllllllllllIIIIIlIIllIlllIllI;
        for (int llllllllllllllIIIIIlIIllIlllIlIl = 0; llllllllllllllIIIIIlIIllIlllIlIl < llllllllllllllIIIIIlIIllIllllIII.length; llllllllllllllIIIIIlIIllIlllIlIl += llllllllllllllIIIIIlIIllIlllIllI) {
            llllllllllllllIIIIIlIIllIlllIllI = llllllllllllllIIIIIlIIllIlllIlll.read(llllllllllllllIIIIIlIIllIllllIII, llllllllllllllIIIIIlIIllIlllIlIl, llllllllllllllIIIIIlIIllIllllIII.length - llllllllllllllIIIIIlIIllIlllIlIl);
            if (llllllllllllllIIIIIlIIllIlllIllI < 0) {
                throw new EOFException();
            }
        }
    }
}
