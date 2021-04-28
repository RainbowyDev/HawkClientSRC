package net.minecraft.network.play.client;

import net.minecraft.util.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class C12PacketUpdateSign implements Packet
{
    private /* synthetic */ BlockPos field_179723_a;
    private /* synthetic */ IChatComponent[] lines;
    
    public void processPacket(final INetHandlerPlayServer llllllllllllllllIIlllllllIIllllI) {
        llllllllllllllllIIlllllllIIllllI.processUpdateSign(this);
    }
    
    public C12PacketUpdateSign() {
    }
    
    public BlockPos func_179722_a() {
        return this.field_179723_a;
    }
    
    public C12PacketUpdateSign(final BlockPos llllllllllllllllIIlllllllIlllIII, final IChatComponent[] llllllllllllllllIIlllllllIllIlII) {
        this.field_179723_a = llllllllllllllllIIlllllllIlllIII;
        this.lines = new IChatComponent[] { llllllllllllllllIIlllllllIllIlII[0], llllllllllllllllIIlllllllIllIlII[1], llllllllllllllllIIlllllllIllIlII[2], llllllllllllllllIIlllllllIllIlII[3] };
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIIlllllllIIlIIII) {
        this.processPacket((INetHandlerPlayServer)llllllllllllllllIIlllllllIIlIIII);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIIlllllllIlIIIll) throws IOException {
        llllllllllllllllIIlllllllIlIIIll.writeBlockPos(this.field_179723_a);
        for (int llllllllllllllllIIlllllllIlIIlIl = 0; llllllllllllllllIIlllllllIlIIlIl < 4; ++llllllllllllllllIIlllllllIlIIlIl) {
            llllllllllllllllIIlllllllIlIIIll.writeChatComponent(this.lines[llllllllllllllllIIlllllllIlIIlIl]);
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIIlllllllIlIllII) throws IOException {
        this.field_179723_a = llllllllllllllllIIlllllllIlIllII.readBlockPos();
        this.lines = new IChatComponent[4];
        for (int llllllllllllllllIIlllllllIlIlllI = 0; llllllllllllllllIIlllllllIlIlllI < 4; ++llllllllllllllllIIlllllllIlIlllI) {
            this.lines[llllllllllllllllIIlllllllIlIlllI] = llllllllllllllllIIlllllllIlIllII.readChatComponent();
        }
    }
    
    public IChatComponent[] func_180768_b() {
        return this.lines;
    }
    
    static {
        __OBFID = "CL_00001370";
    }
}
