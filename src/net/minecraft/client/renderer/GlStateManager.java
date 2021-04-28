package net.minecraft.client.renderer;

import org.lwjgl.opengl.*;
import java.nio.*;
import optifine.*;

public class GlStateManager
{
    private static /* synthetic */ BooleanState rescaleNormalState;
    private static /* synthetic */ ColorLogicState colorLogicState;
    private static /* synthetic */ StencilState stencilState;
    private static /* synthetic */ Color colorState;
    private static /* synthetic */ ClearState clearState;
    private static /* synthetic */ PolygonOffsetState polygonOffsetState;
    private static /* synthetic */ ColorMaterialState colorMaterialState;
    private static /* synthetic */ BooleanState normalizeState;
    private static /* synthetic */ BooleanState lightingState;
    public static /* synthetic */ boolean clearEnabled;
    private static /* synthetic */ FogState fogState;
    private static /* synthetic */ ColorMask colorMaskState;
    private static /* synthetic */ DepthState depthState;
    private static /* synthetic */ int field_179173_q;
    private static /* synthetic */ TextureState[] field_179174_p;
    private static /* synthetic */ BlendState blendState;
    private static /* synthetic */ Viewport field_179169_u;
    private static /* synthetic */ int field_179162_o;
    private static /* synthetic */ CullState cullState;
    private static /* synthetic */ TexGenState texGenState;
    private static /* synthetic */ AlphaState alphaState;
    private static /* synthetic */ BooleanState[] field_179159_c;
    
    public static void shadeModel(final int llllllllllllllIlllllIIIlIIIIlllI) {
        if (llllllllllllllIlllllIIIlIIIIlllI != GlStateManager.field_179173_q) {
            GL11.glShadeModel(GlStateManager.field_179173_q = llllllllllllllIlllllIIIlIIIIlllI);
        }
    }
    
    public static int getActiveTextureUnit() {
        return OpenGlHelper.defaultTexUnit + GlStateManager.field_179162_o;
    }
    
    public static void enableAlpha() {
        GlStateManager.alphaState.field_179208_a.setEnabled();
    }
    
    public static void ortho(final double llllllllllllllIlllllIIIIllIIllIl, final double llllllllllllllIlllllIIIIllIlIIlI, final double llllllllllllllIlllllIIIIllIIlIll, final double llllllllllllllIlllllIIIIllIIlIlI, final double llllllllllllllIlllllIIIIllIIlIIl, final double llllllllllllllIlllllIIIIllIIlIII) {
        GL11.glOrtho(llllllllllllllIlllllIIIIllIIllIl, llllllllllllllIlllllIIIIllIlIIlI, llllllllllllllIlllllIIIIllIIlIll, llllllllllllllIlllllIIIIllIIlIlI, llllllllllllllIlllllIIIIllIIlIIl, llllllllllllllIlllllIIIIllIIlIII);
    }
    
    public static void enableFog() {
        GlStateManager.fogState.field_179049_a.setEnabled();
    }
    
    public static void clearDepth(final double llllllllllllllIlllllIIIIllllIIlI) {
        if (llllllllllllllIlllllIIIIllllIIlI != GlStateManager.clearState.field_179205_a) {
            GlStateManager.clearState.field_179205_a = llllllllllllllIlllllIIIIllllIIlI;
            GL11.glClearDepth(llllllllllllllIlllllIIIIllllIIlI);
        }
    }
    
    public static void disableDepth() {
        GlStateManager.depthState.field_179052_a.setDisabled();
    }
    
    public static void viewport(final int llllllllllllllIlllllIIIlIIIIIlII, final int llllllllllllllIlllllIIIlIIIIIlll, final int llllllllllllllIlllllIIIlIIIIIllI, final int llllllllllllllIlllllIIIlIIIIIIIl) {
        if (llllllllllllllIlllllIIIlIIIIIlII != GlStateManager.field_179169_u.field_179058_a || llllllllllllllIlllllIIIlIIIIIlll != GlStateManager.field_179169_u.field_179056_b || llllllllllllllIlllllIIIlIIIIIllI != GlStateManager.field_179169_u.field_179057_c || llllllllllllllIlllllIIIlIIIIIIIl != GlStateManager.field_179169_u.field_179055_d) {
            GlStateManager.field_179169_u.field_179058_a = llllllllllllllIlllllIIIlIIIIIlII;
            GlStateManager.field_179169_u.field_179056_b = llllllllllllllIlllllIIIlIIIIIlll;
            GlStateManager.field_179169_u.field_179057_c = llllllllllllllIlllllIIIlIIIIIllI;
            GlStateManager.field_179169_u.field_179055_d = llllllllllllllIlllllIIIlIIIIIIIl;
            GL11.glViewport(llllllllllllllIlllllIIIlIIIIIlII, llllllllllllllIlllllIIIlIIIIIlll, llllllllllllllIlllllIIIlIIIIIllI, llllllllllllllIlllllIIIlIIIIIIIl);
        }
    }
    
    public static void translate(final float llllllllllllllIlllllIIIIlIlIIIll, final float llllllllllllllIlllllIIIIlIlIIlIl, final float llllllllllllllIlllllIIIIlIlIIlII) {
        GL11.glTranslatef(llllllllllllllIlllllIIIIlIlIIIll, llllllllllllllIlllllIIIIlIlIIlIl, llllllllllllllIlllllIIIIlIlIIlII);
    }
    
    public static void disableColorLogic() {
        GlStateManager.colorLogicState.field_179197_a.setDisabled();
    }
    
    public static void pushAttrib() {
        GL11.glPushAttrib(8256);
    }
    
