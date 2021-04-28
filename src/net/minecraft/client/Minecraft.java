package net.minecraft.client;

import net.minecraft.client.gui.achievement.*;
import net.minecraft.client.shader.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.entity.*;
import net.minecraft.profiler.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.server.integrated.*;
import net.minecraft.server.*;
import net.minecraft.client.resources.data.*;
import net.minecraft.entity.boss.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.*;
import net.minecraft.network.login.client.*;
import net.minecraft.world.storage.*;
import net.minecraft.crash.*;
import java.net.*;
import org.apache.commons.lang3.*;
import com.google.common.util.concurrent.*;
import net.minecraft.client.network.*;
import java.nio.*;
import org.apache.commons.io.*;
import java.io.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.client.renderer.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import org.lwjgl.*;
import net.minecraft.client.settings.*;
import org.lwjgl.input.*;
import hawk.*;
import net.minecraft.network.play.client.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.stream.*;
import net.minecraft.util.*;
import net.minecraft.client.main.*;
import com.mojang.authlib.yggdrasil.*;
import javax.imageio.*;
import net.minecraft.init.*;
import net.minecraft.client.gui.*;
import java.text.*;
import org.lwjgl.util.glu.*;
import java.util.*;
import java.util.concurrent.*;
import com.mojang.authlib.properties.*;
import com.google.common.collect.*;
import net.minecraft.client.stream.*;
import org.apache.logging.log4j.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.client.resources.*;
import net.minecraft.stats.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.multiplayer.*;
import org.lwjgl.opengl.*;
import java.awt.image.*;

public class Minecraft implements IThreadListener, IPlayerUsage
{
    public static /* synthetic */ byte[] memoryReserve;
    private final /* synthetic */ boolean isDemo;
    public /* synthetic */ boolean field_175614_C;
    public /* synthetic */ GameSettings gameSettings;
    public final /* synthetic */ Profiler mcProfiler;
    public /* synthetic */ int displayHeight;
    public /* synthetic */ GuiScreen currentScreen;
    /* synthetic */ long debugUpdateTime;
    public /* synthetic */ GuiAchievement guiAchievement;
    private /* synthetic */ LanguageManager mcLanguageManager;
    private final /* synthetic */ DefaultResourcePack mcDefaultResourcePack;
    private /* synthetic */ MusicTicker mcMusicTicker;
    private static final /* synthetic */ ResourceLocation locationMojangPng;
    public /* synthetic */ boolean inGameHasFocus;
    private final /* synthetic */ File fileAssets;
    public /* synthetic */ String debug;
    private /* synthetic */ long debugCrashKeyPressTime;
    public /* synthetic */ MouseHelper mouseHelper;
    public /* synthetic */ FontRenderer fontRendererObj;
    public /* synthetic */ MovingObjectPosition objectMouseOver;
    private /* synthetic */ boolean fullscreen;
    private final /* synthetic */ List defaultResourcePacks;
    private final /* synthetic */ Thread mcThread;
    private /* synthetic */ Framebuffer framebufferMc;
    public /* synthetic */ WorldClient theWorld;
    private final /* synthetic */ Queue scheduledTasks;
    private /* synthetic */ ServerData currentServerData;
    /* synthetic */ long systemTime;
    private /* synthetic */ boolean field_175619_R;
    private /* synthetic */ RenderManager renderManager;
    private /* synthetic */ boolean hasCrashed;
    private /* synthetic */ int leftClickCounter;
    /* synthetic */ int fpsCounter;
    private final /* synthetic */ Proxy proxy;
    public /* synthetic */ boolean field_175611_D;
    public /* synthetic */ RenderGlobal renderGlobal;
    private /* synthetic */ ResourceLocation mojangLogo;
    private /* synthetic */ ModelManager modelManager;
    private /* synthetic */ boolean isGamePaused;
    private /* synthetic */ ItemRenderer itemRenderer;
    private /* synthetic */ Entity field_175622_Z;
    private /* synthetic */ ResourcePackRepository mcResourcePackRepository;
    public /* synthetic */ Timer timer;
    public final /* synthetic */ File mcDataDir;
    private final /* synthetic */ PropertyMap twitchDetails;
    public /* synthetic */ EffectRenderer effectRenderer;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ String launchedVersion;
    private /* synthetic */ BlockRendererDispatcher field_175618_aM;
    private /* synthetic */ SoundHandler mcSoundHandler;
    private /* synthetic */ int tempDisplayWidth;
    public /* synthetic */ int displayWidth;
    public /* synthetic */ boolean skipRenderWorld;
    private static /* synthetic */ Minecraft theMinecraft;
    private /* synthetic */ ISaveFormat saveLoader;
    private /* synthetic */ NetworkManager myNetworkManager;
    private /* synthetic */ RenderItem renderItem;
    public /* synthetic */ GuiIngame ingameGUI;
    public /* synthetic */ boolean field_175612_E;
    public /* synthetic */ EntityRenderer entityRenderer;
    private /* synthetic */ SkinManager skinManager;
    public /* synthetic */ boolean field_175613_B;
    private /* synthetic */ CrashReport crashReporter;
    public /* synthetic */ LoadingScreenRenderer loadingScreen;
    public /* synthetic */ PlayerControllerMP playerController;
    public /* synthetic */ boolean integratedServerIsRunning;
    public static /* synthetic */ int debugFPS;
    private final /* synthetic */ File fileResourcepacks;
    private final /* synthetic */ IMetadataSerializer metadataSerializer_;
    private static final /* synthetic */ List macDisplayModes;
    private /* synthetic */ TextureMap textureMapBlocks;
    public /* synthetic */ int rightClickDelayTimer;
    public /* synthetic */ EntityPlayerSP thePlayer;
    private /* synthetic */ String debugProfilerName;
    public /* synthetic */ String serverName;
    private /* synthetic */ IStream stream;
    private /* synthetic */ PlayerUsageSnooper usageSnooper;
    public /* synthetic */ int serverPort;
    private final /* synthetic */ MinecraftSessionService sessionService;
    private /* synthetic */ TextureManager renderEngine;
    /* synthetic */ long prevFrameTime;
    private /* synthetic */ IReloadableResourceManager mcResourceManager;
    private /* synthetic */ IntegratedServer theIntegratedServer;
    private /* synthetic */ int joinPlayerCounter;
    private final /* synthetic */ boolean jvm64bit;
    volatile /* synthetic */ boolean running;
    public /* synthetic */ FontRenderer standardGalacticFontRenderer;
    private /* synthetic */ int tempDisplayHeight;
    public /* synthetic */ Session session;
    private /* synthetic */ long field_175615_aJ;
    
    public static boolean isGuiEnabled() {
        return Minecraft.theMinecraft == null || !Minecraft.theMinecraft.gameSettings.hideGUI;
    }
    
    public void loadWorld(final WorldClient lllllIlllIlIlI) {
        this.loadWorld(lllllIlllIlIlI, "");
    }
    
    public void func_175607_a(final Entity lllllIIIIlIIII) {
        this.field_175622_Z = lllllIIIIlIIII;
        this.entityRenderer.func_175066_a(lllllIIIIlIIII);
    }
    
    public IStream getTwitchStream() {
        return this.stream;
    }
    
