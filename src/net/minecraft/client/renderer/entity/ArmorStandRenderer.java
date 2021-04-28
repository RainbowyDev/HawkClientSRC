package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.*;

public class ArmorStandRenderer extends RendererLivingEntity
{
    public static final /* synthetic */ ResourceLocation field_177103_a;
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllllIIlllIIllllIIII) {
        return this.func_177102_a((EntityArmorStand)lllllllllllllllllIIlllIIllllIIII);
    }
    
    @Override
    protected void rotateCorpse(final EntityLivingBase lllllllllllllllllIIlllIlIIIIIIIl, final float lllllllllllllllllIIlllIIlllllIll, final float lllllllllllllllllIIlllIIllllllll, final float lllllllllllllllllIIlllIIlllllIIl) {
        this.func_177101_a((EntityArmorStand)lllllllllllllllllIIlllIlIIIIIIIl, lllllllllllllllllIIlllIIlllllIll, lllllllllllllllllIIlllIIllllllll, lllllllllllllllllIIlllIIlllllIIl);
    }
    
    protected ResourceLocation func_177102_a(final EntityArmorStand lllllllllllllllllIIlllIlIIIlllII) {
        return ArmorStandRenderer.field_177103_a;
    }
    
    static {
        __OBFID = "CL_00002447";
        field_177103_a = new ResourceLocation("textures/entity/armorstand/wood.png");
    }
    
    @Override
    public ModelBase getMainModel() {
        return this.func_177100_a();
    }
    
    protected boolean func_177099_b(final EntityArmorStand lllllllllllllllllIIlllIlIIIIlllI) {
        return lllllllllllllllllIIlllIlIIIIlllI.getAlwaysRenderNameTag();
    }
    
    @Override
    protected boolean canRenderName(final EntityLivingBase lllllllllllllllllIIlllIlIIIIlIII) {
        return this.func_177099_b((EntityArmorStand)lllllllllllllllllIIlllIlIIIIlIII);
    }
    
    public ArmorStandRenderer(final RenderManager lllllllllllllllllIIlllIlIIlIIIlI) {
        super(lllllllllllllllllIIlllIlIIlIIIlI, new ModelArmorStand(), 0.0f);
        final LayerBipedArmor lllllllllllllllllIIlllIlIIlIIIIl = new LayerBipedArmor(this) {
            @Override
            protected void func_177177_a() {
                this.field_177189_c = new ModelArmorStandArmor(0.5f);
                this.field_177186_d = new ModelArmorStandArmor(1.0f);
            }
            
            static {
                __OBFID = "CL_00002446";
            }
        };
        this.addLayer(lllllllllllllllllIIlllIlIIlIIIIl);
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerCustomHead(this.func_177100_a().bipedHead));
    }
    
    public ModelArmorStand func_177100_a() {
        return (ModelArmorStand)super.getMainModel();
    }
    
    @Override
    protected boolean func_177070_b(final Entity lllllllllllllllllIIlllIIlllIlIlI) {
        return this.func_177099_b((EntityArmorStand)lllllllllllllllllIIlllIIlllIlIlI);
    }
    
    protected void func_177101_a(final EntityArmorStand lllllllllllllllllIIlllIlIIIlIllI, final float lllllllllllllllllIIlllIlIIIlIlIl, final float lllllllllllllllllIIlllIlIIIlIlII, final float lllllllllllllllllIIlllIlIIIlIIll) {
        GlStateManager.rotate(180.0f - lllllllllllllllllIIlllIlIIIlIlII, 0.0f, 1.0f, 0.0f);
    }
}
