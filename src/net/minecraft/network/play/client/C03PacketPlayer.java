package net.minecraft.network.play.client;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class C03PacketPlayer implements Packet
{
    public /* synthetic */ float pitch;
    public /* synthetic */ float yaw;
    public /* synthetic */ boolean rotating;
    public /* synthetic */ boolean field_149480_h;
    public /* synthetic */ double x;
    public /* synthetic */ boolean onground;
    public /* synthetic */ double z;
    public /* synthetic */ double y;
    
    public float getPitch() {
        return this.pitch;
    }
    
    public double getPositionY() {
        return this.y;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIllIIllIIIIllIlI) throws IOException {
        llllllllllllllllIllIIllIIIIllIlI.writeByte(this.onground ? 1 : 0);
    }
    
    public boolean func_149466_j() {
        return this.field_149480_h;
    }
    
    public void processPacket(final INetHandlerPlayServer llllllllllllllllIllIIllIIIlIIllI) {
        llllllllllllllllIllIIllIIIlIIllI.processPlayer(this);
    }
    
    public void func_149469_a(final boolean llllllllllllllllIllIIlIlllllllII) {
        this.field_149480_h = llllllllllllllllIllIIlIlllllllII;
    }
    
    public C03PacketPlayer() {
    }
    
    public C03PacketPlayer(final boolean llllllllllllllllIllIIllIIIlIlllI) {
        this.onground = llllllllllllllllIllIIllIIIlIlllI;
    }
    
    public double getPositionX() {
        return this.x;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIllIIlIllllllIII) {
        this.processPacket((INetHandlerPlayServer)llllllllllllllllIllIIlIllllllIII);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIllIIllIIIlIIIII) throws IOException {
        this.onground = (llllllllllllllllIllIIllIIIlIIIII.readUnsignedByte() != 0);
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    static {
        __OBFID = "CL_00001360";
    }
    
    public boolean func_149465_i() {
        return this.onground;
    }
    
    public double getPositionZ() {
        return this.z;
    }
    
    public boolean getRotating() {
        return this.rotating;
    }
    
    public static class C05PacketPlayerLook extends C03PacketPlayer
    {
        public C05PacketPlayerLook() {
            this.rotating = true;
        }
        
        @Override
        public void processPacket(final INetHandler llllllllllllllIlIIlIIlIlllllIlIl) {
            super.processPacket((INetHandlerPlayServer)llllllllllllllIlIIlIIlIlllllIlIl);
        }
        
        @Override
        public void writePacketData(final PacketBuffer llllllllllllllIlIIlIIlIlllllllIl) throws IOException {
            llllllllllllllIlIIlIIlIlllllllIl.writeFloat(this.yaw);
            llllllllllllllIlIIlIIlIlllllllIl.writeFloat(this.pitch);
            super.writePacketData(llllllllllllllIlIIlIIlIlllllllIl);
        }
        
        static {
            __OBFID = "CL_00001363";
        }
        
        @Override
        public void readPacketData(final PacketBuffer llllllllllllllIlIIlIIllIIIIIIIll) throws IOException {
            this.yaw = llllllllllllllIlIIlIIllIIIIIIIll.readFloat();
            this.pitch = llllllllllllllIlIIlIIllIIIIIIIll.readFloat();
            super.readPacketData(llllllllllllllIlIIlIIllIIIIIIIll);
        }
        
        public C05PacketPlayerLook(final float llllllllllllllIlIIlIIllIIIIIlIIl, final float llllllllllllllIlIIlIIllIIIIIllII, final boolean llllllllllllllIlIIlIIllIIIIIlIll) {
            this.yaw = llllllllllllllIlIIlIIllIIIIIlIIl;
            this.pitch = llllllllllllllIlIIlIIllIIIIIllII;
            this.onground = llllllllllllllIlIIlIIllIIIIIlIll;
            this.rotating = true;
        }
    }
    
    public static class C06PacketPlayerPosLook extends C03PacketPlayer
    {
        @Override
        public void readPacketData(final PacketBuffer llllllllllllllllIIIIlllIIlIIIllI) throws IOException {
            this.x = llllllllllllllllIIIIlllIIlIIIllI.readDouble();
            this.y = llllllllllllllllIIIIlllIIlIIIllI.readDouble();
            this.z = llllllllllllllllIIIIlllIIlIIIllI.readDouble();
            this.yaw = llllllllllllllllIIIIlllIIlIIIllI.readFloat();
            this.pitch = llllllllllllllllIIIIlllIIlIIIllI.readFloat();
            super.readPacketData(llllllllllllllllIIIIlllIIlIIIllI);
        }
        
        @Override
        public void writePacketData(final PacketBuffer llllllllllllllllIIIIlllIIlIIIIlI) throws IOException {
            llllllllllllllllIIIIlllIIlIIIIlI.writeDouble(this.x);
            llllllllllllllllIIIIlllIIlIIIIlI.writeDouble(this.y);
            llllllllllllllllIIIIlllIIlIIIIlI.writeDouble(this.z);
            llllllllllllllllIIIIlllIIlIIIIlI.writeFloat(this.yaw);
            llllllllllllllllIIIIlllIIlIIIIlI.writeFloat(this.pitch);
            super.writePacketData(llllllllllllllllIIIIlllIIlIIIIlI);
        }
        
        static {
            __OBFID = "CL_00001362";
        }
        
        public C06PacketPlayerPosLook() {
            this.field_149480_h = true;
            this.rotating = true;
        }
        
        public C06PacketPlayerPosLook(final double llllllllllllllllIIIIlllIIlIllIII, final double llllllllllllllllIIIIlllIIlIlIIII, final double llllllllllllllllIIIIlllIIlIIllll, final float llllllllllllllllIIIIlllIIlIlIlIl, final float llllllllllllllllIIIIlllIIlIIllIl, final boolean llllllllllllllllIIIIlllIIlIlIIll) {
            this.x = llllllllllllllllIIIIlllIIlIllIII;
            this.y = llllllllllllllllIIIIlllIIlIlIIII;
            this.z = llllllllllllllllIIIIlllIIlIIllll;
            this.yaw = llllllllllllllllIIIIlllIIlIlIlIl;
            this.pitch = llllllllllllllllIIIIlllIIlIIllIl;
            this.onground = llllllllllllllllIIIIlllIIlIlIIll;
            this.rotating = true;
            this.field_149480_h = true;
        }
        
        @Override
        public void processPacket(final INetHandler llllllllllllllllIIIIlllIIIlllIlI) {
            super.processPacket((INetHandlerPlayServer)llllllllllllllllIIIIlllIIIlllIlI);
        }
    }
    
    public static class C04PacketPlayerPosition extends C03PacketPlayer
    {
        @Override
        public void processPacket(final INetHandler lllllllllllllllIllIlIIlIlIllIIII) {
            super.processPacket((INetHandlerPlayServer)lllllllllllllllIllIlIIlIlIllIIII);
        }
        
        public C04PacketPlayerPosition() {
            this.field_149480_h = true;
        }
        
        static {
            __OBFID = "CL_00001361";
        }
        
        @Override
        public void writePacketData(final PacketBuffer lllllllllllllllIllIlIIlIlIllIllI) throws IOException {
            lllllllllllllllIllIlIIlIlIllIllI.writeDouble(this.x);
            lllllllllllllllIllIlIIlIlIllIllI.writeDouble(this.y);
            lllllllllllllllIllIlIIlIlIllIllI.writeDouble(this.z);
            super.writePacketData(lllllllllllllllIllIlIIlIlIllIllI);
        }
        
        @Override
        public void readPacketData(final PacketBuffer lllllllllllllllIllIlIIlIlIllllII) throws IOException {
            this.x = lllllllllllllllIllIlIIlIlIllllII.readDouble();
            this.y = lllllllllllllllIllIlIIlIlIllllII.readDouble();
            this.z = lllllllllllllllIllIlIIlIlIllllII.readDouble();
            super.readPacketData(lllllllllllllllIllIlIIlIlIllllII);
        }
        
        public C04PacketPlayerPosition(final double lllllllllllllllIllIlIIlIllIIlIlI, final double lllllllllllllllIllIlIIlIllIIIlII, final double lllllllllllllllIllIlIIlIllIIlIII, final boolean lllllllllllllllIllIlIIlIllIIIlll) {
            this.x = lllllllllllllllIllIlIIlIllIIlIlI;
            this.y = lllllllllllllllIllIlIIlIllIIIlII;
            this.z = lllllllllllllllIllIlIIlIllIIlIII;
            this.onground = lllllllllllllllIllIlIIlIllIIIlll;
            this.field_149480_h = true;
        }
    }
}
