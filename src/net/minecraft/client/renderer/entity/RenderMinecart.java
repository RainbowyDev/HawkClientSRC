package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;

public class RenderMinecart extends Render
{
    private static final /* synthetic */ ResourceLocation minecartTextures;
    protected /* synthetic */ ModelBase modelMinecart;
    
    protected void func_180560_a(final EntityMinecart llIIIllllIllIl, final float llIIIllllIllII, final IBlockState llIIIllllIlIll) {
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getBlockRendererDispatcher().func_175016_a(llIIIllllIlIll, llIIIllllIllIl.getBrightness(llIIIllllIllII));
        GlStateManager.popMatrix();
    }
    
    public void doRender(final EntityMinecart llIIlIIIlIIIIl, double llIIlIIIIIIlll, double llIIlIIIIIIllI, double llIIlIIIIIIlIl, float llIIlIIIIIIlII, final float llIIlIIIIIIIll) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(llIIlIIIlIIIIl);
        long llIIlIIIIllIll = llIIlIIIlIIIIl.getEntityId() * 493286711L;
        llIIlIIIIllIll = llIIlIIIIllIll * llIIlIIIIllIll * 4392167121L + llIIlIIIIllIll * 98761L;
        final float llIIlIIIIllIlI = (((llIIlIIIIllIll >> 16 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        final float llIIlIIIIllIIl = (((llIIlIIIIllIll >> 20 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        final float llIIlIIIIllIII = (((llIIlIIIIllIll >> 24 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        GlStateManager.translate(llIIlIIIIllIlI, llIIlIIIIllIIl, llIIlIIIIllIII);
        final double llIIlIIIIlIlll = llIIlIIIlIIIIl.lastTickPosX + (llIIlIIIlIIIIl.posX - llIIlIIIlIIIIl.lastTickPosX) * llIIlIIIIIIIll;
        final double llIIlIIIIlIllI = llIIlIIIlIIIIl.lastTickPosY + (llIIlIIIlIIIIl.posY - llIIlIIIlIIIIl.lastTickPosY) * llIIlIIIIIIIll;
        final double llIIlIIIIlIlIl = llIIlIIIlIIIIl.lastTickPosZ + (llIIlIIIlIIIIl.posZ - llIIlIIIlIIIIl.lastTickPosZ) * llIIlIIIIIIIll;
        final double llIIlIIIIlIlII = 0.30000001192092896;
        final Vec3 llIIlIIIIlIIll = llIIlIIIlIIIIl.func_70489_a(llIIlIIIIlIlll, llIIlIIIIlIllI, llIIlIIIIlIlIl);
        float llIIlIIIIlIIlI = llIIlIIIlIIIIl.prevRotationPitch + (llIIlIIIlIIIIl.rotationPitch - llIIlIIIlIIIIl.prevRotationPitch) * llIIlIIIIIIIll;
        if (llIIlIIIIlIIll != null) {
            Vec3 llIIlIIIIlIIIl = llIIlIIIlIIIIl.func_70495_a(llIIlIIIIlIlll, llIIlIIIIlIllI, llIIlIIIIlIlIl, llIIlIIIIlIlII);
            Vec3 llIIlIIIIlIIII = llIIlIIIlIIIIl.func_70495_a(llIIlIIIIlIlll, llIIlIIIIlIllI, llIIlIIIIlIlIl, -llIIlIIIIlIlII);
            if (llIIlIIIIlIIIl == null) {
                llIIlIIIIlIIIl = llIIlIIIIlIIll;
            }
            if (llIIlIIIIlIIII == null) {
                llIIlIIIIlIIII = llIIlIIIIlIIll;
            }
            llIIlIIIIIIlll += llIIlIIIIlIIll.xCoord - llIIlIIIIlIlll;
            llIIlIIIIIIllI += (llIIlIIIIlIIIl.yCoord + llIIlIIIIlIIII.yCoord) / 2.0 - llIIlIIIIlIllI;
            llIIlIIIIIIlIl += llIIlIIIIlIIll.zCoord - llIIlIIIIlIlIl;
            Vec3 llIIlIIIIIllll = llIIlIIIIlIIII.addVector(-llIIlIIIIlIIIl.xCoord, -llIIlIIIIlIIIl.yCoord, -llIIlIIIIlIIIl.zCoord);
            if (llIIlIIIIIllll.lengthVector() != 0.0) {
                llIIlIIIIIllll = llIIlIIIIIllll.normalize();
                llIIlIIIIIIlII = (float)(Math.atan2(llIIlIIIIIllll.zCoord, llIIlIIIIIllll.xCoord) * 180.0 / 3.141592653589793);
                llIIlIIIIlIIlI = (float)(Math.atan(llIIlIIIIIllll.yCoord) * 73.0);
            }
        }
        GlStateManager.translate((float)llIIlIIIIIIlll, (float)llIIlIIIIIIllI + 0.375f, (float)llIIlIIIIIIlIl);
        GlStateManager.rotate(180.0f - llIIlIIIIIIlII, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-llIIlIIIIlIIlI, 0.0f, 0.0f, 1.0f);
        final float llIIlIIIIIlllI = llIIlIIIlIIIIl.getRollingAmplitude() - llIIlIIIIIIIll;
        float llIIlIIIIIllIl = llIIlIIIlIIIIl.getDamage() - llIIlIIIIIIIll;
        if (llIIlIIIIIllIl < 0.0f) {
            llIIlIIIIIllIl = 0.0f;
        }
        if (llIIlIIIIIlllI > 0.0f) {
            GlStateManager.rotate(MathHelper.sin(llIIlIIIIIlllI) * llIIlIIIIIlllI * llIIlIIIIIllIl / 10.0f * llIIlIIIlIIIIl.getRollingDirection(), 1.0f, 0.0f, 0.0f);
        }
        final int llIIlIIIIIllII = llIIlIIIlIIIIl.getDisplayTileOffset();
        final IBlockState llIIlIIIIIlIll = llIIlIIIlIIIIl.func_174897_t();
        if (llIIlIIIIIlIll.getBlock().getRenderType() != -1) {
            GlStateManager.pushMatrix();
            this.bindTexture(TextureMap.locationBlocksTexture);
            final float llIIlIIIIIlIlI = 0.75f;
            GlStateManager.scale(llIIlIIIIIlIlI, llIIlIIIIIlIlI, llIIlIIIIIlIlI);
            GlStateManager.translate(-0.5f, (llIIlIIIIIllII - 8) / 16.0f, 0.5f);
            this.func_180560_a(llIIlIIIlIIIIl, llIIlIIIIIIIll, llIIlIIIIIlIll);
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.bindEntityTexture(llIIlIIIlIIIIl);
        }
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        this.modelMinecart.render(llIIlIIIlIIIIl, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
        super.doRender(llIIlIIIlIIIIl, llIIlIIIIIIlll, llIIlIIIIIIllI, llIIlIIIIIIlIl, llIIlIIIIIIlII, llIIlIIIIIIIll);
    }
    
    protected ResourceLocation getEntityTexture(final EntityMinecart llIIIlllllIIlI) {
        return RenderMinecart.minecartTextures;
    }
    
    public RenderMinecart(final RenderManager llIIlIIIlllIll) {
        super(llIIlIIIlllIll);
        this.modelMinecart = new ModelMinecart();
        this.shadowSize = 0.5f;
    }
    
    static {
        __OBFID = "CL_00001013";
        minecartTextures = new ResourceLocation("textures/entity/minecart.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llIIIllllIIlII) {
        return this.getEntityTexture((EntityMinecart)llIIIllllIIlII);
    }
    
    @Override
    public void doRender(final Entity llIIIlllIlIIlI, final double llIIIlllIllIII, final double llIIIlllIlIIII, final double llIIIlllIIllll, final float llIIIlllIlIlIl, final float llIIIlllIIllIl) {
        this.doRender((EntityMinecart)llIIIlllIlIIlI, llIIIlllIllIII, llIIIlllIlIIII, llIIIlllIIllll, llIIIlllIlIlIl, llIIIlllIIllIl);
    }
}
