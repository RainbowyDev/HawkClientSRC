package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderSheep extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation shearedSheepTextures;
    
    protected ResourceLocation getEntityTexture(final EntitySheep lllllllllllllllIIIlIlIIlIIlIlIll) {
        return RenderSheep.shearedSheepTextures;
    }
    
    static {
        __OBFID = "CL_00001021";
        shearedSheepTextures = new ResourceLocation("textures/entity/sheep/sheep.png");
    }
    
    public RenderSheep(final RenderManager lllllllllllllllIIIlIlIIlIIllIIll, final ModelBase lllllllllllllllIIIlIlIIlIIllIIlI, final float lllllllllllllllIIIlIlIIlIIlIllIl) {
        super(lllllllllllllllIIIlIlIIlIIllIIll, lllllllllllllllIIIlIlIIlIIllIIlI, lllllllllllllllIIIlIlIIlIIlIllIl);
        this.addLayer(new LayerSheepWool(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIIlIlIIlIIlIIlIl) {
        return this.getEntityTexture((EntitySheep)lllllllllllllllIIIlIlIIlIIlIIlIl);
    }
}
