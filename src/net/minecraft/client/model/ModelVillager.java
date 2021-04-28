package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelVillager extends ModelBase
{
    public /* synthetic */ ModelRenderer rightVillagerLeg;
    public /* synthetic */ ModelRenderer villagerArms;
    public /* synthetic */ ModelRenderer villagerBody;
    public /* synthetic */ ModelRenderer villagerHead;
    public /* synthetic */ ModelRenderer leftVillagerLeg;
    public /* synthetic */ ModelRenderer villagerNose;
    
    @Override
    public void render(final Entity llllllllllllllIIlIIIlIllIIIIIIlI, final float llllllllllllllIIlIIIlIllIIIIIIIl, final float llllllllllllllIIlIIIlIllIIIIIIII, final float llllllllllllllIIlIIIlIlIllllIlll, final float llllllllllllllIIlIIIlIlIlllllllI, final float llllllllllllllIIlIIIlIlIllllIlIl, final float llllllllllllllIIlIIIlIlIllllllII) {
        this.setRotationAngles(llllllllllllllIIlIIIlIllIIIIIIIl, llllllllllllllIIlIIIlIllIIIIIIII, llllllllllllllIIlIIIlIlIllllIlll, llllllllllllllIIlIIIlIlIlllllllI, llllllllllllllIIlIIIlIlIllllIlIl, llllllllllllllIIlIIIlIlIllllllII, llllllllllllllIIlIIIlIllIIIIIIlI);
        this.villagerHead.render(llllllllllllllIIlIIIlIlIllllllII);
        this.villagerBody.render(llllllllllllllIIlIIIlIlIllllllII);
        this.rightVillagerLeg.render(llllllllllllllIIlIIIlIlIllllllII);
        this.leftVillagerLeg.render(llllllllllllllIIlIIIlIlIllllllII);
        this.villagerArms.render(llllllllllllllIIlIIIlIlIllllllII);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIlIIIlIlIlllIIlIl, final float llllllllllllllIIlIIIlIlIlllIIlII, final float llllllllllllllIIlIIIlIlIlllIlIll, final float llllllllllllllIIlIIIlIlIlllIIIll, final float llllllllllllllIIlIIIlIlIlllIlIIl, final float llllllllllllllIIlIIIlIlIlllIlIII, final Entity llllllllllllllIIlIIIlIlIlllIIlll) {
        this.villagerHead.rotateAngleY = llllllllllllllIIlIIIlIlIlllIIIll / 57.295776f;
        this.villagerHead.rotateAngleX = llllllllllllllIIlIIIlIlIlllIlIIl / 57.295776f;
        this.villagerArms.rotationPointY = 3.0f;
        this.villagerArms.rotationPointZ = -1.0f;
        this.villagerArms.rotateAngleX = -0.75f;
        this.rightVillagerLeg.rotateAngleX = MathHelper.cos(llllllllllllllIIlIIIlIlIlllIIlIl * 0.6662f) * 1.4f * llllllllllllllIIlIIIlIlIlllIIlII * 0.5f;
        this.leftVillagerLeg.rotateAngleX = MathHelper.cos(llllllllllllllIIlIIIlIlIlllIIlIl * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIIlIIIlIlIlllIIlII * 0.5f;
        this.rightVillagerLeg.rotateAngleY = 0.0f;
        this.leftVillagerLeg.rotateAngleY = 0.0f;
    }
    
    static {
        __OBFID = "CL_00000864";
    }
    
    public ModelVillager(final float llllllllllllllIIlIIIlIllIIIIllll, final float llllllllllllllIIlIIIlIllIIIIlllI, final int llllllllllllllIIlIIIlIllIIIIllIl, final int llllllllllllllIIlIIIlIllIIIIllII) {
        this.villagerHead = new ModelRenderer(this).setTextureSize(llllllllllllllIIlIIIlIllIIIIllIl, llllllllllllllIIlIIIlIllIIIIllII);
        this.villagerHead.setRotationPoint(0.0f, 0.0f + llllllllllllllIIlIIIlIllIIIIlllI, 0.0f);
        this.villagerHead.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, llllllllllllllIIlIIIlIllIIIIllll);
        this.villagerNose = new ModelRenderer(this).setTextureSize(llllllllllllllIIlIIIlIllIIIIllIl, llllllllllllllIIlIIIlIllIIIIllII);
        this.villagerNose.setRotationPoint(0.0f, llllllllllllllIIlIIIlIllIIIIlllI - 2.0f, 0.0f);
        this.villagerNose.setTextureOffset(24, 0).addBox(-1.0f, -1.0f, -6.0f, 2, 4, 2, llllllllllllllIIlIIIlIllIIIIllll);
        this.villagerHead.addChild(this.villagerNose);
        this.villagerBody = new ModelRenderer(this).setTextureSize(llllllllllllllIIlIIIlIllIIIIllIl, llllllllllllllIIlIIIlIllIIIIllII);
        this.villagerBody.setRotationPoint(0.0f, 0.0f + llllllllllllllIIlIIIlIllIIIIlllI, 0.0f);
        this.villagerBody.setTextureOffset(16, 20).addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, llllllllllllllIIlIIIlIllIIIIllll);
        this.villagerBody.setTextureOffset(0, 38).addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, llllllllllllllIIlIIIlIllIIIIllll + 0.5f);
        this.villagerArms = new ModelRenderer(this).setTextureSize(llllllllllllllIIlIIIlIllIIIIllIl, llllllllllllllIIlIIIlIllIIIIllII);
        this.villagerArms.setRotationPoint(0.0f, 0.0f + llllllllllllllIIlIIIlIllIIIIlllI + 2.0f, 0.0f);
        this.villagerArms.setTextureOffset(44, 22).addBox(-8.0f, -2.0f, -2.0f, 4, 8, 4, llllllllllllllIIlIIIlIllIIIIllll);
        this.villagerArms.setTextureOffset(44, 22).addBox(4.0f, -2.0f, -2.0f, 4, 8, 4, llllllllllllllIIlIIIlIllIIIIllll);
        this.villagerArms.setTextureOffset(40, 38).addBox(-4.0f, 2.0f, -2.0f, 8, 4, 4, llllllllllllllIIlIIIlIllIIIIllll);
        this.rightVillagerLeg = new ModelRenderer(this, 0, 22).setTextureSize(llllllllllllllIIlIIIlIllIIIIllIl, llllllllllllllIIlIIIlIllIIIIllII);
        this.rightVillagerLeg.setRotationPoint(-2.0f, 12.0f + llllllllllllllIIlIIIlIllIIIIlllI, 0.0f);
        this.rightVillagerLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIIlIIIlIllIIIIllll);
        this.leftVillagerLeg = new ModelRenderer(this, 0, 22).setTextureSize(llllllllllllllIIlIIIlIllIIIIllIl, llllllllllllllIIlIIIlIllIIIIllII);
        this.leftVillagerLeg.mirror = true;
        this.leftVillagerLeg.setRotationPoint(2.0f, 12.0f + llllllllllllllIIlIIIlIllIIIIlllI, 0.0f);
        this.leftVillagerLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIIlIIIlIllIIIIllll);
    }
    
    public ModelVillager(final float llllllllllllllIIlIIIlIllIIIllIll) {
        this(llllllllllllllIIlIIIlIllIIIllIll, 0.0f, 64, 64);
    }
}
