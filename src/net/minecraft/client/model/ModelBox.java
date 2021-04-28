package net.minecraft.client.model;

import net.minecraft.client.renderer.*;

public class ModelBox
{
    private /* synthetic */ PositionTextureVertex[] vertexPositions;
    private /* synthetic */ TexturedQuad[] quadList;
    public final /* synthetic */ float posX1;
    public final /* synthetic */ float posY2;
    public final /* synthetic */ float posZ1;
    public final /* synthetic */ float posZ2;
    public /* synthetic */ String field_78247_g;
    public final /* synthetic */ float posY1;
    public final /* synthetic */ float posX2;
    
    public void render(final WorldRenderer llllllllllllllllllllIIIllIIllIll, final float llllllllllllllllllllIIIllIIlIllI) {
        for (int llllllllllllllllllllIIIllIIllIIl = 0; llllllllllllllllllllIIIllIIllIIl < this.quadList.length; ++llllllllllllllllllllIIIllIIllIIl) {
            this.quadList[llllllllllllllllllllIIIllIIllIIl].func_178765_a(llllllllllllllllllllIIIllIIllIll, llllllllllllllllllllIIIllIIlIllI);
        }
    }
    
    public ModelBox(final ModelRenderer llllllllllllllllllllIIIllIllIlll, final int llllllllllllllllllllIIIllIllIllI, final int llllllllllllllllllllIIIllIllIlIl, float llllllllllllllllllllIIIllIllIlII, float llllllllllllllllllllIIIllIllIIll, float llllllllllllllllllllIIIlllIIlIll, final int llllllllllllllllllllIIIllIllIIIl, final int llllllllllllllllllllIIIllIllIIII, final int llllllllllllllllllllIIIllIlIllll, final float llllllllllllllllllllIIIllIlIlllI, final boolean llllllllllllllllllllIIIllIlIllIl) {
        this.posX1 = llllllllllllllllllllIIIllIllIlII;
        this.posY1 = llllllllllllllllllllIIIllIllIIll;
        this.posZ1 = llllllllllllllllllllIIIlllIIlIll;
        this.posX2 = llllllllllllllllllllIIIllIllIlII + llllllllllllllllllllIIIllIllIIIl;
        this.posY2 = llllllllllllllllllllIIIllIllIIll + llllllllllllllllllllIIIllIllIIII;
        this.posZ2 = llllllllllllllllllllIIIlllIIlIll + llllllllllllllllllllIIIllIlIllll;
        this.vertexPositions = new PositionTextureVertex[8];
        this.quadList = new TexturedQuad[6];
        float llllllllllllllllllllIIIlllIIIlIl = llllllllllllllllllllIIIllIllIlII + llllllllllllllllllllIIIllIllIIIl;
        float llllllllllllllllllllIIIlllIIIlII = llllllllllllllllllllIIIllIllIIll + llllllllllllllllllllIIIllIllIIII;
        float llllllllllllllllllllIIIlllIIIIll = llllllllllllllllllllIIIlllIIlIll + llllllllllllllllllllIIIllIlIllll;
        llllllllllllllllllllIIIllIllIlII -= llllllllllllllllllllIIIllIlIlllI;
        llllllllllllllllllllIIIllIllIIll -= llllllllllllllllllllIIIllIlIlllI;
        llllllllllllllllllllIIIlllIIlIll -= llllllllllllllllllllIIIllIlIlllI;
        llllllllllllllllllllIIIlllIIIlIl += llllllllllllllllllllIIIllIlIlllI;
        llllllllllllllllllllIIIlllIIIlII += llllllllllllllllllllIIIllIlIlllI;
        llllllllllllllllllllIIIlllIIIIll += llllllllllllllllllllIIIllIlIlllI;
        if (llllllllllllllllllllIIIllIlIllIl) {
            final float llllllllllllllllllllIIIlllIIIIlI = llllllllllllllllllllIIIlllIIIlIl;
            llllllllllllllllllllIIIlllIIIlIl = llllllllllllllllllllIIIllIllIlII;
            llllllllllllllllllllIIIllIllIlII = llllllllllllllllllllIIIlllIIIIlI;
        }
        final PositionTextureVertex llllllllllllllllllllIIIlllIIIIIl = new PositionTextureVertex(llllllllllllllllllllIIIllIllIlII, llllllllllllllllllllIIIllIllIIll, llllllllllllllllllllIIIlllIIlIll, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllllllllIIIlllIIIIII = new PositionTextureVertex(llllllllllllllllllllIIIlllIIIlIl, llllllllllllllllllllIIIllIllIIll, llllllllllllllllllllIIIlllIIlIll, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllllllllIIIllIllllll = new PositionTextureVertex(llllllllllllllllllllIIIlllIIIlIl, llllllllllllllllllllIIIlllIIIlII, llllllllllllllllllllIIIlllIIlIll, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllllllllIIIllIlllllI = new PositionTextureVertex(llllllllllllllllllllIIIllIllIlII, llllllllllllllllllllIIIlllIIIlII, llllllllllllllllllllIIIlllIIlIll, 8.0f, 0.0f);
        final PositionTextureVertex llllllllllllllllllllIIIllIllllIl = new PositionTextureVertex(llllllllllllllllllllIIIllIllIlII, llllllllllllllllllllIIIllIllIIll, llllllllllllllllllllIIIlllIIIIll, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllllllllIIIllIllllII = new PositionTextureVertex(llllllllllllllllllllIIIlllIIIlIl, llllllllllllllllllllIIIllIllIIll, llllllllllllllllllllIIIlllIIIIll, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllllllllIIIllIlllIll = new PositionTextureVertex(llllllllllllllllllllIIIlllIIIlIl, llllllllllllllllllllIIIlllIIIlII, llllllllllllllllllllIIIlllIIIIll, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllllllllIIIllIlllIlI = new PositionTextureVertex(llllllllllllllllllllIIIllIllIlII, llllllllllllllllllllIIIlllIIIlII, llllllllllllllllllllIIIlllIIIIll, 8.0f, 0.0f);
        this.vertexPositions[0] = llllllllllllllllllllIIIlllIIIIIl;
        this.vertexPositions[1] = llllllllllllllllllllIIIlllIIIIII;
        this.vertexPositions[2] = llllllllllllllllllllIIIllIllllll;
        this.vertexPositions[3] = llllllllllllllllllllIIIllIlllllI;
        this.vertexPositions[4] = llllllllllllllllllllIIIllIllllIl;
        this.vertexPositions[5] = llllllllllllllllllllIIIllIllllII;
        this.vertexPositions[6] = llllllllllllllllllllIIIllIlllIll;
        this.vertexPositions[7] = llllllllllllllllllllIIIllIlllIlI;
        this.quadList[0] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllllllllIIIllIllllII, llllllllllllllllllllIIIlllIIIIII, llllllllllllllllllllIIIllIllllll, llllllllllllllllllllIIIllIlllIll }, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIII, llllllllllllllllllllIIIllIllIlll.textureWidth, llllllllllllllllllllIIIllIllIlll.textureHeight);
        this.quadList[1] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllllllllIIIlllIIIIIl, llllllllllllllllllllIIIllIllllIl, llllllllllllllllllllIIIllIlllIlI, llllllllllllllllllllIIIllIlllllI }, llllllllllllllllllllIIIllIllIllI, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIII, llllllllllllllllllllIIIllIllIlll.textureWidth, llllllllllllllllllllIIIllIllIlll.textureHeight);
        this.quadList[2] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllllllllIIIllIllllII, llllllllllllllllllllIIIllIllllIl, llllllllllllllllllllIIIlllIIIIIl, llllllllllllllllllllIIIlllIIIIII }, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIlIl, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIlll.textureWidth, llllllllllllllllllllIIIllIllIlll.textureHeight);
        this.quadList[3] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllllllllIIIllIllllll, llllllllllllllllllllIIIllIlllllI, llllllllllllllllllllIIIllIlllIlI, llllllllllllllllllllIIIllIlllIll }, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl + llllllllllllllllllllIIIllIllIIIl, llllllllllllllllllllIIIllIllIlIl, llllllllllllllllllllIIIllIllIlll.textureWidth, llllllllllllllllllllIIIllIllIlll.textureHeight);
        this.quadList[4] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllllllllIIIlllIIIIII, llllllllllllllllllllIIIlllIIIIIl, llllllllllllllllllllIIIllIlllllI, llllllllllllllllllllIIIllIllllll }, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIII, llllllllllllllllllllIIIllIllIlll.textureWidth, llllllllllllllllllllIIIllIllIlll.textureHeight);
        this.quadList[5] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllllllllIIIllIllllIl, llllllllllllllllllllIIIllIllllII, llllllllllllllllllllIIIllIlllIll, llllllllllllllllllllIIIllIlllIlI }, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIllIllI + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIIl, llllllllllllllllllllIIIllIllIlIl + llllllllllllllllllllIIIllIlIllll + llllllllllllllllllllIIIllIllIIII, llllllllllllllllllllIIIllIllIlll.textureWidth, llllllllllllllllllllIIIllIllIlll.textureHeight);
        if (llllllllllllllllllllIIIllIlIllIl) {
            for (int llllllllllllllllllllIIIllIlllIIl = 0; llllllllllllllllllllIIIllIlllIIl < this.quadList.length; ++llllllllllllllllllllIIIllIlllIIl) {
                this.quadList[llllllllllllllllllllIIIllIlllIIl].flipFace();
            }
        }
    }
    
    public ModelBox func_78244_a(final String llllllllllllllllllllIIIllIIlIIIl) {
        this.field_78247_g = llllllllllllllllllllIIIllIIlIIIl;
        return this;
    }
    
    public ModelBox(final ModelRenderer llllllllllllllllllllIIIlllllIIll, final int llllllllllllllllllllIIIlllllIIlI, final int llllllllllllllllllllIIIlllllllII, final float llllllllllllllllllllIIIlllllIIII, final float llllllllllllllllllllIIIllllIllll, final float llllllllllllllllllllIIIllllllIIl, final int llllllllllllllllllllIIIllllIllIl, final int llllllllllllllllllllIIIllllIllII, final int llllllllllllllllllllIIIlllllIllI, final float llllllllllllllllllllIIIlllllIlIl) {
        this(llllllllllllllllllllIIIlllllIIll, llllllllllllllllllllIIIlllllIIlI, llllllllllllllllllllIIIlllllllII, llllllllllllllllllllIIIlllllIIII, llllllllllllllllllllIIIllllIllll, llllllllllllllllllllIIIllllllIIl, llllllllllllllllllllIIIllllIllIl, llllllllllllllllllllIIIllllIllII, llllllllllllllllllllIIIlllllIllI, llllllllllllllllllllIIIlllllIlIl, llllllllllllllllllllIIIlllllIIll.mirror);
    }
    
    static {
        __OBFID = "CL_00000872";
    }
}
