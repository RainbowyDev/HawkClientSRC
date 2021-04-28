package net.minecraft.world.biome;

import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.gen.feature.*;

public class BiomeGenDesert extends BiomeGenBase
{
    static {
        __OBFID = "CL_00000167";
    }
    
    public BiomeGenDesert(final int llllllllllllllllIIIllIlIlIlIIIll) {
        super(llllllllllllllllIIIllIlIlIlIIIll);
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.sand.getDefaultState();
        this.fillerBlock = Blocks.sand.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 50;
        this.theBiomeDecorator.cactiPerChunk = 10;
        this.spawnableCreatureList.clear();
    }
    
    @Override
    public void func_180624_a(final World llllllllllllllllIIIllIlIlIIlIIll, final Random llllllllllllllllIIIllIlIlIIlIIlI, final BlockPos llllllllllllllllIIIllIlIlIIlIIIl) {
        super.func_180624_a(llllllllllllllllIIIllIlIlIIlIIll, llllllllllllllllIIIllIlIlIIlIIlI, llllllllllllllllIIIllIlIlIIlIIIl);
        if (llllllllllllllllIIIllIlIlIIlIIlI.nextInt(1000) == 0) {
            final int llllllllllllllllIIIllIlIlIIlIlll = llllllllllllllllIIIllIlIlIIlIIlI.nextInt(16) + 8;
            final int llllllllllllllllIIIllIlIlIIlIllI = llllllllllllllllIIIllIlIlIIlIIlI.nextInt(16) + 8;
            final BlockPos llllllllllllllllIIIllIlIlIIlIlIl = llllllllllllllllIIIllIlIlIIlIIll.getHorizon(llllllllllllllllIIIllIlIlIIlIIIl.add(llllllllllllllllIIIllIlIlIIlIlll, 0, llllllllllllllllIIIllIlIlIIlIllI)).offsetUp();
            new WorldGenDesertWells().generate(llllllllllllllllIIIllIlIlIIlIIll, llllllllllllllllIIIllIlIlIIlIIlI, llllllllllllllllIIIllIlIlIIlIlIl);
        }
    }
}
