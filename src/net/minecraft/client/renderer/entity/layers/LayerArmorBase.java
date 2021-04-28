package net.minecraft.client.renderer.entity.layers;

import java.util.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import optifine.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import shadersmod.client.*;

public abstract class LayerArmorBase implements LayerRenderer
{
    private static final /* synthetic */ Map field_177191_j;
    private /* synthetic */ float field_177185_g;
    private /* synthetic */ float field_177192_h;
    private /* synthetic */ float field_177184_f;
    protected /* synthetic */ ModelBase field_177186_d;
    protected static final /* synthetic */ ResourceLocation field_177188_b;
    private /* synthetic */ boolean field_177193_i;
    protected /* synthetic */ ModelBase field_177189_c;
    private final /* synthetic */ RendererLivingEntity field_177190_a;
    private /* synthetic */ float field_177187_e;
    
    public LayerArmorBase(final RendererLivingEntity lllllllllllllllIIlllllIlIIIIIlII) {
        this.field_177187_e = 1.0f;
        this.field_177184_f = 1.0f;
        this.field_177185_g = 1.0f;
        this.field_177192_h = 1.0f;
        this.field_177190_a = lllllllllllllllIIlllllIlIIIIIlII;
        this.func_177177_a();
    }
    
    private ResourceLocation func_177181_a(final ItemArmor lllllllllllllllIIlllllIIIllIIllI, final boolean lllllllllllllllIIlllllIIIllIlIII) {
        return this.func_177178_a(lllllllllllllllIIlllllIIIllIIllI, lllllllllllllllIIlllllIIIllIlIII, null);
    }
    
    private boolean func_177180_b(final int lllllllllllllllIIlllllIIlIIllIll) {
        return lllllllllllllllIIlllllIIlIIllIll == 2;
    }
    
    public ItemStack func_177176_a(final EntityLivingBase lllllllllllllllIIlllllIIlIlIlIII, final int lllllllllllllllIIlllllIIlIlIIlIl) {
        return lllllllllllllllIIlllllIIlIlIlIII.getCurrentArmor(lllllllllllllllIIlllllIIlIlIIlIl - 1);
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllllIIlllllIIlllIlllI, final float lllllllllllllllIIlllllIIlllIllIl, final float lllllllllllllllIIlllllIIllllIlIl, final float lllllllllllllllIIlllllIIlllIlIll, final float lllllllllllllllIIlllllIIlllIlIlI, final float lllllllllllllllIIlllllIIlllIlIIl, final float lllllllllllllllIIlllllIIlllIlIII, final float lllllllllllllllIIlllllIIlllIIlll) {
        this.func_177182_a(lllllllllllllllIIlllllIIlllIlllI, lllllllllllllllIIlllllIIlllIllIl, lllllllllllllllIIlllllIIllllIlIl, lllllllllllllllIIlllllIIlllIlIll, lllllllllllllllIIlllllIIlllIlIlI, lllllllllllllllIIlllllIIlllIlIIl, lllllllllllllllIIlllllIIlllIlIII, lllllllllllllllIIlllllIIlllIIlll, 4);
        this.func_177182_a(lllllllllllllllIIlllllIIlllIlllI, lllllllllllllllIIlllllIIlllIllIl, lllllllllllllllIIlllllIIllllIlIl, lllllllllllllllIIlllllIIlllIlIll, lllllllllllllllIIlllllIIlllIlIlI, lllllllllllllllIIlllllIIlllIlIIl, lllllllllllllllIIlllllIIlllIlIII, lllllllllllllllIIlllllIIlllIIlll, 3);
        this.func_177182_a(lllllllllllllllIIlllllIIlllIlllI, lllllllllllllllIIlllllIIlllIllIl, lllllllllllllllIIlllllIIllllIlIl, lllllllllllllllIIlllllIIlllIlIll, lllllllllllllllIIlllllIIlllIlIlI, lllllllllllllllIIlllllIIlllIlIIl, lllllllllllllllIIlllllIIlllIlIII, lllllllllllllllIIlllllIIlllIIlll, 2);
        this.func_177182_a(lllllllllllllllIIlllllIIlllIlllI, lllllllllllllllIIlllllIIlllIllIl, lllllllllllllllIIlllllIIllllIlIl, lllllllllllllllIIlllllIIlllIlIll, lllllllllllllllIIlllllIIlllIlIlI, lllllllllllllllIIlllllIIlllIlIIl, lllllllllllllllIIlllllIIlllIlIII, lllllllllllllllIIlllllIIlllIIlll, 1);
    }
    
