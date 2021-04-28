package net.minecraft.realms;

import org.apache.logging.log4j.*;
import net.minecraft.client.*;
import net.minecraft.client.network.*;
import net.minecraft.client.gui.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.*;
import net.minecraft.network.login.client.*;
import net.minecraft.util.*;
import java.net.*;

public class RealmsConnect
{
    private volatile /* synthetic */ boolean aborted;
    private /* synthetic */ NetworkManager connection;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ RealmsScreen onlineScreen;
    
    public void tick() {
        if (this.connection != null) {
            if (this.connection.isChannelOpen()) {
                this.connection.processReceivedPackets();
            }
            else {
                this.connection.checkDisconnected();
            }
        }
    }
    
    static {
        __OBFID = "CL_00001844";
        LOGGER = LogManager.getLogger();
    }
    
    public void abort() {
        this.aborted = true;
    }
    
    static /* synthetic */ void access$1(final RealmsConnect lllllllllllllllIIIlIIlIIllllIIII, final NetworkManager lllllllllllllllIIIlIIlIIlllIllll) {
        lllllllllllllllIIIlIIlIIllllIIII.connection = lllllllllllllllIIIlIIlIIlllIllll;
    }
    
    public void connect(final String lllllllllllllllIIIlIIlIIllllllll, final int lllllllllllllllIIIlIIlIIlllllllI) {
        new Thread("Realms-connect-task") {
            @Override
            public void run() {
                InetAddress lllllllllllllllIIIlIlIIllIlIIllI = null;
                try {
                    lllllllllllllllIIIlIlIIllIlIIllI = InetAddress.getByName(lllllllllllllllIIIlIIlIIllllllll);
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.access$1(RealmsConnect.this, NetworkManager.provideLanClient(lllllllllllllllIIIlIlIIllIlIIllI, lllllllllllllllIIIlIIlIIlllllllI));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.setNetHandler(new NetHandlerLoginClient(RealmsConnect.this.connection, Minecraft.getMinecraft(), RealmsConnect.this.onlineScreen.getProxy()));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.sendPacket(new C00Handshake(47, lllllllllllllllIIIlIIlIIllllllll, lllllllllllllllIIIlIIlIIlllllllI, EnumConnectionState.LOGIN));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.sendPacket(new C00PacketLoginStart(Minecraft.getMinecraft().getSession().getProfile()));
                }
                catch (UnknownHostException lllllllllllllllIIIlIlIIllIlIIlIl) {
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.LOGGER.error("Couldn't connect to world", (Throwable)lllllllllllllllIIIlIlIIllIlIIlIl);
                    Realms.setScreen(new DisconnectedRealmsScreen(RealmsConnect.this.onlineScreen, "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[] { String.valueOf(new StringBuilder("Unknown host '").append(lllllllllllllllIIIlIIlIIllllllll).append("'")) })));
                }
                catch (Exception lllllllllllllllIIIlIlIIllIlIIlII) {
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.LOGGER.error("Couldn't connect to world", (Throwable)lllllllllllllllIIIlIlIIllIlIIlII);
                    String lllllllllllllllIIIlIlIIllIlIIIll = lllllllllllllllIIIlIlIIllIlIIlII.toString();
                    if (lllllllllllllllIIIlIlIIllIlIIllI != null) {
                        final String lllllllllllllllIIIlIlIIllIlIIIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIlIlIIllIlIIllI.toString())).append(":").append(lllllllllllllllIIIlIIlIIlllllllI));
                        lllllllllllllllIIIlIlIIllIlIIIll = lllllllllllllllIIIlIlIIllIlIIIll.replaceAll(lllllllllllllllIIIlIlIIllIlIIIlI, "");
                    }
                    Realms.setScreen(new DisconnectedRealmsScreen(RealmsConnect.this.onlineScreen, "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[] { lllllllllllllllIIIlIlIIllIlIIIll })));
                }
            }
            
            static {
                __OBFID = "CL_00001808";
            }
        }.start();
    }
    
    public RealmsConnect(final RealmsScreen lllllllllllllllIIIlIIlIlIIIIIlII) {
        this.aborted = false;
        this.onlineScreen = lllllllllllllllIIIlIIlIlIIIIIlII;
    }
}
