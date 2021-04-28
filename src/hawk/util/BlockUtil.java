package hawk.util;

import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class BlockUtil
{
    public static void placeHeldItemUnderPlayer() {
        final Minecraft llllllllllllllIlIllIlIIIIIlIIIll = Minecraft.getMinecraft();
        final BlockPos llllllllllllllIlIllIlIIIIIlIIIlI = new BlockPos(llllllllllllllIlIllIlIIIIIlIIIll.thePlayer.posX, llllllllllllllIlIllIlIIIIIlIIIll.thePlayer.getEntityBoundingBox().minY - 1.0, llllllllllllllIlIllIlIIIIIlIIIll.thePlayer.posZ);
        final Vec3 llllllllllllllIlIllIlIIIIIlIIIIl = new Vec3(llllllllllllllIlIllIlIIIIIlIIIll.thePlayer.posX, llllllllllllllIlIllIlIIIIIlIIIll.thePlayer.getEntityBoundingBox().minY - 1.0, llllllllllllllIlIllIlIIIIIlIIIll.thePlayer.posZ);
        llllllllllllllIlIllIlIIIIIlIIIll.playerController.func_178890_a(llllllllllllllIlIllIlIIIIIlIIIll.thePlayer, llllllllllllllIlIllIlIIIIIlIIIll.theWorld, null, llllllllllllllIlIllIlIIIIIlIIIlI, EnumFacing.UP, llllllllllllllIlIllIlIIIIIlIIIIl);
    }
}