    private ResourceLocation func_177178_a(final ItemArmor lllllllllllllllIIlllllIIIlIllIIl, final boolean lllllllllllllllIIlllllIIIlIlllIl, final String lllllllllllllllIIlllllIIIlIlllII) {
        final String lllllllllllllllIIlllllIIIlIllIll = String.format("textures/models/armor/%s_layer_%d%s.png", lllllllllllllllIIlllllIIIlIllIIl.getArmorMaterial().func_179242_c(), lllllllllllllllIIlllllIIIlIlllIl ? 2 : 1, (lllllllllllllllIIlllllIIIlIlllII == null) ? "" : String.format("_%s", lllllllllllllllIIlllllIIIlIlllII));
        ResourceLocation lllllllllllllllIIlllllIIIlIllIlI = LayerArmorBase.field_177191_j.get(lllllllllllllllIIlllllIIIlIllIll);
        if (lllllllllllllllIIlllllIIIlIllIlI == null) {
            lllllllllllllllIIlllllIIIlIllIlI = new ResourceLocation(lllllllllllllllIIlllllIIIlIllIll);
            LayerArmorBase.field_177191_j.put(lllllllllllllllIIlllllIIIlIllIll, lllllllllllllllIIlllllIIIlIllIlI);
        }
        return lllllllllllllllIIlllllIIIlIllIlI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public ModelBase func_177175_a(final int lllllllllllllllIIlllllIIlIIlllll) {
        return this.func_177180_b(lllllllllllllllIIlllllIIlIIlllll) ? this.field_177189_c : this.field_177186_d;
    }
    
    protected abstract void func_177179_a(final ModelBase p0, final int p1);
    
    static {
        __OBFID = "CL_00002428";
        field_177188_b = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        field_177191_j = Maps.newHashMap();
    }
    
    private void func_177182_a(final EntityLivingBase lllllllllllllllIIlllllIIlIllllII, final float lllllllllllllllIIlllllIIlIlllIll, final float lllllllllllllllIIlllllIIllIlIIII, final float lllllllllllllllIIlllllIIllIIllll, final float lllllllllllllllIIlllllIIlIlllIII, final float lllllllllllllllIIlllllIIlIllIlll, final float lllllllllllllllIIlllllIIlIllIllI, final float lllllllllllllllIIlllllIIlIllIlIl, final int lllllllllllllllIIlllllIIlIllIlII) {
        final ItemStack lllllllllllllllIIlllllIIllIIlIIl = this.func_177176_a(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIlIllIlII);
        if (lllllllllllllllIIlllllIIllIIlIIl != null && lllllllllllllllIIlllllIIllIIlIIl.getItem() instanceof ItemArmor) {
            final ItemArmor lllllllllllllllIIlllllIIllIIlIII = (ItemArmor)lllllllllllllllIIlllllIIllIIlIIl.getItem();
            ModelBase lllllllllllllllIIlllllIIllIIIlll = this.func_177175_a(lllllllllllllllIIlllllIIlIllIlII);
            lllllllllllllllIIlllllIIllIIIlll.setModelAttributes(this.field_177190_a.getMainModel());
            lllllllllllllllIIlllllIIllIIIlll.setLivingAnimations(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIllIIllll);
            if (Reflector.ForgeHooksClient_getArmorModel.exists()) {
                lllllllllllllllIIlllllIIllIIIlll = (ModelBase)Reflector.call(Reflector.ForgeHooksClient_getArmorModel, lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIllIIlIIl, lllllllllllllllIIlllllIIlIllIlII, lllllllllllllllIIlllllIIllIIIlll);
            }
            this.func_177179_a(lllllllllllllllIIlllllIIllIIIlll, lllllllllllllllIIlllllIIlIllIlII);
            final boolean lllllllllllllllIIlllllIIllIIIllI = this.func_177180_b(lllllllllllllllIIlllllIIlIllIlII);
            if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllllIIlllllIIllIIlIIl, lllllllllllllllIIlllllIIllIIIllI ? 2 : 1, null)) {
                if (Reflector.ForgeHooksClient_getArmorTexture.exists()) {
                    this.field_177190_a.bindTexture(this.getArmorResource(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIllIIlIIl, lllllllllllllllIIlllllIIllIIIllI ? 2 : 1, null));
                }
                else {
                    this.field_177190_a.bindTexture(this.func_177181_a(lllllllllllllllIIlllllIIllIIlIII, lllllllllllllllIIlllllIIllIIIllI));
                }
            }
            if (Reflector.ForgeHooksClient_getArmorTexture.exists()) {
                final int lllllllllllllllIIlllllIIllIIIlIl = lllllllllllllllIIlllllIIllIIlIII.getColor(lllllllllllllllIIlllllIIllIIlIIl);
                if (lllllllllllllllIIlllllIIllIIIlIl != -1) {
                    final float lllllllllllllllIIlllllIIllIIIIll = (lllllllllllllllIIlllllIIllIIIlIl >> 16 & 0xFF) / 255.0f;
                    final float lllllllllllllllIIlllllIIllIIIIIl = (lllllllllllllllIIlllllIIllIIIlIl >> 8 & 0xFF) / 255.0f;
                    final float lllllllllllllllIIlllllIIlIllllll = (lllllllllllllllIIlllllIIllIIIlIl & 0xFF) / 255.0f;
                    GlStateManager.color(this.field_177184_f * lllllllllllllllIIlllllIIllIIIIll, this.field_177185_g * lllllllllllllllIIlllllIIllIIIIIl, this.field_177192_h * lllllllllllllllIIlllllIIlIllllll, this.field_177187_e);
                    lllllllllllllllIIlllllIIllIIIlll.render(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIlIlllIII, lllllllllllllllIIlllllIIlIllIlll, lllllllllllllllIIlllllIIlIllIllI, lllllllllllllllIIlllllIIlIllIlIl);
                    if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllllIIlllllIIllIIlIIl, lllllllllllllllIIlllllIIllIIIllI ? 2 : 1, "overlay")) {
                        this.field_177190_a.bindTexture(this.getArmorResource(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIllIIlIIl, lllllllllllllllIIlllllIIllIIIllI ? 2 : 1, "overlay"));
                    }
                }
                GlStateManager.color(this.field_177184_f, this.field_177185_g, this.field_177192_h, this.field_177187_e);
                lllllllllllllllIIlllllIIllIIIlll.render(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIlIlllIII, lllllllllllllllIIlllllIIlIllIlll, lllllllllllllllIIlllllIIlIllIllI, lllllllllllllllIIlllllIIlIllIlIl);
                if (!this.field_177193_i && lllllllllllllllIIlllllIIllIIlIIl.isItemEnchanted() && (!Config.isCustomItems() || !CustomItems.renderCustomArmorEffect(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIllIIlIIl, lllllllllllllllIIlllllIIllIIIlll, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIllIIllll, lllllllllllllllIIlllllIIlIlllIII, lllllllllllllllIIlllllIIlIllIlll, lllllllllllllllIIlllllIIlIllIllI, lllllllllllllllIIlllllIIlIllIlIl))) {
                    this.func_177183_a(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIllIIIlll, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIllIIllll, lllllllllllllllIIlllllIIlIlllIII, lllllllllllllllIIlllllIIlIllIlll, lllllllllllllllIIlllllIIlIllIllI, lllllllllllllllIIlllllIIlIllIlIl);
                }
                return;
            }
            switch (SwitchArmorMaterial.field_178747_a[lllllllllllllllIIlllllIIllIIlIII.getArmorMaterial().ordinal()]) {
                case 1: {
                    final int lllllllllllllllIIlllllIIllIIIlII = lllllllllllllllIIlllllIIllIIlIII.getColor(lllllllllllllllIIlllllIIllIIlIIl);
                    final float lllllllllllllllIIlllllIIllIIIIlI = (lllllllllllllllIIlllllIIllIIIlII >> 16 & 0xFF) / 255.0f;
                    final float lllllllllllllllIIlllllIIllIIIIII = (lllllllllllllllIIlllllIIllIIIlII >> 8 & 0xFF) / 255.0f;
                    final float lllllllllllllllIIlllllIIlIlllllI = (lllllllllllllllIIlllllIIllIIIlII & 0xFF) / 255.0f;
                    GlStateManager.color(this.field_177184_f * lllllllllllllllIIlllllIIllIIIIlI, this.field_177185_g * lllllllllllllllIIlllllIIllIIIIII, this.field_177192_h * lllllllllllllllIIlllllIIlIlllllI, this.field_177187_e);
                    lllllllllllllllIIlllllIIllIIIlll.render(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIlIlllIII, lllllllllllllllIIlllllIIlIllIlll, lllllllllllllllIIlllllIIlIllIllI, lllllllllllllllIIlllllIIlIllIlIl);
                    if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllllIIlllllIIllIIlIIl, lllllllllllllllIIlllllIIllIIIllI ? 2 : 1, "overlay")) {
                        this.field_177190_a.bindTexture(this.func_177178_a(lllllllllllllllIIlllllIIllIIlIII, lllllllllllllllIIlllllIIllIIIllI, "overlay"));
                    }
                }
                case 2:
                case 3:
                case 4:
                case 5: {
                    GlStateManager.color(this.field_177184_f, this.field_177185_g, this.field_177192_h, this.field_177187_e);
                    lllllllllllllllIIlllllIIllIIIlll.render(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIlIlllIII, lllllllllllllllIIlllllIIlIllIlll, lllllllllllllllIIlllllIIlIllIllI, lllllllllllllllIIlllllIIlIllIlIl);
                    break;
                }
            }
            if (!this.field_177193_i && lllllllllllllllIIlllllIIllIIlIIl.isItemEnchanted() && (!Config.isCustomItems() || !CustomItems.renderCustomArmorEffect(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIllIIlIIl, lllllllllllllllIIlllllIIllIIIlll, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIllIIllll, lllllllllllllllIIlllllIIlIlllIII, lllllllllllllllIIlllllIIlIllIlll, lllllllllllllllIIlllllIIlIllIllI, lllllllllllllllIIlllllIIlIllIlIl))) {
                this.func_177183_a(lllllllllllllllIIlllllIIlIllllII, lllllllllllllllIIlllllIIllIIIlll, lllllllllllllllIIlllllIIlIlllIll, lllllllllllllllIIlllllIIllIlIIII, lllllllllllllllIIlllllIIllIIllll, lllllllllllllllIIlllllIIlIlllIII, lllllllllllllllIIlllllIIlIllIlll, lllllllllllllllIIlllllIIlIllIllI, lllllllllllllllIIlllllIIlIllIlIl);
            }
        }
    }
    
    public ResourceLocation getArmorResource(final Entity lllllllllllllllIIlllllIIIlIIlIIl, final ItemStack lllllllllllllllIIlllllIIIlIIlIII, final int lllllllllllllllIIlllllIIIIllllIl, final String lllllllllllllllIIlllllIIIlIIIllI) {
        final ItemArmor lllllllllllllllIIlllllIIIlIIIlIl = (ItemArmor)lllllllllllllllIIlllllIIIlIIlIII.getItem();
        String lllllllllllllllIIlllllIIIlIIIlII = ((ItemArmor)lllllllllllllllIIlllllIIIlIIlIII.getItem()).getArmorMaterial().func_179242_c();
        String lllllllllllllllIIlllllIIIlIIIIll = "minecraft";
        final int lllllllllllllllIIlllllIIIlIIIIlI = lllllllllllllllIIlllllIIIlIIIlII.indexOf(58);
        if (lllllllllllllllIIlllllIIIlIIIIlI != -1) {
            lllllllllllllllIIlllllIIIlIIIIll = lllllllllllllllIIlllllIIIlIIIlII.substring(0, lllllllllllllllIIlllllIIIlIIIIlI);
            lllllllllllllllIIlllllIIIlIIIlII = lllllllllllllllIIlllllIIIlIIIlII.substring(lllllllllllllllIIlllllIIIlIIIIlI + 1);
        }
        String lllllllllllllllIIlllllIIIlIIIIIl = String.format("%s:textures/models/armor/%s_layer_%d%s.png", lllllllllllllllIIlllllIIIlIIIIll, lllllllllllllllIIlllllIIIlIIIlII, (lllllllllllllllIIlllllIIIIllllIl == 2) ? 2 : 1, (lllllllllllllllIIlllllIIIlIIIllI == null) ? "" : String.format("_%s", lllllllllllllllIIlllllIIIlIIIllI));
        lllllllllllllllIIlllllIIIlIIIIIl = Reflector.callString(Reflector.ForgeHooksClient_getArmorTexture, lllllllllllllllIIlllllIIIlIIlIIl, lllllllllllllllIIlllllIIIlIIlIII, lllllllllllllllIIlllllIIIlIIIIIl, lllllllllllllllIIlllllIIIIllllIl, lllllllllllllllIIlllllIIIlIIIllI);
        ResourceLocation lllllllllllllllIIlllllIIIlIIIIII = LayerArmorBase.field_177191_j.get(lllllllllllllllIIlllllIIIlIIIIIl);
        if (lllllllllllllllIIlllllIIIlIIIIII == null) {
            lllllllllllllllIIlllllIIIlIIIIII = new ResourceLocation(lllllllllllllllIIlllllIIIlIIIIIl);
            LayerArmorBase.field_177191_j.put(lllllllllllllllIIlllllIIIlIIIIIl, lllllllllllllllIIlllllIIIlIIIIII);
        }
        return lllllllllllllllIIlllllIIIlIIIIII;
    }
    
    private void func_177183_a(final EntityLivingBase lllllllllllllllIIlllllIIlIIIlIlI, final ModelBase lllllllllllllllIIlllllIIIllllIlI, final float lllllllllllllllIIlllllIIIllllIIl, final float lllllllllllllllIIlllllIIIllllIII, final float lllllllllllllllIIlllllIIIlllIlll, final float lllllllllllllllIIlllllIIlIIIIlIl, final float lllllllllllllllIIlllllIIIlllIlIl, final float lllllllllllllllIIlllllIIIlllIlII, final float lllllllllllllllIIlllllIIIlllIIll) {
        if (!Config.isCustomItems() || CustomItems.isUseGlint()) {
            if (Config.isShaders()) {
                if (Shaders.isShadowPass) {
                    return;
                }
                ShadersRender.layerArmorBaseDrawEnchantedGlintBegin();
            }
            final float lllllllllllllllIIlllllIIlIIIIIIl = lllllllllllllllIIlllllIIlIIIlIlI.ticksExisted + lllllllllllllllIIlllllIIIlllIlll;
            this.field_177190_a.bindTexture(LayerArmorBase.field_177188_b);
            GlStateManager.enableBlend();
            GlStateManager.depthFunc(514);
            GlStateManager.depthMask(false);
            final float lllllllllllllllIIlllllIIlIIIIIII = 0.5f;
            GlStateManager.color(lllllllllllllllIIlllllIIlIIIIIII, lllllllllllllllIIlllllIIlIIIIIII, lllllllllllllllIIlllllIIlIIIIIII, 1.0f);
            for (int lllllllllllllllIIlllllIIIlllllll = 0; lllllllllllllllIIlllllIIIlllllll < 2; ++lllllllllllllllIIlllllIIIlllllll) {
                GlStateManager.disableLighting();
                GlStateManager.blendFunc(768, 1);
                final float lllllllllllllllIIlllllIIIllllllI = 0.76f;
                GlStateManager.color(0.5f * lllllllllllllllIIlllllIIIllllllI, 0.25f * lllllllllllllllIIlllllIIIllllllI, 0.8f * lllllllllllllllIIlllllIIIllllllI, 1.0f);
                GlStateManager.matrixMode(5890);
                GlStateManager.loadIdentity();
                final float lllllllllllllllIIlllllIIIlllllIl = 0.33333334f;
                GlStateManager.scale(lllllllllllllllIIlllllIIIlllllIl, lllllllllllllllIIlllllIIIlllllIl, lllllllllllllllIIlllllIIIlllllIl);
                GlStateManager.rotate(30.0f - lllllllllllllllIIlllllIIIlllllll * 60.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.translate(0.0f, lllllllllllllllIIlllllIIlIIIIIIl * (0.001f + lllllllllllllllIIlllllIIIlllllll * 0.003f) * 20.0f, 0.0f);
                GlStateManager.matrixMode(5888);
                lllllllllllllllIIlllllIIIllllIlI.render(lllllllllllllllIIlllllIIlIIIlIlI, lllllllllllllllIIlllllIIIllllIIl, lllllllllllllllIIlllllIIIllllIII, lllllllllllllllIIlllllIIlIIIIlIl, lllllllllllllllIIlllllIIIlllIlIl, lllllllllllllllIIlllllIIIlllIlII, lllllllllllllllIIlllllIIIlllIIll);
            }
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.depthFunc(515);
            GlStateManager.disableBlend();
            if (Config.isShaders()) {
                ShadersRender.layerArmorBaseDrawEnchantedGlintEnd();
            }
        }
    }
    
    protected abstract void func_177177_a();
    
    static final class SwitchArmorMaterial
    {
        static final /* synthetic */ int[] field_178747_a;
        
        static {
            __OBFID = "CL_00002427";
            field_178747_a = new int[ItemArmor.ArmorMaterial.values().length];
            try {
                SwitchArmorMaterial.field_178747_a[ItemArmor.ArmorMaterial.LEATHER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchArmorMaterial.field_178747_a[ItemArmor.ArmorMaterial.CHAIN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchArmorMaterial.field_178747_a[ItemArmor.ArmorMaterial.IRON.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchArmorMaterial.field_178747_a[ItemArmor.ArmorMaterial.GOLD.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchArmorMaterial.field_178747_a[ItemArmor.ArmorMaterial.DIAMOND.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
        }
    }
}
