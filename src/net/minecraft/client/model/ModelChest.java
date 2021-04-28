package net.minecraft.client.model;

public class ModelChest extends ModelBase
{
    public /* synthetic */ ModelRenderer chestKnob;
    public /* synthetic */ ModelRenderer chestLid;
    public /* synthetic */ ModelRenderer chestBelow;
    
    public ModelChest() {
        this.chestLid = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        this.chestLid.addBox(0.0f, -5.0f, -14.0f, 14, 5, 14, 0.0f);
        this.chestLid.rotationPointX = 1.0f;
        this.chestLid.rotationPointY = 7.0f;
        this.chestLid.rotationPointZ = 15.0f;
        this.chestKnob = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        this.chestKnob.addBox(-1.0f, -2.0f, -15.0f, 2, 4, 1, 0.0f);
        this.chestKnob.rotationPointX = 8.0f;
        this.chestKnob.rotationPointY = 7.0f;
        this.chestKnob.rotationPointZ = 15.0f;
        this.chestBelow = new ModelRenderer(this, 0, 19).setTextureSize(64, 64);
        this.chestBelow.addBox(0.0f, 0.0f, 0.0f, 14, 10, 14, 0.0f);
        this.chestBelow.rotationPointX = 1.0f;
        this.chestBelow.rotationPointY = 6.0f;
        this.chestBelow.rotationPointZ = 1.0f;
    }
    
    static {
        __OBFID = "CL_00000834";
    }
    
    public void renderAll() {
        this.chestKnob.rotateAngleX = this.chestLid.rotateAngleX;
        this.chestLid.render(0.0625f);
        this.chestKnob.render(0.0625f);
        this.chestBelow.render(0.0625f);
    }
}
