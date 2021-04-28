package optifine;

import net.minecraft.client.*;

public class FileDownloadThread extends Thread
{
    private /* synthetic */ IFileDownloadListener listener;
    private /* synthetic */ String urlString;
    
    @Override
    public void run() {
        try {
            final byte[] llllllllllllllllIlIlIIlIlllIIIll = HttpPipeline.get(this.urlString, Minecraft.getMinecraft().getProxy());
            this.listener.fileDownloadFinished(this.urlString, llllllllllllllllIlIlIIlIlllIIIll, null);
        }
        catch (Exception llllllllllllllllIlIlIIlIlllIIIlI) {
            this.listener.fileDownloadFinished(this.urlString, null, llllllllllllllllIlIlIIlIlllIIIlI);
        }
    }
    
    public FileDownloadThread(final String llllllllllllllllIlIlIIlIlllIlIll, final IFileDownloadListener llllllllllllllllIlIlIIlIlllIIlll) {
        this.urlString = null;
        this.listener = null;
        this.urlString = llllllllllllllllIlIlIIlIlllIlIll;
        this.listener = llllllllllllllllIlIlIIlIlllIIlll;
    }
    
    public IFileDownloadListener getListener() {
        return this.listener;
    }
    
    public String getUrlString() {
        return this.urlString;
    }
}
