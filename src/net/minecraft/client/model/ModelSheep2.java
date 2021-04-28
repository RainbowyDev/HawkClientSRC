package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;

public class ModelSheep2 extends ModelQuadruped
{
    private /* synthetic */ float field_78153_i;
    
    @Override
    public void setRotationAngles(final float llIIIIllllllIl, final float llIIIIllllIlII, final float llIIIIllllIIll, final float llIIIIlllllIlI, final float llIIIIllllIIIl, final float llIIIIlllllIII, final Entity llIIIIlllIllll) {
        super.setRotationAngles(llIIIIllllllIl, llIIIIllllIlII, llIIIIllllIIll, llIIIIlllllIlI, llIIIIllllIIIl, llIIIIlllllIII, llIIIIlllIllll);
        this.head.rotateAngleX = this.field_78153_i;
    }
    
    public ModelSheep2() {
        super(12, 0.0f);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0f, -4.0f, -6.0f, 6, 6, 8, 0.0f);
        this.head.setRotationPoint(0.0f, 6.0f, -8.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-4.0f, -10.0f, -7.0f, 8, 16, 6, 0.0f);
        this.body.setRotationPoint(0.0f, 5.0f, 2.0f);
    }
    
    static {
        __OBFID = "CL_00000853";
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llIIIlIIIIlIlI, final float llIIIlIIIIlIIl, final float llIIIlIIIIllIl, final float llIIIlIIIIIlll) {
        super.setLivingAnimations(llIIIlIIIIlIlI, llIIIlIIIIlIIl, llIIIlIIIIllIl, llIIIlIIIIIlll);
        this.head.rotationPointY = 6.0f + ((EntitySheep)llIIIlIIIIlIlI).getHeadRotationPointY(llIIIlIIIIIlll) * 9.0f;
        this.field_78153_i = ((EntitySheep)llIIIlIIIIlIlI).getHeadRotationAngleX(llIIIlIIIIIlll);
    }
}
