package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class C0CPacketInput implements Packet
{
    private /* synthetic */ boolean sneaking;
    private /* synthetic */ float strafeSpeed;
    private /* synthetic */ boolean jumping;
    private /* synthetic */ float forwardSpeed;
    
    static {
        __OBFID = "CL_00001367";
    }
    
    public float getStrafeSpeed() {
        return this.strafeSpeed;
    }
    
    public float getForwardSpeed() {
        return this.forwardSpeed;
    }
    
    public boolean isJumping() {
        return this.jumping;
    }
    
    public C0CPacketInput(final float lllllllllllllllIlIllIIllIIlIlIll, final float lllllllllllllllIlIllIIllIIlIlIlI, final boolean lllllllllllllllIlIllIIllIIlIlllI, final boolean lllllllllllllllIlIllIIllIIlIlIII) {
        this.strafeSpeed = lllllllllllllllIlIllIIllIIlIlIll;
        this.forwardSpeed = lllllllllllllllIlIllIIllIIlIlIlI;
        this.jumping = lllllllllllllllIlIllIIllIIlIlllI;
        this.sneaking = lllllllllllllllIlIllIIllIIlIlIII;
    }
    
    public void func_180766_a(final INetHandlerPlayServer lllllllllllllllIlIllIIllIIIlIIII) {
        lllllllllllllllIlIllIIllIIIlIIII.processInput(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIllIIllIIlIIIII) throws IOException {
        this.strafeSpeed = lllllllllllllllIlIllIIllIIlIIIII.readFloat();
        this.forwardSpeed = lllllllllllllllIlIllIIllIIlIIIII.readFloat();
        final byte lllllllllllllllIlIllIIllIIlIIIlI = lllllllllllllllIlIllIIllIIlIIIII.readByte();
        this.jumping = ((lllllllllllllllIlIllIIllIIlIIIlI & 0x1) > 0);
        this.sneaking = ((lllllllllllllllIlIllIIllIIlIIIlI & 0x2) > 0);
    }
    
    public C0CPacketInput() {
    }
    
    public boolean isSneaking() {
        return this.sneaking;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIllIIllIIIlIlll) throws IOException {
        lllllllllllllllIlIllIIllIIIlIlll.writeFloat(this.strafeSpeed);
        lllllllllllllllIlIllIIllIIIlIlll.writeFloat(this.forwardSpeed);
        byte lllllllllllllllIlIllIIllIIIllIIl = 0;
        if (this.jumping) {
            lllllllllllllllIlIllIIllIIIllIIl |= 0x1;
        }
        if (this.sneaking) {
            lllllllllllllllIlIllIIllIIIllIIl |= 0x2;
        }
        lllllllllllllllIlIllIIllIIIlIlll.writeByte(lllllllllllllllIlIllIIllIIIllIIl);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIlIllIIlIlllllllI) {
        this.func_180766_a((INetHandlerPlayServer)lllllllllllllllIlIllIIlIlllllllI);
    }
}
