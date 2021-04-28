package net.minecraft.client.stream;

import tv.twitch.*;
import org.apache.logging.log4j.*;
import java.util.*;
import com.google.common.collect.*;
import tv.twitch.chat.*;

public class ChatController
{
    protected /* synthetic */ IChatAPIListener field_175999_p;
    protected /* synthetic */ Core field_175992_e;
    protected /* synthetic */ AuthToken field_153012_j;
    protected /* synthetic */ ChatState field_153011_i;
    protected /* synthetic */ int field_175994_o;
    private static final /* synthetic */ Logger LOGGER;
    protected /* synthetic */ EnumEmoticonMode field_175995_l;
    protected /* synthetic */ String field_153007_e;
    protected /* synthetic */ String field_153004_b;
    protected /* synthetic */ HashMap field_175998_i;
    protected /* synthetic */ Chat field_153008_f;
    protected /* synthetic */ int field_175993_n;
    protected /* synthetic */ ChatEmoticonData field_175996_m;
    protected /* synthetic */ String field_153006_d;
    protected /* synthetic */ EnumEmoticonMode field_175997_k;
    protected /* synthetic */ ChatListener field_153003_a;
    protected /* synthetic */ int field_153015_m;
    
    protected boolean func_175987_a(final String llllllllllllllllllIlIIIIIllIIIII, final boolean llllllllllllllllllIlIIIIIlIlllll) {
        if (this.field_153011_i != ChatState.Initialized) {
            return false;
        }
        if (this.field_175998_i.containsKey(llllllllllllllllllIlIIIIIllIIIII)) {
            this.func_152995_h(String.valueOf(new StringBuilder("Already in channel: ").append(llllllllllllllllllIlIIIIIllIIIII)));
            return false;
        }
        if (llllllllllllllllllIlIIIIIllIIIII != null && !llllllllllllllllllIlIIIIIllIIIII.equals("")) {
            final ChatChannelListener llllllllllllllllllIlIIIIIllIIIll = new ChatChannelListener(llllllllllllllllllIlIIIIIllIIIII);
            this.field_175998_i.put(llllllllllllllllllIlIIIIIllIIIII, llllllllllllllllllIlIIIIIllIIIll);
            final boolean llllllllllllllllllIlIIIIIllIIIlI = llllllllllllllllllIlIIIIIllIIIll.func_176038_a(llllllllllllllllllIlIIIIIlIlllll);
            if (!llllllllllllllllllIlIIIIIllIIIlI) {
                this.field_175998_i.remove(llllllllllllllllllIlIIIIIllIIIII);
            }
            return llllllllllllllllllIlIIIIIllIIIlI;
        }
        return false;
    }
    
