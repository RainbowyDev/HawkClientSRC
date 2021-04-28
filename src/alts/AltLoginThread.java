package alts;

import net.minecraft.client.*;
import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.*;

public final class AltLoginThread extends Thread
{
    private final /* synthetic */ String username;
    private final /* synthetic */ String password;
    private /* synthetic */ Minecraft mc;
    private /* synthetic */ String status;
    
    public void setStatus(final String lllllllllllllllIllIIIllIIlIIIIll) {
        this.status = lllllllllllllllIllIIIllIIlIIIIll;
    }
    
    public AltLoginThread(final String lllllllllllllllIllIIIllIIllIIIll, final String lllllllllllllllIllIIIllIIllIIlIl) {
        super("Alt Login Thread");
        this.mc = Minecraft.getMinecraft();
        this.username = lllllllllllllllIllIIIllIIllIIIll;
        this.password = lllllllllllllllIllIIIllIIllIIlIl;
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Waiting..."));
    }
    
    @Override
    public void run() {
        if (this.password.equals("")) {
            this.mc.session = new Session(this.username, "", "", "mojang");
            this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append("Logged in. (").append(this.username).append(" - offline name)"));
            return;
        }
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.YELLOW).append("Logging in..."));
        final Session lllllllllllllllIllIIIllIIlIIlIll = this.createSession(this.username, this.password);
        if (lllllllllllllllIllIIIllIIlIIlIll == null) {
            this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Login failed!"));
        }
        else {
            AltManager.lastAlt = new Alt(this.username, this.password);
            this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append("Logged in. (").append(lllllllllllllllIllIIIllIIlIIlIll.getUsername()).append(")"));
            this.mc.session = lllllllllllllllIllIIIllIIlIIlIll;
        }
    }
    
    public String getStatus() {
        return this.status;
    }
    
    private Session createSession(final String lllllllllllllllIllIIIllIIlIlIllI, final String lllllllllllllllIllIIIllIIlIllIlI) {
        final YggdrasilAuthenticationService lllllllllllllllIllIIIllIIlIllIIl = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        final YggdrasilUserAuthentication lllllllllllllllIllIIIllIIlIllIII = (YggdrasilUserAuthentication)lllllllllllllllIllIIIllIIlIllIIl.createUserAuthentication(Agent.MINECRAFT);
        lllllllllllllllIllIIIllIIlIllIII.setUsername(lllllllllllllllIllIIIllIIlIlIllI);
        lllllllllllllllIllIIIllIIlIllIII.setPassword(lllllllllllllllIllIIIllIIlIllIlI);
        try {
            lllllllllllllllIllIIIllIIlIllIII.logIn();
            return new Session(lllllllllllllllIllIIIllIIlIllIII.getSelectedProfile().getName(), lllllllllllllllIllIIIllIIlIllIII.getSelectedProfile().getId().toString(), lllllllllllllllIllIIIllIIlIllIII.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException lllllllllllllllIllIIIllIIlIlIlll) {
            lllllllllllllllIllIIIllIIlIlIlll.printStackTrace();
            return null;
        }
    }
}
