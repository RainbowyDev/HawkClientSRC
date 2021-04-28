package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S0DPacketCollectItem implements Packet
{
    private /* synthetic */ int field_149357_a;
    private /* synthetic */ int field_149356_b;
    
    public S0DPacketCollectItem(final int lIIIllllllII, final int lIIIlllllIll) {
        this.field_149357_a = lIIIllllllII;
        this.field_149356_b = lIIIlllllIll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lIIIllllIlll) throws IOException {
        this.field_149357_a = lIIIllllIlll.readVarIntFromBuffer();
        this.field_149356_b = lIIIllllIlll.readVarIntFromBuffer();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lIIIllllIIIl) throws IOException {
        lIIIllllIIIl.writeVarIntToBuffer(this.field_149357_a);
        lIIIllllIIIl.writeVarIntToBuffer(this.field_149356_b);
    }
    
    public int func_149353_d() {
        return this.field_149356_b;
    }
    
    public int func_149354_c() {
        return this.field_149357_a;
    }
    
    public void processPacket(final INetHandlerPlayClient lIIIlllIlIIl) {
        lIIIlllIlIIl.handleCollectItem(this);
    }
    
    static {
        __OBFID = "CL_00001339";
    }
    
    public S0DPacketCollectItem() {
    }
    
    @Override
    public void processPacket(final INetHandler lIIIllIlllIl) {
        this.processPacket((INetHandlerPlayClient)lIIIllIlllIl);
    }
}
