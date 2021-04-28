package net.minecraft.client.renderer;

import java.nio.*;
import optifine.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;

public class OpenGlHelper
{
    public static /* synthetic */ int field_176089_P;
    private static /* synthetic */ String field_153196_B;
    public static /* synthetic */ int field_176078_F;
    public static /* synthetic */ boolean field_153211_u;
    public static /* synthetic */ int field_176093_u;
    private static /* synthetic */ boolean openGL14;
    public static /* synthetic */ int GL_LINK_STATUS;
    private static /* synthetic */ boolean field_153213_x;
    public static /* synthetic */ int field_176086_J;
    public static /* synthetic */ int lightmapTexUnit;
    public static /* synthetic */ boolean shadersSupported;
    public static /* synthetic */ int field_153205_l;
    public static /* synthetic */ float lastBrightnessX;
    public static /* synthetic */ int field_176077_E;
    public static /* synthetic */ int field_176085_I;
    public static /* synthetic */ int field_176092_v;
    public static /* synthetic */ int field_153201_h;
    public static /* synthetic */ int field_153206_m;
    public static /* synthetic */ float lastBrightnessY;
    public static /* synthetic */ int field_176081_B;
    public static /* synthetic */ int field_153199_f;
    public static /* synthetic */ int anisotropicFilteringMax;
    public static /* synthetic */ int field_176095_s;
    public static /* synthetic */ int field_176082_C;
    private static /* synthetic */ boolean field_153214_y;
    public static /* synthetic */ int field_153200_g;
    public static /* synthetic */ int field_153198_e;
    public static /* synthetic */ boolean field_153197_d;
    public static /* synthetic */ int field_153202_i;
    public static /* synthetic */ int GL_COMPILE_STATUS;
    public static /* synthetic */ boolean field_176083_O;
    private static /* synthetic */ boolean field_153215_z;
    public static /* synthetic */ int defaultTexUnit;
    public static /* synthetic */ int field_153203_j;
    public static /* synthetic */ int field_153204_k;
    public static /* synthetic */ int field_176091_w;
    public static /* synthetic */ int GL_VERTEX_SHADER;
    public static /* synthetic */ int field_176087_K;
    public static /* synthetic */ int field_176096_r;
    private static /* synthetic */ boolean field_176088_V;
    public static /* synthetic */ int field_176094_t;
    public static /* synthetic */ boolean openGL21;
    public static /* synthetic */ int field_176084_H;
    public static /* synthetic */ boolean framebufferSupported;
    public static /* synthetic */ int field_176076_D;
    public static /* synthetic */ int field_176080_A;
    public static /* synthetic */ int field_176098_y;
    public static /* synthetic */ int field_176079_G;
    private static /* synthetic */ int field_153212_w;
    public static /* synthetic */ int field_176099_x;
    public static /* synthetic */ int field_176097_z;
    private static /* synthetic */ boolean field_176090_Y;
    public static /* synthetic */ int GL_FRAGMENT_SHADER;
    
    public static void func_153174_h(final int llllllllllllllIlIlIlIlIIlllllIII) {
        if (OpenGlHelper.framebufferSupported) {
            switch (OpenGlHelper.field_153212_w) {
                case 0: {
                    GL30.glDeleteFramebuffers(llllllllllllllIlIlIlIlIIlllllIII);
                    break;
                }
                case 1: {
                    ARBFramebufferObject.glDeleteFramebuffers(llllllllllllllIlIlIlIlIIlllllIII);
                    break;
                }
                case 2: {
                    EXTFramebufferObject.glDeleteFramebuffersEXT(llllllllllllllIlIlIlIlIIlllllIII);
                    break;
                }
            }
        }
    }
    
    public static void setActiveTexture(final int llllllllllllllIlIlIlIlIIlIIIIlII) {
        if (OpenGlHelper.field_153215_z) {
            ARBMultitexture.glActiveTextureARB(llllllllllllllIlIlIlIlIIlIIIIlII);
        }
        else {
            GL13.glActiveTexture(llllllllllllllIlIlIlIlIIlIIIIlII);
        }
    }
    
