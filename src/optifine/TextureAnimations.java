package optifine;

import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.settings.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;

public class TextureAnimations
{
    private static /* synthetic */ TextureAnimation[] textureAnimations;
    
    public static TextureAnimation[] getTextureAnimations(final IResourcePack llllllllllllllIlIllIIlIllIIIIllI) {
        final String[] llllllllllllllIlIllIIlIllIIIIlIl = ResUtils.collectFiles(llllllllllllllIlIllIIlIllIIIIllI, "mcpatcher/anim", ".properties", null);
        if (llllllllllllllIlIllIIlIllIIIIlIl.length <= 0) {
            return null;
        }
        final ArrayList llllllllllllllIlIllIIlIllIIIIlII = new ArrayList();
        for (int llllllllllllllIlIllIIlIllIIIIIll = 0; llllllllllllllIlIllIIlIllIIIIIll < llllllllllllllIlIllIIlIllIIIIlIl.length; ++llllllllllllllIlIllIIlIllIIIIIll) {
            final String llllllllllllllIlIllIIlIllIIIIIlI = llllllllllllllIlIllIIlIllIIIIlIl[llllllllllllllIlIllIIlIllIIIIIll];
            Config.dbg(String.valueOf(new StringBuilder("Texture animation: ").append(llllllllllllllIlIllIIlIllIIIIIlI)));
            try {
                final ResourceLocation llllllllllllllIlIllIIlIllIIIIIIl = new ResourceLocation(llllllllllllllIlIllIIlIllIIIIIlI);
                final InputStream llllllllllllllIlIllIIlIllIIIIIII = llllllllllllllIlIllIIlIllIIIIllI.getInputStream(llllllllllllllIlIllIIlIllIIIIIIl);
                final Properties llllllllllllllIlIllIIlIlIlllllll = new Properties();
                llllllllllllllIlIllIIlIlIlllllll.load(llllllllllllllIlIllIIlIllIIIIIII);
                final TextureAnimation llllllllllllllIlIllIIlIlIllllllI = makeTextureAnimation(llllllllllllllIlIllIIlIlIlllllll, llllllllllllllIlIllIIlIllIIIIIIl);
                if (llllllllllllllIlIllIIlIlIllllllI != null) {
                    final ResourceLocation llllllllllllllIlIllIIlIlIlllllIl = new ResourceLocation(llllllllllllllIlIllIIlIlIllllllI.getDstTex());
                    if (Config.getDefiningResourcePack(llllllllllllllIlIllIIlIlIlllllIl) != llllllllllllllIlIllIIlIllIIIIllI) {
                        Config.dbg(String.valueOf(new StringBuilder("Skipped: ").append(llllllllllllllIlIllIIlIllIIIIIlI).append(", target texture not loaded from same resource pack")));
                    }
                    else {
                        llllllllllllllIlIllIIlIllIIIIlII.add(llllllllllllllIlIllIIlIlIllllllI);
                    }
                }
            }
            catch (FileNotFoundException llllllllllllllIlIllIIlIlIlllllII) {
                Config.warn(String.valueOf(new StringBuilder("File not found: ").append(llllllllllllllIlIllIIlIlIlllllII.getMessage())));
            }
            catch (IOException llllllllllllllIlIllIIlIlIllllIll) {
                llllllllllllllIlIllIIlIlIllllIll.printStackTrace();
            }
        }
        final TextureAnimation[] llllllllllllllIlIllIIlIlIllllIlI = llllllllllllllIlIllIIlIllIIIIlII.toArray(new TextureAnimation[llllllllllllllIlIllIIlIllIIIIlII.size()]);
        return llllllllllllllIlIllIIlIlIllllIlI;
    }
    
