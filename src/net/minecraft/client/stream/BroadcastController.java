package net.minecraft.client.stream;

import com.google.common.collect.*;
import tv.twitch.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import org.apache.logging.log4j.*;
import tv.twitch.broadcast.*;

public class BroadcastController
{
    private static final /* synthetic */ Logger logger;
    protected /* synthetic */ String field_152869_e;
    private /* synthetic */ ErrorCode field_152864_E;
    protected /* synthetic */ Core field_152872_h;
    protected /* synthetic */ VideoParams field_152881_q;
    protected /* synthetic */ StreamInfo field_152888_x;
    protected /* synthetic */ IngestServerTester field_152860_A;
    protected /* synthetic */ IStreamCallbacks field_177948_B;
    protected /* synthetic */ AuthToken field_152885_u;
    protected /* synthetic */ boolean field_152878_n;
    protected /* synthetic */ UserInfo field_152887_w;
    protected /* synthetic */ Stream field_152873_i;
    protected /* synthetic */ BroadcastState broadcastState;
    protected /* synthetic */ BroadcastListener field_152867_c;
    protected /* synthetic */ boolean field_152876_l;
    protected /* synthetic */ ChannelInfo channelInfo;
    private static final /* synthetic */ ThreadSafeBoundList field_152862_C;
    protected /* synthetic */ String field_152868_d;
    protected /* synthetic */ List field_152874_j;
    protected /* synthetic */ IStatCallbacks field_177949_C;
    protected /* synthetic */ IngestServer field_152884_t;
    private /* synthetic */ String field_152863_D;
    protected /* synthetic */ ArchivingState field_152889_y;
    protected /* synthetic */ boolean field_152877_m;
    protected /* synthetic */ String field_152870_f;
    protected /* synthetic */ AudioParams field_152882_r;
    protected /* synthetic */ IngestList field_152883_s;
    protected /* synthetic */ String field_152880_p;
    protected /* synthetic */ List field_152875_k;
    protected /* synthetic */ long field_152890_z;
    protected /* synthetic */ boolean field_152871_g;
    
    protected PixelFormat func_152826_z() {
        return PixelFormat.TTV_PF_RGBA;
    }
    
    public ErrorCode func_152852_P() {
        return this.field_152864_E;
    }
    
    protected void func_152835_I() {
        final long llllllllllllllIlIIllllIIIlIIIlIl = System.nanoTime();
        final long llllllllllllllIlIIllllIIIlIIIlII = (llllllllllllllIlIIllllIIIlIIIlIl - this.field_152890_z) / 1000000000L;
        if (llllllllllllllIlIIllllIIIlIIIlII >= 30L) {
            this.field_152890_z = llllllllllllllIlIIllllIIIlIIIlIl;
            final ErrorCode llllllllllllllIlIIllllIIIlIIIIll = this.field_152873_i.getStreamInfo(this.field_152885_u, this.field_152880_p);
            if (ErrorCode.failed(llllllllllllllIlIIllllIIIlIIIIll)) {
                final String llllllllllllllIlIIllllIIIlIIIIlI = ErrorCode.getString(llllllllllllllIlIIllllIIIlIIIIll);
                this.func_152820_d(String.format("Error in TTV_GetStreamInfo: %s", llllllllllllllIlIIllllIIIlIIIIlI));
            }
        }
    }
    
    public IngestList func_152855_t() {
        return this.field_152883_s;
    }
    
    public boolean func_152817_A() {
        if (this.field_152876_l) {
            return false;
        }
        this.field_152873_i.setStreamCallbacks(this.field_177948_B);
        ErrorCode llllllllllllllIlIIllllIlIIIIlIll = this.field_152872_h.initialize(this.field_152868_d, System.getProperty("java.library.path"));
        if (!this.func_152853_a(llllllllllllllIlIIllllIlIIIIlIll)) {
            this.field_152873_i.setStreamCallbacks((IStreamCallbacks)null);
            this.field_152864_E = llllllllllllllIlIIllllIlIIIIlIll;
            return false;
        }
        llllllllllllllIlIIllllIlIIIIlIll = this.field_152872_h.setTraceLevel(MessageLevel.TTV_ML_ERROR);
        if (!this.func_152853_a(llllllllllllllIlIIllllIlIIIIlIll)) {
            this.field_152873_i.setStreamCallbacks((IStreamCallbacks)null);
            this.field_152872_h.shutdown();
            this.field_152864_E = llllllllllllllIlIIllllIlIIIIlIll;
            return false;
        }
        if (ErrorCode.succeeded(llllllllllllllIlIIllllIlIIIIlIll)) {
            this.field_152876_l = true;
            this.func_152827_a(BroadcastState.Initialized);
            return true;
        }
        this.field_152864_E = llllllllllllllIlIIllllIlIIIIlIll;
        this.field_152872_h.shutdown();
        return false;
    }
    
    public boolean isIngestTesting() {
        return this.broadcastState == BroadcastState.IngestTesting;
    }
    
    public boolean func_152858_b() {
        return this.field_152876_l;
    }
    
    public boolean func_152819_E() {
        if (!this.isBroadcasting()) {
            return false;
        }
        final ErrorCode llllllllllllllIlIIllllIIlIllIIII = this.field_152873_i.stop(true);
        if (ErrorCode.failed(llllllllllllllIlIIllllIIlIllIIII)) {
            final String llllllllllllllIlIIllllIIlIlIllll = ErrorCode.getString(llllllllllllllIlIIllllIIlIllIIII);
            this.func_152820_d(String.format("Error while stopping the broadcast: %s", llllllllllllllIlIIllllIIlIlIllll));
            return false;
        }
        this.func_152827_a(BroadcastState.Stopping);
        return ErrorCode.succeeded(llllllllllllllIlIIllllIIlIllIIII);
    }
    
    public boolean func_152849_q() {
        return this.field_152877_m;
    }
    
