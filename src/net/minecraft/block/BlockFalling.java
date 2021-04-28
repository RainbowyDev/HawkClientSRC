package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;

public class BlockFalling extends Block
{
    public static /* synthetic */ boolean fallInstantly;
    
    public BlockFalling(final Material lllllllllllllllllIlIlIIlIIlIIIlI) {
        super(lllllllllllllllllIlIlIIlIIlIIIlI);
    }
    
    @Override
    public int tickRate(final World lllllllllllllllllIlIlIIIlllIlllI) {
        return 2;
    }
    
    public BlockFalling() {
        super(Material.sand);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    static {
        __OBFID = "CL_00000240";
    }
    
    protected void onStartFalling(final EntityFallingBlock lllllllllllllllllIlIlIIIllllIIII) {
    }
    
    @Override
    public void updateTick(final World lllllllllllllllllIlIlIIlIIIIIIll, final BlockPos lllllllllllllllllIlIlIIlIIIIIIlI, final IBlockState lllllllllllllllllIlIlIIlIIIIIllI, final Random lllllllllllllllllIlIlIIlIIIIIlIl) {
        if (!lllllllllllllllllIlIlIIlIIIIIIll.isRemote) {
            this.checkFallable(lllllllllllllllllIlIlIIlIIIIIIll, lllllllllllllllllIlIlIIlIIIIIIlI);
        }
    }
    
    public void onEndFalling(final World lllllllllllllllllIlIlIIIlllIIIII, final BlockPos lllllllllllllllllIlIlIIIllIlllll) {
    }
    
    public static boolean canFallInto(final World lllllllllllllllllIlIlIIIlllIlIIl, final BlockPos lllllllllllllllllIlIlIIIlllIIlII) {
        final Block lllllllllllllllllIlIlIIIlllIIlll = lllllllllllllllllIlIlIIIlllIlIIl.getBlockState(lllllllllllllllllIlIlIIIlllIIlII).getBlock();
        final Material lllllllllllllllllIlIlIIIlllIIllI = lllllllllllllllllIlIlIIIlllIIlll.blockMaterial;
        return lllllllllllllllllIlIlIIIlllIIlll == Blocks.fire || lllllllllllllllllIlIlIIIlllIIllI == Material.air || lllllllllllllllllIlIlIIIlllIIllI == Material.water || lllllllllllllllllIlIlIIIlllIIllI == Material.lava;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllllIlIlIIlIIIlllIl, final BlockPos lllllllllllllllllIlIlIIlIIIllIII, final IBlockState lllllllllllllllllIlIlIIlIIIllIll) {
        lllllllllllllllllIlIlIIlIIIlllIl.scheduleUpdate(lllllllllllllllllIlIlIIlIIIllIII, this, this.tickRate(lllllllllllllllllIlIlIIlIIIlllIl));
    }
    
    private void checkFallable(final World lllllllllllllllllIlIlIIIlllllIll, final BlockPos lllllllllllllllllIlIlIIIllllIlII) {
        if (canFallInto(lllllllllllllllllIlIlIIIlllllIll, lllllllllllllllllIlIlIIIllllIlII.offsetDown()) && lllllllllllllllllIlIlIIIllllIlII.getY() >= 0) {
            final byte lllllllllllllllllIlIlIIIlllllIIl = 32;
            if (!BlockFalling.fallInstantly && lllllllllllllllllIlIlIIIlllllIll.isAreaLoaded(lllllllllllllllllIlIlIIIllllIlII.add(-lllllllllllllllllIlIlIIIlllllIIl, -lllllllllllllllllIlIlIIIlllllIIl, -lllllllllllllllllIlIlIIIlllllIIl), lllllllllllllllllIlIlIIIllllIlII.add(lllllllllllllllllIlIlIIIlllllIIl, lllllllllllllllllIlIlIIIlllllIIl, lllllllllllllllllIlIlIIIlllllIIl))) {
                if (!lllllllllllllllllIlIlIIIlllllIll.isRemote) {
                    final EntityFallingBlock lllllllllllllllllIlIlIIIlllllIII = new EntityFallingBlock(lllllllllllllllllIlIlIIIlllllIll, lllllllllllllllllIlIlIIIllllIlII.getX() + 0.5, lllllllllllllllllIlIlIIIllllIlII.getY(), lllllllllllllllllIlIlIIIllllIlII.getZ() + 0.5, lllllllllllllllllIlIlIIIlllllIll.getBlockState(lllllllllllllllllIlIlIIIllllIlII));
                    this.onStartFalling(lllllllllllllllllIlIlIIIlllllIII);
                    lllllllllllllllllIlIlIIIlllllIll.spawnEntityInWorld(lllllllllllllllllIlIlIIIlllllIII);
                }
            }
            else {
                lllllllllllllllllIlIlIIIlllllIll.setBlockToAir(lllllllllllllllllIlIlIIIllllIlII);
                BlockPos lllllllllllllllllIlIlIIIllllIlll;
                for (lllllllllllllllllIlIlIIIllllIlll = lllllllllllllllllIlIlIIIllllIlII.offsetDown(); canFallInto(lllllllllllllllllIlIlIIIlllllIll, lllllllllllllllllIlIlIIIllllIlll) && lllllllllllllllllIlIlIIIllllIlll.getY() > 0; lllllllllllllllllIlIlIIIllllIlll = lllllllllllllllllIlIlIIIllllIlll.offsetDown()) {}
                if (lllllllllllllllllIlIlIIIllllIlll.getY() > 0) {
                    lllllllllllllllllIlIlIIIlllllIll.setBlockState(lllllllllllllllllIlIlIIIllllIlll.offsetUp(), this.getDefaultState());
                }
            }
        }
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllllIlIlIIlIIIlIIll, final BlockPos lllllllllllllllllIlIlIIlIIIIllIl, final IBlockState lllllllllllllllllIlIlIIlIIIlIIIl, final Block lllllllllllllllllIlIlIIlIIIlIIII) {
        lllllllllllllllllIlIlIIlIIIlIIll.scheduleUpdate(lllllllllllllllllIlIlIIlIIIIllIl, this, this.tickRate(lllllllllllllllllIlIlIIlIIIlIIll));
    }
}
