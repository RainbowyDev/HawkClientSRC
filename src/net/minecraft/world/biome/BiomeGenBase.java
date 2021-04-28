package net.minecraft.world.biome;

import net.minecraft.block.state.*;
import net.minecraft.world.gen.*;
import net.minecraft.init.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import java.awt.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.util.*;

public abstract class BiomeGenBase
{
    public static final /* synthetic */ BiomeGenBase savanna;
    public /* synthetic */ IBlockState topBlock;
    protected static final /* synthetic */ Height height_MidHills;
    public /* synthetic */ int waterColorMultiplier;
    protected static final /* synthetic */ Height height_LowPlains;
    public /* synthetic */ float rainfall;
    public static final /* synthetic */ BiomeGenBase roofedForest;
    public static final /* synthetic */ BiomeGenBase sky;
    protected static final /* synthetic */ Height height_ShallowWaters;
    public /* synthetic */ int color;
    protected /* synthetic */ boolean enableSnow;
    protected /* synthetic */ List spawnableMonsterList;
    protected static final /* synthetic */ Height height_LowHills;
    protected /* synthetic */ boolean enableRain;
    public static final /* synthetic */ BiomeGenBase ocean;
    public static final /* synthetic */ BiomeGenBase frozenOcean;
    protected static final /* synthetic */ Height height_Oceans;
    public static final /* synthetic */ BiomeGenBase taiga;
    public /* synthetic */ int fillerBlockMetadata;
    protected static final /* synthetic */ Height height_RockyWaters;
    public /* synthetic */ BiomeDecorator theBiomeDecorator;
    public /* synthetic */ int field_150609_ah;
    protected /* synthetic */ List spawnableCreatureList;
    protected /* synthetic */ List spawnableCaveCreatureList;
    public static final /* synthetic */ BiomeGenBase birchForest;
    public static final /* synthetic */ BiomeGenBase birchForestHills;
    public /* synthetic */ String biomeName;
    public static final /* synthetic */ BiomeGenBase extremeHills;
    public /* synthetic */ IBlockState fillerBlock;
    public /* synthetic */ float maxHeight;
    protected /* synthetic */ WorldGenBigTree worldGeneratorBigTree;
    protected /* synthetic */ WorldGenTrees worldGeneratorTrees;
    protected static final /* synthetic */ Height height_MidPlains;
    public static final /* synthetic */ BiomeGenBase mesa;
    protected static final /* synthetic */ Height height_PartiallySubmerged;
    protected static final /* synthetic */ Height height_DeepOceans;
    protected /* synthetic */ List spawnableWaterCreatureList;
    public static final /* synthetic */ BiomeGenBase icePlains;
    public static final /* synthetic */ BiomeGenBase megaTaigaHills;
    public /* synthetic */ float temperature;
    protected static final /* synthetic */ Height height_Shores;
    public final /* synthetic */ int biomeID;
    protected static final /* synthetic */ Height height_Default;
    protected static final /* synthetic */ Height height_HighPlateaus;
    public static final /* synthetic */ BiomeGenBase mesaPlateau;
    public /* synthetic */ float minHeight;
    public static final /* synthetic */ BiomeGenBase desert;
    public static final /* synthetic */ BiomeGenBase megaTaiga;
    private static final /* synthetic */ BiomeGenBase[] biomeList;
    public static final /* synthetic */ Set explorationBiomesList;
    public static final /* synthetic */ BiomeGenBase mesaPlateau_F;
    public static final /* synthetic */ BiomeGenBase plains;
    public static final /* synthetic */ BiomeGenBase extremeHillsPlus;
    protected static final /* synthetic */ Height height_LowIslands;
    public static final /* synthetic */ BiomeGenBase forest;
    private static final /* synthetic */ Logger logger;
    public static final /* synthetic */ BiomeGenBase coldTaiga;
    public static final /* synthetic */ Map field_180278_o;
    public static final /* synthetic */ BiomeGenBase hell;
    protected /* synthetic */ WorldGenSwamp worldGeneratorSwamp;
    public static final /* synthetic */ BiomeGenBase swampland;
    protected static final /* synthetic */ NoiseGeneratorPerlin temperatureNoise;
    public static final /* synthetic */ BiomeGenBase savannaPlateau;
    public static final /* synthetic */ BiomeGenBase jungleEdge;
    public static final /* synthetic */ BiomeGenBase extremeHillsEdge;
    public static final /* synthetic */ BiomeGenBase jungle;
    
    public final int getIntRainfall() {
        return (int)(this.rainfall * 65536.0f);
    }
    
    public final float getFloatRainfall() {
        return this.rainfall;
    }
    
    protected BiomeGenBase setColor(final int lllllllllllllllllIIIlIIIIlIllllI) {
        this.func_150557_a(lllllllllllllllllIIIlIIIIlIllllI, false);
        return this;
    }
    