    public VideoParams func_152834_a(final int llllllllllllllIlIIllllIIllIIllIl, final int llllllllllllllIlIIllllIIllIIIlIl, final float llllllllllllllIlIIllllIIllIIIlII, final float llllllllllllllIlIIllllIIllIIIIll) {
        final int[] llllllllllllllIlIIllllIIllIIlIIl = this.field_152873_i.getMaxResolution(llllllllllllllIlIIllllIIllIIllIl, llllllllllllllIlIIllllIIllIIIlIl, llllllllllllllIlIIllllIIllIIIlII, llllllllllllllIlIIllllIIllIIIIll);
        final VideoParams llllllllllllllIlIIllllIIllIIlIII = new VideoParams();
        llllllllllllllIlIIllllIIllIIlIII.maxKbps = llllllllllllllIlIIllllIIllIIllIl;
        llllllllllllllIlIIllllIIllIIlIII.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
        llllllllllllllIlIIllllIIllIIlIII.pixelFormat = this.func_152826_z();
        llllllllllllllIlIIllllIIllIIlIII.targetFps = llllllllllllllIlIIllllIIllIIIlIl;
        llllllllllllllIlIIllllIIllIIlIII.outputWidth = llllllllllllllIlIIllllIIllIIlIIl[0];
        llllllllllllllIlIIllllIIllIIlIII.outputHeight = llllllllllllllIlIIllllIIllIIlIIl[1];
        llllllllllllllIlIIllllIIllIIlIII.disableAdaptiveBitrate = false;
        llllllllllllllIlIIllllIIllIIlIII.verticalFlip = false;
        return llllllllllllllIlIIllllIIllIIlIII;
    }
    
    protected boolean func_152823_L() {
        for (int llllllllllllllIlIIllllIIIIllIlIl = 0; llllllllllllllIlIIllllIIIIllIlIl < 3; ++llllllllllllllIlIIllllIIIIllIlIl) {
            final FrameBuffer llllllllllllllIlIIllllIIIIllIlII = this.field_152873_i.allocateFrameBuffer(this.field_152881_q.outputWidth * this.field_152881_q.outputHeight * 4);
            if (!llllllllllllllIlIIllllIIIIllIlII.getIsValid()) {
                this.func_152820_d(String.format("Error while allocating frame buffer", new Object[0]));
                return false;
            }
            this.field_152874_j.add(llllllllllllllIlIIllllIIIIllIlII);
            this.field_152875_k.add(llllllllllllllIlIIllllIIIIllIlII);
        }
        return true;
    }
    
    public IngestServerTester func_152838_J() {
        if (!this.func_152857_n() || this.field_152883_s == null) {
            return null;
        }
        if (this.isIngestTesting()) {
            return null;
        }
        this.field_152860_A = new IngestServerTester(this.field_152873_i, this.field_152883_s);
        this.field_152860_A.func_176004_j();
        this.func_152827_a(BroadcastState.IngestTesting);
        return this.field_152860_A;
    }
    
    protected boolean func_152853_a(final ErrorCode llllllllllllllIlIIllllIIIIIIIIIl) {
        if (ErrorCode.failed(llllllllllllllIlIIllllIIIIIIIIIl)) {
            this.func_152820_d(ErrorCode.getString(llllllllllllllIlIIllllIIIIIIIIIl));
            return false;
        }
        return true;
    }
    
    public StreamInfo func_152816_j() {
        return this.field_152888_x;
    }
    
    public boolean func_152845_C() {
        if (this.isIngestTesting()) {
            return false;
        }
        if (this.isBroadcasting()) {
            this.field_152873_i.stop(false);
        }
        this.field_152880_p = "";
        this.field_152885_u = new AuthToken();
        if (!this.field_152877_m) {
            return false;
        }
        this.field_152877_m = false;
        if (!this.field_152878_n) {
            try {
                if (this.field_152867_c != null) {
                    this.field_152867_c.func_152895_a();
                }
            }
            catch (Exception llllllllllllllIlIIllllIIllllIIII) {
                this.func_152820_d(llllllllllllllIlIIllllIIllllIIII.toString());
            }
        }
        this.func_152827_a(BroadcastState.Initialized);
        return true;
    }
    
    public boolean func_152847_F() {
        if (!this.isBroadcasting()) {
            return false;
        }
        final ErrorCode llllllllllllllIlIIllllIIlIlIIlll = this.field_152873_i.pauseVideo();
        if (ErrorCode.failed(llllllllllllllIlIIllllIIlIlIIlll)) {
            this.func_152819_E();
            final String llllllllllllllIlIIllllIIlIlIIllI = ErrorCode.getString(llllllllllllllIlIIllllIIlIlIIlll);
            this.func_152820_d(String.format("Error pausing stream: %s\n", llllllllllllllIlIIllllIIlIlIIllI));
        }
        else {
            this.func_152827_a(BroadcastState.Paused);
        }
        return ErrorCode.succeeded(llllllllllllllIlIIllllIIlIlIIlll);
    }
    
    public IngestServer func_152833_s() {
        return this.field_152884_t;
    }
    
    public long func_152844_x() {
        return this.field_152873_i.getStreamTime();
    }
    
    public ChannelInfo func_152843_l() {
        return this.channelInfo;
    }
    
    public IngestServerTester isReady() {
        return this.field_152860_A;
    }
    
    protected boolean func_152848_y() {
        return true;
    }
    
