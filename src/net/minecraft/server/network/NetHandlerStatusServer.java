package net.minecraft.server.network;

import net.minecraft.network.status.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import net.minecraft.network.status.client.*;
import net.minecraft.network.status.server.*;

public class NetHandlerStatusServer implements INetHandlerStatusServer
{
    private final /* synthetic */ NetworkManager networkManager;
    private final /* synthetic */ MinecraftServer server;
    
    @Override
    public void onDisconnect(final IChatComponent llllllllllllllIIlIIlllIlllIlIlII) {
    }
    
    @Override
    public void processServerQuery(final C00PacketServerQuery llllllllllllllIIlIIlllIlllIlIIIl) {
        this.networkManager.sendPacket(new S00PacketServerInfo(this.server.getServerStatusResponse()));
    }
    
    static {
        __OBFID = "CL_00001464";
    }
    
    public NetHandlerStatusServer(final MinecraftServer llllllllllllllIIlIIlllIlllIlIlll, final NetworkManager llllllllllllllIIlIIlllIlllIllIIl) {
        this.server = llllllllllllllIIlIIlllIlllIlIlll;
        this.networkManager = llllllllllllllIIlIIlllIlllIllIIl;
    }
    
    @Override
    public void processPing(final C01PacketPing llllllllllllllIIlIIlllIlllIIllII) {
        this.networkManager.sendPacket(new S01PacketPong(llllllllllllllIIlIIlllIlllIIllII.getClientTime()));
    }
}
