package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import net.minecraft.util.*;
import java.io.*;
import org.apache.logging.log4j.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;

public class SimpleReloadableResourceManager implements IReloadableResourceManager
{
    private static final /* synthetic */ Joiner joinerResourcePacks;
    private final /* synthetic */ Set setResourceDomains;
    private final /* synthetic */ Map domainResourceManagers;
    private final /* synthetic */ List reloadListeners;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ IMetadataSerializer rmMetadataSerializer;
    
    public SimpleReloadableResourceManager(final IMetadataSerializer lllllllllllllllIIlIlIlIIllIIllll) {
        this.domainResourceManagers = Maps.newHashMap();
        this.reloadListeners = Lists.newArrayList();
        this.setResourceDomains = Sets.newLinkedHashSet();
        this.rmMetadataSerializer = lllllllllllllllIIlIlIlIIllIIllll;
    }
    
    @Override
    public IResource getResource(final ResourceLocation lllllllllllllllIIlIlIlIIlIllIIll) throws IOException {
        final IResourceManager lllllllllllllllIIlIlIlIIlIllIlIl = this.domainResourceManagers.get(lllllllllllllllIIlIlIlIIlIllIIll.getResourceDomain());
        if (lllllllllllllllIIlIlIlIIlIllIlIl != null) {
            return lllllllllllllllIIlIlIlIIlIllIlIl.getResource(lllllllllllllllIIlIlIlIIlIllIIll);
        }
        throw new FileNotFoundException(lllllllllllllllIIlIlIlIIlIllIIll.toString());
    }
    
    @Override
    public Set getResourceDomains() {
        return this.setResourceDomains;
    }
    
    static {
        __OBFID = "CL_00001091";
        logger = LogManager.getLogger();
        joinerResourcePacks = Joiner.on(", ");
    }
    
    private void clearResources() {
        this.domainResourceManagers.clear();
        this.setResourceDomains.clear();
    }
    
    @Override
    public void reloadResources(final List lllllllllllllllIIlIlIlIIlIlIIIII) {
        this.clearResources();
        SimpleReloadableResourceManager.logger.info(String.valueOf(new StringBuilder("Reloading ResourceManager: ").append(SimpleReloadableResourceManager.joinerResourcePacks.join(Iterables.transform((Iterable)lllllllllllllllIIlIlIlIIlIlIIIII, (Function)new Function() {
            public String apply(final IResourcePack llllllllllllllIIIlIIIllIIIIIIIII) {
                return llllllllllllllIIIlIIIllIIIIIIIII.getPackName();
            }
            
            public Object apply(final Object llllllllllllllIIIlIIIlIllllllIIl) {
                return this.apply((IResourcePack)llllllllllllllIIIlIIIlIllllllIIl);
            }
            
            static {
                __OBFID = "CL_00001092";
            }
        })))));
        for (final IResourcePack lllllllllllllllIIlIlIlIIlIIllllI : lllllllllllllllIIlIlIlIIlIlIIIII) {
            this.reloadResourcePack(lllllllllllllllIIlIlIlIIlIIllllI);
        }
        this.notifyReloadListeners();
    }
    
    @Override
    public void registerReloadListener(final IResourceManagerReloadListener lllllllllllllllIIlIlIlIIlIIlIlII) {
        this.reloadListeners.add(lllllllllllllllIIlIlIlIIlIIlIlII);
        lllllllllllllllIIlIlIlIIlIIlIlII.onResourceManagerReload(this);
    }
    
    public void reloadResourcePack(final IResourcePack lllllllllllllllIIlIlIlIIllIIIIIl) {
        for (final String lllllllllllllllIIlIlIlIIllIIIIll : lllllllllllllllIIlIlIlIIllIIIIIl.getResourceDomains()) {
            this.setResourceDomains.add(lllllllllllllllIIlIlIlIIllIIIIll);
            FallbackResourceManager lllllllllllllllIIlIlIlIIllIIIlIl = this.domainResourceManagers.get(lllllllllllllllIIlIlIlIIllIIIIll);
            if (lllllllllllllllIIlIlIlIIllIIIlIl == null) {
                lllllllllllllllIIlIlIlIIllIIIlIl = new FallbackResourceManager(this.rmMetadataSerializer);
                this.domainResourceManagers.put(lllllllllllllllIIlIlIlIIllIIIIll, lllllllllllllllIIlIlIlIIllIIIlIl);
            }
            lllllllllllllllIIlIlIlIIllIIIlIl.addResourcePack(lllllllllllllllIIlIlIlIIllIIIIIl);
        }
    }
    
    private void notifyReloadListeners() {
        for (final IResourceManagerReloadListener lllllllllllllllIIlIlIlIIlIIIlllI : this.reloadListeners) {
            lllllllllllllllIIlIlIlIIlIIIlllI.onResourceManagerReload(this);
        }
    }
    
    @Override
    public List getAllResources(final ResourceLocation lllllllllllllllIIlIlIlIIlIlIllIl) throws IOException {
        final IResourceManager lllllllllllllllIIlIlIlIIlIlIllII = this.domainResourceManagers.get(lllllllllllllllIIlIlIlIIlIlIllIl.getResourceDomain());
        if (lllllllllllllllIIlIlIlIIlIlIllII != null) {
            return lllllllllllllllIIlIlIlIIlIlIllII.getAllResources(lllllllllllllllIIlIlIlIIlIlIllIl);
        }
        throw new FileNotFoundException(lllllllllllllllIIlIlIlIIlIlIllIl.toString());
    }
}
