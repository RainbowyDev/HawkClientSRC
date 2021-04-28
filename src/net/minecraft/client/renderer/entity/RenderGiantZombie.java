package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.model.*;

public class RenderGiantZombie extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation zombieTextures;
    private /* synthetic */ float scale;
    
    @Override
    public void func_82422_c() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllIlIllllIIIIlIlIlII, final float llllllllllllllIlIllllIIIIlIlIIII) {
        this.preRenderCallback((EntityGiantZombie)llllllllllllllIlIllllIIIIlIlIlII, llllllllllllllIlIllllIIIIlIlIIII);
    }
    
    protected void preRenderCallback(final EntityGiantZombie llllllllllllllIlIllllIIIIlIlllIl, final float llllllllllllllIlIllllIIIIlIlllII) {
        GlStateManager.scale(this.scale, this.scale, this.scale);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIlIllllIIIIlIIllII) {
        return this.getEntityTexture((EntityGiantZombie)llllllllllllllIlIllllIIIIlIIllII);
    }
    
    static {
        __OBFID = "CL_00000998";
        zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");
    }
    
    protected ResourceLocation getEntityTexture(final EntityGiantZombie llllllllllllllIlIllllIIIIlIllIIl) {
        return RenderGiantZombie.zombieTextures;
    }
    
    public RenderGiantZombie(final RenderManager llllllllllllllIlIllllIIIIllIIlII, final ModelBase llllllllllllllIlIllllIIIIllIlIII, final float llllllllllllllIlIllllIIIIllIIlll, final float llllllllllllllIlIllllIIIIllIIllI) {
        super(llllllllllllllIlIllllIIIIllIIlII, llllllllllllllIlIllllIIIIllIlIII, llllllllllllllIlIllllIIIIllIIlll * llllllllllllllIlIllllIIIIllIIllI);
        this.scale = llllllllllllllIlIllllIIIIllIIllI;
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this) {
            @Override
            protected void func_177177_a() {
                this.field_177189_c = new ModelZombie(0.5f, true);
                this.field_177186_d = new ModelZombie(1.0f, true);
            }
            
            static {
                __OBFID = "CL_00002444";
            }
        });
    }
}
