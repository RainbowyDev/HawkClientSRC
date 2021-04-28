package net.minecraft.server.management;

import com.mojang.authlib.*;
import java.util.*;
import com.google.gson.*;
import java.io.*;

public class UserListBans extends UserList
{
    public boolean isBanned(final GameProfile llllllllllllllllllIIIIIIlIIlIlII) {
        return this.hasEntry(llllllllllllllllllIIIIIIlIIlIlII);
    }
    
    public GameProfile isUsernameBanned(final String llllllllllllllllllIIIIIIIlllIlll) {
        for (final UserListBansEntry llllllllllllllllllIIIIIIIllllIIl : this.getValues().values()) {
            if (llllllllllllllllllIIIIIIIlllIlll.equalsIgnoreCase(((GameProfile)llllllllllllllllllIIIIIIIllllIIl.getValue()).getName())) {
                return (GameProfile)llllllllllllllllllIIIIIIIllllIIl.getValue();
            }
        }
        return null;
    }
    
    @Override
    protected UserListEntry createEntry(final JsonObject llllllllllllllllllIIIIIIlIIllIlI) {
        return new UserListBansEntry(llllllllllllllllllIIIIIIlIIllIlI);
    }
    
    @Override
    public String[] getKeys() {
        final String[] llllllllllllllllllIIIIIIlIIIllIl = new String[this.getValues().size()];
        int llllllllllllllllllIIIIIIlIIIllII = 0;
        for (final UserListBansEntry llllllllllllllllllIIIIIIlIIIlIll : this.getValues().values()) {
            llllllllllllllllllIIIIIIlIIIllIl[llllllllllllllllllIIIIIIlIIIllII++] = ((GameProfile)llllllllllllllllllIIIIIIlIIIlIll.getValue()).getName();
        }
        return llllllllllllllllllIIIIIIlIIIllIl;
    }
    
    public UserListBans(final File llllllllllllllllllIIIIIIlIIllllI) {
        super(llllllllllllllllllIIIIIIlIIllllI);
    }
    
    protected String getProfileId(final GameProfile llllllllllllllllllIIIIIIlIIIIIIl) {
        return llllllllllllllllllIIIIIIlIIIIIIl.getId().toString();
    }
    
    static {
        __OBFID = "CL_00001873";
    }
    
    @Override
    protected String getObjectKey(final Object llllllllllllllllllIIIIIIIlllIIIl) {
        return this.getProfileId((GameProfile)llllllllllllllllllIIIIIIIlllIIIl);
    }
}
