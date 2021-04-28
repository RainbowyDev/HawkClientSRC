package net.minecraft.network.login.server;

import com.mojang.authlib.*;
import net.minecraft.network.login.*;
import net.minecraft.network.*;
import java.util.*;
import java.io.*;

public class S02PacketLoginSuccess implements Packet
{
    private /* synthetic */ GameProfile profile;
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIllIIIlIlIIlIIlIl) {
        this.func_180771_a((INetHandlerLoginClient)llllllllllllllIIllIIIlIlIIlIIlIl);
    }
    
    static {
        __OBFID = "CL_00001375";
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIllIIIlIlIlIIIIII) throws IOException {
        final String llllllllllllllIIllIIIlIlIlIIIlII = llllllllllllllIIllIIIlIlIlIIIIII.readStringFromBuffer(36);
        final String llllllllllllllIIllIIIlIlIlIIIIll = llllllllllllllIIllIIIlIlIlIIIIII.readStringFromBuffer(16);
        final UUID llllllllllllllIIllIIIlIlIlIIIIlI = UUID.fromString(llllllllllllllIIllIIIlIlIlIIIlII);
        this.profile = new GameProfile(llllllllllllllIIllIIIlIlIlIIIIlI, llllllllllllllIIllIIIlIlIlIIIIll);
    }
    
    public S02PacketLoginSuccess() {
    }
    
    public GameProfile func_179730_a() {
        return this.profile;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIllIIIlIlIIllIlIl) throws IOException {
        final UUID llllllllllllllIIllIIIlIlIIllIlll = this.profile.getId();
        llllllllllllllIIllIIIlIlIIllIlIl.writeString((llllllllllllllIIllIIIlIlIIllIlll == null) ? "" : llllllllllllllIIllIIIlIlIIllIlll.toString());
        llllllllllllllIIllIIIlIlIIllIlIl.writeString(this.profile.getName());
    }
    
    public S02PacketLoginSuccess(final GameProfile llllllllllllllIIllIIIlIlIlIIllII) {
        this.profile = llllllllllllllIIllIIIlIlIlIIllII;
    }
    
    public void func_180771_a(final INetHandlerLoginClient llllllllllllllIIllIIIlIlIIlIlllI) {
        llllllllllllllIIllIIIlIlIIlIlllI.handleLoginSuccess(this);
    }
}
