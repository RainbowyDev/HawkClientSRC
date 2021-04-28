package shadersmod.client;

import net.minecraft.client.renderer.culling.*;
import net.minecraft.util.*;

public class ClippingHelperShadow extends ClippingHelper
{
    /* synthetic */ int shadowClipPlaneCount;
    /* synthetic */ float[][] shadowClipPlanes;
    /* synthetic */ float[] frustumTest;
    /* synthetic */ float[] matInvMP;
    private static /* synthetic */ ClippingHelperShadow instance;
    /* synthetic */ float[] vecIntersection;
    
    private void normalizePlane(final float[] llllllllllllllIIIlIIlIllIlIIlIlI) {
        final float llllllllllllllIIIlIIlIllIlIIlIll = MathHelper.sqrt_float(llllllllllllllIIIlIIlIllIlIIlIlI[0] * llllllllllllllIIIlIIlIllIlIIlIlI[0] + llllllllllllllIIIlIIlIllIlIIlIlI[1] * llllllllllllllIIIlIIlIllIlIIlIlI[1] + llllllllllllllIIIlIIlIllIlIIlIlI[2] * llllllllllllllIIIlIIlIllIlIIlIlI[2]);
        final int n = 0;
        llllllllllllllIIIlIIlIllIlIIlIlI[n] /= llllllllllllllIIIlIIlIllIlIIlIll;
        final int n2 = 1;
        llllllllllllllIIIlIIlIllIlIIlIlI[n2] /= llllllllllllllIIIlIIlIllIlIIlIll;
        final int n3 = 2;
        llllllllllllllIIIlIIlIllIlIIlIlI[n3] /= llllllllllllllIIIlIIlIllIlIIlIll;
        final int n4 = 3;
        llllllllllllllIIIlIIlIllIlIIlIlI[n4] /= llllllllllllllIIIlIIlIllIlIIlIll;
    }
    
