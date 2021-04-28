package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;

public class RenderCow extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation cowTextures;
    
    protected ResourceLocation func_180572_a(final EntityCow lllllllllllllllIIllllllIIIIlIIIl) {
        return RenderCow.cowTextures;
    }
    
    static {
        __OBFID = "CL_00000984";
        cowTextures = new ResourceLocation("textures/entity/cow/cow.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIllllllIIIIIllIl) {
        return this.func_180572_a((EntityCow)lllllllllllllllIIllllllIIIIIllIl);
    }
    
    public RenderCow(final RenderManager lllllllllllllllIIllllllIIIIllIIl, final ModelBase lllllllllllllllIIllllllIIIIllIII, final float lllllllllllllllIIllllllIIIIlIIll) {
        super(lllllllllllllllIIllllllIIIIllIIl, lllllllllllllllIIllllllIIIIllIII, lllllllllllllllIIllllllIIIIlIIll);
    }
}
