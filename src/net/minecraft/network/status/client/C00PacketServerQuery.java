package net.minecraft.network.status.client;

import net.minecraft.network.status.*;
import net.minecraft.network.*;
import java.io.*;

public class C00PacketServerQuery implements Packet
{
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIlllIIllIIIlllIl) {
        this.func_180775_a((INetHandlerStatusServer)lllllllllllllllIIlllIIllIIIlllIl);
    }
    
    static {
        __OBFID = "CL_00001393";
    }
    
    public void func_180775_a(final INetHandlerStatusServer lllllllllllllllIIlllIIllIIlIIIIl) {
        lllllllllllllllIIlllIIllIIlIIIIl.processServerQuery(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlllIIllIIlIIlll) throws IOException {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlllIIllIIlIlIIl) throws IOException {
    }
}
