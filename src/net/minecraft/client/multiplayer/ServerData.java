package net.minecraft.client.multiplayer;

import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class ServerData
{
    private /* synthetic */ ServerResourceMode resourceMode;
    public /* synthetic */ int version;
    public /* synthetic */ String serverName;
    private /* synthetic */ String serverIcon;
    public /* synthetic */ String serverIP;
    public /* synthetic */ String gameVersion;
    
    public void setBase64EncodedIconData(final String lllllllllllllllIlIIlIIlllIIIllIl) {
        this.serverIcon = lllllllllllllllIlIIlIIlllIIIllIl;
    }
    
    public static ServerData getServerDataFromNBTCompound(final NBTTagCompound lllllllllllllllIlIIlIIlllIIlIlIl) {
        final ServerData lllllllllllllllIlIIlIIlllIIlIllI = new ServerData(lllllllllllllllIlIIlIIlllIIlIlIl.getString("name"), lllllllllllllllIlIIlIIlllIIlIlIl.getString("ip"));
        if (lllllllllllllllIlIIlIIlllIIlIlIl.hasKey("icon", 8)) {
            lllllllllllllllIlIIlIIlllIIlIllI.setBase64EncodedIconData(lllllllllllllllIlIIlIIlllIIlIlIl.getString("icon"));
        }
        if (lllllllllllllllIlIIlIIlllIIlIlIl.hasKey("acceptTextures", 1)) {
            if (lllllllllllllllIlIIlIIlllIIlIlIl.getBoolean("acceptTextures")) {
                lllllllllllllllIlIIlIIlllIIlIllI.setResourceMode(ServerResourceMode.ENABLED);
            }
            else {
                lllllllllllllllIlIIlIIlllIIlIllI.setResourceMode(ServerResourceMode.DISABLED);
            }
        }
        else {
            lllllllllllllllIlIIlIIlllIIlIllI.setResourceMode(ServerResourceMode.PROMPT);
        }
        return lllllllllllllllIlIIlIIlllIIlIllI;
    }
    
    public void copyFrom(final ServerData lllllllllllllllIlIIlIIlllIIIIlll) {
        this.serverIP = lllllllllllllllIlIIlIIlllIIIIlll.serverIP;
        this.serverName = lllllllllllllllIlIIlIIlllIIIIlll.serverName;
        this.setResourceMode(lllllllllllllllIlIIlIIlllIIIIlll.getResourceMode());
        this.serverIcon = lllllllllllllllIlIIlIIlllIIIIlll.serverIcon;
    }
    
    public ServerResourceMode getResourceMode() {
        return this.resourceMode;
    }
    
    public String getBase64EncodedIconData() {
        return this.serverIcon;
    }
    
    public void setResourceMode(final ServerResourceMode lllllllllllllllIlIIlIIlllIIllIlI) {
        this.resourceMode = lllllllllllllllIlIIlIIlllIIllIlI;
    }
    
    public ServerData(final String lllllllllllllllIlIIlIIlllIlIlIlI, final String lllllllllllllllIlIIlIIlllIlIlIIl) {
        this.version = 47;
        this.gameVersion = "1.8";
        this.resourceMode = ServerResourceMode.PROMPT;
        this.serverName = lllllllllllllllIlIIlIIlllIlIlIlI;
        this.serverIP = lllllllllllllllIlIIlIIlllIlIlIIl;
    }
    
    static {
        __OBFID = "CL_00000890";
    }
    
    public NBTTagCompound getNBTCompound() {
        final NBTTagCompound lllllllllllllllIlIIlIIlllIlIIlIl = new NBTTagCompound();
        lllllllllllllllIlIIlIIlllIlIIlIl.setString("name", this.serverName);
        lllllllllllllllIlIIlIIlllIlIIlIl.setString("ip", this.serverIP);
        if (this.serverIcon != null) {
            lllllllllllllllIlIIlIIlllIlIIlIl.setString("icon", this.serverIcon);
        }
        if (this.resourceMode == ServerResourceMode.ENABLED) {
            lllllllllllllllIlIIlIIlllIlIIlIl.setBoolean("acceptTextures", true);
        }
        else if (this.resourceMode == ServerResourceMode.DISABLED) {
            lllllllllllllllIlIIlIIlllIlIIlIl.setBoolean("acceptTextures", false);
        }
        return lllllllllllllllIlIIlIIlllIlIIlIl;
    }
    
    public enum ServerResourceMode
    {
        PROMPT("PROMPT", 2, "PROMPT", 2, "prompt");
        
        private final /* synthetic */ IChatComponent motd;
        
        ENABLED("ENABLED", 0, "ENABLED", 0, "enabled"), 
        DISABLED("DISABLED", 1, "DISABLED", 1, "disabled");
        
        public IChatComponent getMotd() {
            return this.motd;
        }
        
        static {
            __OBFID = "CL_00001833";
        }
        
        private ServerResourceMode(final String lllllllllllllllllIIlIIlllIIlllII, final int lllllllllllllllllIIlIIlllIIllIll, final String lllllllllllllllllIIlIIlllIlIIIII, final int lllllllllllllllllIIlIIlllIIlllll, final String lllllllllllllllllIIlIIlllIIllllI) {
            this.motd = new ChatComponentTranslation(String.valueOf(new StringBuilder("addServer.resourcePack.").append(lllllllllllllllllIIlIIlllIIllllI)), new Object[0]);
        }
    }
}
