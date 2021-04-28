package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;

public class RenderBlaze extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation blazeTextures;
    
    public RenderBlaze(final RenderManager llllllllllllllIlllIIIlllIIlIIlII) {
        super(llllllllllllllIlllIIIlllIIlIIlII, new ModelBlaze(), 0.5f);
    }
    
    static {
        __OBFID = "CL_00000980";
        blazeTextures = new ResourceLocation("textures/entity/blaze.png");
    }
    
    protected ResourceLocation getEntityTexture(final EntityBlaze llllllllllllllIlllIIIlllIIlIIIII) {
        return RenderBlaze.blazeTextures;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIlllIIIlllIIIlllII) {
        return this.getEntityTexture((EntityBlaze)llllllllllllllIlllIIIlllIIIlllII);
    }
}
