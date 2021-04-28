package net.minecraft.network.play.server;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S25PacketBlockBreakAnim implements Packet
{
    private /* synthetic */ BlockPos position;
    private /* synthetic */ int breakerId;
    private /* synthetic */ int progress;
    
    public int func_148845_c() {
        return this.breakerId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIIIIlIlllllIIIl) throws IOException {
        this.breakerId = lllllllllllllllIIIIIIlIlllllIIIl.readVarIntFromBuffer();
        this.position = lllllllllllllllIIIIIIlIlllllIIIl.readBlockPos();
        this.progress = lllllllllllllllIIIIIIlIlllllIIIl.readUnsignedByte();
    }
    
    public void handle(final INetHandlerPlayClient lllllllllllllllIIIIIIlIllllIIIll) {
        lllllllllllllllIIIIIIlIllllIIIll.handleBlockBreakAnim(this);
    }
    
    public int func_148846_g() {
        return this.progress;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIIIIIlIlllIlIllI) {
        this.handle((INetHandlerPlayClient)lllllllllllllllIIIIIIlIlllIlIllI);
    }
    
    public S25PacketBlockBreakAnim(final int lllllllllllllllIIIIIIllIIlllIllI, final BlockPos lllllllllllllllIIIIIIllIIlllllII, final int lllllllllllllllIIIIIIlIlllllIlll) {
        this.breakerId = lllllllllllllllIIIIIIllIIlllIllI;
        this.position = lllllllllllllllIIIIIIllIIlllllII;
        this.progress = lllllllllllllllIIIIIIlIlllllIlll;
    }
    
    public BlockPos func_179821_b() {
        return this.position;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIIIIlIllllIlIll) throws IOException {
        lllllllllllllllIIIIIIlIllllIlIll.writeVarIntToBuffer(this.breakerId);
        lllllllllllllllIIIIIIlIllllIlIll.writeBlockPos(this.position);
        lllllllllllllllIIIIIIlIllllIlIll.writeByte(this.progress);
    }
    
    static {
        __OBFID = "CL_00001284";
    }
    
    public S25PacketBlockBreakAnim() {
    }
}
