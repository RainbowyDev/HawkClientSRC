package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderZombie extends RenderBiped
{
    private static final /* synthetic */ ResourceLocation zombieTextures;
    private final /* synthetic */ List field_177122_o;
    private final /* synthetic */ ModelZombieVillager zombieVillagerModel;
    private final /* synthetic */ List field_177121_n;
    private final /* synthetic */ ModelBiped field_82434_o;
    private static final /* synthetic */ ResourceLocation zombieVillagerTextures;
    
    private void func_82427_a(final EntityZombie lllllllllllllllIIlIlIlllIlllIlll) {
        if (lllllllllllllllIIlIlIlllIlllIlll.isVillager()) {
            this.mainModel = this.zombieVillagerModel;
            this.field_177097_h = this.field_177121_n;
        }
        else {
            this.mainModel = this.field_82434_o;
            this.field_177097_h = this.field_177122_o;
        }
        this.modelBipedMain = (ModelBiped)this.mainModel;
    }
    
    @Override
    public void doRender(final EntityLiving lllllllllllllllIIlIlIlllIlIlIIII, final double lllllllllllllllIIlIlIlllIlIlIllI, final double lllllllllllllllIIlIlIlllIlIIlllI, final double lllllllllllllllIIlIlIlllIlIIllIl, final float lllllllllllllllIIlIlIlllIlIIllII, final float lllllllllllllllIIlIlIlllIlIlIIlI) {
        this.func_180579_a((EntityZombie)lllllllllllllllIIlIlIlllIlIlIIII, lllllllllllllllIIlIlIlllIlIlIllI, lllllllllllllllIIlIlIlllIlIIlllI, lllllllllllllllIIlIlIlllIlIIllIl, lllllllllllllllIIlIlIlllIlIIllII, lllllllllllllllIIlIlIlllIlIlIIlI);
    }
    
    @Override
    protected void rotateCorpse(final EntityLivingBase lllllllllllllllIIlIlIlllIIllllll, final float lllllllllllllllIIlIlIlllIIlllllI, final float lllllllllllllllIIlIlIlllIlIIIIlI, final float lllllllllllllllIIlIlIlllIIllllII) {
        this.rotateCorpse((EntityZombie)lllllllllllllllIIlIlIlllIIllllll, lllllllllllllllIIlIlIlllIIlllllI, lllllllllllllllIIlIlIlllIlIIIIlI, lllllllllllllllIIlIlIlllIIllllII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLiving lllllllllllllllIIlIlIlllIllIIIlI) {
        return this.func_180578_a((EntityZombie)lllllllllllllllIIlIlIlllIllIIIlI);
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIIlIlIlllIIIllIII, final double lllllllllllllllIIlIlIlllIIIlIIII, final double lllllllllllllllIIlIlIlllIIIIllll, final double lllllllllllllllIIlIlIlllIIIlIlIl, final float lllllllllllllllIIlIlIlllIIIlIlII, final float lllllllllllllllIIlIlIlllIIIIllII) {
        this.func_180579_a((EntityZombie)lllllllllllllllIIlIlIlllIIIllIII, lllllllllllllllIIlIlIlllIIIlIIII, lllllllllllllllIIlIlIlllIIIIllll, lllllllllllllllIIlIlIlllIIIlIlIl, lllllllllllllllIIlIlIlllIIIlIlII, lllllllllllllllIIlIlIlllIIIIllII);
    }
    
    protected void rotateCorpse(final EntityZombie lllllllllllllllIIlIlIlllIllIlllI, final float lllllllllllllllIIlIlIlllIllIllIl, float lllllllllllllllIIlIlIlllIllIIlll, final float lllllllllllllllIIlIlIlllIllIIllI) {
        if (lllllllllllllllIIlIlIlllIllIlllI.isConverting()) {
            lllllllllllllllIIlIlIlllIllIIlll += (float)(Math.cos(lllllllllllllllIIlIlIlllIllIlllI.ticksExisted * 3.25) * 3.141592653589793 * 0.25);
        }
        super.rotateCorpse(lllllllllllllllIIlIlIlllIllIlllI, lllllllllllllllIIlIlIlllIllIllIl, lllllllllllllllIIlIlIlllIllIIlll, lllllllllllllllIIlIlIlllIllIIllI);
    }
    
    public RenderZombie(final RenderManager lllllllllllllllIIlIlIllllIIllIlI) {
        super(lllllllllllllllIIlIlIllllIIllIlI, new ModelZombie(), 0.5f, 1.0f);
        final LayerRenderer lllllllllllllllIIlIlIllllIIllIIl = this.field_177097_h.get(0);
        this.field_82434_o = this.modelBipedMain;
        this.zombieVillagerModel = new ModelZombieVillager();
        this.addLayer(new LayerHeldItem(this));
        final LayerBipedArmor lllllllllllllllIIlIlIllllIIllIII = new LayerBipedArmor(this) {
            @Override
            protected void func_177177_a() {
                this.field_177189_c = new ModelZombie(0.5f, true);
                this.field_177186_d = new ModelZombie(1.0f, true);
            }
            
            static {
                __OBFID = "CL_00002429";
            }
        };
        this.addLayer(lllllllllllllllIIlIlIllllIIllIII);
        this.field_177122_o = Lists.newArrayList((Iterable)this.field_177097_h);
        if (lllllllllllllllIIlIlIllllIIllIIl instanceof LayerCustomHead) {
            this.func_177089_b(lllllllllllllllIIlIlIllllIIllIIl);
            this.addLayer(new LayerCustomHead(this.zombieVillagerModel.bipedHead));
        }
        this.func_177089_b(lllllllllllllllIIlIlIllllIIllIII);
        this.addLayer(new LayerVillagerArmor(this));
        this.field_177121_n = Lists.newArrayList((Iterable)this.field_177097_h);
    }
    
    @Override
    public void doRender(final EntityLivingBase lllllllllllllllIIlIlIlllIIlIllII, final double lllllllllllllllIIlIlIlllIIlIlIll, final double lllllllllllllllIIlIlIlllIIllIIIl, final double lllllllllllllllIIlIlIlllIIlIlIIl, final float lllllllllllllllIIlIlIlllIIlIllll, final float lllllllllllllllIIlIlIlllIIlIIlll) {
        this.func_180579_a((EntityZombie)lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll, lllllllllllllllIIlIlIlllIIllIIIl, lllllllllllllllIIlIlIlllIIlIlIIl, lllllllllllllllIIlIlIlllIIlIllll, lllllllllllllllIIlIlIlllIIlIIlll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIlIlIlllIIlIIIIl) {
        return this.func_180578_a((EntityZombie)lllllllllllllllIIlIlIlllIIlIIIIl);
    }
    
    static {
        __OBFID = "CL_00001037";
        zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");
        zombieVillagerTextures = new ResourceLocation("textures/entity/zombie/zombie_villager.png");
    }
    
    protected ResourceLocation func_180578_a(final EntityZombie lllllllllllllllIIlIlIlllIlllllII) {
        return lllllllllllllllIIlIlIlllIlllllII.isVillager() ? RenderZombie.zombieVillagerTextures : RenderZombie.zombieTextures;
    }
    
    public void func_180579_a(final EntityZombie lllllllllllllllIIlIlIllllIIIIlII, final double lllllllllllllllIIlIlIllllIIIIIll, final double lllllllllllllllIIlIlIllllIIIlIIl, final double lllllllllllllllIIlIlIllllIIIlIII, final float lllllllllllllllIIlIlIllllIIIIIII, final float lllllllllllllllIIlIlIllllIIIIllI) {
        this.func_82427_a(lllllllllllllllIIlIlIllllIIIIlII);
        super.doRender(lllllllllllllllIIlIlIllllIIIIlII, lllllllllllllllIIlIlIllllIIIIIll, lllllllllllllllIIlIlIllllIIIlIIl, lllllllllllllllIIlIlIllllIIIlIII, lllllllllllllllIIlIlIllllIIIIIII, lllllllllllllllIIlIlIllllIIIIllI);
    }
}
