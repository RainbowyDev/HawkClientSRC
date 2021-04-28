package net.minecraft.network.play.client;

import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class C14PacketTabComplete implements Packet
{
    private /* synthetic */ String message;
    private /* synthetic */ BlockPos field_179710_b;
    
    @Override
    public void writePacketData(final PacketBuffer lIlllllIllllllI) throws IOException {
        lIlllllIllllllI.writeString(StringUtils.substring(this.message, 0, 32767));
        final boolean lIlllllIlllllIl = this.field_179710_b != null;
        lIlllllIllllllI.writeBoolean(lIlllllIlllllIl);
        if (lIlllllIlllllIl) {
            lIlllllIllllllI.writeBlockPos(this.field_179710_b);
        }
    }
    
    public BlockPos func_179709_b() {
        return this.field_179710_b;
    }
    
    public C14PacketTabComplete(final String lIllllllIIlIIII, final BlockPos lIllllllIIIllII) {
        this.message = lIllllllIIlIIII;
        this.field_179710_b = lIllllllIIIllII;
    }
    
    static {
        __OBFID = "CL_00001346";
    }
    
    public C14PacketTabComplete(final String lIllllllIIlIlll) {
        this(lIllllllIIlIlll, null);
    }
    
    public void func_180756_a(final INetHandlerPlayServer lIlllllIlllIllI) {
        lIlllllIlllIllI.processTabComplete(this);
    }
    
    public C14PacketTabComplete() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lIllllllIIIIlII) throws IOException {
        this.message = lIllllllIIIIlII.readStringFromBuffer(32767);
        final boolean lIllllllIIIIllI = lIllllllIIIIlII.readBoolean();
        if (lIllllllIIIIllI) {
            this.field_179710_b = lIllllllIIIIlII.readBlockPos();
        }
    }
    
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public void processPacket(final INetHandler lIlllllIllIlIlI) {
        this.func_180756_a((INetHandlerPlayServer)lIlllllIllIlIlI);
    }
}
