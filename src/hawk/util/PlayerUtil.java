package hawk.util;

import net.minecraft.client.*;

public class PlayerUtil
{
    public static /* synthetic */ Minecraft mc;
    
    public static double getCurrentMotion() {
        final double llllllllllllllIlIIIIIlllIllllIII = Math.sqrt(PlayerUtil.mc.thePlayer.motionX * PlayerUtil.mc.thePlayer.motionX + PlayerUtil.mc.thePlayer.motionZ * PlayerUtil.mc.thePlayer.motionZ);
        return llllllllllllllIlIIIIIlllIllllIII;
    }
    
    public static float getDirection() {
        float llllllllllllllIlIIIIIlllIlllllIl = PlayerUtil.mc.thePlayer.rotationYaw;
        if (PlayerUtil.mc.thePlayer.moveForward < 0.0f) {
            llllllllllllllIlIIIIIlllIlllllIl += 180.0f;
        }
        float llllllllllllllIlIIIIIlllIlllllII = 1.0f;
        if (PlayerUtil.mc.thePlayer.moveForward < 0.0f) {
            llllllllllllllIlIIIIIlllIlllllII = -0.5f;
        }
        else if (PlayerUtil.mc.thePlayer.moveForward > 0.0f) {
            llllllllllllllIlIIIIIlllIlllllII = 0.5f;
        }
        if (PlayerUtil.mc.thePlayer.moveStrafing > 0.0f) {
            llllllllllllllIlIIIIIlllIlllllIl -= 90.0f * llllllllllllllIlIIIIIlllIlllllII;
        }
        if (PlayerUtil.mc.thePlayer.moveStrafing < 0.0f) {
            llllllllllllllIlIIIIIlllIlllllIl += 90.0f * llllllllllllllIlIIIIIlllIlllllII;
        }
        llllllllllllllIlIIIIIlllIlllllIl *= 0.017453292f;
        return llllllllllllllIlIIIIIlllIlllllIl;
    }
    
    static {
        PlayerUtil.mc = Minecraft.getMinecraft();
    }
    
    public static void setSpeed(final double llllllllllllllIlIIIIIlllIlllIlII) {
        PlayerUtil.mc.thePlayer.motionX = -Math.sin(getDirection()) * llllllllllllllIlIIIIIlllIlllIlII;
        PlayerUtil.mc.thePlayer.motionZ = Math.cos(getDirection()) * llllllllllllllIlIIIIIlllIlllIlII;
    }
}