    public void func_152821_H() {
        if (this.field_152873_i != null && this.field_152876_l) {
            ErrorCode llllllllllllllIlIIllllIIIlIlIIll = this.field_152873_i.pollTasks();
            this.func_152853_a(llllllllllllllIlIIllllIIIlIlIIll);
            if (this.isIngestTesting()) {
                this.field_152860_A.func_153041_j();
                if (this.field_152860_A.func_153032_e()) {
                    this.field_152860_A = null;
                    this.func_152827_a(BroadcastState.ReadyToBroadcast);
                }
            }
            switch (SwitchBroadcastState.field_177773_a[this.broadcastState.ordinal()]) {
                case 1: {
                    this.func_152827_a(BroadcastState.LoggingIn);
                    llllllllllllllIlIIllllIIIlIlIIll = this.field_152873_i.login(this.field_152885_u);
                    if (ErrorCode.failed(llllllllllllllIlIIllllIIIlIlIIll)) {
                        final String llllllllllllllIlIIllllIIIlIlIIlI = ErrorCode.getString(llllllllllllllIlIIllllIIIlIlIIll);
                        this.func_152820_d(String.format("Error in TTV_Login: %s\n", llllllllllllllIlIIllllIIIlIlIIlI));
                        break;
                    }
                    break;
                }
                case 2: {
                    this.func_152827_a(BroadcastState.FindingIngestServer);
                    llllllllllllllIlIIllllIIIlIlIIll = this.field_152873_i.getIngestServers(this.field_152885_u);
                    if (ErrorCode.failed(llllllllllllllIlIIllllIIIlIlIIll)) {
                        this.func_152827_a(BroadcastState.LoggedIn);
                        final String llllllllllllllIlIIllllIIIlIlIIIl = ErrorCode.getString(llllllllllllllIlIIllllIIIlIlIIll);
                        this.func_152820_d(String.format("Error in TTV_GetIngestServers: %s\n", llllllllllllllIlIIllllIIIlIlIIIl));
                        break;
                    }
                    break;
                }
                case 3: {
                    this.func_152827_a(BroadcastState.ReadyToBroadcast);
                    llllllllllllllIlIIllllIIIlIlIIll = this.field_152873_i.getUserInfo(this.field_152885_u);
                    if (ErrorCode.failed(llllllllllllllIlIIllllIIIlIlIIll)) {
                        final String llllllllllllllIlIIllllIIIlIlIIII = ErrorCode.getString(llllllllllllllIlIIllllIIIlIlIIll);
                        this.func_152820_d(String.format("Error in TTV_GetUserInfo: %s\n", llllllllllllllIlIIllllIIIlIlIIII));
                    }
                    this.func_152835_I();
                    llllllllllllllIlIIllllIIIlIlIIll = this.field_152873_i.getArchivingState(this.field_152885_u);
                    if (ErrorCode.failed(llllllllllllllIlIIllllIIIlIlIIll)) {
                        final String llllllllllllllIlIIllllIIIlIIllll = ErrorCode.getString(llllllllllllllIlIIllllIIIlIlIIll);
                        this.func_152820_d(String.format("Error in TTV_GetArchivingState: %s\n", llllllllllllllIlIIllllIIIlIIllll));
                        break;
                    }
                    break;
                }
                case 11:
                case 12: {
                    this.func_152835_I();
                    break;
                }
            }
        }
    }
    
    protected void func_152827_a(final BroadcastState llllllllllllllIlIIllllIIIlIllIIl) {
        if (llllllllllllllIlIIllllIIIlIllIIl != this.broadcastState) {
            this.broadcastState = llllllllllllllIlIIllllIIIlIllIIl;
            try {
                if (this.field_152867_c != null) {
                    this.field_152867_c.func_152891_a(llllllllllllllIlIIllllIIIlIllIIl);
                }
            }
            catch (Exception llllllllllllllIlIIllllIIIlIllIll) {
                this.func_152820_d(llllllllllllllIlIIllllIIIlIllIll.toString());
            }
        }
    }
    
    public boolean isBroadcastPaused() {
        return this.broadcastState == BroadcastState.Paused;
    }
    
    public long func_177946_b(final String llllllllllllllIlIIllllIIlIIIIIll, final long llllllllllllllIlIIllllIIlIIIIIlI, final String llllllllllllllIlIIllllIIlIIIIIIl, final String llllllllllllllIlIIllllIIIllllIlI) {
        final long llllllllllllllIlIIllllIIIlllllll = this.field_152873_i.sendStartSpanMetaData(this.field_152885_u, llllllllllllllIlIIllllIIlIIIIIll, llllllllllllllIlIIllllIIlIIIIIlI, llllllllllllllIlIIllllIIlIIIIIIl, llllllllllllllIlIIllllIIIllllIlI);
        if (llllllllllllllIlIIllllIIIlllllll == -1L) {
            this.func_152820_d(String.format("Error in SendStartSpanMetaData\n", new Object[0]));
        }
        return llllllllllllllIlIIllllIIIlllllll;
    }
    
    public boolean func_152857_n() {
        return this.broadcastState == BroadcastState.ReadyToBroadcast;
    }
    
