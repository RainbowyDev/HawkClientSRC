package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderMooshroom extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation mooshroomTextures;
    
    static {
        __OBFID = "CL_00001016";
        mooshroomTextures = new ResourceLocation("textures/entity/cow/mooshroom.png");
    }
    
    protected ResourceLocation func_180582_a(final EntityMooshroom llllllllllllllIIIIlIIlIIlllIIIlI) {
        return RenderMooshroom.mooshroomTextures;
    }
    
    public RenderMooshroom(final RenderManager llllllllllllllIIIIlIIlIIlllIIllI, final ModelBase llllllllllllllIIIIlIIlIIlllIIlIl, final float llllllllllllllIIIIlIIlIIlllIlIII) {
        super(llllllllllllllIIIIlIIlIIlllIIllI, llllllllllllllIIIIlIIlIIlllIIlIl, llllllllllllllIIIIlIIlIIlllIlIII);
        this.addLayer(new LayerMooshroomMushroom(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIIIlIIlIIllIlllII) {
        return this.func_180582_a((EntityMooshroom)llllllllllllllIIIIlIIlIIllIlllII);
    }
}
