package shadersmod.client;

import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import java.nio.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.*;

public class SVertexBuilder
{
    /* synthetic */ long[] entityData;
    /* synthetic */ int offsetUVCenter;
    /* synthetic */ int entityDataIndex;
    /* synthetic */ int vertexSize;
    /* synthetic */ boolean hasUV;
    /* synthetic */ boolean hasTangent;
    /* synthetic */ boolean hasNormal;
    /* synthetic */ int offsetNormal;
    /* synthetic */ int offsetUV;
    
    public static void endAddVertex(final WorldRenderer llllllllllllllIlIIllIIIIlllIIllI) {
        final SVertexBuilder llllllllllllllIlIIllIIIIlllIlIIl = llllllllllllllIlIIllIIIIlllIIllI.sVertexBuilder;
        if (llllllllllllllIlIIllIIIIlllIlIIl.vertexSize == 14) {
            if (llllllllllllllIlIIllIIIIlllIIllI.drawMode == 7 && llllllllllllllIlIIllIIIIlllIIllI.vertexCount % 4 == 0) {
                llllllllllllllIlIIllIIIIlllIlIIl.calcNormal(llllllllllllllIlIIllIIIIlllIIllI, llllllllllllllIlIIllIIIIlllIIllI.rawBufferIndex - 4 * llllllllllllllIlIIllIIIIlllIlIIl.vertexSize);
            }
            final long llllllllllllllIlIIllIIIIlllIlIII = llllllllllllllIlIIllIIIIlllIlIIl.entityData[llllllllllllllIlIIllIIIIlllIlIIl.entityDataIndex];
            final int llllllllllllllIlIIllIIIIlllIIlll = llllllllllllllIlIIllIIIIlllIIllI.rawBufferIndex - 14 + 12;
            llllllllllllllIlIIllIIIIlllIIllI.rawIntBuffer.put(llllllllllllllIlIIllIIIIlllIIlll, (int)llllllllllllllIlIIllIIIIlllIlIII);
            llllllllllllllIlIIllIIIIlllIIllI.rawIntBuffer.put(llllllllllllllIlIIllIIIIlllIIlll + 1, (int)(llllllllllllllIlIIllIIIIlllIlIII >> 32));
        }
    }
    
    public static void calcNormalChunkLayer(final WorldRenderer llllllllllllllIlIIllIIIIIIIIlllI) {
        if (llllllllllllllIlIIllIIIIIIIIlllI.func_178973_g().func_177350_b() && llllllllllllllIlIIllIIIIIIIIlllI.drawMode == 7 && llllllllllllllIlIIllIIIIIIIIlllI.vertexCount % 4 == 0) {
            final SVertexBuilder llllllllllllllIlIIllIIIIIIIlIIIl = llllllllllllllIlIIllIIIIIIIIlllI.sVertexBuilder;
            endSetVertexFormat(llllllllllllllIlIIllIIIIIIIIlllI);
            for (int llllllllllllllIlIIllIIIIIIIlIIII = llllllllllllllIlIIllIIIIIIIIlllI.vertexCount * llllllllllllllIlIIllIIIIIIIlIIIl.vertexSize, llllllllllllllIlIIllIIIIIIIIllll = 0; llllllllllllllIlIIllIIIIIIIIllll < llllllllllllllIlIIllIIIIIIIlIIII; llllllllllllllIlIIllIIIIIIIIllll += llllllllllllllIlIIllIIIIIIIlIIIl.vertexSize * 4) {
                llllllllllllllIlIIllIIIIIIIlIIIl.calcNormal(llllllllllllllIlIIllIIIIIIIIlllI, llllllllllllllIlIIllIIIIIIIIllll);
            }
        }
    }
    
