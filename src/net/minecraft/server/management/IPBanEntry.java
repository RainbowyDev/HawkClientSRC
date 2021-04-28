package net.minecraft.server.management;

import java.util.*;
import com.google.gson.*;

public class IPBanEntry extends BanEntry
{
    public IPBanEntry(final String llllllllllllllIlIIIlllIIlllIIlIl, final Date llllllllllllllIlIIIlllIIllIllllI, final String llllllllllllllIlIIIlllIIlllIIIll, final Date llllllllllllllIlIIIlllIIlllIIIlI, final String llllllllllllllIlIIIlllIIllIllIll) {
        super(llllllllllllllIlIIIlllIIlllIIlIl, llllllllllllllIlIIIlllIIllIllllI, llllllllllllllIlIIIlllIIlllIIIll, llllllllllllllIlIIIlllIIlllIIIlI, llllllllllllllIlIIIlllIIllIllIll);
    }
    
    private static String func_152647_b(final JsonObject llllllllllllllIlIIIlllIIllIlIIll) {
        return llllllllllllllIlIIIlllIIllIlIIll.has("ip") ? llllllllllllllIlIIIlllIIllIlIIll.get("ip").getAsString() : null;
    }
    
    @Override
    protected void onSerialization(final JsonObject llllllllllllllIlIIIlllIIllIIlllI) {
        if (this.getValue() != null) {
            llllllllllllllIlIIIlllIIllIIlllI.addProperty("ip", (String)this.getValue());
            super.onSerialization(llllllllllllllIlIIIlllIIllIIlllI);
        }
    }
    
    static {
        __OBFID = "CL_00001883";
    }
    
    public IPBanEntry(final String llllllllllllllIlIIIlllIIlllIllIl) {
        this(llllllllllllllIlIIIlllIIlllIllIl, null, null, null, null);
    }
    
    public IPBanEntry(final JsonObject llllllllllllllIlIIIlllIIllIlIlIl) {
        super(func_152647_b(llllllllllllllIlIIIlllIIllIlIlIl), llllllllllllllIlIIIlllIIllIlIlIl);
    }
}