    public static void clear(final int llllllllllllllIlllllIIIIlllIIIll) {
        if (GlStateManager.clearEnabled) {
            GL11.glClear(llllllllllllllIlllllIIIIlllIIIll);
        }
    }
    
    public static void enableRescaleNormal() {
        GlStateManager.rescaleNormalState.setEnabled();
    }
    
    public static void scale(final float llllllllllllllIlllllIIIIlIllIlIl, final float llllllllllllllIlllllIIIIlIllIlll, final float llllllllllllllIlllllIIIIlIllIllI) {
        GL11.glScalef(llllllllllllllIlllllIIIIlIllIlIl, llllllllllllllIlllllIIIIlIllIlll, llllllllllllllIlllllIIIIlIllIllI);
    }
    
    public static void enableColorLogic() {
        GlStateManager.colorLogicState.field_179197_a.setEnabled();
    }
    
    public static void translate(final double llllllllllllllIlllllIIIIlIIlllIl, final double llllllllllllllIlllllIIIIlIIllIIl, final double llllllllllllllIlllllIIIIlIIllIll) {
        GL11.glTranslated(llllllllllllllIlllllIIIIlIIlllIl, llllllllllllllIlllllIIIIlIIllIIl, llllllllllllllIlllllIIIIlIIllIll);
    }
    
    public static void callList(final int llllllllllllllIlllllIIIIIlllllIl) {
        GL11.glCallList(llllllllllllllIlllllIIIIIlllllIl);
    }
    
    public static void setFogDensity(final float llllllllllllllIlllllIIIllIIIlllI) {
        if (llllllllllllllIlllllIIIllIIIlllI != GlStateManager.fogState.field_179048_c) {
            GlStateManager.fogState.field_179048_c = llllllllllllllIlllllIIIllIIIlllI;
            GL11.glFogf(2914, llllllllllllllIlllllIIIllIIIlllI);
        }
    }
    
    public static void disableLighting() {
        GlStateManager.lightingState.setDisabled();
    }
    
    public static void disableBooleanStateAt(final int llllllllllllllIlllllIIIlllIlIlll) {
        GlStateManager.field_179159_c[llllllllllllllIlllllIIIlllIlIlll].setDisabled();
    }
    
    public static void func_179098_w() {
        GlStateManager.field_179174_p[GlStateManager.field_179162_o].field_179060_a.setEnabled();
    }
    
    public static void texGen(final TexGen llllllllllllllIlllllIIIlIlIIlllI, final int llllllllllllllIlllllIIIlIlIIllII) {
        final TexGenCoord llllllllllllllIlllllIIIlIlIIlIlI = texGenCoord(llllllllllllllIlllllIIIlIlIIlllI);
        if (llllllllllllllIlllllIIIlIlIIllII != llllllllllllllIlllllIIIlIlIIlIlI.field_179066_c) {
            llllllllllllllIlllllIIIlIlIIlIlI.field_179066_c = llllllllllllllIlllllIIIlIlIIllII;
            GL11.glTexGeni(llllllllllllllIlllllIIIlIlIIlIlI.field_179065_b, 9472, llllllllllllllIlllllIIIlIlIIllII);
        }
    }
    
    public static void color(final float llllllllllllllIlllllIIIIlIIIllII, final float llllllllllllllIlllllIIIIlIIIlIll, final float llllllllllllllIlllllIIIIlIIIlIlI, final float llllllllllllllIlllllIIIIlIIIllIl) {
        if (llllllllllllllIlllllIIIIlIIIllII != GlStateManager.colorState.field_179195_a || llllllllllllllIlllllIIIIlIIIlIll != GlStateManager.colorState.green || llllllllllllllIlllllIIIIlIIIlIlI != GlStateManager.colorState.blue || llllllllllllllIlllllIIIIlIIIllIl != GlStateManager.colorState.alpha) {
            GlStateManager.colorState.field_179195_a = llllllllllllllIlllllIIIIlIIIllII;
            GlStateManager.colorState.green = llllllllllllllIlllllIIIIlIIIlIll;
            GlStateManager.colorState.blue = llllllllllllllIlllllIIIIlIIIlIlI;
            GlStateManager.colorState.alpha = llllllllllllllIlllllIIIIlIIIllIl;
            GL11.glColor4f(llllllllllllllIlllllIIIIlIIIllII, llllllllllllllIlllllIIIIlIIIlIll, llllllllllllllIlllllIIIIlIIIlIlI, llllllllllllllIlllllIIIIlIIIllIl);
        }
    }
    
    public static void func_179105_a(final TexGen llllllllllllllIlllllIIIlIIllllll, final int llllllllllllllIlllllIIIlIIlllllI, final FloatBuffer llllllllllllllIlllllIIIlIIllllIl) {
        GL11.glTexGen(texGenCoord(llllllllllllllIlllllIIIlIIllllll).field_179065_b, llllllllllllllIlllllIIIlIIlllllI, llllllllllllllIlllllIIIlIIllllIl);
    }
    
    public static void disableRescaleNormal() {
        GlStateManager.rescaleNormalState.setDisabled();
    }
    
    public static void deleteTextures(final IntBuffer llllllllllllllIlllllIIIIIllIlllI) {
        llllllllllllllIlllllIIIIIllIlllI.rewind();
        while (llllllllllllllIlllllIIIIIllIlllI.position() < llllllllllllllIlllllIIIIIllIlllI.limit()) {
            final int llllllllllllllIlllllIIIIIllIllIl = llllllllllllllIlllllIIIIIllIlllI.get();
            func_179150_h(llllllllllllllIlllllIIIIIllIllIl);
        }
        llllllllllllllIlllllIIIIIllIlllI.rewind();
    }
    
