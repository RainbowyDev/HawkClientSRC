package net.minecraft.network;

import io.netty.handler.codec.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import javax.crypto.*;

public class NettyEncryptingEncoder extends MessageToByteEncoder
{
    private final /* synthetic */ NettyEncryptionTranslator encryptionCodec;
    
    protected void encode(final ChannelHandlerContext llllllllllllllIIlIIIIllllIlIllII, final ByteBuf llllllllllllllIIlIIIIllllIlIlIll, final ByteBuf llllllllllllllIIlIIIIllllIlIlIlI) throws ShortBufferException {
        this.encryptionCodec.cipher(llllllllllllllIIlIIIIllllIlIlIll, llllllllllllllIIlIIIIllllIlIlIlI);
    }
    
    public NettyEncryptingEncoder(final Cipher llllllllllllllIIlIIIIllllIllIIIl) {
        this.encryptionCodec = new NettyEncryptionTranslator(llllllllllllllIIlIIIIllllIllIIIl);
    }
    
    protected void encode(final ChannelHandlerContext llllllllllllllIIlIIIIllllIIlllIl, final Object llllllllllllllIIlIIIIllllIlIIIII, final ByteBuf llllllllllllllIIlIIIIllllIIllIll) throws ShortBufferException {
        this.encode(llllllllllllllIIlIIIIllllIIlllIl, (ByteBuf)llllllllllllllIIlIIIIllllIlIIIII, llllllllllllllIIlIIIIllllIIllIll);
    }
    
    static {
        __OBFID = "CL_00001239";
    }
}
