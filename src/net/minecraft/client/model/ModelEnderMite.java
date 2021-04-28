package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelEnderMite extends ModelBase
{
    private static final /* synthetic */ int[][] field_178716_a;
    private static final /* synthetic */ int[][] field_178714_b;
    private final /* synthetic */ ModelRenderer[] field_178713_d;
    private static final /* synthetic */ int field_178715_c;
    
    public ModelEnderMite() {
        this.field_178713_d = new ModelRenderer[ModelEnderMite.field_178715_c];
        float llllllllllllllIIIllIIIIllIIlIlII = -3.5f;
        for (int llllllllllllllIIIllIIIIllIIlIIll = 0; llllllllllllllIIIllIIIIllIIlIIll < this.field_178713_d.length; ++llllllllllllllIIIllIIIIllIIlIIll) {
            (this.field_178713_d[llllllllllllllIIIllIIIIllIIlIIll] = new ModelRenderer(this, ModelEnderMite.field_178714_b[llllllllllllllIIIllIIIIllIIlIIll][0], ModelEnderMite.field_178714_b[llllllllllllllIIIllIIIIllIIlIIll][1])).addBox(ModelEnderMite.field_178716_a[llllllllllllllIIIllIIIIllIIlIIll][0] * -0.5f, 0.0f, ModelEnderMite.field_178716_a[llllllllllllllIIIllIIIIllIIlIIll][2] * -0.5f, ModelEnderMite.field_178716_a[llllllllllllllIIIllIIIIllIIlIIll][0], ModelEnderMite.field_178716_a[llllllllllllllIIIllIIIIllIIlIIll][1], ModelEnderMite.field_178716_a[llllllllllllllIIIllIIIIllIIlIIll][2]);
            this.field_178713_d[llllllllllllllIIIllIIIIllIIlIIll].setRotationPoint(0.0f, (float)(24 - ModelEnderMite.field_178716_a[llllllllllllllIIIllIIIIllIIlIIll][1]), llllllllllllllIIIllIIIIllIIlIlII);
            if (llllllllllllllIIIllIIIIllIIlIIll < this.field_178713_d.length - 1) {
                llllllllllllllIIIllIIIIllIIlIlII += (ModelEnderMite.field_178716_a[llllllllllllllIIIllIIIIllIIlIIll][2] + ModelEnderMite.field_178716_a[llllllllllllllIIIllIIIIllIIlIIll + 1][2]) * 0.5f;
            }
        }
    }
    
    static {
        __OBFID = "CL_00002629";
        field_178716_a = new int[][] { { 4, 3, 2 }, { 6, 4, 5 }, { 3, 3, 1 }, { 1, 2, 1 } };
        field_178714_b = new int[][] { new int[2], { 0, 5 }, { 0, 14 }, { 0, 18 } };
        field_178715_c = ModelEnderMite.field_178716_a.length;
    }
    
    @Override
    public void render(final Entity llllllllllllllIIIllIIIIllIIIIlIl, final float llllllllllllllIIIllIIIIlIllllIll, final float llllllllllllllIIIllIIIIllIIIIIll, final float llllllllllllllIIIllIIIIlIllllIIl, final float llllllllllllllIIIllIIIIlIllllIII, final float llllllllllllllIIIllIIIIllIIIIIII, final float llllllllllllllIIIllIIIIlIlllllll) {
        this.setRotationAngles(llllllllllllllIIIllIIIIlIllllIll, llllllllllllllIIIllIIIIllIIIIIll, llllllllllllllIIIllIIIIlIllllIIl, llllllllllllllIIIllIIIIlIllllIII, llllllllllllllIIIllIIIIllIIIIIII, llllllllllllllIIIllIIIIlIlllllll, llllllllllllllIIIllIIIIllIIIIlIl);
        for (int llllllllllllllIIIllIIIIlIllllllI = 0; llllllllllllllIIIllIIIIlIllllllI < this.field_178713_d.length; ++llllllllllllllIIIllIIIIlIllllllI) {
            this.field_178713_d[llllllllllllllIIIllIIIIlIllllllI].render(llllllllllllllIIIllIIIIlIlllllll);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIllIIIIlIlllIIII, final float llllllllllllllIIIllIIIIlIllIllll, final float llllllllllllllIIIllIIIIlIllIlllI, final float llllllllllllllIIIllIIIIlIllIllIl, final float llllllllllllllIIIllIIIIlIllIllII, final float llllllllllllllIIIllIIIIlIllIlIll, final Entity llllllllllllllIIIllIIIIlIllIlIlI) {
        for (int llllllllllllllIIIllIIIIlIllIlIIl = 0; llllllllllllllIIIllIIIIlIllIlIIl < this.field_178713_d.length; ++llllllllllllllIIIllIIIIlIllIlIIl) {
            this.field_178713_d[llllllllllllllIIIllIIIIlIllIlIIl].rotateAngleY = MathHelper.cos(llllllllllllllIIIllIIIIlIllIlllI * 0.9f + llllllllllllllIIIllIIIIlIllIlIIl * 0.15f * 3.1415927f) * 3.1415927f * 0.01f * (1 + Math.abs(llllllllllllllIIIllIIIIlIllIlIIl - 2));
            this.field_178713_d[llllllllllllllIIIllIIIIlIllIlIIl].rotationPointX = MathHelper.sin(llllllllllllllIIIllIIIIlIllIlllI * 0.9f + llllllllllllllIIIllIIIIlIllIlIIl * 0.15f * 3.1415927f) * 3.1415927f * 0.1f * Math.abs(llllllllllllllIIIllIIIIlIllIlIIl - 2);
        }
    }
}
