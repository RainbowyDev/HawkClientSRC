package net.minecraft.client.multiplayer;

import java.util.*;
import javax.naming.directory.*;
import java.net.*;

public class ServerAddress
{
    private final /* synthetic */ String ipAddress;
    private final /* synthetic */ int serverPort;
    
    private static int parseIntWithDefault(final String lllllllllllllllIIlIIllIIlIllIIll, final int lllllllllllllllIIlIIllIIlIlIllll) {
        try {
            return Integer.parseInt(lllllllllllllllIIlIIllIIlIllIIll.trim());
        }
        catch (Exception lllllllllllllllIIlIIllIIlIllIIIl) {
            return lllllllllllllllIIlIIllIIlIlIllll;
        }
    }
    
    static {
        __OBFID = "CL_00000889";
    }
    
    public int getPort() {
        return this.serverPort;
    }
    
    private ServerAddress(final String lllllllllllllllIIlIIllIIlllIIIll, final int lllllllllllllllIIlIIllIIlllIIlIl) {
        this.ipAddress = lllllllllllllllIIlIIllIIlllIIIll;
        this.serverPort = lllllllllllllllIIlIIllIIlllIIlIl;
    }
    
    private static String[] getServerAddress(final String lllllllllllllllIIlIIllIIlIllllII) {
        try {
            final String lllllllllllllllIIlIIllIIllIIIIlI = "com.sun.jndi.dns.DnsContextFactory";
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            final Hashtable lllllllllllllllIIlIIllIIllIIIIIl = new Hashtable();
            lllllllllllllllIIlIIllIIllIIIIIl.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            lllllllllllllllIIlIIllIIllIIIIIl.put("java.naming.provider.url", "dns:");
            lllllllllllllllIIlIIllIIllIIIIIl.put("com.sun.jndi.dns.timeout.retries", "1");
            final InitialDirContext lllllllllllllllIIlIIllIIllIIIIII = new InitialDirContext(lllllllllllllllIIlIIllIIllIIIIIl);
            final Attributes lllllllllllllllIIlIIllIIlIllllll = lllllllllllllllIIlIIllIIllIIIIII.getAttributes(String.valueOf(new StringBuilder("_minecraft._tcp.").append(lllllllllllllllIIlIIllIIlIllllII)), new String[] { "SRV" });
            final String[] lllllllllllllllIIlIIllIIlIlllllI = lllllllllllllllIIlIIllIIlIllllll.get("srv").get().toString().split(" ", 4);
            return new String[] { lllllllllllllllIIlIIllIIlIlllllI[3], lllllllllllllllIIlIIllIIlIlllllI[2] };
        }
        catch (Throwable lllllllllllllllIIlIIllIIlIllllIl) {
            return new String[] { lllllllllllllllIIlIIllIIlIllllII, Integer.toString(25565) };
        }
    }
    
    public static ServerAddress func_78860_a(final String lllllllllllllllIIlIIllIIllIlIllI) {
        if (lllllllllllllllIIlIIllIIllIlIllI == null) {
            return null;
        }
        String[] lllllllllllllllIIlIIllIIllIlIlIl = lllllllllllllllIIlIIllIIllIlIllI.split(":");
        if (lllllllllllllllIIlIIllIIllIlIllI.startsWith("[")) {
            final int lllllllllllllllIIlIIllIIllIlIlII = lllllllllllllllIIlIIllIIllIlIllI.indexOf("]");
            if (lllllllllllllllIIlIIllIIllIlIlII > 0) {
                final String lllllllllllllllIIlIIllIIllIlIIll = lllllllllllllllIIlIIllIIllIlIllI.substring(1, lllllllllllllllIIlIIllIIllIlIlII);
                String lllllllllllllllIIlIIllIIllIlIIlI = lllllllllllllllIIlIIllIIllIlIllI.substring(lllllllllllllllIIlIIllIIllIlIlII + 1).trim();
                if (lllllllllllllllIIlIIllIIllIlIIlI.startsWith(":") && lllllllllllllllIIlIIllIIllIlIIlI.length() > 0) {
                    lllllllllllllllIIlIIllIIllIlIIlI = lllllllllllllllIIlIIllIIllIlIIlI.substring(1);
                    lllllllllllllllIIlIIllIIllIlIlIl = new String[] { lllllllllllllllIIlIIllIIllIlIIll, lllllllllllllllIIlIIllIIllIlIIlI };
                }
                else {
                    lllllllllllllllIIlIIllIIllIlIlIl = new String[] { lllllllllllllllIIlIIllIIllIlIIll };
                }
            }
        }
        if (lllllllllllllllIIlIIllIIllIlIlIl.length > 2) {
            lllllllllllllllIIlIIllIIllIlIlIl = new String[] { lllllllllllllllIIlIIllIIllIlIllI };
        }
        String lllllllllllllllIIlIIllIIllIlIIIl = lllllllllllllllIIlIIllIIllIlIlIl[0];
        int lllllllllllllllIIlIIllIIllIlIIII = (lllllllllllllllIIlIIllIIllIlIlIl.length > 1) ? parseIntWithDefault(lllllllllllllllIIlIIllIIllIlIlIl[1], 25565) : 25565;
        if (lllllllllllllllIIlIIllIIllIlIIII == 25565) {
            final String[] lllllllllllllllIIlIIllIIllIIllll = getServerAddress(lllllllllllllllIIlIIllIIllIlIIIl);
            lllllllllllllllIIlIIllIIllIlIIIl = lllllllllllllllIIlIIllIIllIIllll[0];
            lllllllllllllllIIlIIllIIllIlIIII = parseIntWithDefault(lllllllllllllllIIlIIllIIllIIllll[1], 25565);
        }
        return new ServerAddress(lllllllllllllllIIlIIllIIllIlIIIl, lllllllllllllllIIlIIllIIllIlIIII);
    }
    
    public String getIP() {
        return IDN.toASCII(this.ipAddress);
    }
}