    protected BiomeGenBase(final int lllllllllllllllllIIIlIIIlIIlIIIl) {
        this.topBlock = Blocks.grass.getDefaultState();
        this.fillerBlock = Blocks.dirt.getDefaultState();
        this.fillerBlockMetadata = 5169201;
        this.minHeight = BiomeGenBase.height_Default.rootHeight;
        this.maxHeight = BiomeGenBase.height_Default.variation;
        this.temperature = 0.5f;
        this.rainfall = 0.5f;
        this.waterColorMultiplier = 16777215;
        this.spawnableMonsterList = Lists.newArrayList();
        this.spawnableCreatureList = Lists.newArrayList();
        this.spawnableWaterCreatureList = Lists.newArrayList();
        this.spawnableCaveCreatureList = Lists.newArrayList();
        this.enableRain = true;
        this.worldGeneratorTrees = new WorldGenTrees(false);
        this.worldGeneratorBigTree = new WorldGenBigTree(false);
        this.worldGeneratorSwamp = new WorldGenSwamp();
        this.biomeID = lllllllllllllllllIIIlIIIlIIlIIIl;
        BiomeGenBase.biomeList[lllllllllllllllllIIIlIIIlIIlIIIl] = this;
        this.theBiomeDecorator = this.createBiomeDecorator();
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 10, 3, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
    }
    
    protected BiomeGenBase func_150563_c(final int lllllllllllllllllIIIlIIIIlIllIII) {
        this.field_150609_ah = lllllllllllllllllIIIlIIIIlIllIII;
        return this;
    }
    
    public void func_180624_a(final World lllllllllllllllllIIIlIIIIIlIIlII, final Random lllllllllllllllllIIIlIIIIIIlllll, final BlockPos lllllllllllllllllIIIlIIIIIlIIIlI) {
        this.theBiomeDecorator.func_180292_a(lllllllllllllllllIIIlIIIIIlIIlII, lllllllllllllllllIIIlIIIIIIlllll, this, lllllllllllllllllIIIlIIIIIlIIIlI);
    }
    
