package net.minecraft.client.renderer.texture;

import java.nio.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import org.lwjgl.*;
import javax.imageio.*;
import java.awt.image.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.*;
import java.io.*;
import optifine.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;

public class TextureUtil
{
    public static final /* synthetic */ DynamicTexture missingTexture;
    private static final /* synthetic */ IntBuffer dataBuffer;
    private static final /* synthetic */ Logger logger;
    public static final /* synthetic */ int[] missingTextureData;
    
    public static int uploadTextureImage(final int llllllllllllllIlllIlIllIlIllIIIl, final BufferedImage llllllllllllllIlllIlIllIlIllIIII) {
        return uploadTextureImageAllocate(llllllllllllllIlllIlIllIlIllIIIl, llllllllllllllIlllIlIllIlIllIIII, false, false);
    }
    
    private static void uploadTextureSub(final int llllllllllllllIlllIlIllIIIlIIIll, final int[] llllllllllllllIlllIlIllIIIlIIIlI, final int llllllllllllllIlllIlIllIIIlIIIIl, final int llllllllllllllIlllIlIllIIIIlIIlI, final int llllllllllllllIlllIlIllIIIIlllll, final int llllllllllllllIlllIlIllIIIIllllI, final boolean llllllllllllllIlllIlIllIIIIIllll, final boolean llllllllllllllIlllIlIllIIIIIlllI, final boolean llllllllllllllIlllIlIllIIIIIllIl) {
        final int llllllllllllllIlllIlIllIIIIllIlI = 4194304 / llllllllllllllIlllIlIllIIIlIIIIl;
        func_147954_b(llllllllllllllIlllIlIllIIIIIllll, llllllllllllllIlllIlIllIIIIIllIl);
        setTextureClamped(llllllllllllllIlllIlIllIIIIIlllI);
        int llllllllllllllIlllIlIllIIIIllIIl;
        for (int llllllllllllllIlllIlIllIIIIllIII = 0; llllllllllllllIlllIlIllIIIIllIII < llllllllllllllIlllIlIllIIIlIIIIl * llllllllllllllIlllIlIllIIIIlIIlI; llllllllllllllIlllIlIllIIIIllIII += llllllllllllllIlllIlIllIIIlIIIIl * llllllllllllllIlllIlIllIIIIllIIl) {
            final int llllllllllllllIlllIlIllIIIIlIlll = llllllllllllllIlllIlIllIIIIllIII / llllllllllllllIlllIlIllIIIlIIIIl;
            llllllllllllllIlllIlIllIIIIllIIl = Math.min(llllllllllllllIlllIlIllIIIIllIlI, llllllllllllllIlllIlIllIIIIlIIlI - llllllllllllllIlllIlIllIIIIlIlll);
            final int llllllllllllllIlllIlIllIIIIlIllI = llllllllllllllIlllIlIllIIIlIIIIl * llllllllllllllIlllIlIllIIIIllIIl;
            copyToBufferPos(llllllllllllllIlllIlIllIIIlIIIlI, llllllllllllllIlllIlIllIIIIllIII, llllllllllllllIlllIlIllIIIIlIllI);
            GL11.glTexSubImage2D(3553, llllllllllllllIlllIlIllIIIlIIIll, llllllllllllllIlllIlIllIIIIlllll, llllllllllllllIlllIlIllIIIIllllI + llllllllllllllIlllIlIllIIIIlIlll, llllllllllllllIlllIlIllIIIlIIIIl, llllllllllllllIlllIlIllIIIIllIIl, 32993, 33639, TextureUtil.dataBuffer);
        }
    }
    
    public static int glGenTextures() {
        return GlStateManager.func_179146_y();
    }
    
    private static void copyToBufferPos(final int[] llllllllllllllIlllIlIlIllIIIlllI, final int llllllllllllllIlllIlIlIllIIIlIIl, final int llllllllllllllIlllIlIlIllIIIlIII) {
        int[] llllllllllllllIlllIlIlIllIIIlIll = llllllllllllllIlllIlIlIllIIIlllI;
        if (Minecraft.getMinecraft().gameSettings.anaglyph) {
            llllllllllllllIlllIlIlIllIIIlIll = updateAnaglyph(llllllllllllllIlllIlIlIllIIIlllI);
        }
        TextureUtil.dataBuffer.clear();
        TextureUtil.dataBuffer.put(llllllllllllllIlllIlIlIllIIIlIll, llllllllllllllIlllIlIlIllIIIlIIl, llllllllllllllIlllIlIlIllIIIlIII);
        TextureUtil.dataBuffer.position(0).limit(llllllllllllllIlllIlIlIllIIIlIII);
    }
    
