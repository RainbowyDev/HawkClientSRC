package net.minecraft.client.stream;

import java.util.*;
import tv.twitch.*;
import com.google.common.collect.*;
import tv.twitch.broadcast.*;

public class IngestServerTester
{
    protected /* synthetic */ IngestList field_153046_d;
    protected /* synthetic */ IStatCallbacks field_176006_B;
    protected /* synthetic */ boolean field_153061_s;
    protected /* synthetic */ int field_153062_t;
    protected /* synthetic */ VideoParams field_153052_j;
    protected /* synthetic */ boolean field_153056_n;
    protected /* synthetic */ List field_153055_m;
    protected /* synthetic */ int field_153063_u;
    protected /* synthetic */ boolean field_176009_x;
    protected /* synthetic */ long field_153049_g;
    protected /* synthetic */ float field_153065_w;
    protected /* synthetic */ boolean field_153060_r;
    protected /* synthetic */ IngestTestState field_153047_e;
    protected /* synthetic */ IStreamCallbacks field_176005_A;
    protected /* synthetic */ float field_153066_x;
    protected /* synthetic */ Stream field_153045_c;
    protected /* synthetic */ RTMPState field_153051_i;
    protected /* synthetic */ long field_153064_v;
    protected /* synthetic */ boolean field_176008_y;
    protected /* synthetic */ long field_153048_f;
    protected /* synthetic */ AudioParams field_153053_k;
    protected /* synthetic */ IStatCallbacks field_153058_p;
    protected /* synthetic */ IngestTestListener field_153044_b;
    protected /* synthetic */ long field_153050_h;
    protected /* synthetic */ long field_153054_l;
    protected /* synthetic */ IngestServer field_153059_q;
    protected /* synthetic */ IStreamCallbacks field_153057_o;
    protected /* synthetic */ boolean field_176007_z;
    
    protected void func_153031_o() {
        this.field_153059_q = null;
        if (this.field_153055_m != null) {
            for (int lllllllllllllllIlIIIIlIIIIIlllll = 0; lllllllllllllllIlIIIIlIIIIIlllll < this.field_153055_m.size(); ++lllllllllllllllIlIIIIlIIIIIlllll) {
                this.field_153055_m.get(lllllllllllllllIlIIIIlIIIIIlllll).free();
            }
            this.field_153055_m = null;
        }
        if (this.field_153045_c.getStatCallbacks() == this.field_176006_B) {
            this.field_153045_c.setStatCallbacks(this.field_153058_p);
            this.field_153058_p = null;
        }
        if (this.field_153045_c.getStreamCallbacks() == this.field_176005_A) {
            this.field_153045_c.setStreamCallbacks(this.field_153057_o);
            this.field_153057_o = null;
        }
    }
    
    public IngestServer func_153040_c() {
        return this.field_153059_q;
    }
    
    public void func_153039_l() {
        if (!this.func_153032_e() && !this.field_153060_r) {
            this.field_153060_r = true;
            if (this.field_153059_q != null) {
                this.field_153059_q.bitrateKbps = 0.0f;
            }
        }
    }
    
    protected void func_153038_n() {
        final float lllllllllllllllIlIIIIlIIIIllIIIl = (float)this.func_153037_m();
        switch (SwitchStatType.field_176002_b[this.field_153047_e.ordinal()]) {
            case 1:
            case 3:
            case 6:
            case 7:
            case 8:
            case 9: {
                this.field_153066_x = 0.0f;
                break;
            }
            case 2: {
                this.field_153066_x = 1.0f;
                break;
            }
            default: {
                this.field_153066_x = lllllllllllllllIlIIIIlIIIIllIIIl / this.field_153048_f;
                break;
            }
        }
        switch (SwitchStatType.field_176002_b[this.field_153047_e.ordinal()]) {
            case 7:
            case 8:
            case 9: {
                this.field_153065_w = 1.0f;
                break;
            }
            default: {
                this.field_153065_w = this.field_153062_t / (float)this.field_153046_d.getServers().length;
                this.field_153065_w += this.field_153066_x / this.field_153046_d.getServers().length;
                break;
            }
        }
    }
    
