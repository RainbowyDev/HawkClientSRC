package net.minecraft.network.play.server;

import net.minecraft.entity.player.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S39PacketPlayerAbilities implements Packet
{
    private /* synthetic */ float flySpeed;
    private /* synthetic */ float walkSpeed;
    private /* synthetic */ boolean allowFlying;
    private /* synthetic */ boolean flying;
    private /* synthetic */ boolean invulnerable;
    private /* synthetic */ boolean creativeMode;
    
    public boolean isInvulnerable() {
        return this.invulnerable;
    }
    
    public S39PacketPlayerAbilities(final PlayerCapabilities lllllllllllllllIIlIlIlIIIlIlIIll) {
        this.setInvulnerable(lllllllllllllllIIlIlIlIIIlIlIIll.disableDamage);
        this.setFlying(lllllllllllllllIIlIlIlIIIlIlIIll.isFlying);
        this.setAllowFlying(lllllllllllllllIIlIlIlIIIlIlIIll.allowFlying);
        this.setCreativeMode(lllllllllllllllIIlIlIlIIIlIlIIll.isCreativeMode);
        this.setFlySpeed(lllllllllllllllIIlIlIlIIIlIlIIll.getFlySpeed());
        this.setWalkSpeed(lllllllllllllllIIlIlIlIIIlIlIIll.getWalkSpeed());
    }
    
    public void setFlying(final boolean lllllllllllllllIIlIlIlIIIIlIlIIl) {
        this.flying = lllllllllllllllIIlIlIlIIIIlIlIIl;
    }
    
    public float getFlySpeed() {
        return this.flySpeed;
    }
    
    public void setFlySpeed(final float lllllllllllllllIIlIlIlIIIIIlIIII) {
        this.flySpeed = lllllllllllllllIIlIlIlIIIIIlIIII;
    }
    
    public S39PacketPlayerAbilities() {
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIlIlIlIIIIIIIIIl) {
        this.func_180742_a((INetHandlerPlayClient)lllllllllllllllIIlIlIlIIIIIIIIIl);
    }
    
    public void setCreativeMode(final boolean lllllllllllllllIIlIlIlIIIIIlIlll) {
        this.creativeMode = lllllllllllllllIIlIlIlIIIIIlIlll;
    }
    
    public boolean isAllowFlying() {
        return this.allowFlying;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIlIlIIIlIIlllI) throws IOException {
        final byte lllllllllllllllIIlIlIlIIIlIIllIl = lllllllllllllllIIlIlIlIIIlIIlllI.readByte();
        this.setInvulnerable((lllllllllllllllIIlIlIlIIIlIIllIl & 0x1) > 0);
        this.setFlying((lllllllllllllllIIlIlIlIIIlIIllIl & 0x2) > 0);
        this.setAllowFlying((lllllllllllllllIIlIlIlIIIlIIllIl & 0x4) > 0);
        this.setCreativeMode((lllllllllllllllIIlIlIlIIIlIIllIl & 0x8) > 0);
        this.setFlySpeed(lllllllllllllllIIlIlIlIIIlIIlllI.readFloat());
        this.setWalkSpeed(lllllllllllllllIIlIlIlIIIlIIlllI.readFloat());
    }
    
    static {
        __OBFID = "CL_00001317";
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIlIlIIIlIIIlIl) throws IOException {
        byte lllllllllllllllIIlIlIlIIIlIIIlII = 0;
        if (this.isInvulnerable()) {
            lllllllllllllllIIlIlIlIIIlIIIlII |= 0x1;
        }
        if (this.isFlying()) {
            lllllllllllllllIIlIlIlIIIlIIIlII |= 0x2;
        }
        if (this.isAllowFlying()) {
            lllllllllllllllIIlIlIlIIIlIIIlII |= 0x4;
        }
        if (this.isCreativeMode()) {
            lllllllllllllllIIlIlIlIIIlIIIlII |= 0x8;
        }
        lllllllllllllllIIlIlIlIIIlIIIlIl.writeByte(lllllllllllllllIIlIlIlIIIlIIIlII);
        lllllllllllllllIIlIlIlIIIlIIIlIl.writeFloat(this.flySpeed);
        lllllllllllllllIIlIlIlIIIlIIIlIl.writeFloat(this.walkSpeed);
    }
    
    public void setAllowFlying(final boolean lllllllllllllllIIlIlIlIIIIlIIIlI) {
        this.allowFlying = lllllllllllllllIIlIlIlIIIIlIIIlI;
    }
    
    public boolean isFlying() {
        return this.flying;
    }
    
    public boolean isCreativeMode() {
        return this.creativeMode;
    }
    
    public void setInvulnerable(final boolean lllllllllllllllIIlIlIlIIIIllIlII) {
        this.invulnerable = lllllllllllllllIIlIlIlIIIIllIlII;
    }
    
    public void setWalkSpeed(final float lllllllllllllllIIlIlIlIIIIIIIlll) {
        this.walkSpeed = lllllllllllllllIIlIlIlIIIIIIIlll;
    }
    
    public void func_180742_a(final INetHandlerPlayClient lllllllllllllllIIlIlIlIIIIllllIl) {
        lllllllllllllllIIlIlIlIIIIllllIl.handlePlayerAbilities(this);
    }
    
    public float getWalkSpeed() {
        return this.walkSpeed;
    }
}