    public static void disableTexGenCoord(final TexGen llllllllllllllIlllllIIIlIlIllIII) {
        texGenCoord(llllllllllllllIlllllIIIlIlIllIII).field_179067_a.setDisabled();
    }
    
    public static void enableDepth() {
        GlStateManager.depthState.field_179052_a.setEnabled();
    }
    
    public static void enablePolygonOffset() {
        GlStateManager.polygonOffsetState.field_179044_a.setEnabled();
    }
    
    public static void loadIdentity() {
        GL11.glLoadIdentity();
    }
    
    public static void disableColorMaterial() {
        GlStateManager.colorMaterialState.field_179191_a.setDisabled();
    }
    
    public static void bindCurrentTexture() {
        GL11.glBindTexture(3553, GlStateManager.field_179174_p[GlStateManager.field_179162_o].field_179059_b);
    }
    
    public static void enableColorMaterial() {
        GlStateManager.colorMaterialState.field_179191_a.setEnabled();
    }
    
    private static TexGenCoord texGenCoord(final TexGen llllllllllllllIlllllIIIlIIllIIII) {
        switch (SwitchTexGen.field_179175_a[llllllllllllllIlllllIIIlIIllIIII.ordinal()]) {
            case 1: {
                return GlStateManager.texGenState.field_179064_a;
            }
            case 2: {
                return GlStateManager.texGenState.field_179062_b;
            }
            case 3: {
                return GlStateManager.texGenState.field_179063_c;
            }
            case 4: {
                return GlStateManager.texGenState.field_179061_d;
            }
            default: {
                return GlStateManager.texGenState.field_179064_a;
            }
        }
    }
    
    public static void disableAlpha() {
        GlStateManager.alphaState.field_179208_a.setDisabled();
    }
    
    static {
        __OBFID = "CL_00002558";
        GlStateManager.alphaState = new AlphaState(null);
        GlStateManager.lightingState = new BooleanState(2896);
        GlStateManager.field_179159_c = new BooleanState[8];
        GlStateManager.colorMaterialState = new ColorMaterialState(null);
        GlStateManager.blendState = new BlendState(null);
        GlStateManager.depthState = new DepthState(null);
        GlStateManager.fogState = new FogState(null);
        GlStateManager.cullState = new CullState(null);
        GlStateManager.polygonOffsetState = new PolygonOffsetState(null);
        GlStateManager.colorLogicState = new ColorLogicState(null);
        GlStateManager.texGenState = new TexGenState(null);
        GlStateManager.clearState = new ClearState(null);
        GlStateManager.stencilState = new StencilState(null);
        GlStateManager.normalizeState = new BooleanState(2977);
        GlStateManager.field_179162_o = 0;
        GlStateManager.field_179174_p = new TextureState[32];
        GlStateManager.field_179173_q = 7425;
        GlStateManager.rescaleNormalState = new BooleanState(32826);
        GlStateManager.colorMaskState = new ColorMask(null);
        GlStateManager.colorState = new Color();
        GlStateManager.field_179169_u = new Viewport(null);
        GlStateManager.clearEnabled = true;
        for (int llllllllllllllIlllllIIIllllllIll = 0; llllllllllllllIlllllIIIllllllIll < 8; ++llllllllllllllIlllllIIIllllllIll) {
            GlStateManager.field_179159_c[llllllllllllllIlllllIIIllllllIll] = new BooleanState(16384 + llllllllllllllIlllllIIIllllllIll);
        }
        for (int llllllllllllllIlllllIIIllllllIll = 0; llllllllllllllIlllllIIIllllllIll < GlStateManager.field_179174_p.length; ++llllllllllllllIlllllIIIllllllIll) {
            GlStateManager.field_179174_p[llllllllllllllIlllllIIIllllllIll] = new TextureState(null);
        }
    }
    
    public static void func_179144_i(final int llllllllllllllIlllllIIIlIIIlIIIl) {
        if (llllllllllllllIlllllIIIlIIIlIIIl != GlStateManager.field_179174_p[GlStateManager.field_179162_o].field_179059_b) {
            GlStateManager.field_179174_p[GlStateManager.field_179162_o].field_179059_b = llllllllllllllIlllllIIIlIIIlIIIl;
            GL11.glBindTexture(3553, llllllllllllllIlllllIIIlIIIlIIIl);
        }
    }
    
    public static void colorMaterial(final int llllllllllllllIlllllIIIlllIIIlll, final int llllllllllllllIlllllIIIlllIIlIIl) {
        if (llllllllllllllIlllllIIIlllIIIlll != GlStateManager.colorMaterialState.field_179189_b || llllllllllllllIlllllIIIlllIIlIIl != GlStateManager.colorMaterialState.field_179190_c) {
            GlStateManager.colorMaterialState.field_179189_b = llllllllllllllIlllllIIIlllIIIlll;
            GlStateManager.colorMaterialState.field_179190_c = llllllllllllllIlllllIIIlllIIlIIl;
            GL11.glColorMaterial(llllllllllllllIlllllIIIlllIIIlll, llllllllllllllIlllllIIIlllIIlIIl);
        }
    }
    
