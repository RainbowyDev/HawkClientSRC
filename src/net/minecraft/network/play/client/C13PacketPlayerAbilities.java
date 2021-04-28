package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;

public class C13PacketPlayerAbilities implements Packet
{
    private /* synthetic */ boolean invulnerable;
    private /* synthetic */ boolean flying;
    private /* synthetic */ boolean creativeMode;
    private /* synthetic */ float flySpeed;
    private /* synthetic */ float walkSpeed;
    private /* synthetic */ boolean allowFlying;
    
    public boolean isAllowFlying() {
        return this.allowFlying;
    }
    
    public boolean isFlying() {
        return this.flying;
    }
    
    public void func_180761_a(final INetHandlerPlayServer lllllllllllllllllIlIIlllllllIIlI) {
        lllllllllllllllllIlIIlllllllIIlI.processPlayerAbilities(this);
    }
    
    public boolean isInvulnerable() {
        return this.invulnerable;
    }
    
    static {
        __OBFID = "CL_00001364";
    }
    
    public void setCreativeMode(final boolean lllllllllllllllllIlIIlllllIIllII) {
        this.creativeMode = lllllllllllllllllIlIIlllllIIllII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIlIIlllllllIlll) throws IOException {
        byte lllllllllllllllllIlIIllllllllIIl = 0;
        if (this.isInvulnerable()) {
            lllllllllllllllllIlIIllllllllIIl |= 0x1;
        }
        if (this.isFlying()) {
            lllllllllllllllllIlIIllllllllIIl |= 0x2;
        }
        if (this.isAllowFlying()) {
            lllllllllllllllllIlIIllllllllIIl |= 0x4;
        }
        if (this.isCreativeMode()) {
            lllllllllllllllllIlIIllllllllIIl |= 0x8;
        }
        lllllllllllllllllIlIIlllllllIlll.writeByte(lllllllllllllllllIlIIllllllllIIl);
        lllllllllllllllllIlIIlllllllIlll.writeFloat(this.flySpeed);
        lllllllllllllllllIlIIlllllllIlll.writeFloat(this.walkSpeed);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllIlIIllllIlllIlI) {
        this.func_180761_a((INetHandlerPlayServer)lllllllllllllllllIlIIllllIlllIlI);
    }
    
    public void setFlySpeed(final float lllllllllllllllllIlIIlllllIIlIII) {
        this.flySpeed = lllllllllllllllllIlIIlllllIIlIII;
    }
    
    public void setFlying(final boolean lllllllllllllllllIlIIllllllIIIII) {
        this.flying = lllllllllllllllllIlIIllllllIIIII;
    }
    
    public void setWalkSpeed(final float lllllllllllllllllIlIIlllllIIIIlI) {
        this.walkSpeed = lllllllllllllllllIlIIlllllIIIIlI;
    }
    
    public void setAllowFlying(final boolean lllllllllllllllllIlIIlllllIlIlIl) {
        this.allowFlying = lllllllllllllllllIlIIlllllIlIlIl;
    }
    
    public C13PacketPlayerAbilities() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIlIlIIIIIIIIIII) throws IOException {
        final byte lllllllllllllllllIlIlIIIIIIIIIlI = lllllllllllllllllIlIlIIIIIIIIIII.readByte();
        this.setInvulnerable((lllllllllllllllllIlIlIIIIIIIIIlI & 0x1) > 0);
        this.setFlying((lllllllllllllllllIlIlIIIIIIIIIlI & 0x2) > 0);
        this.setAllowFlying((lllllllllllllllllIlIlIIIIIIIIIlI & 0x4) > 0);
        this.setCreativeMode((lllllllllllllllllIlIlIIIIIIIIIlI & 0x8) > 0);
        this.setFlySpeed(lllllllllllllllllIlIlIIIIIIIIIII.readFloat());
        this.setWalkSpeed(lllllllllllllllllIlIlIIIIIIIIIII.readFloat());
    }
    
    public void setInvulnerable(final boolean lllllllllllllllllIlIIllllllIIlll) {
        this.invulnerable = lllllllllllllllllIlIIllllllIIlll;
    }
    
    public C13PacketPlayerAbilities(final PlayerCapabilities lllllllllllllllllIlIlIIIIIIIlIlI) {
        this.setInvulnerable(lllllllllllllllllIlIlIIIIIIIlIlI.disableDamage);
        this.setFlying(lllllllllllllllllIlIlIIIIIIIlIlI.isFlying);
        this.setAllowFlying(lllllllllllllllllIlIlIIIIIIIlIlI.allowFlying);
        this.setCreativeMode(lllllllllllllllllIlIlIIIIIIIlIlI.isCreativeMode);
        this.setFlySpeed(lllllllllllllllllIlIlIIIIIIIlIlI.getFlySpeed());
        this.setWalkSpeed(lllllllllllllllllIlIlIIIIIIIlIlI.getWalkSpeed());
    }
    
    public boolean isCreativeMode() {
        return this.creativeMode;
    }
}
