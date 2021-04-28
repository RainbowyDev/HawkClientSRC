package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import java.io.*;
import net.minecraft.world.*;

public class S23PacketBlockChange implements Packet
{
    private /* synthetic */ BlockPos field_179828_a;
    private /* synthetic */ IBlockState field_148883_d;
    
    public BlockPos func_179827_b() {
        return this.field_179828_a;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIllllIIlIIIIlIlllI) {
        this.func_180727_a((INetHandlerPlayClient)llllllllllllllIllllIIlIIIIlIlllI);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllllIIlIIIlIIIIII) throws IOException {
        llllllllllllllIllllIIlIIIlIIIIII.writeBlockPos(this.field_179828_a);
        llllllllllllllIllllIIlIIIlIIIIII.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(this.field_148883_d));
    }
    
    public S23PacketBlockChange(final World llllllllllllllIllllIIlIIIlIIllIl, final BlockPos llllllllllllllIllllIIlIIIlIIllll) {
        this.field_179828_a = llllllllllllllIllllIIlIIIlIIllll;
        this.field_148883_d = llllllllllllllIllllIIlIIIlIIllIl.getBlockState(llllllllllllllIllllIIlIIIlIIllll);
    }
    
    static {
        __OBFID = "CL_00001287";
    }
    
    public IBlockState func_180728_a() {
        return this.field_148883_d;
    }
    
    public S23PacketBlockChange() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllllIIlIIIlIIIllI) throws IOException {
        this.field_179828_a = llllllllllllllIllllIIlIIIlIIIllI.readBlockPos();
        this.field_148883_d = (IBlockState)Block.BLOCK_STATE_IDS.getByValue(llllllllllllllIllllIIlIIIlIIIllI.readVarIntFromBuffer());
    }
    
    public void func_180727_a(final INetHandlerPlayClient llllllllllllllIllllIIlIIIIlllIlI) {
        llllllllllllllIllllIIlIIIIlllIlI.handleBlockChange(this);
    }
}
