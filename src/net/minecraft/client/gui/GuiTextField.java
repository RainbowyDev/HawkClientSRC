package net.minecraft.client.gui;

import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class GuiTextField extends Gui
{
    public /* synthetic */ int xPosition;
    private /* synthetic */ int selectionEnd;
    private /* synthetic */ boolean enableBackgroundDrawing;
    private /* synthetic */ int enabledColor;
    private /* synthetic */ boolean isFocused;
    private /* synthetic */ boolean canLoseFocus;
    private /* synthetic */ boolean isEnabled;
    private /* synthetic */ int lineScrollOffset;
    private final /* synthetic */ FontRenderer fontRendererInstance;
    private /* synthetic */ GuiPageButtonList.GuiResponder field_175210_x;
    private /* synthetic */ int disabledColor;
    private /* synthetic */ int maxStringLength;
    public /* synthetic */ int yPosition;
    private /* synthetic */ Predicate field_175209_y;
    private final /* synthetic */ int width;
    private final /* synthetic */ int field_175208_g;
    private /* synthetic */ int cursorCounter;
    private /* synthetic */ String text;
    private final /* synthetic */ int height;
    private /* synthetic */ int cursorPosition;
    private /* synthetic */ boolean visible;
    
    public void setSelectionPos(int llllllllllllllIIlIIllIIlllIlIlIl) {
        final int llllllllllllllIIlIIllIIlllIllIlI = this.text.length();
        if (llllllllllllllIIlIIllIIlllIlIlIl > llllllllllllllIIlIIllIIlllIllIlI) {
            llllllllllllllIIlIIllIIlllIlIlIl = llllllllllllllIIlIIllIIlllIllIlI;
        }
        if (llllllllllllllIIlIIllIIlllIlIlIl < 0) {
            llllllllllllllIIlIIllIIlllIlIlIl = 0;
        }
        this.selectionEnd = llllllllllllllIIlIIllIIlllIlIlIl;
        if (this.fontRendererInstance != null) {
            if (this.lineScrollOffset > llllllllllllllIIlIIllIIlllIllIlI) {
                this.lineScrollOffset = llllllllllllllIIlIIllIIlllIllIlI;
            }
            final int llllllllllllllIIlIIllIIlllIllIIl = this.getWidth();
            final String llllllllllllllIIlIIllIIlllIllIII = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), llllllllllllllIIlIIllIIlllIllIIl);
            final int llllllllllllllIIlIIllIIlllIlIlll = llllllllllllllIIlIIllIIlllIllIII.length() + this.lineScrollOffset;
            if (llllllllllllllIIlIIllIIlllIlIlIl == this.lineScrollOffset) {
                this.lineScrollOffset -= this.fontRendererInstance.trimStringToWidth(this.text, llllllllllllllIIlIIllIIlllIllIIl, true).length();
            }
            if (llllllllllllllIIlIIllIIlllIlIlIl > llllllllllllllIIlIIllIIlllIlIlll) {
                this.lineScrollOffset += llllllllllllllIIlIIllIIlllIlIlIl - llllllllllllllIIlIIllIIlllIlIlll;
            }
            else if (llllllllllllllIIlIIllIIlllIlIlIl <= this.lineScrollOffset) {
                this.lineScrollOffset -= this.lineScrollOffset - llllllllllllllIIlIIllIIlllIlIlIl;
            }
            this.lineScrollOffset = MathHelper.clamp_int(this.lineScrollOffset, 0, llllllllllllllIIlIIllIIlllIllIlI);
        }
    }
    
    public void drawTextBox() {
        if (this.getVisible()) {
            if (this.getEnableBackgroundDrawing()) {
                Gui.drawRect(this.xPosition - 1, this.yPosition - 1, this.xPosition + this.width + 1, this.yPosition + this.height + 1, -6250336);
                Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, -16777216);
            }
            final int llllllllllllllIIlIIllIlIIlIIlIll = this.isEnabled ? this.enabledColor : this.disabledColor;
            final int llllllllllllllIIlIIllIlIIlIIlIlI = this.cursorPosition - this.lineScrollOffset;
            int llllllllllllllIIlIIllIlIIlIIlIIl = this.selectionEnd - this.lineScrollOffset;
            final String llllllllllllllIIlIIllIlIIlIIlIII = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            final boolean llllllllllllllIIlIIllIlIIlIIIlll = llllllllllllllIIlIIllIlIIlIIlIlI >= 0 && llllllllllllllIIlIIllIlIIlIIlIlI <= llllllllllllllIIlIIllIlIIlIIlIII.length();
            final boolean llllllllllllllIIlIIllIlIIlIIIllI = this.isFocused && this.cursorCounter / 6 % 2 == 0 && llllllllllllllIIlIIllIlIIlIIIlll;
            final int llllllllllllllIIlIIllIlIIlIIIlIl = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
            final int llllllllllllllIIlIIllIlIIlIIIlII = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
            int llllllllllllllIIlIIllIlIIlIIIIll = llllllllllllllIIlIIllIlIIlIIIlIl;
            if (llllllllllllllIIlIIllIlIIlIIlIIl > llllllllllllllIIlIIllIlIIlIIlIII.length()) {
                llllllllllllllIIlIIllIlIIlIIlIIl = llllllllllllllIIlIIllIlIIlIIlIII.length();
            }
            if (llllllllllllllIIlIIllIlIIlIIlIII.length() > 0) {
                final String llllllllllllllIIlIIllIlIIlIIIIlI = llllllllllllllIIlIIllIlIIlIIIlll ? llllllllllllllIIlIIllIlIIlIIlIII.substring(0, llllllllllllllIIlIIllIlIIlIIlIlI) : llllllllllllllIIlIIllIlIIlIIlIII;
                llllllllllllllIIlIIllIlIIlIIIIll = this.fontRendererInstance.drawStringWithShadow(llllllllllllllIIlIIllIlIIlIIIIlI, (float)llllllllllllllIIlIIllIlIIlIIIlIl, (float)llllllllllllllIIlIIllIlIIlIIIlII, llllllllllllllIIlIIllIlIIlIIlIll);
            }
            final boolean llllllllllllllIIlIIllIlIIlIIIIIl = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int llllllllllllllIIlIIllIlIIlIIIIII = llllllllllllllIIlIIllIlIIlIIIIll;
            if (!llllllllllllllIIlIIllIlIIlIIIlll) {
                llllllllllllllIIlIIllIlIIlIIIIII = ((llllllllllllllIIlIIllIlIIlIIlIlI > 0) ? (llllllllllllllIIlIIllIlIIlIIIlIl + this.width) : llllllllllllllIIlIIllIlIIlIIIlIl);
            }
            else if (llllllllllllllIIlIIllIlIIlIIIIIl) {
                llllllllllllllIIlIIllIlIIlIIIIII = llllllllllllllIIlIIllIlIIlIIIIll - 1;
                --llllllllllllllIIlIIllIlIIlIIIIll;
            }
            if (llllllllllllllIIlIIllIlIIlIIlIII.length() > 0 && llllllllllllllIIlIIllIlIIlIIIlll && llllllllllllllIIlIIllIlIIlIIlIlI < llllllllllllllIIlIIllIlIIlIIlIII.length()) {
                llllllllllllllIIlIIllIlIIlIIIIll = this.fontRendererInstance.drawStringWithShadow(llllllllllllllIIlIIllIlIIlIIlIII.substring(llllllllllllllIIlIIllIlIIlIIlIlI), (float)llllllllllllllIIlIIllIlIIlIIIIll, (float)llllllllllllllIIlIIllIlIIlIIIlII, llllllllllllllIIlIIllIlIIlIIlIll);
            }
            if (llllllllllllllIIlIIllIlIIlIIIllI) {
                if (llllllllllllllIIlIIllIlIIlIIIIIl) {
                    Gui.drawRect(llllllllllllllIIlIIllIlIIlIIIIII, llllllllllllllIIlIIllIlIIlIIIlII - 1, llllllllllllllIIlIIllIlIIlIIIIII + 1, llllllllllllllIIlIIllIlIIlIIIlII + 1 + this.fontRendererInstance.FONT_HEIGHT, -3092272);
                }
                else {
                    this.fontRendererInstance.drawStringWithShadow("_", (float)llllllllllllllIIlIIllIlIIlIIIIII, (float)llllllllllllllIIlIIllIlIIlIIIlII, llllllllllllllIIlIIllIlIIlIIlIll);
                }
            }
            if (llllllllllllllIIlIIllIlIIlIIlIIl != llllllllllllllIIlIIllIlIIlIIlIlI) {
                final int llllllllllllllIIlIIllIlIIIllllll = llllllllllllllIIlIIllIlIIlIIIlIl + this.fontRendererInstance.getStringWidth(llllllllllllllIIlIIllIlIIlIIlIII.substring(0, llllllllllllllIIlIIllIlIIlIIlIIl));
                this.drawCursorVertical(llllllllllllllIIlIIllIlIIlIIIIII, llllllllllllllIIlIIllIlIIlIIIlII - 1, llllllllllllllIIlIIllIlIIIllllll - 1, llllllllllllllIIlIIllIlIIlIIIlII + 1 + this.fontRendererInstance.FONT_HEIGHT);
            }
        }
    }
    
    public void func_175205_a(final Predicate llllllllllllllIIlIIllIlIllllIIII) {
        this.field_175209_y = llllllllllllllIIlIIllIlIllllIIII;
    }
    
    public void mouseClicked(final int llllllllllllllIIlIIllIlIIlIlllll, final int llllllllllllllIIlIIllIlIIlIllllI, final int llllllllllllllIIlIIllIlIIllIIlII) {
        final boolean llllllllllllllIIlIIllIlIIllIIIll = llllllllllllllIIlIIllIlIIlIlllll >= this.xPosition && llllllllllllllIIlIIllIlIIlIlllll < this.xPosition + this.width && llllllllllllllIIlIIllIlIIlIllllI >= this.yPosition && llllllllllllllIIlIIllIlIIlIllllI < this.yPosition + this.height;
        if (this.canLoseFocus) {
            this.setFocused(llllllllllllllIIlIIllIlIIllIIIll);
        }
        if (this.isFocused && llllllllllllllIIlIIllIlIIllIIIll && llllllllllllllIIlIIllIlIIllIIlII == 0) {
            int llllllllllllllIIlIIllIlIIllIIIlI = llllllllllllllIIlIIllIlIIlIlllll - this.xPosition;
            if (this.enableBackgroundDrawing) {
                llllllllllllllIIlIIllIlIIllIIIlI -= 4;
            }
            final String llllllllllllllIIlIIllIlIIllIIIIl = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            this.setCursorPosition(this.fontRendererInstance.trimStringToWidth(llllllllllllllIIlIIllIlIIllIIIIl, llllllllllllllIIlIIllIlIIllIIIlI).length() + this.lineScrollOffset);
        }
    }
    
    public void setTextColor(final int llllllllllllllIIlIIllIlIIIIIIIII) {
        this.enabledColor = llllllllllllllIIlIIllIlIIIIIIIII;
    }
    
    public void setCanLoseFocus(final boolean llllllllllllllIIlIIllIIlllIIllIl) {
        this.canLoseFocus = llllllllllllllIIlIIllIIlllIIllIl;
    }
    
    public void setCursorPosition(final int llllllllllllllIIlIIllIlIIlllllll) {
        this.cursorPosition = llllllllllllllIIlIIllIlIIlllllll;
        final int llllllllllllllIIlIIllIlIlIIIIIIl = this.text.length();
        this.cursorPosition = MathHelper.clamp_int(this.cursorPosition, 0, llllllllllllllIIlIIllIlIlIIIIIIl);
        this.setSelectionPos(this.cursorPosition);
    }
    
    public int func_175206_d() {
        return this.field_175208_g;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public void setDisabledTextColour(final int llllllllllllllIIlIIllIIllllllIII) {
        this.disabledColor = llllllllllllllIIlIIllIIllllllIII;
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public String getSelectedText() {
        final int llllllllllllllIIlIIllIlIlllllIII = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllllIIlIIllIlIllllIlll = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(llllllllllllllIIlIIllIlIlllllIII, llllllllllllllIIlIIllIlIllllIlll);
    }
    
    public boolean getVisible() {
        return this.visible;
    }
    
    public GuiTextField(final int llllllllllllllIIlIIllIllIIIlIlII, final FontRenderer llllllllllllllIIlIIllIllIIIllIlI, final int llllllllllllllIIlIIllIllIIIlIIlI, final int llllllllllllllIIlIIllIllIIIlIIIl, final int llllllllllllllIIlIIllIllIIIlIlll, final int llllllllllllllIIlIIllIllIIIlIllI) {
        this.text = "";
        this.maxStringLength = 32;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isEnabled = true;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.visible = true;
        this.field_175209_y = Predicates.alwaysTrue();
        this.field_175208_g = llllllllllllllIIlIIllIllIIIlIlII;
        this.fontRendererInstance = llllllllllllllIIlIIllIllIIIllIlI;
        this.xPosition = llllllllllllllIIlIIllIllIIIlIIlI;
        this.yPosition = llllllllllllllIIlIIllIllIIIlIIIl;
        this.width = llllllllllllllIIlIIllIllIIIlIlll;
        this.height = llllllllllllllIIlIIllIllIIIlIllI;
    }
    
    public void deleteFromCursor(final int llllllllllllllIIlIIllIlIlIlllllI) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean llllllllllllllIIlIIllIlIllIIIIll = llllllllllllllIIlIIllIlIlIlllllI < 0;
                final int llllllllllllllIIlIIllIlIllIIIIlI = llllllllllllllIIlIIllIlIllIIIIll ? (this.cursorPosition + llllllllllllllIIlIIllIlIlIlllllI) : this.cursorPosition;
                final int llllllllllllllIIlIIllIlIllIIIIIl = llllllllllllllIIlIIllIlIllIIIIll ? this.cursorPosition : (this.cursorPosition + llllllllllllllIIlIIllIlIlIlllllI);
                String llllllllllllllIIlIIllIlIllIIIIII = "";
                if (llllllllllllllIIlIIllIlIllIIIIlI >= 0) {
                    llllllllllllllIIlIIllIlIllIIIIII = this.text.substring(0, llllllllllllllIIlIIllIlIllIIIIlI);
                }
                if (llllllllllllllIIlIIllIlIllIIIIIl < this.text.length()) {
                    llllllllllllllIIlIIllIlIllIIIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIllIlIllIIIIII)).append(this.text.substring(llllllllllllllIIlIIllIlIllIIIIIl)));
                }
                this.text = llllllllllllllIIlIIllIlIllIIIIII;
                if (llllllllllllllIIlIIllIlIllIIIIll) {
                    this.moveCursorBy(llllllllllllllIIlIIllIlIlIlllllI);
                }
                if (this.field_175210_x != null) {
                    this.field_175210_x.func_175319_a(this.field_175208_g, this.text);
                }
            }
        }
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public boolean textboxKeyTyped(final char llllllllllllllIIlIIllIlIIlllIIII, final int llllllllllllllIIlIIllIlIIlllIIlI) {
        if (!this.isFocused) {
            return false;
        }
        if (GuiScreen.func_175278_g(llllllllllllllIIlIIllIlIIlllIIlI)) {
            this.setCursorPositionEnd();
            this.setSelectionPos(0);
            return true;
        }
        if (GuiScreen.func_175280_f(llllllllllllllIIlIIllIlIIlllIIlI)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            return true;
        }
        if (GuiScreen.func_175279_e(llllllllllllllIIlIIllIlIIlllIIlI)) {
            if (this.isEnabled) {
                this.writeText(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.func_175277_d(llllllllllllllIIlIIllIlIIlllIIlI)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            if (this.isEnabled) {
                this.writeText("");
            }
            return true;
        }
        switch (llllllllllllllIIlIIllIlIIlllIIlI) {
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.isEnabled) {
                        this.deleteWords(-1);
                    }
                }
                else if (this.isEnabled) {
                    this.deleteFromCursor(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.setSelectionPos(0);
                }
                else {
                    this.setCursorPositionZero();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.setSelectionPos(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                    }
                    else {
                        this.setSelectionPos(this.getSelectionEnd() - 1);
                    }
                }
                else if (GuiScreen.isCtrlKeyDown()) {
                    this.setCursorPosition(this.getNthWordFromCursor(-1));
                }
                else {
                    this.moveCursorBy(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.setSelectionPos(this.getNthWordFromPos(1, this.getSelectionEnd()));
                    }
                    else {
                        this.setSelectionPos(this.getSelectionEnd() + 1);
                    }
                }
                else if (GuiScreen.isCtrlKeyDown()) {
                    this.setCursorPosition(this.getNthWordFromCursor(1));
                }
                else {
                    this.moveCursorBy(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.setSelectionPos(this.text.length());
                }
                else {
                    this.setCursorPositionEnd();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.isEnabled) {
                        this.deleteWords(1);
                    }
                }
                else if (this.isEnabled) {
                    this.deleteFromCursor(1);
                }
                return true;
            }
            default: {
                if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIIlIIllIlIIlllIIII)) {
                    if (this.isEnabled) {
                        this.writeText(Character.toString(llllllllllllllIIlIIllIlIIlllIIII));
                    }
                    return true;
                }
                return false;
            }
        }
    }
    
    public void moveCursorBy(final int llllllllllllllIIlIIllIlIlIIIlIIl) {
        this.setCursorPosition(this.selectionEnd + llllllllllllllIIlIIllIlIlIIIlIIl);
    }
    
    public int func_146197_a(final int llllllllllllllIIlIIllIlIlIIlllIl, final int llllllllllllllIIlIIllIlIlIIlIIll, final boolean llllllllllllllIIlIIllIlIlIIlIIlI) {
        int llllllllllllllIIlIIllIlIlIIllIlI = llllllllllllllIIlIIllIlIlIIlIIll;
        final boolean llllllllllllllIIlIIllIlIlIIllIIl = llllllllllllllIIlIIllIlIlIIlllIl < 0;
        for (int llllllllllllllIIlIIllIlIlIIllIII = Math.abs(llllllllllllllIIlIIllIlIlIIlllIl), llllllllllllllIIlIIllIlIlIIlIlll = 0; llllllllllllllIIlIIllIlIlIIlIlll < llllllllllllllIIlIIllIlIlIIllIII; ++llllllllllllllIIlIIllIlIlIIlIlll) {
            if (llllllllllllllIIlIIllIlIlIIllIIl) {
                while (llllllllllllllIIlIIllIlIlIIlIIlI && llllllllllllllIIlIIllIlIlIIllIlI > 0) {
                    if (this.text.charAt(llllllllllllllIIlIIllIlIlIIllIlI - 1) != ' ') {
                        break;
                    }
                    --llllllllllllllIIlIIllIlIlIIllIlI;
                }
                while (llllllllllllllIIlIIllIlIlIIllIlI > 0) {
                    if (this.text.charAt(llllllllllllllIIlIIllIlIlIIllIlI - 1) == ' ') {
                        break;
                    }
                    --llllllllllllllIIlIIllIlIlIIllIlI;
                }
            }
            else {
                final int llllllllllllllIIlIIllIlIlIIlIllI = this.text.length();
                llllllllllllllIIlIIllIlIlIIllIlI = this.text.indexOf(32, llllllllllllllIIlIIllIlIlIIllIlI);
                if (llllllllllllllIIlIIllIlIlIIllIlI == -1) {
                    llllllllllllllIIlIIllIlIlIIllIlI = llllllllllllllIIlIIllIlIlIIlIllI;
                }
                else {
                    while (llllllllllllllIIlIIllIlIlIIlIIlI && llllllllllllllIIlIIllIlIlIIllIlI < llllllllllllllIIlIIllIlIlIIlIllI && this.text.charAt(llllllllllllllIIlIIllIlIlIIllIlI) == ' ') {
                        ++llllllllllllllIIlIIllIlIlIIllIlI;
                    }
                }
            }
        }
        return llllllllllllllIIlIIllIlIlIIllIlI;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void writeText(final String llllllllllllllIIlIIllIlIlllIIIll) {
        String llllllllllllllIIlIIllIlIlllIIIlI = "";
        final String llllllllllllllIIlIIllIlIlllIIIIl = ChatAllowedCharacters.filterAllowedCharacters(llllllllllllllIIlIIllIlIlllIIIll);
        final int llllllllllllllIIlIIllIlIlllIIIII = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllllIIlIIllIlIllIlllll = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int llllllllllllllIIlIIllIlIllIllllI = this.maxStringLength - this.text.length() - (llllllllllllllIIlIIllIlIlllIIIII - llllllllllllllIIlIIllIlIllIlllll);
        final boolean llllllllllllllIIlIIllIlIllIlllIl = false;
        if (this.text.length() > 0) {
            llllllllllllllIIlIIllIlIlllIIIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIllIlIlllIIIlI)).append(this.text.substring(0, llllllllllllllIIlIIllIlIlllIIIII)));
        }
        int llllllllllllllIIlIIllIlIllIllIll = 0;
        if (llllllllllllllIIlIIllIlIllIllllI < llllllllllllllIIlIIllIlIlllIIIIl.length()) {
            llllllllllllllIIlIIllIlIlllIIIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIllIlIlllIIIlI)).append(llllllllllllllIIlIIllIlIlllIIIIl.substring(0, llllllllllllllIIlIIllIlIllIllllI)));
            final int llllllllllllllIIlIIllIlIllIlllII = llllllllllllllIIlIIllIlIllIllllI;
        }
        else {
            llllllllllllllIIlIIllIlIlllIIIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIllIlIlllIIIlI)).append(llllllllllllllIIlIIllIlIlllIIIIl));
            llllllllllllllIIlIIllIlIllIllIll = llllllllllllllIIlIIllIlIlllIIIIl.length();
        }
        if (this.text.length() > 0 && llllllllllllllIIlIIllIlIllIlllll < this.text.length()) {
            llllllllllllllIIlIIllIlIlllIIIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIllIlIlllIIIlI)).append(this.text.substring(llllllllllllllIIlIIllIlIllIlllll)));
        }
        if (this.field_175209_y.apply((Object)llllllllllllllIIlIIllIlIlllIIIlI)) {
            this.text = llllllllllllllIIlIIllIlIlllIIIlI;
            this.moveCursorBy(llllllllllllllIIlIIllIlIlllIIIII - this.selectionEnd + llllllllllllllIIlIIllIlIllIllIll);
            if (this.field_175210_x != null) {
                this.field_175210_x.func_175319_a(this.field_175208_g, this.text);
            }
        }
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public void setMaxStringLength(final int llllllllllllllIIlIIllIlIIIIlIIll) {
        this.maxStringLength = llllllllllllllIIlIIllIlIIIIlIIll;
        if (this.text.length() > llllllllllllllIIlIIllIlIIIIlIIll) {
            this.text = this.text.substring(0, llllllllllllllIIlIIllIlIIIIlIIll);
        }
    }
    
    public void setText(final String llllllllllllllIIlIIllIllIIIIIIII) {
        if (this.field_175209_y.apply((Object)llllllllllllllIIlIIllIllIIIIIIII)) {
            if (llllllllllllllIIlIIllIllIIIIIIII.length() > this.maxStringLength) {
                this.text = llllllllllllllIIlIIllIllIIIIIIII.substring(0, this.maxStringLength);
            }
            else {
                this.text = llllllllllllllIIlIIllIllIIIIIIII;
            }
            this.setCursorPositionEnd();
        }
    }
    
    public void func_175207_a(final GuiPageButtonList.GuiResponder llllllllllllllIIlIIllIllIIIIlIIl) {
        this.field_175210_x = llllllllllllllIIlIIllIllIIIIlIIl;
    }
    
    public int getNthWordFromCursor(final int llllllllllllllIIlIIllIlIlIllIIIl) {
        return this.getNthWordFromPos(llllllllllllllIIlIIllIlIlIllIIIl, this.getCursorPosition());
    }
    
    public void setVisible(final boolean llllllllllllllIIlIIllIIlllIIIlII) {
        this.visible = llllllllllllllIIlIIllIIlllIIIlII;
    }
    
    static {
        __OBFID = "CL_00000670";
    }
    
    private void drawCursorVertical(int llllllllllllllIIlIIllIlIIIIlllll, int llllllllllllllIIlIIllIlIIIIllllI, int llllllllllllllIIlIIllIlIIIIlllIl, int llllllllllllllIIlIIllIlIIIIlllII) {
        if (llllllllllllllIIlIIllIlIIIIlllll < llllllllllllllIIlIIllIlIIIIlllIl) {
            final int llllllllllllllIIlIIllIlIIIlIIlII = (int)llllllllllllllIIlIIllIlIIIIlllll;
            llllllllllllllIIlIIllIlIIIIlllll = llllllllllllllIIlIIllIlIIIIlllIl;
            llllllllllllllIIlIIllIlIIIIlllIl = llllllllllllllIIlIIllIlIIIlIIlII;
        }
        if (llllllllllllllIIlIIllIlIIIIllllI < llllllllllllllIIlIIllIlIIIIlllII) {
            final int llllllllllllllIIlIIllIlIIIlIIIll = llllllllllllllIIlIIllIlIIIIllllI;
            llllllllllllllIIlIIllIlIIIIllllI = llllllllllllllIIlIIllIlIIIIlllII;
            llllllllllllllIIlIIllIlIIIIlllII = llllllllllllllIIlIIllIlIIIlIIIll;
        }
        if (llllllllllllllIIlIIllIlIIIIlllIl > this.xPosition + this.width) {
            llllllllllllllIIlIIllIlIIIIlllIl = this.xPosition + this.width;
        }
        if (llllllllllllllIIlIIllIlIIIIlllll > this.xPosition + this.width) {
            llllllllllllllIIlIIllIlIIIIlllll = this.xPosition + this.width;
        }
        final Tessellator llllllllllllllIIlIIllIlIIIlIIIlI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIlIIllIlIIIlIIIIl = llllllllllllllIIlIIllIlIIIlIIIlI.getWorldRenderer();
        GlStateManager.color(0.0f, 0.0f, 255.0f, 255.0f);
        GlStateManager.func_179090_x();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp(5387);
        llllllllllllllIIlIIllIlIIIlIIIIl.startDrawingQuads();
        llllllllllllllIIlIIllIlIIIlIIIIl.addVertex(llllllllllllllIIlIIllIlIIIIlllll, llllllllllllllIIlIIllIlIIIIlllII, 0.0);
        llllllllllllllIIlIIllIlIIIlIIIIl.addVertex(llllllllllllllIIlIIllIlIIIIlllIl, llllllllllllllIIlIIllIlIIIIlllII, 0.0);
        llllllllllllllIIlIIllIlIIIlIIIIl.addVertex(llllllllllllllIIlIIllIlIIIIlllIl, llllllllllllllIIlIIllIlIIIIllllI, 0.0);
        llllllllllllllIIlIIllIlIIIlIIIIl.addVertex(llllllllllllllIIlIIllIlIIIIlllll, llllllllllllllIIlIIllIlIIIIllllI, 0.0);
        llllllllllllllIIlIIllIlIIIlIIIlI.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.func_179098_w();
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public void setFocused(final boolean llllllllllllllIIlIIllIIlllllIlII) {
        if (llllllllllllllIIlIIllIIlllllIlII && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = llllllllllllllIIlIIllIIlllllIlII;
    }
    
    public void setEnableBackgroundDrawing(final boolean llllllllllllllIIlIIllIlIIIIIIllI) {
        this.enableBackgroundDrawing = llllllllllllllIIlIIllIlIIIIIIllI;
    }
    
    public void deleteWords(final int llllllllllllllIIlIIllIlIllIIlllI) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(llllllllllllllIIlIIllIlIllIIlllI) - this.cursorPosition);
            }
        }
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public void setEnabled(final boolean llllllllllllllIIlIIllIIllllIlIll) {
        this.isEnabled = llllllllllllllIIlIIllIIllllIlIll;
    }
    
    public int getNthWordFromPos(final int llllllllllllllIIlIIllIlIlIlIllII, final int llllllllllllllIIlIIllIlIlIlIlIll) {
        return this.func_146197_a(llllllllllllllIIlIIllIlIlIlIllII, llllllllllllllIIlIIllIlIlIlIlIll, true);
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
}
