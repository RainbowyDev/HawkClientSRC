package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderVillager extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation librarianVillagerTextures;
    private static final /* synthetic */ ResourceLocation priestVillagerTextures;
    private static final /* synthetic */ ResourceLocation smithVillagerTextures;
    private static final /* synthetic */ ResourceLocation villagerTextures;
    private static final /* synthetic */ ResourceLocation farmerVillagerTextures;
    private static final /* synthetic */ ResourceLocation butcherVillagerTextures;
    
    @Override
    public ModelBase getMainModel() {
        return this.func_177134_g();
    }
    
    public RenderVillager(final RenderManager llllllllllllllIlIlIIIlIllIIlllII) {
        super(llllllllllllllIlIlIIIlIllIIlllII, new ModelVillager(0.0f), 0.5f);
        this.addLayer(new LayerCustomHead(this.func_177134_g().villagerHead));
    }
    
    static {
        __OBFID = "CL_00001032";
        villagerTextures = new ResourceLocation("textures/entity/villager/villager.png");
        farmerVillagerTextures = new ResourceLocation("textures/entity/villager/farmer.png");
        librarianVillagerTextures = new ResourceLocation("textures/entity/villager/librarian.png");
        priestVillagerTextures = new ResourceLocation("textures/entity/villager/priest.png");
        smithVillagerTextures = new ResourceLocation("textures/entity/villager/smith.png");
        butcherVillagerTextures = new ResourceLocation("textures/entity/villager/butcher.png");
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllIlIlIIIlIllIIIIIIl, final float llllllllllllllIlIlIIIlIllIIIIIll) {
        this.preRenderCallback((EntityVillager)llllllllllllllIlIlIIIlIllIIIIIIl, llllllllllllllIlIlIIIlIllIIIIIll);
    }
    
    public ModelVillager func_177134_g() {
        return (ModelVillager)super.getMainModel();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIlIlIIIlIlIllllIIl) {
        return this.getEntityTexture((EntityVillager)llllllllllllllIlIlIIIlIlIllllIIl);
    }
    
    protected void preRenderCallback(final EntityVillager llllllllllllllIlIlIIIlIllIIIlllI, final float llllllllllllllIlIlIIIlIllIIIllIl) {
        float llllllllllllllIlIlIIIlIllIIIllII = 0.9375f;
        if (llllllllllllllIlIlIIIlIllIIIlllI.getGrowingAge() < 0) {
            llllllllllllllIlIlIIIlIllIIIllII *= 0.5;
            this.shadowSize = 0.25f;
        }
        else {
            this.shadowSize = 0.5f;
        }
        GlStateManager.scale(llllllllllllllIlIlIIIlIllIIIllII, llllllllllllllIlIlIIIlIllIIIllII, llllllllllllllIlIlIIIlIllIIIllII);
    }
    
    protected ResourceLocation getEntityTexture(final EntityVillager llllllllllllllIlIlIIIlIllIIlIlII) {
        switch (llllllllllllllIlIlIIIlIllIIlIlII.getProfession()) {
            case 0: {
                return RenderVillager.farmerVillagerTextures;
            }
            case 1: {
                return RenderVillager.librarianVillagerTextures;
            }
            case 2: {
                return RenderVillager.priestVillagerTextures;
            }
            case 3: {
                return RenderVillager.smithVillagerTextures;
            }
            case 4: {
                return RenderVillager.butcherVillagerTextures;
            }
            default: {
                return RenderVillager.villagerTextures;
            }
        }
    }
}
