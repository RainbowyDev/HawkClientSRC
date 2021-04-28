package net.minecraft.realms;

import net.minecraft.util.*;
import net.minecraft.network.status.*;
import net.minecraft.network.status.server.*;
import net.minecraft.network.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.status.client.*;
import java.net.*;
import com.google.common.collect.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class RealmsServerStatusPinger
{
    private final /* synthetic */ List connections;
    private static final /* synthetic */ Logger LOGGER;
    
    public void removeAll() {
        final List llllllllllllllIIIlllIllllllllllI = this.connections;
        synchronized (this.connections) {
            final Iterator llllllllllllllIIIlllIlllllllllIl = this.connections.iterator();
            while (llllllllllllllIIIlllIlllllllllIl.hasNext()) {
                final NetworkManager llllllllllllllIIIlllIlllllllllII = llllllllllllllIIIlllIlllllllllIl.next();
                if (llllllllllllllIIIlllIlllllllllII.isChannelOpen()) {
                    llllllllllllllIIIlllIlllllllllIl.remove();
                    llllllllllllllIIIlllIlllllllllII.closeChannel(new ChatComponentText("Cancelled"));
                }
            }
        }
        // monitorexit(this.connections)
    }
    
    public void pingServer(final String llllllllllllllIIIllllIIIIIIlllIl, final RealmsServerPing llllllllllllllIIIllllIIIIIIlIllI) throws UnknownHostException {
        if (llllllllllllllIIIllllIIIIIIlllIl != null && !llllllllllllllIIIllllIIIIIIlllIl.startsWith("0.0.0.0") && !llllllllllllllIIIllllIIIIIIlllIl.isEmpty()) {
            final RealmsServerAddress llllllllllllllIIIllllIIIIIIllIll = RealmsServerAddress.parseString(llllllllllllllIIIllllIIIIIIlllIl);
            final NetworkManager llllllllllllllIIIllllIIIIIIllIlI = NetworkManager.provideLanClient(InetAddress.getByName(llllllllllllllIIIllllIIIIIIllIll.getHost()), llllllllllllllIIIllllIIIIIIllIll.getPort());
            this.connections.add(llllllllllllllIIIllllIIIIIIllIlI);
            llllllllllllllIIIllllIIIIIIllIlI.setNetHandler(new INetHandlerStatusClient() {
                private /* synthetic */ boolean field_154345_e = false;
                
                @Override
                public void handlePong(final S01PacketPong lllllllllllllllIlIlIllllIlIllIlI) {
                    llllllllllllllIIIllllIIIIIIllIlI.closeChannel(new ChatComponentText("Finished"));
                }
                
                static {
                    __OBFID = "CL_00001807";
                }
                
                @Override
                public void onDisconnect(final IChatComponent lllllllllllllllIlIlIllllIlIlIlIl) {
                    if (!this.field_154345_e) {
                        RealmsServerStatusPinger.LOGGER.error(String.valueOf(new StringBuilder("Can't ping ").append(llllllllllllllIIIllllIIIIIIlllIl).append(": ").append(lllllllllllllllIlIlIllllIlIlIlIl.getUnformattedText())));
                    }
                }
                
                @Override
                public void handleServerInfo(final S00PacketServerInfo lllllllllllllllIlIlIllllIllIIIIl) {
                    final ServerStatusResponse lllllllllllllllIlIlIllllIllIIIII = lllllllllllllllIlIlIllllIllIIIIl.func_149294_c();
                    if (lllllllllllllllIlIlIllllIllIIIII.getPlayerCountData() != null) {
                        llllllllllllllIIIllllIIIIIIlIllI.nrOfPlayers = String.valueOf(lllllllllllllllIlIlIllllIllIIIII.getPlayerCountData().getOnlinePlayerCount());
                    }
                    llllllllllllllIIIllllIIIIIIllIlI.sendPacket(new C01PacketPing(Realms.currentTimeMillis()));
                    this.field_154345_e = true;
                }
            });
            try {
                llllllllllllllIIIllllIIIIIIllIlI.sendPacket(new C00Handshake(RealmsSharedConstants.NETWORK_PROTOCOL_VERSION, llllllllllllllIIIllllIIIIIIllIll.getHost(), llllllllllllllIIIllllIIIIIIllIll.getPort(), EnumConnectionState.STATUS));
                llllllllllllllIIIllllIIIIIIllIlI.sendPacket(new C00PacketServerQuery());
            }
            catch (Throwable llllllllllllllIIIllllIIIIIIllIIl) {
                RealmsServerStatusPinger.LOGGER.error((Object)llllllllllllllIIIllllIIIIIIllIIl);
            }
        }
    }
    
    public void tick() {
        final List llllllllllllllIIIllllIIIIIIIllII = this.connections;
        synchronized (this.connections) {
            final Iterator llllllllllllllIIIllllIIIIIIIlIll = this.connections.iterator();
            while (llllllllllllllIIIllllIIIIIIIlIll.hasNext()) {
                final NetworkManager llllllllllllllIIIllllIIIIIIIlIlI = llllllllllllllIIIllllIIIIIIIlIll.next();
                if (llllllllllllllIIIllllIIIIIIIlIlI.isChannelOpen()) {
                    llllllllllllllIIIllllIIIIIIIlIlI.processReceivedPackets();
                }
                else {
                    llllllllllllllIIIllllIIIIIIIlIll.remove();
                    llllllllllllllIIIllllIIIIIIIlIlI.checkDisconnected();
                }
            }
        }
        // monitorexit(this.connections)
    }
    
    public RealmsServerStatusPinger() {
        this.connections = Collections.synchronizedList((List<Object>)Lists.newArrayList());
    }
    
    static {
        __OBFID = "CL_00001854";
        LOGGER = LogManager.getLogger();
    }
}