    public static void endAddVertexData(final WorldRenderer llllllllllllllIlIIllIIIIllIlIIIl) {
        final SVertexBuilder llllllllllllllIlIIllIIIIllIlIIII = llllllllllllllIlIIllIIIIllIlIIIl.sVertexBuilder;
        if (llllllllllllllIlIIllIIIIllIlIIII.vertexSize == 14 && llllllllllllllIlIIllIIIIllIlIIIl.drawMode == 7 && llllllllllllllIlIIllIIIIllIlIIIl.vertexCount % 4 == 0) {
            llllllllllllllIlIIllIIIIllIlIIII.calcNormal(llllllllllllllIlIIllIIIIllIlIIIl, llllllllllllllIlIIllIIIIllIlIIIl.rawBufferIndex - 4 * llllllllllllllIlIIllIIIIllIlIIII.vertexSize);
        }
    }
    
    public static boolean popEntity(final boolean llllllllllllllIlIIllIIIIllllllII, final WorldRenderer llllllllllllllIlIIllIIIIlllllIll) {
        llllllllllllllIlIIllIIIIlllllIll.sVertexBuilder.popEntity();
        return llllllllllllllIlIIllIIIIllllllII;
    }
    
    public static void initVertexBuilder(final WorldRenderer llllllllllllllIlIIllIIIlIIlIIlll) {
        llllllllllllllIlIIllIIIlIIlIIlll.sVertexBuilder = new SVertexBuilder();
    }
    
    public static void drawArrays(final int llllllllllllllIlIIlIllllllllllII, final int llllllllllllllIlIIllIIIIIIIIIIlI, final int llllllllllllllIlIIllIIIIIIIIIIIl, final WorldRenderer llllllllllllllIlIIlIlllllllllIIl) {
        if (llllllllllllllIlIIllIIIIIIIIIIIl != 0) {
            final VertexFormat llllllllllllllIlIIlIllllllllllll = llllllllllllllIlIIlIlllllllllIIl.func_178973_g();
            final int llllllllllllllIlIIlIlllllllllllI = llllllllllllllIlIIlIllllllllllll.func_177338_f();
            if (llllllllllllllIlIIlIlllllllllllI == 56) {
                final ByteBuffer llllllllllllllIlIIlIllllllllllIl = llllllllllllllIlIIlIlllllllllIIl.func_178966_f();
                llllllllllllllIlIIlIllllllllllIl.position(32);
                GL20.glVertexAttribPointer(Shaders.midTexCoordAttrib, 2, 5126, false, llllllllllllllIlIIlIlllllllllllI, llllllllllllllIlIIlIllllllllllIl);
                llllllllllllllIlIIlIllllllllllIl.position(40);
                GL20.glVertexAttribPointer(Shaders.tangentAttrib, 4, 5122, false, llllllllllllllIlIIlIlllllllllllI, llllllllllllllIlIIlIllllllllllIl);
                llllllllllllllIlIIlIllllllllllIl.position(48);
                GL20.glVertexAttribPointer(Shaders.entityAttrib, 3, 5122, false, llllllllllllllIlIIlIlllllllllllI, llllllllllllllIlIIlIllllllllllIl);
                llllllllllllllIlIIlIllllllllllIl.position(0);
                GL20.glEnableVertexAttribArray(Shaders.midTexCoordAttrib);
                GL20.glEnableVertexAttribArray(Shaders.tangentAttrib);
                GL20.glEnableVertexAttribArray(Shaders.entityAttrib);
                GL11.glDrawArrays(llllllllllllllIlIIlIllllllllllII, llllllllllllllIlIIllIIIIIIIIIIlI, llllllllllllllIlIIllIIIIIIIIIIIl);
                GL20.glDisableVertexAttribArray(Shaders.midTexCoordAttrib);
                GL20.glDisableVertexAttribArray(Shaders.tangentAttrib);
                GL20.glDisableVertexAttribArray(Shaders.entityAttrib);
            }
            else {
                GL11.glDrawArrays(llllllllllllllIlIIlIllllllllllII, llllllllllllllIlIIllIIIIIIIIIIlI, llllllllllllllIlIIllIIIIIIIIIIIl);
            }
        }
    }
    
    public void popEntity() {
        this.entityData[this.entityDataIndex] = 0L;
        --this.entityDataIndex;
    }
    
