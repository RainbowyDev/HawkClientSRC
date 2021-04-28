package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S10PacketSpawnPainting implements Packet
{
    private /* synthetic */ String field_148968_f;
    private /* synthetic */ BlockPos field_179838_b;
    private /* synthetic */ EnumFacing field_179839_c;
    private /* synthetic */ int field_148973_a;
    
    public BlockPos func_179837_b() {
        return this.field_179838_b;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIIIIlllllIIIIIII) throws IOException {
        this.field_148973_a = llllllllllllllIIIIIIlllllIIIIIII.readVarIntFromBuffer();
        this.field_148968_f = llllllllllllllIIIIIIlllllIIIIIII.readStringFromBuffer(EntityPainting.EnumArt.field_180001_A);
        this.field_179838_b = llllllllllllllIIIIIIlllllIIIIIII.readBlockPos();
        this.field_179839_c = EnumFacing.getHorizontal(llllllllllllllIIIIIIlllllIIIIIII.readUnsignedByte());
    }
    
    public S10PacketSpawnPainting() {
    }
    
    public String func_148961_h() {
        return this.field_148968_f;
    }
    
    public EnumFacing func_179836_c() {
        return this.field_179839_c;
    }
    
    static {
        __OBFID = "CL_00001280";
    }
    
    public int func_148965_c() {
        return this.field_148973_a;
    }
    
    public void func_180722_a(final INetHandlerPlayClient llllllllllllllIIIIIIllllIllIIlll) {
        llllllllllllllIIIIIIllllIllIIlll.handleSpawnPainting(this);
    }
    
    public S10PacketSpawnPainting(final EntityPainting llllllllllllllIIIIIIlllllIIIllIl) {
        this.field_148973_a = llllllllllllllIIIIIIlllllIIIllIl.getEntityId();
        this.field_179838_b = llllllllllllllIIIIIIlllllIIIllIl.func_174857_n();
        this.field_179839_c = llllllllllllllIIIIIIlllllIIIllIl.field_174860_b;
        this.field_148968_f = llllllllllllllIIIIIIlllllIIIllIl.art.title;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIIIIllllIllIllll) throws IOException {
        llllllllllllllIIIIIIllllIllIllll.writeVarIntToBuffer(this.field_148973_a);
        llllllllllllllIIIIIIllllIllIllll.writeString(this.field_148968_f);
        llllllllllllllIIIIIIllllIllIllll.writeBlockPos(this.field_179838_b);
        llllllllllllllIIIIIIllllIllIllll.writeByte(this.field_179839_c.getHorizontalIndex());
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIIIIllllIIlllIIl) {
        this.func_180722_a((INetHandlerPlayClient)llllllllllllllIIIIIIllllIIlllIIl);
    }
}
