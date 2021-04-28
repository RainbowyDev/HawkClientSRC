package net.minecraft.network.login.client;

import com.mojang.authlib.*;
import java.util.*;
import java.io.*;
import net.minecraft.network.login.*;
import net.minecraft.network.*;

public class C00PacketLoginStart implements Packet
{
    private /* synthetic */ GameProfile profile;
    
    public C00PacketLoginStart() {
    }
    
    static {
        __OBFID = "CL_00001379";
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIlIlIllIIIIlIII) throws IOException {
        this.profile = new GameProfile((UUID)null, llllllllllllllIlIIlIlIllIIIIlIII.readStringFromBuffer(16));
    }
    
    public void func_180773_a(final INetHandlerLoginServer llllllllllllllIlIIlIlIlIllllllII) {
        llllllllllllllIlIIlIlIlIllllllII.processLoginStart(this);
    }
    
    public C00PacketLoginStart(final GameProfile llllllllllllllIlIIlIlIllIIIlIIII) {
        this.profile = llllllllllllllIlIIlIlIllIIIlIIII;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlIIlIlIlIllllIIll) {
        this.func_180773_a((INetHandlerLoginServer)llllllllllllllIlIIlIlIlIllllIIll);
    }
    
    public GameProfile getProfile() {
        return this.profile;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIlIlIllIIIIIlII) throws IOException {
        llllllllllllllIlIIlIlIllIIIIIlII.writeString(this.profile.getName());
    }
}
