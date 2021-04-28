package net.minecraft.world.biome;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.world.gen.feature.*;

public class BiomeGenJungle extends BiomeGenBase
{
    private /* synthetic */ boolean field_150614_aC;
    
    static {
        __OBFID = "CL_00000175";
    }
    
    @Override
    public WorldGenerator getRandomWorldGenForGrass(final Random llllllllllllllIIIIlIlllIIIIIIIII) {
        return (llllllllllllllIIIIlIlllIIIIIIIII.nextInt(4) == 0) ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIIIIlIlllIIIIIIlII) {
        return (llllllllllllllIIIIlIlllIIIIIIlII.nextInt(10) == 0) ? this.worldGeneratorBigTree : ((llllllllllllllIIIIlIlllIIIIIIlII.nextInt(2) == 0) ? new WorldGenShrub(BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.OAK.func_176839_a()) : ((!this.field_150614_aC && llllllllllllllIIIIlIlllIIIIIIlII.nextInt(3) == 0) ? new WorldGenMegaJungle(false, 10, 20, BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a()) : new WorldGenTrees(false, 4 + llllllllllllllIIIIlIlllIIIIIIlII.nextInt(7), BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a(), true)));
    }
    
    public BiomeGenJungle(final int llllllllllllllIIIIlIlllIIIIIlllI, final boolean llllllllllllllIIIIlIlllIIIIIlIlI) {
        super(llllllllllllllIIIIlIlllIIIIIlllI);
        this.field_150614_aC = llllllllllllllIIIIlIlllIIIIIlIlI;
        if (llllllllllllllIIIIlIlllIIIIIlIlI) {
            this.theBiomeDecorator.treesPerChunk = 2;
        }
        else {
            this.theBiomeDecorator.treesPerChunk = 50;
        }
        this.theBiomeDecorator.grassPerChunk = 25;
        this.theBiomeDecorator.flowersPerChunk = 4;
        if (!llllllllllllllIIIIlIlllIIIIIlIlI) {
            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        }
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
    }
    
    @Override
    public void func_180624_a(final World llllllllllllllIIIIlIllIlllllIlII, final Random llllllllllllllIIIIlIllIllllIlIIl, final BlockPos llllllllllllllIIIIlIllIllllIlIII) {
        super.func_180624_a(llllllllllllllIIIIlIllIlllllIlII, llllllllllllllIIIIlIllIllllIlIIl, llllllllllllllIIIIlIllIllllIlIII);
        final int llllllllllllllIIIIlIllIlllllIIIl = llllllllllllllIIIIlIllIllllIlIIl.nextInt(16) + 8;
        int llllllllllllllIIIIlIllIlllllIIII = llllllllllllllIIIIlIllIllllIlIIl.nextInt(16) + 8;
        int llllllllllllllIIIIlIllIllllIllll = llllllllllllllIIIIlIllIllllIlIIl.nextInt(llllllllllllllIIIIlIllIlllllIlII.getHorizon(llllllllllllllIIIIlIllIllllIlIII.add(llllllllllllllIIIIlIllIlllllIIIl, 0, llllllllllllllIIIIlIllIlllllIIII)).getY() * 2);
        new WorldGenMelon().generate(llllllllllllllIIIIlIllIlllllIlII, llllllllllllllIIIIlIllIllllIlIIl, llllllllllllllIIIIlIllIllllIlIII.add(llllllllllllllIIIIlIllIlllllIIIl, llllllllllllllIIIIlIllIllllIllll, llllllllllllllIIIIlIllIlllllIIII));
        final WorldGenVines llllllllllllllIIIIlIllIllllIlllI = new WorldGenVines();
        for (llllllllllllllIIIIlIllIlllllIIII = 0; llllllllllllllIIIIlIllIlllllIIII < 50; ++llllllllllllllIIIIlIllIlllllIIII) {
            llllllllllllllIIIIlIllIllllIllll = llllllllllllllIIIIlIllIllllIlIIl.nextInt(16) + 8;
            final boolean llllllllllllllIIIIlIllIllllIllIl = true;
            final int llllllllllllllIIIIlIllIllllIllII = llllllllllllllIIIIlIllIllllIlIIl.nextInt(16) + 8;
            llllllllllllllIIIIlIllIllllIlllI.generate(llllllllllllllIIIIlIllIlllllIlII, llllllllllllllIIIIlIllIllllIlIIl, llllllllllllllIIIIlIllIllllIlIII.add(llllllllllllllIIIIlIllIllllIllll, 128, llllllllllllllIIIIlIllIllllIllII));
        }
    }
}