    public final void func_180628_b(final World lllllllllllllllllIIIIlllllIlllIl, final Random lllllllllllllllllIIIIlllllIlllII, final ChunkPrimer lllllllllllllllllIIIIlllllIIllII, final int lllllllllllllllllIIIIlllllIIlIll, final int lllllllllllllllllIIIIlllllIllIIl, final double lllllllllllllllllIIIIlllllIIlIIl) {
        final boolean lllllllllllllllllIIIIlllllIlIlll = true;
        IBlockState lllllllllllllllllIIIIlllllIlIllI = this.topBlock;
        IBlockState lllllllllllllllllIIIIlllllIlIlIl = this.fillerBlock;
        int lllllllllllllllllIIIIlllllIlIlII = -1;
        final int lllllllllllllllllIIIIlllllIlIIll = (int)(lllllllllllllllllIIIIlllllIIlIIl / 3.0 + 3.0 + lllllllllllllllllIIIIlllllIlllII.nextDouble() * 0.25);
        final int lllllllllllllllllIIIIlllllIlIIlI = lllllllllllllllllIIIIlllllIIlIll & 0xF;
        final int lllllllllllllllllIIIIlllllIlIIIl = lllllllllllllllllIIIIlllllIllIIl & 0xF;
        for (int lllllllllllllllllIIIIlllllIlIIII = 255; lllllllllllllllllIIIIlllllIlIIII >= 0; --lllllllllllllllllIIIIlllllIlIIII) {
            if (lllllllllllllllllIIIIlllllIlIIII <= lllllllllllllllllIIIIlllllIlllII.nextInt(5)) {
                lllllllllllllllllIIIIlllllIIllII.setBlockState(lllllllllllllllllIIIIlllllIlIIIl, lllllllllllllllllIIIIlllllIlIIII, lllllllllllllllllIIIIlllllIlIIlI, Blocks.bedrock.getDefaultState());
            }
            else {
                final IBlockState lllllllllllllllllIIIIlllllIIllll = lllllllllllllllllIIIIlllllIIllII.getBlockState(lllllllllllllllllIIIIlllllIlIIIl, lllllllllllllllllIIIIlllllIlIIII, lllllllllllllllllIIIIlllllIlIIlI);
                if (lllllllllllllllllIIIIlllllIIllll.getBlock().getMaterial() == Material.air) {
                    lllllllllllllllllIIIIlllllIlIlII = -1;
                }
                else if (lllllllllllllllllIIIIlllllIIllll.getBlock() == Blocks.stone) {
                    if (lllllllllllllllllIIIIlllllIlIlII == -1) {
                        if (lllllllllllllllllIIIIlllllIlIIll <= 0) {
                            lllllllllllllllllIIIIlllllIlIllI = null;
                            lllllllllllllllllIIIIlllllIlIlIl = Blocks.stone.getDefaultState();
                        }
                        else if (lllllllllllllllllIIIIlllllIlIIII >= 59 && lllllllllllllllllIIIIlllllIlIIII <= 64) {
                            lllllllllllllllllIIIIlllllIlIllI = this.topBlock;
                            lllllllllllllllllIIIIlllllIlIlIl = this.fillerBlock;
                        }
                        if (lllllllllllllllllIIIIlllllIlIIII < 63 && (lllllllllllllllllIIIIlllllIlIllI == null || lllllllllllllllllIIIIlllllIlIllI.getBlock().getMaterial() == Material.air)) {
                            if (this.func_180626_a(new BlockPos(lllllllllllllllllIIIIlllllIIlIll, lllllllllllllllllIIIIlllllIlIIII, lllllllllllllllllIIIIlllllIllIIl)) < 0.15f) {
                                lllllllllllllllllIIIIlllllIlIllI = Blocks.ice.getDefaultState();
                            }
                            else {
                                lllllllllllllllllIIIIlllllIlIllI = Blocks.water.getDefaultState();
                            }
                        }
                        lllllllllllllllllIIIIlllllIlIlII = lllllllllllllllllIIIIlllllIlIIll;
                        if (lllllllllllllllllIIIIlllllIlIIII >= 62) {
                            lllllllllllllllllIIIIlllllIIllII.setBlockState(lllllllllllllllllIIIIlllllIlIIIl, lllllllllllllllllIIIIlllllIlIIII, lllllllllllllllllIIIIlllllIlIIlI, lllllllllllllllllIIIIlllllIlIllI);
                        }
                        else if (lllllllllllllllllIIIIlllllIlIIII < 56 - lllllllllllllllllIIIIlllllIlIIll) {
                            lllllllllllllllllIIIIlllllIlIllI = null;
                            lllllllllllllllllIIIIlllllIlIlIl = Blocks.stone.getDefaultState();
                            lllllllllllllllllIIIIlllllIIllII.setBlockState(lllllllllllllllllIIIIlllllIlIIIl, lllllllllllllllllIIIIlllllIlIIII, lllllllllllllllllIIIIlllllIlIIlI, Blocks.gravel.getDefaultState());
                        }
                        else {
                            lllllllllllllllllIIIIlllllIIllII.setBlockState(lllllllllllllllllIIIIlllllIlIIIl, lllllllllllllllllIIIIlllllIlIIII, lllllllllllllllllIIIIlllllIlIIlI, lllllllllllllllllIIIIlllllIlIlIl);
                        }
                    }
                    else if (lllllllllllllllllIIIIlllllIlIlII > 0) {
                        --lllllllllllllllllIIIIlllllIlIlII;
                        lllllllllllllllllIIIIlllllIIllII.setBlockState(lllllllllllllllllIIIIlllllIlIIIl, lllllllllllllllllIIIIlllllIlIIII, lllllllllllllllllIIIIlllllIlIIlI, lllllllllllllllllIIIIlllllIlIlIl);
                        if (lllllllllllllllllIIIIlllllIlIlII == 0 && lllllllllllllllllIIIIlllllIlIlIl.getBlock() == Blocks.sand) {
                            lllllllllllllllllIIIIlllllIlIlII = lllllllllllllllllIIIIlllllIlllII.nextInt(4) + Math.max(0, lllllllllllllllllIIIIlllllIlIIII - 63);
                            lllllllllllllllllIIIIlllllIlIlIl = ((lllllllllllllllllIIIIlllllIlIlIl.getValue(BlockSand.VARIANT_PROP) == BlockSand.EnumType.RED_SAND) ? Blocks.red_sandstone.getDefaultState() : Blocks.sandstone.getDefaultState());
                        }
                    }
                }
            }
        }
    }
    
    public float getSpawningChance() {
        return 0.1f;
    }
    
    public final float func_180626_a(final BlockPos lllllllllllllllllIIIlIIIIIlIlllI) {
        if (lllllllllllllllllIIIlIIIIIlIlllI.getY() > 64) {
            final float lllllllllllllllllIIIlIIIIIlIllIl = (float)(BiomeGenBase.temperatureNoise.func_151601_a(lllllllllllllllllIIIlIIIIIlIlllI.getX() * 1.0 / 8.0, lllllllllllllllllIIIlIIIIIlIlllI.getZ() * 1.0 / 8.0) * 4.0);
            return this.temperature - (lllllllllllllllllIIIlIIIIIlIllIl + lllllllllllllllllIIIlIIIIIlIlllI.getY() - 64.0f) * 0.05f / 30.0f;
        }
        return this.temperature;
    }
    
    public boolean canSpawnLightningBolt() {
        return !this.isSnowyBiome() && this.enableRain;
    }
    