    public ChatController() {
        this.field_153003_a = null;
        this.field_153004_b = "";
        this.field_153006_d = "";
        this.field_153007_e = "";
        this.field_175992_e = null;
        this.field_153008_f = null;
        this.field_153011_i = ChatState.Uninitialized;
        this.field_153012_j = new AuthToken();
        this.field_175998_i = new HashMap();
        this.field_153015_m = 128;
        this.field_175997_k = EnumEmoticonMode.None;
        this.field_175995_l = EnumEmoticonMode.None;
        this.field_175996_m = null;
        this.field_175993_n = 500;
        this.field_175994_o = 2000;
        this.field_175999_p = (IChatAPIListener)new IChatAPIListener() {
            public void chatEmoticonDataDownloadCallback(final ErrorCode llllllllllllllIIllllllllIlllllIl) {
                if (ErrorCode.succeeded(llllllllllllllIIllllllllIlllllIl)) {
                    ChatController.this.func_152988_s();
                }
            }
            
            public void chatShutdownCallback(final ErrorCode llllllllllllllIIlllllllllIIIIIll) {
                if (ErrorCode.succeeded(llllllllllllllIIlllllllllIIIIIll)) {
                    final ErrorCode llllllllllllllIIlllllllllIIIIlll = ChatController.this.field_175992_e.shutdown();
                    if (ErrorCode.failed(llllllllllllllIIlllllllllIIIIlll)) {
                        final String llllllllllllllIIlllllllllIIIIllI = ErrorCode.getString(llllllllllllllIIlllllllllIIIIlll);
                        ChatController.this.func_152995_h(String.format("Error shutting down the Twitch sdk: %s", llllllllllllllIIlllllllllIIIIllI));
                    }
                    ChatController.this.func_175985_a(ChatState.Uninitialized);
                }
                else {
                    ChatController.this.func_175985_a(ChatState.Initialized);
                    ChatController.this.func_152995_h(String.format("Error shutting down Twith chat: %s", llllllllllllllIIlllllllllIIIIIll));
                }
                try {
                    if (ChatController.this.field_153003_a != null) {
                        ChatController.this.field_153003_a.func_176022_e(llllllllllllllIIlllllllllIIIIIll);
                    }
                }
                catch (Exception llllllllllllllIIlllllllllIIIIlIl) {
                    ChatController.this.func_152995_h(llllllllllllllIIlllllllllIIIIlIl.toString());
                }
            }
            
            public void chatInitializationCallback(final ErrorCode llllllllllllllIIlllllllllIIIllll) {
                if (ErrorCode.succeeded(llllllllllllllIIlllllllllIIIllll)) {
                    ChatController.this.field_153008_f.setMessageFlushInterval(ChatController.this.field_175993_n);
                    ChatController.this.field_153008_f.setUserChangeEventInterval(ChatController.this.field_175994_o);
                    ChatController.this.func_153001_r();
                    ChatController.this.func_175985_a(ChatState.Initialized);
                }
                else {
                    ChatController.this.func_175985_a(ChatState.Uninitialized);
                }
                try {
                    if (ChatController.this.field_153003_a != null) {
                        ChatController.this.field_153003_a.func_176023_d(llllllllllllllIIlllllllllIIIllll);
                    }
                }
                catch (Exception llllllllllllllIIlllllllllIIlIIIl) {
                    ChatController.this.func_152995_h(llllllllllllllIIlllllllllIIlIIIl.toString());
                }
            }
            
            static {
                __OBFID = "CL_00002373";
            }
        };
        this.field_175992_e = Core.getInstance();
        if (this.field_175992_e == null) {
            this.field_175992_e = new Core((CoreAPI)new StandardCoreAPI());
        }
        this.field_153008_f = new Chat((ChatAPI)new StandardChatAPI());
    }
    
    protected void func_175985_a(final ChatState llllllllllllllllllIlIIIIIIlIllII) {
        if (llllllllllllllllllIlIIIIIIlIllII != this.field_153011_i) {
            this.field_153011_i = llllllllllllllllllIlIIIIIIlIllII;
            try {
                if (this.field_153003_a != null) {
                    this.field_153003_a.func_176017_a(llllllllllllllllllIlIIIIIIlIllII);
                }
            }
            catch (Exception llllllllllllllllllIlIIIIIIlIlIll) {
                this.func_152995_h(llllllllllllllllllIlIIIIIIlIlIll.toString());
            }
        }
    }
    
    public void func_152994_a(final AuthToken llllllllllllllllllIlIIIIlIlIIlIl) {
        this.field_153012_j = llllllllllllllllllIlIIIIlIlIIlIl;
    }
    
    public void func_175988_p() {
        if (this.func_153000_j() != ChatState.Uninitialized) {
            this.func_152993_m();
            if (this.func_153000_j() == ChatState.ShuttingDown) {
                while (this.func_153000_j() != ChatState.Uninitialized) {
                    try {
                        Thread.sleep(200L);
                        this.func_152997_n();
                    }
                    catch (InterruptedException ex) {}
                }
            }
        }
    }
    
    public boolean func_175986_a(final String llllllllllllllllllIlIIIIIIllIIll, final String llllllllllllllllllIlIIIIIIllIllI) {
        if (this.field_153011_i != ChatState.Initialized) {
            return false;
        }
        if (!this.field_175998_i.containsKey(llllllllllllllllllIlIIIIIIllIIll)) {
            this.func_152995_h(String.valueOf(new StringBuilder("Not in channel: ").append(llllllllllllllllllIlIIIIIIllIIll)));
            return false;
        }
        final ChatChannelListener llllllllllllllllllIlIIIIIIllIlIl = this.field_175998_i.get(llllllllllllllllllIlIIIIIIllIIll);
        return llllllllllllllllllIlIIIIIIllIlIl.func_176037_b(llllllllllllllllllIlIIIIIIllIllI);
    }
    
    protected void func_152988_s() {
        if (this.field_175996_m == null) {
            this.field_175996_m = new ChatEmoticonData();
            final ErrorCode llllllllllllllllllIlIIIIIIIllIlI = this.field_153008_f.getEmoticonData(this.field_175996_m);
            if (ErrorCode.succeeded(llllllllllllllllllIlIIIIIIIllIlI)) {
                try {
                    if (this.field_153003_a != null) {
                        this.field_153003_a.func_176021_d();
                    }
                }
                catch (Exception llllllllllllllllllIlIIIIIIIllIIl) {
                    this.func_152995_h(llllllllllllllllllIlIIIIIIIllIIl.toString());
                }
            }
            else {
                this.func_152995_h(String.valueOf(new StringBuilder("Error preparing emoticon data: ").append(ErrorCode.getString(llllllllllllllllllIlIIIIIIIllIlI))));
            }
        }
    }
    
