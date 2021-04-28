package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import java.util.*;
import net.minecraft.client.*;
import java.io.*;

public class GuiControls extends GuiScreen
{
    private /* synthetic */ GuiButton buttonReset;
    public /* synthetic */ KeyBinding buttonId;
    private /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ GuiKeyBindingList keyBindingList;
    public /* synthetic */ long time;
    protected /* synthetic */ String screenTitle;
    private /* synthetic */ GameSettings options;
    private static final /* synthetic */ GameSettings.Options[] optionsArr;
    
    @Override
    public void initGui() {
        this.keyBindingList = new GuiKeyBindingList(this, this.mc);
        this.buttonList.add(new GuiButton(200, this.width / 2 - 155, this.height - 29, 150, 20, I18n.format("gui.done", new Object[0])));
        final List buttonList = this.buttonList;
        final GuiButton buttonReset = new GuiButton(201, this.width / 2 - 155 + 160, this.height - 29, 150, 20, I18n.format("controls.resetAll", new Object[0]));
        this.buttonReset = buttonReset;
        buttonList.add(buttonReset);
        this.screenTitle = I18n.format("controls.title", new Object[0]);
        int lllllllllllllllIIlIIIIIlIIIllIII = 0;
        for (final GameSettings.Options lllllllllllllllIIlIIIIIlIIIlIlII : GuiControls.optionsArr) {
            if (lllllllllllllllIIlIIIIIlIIIlIlII.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(lllllllllllllllIIlIIIIIlIIIlIlII.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllllllIIlIIIIIlIIIllIII % 2 * 160, 18 + 24 * (lllllllllllllllIIlIIIIIlIIIllIII >> 1), lllllllllllllllIIlIIIIIlIIIlIlII));
            }
            else {
                this.buttonList.add(new GuiOptionButton(lllllllllllllllIIlIIIIIlIIIlIlII.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllllllIIlIIIIIlIIIllIII % 2 * 160, 18 + 24 * (lllllllllllllllIIlIIIIIlIIIllIII >> 1), lllllllllllllllIIlIIIIIlIIIlIlII, this.options.getKeyBinding(lllllllllllllllIIlIIIIIlIIIlIlII)));
            }
            ++lllllllllllllllIIlIIIIIlIIIllIII;
        }
    }
    
    public GuiControls(final GuiScreen lllllllllllllllIIlIIIIIlIllllIII, final GameSettings lllllllllllllllIIlIIIIIlIlllIlll) {
        this.screenTitle = "Controls";
        this.buttonId = null;
        this.parentScreen = lllllllllllllllIIlIIIIIlIllllIII;
        this.options = lllllllllllllllIIlIIIIIlIlllIlll;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllIIlIIIIIIllIllIIl, final int lllllllllllllllIIlIIIIIIllIllIll) throws IOException {
        if (this.buttonId != null) {
            if (lllllllllllllllIIlIIIIIIllIllIll == 1) {
                this.options.setOptionKeyBinding(this.buttonId, 0);
            }
            else if (lllllllllllllllIIlIIIIIIllIllIll != 0) {
                this.options.setOptionKeyBinding(this.buttonId, lllllllllllllllIIlIIIIIIllIllIll);
            }
            else if (lllllllllllllllIIlIIIIIIllIllIIl > '\0') {
                this.options.setOptionKeyBinding(this.buttonId, lllllllllllllllIIlIIIIIIllIllIIl + '\u0100');
            }
            this.buttonId = null;
            this.time = Minecraft.getSystemTime();
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else {
            super.keyTyped(lllllllllllllllIIlIIIIIIllIllIIl, lllllllllllllllIIlIIIIIIllIllIll);
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIlIIIIIIllIIllIl, final int lllllllllllllllIIlIIIIIIllIIIIll, final float lllllllllllllllIIlIIIIIIllIIIIlI) {
        this.drawDefaultBackground();
        this.keyBindingList.drawScreen(lllllllllllllllIIlIIIIIIllIIllIl, lllllllllllllllIIlIIIIIIllIIIIll, lllllllllllllllIIlIIIIIIllIIIIlI);
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 8, 16777215);
        boolean lllllllllllllllIIlIIIIIIllIIlIlI = true;
        for (final KeyBinding lllllllllllllllIIlIIIIIIllIIIllI : this.options.keyBindings) {
            if (lllllllllllllllIIlIIIIIIllIIIllI.getKeyCode() != lllllllllllllllIIlIIIIIIllIIIllI.getKeyCodeDefault()) {
                lllllllllllllllIIlIIIIIIllIIlIlI = false;
                break;
            }
        }
        this.buttonReset.enabled = !lllllllllllllllIIlIIIIIIllIIlIlI;
        super.drawScreen(lllllllllllllllIIlIIIIIIllIIllIl, lllllllllllllllIIlIIIIIIllIIIIll, lllllllllllllllIIlIIIIIIllIIIIlI);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIlIIIIIlIIIIIIll) throws IOException {
        if (lllllllllllllllIIlIIIIIlIIIIIIll.id == 200) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
        else if (lllllllllllllllIIlIIIIIlIIIIIIll.id == 201) {
            for (final KeyBinding lllllllllllllllIIlIIIIIIllllllll : this.mc.gameSettings.keyBindings) {
                lllllllllllllllIIlIIIIIIllllllll.setKeyCode(lllllllllllllllIIlIIIIIIllllllll.getKeyCodeDefault());
            }
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else if (lllllllllllllllIIlIIIIIlIIIIIIll.id < 100 && lllllllllllllllIIlIIIIIlIIIIIIll instanceof GuiOptionButton) {
            this.options.setOptionValue(((GuiOptionButton)lllllllllllllllIIlIIIIIlIIIIIIll).returnEnumOptions(), 1);
            lllllllllllllllIIlIIIIIlIIIIIIll.displayString = this.options.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllllllIIlIIIIIlIIIIIIll.id));
        }
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllllllIIlIIIIIIlllIIlll, final int lllllllllllllllIIlIIIIIIlllIIIlI, final int lllllllllllllllIIlIIIIIIlllIIIIl) {
        if (lllllllllllllllIIlIIIIIIlllIIIIl != 0 || !this.keyBindingList.func_148181_b(lllllllllllllllIIlIIIIIIlllIIlll, lllllllllllllllIIlIIIIIIlllIIIlI, lllllllllllllllIIlIIIIIIlllIIIIl)) {
            super.mouseReleased(lllllllllllllllIIlIIIIIIlllIIlll, lllllllllllllllIIlIIIIIIlllIIIlI, lllllllllllllllIIlIIIIIIlllIIIIl);
        }
    }
    
    static {
        __OBFID = "CL_00000736";
        optionsArr = new GameSettings.Options[] { GameSettings.Options.INVERT_MOUSE, GameSettings.Options.SENSITIVITY, GameSettings.Options.TOUCHSCREEN };
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.keyBindingList.func_178039_p();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIIlIIIIIIllllIIll, final int lllllllllllllllIIlIIIIIIllllIIlI, final int lllllllllllllllIIlIIIIIIllllIIIl) throws IOException {
        if (this.buttonId != null) {
            this.options.setOptionKeyBinding(this.buttonId, -100 + lllllllllllllllIIlIIIIIIllllIIIl);
            this.buttonId = null;
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else if (lllllllllllllllIIlIIIIIIllllIIIl != 0 || !this.keyBindingList.func_148179_a(lllllllllllllllIIlIIIIIIllllIIll, lllllllllllllllIIlIIIIIIllllIIlI, lllllllllllllllIIlIIIIIIllllIIIl)) {
            super.mouseClicked(lllllllllllllllIIlIIIIIIllllIIll, lllllllllllllllIIlIIIIIIllllIIlI, lllllllllllllllIIlIIIIIIllllIIIl);
        }
    }
}