    public static void startTexturedQuad(final WorldRenderer llllllllllllllIlIIlIllllllllIlII) {
        llllllllllllllIlIIlIllllllllIlII.setVertexFormat(SVertexFormat.defVertexFormatTextured);
    }
    
    public SVertexBuilder() {
        this.entityData = new long[10];
        this.entityDataIndex = 0;
        this.entityData[this.entityDataIndex] = 0L;
    }
    
    public static void beginAddVertex(final WorldRenderer llllllllllllllIlIIllIIIIlllIllll) {
        if (llllllllllllllIlIIllIIIIlllIllll.vertexCount == 0) {
            endSetVertexFormat(llllllllllllllIlIIllIIIIlllIllll);
        }
    }
    
    public static void popEntity(final WorldRenderer llllllllllllllIlIIllIIIlIIIIIIlI) {
        llllllllllllllIlIIllIIIlIIIIIIlI.sVertexBuilder.popEntity();
    }
    
    public void calcNormal(final WorldRenderer llllllllllllllIlIIllIIIIlIIIllll, final int llllllllllllllIlIIllIIIIlIIIlllI) {
        final FloatBuffer llllllllllllllIlIIllIIIIlIIIllIl = llllllllllllllIlIIllIIIIlIIIllll.rawFloatBuffer;
        final IntBuffer llllllllllllllIlIIllIIIIlIIIllII = llllllllllllllIlIIllIIIIlIIIllll.rawIntBuffer;
        final int llllllllllllllIlIIllIIIIlIIIlIll = llllllllllllllIlIIllIIIIlIIIllll.rawBufferIndex;
        final float llllllllllllllIlIIllIIIIlIIIlIlI = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize);
        final float llllllllllllllIlIIllIIIIlIIIlIIl = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + 1);
        final float llllllllllllllIlIIllIIIIlIIIlIII = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + 2);
        final float llllllllllllllIlIIllIIIIlIIIIlll = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + this.offsetUV);
        final float llllllllllllllIlIIllIIIIlIIIIllI = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + this.offsetUV + 1);
        final float llllllllllllllIlIIllIIIIlIIIIlIl = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize);
        final float llllllllllllllIlIIllIIIIlIIIIlII = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + 1);
        final float llllllllllllllIlIIllIIIIlIIIIIll = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + 2);
        final float llllllllllllllIlIIllIIIIlIIIIIlI = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + this.offsetUV);
        final float llllllllllllllIlIIllIIIIlIIIIIIl = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + this.offsetUV + 1);
        final float llllllllllllllIlIIllIIIIlIIIIIII = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize);
        final float llllllllllllllIlIIllIIIIIlllllll = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + 1);
        final float llllllllllllllIlIIllIIIIIllllllI = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + 2);
        final float llllllllllllllIlIIllIIIIIlllllIl = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + this.offsetUV);
        final float llllllllllllllIlIIllIIIIIlllllII = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + this.offsetUV + 1);
        final float llllllllllllllIlIIllIIIIIllllIll = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize);
        final float llllllllllllllIlIIllIIIIIllllIlI = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + 1);
        final float llllllllllllllIlIIllIIIIIllllIIl = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + 2);
        final float llllllllllllllIlIIllIIIIIllllIII = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + this.offsetUV);
        final float llllllllllllllIlIIllIIIIIlllIlll = llllllllllllllIlIIllIIIIlIIIllIl.get(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + this.offsetUV + 1);
        float llllllllllllllIlIIllIIIIIlllIllI = llllllllllllllIlIIllIIIIlIIIIIII - llllllllllllllIlIIllIIIIlIIIlIlI;
        float llllllllllllllIlIIllIIIIIlllIlIl = llllllllllllllIlIIllIIIIIlllllll - llllllllllllllIlIIllIIIIlIIIlIIl;
        float llllllllllllllIlIIllIIIIIlllIlII = llllllllllllllIlIIllIIIIIllllllI - llllllllllllllIlIIllIIIIlIIIlIII;
        float llllllllllllllIlIIllIIIIIlllIIll = llllllllllllllIlIIllIIIIIllllIll - llllllllllllllIlIIllIIIIlIIIIlIl;
        float llllllllllllllIlIIllIIIIIlllIIlI = llllllllllllllIlIIllIIIIIllllIlI - llllllllllllllIlIIllIIIIlIIIIlII;
        float llllllllllllllIlIIllIIIIIlllIIIl = llllllllllllllIlIIllIIIIIllllIIl - llllllllllllllIlIIllIIIIlIIIIIll;
        float llllllllllllllIlIIllIIIIIlllIIII = llllllllllllllIlIIllIIIIIlllIlIl * llllllllllllllIlIIllIIIIIlllIIIl - llllllllllllllIlIIllIIIIIlllIIlI * llllllllllllllIlIIllIIIIIlllIlII;
        float llllllllllllllIlIIllIIIIIllIllll = llllllllllllllIlIIllIIIIIlllIlII * llllllllllllllIlIIllIIIIIlllIIll - llllllllllllllIlIIllIIIIIlllIIIl * llllllllllllllIlIIllIIIIIlllIllI;
        float llllllllllllllIlIIllIIIIIllIlllI = llllllllllllllIlIIllIIIIIlllIllI * llllllllllllllIlIIllIIIIIlllIIlI - llllllllllllllIlIIllIIIIIlllIIll * llllllllllllllIlIIllIIIIIlllIlIl;
        float llllllllllllllIlIIllIIIIIllIllIl = llllllllllllllIlIIllIIIIIlllIIII * llllllllllllllIlIIllIIIIIlllIIII + llllllllllllllIlIIllIIIIIllIllll * llllllllllllllIlIIllIIIIIllIllll + llllllllllllllIlIIllIIIIIllIlllI * llllllllllllllIlIIllIIIIIllIlllI;
        float llllllllllllllIlIIllIIIIIllIllII = (llllllllllllllIlIIllIIIIIllIllIl != 0.0) ? ((float)(1.0 / Math.sqrt(llllllllllllllIlIIllIIIIIllIllIl))) : 1.0f;
        llllllllllllllIlIIllIIIIIlllIIII *= llllllllllllllIlIIllIIIIIllIllII;
        llllllllllllllIlIIllIIIIIllIllll *= llllllllllllllIlIIllIIIIIllIllII;
        llllllllllllllIlIIllIIIIIllIlllI *= llllllllllllllIlIIllIIIIIllIllII;
        llllllllllllllIlIIllIIIIIlllIllI = llllllllllllllIlIIllIIIIlIIIIlIl - llllllllllllllIlIIllIIIIlIIIlIlI;
        llllllllllllllIlIIllIIIIIlllIlIl = llllllllllllllIlIIllIIIIlIIIIlII - llllllllllllllIlIIllIIIIlIIIlIIl;
        llllllllllllllIlIIllIIIIIlllIlII = llllllllllllllIlIIllIIIIlIIIIIll - llllllllllllllIlIIllIIIIlIIIlIII;
        final float llllllllllllllIlIIllIIIIIllIlIll = llllllllllllllIlIIllIIIIlIIIIIlI - llllllllllllllIlIIllIIIIlIIIIlll;
        final float llllllllllllllIlIIllIIIIIllIlIlI = llllllllllllllIlIIllIIIIlIIIIIIl - llllllllllllllIlIIllIIIIlIIIIllI;
        llllllllllllllIlIIllIIIIIlllIIll = llllllllllllllIlIIllIIIIlIIIIIII - llllllllllllllIlIIllIIIIlIIIlIlI;
        llllllllllllllIlIIllIIIIIlllIIlI = llllllllllllllIlIIllIIIIIlllllll - llllllllllllllIlIIllIIIIlIIIlIIl;
        llllllllllllllIlIIllIIIIIlllIIIl = llllllllllllllIlIIllIIIIIllllllI - llllllllllllllIlIIllIIIIlIIIlIII;
        final float llllllllllllllIlIIllIIIIIllIlIIl = llllllllllllllIlIIllIIIIIlllllIl - llllllllllllllIlIIllIIIIlIIIIlll;
        final float llllllllllllllIlIIllIIIIIllIlIII = llllllllllllllIlIIllIIIIIlllllII - llllllllllllllIlIIllIIIIlIIIIllI;
        final float llllllllllllllIlIIllIIIIIllIIlll = llllllllllllllIlIIllIIIIIllIlIll * llllllllllllllIlIIllIIIIIllIlIII - llllllllllllllIlIIllIIIIIllIlIIl * llllllllllllllIlIIllIIIIIllIlIlI;
        final float llllllllllllllIlIIllIIIIIllIIllI = (llllllllllllllIlIIllIIIIIllIIlll != 0.0f) ? (1.0f / llllllllllllllIlIIllIIIIIllIIlll) : 1.0f;
        float llllllllllllllIlIIllIIIIIllIIlIl = (llllllllllllllIlIIllIIIIIllIlIII * llllllllllllllIlIIllIIIIIlllIllI - llllllllllllllIlIIllIIIIIllIlIlI * llllllllllllllIlIIllIIIIIlllIIll) * llllllllllllllIlIIllIIIIIllIIllI;
        float llllllllllllllIlIIllIIIIIllIIlII = (llllllllllllllIlIIllIIIIIllIlIII * llllllllllllllIlIIllIIIIIlllIlIl - llllllllllllllIlIIllIIIIIllIlIlI * llllllllllllllIlIIllIIIIIlllIIlI) * llllllllllllllIlIIllIIIIIllIIllI;
        float llllllllllllllIlIIllIIIIIllIIIll = (llllllllllllllIlIIllIIIIIllIlIII * llllllllllllllIlIIllIIIIIlllIlII - llllllllllllllIlIIllIIIIIllIlIlI * llllllllllllllIlIIllIIIIIlllIIIl) * llllllllllllllIlIIllIIIIIllIIllI;
        float llllllllllllllIlIIllIIIIIllIIIlI = (llllllllllllllIlIIllIIIIIllIlIll * llllllllllllllIlIIllIIIIIlllIIll - llllllllllllllIlIIllIIIIIllIlIIl * llllllllllllllIlIIllIIIIIlllIllI) * llllllllllllllIlIIllIIIIIllIIllI;
        float llllllllllllllIlIIllIIIIIllIIIIl = (llllllllllllllIlIIllIIIIIllIlIll * llllllllllllllIlIIllIIIIIlllIIlI - llllllllllllllIlIIllIIIIIllIlIIl * llllllllllllllIlIIllIIIIIlllIlIl) * llllllllllllllIlIIllIIIIIllIIllI;
        float llllllllllllllIlIIllIIIIIllIIIII = (llllllllllllllIlIIllIIIIIllIlIll * llllllllllllllIlIIllIIIIIlllIIIl - llllllllllllllIlIIllIIIIIllIlIIl * llllllllllllllIlIIllIIIIIlllIlII) * llllllllllllllIlIIllIIIIIllIIllI;
        llllllllllllllIlIIllIIIIIllIllIl = llllllllllllllIlIIllIIIIIllIIlIl * llllllllllllllIlIIllIIIIIllIIlIl + llllllllllllllIlIIllIIIIIllIIlII * llllllllllllllIlIIllIIIIIllIIlII + llllllllllllllIlIIllIIIIIllIIIll * llllllllllllllIlIIllIIIIIllIIIll;
        llllllllllllllIlIIllIIIIIllIllII = ((llllllllllllllIlIIllIIIIIllIllIl != 0.0) ? ((float)(1.0 / Math.sqrt(llllllllllllllIlIIllIIIIIllIllIl))) : 1.0f);
        llllllllllllllIlIIllIIIIIllIIlIl *= llllllllllllllIlIIllIIIIIllIllII;
        llllllllllllllIlIIllIIIIIllIIlII *= llllllllllllllIlIIllIIIIIllIllII;
        llllllllllllllIlIIllIIIIIllIIIll *= llllllllllllllIlIIllIIIIIllIllII;
        llllllllllllllIlIIllIIIIIllIllIl = llllllllllllllIlIIllIIIIIllIIIlI * llllllllllllllIlIIllIIIIIllIIIlI + llllllllllllllIlIIllIIIIIllIIIIl * llllllllllllllIlIIllIIIIIllIIIIl + llllllllllllllIlIIllIIIIIllIIIII * llllllllllllllIlIIllIIIIIllIIIII;
        llllllllllllllIlIIllIIIIIllIllII = ((llllllllllllllIlIIllIIIIIllIllIl != 0.0) ? ((float)(1.0 / Math.sqrt(llllllllllllllIlIIllIIIIIllIllIl))) : 1.0f);
        llllllllllllllIlIIllIIIIIllIIIlI *= llllllllllllllIlIIllIIIIIllIllII;
        llllllllllllllIlIIllIIIIIllIIIIl *= llllllllllllllIlIIllIIIIIllIllII;
        llllllllllllllIlIIllIIIIIllIIIII *= llllllllllllllIlIIllIIIIIllIllII;
        final float llllllllllllllIlIIllIIIIIlIlllll = llllllllllllllIlIIllIIIIIllIlllI * llllllllllllllIlIIllIIIIIllIIlII - llllllllllllllIlIIllIIIIIllIllll * llllllllllllllIlIIllIIIIIllIIIll;
        final float llllllllllllllIlIIllIIIIIlIllllI = llllllllllllllIlIIllIIIIIlllIIII * llllllllllllllIlIIllIIIIIllIIIll - llllllllllllllIlIIllIIIIIllIlllI * llllllllllllllIlIIllIIIIIllIIlIl;
        final float llllllllllllllIlIIllIIIIIlIlllIl = llllllllllllllIlIIllIIIIIllIllll * llllllllllllllIlIIllIIIIIllIIlIl - llllllllllllllIlIIllIIIIIlllIIII * llllllllllllllIlIIllIIIIIllIIlII;
        final float llllllllllllllIlIIllIIIIIlIlllII = (llllllllllllllIlIIllIIIIIllIIIlI * llllllllllllllIlIIllIIIIIlIlllll + llllllllllllllIlIIllIIIIIllIIIIl * llllllllllllllIlIIllIIIIIlIllllI + llllllllllllllIlIIllIIIIIllIIIII * llllllllllllllIlIIllIIIIIlIlllIl < 0.0f) ? -1.0f : 1.0f;
        final int llllllllllllllIlIIllIIIIIlIllIll = (int)(llllllllllllllIlIIllIIIIIlllIIII * 127.0f) & 0xFF;
        final int llllllllllllllIlIIllIIIIIlIllIlI = (int)(llllllllllllllIlIIllIIIIIllIllll * 127.0f) & 0xFF;
        final int llllllllllllllIlIIllIIIIIlIllIIl = (int)(llllllllllllllIlIIllIIIIIllIlllI * 127.0f) & 0xFF;
        final int llllllllllllllIlIIllIIIIIlIllIII = (llllllllllllllIlIIllIIIIIlIllIIl << 16) + (llllllllllllllIlIIllIIIIIlIllIlI << 8) + llllllllllllllIlIIllIIIIIlIllIll;
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + this.offsetNormal, llllllllllllllIlIIllIIIIIlIllIII);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + this.offsetNormal, llllllllllllllIlIIllIIIIIlIllIII);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + this.offsetNormal, llllllllllllllIlIIllIIIIIlIllIII);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + this.offsetNormal, llllllllllllllIlIIllIIIIIlIllIII);
        final int llllllllllllllIlIIllIIIIIlIlIlll = ((int)(llllllllllllllIlIIllIIIIIllIIlIl * 32767.0f) & 0xFFFF) + (((int)(llllllllllllllIlIIllIIIIIllIIlII * 32767.0f) & 0xFFFF) << 16);
        final int llllllllllllllIlIIllIIIIIlIlIllI = ((int)(llllllllllllllIlIIllIIIIIllIIIll * 32767.0f) & 0xFFFF) + (((int)(llllllllllllllIlIIllIIIIIlIlllII * 32767.0f) & 0xFFFF) << 16);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + 10, llllllllllllllIlIIllIIIIIlIlIlll);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + 10 + 1, llllllllllllllIlIIllIIIIIlIlIllI);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + 10, llllllllllllllIlIIllIIIIIlIlIlll);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + 10 + 1, llllllllllllllIlIIllIIIIIlIlIllI);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + 10, llllllllllllllIlIIllIIIIIlIlIlll);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + 10 + 1, llllllllllllllIlIIllIIIIIlIlIllI);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + 10, llllllllllllllIlIIllIIIIIlIlIlll);
        llllllllllllllIlIIllIIIIlIIIllII.put(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + 10 + 1, llllllllllllllIlIIllIIIIIlIlIllI);
        final float llllllllllllllIlIIllIIIIIlIlIlIl = (llllllllllllllIlIIllIIIIlIIIIlll + llllllllllllllIlIIllIIIIlIIIIIlI + llllllllllllllIlIIllIIIIIlllllIl + llllllllllllllIlIIllIIIIIllllIII) / 4.0f;
        final float llllllllllllllIlIIllIIIIIlIlIlII = (llllllllllllllIlIIllIIIIlIIIIllI + llllllllllllllIlIIllIIIIlIIIIIIl + llllllllllllllIlIIllIIIIIlllllII + llllllllllllllIlIIllIIIIIlllIlll) / 4.0f;
        llllllllllllllIlIIllIIIIlIIIllIl.put(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + 8, llllllllllllllIlIIllIIIIIlIlIlIl);
        llllllllllllllIlIIllIIIIlIIIllIl.put(llllllllllllllIlIIllIIIIlIIIlllI + 0 * this.vertexSize + 8 + 1, llllllllllllllIlIIllIIIIIlIlIlII);
        llllllllllllllIlIIllIIIIlIIIllIl.put(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + 8, llllllllllllllIlIIllIIIIIlIlIlIl);
        llllllllllllllIlIIllIIIIlIIIllIl.put(llllllllllllllIlIIllIIIIlIIIlllI + 1 * this.vertexSize + 8 + 1, llllllllllllllIlIIllIIIIIlIlIlII);
        llllllllllllllIlIIllIIIIlIIIllIl.put(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + 8, llllllllllllllIlIIllIIIIIlIlIlIl);
        llllllllllllllIlIIllIIIIlIIIllIl.put(llllllllllllllIlIIllIIIIlIIIlllI + 2 * this.vertexSize + 8 + 1, llllllllllllllIlIIllIIIIIlIlIlII);
        llllllllllllllIlIIllIIIIlIIIllIl.put(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + 8, llllllllllllllIlIIllIIIIIlIlIlIl);
        llllllllllllllIlIIllIIIIlIIIllIl.put(llllllllllllllIlIIllIIIIlIIIlllI + 3 * this.vertexSize + 8 + 1, llllllllllllllIlIIllIIIIIlIlIlII);
    }
    
    public static void pushEntity(final IBlockState llllllllllllllIlIIllIIIlIIIIlIll, final BlockPos llllllllllllllIlIIllIIIlIIIlIlII, final IBlockAccess llllllllllllllIlIIllIIIlIIIlIIll, final WorldRenderer llllllllllllllIlIIllIIIlIIIIlIlI) {
        final Block llllllllllllllIlIIllIIIlIIIlIIIl = llllllllllllllIlIIllIIIlIIIIlIll.getBlock();
        final int llllllllllllllIlIIllIIIlIIIlIIII = Block.getIdFromBlock(llllllllllllllIlIIllIIIlIIIlIIIl);
        final int llllllllllllllIlIIllIIIlIIIIllll = llllllllllllllIlIIllIIIlIIIlIIIl.getRenderType();
        final int llllllllllllllIlIIllIIIlIIIIlllI = llllllllllllllIlIIllIIIlIIIlIIIl.getMetaFromState(llllllllllllllIlIIllIIIlIIIIlIll);
        final int llllllllllllllIlIIllIIIlIIIIllIl = ((llllllllllllllIlIIllIIIlIIIIllll & 0xFFFF) << 16) + (llllllllllllllIlIIllIIIlIIIlIIII & 0xFFFF);
        final int llllllllllllllIlIIllIIIlIIIIllII = llllllllllllllIlIIllIIIlIIIIlllI & 0xFFFF;
        llllllllllllllIlIIllIIIlIIIIlIlI.sVertexBuilder.pushEntity(((long)llllllllllllllIlIIllIIIlIIIIllII << 32) + llllllllllllllIlIIllIIIlIIIIllIl);
    }
    
    public static void endSetVertexFormat(final WorldRenderer llllllllllllllIlIIllIIIIllllIlll) {
        final SVertexBuilder llllllllllllllIlIIllIIIIllllIllI = llllllllllllllIlIIllIIIIllllIlll.sVertexBuilder;
        final VertexFormat llllllllllllllIlIIllIIIIllllIlIl = llllllllllllllIlIIllIIIIllllIlll.func_178973_g();
        llllllllllllllIlIIllIIIIllllIllI.vertexSize = llllllllllllllIlIIllIIIIllllIlIl.func_177338_f() / 4;
        llllllllllllllIlIIllIIIIllllIllI.hasNormal = llllllllllllllIlIIllIIIIllllIlIl.func_177350_b();
        llllllllllllllIlIIllIIIIllllIllI.hasTangent = llllllllllllllIlIIllIIIIllllIllI.hasNormal;
        llllllllllllllIlIIllIIIIllllIllI.hasUV = llllllllllllllIlIIllIIIIllllIlIl.func_177347_a(0);
        llllllllllllllIlIIllIIIIllllIllI.offsetNormal = (llllllllllllllIlIIllIIIIllllIllI.hasNormal ? (llllllllllllllIlIIllIIIIllllIlIl.func_177342_c() / 4) : 0);
        llllllllllllllIlIIllIIIIllllIllI.offsetUV = (llllllllllllllIlIIllIIIIllllIllI.hasUV ? (llllllllllllllIlIIllIIIIllllIlIl.func_177344_b(0) / 4) : 0);
        llllllllllllllIlIIllIIIIllllIllI.offsetUVCenter = 8;
    }
    
    public static void beginAddVertexData(final WorldRenderer llllllllllllllIlIIllIIIIllIlllIl, final int[] llllllllllllllIlIIllIIIIllIlIlll) {
        if (llllllllllllllIlIIllIIIIllIlllIl.vertexCount == 0) {
            endSetVertexFormat(llllllllllllllIlIIllIIIIllIlllIl);
        }
        final SVertexBuilder llllllllllllllIlIIllIIIIllIllIll = llllllllllllllIlIIllIIIIllIlllIl.sVertexBuilder;
        if (llllllllllllllIlIIllIIIIllIllIll.vertexSize == 14) {
            final long llllllllllllllIlIIllIIIIllIllIlI = llllllllllllllIlIIllIIIIllIllIll.entityData[llllllllllllllIlIIllIIIIllIllIll.entityDataIndex];
            for (int llllllllllllllIlIIllIIIIllIllIIl = 12; llllllllllllllIlIIllIIIIllIllIIl + 1 < llllllllllllllIlIIllIIIIllIlIlll.length; llllllllllllllIlIIllIIIIllIllIIl += 14) {
                llllllllllllllIlIIllIIIIllIlIlll[llllllllllllllIlIIllIIIIllIllIIl] = (int)llllllllllllllIlIIllIIIIllIllIlI;
                llllllllllllllIlIIllIIIIllIlIlll[llllllllllllllIlIIllIIIIllIllIIl + 1] = (int)(llllllllllllllIlIIllIIIIllIllIlI >> 32);
            }
        }
    }
    
    public void pushEntity(final long llllllllllllllIlIIllIIIlIIlIIIll) {
        ++this.entityDataIndex;
        this.entityData[this.entityDataIndex] = llllllllllllllIlIIllIIIlIIlIIIll;
    }
}
