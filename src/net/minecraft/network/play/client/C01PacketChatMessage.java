package net.minecraft.network.play.client;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class C01PacketChatMessage implements Packet
{
    private /* synthetic */ String message;
    
    public C01PacketChatMessage(String lllllllllllllllIIIlllllIlllllIII) {
        if (lllllllllllllllIIIlllllIlllllIII.length() > 100) {
            lllllllllllllllIIIlllllIlllllIII = lllllllllllllllIIIlllllIlllllIII.substring(0, 100);
        }
        this.message = lllllllllllllllIIIlllllIlllllIII;
    }
    
    static {
        __OBFID = "CL_00001347";
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIlllllIllllIIlI) throws IOException {
        this.message = lllllllllllllllIIIlllllIllllIIlI.readStringFromBuffer(100);
    }
    
    public void func_180757_a(final INetHandlerPlayServer lllllllllllllllIIIlllllIlllIlIII) {
        lllllllllllllllIIIlllllIlllIlIII.processChatMessage(this);
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public C01PacketChatMessage() {
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIIlllllIllIlllIl) {
        this.func_180757_a((INetHandlerPlayServer)lllllllllllllllIIIlllllIllIlllIl);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIlllllIlllIlllI) throws IOException {
        lllllllllllllllIIIlllllIlllIlllI.writeString(this.message);
    }
}