    public boolean getEnableSnow() {
        return this.isSnowyBiome();
    }
    
    protected BiomeDecorator createBiomeDecorator() {
        return new BiomeDecorator();
    }
    
    protected BiomeGenBase createMutation() {
        return this.createMutatedBiome(this.biomeID + 128);
    }
    
    public int getSkyColorByTemp(float lllllllllllllllllIIIlIIIIlIIlIlI) {
        lllllllllllllllllIIIlIIIIlIIlIlI /= 3.0f;
        lllllllllllllllllIIIlIIIIlIIlIlI = MathHelper.clamp_float(lllllllllllllllllIIIlIIIIlIIlIlI, -1.0f, 1.0f);
        return Color.getHSBColor(0.62222224f - lllllllllllllllllIIIlIIIIlIIlIlI * 0.05f, 0.5f + lllllllllllllllllIIIlIIIIlIIlIlI * 0.1f, 1.0f).getRGB();
    }
    
    public int func_180625_c(final BlockPos lllllllllllllllllIIIlIIIIIIIllII) {
        final double lllllllllllllllllIIIlIIIIIIIlIll = MathHelper.clamp_float(this.func_180626_a(lllllllllllllllllIIIlIIIIIIIllII), 0.0f, 1.0f);
        final double lllllllllllllllllIIIlIIIIIIIlIlI = MathHelper.clamp_float(this.getFloatRainfall(), 0.0f, 1.0f);
        return ColorizerFoliage.getFoliageColor(lllllllllllllllllIIIlIIIIIIIlIll, lllllllllllllllllIIIlIIIIIIIlIlI);
    }
    
    protected BiomeGenBase setTemperatureRainfall(final float lllllllllllllllllIIIlIIIlIIIlIll, final float lllllllllllllllllIIIlIIIlIIIlIlI) {
        if (lllllllllllllllllIIIlIIIlIIIlIll > 0.1f && lllllllllllllllllIIIlIIIlIIIlIll < 0.2f) {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        }
        this.temperature = lllllllllllllllllIIIlIIIlIIIlIll;
        this.rainfall = lllllllllllllllllIIIlIIIlIIIlIlI;
        return this;
    }
    
