package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.culling.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class RenderGuardian extends RenderLiving
{
    /* synthetic */ int field_177115_a;
    private static final /* synthetic */ ResourceLocation field_177116_j;
    private static final /* synthetic */ ResourceLocation field_177114_e;
    private static final /* synthetic */ ResourceLocation field_177117_k;
    
    @Override
    public boolean func_177104_a(final EntityLiving llllllllllllllIIlIlIIIlIlIIIIIII, final ICamera llllllllllllllIIlIlIIIlIIlllllll, final double llllllllllllllIIlIlIIIlIIllllllI, final double llllllllllllllIIlIlIIIlIIlllllIl, final double llllllllllllllIIlIlIIIlIIlllIllI) {
        return this.func_177113_a((EntityGuardian)llllllllllllllIIlIlIIIlIlIIIIIII, llllllllllllllIIlIlIIIlIIlllllll, llllllllllllllIIlIlIIIlIIllllllI, llllllllllllllIIlIlIIIlIIlllllIl, llllllllllllllIIlIlIIIlIIlllIllI);
    }
    
    static {
        __OBFID = "CL_00002443";
        field_177114_e = new ResourceLocation("textures/entity/guardian.png");
        field_177116_j = new ResourceLocation("textures/entity/guardian_elder.png");
        field_177117_k = new ResourceLocation("textures/entity/guardian_beam.png");
    }
    
    @Override
    public void doRender(final EntityLiving llllllllllllllIIlIlIIIlIlIIlIlII, final double llllllllllllllIIlIlIIIlIlIIIllII, final double llllllllllllllIIlIlIIIlIlIIIlIll, final double llllllllllllllIIlIlIIIlIlIIIlIlI, final float llllllllllllllIIlIlIIIlIlIIlIIII, final float llllllllllllllIIlIlIIIlIlIIIlIII) {
        this.func_177109_a((EntityGuardian)llllllllllllllIIlIlIIIlIlIIlIlII, llllllllllllllIIlIlIIIlIlIIIllII, llllllllllllllIIlIlIIIlIlIIIlIll, llllllllllllllIIlIlIIIlIlIIIlIlI, llllllllllllllIIlIlIIIlIlIIlIIII, llllllllllllllIIlIlIIIlIlIIIlIII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIlIlIIIlIIlIlIlII) {
        return this.func_177111_a((EntityGuardian)llllllllllllllIIlIlIIIlIIlIlIlII);
    }
    
    private Vec3 func_177110_a(final EntityLivingBase llllllllllllllIIlIlIIIllIIlllllI, final double llllllllllllllIIlIlIIIllIIllIlll, final float llllllllllllllIIlIlIIIllIIllIllI) {
        final double llllllllllllllIIlIlIIIllIIlllIll = llllllllllllllIIlIlIIIllIIlllllI.lastTickPosX + (llllllllllllllIIlIlIIIllIIlllllI.posX - llllllllllllllIIlIlIIIllIIlllllI.lastTickPosX) * llllllllllllllIIlIlIIIllIIllIllI;
        final double llllllllllllllIIlIlIIIllIIlllIlI = llllllllllllllIIlIlIIIllIIllIlll + llllllllllllllIIlIlIIIllIIlllllI.lastTickPosY + (llllllllllllllIIlIlIIIllIIlllllI.posY - llllllllllllllIIlIlIIIllIIlllllI.lastTickPosY) * llllllllllllllIIlIlIIIllIIllIllI;
        final double llllllllllllllIIlIlIIIllIIlllIIl = llllllllllllllIIlIlIIIllIIlllllI.lastTickPosZ + (llllllllllllllIIlIlIIIllIIlllllI.posZ - llllllllllllllIIlIlIIIllIIlllllI.lastTickPosZ) * llllllllllllllIIlIlIIIllIIllIllI;
        return new Vec3(llllllllllllllIIlIlIIIllIIlllIll, llllllllllllllIIlIlIIIllIIlllIlI, llllllllllllllIIlIlIIIllIIlllIIl);
    }
    
    @Override
    public void doRender(final EntityLivingBase llllllllllllllIIlIlIIIlIIllIIlII, final double llllllllllllllIIlIlIIIlIIllIIIll, final double llllllllllllllIIlIlIIIlIIllIIIlI, final double llllllllllllllIIlIlIIIlIIllIIIIl, final float llllllllllllllIIlIlIIIlIIlIllIIl, final float llllllllllllllIIlIlIIIlIIlIlllll) {
        this.func_177109_a((EntityGuardian)llllllllllllllIIlIlIIIlIIllIIlII, llllllllllllllIIlIlIIIlIIllIIIll, llllllllllllllIIlIlIIIlIIllIIIlI, llllllllllllllIIlIlIIIlIIllIIIIl, llllllllllllllIIlIlIIIlIIlIllIIl, llllllllllllllIIlIlIIIlIIlIlllll);
    }
    
    @Override
    public boolean func_177071_a(final Entity llllllllllllllIIlIlIIIlIIIllIlIl, final ICamera llllllllllllllIIlIlIIIlIIIlIlllI, final double llllllllllllllIIlIlIIIlIIIlIllIl, final double llllllllllllllIIlIlIIIlIIIllIIlI, final double llllllllllllllIIlIlIIIlIIIllIIIl) {
        return this.func_177113_a((EntityGuardian)llllllllllllllIIlIlIIIlIIIllIlIl, llllllllllllllIIlIlIIIlIIIlIlllI, llllllllllllllIIlIlIIIlIIIlIllIl, llllllllllllllIIlIlIIIlIIIllIIlI, llllllllllllllIIlIlIIIlIIIllIIIl);
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIIlIlIIIlIIlIIIIlI, final double llllllllllllllIIlIlIIIlIIlIIlIII, final double llllllllllllllIIlIlIIIlIIlIIIlll, final double llllllllllllllIIlIlIIIlIIIllllll, final float llllllllllllllIIlIlIIIlIIlIIIlIl, final float llllllllllllllIIlIlIIIlIIlIIIlII) {
        this.func_177109_a((EntityGuardian)llllllllllllllIIlIlIIIlIIlIIIIlI, llllllllllllllIIlIlIIIlIIlIIlIII, llllllllllllllIIlIlIIIlIIlIIIlll, llllllllllllllIIlIlIIIlIIIllllll, llllllllllllllIIlIlIIIlIIlIIIlIl, llllllllllllllIIlIlIIIlIIlIIIlII);
    }
    
    protected void func_177112_a(final EntityGuardian llllllllllllllIIlIlIIIlIlIlIIIIl, final float llllllllllllllIIlIlIIIlIlIlIIIlI) {
        if (llllllllllllllIIlIlIIIlIlIlIIIIl.func_175461_cl()) {
            GlStateManager.scale(2.35f, 2.35f, 2.35f);
        }
    }
    
    public boolean func_177113_a(final EntityGuardian llllllllllllllIIlIlIIIllIlIlIllI, final ICamera llllllllllllllIIlIlIIIllIlIlIlIl, final double llllllllllllllIIlIlIIIllIlIIlIll, final double llllllllllllllIIlIlIIIllIlIIlIlI, final double llllllllllllllIIlIlIIIllIlIIlIIl) {
        if (super.func_177104_a(llllllllllllllIIlIlIIIllIlIlIllI, llllllllllllllIIlIlIIIllIlIlIlIl, llllllllllllllIIlIlIIIllIlIIlIll, llllllllllllllIIlIlIIIllIlIIlIlI, llllllllllllllIIlIlIIIllIlIIlIIl)) {
            return true;
        }
        if (llllllllllllllIIlIlIIIllIlIlIllI.func_175474_cn()) {
            final EntityLivingBase llllllllllllllIIlIlIIIllIlIlIIIl = llllllllllllllIIlIlIIIllIlIlIllI.func_175466_co();
            if (llllllllllllllIIlIlIIIllIlIlIIIl != null) {
                final Vec3 llllllllllllllIIlIlIIIllIlIlIIII = this.func_177110_a(llllllllllllllIIlIlIIIllIlIlIIIl, llllllllllllllIIlIlIIIllIlIlIIIl.height * 0.5, 1.0f);
                final Vec3 llllllllllllllIIlIlIIIllIlIIllll = this.func_177110_a(llllllllllllllIIlIlIIIllIlIlIllI, llllllllllllllIIlIlIIIllIlIlIllI.getEyeHeight(), 1.0f);
                if (llllllllllllllIIlIlIIIllIlIlIlIl.isBoundingBoxInFrustum(AxisAlignedBB.fromBounds(llllllllllllllIIlIlIIIllIlIIllll.xCoord, llllllllllllllIIlIlIIIllIlIIllll.yCoord, llllllllllllllIIlIlIIIllIlIIllll.zCoord, llllllllllllllIIlIlIIIllIlIlIIII.xCoord, llllllllllllllIIlIlIIIllIlIlIIII.yCoord, llllllllllllllIIlIlIIIllIlIlIIII.zCoord))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected ResourceLocation func_177111_a(final EntityGuardian llllllllllllllIIlIlIIIlIlIIllllI) {
        return llllllllllllllIIlIlIIIlIlIIllllI.func_175461_cl() ? RenderGuardian.field_177116_j : RenderGuardian.field_177114_e;
    }
    
    public RenderGuardian(final RenderManager llllllllllllllIIlIlIIIllIllIIIIl) {
        super(llllllllllllllIIlIlIIIllIllIIIIl, new ModelGuardian(), 0.5f);
        this.field_177115_a = ((ModelGuardian)this.mainModel).func_178706_a();
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllIIlIlIIIlIIllIlllI, final float llllllllllllllIIlIlIIIlIIllIllIl) {
        this.func_177112_a((EntityGuardian)llllllllllllllIIlIlIIIlIIllIlllI, llllllllllllllIIlIlIIIlIIllIllIl);
    }
    
    public void func_177109_a(final EntityGuardian llllllllllllllIIlIlIIIllIIIIIIlI, final double llllllllllllllIIlIlIIIllIIIIIIIl, final double llllllllllllllIIlIlIIIllIIIIIIII, final double llllllllllllllIIlIlIIIlIllIIllIl, final float llllllllllllllIIlIlIIIlIlllllllI, final float llllllllllllllIIlIlIIIlIllIIlIlI) {
        if (this.field_177115_a != ((ModelGuardian)this.mainModel).func_178706_a()) {
            this.mainModel = new ModelGuardian();
            this.field_177115_a = ((ModelGuardian)this.mainModel).func_178706_a();
        }
        super.doRender(llllllllllllllIIlIlIIIllIIIIIIlI, llllllllllllllIIlIlIIIllIIIIIIIl, llllllllllllllIIlIlIIIllIIIIIIII, llllllllllllllIIlIlIIIlIllIIllIl, llllllllllllllIIlIlIIIlIlllllllI, llllllllllllllIIlIlIIIlIllIIlIlI);
        final EntityLivingBase llllllllllllllIIlIlIIIlIllllllII = llllllllllllllIIlIlIIIllIIIIIIlI.func_175466_co();
        if (llllllllllllllIIlIlIIIlIllllllII != null) {
            final float llllllllllllllIIlIlIIIlIlllllIll = llllllllllllllIIlIlIIIllIIIIIIlI.func_175477_p(llllllllllllllIIlIlIIIlIllIIlIlI);
            final Tessellator llllllllllllllIIlIlIIIlIlllllIlI = Tessellator.getInstance();
            final WorldRenderer llllllllllllllIIlIlIIIlIlllllIIl = llllllllllllllIIlIlIIIlIlllllIlI.getWorldRenderer();
            this.bindTexture(RenderGuardian.field_177117_k);
            GL11.glTexParameterf(3553, 10242, 10497.0f);
            GL11.glTexParameterf(3553, 10243, 10497.0f);
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            final float llllllllllllllIIlIlIIIlIlllllIII = 240.0f;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllIIlIlIIIlIlllllIII, llllllllllllllIIlIlIIIlIlllllIII);
            GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
            final float llllllllllllllIIlIlIIIlIllllIlll = llllllllllllllIIlIlIIIllIIIIIIlI.worldObj.getTotalWorldTime() + llllllllllllllIIlIlIIIlIllIIlIlI;
            final float llllllllllllllIIlIlIIIlIllllIllI = llllllllllllllIIlIlIIIlIllllIlll * 0.5f % 1.0f;
            final float llllllllllllllIIlIlIIIlIllllIlIl = llllllllllllllIIlIlIIIllIIIIIIlI.getEyeHeight();
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)llllllllllllllIIlIlIIIllIIIIIIIl, (float)llllllllllllllIIlIlIIIllIIIIIIII + llllllllllllllIIlIlIIIlIllllIlIl, (float)llllllllllllllIIlIlIIIlIllIIllIl);
            final Vec3 llllllllllllllIIlIlIIIlIllllIlII = this.func_177110_a(llllllllllllllIIlIlIIIlIllllllII, llllllllllllllIIlIlIIIlIllllllII.height * 0.5, llllllllllllllIIlIlIIIlIllIIlIlI);
            final Vec3 llllllllllllllIIlIlIIIlIllllIIll = this.func_177110_a(llllllllllllllIIlIlIIIllIIIIIIlI, llllllllllllllIIlIlIIIlIllllIlIl, llllllllllllllIIlIlIIIlIllIIlIlI);
            Vec3 llllllllllllllIIlIlIIIlIllllIIlI = llllllllllllllIIlIlIIIlIllllIlII.subtract(llllllllllllllIIlIlIIIlIllllIIll);
            final double llllllllllllllIIlIlIIIlIllllIIIl = llllllllllllllIIlIlIIIlIllllIIlI.lengthVector() + 1.0;
            llllllllllllllIIlIlIIIlIllllIIlI = llllllllllllllIIlIlIIIlIllllIIlI.normalize();
            final float llllllllllllllIIlIlIIIlIllllIIII = (float)Math.acos(llllllllllllllIIlIlIIIlIllllIIlI.yCoord);
            final float llllllllllllllIIlIlIIIlIlllIllll = (float)Math.atan2(llllllllllllllIIlIlIIIlIllllIIlI.zCoord, llllllllllllllIIlIlIIIlIllllIIlI.xCoord);
            GlStateManager.rotate((1.5707964f + -llllllllllllllIIlIlIIIlIlllIllll) * 57.295776f, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(llllllllllllllIIlIlIIIlIllllIIII * 57.295776f, 1.0f, 0.0f, 0.0f);
            final byte llllllllllllllIIlIlIIIlIlllIlllI = 1;
            final double llllllllllllllIIlIlIIIlIlllIllIl = llllllllllllllIIlIlIIIlIllllIlll * 0.05 * (1.0 - (llllllllllllllIIlIlIIIlIlllIlllI & 0x1) * 2.5);
            llllllllllllllIIlIlIIIlIlllllIIl.startDrawingQuads();
            final float llllllllllllllIIlIlIIIlIlllIllII = llllllllllllllIIlIlIIIlIlllllIll * llllllllllllllIIlIlIIIlIlllllIll;
            llllllllllllllIIlIlIIIlIlllllIIl.func_178961_b(64 + (int)(llllllllllllllIIlIlIIIlIlllIllII * 240.0f), 32 + (int)(llllllllllllllIIlIlIIIlIlllIllII * 192.0f), 128 - (int)(llllllllllllllIIlIlIIIlIlllIllII * 64.0f), 255);
            final double llllllllllllllIIlIlIIIlIlllIlIll = llllllllllllllIIlIlIIIlIlllIlllI * 0.2;
            final double llllllllllllllIIlIlIIIlIlllIlIlI = llllllllllllllIIlIlIIIlIlllIlIll * 1.41;
            final double llllllllllllllIIlIlIIIlIlllIlIIl = 0.0 + Math.cos(llllllllllllllIIlIlIIIlIlllIllIl + 2.356194490192345) * llllllllllllllIIlIlIIIlIlllIlIlI;
            final double llllllllllllllIIlIlIIIlIlllIlIII = 0.0 + Math.sin(llllllllllllllIIlIlIIIlIlllIllIl + 2.356194490192345) * llllllllllllllIIlIlIIIlIlllIlIlI;
            final double llllllllllllllIIlIlIIIlIlllIIlll = 0.0 + Math.cos(llllllllllllllIIlIlIIIlIlllIllIl + 0.7853981633974483) * llllllllllllllIIlIlIIIlIlllIlIlI;
            final double llllllllllllllIIlIlIIIlIlllIIllI = 0.0 + Math.sin(llllllllllllllIIlIlIIIlIlllIllIl + 0.7853981633974483) * llllllllllllllIIlIlIIIlIlllIlIlI;
            final double llllllllllllllIIlIlIIIlIlllIIlIl = 0.0 + Math.cos(llllllllllllllIIlIlIIIlIlllIllIl + 3.9269908169872414) * llllllllllllllIIlIlIIIlIlllIlIlI;
            final double llllllllllllllIIlIlIIIlIlllIIlII = 0.0 + Math.sin(llllllllllllllIIlIlIIIlIlllIllIl + 3.9269908169872414) * llllllllllllllIIlIlIIIlIlllIlIlI;
            final double llllllllllllllIIlIlIIIlIlllIIIll = 0.0 + Math.cos(llllllllllllllIIlIlIIIlIlllIllIl + 5.497787143782138) * llllllllllllllIIlIlIIIlIlllIlIlI;
            final double llllllllllllllIIlIlIIIlIlllIIIlI = 0.0 + Math.sin(llllllllllllllIIlIlIIIlIlllIllIl + 5.497787143782138) * llllllllllllllIIlIlIIIlIlllIlIlI;
            final double llllllllllllllIIlIlIIIlIlllIIIIl = 0.0 + Math.cos(llllllllllllllIIlIlIIIlIlllIllIl + 3.141592653589793) * llllllllllllllIIlIlIIIlIlllIlIll;
            final double llllllllllllllIIlIlIIIlIlllIIIII = 0.0 + Math.sin(llllllllllllllIIlIlIIIlIlllIllIl + 3.141592653589793) * llllllllllllllIIlIlIIIlIlllIlIll;
            final double llllllllllllllIIlIlIIIlIllIlllll = 0.0 + Math.cos(llllllllllllllIIlIlIIIlIlllIllIl + 0.0) * llllllllllllllIIlIlIIIlIlllIlIll;
            final double llllllllllllllIIlIlIIIlIllIllllI = 0.0 + Math.sin(llllllllllllllIIlIlIIIlIlllIllIl + 0.0) * llllllllllllllIIlIlIIIlIlllIlIll;
            final double llllllllllllllIIlIlIIIlIllIlllIl = 0.0 + Math.cos(llllllllllllllIIlIlIIIlIlllIllIl + 1.5707963267948966) * llllllllllllllIIlIlIIIlIlllIlIll;
            final double llllllllllllllIIlIlIIIlIllIlllII = 0.0 + Math.sin(llllllllllllllIIlIlIIIlIlllIllIl + 1.5707963267948966) * llllllllllllllIIlIlIIIlIlllIlIll;
            final double llllllllllllllIIlIlIIIlIllIllIll = 0.0 + Math.cos(llllllllllllllIIlIlIIIlIlllIllIl + 4.71238898038469) * llllllllllllllIIlIlIIIlIlllIlIll;
            final double llllllllllllllIIlIlIIIlIllIllIlI = 0.0 + Math.sin(llllllllllllllIIlIlIIIlIlllIllIl + 4.71238898038469) * llllllllllllllIIlIlIIIlIlllIlIll;
            final double llllllllllllllIIlIlIIIlIllIllIIl = 0.0;
            final double llllllllllllllIIlIlIIIlIllIllIII = 0.4999;
            final double llllllllllllllIIlIlIIIlIllIlIlll = -1.0f + llllllllllllllIIlIlIIIlIllllIllI;
            final double llllllllllllllIIlIlIIIlIllIlIllI = llllllllllllllIIlIlIIIlIllllIIIl * (0.5 / llllllllllllllIIlIlIIIlIlllIlIll) + llllllllllllllIIlIlIIIlIllIlIlll;
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIlllIIIIl, llllllllllllllIIlIlIIIlIllllIIIl, llllllllllllllIIlIlIIIlIlllIIIII, llllllllllllllIIlIlIIIlIllIllIII, llllllllllllllIIlIlIIIlIllIlIllI);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIlllIIIIl, 0.0, llllllllllllllIIlIlIIIlIlllIIIII, llllllllllllllIIlIlIIIlIllIllIII, llllllllllllllIIlIlIIIlIllIlIlll);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIllIlllll, 0.0, llllllllllllllIIlIlIIIlIllIllllI, llllllllllllllIIlIlIIIlIllIllIIl, llllllllllllllIIlIlIIIlIllIlIlll);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIllIlllll, llllllllllllllIIlIlIIIlIllllIIIl, llllllllllllllIIlIlIIIlIllIllllI, llllllllllllllIIlIlIIIlIllIllIIl, llllllllllllllIIlIlIIIlIllIlIllI);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIllIlllIl, llllllllllllllIIlIlIIIlIllllIIIl, llllllllllllllIIlIlIIIlIllIlllII, llllllllllllllIIlIlIIIlIllIllIII, llllllllllllllIIlIlIIIlIllIlIllI);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIllIlllIl, 0.0, llllllllllllllIIlIlIIIlIllIlllII, llllllllllllllIIlIlIIIlIllIllIII, llllllllllllllIIlIlIIIlIllIlIlll);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIllIllIll, 0.0, llllllllllllllIIlIlIIIlIllIllIlI, llllllllllllllIIlIlIIIlIllIllIIl, llllllllllllllIIlIlIIIlIllIlIlll);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIllIllIll, llllllllllllllIIlIlIIIlIllllIIIl, llllllllllllllIIlIlIIIlIllIllIlI, llllllllllllllIIlIlIIIlIllIllIIl, llllllllllllllIIlIlIIIlIllIlIllI);
            double llllllllllllllIIlIlIIIlIllIlIlIl = 0.0;
            if (llllllllllllllIIlIlIIIllIIIIIIlI.ticksExisted % 2 == 0) {
                llllllllllllllIIlIlIIIlIllIlIlIl = 0.5;
            }
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIlllIlIIl, llllllllllllllIIlIlIIIlIllllIIIl, llllllllllllllIIlIlIIIlIlllIlIII, 0.5, llllllllllllllIIlIlIIIlIllIlIlIl + 0.5);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIlllIIlll, llllllllllllllIIlIlIIIlIllllIIIl, llllllllllllllIIlIlIIIlIlllIIllI, 1.0, llllllllllllllIIlIlIIIlIllIlIlIl + 0.5);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIlllIIIll, llllllllllllllIIlIlIIIlIllllIIIl, llllllllllllllIIlIlIIIlIlllIIIlI, 1.0, llllllllllllllIIlIlIIIlIllIlIlIl);
            llllllllllllllIIlIlIIIlIlllllIIl.addVertexWithUV(llllllllllllllIIlIlIIIlIlllIIlIl, llllllllllllllIIlIlIIIlIllllIIIl, llllllllllllllIIlIlIIIlIlllIIlII, 0.5, llllllllllllllIIlIlIIIlIllIlIlIl);
            llllllllllllllIIlIlIIIlIlllllIlI.draw();
            GlStateManager.popMatrix();
        }
    }
}