    @Override
    public void addServerStatsToSnooper(final PlayerUsageSnooper lllllIlIIIIIIl) {
        lllllIlIIIIIIl.addClientStat("fps", Minecraft.debugFPS);
        lllllIlIIIIIIl.addClientStat("vsync_enabled", this.gameSettings.enableVsync);
        lllllIlIIIIIIl.addClientStat("display_frequency", Display.getDisplayMode().getFrequency());
        lllllIlIIIIIIl.addClientStat("display_type", this.fullscreen ? "fullscreen" : "windowed");
        lllllIlIIIIIIl.addClientStat("run_time", (MinecraftServer.getCurrentTimeMillis() - lllllIlIIIIIIl.getMinecraftStartTimeMillis()) / 60L * 1000L);
        final String lllllIlIIIIIII = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) ? "little" : "big";
        lllllIlIIIIIIl.addClientStat("endianness", lllllIlIIIIIII);
        lllllIlIIIIIIl.addClientStat("resource_packs", this.mcResourcePackRepository.getRepositoryEntries().size());
        int lllllIIlllllll = 0;
        for (final ResourcePackRepository.Entry lllllIIlllllIl : this.mcResourcePackRepository.getRepositoryEntries()) {
            lllllIlIIIIIIl.addClientStat(String.valueOf(new StringBuilder("resource_pack[").append(lllllIIlllllll++).append("]")), lllllIIlllllIl.getResourcePackName());
        }
        if (this.theIntegratedServer != null && this.theIntegratedServer.getPlayerUsageSnooper() != null) {
            lllllIlIIIIIIl.addClientStat("snooper_partner", this.theIntegratedServer.getPlayerUsageSnooper().getUniqueID());
        }
    }
    
    public void refreshResources() {
        final ArrayList lIIIIIIIlllIlII = Lists.newArrayList((Iterable)this.defaultResourcePacks);
        for (final ResourcePackRepository.Entry lIIIIIIIlllIIlI : this.mcResourcePackRepository.getRepositoryEntries()) {
            lIIIIIIIlllIlII.add(lIIIIIIIlllIIlI.getResourcePack());
        }
        if (this.mcResourcePackRepository.getResourcePackInstance() != null) {
            lIIIIIIIlllIlII.add(this.mcResourcePackRepository.getResourcePackInstance());
        }
        try {
            this.mcResourceManager.reloadResources(lIIIIIIIlllIlII);
        }
        catch (RuntimeException lIIIIIIIlllIIIl) {
            Minecraft.logger.info("Caught error stitching, removing all assigned resourcepacks", (Throwable)lIIIIIIIlllIIIl);
            lIIIIIIIlllIlII.clear();
            lIIIIIIIlllIlII.addAll(this.defaultResourcePacks);
            this.mcResourcePackRepository.func_148527_a(Collections.emptyList());
            this.mcResourceManager.reloadResources(lIIIIIIIlllIlII);
            this.gameSettings.resourcePacks.clear();
            this.gameSettings.saveOptions();
        }
        this.mcLanguageManager.parseLanguageMetadata(lIIIIIIIlllIlII);
        if (this.renderGlobal != null) {
            this.renderGlobal.loadRenderers();
        }
    }
    
    public TextureMap getTextureMapBlocks() {
        return this.textureMapBlocks;
    }
    
    private void func_175608_ak() {
        this.metadataSerializer_.registerMetadataSectionType(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new FontMetadataSectionSerializer(), FontMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new PackMetadataSectionSerializer(), PackMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
    }
    
    public PlayerUsageSnooper getPlayerUsageSnooper() {
        return this.usageSnooper;
    }
    
    public MusicTicker.MusicType getAmbientMusicType() {
        return (this.currentScreen instanceof GuiWinGame) ? MusicTicker.MusicType.CREDITS : ((this.thePlayer != null) ? ((this.thePlayer.worldObj.provider instanceof WorldProviderHell) ? MusicTicker.MusicType.NETHER : ((this.thePlayer.worldObj.provider instanceof WorldProviderEnd) ? ((BossStatus.bossName != null && BossStatus.statusBarTime > 0) ? MusicTicker.MusicType.END_BOSS : MusicTicker.MusicType.END) : ((this.thePlayer.capabilities.isCreativeMode && this.thePlayer.capabilities.allowFlying) ? MusicTicker.MusicType.CREATIVE : MusicTicker.MusicType.GAME))) : MusicTicker.MusicType.MENU);
    }
    
    public void shutdown() {
        this.running = false;
    }
    
    public void setDimensionAndSpawnPlayer(final int lllllIllIlIlIl) {
        this.theWorld.setInitialSpawnLocation();
        this.theWorld.removeAllEntities();
        int lllllIllIlIlII = 0;
        String lllllIllIlIIll = null;
        if (this.thePlayer != null) {
            lllllIllIlIlII = this.thePlayer.getEntityId();
            this.theWorld.removeEntity(this.thePlayer);
            lllllIllIlIIll = this.thePlayer.getClientBrand();
        }
        this.field_175622_Z = null;
        final EntityPlayerSP lllllIllIlIIlI = this.thePlayer;
        this.thePlayer = this.playerController.func_178892_a(this.theWorld, (this.thePlayer == null) ? new StatFileWriter() : this.thePlayer.getStatFileWriter());
        this.thePlayer.getDataWatcher().updateWatchedObjectsFromList(lllllIllIlIIlI.getDataWatcher().getAllWatched());
        this.thePlayer.dimension = lllllIllIlIlIl;
        this.field_175622_Z = this.thePlayer;
        this.thePlayer.preparePlayerToSpawn();
        this.thePlayer.func_175158_f(lllllIllIlIIll);
        this.theWorld.spawnEntityInWorld(this.thePlayer);
        this.playerController.flipPlayer(this.thePlayer);
        this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
        this.thePlayer.setEntityId(lllllIllIlIlII);
        this.playerController.setPlayerCapabilities(this.thePlayer);
        this.thePlayer.func_175150_k(lllllIllIlIIlI.func_175140_cp());
        if (this.currentScreen instanceof GuiGameOver) {
            this.displayGuiScreen(null);
        }
    }
    
    private void displayDebugInfo(final long lllllllIIlIlIl) {
        if (this.mcProfiler.profilingEnabled) {
            final List lllllllIIlIlII = this.mcProfiler.getProfilingData(this.debugProfilerName);
            final Profiler.Result lllllllIIlIIll = lllllllIIlIlII.remove(0);
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.enableColorMaterial();
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, this.displayWidth, this.displayHeight, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GL11.glLineWidth(1.0f);
            GlStateManager.func_179090_x();
            final Tessellator lllllllIIlIIlI = Tessellator.getInstance();
            final WorldRenderer lllllllIIlIIIl = lllllllIIlIIlI.getWorldRenderer();
            final short lllllllIIlIIII = 160;
            final int lllllllIIIllll = this.displayWidth - lllllllIIlIIII - 10;
            final int lllllllIIIlllI = this.displayHeight - lllllllIIlIIII * 2;
            GlStateManager.enableBlend();
            lllllllIIlIIIl.startDrawingQuads();
            lllllllIIlIIIl.func_178974_a(0, 200);
            lllllllIIlIIIl.addVertex(lllllllIIIllll - lllllllIIlIIII * 1.1f, lllllllIIIlllI - lllllllIIlIIII * 0.6f - 16.0f, 0.0);
            lllllllIIlIIIl.addVertex(lllllllIIIllll - lllllllIIlIIII * 1.1f, lllllllIIIlllI + lllllllIIlIIII * 2, 0.0);
            lllllllIIlIIIl.addVertex(lllllllIIIllll + lllllllIIlIIII * 1.1f, lllllllIIIlllI + lllllllIIlIIII * 2, 0.0);
            lllllllIIlIIIl.addVertex(lllllllIIIllll + lllllllIIlIIII * 1.1f, lllllllIIIlllI - lllllllIIlIIII * 0.6f - 16.0f, 0.0);
            lllllllIIlIIlI.draw();
            GlStateManager.disableBlend();
            double lllllllIIIllIl = 0.0;
            for (int lllllllIIIlIlI = 0; lllllllIIIlIlI < lllllllIIlIlII.size(); ++lllllllIIIlIlI) {
                final Profiler.Result lllllllIIIlIIl = lllllllIIlIlII.get(lllllllIIIlIlI);
                final int lllllllIIIllII = MathHelper.floor_double(lllllllIIIlIIl.field_76332_a / 4.0) + 1;
                lllllllIIlIIIl.startDrawing(6);
                lllllllIIlIIIl.func_178991_c(lllllllIIIlIIl.func_76329_a());
                lllllllIIlIIIl.addVertex(lllllllIIIllll, lllllllIIIlllI, 0.0);
                for (int lllllllIIIlIII = lllllllIIIllII; lllllllIIIlIII >= 0; --lllllllIIIlIII) {
                    final float lllllllIIIIlll = (float)((lllllllIIIllIl + lllllllIIIlIIl.field_76332_a * lllllllIIIlIII / lllllllIIIllII) * 3.141592653589793 * 2.0 / 100.0);
                    final float lllllllIIIIlIl = MathHelper.sin(lllllllIIIIlll) * lllllllIIlIIII;
                    final float lllllllIIIIIll = MathHelper.cos(lllllllIIIIlll) * lllllllIIlIIII * 0.5f;
                    lllllllIIlIIIl.addVertex(lllllllIIIllll + lllllllIIIIlIl, lllllllIIIlllI - lllllllIIIIIll, 0.0);
                }
                lllllllIIlIIlI.draw();
                lllllllIIlIIIl.startDrawing(5);
                lllllllIIlIIIl.func_178991_c((lllllllIIIlIIl.func_76329_a() & 0xFEFEFE) >> 1);
                for (int lllllllIIIlIII = lllllllIIIllII; lllllllIIIlIII >= 0; --lllllllIIIlIII) {
                    final float lllllllIIIIllI = (float)((lllllllIIIllIl + lllllllIIIlIIl.field_76332_a * lllllllIIIlIII / lllllllIIIllII) * 3.141592653589793 * 2.0 / 100.0);
                    final float lllllllIIIIlII = MathHelper.sin(lllllllIIIIllI) * lllllllIIlIIII;
                    final float lllllllIIIIIlI = MathHelper.cos(lllllllIIIIllI) * lllllllIIlIIII * 0.5f;
                    lllllllIIlIIIl.addVertex(lllllllIIIllll + lllllllIIIIlII, lllllllIIIlllI - lllllllIIIIIlI, 0.0);
                    lllllllIIlIIIl.addVertex(lllllllIIIllll + lllllllIIIIlII, lllllllIIIlllI - lllllllIIIIIlI + 10.0f, 0.0);
                }
                lllllllIIlIIlI.draw();
                lllllllIIIllIl += lllllllIIIlIIl.field_76332_a;
            }
            final DecimalFormat lllllllIIIIIIl = new DecimalFormat("##0.00");
            GlStateManager.func_179098_w();
            String lllllllIIIIIII = "";
            if (!lllllllIIlIIll.field_76331_c.equals("unspecified")) {
                lllllllIIIIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllIIIIIII)).append("[0] "));
            }
            if (lllllllIIlIIll.field_76331_c.length() == 0) {
                lllllllIIIIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllIIIIIII)).append("ROOT "));
            }
            else {
                lllllllIIIIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllIIIIIII)).append(lllllllIIlIIll.field_76331_c).append(" "));
            }
            final int lllllllIIIlIll = 16777215;
            this.fontRendererObj.drawStringWithShadow(lllllllIIIIIII, (float)(lllllllIIIllll - lllllllIIlIIII), (float)(lllllllIIIlllI - lllllllIIlIIII / 2 - 16), lllllllIIIlIll);
            this.fontRendererObj.drawStringWithShadow(lllllllIIIIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllIIIIIIl.format(lllllllIIlIIll.field_76330_b))).append("%")), (float)(lllllllIIIllll + lllllllIIlIIII - this.fontRendererObj.getStringWidth(lllllllIIIIIII)), (float)(lllllllIIIlllI - lllllllIIlIIII / 2 - 16), lllllllIIIlIll);
            for (int llllllIlllllll = 0; llllllIlllllll < lllllllIIlIlII.size(); ++llllllIlllllll) {
                final Profiler.Result llllllIllllllI = lllllllIIlIlII.get(llllllIlllllll);
                String llllllIlllllIl = "";
                if (llllllIllllllI.field_76331_c.equals("unspecified")) {
                    llllllIlllllIl = String.valueOf(new StringBuilder(String.valueOf(llllllIlllllIl)).append("[?] "));
                }
                else {
                    llllllIlllllIl = String.valueOf(new StringBuilder(String.valueOf(llllllIlllllIl)).append("[").append(llllllIlllllll + 1).append("] "));
                }
                llllllIlllllIl = String.valueOf(new StringBuilder(String.valueOf(llllllIlllllIl)).append(llllllIllllllI.field_76331_c));
                this.fontRendererObj.drawStringWithShadow(llllllIlllllIl, (float)(lllllllIIIllll - lllllllIIlIIII), (float)(lllllllIIIlllI + lllllllIIlIIII / 2 + llllllIlllllll * 8 + 20), llllllIllllllI.func_76329_a());
                this.fontRendererObj.drawStringWithShadow(llllllIlllllIl = String.valueOf(new StringBuilder(String.valueOf(lllllllIIIIIIl.format(llllllIllllllI.field_76332_a))).append("%")), (float)(lllllllIIIllll + lllllllIIlIIII - 50 - this.fontRendererObj.getStringWidth(llllllIlllllIl)), (float)(lllllllIIIlllI + lllllllIIlIIII / 2 + llllllIlllllll * 8 + 20), llllllIllllllI.func_76329_a());
                this.fontRendererObj.drawStringWithShadow(llllllIlllllIl = String.valueOf(new StringBuilder(String.valueOf(lllllllIIIIIIl.format(llllllIllllllI.field_76330_b))).append("%")), (float)(lllllllIIIllll + lllllllIIlIIII - this.fontRendererObj.getStringWidth(llllllIlllllIl)), (float)(lllllllIIIlllI + lllllllIIlIIII / 2 + llllllIlllllll * 8 + 20), llllllIllllllI.func_76329_a());
            }
        }
    }
    
    public void launchIntegratedServer(final String lllllIllllIlIl, final String llllllIIIIIIII, WorldSettings lllllIllllIIll) {
        this.loadWorld(null);
        System.gc();
        final ISaveHandler lllllIlllllllI = this.saveLoader.getSaveLoader(lllllIllllIlIl, false);
        WorldInfo lllllIllllllIl = lllllIlllllllI.loadWorldInfo();
        if (lllllIllllllIl == null && lllllIllllIIll != null) {
            lllllIllllllIl = new WorldInfo(lllllIllllIIll, lllllIllllIlIl);
            lllllIlllllllI.saveWorldInfo(lllllIllllllIl);
        }
        if (lllllIllllIIll == null) {
            lllllIllllIIll = new WorldSettings(lllllIllllllIl);
        }
        try {
            this.theIntegratedServer = new IntegratedServer(this, lllllIllllIlIl, llllllIIIIIIII, lllllIllllIIll);
            this.theIntegratedServer.startServerThread();
            this.integratedServerIsRunning = true;
        }
        catch (Throwable lllllIllllllII) {
            final CrashReport lllllIlllllIll = CrashReport.makeCrashReport(lllllIllllllII, "Starting integrated server");
            final CrashReportCategory lllllIlllllIlI = lllllIlllllIll.makeCategory("Starting integrated server");
            lllllIlllllIlI.addCrashSection("Level ID", lllllIllllIlIl);
            lllllIlllllIlI.addCrashSection("Level Name", llllllIIIIIIII);
            throw new ReportedException(lllllIlllllIll);
        }
        this.loadingScreen.displaySavingString(I18n.format("menu.loadingLevel", new Object[0]));
        while (!this.theIntegratedServer.serverIsInRunLoop()) {
            final String lllllIlllllIIl = this.theIntegratedServer.getUserMessage();
            if (lllllIlllllIIl != null) {
                this.loadingScreen.displayLoadingString(I18n.format(lllllIlllllIIl, new Object[0]));
            }
            else {
                this.loadingScreen.displayLoadingString("");
            }
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException ex) {}
        }
        this.displayGuiScreen(null);
        final SocketAddress lllllIlllllIII = this.theIntegratedServer.getNetworkSystem().addLocalEndpoint();
        final NetworkManager lllllIllllIlll = NetworkManager.provideLocalClient(lllllIlllllIII);
        lllllIllllIlll.setNetHandler(new NetHandlerLoginClient(lllllIllllIlll, this, null));
        lllllIllllIlll.sendPacket(new C00Handshake(47, lllllIlllllIII.toString(), 0, EnumConnectionState.LOGIN));
        lllllIllllIlll.sendPacket(new C00PacketLoginStart(this.getSession().getProfile()));
        this.myNetworkManager = lllllIllllIlll;
    }
    
    public boolean isIntegratedServerRunning() {
        return this.integratedServerIsRunning;
    }
    
    public boolean isGamePaused() {
        return this.isGamePaused;
    }
    
    public void scaledTessellator(final int lIIIIIIIIIlIIIl, final int lIIIIIIIIIlIIII, final int lIIIIIIIIIIllll, final int lIIIIIIIIIIlllI, final int lIIIIIIIIIIIlII, final int lIIIIIIIIIIIIll) {
        final float lIIIIIIIIIIlIll = 0.00390625f;
        final float lIIIIIIIIIIlIlI = 0.00390625f;
        final WorldRenderer lIIIIIIIIIIlIIl = Tessellator.getInstance().getWorldRenderer();
        lIIIIIIIIIIlIIl.startDrawingQuads();
        lIIIIIIIIIIlIIl.addVertexWithUV(lIIIIIIIIIlIIIl + 0, lIIIIIIIIIlIIII + lIIIIIIIIIIIIll, 0.0, (lIIIIIIIIIIllll + 0) * lIIIIIIIIIIlIll, (lIIIIIIIIIIlllI + lIIIIIIIIIIIIll) * lIIIIIIIIIIlIlI);
        lIIIIIIIIIIlIIl.addVertexWithUV(lIIIIIIIIIlIIIl + lIIIIIIIIIIIlII, lIIIIIIIIIlIIII + lIIIIIIIIIIIIll, 0.0, (lIIIIIIIIIIllll + lIIIIIIIIIIIlII) * lIIIIIIIIIIlIll, (lIIIIIIIIIIlllI + lIIIIIIIIIIIIll) * lIIIIIIIIIIlIlI);
        lIIIIIIIIIIlIIl.addVertexWithUV(lIIIIIIIIIlIIIl + lIIIIIIIIIIIlII, lIIIIIIIIIlIIII + 0, 0.0, (lIIIIIIIIIIllll + lIIIIIIIIIIIlII) * lIIIIIIIIIIlIll, (lIIIIIIIIIIlllI + 0) * lIIIIIIIIIIlIlI);
        lIIIIIIIIIIlIIl.addVertexWithUV(lIIIIIIIIIlIIIl + 0, lIIIIIIIIIlIIII + 0, 0.0, (lIIIIIIIIIIllll + 0) * lIIIIIIIIIIlIll, (lIIIIIIIIIIlllI + 0) * lIIIIIIIIIIlIlI);
        Tessellator.getInstance().draw();
    }
    
    public Session getSession() {
        return this.session;
    }
    
    private void updateDisplayMode() throws LWJGLException {
        final HashSet lIIIIIIIlIIlIlI = Sets.newHashSet();
        Collections.addAll(lIIIIIIIlIIlIlI, Display.getAvailableDisplayModes());
        DisplayMode lIIIIIIIlIIlIIl = Display.getDesktopDisplayMode();
        if (!lIIIIIIIlIIlIlI.contains(lIIIIIIIlIIlIIl) && Util.getOSType() == Util.EnumOS.OSX) {
            for (final DisplayMode lIIIIIIIlIIIlll : Minecraft.macDisplayModes) {
                boolean lIIIIIIIlIIIllI = true;
                for (final DisplayMode lIIIIIIIlIIIlII : lIIIIIIIlIIlIlI) {
                    if (lIIIIIIIlIIIlII.getBitsPerPixel() == 32 && lIIIIIIIlIIIlII.getWidth() == lIIIIIIIlIIIlll.getWidth() && lIIIIIIIlIIIlII.getHeight() == lIIIIIIIlIIIlll.getHeight()) {
                        lIIIIIIIlIIIllI = false;
                        break;
                    }
                }
                if (!lIIIIIIIlIIIllI) {
                    for (final DisplayMode lIIIIIIIlIIIIll : lIIIIIIIlIIlIlI) {
                        if (lIIIIIIIlIIIIll.getBitsPerPixel() == 32 && lIIIIIIIlIIIIll.getWidth() == lIIIIIIIlIIIlll.getWidth() / 2 && lIIIIIIIlIIIIll.getHeight() == lIIIIIIIlIIIlll.getHeight() / 2) {
                            lIIIIIIIlIIlIIl = lIIIIIIIlIIIIll;
                            break;
                        }
                    }
                }
            }
        }
        Display.setDisplayMode(lIIIIIIIlIIlIIl);
        this.displayWidth = lIIIIIIIlIIlIIl.getWidth();
        this.displayHeight = lIIIIIIIlIIlIIl.getHeight();
    }
    
    public ListenableFuture addScheduledTask(final Callable lllllIIIIIIlll) {
        Validate.notNull((Object)lllllIIIIIIlll);
        if (!this.isCallingFromMinecraftThread()) {
            final ListenableFutureTask lllllIIIIIIllI = ListenableFutureTask.create(lllllIIIIIIlll);
            final Queue lllllIIIIIIlIl = this.scheduledTasks;
            synchronized (this.scheduledTasks) {
                this.scheduledTasks.add(lllllIIIIIIllI);
                final ListenableFutureTask listenableFutureTask = lllllIIIIIIllI;
                // monitorexit(this.scheduledTasks)
                return (ListenableFuture)listenableFutureTask;
            }
        }
        try {
            return Futures.immediateFuture(lllllIIIIIIlll.call());
        }
        catch (Exception lllllIIIIIIlII) {
            return (ListenableFuture)Futures.immediateFailedCheckedFuture(lllllIIIIIIlII);
        }
    }
    
    public ListenableFuture func_175603_A() {
        return this.addScheduledTask(new Runnable() {
            static {
                __OBFID = "CL_00001853";
            }
            
            @Override
            public void run() {
                Minecraft.this.refreshResources();
            }
        });
    }
    
    public NetHandlerPlayClient getNetHandler() {
        return (this.thePlayer != null) ? this.thePlayer.sendQueue : null;
    }
    
    private void func_175594_ao() {
        final Util.EnumOS lIIIIIIlIllIlII = Util.getOSType();
        if (lIIIIIIlIllIlII != Util.EnumOS.OSX) {
            InputStream lIIIIIIlIllIIll = null;
            InputStream lIIIIIIlIllIIlI = null;
            try {
                lIIIIIIlIllIIll = this.mcDefaultResourcePack.func_152780_c(new ResourceLocation("icons/icon_16x16.png"));
                lIIIIIIlIllIIlI = this.mcDefaultResourcePack.func_152780_c(new ResourceLocation("icons/icon_32x32.png"));
                if (lIIIIIIlIllIIll != null && lIIIIIIlIllIIlI != null) {
                    Display.setIcon(new ByteBuffer[] { this.readImageToBuffer(lIIIIIIlIllIIll), this.readImageToBuffer(lIIIIIIlIllIIlI) });
                }
            }
            catch (IOException lIIIIIIlIllIIIl) {
                Minecraft.logger.error("Couldn't set icon", (Throwable)lIIIIIIlIllIIIl);
                return;
            }
            finally {
                IOUtils.closeQuietly(lIIIIIIlIllIIll);
                IOUtils.closeQuietly(lIIIIIIlIllIIlI);
            }
            IOUtils.closeQuietly(lIIIIIIlIllIIll);
            IOUtils.closeQuietly(lIIIIIIlIllIIlI);
        }
    }
    
    public RenderItem getRenderItem() {
        return this.renderItem;
    }
    
    private void func_175609_am() throws LWJGLException {
        Display.setResizable(true);
        Display.setTitle("Loading Minecraft...");
        try {
            Display.create(new PixelFormat().withDepthBits(24));
        }
        catch (LWJGLException lIIIIIIllIIIlIl) {
            Minecraft.logger.error("Couldn't set pixel format", (Throwable)lIIIIIIllIIIlIl);
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex) {}
            if (this.fullscreen) {
                this.updateDisplayMode();
            }
            Display.create();
        }
    }
    
    public boolean isUnicode() {
        return this.mcLanguageManager.isCurrentLocaleUnicode() || this.gameSettings.forceUnicodeFont;
    }
    
    public ResourcePackRepository getResourcePackRepository() {
        return this.mcResourcePackRepository;
    }
    
    private void runGameLoop() throws IOException {
        this.mcProfiler.startSection("root");
        if (Display.isCreated() && Display.isCloseRequested()) {
            this.shutdown();
        }
        if (this.isGamePaused && this.theWorld != null) {
            final float llllllllIlIlIl = this.timer.renderPartialTicks;
            this.timer.updateTimer();
            this.timer.renderPartialTicks = llllllllIlIlIl;
        }
        else {
            this.timer.updateTimer();
        }
        this.mcProfiler.startSection("scheduledExecutables");
        final Queue llllllllIlIlII = this.scheduledTasks;
        synchronized (this.scheduledTasks) {
            while (!this.scheduledTasks.isEmpty()) {
                this.scheduledTasks.poll().run();
            }
        }
        // monitorexit(this.scheduledTasks)
        this.mcProfiler.endSection();
        final long llllllllIlIIll = System.nanoTime();
        this.mcProfiler.startSection("tick");
        for (int llllllllIlIIlI = 0; llllllllIlIIlI < this.timer.elapsedTicks; ++llllllllIlIIlI) {
            this.runTick();
        }
        this.mcProfiler.endStartSection("preRenderErrors");
        final long llllllllIlIIIl = System.nanoTime() - llllllllIlIIll;
        this.checkGLError("Pre render");
        this.mcProfiler.endStartSection("sound");
        this.mcSoundHandler.setListener(this.thePlayer, this.timer.renderPartialTicks);
        this.mcProfiler.endSection();
        this.mcProfiler.startSection("render");
        GlStateManager.pushMatrix();
        GlStateManager.clear(16640);
        this.framebufferMc.bindFramebuffer(true);
        this.mcProfiler.startSection("display");
        GlStateManager.func_179098_w();
        if (this.thePlayer != null && this.thePlayer.isEntityInsideOpaqueBlock()) {
            this.gameSettings.thirdPersonView = 0;
        }
        this.mcProfiler.endSection();
        if (!this.skipRenderWorld) {
            this.mcProfiler.endStartSection("gameRenderer");
            this.entityRenderer.updateCameraAndRender(this.timer.renderPartialTicks);
            this.mcProfiler.endSection();
        }
        this.mcProfiler.endSection();
        if (this.gameSettings.showDebugInfo && this.gameSettings.showDebugProfilerChart && !this.gameSettings.hideGUI) {
            if (!this.mcProfiler.profilingEnabled) {
                this.mcProfiler.clearProfiling();
            }
            this.mcProfiler.profilingEnabled = true;
            this.displayDebugInfo(llllllllIlIIIl);
        }
        else {
            this.mcProfiler.profilingEnabled = false;
            this.prevFrameTime = System.nanoTime();
        }
        this.guiAchievement.updateAchievementWindow();
        this.framebufferMc.unbindFramebuffer();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.framebufferMc.framebufferRender(this.displayWidth, this.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.entityRenderer.func_152430_c(this.timer.renderPartialTicks);
        GlStateManager.popMatrix();
        this.mcProfiler.startSection("root");
        this.func_175601_h();
        Thread.yield();
        this.mcProfiler.startSection("stream");
        this.mcProfiler.startSection("update");
        this.stream.func_152935_j();
        this.mcProfiler.endStartSection("submit");
        this.stream.func_152922_k();
        this.mcProfiler.endSection();
        this.mcProfiler.endSection();
        this.checkGLError("Post render");
        ++this.fpsCounter;
        this.isGamePaused = (this.isSingleplayer() && this.currentScreen != null && this.currentScreen.doesGuiPauseGame() && !this.theIntegratedServer.getPublic());
        while (getSystemTime() >= this.debugUpdateTime + 1000L) {
            Minecraft.debugFPS = this.fpsCounter;
            this.debug = String.format("%d fps (%d chunk update%s) T: %s%s%s%s%s", Minecraft.debugFPS, RenderChunk.field_178592_a, (RenderChunk.field_178592_a != 1) ? "s" : "", (this.gameSettings.limitFramerate == GameSettings.Options.FRAMERATE_LIMIT.getValueMax()) ? "inf" : Integer.valueOf(this.gameSettings.limitFramerate), this.gameSettings.enableVsync ? " vsync" : "", this.gameSettings.fancyGraphics ? "" : " fast", this.gameSettings.clouds ? " clouds" : "", OpenGlHelper.func_176075_f() ? " vbo" : "");
            RenderChunk.field_178592_a = 0;
            this.debugUpdateTime += 1000L;
            this.fpsCounter = 0;
            this.usageSnooper.addMemoryStatsToSnooper();
            if (!this.usageSnooper.isSnooperRunning()) {
                this.usageSnooper.startSnooper();
            }
        }
        if (this.isFramerateLimitBelowMax()) {
            this.mcProfiler.startSection("fpslimit_wait");
            Display.sync(this.getLimitFramerate());
            this.mcProfiler.endSection();
        }
        this.mcProfiler.endSection();
    }
    
    public ServerData getCurrentServerData() {
        return this.currentServerData;
    }
    
    public static void stopIntegratedServer() {
        if (Minecraft.theMinecraft != null) {
            final IntegratedServer lllllIIlIlIIIl = Minecraft.theMinecraft.getIntegratedServer();
            if (lllllIIlIlIIIl != null) {
                lllllIIlIlIIIl.stopServer();
            }
        }
    }
    
    private void middleClickMouse() {
        if (this.objectMouseOver != null) {
            final boolean lllllIlIlllIlI = this.thePlayer.capabilities.isCreativeMode;
            int lllllIlIlllIIl = 0;
            boolean lllllIlIlllIII = false;
            TileEntity lllllIlIllIlll = null;
            Object lllllIlIlIlIIl = null;
            if (this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                final BlockPos lllllIlIlIlIII = this.objectMouseOver.func_178782_a();
                final Block lllllIlIlIIlll = this.theWorld.getBlockState(lllllIlIlIlIII).getBlock();
                if (lllllIlIlIIlll.getMaterial() == Material.air) {
                    return;
                }
                final Object lllllIlIllIllI = lllllIlIlIIlll.getItem(this.theWorld, lllllIlIlIlIII);
                if (lllllIlIllIllI == null) {
                    return;
                }
                if (lllllIlIlllIlI && GuiScreen.isCtrlKeyDown()) {
                    lllllIlIllIlll = this.theWorld.getTileEntity(lllllIlIlIlIII);
                }
                final Block lllllIlIlIIllI = (lllllIlIllIllI instanceof ItemBlock && !lllllIlIlIIlll.isFlowerPot()) ? Block.getBlockFromItem((Item)lllllIlIllIllI) : lllllIlIlIIlll;
                lllllIlIlllIIl = lllllIlIlIIllI.getDamageValue(this.theWorld, lllllIlIlIlIII);
                lllllIlIlllIII = ((Item)lllllIlIllIllI).getHasSubtypes();
            }
            else {
                if (this.objectMouseOver.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY || this.objectMouseOver.entityHit == null || !lllllIlIlllIlI) {
                    return;
                }
                if (this.objectMouseOver.entityHit instanceof EntityPainting) {
                    final Object lllllIlIllIlIl = Items.painting;
                }
                else if (this.objectMouseOver.entityHit instanceof EntityLeashKnot) {
                    final Object lllllIlIllIlII = Items.lead;
                }
                else if (this.objectMouseOver.entityHit instanceof EntityItemFrame) {
                    final EntityItemFrame lllllIlIlIIlIl = (EntityItemFrame)this.objectMouseOver.entityHit;
                    final ItemStack lllllIlIlIIlII = lllllIlIlIIlIl.getDisplayedItem();
                    if (lllllIlIlIIlII == null) {
                        final Object lllllIlIllIIll = Items.item_frame;
                    }
                    else {
                        final Object lllllIlIllIIlI = lllllIlIlIIlII.getItem();
                        lllllIlIlllIIl = lllllIlIlIIlII.getMetadata();
                        lllllIlIlllIII = true;
                    }
                }
                else if (this.objectMouseOver.entityHit instanceof EntityMinecart) {
                    final EntityMinecart lllllIlIlIIIll = (EntityMinecart)this.objectMouseOver.entityHit;
                    switch (SwitchEnumMinecartType.field_178901_b[lllllIlIlIIIll.func_180456_s().ordinal()]) {
                        case 1: {
                            final Object lllllIlIllIIIl = Items.furnace_minecart;
                            break;
                        }
                        case 2: {
                            final Object lllllIlIllIIII = Items.chest_minecart;
                            break;
                        }
                        case 3: {
                            final Object lllllIlIlIllll = Items.tnt_minecart;
                            break;
                        }
                        case 4: {
                            final Object lllllIlIlIlllI = Items.hopper_minecart;
                            break;
                        }
                        case 5: {
                            final Object lllllIlIlIllIl = Items.command_block_minecart;
                            break;
                        }
                        default: {
                            final Object lllllIlIlIllII = Items.minecart;
                            break;
                        }
                    }
                }
                else if (this.objectMouseOver.entityHit instanceof EntityBoat) {
                    final Object lllllIlIlIlIll = Items.boat;
                }
                else if (this.objectMouseOver.entityHit instanceof EntityArmorStand) {
                    final Object lllllIlIlIlIlI = Items.armor_stand;
                }
                else {
                    lllllIlIlIlIIl = Items.spawn_egg;
                    lllllIlIlllIIl = EntityList.getEntityID(this.objectMouseOver.entityHit);
                    lllllIlIlllIII = true;
                    if (!EntityList.entityEggs.containsKey(lllllIlIlllIIl)) {
                        return;
                    }
                }
            }
            final InventoryPlayer lllllIlIlIIIlI = this.thePlayer.inventory;
            if (lllllIlIllIlll == null) {
                lllllIlIlIIIlI.setCurrentItem((Item)lllllIlIlIlIIl, lllllIlIlllIIl, lllllIlIlllIII, lllllIlIlllIlI);
            }
            else {
                final NBTTagCompound lllllIlIlIIIIl = new NBTTagCompound();
                lllllIlIllIlll.writeToNBT(lllllIlIlIIIIl);
                final ItemStack lllllIlIlIIIII = new ItemStack((Item)lllllIlIlIlIIl, 1, lllllIlIlllIIl);
                lllllIlIlIIIII.setTagInfo("BlockEntityTag", lllllIlIlIIIIl);
                final NBTTagCompound lllllIlIIlllll = new NBTTagCompound();
                final NBTTagList lllllIlIIllllI = new NBTTagList();
                lllllIlIIllllI.appendTag(new NBTTagString("(+NBT)"));
                lllllIlIIlllll.setTag("Lore", lllllIlIIllllI);
                lllllIlIlIIIII.setTagInfo("display", lllllIlIIlllll);
                lllllIlIlIIIlI.setInventorySlotContents(lllllIlIlIIIlI.currentItem, lllllIlIlIIIII);
            }
            if (lllllIlIlllIlI) {
                final int lllllIlIIlllIl = this.thePlayer.inventoryContainer.inventorySlots.size() - 9 + lllllIlIlIIIlI.currentItem;
                this.playerController.sendSlotPacket(lllllIlIlIIIlI.getStackInSlot(lllllIlIlIIIlI.currentItem), lllllIlIIlllIl);
            }
        }
    }
    
    public boolean isFramerateLimitBelowMax() {
        return this.getLimitFramerate() < GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
    }
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return Thread.currentThread() == this.mcThread;
    }
    
    public void run() {
        this.running = true;
        try {
            this.startGame();
        }
        catch (Throwable lIIIIIIlllIIIII) {
            final CrashReport lIIIIIIlllIIIlI = CrashReport.makeCrashReport(lIIIIIIlllIIIII, "Initializing game");
            lIIIIIIlllIIIlI.makeCategory("Initialization");
            this.displayCrashReport(this.addGraphicsAndWorldToCrashReport(lIIIIIIlllIIIlI));
            return;
        }
        try {
            do {
                if (this.hasCrashed) {
                    if (this.crashReporter != null) {
                        this.displayCrashReport(this.crashReporter);
                        return;
                    }
                }
                try {
                    this.runGameLoop();
                }
                catch (OutOfMemoryError lIIIIIIllIlllll) {
                    this.freeMemory();
                    this.displayGuiScreen(new GuiMemoryErrorScreen());
                    System.gc();
                }
            } while (this.running);
        }
        catch (MinecraftError lIIIIIIllIllIlI) {}
        catch (ReportedException lIIIIIIllIllllI) {
            this.addGraphicsAndWorldToCrashReport(lIIIIIIllIllllI.getCrashReport());
            this.freeMemory();
            Minecraft.logger.fatal("Reported exception thrown!", (Throwable)lIIIIIIllIllllI);
            this.displayCrashReport(lIIIIIIllIllllI.getCrashReport());
        }
        catch (Throwable lIIIIIIllIlllIl) {
            final CrashReport lIIIIIIlllIIIIl = this.addGraphicsAndWorldToCrashReport(new CrashReport("Unexpected error", lIIIIIIllIlllIl));
            this.freeMemory();
            Minecraft.logger.fatal("Unreported exception thrown!", lIIIIIIllIlllIl);
            this.displayCrashReport(lIIIIIIlllIIIIl);
        }
        finally {
            this.shutdownMinecraftApplet();
        }
        this.shutdownMinecraftApplet();
    }
    
    public static boolean isFancyGraphicsEnabled() {
        return Minecraft.theMinecraft != null && Minecraft.theMinecraft.gameSettings.fancyGraphics;
    }
    
    private static boolean isJvm64bit() {
        final String[] lIIIIIIlIlIIIll;
        final String[] lIIIIIIlIlIIlII = lIIIIIIlIlIIIll = new String[] { "sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch" };
        for (int lIIIIIIlIlIIIlI = lIIIIIIlIlIIlII.length, lIIIIIIlIlIIIIl = 0; lIIIIIIlIlIIIIl < lIIIIIIlIlIIIlI; ++lIIIIIIlIlIIIIl) {
            final String lIIIIIIlIlIIIII = lIIIIIIlIlIIIll[lIIIIIIlIlIIIIl];
            final String lIIIIIIlIIlllll = System.getProperty(lIIIIIIlIlIIIII);
            if (lIIIIIIlIIlllll != null && lIIIIIIlIIlllll.contains("64")) {
                return true;
            }
        }
        return false;
    }
    
    public static long getSystemTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }
    
    public Entity func_175606_aa() {
        return this.field_175622_Z;
    }
    
    public void runTick() throws IOException {
        if (this.rightClickDelayTimer > 0) {
            --this.rightClickDelayTimer;
        }
        this.mcProfiler.startSection("gui");
        if (!this.isGamePaused) {
            this.ingameGUI.updateTick();
        }
        this.mcProfiler.endSection();
        this.entityRenderer.getMouseOver(1.0f);
        this.mcProfiler.startSection("gameMode");
        if (!this.isGamePaused && this.theWorld != null) {
            this.playerController.updateController();
        }
        this.mcProfiler.endStartSection("textures");
        if (!this.isGamePaused) {
            this.renderEngine.tick();
        }
        if (this.currentScreen == null && this.thePlayer != null) {
            if (this.thePlayer.getHealth() <= 0.0f) {
                this.displayGuiScreen(null);
            }
            else if (this.thePlayer.isPlayerSleeping() && this.theWorld != null) {
                this.displayGuiScreen(new GuiSleepMP());
            }
        }
        else if (this.currentScreen != null && this.currentScreen instanceof GuiSleepMP && !this.thePlayer.isPlayerSleeping()) {
            this.displayGuiScreen(null);
        }
        if (this.currentScreen != null) {
            this.leftClickCounter = 10000;
        }
        if (this.currentScreen != null) {
            try {
                this.currentScreen.handleInput();
            }
            catch (Throwable llllllIIIllllI) {
                final CrashReport llllllIIlIIlII = CrashReport.makeCrashReport(llllllIIIllllI, "Updating screen events");
                final CrashReportCategory llllllIIlIIIIl = llllllIIlIIlII.makeCategory("Affected screen");
                llllllIIlIIIIl.addCrashSectionCallable("Screen name", new Callable() {
                    static {
                        __OBFID = "CL_00000640";
                    }
                    
                    public Object call1() {
                        return this.call();
                    }
                    
                    @Override
                    public String call() {
                        return Minecraft.this.currentScreen.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(llllllIIlIIlII);
            }
            if (this.currentScreen != null) {
                try {
                    this.currentScreen.updateScreen();
                }
                catch (Throwable llllllIIIlllIl) {
                    final CrashReport llllllIIlIIIll = CrashReport.makeCrashReport(llllllIIIlllIl, "Ticking screen");
                    final CrashReportCategory llllllIIlIIIII = llllllIIlIIIll.makeCategory("Affected screen");
                    llllllIIlIIIII.addCrashSectionCallable("Screen name", new Callable() {
                        static {
                            __OBFID = "CL_00000642";
                        }
                        
                        @Override
                        public String call() {
                            return Minecraft.this.currentScreen.getClass().getCanonicalName();
                        }
                        
                        public Object call1() {
                            return this.call();
                        }
                    });
                    throw new ReportedException(llllllIIlIIIll);
                }
            }
        }
        if (this.currentScreen == null || this.currentScreen.allowUserInput) {
            this.mcProfiler.endStartSection("mouse");
            while (Mouse.next()) {
                final int llllllIIIlllII = Mouse.getEventButton();
                KeyBinding.setKeyBindState(llllllIIIlllII - 100, Mouse.getEventButtonState());
                if (Mouse.getEventButtonState()) {
                    if (this.thePlayer.func_175149_v() && llllllIIIlllII == 2) {
                        this.ingameGUI.func_175187_g().func_175261_b();
                    }
                    else {
                        KeyBinding.onTick(llllllIIIlllII - 100);
                    }
                }
                final long llllllIIIllIIl = getSystemTime() - this.systemTime;
                if (llllllIIIllIIl <= 200L) {
                    int llllllIIIllIII = Mouse.getEventDWheel();
                    if (llllllIIIllIII != 0) {
                        if (this.thePlayer.func_175149_v()) {
                            llllllIIIllIII = ((llllllIIIllIII < 0) ? -1 : 1);
                            if (this.ingameGUI.func_175187_g().func_175262_a()) {
                                this.ingameGUI.func_175187_g().func_175259_b(-llllllIIIllIII);
                            }
                            else {
                                final float llllllIIIlIlll = MathHelper.clamp_float(this.thePlayer.capabilities.getFlySpeed() + llllllIIIllIII * 0.005f, 0.0f, 0.2f);
                                this.thePlayer.capabilities.setFlySpeed(llllllIIIlIlll);
                            }
                        }
                        else {
                            this.thePlayer.inventory.changeCurrentItem(llllllIIIllIII);
                        }
                    }
                    if (this.currentScreen == null) {
                        if (this.inGameHasFocus || !Mouse.getEventButtonState()) {
                            continue;
                        }
                        this.setIngameFocus();
                    }
                    else {
                        if (this.currentScreen == null) {
                            continue;
                        }
                        this.currentScreen.handleMouseInput();
                    }
                }
            }
            if (this.leftClickCounter > 0) {
                --this.leftClickCounter;
            }
            this.mcProfiler.endStartSection("keyboard");
            while (Keyboard.next()) {
                final int llllllIIIllIll = (Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + '\u0100') : Keyboard.getEventKey();
                KeyBinding.setKeyBindState(llllllIIIllIll, Keyboard.getEventKeyState());
                if (Keyboard.getEventKeyState()) {
                    KeyBinding.onTick(llllllIIIllIll);
                }
                if (this.debugCrashKeyPressTime > 0L) {
                    if (getSystemTime() - this.debugCrashKeyPressTime >= 6000L) {
                        throw new ReportedException(new CrashReport("Manually triggered debug crash", new Throwable()));
                    }
                    if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61)) {
                        this.debugCrashKeyPressTime = -1L;
                    }
                }
                else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61)) {
                    this.debugCrashKeyPressTime = getSystemTime();
                }
                this.dispatchKeypresses();
                if (Keyboard.getEventKeyState()) {
                    if (llllllIIIllIll == 62 && this.entityRenderer != null) {
                        this.entityRenderer.func_175071_c();
                    }
                    if (this.currentScreen != null) {
                        this.currentScreen.handleKeyboardInput();
                    }
                    else {
                        Client.keyPress(llllllIIIllIll);
                        if (llllllIIIllIll == 1) {
                            this.displayInGameMenu();
                        }
                        if (llllllIIIllIll == 32 && Keyboard.isKeyDown(61) && this.ingameGUI != null) {
                            this.ingameGUI.getChatGUI().clearChatMessages();
                        }
                        if (llllllIIIllIll == 31 && Keyboard.isKeyDown(61)) {
                            this.refreshResources();
                        }
                        if (llllllIIIllIll != 17 || Keyboard.isKeyDown(61)) {}
                        if (llllllIIIllIll != 18 || Keyboard.isKeyDown(61)) {}
                        if (llllllIIIllIll != 47 || Keyboard.isKeyDown(61)) {}
                        if (llllllIIIllIll != 38 || Keyboard.isKeyDown(61)) {}
                        if (llllllIIIllIll != 22 || Keyboard.isKeyDown(61)) {}
                        if (llllllIIIllIll == 20 && Keyboard.isKeyDown(61)) {
                            this.refreshResources();
                        }
                        if (llllllIIIllIll == 33 && Keyboard.isKeyDown(61)) {
                            final boolean llllllIIIlIllI = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                            this.gameSettings.setOptionValue(GameSettings.Options.RENDER_DISTANCE, llllllIIIlIllI ? -1 : 1);
                        }
                        if (llllllIIIllIll == 30 && Keyboard.isKeyDown(61)) {
                            this.renderGlobal.loadRenderers();
                        }
                        if (llllllIIIllIll == 35 && Keyboard.isKeyDown(61)) {
                            this.gameSettings.advancedItemTooltips = !this.gameSettings.advancedItemTooltips;
                            this.gameSettings.saveOptions();
                        }
                        if (llllllIIIllIll == 48 && Keyboard.isKeyDown(61)) {
                            this.renderManager.func_178629_b(!this.renderManager.func_178634_b());
                        }
                        if (llllllIIIllIll == 25 && Keyboard.isKeyDown(61)) {
                            this.gameSettings.pauseOnLostFocus = !this.gameSettings.pauseOnLostFocus;
                            this.gameSettings.saveOptions();
                        }
                        if (llllllIIIllIll == 59) {
                            this.gameSettings.hideGUI = !this.gameSettings.hideGUI;
                        }
                        if (llllllIIIllIll == 61) {
                            this.gameSettings.showDebugInfo = !this.gameSettings.showDebugInfo;
                            this.gameSettings.showDebugProfilerChart = GuiScreen.isShiftKeyDown();
                        }
                        if (this.gameSettings.keyBindTogglePerspective.isPressed()) {
                            final GameSettings gameSettings = this.gameSettings;
                            ++gameSettings.thirdPersonView;
                            if (this.gameSettings.thirdPersonView > 2) {
                                this.gameSettings.thirdPersonView = 0;
                            }
                            if (this.gameSettings.thirdPersonView == 0) {
                                this.entityRenderer.func_175066_a(this.func_175606_aa());
                            }
                            else if (this.gameSettings.thirdPersonView == 1) {
                                this.entityRenderer.func_175066_a(null);
                            }
                        }
                        if (this.gameSettings.keyBindSmoothCamera.isPressed()) {
                            this.gameSettings.smoothCamera = !this.gameSettings.smoothCamera;
                        }
                    }
                    if (!this.gameSettings.showDebugInfo || !this.gameSettings.showDebugProfilerChart) {
                        continue;
                    }
                    if (llllllIIIllIll == 11) {
                        this.updateDebugProfilerName(0);
                    }
                    for (int llllllIIIlIlIl = 0; llllllIIIlIlIl < 9; ++llllllIIIlIlIl) {
                        if (llllllIIIllIll == 2 + llllllIIIlIlIl) {
                            this.updateDebugProfilerName(llllllIIIlIlIl + 1);
                        }
                    }
                }
            }
            for (int llllllIIIllIlI = 0; llllllIIIllIlI < 9; ++llllllIIIllIlI) {
                if (this.gameSettings.keyBindsHotbar[llllllIIIllIlI].isPressed()) {
                    if (this.thePlayer.func_175149_v()) {
                        this.ingameGUI.func_175187_g().func_175260_a(llllllIIIllIlI);
                    }
                    else {
                        this.thePlayer.inventory.currentItem = llllllIIIllIlI;
                    }
                }
            }
            final boolean llllllIIIlIlII = this.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN;
            while (this.gameSettings.keyBindInventory.isPressed()) {
                if (this.playerController.isRidingHorse()) {
                    this.thePlayer.func_175163_u();
                }
                else {
                    this.getNetHandler().addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT));
                    this.displayGuiScreen(new GuiInventory(this.thePlayer));
                }
            }
            while (this.gameSettings.keyBindDrop.isPressed()) {
                if (!this.thePlayer.func_175149_v()) {
                    this.thePlayer.dropOneItem(GuiScreen.isCtrlKeyDown());
                }
            }
            while (this.gameSettings.keyBindChat.isPressed() && llllllIIIlIlII) {
                this.displayGuiScreen(new GuiChat());
            }
            if (this.currentScreen == null && this.gameSettings.keyBindCommand.isPressed() && llllllIIIlIlII) {
                this.displayGuiScreen(new GuiChat("/"));
            }
            if (this.thePlayer.isUsingItem()) {
                if (!this.gameSettings.keyBindUseItem.getIsKeyPressed()) {
                    this.playerController.onStoppedUsingItem(this.thePlayer);
                }
                while (this.gameSettings.keyBindAttack.isPressed()) {}
                while (this.gameSettings.keyBindUseItem.isPressed()) {}
                while (this.gameSettings.keyBindPickBlock.isPressed()) {}
            }
            else {
                while (this.gameSettings.keyBindAttack.isPressed()) {
                    this.clickMouse();
                }
                while (this.gameSettings.keyBindUseItem.isPressed()) {
                    this.rightClickMouse();
                }
                while (this.gameSettings.keyBindPickBlock.isPressed()) {
                    this.middleClickMouse();
                }
            }
            if (this.gameSettings.keyBindUseItem.getIsKeyPressed() && this.rightClickDelayTimer == 0 && !this.thePlayer.isUsingItem()) {
                this.rightClickMouse();
            }
            this.sendClickBlockToController(this.currentScreen == null && this.gameSettings.keyBindAttack.getIsKeyPressed() && this.inGameHasFocus);
        }
        if (this.theWorld != null) {
            if (this.thePlayer != null) {
                ++this.joinPlayerCounter;
                if (this.joinPlayerCounter == 30) {
                    this.joinPlayerCounter = 0;
                    this.theWorld.joinEntityInSurroundings(this.thePlayer);
                }
            }
            this.mcProfiler.endStartSection("gameRenderer");
            if (!this.isGamePaused) {
                this.entityRenderer.updateRenderer();
            }
            this.mcProfiler.endStartSection("levelRenderer");
            if (!this.isGamePaused) {
                this.renderGlobal.updateClouds();
            }
            this.mcProfiler.endStartSection("level");
            if (!this.isGamePaused) {
                if (this.theWorld.func_175658_ac() > 0) {
                    this.theWorld.setLastLightningBolt(this.theWorld.func_175658_ac() - 1);
                }
                this.theWorld.updateEntities();
            }
        }
        if (!this.isGamePaused) {
            this.mcMusicTicker.update();
            this.mcSoundHandler.update();
        }
        if (this.theWorld != null) {
            if (!this.isGamePaused) {
                this.theWorld.setAllowedSpawnTypes(this.theWorld.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                try {
                    this.theWorld.tick();
                }
                catch (Throwable llllllIIIlIIll) {
                    final CrashReport llllllIIlIIIlI = CrashReport.makeCrashReport(llllllIIIlIIll, "Exception in world tick");
                    if (this.theWorld == null) {
                        final CrashReportCategory llllllIIIlllll = llllllIIlIIIlI.makeCategory("Affected level");
                        llllllIIIlllll.addCrashSection("Problem", "Level is null!");
                    }
                    else {
                        this.theWorld.addWorldInfoToCrashReport(llllllIIlIIIlI);
                    }
                    throw new ReportedException(llllllIIlIIIlI);
                }
            }
            this.mcProfiler.endStartSection("animateTick");
            if (!this.isGamePaused && this.theWorld != null) {
                this.theWorld.doVoidFogParticles(MathHelper.floor_double(this.thePlayer.posX), MathHelper.floor_double(this.thePlayer.posY), MathHelper.floor_double(this.thePlayer.posZ));
            }
            this.mcProfiler.endStartSection("particles");
            if (!this.isGamePaused) {
                this.effectRenderer.updateEffects();
            }
        }
        else if (this.myNetworkManager != null) {
            this.mcProfiler.endStartSection("pendingConnection");
            this.myNetworkManager.processReceivedPackets();
        }
        this.mcProfiler.endSection();
        this.systemTime = getSystemTime();
    }
    
    public void dispatchKeypresses() {
        final int lllllIIIIlllll = (Keyboard.getEventKey() == 0) ? Keyboard.getEventCharacter() : Keyboard.getEventKey();
        if (lllllIIIIlllll != 0 && !Keyboard.isRepeatEvent() && (!(this.currentScreen instanceof GuiControls) || ((GuiControls)this.currentScreen).time <= getSystemTime() - 20L)) {
            if (Keyboard.getEventKeyState()) {
                if (lllllIIIIlllll == this.gameSettings.keyBindStreamStartStop.getKeyCode()) {
                    if (this.getTwitchStream().func_152934_n()) {
                        this.getTwitchStream().func_152914_u();
                    }
                    else if (this.getTwitchStream().func_152924_m()) {
                        this.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
                            @Override
                            public void confirmClicked(final boolean llllllllllllllIlllIIllIlIIlIllll, final int llllllllllllllIlllIIllIlIIllIIIl) {
                                if (llllllllllllllIlllIIllIlIIlIllll) {
                                    Minecraft.this.getTwitchStream().func_152930_t();
                                }
                                Minecraft.this.displayGuiScreen(null);
                            }
                            
                            static {
                                __OBFID = "CL_00001852";
                            }
                        }, I18n.format("stream.confirm_start", new Object[0]), "", 0));
                    }
                    else if (this.getTwitchStream().func_152928_D() && this.getTwitchStream().func_152936_l()) {
                        if (this.theWorld != null) {
                            this.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("Not ready to start streaming yet!"));
                        }
                    }
                    else {
                        GuiStreamUnavailable.func_152321_a(this.currentScreen);
                    }
                }
                else if (lllllIIIIlllll == this.gameSettings.keyBindStreamPauseUnpause.getKeyCode()) {
                    if (this.getTwitchStream().func_152934_n()) {
                        if (this.getTwitchStream().isPaused()) {
                            this.getTwitchStream().func_152933_r();
                        }
                        else {
                            this.getTwitchStream().func_152916_q();
                        }
                    }
                }
                else if (lllllIIIIlllll == this.gameSettings.keyBindStreamCommercials.getKeyCode()) {
                    if (this.getTwitchStream().func_152934_n()) {
                        this.getTwitchStream().func_152931_p();
                    }
                }
                else if (lllllIIIIlllll == this.gameSettings.keyBindStreamToggleMic.getKeyCode()) {
                    this.stream.func_152910_a(true);
                }
                else if (lllllIIIIlllll == this.gameSettings.keyBindFullscreen.getKeyCode()) {
                    this.toggleFullscreen();
                }
                else if (lllllIIIIlllll == this.gameSettings.keyBindScreenshot.getKeyCode()) {
                    this.ingameGUI.getChatGUI().printChatMessage(ScreenShotHelper.saveScreenshot(this.mcDataDir, this.displayWidth, this.displayHeight, this.framebufferMc));
                }
            }
            else if (lllllIIIIlllll == this.gameSettings.keyBindStreamToggleMic.getKeyCode()) {
                this.stream.func_152910_a(false);
            }
        }
    }
    
    public IntegratedServer getIntegratedServer() {
        return this.theIntegratedServer;
    }
    
    public ItemRenderer getItemRenderer() {
        return this.itemRenderer;
    }
    
    public PropertyMap func_180509_L() {
        return this.twitchDetails;
    }
    
    public void displayGuiScreen(GuiScreen llllllllllIIIl) {
        if (this.currentScreen != null) {
            this.currentScreen.onGuiClosed();
        }
        if (llllllllllIIIl == null && this.theWorld == null) {
            llllllllllIIIl = new GuiMainMenu();
        }
        else if (llllllllllIIIl == null && this.thePlayer.getHealth() <= 0.0f) {
            llllllllllIIIl = new GuiGameOver();
        }
        if (llllllllllIIIl instanceof GuiMainMenu) {
            this.gameSettings.showDebugInfo = false;
            this.ingameGUI.getChatGUI().clearChatMessages();
        }
        if ((this.currentScreen = (GuiScreen)llllllllllIIIl) != null) {
            this.setIngameNotInFocus();
            final ScaledResolution llllllllllIlIl = new ScaledResolution(this, this.displayWidth, this.displayHeight);
            final int llllllllllIlII = llllllllllIlIl.getScaledWidth();
            final int llllllllllIIll = llllllllllIlIl.getScaledHeight();
            ((GuiScreen)llllllllllIIIl).setWorldAndResolution(this, llllllllllIlII, llllllllllIIll);
            this.skipRenderWorld = false;
        }
        else {
            this.mcSoundHandler.resumeSounds();
            this.setIngameFocus();
        }
    }
    
    public TextureManager getTextureManager() {
        return this.renderEngine;
    }
    
    public boolean isSingleplayer() {
        return this.integratedServerIsRunning && this.theIntegratedServer != null;
    }
    
    public void shutdownMinecraftApplet() {
        try {
            Client.shutdown();
            this.stream.shutdownStream();
            Minecraft.logger.info("Stopping!");
            try {
                this.loadWorld(null);
            }
            catch (Throwable t) {}
            this.mcSoundHandler.unloadSounds();
        }
        finally {
            Display.destroy();
            if (!this.hasCrashed) {
                System.exit(0);
            }
        }
        Display.destroy();
        if (!this.hasCrashed) {
            System.exit(0);
        }
        System.gc();
    }
    
    private void updateDebugProfilerName(int lllllllIlIllll) {
        final List lllllllIlIlllI = this.mcProfiler.getProfilingData(this.debugProfilerName);
        if (lllllllIlIlllI != null && !lllllllIlIlllI.isEmpty()) {
            final Profiler.Result lllllllIlIllIl = lllllllIlIlllI.remove(0);
            if (lllllllIlIllll == 0) {
                if (lllllllIlIllIl.field_76331_c.length() > 0) {
                    final int lllllllIlIllII = this.debugProfilerName.lastIndexOf(".");
                    if (lllllllIlIllII >= 0) {
                        this.debugProfilerName = this.debugProfilerName.substring(0, lllllllIlIllII);
                    }
                }
            }
            else if (--lllllllIlIllll < lllllllIlIlllI.size() && !lllllllIlIlllI.get(lllllllIlIllll).field_76331_c.equals("unspecified")) {
                if (this.debugProfilerName.length() > 0) {
                    this.debugProfilerName = String.valueOf(new StringBuilder(String.valueOf(this.debugProfilerName)).append("."));
                }
                this.debugProfilerName = String.valueOf(new StringBuilder(String.valueOf(this.debugProfilerName)).append(lllllllIlIlllI.get(lllllllIlIllll).field_76331_c));
            }
        }
    }
    
    @Override
    public void addServerTypeToSnooper(final PlayerUsageSnooper lllllIIlllIIlI) {
        lllllIIlllIIlI.addStatToSnooper("opengl_version", GL11.glGetString(7938));
        lllllIIlllIIlI.addStatToSnooper("opengl_vendor", GL11.glGetString(7936));
        lllllIIlllIIlI.addStatToSnooper("client_brand", ClientBrandRetriever.getClientModName());
        lllllIIlllIIlI.addStatToSnooper("launched_version", this.launchedVersion);
        final ContextCapabilities lllllIIlllIIIl = GLContext.getCapabilities();
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_arrays_of_arrays]", lllllIIlllIIIl.GL_ARB_arrays_of_arrays);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_base_instance]", lllllIIlllIIIl.GL_ARB_base_instance);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_blend_func_extended]", lllllIIlllIIIl.GL_ARB_blend_func_extended);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_clear_buffer_object]", lllllIIlllIIIl.GL_ARB_clear_buffer_object);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_color_buffer_float]", lllllIIlllIIIl.GL_ARB_color_buffer_float);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_compatibility]", lllllIIlllIIIl.GL_ARB_compatibility);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_compressed_texture_pixel_storage]", lllllIIlllIIIl.GL_ARB_compressed_texture_pixel_storage);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_compute_shader]", lllllIIlllIIIl.GL_ARB_compute_shader);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_copy_buffer]", lllllIIlllIIIl.GL_ARB_copy_buffer);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_copy_image]", lllllIIlllIIIl.GL_ARB_copy_image);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", lllllIIlllIIIl.GL_ARB_depth_buffer_float);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_compute_shader]", lllllIIlllIIIl.GL_ARB_compute_shader);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_copy_buffer]", lllllIIlllIIIl.GL_ARB_copy_buffer);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_copy_image]", lllllIIlllIIIl.GL_ARB_copy_image);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", lllllIIlllIIIl.GL_ARB_depth_buffer_float);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_depth_clamp]", lllllIIlllIIIl.GL_ARB_depth_clamp);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_depth_texture]", lllllIIlllIIIl.GL_ARB_depth_texture);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_draw_buffers]", lllllIIlllIIIl.GL_ARB_draw_buffers);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_draw_buffers_blend]", lllllIIlllIIIl.GL_ARB_draw_buffers_blend);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_draw_elements_base_vertex]", lllllIIlllIIIl.GL_ARB_draw_elements_base_vertex);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_draw_indirect]", lllllIIlllIIIl.GL_ARB_draw_indirect);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_draw_instanced]", lllllIIlllIIIl.GL_ARB_draw_instanced);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_explicit_attrib_location]", lllllIIlllIIIl.GL_ARB_explicit_attrib_location);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_explicit_uniform_location]", lllllIIlllIIIl.GL_ARB_explicit_uniform_location);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_fragment_layer_viewport]", lllllIIlllIIIl.GL_ARB_fragment_layer_viewport);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_fragment_program]", lllllIIlllIIIl.GL_ARB_fragment_program);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_fragment_shader]", lllllIIlllIIIl.GL_ARB_fragment_shader);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_fragment_program_shadow]", lllllIIlllIIIl.GL_ARB_fragment_program_shadow);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_framebuffer_object]", lllllIIlllIIIl.GL_ARB_framebuffer_object);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_framebuffer_sRGB]", lllllIIlllIIIl.GL_ARB_framebuffer_sRGB);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_geometry_shader4]", lllllIIlllIIIl.GL_ARB_geometry_shader4);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_gpu_shader5]", lllllIIlllIIIl.GL_ARB_gpu_shader5);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_half_float_pixel]", lllllIIlllIIIl.GL_ARB_half_float_pixel);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_half_float_vertex]", lllllIIlllIIIl.GL_ARB_half_float_vertex);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_instanced_arrays]", lllllIIlllIIIl.GL_ARB_instanced_arrays);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_map_buffer_alignment]", lllllIIlllIIIl.GL_ARB_map_buffer_alignment);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_map_buffer_range]", lllllIIlllIIIl.GL_ARB_map_buffer_range);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_multisample]", lllllIIlllIIIl.GL_ARB_multisample);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_multitexture]", lllllIIlllIIIl.GL_ARB_multitexture);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_occlusion_query2]", lllllIIlllIIIl.GL_ARB_occlusion_query2);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_pixel_buffer_object]", lllllIIlllIIIl.GL_ARB_pixel_buffer_object);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_seamless_cube_map]", lllllIIlllIIIl.GL_ARB_seamless_cube_map);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_shader_objects]", lllllIIlllIIIl.GL_ARB_shader_objects);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_shader_stencil_export]", lllllIIlllIIIl.GL_ARB_shader_stencil_export);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_shader_texture_lod]", lllllIIlllIIIl.GL_ARB_shader_texture_lod);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_shadow]", lllllIIlllIIIl.GL_ARB_shadow);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_shadow_ambient]", lllllIIlllIIIl.GL_ARB_shadow_ambient);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_stencil_texturing]", lllllIIlllIIIl.GL_ARB_stencil_texturing);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_sync]", lllllIIlllIIIl.GL_ARB_sync);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_tessellation_shader]", lllllIIlllIIIl.GL_ARB_tessellation_shader);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_texture_border_clamp]", lllllIIlllIIIl.GL_ARB_texture_border_clamp);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_texture_buffer_object]", lllllIIlllIIIl.GL_ARB_texture_buffer_object);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_texture_cube_map]", lllllIIlllIIIl.GL_ARB_texture_cube_map);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_texture_cube_map_array]", lllllIIlllIIIl.GL_ARB_texture_cube_map_array);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_texture_non_power_of_two]", lllllIIlllIIIl.GL_ARB_texture_non_power_of_two);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_uniform_buffer_object]", lllllIIlllIIIl.GL_ARB_uniform_buffer_object);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_vertex_blend]", lllllIIlllIIIl.GL_ARB_vertex_blend);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_vertex_buffer_object]", lllllIIlllIIIl.GL_ARB_vertex_buffer_object);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_vertex_program]", lllllIIlllIIIl.GL_ARB_vertex_program);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[ARB_vertex_shader]", lllllIIlllIIIl.GL_ARB_vertex_shader);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_bindable_uniform]", lllllIIlllIIIl.GL_EXT_bindable_uniform);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_blend_equation_separate]", lllllIIlllIIIl.GL_EXT_blend_equation_separate);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_blend_func_separate]", lllllIIlllIIIl.GL_EXT_blend_func_separate);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_blend_minmax]", lllllIIlllIIIl.GL_EXT_blend_minmax);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_blend_subtract]", lllllIIlllIIIl.GL_EXT_blend_subtract);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_draw_instanced]", lllllIIlllIIIl.GL_EXT_draw_instanced);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_framebuffer_multisample]", lllllIIlllIIIl.GL_EXT_framebuffer_multisample);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_framebuffer_object]", lllllIIlllIIIl.GL_EXT_framebuffer_object);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_framebuffer_sRGB]", lllllIIlllIIIl.GL_EXT_framebuffer_sRGB);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_geometry_shader4]", lllllIIlllIIIl.GL_EXT_geometry_shader4);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_gpu_program_parameters]", lllllIIlllIIIl.GL_EXT_gpu_program_parameters);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_gpu_shader4]", lllllIIlllIIIl.GL_EXT_gpu_shader4);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_multi_draw_arrays]", lllllIIlllIIIl.GL_EXT_multi_draw_arrays);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_packed_depth_stencil]", lllllIIlllIIIl.GL_EXT_packed_depth_stencil);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_paletted_texture]", lllllIIlllIIIl.GL_EXT_paletted_texture);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_rescale_normal]", lllllIIlllIIIl.GL_EXT_rescale_normal);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_separate_shader_objects]", lllllIIlllIIIl.GL_EXT_separate_shader_objects);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_shader_image_load_store]", lllllIIlllIIIl.GL_EXT_shader_image_load_store);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_shadow_funcs]", lllllIIlllIIIl.GL_EXT_shadow_funcs);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_shared_texture_palette]", lllllIIlllIIIl.GL_EXT_shared_texture_palette);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_stencil_clear_tag]", lllllIIlllIIIl.GL_EXT_stencil_clear_tag);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_stencil_two_side]", lllllIIlllIIIl.GL_EXT_stencil_two_side);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_stencil_wrap]", lllllIIlllIIIl.GL_EXT_stencil_wrap);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_texture_3d]", lllllIIlllIIIl.GL_EXT_texture_3d);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_texture_array]", lllllIIlllIIIl.GL_EXT_texture_array);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_texture_buffer_object]", lllllIIlllIIIl.GL_EXT_texture_buffer_object);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_texture_integer]", lllllIIlllIIIl.GL_EXT_texture_integer);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_texture_lod_bias]", lllllIIlllIIIl.GL_EXT_texture_lod_bias);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_texture_sRGB]", lllllIIlllIIIl.GL_EXT_texture_sRGB);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_vertex_shader]", lllllIIlllIIIl.GL_EXT_vertex_shader);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[EXT_vertex_weighting]", lllllIIlllIIIl.GL_EXT_vertex_weighting);
        lllllIIlllIIlI.addStatToSnooper("gl_caps[gl_max_vertex_uniforms]", GL11.glGetInteger(35658));
        GL11.glGetError();
        lllllIIlllIIlI.addStatToSnooper("gl_caps[gl_max_fragment_uniforms]", GL11.glGetInteger(35657));
        GL11.glGetError();
        lllllIIlllIIlI.addStatToSnooper("gl_caps[gl_max_vertex_attribs]", GL11.glGetInteger(34921));
        GL11.glGetError();
        lllllIIlllIIlI.addStatToSnooper("gl_caps[gl_max_vertex_texture_image_units]", GL11.glGetInteger(35660));
        GL11.glGetError();
        lllllIIlllIIlI.addStatToSnooper("gl_caps[gl_max_texture_image_units]", GL11.glGetInteger(34930));
        GL11.glGetError();
        lllllIIlllIIlI.addStatToSnooper("gl_caps[gl_max_texture_image_units]", GL11.glGetInteger(35071));
        GL11.glGetError();
        lllllIIlllIIlI.addStatToSnooper("gl_max_texture_size", getGLMaximumTextureSize());
    }
    
    public SkinManager getSkinManager() {
        return this.skinManager;
    }
    
    public LanguageManager getLanguageManager() {
        return this.mcLanguageManager;
    }
    
    private void startTimerHackThread() {
        final Thread lIIIIIIlIIIllll = new Thread("Timer hack thread") {
            @Override
            public void run() {
                while (Minecraft.this.running) {
                    try {
                        Thread.sleep(2147483647L);
                    }
                    catch (InterruptedException ex) {}
                }
            }
            
            static {
                __OBFID = "CL_00000639";
            }
        };
        lIIIIIIlIIIllll.setDaemon(true);
        lIIIIIIlIIIllll.start();
    }
    
    public Minecraft(final GameConfiguration lIIIIIIlllIlIII) {
        this.field_175619_R = true;
        this.timer = new Timer(20.0f);
        this.usageSnooper = new PlayerUsageSnooper("client", this, MinecraftServer.getCurrentTimeMillis());
        this.systemTime = getSystemTime();
        this.mcProfiler = new Profiler();
        this.debugCrashKeyPressTime = -1L;
        this.metadataSerializer_ = new IMetadataSerializer();
        this.defaultResourcePacks = Lists.newArrayList();
        this.scheduledTasks = Queues.newArrayDeque();
        this.field_175615_aJ = 0L;
        this.mcThread = Thread.currentThread();
        this.running = true;
        this.debug = "";
        this.field_175613_B = false;
        this.field_175614_C = false;
        this.field_175611_D = false;
        this.field_175612_E = true;
        this.debugUpdateTime = getSystemTime();
        this.prevFrameTime = -1L;
        this.debugProfilerName = "root";
        Minecraft.theMinecraft = this;
        this.mcDataDir = lIIIIIIlllIlIII.field_178744_c.field_178760_a;
        this.fileAssets = lIIIIIIlllIlIII.field_178744_c.field_178759_c;
        this.fileResourcepacks = lIIIIIIlllIlIII.field_178744_c.field_178758_b;
        this.launchedVersion = lIIIIIIlllIlIII.field_178741_d.field_178755_b;
        this.twitchDetails = lIIIIIIlllIlIII.field_178745_a.field_178750_b;
        this.mcDefaultResourcePack = new DefaultResourcePack(new ResourceIndex(lIIIIIIlllIlIII.field_178744_c.field_178759_c, lIIIIIIlllIlIII.field_178744_c.field_178757_d).func_152782_a());
        this.proxy = ((lIIIIIIlllIlIII.field_178745_a.field_178751_c == null) ? Proxy.NO_PROXY : lIIIIIIlllIlIII.field_178745_a.field_178751_c);
        this.sessionService = new YggdrasilAuthenticationService(lIIIIIIlllIlIII.field_178745_a.field_178751_c, UUID.randomUUID().toString()).createMinecraftSessionService();
        this.session = lIIIIIIlllIlIII.field_178745_a.field_178752_a;
        Minecraft.logger.info(String.valueOf(new StringBuilder("Setting user: ").append(this.session.getUsername())));
        Minecraft.logger.info(String.valueOf(new StringBuilder("(Session ID is ").append(this.session.getSessionID()).append(")")));
        this.isDemo = lIIIIIIlllIlIII.field_178741_d.field_178756_a;
        this.displayWidth = ((lIIIIIIlllIlIII.field_178743_b.field_178764_a > 0) ? lIIIIIIlllIlIII.field_178743_b.field_178764_a : 1);
        this.displayHeight = ((lIIIIIIlllIlIII.field_178743_b.field_178762_b > 0) ? lIIIIIIlllIlIII.field_178743_b.field_178762_b : 1);
        this.tempDisplayWidth = lIIIIIIlllIlIII.field_178743_b.field_178764_a;
        this.tempDisplayHeight = lIIIIIIlllIlIII.field_178743_b.field_178762_b;
        this.fullscreen = lIIIIIIlllIlIII.field_178743_b.field_178763_c;
        this.jvm64bit = isJvm64bit();
        this.theIntegratedServer = new IntegratedServer(this);
        if (lIIIIIIlllIlIII.field_178742_e.field_178754_a != null) {
            this.serverName = lIIIIIIlllIlIII.field_178742_e.field_178754_a;
            this.serverPort = lIIIIIIlllIlIII.field_178742_e.field_178753_b;
        }
        ImageIO.setUseCache(false);
        Bootstrap.register();
    }
    
    public static int func_175610_ah() {
        return Minecraft.debugFPS;
    }
    
    public void displayInGameMenu() {
        if (this.currentScreen == null) {
            this.displayGuiScreen(new GuiIngameMenu());
            if (this.isSingleplayer() && !this.theIntegratedServer.getPublic()) {
                this.mcSoundHandler.pauseSounds();
            }
        }
    }
    
    public void displayCrashReport(final CrashReport lIIIIIIlIIIIIlI) {
        final File lIIIIIIlIIIIIIl = new File(getMinecraft().mcDataDir, "crash-reports");
        final File lIIIIIIlIIIIIII = new File(lIIIIIIlIIIIIIl, String.valueOf(new StringBuilder("crash-").append(new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date())).append("-client.txt")));
        Bootstrap.func_179870_a(lIIIIIIlIIIIIlI.getCompleteReport());
        if (lIIIIIIlIIIIIlI.getFile() != null) {
            Bootstrap.func_179870_a(String.valueOf(new StringBuilder("#@!@# Game crashed! Crash report saved to: #@!@# ").append(lIIIIIIlIIIIIlI.getFile())));
            System.exit(-1);
        }
        else if (lIIIIIIlIIIIIlI.saveToFile(lIIIIIIlIIIIIII)) {
            Bootstrap.func_179870_a(String.valueOf(new StringBuilder("#@!@# Game crashed! Crash report saved to: #@!@# ").append(lIIIIIIlIIIIIII.getAbsolutePath())));
            System.exit(-1);
        }
        else {
            Bootstrap.func_179870_a("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(-2);
        }
    }
    
    private void func_180510_a(final TextureManager lIIIIIIIIlIllll) {
        final ScaledResolution lIIIIIIIIlIlllI = new ScaledResolution(this, this.displayWidth, this.displayHeight);
        final int lIIIIIIIIlIllIl = lIIIIIIIIlIlllI.getScaleFactor();
        final Framebuffer lIIIIIIIIlIllII = new Framebuffer(lIIIIIIIIlIlllI.getScaledWidth() * lIIIIIIIIlIllIl, lIIIIIIIIlIlllI.getScaledHeight() * lIIIIIIIIlIllIl, true);
        lIIIIIIIIlIllII.bindFramebuffer(false);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, lIIIIIIIIlIlllI.getScaledWidth(), lIIIIIIIIlIlllI.getScaledHeight(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.func_179098_w();
        InputStream lIIIIIIIIlIlIll = null;
        Label_0212: {
            try {
                lIIIIIIIIlIlIll = this.mcDefaultResourcePack.getInputStream(Minecraft.locationMojangPng);
                this.mojangLogo = lIIIIIIIIlIllll.getDynamicTextureLocation("logo", new DynamicTexture(ImageIO.read(lIIIIIIIIlIlIll)));
                lIIIIIIIIlIllll.bindTexture(this.mojangLogo);
            }
            catch (IOException lIIIIIIIIlIlIlI) {
                Minecraft.logger.error(String.valueOf(new StringBuilder("Unable to load logo: ").append(Minecraft.locationMojangPng)), (Throwable)lIIIIIIIIlIlIlI);
                break Label_0212;
            }
            finally {
                IOUtils.closeQuietly(lIIIIIIIIlIlIll);
            }
            IOUtils.closeQuietly(lIIIIIIIIlIlIll);
        }
        final Tessellator lIIIIIIIIlIlIIl = Tessellator.getInstance();
        final WorldRenderer lIIIIIIIIlIlIII = lIIIIIIIIlIlIIl.getWorldRenderer();
        lIIIIIIIIlIlIII.startDrawingQuads();
        lIIIIIIIIlIlIII.func_178991_c(16777215);
        lIIIIIIIIlIlIII.addVertexWithUV(0.0, this.displayHeight, 0.0, 0.0, 0.0);
        lIIIIIIIIlIlIII.addVertexWithUV(this.displayWidth, this.displayHeight, 0.0, 0.0, 0.0);
        lIIIIIIIIlIlIII.addVertexWithUV(this.displayWidth, 0.0, 0.0, 0.0, 0.0);
        lIIIIIIIIlIlIII.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0.0);
        lIIIIIIIIlIlIIl.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        lIIIIIIIIlIlIII.func_178991_c(16777215);
        final short lIIIIIIIIlIIlll = 256;
        final short lIIIIIIIIlIIllI = 256;
        this.scaledTessellator((lIIIIIIIIlIlllI.getScaledWidth() - lIIIIIIIIlIIlll) / 2, (lIIIIIIIIlIlllI.getScaledHeight() - lIIIIIIIIlIIllI) / 2, 0, 0, lIIIIIIIIlIIlll, lIIIIIIIIlIIllI);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        lIIIIIIIIlIllII.unbindFramebuffer();
        lIIIIIIIIlIllII.framebufferRender(lIIIIIIIIlIlllI.getScaledWidth() * lIIIIIIIIlIllIl, lIIIIIIIIlIlllI.getScaledHeight() * lIIIIIIIIlIllIl);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        this.func_175601_h();
    }
    
    private void checkGLError(final String lllllllllIlIII) {
        if (this.field_175619_R) {
            final int lllllllllIIlll = GL11.glGetError();
            if (lllllllllIIlll != 0) {
                final String lllllllllIIllI = GLU.gluErrorString(lllllllllIIlll);
                Minecraft.logger.error("########## GL ERROR ##########");
                Minecraft.logger.error(String.valueOf(new StringBuilder("@ ").append(lllllllllIlIII)));
                Minecraft.logger.error(String.valueOf(new StringBuilder(String.valueOf(lllllllllIIlll)).append(": ").append(lllllllllIIllI)));
            }
        }
    }
    
    public BlockRendererDispatcher getBlockRendererDispatcher() {
        return this.field_175618_aM;
    }
    
    private void rightClickMouse() {
        this.rightClickDelayTimer = 4;
        boolean llllllIlIIlIll = true;
        final ItemStack llllllIlIIlIlI = this.thePlayer.inventory.getCurrentItem();
        if (this.objectMouseOver == null) {
            Minecraft.logger.warn("Null returned as 'hitResult', this shouldn't happen!");
        }
        else {
            switch (SwitchEnumMinecartType.field_152390_a[this.objectMouseOver.typeOfHit.ordinal()]) {
                case 1: {
                    if (this.playerController.func_178894_a(this.thePlayer, this.objectMouseOver.entityHit, this.objectMouseOver)) {
                        llllllIlIIlIll = false;
                        break;
                    }
                    if (this.playerController.interactWithEntitySendPacket(this.thePlayer, this.objectMouseOver.entityHit)) {
                        llllllIlIIlIll = false;
                        break;
                    }
                    break;
                }
                case 2: {
                    final BlockPos llllllIlIIlIIl = this.objectMouseOver.func_178782_a();
                    if (this.theWorld.getBlockState(llllllIlIIlIIl).getBlock().getMaterial() == Material.air) {
                        break;
                    }
                    final int llllllIlIIlIII = (llllllIlIIlIlI != null) ? llllllIlIIlIlI.stackSize : 0;
                    if (this.playerController.func_178890_a(this.thePlayer, this.theWorld, llllllIlIIlIlI, llllllIlIIlIIl, this.objectMouseOver.field_178784_b, this.objectMouseOver.hitVec)) {
                        llllllIlIIlIll = false;
                        this.thePlayer.swingItem();
                    }
                    if (llllllIlIIlIlI == null) {
                        return;
                    }
                    if (llllllIlIIlIlI.stackSize == 0) {
                        this.thePlayer.inventory.mainInventory[this.thePlayer.inventory.currentItem] = null;
                        break;
                    }
                    if (llllllIlIIlIlI.stackSize != llllllIlIIlIII || this.playerController.isInCreativeMode()) {
                        this.entityRenderer.itemRenderer.resetEquippedProgress();
                        break;
                    }
                    break;
                }
            }
        }
        if (llllllIlIIlIll) {
            final ItemStack llllllIlIIIlll = this.thePlayer.inventory.getCurrentItem();
            if (llllllIlIIIlll != null && this.playerController.sendUseItem(this.thePlayer, this.theWorld, llllllIlIIIlll)) {
                this.entityRenderer.itemRenderer.resetEquippedProgress2();
            }
        }
    }
    
    public static Map func_175596_ai() {
        final HashMap llllIllllIlIII = Maps.newHashMap();
        llllIllllIlIII.put("X-Minecraft-Username", getMinecraft().getSession().getUsername());
        llllIllllIlIII.put("X-Minecraft-UUID", getMinecraft().getSession().getPlayerID());
        llllIllllIlIII.put("X-Minecraft-Version", "1.8");
        return llllIllllIlIII;
    }
    
    public void loadWorld(final WorldClient lllllIllIllllI, final String lllllIlllIIIIl) {
        if (lllllIllIllllI == null) {
            final NetHandlerPlayClient lllllIlllIIIII = this.getNetHandler();
            if (lllllIlllIIIII != null) {
                lllllIlllIIIII.cleanup();
            }
            if (this.theIntegratedServer != null && this.theIntegratedServer.func_175578_N()) {
                this.theIntegratedServer.initiateShutdown();
                this.theIntegratedServer.func_175592_a();
            }
            this.theIntegratedServer = null;
            this.guiAchievement.clearAchievements();
            this.entityRenderer.getMapItemRenderer().func_148249_a();
        }
        this.field_175622_Z = null;
        this.myNetworkManager = null;
        if (this.loadingScreen != null) {
            this.loadingScreen.resetProgressAndMessage(lllllIlllIIIIl);
            this.loadingScreen.displayLoadingString("");
        }
        if (lllllIllIllllI == null && this.theWorld != null) {
            if (this.mcResourcePackRepository.getResourcePackInstance() != null) {
                this.mcResourcePackRepository.func_148529_f();
                this.func_175603_A();
            }
            this.setServerData(null);
            this.integratedServerIsRunning = false;
        }
        this.mcSoundHandler.stopSounds();
        if ((this.theWorld = lllllIllIllllI) != null) {
            if (this.renderGlobal != null) {
                this.renderGlobal.setWorldAndLoadRenderers(lllllIllIllllI);
            }
            if (this.effectRenderer != null) {
                this.effectRenderer.clearEffects(lllllIllIllllI);
            }
            if (this.thePlayer == null) {
                this.thePlayer = this.playerController.func_178892_a(lllllIllIllllI, new StatFileWriter());
                this.playerController.flipPlayer(this.thePlayer);
            }
            this.thePlayer.preparePlayerToSpawn();
            lllllIllIllllI.spawnEntityInWorld(this.thePlayer);
            this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
            this.playerController.setPlayerCapabilities(this.thePlayer);
            this.field_175622_Z = this.thePlayer;
        }
        else {
            this.saveLoader.flushCache();
            this.thePlayer = null;
        }
        System.gc();
        this.systemTime = 0L;
    }
    
    public void func_175601_h() {
        this.mcProfiler.startSection("display_update");
        Display.update();
        this.mcProfiler.endSection();
        this.func_175604_i();
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    @Override
    public ListenableFuture addScheduledTask(final Runnable llllIllllllIll) {
        Validate.notNull((Object)llllIllllllIll);
        return this.addScheduledTask(Executors.callable(llllIllllllIll));
    }
    
    public CrashReport addGraphicsAndWorldToCrashReport(final CrashReport lllllIlIIIllII) {
        lllllIlIIIllII.getCategory().addCrashSectionCallable("Launched Version", new Callable() {
            static {
                __OBFID = "CL_00000643";
            }
            
            public Object call1() {
                return this.call();
            }
            
            @Override
            public String call() {
                return Minecraft.this.launchedVersion;
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("LWJGL", new Callable() {
            @Override
            public String call() {
                return Sys.getVersion();
            }
            
            static {
                __OBFID = "CL_00000644";
            }
            
            public Object call1() {
                return this.call();
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("OpenGL", new Callable() {
            public Object call1() {
                return this.call();
            }
            
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(GL11.glGetString(7937))).append(" GL version ").append(GL11.glGetString(7938)).append(", ").append(GL11.glGetString(7936)));
            }
            
            static {
                __OBFID = "CL_00000645";
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("GL Caps", new Callable() {
            @Override
            public String call() {
                return OpenGlHelper.func_153172_c();
            }
            
            public Object call1() {
                return this.call();
            }
            
            static {
                __OBFID = "CL_00000646";
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("Using VBOs", new Callable() {
            public Object call1() {
                return this.call();
            }
            
            static {
                __OBFID = "CL_00000647";
            }
            
            @Override
            public String call() {
                return Minecraft.this.gameSettings.field_178881_t ? "Yes" : "No";
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("Is Modded", new Callable() {
            public Object call1() {
                return this.call();
            }
            
            @Override
            public String call() {
                final String lllllllllllllllIlIIllIlIllIllIII = ClientBrandRetriever.getClientModName();
                return lllllllllllllllIlIIllIlIllIllIII.equals("vanilla") ? ((Minecraft.class.getSigners() == null) ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and client brand is untouched.") : String.valueOf(new StringBuilder("Definitely; Client brand changed to '").append(lllllllllllllllIlIIllIlIllIllIII).append("'"));
            }
            
            static {
                __OBFID = "CL_00000633";
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("Type", new Callable() {
            @Override
            public String call() {
                return "Client (map_client.txt)";
            }
            
            public Object call1() {
                return this.call();
            }
            
            static {
                __OBFID = "CL_00000634";
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("Resource Packs", new Callable() {
            @Override
            public String call() {
                return Minecraft.this.gameSettings.resourcePacks.toString();
            }
            
            static {
                __OBFID = "CL_00000635";
            }
            
            public Object call1() {
                return this.call();
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("Current Language", new Callable() {
            @Override
            public String call() {
                return Minecraft.this.mcLanguageManager.getCurrentLanguage().toString();
            }
            
            public Object call1() {
                return this.call();
            }
            
            static {
                __OBFID = "CL_00000636";
            }
        });
        lllllIlIIIllII.getCategory().addCrashSectionCallable("Profiler Position", new Callable() {
            @Override
            public Object call() {
                return this.call1();
            }
            
            static {
                __OBFID = "CL_00000637";
            }
            
            public String call1() {
                return Minecraft.this.mcProfiler.profilingEnabled ? Minecraft.this.mcProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
        });
        if (this.theWorld != null) {
            this.theWorld.addWorldInfoToCrashReport(lllllIlIIIllII);
        }
        return lllllIlIIIllII;
    }
    
    public boolean isJava64bit() {
        return this.jvm64bit;
    }
    
    public String func_175600_c() {
        return this.launchedVersion;
    }
    
    public int getLimitFramerate() {
        return (this.theWorld == null && this.currentScreen != null) ? 30 : this.gameSettings.limitFramerate;
    }
    
    public MinecraftSessionService getSessionService() {
        return this.sessionService;
    }
    
    public static int getGLMaximumTextureSize() {
        for (int lllllIIllIlIll = 16384; lllllIIllIlIll > 0; lllllIIllIlIll >>= 1) {
            GL11.glTexImage2D(32868, 0, 6408, lllllIIllIlIll, lllllIIllIlIll, 0, 6408, 5121, (ByteBuffer)null);
            final int lllllIIllIlIlI = GL11.glGetTexLevelParameteri(32868, 0, 4096);
            if (lllllIIllIlIlI != 0) {
                return lllllIIllIlIll;
            }
        }
        return -1;
    }
    
    private void resize(final int llllllIIllIIlI, final int llllllIIllIIIl) {
        this.displayWidth = Math.max(1, llllllIIllIIlI);
        this.displayHeight = Math.max(1, llllllIIllIIIl);
        if (this.currentScreen != null) {
            final ScaledResolution llllllIIllIlII = new ScaledResolution(this, llllllIIllIIlI, llllllIIllIIIl);
            this.currentScreen.func_175273_b(this, llllllIIllIlII.getScaledWidth(), llllllIIllIlII.getScaledHeight());
        }
        this.loadingScreen = new LoadingScreenRenderer(this);
        this.updateFramebufferSize();
    }
    
    private void sendClickBlockToController(final boolean llllllIlIlllII) {
        if (!llllllIlIlllII) {
            this.leftClickCounter = 0;
        }
        if (this.leftClickCounter <= 0 && !this.thePlayer.isUsingItem()) {
            if (llllllIlIlllII && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                final BlockPos llllllIlIllIll = this.objectMouseOver.func_178782_a();
                if (this.theWorld.getBlockState(llllllIlIllIll).getBlock().getMaterial() != Material.air && this.playerController.func_180512_c(llllllIlIllIll, this.objectMouseOver.field_178784_b)) {
                    this.effectRenderer.func_180532_a(llllllIlIllIll, this.objectMouseOver.field_178784_b);
                    this.thePlayer.swingItem();
                }
            }
            else {
                this.playerController.resetBlockRemoving();
            }
        }
    }
    
    public void setIngameFocus() {
        if (Display.isActive() && !this.inGameHasFocus) {
            this.inGameHasFocus = true;
            this.mouseHelper.grabMouseCursor();
            this.displayGuiScreen(null);
            this.leftClickCounter = 10000;
        }
    }
    
    public SoundHandler getSoundHandler() {
        return this.mcSoundHandler;
    }
    
    public void crashed(final CrashReport lIIIIIIlIIIlIIl) {
        this.hasCrashed = true;
        this.crashReporter = lIIIIIIlIIIlIIl;
    }
    
    public ISaveFormat getSaveLoader() {
        return this.saveLoader;
    }
    
    private void func_175595_al() {
        try {
            this.stream = new TwitchStream(this, (Property)Iterables.getFirst((Iterable)this.twitchDetails.get((Object)"twitch_access_token"), (Object)null));
        }
        catch (Throwable lIIIIIIllIIllII) {
            this.stream = new NullStream(lIIIIIIllIIllII);
            Minecraft.logger.error("Couldn't initialize twitch stream");
        }
    }
    
    static {
        __OBFID = "CL_00000631";
        logger = LogManager.getLogger();
        locationMojangPng = new ResourceLocation("textures/gui/title/mojang.png");
        isRunningOnMac = (Util.getOSType() == Util.EnumOS.OSX);
        Minecraft.memoryReserve = new byte[10485760];
        macDisplayModes = Lists.newArrayList((Object[])new DisplayMode[] { new DisplayMode(2560, 1600), new DisplayMode(2880, 1800) });
    }
    
    public RenderManager getRenderManager() {
        return this.renderManager;
    }
    
    public void freeMemory() {
        try {
            Minecraft.memoryReserve = new byte[0];
            this.renderGlobal.deleteAllDisplayLists();
        }
        catch (Throwable t) {}
        try {
            System.gc();
            this.loadWorld(null);
        }
        catch (Throwable t2) {}
        System.gc();
    }
    
    public static Minecraft getMinecraft() {
        return Minecraft.theMinecraft;
    }
    
    private void startGame() throws LWJGLException {
        this.gameSettings = new GameSettings(this, this.mcDataDir);
        this.defaultResourcePacks.add(this.mcDefaultResourcePack);
        this.startTimerHackThread();
        if (this.gameSettings.overrideHeight > 0 && this.gameSettings.overrideWidth > 0) {
            this.displayWidth = this.gameSettings.overrideWidth;
            this.displayHeight = this.gameSettings.overrideHeight;
        }
        Minecraft.logger.info(String.valueOf(new StringBuilder("LWJGL Version: ").append(Sys.getVersion())));
        this.func_175594_ao();
        this.func_175605_an();
        this.func_175609_am();
        OpenGlHelper.initializeTextures();
        this.framebufferMc = new Framebuffer(this.displayWidth, this.displayHeight, true);
        this.framebufferMc.setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.func_175608_ak();
        this.mcResourcePackRepository = new ResourcePackRepository(this.fileResourcepacks, new File(this.mcDataDir, "server-resource-packs"), this.mcDefaultResourcePack, this.metadataSerializer_, this.gameSettings);
        this.mcResourceManager = new SimpleReloadableResourceManager(this.metadataSerializer_);
        this.mcLanguageManager = new LanguageManager(this.metadataSerializer_, this.gameSettings.language);
        this.mcResourceManager.registerReloadListener(this.mcLanguageManager);
        this.refreshResources();
        this.renderEngine = new TextureManager(this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.renderEngine);
        this.func_180510_a(this.renderEngine);
        this.func_175595_al();
        this.skinManager = new SkinManager(this.renderEngine, new File(this.fileAssets, "skins"), this.sessionService);
        this.saveLoader = new AnvilSaveConverter(new File(this.mcDataDir, "saves"));
        this.mcSoundHandler = new SoundHandler(this.mcResourceManager, this.gameSettings);
        this.mcResourceManager.registerReloadListener(this.mcSoundHandler);
        this.mcMusicTicker = new MusicTicker(this);
        this.fontRendererObj = new FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii.png"), this.renderEngine, false);
        if (this.gameSettings.language != null) {
            this.fontRendererObj.setUnicodeFlag(this.isUnicode());
            this.fontRendererObj.setBidiFlag(this.mcLanguageManager.isCurrentLanguageBidirectional());
        }
        this.standardGalacticFontRenderer = new FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii_sga.png"), this.renderEngine, false);
        this.mcResourceManager.registerReloadListener(this.fontRendererObj);
        this.mcResourceManager.registerReloadListener(this.standardGalacticFontRenderer);
        this.mcResourceManager.registerReloadListener(new GrassColorReloadListener());
        this.mcResourceManager.registerReloadListener(new FoliageColorReloadListener());
        AchievementList.openInventory.setStatStringFormatter(new IStatStringFormat() {
            static {
                __OBFID = "CL_00000632";
            }
            
            @Override
            public String formatString(final String lllllllllllllllIlllllIIllllIlIII) {
                try {
                    return String.format(lllllllllllllllIlllllIIllllIlIII, GameSettings.getKeyDisplayString(Minecraft.this.gameSettings.keyBindInventory.getKeyCode()));
                }
                catch (Exception lllllllllllllllIlllllIIllllIlIlI) {
                    return String.valueOf(new StringBuilder("Error: ").append(lllllllllllllllIlllllIIllllIlIlI.getLocalizedMessage()));
                }
            }
        });
        this.mouseHelper = new MouseHelper();
        this.checkGLError("Pre startup");
        GlStateManager.func_179098_w();
        GlStateManager.shadeModel(7425);
        GlStateManager.clearDepth(1.0);
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.cullFace(1029);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(5888);
        this.checkGLError("Startup");
        this.textureMapBlocks = new TextureMap("textures");
        this.textureMapBlocks.setMipmapLevels(this.gameSettings.mipmapLevels);
        this.renderEngine.loadTickableTexture(TextureMap.locationBlocksTexture, this.textureMapBlocks);
        this.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
        this.textureMapBlocks.func_174937_a(false, this.gameSettings.mipmapLevels > 0);
        this.modelManager = new ModelManager(this.textureMapBlocks);
        this.mcResourceManager.registerReloadListener(this.modelManager);
        this.renderItem = new RenderItem(this.renderEngine, this.modelManager);
        this.renderManager = new RenderManager(this.renderEngine, this.renderItem);
        this.itemRenderer = new ItemRenderer(this);
        this.mcResourceManager.registerReloadListener(this.renderItem);
        this.entityRenderer = new EntityRenderer(this, this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.entityRenderer);
        this.field_175618_aM = new BlockRendererDispatcher(this.modelManager.getBlockModelShapes(), this.gameSettings);
        this.mcResourceManager.registerReloadListener(this.field_175618_aM);
        this.renderGlobal = new RenderGlobal(this);
        this.mcResourceManager.registerReloadListener(this.renderGlobal);
        this.guiAchievement = new GuiAchievement(this);
        GlStateManager.viewport(0, 0, this.displayWidth, this.displayHeight);
        this.effectRenderer = new EffectRenderer(this.theWorld, this.renderEngine);
        this.checkGLError("Post startup");
        this.ingameGUI = new GuiIngame(this);
        Client.startup();
        if (this.serverName != null) {
            this.displayGuiScreen(new GuiConnecting(new GuiMainMenu(), this, this.serverName, this.serverPort));
        }
        else {
            this.displayGuiScreen(new GuiMainMenu());
        }
        this.renderEngine.deleteTexture(this.mojangLogo);
        this.mojangLogo = null;
        this.loadingScreen = new LoadingScreenRenderer(this);
        if (this.gameSettings.fullScreen && !this.fullscreen) {
            this.toggleFullscreen();
        }
        try {
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
        }
        catch (OpenGLException lIIIIIIllIlIlIl) {
            this.gameSettings.enableVsync = false;
            this.gameSettings.saveOptions();
        }
        this.renderGlobal.func_174966_b();
    }
    
    private void func_175605_an() throws LWJGLException {
        if (this.fullscreen) {
            Display.setFullscreen(true);
            final DisplayMode lIIIIIIlIlllllI = Display.getDisplayMode();
            this.displayWidth = Math.max(1, lIIIIIIlIlllllI.getWidth());
            this.displayHeight = Math.max(1, lIIIIIIlIlllllI.getHeight());
        }
        else {
            Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
        }
    }
    
    public Framebuffer getFramebuffer() {
        return this.framebufferMc;
    }
    
    public void toggleFullscreen() {
        try {
            this.fullscreen = !this.fullscreen;
            this.gameSettings.fullScreen = this.fullscreen;
            if (this.fullscreen) {
                this.updateDisplayMode();
                this.displayWidth = Display.getDisplayMode().getWidth();
                this.displayHeight = Display.getDisplayMode().getHeight();
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
            }
            else {
                Display.setDisplayMode(new DisplayMode(this.tempDisplayWidth, this.tempDisplayHeight));
                this.displayWidth = this.tempDisplayWidth;
                this.displayHeight = this.tempDisplayHeight;
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
            }
            if (this.currentScreen != null) {
                this.resize(this.displayWidth, this.displayHeight);
            }
            else {
                this.updateFramebufferSize();
            }
            Display.setFullscreen(this.fullscreen);
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
            this.func_175601_h();
        }
        catch (Exception llllllIIlllllI) {
            Minecraft.logger.error("Couldn't toggle fullscreen", (Throwable)llllllIIlllllI);
        }
    }
    
    private ByteBuffer readImageToBuffer(final InputStream lIIIIIIIlIllIll) throws IOException {
        final BufferedImage lIIIIIIIllIIIlI = ImageIO.read(lIIIIIIIlIllIll);
        final int[] lIIIIIIIllIIIIl = lIIIIIIIllIIIlI.getRGB(0, 0, lIIIIIIIllIIIlI.getWidth(), lIIIIIIIllIIIlI.getHeight(), null, 0, lIIIIIIIllIIIlI.getWidth());
        final ByteBuffer lIIIIIIIllIIIII = ByteBuffer.allocate(4 * lIIIIIIIllIIIIl.length);
        final int[] lIIIIIIIlIlllll = lIIIIIIIllIIIIl;
        for (int lIIIIIIIlIllllI = lIIIIIIIllIIIIl.length, lIIIIIIIlIlllIl = 0; lIIIIIIIlIlllIl < lIIIIIIIlIllllI; ++lIIIIIIIlIlllIl) {
            final int lIIIIIIIlIlllII = lIIIIIIIlIlllll[lIIIIIIIlIlllIl];
            lIIIIIIIllIIIII.putInt(lIIIIIIIlIlllII << 8 | (lIIIIIIIlIlllII >> 24 & 0xFF));
        }
        lIIIIIIIllIIIII.flip();
        return lIIIIIIIllIIIII;
    }
    
    public boolean isFullScreen() {
        return this.fullscreen;
    }
    
    protected void func_175604_i() {
        if (!this.fullscreen && Display.wasResized()) {
            final int llllllllIIIlIl = this.displayWidth;
            final int llllllllIIIlII = this.displayHeight;
            this.displayWidth = Display.getWidth();
            this.displayHeight = Display.getHeight();
            if (this.displayWidth != llllllllIIIlIl || this.displayHeight != llllllllIIIlII) {
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
                this.resize(this.displayWidth, this.displayHeight);
            }
        }
    }
    
    private void updateFramebufferSize() {
        this.framebufferMc.createBindFramebuffer(this.displayWidth, this.displayHeight);
        if (this.entityRenderer != null) {
            this.entityRenderer.updateShaderGroupSize(this.displayWidth, this.displayHeight);
        }
    }
    
    public void setServerData(final ServerData lllllIIlIlllll) {
        this.currentServerData = lllllIIlIlllll;
    }
    
    public final boolean isDemo() {
        return this.isDemo;
    }
    
    private void clickMouse() {
        if (this.leftClickCounter <= 0) {
            this.thePlayer.swingItem();
            if (this.objectMouseOver == null) {
                Minecraft.logger.error("Null returned as 'hitResult', this shouldn't happen!");
                if (this.playerController.isNotCreative()) {
                    this.leftClickCounter = 10;
                }
            }
            else {
                switch (SwitchEnumMinecartType.field_152390_a[this.objectMouseOver.typeOfHit.ordinal()]) {
                    case 1: {
                        this.playerController.attackEntity(this.thePlayer, this.objectMouseOver.entityHit);
                        return;
                    }
                    case 2: {
                        final BlockPos llllllIlIlIlII = this.objectMouseOver.func_178782_a();
                        if (this.theWorld.getBlockState(llllllIlIlIlII).getBlock().getMaterial() != Material.air) {
                            this.playerController.func_180511_b(llllllIlIlIlII, this.objectMouseOver.field_178784_b);
                            return;
                        }
                        break;
                    }
                }
                if (this.playerController.isNotCreative()) {
                    this.leftClickCounter = 10;
                }
            }
        }
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return this.gameSettings.snooperEnabled;
    }
    
    public IResourceManager getResourceManager() {
        return this.mcResourceManager;
    }
    
    public void setIngameNotInFocus() {
        if (this.inGameHasFocus) {
            KeyBinding.unPressAllKeys();
            this.inGameHasFocus = false;
            this.mouseHelper.ungrabMouseCursor();
        }
    }
    
    public static boolean isAmbientOcclusionEnabled() {
        return Minecraft.theMinecraft != null && Minecraft.theMinecraft.gameSettings.ambientOcclusion != 0;
    }
    
    static final class SwitchEnumMinecartType
    {
        static final /* synthetic */ int[] field_178901_b;
        static final /* synthetic */ int[] field_152390_a;
        
        static {
            __OBFID = "CL_00001959";
            field_178901_b = new int[EntityMinecart.EnumMinecartType.values().length];
            try {
                SwitchEnumMinecartType.field_178901_b[EntityMinecart.EnumMinecartType.FURNACE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumMinecartType.field_178901_b[EntityMinecart.EnumMinecartType.CHEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumMinecartType.field_178901_b[EntityMinecart.EnumMinecartType.TNT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumMinecartType.field_178901_b[EntityMinecart.EnumMinecartType.HOPPER.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumMinecartType.field_178901_b[EntityMinecart.EnumMinecartType.COMMAND_BLOCK.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            field_152390_a = new int[MovingObjectPosition.MovingObjectType.values().length];
            try {
                SwitchEnumMinecartType.field_152390_a[MovingObjectPosition.MovingObjectType.ENTITY.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchEnumMinecartType.field_152390_a[MovingObjectPosition.MovingObjectType.BLOCK.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchEnumMinecartType.field_152390_a[MovingObjectPosition.MovingObjectType.MISS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
        }
    }
}
