package net.minecraft.world.biome;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.world.gen.feature.*;

public class BiomeDecorator
{
    protected /* synthetic */ WorldGenerator waterlilyGen;
    protected /* synthetic */ int flowersPerChunk;
    protected /* synthetic */ WorldGenerator mushroomRedGen;
    protected /* synthetic */ int sandPerChunk2;
    protected /* synthetic */ int sandPerChunk;
    protected /* synthetic */ int waterlilyPerChunk;
    protected /* synthetic */ WorldGenerator ironGen;
    protected /* synthetic */ int grassPerChunk;
    protected /* synthetic */ WorldGenerator field_180299_p;
    protected /* synthetic */ WorldGenFlowers yellowFlowerGen;
    protected /* synthetic */ int bigMushroomsPerChunk;
    protected /* synthetic */ WorldGenerator bigMushroomGen;
    protected /* synthetic */ WorldGenerator clayGen;
    protected /* synthetic */ Random randomGenerator;
    protected /* synthetic */ World currentWorld;
    protected /* synthetic */ int mushroomsPerChunk;
    protected /* synthetic */ int clayPerChunk;
    protected /* synthetic */ WorldGenerator field_180298_q;
    protected /* synthetic */ int deadBushPerChunk;
    protected /* synthetic */ WorldGenerator cactusGen;
    protected /* synthetic */ WorldGenerator field_180297_k;
    protected /* synthetic */ WorldGenerator goldGen;
    protected /* synthetic */ WorldGenerator lapisGen;
    protected /* synthetic */ WorldGenerator field_180296_j;
    public /* synthetic */ boolean generateLakes;
    protected /* synthetic */ WorldGenerator sandGen;
    protected /* synthetic */ BlockPos field_180294_c;
    protected /* synthetic */ WorldGenerator gravelGen;
    protected /* synthetic */ int treesPerChunk;
    protected /* synthetic */ int cactiPerChunk;
    protected /* synthetic */ WorldGenerator mushroomBrownGen;
    protected /* synthetic */ ChunkProviderSettings field_180293_d;
    protected /* synthetic */ int reedsPerChunk;
    protected /* synthetic */ WorldGenerator coalGen;
    protected /* synthetic */ WorldGenerator field_180295_l;
    protected /* synthetic */ WorldGenerator dirtGen;
    protected /* synthetic */ WorldGenerator gravelAsSandGen;
    protected /* synthetic */ WorldGenerator reedGen;
    
