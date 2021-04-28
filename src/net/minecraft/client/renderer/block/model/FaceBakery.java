package net.minecraft.client.renderer.block.model;

import shadersmod.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraftforge.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.model.*;
import optifine.*;
import javax.vecmath.*;
import net.minecraft.util.*;

public class FaceBakery
{
    private static final /* synthetic */ double field_178417_b;
    private static final /* synthetic */ double field_178418_a;
    
    private void func_178406_a(final Vector3d llllllllllllllIIlIIlIlIllIIIllll, final Vector3d llllllllllllllIIlIIlIlIllIIIlllI, final Matrix4d llllllllllllllIIlIIlIlIllIIIllIl, final Vector3d llllllllllllllIIlIIlIlIllIIlIIII) {
        llllllllllllllIIlIIlIlIllIIIllll.sub((Tuple3d)llllllllllllllIIlIIlIlIllIIIlllI);
        llllllllllllllIIlIIlIlIllIIIllIl.transform(llllllllllllllIIlIIlIlIllIIIllll);
        llllllllllllllIIlIIlIlIllIIIllll.x *= llllllllllllllIIlIIlIlIllIIlIIII.x;
        llllllllllllllIIlIIlIlIllIIIllll.y *= llllllllllllllIIlIIlIlIllIIlIIII.y;
        llllllllllllllIIlIIlIlIllIIIllll.z *= llllllllllllllIIlIIlIlIllIIlIIII.z;
        llllllllllllllIIlIIlIlIllIIIllll.add((Tuple3d)llllllllllllllIIlIIlIlIllIIIlllI);
    }
    
    private Matrix4d func_178416_a(final AxisAngle4d llllllllllllllIIlIIlIlIllIIIIlll) {
        final Matrix4d llllllllllllllIIlIIlIlIllIIIIllI = this.func_178411_a();
        llllllllllllllIIlIIlIlIllIIIIllI.setRotation(llllllllllllllIIlIIlIlIllIIIIlll);
        return llllllllllllllIIlIIlIlIllIIIIllI;
    }
    
