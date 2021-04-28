package net.minecraft.network.play.server;

import net.minecraft.world.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S01PacketJoinGame implements Packet
{
    private /* synthetic */ EnumDifficulty field_149203_e;
    private /* synthetic */ int field_149200_f;
    private /* synthetic */ int field_149202_d;
    private /* synthetic */ boolean field_149204_b;
    private /* synthetic */ int field_149206_a;
    private /* synthetic */ WorldSettings.GameType field_149205_c;
    private /* synthetic */ boolean field_179745_h;
    private /* synthetic */ WorldType field_149201_g;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllllIlllIlllIIlIl) throws IOException {
        lllllllllllllllllllIlllIlllIIlIl.writeInt(this.field_149206_a);
        int lllllllllllllllllllIlllIlllIIlll = this.field_149205_c.getID();
        if (this.field_149204_b) {
            lllllllllllllllllllIlllIlllIIlll |= 0x8;
        }
        lllllllllllllllllllIlllIlllIIlIl.writeByte(lllllllllllllllllllIlllIlllIIlll);
        lllllllllllllllllllIlllIlllIIlIl.writeByte(this.field_149202_d);
        lllllllllllllllllllIlllIlllIIlIl.writeByte(this.field_149203_e.getDifficultyId());
        lllllllllllllllllllIlllIlllIIlIl.writeByte(this.field_149200_f);
        lllllllllllllllllllIlllIlllIIlIl.writeString(this.field_149201_g.getWorldTypeName());
        lllllllllllllllllllIlllIlllIIlIl.writeBoolean(this.field_179745_h);
    }
    
    public WorldType func_149196_i() {
        return this.field_149201_g;
    }
    
    public EnumDifficulty func_149192_g() {
        return this.field_149203_e;
    }
    
    public int func_149194_f() {
        return this.field_149202_d;
    }
    
    public S01PacketJoinGame() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllllIlllIllllIIll) throws IOException {
        this.field_149206_a = lllllllllllllllllllIlllIllllIIll.readInt();
        final short lllllllllllllllllllIlllIllllIIlI = lllllllllllllllllllIlllIllllIIll.readUnsignedByte();
        this.field_149204_b = ((lllllllllllllllllllIlllIllllIIlI & 0x8) == 0x8);
        final int lllllllllllllllllllIlllIllllIIIl = lllllllllllllllllllIlllIllllIIlI & 0xFFFFFFF7;
        this.field_149205_c = WorldSettings.GameType.getByID(lllllllllllllllllllIlllIllllIIIl);
        this.field_149202_d = lllllllllllllllllllIlllIllllIIll.readByte();
        this.field_149203_e = EnumDifficulty.getDifficultyEnum(lllllllllllllllllllIlllIllllIIll.readUnsignedByte());
        this.field_149200_f = lllllllllllllllllllIlllIllllIIll.readUnsignedByte();
        this.field_149201_g = WorldType.parseWorldType(lllllllllllllllllllIlllIllllIIll.readStringFromBuffer(16));
        if (this.field_149201_g == null) {
            this.field_149201_g = WorldType.DEFAULT;
        }
        this.field_179745_h = lllllllllllllllllllIlllIllllIIll.readBoolean();
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllllllIlllIlllIIIII) {
        lllllllllllllllllllIlllIlllIIIII.handleJoinGame(this);
    }
    
    public int func_149197_c() {
        return this.field_149206_a;
    }
    
    public boolean func_149195_d() {
        return this.field_149204_b;
    }
    
    public WorldSettings.GameType func_149198_e() {
        return this.field_149205_c;
    }
    
    public S01PacketJoinGame(final int lllllllllllllllllllIllllIIIIlIIl, final WorldSettings.GameType lllllllllllllllllllIllllIIIIlIII, final boolean lllllllllllllllllllIlllIlllllllI, final int lllllllllllllllllllIlllIllllllIl, final EnumDifficulty lllllllllllllllllllIllllIIIIIlIl, final int lllllllllllllllllllIlllIlllllIll, final WorldType lllllllllllllllllllIllllIIIIIIll, final boolean lllllllllllllllllllIllllIIIIIIlI) {
        this.field_149206_a = lllllllllllllllllllIllllIIIIlIIl;
        this.field_149202_d = lllllllllllllllllllIlllIllllllIl;
        this.field_149203_e = lllllllllllllllllllIllllIIIIIlIl;
        this.field_149205_c = lllllllllllllllllllIllllIIIIlIII;
        this.field_149200_f = lllllllllllllllllllIlllIlllllIll;
        this.field_149204_b = lllllllllllllllllllIlllIlllllllI;
        this.field_149201_g = lllllllllllllllllllIllllIIIIIIll;
        this.field_179745_h = lllllllllllllllllllIllllIIIIIIlI;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllllIlllIllIIIIII) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllllllIlllIllIIIIII);
    }
    
    public int func_149193_h() {
        return this.field_149200_f;
    }
    
    static {
        __OBFID = "CL_00001310";
    }
    
    public boolean func_179744_h() {
        return this.field_179745_h;
    }
}
