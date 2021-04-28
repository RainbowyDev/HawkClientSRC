package net.minecraft.network.play.client;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class C19PacketResourcePackStatus implements Packet
{
    private /* synthetic */ Action field_179719_b;
    private /* synthetic */ String field_179720_a;
    
    public C19PacketResourcePackStatus(String llllllllllllllIlIlllIlllIIllllll, final Action llllllllllllllIlIlllIlllIlIIIIIl) {
        if (llllllllllllllIlIlllIlllIIllllll.length() > 40) {
            llllllllllllllIlIlllIlllIIllllll = llllllllllllllIlIlllIlllIIllllll.substring(0, 40);
        }
        this.field_179720_a = llllllllllllllIlIlllIlllIIllllll;
        this.field_179719_b = llllllllllllllIlIlllIlllIlIIIIIl;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIlllIlllIIlllIII) throws IOException {
        this.field_179720_a = llllllllllllllIlIlllIlllIIlllIII.readStringFromBuffer(40);
        this.field_179719_b = (Action)llllllllllllllIlIlllIlllIIlllIII.readEnumValue(Action.class);
    }
    
    static {
        __OBFID = "CL_00002282";
    }
    
    public C19PacketResourcePackStatus() {
    }
    
    public void func_179718_a(final INetHandlerPlayServer llllllllllllllIlIlllIlllIIlIlllI) {
        llllllllllllllIlIlllIlllIIlIlllI.func_175086_a(this);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlIlllIlllIIlIlIII) {
        this.func_179718_a((INetHandlerPlayServer)llllllllllllllIlIlllIlllIIlIlIII);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIlllIlllIIllIIlI) throws IOException {
        llllllllllllllIlIlllIlllIIllIIlI.writeString(this.field_179720_a);
        llllllllllllllIlIlllIlllIIllIIlI.writeEnumValue(this.field_179719_b);
    }
    
    public enum Action
    {
        DECLINED("DECLINED", 1, "DECLINED", 1), 
        ACCEPTED("ACCEPTED", 3, "ACCEPTED", 3), 
        FAILED_DOWNLOAD("FAILED_DOWNLOAD", 2, "FAILED_DOWNLOAD", 2), 
        SUCCESSFULLY_LOADED("SUCCESSFULLY_LOADED", 0, "SUCCESSFULLY_LOADED", 0);
        
        static {
            __OBFID = "CL_00002281";
        }
        
        private Action(final String llllllllllllllIIIIIIIlIlllIlIIII, final int llllllllllllllIIIIIIIlIlllIIllll, final String llllllllllllllIIIIIIIlIlllIlIIll, final int llllllllllllllIIIIIIIlIlllIlIIlI) {
        }
    }
}
