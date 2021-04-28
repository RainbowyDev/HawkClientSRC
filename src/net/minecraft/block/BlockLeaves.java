package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.world.biome.*;

public abstract class BlockLeaves extends BlockLeavesBase
{
    protected /* synthetic */ int field_150127_b;
    /* synthetic */ int[] field_150128_a;
    public static final /* synthetic */ PropertyBool field_176236_b;
    protected /* synthetic */ boolean field_176238_O;
    public static final /* synthetic */ PropertyBool field_176237_a;
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIllIlIIlllIlIIlIIl, final BlockPos llllllllllllllIllIlIIlllIlIIIIII, final IBlockState llllllllllllllIllIlIIlllIIllllll, final float llllllllllllllIllIlIIlllIlIIIllI, final int llllllllllllllIllIlIIlllIIlllllI) {
        if (!llllllllllllllIllIlIIlllIlIIlIIl.isRemote) {
            int llllllllllllllIllIlIIlllIlIIIlII = this.func_176232_d(llllllllllllllIllIlIIlllIIllllll);
            if (llllllllllllllIllIlIIlllIIlllllI > 0) {
                llllllllllllllIllIlIIlllIlIIIlII -= 2 << llllllllllllllIllIlIIlllIIlllllI;
                if (llllllllllllllIllIlIIlllIlIIIlII < 10) {
                    llllllllllllllIllIlIIlllIlIIIlII = 10;
                }
            }
            if (llllllllllllllIllIlIIlllIlIIlIIl.rand.nextInt(llllllllllllllIllIlIIlllIlIIIlII) == 0) {
                final Item llllllllllllllIllIlIIlllIlIIIIll = this.getItemDropped(llllllllllllllIllIlIIlllIIllllll, llllllllllllllIllIlIIlllIlIIlIIl.rand, llllllllllllllIllIlIIlllIIlllllI);
                Block.spawnAsEntity(llllllllllllllIllIlIIlllIlIIlIIl, llllllllllllllIllIlIIlllIlIIIIII, new ItemStack(llllllllllllllIllIlIIlllIlIIIIll, 1, this.damageDropped(llllllllllllllIllIlIIlllIIllllll)));
            }
            llllllllllllllIllIlIIlllIlIIIlII = 200;
            if (llllllllllllllIllIlIIlllIIlllllI > 0) {
                llllllllllllllIllIlIIlllIlIIIlII -= 10 << llllllllllllllIllIlIIlllIIlllllI;
                if (llllllllllllllIllIlIIlllIlIIIlII < 40) {
                    llllllllllllllIllIlIIlllIlIIIlII = 40;
                }
            }
            this.func_176234_a(llllllllllllllIllIlIIlllIlIIlIIl, llllllllllllllIllIlIIlllIlIIIIII, llllllllllllllIllIlIIlllIIllllll, llllllllllllllIllIlIIlllIlIIIlII);
        }
    }
    
    @Override
    public int getBlockColor() {
        return ColorizerFoliage.getFoliageColor(0.5, 1.0);
    }
    
    public void setGraphicsLevel(final boolean llllllllllllllIllIlIIlllIIlIlllI) {
        this.field_176238_O = llllllllllllllIllIlIIlllIIlIlllI;
        this.field_150121_P = llllllllllllllIllIlIIlllIIlIlllI;
        this.field_150127_b = (llllllllllllllIllIlIIlllIIlIlllI ? 0 : 1);
    }
    
    @Override
    public void updateTick(final World llllllllllllllIllIlIIllllIIIIlIl, final BlockPos llllllllllllllIllIlIIllllIIllIIl, final IBlockState llllllllllllllIllIlIIllllIIIIIll, final Random llllllllllllllIllIlIIllllIIlIlll) {
        if (!llllllllllllllIllIlIIllllIIIIlIl.isRemote && (boolean)llllllllllllllIllIlIIllllIIIIIll.getValue(BlockLeaves.field_176236_b) && (boolean)llllllllllllllIllIlIIllllIIIIIll.getValue(BlockLeaves.field_176237_a)) {
            final byte llllllllllllllIllIlIIllllIIlIllI = 4;
            final int llllllllllllllIllIlIIllllIIlIlIl = llllllllllllllIllIlIIllllIIlIllI + 1;
            final int llllllllllllllIllIlIIllllIIlIlII = llllllllllllllIllIlIIllllIIllIIl.getX();
            final int llllllllllllllIllIlIIllllIIlIIll = llllllllllllllIllIlIIllllIIllIIl.getY();
            final int llllllllllllllIllIlIIllllIIlIIlI = llllllllllllllIllIlIIllllIIllIIl.getZ();
            final byte llllllllllllllIllIlIIllllIIlIIIl = 32;
            final int llllllllllllllIllIlIIllllIIlIIII = llllllllllllllIllIlIIllllIIlIIIl * llllllllllllllIllIlIIllllIIlIIIl;
            final int llllllllllllllIllIlIIllllIIIllll = llllllllllllllIllIlIIllllIIlIIIl / 2;
            if (this.field_150128_a == null) {
                this.field_150128_a = new int[llllllllllllllIllIlIIllllIIlIIIl * llllllllllllllIllIlIIllllIIlIIIl * llllllllllllllIllIlIIllllIIlIIIl];
            }
            if (llllllllllllllIllIlIIllllIIIIlIl.isAreaLoaded(new BlockPos(llllllllllllllIllIlIIllllIIlIlII - llllllllllllllIllIlIIllllIIlIlIl, llllllllllllllIllIlIIllllIIlIIll - llllllllllllllIllIlIIllllIIlIlIl, llllllllllllllIllIlIIllllIIlIIlI - llllllllllllllIllIlIIllllIIlIlIl), new BlockPos(llllllllllllllIllIlIIllllIIlIlII + llllllllllllllIllIlIIllllIIlIlIl, llllllllllllllIllIlIIllllIIlIIll + llllllllllllllIllIlIIllllIIlIlIl, llllllllllllllIllIlIIllllIIlIIlI + llllllllllllllIllIlIIllllIIlIlIl))) {
                for (int llllllllllllllIllIlIIllllIIIlllI = -llllllllllllllIllIlIIllllIIlIllI; llllllllllllllIllIlIIllllIIIlllI <= llllllllllllllIllIlIIllllIIlIllI; ++llllllllllllllIllIlIIllllIIIlllI) {
                    for (int llllllllllllllIllIlIIllllIIIllII = -llllllllllllllIllIlIIllllIIlIllI; llllllllllllllIllIlIIllllIIIllII <= llllllllllllllIllIlIIllllIIlIllI; ++llllllllllllllIllIlIIllllIIIllII) {
                        for (int llllllllllllllIllIlIIllllIIIlIlI = -llllllllllllllIllIlIIllllIIlIllI; llllllllllllllIllIlIIllllIIIlIlI <= llllllllllllllIllIlIIllllIIlIllI; ++llllllllllllllIllIlIIllllIIIlIlI) {
                            final Block llllllllllllllIllIlIIllllIIIlIII = llllllllllllllIllIlIIllllIIIIlIl.getBlockState(new BlockPos(llllllllllllllIllIlIIllllIIlIlII + llllllllllllllIllIlIIllllIIIlllI, llllllllllllllIllIlIIllllIIlIIll + llllllllllllllIllIlIIllllIIIllII, llllllllllllllIllIlIIllllIIlIIlI + llllllllllllllIllIlIIllllIIIlIlI)).getBlock();
                            if (llllllllllllllIllIlIIllllIIIlIII != Blocks.log && llllllllllllllIllIlIIllllIIIlIII != Blocks.log2) {
                                if (llllllllllllllIllIlIIllllIIIlIII.getMaterial() == Material.leaves) {
                                    this.field_150128_a[(llllllllllllllIllIlIIllllIIIlllI + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIllII + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIlIlI + llllllllllllllIllIlIIllllIIIllll] = -2;
                                }
                                else {
                                    this.field_150128_a[(llllllllllllllIllIlIIllllIIIlllI + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIllII + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIlIlI + llllllllllllllIllIlIIllllIIIllll] = -1;
                                }
                            }
                            else {
                                this.field_150128_a[(llllllllllllllIllIlIIllllIIIlllI + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIllII + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIlIlI + llllllllllllllIllIlIIllllIIIllll] = 0;
                            }
                        }
                    }
                }
                for (int llllllllllllllIllIlIIllllIIIlllI = 1; llllllllllllllIllIlIIllllIIIlllI <= 4; ++llllllllllllllIllIlIIllllIIIlllI) {
                    for (int llllllllllllllIllIlIIllllIIIlIll = -llllllllllllllIllIlIIllllIIlIllI; llllllllllllllIllIlIIllllIIIlIll <= llllllllllllllIllIlIIllllIIlIllI; ++llllllllllllllIllIlIIllllIIIlIll) {
                        for (int llllllllllllllIllIlIIllllIIIlIIl = -llllllllllllllIllIlIIllllIIlIllI; llllllllllllllIllIlIIllllIIIlIIl <= llllllllllllllIllIlIIllllIIlIllI; ++llllllllllllllIllIlIIllllIIIlIIl) {
                            for (int llllllllllllllIllIlIIllllIIIIlll = -llllllllllllllIllIlIIllllIIlIllI; llllllllllllllIllIlIIllllIIIIlll <= llllllllllllllIllIlIIllllIIlIllI; ++llllllllllllllIllIlIIllllIIIIlll) {
                                if (this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] == llllllllllllllIllIlIIllllIIIlllI - 1) {
                                    if (this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll - 1) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] == -2) {
                                        this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll - 1) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] = llllllllllllllIllIlIIllllIIIlllI;
                                    }
                                    if (this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll + 1) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] == -2) {
                                        this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll + 1) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] = llllllllllllllIllIlIIllllIIIlllI;
                                    }
                                    if (this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll - 1) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] == -2) {
                                        this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll - 1) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] = llllllllllllllIllIlIIllllIIIlllI;
                                    }
                                    if (this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll + 1) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] == -2) {
                                        this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll + 1) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll] = llllllllllllllIllIlIIllllIIIlllI;
                                    }
                                    if (this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + (llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll - 1)] == -2) {
                                        this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + (llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll - 1)] = llllllllllllllIllIlIIllllIIIlllI;
                                    }
                                    if (this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll + 1] == -2) {
                                        this.field_150128_a[(llllllllllllllIllIlIIllllIIIlIll + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIII + (llllllllllllllIllIlIIllllIIIlIIl + llllllllllllllIllIlIIllllIIIllll) * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIIlll + llllllllllllllIllIlIIllllIIIllll + 1] = llllllllllllllIllIlIIllllIIIlllI;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final int llllllllllllllIllIlIIllllIIIllIl = this.field_150128_a[llllllllllllllIllIlIIllllIIIllll * llllllllllllllIllIlIIllllIIlIIII + llllllllllllllIllIlIIllllIIIllll * llllllllllllllIllIlIIllllIIlIIIl + llllllllllllllIllIlIIllllIIIllll];
            if (llllllllllllllIllIlIIllllIIIllIl >= 0) {
                llllllllllllllIllIlIIllllIIIIlIl.setBlockState(llllllllllllllIllIlIIllllIIllIIl, llllllllllllllIllIlIIllllIIIIIll.withProperty(BlockLeaves.field_176236_b, false), 4);
            }
            else {
                this.func_176235_d(llllllllllllllIllIlIIllllIIIIlIl, llllllllllllllIllIlIIllllIIllIIl);
            }
        }
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIllIlIIllllIllIlll, final BlockPos llllllllllllllIllIlIIlllllIIIIll, final IBlockState llllllllllllllIllIlIIlllllIIIIlI) {
        final byte llllllllllllllIllIlIIlllllIIIIIl = 1;
        final int llllllllllllllIllIlIIlllllIIIIII = llllllllllllllIllIlIIlllllIIIIIl + 1;
        final int llllllllllllllIllIlIIllllIllllll = llllllllllllllIllIlIIlllllIIIIll.getX();
        final int llllllllllllllIllIlIIllllIlllllI = llllllllllllllIllIlIIlllllIIIIll.getY();
        final int llllllllllllllIllIlIIllllIllllIl = llllllllllllllIllIlIIlllllIIIIll.getZ();
        if (llllllllllllllIllIlIIllllIllIlll.isAreaLoaded(new BlockPos(llllllllllllllIllIlIIllllIllllll - llllllllllllllIllIlIIlllllIIIIII, llllllllllllllIllIlIIllllIlllllI - llllllllllllllIllIlIIlllllIIIIII, llllllllllllllIllIlIIllllIllllIl - llllllllllllllIllIlIIlllllIIIIII), new BlockPos(llllllllllllllIllIlIIllllIllllll + llllllllllllllIllIlIIlllllIIIIII, llllllllllllllIllIlIIllllIlllllI + llllllllllllllIllIlIIlllllIIIIII, llllllllllllllIllIlIIllllIllllIl + llllllllllllllIllIlIIlllllIIIIII))) {
            for (int llllllllllllllIllIlIIllllIllllII = -llllllllllllllIllIlIIlllllIIIIIl; llllllllllllllIllIlIIllllIllllII <= llllllllllllllIllIlIIlllllIIIIIl; ++llllllllllllllIllIlIIllllIllllII) {
                for (int llllllllllllllIllIlIIllllIlllIll = -llllllllllllllIllIlIIlllllIIIIIl; llllllllllllllIllIlIIllllIlllIll <= llllllllllllllIllIlIIlllllIIIIIl; ++llllllllllllllIllIlIIllllIlllIll) {
                    for (int llllllllllllllIllIlIIllllIlllIlI = -llllllllllllllIllIlIIlllllIIIIIl; llllllllllllllIllIlIIllllIlllIlI <= llllllllllllllIllIlIIlllllIIIIIl; ++llllllllllllllIllIlIIllllIlllIlI) {
                        final BlockPos llllllllllllllIllIlIIllllIlllIIl = llllllllllllllIllIlIIlllllIIIIll.add(llllllllllllllIllIlIIllllIllllII, llllllllllllllIllIlIIllllIlllIll, llllllllllllllIllIlIIllllIlllIlI);
                        final IBlockState llllllllllllllIllIlIIllllIlllIII = llllllllllllllIllIlIIllllIllIlll.getBlockState(llllllllllllllIllIlIIllllIlllIIl);
                        if (llllllllllllllIllIlIIllllIlllIII.getBlock().getMaterial() == Material.leaves && !(boolean)llllllllllllllIllIlIIllllIlllIII.getValue(BlockLeaves.field_176236_b)) {
                            llllllllllllllIllIlIIllllIllIlll.setBlockState(llllllllllllllIllIlIIllllIlllIIl, llllllllllllllIllIlIIllllIlllIII.withProperty(BlockLeaves.field_176236_b, true), 4);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void randomDisplayTick(final World llllllllllllllIllIlIIlllIllIllll, final BlockPos llllllllllllllIllIlIIlllIllIIlll, final IBlockState llllllllllllllIllIlIIlllIllIllIl, final Random llllllllllllllIllIlIIlllIllIllII) {
        if (llllllllllllllIllIlIIlllIllIllll.func_175727_C(llllllllllllllIllIlIIlllIllIIlll.offsetUp()) && !World.doesBlockHaveSolidTopSurface(llllllllllllllIllIlIIlllIllIllll, llllllllllllllIllIlIIlllIllIIlll.offsetDown()) && llllllllllllllIllIlIIlllIllIllII.nextInt(15) == 1) {
            final double llllllllllllllIllIlIIlllIllIlIll = llllllllllllllIllIlIIlllIllIIlll.getX() + llllllllllllllIllIlIIlllIllIllII.nextFloat();
            final double llllllllllllllIllIlIIlllIllIlIlI = llllllllllllllIllIlIIlllIllIIlll.getY() - 0.05;
            final double llllllllllllllIllIlIIlllIllIlIIl = llllllllllllllIllIlIIlllIllIIlll.getZ() + llllllllllllllIllIlIIlllIllIllII.nextFloat();
            llllllllllllllIllIlIIlllIllIllll.spawnParticle(EnumParticleTypes.DRIP_WATER, llllllllllllllIllIlIIlllIllIlIll, llllllllllllllIllIlIIlllIllIlIlI, llllllllllllllIllIlIIlllIllIlIIl, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    static {
        __OBFID = "CL_00000263";
        field_176237_a = PropertyBool.create("decayable");
        field_176236_b = PropertyBool.create("check_decay");
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIllIlIIlllIlIlIlll) {
        return (llllllllllllllIllIlIIlllIlIlIlll.nextInt(20) == 0) ? 1 : 0;
    }
    
    @Override
    public int getRenderColor(final IBlockState llllllllllllllIllIlIIlllllIllIlI) {
        return ColorizerFoliage.getFoliageColorBasic();
    }
    
    protected void func_176234_a(final World llllllllllllllIllIlIIlllIIlllIlI, final BlockPos llllllllllllllIllIlIIlllIIlllIIl, final IBlockState llllllllllllllIllIlIIlllIIlllIII, final int llllllllllllllIllIlIIlllIIllIlll) {
    }
    
    @Override
    public boolean isVisuallyOpaque() {
        return false;
    }
    
    public BlockLeaves() {
        super(Material.leaves, false);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHardness(0.2f);
        this.setLightOpacity(1);
        this.setStepSound(BlockLeaves.soundTypeGrass);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return !this.field_150121_P;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIllIlIIlllIlIlIlII, final Random llllllllllllllIllIlIIlllIlIlIIll, final int llllllllllllllIllIlIIlllIlIlIIlI) {
        return Item.getItemFromBlock(Blocks.sapling);
    }
    
    private void func_176235_d(final World llllllllllllllIllIlIIlllIlIllllI, final BlockPos llllllllllllllIllIlIIlllIlIllIlI) {
        this.dropBlockAsItem(llllllllllllllIllIlIIlllIlIllllI, llllllllllllllIllIlIIlllIlIllIlI, llllllllllllllIllIlIIlllIlIllllI.getBlockState(llllllllllllllIllIlIIlllIlIllIlI), 0);
        llllllllllllllIllIlIIlllIlIllllI.setBlockToAir(llllllllllllllIllIlIIlllIlIllIlI);
    }
    
    protected int func_176232_d(final IBlockState llllllllllllllIllIlIIlllIIllIlIl) {
        return 20;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return this.field_176238_O ? EnumWorldBlockLayer.CUTOUT_MIPPED : EnumWorldBlockLayer.SOLID;
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess llllllllllllllIllIlIIlllllIlIIll, final BlockPos llllllllllllllIllIlIIlllllIlIIlI, final int llllllllllllllIllIlIIlllllIlIlII) {
        return BiomeColorHelper.func_180287_b(llllllllllllllIllIlIIlllllIlIIll, llllllllllllllIllIlIIlllllIlIIlI);
    }
    
    public abstract BlockPlanks.EnumType func_176233_b(final int p0);
}
