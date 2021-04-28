package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.util.*;
import java.io.*;
import com.google.common.collect.*;
import net.minecraft.stats.*;

public class S37PacketStatistics implements Packet
{
    private /* synthetic */ Map field_148976_a;
    
    public S37PacketStatistics(final Map llllllllllllllIIlIIllIlllIlIlIIl) {
        this.field_148976_a = llllllllllllllIIlIIllIlllIlIlIIl;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIlIIllIlllIlIIIll) {
        llllllllllllllIIlIIllIlllIlIIIll.handleStatistics(this);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIlIIllIllIllllIlI) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIIlIIllIllIllllIlI);
    }
    
    public Map func_148974_c() {
        return this.field_148976_a;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlIIllIlllIIIlIIl) throws IOException {
        llllllllllllllIIlIIllIlllIIIlIIl.writeVarIntToBuffer(this.field_148976_a.size());
        for (final Map.Entry llllllllllllllIIlIIllIlllIIIIlll : this.field_148976_a.entrySet()) {
            llllllllllllllIIlIIllIlllIIIlIIl.writeString(llllllllllllllIIlIIllIlllIIIIlll.getKey().statId);
            llllllllllllllIIlIIllIlllIIIlIIl.writeVarIntToBuffer(llllllllllllllIIlIIllIlllIIIIlll.getValue());
        }
    }
    
    static {
        __OBFID = "CL_00001283";
    }
    
    public S37PacketStatistics() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlIIllIlllIIllIIl) throws IOException {
        final int llllllllllllllIIlIIllIlllIIllIII = llllllllllllllIIlIIllIlllIIllIIl.readVarIntFromBuffer();
        this.field_148976_a = Maps.newHashMap();
        for (int llllllllllllllIIlIIllIlllIIlIlll = 0; llllllllllllllIIlIIllIlllIIlIlll < llllllllllllllIIlIIllIlllIIllIII; ++llllllllllllllIIlIIllIlllIIlIlll) {
            final StatBase llllllllllllllIIlIIllIlllIIlIllI = StatList.getOneShotStat(llllllllllllllIIlIIllIlllIIllIIl.readStringFromBuffer(32767));
            final int llllllllllllllIIlIIllIlllIIlIlIl = llllllllllllllIIlIIllIlllIIllIIl.readVarIntFromBuffer();
            if (llllllllllllllIIlIIllIlllIIlIllI != null) {
                this.field_148976_a.put(llllllllllllllIIlIIllIlllIIlIllI, llllllllllllllIIlIIllIlllIIlIlIl);
            }
        }
    }
}
