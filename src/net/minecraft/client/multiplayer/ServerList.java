package net.minecraft.client.multiplayer;

import net.minecraft.client.*;
import org.apache.logging.log4j.*;
import java.io.*;
import net.minecraft.nbt.*;
import java.util.*;
import com.google.common.collect.*;

public class ServerList
{
    private final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ List servers;
    
    public int countServers() {
        return this.servers.size();
    }
    
    public void removeServerData(final int llllllllllllllllllIllllIIlllIIII) {
        this.servers.remove(llllllllllllllllllIllllIIlllIIII);
    }
    
    static {
        __OBFID = "CL_00000891";
        logger = LogManager.getLogger();
    }
    
    public void saveServerList() {
        try {
            final NBTTagList llllllllllllllllllIllllIlIIIIlII = new NBTTagList();
            for (final ServerData llllllllllllllllllIllllIlIIIIIlI : this.servers) {
                llllllllllllllllllIllllIlIIIIlII.appendTag(llllllllllllllllllIllllIlIIIIIlI.getNBTCompound());
            }
            final NBTTagCompound llllllllllllllllllIllllIlIIIIIIl = new NBTTagCompound();
            llllllllllllllllllIllllIlIIIIIIl.setTag("servers", llllllllllllllllllIllllIlIIIIlII);
            CompressedStreamTools.safeWrite(llllllllllllllllllIllllIlIIIIIIl, new File(this.mc.mcDataDir, "servers.dat"));
        }
        catch (Exception llllllllllllllllllIllllIlIIIIIII) {
            ServerList.logger.error("Couldn't save server list", (Throwable)llllllllllllllllllIllllIlIIIIIII);
        }
    }
    
    public void addServerData(final ServerData llllllllllllllllllIllllIIllIlIlI) {
        this.servers.add(llllllllllllllllllIllllIIllIlIlI);
    }
    
    public void loadServerList() {
        try {
            this.servers.clear();
            final NBTTagCompound llllllllllllllllllIllllIlIIlIIIl = CompressedStreamTools.read(new File(this.mc.mcDataDir, "servers.dat"));
            if (llllllllllllllllllIllllIlIIlIIIl == null) {
                return;
            }
            final NBTTagList llllllllllllllllllIllllIlIIlIIII = llllllllllllllllllIllllIlIIlIIIl.getTagList("servers", 10);
            for (int llllllllllllllllllIllllIlIIIllll = 0; llllllllllllllllllIllllIlIIIllll < llllllllllllllllllIllllIlIIlIIII.tagCount(); ++llllllllllllllllllIllllIlIIIllll) {
                this.servers.add(ServerData.getServerDataFromNBTCompound(llllllllllllllllllIllllIlIIlIIII.getCompoundTagAt(llllllllllllllllllIllllIlIIIllll)));
            }
        }
        catch (Exception llllllllllllllllllIllllIlIIIlllI) {
            ServerList.logger.error("Couldn't load server list", (Throwable)llllllllllllllllllIllllIlIIIlllI);
        }
    }
    
    public ServerList(final Minecraft llllllllllllllllllIllllIlIIllIIl) {
        this.servers = Lists.newArrayList();
        this.mc = llllllllllllllllllIllllIlIIllIIl;
        this.loadServerList();
    }
    
    public static void func_147414_b(final ServerData llllllllllllllllllIllllIIlIIlIIl) {
        final ServerList llllllllllllllllllIllllIIlIIllII = new ServerList(Minecraft.getMinecraft());
        llllllllllllllllllIllllIIlIIllII.loadServerList();
        for (int llllllllllllllllllIllllIIlIIlIll = 0; llllllllllllllllllIllllIIlIIlIll < llllllllllllllllllIllllIIlIIllII.countServers(); ++llllllllllllllllllIllllIIlIIlIll) {
            final ServerData llllllllllllllllllIllllIIlIIlIlI = llllllllllllllllllIllllIIlIIllII.getServerData(llllllllllllllllllIllllIIlIIlIll);
            if (llllllllllllllllllIllllIIlIIlIlI.serverName.equals(llllllllllllllllllIllllIIlIIlIIl.serverName) && llllllllllllllllllIllllIIlIIlIlI.serverIP.equals(llllllllllllllllllIllllIIlIIlIIl.serverIP)) {
                llllllllllllllllllIllllIIlIIllII.func_147413_a(llllllllllllllllllIllllIIlIIlIll, llllllllllllllllllIllllIIlIIlIIl);
                break;
            }
        }
        llllllllllllllllllIllllIIlIIllII.saveServerList();
    }
    
    public ServerData getServerData(final int llllllllllllllllllIllllIIlllIllI) {
        return this.servers.get(llllllllllllllllllIllllIIlllIllI);
    }
    
    public void func_147413_a(final int llllllllllllllllllIllllIIlIlIllI, final ServerData llllllllllllllllllIllllIIlIlIIlI) {
        this.servers.set(llllllllllllllllllIllllIIlIlIllI, llllllllllllllllllIllllIIlIlIIlI);
    }
    
    public void swapServers(final int llllllllllllllllllIllllIIlIlllIl, final int llllllllllllllllllIllllIIllIIIII) {
        final ServerData llllllllllllllllllIllllIIlIlllll = this.getServerData(llllllllllllllllllIllllIIlIlllIl);
        this.servers.set(llllllllllllllllllIllllIIlIlllIl, this.getServerData(llllllllllllllllllIllllIIllIIIII));
        this.servers.set(llllllllllllllllllIllllIIllIIIII, llllllllllllllllllIllllIIlIlllll);
        this.saveServerList();
    }
}
