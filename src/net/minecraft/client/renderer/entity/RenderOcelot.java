package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;

public class RenderOcelot extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation ocelotTextures;
    private static final /* synthetic */ ResourceLocation siameseOcelotTextures;
    private static final /* synthetic */ ResourceLocation redOcelotTextures;
    private static final /* synthetic */ ResourceLocation blackOcelotTextures;
    
    protected void preRenderCallback(final EntityOcelot llllllllllllllIIllIIIllIIlIlIIIl, final float llllllllllllllIIllIIIllIIlIIllIl) {
        super.preRenderCallback(llllllllllllllIIllIIIllIIlIlIIIl, llllllllllllllIIllIIIllIIlIIllIl);
        if (llllllllllllllIIllIIIllIIlIlIIIl.isTamed()) {
            GlStateManager.scale(0.8f, 0.8f, 0.8f);
        }
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllIIllIIIllIIlIIIlIl, final float llllllllllllllIIllIIIllIIlIIIlll) {
        this.preRenderCallback((EntityOcelot)llllllllllllllIIllIIIllIIlIIIlIl, llllllllllllllIIllIIIllIIlIIIlll);
    }
    
    protected ResourceLocation getEntityTexture(final EntityOcelot llllllllllllllIIllIIIllIIlIlIlll) {
        switch (llllllllllllllIIllIIIllIIlIlIlll.getTameSkin()) {
            default: {
                return RenderOcelot.ocelotTextures;
            }
            case 1: {
                return RenderOcelot.blackOcelotTextures;
            }
            case 2: {
                return RenderOcelot.redOcelotTextures;
            }
            case 3: {
                return RenderOcelot.siameseOcelotTextures;
            }
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIllIIIllIIlIIIIII) {
        return this.getEntityTexture((EntityOcelot)llllllllllllllIIllIIIllIIlIIIIII);
    }
    
    static {
        __OBFID = "CL_00001017";
        blackOcelotTextures = new ResourceLocation("textures/entity/cat/black.png");
        ocelotTextures = new ResourceLocation("textures/entity/cat/ocelot.png");
        redOcelotTextures = new ResourceLocation("textures/entity/cat/red.png");
        siameseOcelotTextures = new ResourceLocation("textures/entity/cat/siamese.png");
    }
    
    public RenderOcelot(final RenderManager llllllllllllllIIllIIIllIIlIlllII, final ModelBase llllllllllllllIIllIIIllIIlIlllll, final float llllllllllllllIIllIIIllIIlIllllI) {
        super(llllllllllllllIIllIIIllIIlIlllII, llllllllllllllIIllIIIllIIlIlllll, llllllllllllllIIllIIIllIIlIllllI);
    }
}