    public boolean func_175984_n() {
        if (this.field_153011_i != ChatState.Uninitialized) {
            return false;
        }
        this.func_175985_a(ChatState.Initializing);
        ErrorCode llllllllllllllllllIlIIIIIllllIIl = this.field_175992_e.initialize(this.field_153006_d, (String)null);
        if (ErrorCode.failed(llllllllllllllllllIlIIIIIllllIIl)) {
            this.func_175985_a(ChatState.Uninitialized);
            final String llllllllllllllllllIlIIIIIllllIII = ErrorCode.getString(llllllllllllllllllIlIIIIIllllIIl);
            this.func_152995_h(String.format("Error initializing Twitch sdk: %s", llllllllllllllllllIlIIIIIllllIII));
            return false;
        }
        this.field_175995_l = this.field_175997_k;
        final HashSet llllllllllllllllllIlIIIIIlllIlll = new HashSet();
        switch (SwitchEnumEmoticonMode.field_175975_c[this.field_175997_k.ordinal()]) {
            case 1: {
                llllllllllllllllllIlIIIIIlllIlll.add(ChatTokenizationOption.TTV_CHAT_TOKENIZATION_OPTION_NONE);
                break;
            }
            case 2: {
                llllllllllllllllllIlIIIIIlllIlll.add(ChatTokenizationOption.TTV_CHAT_TOKENIZATION_OPTION_EMOTICON_URLS);
                break;
            }
            case 3: {
                llllllllllllllllllIlIIIIIlllIlll.add(ChatTokenizationOption.TTV_CHAT_TOKENIZATION_OPTION_EMOTICON_TEXTURES);
                break;
            }
        }
        llllllllllllllllllIlIIIIIllllIIl = this.field_153008_f.initialize(llllllllllllllllllIlIIIIIlllIlll, this.field_175999_p);
        if (ErrorCode.failed(llllllllllllllllllIlIIIIIllllIIl)) {
            this.field_175992_e.shutdown();
            this.func_175985_a(ChatState.Uninitialized);
            final String llllllllllllllllllIlIIIIIlllIllI = ErrorCode.getString(llllllllllllllllllIlIIIIIllllIIl);
            this.func_152995_h(String.format("Error initializing Twitch chat: %s", llllllllllllllllllIlIIIIIlllIllI));
            return false;
        }
        this.func_175985_a(ChatState.Initialized);
        return true;
    }
    
    public EnumChannelState func_175989_e(final String llllllllllllllllllIlIIIIlIIIIllI) {
        if (!this.field_175998_i.containsKey(llllllllllllllllllIlIIIIlIIIIllI)) {
            return EnumChannelState.Disconnected;
        }
        final ChatChannelListener llllllllllllllllllIlIIIIlIIIIlIl = this.field_175998_i.get(llllllllllllllllllIlIIIIlIIIIllI);
        return llllllllllllllllllIlIIIIlIIIIlIl.func_176040_a();
    }
    
    public boolean func_175990_d(final String llllllllllllllllllIlIIIIlIIIllll) {
        if (!this.field_175998_i.containsKey(llllllllllllllllllIlIIIIlIIIllll)) {
            return false;
        }
        final ChatChannelListener llllllllllllllllllIlIIIIlIIIlllI = this.field_175998_i.get(llllllllllllllllllIlIIIIlIIIllll);
        return llllllllllllllllllIlIIIIlIIIlllI.func_176040_a() == EnumChannelState.Connected;
    }
    
    public void func_152998_c(final String llllllllllllllllllIlIIIIlIIllIIl) {
        this.field_153004_b = llllllllllllllllllIlIIIIlIIllIIl;
    }
    
    public void func_152997_n() {
        if (this.field_153011_i != ChatState.Uninitialized) {
            final ErrorCode llllllllllllllllllIlIIIIIlIIIIIl = this.field_153008_f.flushEvents();
            if (ErrorCode.failed(llllllllllllllllllIlIIIIIlIIIIIl)) {
                final String llllllllllllllllllIlIIIIIlIIIIII = ErrorCode.getString(llllllllllllllllllIlIIIIIlIIIIIl);
                this.func_152995_h(String.format("Error flushing chat events: %s", llllllllllllllllllIlIIIIIlIIIIII));
            }
        }
    }
    
