package net.minecraft.client.stream;

import net.minecraft.client.*;
import net.minecraft.client.shader.*;
import com.mojang.authlib.properties.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.net.*;
import java.io.*;
import com.google.gson.*;
import net.minecraft.client.settings.*;
import tv.twitch.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import tv.twitch.broadcast.*;
import net.minecraft.client.gui.stream.*;
import net.minecraft.event.*;
import java.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import tv.twitch.chat.*;

public class TwitchStream implements BroadcastController.BroadcastListener, IngestServerTester.IngestTestListener, ChatController.ChatListener, IStream
{
    public static final /* synthetic */ Marker field_152949_a;
    private /* synthetic */ AuthFailureReason field_152964_p;
    private final /* synthetic */ ChatController field_152952_d;
    private /* synthetic */ boolean field_152957_i;
    private /* synthetic */ String field_176029_e;
    private /* synthetic */ boolean field_152960_l;
    private final /* synthetic */ IChatComponent field_152954_f;
    private /* synthetic */ int field_152958_j;
    private /* synthetic */ boolean field_152962_n;
    private /* synthetic */ boolean field_152961_m;
    private static final /* synthetic */ Logger field_152950_b;
    private /* synthetic */ boolean field_152963_o;
    private /* synthetic */ long field_152959_k;
    private final /* synthetic */ Map field_152955_g;
    private static /* synthetic */ boolean field_152965_q;
    private final /* synthetic */ Minecraft field_152953_e;
    private final /* synthetic */ BroadcastController broadcastController;
    private /* synthetic */ Framebuffer field_152956_h;
    
    @Override
    public boolean func_152908_z() {
        return this.broadcastController.isIngestTesting();
    }
    
    @Override
    public boolean func_152927_B() {
        return this.field_176029_e != null && this.field_176029_e.equals(this.broadcastController.func_152843_l().name);
    }
    
    @Override
    public void func_176021_d() {
    }
    
