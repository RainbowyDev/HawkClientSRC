package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.*;
import org.lwjgl.input.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.network.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.resources.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;

public class GuiEditSign extends GuiScreen
{
    private /* synthetic */ TileEntitySign tileSign;
    private /* synthetic */ int editLine;
    private /* synthetic */ GuiButton doneBtn;
    private /* synthetic */ int updateCounter;
    
    @Override
    public void updateScreen() {
        ++this.updateCounter;
    }
    
    static {
        __OBFID = "CL_00000764";
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        final NetHandlerPlayClient llllllllllllllIlIIlIllIlIlIIlIlI = this.mc.getNetHandler();
        if (llllllllllllllIlIIlIllIlIlIIlIlI != null) {
            llllllllllllllIlIIlIllIlIlIIlIlI.addToSendQueue(new C12PacketUpdateSign(this.tileSign.getPos(), this.tileSign.signText));
        }
        this.tileSign.setEditable(true);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIlIIlIllIlIIlllIIl, final int llllllllllllllIlIIlIllIlIIllIlII) throws IOException {
        if (llllllllllllllIlIIlIllIlIIllIlII == 200) {
            this.editLine = (this.editLine - 1 & 0x3);
        }
        if (llllllllllllllIlIIlIllIlIIllIlII == 208 || llllllllllllllIlIIlIllIlIIllIlII == 28 || llllllllllllllIlIIlIllIlIIllIlII == 156) {
            this.editLine = (this.editLine + 1 & 0x3);
        }
        String llllllllllllllIlIIlIllIlIIllIlll = this.tileSign.signText[this.editLine].getUnformattedText();
        if (llllllllllllllIlIIlIllIlIIllIlII == 14 && llllllllllllllIlIIlIllIlIIllIlll.length() > 0) {
            llllllllllllllIlIIlIllIlIIllIlll = llllllllllllllIlIIlIllIlIIllIlll.substring(0, llllllllllllllIlIIlIllIlIIllIlll.length() - 1);
        }
        if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIlIIlIllIlIIlllIIl) && this.fontRendererObj.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIlIllIlIIllIlll)).append(llllllllllllllIlIIlIllIlIIlllIIl))) <= 90) {
            llllllllllllllIlIIlIllIlIIllIlll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIlIllIlIIllIlll)).append(llllllllllllllIlIIlIllIlIIlllIIl));
        }
        this.tileSign.signText[this.editLine] = new ChatComponentText(llllllllllllllIlIIlIllIlIIllIlll);
        if (llllllllllllllIlIIlIllIlIIllIlII == 1) {
            this.actionPerformed(this.doneBtn);
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIIlIllIlIlIIIIIl) throws IOException {
        if (llllllllllllllIlIIlIllIlIlIIIIIl.enabled && llllllllllllllIlIIlIllIlIlIIIIIl.id == 0) {
            this.tileSign.markDirty();
            this.mc.displayGuiScreen(null);
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        final List buttonList = this.buttonList;
        final GuiButton doneBtn = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, I18n.format("gui.done", new Object[0]));
        this.doneBtn = doneBtn;
        buttonList.add(doneBtn);
        this.tileSign.setEditable(false);
    }
    
    public GuiEditSign(final TileEntitySign llllllllllllllIlIIlIllIlIlIlIIll) {
        this.tileSign = llllllllllllllIlIIlIllIlIlIlIIll;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIIlIllIlIIlIlIIl, final int llllllllllllllIlIIlIllIlIIlIlIII, final float llllllllllllllIlIIlIllIlIIIllllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("sign.edit", new Object[0]), this.width / 2, 40, 16777215);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.width / 2), 0.0f, 50.0f);
        final float llllllllllllllIlIIlIllIlIIlIIllI = 93.75f;
        GlStateManager.scale(-llllllllllllllIlIIlIllIlIIlIIllI, -llllllllllllllIlIIlIllIlIIlIIllI, -llllllllllllllIlIIlIllIlIIlIIllI);
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        final Block llllllllllllllIlIIlIllIlIIlIIlIl = this.tileSign.getBlockType();
        if (llllllllllllllIlIIlIllIlIIlIIlIl == Blocks.standing_sign) {
            final float llllllllllllllIlIIlIllIlIIlIIlII = this.tileSign.getBlockMetadata() * 360 / 16.0f;
            GlStateManager.rotate(llllllllllllllIlIIlIllIlIIlIIlII, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -1.0625f, 0.0f);
        }
        else {
            final int llllllllllllllIlIIlIllIlIIlIIIll = this.tileSign.getBlockMetadata();
            float llllllllllllllIlIIlIllIlIIlIIIlI = 0.0f;
            if (llllllllllllllIlIIlIllIlIIlIIIll == 2) {
                llllllllllllllIlIIlIllIlIIlIIIlI = 180.0f;
            }
            if (llllllllllllllIlIIlIllIlIIlIIIll == 4) {
                llllllllllllllIlIIlIllIlIIlIIIlI = 90.0f;
            }
            if (llllllllllllllIlIIlIllIlIIlIIIll == 5) {
                llllllllllllllIlIIlIllIlIIlIIIlI = -90.0f;
            }
            GlStateManager.rotate(llllllllllllllIlIIlIllIlIIlIIIlI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -1.0625f, 0.0f);
        }
        if (this.updateCounter / 6 % 2 == 0) {
            this.tileSign.lineBeingEdited = this.editLine;
        }
        TileEntityRendererDispatcher.instance.renderTileEntityAt(this.tileSign, -0.5, -0.75, -0.5, 0.0f);
        this.tileSign.lineBeingEdited = -1;
        GlStateManager.popMatrix();
        super.drawScreen(llllllllllllllIlIIlIllIlIIlIlIIl, llllllllllllllIlIIlIllIlIIlIlIII, llllllllllllllIlIIlIllIlIIIllllI);
    }
}
