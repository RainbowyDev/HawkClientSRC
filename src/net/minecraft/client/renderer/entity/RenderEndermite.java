package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderEndermite extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation field_177108_a;
    
    static {
        __OBFID = "CL_00002445";
        field_177108_a = new ResourceLocation("textures/entity/endermite.png");
    }
    
    protected float func_177107_a(final EntityEndermite lIIlllllIIII) {
        return 180.0f;
    }
    
    @Override
    protected float getDeathMaxRotation(final EntityLivingBase lIIllllIlIlI) {
        return this.func_177107_a((EntityEndermite)lIIllllIlIlI);
    }
    
    public RenderEndermite(final RenderManager lIIlllllIlII) {
        super(lIIlllllIlII, new ModelEnderMite(), 0.3f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lIIllllIIIlI) {
        return this.func_177106_b((EntityEndermite)lIIllllIIIlI);
    }
    
    protected ResourceLocation func_177106_b(final EntityEndermite lIIllllIlllI) {
        return RenderEndermite.field_177108_a;
    }
}
