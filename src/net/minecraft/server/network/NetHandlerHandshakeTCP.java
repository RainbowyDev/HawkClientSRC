package net.minecraft.server.network;

import net.minecraft.network.handshake.*;
import net.minecraft.server.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.login.server.*;
import net.minecraft.util.*;
import net.minecraft.network.*;

public class NetHandlerHandshakeTCP implements INetHandlerHandshakeServer
{
    private final /* synthetic */ MinecraftServer server;
    private final /* synthetic */ NetworkManager networkManager;
    
    @Override
    public void processHandshake(final C00Handshake llllllllllllllIIIlIlIIlIIIIIllII) {
        switch (SwitchEnumConnectionState.VALUES[llllllllllllllIIIlIlIIlIIIIIllII.getRequestedState().ordinal()]) {
            case 1: {
                this.networkManager.setConnectionState(EnumConnectionState.LOGIN);
                if (llllllllllllllIIIlIlIIlIIIIIllII.getProtocolVersion() > 47) {
                    final ChatComponentText llllllllllllllIIIlIlIIlIIIIIlIll = new ChatComponentText("Outdated server! I'm still on 1.8");
                    this.networkManager.sendPacket(new S00PacketDisconnect(llllllllllllllIIIlIlIIlIIIIIlIll));
                    this.networkManager.closeChannel(llllllllllllllIIIlIlIIlIIIIIlIll);
                    break;
                }
                if (llllllllllllllIIIlIlIIlIIIIIllII.getProtocolVersion() < 47) {
                    final ChatComponentText llllllllllllllIIIlIlIIlIIIIIlIlI = new ChatComponentText("Outdated client! Please use 1.8");
                    this.networkManager.sendPacket(new S00PacketDisconnect(llllllllllllllIIIlIlIIlIIIIIlIlI));
                    this.networkManager.closeChannel(llllllllllllllIIIlIlIIlIIIIIlIlI);
                    break;
                }
                this.networkManager.setNetHandler(new NetHandlerLoginServer(this.server, this.networkManager));
                break;
            }
            case 2: {
                this.networkManager.setConnectionState(EnumConnectionState.STATUS);
                this.networkManager.setNetHandler(new NetHandlerStatusServer(this.server, this.networkManager));
                break;
            }
            default: {
                throw new UnsupportedOperationException(String.valueOf(new StringBuilder("Invalid intention ").append(llllllllllllllIIIlIlIIlIIIIIllII.getRequestedState())));
            }
        }
    }
    
    @Override
    public void onDisconnect(final IChatComponent llllllllllllllIIIlIlIIlIIIIIIlIl) {
    }
    
    public NetHandlerHandshakeTCP(final MinecraftServer llllllllllllllIIIlIlIIlIIIIlIIlI, final NetworkManager llllllllllllllIIIlIlIIlIIIIlIIIl) {
        this.server = llllllllllllllIIIlIlIIlIIIIlIIlI;
        this.networkManager = llllllllllllllIIIlIlIIlIIIIlIIIl;
    }
    
    static {
        __OBFID = "CL_00001456";
    }
    
    static final class SwitchEnumConnectionState
    {
        static final /* synthetic */ int[] VALUES;
        
        static {
            __OBFID = "CL_00001457";
            VALUES = new int[EnumConnectionState.values().length];
            try {
                SwitchEnumConnectionState.VALUES[EnumConnectionState.LOGIN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumConnectionState.VALUES[EnumConnectionState.STATUS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
        }
    }
}
