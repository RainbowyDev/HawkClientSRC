package hawk.modules.movement;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.entity.*;

public class Invmove extends Module
{
    @Override
    public void onEvent(final Event lllllllllllllllllllIIIIllIIIlIll) {
        if (lllllllllllllllllllIIIIllIIIlIll instanceof EventUpdate) {
            if (this.mc.currentScreen instanceof GuiScreen) {
                if (Keyboard.isKeyDown(205) && !(this.mc.currentScreen instanceof GuiChat)) {
                    final EntityPlayerSP thePlayer = this.mc.thePlayer;
                    thePlayer.rotationYaw += 8.0f;
                }
                if (Keyboard.isKeyDown(203) && !(this.mc.currentScreen instanceof GuiChat)) {
                    final EntityPlayerSP thePlayer2 = this.mc.thePlayer;
                    thePlayer2.rotationYaw -= 8.0f;
                }
                if (Keyboard.isKeyDown(200) && !(this.mc.currentScreen instanceof GuiChat)) {
                    final EntityPlayerSP thePlayer3 = this.mc.thePlayer;
                    thePlayer3.rotationPitch -= 8.0f;
                }
                if (Keyboard.isKeyDown(208) && !(this.mc.currentScreen instanceof GuiChat)) {
                    final EntityPlayerSP thePlayer4 = this.mc.thePlayer;
                    thePlayer4.rotationPitch += 8.0f;
                }
            }
            final KeyBinding[] lllllllllllllllllllIIIIllIIIllll = { this.mc.gameSettings.keyBindRight, this.mc.gameSettings.keyBindLeft, this.mc.gameSettings.keyBindBack, this.mc.gameSettings.keyBindForward, this.mc.gameSettings.keyBindJump, this.mc.gameSettings.keyBindSprint };
            if (this.mc.currentScreen instanceof GuiScreen && !(this.mc.currentScreen instanceof GuiChat)) {
                final float lllllllllllllllllllIIIIllIIIIllI;
                final String lllllllllllllllllllIIIIllIIIIlll = (String)((KeyBinding[])(Object)(lllllllllllllllllllIIIIllIIIIllI = (float)(Object)lllllllllllllllllllIIIIllIIIllll)).length;
                for (double lllllllllllllllllllIIIIllIIIlIII = 0; lllllllllllllllllllIIIIllIIIlIII < lllllllllllllllllllIIIIllIIIIlll; ++lllllllllllllllllllIIIIllIIIlIII) {
                    final KeyBinding lllllllllllllllllllIIIIllIIIlllI = lllllllllllllllllllIIIIllIIIIllI[lllllllllllllllllllIIIIllIIIlIII];
                    lllllllllllllllllllIIIIllIIIlllI.pressed = Keyboard.isKeyDown(lllllllllllllllllllIIIIllIIIlllI.getKeyCode());
                }
            }
            else {
                final float lllllllllllllllllllIIIIllIIIIllI;
                final String lllllllllllllllllllIIIIllIIIIlll = (String)((KeyBinding[])(Object)(lllllllllllllllllllIIIIllIIIIllI = (float)(Object)lllllllllllllllllllIIIIllIIIllll)).length;
                for (double lllllllllllllllllllIIIIllIIIlIII = 0; lllllllllllllllllllIIIIllIIIlIII < lllllllllllllllllllIIIIllIIIIlll; ++lllllllllllllllllllIIIIllIIIlIII) {
                    final KeyBinding lllllllllllllllllllIIIIllIIIllIl = lllllllllllllllllllIIIIllIIIIllI[lllllllllllllllllllIIIIllIIIlIII];
                    if (!Keyboard.isKeyDown(lllllllllllllllllllIIIIllIIIllIl.getKeyCode())) {
                        KeyBinding.setKeyBindState(lllllllllllllllllllIIIIllIIIllIl.getKeyCode(), false);
                    }
                }
            }
        }
    }
    
    public Invmove() {
        super("Invmove", 0, Category.MOVEMENT);
    }
}
