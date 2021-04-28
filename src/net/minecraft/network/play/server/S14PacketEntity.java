package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;

public class S14PacketEntity implements Packet
{
    protected /* synthetic */ byte field_149073_c;
    protected /* synthetic */ byte field_149068_f;
    protected /* synthetic */ byte field_149070_d;
    protected /* synthetic */ byte field_149071_e;
    protected /* synthetic */ int field_149074_a;
    protected /* synthetic */ boolean field_179743_g;
    protected /* synthetic */ boolean field_149069_g;
    protected /* synthetic */ byte field_149072_b;
    
    public boolean func_149060_h() {
        return this.field_149069_g;
    }
    
    public byte func_149063_g() {
        return this.field_149068_f;
    }
    
    public byte func_149061_d() {
        return this.field_149073_c;
    }
    
    public byte func_149064_e() {
        return this.field_149070_d;
    }
    
    static {
        __OBFID = "CL_00001312";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIIlIlIlIIlllIII) throws IOException {
        llllllllllllllIlIIIlIlIlIIlllIII.writeVarIntToBuffer(this.field_149074_a);
    }
    
    public S14PacketEntity() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIIlIlIlIIllllII) throws IOException {
        this.field_149074_a = llllllllllllllIlIIIlIlIlIIllllII.readVarIntFromBuffer();
    }
    
    public boolean func_179742_g() {
        return this.field_179743_g;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Entity_").append(super.toString()));
    }
    
    public byte func_149062_c() {
        return this.field_149072_b;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIIIlIlIlIIllIIlI) {
        llllllllllllllIlIIIlIlIlIIllIIlI.handleEntityMovement(this);
    }
    
    public Entity func_149065_a(final World llllllllllllllIlIIIlIlIlIIlIlIIl) {
        return llllllllllllllIlIIIlIlIlIIlIlIIl.getEntityByID(this.field_149074_a);
    }
    
    public S14PacketEntity(final int llllllllllllllIlIIIlIlIlIlIIIIlI) {
        this.field_149074_a = llllllllllllllIlIIIlIlIlIlIIIIlI;
    }
    
    public byte func_149066_f() {
        return this.field_149071_e;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlIIIlIlIlIIIIlllI) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIlIIIlIlIlIIIIlllI);
    }
    
    public static class S16PacketEntityLook extends S14PacketEntity
    {
        @Override
        public void writePacketData(final PacketBuffer lllllllllllllllIllIIlIIIIIlIIIlI) throws IOException {
            super.writePacketData(lllllllllllllllIllIIlIIIIIlIIIlI);
            lllllllllllllllIllIIlIIIIIlIIIlI.writeByte(this.field_149071_e);
            lllllllllllllllIllIIlIIIIIlIIIlI.writeByte(this.field_149068_f);
            lllllllllllllllIllIIlIIIIIlIIIlI.writeBoolean(this.field_179743_g);
        }
        
        public S16PacketEntityLook(final int lllllllllllllllIllIIlIIIIIlIllll, final byte lllllllllllllllIllIIlIIIIIlIlllI, final byte lllllllllllllllIllIIlIIIIIlIllIl, final boolean lllllllllllllllIllIIlIIIIIllIIIl) {
            super(lllllllllllllllIllIIlIIIIIlIllll);
            this.field_149071_e = lllllllllllllllIllIIlIIIIIlIlllI;
            this.field_149068_f = lllllllllllllllIllIIlIIIIIlIllIl;
            this.field_149069_g = true;
            this.field_179743_g = lllllllllllllllIllIIlIIIIIllIIIl;
        }
        
        @Override
        public void readPacketData(final PacketBuffer lllllllllllllllIllIIlIIIIIlIlIII) throws IOException {
            super.readPacketData(lllllllllllllllIllIIlIIIIIlIlIII);
            this.field_149071_e = lllllllllllllllIllIIlIIIIIlIlIII.readByte();
            this.field_149068_f = lllllllllllllllIllIIlIIIIIlIlIII.readByte();
            this.field_179743_g = lllllllllllllllIllIIlIIIIIlIlIII.readBoolean();
        }
        
        public S16PacketEntityLook() {
            this.field_149069_g = true;
        }
        
        static {
            __OBFID = "CL_00001315";
        }
        
        @Override
        public void processPacket(final INetHandler lllllllllllllllIllIIlIIIIIIlllII) {
            super.processPacket((INetHandlerPlayClient)lllllllllllllllIllIIlIIIIIIlllII);
        }
    }
    
    public static class S17PacketEntityLookMove extends S14PacketEntity
    {
        @Override
        public void writePacketData(final PacketBuffer llllllllllllllllIIlIllIIIlIlIlll) throws IOException {
            super.writePacketData(llllllllllllllllIIlIllIIIlIlIlll);
            llllllllllllllllIIlIllIIIlIlIlll.writeByte(this.field_149072_b);
            llllllllllllllllIIlIllIIIlIlIlll.writeByte(this.field_149073_c);
            llllllllllllllllIIlIllIIIlIlIlll.writeByte(this.field_149070_d);
            llllllllllllllllIIlIllIIIlIlIlll.writeByte(this.field_149071_e);
            llllllllllllllllIIlIllIIIlIlIlll.writeByte(this.field_149068_f);
            llllllllllllllllIIlIllIIIlIlIlll.writeBoolean(this.field_179743_g);
        }
        
        static {
            __OBFID = "CL_00001314";
        }
        
        public S17PacketEntityLookMove() {
            this.field_149069_g = true;
        }
        
        @Override
        public void processPacket(final INetHandler llllllllllllllllIIlIllIIIlIIllll) {
            super.processPacket((INetHandlerPlayClient)llllllllllllllllIIlIllIIIlIIllll);
        }
        
        public S17PacketEntityLookMove(final int llllllllllllllllIIlIllIIIllIIlll, final byte llllllllllllllllIIlIllIIIllIlllI, final byte llllllllllllllllIIlIllIIIllIllIl, final byte llllllllllllllllIIlIllIIIllIllII, final byte llllllllllllllllIIlIllIIIllIlIll, final byte llllllllllllllllIIlIllIIIllIlIlI, final boolean llllllllllllllllIIlIllIIIllIIIIl) {
            super(llllllllllllllllIIlIllIIIllIIlll);
            this.field_149072_b = llllllllllllllllIIlIllIIIllIlllI;
            this.field_149073_c = llllllllllllllllIIlIllIIIllIllIl;
            this.field_149070_d = llllllllllllllllIIlIllIIIllIllII;
            this.field_149071_e = llllllllllllllllIIlIllIIIllIlIll;
            this.field_149068_f = llllllllllllllllIIlIllIIIllIlIlI;
            this.field_179743_g = llllllllllllllllIIlIllIIIllIIIIl;
            this.field_149069_g = true;
        }
        
        @Override
        public void readPacketData(final PacketBuffer llllllllllllllllIIlIllIIIlIlllIl) throws IOException {
            super.readPacketData(llllllllllllllllIIlIllIIIlIlllIl);
            this.field_149072_b = llllllllllllllllIIlIllIIIlIlllIl.readByte();
            this.field_149073_c = llllllllllllllllIIlIllIIIlIlllIl.readByte();
            this.field_149070_d = llllllllllllllllIIlIllIIIlIlllIl.readByte();
            this.field_149071_e = llllllllllllllllIIlIllIIIlIlllIl.readByte();
            this.field_149068_f = llllllllllllllllIIlIllIIIlIlllIl.readByte();
            this.field_179743_g = llllllllllllllllIIlIllIIIlIlllIl.readBoolean();
        }
    }
    
    public static class S15PacketEntityRelMove extends S14PacketEntity
    {
        public S15PacketEntityRelMove() {
        }
        
        @Override
        public void writePacketData(final PacketBuffer llllllllllllllIIIllIlIIlllIlIlll) throws IOException {
            super.writePacketData(llllllllllllllIIIllIlIIlllIlIlll);
            llllllllllllllIIIllIlIIlllIlIlll.writeByte(this.field_149072_b);
            llllllllllllllIIIllIlIIlllIlIlll.writeByte(this.field_149073_c);
            llllllllllllllIIIllIlIIlllIlIlll.writeByte(this.field_149070_d);
            llllllllllllllIIIllIlIIlllIlIlll.writeBoolean(this.field_179743_g);
        }
        
        @Override
        public void processPacket(final INetHandler llllllllllllllIIIllIlIIlllIlIIIl) {
            super.processPacket((INetHandlerPlayClient)llllllllllllllIIIllIlIIlllIlIIIl);
        }
        
        @Override
        public void readPacketData(final PacketBuffer llllllllllllllIIIllIlIIlllIlllIl) throws IOException {
            super.readPacketData(llllllllllllllIIIllIlIIlllIlllIl);
            this.field_149072_b = llllllllllllllIIIllIlIIlllIlllIl.readByte();
            this.field_149073_c = llllllllllllllIIIllIlIIlllIlllIl.readByte();
            this.field_149070_d = llllllllllllllIIIllIlIIlllIlllIl.readByte();
            this.field_179743_g = llllllllllllllIIIllIlIIlllIlllIl.readBoolean();
        }
        
        public S15PacketEntityRelMove(final int llllllllllllllIIIllIlIIllllIIlIl, final byte llllllllllllllIIIllIlIIllllIIlII, final byte llllllllllllllIIIllIlIIllllIlIIl, final byte llllllllllllllIIIllIlIIllllIIIlI, final boolean llllllllllllllIIIllIlIIllllIIlll) {
            super(llllllllllllllIIIllIlIIllllIIlIl);
            this.field_149072_b = llllllllllllllIIIllIlIIllllIIlII;
            this.field_149073_c = llllllllllllllIIIllIlIIllllIlIIl;
            this.field_149070_d = llllllllllllllIIIllIlIIllllIIIlI;
            this.field_179743_g = llllllllllllllIIIllIlIIllllIIlll;
        }
        
        static {
            __OBFID = "CL_00001313";
        }
    }
}
