package net.minecraft.network.play.client;

import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class C08PacketPlayerBlockPlacement implements Packet
{
    private static final /* synthetic */ BlockPos field_179726_a;
    private /* synthetic */ ItemStack stack;
    private /* synthetic */ int placedBlockDirection;
    private /* synthetic */ float facingY;
    private /* synthetic */ float facingZ;
    private /* synthetic */ float facingX;
    private /* synthetic */ BlockPos field_179725_b;
    
    public ItemStack getStack() {
        return this.stack;
    }
    
    public float getPlacedBlockOffsetX() {
        return this.facingX;
    }
    
    static {
        __OBFID = "CL_00001371";
        field_179726_a = new BlockPos(-1, -1, -1);
    }
    
    public BlockPos func_179724_a() {
        return this.field_179725_b;
    }
    
    public float getPlacedBlockOffsetZ() {
        return this.facingZ;
    }
    
    public void func_180769_a(final INetHandlerPlayServer lIlIllIIIllIllI) {
        lIlIllIIIllIllI.processPlayerBlockPlacement(this);
    }
    
    public C08PacketPlayerBlockPlacement(final BlockPos lIlIllIIlIIlIll, final int lIlIllIIlIlIIIl, final ItemStack lIlIllIIlIlIIII, final float lIlIllIIlIIllll, final float lIlIllIIlIIIlll, final float lIlIllIIlIIIllI) {
        this.field_179725_b = lIlIllIIlIIlIll;
        this.placedBlockDirection = lIlIllIIlIlIIIl;
        this.stack = ((lIlIllIIlIlIIII != null) ? lIlIllIIlIlIIII.copy() : null);
        this.facingX = lIlIllIIlIIllll;
        this.facingY = lIlIllIIlIIIlll;
        this.facingZ = lIlIllIIlIIIllI;
    }
    
    public C08PacketPlayerBlockPlacement() {
    }
    
    public float getPlacedBlockOffsetY() {
        return this.facingY;
    }
    
    public C08PacketPlayerBlockPlacement(final ItemStack lIlIllIIlIlllIl) {
        this(C08PacketPlayerBlockPlacement.field_179726_a, 255, lIlIllIIlIlllIl, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void processPacket(final INetHandler lIlIllIIIIlllII) {
        this.func_180769_a((INetHandlerPlayServer)lIlIllIIIIlllII);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lIlIllIIlIIIIlI) throws IOException {
        this.field_179725_b = lIlIllIIlIIIIlI.readBlockPos();
        this.placedBlockDirection = lIlIllIIlIIIIlI.readUnsignedByte();
        this.stack = lIlIllIIlIIIIlI.readItemStackFromBuffer();
        this.facingX = lIlIllIIlIIIIlI.readUnsignedByte() / 16.0f;
        this.facingY = lIlIllIIlIIIIlI.readUnsignedByte() / 16.0f;
        this.facingZ = lIlIllIIlIIIIlI.readUnsignedByte() / 16.0f;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lIlIllIIIlllIlI) throws IOException {
        lIlIllIIIlllIlI.writeBlockPos(this.field_179725_b);
        lIlIllIIIlllIlI.writeByte(this.placedBlockDirection);
        lIlIllIIIlllIlI.writeItemStackToBuffer(this.stack);
        lIlIllIIIlllIlI.writeByte((int)(this.facingX * 16.0f));
        lIlIllIIIlllIlI.writeByte((int)(this.facingY * 16.0f));
        lIlIllIIIlllIlI.writeByte((int)(this.facingZ * 16.0f));
    }
    
    public int getPlacedBlockDirection() {
        return this.placedBlockDirection;
    }
}
