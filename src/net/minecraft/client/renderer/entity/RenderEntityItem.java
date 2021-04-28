package net.minecraft.client.renderer.entity;

import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;

public class RenderEntityItem extends Render
{
    private final /* synthetic */ RenderItem field_177080_a;
    private /* synthetic */ Random field_177079_e;
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIllllIlIlIlIllII) {
        return this.func_177076_a((EntityItem)lllllllllllllllIIllllIlIlIlIllII);
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIIllllIlIlIlIIIIl, final double lllllllllllllllIIllllIlIlIlIIIII, final double lllllllllllllllIIllllIlIlIIllIII, final double lllllllllllllllIIllllIlIlIIlIlll, final float lllllllllllllllIIllllIlIlIIlIllI, final float lllllllllllllllIIllllIlIlIIlIlIl) {
        this.func_177075_a((EntityItem)lllllllllllllllIIllllIlIlIlIIIIl, lllllllllllllllIIllllIlIlIlIIIII, lllllllllllllllIIllllIlIlIIllIII, lllllllllllllllIIllllIlIlIIlIlll, lllllllllllllllIIllllIlIlIIlIllI, lllllllllllllllIIllllIlIlIIlIlIl);
    }
    
    public void func_177075_a(final EntityItem lllllllllllllllIIllllIlIlIllllll, final double lllllllllllllllIIllllIlIllIIllIl, final double lllllllllllllllIIllllIlIlIllllIl, final double lllllllllllllllIIllllIlIlIllllII, final float lllllllllllllllIIllllIlIllIIlIlI, final float lllllllllllllllIIllllIlIlIlllIlI) {
        final ItemStack lllllllllllllllIIllllIlIllIIlIII = lllllllllllllllIIllllIlIlIllllll.getEntityItem();
        this.field_177079_e.setSeed(187L);
        boolean lllllllllllllllIIllllIlIllIIIlll = false;
        if (this.bindEntityTexture(lllllllllllllllIIllllIlIlIllllll)) {
            this.renderManager.renderEngine.getTexture(this.func_177076_a(lllllllllllllllIIllllIlIlIllllll)).func_174936_b(false, false);
            lllllllllllllllIIllllIlIllIIIlll = true;
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.pushMatrix();
        final IBakedModel lllllllllllllllIIllllIlIllIIIllI = this.field_177080_a.getItemModelMesher().getItemModel(lllllllllllllllIIllllIlIllIIlIII);
        for (int lllllllllllllllIIllllIlIllIIIlIl = this.func_177077_a(lllllllllllllllIIllllIlIlIllllll, lllllllllllllllIIllllIlIllIIllIl, lllllllllllllllIIllllIlIlIllllIl, lllllllllllllllIIllllIlIlIllllII, lllllllllllllllIIllllIlIlIlllIlI, lllllllllllllllIIllllIlIllIIIllI), lllllllllllllllIIllllIlIllIIIlII = 0; lllllllllllllllIIllllIlIllIIIlII < lllllllllllllllIIllllIlIllIIIlIl; ++lllllllllllllllIIllllIlIllIIIlII) {
            if (lllllllllllllllIIllllIlIllIIIllI.isAmbientOcclusionEnabled()) {
                GlStateManager.pushMatrix();
                if (lllllllllllllllIIllllIlIllIIIlII > 0) {
                    final float lllllllllllllllIIllllIlIllIIIIll = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    final float lllllllllllllllIIllllIlIllIIIIlI = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    final float lllllllllllllllIIllllIlIllIIIIIl = (this.field_177079_e.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    GlStateManager.translate(lllllllllllllllIIllllIlIllIIIIll, lllllllllllllllIIllllIlIllIIIIlI, lllllllllllllllIIllllIlIllIIIIIl);
                }
                GlStateManager.scale(0.5f, 0.5f, 0.5f);
                this.field_177080_a.func_180454_a(lllllllllllllllIIllllIlIllIIlIII, lllllllllllllllIIllllIlIllIIIllI);
                GlStateManager.popMatrix();
            }
            else {
                this.field_177080_a.func_180454_a(lllllllllllllllIIllllIlIllIIlIII, lllllllllllllllIIllllIlIllIIIllI);
                GlStateManager.translate(0.0f, 0.0f, 0.046875f);
            }
        }
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        this.bindEntityTexture(lllllllllllllllIIllllIlIlIllllll);
        if (lllllllllllllllIIllllIlIllIIIlll) {
            this.renderManager.renderEngine.getTexture(this.func_177076_a(lllllllllllllllIIllllIlIlIllllll)).func_174935_a();
        }
        super.doRender(lllllllllllllllIIllllIlIlIllllll, lllllllllllllllIIllllIlIllIIllIl, lllllllllllllllIIllllIlIlIllllIl, lllllllllllllllIIllllIlIlIllllII, lllllllllllllllIIllllIlIllIIlIlI, lllllllllllllllIIllllIlIlIlllIlI);
    }
    
    public RenderEntityItem(final RenderManager lllllllllllllllIIllllIllIIIllIll, final RenderItem lllllllllllllllIIllllIllIIIllIlI) {
        super(lllllllllllllllIIllllIllIIIllIll);
        this.field_177079_e = new Random();
        this.field_177080_a = lllllllllllllllIIllllIllIIIllIlI;
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }
    
    private int func_177078_a(final ItemStack lllllllllllllllIIllllIlIlllIIIII) {
        byte lllllllllllllllIIllllIlIlllIIIIl = 1;
        if (lllllllllllllllIIllllIlIlllIIIII.stackSize > 48) {
            lllllllllllllllIIllllIlIlllIIIIl = 5;
        }
        else if (lllllllllllllllIIllllIlIlllIIIII.stackSize > 32) {
            lllllllllllllllIIllllIlIlllIIIIl = 4;
        }
        else if (lllllllllllllllIIllllIlIlllIIIII.stackSize > 16) {
            lllllllllllllllIIllllIlIlllIIIIl = 3;
        }
        else if (lllllllllllllllIIllllIlIlllIIIII.stackSize > 1) {
            lllllllllllllllIIllllIlIlllIIIIl = 2;
        }
        return lllllllllllllllIIllllIlIlllIIIIl;
    }
    
    private int func_177077_a(final EntityItem lllllllllllllllIIllllIllIIIIIlIl, final double lllllllllllllllIIllllIllIIIIIlII, final double lllllllllllllllIIllllIllIIIIIIll, final double lllllllllllllllIIllllIlIllllIIIl, final float lllllllllllllllIIllllIlIllllIIII, final IBakedModel lllllllllllllllIIllllIllIIIIIIII) {
        final ItemStack lllllllllllllllIIllllIlIllllllll = lllllllllllllllIIllllIllIIIIIlIl.getEntityItem();
        final Item lllllllllllllllIIllllIlIlllllllI = lllllllllllllllIIllllIlIllllllll.getItem();
        if (lllllllllllllllIIllllIlIlllllllI == null) {
            return 0;
        }
        final boolean lllllllllllllllIIllllIlIllllllIl = lllllllllllllllIIllllIllIIIIIIII.isAmbientOcclusionEnabled();
        final int lllllllllllllllIIllllIlIllllllII = this.func_177078_a(lllllllllllllllIIllllIlIllllllll);
        final float lllllllllllllllIIllllIlIlllllIll = 0.25f;
        final float lllllllllllllllIIllllIlIlllllIlI = MathHelper.sin((lllllllllllllllIIllllIllIIIIIlIl.func_174872_o() + lllllllllllllllIIllllIlIllllIIII) / 10.0f + lllllllllllllllIIllllIllIIIIIlIl.hoverStart) * 0.1f + 0.1f;
        GlStateManager.translate((float)lllllllllllllllIIllllIllIIIIIlII, (float)lllllllllllllllIIllllIllIIIIIIll + lllllllllllllllIIllllIlIlllllIlI + 0.25f, (float)lllllllllllllllIIllllIlIllllIIIl);
        if (lllllllllllllllIIllllIlIllllllIl || (this.renderManager.options != null && this.renderManager.options.fancyGraphics)) {
            final float lllllllllllllllIIllllIlIlllllIIl = ((lllllllllllllllIIllllIllIIIIIlIl.func_174872_o() + lllllllllllllllIIllllIlIllllIIII) / 20.0f + lllllllllllllllIIllllIllIIIIIlIl.hoverStart) * 57.295776f;
            GlStateManager.rotate(lllllllllllllllIIllllIlIlllllIIl, 0.0f, 1.0f, 0.0f);
        }
        if (!lllllllllllllllIIllllIlIllllllIl) {
            final float lllllllllllllllIIllllIlIlllllIII = -0.0f * (lllllllllllllllIIllllIlIllllllII - 1) * 0.5f;
            final float lllllllllllllllIIllllIlIllllIlll = -0.0f * (lllllllllllllllIIllllIlIllllllII - 1) * 0.5f;
            final float lllllllllllllllIIllllIlIllllIllI = -0.046875f * (lllllllllllllllIIllllIlIllllllII - 1) * 0.5f;
            GlStateManager.translate(lllllllllllllllIIllllIlIlllllIII, lllllllllllllllIIllllIlIllllIlll, lllllllllllllllIIllllIlIllllIllI);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        return lllllllllllllllIIllllIlIllllllII;
    }
    
    protected ResourceLocation func_177076_a(final EntityItem lllllllllllllllIIllllIlIlIllIIII) {
        return TextureMap.locationBlocksTexture;
    }
    
    static {
        __OBFID = "CL_00002442";
    }
}
