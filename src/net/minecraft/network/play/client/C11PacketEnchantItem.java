package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class C11PacketEnchantItem implements Packet
{
    private /* synthetic */ int button;
    private /* synthetic */ int id;
    
    public C11PacketEnchantItem(final int llllllllllllllIlIIIlllIlIIlIIllI, final int llllllllllllllIlIIIlllIlIIlIlIII) {
        this.id = llllllllllllllIlIIIlllIlIIlIIllI;
        this.button = llllllllllllllIlIIIlllIlIIlIlIII;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlIIIlllIlIIIIlIIl) {
        this.processPacket((INetHandlerPlayServer)llllllllllllllIlIIIlllIlIIIIlIIl);
    }
    
    static {
        __OBFID = "CL_00001352";
    }
    
    public void processPacket(final INetHandlerPlayServer llllllllllllllIlIIIlllIlIIIlllll) {
        llllllllllllllIlIIIlllIlIIIlllll.processEnchantItem(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIIlllIlIIIlIlIl) throws IOException {
        llllllllllllllIlIIIlllIlIIIlIlIl.writeByte(this.id);
        llllllllllllllIlIIIlllIlIIIlIlIl.writeByte(this.button);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIIlllIlIIIllIIl) throws IOException {
        this.id = llllllllllllllIlIIIlllIlIIIllIIl.readByte();
        this.button = llllllllllllllIlIIIlllIlIIIllIIl.readByte();
    }
    
    public int getId() {
        return this.id;
    }
    
    public C11PacketEnchantItem() {
    }
    
    public int getButton() {
        return this.button;
    }
}
