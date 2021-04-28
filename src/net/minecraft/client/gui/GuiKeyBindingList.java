package net.minecraft.client.gui;

import net.minecraft.client.*;
import org.apache.commons.lang3.*;
import java.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.settings.*;
import net.minecraft.util.*;

public class GuiKeyBindingList extends GuiListExtended
{
    private final /* synthetic */ GuiControls field_148191_k;
    private /* synthetic */ int maxListLabelWidth;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ IGuiListEntry[] listEntries;
    
    static {
        __OBFID = "CL_00000732";
    }
    
    @Override
    protected int getSize() {
        return this.listEntries.length;
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 15;
    }
    
    @Override
    public int getListWidth() {
        return super.getListWidth() + 32;
    }
    
    @Override
    public IGuiListEntry getListEntry(final int lllllllllllllllIlIIllIlllIllIllI) {
        return this.listEntries[lllllllllllllllIlIIllIlllIllIllI];
    }
    
    public GuiKeyBindingList(final GuiControls lllllllllllllllIlIIllIllllIIIlll, final Minecraft lllllllllllllllIlIIllIllllIlIIlI) {
        super(lllllllllllllllIlIIllIllllIlIIlI, lllllllllllllllIlIIllIllllIIIlll.width, lllllllllllllllIlIIllIllllIIIlll.height, 63, lllllllllllllllIlIIllIllllIIIlll.height - 32, 20);
        this.maxListLabelWidth = 0;
        this.field_148191_k = lllllllllllllllIlIIllIllllIIIlll;
        this.mc = lllllllllllllllIlIIllIllllIlIIlI;
        final KeyBinding[] lllllllllllllllIlIIllIllllIlIIIl = (KeyBinding[])ArrayUtils.clone((Object[])lllllllllllllllIlIIllIllllIlIIlI.gameSettings.keyBindings);
        this.listEntries = new IGuiListEntry[lllllllllllllllIlIIllIllllIlIIIl.length + KeyBinding.getKeybinds().size()];
        Arrays.sort(lllllllllllllllIlIIllIllllIlIIIl);
        int lllllllllllllllIlIIllIllllIlIIII = 0;
        String lllllllllllllllIlIIllIllllIIllll = null;
        final KeyBinding[] lllllllllllllllIlIIllIllllIIlllI = lllllllllllllllIlIIllIllllIlIIIl;
        for (int lllllllllllllllIlIIllIllllIIllIl = lllllllllllllllIlIIllIllllIlIIIl.length, lllllllllllllllIlIIllIllllIIllII = 0; lllllllllllllllIlIIllIllllIIllII < lllllllllllllllIlIIllIllllIIllIl; ++lllllllllllllllIlIIllIllllIIllII) {
            final KeyBinding lllllllllllllllIlIIllIllllIIlIll = lllllllllllllllIlIIllIllllIIlllI[lllllllllllllllIlIIllIllllIIllII];
            final String lllllllllllllllIlIIllIllllIIlIlI = lllllllllllllllIlIIllIllllIIlIll.getKeyCategory();
            if (!lllllllllllllllIlIIllIllllIIlIlI.equals(lllllllllllllllIlIIllIllllIIllll)) {
                lllllllllllllllIlIIllIllllIIllll = lllllllllllllllIlIIllIllllIIlIlI;
                this.listEntries[lllllllllllllllIlIIllIllllIlIIII++] = new CategoryEntry(lllllllllllllllIlIIllIllllIIlIlI);
            }
            final int lllllllllllllllIlIIllIllllIIlIIl = lllllllllllllllIlIIllIllllIlIIlI.fontRendererObj.getStringWidth(I18n.format(lllllllllllllllIlIIllIllllIIlIll.getKeyDescription(), new Object[0]));
            if (lllllllllllllllIlIIllIllllIIlIIl > this.maxListLabelWidth) {
                this.maxListLabelWidth = lllllllllllllllIlIIllIllllIIlIIl;
            }
            this.listEntries[lllllllllllllllIlIIllIllllIlIIII++] = new KeyEntry(lllllllllllllllIlIIllIllllIIlIll, null);
        }
    }
    
    public class CategoryEntry implements IGuiListEntry
    {
        private final /* synthetic */ int labelWidth;
        private final /* synthetic */ String labelText;
        
        public CategoryEntry(final String lllllllllllllllIlllIlllIlIIlIlIl) {
            this.labelText = I18n.format(lllllllllllllllIlllIlllIlIIlIlIl, new Object[0]);
            this.labelWidth = GuiKeyBindingList.this.mc.fontRendererObj.getStringWidth(this.labelText);
        }
        
        static {
            __OBFID = "CL_00000734";
        }
        
