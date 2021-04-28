package net.minecraft.network.play.server;

import net.minecraft.network.*;
import net.minecraft.network.play.*;
import java.io.*;
import io.netty.buffer.*;

public class S3FPacketCustomPayload implements Packet
{
    private /* synthetic */ PacketBuffer data;
    private /* synthetic */ String channel;
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIlIIllIlllIlIllI) {
        this.process((INetHandlerPlayClient)lllllllllllllllIIlIIllIlllIlIllI);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIIllIlllllIIlI) throws IOException {
        this.channel = lllllllllllllllIIlIIllIlllllIIlI.readStringFromBuffer(20);
        final int lllllllllllllllIIlIIllIlllllIIIl = lllllllllllllllIIlIIllIlllllIIlI.readableBytes();
        if (lllllllllllllllIIlIIllIlllllIIIl >= 0 && lllllllllllllllIIlIIllIlllllIIIl <= 1048576) {
            this.data = new PacketBuffer(lllllllllllllllIIlIIllIlllllIIlI.readBytes(lllllllllllllllIIlIIllIlllllIIIl));
            return;
        }
        throw new IOException("Payload may not be larger than 1048576 bytes");
    }
    
    public PacketBuffer getBufferData() {
        return this.data;
    }
    
    public S3FPacketCustomPayload() {
    }
    
    static {
        __OBFID = "CL_00001297";
    }
    
    public S3FPacketCustomPayload(final String lllllllllllllllIIlIIllIllllllIll, final PacketBuffer lllllllllllllllIIlIIllIlllllIlll) {
        this.channel = lllllllllllllllIIlIIllIllllllIll;
        this.data = lllllllllllllllIIlIIllIlllllIlll;
        if (lllllllllllllllIIlIIllIlllllIlll.writerIndex() > 1048576) {
            throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
        }
    }
    
    public String getChannelName() {
        return this.channel;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIIllIllllIlIlI) throws IOException {
        lllllllllllllllIIlIIllIllllIlIlI.writeString(this.channel);
        lllllllllllllllIIlIIllIllllIlIlI.writeBytes(this.data);
    }
    
    public void process(final INetHandlerPlayClient lllllllllllllllIIlIIllIllllIIlII) {
        lllllllllllllllIIlIIllIllllIIlII.handleCustomPayload(this);
    }
}
