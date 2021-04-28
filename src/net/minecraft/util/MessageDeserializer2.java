package net.minecraft.util;

import io.netty.channel.*;
import java.util.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import io.netty.handler.codec.*;

public class MessageDeserializer2 extends ByteToMessageDecoder
{
    protected void decode(final ChannelHandlerContext llllllllllllllllIlllIlllIIIIIlll, final ByteBuf llllllllllllllllIlllIlllIIIIIllI, final List llllllllllllllllIlllIlllIIIIIlIl) {
        llllllllllllllllIlllIlllIIIIIllI.markReaderIndex();
        final byte[] llllllllllllllllIlllIlllIIIIIlII = new byte[3];
        for (int llllllllllllllllIlllIlllIIIIIIll = 0; llllllllllllllllIlllIlllIIIIIIll < llllllllllllllllIlllIlllIIIIIlII.length; ++llllllllllllllllIlllIlllIIIIIIll) {
            if (!llllllllllllllllIlllIlllIIIIIllI.isReadable()) {
                llllllllllllllllIlllIlllIIIIIllI.resetReaderIndex();
                return;
            }
            llllllllllllllllIlllIlllIIIIIlII[llllllllllllllllIlllIlllIIIIIIll] = llllllllllllllllIlllIlllIIIIIllI.readByte();
            if (llllllllllllllllIlllIlllIIIIIlII[llllllllllllllllIlllIlllIIIIIIll] >= 0) {
                final PacketBuffer llllllllllllllllIlllIlllIIIIIIlI = new PacketBuffer(Unpooled.wrappedBuffer(llllllllllllllllIlllIlllIIIIIlII));
                try {
                    final int llllllllllllllllIlllIlllIIIIIIIl = llllllllllllllllIlllIlllIIIIIIlI.readVarIntFromBuffer();
                    if (llllllllllllllllIlllIlllIIIIIllI.readableBytes() >= llllllllllllllllIlllIlllIIIIIIIl) {
                        llllllllllllllllIlllIlllIIIIIlIl.add(llllllllllllllllIlllIlllIIIIIllI.readBytes(llllllllllllllllIlllIlllIIIIIIIl));
                        return;
                    }
                    llllllllllllllllIlllIlllIIIIIllI.resetReaderIndex();
                }
                finally {
                    llllllllllllllllIlllIlllIIIIIIlI.release();
                }
                llllllllllllllllIlllIlllIIIIIIlI.release();
                return;
            }
        }
        throw new CorruptedFrameException("length wider than 21-bit");
    }
    
    static {
        __OBFID = "CL_00001255";
    }
}
