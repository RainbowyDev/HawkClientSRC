package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelZombie extends ModelBiped
{
    protected ModelZombie(final float llllllllllllllIlIIIlllIIlIIllIlI, final float llllllllllllllIlIIIlllIIlIIllllI, final int llllllllllllllIlIIIlllIIlIIlllIl, final int llllllllllllllIlIIIlllIIlIIlIlll) {
        super(llllllllllllllIlIIIlllIIlIIllIlI, llllllllllllllIlIIIlllIIlIIllllI, llllllllllllllIlIIIlllIIlIIlllIl, llllllllllllllIlIIIlllIIlIIlIlll);
    }
    
    public ModelZombie(final float llllllllllllllIlIIIlllIIlIIlIIlI, final boolean llllllllllllllIlIIIlllIIlIIlIIIl) {
        super(llllllllllllllIlIIIlllIIlIIlIIlI, 0.0f, 64, llllllllllllllIlIIIlllIIlIIlIIIl ? 32 : 64);
    }
    
    public ModelZombie() {
        this(0.0f, false);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlIIIlllIIlIIIIIlI, final float llllllllllllllIlIIIlllIIlIIIIIIl, final float llllllllllllllIlIIIlllIIIlllIllI, final float llllllllllllllIlIIIlllIIIlllllll, final float llllllllllllllIlIIIlllIIIlllIlII, final float llllllllllllllIlIIIlllIIIlllllIl, final Entity llllllllllllllIlIIIlllIIIlllIIlI) {
        super.setRotationAngles(llllllllllllllIlIIIlllIIlIIIIIlI, llllllllllllllIlIIIlllIIlIIIIIIl, llllllllllllllIlIIIlllIIIlllIllI, llllllllllllllIlIIIlllIIIlllllll, llllllllllllllIlIIIlllIIIlllIlII, llllllllllllllIlIIIlllIIIlllllIl, llllllllllllllIlIIIlllIIIlllIIlI);
        final float llllllllllllllIlIIIlllIIIllllIll = MathHelper.sin(this.swingProgress * 3.1415927f);
        final float llllllllllllllIlIIIlllIIIllllIlI = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - llllllllllllllIlIIIlllIIIllllIll * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - llllllllllllllIlIIIlllIIIllllIll * 0.6f;
        this.bipedRightArm.rotateAngleX = -1.5707964f;
        this.bipedLeftArm.rotateAngleX = -1.5707964f;
        final ModelRenderer bipedRightArm = this.bipedRightArm;
        bipedRightArm.rotateAngleX -= llllllllllllllIlIIIlllIIIllllIll * 1.2f - llllllllllllllIlIIIlllIIIllllIlI * 0.4f;
        final ModelRenderer bipedLeftArm = this.bipedLeftArm;
        bipedLeftArm.rotateAngleX -= llllllllllllllIlIIIlllIIIllllIll * 1.2f - llllllllllllllIlIIIlllIIIllllIlI * 0.4f;
        final ModelRenderer bipedRightArm2 = this.bipedRightArm;
        bipedRightArm2.rotateAngleZ += MathHelper.cos(llllllllllllllIlIIIlllIIIlllIllI * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
        bipedLeftArm2.rotateAngleZ -= MathHelper.cos(llllllllllllllIlIIIlllIIIlllIllI * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm3 = this.bipedRightArm;
        bipedRightArm3.rotateAngleX += MathHelper.sin(llllllllllllllIlIIIlllIIIlllIllI * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
        bipedLeftArm3.rotateAngleX -= MathHelper.sin(llllllllllllllIlIIIlllIIIlllIllI * 0.067f) * 0.05f;
    }
    
    static {
        __OBFID = "CL_00000869";
    }
}
