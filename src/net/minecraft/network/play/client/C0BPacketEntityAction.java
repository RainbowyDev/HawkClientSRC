package net.minecraft.network.play.client;

import net.minecraft.entity.*;
import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class C0BPacketEntityAction implements Packet
{
    private /* synthetic */ Action field_149515_b;
    private /* synthetic */ int field_149516_c;
    private /* synthetic */ int field_149517_a;
    
    public C0BPacketEntityAction(final Entity llIlIlIIlIIlllI, final Action llIlIlIIlIlIIIl, final int llIlIlIIlIIllII) {
        this.field_149517_a = llIlIlIIlIIlllI.getEntityId();
        this.field_149515_b = llIlIlIIlIlIIIl;
        this.field_149516_c = llIlIlIIlIIllII;
    }
    
    public void func_180765_a(final INetHandlerPlayServer llIlIlIIIlllIlI) {
        llIlIlIIIlllIlI.processEntityAction(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llIlIlIIlIIIIlI) throws IOException {
        llIlIlIIlIIIIlI.writeVarIntToBuffer(this.field_149517_a);
        llIlIlIIlIIIIlI.writeEnumValue(this.field_149515_b);
        llIlIlIIlIIIIlI.writeVarIntToBuffer(this.field_149516_c);
    }
    
    public C0BPacketEntityAction(final Entity llIlIlIIlIlllII, final Action llIlIlIIlIllIII) {
        this(llIlIlIIlIlllII, llIlIlIIlIllIII, 0);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llIlIlIIlIIIllI) throws IOException {
        this.field_149517_a = llIlIlIIlIIIllI.readVarIntFromBuffer();
        this.field_149515_b = (Action)llIlIlIIlIIIllI.readEnumValue(Action.class);
        this.field_149516_c = llIlIlIIlIIIllI.readVarIntFromBuffer();
    }
    
    static {
        __OBFID = "CL_00001366";
    }
    
    public int func_149512_e() {
        return this.field_149516_c;
    }
    
    @Override
    public void processPacket(final INetHandler llIlIlIIIlIlllI) {
        this.func_180765_a((INetHandlerPlayServer)llIlIlIIIlIlllI);
    }
    
    public Action func_180764_b() {
        return this.field_149515_b;
    }
    
    public C0BPacketEntityAction() {
    }
    
    public enum Action
    {
        STOP_SLEEPING("STOP_SLEEPING", 2, "STOP_SLEEPING", 2), 
        RIDING_JUMP("RIDING_JUMP", 5, "RIDING_JUMP", 5), 
        STOP_SPRINTING("STOP_SPRINTING", 4, "STOP_SPRINTING", 4), 
        START_SPRINTING("START_SPRINTING", 3, "START_SPRINTING", 3), 
        STOP_SNEAKING("STOP_SNEAKING", 1, "STOP_SNEAKING", 1), 
        START_SNEAKING("START_SNEAKING", 0, "START_SNEAKING", 0), 
        OPEN_INVENTORY("OPEN_INVENTORY", 6, "OPEN_INVENTORY", 6);
        
        static {
            __OBFID = "CL_00002283";
        }
        
        private Action(final String llllllllllllllIlIlllIIlIllIIIIll, final int llllllllllllllIlIlllIIlIllIIIIlI, final String llllllllllllllIlIlllIIlIllIIIllI, final int llllllllllllllIlIlllIIlIllIIIlIl) {
        }
    }
}