    public static void tryBlendFuncSeparate(final int llllllllllllllIlllllIIIllIlIIIII, final int llllllllllllllIlllllIIIllIIllIll, final int llllllllllllllIlllllIIIllIIllIlI, final int llllllllllllllIlllllIIIllIIllIIl) {
        if (llllllllllllllIlllllIIIllIlIIIII != GlStateManager.blendState.field_179211_b || llllllllllllllIlllllIIIllIIllIll != GlStateManager.blendState.field_179212_c || llllllllllllllIlllllIIIllIIllIlI != GlStateManager.blendState.field_179209_d || llllllllllllllIlllllIIIllIIllIIl != GlStateManager.blendState.field_179210_e) {
            GlStateManager.blendState.field_179211_b = llllllllllllllIlllllIIIllIlIIIII;
            GlStateManager.blendState.field_179212_c = llllllllllllllIlllllIIIllIIllIll;
            GlStateManager.blendState.field_179209_d = llllllllllllllIlllllIIIllIIllIlI;
            GlStateManager.blendState.field_179210_e = llllllllllllllIlllllIIIllIIllIIl;
            OpenGlHelper.glBlendFunc(llllllllllllllIlllllIIIllIlIIIII, llllllllllllllIlllllIIIllIIllIll, llllllllllllllIlllllIIIllIIllIlI, llllllllllllllIlllllIIIllIIllIIl);
        }
    }
    
    public static void setFogEnd(final float llllllllllllllIlllllIIIllIIIIIIl) {
        if (llllllllllllllIlllllIIIllIIIIIIl != GlStateManager.fogState.field_179046_e) {
            GlStateManager.fogState.field_179046_e = llllllllllllllIlllllIIIllIIIIIIl;
            GL11.glFogf(2916, llllllllllllllIlllllIIIllIIIIIIl);
        }
    }
    
    public static void depthFunc(final int llllllllllllllIlllllIIIlllIIIIIl) {
        if (llllllllllllllIlllllIIIlllIIIIIl != GlStateManager.depthState.field_179051_c) {
            GlStateManager.depthState.field_179051_c = llllllllllllllIlllllIIIlllIIIIIl;
            GL11.glDepthFunc(llllllllllllllIlllllIIIlllIIIIIl);
        }
    }
    
    public static int func_179146_y() {
        return GL11.glGenTextures();
    }
    
    public static void matrixMode(final int llllllllllllllIlllllIIIIlllIIIII) {
        GL11.glMatrixMode(llllllllllllllIlllllIIIIlllIIIII);
    }
    
    public static void enableBlend() {
        GlStateManager.blendState.field_179213_a.setEnabled();
    }
    
    public static void enableNormalize() {
        GlStateManager.normalizeState.setEnabled();
    }
    
    public static void pushMatrix() {
        GL11.glPushMatrix();
    }
    
    public static void disableCull() {
        GlStateManager.cullState.field_179054_a.setDisabled();
    }
    
    public static void disablePolygonOffset() {
        GlStateManager.polygonOffsetState.field_179044_a.setDisabled();
    }
    
    public static void disableBlend() {
        GlStateManager.blendState.field_179213_a.setDisabled();
    }
    
    public static void rotate(final float llllllllllllllIlllllIIIIlIllllll, final float llllllllllllllIlllllIIIIllIIIIlI, final float llllllllllllllIlllllIIIIlIllllIl, final float llllllllllllllIlllllIIIIllIIIIII) {
        GL11.glRotatef(llllllllllllllIlllllIIIIlIllllll, llllllllllllllIlllllIIIIllIIIIlI, llllllllllllllIlllllIIIIlIllllIl, llllllllllllllIlllllIIIIllIIIIII);
    }
    
    public static void setActiveTexture(final int llllllllllllllIlllllIIIlIIlIlIlI) {
        if (GlStateManager.field_179162_o != llllllllllllllIlllllIIIlIIlIlIlI - OpenGlHelper.defaultTexUnit) {
            GlStateManager.field_179162_o = llllllllllllllIlllllIIIlIIlIlIlI - OpenGlHelper.defaultTexUnit;
            OpenGlHelper.setActiveTexture(llllllllllllllIlllllIIIlIIlIlIlI);
        }
    }
    
    public static void color(final float llllllllllllllIlllllIIIIlIIIIlIl, final float llllllllllllllIlllllIIIIlIIIIIIl, final float llllllllllllllIlllllIIIIlIIIIIll) {
        color(llllllllllllllIlllllIIIIlIIIIlIl, llllllllllllllIlllllIIIIlIIIIIIl, llllllllllllllIlllllIIIIlIIIIIll, 1.0f);
    }
    
    public static void enableTexGenCoord(final TexGen llllllllllllllIlllllIIIlIlIllIll) {
        texGenCoord(llllllllllllllIlllllIIIlIlIllIll).field_179067_a.setEnabled();
    }
    
    public static void doPolygonOffset(final float llllllllllllllIlllllIIIlIlllIIII, final float llllllllllllllIlllllIIIlIllIlllI) {
        if (llllllllllllllIlllllIIIlIlllIIII != GlStateManager.polygonOffsetState.field_179043_c || llllllllllllllIlllllIIIlIllIlllI != GlStateManager.polygonOffsetState.field_179041_d) {
            GlStateManager.polygonOffsetState.field_179043_c = llllllllllllllIlllllIIIlIlllIIII;
            GlStateManager.polygonOffsetState.field_179041_d = llllllllllllllIlllllIIIlIllIlllI;
            GL11.glPolygonOffset(llllllllllllllIlllllIIIlIlllIIII, llllllllllllllIlllllIIIlIllIlllI);
        }
    }
    
    public static void disableFog() {
        GlStateManager.fogState.field_179049_a.setDisabled();
    }
    
