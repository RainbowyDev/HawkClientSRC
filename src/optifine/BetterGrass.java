package optifine;

import net.minecraft.client.resources.model.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class BetterGrass
{
    private static /* synthetic */ IBakedModel modelCubeGrass;
    private static /* synthetic */ IBakedModel modelCubeGrassSnowy;
    private static /* synthetic */ IBakedModel modelCubeMycelium;
    private static /* synthetic */ IBakedModel modelEmpty;
    
    static {
        BetterGrass.modelEmpty = new SimpleBakedModel(new ArrayList(), new ArrayList(), false, false, null, null);
        BetterGrass.modelCubeMycelium = null;
        BetterGrass.modelCubeGrassSnowy = null;
        BetterGrass.modelCubeGrass = null;
    }
    
    public static void update() {
        BetterGrass.modelCubeGrass = BlockModelUtils.makeModelCube("minecraft:blocks/grass_top", 0);
        BetterGrass.modelCubeGrassSnowy = BlockModelUtils.makeModelCube("minecraft:blocks/snow", -1);
        BetterGrass.modelCubeMycelium = BlockModelUtils.makeModelCube("minecraft:blocks/mycelium_top", -1);
    }
    
    private static Block getBlockAt(final BlockPos llIIlllIIlIlI, final EnumFacing llIIlllIIlllI, final IBlockAccess llIIlllIIlIII) {
        final BlockPos llIIlllIIllII = llIIlllIIlIlI.offset(llIIlllIIlllI);
        final Block llIIlllIIlIll = llIIlllIIlIII.getBlockState(llIIlllIIllII).getBlock();
        return llIIlllIIlIll;
    }
    
    public static List getFaceQuads(final IBlockAccess llIIllllIIIlI, final Block llIIlllIllIlI, final BlockPos llIIlllIllIIl, final EnumFacing llIIlllIlllll, final List llIIlllIllllI) {
        if (llIIlllIlllll == EnumFacing.UP || llIIlllIlllll == EnumFacing.DOWN) {
            return llIIlllIllllI;
        }
        if (llIIlllIllIlI instanceof BlockMycelium) {
            return Config.isBetterGrassFancy() ? ((getBlockAt(llIIlllIllIIl.offsetDown(), llIIlllIlllll, llIIllllIIIlI) == Blocks.mycelium) ? BetterGrass.modelCubeMycelium.func_177551_a(llIIlllIlllll) : llIIlllIllllI) : BetterGrass.modelCubeMycelium.func_177551_a(llIIlllIlllll);
        }
        if (llIIlllIllIlI instanceof BlockGrass) {
            final Block llIIlllIlllIl = llIIllllIIIlI.getBlockState(llIIlllIllIIl.offsetUp()).getBlock();
            final boolean llIIlllIlllII = llIIlllIlllIl == Blocks.snow || llIIlllIlllIl == Blocks.snow_layer;
            if (!Config.isBetterGrassFancy()) {
                if (llIIlllIlllII) {
                    return BetterGrass.modelCubeGrassSnowy.func_177551_a(llIIlllIlllll);
                }
                return BetterGrass.modelCubeGrass.func_177551_a(llIIlllIlllll);
            }
            else if (llIIlllIlllII) {
                if (getBlockAt(llIIlllIllIIl, llIIlllIlllll, llIIllllIIIlI) == Blocks.snow_layer) {
                    return BetterGrass.modelCubeGrassSnowy.func_177551_a(llIIlllIlllll);
                }
            }
            else if (getBlockAt(llIIlllIllIIl.offsetDown(), llIIlllIlllll, llIIllllIIIlI) == Blocks.grass) {
                return BetterGrass.modelCubeGrass.func_177551_a(llIIlllIlllll);
            }
        }
        return llIIlllIllllI;
    }
}
