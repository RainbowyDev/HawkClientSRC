package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.network.*;

public class S43PacketCamera implements Packet
{
    public /* synthetic */ int field_179781_a;
    
    public void func_179779_a(final INetHandlerPlayClient llllllllllllllIIIlIlIlIlIlllIllI) {
        llllllllllllllIIIlIlIlIlIlllIllI.func_175094_a(this);
    }
    
    public S43PacketCamera() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIlIlIlIlIlllllII) throws IOException {
        llllllllllllllIIIlIlIlIlIlllllII.writeVarIntToBuffer(this.field_179781_a);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIlIlIlIllIIIIIII) throws IOException {
        this.field_179781_a = llllllllllllllIIIlIlIlIllIIIIIII.readVarIntFromBuffer();
    }
    
    public S43PacketCamera(final Entity llllllllllllllIIIlIlIlIllIIIlIII) {
        this.field_179781_a = llllllllllllllIIIlIlIlIllIIIlIII.getEntityId();
    }
    
    static {
        __OBFID = "CL_00002289";
    }
    
    public Entity func_179780_a(final World llllllllllllllIIIlIlIlIlIllIlllI) {
        return llllllllllllllIIIlIlIlIlIllIlllI.getEntityByID(this.field_179781_a);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIlIlIlIlIllIlIII) {
        this.func_179779_a((INetHandlerPlayClient)llllllllllllllIIIlIlIlIlIllIlIII);
    }
}
