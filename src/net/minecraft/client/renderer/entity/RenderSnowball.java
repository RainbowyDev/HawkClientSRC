package net.minecraft.client.renderer.entity;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class RenderSnowball extends Render
{
    protected final /* synthetic */ Item field_177084_a;
    private final /* synthetic */ RenderItem field_177083_e;
    
    public RenderSnowball(final RenderManager llllllllllllllIIIIIlllIllIlIlllI, final Item llllllllllllllIIIIIlllIllIlIlIIl, final RenderItem llllllllllllllIIIIIlllIllIlIllII) {
        super(llllllllllllllIIIIIlllIllIlIlllI);
        this.field_177084_a = llllllllllllllIIIIIlllIllIlIlIIl;
        this.field_177083_e = llllllllllllllIIIIIlllIllIlIllII;
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIIIIIlllIllIIlllll, final double llllllllllllllIIIIIlllIllIIlIlll, final double llllllllllllllIIIIIlllIllIIlllIl, final double llllllllllllllIIIIIlllIllIIlllII, final float llllllllllllllIIIIIlllIllIIllIll, final float llllllllllllllIIIIIlllIllIIlIIll) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIIIIIlllIllIIlIlll, (float)llllllllllllllIIIIIlllIllIIlllIl, (float)llllllllllllllIIIIIlllIllIIlllII);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        this.bindTexture(TextureMap.locationBlocksTexture);
        this.field_177083_e.func_175043_b(this.func_177082_d(llllllllllllllIIIIIlllIllIIlllll));
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIIIIIlllIllIIlllll, llllllllllllllIIIIIlllIllIIlIlll, llllllllllllllIIIIIlllIllIIlllIl, llllllllllllllIIIIIlllIllIIlllII, llllllllllllllIIIIIlllIllIIllIll, llllllllllllllIIIIIlllIllIIlIIll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIIIIlllIllIIIllIl) {
        return TextureMap.locationBlocksTexture;
    }
    
    public ItemStack func_177082_d(final Entity llllllllllllllIIIIIlllIllIIlIIII) {
        return new ItemStack(this.field_177084_a, 1, 0);
    }
    
    static {
        __OBFID = "CL_00001008";
    }
}