    public static void colorMask(final boolean llllllllllllllIlllllIIIIlllllIII, final boolean llllllllllllllIlllllIIIIlllllIll, final boolean llllllllllllllIlllllIIIIlllllIlI, final boolean llllllllllllllIlllllIIIIllllIlIl) {
        if (llllllllllllllIlllllIIIIlllllIII != GlStateManager.colorMaskState.field_179188_a || llllllllllllllIlllllIIIIlllllIll != GlStateManager.colorMaskState.field_179186_b || llllllllllllllIlllllIIIIlllllIlI != GlStateManager.colorMaskState.field_179187_c || llllllllllllllIlllllIIIIllllIlIl != GlStateManager.colorMaskState.field_179185_d) {
            GlStateManager.colorMaskState.field_179188_a = llllllllllllllIlllllIIIIlllllIII;
            GlStateManager.colorMaskState.field_179186_b = llllllllllllllIlllllIIIIlllllIll;
            GlStateManager.colorMaskState.field_179187_c = llllllllllllllIlllllIIIIlllllIlI;
            GlStateManager.colorMaskState.field_179185_d = llllllllllllllIlllllIIIIllllIlIl;
            GL11.glColorMask(llllllllllllllIlllllIIIIlllllIII, llllllllllllllIlllllIIIIlllllIll, llllllllllllllIlllllIIIIlllllIlI, llllllllllllllIlllllIIIIllllIlIl);
        }
    }
    
    public static int getBoundTexture() {
        return GlStateManager.field_179174_p[GlStateManager.field_179162_o].field_179059_b;
    }
    
    public static void popAttrib() {
        GL11.glPopAttrib();
    }
    
    public static void enableBooleanStateAt(final int llllllllllllllIlllllIIIlllIllIlI) {
        GlStateManager.field_179159_c[llllllllllllllIlllllIIIlllIllIlI].setEnabled();
    }
    
    public static void popMatrix() {
        GL11.glPopMatrix();
    }
    
    public static void alphaFunc(final int llllllllllllllIlllllIIIllllIIlIl, final float llllllllllllllIlllllIIIllllIIIlI) {
        if (llllllllllllllIlllllIIIllllIIlIl != GlStateManager.alphaState.field_179206_b || llllllllllllllIlllllIIIllllIIIlI != GlStateManager.alphaState.field_179207_c) {
            GlStateManager.alphaState.field_179206_b = llllllllllllllIlllllIIIllllIIlIl;
            GlStateManager.alphaState.field_179207_c = llllllllllllllIlllllIIIllllIIIlI;
            GL11.glAlphaFunc(llllllllllllllIlllllIIIllllIIlIl, llllllllllllllIlllllIIIllllIIIlI);
        }
    }
    
    public static void checkBoundTexture() {
        if (Config.isMinecraftThread()) {
            final int llllllllllllllIlllllIIIIIllllIII = GL11.glGetInteger(34016);
            final int llllllllllllllIlllllIIIIIlllIlll = GL11.glGetInteger(32873);
            final int llllllllllllllIlllllIIIIIlllIllI = getActiveTextureUnit();
            final int llllllllllllllIlllllIIIIIlllIlIl = getBoundTexture();
            if (llllllllllllllIlllllIIIIIlllIlIl > 0 && (llllllllllllllIlllllIIIIIllllIII != llllllllllllllIlllllIIIIIlllIllI || llllllllllllllIlllllIIIIIlllIlll != llllllllllllllIlllllIIIIIlllIlIl)) {
                Config.dbg(String.valueOf(new StringBuilder("checkTexture: act: ").append(llllllllllllllIlllllIIIIIlllIllI).append(", glAct: ").append(llllllllllllllIlllllIIIIIllllIII).append(", tex: ").append(llllllllllllllIlllllIIIIIlllIlIl).append(", glTex: ").append(llllllllllllllIlllllIIIIIlllIlll)));
            }
        }
    }
    
    public static void setFog(final int llllllllllllllIlllllIIIllIIlIllI) {
        if (llllllllllllllIlllllIIIllIIlIllI != GlStateManager.fogState.field_179047_b) {
            GlStateManager.fogState.field_179047_b = llllllllllllllIlllllIIIllIIlIllI;
            GL11.glFogi(2917, llllllllllllllIlllllIIIllIIlIllI);
        }
    }
    
    public static void multMatrix(final FloatBuffer llllllllllllllIlllllIIIIlIIlIlIl) {
        GL11.glMultMatrix(llllllllllllllIlllllIIIIlIIlIlIl);
    }
    
    public static void enableLighting() {
        GlStateManager.lightingState.setEnabled();
    }
    
    public static void scale(final double llllllllllllllIlllllIIIIlIlIllll, final double llllllllllllllIlllllIIIIlIlIlIll, final double llllllllllllllIlllllIIIIlIlIllIl) {
        GL11.glScaled(llllllllllllllIlllllIIIIlIlIllll, llllllllllllllIlllllIIIIlIlIlIll, llllllllllllllIlllllIIIIlIlIllIl);
    }
    
    public static void func_179117_G() {
        final Color colorState = GlStateManager.colorState;
        final Color colorState2 = GlStateManager.colorState;
        final Color colorState3 = GlStateManager.colorState;
        final Color colorState4 = GlStateManager.colorState;
        final float n = -1.0f;
        colorState4.alpha = n;
        colorState3.blue = n;
        colorState2.green = n;
        colorState.field_179195_a = n;
    }
    
    public static void func_179090_x() {
        GlStateManager.field_179174_p[GlStateManager.field_179162_o].field_179060_a.setDisabled();
    }
    
