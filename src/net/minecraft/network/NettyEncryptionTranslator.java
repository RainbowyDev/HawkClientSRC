package net.minecraft.network;

import io.netty.channel.*;
import io.netty.buffer.*;
import javax.crypto.*;

public class NettyEncryptionTranslator
{
    private /* synthetic */ byte[] field_150506_c;
    private final /* synthetic */ Cipher cipher;
    private /* synthetic */ byte[] field_150505_b;
    
    protected ByteBuf decipher(final ChannelHandlerContext llIlIllllIlIIl, final ByteBuf llIlIllllIIlll) throws ShortBufferException {
        final int llIlIlllllIIIl = llIlIllllIIlll.readableBytes();
        final byte[] llIlIllllIllll = this.func_150502_a(llIlIllllIIlll);
        final ByteBuf llIlIllllIllIl = llIlIllllIlIIl.alloc().heapBuffer(this.cipher.getOutputSize(llIlIlllllIIIl));
        llIlIllllIllIl.writerIndex(this.cipher.update(llIlIllllIllll, 0, llIlIlllllIIIl, llIlIllllIllIl.array(), llIlIllllIllIl.arrayOffset()));
        return llIlIllllIllIl;
    }
    
    protected NettyEncryptionTranslator(final Cipher llIllIIIIlIIIl) {
        this.field_150505_b = new byte[0];
        this.field_150506_c = new byte[0];
        this.cipher = llIllIIIIlIIIl;
    }
    
    static {
        __OBFID = "CL_00001237";
    }
    
    protected void cipher(final ByteBuf llIlIlllIIIllI, final ByteBuf llIlIlllIIIlIl) throws ShortBufferException {
        final int llIlIlllIIIlII = llIlIlllIIIllI.readableBytes();
        final byte[] llIlIlllIIIIll = this.func_150502_a(llIlIlllIIIllI);
        final int llIlIlllIIIIlI = this.cipher.getOutputSize(llIlIlllIIIlII);
        if (this.field_150506_c.length < llIlIlllIIIIlI) {
            this.field_150506_c = new byte[llIlIlllIIIIlI];
        }
        llIlIlllIIIlIl.writeBytes(this.field_150506_c, 0, this.cipher.update(llIlIlllIIIIll, 0, llIlIlllIIIlII, this.field_150506_c));
    }
    
    private byte[] func_150502_a(final ByteBuf llIllIIIIIlIIl) {
        final int llIllIIIIIlIll = llIllIIIIIlIIl.readableBytes();
        if (this.field_150505_b.length < llIllIIIIIlIll) {
            this.field_150505_b = new byte[llIllIIIIIlIll];
        }
        llIllIIIIIlIIl.readBytes(this.field_150505_b, 0, llIllIIIIIlIll);
        return this.field_150505_b;
    }
}
