package net.minecraft.network;

import io.netty.handler.codec.*;
import java.util.zip.*;
import io.netty.channel.*;
import io.netty.buffer.*;

public class NettyCompressionEncoder extends MessageToByteEncoder
{
    private /* synthetic */ int treshold;
    private final /* synthetic */ byte[] buffer;
    private final /* synthetic */ Deflater deflater;
    
    protected void compress(final ChannelHandlerContext llllllllllllllIlllIIllIlIllIllIl, final ByteBuf llllllllllllllIlllIIllIlIllIllII, final ByteBuf llllllllllllllIlllIIllIlIllIIlII) {
        final int llllllllllllllIlllIIllIlIllIlIlI = llllllllllllllIlllIIllIlIllIllII.readableBytes();
        final PacketBuffer llllllllllllllIlllIIllIlIllIlIIl = new PacketBuffer(llllllllllllllIlllIIllIlIllIIlII);
        if (llllllllllllllIlllIIllIlIllIlIlI < this.treshold) {
            llllllllllllllIlllIIllIlIllIlIIl.writeVarIntToBuffer(0);
            llllllllllllllIlllIIllIlIllIlIIl.writeBytes(llllllllllllllIlllIIllIlIllIllII);
        }
        else {
            final byte[] llllllllllllllIlllIIllIlIllIlIII = new byte[llllllllllllllIlllIIllIlIllIlIlI];
            llllllllllllllIlllIIllIlIllIllII.readBytes(llllllllllllllIlllIIllIlIllIlIII);
            llllllllllllllIlllIIllIlIllIlIIl.writeVarIntToBuffer(llllllllllllllIlllIIllIlIllIlIII.length);
            this.deflater.setInput(llllllllllllllIlllIIllIlIllIlIII, 0, llllllllllllllIlllIIllIlIllIlIlI);
            this.deflater.finish();
            while (!this.deflater.finished()) {
                final int llllllllllllllIlllIIllIlIllIIlll = this.deflater.deflate(this.buffer);
                llllllllllllllIlllIIllIlIllIlIIl.writeBytes(this.buffer, 0, llllllllllllllIlllIIllIlIllIIlll);
            }
            this.deflater.reset();
        }
    }
    
    public NettyCompressionEncoder(final int llllllllllllllIlllIIllIlIlllIllI) {
        this.buffer = new byte[8192];
        this.treshold = llllllllllllllIlllIIllIlIlllIllI;
        this.deflater = new Deflater();
    }
    
    public void setCompressionTreshold(final int llllllllllllllIlllIIllIlIlIllIlI) {
        this.treshold = llllllllllllllIlllIIllIlIlIllIlI;
    }
    
    protected void encode(final ChannelHandlerContext llllllllllllllIlllIIllIlIlIlIIII, final Object llllllllllllllIlllIIllIlIlIIllll, final ByteBuf llllllllllllllIlllIIllIlIlIIlllI) {
        this.compress(llllllllllllllIlllIIllIlIlIlIIII, (ByteBuf)llllllllllllllIlllIIllIlIlIIllll, llllllllllllllIlllIIllIlIlIIlllI);
    }
    
    static {
        __OBFID = "CL_00002313";
    }
}
