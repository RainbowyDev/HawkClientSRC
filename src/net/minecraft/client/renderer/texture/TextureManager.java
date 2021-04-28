package net.minecraft.client.renderer.texture;

import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;
import optifine.*;
import shadersmod.client.*;
import java.io.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import java.util.*;

public class TextureManager implements IResourceManagerReloadListener, ITickable
{
    private final /* synthetic */ List listTickables;
    private final /* synthetic */ Map mapTextureCounters;
    private final /* synthetic */ Map mapTextureObjects;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ IResourceManager theResourceManager;
    
    public void deleteTexture(final ResourceLocation lllllllllllllllIlIlIIlIIllIIlIll) {
        final ITextureObject lllllllllllllllIlIlIIlIIllIIllIl = this.getTexture(lllllllllllllllIlIlIIlIIllIIlIll);
        if (lllllllllllllllIlIlIIlIIllIIllIl != null) {
            TextureUtil.deleteTexture(lllllllllllllllIlIlIIlIIllIIllIl.getGlTextureId());
        }
    }
    
    public ITextureObject getTexture(final ResourceLocation lllllllllllllllIlIlIIlIIlllIlIll) {
        return this.mapTextureObjects.get(lllllllllllllllIlIlIIlIIlllIlIll);
    }
    
    public boolean loadTickableTexture(final ResourceLocation lllllllllllllllIlIlIIlIlIIIIlIll, final ITickableTextureObject lllllllllllllllIlIlIIlIlIIIIllIl) {
        if (this.loadTexture(lllllllllllllllIlIlIIlIlIIIIlIll, lllllllllllllllIlIlIIlIlIIIIllIl)) {
            this.listTickables.add(lllllllllllllllIlIlIIlIlIIIIllIl);
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00001064";
        logger = LogManager.getLogger();
    }
    
    public void bindTexture(ResourceLocation lllllllllllllllIlIlIIlIlIIIlIlII) {
        if (Config.isRandomMobs()) {
            lllllllllllllllIlIlIIlIlIIIlIlII = RandomMobs.getTextureLocation((ResourceLocation)lllllllllllllllIlIlIIlIlIIIlIlII);
        }
        Object lllllllllllllllIlIlIIlIlIIIlIllI = this.mapTextureObjects.get(lllllllllllllllIlIlIIlIlIIIlIlII);
        if (lllllllllllllllIlIlIIlIlIIIlIllI == null) {
            lllllllllllllllIlIlIIlIlIIIlIllI = new SimpleTexture((ResourceLocation)lllllllllllllllIlIlIIlIlIIIlIlII);
            this.loadTexture((ResourceLocation)lllllllllllllllIlIlIIlIlIIIlIlII, (ITextureObject)lllllllllllllllIlIlIIlIlIIIlIllI);
        }
        if (Config.isShaders()) {
            ShadersTex.bindTexture((ITextureObject)lllllllllllllllIlIlIIlIlIIIlIllI);
        }
        else {
            TextureUtil.bindTexture(((ITextureObject)lllllllllllllllIlIlIIlIlIIIlIllI).getGlTextureId());
        }
    }
    
    public boolean loadTexture(final ResourceLocation lllllllllllllllIlIlIIlIIllllIlll, final ITextureObject lllllllllllllllIlIlIIlIIllllIllI) {
        boolean lllllllllllllllIlIlIIlIIlllllllI = true;
        Object lllllllllllllllIlIlIIlIIllllllIl = lllllllllllllllIlIlIIlIIllllIllI;
        try {
            lllllllllllllllIlIlIIlIIllllIllI.loadTexture(this.theResourceManager);
        }
        catch (IOException lllllllllllllllIlIlIIlIIllllllII) {
            TextureManager.logger.warn(String.valueOf(new StringBuilder("Failed to load texture: ").append(lllllllllllllllIlIlIIlIIllllIlll)), (Throwable)lllllllllllllllIlIlIIlIIllllllII);
            lllllllllllllllIlIlIIlIIllllllIl = TextureUtil.missingTexture;
            this.mapTextureObjects.put(lllllllllllllllIlIlIIlIIllllIlll, lllllllllllllllIlIlIIlIIllllllIl);
            lllllllllllllllIlIlIIlIIlllllllI = false;
        }
        catch (Throwable lllllllllllllllIlIlIIlIIlllllIll) {
            final CrashReport lllllllllllllllIlIlIIlIIlllllIlI = CrashReport.makeCrashReport(lllllllllllllllIlIlIIlIIlllllIll, "Registering texture");
            final CrashReportCategory lllllllllllllllIlIlIIlIIlllllIIl = lllllllllllllllIlIlIIlIIlllllIlI.makeCategory("Resource location being registered");
            lllllllllllllllIlIlIIlIIlllllIIl.addCrashSection("Resource location", lllllllllllllllIlIlIIlIIllllIlll);
            lllllllllllllllIlIlIIlIIlllllIIl.addCrashSectionCallable("Texture object class", new Callable() {
                @Override
                public String call() {
                    return lllllllllllllllIlIlIIlIIllllIllI.getClass().getName();
                }
                
                static {
                    __OBFID = "CL_00001065";
                }
            });
            throw new ReportedException(lllllllllllllllIlIlIIlIIlllllIlI);
        }
        this.mapTextureObjects.put(lllllllllllllllIlIlIIlIIllllIlll, lllllllllllllllIlIlIIlIIllllllIl);
        return lllllllllllllllIlIlIIlIIlllllllI;
    }
    
    public TextureManager(final IResourceManager lllllllllllllllIlIlIIlIlIIIllllI) {
        this.mapTextureObjects = Maps.newHashMap();
        this.listTickables = Lists.newArrayList();
        this.mapTextureCounters = Maps.newHashMap();
        this.theResourceManager = lllllllllllllllIlIlIIlIlIIIllllI;
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllllIlIlIIlIIllIIIIll) {
        Config.dbg("*** Reloading textures ***");
        Config.log(String.valueOf(new StringBuilder("Resource packs: ").append(Config.getResourcePackNames())));
        final Iterator lllllllllllllllIlIlIIlIIllIIIIlI = this.mapTextureObjects.keySet().iterator();
        while (lllllllllllllllIlIlIIlIIllIIIIlI.hasNext()) {
            final ResourceLocation lllllllllllllllIlIlIIlIIllIIIIIl = lllllllllllllllIlIlIIlIIllIIIIlI.next();
            if (lllllllllllllllIlIlIIlIIllIIIIIl.getResourcePath().startsWith("mcpatcher/")) {
                final ITextureObject lllllllllllllllIlIlIIlIIllIIIIII = this.mapTextureObjects.get(lllllllllllllllIlIlIIlIIllIIIIIl);
                if (lllllllllllllllIlIlIIlIIllIIIIII instanceof AbstractTexture) {
                    final AbstractTexture lllllllllllllllIlIlIIlIIlIllllll = (AbstractTexture)lllllllllllllllIlIlIIlIIllIIIIII;
                    lllllllllllllllIlIlIIlIIlIllllll.deleteGlTexture();
                }
                lllllllllllllllIlIlIIlIIllIIIIlI.remove();
            }
        }
        for (final Map.Entry lllllllllllllllIlIlIIlIIlIllllIl : this.mapTextureObjects.entrySet()) {
            this.loadTexture(lllllllllllllllIlIlIIlIIlIllllIl.getKey(), lllllllllllllllIlIlIIlIIlIllllIl.getValue());
        }
    }
    
    @Override
    public void tick() {
        for (final ITickable lllllllllllllllIlIlIIlIIllIlIllI : this.listTickables) {
            lllllllllllllllIlIlIIlIIllIlIllI.tick();
        }
    }
    
    public ResourceLocation getDynamicTextureLocation(final String lllllllllllllllIlIlIIlIIllIlllll, DynamicTexture lllllllllllllllIlIlIIlIIllIllllI) {
        if (lllllllllllllllIlIlIIlIIllIlllll.equals("logo")) {
            lllllllllllllllIlIlIIlIIllIllllI = Config.getMojangLogoTexture(lllllllllllllllIlIlIIlIIllIllllI);
        }
        Integer lllllllllllllllIlIlIIlIIlllIIIlI = this.mapTextureCounters.get(lllllllllllllllIlIlIIlIIllIlllll);
        if (lllllllllllllllIlIlIIlIIlllIIIlI == null) {
            lllllllllllllllIlIlIIlIIlllIIIlI = 1;
        }
        else {
            ++lllllllllllllllIlIlIIlIIlllIIIlI;
        }
        this.mapTextureCounters.put(lllllllllllllllIlIlIIlIIllIlllll, lllllllllllllllIlIlIIlIIlllIIIlI);
        final ResourceLocation lllllllllllllllIlIlIIlIIlllIIIIl = new ResourceLocation(String.format("dynamic/%s_%d", lllllllllllllllIlIlIIlIIllIlllll, lllllllllllllllIlIlIIlIIlllIIIlI));
        this.loadTexture(lllllllllllllllIlIlIIlIIlllIIIIl, lllllllllllllllIlIlIIlIIllIllllI);
        return lllllllllllllllIlIlIIlIIlllIIIIl;
    }
}
