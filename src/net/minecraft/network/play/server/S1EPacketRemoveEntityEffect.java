package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import net.minecraft.potion.*;

public class S1EPacketRemoveEntityEffect implements Packet
{
    private /* synthetic */ int field_149078_b;
    private /* synthetic */ int field_149079_a;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIllIIIIIIIllIl) throws IOException {
        lllllllllllllllIIlIllIIIIIIIllIl.writeVarIntToBuffer(this.field_149079_a);
        lllllllllllllllIIlIllIIIIIIIllIl.writeByte(this.field_149078_b);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIlIlIlllllllllIl) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllIIlIlIlllllllllIl);
    }
    
    public S1EPacketRemoveEntityEffect() {
    }
    
    static {
        __OBFID = "CL_00001321";
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIllIIIIIIlIIll) throws IOException {
        this.field_149079_a = lllllllllllllllIIlIllIIIIIIlIIll.readVarIntFromBuffer();
        this.field_149078_b = lllllllllllllllIIlIllIIIIIIlIIll.readUnsignedByte();
    }
    
    public int func_149075_d() {
        return this.field_149078_b;
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIlIllIIIIIIIlIIl) {
        lllllllllllllllIIlIllIIIIIIIlIIl.handleRemoveEntityEffect(this);
    }
    
    public int func_149076_c() {
        return this.field_149079_a;
    }
    
    public S1EPacketRemoveEntityEffect(final int lllllllllllllllIIlIllIIIIIIllIlI, final PotionEffect lllllllllllllllIIlIllIIIIIIllIIl) {
        this.field_149079_a = lllllllllllllllIIlIllIIIIIIllIlI;
        this.field_149078_b = lllllllllllllllIIlIllIIIIIIllIIl.getPotionID();
    }
}
