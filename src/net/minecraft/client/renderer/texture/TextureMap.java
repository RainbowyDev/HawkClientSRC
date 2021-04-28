package net.minecraft.client.renderer.texture;

import shadersmod.client.*;
import net.minecraft.client.*;
import java.awt.image.*;
import net.minecraft.client.resources.data.*;
import optifine.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import org.apache.logging.log4j.*;

public class TextureMap extends AbstractTexture implements ITickableTextureObject
{
    private /* synthetic */ int iconGridCountX;
    private /* synthetic */ int mipmapLevels;
    private /* synthetic */ TextureAtlasSprite[] iconGrid;
    private final /* synthetic */ String basePath;
    private /* synthetic */ int iconGridSize;
    private /* synthetic */ double iconGridSizeV;
    public /* synthetic */ int atlasWidth;
    private /* synthetic */ boolean skipFirst;
    private final /* synthetic */ TextureAtlasSprite missingImage;
    private final /* synthetic */ Map mapRegisteredSprites;
    public /* synthetic */ int atlasHeight;
    private final /* synthetic */ List listAnimatedSprites;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ double iconGridSizeU;
    private final /* synthetic */ Map mapUploadedSprites;
    public static final /* synthetic */ ResourceLocation locationBlocksTexture;
    private final /* synthetic */ IIconCreator field_174946_m;
    private /* synthetic */ int iconGridCountY;
    private static final /* synthetic */ boolean ENABLE_SKIP;
    
    public TextureAtlasSprite getAtlasSprite(final String lllllllllllllllIlIIllIIIlllIllIl) {
        TextureAtlasSprite lllllllllllllllIlIIllIIIllllIIIl = this.mapUploadedSprites.get(lllllllllllllllIlIIllIIIlllIllIl);
        if (lllllllllllllllIlIIllIIIllllIIIl == null) {
            lllllllllllllllIlIIllIIIllllIIIl = this.missingImage;
        }
        return lllllllllllllllIlIIllIIIllllIIIl;
    }
    
    public TextureMap(final String lllllllllllllllIlIIllIIllllIIIII) {
        this(lllllllllllllllIlIIllIIllllIIIII, null);
    }
    
    private boolean isAbsoluteLocation(final ResourceLocation lllllllllllllllIlIIllIIIlIIIllll) {
        final String lllllllllllllllIlIIllIIIlIIIlllI = lllllllllllllllIlIIllIIIlIIIllll.getResourcePath();
        return this.isAbsoluteLocationPath(lllllllllllllllIlIIllIIIlIIIlllI);
    }
    
    private int detectMaxMipmapLevel(final Map lllllllllllllllIlIIllIIIIllIlIII, final IResourceManager lllllllllllllllIlIIllIIIIllIIlll) {
        int lllllllllllllllIlIIllIIIIllIlIll = this.detectMinimumSpriteSize(lllllllllllllllIlIIllIIIIllIlIII, lllllllllllllllIlIIllIIIIllIIlll, 20);
        if (lllllllllllllllIlIIllIIIIllIlIll < 16) {
            lllllllllllllllIlIIllIIIIllIlIll = 16;
        }
        lllllllllllllllIlIIllIIIIllIlIll = MathHelper.roundUpToPowerOfTwo(lllllllllllllllIlIIllIIIIllIlIll);
        if (lllllllllllllllIlIIllIIIIllIlIll > 16) {
            Config.log(String.valueOf(new StringBuilder("Sprite size: ").append(lllllllllllllllIlIIllIIIIllIlIll)));
        }
        int lllllllllllllllIlIIllIIIIllIlIlI = MathHelper.calculateLogBaseTwo(lllllllllllllllIlIIllIIIIllIlIll);
        if (lllllllllllllllIlIIllIIIIllIlIlI < 4) {
            lllllllllllllllIlIIllIIIIllIlIlI = 4;
        }
        return lllllllllllllllIlIIllIIIIllIlIlI;
    }
    
    public boolean isTextureBound() {
        final int lllllllllllllllIlIIllIIIIIIIlllI = GlStateManager.getBoundTexture();
        final int lllllllllllllllIlIIllIIIIIIIllIl = this.getGlTextureId();
        return lllllllllllllllIlIIllIIIIIIIlllI == lllllllllllllllIlIIllIIIIIIIllIl;
    }
    
