package net.minecraft.client.shader;

import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import org.lwjgl.*;
import org.apache.commons.lang3.*;
import net.minecraft.client.util.*;
import java.nio.*;
import java.io.*;
import java.util.*;
import com.google.common.collect.*;

public class ShaderLoader
{
    private /* synthetic */ int shaderAttachCount;
    private /* synthetic */ int shader;
    private final /* synthetic */ String shaderFilename;
    private final /* synthetic */ ShaderType shaderType;
    
    public String getShaderFilename() {
        return this.shaderFilename;
    }
    
    static {
        __OBFID = "CL_00001043";
    }
    
    public void attachShader(final ShaderManager llllllllllllllIIIlIlIlIlIIIIlllI) {
        ++this.shaderAttachCount;
        OpenGlHelper.glAttachShader(llllllllllllllIIIlIlIlIlIIIIlllI.getProgram(), this.shader);
    }
    
    public void deleteShader(final ShaderManager llllllllllllllIIIlIlIlIlIIIIlIIl) {
        --this.shaderAttachCount;
        if (this.shaderAttachCount <= 0) {
            OpenGlHelper.glDeleteShader(this.shader);
            this.shaderType.getLoadedShaders().remove(this.shaderFilename);
        }
    }
    
    public static ShaderLoader loadShader(final IResourceManager llllllllllllllIIIlIlIlIIlllIlllI, final ShaderType llllllllllllllIIIlIlIlIIlllIllIl, final String llllllllllllllIIIlIlIlIIlllIllII) throws IOException {
        ShaderLoader llllllllllllllIIIlIlIlIIllllIllI = llllllllllllllIIIlIlIlIIlllIllIl.getLoadedShaders().get(llllllllllllllIIIlIlIlIIlllIllII);
        if (llllllllllllllIIIlIlIlIIllllIllI == null) {
            final ResourceLocation llllllllllllllIIIlIlIlIIllllIlIl = new ResourceLocation(String.valueOf(new StringBuilder("shaders/program/").append(llllllllllllllIIIlIlIlIIlllIllII).append(llllllllllllllIIIlIlIlIIlllIllIl.getShaderExtension())));
            final BufferedInputStream llllllllllllllIIIlIlIlIIllllIlII = new BufferedInputStream(llllllllllllllIIIlIlIlIIlllIlllI.getResource(llllllllllllllIIIlIlIlIIllllIlIl).getInputStream());
            final byte[] llllllllllllllIIIlIlIlIIllllIIll = func_177064_a(llllllllllllllIIIlIlIlIIllllIlII);
            final ByteBuffer llllllllllllllIIIlIlIlIIllllIIlI = BufferUtils.createByteBuffer(llllllllllllllIIIlIlIlIIllllIIll.length);
            llllllllllllllIIIlIlIlIIllllIIlI.put(llllllllllllllIIIlIlIlIIllllIIll);
            llllllllllllllIIIlIlIlIIllllIIlI.position(0);
            final int llllllllllllllIIIlIlIlIIllllIIIl = OpenGlHelper.glCreateShader(llllllllllllllIIIlIlIlIIlllIllIl.getShaderMode());
            OpenGlHelper.glShaderSource(llllllllllllllIIIlIlIlIIllllIIIl, llllllllllllllIIIlIlIlIIllllIIlI);
            OpenGlHelper.glCompileShader(llllllllllllllIIIlIlIlIIllllIIIl);
            if (OpenGlHelper.glGetShaderi(llllllllllllllIIIlIlIlIIllllIIIl, OpenGlHelper.GL_COMPILE_STATUS) == 0) {
                final String llllllllllllllIIIlIlIlIIllllIIII = StringUtils.trim(OpenGlHelper.glGetShaderInfoLog(llllllllllllllIIIlIlIlIIllllIIIl, 32768));
                final JsonException llllllllllllllIIIlIlIlIIlllIllll = new JsonException(String.valueOf(new StringBuilder("Couldn't compile ").append(llllllllllllllIIIlIlIlIIlllIllIl.getShaderName()).append(" program: ").append(llllllllllllllIIIlIlIlIIllllIIII)));
                llllllllllllllIIIlIlIlIIlllIllll.func_151381_b(llllllllllllllIIIlIlIlIIllllIlIl.getResourcePath());
                throw llllllllllllllIIIlIlIlIIlllIllll;
            }
            llllllllllllllIIIlIlIlIIllllIllI = new ShaderLoader(llllllllllllllIIIlIlIlIIlllIllIl, llllllllllllllIIIlIlIlIIllllIIIl, llllllllllllllIIIlIlIlIIlllIllII);
            llllllllllllllIIIlIlIlIIlllIllIl.getLoadedShaders().put(llllllllllllllIIIlIlIlIIlllIllII, llllllllllllllIIIlIlIlIIllllIllI);
        }
        return llllllllllllllIIIlIlIlIIllllIllI;
    }
    
