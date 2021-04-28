package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderPig extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation pigTextures;
    
    static {
        __OBFID = "CL_00001019";
        pigTextures = new ResourceLocation("textures/entity/pig/pig.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIllIIlllIIIIIlIIlI) {
        return this.func_180583_a((EntityPig)llllllllllllllIllIIlllIIIIIlIIlI);
    }
    
    protected ResourceLocation func_180583_a(final EntityPig llllllllllllllIllIIlllIIIIIlIllI) {
        return RenderPig.pigTextures;
    }
    
    public RenderPig(final RenderManager llllllllllllllIllIIlllIIIIIllIlI, final ModelBase llllllllllllllIllIIlllIIIIIllIIl, final float llllllllllllllIllIIlllIIIIIlllII) {
        super(llllllllllllllIllIIlllIIIIIllIlI, llllllllllllllIllIIlllIIIIIllIIl, llllllllllllllIllIIlllIIIIIlllII);
        this.addLayer(new LayerSaddle(this));
    }
}