        @Override
        public boolean mousePressed(final int lllllllllllllllIlllIlllIlIIIIlII, final int lllllllllllllllIlllIlllIlIIIIIll, final int lllllllllllllllIlllIlllIlIIIIIlI, final int lllllllllllllllIlllIlllIlIIIIIIl, final int lllllllllllllllIlllIlllIlIIIIIII, final int lllllllllllllllIlllIlllIIlllllll) {
            return false;
        }
        
        @Override
        public void setSelected(final int lllllllllllllllIlllIlllIIlllIllI, final int lllllllllllllllIlllIlllIIlllIlIl, final int lllllllllllllllIlllIlllIIlllIlII) {
        }
        
        @Override
        public void mouseReleased(final int lllllllllllllllIlllIlllIIlllllIl, final int lllllllllllllllIlllIlllIIlllllII, final int lllllllllllllllIlllIlllIIllllIll, final int lllllllllllllllIlllIlllIIllllIlI, final int lllllllllllllllIlllIlllIIllllIIl, final int lllllllllllllllIlllIlllIIllllIII) {
        }
        
        @Override
        public void drawEntry(final int lllllllllllllllIlllIlllIlIIlIIII, final int lllllllllllllllIlllIlllIlIIIllll, final int lllllllllllllllIlllIlllIlIIIlllI, final int lllllllllllllllIlllIlllIlIIIllIl, final int lllllllllllllllIlllIlllIlIIIllII, final int lllllllllllllllIlllIlllIlIIIlIll, final int lllllllllllllllIlllIlllIlIIIlIlI, final boolean lllllllllllllllIlllIlllIlIIIlIIl) {
            GuiKeyBindingList.this.mc.fontRendererObj.drawString(this.labelText, GuiKeyBindingList.this.mc.currentScreen.width / 2 - this.labelWidth / 2, lllllllllllllllIlllIlllIlIIIlllI + lllllllllllllllIlllIlllIlIIIllII - GuiKeyBindingList.this.mc.fontRendererObj.FONT_HEIGHT - 1, 16777215);
        }
    }
    
    public class KeyEntry implements IGuiListEntry
    {
        private final /* synthetic */ GuiButton btnChangeKeyBinding;
        private final /* synthetic */ String field_148283_c;
        private final /* synthetic */ GuiButton btnReset;
        private final /* synthetic */ KeyBinding field_148282_b;
        
        private KeyEntry(final KeyBinding lllllllllllllllIIIIIIIllIIlIlIll) {
            this.field_148282_b = lllllllllllllllIIIIIIIllIIlIlIll;
            this.field_148283_c = I18n.format(lllllllllllllllIIIIIIIllIIlIlIll.getKeyDescription(), new Object[0]);
            this.btnChangeKeyBinding = new GuiButton(0, 0, 0, 75, 18, I18n.format(lllllllllllllllIIIIIIIllIIlIlIll.getKeyDescription(), new Object[0]));
            this.btnReset = new GuiButton(0, 0, 0, 50, 18, I18n.format("controls.reset", new Object[0]));
        }
        
        @Override
        public void setSelected(final int lllllllllllllllIIIIIIIlIlllIlIII, final int lllllllllllllllIIIIIIIlIlllIIlll, final int lllllllllllllllIIIIIIIlIlllIIllI) {
        }
        
        @Override
        public boolean mousePressed(final int lllllllllllllllIIIIIIIlIllllllll, final int lllllllllllllllIIIIIIIlIlllllIII, final int lllllllllllllllIIIIIIIlIllllIlll, final int lllllllllllllllIIIIIIIlIllllllII, final int lllllllllllllllIIIIIIIlIlllllIll, final int lllllllllllllllIIIIIIIlIlllllIlI) {
            if (this.btnChangeKeyBinding.mousePressed(GuiKeyBindingList.this.mc, lllllllllllllllIIIIIIIlIlllllIII, lllllllllllllllIIIIIIIlIllllIlll)) {
                GuiKeyBindingList.this.field_148191_k.buttonId = this.field_148282_b;
                return true;
            }
            if (this.btnReset.mousePressed(GuiKeyBindingList.this.mc, lllllllllllllllIIIIIIIlIlllllIII, lllllllllllllllIIIIIIIlIllllIlll)) {
                GuiKeyBindingList.this.mc.gameSettings.setOptionKeyBinding(this.field_148282_b, this.field_148282_b.getKeyCodeDefault());
                KeyBinding.resetKeyBindingArrayAndHash();
                return true;
            }
            return false;
        }
        
