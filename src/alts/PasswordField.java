package alts;

import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;

public class PasswordField extends Gui
{
    private /* synthetic */ boolean enableBackgroundDrawing;
    private final /* synthetic */ FontRenderer fontRenderer;
    private /* synthetic */ int enabledColor;
    private final /* synthetic */ int width;
    private final /* synthetic */ int height;
    public /* synthetic */ boolean isFocused;
    private /* synthetic */ int disabledColor;
    private final /* synthetic */ int yPos;
    private /* synthetic */ boolean canLoseFocus;
    private /* synthetic */ boolean b;
    private /* synthetic */ int maxStringLength;
    private final /* synthetic */ int xPos;
    private /* synthetic */ int cursorCounter;
    private /* synthetic */ int i;
    private /* synthetic */ String text;
    private /* synthetic */ int cursorPosition;
    private /* synthetic */ int selectionEnd;
    private /* synthetic */ boolean isEnabled;
    
    public void setEnableBackgroundDrawing(final boolean llllllllllllllIlIIllIlIIIIIllIlI) {
        this.enableBackgroundDrawing = llllllllllllllIlIIllIlIIIIIllIlI;
    }
    
    public boolean func_73778_q() {
        return this.b;
    }
    
    public void setCanLoseFocus(final boolean llllllllllllllIlIIllIIlllllIIlll) {
        this.canLoseFocus = llllllllllllllIlIIllIIlllllIIlll;
    }
    
    public void cursorPos(final int llllllllllllllIlIIllIlIIlIllIIlI) {
        this.setCursorPosition(this.selectionEnd + llllllllllllllIlIIllIlIIlIllIIlI);
    }
    
    private void drawCursorVertical(int llllllllllllllIlIIllIlIIIlIlIIIl, int llllllllllllllIlIIllIlIIIlIIlIII, int llllllllllllllIlIIllIlIIIlIIIlll, int llllllllllllllIlIIllIlIIIlIIlllI) {
        if (llllllllllllllIlIIllIlIIIlIlIIIl < llllllllllllllIlIIllIlIIIlIIIlll) {
            final int llllllllllllllIlIIllIlIIIlIIllIl = llllllllllllllIlIIllIlIIIlIlIIIl;
            llllllllllllllIlIIllIlIIIlIlIIIl = llllllllllllllIlIIllIlIIIlIIIlll;
            llllllllllllllIlIIllIlIIIlIIIlll = llllllllllllllIlIIllIlIIIlIIllIl;
        }
        if (llllllllllllllIlIIllIlIIIlIIlIII < llllllllllllllIlIIllIlIIIlIIlllI) {
            final int llllllllllllllIlIIllIlIIIlIIllII = llllllllllllllIlIIllIlIIIlIIlIII;
            llllllllllllllIlIIllIlIIIlIIlIII = llllllllllllllIlIIllIlIIIlIIlllI;
            llllllllllllllIlIIllIlIIIlIIlllI = llllllllllllllIlIIllIlIIIlIIllII;
        }
        final Tessellator llllllllllllllIlIIllIlIIIlIIlIll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIlIIllIlIIIlIIlIlI = llllllllllllllIlIIllIlIIIlIIlIll.getWorldRenderer();
    }
    