    public static void disableNormalize() {
        GlStateManager.normalizeState.setDisabled();
    }
    
    public static void getFloat(final int llllllllllllllIlllllIIIIllIllIll, final FloatBuffer llllllllllllllIlllllIIIIllIlllII) {
        GL11.glGetFloat(llllllllllllllIlllllIIIIllIllIll, llllllllllllllIlllllIIIIllIlllII);
    }
    
    public static void blendFunc(final int llllllllllllllIlllllIIIllIlIlllI, final int llllllllllllllIlllllIIIllIlIllII) {
        if (llllllllllllllIlllllIIIllIlIlllI != GlStateManager.blendState.field_179211_b || llllllllllllllIlllllIIIllIlIllII != GlStateManager.blendState.field_179212_c) {
            GlStateManager.blendState.field_179211_b = llllllllllllllIlllllIIIllIlIlllI;
            GlStateManager.blendState.field_179212_c = llllllllllllllIlllllIIIllIlIllII;
            GL11.glBlendFunc(llllllllllllllIlllllIIIllIlIlllI, llllllllllllllIlllllIIIllIlIllII);
        }
    }
    
    public static void depthMask(final boolean llllllllllllllIlllllIIIllIllIlll) {
        if (llllllllllllllIlllllIIIllIllIlll != GlStateManager.depthState.field_179050_b) {
            GlStateManager.depthState.field_179050_b = llllllllllllllIlllllIIIllIllIlll;
            GL11.glDepthMask(llllllllllllllIlllllIIIllIllIlll);
        }
    }
    
    public static void colorLogicOp(final int llllllllllllllIlllllIIIlIllIIlIl) {
        if (llllllllllllllIlllllIIIlIllIIlIl != GlStateManager.colorLogicState.field_179196_b) {
            GlStateManager.colorLogicState.field_179196_b = llllllllllllllIlllllIIIlIllIIlIl;
            GL11.glLogicOp(llllllllllllllIlllllIIIlIllIIlIl);
        }
    }
    
    public static void setFogStart(final float llllllllllllllIlllllIIIllIIIIllI) {
        if (llllllllllllllIlllllIIIllIIIIllI != GlStateManager.fogState.field_179045_d) {
            GlStateManager.fogState.field_179045_d = llllllllllllllIlllllIIIllIIIIllI;
            GL11.glFogf(2915, llllllllllllllIlllllIIIllIIIIllI);
        }
    }
    
    public static void cullFace(final int llllllllllllllIlllllIIIlIlllllll) {
        if (llllllllllllllIlllllIIIlIlllllll != GlStateManager.cullState.field_179053_b) {
            GlStateManager.cullState.field_179053_b = llllllllllllllIlllllIIIlIlllllll;
            GL11.glCullFace(llllllllllllllIlllllIIIlIlllllll);
        }
    }
    
    public static void clearColor(final float llllllllllllllIlllllIIIIlllIlIIl, final float llllllllllllllIlllllIIIIlllIlIII, final float llllllllllllllIlllllIIIIlllIlIll, final float llllllllllllllIlllllIIIIlllIIllI) {
        if (llllllllllllllIlllllIIIIlllIlIIl != GlStateManager.clearState.field_179203_b.field_179195_a || llllllllllllllIlllllIIIIlllIlIII != GlStateManager.clearState.field_179203_b.green || llllllllllllllIlllllIIIIlllIlIll != GlStateManager.clearState.field_179203_b.blue || llllllllllllllIlllllIIIIlllIIllI != GlStateManager.clearState.field_179203_b.alpha) {
            GlStateManager.clearState.field_179203_b.field_179195_a = llllllllllllllIlllllIIIIlllIlIIl;
            GlStateManager.clearState.field_179203_b.green = llllllllllllllIlllllIIIIlllIlIII;
            GlStateManager.clearState.field_179203_b.blue = llllllllllllllIlllllIIIIlllIlIll;
            GlStateManager.clearState.field_179203_b.alpha = llllllllllllllIlllllIIIIlllIIllI;
            GL11.glClearColor(llllllllllllllIlllllIIIIlllIlIIl, llllllllllllllIlllllIIIIlllIlIII, llllllllllllllIlllllIIIIlllIlIll, llllllllllllllIlllllIIIIlllIIllI);
        }
    }
    
    public static void func_179150_h(final int llllllllllllllIlllllIIIlIIIlllII) {
        if (llllllllllllllIlllllIIIlIIIlllII != 0) {
            GL11.glDeleteTextures(llllllllllllllIlllllIIIlIIIlllII);
            for (final TextureState llllllllllllllIlllllIIIlIIIllIII : GlStateManager.field_179174_p) {
                if (llllllllllllllIlllllIIIlIIIllIII.field_179059_b == llllllllllllllIlllllIIIlIIIlllII) {
                    llllllllllllllIlllllIIIlIIIllIII.field_179059_b = 0;
                }
            }
        }
    }
    
    public static void enableCull() {
        GlStateManager.cullState.field_179054_a.setEnabled();
    }
    
    static class PolygonOffsetState
    {
        public /* synthetic */ float field_179041_d;
        public /* synthetic */ float field_179043_c;
        public /* synthetic */ BooleanState field_179044_a;
        public /* synthetic */ BooleanState field_179042_b;
        
        PolygonOffsetState(final SwitchTexGen lllllllllllllllIlIIllIlllllllIll) {
            this();
        }
        
        private PolygonOffsetState() {
            this.field_179044_a = new BooleanState(32823);
            this.field_179042_b = new BooleanState(10754);
            this.field_179043_c = 0.0f;
            this.field_179041_d = 0.0f;
        }
    }
    
