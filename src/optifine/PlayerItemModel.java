package optifine;

import net.minecraft.util.*;
import java.awt.*;
import java.awt.image.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.model.*;

public class PlayerItemModel
{
    private /* synthetic */ ResourceLocation locationMissing;
    private /* synthetic */ ResourceLocation textureLocation;
    private /* synthetic */ PlayerItemRenderer[] modelRenderers;
    private /* synthetic */ DynamicTexture texture;
    private /* synthetic */ Dimension textureSize;
    private /* synthetic */ boolean usePlayerTexture;
    private /* synthetic */ BufferedImage textureImage;
    
    public void render(final ModelBiped llllllllllllllIlIlIlIIlIIlIIIIlI, final AbstractClientPlayer llllllllllllllIlIlIlIIlIIlIIIIII, final float llllllllllllllIlIlIlIIlIIIllIlIl, final float llllllllllllllIlIlIlIIlIIIllllII) {
        final TextureManager llllllllllllllIlIlIlIIlIIIlllIll = Config.getTextureManager();
        if (this.usePlayerTexture) {
            llllllllllllllIlIlIlIIlIIIlllIll.bindTexture(llllllllllllllIlIlIlIIlIIlIIIIII.getLocationSkin());
        }
        else if (this.textureLocation != null) {
            if (this.texture == null && this.textureImage != null) {
                this.texture = new DynamicTexture(this.textureImage);
                Minecraft.getMinecraft().getTextureManager().loadTexture(this.textureLocation, this.texture);
            }
            llllllllllllllIlIlIlIIlIIIlllIll.bindTexture(this.textureLocation);
        }
        else {
            llllllllllllllIlIlIlIIlIIIlllIll.bindTexture(this.locationMissing);
        }
        for (int llllllllllllllIlIlIlIIlIIIlllIlI = 0; llllllllllllllIlIlIlIIlIIIlllIlI < this.modelRenderers.length; ++llllllllllllllIlIlIlIIlIIIlllIlI) {
            final PlayerItemRenderer llllllllllllllIlIlIlIIlIIIlllIIl = this.modelRenderers[llllllllllllllIlIlIlIIlIIIlllIlI];
            GlStateManager.pushMatrix();
            if (llllllllllllllIlIlIlIIlIIlIIIIII.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            llllllllllllllIlIlIlIIlIIIlllIIl.render(llllllllllllllIlIlIlIIlIIlIIIIlI, llllllllllllllIlIlIlIIlIIIllIlIl);
            GlStateManager.popMatrix();
        }
    }
    
    public BufferedImage getTextureImage() {
        return this.textureImage;
    }
    
    public void setTextureLocation(final ResourceLocation llllllllllllllIlIlIlIIlIIIIIIlII) {
        this.textureLocation = llllllllllllllIlIlIlIIlIIIIIIlII;
    }
    
    public static ModelRenderer getAttachModel(final ModelBiped llllllllllllllIlIlIlIIlIIIlIlIII, final int llllllllllllllIlIlIlIIlIIIlIIllI) {
        switch (llllllllllllllIlIlIlIIlIIIlIIllI) {
            case 0: {
                return llllllllllllllIlIlIlIIlIIIlIlIII.bipedBody;
            }
            case 1: {
                return llllllllllllllIlIlIlIIlIIIlIlIII.bipedHead;
            }
            case 2: {
                return llllllllllllllIlIlIlIIlIIIlIlIII.bipedLeftArm;
            }
            case 3: {
                return llllllllllllllIlIlIlIIlIIIlIlIII.bipedRightArm;
            }
            case 4: {
                return llllllllllllllIlIlIlIIlIIIlIlIII.bipedLeftLeg;
            }
            case 5: {
                return llllllllllllllIlIlIlIIlIIIlIlIII.bipedRightLeg;
            }
            default: {
                return null;
            }
        }
    }
    
    public void setTextureImage(final BufferedImage llllllllllllllIlIlIlIIlIIIIlIlIl) {
        this.textureImage = llllllllllllllIlIlIlIIlIIIIlIlIl;
    }
    
    public PlayerItemModel(final Dimension llllllllllllllIlIlIlIIlIIllIIIlI, final boolean llllllllllllllIlIlIlIIlIIllIIIIl, final PlayerItemRenderer[] llllllllllllllIlIlIlIIlIIllIIlII) {
        this.textureSize = null;
        this.usePlayerTexture = false;
        this.modelRenderers = new PlayerItemRenderer[0];
        this.textureLocation = null;
        this.textureImage = null;
        this.texture = null;
        this.locationMissing = new ResourceLocation("textures/blocks/wool_colored_red.png");
        this.textureSize = llllllllllllllIlIlIlIIlIIllIIIlI;
        this.usePlayerTexture = llllllllllllllIlIlIlIIlIIllIIIIl;
        this.modelRenderers = llllllllllllllIlIlIlIIlIIllIIlII;
    }
    
    public boolean isUsePlayerTexture() {
        return this.usePlayerTexture;
    }
    
    public DynamicTexture getTexture() {
        return this.texture;
    }
    
    static {
        ATTACH_BODY = 0;
        ATTACH_HEAD = 1;
        ATTACH_LEFT_ARM = 2;
        ATTACH_LEFT_LEG = 4;
        ATTACH_CAPE = 6;
        ATTACH_RIGHT_ARM = 3;
        ATTACH_RIGHT_LEG = 5;
    }
    
    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }
}
