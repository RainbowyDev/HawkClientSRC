package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelWitch extends ModelVillager
{
    public /* synthetic */ boolean field_82900_g;
    private /* synthetic */ ModelRenderer field_82901_h;
    private /* synthetic */ ModelRenderer witchHat;
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIIIIIIlIlIIlllIl, final float llllllllllllllIIIIIIIIlIlIIlllII, final float llllllllllllllIIIIIIIIlIlIIllIll, final float llllllllllllllIIIIIIIIlIlIIlIIIl, final float llllllllllllllIIIIIIIIlIlIIlIIII, final float llllllllllllllIIIIIIIIlIlIIllIII, final Entity llllllllllllllIIIIIIIIlIlIIlIlll) {
        super.setRotationAngles(llllllllllllllIIIIIIIIlIlIIlllIl, llllllllllllllIIIIIIIIlIlIIlllII, llllllllllllllIIIIIIIIlIlIIllIll, llllllllllllllIIIIIIIIlIlIIlIIIl, llllllllllllllIIIIIIIIlIlIIlIIII, llllllllllllllIIIIIIIIlIlIIllIII, llllllllllllllIIIIIIIIlIlIIlIlll);
        final ModelRenderer villagerNose = this.villagerNose;
        final ModelRenderer villagerNose2 = this.villagerNose;
        final ModelRenderer villagerNose3 = this.villagerNose;
        final float offsetX = 0.0f;
        villagerNose3.offsetZ = offsetX;
        villagerNose2.offsetY = offsetX;
        villagerNose.offsetX = offsetX;
        final float llllllllllllllIIIIIIIIlIlIIlIllI = 0.01f * (llllllllllllllIIIIIIIIlIlIIlIlll.getEntityId() % 10);
        this.villagerNose.rotateAngleX = MathHelper.sin(llllllllllllllIIIIIIIIlIlIIlIlll.ticksExisted * llllllllllllllIIIIIIIIlIlIIlIllI) * 4.5f * 3.1415927f / 180.0f;
        this.villagerNose.rotateAngleY = 0.0f;
        this.villagerNose.rotateAngleZ = MathHelper.cos(llllllllllllllIIIIIIIIlIlIIlIlll.ticksExisted * llllllllllllllIIIIIIIIlIlIIlIllI) * 2.5f * 3.1415927f / 180.0f;
        if (this.field_82900_g) {
            this.villagerNose.rotateAngleX = -0.9f;
            this.villagerNose.offsetZ = -0.09375f;
            this.villagerNose.offsetY = 0.1875f;
        }
    }
    
    static {
        __OBFID = "CL_00000866";
    }
    
    public ModelWitch(final float llllllllllllllIIIIIIIIlIlIlIlIll) {
        super(llllllllllllllIIIIIIIIlIlIlIlIll, 0.0f, 64, 128);
        this.field_82901_h = new ModelRenderer(this).setTextureSize(64, 128);
        this.field_82901_h.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.field_82901_h.setTextureOffset(0, 0).addBox(0.0f, 3.0f, -6.75f, 1, 1, 1, -0.25f);
        this.villagerNose.addChild(this.field_82901_h);
        this.witchHat = new ModelRenderer(this).setTextureSize(64, 128);
        this.witchHat.setRotationPoint(-5.0f, -10.03125f, -5.0f);
        this.witchHat.setTextureOffset(0, 64).addBox(0.0f, 0.0f, 0.0f, 10, 2, 10);
        this.villagerHead.addChild(this.witchHat);
        final ModelRenderer llllllllllllllIIIIIIIIlIlIlIllll = new ModelRenderer(this).setTextureSize(64, 128);
        llllllllllllllIIIIIIIIlIlIlIllll.setRotationPoint(1.75f, -4.0f, 2.0f);
        llllllllllllllIIIIIIIIlIlIlIllll.setTextureOffset(0, 76).addBox(0.0f, 0.0f, 0.0f, 7, 4, 7);
        llllllllllllllIIIIIIIIlIlIlIllll.rotateAngleX = -0.05235988f;
        llllllllllllllIIIIIIIIlIlIlIllll.rotateAngleZ = 0.02617994f;
        this.witchHat.addChild(llllllllllllllIIIIIIIIlIlIlIllll);
        final ModelRenderer llllllllllllllIIIIIIIIlIlIlIlllI = new ModelRenderer(this).setTextureSize(64, 128);
        llllllllllllllIIIIIIIIlIlIlIlllI.setRotationPoint(1.75f, -4.0f, 2.0f);
        llllllllllllllIIIIIIIIlIlIlIlllI.setTextureOffset(0, 87).addBox(0.0f, 0.0f, 0.0f, 4, 4, 4);
        llllllllllllllIIIIIIIIlIlIlIlllI.rotateAngleX = -0.10471976f;
        llllllllllllllIIIIIIIIlIlIlIlllI.rotateAngleZ = 0.05235988f;
        llllllllllllllIIIIIIIIlIlIlIllll.addChild(llllllllllllllIIIIIIIIlIlIlIlllI);
        final ModelRenderer llllllllllllllIIIIIIIIlIlIlIllIl = new ModelRenderer(this).setTextureSize(64, 128);
        llllllllllllllIIIIIIIIlIlIlIllIl.setRotationPoint(1.75f, -2.0f, 2.0f);
        llllllllllllllIIIIIIIIlIlIlIllIl.setTextureOffset(0, 95).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.25f);
        llllllllllllllIIIIIIIIlIlIlIllIl.rotateAngleX = -0.20943952f;
        llllllllllllllIIIIIIIIlIlIlIllIl.rotateAngleZ = 0.10471976f;
        llllllllllllllIIIIIIIIlIlIlIlllI.addChild(llllllllllllllIIIIIIIIlIlIlIllIl);
    }
}
