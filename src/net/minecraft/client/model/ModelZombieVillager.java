package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelZombieVillager extends ModelBiped
{
    public ModelZombieVillager(final float llllllllllllllIIIlIlIllIIIIIIIIl, final float llllllllllllllIIIlIlIllIIIIIIlII, final boolean llllllllllllllIIIlIlIllIIIIIIIll) {
        super(llllllllllllllIIIlIlIllIIIIIIIIl, 0.0f, 64, llllllllllllllIIIlIlIllIIIIIIIll ? 32 : 64);
        if (llllllllllllllIIIlIlIllIIIIIIIll) {
            this.bipedHead = new ModelRenderer(this, 0, 0);
            this.bipedHead.addBox(-4.0f, -10.0f, -4.0f, 8, 8, 8, llllllllllllllIIIlIlIllIIIIIIIIl);
            this.bipedHead.setRotationPoint(0.0f, 0.0f + llllllllllllllIIIlIlIllIIIIIIlII, 0.0f);
        }
        else {
            this.bipedHead = new ModelRenderer(this);
            this.bipedHead.setRotationPoint(0.0f, 0.0f + llllllllllllllIIIlIlIllIIIIIIlII, 0.0f);
            this.bipedHead.setTextureOffset(0, 32).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, llllllllllllllIIIlIlIllIIIIIIIIl);
            this.bipedHead.setTextureOffset(24, 32).addBox(-1.0f, -3.0f, -6.0f, 2, 4, 2, llllllllllllllIIIlIlIllIIIIIIIIl);
        }
    }
    
    static {
        __OBFID = "CL_00000865";
    }
    
    public ModelZombieVillager() {
        this(0.0f, 0.0f, false);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIlIlIlIlllllIIll, final float llllllllllllllIIIlIlIlIllllIlIII, final float llllllllllllllIIIlIlIlIllllIIlll, final float llllllllllllllIIIlIlIlIlllllIIII, final float llllllllllllllIIIlIlIlIllllIllll, final float llllllllllllllIIIlIlIlIllllIIlII, final Entity llllllllllllllIIIlIlIlIllllIllIl) {
        super.setRotationAngles(llllllllllllllIIIlIlIlIlllllIIll, llllllllllllllIIIlIlIlIllllIlIII, llllllllllllllIIIlIlIlIllllIIlll, llllllllllllllIIIlIlIlIlllllIIII, llllllllllllllIIIlIlIlIllllIllll, llllllllllllllIIIlIlIlIllllIIlII, llllllllllllllIIIlIlIlIllllIllIl);
        final float llllllllllllllIIIlIlIlIllllIllII = MathHelper.sin(this.swingProgress * 3.1415927f);
        final float llllllllllllllIIIlIlIlIllllIlIll = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - llllllllllllllIIIlIlIlIllllIllII * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - llllllllllllllIIIlIlIlIllllIllII * 0.6f;
        this.bipedRightArm.rotateAngleX = -1.5707964f;
        this.bipedLeftArm.rotateAngleX = -1.5707964f;
        final ModelRenderer bipedRightArm = this.bipedRightArm;
        bipedRightArm.rotateAngleX -= llllllllllllllIIIlIlIlIllllIllII * 1.2f - llllllllllllllIIIlIlIlIllllIlIll * 0.4f;
        final ModelRenderer bipedLeftArm = this.bipedLeftArm;
        bipedLeftArm.rotateAngleX -= llllllllllllllIIIlIlIlIllllIllII * 1.2f - llllllllllllllIIIlIlIlIllllIlIll * 0.4f;
        final ModelRenderer bipedRightArm2 = this.bipedRightArm;
        bipedRightArm2.rotateAngleZ += MathHelper.cos(llllllllllllllIIIlIlIlIllllIIlll * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
        bipedLeftArm2.rotateAngleZ -= MathHelper.cos(llllllllllllllIIIlIlIlIllllIIlll * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm3 = this.bipedRightArm;
        bipedRightArm3.rotateAngleX += MathHelper.sin(llllllllllllllIIIlIlIlIllllIIlll * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
        bipedLeftArm3.rotateAngleX -= MathHelper.sin(llllllllllllllIIIlIlIlIllllIIlll * 0.067f) * 0.05f;
    }
}
