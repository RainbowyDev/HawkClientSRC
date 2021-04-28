package net.minecraft.network.play.client;

import net.minecraft.item.*;
import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class C10PacketCreativeInventoryAction implements Packet
{
    private /* synthetic */ int slotId;
    private /* synthetic */ ItemStack stack;
    
    public void func_180767_a(final INetHandlerPlayServer llllllllllllllIIIlIIIIlIIlIIllll) {
        llllllllllllllIIIlIIIIlIIlIIllll.processCreativeInventoryAction(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIlIIIIlIIlIIIlIl) throws IOException {
        llllllllllllllIIIlIIIIlIIlIIIlIl.writeShort(this.slotId);
        llllllllllllllIIIlIIIIlIIlIIIlIl.writeItemStackToBuffer(this.stack);
    }
    
    public int getSlotId() {
        return this.slotId;
    }
    
    public C10PacketCreativeInventoryAction() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIlIIIIlIIlIIlIIl) throws IOException {
        this.slotId = llllllllllllllIIIlIIIIlIIlIIlIIl.readShort();
        this.stack = llllllllllllllIIIlIIIIlIIlIIlIIl.readItemStackFromBuffer();
    }
    
    static {
        __OBFID = "CL_00001369";
    }
    
    public ItemStack getStack() {
        return this.stack;
    }
    
    public C10PacketCreativeInventoryAction(final int llllllllllllllIIIlIIIIlIIlIllIIl, final ItemStack llllllllllllllIIIlIIIIlIIlIlIlIl) {
        this.slotId = llllllllllllllIIIlIIIIlIIlIllIIl;
        this.stack = ((llllllllllllllIIIlIIIIlIIlIlIlIl != null) ? llllllllllllllIIIlIIIIlIIlIlIlIl.copy() : null);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIlIIIIlIIIllIlll) {
        this.func_180767_a((INetHandlerPlayServer)llllllllllllllIIIlIIIIlIIIllIlll);
    }
}