    private static byte[] loadImage(final String llllllllllllllIlIllIIlIlIIIllIlI, final int llllllllllllllIlIllIIlIlIIIllIIl) {
        final GameSettings llllllllllllllIlIllIIlIlIIlIlllI = Config.getGameSettings();
        try {
            final ResourceLocation llllllllllllllIlIllIIlIlIIlIllIl = new ResourceLocation(llllllllllllllIlIllIIlIlIIIllIlI);
            final InputStream llllllllllllllIlIllIIlIlIIlIllII = Config.getResourceStream(llllllllllllllIlIllIIlIlIIlIllIl);
            if (llllllllllllllIlIllIIlIlIIlIllII == null) {
                return null;
            }
            BufferedImage llllllllllllllIlIllIIlIlIIlIlIll = readTextureImage(llllllllllllllIlIllIIlIlIIlIllII);
            llllllllllllllIlIllIIlIlIIlIllII.close();
            if (llllllllllllllIlIllIIlIlIIlIlIll == null) {
                return null;
            }
            if (llllllllllllllIlIllIIlIlIIIllIIl > 0 && llllllllllllllIlIllIIlIlIIlIlIll.getWidth() != llllllllllllllIlIllIIlIlIIIllIIl) {
                final double llllllllllllllIlIllIIlIlIIlIlIlI = llllllllllllllIlIllIIlIlIIlIlIll.getHeight() / llllllllllllllIlIllIIlIlIIlIlIll.getWidth();
                final int llllllllllllllIlIllIIlIlIIlIlIIl = (int)(llllllllllllllIlIllIIlIlIIIllIIl * llllllllllllllIlIllIIlIlIIlIlIlI);
                llllllllllllllIlIllIIlIlIIlIlIll = scaleBufferedImage(llllllllllllllIlIllIIlIlIIlIlIll, llllllllllllllIlIllIIlIlIIIllIIl, llllllllllllllIlIllIIlIlIIlIlIIl);
            }
            final int llllllllllllllIlIllIIlIlIIlIlIII = llllllllllllllIlIllIIlIlIIlIlIll.getWidth();
            final int llllllllllllllIlIllIIlIlIIlIIlll = llllllllllllllIlIllIIlIlIIlIlIll.getHeight();
            final int[] llllllllllllllIlIllIIlIlIIlIIllI = new int[llllllllllllllIlIllIIlIlIIlIlIII * llllllllllllllIlIllIIlIlIIlIIlll];
            final byte[] llllllllllllllIlIllIIlIlIIlIIlIl = new byte[llllllllllllllIlIllIIlIlIIlIlIII * llllllllllllllIlIllIIlIlIIlIIlll * 4];
            llllllllllllllIlIllIIlIlIIlIlIll.getRGB(0, 0, llllllllllllllIlIllIIlIlIIlIlIII, llllllllllllllIlIllIIlIlIIlIIlll, llllllllllllllIlIllIIlIlIIlIIllI, 0, llllllllllllllIlIllIIlIlIIlIlIII);
            for (int llllllllllllllIlIllIIlIlIIlIIlII = 0; llllllllllllllIlIllIIlIlIIlIIlII < llllllllllllllIlIllIIlIlIIlIIllI.length; ++llllllllllllllIlIllIIlIlIIlIIlII) {
                final int llllllllllllllIlIllIIlIlIIlIIIll = llllllllllllllIlIllIIlIlIIlIIllI[llllllllllllllIlIllIIlIlIIlIIlII] >> 24 & 0xFF;
                int llllllllllllllIlIllIIlIlIIlIIIlI = llllllllllllllIlIllIIlIlIIlIIllI[llllllllllllllIlIllIIlIlIIlIIlII] >> 16 & 0xFF;
                int llllllllllllllIlIllIIlIlIIlIIIIl = llllllllllllllIlIllIIlIlIIlIIllI[llllllllllllllIlIllIIlIlIIlIIlII] >> 8 & 0xFF;
                int llllllllllllllIlIllIIlIlIIlIIIII = llllllllllllllIlIllIIlIlIIlIIllI[llllllllllllllIlIllIIlIlIIlIIlII] & 0xFF;
                if (llllllllllllllIlIllIIlIlIIlIlllI != null && llllllllllllllIlIllIIlIlIIlIlllI.anaglyph) {
                    final int llllllllllllllIlIllIIlIlIIIlllll = (llllllllllllllIlIllIIlIlIIlIIIlI * 30 + llllllllllllllIlIllIIlIlIIlIIIIl * 59 + llllllllllllllIlIllIIlIlIIlIIIII * 11) / 100;
                    final int llllllllllllllIlIllIIlIlIIIllllI = (llllllllllllllIlIllIIlIlIIlIIIlI * 30 + llllllllllllllIlIllIIlIlIIlIIIIl * 70) / 100;
                    final int llllllllllllllIlIllIIlIlIIIlllIl = (llllllllllllllIlIllIIlIlIIlIIIlI * 30 + llllllllllllllIlIllIIlIlIIlIIIII * 70) / 100;
                    llllllllllllllIlIllIIlIlIIlIIIlI = llllllllllllllIlIllIIlIlIIIlllll;
                    llllllllllllllIlIllIIlIlIIlIIIIl = llllllllllllllIlIllIIlIlIIIllllI;
                    llllllllllllllIlIllIIlIlIIlIIIII = llllllllllllllIlIllIIlIlIIIlllIl;
                }
                llllllllllllllIlIllIIlIlIIlIIlIl[llllllllllllllIlIllIIlIlIIlIIlII * 4 + 0] = (byte)llllllllllllllIlIllIIlIlIIlIIIlI;
                llllllllllllllIlIllIIlIlIIlIIlIl[llllllllllllllIlIllIIlIlIIlIIlII * 4 + 1] = (byte)llllllllllllllIlIllIIlIlIIlIIIIl;
                llllllllllllllIlIllIIlIlIIlIIlIl[llllllllllllllIlIllIIlIlIIlIIlII * 4 + 2] = (byte)llllllllllllllIlIllIIlIlIIlIIIII;
                llllllllllllllIlIllIIlIlIIlIIlIl[llllllllllllllIlIllIIlIlIIlIIlII * 4 + 3] = (byte)llllllllllllllIlIllIIlIlIIlIIIll;
            }
            return llllllllllllllIlIllIIlIlIIlIIlIl;
        }
        catch (FileNotFoundException llllllllllllllIlIllIIlIlIIIlllII) {
            return null;
        }
        catch (Exception llllllllllllllIlIllIIlIlIIIllIll) {
            llllllllllllllIlIllIIlIlIIIllIll.printStackTrace();
            return null;
        }
    }
    
