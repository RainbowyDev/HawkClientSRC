package net.minecraft.network.play.server;

import net.minecraft.scoreboard.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S3CPacketUpdateScore implements Packet
{
    private /* synthetic */ String objective;
    private /* synthetic */ int value;
    private /* synthetic */ String name;
    private /* synthetic */ Action action;
    
    public S3CPacketUpdateScore(final String llllllllllllllIllIIlllIIlllllIlI) {
        this.name = "";
        this.objective = "";
        this.name = llllllllllllllIllIIlllIIlllllIlI;
        this.objective = "";
        this.value = 0;
        this.action = Action.REMOVE;
    }
    
    public S3CPacketUpdateScore(final Score llllllllllllllIllIIlllIlIIIIIIII) {
        this.name = "";
        this.objective = "";
        this.name = llllllllllllllIllIIlllIlIIIIIIII.getPlayerName();
        this.objective = llllllllllllllIllIIlllIlIIIIIIII.getObjective().getName();
        this.value = llllllllllllllIllIIlllIlIIIIIIII.getScorePoints();
        this.action = Action.CHANGE;
    }
    
    public S3CPacketUpdateScore(final String llllllllllllllIllIIlllIIllllIIlI, final ScoreObjective llllllllllllllIllIIlllIIllllIIIl) {
        this.name = "";
        this.objective = "";
        this.name = llllllllllllllIllIIlllIIllllIIlI;
        this.objective = llllllllllllllIllIIlllIIllllIIIl.getName();
        this.value = 0;
        this.action = Action.REMOVE;
    }
    
    public Action func_180751_d() {
        return this.action;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIllIIlllIIllIIllIl) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIllIIlllIIllIIllIl);
    }
    
    public String func_149321_d() {
        return this.objective;
    }
    
    public S3CPacketUpdateScore() {
        this.name = "";
        this.objective = "";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllIIlllIIlllIIlll) throws IOException {
        llllllllllllllIllIIlllIIlllIIlll.writeString(this.name);
        llllllllllllllIllIIlllIIlllIIlll.writeEnumValue(this.action);
        llllllllllllllIllIIlllIIlllIIlll.writeString(this.objective);
        if (this.action != Action.REMOVE) {
            llllllllllllllIllIIlllIIlllIIlll.writeVarIntToBuffer(this.value);
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllIIlllIIlllIllIl) throws IOException {
        this.name = llllllllllllllIllIIlllIIlllIllIl.readStringFromBuffer(40);
        this.action = (Action)llllllllllllllIllIIlllIIlllIllIl.readEnumValue(Action.class);
        this.objective = llllllllllllllIllIIlllIIlllIllIl.readStringFromBuffer(16);
        if (this.action != Action.REMOVE) {
            this.value = llllllllllllllIllIIlllIIlllIllIl.readVarIntFromBuffer();
        }
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIllIIlllIIlllIIIIl) {
        llllllllllllllIllIIlllIIlllIIIIl.handleUpdateScore(this);
    }
    
    public int func_149323_e() {
        return this.value;
    }
    
    static {
        __OBFID = "CL_00001335";
    }
    
    public String func_149324_c() {
        return this.name;
    }
    
    public enum Action
    {
        CHANGE("CHANGE", 0, "CHANGE", 0), 
        REMOVE("REMOVE", 1, "REMOVE", 1);
        
        static {
            __OBFID = "CL_00002288";
        }
        
        private Action(final String llllllllllllllIlIlIIllllIlIIllIl, final int llllllllllllllIlIlIIllllIlIIllII, final String llllllllllllllIlIlIIllllIlIlIIlI, final int llllllllllllllIlIlIIllllIlIlIIIl) {
        }
    }
}
