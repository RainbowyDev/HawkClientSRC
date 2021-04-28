package hawk.modules.movement;

import net.minecraft.client.*;

public class SpeedModifier
{
    public static void setSpeed(final float lllllllllllllllllIllIlIIlIlllIlI) {
        double lllllllllllllllllIllIlIIlIlllIIl = Minecraft.getMinecraft().thePlayer.rotationYaw;
        final boolean lllllllllllllllllIllIlIIlIlllIII = Minecraft.getMinecraft().thePlayer.moveForward != 0.0f || Minecraft.getMinecraft().thePlayer.moveStrafing != 0.0f;
        final boolean lllllllllllllllllIllIlIIlIllIlll = Minecraft.getMinecraft().thePlayer.moveForward > 0.0f;
        final boolean lllllllllllllllllIllIlIIlIllIllI = Minecraft.getMinecraft().thePlayer.moveForward < 0.0f;
        final boolean lllllllllllllllllIllIlIIlIllIlIl = Minecraft.getMinecraft().thePlayer.moveStrafing > 0.0f;
        final boolean lllllllllllllllllIllIlIIlIllIlII = Minecraft.getMinecraft().thePlayer.moveStrafing < 0.0f;
        final boolean lllllllllllllllllIllIlIIlIllIIll = lllllllllllllllllIllIlIIlIllIlII || lllllllllllllllllIllIlIIlIllIlIl;
        final boolean lllllllllllllllllIllIlIIlIllIIlI = lllllllllllllllllIllIlIIlIllIlll || lllllllllllllllllIllIlIIlIllIllI;
        if (lllllllllllllllllIllIlIIlIlllIII) {
            if (lllllllllllllllllIllIlIIlIllIlll && !lllllllllllllllllIllIlIIlIllIIll) {
                lllllllllllllllllIllIlIIlIlllIIl += 0.0;
            }
            else if (lllllllllllllllllIllIlIIlIllIllI && !lllllllllllllllllIllIlIIlIllIIll) {
                lllllllllllllllllIllIlIIlIlllIIl += 180.0;
            }
            else if (lllllllllllllllllIllIlIIlIllIlll && lllllllllllllllllIllIlIIlIllIlII) {
                lllllllllllllllllIllIlIIlIlllIIl += 45.0;
            }
            else if (lllllllllllllllllIllIlIIlIllIlll) {
                lllllllllllllllllIllIlIIlIlllIIl -= 45.0;
            }
            else if (!lllllllllllllllllIllIlIIlIllIIlI && lllllllllllllllllIllIlIIlIllIlII) {
                lllllllllllllllllIllIlIIlIlllIIl += 90.0;
            }
            else if (!lllllllllllllllllIllIlIIlIllIIlI && lllllllllllllllllIllIlIIlIllIlIl) {
                lllllllllllllllllIllIlIIlIlllIIl -= 90.0;
            }
            else if (lllllllllllllllllIllIlIIlIllIllI && lllllllllllllllllIllIlIIlIllIlII) {
                lllllllllllllllllIllIlIIlIlllIIl += 135.0;
            }
            else if (lllllllllllllllllIllIlIIlIllIllI) {
                lllllllllllllllllIllIlIIlIlllIIl -= 135.0;
            }
            lllllllllllllllllIllIlIIlIlllIIl = Math.toRadians(lllllllllllllllllIllIlIIlIlllIIl);
            Minecraft.getMinecraft().thePlayer.motionX = -Math.sin(lllllllllllllllllIllIlIIlIlllIIl) * lllllllllllllllllIllIlIIlIlllIlI;
            Minecraft.getMinecraft().thePlayer.motionZ = Math.cos(lllllllllllllllllIllIlIIlIlllIIl) * lllllllllllllllllIllIlIIlIlllIlI;
        }
    }
}
