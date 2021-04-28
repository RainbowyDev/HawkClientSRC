package net.minecraft.server.management;

import java.io.*;
import com.google.gson.*;
import java.net.*;

public class BanList extends UserList
{
    public BanList(final File llllllllllllllIIlIllIIllllllIlII) {
        super(llllllllllllllIIlIllIIllllllIlII);
    }
    
    static {
        __OBFID = "CL_00001396";
    }
    
    @Override
    protected UserListEntry createEntry(final JsonObject llllllllllllllIIlIllIIlllllIlllI) {
        return new IPBanEntry(llllllllllllllIIlIllIIlllllIlllI);
    }
    
    private String addressToString(final SocketAddress llllllllllllllIIlIllIIllllIlIllI) {
        String llllllllllllllIIlIllIIllllIlIlll = llllllllllllllIIlIllIIllllIlIllI.toString();
        if (llllllllllllllIIlIllIIllllIlIlll.contains("/")) {
            llllllllllllllIIlIllIIllllIlIlll = llllllllllllllIIlIllIIllllIlIlll.substring(llllllllllllllIIlIllIIllllIlIlll.indexOf(47) + 1);
        }
        if (llllllllllllllIIlIllIIllllIlIlll.contains(":")) {
            llllllllllllllIIlIllIIllllIlIlll = llllllllllllllIIlIllIIllllIlIlll.substring(0, llllllllllllllIIlIllIIllllIlIlll.indexOf(58));
        }
        return llllllllllllllIIlIllIIllllIlIlll;
    }
    
    public boolean isBanned(final SocketAddress llllllllllllllIIlIllIIlllllIIllI) {
        final String llllllllllllllIIlIllIIlllllIlIII = this.addressToString(llllllllllllllIIlIllIIlllllIIllI);
        return this.hasEntry(llllllllllllllIIlIllIIlllllIlIII);
    }
    
    public IPBanEntry getBanEntry(final SocketAddress llllllllllllllIIlIllIIlllllIIIII) {
        final String llllllllllllllIIlIllIIllllIlllll = this.addressToString(llllllllllllllIIlIllIIlllllIIIII);
        return (IPBanEntry)this.getEntry(llllllllllllllIIlIllIIllllIlllll);
    }
}
