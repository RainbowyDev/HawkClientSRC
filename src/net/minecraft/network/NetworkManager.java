package net.minecraft.network;

import io.netty.util.*;
import java.util.*;
import hawk.*;
import com.google.common.collect.*;
import hawk.events.*;
import io.netty.bootstrap.*;
import io.netty.util.concurrent.*;
import org.apache.commons.lang3.*;
import hawk.events.listeners.*;
import java.net.*;
import io.netty.handler.timeout.*;
import io.netty.channel.socket.nio.*;
import io.netty.channel.*;
import javax.crypto.*;
import net.minecraft.util.*;
import java.security.*;
import net.minecraft.server.gui.*;
import org.apache.logging.log4j.*;
import io.netty.channel.nio.*;
import com.google.common.util.concurrent.*;
import io.netty.channel.local.*;

public class NetworkManager extends SimpleChannelInboundHandler
{
    public static final /* synthetic */ Marker logMarkerNetwork;
    private final /* synthetic */ EnumPacketDirection direction;
    public static final /* synthetic */ LazyLoadBase CLIENT_LOCAL_EVENTLOOP;
    private static final /* synthetic */ Logger logger;
    public static final /* synthetic */ LazyLoadBase CLIENT_NIO_EVENTLOOP;
    private /* synthetic */ IChatComponent terminationReason;
    public static final /* synthetic */ AttributeKey attrKeyConnectionState;
    private /* synthetic */ Channel channel;
    private /* synthetic */ INetHandler packetListener;
    private /* synthetic */ SocketAddress socketAddress;
    private final /* synthetic */ Queue outboundPacketsQueue;
    private /* synthetic */ boolean disconnected;
    private /* synthetic */ boolean isEncrypted;
    
    public void exceptionCaught(final ChannelHandlerContext llllllllllllllIIlIllIIlIllIlllIl, final Throwable llllllllllllllIIlIllIIlIllIlllII) {
        NetworkManager.logger.debug(String.valueOf(new StringBuilder("Disconnecting ").append(this.getRemoteAddress())), llllllllllllllIIlIllIIlIllIlllII);
        this.closeChannel(new ChatComponentTranslation("disconnect.genericReason", new Object[] { String.valueOf(new StringBuilder("Internal Exception: ").append(llllllllllllllIIlIllIIlIllIlllII)) }));
    }
    
    protected void channelRead0(final ChannelHandlerContext llllllllllllllIIlIllIIlIIlIlIllI, final Object llllllllllllllIIlIllIIlIIlIlIIIl) {
        final EventReceivePacket llllllllllllllIIlIllIIlIIlIlIlII = new EventReceivePacket((Packet)llllllllllllllIIlIllIIlIIlIlIIIl);
        Client.onEvent(llllllllllllllIIlIllIIlIIlIlIlII);
        if (llllllllllllllIIlIllIIlIIlIlIlII.isCancelled()) {
            return;
        }
        this.channelRead0(llllllllllllllIIlIllIIlIIlIlIllI, (Packet)llllllllllllllIIlIllIIlIIlIlIIIl);
    }
    
    public NetworkManager(final EnumPacketDirection llllllllllllllIIlIllIIlIllllIlII) {
        this.outboundPacketsQueue = Queues.newConcurrentLinkedQueue();
        this.direction = llllllllllllllIIlIllIIlIllllIlII;
    }
    
    public void setNetHandler(final INetHandler llllllllllllllIIlIllIIlIllIIlIlI) {
        Validate.notNull((Object)llllllllllllllIIlIllIIlIllIIlIlI, "packetListener", new Object[0]);
        NetworkManager.logger.debug("Set listener of {} to {}", new Object[] { this, llllllllllllllIIlIllIIlIllIIlIlI });
        this.packetListener = llllllllllllllIIlIllIIlIllIIlIlI;
    }
    
    protected void channelRead0(final ChannelHandlerContext llllllllllllllIIlIllIIlIllIlIlII, final Packet llllllllllllllIIlIllIIlIllIlIIII) {
        final EventPacket llllllllllllllIIlIllIIlIllIlIIlI = new EventPacket(llllllllllllllIIlIllIIlIllIlIIII);
        llllllllllllllIIlIllIIlIllIlIIlI.setDirection(EventDirection.INCOMING);
        Client.onEvent(llllllllllllllIIlIllIIlIllIlIIlI);
        if (this.channel.isOpen()) {
            try {
                if (!llllllllllllllIIlIllIIlIllIlIIlI.isCancelled()) {
                    llllllllllllllIIlIllIIlIllIlIIII.processPacket(this.packetListener);
                }
            }
            catch (ThreadQuickExitException ex) {}
        }
    }
    
