package net.minecraft.util;

import java.nio.*;
import java.io.*;
import net.minecraft.client.shader.*;
import org.lwjgl.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import javax.imageio.*;
import java.awt.image.*;
import net.minecraft.event.*;
import java.util.*;
import org.apache.logging.log4j.*;
import java.text.*;

public class ScreenShotHelper
{
    private static final /* synthetic */ DateFormat dateFormat;
    private static /* synthetic */ IntBuffer pixelBuffer;
    private static /* synthetic */ int[] pixelValues;
    private static final /* synthetic */ Logger logger;
    
    public static IChatComponent saveScreenshot(final File lllllllllllllllIIllIlIIIlIlIlIlI, final int lllllllllllllllIIllIlIIIlIlIlIIl, final int lllllllllllllllIIllIlIIIlIlIIlII, final Framebuffer lllllllllllllllIIllIlIIIlIlIIlll) {
        return saveScreenshot(lllllllllllllllIIllIlIIIlIlIlIlI, null, lllllllllllllllIIllIlIIIlIlIlIIl, lllllllllllllllIIllIlIIIlIlIIlII, lllllllllllllllIIllIlIIIlIlIIlll);
    }
    
    public static IChatComponent saveScreenshot(final File lllllllllllllllIIllIlIIIlIIIlIII, final String lllllllllllllllIIllIlIIIlIIlIllI, int lllllllllllllllIIllIlIIIlIIIIllI, int lllllllllllllllIIllIlIIIlIIIIlIl, final Framebuffer lllllllllllllllIIllIlIIIlIIlIIll) {
        try {
            final File lllllllllllllllIIllIlIIIlIIlIIlI = new File(lllllllllllllllIIllIlIIIlIIIlIII, "screenshots");
            lllllllllllllllIIllIlIIIlIIlIIlI.mkdir();
            if (OpenGlHelper.isFramebufferEnabled()) {
                lllllllllllllllIIllIlIIIlIIIIllI = lllllllllllllllIIllIlIIIlIIlIIll.framebufferTextureWidth;
                lllllllllllllllIIllIlIIIlIIIIlIl = lllllllllllllllIIllIlIIIlIIlIIll.framebufferTextureHeight;
            }
            final int lllllllllllllllIIllIlIIIlIIlIIIl = lllllllllllllllIIllIlIIIlIIIIllI * lllllllllllllllIIllIlIIIlIIIIlIl;
            if (ScreenShotHelper.pixelBuffer == null || ScreenShotHelper.pixelBuffer.capacity() < lllllllllllllllIIllIlIIIlIIlIIIl) {
                ScreenShotHelper.pixelBuffer = BufferUtils.createIntBuffer(lllllllllllllllIIllIlIIIlIIlIIIl);
                ScreenShotHelper.pixelValues = new int[lllllllllllllllIIllIlIIIlIIlIIIl];
            }
            GL11.glPixelStorei(3333, 1);
            GL11.glPixelStorei(3317, 1);
            ScreenShotHelper.pixelBuffer.clear();
            if (OpenGlHelper.isFramebufferEnabled()) {
                GlStateManager.func_179144_i(lllllllllllllllIIllIlIIIlIIlIIll.framebufferTexture);
                GL11.glGetTexImage(3553, 0, 32993, 33639, ScreenShotHelper.pixelBuffer);
            }
            else {
                GL11.glReadPixels(0, 0, lllllllllllllllIIllIlIIIlIIIIllI, lllllllllllllllIIllIlIIIlIIIIlIl, 32993, 33639, ScreenShotHelper.pixelBuffer);
            }
            ScreenShotHelper.pixelBuffer.get(ScreenShotHelper.pixelValues);
            TextureUtil.func_147953_a(ScreenShotHelper.pixelValues, lllllllllllllllIIllIlIIIlIIIIllI, lllllllllllllllIIllIlIIIlIIIIlIl);
            BufferedImage lllllllllllllllIIllIlIIIlIIlIIII = null;
            if (OpenGlHelper.isFramebufferEnabled()) {
                lllllllllllllllIIllIlIIIlIIlIIII = new BufferedImage(lllllllllllllllIIllIlIIIlIIlIIll.framebufferWidth, lllllllllllllllIIllIlIIIlIIlIIll.framebufferHeight, 1);
                int lllllllllllllllIIllIlIIIlIIIlllI;
                for (int lllllllllllllllIIllIlIIIlIIIllll = lllllllllllllllIIllIlIIIlIIIlllI = lllllllllllllllIIllIlIIIlIIlIIll.framebufferTextureHeight - lllllllllllllllIIllIlIIIlIIlIIll.framebufferHeight; lllllllllllllllIIllIlIIIlIIIlllI < lllllllllllllllIIllIlIIIlIIlIIll.framebufferTextureHeight; ++lllllllllllllllIIllIlIIIlIIIlllI) {
                    for (int lllllllllllllllIIllIlIIIlIIIllIl = 0; lllllllllllllllIIllIlIIIlIIIllIl < lllllllllllllllIIllIlIIIlIIlIIll.framebufferWidth; ++lllllllllllllllIIllIlIIIlIIIllIl) {
                        lllllllllllllllIIllIlIIIlIIlIIII.setRGB(lllllllllllllllIIllIlIIIlIIIllIl, lllllllllllllllIIllIlIIIlIIIlllI - lllllllllllllllIIllIlIIIlIIIllll, ScreenShotHelper.pixelValues[lllllllllllllllIIllIlIIIlIIIlllI * lllllllllllllllIIllIlIIIlIIlIIll.framebufferTextureWidth + lllllllllllllllIIllIlIIIlIIIllIl]);
                    }
                }
            }
            else {
                lllllllllllllllIIllIlIIIlIIlIIII = new BufferedImage(lllllllllllllllIIllIlIIIlIIIIllI, lllllllllllllllIIllIlIIIlIIIIlIl, 1);
                lllllllllllllllIIllIlIIIlIIlIIII.setRGB(0, 0, lllllllllllllllIIllIlIIIlIIIIllI, lllllllllllllllIIllIlIIIlIIIIlIl, ScreenShotHelper.pixelValues, 0, lllllllllllllllIIllIlIIIlIIIIllI);
            }
            File lllllllllllllllIIllIlIIIlIIIlIll = null;
            if (lllllllllllllllIIllIlIIIlIIlIllI == null) {
                final File lllllllllllllllIIllIlIIIlIIIllII = getTimestampedPNGFileForDirectory(lllllllllllllllIIllIlIIIlIIlIIlI);
            }
            else {
                lllllllllllllllIIllIlIIIlIIIlIll = new File(lllllllllllllllIIllIlIIIlIIlIIlI, lllllllllllllllIIllIlIIIlIIlIllI);
            }
            ImageIO.write(lllllllllllllllIIllIlIIIlIIlIIII, "png", lllllllllllllllIIllIlIIIlIIIlIll);
            final ChatComponentText lllllllllllllllIIllIlIIIlIIIlIlI = new ChatComponentText(lllllllllllllllIIllIlIIIlIIIlIll.getName());
            lllllllllllllllIIllIlIIIlIIIlIlI.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, lllllllllllllllIIllIlIIIlIIIlIll.getAbsolutePath()));
            lllllllllllllllIIllIlIIIlIIIlIlI.getChatStyle().setUnderlined(true);
            return new ChatComponentTranslation("screenshot.success", new Object[] { lllllllllllllllIIllIlIIIlIIIlIlI });
        }
        catch (Exception lllllllllllllllIIllIlIIIlIIIlIIl) {
            ScreenShotHelper.logger.warn("Couldn't save screenshot", (Throwable)lllllllllllllllIIllIlIIIlIIIlIIl);
            return new ChatComponentTranslation("screenshot.failure", new Object[] { lllllllllllllllIIllIlIIIlIIIlIIl.getMessage() });
        }
    }
    
    private static File getTimestampedPNGFileForDirectory(final File lllllllllllllllIIllIlIIIIllllIIl) {
        final String lllllllllllllllIIllIlIIIIllllIII = ScreenShotHelper.dateFormat.format(new Date()).toString();
        int lllllllllllllllIIllIlIIIIlllIlll = 1;
        File lllllllllllllllIIllIlIIIIlllIllI;
        while (true) {
            lllllllllllllllIIllIlIIIIlllIllI = new File(lllllllllllllllIIllIlIIIIllllIIl, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIllIlIIIIllllIII)).append((lllllllllllllllIIllIlIIIIlllIlll == 1) ? "" : String.valueOf(new StringBuilder("_").append(lllllllllllllllIIllIlIIIIlllIlll))).append(".png")));
            if (!lllllllllllllllIIllIlIIIIlllIllI.exists()) {
                break;
            }
            ++lllllllllllllllIIllIlIIIIlllIlll;
        }
        return lllllllllllllllIIllIlIIIIlllIllI;
    }
    
    static {
        __OBFID = "CL_00000656";
        logger = LogManager.getLogger();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    }
}
