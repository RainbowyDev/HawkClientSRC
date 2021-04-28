package net.minecraft.world.pathfinder;

import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public class WalkNodeProcessor extends NodeProcessor
{
    private /* synthetic */ boolean field_176182_j;
    private /* synthetic */ boolean field_176180_f;
    private /* synthetic */ boolean field_176181_g;
    private /* synthetic */ boolean field_176184_i;
    private /* synthetic */ boolean field_176183_h;
    
    public void func_176176_c(final boolean llllllllllllllIIlllIlIIlIIIlIIll) {
        this.field_176183_h = llllllllllllllIIlllIlIIlIIIlIIll;
    }
    
    public void func_176175_a(final boolean llllllllllllllIIlllIlIIlIIIlllll) {
        this.field_176180_f = llllllllllllllIIlllIlIIlIIIlllll;
    }
    
    static {
        __OBFID = "CL_00001965";
    }
    
    private int func_176177_a(final Entity llllllllllllllIIlllIlIIlIllIIlII, final int llllllllllllllIIlllIlIIlIlIllllI, final int llllllllllllllIIlllIlIIlIlIlllIl, final int llllllllllllllIIlllIlIIlIllIIIIl) {
        return func_176170_a(this.field_176169_a, llllllllllllllIIlllIlIIlIllIIlII, llllllllllllllIIlllIlIIlIlIllllI, llllllllllllllIIlllIlIIlIlIlllIl, llllllllllllllIIlllIlIIlIllIIIIl, this.field_176168_c, this.field_176165_d, this.field_176166_e, this.field_176183_h, this.field_176181_g, this.field_176180_f);
    }
    
    @Override
    public PathPoint func_176161_a(final Entity llllllllllllllIIlllIlIIllIlllllI) {
        int llllllllllllllIIlllIlIIlllIIIIIl = 0;
        if (this.field_176184_i && llllllllllllllIIlllIlIIllIlllllI.isInWater()) {
            int llllllllllllllIIlllIlIIlllIIIIlI = (int)llllllllllllllIIlllIlIIllIlllllI.getEntityBoundingBox().minY;
            for (Block llllllllllllllIIlllIlIIlllIIIIII = this.field_176169_a.getBlockState(new BlockPos(MathHelper.floor_double(llllllllllllllIIlllIlIIllIlllllI.posX), llllllllllllllIIlllIlIIlllIIIIlI, MathHelper.floor_double(llllllllllllllIIlllIlIIllIlllllI.posZ))).getBlock(); llllllllllllllIIlllIlIIlllIIIIII == Blocks.flowing_water || llllllllllllllIIlllIlIIlllIIIIII == Blocks.water; llllllllllllllIIlllIlIIlllIIIIII = this.field_176169_a.getBlockState(new BlockPos(MathHelper.floor_double(llllllllllllllIIlllIlIIllIlllllI.posX), llllllllllllllIIlllIlIIlllIIIIlI, MathHelper.floor_double(llllllllllllllIIlllIlIIllIlllllI.posZ))).getBlock()) {
                ++llllllllllllllIIlllIlIIlllIIIIlI;
            }
            this.field_176183_h = false;
        }
        else {
            llllllllllllllIIlllIlIIlllIIIIIl = MathHelper.floor_double(llllllllllllllIIlllIlIIllIlllllI.getEntityBoundingBox().minY + 0.5);
        }
        return this.func_176159_a(MathHelper.floor_double(llllllllllllllIIlllIlIIllIlllllI.getEntityBoundingBox().minX), llllllllllllllIIlllIlIIlllIIIIIl, MathHelper.floor_double(llllllllllllllIIlllIlIIllIlllllI.getEntityBoundingBox().minZ));
    }
    
    public boolean func_176174_d() {
        return this.field_176184_i;
    }
    
    @Override
    public int func_176164_a(final PathPoint[] llllllllllllllIIlllIlIIllIIlllll, final Entity llllllllllllllIIlllIlIIllIIllllI, final PathPoint llllllllllllllIIlllIlIIllIIlIIIl, final PathPoint llllllllllllllIIlllIlIIllIIlIIII, final float llllllllllllllIIlllIlIIllIIllIll) {
        int llllllllllllllIIlllIlIIllIIllIlI = 0;
        byte llllllllllllllIIlllIlIIllIIllIIl = 0;
        if (this.func_176177_a(llllllllllllllIIlllIlIIllIIllllI, llllllllllllllIIlllIlIIllIIlIIIl.xCoord, llllllllllllllIIlllIlIIllIIlIIIl.yCoord + 1, llllllllllllllIIlllIlIIllIIlIIIl.zCoord) == 1) {
            llllllllllllllIIlllIlIIllIIllIIl = 1;
        }
        final PathPoint llllllllllllllIIlllIlIIllIIllIII = this.func_176171_a(llllllllllllllIIlllIlIIllIIllllI, llllllllllllllIIlllIlIIllIIlIIIl.xCoord, llllllllllllllIIlllIlIIllIIlIIIl.yCoord, llllllllllllllIIlllIlIIllIIlIIIl.zCoord + 1, llllllllllllllIIlllIlIIllIIllIIl);
        final PathPoint llllllllllllllIIlllIlIIllIIlIlll = this.func_176171_a(llllllllllllllIIlllIlIIllIIllllI, llllllllllllllIIlllIlIIllIIlIIIl.xCoord - 1, llllllllllllllIIlllIlIIllIIlIIIl.yCoord, llllllllllllllIIlllIlIIllIIlIIIl.zCoord, llllllllllllllIIlllIlIIllIIllIIl);
        final PathPoint llllllllllllllIIlllIlIIllIIlIllI = this.func_176171_a(llllllllllllllIIlllIlIIllIIllllI, llllllllllllllIIlllIlIIllIIlIIIl.xCoord + 1, llllllllllllllIIlllIlIIllIIlIIIl.yCoord, llllllllllllllIIlllIlIIllIIlIIIl.zCoord, llllllllllllllIIlllIlIIllIIllIIl);
        final PathPoint llllllllllllllIIlllIlIIllIIlIlIl = this.func_176171_a(llllllllllllllIIlllIlIIllIIllllI, llllllllllllllIIlllIlIIllIIlIIIl.xCoord, llllllllllllllIIlllIlIIllIIlIIIl.yCoord, llllllllllllllIIlllIlIIllIIlIIIl.zCoord - 1, llllllllllllllIIlllIlIIllIIllIIl);
        if (llllllllllllllIIlllIlIIllIIllIII != null && !llllllllllllllIIlllIlIIllIIllIII.visited && llllllllllllllIIlllIlIIllIIllIII.distanceTo(llllllllllllllIIlllIlIIllIIlIIII) < llllllllllllllIIlllIlIIllIIllIll) {
            llllllllllllllIIlllIlIIllIIlllll[llllllllllllllIIlllIlIIllIIllIlI++] = llllllllllllllIIlllIlIIllIIllIII;
        }
        if (llllllllllllllIIlllIlIIllIIlIlll != null && !llllllllllllllIIlllIlIIllIIlIlll.visited && llllllllllllllIIlllIlIIllIIlIlll.distanceTo(llllllllllllllIIlllIlIIllIIlIIII) < llllllllllllllIIlllIlIIllIIllIll) {
            llllllllllllllIIlllIlIIllIIlllll[llllllllllllllIIlllIlIIllIIllIlI++] = llllllllllllllIIlllIlIIllIIlIlll;
        }
        if (llllllllllllllIIlllIlIIllIIlIllI != null && !llllllllllllllIIlllIlIIllIIlIllI.visited && llllllllllllllIIlllIlIIllIIlIllI.distanceTo(llllllllllllllIIlllIlIIllIIlIIII) < llllllllllllllIIlllIlIIllIIllIll) {
            llllllllllllllIIlllIlIIllIIlllll[llllllllllllllIIlllIlIIllIIllIlI++] = llllllllllllllIIlllIlIIllIIlIllI;
        }
        if (llllllllllllllIIlllIlIIllIIlIlIl != null && !llllllllllllllIIlllIlIIllIIlIlIl.visited && llllllllllllllIIlllIlIIllIIlIlIl.distanceTo(llllllllllllllIIlllIlIIllIIlIIII) < llllllllllllllIIlllIlIIllIIllIll) {
            llllllllllllllIIlllIlIIllIIlllll[llllllllllllllIIlllIlIIllIIllIlI++] = llllllllllllllIIlllIlIIllIIlIlIl;
        }
        return llllllllllllllIIlllIlIIllIIllIlI;
    }
    
    public boolean func_176179_b() {
        return this.field_176180_f;
    }
    
    @Override
    public void func_176163_a() {
        super.func_176163_a();
        this.field_176183_h = this.field_176182_j;
    }
    
    @Override
    public PathPoint func_176160_a(final Entity llllllllllllllIIlllIlIIllIllIIII, final double llllllllllllllIIlllIlIIllIllIlII, final double llllllllllllllIIlllIlIIllIlIlllI, final double llllllllllllllIIlllIlIIllIlIllIl) {
        return this.func_176159_a(MathHelper.floor_double(llllllllllllllIIlllIlIIllIllIlII - llllllllllllllIIlllIlIIllIllIIII.width / 2.0f), MathHelper.floor_double(llllllllllllllIIlllIlIIllIlIlllI), MathHelper.floor_double(llllllllllllllIIlllIlIIllIlIllIl - llllllllllllllIIlllIlIIllIllIIII.width / 2.0f));
    }
    
    public static int func_176170_a(final IBlockAccess llllllllllllllIIlllIlIIlIlIIlIII, final Entity llllllllllllllIIlllIlIIlIIllIlII, final int llllllllllllllIIlllIlIIlIIllIIll, final int llllllllllllllIIlllIlIIlIIllIIlI, final int llllllllllllllIIlllIlIIlIlIIIlII, final int llllllllllllllIIlllIlIIlIlIIIIll, final int llllllllllllllIIlllIlIIlIIlIllll, final int llllllllllllllIIlllIlIIlIlIIIIIl, final boolean llllllllllllllIIlllIlIIlIlIIIIII, final boolean llllllllllllllIIlllIlIIlIIllllll, final boolean llllllllllllllIIlllIlIIlIIlllllI) {
        boolean llllllllllllllIIlllIlIIlIIllllIl = false;
        final BlockPos llllllllllllllIIlllIlIIlIIllllII = new BlockPos(llllllllllllllIIlllIlIIlIIllIlII);
        for (int llllllllllllllIIlllIlIIlIIlllIll = llllllllllllllIIlllIlIIlIIllIIll; llllllllllllllIIlllIlIIlIIlllIll < llllllllllllllIIlllIlIIlIIllIIll + llllllllllllllIIlllIlIIlIlIIIIll; ++llllllllllllllIIlllIlIIlIIlllIll) {
            for (int llllllllllllllIIlllIlIIlIIlllIlI = llllllllllllllIIlllIlIIlIIllIIlI; llllllllllllllIIlllIlIIlIIlllIlI < llllllllllllllIIlllIlIIlIIllIIlI + llllllllllllllIIlllIlIIlIIlIllll; ++llllllllllllllIIlllIlIIlIIlllIlI) {
                for (int llllllllllllllIIlllIlIIlIIlllIIl = llllllllllllllIIlllIlIIlIlIIIlII; llllllllllllllIIlllIlIIlIIlllIIl < llllllllllllllIIlllIlIIlIlIIIlII + llllllllllllllIIlllIlIIlIlIIIIIl; ++llllllllllllllIIlllIlIIlIIlllIIl) {
                    final BlockPos llllllllllllllIIlllIlIIlIIlllIII = new BlockPos(llllllllllllllIIlllIlIIlIIlllIll, llllllllllllllIIlllIlIIlIIlllIlI, llllllllllllllIIlllIlIIlIIlllIIl);
                    final Block llllllllllllllIIlllIlIIlIIllIlll = llllllllllllllIIlllIlIIlIlIIlIII.getBlockState(llllllllllllllIIlllIlIIlIIlllIII).getBlock();
                    if (llllllllllllllIIlllIlIIlIIllIlll.getMaterial() != Material.air) {
                        if (llllllllllllllIIlllIlIIlIIllIlll != Blocks.trapdoor && llllllllllllllIIlllIlIIlIIllIlll != Blocks.iron_trapdoor) {
                            if (llllllllllllllIIlllIlIIlIIllIlll != Blocks.flowing_water && llllllllllllllIIlllIlIIlIIllIlll != Blocks.water) {
                                if (!llllllllllllllIIlllIlIIlIIlllllI && llllllllllllllIIlllIlIIlIIllIlll instanceof BlockDoor && llllllllllllllIIlllIlIIlIIllIlll.getMaterial() == Material.wood) {
                                    return 0;
                                }
                            }
                            else {
                                if (llllllllllllllIIlllIlIIlIlIIIIII) {
                                    return -1;
                                }
                                llllllllllllllIIlllIlIIlIIllllIl = true;
                            }
                        }
                        else {
                            llllllllllllllIIlllIlIIlIIllllIl = true;
                        }
                        if (llllllllllllllIIlllIlIIlIIllIlII.worldObj.getBlockState(llllllllllllllIIlllIlIIlIIlllIII).getBlock() instanceof BlockRailBase) {
                            if (!(llllllllllllllIIlllIlIIlIIllIlII.worldObj.getBlockState(llllllllllllllIIlllIlIIlIIllllII).getBlock() instanceof BlockRailBase) && !(llllllllllllllIIlllIlIIlIIllIlII.worldObj.getBlockState(llllllllllllllIIlllIlIIlIIllllII.offsetDown()).getBlock() instanceof BlockRailBase)) {
                                return -3;
                            }
                        }
                        else if (!llllllllllllllIIlllIlIIlIIllIlll.isPassable(llllllllllllllIIlllIlIIlIlIIlIII, llllllllllllllIIlllIlIIlIIlllIII) && (!llllllllllllllIIlllIlIIlIIllllll || !(llllllllllllllIIlllIlIIlIIllIlll instanceof BlockDoor) || llllllllllllllIIlllIlIIlIIllIlll.getMaterial() != Material.wood)) {
                            if (llllllllllllllIIlllIlIIlIIllIlll instanceof BlockFence || llllllllllllllIIlllIlIIlIIllIlll instanceof BlockFenceGate || llllllllllllllIIlllIlIIlIIllIlll instanceof BlockWall) {
                                return -3;
                            }
                            if (llllllllllllllIIlllIlIIlIIllIlll == Blocks.trapdoor || llllllllllllllIIlllIlIIlIIllIlll == Blocks.iron_trapdoor) {
                                return -4;
                            }
                            final Material llllllllllllllIIlllIlIIlIIllIllI = llllllllllllllIIlllIlIIlIIllIlll.getMaterial();
                            if (llllllllllllllIIlllIlIIlIIllIllI != Material.lava) {
                                return 0;
                            }
                            if (!llllllllllllllIIlllIlIIlIIllIlII.func_180799_ab()) {
                                return -2;
                            }
                        }
                    }
                }
            }
        }
        return llllllllllllllIIlllIlIIlIIllllIl ? 2 : 1;
    }
    
    @Override
    public void func_176162_a(final IBlockAccess llllllllllllllIIlllIlIIlllIlIIII, final Entity llllllllllllllIIlllIlIIlllIIllll) {
        super.func_176162_a(llllllllllllllIIlllIlIIlllIlIIII, llllllllllllllIIlllIlIIlllIIllll);
        this.field_176182_j = this.field_176183_h;
    }
    
    public void func_176178_d(final boolean llllllllllllllIIlllIlIIlIIIIllIl) {
        this.field_176184_i = llllllllllllllIIlllIlIIlIIIIllIl;
    }
    
    public boolean func_176173_e() {
        return this.field_176183_h;
    }
    
    public void func_176172_b(final boolean llllllllllllllIIlllIlIIlIIIllIIl) {
        this.field_176181_g = llllllllllllllIIlllIlIIlIIIllIIl;
    }
    
    private PathPoint func_176171_a(final Entity llllllllllllllIIlllIlIIlIlllIIll, final int llllllllllllllIIlllIlIIlIlllllII, int llllllllllllllIIlllIlIIlIlllIIIl, final int llllllllllllllIIlllIlIIlIllllIlI, final int llllllllllllllIIlllIlIIlIllIllll) {
        PathPoint llllllllllllllIIlllIlIIlIllllIII = null;
        final int llllllllllllllIIlllIlIIlIlllIlll = this.func_176177_a(llllllllllllllIIlllIlIIlIlllIIll, llllllllllllllIIlllIlIIlIlllllII, llllllllllllllIIlllIlIIlIlllIIIl, llllllllllllllIIlllIlIIlIllllIlI);
        if (llllllllllllllIIlllIlIIlIlllIlll == 2) {
            return this.func_176159_a(llllllllllllllIIlllIlIIlIlllllII, llllllllllllllIIlllIlIIlIlllIIIl, llllllllllllllIIlllIlIIlIllllIlI);
        }
        if (llllllllllllllIIlllIlIIlIlllIlll == 1) {
            llllllllllllllIIlllIlIIlIllllIII = this.func_176159_a(llllllllllllllIIlllIlIIlIlllllII, llllllllllllllIIlllIlIIlIlllIIIl, llllllllllllllIIlllIlIIlIllllIlI);
        }
        if (llllllllllllllIIlllIlIIlIllllIII == null && llllllllllllllIIlllIlIIlIllIllll > 0 && llllllllllllllIIlllIlIIlIlllIlll != -3 && llllllllllllllIIlllIlIIlIlllIlll != -4 && this.func_176177_a(llllllllllllllIIlllIlIIlIlllIIll, llllllllllllllIIlllIlIIlIlllllII, llllllllllllllIIlllIlIIlIlllIIIl + llllllllllllllIIlllIlIIlIllIllll, llllllllllllllIIlllIlIIlIllllIlI) == 1) {
            llllllllllllllIIlllIlIIlIllllIII = this.func_176159_a(llllllllllllllIIlllIlIIlIlllllII, llllllllllllllIIlllIlIIlIlllIIIl + llllllllllllllIIlllIlIIlIllIllll, llllllllllllllIIlllIlIIlIllllIlI);
            llllllllllllllIIlllIlIIlIlllIIIl += llllllllllllllIIlllIlIIlIllIllll;
        }
        if (llllllllllllllIIlllIlIIlIllllIII != null) {
            int llllllllllllllIIlllIlIIlIlllIllI = 0;
            int llllllllllllllIIlllIlIIlIlllIlIl = 0;
            while (llllllllllllllIIlllIlIIlIlllIIIl > 0) {
                llllllllllllllIIlllIlIIlIlllIlIl = this.func_176177_a(llllllllllllllIIlllIlIIlIlllIIll, llllllllllllllIIlllIlIIlIlllllII, llllllllllllllIIlllIlIIlIlllIIIl - 1, llllllllllllllIIlllIlIIlIllllIlI);
                if (this.field_176183_h && llllllllllllllIIlllIlIIlIlllIlIl == -1) {
                    return null;
                }
                if (llllllllllllllIIlllIlIIlIlllIlIl != 1) {
                    break;
                }
                if (llllllllllllllIIlllIlIIlIlllIllI++ >= llllllllllllllIIlllIlIIlIlllIIll.getMaxFallHeight()) {
                    return null;
                }
                if (--llllllllllllllIIlllIlIIlIlllIIIl <= 0) {
                    return null;
                }
                llllllllllllllIIlllIlIIlIllllIII = this.func_176159_a(llllllllllllllIIlllIlIIlIlllllII, llllllllllllllIIlllIlIIlIlllIIIl, llllllllllllllIIlllIlIIlIllllIlI);
            }
            if (llllllllllllllIIlllIlIIlIlllIlIl == -2) {
                return null;
            }
        }
        return llllllllllllllIIlllIlIIlIllllIII;
    }
}
