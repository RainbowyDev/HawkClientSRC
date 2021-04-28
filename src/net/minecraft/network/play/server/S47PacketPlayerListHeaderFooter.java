package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class S47PacketPlayerListHeaderFooter implements Packet
{
    private /* synthetic */ IChatComponent field_179702_b;
    private /* synthetic */ IChatComponent field_179703_a;
    
    public S47PacketPlayerListHeaderFooter(final IChatComponent lllllllllllllllIllllIIIIllllllII) {
        this.field_179703_a = lllllllllllllllIllllIIIIllllllII;
    }
    
    public void func_179699_a(final INetHandlerPlayClient lllllllllllllllIllllIIIIlllIlIlI) {
        lllllllllllllllIllllIIIIlllIlIlI.func_175096_a(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIllllIIIIllllIllI) throws IOException {
        this.field_179703_a = lllllllllllllllIllllIIIIllllIllI.readChatComponent();
        this.field_179702_b = lllllllllllllllIllllIIIIllllIllI.readChatComponent();
    }
    
    public S47PacketPlayerListHeaderFooter() {
    }
    
    public IChatComponent func_179700_a() {
        return this.field_179703_a;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIllllIIIIlllIIIII) {
        this.func_179699_a((INetHandlerPlayClient)lllllllllllllllIllllIIIIlllIIIII);
    }
    
    public IChatComponent func_179701_b() {
        return this.field_179702_b;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIllllIIIIllllIIlI) throws IOException {
        lllllllllllllllIllllIIIIllllIIlI.writeChatComponent(this.field_179703_a);
        lllllllllllllllIllllIIIIllllIIlI.writeChatComponent(this.field_179702_b);
    }
    
    static {
        __OBFID = "CL_00002285";
    }
}
