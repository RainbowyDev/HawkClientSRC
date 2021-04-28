package net.minecraft.network.play.server;

import net.minecraft.potion.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S1DPacketEntityEffect implements Packet
{
    private /* synthetic */ byte field_149432_b;
    private /* synthetic */ int field_149434_a;
    private /* synthetic */ byte field_179708_e;
    private /* synthetic */ byte field_149433_c;
    private /* synthetic */ int field_149431_d;
    
    public S1DPacketEntityEffect(final int lllllllllllllllIIIllIllIIlIIllll, final PotionEffect lllllllllllllllIIIllIllIIlIlIIIl) {
        this.field_149434_a = lllllllllllllllIIIllIllIIlIIllll;
        this.field_149432_b = (byte)(lllllllllllllllIIIllIllIIlIlIIIl.getPotionID() & 0xFF);
        this.field_149433_c = (byte)(lllllllllllllllIIIllIllIIlIlIIIl.getAmplifier() & 0xFF);
        if (lllllllllllllllIIIllIllIIlIlIIIl.getDuration() > 32767) {
            this.field_149431_d = 32767;
        }
        else {
            this.field_149431_d = lllllllllllllllIIIllIllIIlIlIIIl.getDuration();
        }
        this.field_179708_e = (byte)(lllllllllllllllIIIllIllIIlIlIIIl.func_180154_f() ? 1 : 0);
    }
    
    static {
        __OBFID = "CL_00001343";
    }
    
    public boolean func_179707_f() {
        return this.field_179708_e != 0;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIllIllIIlIIlIlI) throws IOException {
        this.field_149434_a = lllllllllllllllIIIllIllIIlIIlIlI.readVarIntFromBuffer();
        this.field_149432_b = lllllllllllllllIIIllIllIIlIIlIlI.readByte();
        this.field_149433_c = lllllllllllllllIIIllIllIIlIIlIlI.readByte();
        this.field_149431_d = lllllllllllllllIIIllIllIIlIIlIlI.readVarIntFromBuffer();
        this.field_179708_e = lllllllllllllllIIIllIllIIlIIlIlI.readByte();
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIIllIllIIIlllIIl) {
        lllllllllllllllIIIllIllIIIlllIIl.handleEntityEffect(this);
    }
    
    public boolean func_149429_c() {
        return this.field_149431_d == 32767;
    }
    
    public byte func_149427_e() {
        return this.field_149432_b;
    }
    
    public byte func_149428_f() {
        return this.field_149433_c;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIIllIllIIIlIIllI) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllIIIllIllIIIlIIllI);
    }
    
    public int func_149426_d() {
        return this.field_149434_a;
    }
    
    public S1DPacketEntityEffect() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIllIllIIlIIIlII) throws IOException {
        lllllllllllllllIIIllIllIIlIIIlII.writeVarIntToBuffer(this.field_149434_a);
        lllllllllllllllIIIllIllIIlIIIlII.writeByte(this.field_149432_b);
        lllllllllllllllIIIllIllIIlIIIlII.writeByte(this.field_149433_c);
        lllllllllllllllIIIllIllIIlIIIlII.writeVarIntToBuffer(this.field_149431_d);
        lllllllllllllllIIIllIllIIlIIIlII.writeByte(this.field_179708_e);
    }
    
    public int func_180755_e() {
        return this.field_149431_d;
    }
}
