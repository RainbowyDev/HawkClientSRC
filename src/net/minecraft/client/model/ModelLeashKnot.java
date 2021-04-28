package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelLeashKnot extends ModelBase
{
    public /* synthetic */ ModelRenderer field_110723_a;
    
    @Override
    public void render(final Entity llllllllllllllIIIIIllllIlIlllIII, final float llllllllllllllIIIIIllllIllIIIlII, final float llllllllllllllIIIIIllllIlIllIllI, final float llllllllllllllIIIIIllllIlIllIlIl, final float llllllllllllllIIIIIllllIlIllIlII, final float llllllllllllllIIIIIllllIlIllllII, final float llllllllllllllIIIIIllllIlIlllIlI) {
        this.setRotationAngles(llllllllllllllIIIIIllllIllIIIlII, llllllllllllllIIIIIllllIlIllIllI, llllllllllllllIIIIIllllIlIllIlIl, llllllllllllllIIIIIllllIlIllIlII, llllllllllllllIIIIIllllIlIllllII, llllllllllllllIIIIIllllIlIlllIlI, llllllllllllllIIIIIllllIlIlllIII);
        this.field_110723_a.render(llllllllllllllIIIIIllllIlIlllIlI);
    }
    
    static {
        __OBFID = "CL_00000843";
    }
    
    public ModelLeashKnot() {
        this(0, 0, 32, 32);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIIIllllIlIIlllII, final float llllllllllllllIIIIIllllIlIIllIll, final float llllllllllllllIIIIIllllIlIIIlllI, final float llllllllllllllIIIIIllllIlIIllIII, final float llllllllllllllIIIIIllllIlIIlIllI, final float llllllllllllllIIIIIllllIlIIlIlIl, final Entity llllllllllllllIIIIIllllIlIIIlIIl) {
        super.setRotationAngles(llllllllllllllIIIIIllllIlIIlllII, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIlllI, llllllllllllllIIIIIllllIlIIllIII, llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIIlIIl);
        this.field_110723_a.rotateAngleY = llllllllllllllIIIIIllllIlIIllIII / 57.295776f;
        this.field_110723_a.rotateAngleX = llllllllllllllIIIIIllllIlIIlIllI / 57.295776f;
    }
    
    public ModelLeashKnot(final int llllllllllllllIIIIIllllIlllIIIlI, final int llllllllllllllIIIIIllllIllIllIIl, final int llllllllllllllIIIIIllllIllIllIII, final int llllllllllllllIIIIIllllIllIlIlll) {
        this.textureWidth = llllllllllllllIIIIIllllIllIllIII;
        this.textureHeight = llllllllllllllIIIIIllllIllIlIlll;
        this.field_110723_a = new ModelRenderer(this, llllllllllllllIIIIIllllIlllIIIlI, llllllllllllllIIIIIllllIllIllIIl);
        this.field_110723_a.addBox(-3.0f, -6.0f, -3.0f, 6, 8, 6, 0.0f);
        this.field_110723_a.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
}
