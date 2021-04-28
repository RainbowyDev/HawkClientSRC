package com.thealtening.auth.service;

public enum AlteningServiceType
{
    THEALTENING("THEALTENING", 1, "http://authserver.thealtening.com/", "http://sessionserver.thealtening.com/");
    
    private final /* synthetic */ String authServer;
    private final /* synthetic */ String sessionServer;
    
    MOJANG("MOJANG", 0, "https://authserver.mojang.com/", "https://sessionserver.mojang.com/");
    
    public String getSessionServer() {
        return this.sessionServer;
    }
    
    private AlteningServiceType(final String llllllllllllllIlIIllllllIIIllIIl, final int llllllllllllllIlIIllllllIIIllIII, final String llllllllllllllIlIIllllllIIIlllII, final String llllllllllllllIlIIllllllIIIllIll) {
        this.authServer = llllllllllllllIlIIllllllIIIlllII;
        this.sessionServer = llllllllllllllIlIIllllllIIIllIll;
    }
    
    public String getAuthServer() {
        return this.authServer;
    }
}
