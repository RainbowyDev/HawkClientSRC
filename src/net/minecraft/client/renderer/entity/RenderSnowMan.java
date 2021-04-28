package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;

public class RenderSnowMan extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation snowManTextures;
    
    @Override
    public ModelBase getMainModel() {
        return this.func_177123_g();
    }
    
    public RenderSnowMan(final RenderManager llllllllllllllIIIIllIlllIIlIIIll) {
        super(llllllllllllllIIIIllIlllIIlIIIll, new ModelSnowMan(), 0.5f);
        this.addLayer(new LayerSnowmanHead(this));
    }
    
    public ModelSnowMan func_177123_g() {
        return (ModelSnowMan)super.getMainModel();
    }
    
    protected ResourceLocation func_180587_a(final EntitySnowman llllllllllllllIIIIllIlllIIlIIIIl) {
        return RenderSnowMan.snowManTextures;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIIIllIlllIIIlIlll) {
        return this.func_180587_a((EntitySnowman)llllllllllllllIIIIllIlllIIIlIlll);
    }
    
    static {
        __OBFID = "CL_00001025";
        snowManTextures = new ResourceLocation("textures/entity/snowman.png");
    }
}
