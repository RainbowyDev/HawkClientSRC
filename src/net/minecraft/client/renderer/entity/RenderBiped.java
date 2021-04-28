package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderBiped extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation field_177118_j;
    protected /* synthetic */ ModelBiped modelBipedMain;
    protected /* synthetic */ float field_77070_b;
    
    @Override
    public void func_82422_c() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllllIIlIIIIIIIIlIIlI) {
        return this.getEntityTexture((EntityLiving)llllllllllllllllIIlIIIIIIIIlIIlI);
    }
    
    static {
        __OBFID = "CL_00001001";
        field_177118_j = new ResourceLocation("textures/entity/steve.png");
    }
    
    public RenderBiped(final RenderManager llllllllllllllllIIlIIIIIIIllIIII, final ModelBiped llllllllllllllllIIlIIIIIIIlIllll, final float llllllllllllllllIIlIIIIIIIlIlllI) {
        this(llllllllllllllllIIlIIIIIIIllIIII, llllllllllllllllIIlIIIIIIIlIllll, llllllllllllllllIIlIIIIIIIlIlllI, 1.0f);
        this.addLayer(new LayerHeldItem(this));
    }
    
    public RenderBiped(final RenderManager llllllllllllllllIIlIIIIIIIIllllI, final ModelBiped llllllllllllllllIIlIIIIIIIIlllIl, final float llllllllllllllllIIlIIIIIIIIlllII, final float llllllllllllllllIIlIIIIIIIlIIIII) {
        super(llllllllllllllllIIlIIIIIIIIllllI, llllllllllllllllIIlIIIIIIIIlllIl, llllllllllllllllIIlIIIIIIIIlllII);
        this.modelBipedMain = llllllllllllllllIIlIIIIIIIIlllIl;
        this.field_77070_b = llllllllllllllllIIlIIIIIIIlIIIII;
        this.addLayer(new LayerCustomHead(llllllllllllllllIIlIIIIIIIIlllIl.bipedHead));
    }
    
    protected ResourceLocation getEntityTexture(final EntityLiving llllllllllllllllIIlIIIIIIIIllIIl) {
        return RenderBiped.field_177118_j;
    }
}
