package hawk.util;

import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import optifine.*;
import net.minecraft.client.entity.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import java.util.*;

public class BlockUtils2
{
    private /* synthetic */ List<Block> invalid;
    public static /* synthetic */ Minecraft mc;
    private static /* synthetic */ ReflectorClass ForgeBlock;
    private static /* synthetic */ ReflectorMethod ForgeBlock_setLightOpacity;
    private static /* synthetic */ boolean directAccessValid;
    
    public Block getBlockByIDorName(final String llllllllllllllIIlIIIIlIllIIIIIIl) {
        Block llllllllllllllIIlIIIIlIllIIIIIII = null;
        try {
            llllllllllllllIIlIIIIlIllIIIIIII = Block.getBlockById(Integer.parseInt(llllllllllllllIIlIIIIlIllIIIIIIl));
        }
        catch (NumberFormatException llllllllllllllIIlIIIIlIlIlllllll) {
            Block llllllllllllllIIlIIIIlIlIllllllI = null;
            for (final Object llllllllllllllIIlIIIIlIlIlllllIl : Block.blockRegistry) {
                llllllllllllllIIlIIIIlIlIllllllI = (Block)llllllllllllllIIlIIIIlIlIlllllIl;
                final String llllllllllllllIIlIIIIlIlIlllllII = llllllllllllllIIlIIIIlIlIllllllI.getLocalizedName().replace(" ", "");
                if (llllllllllllllIIlIIIIlIlIlllllII.toLowerCase().startsWith(llllllllllllllIIlIIIIlIllIIIIIIl)) {
                    break;
                }
                if (llllllllllllllIIlIIIIlIlIlllllII.toLowerCase().contains(llllllllllllllIIlIIIIlIllIIIIIIl)) {
                    break;
                }
            }
            if (llllllllllllllIIlIIIIlIlIllllllI != null) {
                llllllllllllllIIlIIIIlIllIIIIIII = llllllllllllllIIlIIIIlIlIllllllI;
            }
        }
        return llllllllllllllIIlIIIIlIllIIIIIII;
    }
    
    public static boolean isOnIce() {
        if (BlockUtils2.mc.thePlayer == null) {
            return false;
        }
        boolean llllllllllllllIIlIIIIlIllIlIIlll = false;
        final int llllllllllllllIIlIIIIlIllIlIIllI = (int)BlockUtils2.mc.thePlayer.getEntityBoundingBox().offset(0.0, -0.01, 0.0).minY;
        for (int llllllllllllllIIlIIIIlIllIlIIlIl = MathHelper.floor_double(BlockUtils2.mc.thePlayer.getEntityBoundingBox().minX); llllllllllllllIIlIIIIlIllIlIIlIl < MathHelper.floor_double(BlockUtils2.mc.thePlayer.getEntityBoundingBox().maxX) + 1; ++llllllllllllllIIlIIIIlIllIlIIlIl) {
            for (int llllllllllllllIIlIIIIlIllIlIIlII = MathHelper.floor_double(BlockUtils2.mc.thePlayer.getEntityBoundingBox().minZ); llllllllllllllIIlIIIIlIllIlIIlII < MathHelper.floor_double(BlockUtils2.mc.thePlayer.getEntityBoundingBox().maxZ) + 1; ++llllllllllllllIIlIIIIlIllIlIIlII) {
                final Block llllllllllllllIIlIIIIlIllIlIIIll = getBlock(llllllllllllllIIlIIIIlIllIlIIlIl, llllllllllllllIIlIIIIlIllIlIIllI, llllllllllllllIIlIIIIlIllIlIIlII);
                if (llllllllllllllIIlIIIIlIllIlIIIll != null && !(llllllllllllllIIlIIIIlIllIlIIIll instanceof BlockAir)) {
                    if (!(llllllllllllllIIlIIIIlIllIlIIIll instanceof BlockIce) && !(llllllllllllllIIlIIIIlIllIlIIIll instanceof BlockPackedIce)) {
                        return false;
                    }
                    llllllllllllllIIlIIIIlIllIlIIlll = true;
                }
            }
        }
        return llllllllllllllIIlIIIIlIllIlIIlll;
    }
    
