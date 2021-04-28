package net.minecraft.world.gen.feature;

import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;

public class WorldGeneratorBonusChest extends WorldGenerator
{
    private final /* synthetic */ int itemsToGenerateInBonusChest;
    private final /* synthetic */ List field_175909_a;
    
    static {
        __OBFID = "CL_00000403";
    }
    
    public WorldGeneratorBonusChest(final List llllllllllllllIIlIIlllIlIIIlIlII, final int llllllllllllllIIlIIlllIlIIIlIIll) {
        this.field_175909_a = llllllllllllllIIlIIlllIlIIIlIlII;
        this.itemsToGenerateInBonusChest = llllllllllllllIIlIIlllIlIIIlIIll;
    }
    
    @Override
    public boolean generate(final World llllllllllllllIIlIIlllIIllllIlIl, final Random llllllllllllllIIlIIlllIIllllIlII, BlockPos llllllllllllllIIlIIlllIIllllIIll) {
        Block llllllllllllllIIlIIlllIIlllllllI;
        while (((llllllllllllllIIlIIlllIIlllllllI = llllllllllllllIIlIIlllIIllllIlIl.getBlockState(llllllllllllllIIlIIlllIIllllIIll).getBlock()).getMaterial() == Material.air || llllllllllllllIIlIIlllIIlllllllI.getMaterial() == Material.leaves) && llllllllllllllIIlIIlllIIllllIIll.getY() > 1) {
            llllllllllllllIIlIIlllIIllllIIll = llllllllllllllIIlIIlllIIllllIIll.offsetDown();
        }
        if (llllllllllllllIIlIIlllIIllllIIll.getY() < 1) {
            return false;
        }
        llllllllllllllIIlIIlllIIllllIIll = llllllllllllllIIlIIlllIIllllIIll.offsetUp();
        for (int llllllllllllllIIlIIlllIIllllllIl = 0; llllllllllllllIIlIIlllIIllllllIl < 4; ++llllllllllllllIIlIIlllIIllllllIl) {
            final BlockPos llllllllllllllIIlIIlllIIllllllII = llllllllllllllIIlIIlllIIllllIIll.add(llllllllllllllIIlIIlllIIllllIlII.nextInt(4) - llllllllllllllIIlIIlllIIllllIlII.nextInt(4), llllllllllllllIIlIIlllIIllllIlII.nextInt(3) - llllllllllllllIIlIIlllIIllllIlII.nextInt(3), llllllllllllllIIlIIlllIIllllIlII.nextInt(4) - llllllllllllllIIlIIlllIIllllIlII.nextInt(4));
            if (llllllllllllllIIlIIlllIIllllIlIl.isAirBlock(llllllllllllllIIlIIlllIIllllllII) && World.doesBlockHaveSolidTopSurface(llllllllllllllIIlIIlllIIllllIlIl, llllllllllllllIIlIIlllIIllllllII.offsetDown())) {
                llllllllllllllIIlIIlllIIllllIlIl.setBlockState(llllllllllllllIIlIIlllIIllllllII, Blocks.chest.getDefaultState(), 2);
                final TileEntity llllllllllllllIIlIIlllIIlllllIll = llllllllllllllIIlIIlllIIllllIlIl.getTileEntity(llllllllllllllIIlIIlllIIllllllII);
                if (llllllllllllllIIlIIlllIIlllllIll instanceof TileEntityChest) {
                    WeightedRandomChestContent.generateChestContents(llllllllllllllIIlIIlllIIllllIlII, this.field_175909_a, (IInventory)llllllllllllllIIlIIlllIIlllllIll, this.itemsToGenerateInBonusChest);
                }
                final BlockPos llllllllllllllIIlIIlllIIlllllIlI = llllllllllllllIIlIIlllIIllllllII.offsetEast();
                final BlockPos llllllllllllllIIlIIlllIIlllllIIl = llllllllllllllIIlIIlllIIllllllII.offsetWest();
                final BlockPos llllllllllllllIIlIIlllIIlllllIII = llllllllllllllIIlIIlllIIllllllII.offsetNorth();
                final BlockPos llllllllllllllIIlIIlllIIllllIlll = llllllllllllllIIlIIlllIIllllllII.offsetSouth();
                if (llllllllllllllIIlIIlllIIllllIlIl.isAirBlock(llllllllllllllIIlIIlllIIlllllIIl) && World.doesBlockHaveSolidTopSurface(llllllllllllllIIlIIlllIIllllIlIl, llllllllllllllIIlIIlllIIlllllIIl.offsetDown())) {
                    llllllllllllllIIlIIlllIIllllIlIl.setBlockState(llllllllllllllIIlIIlllIIlllllIIl, Blocks.torch.getDefaultState(), 2);
                }
                if (llllllllllllllIIlIIlllIIllllIlIl.isAirBlock(llllllllllllllIIlIIlllIIlllllIlI) && World.doesBlockHaveSolidTopSurface(llllllllllllllIIlIIlllIIllllIlIl, llllllllllllllIIlIIlllIIlllllIlI.offsetDown())) {
                    llllllllllllllIIlIIlllIIllllIlIl.setBlockState(llllllllllllllIIlIIlllIIlllllIlI, Blocks.torch.getDefaultState(), 2);
                }
                if (llllllllllllllIIlIIlllIIllllIlIl.isAirBlock(llllllllllllllIIlIIlllIIlllllIII) && World.doesBlockHaveSolidTopSurface(llllllllllllllIIlIIlllIIllllIlIl, llllllllllllllIIlIIlllIIlllllIII.offsetDown())) {
                    llllllllllllllIIlIIlllIIllllIlIl.setBlockState(llllllllllllllIIlIIlllIIlllllIII, Blocks.torch.getDefaultState(), 2);
                }
                if (llllllllllllllIIlIIlllIIllllIlIl.isAirBlock(llllllllllllllIIlIIlllIIllllIlll) && World.doesBlockHaveSolidTopSurface(llllllllllllllIIlIIlllIIllllIlIl, llllllllllllllIIlIIlllIIllllIlll.offsetDown())) {
                    llllllllllllllIIlIIlllIIllllIlIl.setBlockState(llllllllllllllIIlIIlllIIllllIlll, Blocks.torch.getDefaultState(), 2);
                }
                return true;
            }
        }
        return false;
    }
}
