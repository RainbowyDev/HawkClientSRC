package net.minecraft.network.play.client;

import java.util.*;
import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;

public class C18PacketSpectate implements Packet
{
    private /* synthetic */ UUID field_179729_a;
    
    public void func_179728_a(final INetHandlerPlayServer lllllllllllllllIIIllIllIIlllIlIl) {
        lllllllllllllllIIIllIllIIlllIlIl.func_175088_a(this);
    }
    
    public C18PacketSpectate(final UUID lllllllllllllllIIIllIllIlIIIIlIl) {
        this.field_179729_a = lllllllllllllllIIIllIllIlIIIIlIl;
    }
    
    static {
        __OBFID = "CL_00002280";
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIllIllIIllllIIl) throws IOException {
        lllllllllllllllIIIllIllIIllllIIl.writeUuid(this.field_179729_a);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIllIllIIlllllll) throws IOException {
        this.field_179729_a = lllllllllllllllIIIllIllIIlllllll.readUuid();
    }
    
    public Entity func_179727_a(final WorldServer lllllllllllllllIIIllIllIIllIllIl) {
        return lllllllllllllllIIIllIllIIllIllIl.getEntityFromUuid(this.field_179729_a);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIIllIllIIllIIlll) {
        this.func_179728_a((INetHandlerPlayServer)lllllllllllllllIIIllIllIIllIIlll);
    }
    
    public C18PacketSpectate() {
    }
}
