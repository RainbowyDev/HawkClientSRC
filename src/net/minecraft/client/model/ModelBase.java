package net.minecraft.client.model;

import com.google.common.collect.*;
import java.util.*;
import net.minecraft.entity.*;

public abstract class ModelBase
{
    public /* synthetic */ int textureWidth;
    public /* synthetic */ float swingProgress;
    private /* synthetic */ Map modelTextureMap;
    public /* synthetic */ boolean isRiding;
    public /* synthetic */ int textureHeight;
    public /* synthetic */ List boxList;
    public /* synthetic */ boolean isChild;
    
    public static void func_178685_a(final ModelRenderer lllllllllllllllllIlIIllIlIlllIlI, final ModelRenderer lllllllllllllllllIlIIllIlIlllIll) {
        lllllllllllllllllIlIIllIlIlllIll.rotateAngleX = lllllllllllllllllIlIIllIlIlllIlI.rotateAngleX;
        lllllllllllllllllIlIIllIlIlllIll.rotateAngleY = lllllllllllllllllIlIIllIlIlllIlI.rotateAngleY;
        lllllllllllllllllIlIIllIlIlllIll.rotateAngleZ = lllllllllllllllllIlIIllIlIlllIlI.rotateAngleZ;
        lllllllllllllllllIlIIllIlIlllIll.rotationPointX = lllllllllllllllllIlIIllIlIlllIlI.rotationPointX;
        lllllllllllllllllIlIIllIlIlllIll.rotationPointY = lllllllllllllllllIlIIllIlIlllIlI.rotationPointY;
        lllllllllllllllllIlIIllIlIlllIll.rotationPointZ = lllllllllllllllllIlIIllIlIlllIlI.rotationPointZ;
    }
    
    public void setModelAttributes(final ModelBase lllllllllllllllllIlIIllIlIlIlllI) {
        this.swingProgress = lllllllllllllllllIlIIllIlIlIlllI.swingProgress;
        this.isRiding = lllllllllllllllllIlIIllIlIlIlllI.isRiding;
        this.isChild = lllllllllllllllllIlIIllIlIlIlllI.isChild;
    }
    
    protected void setTextureOffset(final String lllllllllllllllllIlIIllIllIIIlll, final int lllllllllllllllllIlIIllIllIIlIlI, final int lllllllllllllllllIlIIllIllIIlIIl) {
        this.modelTextureMap.put(lllllllllllllllllIlIIllIllIIIlll, new TextureOffset(lllllllllllllllllIlIIllIllIIlIlI, lllllllllllllllllIlIIllIllIIlIIl));
    }
    
    public TextureOffset getTextureOffset(final String lllllllllllllllllIlIIllIlIllllll) {
        return this.modelTextureMap.get(lllllllllllllllllIlIIllIlIllllll);
    }
    
    public ModelBase() {
        this.isChild = true;
        this.boxList = Lists.newArrayList();
        this.modelTextureMap = Maps.newHashMap();
        this.textureWidth = 64;
        this.textureHeight = 32;
    }
    
    public void render(final Entity lllllllllllllllllIlIIllIlllIllII, final float lllllllllllllllllIlIIllIlllIlIll, final float lllllllllllllllllIlIIllIlllIlIlI, final float lllllllllllllllllIlIIllIlllIlIIl, final float lllllllllllllllllIlIIllIlllIlIII, final float lllllllllllllllllIlIIllIlllIIlll, final float lllllllllllllllllIlIIllIlllIIllI) {
    }
    
    public ModelRenderer getRandomModelBox(final Random lllllllllllllllllIlIIllIllIlIIll) {
        return this.boxList.get(lllllllllllllllllIlIIllIllIlIIll.nextInt(this.boxList.size()));
    }
    
    public void setRotationAngles(final float lllllllllllllllllIlIIllIlllIIlII, final float lllllllllllllllllIlIIllIlllIIIll, final float lllllllllllllllllIlIIllIlllIIIlI, final float lllllllllllllllllIlIIllIlllIIIIl, final float lllllllllllllllllIlIIllIlllIIIII, final float lllllllllllllllllIlIIllIllIlllll, final Entity lllllllllllllllllIlIIllIllIllllI) {
    }
    
    public void setLivingAnimations(final EntityLivingBase lllllllllllllllllIlIIllIllIlllII, final float lllllllllllllllllIlIIllIllIllIll, final float lllllllllllllllllIlIIllIllIllIlI, final float lllllllllllllllllIlIIllIllIllIIl) {
    }
    
    static {
        __OBFID = "CL_00000845";
    }
}
