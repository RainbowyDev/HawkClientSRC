package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderChicken extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation chickenTextures;
    
    protected float func_180569_a(final EntityChicken lllllllllllllllllIlIlIIlIlIllIll, final float lllllllllllllllllIlIlIIlIlIlIllI) {
        final float lllllllllllllllllIlIlIIlIlIllIIl = lllllllllllllllllIlIlIIlIlIllIll.field_70888_h + (lllllllllllllllllIlIlIIlIlIllIll.field_70886_e - lllllllllllllllllIlIlIIlIlIllIll.field_70888_h) * lllllllllllllllllIlIlIIlIlIlIllI;
        final float lllllllllllllllllIlIlIIlIlIllIII = lllllllllllllllllIlIlIIlIlIllIll.field_70884_g + (lllllllllllllllllIlIlIIlIlIllIll.destPos - lllllllllllllllllIlIlIIlIlIllIll.field_70884_g) * lllllllllllllllllIlIlIIlIlIlIllI;
        return (MathHelper.sin(lllllllllllllllllIlIlIIlIlIllIIl) + 1.0f) * lllllllllllllllllIlIlIIlIlIllIII;
    }
    
    static {
        __OBFID = "CL_00000983";
        chickenTextures = new ResourceLocation("textures/entity/chicken.png");
    }
    
    public RenderChicken(final RenderManager lllllllllllllllllIlIlIIlIllIlIIl, final ModelBase lllllllllllllllllIlIlIIlIllIlIII, final float lllllllllllllllllIlIlIIlIllIIlll) {
        super(lllllllllllllllllIlIlIIlIllIlIIl, lllllllllllllllllIlIlIIlIllIlIII, lllllllllllllllllIlIlIIlIllIIlll);
    }
    
    protected ResourceLocation func_180568_a(final EntityChicken lllllllllllllllllIlIlIIlIllIIIIl) {
        return RenderChicken.chickenTextures;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllllIlIlIIlIlIIIlll) {
        return this.func_180568_a((EntityChicken)lllllllllllllllllIlIlIIlIlIIIlll);
    }
    
    @Override
    protected float handleRotationFloat(final EntityLivingBase lllllllllllllllllIlIlIIlIlIIllII, final float lllllllllllllllllIlIlIIlIlIIlIll) {
        return this.func_180569_a((EntityChicken)lllllllllllllllllIlIlIIlIlIIllII, lllllllllllllllllIlIlIIlIlIIlIll);
    }
}
