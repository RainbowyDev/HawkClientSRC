package net.minecraft.client.particle;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.client.*;

public class EntityLargeExplodeFX extends EntityFX
{
    private /* synthetic */ TextureManager theRenderEngine;
    private /* synthetic */ int field_70584_aq;
    private static final /* synthetic */ ResourceLocation field_110127_a;
    private /* synthetic */ float field_70582_as;
    private /* synthetic */ int field_70581_a;
    
    @Override
    public void func_180434_a(final WorldRenderer lllllllllllllllllllIIIIIlIlIlIll, final Entity lllllllllllllllllllIIIIIlIllllII, final float lllllllllllllllllllIIIIIlIlllIll, final float lllllllllllllllllllIIIIIlIlIlIIl, final float lllllllllllllllllllIIIIIlIlIlIII, final float lllllllllllllllllllIIIIIlIlIIlll, final float lllllllllllllllllllIIIIIlIllIlll, final float lllllllllllllllllllIIIIIlIllIllI) {
        final int lllllllllllllllllllIIIIIlIllIlIl = (int)((this.field_70581_a + lllllllllllllllllllIIIIIlIlllIll) * 15.0f / this.field_70584_aq);
        if (lllllllllllllllllllIIIIIlIllIlIl <= 15) {
            this.theRenderEngine.bindTexture(EntityLargeExplodeFX.field_110127_a);
            final float lllllllllllllllllllIIIIIlIllIlII = lllllllllllllllllllIIIIIlIllIlIl % 4 / 4.0f;
            final float lllllllllllllllllllIIIIIlIllIIll = lllllllllllllllllllIIIIIlIllIlII + 0.24975f;
            final float lllllllllllllllllllIIIIIlIllIIlI = lllllllllllllllllllIIIIIlIllIlIl / 4 / 4.0f;
            final float lllllllllllllllllllIIIIIlIllIIIl = lllllllllllllllllllIIIIIlIllIIlI + 0.24975f;
            final float lllllllllllllllllllIIIIIlIllIIII = 2.0f * this.field_70582_as;
            final float lllllllllllllllllllIIIIIlIlIllll = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllllllllllIIIIIlIlllIll - EntityLargeExplodeFX.interpPosX);
            final float lllllllllllllllllllIIIIIlIlIlllI = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllllllllllIIIIIlIlllIll - EntityLargeExplodeFX.interpPosY);
            final float lllllllllllllllllllIIIIIlIlIllIl = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllllllllllIIIIIlIlllIll - EntityLargeExplodeFX.interpPosZ);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            RenderHelper.disableStandardItemLighting();
            lllllllllllllllllllIIIIIlIlIlIll.startDrawingQuads();
            lllllllllllllllllllIIIIIlIlIlIll.func_178960_a(this.particleRed, this.particleGreen, this.particleBlue, 1.0f);
            lllllllllllllllllllIIIIIlIlIlIll.func_178980_d(0.0f, 1.0f, 0.0f);
            lllllllllllllllllllIIIIIlIlIlIll.func_178963_b(240);
            lllllllllllllllllllIIIIIlIlIlIll.addVertexWithUV(lllllllllllllllllllIIIIIlIlIllll - lllllllllllllllllllIIIIIlIlIlIIl * lllllllllllllllllllIIIIIlIllIIII - lllllllllllllllllllIIIIIlIllIlll * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIlIlllI - lllllllllllllllllllIIIIIlIlIlIII * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIlIllIl - lllllllllllllllllllIIIIIlIlIIlll * lllllllllllllllllllIIIIIlIllIIII - lllllllllllllllllllIIIIIlIllIllI * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIllIIll, lllllllllllllllllllIIIIIlIllIIIl);
            lllllllllllllllllllIIIIIlIlIlIll.addVertexWithUV(lllllllllllllllllllIIIIIlIlIllll - lllllllllllllllllllIIIIIlIlIlIIl * lllllllllllllllllllIIIIIlIllIIII + lllllllllllllllllllIIIIIlIllIlll * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIlIlllI + lllllllllllllllllllIIIIIlIlIlIII * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIlIllIl - lllllllllllllllllllIIIIIlIlIIlll * lllllllllllllllllllIIIIIlIllIIII + lllllllllllllllllllIIIIIlIllIllI * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIllIIll, lllllllllllllllllllIIIIIlIllIIlI);
            lllllllllllllllllllIIIIIlIlIlIll.addVertexWithUV(lllllllllllllllllllIIIIIlIlIllll + lllllllllllllllllllIIIIIlIlIlIIl * lllllllllllllllllllIIIIIlIllIIII + lllllllllllllllllllIIIIIlIllIlll * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIlIlllI + lllllllllllllllllllIIIIIlIlIlIII * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIlIllIl + lllllllllllllllllllIIIIIlIlIIlll * lllllllllllllllllllIIIIIlIllIIII + lllllllllllllllllllIIIIIlIllIllI * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIIlI);
            lllllllllllllllllllIIIIIlIlIlIll.addVertexWithUV(lllllllllllllllllllIIIIIlIlIllll + lllllllllllllllllllIIIIIlIlIlIIl * lllllllllllllllllllIIIIIlIllIIII - lllllllllllllllllllIIIIIlIllIlll * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIlIlllI - lllllllllllllllllllIIIIIlIlIlIII * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIlIllIl + lllllllllllllllllllIIIIIlIlIIlll * lllllllllllllllllllIIIIIlIllIIII - lllllllllllllllllllIIIIIlIllIllI * lllllllllllllllllllIIIIIlIllIIII, lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIIIl);
            Tessellator.getInstance().draw();
            GlStateManager.doPolygonOffset(0.0f, 0.0f);
            GlStateManager.enableLighting();
        }
    }
    
    protected EntityLargeExplodeFX(final TextureManager lllllllllllllllllllIIIIIllIllllI, final World lllllllllllllllllllIIIIIllIlllIl, final double lllllllllllllllllllIIIIIllIlllII, final double lllllllllllllllllllIIIIIllIlIIlI, final double lllllllllllllllllllIIIIIllIllIlI, final double lllllllllllllllllllIIIIIllIlIIII, final double lllllllllllllllllllIIIIIllIllIII, final double lllllllllllllllllllIIIIIllIlIlll) {
        super(lllllllllllllllllllIIIIIllIlllIl, lllllllllllllllllllIIIIIllIlllII, lllllllllllllllllllIIIIIllIlIIlI, lllllllllllllllllllIIIIIllIllIlI, 0.0, 0.0, 0.0);
        this.theRenderEngine = lllllllllllllllllllIIIIIllIllllI;
        this.field_70584_aq = 6 + this.rand.nextInt(4);
        final float particleRed = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.field_70582_as = 1.0f - (float)lllllllllllllllllllIIIIIllIlIIII * 0.5f;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.field_70581_a;
        if (this.field_70581_a == this.field_70584_aq) {
            this.setDead();
        }
    }
    
    static {
        __OBFID = "CL_00000910";
        field_110127_a = new ResourceLocation("textures/entity/explosion.png");
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllllllllIIIIIlIIllIlI) {
        return 61680;
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002598";
        }
        
        @Override
        public EntityFX func_178902_a(final int lIlllIllllllIl, final World lIlllIllllllII, final double lIlllIllllIIll, final double lIlllIllllIIlI, final double lIlllIllllIIIl, final double lIlllIlllllIII, final double lIlllIlllIllll, final double lIlllIlllIlllI, final int... lIlllIllllIlIl) {
            return new EntityLargeExplodeFX(Minecraft.getMinecraft().getTextureManager(), lIlllIllllllII, lIlllIllllIIll, lIlllIllllIIlI, lIlllIllllIIIl, lIlllIlllllIII, lIlllIlllIllll, lIlllIlllIlllI);
        }
    }
}