    public boolean func_179292_f() {
        return this.isEncrypted;
    }
    
    public void setCompressionTreshold(final int llllllllllllllIIlIllIIlIIlIlllll) {
        if (llllllllllllllIIlIllIIlIIlIlllll >= 0) {
            if (this.channel.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                ((NettyCompressionDecoder)this.channel.pipeline().get("decompress")).setCompressionTreshold(llllllllllllllIIlIllIIlIIlIlllll);
            }
            else {
                this.channel.pipeline().addBefore("decoder", "decompress", (ChannelHandler)new NettyCompressionDecoder(llllllllllllllIIlIllIIlIIlIlllll));
            }
            if (this.channel.pipeline().get("compress") instanceof NettyCompressionEncoder) {
                ((NettyCompressionEncoder)this.channel.pipeline().get("decompress")).setCompressionTreshold(llllllllllllllIIlIllIIlIIlIlllll);
            }
            else {
                this.channel.pipeline().addBefore("encoder", "compress", (ChannelHandler)new NettyCompressionEncoder(llllllllllllllIIlIllIIlIIlIlllll));
            }
        }
        else {
            if (this.channel.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                this.channel.pipeline().remove("decompress");
            }
            if (this.channel.pipeline().get("compress") instanceof NettyCompressionEncoder) {
                this.channel.pipeline().remove("compress");
            }
        }
    }
    
    public boolean isChannelOpen() {
        return this.channel != null && this.channel.isOpen();
    }
    
    public SocketAddress getRemoteAddress() {
        return this.socketAddress;
    }
    
