package hawk.alt;

import net.minecraft.client.*;
import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.*;

public final class AltLoginThread extends Thread
{
    private /* synthetic */ String status;
    private final /* synthetic */ String username;
    private final /* synthetic */ String password;
    private /* synthetic */ Minecraft mc;
    
    @Override
    public void run() {
        if (this.password.equals("")) {
            this.mc.session = new Session(this.username, "", "", "mojang");
            this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append("Logged in. (").append(this.username).append(" - offline name)"));
            return;
        }
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.YELLOW).append("Logging in..."));
        final Session llllllllllllllllllIlllIIllIIlIlI = this.createSession(this.username, this.password);
        if (llllllllllllllllllIlllIIllIIlIlI == null) {
            this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Login failed!"));
        }
        else {
            this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append("Logged in. (").append(llllllllllllllllllIlllIIllIIlIlI.getUsername()).append(")"));
            this.mc.session = llllllllllllllllllIlllIIllIIlIlI;
        }
    }
    
    public AltLoginThread(final String llllllllllllllllllIlllIIlllIlllI, final String llllllllllllllllllIlllIIlllIllIl) {
        super("Alt Login Thread");
        this.mc = Minecraft.getMinecraft();
        this.username = llllllllllllllllllIlllIIlllIlllI;
        this.password = llllllllllllllllllIlllIIlllIllIl;
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Waiting..."));
    }
    
    private Session createSession(final String llllllllllllllllllIlllIIlllIIIll, final String llllllllllllllllllIlllIIllIlllIl) {
        final YggdrasilAuthenticationService llllllllllllllllllIlllIIlllIIIIl = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        final YggdrasilUserAuthentication llllllllllllllllllIlllIIlllIIIII = (YggdrasilUserAuthentication)llllllllllllllllllIlllIIlllIIIIl.createUserAuthentication(Agent.MINECRAFT);
        llllllllllllllllllIlllIIlllIIIII.setUsername(llllllllllllllllllIlllIIlllIIIll);
        llllllllllllllllllIlllIIlllIIIII.setPassword(llllllllllllllllllIlllIIllIlllIl);
        try {
            llllllllllllllllllIlllIIlllIIIII.logIn();
            return new Session(llllllllllllllllllIlllIIlllIIIII.getSelectedProfile().getName(), llllllllllllllllllIlllIIlllIIIII.getSelectedProfile().getId().toString(), llllllllllllllllllIlllIIlllIIIII.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException llllllllllllllllllIlllIIllIlllll) {
            llllllllllllllllllIlllIIllIlllll.printStackTrace();
            return null;
        }
    }
    
    public void setStatus(final String llllllllllllllllllIlllIIlIllllIl) {
        this.status = llllllllllllllllllIlllIIlIllllIl;
    }
    
    public String getStatus() {
        return this.status;
    }
}