    static final class SwitchTexGen
    {
        static final /* synthetic */ int[] field_179175_a;
        
        static {
            field_179175_a = new int[TexGen.values().length];
            try {
                SwitchTexGen.field_179175_a[TexGen.S.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchTexGen.field_179175_a[TexGen.T.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchTexGen.field_179175_a[TexGen.R.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchTexGen.field_179175_a[TexGen.Q.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
    
    public enum TexGen
    {
        S("S", 0, "S", 0, "S", 0), 
        R("R", 2, "R", 2, "R", 2), 
        T("T", 1, "T", 1, "T", 1), 
        Q("Q", 3, "Q", 3, "Q", 3);
        
        private TexGen(final String llllllllllllllllIllIIlIlIIllllII, final int llllllllllllllllIllIIlIlIIlllIll, final String llllllllllllllllIllIIlIlIlIIIIIl, final int llllllllllllllllIllIIlIlIlIIIIII, final String llllllllllllllllIllIIlIlIIllllll, final int llllllllllllllllIllIIlIlIIlllllI) {
        }
        
        static {
            __OBFID = "CL_00002542";
        }
    }
    
    static class BooleanState
    {
        private final /* synthetic */ int capability;
        private /* synthetic */ boolean currentState;
        
        public void setDisabled() {
            this.setState(false);
        }
        
        public void setEnabled() {
            this.setState(true);
        }
        
        public BooleanState(final int llllllllllllllIIllIIIIIIllllIIIl) {
            this.currentState = false;
            this.capability = llllllllllllllIIllIIIIIIllllIIIl;
        }
        
        public void setState(final boolean llllllllllllllIIllIIIIIIlllIIIll) {
            if (llllllllllllllIIllIIIIIIlllIIIll != this.currentState) {
                this.currentState = llllllllllllllIIllIIIIIIlllIIIll;
                if (llllllllllllllIIllIIIIIIlllIIIll) {
                    GL11.glEnable(this.capability);
                }
                else {
                    GL11.glDisable(this.capability);
                }
            }
        }
    }
    
    static class DepthState
    {
        public /* synthetic */ int field_179051_c;
        public /* synthetic */ boolean field_179050_b;
        public /* synthetic */ BooleanState field_179052_a;
        
        DepthState(final SwitchTexGen llllllllllllllllIIllIIlIIIIlIIIl) {
            this();
        }
        
        private DepthState() {
            this.field_179052_a = new BooleanState(2929);
            this.field_179050_b = true;
            this.field_179051_c = 513;
        }
    }
    
    static class AlphaState
    {
        public /* synthetic */ float field_179207_c;
        public /* synthetic */ BooleanState field_179208_a;
        public /* synthetic */ int field_179206_b;
        
        static {
            __OBFID = "CL_00002556";
        }
        
        AlphaState(final SwitchTexGen llllllllllllllIllIIllIlIIIIIIIII) {
            this();
        }
        
        private AlphaState() {
            this.field_179208_a = new BooleanState(3008);
            this.field_179206_b = 519;
            this.field_179207_c = -1.0f;
        }
    }
    
    static class ColorMaterialState
    {
        public /* synthetic */ BooleanState field_179191_a;
        public /* synthetic */ int field_179189_b;
        public /* synthetic */ int field_179190_c;
        
        ColorMaterialState(final SwitchTexGen llllllllllllllllllllllIIIlIlIIII) {
            this();
        }
        
        private ColorMaterialState() {
            this.field_179191_a = new BooleanState(2903);
            this.field_179189_b = 1032;
            this.field_179190_c = 5634;
        }
    }
    
    static class ColorLogicState
    {
        public /* synthetic */ int field_179196_b;
        public /* synthetic */ BooleanState field_179197_a;
        
        ColorLogicState(final SwitchTexGen llllllllllllllIIIIIlIIIllIlIllII) {
            this();
        }
        
        private ColorLogicState() {
            this.field_179197_a = new BooleanState(3058);
            this.field_179196_b = 5379;
        }
    }
    
    static class TexGenState
    {
        public /* synthetic */ TexGenCoord field_179063_c;
        public /* synthetic */ TexGenCoord field_179061_d;
        public /* synthetic */ TexGenCoord field_179062_b;
        public /* synthetic */ TexGenCoord field_179064_a;
        
        private TexGenState() {
            this.field_179064_a = new TexGenCoord(8192, 3168);
            this.field_179062_b = new TexGenCoord(8193, 3169);
            this.field_179063_c = new TexGenCoord(8194, 3170);
            this.field_179061_d = new TexGenCoord(8195, 3171);
        }
        
        TexGenState(final SwitchTexGen llllllllllllllIIIIlIllIIIIlIIlII) {
            this();
        }
    }
    
    static class TexGenCoord
    {
        public /* synthetic */ int field_179066_c;
        public /* synthetic */ int field_179065_b;
        public /* synthetic */ BooleanState field_179067_a;
        
        public TexGenCoord(final int lllllllllllllllllllIllIlllIIlIII, final int lllllllllllllllllllIllIlllIIIlll) {
            this.field_179066_c = -1;
            this.field_179065_b = lllllllllllllllllllIllIlllIIlIII;
            this.field_179067_a = new BooleanState(lllllllllllllllllllIllIlllIIIlll);
        }
    }
    
    static class TextureState
    {
        public /* synthetic */ BooleanState field_179060_a;
        public /* synthetic */ int field_179059_b;
        
        TextureState(final SwitchTexGen llllllllllllllIlIIIlllIIllllIlII) {
            this();
        }
        
        private TextureState() {
            this.field_179060_a = new BooleanState(3553);
            this.field_179059_b = 0;
        }
    }
    
    static class BlendState
    {
        public /* synthetic */ int field_179212_c;
        public /* synthetic */ int field_179211_b;
        public /* synthetic */ int field_179210_e;
        public /* synthetic */ int field_179209_d;
        public /* synthetic */ BooleanState field_179213_a;
        
        BlendState(final SwitchTexGen llllllllllllllIllIllIlIIlllllllI) {
            this();
        }
        
        private BlendState() {
            this.field_179213_a = new BooleanState(3042);
            this.field_179211_b = 1;
            this.field_179212_c = 0;
            this.field_179209_d = 1;
            this.field_179210_e = 0;
        }
    }
    
    static class ColorMask
    {
        public /* synthetic */ boolean field_179186_b;
        public /* synthetic */ boolean field_179188_a;
        public /* synthetic */ boolean field_179187_c;
        public /* synthetic */ boolean field_179185_d;
        
        ColorMask(final SwitchTexGen lllllllllllllllllIlIIlIIIlllIlII) {
            this();
        }
        
        private ColorMask() {
            this.field_179188_a = true;
            this.field_179186_b = true;
            this.field_179187_c = true;
            this.field_179185_d = true;
        }
    }
    
    static class Viewport
    {
        public /* synthetic */ int field_179055_d;
        public /* synthetic */ int field_179056_b;
        public /* synthetic */ int field_179058_a;
        public /* synthetic */ int field_179057_c;
        
        Viewport(final SwitchTexGen llllllllllllllIIlIIIlIllIIlIIIlI) {
            this();
        }
        
        private Viewport() {
            this.field_179058_a = 0;
            this.field_179056_b = 0;
            this.field_179057_c = 0;
            this.field_179055_d = 0;
        }
    }
    
    static class Color
    {
        public /* synthetic */ float green;
        public /* synthetic */ float field_179195_a;
        public /* synthetic */ float alpha;
        public /* synthetic */ float blue;
        
        public Color(final float llllllllllllllllllllIIlIlllIIlII, final float llllllllllllllllllllIIlIlllIIIll, final float llllllllllllllllllllIIlIlllIIIlI, final float llllllllllllllllllllIIlIlllIIllI) {
            this.field_179195_a = 1.0f;
            this.green = 1.0f;
            this.blue = 1.0f;
            this.alpha = 1.0f;
            this.field_179195_a = llllllllllllllllllllIIlIlllIIlII;
            this.green = llllllllllllllllllllIIlIlllIIIll;
            this.blue = llllllllllllllllllllIIlIlllIIIlI;
            this.alpha = llllllllllllllllllllIIlIlllIIllI;
        }
        
        public Color() {
            this.field_179195_a = 1.0f;
            this.green = 1.0f;
            this.blue = 1.0f;
            this.alpha = 1.0f;
        }
    }
    
    static class StencilFunc
    {
        public /* synthetic */ int field_179079_b;
        public /* synthetic */ int field_179080_c;
        public /* synthetic */ int field_179081_a;
        
        private StencilFunc() {
            this.field_179081_a = 519;
            this.field_179079_b = 0;
            this.field_179080_c = -1;
        }
        
        StencilFunc(final SwitchTexGen llllllllllllllllllllIlIlllllIlIl) {
            this();
        }
    }
    
    static class StencilState
    {
        public /* synthetic */ int field_179075_e;
        public /* synthetic */ int field_179074_d;
        public /* synthetic */ int field_179077_c;
        public /* synthetic */ int field_179076_b;
        public /* synthetic */ StencilFunc field_179078_a;
        
        StencilState(final SwitchTexGen lllIIIllllllI) {
            this();
        }
        
        private StencilState() {
            this.field_179078_a = new StencilFunc(null);
            this.field_179076_b = -1;
            this.field_179077_c = 7680;
            this.field_179074_d = 7680;
            this.field_179075_e = 7680;
        }
    }
    
    static class FogState
    {
        public /* synthetic */ BooleanState field_179049_a;
        public /* synthetic */ float field_179046_e;
        public /* synthetic */ float field_179045_d;
        public /* synthetic */ int field_179047_b;
        public /* synthetic */ float field_179048_c;
        
        private FogState() {
            this.field_179049_a = new BooleanState(2912);
            this.field_179047_b = 2048;
            this.field_179048_c = 1.0f;
            this.field_179045_d = 0.0f;
            this.field_179046_e = 1.0f;
        }
        
        FogState(final SwitchTexGen llllllllllllllIlIIIlllIlllIIIllI) {
            this();
        }
    }
    
    static class CullState
    {
        public /* synthetic */ BooleanState field_179054_a;
        public /* synthetic */ int field_179053_b;
        
        private CullState() {
            this.field_179054_a = new BooleanState(2884);
            this.field_179053_b = 1029;
        }
        
        CullState(final SwitchTexGen llllllllllllllIllIlIllllIIIlllIl) {
            this();
        }
    }
    
    static class ClearState
    {
        public /* synthetic */ int field_179204_c;
        public /* synthetic */ Color field_179203_b;
        public /* synthetic */ double field_179205_a;
        
        private ClearState() {
            this.field_179205_a = 1.0;
            this.field_179203_b = new Color(0.0f, 0.0f, 0.0f, 0.0f);
            this.field_179204_c = 0;
        }
        
        ClearState(final SwitchTexGen lllllllllllllllIlIlIlIIlllIlIlll) {
            this();
        }
    }
}