    protected void func_153035_b(final IngestServer lllllllllllllllIlIIIIlIIIIlllIll) {
        if (this.field_176008_y) {
            this.field_153061_s = true;
        }
        else if (this.field_176009_x) {
            this.field_176007_z = true;
            final ErrorCode lllllllllllllllIlIIIIlIIIIlllIlI = this.field_153045_c.stop(true);
            if (ErrorCode.failed(lllllllllllllllIlIIIIlIIIIlllIlI)) {
                this.field_176005_A.stopCallback(ErrorCode.TTV_EC_SUCCESS);
                System.out.println(String.valueOf(new StringBuilder("Stop failed: ").append(lllllllllllllllIlIIIIlIIIIlllIlI.toString())));
            }
            this.field_153045_c.pollStats();
        }
        else {
            this.field_176005_A.stopCallback(ErrorCode.TTV_EC_SUCCESS);
        }
    }
    
    protected void func_153034_a(final IngestTestState lllllllllllllllIlIIIIlIIIIIlIlll) {
        if (lllllllllllllllIlIIIIlIIIIIlIlll != this.field_153047_e) {
            this.field_153047_e = lllllllllllllllIlIIIIlIIIIIlIlll;
            if (this.field_153044_b != null) {
                this.field_153044_b.func_152907_a(this, lllllllllllllllIlIIIIlIIIIIlIlll);
            }
        }
    }
    
    public boolean func_153032_e() {
        return this.field_153047_e == IngestTestState.Finished || this.field_153047_e == IngestTestState.Cancelled || this.field_153047_e == IngestTestState.Failed;
    }
    
    public int func_153028_p() {
        return this.field_153062_t;
    }
    
    public IngestServerTester(final Stream lllllllllllllllIlIIIIlIIIlIllIll, final IngestList lllllllllllllllIlIIIIlIIIlIlllIl) {
        this.field_153044_b = null;
        this.field_153045_c = null;
        this.field_153046_d = null;
        this.field_153047_e = IngestTestState.Uninitalized;
        this.field_153048_f = 8000L;
        this.field_153049_g = 2000L;
        this.field_153050_h = 0L;
        this.field_153051_i = RTMPState.Invalid;
        this.field_153052_j = null;
        this.field_153053_k = null;
        this.field_153054_l = 0L;
        this.field_153055_m = null;
        this.field_153056_n = false;
        this.field_153057_o = null;
        this.field_153058_p = null;
        this.field_153059_q = null;
        this.field_153060_r = false;
        this.field_153061_s = false;
        this.field_153062_t = -1;
        this.field_153063_u = 0;
        this.field_153064_v = 0L;
        this.field_153065_w = 0.0f;
        this.field_153066_x = 0.0f;
        this.field_176009_x = false;
        this.field_176008_y = false;
        this.field_176007_z = false;
        this.field_176005_A = (IStreamCallbacks)new IStreamCallbacks() {
            public void startCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIIIllI) {
                IngestServerTester.this.field_176008_y = false;
                if (ErrorCode.succeeded(llllllllllllllIIIlIlIlIIlIIIIllI)) {
                    IngestServerTester.this.field_176009_x = true;
                    IngestServerTester.this.field_153054_l = System.currentTimeMillis();
                    IngestServerTester.this.func_153034_a(IngestTestState.ConnectingToServer);
                }
                else {
                    IngestServerTester.this.field_153056_n = false;
                    IngestServerTester.this.func_153034_a(IngestTestState.DoneTestingServer);
                }
            }
            
            static {
                __OBFID = "CL_00002368";
            }
            
            public void getStreamInfoCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIllIIl, final StreamInfo llllllllllllllIIIlIlIlIIlIIllIII) {
            }
            
