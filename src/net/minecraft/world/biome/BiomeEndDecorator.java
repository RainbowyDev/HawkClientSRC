package net.minecraft.world.biome;

import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;

public class BiomeEndDecorator extends BiomeDecorator
{
    protected /* synthetic */ WorldGenerator spikeGen;
    
    @Override
    protected void genDecorations(final BiomeGenBase llllllllllllllIllllIlllIllIIIIlI) {
        this.generateOres();
        if (this.randomGenerator.nextInt(5) == 0) {
            final int llllllllllllllIllllIlllIllIIIIIl = this.randomGenerator.nextInt(16) + 8;
            final int llllllllllllllIllllIlllIllIIIIII = this.randomGenerator.nextInt(16) + 8;
            this.spikeGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.func_175672_r(this.field_180294_c.add(llllllllllllllIllllIlllIllIIIIIl, 0, llllllllllllllIllllIlllIllIIIIII)));
        }
        if (this.field_180294_c.getX() == 0 && this.field_180294_c.getZ() == 0) {
            final EntityDragon llllllllllllllIllllIlllIlIllllll = new EntityDragon(this.currentWorld);
            llllllllllllllIllllIlllIlIllllll.setLocationAndAngles(0.0, 128.0, 0.0, this.randomGenerator.nextFloat() * 360.0f, 0.0f);
            this.currentWorld.spawnEntityInWorld(llllllllllllllIllllIlllIlIllllll);
        }
    }
    
    public BiomeEndDecorator() {
        this.spikeGen = new WorldGenSpikes(Blocks.end_stone);
    }
    
    static {
        __OBFID = "CL_00000188";
    }
}