    public boolean func_175991_l(final String llllllllllllllllllIlIIIIIlIllIII) {
        if (this.field_153011_i != ChatState.Initialized) {
            return false;
        }
        if (!this.field_175998_i.containsKey(llllllllllllllllllIlIIIIIlIllIII)) {
            this.func_152995_h(String.valueOf(new StringBuilder("Not in channel: ").append(llllllllllllllllllIlIIIIIlIllIII)));
            return false;
        }
        final ChatChannelListener llllllllllllllllllIlIIIIIlIlIlll = this.field_175998_i.get(llllllllllllllllllIlIIIIIlIllIII);
        return llllllllllllllllllIlIIIIIlIlIlll.func_176034_g();
    }
    
    public void func_152990_a(final ChatListener llllllllllllllllllIlIIIIlIlIlIll) {
        this.field_153003_a = llllllllllllllllllIlIIIIlIlIlIll;
    }
    
    public boolean func_152986_d(final String llllllllllllllllllIlIIIIIllIllII) {
        return this.func_175987_a(llllllllllllllllllIlIIIIIllIllII, false);
    }
    
    static {
        __OBFID = "CL_00001819";
        LOGGER = LogManager.getLogger();
    }
    
    protected void func_153001_r() {
        if (this.field_175995_l != EnumEmoticonMode.None && this.field_175996_m == null) {
            final ErrorCode llllllllllllllllllIlIIIIIIlIIIll = this.field_153008_f.downloadEmoticonData();
            if (ErrorCode.failed(llllllllllllllllllIlIIIIIIlIIIll)) {
                final String llllllllllllllllllIlIIIIIIlIIIlI = ErrorCode.getString(llllllllllllllllllIlIIIIIIlIIIll);
                this.func_152995_h(String.format("Error trying to download emoticon data: %s", llllllllllllllllllIlIIIIIIlIIIlI));
            }
        }
    }
    
    public boolean func_152993_m() {
        if (this.field_153011_i != ChatState.Initialized) {
            return false;
        }
        final ErrorCode llllllllllllllllllIlIIIIIlIIllll = this.field_153008_f.shutdown();
        if (ErrorCode.failed(llllllllllllllllllIlIIIIIlIIllll)) {
            final String llllllllllllllllllIlIIIIIlIIlllI = ErrorCode.getString(llllllllllllllllllIlIIIIIlIIllll);
            this.func_152995_h(String.format("Error shutting down chat: %s", llllllllllllllllllIlIIIIIlIIlllI));
            return false;
        }
        this.func_152996_t();
        this.func_175985_a(ChatState.ShuttingDown);
        return true;
    }
    
    protected void func_152995_h(final String llllllllllllllllllIlIIIIIIIIlIIl) {
        ChatController.LOGGER.error(TwitchStream.field_152949_a, "[Chat controller] {}", new Object[] { llllllllllllllllllIlIIIIIIIIlIIl });
    }
    
    public void func_152984_a(final String llllllllllllllllllIlIIIIlIIlllll) {
        this.field_153006_d = llllllllllllllllllIlIIIIlIIlllll;
    }
    
    protected void func_152996_t() {
        if (this.field_175996_m != null) {
            final ErrorCode llllllllllllllllllIlIIIIIIIlIIIl = this.field_153008_f.clearEmoticonData();
            if (ErrorCode.succeeded(llllllllllllllllllIlIIIIIIIlIIIl)) {
                this.field_175996_m = null;
                try {
                    if (this.field_153003_a != null) {
                        this.field_153003_a.func_176024_e();
                    }
                }
                catch (Exception llllllllllllllllllIlIIIIIIIlIIII) {
                    this.func_152995_h(llllllllllllllllllIlIIIIIIIlIIII.toString());
                }
            }
            else {
                this.func_152995_h(String.valueOf(new StringBuilder("Error clearing emoticon data: ").append(ErrorCode.getString(llllllllllllllllllIlIIIIIIIlIIIl))));
            }
        }
    }
    
    public ChatState func_153000_j() {
        return this.field_153011_i;
    }
    
    public interface ChatListener
    {
        void func_180605_a(final String p0, final ChatRawMessage[] p1);
        
        void func_176022_e(final ErrorCode p0);
        
        void func_180607_b(final String p0);
        
        void func_176023_d(final ErrorCode p0);
        
        void func_176020_d(final String p0);
        
        void func_176019_a(final String p0, final String p1);
        
        void func_176024_e();
        
