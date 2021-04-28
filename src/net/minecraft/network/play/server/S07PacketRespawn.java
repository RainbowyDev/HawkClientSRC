package net.minecraft.network.play.server;

import net.minecraft.world.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S07PacketRespawn implements Packet
{
    private /* synthetic */ WorldSettings.GameType field_149087_c;
    private /* synthetic */ WorldType field_149085_d;
    private /* synthetic */ int field_149088_a;
    private /* synthetic */ EnumDifficulty field_149086_b;
    
    static {
        __OBFID = "CL_00001322";
    }
    
    public S07PacketRespawn(final int llllllllllllllllIlllIIlIlIIlIlII, final EnumDifficulty llllllllllllllllIlllIIlIlIIlIIll, final WorldType llllllllllllllllIlllIIlIlIIlIIlI, final WorldSettings.GameType llllllllllllllllIlllIIlIlIIlIllI) {
        this.field_149088_a = llllllllllllllllIlllIIlIlIIlIlII;
        this.field_149086_b = llllllllllllllllIlllIIlIlIIlIIll;
        this.field_149087_c = llllllllllllllllIlllIIlIlIIlIllI;
        this.field_149085_d = llllllllllllllllIlllIIlIlIIlIIlI;
    }
    
    public int func_149082_c() {
        return this.field_149088_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIlllIIlIlIIIIlll) throws IOException {
        this.field_149088_a = llllllllllllllllIlllIIlIlIIIIlll.readInt();
        this.field_149086_b = EnumDifficulty.getDifficultyEnum(llllllllllllllllIlllIIlIlIIIIlll.readUnsignedByte());
        this.field_149087_c = WorldSettings.GameType.getByID(llllllllllllllllIlllIIlIlIIIIlll.readUnsignedByte());
        this.field_149085_d = WorldType.parseWorldType(llllllllllllllllIlllIIlIlIIIIlll.readStringFromBuffer(16));
        if (this.field_149085_d == null) {
            this.field_149085_d = WorldType.DEFAULT;
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIlllIIlIIlllllll) throws IOException {
        llllllllllllllllIlllIIlIIlllllll.writeInt(this.field_149088_a);
        llllllllllllllllIlllIIlIIlllllll.writeByte(this.field_149086_b.getDifficultyId());
        llllllllllllllllIlllIIlIIlllllll.writeByte(this.field_149087_c.getID());
        llllllllllllllllIlllIIlIIlllllll.writeString(this.field_149085_d.getWorldTypeName());
    }
    
    public EnumDifficulty func_149081_d() {
        return this.field_149086_b;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllllIlllIIlIlIIIlIll) {
        llllllllllllllllIlllIIlIlIIIlIll.handleRespawn(this);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIlllIIlIIllIllll) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllllIlllIIlIIllIllll);
    }
    
    public S07PacketRespawn() {
    }
    
    public WorldType func_149080_f() {
        return this.field_149085_d;
    }
    
    public WorldSettings.GameType func_149083_e() {
        return this.field_149087_c;
    }
}
