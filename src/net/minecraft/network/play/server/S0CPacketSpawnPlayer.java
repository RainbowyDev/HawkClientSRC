package net.minecraft.network.play.server;

import net.minecraft.entity.*;
import java.util.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class S0CPacketSpawnPlayer implements Packet
{
    private /* synthetic */ int field_148957_a;
    private /* synthetic */ int field_148956_c;
    private /* synthetic */ List field_148958_j;
    private /* synthetic */ DataWatcher field_148960_i;
    private /* synthetic */ UUID field_179820_b;
    private /* synthetic */ int field_148953_d;
    private /* synthetic */ int field_148954_e;
    private /* synthetic */ int field_148959_h;
    private /* synthetic */ byte field_148951_f;
    private /* synthetic */ byte field_148952_g;
    
    public int func_148947_k() {
        return this.field_148959_h;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIIIIllIIlIIlIIll) throws IOException {
        llllllllllllllllIIIIllIIlIIlIIll.writeVarIntToBuffer(this.field_148957_a);
        llllllllllllllllIIIIllIIlIIlIIll.writeUuid(this.field_179820_b);
        llllllllllllllllIIIIllIIlIIlIIll.writeInt(this.field_148956_c);
        llllllllllllllllIIIIllIIlIIlIIll.writeInt(this.field_148953_d);
        llllllllllllllllIIIIllIIlIIlIIll.writeInt(this.field_148954_e);
        llllllllllllllllIIIIllIIlIIlIIll.writeByte(this.field_148951_f);
        llllllllllllllllIIIIllIIlIIlIIll.writeByte(this.field_148952_g);
        llllllllllllllllIIIIllIIlIIlIIll.writeShort(this.field_148959_h);
        this.field_148960_i.writeTo(llllllllllllllllIIIIllIIlIIlIIll);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIIIIllIIIllIlllI) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllllIIIIllIIIllIlllI);
    }
    
    public int func_148949_g() {
        return this.field_148953_d;
    }
    
    public int func_148943_d() {
        return this.field_148957_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIIIIllIIlIIllIIl) throws IOException {
        this.field_148957_a = llllllllllllllllIIIIllIIlIIllIIl.readVarIntFromBuffer();
        this.field_179820_b = llllllllllllllllIIIIllIIlIIllIIl.readUuid();
        this.field_148956_c = llllllllllllllllIIIIllIIlIIllIIl.readInt();
        this.field_148953_d = llllllllllllllllIIIIllIIlIIllIIl.readInt();
        this.field_148954_e = llllllllllllllllIIIIllIIlIIllIIl.readInt();
        this.field_148951_f = llllllllllllllllIIIIllIIlIIllIIl.readByte();
        this.field_148952_g = llllllllllllllllIIIIllIIlIIllIIl.readByte();
        this.field_148959_h = llllllllllllllllIIIIllIIlIIllIIl.readShort();
        this.field_148958_j = DataWatcher.readWatchedListFromPacketBuffer(llllllllllllllllIIIIllIIlIIllIIl);
    }
    
    public int func_148946_h() {
        return this.field_148954_e;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllllIIIIllIIlIIIllll) {
        llllllllllllllllIIIIllIIlIIIllll.handleSpawnPlayer(this);
    }
    
    public List func_148944_c() {
        if (this.field_148958_j == null) {
            this.field_148958_j = this.field_148960_i.getAllWatched();
        }
        return this.field_148958_j;
    }
    
    public byte func_148945_j() {
        return this.field_148952_g;
    }
    
    public byte func_148941_i() {
        return this.field_148951_f;
    }
    
    public S0CPacketSpawnPlayer(final EntityPlayer llllllllllllllllIIIIllIIlIlIIIll) {
        this.field_148957_a = llllllllllllllllIIIIllIIlIlIIIll.getEntityId();
        this.field_179820_b = llllllllllllllllIIIIllIIlIlIIIll.getGameProfile().getId();
        this.field_148956_c = MathHelper.floor_double(llllllllllllllllIIIIllIIlIlIIIll.posX * 32.0);
        this.field_148953_d = MathHelper.floor_double(llllllllllllllllIIIIllIIlIlIIIll.posY * 32.0);
        this.field_148954_e = MathHelper.floor_double(llllllllllllllllIIIIllIIlIlIIIll.posZ * 32.0);
        this.field_148951_f = (byte)(llllllllllllllllIIIIllIIlIlIIIll.rotationYaw * 256.0f / 360.0f);
        this.field_148952_g = (byte)(llllllllllllllllIIIIllIIlIlIIIll.rotationPitch * 256.0f / 360.0f);
        final ItemStack llllllllllllllllIIIIllIIlIlIIIlI = llllllllllllllllIIIIllIIlIlIIIll.inventory.getCurrentItem();
        this.field_148959_h = ((llllllllllllllllIIIIllIIlIlIIIlI == null) ? 0 : Item.getIdFromItem(llllllllllllllllIIIIllIIlIlIIIlI.getItem()));
        this.field_148960_i = llllllllllllllllIIIIllIIlIlIIIll.getDataWatcher();
    }
    
    public int func_148942_f() {
        return this.field_148956_c;
    }
    
    public S0CPacketSpawnPlayer() {
    }
    
    public UUID func_179819_c() {
        return this.field_179820_b;
    }
    
    static {
        __OBFID = "CL_00001281";
    }
}
