package net.minecraft.client.renderer.texture;

import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.resources.data.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.resources.*;
import java.awt.image.*;
import java.io.*;

public class SimpleTexture extends AbstractTexture
{
    protected final /* synthetic */ ResourceLocation textureLocation;
    private static final /* synthetic */ Logger logger;
    
    public SimpleTexture(final ResourceLocation lllllllllllllllIlIIIIIlIlIllIlll) {
        this.textureLocation = lllllllllllllllIlIIIIIlIlIllIlll;
    }
    
    static {
        __OBFID = "CL_00001052";
        logger = LogManager.getLogger();
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllllIlIIIIIlIlIlIIIll) throws IOException {
        this.deleteGlTexture();
        InputStream lllllllllllllllIlIIIIIlIlIlIlIll = null;
        try {
            final IResource lllllllllllllllIlIIIIIlIlIlIlIlI = lllllllllllllllIlIIIIIlIlIlIIIll.getResource(this.textureLocation);
            lllllllllllllllIlIIIIIlIlIlIlIll = lllllllllllllllIlIIIIIlIlIlIlIlI.getInputStream();
            final BufferedImage lllllllllllllllIlIIIIIlIlIlIlIIl = TextureUtil.func_177053_a(lllllllllllllllIlIIIIIlIlIlIlIll);
            boolean lllllllllllllllIlIIIIIlIlIlIlIII = false;
            boolean lllllllllllllllIlIIIIIlIlIlIIlll = false;
            if (lllllllllllllllIlIIIIIlIlIlIlIlI.hasMetadata()) {
                try {
                    final TextureMetadataSection lllllllllllllllIlIIIIIlIlIlIIllI = (TextureMetadataSection)lllllllllllllllIlIIIIIlIlIlIlIlI.getMetadata("texture");
                    if (lllllllllllllllIlIIIIIlIlIlIIllI != null) {
                        lllllllllllllllIlIIIIIlIlIlIlIII = lllllllllllllllIlIIIIIlIlIlIIllI.getTextureBlur();
                        lllllllllllllllIlIIIIIlIlIlIIlll = lllllllllllllllIlIIIIIlIlIlIIllI.getTextureClamp();
                    }
                }
                catch (RuntimeException lllllllllllllllIlIIIIIlIlIlIIlIl) {
                    SimpleTexture.logger.warn(String.valueOf(new StringBuilder("Failed reading metadata of: ").append(this.textureLocation)), (Throwable)lllllllllllllllIlIIIIIlIlIlIIlIl);
                }
            }
            if (Config.isShaders()) {
                ShadersTex.loadSimpleTexture(this.getGlTextureId(), lllllllllllllllIlIIIIIlIlIlIlIIl, lllllllllllllllIlIIIIIlIlIlIlIII, lllllllllllllllIlIIIIIlIlIlIIlll, lllllllllllllllIlIIIIIlIlIlIIIll, this.textureLocation, this.getMultiTexID());
            }
            else {
                TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), lllllllllllllllIlIIIIIlIlIlIlIIl, lllllllllllllllIlIIIIIlIlIlIlIII, lllllllllllllllIlIIIIIlIlIlIIlll);
            }
        }
        finally {
            if (lllllllllllllllIlIIIIIlIlIlIlIll != null) {
                lllllllllllllllIlIIIIIlIlIlIlIll.close();
            }
        }
        if (lllllllllllllllIlIIIIIlIlIlIlIll != null) {
            lllllllllllllllIlIIIIIlIlIlIlIll.close();
        }
    }
}
