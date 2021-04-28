package net.minecraft.client.network;

import net.minecraft.client.multiplayer.*;
import io.netty.bootstrap.*;
import com.google.common.base.*;
import io.netty.buffer.*;
import io.netty.channel.*;
import io.netty.util.concurrent.*;
import io.netty.channel.socket.nio.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.network.status.*;
import org.apache.commons.lang3.*;
import net.minecraft.client.*;
import com.mojang.authlib.*;
import net.minecraft.network.status.server.*;
import net.minecraft.network.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.status.client.*;
import java.net.*;

public class OldServerPinger
{
    private final /* synthetic */ List pingDestinations;
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ Splitter PING_RESPONSE_SPLITTER;
    
    public void pingPendingNetworks() {
        final List lllllllllllllllIIIIIlllllIlIIIII = this.pingDestinations;
        synchronized (this.pingDestinations) {
            final Iterator lllllllllllllllIIIIIlllllIIlllll = this.pingDestinations.iterator();
            while (lllllllllllllllIIIIIlllllIIlllll.hasNext()) {
                final NetworkManager lllllllllllllllIIIIIlllllIIllllI = lllllllllllllllIIIIIlllllIIlllll.next();
                if (lllllllllllllllIIIIIlllllIIllllI.isChannelOpen()) {
                    lllllllllllllllIIIIIlllllIIllllI.processReceivedPackets();
                }
                else {
                    lllllllllllllllIIIIIlllllIIlllll.remove();
                    lllllllllllllllIIIIIlllllIIllllI.checkDisconnected();
                }
            }
        }
        // monitorexit(this.pingDestinations)
    }
    
