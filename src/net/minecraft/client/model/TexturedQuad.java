package net.minecraft.client.model;

import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class TexturedQuad
{
    private /* synthetic */ boolean invertNormal;
    public /* synthetic */ PositionTextureVertex[] vertexPositions;
    public /* synthetic */ int nVertices;
    
    public void flipFace() {
        final PositionTextureVertex[] llllllllllllllIlIIIllIIllIllIIIl = new PositionTextureVertex[this.vertexPositions.length];
        for (int llllllllllllllIlIIIllIIllIllIIII = 0; llllllllllllllIlIIIllIIllIllIIII < this.vertexPositions.length; ++llllllllllllllIlIIIllIIllIllIIII) {
            llllllllllllllIlIIIllIIllIllIIIl[llllllllllllllIlIIIllIIllIllIIII] = this.vertexPositions[this.vertexPositions.length - llllllllllllllIlIIIllIIllIllIIII - 1];
        }
        this.vertexPositions = llllllllllllllIlIIIllIIllIllIIIl;
    }
    
    public TexturedQuad(final PositionTextureVertex[] llllllllllllllIlIIIllIIllIlllllI, final int llllllllllllllIlIIIllIIlllIIIlll, final int llllllllllllllIlIIIllIIlllIIIllI, final int llllllllllllllIlIIIllIIllIlllIll, final int llllllllllllllIlIIIllIIllIlllIlI, final float llllllllllllllIlIIIllIIlllIIIIll, final float llllllllllllllIlIIIllIIllIlllIII) {
        this(llllllllllllllIlIIIllIIllIlllllI);
        final float llllllllllllllIlIIIllIIlllIIIIIl = 0.0f / llllllllllllllIlIIIllIIlllIIIIll;
        final float llllllllllllllIlIIIllIIlllIIIIII = 0.0f / llllllllllllllIlIIIllIIllIlllIII;
        llllllllllllllIlIIIllIIllIlllllI[0] = llllllllllllllIlIIIllIIllIlllllI[0].setTexturePosition(llllllllllllllIlIIIllIIllIlllIll / llllllllllllllIlIIIllIIlllIIIIll - llllllllllllllIlIIIllIIlllIIIIIl, llllllllllllllIlIIIllIIlllIIIllI / llllllllllllllIlIIIllIIllIlllIII + llllllllllllllIlIIIllIIlllIIIIII);
        llllllllllllllIlIIIllIIllIlllllI[1] = llllllllllllllIlIIIllIIllIlllllI[1].setTexturePosition(llllllllllllllIlIIIllIIlllIIIlll / llllllllllllllIlIIIllIIlllIIIIll + llllllllllllllIlIIIllIIlllIIIIIl, llllllllllllllIlIIIllIIlllIIIllI / llllllllllllllIlIIIllIIllIlllIII + llllllllllllllIlIIIllIIlllIIIIII);
        llllllllllllllIlIIIllIIllIlllllI[2] = llllllllllllllIlIIIllIIllIlllllI[2].setTexturePosition(llllllllllllllIlIIIllIIlllIIIlll / llllllllllllllIlIIIllIIlllIIIIll + llllllllllllllIlIIIllIIlllIIIIIl, llllllllllllllIlIIIllIIllIlllIlI / llllllllllllllIlIIIllIIllIlllIII - llllllllllllllIlIIIllIIlllIIIIII);
        llllllllllllllIlIIIllIIllIlllllI[3] = llllllllllllllIlIIIllIIllIlllllI[3].setTexturePosition(llllllllllllllIlIIIllIIllIlllIll / llllllllllllllIlIIIllIIlllIIIIll - llllllllllllllIlIIIllIIlllIIIIIl, llllllllllllllIlIIIllIIllIlllIlI / llllllllllllllIlIIIllIIllIlllIII - llllllllllllllIlIIIllIIlllIIIIII);
    }
    
    static {
        __OBFID = "CL_00000850";
    }
    
    public TexturedQuad(final PositionTextureVertex[] llllllllllllllIlIIIllIIlllIlIlII) {
        this.vertexPositions = llllllllllllllIlIIIllIIlllIlIlII;
        this.nVertices = llllllllllllllIlIIIllIIlllIlIlII.length;
    }
    
    public void func_178765_a(final WorldRenderer llllllllllllllIlIIIllIIllIIllIll, final float llllllllllllllIlIIIllIIllIIllIlI) {
        final Vec3 llllllllllllllIlIIIllIIllIlIIIIl = this.vertexPositions[1].vector3D.subtractReverse(this.vertexPositions[0].vector3D);
        final Vec3 llllllllllllllIlIIIllIIllIlIIIII = this.vertexPositions[1].vector3D.subtractReverse(this.vertexPositions[2].vector3D);
        final Vec3 llllllllllllllIlIIIllIIllIIlllll = llllllllllllllIlIIIllIIllIlIIIII.crossProduct(llllllllllllllIlIIIllIIllIlIIIIl).normalize();
        llllllllllllllIlIIIllIIllIIllIll.startDrawingQuads();
        if (Config.isShaders()) {
            SVertexBuilder.startTexturedQuad(llllllllllllllIlIIIllIIllIIllIll);
        }
        if (this.invertNormal) {
            llllllllllllllIlIIIllIIllIIllIll.func_178980_d(-(float)llllllllllllllIlIIIllIIllIIlllll.xCoord, -(float)llllllllllllllIlIIIllIIllIIlllll.yCoord, -(float)llllllllllllllIlIIIllIIllIIlllll.zCoord);
        }
        else {
            llllllllllllllIlIIIllIIllIIllIll.func_178980_d((float)llllllllllllllIlIIIllIIllIIlllll.xCoord, (float)llllllllllllllIlIIIllIIllIIlllll.yCoord, (float)llllllllllllllIlIIIllIIllIIlllll.zCoord);
        }
        for (int llllllllllllllIlIIIllIIllIIllllI = 0; llllllllllllllIlIIIllIIllIIllllI < 4; ++llllllllllllllIlIIIllIIllIIllllI) {
            final PositionTextureVertex llllllllllllllIlIIIllIIllIIlllIl = this.vertexPositions[llllllllllllllIlIIIllIIllIIllllI];
            llllllllllllllIlIIIllIIllIIllIll.addVertexWithUV(llllllllllllllIlIIIllIIllIIlllIl.vector3D.xCoord * llllllllllllllIlIIIllIIllIIllIlI, llllllllllllllIlIIIllIIllIIlllIl.vector3D.yCoord * llllllllllllllIlIIIllIIllIIllIlI, llllllllllllllIlIIIllIIllIIlllIl.vector3D.zCoord * llllllllllllllIlIIIllIIllIIllIlI, llllllllllllllIlIIIllIIllIIlllIl.texturePositionX, llllllllllllllIlIIIllIIllIIlllIl.texturePositionY);
        }
        Tessellator.getInstance().draw();
    }
}
