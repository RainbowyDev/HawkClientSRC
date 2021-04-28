package net.minecraft.client.renderer.culling;

public class ClippingHelper
{
    public /* synthetic */ float[][] frustum;
    public /* synthetic */ float[] field_178626_c;
    public /* synthetic */ float[] field_178625_b;
    public /* synthetic */ float[] clippingMatrix;
    
    static {
        __OBFID = "CL_00000977";
    }
    
    public boolean isBoxInFrustum(final double llllllllllllllIIIIllIIIIIIlIllIl, final double llllllllllllllIIIIllIIIIIIlllIll, final double llllllllllllllIIIIllIIIIIIlllIlI, final double llllllllllllllIIIIllIIIIIIlllIIl, final double llllllllllllllIIIIllIIIIIIlIlIIl, final double llllllllllllllIIIIllIIIIIIlIlIII) {
        final float llllllllllllllIIIIllIIIIIIllIllI = (float)llllllllllllllIIIIllIIIIIIlIllIl;
        final float llllllllllllllIIIIllIIIIIIllIlIl = (float)llllllllllllllIIIIllIIIIIIlllIll;
        final float llllllllllllllIIIIllIIIIIIllIlII = (float)llllllllllllllIIIIllIIIIIIlllIlI;
        final float llllllllllllllIIIIllIIIIIIllIIll = (float)llllllllllllllIIIIllIIIIIIlllIIl;
        final float llllllllllllllIIIIllIIIIIIllIIlI = (float)llllllllllllllIIIIllIIIIIIlIlIIl;
        final float llllllllllllllIIIIllIIIIIIllIIIl = (float)llllllllllllllIIIIllIIIIIIlIlIII;
        for (int llllllllllllllIIIIllIIIIIIllIIII = 0; llllllllllllllIIIIllIIIIIIllIIII < 6; ++llllllllllllllIIIIllIIIIIIllIIII) {
            final float[] llllllllllllllIIIIllIIIIIIlIllll = this.frustum[llllllllllllllIIIIllIIIIIIllIIII];
            if (this.dot(llllllllllllllIIIIllIIIIIIlIllll, llllllllllllllIIIIllIIIIIIllIllI, llllllllllllllIIIIllIIIIIIllIlIl, llllllllllllllIIIIllIIIIIIllIlII) <= 0.0f && this.dot(llllllllllllllIIIIllIIIIIIlIllll, llllllllllllllIIIIllIIIIIIllIIll, llllllllllllllIIIIllIIIIIIllIlIl, llllllllllllllIIIIllIIIIIIllIlII) <= 0.0f && this.dot(llllllllllllllIIIIllIIIIIIlIllll, llllllllllllllIIIIllIIIIIIllIllI, llllllllllllllIIIIllIIIIIIllIIlI, llllllllllllllIIIIllIIIIIIllIlII) <= 0.0f && this.dot(llllllllllllllIIIIllIIIIIIlIllll, llllllllllllllIIIIllIIIIIIllIIll, llllllllllllllIIIIllIIIIIIllIIlI, llllllllllllllIIIIllIIIIIIllIlII) <= 0.0f && this.dot(llllllllllllllIIIIllIIIIIIlIllll, llllllllllllllIIIIllIIIIIIllIllI, llllllllllllllIIIIllIIIIIIllIlIl, llllllllllllllIIIIllIIIIIIllIIIl) <= 0.0f && this.dot(llllllllllllllIIIIllIIIIIIlIllll, llllllllllllllIIIIllIIIIIIllIIll, llllllllllllllIIIIllIIIIIIllIlIl, llllllllllllllIIIIllIIIIIIllIIIl) <= 0.0f && this.dot(llllllllllllllIIIIllIIIIIIlIllll, llllllllllllllIIIIllIIIIIIllIllI, llllllllllllllIIIIllIIIIIIllIIlI, llllllllllllllIIIIllIIIIIIllIIIl) <= 0.0f && this.dot(llllllllllllllIIIIllIIIIIIlIllll, llllllllllllllIIIIllIIIIIIllIIll, llllllllllllllIIIIllIIIIIIllIIlI, llllllllllllllIIIIllIIIIIIllIIIl) <= 0.0f) {
                return false;
            }
        }
        return true;
    }
    
    public ClippingHelper() {
        this.frustum = new float[6][4];
        this.field_178625_b = new float[16];
        this.field_178626_c = new float[16];
        this.clippingMatrix = new float[16];
    }
    
    private float dot(final float[] llllllllllllllIIIIllIIIIIlIlIlII, final float llllllllllllllIIIIllIIIIIlIlIIll, final float llllllllllllllIIIIllIIIIIlIIlllI, final float llllllllllllllIIIIllIIIIIlIlIIIl) {
        return llllllllllllllIIIIllIIIIIlIlIlII[0] * llllllllllllllIIIIllIIIIIlIlIIll + llllllllllllllIIIIllIIIIIlIlIlII[1] * llllllllllllllIIIIllIIIIIlIIlllI + llllllllllllllIIIIllIIIIIlIlIlII[2] * llllllllllllllIIIIllIIIIIlIlIIIl + llllllllllllllIIIIllIIIIIlIlIlII[3];
    }
}
