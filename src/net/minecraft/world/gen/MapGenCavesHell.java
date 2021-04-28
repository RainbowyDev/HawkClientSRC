package net.minecraft.world.gen;

import net.minecraft.world.chunk.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;

public class MapGenCavesHell extends MapGenBase
{
    static {
        __OBFID = "CL_00000395";
    }
    
    protected void func_180704_a(final long llllllllllllllIllIllIlllIlIIIIIl, final int llllllllllllllIllIllIlllIlIIIIII, final int llllllllllllllIllIllIlllIIllllll, final ChunkPrimer llllllllllllllIllIllIlllIIIIlllI, double llllllllllllllIllIllIlllIIIIllIl, double llllllllllllllIllIllIlllIIIIllII, double llllllllllllllIllIllIlllIIIIlIll, final float llllllllllllllIllIllIlllIIIIlIlI, float llllllllllllllIllIllIlllIIIIlIIl, float llllllllllllllIllIllIlllIIIIlIII, int llllllllllllllIllIllIlllIIIIIlll, int llllllllllllllIllIllIlllIIIIIllI, final double llllllllllllllIllIllIlllIIllIlIl) {
        final double llllllllllllllIllIllIlllIIllIlII = llllllllllllllIllIllIlllIlIIIIII * 16 + 8;
        final double llllllllllllllIllIllIlllIIllIIll = llllllllllllllIllIllIlllIIllllll * 16 + 8;
        float llllllllllllllIllIllIlllIIllIIlI = 0.0f;
        float llllllllllllllIllIllIlllIIllIIIl = 0.0f;
        final Random llllllllllllllIllIllIlllIIllIIII = new Random(llllllllllllllIllIllIlllIlIIIIIl);
        if (llllllllllllllIllIllIlllIIIIIllI <= 0) {
            final int llllllllllllllIllIllIlllIIlIllll = this.range * 16 - 16;
            llllllllllllllIllIllIlllIIIIIllI = llllllllllllllIllIllIlllIIlIllll - llllllllllllllIllIllIlllIIllIIII.nextInt(llllllllllllllIllIllIlllIIlIllll / 4);
        }
        boolean llllllllllllllIllIllIlllIIlIlllI = false;
        if (llllllllllllllIllIllIlllIIIIIlll == -1) {
            llllllllllllllIllIllIlllIIIIIlll = llllllllllllllIllIllIlllIIIIIllI / 2;
            llllllllllllllIllIllIlllIIlIlllI = true;
        }
        final int llllllllllllllIllIllIlllIIlIllIl = (int)(llllllllllllllIllIllIlllIIllIIII.nextInt((int)(llllllllllllllIllIllIlllIIIIIllI / 2)) + llllllllllllllIllIllIlllIIIIIllI / 4);
        final boolean llllllllllllllIllIllIlllIIlIllII = llllllllllllllIllIllIlllIIllIIII.nextInt(6) == 0;
        while (llllllllllllllIllIllIlllIIIIIlll < llllllllllllllIllIllIlllIIIIIllI) {
            final double llllllllllllllIllIllIlllIIlIlIll = 1.5 + MathHelper.sin((float)llllllllllllllIllIllIlllIIIIIlll * 3.1415927f / (float)llllllllllllllIllIllIlllIIIIIllI) * llllllllllllllIllIllIlllIIIIlIlI * 1.0f;
            final double llllllllllllllIllIllIlllIIlIlIlI = llllllllllllllIllIllIlllIIlIlIll * llllllllllllllIllIllIlllIIllIlIl;
            final float llllllllllllllIllIllIlllIIlIlIIl = MathHelper.cos(llllllllllllllIllIllIlllIIIIlIII);
            final float llllllllllllllIllIllIlllIIlIlIII = MathHelper.sin(llllllllllllllIllIllIlllIIIIlIII);
            llllllllllllllIllIllIlllIIIIllIl += MathHelper.cos(llllllllllllllIllIllIlllIIIIlIIl) * llllllllllllllIllIllIlllIIlIlIIl;
            llllllllllllllIllIllIlllIIIIllII += llllllllllllllIllIllIlllIIlIlIII;
            llllllllllllllIllIllIlllIIIIlIll += MathHelper.sin(llllllllllllllIllIllIlllIIIIlIIl) * llllllllllllllIllIllIlllIIlIlIIl;
            if (llllllllllllllIllIllIlllIIlIllII) {
                llllllllllllllIllIllIlllIIIIlIII *= 0.92f;
            }
            else {
                llllllllllllllIllIllIlllIIIIlIII *= 0.7f;
            }
            llllllllllllllIllIllIlllIIIIlIII += llllllllllllllIllIllIlllIIllIIIl * 0.1f;
            llllllllllllllIllIllIlllIIIIlIIl += llllllllllllllIllIllIlllIIllIIlI * 0.1f;
            llllllllllllllIllIllIlllIIllIIIl *= 0.9f;
            llllllllllllllIllIllIlllIIllIIlI *= 0.75f;
            llllllllllllllIllIllIlllIIllIIIl += (llllllllllllllIllIllIlllIIllIIII.nextFloat() - llllllllllllllIllIllIlllIIllIIII.nextFloat()) * llllllllllllllIllIllIlllIIllIIII.nextFloat() * 2.0f;
            llllllllllllllIllIllIlllIIllIIlI += (llllllllllllllIllIllIlllIIllIIII.nextFloat() - llllllllllllllIllIllIlllIIllIIII.nextFloat()) * llllllllllllllIllIllIlllIIllIIII.nextFloat() * 4.0f;
            if (!llllllllllllllIllIllIlllIIlIlllI && llllllllllllllIllIllIlllIIIIIlll == llllllllllllllIllIllIlllIIlIllIl && llllllllllllllIllIllIlllIIIIlIlI > 1.0f) {
                this.func_180704_a(llllllllllllllIllIllIlllIIllIIII.nextLong(), llllllllllllllIllIllIlllIlIIIIII, llllllllllllllIllIllIlllIIllllll, llllllllllllllIllIllIlllIIIIlllI, llllllllllllllIllIllIlllIIIIllIl, (double)llllllllllllllIllIllIlllIIIIllII, (double)llllllllllllllIllIllIlllIIIIlIll, llllllllllllllIllIllIlllIIllIIII.nextFloat() * 0.5f + 0.5f, llllllllllllllIllIllIlllIIIIlIIl - 1.5707964f, llllllllllllllIllIllIlllIIIIlIII / 3.0f, (int)llllllllllllllIllIllIlllIIIIIlll, (int)llllllllllllllIllIllIlllIIIIIllI, 1.0);
                this.func_180704_a(llllllllllllllIllIllIlllIIllIIII.nextLong(), llllllllllllllIllIllIlllIlIIIIII, llllllllllllllIllIllIlllIIllllll, llllllllllllllIllIllIlllIIIIlllI, llllllllllllllIllIllIlllIIIIllIl, (double)llllllllllllllIllIllIlllIIIIllII, (double)llllllllllllllIllIllIlllIIIIlIll, llllllllllllllIllIllIlllIIllIIII.nextFloat() * 0.5f + 0.5f, llllllllllllllIllIllIlllIIIIlIIl + 1.5707964f, llllllllllllllIllIllIlllIIIIlIII / 3.0f, (int)llllllllllllllIllIllIlllIIIIIlll, (int)llllllllllllllIllIllIlllIIIIIllI, 1.0);
                return;
            }
            if (llllllllllllllIllIllIlllIIlIlllI || llllllllllllllIllIllIlllIIllIIII.nextInt(4) != 0) {
                final double llllllllllllllIllIllIlllIIlIIlll = llllllllllllllIllIllIlllIIIIllIl - llllllllllllllIllIllIlllIIllIlII;
                final double llllllllllllllIllIllIlllIIlIIllI = (double)(llllllllllllllIllIllIlllIIIIlIll - llllllllllllllIllIllIlllIIllIIll);
                final double llllllllllllllIllIllIlllIIlIIlIl = llllllllllllllIllIllIlllIIIIIllI - llllllllllllllIllIllIlllIIIIIlll;
                final double llllllllllllllIllIllIlllIIlIIlII = llllllllllllllIllIllIlllIIIIlIlI + 2.0f + 16.0f;
                if (llllllllllllllIllIllIlllIIlIIlll * llllllllllllllIllIllIlllIIlIIlll + llllllllllllllIllIllIlllIIlIIllI * llllllllllllllIllIllIlllIIlIIllI - llllllllllllllIllIllIlllIIlIIlIl * llllllllllllllIllIllIlllIIlIIlIl > llllllllllllllIllIllIlllIIlIIlII * llllllllllllllIllIllIlllIIlIIlII) {
                    return;
                }
                if (llllllllllllllIllIllIlllIIIIllIl >= llllllllllllllIllIllIlllIIllIlII - 16.0 - llllllllllllllIllIllIlllIIlIlIll * 2.0 && llllllllllllllIllIllIlllIIIIlIll >= llllllllllllllIllIllIlllIIllIIll - 16.0 - llllllllllllllIllIllIlllIIlIlIll * 2.0 && llllllllllllllIllIllIlllIIIIllIl <= llllllllllllllIllIllIlllIIllIlII + 16.0 + llllllllllllllIllIllIlllIIlIlIll * 2.0 && llllllllllllllIllIllIlllIIIIlIll <= llllllllllllllIllIllIlllIIllIIll + 16.0 + llllllllllllllIllIllIlllIIlIlIll * 2.0) {
                    int llllllllllllllIllIllIlllIIlIIIll = MathHelper.floor_double(llllllllllllllIllIllIlllIIIIllIl - llllllllllllllIllIllIlllIIlIlIll) - llllllllllllllIllIllIlllIlIIIIII * 16 - 1;
                    int llllllllllllllIllIllIlllIIlIIIlI = MathHelper.floor_double(llllllllllllllIllIllIlllIIIIllIl + llllllllllllllIllIllIlllIIlIlIll) - llllllllllllllIllIllIlllIlIIIIII * 16 + 1;
                    int llllllllllllllIllIllIlllIIlIIIIl = MathHelper.floor_double((double)(llllllllllllllIllIllIlllIIIIllII - llllllllllllllIllIllIlllIIlIlIlI)) - 1;
                    int llllllllllllllIllIllIlllIIlIIIII = MathHelper.floor_double((double)(llllllllllllllIllIllIlllIIIIllII + llllllllllllllIllIllIlllIIlIlIlI)) + 1;
                    int llllllllllllllIllIllIlllIIIlllll = MathHelper.floor_double((double)(llllllllllllllIllIllIlllIIIIlIll - llllllllllllllIllIllIlllIIlIlIll)) - llllllllllllllIllIllIlllIIllllll * 16 - 1;
                    int llllllllllllllIllIllIlllIIIllllI = MathHelper.floor_double((double)(llllllllllllllIllIllIlllIIIIlIll + llllllllllllllIllIllIlllIIlIlIll)) - llllllllllllllIllIllIlllIIllllll * 16 + 1;
                    if (llllllllllllllIllIllIlllIIlIIIll < 0) {
                        llllllllllllllIllIllIlllIIlIIIll = 0;
                    }
                    if (llllllllllllllIllIllIlllIIlIIIlI > 16) {
                        llllllllllllllIllIllIlllIIlIIIlI = 16;
                    }
                    if (llllllllllllllIllIllIlllIIlIIIIl < 1) {
                        llllllllllllllIllIllIlllIIlIIIIl = 1;
                    }
                    if (llllllllllllllIllIllIlllIIlIIIII > 120) {
                        llllllllllllllIllIllIlllIIlIIIII = 120;
                    }
                    if (llllllllllllllIllIllIlllIIIlllll < 0) {
                        llllllllllllllIllIllIlllIIIlllll = 0;
                    }
                    if (llllllllllllllIllIllIlllIIIllllI > 16) {
                        llllllllllllllIllIllIlllIIIllllI = 16;
                    }
                    boolean llllllllllllllIllIllIlllIIIlllIl = false;
                    for (int llllllllllllllIllIllIlllIIIlllII = llllllllllllllIllIllIlllIIlIIIll; !llllllllllllllIllIllIlllIIIlllIl && llllllllllllllIllIllIlllIIIlllII < llllllllllllllIllIllIlllIIlIIIlI; ++llllllllllllllIllIllIlllIIIlllII) {
                        for (int llllllllllllllIllIllIlllIIIllIll = llllllllllllllIllIllIlllIIIlllll; !llllllllllllllIllIllIlllIIIlllIl && llllllllllllllIllIllIlllIIIllIll < llllllllllllllIllIllIlllIIIllllI; ++llllllllllllllIllIllIlllIIIllIll) {
                            for (int llllllllllllllIllIllIlllIIIllIlI = llllllllllllllIllIllIlllIIlIIIII + 1; !llllllllllllllIllIllIlllIIIlllIl && llllllllllllllIllIllIlllIIIllIlI >= llllllllllllllIllIllIlllIIlIIIIl - 1; --llllllllllllllIllIllIlllIIIllIlI) {
                                if (llllllllllllllIllIllIlllIIIllIlI >= 0 && llllllllllllllIllIllIlllIIIllIlI < 128) {
                                    final IBlockState llllllllllllllIllIllIlllIIIllIIl = llllllllllllllIllIllIlllIIIIlllI.getBlockState(llllllllllllllIllIllIlllIIIlllII, llllllllllllllIllIllIlllIIIllIlI, llllllllllllllIllIllIlllIIIllIll);
                                    if (llllllllllllllIllIllIlllIIIllIIl.getBlock() == Blocks.flowing_lava || llllllllllllllIllIllIlllIIIllIIl.getBlock() == Blocks.lava) {
                                        llllllllllllllIllIllIlllIIIlllIl = true;
                                    }
                                    if (llllllllllllllIllIllIlllIIIllIlI != llllllllllllllIllIllIlllIIlIIIIl - 1 && llllllllllllllIllIllIlllIIIlllII != llllllllllllllIllIllIlllIIlIIIll && llllllllllllllIllIllIlllIIIlllII != llllllllllllllIllIllIlllIIlIIIlI - 1 && llllllllllllllIllIllIlllIIIllIll != llllllllllllllIllIllIlllIIIlllll && llllllllllllllIllIllIlllIIIllIll != llllllllllllllIllIllIlllIIIllllI - 1) {
                                        llllllllllllllIllIllIlllIIIllIlI = llllllllllllllIllIllIlllIIlIIIIl;
                                    }
                                }
                            }
                        }
                    }
                    if (!llllllllllllllIllIllIlllIIIlllIl) {
                        for (int llllllllllllllIllIllIlllIIIlllII = llllllllllllllIllIllIlllIIlIIIll; llllllllllllllIllIllIlllIIIlllII < llllllllllllllIllIllIlllIIlIIIlI; ++llllllllllllllIllIllIlllIIIlllII) {
                            final double llllllllllllllIllIllIlllIIIllIII = (llllllllllllllIllIllIlllIIIlllII + llllllllllllllIllIllIlllIlIIIIII * 16 + 0.5 - llllllllllllllIllIllIlllIIIIllIl) / llllllllllllllIllIllIlllIIlIlIll;
                            for (int llllllllllllllIllIllIlllIIIlIlll = llllllllllllllIllIllIlllIIIlllll; llllllllllllllIllIllIlllIIIlIlll < llllllllllllllIllIllIlllIIIllllI; ++llllllllllllllIllIllIlllIIIlIlll) {
                                final double llllllllllllllIllIllIlllIIIlIllI = (double)((llllllllllllllIllIllIlllIIIlIlll + llllllllllllllIllIllIlllIIllllll * 16 + 0.5 - llllllllllllllIllIllIlllIIIIlIll) / llllllllllllllIllIllIlllIIlIlIll);
                                for (int llllllllllllllIllIllIlllIIIlIlIl = llllllllllllllIllIllIlllIIlIIIII; llllllllllllllIllIllIlllIIIlIlIl > llllllllllllllIllIllIlllIIlIIIIl; --llllllllllllllIllIllIlllIIIlIlIl) {
                                    final double llllllllllllllIllIllIlllIIIlIlII = (double)((llllllllllllllIllIllIlllIIIlIlIl - 1 + 0.5 - llllllllllllllIllIllIlllIIIIllII) / llllllllllllllIllIllIlllIIlIlIlI);
                                    if (llllllllllllllIllIllIlllIIIlIlII > -0.7 && llllllllllllllIllIllIlllIIIllIII * llllllllllllllIllIllIlllIIIllIII + llllllllllllllIllIllIlllIIIlIlII * llllllllllllllIllIllIlllIIIlIlII + llllllllllllllIllIllIlllIIIlIllI * llllllllllllllIllIllIlllIIIlIllI < 1.0) {
                                        final IBlockState llllllllllllllIllIllIlllIIIlIIll = llllllllllllllIllIllIlllIIIIlllI.getBlockState(llllllllllllllIllIllIlllIIIlllII, llllllllllllllIllIllIlllIIIlIlIl, llllllllllllllIllIllIlllIIIlIlll);
                                        if (llllllllllllllIllIllIlllIIIlIIll.getBlock() == Blocks.netherrack || llllllllllllllIllIllIlllIIIlIIll.getBlock() == Blocks.dirt || llllllllllllllIllIllIlllIIIlIIll.getBlock() == Blocks.grass) {
                                            llllllllllllllIllIllIlllIIIIlllI.setBlockState(llllllllllllllIllIllIlllIIIlllII, llllllllllllllIllIllIlllIIIlIlIl, llllllllllllllIllIllIlllIIIlIlll, Blocks.air.getDefaultState());
                                        }
                                    }
                                }
                            }
                        }
                        if (llllllllllllllIllIllIlllIIlIlllI) {
                            break;
                        }
                    }
                }
            }
            ++llllllllllllllIllIllIlllIIIIIlll;
        }
    }
    
