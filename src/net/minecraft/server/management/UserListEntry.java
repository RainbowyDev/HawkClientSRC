package net.minecraft.server.management;

import com.google.gson.*;

public class UserListEntry
{
    private final /* synthetic */ Object value;
    
    public UserListEntry(final Object llllllllllllllllIIllIIlllIllllll) {
        this.value = llllllllllllllllIIllIIlllIllllll;
    }
    
    static {
        __OBFID = "CL_00001877";
    }
    
    boolean hasBanExpired() {
        return false;
    }
    
    protected void onSerialization(final JsonObject llllllllllllllllIIllIIlllIllIIlI) {
    }
    
    Object getValue() {
        return this.value;
    }
    
    protected UserListEntry(final Object llllllllllllllllIIllIIlllIlllIII, final JsonObject llllllllllllllllIIllIIlllIlllIlI) {
        this.value = llllllllllllllllIIllIIlllIlllIII;
    }
}
