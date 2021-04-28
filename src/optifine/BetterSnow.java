package optifine;

import net.minecraft.client.resources.model.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class BetterSnow
{
    private static /* synthetic */ IBakedModel modelSnowLayer;
    
    public static void update() {
        BetterSnow.modelSnowLayer = Config.getMinecraft().getBlockRendererDispatcher().func_175023_a().func_178125_b(Blocks.snow_layer.getDefaultState());
    }
    
    private static boolean checkBlock(final Block llllllllllllllIlllllIlllllIIIIll, final IBlockState llllllllllllllIlllllIlllllIIIIIl) {
        if (llllllllllllllIlllllIlllllIIIIll.isFullCube()) {
            return false;
        }
        if (llllllllllllllIlllllIlllllIIIIll.isOpaqueCube()) {
            return false;
        }
        if (llllllllllllllIlllllIlllllIIIIll instanceof BlockSnow) {
            return false;
        }
        if (llllllllllllllIlllllIlllllIIIIll instanceof BlockBush && (llllllllllllllIlllllIlllllIIIIll instanceof BlockDoublePlant || llllllllllllllIlllllIlllllIIIIll instanceof BlockFlower || llllllllllllllIlllllIlllllIIIIll instanceof BlockMushroom || llllllllllllllIlllllIlllllIIIIll instanceof BlockSapling || llllllllllllllIlllllIlllllIIIIll instanceof BlockTallGrass)) {
            return true;
        }
        if (llllllllllllllIlllllIlllllIIIIll instanceof BlockFence || llllllllllllllIlllllIlllllIIIIll instanceof BlockFenceGate || llllllllllllllIlllllIlllllIIIIll instanceof BlockFlowerPot || llllllllllllllIlllllIlllllIIIIll instanceof BlockPane || llllllllllllllIlllllIlllllIIIIll instanceof BlockReed || llllllllllllllIlllllIlllllIIIIll instanceof BlockWall) {
            return true;
        }
        if (llllllllllllllIlllllIlllllIIIIll instanceof BlockRedstoneTorch && llllllllllllllIlllllIlllllIIIIIl.getValue(BlockTorch.FACING_PROP) == EnumFacing.UP) {
            return true;
        }
        if (llllllllllllllIlllllIlllllIIIIll instanceof BlockLever) {
            final Comparable llllllllllllllIlllllIllllIllllll = llllllllllllllIlllllIlllllIIIIIl.getValue(BlockLever.FACING);
            if (llllllllllllllIlllllIllllIllllll == BlockLever.EnumOrientation.UP_X || llllllllllllllIlllllIllllIllllll == BlockLever.EnumOrientation.UP_Z) {
                return true;
            }
        }
        return false;
    }
    
    static {
        BetterSnow.modelSnowLayer = null;
    }
    
    public static boolean shouldRender(final IBlockAccess llllllllllllllIlllllIllllllIIlIl, final Block llllllllllllllIlllllIllllllIIlII, final IBlockState llllllllllllllIlllllIllllllIIIll, final BlockPos llllllllllllllIlllllIllllllIIIlI) {
        return checkBlock(llllllllllllllIlllllIllllllIIlII, llllllllllllllIlllllIllllllIIIll) && hasSnowNeighbours(llllllllllllllIlllllIllllllIIlIl, llllllllllllllIlllllIllllllIIIlI);
    }
    
    public static IBlockState getStateSnowLayer() {
        return Blocks.snow_layer.getDefaultState();
    }
    
    public static IBakedModel getModelSnowLayer() {
        return BetterSnow.modelSnowLayer;
    }
    
    private static boolean hasSnowNeighbours(final IBlockAccess llllllllllllllIlllllIlllllIlIIIl, final BlockPos llllllllllllllIlllllIlllllIlIIll) {
        final Block llllllllllllllIlllllIlllllIlIIlI = Blocks.snow_layer;
        return (llllllllllllllIlllllIlllllIlIIIl.getBlockState(llllllllllllllIlllllIlllllIlIIll.offsetNorth()).getBlock() == llllllllllllllIlllllIlllllIlIIlI || llllllllllllllIlllllIlllllIlIIIl.getBlockState(llllllllllllllIlllllIlllllIlIIll.offsetSouth()).getBlock() == llllllllllllllIlllllIlllllIlIIlI || llllllllllllllIlllllIlllllIlIIIl.getBlockState(llllllllllllllIlllllIlllllIlIIll.offsetWest()).getBlock() == llllllllllllllIlllllIlllllIlIIlI || llllllllllllllIlllllIlllllIlIIIl.getBlockState(llllllllllllllIlllllIlllllIlIIll.offsetEast()).getBlock() == llllllllllllllIlllllIlllllIlIIlI) && llllllllllllllIlllllIlllllIlIIIl.getBlockState(llllllllllllllIlllllIlllllIlIIll.offsetDown()).getBlock().isOpaqueCube();
    }
}
