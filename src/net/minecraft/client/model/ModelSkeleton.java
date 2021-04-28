package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;

public class ModelSkeleton extends ModelZombie
{
    static {
        __OBFID = "CL_00000857";
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIllIIlIIIIIIIIlllI, final float llllllllllllllIllIIlIIIIIIIIIlIl, final float llllllllllllllIllIIlIIIIIIIIllII, final float llllllllllllllIllIIlIIIIIIIIlIll, final float llllllllllllllIllIIlIIIIIIIIlIlI, final float llllllllllllllIllIIlIIIIIIIIIIIl, final Entity llllllllllllllIllIIlIIIIIIIIIIII) {
        super.setRotationAngles(llllllllllllllIllIIlIIIIIIIIlllI, llllllllllllllIllIIlIIIIIIIIIlIl, llllllllllllllIllIIlIIIIIIIIllII, llllllllllllllIllIIlIIIIIIIIlIll, llllllllllllllIllIIlIIIIIIIIlIlI, llllllllllllllIllIIlIIIIIIIIIIIl, llllllllllllllIllIIlIIIIIIIIIIII);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIllIIlIIIIIIlIIIII, final float llllllllllllllIllIIlIIIIIIIlllll, final float llllllllllllllIllIIlIIIIIIIllIIl, final float llllllllllllllIllIIlIIIIIIIllIII) {
        this.aimedBow = (((EntitySkeleton)llllllllllllllIllIIlIIIIIIlIIIII).getSkeletonType() == 1);
        super.setLivingAnimations(llllllllllllllIllIIlIIIIIIlIIIII, llllllllllllllIllIIlIIIIIIIlllll, llllllllllllllIllIIlIIIIIIIllIIl, llllllllllllllIllIIlIIIIIIIllIII);
    }
    
    public ModelSkeleton() {
        this(0.0f, false);
    }
    
    public ModelSkeleton(final float llllllllllllllIllIIlIIIIIIlIlIll, final boolean llllllllllllllIllIIlIIIIIIlIIlll) {
        super(llllllllllllllIllIIlIIIIIIlIlIll, 0.0f, 64, 32);
        if (!llllllllllllllIllIIlIIIIIIlIIlll) {
            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-1.0f, -2.0f, -1.0f, 2, 12, 2, llllllllllllllIllIIlIIIIIIlIlIll);
            this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
            this.bipedLeftArm = new ModelRenderer(this, 40, 16);
            this.bipedLeftArm.mirror = true;
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -1.0f, 2, 12, 2, llllllllllllllIllIIlIIIIIIlIlIll);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.bipedRightLeg = new ModelRenderer(this, 0, 16);
            this.bipedRightLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, llllllllllllllIllIIlIIIIIIlIlIll);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f, 0.0f);
            this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, llllllllllllllIllIIlIIIIIIlIlIll);
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f, 0.0f);
        }
    }
}