    private ShaderLoader(final ShaderType llllllllllllllIIIlIlIlIlIIIlIlII, final int llllllllllllllIIIlIlIlIlIIIlIlll, final String llllllllllllllIIIlIlIlIlIIIlIIlI) {
        this.shaderAttachCount = 0;
        this.shaderType = llllllllllllllIIIlIlIlIlIIIlIlII;
        this.shader = llllllllllllllIIIlIlIlIlIIIlIlll;
        this.shaderFilename = llllllllllllllIIIlIlIlIlIIIlIIlI;
    }
    
    protected static byte[] func_177064_a(final BufferedInputStream llllllllllllllIIIlIlIlIIlllIIIII) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    org/apache/commons/io/IOUtils.toByteArray:(Ljava/io/InputStream;)[B
        //     4: astore_1        /* llllllllllllllIIIlIlIlIIllIlllII */
        //     5: goto            15
        //     8: astore_2        /* llllllllllllllIIIlIlIlIIllIllIll */
        //     9: aload_0         /* llllllllllllllIIIlIlIlIIllIlllIl */
        //    10: invokevirtual   java/io/BufferedInputStream.close:()V
        //    13: aload_2         /* llllllllllllllIIIlIlIlIIllIllIll */
        //    14: athrow         
        //    15: aload_0         /* llllllllllllllIIIlIlIlIIllIlllIl */
        //    16: invokevirtual   java/io/BufferedInputStream.close:()V
        //    19: aload_1         /* llllllllllllllIIIlIlIlIIllIllllI */
        //    20: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 48 07 01 00 FC 00 06 07 00 E2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      8      8      15     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public enum ShaderType
    {
        private final /* synthetic */ int shaderMode;
        private final /* synthetic */ String shaderName;
        private final /* synthetic */ Map loadedShaders;
        
        VERTEX("VERTEX", 0, "VERTEX", 0, "vertex", ".vsh", OpenGlHelper.GL_VERTEX_SHADER);
        
        private final /* synthetic */ String shaderExtension;
        
        FRAGMENT("FRAGMENT", 1, "FRAGMENT", 1, "fragment", ".fsh", OpenGlHelper.GL_FRAGMENT_SHADER);
        
        protected int getShaderMode() {
            return this.shaderMode;
        }
        
        private ShaderType(final String llllllllllllllIIIlllIIIlIIIIIlll, final int llllllllllllllIIIlllIIIlIIIIIllI, final String llllllllllllllIIIlllIIIlIIIIllIl, final int llllllllllllllIIIlllIIIlIIIIllII, final String llllllllllllllIIIlllIIIlIIIIlIll, final String llllllllllllllIIIlllIIIlIIIIlIlI, final int llllllllllllllIIIlllIIIlIIIIIIll) {
            this.loadedShaders = Maps.newHashMap();
            this.shaderName = llllllllllllllIIIlllIIIlIIIIlIll;
            this.shaderExtension = llllllllllllllIIIlllIIIlIIIIlIlI;
            this.shaderMode = llllllllllllllIIIlllIIIlIIIIIIll;
        }
        
        protected String getShaderExtension() {
            return this.shaderExtension;
        }
        
        protected Map getLoadedShaders() {
            return this.loadedShaders;
        }
        
        public String getShaderName() {
            return this.shaderName;
        }
        
        static {
            __OBFID = "CL_00001044";
        }
    }
}
