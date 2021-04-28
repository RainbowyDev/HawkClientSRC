package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S12PacketEntityVelocity implements Packet
{
    private /* synthetic */ int field_149417_a;
    private /* synthetic */ int field_149414_d;
    private /* synthetic */ int field_149415_b;
    private /* synthetic */ int field_149416_c;
    
    public void setMotionY(final int llllllllllllllllIlllIIlllllIIllI) {
        this.field_149416_c = llllllllllllllllIlllIIlllllIIllI;
    }
    
    public void setMotionZ(final int llllllllllllllllIlllIIlllllIIIII) {
        this.field_149414_d = llllllllllllllllIlllIIlllllIIIII;
    }
    
    public int func_149409_f() {
        return this.field_149414_d;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIlllIlIIIIIIIlII) throws IOException {
        llllllllllllllllIlllIlIIIIIIIlII.writeVarIntToBuffer(this.field_149417_a);
        llllllllllllllllIlllIlIIIIIIIlII.writeShort(this.field_149415_b);
        llllllllllllllllIlllIlIIIIIIIlII.writeShort(this.field_149416_c);
        llllllllllllllllIlllIlIIIIIIIlII.writeShort(this.field_149414_d);
    }
    
    public S12PacketEntityVelocity(final Entity llllllllllllllllIlllIlIIIIlIIIII) {
        this(llllllllllllllllIlllIlIIIIlIIIII.getEntityId(), llllllllllllllllIlllIlIIIIlIIIII.motionX, llllllllllllllllIlllIlIIIIlIIIII.motionY, llllllllllllllllIlllIlIIIIlIIIII.motionZ);
    }
    
    public void setMotionX(final int llllllllllllllllIlllIIlllllIllII) {
        this.field_149415_b = llllllllllllllllIlllIIlllllIllII;
    }
    
    public int func_149412_c() {
        return this.field_149417_a;
    }
    
    static {
        __OBFID = "CL_00001328";
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIlllIlIIIIIIlIII) throws IOException {
        this.field_149417_a = llllllllllllllllIlllIlIIIIIIlIII.readVarIntFromBuffer();
        this.field_149415_b = llllllllllllllllIlllIlIIIIIIlIII.readShort();
        this.field_149416_c = llllllllllllllllIlllIlIIIIIIlIII.readShort();
        this.field_149414_d = llllllllllllllllIlllIlIIIIIIlIII.readShort();
    }
    
    public int func_149410_e() {
        return this.field_149416_c;
    }
    
    public int func_149411_d() {
        return this.field_149415_b;
    }
    
    public S12PacketEntityVelocity(final int llllllllllllllllIlllIlIIIIIllIII, double llllllllllllllllIlllIlIIIIIlIIIl, double llllllllllllllllIlllIlIIIIIlIIII, double llllllllllllllllIlllIlIIIIIIllll) {
        this.field_149417_a = llllllllllllllllIlllIlIIIIIllIII;
        final double llllllllllllllllIlllIlIIIIIlIlII = 3.9;
        if (llllllllllllllllIlllIlIIIIIlIIIl < -llllllllllllllllIlllIlIIIIIlIlII) {
            llllllllllllllllIlllIlIIIIIlIIIl = -llllllllllllllllIlllIlIIIIIlIlII;
        }
        if (llllllllllllllllIlllIlIIIIIlIIII < -llllllllllllllllIlllIlIIIIIlIlII) {
            llllllllllllllllIlllIlIIIIIlIIII = -llllllllllllllllIlllIlIIIIIlIlII;
        }
        if (llllllllllllllllIlllIlIIIIIIllll < -llllllllllllllllIlllIlIIIIIlIlII) {
            llllllllllllllllIlllIlIIIIIIllll = -llllllllllllllllIlllIlIIIIIlIlII;
        }
        if (llllllllllllllllIlllIlIIIIIlIIIl > llllllllllllllllIlllIlIIIIIlIlII) {
            llllllllllllllllIlllIlIIIIIlIIIl = llllllllllllllllIlllIlIIIIIlIlII;
        }
        if (llllllllllllllllIlllIlIIIIIlIIII > llllllllllllllllIlllIlIIIIIlIlII) {
            llllllllllllllllIlllIlIIIIIlIIII = llllllllllllllllIlllIlIIIIIlIlII;
        }
        if (llllllllllllllllIlllIlIIIIIIllll > llllllllllllllllIlllIlIIIIIlIlII) {
            llllllllllllllllIlllIlIIIIIIllll = llllllllllllllllIlllIlIIIIIlIlII;
        }
        this.field_149415_b = (int)(llllllllllllllllIlllIlIIIIIlIIIl * 8000.0);
        this.field_149416_c = (int)(llllllllllllllllIlllIlIIIIIlIIII * 8000.0);
        this.field_149414_d = (int)(llllllllllllllllIlllIlIIIIIIllll * 8000.0);
    }
    
    public S12PacketEntityVelocity() {
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllllIlllIIlllllllllI) {
        llllllllllllllllIlllIIlllllllllI.handleEntityVelocity(this);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIlllIIllllIllIII) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllllIlllIIllllIllIII);
    }
}