        void func_176025_a(final String p0, final ChatTokenizedMessage[] p1);
        
        void func_180606_a(final String p0);
        
        void func_176018_a(final String p0, final ChatUserInfo[] p1, final ChatUserInfo[] p2, final ChatUserInfo[] p3);
        
        void func_176017_a(final ChatState p0);
        
        void func_176016_c(final String p0);
        
        void func_176021_d();
    }
    
    public enum ChatState
    {
        Initializing("Initializing", 1, "Initializing", 1), 
        ShuttingDown("ShuttingDown", 3, "ShuttingDown", 3), 
        Initialized("Initialized", 2, "Initialized", 2), 
        Uninitialized("Uninitialized", 0, "Uninitialized", 0);
        
        static {
            __OBFID = "CL_00001817";
        }
        
        private ChatState(final String llllllllllllllIllllIllIIllIlIlII, final int llllllllllllllIllllIllIIllIlIIll, final String llllllllllllllIllllIllIIllIlIlll, final int llllllllllllllIllllIllIIllIlIllI) {
        }
    }
    
    public class ChatChannelListener implements IChatChannelListener
    {
        protected /* synthetic */ EnumChannelState field_176047_c;
        protected /* synthetic */ String field_176048_a;
        protected /* synthetic */ boolean field_176046_b;
        protected /* synthetic */ ChatBadgeData field_176043_g;
        protected /* synthetic */ LinkedList field_176045_e;
        protected /* synthetic */ List field_176044_d;
        protected /* synthetic */ LinkedList field_176042_f;
        
        public boolean func_176038_a(final boolean lIIlIIIlIIlIllI) {
            this.field_176046_b = lIIlIIIlIIlIllI;
            ErrorCode lIIlIIIlIIlIlIl = ErrorCode.TTV_EC_SUCCESS;
            if (lIIlIIIlIIlIllI) {
                lIIlIIIlIIlIlIl = ChatController.this.field_153008_f.connectAnonymous(this.field_176048_a, (IChatChannelListener)this);
            }
            else {
                lIIlIIIlIIlIlIl = ChatController.this.field_153008_f.connect(this.field_176048_a, ChatController.this.field_153004_b, ChatController.this.field_153012_j.data, (IChatChannelListener)this);
            }
            if (ErrorCode.failed(lIIlIIIlIIlIlIl)) {
                final String lIIlIIIlIIlIlII = ErrorCode.getString(lIIlIIIlIIlIlIl);
                ChatController.this.func_152995_h(String.format("Error connecting: %s", lIIlIIIlIIlIlII));
                this.func_176036_d(this.field_176048_a);
                return false;
            }
            this.func_176035_a(EnumChannelState.Connecting);
            this.func_176041_h();
            return true;
        }
        
        public void chatChannelUserChangeCallback(final String lIIlIIIIIIllIlI, final ChatUserInfo[] lIIlIIIIIIlIIIl, final ChatUserInfo[] lIIlIIIIIIlIIII, final ChatUserInfo[] lIIlIIIIIIlIlll) {
            for (int lIIlIIIIIIlIllI = 0; lIIlIIIIIIlIllI < lIIlIIIIIIlIIII.length; ++lIIlIIIIIIlIllI) {
                final int lIIlIIIIIIlIlIl = this.field_176044_d.indexOf(lIIlIIIIIIlIIII[lIIlIIIIIIlIllI]);
                if (lIIlIIIIIIlIlIl >= 0) {
                    this.field_176044_d.remove(lIIlIIIIIIlIlIl);
                }
            }
            for (int lIIlIIIIIIlIllI = 0; lIIlIIIIIIlIllI < lIIlIIIIIIlIlll.length; ++lIIlIIIIIIlIllI) {
                final int lIIlIIIIIIlIlII = this.field_176044_d.indexOf(lIIlIIIIIIlIlll[lIIlIIIIIIlIllI]);
                if (lIIlIIIIIIlIlII >= 0) {
                    this.field_176044_d.remove(lIIlIIIIIIlIlII);
                }
                this.field_176044_d.add(lIIlIIIIIIlIlll[lIIlIIIIIIlIllI]);
            }
            for (int lIIlIIIIIIlIllI = 0; lIIlIIIIIIlIllI < lIIlIIIIIIlIIIl.length; ++lIIlIIIIIIlIllI) {
                this.field_176044_d.add(lIIlIIIIIIlIIIl[lIIlIIIIIIlIllI]);
            }
            try {
                if (ChatController.this.field_153003_a != null) {
                    ChatController.this.field_153003_a.func_176018_a(this.field_176048_a, lIIlIIIIIIlIIIl, lIIlIIIIIIlIIII, lIIlIIIIIIlIlll);
                }
            }
            catch (Exception lIIlIIIIIIlIIll) {
                ChatController.this.func_152995_h(lIIlIIIIIIlIIll.toString());
            }
        }
        