    public int func_180627_b(final BlockPos lllllllllllllllllIIIlIIIIIIlIlII) {
        final double lllllllllllllllllIIIlIIIIIIlIlll = MathHelper.clamp_float(this.func_180626_a(lllllllllllllllllIIIlIIIIIIlIlII), 0.0f, 1.0f);
        final double lllllllllllllllllIIIlIIIIIIlIllI = MathHelper.clamp_float(this.getFloatRainfall(), 0.0f, 1.0f);
        return ColorizerGrass.getGrassColor(lllllllllllllllllIIIlIIIIIIlIlll, lllllllllllllllllIIIlIIIIIIlIllI);
    }
    
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random lllllllllllllllllIIIlIIIIlllIIIl, final BlockPos lllllllllllllllllIIIlIIIIlllIIlI) {
        return (lllllllllllllllllIIIlIIIIlllIIIl.nextInt(3) > 0) ? BlockFlower.EnumFlowerType.DANDELION : BlockFlower.EnumFlowerType.POPPY;
    }
    
    public static BiomeGenBase[] getBiomeGenArray() {
        return BiomeGenBase.biomeList;
    }
    
    protected BiomeGenBase setBiomeName(final String lllllllllllllllllIIIlIIIIllIlIlI) {
        this.biomeName = lllllllllllllllllIIIlIIIIllIlIlI;
        return this;
    }
    
    public static BiomeGenBase getBiome(final int lllllllllllllllllIIIIllllIlIlIIl) {
        return getBiomeFromBiomeList(lllllllllllllllllIIIIllllIlIlIIl, null);
    }
    
    public Class getBiomeClass() {
        return this.getClass();
    }
    
    protected BiomeGenBase setFillerBlockMetadata(final int lllllllllllllllllIIIlIIIIllIIlII) {
        this.fillerBlockMetadata = lllllllllllllllllIIIlIIIIllIIlII;
        return this;
    }
    
    public static BiomeGenBase getBiomeFromBiomeList(final int lllllllllllllllllIIIIllllIlIIIIl, final BiomeGenBase lllllllllllllllllIIIIllllIlIIIII) {
        if (lllllllllllllllllIIIIllllIlIIIIl >= 0 && lllllllllllllllllIIIIllllIlIIIIl <= BiomeGenBase.biomeList.length) {
            final BiomeGenBase lllllllllllllllllIIIIllllIlIIIlI = BiomeGenBase.biomeList[lllllllllllllllllIIIIllllIlIIIIl];
            return (lllllllllllllllllIIIIllllIlIIIlI == null) ? lllllllllllllllllIIIIllllIlIIIII : lllllllllllllllllIIIIllllIlIIIlI;
        }
        BiomeGenBase.logger.warn(String.valueOf(new StringBuilder("Biome ID is out of bounds: ").append(lllllllllllllllllIIIIllllIlIIIIl).append(", defaulting to 0 (Ocean)")));
        return BiomeGenBase.ocean;
    }
    
    protected BiomeGenBase func_150557_a(final int lllllllllllllllllIIIlIIIIlIlIIIl, final boolean lllllllllllllllllIIIlIIIIlIIllIl) {
        this.color = lllllllllllllllllIIIlIIIIlIlIIIl;
        if (lllllllllllllllllIIIlIIIIlIIllIl) {
            this.field_150609_ah = (lllllllllllllllllIIIlIIIIlIlIIIl & 0xFEFEFE) >> 1;
        }
        else {
            this.field_150609_ah = lllllllllllllllllIIIlIIIIlIlIIIl;
        }
        return this;
    }
    
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllllllIIIlIIIIllllIlI) {
        return (lllllllllllllllllIIIlIIIIllllIlI.nextInt(10) == 0) ? this.worldGeneratorBigTree : this.worldGeneratorTrees;
    }
    
    public void genTerrainBlocks(final World lllllllllllllllllIIIIlllllllIIll, final Random lllllllllllllllllIIIIlllllllIIlI, final ChunkPrimer lllllllllllllllllIIIIllllllllIII, final int lllllllllllllllllIIIIlllllllIIII, final int lllllllllllllllllIIIIlllllllIllI, final double lllllllllllllllllIIIIllllllIlllI) {
        this.func_180628_b(lllllllllllllllllIIIIlllllllIIll, lllllllllllllllllIIIIlllllllIIlI, lllllllllllllllllIIIIllllllllIII, lllllllllllllllllIIIIlllllllIIII, lllllllllllllllllIIIIlllllllIllI, lllllllllllllllllIIIIllllllIlllI);
    }
    
    public boolean isSnowyBiome() {
        return this.enableSnow;
    }
    
    public TempCategory getTempCategory() {
        return (this.temperature < 0.2) ? TempCategory.COLD : ((this.temperature < 1.0) ? TempCategory.MEDIUM : TempCategory.WARM);
    }
    
    public List getSpawnableList(final EnumCreatureType lllllllllllllllllIIIlIIIIlIIIIll) {
        switch (SwitchEnumCreatureType.field_180275_a[lllllllllllllllllIIIlIIIIlIIIIll.ordinal()]) {
            case 1: {
                return this.spawnableMonsterList;
            }
            case 2: {
                return this.spawnableCreatureList;
            }
            case 3: {
                return this.spawnableWaterCreatureList;
            }
            case 4: {
                return this.spawnableCaveCreatureList;
            }
            default: {
                return Collections.emptyList();
            }
        }
    }
    
    public boolean isEqualTo(final BiomeGenBase lllllllllllllllllIIIIllllIllIIII) {
        return lllllllllllllllllIIIIllllIllIIII == this || (lllllllllllllllllIIIIllllIllIIII != null && this.getBiomeClass() == lllllllllllllllllIIIIllllIllIIII.getBiomeClass());
    }
    
    protected BiomeGenBase createMutatedBiome(final int lllllllllllllllllIIIIllllIllIlll) {
        return new BiomeGenMutated(lllllllllllllllllIIIIllllIllIlll, this);
    }
    
    static {
        __OBFID = "CL_00000158";
        logger = LogManager.getLogger();
        height_Default = new Height(0.1f, 0.2f);
        height_ShallowWaters = new Height(-0.5f, 0.0f);
        height_Oceans = new Height(-1.0f, 0.1f);
        height_DeepOceans = new Height(-1.8f, 0.1f);
        height_LowPlains = new Height(0.125f, 0.05f);
        height_MidPlains = new Height(0.2f, 0.2f);
        height_LowHills = new Height(0.45f, 0.3f);
        height_HighPlateaus = new Height(1.5f, 0.025f);
        height_MidHills = new Height(1.0f, 0.5f);
        height_Shores = new Height(0.0f, 0.025f);
        height_RockyWaters = new Height(0.1f, 0.8f);
        height_LowIslands = new Height(0.2f, 0.3f);
        height_PartiallySubmerged = new Height(-0.2f, 0.1f);
        biomeList = new BiomeGenBase[256];
        explorationBiomesList = Sets.newHashSet();
        field_180278_o = Maps.newHashMap();
        ocean = new BiomeGenOcean(0).setColor(112).setBiomeName("Ocean").setHeight(BiomeGenBase.height_Oceans);
        plains = new BiomeGenPlains(1).setColor(9286496).setBiomeName("Plains");
        desert = new BiomeGenDesert(2).setColor(16421912).setBiomeName("Desert").setDisableRain().setTemperatureRainfall(2.0f, 0.0f).setHeight(BiomeGenBase.height_LowPlains);
        extremeHills = new BiomeGenHills(3, false).setColor(6316128).setBiomeName("Extreme Hills").setHeight(BiomeGenBase.height_MidHills).setTemperatureRainfall(0.2f, 0.3f);
        forest = new BiomeGenForest(4, 0).setColor(353825).setBiomeName("Forest");
        taiga = new BiomeGenTaiga(5, 0).setColor(747097).setBiomeName("Taiga").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.25f, 0.8f).setHeight(BiomeGenBase.height_MidPlains);
        swampland = new BiomeGenSwamp(6).setColor(522674).setBiomeName("Swampland").setFillerBlockMetadata(9154376).setHeight(BiomeGenBase.height_PartiallySubmerged).setTemperatureRainfall(0.8f, 0.9f);
        river = new BiomeGenRiver(7).setColor(255).setBiomeName("River").setHeight(BiomeGenBase.height_ShallowWaters);
        hell = new BiomeGenHell(8).setColor(16711680).setBiomeName("Hell").setDisableRain().setTemperatureRainfall(2.0f, 0.0f);
        sky = new BiomeGenEnd(9).setColor(8421631).setBiomeName("The End").setDisableRain();
        frozenOcean = new BiomeGenOcean(10).setColor(9474208).setBiomeName("FrozenOcean").setEnableSnow().setHeight(BiomeGenBase.height_Oceans).setTemperatureRainfall(0.0f, 0.5f);
        frozenRiver = new BiomeGenRiver(11).setColor(10526975).setBiomeName("FrozenRiver").setEnableSnow().setHeight(BiomeGenBase.height_ShallowWaters).setTemperatureRainfall(0.0f, 0.5f);
        icePlains = new BiomeGenSnow(12, false).setColor(16777215).setBiomeName("Ice Plains").setEnableSnow().setTemperatureRainfall(0.0f, 0.5f).setHeight(BiomeGenBase.height_LowPlains);
        iceMountains = new BiomeGenSnow(13, false).setColor(10526880).setBiomeName("Ice Mountains").setEnableSnow().setHeight(BiomeGenBase.height_LowHills).setTemperatureRainfall(0.0f, 0.5f);
        mushroomIsland = new BiomeGenMushroomIsland(14).setColor(16711935).setBiomeName("MushroomIsland").setTemperatureRainfall(0.9f, 1.0f).setHeight(BiomeGenBase.height_LowIslands);
        mushroomIslandShore = new BiomeGenMushroomIsland(15).setColor(10486015).setBiomeName("MushroomIslandShore").setTemperatureRainfall(0.9f, 1.0f).setHeight(BiomeGenBase.height_Shores);
        beach = new BiomeGenBeach(16).setColor(16440917).setBiomeName("Beach").setTemperatureRainfall(0.8f, 0.4f).setHeight(BiomeGenBase.height_Shores);
        desertHills = new BiomeGenDesert(17).setColor(13786898).setBiomeName("DesertHills").setDisableRain().setTemperatureRainfall(2.0f, 0.0f).setHeight(BiomeGenBase.height_LowHills);
        forestHills = new BiomeGenForest(18, 0).setColor(2250012).setBiomeName("ForestHills").setHeight(BiomeGenBase.height_LowHills);
        taigaHills = new BiomeGenTaiga(19, 0).setColor(1456435).setBiomeName("TaigaHills").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.25f, 0.8f).setHeight(BiomeGenBase.height_LowHills);
        extremeHillsEdge = new BiomeGenHills(20, true).setColor(7501978).setBiomeName("Extreme Hills Edge").setHeight(BiomeGenBase.height_MidHills.attenuate()).setTemperatureRainfall(0.2f, 0.3f);
        jungle = new BiomeGenJungle(21, false).setColor(5470985).setBiomeName("Jungle").setFillerBlockMetadata(5470985).setTemperatureRainfall(0.95f, 0.9f);
        jungleHills = new BiomeGenJungle(22, false).setColor(2900485).setBiomeName("JungleHills").setFillerBlockMetadata(5470985).setTemperatureRainfall(0.95f, 0.9f).setHeight(BiomeGenBase.height_LowHills);
        jungleEdge = new BiomeGenJungle(23, true).setColor(6458135).setBiomeName("JungleEdge").setFillerBlockMetadata(5470985).setTemperatureRainfall(0.95f, 0.8f);
        deepOcean = new BiomeGenOcean(24).setColor(48).setBiomeName("Deep Ocean").setHeight(BiomeGenBase.height_DeepOceans);
        stoneBeach = new BiomeGenStoneBeach(25).setColor(10658436).setBiomeName("Stone Beach").setTemperatureRainfall(0.2f, 0.3f).setHeight(BiomeGenBase.height_RockyWaters);
        coldBeach = new BiomeGenBeach(26).setColor(16445632).setBiomeName("Cold Beach").setTemperatureRainfall(0.05f, 0.3f).setHeight(BiomeGenBase.height_Shores).setEnableSnow();
        birchForest = new BiomeGenForest(27, 2).setBiomeName("Birch Forest").setColor(3175492);
        birchForestHills = new BiomeGenForest(28, 2).setBiomeName("Birch Forest Hills").setColor(2055986).setHeight(BiomeGenBase.height_LowHills);
        roofedForest = new BiomeGenForest(29, 3).setColor(4215066).setBiomeName("Roofed Forest");
        coldTaiga = new BiomeGenTaiga(30, 0).setColor(3233098).setBiomeName("Cold Taiga").setFillerBlockMetadata(5159473).setEnableSnow().setTemperatureRainfall(-0.5f, 0.4f).setHeight(BiomeGenBase.height_MidPlains).func_150563_c(16777215);
        coldTaigaHills = new BiomeGenTaiga(31, 0).setColor(2375478).setBiomeName("Cold Taiga Hills").setFillerBlockMetadata(5159473).setEnableSnow().setTemperatureRainfall(-0.5f, 0.4f).setHeight(BiomeGenBase.height_LowHills).func_150563_c(16777215);
        megaTaiga = new BiomeGenTaiga(32, 1).setColor(5858897).setBiomeName("Mega Taiga").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.3f, 0.8f).setHeight(BiomeGenBase.height_MidPlains);
        megaTaigaHills = new BiomeGenTaiga(33, 1).setColor(4542270).setBiomeName("Mega Taiga Hills").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.3f, 0.8f).setHeight(BiomeGenBase.height_LowHills);
        extremeHillsPlus = new BiomeGenHills(34, true).setColor(5271632).setBiomeName("Extreme Hills+").setHeight(BiomeGenBase.height_MidHills).setTemperatureRainfall(0.2f, 0.3f);
        savanna = new BiomeGenSavanna(35).setColor(12431967).setBiomeName("Savanna").setTemperatureRainfall(1.2f, 0.0f).setDisableRain().setHeight(BiomeGenBase.height_LowPlains);
        savannaPlateau = new BiomeGenSavanna(36).setColor(10984804).setBiomeName("Savanna Plateau").setTemperatureRainfall(1.0f, 0.0f).setDisableRain().setHeight(BiomeGenBase.height_HighPlateaus);
        mesa = new BiomeGenMesa(37, false, false).setColor(14238997).setBiomeName("Mesa");
        mesaPlateau_F = new BiomeGenMesa(38, false, true).setColor(11573093).setBiomeName("Mesa Plateau F").setHeight(BiomeGenBase.height_HighPlateaus);
        mesaPlateau = new BiomeGenMesa(39, false, false).setColor(13274213).setBiomeName("Mesa Plateau").setHeight(BiomeGenBase.height_HighPlateaus);
        field_180279_ad = BiomeGenBase.ocean;
        BiomeGenBase.plains.createMutation();
        BiomeGenBase.desert.createMutation();
        BiomeGenBase.forest.createMutation();
        BiomeGenBase.taiga.createMutation();
        BiomeGenBase.swampland.createMutation();
        BiomeGenBase.icePlains.createMutation();
        BiomeGenBase.jungle.createMutation();
        BiomeGenBase.jungleEdge.createMutation();
        BiomeGenBase.coldTaiga.createMutation();
        BiomeGenBase.savanna.createMutation();
        BiomeGenBase.savannaPlateau.createMutation();
        BiomeGenBase.mesa.createMutation();
        BiomeGenBase.mesaPlateau_F.createMutation();
        BiomeGenBase.mesaPlateau.createMutation();
        BiomeGenBase.birchForest.createMutation();
        BiomeGenBase.birchForestHills.createMutation();
        BiomeGenBase.roofedForest.createMutation();
        BiomeGenBase.megaTaiga.createMutation();
        BiomeGenBase.extremeHills.createMutation();
        BiomeGenBase.extremeHillsPlus.createMutation();
        BiomeGenBase.megaTaiga.createMutatedBiome(BiomeGenBase.megaTaigaHills.biomeID + 128).setBiomeName("Redwood Taiga Hills M");
        for (final BiomeGenBase lllllllllllllllllIIIlIIIlIIllIll : BiomeGenBase.biomeList) {
            if (lllllllllllllllllIIIlIIIlIIllIll != null) {
                if (BiomeGenBase.field_180278_o.containsKey(lllllllllllllllllIIIlIIIlIIllIll.biomeName)) {
                    throw new Error(String.valueOf(new StringBuilder("Biome \"").append(lllllllllllllllllIIIlIIIlIIllIll.biomeName).append("\" is defined as both ID ").append(BiomeGenBase.field_180278_o.get(lllllllllllllllllIIIlIIIlIIllIll.biomeName).biomeID).append(" and ").append(lllllllllllllllllIIIlIIIlIIllIll.biomeID)));
                }
                BiomeGenBase.field_180278_o.put(lllllllllllllllllIIIlIIIlIIllIll.biomeName, lllllllllllllllllIIIlIIIlIIllIll);
                if (lllllllllllllllllIIIlIIIlIIllIll.biomeID < 128) {
                    BiomeGenBase.explorationBiomesList.add(lllllllllllllllllIIIlIIIlIIllIll);
                }
            }
        }
        BiomeGenBase.explorationBiomesList.remove(BiomeGenBase.hell);
        BiomeGenBase.explorationBiomesList.remove(BiomeGenBase.sky);
        BiomeGenBase.explorationBiomesList.remove(BiomeGenBase.frozenOcean);
        BiomeGenBase.explorationBiomesList.remove(BiomeGenBase.extremeHillsEdge);
        temperatureNoise = new NoiseGeneratorPerlin(new Random(1234L), 1);
        field_180281_af = new NoiseGeneratorPerlin(new Random(2345L), 1);
        field_180280_ag = new WorldGenDoublePlant();
    }
    
    public boolean isHighHumidity() {
        return this.rainfall > 0.85f;
    }
    
    protected BiomeGenBase setEnableSnow() {
        this.enableSnow = true;
        return this;
    }
    
    protected BiomeGenBase setDisableRain() {
        this.enableRain = false;
        return this;
    }
    
    protected final BiomeGenBase setHeight(final Height lllllllllllllllllIIIlIIIlIIIIIll) {
        this.minHeight = lllllllllllllllllIIIlIIIlIIIIIll.rootHeight;
        this.maxHeight = lllllllllllllllllIIIlIIIlIIIIIll.variation;
        return this;
    }
    
    public WorldGenerator getRandomWorldGenForGrass(final Random lllllllllllllllllIIIlIIIIlllIllI) {
        return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    static final class SwitchEnumCreatureType
    {
        static final /* synthetic */ int[] field_180275_a;
        
        static {
            __OBFID = "CL_00002150";
            field_180275_a = new int[EnumCreatureType.values().length];
            try {
                SwitchEnumCreatureType.field_180275_a[EnumCreatureType.MONSTER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumCreatureType.field_180275_a[EnumCreatureType.CREATURE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumCreatureType.field_180275_a[EnumCreatureType.WATER_CREATURE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumCreatureType.field_180275_a[EnumCreatureType.AMBIENT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
    
    public static class Height
    {
        public /* synthetic */ float variation;
        public /* synthetic */ float rootHeight;
        
        public Height(final float lllllllllllllllllIlllllIIIIIIlII, final float lllllllllllllllllIlllllIIIIIIIII) {
            this.rootHeight = lllllllllllllllllIlllllIIIIIIlII;
            this.variation = lllllllllllllllllIlllllIIIIIIIII;
        }
        
        public Height attenuate() {
            return new Height(this.rootHeight * 0.8f, this.variation * 0.6f);
        }
        
        static {
            __OBFID = "CL_00000159";
        }
    }
    
    public static class SpawnListEntry extends WeightedRandom.Item
    {
        public /* synthetic */ int maxGroupCount;
        public /* synthetic */ Class entityClass;
        public /* synthetic */ int minGroupCount;
        
        static {
            __OBFID = "CL_00000161";
        }
        
        public SpawnListEntry(final Class llllllllllllllllIIlIIlIlllIlIIll, final int llllllllllllllllIIlIIlIlllIlIIlI, final int llllllllllllllllIIlIIlIlllIlIIIl, final int llllllllllllllllIIlIIlIlllIlIlIl) {
            super(llllllllllllllllIIlIIlIlllIlIIlI);
            this.entityClass = llllllllllllllllIIlIIlIlllIlIIll;
            this.minGroupCount = llllllllllllllllIIlIIlIlllIlIIIl;
            this.maxGroupCount = llllllllllllllllIIlIIlIlllIlIlIl;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder(String.valueOf(this.entityClass.getSimpleName())).append("*(").append(this.minGroupCount).append("-").append(this.maxGroupCount).append("):").append(this.itemWeight));
        }
    }
    
    public enum TempCategory
    {
        COLD("COLD", 1, "COLD", 1), 
        WARM("WARM", 3, "WARM", 3), 
        OCEAN("OCEAN", 0, "OCEAN", 0), 
        MEDIUM("MEDIUM", 2, "MEDIUM", 2);
        
        private TempCategory(final String llllllllllllllIIIIIIIIllIIlllIII, final int llllllllllllllIIIIIIIIllIIllIlll, final String llllllllllllllIIIIIIIIllIIlllIll, final int llllllllllllllIIIIIIIIllIIlllIlI) {
        }
        
        static {
            __OBFID = "CL_00000160";
        }
    }
}
