package net.minecraft.client.gui;

import net.minecraft.network.play.client.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.client.network.*;
import java.io.*;
import net.minecraft.client.resources.*;

public class GuiSleepMP extends GuiChat
{
    private void wakeFromSleep() {
        final NetHandlerPlayClient llllllllllllllllIIIllllllIllIlII = this.mc.thePlayer.sendQueue;
        llllllllllllllllIIIllllllIllIlII.addToSendQueue(new C0BPacketEntityAction(this.mc.thePlayer, C0BPacketEntityAction.Action.STOP_SLEEPING));
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIIIllllllIlllIlI) throws IOException {
        if (llllllllllllllllIIIllllllIlllIlI.id == 1) {
            this.wakeFromSleep();
        }
        else {
            super.actionPerformed(llllllllllllllllIIIllllllIlllIlI);
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height - 40, I18n.format("multiplayer.stopSleeping", new Object[0])));
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllllIIIlllllllIIIlII, final int llllllllllllllllIIIlllllllIIIIll) throws IOException {
        if (llllllllllllllllIIIlllllllIIIIll == 1) {
            this.wakeFromSleep();
        }
        else if (llllllllllllllllIIIlllllllIIIIll != 28 && llllllllllllllllIIIlllllllIIIIll != 156) {
            super.keyTyped(llllllllllllllllIIIlllllllIIIlII, llllllllllllllllIIIlllllllIIIIll);
        }
        else {
            final String llllllllllllllllIIIlllllllIIIIlI = this.inputField.getText().trim();
            if (!llllllllllllllllIIIlllllllIIIIlI.isEmpty()) {
                this.mc.thePlayer.sendChatMessage(llllllllllllllllIIIlllllllIIIIlI);
            }
            this.inputField.setText("");
            this.mc.ingameGUI.getChatGUI().resetScroll();
        }
    }
    
    static {
        __OBFID = "CL_00000697";
    }
}