        public void chatChannelRawMessageCallback(final String lIIlIIIIIIIIlll, final ChatRawMessage[] lIIlIIIIIIIIIlI) {
            for (int lIIlIIIIIIIIlIl = 0; lIIlIIIIIIIIlIl < lIIlIIIIIIIIIlI.length; ++lIIlIIIIIIIIlIl) {
                this.field_176045_e.addLast(lIIlIIIIIIIIIlI[lIIlIIIIIIIIlIl]);
            }
            try {
                if (ChatController.this.field_153003_a != null) {
                    ChatController.this.field_153003_a.func_180605_a(this.field_176048_a, lIIlIIIIIIIIIlI);
                }
            }
            catch (Exception lIIlIIIIIIIIlII) {
                ChatController.this.func_152995_h(lIIlIIIIIIIIlII.toString());
            }
            while (this.field_176045_e.size() > ChatController.this.field_153015_m) {
                this.field_176045_e.removeFirst();
            }
        }
        
        private void func_176030_k() {
            if (this.field_176047_c != EnumChannelState.Disconnected) {
                this.func_176035_a(EnumChannelState.Disconnected);
                this.func_176036_d(this.field_176048_a);
                this.func_176033_j();
            }
        }
        
        public void chatStatusCallback(final String lIIlIIIIIllIIIl, final ErrorCode lIIlIIIIIlIllIl) {
            if (!ErrorCode.succeeded(lIIlIIIIIlIllIl)) {
                ChatController.this.field_175998_i.remove(lIIlIIIIIllIIIl);
                this.func_176030_k();
            }
        }
        
        public void chatBadgeDataDownloadCallback(final String lIIIllllllIlIll, final ErrorCode lIIIllllllIlIlI) {
            if (ErrorCode.succeeded(lIIIllllllIlIlI)) {
                this.func_176039_i();
            }
        }
        
        public boolean func_176037_b(final String lIIlIIIIllIlIII) {
            if (this.field_176047_c != EnumChannelState.Connected) {
                return false;
            }
            final ErrorCode lIIlIIIIllIlIll = ChatController.this.field_153008_f.sendMessage(this.field_176048_a, lIIlIIIIllIlIII);
            if (ErrorCode.failed(lIIlIIIIllIlIll)) {
                final String lIIlIIIIllIlIlI = ErrorCode.getString(lIIlIIIIllIlIll);
                ChatController.this.func_152995_h(String.format("Error sending chat message: %s", lIIlIIIIllIlIlI));
                return false;
            }
            return true;
        }
        
        protected void func_176033_j() {
            if (this.field_176043_g != null) {
                final ErrorCode lIIlIIIIlIIllll = ChatController.this.field_153008_f.clearBadgeData(this.field_176048_a);
                if (ErrorCode.succeeded(lIIlIIIIlIIllll)) {
                    this.field_176043_g = null;
                    try {
                        if (ChatController.this.field_153003_a != null) {
                            ChatController.this.field_153003_a.func_176020_d(this.field_176048_a);
                        }
                    }
                    catch (Exception lIIlIIIIlIIlllI) {
                        ChatController.this.func_152995_h(lIIlIIIIlIIlllI.toString());
                    }
                }
                else {
                    ChatController.this.func_152995_h(String.valueOf(new StringBuilder("Error releasing badge data: ").append(ErrorCode.getString(lIIlIIIIlIIllll))));
                }
            }
        }
        
        public void chatChannelTokenizedMessageCallback(final String lIIIlllllllllII, final ChatTokenizedMessage[] lIIIlllllllIlll) {
            for (int lIIIllllllllIlI = 0; lIIIllllllllIlI < lIIIlllllllIlll.length; ++lIIIllllllllIlI) {
                this.field_176042_f.addLast(lIIIlllllllIlll[lIIIllllllllIlI]);
            }
            try {
                if (ChatController.this.field_153003_a != null) {
                    ChatController.this.field_153003_a.func_176025_a(this.field_176048_a, lIIIlllllllIlll);
                }
            }
            catch (Exception lIIIllllllllIIl) {
                ChatController.this.func_152995_h(lIIIllllllllIIl.toString());
            }
            while (this.field_176042_f.size() > ChatController.this.field_153015_m) {
                this.field_176042_f.removeFirst();
            }
        }
        
