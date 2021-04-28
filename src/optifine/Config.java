package optifine;

import net.minecraft.client.resources.model.*;
import net.minecraft.client.settings.*;
import java.nio.*;
import javax.imageio.*;
import java.awt.image.*;
import net.minecraft.util.*;
import org.lwjgl.util.glu.*;
import net.minecraft.client.resources.*;
import shadersmod.client.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.server.integrated.*;
import net.minecraft.world.*;
import java.util.regex.*;
import net.minecraft.client.renderer.texture.*;
import java.awt.*;
import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.apache.commons.io.*;
import java.util.*;
import java.lang.reflect.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import java.io.*;

public class Config
{
    private static /* synthetic */ String newRelease;
    private static /* synthetic */ DefaultResourcePack defaultResourcePack;
    public static /* synthetic */ boolean zoomMode;
    private static /* synthetic */ ModelManager modelManager;
    private static /* synthetic */ boolean fullscreenModeChecked;
    public static /* synthetic */ boolean waterOpacityChanged;
    public static /* synthetic */ String openGlVendor;
    private static /* synthetic */ PrintStream systemOut;
    private static /* synthetic */ Thread minecraftThread;
    private static /* synthetic */ GameSettings gameSettings;
    private static /* synthetic */ boolean initialized;
    public static /* synthetic */ String openGlRenderer;
    private static /* synthetic */ boolean desktopModeChecked;
    private static /* synthetic */ int texturePackClouds;
    public static /* synthetic */ boolean occlusionAvailable;
    public static /* synthetic */ String openGlVersion;
    public static /* synthetic */ boolean fancyFogAvailable;
    private static /* synthetic */ boolean notify64BitJava;
    private static /* synthetic */ Minecraft minecraft;
    private static /* synthetic */ int availableProcessors;
    public static final /* synthetic */ Float DEF_ALPHA_FUNC_LEVEL;
    private static /* synthetic */ int antialiasingLevel;
    private static /* synthetic */ DisplayMode desktopDisplayMode;
    
    private static ByteBuffer readIconImage(final InputStream llllllllllllllIlIIIlllllIllllllI) throws IOException {
        final BufferedImage llllllllllllllIlIIIllllllIIIlIIl = ImageIO.read(llllllllllllllIlIIIlllllIllllllI);
        final int[] llllllllllllllIlIIIllllllIIIIlll = llllllllllllllIlIIIllllllIIIlIIl.getRGB(0, 0, llllllllllllllIlIIIllllllIIIlIIl.getWidth(), llllllllllllllIlIIIllllllIIIlIIl.getHeight(), null, 0, llllllllllllllIlIIIllllllIIIlIIl.getWidth());
        final ByteBuffer llllllllllllllIlIIIllllllIIIIlIl = ByteBuffer.allocate(4 * llllllllllllllIlIIIllllllIIIIlll.length);
        final int[] llllllllllllllIlIIIllllllIIIIIll = llllllllllllllIlIIIllllllIIIIlll;
        for (int llllllllllllllIlIIIllllllIIIIIIl = llllllllllllllIlIIIllllllIIIIlll.length, llllllllllllllIlIIIllllllIIIIIII = 0; llllllllllllllIlIIIllllllIIIIIII < llllllllllllllIlIIIllllllIIIIIIl; ++llllllllllllllIlIIIllllllIIIIIII) {
            final int llllllllllllllIlIIIlllllIlllllll = llllllllllllllIlIIIllllllIIIIIll[llllllllllllllIlIIIllllllIIIIIII];
            llllllllllllllIlIIIllllllIIIIlIl.putInt(llllllllllllllIlIIIlllllIlllllll << 8 | (llllllllllllllIlIIIlllllIlllllll >> 24 & 0xFF));
        }
        llllllllllllllIlIIIllllllIIIIlIl.flip();
        return llllllllllllllIlIIIllllllIIIIlIl;
    }
    
    public static int getBitsOs() {
        final String llllllllllllllIlIIIllllIlIlIllII = System.getenv("ProgramFiles(X86)");
        return (llllllllllllllIlIIIllllIlIlIllII != null) ? 64 : 32;
    }
    
    public static float getFogStart() {
        return Config.gameSettings.ofFogStart;
    }
    
    public static String readInputStream(final InputStream llllllllllllllIlIIlIIIIIIIlIIlll) throws IOException {
        return readInputStream(llllllllllllllIlIIlIIIIIIIlIIlll, "ASCII");
    }
    
    public static boolean isFogFancy() {
        return isFancyFogAvailable() && Config.gameSettings.ofFogType == 2;
    }
    
    public static void updateTexturePackClouds() {
        Config.texturePackClouds = 0;
        final IResourceManager llllllllllllllIlIIlIIIIlIllIIllI = getResourceManager();
        if (llllllllllllllIlIIlIIIIlIllIIllI != null) {
            try {
                final InputStream llllllllllllllIlIIlIIIIlIllIIlIl = llllllllllllllIlIIlIIIIlIllIIllI.getResource(new ResourceLocation("mcpatcher/color.properties")).getInputStream();
                if (llllllllllllllIlIIlIIIIlIllIIlIl == null) {
                    return;
                }
                final Properties llllllllllllllIlIIlIIIIlIllIIlII = new Properties();
                llllllllllllllIlIIlIIIIlIllIIlII.load(llllllllllllllIlIIlIIIIlIllIIlIl);
                llllllllllllllIlIIlIIIIlIllIIlIl.close();
                String llllllllllllllIlIIlIIIIlIllIIIll = llllllllllllllIlIIlIIIIlIllIIlII.getProperty("clouds");
                if (llllllllllllllIlIIlIIIIlIllIIIll == null) {
                    return;
                }
                dbg(String.valueOf(new StringBuilder("Texture pack clouds: ").append(llllllllllllllIlIIlIIIIlIllIIIll)));
                llllllllllllllIlIIlIIIIlIllIIIll = llllllllllllllIlIIlIIIIlIllIIIll.toLowerCase();
                if (llllllllllllllIlIIlIIIIlIllIIIll.equals("fast")) {
                    Config.texturePackClouds = 1;
                }
                if (llllllllllllllIlIIlIIIIlIllIIIll.equals("fancy")) {
                    Config.texturePackClouds = 2;
                }
                if (llllllllllllllIlIIlIIIIlIllIIIll.equals("off")) {
                    Config.texturePackClouds = 3;
                }
            }
            catch (Exception ex) {}
        }
    }
    
    public static String getResourcePackNames() {
        if (Config.minecraft == null) {
            return "";
        }
        if (Config.minecraft.getResourcePackRepository() == null) {
            return "";
        }
        final IResourcePack[] llllllllllllllIlIIlIIIIIlllIIIII = getResourcePacks();
        if (llllllllllllllIlIIlIIIIIlllIIIII.length <= 0) {
            return getDefaultResourcePack().getPackName();
        }
        final String[] llllllllllllllIlIIlIIIIIllIlllll = new String[llllllllllllllIlIIlIIIIIlllIIIII.length];
        for (int llllllllllllllIlIIlIIIIIllIllllI = 0; llllllllllllllIlIIlIIIIIllIllllI < llllllllllllllIlIIlIIIIIlllIIIII.length; ++llllllllllllllIlIIlIIIIIllIllllI) {
            llllllllllllllIlIIlIIIIIllIlllll[llllllllllllllIlIIlIIIIIllIllllI] = llllllllllllllIlIIlIIIIIlllIIIII[llllllllllllllIlIIlIIIIIllIllllI].getPackName();
        }
        final String llllllllllllllIlIIlIIIIIllIlllIl = arrayToString(llllllllllllllIlIIlIIIIIllIlllll);
        return llllllllllllllIlIIlIIIIIllIlllIl;
    }
    
    public static boolean isSingleProcessor() {
        return getAvailableProcessors() <= 1;
    }
    
    public static boolean isTreesSmart() {
        return Config.gameSettings.ofTrees == 4;
    }
    
