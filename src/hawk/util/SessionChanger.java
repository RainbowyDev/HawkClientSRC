package hawk.util;

import net.minecraft.util.*;
import net.minecraft.client.*;
import com.mojang.util.*;
import java.util.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;

public class SessionChanger
{
    private static /* synthetic */ SessionChanger instance;
    private final /* synthetic */ UserAuthentication auth;
    
    public void setUserOffline(final String lllllllllllllllllIIllllIlIIIIlII) {
        this.auth.logOut();
        final Session lllllllllllllllllIIllllIlIIIIIll = new Session(lllllllllllllllllIIllllIlIIIIlII, lllllllllllllllllIIllllIlIIIIlII, "0", "legacy");
        this.setSession(lllllllllllllllllIIllllIlIIIIIll);
    }
    
    public void setUser(final String lllllllllllllllllIIllllIlIIIllll, final String lllllllllllllllllIIllllIlIIIlllI) {
        if (!Minecraft.getMinecraft().getSession().getUsername().equals(lllllllllllllllllIIllllIlIIIllll) || Minecraft.getMinecraft().getSession().getToken().equals("0")) {
            this.auth.logOut();
            this.auth.setUsername(lllllllllllllllllIIllllIlIIIllll);
            this.auth.setPassword(lllllllllllllllllIIllllIlIIIlllI);
            try {
                this.auth.logIn();
                final Session lllllllllllllllllIIllllIlIIlIIlI = new Session(this.auth.getSelectedProfile().getName(), UUIDTypeAdapter.fromUUID(this.auth.getSelectedProfile().getId()), this.auth.getAuthenticatedToken(), this.auth.getUserType().getName());
                this.setSession(lllllllllllllllllIIllllIlIIlIIlI);
            }
            catch (Exception lllllllllllllllllIIllllIlIIlIIIl) {
                lllllllllllllllllIIllllIlIIlIIIl.printStackTrace();
            }
        }
    }
    
    public static SessionChanger getInstance() {
        if (SessionChanger.instance == null) {
            SessionChanger.instance = new SessionChanger();
        }
        return SessionChanger.instance;
    }
    
    private SessionChanger() {
        final UUID lllllllllllllllllIIllllIlIIllllI = UUID.randomUUID();
        final AuthenticationService lllllllllllllllllIIllllIlIIlllIl = (AuthenticationService)new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(), lllllllllllllllllIIllllIlIIllllI.toString());
        this.auth = lllllllllllllllllIIllllIlIIlllIl.createUserAuthentication(Agent.MINECRAFT);
        lllllllllllllllllIIllllIlIIlllIl.createMinecraftSessionService();
    }
    
    private void setSession(final Session lllllllllllllllllIIllllIlIIIlIlI) {
        Minecraft.getMinecraft().session = lllllllllllllllllIIllllIlIIIlIlI;
    }
}
