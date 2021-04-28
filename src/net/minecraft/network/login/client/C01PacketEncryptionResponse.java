package net.minecraft.network.login.client;

import java.io.*;
import net.minecraft.util.*;
import net.minecraft.network.login.*;
import javax.crypto.*;
import net.minecraft.network.*;
import java.security.*;

public class C01PacketEncryptionResponse implements Packet
{
    private /* synthetic */ byte[] field_149302_a;
    private /* synthetic */ byte[] field_149301_b;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIIIlIlIllIllllII) throws IOException {
        this.field_149302_a = llllllllllllllllIIIlIlIllIllllII.readByteArray();
        this.field_149301_b = llllllllllllllllIIIlIlIllIllllII.readByteArray();
    }
    
    public byte[] func_149299_b(final PrivateKey llllllllllllllllIIIlIlIllIlIIllI) {
        return (llllllllllllllllIIIlIlIllIlIIllI == null) ? this.field_149301_b : CryptManager.decryptData(llllllllllllllllIIIlIlIllIlIIllI, this.field_149301_b);
    }
    
    public void processPacket(final INetHandlerLoginServer llllllllllllllllIIIlIlIllIllIIlI) {
        llllllllllllllllIIIlIlIllIllIIlI.processEncryptionResponse(this);
    }
    
    public SecretKey func_149300_a(final PrivateKey llllllllllllllllIIIlIlIllIlIllII) {
        return CryptManager.decryptSharedKey(llllllllllllllllIIIlIlIllIlIllII, this.field_149302_a);
    }
    
    public C01PacketEncryptionResponse() {
        this.field_149302_a = new byte[0];
        this.field_149301_b = new byte[0];
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIIIlIlIllIlIIIII) {
        this.processPacket((INetHandlerLoginServer)llllllllllllllllIIIlIlIllIlIIIII);
    }
    
    public C01PacketEncryptionResponse(final SecretKey llllllllllllllllIIIlIlIlllIIIlII, final PublicKey llllllllllllllllIIIlIlIlllIIIlll, final byte[] llllllllllllllllIIIlIlIlllIIIllI) {
        this.field_149302_a = new byte[0];
        this.field_149301_b = new byte[0];
        this.field_149302_a = CryptManager.encryptData(llllllllllllllllIIIlIlIlllIIIlll, llllllllllllllllIIIlIlIlllIIIlII.getEncoded());
        this.field_149301_b = CryptManager.encryptData(llllllllllllllllIIIlIlIlllIIIlll, llllllllllllllllIIIlIlIlllIIIllI);
    }
    
    static {
        __OBFID = "CL_00001380";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIIIlIlIllIlllIII) throws IOException {
        llllllllllllllllIIIlIlIllIlllIII.writeByteArray(this.field_149302_a);
        llllllllllllllllIIIlIlIllIlllIII.writeByteArray(this.field_149301_b);
    }
}
