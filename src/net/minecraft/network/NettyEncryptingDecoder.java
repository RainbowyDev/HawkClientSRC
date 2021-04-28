package net.minecraft.network;

import io.netty.handler.codec.*;
import io.netty.channel.*;
import java.util.*;
import io.netty.buffer.*;
import javax.crypto.*;

public class NettyEncryptingDecoder extends MessageToMessageDecoder
{
    private final /* synthetic */ NettyEncryptionTranslator decryptionCodec;
    
    static {
        __OBFID = "CL_00001238";
    }
    
    protected void decode(final ChannelHandlerContext llllllllllllllIlIlIlllIIIIIllIII, final Object llllllllllllllIlIlIlllIIIIIlIIll, final List llllllllllllllIlIlIlllIIIIIlIllI) throws ShortBufferException {
        this.decode(llllllllllllllIlIlIlllIIIIIllIII, (ByteBuf)llllllllllllllIlIlIlllIIIIIlIIll, llllllllllllllIlIlIlllIIIIIlIllI);
    }
    
    public NettyEncryptingDecoder(final Cipher llllllllllllllIlIlIlllIIIIlIllII) {
        this.decryptionCodec = new NettyEncryptionTranslator(llllllllllllllIlIlIlllIIIIlIllII);
    }
    
    protected void decode(final ChannelHandlerContext llllllllllllllIlIlIlllIIIIlIIIII, final ByteBuf llllllllllllllIlIlIlllIIIIlIIIll, final List llllllllllllllIlIlIlllIIIIIllllI) throws ShortBufferException {
        llllllllllllllIlIlIlllIIIIIllllI.add(this.decryptionCodec.decipher(llllllllllllllIlIlIlllIIIIlIIIII, llllllllllllllIlIlIlllIIIIlIIIll));
    }
}
