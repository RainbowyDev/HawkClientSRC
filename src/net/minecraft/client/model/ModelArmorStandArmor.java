package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.item.*;

public class ModelArmorStandArmor extends ModelBiped
{
    static {
        __OBFID = "CL_00002632";
    }
    
    public ModelArmorStandArmor() {
        this(0.0f);
    }
    
    @Override
    public void setRotationAngles(final float lIlIllIllllII, final float lIlIllIlllIll, final float lIlIllIlllIlI, final float lIlIllIlllIIl, final float lIlIllIlllIII, final float lIlIllIllIlll, final Entity lIlIllIllIIll) {
        if (lIlIllIllIIll instanceof EntityArmorStand) {
            final EntityArmorStand lIlIllIllIlIl = (EntityArmorStand)lIlIllIllIIll;
            this.bipedHead.rotateAngleX = 0.017453292f * lIlIllIllIlIl.getHeadRotation().func_179415_b();
            this.bipedHead.rotateAngleY = 0.017453292f * lIlIllIllIlIl.getHeadRotation().func_179416_c();
            this.bipedHead.rotateAngleZ = 0.017453292f * lIlIllIllIlIl.getHeadRotation().func_179413_d();
            this.bipedHead.setRotationPoint(0.0f, 1.0f, 0.0f);
            this.bipedBody.rotateAngleX = 0.017453292f * lIlIllIllIlIl.getBodyRotation().func_179415_b();
            this.bipedBody.rotateAngleY = 0.017453292f * lIlIllIllIlIl.getBodyRotation().func_179416_c();
            this.bipedBody.rotateAngleZ = 0.017453292f * lIlIllIllIlIl.getBodyRotation().func_179413_d();
            this.bipedLeftArm.rotateAngleX = 0.017453292f * lIlIllIllIlIl.getLeftArmRotation().func_179415_b();
            this.bipedLeftArm.rotateAngleY = 0.017453292f * lIlIllIllIlIl.getLeftArmRotation().func_179416_c();
            this.bipedLeftArm.rotateAngleZ = 0.017453292f * lIlIllIllIlIl.getLeftArmRotation().func_179413_d();
            this.bipedRightArm.rotateAngleX = 0.017453292f * lIlIllIllIlIl.getRightArmRotation().func_179415_b();
            this.bipedRightArm.rotateAngleY = 0.017453292f * lIlIllIllIlIl.getRightArmRotation().func_179416_c();
            this.bipedRightArm.rotateAngleZ = 0.017453292f * lIlIllIllIlIl.getRightArmRotation().func_179413_d();
            this.bipedLeftLeg.rotateAngleX = 0.017453292f * lIlIllIllIlIl.getLeftLegRotation().func_179415_b();
            this.bipedLeftLeg.rotateAngleY = 0.017453292f * lIlIllIllIlIl.getLeftLegRotation().func_179416_c();
            this.bipedLeftLeg.rotateAngleZ = 0.017453292f * lIlIllIllIlIl.getLeftLegRotation().func_179413_d();
            this.bipedLeftLeg.setRotationPoint(1.9f, 11.0f, 0.0f);
            this.bipedRightLeg.rotateAngleX = 0.017453292f * lIlIllIllIlIl.getRightLegRotation().func_179415_b();
            this.bipedRightLeg.rotateAngleY = 0.017453292f * lIlIllIllIlIl.getRightLegRotation().func_179416_c();
            this.bipedRightLeg.rotateAngleZ = 0.017453292f * lIlIllIllIlIl.getRightLegRotation().func_179413_d();
            this.bipedRightLeg.setRotationPoint(-1.9f, 11.0f, 0.0f);
            ModelBase.func_178685_a(this.bipedHead, this.bipedHeadwear);
        }
    }
    
    protected ModelArmorStandArmor(final float lIlIlllIIIlll, final int lIlIlllIIIIlI, final int lIlIlllIIIlIl) {
        super(lIlIlllIIIlll, 0.0f, lIlIlllIIIIlI, lIlIlllIIIlIl);
    }
    
    public ModelArmorStandArmor(final float lIlIlllIIllll) {
        this(lIlIlllIIllll, 64, 32);
    }
}
