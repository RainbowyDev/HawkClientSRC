package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerSheepWool implements LayerRenderer
{
    private final /* synthetic */ ModelSheep1 sheepModel;
    private static final /* synthetic */ ResourceLocation TEXTURE;
    private final /* synthetic */ RenderSheep sheepRenderer;
    
    static {
        __OBFID = "CL_00002413";
        TEXTURE = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIlllIlIIlIIIlIIIll, final float llllllllllllllIlllIlIIlIIIIIllll, final float llllllllllllllIlllIlIIlIIIIlllll, final float llllllllllllllIlllIlIIlIIIIlllIl, final float llllllllllllllIlllIlIIlIIIIIlIIl, final float llllllllllllllIlllIlIIlIIIIllIIl, final float llllllllllllllIlllIlIIlIIIIlIlll, final float llllllllllllllIlllIlIIlIIIIIIlII) {
        this.doRenderLayer((EntitySheep)llllllllllllllIlllIlIIlIIIlIIIll, llllllllllllllIlllIlIIlIIIIIllll, llllllllllllllIlllIlIIlIIIIlllll, llllllllllllllIlllIlIIlIIIIlllIl, llllllllllllllIlllIlIIlIIIIIlIIl, llllllllllllllIlllIlIIlIIIIllIIl, llllllllllllllIlllIlIIlIIIIlIlll, llllllllllllllIlllIlIIlIIIIIIlII);
    }
    
    public void doRenderLayer(final EntitySheep llllllllllllllIlllIlIIlIIllIIIII, final float llllllllllllllIlllIlIIlIlIIIllII, final float llllllllllllllIlllIlIIlIIlIlllII, final float llllllllllllllIlllIlIIlIlIIIlIII, final float llllllllllllllIlllIlIIlIlIIIIllI, final float llllllllllllllIlllIlIIlIIlIlIlll, final float llllllllllllllIlllIlIIlIlIIIIIlI, final float llllllllllllllIlllIlIIlIlIIIIIII) {
        if (!llllllllllllllIlllIlIIlIIllIIIII.getSheared() && !llllllllllllllIlllIlIIlIIllIIIII.isInvisible()) {
            this.sheepRenderer.bindTexture(LayerSheepWool.TEXTURE);
            if (llllllllllllllIlllIlIIlIIllIIIII.hasCustomName() && "jeb_".equals(llllllllllllllIlllIlIIlIIllIIIII.getCustomNameTag())) {
                final boolean llllllllllllllIlllIlIIlIIllllllI = true;
                final int llllllllllllllIlllIlIIlIIlllllIl = llllllllllllllIlllIlIIlIIllIIIII.ticksExisted / 25 + llllllllllllllIlllIlIIlIIllIIIII.getEntityId();
                final int llllllllllllllIlllIlIIlIIllllIll = EnumDyeColor.values().length;
                final int llllllllllllllIlllIlIIlIIllllIIl = llllllllllllllIlllIlIIlIIlllllIl % llllllllllllllIlllIlIIlIIllllIll;
                final int llllllllllllllIlllIlIIlIIlllIlll = (llllllllllllllIlllIlIIlIIlllllIl + 1) % llllllllllllllIlllIlIIlIIllllIll;
                final float llllllllllllllIlllIlIIlIIlllIlIl = (llllllllllllllIlllIlIIlIIllIIIII.ticksExisted % 25 + llllllllllllllIlllIlIIlIlIIIlIII) / 25.0f;
                float[] llllllllllllllIlllIlIIlIIlllIIll = EntitySheep.func_175513_a(EnumDyeColor.func_176764_b(llllllllllllllIlllIlIIlIIllllIIl));
                float[] llllllllllllllIlllIlIIlIIlllIIIl = EntitySheep.func_175513_a(EnumDyeColor.func_176764_b(llllllllllllllIlllIlIIlIIlllIlll));
                if (Config.isCustomColors()) {
                    llllllllllllllIlllIlIIlIIlllIIll = CustomColors.getSheepColors(EnumDyeColor.func_176764_b(llllllllllllllIlllIlIIlIIllllIIl), llllllllllllllIlllIlIIlIIlllIIll);
                    llllllllllllllIlllIlIIlIIlllIIIl = CustomColors.getSheepColors(EnumDyeColor.func_176764_b(llllllllllllllIlllIlIIlIIlllIlll), llllllllllllllIlllIlIIlIIlllIIIl);
                }
                GlStateManager.color(llllllllllllllIlllIlIIlIIlllIIll[0] * (1.0f - llllllllllllllIlllIlIIlIIlllIlIl) + llllllllllllllIlllIlIIlIIlllIIIl[0] * llllllllllllllIlllIlIIlIIlllIlIl, llllllllllllllIlllIlIIlIIlllIIll[1] * (1.0f - llllllllllllllIlllIlIIlIIlllIlIl) + llllllllllllllIlllIlIIlIIlllIIIl[1] * llllllllllllllIlllIlIIlIIlllIlIl, llllllllllllllIlllIlIIlIIlllIIll[2] * (1.0f - llllllllllllllIlllIlIIlIIlllIlIl) + llllllllllllllIlllIlIIlIIlllIIIl[2] * llllllllllllllIlllIlIIlIIlllIlIl);
            }
            else {
                float[] llllllllllllllIlllIlIIlIIllIllll = EntitySheep.func_175513_a(llllllllllllllIlllIlIIlIIllIIIII.func_175509_cj());
                if (Config.isCustomColors()) {
                    llllllllllllllIlllIlIIlIIllIllll = CustomColors.getSheepColors(llllllllllllllIlllIlIIlIIllIIIII.func_175509_cj(), llllllllllllllIlllIlIIlIIllIllll);
                }
                GlStateManager.color(llllllllllllllIlllIlIIlIIllIllll[0], llllllllllllllIlllIlIIlIIllIllll[1], llllllllllllllIlllIlIIlIIllIllll[2]);
            }
            this.sheepModel.setModelAttributes(this.sheepRenderer.getMainModel());
            this.sheepModel.setLivingAnimations(llllllllllllllIlllIlIIlIIllIIIII, llllllllllllllIlllIlIIlIlIIIllII, llllllllllllllIlllIlIIlIIlIlllII, llllllllllllllIlllIlIIlIlIIIlIII);
            this.sheepModel.render(llllllllllllllIlllIlIIlIIllIIIII, llllllllllllllIlllIlIIlIlIIIllII, llllllllllllllIlllIlIIlIIlIlllII, llllllllllllllIlllIlIIlIlIIIIllI, llllllllllllllIlllIlIIlIIlIlIlll, llllllllllllllIlllIlIIlIlIIIIIlI, llllllllllllllIlllIlIIlIlIIIIIII);
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    public LayerSheepWool(final RenderSheep llllllllllllllIlllIlIIlIlIlIIIll) {
        this.sheepModel = new ModelSheep1();
        this.sheepRenderer = llllllllllllllIlllIlIIlIlIlIIIll;
    }
}
