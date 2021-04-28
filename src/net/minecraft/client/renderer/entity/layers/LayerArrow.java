package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.projectile.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;

public class LayerArrow implements LayerRenderer
{
    private final /* synthetic */ RendererLivingEntity field_177168_a;
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllllIIlIIllIlIIIlIIII, final float lllllllllllllllIIlIIllIlIIlIlIII, final float lllllllllllllllIIlIIllIlIIlIIlll, final float lllllllllllllllIIlIIllIlIIlIIllI, final float lllllllllllllllIIlIIllIlIIlIIlIl, final float lllllllllllllllIIlIIllIlIIlIIlII, final float lllllllllllllllIIlIIllIlIIlIIIll, final float lllllllllllllllIIlIIllIlIIlIIIlI) {
        final int lllllllllllllllIIlIIllIlIIlIIIIl = lllllllllllllllIIlIIllIlIIIlIIII.getArrowCountInEntity();
        if (lllllllllllllllIIlIIllIlIIlIIIIl > 0) {
            final EntityArrow lllllllllllllllIIlIIllIlIIlIIIII = new EntityArrow(lllllllllllllllIIlIIllIlIIIlIIII.worldObj, lllllllllllllllIIlIIllIlIIIlIIII.posX, lllllllllllllllIIlIIllIlIIIlIIII.posY, lllllllllllllllIIlIIllIlIIIlIIII.posZ);
            final Random lllllllllllllllIIlIIllIlIIIlllll = new Random(lllllllllllllllIIlIIllIlIIIlIIII.getEntityId());
            RenderHelper.disableStandardItemLighting();
            for (int lllllllllllllllIIlIIllIlIIIllllI = 0; lllllllllllllllIIlIIllIlIIIllllI < lllllllllllllllIIlIIllIlIIlIIIIl; ++lllllllllllllllIIlIIllIlIIIllllI) {
                GlStateManager.pushMatrix();
                final ModelRenderer lllllllllllllllIIlIIllIlIIIlllIl = this.field_177168_a.getMainModel().getRandomModelBox(lllllllllllllllIIlIIllIlIIIlllll);
                final ModelBox lllllllllllllllIIlIIllIlIIIlllII = lllllllllllllllIIlIIllIlIIIlllIl.cubeList.get(lllllllllllllllIIlIIllIlIIIlllll.nextInt(lllllllllllllllIIlIIllIlIIIlllIl.cubeList.size()));
                lllllllllllllllIIlIIllIlIIIlllIl.postRender(0.0625f);
                float lllllllllllllllIIlIIllIlIIIllIll = lllllllllllllllIIlIIllIlIIIlllll.nextFloat();
                float lllllllllllllllIIlIIllIlIIIllIlI = lllllllllllllllIIlIIllIlIIIlllll.nextFloat();
                float lllllllllllllllIIlIIllIlIIIllIIl = lllllllllllllllIIlIIllIlIIIlllll.nextFloat();
                final float lllllllllllllllIIlIIllIlIIIllIII = (lllllllllllllllIIlIIllIlIIIlllII.posX1 + (lllllllllllllllIIlIIllIlIIIlllII.posX2 - lllllllllllllllIIlIIllIlIIIlllII.posX1) * lllllllllllllllIIlIIllIlIIIllIll) / 16.0f;
                final float lllllllllllllllIIlIIllIlIIIlIlll = (lllllllllllllllIIlIIllIlIIIlllII.posY1 + (lllllllllllllllIIlIIllIlIIIlllII.posY2 - lllllllllllllllIIlIIllIlIIIlllII.posY1) * lllllllllllllllIIlIIllIlIIIllIlI) / 16.0f;
                final float lllllllllllllllIIlIIllIlIIIlIllI = (lllllllllllllllIIlIIllIlIIIlllII.posZ1 + (lllllllllllllllIIlIIllIlIIIlllII.posZ2 - lllllllllllllllIIlIIllIlIIIlllII.posZ1) * lllllllllllllllIIlIIllIlIIIllIIl) / 16.0f;
                GlStateManager.translate(lllllllllllllllIIlIIllIlIIIllIII, lllllllllllllllIIlIIllIlIIIlIlll, lllllllllllllllIIlIIllIlIIIlIllI);
                lllllllllllllllIIlIIllIlIIIllIll = lllllllllllllllIIlIIllIlIIIllIll * 2.0f - 1.0f;
                lllllllllllllllIIlIIllIlIIIllIlI = lllllllllllllllIIlIIllIlIIIllIlI * 2.0f - 1.0f;
                lllllllllllllllIIlIIllIlIIIllIIl = lllllllllllllllIIlIIllIlIIIllIIl * 2.0f - 1.0f;
                lllllllllllllllIIlIIllIlIIIllIll *= -1.0f;
                lllllllllllllllIIlIIllIlIIIllIlI *= -1.0f;
                lllllllllllllllIIlIIllIlIIIllIIl *= -1.0f;
                final float lllllllllllllllIIlIIllIlIIIlIlIl = MathHelper.sqrt_float(lllllllllllllllIIlIIllIlIIIllIll * lllllllllllllllIIlIIllIlIIIllIll + lllllllllllllllIIlIIllIlIIIllIIl * lllllllllllllllIIlIIllIlIIIllIIl);
                final EntityArrow entityArrow = lllllllllllllllIIlIIllIlIIlIIIII;
                final EntityArrow entityArrow2 = lllllllllllllllIIlIIllIlIIlIIIII;
                final float n = (float)(Math.atan2(lllllllllllllllIIlIIllIlIIIllIll, lllllllllllllllIIlIIllIlIIIllIIl) * 180.0 / 3.141592653589793);
                entityArrow2.rotationYaw = n;
                entityArrow.prevRotationYaw = n;
                final EntityArrow entityArrow3 = lllllllllllllllIIlIIllIlIIlIIIII;
                final EntityArrow entityArrow4 = lllllllllllllllIIlIIllIlIIlIIIII;
                final float n2 = (float)(Math.atan2(lllllllllllllllIIlIIllIlIIIllIlI, lllllllllllllllIIlIIllIlIIIlIlIl) * 180.0 / 3.141592653589793);
                entityArrow4.rotationPitch = n2;
                entityArrow3.prevRotationPitch = n2;
                final double lllllllllllllllIIlIIllIlIIIlIlII = 0.0;
                final double lllllllllllllllIIlIIllIlIIIlIIll = 0.0;
                final double lllllllllllllllIIlIIllIlIIIlIIlI = 0.0;
                this.field_177168_a.func_177068_d().renderEntityWithPosYaw(lllllllllllllllIIlIIllIlIIlIIIII, lllllllllllllllIIlIIllIlIIIlIlII, lllllllllllllllIIlIIllIlIIIlIIll, lllllllllllllllIIlIIllIlIIIlIIlI, 0.0f, lllllllllllllllIIlIIllIlIIlIIllI);
                GlStateManager.popMatrix();
            }
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    static {
        __OBFID = "CL_00002426";
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerArrow(final RendererLivingEntity lllllllllllllllIIlIIllIlIlIIIIII) {
        this.field_177168_a = lllllllllllllllIIlIIllIlIlIIIIII;
    }
}
