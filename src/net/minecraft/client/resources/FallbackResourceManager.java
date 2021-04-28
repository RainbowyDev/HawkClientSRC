package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import java.util.*;
import java.io.*;

public class FallbackResourceManager implements IResourceManager
{
    protected final /* synthetic */ List resourcePacks;
    private static final /* synthetic */ Logger field_177246_b;
    private final /* synthetic */ IMetadataSerializer frmMetadataSerializer;
    
    @Override
    public IResource getResource(final ResourceLocation llllllllllllllllllllllllIIIIllll) throws IOException {
        IResourcePack llllllllllllllllllllllllIIIlIlIl = null;
        final ResourceLocation llllllllllllllllllllllllIIIlIlII = getLocationMcmeta(llllllllllllllllllllllllIIIIllll);
        for (int llllllllllllllllllllllllIIIlIIll = this.resourcePacks.size() - 1; llllllllllllllllllllllllIIIlIIll >= 0; --llllllllllllllllllllllllIIIlIIll) {
            final IResourcePack llllllllllllllllllllllllIIIlIIlI = this.resourcePacks.get(llllllllllllllllllllllllIIIlIIll);
            if (llllllllllllllllllllllllIIIlIlIl == null && llllllllllllllllllllllllIIIlIIlI.resourceExists(llllllllllllllllllllllllIIIlIlII)) {
                llllllllllllllllllllllllIIIlIlIl = llllllllllllllllllllllllIIIlIIlI;
            }
            if (llllllllllllllllllllllllIIIlIIlI.resourceExists(llllllllllllllllllllllllIIIIllll)) {
                InputStream llllllllllllllllllllllllIIIlIIIl = null;
                if (llllllllllllllllllllllllIIIlIlIl != null) {
                    llllllllllllllllllllllllIIIlIIIl = this.func_177245_a(llllllllllllllllllllllllIIIlIlII, llllllllllllllllllllllllIIIlIlIl);
                }
                return new SimpleResource(llllllllllllllllllllllllIIIlIIlI.getPackName(), llllllllllllllllllllllllIIIIllll, this.func_177245_a(llllllllllllllllllllllllIIIIllll, llllllllllllllllllllllllIIIlIIlI), llllllllllllllllllllllllIIIlIIIl, this.frmMetadataSerializer);
            }
        }
        throw new FileNotFoundException(llllllllllllllllllllllllIIIIllll.toString());
    }
    
    protected InputStream func_177245_a(final ResourceLocation llllllllllllllllllllllllIIIIIIlI, final IResourcePack llllllllllllllllllllllllIIIIIIIl) throws IOException {
        final InputStream llllllllllllllllllllllllIIIIIIll = llllllllllllllllllllllllIIIIIIIl.getInputStream(llllllllllllllllllllllllIIIIIIlI);
        return FallbackResourceManager.field_177246_b.isDebugEnabled() ? new ImputStreamLeakedResourceLogger(llllllllllllllllllllllllIIIIIIll, llllllllllllllllllllllllIIIIIIlI, llllllllllllllllllllllllIIIIIIIl.getPackName()) : llllllllllllllllllllllllIIIIIIll;
    }
    
    @Override
    public List getAllResources(final ResourceLocation lllllllllllllllllllllllIllllIIII) throws IOException {
        final ArrayList lllllllllllllllllllllllIllllIllI = Lists.newArrayList();
        final ResourceLocation lllllllllllllllllllllllIllllIlIl = getLocationMcmeta(lllllllllllllllllllllllIllllIIII);
        for (final IResourcePack lllllllllllllllllllllllIllllIIll : this.resourcePacks) {
            if (lllllllllllllllllllllllIllllIIll.resourceExists(lllllllllllllllllllllllIllllIIII)) {
                final InputStream lllllllllllllllllllllllIllllIIlI = lllllllllllllllllllllllIllllIIll.resourceExists(lllllllllllllllllllllllIllllIlIl) ? this.func_177245_a(lllllllllllllllllllllllIllllIlIl, lllllllllllllllllllllllIllllIIll) : null;
                lllllllllllllllllllllllIllllIllI.add(new SimpleResource(lllllllllllllllllllllllIllllIIll.getPackName(), lllllllllllllllllllllllIllllIIII, this.func_177245_a(lllllllllllllllllllllllIllllIIII, lllllllllllllllllllllllIllllIIll), lllllllllllllllllllllllIllllIIlI, this.frmMetadataSerializer));
            }
        }
        if (lllllllllllllllllllllllIllllIllI.isEmpty()) {
            throw new FileNotFoundException(lllllllllllllllllllllllIllllIIII.toString());
        }
        return lllllllllllllllllllllllIllllIllI;
    }
    
    static ResourceLocation getLocationMcmeta(final ResourceLocation lllllllllllllllllllllllIlllIlIIl) {
        return new ResourceLocation(lllllllllllllllllllllllIlllIlIIl.getResourceDomain(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllllllllIlllIlIIl.getResourcePath())).append(".mcmeta")));
    }
    
    static {
        __OBFID = "CL_00001074";
        field_177246_b = LogManager.getLogger();
    }
    
    @Override
    public Set getResourceDomains() {
        return null;
    }
    
    public void addResourcePack(final IResourcePack llllllllllllllllllllllllIIlIIIII) {
        this.resourcePacks.add(llllllllllllllllllllllllIIlIIIII);
    }
    
    public FallbackResourceManager(final IMetadataSerializer llllllllllllllllllllllllIIlIIllI) {
        this.resourcePacks = Lists.newArrayList();
        this.frmMetadataSerializer = llllllllllllllllllllllllIIlIIllI;
    }
    
    static class ImputStreamLeakedResourceLogger extends InputStream
    {
        private final /* synthetic */ String field_177328_b;
        private final /* synthetic */ InputStream field_177330_a;
        private /* synthetic */ boolean field_177329_c;
        
        public ImputStreamLeakedResourceLogger(final InputStream lllllllllllllllIlllIIlIIlIlIIIlI, final ResourceLocation lllllllllllllllIlllIIlIIlIlIIIIl, final String lllllllllllllllIlllIIlIIlIlIIIII) {
            this.field_177329_c = false;
            this.field_177330_a = lllllllllllllllIlllIIlIIlIlIIIlI;
            final ByteArrayOutputStream lllllllllllllllIlllIIlIIlIlIIlII = new ByteArrayOutputStream();
            new Exception().printStackTrace(new PrintStream(lllllllllllllllIlllIIlIIlIlIIlII));
            this.field_177328_b = String.valueOf(new StringBuilder("Leaked resource: '").append(lllllllllllllllIlllIIlIIlIlIIIIl).append("' loaded from pack: '").append(lllllllllllllllIlllIIlIIlIlIIIII).append("'\n").append(lllllllllllllllIlllIIlIIlIlIIlII.toString()));
        }
        
        @Override
        public int read() throws IOException {
            return this.field_177330_a.read();
        }
        
        static {
            __OBFID = "CL_00002395";
        }
        
        @Override
        protected void finalize() throws Throwable {
            if (!this.field_177329_c) {
                FallbackResourceManager.field_177246_b.warn(this.field_177328_b);
            }
            super.finalize();
        }
        
        @Override
        public void close() throws IOException {
            this.field_177330_a.close();
            this.field_177329_c = true;
        }
    }
}
