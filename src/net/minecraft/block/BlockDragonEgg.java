package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;

public class BlockDragonEgg extends Block
{
    public BlockDragonEgg() {
        super(Material.dragonEgg);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIlllIlIlllllIlIlII, final BlockPos llllllllllllllIlllIlIlllllIlIIll, final IBlockState llllllllllllllIlllIlIlllllIlIIlI) {
        llllllllllllllIlllIlIlllllIlIlII.scheduleUpdate(llllllllllllllIlllIlIlllllIlIIll, this, this.tickRate(llllllllllllllIlllIlIlllllIlIlII));
    }
    
    @Override
    public Item getItem(final World llllllllllllllIlllIlIlllIlIlllIl, final BlockPos llllllllllllllIlllIlIlllIlIlllII) {
        return null;
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIlllIlIlllllIIlIlI, final BlockPos llllllllllllllIlllIlIlllllIIIlII, final IBlockState llllllllllllllIlllIlIlllllIIlIII, final Block llllllllllllllIlllIlIlllllIIIlll) {
        llllllllllllllIlllIlIlllllIIlIlI.scheduleUpdate(llllllllllllllIlllIlIlllllIIIlII, this, this.tickRate(llllllllllllllIlllIlIlllllIIlIlI));
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000232";
    }
    
    private void func_180684_e(final World llllllllllllllIlllIlIllllIIIIIIl, final BlockPos llllllllllllllIlllIlIlllIlllIIlI) {
        final IBlockState llllllllllllllIlllIlIlllIlllllll = llllllllllllllIlllIlIllllIIIIIIl.getBlockState(llllllllllllllIlllIlIlllIlllIIlI);
        if (llllllllllllllIlllIlIlllIlllllll.getBlock() == this) {
            for (int llllllllllllllIlllIlIlllIllllllI = 0; llllllllllllllIlllIlIlllIllllllI < 1000; ++llllllllllllllIlllIlIlllIllllllI) {
                final BlockPos llllllllllllllIlllIlIlllIlllllIl = llllllllllllllIlllIlIlllIlllIIlI.add(llllllllllllllIlllIlIllllIIIIIIl.rand.nextInt(16) - llllllllllllllIlllIlIllllIIIIIIl.rand.nextInt(16), llllllllllllllIlllIlIllllIIIIIIl.rand.nextInt(8) - llllllllllllllIlllIlIllllIIIIIIl.rand.nextInt(8), llllllllllllllIlllIlIllllIIIIIIl.rand.nextInt(16) - llllllllllllllIlllIlIllllIIIIIIl.rand.nextInt(16));
                if (llllllllllllllIlllIlIllllIIIIIIl.getBlockState(llllllllllllllIlllIlIlllIlllllIl).getBlock().blockMaterial == Material.air) {
                    if (llllllllllllllIlllIlIllllIIIIIIl.isRemote) {
                        for (int llllllllllllllIlllIlIlllIlllllII = 0; llllllllllllllIlllIlIlllIlllllII < 128; ++llllllllllllllIlllIlIlllIlllllII) {
                            final double llllllllllllllIlllIlIlllIllllIll = llllllllllllllIlllIlIllllIIIIIIl.rand.nextDouble();
                            final float llllllllllllllIlllIlIlllIllllIlI = (llllllllllllllIlllIlIllllIIIIIIl.rand.nextFloat() - 0.5f) * 0.2f;
                            final float llllllllllllllIlllIlIlllIllllIIl = (llllllllllllllIlllIlIllllIIIIIIl.rand.nextFloat() - 0.5f) * 0.2f;
                            final float llllllllllllllIlllIlIlllIllllIII = (llllllllllllllIlllIlIllllIIIIIIl.rand.nextFloat() - 0.5f) * 0.2f;
                            final double llllllllllllllIlllIlIlllIlllIlll = llllllllllllllIlllIlIlllIlllllIl.getX() + (llllllllllllllIlllIlIlllIlllIIlI.getX() - llllllllllllllIlllIlIlllIlllllIl.getX()) * llllllllllllllIlllIlIlllIllllIll + (llllllllllllllIlllIlIllllIIIIIIl.rand.nextDouble() - 0.5) * 1.0 + 0.5;
                            final double llllllllllllllIlllIlIlllIlllIllI = llllllllllllllIlllIlIlllIlllllIl.getY() + (llllllllllllllIlllIlIlllIlllIIlI.getY() - llllllllllllllIlllIlIlllIlllllIl.getY()) * llllllllllllllIlllIlIlllIllllIll + llllllllllllllIlllIlIllllIIIIIIl.rand.nextDouble() * 1.0 - 0.5;
                            final double llllllllllllllIlllIlIlllIlllIlIl = llllllllllllllIlllIlIlllIlllllIl.getZ() + (llllllllllllllIlllIlIlllIlllIIlI.getZ() - llllllllllllllIlllIlIlllIlllllIl.getZ()) * llllllllllllllIlllIlIlllIllllIll + (llllllllllllllIlllIlIllllIIIIIIl.rand.nextDouble() - 0.5) * 1.0 + 0.5;
                            llllllllllllllIlllIlIllllIIIIIIl.spawnParticle(EnumParticleTypes.PORTAL, llllllllllllllIlllIlIlllIlllIlll, llllllllllllllIlllIlIlllIlllIllI, llllllllllllllIlllIlIlllIlllIlIl, llllllllllllllIlllIlIlllIllllIlI, llllllllllllllIlllIlIlllIllllIIl, llllllllllllllIlllIlIlllIllllIII, new int[0]);
                        }
                    }
                    else {
                        llllllllllllllIlllIlIllllIIIIIIl.setBlockState(llllllllllllllIlllIlIlllIlllllIl, llllllllllllllIlllIlIlllIlllllll, 2);
                        llllllllllllllIlllIlIllllIIIIIIl.setBlockToAir(llllllllllllllIlllIlIlllIlllIIlI);
                    }
                    return;
                }
            }
        }
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIlllIlIlllIllIIIIl, final BlockPos llllllllllllllIlllIlIlllIllIIIII, final EnumFacing llllllllllllllIlllIlIlllIlIlllll) {
        return true;
    }
    
