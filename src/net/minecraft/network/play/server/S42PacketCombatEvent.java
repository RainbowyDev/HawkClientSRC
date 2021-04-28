package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class S42PacketCombatEvent implements Packet
{
    public /* synthetic */ Event field_179776_a;
    public /* synthetic */ String field_179773_e;
    public /* synthetic */ int field_179775_c;
    public /* synthetic */ int field_179772_d;
    public /* synthetic */ int field_179774_b;
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIIlllllIIIllIlIl) {
        this.func_179771_a((INetHandlerPlayClient)lllllllllllllllIIIlllllIIIllIlIl);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIlllllIIlIIIIll) throws IOException {
        lllllllllllllllIIIlllllIIlIIIIll.writeEnumValue(this.field_179776_a);
        if (this.field_179776_a == Event.END_COMBAT) {
            lllllllllllllllIIIlllllIIlIIIIll.writeVarIntToBuffer(this.field_179772_d);
            lllllllllllllllIIIlllllIIlIIIIll.writeInt(this.field_179775_c);
        }
        else if (this.field_179776_a == Event.ENTITY_DIED) {
            lllllllllllllllIIIlllllIIlIIIIll.writeVarIntToBuffer(this.field_179774_b);
            lllllllllllllllIIIlllllIIlIIIIll.writeInt(this.field_179775_c);
            lllllllllllllllIIIlllllIIlIIIIll.writeString(this.field_179773_e);
        }
    }
    
    public void func_179771_a(final INetHandlerPlayClient lllllllllllllllIIIlllllIIIllllIl) {
        lllllllllllllllIIIlllllIIIllllIl.func_175098_a(this);
    }
    
    static {
        __OBFID = "CL_00002299";
    }
    
    public S42PacketCombatEvent() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIlllllIIlIIIlll) throws IOException {
        this.field_179776_a = (Event)lllllllllllllllIIIlllllIIlIIIlll.readEnumValue(Event.class);
        if (this.field_179776_a == Event.END_COMBAT) {
            this.field_179772_d = lllllllllllllllIIIlllllIIlIIIlll.readVarIntFromBuffer();
            this.field_179775_c = lllllllllllllllIIIlllllIIlIIIlll.readInt();
        }
        else if (this.field_179776_a == Event.ENTITY_DIED) {
            this.field_179774_b = lllllllllllllllIIIlllllIIlIIIlll.readVarIntFromBuffer();
            this.field_179775_c = lllllllllllllllIIIlllllIIlIIIlll.readInt();
            this.field_179773_e = lllllllllllllllIIIlllllIIlIIIlll.readStringFromBuffer(32767);
        }
    }
    
    public S42PacketCombatEvent(final CombatTracker lllllllllllllllIIIlllllIIlIIllll, final Event lllllllllllllllIIIlllllIIlIIlllI) {
        this.field_179776_a = lllllllllllllllIIIlllllIIlIIlllI;
        final EntityLivingBase lllllllllllllllIIIlllllIIlIlIIIl = lllllllllllllllIIIlllllIIlIIllll.func_94550_c();
        switch (SwitchEvent.field_179944_a[lllllllllllllllIIIlllllIIlIIlllI.ordinal()]) {
            case 1: {
                this.field_179772_d = lllllllllllllllIIIlllllIIlIIllll.func_180134_f();
                this.field_179775_c = ((lllllllllllllllIIIlllllIIlIlIIIl == null) ? -1 : lllllllllllllllIIIlllllIIlIlIIIl.getEntityId());
                break;
            }
            case 2: {
                this.field_179774_b = lllllllllllllllIIIlllllIIlIIllll.func_180135_h().getEntityId();
                this.field_179775_c = ((lllllllllllllllIIIlllllIIlIlIIIl == null) ? -1 : lllllllllllllllIIIlllllIIlIlIIIl.getEntityId());
                this.field_179773_e = lllllllllllllllIIIlllllIIlIIllll.func_151521_b().getUnformattedText();
                break;
            }
        }
    }
    
    public enum Event
    {
        END_COMBAT("END_COMBAT", 1, "END_COMBAT", 1), 
        ENTER_COMBAT("ENTER_COMBAT", 0, "ENTER_COMBAT", 0), 
        ENTITY_DIED("ENTITY_DIED", 2, "ENTITY_DIED", 2);
        
        private Event(final String lllllllllllllllIlIlIlIlIIlIlIlII, final int lllllllllllllllIlIlIlIlIIlIlIIll, final String lllllllllllllllIlIlIlIlIIlIlIlll, final int lllllllllllllllIlIlIlIlIIlIlIllI) {
        }
        
        static {
            __OBFID = "CL_00002297";
        }
    }
    
    static final class SwitchEvent
    {
        static final /* synthetic */ int[] field_179944_a;
        
        static {
            __OBFID = "CL_00002298";
            field_179944_a = new int[Event.values().length];
            try {
                SwitchEvent.field_179944_a[Event.END_COMBAT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEvent.field_179944_a[Event.ENTITY_DIED.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
        }
    }
}
