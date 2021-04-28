package net.minecraft.util;

import net.minecraft.client.settings.*;

public class MovementInputFromOptions extends MovementInput
{
    private final /* synthetic */ GameSettings gameSettings;
    
    @Override
    public void updatePlayerMoveState() {
        MovementInputFromOptions.moveStrafe = 0.0f;
        MovementInputFromOptions.moveForward = 0.0f;
        if (this.gameSettings.keyBindForward.getIsKeyPressed()) {
            ++MovementInputFromOptions.moveForward;
        }
        if (this.gameSettings.keyBindBack.getIsKeyPressed()) {
            --MovementInputFromOptions.moveForward;
        }
        if (this.gameSettings.keyBindLeft.getIsKeyPressed()) {
            ++MovementInputFromOptions.moveStrafe;
        }
        if (this.gameSettings.keyBindRight.getIsKeyPressed()) {
            --MovementInputFromOptions.moveStrafe;
        }
        this.jump = this.gameSettings.keyBindJump.getIsKeyPressed();
        this.sneak = this.gameSettings.keyBindSneak.getIsKeyPressed();
        if (this.sneak) {
            MovementInputFromOptions.moveStrafe *= (float)0.3;
            MovementInputFromOptions.moveForward *= (float)0.3;
        }
    }
    
    static {
        __OBFID = "CL_00000937";
    }
    
    public MovementInputFromOptions(final GameSettings lllllllllllllllIlllIIlIIIlIIIlIl) {
        this.gameSettings = lllllllllllllllIlllIIlIIIlIIIlIl;
    }
}
