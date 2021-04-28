package net.minecraft.util;

import com.mojang.authlib.*;
import com.mojang.util.*;
import java.util.*;
import com.google.common.collect.*;

public class Session
{
    private final /* synthetic */ String playerID;
    private final /* synthetic */ String token;
    private final /* synthetic */ Type sessionType;
    private final /* synthetic */ String username;
    
    public String getSessionID() {
        return String.valueOf(new StringBuilder("token:").append(this.token).append(":").append(this.playerID));
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public Type getSessionType() {
        return this.sessionType;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public String getPlayerID() {
        return this.playerID;
    }
    
    public Session(final String llllllllllllllllllIIIIlIllIlIIlI, final String llllllllllllllllllIIIIlIllIlIllI, final String llllllllllllllllllIIIIlIllIlIIII, final String llllllllllllllllllIIIIlIllIlIlII) {
        this.username = llllllllllllllllllIIIIlIllIlIIlI;
        this.playerID = llllllllllllllllllIIIIlIllIlIllI;
        this.token = llllllllllllllllllIIIIlIllIlIIII;
        this.sessionType = Type.setSessionType(llllllllllllllllllIIIIlIllIlIlII);
    }
    
    static {
        __OBFID = "CL_00000659";
    }
    
    public GameProfile getProfile() {
        try {
            final UUID llllllllllllllllllIIIIlIlIllllll = UUIDTypeAdapter.fromString(this.getPlayerID());
            return new GameProfile(llllllllllllllllllIIIIlIlIllllll, this.getUsername());
        }
        catch (IllegalArgumentException llllllllllllllllllIIIIlIlIlllllI) {
            return new GameProfile((UUID)null, this.getUsername());
        }
    }
    
    public enum Type
    {
        MOJANG("MOJANG", 1, "MOJANG", 1, "mojang"), 
        LEGACY("LEGACY", 0, "LEGACY", 0, "legacy");
        
        private static final /* synthetic */ Map field_152425_c;
        private final /* synthetic */ String sessionType;
        
        private Type(final String llllllllllllllIlIlIllIlllIlIlIlI, final int llllllllllllllIlIlIllIlllIlIlIIl, final String llllllllllllllIlIlIllIlllIlIlllI, final int llllllllllllllIlIlIllIlllIlIllIl, final String llllllllllllllIlIlIllIlllIlIllII) {
            this.sessionType = llllllllllllllIlIlIllIlllIlIllII;
        }
        
        static {
            __OBFID = "CL_00001851";
            field_152425_c = Maps.newHashMap();
            for (final Type llllllllllllllIlIlIllIlllIlllIII : values()) {
                Type.field_152425_c.put(llllllllllllllIlIlIllIlllIlllIII.sessionType, llllllllllllllIlIlIllIlllIlllIII);
            }
        }
        
        public static Type setSessionType(final String llllllllllllllIlIlIllIlllIlIIlIl) {
            return Type.field_152425_c.get(llllllllllllllIlIlIllIlllIlIIlIl.toLowerCase());
        }
    }
}
