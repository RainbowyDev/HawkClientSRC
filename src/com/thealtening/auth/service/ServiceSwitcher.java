package com.thealtening.auth.service;

import java.net.*;

public final class ServiceSwitcher
{
    private final /* synthetic */ String[] WHITELISTED_DOMAINS;
    private final /* synthetic */ FieldAdapter userAuthentication;
    private final /* synthetic */ FieldAdapter minecraftSessionServer;
    
    public ServiceSwitcher() {
        this.WHITELISTED_DOMAINS = new String[] { ".minecraft.net", ".mojang.com", ".thealtening.com" };
        this.minecraftSessionServer = new FieldAdapter("com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService");
        this.userAuthentication = new FieldAdapter("com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication");
        try {
            this.minecraftSessionServer.updateFieldIfPresent("WHITELISTED_DOMAINS", this.WHITELISTED_DOMAINS);
        }
        catch (Exception llllllllllllllllIIIIIllIIIlIlIll) {
            llllllllllllllllIIIIIllIIIlIlIll.printStackTrace();
        }
    }
    
    public AlteningServiceType switchToService(final AlteningServiceType llllllllllllllllIIIIIllIIIlIIIIl) {
        try {
            final String llllllllllllllllIIIIIllIIIlIIIII = llllllllllllllllIIIIIllIIIlIIIIl.getAuthServer();
            final FieldAdapter llllllllllllllllIIIIIllIIIIlllll = this.userAuthentication;
            llllllllllllllllIIIIIllIIIIlllll.updateFieldIfPresent("BASE_URL", llllllllllllllllIIIIIllIIIlIIIII);
            llllllllllllllllIIIIIllIIIIlllll.updateFieldIfPresent("ROUTE_AUTHENTICATE", new URL(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIllIIIlIIIII)).append("authenticate"))));
            llllllllllllllllIIIIIllIIIIlllll.updateFieldIfPresent("ROUTE_INVALIDATE", new URL(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIllIIIlIIIII)).append("invalidate"))));
            llllllllllllllllIIIIIllIIIIlllll.updateFieldIfPresent("ROUTE_REFRESH", new URL(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIllIIIlIIIII)).append("refresh"))));
            llllllllllllllllIIIIIllIIIIlllll.updateFieldIfPresent("ROUTE_VALIDATE", new URL(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIllIIIlIIIII)).append("validate"))));
            llllllllllllllllIIIIIllIIIIlllll.updateFieldIfPresent("ROUTE_SIGNOUT", new URL(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIllIIIlIIIII)).append("signout"))));
            final String llllllllllllllllIIIIIllIIIIllllI = llllllllllllllllIIIIIllIIIlIIIIl.getSessionServer();
            final FieldAdapter llllllllllllllllIIIIIllIIIIlllIl = this.minecraftSessionServer;
            llllllllllllllllIIIIIllIIIIlllIl.updateFieldIfPresent("BASE_URL", String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIllIIIIllllI)).append("session/minecraft/")));
            llllllllllllllllIIIIIllIIIIlllIl.updateFieldIfPresent("JOIN_URL", new URL(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIllIIIIllllI)).append("session/minecraft/join"))));
            llllllllllllllllIIIIIllIIIIlllIl.updateFieldIfPresent("CHECK_URL", new URL(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIllIIIIllllI)).append("session/minecraft/hasJoined"))));
        }
        catch (Exception llllllllllllllllIIIIIllIIIIlllII) {
            llllllllllllllllIIIIIllIIIIlllII.printStackTrace();
            return AlteningServiceType.MOJANG;
        }
        return llllllllllllllllIIIIIllIIIlIIIIl;
    }
}