    private float func_178412_b(final EnumFacing llllllllllllllIIlIIlIllIIIlIIIII) {
        switch (SwitchEnumFacing.field_178400_a[llllllllllllllIIlIIlIllIIIlIIIII.ordinal()]) {
            case 1: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel05;
                }
                return 0.5f;
            }
            case 2: {
                return 1.0f;
            }
            case 3:
            case 4: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel08;
                }
                return 0.8f;
            }
            case 5:
            case 6: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel06;
                }
                return 0.6f;
            }
            default: {
                return 1.0f;
            }
        }
    }
    
    private void fillVertexData(final int[] llllllllllllllIIlIIlIlIlllllIlII, final int llllllllllllllIIlIIlIllIIIIIIIll, final EnumFacing llllllllllllllIIlIIlIllIIIIIIIlI, final BlockPartFace llllllllllllllIIlIIlIllIIIIIIIIl, final float[] llllllllllllllIIlIIlIlIlllllIIII, final TextureAtlasSprite llllllllllllllIIlIIlIlIlllllllll, final ITransformation llllllllllllllIIlIIlIlIllllllllI, final BlockPartRotation llllllllllllllIIlIIlIlIlllllllIl, final boolean llllllllllllllIIlIIlIlIllllIllII, final boolean llllllllllllllIIlIIlIlIllllIlIll) {
        final EnumFacing llllllllllllllIIlIIlIlIllllllIlI = llllllllllllllIIlIIlIlIllllllllI.rotate(llllllllllllllIIlIIlIllIIIIIIIlI);
        final int llllllllllllllIIlIIlIlIllllllIIl = llllllllllllllIIlIIlIlIllllIlIll ? this.func_178413_a(llllllllllllllIIlIIlIlIllllllIlI) : -1;
        final EnumFaceing.VertexInformation llllllllllllllIIlIIlIlIllllllIII = EnumFaceing.func_179027_a(llllllllllllllIIlIIlIllIIIIIIIlI).func_179025_a(llllllllllllllIIlIIlIllIIIIIIIll);
        final Vector3d llllllllllllllIIlIIlIlIlllllIlll = new Vector3d((double)llllllllllllllIIlIIlIlIlllllIIII[llllllllllllllIIlIIlIlIllllllIII.field_179184_a], (double)llllllllllllllIIlIIlIlIlllllIIII[llllllllllllllIIlIIlIlIllllllIII.field_179182_b], (double)llllllllllllllIIlIIlIlIlllllIIII[llllllllllllllIIlIIlIlIllllllIII.field_179183_c]);
        this.func_178407_a(llllllllllllllIIlIIlIlIlllllIlll, llllllllllllllIIlIIlIlIlllllllIl);
        final int llllllllllllllIIlIIlIlIlllllIllI = this.rotateVertex(llllllllllllllIIlIIlIlIlllllIlll, llllllllllllllIIlIIlIllIIIIIIIlI, llllllllllllllIIlIIlIllIIIIIIIll, llllllllllllllIIlIIlIlIllllllllI, llllllllllllllIIlIIlIlIllllIllII);
        this.func_178404_a(llllllllllllllIIlIIlIlIlllllIlII, llllllllllllllIIlIIlIlIlllllIllI, llllllllllllllIIlIIlIllIIIIIIIll, llllllllllllllIIlIIlIlIlllllIlll, llllllllllllllIIlIIlIlIllllllIIl, llllllllllllllIIlIIlIlIlllllllll, llllllllllllllIIlIIlIllIIIIIIIIl.field_178243_e);
    }
    
    private float[] func_178403_a(final Vector3f llllllllllllllIIlIIlIllIIIIllIII, final Vector3f llllllllllllllIIlIIlIllIIIIlIlll) {
        final float[] llllllllllllllIIlIIlIllIIIIllIIl = new float[EnumFacing.values().length];
        llllllllllllllIIlIIlIllIIIIllIIl[EnumFaceing.Constants.field_179176_f] = llllllllllllllIIlIIlIllIIIIllIII.x / 16.0f;
        llllllllllllllIIlIIlIllIIIIllIIl[EnumFaceing.Constants.field_179178_e] = llllllllllllllIIlIIlIllIIIIllIII.y / 16.0f;
        llllllllllllllIIlIIlIllIIIIllIIl[EnumFaceing.Constants.field_179177_d] = llllllllllllllIIlIIlIllIIIIllIII.z / 16.0f;
        llllllllllllllIIlIIlIllIIIIllIIl[EnumFaceing.Constants.field_179180_c] = llllllllllllllIIlIIlIllIIIIlIlll.x / 16.0f;
        llllllllllllllIIlIIlIllIIIIllIIl[EnumFaceing.Constants.field_179179_b] = llllllllllllllIIlIIlIllIIIIlIlll.y / 16.0f;
        llllllllllllllIIlIIlIllIIIIllIIl[EnumFaceing.Constants.field_179181_a] = llllllllllllllIIlIIlIllIIIIlIlll.z / 16.0f;
        return llllllllllllllIIlIIlIllIIIIllIIl;
    }
    
    private void func_178401_a(final int llllllllllllllIIlIIlIlIIllIlllll, final int[] llllllllllllllIIlIIlIlIIlllIlIll, final EnumFacing llllllllllllllIIlIIlIlIIllIlllIl, final BlockFaceUV llllllllllllllIIlIIlIlIIllIlllII, final TextureAtlasSprite llllllllllllllIIlIIlIlIIlllIlIII) {
        final int llllllllllllllIIlIIlIlIIlllIIlll = llllllllllllllIIlIIlIlIIlllIlIll.length / 4;
        final int llllllllllllllIIlIIlIlIIlllIIllI = llllllllllllllIIlIIlIlIIlllIIlll * llllllllllllllIIlIIlIlIIllIlllll;
        float llllllllllllllIIlIIlIlIIlllIIlIl = Float.intBitsToFloat(llllllllllllllIIlIIlIlIIlllIlIll[llllllllllllllIIlIIlIlIIlllIIllI]);
        float llllllllllllllIIlIIlIlIIlllIIlII = Float.intBitsToFloat(llllllllllllllIIlIIlIlIIlllIlIll[llllllllllllllIIlIIlIlIIlllIIllI + 1]);
        float llllllllllllllIIlIIlIlIIlllIIIll = Float.intBitsToFloat(llllllllllllllIIlIIlIlIIlllIlIll[llllllllllllllIIlIIlIlIIlllIIllI + 2]);
        if (llllllllllllllIIlIIlIlIIlllIIlIl < -0.1f || llllllllllllllIIlIIlIlIIlllIIlIl >= 1.1f) {
            llllllllllllllIIlIIlIlIIlllIIlIl -= MathHelper.floor_float(llllllllllllllIIlIIlIlIIlllIIlIl);
        }
        if (llllllllllllllIIlIIlIlIIlllIIlII < -0.1f || llllllllllllllIIlIIlIlIIlllIIlII >= 1.1f) {
            llllllllllllllIIlIIlIlIIlllIIlII -= MathHelper.floor_float(llllllllllllllIIlIIlIlIIlllIIlII);
        }
        if (llllllllllllllIIlIIlIlIIlllIIIll < -0.1f || llllllllllllllIIlIIlIlIIlllIIIll >= 1.1f) {
            llllllllllllllIIlIIlIlIIlllIIIll -= MathHelper.floor_float(llllllllllllllIIlIIlIlIIlllIIIll);
        }
        float llllllllllllllIIlIIlIlIIlllIIIlI = 0.0f;
        float llllllllllllllIIlIIlIlIIlllIIIIl = 0.0f;
        switch (SwitchEnumFacing.field_178400_a[llllllllllllllIIlIIlIlIIllIlllIl.ordinal()]) {
            case 1: {
                llllllllllllllIIlIIlIlIIlllIIIlI = llllllllllllllIIlIIlIlIIlllIIlIl * 16.0f;
                llllllllllllllIIlIIlIlIIlllIIIIl = (1.0f - llllllllllllllIIlIIlIlIIlllIIIll) * 16.0f;
                break;
            }
            case 2: {
                llllllllllllllIIlIIlIlIIlllIIIlI = llllllllllllllIIlIIlIlIIlllIIlIl * 16.0f;
                llllllllllllllIIlIIlIlIIlllIIIIl = llllllllllllllIIlIIlIlIIlllIIIll * 16.0f;
                break;
            }
            case 3: {
                llllllllllllllIIlIIlIlIIlllIIIlI = (1.0f - llllllllllllllIIlIIlIlIIlllIIlIl) * 16.0f;
                llllllllllllllIIlIIlIlIIlllIIIIl = (1.0f - llllllllllllllIIlIIlIlIIlllIIlII) * 16.0f;
                break;
            }
            case 4: {
                llllllllllllllIIlIIlIlIIlllIIIlI = llllllllllllllIIlIIlIlIIlllIIlIl * 16.0f;
                llllllllllllllIIlIIlIlIIlllIIIIl = (1.0f - llllllllllllllIIlIIlIlIIlllIIlII) * 16.0f;
                break;
            }
            case 5: {
                llllllllllllllIIlIIlIlIIlllIIIlI = llllllllllllllIIlIIlIlIIlllIIIll * 16.0f;
                llllllllllllllIIlIIlIlIIlllIIIIl = (1.0f - llllllllllllllIIlIIlIlIIlllIIlII) * 16.0f;
                break;
            }
            case 6: {
                llllllllllllllIIlIIlIlIIlllIIIlI = (1.0f - llllllllllllllIIlIIlIlIIlllIIIll) * 16.0f;
                llllllllllllllIIlIIlIlIIlllIIIIl = (1.0f - llllllllllllllIIlIIlIlIIlllIIlII) * 16.0f;
                break;
            }
        }
        final int llllllllllllllIIlIIlIlIIlllIIIII = llllllllllllllIIlIIlIlIIllIlllII.func_178345_c(llllllllllllllIIlIIlIlIIllIlllll) * llllllllllllllIIlIIlIlIIlllIIlll;
        llllllllllllllIIlIIlIlIIlllIlIll[llllllllllllllIIlIIlIlIIlllIIIII + 4] = Float.floatToRawIntBits(llllllllllllllIIlIIlIlIIlllIlIII.getInterpolatedU(llllllllllllllIIlIIlIlIIlllIIIlI));
        llllllllllllllIIlIIlIlIIlllIlIll[llllllllllllllIIlIIlIlIIlllIIIII + 4 + 1] = Float.floatToRawIntBits(llllllllllllllIIlIIlIlIIlllIlIII.getInterpolatedV(llllllllllllllIIlIIlIlIIlllIIIIl));
    }
    
    public int rotateVertex(final Vector3d llllllllllllllIIlIIlIlIllIlIIIlI, final EnumFacing llllllllllllllIIlIIlIlIllIIllIll, final int llllllllllllllIIlIIlIlIllIlIIIII, final ITransformation llllllllllllllIIlIIlIlIllIIllIIl, final boolean llllllllllllllIIlIIlIlIllIIllllI) {
        if (llllllllllllllIIlIIlIlIllIIllIIl == ModelRotation.X0_Y0) {
            return llllllllllllllIIlIIlIlIllIlIIIII;
        }
        if (Reflector.ForgeHooksClient_transform.exists()) {
            Reflector.call(Reflector.ForgeHooksClient_transform, llllllllllllllIIlIIlIlIllIlIIIlI, llllllllllllllIIlIIlIlIllIIllIIl.getMatrix());
        }
        else {
            this.func_178406_a(llllllllllllllIIlIIlIlIllIlIIIlI, new Vector3d(0.5, 0.5, 0.5), new Matrix4d(llllllllllllllIIlIIlIlIllIIllIIl.getMatrix()), new Vector3d(1.0, 1.0, 1.0));
        }
        return llllllllllllllIIlIIlIlIllIIllIIl.rotate(llllllllllllllIIlIIlIlIllIIllIll, llllllllllllllIIlIIlIlIllIlIIIII);
    }
    
    private void func_178408_a(final int[] llllllllllllllIIlIIlIlIlIIlIIIIl, final EnumFacing llllllllllllllIIlIIlIlIlIIIIlIlI) {
        final int[] llllllllllllllIIlIIlIlIlIIIlllll = new int[llllllllllllllIIlIIlIlIlIIlIIIIl.length];
        System.arraycopy(llllllllllllllIIlIIlIlIlIIlIIIIl, 0, llllllllllllllIIlIIlIlIlIIIlllll, 0, llllllllllllllIIlIIlIlIlIIlIIIIl.length);
        final float[] llllllllllllllIIlIIlIlIlIIIllllI = new float[EnumFacing.values().length];
        llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179176_f] = 999.0f;
        llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179178_e] = 999.0f;
        llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179177_d] = 999.0f;
        llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179180_c] = -999.0f;
        llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179179_b] = -999.0f;
        llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179181_a] = -999.0f;
        final int llllllllllllllIIlIIlIlIlIIIlllIl = llllllllllllllIIlIIlIlIlIIlIIIIl.length / 4;
        for (int llllllllllllllIIlIIlIlIlIIIllIII = 0; llllllllllllllIIlIIlIlIlIIIllIII < 4; ++llllllllllllllIIlIIlIlIlIIIllIII) {
            final int llllllllllllllIIlIIlIlIlIIIlllII = llllllllllllllIIlIIlIlIlIIIlllIl * llllllllllllllIIlIIlIlIlIIIllIII;
            final float llllllllllllllIIlIIlIlIlIIIlIlll = Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIIIlllll[llllllllllllllIIlIIlIlIlIIIlllII]);
            final float llllllllllllllIIlIIlIlIlIIIlIllI = Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIIIlllll[llllllllllllllIIlIIlIlIlIIIlllII + 1]);
            final float llllllllllllllIIlIIlIlIlIIIllIlI = Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIIIlllll[llllllllllllllIIlIIlIlIlIIIlllII + 2]);
            if (llllllllllllllIIlIIlIlIlIIIlIlll < llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179176_f]) {
                llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179176_f] = llllllllllllllIIlIIlIlIlIIIlIlll;
            }
            if (llllllllllllllIIlIIlIlIlIIIlIllI < llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179178_e]) {
                llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179178_e] = llllllllllllllIIlIIlIlIlIIIlIllI;
            }
            if (llllllllllllllIIlIIlIlIlIIIllIlI < llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179177_d]) {
                llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179177_d] = llllllllllllllIIlIIlIlIlIIIllIlI;
            }
            if (llllllllllllllIIlIIlIlIlIIIlIlll > llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179180_c]) {
                llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179180_c] = llllllllllllllIIlIIlIlIlIIIlIlll;
            }
            if (llllllllllllllIIlIIlIlIlIIIlIllI > llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179179_b]) {
                llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179179_b] = llllllllllllllIIlIIlIlIlIIIlIllI;
            }
            if (llllllllllllllIIlIIlIlIlIIIllIlI > llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179181_a]) {
                llllllllllllllIIlIIlIlIlIIIllllI[EnumFaceing.Constants.field_179181_a] = llllllllllllllIIlIIlIlIlIIIllIlI;
            }
        }
        final EnumFaceing llllllllllllllIIlIIlIlIlIIIlIlIl = EnumFaceing.func_179027_a(llllllllllllllIIlIIlIlIlIIIIlIlI);
        for (int llllllllllllllIIlIIlIlIlIIIllIll = 0; llllllllllllllIIlIIlIlIlIIIllIll < 4; ++llllllllllllllIIlIIlIlIlIIIllIll) {
            final int llllllllllllllIIlIIlIlIlIIIlIlII = llllllllllllllIIlIIlIlIlIIIlllIl * llllllllllllllIIlIIlIlIlIIIllIll;
            final EnumFaceing.VertexInformation llllllllllllllIIlIIlIlIlIIIlIIll = llllllllllllllIIlIIlIlIlIIIlIlIl.func_179025_a(llllllllllllllIIlIIlIlIlIIIllIll);
            final float llllllllllllllIIlIIlIlIlIIIllIIl = llllllllllllllIIlIIlIlIlIIIllllI[llllllllllllllIIlIIlIlIlIIIlIIll.field_179184_a];
            final float llllllllllllllIIlIIlIlIlIIIlIIlI = llllllllllllllIIlIIlIlIlIIIllllI[llllllllllllllIIlIIlIlIlIIIlIIll.field_179182_b];
            final float llllllllllllllIIlIIlIlIlIIIlIIIl = llllllllllllllIIlIIlIlIlIIIllllI[llllllllllllllIIlIIlIlIlIIIlIIll.field_179183_c];
            llllllllllllllIIlIIlIlIlIIlIIIIl[llllllllllllllIIlIIlIlIlIIIlIlII] = Float.floatToRawIntBits(llllllllllllllIIlIIlIlIlIIIllIIl);
            llllllllllllllIIlIIlIlIlIIlIIIIl[llllllllllllllIIlIIlIlIlIIIlIlII + 1] = Float.floatToRawIntBits(llllllllllllllIIlIIlIlIlIIIlIIlI);
            llllllllllllllIIlIIlIlIlIIlIIIIl[llllllllllllllIIlIIlIlIlIIIlIlII + 2] = Float.floatToRawIntBits(llllllllllllllIIlIIlIlIlIIIlIIIl);
            for (int llllllllllllllIIlIIlIlIlIIIlIIII = 0; llllllllllllllIIlIIlIlIlIIIlIIII < 4; ++llllllllllllllIIlIIlIlIlIIIlIIII) {
                final int llllllllllllllIIlIIlIlIlIIIIllll = llllllllllllllIIlIIlIlIlIIIlllIl * llllllllllllllIIlIIlIlIlIIIlIIII;
                final float llllllllllllllIIlIIlIlIlIIIIlllI = Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIIIlllll[llllllllllllllIIlIIlIlIlIIIIllll]);
                final float llllllllllllllIIlIIlIlIlIIIIllIl = Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIIIlllll[llllllllllllllIIlIIlIlIlIIIIllll + 1]);
                final float llllllllllllllIIlIIlIlIlIIIIllII = Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIIIlllll[llllllllllllllIIlIIlIlIlIIIIllll + 2]);
                if (MathHelper.func_180185_a(llllllllllllllIIlIIlIlIlIIIllIIl, llllllllllllllIIlIIlIlIlIIIIlllI) && MathHelper.func_180185_a(llllllllllllllIIlIIlIlIlIIIlIIlI, llllllllllllllIIlIIlIlIlIIIIllIl) && MathHelper.func_180185_a(llllllllllllllIIlIIlIlIlIIIlIIIl, llllllllllllllIIlIIlIlIlIIIIllII)) {
                    llllllllllllllIIlIIlIlIlIIlIIIIl[llllllllllllllIIlIIlIlIlIIIlIlII + 4] = llllllllllllllIIlIIlIlIlIIIlllll[llllllllllllllIIlIIlIlIlIIIIllll + 4];
                    llllllllllllllIIlIIlIlIlIIlIIIIl[llllllllllllllIIlIIlIlIlIIIlIlII + 4 + 1] = llllllllllllllIIlIIlIlIlIIIlllll[llllllllllllllIIlIIlIlIlIIIIllll + 4 + 1];
                }
            }
        }
    }
    
    public void func_178409_a(final int[] llllllllllllllIIlIIlIlIlIIlllIII, final EnumFacing llllllllllllllIIlIIlIlIlIIllllIl, final BlockFaceUV llllllllllllllIIlIIlIlIlIIllllII, final TextureAtlasSprite llllllllllllllIIlIIlIlIlIIlllIll) {
        for (int llllllllllllllIIlIIlIlIlIIlllIlI = 0; llllllllllllllIIlIIlIlIlIIlllIlI < 4; ++llllllllllllllIIlIIlIlIlIIlllIlI) {
            this.func_178401_a(llllllllllllllIIlIIlIlIlIIlllIlI, llllllllllllllIIlIIlIlIlIIlllIII, llllllllllllllIIlIIlIlIlIIllllIl, llllllllllllllIIlIIlIlIlIIllllII, llllllllllllllIIlIIlIlIlIIlllIll);
        }
    }
    
    public int func_178415_a(final Vector3d llllllllllllllIIlIIlIlIllIllIIll, final EnumFacing llllllllllllllIIlIIlIlIllIllIIlI, final int llllllllllllllIIlIIlIlIllIllIIIl, final ModelRotation llllllllllllllIIlIIlIlIllIllIIII, final boolean llllllllllllllIIlIIlIlIllIlIlIIl) {
        return this.rotateVertex(llllllllllllllIIlIIlIlIllIllIIll, llllllllllllllIIlIIlIlIllIllIIlI, llllllllllllllIIlIIlIlIllIllIIIl, llllllllllllllIIlIIlIlIllIllIIII, llllllllllllllIIlIIlIlIllIlIlIIl);
    }
    
    private void func_178407_a(final Vector3d llllllllllllllIIlIIlIlIlllIIIIll, final BlockPartRotation llllllllllllllIIlIIlIlIlllIIIIlI) {
        if (llllllllllllllIIlIIlIlIlllIIIIlI != null) {
            final Matrix4d llllllllllllllIIlIIlIlIlllIIIIIl = this.func_178411_a();
            final Vector3d llllllllllllllIIlIIlIlIlllIIIIII = new Vector3d(0.0, 0.0, 0.0);
            switch (SwitchEnumFacing.field_178399_b[llllllllllllllIIlIIlIlIlllIIIIlI.field_178342_b.ordinal()]) {
                case 1: {
                    llllllllllllllIIlIIlIlIlllIIIIIl.mul(this.func_178416_a(new AxisAngle4d(1.0, 0.0, 0.0, llllllllllllllIIlIIlIlIlllIIIIlI.field_178343_c * 0.017453292519943295)));
                    llllllllllllllIIlIIlIlIlllIIIIII.set(0.0, 1.0, 1.0);
                    break;
                }
                case 2: {
                    llllllllllllllIIlIIlIlIlllIIIIIl.mul(this.func_178416_a(new AxisAngle4d(0.0, 1.0, 0.0, llllllllllllllIIlIIlIlIlllIIIIlI.field_178343_c * 0.017453292519943295)));
                    llllllllllllllIIlIIlIlIlllIIIIII.set(1.0, 0.0, 1.0);
                    break;
                }
                case 3: {
                    llllllllllllllIIlIIlIlIlllIIIIIl.mul(this.func_178416_a(new AxisAngle4d(0.0, 0.0, 1.0, llllllllllllllIIlIIlIlIlllIIIIlI.field_178343_c * 0.017453292519943295)));
                    llllllllllllllIIlIIlIlIlllIIIIII.set(1.0, 1.0, 0.0);
                    break;
                }
            }
            if (llllllllllllllIIlIIlIlIlllIIIIlI.field_178341_d) {
                if (Math.abs(llllllllllllllIIlIIlIlIlllIIIIlI.field_178343_c) == 22.5f) {
                    llllllllllllllIIlIIlIlIlllIIIIII.scale(FaceBakery.field_178418_a);
                }
                else {
                    llllllllllllllIIlIIlIlIlllIIIIII.scale(FaceBakery.field_178417_b);
                }
                llllllllllllllIIlIIlIlIlllIIIIII.add((Tuple3d)new Vector3d(1.0, 1.0, 1.0));
            }
            else {
                llllllllllllllIIlIIlIlIlllIIIIII.set((Tuple3d)new Vector3d(1.0, 1.0, 1.0));
            }
            this.func_178406_a(llllllllllllllIIlIIlIlIlllIIIIll, new Vector3d(llllllllllllllIIlIIlIlIlllIIIIlI.field_178344_a), llllllllllllllIIlIIlIlIlllIIIIIl, llllllllllllllIIlIIlIlIlllIIIIII);
        }
    }
    
    private Matrix4d func_178411_a() {
        final Matrix4d llllllllllllllIIlIIlIlIllIIIIIII = new Matrix4d();
        llllllllllllllIIlIIlIlIllIIIIIII.setIdentity();
        return llllllllllllllIIlIIlIlIllIIIIIII;
    }
    
    public static EnumFacing func_178410_a(final int[] llllllllllllllIIlIIlIlIlIlIllIII) {
        final int llllllllllllllIIlIIlIlIlIllIlIlI = llllllllllllllIIlIIlIlIlIlIllIII.length / 4;
        final int llllllllllllllIIlIIlIlIlIllIlIIl = llllllllllllllIIlIIlIlIlIllIlIlI * 2;
        final int llllllllllllllIIlIIlIlIlIllIlIII = llllllllllllllIIlIIlIlIlIllIlIlI * 3;
        final Vector3f llllllllllllllIIlIIlIlIlIllIIlll = new Vector3f(Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[0]), Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[1]), Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[2]));
        final Vector3f llllllllllllllIIlIIlIlIlIllIIllI = new Vector3f(Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[llllllllllllllIIlIIlIlIlIllIlIlI]), Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[llllllllllllllIIlIIlIlIlIllIlIlI + 1]), Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[llllllllllllllIIlIIlIlIlIllIlIlI + 2]));
        final Vector3f llllllllllllllIIlIIlIlIlIllIIlIl = new Vector3f(Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[llllllllllllllIIlIIlIlIlIllIlIIl]), Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[llllllllllllllIIlIIlIlIlIllIlIIl + 1]), Float.intBitsToFloat(llllllllllllllIIlIIlIlIlIlIllIII[llllllllllllllIIlIIlIlIlIllIlIIl + 2]));
        final Vector3f llllllllllllllIIlIIlIlIlIllIIlII = new Vector3f();
        final Vector3f llllllllllllllIIlIIlIlIlIllIIIll = new Vector3f();
        final Vector3f llllllllllllllIIlIIlIlIlIllIIIlI = new Vector3f();
        llllllllllllllIIlIIlIlIlIllIIlII.sub((Tuple3f)llllllllllllllIIlIIlIlIlIllIIlll, (Tuple3f)llllllllllllllIIlIIlIlIlIllIIllI);
        llllllllllllllIIlIIlIlIlIllIIIll.sub((Tuple3f)llllllllllllllIIlIIlIlIlIllIIlIl, (Tuple3f)llllllllllllllIIlIIlIlIlIllIIllI);
        llllllllllllllIIlIIlIlIlIllIIIlI.cross(llllllllllllllIIlIIlIlIlIllIIIll, llllllllllllllIIlIIlIlIlIllIIlII);
        llllllllllllllIIlIIlIlIlIllIIIlI.normalize();
        EnumFacing llllllllllllllIIlIIlIlIlIllIIIIl = null;
        float llllllllllllllIIlIIlIlIlIllIIIII = 0.0f;
        for (final EnumFacing llllllllllllllIIlIIlIlIlIlIlllII : EnumFacing.values()) {
            final Vec3i llllllllllllllIIlIIlIlIlIlIllIll = llllllllllllllIIlIIlIlIlIlIlllII.getDirectionVec();
            final Vector3f llllllllllllllIIlIIlIlIlIlIllIlI = new Vector3f((float)llllllllllllllIIlIIlIlIlIlIllIll.getX(), (float)llllllllllllllIIlIIlIlIlIlIllIll.getY(), (float)llllllllllllllIIlIIlIlIlIlIllIll.getZ());
            final float llllllllllllllIIlIIlIlIlIlIllIIl = llllllllllllllIIlIIlIlIlIllIIIlI.dot(llllllllllllllIIlIIlIlIlIlIllIlI);
            if (llllllllllllllIIlIIlIlIlIlIllIIl >= 0.0f && llllllllllllllIIlIIlIlIlIlIllIIl > llllllllllllllIIlIIlIlIlIllIIIII) {
                llllllllllllllIIlIIlIlIlIllIIIII = llllllllllllllIIlIIlIlIlIlIllIIl;
                llllllllllllllIIlIIlIlIlIllIIIIl = llllllllllllllIIlIIlIlIlIlIlllII;
            }
        }
        if (llllllllllllllIIlIIlIlIlIllIIIII < 0.719f) {
            if (llllllllllllllIIlIIlIlIlIllIIIIl != EnumFacing.EAST && llllllllllllllIIlIIlIlIlIllIIIIl != EnumFacing.WEST && llllllllllllllIIlIIlIlIlIllIIIIl != EnumFacing.NORTH && llllllllllllllIIlIIlIlIlIllIIIIl != EnumFacing.SOUTH) {
                llllllllllllllIIlIIlIlIlIllIIIIl = EnumFacing.UP;
            }
            else {
                llllllllllllllIIlIIlIlIlIllIIIIl = EnumFacing.NORTH;
            }
        }
        return (llllllllllllllIIlIIlIlIlIllIIIIl == null) ? EnumFacing.UP : llllllllllllllIIlIIlIlIlIllIIIIl;
    }
    
    public BakedQuad makeBakedQuad(final Vector3f llllllllllllllIIlIIlIllIIllIlIlI, final Vector3f llllllllllllllIIlIIlIllIIlIlllIl, final BlockPartFace llllllllllllllIIlIIlIllIIllIlIII, final TextureAtlasSprite llllllllllllllIIlIIlIllIIllIIlll, final EnumFacing llllllllllllllIIlIIlIllIIlIllIlI, final ITransformation llllllllllllllIIlIIlIllIIlIllIIl, final BlockPartRotation llllllllllllllIIlIIlIllIIlIllIII, final boolean llllllllllllllIIlIIlIllIIllIIIll, final boolean llllllllllllllIIlIIlIllIIllIIIlI) {
        final int[] llllllllllllllIIlIIlIllIIllIIIIl = this.makeQuadVertexData(llllllllllllllIIlIIlIllIIllIlIII, llllllllllllllIIlIIlIllIIllIIlll, llllllllllllllIIlIIlIllIIlIllIlI, this.func_178403_a(llllllllllllllIIlIIlIllIIllIlIlI, llllllllllllllIIlIIlIllIIlIlllIl), llllllllllllllIIlIIlIllIIlIllIIl, llllllllllllllIIlIIlIllIIlIllIII, llllllllllllllIIlIIlIllIIllIIIll, llllllllllllllIIlIIlIllIIllIIIlI);
        final EnumFacing llllllllllllllIIlIIlIllIIllIIIII = func_178410_a(llllllllllllllIIlIIlIllIIllIIIIl);
        if (llllllllllllllIIlIIlIllIIllIIIll) {
            this.func_178409_a(llllllllllllllIIlIIlIllIIllIIIIl, llllllllllllllIIlIIlIllIIllIIIII, llllllllllllllIIlIIlIllIIllIlIII.field_178243_e, llllllllllllllIIlIIlIllIIllIIlll);
        }
        if (llllllllllllllIIlIIlIllIIlIllIII == null) {
            this.func_178408_a(llllllllllllllIIlIIlIllIIllIIIIl, llllllllllllllIIlIIlIllIIllIIIII);
        }
        if (Reflector.ForgeHooksClient_fillNormal.exists()) {
            Reflector.callVoid(Reflector.ForgeHooksClient_fillNormal, llllllllllllllIIlIIlIllIIllIIIIl, llllllllllllllIIlIIlIllIIllIIIII);
        }
        return new BakedQuad(llllllllllllllIIlIIlIllIIllIIIIl, llllllllllllllIIlIIlIllIIllIlIII.field_178245_c, llllllllllllllIIlIIlIllIIllIIIII, llllllllllllllIIlIIlIllIIllIIlll);
    }
    
    public BakedQuad func_178414_a(final Vector3f llllllllllllllIIlIIlIllIlIIIlIlI, final Vector3f llllllllllllllIIlIIlIllIIlllllll, final BlockPartFace llllllllllllllIIlIIlIllIIllllllI, final TextureAtlasSprite llllllllllllllIIlIIlIllIIlllllIl, final EnumFacing llllllllllllllIIlIIlIllIlIIIIllI, final ModelRotation llllllllllllllIIlIIlIllIIllllIll, final BlockPartRotation llllllllllllllIIlIIlIllIlIIIIlII, final boolean llllllllllllllIIlIIlIllIIllllIIl, final boolean llllllllllllllIIlIIlIllIIllllIII) {
        return this.makeBakedQuad(llllllllllllllIIlIIlIllIlIIIlIlI, llllllllllllllIIlIIlIllIIlllllll, llllllllllllllIIlIIlIllIIllllllI, llllllllllllllIIlIIlIllIIlllllIl, llllllllllllllIIlIIlIllIlIIIIllI, llllllllllllllIIlIIlIllIIllllIll, llllllllllllllIIlIIlIllIlIIIIlII, llllllllllllllIIlIIlIllIIllllIIl, llllllllllllllIIlIIlIllIIllllIII);
    }
    
    private int func_178413_a(final EnumFacing llllllllllllllIIlIIlIllIIIlIlIlI) {
        final float llllllllllllllIIlIIlIllIIIlIlIIl = this.func_178412_b(llllllllllllllIIlIIlIllIIIlIlIlI);
        final int llllllllllllllIIlIIlIllIIIlIlIII = MathHelper.clamp_int((int)(llllllllllllllIIlIIlIllIIIlIlIIl * 255.0f), 0, 255);
        return 0xFF000000 | llllllllllllllIIlIIlIllIIIlIlIII << 16 | llllllllllllllIIlIIlIllIIIlIlIII << 8 | llllllllllllllIIlIIlIllIIIlIlIII;
    }
    
    private void func_178404_a(final int[] llllllllllllllIIlIIlIlIlllIlIIlI, final int llllllllllllllIIlIIlIlIlllIlIIIl, final int llllllllllllllIIlIIlIlIlllIlIIII, final Vector3d llllllllllllllIIlIIlIlIlllIllIII, final int llllllllllllllIIlIIlIlIlllIlIlll, final TextureAtlasSprite llllllllllllllIIlIIlIlIlllIlIllI, final BlockFaceUV llllllllllllllIIlIIlIlIlllIlIlIl) {
        final int llllllllllllllIIlIIlIlIlllIlIlII = llllllllllllllIIlIIlIlIlllIlIIlI.length / 4;
        final int llllllllllllllIIlIIlIlIlllIlIIll = llllllllllllllIIlIIlIlIlllIlIIIl * llllllllllllllIIlIIlIlIlllIlIlII;
        llllllllllllllIIlIIlIlIlllIlIIlI[llllllllllllllIIlIIlIlIlllIlIIll] = Float.floatToRawIntBits((float)llllllllllllllIIlIIlIlIlllIllIII.x);
        llllllllllllllIIlIIlIlIlllIlIIlI[llllllllllllllIIlIIlIlIlllIlIIll + 1] = Float.floatToRawIntBits((float)llllllllllllllIIlIIlIlIlllIllIII.y);
        llllllllllllllIIlIIlIlIlllIlIIlI[llllllllllllllIIlIIlIlIlllIlIIll + 2] = Float.floatToRawIntBits((float)llllllllllllllIIlIIlIlIlllIllIII.z);
        llllllllllllllIIlIIlIlIlllIlIIlI[llllllllllllllIIlIIlIlIlllIlIIll + 3] = llllllllllllllIIlIIlIlIlllIlIlll;
        llllllllllllllIIlIIlIlIlllIlIIlI[llllllllllllllIIlIIlIlIlllIlIIll + 4] = Float.floatToRawIntBits(llllllllllllllIIlIIlIlIlllIlIllI.getInterpolatedU(llllllllllllllIIlIIlIlIlllIlIlIl.func_178348_a(llllllllllllllIIlIIlIlIlllIlIIII)));
        llllllllllllllIIlIIlIlIlllIlIIlI[llllllllllllllIIlIIlIlIlllIlIIll + 4 + 1] = Float.floatToRawIntBits(llllllllllllllIIlIIlIlIlllIlIllI.getInterpolatedV(llllllllllllllIIlIIlIlIlllIlIlIl.func_178346_b(llllllllllllllIIlIIlIlIlllIlIIII)));
    }
    
    static {
        __OBFID = "CL_00002490";
        field_178418_a = 1.0 / Math.cos(0.39269908169872414) - 1.0;
        field_178417_b = 1.0 / Math.cos(0.7853981633974483) - 1.0;
    }
    
    private int[] makeQuadVertexData(final BlockPartFace llllllllllllllIIlIIlIllIIlIIIllI, final TextureAtlasSprite llllllllllllllIIlIIlIllIIlIIIlIl, final EnumFacing llllllllllllllIIlIIlIllIIlIIIlII, final float[] llllllllllllllIIlIIlIllIIlIIIIll, final ITransformation llllllllllllllIIlIIlIllIIlIIIIlI, final BlockPartRotation llllllllllllllIIlIIlIllIIlIIIIIl, final boolean llllllllllllllIIlIIlIllIIIllIlII, final boolean llllllllllllllIIlIIlIllIIIllIIll) {
        byte llllllllllllllIIlIIlIllIIIlllllI = 28;
        if (Config.isShaders()) {
            llllllllllllllIIlIIlIllIIIlllllI = 56;
        }
        final int[] llllllllllllllIIlIIlIllIIIllllIl = new int[llllllllllllllIIlIIlIllIIIlllllI];
        for (int llllllllllllllIIlIIlIllIIIllllII = 0; llllllllllllllIIlIIlIllIIIllllII < 4; ++llllllllllllllIIlIIlIllIIIllllII) {
            this.fillVertexData(llllllllllllllIIlIIlIllIIIllllIl, llllllllllllllIIlIIlIllIIIllllII, llllllllllllllIIlIIlIllIIlIIIlII, llllllllllllllIIlIIlIllIIlIIIllI, llllllllllllllIIlIIlIllIIlIIIIll, llllllllllllllIIlIIlIllIIlIIIlIl, llllllllllllllIIlIIlIllIIlIIIIlI, llllllllllllllIIlIIlIllIIlIIIIIl, llllllllllllllIIlIIlIllIIIllIlII, llllllllllllllIIlIIlIllIIIllIIll);
        }
        return llllllllllllllIIlIIlIllIIIllllIl;
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_178400_a;
        static final /* synthetic */ int[] field_178399_b;
        
        static {
            __OBFID = "CL_00002489";
            field_178399_b = new int[EnumFacing.Axis.values().length];
            try {
                SwitchEnumFacing.field_178399_b[EnumFacing.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_178399_b[EnumFacing.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_178399_b[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            field_178400_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_178400_a[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_178400_a[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_178400_a[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchEnumFacing.field_178400_a[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchEnumFacing.field_178400_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchEnumFacing.field_178400_a[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
        }
    }
}
