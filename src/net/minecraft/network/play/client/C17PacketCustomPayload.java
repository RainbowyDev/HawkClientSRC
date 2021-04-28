package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import io.netty.buffer.*;
import java.io.*;
import net.minecraft.network.*;

public class C17PacketCustomPayload implements Packet
{
    private /* synthetic */ PacketBuffer data;
    private /* synthetic */ String channel;
    
    public PacketBuffer getBufferData() {
        return this.data;
    }
    
    public void processPacket(final INetHandlerPlayServer llllllllllllllIIlIllllllllIlIIlI) {
        llllllllllllllIIlIllllllllIlIIlI.processVanilla250Packet(this);
    }
    
    public String getChannelName() {
        return this.channel;
    }
    
    public C17PacketCustomPayload(final String llllllllllllllIIlIlllllllllIlIll, final PacketBuffer llllllllllllllIIlIlllllllllIIlll) {
        this.channel = llllllllllllllIIlIlllllllllIlIll;
        this.data = llllllllllllllIIlIlllllllllIIlll;
        if (llllllllllllllIIlIlllllllllIIlll.writerIndex() > 32767) {
            throw new IllegalArgumentException("Payload may not be larger than 32767 bytes");
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlIllllllllIllIII) throws IOException {
        llllllllllllllIIlIllllllllIllIII.writeString(this.channel);
        llllllllllllllIIlIllllllllIllIII.writeBytes(this.data);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlIlllllllllIIIlI) throws IOException {
        this.channel = llllllllllllllIIlIlllllllllIIIlI.readStringFromBuffer(20);
        final int llllllllllllllIIlIlllllllllIIIIl = llllllllllllllIIlIlllllllllIIIlI.readableBytes();
        if (llllllllllllllIIlIlllllllllIIIIl >= 0 && llllllllllllllIIlIlllllllllIIIIl <= 32767) {
            this.data = new PacketBuffer(llllllllllllllIIlIlllllllllIIIlI.readBytes(llllllllllllllIIlIlllllllllIIIIl));
            return;
        }
        throw new IOException("Payload may not be larger than 32767 bytes");
    }
    
    public C17PacketCustomPayload() {
    }
    
    static {
        __OBFID = "CL_00001356";
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIlIllllllllIIlIII) {
        this.processPacket((INetHandlerPlayServer)llllllllllllllIIlIllllllllIIlIII);
    }
}
