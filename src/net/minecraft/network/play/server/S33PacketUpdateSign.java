package net.minecraft.network.play.server;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class S33PacketUpdateSign implements Packet
{
    private /* synthetic */ World field_179706_a;
    private /* synthetic */ BlockPos field_179705_b;
    private /* synthetic */ IChatComponent[] field_149349_d;
    
    static {
        __OBFID = "CL_00001338";
    }
    
    public S33PacketUpdateSign() {
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlllIllIIlIIllIllI) {
        llllllllllllllIlllIllIIlIIllIllI.handleUpdateSign(this);
    }
    
    public IChatComponent[] func_180753_b() {
        return this.field_149349_d;
    }
    
    public BlockPos func_179704_a() {
        return this.field_179705_b;
    }
    
    public S33PacketUpdateSign(final World llllllllllllllIlllIllIIlIlIlIIII, final BlockPos llllllllllllllIlllIllIIlIlIlIIll, final IChatComponent[] llllllllllllllIlllIllIIlIlIIlllI) {
        this.field_179706_a = llllllllllllllIlllIllIIlIlIlIIII;
        this.field_179705_b = llllllllllllllIlllIllIIlIlIlIIll;
        this.field_149349_d = new IChatComponent[] { llllllllllllllIlllIllIIlIlIIlllI[0], llllllllllllllIlllIllIIlIlIIlllI[1], llllllllllllllIlllIllIIlIlIIlllI[2], llllllllllllllIlllIllIIlIlIIlllI[3] };
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlllIllIIlIlIIlIIl) throws IOException {
        this.field_179705_b = llllllllllllllIlllIllIIlIlIIlIIl.readBlockPos();
        this.field_149349_d = new IChatComponent[4];
        for (int llllllllllllllIlllIllIIlIlIIlIII = 0; llllllllllllllIlllIllIIlIlIIlIII < 4; ++llllllllllllllIlllIllIIlIlIIlIII) {
            this.field_149349_d[llllllllllllllIlllIllIIlIlIIlIII] = llllllllllllllIlllIllIIlIlIIlIIl.readChatComponent();
        }
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlllIllIIlIIlIlIlI) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIlllIllIIlIIlIlIlI);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlllIllIIlIIllllIl) throws IOException {
        llllllllllllllIlllIllIIlIIllllIl.writeBlockPos(this.field_179705_b);
        for (int llllllllllllllIlllIllIIlIIllllll = 0; llllllllllllllIlllIllIIlIIllllll < 4; ++llllllllllllllIlllIllIIlIIllllll) {
            llllllllllllllIlllIllIIlIIllllIl.writeChatComponent(this.field_149349_d[llllllllllllllIlllIllIIlIIllllll]);
        }
    }
}
