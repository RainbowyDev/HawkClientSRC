package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S48PacketResourcePackSend implements Packet
{
    private /* synthetic */ String hash;
    private /* synthetic */ String url;
    
    static {
        __OBFID = "CL_00002293";
    }
    
    public S48PacketResourcePackSend() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlIIlllIIlIlIIlIl) throws IOException {
        llllllllllllllIIlIIlllIIlIlIIlIl.writeString(this.url);
        llllllllllllllIIlIIlllIIlIlIIlIl.writeString(this.hash);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlIIlllIIlIlIlIll) throws IOException {
        this.url = llllllllllllllIIlIIlllIIlIlIlIll.readStringFromBuffer(32767);
        this.hash = llllllllllllllIIlIIlllIIlIlIlIll.readStringFromBuffer(40);
    }
    
    public S48PacketResourcePackSend(final String llllllllllllllIIlIIlllIIlIllIIlI, final String llllllllllllllIIlIIlllIIlIllIIIl) {
        this.url = llllllllllllllIIlIIlllIIlIllIIlI;
        this.hash = llllllllllllllIIlIIlllIIlIllIIIl;
        if (llllllllllllllIIlIIlllIIlIllIIIl.length() > 40) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Hash is too long (max 40, was ").append(llllllllllllllIIlIIlllIIlIllIIIl.length()).append(")")));
        }
    }
    
    public String func_179783_a() {
        return this.url;
    }
    
    public String func_179784_b() {
        return this.hash;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIlIIlllIIlIlIIIIl) {
        llllllllllllllIIlIIlllIIlIlIIIIl.func_175095_a(this);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIlIIlllIIlIIlIlIl) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIIlIIlllIIlIIlIlIl);
    }
}
