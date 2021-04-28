package net.minecraft.network.play.client;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class C0APacketAnimation implements Packet
{
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIIIllllIlIIlllll) throws IOException {
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIIIllllIlIIlIIll) {
        this.func_179721_a((INetHandlerPlayServer)llllllllllllllllIIIllllIlIIlIIll);
    }
    
    static {
        __OBFID = "CL_00001345";
    }
    
    public void func_179721_a(final INetHandlerPlayServer llllllllllllllllIIIllllIlIIllIIl) {
        llllllllllllllllIIIllllIlIIllIIl.func_175087_a(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIIIllllIlIIlllIl) throws IOException {
    }
}
