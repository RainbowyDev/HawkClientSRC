package net.minecraft.client.renderer;

import java.util.concurrent.atomic.*;
import java.awt.image.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.*;
import javax.imageio.*;
import net.minecraft.client.*;
import org.apache.commons.io.*;
import java.io.*;
import java.net.*;
import optifine.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;

public class ThreadDownloadImageData extends SimpleTexture
{
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ AtomicInteger threadDownloadCounter;
    public /* synthetic */ boolean pipeline;
    private /* synthetic */ Thread imageThread;
    private final /* synthetic */ IImageBuffer imageBuffer;
    private /* synthetic */ boolean textureUploaded;
    private final /* synthetic */ String imageUrl;
    private final /* synthetic */ File field_152434_e;
    public /* synthetic */ Boolean imageFound;
    private /* synthetic */ BufferedImage bufferedImage;
    
    private void checkTextureUploaded() {
        if (!this.textureUploaded && this.bufferedImage != null) {
            this.textureUploaded = true;
            if (this.textureLocation != null) {
                this.deleteGlTexture();
            }
            TextureUtil.uploadTextureImage(super.getGlTextureId(), this.bufferedImage);
        }
    }
    
    public void setBufferedImage(final BufferedImage llllllllllllllllllIIllIIIlllIIll) {
        this.bufferedImage = llllllllllllllllllIIllIIIlllIIll;
        if (this.imageBuffer != null) {
            this.imageBuffer.func_152634_a();
        }
        this.imageFound = (this.bufferedImage != null);
    }
    
    @Override
    public void loadTexture(final IResourceManager llllllllllllllllllIIllIIIllIlllI) throws IOException {
        if (this.bufferedImage == null && this.textureLocation != null) {
            super.loadTexture(llllllllllllllllllIIllIIIllIlllI);
        }
        if (this.imageThread == null) {
            if (this.field_152434_e != null && this.field_152434_e.isFile()) {
                ThreadDownloadImageData.logger.debug("Loading http texture from local cache ({})", new Object[] { this.field_152434_e });
                try {
                    this.bufferedImage = ImageIO.read(this.field_152434_e);
                    if (this.imageBuffer != null) {
                        this.setBufferedImage(this.imageBuffer.parseUserSkin(this.bufferedImage));
                    }
                    this.imageFound = (this.bufferedImage != null);
                }
                catch (IOException llllllllllllllllllIIllIIIllIllIl) {
                    ThreadDownloadImageData.logger.error(String.valueOf(new StringBuilder("Couldn't load skin ").append(this.field_152434_e)), (Throwable)llllllllllllllllllIIllIIIllIllIl);
                    this.func_152433_a();
                }
            }
            else {
                this.func_152433_a();
            }
        }
    }
    
    @Override
    public int getGlTextureId() {
        this.checkTextureUploaded();
        return super.getGlTextureId();
    }
    
    private boolean shouldPipeline() {
        if (!this.pipeline) {
            return false;
        }
        final Proxy llllllllllllllllllIIllIIIllIIIll = Minecraft.getMinecraft().getProxy();
        return (llllllllllllllllllIIllIIIllIIIll.type() == Proxy.Type.DIRECT || llllllllllllllllllIIllIIIllIIIll.type() == Proxy.Type.SOCKS) && this.imageUrl.startsWith("http://");
    }
    
    private void loadPipelined() {
        try {
            final HttpRequest llllllllllllllllllIIllIIIlIllIII = HttpPipeline.makeRequest(this.imageUrl, Minecraft.getMinecraft().getProxy());
            final HttpResponse llllllllllllllllllIIllIIIlIlIlll = HttpPipeline.executeRequest(llllllllllllllllllIIllIIIlIllIII);
            if (llllllllllllllllllIIllIIIlIlIlll.getStatus() / 100 != 2) {
                return;
            }
            final byte[] llllllllllllllllllIIllIIIlIlIllI = llllllllllllllllllIIllIIIlIlIlll.getBody();
            final ByteArrayInputStream llllllllllllllllllIIllIIIlIlIlIl = new ByteArrayInputStream(llllllllllllllllllIIllIIIlIlIllI);
            BufferedImage llllllllllllllllllIIllIIIlIlIIll = null;
            if (this.field_152434_e != null) {
                FileUtils.copyInputStreamToFile((InputStream)llllllllllllllllllIIllIIIlIlIlIl, this.field_152434_e);
                final BufferedImage llllllllllllllllllIIllIIIlIlIlII = ImageIO.read(this.field_152434_e);
            }
            else {
                llllllllllllllllllIIllIIIlIlIIll = TextureUtil.func_177053_a(llllllllllllllllllIIllIIIlIlIlIl);
            }
            if (this.imageBuffer != null) {
                llllllllllllllllllIIllIIIlIlIIll = this.imageBuffer.parseUserSkin(llllllllllllllllllIIllIIIlIlIIll);
            }
            this.setBufferedImage(llllllllllllllllllIIllIIIlIlIIll);
        }
        catch (Exception llllllllllllllllllIIllIIIlIlIIlI) {
            ThreadDownloadImageData.logger.error(String.valueOf(new StringBuilder("Couldn't download http texture: ").append(llllllllllllllllllIIllIIIlIlIIlI.getClass().getName()).append(": ").append(llllllllllllllllllIIllIIIlIlIIlI.getMessage())));
            return;
        }
        finally {
            this.imageFound = (this.bufferedImage != null);
        }
        this.imageFound = (this.bufferedImage != null);
    }
    
