package net.minecraft.world.gen;

import net.minecraft.world.chunk.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import java.util.*;
import com.google.common.base.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;

public class MapGenCaves extends MapGenBase
{
    static {
        __OBFID = "CL_00000393";
    }
    
    protected void func_180703_a(final long llllllllllllllIIlIlllIIIlIIlIlII, final int llllllllllllllIIlIlllIIIlIIlIIll, final int llllllllllllllIIlIlllIIIlIIIlIlI, final ChunkPrimer llllllllllllllIIlIlllIIIlIIIlIIl, final double llllllllllllllIIlIlllIIIlIIIlIII, final double llllllllllllllIIlIlllIIIlIIIllll, final double llllllllllllllIIlIlllIIIlIIIlllI) {
        this.func_180702_a(llllllllllllllIIlIlllIIIlIIlIlII, llllllllllllllIIlIlllIIIlIIlIIll, llllllllllllllIIlIlllIIIlIIIlIlI, llllllllllllllIIlIlllIIIlIIIlIIl, llllllllllllllIIlIlllIIIlIIIlIII, llllllllllllllIIlIlllIIIlIIIllll, llllllllllllllIIlIlllIIIlIIIlllI, 1.0f + this.rand.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
    
    protected boolean func_175793_a(final IBlockState llllllllllllllIIlIllIlllllllIIlI, final IBlockState llllllllllllllIIlIllIlllllllIIIl) {
        return llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.stone || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.dirt || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.grass || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.hardened_clay || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.stained_hardened_clay || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.sandstone || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.red_sandstone || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.mycelium || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.snow_layer || ((llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.sand || llllllllllllllIIlIllIlllllllIIlI.getBlock() == Blocks.gravel) && llllllllllllllIIlIllIlllllllIIIl.getBlock().getMaterial() != Material.water);
    }
    
    @Override
    protected void func_180701_a(final World llllllllllllllIIlIllIlllllIlllIl, final int llllllllllllllIIlIllIlllllIlllII, final int llllllllllllllIIlIllIlllllIllIll, final int llllllllllllllIIlIllIlllllIIlIlI, final int llllllllllllllIIlIllIlllllIIlIIl, final ChunkPrimer llllllllllllllIIlIllIlllllIllIII) {
        int llllllllllllllIIlIllIlllllIlIlll = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
        if (this.rand.nextInt(7) != 0) {
            llllllllllllllIIlIllIlllllIlIlll = 0;
        }
        for (int llllllllllllllIIlIllIlllllIlIllI = 0; llllllllllllllIIlIllIlllllIlIllI < llllllllllllllIIlIllIlllllIlIlll; ++llllllllllllllIIlIllIlllllIlIllI) {
            final double llllllllllllllIIlIllIlllllIlIlIl = llllllllllllllIIlIllIlllllIlllII * 16 + this.rand.nextInt(16);
            final double llllllllllllllIIlIllIlllllIlIlII = this.rand.nextInt(this.rand.nextInt(120) + 8);
            final double llllllllllllllIIlIllIlllllIlIIll = llllllllllllllIIlIllIlllllIllIll * 16 + this.rand.nextInt(16);
            int llllllllllllllIIlIllIlllllIlIIlI = 1;
            if (this.rand.nextInt(4) == 0) {
                this.func_180703_a(this.rand.nextLong(), llllllllllllllIIlIllIlllllIIlIlI, llllllllllllllIIlIllIlllllIIlIIl, llllllllllllllIIlIllIlllllIllIII, llllllllllllllIIlIllIlllllIlIlIl, llllllllllllllIIlIllIlllllIlIlII, llllllllllllllIIlIllIlllllIlIIll);
                llllllllllllllIIlIllIlllllIlIIlI += this.rand.nextInt(4);
            }
            for (int llllllllllllllIIlIllIlllllIlIIIl = 0; llllllllllllllIIlIllIlllllIlIIIl < llllllllllllllIIlIllIlllllIlIIlI; ++llllllllllllllIIlIllIlllllIlIIIl) {
                final float llllllllllllllIIlIllIlllllIlIIII = this.rand.nextFloat() * 3.1415927f * 2.0f;
                final float llllllllllllllIIlIllIlllllIIllll = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float llllllllllllllIIlIllIlllllIIlllI = this.rand.nextFloat() * 2.0f + this.rand.nextFloat();
                if (this.rand.nextInt(10) == 0) {
                    llllllllllllllIIlIllIlllllIIlllI *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0f + 1.0f;
                }
                this.func_180702_a(this.rand.nextLong(), llllllllllllllIIlIllIlllllIIlIlI, llllllllllllllIIlIllIlllllIIlIIl, llllllllllllllIIlIllIlllllIllIII, llllllllllllllIIlIllIlllllIlIlIl, llllllllllllllIIlIllIlllllIlIlII, llllllllllllllIIlIllIlllllIlIIll, llllllllllllllIIlIllIlllllIIlllI, llllllllllllllIIlIllIlllllIlIIII, llllllllllllllIIlIllIlllllIIllll, 0, 0, 1.0);
            }
        }
    }
    
    protected void func_180702_a(final long llllllllllllllIIlIlllIIIIlIlIlIl, final int llllllllllllllIIlIlllIIIIIlIIIlI, final int llllllllllllllIIlIlllIIIIIlIIIIl, final ChunkPrimer llllllllllllllIIlIlllIIIIIlIIIII, double llllllllllllllIIlIlllIIIIIIlllll, double llllllllllllllIIlIlllIIIIIIllllI, double llllllllllllllIIlIlllIIIIIIlllIl, final float llllllllllllllIIlIlllIIIIIIlllII, float llllllllllllllIIlIlllIIIIIIllIll, float llllllllllllllIIlIlllIIIIIIllIlI, int llllllllllllllIIlIlllIIIIIIllIIl, int llllllllllllllIIlIlllIIIIlIIlIlI, final double llllllllllllllIIlIlllIIIIlIIlIIl) {
        final double llllllllllllllIIlIlllIIIIlIIlIII = llllllllllllllIIlIlllIIIIIlIIIlI * 16 + 8;
        final double llllllllllllllIIlIlllIIIIlIIIlll = llllllllllllllIIlIlllIIIIIlIIIIl * 16 + 8;
        float llllllllllllllIIlIlllIIIIlIIIllI = 0.0f;
        float llllllllllllllIIlIlllIIIIlIIIlIl = 0.0f;
        final Random llllllllllllllIIlIlllIIIIlIIIlII = new Random(llllllllllllllIIlIlllIIIIlIlIlIl);
        if (llllllllllllllIIlIlllIIIIlIIlIlI <= 0) {
            final int llllllllllllllIIlIlllIIIIlIIIIll = this.range * 16 - 16;
            llllllllllllllIIlIlllIIIIlIIlIlI = llllllllllllllIIlIlllIIIIlIIIIll - llllllllllllllIIlIlllIIIIlIIIlII.nextInt(llllllllllllllIIlIlllIIIIlIIIIll / 4);
        }
        boolean llllllllllllllIIlIlllIIIIlIIIIlI = false;
        if (llllllllllllllIIlIlllIIIIIIllIIl == -1) {
            llllllllllllllIIlIlllIIIIIIllIIl = llllllllllllllIIlIlllIIIIlIIlIlI / 2;
            llllllllllllllIIlIlllIIIIlIIIIlI = true;
        }
        final int llllllllllllllIIlIlllIIIIlIIIIIl = llllllllllllllIIlIlllIIIIlIIIlII.nextInt(llllllllllllllIIlIlllIIIIlIIlIlI / 2) + llllllllllllllIIlIlllIIIIlIIlIlI / 4;
        final boolean llllllllllllllIIlIlllIIIIlIIIIII = llllllllllllllIIlIlllIIIIlIIIlII.nextInt(6) == 0;
        while (llllllllllllllIIlIlllIIIIIIllIIl < llllllllllllllIIlIlllIIIIlIIlIlI) {
            final double llllllllllllllIIlIlllIIIIIllllll = 1.5 + MathHelper.sin(llllllllllllllIIlIlllIIIIIIllIIl * 3.1415927f / llllllllllllllIIlIlllIIIIlIIlIlI) * llllllllllllllIIlIlllIIIIIIlllII * 1.0f;
            final double llllllllllllllIIlIlllIIIIIlllllI = llllllllllllllIIlIlllIIIIIllllll * llllllllllllllIIlIlllIIIIlIIlIIl;
            final float llllllllllllllIIlIlllIIIIIllllIl = MathHelper.cos(llllllllllllllIIlIlllIIIIIIllIlI);
            final float llllllllllllllIIlIlllIIIIIllllII = MathHelper.sin(llllllllllllllIIlIlllIIIIIIllIlI);
            llllllllllllllIIlIlllIIIIIIlllll += MathHelper.cos(llllllllllllllIIlIlllIIIIIIllIll) * llllllllllllllIIlIlllIIIIIllllIl;
            llllllllllllllIIlIlllIIIIIIllllI += llllllllllllllIIlIlllIIIIIllllII;
            llllllllllllllIIlIlllIIIIIIlllIl += MathHelper.sin(llllllllllllllIIlIlllIIIIIIllIll) * llllllllllllllIIlIlllIIIIIllllIl;
            if (llllllllllllllIIlIlllIIIIlIIIIII) {
                llllllllllllllIIlIlllIIIIIIllIlI *= 0.92f;
            }
            else {
                llllllllllllllIIlIlllIIIIIIllIlI *= 0.7f;
            }
            llllllllllllllIIlIlllIIIIIIllIlI += llllllllllllllIIlIlllIIIIlIIIlIl * 0.1f;
            llllllllllllllIIlIlllIIIIIIllIll += llllllllllllllIIlIlllIIIIlIIIllI * 0.1f;
            llllllllllllllIIlIlllIIIIlIIIlIl *= 0.9f;
            llllllllllllllIIlIlllIIIIlIIIllI *= 0.75f;
            llllllllllllllIIlIlllIIIIlIIIlIl += (llllllllllllllIIlIlllIIIIlIIIlII.nextFloat() - llllllllllllllIIlIlllIIIIlIIIlII.nextFloat()) * llllllllllllllIIlIlllIIIIlIIIlII.nextFloat() * 2.0f;
            llllllllllllllIIlIlllIIIIlIIIllI += (llllllllllllllIIlIlllIIIIlIIIlII.nextFloat() - llllllllllllllIIlIlllIIIIlIIIlII.nextFloat()) * llllllllllllllIIlIlllIIIIlIIIlII.nextFloat() * 4.0f;
            if (!llllllllllllllIIlIlllIIIIlIIIIlI && llllllllllllllIIlIlllIIIIIIllIIl == llllllllllllllIIlIlllIIIIlIIIIIl && llllllllllllllIIlIlllIIIIIIlllII > 1.0f && llllllllllllllIIlIlllIIIIlIIlIlI > 0) {
                this.func_180702_a(llllllllllllllIIlIlllIIIIlIIIlII.nextLong(), llllllllllllllIIlIlllIIIIIlIIIlI, llllllllllllllIIlIlllIIIIIlIIIIl, llllllllllllllIIlIlllIIIIIlIIIII, llllllllllllllIIlIlllIIIIIIlllll, llllllllllllllIIlIlllIIIIIIllllI, llllllllllllllIIlIlllIIIIIIlllIl, llllllllllllllIIlIlllIIIIlIIIlII.nextFloat() * 0.5f + 0.5f, llllllllllllllIIlIlllIIIIIIllIll - 1.5707964f, llllllllllllllIIlIlllIIIIIIllIlI / 3.0f, llllllllllllllIIlIlllIIIIIIllIIl, llllllllllllllIIlIlllIIIIlIIlIlI, 1.0);
                this.func_180702_a(llllllllllllllIIlIlllIIIIlIIIlII.nextLong(), llllllllllllllIIlIlllIIIIIlIIIlI, llllllllllllllIIlIlllIIIIIlIIIIl, llllllllllllllIIlIlllIIIIIlIIIII, llllllllllllllIIlIlllIIIIIIlllll, llllllllllllllIIlIlllIIIIIIllllI, llllllllllllllIIlIlllIIIIIIlllIl, llllllllllllllIIlIlllIIIIlIIIlII.nextFloat() * 0.5f + 0.5f, llllllllllllllIIlIlllIIIIIIllIll + 1.5707964f, llllllllllllllIIlIlllIIIIIIllIlI / 3.0f, llllllllllllllIIlIlllIIIIIIllIIl, llllllllllllllIIlIlllIIIIlIIlIlI, 1.0);
                return;
            }
            if (llllllllllllllIIlIlllIIIIlIIIIlI || llllllllllllllIIlIlllIIIIlIIIlII.nextInt(4) != 0) {
                final double llllllllllllllIIlIlllIIIIIlllIll = llllllllllllllIIlIlllIIIIIIlllll - llllllllllllllIIlIlllIIIIlIIlIII;
                final double llllllllllllllIIlIlllIIIIIlllIlI = llllllllllllllIIlIlllIIIIIIlllIl - llllllllllllllIIlIlllIIIIlIIIlll;
                final double llllllllllllllIIlIlllIIIIIlllIIl = llllllllllllllIIlIlllIIIIlIIlIlI - llllllllllllllIIlIlllIIIIIIllIIl;
                final double llllllllllllllIIlIlllIIIIIlllIII = llllllllllllllIIlIlllIIIIIIlllII + 2.0f + 16.0f;
                if (llllllllllllllIIlIlllIIIIIlllIll * llllllllllllllIIlIlllIIIIIlllIll + llllllllllllllIIlIlllIIIIIlllIlI * llllllllllllllIIlIlllIIIIIlllIlI - llllllllllllllIIlIlllIIIIIlllIIl * llllllllllllllIIlIlllIIIIIlllIIl > llllllllllllllIIlIlllIIIIIlllIII * llllllllllllllIIlIlllIIIIIlllIII) {
                    return;
                }
                if (llllllllllllllIIlIlllIIIIIIlllll >= llllllllllllllIIlIlllIIIIlIIlIII - 16.0 - llllllllllllllIIlIlllIIIIIllllll * 2.0 && llllllllllllllIIlIlllIIIIIIlllIl >= llllllllllllllIIlIlllIIIIlIIIlll - 16.0 - llllllllllllllIIlIlllIIIIIllllll * 2.0 && llllllllllllllIIlIlllIIIIIIlllll <= llllllllllllllIIlIlllIIIIlIIlIII + 16.0 + llllllllllllllIIlIlllIIIIIllllll * 2.0 && llllllllllllllIIlIlllIIIIIIlllIl <= llllllllllllllIIlIlllIIIIlIIIlll + 16.0 + llllllllllllllIIlIlllIIIIIllllll * 2.0) {
                    int llllllllllllllIIlIlllIIIIIllIlll = MathHelper.floor_double(llllllllllllllIIlIlllIIIIIIlllll - llllllllllllllIIlIlllIIIIIllllll) - llllllllllllllIIlIlllIIIIIlIIIlI * 16 - 1;
                    int llllllllllllllIIlIlllIIIIIllIllI = MathHelper.floor_double(llllllllllllllIIlIlllIIIIIIlllll + llllllllllllllIIlIlllIIIIIllllll) - llllllllllllllIIlIlllIIIIIlIIIlI * 16 + 1;
                    int llllllllllllllIIlIlllIIIIIllIlIl = MathHelper.floor_double(llllllllllllllIIlIlllIIIIIIllllI - llllllllllllllIIlIlllIIIIIlllllI) - 1;
                    int llllllllllllllIIlIlllIIIIIllIlII = MathHelper.floor_double(llllllllllllllIIlIlllIIIIIIllllI + llllllllllllllIIlIlllIIIIIlllllI) + 1;
                    int llllllllllllllIIlIlllIIIIIllIIll = MathHelper.floor_double(llllllllllllllIIlIlllIIIIIIlllIl - llllllllllllllIIlIlllIIIIIllllll) - llllllllllllllIIlIlllIIIIIlIIIIl * 16 - 1;
                    int llllllllllllllIIlIlllIIIIIllIIlI = MathHelper.floor_double(llllllllllllllIIlIlllIIIIIIlllIl + llllllllllllllIIlIlllIIIIIllllll) - llllllllllllllIIlIlllIIIIIlIIIIl * 16 + 1;
                    if (llllllllllllllIIlIlllIIIIIllIlll < 0) {
                        llllllllllllllIIlIlllIIIIIllIlll = 0;
                    }
                    if (llllllllllllllIIlIlllIIIIIllIllI > 16) {
                        llllllllllllllIIlIlllIIIIIllIllI = 16;
                    }
                    if (llllllllllllllIIlIlllIIIIIllIlIl < 1) {
                        llllllllllllllIIlIlllIIIIIllIlIl = 1;
                    }
                    if (llllllllllllllIIlIlllIIIIIllIlII > 248) {
                        llllllllllllllIIlIlllIIIIIllIlII = 248;
                    }
                    if (llllllllllllllIIlIlllIIIIIllIIll < 0) {
                        llllllllllllllIIlIlllIIIIIllIIll = 0;
                    }
                    if (llllllllllllllIIlIlllIIIIIllIIlI > 16) {
                        llllllllllllllIIlIlllIIIIIllIIlI = 16;
                    }
                    boolean llllllllllllllIIlIlllIIIIIllIIIl = false;
                    for (int llllllllllllllIIlIlllIIIIIllIIII = llllllllllllllIIlIlllIIIIIllIlll; !llllllllllllllIIlIlllIIIIIllIIIl && llllllllllllllIIlIlllIIIIIllIIII < llllllllllllllIIlIlllIIIIIllIllI; ++llllllllllllllIIlIlllIIIIIllIIII) {
                        for (int llllllllllllllIIlIlllIIIIIlIllll = llllllllllllllIIlIlllIIIIIllIIll; !llllllllllllllIIlIlllIIIIIllIIIl && llllllllllllllIIlIlllIIIIIlIllll < llllllllllllllIIlIlllIIIIIllIIlI; ++llllllllllllllIIlIlllIIIIIlIllll) {
                            for (int llllllllllllllIIlIlllIIIIIlIlllI = llllllllllllllIIlIlllIIIIIllIlII + 1; !llllllllllllllIIlIlllIIIIIllIIIl && llllllllllllllIIlIlllIIIIIlIlllI >= llllllllllllllIIlIlllIIIIIllIlIl - 1; --llllllllllllllIIlIlllIIIIIlIlllI) {
                                if (llllllllllllllIIlIlllIIIIIlIlllI >= 0 && llllllllllllllIIlIlllIIIIIlIlllI < 256) {
                                    final IBlockState llllllllllllllIIlIlllIIIIIlIllIl = llllllllllllllIIlIlllIIIIIlIIIII.getBlockState(llllllllllllllIIlIlllIIIIIllIIII, llllllllllllllIIlIlllIIIIIlIlllI, llllllllllllllIIlIlllIIIIIlIllll);
                                    if (llllllllllllllIIlIlllIIIIIlIllIl.getBlock() == Blocks.flowing_water || llllllllllllllIIlIlllIIIIIlIllIl.getBlock() == Blocks.water) {
                                        llllllllllllllIIlIlllIIIIIllIIIl = true;
                                    }
                                    if (llllllllllllllIIlIlllIIIIIlIlllI != llllllllllllllIIlIlllIIIIIllIlIl - 1 && llllllllllllllIIlIlllIIIIIllIIII != llllllllllllllIIlIlllIIIIIllIlll && llllllllllllllIIlIlllIIIIIllIIII != llllllllllllllIIlIlllIIIIIllIllI - 1 && llllllllllllllIIlIlllIIIIIlIllll != llllllllllllllIIlIlllIIIIIllIIll && llllllllllllllIIlIlllIIIIIlIllll != llllllllllllllIIlIlllIIIIIllIIlI - 1) {
                                        llllllllllllllIIlIlllIIIIIlIlllI = llllllllllllllIIlIlllIIIIIllIlIl;
                                    }
                                }
                            }
                        }
                    }
                    if (!llllllllllllllIIlIlllIIIIIllIIIl) {
                        for (int llllllllllllllIIlIlllIIIIIllIIII = llllllllllllllIIlIlllIIIIIllIlll; llllllllllllllIIlIlllIIIIIllIIII < llllllllllllllIIlIlllIIIIIllIllI; ++llllllllllllllIIlIlllIIIIIllIIII) {
                            final double llllllllllllllIIlIlllIIIIIlIllII = (llllllllllllllIIlIlllIIIIIllIIII + llllllllllllllIIlIlllIIIIIlIIIlI * 16 + 0.5 - llllllllllllllIIlIlllIIIIIIlllll) / llllllllllllllIIlIlllIIIIIllllll;
                            for (int llllllllllllllIIlIlllIIIIIlIlIll = llllllllllllllIIlIlllIIIIIllIIll; llllllllllllllIIlIlllIIIIIlIlIll < llllllllllllllIIlIlllIIIIIllIIlI; ++llllllllllllllIIlIlllIIIIIlIlIll) {
                                final double llllllllllllllIIlIlllIIIIIlIlIlI = (llllllllllllllIIlIlllIIIIIlIlIll + llllllllllllllIIlIlllIIIIIlIIIIl * 16 + 0.5 - llllllllllllllIIlIlllIIIIIIlllIl) / llllllllllllllIIlIlllIIIIIllllll;
                                boolean llllllllllllllIIlIlllIIIIIlIlIIl = false;
                                if (llllllllllllllIIlIlllIIIIIlIllII * llllllllllllllIIlIlllIIIIIlIllII + llllllllllllllIIlIlllIIIIIlIlIlI * llllllllllllllIIlIlllIIIIIlIlIlI < 1.0) {
                                    for (int llllllllllllllIIlIlllIIIIIlIlIII = llllllllllllllIIlIlllIIIIIllIlII; llllllllllllllIIlIlllIIIIIlIlIII > llllllllllllllIIlIlllIIIIIllIlIl; --llllllllllllllIIlIlllIIIIIlIlIII) {
                                        final double llllllllllllllIIlIlllIIIIIlIIlll = (llllllllllllllIIlIlllIIIIIlIlIII - 1 + 0.5 - llllllllllllllIIlIlllIIIIIIllllI) / llllllllllllllIIlIlllIIIIIlllllI;
                                        if (llllllllllllllIIlIlllIIIIIlIIlll > -0.7 && llllllllllllllIIlIlllIIIIIlIllII * llllllllllllllIIlIlllIIIIIlIllII + llllllllllllllIIlIlllIIIIIlIIlll * llllllllllllllIIlIlllIIIIIlIIlll + llllllllllllllIIlIlllIIIIIlIlIlI * llllllllllllllIIlIlllIIIIIlIlIlI < 1.0) {
                                            final IBlockState llllllllllllllIIlIlllIIIIIlIIllI = llllllllllllllIIlIlllIIIIIlIIIII.getBlockState(llllllllllllllIIlIlllIIIIIllIIII, llllllllllllllIIlIlllIIIIIlIlIII, llllllllllllllIIlIlllIIIIIlIlIll);
                                            final IBlockState llllllllllllllIIlIlllIIIIIlIIlIl = (IBlockState)Objects.firstNonNull((Object)llllllllllllllIIlIlllIIIIIlIIIII.getBlockState(llllllllllllllIIlIlllIIIIIllIIII, llllllllllllllIIlIlllIIIIIlIlIII + 1, llllllllllllllIIlIlllIIIIIlIlIll), (Object)Blocks.air.getDefaultState());
                                            if (llllllllllllllIIlIlllIIIIIlIIllI.getBlock() == Blocks.grass || llllllllllllllIIlIlllIIIIIlIIllI.getBlock() == Blocks.mycelium) {
                                                llllllllllllllIIlIlllIIIIIlIlIIl = true;
                                            }
                                            if (this.func_175793_a(llllllllllllllIIlIlllIIIIIlIIllI, llllllllllllllIIlIlllIIIIIlIIlIl)) {
                                                if (llllllllllllllIIlIlllIIIIIlIlIII - 1 < 10) {
                                                    llllllllllllllIIlIlllIIIIIlIIIII.setBlockState(llllllllllllllIIlIlllIIIIIllIIII, llllllllllllllIIlIlllIIIIIlIlIII, llllllllllllllIIlIlllIIIIIlIlIll, Blocks.lava.getDefaultState());
                                                }
                                                else {
                                                    llllllllllllllIIlIlllIIIIIlIIIII.setBlockState(llllllllllllllIIlIlllIIIIIllIIII, llllllllllllllIIlIlllIIIIIlIlIII, llllllllllllllIIlIlllIIIIIlIlIll, Blocks.air.getDefaultState());
                                                    if (llllllllllllllIIlIlllIIIIIlIIlIl.getBlock() == Blocks.sand) {
                                                        llllllllllllllIIlIlllIIIIIlIIIII.setBlockState(llllllllllllllIIlIlllIIIIIllIIII, llllllllllllllIIlIlllIIIIIlIlIII + 1, llllllllllllllIIlIlllIIIIIlIlIll, (llllllllllllllIIlIlllIIIIIlIIlIl.getValue(BlockSand.VARIANT_PROP) == BlockSand.EnumType.RED_SAND) ? Blocks.red_sandstone.getDefaultState() : Blocks.sandstone.getDefaultState());
                                                    }
                                                    if (llllllllllllllIIlIlllIIIIIlIlIIl && llllllllllllllIIlIlllIIIIIlIIIII.getBlockState(llllllllllllllIIlIlllIIIIIllIIII, llllllllllllllIIlIlllIIIIIlIlIII - 1, llllllllllllllIIlIlllIIIIIlIlIll).getBlock() == Blocks.dirt) {
                                                        llllllllllllllIIlIlllIIIIIlIIIII.setBlockState(llllllllllllllIIlIlllIIIIIllIIII, llllllllllllllIIlIlllIIIIIlIlIII - 1, llllllllllllllIIlIlllIIIIIlIlIll, this.worldObj.getBiomeGenForCoords(new BlockPos(llllllllllllllIIlIlllIIIIIllIIII + llllllllllllllIIlIlllIIIIIlIIIlI * 16, 0, llllllllllllllIIlIlllIIIIIlIlIll + llllllllllllllIIlIlllIIIIIlIIIIl * 16)).topBlock.getBlock().getDefaultState());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (llllllllllllllIIlIlllIIIIlIIIIlI) {
                            break;
                        }
                    }
                }
            }
            ++llllllllllllllIIlIlllIIIIIIllIIl;
        }
    }
}
