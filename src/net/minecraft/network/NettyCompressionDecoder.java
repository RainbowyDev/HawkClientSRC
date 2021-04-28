package net.minecraft.network;

import io.netty.channel.*;
import java.util.*;
import io.netty.handler.codec.*;
import io.netty.buffer.*;
import java.util.zip.*;

public class NettyCompressionDecoder extends ByteToMessageDecoder
{
    private /* synthetic */ int treshold;
    private final /* synthetic */ Inflater inflater;
    
    public void setCompressionTreshold(final int llllllllllllllIIIlllllllllllIlII) {
        this.treshold = llllllllllllllIIIlllllllllllIlII;
    }
    
    public NettyCompressionDecoder(final int llllllllllllllIIlIIIIIIIIIlIlIll) {
        this.treshold = llllllllllllllIIlIIIIIIIIIlIlIll;
        this.inflater = new Inflater();
    }
    
    protected void decode(final ChannelHandlerContext llllllllllllllIIlIIIIIIIIIIIllIl, final ByteBuf llllllllllllllIIlIIIIIIIIIIIlIll, final List llllllllllllllIIlIIIIIIIIIIIlIIl) throws DataFormatException {
        if (llllllllllllllIIlIIIIIIIIIIIlIll.readableBytes() != 0) {
            final PacketBuffer llllllllllllllIIlIIIIIIIIIIIIlll = new PacketBuffer(llllllllllllllIIlIIIIIIIIIIIlIll);
            final int llllllllllllllIIlIIIIIIIIIIIIlIl = llllllllllllllIIlIIIIIIIIIIIIlll.readVarIntFromBuffer();
            if (llllllllllllllIIlIIIIIIIIIIIIlIl == 0) {
                llllllllllllllIIlIIIIIIIIIIIlIIl.add(llllllllllllllIIlIIIIIIIIIIIIlll.readBytes(llllllllllllllIIlIIIIIIIIIIIIlll.readableBytes()));
            }
            else {
                if (llllllllllllllIIlIIIIIIIIIIIIlIl < this.treshold) {
                    throw new DecoderException(String.valueOf(new StringBuilder("Badly compressed packet - size of ").append(llllllllllllllIIlIIIIIIIIIIIIlIl).append(" is below server threshold of ").append(this.treshold)));
                }
                if (llllllllllllllIIlIIIIIIIIIIIIlIl > 2097152) {
                    throw new DecoderException(String.valueOf(new StringBuilder("Badly compressed packet - size of ").append(llllllllllllllIIlIIIIIIIIIIIIlIl).append(" is larger than protocol maximum of ").append(2097152)));
                }
                final byte[] llllllllllllllIIlIIIIIIIIIIIIIll = new byte[llllllllllllllIIlIIIIIIIIIIIIlll.readableBytes()];
                llllllllllllllIIlIIIIIIIIIIIIlll.readBytes(llllllllllllllIIlIIIIIIIIIIIIIll);
                this.inflater.setInput(llllllllllllllIIlIIIIIIIIIIIIIll);
                final byte[] llllllllllllllIIlIIIIIIIIIIIIIlI = new byte[llllllllllllllIIlIIIIIIIIIIIIlIl];
                this.inflater.inflate(llllllllllllllIIlIIIIIIIIIIIIIlI);
                llllllllllllllIIlIIIIIIIIIIIlIIl.add(Unpooled.wrappedBuffer(llllllllllllllIIlIIIIIIIIIIIIIlI));
                this.inflater.reset();
            }
        }
    }
    
    static {
        __OBFID = "CL_00002314";
    }
}
