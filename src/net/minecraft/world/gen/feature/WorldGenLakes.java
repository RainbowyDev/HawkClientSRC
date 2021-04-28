package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.world.biome.*;

public class WorldGenLakes extends WorldGenerator
{
    private /* synthetic */ Block field_150556_a;
    
    static {
        __OBFID = "CL_00000418";
    }
    
    @Override
    public boolean generate(final World llllllllllllllIIllIIIIIllIllIlIl, final Random llllllllllllllIIllIIIIIllIllIlII, BlockPos llllllllllllllIIllIIIIIllIIlIIII) {
        for (llllllllllllllIIllIIIIIllIIlIIII = llllllllllllllIIllIIIIIllIIlIIII.add(-8, 0, -8); llllllllllllllIIllIIIIIllIIlIIII.getY() > 5 && llllllllllllllIIllIIIIIllIllIlIl.isAirBlock(llllllllllllllIIllIIIIIllIIlIIII); llllllllllllllIIllIIIIIllIIlIIII = llllllllllllllIIllIIIIIllIIlIIII.offsetDown()) {}
        if (llllllllllllllIIllIIIIIllIIlIIII.getY() <= 4) {
            return false;
        }
        llllllllllllllIIllIIIIIllIIlIIII = llllllllllllllIIllIIIIIllIIlIIII.offsetDown(4);
        final boolean[] llllllllllllllIIllIIIIIllIllIIlI = new boolean[2048];
        for (int llllllllllllllIIllIIIIIllIllIIIl = llllllllllllllIIllIIIIIllIllIlII.nextInt(4) + 4, llllllllllllllIIllIIIIIllIllIIII = 0; llllllllllllllIIllIIIIIllIllIIII < llllllllllllllIIllIIIIIllIllIIIl; ++llllllllllllllIIllIIIIIllIllIIII) {
            final double llllllllllllllIIllIIIIIllIlIllll = llllllllllllllIIllIIIIIllIllIlII.nextDouble() * 6.0 + 3.0;
            final double llllllllllllllIIllIIIIIllIlIlllI = llllllllllllllIIllIIIIIllIllIlII.nextDouble() * 4.0 + 2.0;
            final double llllllllllllllIIllIIIIIllIlIllIl = llllllllllllllIIllIIIIIllIllIlII.nextDouble() * 6.0 + 3.0;
            final double llllllllllllllIIllIIIIIllIlIllII = llllllllllllllIIllIIIIIllIllIlII.nextDouble() * (16.0 - llllllllllllllIIllIIIIIllIlIllll - 2.0) + 1.0 + llllllllllllllIIllIIIIIllIlIllll / 2.0;
            final double llllllllllllllIIllIIIIIllIlIlIll = llllllllllllllIIllIIIIIllIllIlII.nextDouble() * (8.0 - llllllllllllllIIllIIIIIllIlIlllI - 4.0) + 2.0 + llllllllllllllIIllIIIIIllIlIlllI / 2.0;
            final double llllllllllllllIIllIIIIIllIlIlIlI = llllllllllllllIIllIIIIIllIllIlII.nextDouble() * (16.0 - llllllllllllllIIllIIIIIllIlIllIl - 2.0) + 1.0 + llllllllllllllIIllIIIIIllIlIllIl / 2.0;
            for (int llllllllllllllIIllIIIIIllIlIlIIl = 1; llllllllllllllIIllIIIIIllIlIlIIl < 15; ++llllllllllllllIIllIIIIIllIlIlIIl) {
                for (int llllllllllllllIIllIIIIIllIlIlIII = 1; llllllllllllllIIllIIIIIllIlIlIII < 15; ++llllllllllllllIIllIIIIIllIlIlIII) {
                    for (int llllllllllllllIIllIIIIIllIlIIlll = 1; llllllllllllllIIllIIIIIllIlIIlll < 7; ++llllllllllllllIIllIIIIIllIlIIlll) {
                        final double llllllllllllllIIllIIIIIllIlIIllI = (llllllllllllllIIllIIIIIllIlIlIIl - llllllllllllllIIllIIIIIllIlIllII) / (llllllllllllllIIllIIIIIllIlIllll / 2.0);
                        final double llllllllllllllIIllIIIIIllIlIIlIl = (llllllllllllllIIllIIIIIllIlIIlll - llllllllllllllIIllIIIIIllIlIlIll) / (llllllllllllllIIllIIIIIllIlIlllI / 2.0);
                        final double llllllllllllllIIllIIIIIllIlIIlII = (llllllllllllllIIllIIIIIllIlIlIII - llllllllllllllIIllIIIIIllIlIlIlI) / (llllllllllllllIIllIIIIIllIlIllIl / 2.0);
                        final double llllllllllllllIIllIIIIIllIlIIIll = llllllllllllllIIllIIIIIllIlIIllI * llllllllllllllIIllIIIIIllIlIIllI + llllllllllllllIIllIIIIIllIlIIlIl * llllllllllllllIIllIIIIIllIlIIlIl + llllllllllllllIIllIIIIIllIlIIlII * llllllllllllllIIllIIIIIllIlIIlII;
                        if (llllllllllllllIIllIIIIIllIlIIIll < 1.0) {
                            llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIlIlIIl * 16 + llllllllllllllIIllIIIIIllIlIlIII) * 8 + llllllllllllllIIllIIIIIllIlIIlll] = true;
                        }
                    }
                }
            }
        }
        for (int llllllllllllllIIllIIIIIllIllIIII = 0; llllllllllllllIIllIIIIIllIllIIII < 16; ++llllllllllllllIIllIIIIIllIllIIII) {
            for (int llllllllllllllIIllIIIIIllIIllllI = 0; llllllllllllllIIllIIIIIllIIllllI < 16; ++llllllllllllllIIllIIIIIllIIllllI) {
                for (int llllllllllllllIIllIIIIIllIlIIIlI = 0; llllllllllllllIIllIIIIIllIlIIIlI < 8; ++llllllllllllllIIllIIIIIllIlIIIlI) {
                    final boolean llllllllllllllIIllIIIIIllIIllIIl = !llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIllllI) * 8 + llllllllllllllIIllIIIIIllIlIIIlI] && ((llllllllllllllIIllIIIIIllIllIIII < 15 && llllllllllllllIIllIIIIIllIllIIlI[((llllllllllllllIIllIIIIIllIllIIII + 1) * 16 + llllllllllllllIIllIIIIIllIIllllI) * 8 + llllllllllllllIIllIIIIIllIlIIIlI]) || (llllllllllllllIIllIIIIIllIllIIII > 0 && llllllllllllllIIllIIIIIllIllIIlI[((llllllllllllllIIllIIIIIllIllIIII - 1) * 16 + llllllllllllllIIllIIIIIllIIllllI) * 8 + llllllllllllllIIllIIIIIllIlIIIlI]) || (llllllllllllllIIllIIIIIllIIllllI < 15 && llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIllllI + 1) * 8 + llllllllllllllIIllIIIIIllIlIIIlI]) || (llllllllllllllIIllIIIIIllIIllllI > 0 && llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + (llllllllllllllIIllIIIIIllIIllllI - 1)) * 8 + llllllllllllllIIllIIIIIllIlIIIlI]) || (llllllllllllllIIllIIIIIllIlIIIlI < 7 && llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIllllI) * 8 + llllllllllllllIIllIIIIIllIlIIIlI + 1]) || (llllllllllllllIIllIIIIIllIlIIIlI > 0 && llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIllllI) * 8 + (llllllllllllllIIllIIIIIllIlIIIlI - 1)]));
                    if (llllllllllllllIIllIIIIIllIIllIIl) {
                        final Material llllllllllllllIIllIIIIIllIIlIlll = llllllllllllllIIllIIIIIllIllIlIl.getBlockState(llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIlIIIlI, llllllllllllllIIllIIIIIllIIllllI)).getBlock().getMaterial();
                        if (llllllllllllllIIllIIIIIllIlIIIlI >= 4 && llllllllllllllIIllIIIIIllIIlIlll.isLiquid()) {
                            return false;
                        }
                        if (llllllllllllllIIllIIIIIllIlIIIlI < 4 && !llllllllllllllIIllIIIIIllIIlIlll.isSolid() && llllllllllllllIIllIIIIIllIllIlIl.getBlockState(llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIlIIIlI, llllllllllllllIIllIIIIIllIIllllI)).getBlock() != this.field_150556_a) {
                            return false;
                        }
                    }
                }
            }
        }
        for (int llllllllllllllIIllIIIIIllIllIIII = 0; llllllllllllllIIllIIIIIllIllIIII < 16; ++llllllllllllllIIllIIIIIllIllIIII) {
            for (int llllllllllllllIIllIIIIIllIIlllIl = 0; llllllllllllllIIllIIIIIllIIlllIl < 16; ++llllllllllllllIIllIIIIIllIIlllIl) {
                for (int llllllllllllllIIllIIIIIllIlIIIIl = 0; llllllllllllllIIllIIIIIllIlIIIIl < 8; ++llllllllllllllIIllIIIIIllIlIIIIl) {
                    if (llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIlllIl) * 8 + llllllllllllllIIllIIIIIllIlIIIIl]) {
                        llllllllllllllIIllIIIIIllIllIlIl.setBlockState(llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIlIIIIl, llllllllllllllIIllIIIIIllIIlllIl), (llllllllllllllIIllIIIIIllIlIIIIl >= 4) ? Blocks.air.getDefaultState() : this.field_150556_a.getDefaultState(), 2);
                    }
                }
            }
        }
        for (int llllllllllllllIIllIIIIIllIllIIII = 0; llllllllllllllIIllIIIIIllIllIIII < 16; ++llllllllllllllIIllIIIIIllIllIIII) {
            for (int llllllllllllllIIllIIIIIllIIlllII = 0; llllllllllllllIIllIIIIIllIIlllII < 16; ++llllllllllllllIIllIIIIIllIIlllII) {
                for (int llllllllllllllIIllIIIIIllIlIIIII = 4; llllllllllllllIIllIIIIIllIlIIIII < 8; ++llllllllllllllIIllIIIIIllIlIIIII) {
                    if (llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIlllII) * 8 + llllllllllllllIIllIIIIIllIlIIIII]) {
                        final BlockPos llllllllllllllIIllIIIIIllIIlIllI = llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIlIIIII - 1, llllllllllllllIIllIIIIIllIIlllII);
                        if (llllllllllllllIIllIIIIIllIllIlIl.getBlockState(llllllllllllllIIllIIIIIllIIlIllI).getBlock() == Blocks.dirt && llllllllllllllIIllIIIIIllIllIlIl.getLightFor(EnumSkyBlock.SKY, llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIlIIIII, llllllllllllllIIllIIIIIllIIlllII)) > 0) {
                            final BiomeGenBase llllllllllllllIIllIIIIIllIIlIlIl = llllllllllllllIIllIIIIIllIllIlIl.getBiomeGenForCoords(llllllllllllllIIllIIIIIllIIlIllI);
                            if (llllllllllllllIIllIIIIIllIIlIlIl.topBlock.getBlock() == Blocks.mycelium) {
                                llllllllllllllIIllIIIIIllIllIlIl.setBlockState(llllllllllllllIIllIIIIIllIIlIllI, Blocks.mycelium.getDefaultState(), 2);
                            }
                            else {
                                llllllllllllllIIllIIIIIllIllIlIl.setBlockState(llllllllllllllIIllIIIIIllIIlIllI, Blocks.grass.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
        }
        if (this.field_150556_a.getMaterial() == Material.lava) {
            for (int llllllllllllllIIllIIIIIllIllIIII = 0; llllllllllllllIIllIIIIIllIllIIII < 16; ++llllllllllllllIIllIIIIIllIllIIII) {
                for (int llllllllllllllIIllIIIIIllIIllIll = 0; llllllllllllllIIllIIIIIllIIllIll < 16; ++llllllllllllllIIllIIIIIllIIllIll) {
                    for (int llllllllllllllIIllIIIIIllIIlllll = 0; llllllllllllllIIllIIIIIllIIlllll < 8; ++llllllllllllllIIllIIIIIllIIlllll) {
                        final boolean llllllllllllllIIllIIIIIllIIllIII = !llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIllIll) * 8 + llllllllllllllIIllIIIIIllIIlllll] && ((llllllllllllllIIllIIIIIllIllIIII < 15 && llllllllllllllIIllIIIIIllIllIIlI[((llllllllllllllIIllIIIIIllIllIIII + 1) * 16 + llllllllllllllIIllIIIIIllIIllIll) * 8 + llllllllllllllIIllIIIIIllIIlllll]) || (llllllllllllllIIllIIIIIllIllIIII > 0 && llllllllllllllIIllIIIIIllIllIIlI[((llllllllllllllIIllIIIIIllIllIIII - 1) * 16 + llllllllllllllIIllIIIIIllIIllIll) * 8 + llllllllllllllIIllIIIIIllIIlllll]) || (llllllllllllllIIllIIIIIllIIllIll < 15 && llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIllIll + 1) * 8 + llllllllllllllIIllIIIIIllIIlllll]) || (llllllllllllllIIllIIIIIllIIllIll > 0 && llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + (llllllllllllllIIllIIIIIllIIllIll - 1)) * 8 + llllllllllllllIIllIIIIIllIIlllll]) || (llllllllllllllIIllIIIIIllIIlllll < 7 && llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIllIll) * 8 + llllllllllllllIIllIIIIIllIIlllll + 1]) || (llllllllllllllIIllIIIIIllIIlllll > 0 && llllllllllllllIIllIIIIIllIllIIlI[(llllllllllllllIIllIIIIIllIllIIII * 16 + llllllllllllllIIllIIIIIllIIllIll) * 8 + (llllllllllllllIIllIIIIIllIIlllll - 1)]));
                        if (llllllllllllllIIllIIIIIllIIllIII && (llllllllllllllIIllIIIIIllIIlllll < 4 || llllllllllllllIIllIIIIIllIllIlII.nextInt(2) != 0) && llllllllllllllIIllIIIIIllIllIlIl.getBlockState(llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIIlllll, llllllllllllllIIllIIIIIllIIllIll)).getBlock().getMaterial().isSolid()) {
                            llllllllllllllIIllIIIIIllIllIlIl.setBlockState(llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIIlllll, llllllllllllllIIllIIIIIllIIllIll), Blocks.stone.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        if (this.field_150556_a.getMaterial() == Material.water) {
            for (int llllllllllllllIIllIIIIIllIllIIII = 0; llllllllllllllIIllIIIIIllIllIIII < 16; ++llllllllllllllIIllIIIIIllIllIIII) {
                for (int llllllllllllllIIllIIIIIllIIllIlI = 0; llllllllllllllIIllIIIIIllIIllIlI < 16; ++llllllllllllllIIllIIIIIllIIllIlI) {
                    final byte llllllllllllllIIllIIIIIllIIlIlII = 4;
                    if (llllllllllllllIIllIIIIIllIllIlIl.func_175675_v(llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIIlIlII, llllllllllllllIIllIIIIIllIIllIlI))) {
                        llllllllllllllIIllIIIIIllIllIlIl.setBlockState(llllllllllllllIIllIIIIIllIIlIIII.add(llllllllllllllIIllIIIIIllIllIIII, llllllllllllllIIllIIIIIllIIlIlII, llllllllllllllIIllIIIIIllIIllIlI), Blocks.ice.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenLakes(final Block llllllllllllllIIllIIIIIlllIIllll) {
        this.field_150556_a = llllllllllllllIIllIIIIIlllIIllll;
    }
}
