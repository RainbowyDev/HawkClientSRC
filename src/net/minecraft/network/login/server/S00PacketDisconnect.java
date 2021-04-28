package net.minecraft.network.login.server;

import net.minecraft.util.*;
import net.minecraft.network.login.*;
import java.io.*;
import net.minecraft.network.*;

public class S00PacketDisconnect implements Packet
{
    private /* synthetic */ IChatComponent reason;
    
    public void func_180772_a(final INetHandlerLoginClient llllllllllllllIIIIllllIIlIlIIlIl) {
        llllllllllllllIIIIllllIIlIlIIlIl.handleDisconnect(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIIllllIIlIllIIIl) throws IOException {
        this.reason = llllllllllllllIIIIllllIIlIllIIIl.readChatComponent();
    }
    
    public IChatComponent func_149603_c() {
        return this.reason;
    }
    
    static {
        __OBFID = "CL_00001377";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIIllllIIlIlIlIIl) throws IOException {
        llllllllllllllIIIIllllIIlIlIlIIl.writeChatComponent(this.reason);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIIllllIIlIIlllII) {
        this.func_180772_a((INetHandlerLoginClient)llllllllllllllIIIIllllIIlIIlllII);
    }
    
    public S00PacketDisconnect() {
    }
    
    public S00PacketDisconnect(final IChatComponent llllllllllllllIIIIllllIIlIllIlIl) {
        this.reason = llllllllllllllIIIIllllIIlIllIlIl;
    }
}
