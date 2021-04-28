package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

public class ModelGuardian extends ModelBase
{
    private /* synthetic */ ModelRenderer[] guardianSpines;
    private /* synthetic */ ModelRenderer[] guardianTail;
    private /* synthetic */ ModelRenderer guardianBody;
    private /* synthetic */ ModelRenderer guardianEye;
    
    @Override
    public void render(final Entity llllllllllllllIIIlIIIIlIllllIIlI, final float llllllllllllllIIIlIIIIlIlllllIIl, final float llllllllllllllIIIlIIIIlIlllllIII, final float llllllllllllllIIIlIIIIlIllllIlll, final float llllllllllllllIIIlIIIIlIlllIlllI, final float llllllllllllllIIIlIIIIlIlllIllIl, final float llllllllllllllIIIlIIIIlIllllIlII) {
        this.setRotationAngles(llllllllllllllIIIlIIIIlIlllllIIl, llllllllllllllIIIlIIIIlIlllllIII, llllllllllllllIIIlIIIIlIllllIlll, llllllllllllllIIIlIIIIlIlllIlllI, llllllllllllllIIIlIIIIlIlllIllIl, llllllllllllllIIIlIIIIlIllllIlII, llllllllllllllIIIlIIIIlIllllIIlI);
        this.guardianBody.render(llllllllllllllIIIlIIIIlIllllIlII);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIlIIIIlIlIlllllI, final float llllllllllllllIIIlIIIIlIlIllllII, final float llllllllllllllIIIlIIIIlIlIlllIlI, final float llllllllllllllIIIlIIIIlIlIIllIIl, final float llllllllllllllIIIlIIIIlIlIllIllI, final float llllllllllllllIIIlIIIIlIlIllIlII, final Entity llllllllllllllIIIlIIIIlIlIIlIlll) {
        final EntityGuardian llllllllllllllIIIlIIIIlIlIllIIII = (EntityGuardian)llllllllllllllIIIlIIIIlIlIIlIlll;
        final float llllllllllllllIIIlIIIIlIlIlIlllI = llllllllllllllIIIlIIIIlIlIlllIlI - llllllllllllllIIIlIIIIlIlIllIIII.ticksExisted;
        this.guardianBody.rotateAngleY = llllllllllllllIIIlIIIIlIlIIllIIl / 57.295776f;
        this.guardianBody.rotateAngleX = llllllllllllllIIIlIIIIlIlIllIllI / 57.295776f;
        final float[] llllllllllllllIIIlIIIIlIlIlIllII = { 1.75f, 0.25f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 0.5f, 1.25f, 0.75f, 0.0f, 0.0f };
        final float[] llllllllllllllIIIlIIIIlIlIlIlIlI = { 0.0f, 0.0f, 0.0f, 0.0f, 0.25f, 1.75f, 1.25f, 0.75f, 0.0f, 0.0f, 0.0f, 0.0f };
        final float[] llllllllllllllIIIlIIIIlIlIlIlIIl = { 0.0f, 0.0f, 0.25f, 1.75f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.75f, 1.25f };
        final float[] llllllllllllllIIIlIIIIlIlIlIlIII = { 0.0f, 0.0f, 8.0f, -8.0f, -8.0f, 8.0f, 8.0f, -8.0f, 0.0f, 0.0f, 8.0f, -8.0f };
        final float[] llllllllllllllIIIlIIIIlIlIlIIlll = { -8.0f, -8.0f, -8.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 8.0f, 8.0f, 8.0f };
        final float[] llllllllllllllIIIlIIIIlIlIlIIllI = { 8.0f, -8.0f, 0.0f, 0.0f, -8.0f, -8.0f, 8.0f, 8.0f, 8.0f, -8.0f, 0.0f, 0.0f };
        final float llllllllllllllIIIlIIIIlIlIlIIlIl = (1.0f - llllllllllllllIIIlIIIIlIlIllIIII.func_175469_o(llllllllllllllIIIlIIIIlIlIlIlllI)) * 0.55f;
        for (int llllllllllllllIIIlIIIIlIlIlIIlII = 0; llllllllllllllIIIlIIIIlIlIlIIlII < 12; ++llllllllllllllIIIlIIIIlIlIlIIlII) {
            this.guardianSpines[llllllllllllllIIIlIIIIlIlIlIIlII].rotateAngleX = 3.1415927f * llllllllllllllIIIlIIIIlIlIlIllII[llllllllllllllIIIlIIIIlIlIlIIlII];
            this.guardianSpines[llllllllllllllIIIlIIIIlIlIlIIlII].rotateAngleY = 3.1415927f * llllllllllllllIIIlIIIIlIlIlIlIlI[llllllllllllllIIIlIIIIlIlIlIIlII];
            this.guardianSpines[llllllllllllllIIIlIIIIlIlIlIIlII].rotateAngleZ = 3.1415927f * llllllllllllllIIIlIIIIlIlIlIlIIl[llllllllllllllIIIlIIIIlIlIlIIlII];
            this.guardianSpines[llllllllllllllIIIlIIIIlIlIlIIlII].rotationPointX = llllllllllllllIIIlIIIIlIlIlIlIII[llllllllllllllIIIlIIIIlIlIlIIlII] * (1.0f + MathHelper.cos(llllllllllllllIIIlIIIIlIlIlllIlI * 1.5f + llllllllllllllIIIlIIIIlIlIlIIlII) * 0.01f - llllllllllllllIIIlIIIIlIlIlIIlIl);
            this.guardianSpines[llllllllllllllIIIlIIIIlIlIlIIlII].rotationPointY = 16.0f + llllllllllllllIIIlIIIIlIlIlIIlll[llllllllllllllIIIlIIIIlIlIlIIlII] * (1.0f + MathHelper.cos(llllllllllllllIIIlIIIIlIlIlllIlI * 1.5f + llllllllllllllIIIlIIIIlIlIlIIlII) * 0.01f - llllllllllllllIIIlIIIIlIlIlIIlIl);
            this.guardianSpines[llllllllllllllIIIlIIIIlIlIlIIlII].rotationPointZ = llllllllllllllIIIlIIIIlIlIlIIllI[llllllllllllllIIIlIIIIlIlIlIIlII] * (1.0f + MathHelper.cos(llllllllllllllIIIlIIIIlIlIlllIlI * 1.5f + llllllllllllllIIIlIIIIlIlIlIIlII) * 0.01f - llllllllllllllIIIlIIIIlIlIlIIlIl);
        }
        this.guardianEye.rotationPointZ = -8.25f;
        Object llllllllllllllIIIlIIIIlIlIlIIIll = Minecraft.getMinecraft().func_175606_aa();
        if (llllllllllllllIIIlIIIIlIlIllIIII.func_175474_cn()) {
            llllllllllllllIIIlIIIIlIlIlIIIll = llllllllllllllIIIlIIIIlIlIllIIII.func_175466_co();
        }
        if (llllllllllllllIIIlIIIIlIlIlIIIll != null) {
            final Vec3 llllllllllllllIIIlIIIIlIlIlIIIlI = ((Entity)llllllllllllllIIIlIIIIlIlIlIIIll).func_174824_e(0.0f);
            final Vec3 llllllllllllllIIIlIIIIlIlIlIIIIl = llllllllllllllIIIlIIIIlIlIIlIlll.func_174824_e(0.0f);
            final double llllllllllllllIIIlIIIIlIlIlIIIII = llllllllllllllIIIlIIIIlIlIlIIIlI.yCoord - llllllllllllllIIIlIIIIlIlIlIIIIl.yCoord;
            if (llllllllllllllIIIlIIIIlIlIlIIIII > 0.0) {
                this.guardianEye.rotationPointY = 0.0f;
            }
            else {
                this.guardianEye.rotationPointY = 1.0f;
            }
            Vec3 llllllllllllllIIIlIIIIlIlIIlllll = llllllllllllllIIIlIIIIlIlIIlIlll.getLook(0.0f);
            llllllllllllllIIIlIIIIlIlIIlllll = new Vec3(llllllllllllllIIIlIIIIlIlIIlllll.xCoord, 0.0, llllllllllllllIIIlIIIIlIlIIlllll.zCoord);
            final Vec3 llllllllllllllIIIlIIIIlIlIIllllI = new Vec3(llllllllllllllIIIlIIIIlIlIlIIIIl.xCoord - llllllllllllllIIIlIIIIlIlIlIIIlI.xCoord, 0.0, llllllllllllllIIIlIIIIlIlIlIIIIl.zCoord - llllllllllllllIIIlIIIIlIlIlIIIlI.zCoord).normalize().rotateYaw(1.5707964f);
            final double llllllllllllllIIIlIIIIlIlIIlllIl = llllllllllllllIIIlIIIIlIlIIlllll.dotProduct(llllllllllllllIIIlIIIIlIlIIllllI);
            this.guardianEye.rotationPointX = MathHelper.sqrt_float((float)Math.abs(llllllllllllllIIIlIIIIlIlIIlllIl)) * 2.0f * (float)Math.signum(llllllllllllllIIIlIIIIlIlIIlllIl);
        }
        this.guardianEye.showModel = true;
        final float llllllllllllllIIIlIIIIlIlIIlllII = llllllllllllllIIIlIIIIlIlIllIIII.func_175471_a(llllllllllllllIIIlIIIIlIlIlIlllI);
        this.guardianTail[0].rotateAngleY = MathHelper.sin(llllllllllllllIIIlIIIIlIlIIlllII) * 3.1415927f * 0.05f;
        this.guardianTail[1].rotateAngleY = MathHelper.sin(llllllllllllllIIIlIIIIlIlIIlllII) * 3.1415927f * 0.1f;
        this.guardianTail[1].rotationPointX = -1.5f;
        this.guardianTail[1].rotationPointY = 0.5f;
        this.guardianTail[1].rotationPointZ = 14.0f;
        this.guardianTail[2].rotateAngleY = MathHelper.sin(llllllllllllllIIIlIIIIlIlIIlllII) * 3.1415927f * 0.15f;
        this.guardianTail[2].rotationPointX = 0.5f;
        this.guardianTail[2].rotationPointY = 0.5f;
        this.guardianTail[2].rotationPointZ = 6.0f;
    }
    
