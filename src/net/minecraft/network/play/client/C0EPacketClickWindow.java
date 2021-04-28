package net.minecraft.network.play.client;

import net.minecraft.item.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class C0EPacketClickWindow implements Packet
{
    private /* synthetic */ int slotId;
    private /* synthetic */ int windowId;
    private /* synthetic */ int mode;
    private /* synthetic */ int usedButton;
    private /* synthetic */ ItemStack clickedItem;
    private /* synthetic */ short actionNumber;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllllIIIIlIIlIIIll) throws IOException {
        this.windowId = lllllllllllllllllllIIIIlIIlIIIll.readByte();
        this.slotId = lllllllllllllllllllIIIIlIIlIIIll.readShort();
        this.usedButton = lllllllllllllllllllIIIIlIIlIIIll.readByte();
        this.actionNumber = lllllllllllllllllllIIIIlIIlIIIll.readShort();
        this.mode = lllllllllllllllllllIIIIlIIlIIIll.readByte();
        this.clickedItem = lllllllllllllllllllIIIIlIIlIIIll.readItemStackFromBuffer();
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllllIIIIlIIIIIlIl) {
        this.processPacket((INetHandlerPlayServer)lllllllllllllllllllIIIIlIIIIIlIl);
    }
    
    public int getSlotId() {
        return this.slotId;
    }
    
    public ItemStack getClickedItem() {
        return this.clickedItem;
    }
    
    public void processPacket(final INetHandlerPlayServer lllllllllllllllllllIIIIlIIlIlIIl) {
        lllllllllllllllllllIIIIlIIlIlIIl.processClickWindow(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllllIIIIlIIIlllll) throws IOException {
        lllllllllllllllllllIIIIlIIIlllll.writeByte(this.windowId);
        lllllllllllllllllllIIIIlIIIlllll.writeShort(this.slotId);
        lllllllllllllllllllIIIIlIIIlllll.writeByte(this.usedButton);
        lllllllllllllllllllIIIIlIIIlllll.writeShort(this.actionNumber);
        lllllllllllllllllllIIIIlIIIlllll.writeByte(this.mode);
        lllllllllllllllllllIIIIlIIIlllll.writeItemStackToBuffer(this.clickedItem);
    }
    
    public short getActionNumber() {
        return this.actionNumber;
    }
    
    public int getMode() {
        return this.mode;
    }
    
    public int getUsedButton() {
        return this.usedButton;
    }
    
    public C0EPacketClickWindow() {
    }
    
    public C0EPacketClickWindow(final int lllllllllllllllllllIIIIlIIlllIll, final int lllllllllllllllllllIIIIlIIllIIll, final int lllllllllllllllllllIIIIlIIllIIlI, final int lllllllllllllllllllIIIIlIIlllIII, final ItemStack lllllllllllllllllllIIIIlIIllIIII, final short lllllllllllllllllllIIIIlIIllIllI) {
        this.windowId = lllllllllllllllllllIIIIlIIlllIll;
        this.slotId = lllllllllllllllllllIIIIlIIllIIll;
        this.usedButton = lllllllllllllllllllIIIIlIIllIIlI;
        this.clickedItem = ((lllllllllllllllllllIIIIlIIllIIII != null) ? lllllllllllllllllllIIIIlIIllIIII.copy() : null);
        this.actionNumber = lllllllllllllllllllIIIIlIIllIllI;
        this.mode = lllllllllllllllllllIIIIlIIlllIII;
    }
    
    static {
        __OBFID = "CL_00001353";
    }
}