    @Override
    public void onBlockClicked(final World llllllllllllllIlllIlIllllIIlIllI, final BlockPos llllllllllllllIlllIlIllllIIlIlIl, final EntityPlayer llllllllllllllIlllIlIllllIIlIlII) {
        this.func_180684_e(llllllllllllllIlllIlIllllIIlIllI, llllllllllllllIlllIlIllllIIlIlIl);
    }
    
    @Override
    public void updateTick(final World llllllllllllllIlllIlIllllIllllll, final BlockPos llllllllllllllIlllIlIllllIlllIIl, final IBlockState llllllllllllllIlllIlIllllIllllIl, final Random llllllllllllllIlllIlIllllIllllII) {
        this.func_180683_d(llllllllllllllIlllIlIllllIllllll, llllllllllllllIlllIlIllllIlllIIl);
    }
    
    private void func_180683_d(final World llllllllllllllIlllIlIllllIlIllIl, final BlockPos llllllllllllllIlllIlIllllIlIllII) {
        if (BlockFalling.canFallInto(llllllllllllllIlllIlIllllIlIllIl, llllllllllllllIlllIlIllllIlIllII.offsetDown()) && llllllllllllllIlllIlIllllIlIllII.getY() >= 0) {
            final byte llllllllllllllIlllIlIllllIllIIII = 32;
            if (!BlockFalling.fallInstantly && llllllllllllllIlllIlIllllIlIllIl.isAreaLoaded(llllllllllllllIlllIlIllllIlIllII.add(-llllllllllllllIlllIlIllllIllIIII, -llllllllllllllIlllIlIllllIllIIII, -llllllllllllllIlllIlIllllIllIIII), llllllllllllllIlllIlIllllIlIllII.add(llllllllllllllIlllIlIllllIllIIII, llllllllllllllIlllIlIllllIllIIII, llllllllllllllIlllIlIllllIllIIII))) {
                llllllllllllllIlllIlIllllIlIllIl.spawnEntityInWorld(new EntityFallingBlock(llllllllllllllIlllIlIllllIlIllIl, llllllllllllllIlllIlIllllIlIllII.getX() + 0.5f, llllllllllllllIlllIlIllllIlIllII.getY(), llllllllllllllIlllIlIllllIlIllII.getZ() + 0.5f, this.getDefaultState()));
            }
            else {
                llllllllllllllIlllIlIllllIlIllIl.setBlockToAir(llllllllllllllIlllIlIllllIlIllII);
                BlockPos llllllllllllllIlllIlIllllIlIllll;
                for (llllllllllllllIlllIlIllllIlIllll = llllllllllllllIlllIlIllllIlIllII; BlockFalling.canFallInto(llllllllllllllIlllIlIllllIlIllIl, llllllllllllllIlllIlIllllIlIllll) && llllllllllllllIlllIlIllllIlIllll.getY() > 0; llllllllllllllIlllIlIllllIlIllll = llllllllllllllIlllIlIllllIlIllll.offsetDown()) {}
                if (llllllllllllllIlllIlIllllIlIllll.getY() > 0) {
                    llllllllllllllIlllIlIllllIlIllIl.setBlockState(llllllllllllllIlllIlIllllIlIllll, this.getDefaultState(), 2);
                }
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlllIlIllllIlIIlIl, final BlockPos llllllllllllllIlllIlIllllIlIIlII, final IBlockState llllllllllllllIlllIlIllllIlIIIll, final EntityPlayer llllllllllllllIlllIlIllllIlIIIlI, final EnumFacing llllllllllllllIlllIlIllllIlIIIIl, final float llllllllllllllIlllIlIllllIlIIIII, final float llllllllllllllIlllIlIllllIIlllll, final float llllllllllllllIlllIlIllllIIllllI) {
        this.func_180684_e(llllllllllllllIlllIlIllllIlIIlIl, llllllllllllllIlllIlIllllIlIIlII);
        return true;
    }
    
    @Override
    public int tickRate(final World llllllllllllllIlllIlIlllIllIIlIl) {
        return 5;
    }
}