    public static void reset() {
        TextureAnimations.textureAnimations = null;
    }
    
    public static TextureAnimation makeTextureAnimation(final Properties llllllllllllllIlIllIIlIlIlIlIlll, final ResourceLocation llllllllllllllIlIllIIlIlIllIIIlI) {
        String llllllllllllllIlIllIIlIlIllIIIIl = llllllllllllllIlIllIIlIlIlIlIlll.getProperty("from");
        String llllllllllllllIlIllIIlIlIllIIIII = llllllllllllllIlIllIIlIlIlIlIlll.getProperty("to");
        final int llllllllllllllIlIllIIlIlIlIlllll = Config.parseInt(llllllllllllllIlIllIIlIlIlIlIlll.getProperty("x"), -1);
        final int llllllllllllllIlIllIIlIlIlIllllI = Config.parseInt(llllllllllllllIlIllIIlIlIlIlIlll.getProperty("y"), -1);
        final int llllllllllllllIlIllIIlIlIlIlllIl = Config.parseInt(llllllllllllllIlIllIIlIlIlIlIlll.getProperty("w"), -1);
        final int llllllllllllllIlIllIIlIlIlIlllII = Config.parseInt(llllllllllllllIlIllIIlIlIlIlIlll.getProperty("h"), -1);
        if (llllllllllllllIlIllIIlIlIllIIIIl == null || llllllllllllllIlIllIIlIlIllIIIII == null) {
            Config.warn("TextureAnimation: Source or target texture not specified");
            return null;
        }
        if (llllllllllllllIlIllIIlIlIlIlllll < 0 || llllllllllllllIlIllIIlIlIlIllllI < 0 || llllllllllllllIlIllIIlIlIlIlllIl < 0 || llllllllllllllIlIllIIlIlIlIlllII < 0) {
            Config.warn("TextureAnimation: Invalid coordinates");
            return null;
        }
        llllllllllllllIlIllIIlIlIllIIIIl = llllllllllllllIlIllIIlIlIllIIIIl.trim();
        llllllllllllllIlIllIIlIlIllIIIII = llllllllllllllIlIllIIlIlIllIIIII.trim();
        final String llllllllllllllIlIllIIlIlIlIllIll = TextureUtils.getBasePath(llllllllllllllIlIllIIlIlIllIIIlI.getResourcePath());
        llllllllllllllIlIllIIlIlIllIIIIl = TextureUtils.fixResourcePath(llllllllllllllIlIllIIlIlIllIIIIl, llllllllllllllIlIllIIlIlIlIllIll);
        llllllllllllllIlIllIIlIlIllIIIII = TextureUtils.fixResourcePath(llllllllllllllIlIllIIlIlIllIIIII, llllllllllllllIlIllIIlIlIlIllIll);
        final byte[] llllllllllllllIlIllIIlIlIlIllIlI = getCustomTextureData(llllllllllllllIlIllIIlIlIllIIIIl, llllllllllllllIlIllIIlIlIlIlllIl);
        if (llllllllllllllIlIllIIlIlIlIllIlI == null) {
            Config.warn(String.valueOf(new StringBuilder("TextureAnimation: Source texture not found: ").append(llllllllllllllIlIllIIlIlIllIIIII)));
            return null;
        }
        final ResourceLocation llllllllllllllIlIllIIlIlIlIllIIl = new ResourceLocation(llllllllllllllIlIllIIlIlIllIIIII);
        if (!Config.hasResource(llllllllllllllIlIllIIlIlIlIllIIl)) {
            Config.warn(String.valueOf(new StringBuilder("TextureAnimation: Target texture not found: ").append(llllllllllllllIlIllIIlIlIllIIIII)));
            return null;
        }
        final TextureAnimation llllllllllllllIlIllIIlIlIlIllIII = new TextureAnimation(llllllllllllllIlIllIIlIlIllIIIIl, llllllllllllllIlIllIIlIlIlIllIlI, llllllllllllllIlIllIIlIlIllIIIII, llllllllllllllIlIllIIlIlIlIllIIl, llllllllllllllIlIllIIlIlIlIlllll, llllllllllllllIlIllIIlIlIlIllllI, llllllllllllllIlIllIIlIlIlIlllIl, llllllllllllllIlIllIIlIlIlIlllII, llllllllllllllIlIllIIlIlIlIlIlll, 1);
        return llllllllllllllIlIllIIlIlIlIllIII;
    }
    
