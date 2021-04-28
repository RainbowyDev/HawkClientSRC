package net.minecraft.server.management;

import java.util.*;
import com.google.gson.*;
import java.text.*;

public abstract class BanEntry extends UserListEntry
{
    protected final /* synthetic */ String reason;
    protected final /* synthetic */ String bannedBy;
    protected final /* synthetic */ Date banStartDate;
    public static final /* synthetic */ SimpleDateFormat dateFormat;
    protected final /* synthetic */ Date banEndDate;
    
    static {
        __OBFID = "CL_00001395";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    }
    
    public Date getBanEndDate() {
        return this.banEndDate;
    }
    
    public BanEntry(final Object llllllllllllllIllIIIIIIlIIlIIllI, final Date llllllllllllllIllIIIIIIlIIIlllll, final String llllllllllllllIllIIIIIIlIIIllllI, final Date llllllllllllllIllIIIIIIlIIIlllIl, final String llllllllllllllIllIIIIIIlIIIlllII) {
        super(llllllllllllllIllIIIIIIlIIlIIllI);
        this.banStartDate = ((llllllllllllllIllIIIIIIlIIIlllll == null) ? new Date() : llllllllllllllIllIIIIIIlIIIlllll);
        this.bannedBy = ((llllllllllllllIllIIIIIIlIIIllllI == null) ? "(Unknown)" : llllllllllllllIllIIIIIIlIIIllllI);
        this.banEndDate = llllllllllllllIllIIIIIIlIIIlllIl;
        this.reason = ((llllllllllllllIllIIIIIIlIIIlllII == null) ? "Banned by an operator." : llllllllllllllIllIIIIIIlIIIlllII);
    }
    
    @Override
    boolean hasBanExpired() {
        return this.banEndDate != null && this.banEndDate.before(new Date());
    }
    
    @Override
    protected void onSerialization(final JsonObject llllllllllllllIllIIIIIIIlllllIlI) {
        llllllllllllllIllIIIIIIIlllllIlI.addProperty("created", BanEntry.dateFormat.format(this.banStartDate));
        llllllllllllllIllIIIIIIIlllllIlI.addProperty("source", this.bannedBy);
        llllllllllllllIllIIIIIIIlllllIlI.addProperty("expires", (this.banEndDate == null) ? "forever" : BanEntry.dateFormat.format(this.banEndDate));
        llllllllllllllIllIIIIIIIlllllIlI.addProperty("reason", this.reason);
    }
    
    public String getBanReason() {
        return this.reason;
    }
    
    protected BanEntry(final Object llllllllllllllIllIIIIIIlIIIlIlII, final JsonObject llllllllllllllIllIIIIIIlIIIIlIlI) {
        super(llllllllllllllIllIIIIIIlIIIlIlII, llllllllllllllIllIIIIIIlIIIIlIlI);
        Date llllllllllllllIllIIIIIIlIIIlIIIl = null;
        try {
            final Date llllllllllllllIllIIIIIIlIIIlIIlI = llllllllllllllIllIIIIIIlIIIIlIlI.has("created") ? BanEntry.dateFormat.parse(llllllllllllllIllIIIIIIlIIIIlIlI.get("created").getAsString()) : new Date();
        }
        catch (ParseException llllllllllllllIllIIIIIIlIIIlIIII) {
            llllllllllllllIllIIIIIIlIIIlIIIl = new Date();
        }
        this.banStartDate = llllllllllllllIllIIIIIIlIIIlIIIl;
        this.bannedBy = (llllllllllllllIllIIIIIIlIIIIlIlI.has("source") ? llllllllllllllIllIIIIIIlIIIIlIlI.get("source").getAsString() : "(Unknown)");
        Date llllllllllllllIllIIIIIIlIIIIlllI = null;
        try {
            final Date llllllllllllllIllIIIIIIlIIIIllll = llllllllllllllIllIIIIIIlIIIIlIlI.has("expires") ? BanEntry.dateFormat.parse(llllllllllllllIllIIIIIIlIIIIlIlI.get("expires").getAsString()) : null;
        }
        catch (ParseException llllllllllllllIllIIIIIIlIIIIllIl) {
            llllllllllllllIllIIIIIIlIIIIlllI = null;
        }
        this.banEndDate = llllllllllllllIllIIIIIIlIIIIlllI;
        this.reason = (llllllllllllllIllIIIIIIlIIIIlIlI.has("reason") ? llllllllllllllIllIIIIIIlIIIIlIlI.get("reason").getAsString() : "Banned by an operator.");
    }
}