    public BroadcastController() {
        this.field_152863_D = null;
        this.field_152867_c = null;
        this.field_152868_d = "";
        this.field_152869_e = "";
        this.field_152870_f = "";
        this.field_152871_g = true;
        this.field_152872_h = null;
        this.field_152873_i = null;
        this.field_152874_j = Lists.newArrayList();
        this.field_152875_k = Lists.newArrayList();
        this.field_152876_l = false;
        this.field_152877_m = false;
        this.field_152878_n = false;
        this.broadcastState = BroadcastState.Uninitialized;
        this.field_152880_p = null;
        this.field_152881_q = null;
        this.field_152882_r = null;
        this.field_152883_s = new IngestList(new IngestServer[0]);
        this.field_152884_t = null;
        this.field_152885_u = new AuthToken();
        this.channelInfo = new ChannelInfo();
        this.field_152887_w = new UserInfo();
        this.field_152888_x = new StreamInfo();
        this.field_152889_y = new ArchivingState();
        this.field_152890_z = 0L;
        this.field_152860_A = null;
        this.field_177948_B = (IStreamCallbacks)new IStreamCallbacks() {
            public void sendEndSpanMetaDataCallback(final ErrorCode llllllllllllllllIllIlllIllIIllll) {
                if (ErrorCode.failed(llllllllllllllllIllIlllIllIIllll)) {
                    final String llllllllllllllllIllIlllIllIIlllI = ErrorCode.getString(llllllllllllllllIllIlllIllIIllll);
                    BroadcastController.this.func_152820_d(String.format("sendEndSpanMetaDataCallback got failure: %s", llllllllllllllllIllIlllIllIIlllI));
                }
            }
            
            public void sendActionMetaDataCallback(final ErrorCode llllllllllllllllIllIlllIllIllllI) {
                if (ErrorCode.failed(llllllllllllllllIllIlllIllIllllI)) {
                    final String llllllllllllllllIllIlllIlllIIIII = ErrorCode.getString(llllllllllllllllIllIlllIllIllllI);
                    BroadcastController.this.func_152820_d(String.format("sendActionMetaDataCallback got failure: %s", llllllllllllllllIllIlllIlllIIIII));
                }
            }
            
            public void bufferUnlockCallback(final long llllllllllllllllIllIlllIllllllII) {
                final FrameBuffer llllllllllllllllIllIlllIlllllllI = FrameBuffer.lookupBuffer(llllllllllllllllIllIlllIllllllII);
                BroadcastController.this.field_152875_k.add(llllllllllllllllIllIlllIlllllllI);
            }
            
            public void startCallback(final ErrorCode llllllllllllllllIllIlllIllllIllI) {
                if (ErrorCode.succeeded(llllllllllllllllIllIlllIllllIllI)) {
                    try {
                        if (BroadcastController.this.field_152867_c != null) {
                            BroadcastController.this.field_152867_c.func_152899_b();
                        }
                    }
                    catch (Exception llllllllllllllllIllIlllIllllIlIl) {
                        BroadcastController.this.func_152820_d(llllllllllllllllIllIlllIllllIlIl.toString());
                    }
                    BroadcastController.this.func_152827_a(BroadcastState.Broadcasting);
                }
                else {
                    BroadcastController.this.field_152881_q = null;
                    BroadcastController.this.field_152882_r = null;
                    BroadcastController.this.func_152827_a(BroadcastState.ReadyToBroadcast);
                    try {
                        if (BroadcastController.this.field_152867_c != null) {
                            BroadcastController.this.field_152867_c.func_152892_c(llllllllllllllllIllIlllIllllIllI);
                        }
                    }
                    catch (Exception llllllllllllllllIllIlllIllllIlII) {
                        BroadcastController.this.func_152820_d(llllllllllllllllIllIlllIllllIlII.toString());
                    }
                    final String llllllllllllllllIllIlllIllllIIll = ErrorCode.getString(llllllllllllllllIllIlllIllllIllI);
                    BroadcastController.this.func_152820_d(String.format("startCallback got failure: %s", llllllllllllllllIllIlllIllllIIll));
                }
            }
            
            public void setStreamInfoCallback(final ErrorCode llllllllllllllllIllIllllIIIlIlIl) {
                if (ErrorCode.failed(llllllllllllllllIllIllllIIIlIlIl)) {
                    final String llllllllllllllllIllIllllIIIlIlII = ErrorCode.getString(llllllllllllllllIllIllllIIIlIlIl);
                    BroadcastController.this.func_152832_e(String.format("SetStreamInfoCallback got failure: %s", llllllllllllllllIllIllllIIIlIlII));
                }
            }
            
            public void sendStartSpanMetaDataCallback(final ErrorCode llllllllllllllllIllIlllIllIlIlIl) {
                if (ErrorCode.failed(llllllllllllllllIllIlllIllIlIlIl)) {
                    final String llllllllllllllllIllIlllIllIlIlll = ErrorCode.getString(llllllllllllllllIllIlllIllIlIlIl);
                    BroadcastController.this.func_152820_d(String.format("sendStartSpanMetaDataCallback got failure: %s", llllllllllllllllIllIlllIllIlIlll));
                }
            }
            
            public void loginCallback(final ErrorCode llllllllllllllllIllIllllIlIlIlII, final ChannelInfo llllllllllllllllIllIllllIlIlIIll) {
                if (ErrorCode.succeeded(llllllllllllllllIllIllllIlIlIlII)) {
                    BroadcastController.this.channelInfo = llllllllllllllllIllIllllIlIlIIll;
                    BroadcastController.this.func_152827_a(BroadcastState.LoggedIn);
                    BroadcastController.this.field_152877_m = true;
                }
                else {
                    BroadcastController.this.func_152827_a(BroadcastState.Initialized);
                    BroadcastController.this.field_152877_m = false;
                    final String llllllllllllllllIllIllllIlIlIlll = ErrorCode.getString(llllllllllllllllIllIllllIlIlIlII);
                    BroadcastController.this.func_152820_d(String.format("LoginCallback got failure: %s", llllllllllllllllIllIllllIlIlIlll));
                }
                try {
                    if (BroadcastController.this.field_152867_c != null) {
                        BroadcastController.this.field_152867_c.func_152897_a(llllllllllllllllIllIllllIlIlIlII);
                    }
                }
                catch (Exception llllllllllllllllIllIllllIlIlIllI) {
                    BroadcastController.this.func_152820_d(llllllllllllllllIllIllllIlIlIllI.toString());
                }
            }
            
            public void requestAuthTokenCallback(final ErrorCode llllllllllllllllIllIllllIllIIllI, final AuthToken llllllllllllllllIllIllllIllIIlIl) {
                if (ErrorCode.succeeded(llllllllllllllllIllIllllIllIIllI)) {
                    BroadcastController.this.field_152885_u = llllllllllllllllIllIllllIllIIlIl;
                    BroadcastController.this.func_152827_a(BroadcastState.Authenticated);
                }
                else {
                    BroadcastController.this.field_152885_u.data = "";
                    BroadcastController.this.func_152827_a(BroadcastState.Initialized);
                    final String llllllllllllllllIllIllllIllIIlII = ErrorCode.getString(llllllllllllllllIllIllllIllIIllI);
                    BroadcastController.this.func_152820_d(String.format("RequestAuthTokenDoneCallback got failure: %s", llllllllllllllllIllIllllIllIIlII));
                }
                try {
                    if (BroadcastController.this.field_152867_c != null) {
                        BroadcastController.this.field_152867_c.func_152900_a(llllllllllllllllIllIllllIllIIllI, llllllllllllllllIllIllllIllIIlIl);
                    }
                }
                catch (Exception llllllllllllllllIllIllllIllIIIll) {
                    BroadcastController.this.func_152820_d(llllllllllllllllIllIllllIllIIIll.toString());
                }
            }
            
            public void getGameNameListCallback(final ErrorCode llllllllllllllllIllIllllIIIIlIll, final GameInfoList llllllllllllllllIllIllllIIIIIlIl) {
                if (ErrorCode.failed(llllllllllllllllIllIllllIIIIlIll)) {
                    final String llllllllllllllllIllIllllIIIIlIIl = ErrorCode.getString(llllllllllllllllIllIllllIIIIlIll);
                    BroadcastController.this.func_152820_d(String.format("GameNameListCallback got failure: %s", llllllllllllllllIllIllllIIIIlIIl));
                }
                try {
                    if (BroadcastController.this.field_152867_c != null) {
                        BroadcastController.this.field_152867_c.func_152898_a(llllllllllllllllIllIllllIIIIlIll, (llllllllllllllllIllIllllIIIIIlIl == null) ? new GameInfo[0] : llllllllllllllllIllIllllIIIIIlIl.list);
                    }
                }
                catch (Exception llllllllllllllllIllIllllIIIIlIII) {
                    BroadcastController.this.func_152820_d(llllllllllllllllIllIllllIIIIlIII.toString());
                }
            }
            
            public void getArchivingStateCallback(final ErrorCode llllllllllllllllIllIllllIIlIIlII, final ArchivingState llllllllllllllllIllIllllIIlIIllI) {
                BroadcastController.this.field_152889_y = llllllllllllllllIllIllllIIlIIllI;
                if (ErrorCode.failed(llllllllllllllllIllIllllIIlIIlII)) {}
            }
            
            public void getIngestServersCallback(final ErrorCode llllllllllllllllIllIllllIlIIllII, final IngestList llllllllllllllllIllIllllIlIIlIll) {
                if (ErrorCode.succeeded(llllllllllllllllIllIllllIlIIllII)) {
                    BroadcastController.this.field_152883_s = llllllllllllllllIllIllllIlIIlIll;
                    BroadcastController.this.field_152884_t = BroadcastController.this.field_152883_s.getDefaultServer();
                    BroadcastController.this.func_152827_a(BroadcastState.ReceivedIngestServers);
                    try {
                        if (BroadcastController.this.field_152867_c != null) {
                            BroadcastController.this.field_152867_c.func_152896_a(llllllllllllllllIllIllllIlIIlIll);
                        }
                    }
                    catch (Exception llllllllllllllllIllIllllIlIIlIlI) {
                        BroadcastController.this.func_152820_d(llllllllllllllllIllIllllIlIIlIlI.toString());
                    }
                }
                else {
                    final String llllllllllllllllIllIllllIlIIlIIl = ErrorCode.getString(llllllllllllllllIllIllllIlIIllII);
                    BroadcastController.this.func_152820_d(String.format("IngestListCallback got failure: %s", llllllllllllllllIllIllllIlIIlIIl));
                    BroadcastController.this.func_152827_a(BroadcastState.LoggingIn);
                }
            }
            
            static {
                __OBFID = "CL_00002375";
            }
            
            public void stopCallback(final ErrorCode llllllllllllllllIllIlllIlllIIlll) {
                if (ErrorCode.succeeded(llllllllllllllllIllIlllIlllIIlll)) {
                    BroadcastController.this.field_152881_q = null;
                    BroadcastController.this.field_152882_r = null;
                    BroadcastController.this.func_152831_M();
                    try {
                        if (BroadcastController.this.field_152867_c != null) {
                            BroadcastController.this.field_152867_c.func_152901_c();
                        }
                    }
                    catch (Exception llllllllllllllllIllIlllIlllIlIlI) {
                        BroadcastController.this.func_152820_d(llllllllllllllllIllIlllIlllIlIlI.toString());
                    }
                    if (BroadcastController.this.field_152877_m) {
                        BroadcastController.this.func_152827_a(BroadcastState.ReadyToBroadcast);
                    }
                    else {
                        BroadcastController.this.func_152827_a(BroadcastState.Initialized);
                    }
                }
                else {
                    BroadcastController.this.func_152827_a(BroadcastState.ReadyToBroadcast);
                    final String llllllllllllllllIllIlllIlllIlIIl = ErrorCode.getString(llllllllllllllllIllIlllIlllIIlll);
                    BroadcastController.this.func_152820_d(String.format("stopCallback got failure: %s", llllllllllllllllIllIlllIlllIlIIl));
                }
            }
            
            public void runCommercialCallback(final ErrorCode llllllllllllllllIllIllllIIIllllI) {
                if (ErrorCode.failed(llllllllllllllllIllIllllIIIllllI)) {
                    final String llllllllllllllllIllIllllIIIlllIl = ErrorCode.getString(llllllllllllllllIllIllllIIIllllI);
                    BroadcastController.this.func_152832_e(String.format("RunCommercialCallback got failure: %s", llllllllllllllllIllIllllIIIlllIl));
                }
            }
            
            public void getStreamInfoCallback(final ErrorCode llllllllllllllllIllIllllIIlIlllI, final StreamInfo llllllllllllllllIllIllllIIlIllIl) {
                if (ErrorCode.succeeded(llllllllllllllllIllIllllIIlIlllI)) {
                    BroadcastController.this.field_152888_x = llllllllllllllllIllIllllIIlIllIl;
                    try {
                        if (BroadcastController.this.field_152867_c != null) {
                            BroadcastController.this.field_152867_c.func_152894_a(llllllllllllllllIllIllllIIlIllIl);
                        }
                    }
                    catch (Exception llllllllllllllllIllIllllIIllIIIl) {
                        BroadcastController.this.func_152820_d(llllllllllllllllIllIllllIIllIIIl.toString());
                    }
                }
                else {
                    final String llllllllllllllllIllIllllIIllIIII = ErrorCode.getString(llllllllllllllllIllIllllIIlIlllI);
                    BroadcastController.this.func_152832_e(String.format("StreamInfoDoneCallback got failure: %s", llllllllllllllllIllIllllIIllIIII));
                }
            }
            
            public void getUserInfoCallback(final ErrorCode llllllllllllllllIllIllllIIlllIll, final UserInfo llllllllllllllllIllIllllIIlllIlI) {
                BroadcastController.this.field_152887_w = llllllllllllllllIllIllllIIlllIlI;
                if (ErrorCode.failed(llllllllllllllllIllIllllIIlllIll)) {
                    final String llllllllllllllllIllIllllIIllllIl = ErrorCode.getString(llllllllllllllllIllIllllIIlllIll);
                    BroadcastController.this.func_152820_d(String.format("UserInfoDoneCallback got failure: %s", llllllllllllllllIllIllllIIllllIl));
                }
            }
        };
        this.field_177949_C = (IStatCallbacks)new IStatCallbacks() {
            static {
                __OBFID = "CL_00002374";
            }
            
            public void statCallback(final StatType llllllllllllllllIllllIIlIIIIlIIl, final long llllllllllllllllIllllIIlIIIIlIII) {
            }
        };
        this.field_152872_h = Core.getInstance();
        if (Core.getInstance() == null) {
            this.field_152872_h = new Core((CoreAPI)new StandardCoreAPI());
        }
        this.field_152873_i = new Stream((StreamAPI)new DesktopStreamAPI());
    }
    
