package optifine;

import java.awt.image.*;
import java.awt.*;
import net.minecraft.client.entity.*;
import org.apache.commons.io.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;

public class CapeUtils
{
    public static BufferedImage parseCape(final BufferedImage lllllllllllllllIllllIllllllIllll) {
        int lllllllllllllllIllllIllllllIlllI = 64;
        int lllllllllllllllIllllIllllllIllIl = 32;
        for (int lllllllllllllllIllllIllllllIllII = lllllllllllllllIllllIllllllIllll.getWidth(), lllllllllllllllIllllIllllllIlIll = lllllllllllllllIllllIllllllIllll.getHeight(); lllllllllllllllIllllIllllllIlllI < lllllllllllllllIllllIllllllIllII || lllllllllllllllIllllIllllllIllIl < lllllllllllllllIllllIllllllIlIll; lllllllllllllllIllllIllllllIlllI *= 2, lllllllllllllllIllllIllllllIllIl *= 2) {}
        final BufferedImage lllllllllllllllIllllIllllllIlIlI = new BufferedImage(lllllllllllllllIllllIllllllIlllI, lllllllllllllllIllllIllllllIllIl, 2);
        final Graphics lllllllllllllllIllllIllllllIlIIl = lllllllllllllllIllllIllllllIlIlI.getGraphics();
        lllllllllllllllIllllIllllllIlIIl.drawImage(lllllllllllllllIllllIllllllIllll, 0, 0, null);
        lllllllllllllllIllllIllllllIlIIl.dispose();
        return lllllllllllllllIllllIllllllIlIlI;
    }
    
    public static void downloadCape(final AbstractClientPlayer lllllllllllllllIlllllIIIIIIIlIII) {
        final String lllllllllllllllIlllllIIIIIIIIlll = lllllllllllllllIlllllIIIIIIIlIII.getNameClear();
        if (lllllllllllllllIlllllIIIIIIIIlll != null && !lllllllllllllllIlllllIIIIIIIIlll.isEmpty()) {
            final String lllllllllllllllIlllllIIIIIIIIllI = String.valueOf(new StringBuilder("http://s.optifine.net/capes/").append(lllllllllllllllIlllllIIIIIIIIlll).append(".png"));
            final String lllllllllllllllIlllllIIIIIIIIlIl = FilenameUtils.getBaseName(lllllllllllllllIlllllIIIIIIIIllI);
            final ResourceLocation lllllllllllllllIlllllIIIIIIIIlII = new ResourceLocation(String.valueOf(new StringBuilder("capeof/").append(lllllllllllllllIlllllIIIIIIIIlIl)));
            final TextureManager lllllllllllllllIlllllIIIIIIIIIll = Minecraft.getMinecraft().getTextureManager();
            final ITextureObject lllllllllllllllIlllllIIIIIIIIIlI = lllllllllllllllIlllllIIIIIIIIIll.getTexture(lllllllllllllllIlllllIIIIIIIIlII);
            if (lllllllllllllllIlllllIIIIIIIIIlI != null && lllllllllllllllIlllllIIIIIIIIIlI instanceof ThreadDownloadImageData) {
                final ThreadDownloadImageData lllllllllllllllIlllllIIIIIIIIIIl = (ThreadDownloadImageData)lllllllllllllllIlllllIIIIIIIIIlI;
                if (lllllllllllllllIlllllIIIIIIIIIIl.imageFound != null) {
                    if (lllllllllllllllIlllllIIIIIIIIIIl.imageFound) {
                        lllllllllllllllIlllllIIIIIIIlIII.setLocationOfCape(lllllllllllllllIlllllIIIIIIIIlII);
                    }
                    return;
                }
            }
            final IImageBuffer lllllllllllllllIlllllIIIIIIIIIII = new IImageBuffer() {
                @Override
                public BufferedImage parseUserSkin(final BufferedImage llIlIllIlIIlIII) {
                    return CapeUtils.parseCape(llIlIllIlIIlIII);
                }
                
                @Override
                public void func_152634_a() {
                    lllllllllllllllIlllllIIIIIIIlIII.setLocationOfCape(lllllllllllllllIlllllIIIIIIIIlII);
                }
            };
            final ThreadDownloadImageData lllllllllllllllIllllIlllllllllll = new ThreadDownloadImageData(null, lllllllllllllllIlllllIIIIIIIIllI, null, lllllllllllllllIlllllIIIIIIIIIII);
            lllllllllllllllIllllIlllllllllll.pipeline = true;
            lllllllllllllllIlllllIIIIIIIIIll.loadTexture(lllllllllllllllIlllllIIIIIIIIlII, lllllllllllllllIllllIlllllllllll);
        }
    }
}
