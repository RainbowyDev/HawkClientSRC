package net.minecraft.client.gui;

import org.apache.logging.log4j.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import com.google.common.collect.*;
import java.io.*;
import org.lwjgl.input.*;
import org.apache.commons.lang3.*;
import net.minecraft.util.*;
import java.util.*;

public class GuiChat extends GuiScreen
{
    protected /* synthetic */ GuiTextField inputField;
    private /* synthetic */ String historyBuffer;
    private /* synthetic */ boolean waitingOnAutocomplete;
    private /* synthetic */ int autocompleteIndex;
    private /* synthetic */ List foundPlayerNames;
    private /* synthetic */ String defaultInputFieldText;
    private /* synthetic */ boolean playerNamesFound;
    private /* synthetic */ int sentHistoryCursor;
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.sentHistoryCursor = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
        this.inputField = new GuiTextField(0, this.fontRendererObj, 4, this.height - 12, this.width - 4, 12);
        this.inputField.setMaxStringLength(100);
        this.inputField.setEnableBackgroundDrawing(false);
        this.inputField.setFocused(true);
        this.inputField.setText(this.defaultInputFieldText);
        this.inputField.setCanLoseFocus(false);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc.ingameGUI.getChatGUI().resetScroll();
    }
    
    public void getSentHistory(final int llllllllllllllIIIIIlIIlIIIlIlllI) {
        int llllllllllllllIIIIIlIIlIIIlIllIl = this.sentHistoryCursor + llllllllllllllIIIIIlIIlIIIlIlllI;
        final int llllllllllllllIIIIIlIIlIIIlIllII = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
        llllllllllllllIIIIIlIIlIIIlIllIl = MathHelper.clamp_int(llllllllllllllIIIIIlIIlIIIlIllIl, 0, llllllllllllllIIIIIlIIlIIIlIllII);
        if (llllllllllllllIIIIIlIIlIIIlIllIl != this.sentHistoryCursor) {
            if (llllllllllllllIIIIIlIIlIIIlIllIl == llllllllllllllIIIIIlIIlIIIlIllII) {
                this.sentHistoryCursor = llllllllllllllIIIIIlIIlIIIlIllII;
                this.inputField.setText(this.historyBuffer);
            }
            else {
                if (this.sentHistoryCursor == llllllllllllllIIIIIlIIlIIIlIllII) {
                    this.historyBuffer = this.inputField.getText();
                }
                this.inputField.setText(this.mc.ingameGUI.getChatGUI().getSentMessages().get(llllllllllllllIIIIIlIIlIIIlIllIl));
                this.sentHistoryCursor = llllllllllllllIIIIIlIIlIIIlIllIl;
            }
        }
    }
    
    static {
        __OBFID = "CL_00000682";
        logger = LogManager.getLogger();
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    private void sendAutocompleteRequest(final String llllllllllllllIIIIIlIIlIIIllIlIl, final String llllllllllllllIIIIIlIIlIIIlllIII) {
        if (llllllllllllllIIIIIlIIlIIIllIlIl.length() >= 1) {
            BlockPos llllllllllllllIIIIIlIIlIIIllIlll = null;
            if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                llllllllllllllIIIIIlIIlIIIllIlll = this.mc.objectMouseOver.func_178782_a();
            }
            this.mc.thePlayer.sendQueue.addToSendQueue(new C14PacketTabComplete(llllllllllllllIIIIIlIIlIIIllIlIl, llllllllllllllIIIIIlIIlIIIllIlll));
            this.waitingOnAutocomplete = true;
        }
    }
    
    public GuiChat(final String llllllllllllllIIIIIlIIlIlIIIIIII) {
        this.historyBuffer = "";
        this.sentHistoryCursor = -1;
        this.foundPlayerNames = Lists.newArrayList();
        this.defaultInputFieldText = "";
        this.defaultInputFieldText = llllllllllllllIIIIIlIIlIlIIIIIII;
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIIIIIlIIlIIlllIIIl, final int llllllllllllllIIIIIlIIlIIllIllII) throws IOException {
        this.waitingOnAutocomplete = false;
        if (llllllllllllllIIIIIlIIlIIllIllII == 15) {
            this.autocompletePlayerNames();
        }
        else {
            this.playerNamesFound = false;
        }
        if (llllllllllllllIIIIIlIIlIIllIllII == 1) {
            this.mc.displayGuiScreen(null);
        }
        else if (llllllllllllllIIIIIlIIlIIllIllII != 28 && llllllllllllllIIIIIlIIlIIllIllII != 156) {
            if (llllllllllllllIIIIIlIIlIIllIllII == 200) {
                this.getSentHistory(-1);
            }
            else if (llllllllllllllIIIIIlIIlIIllIllII == 208) {
                this.getSentHistory(1);
            }
            else if (llllllllllllllIIIIIlIIlIIllIllII == 201) {
                this.mc.ingameGUI.getChatGUI().scroll(this.mc.ingameGUI.getChatGUI().getLineCount() - 1);
            }
            else if (llllllllllllllIIIIIlIIlIIllIllII == 209) {
                this.mc.ingameGUI.getChatGUI().scroll(-this.mc.ingameGUI.getChatGUI().getLineCount() + 1);
            }
            else {
                this.inputField.textboxKeyTyped(llllllllllllllIIIIIlIIlIIlllIIIl, llllllllllllllIIIIIlIIlIIllIllII);
            }
        }
        else {
            final String llllllllllllllIIIIIlIIlIIllIllll = this.inputField.getText().trim();
            if (llllllllllllllIIIIIlIIlIIllIllll.length() > 0) {
                this.func_175275_f(llllllllllllllIIIIIlIIlIIllIllll);
            }
            this.mc.displayGuiScreen(null);
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIIIIIlIIlIIlIllllI, final int llllllllllllllIIIIIlIIlIIlIllIII, final int llllllllllllllIIIIIlIIlIIlIlIlll) throws IOException {
        if (llllllllllllllIIIIIlIIlIIlIlIlll == 0) {
            final IChatComponent llllllllllllllIIIIIlIIlIIlIllIll = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
            if (this.func_175276_a(llllllllllllllIIIIIlIIlIIlIllIll)) {
                return;
            }
        }
        this.inputField.mouseClicked(llllllllllllllIIIIIlIIlIIlIllllI, llllllllllllllIIIIIlIIlIIlIllIII, llllllllllllllIIIIIlIIlIIlIlIlll);
        super.mouseClicked(llllllllllllllIIIIIlIIlIIlIllllI, llllllllllllllIIIIIlIIlIIlIllIII, llllllllllllllIIIIIlIIlIIlIlIlll);
    }
    
    public GuiChat() {
        this.historyBuffer = "";
        this.sentHistoryCursor = -1;
        this.foundPlayerNames = Lists.newArrayList();
        this.defaultInputFieldText = "";
    }
    
    @Override
    public void updateScreen() {
        this.inputField.updateCursorCounter();
    }
    
    @Override
    protected void func_175274_a(final String llllllllllllllIIIIIlIIlIIlIIlllI, final boolean llllllllllllllIIIIIlIIlIIlIIllIl) {
        if (llllllllllllllIIIIIlIIlIIlIIllIl) {
            this.inputField.setText(llllllllllllllIIIIIlIIlIIlIIlllI);
        }
        else {
            this.inputField.writeText(llllllllllllllIIIIIlIIlIIlIIlllI);
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIIIlIIlIIIIlllII, final int llllllllllllllIIIIIlIIlIIIlIIIII, final float llllllllllllllIIIIIlIIlIIIIllIlI) {
        Gui.drawRect(2.0, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
        this.inputField.drawTextBox();
        final IChatComponent llllllllllllllIIIIIlIIlIIIIllllI = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
        if (llllllllllllllIIIIIlIIlIIIIllllI != null && llllllllllllllIIIIIlIIlIIIIllllI.getChatStyle().getChatHoverEvent() != null) {
            this.func_175272_a(llllllllllllllIIIIIlIIlIIIIllllI, llllllllllllllIIIIIlIIlIIIIlllII, llllllllllllllIIIIIlIIlIIIlIIIII);
        }
        super.drawScreen(llllllllllllllIIIIIlIIlIIIIlllII, llllllllllllllIIIIIlIIlIIIlIIIII, llllllllllllllIIIIIlIIlIIIIllIlI);
    }
    
    public void onAutocompleteResponse(final String[] llllllllllllllIIIIIlIIlIIIIlIIIl) {
        if (this.waitingOnAutocomplete) {
            this.playerNamesFound = false;
            this.foundPlayerNames.clear();
            final String[] llllllllllllllIIIIIlIIlIIIIlIIII = llllllllllllllIIIIIlIIlIIIIlIIIl;
            for (int llllllllllllllIIIIIlIIlIIIIIllll = llllllllllllllIIIIIlIIlIIIIlIIIl.length, llllllllllllllIIIIIlIIlIIIIIlllI = 0; llllllllllllllIIIIIlIIlIIIIIlllI < llllllllllllllIIIIIlIIlIIIIIllll; ++llllllllllllllIIIIIlIIlIIIIIlllI) {
                final String llllllllllllllIIIIIlIIlIIIIIllIl = llllllllllllllIIIIIlIIlIIIIlIIII[llllllllllllllIIIIIlIIlIIIIIlllI];
                if (llllllllllllllIIIIIlIIlIIIIIllIl.length() > 0) {
                    this.foundPlayerNames.add(llllllllllllllIIIIIlIIlIIIIIllIl);
                }
            }
            final String llllllllllllllIIIIIlIIlIIIIIllII = this.inputField.getText().substring(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false));
            final String llllllllllllllIIIIIlIIlIIIIIlIll = StringUtils.getCommonPrefix(llllllllllllllIIIIIlIIlIIIIlIIIl);
            if (llllllllllllllIIIIIlIIlIIIIIlIll.length() > 0 && !llllllllllllllIIIIIlIIlIIIIIllII.equalsIgnoreCase(llllllllllllllIIIIIlIIlIIIIIlIll)) {
                this.inputField.deleteFromCursor(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false) - this.inputField.getCursorPosition());
                this.inputField.writeText(llllllllllllllIIIIIlIIlIIIIIlIll);
            }
            else if (this.foundPlayerNames.size() > 0) {
                this.playerNamesFound = true;
                this.autocompletePlayerNames();
            }
        }
    }
    
    public void autocompletePlayerNames() {
        if (this.playerNamesFound) {
            this.inputField.deleteFromCursor(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false) - this.inputField.getCursorPosition());
            if (this.autocompleteIndex >= this.foundPlayerNames.size()) {
                this.autocompleteIndex = 0;
            }
        }
        else {
            final int llllllllllllllIIIIIlIIlIIlIIIlIl = this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false);
            this.foundPlayerNames.clear();
            this.autocompleteIndex = 0;
            final String llllllllllllllIIIIIlIIlIIlIIIlII = this.inputField.getText().substring(llllllllllllllIIIIIlIIlIIlIIIlIl).toLowerCase();
            final String llllllllllllllIIIIIlIIlIIlIIIlll = this.inputField.getText().substring(0, this.inputField.getCursorPosition());
            this.sendAutocompleteRequest(llllllllllllllIIIIIlIIlIIlIIIlll, llllllllllllllIIIIIlIIlIIlIIIlII);
            if (this.foundPlayerNames.isEmpty()) {
                return;
            }
            this.playerNamesFound = true;
            this.inputField.deleteFromCursor(llllllllllllllIIIIIlIIlIIlIIIlIl - this.inputField.getCursorPosition());
        }
        if (this.foundPlayerNames.size() > 1) {
            final StringBuilder llllllllllllllIIIIIlIIlIIlIIIIll = new StringBuilder();
            for (final String llllllllllllllIIIIIlIIlIIlIIIllI : this.foundPlayerNames) {
                if (llllllllllllllIIIIIlIIlIIlIIIIll.length() > 0) {
                    llllllllllllllIIIIIlIIlIIlIIIIll.append(", ");
                }
                llllllllllllllIIIIIlIIlIIlIIIIll.append(llllllllllllllIIIIIlIIlIIlIIIllI);
            }
            this.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new ChatComponentText(String.valueOf(llllllllllllllIIIIIlIIlIIlIIIIll)), 1);
        }
        this.inputField.writeText(this.foundPlayerNames.get(this.autocompleteIndex++));
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int llllllllllllllIIIIIlIIlIIllIIlll = Mouse.getEventDWheel();
        if (llllllllllllllIIIIIlIIlIIllIIlll != 0) {
            if (llllllllllllllIIIIIlIIlIIllIIlll > 1) {
                llllllllllllllIIIIIlIIlIIllIIlll = 1;
            }
            if (llllllllllllllIIIIIlIIlIIllIIlll < -1) {
                llllllllllllllIIIIIlIIlIIllIIlll = -1;
            }
            if (!GuiScreen.isShiftKeyDown()) {
                llllllllllllllIIIIIlIIlIIllIIlll *= 7;
            }
            this.mc.ingameGUI.getChatGUI().scroll(llllllllllllllIIIIIlIIlIIllIIlll);
        }
    }
}
