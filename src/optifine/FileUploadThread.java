package optifine;

import java.util.*;

public class FileUploadThread extends Thread
{
    private /* synthetic */ Map headers;
    private /* synthetic */ String urlString;
    private /* synthetic */ byte[] content;
    private /* synthetic */ IFileUploadListener listener;
    
    public IFileUploadListener getListener() {
        return this.listener;
    }
    
    @Override
    public void run() {
        try {
            HttpUtils.post(this.urlString, this.headers, this.content);
            this.listener.fileUploadFinished(this.urlString, this.content, null);
        }
        catch (Exception llllllllllllllllIIIllllIIllIIIlI) {
            this.listener.fileUploadFinished(this.urlString, this.content, llllllllllllllllIIIllllIIllIIIlI);
        }
    }
    
    public FileUploadThread(final String llllllllllllllllIIIllllIIllIlllI, final Map llllllllllllllllIIIllllIIllIlIII, final byte[] llllllllllllllllIIIllllIIllIIlll, final IFileUploadListener llllllllllllllllIIIllllIIllIlIll) {
        this.urlString = llllllllllllllllIIIllllIIllIlllI;
        this.headers = llllllllllllllllIIIllllIIllIlIII;
        this.content = llllllllllllllllIIIllllIIllIIlll;
        this.listener = llllllllllllllllIIIllllIIllIlIll;
    }
    
    public byte[] getContent() {
        return this.content;
    }
    
    public String getUrlString() {
        return this.urlString;
    }
}
