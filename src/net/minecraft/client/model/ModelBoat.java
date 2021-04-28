package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelBoat extends ModelBase
{
    public /* synthetic */ ModelRenderer[] boatSides;
    
    @Override
    public void render(final Entity lllllllllllllllIlIlIIIllIllIlIIl, final float lllllllllllllllIlIlIIIllIllIlIII, final float lllllllllllllllIlIlIIIllIllIIlll, final float lllllllllllllllIlIlIIIllIllIIllI, final float lllllllllllllllIlIlIIIllIllIIlIl, final float lllllllllllllllIlIlIIIllIllIIlII, final float lllllllllllllllIlIlIIIllIllIIIII) {
        for (int lllllllllllllllIlIlIIIllIllIIIlI = 0; lllllllllllllllIlIlIIIllIllIIIlI < 5; ++lllllllllllllllIlIlIIIllIllIIIlI) {
            this.boatSides[lllllllllllllllIlIlIIIllIllIIIlI].render(lllllllllllllllIlIlIIIllIllIIIII);
        }
    }
    
    static {
        __OBFID = "CL_00000832";
    }
    
    public ModelBoat() {
        this.boatSides = new ModelRenderer[5];
        this.boatSides[0] = new ModelRenderer(this, 0, 8);
        this.boatSides[1] = new ModelRenderer(this, 0, 0);
        this.boatSides[2] = new ModelRenderer(this, 0, 0);
        this.boatSides[3] = new ModelRenderer(this, 0, 0);
        this.boatSides[4] = new ModelRenderer(this, 0, 0);
        final byte lllllllllllllllIlIlIIIllIlllIllI = 24;
        final byte lllllllllllllllIlIlIIIllIlllIlIl = 6;
        final byte lllllllllllllllIlIlIIIllIlllIlII = 20;
        final byte lllllllllllllllIlIlIIIllIlllIIll = 4;
        this.boatSides[0].addBox((float)(-lllllllllllllllIlIlIIIllIlllIllI / 2), (float)(-lllllllllllllllIlIlIIIllIlllIlII / 2 + 2), -3.0f, lllllllllllllllIlIlIIIllIlllIllI, lllllllllllllllIlIlIIIllIlllIlII - 4, 4, 0.0f);
        this.boatSides[0].setRotationPoint(0.0f, lllllllllllllllIlIlIIIllIlllIIll, 0.0f);
        this.boatSides[1].addBox((float)(-lllllllllllllllIlIlIIIllIlllIllI / 2 + 2), (float)(-lllllllllllllllIlIlIIIllIlllIlIl - 1), -1.0f, lllllllllllllllIlIlIIIllIlllIllI - 4, lllllllllllllllIlIlIIIllIlllIlIl, 2, 0.0f);
        this.boatSides[1].setRotationPoint((float)(-lllllllllllllllIlIlIIIllIlllIllI / 2 + 1), lllllllllllllllIlIlIIIllIlllIIll, 0.0f);
        this.boatSides[2].addBox((float)(-lllllllllllllllIlIlIIIllIlllIllI / 2 + 2), (float)(-lllllllllllllllIlIlIIIllIlllIlIl - 1), -1.0f, lllllllllllllllIlIlIIIllIlllIllI - 4, lllllllllllllllIlIlIIIllIlllIlIl, 2, 0.0f);
        this.boatSides[2].setRotationPoint((float)(lllllllllllllllIlIlIIIllIlllIllI / 2 - 1), lllllllllllllllIlIlIIIllIlllIIll, 0.0f);
        this.boatSides[3].addBox((float)(-lllllllllllllllIlIlIIIllIlllIllI / 2 + 2), (float)(-lllllllllllllllIlIlIIIllIlllIlIl - 1), -1.0f, lllllllllllllllIlIlIIIllIlllIllI - 4, lllllllllllllllIlIlIIIllIlllIlIl, 2, 0.0f);
        this.boatSides[3].setRotationPoint(0.0f, lllllllllllllllIlIlIIIllIlllIIll, (float)(-lllllllllllllllIlIlIIIllIlllIlII / 2 + 1));
        this.boatSides[4].addBox((float)(-lllllllllllllllIlIlIIIllIlllIllI / 2 + 2), (float)(-lllllllllllllllIlIlIIIllIlllIlIl - 1), -1.0f, lllllllllllllllIlIlIIIllIlllIllI - 4, lllllllllllllllIlIlIIIllIlllIlIl, 2, 0.0f);
        this.boatSides[4].setRotationPoint(0.0f, lllllllllllllllIlIlIIIllIlllIIll, (float)(lllllllllllllllIlIlIIIllIlllIlII / 2 - 1));
        this.boatSides[0].rotateAngleX = 1.5707964f;
        this.boatSides[1].rotateAngleY = 4.712389f;
        this.boatSides[2].rotateAngleY = 1.5707964f;
        this.boatSides[3].rotateAngleY = 3.1415927f;
    }
}