    protected void func_180705_a(final long llllllllllllllIllIllIlllIlllIllI, final int llllllllllllllIllIllIlllIlllllIl, final int llllllllllllllIllIllIlllIlllllII, final ChunkPrimer llllllllllllllIllIllIlllIllllIll, final double llllllllllllllIllIllIlllIlllIIlI, final double llllllllllllllIllIllIlllIlllIIIl, final double llllllllllllllIllIllIlllIlllIIII) {
        this.func_180704_a(llllllllllllllIllIllIlllIlllIllI, llllllllllllllIllIllIlllIlllllIl, llllllllllllllIllIllIlllIlllllII, llllllllllllllIllIllIlllIllllIll, llllllllllllllIllIllIlllIlllIIlI, llllllllllllllIllIllIlllIlllIIIl, llllllllllllllIllIllIlllIlllIIII, 1.0f + this.rand.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
    
    @Override
    protected void func_180701_a(final World llllllllllllllIllIllIllIllIlIlII, final int llllllllllllllIllIllIllIllIIIIll, final int llllllllllllllIllIllIllIllIlIIlI, final int llllllllllllllIllIllIllIllIIIIIl, final int llllllllllllllIllIllIllIllIIIIII, final ChunkPrimer llllllllllllllIllIllIllIlIllllll) {
        int llllllllllllllIllIllIllIllIIlllI = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(10) + 1) + 1);
        if (this.rand.nextInt(5) != 0) {
            llllllllllllllIllIllIllIllIIlllI = 0;
        }
        for (int llllllllllllllIllIllIllIllIIllIl = 0; llllllllllllllIllIllIllIllIIllIl < llllllllllllllIllIllIllIllIIlllI; ++llllllllllllllIllIllIllIllIIllIl) {
            final double llllllllllllllIllIllIllIllIIllII = llllllllllllllIllIllIllIllIIIIll * 16 + this.rand.nextInt(16);
            final double llllllllllllllIllIllIllIllIIlIll = this.rand.nextInt(128);
            final double llllllllllllllIllIllIllIllIIlIlI = llllllllllllllIllIllIllIllIlIIlI * 16 + this.rand.nextInt(16);
            int llllllllllllllIllIllIllIllIIlIIl = 1;
            if (this.rand.nextInt(4) == 0) {
                this.func_180705_a(this.rand.nextLong(), llllllllllllllIllIllIllIllIIIIIl, llllllllllllllIllIllIllIllIIIIII, llllllllllllllIllIllIllIlIllllll, llllllllllllllIllIllIllIllIIllII, llllllllllllllIllIllIllIllIIlIll, llllllllllllllIllIllIllIllIIlIlI);
                llllllllllllllIllIllIllIllIIlIIl += this.rand.nextInt(4);
            }
            for (int llllllllllllllIllIllIllIllIIlIII = 0; llllllllllllllIllIllIllIllIIlIII < llllllllllllllIllIllIllIllIIlIIl; ++llllllllllllllIllIllIllIllIIlIII) {
                final float llllllllllllllIllIllIllIllIIIlll = this.rand.nextFloat() * 3.1415927f * 2.0f;
                final float llllllllllllllIllIllIllIllIIIllI = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                final float llllllllllllllIllIllIllIllIIIlIl = this.rand.nextFloat() * 2.0f + this.rand.nextFloat();
                this.func_180704_a(this.rand.nextLong(), llllllllllllllIllIllIllIllIIIIIl, llllllllllllllIllIllIllIllIIIIII, llllllllllllllIllIllIllIlIllllll, llllllllllllllIllIllIllIllIIllII, llllllllllllllIllIllIllIllIIlIll, llllllllllllllIllIllIllIllIIlIlI, llllllllllllllIllIllIllIllIIIlIl * 2.0f, llllllllllllllIllIllIllIllIIIlll, llllllllllllllIllIllIllIllIIIllI, 0, 0, 0.5);
            }
        }
    }
}
