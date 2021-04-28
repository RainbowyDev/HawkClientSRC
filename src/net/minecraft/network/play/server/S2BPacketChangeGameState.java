package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S2BPacketChangeGameState implements Packet
{
    private /* synthetic */ int state;
    private /* synthetic */ float field_149141_c;
    
    public S2BPacketChangeGameState(final int llllllllllllllllIlIlIIIIlIIIlIIl, final float llllllllllllllllIlIlIIIIlIIIlIll) {
        this.state = llllllllllllllllIlIlIIIIlIIIlIIl;
        this.field_149141_c = llllllllllllllllIlIlIIIIlIIIlIll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIlIlIIIIIlllllII) throws IOException {
        llllllllllllllllIlIlIIIIIlllllII.writeByte(this.state);
        llllllllllllllllIlIlIIIIIlllllII.writeFloat(this.field_149141_c);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIlIlIIIIIllIlIlI) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllllIlIlIIIIIllIlIlI);
    }
    
    public S2BPacketChangeGameState() {
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllllIlIlIIIIIllllIII) {
        llllllllllllllllIlIlIIIIIllllIII.handleChangeGameState(this);
    }
    
    public int func_149138_c() {
        return this.state;
    }
    
    public float func_149137_d() {
        return this.field_149141_c;
    }
    
    static {
        __OBFID = "CL_00001301";
        MESSAGE_NAMES = new String[] { "tile.bed.notValid" };
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIlIlIIIIlIIIIIlI) throws IOException {
        this.state = llllllllllllllllIlIlIIIIlIIIIIlI.readUnsignedByte();
        this.field_149141_c = llllllllllllllllIlIlIIIIlIIIIIlI.readFloat();
    }
}