    public void init() {
        final float[] llllllllllllllIIIlIIlIlIllIIIIlI = this.field_178625_b;
        final float[] llllllllllllllIIIlIIlIlIllIIIIIl = this.field_178626_c;
        final float[] llllllllllllllIIIlIIlIlIllIIIIII = this.clippingMatrix;
        System.arraycopy(Shaders.faProjection, 0, llllllllllllllIIIlIIlIlIllIIIIlI, 0, 16);
        System.arraycopy(Shaders.faModelView, 0, llllllllllllllIIIlIIlIlIllIIIIIl, 0, 16);
        SMath.multiplyMat4xMat4(llllllllllllllIIIlIIlIlIllIIIIII, llllllllllllllIIIlIIlIlIllIIIIIl, llllllllllllllIIIlIIlIlIllIIIIlI);
        this.assignPlane(this.frustum[0], llllllllllllllIIIlIIlIlIllIIIIII[3] - llllllllllllllIIIlIIlIlIllIIIIII[0], llllllllllllllIIIlIIlIlIllIIIIII[7] - llllllllllllllIIIlIIlIlIllIIIIII[4], llllllllllllllIIIlIIlIlIllIIIIII[11] - llllllllllllllIIIlIIlIlIllIIIIII[8], llllllllllllllIIIlIIlIlIllIIIIII[15] - llllllllllllllIIIlIIlIlIllIIIIII[12]);
        this.assignPlane(this.frustum[1], llllllllllllllIIIlIIlIlIllIIIIII[3] + llllllllllllllIIIlIIlIlIllIIIIII[0], llllllllllllllIIIlIIlIlIllIIIIII[7] + llllllllllllllIIIlIIlIlIllIIIIII[4], llllllllllllllIIIlIIlIlIllIIIIII[11] + llllllllllllllIIIlIIlIlIllIIIIII[8], llllllllllllllIIIlIIlIlIllIIIIII[15] + llllllllllllllIIIlIIlIlIllIIIIII[12]);
        this.assignPlane(this.frustum[2], llllllllllllllIIIlIIlIlIllIIIIII[3] + llllllllllllllIIIlIIlIlIllIIIIII[1], llllllllllllllIIIlIIlIlIllIIIIII[7] + llllllllllllllIIIlIIlIlIllIIIIII[5], llllllllllllllIIIlIIlIlIllIIIIII[11] + llllllllllllllIIIlIIlIlIllIIIIII[9], llllllllllllllIIIlIIlIlIllIIIIII[15] + llllllllllllllIIIlIIlIlIllIIIIII[13]);
        this.assignPlane(this.frustum[3], llllllllllllllIIIlIIlIlIllIIIIII[3] - llllllllllllllIIIlIIlIlIllIIIIII[1], llllllllllllllIIIlIIlIlIllIIIIII[7] - llllllllllllllIIIlIIlIlIllIIIIII[5], llllllllllllllIIIlIIlIlIllIIIIII[11] - llllllllllllllIIIlIIlIlIllIIIIII[9], llllllllllllllIIIlIIlIlIllIIIIII[15] - llllllllllllllIIIlIIlIlIllIIIIII[13]);
        this.assignPlane(this.frustum[4], llllllllllllllIIIlIIlIlIllIIIIII[3] - llllllllllllllIIIlIIlIlIllIIIIII[2], llllllllllllllIIIlIIlIlIllIIIIII[7] - llllllllllllllIIIlIIlIlIllIIIIII[6], llllllllllllllIIIlIIlIlIllIIIIII[11] - llllllllllllllIIIlIIlIlIllIIIIII[10], llllllllllllllIIIlIIlIlIllIIIIII[15] - llllllllllllllIIIlIIlIlIllIIIIII[14]);
        this.assignPlane(this.frustum[5], llllllllllllllIIIlIIlIlIllIIIIII[3] + llllllllllllllIIIlIIlIlIllIIIIII[2], llllllllllllllIIIlIIlIlIllIIIIII[7] + llllllllllllllIIIlIIlIlIllIIIIII[6], llllllllllllllIIIlIIlIlIllIIIIII[11] + llllllllllllllIIIlIIlIlIllIIIIII[10], llllllllllllllIIIlIIlIlIllIIIIII[15] + llllllllllllllIIIlIIlIlIllIIIIII[14]);
        final float[] llllllllllllllIIIlIIlIlIlIllllll = Shaders.shadowLightPositionVector;
        final float llllllllllllllIIIlIIlIlIlIlllllI = (float)this.dot3(this.frustum[0], llllllllllllllIIIlIIlIlIlIllllll);
        final float llllllllllllllIIIlIIlIlIlIllllIl = (float)this.dot3(this.frustum[1], llllllllllllllIIIlIIlIlIlIllllll);
        final float llllllllllllllIIIlIIlIlIlIllllII = (float)this.dot3(this.frustum[2], llllllllllllllIIIlIIlIlIlIllllll);
        final float llllllllllllllIIIlIIlIlIlIlllIll = (float)this.dot3(this.frustum[3], llllllllllllllIIIlIIlIlIlIllllll);
        final float llllllllllllllIIIlIIlIlIlIlllIlI = (float)this.dot3(this.frustum[4], llllllllllllllIIIlIIlIlIlIllllll);
        final float llllllllllllllIIIlIIlIlIlIlllIIl = (float)this.dot3(this.frustum[5], llllllllllllllIIIlIIlIlIlIllllll);
        this.shadowClipPlaneCount = 0;
        if (llllllllllllllIIIlIIlIlIlIlllllI >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0]);
            if (llllllllllllllIIIlIIlIlIlIlllllI > 0.0f) {
                if (llllllllllllllIIIlIIlIlIlIllllII < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0], this.frustum[2], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIll < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0], this.frustum[3], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIlI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0], this.frustum[4], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0], this.frustum[5], llllllllllllllIIIlIIlIlIlIllllll);
                }
            }
        }
        if (llllllllllllllIIIlIIlIlIlIllllIl >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1]);
            if (llllllllllllllIIIlIIlIlIlIllllIl > 0.0f) {
                if (llllllllllllllIIIlIIlIlIlIllllII < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1], this.frustum[2], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIll < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1], this.frustum[3], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIlI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1], this.frustum[4], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1], this.frustum[5], llllllllllllllIIIlIIlIlIlIllllll);
                }
            }
        }
        if (llllllllllllllIIIlIIlIlIlIllllII >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2]);
            if (llllllllllllllIIIlIIlIlIlIllllII > 0.0f) {
                if (llllllllllllllIIIlIIlIlIlIlllllI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2], this.frustum[0], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIllllIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2], this.frustum[1], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIlI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2], this.frustum[4], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2], this.frustum[5], llllllllllllllIIIlIIlIlIlIllllll);
                }
            }
        }
        if (llllllllllllllIIIlIIlIlIlIlllIll >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3]);
            if (llllllllllllllIIIlIIlIlIlIlllIll > 0.0f) {
                if (llllllllllllllIIIlIIlIlIlIlllllI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3], this.frustum[0], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIllllIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3], this.frustum[1], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIlI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3], this.frustum[4], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3], this.frustum[5], llllllllllllllIIIlIIlIlIlIllllll);
                }
            }
        }
        if (llllllllllllllIIIlIIlIlIlIlllIlI >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4]);
            if (llllllllllllllIIIlIIlIlIlIlllIlI > 0.0f) {
                if (llllllllllllllIIIlIIlIlIlIlllllI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4], this.frustum[0], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIllllIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4], this.frustum[1], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIllllII < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4], this.frustum[2], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIll < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4], this.frustum[3], llllllllllllllIIIlIIlIlIlIllllll);
                }
            }
        }
        if (llllllllllllllIIIlIIlIlIlIlllIIl >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5]);
            if (llllllllllllllIIIlIIlIlIlIlllIIl > 0.0f) {
                if (llllllllllllllIIIlIIlIlIlIlllllI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5], this.frustum[0], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIllllIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5], this.frustum[1], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIllllII < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5], this.frustum[2], llllllllllllllIIIlIIlIlIlIllllll);
                }
                if (llllllllllllllIIIlIIlIlIlIlllIll < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5], this.frustum[3], llllllllllllllIIIlIIlIlIlIllllll);
                }
            }
        }
    }
    
    static {
        ClippingHelperShadow.instance = new ClippingHelperShadow();
    }
    
    private double dot4(final float[] llllllllllllllIIIlIIlIllIlIllllI, final double llllllllllllllIIIlIIlIllIlIllIIl, final double llllllllllllllIIIlIIlIllIlIlllII, final double llllllllllllllIIIlIIlIllIlIllIll) {
        return llllllllllllllIIIlIIlIllIlIllllI[0] * llllllllllllllIIIlIIlIllIlIllIIl + llllllllllllllIIIlIIlIllIlIllllI[1] * llllllllllllllIIIlIIlIllIlIlllII + llllllllllllllIIIlIIlIllIlIllllI[2] * llllllllllllllIIIlIIlIllIlIllIll + llllllllllllllIIIlIIlIllIlIllllI[3];
    }
    
    public ClippingHelperShadow() {
        this.frustumTest = new float[6];
        this.shadowClipPlanes = new float[10][4];
        this.matInvMP = new float[16];
        this.vecIntersection = new float[4];
    }
    
    private float distance(final float llllllllllllllIIIlIIlIllIIIIIlIl, final float llllllllllllllIIIlIIlIllIIIIIlII, final float llllllllllllllIIIlIIlIlIllllllII, final float llllllllllllllIIIlIIlIllIIIIIIlI, final float llllllllllllllIIIlIIlIlIlllllIlI, final float llllllllllllllIIIlIIlIllIIIIIIII) {
        return this.length(llllllllllllllIIIlIIlIllIIIIIlIl - llllllllllllllIIIlIIlIllIIIIIIlI, llllllllllllllIIIlIIlIllIIIIIlII - llllllllllllllIIIlIIlIlIlllllIlI, llllllllllllllIIIlIIlIlIllllllII - llllllllllllllIIIlIIlIllIIIIIIII);
    }
    
    private void normalize3(final float[] llllllllllllllIIIlIIlIllIlIIIIll) {
        float llllllllllllllIIIlIIlIllIlIIIlII = MathHelper.sqrt_float(llllllllllllllIIIlIIlIllIlIIIIll[0] * llllllllllllllIIIlIIlIllIlIIIIll[0] + llllllllllllllIIIlIIlIllIlIIIIll[1] * llllllllllllllIIIlIIlIllIlIIIIll[1] + llllllllllllllIIIlIIlIllIlIIIIll[2] * llllllllllllllIIIlIIlIllIlIIIIll[2]);
        if (llllllllllllllIIIlIIlIllIlIIIlII == 0.0f) {
            llllllllllllllIIIlIIlIllIlIIIlII = 1.0f;
        }
        final int n = 0;
        llllllllllllllIIIlIIlIllIlIIIIll[n] /= llllllllllllllIIIlIIlIllIlIIIlII;
        final int n2 = 1;
        llllllllllllllIIIlIIlIllIlIIIIll[n2] /= llllllllllllllIIIlIIlIllIlIIIlII;
        final int n3 = 2;
        llllllllllllllIIIlIIlIllIlIIIIll[n3] /= llllllllllllllIIIlIIlIllIlIIIlII;
    }
    
    private void assignPlane(final float[] llllllllllllllIIIlIIlIllIIllIlII, final float llllllllllllllIIIlIIlIllIIlllIIl, final float llllllllllllllIIIlIIlIllIIllIIlI, final float llllllllllllllIIIlIIlIllIIllIlll, final float llllllllllllllIIIlIIlIllIIllIIII) {
        final float llllllllllllllIIIlIIlIllIIllIlIl = (float)Math.sqrt(llllllllllllllIIIlIIlIllIIlllIIl * llllllllllllllIIIlIIlIllIIlllIIl + llllllllllllllIIIlIIlIllIIllIIlI * llllllllllllllIIIlIIlIllIIllIIlI + llllllllllllllIIIlIIlIllIIllIlll * llllllllllllllIIIlIIlIllIIllIlll);
        llllllllllllllIIIlIIlIllIIllIlII[0] = llllllllllllllIIIlIIlIllIIlllIIl / llllllllllllllIIIlIIlIllIIllIlIl;
        llllllllllllllIIIlIIlIllIIllIlII[1] = llllllllllllllIIIlIIlIllIIllIIlI / llllllllllllllIIIlIIlIllIIllIlIl;
        llllllllllllllIIIlIIlIllIIllIlII[2] = llllllllllllllIIIlIIlIllIIllIlll / llllllllllllllIIIlIIlIllIIllIlIl;
        llllllllllllllIIIlIIlIllIIllIlII[3] = llllllllllllllIIIlIIlIllIIllIIII / llllllllllllllIIIlIIlIllIIllIlIl;
    }
    
    private float length(final float llllllllllllllIIIlIIlIllIIIlIIll, final float llllllllllllllIIIlIIlIllIIIIllll, final float llllllllllllllIIIlIIlIllIIIlIIIl) {
        return (float)Math.sqrt(llllllllllllllIIIlIIlIllIIIlIIll * llllllllllllllIIIlIIlIllIIIlIIll + llllllllllllllIIIlIIlIllIIIIllll * llllllllllllllIIIlIIlIllIIIIllll + llllllllllllllIIIlIIlIllIIIlIIIl * llllllllllllllIIIlIIlIllIIIlIIIl);
    }
    
    private void addShadowClipPlane(final float[] llllllllllllllIIIlIIlIllIIIllIII) {
        this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], llllllllllllllIIIlIIlIllIIIllIII);
    }
    
    @Override
    public boolean isBoxInFrustum(final double llllllllllllllIIIlIIlIllIllIlIll, final double llllllllllllllIIIlIIlIllIllIlIlI, final double llllllllllllllIIIlIIlIllIllIlIIl, final double llllllllllllllIIIlIIlIllIllIlIII, final double llllllllllllllIIIlIIlIllIlllIIII, final double llllllllllllllIIIlIIlIllIllIIllI) {
        for (int llllllllllllllIIIlIIlIllIllIlllI = 0; llllllllllllllIIIlIIlIllIllIlllI < this.shadowClipPlaneCount; ++llllllllllllllIIIlIIlIllIllIlllI) {
            final float[] llllllllllllllIIIlIIlIllIllIllIl = this.shadowClipPlanes[llllllllllllllIIIlIIlIllIllIlllI];
            if (this.dot4(llllllllllllllIIIlIIlIllIllIllIl, llllllllllllllIIIlIIlIllIllIlIll, llllllllllllllIIIlIIlIllIllIlIlI, llllllllllllllIIIlIIlIllIllIlIIl) <= 0.0 && this.dot4(llllllllllllllIIIlIIlIllIllIllIl, llllllllllllllIIIlIIlIllIllIlIII, llllllllllllllIIIlIIlIllIllIlIlI, llllllllllllllIIIlIIlIllIllIlIIl) <= 0.0 && this.dot4(llllllllllllllIIIlIIlIllIllIllIl, llllllllllllllIIIlIIlIllIllIlIll, llllllllllllllIIIlIIlIllIlllIIII, llllllllllllllIIIlIIlIllIllIlIIl) <= 0.0 && this.dot4(llllllllllllllIIIlIIlIllIllIllIl, llllllllllllllIIIlIIlIllIllIlIII, llllllllllllllIIIlIIlIllIlllIIII, llllllllllllllIIIlIIlIllIllIlIIl) <= 0.0 && this.dot4(llllllllllllllIIIlIIlIllIllIllIl, llllllllllllllIIIlIIlIllIllIlIll, llllllllllllllIIIlIIlIllIllIlIlI, llllllllllllllIIIlIIlIllIllIIllI) <= 0.0 && this.dot4(llllllllllllllIIIlIIlIllIllIllIl, llllllllllllllIIIlIIlIllIllIlIII, llllllllllllllIIIlIIlIllIllIlIlI, llllllllllllllIIIlIIlIllIllIIllI) <= 0.0 && this.dot4(llllllllllllllIIIlIIlIllIllIllIl, llllllllllllllIIIlIIlIllIllIlIll, llllllllllllllIIIlIIlIllIlllIIII, llllllllllllllIIIlIIlIllIllIIllI) <= 0.0 && this.dot4(llllllllllllllIIIlIIlIllIllIllIl, llllllllllllllIIIlIIlIllIllIlIII, llllllllllllllIIIlIIlIllIlllIIII, llllllllllllllIIIlIIlIllIllIIllI) <= 0.0) {
                return false;
            }
        }
        return true;
    }
    
    private void copyPlane(final float[] llllllllllllllIIIlIIlIllIIlIlIll, final float[] llllllllllllllIIIlIIlIllIIlIlIlI) {
        llllllllllllllIIIlIIlIllIIlIlIll[0] = llllllllllllllIIIlIIlIllIIlIlIlI[0];
        llllllllllllllIIIlIIlIllIIlIlIll[1] = llllllllllllllIIIlIIlIllIIlIlIlI[1];
        llllllllllllllIIIlIIlIllIIlIlIll[2] = llllllllllllllIIIlIIlIllIIlIlIlI[2];
        llllllllllllllIIIlIIlIllIIlIlIll[3] = llllllllllllllIIIlIIlIllIIlIlIlI[3];
    }
    
    private double dot3(final float[] llllllllllllllIIIlIIlIllIlIlIIIl, final float[] llllllllllllllIIIlIIlIllIlIlIIlI) {
        return llllllllllllllIIIlIIlIllIlIlIIIl[0] * (double)llllllllllllllIIIlIIlIllIlIlIIlI[0] + llllllllllllllIIIlIIlIllIlIlIIIl[1] * (double)llllllllllllllIIIlIIlIllIlIlIIlI[1] + llllllllllllllIIIlIIlIllIlIlIIIl[2] * (double)llllllllllllllIIIlIIlIllIlIlIIlI[2];
    }
    
    private void cross3(final float[] llllllllllllllIIIlIIlIllIIlIIIll, final float[] llllllllllllllIIIlIIlIllIIlIIIlI, final float[] llllllllllllllIIIlIIlIllIIIllllI) {
        llllllllllllllIIIlIIlIllIIlIIIll[0] = llllllllllllllIIIlIIlIllIIlIIIlI[1] * llllllllllllllIIIlIIlIllIIIllllI[2] - llllllllllllllIIIlIIlIllIIlIIIlI[2] * llllllllllllllIIIlIIlIllIIIllllI[1];
        llllllllllllllIIIlIIlIllIIlIIIll[1] = llllllllllllllIIIlIIlIllIIlIIIlI[2] * llllllllllllllIIIlIIlIllIIIllllI[0] - llllllllllllllIIIlIIlIllIIlIIIlI[0] * llllllllllllllIIIlIIlIllIIIllllI[2];
        llllllllllllllIIIlIIlIllIIlIIIll[2] = llllllllllllllIIIlIIlIllIIlIIIlI[0] * llllllllllllllIIIlIIlIllIIIllllI[1] - llllllllllllllIIIlIIlIllIIlIIIlI[1] * llllllllllllllIIIlIIlIllIIIllllI[0];
    }
    
    private void makeShadowPlane(final float[] llllllllllllllIIIlIIlIlIlllIlIIl, final float[] llllllllllllllIIIlIIlIlIlllIlIII, final float[] llllllllllllllIIIlIIlIlIllIllIIl, final float[] llllllllllllllIIIlIIlIlIllIllIII) {
        this.cross3(this.vecIntersection, llllllllllllllIIIlIIlIlIlllIlIII, llllllllllllllIIIlIIlIlIllIllIIl);
        this.cross3(llllllllllllllIIIlIIlIlIlllIlIIl, this.vecIntersection, llllllllllllllIIIlIIlIlIllIllIII);
        this.normalize3(llllllllllllllIIIlIIlIlIlllIlIIl);
        final float llllllllllllllIIIlIIlIlIlllIIlIl = (float)this.dot3(llllllllllllllIIIlIIlIlIlllIlIII, llllllllllllllIIIlIIlIlIllIllIIl);
        final float llllllllllllllIIIlIIlIlIlllIIlII = (float)this.dot3(llllllllllllllIIIlIIlIlIlllIlIIl, llllllllllllllIIIlIIlIlIllIllIIl);
        final float llllllllllllllIIIlIIlIlIlllIIIll = this.distance(llllllllllllllIIIlIIlIlIlllIlIIl[0], llllllllllllllIIIlIIlIlIlllIlIIl[1], llllllllllllllIIIlIIlIlIlllIlIIl[2], llllllllllllllIIIlIIlIlIllIllIIl[0] * llllllllllllllIIIlIIlIlIlllIIlII, llllllllllllllIIIlIIlIlIllIllIIl[1] * llllllllllllllIIIlIIlIlIlllIIlII, llllllllllllllIIIlIIlIlIllIllIIl[2] * llllllllllllllIIIlIIlIlIlllIIlII);
        final float llllllllllllllIIIlIIlIlIlllIIIlI = this.distance(llllllllllllllIIIlIIlIlIlllIlIII[0], llllllllllllllIIIlIIlIlIlllIlIII[1], llllllllllllllIIIlIIlIlIlllIlIII[2], llllllllllllllIIIlIIlIlIllIllIIl[0] * llllllllllllllIIIlIIlIlIlllIIlIl, llllllllllllllIIIlIIlIlIllIllIIl[1] * llllllllllllllIIIlIIlIlIlllIIlIl, llllllllllllllIIIlIIlIlIllIllIIl[2] * llllllllllllllIIIlIIlIlIlllIIlIl);
        final float llllllllllllllIIIlIIlIlIlllIIIIl = llllllllllllllIIIlIIlIlIlllIIIll / llllllllllllllIIIlIIlIlIlllIIIlI;
        final float llllllllllllllIIIlIIlIlIlllIIIII = (float)this.dot3(llllllllllllllIIIlIIlIlIlllIlIIl, llllllllllllllIIIlIIlIlIlllIlIII);
        final float llllllllllllllIIIlIIlIlIllIlllll = this.distance(llllllllllllllIIIlIIlIlIlllIlIIl[0], llllllllllllllIIIlIIlIlIlllIlIIl[1], llllllllllllllIIIlIIlIlIlllIlIIl[2], llllllllllllllIIIlIIlIlIlllIlIII[0] * llllllllllllllIIIlIIlIlIlllIIIII, llllllllllllllIIIlIIlIlIlllIlIII[1] * llllllllllllllIIIlIIlIlIlllIIIII, llllllllllllllIIIlIIlIlIlllIlIII[2] * llllllllllllllIIIlIIlIlIlllIIIII);
        final float llllllllllllllIIIlIIlIlIllIllllI = this.distance(llllllllllllllIIIlIIlIlIllIllIIl[0], llllllllllllllIIIlIIlIlIllIllIIl[1], llllllllllllllIIIlIIlIlIllIllIIl[2], llllllllllllllIIIlIIlIlIlllIlIII[0] * llllllllllllllIIIlIIlIlIlllIIlIl, llllllllllllllIIIlIIlIlIlllIlIII[1] * llllllllllllllIIIlIIlIlIlllIIlIl, llllllllllllllIIIlIIlIlIlllIlIII[2] * llllllllllllllIIIlIIlIlIlllIIlIl);
        final float llllllllllllllIIIlIIlIlIllIlllIl = llllllllllllllIIIlIIlIlIllIlllll / llllllllllllllIIIlIIlIlIllIllllI;
        llllllllllllllIIIlIIlIlIlllIlIIl[3] = llllllllllllllIIIlIIlIlIlllIlIII[3] * llllllllllllllIIIlIIlIlIlllIIIIl + llllllllllllllIIIlIIlIlIllIllIIl[3] * llllllllllllllIIIlIIlIlIllIlllIl;
    }
    
    public static ClippingHelper getInstance() {
        ClippingHelperShadow.instance.init();
        return ClippingHelperShadow.instance;
    }
}
