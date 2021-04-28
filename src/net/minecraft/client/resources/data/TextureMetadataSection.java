package net.minecraft.client.resources.data;

import java.util.*;

public class TextureMetadataSection implements IMetadataSection
{
    private final /* synthetic */ boolean textureBlur;
    private final /* synthetic */ List listMipmaps;
    private final /* synthetic */ boolean textureClamp;
    
    static {
        __OBFID = "CL_00001114";
    }
    
    public List getListMipmaps() {
        return Collections.unmodifiableList((List<?>)this.listMipmaps);
    }
    
    public boolean getTextureClamp() {
        return this.textureClamp;
    }
    
    public boolean getTextureBlur() {
        return this.textureBlur;
    }
    
    public TextureMetadataSection(final boolean llllllllllllllIIllllllIlllIIIIIl, final boolean llllllllllllllIIllllllIlllIIIIII, final List llllllllllllllIIllllllIllIllllll) {
        this.textureBlur = llllllllllllllIIllllllIlllIIIIIl;
        this.textureClamp = llllllllllllllIIllllllIlllIIIIII;
        this.listMipmaps = llllllllllllllIIllllllIllIllllll;
    }
}
