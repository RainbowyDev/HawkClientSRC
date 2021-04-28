package net.minecraft.client.gui;

import java.io.*;
import net.minecraft.client.resources.*;
import org.lwjgl.input.*;
import net.minecraft.world.storage.*;

public class GuiRenameWorld extends GuiScreen
{
    private final /* synthetic */ String field_146584_g;
    private /* synthetic */ GuiTextField field_146583_f;
    private /* synthetic */ GuiScreen field_146585_a;
    
    public GuiRenameWorld(final GuiScreen lllIIlIlIllll, final String lllIIlIlIlllI) {
        this.field_146585_a = lllIIlIlIllll;
        this.field_146584_g = lllIIlIlIlllI;
    }
    
    @Override
    protected void mouseClicked(final int lllIIlIIIIIll, final int lllIIlIIIIIlI, final int lllIIIllllIll) throws IOException {
        super.mouseClicked(lllIIlIIIIIll, lllIIlIIIIIlI, lllIIIllllIll);
        this.field_146583_f.mouseClicked(lllIIlIIIIIll, lllIIlIIIIIlI, lllIIIllllIll);
    }
    
    @Override
    public void drawScreen(final int lllIIIlllIlIl, final int lllIIIlllIIII, final float lllIIIlllIIll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("selectWorld.renameTitle", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterName", new Object[0]), this.width / 2 - 100, 47, 10526880);
        this.field_146583_f.drawTextBox();
        super.drawScreen(lllIIIlllIlIl, lllIIIlllIIII, lllIIIlllIIll);
    }
    
    @Override
    protected void keyTyped(final char lllIIlIIIllIl, final int lllIIlIIIllll) throws IOException {
        this.field_146583_f.textboxKeyTyped(lllIIlIIIllIl, lllIIlIIIllll);
        this.buttonList.get(0).enabled = (this.field_146583_f.getText().trim().length() > 0);
        if (lllIIlIIIllll == 28 || lllIIlIIIllll == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, I18n.format("selectWorld.renameButton", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
        final ISaveFormat lllIIlIlIIlIl = this.mc.getSaveLoader();
        final WorldInfo lllIIlIlIIlII = lllIIlIlIIlIl.getWorldInfo(this.field_146584_g);
        final String lllIIlIlIIIll = lllIIlIlIIlII.getWorldName();
        this.field_146583_f = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.field_146583_f.setFocused(true);
        this.field_146583_f.setText(lllIIlIlIIIll);
    }
    
    @Override
    public void updateScreen() {
        this.field_146583_f.updateCursorCounter();
    }
    
    static {
        __OBFID = "CL_00000709";
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllIIlIIlIllI) throws IOException {
        if (lllIIlIIlIllI.enabled) {
            if (lllIIlIIlIllI.id == 1) {
                this.mc.displayGuiScreen(this.field_146585_a);
            }
            else if (lllIIlIIlIllI.id == 0) {
                final ISaveFormat lllIIlIIllIII = this.mc.getSaveLoader();
                lllIIlIIllIII.renameWorld(this.field_146584_g, this.field_146583_f.getText().trim());
                this.mc.displayGuiScreen(this.field_146585_a);
            }
        }
    }
}
