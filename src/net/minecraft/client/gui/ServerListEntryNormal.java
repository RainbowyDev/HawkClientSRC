package net.minecraft.client.gui;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import java.net.*;
import java.util.*;
import org.apache.logging.log4j.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;

public class ServerListEntryNormal implements GuiListExtended.IGuiListEntry
{
    private static final /* synthetic */ ResourceLocation field_178014_d;
    private static final /* synthetic */ ThreadPoolExecutor field_148302_b;
    private final /* synthetic */ GuiMultiplayer field_148303_c;
    private final /* synthetic */ ResourceLocation field_148306_i;
    private /* synthetic */ DynamicTexture field_148305_h;
    private static final /* synthetic */ ResourceLocation field_178015_c;
    private /* synthetic */ String field_148299_g;
    private /* synthetic */ long field_148298_f;
    private final /* synthetic */ Minecraft field_148300_d;
    private final /* synthetic */ ServerData field_148301_e;
    
    protected void func_178012_a(final int llllllllllllllllIIIIIllIlIlllIll, final int llllllllllllllllIIIIIllIlIlllIlI, final ResourceLocation llllllllllllllllIIIIIllIlIlllIIl) {
        this.field_148300_d.getTextureManager().bindTexture(llllllllllllllllIIIIIllIlIlllIIl);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllllIIIIIllIlIlllIll, llllllllllllllllIIIIIllIlIlllIlI, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
        GlStateManager.disableBlend();
    }
    
    @Override
    public void mouseReleased(final int llllllllllllllllIIIIIllIlIIIllIl, final int llllllllllllllllIIIIIllIlIIIllII, final int llllllllllllllllIIIIIllIlIIIlIll, final int llllllllllllllllIIIIIllIlIIIlIlI, final int llllllllllllllllIIIIIllIlIIIlIIl, final int llllllllllllllllIIIIIllIlIIIlIII) {
    }
    
    @Override
    public boolean mousePressed(final int llllllllllllllllIIIIIllIlIIlIlIl, final int llllllllllllllllIIIIIllIlIIllIll, final int llllllllllllllllIIIIIllIlIIllIlI, final int llllllllllllllllIIIIIllIlIIllIIl, final int llllllllllllllllIIIIIllIlIIllIII, final int llllllllllllllllIIIIIllIlIIlIlll) {
        if (llllllllllllllllIIIIIllIlIIllIII <= 32) {
            if (llllllllllllllllIIIIIllIlIIllIII < 32 && llllllllllllllllIIIIIllIlIIllIII > 16 && this.func_178013_b()) {
                this.field_148303_c.selectServer(llllllllllllllllIIIIIllIlIIlIlIl);
                this.field_148303_c.connectToSelected();
                return true;
            }
            if (llllllllllllllllIIIIIllIlIIllIII < 16 && llllllllllllllllIIIIIllIlIIlIlll < 16 && this.field_148303_c.func_175392_a(this, llllllllllllllllIIIIIllIlIIlIlIl)) {
                this.field_148303_c.func_175391_a(this, llllllllllllllllIIIIIllIlIIlIlIl, GuiScreen.isShiftKeyDown());
                return true;
            }
            if (llllllllllllllllIIIIIllIlIIllIII < 16 && llllllllllllllllIIIIIllIlIIlIlll > 16 && this.field_148303_c.func_175394_b(this, llllllllllllllllIIIIIllIlIIlIlIl)) {
                this.field_148303_c.func_175393_b(this, llllllllllllllllIIIIIllIlIIlIlIl, GuiScreen.isShiftKeyDown());
                return true;
            }
        }
        this.field_148303_c.selectServer(llllllllllllllllIIIIIllIlIIlIlIl);
        if (Minecraft.getSystemTime() - this.field_148298_f < 250L) {
            this.field_148303_c.connectToSelected();
        }
        this.field_148298_f = Minecraft.getSystemTime();
        return false;
    }
    
