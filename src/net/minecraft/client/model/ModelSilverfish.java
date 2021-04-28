package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelSilverfish extends ModelBase
{
    private /* synthetic */ ModelRenderer[] silverfishWings;
    private static final /* synthetic */ int[][] silverfishTexturePositions;
    private static final /* synthetic */ int[][] silverfishBoxLength;
    private /* synthetic */ ModelRenderer[] silverfishBodyParts;
    private /* synthetic */ float[] field_78170_c;
    
    @Override
    public void render(final Entity llllllllllllllIlIllIlIllIllllIIl, final float llllllllllllllIlIllIlIllIllllIII, final float llllllllllllllIlIllIlIllIllIlllI, final float llllllllllllllIlIllIlIllIllIllIl, final float llllllllllllllIlIllIlIllIlllIlIl, final float llllllllllllllIlIllIlIllIllIlIll, final float llllllllllllllIlIllIlIllIlllIIll) {
        this.setRotationAngles(llllllllllllllIlIllIlIllIllllIII, llllllllllllllIlIllIlIllIllIlllI, llllllllllllllIlIllIlIllIllIllIl, llllllllllllllIlIllIlIllIlllIlIl, llllllllllllllIlIllIlIllIllIlIll, llllllllllllllIlIllIlIllIlllIIll, llllllllllllllIlIllIlIllIllllIIl);
        for (int llllllllllllllIlIllIlIllIlllIIlI = 0; llllllllllllllIlIllIlIllIlllIIlI < this.silverfishBodyParts.length; ++llllllllllllllIlIllIlIllIlllIIlI) {
            this.silverfishBodyParts[llllllllllllllIlIllIlIllIlllIIlI].render(llllllllllllllIlIllIlIllIlllIIll);
        }
        for (int llllllllllllllIlIllIlIllIlllIIlI = 0; llllllllllllllIlIllIlIllIlllIIlI < this.silverfishWings.length; ++llllllllllllllIlIllIlIllIlllIIlI) {
            this.silverfishWings[llllllllllllllIlIllIlIllIlllIIlI].render(llllllllllllllIlIllIlIllIlllIIll);
        }
    }
    
    public ModelSilverfish() {
        this.silverfishBodyParts = new ModelRenderer[7];
        this.field_78170_c = new float[7];
        float llllllllllllllIlIllIlIlllIIIlIII = -3.5f;
        for (int llllllllllllllIlIllIlIlllIIIIlll = 0; llllllllllllllIlIllIlIlllIIIIlll < this.silverfishBodyParts.length; ++llllllllllllllIlIllIlIlllIIIIlll) {
            (this.silverfishBodyParts[llllllllllllllIlIllIlIlllIIIIlll] = new ModelRenderer(this, ModelSilverfish.silverfishTexturePositions[llllllllllllllIlIllIlIlllIIIIlll][0], ModelSilverfish.silverfishTexturePositions[llllllllllllllIlIllIlIlllIIIIlll][1])).addBox(ModelSilverfish.silverfishBoxLength[llllllllllllllIlIllIlIlllIIIIlll][0] * -0.5f, 0.0f, ModelSilverfish.silverfishBoxLength[llllllllllllllIlIllIlIlllIIIIlll][2] * -0.5f, ModelSilverfish.silverfishBoxLength[llllllllllllllIlIllIlIlllIIIIlll][0], ModelSilverfish.silverfishBoxLength[llllllllllllllIlIllIlIlllIIIIlll][1], ModelSilverfish.silverfishBoxLength[llllllllllllllIlIllIlIlllIIIIlll][2]);
            this.silverfishBodyParts[llllllllllllllIlIllIlIlllIIIIlll].setRotationPoint(0.0f, (float)(24 - ModelSilverfish.silverfishBoxLength[llllllllllllllIlIllIlIlllIIIIlll][1]), llllllllllllllIlIllIlIlllIIIlIII);
            this.field_78170_c[llllllllllllllIlIllIlIlllIIIIlll] = llllllllllllllIlIllIlIlllIIIlIII;
            if (llllllllllllllIlIllIlIlllIIIIlll < this.silverfishBodyParts.length - 1) {
                llllllllllllllIlIllIlIlllIIIlIII += (ModelSilverfish.silverfishBoxLength[llllllllllllllIlIllIlIlllIIIIlll][2] + ModelSilverfish.silverfishBoxLength[llllllllllllllIlIllIlIlllIIIIlll + 1][2]) * 0.5f;
            }
        }
        this.silverfishWings = new ModelRenderer[3];
        (this.silverfishWings[0] = new ModelRenderer(this, 20, 0)).addBox(-5.0f, 0.0f, ModelSilverfish.silverfishBoxLength[2][2] * -0.5f, 10, 8, ModelSilverfish.silverfishBoxLength[2][2]);
        this.silverfishWings[0].setRotationPoint(0.0f, 16.0f, this.field_78170_c[2]);
        (this.silverfishWings[1] = new ModelRenderer(this, 20, 11)).addBox(-3.0f, 0.0f, ModelSilverfish.silverfishBoxLength[4][2] * -0.5f, 6, 4, ModelSilverfish.silverfishBoxLength[4][2]);
        this.silverfishWings[1].setRotationPoint(0.0f, 20.0f, this.field_78170_c[4]);
        (this.silverfishWings[2] = new ModelRenderer(this, 20, 18)).addBox(-3.0f, 0.0f, ModelSilverfish.silverfishBoxLength[4][2] * -0.5f, 6, 5, ModelSilverfish.silverfishBoxLength[1][2]);
        this.silverfishWings[2].setRotationPoint(0.0f, 19.0f, this.field_78170_c[1]);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlIllIlIllIllIIlII, final float llllllllllllllIlIllIlIllIllIIIll, final float llllllllllllllIlIllIlIllIlIllIll, final float llllllllllllllIlIllIlIllIllIIIIl, final float llllllllllllllIlIllIlIllIllIIIII, final float llllllllllllllIlIllIlIllIlIlllll, final Entity llllllllllllllIlIllIlIllIlIllllI) {
        for (int llllllllllllllIlIllIlIllIlIlllIl = 0; llllllllllllllIlIllIlIllIlIlllIl < this.silverfishBodyParts.length; ++llllllllllllllIlIllIlIllIlIlllIl) {
            this.silverfishBodyParts[llllllllllllllIlIllIlIllIlIlllIl].rotateAngleY = MathHelper.cos(llllllllllllllIlIllIlIllIlIllIll * 0.9f + llllllllllllllIlIllIlIllIlIlllIl * 0.15f * 3.1415927f) * 3.1415927f * 0.05f * (1 + Math.abs(llllllllllllllIlIllIlIllIlIlllIl - 2));
            this.silverfishBodyParts[llllllllllllllIlIllIlIllIlIlllIl].rotationPointX = MathHelper.sin(llllllllllllllIlIllIlIllIlIllIll * 0.9f + llllllllllllllIlIllIlIllIlIlllIl * 0.15f * 3.1415927f) * 3.1415927f * 0.2f * Math.abs(llllllllllllllIlIllIlIllIlIlllIl - 2);
        }
        this.silverfishWings[0].rotateAngleY = this.silverfishBodyParts[2].rotateAngleY;
        this.silverfishWings[1].rotateAngleY = this.silverfishBodyParts[4].rotateAngleY;
        this.silverfishWings[1].rotationPointX = this.silverfishBodyParts[4].rotationPointX;
        this.silverfishWings[2].rotateAngleY = this.silverfishBodyParts[1].rotateAngleY;
        this.silverfishWings[2].rotationPointX = this.silverfishBodyParts[1].rotationPointX;
    }
    
    static {
        __OBFID = "CL_00000855";
        silverfishBoxLength = new int[][] { { 3, 2, 2 }, { 4, 3, 2 }, { 6, 4, 3 }, { 3, 3, 3 }, { 2, 2, 3 }, { 2, 1, 2 }, { 1, 1, 2 } };
        silverfishTexturePositions = new int[][] { new int[2], { 0, 4 }, { 0, 9 }, { 0, 16 }, { 0, 22 }, { 11, 0 }, { 13, 4 } };
    }
}
