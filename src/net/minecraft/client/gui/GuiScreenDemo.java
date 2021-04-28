package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.settings.*;
import java.net.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;

public class GuiScreenDemo extends GuiScreen
{
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ ResourceLocation field_146348_f;
    
    @Override
    public void drawScreen(final int llllllllllllllIIIIIllIlIIlIIIIIl, final int llllllllllllllIIIIIllIlIIlIIIIII, final float llllllllllllllIIIIIllIlIIIlllIII) {
        this.drawDefaultBackground();
        final int llllllllllllllIIIIIllIlIIIlllllI = (this.width - 248) / 2 + 10;
        int llllllllllllllIIIIIllIlIIIllllIl = (this.height - 166) / 2 + 8;
        this.fontRendererObj.drawString(I18n.format("demo.help.title", new Object[0]), llllllllllllllIIIIIllIlIIIlllllI, llllllllllllllIIIIIllIlIIIllllIl, 2039583);
        llllllllllllllIIIIIllIlIIIllllIl += 12;
        final GameSettings llllllllllllllIIIIIllIlIIIllllII = this.mc.gameSettings;
        this.fontRendererObj.drawString(I18n.format("demo.help.movementShort", GameSettings.getKeyDisplayString(llllllllllllllIIIIIllIlIIIllllII.keyBindForward.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllllIIIIIllIlIIIllllII.keyBindLeft.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllllIIIIIllIlIIIllllII.keyBindBack.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllllIIIIIllIlIIIllllII.keyBindRight.getKeyCode())), llllllllllllllIIIIIllIlIIIlllllI, llllllllllllllIIIIIllIlIIIllllIl, 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.movementMouse", new Object[0]), llllllllllllllIIIIIllIlIIIlllllI, llllllllllllllIIIIIllIlIIIllllIl + 12, 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.jump", GameSettings.getKeyDisplayString(llllllllllllllIIIIIllIlIIIllllII.keyBindJump.getKeyCode())), llllllllllllllIIIIIllIlIIIlllllI, llllllllllllllIIIIIllIlIIIllllIl + 24, 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.inventory", GameSettings.getKeyDisplayString(llllllllllllllIIIIIllIlIIIllllII.keyBindInventory.getKeyCode())), llllllllllllllIIIIIllIlIIIlllllI, llllllllllllllIIIIIllIlIIIllllIl + 36, 5197647);
        this.fontRendererObj.drawSplitString(I18n.format("demo.help.fullWrapped", new Object[0]), llllllllllllllIIIIIllIlIIIlllllI, llllllllllllllIIIIIllIlIIIllllIl + 68, 218, 2039583);
        super.drawScreen(llllllllllllllIIIIIllIlIIlIIIIIl, llllllllllllllIIIIIllIlIIlIIIIII, llllllllllllllIIIIIllIlIIIlllIII);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        final byte llllllllllllllIIIIIllIlIIllIIlIl = -16;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 116, this.height / 2 + 62 + llllllllllllllIIIIIllIlIIllIIlIl, 114, 20, I18n.format("demo.help.buy", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height / 2 + 62 + llllllllllllllIIIIIllIlIIllIIlIl, 114, 20, I18n.format("demo.help.later", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIIIIllIlIIlIlllIl) throws IOException {
        switch (llllllllllllllIIIIIllIlIIlIlllIl.id) {
            case 1: {
                llllllllllllllIIIIIllIlIIlIlllIl.enabled = false;
                try {
                    final Class llllllllllllllIIIIIllIlIIlIlllII = Class.forName("java.awt.Desktop");
                    final Object llllllllllllllIIIIIllIlIIlIllIll = llllllllllllllIIIIIllIlIIlIlllII.getMethod("getDesktop", (Class[])new Class[0]).invoke(null, new Object[0]);
                    llllllllllllllIIIIIllIlIIlIlllII.getMethod("browse", URI.class).invoke(llllllllllllllIIIIIllIlIIlIllIll, new URI("http://www.minecraft.net/store?source=demo"));
                }
                catch (Throwable llllllllllllllIIIIIllIlIIlIllIlI) {
                    GuiScreenDemo.logger.error("Couldn't open link", llllllllllllllIIIIIllIlIIlIllIlI);
                }
                break;
            }
            case 2: {
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
            }
        }
    }
    
    @Override
    public void drawDefaultBackground() {
        super.drawDefaultBackground();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenDemo.field_146348_f);
        final int llllllllllllllIIIIIllIlIIlIIlllI = (this.width - 248) / 2;
        final int llllllllllllllIIIIIllIlIIlIIllIl = (this.height - 166) / 2;
        this.drawTexturedModalRect(llllllllllllllIIIIIllIlIIlIIlllI, llllllllllllllIIIIIllIlIIlIIllIl, 0, 0, 248, 166);
    }
    
    static {
        __OBFID = "CL_00000691";
        logger = LogManager.getLogger();
        field_146348_f = new ResourceLocation("textures/gui/demo_background.png");
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
    }
}
