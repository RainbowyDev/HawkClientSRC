package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderPigZombie extends RenderBiped
{
    private static final /* synthetic */ ResourceLocation field_177120_j;
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllllIllllllIIIllIll) {
        return this.func_177119_a((EntityPigZombie)lllllllllllllllllIllllllIIIllIll);
    }
    
    static {
        __OBFID = "CL_00002434";
        field_177120_j = new ResourceLocation("textures/entity/zombie_pigman.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLiving lllllllllllllllllIllllllIIlIIIIl) {
        return this.func_177119_a((EntityPigZombie)lllllllllllllllllIllllllIIlIIIIl);
    }
    
    public RenderPigZombie(final RenderManager lllllllllllllllllIllllllIIlIlIIl) {
        super(lllllllllllllllllIllllllIIlIlIIl, new ModelZombie(), 0.5f, 1.0f);
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this) {
            @Override
            protected void func_177177_a() {
                this.field_177189_c = new ModelZombie(0.5f, true);
                this.field_177186_d = new ModelZombie(1.0f, true);
            }
            
            static {
                __OBFID = "CL_00002433";
            }
        });
    }
    
    protected ResourceLocation func_177119_a(final EntityPigZombie lllllllllllllllllIllllllIIlIIlll) {
        return RenderPigZombie.field_177120_j;
    }
}
