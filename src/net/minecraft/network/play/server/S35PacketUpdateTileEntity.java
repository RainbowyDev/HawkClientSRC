package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S35PacketUpdateTileEntity implements Packet
{
    private /* synthetic */ BlockPos field_179824_a;
    private /* synthetic */ NBTTagCompound nbt;
    private /* synthetic */ int metadata;
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIIIIIlIlIllIIIIl) {
        this.func_180725_a((INetHandlerPlayClient)llllllllllllllIIIIIIIlIlIllIIIIl);
    }
    
    public void func_180725_a(final INetHandlerPlayClient llllllllllllllIIIIIIIlIlIlllIIlI) {
        llllllllllllllIIIIIIIlIlIlllIIlI.handleUpdateTileEntity(this);
    }
    
    public S35PacketUpdateTileEntity() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIIIIIlIlIllllIII) throws IOException {
        llllllllllllllIIIIIIIlIlIllllIII.writeBlockPos(this.field_179824_a);
        llllllllllllllIIIIIIIlIlIllllIII.writeByte((byte)this.metadata);
        llllllllllllllIIIIIIIlIlIllllIII.writeNBTTagCompoundToBuffer(this.nbt);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIIIIIlIlIlllllII) throws IOException {
        this.field_179824_a = llllllllllllllIIIIIIIlIlIlllllII.readBlockPos();
        this.metadata = llllllllllllllIIIIIIIlIlIlllllII.readUnsignedByte();
        this.nbt = llllllllllllllIIIIIIIlIlIlllllII.readNBTTagCompoundFromBuffer();
    }
    
    static {
        __OBFID = "CL_00001285";
    }
    
    public S35PacketUpdateTileEntity(final BlockPos llllllllllllllIIIIIIIlIllIIIlIII, final int llllllllllllllIIIIIIIlIllIIIIIll, final NBTTagCompound llllllllllllllIIIIIIIlIllIIIIIlI) {
        this.field_179824_a = llllllllllllllIIIIIIIlIllIIIlIII;
        this.metadata = llllllllllllllIIIIIIIlIllIIIIIll;
        this.nbt = llllllllllllllIIIIIIIlIllIIIIIlI;
    }
    
    public NBTTagCompound getNbtCompound() {
        return this.nbt;
    }
    
    public BlockPos func_179823_a() {
        return this.field_179824_a;
    }
    
    public int getTileEntityType() {
        return this.metadata;
    }
}
