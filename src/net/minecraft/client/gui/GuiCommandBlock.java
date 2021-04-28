package net.minecraft.client.gui;

import net.minecraft.command.server.*;
import net.minecraft.client.resources.*;
import java.io.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import org.lwjgl.input.*;
import java.util.*;

public class GuiCommandBlock extends GuiScreen
{
    private /* synthetic */ GuiTextField commandTextField;
    private /* synthetic */ GuiButton field_175390_s;
    private /* synthetic */ GuiButton doneBtn;
    private /* synthetic */ boolean field_175389_t;
    private final /* synthetic */ CommandBlockLogic localCommandBlock;
    private /* synthetic */ GuiTextField field_146486_g;
    private /* synthetic */ GuiButton cancelBtn;
    
    @Override
    public void drawScreen(final int llllllllllllllllIIlIIllIlIIlIIII, final int llllllllllllllllIIlIIllIlIIIllll, final float llllllllllllllllIIlIIllIlIIIlllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("advMode.setCommand", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("advMode.command", new Object[0]), this.width / 2 - 150, 37, 10526880);
        this.commandTextField.drawTextBox();
        final byte llllllllllllllllIIlIIllIlIIllIII = 75;
        final byte llllllllllllllllIIlIIllIlIIlIlll = 0;
        final FontRenderer llllllllllllllllIIlIIllIlIIlIllI = this.fontRendererObj;
        final String llllllllllllllllIIlIIllIlIIlIlIl = I18n.format("advMode.nearestPlayer", new Object[0]);
        final int llllllllllllllllIIlIIllIlIIlIlII = this.width / 2 - 150;
        int llllllllllllllllIIlIIllIlIIlIIll = llllllllllllllllIIlIIllIlIIlIlll + 1;
        this.drawString(llllllllllllllllIIlIIllIlIIlIllI, llllllllllllllllIIlIIllIlIIlIlIl, llllllllllllllllIIlIIllIlIIlIlII, llllllllllllllllIIlIIllIlIIllIII + llllllllllllllllIIlIIllIlIIlIlll * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.randomPlayer", new Object[0]), this.width / 2 - 150, llllllllllllllllIIlIIllIlIIllIII + llllllllllllllllIIlIIllIlIIlIIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allPlayers", new Object[0]), this.width / 2 - 150, llllllllllllllllIIlIIllIlIIllIII + llllllllllllllllIIlIIllIlIIlIIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allEntities", new Object[0]), this.width / 2 - 150, llllllllllllllllIIlIIllIlIIllIII + llllllllllllllllIIlIIllIlIIlIIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, "", this.width / 2 - 150, llllllllllllllllIIlIIllIlIIllIII + llllllllllllllllIIlIIllIlIIlIIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        if (this.field_146486_g.getText().length() > 0) {
            final int llllllllllllllllIIlIIllIlIIlIIlI = llllllllllllllllIIlIIllIlIIllIII + llllllllllllllllIIlIIllIlIIlIIll * this.fontRendererObj.FONT_HEIGHT + 16;
            this.drawString(this.fontRendererObj, I18n.format("advMode.previousOutput", new Object[0]), this.width / 2 - 150, llllllllllllllllIIlIIllIlIIlIIlI, 10526880);
            this.field_146486_g.drawTextBox();
        }
        super.drawScreen(llllllllllllllllIIlIIllIlIIlIIII, llllllllllllllllIIlIIllIlIIIllll, llllllllllllllllIIlIIllIlIIIlllI);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllllIIlIIllIlIllIlIl, final int llllllllllllllllIIlIIllIlIllIlll) throws IOException {
        this.commandTextField.textboxKeyTyped(llllllllllllllllIIlIIllIlIllIlIl, llllllllllllllllIIlIIllIlIllIlll);
        this.field_146486_g.textboxKeyTyped(llllllllllllllllIIlIIllIlIllIlIl, llllllllllllllllIIlIIllIlIllIlll);
        this.doneBtn.enabled = (this.commandTextField.getText().trim().length() > 0);
        if (llllllllllllllllIIlIIllIlIllIlll != 28 && llllllllllllllllIIlIIllIlIllIlll != 156) {
            if (llllllllllllllllIIlIIllIlIllIlll == 1) {
                this.actionPerformed(this.cancelBtn);
            }
        }
        else {
            this.actionPerformed(this.doneBtn);
        }
    }
    
    public GuiCommandBlock(final CommandBlockLogic llllllllllllllllIIlIIllIllIIllIl) {
        this.localCommandBlock = llllllllllllllllIIlIIllIllIIllIl;
    }
    
    private void func_175388_a() {
        if (this.localCommandBlock.func_175571_m()) {
            this.field_175390_s.displayString = "O";
            if (this.localCommandBlock.getLastOutput() != null) {
                this.field_146486_g.setText(this.localCommandBlock.getLastOutput().getUnformattedText());
            }
        }
        else {
            this.field_175390_s.displayString = "X";
            this.field_146486_g.setText("-");
        }
    }
    
    @Override
    public void updateScreen() {
        this.commandTextField.updateCursorCounter();
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIIlIIllIllIIIIIl) throws IOException {
        if (llllllllllllllllIIlIIllIllIIIIIl.enabled) {
            if (llllllllllllllllIIlIIllIllIIIIIl.id == 1) {
                this.localCommandBlock.func_175573_a(this.field_175389_t);
                this.mc.displayGuiScreen(null);
            }
            else if (llllllllllllllllIIlIIllIllIIIIIl.id == 0) {
                final PacketBuffer llllllllllllllllIIlIIllIllIIIIII = new PacketBuffer(Unpooled.buffer());
                llllllllllllllllIIlIIllIllIIIIII.writeByte(this.localCommandBlock.func_145751_f());
                this.localCommandBlock.func_145757_a(llllllllllllllllIIlIIllIllIIIIII);
                llllllllllllllllIIlIIllIllIIIIII.writeString(this.commandTextField.getText());
                llllllllllllllllIIlIIllIllIIIIII.writeBoolean(this.localCommandBlock.func_175571_m());
                this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload("MC|AdvCdm", llllllllllllllllIIlIIllIllIIIIII));
                if (!this.localCommandBlock.func_175571_m()) {
                    this.localCommandBlock.func_145750_b(null);
                }
                this.mc.displayGuiScreen(null);
            }
            else if (llllllllllllllllIIlIIllIllIIIIIl.id == 4) {
                this.localCommandBlock.func_175573_a(!this.localCommandBlock.func_175571_m());
                this.func_175388_a();
            }
        }
    }
    
    static {
        __OBFID = "CL_00000748";
        field_146488_a = LogManager.getLogger();
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        final List buttonList = this.buttonList;
        final GuiButton doneBtn = new GuiButton(0, this.width / 2 - 4 - 150, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.done", new Object[0]));
        this.doneBtn = doneBtn;
        buttonList.add(doneBtn);
        final List buttonList2 = this.buttonList;
        final GuiButton cancelBtn = new GuiButton(1, this.width / 2 + 4, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.cancel", new Object[0]));
        this.cancelBtn = cancelBtn;
        buttonList2.add(cancelBtn);
        final List buttonList3 = this.buttonList;
        final GuiButton field_175390_s = new GuiButton(4, this.width / 2 + 150 - 20, 150, 20, 20, "O");
        this.field_175390_s = field_175390_s;
        buttonList3.add(field_175390_s);
        this.commandTextField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 150, 50, 300, 20);
        this.commandTextField.setMaxStringLength(32767);
        this.commandTextField.setFocused(true);
        this.commandTextField.setText(this.localCommandBlock.getCustomName());
        this.field_146486_g = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 150, 150, 276, 20);
        this.field_146486_g.setMaxStringLength(32767);
        this.field_146486_g.setEnabled(false);
        this.field_146486_g.setText("-");
        this.field_175389_t = this.localCommandBlock.func_175571_m();
        this.func_175388_a();
        this.doneBtn.enabled = (this.commandTextField.getText().trim().length() > 0);
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllllIIlIIllIlIlIlIlI, final int llllllllllllllllIIlIIllIlIlIllIl, final int llllllllllllllllIIlIIllIlIlIllII) throws IOException {
        super.mouseClicked(llllllllllllllllIIlIIllIlIlIlIlI, llllllllllllllllIIlIIllIlIlIllIl, llllllllllllllllIIlIIllIlIlIllII);
        this.commandTextField.mouseClicked(llllllllllllllllIIlIIllIlIlIlIlI, llllllllllllllllIIlIIllIlIlIllIl, llllllllllllllllIIlIIllIlIlIllII);
        this.field_146486_g.mouseClicked(llllllllllllllllIIlIIllIlIlIlIlI, llllllllllllllllIIlIIllIlIlIllIl, llllllllllllllllIIlIIllIlIlIllII);
    }
}