    public void loadTextureAtlas(final IResourceManager lllllllllllllllIlIIllIIllIIIIIIl) {
        ShadersTex.resManager = lllllllllllllllIlIIllIIllIIIIIIl;
        Config.dbg(String.valueOf(new StringBuilder("Multitexture: ").append(Config.isMultiTexture())));
        if (Config.isMultiTexture()) {
            for (final TextureAtlasSprite lllllllllllllllIlIIllIIlIllllllI : this.mapUploadedSprites.values()) {
                lllllllllllllllIlIIllIIlIllllllI.deleteSpriteTexture();
            }
        }
        ConnectedTextures.updateIcons(this);
        CustomItems.updateIcons(this);
        final int lllllllllllllllIlIIllIIlIlllllII = Minecraft.getGLMaximumTextureSize();
        final Stitcher lllllllllllllllIlIIllIIlIllllIll = new Stitcher(lllllllllllllllIlIIllIIlIlllllII, lllllllllllllllIlIIllIIlIlllllII, true, 0, this.mipmapLevels);
        this.mapUploadedSprites.clear();
        this.listAnimatedSprites.clear();
        int lllllllllllllllIlIIllIIlIllllIIl = Integer.MAX_VALUE;
        Reflector.callVoid(Reflector.ForgeHooksClient_onTextureStitchedPre, this);
        final int lllllllllllllllIlIIllIIlIlllIlll = this.getMinSpriteSize();
        this.iconGridSize = lllllllllllllllIlIIllIIlIlllIlll;
        int lllllllllllllllIlIIllIIlIlllIlIl = 1 << this.mipmapLevels;
        final Iterator lllllllllllllllIlIIllIIlIlllIIll = this.mapRegisteredSprites.entrySet().iterator();
        while (lllllllllllllllIlIIllIIlIlllIIll.hasNext() && !this.skipFirst) {
            final Map.Entry lllllllllllllllIlIIllIIlIllIlIlI = lllllllllllllllIlIIllIIlIlllIIll.next();
            final TextureAtlasSprite lllllllllllllllIlIIllIIlIllIlIIl = lllllllllllllllIlIIllIIlIllIlIlI.getValue();
            final ResourceLocation lllllllllllllllIlIIllIIlIllIIlll = new ResourceLocation(lllllllllllllllIlIIllIIlIllIlIIl.getIconName());
            final ResourceLocation lllllllllllllllIlIIllIIlIllIIllI = this.completeResourceLocation(lllllllllllllllIlIIllIIlIllIIlll, 0);
            if (lllllllllllllllIlIIllIIlIllIlIIl.hasCustomLoader(lllllllllllllllIlIIllIIllIIIIIIl, lllllllllllllllIlIIllIIlIllIIlll)) {
                if (!lllllllllllllllIlIIllIIlIllIlIIl.load(lllllllllllllllIlIIllIIllIIIIIIl, lllllllllllllllIlIIllIIlIllIIlll)) {
                    lllllllllllllllIlIIllIIlIllllIIl = Math.min(lllllllllllllllIlIIllIIlIllllIIl, Math.min(lllllllllllllllIlIIllIIlIllIlIIl.getIconWidth(), lllllllllllllllIlIIllIIlIllIlIIl.getIconHeight()));
                    lllllllllllllllIlIIllIIlIllllIll.addSprite(lllllllllllllllIlIIllIIlIllIlIIl);
                }
                Config.dbg(String.valueOf(new StringBuilder("Custom loader: ").append(lllllllllllllllIlIIllIIlIllIlIIl)));
            }
            else {
                try {
                    final IResource lllllllllllllllIlIIllIIlIllIIlIl = ShadersTex.loadResource(lllllllllllllllIlIIllIIllIIIIIIl, lllllllllllllllIlIIllIIlIllIIllI);
                    final BufferedImage[] lllllllllllllllIlIIllIIlIllIIIll = new BufferedImage[1 + this.mipmapLevels];
                    lllllllllllllllIlIIllIIlIllIIIll[0] = TextureUtil.func_177053_a(lllllllllllllllIlIIllIIlIllIIlIl.getInputStream());
                    if (lllllllllllllllIlIIllIIlIllIIIll != null) {
                        final int lllllllllllllllIlIIllIIlIlllIIIl = lllllllllllllllIlIIllIIlIllIIIll[0].getWidth();
                        if (lllllllllllllllIlIIllIIlIlllIIIl < lllllllllllllllIlIIllIIlIlllIlll || this.mipmapLevels > 0) {
                            lllllllllllllllIlIIllIIlIllIIIll[0] = ((this.mipmapLevels > 0) ? TextureUtils.scaleToPowerOfTwo(lllllllllllllllIlIIllIIlIllIIIll[0], lllllllllllllllIlIIllIIlIlllIlll) : TextureUtils.scaleMinTo(lllllllllllllllIlIIllIIlIllIIIll[0], lllllllllllllllIlIIllIIlIlllIlll));
                            final int lllllllllllllllIlIIllIIlIllIIIIl = lllllllllllllllIlIIllIIlIllIIIll[0].getWidth();
                            if (lllllllllllllllIlIIllIIlIllIIIIl != lllllllllllllllIlIIllIIlIlllIIIl) {
                                if (!TextureUtils.isPowerOfTwo(lllllllllllllllIlIIllIIlIlllIIIl)) {
                                    Config.log(String.valueOf(new StringBuilder("Scaled non power of 2: ").append(lllllllllllllllIlIIllIIlIllIlIIl.getIconName()).append(", ").append(lllllllllllllllIlIIllIIlIlllIIIl).append(" -> ").append(lllllllllllllllIlIIllIIlIllIIIIl)));
                                }
                                else {
                                    Config.log(String.valueOf(new StringBuilder("Scaled too small texture: ").append(lllllllllllllllIlIIllIIlIllIlIIl.getIconName()).append(", ").append(lllllllllllllllIlIIllIIlIlllIIIl).append(" -> ").append(lllllllllllllllIlIIllIIlIllIIIIl)));
                                }
                            }
                        }
                    }
                    final TextureMetadataSection lllllllllllllllIlIIllIIlIlIlllll = (TextureMetadataSection)lllllllllllllllIlIIllIIlIllIIlIl.getMetadata("texture");
                    if (lllllllllllllllIlIIllIIlIlIlllll != null) {
                        final List lllllllllllllllIlIIllIIlIllIllIl = lllllllllllllllIlIIllIIlIlIlllll.getListMipmaps();
                        if (!lllllllllllllllIlIIllIIlIllIllIl.isEmpty()) {
                            final int lllllllllllllllIlIIllIIlIlIllIll = lllllllllllllllIlIIllIIlIllIIIll[0].getWidth();
                            final int lllllllllllllllIlIIllIIlIlIllllI = lllllllllllllllIlIIllIIlIllIIIll[0].getHeight();
                            if (MathHelper.roundUpToPowerOfTwo(lllllllllllllllIlIIllIIlIlIllIll) != lllllllllllllllIlIIllIIlIlIllIll || MathHelper.roundUpToPowerOfTwo(lllllllllllllllIlIIllIIlIlIllllI) != lllllllllllllllIlIIllIIlIlIllllI) {
                                throw new RuntimeException("Unable to load extra miplevels, source-texture is not power of two");
                            }
                        }
                        for (final int lllllllllllllllIlIIllIIlIlIlllIl : lllllllllllllllIlIIllIIlIllIllIl) {
                            if (lllllllllllllllIlIIllIIlIlIlllIl > 0 && lllllllllllllllIlIIllIIlIlIlllIl < lllllllllllllllIlIIllIIlIllIIIll.length - 1 && lllllllllllllllIlIIllIIlIllIIIll[lllllllllllllllIlIIllIIlIlIlllIl] == null) {
                                final ResourceLocation lllllllllllllllIlIIllIIlIlIlIlll = this.completeResourceLocation(lllllllllllllllIlIIllIIlIllIIlll, lllllllllllllllIlIIllIIlIlIlllIl);
                                try {
                                    lllllllllllllllIlIIllIIlIllIIIll[lllllllllllllllIlIIllIIlIlIlllIl] = TextureUtil.func_177053_a(ShadersTex.loadResource(lllllllllllllllIlIIllIIllIIIIIIl, lllllllllllllllIlIIllIIlIlIlIlll).getInputStream());
                                }
                                catch (IOException lllllllllllllllIlIIllIIlIlIlIllI) {
                                    TextureMap.logger.error("Unable to load miplevel {} from: {}", new Object[] { lllllllllllllllIlIIllIIlIlIlllIl, lllllllllllllllIlIIllIIlIlIlIlll, lllllllllllllllIlIIllIIlIlIlIllI });
                                }
                            }
                        }
                    }
                    final AnimationMetadataSection lllllllllllllllIlIIllIIlIlIlIlIl = (AnimationMetadataSection)lllllllllllllllIlIIllIIlIllIIlIl.getMetadata("animation");
                    lllllllllllllllIlIIllIIlIllIlIIl.func_180598_a(lllllllllllllllIlIIllIIlIllIIIll, lllllllllllllllIlIIllIIlIlIlIlIl);
                }
                catch (RuntimeException lllllllllllllllIlIIllIIlIlIlIlII) {
                    TextureMap.logger.error(String.valueOf(new StringBuilder("Unable to parse metadata from ").append(lllllllllllllllIlIIllIIlIllIIllI)), (Throwable)lllllllllllllllIlIIllIIlIlIlIlII);
                    ReflectorForge.FMLClientHandler_trackBrokenTexture(lllllllllllllllIlIIllIIlIllIIllI, lllllllllllllllIlIIllIIlIlIlIlII.getMessage());
                    continue;
                }
                catch (IOException lllllllllllllllIlIIllIIlIlIlIIll) {
                    TextureMap.logger.error(String.valueOf(new StringBuilder("Using missing texture, unable to load ").append(lllllllllllllllIlIIllIIlIllIIllI).append(", ").append(lllllllllllllllIlIIllIIlIlIlIIll.getClass().getName())));
                    ReflectorForge.FMLClientHandler_trackMissingTexture(lllllllllllllllIlIIllIIlIllIIllI);
                    continue;
                }
                lllllllllllllllIlIIllIIlIllllIIl = Math.min(lllllllllllllllIlIIllIIlIllllIIl, Math.min(lllllllllllllllIlIIllIIlIllIlIIl.getIconWidth(), lllllllllllllllIlIIllIIlIllIlIIl.getIconHeight()));
                final int lllllllllllllllIlIIllIIlIlIlIIlI = Math.min(Integer.lowestOneBit(lllllllllllllllIlIIllIIlIllIlIIl.getIconWidth()), Integer.lowestOneBit(lllllllllllllllIlIIllIIlIllIlIIl.getIconHeight()));
                if (lllllllllllllllIlIIllIIlIlIlIIlI < lllllllllllllllIlIIllIIlIlllIlIl) {
                    TextureMap.logger.warn("Texture {} with size {}x{} limits mip level from {} to {}", new Object[] { lllllllllllllllIlIIllIIlIllIIllI, lllllllllllllllIlIIllIIlIllIlIIl.getIconWidth(), lllllllllllllllIlIIllIIlIllIlIIl.getIconHeight(), MathHelper.calculateLogBaseTwo(lllllllllllllllIlIIllIIlIlllIlIl), MathHelper.calculateLogBaseTwo(lllllllllllllllIlIIllIIlIlIlIIlI) });
                    lllllllllllllllIlIIllIIlIlllIlIl = lllllllllllllllIlIIllIIlIlIlIIlI;
                }
                lllllllllllllllIlIIllIIlIllllIll.addSprite(lllllllllllllllIlIIllIIlIllIlIIl);
            }
        }
        final int lllllllllllllllIlIIllIIlIlIlIIIl = Math.min(lllllllllllllllIlIIllIIlIllllIIl, lllllllllllllllIlIIllIIlIlllIlIl);
        int lllllllllllllllIlIIllIIlIlIIllll = MathHelper.calculateLogBaseTwo(lllllllllllllllIlIIllIIlIlIlIIIl);
        if (lllllllllllllllIlIIllIIlIlIIllll < 0) {
            lllllllllllllllIlIIllIIlIlIIllll = 0;
        }
        if (lllllllllllllllIlIIllIIlIlIIllll < this.mipmapLevels) {
            TextureMap.logger.info("{}: dropping miplevel from {} to {}, because of minimum power of two: {}", new Object[] { this.basePath, this.mipmapLevels, lllllllllllllllIlIIllIIlIlIIllll, lllllllllllllllIlIIllIIlIlIlIIIl });
            this.mipmapLevels = lllllllllllllllIlIIllIIlIlIIllll;
        }
        final Iterator lllllllllllllllIlIIllIIlIlIIllIl = this.mapRegisteredSprites.values().iterator();
        while (lllllllllllllllIlIIllIIlIlIIllIl.hasNext() && !this.skipFirst) {
            final TextureAtlasSprite lllllllllllllllIlIIllIIlIlIIllII = lllllllllllllllIlIIllIIlIlIIllIl.next();
            try {
                lllllllllllllllIlIIllIIlIlIIllII.generateMipmaps(this.mipmapLevels);
            }
            catch (Throwable lllllllllllllllIlIIllIIlIlIIlIll) {
                final CrashReport lllllllllllllllIlIIllIIlIlIIlIIl = CrashReport.makeCrashReport(lllllllllllllllIlIIllIIlIlIIlIll, "Applying mipmap");
                final CrashReportCategory lllllllllllllllIlIIllIIlIlIIlIII = lllllllllllllllIlIIllIIlIlIIlIIl.makeCategory("Sprite being mipmapped");
                lllllllllllllllIlIIllIIlIlIIlIII.addCrashSectionCallable("Sprite name", new Callable() {
                    @Override
                    public String call() {
                        return lllllllllllllllIlIIllIIlIlIIllII.getIconName();
                    }
                    
                    static {
                        __OBFID = "CL_00001059";
                    }
                });
                lllllllllllllllIlIIllIIlIlIIlIII.addCrashSectionCallable("Sprite size", new Callable() {
                    @Override
                    public String call() {
                        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIllIIlIlIIllII.getIconWidth())).append(" x ").append(lllllllllllllllIlIIllIIlIlIIllII.getIconHeight()));
                    }
                    
                    static {
                        __OBFID = "CL_00001060";
                    }
                });
                lllllllllllllllIlIIllIIlIlIIlIII.addCrashSectionCallable("Sprite frames", new Callable() {
                    @Override
                    public String call() {
                        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIllIIlIlIIllII.getFrameCount())).append(" frames"));
                    }
                    
                    static {
                        __OBFID = "CL_00001061";
                    }
                });
                lllllllllllllllIlIIllIIlIlIIlIII.addCrashSection("Mipmap levels", this.mipmapLevels);
                throw new ReportedException(lllllllllllllllIlIIllIIlIlIIlIIl);
            }
        }
        this.missingImage.generateMipmaps(this.mipmapLevels);
        lllllllllllllllIlIIllIIlIllllIll.addSprite(this.missingImage);
        this.skipFirst = false;
        try {
            lllllllllllllllIlIIllIIlIllllIll.doStitch();
        }
        catch (StitcherException lllllllllllllllIlIIllIIlIlIIIlll) {
            throw lllllllllllllllIlIIllIIlIlIIIlll;
        }
        TextureMap.logger.info("Created: {}x{} {}-atlas", new Object[] { lllllllllllllllIlIIllIIlIllllIll.getCurrentWidth(), lllllllllllllllIlIIllIIlIllllIll.getCurrentHeight(), this.basePath });
        if (Config.isShaders()) {
            ShadersTex.allocateTextureMap(this.getGlTextureId(), this.mipmapLevels, lllllllllllllllIlIIllIIlIllllIll.getCurrentWidth(), lllllllllllllllIlIIllIIlIllllIll.getCurrentHeight(), lllllllllllllllIlIIllIIlIllllIll, this);
        }
        else {
            TextureUtil.func_180600_a(this.getGlTextureId(), this.mipmapLevels, lllllllllllllllIlIIllIIlIllllIll.getCurrentWidth(), lllllllllllllllIlIIllIIlIllllIll.getCurrentHeight());
        }
        final HashMap lllllllllllllllIlIIllIIlIlIIIllI = Maps.newHashMap(this.mapRegisteredSprites);
        for (final TextureAtlasSprite lllllllllllllllIlIIllIIlIlIIIlII : lllllllllllllllIlIIllIIlIllllIll.getStichSlots()) {
            if (Config.isShaders()) {
                ShadersTex.setIconName(ShadersTex.setSprite(lllllllllllllllIlIIllIIlIlIIIlII).getIconName());
            }
            final String lllllllllllllllIlIIllIIlIlIIIIlI = lllllllllllllllIlIIllIIlIlIIIlII.getIconName();
            lllllllllllllllIlIIllIIlIlIIIllI.remove(lllllllllllllllIlIIllIIlIlIIIIlI);
            this.mapUploadedSprites.put(lllllllllllllllIlIIllIIlIlIIIIlI, lllllllllllllllIlIIllIIlIlIIIlII);
            try {
                if (Config.isShaders()) {
                    ShadersTex.uploadTexSubForLoadAtlas(lllllllllllllllIlIIllIIlIlIIIlII.getFrameTextureData(0), lllllllllllllllIlIIllIIlIlIIIlII.getIconWidth(), lllllllllllllllIlIIllIIlIlIIIlII.getIconHeight(), lllllllllllllllIlIIllIIlIlIIIlII.getOriginX(), lllllllllllllllIlIIllIIlIlIIIlII.getOriginY(), false, false);
                }
                else {
                    TextureUtil.uploadTextureMipmap(lllllllllllllllIlIIllIIlIlIIIlII.getFrameTextureData(0), lllllllllllllllIlIIllIIlIlIIIlII.getIconWidth(), lllllllllllllllIlIIllIIlIlIIIlII.getIconHeight(), lllllllllllllllIlIIllIIlIlIIIlII.getOriginX(), lllllllllllllllIlIIllIIlIlIIIlII.getOriginY(), false, false);
                }
            }
            catch (Throwable lllllllllllllllIlIIllIIlIlIIIIIl) {
                final CrashReport lllllllllllllllIlIIllIIlIlIIIIII = CrashReport.makeCrashReport(lllllllllllllllIlIIllIIlIlIIIIIl, "Stitching texture atlas");
                final CrashReportCategory lllllllllllllllIlIIllIIlIIllllll = lllllllllllllllIlIIllIIlIlIIIIII.makeCategory("Texture being stitched together");
                lllllllllllllllIlIIllIIlIIllllll.addCrashSection("Atlas path", this.basePath);
                lllllllllllllllIlIIllIIlIIllllll.addCrashSection("Sprite", lllllllllllllllIlIIllIIlIlIIIlII);
                throw new ReportedException(lllllllllllllllIlIIllIIlIlIIIIII);
            }
            if (lllllllllllllllIlIIllIIlIlIIIlII.hasAnimationMetadata()) {
                this.listAnimatedSprites.add(lllllllllllllllIlIIllIIlIlIIIlII);
            }
        }
        for (final TextureAtlasSprite lllllllllllllllIlIIllIIlIlIIIIll : lllllllllllllllIlIIllIIlIlIIIllI.values()) {
            lllllllllllllllIlIIllIIlIlIIIIll.copyFrom(this.missingImage);
        }
        if (Config.isMultiTexture()) {
            final int lllllllllllllllIlIIllIIlIIlllllI = lllllllllllllllIlIIllIIlIllllIll.getCurrentWidth();
            final int lllllllllllllllIlIIllIIlIllIllll = lllllllllllllllIlIIllIIlIllllIll.getCurrentHeight();
            final List lllllllllllllllIlIIllIIlIllIlIll = lllllllllllllllIlIIllIIlIllllIll.getStichSlots();
            for (final TextureAtlasSprite lllllllllllllllIlIIllIIlIIllllII : lllllllllllllllIlIIllIIlIllIlIll) {
                lllllllllllllllIlIIllIIlIIllllII.sheetWidth = lllllllllllllllIlIIllIIlIIlllllI;
                lllllllllllllllIlIIllIIlIIllllII.sheetHeight = lllllllllllllllIlIIllIIlIllIllll;
                lllllllllllllllIlIIllIIlIIllllII.mipmapLevels = this.mipmapLevels;
                final TextureAtlasSprite lllllllllllllllIlIIllIIlIIlllIll = lllllllllllllllIlIIllIIlIIllllII.spriteSingle;
                if (lllllllllllllllIlIIllIIlIIlllIll != null) {
                    lllllllllllllllIlIIllIIlIIlllIll.sheetWidth = lllllllllllllllIlIIllIIlIIlllllI;
                    lllllllllllllllIlIIllIIlIIlllIll.sheetHeight = lllllllllllllllIlIIllIIlIllIllll;
                    lllllllllllllllIlIIllIIlIIlllIll.mipmapLevels = this.mipmapLevels;
                    lllllllllllllllIlIIllIIlIIllllII.bindSpriteTexture();
                    final boolean lllllllllllllllIlIIllIIlIIlllIIl = false;
                    final boolean lllllllllllllllIlIIllIIlIIllIlll = true;
                    TextureUtil.uploadTextureMipmap(lllllllllllllllIlIIllIIlIIlllIll.getFrameTextureData(0), lllllllllllllllIlIIllIIlIIlllIll.getIconWidth(), lllllllllllllllIlIIllIIlIIlllIll.getIconHeight(), lllllllllllllllIlIIllIIlIIlllIll.getOriginX(), lllllllllllllllIlIIllIIlIIlllIll.getOriginY(), lllllllllllllllIlIIllIIlIIlllIIl, lllllllllllllllIlIIllIIlIIllIlll);
                }
            }
            Config.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        }
        Reflector.callVoid(Reflector.ForgeHooksClient_onTextureStitchedPost, this);
        this.updateIconGrid(lllllllllllllllIlIIllIIlIllllIll.getCurrentWidth(), lllllllllllllllIlIIllIIlIllllIll.getCurrentHeight());
        if (Config.equals(System.getProperty("saveTextureMap"), "true")) {
            Config.dbg(String.valueOf(new StringBuilder("Exporting texture map to: ").append(this.basePath).append("_x.png")));
            TextureUtil.func_177055_a(this.basePath.replaceAll("/", "_"), this.getGlTextureId(), this.mipmapLevels, lllllllllllllllIlIIllIIlIllllIll.getCurrentWidth(), lllllllllllllllIlIIllIIlIllllIll.getCurrentHeight());
        }
    }
    
    public boolean setTextureEntry(final String lllllllllllllllIlIIllIIIlIIllIII, final TextureAtlasSprite lllllllllllllllIlIIllIIIlIIlIlll) {
        if (!this.mapRegisteredSprites.containsKey(lllllllllllllllIlIIllIIIlIIllIII)) {
            this.mapRegisteredSprites.put(lllllllllllllllIlIIllIIIlIIllIII, lllllllllllllllIlIIllIIIlIIlIlll);
            if (lllllllllllllllIlIIllIIIlIIlIlll.getIndexInMap() < 0) {
                lllllllllllllllIlIIllIIIlIIlIlll.setIndexInMap(this.mapRegisteredSprites.size());
            }
            return true;
        }
        return false;
    }
    
    public TextureAtlasSprite getTextureExtry(final String lllllllllllllllIlIIllIIIlIIllllI) {
        final ResourceLocation lllllllllllllllIlIIllIIIlIlIIIII = new ResourceLocation(lllllllllllllllIlIIllIIIlIIllllI);
        return this.mapRegisteredSprites.get(lllllllllllllllIlIIllIIIlIlIIIII.toString());
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllllIlIIllIIllIllIIlI) throws IOException {
        ShadersTex.resManager = lllllllllllllllIlIIllIIllIllIIlI;
        if (this.field_174946_m != null) {
            this.func_174943_a(lllllllllllllllIlIIllIIllIllIIlI, this.field_174946_m);
        }
    }
    
    public TextureMap(final String lllllllllllllllIlIIllIIlllIIIlII, final IIconCreator lllllllllllllllIlIIllIIlllIIIIll, final boolean lllllllllllllllIlIIllIIlllIIIllI) {
        this.iconGrid = null;
        this.iconGridSize = -1;
        this.iconGridCountX = -1;
        this.iconGridCountY = -1;
        this.iconGridSizeU = -1.0;
        this.iconGridSizeV = -1.0;
        this.skipFirst = false;
        this.atlasWidth = 0;
        this.atlasHeight = 0;
        this.listAnimatedSprites = Lists.newArrayList();
        this.mapRegisteredSprites = Maps.newHashMap();
        this.mapUploadedSprites = Maps.newHashMap();
        this.missingImage = new TextureAtlasSprite("missingno");
        this.basePath = lllllllllllllllIlIIllIIlllIIIlII;
        this.field_174946_m = lllllllllllllllIlIIllIIlllIIIIll;
        this.skipFirst = (lllllllllllllllIlIIllIIlllIIIllI && TextureMap.ENABLE_SKIP);
    }
    
    private void updateIconGrid(final int lllllllllllllllIlIIlIllllllIIlII, final int lllllllllllllllIlIIlIllllllIIIll) {
        this.iconGridCountX = -1;
        this.iconGridCountY = -1;
        this.iconGrid = null;
        if (this.iconGridSize > 0) {
            this.iconGridCountX = lllllllllllllllIlIIlIllllllIIlII / this.iconGridSize;
            this.iconGridCountY = lllllllllllllllIlIIlIllllllIIIll / this.iconGridSize;
            this.iconGrid = new TextureAtlasSprite[this.iconGridCountX * this.iconGridCountY];
            this.iconGridSizeU = 1.0 / this.iconGridCountX;
            this.iconGridSizeV = 1.0 / this.iconGridCountY;
            for (final TextureAtlasSprite lllllllllllllllIlIIlIlllllllIIll : this.mapUploadedSprites.values()) {
                final double lllllllllllllllIlIIlIlllllllIIlI = 0.5 / lllllllllllllllIlIIlIllllllIIlII;
                final double lllllllllllllllIlIIlIlllllllIIIl = 0.5 / lllllllllllllllIlIIlIllllllIIIll;
                final double lllllllllllllllIlIIlIlllllllIIII = Math.min(lllllllllllllllIlIIlIlllllllIIll.getMinU(), lllllllllllllllIlIIlIlllllllIIll.getMaxU()) + lllllllllllllllIlIIlIlllllllIIlI;
                final double lllllllllllllllIlIIlIllllllIllll = Math.min(lllllllllllllllIlIIlIlllllllIIll.getMinV(), lllllllllllllllIlIIlIlllllllIIll.getMaxV()) + lllllllllllllllIlIIlIlllllllIIIl;
                final double lllllllllllllllIlIIlIllllllIlllI = Math.max(lllllllllllllllIlIIlIlllllllIIll.getMinU(), lllllllllllllllIlIIlIlllllllIIll.getMaxU()) - lllllllllllllllIlIIlIlllllllIIlI;
                final double lllllllllllllllIlIIlIllllllIllIl = Math.max(lllllllllllllllIlIIlIlllllllIIll.getMinV(), lllllllllllllllIlIIlIlllllllIIll.getMaxV()) - lllllllllllllllIlIIlIlllllllIIIl;
                final int lllllllllllllllIlIIlIllllllIllII = (int)(lllllllllllllllIlIIlIlllllllIIII / this.iconGridSizeU);
                final int lllllllllllllllIlIIlIllllllIlIll = (int)(lllllllllllllllIlIIlIllllllIllll / this.iconGridSizeV);
                final int lllllllllllllllIlIIlIllllllIlIlI = (int)(lllllllllllllllIlIIlIllllllIlllI / this.iconGridSizeU);
                final int lllllllllllllllIlIIlIllllllIlIIl = (int)(lllllllllllllllIlIIlIllllllIllIl / this.iconGridSizeV);
                for (int lllllllllllllllIlIIlIllllllIlIII = lllllllllllllllIlIIlIllllllIllII; lllllllllllllllIlIIlIllllllIlIII <= lllllllllllllllIlIIlIllllllIlIlI; ++lllllllllllllllIlIIlIllllllIlIII) {
                    if (lllllllllllllllIlIIlIllllllIlIII >= 0 && lllllllllllllllIlIIlIllllllIlIII < this.iconGridCountX) {
                        for (int lllllllllllllllIlIIlIllllllIIlll = lllllllllllllllIlIIlIllllllIlIll; lllllllllllllllIlIIlIllllllIIlll <= lllllllllllllllIlIIlIllllllIlIIl; ++lllllllllllllllIlIIlIllllllIIlll) {
                            if (lllllllllllllllIlIIlIllllllIIlll >= 0 && lllllllllllllllIlIIlIllllllIIlll < this.iconGridCountX) {
                                final int lllllllllllllllIlIIlIllllllIIllI = lllllllllllllllIlIIlIllllllIIlll * this.iconGridCountX + lllllllllllllllIlIIlIllllllIlIII;
                                this.iconGrid[lllllllllllllllIlIIlIllllllIIllI] = lllllllllllllllIlIIlIlllllllIIll;
                            }
                            else {
                                Config.warn(String.valueOf(new StringBuilder("Invalid grid V: ").append(lllllllllllllllIlIIlIllllllIIlll).append(", icon: ").append(lllllllllllllllIlIIlIlllllllIIll.getIconName())));
                            }
                        }
                    }
                    else {
                        Config.warn(String.valueOf(new StringBuilder("Invalid grid U: ").append(lllllllllllllllIlIIlIllllllIlIII).append(", icon: ").append(lllllllllllllllIlIIlIlllllllIIll.getIconName())));
                    }
                }
            }
        }
    }
    
    public TextureAtlasSprite func_174944_f() {
        return this.missingImage;
    }
    
    public int getCountRegisteredSprites() {
        return this.mapRegisteredSprites.size();
    }
    
    public TextureAtlasSprite func_174942_a(final ResourceLocation lllllllllllllllIlIIllIIIlIlllIlI) {
        if (lllllllllllllllIlIIllIIIlIlllIlI == null) {
            throw new IllegalArgumentException("Location cannot be null!");
        }
        TextureAtlasSprite lllllllllllllllIlIIllIIIlIlllIII = this.mapRegisteredSprites.get(lllllllllllllllIlIIllIIIlIlllIlI.toString());
        if (lllllllllllllllIlIIllIIIlIlllIII == null) {
            lllllllllllllllIlIIllIIIlIlllIII = TextureAtlasSprite.func_176604_a(lllllllllllllllIlIIllIIIlIlllIlI);
            this.mapRegisteredSprites.put(lllllllllllllllIlIIllIIIlIlllIlI.toString(), lllllllllllllllIlIIllIIIlIlllIII);
            if (lllllllllllllllIlIIllIIIlIlllIII instanceof TextureAtlasSprite && lllllllllllllllIlIIllIIIlIlllIII.getIndexInMap() < 0) {
                lllllllllllllllIlIIllIIIlIlllIII.setIndexInMap(this.mapRegisteredSprites.size());
            }
        }
        return lllllllllllllllIlIIllIIIlIlllIII;
    }
    
    public ResourceLocation completeResourceLocation(final ResourceLocation lllllllllllllllIlIIllIIlIIIIIIIl, final int lllllllllllllllIlIIllIIlIIIIIIII) {
        return this.isAbsoluteLocation(lllllllllllllllIlIIllIIlIIIIIIIl) ? ((lllllllllllllllIlIIllIIlIIIIIIII == 0) ? new ResourceLocation(lllllllllllllllIlIIllIIlIIIIIIIl.getResourceDomain(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIllIIlIIIIIIIl.getResourcePath())).append(".png"))) : new ResourceLocation(lllllllllllllllIlIIllIIlIIIIIIIl.getResourceDomain(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIllIIlIIIIIIIl.getResourcePath())).append("mipmap").append(lllllllllllllllIlIIllIIlIIIIIIII).append(".png")))) : ((lllllllllllllllIlIIllIIlIIIIIIII == 0) ? new ResourceLocation(lllllllllllllllIlIIllIIlIIIIIIIl.getResourceDomain(), String.format("%s/%s%s", this.basePath, lllllllllllllllIlIIllIIlIIIIIIIl.getResourcePath(), ".png")) : new ResourceLocation(lllllllllllllllIlIIllIIlIIIIIIIl.getResourceDomain(), String.format("%s/mipmaps/%s.%d%s", this.basePath, lllllllllllllllIlIIllIIlIIIIIIIl.getResourcePath(), lllllllllllllllIlIIllIIlIIIIIIII, ".png")));
    }
    
    public void func_174943_a(final IResourceManager lllllllllllllllIlIIllIIllIlIlIII, final IIconCreator lllllllllllllllIlIIllIIllIlIlIlI) {
        this.mapRegisteredSprites.clear();
        lllllllllllllllIlIIllIIllIlIlIlI.func_177059_a(this);
        if (this.mipmapLevels >= 4) {
            this.mipmapLevels = this.detectMaxMipmapLevel(this.mapRegisteredSprites, lllllllllllllllIlIIllIIllIlIlIII);
            Config.log(String.valueOf(new StringBuilder("Mipmap levels: ").append(this.mipmapLevels)));
        }
        this.initMissingImage();
        this.deleteGlTexture();
        this.loadTextureAtlas(lllllllllllllllIlIIllIIllIlIlIII);
    }
    
    private int getMinSpriteSize() {
        int lllllllllllllllIlIIllIIIIIlIIIlI = 1 << this.mipmapLevels;
        if (lllllllllllllllIlIIllIIIIIlIIIlI < 8) {
            lllllllllllllllIlIIllIIIIIlIIIlI = 8;
        }
        return lllllllllllllllIlIIllIIIIIlIIIlI;
    }
    
    private int detectMinimumSpriteSize(final Map lllllllllllllllIlIIllIIIIlIlIIlI, final IResourceManager lllllllllllllllIlIIllIIIIlIlIIIl, final int lllllllllllllllIlIIllIIIIlIlIIII) {
        final HashMap lllllllllllllllIlIIllIIIIlIIllll = new HashMap();
        final Set lllllllllllllllIlIIllIIIIlIIlllI = lllllllllllllllIlIIllIIIIlIlIIlI.entrySet();
        for (final Map.Entry lllllllllllllllIlIIllIIIIlIIlIlI : lllllllllllllllIlIIllIIIIlIIlllI) {
            final TextureAtlasSprite lllllllllllllllIlIIllIIIIlIIlIIl = lllllllllllllllIlIIllIIIIlIIlIlI.getValue();
            final ResourceLocation lllllllllllllllIlIIllIIIIlIIlIII = new ResourceLocation(lllllllllllllllIlIIllIIIIlIIlIIl.getIconName());
            final ResourceLocation lllllllllllllllIlIIllIIIIlIIIlll = this.completeResourceLocation(lllllllllllllllIlIIllIIIIlIIlIII, 0);
            if (!lllllllllllllllIlIIllIIIIlIIlIIl.hasCustomLoader(lllllllllllllllIlIIllIIIIlIlIIIl, lllllllllllllllIlIIllIIIIlIIlIII)) {
                try {
                    final IResource lllllllllllllllIlIIllIIIIlIIIllI = lllllllllllllllIlIIllIIIIlIlIIIl.getResource(lllllllllllllllIlIIllIIIIlIIIlll);
                    if (lllllllllllllllIlIIllIIIIlIIIllI == null) {
                        continue;
                    }
                    final InputStream lllllllllllllllIlIIllIIIIlIIIlIl = lllllllllllllllIlIIllIIIIlIIIllI.getInputStream();
                    if (lllllllllllllllIlIIllIIIIlIIIlIl == null) {
                        continue;
                    }
                    final Dimension lllllllllllllllIlIIllIIIIlIIIlII = TextureUtils.getImageSize(lllllllllllllllIlIIllIIIIlIIIlIl, "png");
                    if (lllllllllllllllIlIIllIIIIlIIIlII == null) {
                        continue;
                    }
                    final int lllllllllllllllIlIIllIIIIlIIllII = lllllllllllllllIlIIllIIIIlIIIlII.width;
                    final int lllllllllllllllIlIIllIIIIlIIIIll = MathHelper.roundUpToPowerOfTwo(lllllllllllllllIlIIllIIIIlIIllII);
                    if (!lllllllllllllllIlIIllIIIIlIIllll.containsKey(lllllllllllllllIlIIllIIIIlIIIIll)) {
                        lllllllllllllllIlIIllIIIIlIIllll.put(lllllllllllllllIlIIllIIIIlIIIIll, 1);
                    }
                    else {
                        final int lllllllllllllllIlIIllIIIIlIIIIlI = lllllllllllllllIlIIllIIIIlIIllll.get(lllllllllllllllIlIIllIIIIlIIIIll);
                        lllllllllllllllIlIIllIIIIlIIllll.put(lllllllllllllllIlIIllIIIIlIIIIll, lllllllllllllllIlIIllIIIIlIIIIlI + 1);
                    }
                }
                catch (Exception ex) {}
            }
        }
        int lllllllllllllllIlIIllIIIIlIIIIIl = 0;
        final Set lllllllllllllllIlIIllIIIIlIIIIII = lllllllllllllllIlIIllIIIIlIIllll.keySet();
        final TreeSet lllllllllllllllIlIIllIIIIIllllll = new TreeSet(lllllllllllllllIlIIllIIIIlIIIIII);
        for (final int lllllllllllllllIlIIllIIIIIlllllI : lllllllllllllllIlIIllIIIIIllllll) {
            final int lllllllllllllllIlIIllIIIIIllllII = lllllllllllllllIlIIllIIIIlIIllll.get(lllllllllllllllIlIIllIIIIIlllllI);
            lllllllllllllllIlIIllIIIIlIIIIIl += lllllllllllllllIlIIllIIIIIllllII;
        }
        int lllllllllllllllIlIIllIIIIIlllIIl = 16;
        int lllllllllllllllIlIIllIIIIIllllIl = 0;
        final int lllllllllllllllIlIIllIIIIIlllIll = lllllllllllllllIlIIllIIIIlIIIIIl * lllllllllllllllIlIIllIIIIlIlIIII / 100;
        for (final int lllllllllllllllIlIIllIIIIIllIlll : lllllllllllllllIlIIllIIIIIllllll) {
            final int lllllllllllllllIlIIllIIIIlIIlIll = lllllllllllllllIlIIllIIIIlIIllll.get(lllllllllllllllIlIIllIIIIIllIlll);
            lllllllllllllllIlIIllIIIIIllllIl += lllllllllllllllIlIIllIIIIlIIlIll;
            if (lllllllllllllllIlIIllIIIIIllIlll > lllllllllllllllIlIIllIIIIIlllIIl) {
                lllllllllllllllIlIIllIIIIIlllIIl = lllllllllllllllIlIIllIIIIIllIlll;
            }
            if (lllllllllllllllIlIIllIIIIIllllIl > lllllllllllllllIlIIllIIIIIlllIll) {
                return lllllllllllllllIlIIllIIIIIlllIIl;
            }
        }
        return lllllllllllllllIlIIllIIIIIlllIIl;
    }
    
    private void initMissingImage() {
        final int lllllllllllllllIlIIllIIllIllllII = this.getMinSpriteSize();
        final int[] lllllllllllllllIlIIllIIllIlllIll = this.getMissingImageData(lllllllllllllllIlIIllIIllIllllII);
        this.missingImage.setIconWidth(lllllllllllllllIlIIllIIllIllllII);
        this.missingImage.setIconHeight(lllllllllllllllIlIIllIIllIllllII);
        final int[][] lllllllllllllllIlIIllIIllIlllIlI = new int[this.mipmapLevels + 1][];
        lllllllllllllllIlIIllIIllIlllIlI[0] = lllllllllllllllIlIIllIIllIlllIll;
        this.missingImage.setFramesTextureData(Lists.newArrayList((Object[])new int[][][] { lllllllllllllllIlIIllIIllIlllIlI }));
        this.missingImage.setIndexInMap(0);
    }
    
    private boolean isTerrainAnimationActive(final TextureAtlasSprite lllllllllllllllIlIIllIIIIllllIII) {
        return (lllllllllllllllIlIIllIIIIllllIII != TextureUtils.iconWaterStill && lllllllllllllllIlIIllIIIIllllIII != TextureUtils.iconWaterFlow) ? ((lllllllllllllllIlIIllIIIIllllIII != TextureUtils.iconLavaStill && lllllllllllllllIlIIllIIIIllllIII != TextureUtils.iconLavaFlow) ? ((lllllllllllllllIlIIllIIIIllllIII != TextureUtils.iconFireLayer0 && lllllllllllllllIlIIllIIIIllllIII != TextureUtils.iconFireLayer1) ? ((lllllllllllllllIlIIllIIIIllllIII == TextureUtils.iconPortal) ? Config.isAnimatedPortal() : (lllllllllllllllIlIIllIIIIllllIII == TextureUtils.iconClock || lllllllllllllllIlIIllIIIIllllIII == TextureUtils.iconCompass || Config.isAnimatedTerrain())) : Config.isAnimatedFire()) : Config.isAnimatedLava()) : Config.isAnimatedWater();
    }
    
    static {
        __OBFID = "CL_00001058";
        logger = LogManager.getLogger();
        field_174945_f = new ResourceLocation("missingno");
        locationBlocksTexture = new ResourceLocation("textures/atlas/blocks.png");
        ENABLE_SKIP = Boolean.parseBoolean(System.getProperty("fml.skipFirstTextureLoad", "true"));
    }
    
    public void updateAnimations() {
        if (Config.isShaders()) {
            ShadersTex.updatingTex = this.getMultiTexID();
        }
        TextureUtil.bindTexture(this.getGlTextureId());
        for (final TextureAtlasSprite lllllllllllllllIlIIllIIIllIlIIII : this.listAnimatedSprites) {
            if (this.isTerrainAnimationActive(lllllllllllllllIlIIllIIIllIlIIII)) {
                lllllllllllllllIlIIllIIIllIlIIII.updateAnimation();
            }
        }
        if (Config.isMultiTexture()) {
            for (final TextureAtlasSprite lllllllllllllllIlIIllIIIllIIllII : this.listAnimatedSprites) {
                if (this.isTerrainAnimationActive(lllllllllllllllIlIIllIIIllIIllII)) {
                    final TextureAtlasSprite lllllllllllllllIlIIllIIIllIIlIlI = lllllllllllllllIlIIllIIIllIIllII.spriteSingle;
                    if (lllllllllllllllIlIIllIIIllIIlIlI == null) {
                        continue;
                    }
                    if (lllllllllllllllIlIIllIIIllIIllII == TextureUtils.iconClock || lllllllllllllllIlIIllIIIllIIllII == TextureUtils.iconCompass) {
                        lllllllllllllllIlIIllIIIllIIlIlI.frameCounter = lllllllllllllllIlIIllIIIllIIllII.frameCounter;
                    }
                    lllllllllllllllIlIIllIIIllIIllII.bindSpriteTexture();
                    lllllllllllllllIlIIllIIIllIIlIlI.updateAnimation();
                }
            }
            TextureUtil.bindTexture(this.getGlTextureId());
        }
        if (Config.isShaders()) {
            ShadersTex.updatingTex = null;
        }
    }
    
    public TextureAtlasSprite getIconByUV(final double lllllllllllllllIlIIlIlllllIIIllI, final double lllllllllllllllIlIIlIlllllIIIlIl) {
        if (this.iconGrid == null) {
            return null;
        }
        final int lllllllllllllllIlIIlIlllllIIlIlI = (int)(lllllllllllllllIlIIlIlllllIIIllI / this.iconGridSizeU);
        final int lllllllllllllllIlIIlIlllllIIlIIl = (int)(lllllllllllllllIlIIlIlllllIIIlIl / this.iconGridSizeV);
        final int lllllllllllllllIlIIlIlllllIIlIII = lllllllllllllllIlIIlIlllllIIlIIl * this.iconGridCountX + lllllllllllllllIlIIlIlllllIIlIlI;
        return (lllllllllllllllIlIIlIlllllIIlIII >= 0 && lllllllllllllllIlIIlIlllllIIlIII <= this.iconGrid.length) ? this.iconGrid[lllllllllllllllIlIIlIlllllIIlIII] : null;
    }
    
    private int[] getMissingImageData(final int lllllllllllllllIlIIllIIIIIIlIllI) {
        final BufferedImage lllllllllllllllIlIIllIIIIIIllIIl = new BufferedImage(16, 16, 2);
        lllllllllllllllIlIIllIIIIIIllIIl.setRGB(0, 0, 16, 16, TextureUtil.missingTextureData, 0, 16);
        final BufferedImage lllllllllllllllIlIIllIIIIIIllIII = TextureUtils.scaleToPowerOfTwo(lllllllllllllllIlIIllIIIIIIllIIl, lllllllllllllllIlIIllIIIIIIlIllI);
        final int[] lllllllllllllllIlIIllIIIIIIlIlll = new int[lllllllllllllllIlIIllIIIIIIlIllI * lllllllllllllllIlIIllIIIIIIlIllI];
        lllllllllllllllIlIIllIIIIIIllIII.getRGB(0, 0, lllllllllllllllIlIIllIIIIIIlIllI, lllllllllllllllIlIIllIIIIIIlIllI, lllllllllllllllIlIIllIIIIIIlIlll, 0, lllllllllllllllIlIIllIIIIIIlIllI);
        return lllllllllllllllIlIIllIIIIIIlIlll;
    }
    
    public TextureMap(final String lllllllllllllllIlIIllIIlllIlIIlI, final IIconCreator lllllllllllllllIlIIllIIlllIIlllI) {
        this(lllllllllllllllIlIIllIIlllIlIIlI, lllllllllllllllIlIIllIIlllIIlllI, false);
    }
    
    public TextureAtlasSprite getSpriteSafe(final String lllllllllllllllIlIIllIIIIlllllll) {
        final ResourceLocation lllllllllllllllIlIIllIIIIllllllI = new ResourceLocation(lllllllllllllllIlIIllIIIIlllllll);
        return this.mapRegisteredSprites.get(lllllllllllllllIlIIllIIIIllllllI.toString());
    }
    
    public TextureMap(final String lllllllllllllllIlIIllIIlllIllIII, final boolean lllllllllllllllIlIIllIIlllIllIlI) {
        this(lllllllllllllllIlIIllIIlllIllIII, null, lllllllllllllllIlIIllIIlllIllIlI);
    }
    
    @Override
    public void tick() {
        this.updateAnimations();
    }
    
    private boolean isAbsoluteLocationPath(final String lllllllllllllllIlIIllIIIlIIIIlll) {
        final String lllllllllllllllIlIIllIIIlIIIIllI = lllllllllllllllIlIIllIIIlIIIIlll.toLowerCase();
        return lllllllllllllllIlIIllIIIlIIIIllI.startsWith("mcpatcher/") || lllllllllllllllIlIIllIIIlIIIIllI.startsWith("optifine/");
    }
    
    public void setMipmapLevels(final int lllllllllllllllIlIIllIIIlIlIlIll) {
        this.mipmapLevels = lllllllllllllllIlIIllIIIlIlIlIll;
    }
}