    public static boolean isOnLadder() {
        if (BlockUtils2.mc.thePlayer == null) {
            return false;
        }
        boolean llllllllllllllIIlIIIIlIllIllIllI = false;
        final int llllllllllllllIIlIIIIlIllIllIlIl = (int)BlockUtils2.mc.thePlayer.getEntityBoundingBox().offset(0.0, 1.0, 0.0).minY;
        for (int llllllllllllllIIlIIIIlIllIllIlII = MathHelper.floor_double(BlockUtils2.mc.thePlayer.getEntityBoundingBox().minX); llllllllllllllIIlIIIIlIllIllIlII < MathHelper.floor_double(BlockUtils2.mc.thePlayer.getEntityBoundingBox().maxX) + 1; ++llllllllllllllIIlIIIIlIllIllIlII) {
            for (int llllllllllllllIIlIIIIlIllIllIIll = MathHelper.floor_double(BlockUtils2.mc.thePlayer.getEntityBoundingBox().minZ); llllllllllllllIIlIIIIlIllIllIIll < MathHelper.floor_double(BlockUtils2.mc.thePlayer.getEntityBoundingBox().maxZ) + 1; ++llllllllllllllIIlIIIIlIllIllIIll) {
                final Block llllllllllllllIIlIIIIlIllIllIIlI = getBlock(llllllllllllllIIlIIIIlIllIllIlII, llllllllllllllIIlIIIIlIllIllIlIl, llllllllllllllIIlIIIIlIllIllIIll);
                if (llllllllllllllIIlIIIIlIllIllIIlI != null && !(llllllllllllllIIlIIIIlIllIllIIlI instanceof BlockAir)) {
                    if (!(llllllllllllllIIlIIIIlIllIllIIlI instanceof BlockLadder) && !(llllllllllllllIIlIIIIlIllIllIIlI instanceof BlockVine)) {
                        return false;
                    }
                    llllllllllllllIIlIIIIlIllIllIllI = true;
                }
            }
        }
        return llllllllllllllIIlIIIIlIllIllIllI || BlockUtils2.mc.thePlayer.isOnLadder();
    }
    
    public static boolean canSeeBlock(final float llllllllllllllIIlIIIIlIlIllIlIII, final float llllllllllllllIIlIIIIlIlIllIlIlI, final float llllllllllllllIIlIIIIlIlIllIlIIl) {
        return getFacing(new BlockPos(llllllllllllllIIlIIIIlIlIllIlIII, llllllllllllllIIlIIIIlIlIllIlIlI, llllllllllllllIIlIIIIlIlIllIlIIl)) != null;
    }
    
    public static Block getBlockAtPosC(final EntityPlayer llllllllllllllIIlIIIIlIlIIlIIIll, final double llllllllllllllIIlIIIIlIlIIIllllI, final double llllllllllllllIIlIIIIlIlIIlIIIIl, final double llllllllllllllIIlIIIIlIlIIIlllII) {
        return getBlock(new BlockPos(llllllllllllllIIlIIIIlIlIIlIIIll.posX - llllllllllllllIIlIIIIlIlIIIllllI, llllllllllllllIIlIIIIlIlIIlIIIll.posY - llllllllllllllIIlIIIIlIlIIlIIIIl, llllllllllllllIIlIIIIlIlIIlIIIll.posZ - llllllllllllllIIlIIIIlIlIIIlllII));
    }
    
