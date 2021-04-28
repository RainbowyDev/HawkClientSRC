package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import java.util.*;
import java.io.*;
import net.minecraft.network.*;

public class S20PacketEntityProperties implements Packet
{
    private final /* synthetic */ List field_149444_b;
    private /* synthetic */ int field_149445_a;
    
    public int func_149442_c() {
        return this.field_149445_a;
    }
    
    public List func_149441_d() {
        return this.field_149444_b;
    }
    
    public void func_180754_a(final INetHandlerPlayClient llllllllllllllIlllIlllIIlIlllIII) {
        llllllllllllllIlllIlllIIlIlllIII.handleEntityProperties(this);
    }
    
    public S20PacketEntityProperties(final int llllllllllllllIlllIlllIlIIIIIIll, final Collection llllllllllllllIlllIlllIlIIIIIIIl) {
        this.field_149444_b = Lists.newArrayList();
        this.field_149445_a = llllllllllllllIlllIlllIlIIIIIIll;
        for (final IAttributeInstance llllllllllllllIlllIlllIIllllllIl : llllllllllllllIlllIlllIlIIIIIIIl) {
            this.field_149444_b.add(new Snapshot(llllllllllllllIlllIlllIIllllllIl.getAttribute().getAttributeUnlocalizedName(), llllllllllllllIlllIlllIIllllllIl.getBaseValue(), llllllllllllllIlllIlllIIllllllIl.func_111122_c()));
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlllIlllIIllIllIII) throws IOException {
        this.field_149445_a = llllllllllllllIlllIlllIIllIllIII.readVarIntFromBuffer();
        for (int llllllllllllllIlllIlllIIlllIIIIl = llllllllllllllIlllIlllIIllIllIII.readInt(), llllllllllllllIlllIlllIIlllIIIII = 0; llllllllllllllIlllIlllIIlllIIIII < llllllllllllllIlllIlllIIlllIIIIl; ++llllllllllllllIlllIlllIIlllIIIII) {
            final String llllllllllllllIlllIlllIIllIlllll = llllllllllllllIlllIlllIIllIllIII.readStringFromBuffer(64);
            final double llllllllllllllIlllIlllIIllIllllI = llllllllllllllIlllIlllIIllIllIII.readDouble();
            final ArrayList llllllllllllllIlllIlllIIllIlllIl = Lists.newArrayList();
            for (int llllllllllllllIlllIlllIIllIlllII = llllllllllllllIlllIlllIIllIllIII.readVarIntFromBuffer(), llllllllllllllIlllIlllIIllIllIll = 0; llllllllllllllIlllIlllIIllIllIll < llllllllllllllIlllIlllIIllIlllII; ++llllllllllllllIlllIlllIIllIllIll) {
                final UUID llllllllllllllIlllIlllIIllIllIlI = llllllllllllllIlllIlllIIllIllIII.readUuid();
                llllllllllllllIlllIlllIIllIlllIl.add(new AttributeModifier(llllllllllllllIlllIlllIIllIllIlI, "Unknown synced attribute modifier", llllllllllllllIlllIlllIIllIllIII.readDouble(), llllllllllllllIlllIlllIIllIllIII.readByte()));
            }
            this.field_149444_b.add(new Snapshot(llllllllllllllIlllIlllIIllIlllll, llllllllllllllIlllIlllIIllIllllI, llllllllllllllIlllIlllIIllIlllIl));
        }
    }
    
    static {
        __OBFID = "CL_00001341";
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlllIlllIIlIlIllII) {
        this.func_180754_a((INetHandlerPlayClient)llllllllllllllIlllIlllIIlIlIllII);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlllIlllIIllIIIIlI) throws IOException {
        llllllllllllllIlllIlllIIllIIIIlI.writeVarIntToBuffer(this.field_149445_a);
        llllllllllllllIlllIlllIIllIIIIlI.writeInt(this.field_149444_b.size());
        for (final Snapshot llllllllllllllIlllIlllIIllIIIllI : this.field_149444_b) {
            llllllllllllllIlllIlllIIllIIIIlI.writeString(llllllllllllllIlllIlllIIllIIIllI.func_151409_a());
            llllllllllllllIlllIlllIIllIIIIlI.writeDouble(llllllllllllllIlllIlllIIllIIIllI.func_151410_b());
            llllllllllllllIlllIlllIIllIIIIlI.writeVarIntToBuffer(llllllllllllllIlllIlllIIllIIIllI.func_151408_c().size());
            for (final AttributeModifier llllllllllllllIlllIlllIIllIIIlII : llllllllllllllIlllIlllIIllIIIllI.func_151408_c()) {
                llllllllllllllIlllIlllIIllIIIIlI.writeUuid(llllllllllllllIlllIlllIIllIIIlII.getID());
                llllllllllllllIlllIlllIIllIIIIlI.writeDouble(llllllllllllllIlllIlllIIllIIIlII.getAmount());
                llllllllllllllIlllIlllIIllIIIIlI.writeByte(llllllllllllllIlllIlllIIllIIIlII.getOperation());
            }
        }
    }
    
    public S20PacketEntityProperties() {
        this.field_149444_b = Lists.newArrayList();
    }
    
    public class Snapshot
    {
        private final /* synthetic */ String field_151412_b;
        private final /* synthetic */ double field_151413_c;
        private final /* synthetic */ Collection field_151411_d;
        
        public Snapshot(final String llllllllllllllIlIlIllIlIIllIIIIl, final double llllllllllllllIlIlIllIlIIlIllIll, final Collection llllllllllllllIlIlIllIlIIlIllIlI) {
            this.field_151412_b = llllllllllllllIlIlIllIlIIllIIIIl;
            this.field_151413_c = llllllllllllllIlIlIllIlIIlIllIll;
            this.field_151411_d = llllllllllllllIlIlIllIlIIlIllIlI;
        }
        
        public String func_151409_a() {
            return this.field_151412_b;
        }
        
        static {
            __OBFID = "CL_00001342";
        }
        
        public double func_151410_b() {
            return this.field_151413_c;
        }
        
        public Collection func_151408_c() {
            return this.field_151411_d;
        }
    }
}
