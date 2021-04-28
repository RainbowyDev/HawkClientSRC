package net.minecraft.client.renderer.entity;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.block.material.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderEnderman extends RenderLiving
{
    private /* synthetic */ Random rnd;
    private static final /* synthetic */ ResourceLocation endermanTextures;
    private /* synthetic */ ModelEnderman endermanModel;
    
    public void doRender(final EntityEnderman llllllllllllllIIIIIIlIIIIlllllll, double llllllllllllllIIIIIIlIIIIlllIllI, final double llllllllllllllIIIIIIlIIIIlllllIl, double llllllllllllllIIIIIIlIIIIlllllII, final float llllllllllllllIIIIIIlIIIIlllIIll, final float llllllllllllllIIIIIIlIIIIlllIIlI) {
        this.endermanModel.isCarrying = (llllllllllllllIIIIIIlIIIIlllllll.func_175489_ck().getBlock().getMaterial() != Material.air);
        this.endermanModel.isAttacking = llllllllllllllIIIIIIlIIIIlllllll.isScreaming();
        if (llllllllllllllIIIIIIlIIIIlllllll.isScreaming()) {
            final double llllllllllllllIIIIIIlIIIIllllIIl = 0.02;
            llllllllllllllIIIIIIlIIIIlllIllI += this.rnd.nextGaussian() * llllllllllllllIIIIIIlIIIIllllIIl;
            llllllllllllllIIIIIIlIIIIlllllII += this.rnd.nextGaussian() * llllllllllllllIIIIIIlIIIIllllIIl;
        }
        super.doRender(llllllllllllllIIIIIIlIIIIlllllll, llllllllllllllIIIIIIlIIIIlllIllI, llllllllllllllIIIIIIlIIIIlllllIl, llllllllllllllIIIIIIlIIIIlllllII, llllllllllllllIIIIIIlIIIIlllIIll, llllllllllllllIIIIIIlIIIIlllIIlI);
    }
    
    static {
        __OBFID = "CL_00000989";
        endermanTextures = new ResourceLocation("textures/entity/enderman/enderman.png");
    }
    
    @Override
    public void doRender(final EntityLiving llllllllllllllIIIIIIlIIIIlIlllll, final double llllllllllllllIIIIIIlIIIIllIIlIl, final double llllllllllllllIIIIIIlIIIIlIlllIl, final double llllllllllllllIIIIIIlIIIIlIlllII, final float llllllllllllllIIIIIIlIIIIlIllIll, final float llllllllllllllIIIIIIlIIIIlIllIlI) {
        this.doRender((EntityEnderman)llllllllllllllIIIIIIlIIIIlIlllll, llllllllllllllIIIIIIlIIIIllIIlIl, llllllllllllllIIIIIIlIIIIlIlllIl, llllllllllllllIIIIIIlIIIIlIlllII, llllllllllllllIIIIIIlIIIIlIllIll, llllllllllllllIIIIIIlIIIIlIllIlI);
    }
    
    public RenderEnderman(final RenderManager llllllllllllllIIIIIIlIIIlIIIlIll) {
        super(llllllllllllllIIIIIIlIIIlIIIlIll, new ModelEnderman(0.0f), 0.5f);
        this.rnd = new Random();
        this.endermanModel = (ModelEnderman)super.mainModel;
        this.addLayer(new LayerEndermanEyes(this));
        this.addLayer(new LayerHeldBlock(this));
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIIIIIIlIIIIIllIllI, final double llllllllllllllIIIIIIlIIIIIlIlllI, final double llllllllllllllIIIIIIlIIIIIlIllIl, final double llllllllllllllIIIIIIlIIIIIllIIll, final float llllllllllllllIIIIIIlIIIIIllIIlI, final float llllllllllllllIIIIIIlIIIIIllIIIl) {
        this.doRender((EntityEnderman)llllllllllllllIIIIIIlIIIIIllIllI, llllllllllllllIIIIIIlIIIIIlIlllI, llllllllllllllIIIIIIlIIIIIlIllIl, llllllllllllllIIIIIIlIIIIIllIIll, llllllllllllllIIIIIIlIIIIIllIIlI, llllllllllllllIIIIIIlIIIIIllIIIl);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIIIIIlIIIIIllllll) {
        return this.func_180573_a((EntityEnderman)llllllllllllllIIIIIIlIIIIIllllll);
    }
    
    @Override
    public void doRender(final EntityLivingBase llllllllllllllIIIIIIlIIIIlIlIIIl, final double llllllllllllllIIIIIIlIIIIlIIlIIl, final double llllllllllllllIIIIIIlIIIIlIIllll, final double llllllllllllllIIIIIIlIIIIlIIlllI, final float llllllllllllllIIIIIIlIIIIlIIllIl, final float llllllllllllllIIIIIIlIIIIlIIllII) {
        this.doRender((EntityEnderman)llllllllllllllIIIIIIlIIIIlIlIIIl, llllllllllllllIIIIIIlIIIIlIIlIIl, llllllllllllllIIIIIIlIIIIlIIllll, llllllllllllllIIIIIIlIIIIlIIlllI, llllllllllllllIIIIIIlIIIIlIIllIl, llllllllllllllIIIIIIlIIIIlIIllII);
    }
    
    protected ResourceLocation func_180573_a(final EntityEnderman llllllllllllllIIIIIIlIIIIllIllll) {
        return RenderEnderman.endermanTextures;
    }
}
