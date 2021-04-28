package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import net.minecraft.scoreboard.*;

public class S3DPacketDisplayScoreboard implements Packet
{
    private /* synthetic */ int field_149374_a;
    private /* synthetic */ String field_149373_b;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIllllIIllIlIIIIIl) throws IOException {
        llllllllllllllIIllllIIllIlIIIIIl.writeByte(this.field_149374_a);
        llllllllllllllIIllllIIllIlIIIIIl.writeString(this.field_149373_b);
    }
    
    static {
        __OBFID = "CL_00001325";
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIllllIIllIIlIllll) {
        this.func_180747_a((INetHandlerPlayClient)llllllllllllllIIllllIIllIIlIllll);
    }
    
    public int func_149371_c() {
        return this.field_149374_a;
    }
    
    public String func_149370_d() {
        return this.field_149373_b;
    }
    
    public void func_180747_a(final INetHandlerPlayClient llllllllllllllIIllllIIllIIlllIll) {
        llllllllllllllIIllllIIllIIlllIll.handleDisplayScoreboard(this);
    }
    
    public S3DPacketDisplayScoreboard() {
    }
    
    public S3DPacketDisplayScoreboard(final int llllllllllllllIIllllIIllIlIlIIIl, final ScoreObjective llllllllllllllIIllllIIllIlIlIIII) {
        this.field_149374_a = llllllllllllllIIllllIIllIlIlIIIl;
        if (llllllllllllllIIllllIIllIlIlIIII == null) {
            this.field_149373_b = "";
        }
        else {
            this.field_149373_b = llllllllllllllIIllllIIllIlIlIIII.getName();
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIllllIIllIlIIIlll) throws IOException {
        this.field_149374_a = llllllllllllllIIllllIIllIlIIIlll.readByte();
        this.field_149373_b = llllllllllllllIIllllIIllIlIIIlll.readStringFromBuffer(16);
    }
}
