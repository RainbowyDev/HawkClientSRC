package hawk.util;

import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import net.minecraft.network.*;
import net.minecraft.tileentity.*;
import net.minecraft.network.play.client.*;
import net.minecraft.util.*;
import org.lwjgl.input.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.*;

public class RotationUtils2
{
    public /* synthetic */ float hitDelay;
    public /* synthetic */ float blockDamage;
    public static /* synthetic */ Minecraft mc;
    
    public static float[] getRotationFromPosition(final double lllllllllllllllIllIIlIlIIIllIlIl, final double lllllllllllllllIllIIlIlIIIllIlII, final double lllllllllllllllIllIIlIlIIIllIIll) {
        Minecraft.getMinecraft();
        final double lllllllllllllllIllIIlIlIIIllIIlI = lllllllllllllllIllIIlIlIIIllIlIl - RotationUtils2.mc.thePlayer.posX;
        Minecraft.getMinecraft();
        final double lllllllllllllllIllIIlIlIIIllIIIl = lllllllllllllllIllIIlIlIIIllIlII - RotationUtils2.mc.thePlayer.posZ;
        Minecraft.getMinecraft();
        final double lllllllllllllllIllIIlIlIIIllIIII = lllllllllllllllIllIIlIlIIIllIIll - RotationUtils2.mc.thePlayer.posY - 0.6;
        final double lllllllllllllllIllIIlIlIIIlIllll = MathHelper.sqrt_double(lllllllllllllllIllIIlIlIIIllIIlI * lllllllllllllllIllIIlIlIIIllIIlI + lllllllllllllllIllIIlIlIIIllIIIl * lllllllllllllllIllIIlIlIIIllIIIl);
        final float lllllllllllllllIllIIlIlIIIlIlllI = (float)(Math.atan2(lllllllllllllllIllIIlIlIIIllIIIl, lllllllllllllllIllIIlIlIIIllIIlI) * 180.0 / 3.141592653589793) - 90.0f;
        final float lllllllllllllllIllIIlIlIIIlIllIl = (float)(-(Math.atan2(lllllllllllllllIllIIlIlIIIllIIII, lllllllllllllllIllIIlIlIIIlIllll) * 180.0 / 3.141592653589793));
        return new float[] { lllllllllllllllIllIIlIlIIIlIlllI, lllllllllllllllIllIIlIlIIIlIllIl };
    }
    
    public float getDistanceToEntity(final TileEntity lllllllllllllllIllIIlIllIIlIIllI) {
        final float lllllllllllllllIllIIlIllIIlIIlIl = (float)(RotationUtils2.mc.thePlayer.posX - lllllllllllllllIllIIlIllIIlIIllI.getPos().getX());
        final float lllllllllllllllIllIIlIllIIlIIlII = (float)(RotationUtils2.mc.thePlayer.posY - lllllllllllllllIllIIlIllIIlIIllI.getPos().getY());
        final float lllllllllllllllIllIIlIllIIlIIIll = (float)(RotationUtils2.mc.thePlayer.posZ - lllllllllllllllIllIIlIllIIlIIllI.getPos().getZ());
        return MathHelper.sqrt_float(lllllllllllllllIllIIlIllIIlIIlIl * lllllllllllllllIllIIlIllIIlIIlIl + lllllllllllllllIllIIlIllIIlIIlII * lllllllllllllllIllIIlIllIIlIIlII + lllllllllllllllIllIIlIllIIlIIIll * lllllllllllllllIllIIlIllIIlIIIll);
    }
    
    public boolean isVisibleFOV(final TileEntity lllllllllllllllIllIIlIlIIllIIIlI, final EntityPlayerSP lllllllllllllllIllIIlIlIIllIIIIl, final int lllllllllllllllIllIIlIlIIlIlllII) {
        return ((Math.abs(this.getRotationsTileEntity(lllllllllllllllIllIIlIlIIllIIIlI)[0] - lllllllllllllllIllIIlIlIIllIIIIl.rotationYaw) % 360.0f > 180.0f) ? (360.0f - Math.abs(this.getRotationsTileEntity(lllllllllllllllIllIIlIlIIllIIIlI)[0] - lllllllllllllllIllIIlIlIIllIIIIl.rotationYaw) % 360.0f) : (Math.abs(this.getRotationsTileEntity(lllllllllllllllIllIIlIlIIllIIIlI)[0] - lllllllllllllllIllIIlIlIIllIIIIl.rotationYaw) % 360.0f)) <= lllllllllllllllIllIIlIlIIlIlllII;
    }
    
