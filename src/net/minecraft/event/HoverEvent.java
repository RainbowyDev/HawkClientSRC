package net.minecraft.event;

import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;

public class HoverEvent
{
    private final /* synthetic */ IChatComponent value;
    private final /* synthetic */ Action action;
    
    public HoverEvent(final Action llllllllllllllIllIIllIlllllIIIlI, final IChatComponent llllllllllllllIllIIllIllllIllllI) {
        this.action = llllllllllllllIllIIllIlllllIIIlI;
        this.value = llllllllllllllIllIIllIllllIllllI;
    }
    
    static {
        __OBFID = "CL_00001264";
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIllIIllIllllIIlIII = this.action.hashCode();
        llllllllllllllIllIIllIllllIIlIII = 31 * llllllllllllllIllIIllIllllIIlIII + ((this.value != null) ? this.value.hashCode() : 0);
        return llllllllllllllIllIIllIllllIIlIII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("HoverEvent{action=").append(this.action).append(", value='").append(this.value).append('\'').append('}'));
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllIIllIllllIlIIII) {
        if (this == llllllllllllllIllIIllIllllIlIIII) {
            return true;
        }
        if (llllllllllllllIllIIllIllllIlIIII == null || this.getClass() != llllllllllllllIllIIllIllllIlIIII.getClass()) {
            return false;
        }
        final HoverEvent llllllllllllllIllIIllIllllIlIIlI = (HoverEvent)llllllllllllllIllIIllIllllIlIIII;
        if (this.action != llllllllllllllIllIIllIllllIlIIlI.action) {
            return false;
        }
        if (this.value != null) {
            if (!this.value.equals(llllllllllllllIllIIllIllllIlIIlI.value)) {
                return false;
            }
        }
        else if (llllllllllllllIllIIllIllllIlIIlI.value != null) {
            return false;
        }
        return true;
    }
    
    public Action getAction() {
        return this.action;
    }
    
    public IChatComponent getValue() {
        return this.value;
    }
    
    public enum Action
    {
        SHOW_ITEM("SHOW_ITEM", 2, "SHOW_ITEM", 2, "show_item", true);
        
        private final /* synthetic */ boolean allowedInChat;
        
        SHOW_ENTITY("SHOW_ENTITY", 3, "SHOW_ENTITY", 3, "show_entity", true);
        
        private static final /* synthetic */ Map nameMapping;
        
        SHOW_TEXT("SHOW_TEXT", 0, "SHOW_TEXT", 0, "show_text", true);
        
        private final /* synthetic */ String canonicalName;
        
        SHOW_ACHIEVEMENT("SHOW_ACHIEVEMENT", 1, "SHOW_ACHIEVEMENT", 1, "show_achievement", true);
        
        public String getCanonicalName() {
            return this.canonicalName;
        }
        
        public boolean shouldAllowInChat() {
            return this.allowedInChat;
        }
        
        static {
            __OBFID = "CL_00001265";
            nameMapping = Maps.newHashMap();
            for (final Action llllllIIIIIIlll : values()) {
                Action.nameMapping.put(llllllIIIIIIlll.getCanonicalName(), llllllIIIIIIlll);
            }
        }
        
        private Action(final String lllllIlllllIlll, final int lllllIlllllIllI, final String lllllIlllllllII, final int lllllIllllllIll, final String lllllIlllllIlIl, final boolean lllllIllllllIIl) {
            this.canonicalName = lllllIlllllIlIl;
            this.allowedInChat = lllllIllllllIIl;
        }
        
        public static Action getValueByCanonicalName(final String lllllIllllIlIll) {
            return Action.nameMapping.get(lllllIllllIlIll);
        }
    }
}
