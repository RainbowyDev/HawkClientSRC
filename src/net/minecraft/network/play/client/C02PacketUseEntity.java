package net.minecraft.network.play.client;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import net.minecraft.world.*;

public class C02PacketUseEntity implements Packet
{
    private /* synthetic */ Vec3 field_179713_c;
    private /* synthetic */ Action action;
    private /* synthetic */ int entityId;
    
    public C02PacketUseEntity(final Entity lllllllllllllllllIlIIIllIlIllIII, final Action lllllllllllllllllIlIIIllIlIlIlll) {
        this.entityId = lllllllllllllllllIlIIIllIlIllIII.getEntityId();
        this.action = lllllllllllllllllIlIIIllIlIlIlll;
    }
    
    public Action getAction() {
        return this.action;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIlIIIllIlIIIlll) throws IOException {
        this.entityId = lllllllllllllllllIlIIIllIlIIIlll.readVarIntFromBuffer();
        this.action = (Action)lllllllllllllllllIlIIIllIlIIIlll.readEnumValue(Action.class);
        if (this.action == Action.INTERACT_AT) {
            this.field_179713_c = new Vec3(lllllllllllllllllIlIIIllIlIIIlll.readFloat(), lllllllllllllllllIlIIIllIlIIIlll.readFloat(), lllllllllllllllllIlIIIllIlIIIlll.readFloat());
        }
    }
    
    public C02PacketUseEntity() {
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllIlIIIllIIlIIlll) {
        this.processPacket((INetHandlerPlayServer)lllllllllllllllllIlIIIllIIlIIlll);
    }
    
    public void processPacket(final INetHandlerPlayServer lllllllllllllllllIlIIIllIIlllIll) {
        lllllllllllllllllIlIIIllIIlllIll.processUseEntity(this);
    }
    
    public C02PacketUseEntity(final Entity lllllllllllllllllIlIIIllIlIIllll, final Vec3 lllllllllllllllllIlIIIllIlIIlIll) {
        this(lllllllllllllllllIlIIIllIlIIllll, Action.INTERACT_AT);
        this.field_179713_c = lllllllllllllllllIlIIIllIlIIlIll;
    }
    
    public Vec3 func_179712_b() {
        return this.field_179713_c;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIlIIIllIIllllll) throws IOException {
        lllllllllllllllllIlIIIllIIllllll.writeVarIntToBuffer(this.entityId);
        lllllllllllllllllIlIIIllIIllllll.writeEnumValue(this.action);
        if (this.action == Action.INTERACT_AT) {
            lllllllllllllllllIlIIIllIIllllll.writeFloat((float)this.field_179713_c.xCoord);
            lllllllllllllllllIlIIIllIIllllll.writeFloat((float)this.field_179713_c.yCoord);
            lllllllllllllllllIlIIIllIIllllll.writeFloat((float)this.field_179713_c.zCoord);
        }
    }
    
    static {
        __OBFID = "CL_00001357";
    }
    
    public Entity getEntityFromWorld(final World lllllllllllllllllIlIIIllIIllIIll) {
        return lllllllllllllllllIlIIIllIIllIIll.getEntityByID(this.entityId);
    }
    
    public enum Action
    {
        ATTACK("ATTACK", 1, "ATTACK", 1), 
        INTERACT_AT("INTERACT_AT", 2, "INTERACT_AT", 2), 
        INTERACT("INTERACT", 0, "INTERACT", 0);
        
        private Action(final String lIIIlIllIIIIlII, final int lIIIlIllIIIIIll, final String lIIIlIllIIIIlll, final int lIIIlIllIIIIllI) {
        }
        
        static {
            __OBFID = "CL_00001358";
        }
    }
}
