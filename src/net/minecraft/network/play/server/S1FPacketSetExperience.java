package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S1FPacketSetExperience implements Packet
{
    private /* synthetic */ float field_149401_a;
    private /* synthetic */ int field_149399_b;
    private /* synthetic */ int field_149400_c;
    
    @Override
    public void readPacketData(final PacketBuffer lIIlllIlIIIlI) throws IOException {
        this.field_149401_a = lIIlllIlIIIlI.readFloat();
        this.field_149400_c = lIIlllIlIIIlI.readVarIntFromBuffer();
        this.field_149399_b = lIIlllIlIIIlI.readVarIntFromBuffer();
    }
    
    public float func_149397_c() {
        return this.field_149401_a;
    }
    
    public int func_149396_d() {
        return this.field_149399_b;
    }
    
    public int func_149395_e() {
        return this.field_149400_c;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lIIlllIIlllII) throws IOException {
        lIIlllIIlllII.writeFloat(this.field_149401_a);
        lIIlllIIlllII.writeVarIntToBuffer(this.field_149400_c);
        lIIlllIIlllII.writeVarIntToBuffer(this.field_149399_b);
    }
    
    public void func_180749_a(final INetHandlerPlayClient lIIlllIIlIllI) {
        lIIlllIIlIllI.handleSetExperience(this);
    }
    
    public S1FPacketSetExperience() {
    }
    
    static {
        __OBFID = "CL_00001331";
    }
    
    public S1FPacketSetExperience(final float lIIlllIlIlIII, final int lIIlllIlIIlll, final int lIIlllIlIlIlI) {
        this.field_149401_a = lIIlllIlIlIII;
        this.field_149399_b = lIIlllIlIIlll;
        this.field_149400_c = lIIlllIlIlIlI;
    }
    
    @Override
    public void processPacket(final INetHandler lIIlllIIIIlll) {
        this.func_180749_a((INetHandlerPlayClient)lIIlllIIIIlll);
    }
}