    public static void glDeleteShader(final int llllllllllllllIlIlIlIllIIIllIllI) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glDeleteObjectARB(llllllllllllllIlIlIlIllIIIllIllI);
        }
        else {
            GL20.glDeleteShader(llllllllllllllIlIlIlIllIIIllIllI);
        }
    }
    
    public static void func_153186_a(final int llllllllllllllIlIlIlIlIIllIlllll, final int llllllllllllllIlIlIlIlIIllIllIlI, final int llllllllllllllIlIlIlIlIIllIlllIl, final int llllllllllllllIlIlIlIlIIllIlllII) {
        if (OpenGlHelper.framebufferSupported) {
            switch (OpenGlHelper.field_153212_w) {
                case 0: {
                    GL30.glRenderbufferStorage(llllllllllllllIlIlIlIlIIllIlllll, llllllllllllllIlIlIlIlIIllIllIlI, llllllllllllllIlIlIlIlIIllIlllIl, llllllllllllllIlIlIlIlIIllIlllII);
                    break;
                }
                case 1: {
                    ARBFramebufferObject.glRenderbufferStorage(llllllllllllllIlIlIlIlIIllIlllll, llllllllllllllIlIlIlIlIIllIllIlI, llllllllllllllIlIlIlIlIIllIlllIl, llllllllllllllIlIlIlIlIIllIlllII);
                    break;
                }
                case 2: {
                    EXTFramebufferObject.glRenderbufferStorageEXT(llllllllllllllIlIlIlIlIIllIlllll, llllllllllllllIlIlIlIlIIllIllIlI, llllllllllllllIlIlIlIlIIllIlllIl, llllllllllllllIlIlIlIlIIllIlllII);
                    break;
                }
            }
        }
    }
    
    public static boolean areShadersSupported() {
        return OpenGlHelper.shadersSupported;
    }
    
    public static void glUniform4(final int llllllllllllllIlIlIlIlIllIIlIllI, final FloatBuffer llllllllllllllIlIlIlIlIllIIlIlII) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform4ARB(llllllllllllllIlIlIlIlIllIIlIllI, llllllllllllllIlIlIlIlIllIIlIlII);
        }
        else {
            GL20.glUniform4(llllllllllllllIlIlIlIlIllIIlIllI, llllllllllllllIlIlIlIlIllIIlIlII);
        }
    }
    
    public static void func_153171_g(final int llllllllllllllIlIlIlIlIlIIlIIIII, final int llllllllllllllIlIlIlIlIlIIIlllll) {
        if (OpenGlHelper.framebufferSupported) {
            switch (OpenGlHelper.field_153212_w) {
                case 0: {
                    GL30.glBindFramebuffer(llllllllllllllIlIlIlIlIlIIlIIIII, llllllllllllllIlIlIlIlIlIIIlllll);
                    break;
                }
                case 1: {
                    ARBFramebufferObject.glBindFramebuffer(llllllllllllllIlIlIlIlIlIIlIIIII, llllllllllllllIlIlIlIlIlIIIlllll);
                    break;
                }
                case 2: {
                    EXTFramebufferObject.glBindFramebufferEXT(llllllllllllllIlIlIlIlIlIIlIIIII, llllllllllllllIlIlIlIlIlIIIlllll);
                    break;
                }
            }
        }
    }
    
    public static void glUniform1(final int llllllllllllllIlIlIlIlIlllIlllIl, final IntBuffer llllllllllllllIlIlIlIlIlllIlllII) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform1ARB(llllllllllllllIlIlIlIlIlllIlllIl, llllllllllllllIlIlIlIlIlllIlllII);
        }
        else {
            GL20.glUniform1(llllllllllllllIlIlIlIlIlllIlllIl, llllllllllllllIlIlIlIlIlllIlllII);
        }
    }
    
    public static void setClientActiveTexture(final int llllllllllllllIlIlIlIlIIIllllIlI) {
        if (OpenGlHelper.field_153215_z) {
            ARBMultitexture.glClientActiveTextureARB(llllllllllllllIlIlIlIlIIIllllIlI);
        }
        else {
            GL13.glClientActiveTexture(llllllllllllllIlIlIlIlIIIllllIlI);
        }
    }
    
    public static int glGetAttribLocation(final int llllllllllllllIlIlIlIlIlIlIlIIll, final CharSequence llllllllllllllIlIlIlIlIlIlIlIlII) {
        return OpenGlHelper.field_153214_y ? ARBVertexShader.glGetAttribLocationARB(llllllllllllllIlIlIlIlIlIlIlIIll, llllllllllllllIlIlIlIlIlIlIlIlII) : GL20.glGetAttribLocation(llllllllllllllIlIlIlIlIlIlIlIIll, llllllllllllllIlIlIlIlIlIlIlIlII);
    }
    
    public static void func_176074_g(final int llllllllllllllIlIlIlIlIlIIlIlIIl) {
        if (OpenGlHelper.field_176090_Y) {
            ARBVertexBufferObject.glDeleteBuffersARB(llllllllllllllIlIlIlIlIlIIlIlIIl);
        }
        else {
            GL15.glDeleteBuffers(llllllllllllllIlIlIlIlIlIIlIlIIl);
        }
    }
    
    public static void glUniform1i(final int llllllllllllllIlIlIlIlIlllIlIlll, final int llllllllllllllIlIlIlIlIlllIlIllI) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform1iARB(llllllllllllllIlIlIlIlIlllIlIlll, llllllllllllllIlIlIlIlIlllIlIllI);
        }
        else {
            GL20.glUniform1i(llllllllllllllIlIlIlIlIlllIlIlll, llllllllllllllIlIlIlIlIlllIlIllI);
        }
    }
    
    public static int glGetShaderi(final int llllllllllllllIlIlIlIllIIIIllIII, final int llllllllllllllIlIlIlIllIIIIllIlI) {
        return OpenGlHelper.field_153214_y ? ARBShaderObjects.glGetObjectParameteriARB(llllllllllllllIlIlIlIllIIIIllIII, llllllllllllllIlIlIlIllIIIIllIlI) : GL20.glGetShaderi(llllllllllllllIlIlIlIllIIIIllIII, llllllllllllllIlIlIlIllIIIIllIlI);
    }
    
    public static void glAttachShader(final int llllllllllllllIlIlIlIllIIIllllll, final int llllllllllllllIlIlIlIllIIlIIIIIl) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glAttachObjectARB(llllllllllllllIlIlIlIllIIIllllll, llllllllllllllIlIlIlIllIIlIIIIIl);
        }
        else {
            GL20.glAttachShader(llllllllllllllIlIlIlIllIIIllllll, llllllllllllllIlIlIlIllIIlIIIIIl);
        }
    }
    
    public static void func_153176_h(final int llllllllllllllIlIlIlIlIlIIIIllII, final int llllllllllllllIlIlIlIlIlIIIIlllI) {
        if (OpenGlHelper.framebufferSupported) {
            switch (OpenGlHelper.field_153212_w) {
                case 0: {
                    GL30.glBindRenderbuffer(llllllllllllllIlIlIlIlIlIIIIllII, llllllllllllllIlIlIlIlIlIIIIlllI);
                    break;
                }
                case 1: {
                    ARBFramebufferObject.glBindRenderbuffer(llllllllllllllIlIlIlIlIlIIIIllII, llllllllllllllIlIlIlIlIlIIIIlllI);
                    break;
                }
                case 2: {
                    EXTFramebufferObject.glBindRenderbufferEXT(llllllllllllllIlIlIlIlIlIIIIllII, llllllllllllllIlIlIlIlIlIIIIlllI);
                    break;
                }
            }
        }
    }
    
    public static int func_153185_f() {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch (OpenGlHelper.field_153212_w) {
            case 0: {
                return GL30.glGenRenderbuffers();
            }
            case 1: {
                return ARBFramebufferObject.glGenRenderbuffers();
            }
            case 2: {
                return EXTFramebufferObject.glGenRenderbuffersEXT();
            }
            default: {
                return -1;
            }
        }
    }
    
    public static void glLinkProgram(final int llllllllllllllIlIlIlIlIllllIlIIl) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glLinkProgramARB(llllllllllllllIlIlIlIlIllllIlIIl);
        }
        else {
            GL20.glLinkProgram(llllllllllllllIlIlIlIlIllllIlIIl);
        }
    }
    
    public static void func_153184_g(final int llllllllllllllIlIlIlIlIlIIIIIIll) {
        if (OpenGlHelper.framebufferSupported) {
            switch (OpenGlHelper.field_153212_w) {
                case 0: {
                    GL30.glDeleteRenderbuffers(llllllllllllllIlIlIlIlIlIIIIIIll);
                    break;
                }
                case 1: {
                    ARBFramebufferObject.glDeleteRenderbuffers(llllllllllllllIlIlIlIlIlIIIIIIll);
                    break;
                }
                case 2: {
                    EXTFramebufferObject.glDeleteRenderbuffersEXT(llllllllllllllIlIlIlIlIlIIIIIIll);
                    break;
                }
            }
        }
    }
    
    public static void glUniform2(final int llllllllllllllIlIlIlIlIlllIIIlll, final FloatBuffer llllllllllllllIlIlIlIlIlllIIIllI) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform2ARB(llllllllllllllIlIlIlIlIlllIIIlll, llllllllllllllIlIlIlIlIlllIIIllI);
        }
        else {
            GL20.glUniform2(llllllllllllllIlIlIlIlIlllIIIlll, llllllllllllllIlIlIlIlIlllIIIllI);
        }
    }
    
    public static int func_176073_e() {
        return OpenGlHelper.field_176090_Y ? ARBVertexBufferObject.glGenBuffersARB() : GL15.glGenBuffers();
    }
    
    public static void glUniform1(final int llllllllllllllIlIlIlIlIlllIlIIIl, final FloatBuffer llllllllllllllIlIlIlIlIlllIlIIlI) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform1ARB(llllllllllllllIlIlIlIlIlllIlIIIl, llllllllllllllIlIlIlIlIlllIlIIlI);
        }
        else {
            GL20.glUniform1(llllllllllllllIlIlIlIlIlllIlIIIl, llllllllllllllIlIlIlIlIlllIlIIlI);
        }
    }
    
    public static void glUniformMatrix4(final int llllllllllllllIlIlIlIlIlIlIllllI, final boolean llllllllllllllIlIlIlIlIlIlIllIIl, final FloatBuffer llllllllllllllIlIlIlIlIlIlIllIll) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniformMatrix4ARB(llllllllllllllIlIlIlIlIlIlIllllI, llllllllllllllIlIlIlIlIlIlIllIIl, llllllllllllllIlIlIlIlIlIlIllIll);
        }
        else {
            GL20.glUniformMatrix4(llllllllllllllIlIlIlIlIlIlIllllI, llllllllllllllIlIlIlIlIlIlIllIIl, llllllllllllllIlIlIlIlIlIlIllIll);
        }
    }
    
    public static void glDeleteProgram(final int llllllllllllllIlIlIlIlIllllIllIl) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glDeleteObjectARB(llllllllllllllIlIlIlIlIllllIllIl);
        }
        else {
            GL20.glDeleteProgram(llllllllllllllIlIlIlIlIllllIllIl);
        }
    }
    
    public static void func_153190_b(final int llllllllllllllIlIlIlIlIIllIIllll, final int llllllllllllllIlIlIlIlIIllIIIlIl, final int llllllllllllllIlIlIlIlIIllIIIIll, final int llllllllllllllIlIlIlIlIIllIIIIIl) {
        if (OpenGlHelper.framebufferSupported) {
            switch (OpenGlHelper.field_153212_w) {
                case 0: {
                    GL30.glFramebufferRenderbuffer(llllllllllllllIlIlIlIlIIllIIllll, llllllllllllllIlIlIlIlIIllIIIlIl, llllllllllllllIlIlIlIlIIllIIIIll, llllllllllllllIlIlIlIlIIllIIIIIl);
                    break;
                }
                case 1: {
                    ARBFramebufferObject.glFramebufferRenderbuffer(llllllllllllllIlIlIlIlIIllIIllll, llllllllllllllIlIlIlIlIIllIIIlIl, llllllllllllllIlIlIlIlIIllIIIIll, llllllllllllllIlIlIlIlIIllIIIIIl);
                    break;
                }
                case 2: {
                    EXTFramebufferObject.glFramebufferRenderbufferEXT(llllllllllllllIlIlIlIlIIllIIllll, llllllllllllllIlIlIlIlIIllIIIlIl, llllllllllllllIlIlIlIlIIllIIIIll, llllllllllllllIlIlIlIlIIllIIIIIl);
                    break;
                }
            }
        }
    }
    
    public static void glBlendFunc(final int llllllllllllllIlIlIlIlIIIllIIlII, final int llllllllllllllIlIlIlIlIIIllIIlll, final int llllllllllllllIlIlIlIlIIIllIIllI, final int llllllllllllllIlIlIlIlIIIllIIlIl) {
        if (OpenGlHelper.openGL14) {
            if (OpenGlHelper.field_153211_u) {
                EXTBlendFuncSeparate.glBlendFuncSeparateEXT(llllllllllllllIlIlIlIlIIIllIIlII, llllllllllllllIlIlIlIlIIIllIIlll, llllllllllllllIlIlIlIlIIIllIIllI, llllllllllllllIlIlIlIlIIIllIIlIl);
            }
            else {
                GL14.glBlendFuncSeparate(llllllllllllllIlIlIlIlIIIllIIlII, llllllllllllllIlIlIlIlIIIllIIlll, llllllllllllllIlIlIlIlIIIllIIllI, llllllllllllllIlIlIlIlIIIllIIlIl);
            }
        }
        else {
            GL11.glBlendFunc(llllllllllllllIlIlIlIlIIIllIIlII, llllllllllllllIlIlIlIlIIIllIIlll);
        }
    }
    
    public static void glShaderSource(final int llllllllllllllIlIlIlIllIIIlIllII, final ByteBuffer llllllllllllllIlIlIlIllIIIlIlIll) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glShaderSourceARB(llllllllllllllIlIlIlIllIIIlIllII, llllllllllllllIlIlIlIllIIIlIlIll);
        }
        else {
            GL20.glShaderSource(llllllllllllllIlIlIlIllIIIlIllII, llllllllllllllIlIlIlIllIIIlIlIll);
        }
    }
    
    public static int glCreateProgram() {
        return OpenGlHelper.field_153214_y ? ARBShaderObjects.glCreateProgramObjectARB() : GL20.glCreateProgram();
    }
    
    public static void glUniformMatrix3(final int llllllllllllllIlIlIlIlIlIlllIllI, final boolean llllllllllllllIlIlIlIlIlIllIlllI, final FloatBuffer llllllllllllllIlIlIlIlIlIllIllII) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniformMatrix3ARB(llllllllllllllIlIlIlIlIlIlllIllI, llllllllllllllIlIlIlIlIlIllIlllI, llllllllllllllIlIlIlIlIlIllIllII);
        }
        else {
            GL20.glUniformMatrix3(llllllllllllllIlIlIlIlIlIlllIllI, llllllllllllllIlIlIlIlIlIllIlllI, llllllllllllllIlIlIlIlIlIllIllII);
        }
    }
    
    public static void func_176072_g(final int llllllllllllllIlIlIlIlIlIlIIIIIl, final int llllllllllllllIlIlIlIlIlIlIIIIII) {
        if (OpenGlHelper.field_176090_Y) {
            ARBVertexBufferObject.glBindBufferARB(llllllllllllllIlIlIlIlIlIlIIIIIl, llllllllllllllIlIlIlIlIlIlIIIIII);
        }
        else {
            GL15.glBindBuffer(llllllllllllllIlIlIlIlIlIlIIIIIl, llllllllllllllIlIlIlIlIlIlIIIIII);
        }
    }
    
    public static void glUniform3(final int llllllllllllllIlIlIlIlIllIllIlll, final FloatBuffer llllllllllllllIlIlIlIlIllIllIllI) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform3ARB(llllllllllllllIlIlIlIlIllIllIlll, llllllllllllllIlIlIlIlIllIllIllI);
        }
        else {
            GL20.glUniform3(llllllllllllllIlIlIlIlIllIllIlll, llllllllllllllIlIlIlIlIllIllIllI);
        }
    }
    
    public static void glUniform2(final int llllllllllllllIlIlIlIlIlllIIlIll, final IntBuffer llllllllllllllIlIlIlIlIlllIIllII) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform2ARB(llllllllllllllIlIlIlIlIlllIIlIll, llllllllllllllIlIlIlIlIlllIIllII);
        }
        else {
            GL20.glUniform2(llllllllllllllIlIlIlIlIlllIIlIll, llllllllllllllIlIlIlIlIlllIIllII);
        }
    }
    
    public static void initializeTextures() {
        Config.initDisplay();
        final ContextCapabilities llllllllllllllIlIlIlIllIIlIllIIl = GLContext.getCapabilities();
        OpenGlHelper.field_153215_z = (llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_multitexture && !llllllllllllllIlIlIlIllIIlIllIIl.OpenGL13);
        OpenGlHelper.field_176088_V = (llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_texture_env_combine && !llllllllllllllIlIlIlIllIIlIllIIl.OpenGL13);
        if (OpenGlHelper.field_153215_z) {
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("Using ARB_multitexture.\n"));
            OpenGlHelper.defaultTexUnit = 33984;
            OpenGlHelper.lightmapTexUnit = 33985;
            OpenGlHelper.field_176096_r = 33986;
        }
        else {
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("Using GL 1.3 multitexturing.\n"));
            OpenGlHelper.defaultTexUnit = 33984;
            OpenGlHelper.lightmapTexUnit = 33985;
            OpenGlHelper.field_176096_r = 33986;
        }
        if (OpenGlHelper.field_176088_V) {
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("Using ARB_texture_env_combine.\n"));
            OpenGlHelper.field_176095_s = 34160;
            OpenGlHelper.field_176094_t = 34165;
            OpenGlHelper.field_176093_u = 34167;
            OpenGlHelper.field_176092_v = 34166;
            OpenGlHelper.field_176091_w = 34168;
            OpenGlHelper.field_176099_x = 34161;
            OpenGlHelper.field_176098_y = 34176;
            OpenGlHelper.field_176097_z = 34177;
            OpenGlHelper.field_176080_A = 34178;
            OpenGlHelper.field_176081_B = 34192;
            OpenGlHelper.field_176082_C = 34193;
            OpenGlHelper.field_176076_D = 34194;
            OpenGlHelper.field_176077_E = 34162;
            OpenGlHelper.field_176078_F = 34184;
            OpenGlHelper.field_176079_G = 34185;
            OpenGlHelper.field_176084_H = 34186;
            OpenGlHelper.field_176085_I = 34200;
            OpenGlHelper.field_176086_J = 34201;
            OpenGlHelper.field_176087_K = 34202;
        }
        else {
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("Using GL 1.3 texture combiners.\n"));
            OpenGlHelper.field_176095_s = 34160;
            OpenGlHelper.field_176094_t = 34165;
            OpenGlHelper.field_176093_u = 34167;
            OpenGlHelper.field_176092_v = 34166;
            OpenGlHelper.field_176091_w = 34168;
            OpenGlHelper.field_176099_x = 34161;
            OpenGlHelper.field_176098_y = 34176;
            OpenGlHelper.field_176097_z = 34177;
            OpenGlHelper.field_176080_A = 34178;
            OpenGlHelper.field_176081_B = 34192;
            OpenGlHelper.field_176082_C = 34193;
            OpenGlHelper.field_176076_D = 34194;
            OpenGlHelper.field_176077_E = 34162;
            OpenGlHelper.field_176078_F = 34184;
            OpenGlHelper.field_176079_G = 34185;
            OpenGlHelper.field_176084_H = 34186;
            OpenGlHelper.field_176085_I = 34200;
            OpenGlHelper.field_176086_J = 34201;
            OpenGlHelper.field_176087_K = 34202;
        }
        OpenGlHelper.field_153211_u = (llllllllllllllIlIlIlIllIIlIllIIl.GL_EXT_blend_func_separate && !llllllllllllllIlIlIlIllIIlIllIIl.OpenGL14);
        OpenGlHelper.openGL14 = (llllllllllllllIlIlIlIllIIlIllIIl.OpenGL14 || llllllllllllllIlIlIlIllIIlIllIIl.GL_EXT_blend_func_separate);
        OpenGlHelper.framebufferSupported = (OpenGlHelper.openGL14 && (llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_framebuffer_object || llllllllllllllIlIlIlIllIIlIllIIl.GL_EXT_framebuffer_object || llllllllllllllIlIlIlIllIIlIllIIl.OpenGL30));
        if (OpenGlHelper.framebufferSupported) {
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("Using framebuffer objects because "));
            if (llllllllllllllIlIlIlIllIIlIllIIl.OpenGL30) {
                OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("OpenGL 3.0 is supported and separate blending is supported.\n"));
                OpenGlHelper.field_153212_w = 0;
                OpenGlHelper.field_153198_e = 36160;
                OpenGlHelper.field_153199_f = 36161;
                OpenGlHelper.field_153200_g = 36064;
                OpenGlHelper.field_153201_h = 36096;
                OpenGlHelper.field_153202_i = 36053;
                OpenGlHelper.field_153203_j = 36054;
                OpenGlHelper.field_153204_k = 36055;
                OpenGlHelper.field_153205_l = 36059;
                OpenGlHelper.field_153206_m = 36060;
            }
            else if (llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_framebuffer_object) {
                OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("ARB_framebuffer_object is supported and separate blending is supported.\n"));
                OpenGlHelper.field_153212_w = 1;
                OpenGlHelper.field_153198_e = 36160;
                OpenGlHelper.field_153199_f = 36161;
                OpenGlHelper.field_153200_g = 36064;
                OpenGlHelper.field_153201_h = 36096;
                OpenGlHelper.field_153202_i = 36053;
                OpenGlHelper.field_153204_k = 36055;
                OpenGlHelper.field_153203_j = 36054;
                OpenGlHelper.field_153205_l = 36059;
                OpenGlHelper.field_153206_m = 36060;
            }
            else if (llllllllllllllIlIlIlIllIIlIllIIl.GL_EXT_framebuffer_object) {
                OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("EXT_framebuffer_object is supported.\n"));
                OpenGlHelper.field_153212_w = 2;
                OpenGlHelper.field_153198_e = 36160;
                OpenGlHelper.field_153199_f = 36161;
                OpenGlHelper.field_153200_g = 36064;
                OpenGlHelper.field_153201_h = 36096;
                OpenGlHelper.field_153202_i = 36053;
                OpenGlHelper.field_153204_k = 36055;
                OpenGlHelper.field_153203_j = 36054;
                OpenGlHelper.field_153205_l = 36059;
                OpenGlHelper.field_153206_m = 36060;
            }
        }
        else {
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("Not using framebuffer objects because "));
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("OpenGL 1.4 is ").append(llllllllllllllIlIlIlIllIIlIllIIl.OpenGL14 ? "" : "not ").append("supported, "));
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("EXT_blend_func_separate is ").append(llllllllllllllIlIlIlIllIIlIllIIl.GL_EXT_blend_func_separate ? "" : "not ").append("supported, "));
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("OpenGL 3.0 is ").append(llllllllllllllIlIlIlIllIIlIllIIl.OpenGL30 ? "" : "not ").append("supported, "));
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("ARB_framebuffer_object is ").append(llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_framebuffer_object ? "" : "not ").append("supported, and "));
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("EXT_framebuffer_object is ").append(llllllllllllllIlIlIlIllIIlIllIIl.GL_EXT_framebuffer_object ? "" : "not ").append("supported.\n"));
        }
        OpenGlHelper.openGL21 = llllllllllllllIlIlIlIllIIlIllIIl.OpenGL21;
        OpenGlHelper.field_153213_x = (OpenGlHelper.openGL21 || (llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_vertex_shader && llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_fragment_shader && llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_shader_objects));
        OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("Shaders are ").append(OpenGlHelper.field_153213_x ? "" : "not ").append("available because "));
        if (OpenGlHelper.field_153213_x) {
            if (llllllllllllllIlIlIlIllIIlIllIIl.OpenGL21) {
                OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("OpenGL 2.1 is supported.\n"));
                OpenGlHelper.field_153214_y = false;
                OpenGlHelper.GL_LINK_STATUS = 35714;
                OpenGlHelper.GL_COMPILE_STATUS = 35713;
                OpenGlHelper.GL_VERTEX_SHADER = 35633;
                OpenGlHelper.GL_FRAGMENT_SHADER = 35632;
            }
            else {
                OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("ARB_shader_objects, ARB_vertex_shader, and ARB_fragment_shader are supported.\n"));
                OpenGlHelper.field_153214_y = true;
                OpenGlHelper.GL_LINK_STATUS = 35714;
                OpenGlHelper.GL_COMPILE_STATUS = 35713;
                OpenGlHelper.GL_VERTEX_SHADER = 35633;
                OpenGlHelper.GL_FRAGMENT_SHADER = 35632;
            }
        }
        else {
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("OpenGL 2.1 is ").append(llllllllllllllIlIlIlIllIIlIllIIl.OpenGL21 ? "" : "not ").append("supported, "));
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("ARB_shader_objects is ").append(llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_shader_objects ? "" : "not ").append("supported, "));
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("ARB_vertex_shader is ").append(llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_vertex_shader ? "" : "not ").append("supported, and "));
            OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("ARB_fragment_shader is ").append(llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_fragment_shader ? "" : "not ").append("supported.\n"));
        }
        OpenGlHelper.shadersSupported = (OpenGlHelper.framebufferSupported && OpenGlHelper.field_153213_x);
        OpenGlHelper.field_153197_d = GL11.glGetString(7936).toLowerCase().contains("nvidia");
        OpenGlHelper.field_176090_Y = (!llllllllllllllIlIlIlIllIIlIllIIl.OpenGL15 && llllllllllllllIlIlIlIllIIlIllIIl.GL_ARB_vertex_buffer_object);
        OpenGlHelper.field_176083_O = (llllllllllllllIlIlIlIllIIlIllIIl.OpenGL15 || OpenGlHelper.field_176090_Y);
        OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("VBOs are ").append(OpenGlHelper.field_176083_O ? "" : "not ").append("available because "));
        if (OpenGlHelper.field_176083_O) {
            if (OpenGlHelper.field_176090_Y) {
                OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("ARB_vertex_buffer_object is supported.\n"));
                OpenGlHelper.anisotropicFilteringMax = 35044;
                OpenGlHelper.field_176089_P = 34962;
            }
            else {
                OpenGlHelper.field_153196_B = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.field_153196_B)).append("OpenGL 1.5 is supported.\n"));
                OpenGlHelper.anisotropicFilteringMax = 35044;
                OpenGlHelper.field_176089_P = 34962;
            }
        }
    }
    
    public static boolean isFramebufferEnabled() {
        return !Config.isFastRender() && !Config.isAntialiasing() && (OpenGlHelper.framebufferSupported && Minecraft.getMinecraft().gameSettings.fboEnable);
    }
    
    public static int func_153165_e() {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch (OpenGlHelper.field_153212_w) {
            case 0: {
                return GL30.glGenFramebuffers();
            }
            case 1: {
                return ARBFramebufferObject.glGenFramebuffers();
            }
            case 2: {
                return EXTFramebufferObject.glGenFramebuffersEXT();
            }
            default: {
                return -1;
            }
        }
    }
    
    public static void glUniform3(final int llllllllllllllIlIlIlIlIllIlllIll, final IntBuffer llllllllllllllIlIlIlIlIllIlllIlI) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform3ARB(llllllllllllllIlIlIlIlIllIlllIll, llllllllllllllIlIlIlIlIllIlllIlI);
        }
        else {
            GL20.glUniform3(llllllllllllllIlIlIlIlIllIlllIll, llllllllllllllIlIlIlIlIllIlllIlI);
        }
    }
    
    public static void func_153188_a(final int llllllllllllllIlIlIlIlIIlIIlIlIl, final int llllllllllllllIlIlIlIlIIlIIlIIll, final int llllllllllllllIlIlIlIlIIlIIllIll, final int llllllllllllllIlIlIlIlIIlIIllIIl, final int llllllllllllllIlIlIlIlIIlIIlIlll) {
        if (OpenGlHelper.framebufferSupported) {
            switch (OpenGlHelper.field_153212_w) {
                case 0: {
                    GL30.glFramebufferTexture2D(llllllllllllllIlIlIlIlIIlIIlIlIl, llllllllllllllIlIlIlIlIIlIIlIIll, llllllllllllllIlIlIlIlIIlIIllIll, llllllllllllllIlIlIlIlIIlIIllIIl, llllllllllllllIlIlIlIlIIlIIlIlll);
                    break;
                }
                case 1: {
                    ARBFramebufferObject.glFramebufferTexture2D(llllllllllllllIlIlIlIlIIlIIlIlIl, llllllllllllllIlIlIlIlIIlIIlIIll, llllllllllllllIlIlIlIlIIlIIllIll, llllllllllllllIlIlIlIlIIlIIllIIl, llllllllllllllIlIlIlIlIIlIIlIlll);
                    break;
                }
                case 2: {
                    EXTFramebufferObject.glFramebufferTexture2DEXT(llllllllllllllIlIlIlIlIIlIIlIlIl, llllllllllllllIlIlIlIlIIlIIlIIll, llllllllllllllIlIlIlIlIIlIIllIll, llllllllllllllIlIlIlIlIIlIIllIIl, llllllllllllllIlIlIlIlIIlIIlIlll);
                    break;
                }
            }
        }
    }
    
    public static String glGetShaderInfoLog(final int llllllllllllllIlIlIlIllIIIIlIIIl, final int llllllllllllllIlIlIlIllIIIIlIIII) {
        return OpenGlHelper.field_153214_y ? ARBShaderObjects.glGetInfoLogARB(llllllllllllllIlIlIlIllIIIIlIIIl, llllllllllllllIlIlIlIllIIIIlIIII) : GL20.glGetShaderInfoLog(llllllllllllllIlIlIlIllIIIIlIIIl, llllllllllllllIlIlIlIllIIIIlIIII);
    }
    
    public static void func_176071_a(final int llllllllllllllIlIlIlIlIlIIllIlll, final ByteBuffer llllllllllllllIlIlIlIlIlIIllIlIl, final int llllllllllllllIlIlIlIlIlIIlIllll) {
        if (OpenGlHelper.field_176090_Y) {
            ARBVertexBufferObject.glBufferDataARB(llllllllllllllIlIlIlIlIlIIllIlll, llllllllllllllIlIlIlIlIlIIllIlIl, llllllllllllllIlIlIlIlIlIIlIllll);
        }
        else {
            GL15.glBufferData(llllllllllllllIlIlIlIlIlIIllIlll, llllllllllllllIlIlIlIlIlIIllIlIl, llllllllllllllIlIlIlIlIlIIlIllll);
        }
    }
    
    static {
        __OBFID = "CL_00001179";
        OpenGlHelper.field_153196_B = "";
        OpenGlHelper.lastBrightnessX = 0.0f;
        OpenGlHelper.lastBrightnessY = 0.0f;
    }
    
    public static void glUniformMatrix2(final int llllllllllllllIlIlIlIlIllIIIIIlI, final boolean llllllllllllllIlIlIlIlIllIIIIlII, final FloatBuffer llllllllllllllIlIlIlIlIllIIIIIII) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniformMatrix2ARB(llllllllllllllIlIlIlIlIllIIIIIlI, llllllllllllllIlIlIlIlIllIIIIlII, llllllllllllllIlIlIlIlIllIIIIIII);
        }
        else {
            GL20.glUniformMatrix2(llllllllllllllIlIlIlIlIllIIIIIlI, llllllllllllllIlIlIlIlIllIIIIlII, llllllllllllllIlIlIlIlIllIIIIIII);
        }
    }
    
    public static void glUniform4(final int llllllllllllllIlIlIlIlIllIlIlIll, final IntBuffer llllllllllllllIlIlIlIlIllIlIIlIl) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform4ARB(llllllllllllllIlIlIlIlIllIlIlIll, llllllllllllllIlIlIlIlIllIlIIlIl);
        }
        else {
            GL20.glUniform4(llllllllllllllIlIlIlIlIllIlIlIll, llllllllllllllIlIlIlIlIllIlIIlIl);
        }
    }
    
    public static int func_153167_i(final int llllllllllllllIlIlIlIlIIlIllIlll) {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch (OpenGlHelper.field_153212_w) {
            case 0: {
                return GL30.glCheckFramebufferStatus(llllllllllllllIlIlIlIlIIlIllIlll);
            }
            case 1: {
                return ARBFramebufferObject.glCheckFramebufferStatus(llllllllllllllIlIlIlIlIIlIllIlll);
            }
            case 2: {
                return EXTFramebufferObject.glCheckFramebufferStatusEXT(llllllllllllllIlIlIlIlIIlIllIlll);
            }
            default: {
                return -1;
            }
        }
    }
    
    public static void glUseProgram(final int llllllllllllllIlIlIlIlIllllllIlI) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUseProgramObjectARB(llllllllllllllIlIlIlIlIllllllIlI);
        }
        else {
            GL20.glUseProgram(llllllllllllllIlIlIlIlIllllllIlI);
        }
    }
    
    public static int glGetUniformLocation(final int llllllllllllllIlIlIlIlIllllIIlIl, final CharSequence llllllllllllllIlIlIlIlIllllIIlII) {
        return OpenGlHelper.field_153214_y ? ARBShaderObjects.glGetUniformLocationARB(llllllllllllllIlIlIlIlIllllIIlIl, llllllllllllllIlIlIlIlIllllIIlII) : GL20.glGetUniformLocation(llllllllllllllIlIlIlIlIllllIIlIl, llllllllllllllIlIlIlIlIllllIIlII);
    }
    
    public static String glGetProgramInfoLog(final int llllllllllllllIlIlIlIllIIIIIIlll, final int llllllllllllllIlIlIlIllIIIIIIlIl) {
        return OpenGlHelper.field_153214_y ? ARBShaderObjects.glGetInfoLogARB(llllllllllllllIlIlIlIllIIIIIIlll, llllllllllllllIlIlIlIllIIIIIIlIl) : GL20.glGetProgramInfoLog(llllllllllllllIlIlIlIllIIIIIIlll, llllllllllllllIlIlIlIllIIIIIIlIl);
    }
    
    public static void setLightmapTextureCoords(final int llllllllllllllIlIlIlIlIIIllIllll, final float llllllllllllllIlIlIlIlIIIlllIIIl, final float llllllllllllllIlIlIlIlIIIlllIIII) {
        if (OpenGlHelper.field_153215_z) {
            ARBMultitexture.glMultiTexCoord2fARB(llllllllllllllIlIlIlIlIIIllIllll, llllllllllllllIlIlIlIlIIIlllIIIl, llllllllllllllIlIlIlIlIIIlllIIII);
        }
        else {
            GL13.glMultiTexCoord2f(llllllllllllllIlIlIlIlIIIllIllll, llllllllllllllIlIlIlIlIIIlllIIIl, llllllllllllllIlIlIlIlIIIlllIIII);
        }
        if (llllllllllllllIlIlIlIlIIIllIllll == OpenGlHelper.lightmapTexUnit) {
            OpenGlHelper.lastBrightnessX = llllllllllllllIlIlIlIlIIIlllIIIl;
            OpenGlHelper.lastBrightnessY = llllllllllllllIlIlIlIlIIIlllIIII;
        }
    }
    
    public static String func_153172_c() {
        return OpenGlHelper.field_153196_B;
    }
    
    public static boolean func_176075_f() {
        return !Config.isMultiTexture() && (OpenGlHelper.field_176083_O && Minecraft.getMinecraft().gameSettings.field_178881_t);
    }
    
    public static int glGetProgrami(final int llllllllllllllIlIlIlIllIIlIIllll, final int llllllllllllllIlIlIlIllIIlIIllIl) {
        return OpenGlHelper.field_153214_y ? ARBShaderObjects.glGetObjectParameteriARB(llllllllllllllIlIlIlIllIIlIIllll, llllllllllllllIlIlIlIllIIlIIllIl) : GL20.glGetProgrami(llllllllllllllIlIlIlIllIIlIIllll, llllllllllllllIlIlIlIllIIlIIllIl);
    }
    
    public static int glCreateShader(final int llllllllllllllIlIlIlIllIIIllIIlI) {
        return OpenGlHelper.field_153214_y ? ARBShaderObjects.glCreateShaderObjectARB(llllllllllllllIlIlIlIllIIIllIIlI) : GL20.glCreateShader(llllllllllllllIlIlIlIllIIIllIIlI);
    }
    
    public static void glCompileShader(final int llllllllllllllIlIlIlIllIIIlIIlll) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glCompileShaderARB(llllllllllllllIlIlIlIllIIIlIIlll);
        }
        else {
            GL20.glCompileShader(llllllllllllllIlIlIlIllIIIlIIlll);
        }
    }
}
