package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class C16PacketClientStatus implements Packet
{
    private /* synthetic */ EnumState status;
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIlllIIIIIIIlIIIIl) {
        this.func_180758_a((INetHandlerPlayServer)llllllllllllllIIlllIIIIIIIlIIIIl);
    }
    
    static {
        __OBFID = "CL_00001348";
    }
    
    public EnumState getStatus() {
        return this.status;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlllIIIIIIIllIllI) throws IOException {
        this.status = (EnumState)llllllllllllllIIlllIIIIIIIllIllI.readEnumValue(EnumState.class);
    }
    
    public void func_180758_a(final INetHandlerPlayServer llllllllllllllIIlllIIIIIIIlIlIII) {
        llllllllllllllIIlllIIIIIIIlIlIII.processClientStatus(this);
    }
    
    public C16PacketClientStatus(final EnumState llllllllllllllIIlllIIIIIIIlllIlI) {
        this.status = llllllllllllllIIlllIIIIIIIlllIlI;
    }
    
    public C16PacketClientStatus() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlllIIIIIIIlIlllI) throws IOException {
        llllllllllllllIIlllIIIIIIIlIlllI.writeEnumValue(this.status);
    }
    
    public enum EnumState
    {
        PERFORM_RESPAWN("PERFORM_RESPAWN", 0, "PERFORM_RESPAWN", 0), 
        OPEN_INVENTORY_ACHIEVEMENT("OPEN_INVENTORY_ACHIEVEMENT", 2, "OPEN_INVENTORY_ACHIEVEMENT", 2), 
        REQUEST_STATS("REQUEST_STATS", 1, "REQUEST_STATS", 1);
        
        static {
            __OBFID = "CL_00001349";
        }
        
        private EnumState(final String lllllllllllllllIlIIlIIlllllIIlII, final int lllllllllllllllIlIIlIIlllllIIIll, final String lllllllllllllllIlIIlIIlllllIIlll, final int lllllllllllllllIlIIlIIlllllIIllI) {
        }
    }
}
