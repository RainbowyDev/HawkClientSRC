package net.minecraft.client.renderer.culling;

import java.nio.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class ClippingHelperImpl extends ClippingHelper
{
    private static /* synthetic */ ClippingHelperImpl instance;
    private /* synthetic */ FloatBuffer modelviewMatrixBuffer;
    private /* synthetic */ FloatBuffer projectionMatrixBuffer;
    private /* synthetic */ FloatBuffer field_78564_h;
    
    public ClippingHelperImpl() {
        this.projectionMatrixBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.modelviewMatrixBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.field_78564_h = GLAllocation.createDirectFloatBuffer(16);
    }
    
    public static ClippingHelper getInstance() {
        ClippingHelperImpl.instance.init();
        return ClippingHelperImpl.instance;
    }
    
    private void func_180547_a(final float[] llllllllllllllIlllIIIIIIIIlIlIll) {
        final float llllllllllllllIlllIIIIIIIIlIllII = MathHelper.sqrt_float(llllllllllllllIlllIIIIIIIIlIlIll[0] * llllllllllllllIlllIIIIIIIIlIlIll[0] + llllllllllllllIlllIIIIIIIIlIlIll[1] * llllllllllllllIlllIIIIIIIIlIlIll[1] + llllllllllllllIlllIIIIIIIIlIlIll[2] * llllllllllllllIlllIIIIIIIIlIlIll[2]);
        final int n = 0;
        llllllllllllllIlllIIIIIIIIlIlIll[n] /= llllllllllllllIlllIIIIIIIIlIllII;
        final int n2 = 1;
        llllllllllllllIlllIIIIIIIIlIlIll[n2] /= llllllllllllllIlllIIIIIIIIlIllII;
        final int n3 = 2;
        llllllllllllllIlllIIIIIIIIlIlIll[n3] /= llllllllllllllIlllIIIIIIIIlIllII;
        final int n4 = 3;
        llllllllllllllIlllIIIIIIIIlIlIll[n4] /= llllllllllllllIlllIIIIIIIIlIllII;
    }
    
    public void init() {
        this.projectionMatrixBuffer.clear();
        this.modelviewMatrixBuffer.clear();
        this.field_78564_h.clear();
        GlStateManager.getFloat(2983, this.projectionMatrixBuffer);
        GlStateManager.getFloat(2982, this.modelviewMatrixBuffer);
        final float[] llllllllllllllIlllIIIIIIIIIlllll = this.field_178625_b;
        final float[] llllllllllllllIlllIIIIIIIIIllllI = this.field_178626_c;
        this.projectionMatrixBuffer.flip().limit(16);
        this.projectionMatrixBuffer.get(llllllllllllllIlllIIIIIIIIIlllll);
        this.modelviewMatrixBuffer.flip().limit(16);
        this.modelviewMatrixBuffer.get(llllllllllllllIlllIIIIIIIIIllllI);
        this.clippingMatrix[0] = llllllllllllllIlllIIIIIIIIIllllI[0] * llllllllllllllIlllIIIIIIIIIlllll[0] + llllllllllllllIlllIIIIIIIIIllllI[1] * llllllllllllllIlllIIIIIIIIIlllll[4] + llllllllllllllIlllIIIIIIIIIllllI[2] * llllllllllllllIlllIIIIIIIIIlllll[8] + llllllllllllllIlllIIIIIIIIIllllI[3] * llllllllllllllIlllIIIIIIIIIlllll[12];
        this.clippingMatrix[1] = llllllllllllllIlllIIIIIIIIIllllI[0] * llllllllllllllIlllIIIIIIIIIlllll[1] + llllllllllllllIlllIIIIIIIIIllllI[1] * llllllllllllllIlllIIIIIIIIIlllll[5] + llllllllllllllIlllIIIIIIIIIllllI[2] * llllllllllllllIlllIIIIIIIIIlllll[9] + llllllllllllllIlllIIIIIIIIIllllI[3] * llllllllllllllIlllIIIIIIIIIlllll[13];
        this.clippingMatrix[2] = llllllllllllllIlllIIIIIIIIIllllI[0] * llllllllllllllIlllIIIIIIIIIlllll[2] + llllllllllllllIlllIIIIIIIIIllllI[1] * llllllllllllllIlllIIIIIIIIIlllll[6] + llllllllllllllIlllIIIIIIIIIllllI[2] * llllllllllllllIlllIIIIIIIIIlllll[10] + llllllllllllllIlllIIIIIIIIIllllI[3] * llllllllllllllIlllIIIIIIIIIlllll[14];
        this.clippingMatrix[3] = llllllllllllllIlllIIIIIIIIIllllI[0] * llllllllllllllIlllIIIIIIIIIlllll[3] + llllllllllllllIlllIIIIIIIIIllllI[1] * llllllllllllllIlllIIIIIIIIIlllll[7] + llllllllllllllIlllIIIIIIIIIllllI[2] * llllllllllllllIlllIIIIIIIIIlllll[11] + llllllllllllllIlllIIIIIIIIIllllI[3] * llllllllllllllIlllIIIIIIIIIlllll[15];
        this.clippingMatrix[4] = llllllllllllllIlllIIIIIIIIIllllI[4] * llllllllllllllIlllIIIIIIIIIlllll[0] + llllllllllllllIlllIIIIIIIIIllllI[5] * llllllllllllllIlllIIIIIIIIIlllll[4] + llllllllllllllIlllIIIIIIIIIllllI[6] * llllllllllllllIlllIIIIIIIIIlllll[8] + llllllllllllllIlllIIIIIIIIIllllI[7] * llllllllllllllIlllIIIIIIIIIlllll[12];
        this.clippingMatrix[5] = llllllllllllllIlllIIIIIIIIIllllI[4] * llllllllllllllIlllIIIIIIIIIlllll[1] + llllllllllllllIlllIIIIIIIIIllllI[5] * llllllllllllllIlllIIIIIIIIIlllll[5] + llllllllllllllIlllIIIIIIIIIllllI[6] * llllllllllllllIlllIIIIIIIIIlllll[9] + llllllllllllllIlllIIIIIIIIIllllI[7] * llllllllllllllIlllIIIIIIIIIlllll[13];
        this.clippingMatrix[6] = llllllllllllllIlllIIIIIIIIIllllI[4] * llllllllllllllIlllIIIIIIIIIlllll[2] + llllllllllllllIlllIIIIIIIIIllllI[5] * llllllllllllllIlllIIIIIIIIIlllll[6] + llllllllllllllIlllIIIIIIIIIllllI[6] * llllllllllllllIlllIIIIIIIIIlllll[10] + llllllllllllllIlllIIIIIIIIIllllI[7] * llllllllllllllIlllIIIIIIIIIlllll[14];
        this.clippingMatrix[7] = llllllllllllllIlllIIIIIIIIIllllI[4] * llllllllllllllIlllIIIIIIIIIlllll[3] + llllllllllllllIlllIIIIIIIIIllllI[5] * llllllllllllllIlllIIIIIIIIIlllll[7] + llllllllllllllIlllIIIIIIIIIllllI[6] * llllllllllllllIlllIIIIIIIIIlllll[11] + llllllllllllllIlllIIIIIIIIIllllI[7] * llllllllllllllIlllIIIIIIIIIlllll[15];
        this.clippingMatrix[8] = llllllllllllllIlllIIIIIIIIIllllI[8] * llllllllllllllIlllIIIIIIIIIlllll[0] + llllllllllllllIlllIIIIIIIIIllllI[9] * llllllllllllllIlllIIIIIIIIIlllll[4] + llllllllllllllIlllIIIIIIIIIllllI[10] * llllllllllllllIlllIIIIIIIIIlllll[8] + llllllllllllllIlllIIIIIIIIIllllI[11] * llllllllllllllIlllIIIIIIIIIlllll[12];
        this.clippingMatrix[9] = llllllllllllllIlllIIIIIIIIIllllI[8] * llllllllllllllIlllIIIIIIIIIlllll[1] + llllllllllllllIlllIIIIIIIIIllllI[9] * llllllllllllllIlllIIIIIIIIIlllll[5] + llllllllllllllIlllIIIIIIIIIllllI[10] * llllllllllllllIlllIIIIIIIIIlllll[9] + llllllllllllllIlllIIIIIIIIIllllI[11] * llllllllllllllIlllIIIIIIIIIlllll[13];
        this.clippingMatrix[10] = llllllllllllllIlllIIIIIIIIIllllI[8] * llllllllllllllIlllIIIIIIIIIlllll[2] + llllllllllllllIlllIIIIIIIIIllllI[9] * llllllllllllllIlllIIIIIIIIIlllll[6] + llllllllllllllIlllIIIIIIIIIllllI[10] * llllllllllllllIlllIIIIIIIIIlllll[10] + llllllllllllllIlllIIIIIIIIIllllI[11] * llllllllllllllIlllIIIIIIIIIlllll[14];
        this.clippingMatrix[11] = llllllllllllllIlllIIIIIIIIIllllI[8] * llllllllllllllIlllIIIIIIIIIlllll[3] + llllllllllllllIlllIIIIIIIIIllllI[9] * llllllllllllllIlllIIIIIIIIIlllll[7] + llllllllllllllIlllIIIIIIIIIllllI[10] * llllllllllllllIlllIIIIIIIIIlllll[11] + llllllllllllllIlllIIIIIIIIIllllI[11] * llllllllllllllIlllIIIIIIIIIlllll[15];
        this.clippingMatrix[12] = llllllllllllllIlllIIIIIIIIIllllI[12] * llllllllllllllIlllIIIIIIIIIlllll[0] + llllllllllllllIlllIIIIIIIIIllllI[13] * llllllllllllllIlllIIIIIIIIIlllll[4] + llllllllllllllIlllIIIIIIIIIllllI[14] * llllllllllllllIlllIIIIIIIIIlllll[8] + llllllllllllllIlllIIIIIIIIIllllI[15] * llllllllllllllIlllIIIIIIIIIlllll[12];
        this.clippingMatrix[13] = llllllllllllllIlllIIIIIIIIIllllI[12] * llllllllllllllIlllIIIIIIIIIlllll[1] + llllllllllllllIlllIIIIIIIIIllllI[13] * llllllllllllllIlllIIIIIIIIIlllll[5] + llllllllllllllIlllIIIIIIIIIllllI[14] * llllllllllllllIlllIIIIIIIIIlllll[9] + llllllllllllllIlllIIIIIIIIIllllI[15] * llllllllllllllIlllIIIIIIIIIlllll[13];
        this.clippingMatrix[14] = llllllllllllllIlllIIIIIIIIIllllI[12] * llllllllllllllIlllIIIIIIIIIlllll[2] + llllllllllllllIlllIIIIIIIIIllllI[13] * llllllllllllllIlllIIIIIIIIIlllll[6] + llllllllllllllIlllIIIIIIIIIllllI[14] * llllllllllllllIlllIIIIIIIIIlllll[10] + llllllllllllllIlllIIIIIIIIIllllI[15] * llllllllllllllIlllIIIIIIIIIlllll[14];
        this.clippingMatrix[15] = llllllllllllllIlllIIIIIIIIIllllI[12] * llllllllllllllIlllIIIIIIIIIlllll[3] + llllllllllllllIlllIIIIIIIIIllllI[13] * llllllllllllllIlllIIIIIIIIIlllll[7] + llllllllllllllIlllIIIIIIIIIllllI[14] * llllllllllllllIlllIIIIIIIIIlllll[11] + llllllllllllllIlllIIIIIIIIIllllI[15] * llllllllllllllIlllIIIIIIIIIlllll[15];
        final float[] llllllllllllllIlllIIIIIIIIIlllIl = this.frustum[0];
        llllllllllllllIlllIIIIIIIIIlllIl[0] = this.clippingMatrix[3] - this.clippingMatrix[0];
        llllllllllllllIlllIIIIIIIIIlllIl[1] = this.clippingMatrix[7] - this.clippingMatrix[4];
        llllllllllllllIlllIIIIIIIIIlllIl[2] = this.clippingMatrix[11] - this.clippingMatrix[8];
        llllllllllllllIlllIIIIIIIIIlllIl[3] = this.clippingMatrix[15] - this.clippingMatrix[12];
        this.func_180547_a(llllllllllllllIlllIIIIIIIIIlllIl);
        final float[] llllllllllllllIlllIIIIIIIIIlllII = this.frustum[1];
        llllllllllllllIlllIIIIIIIIIlllII[0] = this.clippingMatrix[3] + this.clippingMatrix[0];
        llllllllllllllIlllIIIIIIIIIlllII[1] = this.clippingMatrix[7] + this.clippingMatrix[4];
        llllllllllllllIlllIIIIIIIIIlllII[2] = this.clippingMatrix[11] + this.clippingMatrix[8];
        llllllllllllllIlllIIIIIIIIIlllII[3] = this.clippingMatrix[15] + this.clippingMatrix[12];
        this.func_180547_a(llllllllllllllIlllIIIIIIIIIlllII);
        final float[] llllllllllllllIlllIIIIIIIIIllIll = this.frustum[2];
        llllllllllllllIlllIIIIIIIIIllIll[0] = this.clippingMatrix[3] + this.clippingMatrix[1];
        llllllllllllllIlllIIIIIIIIIllIll[1] = this.clippingMatrix[7] + this.clippingMatrix[5];
        llllllllllllllIlllIIIIIIIIIllIll[2] = this.clippingMatrix[11] + this.clippingMatrix[9];
        llllllllllllllIlllIIIIIIIIIllIll[3] = this.clippingMatrix[15] + this.clippingMatrix[13];
        this.func_180547_a(llllllllllllllIlllIIIIIIIIIllIll);
        final float[] llllllllllllllIlllIIIIIIIIIllIlI = this.frustum[3];
        llllllllllllllIlllIIIIIIIIIllIlI[0] = this.clippingMatrix[3] - this.clippingMatrix[1];
        llllllllllllllIlllIIIIIIIIIllIlI[1] = this.clippingMatrix[7] - this.clippingMatrix[5];
        llllllllllllllIlllIIIIIIIIIllIlI[2] = this.clippingMatrix[11] - this.clippingMatrix[9];
        llllllllllllllIlllIIIIIIIIIllIlI[3] = this.clippingMatrix[15] - this.clippingMatrix[13];
        this.func_180547_a(llllllllllllllIlllIIIIIIIIIllIlI);
        final float[] llllllllllllllIlllIIIIIIIIIllIIl = this.frustum[4];
        llllllllllllllIlllIIIIIIIIIllIIl[0] = this.clippingMatrix[3] - this.clippingMatrix[2];
        llllllllllllllIlllIIIIIIIIIllIIl[1] = this.clippingMatrix[7] - this.clippingMatrix[6];
        llllllllllllllIlllIIIIIIIIIllIIl[2] = this.clippingMatrix[11] - this.clippingMatrix[10];
        llllllllllllllIlllIIIIIIIIIllIIl[3] = this.clippingMatrix[15] - this.clippingMatrix[14];
        this.func_180547_a(llllllllllllllIlllIIIIIIIIIllIIl);
        final float[] llllllllllllllIlllIIIIIIIIIllIII = this.frustum[5];
        llllllllllllllIlllIIIIIIIIIllIII[0] = this.clippingMatrix[3] + this.clippingMatrix[2];
        llllllllllllllIlllIIIIIIIIIllIII[1] = this.clippingMatrix[7] + this.clippingMatrix[6];
        llllllllllllllIlllIIIIIIIIIllIII[2] = this.clippingMatrix[11] + this.clippingMatrix[10];
        llllllllllllllIlllIIIIIIIIIllIII[3] = this.clippingMatrix[15] + this.clippingMatrix[14];
        this.func_180547_a(llllllllllllllIlllIIIIIIIIIllIII);
    }
    
    static {
        __OBFID = "CL_00000975";
        ClippingHelperImpl.instance = new ClippingHelperImpl();
    }
}