    public static void update() {
        TextureAnimations.textureAnimations = null;
        final IResourcePack[] llllllllllllllIlIllIIlIllIlIlIII = Config.getResourcePacks();
        TextureAnimations.textureAnimations = getTextureAnimations(llllllllllllllIlIllIIlIllIlIlIII);
        if (Config.isAnimatedTextures()) {
            updateAnimations();
        }
    }
    
    public static byte[] getCustomTextureData(final String llllllllllllllIlIllIIlIlIlIIIlIl, final int llllllllllllllIlIllIIlIlIlIIIlll) {
        byte[] llllllllllllllIlIllIIlIlIlIIIllI = loadImage(llllllllllllllIlIllIIlIlIlIIIlIl, llllllllllllllIlIllIIlIlIlIIIlll);
        if (llllllllllllllIlIllIIlIlIlIIIllI == null) {
            llllllllllllllIlIllIIlIlIlIIIllI = loadImage(String.valueOf(new StringBuilder("/anim").append(llllllllllllllIlIllIIlIlIlIIIlIl)), llllllllllllllIlIllIIlIlIlIIIlll);
        }
        return llllllllllllllIlIllIIlIlIlIIIllI;
    }
    
    public static void updateAnimations() {
        if (TextureAnimations.textureAnimations != null) {
            for (int llllllllllllllIlIllIIlIllIlIIlII = 0; llllllllllllllIlIllIIlIllIlIIlII < TextureAnimations.textureAnimations.length; ++llllllllllllllIlIllIIlIllIlIIlII) {
                final TextureAnimation llllllllllllllIlIllIIlIllIlIIIll = TextureAnimations.textureAnimations[llllllllllllllIlIllIIlIllIlIIlII];
                llllllllllllllIlIllIIlIllIlIIIll.updateTexture();
            }
        }
    }
    
