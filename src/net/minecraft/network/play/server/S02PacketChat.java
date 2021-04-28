package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S02PacketChat implements Packet
{
    private /* synthetic */ IChatComponent chatComponent;
    private /* synthetic */ byte field_179842_b;
    
    static {
        __OBFID = "CL_00001289";
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllllIIlIIlIllllIIlI) {
        lllllllllllllllllIIlIIlIllllIIlI.handleChat(this);
    }
    
    public byte func_179841_c() {
        return this.field_179842_b;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllIIlIIlIlllIIIll) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllllIIlIIlIlllIIIll);
    }
    
    public S02PacketChat() {
    }
    
    public S02PacketChat(final IChatComponent lllllllllllllllllIIlIIllIIIIlIll) {
        this(lllllllllllllllllIIlIIllIIIIlIll, (byte)1);
    }
    
    public IChatComponent func_148915_c() {
        return this.chatComponent;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIIlIIlIlllllIII) throws IOException {
        lllllllllllllllllIIlIIlIlllllIII.writeChatComponent(this.chatComponent);
        lllllllllllllllllIIlIIlIlllllIII.writeByte(this.field_179842_b);
    }
    
    public boolean isChat() {
        return this.field_179842_b == 1 || this.field_179842_b == 2;
    }
    
    public S02PacketChat(final IChatComponent lllllllllllllllllIIlIIllIIIIIllI, final byte lllllllllllllllllIIlIIllIIIIIlIl) {
        this.chatComponent = lllllllllllllllllIIlIIllIIIIIllI;
        this.field_179842_b = lllllllllllllllllIIlIIllIIIIIlIl;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIIlIIlIlllllllI) throws IOException {
        this.chatComponent = lllllllllllllllllIIlIIlIlllllllI.readChatComponent();
        this.field_179842_b = lllllllllllllllllIIlIIlIlllllllI.readByte();
    }
}
