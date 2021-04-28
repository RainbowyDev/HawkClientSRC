package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S2EPacketCloseWindow implements Packet
{
    private /* synthetic */ int field_148896_a;
    
    public S2EPacketCloseWindow(final int llllllllllllllIlllIllIIIlIIIIIlI) {
        this.field_148896_a = llllllllllllllIlllIllIIIlIIIIIlI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlllIllIIIIlllIllI) throws IOException {
        this.field_148896_a = llllllllllllllIlllIllIIIIlllIllI.readUnsignedByte();
    }
    
    public void func_180731_a(final INetHandlerPlayClient llllllllllllllIlllIllIIIIllllIlI) {
        llllllllllllllIlllIllIIIIllllIlI.handleCloseWindow(this);
    }
    
    public S2EPacketCloseWindow() {
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlllIllIIIIllIlIII) {
        this.func_180731_a((INetHandlerPlayClient)llllllllllllllIlllIllIIIIllIlIII);
    }
    
    static {
        __OBFID = "CL_00001292";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlllIllIIIIlllIIII) throws IOException {
        llllllllllllllIlllIllIIIIlllIIII.writeByte(this.field_148896_a);
    }
}
