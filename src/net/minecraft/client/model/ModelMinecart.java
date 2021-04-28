package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelMinecart extends ModelBase
{
    public /* synthetic */ ModelRenderer[] sideModels;
    
    @Override
    public void render(final Entity llllllllllllllIIlIlIllIIIIlllIlI, final float llllllllllllllIIlIlIllIIIIlllIIl, final float llllllllllllllIIlIlIllIIIIlllIII, final float llllllllllllllIIlIlIllIIIIllIIIl, final float llllllllllllllIIlIlIllIIIIllIllI, final float llllllllllllllIIlIlIllIIIIllIlIl, final float llllllllllllllIIlIlIllIIIIllIIII) {
        this.sideModels[5].rotationPointY = 4.0f - llllllllllllllIIlIlIllIIIIllIIIl;
        for (int llllllllllllllIIlIlIllIIIIllIIll = 0; llllllllllllllIIlIlIllIIIIllIIll < 6; ++llllllllllllllIIlIlIllIIIIllIIll) {
            this.sideModels[llllllllllllllIIlIlIllIIIIllIIll].render(llllllllllllllIIlIlIllIIIIllIIII);
        }
    }
    
    public ModelMinecart() {
        this.sideModels = new ModelRenderer[7];
        this.sideModels[0] = new ModelRenderer(this, 0, 10);
        this.sideModels[1] = new ModelRenderer(this, 0, 0);
        this.sideModels[2] = new ModelRenderer(this, 0, 0);
        this.sideModels[3] = new ModelRenderer(this, 0, 0);
        this.sideModels[4] = new ModelRenderer(this, 0, 0);
        this.sideModels[5] = new ModelRenderer(this, 44, 10);
        final byte llllllllllllllIIlIlIllIIIlIIlIII = 20;
        final byte llllllllllllllIIlIlIllIIIlIIIlll = 8;
        final byte llllllllllllllIIlIlIllIIIlIIIllI = 16;
        final byte llllllllllllllIIlIlIllIIIlIIIlIl = 4;
        this.sideModels[0].addBox((float)(-llllllllllllllIIlIlIllIIIlIIlIII / 2), (float)(-llllllllllllllIIlIlIllIIIlIIIllI / 2), -1.0f, llllllllllllllIIlIlIllIIIlIIlIII, llllllllllllllIIlIlIllIIIlIIIllI, 2, 0.0f);
        this.sideModels[0].setRotationPoint(0.0f, llllllllllllllIIlIlIllIIIlIIIlIl, 0.0f);
        this.sideModels[5].addBox((float)(-llllllllllllllIIlIlIllIIIlIIlIII / 2 + 1), (float)(-llllllllllllllIIlIlIllIIIlIIIllI / 2 + 1), -1.0f, llllllllllllllIIlIlIllIIIlIIlIII - 2, llllllllllllllIIlIlIllIIIlIIIllI - 2, 1, 0.0f);
        this.sideModels[5].setRotationPoint(0.0f, llllllllllllllIIlIlIllIIIlIIIlIl, 0.0f);
        this.sideModels[1].addBox((float)(-llllllllllllllIIlIlIllIIIlIIlIII / 2 + 2), (float)(-llllllllllllllIIlIlIllIIIlIIIlll - 1), -1.0f, llllllllllllllIIlIlIllIIIlIIlIII - 4, llllllllllllllIIlIlIllIIIlIIIlll, 2, 0.0f);
        this.sideModels[1].setRotationPoint((float)(-llllllllllllllIIlIlIllIIIlIIlIII / 2 + 1), llllllllllllllIIlIlIllIIIlIIIlIl, 0.0f);
        this.sideModels[2].addBox((float)(-llllllllllllllIIlIlIllIIIlIIlIII / 2 + 2), (float)(-llllllllllllllIIlIlIllIIIlIIIlll - 1), -1.0f, llllllllllllllIIlIlIllIIIlIIlIII - 4, llllllllllllllIIlIlIllIIIlIIIlll, 2, 0.0f);
        this.sideModels[2].setRotationPoint((float)(llllllllllllllIIlIlIllIIIlIIlIII / 2 - 1), llllllllllllllIIlIlIllIIIlIIIlIl, 0.0f);
        this.sideModels[3].addBox((float)(-llllllllllllllIIlIlIllIIIlIIlIII / 2 + 2), (float)(-llllllllllllllIIlIlIllIIIlIIIlll - 1), -1.0f, llllllllllllllIIlIlIllIIIlIIlIII - 4, llllllllllllllIIlIlIllIIIlIIIlll, 2, 0.0f);
        this.sideModels[3].setRotationPoint(0.0f, llllllllllllllIIlIlIllIIIlIIIlIl, (float)(-llllllllllllllIIlIlIllIIIlIIIllI / 2 + 1));
        this.sideModels[4].addBox((float)(-llllllllllllllIIlIlIllIIIlIIlIII / 2 + 2), (float)(-llllllllllllllIIlIlIllIIIlIIIlll - 1), -1.0f, llllllllllllllIIlIlIllIIIlIIlIII - 4, llllllllllllllIIlIlIllIIIlIIIlll, 2, 0.0f);
        this.sideModels[4].setRotationPoint(0.0f, llllllllllllllIIlIlIllIIIlIIIlIl, (float)(llllllllllllllIIlIlIllIIIlIIIllI / 2 - 1));
        this.sideModels[0].rotateAngleX = 1.5707964f;
        this.sideModels[1].rotateAngleY = 4.712389f;
        this.sideModels[2].rotateAngleY = 1.5707964f;
        this.sideModels[3].rotateAngleY = 3.1415927f;
        this.sideModels[5].rotateAngleX = -1.5707964f;
    }
    
    static {
        __OBFID = "CL_00000844";
    }
}
