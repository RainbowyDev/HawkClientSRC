package net.minecraft.client.model;

import net.minecraft.util.*;

public class PositionTextureVertex
{
    public /* synthetic */ float texturePositionY;
    public /* synthetic */ float texturePositionX;
    public /* synthetic */ Vec3 vector3D;
    
    public PositionTextureVertex(final Vec3 lllllllllllllllllllIIIlIlllllllI, final float lllllllllllllllllllIIIlIlllllIIl, final float lllllllllllllllllllIIIlIlllllIII) {
        this.vector3D = lllllllllllllllllllIIIlIlllllllI;
        this.texturePositionX = lllllllllllllllllllIIIlIlllllIIl;
        this.texturePositionY = lllllllllllllllllllIIIlIlllllIII;
    }
    
    public PositionTextureVertex(final PositionTextureVertex lllllllllllllllllllIIIllIIIIlIlI, final float lllllllllllllllllllIIIllIIIIIlIl, final float lllllllllllllllllllIIIllIIIIlIII) {
        this.vector3D = lllllllllllllllllllIIIllIIIIlIlI.vector3D;
        this.texturePositionX = lllllllllllllllllllIIIllIIIIIlIl;
        this.texturePositionY = lllllllllllllllllllIIIllIIIIlIII;
    }
    
    public PositionTextureVertex(final float lllllllllllllllllllIIIllIIlIIIll, final float lllllllllllllllllllIIIllIIIlllII, final float lllllllllllllllllllIIIllIIIllIll, final float lllllllllllllllllllIIIllIIIllIlI, final float lllllllllllllllllllIIIllIIIllIIl) {
        this(new Vec3(lllllllllllllllllllIIIllIIlIIIll, lllllllllllllllllllIIIllIIIlllII, lllllllllllllllllllIIIllIIIllIll), lllllllllllllllllllIIIllIIIllIlI, lllllllllllllllllllIIIllIIIllIIl);
    }
    
    public PositionTextureVertex setTexturePosition(final float lllllllllllllllllllIIIllIIIlIlII, final float lllllllllllllllllllIIIllIIIlIIII) {
        return new PositionTextureVertex(this, lllllllllllllllllllIIIllIIIlIlII, lllllllllllllllllllIIIllIIIlIIII);
    }
    
    static {
        __OBFID = "CL_00000862";
    }
}
