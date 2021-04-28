package optifine;

import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;

public class CustomSky
{
    private static /* synthetic */ CustomSkyLayer[][] worldSkyLayers;
    
    public static boolean hasSkyLayers(final World lllllllllllllllIIlIIIIlIlIlIllIl) {
        if (CustomSky.worldSkyLayers == null) {
            return false;
        }
        if (Config.getGameSettings().renderDistanceChunks < 8) {
            return false;
        }
        final int lllllllllllllllIIlIIIIlIlIlIllII = lllllllllllllllIIlIIIIlIlIlIllIl.provider.getDimensionId();
        if (lllllllllllllllIIlIIIIlIlIlIllII >= 0 && lllllllllllllllIIlIIIIlIlIlIllII < CustomSky.worldSkyLayers.length) {
            final CustomSkyLayer[] lllllllllllllllIIlIIIIlIlIlIlIll = CustomSky.worldSkyLayers[lllllllllllllllIIlIIIIlIlIlIllII];
            return lllllllllllllllIIlIIIIlIlIlIlIll != null && lllllllllllllllIIlIIIIlIlIlIlIll.length > 0;
        }
        return false;
    }
    
    public static void renderSky(final World lllllllllllllllIIlIIIIlIllIIIIII, final TextureManager lllllllllllllllIIlIIIIlIllIIlIll, final float lllllllllllllllIIlIIIIlIllIIlIlI, final float lllllllllllllllIIlIIIIlIllIIlIII) {
        if (CustomSky.worldSkyLayers != null && Config.getGameSettings().renderDistanceChunks >= 8) {
            final int lllllllllllllllIIlIIIIlIllIIIllI = lllllllllllllllIIlIIIIlIllIIIIII.provider.getDimensionId();
            if (lllllllllllllllIIlIIIIlIllIIIllI >= 0 && lllllllllllllllIIlIIIIlIllIIIllI < CustomSky.worldSkyLayers.length) {
                final CustomSkyLayer[] lllllllllllllllIIlIIIIlIllIIIlIl = CustomSky.worldSkyLayers[lllllllllllllllIIlIIIIlIllIIIllI];
                if (lllllllllllllllIIlIIIIlIllIIIlIl != null) {
                    final long lllllllllllllllIIlIIIIlIllIIIlII = lllllllllllllllIIlIIIIlIllIIIIII.getWorldTime();
                    final int lllllllllllllllIIlIIIIlIllIIIIll = (int)(lllllllllllllllIIlIIIIlIllIIIlII % 24000L);
                    for (int lllllllllllllllIIlIIIIlIllIIIIlI = 0; lllllllllllllllIIlIIIIlIllIIIIlI < lllllllllllllllIIlIIIIlIllIIIlIl.length; ++lllllllllllllllIIlIIIIlIllIIIIlI) {
                        final CustomSkyLayer lllllllllllllllIIlIIIIlIllIIIIIl = lllllllllllllllIIlIIIIlIllIIIlIl[lllllllllllllllIIlIIIIlIllIIIIlI];
                        if (lllllllllllllllIIlIIIIlIllIIIIIl.isActive(lllllllllllllllIIlIIIIlIllIIIIII, lllllllllllllllIIlIIIIlIllIIIIll)) {
                            lllllllllllllllIIlIIIIlIllIIIIIl.render(lllllllllllllllIIlIIIIlIllIIIIll, lllllllllllllllIIlIIIIlIllIIlIlI, lllllllllllllllIIlIIIIlIllIIlIII);
                        }
                    }
                    Blender.clearBlend(lllllllllllllllIIlIIIIlIllIIlIII);
                }
            }
        }
    }
    
    public static void update() {
        reset();
        if (Config.isCustomSky()) {
            CustomSky.worldSkyLayers = readCustomSkies();
        }
    }
    
