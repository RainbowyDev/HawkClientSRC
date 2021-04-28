package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class LayerSaddle implements LayerRenderer
{
    private final /* synthetic */ RenderPig pigRenderer;
    private static final /* synthetic */ ResourceLocation TEXTURE;
    private final /* synthetic */ ModelPig pigModel;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerSaddle(final RenderPig llllllllllllllIIIIIIIlIlIIlIlIIl) {
        this.pigModel = new ModelPig(0.5f);
        this.pigRenderer = llllllllllllllIIIIIIIlIlIIlIlIIl;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIIIIIIIlIlIIIIIIlI, final float llllllllllllllIIIIIIIlIlIIIIIIIl, final float llllllllllllllIIIIIIIlIlIIIIIIII, final float llllllllllllllIIIIIIIlIIllllllll, final float llllllllllllllIIIIIIIlIIllllIlIl, final float llllllllllllllIIIIIIIlIIllllllIl, final float llllllllllllllIIIIIIIlIIllllllII, final float llllllllllllllIIIIIIIlIIllllIIlI) {
        this.doRenderLayer((EntityPig)llllllllllllllIIIIIIIlIlIIIIIIlI, llllllllllllllIIIIIIIlIlIIIIIIIl, llllllllllllllIIIIIIIlIlIIIIIIII, llllllllllllllIIIIIIIlIIllllllll, llllllllllllllIIIIIIIlIIllllIlIl, llllllllllllllIIIIIIIlIIllllllIl, llllllllllllllIIIIIIIlIIllllllII, llllllllllllllIIIIIIIlIIllllIIlI);
    }
    
    public void doRenderLayer(final EntityPig llllllllllllllIIIIIIIlIlIIIlllIl, final float llllllllllllllIIIIIIIlIlIIIlIIll, final float llllllllllllllIIIIIIIlIlIIIllIll, final float llllllllllllllIIIIIIIlIlIIIllIlI, final float llllllllllllllIIIIIIIlIlIIIlIIIl, final float llllllllllllllIIIIIIIlIlIIIllIII, final float llllllllllllllIIIIIIIlIlIIIIllll, final float llllllllllllllIIIIIIIlIlIIIlIllI) {
        if (llllllllllllllIIIIIIIlIlIIIlllIl.getSaddled()) {
            this.pigRenderer.bindTexture(LayerSaddle.TEXTURE);
            this.pigModel.setModelAttributes(this.pigRenderer.getMainModel());
            this.pigModel.render(llllllllllllllIIIIIIIlIlIIIlllIl, llllllllllllllIIIIIIIlIlIIIlIIll, llllllllllllllIIIIIIIlIlIIIllIll, llllllllllllllIIIIIIIlIlIIIlIIIl, llllllllllllllIIIIIIIlIlIIIllIII, llllllllllllllIIIIIIIlIlIIIIllll, llllllllllllllIIIIIIIlIlIIIlIllI);
        }
    }
    
    static {
        __OBFID = "CL_00002414";
        TEXTURE = new ResourceLocation("textures/entity/pig/pig_saddle.png");
    }
}
