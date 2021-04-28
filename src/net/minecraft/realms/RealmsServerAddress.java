package net.minecraft.realms;

import net.minecraft.client.multiplayer.*;

public class RealmsServerAddress
{
    private final /* synthetic */ int port;
    private final /* synthetic */ String host;
    
    public String getHost() {
        return this.host;
    }
    
    public int getPort() {
        return this.port;
    }
    
    protected RealmsServerAddress(final String llllllllllllllIIIlIIIIlIlllIIlII, final int llllllllllllllIIIlIIIIlIlllIIllI) {
        this.host = llllllllllllllIIIlIIIIlIlllIIlII;
        this.port = llllllllllllllIIIlIIIIlIlllIIllI;
    }
    
    static {
        __OBFID = "CL_00001864";
    }
    
    public static RealmsServerAddress parseString(final String llllllllllllllIIIlIIIIlIllIlIIII) {
        final ServerAddress llllllllllllllIIIlIIIIlIllIlIIlI = ServerAddress.func_78860_a(llllllllllllllIIIlIIIIlIllIlIIII);
        return new RealmsServerAddress(llllllllllllllIIIlIIIIlIllIlIIlI.getIP(), llllllllllllllIIIlIIIIlIllIlIIlI.getPort());
    }
}
