package net.minecraft.util;

import io.netty.handler.codec.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import net.minecraft.network.*;

public class MessageSerializer2 extends MessageToByteEncoder
{
    protected void encode(final ChannelHandlerContext llllllllllllllIIIIlIllIllIllIlII, final ByteBuf llllllllllllllIIIIlIllIllIllIIll, final ByteBuf llllllllllllllIIIIlIllIllIlIllIl) {
        final int llllllllllllllIIIIlIllIllIllIIIl = llllllllllllllIIIIlIllIllIllIIll.readableBytes();
        final int llllllllllllllIIIIlIllIllIllIIII = PacketBuffer.getVarIntSize(llllllllllllllIIIIlIllIllIllIIIl);
        if (llllllllllllllIIIIlIllIllIllIIII > 3) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("unable to fit ").append(llllllllllllllIIIIlIllIllIllIIIl).append(" into ").append(3)));
        }
        final PacketBuffer llllllllllllllIIIIlIllIllIlIllll = new PacketBuffer(llllllllllllllIIIIlIllIllIlIllIl);
        llllllllllllllIIIIlIllIllIlIllll.ensureWritable(llllllllllllllIIIIlIllIllIllIIII + llllllllllllllIIIIlIllIllIllIIIl);
        llllllllllllllIIIIlIllIllIlIllll.writeVarIntToBuffer(llllllllllllllIIIIlIllIllIllIIIl);
        llllllllllllllIIIIlIllIllIlIllll.writeBytes(llllllllllllllIIIIlIllIllIllIIll, llllllllllllllIIIIlIllIllIllIIll.readerIndex(), llllllllllllllIIIIlIllIllIllIIIl);
    }
    
    protected void encode(final ChannelHandlerContext llllllllllllllIIIIlIllIllIlIIlII, final Object llllllllllllllIIIIlIllIllIlIIIll, final ByteBuf llllllllllllllIIIIlIllIllIIllllI) {
        this.encode(llllllllllllllIIIIlIllIllIlIIlII, (ByteBuf)llllllllllllllIIIIlIllIllIlIIIll, llllllllllllllIIIIlIllIllIIllllI);
    }
    
    static {
        __OBFID = "CL_00001256";
    }
}
