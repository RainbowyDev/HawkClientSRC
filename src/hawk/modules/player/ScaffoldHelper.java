package hawk.modules.player;

import net.minecraft.client.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class ScaffoldHelper
{
    public static float[] getAngles(final Entity llllllllllllllIlIlIlllIIlllIIIIl) {
        final Minecraft llllllllllllllIlIlIlllIIlllIIIlI = Minecraft.getMinecraft();
        return new float[] { getYawChangeToEntity(llllllllllllllIlIlIlllIIlllIIIIl) + llllllllllllllIlIlIlllIIlllIIIlI.thePlayer.rotationYaw, getPitchChangeToEntity(llllllllllllllIlIlIlllIIlllIIIIl) + llllllllllllllIlIlIlllIIlllIIIlI.thePlayer.rotationPitch };
    }
    
    public static float[] getBlockRotations(final int llllllllllllllIlIlIlllIIlllIlIlI, final int llllllllllllllIlIlIlllIIlllIllll, final int llllllllllllllIlIlIlllIIlllIlIII, final EnumFacing llllllllllllllIlIlIlllIIlllIllIl) {
        final Minecraft llllllllllllllIlIlIlllIIlllIllII = Minecraft.getMinecraft();
        final EntitySnowball llllllllllllllIlIlIlllIIlllIlIll = new EntitySnowball(llllllllllllllIlIlIlllIIlllIllII.theWorld);
        llllllllllllllIlIlIlllIIlllIlIll.posX = llllllllllllllIlIlIlllIIlllIlIlI + 0.5;
        llllllllllllllIlIlIlllIIlllIlIll.posY = llllllllllllllIlIlIlllIIlllIllll + 0.5;
        llllllllllllllIlIlIlllIIlllIlIll.posZ = llllllllllllllIlIlIlllIIlllIlIII + 0.5;
        return getAngles(llllllllllllllIlIlIlllIIlllIlIll);
    }
    
    public static float getYawChangeToEntity(final Entity llllllllllllllIlIlIlllIIllIIIIll) {
        final Minecraft llllllllllllllIlIlIlllIIlIllllll = Minecraft.getMinecraft();
        final double llllllllllllllIlIlIlllIIlIlllllI = llllllllllllllIlIlIlllIIllIIIIll.posX - llllllllllllllIlIlIlllIIlIllllll.thePlayer.posX;
        final double llllllllllllllIlIlIlllIIlIllllIl = llllllllllllllIlIlIlllIIllIIIIll.posZ - llllllllllllllIlIlIlllIIlIllllll.thePlayer.posZ;
        double llllllllllllllIlIlIlllIIllIIIIII = 0.0;
        if (llllllllllllllIlIlIlllIIlIllllIl < 0.0 && llllllllllllllIlIlIlllIIlIlllllI < 0.0) {
            final double llllllllllllllIlIlIlllIIllIIIIlI = 90.0 + Math.toDegrees(Math.atan(llllllllllllllIlIlIlllIIlIllllIl / llllllllllllllIlIlIlllIIlIlllllI));
        }
        else if (llllllllllllllIlIlIlllIIlIllllIl < 0.0 && llllllllllllllIlIlIlllIIlIlllllI > 0.0) {
            final double llllllllllllllIlIlIlllIIllIIIIIl = -90.0 + Math.toDegrees(Math.atan(llllllllllllllIlIlIlllIIlIllllIl / llllllllllllllIlIlIlllIIlIlllllI));
        }
        else {
            llllllllllllllIlIlIlllIIllIIIIII = Math.toDegrees(-Math.atan(llllllllllllllIlIlIlllIIlIlllllI / llllllllllllllIlIlIlllIIlIllllIl));
        }
        return MathHelper.wrapAngleTo180_float(-(llllllllllllllIlIlIlllIIlIllllll.thePlayer.rotationYaw - (float)llllllllllllllIlIlIlllIIllIIIIII));
    }
    
    public static float getPitchChangeToEntity(final Entity llllllllllllllIlIlIlllIIlIllIIII) {
        final Minecraft llllllllllllllIlIlIlllIIlIlIllll = Minecraft.getMinecraft();
        final double llllllllllllllIlIlIlllIIlIlIlllI = llllllllllllllIlIlIlllIIlIllIIII.posX - llllllllllllllIlIlIlllIIlIlIllll.thePlayer.posX;
        final double llllllllllllllIlIlIlllIIIlIIllII = llllllllllllllIlIlIlllIIlIllIIII.posZ - llllllllllllllIlIlIlllIIlIlIllll.thePlayer.posZ;
        final double llllllllllllllIlIlIlllIIIlIIlIll = llllllllllllllIlIlIlllIIlIllIIII.posY - 1.6 + llllllllllllllIlIlIlllIIlIllIIII.getEyeHeight() - 0.4 - llllllllllllllIlIlIlllIIlIlIllll.thePlayer.posY;
        final double llllllllllllllIlIlIlllIIIlIIlIlI = MathHelper.sqrt_double(llllllllllllllIlIlIlllIIlIlIlllI * llllllllllllllIlIlIlllIIlIlIlllI + llllllllllllllIlIlIlllIIIlIIllII * llllllllllllllIlIlIlllIIIlIIllII);
        final double llllllllllllllIlIlIlllIIIlIIlIII = -Math.toDegrees(Math.atan(llllllllllllllIlIlIlllIIIlIIlIll / llllllllllllllIlIlIlllIIIlIIlIlI));
        return -MathHelper.wrapAngleTo180_float(llllllllllllllIlIlIlllIIlIlIllll.thePlayer.rotationPitch - (float)llllllllllllllIlIlIlllIIIlIIlIII);
    }
    
    public static float[] getRotations(final Entity llllllllllllllIlIlIlllIIllIllIII) {
        if (llllllllllllllIlIlIlllIIllIllIII == null) {
            return null;
        }
        final double llllllllllllllIlIlIlllIIllIlIlIl = llllllllllllllIlIlIlllIIllIllIII.posX - Minecraft.getMinecraft().thePlayer.posX;
        final double llllllllllllllIlIlIlllIIllIlIlII = llllllllllllllIlIlIlllIIllIllIII.posZ - Minecraft.getMinecraft().thePlayer.posZ;
        double llllllllllllllIlIlIlllIIllIlIllI = 0.0;
        if (llllllllllllllIlIlIlllIIllIllIII instanceof EntityLivingBase) {
            final EntityLivingBase llllllllllllllIlIlIlllIIllIlIIll = (EntityLivingBase)llllllllllllllIlIlIlllIIllIllIII;
            final double llllllllllllllIlIlIlllIIllIlIlll = llllllllllllllIlIlIlllIIllIlIIll.posY + llllllllllllllIlIlIlllIIllIlIIll.getEyeHeight() - 0.4 - Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight();
        }
        else {
            llllllllllllllIlIlIlllIIllIlIllI = (llllllllllllllIlIlIlllIIllIllIII.boundingBox.minY + llllllllllllllIlIlIlllIIllIllIII.boundingBox.maxY) / 2.0 - Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight();
        }
        final double llllllllllllllIlIlIlllIIllIlIIlI = MathHelper.sqrt_double(llllllllllllllIlIlIlllIIllIlIlIl * llllllllllllllIlIlIlllIIllIlIlIl + llllllllllllllIlIlIlllIIllIlIlII * llllllllllllllIlIlIlllIIllIlIlII);
        final float llllllllllllllIlIlIlllIIllIlIIIl = (float)(Math.atan2(llllllllllllllIlIlIlllIIllIlIlII, llllllllllllllIlIlIlllIIllIlIlIl) * 180.0 / 3.141592653589793) - 90.0f;
        final float llllllllllllllIlIlIlllIIllIlIIII = (float)(-(Math.atan2(llllllllllllllIlIlIlllIIllIlIllI, llllllllllllllIlIlIlllIIllIlIIlI) * 180.0 / 3.141592653589793));
        return new float[] { llllllllllllllIlIlIlllIIllIlIIIl, llllllllllllllIlIlIlllIIllIlIIII };
    }
}
