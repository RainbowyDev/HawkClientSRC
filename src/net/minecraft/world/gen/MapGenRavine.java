package net.minecraft.world.gen;

import net.minecraft.world.chunk.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;

public class MapGenRavine extends MapGenBase
{
    private /* synthetic */ float[] field_75046_d;
    
    protected void func_180707_a(final long llllllllllllllllIlIIlIlIlIIlIIll, final int llllllllllllllllIlIIlIlIlIIlIIlI, final int llllllllllllllllIlIIlIlIlIIlIIIl, final ChunkPrimer llllllllllllllllIlIIlIlIllIIIIIl, double llllllllllllllllIlIIlIlIlIIIllll, double llllllllllllllllIlIIlIlIlIIIlllI, double llllllllllllllllIlIIlIlIlIIIllIl, final float llllllllllllllllIlIIlIlIlIllllIl, float llllllllllllllllIlIIlIlIlIIIlIll, float llllllllllllllllIlIIlIlIlIIIlIlI, int llllllllllllllllIlIIlIlIlIlllIlI, int llllllllllllllllIlIIlIlIlIIIlIII, final double llllllllllllllllIlIIlIlIlIIIIlll) {
        final Random llllllllllllllllIlIIlIlIlIllIlll = new Random(llllllllllllllllIlIIlIlIlIIlIIll);
        final double llllllllllllllllIlIIlIlIlIllIllI = llllllllllllllllIlIIlIlIlIIlIIlI * 16 + 8;
        final double llllllllllllllllIlIIlIlIlIllIlIl = llllllllllllllllIlIIlIlIlIIlIIIl * 16 + 8;
        float llllllllllllllllIlIIlIlIlIllIlII = 0.0f;
        float llllllllllllllllIlIIlIlIlIllIIll = 0.0f;
        if (llllllllllllllllIlIIlIlIlIIIlIII <= 0) {
            final int llllllllllllllllIlIIlIlIlIllIIlI = this.range * 16 - 16;
            llllllllllllllllIlIIlIlIlIIIlIII = llllllllllllllllIlIIlIlIlIllIIlI - llllllllllllllllIlIIlIlIlIllIlll.nextInt(llllllllllllllllIlIIlIlIlIllIIlI / 4);
        }
        boolean llllllllllllllllIlIIlIlIlIllIIIl = false;
        if (llllllllllllllllIlIIlIlIlIlllIlI == -1) {
            llllllllllllllllIlIIlIlIlIlllIlI = llllllllllllllllIlIIlIlIlIIIlIII / 2;
            llllllllllllllllIlIIlIlIlIllIIIl = true;
        }
        float llllllllllllllllIlIIlIlIlIllIIII = 1.0f;
        for (int llllllllllllllllIlIIlIlIlIlIllll = 0; llllllllllllllllIlIIlIlIlIlIllll < 256; ++llllllllllllllllIlIIlIlIlIlIllll) {
            if (llllllllllllllllIlIIlIlIlIlIllll == 0 || llllllllllllllllIlIIlIlIlIllIlll.nextInt(3) == 0) {
                llllllllllllllllIlIIlIlIlIllIIII = 1.0f + llllllllllllllllIlIIlIlIlIllIlll.nextFloat() * llllllllllllllllIlIIlIlIlIllIlll.nextFloat() * 1.0f;
            }
            this.field_75046_d[llllllllllllllllIlIIlIlIlIlIllll] = llllllllllllllllIlIIlIlIlIllIIII * llllllllllllllllIlIIlIlIlIllIIII;
        }
        while (llllllllllllllllIlIIlIlIlIlllIlI < llllllllllllllllIlIIlIlIlIIIlIII) {
            double llllllllllllllllIlIIlIlIlIlIlllI = 1.5 + MathHelper.sin(llllllllllllllllIlIIlIlIlIlllIlI * 3.1415927f / llllllllllllllllIlIIlIlIlIIIlIII) * llllllllllllllllIlIIlIlIlIllllIl * 1.0f;
            double llllllllllllllllIlIIlIlIlIlIllIl = llllllllllllllllIlIIlIlIlIlIlllI * llllllllllllllllIlIIlIlIlIIIIlll;
            llllllllllllllllIlIIlIlIlIlIlllI *= llllllllllllllllIlIIlIlIlIllIlll.nextFloat() * 0.25 + 0.75;
            llllllllllllllllIlIIlIlIlIlIllIl *= llllllllllllllllIlIIlIlIlIllIlll.nextFloat() * 0.25 + 0.75;
            final float llllllllllllllllIlIIlIlIlIlIllII = MathHelper.cos(llllllllllllllllIlIIlIlIlIIIlIlI);
            final float llllllllllllllllIlIIlIlIlIlIlIll = MathHelper.sin(llllllllllllllllIlIIlIlIlIIIlIlI);
            llllllllllllllllIlIIlIlIlIIIllll += MathHelper.cos(llllllllllllllllIlIIlIlIlIIIlIll) * llllllllllllllllIlIIlIlIlIlIllII;
            llllllllllllllllIlIIlIlIlIIIlllI += llllllllllllllllIlIIlIlIlIlIlIll;
            llllllllllllllllIlIIlIlIlIIIllIl += MathHelper.sin(llllllllllllllllIlIIlIlIlIIIlIll) * llllllllllllllllIlIIlIlIlIlIllII;
            llllllllllllllllIlIIlIlIlIIIlIlI *= 0.7f;
            llllllllllllllllIlIIlIlIlIIIlIlI += llllllllllllllllIlIIlIlIlIllIIll * 0.05f;
            llllllllllllllllIlIIlIlIlIIIlIll += llllllllllllllllIlIIlIlIlIllIlII * 0.05f;
            llllllllllllllllIlIIlIlIlIllIIll *= 0.8f;
            llllllllllllllllIlIIlIlIlIllIlII *= 0.5f;
            llllllllllllllllIlIIlIlIlIllIIll += (llllllllllllllllIlIIlIlIlIllIlll.nextFloat() - llllllllllllllllIlIIlIlIlIllIlll.nextFloat()) * llllllllllllllllIlIIlIlIlIllIlll.nextFloat() * 2.0f;
            llllllllllllllllIlIIlIlIlIllIlII += (llllllllllllllllIlIIlIlIlIllIlll.nextFloat() - llllllllllllllllIlIIlIlIlIllIlll.nextFloat()) * llllllllllllllllIlIIlIlIlIllIlll.nextFloat() * 4.0f;
            if (llllllllllllllllIlIIlIlIlIllIIIl || llllllllllllllllIlIIlIlIlIllIlll.nextInt(4) != 0) {
                final double llllllllllllllllIlIIlIlIlIlIlIlI = llllllllllllllllIlIIlIlIlIIIllll - llllllllllllllllIlIIlIlIlIllIllI;
                final double llllllllllllllllIlIIlIlIlIlIlIIl = llllllllllllllllIlIIlIlIlIIIllIl - llllllllllllllllIlIIlIlIlIllIlIl;
                final double llllllllllllllllIlIIlIlIlIlIlIII = llllllllllllllllIlIIlIlIlIIIlIII - llllllllllllllllIlIIlIlIlIlllIlI;
                final double llllllllllllllllIlIIlIlIlIlIIlll = llllllllllllllllIlIIlIlIlIllllIl + 2.0f + 16.0f;
                if (llllllllllllllllIlIIlIlIlIlIlIlI * llllllllllllllllIlIIlIlIlIlIlIlI + llllllllllllllllIlIIlIlIlIlIlIIl * llllllllllllllllIlIIlIlIlIlIlIIl - llllllllllllllllIlIIlIlIlIlIlIII * llllllllllllllllIlIIlIlIlIlIlIII > llllllllllllllllIlIIlIlIlIlIIlll * llllllllllllllllIlIIlIlIlIlIIlll) {
                    return;
                }
                if (llllllllllllllllIlIIlIlIlIIIllll >= llllllllllllllllIlIIlIlIlIllIllI - 16.0 - llllllllllllllllIlIIlIlIlIlIlllI * 2.0 && llllllllllllllllIlIIlIlIlIIIllIl >= llllllllllllllllIlIIlIlIlIllIlIl - 16.0 - llllllllllllllllIlIIlIlIlIlIlllI * 2.0 && llllllllllllllllIlIIlIlIlIIIllll <= llllllllllllllllIlIIlIlIlIllIllI + 16.0 + llllllllllllllllIlIIlIlIlIlIlllI * 2.0 && llllllllllllllllIlIIlIlIlIIIllIl <= llllllllllllllllIlIIlIlIlIllIlIl + 16.0 + llllllllllllllllIlIIlIlIlIlIlllI * 2.0) {
                    int llllllllllllllllIlIIlIlIlIlIIllI = MathHelper.floor_double(llllllllllllllllIlIIlIlIlIIIllll - llllllllllllllllIlIIlIlIlIlIlllI) - llllllllllllllllIlIIlIlIlIIlIIlI * 16 - 1;
                    int llllllllllllllllIlIIlIlIlIlIIlIl = MathHelper.floor_double(llllllllllllllllIlIIlIlIlIIIllll + llllllllllllllllIlIIlIlIlIlIlllI) - llllllllllllllllIlIIlIlIlIIlIIlI * 16 + 1;
                    int llllllllllllllllIlIIlIlIlIlIIlII = MathHelper.floor_double((double)(llllllllllllllllIlIIlIlIlIIIlllI - llllllllllllllllIlIIlIlIlIlIllIl)) - 1;
                    int llllllllllllllllIlIIlIlIlIlIIIll = MathHelper.floor_double((double)(llllllllllllllllIlIIlIlIlIIIlllI + llllllllllllllllIlIIlIlIlIlIllIl)) + 1;
                    int llllllllllllllllIlIIlIlIlIlIIIlI = MathHelper.floor_double(llllllllllllllllIlIIlIlIlIIIllIl - llllllllllllllllIlIIlIlIlIlIlllI) - llllllllllllllllIlIIlIlIlIIlIIIl * 16 - 1;
                    int llllllllllllllllIlIIlIlIlIlIIIIl = MathHelper.floor_double(llllllllllllllllIlIIlIlIlIIIllIl + llllllllllllllllIlIIlIlIlIlIlllI) - llllllllllllllllIlIIlIlIlIIlIIIl * 16 + 1;
                    if (llllllllllllllllIlIIlIlIlIlIIllI < 0) {
                        llllllllllllllllIlIIlIlIlIlIIllI = 0;
                    }
                    if (llllllllllllllllIlIIlIlIlIlIIlIl > 16) {
                        llllllllllllllllIlIIlIlIlIlIIlIl = 16;
                    }
                    if (llllllllllllllllIlIIlIlIlIlIIlII < 1) {
                        llllllllllllllllIlIIlIlIlIlIIlII = 1;
                    }
                    if (llllllllllllllllIlIIlIlIlIlIIIll > 248) {
                        llllllllllllllllIlIIlIlIlIlIIIll = 248;
                    }
                    if (llllllllllllllllIlIIlIlIlIlIIIlI < 0) {
                        llllllllllllllllIlIIlIlIlIlIIIlI = 0;
                    }
                    if (llllllllllllllllIlIIlIlIlIlIIIIl > 16) {
                        llllllllllllllllIlIIlIlIlIlIIIIl = 16;
                    }
                    boolean llllllllllllllllIlIIlIlIlIlIIIII = false;
                    for (int llllllllllllllllIlIIlIlIlIIlllll = llllllllllllllllIlIIlIlIlIlIIllI; !llllllllllllllllIlIIlIlIlIlIIIII && llllllllllllllllIlIIlIlIlIIlllll < llllllllllllllllIlIIlIlIlIlIIlIl; ++llllllllllllllllIlIIlIlIlIIlllll) {
                        for (int llllllllllllllllIlIIlIlIlIIllllI = llllllllllllllllIlIIlIlIlIlIIIlI; !llllllllllllllllIlIIlIlIlIlIIIII && llllllllllllllllIlIIlIlIlIIllllI < llllllllllllllllIlIIlIlIlIlIIIIl; ++llllllllllllllllIlIIlIlIlIIllllI) {
                            for (int llllllllllllllllIlIIlIlIlIIlllIl = llllllllllllllllIlIIlIlIlIlIIIll + 1; !llllllllllllllllIlIIlIlIlIlIIIII && llllllllllllllllIlIIlIlIlIIlllIl >= llllllllllllllllIlIIlIlIlIlIIlII - 1; --llllllllllllllllIlIIlIlIlIIlllIl) {
                                if (llllllllllllllllIlIIlIlIlIIlllIl >= 0 && llllllllllllllllIlIIlIlIlIIlllIl < 256) {
                                    final IBlockState llllllllllllllllIlIIlIlIlIIlllII = llllllllllllllllIlIIlIlIllIIIIIl.getBlockState(llllllllllllllllIlIIlIlIlIIlllll, llllllllllllllllIlIIlIlIlIIlllIl, llllllllllllllllIlIIlIlIlIIllllI);
                                    if (llllllllllllllllIlIIlIlIlIIlllII.getBlock() == Blocks.flowing_water || llllllllllllllllIlIIlIlIlIIlllII.getBlock() == Blocks.water) {
                                        llllllllllllllllIlIIlIlIlIlIIIII = true;
                                    }
                                    if (llllllllllllllllIlIIlIlIlIIlllIl != llllllllllllllllIlIIlIlIlIlIIlII - 1 && llllllllllllllllIlIIlIlIlIIlllll != llllllllllllllllIlIIlIlIlIlIIllI && llllllllllllllllIlIIlIlIlIIlllll != llllllllllllllllIlIIlIlIlIlIIlIl - 1 && llllllllllllllllIlIIlIlIlIIllllI != llllllllllllllllIlIIlIlIlIlIIIlI && llllllllllllllllIlIIlIlIlIIllllI != llllllllllllllllIlIIlIlIlIlIIIIl - 1) {
                                        llllllllllllllllIlIIlIlIlIIlllIl = llllllllllllllllIlIIlIlIlIlIIlII;
                                    }
                                }
                            }
                        }
                    }
                    if (!llllllllllllllllIlIIlIlIlIlIIIII) {
                        for (int llllllllllllllllIlIIlIlIlIIlllll = llllllllllllllllIlIIlIlIlIlIIllI; llllllllllllllllIlIIlIlIlIIlllll < llllllllllllllllIlIIlIlIlIlIIlIl; ++llllllllllllllllIlIIlIlIlIIlllll) {
                            final double llllllllllllllllIlIIlIlIlIIllIll = (llllllllllllllllIlIIlIlIlIIlllll + llllllllllllllllIlIIlIlIlIIlIIlI * 16 + 0.5 - llllllllllllllllIlIIlIlIlIIIllll) / llllllllllllllllIlIIlIlIlIlIlllI;
                            for (int llllllllllllllllIlIIlIlIlIIllIlI = llllllllllllllllIlIIlIlIlIlIIIlI; llllllllllllllllIlIIlIlIlIIllIlI < llllllllllllllllIlIIlIlIlIlIIIIl; ++llllllllllllllllIlIIlIlIlIIllIlI) {
                                final double llllllllllllllllIlIIlIlIlIIllIIl = (llllllllllllllllIlIIlIlIlIIllIlI + llllllllllllllllIlIIlIlIlIIlIIIl * 16 + 0.5 - llllllllllllllllIlIIlIlIlIIIllIl) / llllllllllllllllIlIIlIlIlIlIlllI;
                                boolean llllllllllllllllIlIIlIlIlIIllIII = false;
                                if (llllllllllllllllIlIIlIlIlIIllIll * llllllllllllllllIlIIlIlIlIIllIll + llllllllllllllllIlIIlIlIlIIllIIl * llllllllllllllllIlIIlIlIlIIllIIl < 1.0) {
                                    for (int llllllllllllllllIlIIlIlIlIIlIlll = llllllllllllllllIlIIlIlIlIlIIIll; llllllllllllllllIlIIlIlIlIIlIlll > llllllllllllllllIlIIlIlIlIlIIlII; --llllllllllllllllIlIIlIlIlIIlIlll) {
                                        final double llllllllllllllllIlIIlIlIlIIlIllI = (double)((llllllllllllllllIlIIlIlIlIIlIlll - 1 + 0.5 - llllllllllllllllIlIIlIlIlIIIlllI) / llllllllllllllllIlIIlIlIlIlIllIl);
                                        if ((llllllllllllllllIlIIlIlIlIIllIll * llllllllllllllllIlIIlIlIlIIllIll + llllllllllllllllIlIIlIlIlIIllIIl * llllllllllllllllIlIIlIlIlIIllIIl) * this.field_75046_d[llllllllllllllllIlIIlIlIlIIlIlll - 1] + llllllllllllllllIlIIlIlIlIIlIllI * llllllllllllllllIlIIlIlIlIIlIllI / 6.0 < 1.0) {
                                            final IBlockState llllllllllllllllIlIIlIlIlIIlIlIl = llllllllllllllllIlIIlIlIllIIIIIl.getBlockState(llllllllllllllllIlIIlIlIlIIlllll, llllllllllllllllIlIIlIlIlIIlIlll, llllllllllllllllIlIIlIlIlIIllIlI);
                                            if (llllllllllllllllIlIIlIlIlIIlIlIl.getBlock() == Blocks.grass) {
                                                llllllllllllllllIlIIlIlIlIIllIII = true;
                                            }
                                            if (llllllllllllllllIlIIlIlIlIIlIlIl.getBlock() == Blocks.stone || llllllllllllllllIlIIlIlIlIIlIlIl.getBlock() == Blocks.dirt || llllllllllllllllIlIIlIlIlIIlIlIl.getBlock() == Blocks.grass) {
                                                if (llllllllllllllllIlIIlIlIlIIlIlll - 1 < 10) {
                                                    llllllllllllllllIlIIlIlIllIIIIIl.setBlockState(llllllllllllllllIlIIlIlIlIIlllll, llllllllllllllllIlIIlIlIlIIlIlll, llllllllllllllllIlIIlIlIlIIllIlI, Blocks.flowing_lava.getDefaultState());
                                                }
                                                else {
                                                    llllllllllllllllIlIIlIlIllIIIIIl.setBlockState(llllllllllllllllIlIIlIlIlIIlllll, llllllllllllllllIlIIlIlIlIIlIlll, llllllllllllllllIlIIlIlIlIIllIlI, Blocks.air.getDefaultState());
                                                    if (llllllllllllllllIlIIlIlIlIIllIII && llllllllllllllllIlIIlIlIllIIIIIl.getBlockState(llllllllllllllllIlIIlIlIlIIlllll, llllllllllllllllIlIIlIlIlIIlIlll - 1, llllllllllllllllIlIIlIlIlIIllIlI).getBlock() == Blocks.dirt) {
                                                        llllllllllllllllIlIIlIlIllIIIIIl.setBlockState(llllllllllllllllIlIIlIlIlIIlllll, llllllllllllllllIlIIlIlIlIIlIlll - 1, llllllllllllllllIlIIlIlIlIIllIlI, this.worldObj.getBiomeGenForCoords(new BlockPos(llllllllllllllllIlIIlIlIlIIlllll + llllllllllllllllIlIIlIlIlIIlIIlI * 16, 0, llllllllllllllllIlIIlIlIlIIllIlI + llllllllllllllllIlIIlIlIlIIlIIIl * 16)).topBlock);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (llllllllllllllllIlIIlIlIlIllIIIl) {
                            break;
                        }
                    }
                }
            }
            ++llllllllllllllllIlIIlIlIlIlllIlI;
        }
    }
    
    @Override
    protected void func_180701_a(final World llllllllllllllllIlIIlIlIIlIllIII, final int llllllllllllllllIlIIlIlIIlIIlIIl, final int llllllllllllllllIlIIlIlIIlIIlIII, final int llllllllllllllllIlIIlIlIIlIlIlIl, final int llllllllllllllllIlIIlIlIIlIlIlII, final ChunkPrimer llllllllllllllllIlIIlIlIIlIIIlIl) {
        if (this.rand.nextInt(50) == 0) {
            final double llllllllllllllllIlIIlIlIIlIlIIlI = llllllllllllllllIlIIlIlIIlIIlIIl * 16 + this.rand.nextInt(16);
            final double llllllllllllllllIlIIlIlIIlIlIIIl = this.rand.nextInt(this.rand.nextInt(40) + 8) + 20;
            final double llllllllllllllllIlIIlIlIIlIlIIII = llllllllllllllllIlIIlIlIIlIIlIII * 16 + this.rand.nextInt(16);
            final byte llllllllllllllllIlIIlIlIIlIIllll = 1;
            for (int llllllllllllllllIlIIlIlIIlIIlllI = 0; llllllllllllllllIlIIlIlIIlIIlllI < llllllllllllllllIlIIlIlIIlIIllll; ++llllllllllllllllIlIIlIlIIlIIlllI) {
                final float llllllllllllllllIlIIlIlIIlIIllIl = this.rand.nextFloat() * 3.1415927f * 2.0f;
                final float llllllllllllllllIlIIlIlIIlIIllII = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                final float llllllllllllllllIlIIlIlIIlIIlIll = (this.rand.nextFloat() * 2.0f + this.rand.nextFloat()) * 2.0f;
                this.func_180707_a(this.rand.nextLong(), llllllllllllllllIlIIlIlIIlIlIlIl, llllllllllllllllIlIIlIlIIlIlIlII, llllllllllllllllIlIIlIlIIlIIIlIl, llllllllllllllllIlIIlIlIIlIlIIlI, llllllllllllllllIlIIlIlIIlIlIIIl, llllllllllllllllIlIIlIlIIlIlIIII, llllllllllllllllIlIIlIlIIlIIlIll, llllllllllllllllIlIIlIlIIlIIllIl, llllllllllllllllIlIIlIlIIlIIllII, 0, 0, 3.0);
            }
        }
    }
    
    static {
        __OBFID = "CL_00000390";
    }
    
    public MapGenRavine() {
        this.field_75046_d = new float[1024];
    }
}
