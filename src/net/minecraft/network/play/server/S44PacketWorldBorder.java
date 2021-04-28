package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.world.border.*;

public class S44PacketWorldBorder implements Packet
{
    private /* synthetic */ double field_179789_f;
    private /* synthetic */ int field_179797_i;
    private /* synthetic */ Action field_179795_a;
    private /* synthetic */ int field_179796_h;
    private /* synthetic */ double field_179794_c;
    private /* synthetic */ double field_179791_d;
    private /* synthetic */ double field_179792_e;
    private /* synthetic */ long field_179790_g;
    private /* synthetic */ int field_179793_b;
    
    public void func_179787_a(final INetHandlerPlayClient llllllllllllllIIIlIllIIIIIlllIII) {
        llllllllllllllIIIlIllIIIIIlllIII.func_175093_a(this);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIlIllIIIIIlIllII) {
        this.func_179787_a((INetHandlerPlayClient)llllllllllllllIIIlIllIIIIIlIllII);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIlIllIIIIlIIIlII) throws IOException {
        this.field_179795_a = (Action)llllllllllllllIIIlIllIIIIlIIIlII.readEnumValue(Action.class);
        switch (SwitchAction.field_179947_a[this.field_179795_a.ordinal()]) {
            case 1: {
                this.field_179792_e = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                break;
            }
            case 2: {
                this.field_179789_f = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                this.field_179792_e = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                this.field_179790_g = llllllllllllllIIIlIllIIIIlIIIlII.readVarLong();
                break;
            }
            case 3: {
                this.field_179794_c = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                this.field_179791_d = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                break;
            }
            case 4: {
                this.field_179797_i = llllllllllllllIIIlIllIIIIlIIIlII.readVarIntFromBuffer();
                break;
            }
            case 5: {
                this.field_179796_h = llllllllllllllIIIlIllIIIIlIIIlII.readVarIntFromBuffer();
                break;
            }
            case 6: {
                this.field_179794_c = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                this.field_179791_d = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                this.field_179789_f = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                this.field_179792_e = llllllllllllllIIIlIllIIIIlIIIlII.readDouble();
                this.field_179790_g = llllllllllllllIIIlIllIIIIlIIIlII.readVarLong();
                this.field_179793_b = llllllllllllllIIIlIllIIIIlIIIlII.readVarIntFromBuffer();
                this.field_179797_i = llllllllllllllIIIlIllIIIIlIIIlII.readVarIntFromBuffer();
                this.field_179796_h = llllllllllllllIIIlIllIIIIlIIIlII.readVarIntFromBuffer();
                break;
            }
        }
    }
    
