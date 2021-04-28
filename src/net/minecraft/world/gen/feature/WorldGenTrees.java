package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class WorldGenTrees extends WorldGenAbstractTree
{
    private final /* synthetic */ int minTreeHeight;
    private final /* synthetic */ int metaLeaves;
    private final /* synthetic */ boolean vinesGrow;
    private final /* synthetic */ int metaWood;
    
    public WorldGenTrees(final boolean llllllllllllllIlIIllIlllIIIlIlll, final int llllllllllllllIlIIllIlllIIIlllII, final int llllllllllllllIlIIllIlllIIIllIll, final int llllllllllllllIlIIllIlllIIIlIlII, final boolean llllllllllllllIlIIllIlllIIIllIIl) {
        super(llllllllllllllIlIIllIlllIIIlIlll);
        this.minTreeHeight = llllllllllllllIlIIllIlllIIIlllII;
        this.metaWood = llllllllllllllIlIIllIlllIIIllIll;
        this.metaLeaves = llllllllllllllIlIIllIlllIIIlIlII;
        this.vinesGrow = llllllllllllllIlIIllIlllIIIllIIl;
    }
    
    private void func_175923_a(final World llllllllllllllIlIIllIllIlIlllllI, BlockPos llllllllllllllIlIIllIllIlIllllIl, final int llllllllllllllIlIIllIllIlIllllII) {
        this.func_175905_a(llllllllllllllIlIIllIllIlIlllllI, llllllllllllllIlIIllIllIlIllllIl, Blocks.vine, llllllllllllllIlIIllIllIlIllllII);
        int llllllllllllllIlIIllIllIllIIIIII;
        for (llllllllllllllIlIIllIllIllIIIIII = 4, llllllllllllllIlIIllIllIlIllllIl = llllllllllllllIlIIllIllIlIllllIl.offsetDown(); llllllllllllllIlIIllIllIlIlllllI.getBlockState(llllllllllllllIlIIllIllIlIllllIl).getBlock().getMaterial() == Material.air && llllllllllllllIlIIllIllIllIIIIII > 0; llllllllllllllIlIIllIllIlIllllIl = llllllllllllllIlIIllIllIlIllllIl.offsetDown(), --llllllllllllllIlIIllIllIllIIIIII) {
            this.func_175905_a(llllllllllllllIlIIllIllIlIlllllI, llllllllllllllIlIIllIllIlIllllIl, Blocks.vine, llllllllllllllIlIIllIllIlIllllII);
        }
    }
    
    public WorldGenTrees(final boolean llllllllllllllIlIIllIlllIIlIIlll) {
        this(llllllllllllllIlIIllIlllIIlIIlll, 4, 0, 0, false);
    }
    
    @Override
    public boolean generate(final World llllllllllllllIlIIllIllIlllllllI, final Random llllllllllllllIlIIllIllIllIllIlI, final BlockPos llllllllllllllIlIIllIllIllIllIIl) {
        final int llllllllllllllIlIIllIllIlllllIll = llllllllllllllIlIIllIllIllIllIlI.nextInt(3) + this.minTreeHeight;
        boolean llllllllllllllIlIIllIllIlllllIlI = true;
        if (llllllllllllllIlIIllIllIllIllIIl.getY() < 1 || llllllllllllllIlIIllIllIllIllIIl.getY() + llllllllllllllIlIIllIllIlllllIll + 1 > 256) {
            return false;
        }
        for (int llllllllllllllIlIIllIllIllllIlIl = llllllllllllllIlIIllIllIllIllIIl.getY(); llllllllllllllIlIIllIllIllllIlIl <= llllllllllllllIlIIllIllIllIllIIl.getY() + 1 + llllllllllllllIlIIllIllIlllllIll; ++llllllllllllllIlIIllIllIllllIlIl) {
            byte llllllllllllllIlIIllIllIlllllIIl = 1;
            if (llllllllllllllIlIIllIllIllllIlIl == llllllllllllllIlIIllIllIllIllIIl.getY()) {
                llllllllllllllIlIIllIllIlllllIIl = 0;
            }
            if (llllllllllllllIlIIllIllIllllIlIl >= llllllllllllllIlIIllIllIllIllIIl.getY() + 1 + llllllllllllllIlIIllIllIlllllIll - 2) {
                llllllllllllllIlIIllIllIlllllIIl = 2;
            }
            for (int llllllllllllllIlIIllIllIllllIlII = llllllllllllllIlIIllIllIllIllIIl.getX() - llllllllllllllIlIIllIllIlllllIIl; llllllllllllllIlIIllIllIllllIlII <= llllllllllllllIlIIllIllIllIllIIl.getX() + llllllllllllllIlIIllIllIlllllIIl && llllllllllllllIlIIllIllIlllllIlI; ++llllllllllllllIlIIllIllIllllIlII) {
                for (int llllllllllllllIlIIllIllIllllIlll = llllllllllllllIlIIllIllIllIllIIl.getZ() - llllllllllllllIlIIllIllIlllllIIl; llllllllllllllIlIIllIllIllllIlll <= llllllllllllllIlIIllIllIllIllIIl.getZ() + llllllllllllllIlIIllIllIlllllIIl && llllllllllllllIlIIllIllIlllllIlI; ++llllllllllllllIlIIllIllIllllIlll) {
                    if (llllllllllllllIlIIllIllIllllIlIl >= 0 && llllllllllllllIlIIllIllIllllIlIl < 256) {
                        if (!this.func_150523_a(llllllllllllllIlIIllIllIlllllllI.getBlockState(new BlockPos(llllllllllllllIlIIllIllIllllIlII, llllllllllllllIlIIllIllIllllIlIl, llllllllllllllIlIIllIllIllllIlll)).getBlock())) {
                            llllllllllllllIlIIllIllIlllllIlI = false;
                        }
                    }
                    else {
                        llllllllllllllIlIIllIllIlllllIlI = false;
                    }
                }
            }
        }
        if (!llllllllllllllIlIIllIllIlllllIlI) {
            return false;
        }
        final Block llllllllllllllIlIIllIllIllllIIll = llllllllllllllIlIIllIllIlllllllI.getBlockState(llllllllllllllIlIIllIllIllIllIIl.offsetDown()).getBlock();
        if ((llllllllllllllIlIIllIllIllllIIll == Blocks.grass || llllllllllllllIlIIllIllIllllIIll == Blocks.dirt || llllllllllllllIlIIllIllIllllIIll == Blocks.farmland) && llllllllllllllIlIIllIllIllIllIIl.getY() < 256 - llllllllllllllIlIIllIllIlllllIll - 1) {
            this.func_175921_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIllIIl.offsetDown());
            final byte llllllllllllllIlIIllIllIlllllIII = 3;
            final byte llllllllllllllIlIIllIllIllllIIlI = 0;
            for (int llllllllllllllIlIIllIllIllllIllI = llllllllllllllIlIIllIllIllIllIIl.getY() - llllllllllllllIlIIllIllIlllllIII + llllllllllllllIlIIllIllIlllllIll; llllllllllllllIlIIllIllIllllIllI <= llllllllllllllIlIIllIllIllIllIIl.getY() + llllllllllllllIlIIllIllIlllllIll; ++llllllllllllllIlIIllIllIllllIllI) {
                final int llllllllllllllIlIIllIllIllllIIIl = llllllllllllllIlIIllIllIllllIllI - (llllllllllllllIlIIllIllIllIllIIl.getY() + llllllllllllllIlIIllIllIlllllIll);
                for (int llllllllllllllIlIIllIllIlllIlllI = llllllllllllllIlIIllIllIllllIIlI + 1 - llllllllllllllIlIIllIllIllllIIIl / 2, llllllllllllllIlIIllIllIlllIlIll = llllllllllllllIlIIllIllIllIllIIl.getX() - llllllllllllllIlIIllIllIlllIlllI; llllllllllllllIlIIllIllIlllIlIll <= llllllllllllllIlIIllIllIllIllIIl.getX() + llllllllllllllIlIIllIllIlllIlllI; ++llllllllllllllIlIIllIllIlllIlIll) {
                    final int llllllllllllllIlIIllIllIlllIlIIl = llllllllllllllIlIIllIllIlllIlIll - llllllllllllllIlIIllIllIllIllIIl.getX();
                    for (int llllllllllllllIlIIllIllIlllIIlIl = llllllllllllllIlIIllIllIllIllIIl.getZ() - llllllllllllllIlIIllIllIlllIlllI; llllllllllllllIlIIllIllIlllIIlIl <= llllllllllllllIlIIllIllIllIllIIl.getZ() + llllllllllllllIlIIllIllIlllIlllI; ++llllllllllllllIlIIllIllIlllIIlIl) {
                        final int llllllllllllllIlIIllIllIlllIIlII = llllllllllllllIlIIllIllIlllIIlIl - llllllllllllllIlIIllIllIllIllIIl.getZ();
                        if (Math.abs(llllllllllllllIlIIllIllIlllIlIIl) != llllllllllllllIlIIllIllIlllIlllI || Math.abs(llllllllllllllIlIIllIllIlllIIlII) != llllllllllllllIlIIllIllIlllIlllI || (llllllllllllllIlIIllIllIllIllIlI.nextInt(2) != 0 && llllllllllllllIlIIllIllIllllIIIl != 0)) {
                            final BlockPos llllllllllllllIlIIllIllIlllIIlll = new BlockPos(llllllllllllllIlIIllIllIlllIlIll, llllllllllllllIlIIllIllIllllIllI, llllllllllllllIlIIllIllIlllIIlIl);
                            final Block llllllllllllllIlIIllIllIlllIIIll = llllllllllllllIlIIllIllIlllllllI.getBlockState(llllllllllllllIlIIllIllIlllIIlll).getBlock();
                            if (llllllllllllllIlIIllIllIlllIIIll.getMaterial() == Material.air || llllllllllllllIlIIllIllIlllIIIll.getMaterial() == Material.leaves || llllllllllllllIlIIllIllIlllIIIll.getMaterial() == Material.vine) {
                                this.func_175905_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIlllIIlll, Blocks.leaves, this.metaLeaves);
                            }
                        }
                    }
                }
            }
            for (int llllllllllllllIlIIllIllIllllIllI = 0; llllllllllllllIlIIllIllIllllIllI < llllllllllllllIlIIllIllIlllllIll; ++llllllllllllllIlIIllIllIllllIllI) {
                final Block llllllllllllllIlIIllIllIlllIIIlI = llllllllllllllIlIIllIllIlllllllI.getBlockState(llllllllllllllIlIIllIllIllIllIIl.offsetUp(llllllllllllllIlIIllIllIllllIllI)).getBlock();
                if (llllllllllllllIlIIllIllIlllIIIlI.getMaterial() == Material.air || llllllllllllllIlIIllIllIlllIIIlI.getMaterial() == Material.leaves || llllllllllllllIlIIllIllIlllIIIlI.getMaterial() == Material.vine) {
                    this.func_175905_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIllIIl.offsetUp(llllllllllllllIlIIllIllIllllIllI), Blocks.log, this.metaWood);
                    if (this.vinesGrow && llllllllllllllIlIIllIllIllllIllI > 0) {
                        if (llllllllllllllIlIIllIllIllIllIlI.nextInt(3) > 0 && llllllllllllllIlIIllIllIlllllllI.isAirBlock(llllllllllllllIlIIllIllIllIllIIl.add(-1, llllllllllllllIlIIllIllIllllIllI, 0))) {
                            this.func_175905_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIllIIl.add(-1, llllllllllllllIlIIllIllIllllIllI, 0), Blocks.vine, BlockVine.field_176275_S);
                        }
                        if (llllllllllllllIlIIllIllIllIllIlI.nextInt(3) > 0 && llllllllllllllIlIIllIllIlllllllI.isAirBlock(llllllllllllllIlIIllIllIllIllIIl.add(1, llllllllllllllIlIIllIllIllllIllI, 0))) {
                            this.func_175905_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIllIIl.add(1, llllllllllllllIlIIllIllIllllIllI, 0), Blocks.vine, BlockVine.field_176271_T);
                        }
                        if (llllllllllllllIlIIllIllIllIllIlI.nextInt(3) > 0 && llllllllllllllIlIIllIllIlllllllI.isAirBlock(llllllllllllllIlIIllIllIllIllIIl.add(0, llllllllllllllIlIIllIllIllllIllI, -1))) {
                            this.func_175905_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIllIIl.add(0, llllllllllllllIlIIllIllIllllIllI, -1), Blocks.vine, BlockVine.field_176272_Q);
                        }
                        if (llllllllllllllIlIIllIllIllIllIlI.nextInt(3) > 0 && llllllllllllllIlIIllIllIlllllllI.isAirBlock(llllllllllllllIlIIllIllIllIllIIl.add(0, llllllllllllllIlIIllIllIllllIllI, 1))) {
                            this.func_175905_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIllIIl.add(0, llllllllllllllIlIIllIllIllllIllI, 1), Blocks.vine, BlockVine.field_176276_R);
                        }
                    }
                }
            }
            if (this.vinesGrow) {
                for (int llllllllllllllIlIIllIllIllllIllI = llllllllllllllIlIIllIllIllIllIIl.getY() - 3 + llllllllllllllIlIIllIllIlllllIll; llllllllllllllIlIIllIllIllllIllI <= llllllllllllllIlIIllIllIllIllIIl.getY() + llllllllllllllIlIIllIllIlllllIll; ++llllllllllllllIlIIllIllIllllIllI) {
                    final int llllllllllllllIlIIllIllIllllIIII = llllllllllllllIlIIllIllIllllIllI - (llllllllllllllIlIIllIllIllIllIIl.getY() + llllllllllllllIlIIllIllIlllllIll);
                    for (int llllllllllllllIlIIllIllIlllIllIl = 2 - llllllllllllllIlIIllIllIllllIIII / 2, llllllllllllllIlIIllIllIlllIlIlI = llllllllllllllIlIIllIllIllIllIIl.getX() - llllllllllllllIlIIllIllIlllIllIl; llllllllllllllIlIIllIllIlllIlIlI <= llllllllllllllIlIIllIllIllIllIIl.getX() + llllllllllllllIlIIllIllIlllIllIl; ++llllllllllllllIlIIllIllIlllIlIlI) {
                        for (int llllllllllllllIlIIllIllIlllIlIII = llllllllllllllIlIIllIllIllIllIIl.getZ() - llllllllllllllIlIIllIllIlllIllIl; llllllllllllllIlIIllIllIlllIlIII <= llllllllllllllIlIIllIllIllIllIIl.getZ() + llllllllllllllIlIIllIllIlllIllIl; ++llllllllllllllIlIIllIllIlllIlIII) {
                            final BlockPos llllllllllllllIlIIllIllIlllIIIIl = new BlockPos(llllllllllllllIlIIllIllIlllIlIlI, llllllllllllllIlIIllIllIllllIllI, llllllllllllllIlIIllIllIlllIlIII);
                            if (llllllllllllllIlIIllIllIlllllllI.getBlockState(llllllllllllllIlIIllIllIlllIIIIl).getBlock().getMaterial() == Material.leaves) {
                                final BlockPos llllllllllllllIlIIllIllIlllIIIII = llllllllllllllIlIIllIllIlllIIIIl.offsetWest();
                                final BlockPos llllllllllllllIlIIllIllIlllIIllI = llllllllllllllIlIIllIllIlllIIIIl.offsetEast();
                                final BlockPos llllllllllllllIlIIllIllIllIlllll = llllllllllllllIlIIllIllIlllIIIIl.offsetNorth();
                                final BlockPos llllllllllllllIlIIllIllIllIllllI = llllllllllllllIlIIllIllIlllIIIIl.offsetSouth();
                                if (llllllllllllllIlIIllIllIllIllIlI.nextInt(4) == 0 && llllllllllllllIlIIllIllIlllllllI.getBlockState(llllllllllllllIlIIllIllIlllIIIII).getBlock().getMaterial() == Material.air) {
                                    this.func_175923_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIlllIIIII, BlockVine.field_176275_S);
                                }
                                if (llllllllllllllIlIIllIllIllIllIlI.nextInt(4) == 0 && llllllllllllllIlIIllIllIlllllllI.getBlockState(llllllllllllllIlIIllIllIlllIIllI).getBlock().getMaterial() == Material.air) {
                                    this.func_175923_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIlllIIllI, BlockVine.field_176271_T);
                                }
                                if (llllllllllllllIlIIllIllIllIllIlI.nextInt(4) == 0 && llllllllllllllIlIIllIllIlllllllI.getBlockState(llllllllllllllIlIIllIllIllIlllll).getBlock().getMaterial() == Material.air) {
                                    this.func_175923_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIlllll, BlockVine.field_176272_Q);
                                }
                                if (llllllllllllllIlIIllIllIllIllIlI.nextInt(4) == 0 && llllllllllllllIlIIllIllIlllllllI.getBlockState(llllllllllllllIlIIllIllIllIllllI).getBlock().getMaterial() == Material.air) {
                                    this.func_175923_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIllllI, BlockVine.field_176276_R);
                                }
                            }
                        }
                    }
                }
                if (llllllllllllllIlIIllIllIllIllIlI.nextInt(5) == 0 && llllllllllllllIlIIllIllIlllllIll > 5) {
                    for (int llllllllllllllIlIIllIllIllllIllI = 0; llllllllllllllIlIIllIllIllllIllI < 2; ++llllllllllllllIlIIllIllIllllIllI) {
                        for (int llllllllllllllIlIIllIllIlllIllll = 0; llllllllllllllIlIIllIllIlllIllll < 4; ++llllllllllllllIlIIllIllIlllIllll) {
                            if (llllllllllllllIlIIllIllIllIllIlI.nextInt(4 - llllllllllllllIlIIllIllIllllIllI) == 0) {
                                final int llllllllllllllIlIIllIllIlllIllII = llllllllllllllIlIIllIllIllIllIlI.nextInt(3);
                                final EnumFacing llllllllllllllIlIIllIllIllIlllIl = EnumFacing.getHorizontal(llllllllllllllIlIIllIllIlllIllll).getOpposite();
                                this.func_175905_a(llllllllllllllIlIIllIllIlllllllI, llllllllllllllIlIIllIllIllIllIIl.add(llllllllllllllIlIIllIllIllIlllIl.getFrontOffsetX(), llllllllllllllIlIIllIllIlllllIll - 5 + llllllllllllllIlIIllIllIllllIllI, llllllllllllllIlIIllIllIllIlllIl.getFrontOffsetZ()), Blocks.cocoa, llllllllllllllIlIIllIllIlllIllII << 2 | EnumFacing.getHorizontal(llllllllllllllIlIIllIllIlllIllll).getHorizontalIndex());
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000438";
    }
}
