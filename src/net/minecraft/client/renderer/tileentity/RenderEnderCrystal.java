package net.minecraft.client.renderer.tileentity;

import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class RenderEnderCrystal extends Render
{
    private static final /* synthetic */ ResourceLocation enderCrystalTextures;
    private /* synthetic */ ModelBase field_76995_b;
    
    protected ResourceLocation func_180554_a(final EntityEnderCrystal llllllllllllllIIllIIIllIlIlIlIlI) {
        return RenderEnderCrystal.enderCrystalTextures;
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIIllIIIllIlIIlIlII, final double llllllllllllllIIllIIIllIlIIllIlI, final double llllllllllllllIIllIIIllIlIIllIIl, final double llllllllllllllIIllIIIllIlIIllIII, final float llllllllllllllIIllIIIllIlIIlIIII, final float llllllllllllllIIllIIIllIlIIIllll) {
        this.doRender((EntityEnderCrystal)llllllllllllllIIllIIIllIlIIlIlII, llllllllllllllIIllIIIllIlIIllIlI, llllllllllllllIIllIIIllIlIIllIIl, llllllllllllllIIllIIIllIlIIllIII, llllllllllllllIIllIIIllIlIIlIIII, llllllllllllllIIllIIIllIlIIIllll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIllIIIllIlIlIIlII) {
        return this.func_180554_a((EntityEnderCrystal)llllllllllllllIIllIIIllIlIlIIlII);
    }
    
    static {
        __OBFID = "CL_00000987";
        enderCrystalTextures = new ResourceLocation("textures/entity/endercrystal/endercrystal.png");
    }
    
    public RenderEnderCrystal(final RenderManager llllllllllllllIIllIIIllIllIIIlll) {
        super(llllllllllllllIIllIIIllIllIIIlll);
        this.field_76995_b = new ModelEnderCrystal(0.0f, true);
        this.shadowSize = 0.5f;
    }
    
    public void doRender(final EntityEnderCrystal llllllllllllllIIllIIIllIlIllllII, final double llllllllllllllIIllIIIllIlIllIIlI, final double llllllllllllllIIllIIIllIlIlllIlI, final double llllllllllllllIIllIIIllIlIllIIII, final float llllllllllllllIIllIIIllIlIlllIII, final float llllllllllllllIIllIIIllIlIlIlllI) {
        final float llllllllllllllIIllIIIllIlIllIllI = llllllllllllllIIllIIIllIlIllllII.innerRotation + llllllllllllllIIllIIIllIlIlIlllI;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIIllIIIllIlIllIIlI, (float)llllllllllllllIIllIIIllIlIlllIlI, (float)llllllllllllllIIllIIIllIlIllIIII);
        this.bindTexture(RenderEnderCrystal.enderCrystalTextures);
        float llllllllllllllIIllIIIllIlIllIlIl = MathHelper.sin(llllllllllllllIIllIIIllIlIllIllI * 0.2f) / 2.0f + 0.5f;
        llllllllllllllIIllIIIllIlIllIlIl += llllllllllllllIIllIIIllIlIllIlIl * llllllllllllllIIllIIIllIlIllIlIl;
        this.field_76995_b.render(llllllllllllllIIllIIIllIlIllllII, 0.0f, llllllllllllllIIllIIIllIlIllIllI * 3.0f, llllllllllllllIIllIIIllIlIllIlIl * 0.2f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIIllIIIllIlIllllII, llllllllllllllIIllIIIllIlIllIIlI, llllllllllllllIIllIIIllIlIlllIlI, llllllllllllllIIllIIIllIlIllIIII, llllllllllllllIIllIIIllIlIlllIII, llllllllllllllIIllIIIllIlIlIlllI);
    }
}