    public void func_152837_b(final float llllllllllllllIlIIllllIlIIIlllIl) {
        this.field_152873_i.setVolume(AudioDeviceType.TTV_PLAYBACK_DEVICE, llllllllllllllIlIIllllIlIIIlllIl);
    }
    
    public void func_152842_a(final String llllllllllllllIlIIllllIlIlIIlIlI) {
        this.field_152868_d = llllllllllllllIlIIllllIlIlIIlIlI;
    }
    
    public boolean func_152828_a(String llllllllllllllIlIIllllIIlllIIIII, String llllllllllllllIlIIllllIIllIlllll, String llllllllllllllIlIIllllIIllIllllI) {
        if (!this.field_152877_m) {
            return false;
        }
        if (llllllllllllllIlIIllllIIlllIIIII == null || ((String)llllllllllllllIlIIllllIIlllIIIII).equals("")) {
            llllllllllllllIlIIllllIIlllIIIII = this.field_152880_p;
        }
        if (llllllllllllllIlIIllllIIllIlllll == null) {
            llllllllllllllIlIIllllIIllIlllll = "";
        }
        if (llllllllllllllIlIIllllIIllIllllI == null) {
            llllllllllllllIlIIllllIIllIllllI = "";
        }
        final StreamInfoForSetting llllllllllllllIlIIllllIIlllIIIll = new StreamInfoForSetting();
        llllllllllllllIlIIllllIIlllIIIll.streamTitle = (String)llllllllllllllIlIIllllIIllIllllI;
        llllllllllllllIlIIllllIIlllIIIll.gameName = (String)llllllllllllllIlIIllllIIllIlllll;
        final ErrorCode llllllllllllllIlIIllllIIlllIIIlI = this.field_152873_i.setStreamInfo(this.field_152885_u, (String)llllllllllllllIlIIllllIIlllIIIII, llllllllllllllIlIIllllIIlllIIIll);
        this.func_152853_a(llllllllllllllIlIIllllIIlllIIIlI);
        return ErrorCode.succeeded(llllllllllllllIlIIllllIIlllIIIlI);
    }
    
