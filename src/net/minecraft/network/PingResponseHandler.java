package net.minecraft.network;

import org.apache.logging.log4j.*;
import io.netty.channel.*;
import io.netty.util.concurrent.*;
import java.net.*;
import com.google.common.base.*;
import net.minecraft.server.*;
import io.netty.buffer.*;

public class PingResponseHandler extends ChannelInboundHandlerAdapter
{
    private /* synthetic */ NetworkSystem networkSystem;
    private static final /* synthetic */ Logger logger;
    
    static {
        __OBFID = "CL_00001444";
        logger = LogManager.getLogger();
    }
    
    public PingResponseHandler(final NetworkSystem llllllllllllllIIllllIlIIIllIllll) {
        this.networkSystem = llllllllllllllIIllllIlIIIllIllll;
    }
    
    private void writeAndFlush(final ChannelHandlerContext llllllllllllllIIllllIlIIIIllllIl, final ByteBuf llllllllllllllIIllllIlIIIIlllllI) {
        llllllllllllllIIllllIlIIIIllllIl.pipeline().firstContext().writeAndFlush((Object)llllllllllllllIIllllIlIIIIlllllI).addListener((GenericFutureListener)ChannelFutureListener.CLOSE);
    }
    
    public void channelRead(final ChannelHandlerContext llllllllllllllIIllllIlIIIlIlIIII, final Object llllllllllllllIIllllIlIIIlIlllIl) {
        final ByteBuf llllllllllllllIIllllIlIIIlIlllII = (ByteBuf)llllllllllllllIIllllIlIIIlIlllIl;
        llllllllllllllIIllllIlIIIlIlllII.markReaderIndex();
        boolean llllllllllllllIIllllIlIIIlIllIll = true;
        try {
            if (llllllllllllllIIllllIlIIIlIlllII.readUnsignedByte() != 254) {
                return;
            }
            final InetSocketAddress llllllllllllllIIllllIlIIIlIllIlI = (InetSocketAddress)llllllllllllllIIllllIlIIIlIlIIII.channel().remoteAddress();
            final MinecraftServer llllllllllllllIIllllIlIIIlIllIIl = this.networkSystem.getServer();
            final int llllllllllllllIIllllIlIIIlIllIII = llllllllllllllIIllllIlIIIlIlllII.readableBytes();
            switch (llllllllllllllIIllllIlIIIlIllIII) {
                case 0: {
                    PingResponseHandler.logger.debug("Ping: (<1.3.x) from {}:{}", new Object[] { llllllllllllllIIllllIlIIIlIllIlI.getAddress(), llllllllllllllIIllllIlIIIlIllIlI.getPort() });
                    final String llllllllllllllIIllllIlIIIlIlIlll = String.format("%s§%d§%d", llllllllllllllIIllllIlIIIlIllIIl.getMOTD(), llllllllllllllIIllllIlIIIlIllIIl.getCurrentPlayerCount(), llllllllllllllIIllllIlIIIlIllIIl.getMaxPlayers());
                    this.writeAndFlush(llllllllllllllIIllllIlIIIlIlIIII, this.getStringBuffer(llllllllllllllIIllllIlIIIlIlIlll));
                    break;
                }
                case 1: {
                    if (llllllllllllllIIllllIlIIIlIlllII.readUnsignedByte() != 1) {
                        return;
                    }
                    PingResponseHandler.logger.debug("Ping: (1.4-1.5.x) from {}:{}", new Object[] { llllllllllllllIIllllIlIIIlIllIlI.getAddress(), llllllllllllllIIllllIlIIIlIllIlI.getPort() });
                    final String llllllllllllllIIllllIlIIIlIlIllI = String.format("§1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, llllllllllllllIIllllIlIIIlIllIIl.getMinecraftVersion(), llllllllllllllIIllllIlIIIlIllIIl.getMOTD(), llllllllllllllIIllllIlIIIlIllIIl.getCurrentPlayerCount(), llllllllllllllIIllllIlIIIlIllIIl.getMaxPlayers());
                    this.writeAndFlush(llllllllllllllIIllllIlIIIlIlIIII, this.getStringBuffer(llllllllllllllIIllllIlIIIlIlIllI));
                    break;
                }
                default: {
                    boolean llllllllllllllIIllllIlIIIlIlIlIl = llllllllllllllIIllllIlIIIlIlllII.readUnsignedByte() == 1;
                    llllllllllllllIIllllIlIIIlIlIlIl &= (llllllllllllllIIllllIlIIIlIlllII.readUnsignedByte() == 250);
                    llllllllllllllIIllllIlIIIlIlIlIl &= "MC|PingHost".equals(new String(llllllllllllllIIllllIlIIIlIlllII.readBytes(llllllllllllllIIllllIlIIIlIlllII.readShort() * 2).array(), Charsets.UTF_16BE));
                    final int llllllllllllllIIllllIlIIIlIlIlII = llllllllllllllIIllllIlIIIlIlllII.readUnsignedShort();
                    llllllllllllllIIllllIlIIIlIlIlIl &= (llllllllllllllIIllllIlIIIlIlllII.readUnsignedByte() >= 73);
                    llllllllllllllIIllllIlIIIlIlIlIl &= (3 + llllllllllllllIIllllIlIIIlIlllII.readBytes(llllllllllllllIIllllIlIIIlIlllII.readShort() * 2).array().length + 4 == llllllllllllllIIllllIlIIIlIlIlII);
                    llllllllllllllIIllllIlIIIlIlIlIl &= (llllllllllllllIIllllIlIIIlIlllII.readInt() <= 65535);
                    llllllllllllllIIllllIlIIIlIlIlIl &= (llllllllllllllIIllllIlIIIlIlllII.readableBytes() == 0);
                    if (!llllllllllllllIIllllIlIIIlIlIlIl) {
                        return;
                    }
                    PingResponseHandler.logger.debug("Ping: (1.6) from {}:{}", new Object[] { llllllllllllllIIllllIlIIIlIllIlI.getAddress(), llllllllllllllIIllllIlIIIlIllIlI.getPort() });
                    final String llllllllllllllIIllllIlIIIlIlIIll = String.format("§1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, llllllllllllllIIllllIlIIIlIllIIl.getMinecraftVersion(), llllllllllllllIIllllIlIIIlIllIIl.getMOTD(), llllllllllllllIIllllIlIIIlIllIIl.getCurrentPlayerCount(), llllllllllllllIIllllIlIIIlIllIIl.getMaxPlayers());
                    final ByteBuf llllllllllllllIIllllIlIIIlIlIIlI = this.getStringBuffer(llllllllllllllIIllllIlIIIlIlIIll);
                    try {
                        this.writeAndFlush(llllllllllllllIIllllIlIIIlIlIIII, llllllllllllllIIllllIlIIIlIlIIlI);
                    }
                    finally {
                        llllllllllllllIIllllIlIIIlIlIIlI.release();
                    }
                    llllllllllllllIIllllIlIIIlIlIIlI.release();
                    break;
                }
            }
            llllllllllllllIIllllIlIIIlIlllII.release();
            llllllllllllllIIllllIlIIIlIllIll = false;
        }
        catch (RuntimeException ex) {}
        finally {
            if (llllllllllllllIIllllIlIIIlIllIll) {
                llllllllllllllIIllllIlIIIlIlllII.resetReaderIndex();
                llllllllllllllIIllllIlIIIlIlIIII.channel().pipeline().remove("legacy_query");
                llllllllllllllIIllllIlIIIlIlIIII.fireChannelRead(llllllllllllllIIllllIlIIIlIlllIl);
            }
        }
        if (llllllllllllllIIllllIlIIIlIllIll) {
            llllllllllllllIIllllIlIIIlIlllII.resetReaderIndex();
            llllllllllllllIIllllIlIIIlIlIIII.channel().pipeline().remove("legacy_query");
            llllllllllllllIIllllIlIIIlIlIIII.fireChannelRead(llllllllllllllIIllllIlIIIlIlllIl);
        }
    }
    
    private ByteBuf getStringBuffer(final String llllllllllllllIIllllIlIIIIllIIll) {
        final ByteBuf llllllllllllllIIllllIlIIIIllIIlI = Unpooled.buffer();
        llllllllllllllIIllllIlIIIIllIIlI.writeByte(255);
        final char[] llllllllllllllIIllllIlIIIIllIIIl = llllllllllllllIIllllIlIIIIllIIll.toCharArray();
        llllllllllllllIIllllIlIIIIllIIlI.writeShort(llllllllllllllIIllllIlIIIIllIIIl.length);
        final char[] llllllllllllllIIllllIlIIIIllIIII = llllllllllllllIIllllIlIIIIllIIIl;
        for (int llllllllllllllIIllllIlIIIIlIllll = llllllllllllllIIllllIlIIIIllIIIl.length, llllllllllllllIIllllIlIIIIlIlllI = 0; llllllllllllllIIllllIlIIIIlIlllI < llllllllllllllIIllllIlIIIIlIllll; ++llllllllllllllIIllllIlIIIIlIlllI) {
            final char llllllllllllllIIllllIlIIIIlIllIl = llllllllllllllIIllllIlIIIIllIIII[llllllllllllllIIllllIlIIIIlIlllI];
            llllllllllllllIIllllIlIIIIllIIlI.writeChar((int)llllllllllllllIIllllIlIIIIlIllIl);
        }
        return llllllllllllllIIllllIlIIIIllIIlI;
    }
}
