package net.minecraft.client.shader;

import java.nio.*;
import javax.vecmath.*;
import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;
import org.lwjgl.*;

public class ShaderUniform
{
    private final /* synthetic */ FloatBuffer uniformFloatBuffer;
    private final /* synthetic */ int uniformType;
    private final /* synthetic */ int uniformCount;
    private final /* synthetic */ ShaderManager shaderManager;
    private final /* synthetic */ IntBuffer uniformIntBuffer;
    private /* synthetic */ int uniformLocation;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ String shaderName;
    private /* synthetic */ boolean field_148105_h;
    
    public String getShaderName() {
        return this.shaderName;
    }
    
    public void set(final Matrix4f llllllllllllllIIIlIlIIIlIIllIIlI) {
        this.set(llllllllllllllIIIlIlIIIlIIllIIlI.m00, llllllllllllllIIIlIlIIIlIIllIIlI.m01, llllllllllllllIIIlIlIIIlIIllIIlI.m02, llllllllllllllIIIlIlIIIlIIllIIlI.m03, llllllllllllllIIIlIlIIIlIIllIIlI.m10, llllllllllllllIIIlIlIIIlIIllIIlI.m11, llllllllllllllIIIlIlIIIlIIllIIlI.m12, llllllllllllllIIIlIlIIIlIIllIIlI.m13, llllllllllllllIIIlIlIIIlIIllIIlI.m20, llllllllllllllIIIlIlIIIlIIllIIlI.m21, llllllllllllllIIIlIlIIIlIIllIIlI.m22, llllllllllllllIIIlIlIIIlIIllIIlI.m23, llllllllllllllIIIlIlIIIlIIllIIlI.m30, llllllllllllllIIIlIlIIIlIIllIIlI.m31, llllllllllllllIIIlIlIIIlIIllIIlI.m32, llllllllllllllIIIlIlIIIlIIllIIlI.m33);
    }
    