        protected void func_176035_a(final EnumChannelState lIIlIIIlIIIIIll) {
            if (lIIlIIIlIIIIIll != this.field_176047_c) {
                this.field_176047_c = lIIlIIIlIIIIIll;
            }
        }
        
        public void func_176032_a(final String lIIlIIIIlllIlII) {
            if (ChatController.this.field_175995_l == EnumEmoticonMode.None) {
                this.field_176045_e.clear();
                this.field_176042_f.clear();
            }
            else {
                if (this.field_176045_e.size() > 0) {
                    final ListIterator lIIlIIIIllllIlI = this.field_176045_e.listIterator();
                    while (lIIlIIIIllllIlI.hasNext()) {
                        final ChatRawMessage lIIlIIIIllllIII = lIIlIIIIllllIlI.next();
                        if (lIIlIIIIllllIII.userName.equals(lIIlIIIIlllIlII)) {
                            lIIlIIIIllllIlI.remove();
                        }
                    }
                }
                if (this.field_176042_f.size() > 0) {
                    final ListIterator lIIlIIIIllllIIl = this.field_176042_f.listIterator();
                    while (lIIlIIIIllllIIl.hasNext()) {
                        final ChatTokenizedMessage lIIlIIIIlllIlll = lIIlIIIIllllIIl.next();
                        if (lIIlIIIIlllIlll.displayName.equals(lIIlIIIIlllIlII)) {
                            lIIlIIIIllllIIl.remove();
                        }
                    }
                }
            }
            try {
                if (ChatController.this.field_153003_a != null) {
                    ChatController.this.field_153003_a.func_176019_a(this.field_176048_a, lIIlIIIIlllIlII);
                }
            }
            catch (Exception lIIlIIIIlllIllI) {
                ChatController.this.func_152995_h(lIIlIIIIlllIllI.toString());
            }
        }
        
        protected void func_176036_d(final String lIIlIIIIIllllIl) {
            try {
                if (ChatController.this.field_153003_a != null) {
                    ChatController.this.field_153003_a.func_180607_b(lIIlIIIIIllllIl);
                }
            }
            catch (Exception lIIlIIIIIllllII) {
                ChatController.this.func_152995_h(lIIlIIIIIllllII.toString());
            }
        }
        
        protected void func_176031_c(final String lIIlIIIIlIIIllI) {
            try {
                if (ChatController.this.field_153003_a != null) {
                    ChatController.this.field_153003_a.func_180606_a(lIIlIIIIlIIIllI);
                }
            }
            catch (Exception lIIlIIIIlIIIlIl) {
                ChatController.this.func_152995_h(lIIlIIIIlIIIlIl.toString());
            }
        }
        
        public ChatChannelListener(final String lIIlIIIlIlIIIlI) {
            this.field_176048_a = null;
            this.field_176046_b = false;
            this.field_176047_c = EnumChannelState.Created;
            this.field_176044_d = Lists.newArrayList();
            this.field_176045_e = new LinkedList();
            this.field_176042_f = new LinkedList();
            this.field_176043_g = null;
            this.field_176048_a = lIIlIIIlIlIIIlI;
        }
        
        protected void func_176039_i() {
            if (this.field_176043_g == null) {
                this.field_176043_g = new ChatBadgeData();
                final ErrorCode lIIlIIIIlIllIII = ChatController.this.field_153008_f.getBadgeData(this.field_176048_a, this.field_176043_g);
                if (ErrorCode.succeeded(lIIlIIIIlIllIII)) {
                    try {
                        if (ChatController.this.field_153003_a != null) {
                            ChatController.this.field_153003_a.func_176016_c(this.field_176048_a);
                        }
                    }
                    catch (Exception lIIlIIIIlIlIlll) {
                        ChatController.this.func_152995_h(lIIlIIIIlIlIlll.toString());
                    }
                }
                else {
                    ChatController.this.func_152995_h(String.valueOf(new StringBuilder("Error preparing badge data: ").append(ErrorCode.getString(lIIlIIIIlIllIII))));
                }
            }
        }
        
        protected void func_176041_h() {
            if (ChatController.this.field_175995_l != EnumEmoticonMode.None && this.field_176043_g == null) {
                final ErrorCode lIIlIIIIllIIIIl = ChatController.this.field_153008_f.downloadBadgeData(this.field_176048_a);
                if (ErrorCode.failed(lIIlIIIIllIIIIl)) {
                    final String lIIlIIIIllIIIII = ErrorCode.getString(lIIlIIIIllIIIIl);
                    ChatController.this.func_152995_h(String.format("Error trying to download badge data: %s", lIIlIIIIllIIIII));
                }
            }
        }
        