    public static String fillLeft(String llllllllllllllIlIIIllllIlIIlIIll, final int llllllllllllllIlIIIllllIlIIlIIlI, final char llllllllllllllIlIIIllllIlIIlIlIl) {
        if (llllllllllllllIlIIIllllIlIIlIIll == null) {
            llllllllllllllIlIIIllllIlIIlIIll = "";
        }
        if (((String)llllllllllllllIlIIIllllIlIIlIIll).length() >= llllllllllllllIlIIIllllIlIIlIIlI) {
            return (String)llllllllllllllIlIIIllllIlIIlIIll;
        }
        final StringBuffer llllllllllllllIlIIIllllIlIIlIlII = new StringBuffer((String)llllllllllllllIlIIIllllIlIIlIIll);
        while (llllllllllllllIlIIIllllIlIIlIlII.length() < llllllllllllllIlIIIllllIlIIlIIlI - ((String)llllllllllllllIlIIIllllIlIIlIIll).length()) {
            llllllllllllllIlIIIllllIlIIlIlII.append(llllllllllllllIlIIIllllIlIIlIlIl);
        }
        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIIllllIlIIlIlII.toString())).append((String)llllllllllllllIlIIIllllIlIIlIIll));
    }
    
    public static boolean isOcclusionAvailable() {
        return Config.occlusionAvailable;
    }
    
    public static int[] addIntToArray(final int[] llllllllllllllIlIIIllllIIlllIllI, final int llllllllllllllIlIIIllllIIlllIlll) {
        return addIntsToArray(llllllllllllllIlIIIllllIIlllIllI, new int[] { llllllllllllllIlIIIllllIIlllIlll });
    }
    
    public static int getRandom(final BlockPos llllllllllllllIlIIIlllllllIIlIII, final int llllllllllllllIlIIIlllllllIIIlll) {
        int llllllllllllllIlIIIlllllllIIlIIl = intHash(llllllllllllllIlIIIlllllllIIIlll + 37);
        llllllllllllllIlIIIlllllllIIlIIl = intHash(llllllllllllllIlIIIlllllllIIlIIl + llllllllllllllIlIIIlllllllIIlIII.getX());
        llllllllllllllIlIIIlllllllIIlIIl = intHash(llllllllllllllIlIIIlllllllIIlIIl + llllllllllllllIlIIIlllllllIIlIII.getZ());
        llllllllllllllIlIIIlllllllIIlIIl = intHash(llllllllllllllIlIIIlllllllIIlIIl + llllllllllllllIlIIIlllllllIIlIII.getY());
        return llllllllllllllIlIIIlllllllIIlIIl;
    }
    
    private static void checkOpenGlCaps() {
        log("");
        log(getVersion());
        log(String.valueOf(new StringBuilder("Build: ").append(getBuild())));
        log(String.valueOf(new StringBuilder("OS: ").append(System.getProperty("os.name")).append(" (").append(System.getProperty("os.arch")).append(") version ").append(System.getProperty("os.version"))));
        log(String.valueOf(new StringBuilder("Java: ").append(System.getProperty("java.version")).append(", ").append(System.getProperty("java.vendor"))));
        log(String.valueOf(new StringBuilder("VM: ").append(System.getProperty("java.vm.name")).append(" (").append(System.getProperty("java.vm.info")).append("), ").append(System.getProperty("java.vm.vendor"))));
        log(String.valueOf(new StringBuilder("LWJGL: ").append(Sys.getVersion())));
        Config.openGlVersion = GL11.glGetString(7938);
        Config.openGlRenderer = GL11.glGetString(7937);
        Config.openGlVendor = GL11.glGetString(7936);
        log(String.valueOf(new StringBuilder("OpenGL: ").append(Config.openGlRenderer).append(", version ").append(Config.openGlVersion).append(", ").append(Config.openGlVendor)));
        log(String.valueOf(new StringBuilder("OpenGL Version: ").append(getOpenGlVersionString())));
        if (!GLContext.getCapabilities().OpenGL12) {
            log("OpenGL Mipmap levels: Not available (GL12.GL_TEXTURE_MAX_LEVEL)");
        }
        if (!(Config.fancyFogAvailable = GLContext.getCapabilities().GL_NV_fog_distance)) {
            log("OpenGL Fancy fog: Not available (GL_NV_fog_distance)");
        }
        if (!(Config.occlusionAvailable = GLContext.getCapabilities().GL_ARB_occlusion_query)) {
            log("OpenGL Occlussion culling: Not available (GL_ARB_occlusion_query)");
        }
        final int llllllllllllllIlIIlIIIIllIlIIlII = Minecraft.getGLMaximumTextureSize();
        dbg(String.valueOf(new StringBuilder("Maximum texture size: ").append(llllllllllllllIlIIlIIIIllIlIIlII).append("x").append(llllllllllllllIlIIlIIIIllIlIIlII)));
    }
    
    public static boolean isSkyEnabled() {
        return Config.gameSettings.ofSky;
    }
    
    public static boolean isDynamicLights() {
        return Config.gameSettings.ofDynamicLights != 3;
    }
    
    public static void checkGlError(final String llllllllllllllIlIIlIIIIIIlIIlIIl) {
        final int llllllllllllllIlIIlIIIIIIlIIlIll = GL11.glGetError();
        if (llllllllllllllIlIIlIIIIIIlIIlIll != 0) {
            final String llllllllllllllIlIIlIIIIIIlIIlIlI = GLU.gluErrorString(llllllllllllllIlIIlIIIIIIlIIlIll);
            error(String.valueOf(new StringBuilder("OpenGlError: ").append(llllllllllllllIlIIlIIIIIIlIIlIll).append(" (").append(llllllllllllllIlIIlIIIIIIlIIlIlI).append("), at: ").append(llllllllllllllIlIIlIIIIIIlIIlIIl)));
        }
    }
    
    public static boolean isFogFast() {
        return Config.gameSettings.ofFogType == 1;
    }
    
    public static boolean isDrippingWaterLava() {
        return Config.gameSettings.ofDrippingWaterLava;
    }
    
    private static String getBuild() {
        try {
            final InputStream llllllllllllllIlIIlIIIIllIlIIIII = Config.class.getResourceAsStream("/buildof.txt");
            if (llllllllllllllIlIIlIIIIllIlIIIII == null) {
                return null;
            }
            final String llllllllllllllIlIIlIIIIllIIlllll = readLines(llllllllllllllIlIIlIIIIllIlIIIII)[0];
            return llllllllllllllIlIIlIIIIllIIlllll;
        }
        catch (Exception llllllllllllllIlIIlIIIIllIIllllI) {
            warn(String.valueOf(new StringBuilder().append(llllllllllllllIlIIlIIIIllIIllllI.getClass().getName()).append(": ").append(llllllllllllllIlIIlIIIIllIIllllI.getMessage())));
            return null;
        }
    }
    
    public static TextureMap getTextureMap() {
        return getMinecraft().getTextureMapBlocks();
    }
    
    public static Object[] addObjectToArray(final Object[] llllllllllllllIlIIIlllllIIlIllII, final Object llllllllllllllIlIIIlllllIIlIIIlI) {
        if (llllllllllllllIlIIIlllllIIlIllII == null) {
            throw new NullPointerException("The given array is NULL");
        }
        final int llllllllllllllIlIIIlllllIIlIlIII = llllllllllllllIlIIIlllllIIlIllII.length;
        final int llllllllllllllIlIIIlllllIIlIIlll = llllllllllllllIlIIIlllllIIlIlIII + 1;
        final Object[] llllllllllllllIlIIIlllllIIlIIllI = (Object[])Array.newInstance(llllllllllllllIlIIIlllllIIlIllII.getClass().getComponentType(), llllllllllllllIlIIIlllllIIlIIlll);
        System.arraycopy(llllllllllllllIlIIIlllllIIlIllII, 0, llllllllllllllIlIIIlllllIIlIIllI, 0, llllllllllllllIlIIIlllllIIlIlIII);
        llllllllllllllIlIIIlllllIIlIIllI[llllllllllllllIlIIIlllllIIlIlIII] = llllllllllllllIlIIIlllllIIlIIIlI;
        return llllllllllllllIlIIIlllllIIlIIllI;
    }
    
    public static InputStream getResourceStream(final IResourceManager llllllllllllllIlIIlIIIIlIIIIllIl, final ResourceLocation llllllllllllllIlIIlIIIIlIIIIlIIl) throws IOException {
        final IResource llllllllllllllIlIIlIIIIlIIIIlIll = llllllllllllllIlIIlIIIIlIIIIllIl.getResource(llllllllllllllIlIIlIIIIlIIIIlIIl);
        return (llllllllllllllIlIIlIIIIlIIIIlIll == null) ? null : llllllllllllllIlIIlIIIIlIIIIlIll.getInputStream();
    }
    
    public static boolean isVoidParticles() {
        return Config.gameSettings.ofVoidParticles;
    }
    
    public static String normalize(final String llllllllllllllIlIIIllllllIlIlIll) {
        return (llllllllllllllIlIIIllllllIlIlIll == null) ? "" : llllllllllllllIlIIIllllllIlIlIll;
    }
    
    public static boolean isGeneratedWater() {
        return Config.gameSettings.ofAnimatedWater == 1;
    }
    
    public static float limit(final float llllllllllllllIlIIlIIIIlIlIIllII, final float llllllllllllllIlIIlIIIIlIlIIlIll, final float llllllllllllllIlIIlIIIIlIlIIllIl) {
        return (llllllllllllllIlIIlIIIIlIlIIllII < llllllllllllllIlIIlIIIIlIlIIlIll) ? llllllllllllllIlIIlIIIIlIlIIlIll : ((llllllllllllllIlIIlIIIIlIlIIllII > llllllllllllllIlIIlIIIIlIlIIllIl) ? llllllllllllllIlIIlIIIIlIlIIllIl : llllllllllllllIlIIlIIIIlIlIIllII);
    }
    
    public static Minecraft getMinecraft() {
        return Config.minecraft;
    }
    
    public static float getAmbientOcclusionLevel() {
        return Config.gameSettings.ofAoLevel;
    }
    
    public static boolean isTimeDayOnly() {
        return Config.gameSettings.ofTime == 1;
    }
    
    public static DefaultResourcePack getDefaultResourcePack() {
        if (Config.defaultResourcePack == null) {
            final Minecraft llllllllllllllIlIIlIIIIIllIlIlIl = Minecraft.getMinecraft();
            try {
                final Field[] llllllllllllllIlIIlIIIIIllIlIlII = llllllllllllllIlIIlIIIIIllIlIlIl.getClass().getDeclaredFields();
                for (int llllllllllllllIlIIlIIIIIllIlIIll = 0; llllllllllllllIlIIlIIIIIllIlIIll < llllllllllllllIlIIlIIIIIllIlIlII.length; ++llllllllllllllIlIIlIIIIIllIlIIll) {
                    final Field llllllllllllllIlIIlIIIIIllIlIIlI = llllllllllllllIlIIlIIIIIllIlIlII[llllllllllllllIlIIlIIIIIllIlIIll];
                    if (llllllllllllllIlIIlIIIIIllIlIIlI.getType() == DefaultResourcePack.class) {
                        llllllllllllllIlIIlIIIIIllIlIIlI.setAccessible(true);
                        Config.defaultResourcePack = (DefaultResourcePack)llllllllllllllIlIIlIIIIIllIlIIlI.get(llllllllllllllIlIIlIIIIIllIlIlIl);
                        break;
                    }
                }
            }
            catch (Exception llllllllllllllIlIIlIIIIIllIlIIIl) {
                warn(String.valueOf(new StringBuilder("Error getting default resource pack: ").append(llllllllllllllIlIIlIIIIIllIlIIIl.getClass().getName()).append(": ").append(llllllllllllllIlIIlIIIIIllIlIIIl.getMessage())));
            }
            if (Config.defaultResourcePack == null) {
                final ResourcePackRepository llllllllllllllIlIIlIIIIIllIlIIII = llllllllllllllIlIIlIIIIIllIlIlIl.getResourcePackRepository();
                if (llllllllllllllIlIIlIIIIIllIlIIII != null) {
                    Config.defaultResourcePack = (DefaultResourcePack)llllllllllllllIlIIlIIIIIllIlIIII.rprDefaultResourcePack;
                }
            }
        }
        return Config.defaultResourcePack;
    }
    
    public static boolean isPotionParticles() {
        return Config.gameSettings.ofPotionParticles;
    }
    
    public static boolean equals(final Object llllllllllllllIlIIIllllllIlIlllI, final Object llllllllllllllIlIIIllllllIlIllll) {
        return llllllllllllllIlIIIllllllIlIlllI == llllllllllllllIlIIIllllllIlIllll || (llllllllllllllIlIIIllllllIlIlllI != null && llllllllllllllIlIIIllllllIlIlllI.equals(llllllllllllllIlIIIllllllIlIllll));
    }
    
    public static boolean isConnectedModels() {
        return false;
    }
    
    public static IResource getResource(final ResourceLocation llllllllllllllIlIIlIIIIlIIIIIlIl) throws IOException {
        return Config.minecraft.getResourceManager().getResource(llllllllllllllIlIIlIIIIlIIIIIlIl);
    }
    
    public static boolean isCustomFonts() {
        return Config.gameSettings.ofCustomFonts;
    }
    
    public static float parseFloat(String llllllllllllllIlIIlIIIIIlIIllIII, final float llllllllllllllIlIIlIIIIIlIIlIlII) {
        try {
            if (llllllllllllllIlIIlIIIIIlIIllIII == null) {
                return llllllllllllllIlIIlIIIIIlIIlIlII;
            }
            llllllllllllllIlIIlIIIIIlIIllIII = llllllllllllllIlIIlIIIIIlIIllIII.trim();
            return Float.parseFloat(llllllllllllllIlIIlIIIIIlIIllIII);
        }
        catch (NumberFormatException llllllllllllllIlIIlIIIIIlIIlIllI) {
            return llllllllllllllIlIIlIIIIIlIIlIlII;
        }
    }
    
    public static boolean isBetterGrass() {
        return Config.gameSettings.ofBetterGrass != 3;
    }
    
    public static boolean isConnectedTexturesFancy() {
        return Config.gameSettings.ofConnectedTextures == 2;
    }
    
    public static boolean isRainFancy() {
        return (Config.gameSettings.ofRain == 0) ? Config.gameSettings.fancyGraphics : (Config.gameSettings.ofRain == 2);
    }
    
    public static int getBitsJre() {
        final String[] llllllllllllllIlIIIllllIlIlIIllI = { "sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch" };
        for (int llllllllllllllIlIIIllllIlIlIIlIl = 0; llllllllllllllIlIIIllllIlIlIIlIl < llllllllllllllIlIIIllllIlIlIIllI.length; ++llllllllllllllIlIIIllllIlIlIIlIl) {
            final String llllllllllllllIlIIIllllIlIlIIlII = llllllllllllllIlIIIllllIlIlIIllI[llllllllllllllIlIIIllllIlIlIIlIl];
            final String llllllllllllllIlIIIllllIlIlIIIll = System.getProperty(llllllllllllllIlIIIllllIlIlIIlII);
            if (llllllllllllllIlIIIllllIlIlIIIll != null && llllllllllllllIlIIIllllIlIlIIIll.contains("64")) {
                return 64;
            }
        }
        return 32;
    }
    
    public static float limitTo1(final float llllllllllllllIlIIlIIIIlIIllllll) {
        return (llllllllllllllIlIIlIIIIlIIllllll < 0.0f) ? 0.0f : ((llllllllllllllIlIIlIIIIlIIllllll > 1.0f) ? 1.0f : llllllllllllllIlIIlIIIIlIIllllll);
    }
    
    private static void startVersionCheckThread() {
        final VersionCheckThread llllllllllllllIlIIlIIIIlIllllIll = new VersionCheckThread();
        llllllllllllllIlIIlIIIIlIllllIll.start();
    }
    
    public static int limit(final int llllllllllllllIlIIlIIIIlIlIlIlIl, final int llllllllllllllIlIIlIIIIlIlIlIlll, final int llllllllllllllIlIIlIIIIlIlIlIIll) {
        return (llllllllllllllIlIIlIIIIlIlIlIlIl < llllllllllllllIlIIlIIIIlIlIlIlll) ? llllllllllllllIlIIlIIIIlIlIlIlll : ((llllllllllllllIlIIlIIIIlIlIlIlIl > llllllllllllllIlIIlIIIIlIlIlIIll) ? llllllllllllllIlIIlIIIIlIlIlIIll : llllllllllllllIlIIlIIIIlIlIlIlIl);
    }
    
    public static DisplayMode getDesktopDisplayMode() {
        return Config.desktopDisplayMode;
    }
    
    public static boolean isMultiTexture() {
        return getAnisotropicFilterLevel() > 1 || getAntialiasingLevel() > 0;
    }
    
    private static void setThreadPriority(final String llllllllllllllIlIIlIIIIllIIIlIll, final int llllllllllllllIlIIlIIIIllIIIIIlI) {
        try {
            final ThreadGroup llllllllllllllIlIIlIIIIllIIIlIIl = Thread.currentThread().getThreadGroup();
            if (llllllllllllllIlIIlIIIIllIIIlIIl == null) {
                return;
            }
            final int llllllllllllllIlIIlIIIIllIIIlIII = (llllllllllllllIlIIlIIIIllIIIlIIl.activeCount() + 10) * 2;
            final Thread[] llllllllllllllIlIIlIIIIllIIIIlll = new Thread[llllllllllllllIlIIlIIIIllIIIlIII];
            llllllllllllllIlIIlIIIIllIIIlIIl.enumerate(llllllllllllllIlIIlIIIIllIIIIlll, false);
            for (int llllllllllllllIlIIlIIIIllIIIIllI = 0; llllllllllllllIlIIlIIIIllIIIIllI < llllllllllllllIlIIlIIIIllIIIIlll.length; ++llllllllllllllIlIIlIIIIllIIIIllI) {
                final Thread llllllllllllllIlIIlIIIIllIIIIlIl = llllllllllllllIlIIlIIIIllIIIIlll[llllllllllllllIlIIlIIIIllIIIIllI];
                if (llllllllllllllIlIIlIIIIllIIIIlIl != null && llllllllllllllIlIIlIIIIllIIIIlIl.getName().startsWith(llllllllllllllIlIIlIIIIllIIIlIll)) {
                    llllllllllllllIlIIlIIIIllIIIIlIl.setPriority(llllllllllllllIlIIlIIIIllIIIIIlI);
                }
            }
        }
        catch (Throwable llllllllllllllIlIIlIIIIllIIIIlII) {
            warn(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIlIIIIllIIIIlII.getClass().getName())).append(": ").append(llllllllllllllIlIIlIIIIllIIIIlII.getMessage())));
        }
    }
    
    public static IResourcePack getDefiningResourcePack(final ResourceLocation llllllllllllllIlIIlIIIIIlIllllIl) {
        final IResourcePack[] llllllllllllllIlIIlIIIIIllIIIIII = getResourcePacks();
        for (int llllllllllllllIlIIlIIIIIlIllllll = llllllllllllllIlIIlIIIIIllIIIIII.length - 1; llllllllllllllIlIIlIIIIIlIllllll >= 0; --llllllllllllllIlIIlIIIIIlIllllll) {
            final IResourcePack llllllllllllllIlIIlIIIIIlIlllllI = llllllllllllllIlIIlIIIIIllIIIIII[llllllllllllllIlIIlIIIIIlIllllll];
            if (llllllllllllllIlIIlIIIIIlIlllllI.resourceExists(llllllllllllllIlIIlIIIIIlIllllIl)) {
                return llllllllllllllIlIIlIIIIIlIlllllI;
            }
        }
        if (getDefaultResourcePack().resourceExists(llllllllllllllIlIIlIIIIIlIllllIl)) {
            return getDefaultResourcePack();
        }
        return null;
    }
    
    public static boolean isShowCapes() {
        return Config.gameSettings.ofShowCapes;
    }
    
    public static DisplayMode[] getFullscreenDisplayModes() {
        try {
            final DisplayMode[] llllllllllllllIlIIlIIIIIIlllIlIl = Display.getAvailableDisplayModes();
            final ArrayList llllllllllllllIlIIlIIIIIIlllIlII = new ArrayList();
            for (int llllllllllllllIlIIlIIIIIIlllIIll = 0; llllllllllllllIlIIlIIIIIIlllIIll < llllllllllllllIlIIlIIIIIIlllIlIl.length; ++llllllllllllllIlIIlIIIIIIlllIIll) {
                final DisplayMode llllllllllllllIlIIlIIIIIIlllIIlI = llllllllllllllIlIIlIIIIIIlllIlIl[llllllllllllllIlIIlIIIIIIlllIIll];
                if (Config.desktopDisplayMode == null || (llllllllllllllIlIIlIIIIIIlllIIlI.getBitsPerPixel() == Config.desktopDisplayMode.getBitsPerPixel() && llllllllllllllIlIIlIIIIIIlllIIlI.getFrequency() == Config.desktopDisplayMode.getFrequency())) {
                    llllllllllllllIlIIlIIIIIIlllIlII.add(llllllllllllllIlIIlIIIIIIlllIIlI);
                }
            }
            final DisplayMode[] llllllllllllllIlIIlIIIIIIlllIIIl = llllllllllllllIlIIlIIIIIIlllIlII.toArray(new DisplayMode[llllllllllllllIlIIlIIIIIIlllIlII.size()]);
            final Comparator llllllllllllllIlIIlIIIIIIlllIIII = new Comparator() {
                @Override
                public int compare(final Object lllllllllllllllIIlllIlIIllllIIll, final Object lllllllllllllllIIlllIlIIllllIIlI) {
                    final DisplayMode lllllllllllllllIIlllIlIIllllIIIl = (DisplayMode)lllllllllllllllIIlllIlIIllllIIll;
                    final DisplayMode lllllllllllllllIIlllIlIIllllIIII = (DisplayMode)lllllllllllllllIIlllIlIIllllIIlI;
                    return (lllllllllllllllIIlllIlIIllllIIIl.getWidth() != lllllllllllllllIIlllIlIIllllIIII.getWidth()) ? (lllllllllllllllIIlllIlIIllllIIII.getWidth() - lllllllllllllllIIlllIlIIllllIIIl.getWidth()) : ((lllllllllllllllIIlllIlIIllllIIIl.getHeight() != lllllllllllllllIIlllIlIIllllIIII.getHeight()) ? (lllllllllllllllIIlllIlIIllllIIII.getHeight() - lllllllllllllllIIlllIlIIllllIIIl.getHeight()) : 0);
                }
            };
            Arrays.sort(llllllllllllllIlIIlIIIIIIlllIIIl, llllllllllllllIlIIlIIIIIIlllIIII);
            return llllllllllllllIlIIlIIIIIIlllIIIl;
        }
        catch (Exception llllllllllllllIlIIlIIIIIIllIllll) {
            llllllllllllllIlIIlIIIIIIllIllll.printStackTrace();
            return new DisplayMode[] { Config.desktopDisplayMode };
        }
    }
    
    public static String fillRight(String llllllllllllllIlIIIllllIlIIIIlll, final int llllllllllllllIlIIIllllIlIIIlIlI, final char llllllllllllllIlIIIllllIlIIIIlIl) {
        if (llllllllllllllIlIIIllllIlIIIIlll == null) {
            llllllllllllllIlIIIllllIlIIIIlll = "";
        }
        if (((String)llllllllllllllIlIIIllllIlIIIIlll).length() >= llllllllllllllIlIIIllllIlIIIlIlI) {
            return (String)llllllllllllllIlIIIllllIlIIIIlll;
        }
        final StringBuffer llllllllllllllIlIIIllllIlIIIlIII = new StringBuffer((String)llllllllllllllIlIIIllllIlIIIIlll);
        while (llllllllllllllIlIIIllllIlIIIlIII.length() < llllllllllllllIlIIIllllIlIIIlIlI) {
            llllllllllllllIlIIIllllIlIIIlIII.append(llllllllllllllIlIIIllllIlIIIIlIl);
        }
        return llllllllllllllIlIIIllllIlIIIlIII.toString();
    }
    
    public static void writeFile(final File llllllllllllllIlIIIllllIIlIIlllI, final String llllllllllllllIlIIIllllIIlIIlIIl) throws IOException {
        final FileOutputStream llllllllllllllIlIIIllllIIlIIllII = new FileOutputStream(llllllllllllllIlIIIllllIIlIIlllI);
        final byte[] llllllllllllllIlIIIllllIIlIIlIll = llllllllllllllIlIIIllllIIlIIlIIl.getBytes("ASCII");
        llllllllllllllIlIIIllllIIlIIllII.write(llllllllllllllIlIIIllllIIlIIlIll);
        llllllllllllllIlIIIllllIIlIIllII.close();
    }
    
    public static boolean isConnectedTextures() {
        return Config.gameSettings.ofConnectedTextures != 3;
    }
    
    public static int getMipmapLevels() {
        return Config.gameSettings.mipmapLevels;
    }
    
    public static boolean isCustomSky() {
        return Config.gameSettings.ofCustomSky;
    }
    
    public static boolean isFromDefaultResourcePack(final ResourceLocation llllllllllllllIlIIlIIIIIllIIIlll) {
        final IResourcePack llllllllllllllIlIIlIIIIIllIIlIII = getDefiningResourcePack(llllllllllllllIlIIlIIIIIllIIIlll);
        return llllllllllllllIlIIlIIIIIllIIlIII == getDefaultResourcePack();
    }
    
    public static void updateThreadPriorities() {
        updateAvailableProcessors();
        final boolean llllllllllllllIlIIlIIIIllIIlIlII = true;
        if (isSingleProcessor()) {
            if (isSmoothWorld()) {
                Config.minecraftThread.setPriority(10);
                setThreadPriority("Server thread", 1);
            }
            else {
                Config.minecraftThread.setPriority(5);
                setThreadPriority("Server thread", 5);
            }
        }
        else {
            Config.minecraftThread.setPriority(10);
            setThreadPriority("Server thread", 5);
        }
    }
    
    private static int getOpenGlVersion() {
        return GLContext.getCapabilities().OpenGL11 ? (GLContext.getCapabilities().OpenGL12 ? (GLContext.getCapabilities().OpenGL13 ? (GLContext.getCapabilities().OpenGL14 ? (GLContext.getCapabilities().OpenGL15 ? (GLContext.getCapabilities().OpenGL20 ? (GLContext.getCapabilities().OpenGL21 ? (GLContext.getCapabilities().OpenGL30 ? (GLContext.getCapabilities().OpenGL31 ? (GLContext.getCapabilities().OpenGL32 ? (GLContext.getCapabilities().OpenGL33 ? (GLContext.getCapabilities().OpenGL40 ? 40 : 33) : 32) : 31) : 30) : 21) : 20) : 15) : 14) : 13) : 12) : 11) : 10;
    }
    
    public static int intHash(int llllllllllllllIlIIIlllllllIIllll) {
        llllllllllllllIlIIIlllllllIIllll = (llllllllllllllIlIIIlllllllIIllll ^ 0x3D ^ llllllllllllllIlIIIlllllllIIllll >> 16);
        llllllllllllllIlIIIlllllllIIllll += llllllllllllllIlIIIlllllllIIllll << 3;
        llllllllllllllIlIIIlllllllIIllll ^= llllllllllllllIlIIIlllllllIIllll >> 4;
        llllllllllllllIlIIIlllllllIIllll *= 668265261;
        llllllllllllllIlIIIlllllllIIllll ^= llllllllllllllIlIIIlllllllIIllll >> 15;
        return llllllllllllllIlIIIlllllllIIllll;
    }
    
    public static boolean isAntialiasing() {
        return getAntialiasingLevel() > 0;
    }
    
    public static String arrayToString(final Object[] llllllllllllllIlIIlIIIIlIIlIIIll) {
        if (llllllllllllllIlIIlIIIIlIIlIIIll == null) {
            return "";
        }
        final StringBuffer llllllllllllllIlIIlIIIIlIIlIIllI = new StringBuffer(llllllllllllllIlIIlIIIIlIIlIIIll.length * 5);
        for (int llllllllllllllIlIIlIIIIlIIlIIlIl = 0; llllllllllllllIlIIlIIIIlIIlIIlIl < llllllllllllllIlIIlIIIIlIIlIIIll.length; ++llllllllllllllIlIIlIIIIlIIlIIlIl) {
            final Object llllllllllllllIlIIlIIIIlIIlIIlII = llllllllllllllIlIIlIIIIlIIlIIIll[llllllllllllllIlIIlIIIIlIIlIIlIl];
            if (llllllllllllllIlIIlIIIIlIIlIIlIl > 0) {
                llllllllllllllIlIIlIIIIlIIlIIllI.append(", ");
            }
            llllllllllllllIlIIlIIIIlIIlIIllI.append(String.valueOf(llllllllllllllIlIIlIIIIlIIlIIlII));
        }
        return llllllllllllllIlIIlIIIIlIIlIIllI.toString();
    }
    
    public static boolean isAnimatedWater() {
        return Config.gameSettings.ofAnimatedWater != 2;
    }
    
    public static String arrayToString(final int[] llllllllllllllIlIIlIIIIlIIIllIll) {
        if (llllllllllllllIlIIlIIIIlIIIllIll == null) {
            return "";
        }
        final StringBuffer llllllllllllllIlIIlIIIIlIIIllIlI = new StringBuffer(llllllllllllllIlIIlIIIIlIIIllIll.length * 5);
        for (int llllllllllllllIlIIlIIIIlIIIllIIl = 0; llllllllllllllIlIIlIIIIlIIIllIIl < llllllllllllllIlIIlIIIIlIIIllIll.length; ++llllllllllllllIlIIlIIIIlIIIllIIl) {
            final int llllllllllllllIlIIlIIIIlIIIllIII = llllllllllllllIlIIlIIIIlIIIllIll[llllllllllllllIlIIlIIIIlIIIllIIl];
            if (llllllllllllllIlIIlIIIIlIIIllIIl > 0) {
                llllllllllllllIlIIlIIIIlIIIllIlI.append(", ");
            }
            llllllllllllllIlIIlIIIIlIIIllIlI.append(String.valueOf(llllllllllllllIlIIlIIIIlIIIllIII));
        }
        return llllllllllllllIlIIlIIIIlIIIllIlI.toString();
    }
    
    public static boolean isMinecraftThread() {
        return Thread.currentThread() == Config.minecraftThread;
    }
    
    public static boolean isFastRender() {
        return Config.gameSettings.ofFastRender;
    }
    
    public static int getAntialiasingLevel() {
        return Config.antialiasingLevel;
    }
    
    public static int getMipmapType() {
        switch (Config.gameSettings.ofMipmapType) {
            case 0: {
                return 9986;
            }
            case 1: {
                return 9986;
            }
            case 2: {
                if (isMultiTexture()) {
                    return 9985;
                }
                return 9986;
            }
            case 3: {
                if (isMultiTexture()) {
                    return 9987;
                }
                return 9986;
            }
            default: {
                return 9986;
            }
        }
    }
    
    public static boolean isFireworkParticles() {
        return Config.gameSettings.ofFireworkParticles;
    }
    
    public static String getOpenGlVersionString() {
        final int llllllllllllllIlIIlIIIIllIIllIIl = getOpenGlVersion();
        final String llllllllllllllIlIIlIIIIllIIllIII = String.valueOf(new StringBuilder().append(llllllllllllllIlIIlIIIIllIIllIIl / 10).append(".").append(llllllllllllllIlIIlIIIIllIIllIIl % 10));
        return llllllllllllllIlIIlIIIIllIIllIII;
    }
    
    public static String readFile(final File llllllllllllllIlIIlIIIIIIIlIllII) throws IOException {
        final FileInputStream llllllllllllllIlIIlIIIIIIIlIlIll = new FileInputStream(llllllllllllllIlIIlIIIIIIIlIllII);
        return readInputStream(llllllllllllllIlIIlIIIIIIIlIlIll, "ASCII");
    }
    
    public static boolean isCustomItems() {
        return Config.gameSettings.ofCustomItems;
    }
    
    public static boolean isWaterParticles() {
        return Config.gameSettings.ofWaterParticles;
    }
    
    public static String[] readLines(final InputStream llllllllllllllIlIIlIIIIIIIllIlII) throws IOException {
        final ArrayList llllllllllllllIlIIlIIIIIIIlllIIl = new ArrayList();
        final InputStreamReader llllllllllllllIlIIlIIIIIIIlllIII = new InputStreamReader(llllllllllllllIlIIlIIIIIIIllIlII, "ASCII");
        final BufferedReader llllllllllllllIlIIlIIIIIIIllIlll = new BufferedReader(llllllllllllllIlIIlIIIIIIIlllIII);
        while (true) {
            final String llllllllllllllIlIIlIIIIIIIllIllI = llllllllllllllIlIIlIIIIIIIllIlll.readLine();
            if (llllllllllllllIlIIlIIIIIIIllIllI == null) {
                break;
            }
            llllllllllllllIlIIlIIIIIIIlllIIl.add(llllllllllllllIlIIlIIIIIIIllIllI);
        }
        final String[] llllllllllllllIlIIlIIIIIIIllIlIl = llllllllllllllIlIIlIIIIIIIlllIIl.toArray(new String[llllllllllllllIlIIlIIIIIIIlllIIl.size()]);
        return llllllllllllllIlIIlIIIIIIIllIlIl;
    }
    
    public static boolean isTranslucentBlocksFancy() {
        return (Config.gameSettings.ofTranslucentBlocks == 0) ? Config.gameSettings.fancyGraphics : (Config.gameSettings.ofTranslucentBlocks == 2);
    }
    
    public static boolean isRainOff() {
        return Config.gameSettings.ofRain == 3;
    }
    
    public static boolean isDroppedItemsFancy() {
        return (Config.gameSettings.ofDroppedItems == 0) ? Config.gameSettings.fancyGraphics : (Config.gameSettings.ofDroppedItems == 2);
    }
    
    public static boolean isCloudsFancy() {
        return (Config.gameSettings.ofClouds != 0) ? (Config.gameSettings.ofClouds == 2) : ((isShaders() && !Shaders.shaderPackClouds.isDefault()) ? Shaders.shaderPackClouds.isFancy() : ((Config.texturePackClouds != 0) ? (Config.texturePackClouds == 2) : Config.gameSettings.fancyGraphics));
    }
    
    public static boolean isDynamicFov() {
        return Config.gameSettings.ofDynamicFov;
    }
    
    public static String[] getFullscreenModes() {
        final DisplayMode[] llllllllllllllIlIIlIIIIIIllIIlIl = getFullscreenDisplayModes();
        final String[] llllllllllllllIlIIlIIIIIIllIIlII = new String[llllllllllllllIlIIlIIIIIIllIIlIl.length];
        for (int llllllllllllllIlIIlIIIIIIllIIIll = 0; llllllllllllllIlIIlIIIIIIllIIIll < llllllllllllllIlIIlIIIIIIllIIlIl.length; ++llllllllllllllIlIIlIIIIIIllIIIll) {
            final DisplayMode llllllllllllllIlIIlIIIIIIllIIIlI = llllllllllllllIlIIlIIIIIIllIIlIl[llllllllllllllIlIIlIIIIIIllIIIll];
            final String llllllllllllllIlIIlIIIIIIllIIIIl = String.valueOf(new StringBuilder().append(llllllllllllllIlIIlIIIIIIllIIIlI.getWidth()).append("x").append(llllllllllllllIlIIlIIIIIIllIIIlI.getHeight()));
            llllllllllllllIlIIlIIIIIIllIIlII[llllllllllllllIlIIlIIIIIIllIIIll] = llllllllllllllIlIIlIIIIIIllIIIIl;
        }
        return llllllllllllllIlIIlIIIIIIllIIlII;
    }
    
    public static boolean isStarsEnabled() {
        return Config.gameSettings.ofStars;
    }
    
    public static boolean isClearWater() {
        return Config.gameSettings.ofClearWater;
    }
    
    public static Object[] addObjectsToArray(final Object[] llllllllllllllIlIIIllllIllllIIIl, final Object[] llllllllllllllIlIIIllllIllllIlIl) {
        if (llllllllllllllIlIIIllllIllllIIIl == null) {
            throw new NullPointerException("The given array is NULL");
        }
        if (llllllllllllllIlIIIllllIllllIlIl.length == 0) {
            return llllllllllllllIlIIIllllIllllIIIl;
        }
        final int llllllllllllllIlIIIllllIllllIlII = llllllllllllllIlIIIllllIllllIIIl.length;
        final int llllllllllllllIlIIIllllIllllIIll = llllllllllllllIlIIIllllIllllIlII + llllllllllllllIlIIIllllIllllIlIl.length;
        final Object[] llllllllllllllIlIIIllllIllllIIlI = (Object[])Array.newInstance(llllllllllllllIlIIIllllIllllIIIl.getClass().getComponentType(), llllllllllllllIlIIIllllIllllIIll);
        System.arraycopy(llllllllllllllIlIIIllllIllllIIIl, 0, llllllllllllllIlIIIllllIllllIIlI, 0, llllllllllllllIlIIIllllIllllIlII);
        System.arraycopy(llllllllllllllIlIIIllllIllllIlIl, 0, llllllllllllllIlIIIllllIllllIIlI, llllllllllllllIlIIIllllIllllIlII, llllllllllllllIlIIIllllIllllIlIl.length);
        return llllllllllllllIlIIIllllIllllIIlI;
    }
    
    public static int getAvailableProcessors() {
        return Config.availableProcessors;
    }
    
    public static boolean isCustomColors() {
        return Config.gameSettings.ofCustomColors;
    }
    
    public static int getChunkViewDistance() {
        if (Config.gameSettings == null) {
            return 10;
        }
        final int llllllllllllllIlIIIllllllIllIlII = Config.gameSettings.renderDistanceChunks;
        return llllllllllllllIlIIIllllllIllIlII;
    }
    
    public static DynamicTexture getMojangLogoTexture(final DynamicTexture llllllllllllllIlIIIllllIIlIlIlll) {
        try {
            final ResourceLocation llllllllllllllIlIIIllllIIlIlllII = new ResourceLocation("textures/gui/title/mojang.png");
            final InputStream llllllllllllllIlIIIllllIIlIllIll = getResourceStream(llllllllllllllIlIIIllllIIlIlllII);
            if (llllllllllllllIlIIIllllIIlIllIll == null) {
                return llllllllllllllIlIIIllllIIlIlIlll;
            }
            final BufferedImage llllllllllllllIlIIIllllIIlIllIlI = ImageIO.read(llllllllllllllIlIIIllllIIlIllIll);
            if (llllllllllllllIlIIIllllIIlIllIlI == null) {
                return llllllllllllllIlIIIllllIIlIlIlll;
            }
            final DynamicTexture llllllllllllllIlIIIllllIIlIllIIl = new DynamicTexture(llllllllllllllIlIIIllllIIlIllIlI);
            return llllllllllllllIlIIIllllIIlIllIIl;
        }
        catch (Exception llllllllllllllIlIIIllllIIlIllIII) {
            warn(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIIllllIIlIllIII.getClass().getName())).append(": ").append(llllllllllllllIlIIIllllIIlIllIII.getMessage())));
            return llllllllllllllIlIIIllllIIlIlIlll;
        }
    }
    
    public static boolean isFogOff() {
        return Config.gameSettings.ofFogType == 3;
    }
    
    public static int compareRelease(final String llllllllllllllIlIIIlllllllllIlll, final String llllllllllllllIlIIIllllllllIllII) {
        final String[] llllllllllllllIlIIIlllllllllIlIl = splitRelease(llllllllllllllIlIIIlllllllllIlll);
        final String[] llllllllllllllIlIIIlllllllllIlII = splitRelease(llllllllllllllIlIIIllllllllIllII);
        final String llllllllllllllIlIIIlllllllllIIll = llllllllllllllIlIIIlllllllllIlIl[0];
        final String llllllllllllllIlIIIlllllllllIIlI = llllllllllllllIlIIIlllllllllIlII[0];
        if (!llllllllllllllIlIIIlllllllllIIll.equals(llllllllllllllIlIIIlllllllllIIlI)) {
            return llllllllllllllIlIIIlllllllllIIll.compareTo(llllllllllllllIlIIIlllllllllIIlI);
        }
        final int llllllllllllllIlIIIlllllllllIIIl = parseInt(llllllllllllllIlIIIlllllllllIlIl[1], -1);
        final int llllllllllllllIlIIIlllllllllIIII = parseInt(llllllllllllllIlIIIlllllllllIlII[1], -1);
        if (llllllllllllllIlIIIlllllllllIIIl != llllllllllllllIlIIIlllllllllIIII) {
            return llllllllllllllIlIIIlllllllllIIIl - llllllllllllllIlIIIlllllllllIIII;
        }
        final String llllllllllllllIlIIIllllllllIllll = llllllllllllllIlIIIlllllllllIlIl[2];
        final String llllllllllllllIlIIIllllllllIlllI = llllllllllllllIlIIIlllllllllIlII[2];
        if (!llllllllllllllIlIIIllllllllIllll.equals(llllllllllllllIlIIIllllllllIlllI)) {
            if (llllllllllllllIlIIIllllllllIllll.isEmpty()) {
                return 1;
            }
            if (llllllllllllllIlIIIllllllllIlllI.isEmpty()) {
                return -1;
            }
        }
        return llllllllllllllIlIIIllllllllIllll.compareTo(llllllllllllllIlIIIllllllllIlllI);
    }
    
    public static IResourcePack[] getResourcePacks() {
        final ResourcePackRepository llllllllllllllIlIIlIIIIIlllIlllI = Config.minecraft.getResourcePackRepository();
        final List llllllllllllllIlIIlIIIIIlllIllIl = llllllllllllllIlIIlIIIIIlllIlllI.getRepositoryEntries();
        final ArrayList llllllllllllllIlIIlIIIIIlllIllII = new ArrayList();
        for (final ResourcePackRepository.Entry llllllllllllllIlIIlIIIIIlllIlIlI : llllllllllllllIlIIlIIIIIlllIllIl) {
            llllllllllllllIlIIlIIIIIlllIllII.add(llllllllllllllIlIIlIIIIIlllIlIlI.getResourcePack());
        }
        if (llllllllllllllIlIIlIIIIIlllIlllI.getResourcePackInstance() != null) {
            llllllllllllllIlIIlIIIIIlllIllII.add(llllllllllllllIlIIlIIIIIlllIlllI.getResourcePackInstance());
        }
        final IResourcePack[] llllllllllllllIlIIlIIIIIlllIlIIl = llllllllllllllIlIIlIIIIIlllIllII.toArray(new IResourcePack[llllllllllllllIlIIlIIIIIlllIllII.size()]);
        return llllllllllllllIlIIlIIIIIlllIlIIl;
    }
    
    public static boolean between(final int llllllllllllllIlIIlIIIIIlIllIIII, final int llllllllllllllIlIIlIIIIIlIlIllII, final int llllllllllllllIlIIlIIIIIlIlIlIll) {
        return llllllllllllllIlIIlIIIIIlIllIIII >= llllllllllllllIlIIlIIIIIlIlIllII && llllllllllllllIlIIlIIIIIlIllIIII <= llllllllllllllIlIIlIIIIIlIlIlIll;
    }
    
    public static ModelManager getModelManager() {
        return Config.modelManager;
    }
    
    public static WorldServer getWorldServer() {
        if (Config.minecraft == null) {
            return null;
        }
        final WorldClient llllllllllllllIlIIIlllllllIIIIII = Config.minecraft.theWorld;
        if (llllllllllllllIlIIIlllllllIIIIII == null) {
            return null;
        }
        if (!Config.minecraft.isIntegratedServerRunning()) {
            return null;
        }
        final IntegratedServer llllllllllllllIlIIIllllllIllllll = Config.minecraft.getIntegratedServer();
        if (llllllllllllllIlIIIllllllIllllll == null) {
            return null;
        }
        final WorldProvider llllllllllllllIlIIIllllllIlllllI = llllllllllllllIlIIIlllllllIIIIII.provider;
        if (llllllllllllllIlIIIllllllIlllllI == null) {
            return null;
        }
        final int llllllllllllllIlIIIllllllIllllIl = llllllllllllllIlIIIllllllIlllllI.getDimensionId();
        try {
            final WorldServer llllllllllllllIlIIIllllllIllllII = llllllllllllllIlIIIllllllIllllll.worldServerForDimension(llllllllllllllIlIIIllllllIllllIl);
            return llllllllllllllIlIIIllllllIllllII;
        }
        catch (NullPointerException llllllllllllllIlIIIllllllIlllIll) {
            return null;
        }
    }
    
    public static int getUpdatesPerFrame() {
        return Config.gameSettings.ofChunkUpdates;
    }
    
    public static boolean isDynamicUpdates() {
        return Config.gameSettings.ofChunkUpdatesDynamic;
    }
    
    public static RenderGlobal getRenderGlobal() {
        return (Config.minecraft == null) ? null : Config.minecraft.renderGlobal;
    }
    
    private static String getUpdates(final String llllllllllllllIlIIIllllIlIllIllI) {
        final int llllllllllllllIlIIIllllIlIllIlII = llllllllllllllIlIIIllllIlIllIllI.indexOf(40);
        if (llllllllllllllIlIIIllllIlIllIlII < 0) {
            return "";
        }
        final int llllllllllllllIlIIIllllIlIllIIll = llllllllllllllIlIIIllllIlIllIllI.indexOf(32, llllllllllllllIlIIIllllIlIllIlII);
        return (llllllllllllllIlIIIllllIlIllIIll < 0) ? "" : llllllllllllllIlIIIllllIlIllIllI.substring(llllllllllllllIlIIIllllIlIllIlII + 1, llllllllllllllIlIIIllllIlIllIIll);
    }
    
    public static IResourceManager getResourceManager() {
        return Config.minecraft.getResourceManager();
    }
    
    public static boolean hasResource(final IResourceManager llllllllllllllIlIIlIIIIIllllIllI, final ResourceLocation llllllllllllllIlIIlIIIIIllllIlIl) {
        try {
            final IResource llllllllllllllIlIIlIIIIIlllllIII = llllllllllllllIlIIlIIIIIllllIllI.getResource(llllllllllllllIlIIlIIIIIllllIlIl);
            return llllllllllllllIlIIlIIIIIlllllIII != null;
        }
        catch (IOException llllllllllllllIlIIlIIIIIllllIlll) {
            return false;
        }
    }
    
    public static int[] addIntsToArray(final int[] llllllllllllllIlIIIllllIIllIlIII, final int[] llllllllllllllIlIIIllllIIllIIlll) {
        if (llllllllllllllIlIIIllllIIllIlIII != null && llllllllllllllIlIIIllllIIllIIlll != null) {
            final int llllllllllllllIlIIIllllIIllIllII = llllllllllllllIlIIIllllIIllIlIII.length;
            final int llllllllllllllIlIIIllllIIllIlIll = llllllllllllllIlIIIllllIIllIllII + llllllllllllllIlIIIllllIIllIIlll.length;
            final int[] llllllllllllllIlIIIllllIIllIlIlI = new int[llllllllllllllIlIIIllllIIllIlIll];
            System.arraycopy(llllllllllllllIlIIIllllIIllIlIII, 0, llllllllllllllIlIIIllllIIllIlIlI, 0, llllllllllllllIlIIIllllIIllIllII);
            for (int llllllllllllllIlIIIllllIIllIlIIl = 0; llllllllllllllIlIIIllllIIllIlIIl < llllllllllllllIlIIIllllIIllIIlll.length; ++llllllllllllllIlIIIllllIIllIlIIl) {
                llllllllllllllIlIIIllllIIllIlIlI[llllllllllllllIlIIIllllIIllIlIIl + llllllllllllllIlIIIllllIIllIllII] = llllllllllllllIlIIIllllIIllIIlll[llllllllllllllIlIIIllllIIllIlIIl];
            }
            return llllllllllllllIlIIIllllIIllIlIlI;
        }
        throw new NullPointerException("The given array is NULL");
    }
    
    public static boolean isTimeNightOnly() {
        return Config.gameSettings.ofTime == 2;
    }
    
    public static void sleep(final long llllllllllllllIlIIlIIIIIlIllIlIl) {
        try {
            Thread.currentThread();
            Thread.sleep(llllllllllllllIlIIlIIIIIlIllIlIl);
        }
        catch (InterruptedException llllllllllllllIlIIlIIIIIlIllIllI) {
            llllllllllllllIlIIlIIIIIlIllIllI.printStackTrace();
        }
    }
    
    public static void setModelManager(ModelManager llllllllllllllIlIIlIIIIlIlIlllII) {
        llllllllllllllIlIIlIIIIlIlIlllII = llllllllllllllIlIIlIIIIlIlIlllII;
    }
    
    public static boolean isTimeDefault() {
        return Config.gameSettings.ofTime == 0;
    }
    
    private static String[] splitRelease(final String llllllllllllllIlIIIlllllllIlllIl) {
        if (llllllllllllllIlIIIlllllllIlllIl == null || llllllllllllllIlIIIlllllllIlllIl.length() <= 0) {
            return new String[] { "", "", "" };
        }
        final Pattern llllllllllllllIlIIIlllllllIlllII = Pattern.compile("([A-Z])([0-9]+)(.*)");
        final Matcher llllllllllllllIlIIIlllllllIllIll = llllllllllllllIlIIIlllllllIlllII.matcher(llllllllllllllIlIIIlllllllIlllIl);
        if (!llllllllllllllIlIIIlllllllIllIll.matches()) {
            return new String[] { "", "", "" };
        }
        final String llllllllllllllIlIIIlllllllIllIlI = normalize(llllllllllllllIlIIIlllllllIllIll.group(1));
        final String llllllllllllllIlIIIlllllllIllIIl = normalize(llllllllllllllIlIIIlllllllIllIll.group(2));
        final String llllllllllllllIlIIIlllllllIllIII = normalize(llllllllllllllIlIIIlllllllIllIll.group(3));
        return new String[] { llllllllllllllIlIIIlllllllIllIlI, llllllllllllllIlIIIlllllllIllIIl, llllllllllllllIlIIIlllllllIllIII };
    }
    
    public static boolean isWeatherEnabled() {
        return Config.gameSettings.ofWeather;
    }
    
    public static TextureManager getTextureManager() {
        return Config.minecraft.getTextureManager();
    }
    
    public static DisplayMode getDisplayMode(final Dimension llllllllllllllIlIIlIIIIIIlIlIIll) throws LWJGLException {
        final DisplayMode[] llllllllllllllIlIIlIIIIIIlIlIllI = Display.getAvailableDisplayModes();
        for (int llllllllllllllIlIIlIIIIIIlIlIlIl = 0; llllllllllllllIlIIlIIIIIIlIlIlIl < llllllllllllllIlIIlIIIIIIlIlIllI.length; ++llllllllllllllIlIIlIIIIIIlIlIlIl) {
            final DisplayMode llllllllllllllIlIIlIIIIIIlIlIlII = llllllllllllllIlIIlIIIIIIlIlIllI[llllllllllllllIlIIlIIIIIIlIlIlIl];
            if (llllllllllllllIlIIlIIIIIIlIlIlII.getWidth() == llllllllllllllIlIIlIIIIIIlIlIIll.width && llllllllllllllIlIIlIIIIIIlIlIlII.getHeight() == llllllllllllllIlIIlIIIIIIlIlIIll.height && (Config.desktopDisplayMode == null || (llllllllllllllIlIIlIIIIIIlIlIlII.getBitsPerPixel() == Config.desktopDisplayMode.getBitsPerPixel() && llllllllllllllIlIIlIIIIIIlIlIlII.getFrequency() == Config.desktopDisplayMode.getFrequency()))) {
                return llllllllllllllIlIIlIIIIIIlIlIlII;
            }
        }
        return Config.desktopDisplayMode;
    }
    
    public static boolean isAnimatedFire() {
        return Config.gameSettings.ofAnimatedFire;
    }
    
    public static void updateFramebufferSize() {
        Config.minecraft.getFramebuffer().createBindFramebuffer(Config.minecraft.displayWidth, Config.minecraft.displayHeight);
        if (Config.minecraft.entityRenderer != null) {
            Config.minecraft.entityRenderer.updateShaderGroupSize(Config.minecraft.displayWidth, Config.minecraft.displayHeight);
        }
    }
    
    public static void dbg(final String llllllllllllllIlIIlIIIIlIlllIlII) {
        Config.systemOut.print("[OptiFine] ");
        Config.systemOut.println(llllllllllllllIlIIlIIIIlIlllIlII);
    }
    
    public static boolean isMipmaps() {
        return Config.gameSettings.mipmapLevels > 0;
    }
    
    public static boolean isAnisotropicFiltering() {
        return getAnisotropicFilterLevel() > 1;
    }
    
    public static void drawFps() {
        final Minecraft llllllllllllllIlIIIllllIllIlIIll = Config.minecraft;
        final int llllllllllllllIlIIIllllIllIlIIlI = Minecraft.func_175610_ah();
        final String llllllllllllllIlIIIllllIllIlIIII = getUpdates(Config.minecraft.debug);
        final int llllllllllllllIlIIIllllIllIIlllI = Config.minecraft.renderGlobal.getCountActiveRenderers();
        final int llllllllllllllIlIIIllllIllIIllII = Config.minecraft.renderGlobal.getCountEntitiesRendered();
        final int llllllllllllllIlIIIllllIllIIlIlI = Config.minecraft.renderGlobal.getCountTileEntitiesRendered();
        final String llllllllllllllIlIIIllllIllIIlIII = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIllllIllIlIIlI).append(" fps, C: ").append(llllllllllllllIlIIIllllIllIIlllI).append(", E: ").append(llllllllllllllIlIIIllllIllIIllII).append("+").append(llllllllllllllIlIIIllllIllIIlIlI).append(", U: ").append(llllllllllllllIlIIIllllIllIlIIII));
        Config.minecraft.fontRendererObj.drawString(llllllllllllllIlIIIllllIllIIlIII, 2.0, 2.0, -2039584);
    }
    
    public static Object[] addObjectToArray(final Object[] llllllllllllllIlIIIlllllIIIIIIlI, final Object llllllllllllllIlIIIlllllIIIIIIIl, final int llllllllllllllIlIIIlllllIIIIIIII) {
        final ArrayList llllllllllllllIlIIIlllllIIIIIlII = new ArrayList((Collection<? extends E>)Arrays.asList(llllllllllllllIlIIIlllllIIIIIIlI));
        llllllllllllllIlIIIlllllIIIIIlII.add(llllllllllllllIlIIIlllllIIIIIIII, llllllllllllllIlIIIlllllIIIIIIIl);
        final Object[] llllllllllllllIlIIIlllllIIIIIIll = (Object[])Array.newInstance(llllllllllllllIlIIIlllllIIIIIIlI.getClass().getComponentType(), llllllllllllllIlIIIlllllIIIIIlII.size());
        return llllllllllllllIlIIIlllllIIIIIlII.toArray(llllllllllllllIlIIIlllllIIIIIIll);
    }
    
    public static boolean isLazyChunkLoading() {
        return isSingleProcessor() && Config.gameSettings.ofLazyChunkLoading;
    }
    
    public static boolean isNotify64BitJava() {
        return Config.notify64BitJava;
    }
    
    public static Dimension getFullscreenDimension() {
        if (Config.desktopDisplayMode == null) {
            return null;
        }
        if (Config.gameSettings == null) {
            return new Dimension(Config.desktopDisplayMode.getWidth(), Config.desktopDisplayMode.getHeight());
        }
        final String llllllllllllllIlIIlIIIIIlIlIlIII = Config.gameSettings.ofFullscreenMode;
        if (llllllllllllllIlIIlIIIIIlIlIlIII.equals("Default")) {
            return new Dimension(Config.desktopDisplayMode.getWidth(), Config.desktopDisplayMode.getHeight());
        }
        final String[] llllllllllllllIlIIlIIIIIlIlIIlll = tokenize(llllllllllllllIlIIlIIIIIlIlIlIII, " x");
        return (llllllllllllllIlIIlIIIIIlIlIIlll.length < 2) ? new Dimension(Config.desktopDisplayMode.getWidth(), Config.desktopDisplayMode.getHeight()) : new Dimension(parseInt(llllllllllllllIlIIlIIIIIlIlIIlll[0], -1), parseInt(llllllllllllllIlIIlIIIIIlIlIIlll[1], -1));
    }
    
    public static boolean hasResource(final ResourceLocation llllllllllllllIlIIlIIIIlIIIIIIlI) {
        try {
            final IResource llllllllllllllIlIIlIIIIlIIIIIIIl = getResource(llllllllllllllIlIIlIIIIlIIIIIIlI);
            return llllllllllllllIlIIlIIIIlIIIIIIIl != null;
        }
        catch (IOException llllllllllllllIlIIlIIIIlIIIIIIII) {
            return false;
        }
    }
    
    public static boolean isAnimatedTextures() {
        return Config.gameSettings.ofAnimatedTextures;
    }
    
    public static double limit(final double llllllllllllllIlIIlIIIIlIlIIIIll, final double llllllllllllllIlIIlIIIIlIlIIIIlI, final double llllllllllllllIlIIlIIIIlIlIIIlII) {
        return (llllllllllllllIlIIlIIIIlIlIIIIll < llllllllllllllIlIIlIIIIlIlIIIIlI) ? llllllllllllllIlIIlIIIIlIlIIIIlI : ((llllllllllllllIlIIlIIIIlIlIIIIll > llllllllllllllIlIIlIIIIlIlIIIlII) ? llllllllllllllIlIIlIIIIlIlIIIlII : llllllllllllllIlIIlIIIIlIlIIIIll);
    }
    
    public static void showGuiMessage(final String llllllllllllllIlIIIllllIIlllllIl, final String llllllllllllllIlIIIllllIIlllllll) {
        final GuiMessage llllllllllllllIlIIIllllIIllllllI = new GuiMessage(Config.minecraft.currentScreen, llllllllllllllIlIIIllllIIlllllIl, llllllllllllllIlIIIllllIIlllllll);
        Config.minecraft.displayGuiScreen(llllllllllllllIlIIIllllIIllllllI);
    }
    
    public static boolean isRandomMobs() {
        return Config.gameSettings.ofRandomMobs;
    }
    
    public static boolean isAnimatedTerrain() {
        return Config.gameSettings.ofAnimatedTerrain;
    }
    
    public static int getAnisotropicFilterLevel() {
        return Config.gameSettings.ofAfLevel;
    }
    
    public static boolean isUseAlphaFunc() {
        final float llllllllllllllIlIIlIIIIlIllllIII = getAlphaFuncLevel();
        return llllllllllllllIlIIlIIIIlIllllIII > Config.DEF_ALPHA_FUNC_LEVEL + 1.0E-5f;
    }
    
    public static boolean isGeneratedLava() {
        return Config.gameSettings.ofAnimatedLava == 1;
    }
    
    public static float getAlphaFuncLevel() {
        return Config.DEF_ALPHA_FUNC_LEVEL;
    }
    
    public static void setNewRelease(String llllllllllllllIlIIlIIIIIIIIIIIlI) {
        llllllllllllllIlIIlIIIIIIIIIIIlI = llllllllllllllIlIIlIIIIIIIIIIIlI;
    }
    
    public static void checkDisplaySettings() {
        final int llllllllllllllIlIIIllllllIlIIIll = getAntialiasingLevel();
        if (llllllllllllllIlIIIllllllIlIIIll > 0) {
            final DisplayMode llllllllllllllIlIIIllllllIlIIIlI = Display.getDisplayMode();
            dbg(String.valueOf(new StringBuilder("FSAA Samples: ").append(llllllllllllllIlIIIllllllIlIIIll)));
            try {
                Display.destroy();
                Display.setDisplayMode(llllllllllllllIlIIIllllllIlIIIlI);
                Display.create(new PixelFormat().withDepthBits(24).withSamples(llllllllllllllIlIIIllllllIlIIIll));
                Display.setResizable(false);
                Display.setResizable(true);
            }
            catch (LWJGLException llllllllllllllIlIIIllllllIlIIIIl) {
                warn(String.valueOf(new StringBuilder("Error setting FSAA: ").append(llllllllllllllIlIIIllllllIlIIIll).append("x")));
                llllllllllllllIlIIIllllllIlIIIIl.printStackTrace();
                try {
                    Display.setDisplayMode(llllllllllllllIlIIIllllllIlIIIlI);
                    Display.create(new PixelFormat().withDepthBits(24));
                    Display.setResizable(false);
                    Display.setResizable(true);
                }
                catch (LWJGLException llllllllllllllIlIIIllllllIlIIIII) {
                    llllllllllllllIlIIIllllllIlIIIII.printStackTrace();
                    try {
                        Display.setDisplayMode(llllllllllllllIlIIIllllllIlIIIlI);
                        Display.create();
                        Display.setResizable(false);
                        Display.setResizable(true);
                    }
                    catch (LWJGLException llllllllllllllIlIIIllllllIIlllll) {
                        llllllllllllllIlIIIllllllIIlllll.printStackTrace();
                    }
                }
            }
            if (!Minecraft.isRunningOnMac && getDefaultResourcePack() != null) {
                InputStream llllllllllllllIlIIIllllllIIllllI = null;
                InputStream llllllllllllllIlIIIllllllIIlllIl = null;
                try {
                    llllllllllllllIlIIIllllllIIllllI = getDefaultResourcePack().func_152780_c(new ResourceLocation("icons/icon_16x16.png"));
                    llllllllllllllIlIIIllllllIIlllIl = getDefaultResourcePack().func_152780_c(new ResourceLocation("icons/icon_32x32.png"));
                    if (llllllllllllllIlIIIllllllIIllllI != null && llllllllllllllIlIIIllllllIIlllIl != null) {
                        Display.setIcon(new ByteBuffer[] { readIconImage(llllllllllllllIlIIIllllllIIllllI), readIconImage(llllllllllllllIlIIIllllllIIlllIl) });
                    }
                }
                catch (IOException llllllllllllllIlIIIllllllIIlllII) {
                    warn(String.valueOf(new StringBuilder("Error setting window icon: ").append(llllllllllllllIlIIIllllllIIlllII.getClass().getName()).append(": ").append(llllllllllllllIlIIIllllllIIlllII.getMessage())));
                    return;
                }
                finally {
                    IOUtils.closeQuietly(llllllllllllllIlIIIllllllIIllllI);
                    IOUtils.closeQuietly(llllllllllllllIlIIIllllllIIlllIl);
                }
                IOUtils.closeQuietly(llllllllllllllIlIIIllllllIIllllI);
                IOUtils.closeQuietly(llllllllllllllIlIIIllllllIIlllIl);
            }
        }
    }
    
    public static boolean isShaders() {
        return Shaders.shaderPackLoaded;
    }
    
    public static boolean isSmoothBiomes() {
        return Config.gameSettings.ofSmoothBiomes;
    }
    
    public static void updateAvailableProcessors() {
        Config.availableProcessors = Runtime.getRuntime().availableProcessors();
    }
    
    public static void warn(final String llllllllllllllIlIIlIIIIlIlllIIIl) {
        Config.systemOut.print("[OptiFine] [WARN] ");
        Config.systemOut.println(llllllllllllllIlIIlIIIIlIlllIIIl);
    }
    
    public static String[] tokenize(final String llllllllllllllIlIIlIIIIIIllllllI, final String llllllllllllllIlIIlIIIIIlIIIIIll) {
        final StringTokenizer llllllllllllllIlIIlIIIIIlIIIIIlI = new StringTokenizer(llllllllllllllIlIIlIIIIIIllllllI, llllllllllllllIlIIlIIIIIlIIIIIll);
        final ArrayList llllllllllllllIlIIlIIIIIlIIIIIIl = new ArrayList();
        while (llllllllllllllIlIIlIIIIIlIIIIIlI.hasMoreTokens()) {
            final String llllllllllllllIlIIlIIIIIlIIIIIII = llllllllllllllIlIIlIIIIIlIIIIIlI.nextToken();
            llllllllllllllIlIIlIIIIIlIIIIIIl.add(llllllllllllllIlIIlIIIIIlIIIIIII);
        }
        final String[] llllllllllllllIlIIlIIIIIIlllllll = llllllllllllllIlIIlIIIIIlIIIIIIl.toArray(new String[llllllllllllllIlIIlIIIIIlIIIIIIl.size()]);
        return llllllllllllllIlIIlIIIIIIlllllll;
    }
    
    public static boolean isTreesFancy() {
        return (Config.gameSettings.ofTrees == 0) ? Config.gameSettings.fancyGraphics : (Config.gameSettings.ofTrees != 1);
    }
    
    public static byte[] readAll(final InputStream llllllllllllllIlIIlIIIIIIIIIlllI) throws IOException {
        final ByteArrayOutputStream llllllllllllllIlIIlIIIIIIIIIllIl = new ByteArrayOutputStream();
        final byte[] llllllllllllllIlIIlIIIIIIIIIllII = new byte[1024];
        while (true) {
            final int llllllllllllllIlIIlIIIIIIIIIlIll = llllllllllllllIlIIlIIIIIIIIIlllI.read(llllllllllllllIlIIlIIIIIIIIIllII);
            if (llllllllllllllIlIIlIIIIIIIIIlIll < 0) {
                break;
            }
            llllllllllllllIlIIlIIIIIIIIIllIl.write(llllllllllllllIlIIlIIIIIIIIIllII, 0, llllllllllllllIlIIlIIIIIIIIIlIll);
        }
        llllllllllllllIlIIlIIIIIIIIIlllI.close();
        final byte[] llllllllllllllIlIIlIIIIIIIIIlIlI = llllllllllllllIlIIlIIIIIIIIIllIl.toByteArray();
        return llllllllllllllIlIIlIIIIIIIIIlIlI;
    }
    
    public static boolean isAnimatedRedstone() {
        return Config.gameSettings.ofAnimatedRedstone;
    }
    
    public static void log(final String llllllllllllllIlIIlIIIIlIllIlIll) {
        dbg(llllllllllllllIlIIlIIIIlIllIlIll);
    }
    
    public static boolean isAnimatedSmoke() {
        return Config.gameSettings.ofAnimatedSmoke;
    }
    
    public static boolean isBetterGrassFancy() {
        return Config.gameSettings.ofBetterGrass == 2;
    }
    
    public static void initDisplay() {
        checkInitialized();
        Config.antialiasingLevel = Config.gameSettings.ofAaLevel;
        checkDisplaySettings();
        checkDisplayMode();
        Config.minecraftThread = Thread.currentThread();
        updateThreadPriorities();
        Shaders.startup(Minecraft.getMinecraft());
    }
    
    public static InputStream getResourceStream(final ResourceLocation llllllllllllllIlIIlIIIIlIIIlIIIl) throws IOException {
        return getResourceStream(Config.minecraft.getResourceManager(), llllllllllllllIlIIlIIIIlIIIlIIIl);
    }
    
    public static String readInputStream(final InputStream llllllllllllllIlIIlIIIIIIIIlllll, final String llllllllllllllIlIIlIIIIIIIIllIII) throws IOException {
        final InputStreamReader llllllllllllllIlIIlIIIIIIIIlllIl = new InputStreamReader(llllllllllllllIlIIlIIIIIIIIlllll, llllllllllllllIlIIlIIIIIIIIllIII);
        final BufferedReader llllllllllllllIlIIlIIIIIIIIlllII = new BufferedReader(llllllllllllllIlIIlIIIIIIIIlllIl);
        final StringBuffer llllllllllllllIlIIlIIIIIIIIllIll = new StringBuffer();
        while (true) {
            final String llllllllllllllIlIIlIIIIIIIIllIlI = llllllllllllllIlIIlIIIIIIIIlllII.readLine();
            if (llllllllllllllIlIIlIIIIIIIIllIlI == null) {
                break;
            }
            llllllllllllllIlIIlIIIIIIIIllIll.append(llllllllllllllIlIIlIIIIIIIIllIlI);
            llllllllllllllIlIIlIIIIIIIIllIll.append("\n");
        }
        return llllllllllllllIlIIlIIIIIIIIllIll.toString();
    }
    
    private static Method getMethod(final Class llllllllllllllIlIIlIIIIlIIllIIIl, final String llllllllllllllIlIIlIIIIlIIllIIII, final Object[] llllllllllllllIlIIlIIIIlIIllIlIl) {
        final Method[] llllllllllllllIlIIlIIIIlIIllIlII = llllllllllllllIlIIlIIIIlIIllIIIl.getMethods();
        for (int llllllllllllllIlIIlIIIIlIIllIIll = 0; llllllllllllllIlIIlIIIIlIIllIIll < llllllllllllllIlIIlIIIIlIIllIlII.length; ++llllllllllllllIlIIlIIIIlIIllIIll) {
            final Method llllllllllllllIlIIlIIIIlIIllIIlI = llllllllllllllIlIIlIIIIlIIllIlII[llllllllllllllIlIIlIIIIlIIllIIll];
            if (llllllllllllllIlIIlIIIIlIIllIIlI.getName().equals(llllllllllllllIlIIlIIIIlIIllIIII) && llllllllllllllIlIIlIIIIlIIllIIlI.getParameterTypes().length == llllllllllllllIlIIlIIIIlIIllIlIl.length) {
                return llllllllllllllIlIIlIIIIlIIllIIlI;
            }
        }
        warn(String.valueOf(new StringBuilder("No method found for: ").append(llllllllllllllIlIIlIIIIlIIllIIIl.getName()).append(".").append(llllllllllllllIlIIlIIIIlIIllIIII).append("(").append(arrayToString(llllllllllllllIlIIlIIIIlIIllIlIl)).append(")")));
        return null;
    }
    
    public static void setNotify64BitJava(final boolean llllllllllllllIlIIIllllIlIIlllII) {
        Config.notify64BitJava = llllllllllllllIlIIIllllIlIIlllII;
    }
    
    public static void initGameSettings(final GameSettings llllllllllllllIlIIlIIIIllIlIlllI) {
        if (Config.gameSettings == null) {
            Config.gameSettings = llllllllllllllIlIIlIIIIllIlIlllI;
            Config.minecraft = Minecraft.getMinecraft();
            Config.desktopDisplayMode = Display.getDesktopDisplayMode();
            updateAvailableProcessors();
            ReflectorForge.putLaunchBlackboard("optifine.ForgeSplashCompatible", Boolean.TRUE);
        }
    }
    
    public static boolean isAnimatedExplosion() {
        return Config.gameSettings.ofAnimatedExplosion;
    }
    
    public static boolean isDynamicLightsFast() {
        return Config.gameSettings.ofDynamicLights == 1;
    }
    
    public static boolean isAnimatedLava() {
        return Config.gameSettings.ofAnimatedLava != 2;
    }
    
    public static boolean isAnimatedPortal() {
        return Config.gameSettings.ofAnimatedPortal;
    }
    
    public static boolean parseBoolean(String llllllllllllllIlIIlIIIIIlIIIllII, final boolean llllllllllllllIlIIlIIIIIlIIIlllI) {
        try {
            if (llllllllllllllIlIIlIIIIIlIIIllII == null) {
                return llllllllllllllIlIIlIIIIIlIIIlllI;
            }
            llllllllllllllIlIIlIIIIIlIIIllII = llllllllllllllIlIIlIIIIIlIIIllII.trim();
            return Boolean.parseBoolean(llllllllllllllIlIIlIIIIIlIIIllII);
        }
        catch (NumberFormatException llllllllllllllIlIIlIIIIIlIIIllIl) {
            return llllllllllllllIlIIlIIIIIlIIIlllI;
        }
    }
    
    public static GameSettings getGameSettings() {
        return Config.gameSettings;
    }
    
    public static boolean isFancyFogAvailable() {
        return Config.fancyFogAvailable;
    }
    
    public static boolean isAnimatedFlame() {
        return Config.gameSettings.ofAnimatedFlame;
    }
    
    public static boolean isVignetteEnabled() {
        return (Config.gameSettings.ofVignette == 0) ? Config.gameSettings.fancyGraphics : (Config.gameSettings.ofVignette == 2);
    }
    
    public static boolean isSwampColors() {
        return Config.gameSettings.ofSwampColors;
    }
    
    public static boolean isCloudsOff() {
        return (Config.gameSettings.ofClouds != 0) ? (Config.gameSettings.ofClouds == 3) : ((isShaders() && !Shaders.shaderPackClouds.isDefault()) ? Shaders.shaderPackClouds.isOff() : (Config.texturePackClouds != 0 && Config.texturePackClouds == 3));
    }
    
    public static int parseInt(String llllllllllllllIlIIlIIIIIlIIllllI, final int llllllllllllllIlIIlIIIIIlIIlllIl) {
        try {
            if (llllllllllllllIlIIlIIIIIlIIllllI == null) {
                return llllllllllllllIlIIlIIIIIlIIlllIl;
            }
            llllllllllllllIlIIlIIIIIlIIllllI = llllllllllllllIlIIlIIIIIlIIllllI.trim();
            return Integer.parseInt(llllllllllllllIlIIlIIIIIlIIllllI);
        }
        catch (NumberFormatException llllllllllllllIlIIlIIIIIlIIlllll) {
            return llllllllllllllIlIIlIIIIIlIIlllIl;
        }
    }
    
    public static boolean isBetterSnow() {
        return Config.gameSettings.ofBetterSnow;
    }
    
    public static boolean isDynamicHandLight() {
        return isDynamicLights() && (!isShaders() || Shaders.isDynamicHandLight());
    }
    
    public static boolean isPortalParticles() {
        return Config.gameSettings.ofPortalParticles;
    }
    
    public static boolean isCullFacesLeaves() {
        return (Config.gameSettings.ofTrees == 0) ? (!Config.gameSettings.fancyGraphics) : (Config.gameSettings.ofTrees == 4);
    }
    
    public static String getNewRelease() {
        return Config.newRelease;
    }
    
    public static String getVersion() {
        return "OptiFine_1.8_HD_U_H6";
    }
    
    public static void checkDisplayMode() {
        try {
            if (Config.minecraft.isFullScreen()) {
                if (Config.fullscreenModeChecked) {
                    return;
                }
                Config.fullscreenModeChecked = true;
                Config.desktopModeChecked = false;
                final DisplayMode llllllllllllllIlIIIlllllIlIlIIll = Display.getDisplayMode();
                final Dimension llllllllllllllIlIIIlllllIlIlIIIl = getFullscreenDimension();
                if (llllllllllllllIlIIIlllllIlIlIIIl == null) {
                    return;
                }
                if (llllllllllllllIlIIIlllllIlIlIIll.getWidth() == llllllllllllllIlIIIlllllIlIlIIIl.width && llllllllllllllIlIIIlllllIlIlIIll.getHeight() == llllllllllllllIlIIIlllllIlIlIIIl.height) {
                    return;
                }
                final DisplayMode llllllllllllllIlIIIlllllIlIIllll = getDisplayMode(llllllllllllllIlIIIlllllIlIlIIIl);
                if (llllllllllllllIlIIIlllllIlIIllll == null) {
                    return;
                }
                Display.setDisplayMode(llllllllllllllIlIIIlllllIlIIllll);
                Config.minecraft.displayWidth = Display.getDisplayMode().getWidth();
                Config.minecraft.displayHeight = Display.getDisplayMode().getHeight();
                if (Config.minecraft.displayWidth <= 0) {
                    Config.minecraft.displayWidth = 1;
                }
                if (Config.minecraft.displayHeight <= 0) {
                    Config.minecraft.displayHeight = 1;
                }
                if (Config.minecraft.currentScreen != null) {
                    final ScaledResolution llllllllllllllIlIIIlllllIlIIllIl = new ScaledResolution(Config.minecraft, Config.minecraft.displayWidth, Config.minecraft.displayHeight);
                    final int llllllllllllllIlIIIlllllIlIIlIll = llllllllllllllIlIIIlllllIlIIllIl.getScaledWidth();
                    final int llllllllllllllIlIIIlllllIlIIlIIl = llllllllllllllIlIIIlllllIlIIllIl.getScaledHeight();
                    Config.minecraft.currentScreen.setWorldAndResolution(Config.minecraft, llllllllllllllIlIIIlllllIlIIlIll, llllllllllllllIlIIIlllllIlIIlIIl);
                }
                Config.minecraft.loadingScreen = new LoadingScreenRenderer(Config.minecraft);
                updateFramebufferSize();
                Display.setFullscreen(true);
                Config.minecraft.gameSettings.updateVSync();
                GlStateManager.func_179098_w();
            }
            else {
                if (Config.desktopModeChecked) {
                    return;
                }
                Config.desktopModeChecked = true;
                Config.fullscreenModeChecked = false;
                Config.minecraft.gameSettings.updateVSync();
                Display.update();
                GlStateManager.func_179098_w();
                Display.setResizable(false);
                Display.setResizable(true);
            }
        }
        catch (Exception llllllllllllllIlIIIlllllIlIIIlll) {
            llllllllllllllIlIIIlllllIlIIIlll.printStackTrace();
        }
    }
    
    static {
        OF_NAME = "OptiFine";
        MC_VERSION = "1.8";
        VERSION = "OptiFine_1.8_HD_U_H6";
        OF_EDITION = "HD_U";
        OF_RELEASE = "H6";
        Config.newRelease = null;
        Config.notify64BitJava = false;
        Config.openGlVersion = null;
        Config.openGlRenderer = null;
        Config.openGlVendor = null;
        Config.fancyFogAvailable = false;
        Config.occlusionAvailable = false;
        Config.gameSettings = null;
        Config.minecraft = null;
        Config.initialized = false;
        Config.minecraftThread = null;
        Config.desktopDisplayMode = null;
        Config.antialiasingLevel = 0;
        Config.availableProcessors = 0;
        Config.zoomMode = false;
        Config.texturePackClouds = 0;
        Config.waterOpacityChanged = false;
        Config.fullscreenModeChecked = false;
        Config.desktopModeChecked = false;
        Config.defaultResourcePack = null;
        Config.modelManager = null;
        Config.systemOut = new PrintStream(new FileOutputStream(FileDescriptor.out));
        DEF_ALPHA_FUNC_LEVEL = 0.1f;
    }
    
    public static boolean isAntialiasingConfigured() {
        return getGameSettings().ofAaLevel > 0;
    }
    
    public static String getVersionDebug() {
        final StringBuffer llllllllllllllIlIIlIIIIllIllllll = new StringBuffer(32);
        if (isDynamicLights()) {
            llllllllllllllIlIIlIIIIllIllllll.append("DL: ");
            llllllllllllllIlIIlIIIIllIllllll.append(String.valueOf(DynamicLights.getCount()));
            llllllllllllllIlIIlIIIIllIllllll.append(", ");
        }
        llllllllllllllIlIIlIIIIllIllllll.append("OptiFine_1.8_HD_U_H6");
        final String llllllllllllllIlIIlIIIIllIllllIl = Shaders.getShaderPackName();
        if (llllllllllllllIlIIlIIIIllIllllIl != null) {
            llllllllllllllIlIIlIIIIllIllllll.append(", ");
            llllllllllllllIlIIlIIIIllIllllll.append(llllllllllllllIlIIlIIIIllIllllIl);
        }
        return llllllllllllllIlIIlIIIIllIllllll.toString();
    }
    
    public static boolean isSunMoonEnabled() {
        return Config.gameSettings.ofSunMoon;
    }
    
    public static boolean isNaturalTextures() {
        return Config.gameSettings.ofNaturalTextures;
    }
    
    public static boolean isRainSplash() {
        return Config.gameSettings.ofRainSplash;
    }
    
    public static void checkInitialized() {
        if (!Config.initialized && Display.isCreated()) {
            Config.initialized = true;
            checkOpenGlCaps();
            startVersionCheckThread();
        }
    }
    
    public static boolean isSmoothWorld() {
        return Config.gameSettings.ofSmoothWorld;
    }
    
    public static String[] readLines(final File llllllllllllllIlIIlIIIIIIlIIIIlI) throws IOException {
        final FileInputStream llllllllllllllIlIIlIIIIIIlIIIIll = new FileInputStream(llllllllllllllIlIIlIIIIIIlIIIIlI);
        return readLines(llllllllllllllIlIIlIIIIIIlIIIIll);
    }
    
    public static void error(final String llllllllllllllIlIIlIIIIlIllIlllI) {
        Config.systemOut.print("[OptiFine] [ERROR] ");
        Config.systemOut.println(llllllllllllllIlIIlIIIIlIllIlllI);
    }
}