            public void setStreamInfoCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIlIIIl) {
            }
            
            public void bufferUnlockCallback(final long llllllllllllllIIIlIlIlIIlIIIllII) {
            }
            
            public void getIngestServersCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIlllll, final IngestList llllllllllllllIIIlIlIlIIlIIllllI) {
            }
            
            public void getArchivingStateCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIlIllI, final ArchivingState llllllllllllllIIIlIlIlIIlIIlIlIl) {
            }
            
            public void requestAuthTokenCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIlIIlIl, final AuthToken llllllllllllllIIIlIlIlIIlIlIIlII) {
            }
            
            public void loginCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIlIIIlI, final ChannelInfo llllllllllllllIIIlIlIlIIlIlIIIIl) {
            }
            
            public void sendActionMetaDataCallback(final ErrorCode llllllllllllllIIIlIlIlIIIllllllI) {
            }
            
            public void getUserInfoCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIlllII, final UserInfo llllllllllllllIIIlIlIlIIlIIllIll) {
            }
            
            public void stopCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIIIIII) {
                if (ErrorCode.failed(llllllllllllllIIIlIlIlIIlIIIIIII)) {
                    System.out.println(String.valueOf(new StringBuilder("IngestTester.stopCallback failed to stop - ").append(IngestServerTester.this.field_153059_q.serverName).append(": ").append(llllllllllllllIIIlIlIlIIlIIIIIII.toString())));
                }
                IngestServerTester.this.field_176007_z = false;
                IngestServerTester.this.field_176009_x = false;
                IngestServerTester.this.func_153034_a(IngestTestState.DoneTestingServer);
                IngestServerTester.this.field_153059_q = null;
                if (IngestServerTester.this.field_153060_r) {
                    IngestServerTester.this.func_153034_a(IngestTestState.Cancelling);
                }
            }
            
            public void sendEndSpanMetaDataCallback(final ErrorCode llllllllllllllIIIlIlIlIIIllllIlI) {
            }
            
            public void runCommercialCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIlIIll) {
            }
            
            public void getGameNameListCallback(final ErrorCode llllllllllllllIIIlIlIlIIlIIIllll, final GameInfoList llllllllllllllIIIlIlIlIIlIIIlllI) {
            }
            
            public void sendStartSpanMetaDataCallback(final ErrorCode llllllllllllllIIIlIlIlIIIlllllII) {
            }
        };
        this.field_176006_B = (IStatCallbacks)new IStatCallbacks() {
            public void statCallback(final StatType llllllllllllllIIIlIlIIIIIIlllIlI, final long llllllllllllllIIIlIlIIIIIIllllII) {
                switch (SwitchStatType.field_176003_a[llllllllllllllIIIlIlIIIIIIlllIlI.ordinal()]) {
                    case 1: {
                        IngestServerTester.this.field_153051_i = RTMPState.lookupValue((int)llllllllllllllIIIlIlIIIIIIllllII);
                        break;
                    }
                    case 2: {
                        IngestServerTester.this.field_153050_h = llllllllllllllIIIlIlIIIIIIllllII;
                        break;
                    }
                }
            }
            
            static {
                __OBFID = "CL_00002367";
            }
        };
        this.field_153045_c = lllllllllllllllIlIIIIlIIIlIllIll;
        this.field_153046_d = lllllllllllllllIlIIIIlIIIlIlllIl;
    }
    
    public void func_176004_j() {
        if (this.field_153047_e == IngestTestState.Uninitalized) {
            this.field_153062_t = 0;
            this.field_153060_r = false;
            this.field_153061_s = false;
            this.field_176009_x = false;
            this.field_176008_y = false;
            this.field_176007_z = false;
            this.field_153058_p = this.field_153045_c.getStatCallbacks();
            this.field_153045_c.setStatCallbacks(this.field_176006_B);
            this.field_153057_o = this.field_153045_c.getStreamCallbacks();
            this.field_153045_c.setStreamCallbacks(this.field_176005_A);
            this.field_153052_j = new VideoParams();
            this.field_153052_j.targetFps = 60;
            this.field_153052_j.maxKbps = 3500;
            this.field_153052_j.outputWidth = 1280;
            this.field_153052_j.outputHeight = 720;
            this.field_153052_j.pixelFormat = PixelFormat.TTV_PF_BGRA;
            this.field_153052_j.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
            this.field_153052_j.disableAdaptiveBitrate = true;
            this.field_153052_j.verticalFlip = false;
            this.field_153045_c.getDefaultParams(this.field_153052_j);
            this.field_153053_k = new AudioParams();
            this.field_153053_k.audioEnabled = false;
            this.field_153053_k.enableMicCapture = false;
            this.field_153053_k.enablePlaybackCapture = false;
            this.field_153053_k.enablePassthroughAudio = false;
            this.field_153055_m = Lists.newArrayList();
            final byte lllllllllllllllIlIIIIlIIIlIlIlII = 3;
            for (int lllllllllllllllIlIIIIlIIIlIlIIll = 0; lllllllllllllllIlIIIIlIIIlIlIIll < lllllllllllllllIlIIIIlIIIlIlIlII; ++lllllllllllllllIlIIIIlIIIlIlIIll) {
                final FrameBuffer lllllllllllllllIlIIIIlIIIlIlIIlI = this.field_153045_c.allocateFrameBuffer(this.field_153052_j.outputWidth * this.field_153052_j.outputHeight * 4);
                if (!lllllllllllllllIlIIIIlIIIlIlIIlI.getIsValid()) {
                    this.func_153031_o();
                    this.func_153034_a(IngestTestState.Failed);
                    return;
                }
                this.field_153055_m.add(lllllllllllllllIlIIIIlIIIlIlIIlI);
                this.field_153045_c.randomizeFrameBuffer(lllllllllllllllIlIIIIlIIIlIlIIlI);
            }
            this.func_153034_a(IngestTestState.Starting);
            this.field_153054_l = System.currentTimeMillis();
        }
    }
    
    protected boolean func_153036_a(final IngestServer lllllllllllllllIlIIIIlIIIlIIIIll) {
        this.field_153056_n = true;
        this.field_153050_h = 0L;
        this.field_153051_i = RTMPState.Idle;
        this.field_153059_q = lllllllllllllllIlIIIIlIIIlIIIIll;
        this.field_176008_y = true;
        this.func_153034_a(IngestTestState.ConnectingToServer);
        final ErrorCode lllllllllllllllIlIIIIlIIIlIIIIlI = this.field_153045_c.start(this.field_153052_j, this.field_153053_k, lllllllllllllllIlIIIIlIIIlIIIIll, StartFlags.TTV_Start_BandwidthTest, true);
        if (ErrorCode.failed(lllllllllllllllIlIIIIlIIIlIIIIlI)) {
            this.field_176008_y = false;
            this.field_153056_n = false;
            this.func_153034_a(IngestTestState.DoneTestingServer);
            return false;
        }
        this.field_153064_v = this.field_153050_h;
        lllllllllllllllIlIIIIlIIIlIIIIll.bitrateKbps = 0.0f;
        this.field_153063_u = 0;
        return true;
    }
    
    protected boolean func_153029_c(final IngestServer lllllllllllllllIlIIIIlIIIIlIlIIl) {
        if (this.field_153061_s || this.field_153060_r || this.func_153037_m() >= this.field_153048_f) {
            this.func_153034_a(IngestTestState.DoneTestingServer);
            return true;
        }
        if (this.field_176008_y || this.field_176007_z) {
            return true;
        }
        final ErrorCode lllllllllllllllIlIIIIlIIIIlIlIII = this.field_153045_c.submitVideoFrame((FrameBuffer)this.field_153055_m.get(this.field_153063_u));
        if (ErrorCode.failed(lllllllllllllllIlIIIIlIIIIlIlIII)) {
            this.field_153056_n = false;
            this.func_153034_a(IngestTestState.DoneTestingServer);
            return false;
        }
        this.field_153063_u = (this.field_153063_u + 1) % this.field_153055_m.size();
        this.field_153045_c.pollStats();
        if (this.field_153051_i == RTMPState.SendVideo) {
            this.func_153034_a(IngestTestState.TestingServer);
            final long lllllllllllllllIlIIIIlIIIIlIIlll = this.func_153037_m();
            if (lllllllllllllllIlIIIIlIIIIlIIlll > 0L && this.field_153050_h > this.field_153064_v) {
                lllllllllllllllIlIIIIlIIIIlIlIIl.bitrateKbps = this.field_153050_h * 8L / (float)this.func_153037_m();
                this.field_153064_v = this.field_153050_h;
            }
        }
        return true;
    }
    
    protected long func_153037_m() {
        return System.currentTimeMillis() - this.field_153054_l;
    }
    
    static {
        __OBFID = "CL_00001816";
    }
    
    public float func_153030_h() {
        return this.field_153066_x;
    }
    
    public void func_153041_j() {
        if (!this.func_153032_e() && this.field_153047_e != IngestTestState.Uninitalized && !this.field_176008_y && !this.field_176007_z) {
            switch (SwitchStatType.field_176002_b[this.field_153047_e.ordinal()]) {
                case 1:
                case 2: {
                    if (this.field_153059_q != null) {
                        if (this.field_153061_s || !this.field_153056_n) {
                            this.field_153059_q.bitrateKbps = 0.0f;
                        }
                        this.func_153035_b(this.field_153059_q);
                        break;
                    }
                    this.field_153054_l = 0L;
                    this.field_153061_s = false;
                    this.field_153056_n = true;
                    if (this.field_153047_e != IngestTestState.Starting) {
                        ++this.field_153062_t;
                    }
                    if (this.field_153062_t < this.field_153046_d.getServers().length) {
                        this.field_153059_q = this.field_153046_d.getServers()[this.field_153062_t];
                        this.func_153036_a(this.field_153059_q);
                        break;
                    }
                    this.func_153034_a(IngestTestState.Finished);
                    break;
                }
                case 3:
                case 4: {
                    this.func_153029_c(this.field_153059_q);
                    break;
                }
                case 5: {
                    this.func_153034_a(IngestTestState.Cancelled);
                    break;
                }
            }
            this.func_153038_n();
            if (this.field_153047_e == IngestTestState.Cancelled || this.field_153047_e == IngestTestState.Finished) {
                this.func_153031_o();
            }
        }
    }
    
    public void func_153042_a(final IngestTestListener lllllllllllllllIlIIIIlIIIlllIIIl) {
        this.field_153044_b = lllllllllllllllIlIIIIlIIIlllIIIl;
    }
    
    public enum IngestTestState
    {
        ConnectingToServer("ConnectingToServer", 2, "ConnectingToServer", 2), 
        Starting("Starting", 1, "Starting", 1), 
        Cancelling("Cancelling", 6, "Cancelling", 6), 
        Finished("Finished", 5, "Finished", 5), 
        Failed("Failed", 8, "Failed", 8), 
        DoneTestingServer("DoneTestingServer", 4, "DoneTestingServer", 4), 
        Uninitalized("Uninitalized", 0, "Uninitalized", 0), 
        Cancelled("Cancelled", 7, "Cancelled", 7), 
        TestingServer("TestingServer", 3, "TestingServer", 3);
        
        private IngestTestState(final String llllllllllllllIlIlIIllIllllllIIl, final int llllllllllllllIlIlIIllIllllllIII, final String llllllllllllllIlIlIIllIlllllllII, final int llllllllllllllIlIlIIllIllllllIll) {
        }
        
        static {
            __OBFID = "CL_00001814";
        }
    }
    
    static final class SwitchStatType
    {
        static final /* synthetic */ int[] field_176002_b;
        static final /* synthetic */ int[] field_176003_a;
        
        static {
            __OBFID = "CL_00001815";
            field_176002_b = new int[IngestTestState.values().length];
            try {
                SwitchStatType.field_176002_b[IngestTestState.Starting.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchStatType.field_176002_b[IngestTestState.DoneTestingServer.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchStatType.field_176002_b[IngestTestState.ConnectingToServer.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchStatType.field_176002_b[IngestTestState.TestingServer.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchStatType.field_176002_b[IngestTestState.Cancelling.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchStatType.field_176002_b[IngestTestState.Uninitalized.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchStatType.field_176002_b[IngestTestState.Finished.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchStatType.field_176002_b[IngestTestState.Cancelled.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchStatType.field_176002_b[IngestTestState.Failed.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            field_176003_a = new int[StatType.values().length];
            try {
                SwitchStatType.field_176003_a[StatType.TTV_ST_RTMPSTATE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            try {
                SwitchStatType.field_176003_a[StatType.TTV_ST_RTMPDATASENT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
        }
    }
    
    public interface IngestTestListener
    {
        void func_152907_a(final IngestServerTester p0, final IngestTestState p1);
    }
}
