package net.minecraft.event;

import java.util.*;
import com.google.common.collect.*;

public class ClickEvent
{
    private final /* synthetic */ String value;
    private final /* synthetic */ Action action;
    
    public ClickEvent(final Action llllllllllllllIllIlllIIllIIlllIl, final String llllllllllllllIllIlllIIllIIlllII) {
        this.action = llllllllllllllIllIlllIIllIIlllIl;
        this.value = llllllllllllllIllIlllIIllIIlllII;
    }
    
    static {
        __OBFID = "CL_00001260";
    }
    
    public String getValue() {
        return this.value;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllIlllIIllIIlIIIl) {
        if (this == llllllllllllllIllIlllIIllIIlIIIl) {
            return true;
        }
        if (llllllllllllllIllIlllIIllIIlIIIl == null || this.getClass() != llllllllllllllIllIlllIIllIIlIIIl.getClass()) {
            return false;
        }
        final ClickEvent llllllllllllllIllIlllIIllIIlIIII = (ClickEvent)llllllllllllllIllIlllIIllIIlIIIl;
        if (this.action != llllllllllllllIllIlllIIllIIlIIII.action) {
            return false;
        }
        if (this.value != null) {
            if (!this.value.equals(llllllllllllllIllIlllIIllIIlIIII.value)) {
                return false;
            }
        }
        else if (llllllllllllllIllIlllIIllIIlIIII.value != null) {
            return false;
        }
        return true;
    }
    
    public Action getAction() {
        return this.action;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIllIlllIIllIIIIllI = this.action.hashCode();
        llllllllllllllIllIlllIIllIIIIllI = 31 * llllllllllllllIllIlllIIllIIIIllI + ((this.value != null) ? this.value.hashCode() : 0);
        return llllllllllllllIllIlllIIllIIIIllI;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("ClickEvent{action=").append(this.action).append(", value='").append(this.value).append('\'').append('}'));
    }
    
    public enum Action
    {
        OPEN_URL("OPEN_URL", 0, "OPEN_URL", 0, "open_url", true), 
        CHANGE_PAGE("CHANGE_PAGE", 5, "CHANGE_PAGE", 5, "change_page", true), 
        SUGGEST_COMMAND("SUGGEST_COMMAND", 4, "SUGGEST_COMMAND", 4, "suggest_command", true), 
        RUN_COMMAND("RUN_COMMAND", 2, "RUN_COMMAND", 2, "run_command", true), 
        TWITCH_USER_INFO("TWITCH_USER_INFO", 3, "TWITCH_USER_INFO", 3, "twitch_user_info", false), 
        OPEN_FILE("OPEN_FILE", 1, "OPEN_FILE", 1, "open_file", false);
        
        private final /* synthetic */ String canonicalName;
        private static final /* synthetic */ Map nameMapping;
        private final /* synthetic */ boolean allowedInChat;
        
        private Action(final String lllllllllllllllIIllIIllIIlllIIIl, final int lllllllllllllllIIllIIllIIlllIIII, final String lllllllllllllllIIllIIllIIlllIllI, final int lllllllllllllllIIllIIllIIlllIlIl, final String lllllllllllllllIIllIIllIIlllIlII, final boolean lllllllllllllllIIllIIllIIlllIIll) {
            this.canonicalName = lllllllllllllllIIllIIllIIlllIlII;
            this.allowedInChat = lllllllllllllllIIllIIllIIlllIIll;
        }
        
        public static Action getValueByCanonicalName(final String lllllllllllllllIIllIIllIIllIIllI) {
            return Action.nameMapping.get(lllllllllllllllIIllIIllIIllIIllI);
        }
        
        public String getCanonicalName() {
            return this.canonicalName;
        }
        
        public boolean shouldAllowInChat() {
            return this.allowedInChat;
        }
        
        static {
            __OBFID = "CL_00001261";
            nameMapping = Maps.newHashMap();
            for (final Action lllllllllllllllIIllIIllIlIIIIIIl : values()) {
                Action.nameMapping.put(lllllllllllllllIIllIIllIlIIIIIIl.getCanonicalName(), lllllllllllllllIIllIIllIlIIIIIIl);
            }
        }
    }
}