    public static BlockData getBlockData(final BlockPos llllllllllllllIIlIIIIlIlIIlIlIll, final List llllllllllllllIIlIIIIlIlIIlIlIlI) {
        return llllllllllllllIIlIIIIlIlIIlIlIlI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIIlIlIll.add(0, -1, 0)).getBlock()) ? (llllllllllllllIIlIIIIlIlIIlIlIlI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIIlIlIll.add(-1, 0, 0)).getBlock()) ? (llllllllllllllIIlIIIIlIlIIlIlIlI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIIlIlIll.add(1, 0, 0)).getBlock()) ? (llllllllllllllIIlIIIIlIlIIlIlIlI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIIlIlIll.add(0, 0, -1)).getBlock()) ? (llllllllllllllIIlIIIIlIlIIlIlIlI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIIlIlIll.add(0, 0, 1)).getBlock()) ? null : new BlockData(llllllllllllllIIlIIIIlIlIIlIlIll.add(0, 0, 1), EnumFacing.NORTH)) : new BlockData(llllllllllllllIIlIIIIlIlIIlIlIll.add(0, 0, -1), EnumFacing.SOUTH)) : new BlockData(llllllllllllllIIlIIIIlIlIIlIlIll.add(1, 0, 0), EnumFacing.WEST)) : new BlockData(llllllllllllllIIlIIIIlIlIIlIlIll.add(-1, 0, 0), EnumFacing.EAST)) : new BlockData(llllllllllllllIIlIIIIlIlIIlIlIll.add(0, -1, 0), EnumFacing.UP);
    }
    
    public static EnumFacing getFacing(final BlockPos llllllllllllllIIlIIIIlIlIlIlIlll) {
        final EnumFacing[] llllllllllllllIIlIIIIlIlIlIlllII;
        final EnumFacing[] llllllllllllllIIlIIIIlIlIlIlllIl = llllllllllllllIIlIIIIlIlIlIlllII = new EnumFacing[] { EnumFacing.UP, EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST, EnumFacing.DOWN };
        for (int llllllllllllllIIlIIIIlIlIlIllIll = llllllllllllllIIlIIIIlIlIlIlllIl.length, llllllllllllllIIlIIIIlIlIlIllIlI = 0; llllllllllllllIIlIIIIlIlIlIllIlI < llllllllllllllIIlIIIIlIlIlIllIll; ++llllllllllllllIIlIIIIlIlIlIllIlI) {
            final EnumFacing llllllllllllllIIlIIIIlIlIlIllIIl = llllllllllllllIIlIIIIlIlIlIlllII[llllllllllllllIIlIIIIlIlIlIllIlI];
            final EntitySnowball llllllllllllllIIlIIIIlIlIlIllIII = new EntitySnowball(BlockUtils2.mc.theWorld);
            llllllllllllllIIlIIIIlIlIlIllIII.posX = llllllllllllllIIlIIIIlIlIlIlIlll.getX() + 0.5;
            llllllllllllllIIlIIIIlIlIlIllIII.posY = llllllllllllllIIlIIIIlIlIlIlIlll.getY() + 0.5;
            llllllllllllllIIlIIIIlIlIlIllIII.posZ = llllllllllllllIIlIIIIlIlIlIlIlll.getZ() + 0.5;
            final EntitySnowball entitySnowball = llllllllllllllIIlIIIIlIlIlIllIII;
            entitySnowball.posX += llllllllllllllIIlIIIIlIlIlIllIIl.getDirectionVec().getX() * 0.5;
            final EntitySnowball entitySnowball2 = llllllllllllllIIlIIIIlIlIlIllIII;
            entitySnowball2.posY += llllllllllllllIIlIIIIlIlIlIllIIl.getDirectionVec().getY() * 0.5;
            final EntitySnowball entitySnowball3 = llllllllllllllIIlIIIIlIlIlIllIII;
            entitySnowball3.posZ += llllllllllllllIIlIIIIlIlIlIllIIl.getDirectionVec().getZ() * 0.5;
            if (BlockUtils2.mc.thePlayer.canEntityBeSeen(llllllllllllllIIlIIIIlIlIlIllIII)) {
                return llllllllllllllIIlIIIIlIlIlIllIIl;
            }
        }
        return null;
    }
    
    public BlockData getBlockData1(final BlockPos llllllllllllllIIlIIIIlIlIlIIIlll) {
        final List<Block> llllllllllllllIIlIIIIlIlIlIIIllI = this.invalid;
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlll.add(0, -1, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlll.add(0, -1, 0), EnumFacing.UP);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlll.add(-1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlll.add(-1, 0, 0), EnumFacing.EAST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlll.add(1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlll.add(1, 0, 0), EnumFacing.WEST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlll.add(0, 0, -1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlll.add(0, 0, -1), EnumFacing.SOUTH);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlll.add(0, 0, 1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlll.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockPos llllllllllllllIIlIIIIlIlIlIIIlIl = llllllllllllllIIlIIIIlIlIlIIIlll.add(-1, 0, 0);
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlIl.add(-1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlIl.add(-1, 0, 0), EnumFacing.EAST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlIl.add(1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlIl.add(1, 0, 0), EnumFacing.WEST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlIl.add(0, 0, -1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlIl.add(0, 0, -1), EnumFacing.SOUTH);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlIl.add(0, 0, 1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlIl.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockPos llllllllllllllIIlIIIIlIlIlIIIlII = llllllllllllllIIlIIIIlIlIlIIIlll.add(1, 0, 0);
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlII.add(-1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlII.add(-1, 0, 0), EnumFacing.EAST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlII.add(1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlII.add(1, 0, 0), EnumFacing.WEST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlII.add(0, 0, -1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlII.add(0, 0, -1), EnumFacing.SOUTH);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIlII.add(0, 0, 1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIlII.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockPos llllllllllllllIIlIIIIlIlIlIIIIll = llllllllllllllIIlIIIIlIlIlIIIlll.add(0, 0, -1);
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIIll.add(-1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIIll.add(-1, 0, 0), EnumFacing.EAST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIIll.add(1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIIll.add(1, 0, 0), EnumFacing.WEST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIIll.add(0, 0, -1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIIll.add(0, 0, -1), EnumFacing.SOUTH);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIIll.add(0, 0, 1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIIll.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockPos llllllllllllllIIlIIIIlIlIlIIIIlI = llllllllllllllIIlIIIIlIlIlIIIlll.add(0, 0, 1);
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIIlI.add(-1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIIlI.add(-1, 0, 0), EnumFacing.EAST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIIlI.add(1, 0, 0)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIIlI.add(1, 0, 0), EnumFacing.WEST);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIIlI.add(0, 0, -1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIIlI.add(0, 0, -1), EnumFacing.SOUTH);
        }
        Minecraft.getMinecraft();
        if (!llllllllllllllIIlIIIIlIlIlIIIllI.contains(BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIlIIIIlI.add(0, 0, 1)).getBlock())) {
            return new BlockData(llllllllllllllIIlIIIIlIlIlIIIIlI.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockData llllllllllllllIIlIIIIlIlIlIIIIIl = null;
        return llllllllllllllIIlIIIIlIlIlIIIIIl;
    }
    
    public static float changeRotation(final float llllllllllllllIIlIIIIlIllllIllIl, final float llllllllllllllIIlIIIIlIllllIlIII, final float llllllllllllllIIlIIIIlIllllIlIll) {
        float llllllllllllllIIlIIIIlIllllIlIlI = MathHelper.wrapAngleTo180_float(llllllllllllllIIlIIIIlIllllIlIII - llllllllllllllIIlIIIIlIllllIllIl);
        if (llllllllllllllIIlIIIIlIllllIlIlI > llllllllllllllIIlIIIIlIllllIlIll) {
            llllllllllllllIIlIIIIlIllllIlIlI = llllllllllllllIIlIIIIlIllllIlIll;
        }
        if (llllllllllllllIIlIIIIlIllllIlIlI < -llllllllllllllIIlIIIIlIllllIlIll) {
            llllllllllllllIIlIIIIlIllllIlIlI = -llllllllllllllIIlIIIIlIllllIlIll;
        }
        return llllllllllllllIIlIIIIlIllllIllIl + llllllllllllllIIlIIIIlIllllIlIlI;
    }
    
    public static float[] getFacingRotations(final int llllllllllllllIIlIIIIlIlllIllIll, final int llllllllllllllIIlIIIIlIlllIllIlI, final int llllllllllllllIIlIIIIlIlllIllIIl, final EnumFacing llllllllllllllIIlIIIIlIlllIllIII) {
        final EntitySnowball llllllllllllllIIlIIIIlIlllIlllII = new EntitySnowball(BlockUtils2.mc.theWorld);
        llllllllllllllIIlIIIIlIlllIlllII.posX = llllllllllllllIIlIIIIlIlllIllIll + 0.5;
        llllllllllllllIIlIIIIlIlllIlllII.posY = llllllllllllllIIlIIIIlIlllIllIlI + 0.5;
        llllllllllllllIIlIIIIlIlllIlllII.posZ = llllllllllllllIIlIIIIlIlllIllIIl + 0.5;
        final EntitySnowball entitySnowball = llllllllllllllIIlIIIIlIlllIlllII;
        entitySnowball.posX += llllllllllllllIIlIIIIlIlllIllIII.getDirectionVec().getX() * 0.25;
        final EntitySnowball entitySnowball2 = llllllllllllllIIlIIIIlIlllIlllII;
        entitySnowball2.posY += llllllllllllllIIlIIIIlIlllIllIII.getDirectionVec().getY() * 0.25;
        final EntitySnowball entitySnowball3 = llllllllllllllIIlIIIIlIlllIlllII;
        entitySnowball3.posZ += llllllllllllllIIlIIIIlIlllIllIII.getDirectionVec().getZ() * 0.25;
        return faceTarget(llllllllllllllIIlIIIIlIlllIlllII, 100.0f, 100.0f, false);
    }
    
    public void onEvent(final Event llllllllllllllIIlIIIIllIIIlIIlII) {
        if (llllllllllllllIIlIIIIllIIIlIIlII instanceof EventMotion) {
            final boolean llllllllllllllIIlIIIIllIIIlIIIlI = (boolean)llllllllllllllIIlIIIIllIIIlIIlII;
        }
    }
    
    public static Block getBlockAbovePlayer(final EntityPlayer llllllllllllllIIlIIIIlIlIIIlIIIl, final double llllllllllllllIIlIIIIlIlIIIlIIlI) {
        return getBlock(new BlockPos(llllllllllllllIIlIIIIlIlIIIlIIIl.posX, llllllllllllllIIlIIIIlIlIIIlIIIl.posY + llllllllllllllIIlIIIIlIlIIIlIIIl.height + llllllllllllllIIlIIIIlIlIIIlIIlI, llllllllllllllIIlIIIIlIlIIIlIIIl.posZ));
    }
    
    public int getBlockSlot() {
        for (int llllllllllllllIIlIIIIlIlIIllIlIl = 36; llllllllllllllIIlIIIIlIlIIllIlIl < 45; ++llllllllllllllIIlIIIIlIlIIllIlIl) {
            Minecraft.getMinecraft();
            final ItemStack llllllllllllllIIlIIIIlIlIIllIlII = BlockUtils2.mc.thePlayer.inventoryContainer.getSlot(llllllllllllllIIlIIIIlIlIIllIlIl).getStack();
            if (llllllllllllllIIlIIIIlIlIIllIlII != null && llllllllllllllIIlIIIIlIlIIllIlII.getItem() instanceof ItemBlock) {
                return llllllllllllllIIlIIIIlIlIIllIlIl - 36;
            }
        }
        return -1;
    }
    
    public boolean isInsideBlock() {
        for (int llllllllllllllIIlIIIIlIllIIlIIll = MathHelper.floor_double(BlockUtils2.mc.thePlayer.boundingBox.minX); llllllllllllllIIlIIIIlIllIIlIIll < MathHelper.floor_double(BlockUtils2.mc.thePlayer.boundingBox.maxX) + 1; ++llllllllllllllIIlIIIIlIllIIlIIll) {
            for (int llllllllllllllIIlIIIIlIllIIlIIlI = MathHelper.floor_double(BlockUtils2.mc.thePlayer.boundingBox.minY); llllllllllllllIIlIIIIlIllIIlIIlI < MathHelper.floor_double(BlockUtils2.mc.thePlayer.boundingBox.maxY) + 1; ++llllllllllllllIIlIIIIlIllIIlIIlI) {
                for (int llllllllllllllIIlIIIIlIllIIlIIIl = MathHelper.floor_double(BlockUtils2.mc.thePlayer.boundingBox.minZ); llllllllllllllIIlIIIIlIllIIlIIIl < MathHelper.floor_double(BlockUtils2.mc.thePlayer.boundingBox.maxZ) + 1; ++llllllllllllllIIlIIIIlIllIIlIIIl) {
                    final Block llllllllllllllIIlIIIIlIllIIlIIII = BlockUtils2.mc.theWorld.getBlockState(new BlockPos(llllllllllllllIIlIIIIlIllIIlIIll, llllllllllllllIIlIIIIlIllIIlIIlI, llllllllllllllIIlIIIIlIllIIlIIIl)).getBlock();
                    final AxisAlignedBB llllllllllllllIIlIIIIlIllIIIllll;
                    if (llllllllllllllIIlIIIIlIllIIlIIII != null && !(llllllllllllllIIlIIIIlIllIIlIIII instanceof BlockAir) && (llllllllllllllIIlIIIIlIllIIIllll = llllllllllllllIIlIIIIlIllIIlIIII.getCollisionBoundingBox(BlockUtils2.mc.theWorld, new BlockPos(llllllllllllllIIlIIIIlIllIIlIIll, llllllllllllllIIlIIIIlIllIIlIIlI, llllllllllllllIIlIIIIlIllIIlIIIl), BlockUtils2.mc.theWorld.getBlockState(new BlockPos(llllllllllllllIIlIIIIlIllIIlIIll, llllllllllllllIIlIIIIlIllIIlIIlI, llllllllllllllIIlIIIIlIllIIlIIIl)))) != null && BlockUtils2.mc.thePlayer.boundingBox.intersectsWith(llllllllllllllIIlIIIIlIllIIIllll)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean isOnLiquid() {
        boolean llllllllllllllIIlIIIIlIllIllllIl = false;
        if (getBlockAtPosC(BlockUtils2.mc.thePlayer, 0.30000001192092896, 0.10000000149011612, 0.30000001192092896).getMaterial().isLiquid() && getBlockAtPosC(BlockUtils2.mc.thePlayer, -0.30000001192092896, 0.10000000149011612, -0.30000001192092896).getMaterial().isLiquid()) {
            llllllllllllllIIlIIIIlIllIllllIl = true;
        }
        return llllllllllllllIIlIIIIlIllIllllIl;
    }
    
    public static void setLightOpacity(final Block llllllllllllllIIlIIIIllIIIIllllI, final int llllllllllllllIIlIIIIllIIIIlllIl) {
        if (BlockUtils2.directAccessValid) {
            try {
                llllllllllllllIIlIIIIllIIIIllllI.setLightOpacity(llllllllllllllIIlIIIIllIIIIlllIl);
                return;
            }
            catch (IllegalAccessError llllllllllllllIIlIIIIllIIIIlllII) {
                BlockUtils2.directAccessValid = false;
                if (!BlockUtils2.ForgeBlock_setLightOpacity.exists()) {
                    throw llllllllllllllIIlIIIIllIIIIlllII;
                }
            }
        }
        Reflector.callVoid(llllllllllllllIIlIIIIllIIIIllllI, BlockUtils2.ForgeBlock_setLightOpacity, llllllllllllllIIlIIIIllIIIIlllIl);
    }
    
    static {
        BlockUtils2.ForgeBlock = new ReflectorClass(Block.class);
        BlockUtils2.ForgeBlock_setLightOpacity = new ReflectorMethod(BlockUtils2.ForgeBlock, "setLightOpacity");
        BlockUtils2.directAccessValid = true;
    }
    
    public int getBestSlot() {
        Minecraft.getMinecraft();
        if (BlockUtils2.mc.thePlayer.getHeldItem().getItem() instanceof ItemBlock) {
            Minecraft.getMinecraft();
            return BlockUtils2.mc.thePlayer.inventory.currentItem;
        }
        for (int llllllllllllllIIlIIIIlIlIIlIllll = 0; llllllllllllllIIlIIIIlIlIIlIllll < 8; ++llllllllllllllIIlIIIIlIlIIlIllll) {
            Minecraft.getMinecraft();
            if (BlockUtils2.mc.thePlayer.inventory.getStackInSlot(llllllllllllllIIlIIIIlIlIIlIllll) != null) {
                Minecraft.getMinecraft();
                if (BlockUtils2.mc.thePlayer.inventory.getStackInSlot(llllllllllllllIIlIIIIlIlIIlIllll).getItem() instanceof ItemBlock) {
                    return llllllllllllllIIlIIIIlIlIIlIllll;
                }
            }
        }
        return -1;
    }
    
    public static Block getBlockUnderPlayer(final EntityPlayer llllllllllllllIIlIIIIlIlIIIllIIl, final double llllllllllllllIIlIIIIlIlIIIllIII) {
        return getBlock(new BlockPos(llllllllllllllIIlIIIIlIlIIIllIIl.posX, llllllllllllllIIlIIIIlIlIIIllIIl.posY - llllllllllllllIIlIIIIlIlIIIllIII, llllllllllllllIIlIIIIlIlIIIllIIl.posZ));
    }
    
    public static Block getBlock(final BlockPos llllllllllllllIIlIIIIlIlIIIIIlII) {
        return BlockUtils2.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlIlIIIIIlII).getBlock();
    }
    
    public static Block getBlock(final int llllllllllllllIIlIIIIlIlIIIIllII, final int llllllllllllllIIlIIIIlIlIIIIlIII, final int llllllllllllllIIlIIIIlIlIIIIIlll) {
        return BlockUtils2.mc.theWorld.getBlockState(new BlockPos(llllllllllllllIIlIIIIlIlIIIIllII, llllllllllllllIIlIIIIlIlIIIIlIII, llllllllllllllIIlIIIIlIlIIIIIlll)).getBlock();
    }
    
    public static float[] getAngles(final EntityPlayerSP llllllllllllllIIlIIIIlIlllIIlllI, final BlockPos llllllllllllllIIlIIIIlIlllIIIlIl) {
        final double llllllllllllllIIlIIIIlIlllIIllII = llllllllllllllIIlIIIIlIlllIIIlIl.getX() + 0.5 - llllllllllllllIIlIIIIlIlllIIlllI.posX;
        final double llllllllllllllIIlIIIIlIlllIIlIll = llllllllllllllIIlIIIIlIlllIIIlIl.getY() - llllllllllllllIIlIIIIlIlllIIlllI.posY + llllllllllllllIIlIIIIlIlllIIlllI.getEyeHeight();
        final double llllllllllllllIIlIIIIlIlllIIlIlI = llllllllllllllIIlIIIIlIlllIIIlIl.getZ() + 0.5 - llllllllllllllIIlIIIIlIlllIIlllI.posZ;
        final double llllllllllllllIIlIIIIlIlllIIlIIl = Math.sqrt(llllllllllllllIIlIIIIlIlllIIllII * llllllllllllllIIlIIIIlIlllIIllII + llllllllllllllIIlIIIIlIlllIIlIlI * llllllllllllllIIlIIIIlIlllIIlIlI);
        final float llllllllllllllIIlIIIIlIlllIIlIII = (float)(Math.atan2(llllllllllllllIIlIIIIlIlllIIlIlI, llllllllllllllIIlIIIIlIlllIIllII) * 180.0 / 3.141592653589793) - 90.0f;
        final float llllllllllllllIIlIIIIlIlllIIIlll = (float)(-(Math.atan2(llllllllllllllIIlIIIIlIlllIIlIll, llllllllllllllIIlIIIIlIlllIIlIIl) * 180.0 / 3.141592653589793));
        return new float[] { llllllllllllllIIlIIIIlIlllIIlIII, llllllllllllllIIlIIIIlIlllIIIlll };
    }
    
    public static float[] faceTarget(final Entity llllllllllllllIIlIIIIllIIIIIllII, final float llllllllllllllIIlIIIIlIllllllIll, final float llllllllllllllIIlIIIIlIllllllIlI, final boolean llllllllllllllIIlIIIIllIIIIIlIIl) {
        final double llllllllllllllIIlIIIIllIIIIIIllI = llllllllllllllIIlIIIIllIIIIIllII.posX - BlockUtils2.mc.thePlayer.posX;
        final double llllllllllllllIIlIIIIllIIIIIIlIl = llllllllllllllIIlIIIIllIIIIIllII.posZ - BlockUtils2.mc.thePlayer.posZ;
        double llllllllllllllIIlIIIIllIIIIIIlll = 0.0;
        if (llllllllllllllIIlIIIIllIIIIIllII instanceof EntityLivingBase) {
            final EntityLivingBase llllllllllllllIIlIIIIllIIIIIIlII = (EntityLivingBase)llllllllllllllIIlIIIIllIIIIIllII;
            final double llllllllllllllIIlIIIIllIIIIIlIII = llllllllllllllIIlIIIIllIIIIIIlII.posY + llllllllllllllIIlIIIIllIIIIIIlII.getEyeHeight() - (BlockUtils2.mc.thePlayer.posY + BlockUtils2.mc.thePlayer.getEyeHeight());
        }
        else {
            llllllllllllllIIlIIIIllIIIIIIlll = (llllllllllllllIIlIIIIllIIIIIllII.getEntityBoundingBox().minY + llllllllllllllIIlIIIIllIIIIIllII.getEntityBoundingBox().maxY) / 2.0 - (BlockUtils2.mc.thePlayer.posY + BlockUtils2.mc.thePlayer.getEyeHeight());
        }
        final Random llllllllllllllIIlIIIIllIIIIIIIll = new Random();
        final double llllllllllllllIIlIIIIllIIIIIIIlI = MathHelper.sqrt_double(llllllllllllllIIlIIIIllIIIIIIllI * llllllllllllllIIlIIIIllIIIIIIllI + llllllllllllllIIlIIIIllIIIIIIlIl * llllllllllllllIIlIIIIllIIIIIIlIl);
        final float llllllllllllllIIlIIIIllIIIIIIIIl = (float)(Math.atan2(llllllllllllllIIlIIIIllIIIIIIlIl, llllllllllllllIIlIIIIllIIIIIIllI) * 180.0 / 3.141592653589793) - 90.0f;
        final float llllllllllllllIIlIIIIllIIIIIIIII = (float)(-(Math.atan2(llllllllllllllIIlIIIIllIIIIIIlll - ((llllllllllllllIIlIIIIllIIIIIllII instanceof EntityPlayer) ? 0.25 : 0.0), llllllllllllllIIlIIIIllIIIIIIIlI) * 180.0 / 3.141592653589793));
        final float llllllllllllllIIlIIIIlIlllllllll = changeRotation(BlockUtils2.mc.thePlayer.rotationPitch, llllllllllllllIIlIIIIllIIIIIIIII, llllllllllllllIIlIIIIlIllllllIlI);
        final float llllllllllllllIIlIIIIlIllllllllI = changeRotation(BlockUtils2.mc.thePlayer.rotationYaw, llllllllllllllIIlIIIIllIIIIIIIIl, llllllllllllllIIlIIIIlIllllllIll);
        return new float[] { llllllllllllllIIlIIIIlIllllllllI, llllllllllllllIIlIIIIlIlllllllll };
    }
    
    public static boolean isBlockUnderPlayer(final Material llllllllllllllIIlIIIIlIlIlllIIII, final float llllllllllllllIIlIIIIlIlIllIllll) {
        return getBlockAtPosC(BlockUtils2.mc.thePlayer, 0.3100000023841858, llllllllllllllIIlIIIIlIlIllIllll, 0.3100000023841858).getMaterial() == llllllllllllllIIlIIIIlIlIlllIIII && getBlockAtPosC(BlockUtils2.mc.thePlayer, -0.3100000023841858, llllllllllllllIIlIIIIlIlIllIllll, -0.3100000023841858).getMaterial() == llllllllllllllIIlIIIIlIlIlllIIII && getBlockAtPosC(BlockUtils2.mc.thePlayer, -0.3100000023841858, llllllllllllllIIlIIIIlIlIllIllll, 0.3100000023841858).getMaterial() == llllllllllllllIIlIIIIlIlIlllIIII && getBlockAtPosC(BlockUtils2.mc.thePlayer, 0.3100000023841858, llllllllllllllIIlIIIIlIlIllIllll, -0.3100000023841858).getMaterial() == llllllllllllllIIlIIIIlIlIlllIIII;
    }
    
    public BlockUtils2() {
        this.invalid = Arrays.asList(Blocks.air, Blocks.water, Blocks.fire, Blocks.flowing_water, Blocks.lava, Blocks.flowing_lava, Blocks.chest, Blocks.anvil, Blocks.enchanting_table);
    }
    
    public static class BlockData
    {
        public /* synthetic */ EnumFacing face;
        public /* synthetic */ BlockPos position;
        
        public BlockData(final BlockPos llllllllllllllllIlIIIIlllIIlIIIl, final EnumFacing llllllllllllllllIlIIIIlllIIlIIII) {
            this.position = llllllllllllllllIlIIIIlllIIlIIIl;
            this.face = llllllllllllllllIlIIIIlllIIlIIII;
        }
    }
}
