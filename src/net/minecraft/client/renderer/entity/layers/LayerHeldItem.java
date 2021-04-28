package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.block.model.*;

public class LayerHeldItem implements LayerRenderer
{
    private final /* synthetic */ RendererLivingEntity field_177206_a;
    
    static {
        __OBFID = "CL_00002416";
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllllIlIlllIlIlllIIll, final float llllllllllllllllIlIlllIllIIIIIII, final float llllllllllllllllIlIlllIlIlllllll, final float llllllllllllllllIlIlllIlIllllllI, final float llllllllllllllllIlIlllIlIlllllIl, final float llllllllllllllllIlIlllIlIlllllII, final float llllllllllllllllIlIlllIlIllllIll, final float llllllllllllllllIlIlllIlIllllIlI) {
        ItemStack llllllllllllllllIlIlllIlIllllIIl = llllllllllllllllIlIlllIlIlllIIll.getHeldItem();
        if (llllllllllllllllIlIlllIlIllllIIl != null) {
            GlStateManager.pushMatrix();
            if (this.field_177206_a.getMainModel().isChild) {
                final float llllllllllllllllIlIlllIlIllllIII = 0.5f;
                GlStateManager.translate(0.0f, 0.625f, 0.0f);
                GlStateManager.rotate(-20.0f, -1.0f, 0.0f, 0.0f);
                GlStateManager.scale(llllllllllllllllIlIlllIlIllllIII, llllllllllllllllIlIlllIlIllllIII, llllllllllllllllIlIlllIlIllllIII);
            }
            ((ModelBiped)this.field_177206_a.getMainModel()).postRenderHiddenArm(0.0625f);
            GlStateManager.translate(-0.0625f, 0.4375f, 0.0625f);
            if (llllllllllllllllIlIlllIlIlllIIll instanceof EntityPlayer && ((EntityPlayer)llllllllllllllllIlIlllIlIlllIIll).fishEntity != null) {
                llllllllllllllllIlIlllIlIllllIIl = new ItemStack(Items.fishing_rod, 0);
            }
            final Item llllllllllllllllIlIlllIlIlllIlll = llllllllllllllllIlIlllIlIllllIIl.getItem();
            final Minecraft llllllllllllllllIlIlllIlIlllIllI = Minecraft.getMinecraft();
            if (llllllllllllllllIlIlllIlIlllIlll instanceof ItemBlock && Block.getBlockFromItem(llllllllllllllllIlIlllIlIlllIlll).getRenderType() == 2) {
                GlStateManager.translate(0.0f, 0.1875f, -0.3125f);
                GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
                final float llllllllllllllllIlIlllIlIlllIlIl = 0.375f;
                GlStateManager.scale(-llllllllllllllllIlIlllIlIlllIlIl, -llllllllllllllllIlIlllIlIlllIlIl, llllllllllllllllIlIlllIlIlllIlIl);
            }
            llllllllllllllllIlIlllIlIlllIllI.getItemRenderer().renderItem(llllllllllllllllIlIlllIlIlllIIll, llllllllllllllllIlIlllIlIllllIIl, ItemCameraTransforms.TransformType.THIRD_PERSON);
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerHeldItem(final RendererLivingEntity llllllllllllllllIlIlllIllIIIlIll) {
        this.field_177206_a = llllllllllllllllIlIlllIllIIIlIll;
    }
}
