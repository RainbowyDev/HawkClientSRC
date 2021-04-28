package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelHumanoidHead extends ModelSkeletonHead
{
    private final /* synthetic */ ModelRenderer head;
    
    @Override
    public void render(final Entity lllllllllllllllIIlIIllllIllIIIII, final float lllllllllllllllIIlIIllllIllIIlll, final float lllllllllllllllIIlIIllllIlIllllI, final float lllllllllllllllIIlIIllllIlIlllIl, final float lllllllllllllllIIlIIllllIlIlllII, final float lllllllllllllllIIlIIllllIllIIIll, final float lllllllllllllllIIlIIllllIlIllIlI) {
        super.render(lllllllllllllllIIlIIllllIllIIIII, lllllllllllllllIIlIIllllIllIIlll, lllllllllllllllIIlIIllllIlIllllI, lllllllllllllllIIlIIllllIlIlllIl, lllllllllllllllIIlIIllllIlIlllII, lllllllllllllllIIlIIllllIllIIIll, lllllllllllllllIIlIIllllIlIllIlI);
        this.head.render(lllllllllllllllIIlIIllllIlIllIlI);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIIlIIllllIlIIlIII, final float lllllllllllllllIIlIIllllIlIIIlll, final float lllllllllllllllIIlIIllllIlIIIllI, final float lllllllllllllllIIlIIllllIlIIllIl, final float lllllllllllllllIIlIIllllIlIIIlII, final float lllllllllllllllIIlIIllllIlIIIIll, final Entity lllllllllllllllIIlIIllllIlIIlIlI) {
        super.setRotationAngles(lllllllllllllllIIlIIllllIlIIlIII, lllllllllllllllIIlIIllllIlIIIlll, lllllllllllllllIIlIIllllIlIIIllI, lllllllllllllllIIlIIllllIlIIllIl, lllllllllllllllIIlIIllllIlIIIlII, lllllllllllllllIIlIIllllIlIIIIll, lllllllllllllllIIlIIllllIlIIlIlI);
        this.head.rotateAngleY = this.skeletonHead.rotateAngleY;
        this.head.rotateAngleX = this.skeletonHead.rotateAngleX;
    }
    
    public ModelHumanoidHead() {
        super(0, 0, 64, 64);
        this.head = new ModelRenderer(this, 32, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.25f);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    static {
        __OBFID = "CL_00002627";
    }
}
