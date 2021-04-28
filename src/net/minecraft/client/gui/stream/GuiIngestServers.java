package net.minecraft.client.gui.stream;

import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import tv.twitch.broadcast.*;
import net.minecraft.client.stream.*;
import net.minecraft.client.*;

public class GuiIngestServers extends GuiScreen
{
    private final /* synthetic */ GuiScreen field_152309_a;
    private /* synthetic */ String field_152310_f;
    private /* synthetic */ ServerList field_152311_g;
    
    public GuiIngestServers(final GuiScreen lllllllllllllllIlllllIlllllllIll) {
        this.field_152309_a = lllllllllllllllIlllllIlllllllIll;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIlllllIlllllIllII) throws IOException {
        if (lllllllllllllllIlllllIlllllIllII.enabled) {
            if (lllllllllllllllIlllllIlllllIllII.id == 1) {
                this.mc.displayGuiScreen(this.field_152309_a);
            }
            else {
                this.mc.gameSettings.streamPreferredServer = "";
                this.mc.gameSettings.saveOptions();
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        if (this.mc.getTwitchStream().func_152908_z()) {
            this.mc.getTwitchStream().func_152932_y().func_153039_l();
        }
    }
    
    @Override
    public void initGui() {
        this.field_152310_f = I18n.format("options.stream.ingest.title", new Object[0]);
        this.field_152311_g = new ServerList(this.mc);
        if (!this.mc.getTwitchStream().func_152908_z()) {
            this.mc.getTwitchStream().func_152909_x();
        }
        this.buttonList.add(new GuiButton(1, this.width / 2 - 155, this.height - 24 - 6, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 5, this.height - 24 - 6, 150, 20, I18n.format("options.stream.ingest.reset", new Object[0])));
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_152311_g.func_178039_p();
    }
    
    static {
        __OBFID = "CL_00001843";
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIlllllIlllllIIIII, final int lllllllllllllllIlllllIllllIlllll, final float lllllllllllllllIlllllIlllllIIIlI) {
        this.drawDefaultBackground();
        this.field_152311_g.drawScreen(lllllllllllllllIlllllIlllllIIIII, lllllllllllllllIlllllIllllIlllll, lllllllllllllllIlllllIlllllIIIlI);
        this.drawCenteredString(this.fontRendererObj, this.field_152310_f, this.width / 2, 20, 16777215);
        super.drawScreen(lllllllllllllllIlllllIlllllIIIII, lllllllllllllllIlllllIllllIlllll, lllllllllllllllIlllllIlllllIIIlI);
    }
    
    class ServerList extends GuiSlot
    {
        @Override
        protected void drawSlot(final int llllllllllllllIlllllIlIIIlIIlIIl, int llllllllllllllIlllllIlIIIlIIlIII, final int llllllllllllllIlllllIlIIIlIlIIll, final int llllllllllllllIlllllIlIIIlIlIIlI, final int llllllllllllllIlllllIlIIIlIlIIIl, final int llllllllllllllIlllllIlIIIlIlIIII) {
            final IngestServer llllllllllllllIlllllIlIIIlIIllll = this.mc.getTwitchStream().func_152925_v()[llllllllllllllIlllllIlIIIlIIlIIl];
            String llllllllllllllIlllllIlIIIlIIlllI = llllllllllllllIlllllIlIIIlIIllll.serverUrl.replaceAll("\\{stream_key\\}", "");
            String llllllllllllllIlllllIlIIIlIIllIl = String.valueOf(new StringBuilder(String.valueOf((int)llllllllllllllIlllllIlIIIlIIllll.bitrateKbps)).append(" kbps"));
            String llllllllllllllIlllllIlIIIlIIllII = null;
            final IngestServerTester llllllllllllllIlllllIlIIIlIIlIll = this.mc.getTwitchStream().func_152932_y();
            if (llllllllllllllIlllllIlIIIlIIlIll != null) {
                if (llllllllllllllIlllllIlIIIlIIllll == llllllllllllllIlllllIlIIIlIIlIll.func_153040_c()) {
                    llllllllllllllIlllllIlIIIlIIlllI = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append(llllllllllllllIlllllIlIIIlIIlllI));
                    llllllllllllllIlllllIlIIIlIIllIl = String.valueOf(new StringBuilder(String.valueOf((int)(llllllllllllllIlllllIlIIIlIIlIll.func_153030_h() * 100.0f))).append("%"));
                }
                else if (llllllllllllllIlllllIlIIIlIIlIIl < llllllllllllllIlllllIlIIIlIIlIll.func_153028_p()) {
                    if (llllllllllllllIlllllIlIIIlIIllll.bitrateKbps == 0.0f) {
                        llllllllllllllIlllllIlIIIlIIllIl = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Down!"));
                    }
                }
                else {
                    llllllllllllllIlllllIlIIIlIIllIl = String.valueOf(new StringBuilder().append(EnumChatFormatting.OBFUSCATED).append("1234").append(EnumChatFormatting.RESET).append(" kbps"));
                }
            }
            else if (llllllllllllllIlllllIlIIIlIIllll.bitrateKbps == 0.0f) {
                llllllllllllllIlllllIlIIIlIIllIl = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Down!"));
            }
            llllllllllllllIlllllIlIIIlIIlIII -= 15;
            if (this.isSelected(llllllllllllllIlllllIlIIIlIIlIIl)) {
                llllllllllllllIlllllIlIIIlIIllII = String.valueOf(new StringBuilder().append(EnumChatFormatting.BLUE).append("(Preferred)"));
            }
            else if (llllllllllllllIlllllIlIIIlIIllll.defaultServer) {
                llllllllllllllIlllllIlIIIlIIllII = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append("(Default)"));
            }
            GuiIngestServers.this.drawString(GuiIngestServers.this.fontRendererObj, llllllllllllllIlllllIlIIIlIIllll.serverName, llllllllllllllIlllllIlIIIlIIlIII + 2, llllllllllllllIlllllIlIIIlIlIIll + 5, 16777215);
            GuiIngestServers.this.drawString(GuiIngestServers.this.fontRendererObj, llllllllllllllIlllllIlIIIlIIlllI, llllllllllllllIlllllIlIIIlIIlIII + 2, llllllllllllllIlllllIlIIIlIlIIll + GuiIngestServers.this.fontRendererObj.FONT_HEIGHT + 5 + 3, 3158064);
            GuiIngestServers.this.drawString(GuiIngestServers.this.fontRendererObj, llllllllllllllIlllllIlIIIlIIllIl, this.getScrollBarX() - 5 - GuiIngestServers.this.fontRendererObj.getStringWidth(llllllllllllllIlllllIlIIIlIIllIl), llllllllllllllIlllllIlIIIlIlIIll + 5, 8421504);
            if (llllllllllllllIlllllIlIIIlIIllII != null) {
                GuiIngestServers.this.drawString(GuiIngestServers.this.fontRendererObj, llllllllllllllIlllllIlIIIlIIllII, this.getScrollBarX() - 5 - GuiIngestServers.this.fontRendererObj.getStringWidth(llllllllllllllIlllllIlIIIlIIllII), llllllllllllllIlllllIlIIIlIlIIll + 5 + 3 + GuiIngestServers.this.fontRendererObj.FONT_HEIGHT, 8421504);
            }
        }
        
        @Override
        protected int getScrollBarX() {
            return super.getScrollBarX() + 15;
        }
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected boolean isSelected(final int llllllllllllllIlllllIlIIIllIIIIl) {
            return this.mc.getTwitchStream().func_152925_v()[llllllllllllllIlllllIlIIIllIIIIl].serverUrl.equals(this.mc.gameSettings.streamPreferredServer);
        }
        
        public ServerList(final Minecraft llllllllllllllIlllllIlIIIlllIIll) {
            super(llllllllllllllIlllllIlIIIlllIIll, GuiIngestServers.this.width, GuiIngestServers.this.height, 32, GuiIngestServers.this.height - 35, (int)(llllllllllllllIlllllIlIIIlllIIll.fontRendererObj.FONT_HEIGHT * 3.5));
            this.setShowSelectionBox(false);
        }
        
        static {
            __OBFID = "CL_00001842";
        }
        
        @Override
        protected int getSize() {
            return this.mc.getTwitchStream().func_152925_v().length;
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllIlllllIlIIIllIIlll, final boolean llllllllllllllIlllllIlIIIllIlIll, final int llllllllllllllIlllllIlIIIllIlIlI, final int llllllllllllllIlllllIlIIIllIlIIl) {
            this.mc.gameSettings.streamPreferredServer = this.mc.getTwitchStream().func_152925_v()[llllllllllllllIlllllIlIIIllIIlll].serverUrl;
            this.mc.gameSettings.saveOptions();
        }
    }
}
