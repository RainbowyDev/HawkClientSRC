package net.minecraft.client.model;

public class ModelPig extends ModelQuadruped
{
    public ModelPig(final float lllllllllllllllIlIllIlIIllIIlIIl) {
        super(6, lllllllllllllllIlIllIlIIllIIlIIl);
        this.head.setTextureOffset(16, 16).addBox(-2.0f, 0.0f, -9.0f, 4, 3, 1, lllllllllllllllIlIllIlIIllIIlIIl);
        this.childYOffset = 4.0f;
    }
    
    static {
        __OBFID = "CL_00000849";
    }
    
    public ModelPig() {
        this(0.0f);
    }
}