    public static void allocateTexture(final int llllllllllllllIlllIlIlIlllllIlIl, final int llllllllllllllIlllIlIlIlllllIlll, final int llllllllllllllIlllIlIlIlllllIllI) {
        func_180600_a(llllllllllllllIlllIlIlIlllllIlIl, 0, llllllllllllllIlllIlIlIlllllIlll, llllllllllllllIlllIlIlIlllllIllI);
    }
    
    public static int func_177054_c(final int llllllllllllllIlllIlIlIlIlIIllll) {
        final int llllllllllllllIlllIlIlIlIlIlIllI = llllllllllllllIlllIlIlIlIlIIllll >> 24 & 0xFF;
        final int llllllllllllllIlllIlIlIlIlIlIlIl = llllllllllllllIlllIlIlIlIlIIllll >> 16 & 0xFF;
        final int llllllllllllllIlllIlIlIlIlIlIlII = llllllllllllllIlllIlIlIlIlIIllll >> 8 & 0xFF;
        final int llllllllllllllIlllIlIlIlIlIlIIll = llllllllllllllIlllIlIlIlIlIIllll & 0xFF;
        final int llllllllllllllIlllIlIlIlIlIlIIlI = (llllllllllllllIlllIlIlIlIlIlIlIl * 30 + llllllllllllllIlllIlIlIlIlIlIlII * 59 + llllllllllllllIlllIlIlIlIlIlIIll * 11) / 100;
        final int llllllllllllllIlllIlIlIlIlIlIIIl = (llllllllllllllIlllIlIlIlIlIlIlIl * 30 + llllllllllllllIlllIlIlIlIlIlIlII * 70) / 100;
        final int llllllllllllllIlllIlIlIlIlIlIIII = (llllllllllllllIlllIlIlIlIlIlIlIl * 30 + llllllllllllllIlllIlIlIlIlIlIIll * 70) / 100;
        return llllllllllllllIlllIlIlIlIlIlIllI << 24 | llllllllllllllIlllIlIlIlIlIlIIlI << 16 | llllllllllllllIlllIlIlIlIlIlIIIl << 8 | llllllllllllllIlllIlIlIlIlIlIIII;
    }
    
    public static int uploadTextureImageAllocate(final int llllllllllllllIlllIlIllIIIIIIIll, final BufferedImage llllllllllllllIlllIlIllIIIIIIIlI, final boolean llllllllllllllIlllIlIllIIIIIIIIl, final boolean llllllllllllllIlllIlIllIIIIIIIII) {
        allocateTexture(llllllllllllllIlllIlIllIIIIIIIll, llllllllllllllIlllIlIllIIIIIIIlI.getWidth(), llllllllllllllIlllIlIllIIIIIIIlI.getHeight());
        return uploadTextureImageSub(llllllllllllllIlllIlIllIIIIIIIll, llllllllllllllIlllIlIllIIIIIIIlI, 0, 0, llllllllllllllIlllIlIllIIIIIIIIl, llllllllllllllIlllIlIllIIIIIIIII);
    }
    
