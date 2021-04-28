package net.minecraft.network.play.server;

import java.util.*;
import java.io.*;
import net.minecraft.scoreboard.*;
import com.google.common.collect.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S3EPacketTeams implements Packet
{
    private /* synthetic */ int field_149315_g;
    private /* synthetic */ String field_149318_b;
    private /* synthetic */ int field_179815_f;
    private /* synthetic */ int field_149314_f;
    private /* synthetic */ String field_149320_a;
    private /* synthetic */ String field_149319_c;
    private /* synthetic */ Collection field_149317_e;
    private /* synthetic */ String field_179816_e;
    private /* synthetic */ String field_149316_d;
    
    public String func_149311_e() {
        return this.field_149319_c;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIIlllIllIllllIII) throws IOException {
        llllllllllllllIIIIlllIllIllllIII.writeString(this.field_149320_a);
        llllllllllllllIIIIlllIllIllllIII.writeByte(this.field_149314_f);
        if (this.field_149314_f == 0 || this.field_149314_f == 2) {
            llllllllllllllIIIIlllIllIllllIII.writeString(this.field_149318_b);
            llllllllllllllIIIIlllIllIllllIII.writeString(this.field_149319_c);
            llllllllllllllIIIIlllIllIllllIII.writeString(this.field_149316_d);
            llllllllllllllIIIIlllIllIllllIII.writeByte(this.field_149315_g);
            llllllllllllllIIIIlllIllIllllIII.writeString(this.field_179816_e);
            llllllllllllllIIIIlllIllIllllIII.writeByte(this.field_179815_f);
        }
        if (this.field_149314_f == 0 || this.field_149314_f == 3 || this.field_149314_f == 4) {
            llllllllllllllIIIIlllIllIllllIII.writeVarIntToBuffer(this.field_149317_e.size());
            for (final String llllllllllllllIIIIlllIllIllllIlI : this.field_149317_e) {
                llllllllllllllIIIIlllIllIllllIII.writeString(llllllllllllllIIIIlllIllIllllIlI);
            }
        }
    }
    
    public String func_179814_i() {
        return this.field_179816_e;
    }
    
    public S3EPacketTeams(final ScorePlayerTeam llllllllllllllIIIIlllIlllIIlIIII, final Collection llllllllllllllIIIIlllIlllIIIllll, final int llllllllllllllIIIIlllIlllIIlIIlI) {
        this.field_149320_a = "";
        this.field_149318_b = "";
        this.field_149319_c = "";
        this.field_149316_d = "";
        this.field_179816_e = Team.EnumVisible.ALWAYS.field_178830_e;
        this.field_179815_f = -1;
        this.field_149317_e = Lists.newArrayList();
        if (llllllllllllllIIIIlllIlllIIlIIlI != 3 && llllllllllllllIIIIlllIlllIIlIIlI != 4) {
            throw new IllegalArgumentException("Method must be join or leave for player constructor");
        }
        if (llllllllllllllIIIIlllIlllIIIllll != null && !llllllllllllllIIIIlllIlllIIIllll.isEmpty()) {
            this.field_149314_f = llllllllllllllIIIIlllIlllIIlIIlI;
            this.field_149320_a = llllllllllllllIIIIlllIlllIIlIIII.getRegisteredName();
            this.field_149317_e.addAll(llllllllllllllIIIIlllIlllIIIllll);
            return;
        }
        throw new IllegalArgumentException("Players cannot be null/empty");
    }
    
    public int func_149308_i() {
        return this.field_149315_g;
    }
    
    public String func_149309_f() {
        return this.field_149316_d;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIIlllIlllIIIIlII) throws IOException {
        this.field_149320_a = llllllllllllllIIIIlllIlllIIIIlII.readStringFromBuffer(16);
        this.field_149314_f = llllllllllllllIIIIlllIlllIIIIlII.readByte();
        if (this.field_149314_f == 0 || this.field_149314_f == 2) {
            this.field_149318_b = llllllllllllllIIIIlllIlllIIIIlII.readStringFromBuffer(32);
            this.field_149319_c = llllllllllllllIIIIlllIlllIIIIlII.readStringFromBuffer(16);
            this.field_149316_d = llllllllllllllIIIIlllIlllIIIIlII.readStringFromBuffer(16);
            this.field_149315_g = llllllllllllllIIIIlllIlllIIIIlII.readByte();
            this.field_179816_e = llllllllllllllIIIIlllIlllIIIIlII.readStringFromBuffer(32);
            this.field_179815_f = llllllllllllllIIIIlllIlllIIIIlII.readByte();
        }
        if (this.field_149314_f == 0 || this.field_149314_f == 3 || this.field_149314_f == 4) {
            for (int llllllllllllllIIIIlllIlllIIIIlll = llllllllllllllIIIIlllIlllIIIIlII.readVarIntFromBuffer(), llllllllllllllIIIIlllIlllIIIIllI = 0; llllllllllllllIIIIlllIlllIIIIllI < llllllllllllllIIIIlllIlllIIIIlll; ++llllllllllllllIIIIlllIlllIIIIllI) {
                this.field_149317_e.add(llllllllllllllIIIIlllIlllIIIIlII.readStringFromBuffer(40));
            }
        }
    }
    
    public S3EPacketTeams(final ScorePlayerTeam llllllllllllllIIIIlllIlllIIllllI, final int llllllllllllllIIIIlllIlllIIllIlI) {
        this.field_149320_a = "";
        this.field_149318_b = "";
        this.field_149319_c = "";
        this.field_149316_d = "";
        this.field_179816_e = Team.EnumVisible.ALWAYS.field_178830_e;
        this.field_179815_f = -1;
        this.field_149317_e = Lists.newArrayList();
        this.field_149320_a = llllllllllllllIIIIlllIlllIIllllI.getRegisteredName();
        this.field_149314_f = llllllllllllllIIIIlllIlllIIllIlI;
        if (llllllllllllllIIIIlllIlllIIllIlI == 0 || llllllllllllllIIIIlllIlllIIllIlI == 2) {
            this.field_149318_b = llllllllllllllIIIIlllIlllIIllllI.func_96669_c();
            this.field_149319_c = llllllllllllllIIIIlllIlllIIllllI.getColorPrefix();
            this.field_149316_d = llllllllllllllIIIIlllIlllIIllllI.getColorSuffix();
            this.field_149315_g = llllllllllllllIIIIlllIlllIIllllI.func_98299_i();
            this.field_179816_e = llllllllllllllIIIIlllIlllIIllllI.func_178770_i().field_178830_e;
            this.field_179815_f = llllllllllllllIIIIlllIlllIIllllI.func_178775_l().func_175746_b();
        }
        if (llllllllllllllIIIIlllIlllIIllIlI == 0) {
            this.field_149317_e.addAll(llllllllllllllIIIIlllIlllIIllllI.getMembershipCollection());
        }
    }
    
    public Collection func_149310_g() {
        return this.field_149317_e;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIIIlllIllIlllIIII) {
        llllllllllllllIIIIlllIllIlllIIII.handleTeams(this);
    }
    
    public int func_179813_h() {
        return this.field_179815_f;
    }
    
    public int func_149307_h() {
        return this.field_149314_f;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIIlllIllIlIlIIIl) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIIIIlllIllIlIlIIIl);
    }
    
    public String func_149306_d() {
        return this.field_149318_b;
    }
    
    public S3EPacketTeams() {
        this.field_149320_a = "";
        this.field_149318_b = "";
        this.field_149319_c = "";
        this.field_149316_d = "";
        this.field_179816_e = Team.EnumVisible.ALWAYS.field_178830_e;
        this.field_179815_f = -1;
        this.field_149317_e = Lists.newArrayList();
    }
    
    static {
        __OBFID = "CL_00001334";
    }
    
    public String func_149312_c() {
        return this.field_149320_a;
    }
}
