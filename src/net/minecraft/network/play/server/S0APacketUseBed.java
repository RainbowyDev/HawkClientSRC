package net.minecraft.network.play.server;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S0APacketUseBed implements Packet
{
    private /* synthetic */ int playerID;
    private /* synthetic */ BlockPos field_179799_b;
    
    public S0APacketUseBed() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIllIlIIlIIlIlIlI) throws IOException {
        lllllllllllllllIIllIlIIlIIlIlIlI.writeVarIntToBuffer(this.playerID);
        lllllllllllllllIIllIlIIlIIlIlIlI.writeBlockPos(this.field_179799_b);
    }
    
    public BlockPos func_179798_a() {
        return this.field_179799_b;
    }
    
    public EntityPlayer getPlayer(final World lllllllllllllllIIllIlIIlIIIlllII) {
        return (EntityPlayer)lllllllllllllllIIllIlIIlIIIlllII.getEntityByID(this.playerID);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIllIlIIlIIIlIlIl) {
        this.func_180744_a((INetHandlerPlayClient)lllllllllllllllIIllIlIIlIIIlIlIl);
    }
    
    static {
        __OBFID = "CL_00001319";
    }
    
    public void func_180744_a(final INetHandlerPlayClient lllllllllllllllIIllIlIIlIIlIIIlI) {
        lllllllllllllllIIllIlIIlIIlIIIlI.handleUseBed(this);
    }
    
    public S0APacketUseBed(final EntityPlayer lllllllllllllllIIllIlIIlIIlllIII, final BlockPos lllllllllllllllIIllIlIIlIIllIlII) {
        this.playerID = lllllllllllllllIIllIlIIlIIlllIII.getEntityId();
        this.field_179799_b = lllllllllllllllIIllIlIIlIIllIlII;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIllIlIIlIIllIIII) throws IOException {
        this.playerID = lllllllllllllllIIllIlIIlIIllIIII.readVarIntFromBuffer();
        this.field_179799_b = lllllllllllllllIIllIlIIlIIllIIII.readBlockPos();
    }
}
