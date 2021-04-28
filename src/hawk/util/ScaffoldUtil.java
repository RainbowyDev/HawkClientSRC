package hawk.util;

import net.minecraft.block.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import java.util.*;

public class ScaffoldUtil
{
    private static /* synthetic */ List<Block> blockBlacklist;
    private static /* synthetic */ Minecraft mc;
    
    public static boolean contains(final Block llllllllllllllllllIlIlIlIIlIIIlI) {
        return ScaffoldUtil.blockBlacklist.contains(llllllllllllllllllIlIlIlIIlIIIlI);
    }
    
    public static boolean invCheck() {
        for (int llllllllllllllllllIlIlIlIIlIlIIl = 36; llllllllllllllllllIlIlIlIIlIlIIl < 45; ++llllllllllllllllllIlIlIlIIlIlIIl) {
            if (ScaffoldUtil.mc.thePlayer.inventoryContainer.getSlot(llllllllllllllllllIlIlIlIIlIlIIl).getHasStack() && isValid(ScaffoldUtil.mc.thePlayer.inventoryContainer.getSlot(llllllllllllllllllIlIlIlIIlIlIIl).getStack())) {
                return false;
            }
        }
        return true;
    }
    
    public static Vec3d getVec3d(final BlockPos llllllllllllllllllIlIlIlIIllIlIl, final EnumFacing llllllllllllllllllIlIlIlIIlllIIl) {
        double llllllllllllllllllIlIlIlIIlllIII = llllllllllllllllllIlIlIlIIllIlIl.getX() + 0.5026836562;
        double llllllllllllllllllIlIlIlIIllIlll = llllllllllllllllllIlIlIlIIllIlIl.getY() + 0.5026836562;
        double llllllllllllllllllIlIlIlIIllIllI = llllllllllllllllllIlIlIlIIllIlIl.getZ() + 0.5026836562;
        llllllllllllllllllIlIlIlIIlllIII += llllllllllllllllllIlIlIlIIlllIIl.getFrontOffsetX() / 2.0;
        llllllllllllllllllIlIlIlIIllIllI += llllllllllllllllllIlIlIlIIlllIIl.getFrontOffsetZ() / 2.0;
        llllllllllllllllllIlIlIlIIllIlll += llllllllllllllllllIlIlIlIIlllIIl.getFrontOffsetY() / 2.0;
        if (llllllllllllllllllIlIlIlIIlllIIl == EnumFacing.UP || llllllllllllllllllIlIlIlIIlllIIl == EnumFacing.DOWN) {
            llllllllllllllllllIlIlIlIIlllIII += randomNumber(0.30526836562, -0.30526836562);
            llllllllllllllllllIlIlIlIIllIllI += randomNumber(0.30526836562, -0.30526836562);
        }
        else {
            llllllllllllllllllIlIlIlIIllIlll += randomNumber(0.30526836562, -0.30526836562);
        }
        if (llllllllllllllllllIlIlIlIIlllIIl == EnumFacing.WEST || llllllllllllllllllIlIlIlIIlllIIl == EnumFacing.EAST) {
            llllllllllllllllllIlIlIlIIllIllI += randomNumber(0.30526836562, -0.30526836562);
        }
        if (llllllllllllllllllIlIlIlIIlllIIl == EnumFacing.SOUTH || llllllllllllllllllIlIlIlIIlllIIl == EnumFacing.NORTH) {
            llllllllllllllllllIlIlIlIIlllIII += randomNumber(0.30526836562, -0.30526836562);
        }
        return new Vec3d(llllllllllllllllllIlIlIlIIlllIII, llllllllllllllllllIlIlIlIIllIlll, llllllllllllllllllIlIlIlIIllIllI);
    }
    