    protected void func_152832_e(final String llllllllllllllIlIIlllIllllllIlll) {
        BroadcastController.field_152862_C.func_152757_a(String.valueOf(new StringBuilder("<Warning> ").append(llllllllllllllIlIIlllIllllllIlll)));
        BroadcastController.logger.warn(TwitchStream.field_152949_a, "[Broadcast controller] {}", new Object[] { llllllllllllllIlIIlllIllllllIlll });
    }
    
    public boolean isBroadcasting() {
        return this.broadcastState == BroadcastState.Broadcasting || this.broadcastState == BroadcastState.Paused;
    }
    
    public void func_152841_a(final BroadcastListener llllllllllllllIlIIllllIlIlIlIlIl) {
        this.field_152867_c = llllllllllllllIlIIllllIlIlIlIlIl;
    }
    
    protected void func_152820_d(final String llllllllllllllIlIIlllIlllllllIll) {
        this.field_152863_D = llllllllllllllIlIIlllIlllllllIll;
        BroadcastController.field_152862_C.func_152757_a(String.valueOf(new StringBuilder("<Error> ").append(llllllllllllllIlIIlllIlllllllIll)));
        BroadcastController.logger.error(TwitchStream.field_152949_a, "[Broadcast controller] {}", new Object[] { llllllllllllllIlIIlllIlllllllIll });
    }
    
    public boolean func_152854_G() {
        if (!this.isBroadcastPaused()) {
            return false;
        }
        this.func_152827_a(BroadcastState.Broadcasting);
        return true;
    }
    
    public void func_152846_a(final FrameBuffer llllllllllllllIlIIllllIIIIIllIll) {
        try {
            this.field_152873_i.captureFrameBuffer_ReadPixels(llllllllllllllIlIIllllIIIIIllIll);
        }
        catch (Throwable llllllllllllllIlIIllllIIIIIllIlI) {
            final CrashReport llllllllllllllIlIIllllIIIIIllIIl = CrashReport.makeCrashReport(llllllllllllllIlIIllllIIIIIllIlI, "Trying to submit a frame to Twitch");
            final CrashReportCategory llllllllllllllIlIIllllIIIIIllIII = llllllllllllllIlIIllllIIIIIllIIl.makeCategory("Broadcast State");
            llllllllllllllIlIIllllIIIIIllIII.addCrashSection("Last reported errors", Arrays.toString(BroadcastController.field_152862_C.func_152756_c()));
            llllllllllllllIlIIllllIIIIIllIII.addCrashSection("Buffer", llllllllllllllIlIIllllIIIIIllIll);
            llllllllllllllIlIIllllIIIIIllIII.addCrashSection("Free buffer count", this.field_152875_k.size());
            llllllllllllllIlIIllllIIIIIllIII.addCrashSection("Capture buffer count", this.field_152874_j.size());
            throw new ReportedException(llllllllllllllIlIIllllIIIIIllIIl);
        }
    }
    
