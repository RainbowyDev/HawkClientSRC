package net.minecraft.client.gui;

import net.minecraft.client.network.*;
import java.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import java.io.*;
import net.minecraft.client.multiplayer.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import org.lwjgl.input.*;

public class GuiMultiplayer extends GuiScreen implements GuiYesNoCallback
{
    private /* synthetic */ ServerSelectionList serverListSelector;
    private /* synthetic */ GuiButton btnEditServer;
    private /* synthetic */ boolean initialized;
    private /* synthetic */ ServerList savedServerList;
    private /* synthetic */ LanServerDetector.ThreadLanServerFind lanServerDetector;
    private /* synthetic */ ServerData selectedServer;
    private /* synthetic */ boolean deletingServer;
    private /* synthetic */ boolean addingServer;
    private /* synthetic */ String field_146812_y;
    private /* synthetic */ boolean editingServer;
    private /* synthetic */ GuiButton btnDeleteServer;
    private /* synthetic */ GuiScreen parentScreen;
    private final /* synthetic */ OldServerPinger oldServerPinger;
    private /* synthetic */ boolean directConnect;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ LanServerDetector.LanServerList lanServerList;
    private /* synthetic */ GuiButton btnSelectServer;
    
    public void func_146793_a(final String llllllllllllllIIlllIIlIlllIIIIII) {
        this.field_146812_y = llllllllllllllIIlllIIlIlllIIIIII;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.lanServerList.getWasUpdated()) {
            final List llllllllllllllIIlllIIllIIIlIllIl = this.lanServerList.getLanServers();
            this.lanServerList.setWasNotUpdated();
            this.serverListSelector.func_148194_a(llllllllllllllIIlllIIllIIIlIllIl);
        }
        this.oldServerPinger.pingPendingNetworks();
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlllIIllIIIIlIIll) throws IOException {
        if (llllllllllllllIIlllIIllIIIIlIIll.enabled) {
            final GuiListExtended.IGuiListEntry llllllllllllllIIlllIIllIIIIlllII = (this.serverListSelector.func_148193_k() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.func_148193_k());
            if (llllllllllllllIIlllIIllIIIIlIIll.id == 2 && llllllllllllllIIlllIIllIIIIlllII instanceof ServerListEntryNormal) {
                final String llllllllllllllIIlllIIllIIIIllIll = ((ServerListEntryNormal)llllllllllllllIIlllIIllIIIIlllII).getServerData().serverName;
                if (llllllllllllllIIlllIIllIIIIllIll != null) {
                    this.deletingServer = true;
                    final String llllllllllllllIIlllIIllIIIIllIlI = I18n.format("selectServer.deleteQuestion", new Object[0]);
                    final String llllllllllllllIIlllIIllIIIIllIIl = String.valueOf(new StringBuilder("'").append(llllllllllllllIIlllIIllIIIIllIll).append("' ").append(I18n.format("selectServer.deleteWarning", new Object[0])));
                    final String llllllllllllllIIlllIIllIIIIllIII = I18n.format("selectServer.deleteButton", new Object[0]);
                    final String llllllllllllllIIlllIIllIIIIlIlll = I18n.format("gui.cancel", new Object[0]);
                    final GuiYesNo llllllllllllllIIlllIIllIIIIlIllI = new GuiYesNo(this, llllllllllllllIIlllIIllIIIIllIlI, llllllllllllllIIlllIIllIIIIllIIl, llllllllllllllIIlllIIllIIIIllIII, llllllllllllllIIlllIIllIIIIlIlll, this.serverListSelector.func_148193_k());
                    this.mc.displayGuiScreen(llllllllllllllIIlllIIllIIIIlIllI);
                }
            }
            else if (llllllllllllllIIlllIIllIIIIlIIll.id == 1) {
                this.connectToSelected();
            }
            else if (llllllllllllllIIlllIIllIIIIlIIll.id == 4) {
                this.directConnect = true;
                final Minecraft mc = this.mc;
                final ServerData serverData = new ServerData(I18n.format("selectServer.defaultName", new Object[0]), "");
                this.selectedServer = serverData;
                mc.displayGuiScreen(new GuiScreenServerList(this, serverData));
            }
            else if (llllllllllllllIIlllIIllIIIIlIIll.id == 3) {
                this.addingServer = true;
                final Minecraft mc2 = this.mc;
                final ServerData serverData2 = new ServerData(I18n.format("selectServer.defaultName", new Object[0]), "");
                this.selectedServer = serverData2;
                mc2.displayGuiScreen(new GuiScreenAddServer(this, serverData2));
            }
            else if (llllllllllllllIIlllIIllIIIIlIIll.id == 7 && llllllllllllllIIlllIIllIIIIlllII instanceof ServerListEntryNormal) {
                this.editingServer = true;
                final ServerData llllllllllllllIIlllIIllIIIIlIlIl = ((ServerListEntryNormal)llllllllllllllIIlllIIllIIIIlllII).getServerData();
                this.selectedServer = new ServerData(llllllllllllllIIlllIIllIIIIlIlIl.serverName, llllllllllllllIIlllIIllIIIIlIlIl.serverIP);
                this.selectedServer.copyFrom(llllllllllllllIIlllIIllIIIIlIlIl);
                this.mc.displayGuiScreen(new GuiScreenAddServer(this, this.selectedServer));
            }
            else if (llllllllllllllIIlllIIllIIIIlIIll.id == 0) {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (llllllllllllllIIlllIIllIIIIlIIll.id == 8) {
                this.refreshServerList();
            }
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIIlllIIlIlllllIIII, final int llllllllllllllIIlllIIlIlllllIlII) throws IOException {
        final int llllllllllllllIIlllIIlIlllllIIll = this.serverListSelector.func_148193_k();
        final GuiListExtended.IGuiListEntry llllllllllllllIIlllIIlIlllllIIlI = (llllllllllllllIIlllIIlIlllllIIll < 0) ? null : this.serverListSelector.getListEntry(llllllllllllllIIlllIIlIlllllIIll);
        if (llllllllllllllIIlllIIlIlllllIlII == 63) {
            this.refreshServerList();
        }
        else if (llllllllllllllIIlllIIlIlllllIIll >= 0) {
            if (llllllllllllllIIlllIIlIlllllIlII == 200) {
                if (isShiftKeyDown()) {
                    if (llllllllllllllIIlllIIlIlllllIIll > 0 && llllllllllllllIIlllIIlIlllllIIlI instanceof ServerListEntryNormal) {
                        this.savedServerList.swapServers(llllllllllllllIIlllIIlIlllllIIll, llllllllllllllIIlllIIlIlllllIIll - 1);
                        this.selectServer(this.serverListSelector.func_148193_k() - 1);
                        this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                        this.serverListSelector.func_148195_a(this.savedServerList);
                    }
                }
                else if (llllllllllllllIIlllIIlIlllllIIll > 0) {
                    this.selectServer(this.serverListSelector.func_148193_k() - 1);
                    this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                    if (this.serverListSelector.getListEntry(this.serverListSelector.func_148193_k()) instanceof ServerListEntryLanScan) {
                        if (this.serverListSelector.func_148193_k() > 0) {
                            this.selectServer(this.serverListSelector.getSize() - 1);
                            this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                        }
                        else {
                            this.selectServer(-1);
                        }
                    }
                }
                else {
                    this.selectServer(-1);
                }
            }
            else if (llllllllllllllIIlllIIlIlllllIlII == 208) {
                if (isShiftKeyDown()) {
                    if (llllllllllllllIIlllIIlIlllllIIll < this.savedServerList.countServers() - 1) {
                        this.savedServerList.swapServers(llllllllllllllIIlllIIlIlllllIIll, llllllllllllllIIlllIIlIlllllIIll + 1);
                        this.selectServer(llllllllllllllIIlllIIlIlllllIIll + 1);
                        this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                        this.serverListSelector.func_148195_a(this.savedServerList);
                    }
                }
                else if (llllllllllllllIIlllIIlIlllllIIll < this.serverListSelector.getSize()) {
                    this.selectServer(this.serverListSelector.func_148193_k() + 1);
                    this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                    if (this.serverListSelector.getListEntry(this.serverListSelector.func_148193_k()) instanceof ServerListEntryLanScan) {
                        if (this.serverListSelector.func_148193_k() < this.serverListSelector.getSize() - 1) {
                            this.selectServer(this.serverListSelector.getSize() + 1);
                            this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                        }
                        else {
                            this.selectServer(-1);
                        }
                    }
                }
                else {
                    this.selectServer(-1);
                }
            }
            else if (llllllllllllllIIlllIIlIlllllIlII != 28 && llllllllllllllIIlllIIlIlllllIlII != 156) {
                super.keyTyped(llllllllllllllIIlllIIlIlllllIIII, llllllllllllllIIlllIIlIlllllIlII);
            }
            else {
                this.actionPerformed(this.buttonList.get(2));
            }
        }
        else {
            super.keyTyped(llllllllllllllIIlllIIlIlllllIIII, llllllllllllllIIlllIIlIlllllIlII);
        }
    }
    
    private void connectToServer(final ServerData llllllllllllllIIlllIIlIlllIlIIlI) {
        this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, llllllllllllllIIlllIIlIlllIlIIlI));
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIIlllIIlIllIllIllI, final int llllllllllllllIIlllIIlIllIlllIIl, final int llllllllllllllIIlllIIlIllIllIlII) throws IOException {
        super.mouseClicked(llllllllllllllIIlllIIlIllIllIllI, llllllllllllllIIlllIIlIllIlllIIl, llllllllllllllIIlllIIlIllIllIlII);
        this.serverListSelector.func_148179_a(llllllllllllllIIlllIIlIllIllIllI, llllllllllllllIIlllIIlIllIlllIIl, llllllllllllllIIlllIIlIllIllIlII);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIlllIIlIllllIIlll, final int llllllllllllllIIlllIIlIllllIIllI, final float llllllllllllllIIlllIIlIllllIIlIl) {
        this.field_146812_y = null;
        this.drawDefaultBackground();
        this.serverListSelector.drawScreen(llllllllllllllIIlllIIlIllllIIlll, llllllllllllllIIlllIIlIllllIIllI, llllllllllllllIIlllIIlIllllIIlIl);
        this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.title", new Object[0]), this.width / 2, 20, 16777215);
        super.drawScreen(llllllllllllllIIlllIIlIllllIIlll, llllllllllllllIIlllIIlIllllIIllI, llllllllllllllIIlllIIlIllllIIlIl);
        if (this.field_146812_y != null) {
            this.drawHoveringText(Lists.newArrayList(Splitter.on("\n").split((CharSequence)this.field_146812_y)), llllllllllllllIIlllIIlIllllIIlll, llllllllllllllIIlllIIlIllllIIllI);
        }
    }
    
    @Override
    protected void mouseReleased(final int llllllllllllllIIlllIIlIllIlIlllI, final int llllllllllllllIIlllIIlIllIlIllIl, final int llllllllllllllIIlllIIlIllIlIllII) {
        super.mouseReleased(llllllllllllllIIlllIIlIllIlIlllI, llllllllllllllIIlllIIlIllIlIllIl, llllllllllllllIIlllIIlIllIlIllII);
        this.serverListSelector.func_148181_b(llllllllllllllIIlllIIlIllIlIlllI, llllllllllllllIIlllIIlIllIlIllIl, llllllllllllllIIlllIIlIllIlIllII);
    }
    
    public ServerList getServerList() {
        return this.savedServerList;
    }
    
    static {
        __OBFID = "CL_00000814";
        logger = LogManager.getLogger();
    }
    
    public void connectToSelected() {
        final GuiListExtended.IGuiListEntry llllllllllllllIIlllIIlIlllIlllII = (this.serverListSelector.func_148193_k() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.func_148193_k());
        if (llllllllllllllIIlllIIlIlllIlllII instanceof ServerListEntryNormal) {
            this.connectToServer(((ServerListEntryNormal)llllllllllllllIIlllIIlIlllIlllII).getServerData());
        }
        else if (llllllllllllllIIlllIIlIlllIlllII instanceof ServerListEntryLanDetected) {
            final LanServerDetector.LanServer llllllllllllllIIlllIIlIlllIllIll = ((ServerListEntryLanDetected)llllllllllllllIIlllIIlIlllIlllII).getLanServer();
            this.connectToServer(new ServerData(llllllllllllllIIlllIIlIlllIllIll.getServerMotd(), llllllllllllllIIlllIIlIlllIllIll.getServerIpPort()));
        }
    }
    
    public GuiMultiplayer(final GuiScreen llllllllllllllIIlllIIllIIIllllIl) {
        this.oldServerPinger = new OldServerPinger();
        this.parentScreen = llllllllllllllIIlllIIllIIIllllIl;
    }
    
    public void func_175391_a(final ServerListEntryNormal llllllllllllllIIlllIIlIllIIlIIll, final int llllllllllllllIIlllIIlIllIIlIIlI, final boolean llllllllllllllIIlllIIlIllIIIllIl) {
        final int llllllllllllllIIlllIIlIllIIlIIII = llllllllllllllIIlllIIlIllIIIllIl ? 0 : (llllllllllllllIIlllIIlIllIIlIIlI - 1);
        this.savedServerList.swapServers(llllllllllllllIIlllIIlIllIIlIIlI, llllllllllllllIIlllIIlIllIIlIIII);
        if (this.serverListSelector.func_148193_k() == llllllllllllllIIlllIIlIllIIlIIlI) {
            this.selectServer(llllllllllllllIIlllIIlIllIIlIIII);
        }
        this.serverListSelector.func_148195_a(this.savedServerList);
    }
    
    public void createButtons() {
        final List buttonList = this.buttonList;
        final GuiButton btnEditServer = new GuiButton(7, this.width / 2 - 154, this.height - 28, 70, 20, I18n.format("selectServer.edit", new Object[0]));
        this.btnEditServer = btnEditServer;
        buttonList.add(btnEditServer);
        final List buttonList2 = this.buttonList;
        final GuiButton btnDeleteServer = new GuiButton(2, this.width / 2 - 74, this.height - 28, 70, 20, I18n.format("selectServer.delete", new Object[0]));
        this.btnDeleteServer = btnDeleteServer;
        buttonList2.add(btnDeleteServer);
        final List buttonList3 = this.buttonList;
        final GuiButton btnSelectServer = new GuiButton(1, this.width / 2 - 154, this.height - 52, 100, 20, I18n.format("selectServer.select", new Object[0]));
        this.btnSelectServer = btnSelectServer;
        buttonList3.add(btnSelectServer);
        this.buttonList.add(new GuiButton(4, this.width / 2 - 50, this.height - 52, 100, 20, I18n.format("selectServer.direct", new Object[0])));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 4 + 50, this.height - 52, 100, 20, I18n.format("selectServer.add", new Object[0])));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 4, this.height - 28, 70, 20, I18n.format("selectServer.refresh", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4 + 76, this.height - 28, 75, 20, I18n.format("gui.cancel", new Object[0])));
        this.selectServer(this.serverListSelector.func_148193_k());
    }
    
    public OldServerPinger getOldServerPinger() {
        return this.oldServerPinger;
    }
    
    public boolean func_175394_b(final ServerListEntryNormal llllllllllllllIIlllIIlIllIIlllII, final int llllllllllllllIIlllIIlIllIIllIll) {
        return llllllllllllllIIlllIIlIllIIllIll < this.savedServerList.countServers() - 1;
    }
    
    private void refreshServerList() {
        this.mc.displayGuiScreen(new GuiMultiplayer(this.parentScreen));
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        if (!this.initialized) {
            this.initialized = true;
            this.savedServerList = new ServerList(this.mc);
            this.savedServerList.loadServerList();
            this.lanServerList = new LanServerDetector.LanServerList();
            try {
                this.lanServerDetector = new LanServerDetector.ThreadLanServerFind(this.lanServerList);
                this.lanServerDetector.start();
            }
            catch (Exception llllllllllllllIIlllIIllIIIlllIIl) {
                GuiMultiplayer.logger.warn(String.valueOf(new StringBuilder("Unable to start LAN server detection: ").append(llllllllllllllIIlllIIllIIIlllIIl.getMessage())));
            }
            this.serverListSelector = new ServerSelectionList(this, this.mc, this.width, this.height, 32, this.height - 64, 36);
            this.serverListSelector.func_148195_a(this.savedServerList);
        }
        else {
            this.serverListSelector.setDimensions(this.width, this.height, 32, this.height - 64);
        }
        this.createButtons();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.serverListSelector.func_178039_p();
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        if (this.lanServerDetector != null) {
            this.lanServerDetector.interrupt();
            this.lanServerDetector = null;
        }
        this.oldServerPinger.clearPendingNetworks();
    }
    
    public void func_175393_b(final ServerListEntryNormal llllllllllllllIIlllIIlIllIIIIllI, final int llllllllllllllIIlllIIlIllIIIIIIl, final boolean llllllllllllllIIlllIIlIllIIIIIII) {
        final int llllllllllllllIIlllIIlIllIIIIIll = llllllllllllllIIlllIIlIllIIIIIII ? (this.savedServerList.countServers() - 1) : (llllllllllllllIIlllIIlIllIIIIIIl + 1);
        this.savedServerList.swapServers(llllllllllllllIIlllIIlIllIIIIIIl, llllllllllllllIIlllIIlIllIIIIIll);
        if (this.serverListSelector.func_148193_k() == llllllllllllllIIlllIIlIllIIIIIIl) {
            this.selectServer(llllllllllllllIIlllIIlIllIIIIIll);
        }
        this.serverListSelector.func_148195_a(this.savedServerList);
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllIIlllIIlIllllllllI, final int llllllllllllllIIlllIIllIIIIIIIlI) {
        final GuiListExtended.IGuiListEntry llllllllllllllIIlllIIllIIIIIIIIl = (this.serverListSelector.func_148193_k() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.func_148193_k());
        if (this.deletingServer) {
            this.deletingServer = false;
            if (llllllllllllllIIlllIIlIllllllllI && llllllllllllllIIlllIIllIIIIIIIIl instanceof ServerListEntryNormal) {
                this.savedServerList.removeServerData(this.serverListSelector.func_148193_k());
                this.savedServerList.saveServerList();
                this.serverListSelector.func_148192_c(-1);
                this.serverListSelector.func_148195_a(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
        else if (this.directConnect) {
            this.directConnect = false;
            if (llllllllllllllIIlllIIlIllllllllI) {
                this.connectToServer(this.selectedServer);
            }
            else {
                this.mc.displayGuiScreen(this);
            }
        }
        else if (this.addingServer) {
            this.addingServer = false;
            if (llllllllllllllIIlllIIlIllllllllI) {
                this.savedServerList.addServerData(this.selectedServer);
                this.savedServerList.saveServerList();
                this.serverListSelector.func_148192_c(-1);
                this.serverListSelector.func_148195_a(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
        else if (this.editingServer) {
            this.editingServer = false;
            if (llllllllllllllIIlllIIlIllllllllI && llllllllllllllIIlllIIllIIIIIIIIl instanceof ServerListEntryNormal) {
                final ServerData llllllllllllllIIlllIIllIIIIIIIII = ((ServerListEntryNormal)llllllllllllllIIlllIIllIIIIIIIIl).getServerData();
                llllllllllllllIIlllIIllIIIIIIIII.serverName = this.selectedServer.serverName;
                llllllllllllllIIlllIIllIIIIIIIII.serverIP = this.selectedServer.serverIP;
                llllllllllllllIIlllIIllIIIIIIIII.copyFrom(this.selectedServer);
                this.savedServerList.saveServerList();
                this.serverListSelector.func_148195_a(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
    }
    
    public void selectServer(final int llllllllllllllIIlllIIlIlllIIllIl) {
        this.serverListSelector.func_148192_c(llllllllllllllIIlllIIlIlllIIllIl);
        final GuiListExtended.IGuiListEntry llllllllllllllIIlllIIlIlllIIllII = (llllllllllllllIIlllIIlIlllIIllIl < 0) ? null : this.serverListSelector.getListEntry(llllllllllllllIIlllIIlIlllIIllIl);
        this.btnSelectServer.enabled = false;
        this.btnEditServer.enabled = false;
        this.btnDeleteServer.enabled = false;
        if (llllllllllllllIIlllIIlIlllIIllII != null && !(llllllllllllllIIlllIIlIlllIIllII instanceof ServerListEntryLanScan)) {
            this.btnSelectServer.enabled = true;
            if (llllllllllllllIIlllIIlIlllIIllII instanceof ServerListEntryNormal) {
                this.btnEditServer.enabled = true;
                this.btnDeleteServer.enabled = true;
            }
        }
    }
    
    public boolean func_175392_a(final ServerListEntryNormal llllllllllllllIIlllIIlIllIlIIIlI, final int llllllllllllllIIlllIIlIllIlIIIIl) {
        return llllllllllllllIIlllIIlIllIlIIIIl > 0;
    }
}
