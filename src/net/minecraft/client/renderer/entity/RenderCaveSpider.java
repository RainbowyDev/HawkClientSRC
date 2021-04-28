package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderCaveSpider extends RenderSpider
{
    private static final /* synthetic */ ResourceLocation caveSpiderTextures;
    
    public RenderCaveSpider(final RenderManager lIIIIIlllllIllI) {
        super(lIIIIIlllllIllI);
        this.shadowSize *= 0.7f;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySpider lIIIIIllllIlIIl) {
        return this.func_180586_a((EntityCaveSpider)lIIIIIllllIlIIl);
    }
    
    protected ResourceLocation func_180586_a(final EntityCaveSpider lIIIIIllllIllll) {
        return RenderCaveSpider.caveSpiderTextures;
    }
    
    static {
        __OBFID = "CL_00000982";
        caveSpiderTextures = new ResourceLocation("textures/entity/spider/cave_spider.png");
    }
    
    protected void func_180585_a(final EntityCaveSpider lIIIIIlllllIIlI, final float lIIIIIlllllIIIl) {
        GlStateManager.scale(0.7f, 0.7f, 0.7f);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase lIIIIIllllIIlII, final float lIIIIIllllIIIII) {
        this.func_180585_a((EntityCaveSpider)lIIIIIllllIIlII, lIIIIIllllIIIII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lIIIIIlllIlllII) {
        return this.func_180586_a((EntityCaveSpider)lIIIIIlllIlllII);
    }
}