        @Override
        public void mouseReleased(final int lllllllllllllllIIIIIIIlIllllIIlI, final int lllllllllllllllIIIIIIIlIlllIlIll, final int lllllllllllllllIIIIIIIlIlllIlIlI, final int lllllllllllllllIIIIIIIlIlllIllll, final int lllllllllllllllIIIIIIIlIlllIlllI, final int lllllllllllllllIIIIIIIlIlllIllIl) {
            this.btnChangeKeyBinding.mouseReleased(lllllllllllllllIIIIIIIlIlllIlIll, lllllllllllllllIIIIIIIlIlllIlIlI);
            this.btnReset.mouseReleased(lllllllllllllllIIIIIIIlIlllIlIll, lllllllllllllllIIIIIIIlIlllIlIlI);
        }
        
        @Override
        public void drawEntry(final int lllllllllllllllIIIIIIIllIIIlllIl, final int lllllllllllllllIIIIIIIllIIIlllII, final int lllllllllllllllIIIIIIIllIIIllIll, final int lllllllllllllllIIIIIIIllIIIllIlI, final int lllllllllllllllIIIIIIIllIIIIllII, final int lllllllllllllllIIIIIIIllIIIIlIll, final int lllllllllllllllIIIIIIIllIIIIlIlI, final boolean lllllllllllllllIIIIIIIllIIIlIllI) {
            final boolean lllllllllllllllIIIIIIIllIIIlIlIl = GuiKeyBindingList.this.field_148191_k.buttonId == this.field_148282_b;
            GuiKeyBindingList.this.mc.fontRendererObj.drawString(this.field_148283_c, lllllllllllllllIIIIIIIllIIIlllII + 90 - GuiKeyBindingList.this.maxListLabelWidth, lllllllllllllllIIIIIIIllIIIllIll + lllllllllllllllIIIIIIIllIIIIllII / 2 - GuiKeyBindingList.this.mc.fontRendererObj.FONT_HEIGHT / 2, 16777215);
            this.btnReset.xPosition = lllllllllllllllIIIIIIIllIIIlllII + 190;
            this.btnReset.yPosition = lllllllllllllllIIIIIIIllIIIllIll;
            this.btnReset.enabled = (this.field_148282_b.getKeyCode() != this.field_148282_b.getKeyCodeDefault());
            this.btnReset.drawButton(GuiKeyBindingList.this.mc, lllllllllllllllIIIIIIIllIIIIlIll, lllllllllllllllIIIIIIIllIIIIlIlI);
            this.btnChangeKeyBinding.xPosition = lllllllllllllllIIIIIIIllIIIlllII + 105;
            this.btnChangeKeyBinding.yPosition = lllllllllllllllIIIIIIIllIIIllIll;
            this.btnChangeKeyBinding.displayString = GameSettings.getKeyDisplayString(this.field_148282_b.getKeyCode());
            boolean lllllllllllllllIIIIIIIllIIIlIlII = false;
            if (this.field_148282_b.getKeyCode() != 0) {
                for (final KeyBinding lllllllllllllllIIIIIIIllIIIlIIII : GuiKeyBindingList.this.mc.gameSettings.keyBindings) {
                    if (lllllllllllllllIIIIIIIllIIIlIIII != this.field_148282_b && lllllllllllllllIIIIIIIllIIIlIIII.getKeyCode() == this.field_148282_b.getKeyCode()) {
                        lllllllllllllllIIIIIIIllIIIlIlII = true;
                        break;
                    }
                }
            }
            if (lllllllllllllllIIIIIIIllIIIlIlIl) {
                this.btnChangeKeyBinding.displayString = String.valueOf(new StringBuilder().append(EnumChatFormatting.WHITE).append("> ").append(EnumChatFormatting.YELLOW).append(this.btnChangeKeyBinding.displayString).append(EnumChatFormatting.WHITE).append(" <"));
            }
            else if (lllllllllllllllIIIIIIIllIIIlIlII) {
                this.btnChangeKeyBinding.displayString = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append(this.btnChangeKeyBinding.displayString));
            }
            this.btnChangeKeyBinding.drawButton(GuiKeyBindingList.this.mc, lllllllllllllllIIIIIIIllIIIIlIll, lllllllllllllllIIIIIIIllIIIIlIlI);
        }
        
        static {
            __OBFID = "CL_00000735";
        }
        
        KeyEntry(final GuiKeyBindingList lllllllllllllllIIIIIIIlIllIllllI, final KeyBinding lllllllllllllllIIIIIIIlIlllIIIIl, final Object lllllllllllllllIIIIIIIlIlllIIIII) {
            this(lllllllllllllllIIIIIIIlIllIllllI, lllllllllllllllIIIIIIIlIlllIIIIl);
        }
    }
}
