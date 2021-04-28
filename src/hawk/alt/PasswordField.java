package hawk.alt;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class PasswordField extends Gui
{
    private final /* synthetic */ FontRenderer fontRenderer;
    private /* synthetic */ int disabledColor;
    private final /* synthetic */ int width;
    private /* synthetic */ int i;
    private /* synthetic */ boolean isEnabled;
    private /* synthetic */ int enabledColor;
    private /* synthetic */ String text;
    private /* synthetic */ int cursorPosition;
    public /* synthetic */ boolean isFocused;
    private /* synthetic */ boolean canLoseFocus;
    private final /* synthetic */ int xPos;
    private /* synthetic */ int maxStringLength;
    private final /* synthetic */ int yPos;
    private /* synthetic */ int selectionEnd;
    private /* synthetic */ boolean b;
    private /* synthetic */ int cursorCounter;
    private /* synthetic */ boolean enableBackgroundDrawing;
    private final /* synthetic */ int height;
    
    public void func_73790_e(final boolean llllllllllllllIlllIIlIIllIIllIIl) {
        this.b = llllllllllllllIlllIIlIIllIIllIIl;
    }
    
    public void setCanLoseFocus(final boolean llllllllllllllIlllIIlIIllIlIIIII) {
        this.canLoseFocus = llllllllllllllIlllIIlIIllIlIIIII;
    }
    
    public void func_73800_i(int llllllllllllllIlllIIlIIllIlIlIlI) {
        final int llllllllllllllIlllIIlIIllIlIllll = this.text.length();
        if (llllllllllllllIlllIIlIIllIlIlIlI > llllllllllllllIlllIIlIIllIlIllll) {
            llllllllllllllIlllIIlIIllIlIlIlI = llllllllllllllIlllIIlIIllIlIllll;
        }
        if (llllllllllllllIlllIIlIIllIlIlIlI < 0) {
            llllllllllllllIlllIIlIIllIlIlIlI = 0;
        }
        this.selectionEnd = llllllllllllllIlllIIlIIllIlIlIlI;
        if (this.fontRenderer != null) {
            if (this.i > llllllllllllllIlllIIlIIllIlIllll) {
                this.i = llllllllllllllIlllIIlIIllIlIllll;
            }
            final int llllllllllllllIlllIIlIIllIlIlllI = this.getWidth();
            final String llllllllllllllIlllIIlIIllIlIllIl = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), llllllllllllllIlllIIlIIllIlIlllI);
            final int llllllllllllllIlllIIlIIllIlIllII = llllllllllllllIlllIIlIIllIlIllIl.length() + this.i;
            if (llllllllllllllIlllIIlIIllIlIlIlI == this.i) {
                this.i -= this.fontRenderer.trimStringToWidth(this.text, llllllllllllllIlllIIlIIllIlIlllI, true).length();
            }
            if (llllllllllllllIlllIIlIIllIlIlIlI > llllllllllllllIlllIIlIIllIlIllII) {
                this.i += llllllllllllllIlllIIlIIllIlIlIlI - llllllllllllllIlllIIlIIllIlIllII;
            }
            else if (llllllllllllllIlllIIlIIllIlIlIlI <= this.i) {
                this.i -= this.i - llllllllllllllIlllIIlIIllIlIlIlI;
            }
            if (this.i < 0) {
                this.i = 0;
            }
            if (this.i > llllllllllllllIlllIIlIIllIlIllll) {
                this.i = llllllllllllllIlllIIlIIllIlIllll;
            }
        }
    }
    
    public void mouseClicked(final int llllllllllllllIlllIIlIlIIIIlllll, final int llllllllllllllIlllIIlIlIIIlIIlIl, final int llllllllllllllIlllIIlIlIIIlIIlII) {
        final boolean llllllllllllllIlllIIlIlIIIlIIIll = llllllllllllllIlllIIlIlIIIIlllll >= this.xPos && llllllllllllllIlllIIlIlIIIIlllll < this.xPos + this.width && llllllllllllllIlllIIlIlIIIlIIlIl >= this.yPos && llllllllllllllIlllIIlIlIIIlIIlIl < this.yPos + this.height;
        if (this.canLoseFocus) {
            this.setFocused(this.isEnabled && llllllllllllllIlllIIlIlIIIlIIIll);
        }
        if (this.isFocused && llllllllllllllIlllIIlIlIIIlIIlII == 0) {
            int llllllllllllllIlllIIlIlIIIlIIIlI = llllllllllllllIlllIIlIlIIIIlllll - this.xPos;
            if (this.enableBackgroundDrawing) {
                llllllllllllllIlllIIlIlIIIlIIIlI -= 4;
            }
            final String llllllllllllllIlllIIlIlIIIlIIIIl = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), this.getWidth());
            this.setCursorPosition(this.fontRenderer.trimStringToWidth(llllllllllllllIlllIIlIlIIIlIIIIl, llllllllllllllIlllIIlIlIIIlIIIlI).length() + this.i);
        }
    }
    
    public void writeText(final String llllllllllllllIlllIIlIlIlIIllllI) {
        String llllllllllllllIlllIIlIlIlIIlllIl = "";
        final String llllllllllllllIlllIIlIlIlIIlllII = ChatAllowedCharacters.filterAllowedCharacters(llllllllllllllIlllIIlIlIlIIllllI);
        final int llllllllllllllIlllIIlIlIlIIllIll = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllllIlllIIlIlIlIIllIlI = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int llllllllllllllIlllIIlIlIlIIllIIl = this.maxStringLength - this.text.length() - (llllllllllllllIlllIIlIlIlIIllIll - this.selectionEnd);
        final boolean llllllllllllllIlllIIlIlIlIIllIII = false;
        if (this.text.length() > 0) {
            llllllllllllllIlllIIlIlIlIIlllIl = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlllIIlIlIlIIlllIl)))).append(this.text.substring(0, llllllllllllllIlllIIlIlIlIIllIll)));
        }
        int llllllllllllllIlllIIlIlIlIIlIllI = 0;
        if (llllllllllllllIlllIIlIlIlIIllIIl < llllllllllllllIlllIIlIlIlIIlllII.length()) {
            llllllllllllllIlllIIlIlIlIIlllIl = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlllIIlIlIlIIlllIl)))).append(llllllllllllllIlllIIlIlIlIIlllII.substring(0, llllllllllllllIlllIIlIlIlIIllIIl)));
            final int llllllllllllllIlllIIlIlIlIIlIlll = llllllllllllllIlllIIlIlIlIIllIIl;
        }
        else {
            llllllllllllllIlllIIlIlIlIIlllIl = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlllIIlIlIlIIlllIl)))).append(llllllllllllllIlllIIlIlIlIIlllII));
            llllllllllllllIlllIIlIlIlIIlIllI = llllllllllllllIlllIIlIlIlIIlllII.length();
        }
        if (this.text.length() > 0 && llllllllllllllIlllIIlIlIlIIllIlI < this.text.length()) {
            llllllllllllllIlllIIlIlIlIIlllIl = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlllIIlIlIlIIlllIl)))).append(this.text.substring(llllllllllllllIlllIIlIlIlIIllIlI)));
        }
        this.text = llllllllllllllIlllIIlIlIlIIlllIl.replaceAll(" ", "");
        this.cursorPos(llllllllllllllIlllIIlIlIlIIllIll - this.selectionEnd + llllllllllllllIlllIIlIlIlIIlIllI);
    }
    
    public void setText(final String llllllllllllllIlllIIlIlIlIlllIlI) {
        if (llllllllllllllIlllIIlIlIlIlllIlI.length() > this.maxStringLength) {
            this.text = llllllllllllllIlllIIlIlIlIlllIlI.substring(0, this.maxStringLength);
        }
        else {
            this.text = llllllllllllllIlllIIlIlIlIlllIlI;
        }
        this.setCursorPositionEnd();
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public void setEnableBackgroundDrawing(final boolean llllllllllllllIlllIIlIIlllIIllIl) {
        this.enableBackgroundDrawing = llllllllllllllIlllIIlIIlllIIllIl;
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public boolean func_73778_q() {
        return this.b;
    }
    
    public void func_73779_a(final int llllllllllllllIlllIIlIlIlIIIlIIl) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(llllllllllllllIlllIIlIlIlIIIlIIl) - this.cursorPosition);
            }
        }
    }
    
    public void deleteFromCursor(final int llllllllllllllIlllIIlIlIIllllIIl) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean llllllllllllllIlllIIlIlIIllllllI = llllllllllllllIlllIIlIlIIllllIIl < 0;
                final int llllllllllllllIlllIIlIlIIlllllIl = llllllllllllllIlllIIlIlIIllllllI ? (this.cursorPosition + llllllllllllllIlllIIlIlIIllllIIl) : this.cursorPosition;
                final int llllllllllllllIlllIIlIlIIlllllII = llllllllllllllIlllIIlIlIIllllllI ? this.cursorPosition : (this.cursorPosition + llllllllllllllIlllIIlIlIIllllIIl);
                String llllllllllllllIlllIIlIlIIllllIll = "";
                if (llllllllllllllIlllIIlIlIIlllllIl >= 0) {
                    llllllllllllllIlllIIlIlIIllllIll = this.text.substring(0, llllllllllllllIlllIIlIlIIlllllIl);
                }
                if (llllllllllllllIlllIIlIlIIlllllII < this.text.length()) {
                    llllllllllllllIlllIIlIlIIllllIll = String.valueOf(new StringBuilder(String.valueOf(String.valueOf(String.valueOf(llllllllllllllIlllIIlIlIIllllIll)))).append(this.text.substring(llllllllllllllIlllIIlIlIIlllllII)));
                }
                this.text = llllllllllllllIlllIIlIlIIllllIll;
                if (llllllllllllllIlllIIlIlIIllllllI) {
                    this.cursorPos(llllllllllllllIlllIIlIlIIllllIIl);
                }
            }
        }
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public String getText() {
        final String llllllllllllllIlllIIlIlIlIllIlII = this.text.replaceAll(" ", "");
        return llllllllllllllIlllIIlIlIlIllIlII;
    }
    
    public int getNthWordFromCursor(final int llllllllllllllIlllIIlIlIIllIllll) {
        return this.getNthWordFromPos(llllllllllllllIlllIIlIlIIllIllll, this.getCursorPosition());
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public void drawTextBox() {
        if (this.func_73778_q()) {
            if (this.getEnableBackgroundDrawing()) {
                Gui.drawRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
                Gui.drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
            }
            final int llllllllllllllIlllIIlIlIIIIIlIll = this.isEnabled ? this.enabledColor : this.disabledColor;
            final int llllllllllllllIlllIIlIlIIIIIlIlI = this.cursorPosition - this.i;
            int llllllllllllllIlllIIlIlIIIIIlIIl = this.selectionEnd - this.i;
            final String llllllllllllllIlllIIlIlIIIIIlIII = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), this.getWidth());
            final boolean llllllllllllllIlllIIlIlIIIIIIlll = llllllllllllllIlllIIlIlIIIIIlIlI >= 0 && llllllllllllllIlllIIlIlIIIIIlIlI <= llllllllllllllIlllIIlIlIIIIIlIII.length();
            final boolean llllllllllllllIlllIIlIlIIIIIIllI = this.isFocused && this.cursorCounter / 6 % 2 == 0 && llllllllllllllIlllIIlIlIIIIIIlll;
            final int llllllllllllllIlllIIlIlIIIIIIlIl = this.enableBackgroundDrawing ? (this.xPos + 4) : this.xPos;
            final int llllllllllllllIlllIIlIlIIIIIIlII = this.enableBackgroundDrawing ? (this.yPos + (this.height - 8) / 2) : this.yPos;
            int llllllllllllllIlllIIlIlIIIIIIIll = llllllllllllllIlllIIlIlIIIIIIlIl;
            if (llllllllllllllIlllIIlIlIIIIIlIIl > llllllllllllllIlllIIlIlIIIIIlIII.length()) {
                llllllllllllllIlllIIlIlIIIIIlIIl = llllllllllllllIlllIIlIlIIIIIlIII.length();
            }
            if (llllllllllllllIlllIIlIlIIIIIlIII.length() > 0) {
                if (llllllllllllllIlllIIlIlIIIIIIlll) {
                    llllllllllllllIlllIIlIlIIIIIlIII.substring(0, llllllllllllllIlllIIlIlIIIIIlIlI);
                }
                llllllllllllllIlllIIlIlIIIIIIIll = Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), llllllllllllllIlllIIlIlIIIIIIlIl, llllllllllllllIlllIIlIlIIIIIIlII, llllllllllllllIlllIIlIlIIIIIlIll);
            }
            final boolean llllllllllllllIlllIIlIlIIIIIIIlI = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int llllllllllllllIlllIIlIlIIIIIIIIl = llllllllllllllIlllIIlIlIIIIIIIll;
            if (!llllllllllllllIlllIIlIlIIIIIIlll) {
                llllllllllllllIlllIIlIlIIIIIIIIl = ((llllllllllllllIlllIIlIlIIIIIlIlI > 0) ? (llllllllllllllIlllIIlIlIIIIIIlIl + this.width) : llllllllllllllIlllIIlIlIIIIIIlIl);
            }
            else if (llllllllllllllIlllIIlIlIIIIIIIlI) {
                llllllllllllllIlllIIlIlIIIIIIIIl = llllllllllllllIlllIIlIlIIIIIIIll - 1;
                --llllllllllllllIlllIIlIlIIIIIIIll;
            }
            if (llllllllllllllIlllIIlIlIIIIIlIII.length() > 0 && llllllllllllllIlllIIlIlIIIIIIlll && llllllllllllllIlllIIlIlIIIIIlIlI < llllllllllllllIlllIIlIlIIIIIlIII.length()) {
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(llllllllllllllIlllIIlIlIIIIIlIII.substring(llllllllllllllIlllIIlIlIIIIIlIlI), llllllllllllllIlllIIlIlIIIIIIIll, llllllllllllllIlllIIlIlIIIIIIlII, llllllllllllllIlllIIlIlIIIIIlIll);
            }
            if (llllllllllllllIlllIIlIlIIIIIIllI) {
                if (llllllllllllllIlllIIlIlIIIIIIIlI) {
                    Gui.drawRect(llllllllllllllIlllIIlIlIIIIIIIIl, llllllllllllllIlllIIlIlIIIIIIlII - 1, llllllllllllllIlllIIlIlIIIIIIIIl + 1, llllllllllllllIlllIIlIlIIIIIIlII + 1 + this.fontRenderer.FONT_HEIGHT, -3092272);
                }
                else {
                    Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("_", llllllllllllllIlllIIlIlIIIIIIIIl, llllllllllllllIlllIIlIlIIIIIIlII, llllllllllllllIlllIIlIlIIIIIlIll);
                }
            }
            if (llllllllllllllIlllIIlIlIIIIIlIIl != llllllllllllllIlllIIlIlIIIIIlIlI) {
                final int llllllllllllllIlllIIlIlIIIIIIIII = llllllllllllllIlllIIlIlIIIIIIlIl + this.fontRenderer.getStringWidth(llllllllllllllIlllIIlIlIIIIIlIII.substring(0, llllllllllllllIlllIIlIlIIIIIlIIl));
                this.drawCursorVertical(llllllllllllllIlllIIlIlIIIIIIIIl, llllllllllllllIlllIIlIlIIIIIIlII - 1, llllllllllllllIlllIIlIlIIIIIIIII - 1, llllllllllllllIlllIIlIlIIIIIIlII + 1 + this.fontRenderer.FONT_HEIGHT);
            }
        }
    }
    
    public boolean textboxKeyTyped(final char llllllllllllllIlllIIlIlIIIllIIII, final int llllllllllllllIlllIIlIlIIIllIIlI) {
        if (!this.isEnabled || !this.isFocused) {
            return false;
        }
        switch (llllllllllllllIlllIIlIlIIIllIIII) {
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
                switch (llllllllllllllIlllIIlIlIIIllIIlI) {
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
                        if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIlllIIlIlIIIllIIII)) {
                            this.writeText(Character.toString(llllllllllllllIlllIIlIlIIIllIIII));
                            return true;
                        }
                        return false;
                    }
                }
                break;
            }
        }
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public void setCursorPosition(final int llllllllllllllIlllIIlIlIIlIIIIlI) {
        this.cursorPosition = llllllllllllllIlllIIlIlIIlIIIIlI;
        final int llllllllllllllIlllIIlIlIIlIIIIIl = this.text.length();
        if (this.cursorPosition < 0) {
            this.cursorPosition = 0;
        }
        if (this.cursorPosition > llllllllllllllIlllIIlIlIIlIIIIIl) {
            this.cursorPosition = llllllllllllllIlllIIlIlIIlIIIIIl;
        }
        this.func_73800_i(this.cursorPosition);
    }
    
    public void setFocused(final boolean llllllllllllllIlllIIlIIlllIIIIll) {
        if (llllllllllllllIlllIIlIIlllIIIIll && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = llllllllllllllIlllIIlIIlllIIIIll;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public PasswordField(final FontRenderer llllllllllllllIlllIIlIlIllIIIlIl, final int llllllllllllllIlllIIlIlIllIIlIlI, final int llllllllllllllIlllIIlIlIllIIlIIl, final int llllllllllllllIlllIIlIlIllIIIIlI, final int llllllllllllllIlllIIlIlIllIIIIIl) {
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
        this.fontRenderer = llllllllllllllIlllIIlIlIllIIIlIl;
        this.xPos = llllllllllllllIlllIIlIlIllIIlIlI;
        this.yPos = llllllllllllllIlllIIlIlIllIIlIIl;
        this.width = llllllllllllllIlllIIlIlIllIIIIlI;
        this.height = llllllllllllllIlllIIlIlIllIIIIIl;
    }
    
    public String getSelectedtext() {
        final int llllllllllllllIlllIIlIlIlIlIllIl = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllllIlllIIlIlIlIlIllII = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(llllllllllllllIlllIIlIlIlIlIllIl, llllllllllllllIlllIIlIlIlIlIllII);
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    private void drawCursorVertical(int llllllllllllllIlllIIlIIllllIllII, int llllllllllllllIlllIIlIIllllIlIll, int llllllllllllllIlllIIlIIllllIIlII, int llllllllllllllIlllIIlIIllllIlIIl) {
        if (llllllllllllllIlllIIlIIllllIllII < llllllllllllllIlllIIlIIllllIIlII) {
            final int llllllllllllllIlllIIlIIllllIlIII = llllllllllllllIlllIIlIIllllIllII;
            llllllllllllllIlllIIlIIllllIllII = llllllllllllllIlllIIlIIllllIIlII;
            llllllllllllllIlllIIlIIllllIIlII = llllllllllllllIlllIIlIIllllIlIII;
        }
        if (llllllllllllllIlllIIlIIllllIlIll < llllllllllllllIlllIIlIIllllIlIIl) {
            final int llllllllllllllIlllIIlIIllllIIlll = llllllllllllllIlllIIlIIllllIlIll;
            llllllllllllllIlllIIlIIllllIlIll = llllllllllllllIlllIIlIIllllIlIIl;
            llllllllllllllIlllIIlIIllllIlIIl = llllllllllllllIlllIIlIIllllIIlll;
        }
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public int type(final int llllllllllllllIlllIIlIlIIlIlIlII, final int llllllllllllllIlllIIlIlIIlIlllII, final boolean llllllllllllllIlllIIlIlIIlIllIll) {
        int llllllllllllllIlllIIlIlIIlIllIlI = llllllllllllllIlllIIlIlIIlIlllII;
        final boolean llllllllllllllIlllIIlIlIIlIllIIl = llllllllllllllIlllIIlIlIIlIlIlII < 0;
        int llllllllllllllIlllIIlIlIIlIlIllI;
        Label_0143_Outer:Label_0164:
        for (int llllllllllllllIlllIIlIlIIlIllIII = Math.abs(llllllllllllllIlllIIlIlIIlIlIlII), llllllllllllllIlllIIlIlIIlIlIlll = 0; llllllllllllllIlllIIlIlIIlIlIlll < llllllllllllllIlllIIlIlIIlIllIII; ++llllllllllllllIlllIIlIlIIlIlIlll) {
            if (llllllllllllllIlllIIlIlIIlIllIIl) {
                while (true) {
                    while (llllllllllllllIlllIIlIlIIlIllIll) {
                        if (llllllllllllllIlllIIlIlIIlIllIlI > 0) {
                            if (this.text.charAt(llllllllllllllIlllIIlIlIIlIllIlI - 1) == ' ') {
                                --llllllllllllllIlllIIlIlIIlIllIlI;
                                continue Label_0143_Outer;
                            }
                        }
                        while (llllllllllllllIlllIIlIlIIlIllIlI > 0 && this.text.charAt(llllllllllllllIlllIIlIlIIlIllIlI - 1) != ' ') {
                            --llllllllllllllIlllIIlIlIIlIllIlI;
                        }
                        continue Label_0164;
                    }
                    continue;
                }
            }
            llllllllllllllIlllIIlIlIIlIlIllI = this.text.length();
            llllllllllllllIlllIIlIlIIlIllIlI = this.text.indexOf(32, llllllllllllllIlllIIlIlIIlIllIlI);
            if (llllllllllllllIlllIIlIlIIlIllIlI == -1) {
                llllllllllllllIlllIIlIlIIlIllIlI = llllllllllllllIlllIIlIlIIlIlIllI;
            }
            else {
                while (llllllllllllllIlllIIlIlIIlIllIll) {
                    if (llllllllllllllIlllIIlIlIIlIllIlI >= llllllllllllllIlllIIlIlIIlIlIllI) {
                        break;
                    }
                    if (this.text.charAt(llllllllllllllIlllIIlIlIIlIllIlI) != ' ') {
                        break;
                    }
                    ++llllllllllllllIlllIIlIlIIlIllIlI;
                }
            }
        }
        return llllllllllllllIlllIIlIlIIlIllIlI;
    }
    
    public void cursorPos(final int llllllllllllllIlllIIlIlIIlIIIlll) {
        this.setCursorPosition(this.selectionEnd + llllllllllllllIlllIIlIlIIlIIIlll);
    }
    
    public int getNthWordFromPos(final int llllllllllllllIlllIIlIlIIllIlIll, final int llllllllllllllIlllIIlIlIIllIlIlI) {
        return this.type(llllllllllllllIlllIIlIlIIllIlIll, this.getCursorPosition(), true);
    }
    
    public void func_73794_g(final int llllllllllllllIlllIIlIIlllIIlIIl) {
        this.enabledColor = llllllllllllllIlllIIlIIlllIIlIIl;
    }
    
    public void setMaxStringLength(final int llllllllllllllIlllIIlIIlllIllllI) {
        this.maxStringLength = llllllllllllllIlllIIlIIlllIllllI;
        if (this.text.length() > llllllllllllllIlllIIlIIlllIllllI) {
            this.text = this.text.substring(0, llllllllllllllIlllIIlIIlllIllllI);
        }
    }
}
