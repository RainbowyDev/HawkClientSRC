package net.minecraft.client.renderer.texture;

import java.awt.image.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.resources.*;
import java.io.*;

public class DynamicTexture extends AbstractTexture
{
    private final /* synthetic */ int[] dynamicTextureData;
    private /* synthetic */ boolean shadersInitialized;
    private final /* synthetic */ int height;
    private final /* synthetic */ int width;
    
    public DynamicTexture(final BufferedImage lllllllllllllIlllllllIIlllIlIIlI) {
        this(lllllllllllllIlllllllIIlllIlIIlI.getWidth(), lllllllllllllIlllllllIIlllIlIIlI.getHeight());
        lllllllllllllIlllllllIIlllIlIIlI.getRGB(0, 0, lllllllllllllIlllllllIIlllIlIIlI.getWidth(), lllllllllllllIlllllllIIlllIlIIlI.getHeight(), this.dynamicTextureData, 0, lllllllllllllIlllllllIIlllIlIIlI.getWidth());
        this.updateDynamicTexture();
    }
    
    public int[] getTextureData() {
        return this.dynamicTextureData;
    }
    
    public DynamicTexture(final int lllllllllllllIlllllllIIlllIIlIlI, final int lllllllllllllIlllllllIIlllIIlIIl) {
        this.shadersInitialized = false;
        this.width = lllllllllllllIlllllllIIlllIIlIlI;
        this.height = lllllllllllllIlllllllIIlllIIlIIl;
        this.dynamicTextureData = new int[lllllllllllllIlllllllIIlllIIlIlI * lllllllllllllIlllllllIIlllIIlIIl * 3];
        if (Config.isShaders()) {
            ShadersTex.initDynamicTexture(this.getGlTextureId(), lllllllllllllIlllllllIIlllIIlIlI, lllllllllllllIlllllllIIlllIIlIIl, this);
            this.shadersInitialized = true;
        }
        else {
            TextureUtil.allocateTexture(this.getGlTextureId(), lllllllllllllIlllllllIIlllIIlIlI, lllllllllllllIlllllllIIlllIIlIIl);
        }
    }
    
    public void updateDynamicTexture() {
        if (Config.isShaders()) {
            if (!this.shadersInitialized) {
                ShadersTex.initDynamicTexture(this.getGlTextureId(), this.width, this.height, this);
                this.shadersInitialized = true;
            }
            ShadersTex.updateDynamicTexture(this.getGlTextureId(), this.dynamicTextureData, this.width, this.height, this);
        }
        else {
            TextureUtil.uploadTexture(this.getGlTextureId(), this.dynamicTextureData, this.width, this.height);
        }
    }
    
    static {
        __OBFID = "CL_00001048";
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllIlllllllIIlllIIIlll) throws IOException {
    }
}
