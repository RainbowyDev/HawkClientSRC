package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S28PacketEffect implements Packet
{
    private /* synthetic */ int soundType;
    private /* synthetic */ boolean serverWide;
    private /* synthetic */ BlockPos field_179747_b;
    private /* synthetic */ int soundData;
    
    public int getSoundData() {
        return this.soundData;
    }
    
    public S28PacketEffect(final int lllllllllllllllllllIllllIllllllI, final BlockPos lllllllllllllllllllIllllIlllllIl, final int lllllllllllllllllllIllllIlllllII, final boolean lllllllllllllllllllIllllIllllIll) {
        this.soundType = lllllllllllllllllllIllllIllllllI;
        this.field_179747_b = lllllllllllllllllllIllllIlllllIl;
        this.soundData = lllllllllllllllllllIllllIlllllII;
        this.serverWide = lllllllllllllllllllIllllIllllIll;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllllIllllIlIlIlII) {
        this.func_180739_a((INetHandlerPlayClient)lllllllllllllllllllIllllIlIlIlII);
    }
    
    public S28PacketEffect() {
    }
    
    static {
        __OBFID = "CL_00001307";
    }
    
    public BlockPos func_179746_d() {
        return this.field_179747_b;
    }
    
    public boolean isSoundServerwide() {
        return this.serverWide;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllllIllllIllIlIlI) throws IOException {
        lllllllllllllllllllIllllIllIlIlI.writeInt(this.soundType);
        lllllllllllllllllllIllllIllIlIlI.writeBlockPos(this.field_179747_b);
        lllllllllllllllllllIllllIllIlIlI.writeInt(this.soundData);
        lllllllllllllllllllIllllIllIlIlI.writeBoolean(this.serverWide);
    }
    
    public int getSoundType() {
        return this.soundType;
    }
    
    public void func_180739_a(final INetHandlerPlayClient lllllllllllllllllllIllllIllIIllI) {
        lllllllllllllllllllIllllIllIIllI.handleEffect(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllllIllllIlllIIII) throws IOException {
        this.soundType = lllllllllllllllllllIllllIlllIIII.readInt();
        this.field_179747_b = lllllllllllllllllllIllllIlllIIII.readBlockPos();
        this.soundData = lllllllllllllllllllIllllIlllIIII.readInt();
        this.serverWide = lllllllllllllllllllIllllIlllIIII.readBoolean();
    }
}
