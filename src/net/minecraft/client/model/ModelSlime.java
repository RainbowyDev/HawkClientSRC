package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelSlime extends ModelBase
{
    /* synthetic */ ModelRenderer slimeBodies;
    /* synthetic */ ModelRenderer slimeLeftEye;
    /* synthetic */ ModelRenderer slimeRightEye;
    /* synthetic */ ModelRenderer slimeMouth;
    
    @Override
    public void render(final Entity llllllllllllllllIlllIllllIIlIIII, final float llllllllllllllllIlllIllllIIIIlll, final float llllllllllllllllIlllIllllIIIlllI, final float llllllllllllllllIlllIllllIIIIlIl, final float llllllllllllllllIlllIllllIIIIlII, final float llllllllllllllllIlllIllllIIIlIll, final float llllllllllllllllIlllIllllIIIlIlI) {
        this.setRotationAngles(llllllllllllllllIlllIllllIIIIlll, llllllllllllllllIlllIllllIIIlllI, llllllllllllllllIlllIllllIIIIlIl, llllllllllllllllIlllIllllIIIIlII, llllllllllllllllIlllIllllIIIlIll, llllllllllllllllIlllIllllIIIlIlI, llllllllllllllllIlllIllllIIlIIII);
        this.slimeBodies.render(llllllllllllllllIlllIllllIIIlIlI);
        if (this.slimeRightEye != null) {
            this.slimeRightEye.render(llllllllllllllllIlllIllllIIIlIlI);
            this.slimeLeftEye.render(llllllllllllllllIlllIllllIIIlIlI);
            this.slimeMouth.render(llllllllllllllllIlllIllllIIIlIlI);
        }
    }
    
    static {
        __OBFID = "CL_00000858";
    }
    
    public ModelSlime(final int llllllllllllllllIlllIllllIIlllII) {
        this.slimeBodies = new ModelRenderer(this, 0, llllllllllllllllIlllIllllIIlllII);
        this.slimeBodies.addBox(-4.0f, 16.0f, -4.0f, 8, 8, 8);
        if (llllllllllllllllIlllIllllIIlllII > 0) {
            this.slimeBodies = new ModelRenderer(this, 0, llllllllllllllllIlllIllllIIlllII);
            this.slimeBodies.addBox(-3.0f, 17.0f, -3.0f, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer(this, 32, 0);
            this.slimeRightEye.addBox(-3.25f, 18.0f, -3.5f, 2, 2, 2);
            this.slimeLeftEye = new ModelRenderer(this, 32, 4);
            this.slimeLeftEye.addBox(1.25f, 18.0f, -3.5f, 2, 2, 2);
            this.slimeMouth = new ModelRenderer(this, 32, 8);
            this.slimeMouth.addBox(0.0f, 21.0f, -3.5f, 1, 1, 1);
        }
    }
}
