package net.minecraft.network.play.server;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S05PacketSpawnPosition implements Packet
{
    private /* synthetic */ BlockPos field_179801_a;
    
    public BlockPos func_179800_a() {
        return this.field_179801_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIllIIIIlllIIlII) throws IOException {
        this.field_179801_a = lllllllllllllllIlIllIIIIlllIIlII.readBlockPos();
    }
    
    public S05PacketSpawnPosition(final BlockPos lllllllllllllllIlIllIIIIlllIlIII) {
        this.field_179801_a = lllllllllllllllIlIllIIIIlllIlIII;
    }
    
    static {
        __OBFID = "CL_00001336";
    }
    
    public void func_180752_a(final INetHandlerPlayClient lllllllllllllllIlIllIIIIllIlIllI) {
        lllllllllllllllIlIllIIIIllIlIllI.handleSpawnPosition(this);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIlIllIIIIllIIllIl) {
        this.func_180752_a((INetHandlerPlayClient)lllllllllllllllIlIllIIIIllIIllIl);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIllIIIIllIllllI) throws IOException {
        lllllllllllllllIlIllIIIIllIllllI.writeBlockPos(this.field_179801_a);
    }
    
    public S05PacketSpawnPosition() {
    }
}
