package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderSilverfish extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation silverfishTextures;
    
    protected ResourceLocation getEntityTexture(final EntitySilverfish llllllllllllllIllllIIlIlIlIIIIlI) {
        return RenderSilverfish.silverfishTextures;
    }
    
    protected float func_180584_a(final EntitySilverfish llllllllllllllIllllIIlIlIlIIIlII) {
        return 180.0f;
    }
    
    static {
        __OBFID = "CL_00001022";
        silverfishTextures = new ResourceLocation("textures/entity/silverfish.png");
    }
    
    public RenderSilverfish(final RenderManager llllllllllllllIllllIIlIlIlIIlIII) {
        super(llllllllllllllIllllIIlIlIlIIlIII, new ModelSilverfish(), 0.3f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIllllIIlIlIIllIllI) {
        return this.getEntityTexture((EntitySilverfish)llllllllllllllIllllIIlIlIIllIllI);
    }
    
    @Override
    protected float getDeathMaxRotation(final EntityLivingBase llllllllllllllIllllIIlIlIIlllllI) {
        return this.func_180584_a((EntitySilverfish)llllllllllllllIllllIIlIlIIlllllI);
    }
}
