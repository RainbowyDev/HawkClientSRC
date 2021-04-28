package net.minecraft.network.play.server;

import net.minecraft.world.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import java.io.*;
import net.minecraft.block.state.*;
import net.minecraft.world.chunk.*;
import net.minecraft.util.*;

public class S22PacketMultiBlockChange implements Packet
{
    private /* synthetic */ ChunkCoordIntPair field_148925_b;
    private /* synthetic */ BlockUpdateData[] field_179845_b;
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIIllIlIlIlIIIlIl) {
        this.func_180729_a((INetHandlerPlayClient)llllllllllllllllIIllIlIlIlIIIlIl);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIIllIlIlIlIllllI) throws IOException {
        llllllllllllllllIIllIlIlIlIllllI.writeInt(this.field_148925_b.chunkXPos);
        llllllllllllllllIIllIlIlIlIllllI.writeInt(this.field_148925_b.chunkZPos);
        llllllllllllllllIIllIlIlIlIllllI.writeVarIntToBuffer(this.field_179845_b.length);
        for (final BlockUpdateData llllllllllllllllIIllIlIlIlIllIlI : this.field_179845_b) {
            llllllllllllllllIIllIlIlIlIllllI.writeShort(llllllllllllllllIIllIlIlIlIllIlI.func_180089_b());
            llllllllllllllllIIllIlIlIlIllllI.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(llllllllllllllllIIllIlIlIlIllIlI.func_180088_c()));
        }
    }
    
    public BlockUpdateData[] func_179844_a() {
        return this.field_179845_b;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIIllIlIlIllIlIlI) throws IOException {
        this.field_148925_b = new ChunkCoordIntPair(llllllllllllllllIIllIlIlIllIlIlI.readInt(), llllllllllllllllIIllIlIlIllIlIlI.readInt());
        this.field_179845_b = new BlockUpdateData[llllllllllllllllIIllIlIlIllIlIlI.readVarIntFromBuffer()];
        for (int llllllllllllllllIIllIlIlIllIlIIl = 0; llllllllllllllllIIllIlIlIllIlIIl < this.field_179845_b.length; ++llllllllllllllllIIllIlIlIllIlIIl) {
            this.field_179845_b[llllllllllllllllIIllIlIlIllIlIIl] = new BlockUpdateData(llllllllllllllllIIllIlIlIllIlIlI.readShort(), (IBlockState)Block.BLOCK_STATE_IDS.getByValue(llllllllllllllllIIllIlIlIllIlIlI.readVarIntFromBuffer()));
        }
    }
    
    public S22PacketMultiBlockChange() {
    }
    
    public void func_180729_a(final INetHandlerPlayClient llllllllllllllllIIllIlIlIlIIlllI) {
        llllllllllllllllIIllIlIlIlIIlllI.handleMultiBlockChange(this);
    }
    
    public S22PacketMultiBlockChange(final int llllllllllllllllIIllIlIlIlllIlll, final short[] llllllllllllllllIIllIlIlIlllIllI, final Chunk llllllllllllllllIIllIlIlIlllIlIl) {
        this.field_148925_b = new ChunkCoordIntPair(llllllllllllllllIIllIlIlIlllIlIl.xPosition, llllllllllllllllIIllIlIlIlllIlIl.zPosition);
        this.field_179845_b = new BlockUpdateData[llllllllllllllllIIllIlIlIlllIlll];
        for (int llllllllllllllllIIllIlIlIlllIlII = 0; llllllllllllllllIIllIlIlIlllIlII < this.field_179845_b.length; ++llllllllllllllllIIllIlIlIlllIlII) {
            this.field_179845_b[llllllllllllllllIIllIlIlIlllIlII] = new BlockUpdateData(llllllllllllllllIIllIlIlIlllIllI[llllllllllllllllIIllIlIlIlllIlII], llllllllllllllllIIllIlIlIlllIlIl);
        }
    }
    
    static {
        __OBFID = "CL_00001290";
    }
    
    public class BlockUpdateData
    {
        private final /* synthetic */ short field_180091_b;
        private final /* synthetic */ IBlockState field_180092_c;
        
        public IBlockState func_180088_c() {
            return this.field_180092_c;
        }
        
        public BlockUpdateData(final short lllllllllllllllIlIlIIIllIlIIIlII, final IBlockState lllllllllllllllIlIlIIIllIlIIIlll) {
            this.field_180091_b = lllllllllllllllIlIlIIIllIlIIIlII;
            this.field_180092_c = lllllllllllllllIlIlIIIllIlIIIlll;
        }
        
        static {
            __OBFID = "CL_00002302";
        }
        
        public BlockPos func_180090_a() {
            return new BlockPos(S22PacketMultiBlockChange.this.field_148925_b.getBlock(this.field_180091_b >> 12 & 0xF, this.field_180091_b & 0xFF, this.field_180091_b >> 8 & 0xF));
        }
        
        public BlockUpdateData(final short lllllllllllllllIlIlIIIllIIllllIl, final Chunk lllllllllllllllIlIlIIIllIIllllII) {
            this.field_180091_b = lllllllllllllllIlIlIIIllIIllllIl;
            this.field_180092_c = lllllllllllllllIlIlIIIllIIllllII.getBlockState(this.func_180090_a());
        }
        
        public short func_180089_b() {
            return this.field_180091_b;
        }
    }
}