    public void writeText(final String llllllllllllllIlIIllIlIIllllllll) {
        String llllllllllllllIlIIllIlIlIIIIlIII = "";
        final String llllllllllllllIlIIllIlIlIIIIIlll = ChatAllowedCharacters.filterAllowedCharacters(llllllllllllllIlIIllIlIIllllllll);
        final int llllllllllllllIlIIllIlIlIIIIIllI = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllllIlIIllIlIlIIIIIlIl = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int llllllllllllllIlIIllIlIlIIIIIlII = this.maxStringLength - this.text.length() - (llllllllllllllIlIIllIlIlIIIIIllI - this.selectionEnd);
        final boolean llllllllllllllIlIIllIlIlIIIIIIll = false;
        if (this.text.length() > 0) {
            llllllllllllllIlIIllIlIlIIIIlIII = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlIIllIlIlIIIIlIII)))).append(this.text.substring(0, llllllllllllllIlIIllIlIlIIIIIllI)));
        }
        int llllllllllllllIlIIllIlIlIIIIIIIl = 0;
        if (llllllllllllllIlIIllIlIlIIIIIlII < llllllllllllllIlIIllIlIlIIIIIlll.length()) {
            llllllllllllllIlIIllIlIlIIIIlIII = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlIIllIlIlIIIIlIII)))).append(llllllllllllllIlIIllIlIlIIIIIlll.substring(0, llllllllllllllIlIIllIlIlIIIIIlII)));
            final int llllllllllllllIlIIllIlIlIIIIIIlI = llllllllllllllIlIIllIlIlIIIIIlII;
        }
        else {
            llllllllllllllIlIIllIlIlIIIIlIII = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlIIllIlIlIIIIlIII)))).append(llllllllllllllIlIIllIlIlIIIIIlll));
            llllllllllllllIlIIllIlIlIIIIIIIl = llllllllllllllIlIIllIlIlIIIIIlll.length();
        }
        if (this.text.length() > 0 && llllllllllllllIlIIllIlIlIIIIIlIl < this.text.length()) {
            llllllllllllllIlIIllIlIlIIIIlIII = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlIIllIlIlIIIIlIII)))).append(this.text.substring(llllllllllllllIlIIllIlIlIIIIIlIl)));
        }
        this.text = llllllllllllllIlIIllIlIlIIIIlIII.replaceAll(" ", "");
        this.cursorPos(llllllllllllllIlIIllIlIlIIIIIllI - this.selectionEnd + llllllllllllllIlIIllIlIlIIIIIIIl);
    }
    
    public void deleteFromCursor(final int llllllllllllllIlIIllIlIIlllIlIlI) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean llllllllllllllIlIIllIlIIlllIlIIl = llllllllllllllIlIIllIlIIlllIlIlI < 0;
                final int llllllllllllllIlIIllIlIIlllIlIII = llllllllllllllIlIIllIlIIlllIlIIl ? (this.cursorPosition + llllllllllllllIlIIllIlIIlllIlIlI) : this.cursorPosition;
                final int llllllllllllllIlIIllIlIIlllIIlll = llllllllllllllIlIIllIlIIlllIlIIl ? this.cursorPosition : (this.cursorPosition + llllllllllllllIlIIllIlIIlllIlIlI);
                String llllllllllllllIlIIllIlIIlllIIllI = "";
                if (llllllllllllllIlIIllIlIIlllIlIII >= 0) {
                    llllllllllllllIlIIllIlIIlllIIllI = this.text.substring(0, llllllllllllllIlIIllIlIIlllIlIII);
                }
                if (llllllllllllllIlIIllIlIIlllIIlll < this.text.length()) {
                    llllllllllllllIlIIllIlIIlllIIllI = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlIIllIlIIlllIIllI)))).append(this.text.substring(llllllllllllllIlIIllIlIIlllIIlll)));
                }
                this.text = llllllllllllllIlIIllIlIIlllIIllI;
                if (llllllllllllllIlIIllIlIIlllIlIIl) {
                    this.cursorPos(llllllllllllllIlIIllIlIIlllIlIlI);
                }
            }
        }
    }
    
    public void setText(final String llllllllllllllIlIIllIlIlIIlIIlIl) {
        if (llllllllllllllIlIIllIlIlIIlIIlIl.length() > this.maxStringLength) {
            this.text = llllllllllllllIlIIllIlIlIIlIIlIl.substring(0, this.maxStringLength);
        }
        else {
            this.text = llllllllllllllIlIIllIlIlIIlIIlIl;
        }
        this.setCursorPositionEnd();
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public PasswordField(final FontRenderer llllllllllllllIlIIllIlIlIIllIIII, final int llllllllllllllIlIIllIlIlIIllIlIl, final int llllllllllllllIlIIllIlIlIIllIlII, final int llllllllllllllIlIIllIlIlIIllIIll, final int llllllllllllllIlIIllIlIlIIllIIlI) {
        this.text = "";
        this.maxStringLength = 50;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isFocused = false;
        this.isEnabled = true;
        this.i = 0;
        this.cursorPosition = 0;
        this.selectionEnd = 0;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.b = true;
        this.fontRenderer = llllllllllllllIlIIllIlIlIIllIIII;
        this.xPos = llllllllllllllIlIIllIlIlIIllIlIl;
        this.yPos = llllllllllllllIlIIllIlIlIIllIlII;
        this.width = llllllllllllllIlIIllIlIlIIllIIll;
        this.height = llllllllllllllIlIIllIlIlIIllIIlI;
    }
    
    public String getSelectedtext() {
        final int llllllllllllllIlIIllIlIlIIIllIII = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllllIlIIllIlIlIIIlIlll = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(llllllllllllllIlIIllIlIlIIIllIII, llllllllllllllIlIIllIlIlIIIlIlll);
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public String getText() {
        final String llllllllllllllIlIIllIlIlIIIlllll = this.text.replaceAll(" ", "");
        return llllllllllllllIlIIllIlIlIIIlllll;
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public boolean textboxKeyTyped(final char llllllllllllllIlIIllIlIIlIIllllI, final int llllllllllllllIlIIllIlIIlIIllIlI) {
        if (!this.isEnabled || !this.isFocused) {
            return false;
        }
        switch (llllllllllllllIlIIllIlIIlIIllllI) {
            case '\u0001': {
                this.setCursorPositionEnd();
                this.func_73800_i(0);
                return true;
            }
            case '\u0003': {
                GuiScreen.setClipboardString(this.getSelectedtext());
                return true;
            }
            case '\u0016': {
                this.writeText(GuiScreen.getClipboardString());
                return true;
            }
            case '\u0018': {
                GuiScreen.setClipboardString(this.getSelectedtext());
                this.writeText("");
                return true;
            }
            default: {
                switch (llllllllllllllIlIIllIlIIlIIllIlI) {
                    case 14: {
                        if (GuiScreen.isCtrlKeyDown()) {
                            this.func_73779_a(-1);
                        }
                        else {
                            this.deleteFromCursor(-1);
                        }
                        return true;
                    }
                    case 199: {
                        if (GuiScreen.isShiftKeyDown()) {
                            this.func_73800_i(0);
                        }
                        else {
                            this.setCursorPositionZero();
                        }
                        return true;
                    }
                    case 203: {
                        if (GuiScreen.isShiftKeyDown()) {
                            if (GuiScreen.isCtrlKeyDown()) {
                                this.func_73800_i(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                            }
                            else {
                                this.func_73800_i(this.getSelectionEnd() - 1);
                            }
                        }
                        else if (GuiScreen.isCtrlKeyDown()) {
                            this.setCursorPosition(this.getNthWordFromCursor(-1));
                        }
                        else {
                            this.cursorPos(-1);
                        }
                        return true;
                    }
                    case 205: {
                        if (GuiScreen.isShiftKeyDown()) {
                            if (GuiScreen.isCtrlKeyDown()) {
                                this.func_73800_i(this.getNthWordFromPos(1, this.getSelectionEnd()));
                            }
                            else {
                                this.func_73800_i(this.getSelectionEnd() + 1);
                            }
                        }
                        else if (GuiScreen.isCtrlKeyDown()) {
                            this.setCursorPosition(this.getNthWordFromCursor(1));
                        }
                        else {
                            this.cursorPos(1);
                        }
                        return true;
                    }
                    case 207: {
                        if (GuiScreen.isShiftKeyDown()) {
                            this.func_73800_i(this.text.length());
                        }
                        else {
                            this.setCursorPositionEnd();
                        }
                        return true;
                    }
                    case 211: {
                        if (GuiScreen.isCtrlKeyDown()) {
                            this.func_73779_a(1);
                        }
                        else {
                            this.deleteFromCursor(1);
                        }
                        return true;
                    }
                    default: {
                        if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIlIIllIlIIlIIllllI)) {
                            this.writeText(Character.toString(llllllllllllllIlIIllIlIIlIIllllI));
                            return true;
                        }
                        return false;
                    }
                }
                break;
            }
        }
    }
    
    public void func_73790_e(final boolean llllllllllllllIlIIllIIlllllIIIII) {
        this.b = llllllllllllllIlIIllIIlllllIIIII;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public void func_73794_g(final int llllllllllllllIlIIllIlIIIIIIllll) {
        this.enabledColor = llllllllllllllIlIIllIlIIIIIIllll;
    }
    
    public int getNthWordFromPos(final int llllllllllllllIlIIllIlIIllIlIllI, final int llllllllllllllIlIIllIlIIllIlIlIl) {
        return this.type(llllllllllllllIlIIllIlIIllIlIllI, this.getCursorPosition(), true);
    }
    
    public void drawTextBox() {
        if (this.func_73778_q()) {
            if (this.getEnableBackgroundDrawing()) {
                Gui.drawRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
                Gui.drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
            }
            final int llllllllllllllIlIIllIlIIIlllIllI = this.isEnabled ? this.enabledColor : this.disabledColor;
            final int llllllllllllllIlIIllIlIIIlllIlIl = this.cursorPosition - this.i;
            int llllllllllllllIlIIllIlIIIlllIlII = this.selectionEnd - this.i;
            final String llllllllllllllIlIIllIlIIIlllIIll = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), this.getWidth());
            final boolean llllllllllllllIlIIllIlIIIlllIIlI = llllllllllllllIlIIllIlIIIlllIlIl >= 0 && llllllllllllllIlIIllIlIIIlllIlIl <= llllllllllllllIlIIllIlIIIlllIIll.length();
            final boolean llllllllllllllIlIIllIlIIIlllIIIl = this.isFocused && this.cursorCounter / 6 % 2 == 0 && llllllllllllllIlIIllIlIIIlllIIlI;
            final int llllllllllllllIlIIllIlIIIlllIIII = this.enableBackgroundDrawing ? (this.xPos + 4) : this.xPos;
            final int llllllllllllllIlIIllIlIIIllIllll = this.enableBackgroundDrawing ? (this.yPos + (this.height - 8) / 2) : this.yPos;
            int llllllllllllllIlIIllIlIIIllIlllI = llllllllllllllIlIIllIlIIIlllIIII;
            if (llllllllllllllIlIIllIlIIIlllIlII > llllllllllllllIlIIllIlIIIlllIIll.length()) {
                llllllllllllllIlIIllIlIIIlllIlII = llllllllllllllIlIIllIlIIIlllIIll.length();
            }
            if (llllllllllllllIlIIllIlIIIlllIIll.length() > 0) {
                if (llllllllllllllIlIIllIlIIIlllIIlI) {
                    llllllllllllllIlIIllIlIIIlllIIll.substring(0, llllllllllllllIlIIllIlIIIlllIlIl);
                }
                llllllllllllllIlIIllIlIIIllIlllI = Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), llllllllllllllIlIIllIlIIIlllIIII, llllllllllllllIlIIllIlIIIllIllll, llllllllllllllIlIIllIlIIIlllIllI);
            }
            final boolean llllllllllllllIlIIllIlIIIllIllIl = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int llllllllllllllIlIIllIlIIIllIllII = llllllllllllllIlIIllIlIIIllIlllI;
            if (!llllllllllllllIlIIllIlIIIlllIIlI) {
                llllllllllllllIlIIllIlIIIllIllII = ((llllllllllllllIlIIllIlIIIlllIlIl > 0) ? (llllllllllllllIlIIllIlIIIlllIIII + this.width) : llllllllllllllIlIIllIlIIIlllIIII);
            }
            else if (llllllllllllllIlIIllIlIIIllIllIl) {
                llllllllllllllIlIIllIlIIIllIllII = llllllllllllllIlIIllIlIIIllIlllI - 1;
                --llllllllllllllIlIIllIlIIIllIlllI;
            }
            if (llllllllllllllIlIIllIlIIIlllIIll.length() > 0 && llllllllllllllIlIIllIlIIIlllIIlI && llllllllllllllIlIIllIlIIIlllIlIl < llllllllllllllIlIIllIlIIIlllIIll.length()) {
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(llllllllllllllIlIIllIlIIIlllIIll.substring(llllllllllllllIlIIllIlIIIlllIlIl), llllllllllllllIlIIllIlIIIllIlllI, llllllllllllllIlIIllIlIIIllIllll, llllllllllllllIlIIllIlIIIlllIllI);
            }
            if (llllllllllllllIlIIllIlIIIlllIIIl) {
                if (llllllllllllllIlIIllIlIIIllIllIl) {
                    Gui.drawRect(llllllllllllllIlIIllIlIIIllIllII, llllllllllllllIlIIllIlIIIllIllll - 1, llllllllllllllIlIIllIlIIIllIllII + 1, llllllllllllllIlIIllIlIIIllIllll + 1 + this.fontRenderer.FONT_HEIGHT, -3092272);
                }
                else {
                    Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("_", llllllllllllllIlIIllIlIIIllIllII, llllllllllllllIlIIllIlIIIllIllll, llllllllllllllIlIIllIlIIIlllIllI);
                }
            }
            if (llllllllllllllIlIIllIlIIIlllIlII != llllllllllllllIlIIllIlIIIlllIlIl) {
                final int llllllllllllllIlIIllIlIIIllIlIll = llllllllllllllIlIIllIlIIIlllIIII + this.fontRenderer.getStringWidth(llllllllllllllIlIIllIlIIIlllIIll.substring(0, llllllllllllllIlIIllIlIIIlllIlII));
                this.drawCursorVertical(llllllllllllllIlIIllIlIIIllIllII, llllllllllllllIlIIllIlIIIllIllll - 1, llllllllllllllIlIIllIlIIIllIlIll - 1, llllllllllllllIlIIllIlIIIllIllll + 1 + this.fontRenderer.FONT_HEIGHT);
            }
        }
    }
    
    public void func_73800_i(int llllllllllllllIlIIllIIllllllIIIl) {
        final int llllllllllllllIlIIllIIllllllIllI = this.text.length();
        if (llllllllllllllIlIIllIIllllllIIIl > llllllllllllllIlIIllIIllllllIllI) {
            llllllllllllllIlIIllIIllllllIIIl = llllllllllllllIlIIllIIllllllIllI;
        }
        if (llllllllllllllIlIIllIIllllllIIIl < 0) {
            llllllllllllllIlIIllIIllllllIIIl = 0;
        }
        this.selectionEnd = llllllllllllllIlIIllIIllllllIIIl;
        if (this.fontRenderer != null) {
            if (this.i > llllllllllllllIlIIllIIllllllIllI) {
                this.i = llllllllllllllIlIIllIIllllllIllI;
            }
            final int llllllllllllllIlIIllIIllllllIlIl = this.getWidth();
            final String llllllllllllllIlIIllIIllllllIlII = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), llllllllllllllIlIIllIIllllllIlIl);
            final int llllllllllllllIlIIllIIllllllIIll = llllllllllllllIlIIllIIllllllIlII.length() + this.i;
            if (llllllllllllllIlIIllIIllllllIIIl == this.i) {
                this.i -= this.fontRenderer.trimStringToWidth(this.text, llllllllllllllIlIIllIIllllllIlIl, true).length();
            }
            if (llllllllllllllIlIIllIIllllllIIIl > llllllllllllllIlIIllIIllllllIIll) {
                this.i += llllllllllllllIlIIllIIllllllIIIl - llllllllllllllIlIIllIIllllllIIll;
            }
            else if (llllllllllllllIlIIllIIllllllIIIl <= this.i) {
                this.i -= this.i - llllllllllllllIlIIllIIllllllIIIl;
            }
            if (this.i < 0) {
                this.i = 0;
            }
            if (this.i > llllllllllllllIlIIllIIllllllIllI) {
                this.i = llllllllllllllIlIIllIIllllllIllI;
            }
        }
    }
    
    public void func_73779_a(final int llllllllllllllIlIIllIlIIllllIlII) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(llllllllllllllIlIIllIlIIllllIlII) - this.cursorPosition);
            }
        }
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public void mouseClicked(final int llllllllllllllIlIIllIlIIlIIIlIlI, final int llllllllllllllIlIIllIlIIlIIIlIIl, final int llllllllllllllIlIIllIlIIlIIIlIII) {
        final boolean llllllllllllllIlIIllIlIIlIIIlllI = llllllllllllllIlIIllIlIIlIIIlIlI >= this.xPos && llllllllllllllIlIIllIlIIlIIIlIlI < this.xPos + this.width && llllllllllllllIlIIllIlIIlIIIlIIl >= this.yPos && llllllllllllllIlIIllIlIIlIIIlIIl < this.yPos + this.height;
        if (this.canLoseFocus) {
            this.setFocused(this.isEnabled && llllllllllllllIlIIllIlIIlIIIlllI);
        }
        if (this.isFocused && llllllllllllllIlIIllIlIIlIIIlIII == 0) {
            int llllllllllllllIlIIllIlIIlIIIllIl = llllllllllllllIlIIllIlIIlIIIlIlI - this.xPos;
            if (this.enableBackgroundDrawing) {
                llllllllllllllIlIIllIlIIlIIIllIl -= 4;
            }
            final String llllllllllllllIlIIllIlIIlIIIllII = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), this.getWidth());
            this.setCursorPosition(this.fontRenderer.trimStringToWidth(llllllllllllllIlIIllIlIIlIIIllII, llllllllllllllIlIIllIlIIlIIIllIl).length() + this.i);
        }
    }
    
    public int type(final int llllllllllllllIlIIllIlIIllIIlIII, final int llllllllllllllIlIIllIlIIlIlllllI, final boolean llllllllllllllIlIIllIlIIllIIIllI) {
        int llllllllllllllIlIIllIlIIllIIIlIl = llllllllllllllIlIIllIlIIlIlllllI;
        final boolean llllllllllllllIlIIllIlIIllIIIlII = llllllllllllllIlIIllIlIIllIIlIII < 0;
        int llllllllllllllIlIIllIlIIllIIIIIl;
        Label_0143_Outer:Label_0164:
        for (int llllllllllllllIlIIllIlIIllIIIIll = Math.abs(llllllllllllllIlIIllIlIIllIIlIII), llllllllllllllIlIIllIlIIllIIIIlI = 0; llllllllllllllIlIIllIlIIllIIIIlI < llllllllllllllIlIIllIlIIllIIIIll; ++llllllllllllllIlIIllIlIIllIIIIlI) {
            if (llllllllllllllIlIIllIlIIllIIIlII) {
                while (true) {
                    while (llllllllllllllIlIIllIlIIllIIIllI) {
                        if (llllllllllllllIlIIllIlIIllIIIlIl > 0) {
                            if (this.text.charAt(llllllllllllllIlIIllIlIIllIIIlIl - 1) == ' ') {
                                --llllllllllllllIlIIllIlIIllIIIlIl;
                                continue Label_0143_Outer;
                            }
                        }
                        while (llllllllllllllIlIIllIlIIllIIIlIl > 0 && this.text.charAt(llllllllllllllIlIIllIlIIllIIIlIl - 1) != ' ') {
                            --llllllllllllllIlIIllIlIIllIIIlIl;
                        }
                        continue Label_0164;
                    }
                    continue;
                }
            }
            llllllllllllllIlIIllIlIIllIIIIIl = this.text.length();
            llllllllllllllIlIIllIlIIllIIIlIl = this.text.indexOf(32, llllllllllllllIlIIllIlIIllIIIlIl);
            if (llllllllllllllIlIIllIlIIllIIIlIl == -1) {
                llllllllllllllIlIIllIlIIllIIIlIl = llllllllllllllIlIIllIlIIllIIIIIl;
            }
            else {
                while (llllllllllllllIlIIllIlIIllIIIllI) {
                    if (llllllllllllllIlIIllIlIIllIIIlIl >= llllllllllllllIlIIllIlIIllIIIIIl) {
                        break;
                    }
                    if (this.text.charAt(llllllllllllllIlIIllIlIIllIIIlIl) != ' ') {
                        break;
                    }
                    ++llllllllllllllIlIIllIlIIllIIIlIl;
                }
            }
        }
        return llllllllllllllIlIIllIlIIllIIIlIl;
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public void setMaxStringLength(final int llllllllllllllIlIIllIlIIIIllllII) {
        this.maxStringLength = llllllllllllllIlIIllIlIIIIllllII;
        if (this.text.length() > llllllllllllllIlIIllIlIIIIllllII) {
            this.text = this.text.substring(0, llllllllllllllIlIIllIlIIIIllllII);
        }
    }
    
    public int getNthWordFromCursor(final int llllllllllllllIlIIllIlIIllIlllII) {
        return this.getNthWordFromPos(llllllllllllllIlIIllIlIIllIlllII, this.getCursorPosition());
    }
    
    public void setCursorPosition(final int llllllllllllllIlIIllIlIIlIlIlIlI) {
        this.cursorPosition = llllllllllllllIlIIllIlIIlIlIlIlI;
        final int llllllllllllllIlIIllIlIIlIlIllII = this.text.length();
        if (this.cursorPosition < 0) {
            this.cursorPosition = 0;
        }
        if (this.cursorPosition > llllllllllllllIlIIllIlIIlIlIllII) {
            this.cursorPosition = llllllllllllllIlIIllIlIIlIlIllII;
        }
        this.func_73800_i(this.cursorPosition);
    }
    
    public void setFocused(final boolean llllllllllllllIlIIllIlIIIIIIlIlI) {
        if (llllllllllllllIlIIllIlIIIIIIlIlI && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = llllllllllllllIlIIllIlIIIIIIlIlI;
    }
}
