package net.minecraft.world.biome;

import java.util.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.monster.*;

public class BiomeGenSwamp extends BiomeGenBase
{
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIIIlIllIIllIIIlIlI) {
        return this.worldGeneratorSwamp;
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllllIIIlIllIIlIlllIIII, final Random llllllllllllllIIIlIllIIlIllIIlII, final ChunkPrimer llllllllllllllIIIlIllIIlIllIlllI, final int llllllllllllllIIIlIllIIlIllIllIl, final int llllllllllllllIIIlIllIIlIllIIIIl, final double llllllllllllllIIIlIllIIlIllIlIll) {
        final double llllllllllllllIIIlIllIIlIllIlIlI = BiomeGenSwamp.field_180281_af.func_151601_a(llllllllllllllIIIlIllIIlIllIllIl * 0.25, llllllllllllllIIIlIllIIlIllIIIIl * 0.25);
        if (llllllllllllllIIIlIllIIlIllIlIlI > 0.0) {
            final int llllllllllllllIIIlIllIIlIllIlIIl = llllllllllllllIIIlIllIIlIllIllIl & 0xF;
            final int llllllllllllllIIIlIllIIlIllIlIII = llllllllllllllIIIlIllIIlIllIIIIl & 0xF;
            int llllllllllllllIIIlIllIIlIllIIlll = 255;
            while (llllllllllllllIIIlIllIIlIllIIlll >= 0) {
                if (llllllllllllllIIIlIllIIlIllIlllI.getBlockState(llllllllllllllIIIlIllIIlIllIlIII, llllllllllllllIIIlIllIIlIllIIlll, llllllllllllllIIIlIllIIlIllIlIIl).getBlock().getMaterial() != Material.air) {
                    if (llllllllllllllIIIlIllIIlIllIIlll != 62 || llllllllllllllIIIlIllIIlIllIlllI.getBlockState(llllllllllllllIIIlIllIIlIllIlIII, llllllllllllllIIIlIllIIlIllIIlll, llllllllllllllIIIlIllIIlIllIlIIl).getBlock() == Blocks.water) {
                        break;
                    }
                    llllllllllllllIIIlIllIIlIllIlllI.setBlockState(llllllllllllllIIIlIllIIlIllIlIII, llllllllllllllIIIlIllIIlIllIIlll, llllllllllllllIIIlIllIIlIllIlIIl, Blocks.water.getDefaultState());
                    if (llllllllllllllIIIlIllIIlIllIlIlI < 0.12) {
                        llllllllllllllIIIlIllIIlIllIlllI.setBlockState(llllllllllllllIIIlIllIIlIllIlIII, llllllllllllllIIIlIllIIlIllIIlll + 1, llllllllllllllIIIlIllIIlIllIlIIl, Blocks.waterlily.getDefaultState());
                        break;
                    }
                    break;
                }
                else {
                    --llllllllllllllIIIlIllIIlIllIIlll;
                }
            }
        }
        this.func_180628_b(llllllllllllllIIIlIllIIlIlllIIII, llllllllllllllIIIlIllIIlIllIIlII, llllllllllllllIIIlIllIIlIllIlllI, llllllllllllllIIIlIllIIlIllIllIl, llllllllllllllIIIlIllIIlIllIIIIl, llllllllllllllIIIlIllIIlIllIlIll);
    }
    
    static {
        __OBFID = "CL_00000185";
    }
    
    @Override
    public int func_180627_b(final BlockPos llllllllllllllIIIlIllIIllIIIIIll) {
        final double llllllllllllllIIIlIllIIllIIIIlII = BiomeGenSwamp.field_180281_af.func_151601_a(llllllllllllllIIIlIllIIllIIIIIll.getX() * 0.0225, llllllllllllllIIIlIllIIllIIIIIll.getZ() * 0.0225);
        return (llllllllllllllIIIlIllIIllIIIIlII < -0.1) ? 5011004 : 6975545;
    }
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random llllllllllllllIIIlIllIIlIllllllI, final BlockPos llllllllllllllIIIlIllIIlIlllllIl) {
        return BlockFlower.EnumFlowerType.BLUE_ORCHID;
    }
    
    protected BiomeGenSwamp(final int llllllllllllllIIIlIllIIllIIIllll) {
        super(llllllllllllllIIIlIllIIllIIIllll);
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 1;
        this.theBiomeDecorator.mushroomsPerChunk = 8;
        this.theBiomeDecorator.reedsPerChunk = 10;
        this.theBiomeDecorator.clayPerChunk = 1;
        this.theBiomeDecorator.waterlilyPerChunk = 4;
        this.theBiomeDecorator.sandPerChunk2 = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 5;
        this.waterColorMultiplier = 14745518;
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));
    }
    
    @Override
    public int func_180625_c(final BlockPos llllllllllllllIIIlIllIIllIIIIIII) {
        return 6975545;
    }
}
