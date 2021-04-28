package net.minecraft.network.play.client;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class C07PacketPlayerDigging implements Packet
{
    private /* synthetic */ Action status;
    private /* synthetic */ BlockPos field_179717_a;
    private /* synthetic */ EnumFacing field_179716_b;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllIIlllIIIlIIlllI) throws IOException {
        this.status = (Action)llllllllllllllIllIIlllIIIlIIlllI.readEnumValue(Action.class);
        this.field_179717_a = llllllllllllllIllIIlllIIIlIIlllI.readBlockPos();
        this.field_179716_b = EnumFacing.getFront(llllllllllllllIllIIlllIIIlIIlllI.readUnsignedByte());
    }
    
    public C07PacketPlayerDigging(final Action llllllllllllllIllIIlllIIIlIllIII, final BlockPos llllllllllllllIllIIlllIIIlIlIIll, final EnumFacing llllllllllllllIllIIlllIIIlIlIIlI) {
        this.status = llllllllllllllIllIIlllIIIlIllIII;
        this.field_179717_a = llllllllllllllIllIIlllIIIlIlIIll;
        this.field_179716_b = llllllllllllllIllIIlllIIIlIlIIlI;
    }
    
    public Action func_180762_c() {
        return this.status;
    }
    
    static {
        __OBFID = "CL_00001365";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllIIlllIIIlIIlIII) throws IOException {
        llllllllllllllIllIIlllIIIlIIlIII.writeEnumValue(this.status);
        llllllllllllllIllIIlllIIIlIIlIII.writeBlockPos(this.field_179717_a);
        llllllllllllllIllIIlllIIIlIIlIII.writeByte(this.field_179716_b.getIndex());
    }
    
    public EnumFacing func_179714_b() {
        return this.field_179716_b;
    }
    
    public C07PacketPlayerDigging() {
    }
    
    public BlockPos func_179715_a() {
        return this.field_179717_a;
    }
    
    public void func_180763_a(final INetHandlerPlayServer llllllllllllllIllIIlllIIIlIIIIII) {
        llllllllllllllIllIIlllIIIlIIIIII.processPlayerDigging(this);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIllIIlllIIIIllIIll) {
        this.func_180763_a((INetHandlerPlayServer)llllllllllllllIllIIlllIIIIllIIll);
    }
    
    public enum Action
    {
        DROP_ITEM("DROP_ITEM", 4, "DROP_ITEM", 4), 
        DROP_ALL_ITEMS("DROP_ALL_ITEMS", 3, "DROP_ALL_ITEMS", 3), 
        RELEASE_USE_ITEM("RELEASE_USE_ITEM", 5, "RELEASE_USE_ITEM", 5), 
        ABORT_DESTROY_BLOCK("ABORT_DESTROY_BLOCK", 1, "ABORT_DESTROY_BLOCK", 1), 
        START_DESTROY_BLOCK("START_DESTROY_BLOCK", 0, "START_DESTROY_BLOCK", 0), 
        STOP_DESTROY_BLOCK("STOP_DESTROY_BLOCK", 2, "STOP_DESTROY_BLOCK", 2);
        
        private Action(final String lllllllllllllllIIIIIlIIlllllIlIl, final int lllllllllllllllIIIIIlIIlllllIlII, final String lllllllllllllllIIIIIlIIllllllIII, final int lllllllllllllllIIIIIlIIlllllIlll) {
        }
        
        static {
            __OBFID = "CL_00002284";
        }
    }
}
