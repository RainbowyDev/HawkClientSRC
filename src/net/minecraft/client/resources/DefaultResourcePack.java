package net.minecraft.client.resources;

import java.util.*;
import net.minecraft.client.resources.data.*;
import java.io.*;
import net.minecraft.util.*;
import optifine.*;
import java.awt.image.*;
import net.minecraft.client.renderer.texture.*;
import com.google.common.collect.*;

public class DefaultResourcePack implements IResourcePack
{
    private final /* synthetic */ Map field_152781_b;
    public static final /* synthetic */ Set defaultResourceDomains;
    
    @Override
    public IMetadataSection getPackMetadata(final IMetadataSerializer llllllllllllllIIlllIllIllIlllIIl, final String llllllllllllllIIlllIllIllIlllIII) throws IOException {
        try {
            final FileInputStream llllllllllllllIIlllIllIllIllllIl = new FileInputStream(this.field_152781_b.get("pack.mcmeta"));
            return AbstractResourcePack.readMetadata(llllllllllllllIIlllIllIllIlllIIl, llllllllllllllIIlllIllIllIllllIl, llllllllllllllIIlllIllIllIlllIII);
        }
        catch (RuntimeException llllllllllllllIIlllIllIllIllllII) {
            return null;
        }
        catch (FileNotFoundException llllllllllllllIIlllIllIllIlllIll) {
            return null;
        }
    }
    
    @Override
    public Set getResourceDomains() {
        return DefaultResourcePack.defaultResourceDomains;
    }
    
    @Override
    public boolean resourceExists(final ResourceLocation llllllllllllllIIlllIllIlllIIlIII) {
        return this.getResourceStream(llllllllllllllIIlllIllIlllIIlIII) != null || this.field_152781_b.containsKey(llllllllllllllIIlllIllIlllIIlIII.toString());
    }
    
    private InputStream getResourceStream(final ResourceLocation llllllllllllllIIlllIllIlllIIlllI) {
        final String llllllllllllllIIlllIllIlllIlIIII = String.valueOf(new StringBuilder("/assets/").append(llllllllllllllIIlllIllIlllIIlllI.getResourceDomain()).append("/").append(llllllllllllllIIlllIllIlllIIlllI.getResourcePath()));
        final InputStream llllllllllllllIIlllIllIlllIIllll = ReflectorForge.getOptiFineResourceStream(llllllllllllllIIlllIllIlllIlIIII);
        return (llllllllllllllIIlllIllIlllIIllll != null) ? llllllllllllllIIlllIllIlllIIllll : DefaultResourcePack.class.getResourceAsStream(String.valueOf(new StringBuilder("/assets/").append(llllllllllllllIIlllIllIlllIIlllI.getResourceDomain()).append("/").append(llllllllllllllIIlllIllIlllIIlllI.getResourcePath())));
    }
    
    public InputStream func_152780_c(final ResourceLocation llllllllllllllIIlllIllIlllIllIlI) throws IOException {
        final File llllllllllllllIIlllIllIlllIllIIl = this.field_152781_b.get(llllllllllllllIIlllIllIlllIllIlI.toString());
        return (llllllllllllllIIlllIllIlllIllIIl != null && llllllllllllllIIlllIllIlllIllIIl.isFile()) ? new FileInputStream(llllllllllllllIIlllIllIlllIllIIl) : null;
    }
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtil.func_177053_a(DefaultResourcePack.class.getResourceAsStream(String.valueOf(new StringBuilder("/").append(new ResourceLocation("pack.png").getResourcePath()))));
    }
    
    @Override
    public InputStream getInputStream(final ResourceLocation llllllllllllllIIlllIllIllllIIIIl) throws IOException {
        final InputStream llllllllllllllIIlllIllIllllIIlII = this.getResourceStream(llllllllllllllIIlllIllIllllIIIIl);
        if (llllllllllllllIIlllIllIllllIIlII != null) {
            return llllllllllllllIIlllIllIllllIIlII;
        }
        final InputStream llllllllllllllIIlllIllIllllIIIll = this.func_152780_c(llllllllllllllIIlllIllIllllIIIIl);
        if (llllllllllllllIIlllIllIllllIIIll != null) {
            return llllllllllllllIIlllIllIllllIIIll;
        }
        throw new FileNotFoundException(llllllllllllllIIlllIllIllllIIIIl.getResourcePath());
    }
    
    @Override
    public String getPackName() {
        return "Default";
    }
    
    public DefaultResourcePack(final Map llllllllllllllIIlllIllIllllIlIll) {
        this.field_152781_b = llllllllllllllIIlllIllIllllIlIll;
    }
    
    static {
        __OBFID = "CL_00001073";
        defaultResourceDomains = (Set)ImmutableSet.of((Object)"minecraft", (Object)"realms");
    }
}
