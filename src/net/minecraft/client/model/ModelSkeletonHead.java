package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelSkeletonHead extends ModelBase
{
    public /* synthetic */ ModelRenderer skeletonHead;
    
    public ModelSkeletonHead() {
        this(0, 35, 64, 64);
    }
    
    @Override
    public void render(final Entity llllllllllllllIlIIIIIllIIIlIllll, final float llllllllllllllIlIIIIIllIIIllIllI, final float llllllllllllllIlIIIIIllIIIllIlIl, final float llllllllllllllIlIIIIIllIIIlIllII, final float llllllllllllllIlIIIIIllIIIlIlIll, final float llllllllllllllIlIIIIIllIIIlIlIlI, final float llllllllllllllIlIIIIIllIIIllIIIl) {
        this.setRotationAngles(llllllllllllllIlIIIIIllIIIllIllI, llllllllllllllIlIIIIIllIIIllIlIl, llllllllllllllIlIIIIIllIIIlIllII, llllllllllllllIlIIIIIllIIIlIlIll, llllllllllllllIlIIIIIllIIIlIlIlI, llllllllllllllIlIIIIIllIIIllIIIl, llllllllllllllIlIIIIIllIIIlIllll);
        this.skeletonHead.render(llllllllllllllIlIIIIIllIIIllIIIl);
    }
    
    static {
        __OBFID = "CL_00000856";
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlIIIIIllIIIIlllll, final float llllllllllllllIlIIIIIllIIIIlIllI, final float llllllllllllllIlIIIIIllIIIIlllIl, final float llllllllllllllIlIIIIIllIIIIlllII, final float llllllllllllllIlIIIIIllIIIIllIll, final float llllllllllllllIlIIIIIllIIIIlIIlI, final Entity llllllllllllllIlIIIIIllIIIIllIIl) {
        super.setRotationAngles(llllllllllllllIlIIIIIllIIIIlllll, llllllllllllllIlIIIIIllIIIIlIllI, llllllllllllllIlIIIIIllIIIIlllIl, llllllllllllllIlIIIIIllIIIIlllII, llllllllllllllIlIIIIIllIIIIllIll, llllllllllllllIlIIIIIllIIIIlIIlI, llllllllllllllIlIIIIIllIIIIllIIl);
        this.skeletonHead.rotateAngleY = llllllllllllllIlIIIIIllIIIIlllII / 57.295776f;
        this.skeletonHead.rotateAngleX = llllllllllllllIlIIIIIllIIIIllIll / 57.295776f;
    }
    
    public ModelSkeletonHead(final int llllllllllllllIlIIIIIllIIlIIlIIl, final int llllllllllllllIlIIIIIllIIlIIIIll, final int llllllllllllllIlIIIIIllIIlIIIlll, final int llllllllllllllIlIIIIIllIIlIIIllI) {
        this.textureWidth = llllllllllllllIlIIIIIllIIlIIIlll;
        this.textureHeight = llllllllllllllIlIIIIIllIIlIIIllI;
        this.skeletonHead = new ModelRenderer(this, llllllllllllllIlIIIIIllIIlIIlIIl, llllllllllllllIlIIIIIllIIlIIIIll);
        this.skeletonHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.skeletonHead.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
}
