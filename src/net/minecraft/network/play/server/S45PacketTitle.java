package net.minecraft.network.play.server;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S45PacketTitle implements Packet
{
    private /* synthetic */ IChatComponent field_179810_b;
    private /* synthetic */ Type field_179812_a;
    private /* synthetic */ int field_179808_d;
    private /* synthetic */ int field_179809_e;
    private /* synthetic */ int field_179811_c;
    
    public S45PacketTitle(final int llllllllllllllIIIlllIlllIlllIlll, final int llllllllllllllIIIlllIlllIlllIllI, final int llllllllllllllIIIlllIlllIllllIIl) {
        this(Type.TIMES, null, llllllllllllllIIIlllIlllIlllIlll, llllllllllllllIIIlllIlllIlllIllI, llllllllllllllIIIlllIlllIllllIIl);
    }
    
    public Type func_179807_a() {
        return this.field_179812_a;
    }
    
    static {
        __OBFID = "CL_00002287";
    }
    
    public int func_179803_e() {
        return this.field_179809_e;
    }
    
    public S45PacketTitle(final Type llllllllllllllIIIlllIlllIllIllIl, final IChatComponent llllllllllllllIIIlllIlllIllIIllI, final int llllllllllllllIIIlllIlllIllIlIll, final int llllllllllllllIIIlllIlllIllIlIlI, final int llllllllllllllIIIlllIlllIllIIIll) {
        this.field_179812_a = llllllllllllllIIIlllIlllIllIllIl;
        this.field_179810_b = llllllllllllllIIIlllIlllIllIIllI;
        this.field_179811_c = llllllllllllllIIIlllIlllIllIlIll;
        this.field_179808_d = llllllllllllllIIIlllIlllIllIlIlI;
        this.field_179809_e = llllllllllllllIIIlllIlllIllIIIll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIlllIlllIlIllIIl) throws IOException {
        llllllllllllllIIIlllIlllIlIllIIl.writeEnumValue(this.field_179812_a);
        if (this.field_179812_a == Type.TITLE || this.field_179812_a == Type.SUBTITLE) {
            llllllllllllllIIIlllIlllIlIllIIl.writeChatComponent(this.field_179810_b);
        }
        if (this.field_179812_a == Type.TIMES) {
            llllllllllllllIIIlllIlllIlIllIIl.writeInt(this.field_179811_c);
            llllllllllllllIIIlllIlllIlIllIIl.writeInt(this.field_179808_d);
            llllllllllllllIIIlllIlllIlIllIIl.writeInt(this.field_179809_e);
        }
    }
    
    public S45PacketTitle(final Type llllllllllllllIIIlllIllllIIIIIlI, final IChatComponent llllllllllllllIIIlllIllllIIIIIIl) {
        this(llllllllllllllIIIlllIllllIIIIIlI, llllllllllllllIIIlllIllllIIIIIIl, -1, -1, -1);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIlllIlllIlIlllIl) throws IOException {
        this.field_179812_a = (Type)llllllllllllllIIIlllIlllIlIlllIl.readEnumValue(Type.class);
        if (this.field_179812_a == Type.TITLE || this.field_179812_a == Type.SUBTITLE) {
            this.field_179810_b = llllllllllllllIIIlllIlllIlIlllIl.readChatComponent();
        }
        if (this.field_179812_a == Type.TIMES) {
            this.field_179811_c = llllllllllllllIIIlllIlllIlIlllIl.readInt();
            this.field_179808_d = llllllllllllllIIIlllIlllIlIlllIl.readInt();
            this.field_179809_e = llllllllllllllIIIlllIlllIlIlllIl.readInt();
        }
    }
    
    public int func_179804_d() {
        return this.field_179808_d;
    }
    
    public int func_179806_c() {
        return this.field_179811_c;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIlllIlllIIllllII) {
        this.func_179802_a((INetHandlerPlayClient)llllllllllllllIIIlllIlllIIllllII);
    }
    
    public S45PacketTitle() {
    }
    
    public IChatComponent func_179805_b() {
        return this.field_179810_b;
    }
    
    public void func_179802_a(final INetHandlerPlayClient llllllllllllllIIIlllIlllIlIlIIll) {
        llllllllllllllIIIlllIlllIlIlIIll.func_175099_a(this);
    }
    
    public enum Type
    {
        CLEAR("CLEAR", 3, "CLEAR", 3), 
        TITLE("TITLE", 0, "TITLE", 0), 
        TIMES("TIMES", 2, "TIMES", 2), 
        SUBTITLE("SUBTITLE", 1, "SUBTITLE", 1), 
        RESET("RESET", 4, "RESET", 4);
        
        private Type(final String llllllllllllllIlllllIlIIllIIIlIl, final int llllllllllllllIlllllIlIIllIIIlII, final String llllllllllllllIlllllIlIIllIIlIII, final int llllllllllllllIlllllIlIIllIIIlll) {
        }
        
        public static Type func_179969_a(final String llllllllllllllIlllllIlIIlIlllllI) {
            for (final Type llllllllllllllIlllllIlIIlIlllIlI : values()) {
                if (llllllllllllllIlllllIlIIlIlllIlI.name().equalsIgnoreCase(llllllllllllllIlllllIlIIlIlllllI)) {
                    return llllllllllllllIlllllIlIIlIlllIlI;
                }
            }
            return Type.TITLE;
        }
        
        static {
            __OBFID = "CL_00002286";
        }
        
        public static String[] func_179971_a() {
            final String[] llllllllllllllIlllllIlIIlIlIlllI = new String[values().length];
            int llllllllllllllIlllllIlIIlIlIllIl = 0;
            for (final Type llllllllllllllIlllllIlIIlIlIlIIl : values()) {
                llllllllllllllIlllllIlIIlIlIlllI[llllllllllllllIlllllIlIIlIlIllIl++] = llllllllllllllIlllllIlIIlIlIlIIl.name().toLowerCase();
            }
            return llllllllllllllIlllllIlIIlIlIlllI;
        }
    }
}
