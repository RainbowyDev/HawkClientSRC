package net.minecraft.network.handshake.client;

import java.io.*;
import net.minecraft.network.handshake.*;
import net.minecraft.network.*;

public class C00Handshake implements Packet
{
    private /* synthetic */ int port;
    private /* synthetic */ String ip;
    private /* synthetic */ EnumConnectionState requestedState;
    private /* synthetic */ int protocolVersion;
    
    static {
        __OBFID = "CL_00001372";
    }
    
    public EnumConnectionState getRequestedState() {
        return this.requestedState;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIllIIIIlIIIlII) throws IOException {
        lllllllllllllllIIlIllIIIIlIIIlII.writeVarIntToBuffer(this.protocolVersion);
        lllllllllllllllIIlIllIIIIlIIIlII.writeString(this.ip);
        lllllllllllllllIIlIllIIIIlIIIlII.writeShort(this.port);
        lllllllllllllllIIlIllIIIIlIIIlII.writeVarIntToBuffer(this.requestedState.getId());
    }
    
    public void func_180770_a(final INetHandlerHandshakeServer lllllllllllllllIIlIllIIIIlIIIIII) {
        lllllllllllllllIIlIllIIIIlIIIIII.processHandshake(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIllIIIIlIIlIlI) throws IOException {
        this.protocolVersion = lllllllllllllllIIlIllIIIIlIIlIlI.readVarIntFromBuffer();
        this.ip = lllllllllllllllIIlIllIIIIlIIlIlI.readStringFromBuffer(255);
        this.port = lllllllllllllllIIlIllIIIIlIIlIlI.readUnsignedShort();
        this.requestedState = EnumConnectionState.getById(lllllllllllllllIIlIllIIIIlIIlIlI.readVarIntFromBuffer());
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIlIllIIIIIllIlII) {
        this.func_180770_a((INetHandlerHandshakeServer)lllllllllllllllIIlIllIIIIIllIlII);
    }
    
    public C00Handshake(final int lllllllllllllllIIlIllIIIIlIllIII, final String lllllllllllllllIIlIllIIIIlIlIIlI, final int lllllllllllllllIIlIllIIIIlIlIllI, final EnumConnectionState lllllllllllllllIIlIllIIIIlIlIIII) {
        this.protocolVersion = lllllllllllllllIIlIllIIIIlIllIII;
        this.ip = lllllllllllllllIIlIllIIIIlIlIIlI;
        this.port = lllllllllllllllIIlIllIIIIlIlIllI;
        this.requestedState = lllllllllllllllIIlIllIIIIlIlIIII;
    }
    
    public C00Handshake() {
    }
    
    public int getProtocolVersion() {
        return this.protocolVersion;
    }
}
