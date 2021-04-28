package net.minecraft.network.play.server;

import java.util.*;
import net.minecraft.entity.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S1CPacketEntityMetadata implements Packet
{
    private /* synthetic */ int field_149379_a;
    private /* synthetic */ List field_149378_b;
    
    @Override
    public void writePacketData(final PacketBuffer llIIIlllllllI) throws IOException {
        llIIIlllllllI.writeVarIntToBuffer(this.field_149379_a);
        DataWatcher.writeWatchedListToPacketBuffer(this.field_149378_b, llIIIlllllllI);
    }
    
    public S1CPacketEntityMetadata(final int llIIlIIIIlllI, final DataWatcher llIIlIIIIllIl, final boolean llIIlIIIIlIII) {
        this.field_149379_a = llIIlIIIIlllI;
        if (llIIlIIIIlIII) {
            this.field_149378_b = llIIlIIIIllIl.getAllWatched();
        }
        else {
            this.field_149378_b = llIIlIIIIllIl.getChanged();
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llIIlIIIIIlII) throws IOException {
        this.field_149379_a = llIIlIIIIIlII.readVarIntFromBuffer();
        this.field_149378_b = DataWatcher.readWatchedListFromPacketBuffer(llIIlIIIIIlII);
    }
    
    public void func_180748_a(final INetHandlerPlayClient llIIIllllIllI) {
        llIIIllllIllI.handleEntityMetadata(this);
    }
    
    public S1CPacketEntityMetadata() {
    }
    
    public List func_149376_c() {
        return this.field_149378_b;
    }
    
    public int func_149375_d() {
        return this.field_149379_a;
    }
    
    @Override
    public void processPacket(final INetHandler llIIIlllIlIlI) {
        this.func_180748_a((INetHandlerPlayClient)llIIIlllIlIlI);
    }
    
    static {
        __OBFID = "CL_00001326";
    }
}
