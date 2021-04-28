package net.minecraft.server.management;

import java.io.*;
import com.mojang.authlib.*;
import java.util.*;
import com.google.gson.*;

public class UserListWhitelist extends UserList
{
    public UserListWhitelist(final File lllllllllllllllIIllllIllIllIIlll) {
        super(lllllllllllllllIIllllIllIllIIlll);
    }
    
    protected String func_152704_b(final GameProfile lllllllllllllllIIllllIllIlIIIlII) {
        return lllllllllllllllIIllllIllIlIIIlII.getId().toString();
    }
    
    public GameProfile func_152706_a(final String lllllllllllllllIIllllIllIIlllIIl) {
        for (final UserListWhitelistEntry lllllllllllllllIIllllIllIIlllIll : this.getValues().values()) {
            if (lllllllllllllllIIllllIllIIlllIIl.equalsIgnoreCase(((GameProfile)lllllllllllllllIIllllIllIIlllIll.getValue()).getName())) {
                return (GameProfile)lllllllllllllllIIllllIllIIlllIll.getValue();
            }
        }
        return null;
    }
    
    static {
        __OBFID = "CL_00001871";
    }
    
    @Override
    protected String getObjectKey(final Object lllllllllllllllIIllllIllIIllIIll) {
        return this.func_152704_b((GameProfile)lllllllllllllllIIllllIllIIllIIll);
    }
    
    @Override
    protected UserListEntry createEntry(final JsonObject lllllllllllllllIIllllIllIlIlllII) {
        return new UserListWhitelistEntry(lllllllllllllllIIllllIllIlIlllII);
    }
    
    @Override
    public String[] getKeys() {
        final String[] lllllllllllllllIIllllIllIlIIllll = new String[this.getValues().size()];
        int lllllllllllllllIIllllIllIlIIlllI = 0;
        for (final UserListWhitelistEntry lllllllllllllllIIllllIllIlIIllIl : this.getValues().values()) {
            lllllllllllllllIIllllIllIlIIllll[lllllllllllllllIIllllIllIlIIlllI++] = ((GameProfile)lllllllllllllllIIllllIllIlIIllIl.getValue()).getName();
        }
        return lllllllllllllllIIllllIllIlIIllll;
    }
}