    public static NetworkManager provideLocalClient(final SocketAddress llllllllllllllIIlIllIIlIIllllllI) {
        final NetworkManager llllllllllllllIIlIllIIlIIlllllll = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)NetworkManager.CLIENT_LOCAL_EVENTLOOP.getValue())).handler((ChannelHandler)new ChannelInitializer() {
            protected void initChannel(final Channel llllllllllllllIlllIIlllIIIlIIIII) {
                llllllllllllllIlllIIlllIIIlIIIII.pipeline().addLast("packet_handler", (ChannelHandler)llllllllllllllIIlIllIIlIIlllllll);
            }
            
            static {
                __OBFID = "CL_00002311";
            }
        })).channel((Class)LocalChannel.class)).connect(llllllllllllllIIlIllIIlIIllllllI).syncUninterruptibly();
        return llllllllllllllIIlIllIIlIIlllllll;
    }
    
    public void setConnectionState(final EnumConnectionState llllllllllllllIIlIllIIlIlllIIlll) {
        this.channel.attr(NetworkManager.attrKeyConnectionState).set((Object)llllllllllllllIIlIllIIlIlllIIlll);
        this.channel.config().setAutoRead(true);
        NetworkManager.logger.debug("Enabled auto read");
    }
    
    public void channelInactive(final ChannelHandlerContext llllllllllllllIIlIllIIlIlllIIIlI) {
        this.closeChannel(new ChatComponentTranslation("disconnect.endOfStream", new Object[0]));
    }
    
    private void flushOutboundQueue() {
        if (this.channel != null && this.channel.isOpen()) {
            while (!this.outboundPacketsQueue.isEmpty()) {
                final InboundHandlerTuplePacketListener llllllllllllllIIlIllIIlIlIIlllIl = this.outboundPacketsQueue.poll();
                this.dispatchPacket(llllllllllllllIIlIllIIlIlIIlllIl.packet, llllllllllllllIIlIllIIlIlIIlllIl.futureListeners);
            }
        }
    }
    
    public void checkDisconnected() {
        if (!this.hasNoChannel() && !this.isChannelOpen() && !this.disconnected) {
            this.disconnected = true;
            if (this.getExitMessage() != null) {
                this.getNetHandler().onDisconnect(this.getExitMessage());
            }
            else if (this.getNetHandler() != null) {
                this.getNetHandler().onDisconnect(new ChatComponentText("Disconnected"));
            }
        }
    }
    
    public void sendPacket(final Packet llllllllllllllIIlIllIIlIlIllIlIl, final GenericFutureListener llllllllllllllIIlIllIIlIlIlllIII, final GenericFutureListener... llllllllllllllIIlIllIIlIlIllIIll) {
        if (this.channel != null && this.channel.isOpen()) {
            this.flushOutboundQueue();
            this.dispatchPacket(llllllllllllllIIlIllIIlIlIllIlIl, (GenericFutureListener[])ArrayUtils.add((Object[])llllllllllllllIIlIllIIlIlIllIIll, 0, (Object)llllllllllllllIIlIllIIlIlIlllIII));
        }
        else {
            this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(llllllllllllllIIlIllIIlIlIllIlIl, (GenericFutureListener[])ArrayUtils.add((Object[])llllllllllllllIIlIllIIlIlIllIIll, 0, (Object)llllllllllllllIIlIllIIlIlIlllIII)));
        }
    }
    
    public IChatComponent getExitMessage() {
        return this.terminationReason;
    }
    
    public void sendPacket(final Packet llllllllllllllIIlIllIIlIllIIIIII) {
        final EventSendPacket llllllllllllllIIlIllIIlIllIIIIlI = new EventSendPacket(llllllllllllllIIlIllIIlIllIIIIII);
        Client.onEvent(llllllllllllllIIlIllIIlIllIIIIlI);
        if (llllllllllllllIIlIllIIlIllIIIIlI.isCancelled()) {
            return;
        }
        if (this.channel != null && this.channel.isOpen()) {
            this.flushOutboundQueue();
            if (!llllllllllllllIIlIllIIlIllIIIIlI.isCancelled()) {
                this.dispatchPacket(llllllllllllllIIlIllIIlIllIIIIII, null);
            }
        }
        else {
            this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(llllllllllllllIIlIllIIlIllIIIIII, (GenericFutureListener[])null));
        }
    }
    
    public boolean hasNoChannel() {
        return this.channel == null;
    }
    
    public static NetworkManager provideLanClient(final InetAddress llllllllllllllIIlIllIIlIlIIIlIII, final int llllllllllllllIIlIllIIlIlIIIIlll) {
        final NetworkManager llllllllllllllIIlIllIIlIlIIIIllI = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)NetworkManager.CLIENT_NIO_EVENTLOOP.getValue())).handler((ChannelHandler)new ChannelInitializer() {
            protected void initChannel(final Channel lllllllllllllllllllIllIllIIIIllI) {
                try {
                    lllllllllllllllllllIllIllIIIIllI.config().setOption(ChannelOption.IP_TOS, (Object)24);
                }
                catch (ChannelException ex) {}
                try {
                    lllllllllllllllllllIllIllIIIIllI.config().setOption(ChannelOption.TCP_NODELAY, (Object)false);
                }
                catch (ChannelException ex2) {}
                lllllllllllllllllllIllIllIIIIllI.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(20)).addLast("splitter", (ChannelHandler)new MessageDeserializer2()).addLast("decoder", (ChannelHandler)new MessageDeserializer(EnumPacketDirection.CLIENTBOUND)).addLast("prepender", (ChannelHandler)new MessageSerializer2()).addLast("encoder", (ChannelHandler)new MessageSerializer(EnumPacketDirection.SERVERBOUND)).addLast("packet_handler", (ChannelHandler)llllllllllllllIIlIllIIlIlIIIIllI);
            }
            
            static {
                __OBFID = "CL_00002312";
            }
        })).channel((Class)NioSocketChannel.class)).connect(llllllllllllllIIlIllIIlIlIIIlIII, llllllllllllllIIlIllIIlIlIIIIlll).syncUninterruptibly();
        return llllllllllllllIIlIllIIlIlIIIIllI;
    }
    
    public INetHandler getNetHandler() {
        return this.packetListener;
    }
    
    private void dispatchPacket(final Packet llllllllllllllIIlIllIIlIlIlIlIll, final GenericFutureListener[] llllllllllllllIIlIllIIlIlIlIlIlI) {
        final EnumConnectionState llllllllllllllIIlIllIIlIlIlIlIIl = EnumConnectionState.getFromPacket(llllllllllllllIIlIllIIlIlIlIlIll);
        final EnumConnectionState llllllllllllllIIlIllIIlIlIlIlIII = (EnumConnectionState)this.channel.attr(NetworkManager.attrKeyConnectionState).get();
        if (llllllllllllllIIlIllIIlIlIlIlIII != llllllllllllllIIlIllIIlIlIlIlIIl) {
            NetworkManager.logger.debug("Disabled auto read");
            this.channel.config().setAutoRead(false);
        }
        if (this.channel.eventLoop().inEventLoop()) {
            if (llllllllllllllIIlIllIIlIlIlIlIIl != llllllllllllllIIlIllIIlIlIlIlIII) {
                this.setConnectionState(llllllllllllllIIlIllIIlIlIlIlIIl);
            }
            final ChannelFuture llllllllllllllIIlIllIIlIlIlIIlll = this.channel.writeAndFlush((Object)llllllllllllllIIlIllIIlIlIlIlIll);
            if (llllllllllllllIIlIllIIlIlIlIlIlI != null) {
                llllllllllllllIIlIllIIlIlIlIIlll.addListeners(llllllllllllllIIlIllIIlIlIlIlIlI);
            }
            llllllllllllllIIlIllIIlIlIlIIlll.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }
        else {
            this.channel.eventLoop().execute((Runnable)new Runnable() {
                static {
                    __OBFID = "CL_00001243";
                }
                
                @Override
                public void run() {
                    if (llllllllllllllIIlIllIIlIlIlIlIIl != llllllllllllllIIlIllIIlIlIlIlIII) {
                        NetworkManager.this.setConnectionState(llllllllllllllIIlIllIIlIlIlIlIIl);
                    }
                    final ChannelFuture llllllllllllllIllIlIlIllIllIlllI = NetworkManager.this.channel.writeAndFlush((Object)llllllllllllllIIlIllIIlIlIlIlIll);
                    if (llllllllllllllIIlIllIIlIlIlIlIlI != null) {
                        llllllllllllllIllIlIlIllIllIlllI.addListeners(llllllllllllllIIlIllIIlIlIlIlIlI);
                    }
                    llllllllllllllIllIlIlIllIllIlllI.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
                }
            });
        }
    }
    
    public void enableEncryption(final SecretKey llllllllllllllIIlIllIIlIIlllIlll) {
        this.isEncrypted = true;
        this.channel.pipeline().addBefore("splitter", "decrypt", (ChannelHandler)new NettyEncryptingDecoder(CryptManager.func_151229_a(2, llllllllllllllIIlIllIIlIIlllIlll)));
        this.channel.pipeline().addBefore("prepender", "encrypt", (ChannelHandler)new NettyEncryptingEncoder(CryptManager.func_151229_a(1, llllllllllllllIIlIllIIlIIlllIlll)));
    }
    
    public void closeChannel(final IChatComponent llllllllllllllIIlIllIIlIlIIIllll) {
        if (this.channel.isOpen()) {
            this.channel.close().awaitUninterruptibly();
            this.terminationReason = llllllllllllllIIlIllIIlIlIIIllll;
        }
    }
    
    public void processReceivedPackets() {
        this.flushOutboundQueue();
        if (this.packetListener instanceof IUpdatePlayerListBox) {
            ((IUpdatePlayerListBox)this.packetListener).update();
        }
        this.channel.flush();
    }
    
    public void channelActive(final ChannelHandlerContext llllllllllllllIIlIllIIlIlllIllII) throws Exception {
        super.channelActive(llllllllllllllIIlIllIIlIlllIllII);
        this.channel = llllllllllllllIIlIllIIlIlllIllII.channel();
        this.socketAddress = this.channel.remoteAddress();
        try {
            this.setConnectionState(EnumConnectionState.HANDSHAKING);
        }
        catch (Throwable llllllllllllllIIlIllIIlIlllIlllI) {
            NetworkManager.logger.fatal((Object)llllllllllllllIIlIllIIlIlllIlllI);
        }
    }
    
    static {
        __OBFID = "CL_00001240";
        logger = LogManager.getLogger();
        logMarkerNetwork = MarkerManager.getMarker("NETWORK");
        logMarkerPackets = MarkerManager.getMarker("NETWORK_PACKETS", NetworkManager.logMarkerNetwork);
        attrKeyConnectionState = AttributeKey.valueOf("protocol");
        CLIENT_NIO_EVENTLOOP = new LazyLoadBase() {
            @Override
            protected Object load() {
                return this.genericLoad();
            }
            
            protected NioEventLoopGroup genericLoad() {
                return new NioEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Client IO #%d").setDaemon(true).build());
            }
            
            static {
                __OBFID = "CL_00001241";
            }
        };
        CLIENT_LOCAL_EVENTLOOP = new LazyLoadBase() {
            static {
                __OBFID = "CL_00001242";
            }
            
            @Override
            protected Object load() {
                return this.genericLoad();
            }
            
            protected LocalEventLoopGroup genericLoad() {
                return new LocalEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
            }
        };
    }
    
    public void disableAutoRead() {
        this.channel.config().setAutoRead(false);
    }
    
    public boolean isLocalChannel() {
        return this.channel instanceof LocalChannel || this.channel instanceof LocalServerChannel;
    }
    
    static class InboundHandlerTuplePacketListener
    {
        private final /* synthetic */ Packet packet;
        private final /* synthetic */ GenericFutureListener[] futureListeners;
        
        public InboundHandlerTuplePacketListener(final Packet llllllllllllllllIIlIIIlllIlIlIlI, final GenericFutureListener... llllllllllllllllIIlIIIlllIlIlIIl) {
            this.packet = llllllllllllllllIIlIIIlllIlIlIlI;
            this.futureListeners = llllllllllllllllIIlIIIlllIlIlIIl;
        }
        
        static {
            __OBFID = "CL_00001244";
        }
    }
}
