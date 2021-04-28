package net.minecraft.world.biome;

import net.minecraft.entity.monster.*;

public class BiomeGenHell extends BiomeGenBase
{
    public BiomeGenHell(final int lIIlllllllllIlI) {
        super(lIIlllllllllIlI);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 50, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 1, 4, 4));
    }
    
    static {
        __OBFID = "CL_00000173";
    }
}