    public boolean func_152840_a(final String llllllllllllllIlIIllllIIlIIlIlll, final long llllllllllllllIlIIllllIIlIIlIllI, final String llllllllllllllIlIIllllIIlIIlIlIl, final String llllllllllllllIlIIllllIIlIIlIlII) {
        final ErrorCode llllllllllllllIlIIllllIIlIIlIIll = this.field_152873_i.sendActionMetaData(this.field_152885_u, llllllllllllllIlIIllllIIlIIlIlll, llllllllllllllIlIIllllIIlIIlIllI, llllllllllllllIlIIllllIIlIIlIlIl, llllllllllllllIlIIllllIIlIIlIlII);
        if (ErrorCode.failed(llllllllllllllIlIIllllIIlIIlIIll)) {
            final String llllllllllllllIlIIllllIIlIIlIIlI = ErrorCode.getString(llllllllllllllIlIIllllIIlIIlIIll);
            this.func_152820_d(String.format("Error while sending meta data: %s\n", llllllllllllllIlIIllllIIlIIlIIlI));
            return false;
        }
        return true;
    }
    
    public void func_152824_a(final IngestServer llllllllllllllIlIIllllIlIIlIlllI) {
        this.field_152884_t = llllllllllllllIlIIllllIlIIlIlllI;
    }
    
    public void func_152829_a(final float llllllllllllllIlIIllllIlIIlIIlIl) {
        this.field_152873_i.setVolume(AudioDeviceType.TTV_RECORDER_DEVICE, llllllllllllllIlIIllllIlIIlIIlIl);
    }
    
    public boolean func_152851_B() {
        if (!this.field_152876_l) {
            return true;
        }
        if (this.isIngestTesting()) {
            return false;
        }
        this.field_152878_n = true;
        this.func_152845_C();
        this.field_152873_i.setStreamCallbacks((IStreamCallbacks)null);
        this.field_152873_i.setStatCallbacks((IStatCallbacks)null);
        final ErrorCode llllllllllllllIlIIllllIlIIIIIlIl = this.field_152872_h.shutdown();
        this.func_152853_a(llllllllllllllIlIIllllIlIIIIIlIl);
        this.field_152876_l = false;
        this.field_152878_n = false;
        this.func_152827_a(BroadcastState.Uninitialized);
        return true;
    }
    
    public ErrorCode func_152859_b(final FrameBuffer llllllllllllllIlIIllllIIIIIIllIl) {
        if (this.isBroadcastPaused()) {
            this.func_152854_G();
        }
        else if (!this.isBroadcasting()) {
            return ErrorCode.TTV_EC_STREAM_NOT_STARTED;
        }
        final ErrorCode llllllllllllllIlIIllllIIIIIIllII = this.field_152873_i.submitVideoFrame(llllllllllllllIlIIllllIIIIIIllIl);
        if (llllllllllllllIlIIllllIIIIIIllII != ErrorCode.TTV_EC_SUCCESS) {
            final String llllllllllllllIlIIllllIIIIIIlIll = ErrorCode.getString(llllllllllllllIlIIllllIIIIIIllII);
            if (ErrorCode.succeeded(llllllllllllllIlIIllllIIIIIIllII)) {
                this.func_152832_e(String.format("Warning in SubmitTexturePointer: %s\n", llllllllllllllIlIIllllIIIIIIlIll));
            }
            else {
                this.func_152820_d(String.format("Error in SubmitTexturePointer: %s\n", llllllllllllllIlIIllllIIIIIIlIll));
                this.func_152819_E();
            }
            if (this.field_152867_c != null) {
                this.field_152867_c.func_152893_b(llllllllllllllIlIIllllIIIIIIllII);
            }
        }
        return llllllllllllllIlIIllllIIIIIIllII;
    }
    
    public boolean func_177947_a(final String llllllllllllllIlIIllllIIIllIIlll, final long llllllllllllllIlIIllllIIIllIIllI, final long llllllllllllllIlIIllllIIIllIllIl, final String llllllllllllllIlIIllllIIIllIllII, final String llllllllllllllIlIIllllIIIllIlIll) {
        if (llllllllllllllIlIIllllIIIllIllIl == -1L) {
            this.func_152820_d(String.format("Invalid sequence id: %d\n", llllllllllllllIlIIllllIIIllIllIl));
            return false;
        }
        final ErrorCode llllllllllllllIlIIllllIIIllIlIlI = this.field_152873_i.sendEndSpanMetaData(this.field_152885_u, llllllllllllllIlIIllllIIIllIIlll, llllllllllllllIlIIllllIIIllIIllI, llllllllllllllIlIIllllIIIllIllIl, llllllllllllllIlIIllllIIIllIllII, llllllllllllllIlIIllllIIIllIlIll);
        if (ErrorCode.failed(llllllllllllllIlIIllllIIIllIlIlI)) {
            final String llllllllllllllIlIIllllIIIllIlIIl = ErrorCode.getString(llllllllllllllIlIIllllIIIllIlIlI);
            this.func_152820_d(String.format("Error in SendStopSpanMetaData: %s\n", llllllllllllllIlIIllllIIIllIlIIl));
            return false;
        }
        return true;
    }
    
    public FrameBuffer func_152822_N() {
        if (this.field_152875_k.size() == 0) {
            this.func_152820_d(String.format("Out of free buffers, this should never happen", new Object[0]));
            return null;
        }
        final FrameBuffer llllllllllllllIlIIllllIIIIlIIlII = this.field_152875_k.get(this.field_152875_k.size() - 1);
        this.field_152875_k.remove(this.field_152875_k.size() - 1);
        return llllllllllllllIlIIllllIIIIlIIlII;
    }
    
    public void statCallback() {
        if (this.broadcastState != BroadcastState.Uninitialized) {
            if (this.field_152860_A != null) {
                this.field_152860_A.func_153039_l();
            }
            while (this.field_152860_A != null) {
                try {
                    Thread.sleep(200L);
                }
                catch (Exception llllllllllllllIlIIllllIIllllllll) {
                    this.func_152820_d(llllllllllllllIlIIllllIIllllllll.toString());
                }
                this.func_152821_H();
            }
            this.func_152851_B();
        }
    }
    
    static {
        __OBFID = "CL_00001822";
        logger = LogManager.getLogger();
        field_152862_C = new ThreadSafeBoundList(String.class, 50);
    }
    
    public boolean func_152830_D() {
        if (!this.isBroadcasting()) {
            return false;
        }
        final ErrorCode llllllllllllllIlIIllllIIllIllIII = this.field_152873_i.runCommercial(this.field_152885_u);
        this.func_152853_a(llllllllllllllIlIIllllIIllIllIII);
        return ErrorCode.succeeded(llllllllllllllIlIIllllIIllIllIII);
    }
    
