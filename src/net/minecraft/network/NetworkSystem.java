package net.minecraft.network;

import net.minecraft.server.*;
import com.google.common.collect.*;
import java.util.*;
import java.net.*;
import io.netty.bootstrap.*;
import io.netty.channel.socket.nio.*;
import io.netty.handler.timeout.*;
import net.minecraft.server.network.*;
import io.netty.channel.*;
import java.io.*;
import java.util.concurrent.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import io.netty.util.concurrent.*;
import net.minecraft.crash.*;
import org.apache.logging.log4j.*;
import io.netty.channel.nio.*;
import com.google.common.util.concurrent.*;
import io.netty.channel.local.*;

public class NetworkSystem
{
    public volatile /* synthetic */ boolean isAlive;
    private final /* synthetic */ List networkManagers;
    public static final /* synthetic */ LazyLoadBase eventLoops;
    private final /* synthetic */ List endpoints;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ MinecraftServer mcServer;
    
    public SocketAddress addLocalEndpoint() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/network/NetworkSystem.endpoints:Ljava/util/List;
        //     4: astore_1        /* llIllllIlIIIlll */
        //     5: aload_0         /* llIllllIlIIlIII */
        //     6: getfield        net/minecraft/network/NetworkSystem.endpoints:Ljava/util/List;
        //     9: dup            
        //    10: astore_3        /* llIllllIlIIIlIl */
        //    11: monitorenter   
        //    12: new             Lio/netty/bootstrap/ServerBootstrap;
        //    15: dup            
        //    16: invokespecial   io/netty/bootstrap/ServerBootstrap.<init>:()V
        //    19: ldc             Lio/netty/channel/local/LocalServerChannel;.class
        //    21: invokevirtual   io/netty/bootstrap/ServerBootstrap.channel:(Ljava/lang/Class;)Lio/netty/bootstrap/AbstractBootstrap;
        //    24: checkcast       Lio/netty/bootstrap/ServerBootstrap;
        //    27: new             Lnet/minecraft/network/NetworkSystem$4;
        //    30: dup            
        //    31: aload_0         /* llIllllIlIIlIII */
        //    32: invokespecial   net/minecraft/network/NetworkSystem$4.<init>:(Lnet/minecraft/network/NetworkSystem;)V
        //    35: invokevirtual   io/netty/bootstrap/ServerBootstrap.childHandler:(Lio/netty/channel/ChannelHandler;)Lio/netty/bootstrap/ServerBootstrap;
        //    38: getstatic       net/minecraft/network/NetworkSystem.eventLoops:Lnet/minecraft/util/LazyLoadBase;
        //    41: invokevirtual   net/minecraft/util/LazyLoadBase.getValue:()Ljava/lang/Object;
        //    44: checkcast       Lio/netty/channel/EventLoopGroup;
        //    47: invokevirtual   io/netty/bootstrap/ServerBootstrap.group:(Lio/netty/channel/EventLoopGroup;)Lio/netty/bootstrap/ServerBootstrap;
        //    50: getstatic       io/netty/channel/local/LocalAddress.ANY:Lio/netty/channel/local/LocalAddress;
        //    53: invokevirtual   io/netty/bootstrap/ServerBootstrap.localAddress:(Ljava/net/SocketAddress;)Lio/netty/bootstrap/AbstractBootstrap;
        //    56: checkcast       Lio/netty/bootstrap/ServerBootstrap;
        //    59: invokevirtual   io/netty/bootstrap/ServerBootstrap.bind:()Lio/netty/channel/ChannelFuture;
        //    62: invokeinterface io/netty/channel/ChannelFuture.syncUninterruptibly:()Lio/netty/channel/ChannelFuture;
        //    67: astore_2        /* llIllllIlIIlIlI */
        //    68: aload_0         /* llIllllIlIIlIII */
        //    69: getfield        net/minecraft/network/NetworkSystem.endpoints:Ljava/util/List;
        //    72: aload_2         /* llIllllIlIIlIlI */
        //    73: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    78: pop            
        //    79: aload_3         /* llIllllIlIIIlIl */
        //    80: monitorexit    
        //    81: goto            87
        //    84: aload_3         /* llIllllIlIIIlIl */
        //    85: monitorexit    
        //    86: athrow         
        //    87: aload_2         /* llIllllIlIIlIIl */
        //    88: invokeinterface io/netty/channel/ChannelFuture.channel:()Lio/netty/channel/Channel;
        //    93: invokeinterface io/netty/channel/Channel.localAddress:()Ljava/net/SocketAddress;
        //    98: areturn        
        //    StackMapTable: 00 02 FF 00 54 00 04 07 00 02 07 00 58 00 07 00 58 00 01 07 00 71 FF 00 02 00 04 07 00 02 07 00 58 07 00 53 07 00 58 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  12     81     84     87     Any
        //  84     86     84     87     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void terminateEndpoints() {
        this.isAlive = false;
        for (final ChannelFuture llIllllIIlllllI : this.endpoints) {
            try {
                llIllllIIlllllI.channel().close().sync();
            }
            catch (InterruptedException llIllllIIllllIl) {
                NetworkSystem.logger.error("Interrupted whilst closing channel");
            }
        }
    }
    
    public NetworkSystem(final MinecraftServer llIllllIlIlllll) {
        this.endpoints = Collections.synchronizedList((List<Object>)Lists.newArrayList());
        this.networkManagers = Collections.synchronizedList((List<Object>)Lists.newArrayList());
        this.mcServer = llIllllIlIlllll;
        this.isAlive = true;
    }
    
    public void addLanEndpoint(final InetAddress llIllllIlIlIlII, final int llIllllIlIlIIll) throws IOException {
        final List llIllllIlIlIllI = this.endpoints;
        synchronized (this.endpoints) {
            this.endpoints.add(((ServerBootstrap)((ServerBootstrap)new ServerBootstrap().channel((Class)NioServerSocketChannel.class)).childHandler((ChannelHandler)new ChannelInitializer() {
                protected void initChannel(final Channel llllllllllllllIlIIIlIIlIlllIlIII) {
                    try {
                        llllllllllllllIlIIIlIIlIlllIlIII.config().setOption(ChannelOption.IP_TOS, (Object)24);
                    }
                    catch (ChannelException ex) {}
                    try {
                        llllllllllllllIlIIIlIIlIlllIlIII.config().setOption(ChannelOption.TCP_NODELAY, (Object)false);
                    }
                    catch (ChannelException ex2) {}
                    llllllllllllllIlIIIlIIlIlllIlIII.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(30)).addLast("legacy_query", (ChannelHandler)new PingResponseHandler(NetworkSystem.this)).addLast("splitter", (ChannelHandler)new MessageDeserializer2()).addLast("decoder", (ChannelHandler)new MessageDeserializer(EnumPacketDirection.SERVERBOUND)).addLast("prepender", (ChannelHandler)new MessageSerializer2()).addLast("encoder", (ChannelHandler)new MessageSerializer(EnumPacketDirection.CLIENTBOUND));
                    final NetworkManager llllllllllllllIlIIIlIIlIlllIlIlI = new NetworkManager(EnumPacketDirection.SERVERBOUND);
                    NetworkSystem.this.networkManagers.add(llllllllllllllIlIIIlIIlIlllIlIlI);
                    llllllllllllllIlIIIlIIlIlllIlIII.pipeline().addLast("packet_handler", (ChannelHandler)llllllllllllllIlIIIlIIlIlllIlIlI);
                    llllllllllllllIlIIIlIIlIlllIlIlI.setNetHandler(new NetHandlerHandshakeTCP(NetworkSystem.this.mcServer, llllllllllllllIlIIIlIIlIlllIlIlI));
                }
                
                static {
                    __OBFID = "CL_00001450";
                }
            }).group((EventLoopGroup)NetworkSystem.eventLoops.getValue()).localAddress(llIllllIlIlIlII, llIllllIlIlIIll)).bind().syncUninterruptibly());
        }
        // monitorexit(this.endpoints)
    }
    
    public void networkTick() {
        final List llIllllIIlIllll = this.networkManagers;
        synchronized (this.networkManagers) {
            final Iterator llIllllIIlIlllI = this.networkManagers.iterator();
            while (llIllllIIlIlllI.hasNext()) {
                final NetworkManager llIllllIIlIllIl = llIllllIIlIlllI.next();
                if (!llIllllIIlIllIl.hasNoChannel()) {
                    if (!llIllllIIlIllIl.isChannelOpen()) {
                        llIllllIIlIlllI.remove();
                        llIllllIIlIllIl.checkDisconnected();
                    }
                    else {
                        try {
                            llIllllIIlIllIl.processReceivedPackets();
                        }
                        catch (Exception llIllllIIlIllII) {
                            if (llIllllIIlIllIl.isLocalChannel()) {
                                final CrashReport llIllllIIlIlIll = CrashReport.makeCrashReport(llIllllIIlIllII, "Ticking memory connection");
                                final CrashReportCategory llIllllIIlIlIlI = llIllllIIlIlIll.makeCategory("Ticking connection");
                                llIllllIIlIlIlI.addCrashSectionCallable("Connection", new Callable() {
                                    @Override
                                    public Object call() {
                                        return this.func_180229_a();
                                    }
                                    
                                    static {
                                        __OBFID = "CL_00002272";
                                    }
                                    
                                    public String func_180229_a() {
                                        return llIllllIIlIllIl.toString();
                                    }
                                });
                                throw new ReportedException(llIllllIIlIlIll);
                            }
                            NetworkSystem.logger.warn(String.valueOf(new StringBuilder("Failed to handle packet for ").append(llIllllIIlIllIl.getRemoteAddress())), (Throwable)llIllllIIlIllII);
                            final ChatComponentText llIllllIIlIlIIl = new ChatComponentText("Internal server error");
                            llIllllIIlIllIl.sendPacket(new S40PacketDisconnect(llIllllIIlIlIIl), (GenericFutureListener)new GenericFutureListener() {
                                public void operationComplete(final Future llllllllllllllIlIllIIIIIlIlIllll) {
                                    llIllllIIlIllIl.closeChannel(llIllllIIlIlIIl);
                                }
                                
                                static {
                                    __OBFID = "CL_00002271";
                                }
                            }, new GenericFutureListener[0]);
                            llIllllIIlIllIl.disableAutoRead();
                        }
                    }
                }
            }
        }
        // monitorexit(this.networkManagers)
    }
    
    static {
        __OBFID = "CL_00001447";
        logger = LogManager.getLogger();
        eventLoops = new LazyLoadBase() {
            static {
                __OBFID = "CL_00001448";
            }
            
            @Override
            protected Object load() {
                return this.genericLoad();
            }
            
            protected NioEventLoopGroup genericLoad() {
                return new NioEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Server IO #%d").setDaemon(true).build());
            }
        };
        SERVER_LOCAL_EVENTLOOP = new LazyLoadBase() {
            static {
                __OBFID = "CL_00001449";
            }
            
            @Override
            protected Object load() {
                return this.genericLoad();
            }
            
            protected LocalEventLoopGroup genericLoad() {
                return new LocalEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
            }
        };
    }
    
    public MinecraftServer getServer() {
        return this.mcServer;
    }
}
