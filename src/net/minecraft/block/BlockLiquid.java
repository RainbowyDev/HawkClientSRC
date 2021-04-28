package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public abstract class BlockLiquid extends Block
{
    public static final /* synthetic */ PropertyInteger LEVEL;
    
    @Override
    public int colorMultiplier(final IBlockAccess lllllllllllllllIIIIIlIlllIIllIII, final BlockPos lllllllllllllllIIIIIlIlllIIlIlll, final int lllllllllllllllIIIIIlIlllIIlIllI) {
        return (this.blockMaterial == Material.water) ? BiomeColorHelper.func_180288_c(lllllllllllllllIIIIIlIlllIIllIII, lllllllllllllllIIIIIlIlllIIlIlll) : 16777215;
    }
    
    protected void func_180688_d(final World lllllllllllllllIIIIIlIlIIllIllll, final BlockPos lllllllllllllllIIIIIlIlIIllIlllI) {
        final double lllllllllllllllIIIIIlIlIIllIllIl = lllllllllllllllIIIIIlIlIIllIlllI.getX();
        final double lllllllllllllllIIIIIlIlIIllIllII = lllllllllllllllIIIIIlIlIIllIlllI.getY();
        final double lllllllllllllllIIIIIlIlIIllIlIll = lllllllllllllllIIIIIlIlIIllIlllI.getZ();
        lllllllllllllllIIIIIlIlIIllIllll.playSoundEffect(lllllllllllllllIIIIIlIlIIllIllIl + 0.5, lllllllllllllllIIIIIlIlIIllIllII + 0.5, lllllllllllllllIIIIIlIlIIllIlIll + 0.5, "random.fizz", 0.5f, 2.6f + (lllllllllllllllIIIIIlIlIIllIllll.rand.nextFloat() - lllllllllllllllIIIIIlIlIIllIllll.rand.nextFloat()) * 0.8f);
        for (int lllllllllllllllIIIIIlIlIIllIlIlI = 0; lllllllllllllllIIIIIlIlIIllIlIlI < 8; ++lllllllllllllllIIIIIlIlIIllIlIlI) {
            lllllllllllllllIIIIIlIlIIllIllll.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllllIIIIIlIlIIllIllIl + Math.random(), lllllllllllllllIIIIIlIlIIllIllII + 1.2, lllllllllllllllIIIIIlIlIIllIlIll + Math.random(), 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return (this.blockMaterial == Material.water) ? EnumWorldBlockLayer.TRANSLUCENT : EnumWorldBlockLayer.SOLID;
    }
    
    protected int func_176362_e(final IBlockAccess lllllllllllllllIIIIIlIlllIIIlIII, final BlockPos lllllllllllllllIIIIIlIlllIIIIlll) {
        return (int)((lllllllllllllllIIIIIlIlllIIIlIII.getBlockState(lllllllllllllllIIIIIlIlllIIIIlll).getBlock().getMaterial() == this.blockMaterial) ? lllllllllllllllIIIIIlIlllIIIlIII.getBlockState(lllllllllllllllIIIIIlIlllIIIIlll).getValue(BlockLiquid.LEVEL) : -1);
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState lllllllllllllllIIIIIlIllIlllIlIl, final boolean lllllllllllllllIIIIIlIllIlllIlII) {
        return lllllllllllllllIIIIIlIllIlllIlII && (int)lllllllllllllllIIIIIlIllIlllIlIl.getValue(BlockLiquid.LEVEL) == 0;
    }
    
    public boolean func_176364_g(final IBlockAccess lllllllllllllllIIIIIlIllIlIIllIl, final BlockPos lllllllllllllllIIIIIlIllIlIIllII) {
        for (int lllllllllllllllIIIIIlIllIlIIlIll = -1; lllllllllllllllIIIIIlIllIlIIlIll <= 1; ++lllllllllllllllIIIIIlIllIlIIlIll) {
            for (int lllllllllllllllIIIIIlIllIlIIlIlI = -1; lllllllllllllllIIIIIlIllIlIIlIlI <= 1; ++lllllllllllllllIIIIIlIllIlIIlIlI) {
                final IBlockState lllllllllllllllIIIIIlIllIlIIlIIl = lllllllllllllllIIIIIlIllIlIIllIl.getBlockState(lllllllllllllllIIIIIlIllIlIIllII.add(lllllllllllllllIIIIIlIllIlIIlIll, 0, lllllllllllllllIIIIIlIllIlIIlIlI));
                final Block lllllllllllllllIIIIIlIllIlIIlIII = lllllllllllllllIIIIIlIllIlIIlIIl.getBlock();
                final Material lllllllllllllllIIIIIlIllIlIIIlll = lllllllllllllllIIIIIlIllIlIIlIII.getMaterial();
                if (lllllllllllllllIIIIIlIllIlIIIlll != this.blockMaterial && !lllllllllllllllIIIIIlIllIlIIlIII.isFullBlock()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIIIlIlIIlIllllI) {
        return this.getDefaultState().withProperty(BlockLiquid.LEVEL, lllllllllllllllIIIIIlIlIIlIllllI);
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIIIIIlIlIlIIllIlI, final BlockPos lllllllllllllllIIIIIlIlIlIIllIIl, final IBlockState lllllllllllllllIIIIIlIlIlIIllIII, final Block lllllllllllllllIIIIIlIlIlIIlIlll) {
        this.func_176365_e(lllllllllllllllIIIIIlIlIlIIllIlI, lllllllllllllllIIIIIlIlIlIIllIIl, lllllllllllllllIIIIIlIlIlIIllIII);
    }
    
    @Override
    public Vec3 modifyAcceleration(final World lllllllllllllllIIIIIlIllIIIIlIII, final BlockPos lllllllllllllllIIIIIlIllIIIIllII, final Entity lllllllllllllllIIIIIlIllIIIIlIll, final Vec3 lllllllllllllllIIIIIlIllIIIIIllI) {
        return lllllllllllllllIIIIIlIllIIIIIllI.add(this.func_180687_h(lllllllllllllllIIIIIlIllIIIIlIII, lllllllllllllllIIIIIlIllIIIIllII));
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    public static float getLiquidHeightPercent(int lllllllllllllllIIIIIlIlllIIlIIII) {
        if (lllllllllllllllIIIIIlIlllIIlIIII >= 8) {
            lllllllllllllllIIIIIlIlllIIlIIII = 0;
        }
        return (float)(lllllllllllllllIIIIIlIlllIIlIIII + 1) / 9.0f;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIIIIIlIllIIlllIII, final Random lllllllllllllllIIIIIlIllIIllIlll, final int lllllllllllllllIIIIIlIllIIllIllI) {
        return null;
    }
    
    @Override
    public boolean isBlockSolid(final IBlockAccess lllllllllllllllIIIIIlIllIllIIllI, final BlockPos lllllllllllllllIIIIIlIllIllIlIlI, final EnumFacing lllllllllllllllIIIIIlIllIllIlIIl) {
        final Material lllllllllllllllIIIIIlIllIllIlIII = lllllllllllllllIIIIIlIllIllIIllI.getBlockState(lllllllllllllllIIIIIlIllIllIlIlI).getBlock().getMaterial();
        return lllllllllllllllIIIIIlIllIllIlIII != this.blockMaterial && (lllllllllllllllIIIIIlIllIllIlIIl == EnumFacing.UP || (lllllllllllllllIIIIIlIllIllIlIII != Material.ice && super.isBlockSolid(lllllllllllllllIIIIIlIllIllIIllI, lllllllllllllllIIIIIlIllIllIlIlI, lllllllllllllllIIIIIlIllIllIlIIl)));
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllllIIIIIlIlllIIlllll, final BlockPos lllllllllllllllIIIIIlIlllIIllllI) {
        return this.blockMaterial != Material.lava;
    }
    
    public boolean func_176365_e(final World lllllllllllllllIIIIIlIlIlIIIlIII, final BlockPos lllllllllllllllIIIIIlIlIlIIIIlll, final IBlockState lllllllllllllllIIIIIlIlIlIIIIllI) {
        if (this.blockMaterial == Material.lava) {
            boolean lllllllllllllllIIIIIlIlIlIIIIlIl = false;
            for (final EnumFacing lllllllllllllllIIIIIlIlIlIIIIIIl : EnumFacing.values()) {
                if (lllllllllllllllIIIIIlIlIlIIIIIIl != EnumFacing.DOWN && lllllllllllllllIIIIIlIlIlIIIlIII.getBlockState(lllllllllllllllIIIIIlIlIlIIIIlll.offset(lllllllllllllllIIIIIlIlIlIIIIIIl)).getBlock().getMaterial() == Material.water) {
                    lllllllllllllllIIIIIlIlIlIIIIlIl = true;
                    break;
                }
            }
            if (lllllllllllllllIIIIIlIlIlIIIIlIl) {
                final Integer lllllllllllllllIIIIIlIlIlIIIIIII = (Integer)lllllllllllllllIIIIIlIlIlIIIIllI.getValue(BlockLiquid.LEVEL);
                if (lllllllllllllllIIIIIlIlIlIIIIIII == 0) {
                    lllllllllllllllIIIIIlIlIlIIIlIII.setBlockState(lllllllllllllllIIIIIlIlIlIIIIlll, Blocks.obsidian.getDefaultState());
                    this.func_180688_d(lllllllllllllllIIIIIlIlIlIIIlIII, lllllllllllllllIIIIIlIlIlIIIIlll);
                    return true;
                }
                if (lllllllllllllllIIIIIlIlIlIIIIIII <= 4) {
                    lllllllllllllllIIIIIlIlIlIIIlIII.setBlockState(lllllllllllllllIIIIIlIlIlIIIIlll, Blocks.cobblestone.getDefaultState());
                    this.func_180688_d(lllllllllllllllIIIIIlIlIlIIIlIII, lllllllllllllllIIIIIlIlIlIIIIlll);
                    return true;
                }
            }
        }
        return false;
    }
    
    protected BlockLiquid(final Material lllllllllllllllIIIIIlIlllIlIIIlI) {
        super(lllllllllllllllIIIIIlIlllIlIIIlI);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockLiquid.LEVEL, 0));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.setTickRandomly(true);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIIIlIlIIlIllIll) {
        return (int)lllllllllllllllIIIIIlIlIIlIllIll.getValue(BlockLiquid.LEVEL);
    }
    
    @Override
    public int tickRate(final World lllllllllllllllIIIIIlIllIIIIIIII) {
        return (this.blockMaterial == Material.water) ? 5 : ((this.blockMaterial == Material.lava) ? (lllllllllllllllIIIIIlIllIIIIIIII.provider.getHasNoSky() ? 10 : 30) : 0);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIIIIIlIllIIllIlII) {
        return 0;
    }
    
    protected Vec3 func_180687_h(final IBlockAccess lllllllllllllllIIIIIlIllIIIllIll, final BlockPos lllllllllllllllIIIIIlIllIIlIIlll) {
        Vec3 lllllllllllllllIIIIIlIllIIlIIllI = new Vec3(0.0, 0.0, 0.0);
        final int lllllllllllllllIIIIIlIllIIlIIlIl = this.func_176366_f(lllllllllllllllIIIIIlIllIIIllIll, lllllllllllllllIIIIIlIllIIlIIlll);
        for (final EnumFacing lllllllllllllllIIIIIlIllIIlIIIll : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos lllllllllllllllIIIIIlIllIIlIIIIl = lllllllllllllllIIIIIlIllIIlIIlll.offset(lllllllllllllllIIIIIlIllIIlIIIll);
            int lllllllllllllllIIIIIlIllIIIlllll = this.func_176366_f(lllllllllllllllIIIIIlIllIIIllIll, lllllllllllllllIIIIIlIllIIlIIIIl);
            if (lllllllllllllllIIIIIlIllIIIlllll < 0) {
                if (lllllllllllllllIIIIIlIllIIIllIll.getBlockState(lllllllllllllllIIIIIlIllIIlIIIIl).getBlock().getMaterial().blocksMovement()) {
                    continue;
                }
                lllllllllllllllIIIIIlIllIIIlllll = this.func_176366_f(lllllllllllllllIIIIIlIllIIIllIll, lllllllllllllllIIIIIlIllIIlIIIIl.offsetDown());
                if (lllllllllllllllIIIIIlIllIIIlllll < 0) {
                    continue;
                }
                final int lllllllllllllllIIIIIlIllIIIllllI = lllllllllllllllIIIIIlIllIIIlllll - (lllllllllllllllIIIIIlIllIIlIIlIl - 8);
                lllllllllllllllIIIIIlIllIIlIIllI = lllllllllllllllIIIIIlIllIIlIIllI.addVector((lllllllllllllllIIIIIlIllIIlIIIIl.getX() - lllllllllllllllIIIIIlIllIIlIIlll.getX()) * lllllllllllllllIIIIIlIllIIIllllI, (lllllllllllllllIIIIIlIllIIlIIIIl.getY() - lllllllllllllllIIIIIlIllIIlIIlll.getY()) * lllllllllllllllIIIIIlIllIIIllllI, (lllllllllllllllIIIIIlIllIIlIIIIl.getZ() - lllllllllllllllIIIIIlIllIIlIIlll.getZ()) * lllllllllllllllIIIIIlIllIIIllllI);
            }
            else {
                if (lllllllllllllllIIIIIlIllIIIlllll < 0) {
                    continue;
                }
                final int lllllllllllllllIIIIIlIllIIIlllIl = lllllllllllllllIIIIIlIllIIIlllll - lllllllllllllllIIIIIlIllIIlIIlIl;
                lllllllllllllllIIIIIlIllIIlIIllI = lllllllllllllllIIIIIlIllIIlIIllI.addVector((lllllllllllllllIIIIIlIllIIlIIIIl.getX() - lllllllllllllllIIIIIlIllIIlIIlll.getX()) * lllllllllllllllIIIIIlIllIIIlllIl, (lllllllllllllllIIIIIlIllIIlIIIIl.getY() - lllllllllllllllIIIIIlIllIIlIIlll.getY()) * lllllllllllllllIIIIIlIllIIIlllIl, (lllllllllllllllIIIIIlIllIIlIIIIl.getZ() - lllllllllllllllIIIIIlIllIIlIIlll.getZ()) * lllllllllllllllIIIIIlIllIIIlllIl);
            }
        }
        if ((int)lllllllllllllllIIIIIlIllIIIllIll.getBlockState(lllllllllllllllIIIIIlIllIIlIIlll).getValue(BlockLiquid.LEVEL) >= 8) {
            for (final EnumFacing lllllllllllllllIIIIIlIllIIlIIIlI : EnumFacing.Plane.HORIZONTAL) {
                final BlockPos lllllllllllllllIIIIIlIllIIlIIIII = lllllllllllllllIIIIIlIllIIlIIlll.offset(lllllllllllllllIIIIIlIllIIlIIIlI);
                if (this.isBlockSolid(lllllllllllllllIIIIIlIllIIIllIll, lllllllllllllllIIIIIlIllIIlIIIII, lllllllllllllllIIIIIlIllIIlIIIlI) || this.isBlockSolid(lllllllllllllllIIIIIlIllIIIllIll, lllllllllllllllIIIIIlIllIIlIIIII.offsetUp(), lllllllllllllllIIIIIlIllIIlIIIlI)) {
                    lllllllllllllllIIIIIlIllIIlIIllI = lllllllllllllllIIIIIlIllIIlIIllI.normalize().addVector(0.0, -6.0, 0.0);
                    break;
                }
            }
        }
        return lllllllllllllllIIIIIlIllIIlIIllI.normalize();
    }
    
    public static double func_180689_a(final IBlockAccess lllllllllllllllIIIIIlIlIlIlIllll, final BlockPos lllllllllllllllIIIIIlIlIlIllIIlI, final Material lllllllllllllllIIIIIlIlIlIlIllIl) {
        final Vec3 lllllllllllllllIIIIIlIlIlIllIIII = getDynamicLiquidForMaterial(lllllllllllllllIIIIIlIlIlIlIllIl).func_180687_h(lllllllllllllllIIIIIlIlIlIlIllll, lllllllllllllllIIIIIlIlIlIllIIlI);
        return (lllllllllllllllIIIIIlIlIlIllIIII.xCoord == 0.0 && lllllllllllllllIIIIIlIlIlIllIIII.zCoord == 0.0) ? -1000.0 : (Math.atan2(lllllllllllllllIIIIIlIlIlIllIIII.zCoord, lllllllllllllllIIIIIlIlIlIllIIII.xCoord) - 1.5707963267948966);
    }
    
    @Override
    public void randomDisplayTick(final World lllllllllllllllIIIIIlIlIllIIIlII, final BlockPos lllllllllllllllIIIIIlIlIllIIIIll, final IBlockState lllllllllllllllIIIIIlIlIllIlIIlI, final Random lllllllllllllllIIIIIlIlIllIIIIIl) {
        final double lllllllllllllllIIIIIlIlIllIlIIII = lllllllllllllllIIIIIlIlIllIIIIll.getX();
        final double lllllllllllllllIIIIIlIlIllIIllll = lllllllllllllllIIIIIlIlIllIIIIll.getY();
        final double lllllllllllllllIIIIIlIlIllIIlllI = lllllllllllllllIIIIIlIlIllIIIIll.getZ();
        if (this.blockMaterial == Material.water) {
            final int lllllllllllllllIIIIIlIlIllIIllIl = (int)lllllllllllllllIIIIIlIlIllIlIIlI.getValue(BlockLiquid.LEVEL);
            if (lllllllllllllllIIIIIlIlIllIIllIl > 0 && lllllllllllllllIIIIIlIlIllIIllIl < 8) {
                if (lllllllllllllllIIIIIlIlIllIIIIIl.nextInt(64) == 0) {
                    lllllllllllllllIIIIIlIlIllIIIlII.playSound(lllllllllllllllIIIIIlIlIllIlIIII + 0.5, lllllllllllllllIIIIIlIlIllIIllll + 0.5, lllllllllllllllIIIIIlIlIllIIlllI + 0.5, "liquid.water", lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat() * 0.25f + 0.75f, lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat() * 1.0f + 0.5f, false);
                }
            }
            else if (lllllllllllllllIIIIIlIlIllIIIIIl.nextInt(10) == 0) {
                lllllllllllllllIIIIIlIlIllIIIlII.spawnParticle(EnumParticleTypes.SUSPENDED, lllllllllllllllIIIIIlIlIllIlIIII + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat(), lllllllllllllllIIIIIlIlIllIIllll + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat(), lllllllllllllllIIIIIlIlIllIIlllI + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat(), 0.0, 0.0, 0.0, new int[0]);
            }
        }
        if (this.blockMaterial == Material.lava && lllllllllllllllIIIIIlIlIllIIIlII.getBlockState(lllllllllllllllIIIIIlIlIllIIIIll.offsetUp()).getBlock().getMaterial() == Material.air && !lllllllllllllllIIIIIlIlIllIIIlII.getBlockState(lllllllllllllllIIIIIlIlIllIIIIll.offsetUp()).getBlock().isOpaqueCube()) {
            if (lllllllllllllllIIIIIlIlIllIIIIIl.nextInt(100) == 0) {
                final double lllllllllllllllIIIIIlIlIllIIllII = lllllllllllllllIIIIIlIlIllIlIIII + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat();
                final double lllllllllllllllIIIIIlIlIllIIlIll = lllllllllllllllIIIIIlIlIllIIllll + this.maxY;
                final double lllllllllllllllIIIIIlIlIllIIlIlI = lllllllllllllllIIIIIlIlIllIIlllI + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat();
                lllllllllllllllIIIIIlIlIllIIIlII.spawnParticle(EnumParticleTypes.LAVA, lllllllllllllllIIIIIlIlIllIIllII, lllllllllllllllIIIIIlIlIllIIlIll, lllllllllllllllIIIIIlIlIllIIlIlI, 0.0, 0.0, 0.0, new int[0]);
                lllllllllllllllIIIIIlIlIllIIIlII.playSound(lllllllllllllllIIIIIlIlIllIIllII, lllllllllllllllIIIIIlIlIllIIlIll, lllllllllllllllIIIIIlIlIllIIlIlI, "liquid.lavapop", 0.2f + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat() * 0.2f, 0.9f + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat() * 0.15f, false);
            }
            if (lllllllllllllllIIIIIlIlIllIIIIIl.nextInt(200) == 0) {
                lllllllllllllllIIIIIlIlIllIIIlII.playSound(lllllllllllllllIIIIIlIlIllIlIIII, lllllllllllllllIIIIIlIlIllIIllll, lllllllllllllllIIIIIlIlIllIIlllI, "liquid.lava", 0.2f + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat() * 0.2f, 0.9f + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat() * 0.15f, false);
            }
        }
        if (lllllllllllllllIIIIIlIlIllIIIIIl.nextInt(10) == 0 && World.doesBlockHaveSolidTopSurface(lllllllllllllllIIIIIlIlIllIIIlII, lllllllllllllllIIIIIlIlIllIIIIll.offsetDown())) {
            final Material lllllllllllllllIIIIIlIlIllIIlIIl = lllllllllllllllIIIIIlIlIllIIIlII.getBlockState(lllllllllllllllIIIIIlIlIllIIIIll.offsetDown(2)).getBlock().getMaterial();
            if (!lllllllllllllllIIIIIlIlIllIIlIIl.blocksMovement() && !lllllllllllllllIIIIIlIlIllIIlIIl.isLiquid()) {
                final double lllllllllllllllIIIIIlIlIllIIlIII = lllllllllllllllIIIIIlIlIllIlIIII + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat();
                final double lllllllllllllllIIIIIlIlIllIIIlll = lllllllllllllllIIIIIlIlIllIIllll - 1.05;
                final double lllllllllllllllIIIIIlIlIllIIIllI = lllllllllllllllIIIIIlIlIllIIlllI + lllllllllllllllIIIIIlIlIllIIIIIl.nextFloat();
                if (this.blockMaterial == Material.water) {
                    lllllllllllllllIIIIIlIlIllIIIlII.spawnParticle(EnumParticleTypes.DRIP_WATER, lllllllllllllllIIIIIlIlIllIIlIII, lllllllllllllllIIIIIlIlIllIIIlll, lllllllllllllllIIIIIlIlIllIIIllI, 0.0, 0.0, 0.0, new int[0]);
                }
                else {
                    lllllllllllllllIIIIIlIlIllIIIlII.spawnParticle(EnumParticleTypes.DRIP_LAVA, lllllllllllllllIIIIIlIlIllIIlIII, lllllllllllllllIIIIIlIlIllIIIlll, lllllllllllllllIIIIIlIlIllIIIllI, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
    }
    
    @Override
    public int getMixedBrightnessForBlock(final IBlockAccess lllllllllllllllIIIIIlIlIlllIlllI, final BlockPos lllllllllllllllIIIIIlIlIllllIlIl) {
        final int lllllllllllllllIIIIIlIlIllllIlII = lllllllllllllllIIIIIlIlIlllIlllI.getCombinedLight(lllllllllllllllIIIIIlIlIllllIlIl, 0);
        final int lllllllllllllllIIIIIlIlIllllIIll = lllllllllllllllIIIIIlIlIlllIlllI.getCombinedLight(lllllllllllllllIIIIIlIlIllllIlIl.offsetUp(), 0);
        final int lllllllllllllllIIIIIlIlIllllIIlI = lllllllllllllllIIIIIlIlIllllIlII & 0xFF;
        final int lllllllllllllllIIIIIlIlIllllIIIl = lllllllllllllllIIIIIlIlIllllIIll & 0xFF;
        final int lllllllllllllllIIIIIlIlIllllIIII = lllllllllllllllIIIIIlIlIllllIlII >> 16 & 0xFF;
        final int lllllllllllllllIIIIIlIlIlllIllll = lllllllllllllllIIIIIlIlIllllIIll >> 16 & 0xFF;
        return ((lllllllllllllllIIIIIlIlIllllIIlI > lllllllllllllllIIIIIlIlIllllIIIl) ? lllllllllllllllIIIIIlIlIllllIIlI : lllllllllllllllIIIIIlIlIllllIIIl) | ((lllllllllllllllIIIIIlIlIllllIIII > lllllllllllllllIIIIIlIlIlllIllll) ? lllllllllllllllIIIIIlIlIllllIIII : lllllllllllllllIIIIIlIlIlllIllll) << 16;
    }
    
    protected int func_176366_f(final IBlockAccess lllllllllllllllIIIIIlIllIlllllIl, final BlockPos lllllllllllllllIIIIIlIlllIIIIIII) {
        final int lllllllllllllllIIIIIlIllIlllllll = this.func_176362_e(lllllllllllllllIIIIIlIllIlllllIl, lllllllllllllllIIIIIlIlllIIIIIII);
        return (lllllllllllllllIIIIIlIllIlllllll >= 8) ? 0 : lllllllllllllllIIIIIlIllIlllllll;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIIIIIlIlIlIlIIllI, final BlockPos lllllllllllllllIIIIIlIlIlIlIIIIl, final IBlockState lllllllllllllllIIIIIlIlIlIlIIlII) {
        this.func_176365_e(lllllllllllllllIIIIIlIlIlIlIIllI, lllllllllllllllIIIIIlIlIlIlIIIIl, lllllllllllllllIIIIIlIlIlIlIIlII);
    }
    
    @Override
    public int getRenderType() {
        return 1;
    }
    
    static {
        __OBFID = "CL_00000265";
        LEVEL = PropertyInteger.create("level", 0, 15);
    }
    
    public static BlockStaticLiquid getStaticLiquidForMaterial(final Material lllllllllllllllIIIIIlIlIIlIlIIlI) {
        if (lllllllllllllllIIIIIlIlIIlIlIIlI == Material.water) {
            return Blocks.water;
        }
        if (lllllllllllllllIIIIIlIlIIlIlIIlI == Material.lava) {
            return Blocks.lava;
        }
        throw new IllegalArgumentException("Invalid material");
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllIIIIIlIllIIllllIl, final BlockPos lllllllllllllllIIIIIlIllIIllllII, final IBlockState lllllllllllllllIIIIIlIllIIlllIll) {
        return null;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockLiquid.LEVEL });
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess lllllllllllllllIIIIIlIllIlIlllIl, final BlockPos lllllllllllllllIIIIIlIllIlIlllII, final EnumFacing lllllllllllllllIIIIIlIllIlIlIlll) {
        return lllllllllllllllIIIIIlIllIlIlllIl.getBlockState(lllllllllllllllIIIIIlIllIlIlllII).getBlock().getMaterial() != this.blockMaterial && (lllllllllllllllIIIIIlIllIlIlIlll == EnumFacing.UP || super.shouldSideBeRendered(lllllllllllllllIIIIIlIllIlIlllIl, lllllllllllllllIIIIIlIllIlIlllII, lllllllllllllllIIIIIlIllIlIlIlll));
    }
    
    public static BlockDynamicLiquid getDynamicLiquidForMaterial(final Material lllllllllllllllIIIIIlIlIIlIlIlIl) {
        if (lllllllllllllllIIIIIlIlIIlIlIlIl == Material.water) {
            return Blocks.flowing_water;
        }
        if (lllllllllllllllIIIIIlIlIIlIlIlIl == Material.lava) {
            return Blocks.flowing_lava;
        }
        throw new IllegalArgumentException("Invalid material");
    }
}
