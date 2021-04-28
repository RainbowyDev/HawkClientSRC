package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.passive.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerWolfCollar implements LayerRenderer
{
    private final /* synthetic */ RenderWolf field_177146_b;
    private static final /* synthetic */ ResourceLocation field_177147_a;
    
    static {
        __OBFID = "CL_00002405";
        field_177147_a = new ResourceLocation("textures/entity/wolf/wolf_collar.png");
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lIlIlIlllIlIIll, final float lIlIlIlllIllIll, final float lIlIlIlllIlIIIl, final float lIlIlIlllIlIIII, final float lIlIlIlllIIllll, final float lIlIlIlllIIlllI, final float lIlIlIlllIlIllI, final float lIlIlIlllIlIlIl) {
        this.func_177145_a((EntityWolf)lIlIlIlllIlIIll, lIlIlIlllIllIll, lIlIlIlllIlIIIl, lIlIlIlllIlIIII, lIlIlIlllIIllll, lIlIlIlllIIlllI, lIlIlIlllIlIllI, lIlIlIlllIlIlIl);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    public void func_177145_a(final EntityWolf lIlIlIlllllIIII, final float lIlIlIllllllIlI, final float lIlIlIllllIlllI, final float lIlIlIllllllIII, final float lIlIlIllllIllIl, final float lIlIlIllllIllII, final float lIlIlIllllIlIll, final float lIlIlIlllllIlII) {
        if (lIlIlIlllllIIII.isTamed() && !lIlIlIlllllIIII.isInvisible()) {
            this.field_177146_b.bindTexture(LayerWolfCollar.field_177147_a);
            final EnumDyeColor lIlIlIlllllIIll = EnumDyeColor.func_176764_b(lIlIlIlllllIIII.func_175546_cu().func_176765_a());
            float[] lIlIlIlllllIIlI = EntitySheep.func_175513_a(lIlIlIlllllIIll);
            if (Config.isCustomColors()) {
                lIlIlIlllllIIlI = CustomColors.getWolfCollarColors(lIlIlIlllllIIll, lIlIlIlllllIIlI);
            }
            GlStateManager.color(lIlIlIlllllIIlI[0], lIlIlIlllllIIlI[1], lIlIlIlllllIIlI[2]);
            this.field_177146_b.getMainModel().render(lIlIlIlllllIIII, lIlIlIllllllIlI, lIlIlIllllIlllI, lIlIlIllllIllIl, lIlIlIllllIllII, lIlIlIllllIlIll, lIlIlIlllllIlII);
        }
    }
    
    public LayerWolfCollar(final RenderWolf lIlIllIIIIIIlll) {
        this.field_177146_b = lIlIllIIIIIIlll;
    }
}