    protected void func_152433_a() {
        this.imageThread = new Thread(String.valueOf(new StringBuilder("Texture Downloader #").append(ThreadDownloadImageData.threadDownloadCounter.incrementAndGet()))) {
            @Override
            public void run() {
                HttpURLConnection lllllllllllllllIIlIlIlIllllIIlII = null;
                ThreadDownloadImageData.logger.debug("Downloading http texture from {} to {}", new Object[] { ThreadDownloadImageData.this.imageUrl, ThreadDownloadImageData.this.field_152434_e });
                if (ThreadDownloadImageData.this.shouldPipeline()) {
                    ThreadDownloadImageData.this.loadPipelined();
                }
                else {
                    try {
                        lllllllllllllllIIlIlIlIllllIIlII = (HttpURLConnection)new URL(ThreadDownloadImageData.this.imageUrl).openConnection(Minecraft.getMinecraft().getProxy());
                        lllllllllllllllIIlIlIlIllllIIlII.setDoInput(true);
                        lllllllllllllllIIlIlIlIllllIIlII.setDoOutput(false);
                        lllllllllllllllIIlIlIlIllllIIlII.connect();
                        if (lllllllllllllllIIlIlIlIllllIIlII.getResponseCode() / 100 != 2) {
                            if (lllllllllllllllIIlIlIlIllllIIlII.getErrorStream() != null) {
                                Config.readAll(lllllllllllllllIIlIlIlIllllIIlII.getErrorStream());
                            }
                            return;
                        }
                        BufferedImage lllllllllllllllIIlIlIlIllllIIIlI = null;
                        if (ThreadDownloadImageData.this.field_152434_e != null) {
                            FileUtils.copyInputStreamToFile(lllllllllllllllIIlIlIlIllllIIlII.getInputStream(), ThreadDownloadImageData.this.field_152434_e);
                            final BufferedImage lllllllllllllllIIlIlIlIllllIIIll = ImageIO.read(ThreadDownloadImageData.this.field_152434_e);
                        }
                        else {
                            lllllllllllllllIIlIlIlIllllIIIlI = TextureUtil.func_177053_a(lllllllllllllllIIlIlIlIllllIIlII.getInputStream());
                        }
                        if (ThreadDownloadImageData.this.imageBuffer != null) {
                            lllllllllllllllIIlIlIlIllllIIIlI = ThreadDownloadImageData.this.imageBuffer.parseUserSkin(lllllllllllllllIIlIlIlIllllIIIlI);
                        }
                        ThreadDownloadImageData.this.setBufferedImage(lllllllllllllllIIlIlIlIllllIIIlI);
                    }
                    catch (Exception lllllllllllllllIIlIlIlIllllIIIIl) {
                        ThreadDownloadImageData.logger.error(String.valueOf(new StringBuilder("Couldn't download http texture: ").append(lllllllllllllllIIlIlIlIllllIIIIl.getClass().getName()).append(": ").append(lllllllllllllllIIlIlIlIllllIIIIl.getMessage())));
                        return;
                    }
                    finally {
                        if (lllllllllllllllIIlIlIlIllllIIlII != null) {
                            lllllllllllllllIIlIlIlIllllIIlII.disconnect();
                        }
                        ThreadDownloadImageData.this.imageFound = (ThreadDownloadImageData.this.bufferedImage != null);
                    }
                    if (lllllllllllllllIIlIlIlIllllIIlII != null) {
                        lllllllllllllllIIlIlIlIllllIIlII.disconnect();
                    }
                    ThreadDownloadImageData.this.imageFound = (ThreadDownloadImageData.this.bufferedImage != null);
                }
            }
        };
        this.imageThread.setDaemon(true);
        this.imageThread.start();
    }
    
    public ThreadDownloadImageData(final File llllllllllllllllllIIllIIlIIIIIlI, final String llllllllllllllllllIIllIIlIIIIllI, final ResourceLocation llllllllllllllllllIIllIIlIIIIlIl, final IImageBuffer llllllllllllllllllIIllIIIlllllll) {
        super(llllllllllllllllllIIllIIlIIIIlIl);
        this.imageFound = null;
        this.pipeline = false;
        this.field_152434_e = llllllllllllllllllIIllIIlIIIIIlI;
        this.imageUrl = llllllllllllllllllIIllIIlIIIIllI;
        this.imageBuffer = llllllllllllllllllIIllIIIlllllll;
    }
    
    static {
        __OBFID = "CL_00001049";
        logger = LogManager.getLogger();
        threadDownloadCounter = new AtomicInteger(0);
    }
}
