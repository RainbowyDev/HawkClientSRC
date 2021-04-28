package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class LayerHeldItemWitch implements LayerRenderer
{
    private final /* synthetic */ RenderWitch field_177144_a;
    
    static {
        __OBFID = "CL_00002407";
    }
    
    public void func_177143_a(final EntityWitch lllllllllllllllllIIlllIIlIllIIIl, final float lllllllllllllllllIIlllIIllIIIIIl, final float lllllllllllllllllIIlllIIllIIIIII, final float lllllllllllllllllIIlllIIlIllllll, final float lllllllllllllllllIIlllIIlIlllllI, final float lllllllllllllllllIIlllIIlIllllIl, final float lllllllllllllllllIIlllIIlIllllII, final float lllllllllllllllllIIlllIIlIlllIll) {
        final ItemStack lllllllllllllllllIIlllIIlIlllIlI = lllllllllllllllllIIlllIIlIllIIIl.getHeldItem();
        if (lllllllllllllllllIIlllIIlIlllIlI != null) {
            GlStateManager.color(1.0f, 1.0f, 1.0f);
            GlStateManager.pushMatrix();
            if (this.field_177144_a.getMainModel().isChild) {
                GlStateManager.translate(0.0f, 0.625f, 0.0f);
                GlStateManager.rotate(-20.0f, -1.0f, 0.0f, 0.0f);
                final float lllllllllllllllllIIlllIIlIlllIIl = 0.5f;
                GlStateManager.scale(lllllllllllllllllIIlllIIlIlllIIl, lllllllllllllllllIIlllIIlIlllIIl, lllllllllllllllllIIlllIIlIlllIIl);
            }
            ((ModelWitch)this.field_177144_a.getMainModel()).villagerNose.postRender(0.0625f);
            GlStateManager.translate(-0.0625f, 0.53125f, 0.21875f);
            final Item lllllllllllllllllIIlllIIlIlllIII = lllllllllllllllllIIlllIIlIlllIlI.getItem();
            final Minecraft lllllllllllllllllIIlllIIlIllIlll = Minecraft.getMinecraft();
            if (lllllllllllllllllIIlllIIlIlllIII instanceof ItemBlock && lllllllllllllllllIIlllIIlIllIlll.getBlockRendererDispatcher().func_175021_a(Block.getBlockFromItem(lllllllllllllllllIIlllIIlIlllIII), lllllllllllllllllIIlllIIlIlllIlI.getMetadata())) {
                GlStateManager.translate(0.0f, 0.1875f, -0.3125f);
                GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
                final float lllllllllllllllllIIlllIIlIllIllI = 0.375f;
                GlStateManager.scale(lllllllllllllllllIIlllIIlIllIllI, -lllllllllllllllllIIlllIIlIllIllI, lllllllllllllllllIIlllIIlIllIllI);
            }
            else if (lllllllllllllllllIIlllIIlIlllIII == Items.bow) {
                GlStateManager.translate(0.0f, 0.125f, 0.3125f);
                GlStateManager.rotate(-20.0f, 0.0f, 1.0f, 0.0f);
                final float lllllllllllllllllIIlllIIlIllIlIl = 0.625f;
                GlStateManager.scale(lllllllllllllllllIIlllIIlIllIlIl, -lllllllllllllllllIIlllIIlIllIlIl, lllllllllllllllllIIlllIIlIllIlIl);
                GlStateManager.rotate(-100.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else if (lllllllllllllllllIIlllIIlIlllIII.isFull3D()) {
                if (lllllllllllllllllIIlllIIlIlllIII.shouldRotateAroundWhenRendering()) {
                    GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.translate(0.0f, -0.125f, 0.0f);
                }
                this.field_177144_a.func_82422_c();
                final float lllllllllllllllllIIlllIIlIllIlII = 0.625f;
                GlStateManager.scale(lllllllllllllllllIIlllIIlIllIlII, -lllllllllllllllllIIlllIIlIllIlII, lllllllllllllllllIIlllIIlIllIlII);
                GlStateManager.rotate(-100.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                GlStateManager.translate(0.25f, 0.1875f, -0.1875f);
                final float lllllllllllllllllIIlllIIlIllIIll = 0.375f;
                GlStateManager.scale(lllllllllllllllllIIlllIIlIllIIll, lllllllllllllllllIIlllIIlIllIIll, lllllllllllllllllIIlllIIlIllIIll);
                GlStateManager.rotate(60.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(20.0f, 0.0f, 0.0f, 1.0f);
            }
            GlStateManager.rotate(-15.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(40.0f, 0.0f, 0.0f, 1.0f);
            lllllllllllllllllIIlllIIlIllIlll.getItemRenderer().renderItem(lllllllllllllllllIIlllIIlIllIIIl, lllllllllllllllllIIlllIIlIlllIlI, ItemCameraTransforms.TransformType.THIRD_PERSON);
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllllllIIlllIIlIIllIII, final float lllllllllllllllllIIlllIIlIIlIlll, final float lllllllllllllllllIIlllIIlIIlllll, final float lllllllllllllllllIIlllIIlIIllllI, final float lllllllllllllllllIIlllIIlIIlIlII, final float lllllllllllllllllIIlllIIlIIlllII, final float lllllllllllllllllIIlllIIlIIllIll, final float lllllllllllllllllIIlllIIlIIlIIIl) {
        this.func_177143_a((EntityWitch)lllllllllllllllllIIlllIIlIIllIII, lllllllllllllllllIIlllIIlIIlIlll, lllllllllllllllllIIlllIIlIIlllll, lllllllllllllllllIIlllIIlIIllllI, lllllllllllllllllIIlllIIlIIlIlII, lllllllllllllllllIIlllIIlIIlllII, lllllllllllllllllIIlllIIlIIllIll, lllllllllllllllllIIlllIIlIIlIIIl);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerHeldItemWitch(final RenderWitch lllllllllllllllllIIlllIIllIIlIlI) {
        this.field_177144_a = lllllllllllllllllIIlllIIllIIlIlI;
    }
}
