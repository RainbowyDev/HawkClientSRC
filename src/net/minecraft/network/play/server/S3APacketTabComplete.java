package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S3APacketTabComplete implements Packet
{
    private /* synthetic */ String[] field_149632_a;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIIlIlllIlIlIlII) throws IOException {
        this.field_149632_a = new String[lllllllllllllllIlIIlIlllIlIlIlII.readVarIntFromBuffer()];
        for (int lllllllllllllllIlIIlIlllIlIlIIll = 0; lllllllllllllllIlIIlIlllIlIlIIll < this.field_149632_a.length; ++lllllllllllllllIlIIlIlllIlIlIIll) {
            this.field_149632_a[lllllllllllllllIlIIlIlllIlIlIIll] = lllllllllllllllIlIIlIlllIlIlIlII.readStringFromBuffer(32767);
        }
    }
    
    public S3APacketTabComplete(final String[] lllllllllllllllIlIIlIlllIlIllIIl) {
        this.field_149632_a = lllllllllllllllIlIIlIlllIlIllIIl;
    }
    
    static {
        __OBFID = "CL_00001288";
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIIlIlllIlIIlIII) throws IOException {
        lllllllllllllllIlIIlIlllIlIIlIII.writeVarIntToBuffer(this.field_149632_a.length);
        for (final String lllllllllllllllIlIIlIlllIlIIIlII : this.field_149632_a) {
            lllllllllllllllIlIIlIlllIlIIlIII.writeString(lllllllllllllllIlIIlIlllIlIIIlII);
        }
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIlIIlIlllIIlllIII) {
        lllllllllllllllIlIIlIlllIIlllIII.handleTabComplete(this);
    }
    
    public S3APacketTabComplete() {
    }
    
    public String[] func_149630_c() {
        return this.field_149632_a;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIlIIlIlllIIlIllll) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllIlIIlIlllIIlIllll);
    }
}
