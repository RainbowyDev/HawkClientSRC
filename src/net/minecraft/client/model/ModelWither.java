package net.minecraft.client.model;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;

public class ModelWither extends ModelBase
{
    private /* synthetic */ ModelRenderer[] field_82904_b;
    private /* synthetic */ ModelRenderer[] field_82905_a;
    
    static {
        __OBFID = "CL_00000867";
    }
    
    public ModelWither(final float llllllllllllllIIIllllIlIlllIIIII) {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.field_82905_a = new ModelRenderer[3];
        (this.field_82905_a[0] = new ModelRenderer(this, 0, 16)).addBox(-10.0f, 3.9f, -0.5f, 20, 3, 3, llllllllllllllIIIllllIlIlllIIIII);
        (this.field_82905_a[1] = new ModelRenderer(this).setTextureSize(this.textureWidth, this.textureHeight)).setRotationPoint(-2.0f, 6.9f, -0.5f);
        this.field_82905_a[1].setTextureOffset(0, 22).addBox(0.0f, 0.0f, 0.0f, 3, 10, 3, llllllllllllllIIIllllIlIlllIIIII);
        this.field_82905_a[1].setTextureOffset(24, 22).addBox(-4.0f, 1.5f, 0.5f, 11, 2, 2, llllllllllllllIIIllllIlIlllIIIII);
        this.field_82905_a[1].setTextureOffset(24, 22).addBox(-4.0f, 4.0f, 0.5f, 11, 2, 2, llllllllllllllIIIllllIlIlllIIIII);
        this.field_82905_a[1].setTextureOffset(24, 22).addBox(-4.0f, 6.5f, 0.5f, 11, 2, 2, llllllllllllllIIIllllIlIlllIIIII);
        (this.field_82905_a[2] = new ModelRenderer(this, 12, 22)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 3, llllllllllllllIIIllllIlIlllIIIII);
        this.field_82904_b = new ModelRenderer[3];
        (this.field_82904_b[0] = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8, llllllllllllllIIIllllIlIlllIIIII);
        (this.field_82904_b[1] = new ModelRenderer(this, 32, 0)).addBox(-4.0f, -4.0f, -4.0f, 6, 6, 6, llllllllllllllIIIllllIlIlllIIIII);
        this.field_82904_b[1].rotationPointX = -8.0f;
        this.field_82904_b[1].rotationPointY = 4.0f;
        (this.field_82904_b[2] = new ModelRenderer(this, 32, 0)).addBox(-4.0f, -4.0f, -4.0f, 6, 6, 6, llllllllllllllIIIllllIlIlllIIIII);
        this.field_82904_b[2].rotationPointX = 10.0f;
        this.field_82904_b[2].rotationPointY = 4.0f;
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIllllIlIlIllIlII, final float llllllllllllllIIIllllIlIlIllIIll, final float llllllllllllllIIIllllIlIlIllIIlI, final float llllllllllllllIIIllllIlIlIlIlIlI, final float llllllllllllllIIIllllIlIlIlIlIIl, final float llllllllllllllIIIllllIlIlIlIllll, final Entity llllllllllllllIIIllllIlIlIlIlllI) {
        final float llllllllllllllIIIllllIlIlIlIllIl = MathHelper.cos(llllllllllllllIIIllllIlIlIllIIlI * 0.1f);
        this.field_82905_a[1].rotateAngleX = (0.065f + 0.05f * llllllllllllllIIIllllIlIlIlIllIl) * 3.1415927f;
        this.field_82905_a[2].setRotationPoint(-2.0f, 6.9f + MathHelper.cos(this.field_82905_a[1].rotateAngleX) * 10.0f, -0.5f + MathHelper.sin(this.field_82905_a[1].rotateAngleX) * 10.0f);
        this.field_82905_a[2].rotateAngleX = (0.265f + 0.1f * llllllllllllllIIIllllIlIlIlIllIl) * 3.1415927f;
        this.field_82904_b[0].rotateAngleY = llllllllllllllIIIllllIlIlIlIlIlI / 57.295776f;
        this.field_82904_b[0].rotateAngleX = llllllllllllllIIIllllIlIlIlIlIIl / 57.295776f;
    }
    
    @Override
    public void render(final Entity llllllllllllllIIIllllIlIllIlIIlI, final float llllllllllllllIIIllllIlIllIIIlII, final float llllllllllllllIIIllllIlIllIIIIll, final float llllllllllllllIIIllllIlIllIIIIlI, final float llllllllllllllIIIllllIlIllIIlllI, final float llllllllllllllIIIllllIlIllIIllIl, final float llllllllllllllIIIllllIlIlIllllll) {
        this.setRotationAngles(llllllllllllllIIIllllIlIllIIIlII, llllllllllllllIIIllllIlIllIIIIll, llllllllllllllIIIllllIlIllIIIIlI, llllllllllllllIIIllllIlIllIIlllI, llllllllllllllIIIllllIlIllIIllIl, llllllllllllllIIIllllIlIlIllllll, llllllllllllllIIIllllIlIllIlIIlI);
        for (final ModelRenderer llllllllllllllIIIllllIlIllIIlIII : this.field_82904_b) {
            llllllllllllllIIIllllIlIllIIlIII.render(llllllllllllllIIIllllIlIlIllllll);
        }
        for (final ModelRenderer llllllllllllllIIIllllIlIllIIIlll : this.field_82905_a) {
            llllllllllllllIIIllllIlIllIIIlll.render(llllllllllllllIIIllllIlIlIllllll);
        }
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIIIllllIlIlIIllIll, final float llllllllllllllIIIllllIlIlIlIIIIl, final float llllllllllllllIIIllllIlIlIlIIIII, final float llllllllllllllIIIllllIlIlIIlllll) {
        final EntityWither llllllllllllllIIIllllIlIlIIllllI = (EntityWither)llllllllllllllIIIllllIlIlIIllIll;
        for (int llllllllllllllIIIllllIlIlIIlllIl = 1; llllllllllllllIIIllllIlIlIIlllIl < 3; ++llllllllllllllIIIllllIlIlIIlllIl) {
            this.field_82904_b[llllllllllllllIIIllllIlIlIIlllIl].rotateAngleY = (llllllllllllllIIIllllIlIlIIllllI.func_82207_a(llllllllllllllIIIllllIlIlIIlllIl - 1) - llllllllllllllIIIllllIlIlIIllIll.renderYawOffset) / 57.295776f;
            this.field_82904_b[llllllllllllllIIIllllIlIlIIlllIl].rotateAngleX = llllllllllllllIIIllllIlIlIIllllI.func_82210_r(llllllllllllllIIIllllIlIlIIlllIl - 1) / 57.295776f;
        }
    }
}