    protected void genStandardOre2(final int lllllllllllllllllIlIlIlIlllIlllI, final WorldGenerator lllllllllllllllllIlIlIlIllllIlII, final int lllllllllllllllllIlIlIlIlllIllII, final int lllllllllllllllllIlIlIlIlllIlIll) {
        for (int lllllllllllllllllIlIlIlIllllIIIl = 0; lllllllllllllllllIlIlIlIllllIIIl < lllllllllllllllllIlIlIlIlllIlllI; ++lllllllllllllllllIlIlIlIllllIIIl) {
            final BlockPos lllllllllllllllllIlIlIlIllllIIII = this.field_180294_c.add(this.randomGenerator.nextInt(16), this.randomGenerator.nextInt(lllllllllllllllllIlIlIlIlllIlIll) + this.randomGenerator.nextInt(lllllllllllllllllIlIlIlIlllIlIll) + lllllllllllllllllIlIlIlIlllIllII - lllllllllllllllllIlIlIlIlllIlIll, this.randomGenerator.nextInt(16));
            lllllllllllllllllIlIlIlIllllIlII.generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIlIllllIIII);
        }
    }
    
    public BiomeDecorator() {
        this.clayGen = new WorldGenClay(4);
        this.sandGen = new WorldGenSand(Blocks.sand, 7);
        this.gravelAsSandGen = new WorldGenSand(Blocks.gravel, 6);
        this.yellowFlowerGen = new WorldGenFlowers(Blocks.yellow_flower, BlockFlower.EnumFlowerType.DANDELION);
        this.mushroomBrownGen = new GeneratorBushFeature(Blocks.brown_mushroom);
        this.mushroomRedGen = new GeneratorBushFeature(Blocks.red_mushroom);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.reedGen = new WorldGenReed();
        this.cactusGen = new WorldGenCactus();
        this.waterlilyGen = new WorldGenWaterlily();
        this.flowersPerChunk = 2;
        this.grassPerChunk = 1;
        this.sandPerChunk = 1;
        this.sandPerChunk2 = 3;
        this.clayPerChunk = 1;
        this.generateLakes = true;
    }
    
    public void func_180292_a(final World lllllllllllllllllIlIlIllIllIlIll, final Random lllllllllllllllllIlIlIllIllIIlII, final BiomeGenBase lllllllllllllllllIlIlIllIllIIIll, final BlockPos lllllllllllllllllIlIlIllIllIIIlI) {
        if (this.currentWorld != null) {
            throw new RuntimeException("Already decorating");
        }
        this.currentWorld = lllllllllllllllllIlIlIllIllIlIll;
        final String lllllllllllllllllIlIlIllIllIIlll = lllllllllllllllllIlIlIllIllIlIll.getWorldInfo().getGeneratorOptions();
        if (lllllllllllllllllIlIlIllIllIIlll != null) {
            this.field_180293_d = ChunkProviderSettings.Factory.func_177865_a(lllllllllllllllllIlIlIllIllIIlll).func_177864_b();
        }
        else {
            this.field_180293_d = ChunkProviderSettings.Factory.func_177865_a("").func_177864_b();
        }
        this.randomGenerator = lllllllllllllllllIlIlIllIllIIlII;
        this.field_180294_c = lllllllllllllllllIlIlIllIllIIIlI;
        this.dirtGen = new WorldGenMinable(Blocks.dirt.getDefaultState(), this.field_180293_d.field_177789_I);
        this.gravelGen = new WorldGenMinable(Blocks.gravel.getDefaultState(), this.field_180293_d.field_177785_M);
        this.field_180296_j = new WorldGenMinable(Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT_PROP, BlockStone.EnumType.GRANITE), this.field_180293_d.field_177796_Q);
        this.field_180297_k = new WorldGenMinable(Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT_PROP, BlockStone.EnumType.DIORITE), this.field_180293_d.field_177792_U);
        this.field_180295_l = new WorldGenMinable(Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT_PROP, BlockStone.EnumType.ANDESITE), this.field_180293_d.field_177800_Y);
        this.coalGen = new WorldGenMinable(Blocks.coal_ore.getDefaultState(), this.field_180293_d.field_177844_ac);
        this.ironGen = new WorldGenMinable(Blocks.iron_ore.getDefaultState(), this.field_180293_d.field_177848_ag);
        this.goldGen = new WorldGenMinable(Blocks.gold_ore.getDefaultState(), this.field_180293_d.field_177828_ak);
        this.field_180299_p = new WorldGenMinable(Blocks.redstone_ore.getDefaultState(), this.field_180293_d.field_177836_ao);
        this.field_180298_q = new WorldGenMinable(Blocks.diamond_ore.getDefaultState(), this.field_180293_d.field_177814_as);
        this.lapisGen = new WorldGenMinable(Blocks.lapis_ore.getDefaultState(), this.field_180293_d.field_177822_aw);
        this.genDecorations(lllllllllllllllllIlIlIllIllIIIll);
        this.currentWorld = null;
        this.randomGenerator = null;
    }
    
    protected void genDecorations(final BiomeGenBase lllllllllllllllllIlIlIllIIIlllII) {
        this.generateOres();
        for (int lllllllllllllllllIlIlIllIlIlIlII = 0; lllllllllllllllllIlIlIllIlIlIlII < this.sandPerChunk2; ++lllllllllllllllllIlIlIllIlIlIlII) {
            final int lllllllllllllllllIlIlIllIlIlIIll = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIlIIllll = this.randomGenerator.nextInt(16) + 8;
            this.sandGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.func_175672_r(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIll, 0, lllllllllllllllllIlIlIllIlIIllll)));
        }
        for (int lllllllllllllllllIlIlIllIlIlIlII = 0; lllllllllllllllllIlIlIllIlIlIlII < this.clayPerChunk; ++lllllllllllllllllIlIlIllIlIlIlII) {
            final int lllllllllllllllllIlIlIllIlIlIIlI = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIlIIlllI = this.randomGenerator.nextInt(16) + 8;
            this.clayGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.func_175672_r(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIlI, 0, lllllllllllllllllIlIlIllIlIIlllI)));
        }
        for (int lllllllllllllllllIlIlIllIlIlIlII = 0; lllllllllllllllllIlIlIllIlIlIlII < this.sandPerChunk; ++lllllllllllllllllIlIlIllIlIlIlII) {
            final int lllllllllllllllllIlIlIllIlIlIIIl = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIlIIllIl = this.randomGenerator.nextInt(16) + 8;
            this.gravelAsSandGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.func_175672_r(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIIl, 0, lllllllllllllllllIlIlIllIlIIllIl)));
        }
        int lllllllllllllllllIlIlIllIlIlIlII = this.treesPerChunk;
        if (this.randomGenerator.nextInt(10) == 0) {
            ++lllllllllllllllllIlIlIllIlIlIlII;
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < lllllllllllllllllIlIlIllIlIlIlII; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIlIIllII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlllllI = this.randomGenerator.nextInt(16) + 8;
            final WorldGenAbstractTree lllllllllllllllllIlIlIllIIlIllII = lllllllllllllllllIlIlIllIIIlllII.genBigTreeChance(this.randomGenerator);
            lllllllllllllllllIlIlIllIIlIllII.func_175904_e();
            final BlockPos lllllllllllllllllIlIlIllIIllIIII = this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIllII, 0, lllllllllllllllllIlIlIllIIlllllI));
            if (lllllllllllllllllIlIlIllIIlIllII.generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIllIIII)) {
                lllllllllllllllllIlIlIllIIlIllII.func_180711_a(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIllIIII);
            }
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < this.bigMushroomsPerChunk; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIlIIlIll = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIllllIl = this.randomGenerator.nextInt(16) + 8;
            this.bigMushroomGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIlIll, 0, lllllllllllllllllIlIlIllIIllllIl)));
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < this.flowersPerChunk; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIlIIlIlI = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIllllII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlIlIll = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIlIlI, 0, lllllllllllllllllIlIlIllIIllllII)).getY() + 32);
            final BlockPos lllllllllllllllllIlIlIllIIlIllll = this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIlIlI, lllllllllllllllllIlIlIllIIlIlIll, lllllllllllllllllIlIlIllIIllllII);
            final BlockFlower.EnumFlowerType lllllllllllllllllIlIlIllIIlIIIll = lllllllllllllllllIlIlIllIIIlllII.pickRandomFlower(this.randomGenerator, lllllllllllllllllIlIlIllIIlIllll);
            final BlockFlower lllllllllllllllllIlIlIllIIlIIIlI = lllllllllllllllllIlIlIllIIlIIIll.func_176964_a().func_180346_a();
            if (lllllllllllllllllIlIlIllIIlIIIlI.getMaterial() != Material.air) {
                this.yellowFlowerGen.setGeneratedBlock(lllllllllllllllllIlIlIllIIlIIIlI, lllllllllllllllllIlIlIllIIlIIIll);
                this.yellowFlowerGen.generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIlIllll);
            }
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < this.grassPerChunk; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIlIIlIIl = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlllIll = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlIlIlI = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIlIIl, 0, lllllllllllllllllIlIlIllIIlllIll)).getY() * 2);
            lllllllllllllllllIlIlIllIIIlllII.getRandomWorldGenForGrass(this.randomGenerator).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIlIIl, lllllllllllllllllIlIlIllIIlIlIlI, lllllllllllllllllIlIlIllIIlllIll));
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < this.deadBushPerChunk; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIlIIlIII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlllIlI = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlIlIIl = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIlIII, 0, lllllllllllllllllIlIlIllIIlllIlI)).getY() * 2);
            new WorldGenDeadBush().generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIlIII, lllllllllllllllllIlIlIllIIlIlIIl, lllllllllllllllllIlIlIllIIlllIlI));
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < this.waterlilyPerChunk; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIlIIIlll = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlllIIl = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlIlIII = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIlll, 0, lllllllllllllllllIlIlIllIIlllIIl)).getY() * 2);
            BlockPos lllllllllllllllllIlIlIllIIlIlllI;
            BlockPos lllllllllllllllllIlIlIllIIlIIIIl;
            for (lllllllllllllllllIlIlIllIIlIlllI = this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIlll, lllllllllllllllllIlIlIllIIlIlIII, lllllllllllllllllIlIlIllIIlllIIl); lllllllllllllllllIlIlIllIIlIlllI.getY() > 0; lllllllllllllllllIlIlIllIIlIlllI = lllllllllllllllllIlIlIllIIlIIIIl) {
                lllllllllllllllllIlIlIllIIlIIIIl = lllllllllllllllllIlIlIllIIlIlllI.offsetDown();
                if (!this.currentWorld.isAirBlock(lllllllllllllllllIlIlIllIIlIIIIl)) {
                    break;
                }
            }
            this.waterlilyGen.generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIlIlllI);
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < this.mushroomsPerChunk; ++lllllllllllllllllIlIlIllIlIlIIII) {
            if (this.randomGenerator.nextInt(4) == 0) {
                final int lllllllllllllllllIlIlIllIlIIIllI = this.randomGenerator.nextInt(16) + 8;
                final int lllllllllllllllllIlIlIllIIlllIII = this.randomGenerator.nextInt(16) + 8;
                final BlockPos lllllllllllllllllIlIlIllIIlIIIII = this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIllI, 0, lllllllllllllllllIlIlIllIIlllIII));
                this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIlIIIII);
            }
            if (this.randomGenerator.nextInt(8) == 0) {
                final int lllllllllllllllllIlIlIllIlIIIlIl = this.randomGenerator.nextInt(16) + 8;
                final int lllllllllllllllllIlIlIllIIllIlll = this.randomGenerator.nextInt(16) + 8;
                final int lllllllllllllllllIlIlIllIIlIIlll = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIlIl, 0, lllllllllllllllllIlIlIllIIllIlll)).getY() * 2);
                final BlockPos lllllllllllllllllIlIlIllIIlIllIl = this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIlIl, lllllllllllllllllIlIlIllIIlIIlll, lllllllllllllllllIlIlIllIIllIlll);
                this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIlIllIl);
            }
        }
        if (this.randomGenerator.nextInt(4) == 0) {
            final int lllllllllllllllllIlIlIllIlIlIIII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIlIIIlII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIllIllI = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIII, 0, lllllllllllllllllIlIlIllIlIIIlII)).getY() * 2);
            this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIII, lllllllllllllllllIlIlIllIIllIllI, lllllllllllllllllIlIlIllIlIIIlII));
        }
        if (this.randomGenerator.nextInt(8) == 0) {
            final int lllllllllllllllllIlIlIllIlIlIIII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIlIIIIll = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIllIlIl = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIII, 0, lllllllllllllllllIlIlIllIlIIIIll)).getY() * 2);
            this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIII, lllllllllllllllllIlIlIllIIllIlIl, lllllllllllllllllIlIlIllIlIIIIll));
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < this.reedsPerChunk; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIlIIIIlI = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIllIlII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlIIllI = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIIlI, 0, lllllllllllllllllIlIlIllIIllIlII)).getY() * 2);
            this.reedGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIIlI, lllllllllllllllllIlIlIllIIlIIllI, lllllllllllllllllIlIlIllIIllIlII));
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < 10; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIlIIIIIl = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIllIIll = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlIIlIl = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIIIl, 0, lllllllllllllllllIlIlIllIIllIIll)).getY() * 2);
            this.reedGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(lllllllllllllllllIlIlIllIlIIIIIl, lllllllllllllllllIlIlIllIIlIIlIl, lllllllllllllllllIlIlIllIIllIIll));
        }
        if (this.randomGenerator.nextInt(32) == 0) {
            final int lllllllllllllllllIlIlIllIlIlIIII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIlIIIIII = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIllIIlI = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIII, 0, lllllllllllllllllIlIlIllIlIIIIII)).getY() * 2);
            new WorldGenPumpkin().generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(lllllllllllllllllIlIlIllIlIlIIII, lllllllllllllllllIlIlIllIIllIIlI, lllllllllllllllllIlIlIllIlIIIIII));
        }
        for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < this.cactiPerChunk; ++lllllllllllllllllIlIlIllIlIlIIII) {
            final int lllllllllllllllllIlIlIllIIllllll = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIllIIIl = this.randomGenerator.nextInt(16) + 8;
            final int lllllllllllllllllIlIlIllIIlIIlII = this.randomGenerator.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(lllllllllllllllllIlIlIllIIllllll, 0, lllllllllllllllllIlIlIllIIllIIIl)).getY() * 2);
            this.cactusGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(lllllllllllllllllIlIlIllIIllllll, lllllllllllllllllIlIlIllIIlIIlII, lllllllllllllllllIlIlIllIIllIIIl));
        }
        if (this.generateLakes) {
            for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < 50; ++lllllllllllllllllIlIlIllIlIlIIII) {
                final BlockPos lllllllllllllllllIlIlIllIIIlllll = this.field_180294_c.add(this.randomGenerator.nextInt(16) + 8, this.randomGenerator.nextInt(this.randomGenerator.nextInt(248) + 8), this.randomGenerator.nextInt(16) + 8);
                new WorldGenLiquids(Blocks.flowing_water).generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIIlllll);
            }
            for (int lllllllllllllllllIlIlIllIlIlIIII = 0; lllllllllllllllllIlIlIllIlIlIIII < 20; ++lllllllllllllllllIlIlIllIlIlIIII) {
                final BlockPos lllllllllllllllllIlIlIllIIIllllI = this.field_180294_c.add(this.randomGenerator.nextInt(16) + 8, this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8) + 8), this.randomGenerator.nextInt(16) + 8);
                new WorldGenLiquids(Blocks.flowing_lava).generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIIllllI);
            }
        }
    }
    
    protected void generateOres() {
        this.genStandardOre1(this.field_180293_d.field_177790_J, this.dirtGen, this.field_180293_d.field_177791_K, this.field_180293_d.field_177784_L);
        this.genStandardOre1(this.field_180293_d.field_177786_N, this.gravelGen, this.field_180293_d.field_177787_O, this.field_180293_d.field_177797_P);
        this.genStandardOre1(this.field_180293_d.field_177795_V, this.field_180297_k, this.field_180293_d.field_177794_W, this.field_180293_d.field_177801_X);
        this.genStandardOre1(this.field_180293_d.field_177799_R, this.field_180296_j, this.field_180293_d.field_177798_S, this.field_180293_d.field_177793_T);
        this.genStandardOre1(this.field_180293_d.field_177802_Z, this.field_180295_l, this.field_180293_d.field_177846_aa, this.field_180293_d.field_177847_ab);
        this.genStandardOre1(this.field_180293_d.field_177845_ad, this.coalGen, this.field_180293_d.field_177851_ae, this.field_180293_d.field_177853_af);
        this.genStandardOre1(this.field_180293_d.field_177849_ah, this.ironGen, this.field_180293_d.field_177832_ai, this.field_180293_d.field_177834_aj);
        this.genStandardOre1(this.field_180293_d.field_177830_al, this.goldGen, this.field_180293_d.field_177840_am, this.field_180293_d.field_177842_an);
        this.genStandardOre1(this.field_180293_d.field_177838_ap, this.field_180299_p, this.field_180293_d.field_177818_aq, this.field_180293_d.field_177816_ar);
        this.genStandardOre1(this.field_180293_d.field_177812_at, this.field_180298_q, this.field_180293_d.field_177826_au, this.field_180293_d.field_177824_av);
        this.genStandardOre2(this.field_180293_d.field_177820_ax, this.lapisGen, this.field_180293_d.field_177807_ay, this.field_180293_d.field_177805_az);
    }
    
    static {
        __OBFID = "CL_00000164";
    }
    
    protected void genStandardOre1(final int lllllllllllllllllIlIlIllIIIIIIll, final WorldGenerator lllllllllllllllllIlIlIllIIIIlIlI, int lllllllllllllllllIlIlIllIIIIIIIl, int lllllllllllllllllIlIlIllIIIIIIII) {
        if (lllllllllllllllllIlIlIllIIIIIIII < lllllllllllllllllIlIlIllIIIIIIIl) {
            final int lllllllllllllllllIlIlIllIIIIIlll = lllllllllllllllllIlIlIllIIIIIIIl;
            lllllllllllllllllIlIlIllIIIIIIIl = lllllllllllllllllIlIlIllIIIIIIII;
            lllllllllllllllllIlIlIllIIIIIIII = lllllllllllllllllIlIlIllIIIIIlll;
        }
        else if (lllllllllllllllllIlIlIllIIIIIIII == lllllllllllllllllIlIlIllIIIIIIIl) {
            if (lllllllllllllllllIlIlIllIIIIIIIl < 255) {
                ++lllllllllllllllllIlIlIllIIIIIIII;
            }
            else {
                --lllllllllllllllllIlIlIllIIIIIIIl;
            }
        }
        for (int lllllllllllllllllIlIlIllIIIIIllI = 0; lllllllllllllllllIlIlIllIIIIIllI < lllllllllllllllllIlIlIllIIIIIIll; ++lllllllllllllllllIlIlIllIIIIIllI) {
            final BlockPos lllllllllllllllllIlIlIllIIIIIlIl = this.field_180294_c.add(this.randomGenerator.nextInt(16), this.randomGenerator.nextInt(lllllllllllllllllIlIlIllIIIIIIII - lllllllllllllllllIlIlIllIIIIIIIl) + lllllllllllllllllIlIlIllIIIIIIIl, this.randomGenerator.nextInt(16));
            lllllllllllllllllIlIlIllIIIIlIlI.generate(this.currentWorld, this.randomGenerator, lllllllllllllllllIlIlIllIIIIIlIl);
        }
    }
}
