package net.minecraft.network.play.server;

import net.minecraft.world.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S41PacketServerDifficulty implements Packet
{
    private /* synthetic */ EnumDifficulty field_179833_a;
    private /* synthetic */ boolean field_179832_b;
    
    public EnumDifficulty func_179831_b() {
        return this.field_179833_a;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIlIllIlllIIIlII) throws IOException {
        lllllllllllllllIlIlIllIlllIIIlII.writeByte(this.field_179833_a.getDifficultyId());
    }
    
    public void func_179829_a(final INetHandlerPlayClient lllllllllllllllIlIlIllIlllIlIIII) {
        lllllllllllllllIlIlIllIlllIlIIII.func_175101_a(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIlIllIlllIIlIlI) throws IOException {
        this.field_179833_a = EnumDifficulty.getDifficultyEnum(lllllllllllllllIlIlIllIlllIIlIlI.readUnsignedByte());
    }
    
    public S41PacketServerDifficulty(final EnumDifficulty lllllllllllllllIlIlIllIlllIlIlll, final boolean lllllllllllllllIlIlIllIlllIllIIl) {
        this.field_179833_a = lllllllllllllllIlIlIllIlllIlIlll;
        this.field_179832_b = lllllllllllllllIlIlIllIlllIllIIl;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIlIlIllIllIlllIII) {
        this.func_179829_a((INetHandlerPlayClient)lllllllllllllllIlIlIllIllIlllIII);
    }
    
    public S41PacketServerDifficulty() {
    }
    
    static {
        __OBFID = "CL_00002303";
    }
    
    public boolean func_179830_a() {
        return this.field_179832_b;
    }
}
