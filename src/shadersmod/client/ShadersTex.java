package shadersmod.client;

import java.nio.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.*;
import shadersmod.common.*;
import net.minecraft.client.resources.*;
import java.awt.image.*;
import net.minecraft.client.*;
import javax.imageio.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;

public class ShadersTex
{
    public static /* synthetic */ TextureAtlasSprite updatingSprite;
    public static /* synthetic */ ByteBuffer byteBuffer;
    public static /* synthetic */ TextureMap updatingTextureMap;
    public static /* synthetic */ Map<Integer, MultiTexID> multiTexMap;
    public static /* synthetic */ MultiTexID updatingTex;
    public static /* synthetic */ MultiTexID boundTex;
    public static /* synthetic */ IntBuffer intBuffer;
    public static /* synthetic */ IResourceManager resManager;
    public static /* synthetic */ int[] intArray;
    static /* synthetic */ ResourceLocation resLocation;
    public static /* synthetic */ int updatingPage;
    public static /* synthetic */ String iconName;
    static /* synthetic */ int imageSize;
    
    public static int blend4Alpha(final int lIlllIIIlIIIIII, final int lIlllIIIIllIIIl, final int lIlllIIIIlllllI, final int lIlllIIIIllllIl) {
        int lIlllIIIIllllII = lIlllIIIlIIIIII >>> 24 & 0xFF;
        int lIlllIIIIlllIll = lIlllIIIIllIIIl >>> 24 & 0xFF;
        int lIlllIIIIlllIlI = lIlllIIIIlllllI >>> 24 & 0xFF;
        int lIlllIIIIlllIIl = lIlllIIIIllllIl >>> 24 & 0xFF;
        final int lIlllIIIIlllIII = lIlllIIIIllllII + lIlllIIIIlllIll + lIlllIIIIlllIlI + lIlllIIIIlllIIl;
        final int lIlllIIIIllIlll = (lIlllIIIIlllIII + 2) / 4;
        int lIlllIIIIllIlIl = 0;
        if (lIlllIIIIlllIII != 0) {
            final int lIlllIIIIllIllI = lIlllIIIIlllIII;
        }
        else {
            lIlllIIIIllIlIl = 4;
            lIlllIIIIllllII = 1;
            lIlllIIIIlllIll = 1;
            lIlllIIIIlllIlI = 1;
            lIlllIIIIlllIIl = 1;
        }
        final int lIlllIIIIllIlII = (lIlllIIIIllIlIl + 1) / 2;
        final int lIlllIIIIllIIll = lIlllIIIIllIlll << 24 | ((lIlllIIIlIIIIII >>> 16 & 0xFF) * lIlllIIIIllllII + (lIlllIIIIllIIIl >>> 16 & 0xFF) * lIlllIIIIlllIll + (lIlllIIIIlllllI >>> 16 & 0xFF) * lIlllIIIIlllIlI + (lIlllIIIIllllIl >>> 16 & 0xFF) * lIlllIIIIlllIIl + lIlllIIIIllIlII) / lIlllIIIIllIlIl << 16 | ((lIlllIIIlIIIIII >>> 8 & 0xFF) * lIlllIIIIllllII + (lIlllIIIIllIIIl >>> 8 & 0xFF) * lIlllIIIIlllIll + (lIlllIIIIlllllI >>> 8 & 0xFF) * lIlllIIIIlllIlI + (lIlllIIIIllllIl >>> 8 & 0xFF) * lIlllIIIIlllIIl + lIlllIIIIllIlII) / lIlllIIIIllIlIl << 8 | ((lIlllIIIlIIIIII >>> 0 & 0xFF) * lIlllIIIIllllII + (lIlllIIIIllIIIl >>> 0 & 0xFF) * lIlllIIIIlllIll + (lIlllIIIIlllllI >>> 0 & 0xFF) * lIlllIIIIlllIlI + (lIlllIIIIllllIl >>> 0 & 0xFF) * lIlllIIIIlllIIl + lIlllIIIIllIlII) / lIlllIIIIllIlIl << 0;
        return lIlllIIIIllIIll;
    }
    
    public static void bindTextures(final int lIlllIlIlIlllII) {
        final MultiTexID lIlllIlIlIlllIl = ShadersTex.multiTexMap.get(lIlllIlIlIlllII);
        bindTextures(lIlllIlIlIlllIl);
    }
    
    public static void mergeImage(final int[] lIllIlIlllIllIl, final int lIllIlIlllIllII, final int lIllIlIlllIlIll, final int lIllIlIlllIlIlI) {
    }
    
    public static boolean isSemiTransparent(final int[] lIllIlllIlIIlII, final int lIllIlllIlIlIIl, final int lIllIlllIlIlIII) {
        final int lIllIlllIlIIlll = lIllIlllIlIlIIl * lIllIlllIlIlIII;
        if (lIllIlllIlIIlII[0] >>> 24 == 255 && lIllIlllIlIIlII[lIllIlllIlIIlll - 1] == 0) {
            return true;
        }
        for (int lIllIlllIlIIllI = 0; lIllIlllIlIIllI < lIllIlllIlIIlll; ++lIllIlllIlIIllI) {
            final int lIllIlllIlIIlIl = lIllIlllIlIIlII[lIllIlllIlIIllI] >>> 24;
            if (lIllIlllIlIIlIl != 0 && lIllIlllIlIIlIl != 255) {
                return true;
            }
        }
        return false;
    }
    
    public static MultiTexID getMultiTexID(final AbstractTexture lIlllIllIIlIIII) {
        MultiTexID lIlllIllIIlIIlI = lIlllIllIIlIIII.multiTex;
        if (lIlllIllIIlIIlI == null) {
            final int lIlllIllIIlIIIl = lIlllIllIIlIIII.getGlTextureId();
            lIlllIllIIlIIlI = ShadersTex.multiTexMap.get(lIlllIllIIlIIIl);
            if (lIlllIllIIlIIlI == null) {
                lIlllIllIIlIIlI = new MultiTexID(lIlllIllIIlIIIl, GL11.glGenTextures(), GL11.glGenTextures());
                ShadersTex.multiTexMap.put(lIlllIllIIlIIIl, lIlllIllIIlIIlI);
            }
            lIlllIllIIlIIII.multiTex = lIlllIllIIlIIlI;
        }
        return lIlllIllIIlIIlI;
    }
    
    public static int blend4Simple(final int lIlllIIIIlIIIII, final int lIlllIIIIIlllll, final int lIlllIIIIIllIIl, final int lIlllIIIIIllIII) {
        final int lIlllIIIIIlllII = ((lIlllIIIIlIIIII >>> 24 & 0xFF) + (lIlllIIIIIlllll >>> 24 & 0xFF) + (lIlllIIIIIllIIl >>> 24 & 0xFF) + (lIlllIIIIIllIII >>> 24 & 0xFF) + 2) / 4 << 24 | ((lIlllIIIIlIIIII >>> 16 & 0xFF) + (lIlllIIIIIlllll >>> 16 & 0xFF) + (lIlllIIIIIllIIl >>> 16 & 0xFF) + (lIlllIIIIIllIII >>> 16 & 0xFF) + 2) / 4 << 16 | ((lIlllIIIIlIIIII >>> 8 & 0xFF) + (lIlllIIIIIlllll >>> 8 & 0xFF) + (lIlllIIIIIllIIl >>> 8 & 0xFF) + (lIlllIIIIIllIII >>> 8 & 0xFF) + 2) / 4 << 8 | ((lIlllIIIIlIIIII >>> 0 & 0xFF) + (lIlllIIIIIlllll >>> 0 & 0xFF) + (lIlllIIIIIllIIl >>> 0 & 0xFF) + (lIlllIIIIIllIII >>> 0 & 0xFF) + 2) / 4 << 0;
        return lIlllIIIIIlllII;
    }
    