    public boolean func_152818_a(final String llllllllllllllIlIIllllIIlllllIII, final AuthToken llllllllllllllIlIIllllIIllllIlII) {
        if (this.isIngestTesting()) {
            return false;
        }
        this.func_152845_C();
        if (llllllllllllllIlIIllllIIlllllIII == null || llllllllllllllIlIIllllIIlllllIII.isEmpty()) {
            this.func_152820_d("Username must be valid");
            return false;
        }
        if (llllllllllllllIlIIllllIIllllIlII != null && llllllllllllllIlIIllllIIllllIlII.data != null && !llllllllllllllIlIIllllIIllllIlII.data.isEmpty()) {
            this.field_152880_p = llllllllllllllIlIIllllIIlllllIII;
            this.field_152885_u = llllllllllllllIlIIllllIIllllIlII;
            if (this.func_152858_b()) {
                this.func_152827_a(BroadcastState.Authenticated);
            }
            return true;
        }
        this.func_152820_d("Auth token must be valid");
        return false;
    }
    
    protected void func_152831_M() {
        for (int llllllllllllllIlIIllllIIIIlIllII = 0; llllllllllllllIlIIllllIIIIlIllII < this.field_152874_j.size(); ++llllllllllllllIlIIllllIIIIlIllII) {
            final FrameBuffer llllllllllllllIlIIllllIIIIlIlIll = this.field_152874_j.get(llllllllllllllIlIIllllIIIIlIllII);
            llllllllllllllIlIIllllIIIIlIlIll.free();
        }
        this.field_152875_k.clear();
        this.field_152874_j.clear();
    }
    
    public boolean func_152836_a(final VideoParams llllllllllllllIlIIllllIIlIllIlll) {
        if (llllllllllllllIlIIllllIIlIllIlll == null || !this.func_152857_n()) {
            return false;
        }
        this.field_152881_q = llllllllllllllIlIIllllIIlIllIlll.clone();
        this.field_152882_r = new AudioParams();
        this.field_152882_r.audioEnabled = (this.field_152871_g && this.func_152848_y());
        this.field_152882_r.enableMicCapture = this.field_152882_r.audioEnabled;
        this.field_152882_r.enablePlaybackCapture = this.field_152882_r.audioEnabled;
        this.field_152882_r.enablePassthroughAudio = false;
        if (!this.func_152823_L()) {
            this.field_152881_q = null;
            this.field_152882_r = null;
            return false;
        }
        final ErrorCode llllllllllllllIlIIllllIIlIlllIlI = this.field_152873_i.start(llllllllllllllIlIIllllIIlIllIlll, this.field_152882_r, this.field_152884_t, StartFlags.None, true);
        if (ErrorCode.failed(llllllllllllllIlIIllllIIlIlllIlI)) {
            this.func_152831_M();
            final String llllllllllllllIlIIllllIIlIlllIIl = ErrorCode.getString(llllllllllllllIlIIllllIIlIlllIlI);
            this.func_152820_d(String.format("Error while starting to broadcast: %s", llllllllllllllIlIIllllIIlIlllIIl));
            this.field_152881_q = null;
            this.field_152882_r = null;
            return false;
        }
        this.func_152827_a(BroadcastState.Starting);
        return true;
    }
    
    static final class SwitchBroadcastState
    {
        static final /* synthetic */ int[] field_177773_a;
        
        static {
            __OBFID = "CL_00001821";
            field_177773_a = new int[BroadcastState.values().length];
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.Authenticated.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.LoggedIn.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.ReceivedIngestServers.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.Starting.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.Stopping.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.FindingIngestServer.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.Authenticating.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.Initialized.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.Uninitialized.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.IngestTesting.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.Paused.ordinal()] = 11;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
            try {
                SwitchBroadcastState.field_177773_a[BroadcastState.Broadcasting.ordinal()] = 12;
            }
            catch (NoSuchFieldError noSuchFieldError12) {}
        }
    }
    
    public enum BroadcastState
    {
        Broadcasting("Broadcasting", 10, "Broadcasting", 10), 
        LoggingIn("LoggingIn", 4, "LoggingIn", 4), 
        ReceivedIngestServers("ReceivedIngestServers", 7, "ReceivedIngestServers", 7), 
        Initialized("Initialized", 1, "Initialized", 1), 
        Paused("Paused", 12, "Paused", 12), 
        Authenticating("Authenticating", 2, "Authenticating", 2), 
        IngestTesting("IngestTesting", 13, "IngestTesting", 13), 
        Uninitialized("Uninitialized", 0, "Uninitialized", 0), 
        Authenticated("Authenticated", 3, "Authenticated", 3), 
        Starting("Starting", 9, "Starting", 9), 
        Stopping("Stopping", 11, "Stopping", 11), 
        ReadyToBroadcast("ReadyToBroadcast", 8, "ReadyToBroadcast", 8), 
        LoggedIn("LoggedIn", 5, "LoggedIn", 5), 
        FindingIngestServer("FindingIngestServer", 6, "FindingIngestServer", 6);
        
        static {
            __OBFID = "CL_00001820";
        }
        
        private BroadcastState(final String lllllllllllllllllIlIlIIIlIlIllIl, final int lllllllllllllllllIlIlIIIlIlIllII, final String lllllllllllllllllIlIlIIIlIllIIII, final int lllllllllllllllllIlIlIIIlIlIllll) {
        }
    }
    
    public interface BroadcastListener
    {
        void func_152899_b();
        
        void func_152898_a(final ErrorCode p0, final GameInfo[] p1);
        
        void func_152900_a(final ErrorCode p0, final AuthToken p1);
        
        void func_152891_a(final BroadcastState p0);
        
        void func_152893_b(final ErrorCode p0);
        
        void func_152896_a(final IngestList p0);
        
        void func_152895_a();
        
        void func_152894_a(final StreamInfo p0);
        
        void func_152901_c();
        
        void func_152892_c(final ErrorCode p0);
        
        void func_152897_a(final ErrorCode p0);
    }
}
