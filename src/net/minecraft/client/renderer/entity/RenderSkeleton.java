package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderSkeleton extends RenderBiped
{
    private static final /* synthetic */ ResourceLocation skeletonTextures;
    private static final /* synthetic */ ResourceLocation witherSkeletonTextures;
    
    static {
        __OBFID = "CL_00001023";
        skeletonTextures = new ResourceLocation("textures/entity/skeleton/skeleton.png");
        witherSkeletonTextures = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLiving lllllllllllllllIlIllIlIlIIllllll) {
        return this.func_180577_a((EntitySkeleton)lllllllllllllllIlIllIlIlIIllllll);
    }
    
    protected void preRenderCallback(final EntitySkeleton lllllllllllllllIlIllIlIlIlIIlIlI, final float lllllllllllllllIlIllIlIlIlIIlIll) {
        if (lllllllllllllllIlIllIlIlIlIIlIlI.getSkeletonType() == 1) {
            GlStateManager.scale(1.2f, 1.2f, 1.2f);
        }
    }
    
    @Override
    public void func_82422_c() {
        GlStateManager.translate(0.09375f, 0.1875f, 0.0f);
    }
    
    protected ResourceLocation func_180577_a(final EntitySkeleton lllllllllllllllIlIllIlIlIlIIIlIl) {
        return (lllllllllllllllIlIllIlIlIlIIIlIl.getSkeletonType() == 1) ? RenderSkeleton.witherSkeletonTextures : RenderSkeleton.skeletonTextures;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIlIllIlIlIIllIIlI) {
        return this.func_180577_a((EntitySkeleton)lllllllllllllllIlIllIlIlIIllIIlI);
    }
    
    public RenderSkeleton(final RenderManager lllllllllllllllIlIllIlIlIlIIllll) {
        super(lllllllllllllllIlIllIlIlIlIIllll, new ModelSkeleton(), 0.5f);
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this) {
            static {
                __OBFID = "CL_00002431";
            }
            
            @Override
            protected void func_177177_a() {
                this.field_177189_c = new ModelSkeleton(0.5f, true);
                this.field_177186_d = new ModelSkeleton(1.0f, true);
            }
        });
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase lllllllllllllllIlIllIlIlIIlllIlI, final float lllllllllllllllIlIllIlIlIIlllIIl) {
        this.preRenderCallback((EntitySkeleton)lllllllllllllllIlIllIlIlIIlllIlI, lllllllllllllllIlIllIlIlIIlllIIl);
    }
}
