package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S36PacketSignEditorOpen implements Packet
{
    private /* synthetic */ BlockPos field_179778_a;
    
    public S36PacketSignEditorOpen(final BlockPos lllllllllllllllIIllllIlllllIIIll) {
        this.field_179778_a = lllllllllllllllIIllllIlllllIIIll;
    }
    
    public S36PacketSignEditorOpen() {
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIllllIllllIIlIlI) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllIIllllIllllIIlIlI);
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIllllIllllIlllll) {
        lllllllllllllllIIllllIllllIlllll.handleSignEditorOpen(this);
    }
    
    static {
        __OBFID = "CL_00001316";
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIllllIllllIlIIll) throws IOException {
        lllllllllllllllIIllllIllllIlIIll.writeBlockPos(this.field_179778_a);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIllllIllllIllIIl) throws IOException {
        this.field_179778_a = lllllllllllllllIIllllIllllIllIIl.readBlockPos();
    }
    
    public BlockPos func_179777_a() {
        return this.field_179778_a;
    }
}
