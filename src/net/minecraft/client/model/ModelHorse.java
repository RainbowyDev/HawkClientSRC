package net.minecraft.client.model;

import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class ModelHorse extends ModelBase
{
    private /* synthetic */ ModelRenderer horseSaddleFront;
    private /* synthetic */ ModelRenderer tailBase;
    private /* synthetic */ ModelRenderer frontLeftShin;
    private /* synthetic */ ModelRenderer backLeftShin;
    private /* synthetic */ ModelRenderer backRightLeg;
    private /* synthetic */ ModelRenderer horseLeftSaddleRope;
    private /* synthetic */ ModelRenderer frontRightLeg;
    private /* synthetic */ ModelRenderer tailTip;
    private /* synthetic */ ModelRenderer horseRightSaddleRope;
    private /* synthetic */ ModelRenderer field_178711_b;
    private /* synthetic */ ModelRenderer frontRightShin;
    private /* synthetic */ ModelRenderer horseLeftRein;
    private /* synthetic */ ModelRenderer horseLeftSaddleMetal;
    private /* synthetic */ ModelRenderer backLeftLeg;
    private /* synthetic */ ModelRenderer horseSaddleBottom;
    private /* synthetic */ ModelRenderer horseFaceRopes;
    private /* synthetic */ ModelRenderer head;
    private /* synthetic */ ModelRenderer horseRightRein;
    private /* synthetic */ ModelRenderer mane;
    private /* synthetic */ ModelRenderer muleRightEar;
    private /* synthetic */ ModelRenderer field_178712_c;
    private /* synthetic */ ModelRenderer horseLeftEar;
    private /* synthetic */ ModelRenderer frontRightHoof;
    private /* synthetic */ ModelRenderer backLeftHoof;
    private /* synthetic */ ModelRenderer backRightShin;
    private /* synthetic */ ModelRenderer horseLeftFaceMetal;
    private /* synthetic */ ModelRenderer muleLeftEar;
    private /* synthetic */ ModelRenderer tailMiddle;
    private /* synthetic */ ModelRenderer frontLeftLeg;
    private /* synthetic */ ModelRenderer horseRightEar;
    private /* synthetic */ ModelRenderer horseSaddleBack;
    private /* synthetic */ ModelRenderer neck;
    private /* synthetic */ ModelRenderer backRightHoof;
    private /* synthetic */ ModelRenderer body;
    private /* synthetic */ ModelRenderer horseRightFaceMetal;
    private /* synthetic */ ModelRenderer muleLeftChest;
    private /* synthetic */ ModelRenderer muleRightChest;
    private /* synthetic */ ModelRenderer frontLeftHoof;
    private /* synthetic */ ModelRenderer horseRightSaddleMetal;
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIIlIlllIIllIIllllI, final float llllllllllllllIIlIlllIIllIlllIIl, final float llllllllllllllIIlIlllIIllIlllIII, final float llllllllllllllIIlIlllIIllIllIlll) {
        super.setLivingAnimations(llllllllllllllIIlIlllIIllIIllllI, llllllllllllllIIlIlllIIllIlllIIl, llllllllllllllIIlIlllIIllIlllIII, llllllllllllllIIlIlllIIllIllIlll);
        final float llllllllllllllIIlIlllIIllIllIllI = this.updateHorseRotation(llllllllllllllIIlIlllIIllIIllllI.prevRenderYawOffset, llllllllllllllIIlIlllIIllIIllllI.renderYawOffset, llllllllllllllIIlIlllIIllIllIlll);
        final float llllllllllllllIIlIlllIIllIllIlIl = this.updateHorseRotation(llllllllllllllIIlIlllIIllIIllllI.prevRotationYawHead, llllllllllllllIIlIlllIIllIIllllI.rotationYawHead, llllllllllllllIIlIlllIIllIllIlll);
        final float llllllllllllllIIlIlllIIllIllIlII = llllllllllllllIIlIlllIIllIIllllI.prevRotationPitch + (llllllllllllllIIlIlllIIllIIllllI.rotationPitch - llllllllllllllIIlIlllIIllIIllllI.prevRotationPitch) * llllllllllllllIIlIlllIIllIllIlll;
        float llllllllllllllIIlIlllIIllIllIIll = llllllllllllllIIlIlllIIllIllIlIl - llllllllllllllIIlIlllIIllIllIllI;
        float llllllllllllllIIlIlllIIllIllIIlI = llllllllllllllIIlIlllIIllIllIlII / 57.295776f;
        if (llllllllllllllIIlIlllIIllIllIIll > 20.0f) {
            llllllllllllllIIlIlllIIllIllIIll = 20.0f;
        }
        if (llllllllllllllIIlIlllIIllIllIIll < -20.0f) {
            llllllllllllllIIlIlllIIllIllIIll = -20.0f;
        }
        if (llllllllllllllIIlIlllIIllIlllIII > 0.2f) {
            llllllllllllllIIlIlllIIllIllIIlI += MathHelper.cos(llllllllllllllIIlIlllIIllIlllIIl * 0.4f) * 0.15f * llllllllllllllIIlIlllIIllIlllIII;
        }
        final EntityHorse llllllllllllllIIlIlllIIllIllIIIl = (EntityHorse)llllllllllllllIIlIlllIIllIIllllI;
        final float llllllllllllllIIlIlllIIllIllIIII = llllllllllllllIIlIlllIIllIllIIIl.getGrassEatingAmount(llllllllllllllIIlIlllIIllIllIlll);
        final float llllllllllllllIIlIlllIIllIlIllll = llllllllllllllIIlIlllIIllIllIIIl.getRearingAmount(llllllllllllllIIlIlllIIllIllIlll);
        final float llllllllllllllIIlIlllIIllIlIlllI = 1.0f - llllllllllllllIIlIlllIIllIlIllll;
        final float llllllllllllllIIlIlllIIllIlIllIl = llllllllllllllIIlIlllIIllIllIIIl.func_110201_q(llllllllllllllIIlIlllIIllIllIlll);
        final boolean llllllllllllllIIlIlllIIllIlIllII = llllllllllllllIIlIlllIIllIllIIIl.field_110278_bp != 0;
        final boolean llllllllllllllIIlIlllIIllIlIlIll = llllllllllllllIIlIlllIIllIllIIIl.isHorseSaddled();
        final boolean llllllllllllllIIlIlllIIllIlIlIlI = llllllllllllllIIlIlllIIllIllIIIl.riddenByEntity != null;
        final float llllllllllllllIIlIlllIIllIlIlIIl = llllllllllllllIIlIlllIIllIIllllI.ticksExisted + llllllllllllllIIlIlllIIllIllIlll;
        final float llllllllllllllIIlIlllIIllIlIlIII = MathHelper.cos(llllllllllllllIIlIlllIIllIlllIIl * 0.6662f + 3.1415927f);
        final float llllllllllllllIIlIlllIIllIlIIlll = llllllllllllllIIlIlllIIllIlIlIII * 0.8f * llllllllllllllIIlIlllIIllIlllIII;
        this.head.rotationPointY = 4.0f;
        this.head.rotationPointZ = -10.0f;
        this.tailBase.rotationPointY = 3.0f;
        this.tailMiddle.rotationPointZ = 14.0f;
        this.muleRightChest.rotationPointY = 3.0f;
        this.muleRightChest.rotationPointZ = 10.0f;
        this.body.rotateAngleX = 0.0f;
        this.head.rotateAngleX = 0.5235988f + llllllllllllllIIlIlllIIllIllIIlI;
        this.head.rotateAngleY = llllllllllllllIIlIlllIIllIllIIll / 57.295776f;
        this.head.rotateAngleX = llllllllllllllIIlIlllIIllIlIllll * (0.2617994f + llllllllllllllIIlIlllIIllIllIIlI) + llllllllllllllIIlIlllIIllIllIIII * 2.18166f + (1.0f - Math.max(llllllllllllllIIlIlllIIllIlIllll, llllllllllllllIIlIlllIIllIllIIII)) * this.head.rotateAngleX;
        this.head.rotateAngleY = llllllllllllllIIlIlllIIllIlIllll * llllllllllllllIIlIlllIIllIllIIll / 57.295776f + (1.0f - Math.max(llllllllllllllIIlIlllIIllIlIllll, llllllllllllllIIlIlllIIllIllIIII)) * this.head.rotateAngleY;
        this.head.rotationPointY = llllllllllllllIIlIlllIIllIlIllll * -6.0f + llllllllllllllIIlIlllIIllIllIIII * 11.0f + (1.0f - Math.max(llllllllllllllIIlIlllIIllIlIllll, llllllllllllllIIlIlllIIllIllIIII)) * this.head.rotationPointY;
        this.head.rotationPointZ = llllllllllllllIIlIlllIIllIlIllll * -1.0f + llllllllllllllIIlIlllIIllIllIIII * -10.0f + (1.0f - Math.max(llllllllllllllIIlIlllIIllIlIllll, llllllllllllllIIlIlllIIllIllIIII)) * this.head.rotationPointZ;
        this.tailBase.rotationPointY = llllllllllllllIIlIlllIIllIlIllll * 9.0f + llllllllllllllIIlIlllIIllIlIlllI * this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = llllllllllllllIIlIlllIIllIlIllll * 18.0f + llllllllllllllIIlIlllIIllIlIlllI * this.tailMiddle.rotationPointZ;
        this.muleRightChest.rotationPointY = llllllllllllllIIlIlllIIllIlIllll * 5.5f + llllllllllllllIIlIlllIIllIlIlllI * this.muleRightChest.rotationPointY;
        this.muleRightChest.rotationPointZ = llllllllllllllIIlIlllIIllIlIllll * 15.0f + llllllllllllllIIlIlllIIllIlIlllI * this.muleRightChest.rotationPointZ;
        this.body.rotateAngleX = llllllllllllllIIlIlllIIllIlIllll * -45.0f / 57.295776f + llllllllllllllIIlIlllIIllIlIlllI * this.body.rotateAngleX;
        this.horseLeftEar.rotationPointY = this.head.rotationPointY;
        this.horseRightEar.rotationPointY = this.head.rotationPointY;
        this.muleLeftEar.rotationPointY = this.head.rotationPointY;
        this.muleRightEar.rotationPointY = this.head.rotationPointY;
        this.neck.rotationPointY = this.head.rotationPointY;
        this.field_178711_b.rotationPointY = 0.02f;
        this.field_178712_c.rotationPointY = 0.0f;
        this.mane.rotationPointY = this.head.rotationPointY;
        this.horseLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.horseRightEar.rotationPointZ = this.head.rotationPointZ;
        this.muleLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.muleRightEar.rotationPointZ = this.head.rotationPointZ;
        this.neck.rotationPointZ = this.head.rotationPointZ;
        this.field_178711_b.rotationPointZ = 0.02f - llllllllllllllIIlIlllIIllIlIllIl * 1.0f;
        this.field_178712_c.rotationPointZ = 0.0f + llllllllllllllIIlIlllIIllIlIllIl * 1.0f;
        this.mane.rotationPointZ = this.head.rotationPointZ;
        this.horseLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.horseRightEar.rotateAngleX = this.head.rotateAngleX;
        this.muleLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.muleRightEar.rotateAngleX = this.head.rotateAngleX;
        this.neck.rotateAngleX = this.head.rotateAngleX;
        this.field_178711_b.rotateAngleX = 0.0f - 0.09424778f * llllllllllllllIIlIlllIIllIlIllIl;
        this.field_178712_c.rotateAngleX = 0.0f + 0.15707964f * llllllllllllllIIlIlllIIllIlIllIl;
        this.mane.rotateAngleX = this.head.rotateAngleX;
        this.horseLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.horseRightEar.rotateAngleY = this.head.rotateAngleY;
        this.muleLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.muleRightEar.rotateAngleY = this.head.rotateAngleY;
        this.neck.rotateAngleY = this.head.rotateAngleY;
        this.field_178711_b.rotateAngleY = 0.0f;
        this.field_178712_c.rotateAngleY = 0.0f;
        this.mane.rotateAngleY = this.head.rotateAngleY;
        this.muleLeftChest.rotateAngleX = llllllllllllllIIlIlllIIllIlIIlll / 5.0f;
        this.muleRightChest.rotateAngleX = -llllllllllllllIIlIlllIIllIlIIlll / 5.0f;
        float llllllllllllllIIlIlllIIllIlIIllI = 1.5707964f;
        final float llllllllllllllIIlIlllIIllIlIIlIl = 4.712389f;
        final float llllllllllllllIIlIlllIIllIlIIlII = -1.0471976f;
        final float llllllllllllllIIlIlllIIllIlIIIll = 0.2617994f * llllllllllllllIIlIlllIIllIlIllll;
        final float llllllllllllllIIlIlllIIllIlIIIlI = MathHelper.cos(llllllllllllllIIlIlllIIllIlIlIIl * 0.6f + 3.1415927f);
        this.frontLeftLeg.rotationPointY = -2.0f * llllllllllllllIIlIlllIIllIlIllll + 9.0f * llllllllllllllIIlIlllIIllIlIlllI;
        this.frontLeftLeg.rotationPointZ = -2.0f * llllllllllllllIIlIlllIIllIlIllll + -8.0f * llllllllllllllIIlIlllIIllIlIlllI;
        this.frontRightLeg.rotationPointY = this.frontLeftLeg.rotationPointY;
        this.frontRightLeg.rotationPointZ = this.frontLeftLeg.rotationPointZ;
        this.backLeftShin.rotationPointY = this.backLeftLeg.rotationPointY + MathHelper.sin(1.5707964f + llllllllllllllIIlIlllIIllIlIIIll + llllllllllllllIIlIlllIIllIlIlllI * -llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII) * 7.0f;
        this.backLeftShin.rotationPointZ = this.backLeftLeg.rotationPointZ + MathHelper.cos(4.712389f + llllllllllllllIIlIlllIIllIlIIIll + llllllllllllllIIlIlllIIllIlIlllI * -llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII) * 7.0f;
        this.backRightShin.rotationPointY = this.backRightLeg.rotationPointY + MathHelper.sin(1.5707964f + llllllllllllllIIlIlllIIllIlIIIll + llllllllllllllIIlIlllIIllIlIlllI * llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII) * 7.0f;
        this.backRightShin.rotationPointZ = this.backRightLeg.rotationPointZ + MathHelper.cos(4.712389f + llllllllllllllIIlIlllIIllIlIIIll + llllllllllllllIIlIlllIIllIlIlllI * llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII) * 7.0f;
        final float llllllllllllllIIlIlllIIllIlIIIIl = (-1.0471976f + llllllllllllllIIlIlllIIllIlIIIlI) * llllllllllllllIIlIlllIIllIlIllll + llllllllllllllIIlIlllIIllIlIIlll * llllllllllllllIIlIlllIIllIlIlllI;
        final float llllllllllllllIIlIlllIIllIlIIIII = (-1.0471976f + -llllllllllllllIIlIlllIIllIlIIIlI) * llllllllllllllIIlIlllIIllIlIllll + -llllllllllllllIIlIlllIIllIlIIlll * llllllllllllllIIlIlllIIllIlIlllI;
        this.frontLeftShin.rotationPointY = this.frontLeftLeg.rotationPointY + MathHelper.sin(1.5707964f + llllllllllllllIIlIlllIIllIlIIIIl) * 7.0f;
        this.frontLeftShin.rotationPointZ = this.frontLeftLeg.rotationPointZ + MathHelper.cos(4.712389f + llllllllllllllIIlIlllIIllIlIIIIl) * 7.0f;
        this.frontRightShin.rotationPointY = this.frontRightLeg.rotationPointY + MathHelper.sin(1.5707964f + llllllllllllllIIlIlllIIllIlIIIII) * 7.0f;
        this.frontRightShin.rotationPointZ = this.frontRightLeg.rotationPointZ + MathHelper.cos(4.712389f + llllllllllllllIIlIlllIIllIlIIIII) * 7.0f;
        this.backLeftLeg.rotateAngleX = llllllllllllllIIlIlllIIllIlIIIll + -llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII * llllllllllllllIIlIlllIIllIlIlllI;
        this.backLeftShin.rotateAngleX = -0.08726646f * llllllllllllllIIlIlllIIllIlIllll + (-llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII - Math.max(0.0f, llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII)) * llllllllllllllIIlIlllIIllIlIlllI;
        this.backLeftHoof.rotateAngleX = this.backLeftShin.rotateAngleX;
        this.backRightLeg.rotateAngleX = llllllllllllllIIlIlllIIllIlIIIll + llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII * llllllllllllllIIlIlllIIllIlIlllI;
        this.backRightShin.rotateAngleX = -0.08726646f * llllllllllllllIIlIlllIIllIlIllll + (llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII - Math.max(0.0f, -llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII)) * llllllllllllllIIlIlllIIllIlIlllI;
        this.backRightHoof.rotateAngleX = this.backRightShin.rotateAngleX;
        this.frontLeftLeg.rotateAngleX = llllllllllllllIIlIlllIIllIlIIIIl;
        this.frontLeftShin.rotateAngleX = (this.frontLeftLeg.rotateAngleX + 3.1415927f * Math.max(0.0f, 0.2f + llllllllllllllIIlIlllIIllIlIIIlI * 0.2f)) * llllllllllllllIIlIlllIIllIlIllll + (llllllllllllllIIlIlllIIllIlIIlll + Math.max(0.0f, llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII)) * llllllllllllllIIlIlllIIllIlIlllI;
        this.frontLeftHoof.rotateAngleX = this.frontLeftShin.rotateAngleX;
        this.frontRightLeg.rotateAngleX = llllllllllllllIIlIlllIIllIlIIIII;
        this.frontRightShin.rotateAngleX = (this.frontRightLeg.rotateAngleX + 3.1415927f * Math.max(0.0f, 0.2f - llllllllllllllIIlIlllIIllIlIIIlI * 0.2f)) * llllllllllllllIIlIlllIIllIlIllll + (-llllllllllllllIIlIlllIIllIlIIlll + Math.max(0.0f, -llllllllllllllIIlIlllIIllIlIlIII * 0.5f * llllllllllllllIIlIlllIIllIlllIII)) * llllllllllllllIIlIlllIIllIlIlllI;
        this.frontRightHoof.rotateAngleX = this.frontRightShin.rotateAngleX;
        this.backLeftHoof.rotationPointY = this.backLeftShin.rotationPointY;
        this.backLeftHoof.rotationPointZ = this.backLeftShin.rotationPointZ;
        this.backRightHoof.rotationPointY = this.backRightShin.rotationPointY;
        this.backRightHoof.rotationPointZ = this.backRightShin.rotationPointZ;
        this.frontLeftHoof.rotationPointY = this.frontLeftShin.rotationPointY;
        this.frontLeftHoof.rotationPointZ = this.frontLeftShin.rotationPointZ;
        this.frontRightHoof.rotationPointY = this.frontRightShin.rotationPointY;
        this.frontRightHoof.rotationPointZ = this.frontRightShin.rotationPointZ;
        if (llllllllllllllIIlIlllIIllIlIlIll) {
            this.horseSaddleBottom.rotationPointY = llllllllllllllIIlIlllIIllIlIllll * 0.5f + llllllllllllllIIlIlllIIllIlIlllI * 2.0f;
            this.horseSaddleBottom.rotationPointZ = llllllllllllllIIlIlllIIllIlIllll * 11.0f + llllllllllllllIIlIlllIIllIlIlllI * 2.0f;
            this.horseSaddleFront.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseSaddleBack.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseLeftSaddleRope.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseRightSaddleRope.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseLeftSaddleMetal.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseRightSaddleMetal.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.muleLeftChest.rotationPointY = this.muleRightChest.rotationPointY;
            this.horseSaddleFront.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseSaddleBack.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseLeftSaddleRope.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseRightSaddleRope.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseLeftSaddleMetal.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseRightSaddleMetal.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.muleLeftChest.rotationPointZ = this.muleRightChest.rotationPointZ;
            this.horseSaddleBottom.rotateAngleX = this.body.rotateAngleX;
            this.horseSaddleFront.rotateAngleX = this.body.rotateAngleX;
            this.horseSaddleBack.rotateAngleX = this.body.rotateAngleX;
            this.horseLeftRein.rotationPointY = this.head.rotationPointY;
            this.horseRightRein.rotationPointY = this.head.rotationPointY;
            this.horseFaceRopes.rotationPointY = this.head.rotationPointY;
            this.horseLeftFaceMetal.rotationPointY = this.head.rotationPointY;
            this.horseRightFaceMetal.rotationPointY = this.head.rotationPointY;
            this.horseLeftRein.rotationPointZ = this.head.rotationPointZ;
            this.horseRightRein.rotationPointZ = this.head.rotationPointZ;
            this.horseFaceRopes.rotationPointZ = this.head.rotationPointZ;
            this.horseLeftFaceMetal.rotationPointZ = this.head.rotationPointZ;
            this.horseRightFaceMetal.rotationPointZ = this.head.rotationPointZ;
            this.horseLeftRein.rotateAngleX = llllllllllllllIIlIlllIIllIllIIlI;
            this.horseRightRein.rotateAngleX = llllllllllllllIIlIlllIIllIllIIlI;
            this.horseFaceRopes.rotateAngleX = this.head.rotateAngleX;
            this.horseLeftFaceMetal.rotateAngleX = this.head.rotateAngleX;
            this.horseRightFaceMetal.rotateAngleX = this.head.rotateAngleX;
            this.horseFaceRopes.rotateAngleY = this.head.rotateAngleY;
            this.horseLeftFaceMetal.rotateAngleY = this.head.rotateAngleY;
            this.horseLeftRein.rotateAngleY = this.head.rotateAngleY;
            this.horseRightFaceMetal.rotateAngleY = this.head.rotateAngleY;
            this.horseRightRein.rotateAngleY = this.head.rotateAngleY;
            if (llllllllllllllIIlIlllIIllIlIlIlI) {
                this.horseLeftSaddleRope.rotateAngleX = -1.0471976f;
                this.horseLeftSaddleMetal.rotateAngleX = -1.0471976f;
                this.horseRightSaddleRope.rotateAngleX = -1.0471976f;
                this.horseRightSaddleMetal.rotateAngleX = -1.0471976f;
                this.horseLeftSaddleRope.rotateAngleZ = 0.0f;
                this.horseLeftSaddleMetal.rotateAngleZ = 0.0f;
                this.horseRightSaddleRope.rotateAngleZ = 0.0f;
                this.horseRightSaddleMetal.rotateAngleZ = 0.0f;
            }
            else {
                this.horseLeftSaddleRope.rotateAngleX = llllllllllllllIIlIlllIIllIlIIlll / 3.0f;
                this.horseLeftSaddleMetal.rotateAngleX = llllllllllllllIIlIlllIIllIlIIlll / 3.0f;
                this.horseRightSaddleRope.rotateAngleX = llllllllllllllIIlIlllIIllIlIIlll / 3.0f;
                this.horseRightSaddleMetal.rotateAngleX = llllllllllllllIIlIlllIIllIlIIlll / 3.0f;
                this.horseLeftSaddleRope.rotateAngleZ = llllllllllllllIIlIlllIIllIlIIlll / 5.0f;
                this.horseLeftSaddleMetal.rotateAngleZ = llllllllllllllIIlIlllIIllIlIIlll / 5.0f;
                this.horseRightSaddleRope.rotateAngleZ = -llllllllllllllIIlIlllIIllIlIIlll / 5.0f;
                this.horseRightSaddleMetal.rotateAngleZ = -llllllllllllllIIlIlllIIllIlIIlll / 5.0f;
            }
        }
        llllllllllllllIIlIlllIIllIlIIllI = -1.3089f + llllllllllllllIIlIlllIIllIlllIII * 1.5f;
        if (llllllllllllllIIlIlllIIllIlIIllI > 0.0f) {
            llllllllllllllIIlIlllIIllIlIIllI = 0.0f;
        }
        if (llllllllllllllIIlIlllIIllIlIllII) {
            this.tailBase.rotateAngleY = MathHelper.cos(llllllllllllllIIlIlllIIllIlIlIIl * 0.7f);
            llllllllllllllIIlIlllIIllIlIIllI = 0.0f;
        }
        else {
            this.tailBase.rotateAngleY = 0.0f;
        }
        this.tailMiddle.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailTip.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailMiddle.rotationPointY = this.tailBase.rotationPointY;
        this.tailTip.rotationPointY = this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailTip.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailBase.rotateAngleX = llllllllllllllIIlIlllIIllIlIIllI;
        this.tailMiddle.rotateAngleX = llllllllllllllIIlIlllIIllIlIIllI;
        this.tailTip.rotateAngleX = -0.2618f + llllllllllllllIIlIlllIIllIlIIllI;
    }
    
    public ModelHorse() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer(this, 0, 34);
        this.body.addBox(-5.0f, -8.0f, -19.0f, 10, 10, 24);
        this.body.setRotationPoint(0.0f, 11.0f, 9.0f);
        this.tailBase = new ModelRenderer(this, 44, 0);
        this.tailBase.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.tailBase.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.setBoxRotation(this.tailBase, -1.134464f, 0.0f, 0.0f);
        this.tailMiddle = new ModelRenderer(this, 38, 7);
        this.tailMiddle.addBox(-1.5f, -2.0f, 3.0f, 3, 4, 7);
        this.tailMiddle.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.setBoxRotation(this.tailMiddle, -1.134464f, 0.0f, 0.0f);
        this.tailTip = new ModelRenderer(this, 24, 3);
        this.tailTip.addBox(-1.5f, -4.5f, 9.0f, 3, 4, 7);
        this.tailTip.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.setBoxRotation(this.tailTip, -1.40215f, 0.0f, 0.0f);
        this.backLeftLeg = new ModelRenderer(this, 78, 29);
        this.backLeftLeg.addBox(-2.5f, -2.0f, -2.5f, 4, 9, 5);
        this.backLeftLeg.setRotationPoint(4.0f, 9.0f, 11.0f);
        this.backLeftShin = new ModelRenderer(this, 78, 43);
        this.backLeftShin.addBox(-2.0f, 0.0f, -1.5f, 3, 5, 3);
        this.backLeftShin.setRotationPoint(4.0f, 16.0f, 11.0f);
        this.backLeftHoof = new ModelRenderer(this, 78, 51);
        this.backLeftHoof.addBox(-2.5f, 5.1f, -2.0f, 4, 3, 4);
        this.backLeftHoof.setRotationPoint(4.0f, 16.0f, 11.0f);
        this.backRightLeg = new ModelRenderer(this, 96, 29);
        this.backRightLeg.addBox(-1.5f, -2.0f, -2.5f, 4, 9, 5);
        this.backRightLeg.setRotationPoint(-4.0f, 9.0f, 11.0f);
        this.backRightShin = new ModelRenderer(this, 96, 43);
        this.backRightShin.addBox(-1.0f, 0.0f, -1.5f, 3, 5, 3);
        this.backRightShin.setRotationPoint(-4.0f, 16.0f, 11.0f);
        this.backRightHoof = new ModelRenderer(this, 96, 51);
        this.backRightHoof.addBox(-1.5f, 5.1f, -2.0f, 4, 3, 4);
        this.backRightHoof.setRotationPoint(-4.0f, 16.0f, 11.0f);
        this.frontLeftLeg = new ModelRenderer(this, 44, 29);
        this.frontLeftLeg.addBox(-1.9f, -1.0f, -2.1f, 3, 8, 4);
        this.frontLeftLeg.setRotationPoint(4.0f, 9.0f, -8.0f);
        this.frontLeftShin = new ModelRenderer(this, 44, 41);
        this.frontLeftShin.addBox(-1.9f, 0.0f, -1.6f, 3, 5, 3);
        this.frontLeftShin.setRotationPoint(4.0f, 16.0f, -8.0f);
        this.frontLeftHoof = new ModelRenderer(this, 44, 51);
        this.frontLeftHoof.addBox(-2.4f, 5.1f, -2.1f, 4, 3, 4);
        this.frontLeftHoof.setRotationPoint(4.0f, 16.0f, -8.0f);
        this.frontRightLeg = new ModelRenderer(this, 60, 29);
        this.frontRightLeg.addBox(-1.1f, -1.0f, -2.1f, 3, 8, 4);
        this.frontRightLeg.setRotationPoint(-4.0f, 9.0f, -8.0f);
        this.frontRightShin = new ModelRenderer(this, 60, 41);
        this.frontRightShin.addBox(-1.1f, 0.0f, -1.6f, 3, 5, 3);
        this.frontRightShin.setRotationPoint(-4.0f, 16.0f, -8.0f);
        this.frontRightHoof = new ModelRenderer(this, 60, 51);
        this.frontRightHoof.addBox(-1.6f, 5.1f, -2.1f, 4, 3, 4);
        this.frontRightHoof.setRotationPoint(-4.0f, 16.0f, -8.0f);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.5f, -10.0f, -1.5f, 5, 5, 7);
        this.head.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.head, 0.5235988f, 0.0f, 0.0f);
        this.field_178711_b = new ModelRenderer(this, 24, 18);
        this.field_178711_b.addBox(-2.0f, -10.0f, -7.0f, 4, 3, 6);
        this.field_178711_b.setRotationPoint(0.0f, 3.95f, -10.0f);
        this.setBoxRotation(this.field_178711_b, 0.5235988f, 0.0f, 0.0f);
        this.field_178712_c = new ModelRenderer(this, 24, 27);
        this.field_178712_c.addBox(-2.0f, -7.0f, -6.5f, 4, 2, 5);
        this.field_178712_c.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.field_178712_c, 0.5235988f, 0.0f, 0.0f);
        this.head.addChild(this.field_178711_b);
        this.head.addChild(this.field_178712_c);
        this.horseLeftEar = new ModelRenderer(this, 0, 0);
        this.horseLeftEar.addBox(0.45f, -12.0f, 4.0f, 2, 3, 1);
        this.horseLeftEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.horseLeftEar, 0.5235988f, 0.0f, 0.0f);
        this.horseRightEar = new ModelRenderer(this, 0, 0);
        this.horseRightEar.addBox(-2.45f, -12.0f, 4.0f, 2, 3, 1);
        this.horseRightEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.horseRightEar, 0.5235988f, 0.0f, 0.0f);
        this.muleLeftEar = new ModelRenderer(this, 0, 12);
        this.muleLeftEar.addBox(-2.0f, -16.0f, 4.0f, 2, 7, 1);
        this.muleLeftEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.muleLeftEar, 0.5235988f, 0.0f, 0.2617994f);
        this.muleRightEar = new ModelRenderer(this, 0, 12);
        this.muleRightEar.addBox(0.0f, -16.0f, 4.0f, 2, 7, 1);
        this.muleRightEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.muleRightEar, 0.5235988f, 0.0f, -0.2617994f);
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-2.05f, -9.8f, -2.0f, 4, 14, 8);
        this.neck.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.neck, 0.5235988f, 0.0f, 0.0f);
        this.muleLeftChest = new ModelRenderer(this, 0, 34);
        this.muleLeftChest.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.muleLeftChest.setRotationPoint(-7.5f, 3.0f, 10.0f);
        this.setBoxRotation(this.muleLeftChest, 0.0f, 1.5707964f, 0.0f);
        this.muleRightChest = new ModelRenderer(this, 0, 47);
        this.muleRightChest.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.muleRightChest.setRotationPoint(4.5f, 3.0f, 10.0f);
        this.setBoxRotation(this.muleRightChest, 0.0f, 1.5707964f, 0.0f);
        this.horseSaddleBottom = new ModelRenderer(this, 80, 0);
        this.horseSaddleBottom.addBox(-5.0f, 0.0f, -3.0f, 10, 1, 8);
        this.horseSaddleBottom.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseSaddleFront = new ModelRenderer(this, 106, 9);
        this.horseSaddleFront.addBox(-1.5f, -1.0f, -3.0f, 3, 1, 2);
        this.horseSaddleFront.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseSaddleBack = new ModelRenderer(this, 80, 9);
        this.horseSaddleBack.addBox(-4.0f, -1.0f, 3.0f, 8, 1, 2);
        this.horseSaddleBack.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseLeftSaddleMetal = new ModelRenderer(this, 74, 0);
        this.horseLeftSaddleMetal.addBox(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.horseLeftSaddleMetal.setRotationPoint(5.0f, 3.0f, 2.0f);
        this.horseLeftSaddleRope = new ModelRenderer(this, 70, 0);
        this.horseLeftSaddleRope.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.horseLeftSaddleRope.setRotationPoint(5.0f, 3.0f, 2.0f);
        this.horseRightSaddleMetal = new ModelRenderer(this, 74, 4);
        this.horseRightSaddleMetal.addBox(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.horseRightSaddleMetal.setRotationPoint(-5.0f, 3.0f, 2.0f);
        this.horseRightSaddleRope = new ModelRenderer(this, 80, 0);
        this.horseRightSaddleRope.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.horseRightSaddleRope.setRotationPoint(-5.0f, 3.0f, 2.0f);
        this.horseLeftFaceMetal = new ModelRenderer(this, 74, 13);
        this.horseLeftFaceMetal.addBox(1.5f, -8.0f, -4.0f, 1, 2, 2);
        this.horseLeftFaceMetal.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.horseLeftFaceMetal, 0.5235988f, 0.0f, 0.0f);
        this.horseRightFaceMetal = new ModelRenderer(this, 74, 13);
        this.horseRightFaceMetal.addBox(-2.5f, -8.0f, -4.0f, 1, 2, 2);
        this.horseRightFaceMetal.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.horseRightFaceMetal, 0.5235988f, 0.0f, 0.0f);
        this.horseLeftRein = new ModelRenderer(this, 44, 10);
        this.horseLeftRein.addBox(2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.horseLeftRein.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseRightRein = new ModelRenderer(this, 44, 5);
        this.horseRightRein.addBox(-2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.horseRightRein.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.mane = new ModelRenderer(this, 58, 0);
        this.mane.addBox(-1.0f, -11.5f, 5.0f, 2, 16, 4);
        this.mane.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.mane, 0.5235988f, 0.0f, 0.0f);
        this.horseFaceRopes = new ModelRenderer(this, 80, 12);
        this.horseFaceRopes.addBox(-2.5f, -10.1f, -7.0f, 5, 5, 12, 0.2f);
        this.horseFaceRopes.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.setBoxRotation(this.horseFaceRopes, 0.5235988f, 0.0f, 0.0f);
    }
    
    static {
        __OBFID = "CL_00000846";
    }
    
    private float updateHorseRotation(final float llllllllllllllIIlIlllIIlllIlllll, final float llllllllllllllIIlIlllIIlllIllIlI, final float llllllllllllllIIlIlllIIlllIllIIl) {
        float llllllllllllllIIlIlllIIlllIlllII;
        for (llllllllllllllIIlIlllIIlllIlllII = llllllllllllllIIlIlllIIlllIllIlI - llllllllllllllIIlIlllIIlllIlllll; llllllllllllllIIlIlllIIlllIlllII < -180.0f; llllllllllllllIIlIlllIIlllIlllII += 360.0f) {}
        while (llllllllllllllIIlIlllIIlllIlllII >= 180.0f) {
            llllllllllllllIIlIlllIIlllIlllII -= 360.0f;
        }
        return llllllllllllllIIlIlllIIlllIlllll + llllllllllllllIIlIlllIIlllIllIIl * llllllllllllllIIlIlllIIlllIlllII;
    }
    
    @Override
    public void render(final Entity llllllllllllllIIlIlllIlIIIIIllll, final float llllllllllllllIIlIlllIlIIIIIlllI, final float llllllllllllllIIlIlllIlIIIIIllIl, final float llllllllllllllIIlIlllIlIIIIIllII, final float llllllllllllllIIlIlllIlIIIIIlIll, final float llllllllllllllIIlIlllIlIIIIIlIlI, final float llllllllllllllIIlIlllIlIIIIIlIIl) {
        final EntityHorse llllllllllllllIIlIlllIlIIIIIlIII = (EntityHorse)llllllllllllllIIlIlllIlIIIIIllll;
        final int llllllllllllllIIlIlllIlIIIIIIlll = llllllllllllllIIlIlllIlIIIIIlIII.getHorseType();
        final float llllllllllllllIIlIlllIlIIIIIIllI = llllllllllllllIIlIlllIlIIIIIlIII.getGrassEatingAmount(0.0f);
        final boolean llllllllllllllIIlIlllIlIIIIIIlIl = llllllllllllllIIlIlllIlIIIIIlIII.isAdultHorse();
        final boolean llllllllllllllIIlIlllIlIIIIIIlII = llllllllllllllIIlIlllIlIIIIIIlIl && llllllllllllllIIlIlllIlIIIIIlIII.isHorseSaddled();
        final boolean llllllllllllllIIlIlllIlIIIIIIIll = llllllllllllllIIlIlllIlIIIIIIlIl && llllllllllllllIIlIlllIlIIIIIlIII.isChested();
        final boolean llllllllllllllIIlIlllIlIIIIIIIlI = llllllllllllllIIlIlllIlIIIIIIlll == 1 || llllllllllllllIIlIlllIlIIIIIIlll == 2;
        final float llllllllllllllIIlIlllIlIIIIIIIIl = llllllllllllllIIlIlllIlIIIIIlIII.getHorseSize();
        final boolean llllllllllllllIIlIlllIlIIIIIIIII = llllllllllllllIIlIlllIlIIIIIlIII.riddenByEntity != null;
        if (llllllllllllllIIlIlllIlIIIIIIlII) {
            this.horseFaceRopes.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseSaddleBottom.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseSaddleFront.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseSaddleBack.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseLeftSaddleRope.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseLeftSaddleMetal.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseRightSaddleRope.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseRightSaddleMetal.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseLeftFaceMetal.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseRightFaceMetal.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            if (llllllllllllllIIlIlllIlIIIIIIIII) {
                this.horseLeftRein.render(llllllllllllllIIlIlllIlIIIIIlIIl);
                this.horseRightRein.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            }
        }
        if (!llllllllllllllIIlIlllIlIIIIIIlIl) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(llllllllllllllIIlIlllIlIIIIIIIIl, 0.5f + llllllllllllllIIlIlllIlIIIIIIIIl * 0.5f, llllllllllllllIIlIlllIlIIIIIIIIl);
            GlStateManager.translate(0.0f, 0.95f * (1.0f - llllllllllllllIIlIlllIlIIIIIIIIl), 0.0f);
        }
        this.backLeftLeg.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.backLeftShin.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.backLeftHoof.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.backRightLeg.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.backRightShin.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.backRightHoof.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.frontLeftLeg.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.frontLeftShin.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.frontLeftHoof.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.frontRightLeg.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.frontRightShin.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.frontRightHoof.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        if (!llllllllllllllIIlIlllIlIIIIIIlIl) {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(llllllllllllllIIlIlllIlIIIIIIIIl, llllllllllllllIIlIlllIlIIIIIIIIl, llllllllllllllIIlIlllIlIIIIIIIIl);
            GlStateManager.translate(0.0f, 1.35f * (1.0f - llllllllllllllIIlIlllIlIIIIIIIIl), 0.0f);
        }
        this.body.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.tailBase.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.tailMiddle.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.tailTip.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.neck.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        this.mane.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        if (!llllllllllllllIIlIlllIlIIIIIIlIl) {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            final float llllllllllllllIIlIlllIIlllllllll = 0.5f + llllllllllllllIIlIlllIlIIIIIIIIl * llllllllllllllIIlIlllIlIIIIIIIIl * 0.5f;
            GlStateManager.scale(llllllllllllllIIlIlllIIlllllllll, llllllllllllllIIlIlllIIlllllllll, llllllllllllllIIlIlllIIlllllllll);
            if (llllllllllllllIIlIlllIlIIIIIIllI <= 0.0f) {
                GlStateManager.translate(0.0f, 1.35f * (1.0f - llllllllllllllIIlIlllIlIIIIIIIIl), 0.0f);
            }
            else {
                GlStateManager.translate(0.0f, 0.9f * (1.0f - llllllllllllllIIlIlllIlIIIIIIIIl) * llllllllllllllIIlIlllIlIIIIIIllI + 1.35f * (1.0f - llllllllllllllIIlIlllIlIIIIIIIIl) * (1.0f - llllllllllllllIIlIlllIlIIIIIIllI), 0.15f * (1.0f - llllllllllllllIIlIlllIlIIIIIIIIl) * llllllllllllllIIlIlllIlIIIIIIllI);
            }
        }
        if (llllllllllllllIIlIlllIlIIIIIIIlI) {
            this.muleLeftEar.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.muleRightEar.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        }
        else {
            this.horseLeftEar.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.horseRightEar.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        }
        this.head.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        if (!llllllllllllllIIlIlllIlIIIIIIlIl) {
            GlStateManager.popMatrix();
        }
        if (llllllllllllllIIlIlllIlIIIIIIIll) {
            this.muleLeftChest.render(llllllllllllllIIlIlllIlIIIIIlIIl);
            this.muleRightChest.render(llllllllllllllIIlIlllIlIIIIIlIIl);
        }
    }
    
    private void setBoxRotation(final ModelRenderer llllllllllllllIIlIlllIIllllIllII, final float llllllllllllllIIlIlllIIllllIIlll, final float llllllllllllllIIlIlllIIllllIIllI, final float llllllllllllllIIlIlllIIllllIIlIl) {
        llllllllllllllIIlIlllIIllllIllII.rotateAngleX = llllllllllllllIIlIlllIIllllIIlll;
        llllllllllllllIIlIlllIIllllIllII.rotateAngleY = llllllllllllllIIlIlllIIllllIIllI;
        llllllllllllllIIlIlllIIllllIllII.rotateAngleZ = llllllllllllllIIlIlllIIllllIIlIl;
    }
}
