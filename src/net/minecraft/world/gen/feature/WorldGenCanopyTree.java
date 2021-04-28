package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public class WorldGenCanopyTree extends WorldGenAbstractTree
{
    static {
        __OBFID = "CL_00000430";
    }
    
    private void func_150526_a(final World lllllllllllllllIlIIIIIllIIlIIIll, final int lllllllllllllllIlIIIIIllIIlIIIlI, final int lllllllllllllllIlIIIIIllIIlIIIIl, final int lllllllllllllllIlIIIIIllIIlIIIII) {
        final Block lllllllllllllllIlIIIIIllIIIlllll = lllllllllllllllIlIIIIIllIIlIIIll.getBlockState(new BlockPos(lllllllllllllllIlIIIIIllIIlIIIlI, lllllllllllllllIlIIIIIllIIlIIIIl, lllllllllllllllIlIIIIIllIIlIIIII)).getBlock();
        if (lllllllllllllllIlIIIIIllIIIlllll.getMaterial() == Material.air) {
            this.func_175905_a(lllllllllllllllIlIIIIIllIIlIIIll, new BlockPos(lllllllllllllllIlIIIIIllIIlIIIlI, lllllllllllllllIlIIIIIllIIlIIIIl, lllllllllllllllIlIIIIIllIIlIIIII), Blocks.leaves2, 1);
        }
    }
    
    public WorldGenCanopyTree(final boolean lllllllllllllllIlIIIIIllIllIllIl) {
        super(lllllllllllllllIlIIIIIllIllIllIl);
    }
    
    @Override
    public boolean generate(final World lllllllllllllllIlIIIIIllIIlllIll, final Random lllllllllllllllIlIIIIIllIIlllIlI, final BlockPos lllllllllllllllIlIIIIIllIIlllIIl) {
        final int lllllllllllllllIlIIIIIllIlIlIllI = lllllllllllllllIlIIIIIllIIlllIlI.nextInt(3) + lllllllllllllllIlIIIIIllIIlllIlI.nextInt(2) + 6;
        boolean lllllllllllllllIlIIIIIllIlIlIlIl = true;
        if (lllllllllllllllIlIIIIIllIIlllIIl.getY() < 1 || lllllllllllllllIlIIIIIllIIlllIIl.getY() + lllllllllllllllIlIIIIIllIlIlIllI + 1 > 256) {
            return false;
        }
        for (int lllllllllllllllIlIIIIIllIlIlIIII = lllllllllllllllIlIIIIIllIIlllIIl.getY(); lllllllllllllllIlIIIIIllIlIlIIII <= lllllllllllllllIlIIIIIllIIlllIIl.getY() + 1 + lllllllllllllllIlIIIIIllIlIlIllI; ++lllllllllllllllIlIIIIIllIlIlIIII) {
            byte lllllllllllllllIlIIIIIllIlIIllll = 1;
            if (lllllllllllllllIlIIIIIllIlIlIIII == lllllllllllllllIlIIIIIllIIlllIIl.getY()) {
                lllllllllllllllIlIIIIIllIlIIllll = 0;
            }
            if (lllllllllllllllIlIIIIIllIlIlIIII >= lllllllllllllllIlIIIIIllIIlllIIl.getY() + 1 + lllllllllllllllIlIIIIIllIlIlIllI - 2) {
                lllllllllllllllIlIIIIIllIlIIllll = 2;
            }
            for (int lllllllllllllllIlIIIIIllIlIlIlII = lllllllllllllllIlIIIIIllIIlllIIl.getX() - lllllllllllllllIlIIIIIllIlIIllll; lllllllllllllllIlIIIIIllIlIlIlII <= lllllllllllllllIlIIIIIllIIlllIIl.getX() + lllllllllllllllIlIIIIIllIlIIllll && lllllllllllllllIlIIIIIllIlIlIlIl; ++lllllllllllllllIlIIIIIllIlIlIlII) {
                for (int lllllllllllllllIlIIIIIllIlIlIIlI = lllllllllllllllIlIIIIIllIIlllIIl.getZ() - lllllllllllllllIlIIIIIllIlIIllll; lllllllllllllllIlIIIIIllIlIlIIlI <= lllllllllllllllIlIIIIIllIIlllIIl.getZ() + lllllllllllllllIlIIIIIllIlIIllll && lllllllllllllllIlIIIIIllIlIlIlIl; ++lllllllllllllllIlIIIIIllIlIlIIlI) {
                    if (lllllllllllllllIlIIIIIllIlIlIIII >= 0 && lllllllllllllllIlIIIIIllIlIlIIII < 256) {
                        if (!this.func_150523_a(lllllllllllllllIlIIIIIllIIlllIll.getBlockState(new BlockPos(lllllllllllllllIlIIIIIllIlIlIlII, lllllllllllllllIlIIIIIllIlIlIIII, lllllllllllllllIlIIIIIllIlIlIIlI)).getBlock())) {
                            lllllllllllllllIlIIIIIllIlIlIlIl = false;
                        }
                    }
                    else {
                        lllllllllllllllIlIIIIIllIlIlIlIl = false;
                    }
                }
            }
        }
        if (!lllllllllllllllIlIIIIIllIlIlIlIl) {
            return false;
        }
        final Block lllllllllllllllIlIIIIIllIlIIlllI = lllllllllllllllIlIIIIIllIIlllIll.getBlockState(lllllllllllllllIlIIIIIllIIlllIIl.offsetDown()).getBlock();
        if ((lllllllllllllllIlIIIIIllIlIIlllI == Blocks.grass || lllllllllllllllIlIIIIIllIlIIlllI == Blocks.dirt) && lllllllllllllllIlIIIIIllIIlllIIl.getY() < 256 - lllllllllllllllIlIIIIIllIlIlIllI - 1) {
            this.func_175921_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIIlllIIl.offsetDown());
            this.func_175921_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIIlllIIl.add(1, -1, 0));
            this.func_175921_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIIlllIIl.add(1, -1, 1));
            this.func_175921_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIIlllIIl.add(0, -1, 1));
            final EnumFacing lllllllllllllllIlIIIIIllIlIIllIl = EnumFacing.Plane.HORIZONTAL.random(lllllllllllllllIlIIIIIllIIlllIlI);
            final int lllllllllllllllIlIIIIIllIlIlIIll = lllllllllllllllIlIIIIIllIlIlIllI - lllllllllllllllIlIIIIIllIIlllIlI.nextInt(4);
            int lllllllllllllllIlIIIIIllIlIlIIIl = 2 - lllllllllllllllIlIIIIIllIIlllIlI.nextInt(3);
            int lllllllllllllllIlIIIIIllIlIIllII = lllllllllllllllIlIIIIIllIIlllIIl.getX();
            int lllllllllllllllIlIIIIIllIlIIlIll = lllllllllllllllIlIIIIIllIIlllIIl.getZ();
            int lllllllllllllllIlIIIIIllIlIIlIlI = 0;
            for (int lllllllllllllllIlIIIIIllIlIIlIIl = 0; lllllllllllllllIlIIIIIllIlIIlIIl < lllllllllllllllIlIIIIIllIlIlIllI; ++lllllllllllllllIlIIIIIllIlIIlIIl) {
                final int lllllllllllllllIlIIIIIllIlIIlIII = lllllllllllllllIlIIIIIllIIlllIIl.getY() + lllllllllllllllIlIIIIIllIlIIlIIl;
                if (lllllllllllllllIlIIIIIllIlIIlIIl >= lllllllllllllllIlIIIIIllIlIlIIll && lllllllllllllllIlIIIIIllIlIlIIIl > 0) {
                    lllllllllllllllIlIIIIIllIlIIllII += lllllllllllllllIlIIIIIllIlIIllIl.getFrontOffsetX();
                    lllllllllllllllIlIIIIIllIlIIlIll += lllllllllllllllIlIIIIIllIlIIllIl.getFrontOffsetZ();
                    --lllllllllllllllIlIIIIIllIlIlIIIl;
                }
                final BlockPos lllllllllllllllIlIIIIIllIlIIIlII = new BlockPos(lllllllllllllllIlIIIIIllIlIIllII, lllllllllllllllIlIIIIIllIlIIlIII, lllllllllllllllIlIIIIIllIlIIlIll);
                final Material lllllllllllllllIlIIIIIllIlIIIIll = lllllllllllllllIlIIIIIllIIlllIll.getBlockState(lllllllllllllllIlIIIIIllIlIIIlII).getBlock().getMaterial();
                if (lllllllllllllllIlIIIIIllIlIIIIll == Material.air || lllllllllllllllIlIIIIIllIlIIIIll == Material.leaves) {
                    this.func_175905_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIIlII, Blocks.log2, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                    this.func_175905_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIIlII.offsetEast(), Blocks.log2, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                    this.func_175905_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIIlII.offsetSouth(), Blocks.log2, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                    this.func_175905_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIIlII.offsetEast().offsetSouth(), Blocks.log2, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                    lllllllllllllllIlIIIIIllIlIIlIlI = lllllllllllllllIlIIIIIllIlIIlIII;
                }
            }
            for (int lllllllllllllllIlIIIIIllIlIIlIIl = -2; lllllllllllllllIlIIIIIllIlIIlIIl <= 0; ++lllllllllllllllIlIIIIIllIlIIlIIl) {
                for (int lllllllllllllllIlIIIIIllIlIIIlll = -2; lllllllllllllllIlIIIIIllIlIIIlll <= 0; ++lllllllllllllllIlIIIIIllIlIIIlll) {
                    final byte lllllllllllllllIlIIIIIllIlIIIIlI = -1;
                    this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI + lllllllllllllllIlIIIIIllIlIIIIlI, lllllllllllllllIlIIIIIllIlIIlIll + lllllllllllllllIlIIIIIllIlIIIlll);
                    this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, 1 + lllllllllllllllIlIIIIIllIlIIllII - lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI + lllllllllllllllIlIIIIIllIlIIIIlI, lllllllllllllllIlIIIIIllIlIIlIll + lllllllllllllllIlIIIIIllIlIIIlll);
                    this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI + lllllllllllllllIlIIIIIllIlIIIIlI, 1 + lllllllllllllllIlIIIIIllIlIIlIll - lllllllllllllllIlIIIIIllIlIIIlll);
                    this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, 1 + lllllllllllllllIlIIIIIllIlIIllII - lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI + lllllllllllllllIlIIIIIllIlIIIIlI, 1 + lllllllllllllllIlIIIIIllIlIIlIll - lllllllllllllllIlIIIIIllIlIIIlll);
                    if ((lllllllllllllllIlIIIIIllIlIIlIIl > -2 || lllllllllllllllIlIIIIIllIlIIIlll > -1) && (lllllllllllllllIlIIIIIllIlIIlIIl != -1 || lllllllllllllllIlIIIIIllIlIIIlll != -2)) {
                        final byte lllllllllllllllIlIIIIIllIlIIIIIl = 1;
                        this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI + lllllllllllllllIlIIIIIllIlIIIIIl, lllllllllllllllIlIIIIIllIlIIlIll + lllllllllllllllIlIIIIIllIlIIIlll);
                        this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, 1 + lllllllllllllllIlIIIIIllIlIIllII - lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI + lllllllllllllllIlIIIIIllIlIIIIIl, lllllllllllllllIlIIIIIllIlIIlIll + lllllllllllllllIlIIIIIllIlIIIlll);
                        this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI + lllllllllllllllIlIIIIIllIlIIIIIl, 1 + lllllllllllllllIlIIIIIllIlIIlIll - lllllllllllllllIlIIIIIllIlIIIlll);
                        this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, 1 + lllllllllllllllIlIIIIIllIlIIllII - lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI + lllllllllllllllIlIIIIIllIlIIIIIl, 1 + lllllllllllllllIlIIIIIllIlIIlIll - lllllllllllllllIlIIIIIllIlIIIlll);
                    }
                }
            }
            if (lllllllllllllllIlIIIIIllIIlllIlI.nextBoolean()) {
                this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII, lllllllllllllllIlIIIIIllIlIIlIlI + 2, lllllllllllllllIlIIIIIllIlIIlIll);
                this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + 1, lllllllllllllllIlIIIIIllIlIIlIlI + 2, lllllllllllllllIlIIIIIllIlIIlIll);
                this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + 1, lllllllllllllllIlIIIIIllIlIIlIlI + 2, lllllllllllllllIlIIIIIllIlIIlIll + 1);
                this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII, lllllllllllllllIlIIIIIllIlIIlIlI + 2, lllllllllllllllIlIIIIIllIlIIlIll + 1);
            }
            for (int lllllllllllllllIlIIIIIllIlIIlIIl = -3; lllllllllllllllIlIIIIIllIlIIlIIl <= 4; ++lllllllllllllllIlIIIIIllIlIIlIIl) {
                for (int lllllllllllllllIlIIIIIllIlIIIllI = -3; lllllllllllllllIlIIIIIllIlIIIllI <= 4; ++lllllllllllllllIlIIIIIllIlIIIllI) {
                    if ((lllllllllllllllIlIIIIIllIlIIlIIl != -3 || lllllllllllllllIlIIIIIllIlIIIllI != -3) && (lllllllllllllllIlIIIIIllIlIIlIIl != -3 || lllllllllllllllIlIIIIIllIlIIIllI != 4) && (lllllllllllllllIlIIIIIllIlIIlIIl != 4 || lllllllllllllllIlIIIIIllIlIIIllI != -3) && (lllllllllllllllIlIIIIIllIlIIlIIl != 4 || lllllllllllllllIlIIIIIllIlIIIllI != 4) && (Math.abs(lllllllllllllllIlIIIIIllIlIIlIIl) < 3 || Math.abs(lllllllllllllllIlIIIIIllIlIIIllI) < 3)) {
                        this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI, lllllllllllllllIlIIIIIllIlIIlIll + lllllllllllllllIlIIIIIllIlIIIllI);
                    }
                }
            }
            for (int lllllllllllllllIlIIIIIllIlIIlIIl = -1; lllllllllllllllIlIIIIIllIlIIlIIl <= 2; ++lllllllllllllllIlIIIIIllIlIIlIIl) {
                for (int lllllllllllllllIlIIIIIllIlIIIlIl = -1; lllllllllllllllIlIIIIIllIlIIIlIl <= 2; ++lllllllllllllllIlIIIIIllIlIIIlIl) {
                    if ((lllllllllllllllIlIIIIIllIlIIlIIl < 0 || lllllllllllllllIlIIIIIllIlIIlIIl > 1 || lllllllllllllllIlIIIIIllIlIIIlIl < 0 || lllllllllllllllIlIIIIIllIlIIIlIl > 1) && lllllllllllllllIlIIIIIllIIlllIlI.nextInt(3) <= 0) {
                        for (int lllllllllllllllIlIIIIIllIlIIIIII = lllllllllllllllIlIIIIIllIIlllIlI.nextInt(3) + 2, lllllllllllllllIlIIIIIllIIllllll = 0; lllllllllllllllIlIIIIIllIIllllll < lllllllllllllllIlIIIIIllIlIIIIII; ++lllllllllllllllIlIIIIIllIIllllll) {
                            this.func_175905_a(lllllllllllllllIlIIIIIllIIlllIll, new BlockPos(lllllllllllllllIlIIIIIllIIlllIIl.getX() + lllllllllllllllIlIIIIIllIlIIlIIl, lllllllllllllllIlIIIIIllIlIIlIlI - lllllllllllllllIlIIIIIllIIllllll - 1, lllllllllllllllIlIIIIIllIIlllIIl.getZ() + lllllllllllllllIlIIIIIllIlIIIlIl), Blocks.log2, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                        }
                        for (int lllllllllllllllIlIIIIIllIIllllll = -1; lllllllllllllllIlIIIIIllIIllllll <= 1; ++lllllllllllllllIlIIIIIllIIllllll) {
                            for (int lllllllllllllllIlIIIIIllIIlllllI = -1; lllllllllllllllIlIIIIIllIIlllllI <= 1; ++lllllllllllllllIlIIIIIllIIlllllI) {
                                this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + lllllllllllllllIlIIIIIllIlIIlIIl + lllllllllllllllIlIIIIIllIIllllll, lllllllllllllllIlIIIIIllIlIIlIlI - 0, lllllllllllllllIlIIIIIllIlIIlIll + lllllllllllllllIlIIIIIllIlIIIlIl + lllllllllllllllIlIIIIIllIIlllllI);
                            }
                        }
                        for (int lllllllllllllllIlIIIIIllIIllllll = -2; lllllllllllllllIlIIIIIllIIllllll <= 2; ++lllllllllllllllIlIIIIIllIIllllll) {
                            for (int lllllllllllllllIlIIIIIllIIllllIl = -2; lllllllllllllllIlIIIIIllIIllllIl <= 2; ++lllllllllllllllIlIIIIIllIIllllIl) {
                                if (Math.abs(lllllllllllllllIlIIIIIllIIllllll) != 2 || Math.abs(lllllllllllllllIlIIIIIllIIllllIl) != 2) {
                                    this.func_150526_a(lllllllllllllllIlIIIIIllIIlllIll, lllllllllllllllIlIIIIIllIlIIllII + lllllllllllllllIlIIIIIllIlIIlIIl + lllllllllllllllIlIIIIIllIIllllll, lllllllllllllllIlIIIIIllIlIIlIlI - 1, lllllllllllllllIlIIIIIllIlIIlIll + lllllllllllllllIlIIIIIllIlIIIlIl + lllllllllllllllIlIIIIIllIIllllIl);
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
