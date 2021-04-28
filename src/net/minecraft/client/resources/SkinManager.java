package net.minecraft.client.resources;

import java.io.*;
import com.mojang.authlib.*;
import com.google.common.collect.*;
import net.minecraft.client.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.util.*;
import java.awt.image.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import com.google.common.cache.*;
import java.util.*;
import java.util.concurrent.*;

public class SkinManager
{
    private final /* synthetic */ LoadingCache skinCacheLoader;
    private final /* synthetic */ TextureManager textureManager;
    private final /* synthetic */ File skinCacheDir;
    private static final /* synthetic */ ExecutorService THREAD_POOL;
    private final /* synthetic */ MinecraftSessionService sessionService;
    
    public void func_152790_a(final GameProfile llllllllllllllIllIllllllIlIlllll, final SkinAvailableCallback llllllllllllllIllIllllllIllIIIlI, final boolean llllllllllllllIllIllllllIlIlllIl) {
        SkinManager.THREAD_POOL.submit(new Runnable() {
            @Override
            public void run() {
                final HashMap llllllllllllllIlIlIIIlllllllIlII = Maps.newHashMap();
                try {
                    llllllllllllllIlIlIIIlllllllIlII.putAll(SkinManager.this.sessionService.getTextures(llllllllllllllIllIllllllIlIlllll, llllllllllllllIllIllllllIlIlllIl));
                }
                catch (InsecureTextureException ex) {}
                if (llllllllllllllIlIlIIIlllllllIlII.isEmpty() && llllllllllllllIllIllllllIlIlllll.getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) {
                    llllllllllllllIlIlIIIlllllllIlII.putAll(SkinManager.this.sessionService.getTextures(SkinManager.this.sessionService.fillProfileProperties(llllllllllllllIllIllllllIlIlllll, false), false));
                }
                Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        if (llllllllllllllIlIlIIIlllllllIlII.containsKey(MinecraftProfileTexture.Type.SKIN)) {
                            SkinManager.this.loadSkin(llllllllllllllIlIlIIIlllllllIlII.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN, llllllllllllllIllIllllllIllIIIlI);
                        }
                        if (llllllllllllllIlIlIIIlllllllIlII.containsKey(MinecraftProfileTexture.Type.CAPE)) {
                            SkinManager.this.loadSkin(llllllllllllllIlIlIIIlllllllIlII.get(MinecraftProfileTexture.Type.CAPE), MinecraftProfileTexture.Type.CAPE, llllllllllllllIllIllllllIllIIIlI);
                        }
                    }
                    
                    static {
                        __OBFID = "CL_00001826";
                    }
                });
            }
            
