package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderSpider extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation spiderTextures;
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIlIIlIIlIIlIIlIllI) {
        return this.getEntityTexture((EntitySpider)llllllllllllllIlIIlIIlIIlIIlIllI);
    }
    
    protected float getDeathMaxRotation(final EntitySpider llllllllllllllIlIIlIIlIIlIlIIIlI) {
        return 180.0f;
    }
    
    static {
        __OBFID = "CL_00001027";
        spiderTextures = new ResourceLocation("textures/entity/spider/spider.png");
    }
    
    public RenderSpider(final RenderManager llllllllllllllIlIIlIIlIIlIlIIlII) {
        super(llllllllllllllIlIIlIIlIIlIlIIlII, new ModelSpider(), 1.0f);
        this.addLayer(new LayerSpiderEyes(this));
    }
    
    protected ResourceLocation getEntityTexture(final EntitySpider llllllllllllllIlIIlIIlIIlIlIIIII) {
        return RenderSpider.spiderTextures;
    }
    
    @Override
    protected float getDeathMaxRotation(final EntityLivingBase llllllllllllllIlIIlIIlIIlIIlllII) {
        return this.getDeathMaxRotation((EntitySpider)llllllllllllllIlIIlIIlIIlIIlllII);
    }
}
