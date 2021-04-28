package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RenderRabbit extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation field_177130_l;
    private static final /* synthetic */ ResourceLocation field_177128_n;
    private static final /* synthetic */ ResourceLocation field_177126_e;
    private static final /* synthetic */ ResourceLocation field_177127_a;
    private static final /* synthetic */ ResourceLocation field_177131_m;
    private static final /* synthetic */ ResourceLocation field_177129_o;
    private static final /* synthetic */ ResourceLocation field_177132_j;
    private static final /* synthetic */ ResourceLocation field_177133_k;
    
    public RenderRabbit(final RenderManager llllllllllllllIlIlIIlIllIlIlIIII, final ModelBase llllllllllllllIlIlIIlIllIlIIlIll, final float llllllllllllllIlIlIIlIllIlIIlllI) {
        super(llllllllllllllIlIlIIlIllIlIlIIII, llllllllllllllIlIlIIlIllIlIIlIll, llllllllllllllIlIlIIlIllIlIIlllI);
    }
    
    protected ResourceLocation func_177125_a(final EntityRabbit llllllllllllllIlIlIIlIllIlIIIllI) {
        final String llllllllllllllIlIlIIlIllIlIIIlIl = EnumChatFormatting.getTextWithoutFormattingCodes(llllllllllllllIlIlIIlIllIlIIIllI.getName());
        if (llllllllllllllIlIlIIlIllIlIIIlIl != null && llllllllllllllIlIlIIlIllIlIIIlIl.equals("Toast")) {
            return RenderRabbit.field_177128_n;
        }
        switch (llllllllllllllIlIlIIlIllIlIIIllI.func_175531_cl()) {
            default: {
                return RenderRabbit.field_177127_a;
            }
            case 1: {
                return RenderRabbit.field_177126_e;
            }
            case 2: {
                return RenderRabbit.field_177132_j;
            }
            case 3: {
                return RenderRabbit.field_177131_m;
            }
            case 4: {
                return RenderRabbit.field_177133_k;
            }
            case 5: {
                return RenderRabbit.field_177130_l;
            }
            case 99: {
                return RenderRabbit.field_177129_o;
            }
        }
    }
    
    static {
        __OBFID = "CL_00002432";
        field_177127_a = new ResourceLocation("textures/entity/rabbit/brown.png");
        field_177126_e = new ResourceLocation("textures/entity/rabbit/white.png");
        field_177132_j = new ResourceLocation("textures/entity/rabbit/black.png");
        field_177133_k = new ResourceLocation("textures/entity/rabbit/gold.png");
        field_177130_l = new ResourceLocation("textures/entity/rabbit/salt.png");
        field_177131_m = new ResourceLocation("textures/entity/rabbit/white_splotched.png");
        field_177128_n = new ResourceLocation("textures/entity/rabbit/toast.png");
        field_177129_o = new ResourceLocation("textures/entity/rabbit/caerbannog.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIlIlIIlIllIIllllll) {
        return this.func_177125_a((EntityRabbit)llllllllllllllIlIlIIlIllIIllllll);
    }
}