    public static void bindNSTextures(final MultiTexID lIlllIlIlllllII) {
        bindNSTextures(lIlllIlIlllllII.norm, lIlllIlIlllllII.spec);
    }
    
    public static void updateSubImage(final MultiTexID lIllIllIlIlllII, final int[] lIllIllIlIllIll, final int lIllIllIlIlIIII, final int lIllIllIlIllIIl, final int lIllIllIlIllIII, final int lIllIllIlIIllIl, final boolean lIllIllIlIlIllI, final boolean lIllIllIlIlIlIl) {
        final int lIllIllIlIlIlII = lIllIllIlIlIIII * lIllIllIlIllIIl;
        final IntBuffer lIllIllIlIlIIll = getIntBuffer(lIllIllIlIlIlII);
        lIllIllIlIlIIll.clear();
        lIllIllIlIlIIll.put(lIllIllIlIllIll, 0, lIllIllIlIlIlII);
        lIllIllIlIlIIll.position(0).limit(lIllIllIlIlIlII);
        GlStateManager.func_179144_i(lIllIllIlIlllII.base);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, lIllIllIlIllIII, lIllIllIlIIllIl, lIllIllIlIlIIII, lIllIllIlIllIIl, 32993, 33639, lIllIllIlIlIIll);
        if (lIllIllIlIllIll.length == lIllIllIlIlIlII * 3) {
            lIllIllIlIlIIll.clear();
            lIllIllIlIlIIll.put(lIllIllIlIllIll, lIllIllIlIlIlII, lIllIllIlIlIlII).position(0);
            lIllIllIlIlIIll.position(0).limit(lIllIllIlIlIlII);
        }
        GlStateManager.func_179144_i(lIllIllIlIlllII.norm);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, lIllIllIlIllIII, lIllIllIlIIllIl, lIllIllIlIlIIII, lIllIllIlIllIIl, 32993, 33639, lIllIllIlIlIIll);
        if (lIllIllIlIllIll.length == lIllIllIlIlIlII * 3) {
            lIllIllIlIlIIll.clear();
            lIllIllIlIlIIll.put(lIllIllIlIllIll, lIllIllIlIlIlII * 2, lIllIllIlIlIlII);
            lIllIllIlIlIIll.position(0).limit(lIllIllIlIlIlII);
        }
        GlStateManager.func_179144_i(lIllIllIlIlllII.spec);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, lIllIllIlIllIII, lIllIllIlIIllIl, lIllIllIlIlIIII, lIllIllIlIllIIl, 32993, 33639, lIllIllIlIlIIll);
        GlStateManager.setActiveTexture(33984);
    }
    
    public static TextureAtlasSprite setSprite(final TextureAtlasSprite lIlllIlIIIIIlII) {
        return ShadersTex.updatingSprite = lIlllIlIIIIIlII;
    }
    
    public static IntBuffer getIntBuffer(final int lIlllIlllIIIIlI) {
        if (ShadersTex.intBuffer.capacity() < lIlllIlllIIIIlI) {
            final int lIlllIlllIIIIll = roundUpPOT(lIlllIlllIIIIlI);
            ShadersTex.byteBuffer = BufferUtils.createByteBuffer(lIlllIlllIIIIll * 4);
            ShadersTex.intBuffer = ShadersTex.byteBuffer.asIntBuffer();
        }
        return ShadersTex.intBuffer;
    }
    
    public static int[] createAIntImage(final int lIlllIllIlIIIll) {
        final int[] lIlllIllIlIIIlI = new int[lIlllIllIlIIIll * 3];
        Arrays.fill(lIlllIllIlIIIlI, 0, lIlllIllIlIIIll, 0);
        Arrays.fill(lIlllIllIlIIIlI, lIlllIllIlIIIll, lIlllIllIlIIIll * 2, -8421377);
        Arrays.fill(lIlllIllIlIIIlI, lIlllIllIlIIIll * 2, lIlllIllIlIIIll * 3, 0);
        return lIlllIllIlIIIlI;
    }
    
    public static void initDynamicTexture(final int lIlllIlIlIlIlII, final int lIlllIlIlIlIIll, final int lIlllIlIlIlIIlI, final DynamicTexture lIlllIlIlIIlIll) {
        final MultiTexID lIlllIlIlIlIIII = lIlllIlIlIIlIll.getMultiTexID();
        final int[] lIlllIlIlIIllll = lIlllIlIlIIlIll.getTextureData();
        final int lIlllIlIlIIlllI = lIlllIlIlIlIIll * lIlllIlIlIlIIlI;
        Arrays.fill(lIlllIlIlIIllll, lIlllIlIlIIlllI, lIlllIlIlIIlllI * 2, -8421377);
        Arrays.fill(lIlllIlIlIIllll, lIlllIlIlIIlllI * 2, lIlllIlIlIIlllI * 3, 0);
        TextureUtil.allocateTexture(lIlllIlIlIlIIII.base, lIlllIlIlIlIIll, lIlllIlIlIlIIlI);
        TextureUtil.func_147954_b(false, false);
        TextureUtil.setTextureClamped(false);
        TextureUtil.allocateTexture(lIlllIlIlIlIIII.norm, lIlllIlIlIlIIll, lIlllIlIlIlIIlI);
        TextureUtil.func_147954_b(false, false);
        TextureUtil.setTextureClamped(false);
        TextureUtil.allocateTexture(lIlllIlIlIlIIII.spec, lIlllIlIlIlIIll, lIlllIlIlIlIIlI);
        TextureUtil.func_147954_b(false, false);
        TextureUtil.setTextureClamped(false);
        GlStateManager.func_179144_i(lIlllIlIlIlIIII.base);
    }
    
    public static void allocateTextureMap(final int lIlllIlIIIIllII, final int lIlllIlIIIlIIlI, final int lIlllIlIIIlIIIl, final int lIlllIlIIIlIIII, final Stitcher lIlllIlIIIIllll, final TextureMap lIlllIlIIIIlllI) {
        SMCLog.info(String.valueOf(new StringBuilder("allocateTextureMap ").append(lIlllIlIIIlIIlI).append(" ").append(lIlllIlIIIlIIIl).append(" ").append(lIlllIlIIIlIIII).append(" ")));
        ShadersTex.updatingTextureMap = lIlllIlIIIIlllI;
        lIlllIlIIIIlllI.atlasWidth = lIlllIlIIIlIIIl;
        lIlllIlIIIIlllI.atlasHeight = lIlllIlIIIlIIII;
        final MultiTexID lIlllIlIIIIllIl = ShadersTex.updatingTex = getMultiTexID(lIlllIlIIIIlllI);
        TextureUtil.func_180600_a(lIlllIlIIIIllIl.base, lIlllIlIIIlIIlI, lIlllIlIIIlIIIl, lIlllIlIIIlIIII);
        if (Shaders.configNormalMap) {
            TextureUtil.func_180600_a(lIlllIlIIIIllIl.norm, lIlllIlIIIlIIlI, lIlllIlIIIlIIIl, lIlllIlIIIlIIII);
        }
        if (Shaders.configSpecularMap) {
            TextureUtil.func_180600_a(lIlllIlIIIIllIl.spec, lIlllIlIIIlIIlI, lIlllIlIIIlIIIl, lIlllIlIIIlIIII);
        }
        GlStateManager.func_179144_i(lIlllIlIIIIllII);
    }
    
    public static void uploadTexSub(final int[][] lIlllIIlIIIIlII, final int lIlllIIlIIIlIlI, final int lIlllIIlIIIlIIl, final int lIlllIIlIIIIIIl, final int lIlllIIlIIIIlll, final boolean lIlllIIIlllllll, final boolean lIlllIIIllllllI) {
        TextureUtil.uploadTextureMipmap(lIlllIIlIIIIlII, lIlllIIlIIIlIlI, lIlllIIlIIIlIIl, lIlllIIlIIIIIIl, lIlllIIlIIIIlll, lIlllIIIlllllll, lIlllIIIllllllI);
        if (Shaders.configNormalMap || Shaders.configSpecularMap) {
            if (Shaders.configNormalMap) {
                GlStateManager.func_179144_i(ShadersTex.updatingTex.norm);
                uploadTexSub1(lIlllIIlIIIIlII, lIlllIIlIIIlIlI, lIlllIIlIIIlIIl, lIlllIIlIIIIIIl, lIlllIIlIIIIlll, 1);
            }
            if (Shaders.configSpecularMap) {
                GlStateManager.func_179144_i(ShadersTex.updatingTex.spec);
                uploadTexSub1(lIlllIIlIIIIlII, lIlllIIlIIIlIlI, lIlllIIlIIIlIIl, lIlllIIlIIIIIIl, lIlllIIlIIIIlll, 2);
            }
            GlStateManager.func_179144_i(ShadersTex.updatingTex.base);
        }
    }
    
    static {
        defSpecTexColor = 0;
        initialBufferSize = 1048576;
        defBaseTexColor = 0;
        defNormTexColor = -8421377;
        ShadersTex.byteBuffer = BufferUtils.createByteBuffer(4194304);
        ShadersTex.intBuffer = ShadersTex.byteBuffer.asIntBuffer();
        ShadersTex.intArray = new int[1048576];
        ShadersTex.multiTexMap = new HashMap<Integer, MultiTexID>();
        ShadersTex.updatingTextureMap = null;
        ShadersTex.updatingSprite = null;
        ShadersTex.updatingTex = null;
        ShadersTex.boundTex = null;
        ShadersTex.updatingPage = 0;
        ShadersTex.iconName = null;
        ShadersTex.resManager = null;
        ShadersTex.resLocation = null;
        ShadersTex.imageSize = 0;
    }
    
    public static ITextureObject createDefaultTexture() {
        final DynamicTexture lIlllIlIIIllIll = new DynamicTexture(1, 1);
        lIlllIlIIIllIll.getTextureData()[0] = -1;
        lIlllIlIIIllIll.updateDynamicTexture();
        return lIlllIlIIIllIll;
    }
    
    public static void bindTextures(final int lIlllIlIlllIlIl, final int lIlllIlIlllIlII, final int lIlllIlIlllIllI) {
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            GlStateManager.setActiveTexture(33986);
            GlStateManager.func_179144_i(lIlllIlIlllIlII);
            GlStateManager.setActiveTexture(33987);
            GlStateManager.func_179144_i(lIlllIlIlllIllI);
            GlStateManager.setActiveTexture(33984);
        }
        GlStateManager.func_179144_i(lIlllIlIlllIlIl);
    }
    
    public static IResource loadResource(final IResourceManager lIllIlIlIlIIIlI, final ResourceLocation lIllIlIlIlIIIIl) throws IOException {
        ShadersTex.resManager = lIllIlIlIlIIIlI;
        ShadersTex.resLocation = lIllIlIlIlIIIIl;
        return lIllIlIlIlIIIlI.getResource(lIllIlIlIlIIIIl);
    }
    
    public static int[][] readImageAndMipmaps(final String lIlllIIllIllIII, final int lIlllIIllIlIlll, final int lIlllIIllIIlIlI, final int lIlllIIllIIlIIl, final boolean lIlllIIllIlIlII, final int lIlllIIllIIIlll) {
        int[][] lIlllIIllIlIIlI = new int[lIlllIIllIIlIIl][];
        final int[] lIlllIIllIlIIIl = lIlllIIllIlIIlI[0] = new int[lIlllIIllIlIlll * lIlllIIllIIlIlI];
        boolean lIlllIIllIlIIII = false;
        final BufferedImage lIlllIIllIIllll = readImage(ShadersTex.updatingTextureMap.completeResourceLocation(new ResourceLocation(lIlllIIllIllIII), 0));
        if (lIlllIIllIIllll != null) {
            final int lIlllIIllIIlllI = lIlllIIllIIllll.getWidth();
            final int lIlllIIllIIllIl = lIlllIIllIIllll.getHeight();
            if (lIlllIIllIIlllI + (lIlllIIllIlIlII ? 16 : 0) == lIlllIIllIlIlll) {
                lIlllIIllIlIIII = true;
                lIlllIIllIIllll.getRGB(0, 0, lIlllIIllIIlllI, lIlllIIllIIlllI, lIlllIIllIlIIIl, 0, lIlllIIllIIlllI);
            }
        }
        if (!lIlllIIllIlIIII) {
            Arrays.fill(lIlllIIllIlIIIl, lIlllIIllIIIlll);
        }
        GlStateManager.func_179144_i(ShadersTex.updatingTex.spec);
        lIlllIIllIlIIlI = genMipmapsSimple(lIlllIIllIlIIlI.length - 1, lIlllIIllIlIlll, lIlllIIllIlIIlI);
        return lIlllIIllIlIIlI;
    }
    
    public static void setupTexture(final MultiTexID lIllIllIllIlllI, final int[] lIllIllIlllIlll, final int lIllIllIllIllII, final int lIllIllIlllIlIl, final boolean lIllIllIllIlIlI, final boolean lIllIllIlllIIll) {
        final int lIllIllIlllIIlI = lIllIllIllIlIlI ? 9729 : 9728;
        final int lIllIllIlllIIIl = lIllIllIlllIIll ? 10496 : 10497;
        final int lIllIllIlllIIII = lIllIllIllIllII * lIllIllIlllIlIl;
        final IntBuffer lIllIllIllIllll = getIntBuffer(lIllIllIlllIIII);
        lIllIllIllIllll.clear();
        lIllIllIllIllll.put(lIllIllIlllIlll, 0, lIllIllIlllIIII).position(0).limit(lIllIllIlllIIII);
        GlStateManager.func_179144_i(lIllIllIllIlllI.base);
        GL11.glTexImage2D(3553, 0, 6408, lIllIllIllIllII, lIllIllIlllIlIl, 0, 32993, 33639, lIllIllIllIllll);
        GL11.glTexParameteri(3553, 10241, lIllIllIlllIIlI);
        GL11.glTexParameteri(3553, 10240, lIllIllIlllIIlI);
        GL11.glTexParameteri(3553, 10242, lIllIllIlllIIIl);
        GL11.glTexParameteri(3553, 10243, lIllIllIlllIIIl);
        lIllIllIllIllll.put(lIllIllIlllIlll, lIllIllIlllIIII, lIllIllIlllIIII).position(0).limit(lIllIllIlllIIII);
        GlStateManager.func_179144_i(lIllIllIllIlllI.norm);
        GL11.glTexImage2D(3553, 0, 6408, lIllIllIllIllII, lIllIllIlllIlIl, 0, 32993, 33639, lIllIllIllIllll);
        GL11.glTexParameteri(3553, 10241, lIllIllIlllIIlI);
        GL11.glTexParameteri(3553, 10240, lIllIllIlllIIlI);
        GL11.glTexParameteri(3553, 10242, lIllIllIlllIIIl);
        GL11.glTexParameteri(3553, 10243, lIllIllIlllIIIl);
        lIllIllIllIllll.put(lIllIllIlllIlll, lIllIllIlllIIII * 2, lIllIllIlllIIII).position(0).limit(lIllIllIlllIIII);
        GlStateManager.func_179144_i(lIllIllIllIlllI.spec);
        GL11.glTexImage2D(3553, 0, 6408, lIllIllIllIllII, lIllIllIlllIlIl, 0, 32993, 33639, lIllIllIllIllll);
        GL11.glTexParameteri(3553, 10241, lIllIllIlllIIlI);
        GL11.glTexParameteri(3553, 10240, lIllIllIlllIIlI);
        GL11.glTexParameteri(3553, 10242, lIllIllIlllIIIl);
        GL11.glTexParameteri(3553, 10243, lIllIllIlllIIIl);
        GlStateManager.func_179144_i(lIllIllIllIlllI.base);
    }
    
    public static void bindTextureMapForUpdateAndRender(final TextureManager lIlllIlIllIIllI, final ResourceLocation lIlllIlIllIIlIl) {
        final TextureMap lIlllIlIllIIlII = (TextureMap)lIlllIlIllIIllI.getTexture(lIlllIlIllIIlIl);
        Shaders.atlasSizeX = lIlllIlIllIIlII.atlasWidth;
        Shaders.atlasSizeY = lIlllIlIllIIlII.atlasHeight;
        bindTextures(ShadersTex.updatingTex = lIlllIlIllIIlII.getMultiTexID());
    }
    
    public static void genMipmapAlpha(final int[] lIllIllllllIIll, final int lIllIllllllIIlI, final int lIlllIIIIIIIlII, final int lIllIllllllIIII) {
        Math.min(lIlllIIIIIIIlII, lIllIllllllIIII);
        int lIlllIIIIIIIIlI = lIllIllllllIIlI;
        int lIlllIIIIIIIIIl = lIlllIIIIIIIlII;
        int lIlllIIIIIIIIII = lIllIllllllIIII;
        int lIllIllllllllll = 0;
        int lIllIlllllllllI = 0;
        final boolean lIllIllllllllIl = false;
        int lIllIllllllllII = 0;
        while (lIlllIIIIIIIIIl > 1) {
            if (lIlllIIIIIIIIII <= 1) {
                break;
            }
            lIllIllllllllll = lIlllIIIIIIIIlI + lIlllIIIIIIIIIl * lIlllIIIIIIIIII;
            lIllIlllllllllI = lIlllIIIIIIIIIl / 2;
            final int lIllIllllllIlIl = lIlllIIIIIIIIII / 2;
            for (int lIllIlllllllIll = 0; lIllIlllllllIll < lIllIllllllIlIl; ++lIllIlllllllIll) {
                final int lIllIlllllllIIl = lIllIllllllllll + lIllIlllllllIll * lIllIlllllllllI;
                final int lIllIllllllIlll = lIlllIIIIIIIIlI + lIllIlllllllIll * 2 * lIlllIIIIIIIIIl;
                for (int lIllIllllllIlII = 0; lIllIllllllIlII < lIllIlllllllllI; ++lIllIllllllIlII) {
                    lIllIllllllIIll[lIllIlllllllIIl + lIllIllllllIlII] = blend4Alpha(lIllIllllllIIll[lIllIllllllIlll + lIllIllllllIlII * 2], lIllIllllllIIll[lIllIllllllIlll + lIllIllllllIlII * 2 + 1], lIllIllllllIIll[lIllIllllllIlll + lIlllIIIIIIIIIl + lIllIllllllIlII * 2], lIllIllllllIIll[lIllIllllllIlll + lIlllIIIIIIIIIl + lIllIllllllIlII * 2 + 1]);
                }
            }
            ++lIllIllllllllII;
            lIlllIIIIIIIIIl = lIllIlllllllllI;
            lIlllIIIIIIIIII = lIllIllllllIlIl;
            lIlllIIIIIIIIlI = lIllIllllllllll;
        }
        while (lIllIllllllllII > 0) {
            --lIllIllllllllII;
            lIlllIIIIIIIIIl = lIlllIIIIIIIlII >> lIllIllllllllII;
            lIlllIIIIIIIIII = lIllIllllllIIII >> lIllIllllllllII;
            int lIllIlllllllIlI;
            lIlllIIIIIIIIlI = (lIllIlllllllIlI = lIllIllllllllll - lIlllIIIIIIIIIl * lIlllIIIIIIIIII);
            for (int lIllIlllllllIII = 0; lIllIlllllllIII < lIlllIIIIIIIIII; ++lIllIlllllllIII) {
                for (int lIllIllllllIllI = 0; lIllIllllllIllI < lIlllIIIIIIIIIl; ++lIllIllllllIllI) {
                    if (lIllIllllllIIll[lIllIlllllllIlI] == 0) {
                        lIllIllllllIIll[lIllIlllllllIlI] = (lIllIllllllIIll[lIllIllllllllll + lIllIlllllllIII / 2 * lIllIlllllllllI + lIllIllllllIllI / 2] & 0xFFFFFF);
                    }
                    ++lIllIlllllllIlI;
                }
            }
            lIllIllllllllll = lIlllIIIIIIIIlI;
            lIllIlllllllllI = lIlllIIIIIIIIIl;
        }
    }
    
    public static int roundUpPOT(final int lIlllIllIlllIll) {
        int lIlllIllIlllIlI = lIlllIllIlllIll - 1;
        lIlllIllIlllIlI |= lIlllIllIlllIlI >> 1;
        lIlllIllIlllIlI |= lIlllIllIlllIlI >> 2;
        lIlllIllIlllIlI |= lIlllIllIlllIlI >> 4;
        lIlllIllIlllIlI |= lIlllIllIlllIlI >> 8;
        lIlllIllIlllIlI |= lIlllIllIlllIlI >> 16;
        return lIlllIllIlllIlI + 1;
    }
    
    public static void uploadTexSub1(final int[][] lIlllIIIllIllIl, final int lIlllIIIllIllII, final int lIlllIIIllIlIll, final int lIlllIIIlIllIlI, final int lIlllIIIlIllIIl, final int lIlllIIIlIllIII) {
        final int lIlllIIIllIIlll = lIlllIIIllIllII * lIlllIIIllIlIll;
        final IntBuffer lIlllIIIllIIllI = getIntBuffer(lIlllIIIllIIlll);
        for (int lIlllIIIllIIlIl = lIlllIIIllIllIl.length, lIlllIIIllIIlII = 0, lIlllIIIllIIIll = lIlllIIIllIllII, lIlllIIIllIIIlI = lIlllIIIllIlIll, lIlllIIIllIIIIl = lIlllIIIlIllIlI, lIlllIIIllIIIII = lIlllIIIlIllIIl; lIlllIIIllIIIll > 0 && lIlllIIIllIIIlI > 0 && lIlllIIIllIIlII < lIlllIIIllIIlIl; lIlllIIIllIIIll >>= 1, lIlllIIIllIIIlI >>= 1, lIlllIIIllIIIIl >>= 1, lIlllIIIllIIIII >>= 1, ++lIlllIIIllIIlII) {
            final int lIlllIIIlIlllll = lIlllIIIllIIIll * lIlllIIIllIIIlI;
            final int[] lIlllIIIlIllllI = lIlllIIIllIllIl[lIlllIIIllIIlII];
            lIlllIIIllIIllI.clear();
            if (lIlllIIIlIllllI.length >= lIlllIIIlIlllll * (lIlllIIIlIllIII + 1)) {
                lIlllIIIllIIllI.put(lIlllIIIlIllllI, lIlllIIIlIlllll * lIlllIIIlIllIII, lIlllIIIlIlllll).position(0).limit(lIlllIIIlIlllll);
                GL11.glTexSubImage2D(3553, lIlllIIIllIIlII, lIlllIIIllIIIIl, lIlllIIIllIIIII, lIlllIIIllIIIll, lIlllIIIllIIIlI, 32993, 33639, lIlllIIIllIIllI);
            }
        }
        lIlllIIIllIIllI.clear();
    }
    
    public static void loadNSMap(final IResourceManager lIllIllIIllIllI, final ResourceLocation lIllIllIIllIIII, final int lIllIllIIlIllll, final int lIllIllIIllIIll, final int[] lIllIllIIllIIlI) {
        if (Shaders.configNormalMap) {
            loadNSMap1(lIllIllIIllIllI, getNSMapLocation(lIllIllIIllIIII, "n"), lIllIllIIlIllll, lIllIllIIllIIll, lIllIllIIllIIlI, lIllIllIIlIllll * lIllIllIIllIIll, -8421377);
        }
        if (Shaders.configSpecularMap) {
            loadNSMap1(lIllIllIIllIllI, getNSMapLocation(lIllIllIIllIIII, "s"), lIllIllIIlIllll, lIllIllIIllIIll, lIllIllIIllIIlI, lIllIllIIlIllll * lIllIllIIllIIll * 2, 0);
        }
    }
    
    public static ResourceLocation getNSMapLocation(final ResourceLocation lIllIllIlIIIIII, final String lIllIllIIllllll) {
        final String lIllIllIlIIIIll = lIllIllIlIIIIII.getResourcePath();
        final String[] lIllIllIlIIIIlI = lIllIllIlIIIIll.split(".png");
        final String lIllIllIlIIIIIl = lIllIllIlIIIIlI[0];
        return new ResourceLocation(lIllIllIlIIIIII.getResourceDomain(), String.valueOf(new StringBuilder(String.valueOf(lIllIllIlIIIIIl)).append("_").append(lIllIllIIllllll).append(".png")));
    }
    
    public static void fixTransparentColor(final TextureAtlasSprite lIllIlIIlIlIlIl, final int[] lIllIlIIlIlIlII) {
    }
    
    public static int blendColor(final int lIllIlIlllIIIIl, final int lIllIlIlllIIIII, final int lIllIlIllIlllll) {
        final int lIllIlIlllIIIlI = 255 - lIllIlIllIlllll;
        return ((lIllIlIlllIIIIl >>> 24 & 0xFF) * lIllIlIllIlllll + (lIllIlIlllIIIII >>> 24 & 0xFF) * lIllIlIlllIIIlI) / 255 << 24 | ((lIllIlIlllIIIIl >>> 16 & 0xFF) * lIllIlIllIlllll + (lIllIlIlllIIIII >>> 16 & 0xFF) * lIllIlIlllIIIlI) / 255 << 16 | ((lIllIlIlllIIIIl >>> 8 & 0xFF) * lIllIlIllIlllll + (lIllIlIlllIIIII >>> 8 & 0xFF) * lIllIlIlllIIIlI) / 255 << 8 | ((lIllIlIlllIIIIl >>> 0 & 0xFF) * lIllIlIllIlllll + (lIllIlIlllIIIII >>> 0 & 0xFF) * lIllIlIlllIIIlI) / 255 << 0;
    }
    
    public static void updateDynamicTexture(final int lIlllIlIlIIIIlI, final int[] lIlllIlIIllllII, final int lIlllIlIlIIIIII, final int lIlllIlIIlllIlI, final DynamicTexture lIlllIlIIlllIIl) {
        final MultiTexID lIlllIlIIllllIl = lIlllIlIIlllIIl.getMultiTexID();
        GlStateManager.func_179144_i(lIlllIlIIllllIl.base);
        updateDynTexSubImage1(lIlllIlIIllllII, lIlllIlIlIIIIII, lIlllIlIIlllIlI, 0, 0, 0);
        GlStateManager.func_179144_i(lIlllIlIIllllIl.norm);
        updateDynTexSubImage1(lIlllIlIIllllII, lIlllIlIlIIIIII, lIlllIlIIlllIlI, 0, 0, 1);
        GlStateManager.func_179144_i(lIlllIlIIllllIl.spec);
        updateDynTexSubImage1(lIlllIlIIllllII, lIlllIlIlIIIIII, lIlllIlIIlllIlI, 0, 0, 2);
        GlStateManager.func_179144_i(lIlllIlIIllllIl.base);
    }
    
    static void updateTextureMinMagFilter() {
        final TextureManager lIllIlIlIlIllII = Minecraft.getMinecraft().getTextureManager();
        final ITextureObject lIllIlIlIlIlIll = lIllIlIlIlIllII.getTexture(TextureMap.locationBlocksTexture);
        if (lIllIlIlIlIlIll != null) {
            final MultiTexID lIllIlIlIlIlIlI = lIllIlIlIlIlIll.getMultiTexID();
            GlStateManager.func_179144_i(lIllIlIlIlIlIlI.base);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilB]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilB]);
            GlStateManager.func_179144_i(lIllIlIlIlIlIlI.norm);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilN]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilN]);
            GlStateManager.func_179144_i(lIllIlIlIlIlIlI.spec);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilS]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilS]);
            GlStateManager.func_179144_i(0);
        }
    }
    
    public static int[][] getFrameTexData(final int[][] lIllIlIIllllIlI, final int lIllIlIIllllIIl, final int lIllIlIIllIlIlI, final int lIllIlIIlllIlll) {
        final int lIllIlIIlllIllI = lIllIlIIllllIlI.length;
        final int[][] lIllIlIIlllIlIl = new int[lIllIlIIlllIllI][];
        for (int lIllIlIIlllIlII = 0; lIllIlIIlllIlII < lIllIlIIlllIllI; ++lIllIlIIlllIlII) {
            final int[] lIllIlIIlllIIll = lIllIlIIllllIlI[lIllIlIIlllIlII];
            if (lIllIlIIlllIIll != null) {
                final int lIllIlIIlllIIlI = (lIllIlIIllllIIl >> lIllIlIIlllIlII) * (lIllIlIIllIlIlI >> lIllIlIIlllIlII);
                final int[] lIllIlIIlllIIIl = new int[lIllIlIIlllIIlI * 3];
                lIllIlIIlllIlIl[lIllIlIIlllIlII] = lIllIlIIlllIIIl;
                final int lIllIlIIlllIIII = lIllIlIIlllIIll.length / 3;
                int lIllIlIIllIllll = lIllIlIIlllIIlI * lIllIlIIlllIlll;
                final byte lIllIlIIllIlllI = 0;
                System.arraycopy(lIllIlIIlllIIll, lIllIlIIllIllll, lIllIlIIlllIIIl, lIllIlIIllIlllI, lIllIlIIlllIIlI);
                lIllIlIIllIllll += lIllIlIIlllIIII;
                int lIllIlIIllIllIl = lIllIlIIllIlllI + lIllIlIIlllIIlI;
                System.arraycopy(lIllIlIIlllIIll, lIllIlIIllIllll, lIllIlIIlllIIIl, lIllIlIIllIllIl, lIllIlIIlllIIlI);
                lIllIlIIllIllll += lIllIlIIlllIIII;
                lIllIlIIllIllIl += lIllIlIIlllIIlI;
                System.arraycopy(lIllIlIIlllIIll, lIllIlIIllIllll, lIllIlIIlllIIIl, lIllIlIIllIllIl, lIllIlIIlllIIlI);
            }
        }
        return lIllIlIIlllIlIl;
    }
    
    public static void bindNSTextures(final int lIlllIllIIIIIII, final int lIlllIllIIIIIIl) {
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            GlStateManager.setActiveTexture(33986);
            GlStateManager.func_179144_i(lIlllIllIIIIIII);
            GlStateManager.setActiveTexture(33987);
            GlStateManager.func_179144_i(lIlllIllIIIIIIl);
            GlStateManager.setActiveTexture(33984);
        }
    }
    
    public static void updateSubTex1(final int[] lIllIlllIIlIlIl, final int lIllIlllIIlIlII, final int lIllIlllIIIlIlI, final int lIllIlllIIlIIlI, final int lIllIlllIIlIIIl) {
        int lIllIlllIIlIIII = 0;
        for (int lIllIlllIIIllll = lIllIlllIIlIlII, lIllIlllIIIlllI = lIllIlllIIIlIlI, lIllIlllIIIllIl = lIllIlllIIlIIlI, lIllIlllIIIllII = lIllIlllIIlIIIl; lIllIlllIIIllll > 0 && lIllIlllIIIlllI > 0; lIllIlllIIIllll /= 2, lIllIlllIIIlllI /= 2, lIllIlllIIIllIl /= 2, lIllIlllIIIllII /= 2) {
            GL11.glCopyTexSubImage2D(3553, lIllIlllIIlIIII, lIllIlllIIIllIl, lIllIlllIIIllII, 0, 0, lIllIlllIIIllll, lIllIlllIIIlllI);
            ++lIllIlllIIlIIII;
        }
    }
    
    public static void updateDynTexSubImage1(final int[] lIlllIlIIlIlllI, final int lIlllIlIIlIIlII, final int lIlllIlIIlIllII, final int lIlllIlIIlIlIll, final int lIlllIlIIlIlIlI, final int lIlllIlIIlIlIIl) {
        final int lIlllIlIIlIlIII = lIlllIlIIlIIlII * lIlllIlIIlIllII;
        final IntBuffer lIlllIlIIlIIlll = getIntBuffer(lIlllIlIIlIlIII);
        lIlllIlIIlIIlll.clear();
        final int lIlllIlIIlIIllI = lIlllIlIIlIlIIl * lIlllIlIIlIlIII;
        if (lIlllIlIIlIlllI.length >= lIlllIlIIlIIllI + lIlllIlIIlIlIII) {
            lIlllIlIIlIIlll.put(lIlllIlIIlIlllI, lIlllIlIIlIIllI, lIlllIlIIlIlIII).position(0).limit(lIlllIlIIlIlIII);
            GL11.glTexSubImage2D(3553, 0, lIlllIlIIlIlIll, lIlllIlIIlIlIlI, lIlllIlIIlIIlII, lIlllIlIIlIllII, 32993, 33639, lIlllIlIIlIIlll);
            lIlllIlIIlIIlll.clear();
        }
    }
    
    public static void loadNSMap1(final IResourceManager lIllIllIIlIIIlI, final ResourceLocation lIllIllIIlIIIIl, final int lIllIllIIIlIllI, final int lIllIllIIIlllll, final int[] lIllIllIIIlIlII, final int lIllIllIIIlllIl, final int lIllIllIIIlIIlI) {
        boolean lIllIllIIIllIll = false;
        try {
            final IResource lIllIllIIIllIlI = lIllIllIIlIIIlI.getResource(lIllIllIIlIIIIl);
            final BufferedImage lIllIllIIIllIIl = ImageIO.read(lIllIllIIIllIlI.getInputStream());
            if (lIllIllIIIllIIl != null && lIllIllIIIllIIl.getWidth() == lIllIllIIIlIllI && lIllIllIIIllIIl.getHeight() == lIllIllIIIlllll) {
                lIllIllIIIllIIl.getRGB(0, 0, lIllIllIIIlIllI, lIllIllIIIlllll, lIllIllIIIlIlII, lIllIllIIIlllIl, lIllIllIIIlIllI);
                lIllIllIIIllIll = true;
            }
        }
        catch (IOException ex) {}
        if (!lIllIllIIIllIll) {
            Arrays.fill(lIllIllIIIlIlII, lIllIllIIIlllIl, lIllIllIIIlllIl + lIllIllIIIlIllI * lIllIllIIIlllll, lIllIllIIIlIIlI);
        }
    }
    
    public static BufferedImage readImage(final ResourceLocation lIlllIIlIllllII) {
        try {
            final IResource lIlllIIlIlllIll = ShadersTex.resManager.getResource(lIlllIIlIllllII);
            if (lIlllIIlIlllIll == null) {
                return null;
            }
            final InputStream lIlllIIlIlllIlI = lIlllIIlIlllIll.getInputStream();
            if (lIlllIIlIlllIlI == null) {
                return null;
            }
            final BufferedImage lIlllIIlIlllIIl = ImageIO.read(lIlllIIlIlllIlI);
            lIlllIIlIlllIlI.close();
            return lIlllIIlIlllIIl;
        }
        catch (IOException lIlllIIlIlllIII) {
            return null;
        }
    }
    
    public static void uploadTexSubForLoadAtlas(final int[][] lIlllIIlllIllIl, final int lIlllIIlllIllII, final int lIlllIIllllIlIl, final int lIlllIIllllIlII, final int lIlllIIlllIlIIl, final boolean lIlllIIllllIIlI, final boolean lIlllIIllllIIIl) {
        TextureUtil.uploadTextureMipmap(lIlllIIlllIllIl, lIlllIIlllIllII, lIlllIIllllIlIl, lIlllIIllllIlII, lIlllIIlllIlIIl, lIlllIIllllIIlI, lIlllIIllllIIIl);
        final boolean lIlllIIllllIIII = false;
        if (Shaders.configNormalMap) {
            final int[][] lIlllIIlllIllll = readImageAndMipmaps(String.valueOf(new StringBuilder(String.valueOf(ShadersTex.iconName)).append("_n")), lIlllIIlllIllII, lIlllIIllllIlIl, lIlllIIlllIllIl.length, lIlllIIllllIIII, -8421377);
            GlStateManager.func_179144_i(ShadersTex.updatingTex.norm);
            TextureUtil.uploadTextureMipmap(lIlllIIlllIllll, lIlllIIlllIllII, lIlllIIllllIlIl, lIlllIIllllIlII, lIlllIIlllIlIIl, lIlllIIllllIIlI, lIlllIIllllIIIl);
        }
        if (Shaders.configSpecularMap) {
            final int[][] lIlllIIlllIlllI = readImageAndMipmaps(String.valueOf(new StringBuilder(String.valueOf(ShadersTex.iconName)).append("_s")), lIlllIIlllIllII, lIlllIIllllIlIl, lIlllIIlllIllIl.length, lIlllIIllllIIII, 0);
            GlStateManager.func_179144_i(ShadersTex.updatingTex.spec);
            TextureUtil.uploadTextureMipmap(lIlllIIlllIlllI, lIlllIIlllIllII, lIlllIIllllIlIl, lIlllIIllllIlII, lIlllIIlllIlIIl, lIlllIIllllIIlI, lIlllIIllllIIIl);
        }
        GlStateManager.func_179144_i(ShadersTex.updatingTex.base);
    }
    
    public static void genMipmapSimple(final int[] lIllIllllIIIIII, final int lIllIlllIllllll, final int lIllIlllIlllllI, final int lIllIlllIllllIl) {
        Math.min(lIllIlllIlllllI, lIllIlllIllllIl);
        int lIllIllllIIllll = lIllIlllIllllll;
        int lIllIllllIIlllI = lIllIlllIlllllI;
        int lIllIllllIIllIl = lIllIlllIllllIl;
        int lIllIllllIIllII = 0;
        int lIllIllllIIlIll = 0;
        final boolean lIllIllllIIlIlI = false;
        int lIllIllllIIlIIl = 0;
        while (lIllIllllIIlllI > 1) {
            if (lIllIllllIIllIl <= 1) {
                break;
            }
            lIllIllllIIllII = lIllIllllIIllll + lIllIllllIIlllI * lIllIllllIIllIl;
            lIllIllllIIlIll = lIllIllllIIlllI / 2;
            final int lIllIllllIIIIlI = lIllIllllIIllIl / 2;
            for (int lIllIllllIIlIII = 0; lIllIllllIIlIII < lIllIllllIIIIlI; ++lIllIllllIIlIII) {
                final int lIllIllllIIIllI = lIllIllllIIllII + lIllIllllIIlIII * lIllIllllIIlIll;
                final int lIllIllllIIIlII = lIllIllllIIllll + lIllIllllIIlIII * 2 * lIllIllllIIlllI;
                for (int lIllIllllIIIIIl = 0; lIllIllllIIIIIl < lIllIllllIIlIll; ++lIllIllllIIIIIl) {
                    lIllIllllIIIIII[lIllIllllIIIllI + lIllIllllIIIIIl] = blend4Simple(lIllIllllIIIIII[lIllIllllIIIlII + lIllIllllIIIIIl * 2], lIllIllllIIIIII[lIllIllllIIIlII + lIllIllllIIIIIl * 2 + 1], lIllIllllIIIIII[lIllIllllIIIlII + lIllIllllIIlllI + lIllIllllIIIIIl * 2], lIllIllllIIIIII[lIllIllllIIIlII + lIllIllllIIlllI + lIllIllllIIIIIl * 2 + 1]);
                }
            }
            ++lIllIllllIIlIIl;
            lIllIllllIIlllI = lIllIllllIIlIll;
            lIllIllllIIllIl = lIllIllllIIIIlI;
            lIllIllllIIllll = lIllIllllIIllII;
        }
        while (lIllIllllIIlIIl > 0) {
            --lIllIllllIIlIIl;
            lIllIllllIIlllI = lIllIlllIlllllI >> lIllIllllIIlIIl;
            lIllIllllIIllIl = lIllIlllIllllIl >> lIllIllllIIlIIl;
            int lIllIllllIIIlll;
            lIllIllllIIllll = (lIllIllllIIIlll = lIllIllllIIllII - lIllIllllIIlllI * lIllIllllIIllIl);
            for (int lIllIllllIIIlIl = 0; lIllIllllIIIlIl < lIllIllllIIllIl; ++lIllIllllIIIlIl) {
                for (int lIllIllllIIIIll = 0; lIllIllllIIIIll < lIllIllllIIlllI; ++lIllIllllIIIIll) {
                    if (lIllIllllIIIIII[lIllIllllIIIlll] == 0) {
                        lIllIllllIIIIII[lIllIllllIIIlll] = (lIllIllllIIIIII[lIllIllllIIllII + lIllIllllIIIlIl / 2 * lIllIllllIIlIll + lIllIllllIIIIll / 2] & 0xFFFFFF);
                    }
                    ++lIllIllllIIIlll;
                }
            }
            lIllIllllIIllII = lIllIllllIIllll;
            lIllIllllIIlIll = lIllIllllIIlllI;
        }
    }
    
    public static void bindTextures(final MultiTexID lIlllIlIlllIIIl) {
        ShadersTex.boundTex = lIlllIlIlllIIIl;
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            if (Shaders.configNormalMap) {
                GlStateManager.setActiveTexture(33986);
                GlStateManager.func_179144_i(lIlllIlIlllIIIl.norm);
            }
            if (Shaders.configSpecularMap) {
                GlStateManager.setActiveTexture(33987);
                GlStateManager.func_179144_i(lIlllIlIlllIIIl.spec);
            }
            GlStateManager.setActiveTexture(33984);
        }
        GlStateManager.func_179144_i(lIlllIlIlllIIIl.base);
    }
    
    public static int[] createAIntImage(final int lIlllIllIIlllII, final int lIlllIllIIllIll) {
        final int[] lIlllIllIIllIlI = new int[lIlllIllIIlllII * 3];
        Arrays.fill(lIlllIllIIllIlI, 0, lIlllIllIIlllII, lIlllIllIIllIll);
        Arrays.fill(lIlllIllIIllIlI, lIlllIllIIlllII, lIlllIllIIlllII * 2, -8421377);
        Arrays.fill(lIlllIllIIllIlI, lIlllIllIIlllII * 2, lIlllIllIIlllII * 3, 0);
        return lIlllIllIIllIlI;
    }
    
    public static int[] getIntArray(final int lIlllIllIllllll) {
        if (ShadersTex.intArray == null) {
            ShadersTex.intArray = new int[1048576];
        }
        if (ShadersTex.intArray.length < lIlllIllIllllll) {
            ShadersTex.intArray = new int[roundUpPOT(lIlllIllIllllll)];
        }
        return ShadersTex.intArray;
    }
    
    public static int log2(int lIlllIllIllIIll) {
        int lIlllIllIllIlII = 0;
        if ((lIlllIllIllIIll & 0xFFFF0000) != 0x0) {
            lIlllIllIllIlII += 16;
            lIlllIllIllIIll >>= 16;
        }
        if ((lIlllIllIllIIll & 0xFF00) != 0x0) {
            lIlllIllIllIlII += 8;
            lIlllIllIllIIll >>= 8;
        }
        if ((lIlllIllIllIIll & 0xF0) != 0x0) {
            lIlllIllIllIlII += 4;
            lIlllIllIllIIll >>= 4;
        }
        if ((lIlllIllIllIIll & 0x6) != 0x0) {
            lIlllIllIllIlII += 2;
            lIlllIllIllIIll >>= 2;
        }
        if ((lIlllIllIllIIll & 0x2) != 0x0) {
            ++lIlllIllIllIlII;
        }
        return lIlllIllIllIlII;
    }
    
    public static void loadLayeredTexture(final LayeredTexture lIllIlIlIlllllI, final IResourceManager lIllIlIllIIllIl, final List lIllIlIlIllllII) {
        int lIllIlIllIIlIll = 0;
        int lIllIlIllIIlIlI = 0;
        int lIllIlIllIIlIIl = 0;
        int[] lIllIlIllIIlIII = null;
        for (final String lIllIlIllIIIllI : lIllIlIlIllllII) {
            if (lIllIlIllIIIllI != null) {
                try {
                    final ResourceLocation lIllIlIllIIIlIl = new ResourceLocation(lIllIlIllIIIllI);
                    final InputStream lIllIlIllIIIlII = lIllIlIllIIllIl.getResource(lIllIlIllIIIlIl).getInputStream();
                    final BufferedImage lIllIlIllIIIIll = ImageIO.read(lIllIlIllIIIlII);
                    if (lIllIlIllIIlIIl == 0) {
                        lIllIlIllIIlIll = lIllIlIllIIIIll.getWidth();
                        lIllIlIllIIlIlI = lIllIlIllIIIIll.getHeight();
                        lIllIlIllIIlIIl = lIllIlIllIIlIll * lIllIlIllIIlIlI;
                        lIllIlIllIIlIII = createAIntImage(lIllIlIllIIlIIl, 0);
                    }
                    final int[] lIllIlIllIIIIlI = getIntArray(lIllIlIllIIlIIl * 3);
                    lIllIlIllIIIIll.getRGB(0, 0, lIllIlIllIIlIll, lIllIlIllIIlIlI, lIllIlIllIIIIlI, 0, lIllIlIllIIlIll);
                    loadNSMap(lIllIlIllIIllIl, lIllIlIllIIIlIl, lIllIlIllIIlIll, lIllIlIllIIlIlI, lIllIlIllIIIIlI);
                    for (int lIllIlIllIIIIIl = 0; lIllIlIllIIIIIl < lIllIlIllIIlIIl; ++lIllIlIllIIIIIl) {
                        final int lIllIlIllIIIIII = lIllIlIllIIIIlI[lIllIlIllIIIIIl] >>> 24 & 0xFF;
                        lIllIlIllIIlIII[lIllIlIllIIlIIl * 0 + lIllIlIllIIIIIl] = blendColor(lIllIlIllIIIIlI[lIllIlIllIIlIIl * 0 + lIllIlIllIIIIIl], lIllIlIllIIlIII[lIllIlIllIIlIIl * 0 + lIllIlIllIIIIIl], lIllIlIllIIIIII);
                        lIllIlIllIIlIII[lIllIlIllIIlIIl * 1 + lIllIlIllIIIIIl] = blendColor(lIllIlIllIIIIlI[lIllIlIllIIlIIl * 1 + lIllIlIllIIIIIl], lIllIlIllIIlIII[lIllIlIllIIlIIl * 1 + lIllIlIllIIIIIl], lIllIlIllIIIIII);
                        lIllIlIllIIlIII[lIllIlIllIIlIIl * 2 + lIllIlIllIIIIIl] = blendColor(lIllIlIllIIIIlI[lIllIlIllIIlIIl * 2 + lIllIlIllIIIIIl], lIllIlIllIIlIII[lIllIlIllIIlIIl * 2 + lIllIlIllIIIIIl], lIllIlIllIIIIII);
                    }
                }
                catch (IOException lIllIlIlIllllll) {
                    lIllIlIlIllllll.printStackTrace();
                }
            }
        }
        setupTexture(lIllIlIlIlllllI.getMultiTexID(), lIllIlIllIIlIII, lIllIlIllIIlIll, lIllIlIllIIlIlI, false, false);
    }
    
    public static void deleteTextures(final AbstractTexture lIlllIllIIIlIlI, final int lIlllIllIIIIllI) {
        final MultiTexID lIlllIllIIIlIII = lIlllIllIIIlIlI.multiTex;
        if (lIlllIllIIIlIII != null) {
            lIlllIllIIIlIlI.multiTex = null;
            ShadersTex.multiTexMap.remove(lIlllIllIIIlIII.base);
            GlStateManager.func_179150_h(lIlllIllIIIlIII.norm);
            GlStateManager.func_179150_h(lIlllIllIIIlIII.spec);
            if (lIlllIllIIIlIII.base != lIlllIllIIIIllI) {
                SMCLog.warning(String.valueOf(new StringBuilder("Error : MultiTexID.base mismatch: ").append(lIlllIllIIIlIII.base).append(", texid: ").append(lIlllIllIIIIllI)));
                GlStateManager.func_179150_h(lIlllIllIIIlIII.base);
            }
        }
    }
    
    public static int[][] prepareAF(final TextureAtlasSprite lIllIlIIlIlllII, final int[][] lIllIlIIlIlIlll, final int lIllIlIIlIllIlI, final int lIllIlIIlIllIIl) {
        final boolean lIllIlIIlIllIII = true;
        return lIllIlIIlIlIlll;
    }
    
    public static int loadSimpleTexture(final int lIllIllIIIIIIll, final BufferedImage lIllIllIIIIIIlI, final boolean lIllIllIIIIIIIl, final boolean lIllIllIIIIIIII, final IResourceManager lIllIlIllllIlII, final ResourceLocation lIllIlIllllIIll, final MultiTexID lIllIlIllllIIlI) {
        final int lIllIlIllllllII = lIllIllIIIIIIlI.getWidth();
        final int lIllIlIlllllIll = lIllIllIIIIIIlI.getHeight();
        final int lIllIlIlllllIlI = lIllIlIllllllII * lIllIlIlllllIll;
        final int[] lIllIlIlllllIIl = getIntArray(lIllIlIlllllIlI * 3);
        lIllIllIIIIIIlI.getRGB(0, 0, lIllIlIllllllII, lIllIlIlllllIll, lIllIlIlllllIIl, 0, lIllIlIllllllII);
        loadNSMap(lIllIlIllllIlII, lIllIlIllllIIll, lIllIlIllllllII, lIllIlIlllllIll, lIllIlIlllllIIl);
        setupTexture(lIllIlIllllIIlI, lIllIlIlllllIIl, lIllIlIllllllII, lIllIlIlllllIll, lIllIllIIIIIIIl, lIllIllIIIIIIII);
        return lIllIllIIIIIIll;
    }
    
    public static void bindTexture(final ITextureObject lIlllIlIllIlIll) {
        final int lIlllIlIllIllII = lIlllIlIllIlIll.getGlTextureId();
        if (lIlllIlIllIlIll instanceof TextureMap) {
            Shaders.atlasSizeX = ((TextureMap)lIlllIlIllIlIll).atlasWidth;
            Shaders.atlasSizeY = ((TextureMap)lIlllIlIllIlIll).atlasHeight;
            bindTextures(lIlllIlIllIlIll.getMultiTexID());
        }
        else {
            Shaders.atlasSizeX = 0;
            Shaders.atlasSizeY = 0;
            bindTextures(lIlllIlIllIlIll.getMultiTexID());
        }
    }
    
    public static IntBuffer fillIntBuffer(final int lIlllIllIlIlIIl, final int lIlllIllIlIlIII) {
        final int[] lIlllIllIlIlIll = getIntArray(lIlllIllIlIlIIl);
        final IntBuffer lIlllIllIlIlIlI = getIntBuffer(lIlllIllIlIlIIl);
        Arrays.fill(ShadersTex.intArray, 0, lIlllIllIlIlIIl, lIlllIllIlIlIII);
        ShadersTex.intBuffer.put(ShadersTex.intArray, 0, lIlllIllIlIlIIl);
        return ShadersTex.intBuffer;
    }
    
    public static String setIconName(final String lIlllIlIIIIIIlI) {
        return ShadersTex.iconName = lIlllIlIIIIIIlI;
    }
    
    public static int[] loadAtlasSprite(final BufferedImage lIllIlIlIIllIII, final int lIllIlIlIIlIlll, final int lIllIlIlIIlIllI, final int lIllIlIlIIlIlIl, final int lIllIlIlIIIllII, final int[] lIllIlIlIIlIIll, final int lIllIlIlIIlIIlI, final int lIllIlIlIIlIIIl) {
        ShadersTex.imageSize = lIllIlIlIIlIlIl * lIllIlIlIIIllII;
        lIllIlIlIIllIII.getRGB(lIllIlIlIIlIlll, lIllIlIlIIlIllI, lIllIlIlIIlIlIl, lIllIlIlIIIllII, lIllIlIlIIlIIll, lIllIlIlIIlIIlI, lIllIlIlIIlIIIl);
        loadNSMap(ShadersTex.resManager, ShadersTex.resLocation, lIllIlIlIIlIlIl, lIllIlIlIIIllII, lIllIlIlIIlIIll);
        return lIllIlIlIIlIIll;
    }
    
    public static int[][] genMipmapsSimple(final int lIlllIIlIIlllIl, final int lIlllIIlIlIIlll, final int[][] lIlllIIlIIllIll) {
        for (int lIlllIIlIlIIlIl = 1; lIlllIIlIlIIlIl <= lIlllIIlIIlllIl; ++lIlllIIlIlIIlIl) {
            if (lIlllIIlIIllIll[lIlllIIlIlIIlIl] == null) {
                final int lIlllIIlIlIIlII = lIlllIIlIlIIlll >> lIlllIIlIlIIlIl;
                final int lIlllIIlIlIIIll = lIlllIIlIlIIlII * 2;
                final int[] lIlllIIlIlIIIlI = lIlllIIlIIllIll[lIlllIIlIlIIlIl - 1];
                final int n = lIlllIIlIlIIlIl;
                final int[] array = new int[lIlllIIlIlIIlII * lIlllIIlIlIIlII];
                lIlllIIlIIllIll[n] = array;
                final int[] lIlllIIlIlIIIIl = array;
                for (int lIlllIIlIlIIIII = 0; lIlllIIlIlIIIII < lIlllIIlIlIIlII; ++lIlllIIlIlIIIII) {
                    for (int lIlllIIlIIlllll = 0; lIlllIIlIIlllll < lIlllIIlIlIIlII; ++lIlllIIlIIlllll) {
                        final int lIlllIIlIIllllI = lIlllIIlIlIIIII * 2 * lIlllIIlIlIIIll + lIlllIIlIIlllll * 2;
                        lIlllIIlIlIIIIl[lIlllIIlIlIIIII * lIlllIIlIlIIlII + lIlllIIlIIlllll] = blend4Simple(lIlllIIlIlIIIlI[lIlllIIlIIllllI], lIlllIIlIlIIIlI[lIlllIIlIIllllI + 1], lIlllIIlIlIIIlI[lIlllIIlIIllllI + lIlllIIlIlIIIll], lIlllIIlIlIIIlI[lIlllIIlIIllllI + lIlllIIlIlIIIll + 1]);
                    }
                }
            }
        }
        return lIlllIIlIIllIll;
    }
}
