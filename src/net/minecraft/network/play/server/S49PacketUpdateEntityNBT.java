package net.minecraft.network.play.server;

import net.minecraft.nbt.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S49PacketUpdateEntityNBT implements Packet
{
    private /* synthetic */ NBTTagCompound field_179765_b;
    private /* synthetic */ int field_179766_a;
    
    static {
        __OBFID = "CL_00002301";
    }
    
    public S49PacketUpdateEntityNBT() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlIIIllIlIlIllIIl) throws IOException {
        llllllllllllllIIlIIIllIlIlIllIIl.writeVarIntToBuffer(this.field_179766_a);
        llllllllllllllIIlIIIllIlIlIllIIl.writeNBTTagCompoundToBuffer(this.field_179765_b);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlIIIllIlIllIIlIl) throws IOException {
        this.field_179766_a = llllllllllllllIIlIIIllIlIllIIlIl.readVarIntFromBuffer();
        this.field_179765_b = llllllllllllllIIlIIIllIlIllIIlIl.readNBTTagCompoundFromBuffer();
    }
    
    public Entity func_179764_a(final World llllllllllllllIIlIIIllIlIlIIIlII) {
        return llllllllllllllIIlIIIllIlIlIIIlII.getEntityByID(this.field_179766_a);
    }
    
    public NBTTagCompound func_179763_a() {
        return this.field_179765_b;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIlIIIllIlIIlllIII) {
        this.func_179762_a((INetHandlerPlayClient)llllllllllllllIIlIIIllIlIIlllIII);
    }
    
    public void func_179762_a(final INetHandlerPlayClient llllllllllllllIIlIIIllIlIlIlIIIl) {
        llllllllllllllIIlIIIllIlIlIlIIIl.func_175097_a(this);
    }
    
    public S49PacketUpdateEntityNBT(final int llllllllllllllIIlIIIllIlIlllIIIl, final NBTTagCompound llllllllllllllIIlIIIllIlIllIllll) {
        this.field_179766_a = llllllllllllllIIlIIIllIlIlllIIIl;
        this.field_179765_b = llllllllllllllIIlIIIllIlIllIllll;
    }
}
