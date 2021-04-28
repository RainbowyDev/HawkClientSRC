package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import com.google.common.collect.*;
import java.io.*;
import java.util.*;
import net.minecraft.util.*;

public class S27PacketExplosion implements Packet
{
    private /* synthetic */ float field_149159_h;
    private /* synthetic */ float field_149153_g;
    private /* synthetic */ float field_149152_f;
    private /* synthetic */ double field_149158_a;
    private /* synthetic */ double field_149156_b;
    private /* synthetic */ double field_149157_c;
    private /* synthetic */ List field_149155_e;
    private /* synthetic */ float field_149154_d;
    
    public List func_149150_j() {
        return this.field_149155_e;
    }
    
    static {
        __OBFID = "CL_00001300";
    }
    
    public S27PacketExplosion() {
    }
    
    public float func_149147_e() {
        return this.field_149159_h;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIllIIlIlIllIIllIII) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIllIIlIlIllIIllIII);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllIIlIlIllllIllII) throws IOException {
        this.field_149158_a = llllllllllllllIllIIlIlIllllIllII.readFloat();
        this.field_149156_b = llllllllllllllIllIIlIlIllllIllII.readFloat();
        this.field_149157_c = llllllllllllllIllIIlIlIllllIllII.readFloat();
        this.field_149154_d = llllllllllllllIllIIlIlIllllIllII.readFloat();
        final int llllllllllllllIllIIlIlIllllllIlI = llllllllllllllIllIIlIlIllllIllII.readInt();
        this.field_149155_e = Lists.newArrayListWithCapacity(llllllllllllllIllIIlIlIllllllIlI);
        final int llllllllllllllIllIIlIlIllllllIIl = (int)this.field_149158_a;
        final int llllllllllllllIllIIlIlIllllllIII = (int)this.field_149156_b;
        final int llllllllllllllIllIIlIlIlllllIllI = (int)this.field_149157_c;
        for (int llllllllllllllIllIIlIlIlllllIlII = 0; llllllllllllllIllIIlIlIlllllIlII < llllllllllllllIllIIlIlIllllllIlI; ++llllllllllllllIllIIlIlIlllllIlII) {
            final int llllllllllllllIllIIlIlIlllllIIlI = llllllllllllllIllIIlIlIllllIllII.readByte() + llllllllllllllIllIIlIlIllllllIIl;
            final int llllllllllllllIllIIlIlIlllllIIII = llllllllllllllIllIIlIlIllllIllII.readByte() + llllllllllllllIllIIlIlIllllllIII;
            final int llllllllllllllIllIIlIlIllllIllll = llllllllllllllIllIIlIlIllllIllII.readByte() + llllllllllllllIllIIlIlIlllllIllI;
            this.field_149155_e.add(new BlockPos(llllllllllllllIllIIlIlIlllllIIlI, llllllllllllllIllIIlIlIlllllIIII, llllllllllllllIllIIlIlIllllIllll));
        }
        this.field_149152_f = llllllllllllllIllIIlIlIllllIllII.readFloat();
        this.field_149153_g = llllllllllllllIllIIlIlIllllIllII.readFloat();
        this.field_149159_h = llllllllllllllIllIIlIlIllllIllII.readFloat();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllIIlIlIlllIIllII) throws IOException {
        llllllllllllllIllIIlIlIlllIIllII.writeFloat((float)this.field_149158_a);
        llllllllllllllIllIIlIlIlllIIllII.writeFloat((float)this.field_149156_b);
        llllllllllllllIllIIlIlIlllIIllII.writeFloat((float)this.field_149157_c);
        llllllllllllllIllIIlIlIlllIIllII.writeFloat(this.field_149154_d);
        llllllllllllllIllIIlIlIlllIIllII.writeInt(this.field_149155_e.size());
        final int llllllllllllllIllIIlIlIlllIIlIll = (int)this.field_149158_a;
        final int llllllllllllllIllIIlIlIlllIIlIlI = (int)this.field_149156_b;
        final int llllllllllllllIllIIlIlIlllIIlIIl = (int)this.field_149157_c;
        for (final BlockPos llllllllllllllIllIIlIlIlllIIIlll : this.field_149155_e) {
            final int llllllllllllllIllIIlIlIlllIIIllI = llllllllllllllIllIIlIlIlllIIIlll.getX() - llllllllllllllIllIIlIlIlllIIlIll;
            final int llllllllllllllIllIIlIlIlllIIIlIl = llllllllllllllIllIIlIlIlllIIIlll.getY() - llllllllllllllIllIIlIlIlllIIlIlI;
            final int llllllllllllllIllIIlIlIlllIIIlII = llllllllllllllIllIIlIlIlllIIIlll.getZ() - llllllllllllllIllIIlIlIlllIIlIIl;
            llllllllllllllIllIIlIlIlllIIllII.writeByte(llllllllllllllIllIIlIlIlllIIIllI);
            llllllllllllllIllIIlIlIlllIIllII.writeByte(llllllllllllllIllIIlIlIlllIIIlIl);
            llllllllllllllIllIIlIlIlllIIllII.writeByte(llllllllllllllIllIIlIlIlllIIIlII);
        }
        llllllllllllllIllIIlIlIlllIIllII.writeFloat(this.field_149152_f);
        llllllllllllllIllIIlIlIlllIIllII.writeFloat(this.field_149153_g);
        llllllllllllllIllIIlIlIlllIIllII.writeFloat(this.field_149159_h);
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIllIIlIlIllIllIlII) {
        llllllllllllllIllIIlIlIllIllIlII.handleExplosion(this);
    }
    
    public double func_149148_f() {
        return this.field_149158_a;
    }
    
    public double func_149143_g() {
        return this.field_149156_b;
    }
    
    public float func_149149_c() {
        return this.field_149152_f;
    }
    
    public float func_149144_d() {
        return this.field_149153_g;
    }
    
    public double func_149145_h() {
        return this.field_149157_c;
    }
    
    public float func_149146_i() {
        return this.field_149154_d;
    }
    
    public S27PacketExplosion(final double llllllllllllllIllIIlIllIIIlIIlll, final double llllllllllllllIllIIlIllIIIIllIII, final double llllllllllllllIllIIlIllIIIIlIllI, final float llllllllllllllIllIIlIllIIIIlIlII, final List llllllllllllllIllIIlIllIIIlIIIII, final Vec3 llllllllllllllIllIIlIllIIIIllllI) {
        this.field_149158_a = llllllllllllllIllIIlIllIIIlIIlll;
        this.field_149156_b = llllllllllllllIllIIlIllIIIIllIII;
        this.field_149157_c = llllllllllllllIllIIlIllIIIIlIllI;
        this.field_149154_d = llllllllllllllIllIIlIllIIIIlIlII;
        this.field_149155_e = Lists.newArrayList((Iterable)llllllllllllllIllIIlIllIIIlIIIII);
        if (llllllllllllllIllIIlIllIIIIllllI != null) {
            this.field_149152_f = (float)llllllllllllllIllIIlIllIIIIllllI.xCoord;
            this.field_149153_g = (float)llllllllllllllIllIIlIllIIIIllllI.yCoord;
            this.field_149159_h = (float)llllllllllllllIllIIlIllIIIIllllI.zCoord;
        }
    }
}