    public void breakBlock(final double lllllllllllllllIllIIlIlIlllIIIII, final double lllllllllllllllIllIIlIlIlllIIIll, final double lllllllllllllllIllIIlIlIlllIIIlI) {
        RotationUtils2.mc.thePlayer.swingItem();
        RotationUtils2.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, this.getBlockPos(lllllllllllllllIllIIlIlIlllIIIII, lllllllllllllllIllIIlIlIlllIIIll, lllllllllllllllIllIIlIlIlllIIIlI), this.getEnumFacing((float)(int)lllllllllllllllIllIIlIlIlllIIIII, (float)(int)lllllllllllllllIllIIlIlIlllIIIll, (float)(int)lllllllllllllllIllIIlIlIlllIIIlI)));
        RotationUtils2.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.getBlockPos(lllllllllllllllIllIIlIlIlllIIIII, lllllllllllllllIllIIlIlIlllIIIll, lllllllllllllllIllIIlIlIlllIIIlI), this.getEnumFacing((float)(int)lllllllllllllllIllIIlIlIlllIIIII, (float)(int)lllllllllllllllIllIIlIlIlllIIIll, (float)(int)lllllllllllllllIllIIlIlIlllIIIlI)));
    }
    
    public boolean canBlockBeSeen(final int lllllllllllllllIllIIlIlIlllIlllI, final int lllllllllllllllIllIIlIlIlllIllIl, final int lllllllllllllllIllIIlIlIlllIllII) {
        final Vec3 lllllllllllllllIllIIlIlIllllIIII = new Vec3(RotationUtils2.mc.thePlayer.posX, RotationUtils2.mc.thePlayer.posY + RotationUtils2.mc.thePlayer.getEyeHeight(), RotationUtils2.mc.thePlayer.posZ);
        final Vec3 lllllllllllllllIllIIlIlIlllIllll = new Vec3(lllllllllllllllIllIIlIlIlllIlllI + 0.5f, lllllllllllllllIllIIlIlIlllIllIl + 0.5f, lllllllllllllllIllIIlIlIlllIllII + 0.5f);
        return (RotationUtils2.mc.theWorld.rayTraceBlocks(lllllllllllllllIllIIlIlIllllIIII, lllllllllllllllIllIIlIlIlllIllll) != null) ? Boolean.valueOf(RotationUtils2.mc.theWorld.rayTraceBlocks(lllllllllllllllIllIIlIlIllllIIII, lllllllllllllllIllIIlIlIlllIllll).field_178784_b != null) : null;
    }
    
    public TileEntityChest getBestEntity(final double lllllllllllllllIllIIlIllIIllIIlI) {
        TileEntityChest lllllllllllllllIllIIlIllIIlllIII = null;
        double lllllllllllllllIllIIlIllIIllIlll = lllllllllllllllIllIIlIllIIllIIlI;
        for (final Object lllllllllllllllIllIIlIllIIllIllI : RotationUtils2.mc.theWorld.loadedEntityList) {
            final TileEntityChest lllllllllllllllIllIIlIllIIllIlIl = (TileEntityChest)lllllllllllllllIllIIlIllIIllIllI;
            if (this.getDistanceToEntity(lllllllllllllllIllIIlIllIIllIlIl) <= 6.0f) {
                final double lllllllllllllllIllIIlIllIIllIlII = this.getDistanceToEntity(lllllllllllllllIllIIlIllIIllIlIl);
                if (lllllllllllllllIllIIlIllIIllIlII > lllllllllllllllIllIIlIllIIllIlll) {
                    continue;
                }
                lllllllllllllllIllIIlIllIIllIlll = lllllllllllllllIllIIlIllIIllIlII;
                lllllllllllllllIllIIlIllIIlllIII = lllllllllllllllIllIIlIllIIllIlIl;
            }
        }
        return lllllllllllllllIllIIlIllIIlllIII;
    }
    
    public EnumFacing getEnumFacing(final float lllllllllllllllIllIIlIlIllIlIllI, final float lllllllllllllllIllIIlIlIllIllIII, final float lllllllllllllllIllIIlIlIllIlIlll) {
        return EnumFacing.func_176737_a(lllllllllllllllIllIIlIlIllIlIllI, lllllllllllllllIllIIlIlIllIllIII, lllllllllllllllIllIIlIlIllIlIlll);
    }
    
    public float getDistanceToVec(final double lllllllllllllllIllIIlIlIlIIlIIIl, final double lllllllllllllllIllIIlIlIlIIllIIl, final double lllllllllllllllIllIIlIlIlIIllIII, final double lllllllllllllllIllIIlIlIlIIlIlll, final double lllllllllllllllIllIIlIlIlIIIllIl, final double lllllllllllllllIllIIlIlIlIIIllII) {
        final float lllllllllllllllIllIIlIlIlIIlIlII = (float)(lllllllllllllllIllIIlIlIlIIlIIIl - lllllllllllllllIllIIlIlIlIIlIlll);
        final float lllllllllllllllIllIIlIlIlIIlIIll = (float)(lllllllllllllllIllIIlIlIlIIllIIl - lllllllllllllllIllIIlIlIlIIIllIl);
        final float lllllllllllllllIllIIlIlIlIIlIIlI = (float)(lllllllllllllllIllIIlIlIlIIllIII - lllllllllllllllIllIIlIlIlIIIllII);
        return MathHelper.sqrt_float(lllllllllllllllIllIIlIlIlIIlIlII * lllllllllllllllIllIIlIlIlIIlIlII + lllllllllllllllIllIIlIlIlIIlIIll * lllllllllllllllIllIIlIlIlIIlIIll + lllllllllllllllIllIIlIlIlIIlIIlI * lllllllllllllllIllIIlIlIlIIlIIlI);
    }
    
    public void moveRight() {
        RotationUtils2.mc.gameSettings.keyBindRight.pressed = true;
    }
    
    public static float getNewAngle(float lllllllllllllllIllIIlIlIIIIlIIlI) {
        lllllllllllllllIllIIlIlIIIIlIIlI %= 360.0f;
        if (lllllllllllllllIllIIlIlIIIIlIIlI >= 180.0f) {
            lllllllllllllllIllIIlIlIIIIlIIlI -= 360.0f;
        }
        if (lllllllllllllllIllIIlIlIIIIlIIlI < -180.0f) {
            lllllllllllllllIllIIlIlIIIIlIIlI += 360.0f;
        }
        return lllllllllllllllIllIIlIlIIIIlIIlI;
    }
    
    public void placeBlock(final int lllllllllllllllIllIIlIllIllIllll, final int lllllllllllllllIllIIlIllIllIlllI, final int lllllllllllllllIllIIlIllIllIllIl) {
        RotationUtils2.mc.thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(this.getBlockPos(lllllllllllllllIllIIlIllIllIllll, lllllllllllllllIllIIlIllIllIlllI, lllllllllllllllIllIIlIllIllIllIl), this.getEnumFacing((float)lllllllllllllllIllIIlIllIllIllll, (float)lllllllllllllllIllIIlIllIllIlllI, (float)lllllllllllllllIllIIlIllIllIllIl).getIndex(), RotationUtils2.mc.thePlayer.getHeldItem(), 0.0f, 0.0f, 0.0f));
    }
    
    public BlockPos getBlockPos(final double lllllllllllllllIllIIlIlIllIIlllI, final double lllllllllllllllIllIIlIlIllIIlIIl, final double lllllllllllllllIllIIlIlIllIIlIII) {
        final BlockPos lllllllllllllllIllIIlIlIllIIlIll = new BlockPos(lllllllllllllllIllIIlIlIllIIlllI, lllllllllllllllIllIIlIlIllIIlIIl, lllllllllllllllIllIIlIlIllIIlIII);
        return lllllllllllllllIllIIlIlIllIIlIll;
    }
    
    public Block getBlock(double lllllllllllllllIllIIlIlIlIlllIlI, double lllllllllllllllIllIIlIlIlIllllII, double lllllllllllllllIllIIlIlIlIlllIII) {
        lllllllllllllllIllIIlIlIlIlllIlI = (byte)MathHelper.floor_double(lllllllllllllllIllIIlIlIlIlllIlI);
        lllllllllllllllIllIIlIlIlIllllII = MathHelper.floor_double(lllllllllllllllIllIIlIlIlIllllII);
        lllllllllllllllIllIIlIlIlIlllIII = MathHelper.floor_double(lllllllllllllllIllIIlIlIlIlllIII);
        return RotationUtils2.mc.theWorld.getChunkFromBlockCoords(new BlockPos(lllllllllllllllIllIIlIlIlIlllIlI, lllllllllllllllIllIIlIlIlIllllII, lllllllllllllllIllIIlIlIlIlllIII)).getBlock(new BlockPos(lllllllllllllllIllIIlIlIlIlllIlI, lllllllllllllllIllIIlIlIlIllllII, lllllllllllllllIllIIlIlIlIlllIII));
    }
    
    public void movePlayerToBlock(final double lllllllllllllllIllIIlIllIlllllIl, final double lllllllllllllllIllIIlIllIlllIlll, final double lllllllllllllllIllIIlIllIllllIll, final float lllllllllllllllIllIIlIllIlllIlIl) {
        faceBlock(lllllllllllllllIllIIlIllIlllllIl + 0.5, lllllllllllllllIllIIlIllIlllIlll + 0.5, lllllllllllllllIllIIlIllIllllIll + 0.5);
        this.moveForward();
        if (RotationUtils2.mc.thePlayer.onGround && RotationUtils2.mc.thePlayer.isCollidedHorizontally && !Keyboard.isKeyDown(RotationUtils2.mc.gameSettings.keyBindJump.getKeyCode()) && !RotationUtils2.mc.thePlayer.isInWater()) {
            RotationUtils2.mc.thePlayer.jump();
        }
        if (this.canReach(lllllllllllllllIllIIlIllIlllllIl, lllllllllllllllIllIIlIllIlllIlll, lllllllllllllllIllIIlIllIllllIll, lllllllllllllllIllIIlIllIlllIlIl)) {
            this.stopMoving();
        }
    }
    
    public static float[] getAverageRotations(final List<EntityLivingBase> lllllllllllllllIllIIlIlIIlIIIlII) {
        double lllllllllllllllIllIIlIlIIlIIlIII = 0.0;
        double lllllllllllllllIllIIlIlIIlIIIlll = 0.0;
        double lllllllllllllllIllIIlIlIIlIIIllI = 0.0;
        for (final Entity lllllllllllllllIllIIlIlIIlIIIlIl : lllllllllllllllIllIIlIlIIlIIIlII) {
            lllllllllllllllIllIIlIlIIlIIlIII += lllllllllllllllIllIIlIlIIlIIIlIl.posX;
            lllllllllllllllIllIIlIlIIlIIIlll += lllllllllllllllIllIIlIlIIlIIIlIl.boundingBox.maxY - 2.0;
            lllllllllllllllIllIIlIlIIlIIIllI += lllllllllllllllIllIIlIlIIlIIIlIl.posZ;
        }
        lllllllllllllllIllIIlIlIIlIIlIII /= lllllllllllllllIllIIlIlIIlIIIlII.size();
        lllllllllllllllIllIIlIlIIlIIIlll /= lllllllllllllllIllIIlIlIIlIIIlII.size();
        lllllllllllllllIllIIlIlIIlIIIllI /= lllllllllllllllIllIIlIlIIlIIIlII.size();
        return new float[] { getRotationFromPosition(lllllllllllllllIllIIlIlIIlIIlIII, lllllllllllllllIllIIlIlIIlIIIllI, lllllllllllllllIllIIlIlIIlIIIlll)[0], getRotationFromPosition(lllllllllllllllIllIIlIlIIlIIlIII, lllllllllllllllIllIIlIlIIlIIIllI, lllllllllllllllIllIIlIlIIlIIIlll)[1] };
    }
    
    public static float[] faceBlock(final double lllllllllllllllIllIIlIlIIlllIIlI, final double lllllllllllllllIllIIlIlIIlllllII, final double lllllllllllllllIllIIlIlIIllllIll) {
        final double lllllllllllllllIllIIlIlIIllllIlI = lllllllllllllllIllIIlIlIIlllIIlI - RotationUtils2.mc.thePlayer.posX;
        final double lllllllllllllllIllIIlIlIIllllIIl = lllllllllllllllIllIIlIlIIllllIll - RotationUtils2.mc.thePlayer.posZ;
        final double lllllllllllllllIllIIlIlIIllllIII = lllllllllllllllIllIIlIlIIlllllII - RotationUtils2.mc.thePlayer.posY + RotationUtils2.mc.thePlayer.getEyeHeight();
        final double lllllllllllllllIllIIlIlIIlllIlll = MathHelper.sqrt_double(lllllllllllllllIllIIlIlIIllllIlI * lllllllllllllllIllIIlIlIIllllIlI + lllllllllllllllIllIIlIlIIllllIIl * lllllllllllllllIllIIlIlIIllllIIl);
        final float lllllllllllllllIllIIlIlIIlllIllI = (float)(Math.atan2(lllllllllllllllIllIIlIlIIllllIIl, lllllllllllllllIllIIlIlIIllllIlI) * 180.0 / 3.141592653589793) - 90.0f;
        final float lllllllllllllllIllIIlIlIIlllIlIl = (float)(-(Math.atan2(lllllllllllllllIllIIlIlIIllllIII, lllllllllllllllIllIIlIlIIlllIlll) * 180.0 / 3.141592653589793));
        float lllllllllllllllIllIIlIlIIlllIlII = RotationUtils2.mc.thePlayer.rotationYaw;
        float lllllllllllllllIllIIlIlIIlllIIll = RotationUtils2.mc.thePlayer.rotationPitch;
        final float[] array = new float[2];
        lllllllllllllllIllIIlIlIIlllIlII = (array[0] = lllllllllllllllIllIIlIlIIlllIlII + MathHelper.wrapAngleTo180_float(lllllllllllllllIllIIlIlIIlllIllI - lllllllllllllllIllIIlIlIIlllIlII));
        lllllllllllllllIllIIlIlIIlllIIll = (array[1] = lllllllllllllllIllIIlIlIIlllIIll + MathHelper.wrapAngleTo180_float(lllllllllllllllIllIIlIlIIlllIlIl - lllllllllllllllIllIIlIlIIlllIIll));
        return array;
    }
    
    public void moveBack() {
        RotationUtils2.mc.gameSettings.keyBindBack.pressed = true;
    }
    
    public static float getTrajAngleSolutionLow(final float lllllllllllllllIllIIlIlIIIIllllI, final float lllllllllllllllIllIIlIlIIIIllIII, final float lllllllllllllllIllIIlIlIIIIlllII) {
        final float lllllllllllllllIllIIlIlIIIIllIll = 0.006f;
        final float lllllllllllllllIllIIlIlIIIIllIlI = lllllllllllllllIllIIlIlIIIIlllII * lllllllllllllllIllIIlIlIIIIlllII * lllllllllllllllIllIIlIlIIIIlllII * lllllllllllllllIllIIlIlIIIIlllII - 0.006f * (0.006f * lllllllllllllllIllIIlIlIIIIllllI * lllllllllllllllIllIIlIlIIIIllllI + 2.0f * lllllllllllllllIllIIlIlIIIIllIII * lllllllllllllllIllIIlIlIIIIlllII * lllllllllllllllIllIIlIlIIIIlllII);
        return (float)Math.toDegrees(Math.atan((lllllllllllllllIllIIlIlIIIIlllII * lllllllllllllllIllIIlIlIIIIlllII - Math.sqrt(lllllllllllllllIllIIlIlIIIIllIlI)) / (0.006f * lllllllllllllllIllIIlIlIIIIllllI)));
    }
    
    public boolean canReach(final double lllllllllllllllIllIIlIllIlIIllIl, final double lllllllllllllllIllIIlIllIlIIIllI, final double lllllllllllllllIllIIlIllIlIIIlIl, final float lllllllllllllllIllIIlIllIlIIlIlI) {
        final double lllllllllllllllIllIIlIllIlIIlIIl = this.getDistance(lllllllllllllllIllIIlIllIlIIllIl, lllllllllllllllIllIIlIllIlIIIllI, lllllllllllllllIllIIlIllIlIIIlIl);
        return lllllllllllllllIllIIlIllIlIIlIIl < lllllllllllllllIllIIlIllIlIIlIlI && lllllllllllllllIllIIlIllIlIIlIIl > -lllllllllllllllIllIIlIllIlIIlIlI;
    }
    
    public boolean isContainerEmpty(final Container lllllllllllllllIllIIlIllIlIlIlll) {
        for (int lllllllllllllllIllIIlIllIlIllIIl = 0, lllllllllllllllIllIIlIllIlIllIII = (lllllllllllllllIllIIlIllIlIlIlll.inventorySlots.size() == 90) ? 54 : 27; lllllllllllllllIllIIlIllIlIllIIl < lllllllllllllllIllIIlIllIlIllIII; ++lllllllllllllllIllIIlIllIlIllIIl) {
            if (lllllllllllllllIllIIlIllIlIlIlll.getSlot(lllllllllllllllIllIIlIllIlIllIIl).getHasStack()) {
                return false;
            }
        }
        return true;
    }
    
    public void breakBlockLegit(final int lllllllllllllllIllIIlIllIIIIIIlI, final int lllllllllllllllIllIIlIlIllllllII, final int lllllllllllllllIllIIlIllIIIIIIII, final int lllllllllllllllIllIIlIlIllllllll) {
        ++this.hitDelay;
        RotationUtils2.mc.thePlayer.swingItem();
        if (this.blockDamage == 0.0f) {
            RotationUtils2.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, this.getBlockPos(lllllllllllllllIllIIlIllIIIIIIlI, lllllllllllllllIllIIlIlIllllllII, lllllllllllllllIllIIlIllIIIIIIII), this.getEnumFacing((float)lllllllllllllllIllIIlIllIIIIIIlI, (float)lllllllllllllllIllIIlIlIllllllII, (float)lllllllllllllllIllIIlIllIIIIIIII)));
        }
        if (this.hitDelay >= lllllllllllllllIllIIlIlIllllllll) {
            this.blockDamage += this.getBlock(lllllllllllllllIllIIlIllIIIIIIlI, lllllllllllllllIllIIlIlIllllllII, lllllllllllllllIllIIlIllIIIIIIII).getPlayerRelativeBlockHardness(RotationUtils2.mc.thePlayer, RotationUtils2.mc.theWorld, new BlockPos(lllllllllllllllIllIIlIllIIIIIIlI, lllllllllllllllIllIIlIlIllllllII, lllllllllllllllIllIIlIllIIIIIIII));
            RotationUtils2.mc.theWorld.sendBlockBreakProgress(RotationUtils2.mc.thePlayer.getEntityId(), new BlockPos(lllllllllllllllIllIIlIllIIIIIIlI, lllllllllllllllIllIIlIlIllllllII, lllllllllllllllIllIIlIllIIIIIIII), (int)(this.blockDamage * 10.0f) - 1);
            if (this.blockDamage >= (RotationUtils2.mc.playerController.isInCreativeMode() ? 0.0f : 1.0f)) {
                RotationUtils2.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.getBlockPos(lllllllllllllllIllIIlIllIIIIIIlI, lllllllllllllllIllIIlIlIllllllII, lllllllllllllllIllIIlIllIIIIIIII), this.getEnumFacing((float)lllllllllllllllIllIIlIllIIIIIIlI, (float)lllllllllllllllIllIIlIlIllllllII, (float)lllllllllllllllIllIIlIllIIIIIIII)));
                RotationUtils2.mc.playerController.func_178888_a(this.getBlockPos(lllllllllllllllIllIIlIllIIIIIIlI, lllllllllllllllIllIIlIlIllllllII, lllllllllllllllIllIIlIllIIIIIIII), this.getEnumFacing((float)lllllllllllllllIllIIlIllIIIIIIlI, (float)lllllllllllllllIllIIlIlIllllllII, (float)lllllllllllllllIllIIlIllIIIIIIII));
                this.blockDamage = 0.0f;
                this.hitDelay = 0.0f;
            }
        }
    }
    
    private Float[] getRotationsTileEntity(final TileEntity lllllllllllllllIllIIlIllIIIlIllI) {
        final double lllllllllllllllIllIIlIllIIIlIlIl = lllllllllllllllIllIIlIllIIIlIllI.getPos().getX() - RotationUtils2.mc.thePlayer.posX;
        final double lllllllllllllllIllIIlIllIIIlIlII = lllllllllllllllIllIIlIllIIIlIllI.getPos().getY() - RotationUtils2.mc.thePlayer.posZ;
        final double lllllllllllllllIllIIlIllIIIlIIll = lllllllllllllllIllIIlIllIIIlIllI.getPos().getZ() + 1 - RotationUtils2.mc.thePlayer.posY + RotationUtils2.mc.thePlayer.getEyeHeight();
        final double lllllllllllllllIllIIlIllIIIlIIlI = MathHelper.sqrt_double(lllllllllllllllIllIIlIllIIIlIlIl * lllllllllllllllIllIIlIllIIIlIlIl + lllllllllllllllIllIIlIllIIIlIlII * lllllllllllllllIllIIlIllIIIlIlII);
        float lllllllllllllllIllIIlIllIIIlIIIl = (float)Math.toDegrees(-Math.atan(lllllllllllllllIllIIlIllIIIlIlIl / lllllllllllllllIllIIlIllIIIlIlII));
        final float lllllllllllllllIllIIlIllIIIlIIII = (float)(-Math.toDegrees(Math.atan(lllllllllllllllIllIIlIllIIIlIIll / lllllllllllllllIllIIlIllIIIlIIlI)));
        if (lllllllllllllllIllIIlIllIIIlIlII < 0.0 && lllllllllllllllIllIIlIllIIIlIlIl < 0.0) {
            lllllllllllllllIllIIlIllIIIlIIIl = (float)(90.0 + Math.toDegrees(Math.atan(lllllllllllllllIllIIlIllIIIlIlII / lllllllllllllllIllIIlIllIIIlIlIl)));
        }
        else if (lllllllllllllllIllIIlIllIIIlIlII < 0.0 && lllllllllllllllIllIIlIllIIIlIlIl > 0.0) {
            lllllllllllllllIllIIlIllIIIlIIIl = (float)(-90.0 + Math.toDegrees(Math.atan(lllllllllllllllIllIIlIllIIIlIlII / lllllllllllllllIllIIlIllIIIlIlIl)));
        }
        return new Float[] { lllllllllllllllIllIIlIllIIIlIIIl, lllllllllllllllIllIIlIllIIIlIIII };
    }
    
    public float getDistance(final double lllllllllllllllIllIIlIlIlIllIIII, final double lllllllllllllllIllIIlIlIlIlIlIIl, final double lllllllllllllllIllIIlIlIlIlIlllI) {
        final float lllllllllllllllIllIIlIlIlIlIllIl = (float)(RotationUtils2.mc.thePlayer.posX - lllllllllllllllIllIIlIlIlIllIIII);
        final float lllllllllllllllIllIIlIlIlIlIllII = (float)(RotationUtils2.mc.thePlayer.posY - lllllllllllllllIllIIlIlIlIlIlIIl);
        final float lllllllllllllllIllIIlIlIlIlIlIll = (float)(RotationUtils2.mc.thePlayer.posZ - lllllllllllllllIllIIlIlIlIlIlllI);
        return MathHelper.sqrt_float(lllllllllllllllIllIIlIlIlIlIllIl * lllllllllllllllIllIIlIlIlIlIllIl + lllllllllllllllIllIIlIlIlIlIllII * lllllllllllllllIllIIlIlIlIlIllII + lllllllllllllllIllIIlIlIlIlIlIll * lllllllllllllllIllIIlIlIlIlIlIll);
    }
    
    public boolean shouldHitBlock(final int lllllllllllllllIllIIlIlllIIlIIIl, final int lllllllllllllllIllIIlIlllIIlIIII, final int lllllllllllllllIllIIlIlllIIIllll, final double lllllllllllllllIllIIlIlllIIIlllI) {
        final Block lllllllllllllllIllIIlIlllIIIllIl = this.getBlock(lllllllllllllllIllIIlIlllIIlIIIl, lllllllllllllllIllIIlIlllIIlIIII, lllllllllllllllIllIIlIlllIIIllll);
        final boolean lllllllllllllllIllIIlIlllIIIllII = !(lllllllllllllllIllIIlIlllIIIllIl instanceof BlockLiquid);
        final boolean lllllllllllllllIllIIlIlllIIIlIll = this.canBlockBeSeen(lllllllllllllllIllIIlIlllIIlIIIl, lllllllllllllllIllIIlIlllIIlIIII, lllllllllllllllIllIIlIlllIIIllll);
        return lllllllllllllllIllIIlIlllIIIllII && lllllllllllllllIllIIlIlllIIIlIll;
    }
    
    public static float getDistanceBetweenAngles(final float lllllllllllllllIllIIlIlIIIIIlllI, final float lllllllllllllllIllIIlIlIIIIIllIl) {
        float lllllllllllllllIllIIlIlIIIIIllII = Math.abs(lllllllllllllllIllIIlIlIIIIIlllI - lllllllllllllllIllIIlIlIIIIIllIl) % 360.0f;
        if (lllllllllllllllIllIIlIlIIIIIllII > 180.0f) {
            lllllllllllllllIllIIlIlIIIIIllII = 360.0f - lllllllllllllllIllIIlIlIIIIIllII;
        }
        return lllllllllllllllIllIIlIlIIIIIllII;
    }
    
    public int getNextSlotInContainer(final Container lllllllllllllllIllIIlIllIllIIlII) {
        for (int lllllllllllllllIllIIlIllIllIIIll = 0, lllllllllllllllIllIIlIllIllIIIlI = (lllllllllllllllIllIIlIllIllIIlII.inventorySlots.size() == 90) ? 54 : 27; lllllllllllllllIllIIlIllIllIIIll < lllllllllllllllIllIIlIllIllIIIlI; ++lllllllllllllllIllIIlIllIllIIIll) {
            if (lllllllllllllllIllIIlIllIllIIlII.getInventory().get(lllllllllllllllIllIIlIllIllIIIll) != null) {
                return lllllllllllllllIllIIlIllIllIIIll;
            }
        }
        return -1;
    }
    
    public void moveForward() {
        RotationUtils2.mc.gameSettings.keyBindForward.pressed = true;
    }
    
    public void stopMoving() {
        RotationUtils2.mc.gameSettings.keyBindForward.pressed = false;
        RotationUtils2.mc.gameSettings.keyBindLeft.pressed = false;
        RotationUtils2.mc.gameSettings.keyBindRight.pressed = false;
        RotationUtils2.mc.gameSettings.keyBindBack.pressed = false;
    }
    
    public void moveLeft() {
        RotationUtils2.mc.gameSettings.keyBindLeft.pressed = true;
    }
    
    public static float[] getRotations(final EntityLivingBase lllllllllllllllIllIIlIlIIlIlIIll) {
        final double lllllllllllllllIllIIlIlIIlIlIllI = lllllllllllllllIllIIlIlIIlIlIIll.posX;
        final double lllllllllllllllIllIIlIlIIlIlIlIl = lllllllllllllllIllIIlIlIIlIlIIll.posZ;
        final double lllllllllllllllIllIIlIlIIlIlIlII = lllllllllllllllIllIIlIlIIlIlIIll.posY + lllllllllllllllIllIIlIlIIlIlIIll.getEyeHeight() / 2.0f - 0.5;
        return getRotationFromPosition(lllllllllllllllIllIIlIlIIlIlIllI, lllllllllllllllIllIIlIlIIlIlIlIl, lllllllllllllllIllIIlIlIIlIlIlII);
    }
}
