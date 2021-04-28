package net.minecraft.server.management;

import com.mojang.authlib.*;
import java.util.*;
import com.google.gson.*;
import java.io.*;

public class UserListOps extends UserList
{
    protected String func_152699_b(final GameProfile llllllllllllllIIIllIllllIlIIlIlI) {
        return llllllllllllllIIIllIllllIlIIlIlI.getId().toString();
    }
    
    public GameProfile getGameProfileFromName(final String llllllllllllllIIIllIllllIIllllll) {
        for (final UserListOpsEntry llllllllllllllIIIllIllllIlIIIIIl : this.getValues().values()) {
            if (llllllllllllllIIIllIllllIIllllll.equalsIgnoreCase(((GameProfile)llllllllllllllIIIllIllllIlIIIIIl.getValue()).getName())) {
                return (GameProfile)llllllllllllllIIIllIllllIlIIIIIl.getValue();
            }
        }
        return null;
    }
    
    @Override
    protected UserListEntry createEntry(final JsonObject llllllllllllllIIIllIllllIlIlllII) {
        return new UserListOpsEntry(llllllllllllllIIIllIllllIlIlllII);
    }
    
    static {
        __OBFID = "CL_00001879";
    }
    
    @Override
    protected String getObjectKey(final Object llllllllllllllIIIllIllllIIlllIIl) {
        return this.func_152699_b((GameProfile)llllllllllllllIIIllIllllIIlllIIl);
    }
    
    @Override
    public String[] getKeys() {
        final String[] llllllllllllllIIIllIllllIlIlIlIl = new String[this.getValues().size()];
        int llllllllllllllIIIllIllllIlIlIlII = 0;
        for (final UserListOpsEntry llllllllllllllIIIllIllllIlIlIIll : this.getValues().values()) {
            llllllllllllllIIIllIllllIlIlIlIl[llllllllllllllIIIllIllllIlIlIlII++] = ((GameProfile)llllllllllllllIIIllIllllIlIlIIll.getValue()).getName();
        }
        return llllllllllllllIIIllIllllIlIlIlIl;
    }
    
    public UserListOps(final File llllllllllllllIIIllIllllIllIIIII) {
        super(llllllllllllllIIIllIllllIllIIIII);
    }
}
