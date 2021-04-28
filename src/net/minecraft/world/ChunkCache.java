package net.minecraft.world;

import net.minecraft.world.chunk.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;

public class ChunkCache implements IBlockAccess
{
    protected /* synthetic */ boolean hasExtendedLevels;
    protected /* synthetic */ int chunkZ;
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ int chunkX;
    protected /* synthetic */ Chunk[][] chunkArray;
    
    @Override
    public TileEntity getTileEntity(final BlockPos lllllllllllllllIIIllIIIlIIIllIIl) {
        final int lllllllllllllllIIIllIIIlIIIllIII = (lllllllllllllllIIIllIIIlIIIllIIl.getX() >> 4) - this.chunkX;
        final int lllllllllllllllIIIllIIIlIIIlIlll = (lllllllllllllllIIIllIIIlIIIllIIl.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[lllllllllllllllIIIllIIIlIIIllIII][lllllllllllllllIIIllIIIlIIIlIlll].func_177424_a(lllllllllllllllIIIllIIIlIIIllIIl, Chunk.EnumCreateEntityType.IMMEDIATE);
    }
    
    @Override
    public WorldType getWorldType() {
        return this.worldObj.getWorldType();
    }
    
    @Override
    public int getStrongPower(final BlockPos lllllllllllllllIIIllIIIIlIllIIll, final EnumFacing lllllllllllllllIIIllIIIIlIllIllI) {
        final IBlockState lllllllllllllllIIIllIIIIlIllIlIl = this.getBlockState(lllllllllllllllIIIllIIIIlIllIIll);
        return lllllllllllllllIIIllIIIIlIllIlIl.getBlock().isProvidingStrongPower(this, lllllllllllllllIIIllIIIIlIllIIll, lllllllllllllllIIIllIIIIlIllIlIl, lllllllllllllllIIIllIIIIlIllIllI);
    }
    
    static {
        __OBFID = "CL_00000155";
    }
    
    @Override
    public BiomeGenBase getBiomeGenForCoords(final BlockPos lllllllllllllllIIIllIIIIllllIIIl) {
        return this.worldObj.getBiomeGenForCoords(lllllllllllllllIIIllIIIIllllIIIl);
    }
    
    private int func_175629_a(final EnumSkyBlock lllllllllllllllIIIllIIIIllIllIIl, final BlockPos lllllllllllllllIIIllIIIIllIllIII) {
        if (lllllllllllllllIIIllIIIIllIllIIl == EnumSkyBlock.SKY && this.worldObj.provider.getHasNoSky()) {
            return 0;
        }
        if (lllllllllllllllIIIllIIIIllIllIII.getY() < 0 || lllllllllllllllIIIllIIIIllIllIII.getY() >= 256) {
            return lllllllllllllllIIIllIIIIllIllIIl.defaultLightValue;
        }
        if (this.getBlockState(lllllllllllllllIIIllIIIIllIllIII).getBlock().getUseNeighborBrightness()) {
            int lllllllllllllllIIIllIIIIlllIIIlI = 0;
            for (final EnumFacing lllllllllllllllIIIllIIIIllIlllIl : EnumFacing.values()) {
                final int lllllllllllllllIIIllIIIIllIlllII = this.func_175628_b(lllllllllllllllIIIllIIIIllIllIIl, lllllllllllllllIIIllIIIIllIllIII.offset(lllllllllllllllIIIllIIIIllIlllIl));
                if (lllllllllllllllIIIllIIIIllIlllII > lllllllllllllllIIIllIIIIlllIIIlI) {
                    lllllllllllllllIIIllIIIIlllIIIlI = lllllllllllllllIIIllIIIIllIlllII;
                }
                if (lllllllllllllllIIIllIIIIlllIIIlI >= 15) {
                    return lllllllllllllllIIIllIIIIlllIIIlI;
                }
            }
            return lllllllllllllllIIIllIIIIlllIIIlI;
        }
        final int lllllllllllllllIIIllIIIIlllIIIIl = (lllllllllllllllIIIllIIIIllIllIII.getX() >> 4) - this.chunkX;
        final int lllllllllllllllIIIllIIIIllIllIll = (lllllllllllllllIIIllIIIIllIllIII.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[lllllllllllllllIIIllIIIIlllIIIIl][lllllllllllllllIIIllIIIIllIllIll].getLightFor(lllllllllllllllIIIllIIIIllIllIIl, lllllllllllllllIIIllIIIIllIllIII);
    }
    
    @Override
    public int getCombinedLight(final BlockPos lllllllllllllllIIIllIIIlIIIIIlll, final int lllllllllllllllIIIllIIIlIIIIIllI) {
        final int lllllllllllllllIIIllIIIlIIIIlIlI = this.func_175629_a(EnumSkyBlock.SKY, lllllllllllllllIIIllIIIlIIIIIlll);
        int lllllllllllllllIIIllIIIlIIIIlIIl = this.func_175629_a(EnumSkyBlock.BLOCK, lllllllllllllllIIIllIIIlIIIIIlll);
        if (lllllllllllllllIIIllIIIlIIIIlIIl < lllllllllllllllIIIllIIIlIIIIIllI) {
            lllllllllllllllIIIllIIIlIIIIlIIl = lllllllllllllllIIIllIIIlIIIIIllI;
        }
        return lllllllllllllllIIIllIIIlIIIIlIlI << 20 | lllllllllllllllIIIllIIIlIIIIlIIl << 4;
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos lllllllllllllllIIIllIIIIllllllIl) {
        if (lllllllllllllllIIIllIIIIllllllIl.getY() >= 0 && lllllllllllllllIIIllIIIIllllllIl.getY() < 256) {
            final int lllllllllllllllIIIllIIIIllllllII = (lllllllllllllllIIIllIIIIllllllIl.getX() >> 4) - this.chunkX;
            final int lllllllllllllllIIIllIIIIlllllIll = (lllllllllllllllIIIllIIIIllllllIl.getZ() >> 4) - this.chunkZ;
            if (lllllllllllllllIIIllIIIIllllllII >= 0 && lllllllllllllllIIIllIIIIllllllII < this.chunkArray.length && lllllllllllllllIIIllIIIIlllllIll >= 0 && lllllllllllllllIIIllIIIIlllllIll < this.chunkArray[lllllllllllllllIIIllIIIIllllllII].length) {
                final Chunk lllllllllllllllIIIllIIIIlllllIlI = this.chunkArray[lllllllllllllllIIIllIIIIllllllII][lllllllllllllllIIIllIIIIlllllIll];
                if (lllllllllllllllIIIllIIIIlllllIlI != null) {
                    return lllllllllllllllIIIllIIIIlllllIlI.getBlockState(lllllllllllllllIIIllIIIIllllllIl);
                }
            }
        }
        return Blocks.air.getDefaultState();
    }
    
    public int func_175628_b(final EnumSkyBlock lllllllllllllllIIIllIIIIllIIIlIl, final BlockPos lllllllllllllllIIIllIIIIlIllllll) {
        if (lllllllllllllllIIIllIIIIlIllllll.getY() >= 0 && lllllllllllllllIIIllIIIIlIllllll.getY() < 256) {
            final int lllllllllllllllIIIllIIIIllIIIIll = (lllllllllllllllIIIllIIIIlIllllll.getX() >> 4) - this.chunkX;
            final int lllllllllllllllIIIllIIIIllIIIIlI = (lllllllllllllllIIIllIIIIlIllllll.getZ() >> 4) - this.chunkZ;
            return this.chunkArray[lllllllllllllllIIIllIIIIllIIIIll][lllllllllllllllIIIllIIIIllIIIIlI].getLightFor(lllllllllllllllIIIllIIIIllIIIlIl, lllllllllllllllIIIllIIIIlIllllll);
        }
        return lllllllllllllllIIIllIIIIllIIIlIl.defaultLightValue;
    }
    
    public ChunkCache(final World lllllllllllllllIIIllIIIlIIllIlIl, final BlockPos lllllllllllllllIIIllIIIlIIllIlII, final BlockPos lllllllllllllllIIIllIIIlIIllIIll, final int lllllllllllllllIIIllIIIlIIllIIlI) {
        this.worldObj = lllllllllllllllIIIllIIIlIIllIlIl;
        this.chunkX = lllllllllllllllIIIllIIIlIIllIlII.getX() - lllllllllllllllIIIllIIIlIIllIIlI >> 4;
        this.chunkZ = lllllllllllllllIIIllIIIlIIllIlII.getZ() - lllllllllllllllIIIllIIIlIIllIIlI >> 4;
        final int lllllllllllllllIIIllIIIlIIllIIIl = lllllllllllllllIIIllIIIlIIllIIll.getX() + lllllllllllllllIIIllIIIlIIllIIlI >> 4;
        final int lllllllllllllllIIIllIIIlIIllIIII = lllllllllllllllIIIllIIIlIIllIIll.getZ() + lllllllllllllllIIIllIIIlIIllIIlI >> 4;
        this.chunkArray = new Chunk[lllllllllllllllIIIllIIIlIIllIIIl - this.chunkX + 1][lllllllllllllllIIIllIIIlIIllIIII - this.chunkZ + 1];
        this.hasExtendedLevels = true;
        for (int lllllllllllllllIIIllIIIlIIlIllll = this.chunkX; lllllllllllllllIIIllIIIlIIlIllll <= lllllllllllllllIIIllIIIlIIllIIIl; ++lllllllllllllllIIIllIIIlIIlIllll) {
            for (int lllllllllllllllIIIllIIIlIIlIlllI = this.chunkZ; lllllllllllllllIIIllIIIlIIlIlllI <= lllllllllllllllIIIllIIIlIIllIIII; ++lllllllllllllllIIIllIIIlIIlIlllI) {
                this.chunkArray[lllllllllllllllIIIllIIIlIIlIllll - this.chunkX][lllllllllllllllIIIllIIIlIIlIlllI - this.chunkZ] = lllllllllllllllIIIllIIIlIIllIlIl.getChunkFromChunkCoords(lllllllllllllllIIIllIIIlIIlIllll, lllllllllllllllIIIllIIIlIIlIlllI);
            }
        }
        for (int lllllllllllllllIIIllIIIlIIlIllll = lllllllllllllllIIIllIIIlIIllIlII.getX() >> 4; lllllllllllllllIIIllIIIlIIlIllll <= lllllllllllllllIIIllIIIlIIllIIll.getX() >> 4; ++lllllllllllllllIIIllIIIlIIlIllll) {
            for (int lllllllllllllllIIIllIIIlIIlIllIl = lllllllllllllllIIIllIIIlIIllIlII.getZ() >> 4; lllllllllllllllIIIllIIIlIIlIllIl <= lllllllllllllllIIIllIIIlIIllIIll.getZ() >> 4; ++lllllllllllllllIIIllIIIlIIlIllIl) {
                final Chunk lllllllllllllllIIIllIIIlIIlIllII = this.chunkArray[lllllllllllllllIIIllIIIlIIlIllll - this.chunkX][lllllllllllllllIIIllIIIlIIlIllIl - this.chunkZ];
                if (lllllllllllllllIIIllIIIlIIlIllII != null && !lllllllllllllllIIIllIIIlIIlIllII.getAreLevelsEmpty(lllllllllllllllIIIllIIIlIIllIlII.getY(), lllllllllllllllIIIllIIIlIIllIIll.getY())) {
                    this.hasExtendedLevels = false;
                }
            }
        }
    }
    
    @Override
    public boolean extendedLevelsInChunkCache() {
        return this.hasExtendedLevels;
    }
    
    @Override
    public boolean isAirBlock(final BlockPos lllllllllllllllIIIllIIIIllIIlllI) {
        return this.getBlockState(lllllllllllllllIIIllIIIIllIIlllI).getBlock().getMaterial() == Material.air;
    }
}
