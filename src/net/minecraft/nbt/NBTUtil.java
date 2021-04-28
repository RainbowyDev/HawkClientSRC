package net.minecraft.nbt;

import com.mojang.authlib.*;
import net.minecraft.util.*;
import com.mojang.authlib.properties.*;
import java.util.*;

public final class NBTUtil
{
    public static GameProfile readGameProfileFromNBT(final NBTTagCompound llllllllllllllIIlIIIIlIIIIllIIII) {
        String llllllllllllllIIlIIIIlIIIIlIllll = null;
        String llllllllllllllIIlIIIIlIIIIlIlllI = null;
        if (llllllllllllllIIlIIIIlIIIIllIIII.hasKey("Name", 8)) {
            llllllllllllllIIlIIIIlIIIIlIllll = llllllllllllllIIlIIIIlIIIIllIIII.getString("Name");
        }
        if (llllllllllllllIIlIIIIlIIIIllIIII.hasKey("Id", 8)) {
            llllllllllllllIIlIIIIlIIIIlIlllI = llllllllllllllIIlIIIIlIIIIllIIII.getString("Id");
        }
        if (StringUtils.isNullOrEmpty(llllllllllllllIIlIIIIlIIIIlIllll) && StringUtils.isNullOrEmpty(llllllllllllllIIlIIIIlIIIIlIlllI)) {
            return null;
        }
        UUID llllllllllllllIIlIIIIlIIIIlIllII = null;
        try {
            final UUID llllllllllllllIIlIIIIlIIIIlIllIl = UUID.fromString(llllllllllllllIIlIIIIlIIIIlIlllI);
        }
        catch (Throwable llllllllllllllIIlIIIIlIIIIlIlIll) {
            llllllllllllllIIlIIIIlIIIIlIllII = null;
        }
        final GameProfile llllllllllllllIIlIIIIlIIIIlIlIlI = new GameProfile(llllllllllllllIIlIIIIlIIIIlIllII, llllllllllllllIIlIIIIlIIIIlIllll);
        if (llllllllllllllIIlIIIIlIIIIllIIII.hasKey("Properties", 10)) {
            final NBTTagCompound llllllllllllllIIlIIIIlIIIIlIlIIl = llllllllllllllIIlIIIIlIIIIllIIII.getCompoundTag("Properties");
            for (final String llllllllllllllIIlIIIIlIIIIlIIlll : llllllllllllllIIlIIIIlIIIIlIlIIl.getKeySet()) {
                final NBTTagList llllllllllllllIIlIIIIlIIIIlIIllI = llllllllllllllIIlIIIIlIIIIlIlIIl.getTagList(llllllllllllllIIlIIIIlIIIIlIIlll, 10);
                for (int llllllllllllllIIlIIIIlIIIIlIIlIl = 0; llllllllllllllIIlIIIIlIIIIlIIlIl < llllllllllllllIIlIIIIlIIIIlIIllI.tagCount(); ++llllllllllllllIIlIIIIlIIIIlIIlIl) {
                    final NBTTagCompound llllllllllllllIIlIIIIlIIIIlIIlII = llllllllllllllIIlIIIIlIIIIlIIllI.getCompoundTagAt(llllllllllllllIIlIIIIlIIIIlIIlIl);
                    final String llllllllllllllIIlIIIIlIIIIlIIIll = llllllllllllllIIlIIIIlIIIIlIIlII.getString("Value");
                    if (llllllllllllllIIlIIIIlIIIIlIIlII.hasKey("Signature", 8)) {
                        llllllllllllllIIlIIIIlIIIIlIlIlI.getProperties().put((Object)llllllllllllllIIlIIIIlIIIIlIIlll, (Object)new Property(llllllllllllllIIlIIIIlIIIIlIIlll, llllllllllllllIIlIIIIlIIIIlIIIll, llllllllllllllIIlIIIIlIIIIlIIlII.getString("Signature")));
                    }
                    else {
                        llllllllllllllIIlIIIIlIIIIlIlIlI.getProperties().put((Object)llllllllllllllIIlIIIIlIIIIlIIlll, (Object)new Property(llllllllllllllIIlIIIIlIIIIlIIlll, llllllllllllllIIlIIIIlIIIIlIIIll));
                    }
                }
            }
        }
        return llllllllllllllIIlIIIIlIIIIlIlIlI;
    }
    
    static {
        __OBFID = "CL_00001901";
    }
    
    public static NBTTagCompound writeGameProfile(final NBTTagCompound llllllllllllllIIlIIIIlIIIIIIIlII, final GameProfile llllllllllllllIIlIIIIlIIIIIIllII) {
        if (!StringUtils.isNullOrEmpty(llllllllllllllIIlIIIIlIIIIIIllII.getName())) {
            llllllllllllllIIlIIIIlIIIIIIIlII.setString("Name", llllllllllllllIIlIIIIlIIIIIIllII.getName());
        }
        if (llllllllllllllIIlIIIIlIIIIIIllII.getId() != null) {
            llllllllllllllIIlIIIIlIIIIIIIlII.setString("Id", llllllllllllllIIlIIIIlIIIIIIllII.getId().toString());
        }
        if (!llllllllllllllIIlIIIIlIIIIIIllII.getProperties().isEmpty()) {
            final NBTTagCompound llllllllllllllIIlIIIIlIIIIIIlIll = new NBTTagCompound();
            for (final String llllllllllllllIIlIIIIlIIIIIIlIIl : llllllllllllllIIlIIIIlIIIIIIllII.getProperties().keySet()) {
                final NBTTagList llllllllllllllIIlIIIIlIIIIIIlIII = new NBTTagList();
                for (final Property llllllllllllllIIlIIIIlIIIIIIIlIl : llllllllllllllIIlIIIIlIIIIIIllII.getProperties().get((Object)llllllllllllllIIlIIIIlIIIIIIlIIl)) {
                    final NBTTagCompound llllllllllllllIIlIIIIlIIIIIIIlll = new NBTTagCompound();
                    llllllllllllllIIlIIIIlIIIIIIIlll.setString("Value", llllllllllllllIIlIIIIlIIIIIIIlIl.getValue());
                    if (llllllllllllllIIlIIIIlIIIIIIIlIl.hasSignature()) {
                        llllllllllllllIIlIIIIlIIIIIIIlll.setString("Signature", llllllllllllllIIlIIIIlIIIIIIIlIl.getSignature());
                    }
                    llllllllllllllIIlIIIIlIIIIIIlIII.appendTag(llllllllllllllIIlIIIIlIIIIIIIlll);
                }
                llllllllllllllIIlIIIIlIIIIIIlIll.setTag(llllllllllllllIIlIIIIlIIIIIIlIIl, llllllllllllllIIlIIIIlIIIIIIlIII);
            }
            llllllllllllllIIlIIIIlIIIIIIIlII.setTag("Properties", llllllllllllllIIlIIIIlIIIIIIlIll);
        }
        return llllllllllllllIIlIIIIlIIIIIIIlII;
    }
}