    public ModelGuardian() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.guardianSpines = new ModelRenderer[12];
        this.guardianBody = new ModelRenderer(this);
        this.guardianBody.setTextureOffset(0, 0).addBox(-6.0f, 10.0f, -8.0f, 12, 12, 16);
        this.guardianBody.setTextureOffset(0, 28).addBox(-8.0f, 10.0f, -6.0f, 2, 12, 12);
        this.guardianBody.setTextureOffset(0, 28).addBox(6.0f, 10.0f, -6.0f, 2, 12, 12, true);
        this.guardianBody.setTextureOffset(16, 40).addBox(-6.0f, 8.0f, -6.0f, 12, 2, 12);
        this.guardianBody.setTextureOffset(16, 40).addBox(-6.0f, 22.0f, -6.0f, 12, 2, 12);
        for (int llllllllllllllIIIlIIIIllIIIIIlll = 0; llllllllllllllIIIlIIIIllIIIIIlll < this.guardianSpines.length; ++llllllllllllllIIIlIIIIllIIIIIlll) {
            (this.guardianSpines[llllllllllllllIIIlIIIIllIIIIIlll] = new ModelRenderer(this, 0, 0)).addBox(-1.0f, -4.5f, -1.0f, 2, 9, 2);
            this.guardianBody.addChild(this.guardianSpines[llllllllllllllIIIlIIIIllIIIIIlll]);
        }
        this.guardianEye = new ModelRenderer(this, 8, 0);
        this.guardianEye.addBox(-1.0f, 15.0f, 0.0f, 2, 2, 1);
        this.guardianBody.addChild(this.guardianEye);
        this.guardianTail = new ModelRenderer[3];
        (this.guardianTail[0] = new ModelRenderer(this, 40, 0)).addBox(-2.0f, 14.0f, 7.0f, 4, 4, 8);
        (this.guardianTail[1] = new ModelRenderer(this, 0, 54)).addBox(0.0f, 14.0f, 0.0f, 3, 3, 7);
        this.guardianTail[2] = new ModelRenderer(this);
        this.guardianTail[2].setTextureOffset(41, 32).addBox(0.0f, 14.0f, 0.0f, 2, 2, 6);
        this.guardianTail[2].setTextureOffset(25, 19).addBox(1.0f, 10.5f, 3.0f, 1, 9, 9);
        this.guardianBody.addChild(this.guardianTail[0]);
        this.guardianTail[0].addChild(this.guardianTail[1]);
        this.guardianTail[1].addChild(this.guardianTail[2]);
    }
    
    static {
        __OBFID = "CL_00002628";
    }
    
    public int func_178706_a() {
        return 54;
    }
}