    public static void setTextureClamped(final boolean llllllllllllllIlllIlIlIllIlIIllI) {
        if (llllllllllllllIlllIlIlIllIlIIllI) {
            GL11.glTexParameteri(3553, 10242, 33071);
            GL11.glTexParameteri(3553, 10243, 33071);
        }
        else {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
    }
    
    public static void deleteTexture(final int llllllllllllllIlllIlIllIlIllIlIl) {
        GlStateManager.func_179150_h(llllllllllllllIlllIlIllIlIllIlIl);
    }
    
    public static void func_177055_a(final String llllllllllllllIlllIlIlIlIIlllIIl, final int llllllllllllllIlllIlIlIlIIlIlIlI, final int llllllllllllllIlllIlIlIlIIllIlll, final int llllllllllllllIlllIlIlIlIIllIllI, final int llllllllllllllIlllIlIlIlIIllIlIl) {
        bindTexture(llllllllllllllIlllIlIlIlIIlIlIlI);
        GL11.glPixelStorei(3333, 1);
        GL11.glPixelStorei(3317, 1);
        for (int llllllllllllllIlllIlIlIlIIllIlII = 0; llllllllllllllIlllIlIlIlIIllIlII <= llllllllllllllIlllIlIlIlIIllIlll; ++llllllllllllllIlllIlIlIlIIllIlII) {
            final File llllllllllllllIlllIlIlIlIIllIIll = new File(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIlIlIlIIlllIIl)).append("_").append(llllllllllllllIlllIlIlIlIIllIlII).append(".png")));
            final int llllllllllllllIlllIlIlIlIIllIIlI = llllllllllllllIlllIlIlIlIIllIllI >> llllllllllllllIlllIlIlIlIIllIlII;
            final int llllllllllllllIlllIlIlIlIIllIIIl = llllllllllllllIlllIlIlIlIIllIlIl >> llllllllllllllIlllIlIlIlIIllIlII;
            final int llllllllllllllIlllIlIlIlIIllIIII = llllllllllllllIlllIlIlIlIIllIIlI * llllllllllllllIlllIlIlIlIIllIIIl;
            final IntBuffer llllllllllllllIlllIlIlIlIIlIllll = BufferUtils.createIntBuffer(llllllllllllllIlllIlIlIlIIllIIII);
            final int[] llllllllllllllIlllIlIlIlIIlIlllI = new int[llllllllllllllIlllIlIlIlIIllIIII];
            GL11.glGetTexImage(3553, llllllllllllllIlllIlIlIlIIllIlII, 32993, 33639, llllllllllllllIlllIlIlIlIIlIllll);
            llllllllllllllIlllIlIlIlIIlIllll.get(llllllllllllllIlllIlIlIlIIlIlllI);
            final BufferedImage llllllllllllllIlllIlIlIlIIlIllIl = new BufferedImage(llllllllllllllIlllIlIlIlIIllIIlI, llllllllllllllIlllIlIlIlIIllIIIl, 2);
            llllllllllllllIlllIlIlIlIIlIllIl.setRGB(0, 0, llllllllllllllIlllIlIlIlIIllIIlI, llllllllllllllIlllIlIlIlIIllIIIl, llllllllllllllIlllIlIlIlIIlIlllI, 0, llllllllllllllIlllIlIlIlIIllIIlI);
            try {
                ImageIO.write(llllllllllllllIlllIlIlIlIIlIllIl, "png", llllllllllllllIlllIlIlIlIIllIIll);
                TextureUtil.logger.debug("Exported png to: {}", new Object[] { llllllllllllllIlllIlIlIlIIllIIll.getAbsolutePath() });
            }
            catch (Exception llllllllllllllIlllIlIlIlIIlIllII) {
                TextureUtil.logger.debug("Unable to write: ", (Throwable)llllllllllllllIlllIlIlIlIIlIllII);
            }
        }
    }
    
    static {
        __OBFID = "CL_00001067";
        logger = LogManager.getLogger();
        dataBuffer = GLAllocation.createDirectIntBuffer(4194304);
        missingTexture = new DynamicTexture(16, 16);
        missingTextureData = TextureUtil.missingTexture.getTextureData();
        final int llllllllllllllIlllIlIllIllIIIlIl = -16777216;
        final int llllllllllllllIlllIlIllIllIIIlII = -524040;
        final int[] llllllllllllllIlllIlIllIllIIIIll = { -524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040 };
        final int[] llllllllllllllIlllIlIllIllIIIIlI = { -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216 };
        final int llllllllllllllIlllIlIllIllIIIIIl = llllllllllllllIlllIlIllIllIIIIll.length;
        for (int llllllllllllllIlllIlIllIllIIIIII = 0; llllllllllllllIlllIlIllIllIIIIII < 16; ++llllllllllllllIlllIlIllIllIIIIII) {
            System.arraycopy((llllllllllllllIlllIlIllIllIIIIII < llllllllllllllIlllIlIllIllIIIIIl) ? llllllllllllllIlllIlIllIllIIIIll : llllllllllllllIlllIlIllIllIIIIlI, 0, TextureUtil.missingTextureData, 16 * llllllllllllllIlllIlIllIllIIIIII, llllllllllllllIlllIlIllIllIIIIIl);
            System.arraycopy((llllllllllllllIlllIlIllIllIIIIII < llllllllllllllIlllIlIllIllIIIIIl) ? llllllllllllllIlllIlIllIllIIIIlI : llllllllllllllIlllIlIllIllIIIIll, 0, TextureUtil.missingTextureData, 16 * llllllllllllllIlllIlIllIllIIIIII + llllllllllllllIlllIlIllIllIIIIIl, llllllllllllllIlllIlIllIllIIIIIl);
        }
        TextureUtil.missingTexture.updateDynamicTexture();
        field_147957_g = new int[4];
    }
    
    public static BufferedImage func_177053_a(final InputStream llllllllllllllIlllIlIlIlIllIlIll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnonnull       6
        //     4: aconst_null    
        //     5: areturn        
        //     6: aload_0         /* llllllllllllllIlllIlIlIlIllIlllI */
        //     7: invokestatic    javax/imageio/ImageIO.read:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    10: astore_1        /* llllllllllllllIlllIlIlIlIllIlIlI */
        //    11: goto            21
        //    14: astore_2        /* llllllllllllllIlllIlIlIlIllIlIIl */
        //    15: aload_0         /* llllllllllllllIlllIlIlIlIllIlllI */
        //    16: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    19: aload_2         /* llllllllllllllIlllIlIlIlIllIlIIl */
        //    20: athrow         
        //    21: aload_0         /* llllllllllllllIlllIlIlIlIllIlllI */
        //    22: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    25: aload_1         /* llllllllllllllIlllIlIlIlIllIllII */
        //    26: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.io.IOException
        //    StackMapTable: 00 03 06 47 07 01 92 FC 00 06 07 00 B4
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  6      14     14     21     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static int func_147944_a(final int llllllllllllllIlllIlIllIIllIIIII, final int llllllllllllllIlllIlIllIIlIlIlIl, final int llllllllllllllIlllIlIllIIlIllllI, final int llllllllllllllIlllIlIllIIlIlIIll, final int llllllllllllllIlllIlIllIIlIlIIlI) {
        final float llllllllllllllIlllIlIllIIlIllIll = (float)Math.pow((llllllllllllllIlllIlIllIIllIIIII >> llllllllllllllIlllIlIllIIlIlIIlI & 0xFF) / 255.0f, 2.2);
        final float llllllllllllllIlllIlIllIIlIllIlI = (float)Math.pow((llllllllllllllIlllIlIllIIlIlIlIl >> llllllllllllllIlllIlIllIIlIlIIlI & 0xFF) / 255.0f, 2.2);
        final float llllllllllllllIlllIlIllIIlIllIIl = (float)Math.pow((llllllllllllllIlllIlIllIIlIllllI >> llllllllllllllIlllIlIllIIlIlIIlI & 0xFF) / 255.0f, 2.2);
        final float llllllllllllllIlllIlIllIIlIllIII = (float)Math.pow((llllllllllllllIlllIlIllIIlIlIIll >> llllllllllllllIlllIlIllIIlIlIIlI & 0xFF) / 255.0f, 2.2);
        final float llllllllllllllIlllIlIllIIlIlIlll = (float)Math.pow((llllllllllllllIlllIlIllIIlIllIll + llllllllllllllIlllIlIllIIlIllIlI + llllllllllllllIlllIlIllIIlIllIIl + llllllllllllllIlllIlIllIIlIllIII) * 0.25, 0.45454545454545453);
        return (int)(llllllllllllllIlllIlIllIIlIlIlll * 255.0);
    }
    
    public static void func_180600_a(final int llllllllllllllIlllIlIlIllllIIllI, final int llllllllllllllIlllIlIlIllllIlIll, final int llllllllllllllIlllIlIlIllllIlIlI, final int llllllllllllllIlllIlIlIllllIlIIl) {
        Class llllllllllllllIlllIlIlIllllIlIII = TextureUtil.class;
        if (Reflector.SplashScreen.exists()) {
            llllllllllllllIlllIlIlIllllIlIII = Reflector.SplashScreen.getTargetClass();
        }
        synchronized (llllllllllllllIlllIlIlIllllIlIII) {
            deleteTexture(llllllllllllllIlllIlIlIllllIIllI);
            bindTexture(llllllllllllllIlllIlIlIllllIIllI);
        }
        if (llllllllllllllIlllIlIlIllllIlIll >= 0) {
            GL11.glTexParameteri(3553, 33085, llllllllllllllIlllIlIlIllllIlIll);
            GL11.glTexParameterf(3553, 33082, 0.0f);
            GL11.glTexParameterf(3553, 33083, (float)llllllllllllllIlllIlIlIllllIlIll);
            GL11.glTexParameterf(3553, 34049, 0.0f);
        }
        for (int llllllllllllllIlllIlIlIllllIIlll = 0; llllllllllllllIlllIlIlIllllIIlll <= llllllllllllllIlllIlIlIllllIlIll; ++llllllllllllllIlllIlIlIllllIIlll) {
            GL11.glTexImage2D(3553, llllllllllllllIlllIlIlIllllIIlll, 6408, llllllllllllllIlllIlIlIllllIlIlI >> llllllllllllllIlllIlIlIllllIIlll, llllllllllllllIlllIlIlIllllIlIIl >> llllllllllllllIlllIlIlIllllIIlll, 0, 32993, 33639, (IntBuffer)null);
        }
    }
    
    public static void uploadTextureMipmap(final int[][] llllllllllllllIlllIlIllIIlIIIIll, final int llllllllllllllIlllIlIllIIlIIIIlI, final int llllllllllllllIlllIlIllIIlIIIIIl, final int llllllllllllllIlllIlIllIIlIIIIII, final int llllllllllllllIlllIlIllIIIllIllI, final boolean llllllllllllllIlllIlIllIIIllIlIl, final boolean llllllllllllllIlllIlIllIIIllIlII) {
        for (int llllllllllllllIlllIlIllIIIllllII = 0; llllllllllllllIlllIlIllIIIllllII < llllllllllllllIlllIlIllIIlIIIIll.length; ++llllllllllllllIlllIlIllIIIllllII) {
            final int[] llllllllllllllIlllIlIllIIIlllIll = llllllllllllllIlllIlIllIIlIIIIll[llllllllllllllIlllIlIllIIIllllII];
            uploadTextureSub(llllllllllllllIlllIlIllIIIllllII, llllllllllllllIlllIlIllIIIlllIll, llllllllllllllIlllIlIllIIlIIIIlI >> llllllllllllllIlllIlIllIIIllllII, llllllllllllllIlllIlIllIIlIIIIIl >> llllllllllllllIlllIlIllIIIllllII, llllllllllllllIlllIlIllIIlIIIIII >> llllllllllllllIlllIlIllIIIllllII, llllllllllllllIlllIlIllIIIllIllI >> llllllllllllllIlllIlIllIIIllllII, llllllllllllllIlllIlIllIIIllIlIl, llllllllllllllIlllIlIllIIIllIlII, llllllllllllllIlllIlIllIIlIIIIll.length > 1);
        }
    }
    
    public static int[] updateAnaglyph(final int[] llllllllllllllIlllIlIlIlIllIIIlI) {
        final int[] llllllllllllllIlllIlIlIlIllIIlII = new int[llllllllllllllIlllIlIlIlIllIIIlI.length];
        for (int llllllllllllllIlllIlIlIlIllIIIll = 0; llllllllllllllIlllIlIlIlIllIIIll < llllllllllllllIlllIlIlIlIllIIIlI.length; ++llllllllllllllIlllIlIlIlIllIIIll) {
            llllllllllllllIlllIlIlIlIllIIlII[llllllllllllllIlllIlIlIlIllIIIll] = func_177054_c(llllllllllllllIlllIlIlIlIllIIIlI[llllllllllllllIlllIlIlIlIllIIIll]);
        }
        return llllllllllllllIlllIlIlIlIllIIlII;
    }
    
    public static void func_147954_b(final boolean llllllllllllllIlllIlIlIllIIllllI, final boolean llllllllllllllIlllIlIlIllIIlllIl) {
        if (llllllllllllllIlllIlIlIllIIllllI) {
            GL11.glTexParameteri(3553, 10241, llllllllllllllIlllIlIlIllIIlllIl ? 9987 : 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        }
        else {
            final int llllllllllllllIlllIlIlIllIIlllII = Config.getMipmapType();
            GL11.glTexParameteri(3553, 10241, llllllllllllllIlllIlIlIllIIlllIl ? llllllllllllllIlllIlIlIllIIlllII : 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
    }
    
    static void bindTexture(final int llllllllllllllIlllIlIlIllIIIIlII) {
        GlStateManager.func_179144_i(llllllllllllllIlllIlIlIllIIIIlII);
    }
    
    private static void copyToBuffer(final int[] llllllllllllllIlllIlIlIllIIlIllI, final int llllllllllllllIlllIlIlIllIIlIIll) {
        copyToBufferPos(llllllllllllllIlllIlIlIllIIlIllI, 0, llllllllllllllIlllIlIlIllIIlIIll);
    }
    
    public static int[][] generateMipmapData(final int llllllllllllllIlllIlIllIlIIlIIll, final int llllllllllllllIlllIlIllIlIIIIlII, final int[][] llllllllllllllIlllIlIllIlIIlIIIl) {
        final int[][] llllllllllllllIlllIlIllIlIIlIIII = new int[llllllllllllllIlllIlIllIlIIlIIll + 1][];
        llllllllllllllIlllIlIllIlIIlIIII[0] = llllllllllllllIlllIlIllIlIIlIIIl[0];
        if (llllllllllllllIlllIlIllIlIIlIIll > 0) {
            boolean llllllllllllllIlllIlIllIlIIIllll = false;
            for (int llllllllllllllIlllIlIllIlIIIlllI = 0; llllllllllllllIlllIlIllIlIIIlllI < llllllllllllllIlllIlIllIlIIlIIIl.length; ++llllllllllllllIlllIlIllIlIIIlllI) {
                if (llllllllllllllIlllIlIllIlIIlIIIl[0][llllllllllllllIlllIlIllIlIIIlllI] >> 24 == 0) {
                    llllllllllllllIlllIlIllIlIIIllll = true;
                    break;
                }
            }
            for (int llllllllllllllIlllIlIllIlIIIlllI = 1; llllllllllllllIlllIlIllIlIIIlllI <= llllllllllllllIlllIlIllIlIIlIIll; ++llllllllllllllIlllIlIllIlIIIlllI) {
                if (llllllllllllllIlllIlIllIlIIlIIIl[llllllllllllllIlllIlIllIlIIIlllI] != null) {
                    llllllllllllllIlllIlIllIlIIlIIII[llllllllllllllIlllIlIllIlIIIlllI] = llllllllllllllIlllIlIllIlIIlIIIl[llllllllllllllIlllIlIllIlIIIlllI];
                }
                else {
                    final int[] llllllllllllllIlllIlIllIlIIIllIl = llllllllllllllIlllIlIllIlIIlIIII[llllllllllllllIlllIlIllIlIIIlllI - 1];
                    final int[] llllllllllllllIlllIlIllIlIIIllII = new int[llllllllllllllIlllIlIllIlIIIllIl.length >> 2];
                    final int llllllllllllllIlllIlIllIlIIIlIll = llllllllllllllIlllIlIllIlIIIIlII >> llllllllllllllIlllIlIllIlIIIlllI;
                    final int llllllllllllllIlllIlIllIlIIIlIlI = llllllllllllllIlllIlIllIlIIIllII.length / llllllllllllllIlllIlIllIlIIIlIll;
                    final int llllllllllllllIlllIlIllIlIIIlIIl = llllllllllllllIlllIlIllIlIIIlIll << 1;
                    for (int llllllllllllllIlllIlIllIlIIIlIII = 0; llllllllllllllIlllIlIllIlIIIlIII < llllllllllllllIlllIlIllIlIIIlIll; ++llllllllllllllIlllIlIllIlIIIlIII) {
                        for (int llllllllllllllIlllIlIllIlIIIIlll = 0; llllllllllllllIlllIlIllIlIIIIlll < llllllllllllllIlllIlIllIlIIIlIlI; ++llllllllllllllIlllIlIllIlIIIIlll) {
                            final int llllllllllllllIlllIlIllIlIIIIllI = 2 * (llllllllllllllIlllIlIllIlIIIlIII + llllllllllllllIlllIlIllIlIIIIlll * llllllllllllllIlllIlIllIlIIIlIIl);
                            llllllllllllllIlllIlIllIlIIIllII[llllllllllllllIlllIlIllIlIIIlIII + llllllllllllllIlllIlIllIlIIIIlll * llllllllllllllIlllIlIllIlIIIlIll] = func_147943_a(llllllllllllllIlllIlIllIlIIIllIl[llllllllllllllIlllIlIllIlIIIIllI + 0], llllllllllllllIlllIlIllIlIIIllIl[llllllllllllllIlllIlIllIlIIIIllI + 1], llllllllllllllIlllIlIllIlIIIllIl[llllllllllllllIlllIlIllIlIIIIllI + 0 + llllllllllllllIlllIlIllIlIIIlIIl], llllllllllllllIlllIlIllIlIIIllIl[llllllllllllllIlllIlIllIlIIIIllI + 1 + llllllllllllllIlllIlIllIlIIIlIIl], llllllllllllllIlllIlIllIlIIIllll);
                        }
                    }
                    llllllllllllllIlllIlIllIlIIlIIII[llllllllllllllIlllIlIllIlIIIlllI] = llllllllllllllIlllIlIllIlIIIllII;
                }
            }
        }
        return llllllllllllllIlllIlIllIlIIlIIII;
    }
    
    public static void uploadTexture(final int llllllllllllllIlllIlIllIlIlIIlIl, final int[] llllllllllllllIlllIlIllIlIlIlIII, final int llllllllllllllIlllIlIllIlIlIIIll, final int llllllllllllllIlllIlIllIlIlIIIlI) {
        bindTexture(llllllllllllllIlllIlIllIlIlIIlIl);
        uploadTextureSub(0, llllllllllllllIlllIlIllIlIlIlIII, llllllllllllllIlllIlIllIlIlIIIll, llllllllllllllIlllIlIllIlIlIIIlI, 0, 0, false, false, false);
    }
    
    private static int func_147943_a(final int llllllllllllllIlllIlIllIIllIlllI, final int llllllllllllllIlllIlIllIIlllIIlI, final int llllllllllllllIlllIlIllIIllIllII, final int llllllllllllllIlllIlIllIIllIlIll, final boolean llllllllllllllIlllIlIllIIllIllll) {
        return Mipmaps.alphaBlend(llllllllllllllIlllIlIllIIllIlllI, llllllllllllllIlllIlIllIIlllIIlI, llllllllllllllIlllIlIllIIllIllII, llllllllllllllIlllIlIllIIllIlIll);
    }
    
    private static void uploadTextureImageSubImpl(final BufferedImage llllllllllllllIlllIlIlIllIllIlII, final int llllllllllllllIlllIlIlIllIllIIll, final int llllllllllllllIlllIlIlIllIllIIlI, final boolean llllllllllllllIlllIlIlIllIlllllI, final boolean llllllllllllllIlllIlIlIllIllllIl) {
        final int llllllllllllllIlllIlIlIllIllllII = llllllllllllllIlllIlIlIllIllIlII.getWidth();
        final int llllllllllllllIlllIlIlIllIlllIll = llllllllllllllIlllIlIlIllIllIlII.getHeight();
        final int llllllllllllllIlllIlIlIllIlllIlI = 4194304 / llllllllllllllIlllIlIlIllIllllII;
        final int[] llllllllllllllIlllIlIlIllIlllIIl = new int[llllllllllllllIlllIlIlIllIlllIlI * llllllllllllllIlllIlIlIllIllllII];
        setTextureBlurred(llllllllllllllIlllIlIlIllIlllllI);
        setTextureClamped(llllllllllllllIlllIlIlIllIllllIl);
        for (int llllllllllllllIlllIlIlIllIlllIII = 0; llllllllllllllIlllIlIlIllIlllIII < llllllllllllllIlllIlIlIllIllllII * llllllllllllllIlllIlIlIllIlllIll; llllllllllllllIlllIlIlIllIlllIII += llllllllllllllIlllIlIlIllIllllII * llllllllllllllIlllIlIlIllIlllIlI) {
            final int llllllllllllllIlllIlIlIllIllIlll = llllllllllllllIlllIlIlIllIlllIII / llllllllllllllIlllIlIlIllIllllII;
            final int llllllllllllllIlllIlIlIllIllIllI = Math.min(llllllllllllllIlllIlIlIllIlllIlI, llllllllllllllIlllIlIlIllIlllIll - llllllllllllllIlllIlIlIllIllIlll);
            final int llllllllllllllIlllIlIlIllIllIlIl = llllllllllllllIlllIlIlIllIllllII * llllllllllllllIlllIlIlIllIllIllI;
            llllllllllllllIlllIlIlIllIllIlII.getRGB(0, llllllllllllllIlllIlIlIllIllIlll, llllllllllllllIlllIlIlIllIllllII, llllllllllllllIlllIlIlIllIllIllI, llllllllllllllIlllIlIlIllIlllIIl, 0, llllllllllllllIlllIlIlIllIllllII);
            copyToBuffer(llllllllllllllIlllIlIlIllIlllIIl, llllllllllllllIlllIlIlIllIllIlIl);
            GL11.glTexSubImage2D(3553, 0, llllllllllllllIlllIlIlIllIllIIll, llllllllllllllIlllIlIlIllIllIIlI + llllllllllllllIlllIlIlIllIllIlll, llllllllllllllIlllIlIlIllIllllII, llllllllllllllIlllIlIlIllIllIllI, 32993, 33639, TextureUtil.dataBuffer);
        }
    }
    
    public static int uploadTextureImageSub(final int llllllllllllllIlllIlIlIlllIlIlII, final BufferedImage llllllllllllllIlllIlIlIlllIllIIl, final int llllllllllllllIlllIlIlIlllIllIII, final int llllllllllllllIlllIlIlIlllIlIIIl, final boolean llllllllllllllIlllIlIlIlllIlIllI, final boolean llllllllllllllIlllIlIlIlllIIllll) {
        bindTexture(llllllllllllllIlllIlIlIlllIlIlII);
        uploadTextureImageSubImpl(llllllllllllllIlllIlIlIlllIllIIl, llllllllllllllIlllIlIlIlllIllIII, llllllllllllllIlllIlIlIlllIlIIIl, llllllllllllllIlllIlIlIlllIlIllI, llllllllllllllIlllIlIlIlllIIllll);
        return llllllllllllllIlllIlIlIlllIlIlII;
    }
    
    public static void func_147953_a(final int[] llllllllllllllIlllIlIlIlIIIlIIIl, final int llllllllllllllIlllIlIlIlIIIlIllI, final int llllllllllllllIlllIlIlIlIIIlIlIl) {
        final int[] llllllllllllllIlllIlIlIlIIIlIlII = new int[llllllllllllllIlllIlIlIlIIIlIllI];
        for (int llllllllllllllIlllIlIlIlIIIlIIll = llllllllllllllIlllIlIlIlIIIlIlIl / 2, llllllllllllllIlllIlIlIlIIIlIIlI = 0; llllllllllllllIlllIlIlIlIIIlIIlI < llllllllllllllIlllIlIlIlIIIlIIll; ++llllllllllllllIlllIlIlIlIIIlIIlI) {
            System.arraycopy(llllllllllllllIlllIlIlIlIIIlIIIl, llllllllllllllIlllIlIlIlIIIlIIlI * llllllllllllllIlllIlIlIlIIIlIllI, llllllllllllllIlllIlIlIlIIIlIlII, 0, llllllllllllllIlllIlIlIlIIIlIllI);
            System.arraycopy(llllllllllllllIlllIlIlIlIIIlIIIl, (llllllllllllllIlllIlIlIlIIIlIlIl - 1 - llllllllllllllIlllIlIlIlIIIlIIlI) * llllllllllllllIlllIlIlIlIIIlIllI, llllllllllllllIlllIlIlIlIIIlIIIl, llllllllllllllIlllIlIlIlIIIlIIlI * llllllllllllllIlllIlIlIlIIIlIllI, llllllllllllllIlllIlIlIlIIIlIllI);
            System.arraycopy(llllllllllllllIlllIlIlIlIIIlIlII, 0, llllllllllllllIlllIlIlIlIIIlIIIl, (llllllllllllllIlllIlIlIlIIIlIlIl - 1 - llllllllllllllIlllIlIlIlIIIlIIlI) * llllllllllllllIlllIlIlIlIIIlIllI, llllllllllllllIlllIlIlIlIIIlIllI);
        }
    }
    
    private static void setTextureBlurred(final boolean llllllllllllllIlllIlIlIllIlIIIlI) {
        func_147954_b(llllllllllllllIlllIlIlIllIlIIIlI, false);
    }
    
    public static int[] readImageData(final IResourceManager llllllllllllllIlllIlIlIlIlllIlll, final ResourceLocation llllllllllllllIlllIlIlIlIlllIllI) throws IOException {
        final BufferedImage llllllllllllllIlllIlIlIlIllllIll = func_177053_a(llllllllllllllIlllIlIlIlIlllIlll.getResource(llllllllllllllIlllIlIlIlIlllIllI).getInputStream());
        if (llllllllllllllIlllIlIlIlIllllIll == null) {
            return null;
        }
        final int llllllllllllllIlllIlIlIlIllllIlI = llllllllllllllIlllIlIlIlIllllIll.getWidth();
        final int llllllllllllllIlllIlIlIlIllllIIl = llllllllllllllIlllIlIlIlIllllIll.getHeight();
        final int[] llllllllllllllIlllIlIlIlIllllIII = new int[llllllllllllllIlllIlIlIlIllllIlI * llllllllllllllIlllIlIlIlIllllIIl];
        llllllllllllllIlllIlIlIlIllllIll.getRGB(0, 0, llllllllllllllIlllIlIlIlIllllIlI, llllllllllllllIlllIlIlIlIllllIIl, llllllllllllllIlllIlIlIlIllllIII, 0, llllllllllllllIlllIlIlIlIllllIlI);
        return llllllllllllllIlllIlIlIlIllllIII;
    }
}
