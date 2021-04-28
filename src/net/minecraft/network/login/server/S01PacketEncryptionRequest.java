package net.minecraft.network.login.server;

import java.security.*;
import net.minecraft.network.login.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class S01PacketEncryptionRequest implements Packet
{
    private /* synthetic */ PublicKey publicKey;
    private /* synthetic */ String hashedServerId;
    private /* synthetic */ byte[] field_149611_c;
    
    public String func_149609_c() {
        return this.hashedServerId;
    }
    
    public void processPacket(final INetHandlerLoginClient llllllllllllllIllllIIIIIIllIIIll) {
        llllllllllllllIllllIIIIIIllIIIll.handleEncryptionRequest(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllllIIIIIIllIllll) throws IOException {
        this.hashedServerId = llllllllllllllIllllIIIIIIllIllll.readStringFromBuffer(20);
        this.publicKey = CryptManager.decodePublicKey(llllllllllllllIllllIIIIIIllIllll.readByteArray());
        this.field_149611_c = llllllllllllllIllllIIIIIIllIllll.readByteArray();
    }
    
    public PublicKey func_149608_d() {
        return this.publicKey;
    }
    
    static {
        __OBFID = "CL_00001376";
    }
    
    public byte[] func_149607_e() {
        return this.field_149611_c;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIllllIIIIIIlIlIlII) {
        this.processPacket((INetHandlerLoginClient)llllllllllllllIllllIIIIIIlIlIlII);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllllIIIIIIllIlIll) throws IOException {
        llllllllllllllIllllIIIIIIllIlIll.writeString(this.hashedServerId);
        llllllllllllllIllllIIIIIIllIlIll.writeByteArray(this.publicKey.getEncoded());
        llllllllllllllIllllIIIIIIllIlIll.writeByteArray(this.field_149611_c);
    }
    
    public S01PacketEncryptionRequest(final String llllllllllllllIllllIIIIIIllllIll, final PublicKey llllllllllllllIllllIIIIIIlllIllI, final byte[] llllllllllllllIllllIIIIIIllllIIl) {
        this.hashedServerId = llllllllllllllIllllIIIIIIllllIll;
        this.publicKey = llllllllllllllIllllIIIIIIlllIllI;
        this.field_149611_c = llllllllllllllIllllIIIIIIllllIIl;
    }
    
    public S01PacketEncryptionRequest() {
    }
}