    public TwitchStream(final Minecraft llllIIIIIlllIII, final Property llllIIIIIlllIll) {
        this.field_152954_f = new ChatComponentText("Twitch");
        this.field_152955_g = Maps.newHashMap();
        this.field_152958_j = 30;
        this.field_152959_k = 0L;
        this.field_152960_l = false;
        this.field_152964_p = AuthFailureReason.ERROR;
        this.field_152953_e = llllIIIIIlllIII;
        this.broadcastController = new BroadcastController();
        this.field_152952_d = new ChatController();
        this.broadcastController.func_152841_a(this);
        this.field_152952_d.func_152990_a(this);
        this.broadcastController.func_152842_a("nmt37qblda36pvonovdkbopzfzw3wlq");
        this.field_152952_d.func_152984_a("nmt37qblda36pvonovdkbopzfzw3wlq");
        this.field_152954_f.getChatStyle().setColor(EnumChatFormatting.DARK_PURPLE);
        if (llllIIIIIlllIll != null && !Strings.isNullOrEmpty(llllIIIIIlllIll.getValue()) && OpenGlHelper.framebufferSupported) {
            final Thread llllIIIIIlllIlI = new Thread("Twitch authenticator") {
                @Override
                public void run() {
                    try {
                        final URL llllllllllllllIIIIIlIlllIIIlIIll = new URL(String.valueOf(new StringBuilder("https://api.twitch.tv/kraken?oauth_token=").append(URLEncoder.encode(llllIIIIIlllIll.getValue(), "UTF-8"))));
                        final String llllllllllllllIIIIIlIlllIIIlIIlI = HttpUtil.get(llllllllllllllIIIIIlIlllIIIlIIll);
                        final JsonObject llllllllllllllIIIIIlIlllIIIlIIIl = JsonUtils.getElementAsJsonObject(new JsonParser().parse(llllllllllllllIIIIIlIlllIIIlIIlI), "Response");
                        final JsonObject llllllllllllllIIIIIlIlllIIIlIIII = JsonUtils.getJsonObject(llllllllllllllIIIIIlIlllIIIlIIIl, "token");
                        if (JsonUtils.getJsonObjectBooleanFieldValue(llllllllllllllIIIIIlIlllIIIlIIII, "valid")) {
                            final String llllllllllllllIIIIIlIlllIIIIllll = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIIIIlIlllIIIlIIII, "user_name");
                            TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Authenticated with twitch; username is {}", new Object[] { llllllllllllllIIIIIlIlllIIIIllll });
                            final AuthToken llllllllllllllIIIIIlIlllIIIIlllI = new AuthToken();
                            llllllllllllllIIIIIlIlllIIIIlllI.data = llllIIIIIlllIll.getValue();
                            TwitchStream.this.broadcastController.func_152818_a(llllllllllllllIIIIIlIlllIIIIllll, llllllllllllllIIIIIlIlllIIIIlllI);
                            TwitchStream.this.field_152952_d.func_152998_c(llllllllllllllIIIIIlIlllIIIIllll);
                            TwitchStream.this.field_152952_d.func_152994_a(llllllllllllllIIIIIlIlllIIIIlllI);
                            Runtime.getRuntime().addShutdownHook(new Thread("Twitch shutdown hook") {
                                @Override
                                public void run() {
                                    TwitchStream.this.shutdownStream();
                                }
                                
                                static {
                                    __OBFID = "CL_00001810";
                                }
                            });
                            TwitchStream.this.broadcastController.func_152817_A();
                            TwitchStream.this.field_152952_d.func_175984_n();
                        }
                        else {
                            TwitchStream.access$3(TwitchStream.this, AuthFailureReason.INVALID_TOKEN);
                            TwitchStream.field_152950_b.error(TwitchStream.field_152949_a, "Given twitch access token is invalid");
                        }
                    }
                    catch (IOException llllllllllllllIIIIIlIlllIIIIllIl) {
                        TwitchStream.access$3(TwitchStream.this, AuthFailureReason.ERROR);
                        TwitchStream.field_152950_b.error(TwitchStream.field_152949_a, "Could not authenticate with twitch", (Throwable)llllllllllllllIIIIIlIlllIIIIllIl);
                    }
                }
                
                static {
                    __OBFID = "CL_00001811";
                }
            };
            llllIIIIIlllIlI.setDaemon(true);
            llllIIIIIlllIlI.start();
        }
    }
    
    @Override
    public void func_152930_t() {
        final GameSettings lllIllllIlIllII = this.field_152953_e.gameSettings;
        final VideoParams lllIllllIlIlIll = this.broadcastController.func_152834_a(func_152946_b(lllIllllIlIllII.streamKbps), func_152948_a(lllIllllIlIllII.streamFps), func_152947_c(lllIllllIlIllII.streamBytesPerPixel), this.field_152953_e.displayWidth / (float)this.field_152953_e.displayHeight);
        switch (lllIllllIlIllII.streamCompression) {
            case 0: {
                lllIllllIlIlIll.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_LOW;
                break;
            }
            case 1: {
                lllIllllIlIlIll.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_MEDIUM;
                break;
            }
            case 2: {
                lllIllllIlIlIll.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
                break;
            }
        }
        if (this.field_152956_h == null) {
            this.field_152956_h = new Framebuffer(lllIllllIlIlIll.outputWidth, lllIllllIlIlIll.outputHeight, false);
        }
        else {
            this.field_152956_h.createBindFramebuffer(lllIllllIlIlIll.outputWidth, lllIllllIlIlIll.outputHeight);
        }
        if (lllIllllIlIllII.streamPreferredServer != null && lllIllllIlIllII.streamPreferredServer.length() > 0) {
            for (final IngestServer lllIllllIlIIlll : this.func_152925_v()) {
                if (lllIllllIlIIlll.serverUrl.equals(lllIllllIlIllII.streamPreferredServer)) {
                    this.broadcastController.func_152824_a(lllIllllIlIIlll);
                    break;
                }
            }
        }
        this.field_152958_j = lllIllllIlIlIll.targetFps;
        this.field_152957_i = lllIllllIlIllII.streamSendMetadata;
        this.broadcastController.func_152836_a(lllIllllIlIlIll);
        TwitchStream.field_152950_b.info(TwitchStream.field_152949_a, "Streaming at {}/{} at {} kbps to {}", new Object[] { lllIllllIlIlIll.outputWidth, lllIllllIlIlIll.outputHeight, lllIllllIlIlIll.maxKbps, this.broadcastController.func_152833_s().serverUrl });
        this.broadcastController.func_152828_a(null, "Minecraft", null);
    }
    
    protected void func_152942_I() {
        final ChatController.ChatState llllIIIIIlIIIlI = this.field_152952_d.func_153000_j();
        final String llllIIIIIlIIIIl = this.broadcastController.func_152843_l().name;
        this.field_176029_e = llllIIIIIlIIIIl;
        if (llllIIIIIlIIIlI != ChatController.ChatState.Initialized) {
            TwitchStream.field_152950_b.warn("Invalid twitch chat state {}", new Object[] { llllIIIIIlIIIlI });
        }
        else if (this.field_152952_d.func_175989_e(this.field_176029_e) == ChatController.EnumChannelState.Disconnected) {
            this.field_152952_d.func_152986_d(llllIIIIIlIIIIl);
        }
        else {
            TwitchStream.field_152950_b.warn("Invalid twitch chat state {}", new Object[] { llllIIIIIlIIIlI });
        }
    }
    
    @Override
    public void func_152899_b() {
        this.func_152915_s();
        TwitchStream.field_152950_b.info(TwitchStream.field_152949_a, "Broadcast to Twitch has started");
    }
    
    @Override
    public void func_152897_a(final ErrorCode lllIllllIIlIlII) {
        if (ErrorCode.succeeded(lllIllllIIlIlII)) {
            TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Login attempt successful");
            this.field_152961_m = true;
        }
        else {
            TwitchStream.field_152950_b.warn(TwitchStream.field_152949_a, "Login attempt unsuccessful: {} (error code {})", new Object[] { ErrorCode.getString(lllIllllIIlIlII), lllIllllIIlIlII.getValue() });
            this.field_152961_m = false;
        }
    }
    
    @Override
    public void func_152915_s() {
        if (this.func_152934_n()) {
            final float lllIllllIlllIIl = this.field_152953_e.gameSettings.streamGameVolume;
            final boolean lllIllllIlllIII = this.field_152962_n || lllIllllIlllIIl <= 0.0f;
            this.broadcastController.func_152837_b(lllIllllIlllIII ? 0.0f : lllIllllIlllIIl);
            this.broadcastController.func_152829_a(this.func_152929_G() ? 0.0f : this.field_152953_e.gameSettings.streamMicVolume);
        }
    }
    
    @Override
    public void func_152892_c(final ErrorCode lllIlllIlllIlII) {
        if (lllIlllIlllIlII == ErrorCode.TTV_EC_SOUNDFLOWER_NOT_INSTALLED) {
            final ChatComponentTranslation lllIlllIlllIIll = new ChatComponentTranslation("stream.unavailable.soundflower.chat.link", new Object[0]);
            lllIlllIlllIIll.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://help.mojang.com/customer/portal/articles/1374877-configuring-soundflower-for-streaming-on-apple-computers"));
            lllIlllIlllIIll.getChatStyle().setUnderlined(true);
            final ChatComponentTranslation lllIlllIlllIIIl = new ChatComponentTranslation("stream.unavailable.soundflower.chat", new Object[] { lllIlllIlllIIll });
            lllIlllIlllIIIl.getChatStyle().setColor(EnumChatFormatting.DARK_RED);
            this.field_152953_e.ingameGUI.getChatGUI().printChatMessage(lllIlllIlllIIIl);
        }
        else {
            final ChatComponentTranslation lllIlllIlllIIlI = new ChatComponentTranslation("stream.unavailable.unknown.chat", new Object[] { ErrorCode.getString(lllIlllIlllIlII) });
            lllIlllIlllIIlI.getChatStyle().setColor(EnumChatFormatting.DARK_RED);
            this.field_152953_e.ingameGUI.getChatGUI().printChatMessage(lllIlllIlllIIlI);
        }
    }
    
    public static float func_152947_c(final float lllIlllIlIllllI) {
        return 0.1f + lllIlllIlIllllI * 0.1f;
    }
    
    @Override
    public void func_152909_x() {
        final IngestServerTester lllIlllIlIlIllI = this.broadcastController.func_152838_J();
        if (lllIlllIlIlIllI != null) {
            lllIlllIlIlIllI.func_153042_a(this);
        }
    }
    
    @Override
    public void func_152895_a() {
        TwitchStream.field_152950_b.info(TwitchStream.field_152949_a, "Logged out of twitch");
    }
    
    @Override
    public void func_176016_c(final String lllIllIlIlIIlll) {
    }
    
    @Override
    public void func_176018_a(final String lllIllIllIIIlIl, final ChatUserInfo[] lllIllIlIlllIlI, final ChatUserInfo[] lllIllIllIIIIll, final ChatUserInfo[] lllIllIlIlllIII) {
        ChatUserInfo[] lllIllIllIIIIIl = lllIllIllIIIIll;
        for (int lllIllIllIIIIII = lllIllIllIIIIll.length, lllIllIlIllllll = 0; lllIllIlIllllll < lllIllIllIIIIII; ++lllIllIlIllllll) {
            final ChatUserInfo lllIllIlIlllllI = lllIllIllIIIIIl[lllIllIlIllllll];
            this.field_152955_g.remove(lllIllIlIlllllI.displayName);
        }
        lllIllIllIIIIIl = lllIllIlIlllIII;
        for (int lllIllIllIIIIII = lllIllIlIlllIII.length, lllIllIlIllllll = 0; lllIllIlIllllll < lllIllIllIIIIII; ++lllIllIlIllllll) {
            final ChatUserInfo lllIllIlIllllIl = lllIllIllIIIIIl[lllIllIlIllllll];
            this.field_152955_g.put(lllIllIlIllllIl.displayName, lllIllIlIllllIl);
        }
        lllIllIllIIIIIl = lllIllIlIlllIlI;
        for (int lllIllIllIIIIII = lllIllIlIlllIlI.length, lllIllIlIllllll = 0; lllIllIlIllllll < lllIllIllIIIIII; ++lllIllIlIllllll) {
            final ChatUserInfo lllIllIlIllllII = lllIllIllIIIIIl[lllIllIlIllllll];
            this.field_152955_g.put(lllIllIlIllllII.displayName, lllIllIlIllllII);
        }
    }
    
    @Override
    public void func_152914_u() {
        if (this.broadcastController.func_152819_E()) {
            TwitchStream.field_152950_b.info(TwitchStream.field_152949_a, "Stopped streaming to Twitch");
        }
        else {
            TwitchStream.field_152950_b.warn(TwitchStream.field_152949_a, "Could not stop streaming to Twitch");
        }
    }
    
    static /* synthetic */ void access$3(final TwitchStream lllIllIIlllIlII, final AuthFailureReason lllIllIIlllIIll) {
        lllIllIIlllIlII.field_152964_p = lllIllIIlllIIll;
    }
    
    @Override
    public void func_152898_a(final ErrorCode lllIllllIIlIIlI, final GameInfo[] lllIllllIIlIIIl) {
    }
    
    @Override
    public void func_152910_a(final boolean lllIllIlIIIIllI) {
        this.field_152963_o = lllIllIlIIIIllI;
        this.func_152915_s();
    }
    
    @Override
    public void func_176019_a(final String lllIllIlIlIllII, final String lllIllIlIlIlIll) {
    }
    
    @Override
    public void func_152891_a(final BroadcastController.BroadcastState lllIllllIIIllIl) {
        TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Broadcast state changed to {}", new Object[] { lllIllllIIIllIl });
        if (lllIllllIIIllIl == BroadcastController.BroadcastState.Initialized) {
            this.broadcastController.func_152827_a(BroadcastController.BroadcastState.Authenticated);
        }
    }
    
    @Override
    public boolean isPaused() {
        return this.broadcastController.isBroadcastPaused();
    }
    
    @Override
    public ChatUserInfo func_152926_a(final String lllIllIlIIllIIl) {
        return this.field_152955_g.get(lllIllIlIIllIIl);
    }
    
    @Override
    public void func_152901_c() {
        TwitchStream.field_152950_b.info(TwitchStream.field_152949_a, "Broadcast to Twitch has stopped");
    }
    
    @Override
    public void func_152900_a(final ErrorCode lllIllllIIllIll, final AuthToken lllIllllIIllIlI) {
    }
    
    @Override
    public void func_152933_r() {
        this.broadcastController.func_152854_G();
        this.field_152962_n = false;
        this.func_152915_s();
    }
    
    @Override
    public void func_152896_a(final IngestList lllIllllIIIIlII) {
    }
    
    public static int func_152948_a(final float lllIlllIllIIIll) {
        return MathHelper.floor_float(10.0f + lllIlllIllIIIll * 50.0f);
    }
    
    @Override
    public void func_152916_q() {
        this.broadcastController.func_152847_F();
        this.field_152962_n = true;
        this.func_152915_s();
    }
    
    @Override
    public void func_176026_a(final Metadata lllIlllllIlIIII, final long lllIlllllIIllll, final long lllIlllllIIlllI) {
        if (this.func_152934_n() && this.field_152957_i) {
            final long lllIlllllIlIlIl = this.broadcastController.func_152844_x();
            final String lllIlllllIlIlII = lllIlllllIlIIII.func_152809_a();
            final String lllIlllllIlIIll = lllIlllllIlIIII.func_152806_b();
            final long lllIlllllIlIIlI = this.broadcastController.func_177946_b(lllIlllllIlIIII.func_152810_c(), lllIlllllIlIlIl + lllIlllllIIllll, lllIlllllIlIlII, lllIlllllIlIIll);
            if (lllIlllllIlIIlI < 0L) {
                TwitchStream.field_152950_b.warn(TwitchStream.field_152949_a, "Could not send stream metadata sequence from {} to {}: {}", new Object[] { lllIlllllIlIlIl + lllIlllllIIllll, lllIlllllIlIlIl + lllIlllllIIlllI, lllIlllllIlIIII });
            }
            else if (this.broadcastController.func_177947_a(lllIlllllIlIIII.func_152810_c(), lllIlllllIlIlIl + lllIlllllIIlllI, lllIlllllIlIIlI, lllIlllllIlIlII, lllIlllllIlIIll)) {
                TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Sent stream metadata sequence from {} to {}: {}", new Object[] { lllIlllllIlIlIl + lllIlllllIIllll, lllIlllllIlIlIl + lllIlllllIIlllI, lllIlllllIlIIII });
            }
            else {
                TwitchStream.field_152950_b.warn(TwitchStream.field_152949_a, "Half-sent stream metadata sequence from {} to {}: {}", new Object[] { lllIlllllIlIlIl + lllIlllllIIllll, lllIlllllIlIlIl + lllIlllllIIlllI, lllIlllllIlIIII });
            }
        }
    }
    
    @Override
    public void func_176023_d(final ErrorCode lllIlllIlIIIlII) {
        if (ErrorCode.failed(lllIlllIlIIIlII)) {
            TwitchStream.field_152950_b.error(TwitchStream.field_152949_a, "Chat failed to initialize");
        }
    }
    
    @Override
    public void func_152907_a(final IngestServerTester lllIlllIllIlIIl, final IngestServerTester.IngestTestState lllIlllIllIlIII) {
        TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Ingest test state changed to {}", new Object[] { lllIlllIllIlIII });
        if (lllIlllIllIlIII == IngestServerTester.IngestTestState.Finished) {
            this.field_152960_l = true;
        }
    }
    
    @Override
    public void func_152893_b(final ErrorCode lllIlllIllllllI) {
        TwitchStream.field_152950_b.warn(TwitchStream.field_152949_a, "Issue submitting frame: {} (Error code {})", new Object[] { ErrorCode.getString(lllIlllIllllllI), lllIlllIllllllI.getValue() });
        this.field_152953_e.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new ChatComponentText(String.valueOf(new StringBuilder("Issue streaming frame: ").append(lllIlllIllllllI).append(" (").append(ErrorCode.getString(lllIlllIllllllI)).append(")"))), 2);
    }
    
    public static int func_152946_b(final float lllIlllIllIIIIl) {
        return MathHelper.floor_float(230.0f + lllIlllIllIIIIl * 3270.0f);
    }
    
    @Override
    public ErrorCode func_152912_E() {
        return TwitchStream.field_152965_q ? this.broadcastController.func_152852_P() : ErrorCode.TTV_EC_OS_TOO_OLD;
    }
    
    private void func_176027_a(final String lllIllIllllllII, final ChatRawMessage lllIllIlllllIll) {
        ChatUserInfo lllIllIlllllllI = this.field_152955_g.get(lllIllIllllllII);
        if (lllIllIlllllllI == null) {
            lllIllIlllllllI = new ChatUserInfo();
            lllIllIlllllllI.displayName = lllIllIllllllII;
            this.field_152955_g.put(lllIllIllllllII, lllIllIlllllllI);
        }
        lllIllIlllllllI.subscriptions = lllIllIlllllIll.subscriptions;
        lllIllIlllllllI.modes = lllIllIlllllIll.modes;
        lllIllIlllllllI.nameColorARGB = lllIllIlllllIll.nameColorARGB;
    }
    
    @Override
    public void func_152931_p() {
        if (this.broadcastController.func_152830_D()) {
            TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Requested commercial from Twitch");
        }
        else {
            TwitchStream.field_152950_b.warn(TwitchStream.field_152949_a, "Could not request commercial from Twitch");
        }
    }
    
    @Override
    public boolean func_152929_G() {
        final boolean lllIllIlIIIIIII = this.field_152953_e.gameSettings.streamMicToggleBehavior == 1;
        return this.field_152962_n || this.field_152953_e.gameSettings.streamMicVolume <= 0.0f || lllIllIlIIIIIII != this.field_152963_o;
    }
    
    @Override
    public int func_152920_A() {
        return this.func_152934_n() ? this.broadcastController.func_152816_j().viewers : 0;
    }
    
    @Override
    public void func_176024_e() {
    }
    
    @Override
    public String func_152921_C() {
        return this.field_176029_e;
    }
    
    @Override
    public IngestServer[] func_152925_v() {
        return this.broadcastController.func_152855_t().getServers();
    }
    
    @Override
    public void func_152917_b(final String lllIllIlIIlIIll) {
        this.field_152952_d.func_175986_a(this.field_176029_e, lllIllIlIIlIIll);
    }
    
    @Override
    public void func_180606_a(final String lllIllIlIllIIlI) {
        TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Chat connected");
    }
    
    @Override
    public boolean func_152924_m() {
        return this.broadcastController.func_152857_n();
    }
    
    @Override
    public boolean func_152928_D() {
        return TwitchStream.field_152965_q && this.broadcastController.func_152858_b();
    }
    
    @Override
    public boolean func_152934_n() {
        return this.broadcastController.isBroadcasting();
    }
    
    @Override
    public void func_152922_k() {
        if (this.broadcastController.isBroadcasting() && !this.broadcastController.isBroadcastPaused()) {
            final long llllIIIIIIIllll = System.nanoTime();
            final long llllIIIIIIIlllI = 1000000000 / this.field_152958_j;
            final long llllIIIIIIIllIl = llllIIIIIIIllll - this.field_152959_k;
            final boolean llllIIIIIIIllII = llllIIIIIIIllIl >= llllIIIIIIIlllI;
            if (llllIIIIIIIllII) {
                final FrameBuffer llllIIIIIIIlIll = this.broadcastController.func_152822_N();
                final Framebuffer llllIIIIIIIlIlI = this.field_152953_e.getFramebuffer();
                this.field_152956_h.bindFramebuffer(true);
                GlStateManager.matrixMode(5889);
                GlStateManager.pushMatrix();
                GlStateManager.loadIdentity();
                GlStateManager.ortho(0.0, this.field_152956_h.framebufferWidth, this.field_152956_h.framebufferHeight, 0.0, 1000.0, 3000.0);
                GlStateManager.matrixMode(5888);
                GlStateManager.pushMatrix();
                GlStateManager.loadIdentity();
                GlStateManager.translate(0.0f, 0.0f, -2000.0f);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.viewport(0, 0, this.field_152956_h.framebufferWidth, this.field_152956_h.framebufferHeight);
                GlStateManager.func_179098_w();
                GlStateManager.disableAlpha();
                GlStateManager.disableBlend();
                final float llllIIIIIIIlIIl = (float)this.field_152956_h.framebufferWidth;
                final float llllIIIIIIIlIII = (float)this.field_152956_h.framebufferHeight;
                final float llllIIIIIIIIlll = llllIIIIIIIlIlI.framebufferWidth / (float)llllIIIIIIIlIlI.framebufferTextureWidth;
                final float llllIIIIIIIIllI = llllIIIIIIIlIlI.framebufferHeight / (float)llllIIIIIIIlIlI.framebufferTextureHeight;
                llllIIIIIIIlIlI.bindFramebufferTexture();
                GL11.glTexParameterf(3553, 10241, 9729.0f);
                GL11.glTexParameterf(3553, 10240, 9729.0f);
                final Tessellator llllIIIIIIIIlIl = Tessellator.getInstance();
                final WorldRenderer llllIIIIIIIIlII = llllIIIIIIIIlIl.getWorldRenderer();
                llllIIIIIIIIlII.startDrawingQuads();
                llllIIIIIIIIlII.addVertexWithUV(0.0, llllIIIIIIIlIII, 0.0, 0.0, llllIIIIIIIIllI);
                llllIIIIIIIIlII.addVertexWithUV(llllIIIIIIIlIIl, llllIIIIIIIlIII, 0.0, llllIIIIIIIIlll, llllIIIIIIIIllI);
                llllIIIIIIIIlII.addVertexWithUV(llllIIIIIIIlIIl, 0.0, 0.0, llllIIIIIIIIlll, 0.0);
                llllIIIIIIIIlII.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0.0);
                llllIIIIIIIIlIl.draw();
                llllIIIIIIIlIlI.unbindFramebufferTexture();
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5889);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
                this.broadcastController.func_152846_a(llllIIIIIIIlIll);
                this.field_152956_h.unbindFramebuffer();
                this.broadcastController.func_152859_b(llllIIIIIIIlIll);
                this.field_152959_k = llllIIIIIIIllll;
            }
        }
    }
    
    @Override
    public boolean func_152936_l() {
        return this.broadcastController.func_152849_q();
    }
    
    @Override
    public void func_176022_e(final ErrorCode lllIlllIlIIIIIl) {
        if (ErrorCode.failed(lllIlllIlIIIIIl)) {
            TwitchStream.field_152950_b.error(TwitchStream.field_152949_a, "Chat failed to shutdown");
        }
    }
    
    @Override
    public void func_152894_a(final StreamInfo lllIllllIIIIlll) {
        TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Stream info updated; {} viewers on stream ID {}", new Object[] { lllIllllIIIIlll.viewers, lllIllllIIIIlll.streamId });
    }
    
    @Override
    public void func_152911_a(final Metadata lllIllllllIlIII, final long lllIllllllIIlll) {
        if (this.func_152934_n() && this.field_152957_i) {
            final long lllIllllllIIllI = this.broadcastController.func_152844_x();
            if (!this.broadcastController.func_152840_a(lllIllllllIlIII.func_152810_c(), lllIllllllIIllI + lllIllllllIIlll, lllIllllllIlIII.func_152809_a(), lllIllllllIlIII.func_152806_b())) {
                TwitchStream.field_152950_b.warn(TwitchStream.field_152949_a, "Couldn't send stream metadata action at {}: {}", new Object[] { lllIllllllIIllI + lllIllllllIIlll, lllIllllllIlIII });
            }
            else {
                TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Sent stream metadata action at {}: {}", new Object[] { lllIllllllIIllI + lllIllllllIIlll, lllIllllllIlIII });
            }
        }
    }
    
    @Override
    public IngestServerTester func_152932_y() {
        return this.broadcastController.isReady();
    }
    
    @Override
    public void func_176017_a(final ChatController.ChatState lllIlllIIlllllI) {
    }
    
    @Override
    public void func_180607_b(final String lllIllIlIlIllll) {
        TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Chat disconnected");
        this.field_152955_g.clear();
    }
    
    @Override
    public void func_176020_d(final String lllIllIlIlIIlIl) {
    }
    
    @Override
    public boolean func_152913_F() {
        return this.field_152961_m;
    }
    
    @Override
    public void func_180605_a(final String lllIlllIIlIlllI, final ChatRawMessage[] lllIlllIIlIIIlI) {
        final ChatRawMessage[] lllIlllIIlIllII = lllIlllIIlIIIlI;
        for (int lllIlllIIlIlIll = lllIlllIIlIIIlI.length, lllIlllIIlIlIlI = 0; lllIlllIIlIlIlI < lllIlllIIlIlIll; ++lllIlllIIlIlIlI) {
            final ChatRawMessage lllIlllIIlIlIIl = lllIlllIIlIllII[lllIlllIIlIlIlI];
            this.func_176027_a(lllIlllIIlIlIIl.userName, lllIlllIIlIlIIl);
            if (this.func_176028_a(lllIlllIIlIlIIl.modes, lllIlllIIlIlIIl.subscriptions, this.field_152953_e.gameSettings.streamChatUserFilter)) {
                final ChatComponentText lllIlllIIlIlIII = new ChatComponentText(lllIlllIIlIlIIl.userName);
                final ChatComponentTranslation lllIlllIIlIIlll = new ChatComponentTranslation(String.valueOf(new StringBuilder("chat.stream.").append(lllIlllIIlIlIIl.action ? "emote" : "text")), new Object[] { this.field_152954_f, lllIlllIIlIlIII, EnumChatFormatting.getTextWithoutFormattingCodes(lllIlllIIlIlIIl.message) });
                if (lllIlllIIlIlIIl.action) {
                    lllIlllIIlIIlll.getChatStyle().setItalic(true);
                }
                final ChatComponentText lllIlllIIlIIllI = new ChatComponentText("");
                lllIlllIIlIIllI.appendSibling(new ChatComponentTranslation("stream.userinfo.chatTooltip", new Object[0]));
                for (final IChatComponent lllIlllIIlIIlII : GuiTwitchUserMode.func_152328_a(lllIlllIIlIlIIl.modes, lllIlllIIlIlIIl.subscriptions, null)) {
                    lllIlllIIlIIllI.appendText("\n");
                    lllIlllIIlIIllI.appendSibling(lllIlllIIlIIlII);
                }
                lllIlllIIlIlIII.getChatStyle().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, lllIlllIIlIIllI));
                lllIlllIIlIlIII.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.TWITCH_USER_INFO, lllIlllIIlIlIIl.userName));
                this.field_152953_e.ingameGUI.getChatGUI().printChatMessage(lllIlllIIlIIlll);
            }
        }
    }
    
    @Override
    public void shutdownStream() {
        TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Shutdown streaming");
        this.broadcastController.statCallback();
        this.field_152952_d.func_175988_p();
    }
    
    @Override
    public void func_152935_j() {
        final int llllIIIIIlIllIl = this.field_152953_e.gameSettings.streamChatEnabled;
        final boolean llllIIIIIlIllII = this.field_176029_e != null && this.field_152952_d.func_175990_d(this.field_176029_e);
        final boolean llllIIIIIlIlIll = this.field_152952_d.func_153000_j() == ChatController.ChatState.Initialized && (this.field_176029_e == null || this.field_152952_d.func_175989_e(this.field_176029_e) == ChatController.EnumChannelState.Disconnected);
        if (llllIIIIIlIllIl == 2) {
            if (llllIIIIIlIllII) {
                TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Disconnecting from twitch chat per user options");
                this.field_152952_d.func_175991_l(this.field_176029_e);
            }
        }
        else if (llllIIIIIlIllIl == 1) {
            if (llllIIIIIlIlIll && this.broadcastController.func_152849_q()) {
                TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Connecting to twitch chat per user options");
                this.func_152942_I();
            }
        }
        else if (llllIIIIIlIllIl == 0) {
            if (llllIIIIIlIllII && !this.func_152934_n()) {
                TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Disconnecting from twitch chat as user is no longer streaming");
                this.field_152952_d.func_175991_l(this.field_176029_e);
            }
            else if (llllIIIIIlIlIll && this.func_152934_n()) {
                TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Connecting to twitch chat as user is streaming");
                this.func_152942_I();
            }
        }
        this.broadcastController.func_152821_H();
        this.field_152952_d.func_152997_n();
    }
    
    static {
        __OBFID = "CL_00001812";
        field_152950_b = LogManager.getLogger();
        field_152949_a = MarkerManager.getMarker("STREAM");
        try {
            if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                System.loadLibrary("avutil-ttv-51");
                System.loadLibrary("swresample-ttv-0");
                System.loadLibrary("libmp3lame-ttv");
                if (System.getProperty("os.arch").contains("64")) {
                    System.loadLibrary("libmfxsw64");
                }
                else {
                    System.loadLibrary("libmfxsw32");
                }
            }
            TwitchStream.field_152965_q = true;
        }
        catch (Throwable llllIIIIlIIIIll) {
            TwitchStream.field_152965_q = false;
        }
    }
    
    private boolean func_176028_a(final Set lllIllIlllIlIII, final Set lllIllIlllIIIII, final int lllIllIlllIIlII) {
        return !lllIllIlllIlIII.contains(ChatUserMode.TTV_CHAT_USERMODE_BANNED) && (lllIllIlllIlIII.contains(ChatUserMode.TTV_CHAT_USERMODE_ADMINSTRATOR) || lllIllIlllIlIII.contains(ChatUserMode.TTV_CHAT_USERMODE_MODERATOR) || lllIllIlllIlIII.contains(ChatUserMode.TTV_CHAT_USERMODE_STAFF) || lllIllIlllIIlII == 0 || (lllIllIlllIIlII == 1 && lllIllIlllIIIII.contains(ChatUserSubscription.TTV_CHAT_USERSUB_SUBSCRIBER)));
    }
    
    @Override
    public void func_176025_a(final String lllIlllIIIIllII, final ChatTokenizedMessage[] lllIlllIIIIlIll) {
    }
    
    @Override
    public AuthFailureReason func_152918_H() {
        return this.field_152964_p;
    }
}