    private static CustomSkyLayer[][] readCustomSkies() {
        final CustomSkyLayer[][] lllllllllllllllIIlIIIIllIIIlIlII = new CustomSkyLayer[10][0];
        final String lllllllllllllllIIlIIIIllIIIlIIlI = "mcpatcher/sky/world";
        int lllllllllllllllIIlIIIIllIIIlIIII = -1;
        for (int lllllllllllllllIIlIIIIllIIIIlllI = 0; lllllllllllllllIIlIIIIllIIIIlllI < lllllllllllllllIIlIIIIllIIIlIlII.length; ++lllllllllllllllIIlIIIIllIIIIlllI) {
            final String lllllllllllllllIIlIIIIllIIIIllII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlIIIIllIIIlIIlI)).append(lllllllllllllllIIlIIIIllIIIIlllI).append("/sky"));
            final ArrayList lllllllllllllllIIlIIIIllIIIIlIlI = new ArrayList();
            for (int lllllllllllllllIIlIIIIllIIIIlIIl = 1; lllllllllllllllIIlIIIIllIIIIlIIl < 1000; ++lllllllllllllllIIlIIIIllIIIIlIIl) {
                final String lllllllllllllllIIlIIIIllIIIIlIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlIIIIllIIIIllII)).append(lllllllllllllllIIlIIIIllIIIIlIIl).append(".properties"));
                try {
                    final ResourceLocation lllllllllllllllIIlIIIIllIIIIIllI = new ResourceLocation(lllllllllllllllIIlIIIIllIIIIlIII);
                    final InputStream lllllllllllllllIIlIIIIllIIIIIlII = Config.getResourceStream(lllllllllllllllIIlIIIIllIIIIIllI);
                    if (lllllllllllllllIIlIIIIllIIIIIlII == null) {
                        break;
                    }
                    final Properties lllllllllllllllIIlIIIIllIIIIIIll = new Properties();
                    lllllllllllllllIIlIIIIllIIIIIIll.load(lllllllllllllllIIlIIIIllIIIIIlII);
                    lllllllllllllllIIlIIIIllIIIIIlII.close();
                    Config.dbg(String.valueOf(new StringBuilder("CustomSky properties: ").append(lllllllllllllllIIlIIIIllIIIIlIII)));
                    final String lllllllllllllllIIlIIIIllIIIIIIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlIIIIllIIIIllII)).append(lllllllllllllllIIlIIIIllIIIIlIIl).append(".png"));
                    final CustomSkyLayer lllllllllllllllIIlIIIIllIIIIIIIl = new CustomSkyLayer(lllllllllllllllIIlIIIIllIIIIIIll, lllllllllllllllIIlIIIIllIIIIIIlI);
                    if (lllllllllllllllIIlIIIIllIIIIIIIl.isValid(lllllllllllllllIIlIIIIllIIIIlIII)) {
                        final ResourceLocation lllllllllllllllIIlIIIIllIIIIIIII = new ResourceLocation(lllllllllllllllIIlIIIIllIIIIIIIl.source);
                        final ITextureObject lllllllllllllllIIlIIIIlIllllllll = TextureUtils.getTexture(lllllllllllllllIIlIIIIllIIIIIIII);
                        if (lllllllllllllllIIlIIIIlIllllllll == null) {
                            Config.log(String.valueOf(new StringBuilder("CustomSky: Texture not found: ").append(lllllllllllllllIIlIIIIllIIIIIIII)));
                        }
                        else {
                            lllllllllllllllIIlIIIIllIIIIIIIl.textureId = lllllllllllllllIIlIIIIlIllllllll.getGlTextureId();
                            lllllllllllllllIIlIIIIllIIIIlIlI.add(lllllllllllllllIIlIIIIllIIIIIIIl);
                            lllllllllllllllIIlIIIIllIIIIIlII.close();
                        }
                    }
                }
                catch (FileNotFoundException lllllllllllllllIIlIIIIlIlllllllI) {
                    break;
                }
                catch (IOException lllllllllllllllIIlIIIIlIllllllIl) {
                    lllllllllllllllIIlIIIIlIllllllIl.printStackTrace();
                }
            }
            if (lllllllllllllllIIlIIIIllIIIIlIlI.size() > 0) {
                final CustomSkyLayer[] lllllllllllllllIIlIIIIlIllllllII = lllllllllllllllIIlIIIIllIIIIlIlI.toArray(new CustomSkyLayer[lllllllllllllllIIlIIIIllIIIIlIlI.size()]);
                lllllllllllllllIIlIIIIllIIIlIlII[lllllllllllllllIIlIIIIllIIIIlllI] = lllllllllllllllIIlIIIIlIllllllII;
                lllllllllllllllIIlIIIIllIIIlIIII = lllllllllllllllIIlIIIIllIIIIlllI;
            }
        }
        if (lllllllllllllllIIlIIIIllIIIlIIII < 0) {
            return null;
        }
        int lllllllllllllllIIlIIIIllIIIIlllI = lllllllllllllllIIlIIIIllIIIlIIII + 1;
        final CustomSkyLayer[][] lllllllllllllllIIlIIIIlIlllllIll = new CustomSkyLayer[lllllllllllllllIIlIIIIllIIIIlllI][0];
        for (int lllllllllllllllIIlIIIIlIlllllIlI = 0; lllllllllllllllIIlIIIIlIlllllIlI < lllllllllllllllIIlIIIIlIlllllIll.length; ++lllllllllllllllIIlIIIIlIlllllIlI) {
            lllllllllllllllIIlIIIIlIlllllIll[lllllllllllllllIIlIIIIlIlllllIlI] = lllllllllllllllIIlIIIIllIIIlIlII[lllllllllllllllIIlIIIIlIlllllIlI];
        }
        return lllllllllllllllIIlIIIIlIlllllIll;
    }
    
    static {
        CustomSky.worldSkyLayers = null;
    }
    
    public static void reset() {
        CustomSky.worldSkyLayers = null;
    }
}
