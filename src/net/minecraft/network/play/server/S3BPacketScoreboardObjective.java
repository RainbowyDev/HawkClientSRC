package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.scoreboard.*;

public class S3BPacketScoreboardObjective implements Packet
{
    private /* synthetic */ int field_149342_c;
    private /* synthetic */ String field_149341_b;
    private /* synthetic */ String field_149343_a;
    private /* synthetic */ IScoreObjectiveCriteria.EnumRenderType field_179818_c;
    
    static {
        __OBFID = "CL_00001333";
    }
    
    public IScoreObjectiveCriteria.EnumRenderType func_179817_d() {
        return this.field_179818_c;
    }
    
    public String func_149339_c() {
        return this.field_149343_a;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllllIllIlIllIIIIlIII) {
        llllllllllllllllIllIlIllIIIIlIII.handleScoreboardObjective(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIllIlIllIIIIlllI) throws IOException {
        llllllllllllllllIllIlIllIIIIlllI.writeString(this.field_149343_a);
        llllllllllllllllIllIlIllIIIIlllI.writeByte(this.field_149342_c);
        if (this.field_149342_c == 0 || this.field_149342_c == 2) {
            llllllllllllllllIllIlIllIIIIlllI.writeString(this.field_149341_b);
            llllllllllllllllIllIlIllIIIIlllI.writeString(this.field_179818_c.func_178796_a());
        }
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIllIlIlIllllIllI) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllllIllIlIlIllllIllI);
    }
    
    public String func_149337_d() {
        return this.field_149341_b;
    }
    
    public int func_149338_e() {
        return this.field_149342_c;
    }
    
    public S3BPacketScoreboardObjective(final ScoreObjective llllllllllllllllIllIlIllIIIllIll, final int llllllllllllllllIllIlIllIIIlllIl) {
        this.field_149343_a = llllllllllllllllIllIlIllIIIllIll.getName();
        this.field_149341_b = llllllllllllllllIllIlIllIIIllIll.getDisplayName();
        this.field_179818_c = llllllllllllllllIllIlIllIIIllIll.getCriteria().func_178790_c();
        this.field_149342_c = llllllllllllllllIllIlIllIIIlllIl;
    }
    
    public S3BPacketScoreboardObjective() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIllIlIllIIIlIlII) throws IOException {
        this.field_149343_a = llllllllllllllllIllIlIllIIIlIlII.readStringFromBuffer(16);
        this.field_149342_c = llllllllllllllllIllIlIllIIIlIlII.readByte();
        if (this.field_149342_c == 0 || this.field_149342_c == 2) {
            this.field_149341_b = llllllllllllllllIllIlIllIIIlIlII.readStringFromBuffer(32);
            this.field_179818_c = IScoreObjectiveCriteria.EnumRenderType.func_178795_a(llllllllllllllllIllIlIllIIIlIlII.readStringFromBuffer(16));
        }
    }
}
