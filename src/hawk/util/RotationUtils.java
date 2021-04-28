package hawk.util;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class RotationUtils
{
    private static /* synthetic */ Minecraft mc;
    
    public static float[] getBowAngles(final Entity llllllllllllllllIlIllIlIlIlIIlII) {
        final double llllllllllllllllIlIllIlIlIlIIIll = llllllllllllllllIlIllIlIlIlIIlII.posX - llllllllllllllllIlIllIlIlIlIIlII.lastTickPosX;
        final double llllllllllllllllIlIllIlIlIlIIIlI = llllllllllllllllIlIllIlIlIlIIlII.posZ - llllllllllllllllIlIllIlIlIlIIlII.lastTickPosZ;
        final double llllllllllllllllIlIllIlIlIlIIIIl = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(llllllllllllllllIlIllIlIlIlIIlII) % 0.8;
        final boolean llllllllllllllllIlIllIlIlIlIIIII = llllllllllllllllIlIllIlIlIlIIlII.isSprinting();
        final double llllllllllllllllIlIllIlIlIIlllll = llllllllllllllllIlIllIlIlIlIIIIl / 0.8 * llllllllllllllllIlIllIlIlIlIIIll * (llllllllllllllllIlIllIlIlIlIIIII ? 1.25 : 1.0);
        final double llllllllllllllllIlIllIlIlIIllllI = llllllllllllllllIlIllIlIlIlIIIIl / 0.8 * llllllllllllllllIlIllIlIlIlIIIlI * (llllllllllllllllIlIllIlIlIlIIIII ? 1.25 : 1.0);
        final double llllllllllllllllIlIllIlIlIIlllIl = llllllllllllllllIlIllIlIlIlIIlII.posX + llllllllllllllllIlIllIlIlIIlllll - Minecraft.getMinecraft().thePlayer.posX;
        final double llllllllllllllllIlIllIlIlIIlllII = llllllllllllllllIlIllIlIlIlIIlII.posZ + llllllllllllllllIlIllIlIlIIllllI - Minecraft.getMinecraft().thePlayer.posZ;
        final double llllllllllllllllIlIllIlIlIIllIll = Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight() - (llllllllllllllllIlIllIlIlIlIIlII.posY + llllllllllllllllIlIllIlIlIlIIlII.getEyeHeight());
        final double llllllllllllllllIlIllIlIlIIllIlI = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(llllllllllllllllIlIllIlIlIlIIlII);
        final float llllllllllllllllIlIllIlIlIIllIIl = (float)Math.toDegrees(Math.atan2(llllllllllllllllIlIllIlIlIIlllII, llllllllllllllllIlIllIlIlIIlllIl)) - 90.0f;
        final float llllllllllllllllIlIllIlIlIIllIII = (float)Math.toDegrees(Math.atan2(llllllllllllllllIlIllIlIlIIllIll, llllllllllllllllIlIllIlIlIIllIlI));
        return new float[] { llllllllllllllllIlIllIlIlIIllIIl, llllllllllllllllIlIllIlIlIIllIII };
    }
    
    public static float[] getRotations(final EntityLivingBase llllllllllllllllIlIllIlIllIIlllI) {
        final double llllllllllllllllIlIllIlIllIIllIl = llllllllllllllllIlIllIlIllIIlllI.posX;
        final double llllllllllllllllIlIllIlIllIIllII = llllllllllllllllIlIllIlIllIIlllI.posY + llllllllllllllllIlIllIlIllIIlllI.getEyeHeight() / 2.0f;
        final double llllllllllllllllIlIllIlIllIIlIll = llllllllllllllllIlIllIlIllIIlllI.posZ;
        return getRotationFromPosition(llllllllllllllllIlIllIlIllIIllIl, llllllllllllllllIlIllIlIllIIllII, llllllllllllllllIlIllIlIllIIlIll);
    }
    
    static {
        RotationUtils.mc = Minecraft.getMinecraft();
    }
    
    public static float[] getRotationFromPosition(final double llllllllllllllllIlIllIlIlIIIIIIl, final double llllllllllllllllIlIllIlIIlllIlll, final double llllllllllllllllIlIllIlIIlllllll) {
        final double llllllllllllllllIlIllIlIIllllllI = llllllllllllllllIlIllIlIlIIIIIIl - Minecraft.getMinecraft().thePlayer.posX;
        final double llllllllllllllllIlIllIlIIlllllIl = llllllllllllllllIlIllIlIIlllllll - Minecraft.getMinecraft().thePlayer.posZ;
        final double llllllllllllllllIlIllIlIIlllllII = llllllllllllllllIlIllIlIIlllIlll - Minecraft.getMinecraft().thePlayer.posY - 1.2;
        final double llllllllllllllllIlIllIlIIllllIll = MathHelper.sqrt_double(llllllllllllllllIlIllIlIIllllllI * llllllllllllllllIlIllIlIIllllllI + llllllllllllllllIlIllIlIIlllllIl * llllllllllllllllIlIllIlIIlllllIl);
        final float llllllllllllllllIlIllIlIIllllIlI = (float)(Math.atan2(llllllllllllllllIlIllIlIIlllllIl, llllllllllllllllIlIllIlIIllllllI) * 180.0 / 3.141592653589793) - 90.0f;
        final float llllllllllllllllIlIllIlIIllllIIl = (float)(-(Math.atan2(llllllllllllllllIlIllIlIIlllllII, llllllllllllllllIlIllIlIIllllIll) * 180.0 / 3.141592653589793));
        return new float[] { llllllllllllllllIlIllIlIIllllIlI, llllllllllllllllIlIllIlIIllllIIl };
    }
    
    public static float[] doScaffoldRotations(final Vec3d llllllllllllllllIlIllIlIlIlllIII) {
        final double llllllllllllllllIlIllIlIlIlllllI = llllllllllllllllIlIllIlIlIlllIII.xCoord - RotationUtils.mc.thePlayer.posX;
        final double llllllllllllllllIlIllIlIlIllllIl = llllllllllllllllIlIllIlIlIlllIII.yCoord - RotationUtils.mc.thePlayer.boundingBox.minY;
        final double llllllllllllllllIlIllIlIlIllllII = llllllllllllllllIlIllIlIlIlllIII.zCoord - RotationUtils.mc.thePlayer.posZ;
        final double llllllllllllllllIlIllIlIlIlllIll = MathHelper.sqrt_double(llllllllllllllllIlIllIlIlIlllllI * llllllllllllllllIlIllIlIlIlllllI + llllllllllllllllIlIllIlIlIllllII * llllllllllllllllIlIllIlIlIllllII);
        final float llllllllllllllllIlIllIlIlIlllIlI = (float)Math.toDegrees(Math.atan2(llllllllllllllllIlIllIlIlIllllII, llllllllllllllllIlIllIlIlIlllllI));
        final float llllllllllllllllIlIllIlIlIlllIIl = (float)(-Math.toDegrees(Math.atan2(llllllllllllllllIlIllIlIlIllllIl, llllllllllllllllIlIllIlIlIlllIll)));
        return new float[] { RotationUtils.mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(llllllllllllllllIlIllIlIlIlllIlI - RotationUtils.mc.thePlayer.rotationYaw), RotationUtils.mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(llllllllllllllllIlIllIlIlIlllIIl - RotationUtils.mc.thePlayer.rotationPitch) };
    }
}
