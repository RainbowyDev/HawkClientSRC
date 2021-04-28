package net.minecraft.client.multiplayer;

import java.util.concurrent.atomic.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.network.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.*;
import net.minecraft.network.login.client.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import java.net.*;

public class GuiConnecting extends GuiScreen
{
    private /* synthetic */ NetworkManager networkManager;
    private final /* synthetic */ GuiScreen previousGuiScreen;
    private static final /* synthetic */ AtomicInteger CONNECTION_ID;
    private /* synthetic */ boolean cancel;
    private static final /* synthetic */ Logger logger;
    
    @Override
    protected void keyTyped(final char lllllllllllllllllIlIIlIlIllIllIl, final int lllllllllllllllllIlIIlIlIllIllII) throws IOException {
    }
    
    static /* synthetic */ void access$1(final GuiConnecting lllllllllllllllllIlIIlIlIlIlIIlI, final NetworkManager lllllllllllllllllIlIIlIlIlIlIIIl) {
        lllllllllllllllllIlIIlIlIlIlIIlI.networkManager = lllllllllllllllllIlIIlIlIlIlIIIl;
    }
    
    @Override
    public void updateScreen() {
        if (this.networkManager != null) {
            if (this.networkManager.isChannelOpen()) {
                this.networkManager.processReceivedPackets();
            }
            else {
                this.networkManager.checkDisconnected();
            }
        }
    }
    
    public GuiConnecting(final GuiScreen lllllllllllllllllIlIIlIllIIlIIlI, final Minecraft lllllllllllllllllIlIIlIllIIIllII, final ServerData lllllllllllllllllIlIIlIllIIIlIll) {
        this.mc = lllllllllllllllllIlIIlIllIIIllII;
        this.previousGuiScreen = lllllllllllllllllIlIIlIllIIlIIlI;
        final ServerAddress lllllllllllllllllIlIIlIllIIIllll = ServerAddress.func_78860_a(lllllllllllllllllIlIIlIllIIIlIll.serverIP);
        lllllllllllllllllIlIIlIllIIIllII.loadWorld(null);
        lllllllllllllllllIlIIlIllIIIllII.setServerData(lllllllllllllllllIlIIlIllIIIlIll);
        this.connect(lllllllllllllllllIlIIlIllIIIllll.getIP(), lllllllllllllllllIlIIlIllIIIllll.getPort());
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllllIlIIlIlIllIIlIl) throws IOException {
        if (lllllllllllllllllIlIIlIlIllIIlIl.id == 0) {
            this.cancel = true;
            if (this.networkManager != null) {
                this.networkManager.closeChannel(new ChatComponentText("Aborted"));
            }
            this.mc.displayGuiScreen(this.previousGuiScreen);
        }
    }
    
    public GuiConnecting(final GuiScreen lllllllllllllllllIlIIlIlIllllllI, final Minecraft lllllllllllllllllIlIIlIllIIIIIlI, final String lllllllllllllllllIlIIlIllIIIIIIl, final int lllllllllllllllllIlIIlIlIllllIll) {
        this.mc = lllllllllllllllllIlIIlIllIIIIIlI;
        this.previousGuiScreen = lllllllllllllllllIlIIlIlIllllllI;
        lllllllllllllllllIlIIlIllIIIIIlI.loadWorld(null);
        this.connect(lllllllllllllllllIlIIlIllIIIIIIl, lllllllllllllllllIlIIlIlIllllIll);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
    }
    
    static {
        __OBFID = "CL_00000685";
        CONNECTION_ID = new AtomicInteger(0);
        logger = LogManager.getLogger();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllIlIIlIlIlIlllIl, final int lllllllllllllllllIlIIlIlIlIllIII, final float lllllllllllllllllIlIIlIlIlIllIll) {
        this.drawDefaultBackground();
        if (this.networkManager == null) {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.connecting", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        }
        else {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.authorizing", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        }
        super.drawScreen(lllllllllllllllllIlIIlIlIlIlllIl, lllllllllllllllllIlIIlIlIlIllIII, lllllllllllllllllIlIIlIlIlIllIll);
    }
    
    private void connect(final String lllllllllllllllllIlIIlIlIlllIIll, final int lllllllllllllllllIlIIlIlIlllIIlI) {
        GuiConnecting.logger.info(String.valueOf(new StringBuilder("Connecting to ").append(lllllllllllllllllIlIIlIlIlllIIll).append(", ").append(lllllllllllllllllIlIIlIlIlllIIlI)));
        new Thread(String.valueOf(new StringBuilder("Server Connector #").append(GuiConnecting.CONNECTION_ID.incrementAndGet()))) {
            static {
                __OBFID = "CL_00000686";
            }
            
            @Override
            public void run() {
                InetAddress lllllllllllllllllllIllIlIIlllIlI = null;
                try {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    lllllllllllllllllllIllIlIIlllIlI = InetAddress.getByName(lllllllllllllllllIlIIlIlIlllIIll);
                    GuiConnecting.access$1(GuiConnecting.this, NetworkManager.provideLanClient(lllllllllllllllllllIllIlIIlllIlI, lllllllllllllllllIlIIlIlIlllIIlI));
                    GuiConnecting.this.networkManager.setNetHandler(new NetHandlerLoginClient(GuiConnecting.this.networkManager, GuiConnecting.this.mc, GuiConnecting.this.previousGuiScreen));
                    GuiConnecting.this.networkManager.sendPacket(new C00Handshake(47, lllllllllllllllllIlIIlIlIlllIIll, lllllllllllllllllIlIIlIlIlllIIlI, EnumConnectionState.LOGIN));
                    GuiConnecting.this.networkManager.sendPacket(new C00PacketLoginStart(GuiConnecting.this.mc.getSession().getProfile()));
                }
                catch (UnknownHostException lllllllllllllllllllIllIlIIlllIIl) {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    GuiConnecting.logger.error("Couldn't connect to server", (Throwable)lllllllllllllllllllIllIlIIlllIIl);
                    GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[] { "Unknown host" })));
                }
                catch (Exception lllllllllllllllllllIllIlIIlllIII) {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    GuiConnecting.logger.error("Couldn't connect to server", (Throwable)lllllllllllllllllllIllIlIIlllIII);
                    String lllllllllllllllllllIllIlIIllIlll = lllllllllllllllllllIllIlIIlllIII.toString();
                    if (lllllllllllllllllllIllIlIIlllIlI != null) {
                        final String lllllllllllllllllllIllIlIIllIllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllllIllIlIIlllIlI.toString())).append(":").append(lllllllllllllllllIlIIlIlIlllIIlI));
                        lllllllllllllllllllIllIlIIllIlll = lllllllllllllllllllIllIlIIllIlll.replaceAll(lllllllllllllllllllIllIlIIllIllI, "");
                    }
                    GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[] { lllllllllllllllllllIllIlIIllIlll })));
                }
            }
        }.start();
    }
}
