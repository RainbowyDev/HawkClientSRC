package net.minecraft.server.management;

import java.io.*;
import net.minecraft.server.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class PreYggdrasilConverter
{
    private static final /* synthetic */ Logger LOGGER;
    
    private static void lookupNames(final MinecraftServer llllllllllllllllIlIlllIlllIlIIIl, final Collection llllllllllllllllIlIlllIlllIllIlI, final ProfileLookupCallback llllllllllllllllIlIlllIlllIIllll) {
        final String[] llllllllllllllllIlIlllIlllIllIII = (String[])Iterators.toArray((Iterator)Iterators.filter((Iterator)llllllllllllllllIlIlllIlllIllIlI.iterator(), (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00001881";
            }
            
            public boolean apply(final Object lllllllllllllllIlIIlIllIllllIIlI) {
                return this.func_152733_a((String)lllllllllllllllIlIIlIllIllllIIlI);
            }
            
            public boolean func_152733_a(final String lllllllllllllllIlIIlIllIlllllIII) {
                return !StringUtils.isNullOrEmpty(lllllllllllllllIlIIlIllIlllllIII);
            }
        }), (Class)String.class);
        if (llllllllllllllllIlIlllIlllIlIIIl.isServerInOnlineMode()) {
            llllllllllllllllIlIlllIlllIlIIIl.getGameProfileRepository().findProfilesByNames(llllllllllllllllIlIlllIlllIllIII, Agent.MINECRAFT, llllllllllllllllIlIlllIlllIIllll);
        }
        else {
            final String[] llllllllllllllllIlIlllIlllIlIlll = llllllllllllllllIlIlllIlllIllIII;
            for (int llllllllllllllllIlIlllIlllIlIllI = llllllllllllllllIlIlllIlllIllIII.length, llllllllllllllllIlIlllIlllIlIlIl = 0; llllllllllllllllIlIlllIlllIlIlIl < llllllllllllllllIlIlllIlllIlIllI; ++llllllllllllllllIlIlllIlllIlIlIl) {
                final String llllllllllllllllIlIlllIlllIlIlII = llllllllllllllllIlIlllIlllIlIlll[llllllllllllllllIlIlllIlllIlIlIl];
                final UUID llllllllllllllllIlIlllIlllIlIIll = EntityPlayer.getUUID(new GameProfile((UUID)null, llllllllllllllllIlIlllIlllIlIlII));
                final GameProfile llllllllllllllllIlIlllIlllIlIIlI = new GameProfile(llllllllllllllllIlIlllIlllIlIIll, llllllllllllllllIlIlllIlllIlIlII);
                llllllllllllllllIlIlllIlllIIllll.onProfileLookupSucceeded(llllllllllllllllIlIlllIlllIlIIlI);
            }
        }
    }
    
    public static String func_152719_a(final String llllllllllllllllIlIlllIlllIIIIlI) {
        if (StringUtils.isNullOrEmpty(llllllllllllllllIlIlllIlllIIIIlI) || llllllllllllllllIlIlllIlllIIIIlI.length() > 16) {
            return llllllllllllllllIlIlllIlllIIIIlI;
        }
        final MinecraftServer llllllllllllllllIlIlllIlllIIIIIl = MinecraftServer.getServer();
        final GameProfile llllllllllllllllIlIlllIlllIIIIII = llllllllllllllllIlIlllIlllIIIIIl.getPlayerProfileCache().getGameProfileForUsername(llllllllllllllllIlIlllIlllIIIIlI);
        if (llllllllllllllllIlIlllIlllIIIIII != null && llllllllllllllllIlIlllIlllIIIIII.getId() != null) {
            return llllllllllllllllIlIlllIlllIIIIII.getId().toString();
        }
        if (!llllllllllllllllIlIlllIlllIIIIIl.isSinglePlayer() && llllllllllllllllIlIlllIlllIIIIIl.isServerInOnlineMode()) {
            final ArrayList llllllllllllllllIlIlllIllIllllll = Lists.newArrayList();
            final ProfileLookupCallback llllllllllllllllIlIlllIllIlllllI = (ProfileLookupCallback)new ProfileLookupCallback() {
                public void onProfileLookupFailed(final GameProfile llllllllllllllllIlIlIIlIIIIlllll, final Exception llllllllllllllllIlIlIIlIIIIllllI) {
                    PreYggdrasilConverter.LOGGER.warn(String.valueOf(new StringBuilder("Could not lookup user whitelist entry for ").append(llllllllllllllllIlIlIIlIIIIlllll.getName())), (Throwable)llllllllllllllllIlIlIIlIIIIllllI);
                }
                
                static {
                    __OBFID = "CL_00001880";
                }
                
                public void onProfileLookupSucceeded(final GameProfile llllllllllllllllIlIlIIlIIIlIIlIl) {
                    llllllllllllllllIlIlllIlllIIIIIl.getPlayerProfileCache().func_152649_a(llllllllllllllllIlIlIIlIIIlIIlIl);
                    llllllllllllllllIlIlllIllIllllll.add(llllllllllllllllIlIlIIlIIIlIIlIl);
                }
            };
            lookupNames(llllllllllllllllIlIlllIlllIIIIIl, Lists.newArrayList((Object[])new String[] { llllllllllllllllIlIlllIlllIIIIlI }), llllllllllllllllIlIlllIllIlllllI);
            return (llllllllllllllllIlIlllIllIllllll.size() > 0 && llllllllllllllllIlIlllIllIllllll.get(0).getId() != null) ? llllllllllllllllIlIlllIllIllllll.get(0).getId().toString() : "";
        }
        return EntityPlayer.getUUID(new GameProfile((UUID)null, llllllllllllllllIlIlllIlllIIIIlI)).toString();
    }
    
    static {
        __OBFID = "CL_00001882";
        LOGGER = LogManager.getLogger();
        OLD_IPBAN_FILE = new File("banned-ips.txt");
        OLD_PLAYERBAN_FILE = new File("banned-players.txt");
        OLD_OPS_FILE = new File("ops.txt");
        OLD_WHITELIST_FILE = new File("white-list.txt");
    }
}