    public static void updateCustomAnimations() {
        if (TextureAnimations.textureAnimations != null && Config.isAnimatedTextures()) {
            updateAnimations();
        }
    }
    
    public static TextureAnimation[] getTextureAnimations(final IResourcePack[] llllllllllllllIlIllIIlIllIIlIlIl) {
        final ArrayList llllllllllllllIlIllIIlIllIIllIlI = new ArrayList();
        for (int llllllllllllllIlIllIIlIllIIllIIl = 0; llllllllllllllIlIllIIlIllIIllIIl < llllllllllllllIlIllIIlIllIIlIlIl.length; ++llllllllllllllIlIllIIlIllIIllIIl) {
            final IResourcePack llllllllllllllIlIllIIlIllIIllIII = llllllllllllllIlIllIIlIllIIlIlIl[llllllllllllllIlIllIIlIllIIllIIl];
            final TextureAnimation[] llllllllllllllIlIllIIlIllIIlIlll = getTextureAnimations(llllllllllllllIlIllIIlIllIIllIII);
            if (llllllllllllllIlIllIIlIllIIlIlll != null) {
                llllllllllllllIlIllIIlIllIIllIlI.addAll(Arrays.asList(llllllllllllllIlIllIIlIllIIlIlll));
            }
        }
        final TextureAnimation[] llllllllllllllIlIllIIlIllIIlIllI = llllllllllllllIlIllIIlIllIIllIlI.toArray(new TextureAnimation[llllllllllllllIlIllIIlIllIIllIlI.size()]);
        return llllllllllllllIlIllIIlIllIIlIllI;
    }
    
    private static BufferedImage readTextureImage(final InputStream llllllllllllllIlIllIIlIlIIIIIllI) throws IOException {
        final BufferedImage llllllllllllllIlIllIIlIlIIIIIlIl = ImageIO.read(llllllllllllllIlIllIIlIlIIIIIllI);
        llllllllllllllIlIllIIlIlIIIIIllI.close();
        return llllllllllllllIlIllIIlIlIIIIIlIl;
    }
    
    static {
        TextureAnimations.textureAnimations = null;
    }
    
    public static BufferedImage scaleBufferedImage(final BufferedImage llllllllllllllIlIllIIlIIlllllIII, final int llllllllllllllIlIllIIlIIllllllII, final int llllllllllllllIlIllIIlIIllllIllI) {
        final BufferedImage llllllllllllllIlIllIIlIIlllllIlI = new BufferedImage(llllllllllllllIlIllIIlIIllllllII, llllllllllllllIlIllIIlIIllllIllI, 2);
        final Graphics2D llllllllllllllIlIllIIlIIlllllIIl = llllllllllllllIlIllIIlIIlllllIlI.createGraphics();
        llllllllllllllIlIllIIlIIlllllIIl.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        llllllllllllllIlIllIIlIIlllllIIl.drawImage(llllllllllllllIlIllIIlIIlllllIII, 0, 0, llllllllllllllIlIllIIlIIllllllII, llllllllllllllIlIllIIlIIllllIllI, null);
        return llllllllllllllIlIllIIlIIlllllIlI;
    }
}