    @Override
    public void drawEntry(final int llllllllllllllllIIIIIllIllllIlll, final int llllllllllllllllIIIIIllIllllIllI, final int llllllllllllllllIIIIIllIllllIlIl, final int llllllllllllllllIIIIIllIllIlIIlI, final int llllllllllllllllIIIIIllIllllIIll, final int llllllllllllllllIIIIIllIllIlIIIl, final int llllllllllllllllIIIIIllIllIlIIII, final boolean llllllllllllllllIIIIIllIllIIllll) {
        if (!this.field_148301_e.field_78841_f) {
            this.field_148301_e.field_78841_f = true;
            this.field_148301_e.pingToServer = -2L;
            this.field_148301_e.serverMOTD = "";
            this.field_148301_e.populationInfo = "";
            ServerListEntryNormal.field_148302_b.submit(new Runnable() {
                static {
                    __OBFID = "CL_00000818";
                }
                
                @Override
                public void run() {
                    try {
                        ServerListEntryNormal.this.field_148303_c.getOldServerPinger().ping(ServerListEntryNormal.this.field_148301_e);
                    }
                    catch (UnknownHostException llllllllllllllIlIIIIIIIIIlIIIIll) {
                        ServerListEntryNormal.this.field_148301_e.pingToServer = -1L;
                        ServerListEntryNormal.this.field_148301_e.serverMOTD = String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_RED).append("Can't resolve hostname"));
                    }
                    catch (Exception llllllllllllllIlIIIIIIIIIlIIIIlI) {
                        ServerListEntryNormal.this.field_148301_e.pingToServer = -1L;
                        ServerListEntryNormal.this.field_148301_e.serverMOTD = String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_RED).append("Can't connect to server."));
                    }
                }
            });
        }
        final boolean llllllllllllllllIIIIIllIlllIllll = this.field_148301_e.version > 47;
        final boolean llllllllllllllllIIIIIllIlllIlllI = this.field_148301_e.version < 47;
        final boolean llllllllllllllllIIIIIllIlllIllIl = llllllllllllllllIIIIIllIlllIllll || llllllllllllllllIIIIIllIlllIlllI;
        this.field_148300_d.fontRendererObj.drawString(this.field_148301_e.serverName, llllllllllllllllIIIIIllIllllIllI + 32 + 3, llllllllllllllllIIIIIllIllllIlIl + 1, 16777215);
        final List llllllllllllllllIIIIIllIlllIllII = this.field_148300_d.fontRendererObj.listFormattedStringToWidth(this.field_148301_e.serverMOTD, llllllllllllllllIIIIIllIllIlIIlI - 32 - 2);
        for (int llllllllllllllllIIIIIllIlllIlIll = 0; llllllllllllllllIIIIIllIlllIlIll < Math.min(llllllllllllllllIIIIIllIlllIllII.size(), 2); ++llllllllllllllllIIIIIllIlllIlIll) {
            this.field_148300_d.fontRendererObj.drawString(llllllllllllllllIIIIIllIlllIllII.get(llllllllllllllllIIIIIllIlllIlIll), llllllllllllllllIIIIIllIllllIllI + 32 + 3, llllllllllllllllIIIIIllIllllIlIl + 12 + this.field_148300_d.fontRendererObj.FONT_HEIGHT * llllllllllllllllIIIIIllIlllIlIll, 8421504);
        }
        final String llllllllllllllllIIIIIllIlllIlIlI = llllllllllllllllIIIIIllIlllIllIl ? String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_RED).append(this.field_148301_e.gameVersion)) : this.field_148301_e.populationInfo;
        final int llllllllllllllllIIIIIllIlllIlIIl = this.field_148300_d.fontRendererObj.getStringWidth(llllllllllllllllIIIIIllIlllIlIlI);
        this.field_148300_d.fontRendererObj.drawString(llllllllllllllllIIIIIllIlllIlIlI, llllllllllllllllIIIIIllIllllIllI + llllllllllllllllIIIIIllIllIlIIlI - llllllllllllllllIIIIIllIlllIlIIl - 15 - 2, llllllllllllllllIIIIIllIllllIlIl + 1, 8421504);
        byte llllllllllllllllIIIIIllIlllIlIII = 0;
        String llllllllllllllllIIIIIllIlllIIlll = null;
        int llllllllllllllllIIIIIllIllIlllll = 0;
        String llllllllllllllllIIIIIllIllIllIll = null;
        if (llllllllllllllllIIIIIllIlllIllIl) {
            final int llllllllllllllllIIIIIllIlllIIllI = 5;
            final String llllllllllllllllIIIIIllIllIllllI = llllllllllllllllIIIIIllIlllIllll ? "Client out of date!" : "Server out of date!";
            llllllllllllllllIIIIIllIlllIIlll = this.field_148301_e.playerList;
        }
        else if (this.field_148301_e.field_78841_f && this.field_148301_e.pingToServer != -2L) {
            if (this.field_148301_e.pingToServer < 0L) {
                final int llllllllllllllllIIIIIllIlllIIlIl = 5;
            }
            else if (this.field_148301_e.pingToServer < 150L) {
                final int llllllllllllllllIIIIIllIlllIIlII = 0;
            }
            else if (this.field_148301_e.pingToServer < 300L) {
                final int llllllllllllllllIIIIIllIlllIIIll = 1;
            }
            else if (this.field_148301_e.pingToServer < 600L) {
                final int llllllllllllllllIIIIIllIlllIIIlI = 2;
            }
            else if (this.field_148301_e.pingToServer < 1000L) {
                final int llllllllllllllllIIIIIllIlllIIIIl = 3;
            }
            else {
                final int llllllllllllllllIIIIIllIlllIIIII = 4;
            }
            if (this.field_148301_e.pingToServer < 0L) {
                final String llllllllllllllllIIIIIllIllIlllIl = "(no connection)";
            }
            else {
                final String llllllllllllllllIIIIIllIllIlllII = String.valueOf(new StringBuilder(String.valueOf(this.field_148301_e.pingToServer)).append("ms"));
                llllllllllllllllIIIIIllIlllIIlll = this.field_148301_e.playerList;
            }
        }
        else {
            llllllllllllllllIIIIIllIlllIlIII = 1;
            llllllllllllllllIIIIIllIllIlllll = (int)(Minecraft.getSystemTime() / 100L + llllllllllllllllIIIIIllIllllIlll * 2 & 0x7L);
            if (llllllllllllllllIIIIIllIllIlllll > 4) {
                llllllllllllllllIIIIIllIllIlllll = 8 - llllllllllllllllIIIIIllIllIlllll;
            }
            llllllllllllllllIIIIIllIllIllIll = "Pinging...";
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_148300_d.getTextureManager().bindTexture(Gui.icons);
        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllllIIIIIllIllllIllI + llllllllllllllllIIIIIllIllIlIIlI - 15, llllllllllllllllIIIIIllIllllIlIl, (float)(llllllllllllllllIIIIIllIlllIlIII * 10), (float)(176 + llllllllllllllllIIIIIllIllIlllll * 8), 10, 8, 256.0f, 256.0f);
        if (this.field_148301_e.getBase64EncodedIconData() != null && !this.field_148301_e.getBase64EncodedIconData().equals(this.field_148299_g)) {
            this.field_148299_g = this.field_148301_e.getBase64EncodedIconData();
            this.prepareServerIcon();
            this.field_148303_c.getServerList().saveServerList();
        }
        if (this.field_148305_h != null) {
            this.func_178012_a(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, this.field_148306_i);
        }
        else {
            this.func_178012_a(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, ServerListEntryNormal.field_178015_c);
        }
        final int llllllllllllllllIIIIIllIllIllIlI = llllllllllllllllIIIIIllIllIlIIIl - llllllllllllllllIIIIIllIllllIllI;
        final int llllllllllllllllIIIIIllIllIllIIl = llllllllllllllllIIIIIllIllIlIIII - llllllllllllllllIIIIIllIllllIlIl;
        if (llllllllllllllllIIIIIllIllIllIlI >= llllllllllllllllIIIIIllIllIlIIlI - 15 && llllllllllllllllIIIIIllIllIllIlI <= llllllllllllllllIIIIIllIllIlIIlI - 5 && llllllllllllllllIIIIIllIllIllIIl >= 0 && llllllllllllllllIIIIIllIllIllIIl <= 8) {
            this.field_148303_c.func_146793_a(llllllllllllllllIIIIIllIllIllIll);
        }
        else if (llllllllllllllllIIIIIllIllIllIlI >= llllllllllllllllIIIIIllIllIlIIlI - llllllllllllllllIIIIIllIlllIlIIl - 15 - 2 && llllllllllllllllIIIIIllIllIllIlI <= llllllllllllllllIIIIIllIllIlIIlI - 15 - 2 && llllllllllllllllIIIIIllIllIllIIl >= 0 && llllllllllllllllIIIIIllIllIllIIl <= 8) {
            this.field_148303_c.func_146793_a(llllllllllllllllIIIIIllIlllIIlll);
        }
        if (this.field_148300_d.gameSettings.touchscreen || llllllllllllllllIIIIIllIllIIllll) {
            this.field_148300_d.getTextureManager().bindTexture(ServerListEntryNormal.field_178014_d);
            Gui.drawRect(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, llllllllllllllllIIIIIllIllllIllI + 32, llllllllllllllllIIIIIllIllllIlIl + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int llllllllllllllllIIIIIllIllIllIII = llllllllllllllllIIIIIllIllIlIIIl - llllllllllllllllIIIIIllIllllIllI;
            final int llllllllllllllllIIIIIllIllIlIlll = llllllllllllllllIIIIIllIllIlIIII - llllllllllllllllIIIIIllIllllIlIl;
            if (this.func_178013_b()) {
                if (llllllllllllllllIIIIIllIllIllIII < 32 && llllllllllllllllIIIIIllIllIllIII > 16) {
                    Gui.drawModalRectWithCustomSizedTexture(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, 0.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, 0.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
            if (this.field_148303_c.func_175392_a(this, llllllllllllllllIIIIIllIllllIlll)) {
                if (llllllllllllllllIIIIIllIllIllIII < 16 && llllllllllllllllIIIIIllIllIlIlll < 16) {
                    Gui.drawModalRectWithCustomSizedTexture(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, 96.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, 96.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
            if (this.field_148303_c.func_175394_b(this, llllllllllllllllIIIIIllIllllIlll)) {
                if (llllllllllllllllIIIIIllIllIllIII < 16 && llllllllllllllllIIIIIllIllIlIlll > 16) {
                    Gui.drawModalRectWithCustomSizedTexture(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, 64.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(llllllllllllllllIIIIIllIllllIllI, llllllllllllllllIIIIIllIllllIlIl, 64.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
        }
    }
    
    private boolean func_178013_b() {
        return true;
    }
    
    @Override
    public void setSelected(final int llllllllllllllllIIIIIllIlIIlIIIl, final int llllllllllllllllIIIIIllIlIIlIIII, final int llllllllllllllllIIIIIllIlIIIllll) {
    }
    
    protected ServerListEntryNormal(final GuiMultiplayer llllllllllllllllIIIIIlllIIIlIIII, final ServerData llllllllllllllllIIIIIlllIIIlIIlI) {
        this.field_148303_c = llllllllllllllllIIIIIlllIIIlIIII;
        this.field_148301_e = llllllllllllllllIIIIIlllIIIlIIlI;
        this.field_148300_d = Minecraft.getMinecraft();
        this.field_148306_i = new ResourceLocation(String.valueOf(new StringBuilder("servers/").append(llllllllllllllllIIIIIlllIIIlIIlI.serverIP).append("/icon")));
        this.field_148305_h = (DynamicTexture)this.field_148300_d.getTextureManager().getTexture(this.field_148306_i);
    }
    
    public ServerData getServerData() {
        return this.field_148301_e;
    }
    
    static {
        __OBFID = "CL_00000817";
        logger = LogManager.getLogger();
        field_148302_b = new ScheduledThreadPoolExecutor(5, new ThreadFactoryBuilder().setNameFormat("Server Pinger #%d").setDaemon(true).build());
        field_178015_c = new ResourceLocation("textures/misc/unknown_server.png");
        field_178014_d = new ResourceLocation("textures/gui/server_selection.png");
    }
    
    private void prepareServerIcon() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148301_e:Lnet/minecraft/client/multiplayer/ServerData;
        //     4: invokevirtual   net/minecraft/client/multiplayer/ServerData.getBase64EncodedIconData:()Ljava/lang/String;
        //     7: ifnonnull       32
        //    10: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //    11: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148300_d:Lnet/minecraft/client/Minecraft;
        //    14: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //    17: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //    18: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148306_i:Lnet/minecraft/util/ResourceLocation;
        //    21: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.deleteTexture:(Lnet/minecraft/util/ResourceLocation;)V
        //    24: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //    25: aconst_null    
        //    26: putfield        net/minecraft/client/gui/ServerListEntryNormal.field_148305_h:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //    29: goto            297
        //    32: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //    33: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148301_e:Lnet/minecraft/client/multiplayer/ServerData;
        //    36: invokevirtual   net/minecraft/client/multiplayer/ServerData.getBase64EncodedIconData:()Ljava/lang/String;
        //    39: getstatic       com/google/common/base/Charsets.UTF_8:Ljava/nio/charset/Charset;
        //    42: invokestatic    io/netty/buffer/Unpooled.copiedBuffer:(Ljava/lang/CharSequence;Ljava/nio/charset/Charset;)Lio/netty/buffer/ByteBuf;
        //    45: astore_1        /* llllllllllllllllIIIIIllIlIlIllII */
        //    46: aload_1         /* llllllllllllllllIIIIIllIlIlIllII */
        //    47: invokestatic    io/netty/handler/codec/base64/Base64.decode:(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
        //    50: astore_2        /* llllllllllllllllIIIIIllIlIlIlIll */
        //    51: new             Lio/netty/buffer/ByteBufInputStream;
        //    54: dup            
        //    55: aload_2         /* llllllllllllllllIIIIIllIlIlIlIll */
        //    56: invokespecial   io/netty/buffer/ByteBufInputStream.<init>:(Lio/netty/buffer/ByteBuf;)V
        //    59: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.func_177053_a:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    62: astore_3        /* llllllllllllllllIIIIIllIlIlIlIlI */
        //    63: aload_3         /* llllllllllllllllIIIIIllIlIlIlIlI */
        //    64: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    67: bipush          64
        //    69: if_icmpne       76
        //    72: iconst_1       
        //    73: goto            77
        //    76: iconst_0       
        //    77: ldc_w           "Must be 64 pixels wide"
        //    80: iconst_0       
        //    81: anewarray       Ljava/lang/Object;
        //    84: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //    87: aload_3         /* llllllllllllllllIIIIIllIlIlIlIlI */
        //    88: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    91: bipush          64
        //    93: if_icmpne       100
        //    96: iconst_1       
        //    97: goto            101
        //   100: iconst_0       
        //   101: ldc_w           "Must be 64 pixels high"
        //   104: iconst_0       
        //   105: anewarray       Ljava/lang/Object;
        //   108: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //   111: aload_1         /* llllllllllllllllIIIIIllIlIlIllII */
        //   112: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   115: pop            
        //   116: aload_2         /* llllllllllllllllIIIIIllIlIlIlIll */
        //   117: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   120: pop            
        //   121: goto            218
        //   124: astore          llllllllllllllllIIIIIllIlIlIlIII
        //   126: getstatic       net/minecraft/client/gui/ServerListEntryNormal.logger:Lorg/apache/logging/log4j/Logger;
        //   129: new             Ljava/lang/StringBuilder;
        //   132: dup            
        //   133: ldc_w           "Invalid icon for server "
        //   136: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   139: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   140: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148301_e:Lnet/minecraft/client/multiplayer/ServerData;
        //   143: getfield        net/minecraft/client/multiplayer/ServerData.serverName:Ljava/lang/String;
        //   146: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   149: ldc_w           " ("
        //   152: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   156: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148301_e:Lnet/minecraft/client/multiplayer/ServerData;
        //   159: getfield        net/minecraft/client/multiplayer/ServerData.serverIP:Ljava/lang/String;
        //   162: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   165: ldc_w           ")"
        //   168: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   171: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   174: aload           llllllllllllllllIIIIIllIlIlIlIII
        //   176: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   181: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   182: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148301_e:Lnet/minecraft/client/multiplayer/ServerData;
        //   185: aconst_null    
        //   186: invokevirtual   net/minecraft/client/multiplayer/ServerData.setBase64EncodedIconData:(Ljava/lang/String;)V
        //   189: aload_1         /* llllllllllllllllIIIIIllIlIlIllII */
        //   190: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   193: pop            
        //   194: aload_2         /* llllllllllllllllIIIIIllIlIlIlIll */
        //   195: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   198: pop            
        //   199: goto            217
        //   202: astore          llllllllllllllllIIIIIllIlIlIIIlI
        //   204: aload_1         /* llllllllllllllllIIIIIllIlIlIllII */
        //   205: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   208: pop            
        //   209: aload_2         /* llllllllllllllllIIIIIllIlIlIlIll */
        //   210: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   213: pop            
        //   214: aload           llllllllllllllllIIIIIllIlIlIIIlI
        //   216: athrow         
        //   217: return         
        //   218: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   219: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148305_h:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   222: ifnonnull       263
        //   225: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   226: new             Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   229: dup            
        //   230: aload_3         /* llllllllllllllllIIIIIllIlIlIlIIl */
        //   231: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   234: aload_3         /* llllllllllllllllIIIIIllIlIlIlIIl */
        //   235: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   238: invokespecial   net/minecraft/client/renderer/texture/DynamicTexture.<init>:(II)V
        //   241: putfield        net/minecraft/client/gui/ServerListEntryNormal.field_148305_h:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   244: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   245: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148300_d:Lnet/minecraft/client/Minecraft;
        //   248: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //   251: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   252: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148306_i:Lnet/minecraft/util/ResourceLocation;
        //   255: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   256: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148305_h:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   259: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.loadTexture:(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/client/renderer/texture/ITextureObject;)Z
        //   262: pop            
        //   263: aload_3         /* llllllllllllllllIIIIIllIlIlIlIIl */
        //   264: iconst_0       
        //   265: iconst_0       
        //   266: aload_3         /* llllllllllllllllIIIIIllIlIlIlIIl */
        //   267: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   270: aload_3         /* llllllllllllllllIIIIIllIlIlIlIIl */
        //   271: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   274: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   275: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148305_h:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   278: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.getTextureData:()[I
        //   281: iconst_0       
        //   282: aload_3         /* llllllllllllllllIIIIIllIlIlIlIIl */
        //   283: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   286: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //   289: pop            
        //   290: aload_0         /* llllllllllllllllIIIIIllIlIlIIlll */
        //   291: getfield        net/minecraft/client/gui/ServerListEntryNormal.field_148305_h:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   294: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.updateDynamicTexture:()V
        //   297: return         
        //    StackMapTable: 00 0B 20 FE 00 2B 07 02 17 07 02 17 07 02 05 40 01 16 40 01 FF 00 16 00 03 07 00 02 07 02 17 07 02 17 00 01 07 01 E3 F7 00 4D 07 02 4B FD 00 0E 00 07 01 E3 FF 00 00 00 04 07 00 02 07 02 17 07 02 17 07 02 05 00 00 2C F8 00 21
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  51     111    124    202    Ljava/lang/Exception;
        //  51     111    202    217    Any
        //  124    189    202    217    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