        public boolean func_176034_g() {
            switch (SwitchEnumEmoticonMode.field_175976_a[this.field_176047_c.ordinal()]) {
                case 1:
                case 2: {
                    final ErrorCode lIIlIIIlIIIlIll = ChatController.this.field_153008_f.disconnect(this.field_176048_a);
                    if (ErrorCode.failed(lIIlIIIlIIIlIll)) {
                        final String lIIlIIIlIIIlIlI = ErrorCode.getString(lIIlIIIlIIIlIll);
                        ChatController.this.func_152995_h(String.format("Error disconnecting: %s", lIIlIIIlIIIlIlI));
                        return false;
                    }
                    this.func_176035_a(EnumChannelState.Disconnecting);
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        
        static {
            __OBFID = "CL_00002370";
        }
        
        public void chatClearCallback(final String lIIIlllllllIIlI, final String lIIIllllllIllll) {
            this.func_176032_a(lIIIllllllIllll);
        }
        
        public void chatChannelMembershipCallback(final String lIIlIIIIIlIlIII, final ChatEvent lIIlIIIIIlIIlll, final ChatChannelInfo lIIlIIIIIlIIllI) {
            switch (SwitchEnumEmoticonMode.field_175974_b[lIIlIIIIIlIIlll.ordinal()]) {
                case 1: {
                    this.func_176035_a(EnumChannelState.Connected);
                    this.func_176031_c(lIIlIIIIIlIlIII);
                    break;
                }
                case 2: {
                    this.func_176030_k();
                    break;
                }
            }
        }
        
        public EnumChannelState func_176040_a() {
            return this.field_176047_c;
        }
    }
    
    public enum EnumChannelState
    {
        Connected("Connected", 2, "Connected", 2), 
        Disconnecting("Disconnecting", 3, "Disconnecting", 3), 
        Created("Created", 0, "Created", 0), 
        Connecting("Connecting", 1, "Connecting", 1), 
        Disconnected("Disconnected", 4, "Disconnected", 4);
        
        private EnumChannelState(final String llllllllllllllIllIIlIIIlIIIllIll, final int llllllllllllllIllIIlIIIlIIIllIlI, final String llllllllllllllIllIIlIIIlIIIllllI, final int llllllllllllllIllIIlIIIlIIIlllIl) {
        }
        
        static {
            __OBFID = "CL_00002371";
        }
    }
    
    public enum EnumEmoticonMode
    {
        TextureAtlas("TextureAtlas", 2, "TextureAtlas", 2), 
        None("None", 0, "None", 0), 
        Url("Url", 1, "Url", 1);
        
        static {
            __OBFID = "CL_00002369";
        }
        
        private EnumEmoticonMode(final String llllllllllllllIIlIIlIlIIIlllIIlI, final int llllllllllllllIIlIIlIlIIIlllIIIl, final String llllllllllllllIIlIIlIlIIIlllIlIl, final int llllllllllllllIIlIIlIlIIIlllIlII) {
        }
    }
    
    static final class SwitchEnumEmoticonMode
    {
        static final /* synthetic */ int[] field_175974_b;
        static final /* synthetic */ int[] field_175976_a;
        static final /* synthetic */ int[] field_175975_c;
        
        static {
            __OBFID = "CL_00002372";
            field_175975_c = new int[EnumEmoticonMode.values().length];
            try {
                SwitchEnumEmoticonMode.field_175975_c[EnumEmoticonMode.None.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumEmoticonMode.field_175975_c[EnumEmoticonMode.Url.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumEmoticonMode.field_175975_c[EnumEmoticonMode.TextureAtlas.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            field_175974_b = new int[ChatEvent.values().length];
            try {
                SwitchEnumEmoticonMode.field_175974_b[ChatEvent.TTV_CHAT_JOINED_CHANNEL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumEmoticonMode.field_175974_b[ChatEvent.TTV_CHAT_LEFT_CHANNEL.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            field_175976_a = new int[EnumChannelState.values().length];
            try {
                SwitchEnumEmoticonMode.field_175976_a[EnumChannelState.Connected.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchEnumEmoticonMode.field_175976_a[EnumChannelState.Connecting.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchEnumEmoticonMode.field_175976_a[EnumChannelState.Created.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchEnumEmoticonMode.field_175976_a[EnumChannelState.Disconnected.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchEnumEmoticonMode.field_175976_a[EnumChannelState.Disconnecting.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
        }
    }
}