    private void uploadInt() {
        switch (this.uniformType) {
            case 0: {
                OpenGlHelper.glUniform1(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 1: {
                OpenGlHelper.glUniform2(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 2: {
                OpenGlHelper.glUniform3(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 3: {
                OpenGlHelper.glUniform4(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            default: {
                ShaderUniform.logger.warn(String.valueOf(new StringBuilder("Uniform.upload called, but count value (").append(this.uniformCount).append(") is ").append(" not in the range of 1 to 4. Ignoring.")));
                break;
            }
        }
    }
    
    public void upload() {
        if (!this.field_148105_h) {}
        this.field_148105_h = false;
        if (this.uniformType <= 3) {
            this.uploadInt();
        }
        else if (this.uniformType <= 7) {
            this.uploadFloat();
        }
        else {
            if (this.uniformType > 10) {
                ShaderUniform.logger.warn(String.valueOf(new StringBuilder("Uniform.upload called, but type value (").append(this.uniformType).append(") is not ").append("a valid type. Ignoring.")));
                return;
            }
            this.uploadFloatMatrix();
        }
    }
    
    public void set(final float llllllllllllllIIIlIlIIIlIlIlIllI, final float llllllllllllllIIIlIlIIIlIlIIIlII, final float llllllllllllllIIIlIlIIIlIlIlIlII, final float llllllllllllllIIIlIlIIIlIlIlIIll, final float llllllllllllllIIIlIlIIIlIlIIIIIl, final float llllllllllllllIIIlIlIIIlIlIlIIIl, final float llllllllllllllIIIlIlIIIlIlIlIIII, final float llllllllllllllIIIlIlIIIlIlIIllll, final float llllllllllllllIIIlIlIIIlIIllllIl, final float llllllllllllllIIIlIlIIIlIIllllII, final float llllllllllllllIIIlIlIIIlIlIIllII, final float llllllllllllllIIIlIlIIIlIlIIlIll, final float llllllllllllllIIIlIlIIIlIIlllIIl, final float llllllllllllllIIIlIlIIIlIIlllIII, final float llllllllllllllIIIlIlIIIlIlIIlIII, final float llllllllllllllIIIlIlIIIlIIllIllI) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, llllllllllllllIIIlIlIIIlIlIlIllI);
        this.uniformFloatBuffer.put(1, llllllllllllllIIIlIlIIIlIlIIIlII);
        this.uniformFloatBuffer.put(2, llllllllllllllIIIlIlIIIlIlIlIlII);
        this.uniformFloatBuffer.put(3, llllllllllllllIIIlIlIIIlIlIlIIll);
        this.uniformFloatBuffer.put(4, llllllllllllllIIIlIlIIIlIlIIIIIl);
        this.uniformFloatBuffer.put(5, llllllllllllllIIIlIlIIIlIlIlIIIl);
        this.uniformFloatBuffer.put(6, llllllllllllllIIIlIlIIIlIlIlIIII);
        this.uniformFloatBuffer.put(7, llllllllllllllIIIlIlIIIlIlIIllll);
        this.uniformFloatBuffer.put(8, llllllllllllllIIIlIlIIIlIIllllIl);
        this.uniformFloatBuffer.put(9, llllllllllllllIIIlIlIIIlIIllllII);
        this.uniformFloatBuffer.put(10, llllllllllllllIIIlIlIIIlIlIIllII);
        this.uniformFloatBuffer.put(11, llllllllllllllIIIlIlIIIlIlIIlIll);
        this.uniformFloatBuffer.put(12, llllllllllllllIIIlIlIIIlIIlllIIl);
        this.uniformFloatBuffer.put(13, llllllllllllllIIIlIlIIIlIIlllIII);
        this.uniformFloatBuffer.put(14, llllllllllllllIIIlIlIIIlIlIIlIII);
        this.uniformFloatBuffer.put(15, llllllllllllllIIIlIlIIIlIIllIllI);
        this.markDirty();
    }
    
    private void uploadFloat() {
        switch (this.uniformType) {
            case 4: {
                OpenGlHelper.glUniform1(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 5: {
                OpenGlHelper.glUniform2(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 6: {
                OpenGlHelper.glUniform3(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 7: {
                OpenGlHelper.glUniform4(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            default: {
                ShaderUniform.logger.warn(String.valueOf(new StringBuilder("Uniform.upload called, but count value (").append(this.uniformCount).append(") is ").append("not in the range of 1 to 4. Ignoring.")));
                break;
            }
        }
    }
    
    private void markDirty() {
        this.field_148105_h = true;
        if (this.shaderManager != null) {
            this.shaderManager.markDirty();
        }
    }
    
    public void set(final float llllllllllllllIIIlIlIIIllIlIIIlI, final float llllllllllllllIIIlIlIIIllIIlllIl, final float llllllllllllllIIIlIlIIIllIIlllII) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, llllllllllllllIIIlIlIIIllIlIIIlI);
        this.uniformFloatBuffer.put(1, llllllllllllllIIIlIlIIIllIIlllIl);
        this.uniformFloatBuffer.put(2, llllllllllllllIIIlIlIIIllIIlllII);
        this.markDirty();
    }
    
    public void set(final float llllllllllllllIIIlIlIIIllIlIlIIl, final float llllllllllllllIIIlIlIIIllIlIlIll) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, llllllllllllllIIIlIlIIIllIlIlIIl);
        this.uniformFloatBuffer.put(1, llllllllllllllIIIlIlIIIllIlIlIll);
        this.markDirty();
    }
    
    private void uploadFloatMatrix() {
        switch (this.uniformType) {
            case 8: {
                OpenGlHelper.glUniformMatrix2(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
            case 9: {
                OpenGlHelper.glUniformMatrix3(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
            case 10: {
                OpenGlHelper.glUniformMatrix4(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
        }
    }
    
    static {
        __OBFID = "CL_00001046";
        logger = LogManager.getLogger();
    }
    
    public ShaderUniform(final String llllllllllllllIIIlIlIIIlllIlIIIl, final int llllllllllllllIIIlIlIIIlllIlIIII, final int llllllllllllllIIIlIlIIIlllIIllll, final ShaderManager llllllllllllllIIIlIlIIIlllIIlIIl) {
        this.shaderName = llllllllllllllIIIlIlIIIlllIlIIIl;
        this.uniformCount = llllllllllllllIIIlIlIIIlllIIllll;
        this.uniformType = llllllllllllllIIIlIlIIIlllIlIIII;
        this.shaderManager = llllllllllllllIIIlIlIIIlllIIlIIl;
        if (llllllllllllllIIIlIlIIIlllIlIIII <= 3) {
            this.uniformIntBuffer = BufferUtils.createIntBuffer(llllllllllllllIIIlIlIIIlllIIllll);
            this.uniformFloatBuffer = null;
        }
        else {
            this.uniformIntBuffer = null;
            this.uniformFloatBuffer = BufferUtils.createFloatBuffer(llllllllllllllIIIlIlIIIlllIIllll);
        }
        this.uniformLocation = -1;
        this.markDirty();
    }
    
    public void set(final float llllllllllllllIIIlIlIIIllIIlIIII, final float llllllllllllllIIIlIlIIIllIIIllll, final float llllllllllllllIIIlIlIIIllIIlIIll, final float llllllllllllllIIIlIlIIIllIIlIIlI) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(llllllllllllllIIIlIlIIIllIIlIIII);
        this.uniformFloatBuffer.put(llllllllllllllIIIlIlIIIllIIIllll);
        this.uniformFloatBuffer.put(llllllllllllllIIIlIlIIIllIIlIIll);
        this.uniformFloatBuffer.put(llllllllllllllIIIlIlIIIllIIlIIlI);
        this.uniformFloatBuffer.flip();
        this.markDirty();
    }
    
    public static int parseType(final String llllllllllllllIIIlIlIIIlllIIIIll) {
        byte llllllllllllllIIIlIlIIIlllIIIIlI = -1;
        if (llllllllllllllIIIlIlIIIlllIIIIll.equals("int")) {
            llllllllllllllIIIlIlIIIlllIIIIlI = 0;
        }
        else if (llllllllllllllIIIlIlIIIlllIIIIll.equals("float")) {
            llllllllllllllIIIlIlIIIlllIIIIlI = 4;
        }
        else if (llllllllllllllIIIlIlIIIlllIIIIll.startsWith("matrix")) {
            if (llllllllllllllIIIlIlIIIlllIIIIll.endsWith("2x2")) {
                llllllllllllllIIIlIlIIIlllIIIIlI = 8;
            }
            else if (llllllllllllllIIIlIlIIIlllIIIIll.endsWith("3x3")) {
                llllllllllllllIIIlIlIIIlllIIIIlI = 9;
            }
            else if (llllllllllllllIIIlIlIIIlllIIIIll.endsWith("4x4")) {
                llllllllllllllIIIlIlIIIlllIIIIlI = 10;
            }
        }
        return llllllllllllllIIIlIlIIIlllIIIIlI;
    }
    
    public void set(final int llllllllllllllIIIlIlIIIlIlllIlll, final int llllllllllllllIIIlIlIIIlIlllIIIl, final int llllllllllllllIIIlIlIIIlIlllIlIl, final int llllllllllllllIIIlIlIIIlIlllIlII) {
        this.uniformIntBuffer.position(0);
        if (this.uniformType >= 0) {
            this.uniformIntBuffer.put(0, llllllllllllllIIIlIlIIIlIlllIlll);
        }
        if (this.uniformType >= 1) {
            this.uniformIntBuffer.put(1, llllllllllllllIIIlIlIIIlIlllIIIl);
        }
        if (this.uniformType >= 2) {
            this.uniformIntBuffer.put(2, llllllllllllllIIIlIlIIIlIlllIlIl);
        }
        if (this.uniformType >= 3) {
            this.uniformIntBuffer.put(3, llllllllllllllIIIlIlIIIlIlllIlII);
        }
        this.markDirty();
    }
    
    public void set(final float llllllllllllllIIIlIlIIIllIllIIIl) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, llllllllllllllIIIlIlIIIllIllIIIl);
        this.markDirty();
    }
    
    public void func_148092_b(final float llllllllllllllIIIlIlIIIllIIIIIIl, final float llllllllllllllIIIlIlIIIllIIIIIII, final float llllllllllllllIIIlIlIIIllIIIIlII, final float llllllllllllllIIIlIlIIIllIIIIIll) {
        this.uniformFloatBuffer.position(0);
        if (this.uniformType >= 4) {
            this.uniformFloatBuffer.put(0, llllllllllllllIIIlIlIIIllIIIIIIl);
        }
        if (this.uniformType >= 5) {
            this.uniformFloatBuffer.put(1, llllllllllllllIIIlIlIIIllIIIIIII);
        }
        if (this.uniformType >= 6) {
            this.uniformFloatBuffer.put(2, llllllllllllllIIIlIlIIIllIIIIlII);
        }
        if (this.uniformType >= 7) {
            this.uniformFloatBuffer.put(3, llllllllllllllIIIlIlIIIllIIIIIll);
        }
        this.markDirty();
    }
    
    public void set(final float[] llllllllllllllIIIlIlIIIlIllIlIIl) {
        if (llllllllllllllIIIlIlIIIlIllIlIIl.length < this.uniformCount) {
            ShaderUniform.logger.warn(String.valueOf(new StringBuilder("Uniform.set called with a too-small value array (expected ").append(this.uniformCount).append(", got ").append(llllllllllllllIIIlIlIIIlIllIlIIl.length).append("). Ignoring.")));
        }
        else {
            this.uniformFloatBuffer.position(0);
            this.uniformFloatBuffer.put(llllllllllllllIIIlIlIIIlIllIlIIl);
            this.uniformFloatBuffer.position(0);
            this.markDirty();
        }
    }
    
    public void setUniformLocation(final int llllllllllllllIIIlIlIIIllIlllIlI) {
        this.uniformLocation = llllllllllllllIIIlIlIIIllIlllIlI;
    }
}
