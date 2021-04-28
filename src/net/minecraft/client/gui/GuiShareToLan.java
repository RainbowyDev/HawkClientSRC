package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import java.io.*;

public class GuiShareToLan extends GuiScreen
{
    private /* synthetic */ boolean field_146600_i;
    private /* synthetic */ String field_146599_h;
    private /* synthetic */ GuiButton field_146596_f;
    private /* synthetic */ GuiButton field_146597_g;
    private final /* synthetic */ GuiScreen field_146598_a;
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(101, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("lanServer.start", new Object[0])));
        this.buttonList.add(new GuiButton(102, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        final List buttonList = this.buttonList;
        final GuiButton field_146597_g = new GuiButton(104, this.width / 2 - 155, 100, 150, 20, I18n.format("selectWorld.gameMode", new Object[0]));
        this.field_146597_g = field_146597_g;
        buttonList.add(field_146597_g);
        final List buttonList2 = this.buttonList;
        final GuiButton field_146596_f = new GuiButton(103, this.width / 2 + 5, 100, 150, 20, I18n.format("selectWorld.allowCommands", new Object[0]));
        this.field_146596_f = field_146596_f;
        buttonList2.add(field_146596_f);
        this.func_146595_g();
    }
    
    public GuiShareToLan(final GuiScreen llllllllllllllllIlIIllIlllIIIIII) {
        this.field_146599_h = "survival";
        this.field_146598_a = llllllllllllllllIlIIllIlllIIIIII;
    }
    
    private void func_146595_g() {
        this.field_146597_g.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.gameMode", new Object[0]))).append(" ").append(I18n.format(String.valueOf(new StringBuilder("selectWorld.gameMode.").append(this.field_146599_h)), new Object[0])));
        this.field_146596_f.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0]))).append(" "));
        if (this.field_146600_i) {
            this.field_146596_f.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146596_f.displayString)).append(I18n.format("options.on", new Object[0])));
        }
        else {
            this.field_146596_f.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146596_f.displayString)).append(I18n.format("options.off", new Object[0])));
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIlIIllIllIlIIIIl, final int llllllllllllllllIlIIllIllIlIIlII, final float llllllllllllllllIlIIllIllIIlllll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("lanServer.title", new Object[0]), this.width / 2, 50, 16777215);
        this.drawCenteredString(this.fontRendererObj, I18n.format("lanServer.otherPlayers", new Object[0]), this.width / 2, 82, 16777215);
        super.drawScreen(llllllllllllllllIlIIllIllIlIIIIl, llllllllllllllllIlIIllIllIlIIlII, llllllllllllllllIlIIllIllIIlllll);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIlIIllIllIlIllIl) throws IOException {
        if (llllllllllllllllIlIIllIllIlIllIl.id == 102) {
            this.mc.displayGuiScreen(this.field_146598_a);
        }
        else if (llllllllllllllllIlIIllIllIlIllIl.id == 104) {
            if (this.field_146599_h.equals("spectator")) {
                this.field_146599_h = "creative";
            }
            else if (this.field_146599_h.equals("creative")) {
                this.field_146599_h = "adventure";
            }
            else if (this.field_146599_h.equals("adventure")) {
                this.field_146599_h = "survival";
            }
            else {
                this.field_146599_h = "spectator";
            }
            this.func_146595_g();
        }
        else if (llllllllllllllllIlIIllIllIlIllIl.id == 103) {
            this.field_146600_i = !this.field_146600_i;
            this.func_146595_g();
        }
        else if (llllllllllllllllIlIIllIllIlIllIl.id == 101) {
            this.mc.displayGuiScreen(null);
            final String llllllllllllllllIlIIllIllIllIIIl = this.mc.getIntegratedServer().shareToLAN(WorldSettings.GameType.getByName(this.field_146599_h), this.field_146600_i);
            Object llllllllllllllllIlIIllIllIlIllll = null;
            if (llllllllllllllllIlIIllIllIllIIIl != null) {
                final Object llllllllllllllllIlIIllIllIllIIII = new ChatComponentTranslation("commands.publish.started", new Object[] { llllllllllllllllIlIIllIllIllIIIl });
            }
            else {
                llllllllllllllllIlIIllIllIlIllll = new ChatComponentText("commands.publish.failed");
            }
            this.mc.ingameGUI.getChatGUI().printChatMessage((IChatComponent)llllllllllllllllIlIIllIllIlIllll);
        }
    }
    
    static {
        __OBFID = "CL_00000713";
    }
}