    public static BlockInfo getBlockData(final BlockPos llllllllllllllllllIlIlIlIlIIllII) {
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIllII.add(0, -1, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIllII.add(0, -1, 0), EnumFacing.UP);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIllII.add(-1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIllII.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIllII.add(1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIllII.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIllII.add(0, 0, -1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIllII.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIllII.add(0, 0, 1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIllII.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockPos llllllllllllllllllIlIlIlIlIIlIll = llllllllllllllllllIlIlIlIlIIllII.add(-1, 0, 0);
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIll.add(-1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIll.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIll.add(1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIll.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIll.add(0, 0, -1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIll.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIll.add(0, 0, 1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIll.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockPos llllllllllllllllllIlIlIlIlIIlIlI = llllllllllllllllllIlIlIlIlIIllII.add(1, 0, 0);
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIlI.add(-1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIlI.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIlI.add(1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIlI.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIlI.add(0, 0, -1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIlI.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIlI.add(0, 0, 1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIlI.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockPos llllllllllllllllllIlIlIlIlIIlIIl = llllllllllllllllllIlIlIlIlIIllII.add(0, 0, -1);
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIIl.add(-1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIIl.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIIl.add(1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIIl.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIIl.add(0, 0, -1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIIl.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIIl.add(0, 0, 1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIIl.add(0, 0, 1), EnumFacing.NORTH);
        }
        final BlockPos llllllllllllllllllIlIlIlIlIIlIII = llllllllllllllllllIlIlIlIlIIllII.add(0, 0, 1);
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIII.add(-1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIII.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIII.add(1, 0, 0)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIII.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIII.add(0, 0, -1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIII.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!ScaffoldUtil.blockBlacklist.contains(ScaffoldUtil.mc.theWorld.getBlockState(llllllllllllllllllIlIlIlIlIIlIII.add(0, 0, 1)).getBlock())) {
            return new BlockInfo(llllllllllllllllllIlIlIlIlIIlIII.add(0, 0, 1), EnumFacing.NORTH);
        }
        return null;
    }
    
    public static boolean isValid(final ItemStack llllllllllllllllllIlIlIlIIlIIllI) {
        return !isEmpty(llllllllllllllllllIlIlIlIIlIIllI) && !llllllllllllllllllIlIlIlIIlIIllI.getUnlocalizedName().equalsIgnoreCase("tile.chest") && llllllllllllllllllIlIlIlIIlIIllI.getItem() instanceof ItemBlock && !ScaffoldUtil.blockBlacklist.contains(((ItemBlock)llllllllllllllllllIlIlIlIIlIIllI.getItem()).getBlock());
    }
    
    public static double randomNumber(final double llllllllllllllllllIlIlIlIIlIllII, final double llllllllllllllllllIlIlIlIIlIllIl) {
        return Math.random() * (llllllllllllllllllIlIlIlIIlIllII - llllllllllllllllllIlIlIlIIlIllIl) + llllllllllllllllllIlIlIlIIlIllIl;
    }
    
    public static void swap(final int llllllllllllllllllIlIlIlIIIlIlll, final int llllllllllllllllllIlIlIlIIIllIII) {
        ScaffoldUtil.mc.playerController.windowClick(ScaffoldUtil.mc.thePlayer.inventoryContainer.windowId, llllllllllllllllllIlIlIlIIIlIlll, llllllllllllllllllIlIlIlIIIllIII, 2, ScaffoldUtil.mc.thePlayer);
    }
    
    public static int getBlockSlot() {
        for (int llllllllllllllllllIlIlIlIIIlllll = 36; llllllllllllllllllIlIlIlIIIlllll < 45; ++llllllllllllllllllIlIlIlIIIlllll) {
            final ItemStack llllllllllllllllllIlIlIlIIIllllI = ScaffoldUtil.mc.thePlayer.inventoryContainer.getSlot(llllllllllllllllllIlIlIlIIIlllll).getStack();
            if (llllllllllllllllllIlIlIlIIIllllI != null && llllllllllllllllllIlIlIlIIIllllI.getItem() instanceof ItemBlock && !contains(((ItemBlock)llllllllllllllllllIlIlIlIIIllllI.getItem()).getBlock())) {
                return llllllllllllllllllIlIlIlIIIlllll - 36;
            }
        }
        return -1;
    }
    
    static {
        ScaffoldUtil.mc = Minecraft.getMinecraft();
        ScaffoldUtil.blockBlacklist = Arrays.asList(Blocks.air, Blocks.water, Blocks.tnt, Blocks.chest, Blocks.flowing_water, Blocks.lava, Blocks.flowing_lava, Blocks.enchanting_table, Blocks.carpet, Blocks.chest, Blocks.torch, Blocks.anvil, Blocks.trapped_chest, Blocks.noteblock, Blocks.jukebox, Blocks.iron_ore, Blocks.lapis_ore, Blocks.wooden_pressure_plate, Blocks.stone_pressure_plate, Blocks.light_weighted_pressure_plate, Blocks.heavy_weighted_pressure_plate, Blocks.stone_button, Blocks.wooden_button, Blocks.lever, Blocks.enchanting_table);
    }
    
    public static boolean isEmpty(final ItemStack llllllllllllllllllIlIlIlIlIIIIII) {
        return llllllllllllllllllIlIlIlIlIIIIII == null;
    }
}
