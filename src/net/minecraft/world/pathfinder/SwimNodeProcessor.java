package net.minecraft.world.pathfinder;

import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class SwimNodeProcessor extends NodeProcessor
{
    static {
        __OBFID = "CL_00001966";
    }
    
    @Override
    public PathPoint func_176160_a(final Entity llllllllllllllIlIIllIIllIIlIlIll, final double llllllllllllllIlIIllIIllIIlIlIlI, final double llllllllllllllIlIIllIIllIIlIlIIl, final double llllllllllllllIlIIllIIllIIlIllIl) {
        return this.func_176159_a(MathHelper.floor_double(llllllllllllllIlIIllIIllIIlIlIlI - llllllllllllllIlIIllIIllIIlIlIll.width / 2.0f), MathHelper.floor_double(llllllllllllllIlIIllIIllIIlIlIIl + 0.5), MathHelper.floor_double(llllllllllllllIlIIllIIllIIlIllIl - llllllllllllllIlIIllIIllIIlIlIll.width / 2.0f));
    }
    
    @Override
    public PathPoint func_176161_a(final Entity llllllllllllllIlIIllIIllIIllIlll) {
        return this.func_176159_a(MathHelper.floor_double(llllllllllllllIlIIllIIllIIllIlll.getEntityBoundingBox().minX), MathHelper.floor_double(llllllllllllllIlIIllIIllIIllIlll.getEntityBoundingBox().minY + 0.5), MathHelper.floor_double(llllllllllllllIlIIllIIllIIllIlll.getEntityBoundingBox().minZ));
    }
    
    private PathPoint func_176185_a(final Entity llllllllllllllIlIIllIIlIllIlIlll, final int llllllllllllllIlIIllIIlIllIlIlIl, final int llllllllllllllIlIIllIIlIllIlIlII, final int llllllllllllllIlIIllIIlIllIlllIl) {
        final int llllllllllllllIlIIllIIlIllIllIll = this.func_176186_b(llllllllllllllIlIIllIIlIllIlIlll, llllllllllllllIlIIllIIlIllIlIlIl, llllllllllllllIlIIllIIlIllIlIlII, llllllllllllllIlIIllIIlIllIlllIl);
        return (llllllllllllllIlIIllIIlIllIllIll == -1) ? this.func_176159_a(llllllllllllllIlIIllIIlIllIlIlIl, llllllllllllllIlIIllIIlIllIlIlII, llllllllllllllIlIIllIIlIllIlllIl) : null;
    }
    
    @Override
    public void func_176163_a() {
        super.func_176163_a();
    }
    
    @Override
    public void func_176162_a(final IBlockAccess llllllllllllllIlIIllIIllIlIIIIIl, final Entity llllllllllllllIlIIllIIllIlIIIIII) {
        super.func_176162_a(llllllllllllllIlIIllIIllIlIIIIIl, llllllllllllllIlIIllIIllIlIIIIII);
    }
    
    private int func_176186_b(final Entity llllllllllllllIlIIllIIlIlIllIIII, final int llllllllllllllIlIIllIIlIlIlIIIII, final int llllllllllllllIlIIllIIlIlIlIllII, final int llllllllllllllIlIIllIIlIlIIlllII) {
        for (int llllllllllllllIlIIllIIlIlIlIlIII = llllllllllllllIlIIllIIlIlIlIIIII; llllllllllllllIlIIllIIlIlIlIlIII < llllllllllllllIlIIllIIlIlIlIIIII + this.field_176168_c; ++llllllllllllllIlIIllIIlIlIlIlIII) {
            for (int llllllllllllllIlIIllIIlIlIlIIllI = llllllllllllllIlIIllIIlIlIlIllII; llllllllllllllIlIIllIIlIlIlIIllI < llllllllllllllIlIIllIIlIlIlIllII + this.field_176165_d; ++llllllllllllllIlIIllIIlIlIlIIllI) {
                for (int llllllllllllllIlIIllIIlIlIlIIlIl = llllllllllllllIlIIllIIlIlIIlllII; llllllllllllllIlIIllIIlIlIlIIlIl < llllllllllllllIlIIllIIlIlIIlllII + this.field_176166_e; ++llllllllllllllIlIIllIIlIlIlIIlIl) {
                    final BlockPos llllllllllllllIlIIllIIlIlIlIIlII = new BlockPos(llllllllllllllIlIIllIIlIlIlIlIII, llllllllllllllIlIIllIIlIlIlIIllI, llllllllllllllIlIIllIIlIlIlIIlIl);
                    final Block llllllllllllllIlIIllIIlIlIlIIIll = this.field_176169_a.getBlockState(llllllllllllllIlIIllIIlIlIlIIlII).getBlock();
                    if (llllllllllllllIlIIllIIlIlIlIIIll.getMaterial() != Material.water) {
                        return 0;
                    }
                }
            }
        }
        return -1;
    }
    
    @Override
    public int func_176164_a(final PathPoint[] llllllllllllllIlIIllIIllIIIllIII, final Entity llllllllllllllIlIIllIIllIIIlIllI, final PathPoint llllllllllllllIlIIllIIllIIIIIIII, final PathPoint llllllllllllllIlIIllIIlIllllllll, final float llllllllllllllIlIIllIIlIllllllIl) {
        int llllllllllllllIlIIllIIllIIIIllll = 0;
        for (final EnumFacing llllllllllllllIlIIllIIllIIIIIlll : EnumFacing.values()) {
            final PathPoint llllllllllllllIlIIllIIllIIIIIlIl = this.func_176185_a(llllllllllllllIlIIllIIllIIIlIllI, llllllllllllllIlIIllIIllIIIIIIII.xCoord + llllllllllllllIlIIllIIllIIIIIlll.getFrontOffsetX(), llllllllllllllIlIIllIIllIIIIIIII.yCoord + llllllllllllllIlIIllIIllIIIIIlll.getFrontOffsetY(), llllllllllllllIlIIllIIllIIIIIIII.zCoord + llllllllllllllIlIIllIIllIIIIIlll.getFrontOffsetZ());
            if (llllllllllllllIlIIllIIllIIIIIlIl != null && !llllllllllllllIlIIllIIllIIIIIlIl.visited && llllllllllllllIlIIllIIllIIIIIlIl.distanceTo(llllllllllllllIlIIllIIlIllllllll) < llllllllllllllIlIIllIIlIllllllIl) {
                llllllllllllllIlIIllIIllIIIllIII[llllllllllllllIlIIllIIllIIIIllll++] = llllllllllllllIlIIllIIllIIIIIlIl;
            }
        }
        return llllllllllllllIlIIllIIllIIIIllll;
    }
}