    private void tryCompatibilityPing(final ServerData lllllllllllllllIIIIIlllllIlIlIII) {
        final ServerAddress lllllllllllllllIIIIIlllllIlIlIlI = ServerAddress.func_78860_a(lllllllllllllllIIIIIlllllIlIlIII.serverIP);
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)NetworkManager.CLIENT_NIO_EVENTLOOP.getValue())).handler((ChannelHandler)new ChannelInitializer() {
            protected void initChannel(final Channel llllllllllllllllIllllIlllIIllIIl) {
                try {
                    llllllllllllllllIllllIlllIIllIIl.config().setOption(ChannelOption.IP_TOS, (Object)24);
                }
                catch (ChannelException ex) {}
                try {
                    llllllllllllllllIllllIlllIIllIIl.config().setOption(ChannelOption.TCP_NODELAY, (Object)false);
                }
                catch (ChannelException ex2) {}
                llllllllllllllllIllllIlllIIllIIl.pipeline().addLast(new ChannelHandler[] { (ChannelHandler)new SimpleChannelInboundHandler() {
                        protected void channelRead0(final ChannelHandlerContext lllllllllllllllIIIIllllIlIlIllII, final Object lllllllllllllllIIIIllllIlIlIlIII) {
                            this.channelRead0(lllllllllllllllIIIIllllIlIlIllII, (ByteBuf)lllllllllllllllIIIIllllIlIlIlIII);
                        }
                        
                        protected void channelRead0(final ChannelHandlerContext lllllllllllllllIIIIllllIllIIlIlI, final ByteBuf lllllllllllllllIIIIllllIllIIlIIl) {
                            final short lllllllllllllllIIIIllllIllIIlIII = lllllllllllllllIIIIllllIllIIlIIl.readUnsignedByte();
                            if (lllllllllllllllIIIIllllIllIIlIII == 255) {
                                final String lllllllllllllllIIIIllllIllIIIlll = new String(lllllllllllllllIIIIllllIllIIlIIl.readBytes(lllllllllllllllIIIIllllIllIIlIIl.readShort() * 2).array(), Charsets.UTF_16BE);
                                final String[] lllllllllllllllIIIIllllIllIIIllI = (String[])Iterables.toArray(OldServerPinger.PING_RESPONSE_SPLITTER.split((CharSequence)lllllllllllllllIIIIllllIllIIIlll), (Class)String.class);
                                if ("§1".equals(lllllllllllllllIIIIllllIllIIIllI[0])) {
                                    final int lllllllllllllllIIIIllllIllIIIlIl = MathHelper.parseIntWithDefault(lllllllllllllllIIIIllllIllIIIllI[1], 0);
                                    final String lllllllllllllllIIIIllllIllIIIlII = lllllllllllllllIIIIllllIllIIIllI[2];
                                    final String lllllllllllllllIIIIllllIllIIIIll = lllllllllllllllIIIIllllIllIIIllI[3];
                                    final int lllllllllllllllIIIIllllIllIIIIlI = MathHelper.parseIntWithDefault(lllllllllllllllIIIIllllIllIIIllI[4], -1);
                                    final int lllllllllllllllIIIIllllIllIIIIIl = MathHelper.parseIntWithDefault(lllllllllllllllIIIIllllIllIIIllI[5], -1);
                                    lllllllllllllllIIIIIlllllIlIlIII.version = -1;
                                    lllllllllllllllIIIIIlllllIlIlIII.gameVersion = lllllllllllllllIIIIllllIllIIIlII;
                                    lllllllllllllllIIIIIlllllIlIlIII.serverMOTD = lllllllllllllllIIIIllllIllIIIIll;
                                    lllllllllllllllIIIIIlllllIlIlIII.populationInfo = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(lllllllllllllllIIIIllllIllIIIIlI).append(EnumChatFormatting.DARK_GRAY).append("/").append(EnumChatFormatting.GRAY).append(lllllllllllllllIIIIllllIllIIIIIl));
                                }
                            }
                            lllllllllllllllIIIIllllIllIIlIlI.close();
                        }
                        
                        static {
                            __OBFID = "CL_00000895";
                        }
                        
                        public void exceptionCaught(final ChannelHandlerContext lllllllllllllllIIIIllllIlIllIIIl, final Throwable lllllllllllllllIIIIllllIlIllIIlI) {
                            lllllllllllllllIIIIllllIlIllIIIl.close();
                        }
                        
                        public void channelActive(final ChannelHandlerContext lllllllllllllllIIIIllllIllIllllI) throws Exception {
                            super.channelActive(lllllllllllllllIIIIllllIllIllllI);
                            final ByteBuf lllllllllllllllIIIIllllIlllIIllI = Unpooled.buffer();
                            try {
                                lllllllllllllllIIIIllllIlllIIllI.writeByte(254);
                                lllllllllllllllIIIIllllIlllIIllI.writeByte(1);
                                lllllllllllllllIIIIllllIlllIIllI.writeByte(250);
                                char[] lllllllllllllllIIIIllllIlllIIlIl = "MC|PingHost".toCharArray();
                                lllllllllllllllIIIIllllIlllIIllI.writeShort(lllllllllllllllIIIIllllIlllIIlIl.length);
                                char[] lllllllllllllllIIIIllllIlllIIlII = lllllllllllllllIIIIllllIlllIIlIl;
                                for (int lllllllllllllllIIIIllllIlllIIIll = lllllllllllllllIIIIllllIlllIIlIl.length, lllllllllllllllIIIIllllIlllIIIlI = 0; lllllllllllllllIIIIllllIlllIIIlI < lllllllllllllllIIIIllllIlllIIIll; ++lllllllllllllllIIIIllllIlllIIIlI) {
                                    final char lllllllllllllllIIIIllllIlllIIIIl = lllllllllllllllIIIIllllIlllIIlII[lllllllllllllllIIIIllllIlllIIIlI];
                                    lllllllllllllllIIIIllllIlllIIllI.writeChar((int)lllllllllllllllIIIIllllIlllIIIIl);
                                }
                                lllllllllllllllIIIIllllIlllIIllI.writeShort(7 + 2 * lllllllllllllllIIIIIlllllIlIlIlI.getIP().length());
                                lllllllllllllllIIIIllllIlllIIllI.writeByte(127);
                                lllllllllllllllIIIIllllIlllIIlIl = lllllllllllllllIIIIIlllllIlIlIlI.getIP().toCharArray();
                                lllllllllllllllIIIIllllIlllIIllI.writeShort(lllllllllllllllIIIIllllIlllIIlIl.length);
                                lllllllllllllllIIIIllllIlllIIlII = lllllllllllllllIIIIllllIlllIIlIl;
                                for (int lllllllllllllllIIIIllllIlllIIIll = lllllllllllllllIIIIllllIlllIIlIl.length, lllllllllllllllIIIIllllIlllIIIlI = 0; lllllllllllllllIIIIllllIlllIIIlI < lllllllllllllllIIIIllllIlllIIIll; ++lllllllllllllllIIIIllllIlllIIIlI) {
                                    final char lllllllllllllllIIIIllllIlllIIIII = lllllllllllllllIIIIllllIlllIIlII[lllllllllllllllIIIIllllIlllIIIlI];
                                    lllllllllllllllIIIIllllIlllIIllI.writeChar((int)lllllllllllllllIIIIllllIlllIIIII);
                                }
                                lllllllllllllllIIIIllllIlllIIllI.writeInt(lllllllllllllllIIIIIlllllIlIlIlI.getPort());
                                lllllllllllllllIIIIllllIllIllllI.channel().writeAndFlush((Object)lllllllllllllllIIIIllllIlllIIllI).addListener((GenericFutureListener)ChannelFutureListener.CLOSE_ON_FAILURE);
                            }
                            finally {
                                lllllllllllllllIIIIllllIlllIIllI.release();
                            }
                            lllllllllllllllIIIIllllIlllIIllI.release();
                        }
                    } });
            }
            
            static {
                __OBFID = "CL_00000894";
            }
        })).channel((Class)NioSocketChannel.class)).connect(lllllllllllllllIIIIIlllllIlIlIlI.getIP(), lllllllllllllllIIIIIlllllIlIlIlI.getPort());
    }
    
    public OldServerPinger() {
        this.pingDestinations = Collections.synchronizedList((List<Object>)Lists.newArrayList());
    }
    
    public void clearPendingNetworks() {
        final List lllllllllllllllIIIIIlllllIIlIIlI = this.pingDestinations;
        synchronized (this.pingDestinations) {
            final Iterator lllllllllllllllIIIIIlllllIIlIIIl = this.pingDestinations.iterator();
            while (lllllllllllllllIIIIIlllllIIlIIIl.hasNext()) {
                final NetworkManager lllllllllllllllIIIIIlllllIIlIIII = lllllllllllllllIIIIIlllllIIlIIIl.next();
                if (lllllllllllllllIIIIIlllllIIlIIII.isChannelOpen()) {
                    lllllllllllllllIIIIIlllllIIlIIIl.remove();
                    lllllllllllllllIIIIIlllllIIlIIII.closeChannel(new ChatComponentText("Cancelled"));
                }
            }
        }
        // monitorexit(this.pingDestinations)
    }
    
    static {
        __OBFID = "CL_00000892";
        PING_RESPONSE_SPLITTER = Splitter.on('\0').limit(6);
        logger = LogManager.getLogger();
    }
    
    public void ping(final ServerData lllllllllllllllIIIIIlllllIlllIII) throws UnknownHostException {
        final ServerAddress lllllllllllllllIIIIIlllllIllIlll = ServerAddress.func_78860_a(lllllllllllllllIIIIIlllllIlllIII.serverIP);
        final NetworkManager lllllllllllllllIIIIIlllllIllIllI = NetworkManager.provideLanClient(InetAddress.getByName(lllllllllllllllIIIIIlllllIllIlll.getIP()), lllllllllllllllIIIIIlllllIllIlll.getPort());
        this.pingDestinations.add(lllllllllllllllIIIIIlllllIllIllI);
        lllllllllllllllIIIIIlllllIlllIII.serverMOTD = "Pinging...";
        lllllllllllllllIIIIIlllllIlllIII.pingToServer = -1L;
        lllllllllllllllIIIIIlllllIlllIII.playerList = null;
        lllllllllllllllIIIIIlllllIllIllI.setNetHandler(new INetHandlerStatusClient() {
            private /* synthetic */ long field_175092_e = 0L;
            private /* synthetic */ boolean field_147403_d = false;
            
            @Override
            public void onDisconnect(final IChatComponent llllllllllllllIlIIIIIIIIlIIlIIII) {
                if (!this.field_147403_d) {
                    OldServerPinger.logger.error(String.valueOf(new StringBuilder("Can't ping ").append(lllllllllllllllIIIIIlllllIlllIII.serverIP).append(": ").append(llllllllllllllIlIIIIIIIIlIIlIIII.getUnformattedText())));
                    lllllllllllllllIIIIIlllllIlllIII.serverMOTD = String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_RED).append("Can't connect to server."));
                    lllllllllllllllIIIIIlllllIlllIII.populationInfo = "";
                    OldServerPinger.this.tryCompatibilityPing(lllllllllllllllIIIIIlllllIlllIII);
                }
            }
            
            @Override
            public void handleServerInfo(final S00PacketServerInfo llllllllllllllIlIIIIIIIIlIlIllIl) {
                final ServerStatusResponse llllllllllllllIlIIIIIIIIlIlIllII = llllllllllllllIlIIIIIIIIlIlIllIl.func_149294_c();
                if (llllllllllllllIlIIIIIIIIlIlIllII.getServerDescription() != null) {
                    lllllllllllllllIIIIIlllllIlllIII.serverMOTD = llllllllllllllIlIIIIIIIIlIlIllII.getServerDescription().getFormattedText();
                }
                else {
                    lllllllllllllllIIIIIlllllIlllIII.serverMOTD = "";
                }
                if (llllllllllllllIlIIIIIIIIlIlIllII.getProtocolVersionInfo() != null) {
                    lllllllllllllllIIIIIlllllIlllIII.gameVersion = llllllllllllllIlIIIIIIIIlIlIllII.getProtocolVersionInfo().getName();
                    lllllllllllllllIIIIIlllllIlllIII.version = llllllllllllllIlIIIIIIIIlIlIllII.getProtocolVersionInfo().getProtocol();
                }
                else {
                    lllllllllllllllIIIIIlllllIlllIII.gameVersion = "Old";
                    lllllllllllllllIIIIIlllllIlllIII.version = 0;
                }
                if (llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData() != null) {
                    lllllllllllllllIIIIIlllllIlllIII.populationInfo = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData().getOnlinePlayerCount()).append(EnumChatFormatting.DARK_GRAY).append("/").append(EnumChatFormatting.GRAY).append(llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData().getMaxPlayers()));
                    if (ArrayUtils.isNotEmpty((Object[])llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData().getPlayers())) {
                        final StringBuilder llllllllllllllIlIIIIIIIIlIlIlIll = new StringBuilder();
                        for (final GameProfile llllllllllllllIlIIIIIIIIlIlIIlll : llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData().getPlayers()) {
                            if (llllllllllllllIlIIIIIIIIlIlIlIll.length() > 0) {
                                llllllllllllllIlIIIIIIIIlIlIlIll.append("\n");
                            }
                            llllllllllllllIlIIIIIIIIlIlIlIll.append(llllllllllllllIlIIIIIIIIlIlIIlll.getName());
                        }
                        if (llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData().getPlayers().length < llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData().getOnlinePlayerCount()) {
                            if (llllllllllllllIlIIIIIIIIlIlIlIll.length() > 0) {
                                llllllllllllllIlIIIIIIIIlIlIlIll.append("\n");
                            }
                            llllllllllllllIlIIIIIIIIlIlIlIll.append("... and ").append(llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData().getOnlinePlayerCount() - llllllllllllllIlIIIIIIIIlIlIllII.getPlayerCountData().getPlayers().length).append(" more ...");
                        }
                        lllllllllllllllIIIIIlllllIlllIII.playerList = String.valueOf(llllllllllllllIlIIIIIIIIlIlIlIll);
                    }
                }
                else {
                    lllllllllllllllIIIIIlllllIlllIII.populationInfo = String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_GRAY).append("???"));
                }
                if (llllllllllllllIlIIIIIIIIlIlIllII.getFavicon() != null) {
                    final String llllllllllllllIlIIIIIIIIlIlIIllI = llllllllllllllIlIIIIIIIIlIlIllII.getFavicon();
                    if (llllllllllllllIlIIIIIIIIlIlIIllI.startsWith("data:image/png;base64,")) {
                        lllllllllllllllIIIIIlllllIlllIII.setBase64EncodedIconData(llllllllllllllIlIIIIIIIIlIlIIllI.substring("data:image/png;base64,".length()));
                    }
                    else {
                        OldServerPinger.logger.error("Invalid server icon (unknown format)");
                    }
                }
                else {
                    lllllllllllllllIIIIIlllllIlllIII.setBase64EncodedIconData(null);
                }
                this.field_175092_e = Minecraft.getSystemTime();
                lllllllllllllllIIIIIlllllIllIllI.sendPacket(new C01PacketPing(this.field_175092_e));
                this.field_147403_d = true;
            }
            
            @Override
            public void handlePong(final S01PacketPong llllllllllllllIlIIIIIIIIlIIllIIl) {
                final long llllllllllllllIlIIIIIIIIlIIllIII = this.field_175092_e;
                final long llllllllllllllIlIIIIIIIIlIIlIlll = Minecraft.getSystemTime();
                lllllllllllllllIIIIIlllllIlllIII.pingToServer = llllllllllllllIlIIIIIIIIlIIlIlll - llllllllllllllIlIIIIIIIIlIIllIII;
                lllllllllllllllIIIIIlllllIllIllI.closeChannel(new ChatComponentText("Finished"));
            }
            
            static {
                __OBFID = "CL_00000893";
            }
        });
        try {
            lllllllllllllllIIIIIlllllIllIllI.sendPacket(new C00Handshake(47, lllllllllllllllIIIIIlllllIllIlll.getIP(), lllllllllllllllIIIIIlllllIllIlll.getPort(), EnumConnectionState.STATUS));
            lllllllllllllllIIIIIlllllIllIllI.sendPacket(new C00PacketServerQuery());
        }
        catch (Throwable lllllllllllllllIIIIIlllllIllIlIl) {
            OldServerPinger.logger.error((Object)lllllllllllllllIIIIIlllllIllIlIl);
        }
    }
}