            static {
                __OBFID = "CL_00001827";
            }
        });
    }
    
    public ResourceLocation loadSkin(final MinecraftProfileTexture llllllllllllllIllIllllllIlllIIIl, final MinecraftProfileTexture.Type llllllllllllllIllIllllllIllllIlI, final SkinAvailableCallback llllllllllllllIllIllllllIllIllll) {
        final ResourceLocation llllllllllllllIllIllllllIllllIII = new ResourceLocation(String.valueOf(new StringBuilder("skins/").append(llllllllllllllIllIllllllIlllIIIl.getHash())));
        final ITextureObject llllllllllllllIllIllllllIlllIlll = this.textureManager.getTexture(llllllllllllllIllIllllllIllllIII);
        if (llllllllllllllIllIllllllIlllIlll != null) {
            if (llllllllllllllIllIllllllIllIllll != null) {
                llllllllllllllIllIllllllIllIllll.func_180521_a(llllllllllllllIllIllllllIllllIlI, llllllllllllllIllIllllllIllllIII, llllllllllllllIllIllllllIlllIIIl);
            }
        }
        else {
            final File llllllllllllllIllIllllllIlllIllI = new File(this.skinCacheDir, llllllllllllllIllIllllllIlllIIIl.getHash().substring(0, 2));
            final File llllllllllllllIllIllllllIlllIlIl = new File(llllllllllllllIllIllllllIlllIllI, llllllllllllllIllIllllllIlllIIIl.getHash());
            final ImageBufferDownload llllllllllllllIllIllllllIlllIlII = (llllllllllllllIllIllllllIllllIlI == MinecraftProfileTexture.Type.SKIN) ? new ImageBufferDownload() : null;
            final ThreadDownloadImageData llllllllllllllIllIllllllIlllIIll = new ThreadDownloadImageData(llllllllllllllIllIllllllIlllIlIl, llllllllllllllIllIllllllIlllIIIl.getUrl(), DefaultPlayerSkin.func_177335_a(), new IImageBuffer() {
                @Override
                public void func_152634_a() {
                    if (llllllllllllllIllIllllllIlllIlII != null) {
                        llllllllllllllIllIllllllIlllIlII.func_152634_a();
                    }
                    if (llllllllllllllIllIllllllIllIllll != null) {
                        llllllllllllllIllIllllllIllIllll.func_180521_a(llllllllllllllIllIllllllIllllIlI, llllllllllllllIllIllllllIllllIII, llllllllllllllIllIllllllIlllIIIl);
                    }
                }
                
                static {
                    __OBFID = "CL_00001828";
                }
                
                @Override
                public BufferedImage parseUserSkin(BufferedImage llllllllllllllllIllllIIlIllllIII) {
                    if (llllllllllllllIllIllllllIlllIlII != null) {
                        llllllllllllllllIllllIIlIllllIII = llllllllllllllIllIllllllIlllIlII.parseUserSkin(llllllllllllllllIllllIIlIllllIII);
                    }
                    return llllllllllllllllIllllIIlIllllIII;
                }
            });
            this.textureManager.loadTexture(llllllllllllllIllIllllllIllllIII, llllllllllllllIllIllllllIlllIIll);
        }
        return llllllllllllllIllIllllllIllllIII;
    }
    
    public SkinManager(final TextureManager llllllllllllllIllIlllllllIIlIIlI, final File llllllllllllllIllIlllllllIIlIlIl, final MinecraftSessionService llllllllllllllIllIlllllllIIlIlII) {
        this.textureManager = llllllllllllllIllIlllllllIIlIIlI;
        this.skinCacheDir = llllllllllllllIllIlllllllIIlIlIl;
        this.sessionService = llllllllllllllIllIlllllllIIlIlII;
        this.skinCacheLoader = CacheBuilder.newBuilder().expireAfterAccess(15L, TimeUnit.SECONDS).build((CacheLoader)new CacheLoader() {
            public Map func_152786_a(final GameProfile llllllllllllllllIIllIlIIIllIIlIl) {
                return Minecraft.getMinecraft().getSessionService().getTextures(llllllllllllllllIIllIlIIIllIIlIl, false);
            }
            
            public Object load(final Object llllllllllllllllIIllIlIIIllIIIIl) {
                return this.func_152786_a((GameProfile)llllllllllllllllIIllIlIIIllIIIIl);
            }
            
            static {
                __OBFID = "CL_00001829";
            }
        });
    }
    
    public ResourceLocation loadSkin(final MinecraftProfileTexture llllllllllllllIllIlllllllIIIlIII, final MinecraftProfileTexture.Type llllllllllllllIllIlllllllIIIlIlI) {
        return this.loadSkin(llllllllllllllIllIlllllllIIIlIII, llllllllllllllIllIlllllllIIIlIlI, null);
    }
    
    static {
        __OBFID = "CL_00001830";
        THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    }
    
    public Map loadSkinFromCache(final GameProfile llllllllllllllIllIllllllIlIllIIl) {
        return (Map)this.skinCacheLoader.getUnchecked((Object)llllllllllllllIllIllllllIlIllIIl);
    }
    
    public interface SkinAvailableCallback
    {
        void func_180521_a(final MinecraftProfileTexture.Type p0, final ResourceLocation p1, final MinecraftProfileTexture p2);
    }
}
