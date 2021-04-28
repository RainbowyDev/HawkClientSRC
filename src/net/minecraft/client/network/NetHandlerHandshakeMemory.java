package net.minecraft.client.network;

import net.minecraft.network.handshake.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.server.network.*;
import net.minecraft.network.*;

public class NetHandlerHandshakeMemory implements INetHandlerHandshakeServer
{
    private final /* synthetic */ MinecraftServer field_147385_a;
    private final /* synthetic */ NetworkManager field_147384_b;
    
    public NetHandlerHandshakeMemory(final MinecraftServer llllllllllllllIIlIlIllllllIIIlIl, final NetworkManager llllllllllllllIIlIlIllllllIIIlII) {
        this.field_147385_a = llllllllllllllIIlIlIllllllIIIlIl;
        this.field_147384_b = llllllllllllllIIlIlIllllllIIIlII;
    }
    
    static {
        __OBFID = "CL_00001445";
    }
    
    @Override
    public void onDisconnect(final IChatComponent llllllllllllllIIlIlIlllllIllllII) {
    }
    
    @Override
    public void processHandshake(final C00Handshake llllllllllllllIIlIlIllllllIIIIII) {
        this.field_147384_b.setConnectionState(llllllllllllllIIlIlIllllllIIIIII.getRequestedState());
        this.field_147384_b.setNetHandler(new NetHandlerLoginServer(this.field_147385_a, this.field_147384_b));
    }
}
