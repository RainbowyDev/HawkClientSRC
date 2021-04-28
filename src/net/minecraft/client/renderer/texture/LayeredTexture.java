package net.minecraft.client.renderer.texture;

import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;

public class LayeredTexture extends AbstractTexture
{
    public final /* synthetic */ List layeredTextureNames;
    private static final /* synthetic */ Logger logger;
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllllllIllllllIllIlIll) throws IOException {
        this.deleteGlTexture();
        BufferedImage lllllllllllllllllIllllllIllIlIlI = null;
        try {
            for (final String lllllllllllllllllIllllllIllIlIII : this.layeredTextureNames) {
                if (lllllllllllllllllIllllllIllIlIII != null) {
                    final InputStream lllllllllllllllllIllllllIllIIlll = lllllllllllllllllIllllllIllIlIll.getResource(new ResourceLocation(lllllllllllllllllIllllllIllIlIII)).getInputStream();
                    final BufferedImage lllllllllllllllllIllllllIllIIllI = TextureUtil.func_177053_a(lllllllllllllllllIllllllIllIIlll);
                    if (lllllllllllllllllIllllllIllIlIlI == null) {
                        lllllllllllllllllIllllllIllIlIlI = new BufferedImage(lllllllllllllllllIllllllIllIIllI.getWidth(), lllllllllllllllllIllllllIllIIllI.getHeight(), 2);
                    }
                    lllllllllllllllllIllllllIllIlIlI.getGraphics().drawImage(lllllllllllllllllIllllllIllIIllI, 0, 0, null);
                }
            }
        }
        catch (IOException lllllllllllllllllIllllllIllIIlIl) {
            LayeredTexture.logger.error("Couldn't load layered image", (Throwable)lllllllllllllllllIllllllIllIIlIl);
            return;
        }
        TextureUtil.uploadTextureImage(this.getGlTextureId(), lllllllllllllllllIllllllIllIlIlI);
    }
    
    public LayeredTexture(final String... lllllllllllllllllIllllllIlllIllI) {
        this.layeredTextureNames = Lists.newArrayList((Object[])lllllllllllllllllIllllllIlllIllI);
    }
    
    static {
        __OBFID = "CL_00001051";
        logger = LogManager.getLogger();
    }
}
