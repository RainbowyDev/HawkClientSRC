package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import java.awt.image.*;
import net.minecraft.client.renderer.texture.*;
import com.google.common.base.*;
import java.io.*;
import org.apache.commons.io.*;
import com.google.gson.*;

public abstract class AbstractResourcePack implements IResourcePack
{
    public final /* synthetic */ File resourcePackFile;
    private static final /* synthetic */ Logger resourceLog;
    
    @Override
    public IMetadataSection getPackMetadata(final IMetadataSerializer llllllllllllllIllIllllIlIlIlIIII, final String llllllllllllllIllIllllIlIlIIllII) throws IOException {
        return readMetadata(llllllllllllllIllIllllIlIlIlIIII, this.getInputStreamByName("pack.mcmeta"), llllllllllllllIllIllllIlIlIIllII);
    }
    
    @Override
    public InputStream getInputStream(final ResourceLocation llllllllllllllIllIllllIlIllIIIIl) throws IOException {
        return this.getInputStreamByName(locationToName(llllllllllllllIllIllllIlIllIIIIl));
    }
    
    protected void logNameNotLowercase(final String llllllllllllllIllIllllIlIlIlIlIl) {
        AbstractResourcePack.resourceLog.warn("ResourcePack: ignored non-lowercase namespace: {} in {}", new Object[] { llllllllllllllIllIllllIlIlIlIlIl, this.resourcePackFile });
    }
    
    @Override
    public String getPackName() {
        return this.resourcePackFile.getName();
    }
    
    static {
        __OBFID = "CL_00001072";
        resourceLog = LogManager.getLogger();
    }
    
    protected abstract InputStream getInputStreamByName(final String p0) throws IOException;
    
    @Override
    public boolean resourceExists(final ResourceLocation llllllllllllllIllIllllIlIlIlllIl) {
        return this.hasResourceName(locationToName(llllllllllllllIllIllllIlIlIlllIl));
    }
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtil.func_177053_a(this.getInputStreamByName("pack.png"));
    }
    
    public AbstractResourcePack(final File llllllllllllllIllIllllIlIlllIIlI) {
        this.resourcePackFile = llllllllllllllIllIllllIlIlllIIlI;
    }
    
    static IMetadataSection readMetadata(final IMetadataSerializer llllllllllllllIllIllllIlIlIIIlII, final InputStream llllllllllllllIllIllllIlIIllllIl, final String llllllllllllllIllIllllIlIlIIIIlI) {
        JsonObject llllllllllllllIllIllllIlIlIIIIIl = null;
        BufferedReader llllllllllllllIllIllllIlIlIIIIII = null;
        try {
            llllllllllllllIllIllllIlIlIIIIII = new BufferedReader(new InputStreamReader(llllllllllllllIllIllllIlIIllllIl, Charsets.UTF_8));
            llllllllllllllIllIllllIlIlIIIIIl = new JsonParser().parse((Reader)llllllllllllllIllIllllIlIlIIIIII).getAsJsonObject();
        }
        catch (RuntimeException llllllllllllllIllIllllIlIIllllll) {
            throw new JsonParseException((Throwable)llllllllllllllIllIllllIlIIllllll);
        }
        finally {
            IOUtils.closeQuietly((Reader)llllllllllllllIllIllllIlIlIIIIII);
        }
        IOUtils.closeQuietly((Reader)llllllllllllllIllIllllIlIlIIIIII);
        return llllllllllllllIllIllllIlIlIIIlII.parseMetadataSection(llllllllllllllIllIllllIlIlIIIIlI, llllllllllllllIllIllllIlIlIIIIIl);
    }
    
    private static String locationToName(final ResourceLocation llllllllllllllIllIllllIlIllIllIl) {
        return String.format("%s/%s/%s", "assets", llllllllllllllIllIllllIlIllIllIl.getResourceDomain(), llllllllllllllIllIllllIlIllIllIl.getResourcePath());
    }
    
    protected abstract boolean hasResourceName(final String p0);
    
    protected static String getRelativeName(final File llllllllllllllIllIllllIlIllIlIlI, final File llllllllllllllIllIllllIlIllIIlll) {
        return llllllllllllllIllIllllIlIllIlIlI.toURI().relativize(llllllllllllllIllIllllIlIllIIlll.toURI()).getPath();
    }
}
