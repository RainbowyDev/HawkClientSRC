package net.minecraft.network.play.client;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class C0DPacketCloseWindow implements Packet
{
    private /* synthetic */ int windowId;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIllIIIllIIIlllI) throws IOException {
        lllllllllllllllllIllIIIllIIIlllI.writeByte(this.windowId);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllIllIIIllIIIlIII) {
        this.func_180759_a((INetHandlerPlayServer)lllllllllllllllllIllIIIllIIIlIII);
    }
    
    public C0DPacketCloseWindow(final int lllllllllllllllllIllIIIllIIllllI) {
        this.windowId = lllllllllllllllllIllIIIllIIllllI;
    }
    
    public C0DPacketCloseWindow() {
    }
    
    public void func_180759_a(final INetHandlerPlayServer lllllllllllllllllIllIIIllIIllIII) {
        lllllllllllllllllIllIIIllIIllIII.processCloseWindow(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIllIIIllIIlIlII) throws IOException {
        this.windowId = lllllllllllllllllIllIIIllIIlIlII.readByte();
    }
    
    static {
        __OBFID = "CL_00001354";
    }
}
