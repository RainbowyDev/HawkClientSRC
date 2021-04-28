package net.minecraft.network.login.server;

import net.minecraft.network.login.*;
import java.io.*;
import net.minecraft.network.*;

public class S03PacketEnableCompression implements Packet
{
    private /* synthetic */ int field_179733_a;
    
    public S03PacketEnableCompression() {
    }
    
    public int func_179731_a() {
        return this.field_179733_a;
    }
    
    public void func_179732_a(final INetHandlerLoginClient lllllllllllllllllIIlIIllllIlIIII) {
        lllllllllllllllllIIlIIllllIlIIII.func_180464_a(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIIlIIllllIlllII) throws IOException {
        this.field_179733_a = lllllllllllllllllIIlIIllllIlllII.readVarIntFromBuffer();
    }
    
    public S03PacketEnableCompression(final int lllllllllllllllllIIlIIlllllIIIlI) {
        this.field_179733_a = lllllllllllllllllIIlIIlllllIIIlI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIIlIIllllIlIlII) throws IOException {
        lllllllllllllllllIIlIIllllIlIlII.writeVarIntToBuffer(this.field_179733_a);
    }
    
    static {
        __OBFID = "CL_00002279";
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllIIlIIllllIIIlll) {
        this.func_179732_a((INetHandlerLoginClient)lllllllllllllllllIIlIIllllIIIlll);
    }
}
