package net.minecraft.network.play.client;

import net.minecraft.entity.player.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class C15PacketClientSettings implements Packet
{
    private /* synthetic */ String lang;
    private /* synthetic */ int view;
    private /* synthetic */ EntityPlayer.EnumChatVisibility chatVisibility;
    private /* synthetic */ int field_179711_e;
    private /* synthetic */ boolean enableColors;
    
    public C15PacketClientSettings() {
    }
    
    public C15PacketClientSettings(final String llllllllllllllIIIlllllllIIIIlIII, final int llllllllllllllIIIlllllllIIIIIlll, final EntityPlayer.EnumChatVisibility llllllllllllllIIIlllllllIIIIIllI, final boolean llllllllllllllIIIllllllIllllllll, final int llllllllllllllIIIllllllIlllllllI) {
        this.lang = llllllllllllllIIIlllllllIIIIlIII;
        this.view = llllllllllllllIIIlllllllIIIIIlll;
        this.chatVisibility = llllllllllllllIIIlllllllIIIIIllI;
        this.enableColors = llllllllllllllIIIllllllIllllllll;
        this.field_179711_e = llllllllllllllIIIllllllIlllllllI;
    }
    
    public int getView() {
        return this.field_179711_e;
    }
    
    public boolean isColorsEnabled() {
        return this.enableColors;
    }
    
    static {
        __OBFID = "CL_00001350";
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIllllllIlllllIlI) throws IOException {
        this.lang = llllllllllllllIIIllllllIlllllIlI.readStringFromBuffer(7);
        this.view = llllllllllllllIIIllllllIlllllIlI.readByte();
        this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility(llllllllllllllIIIllllllIlllllIlI.readByte());
        this.enableColors = llllllllllllllIIIllllllIlllllIlI.readBoolean();
        this.field_179711_e = llllllllllllllIIIllllllIlllllIlI.readUnsignedByte();
    }
    
    public void processPacket(final INetHandlerPlayServer llllllllllllllIIIllllllIlllIllII) {
        llllllllllllllIIIllllllIlllIllII.processClientSettings(this);
    }
    
    public EntityPlayer.EnumChatVisibility getChatVisibility() {
        return this.chatVisibility;
    }
    
    public String getLang() {
        return this.lang;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIllllllIllllIIlI) throws IOException {
        llllllllllllllIIIllllllIllllIIlI.writeString(this.lang);
        llllllllllllllIIIllllllIllllIIlI.writeByte(this.view);
        llllllllllllllIIIllllllIllllIIlI.writeByte(this.chatVisibility.getChatVisibility());
        llllllllllllllIIIllllllIllllIIlI.writeBoolean(this.enableColors);
        llllllllllllllIIIllllllIllllIIlI.writeByte(this.field_179711_e);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIllllllIllIlllII) {
        this.processPacket((INetHandlerPlayServer)llllllllllllllIIIllllllIllIlllII);
    }
}
