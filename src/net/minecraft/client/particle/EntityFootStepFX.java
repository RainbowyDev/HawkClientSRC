package net.minecraft.client.particle;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.client.*;

public class EntityFootStepFX extends EntityFX
{
    private /* synthetic */ int footstepAge;
    private /* synthetic */ int footstepMaxAge;
    private static final /* synthetic */ ResourceLocation field_110126_a;
    private /* synthetic */ TextureManager currentFootSteps;
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllIIllIIIlllIlllIlII, final Entity llllllllllllllIIllIIIlllIlllIIll, final float llllllllllllllIIllIIIlllIlllIIlI, final float llllllllllllllIIllIIIlllIlllIIIl, final float llllllllllllllIIllIIIlllIlllIIII, final float llllllllllllllIIllIIIlllIllIllll, final float llllllllllllllIIllIIIlllIllIlllI, final float llllllllllllllIIllIIIlllIllIllIl) {
        float llllllllllllllIIllIIIlllIllIllII = (this.footstepAge + llllllllllllllIIllIIIlllIlllIIlI) / this.footstepMaxAge;
        llllllllllllllIIllIIIlllIllIllII *= llllllllllllllIIllIIIlllIllIllII;
        float llllllllllllllIIllIIIlllIllIlIll = 2.0f - llllllllllllllIIllIIIlllIllIllII * 2.0f;
        if (llllllllllllllIIllIIIlllIllIlIll > 1.0f) {
            llllllllllllllIIllIIIlllIllIlIll = 1.0f;
        }
        llllllllllllllIIllIIIlllIllIlIll *= 0.2f;
        GlStateManager.disableLighting();
        final float llllllllllllllIIllIIIlllIllIlIlI = 0.125f;
        final float llllllllllllllIIllIIIlllIllIlIIl = (float)(this.posX - EntityFootStepFX.interpPosX);
        final float llllllllllllllIIllIIIlllIllIlIII = (float)(this.posY - EntityFootStepFX.interpPosY);
        final float llllllllllllllIIllIIIlllIllIIlll = (float)(this.posZ - EntityFootStepFX.interpPosZ);
        final float llllllllllllllIIllIIIlllIllIIllI = this.worldObj.getLightBrightness(new BlockPos(this));
        this.currentFootSteps.bindTexture(EntityFootStepFX.field_110126_a);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        llllllllllllllIIllIIIlllIlllIlII.startDrawingQuads();
        llllllllllllllIIllIIIlllIlllIlII.func_178960_a(llllllllllllllIIllIIIlllIllIIllI, llllllllllllllIIllIIIlllIllIIllI, llllllllllllllIIllIIIlllIllIIllI, llllllllllllllIIllIIIlllIllIlIll);
        llllllllllllllIIllIIIlllIlllIlII.addVertexWithUV(llllllllllllllIIllIIIlllIllIlIIl - llllllllllllllIIllIIIlllIllIlIlI, llllllllllllllIIllIIIlllIllIlIII, llllllllllllllIIllIIIlllIllIIlll + llllllllllllllIIllIIIlllIllIlIlI, 0.0, 1.0);
        llllllllllllllIIllIIIlllIlllIlII.addVertexWithUV(llllllllllllllIIllIIIlllIllIlIIl + llllllllllllllIIllIIIlllIllIlIlI, llllllllllllllIIllIIIlllIllIlIII, llllllllllllllIIllIIIlllIllIIlll + llllllllllllllIIllIIIlllIllIlIlI, 1.0, 1.0);
        llllllllllllllIIllIIIlllIlllIlII.addVertexWithUV(llllllllllllllIIllIIIlllIllIlIIl + llllllllllllllIIllIIIlllIllIlIlI, llllllllllllllIIllIIIlllIllIlIII, llllllllllllllIIllIIIlllIllIIlll - llllllllllllllIIllIIIlllIllIlIlI, 1.0, 0.0);
        llllllllllllllIIllIIIlllIlllIlII.addVertexWithUV(llllllllllllllIIllIIIlllIllIlIIl - llllllllllllllIIllIIIlllIllIlIlI, llllllllllllllIIllIIIlllIllIlIII, llllllllllllllIIllIIIlllIllIIlll - llllllllllllllIIllIIIlllIllIlIlI, 0.0, 0.0);
        Tessellator.getInstance().draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    protected EntityFootStepFX(final TextureManager llllllllllllllIIllIIIllllIIIIlII, final World llllllllllllllIIllIIIllllIIIlIIl, final double llllllllllllllIIllIIIllllIIIlIII, final double llllllllllllllIIllIIIllllIIIIlll, final double llllllllllllllIIllIIIllllIIIIIII) {
        super(llllllllllllllIIllIIIllllIIIlIIl, llllllllllllllIIllIIIllllIIIlIII, llllllllllllllIIllIIIllllIIIIlll, llllllllllllllIIllIIIllllIIIIIII, 0.0, 0.0, 0.0);
        this.currentFootSteps = llllllllllllllIIllIIIllllIIIIlII;
        final double motionX = 0.0;
        this.motionZ = motionX;
        this.motionY = motionX;
        this.motionX = motionX;
        this.footstepMaxAge = 200;
    }
    
    static {
        __OBFID = "CL_00000908";
        field_110126_a = new ResourceLocation("textures/particle/footprint.png");
    }
    
    @Override
    public void onUpdate() {
        ++this.footstepAge;
        if (this.footstepAge == this.footstepMaxAge) {
            this.setDead();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002601";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIIllIllIIllIlllll, final World llllllllllllllIIIllIllIIllIllllI, final double llllllllllllllIIIllIllIIllIlIlIl, final double llllllllllllllIIIllIllIIllIlIlII, final double llllllllllllllIIIllIllIIllIlIIll, final double llllllllllllllIIIllIllIIllIllIlI, final double llllllllllllllIIIllIllIIllIllIIl, final double llllllllllllllIIIllIllIIllIllIII, final int... llllllllllllllIIIllIllIIllIlIlll) {
            return new EntityFootStepFX(Minecraft.getMinecraft().getTextureManager(), llllllllllllllIIIllIllIIllIllllI, llllllllllllllIIIllIllIIllIlIlIl, llllllllllllllIIIllIllIIllIlIlII, llllllllllllllIIIllIllIIllIlIIll);
        }
    }
}
