package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class S06PacketUpdateHealth implements Packet
{
    private /* synthetic */ float saturationLevel;
    private /* synthetic */ float health;
    private /* synthetic */ int foodLevel;
    
    static {
        __OBFID = "CL_00001332";
    }
    
    public void func_180750_a(final INetHandlerPlayClient lllllllllllllllIIlIllIIIllIlllIl) {
        lllllllllllllllIIlIllIIIllIlllIl.handleUpdateHealth(this);
    }
    
    public float getSaturationLevel() {
        return this.saturationLevel;
    }
    
    public float getHealth() {
        return this.health;
    }
    
    public S06PacketUpdateHealth() {
    }
    
    public S06PacketUpdateHealth(final float lllllllllllllllIIlIllIIIllllIIIl, final int lllllllllllllllIIlIllIIIllllIIII, final float lllllllllllllllIIlIllIIIlllIllll) {
        this.health = lllllllllllllllIIlIllIIIllllIIIl;
        this.foodLevel = lllllllllllllllIIlIllIIIllllIIII;
        this.saturationLevel = lllllllllllllllIIlIllIIIlllIllll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIllIIIlllIIlIl) throws IOException {
        lllllllllllllllIIlIllIIIlllIIlIl.writeFloat(this.health);
        lllllllllllllllIIlIllIIIlllIIlIl.writeVarIntToBuffer(this.foodLevel);
        lllllllllllllllIIlIllIIIlllIIlIl.writeFloat(this.saturationLevel);
    }
    
    public int getFoodLevel() {
        return this.foodLevel;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIlIllIIIllIIlllI) {
        this.func_180750_a((INetHandlerPlayClient)lllllllllllllllIIlIllIIIllIIlllI);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIllIIIlllIlIll) throws IOException {
        this.health = lllllllllllllllIIlIllIIIlllIlIll.readFloat();
        this.foodLevel = lllllllllllllllIIlIllIIIlllIlIll.readVarIntFromBuffer();
        this.saturationLevel = lllllllllllllllIIlIllIIIlllIlIll.readFloat();
    }
}