    public S44PacketWorldBorder(final WorldBorder llllllllllllllIIIlIllIIIIlIIllII, final Action llllllllllllllIIIlIllIIIIlIIlIll) {
        this.field_179795_a = llllllllllllllIIIlIllIIIIlIIlIll;
        this.field_179794_c = llllllllllllllIIIlIllIIIIlIIllII.getCenterX();
        this.field_179791_d = llllllllllllllIIIlIllIIIIlIIllII.getCenterZ();
        this.field_179789_f = llllllllllllllIIIlIllIIIIlIIllII.getDiameter();
        this.field_179792_e = llllllllllllllIIIlIllIIIIlIIllII.getTargetSize();
        this.field_179790_g = llllllllllllllIIIlIllIIIIlIIllII.getTimeUntilTarget();
        this.field_179793_b = llllllllllllllIIIlIllIIIIlIIllII.getSize();
        this.field_179797_i = llllllllllllllIIIlIllIIIIlIIllII.getWarningDistance();
        this.field_179796_h = llllllllllllllIIIlIllIIIIlIIllII.getWarningTime();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIlIllIIIIIlllllI) throws IOException {
        llllllllllllllIIIlIllIIIIIlllllI.writeEnumValue(this.field_179795_a);
        switch (SwitchAction.field_179947_a[this.field_179795_a.ordinal()]) {
            case 1: {
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179792_e);
                break;
            }
            case 2: {
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179789_f);
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179792_e);
                llllllllllllllIIIlIllIIIIIlllllI.writeVarLong(this.field_179790_g);
                break;
            }
            case 3: {
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179794_c);
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179791_d);
                break;
            }
            case 4: {
                llllllllllllllIIIlIllIIIIIlllllI.writeVarIntToBuffer(this.field_179797_i);
                break;
            }
            case 5: {
                llllllllllllllIIIlIllIIIIIlllllI.writeVarIntToBuffer(this.field_179796_h);
                break;
            }
            case 6: {
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179794_c);
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179791_d);
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179789_f);
                llllllllllllllIIIlIllIIIIIlllllI.writeDouble(this.field_179792_e);
                llllllllllllllIIIlIllIIIIIlllllI.writeVarLong(this.field_179790_g);
                llllllllllllllIIIlIllIIIIIlllllI.writeVarIntToBuffer(this.field_179793_b);
                llllllllllllllIIIlIllIIIIIlllllI.writeVarIntToBuffer(this.field_179797_i);
                llllllllllllllIIIlIllIIIIIlllllI.writeVarIntToBuffer(this.field_179796_h);
                break;
            }
        }
    }
    
    public void func_179788_a(final WorldBorder llllllllllllllIIIlIllIIIIIllIIII) {
        switch (SwitchAction.field_179947_a[this.field_179795_a.ordinal()]) {
            case 1: {
                llllllllllllllIIIlIllIIIIIllIIII.setTransition(this.field_179792_e);
                break;
            }
            case 2: {
                llllllllllllllIIIlIllIIIIIllIIII.setTransition(this.field_179789_f, this.field_179792_e, this.field_179790_g);
                break;
            }
            case 3: {
                llllllllllllllIIIlIllIIIIIllIIII.setCenter(this.field_179794_c, this.field_179791_d);
                break;
            }
            case 4: {
                llllllllllllllIIIlIllIIIIIllIIII.setWarningDistance(this.field_179797_i);
                break;
            }
            case 5: {
                llllllllllllllIIIlIllIIIIIllIIII.setWarningTime(this.field_179796_h);
                break;
            }
            case 6: {
                llllllllllllllIIIlIllIIIIIllIIII.setCenter(this.field_179794_c, this.field_179791_d);
                if (this.field_179790_g > 0L) {
                    llllllllllllllIIIlIllIIIIIllIIII.setTransition(this.field_179789_f, this.field_179792_e, this.field_179790_g);
                }
                else {
                    llllllllllllllIIIlIllIIIIIllIIII.setTransition(this.field_179792_e);
                }
                llllllllllllllIIIlIllIIIIIllIIII.setSize(this.field_179793_b);
                llllllllllllllIIIlIllIIIIIllIIII.setWarningDistance(this.field_179797_i);
                llllllllllllllIIIlIllIIIIIllIIII.setWarningTime(this.field_179796_h);
                break;
            }
        }
    }
    
    static {
        __OBFID = "CL_00002292";
    }
    
    public S44PacketWorldBorder() {
    }
    
    public enum Action
    {
        SET_WARNING_BLOCKS("SET_WARNING_BLOCKS", 5, "SET_WARNING_BLOCKS", 5), 
        SET_WARNING_TIME("SET_WARNING_TIME", 4, "SET_WARNING_TIME", 4), 
        LERP_SIZE("LERP_SIZE", 1, "LERP_SIZE", 1), 
        SET_SIZE("SET_SIZE", 0, "SET_SIZE", 0), 
        INITIALIZE("INITIALIZE", 3, "INITIALIZE", 3), 
        SET_CENTER("SET_CENTER", 2, "SET_CENTER", 2);
        
        static {
            __OBFID = "CL_00002290";
        }
        
        private Action(final String llllllllllllllIIlIlllIlIllllIIll, final int llllllllllllllIIlIlllIlIllllIIlI, final String llllllllllllllIIlIlllIlIllllIllI, final int llllllllllllllIIlIlllIlIllllIlIl) {
        }
    }
    
    static final class SwitchAction
    {
        static final /* synthetic */ int[] field_179947_a;
        
        static {
            __OBFID = "CL_00002291";
            field_179947_a = new int[Action.values().length];
            try {
                SwitchAction.field_179947_a[Action.SET_SIZE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchAction.field_179947_a[Action.LERP_SIZE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchAction.field_179947_a[Action.SET_CENTER.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchAction.field_179947_a[Action.SET_WARNING_BLOCKS.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchAction.field_179947_a[Action.SET_WARNING_TIME.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchAction.field_179947_a[Action.INITIALIZE.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
