package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.block.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S24PacketBlockAction implements Packet
{
    private /* synthetic */ BlockPos field_179826_a;
    private /* synthetic */ int field_148872_d;
    private /* synthetic */ int field_148873_e;
    private /* synthetic */ Block field_148871_f;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllllIIIllIllllIII) throws IOException {
        llllllllllllllIllllIIIllIllllIII.writeBlockPos(this.field_179826_a);
        llllllllllllllIllllIIIllIllllIII.writeByte(this.field_148872_d);
        llllllllllllllIllllIIIllIllllIII.writeByte(this.field_148873_e);
        llllllllllllllIllllIIIllIllllIII.writeVarIntToBuffer(Block.getIdFromBlock(this.field_148871_f) & 0xFFF);
    }
    
    public int getData1() {
        return this.field_148872_d;
    }
    
    public BlockPos func_179825_a() {
        return this.field_179826_a;
    }
    
    static {
        __OBFID = "CL_00001286";
    }
    
    public S24PacketBlockAction() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllllIIIllIlllllII) throws IOException {
        this.field_179826_a = llllllllllllllIllllIIIllIlllllII.readBlockPos();
        this.field_148872_d = llllllllllllllIllllIIIllIlllllII.readUnsignedByte();
        this.field_148873_e = llllllllllllllIllllIIIllIlllllII.readUnsignedByte();
        this.field_148871_f = Block.getBlockById(llllllllllllllIllllIIIllIlllllII.readVarIntFromBuffer() & 0xFFF);
    }
    
    public S24PacketBlockAction(final BlockPos llllllllllllllIllllIIIlllIIIlIlI, final Block llllllllllllllIllllIIIlllIIIlIIl, final int llllllllllllllIllllIIIlllIIIIIll, final int llllllllllllllIllllIIIlllIIIIlll) {
        this.field_179826_a = llllllllllllllIllllIIIlllIIIlIlI;
        this.field_148872_d = llllllllllllllIllllIIIlllIIIIIll;
        this.field_148873_e = llllllllllllllIllllIIIlllIIIIlll;
        this.field_148871_f = llllllllllllllIllllIIIlllIIIlIIl;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIllllIIIllIllIIIII) {
        this.func_180726_a((INetHandlerPlayClient)llllllllllllllIllllIIIllIllIIIII);
    }
    
    public int getData2() {
        return this.field_148873_e;
    }
    
    public void func_180726_a(final INetHandlerPlayClient llllllllllllllIllllIIIllIlllIIlI) {
        llllllllllllllIllllIIIllIlllIIlI.handleBlockAction(this);
    }
    
    public Block getBlockType() {
        return this.field_148871_f;
    }
}
