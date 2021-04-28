package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;

public class LayerBipedArmor extends LayerArmorBase
{
    @Override
    protected void func_177177_a() {
        this.field_177189_c = new ModelBiped(0.5f);
        this.field_177186_d = new ModelBiped(1.0f);
    }
    
    public LayerBipedArmor(final RendererLivingEntity llllllllllllllIlIllllIIIlIllllll) {
        super(llllllllllllllIlIllllIIIlIllllll);
    }
    
    @Override
    protected void func_177179_a(final ModelBase llllllllllllllIlIllllIIIlIlIIlIl, final int llllllllllllllIlIllllIIIlIlIIlll) {
        this.func_177195_a((ModelBiped)llllllllllllllIlIllllIIIlIlIIlIl, llllllllllllllIlIllllIIIlIlIIlll);
    }
    
    protected void func_177195_a(final ModelBiped llllllllllllllIlIllllIIIlIllIlIl, final int llllllllllllllIlIllllIIIlIllIlII) {
        this.func_177194_a(llllllllllllllIlIllllIIIlIllIlIl);
        switch (llllllllllllllIlIllllIIIlIllIlII) {
            case 1: {
                llllllllllllllIlIllllIIIlIllIlIl.bipedRightLeg.showModel = true;
                llllllllllllllIlIllllIIIlIllIlIl.bipedLeftLeg.showModel = true;
                break;
            }
            case 2: {
                llllllllllllllIlIllllIIIlIllIlIl.bipedBody.showModel = true;
                llllllllllllllIlIllllIIIlIllIlIl.bipedRightLeg.showModel = true;
                llllllllllllllIlIllllIIIlIllIlIl.bipedLeftLeg.showModel = true;
                break;
            }
            case 3: {
                llllllllllllllIlIllllIIIlIllIlIl.bipedBody.showModel = true;
                llllllllllllllIlIllllIIIlIllIlIl.bipedRightArm.showModel = true;
                llllllllllllllIlIllllIIIlIllIlIl.bipedLeftArm.showModel = true;
                break;
            }
            case 4: {
                llllllllllllllIlIllllIIIlIllIlIl.bipedHead.showModel = true;
                llllllllllllllIlIllllIIIlIllIlIl.bipedHeadwear.showModel = true;
                break;
            }
        }
    }
    
    protected void func_177194_a(final ModelBiped llllllllllllllIlIllllIIIlIlIlllI) {
        llllllllllllllIlIllllIIIlIlIlllI.func_178719_a(false);
    }
    
    static {
        __OBFID = "CL_00002417";
    }
}
