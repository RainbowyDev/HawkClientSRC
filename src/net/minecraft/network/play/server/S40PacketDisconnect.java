package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class S40PacketDisconnect implements Packet
{
    private /* synthetic */ IChatComponent reason;
    
    static {
        __OBFID = "CL_00001298";
    }
    
    public IChatComponent func_149165_c() {
        return this.reason;
    }
    
    public S40PacketDisconnect() {
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIIIIIlIlllllIllII) {
        llllllllllllllIIIIIIlIlllllIllII.handleDisconnect(this);
    }
    
    public S40PacketDisconnect(final IChatComponent llllllllllllllIIIIIIlIlllllllllI) {
        this.reason = llllllllllllllIIIIIIlIlllllllllI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIIIIlIlllllllIII) throws IOException {
        this.reason = llllllllllllllIIIIIIlIlllllllIII.readChatComponent();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIIIIlIllllllIIlI) throws IOException {
        llllllllllllllIIIIIIlIllllllIIlI.writeChatComponent(this.reason);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIIIIlIlllllIIIll) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIIIIIIlIlllllIIIll);
    }
}
