package net.minecraft.network.play.server;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S2DPacketOpenWindow implements Packet
{
    private /* synthetic */ int windowId;
    private /* synthetic */ String inventoryType;
    private /* synthetic */ IChatComponent windowTitle;
    private /* synthetic */ int slotCount;
    private /* synthetic */ int entityId;
    
    public String func_148902_e() {
        return this.inventoryType;
    }
    
    public boolean func_148900_g() {
        return this.slotCount > 0;
    }
    
    static {
        __OBFID = "CL_00001293";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlllIIllIlIIIlIII) throws IOException {
        llllllllllllllIIlllIIllIlIIIlIII.writeByte(this.windowId);
        llllllllllllllIIlllIIllIlIIIlIII.writeString(this.inventoryType);
        llllllllllllllIIlllIIllIlIIIlIII.writeChatComponent(this.windowTitle);
        llllllllllllllIIlllIIllIlIIIlIII.writeByte(this.slotCount);
        if (this.inventoryType.equals("EntityHorse")) {
            llllllllllllllIIlllIIllIlIIIlIII.writeInt(this.entityId);
        }
    }
    
    public S2DPacketOpenWindow(final int llllllllllllllIIlllIIllIlIlIllll, final String llllllllllllllIIlllIIllIlIlIlllI, final IChatComponent llllllllllllllIIlllIIllIlIllIIlI, final int llllllllllllllIIlllIIllIlIllIIIl) {
        this.windowId = llllllllllllllIIlllIIllIlIlIllll;
        this.inventoryType = llllllllllllllIIlllIIllIlIlIlllI;
        this.windowTitle = llllllllllllllIIlllIIllIlIllIIlI;
        this.slotCount = llllllllllllllIIlllIIllIlIllIIIl;
    }
    
    public S2DPacketOpenWindow(final int llllllllllllllIIlllIIllIlIllllIl, final String llllllllllllllIIlllIIllIllIIIIII, final IChatComponent llllllllllllllIIlllIIllIlIlllIll) {
        this(llllllllllllllIIlllIIllIlIllllIl, llllllllllllllIIlllIIllIllIIIIII, llllllllllllllIIlllIIllIlIlllIll, 0);
    }
    
    public int func_148901_c() {
        return this.windowId;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIlllIIllIlIIlIllI) {
        llllllllllllllIIlllIIllIlIIlIllI.handleOpenWindow(this);
    }
    
    public IChatComponent func_179840_c() {
        return this.windowTitle;
    }
    
    public S2DPacketOpenWindow(final int llllllllllllllIIlllIIllIlIIllllI, final String llllllllllllllIIlllIIllIlIlIIIll, final IChatComponent llllllllllllllIIlllIIllIlIIlllII, final int llllllllllllllIIlllIIllIlIIllIll, final int llllllllllllllIIlllIIllIlIlIIIII) {
        this(llllllllllllllIIlllIIllIlIIllllI, llllllllllllllIIlllIIllIlIlIIIll, llllllllllllllIIlllIIllIlIIlllII, llllllllllllllIIlllIIllIlIIllIll);
        this.entityId = llllllllllllllIIlllIIllIlIlIIIII;
    }
    
    public S2DPacketOpenWindow() {
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIlllIIllIIlllIIII) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIIlllIIllIIlllIIII);
    }
    
    public int func_148897_h() {
        return this.entityId;
    }
    
    public int func_148898_f() {
        return this.slotCount;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlllIIllIlIIlIIII) throws IOException {
        this.windowId = llllllllllllllIIlllIIllIlIIlIIII.readUnsignedByte();
        this.inventoryType = llllllllllllllIIlllIIllIlIIlIIII.readStringFromBuffer(32);
        this.windowTitle = llllllllllllllIIlllIIllIlIIlIIII.readChatComponent();
        this.slotCount = llllllllllllllIIlllIIllIlIIlIIII.readUnsignedByte();
        if (this.inventoryType.equals("EntityHorse")) {
            this.entityId = llllllllllllllIIlllIIllIlIIlIIII.readInt();
        }
    }
}
