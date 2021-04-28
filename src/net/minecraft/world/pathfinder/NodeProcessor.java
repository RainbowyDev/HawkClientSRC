package net.minecraft.world.pathfinder;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.*;

public abstract class NodeProcessor
{
    protected /* synthetic */ int field_176165_d;
    protected /* synthetic */ int field_176166_e;
    protected /* synthetic */ IBlockAccess field_176169_a;
    protected /* synthetic */ int field_176168_c;
    protected /* synthetic */ IntHashMap field_176167_b;
    
    public abstract PathPoint func_176160_a(final Entity p0, final double p1, final double p2, final double p3);
    
    public NodeProcessor() {
        this.field_176167_b = new IntHashMap();
    }
    
    protected PathPoint func_176159_a(final int lllllllllllllIllllllllIllIIllIIl, final int lllllllllllllIllllllllIllIIllllI, final int lllllllllllllIllllllllIllIIlllIl) {
        final int lllllllllllllIllllllllIllIIlllII = PathPoint.makeHash(lllllllllllllIllllllllIllIIllIIl, lllllllllllllIllllllllIllIIllllI, lllllllllllllIllllllllIllIIlllIl);
        PathPoint lllllllllllllIllllllllIllIIllIll = (PathPoint)this.field_176167_b.lookup(lllllllllllllIllllllllIllIIlllII);
        if (lllllllllllllIllllllllIllIIllIll == null) {
            lllllllllllllIllllllllIllIIllIll = new PathPoint(lllllllllllllIllllllllIllIIllIIl, lllllllllllllIllllllllIllIIllllI, lllllllllllllIllllllllIllIIlllIl);
            this.field_176167_b.addKey(lllllllllllllIllllllllIllIIlllII, lllllllllllllIllllllllIllIIllIll);
        }
        return lllllllllllllIllllllllIllIIllIll;
    }
    
    public void func_176163_a() {
    }
    
    public void func_176162_a(final IBlockAccess lllllllllllllIllllllllIllIlIllII, final Entity lllllllllllllIllllllllIllIlIlIll) {
        this.field_176169_a = lllllllllllllIllllllllIllIlIllII;
        this.field_176167_b.clearMap();
        this.field_176168_c = MathHelper.floor_float(lllllllllllllIllllllllIllIlIlIll.width + 1.0f);
        this.field_176165_d = MathHelper.floor_float(lllllllllllllIllllllllIllIlIlIll.height + 1.0f);
        this.field_176166_e = MathHelper.floor_float(lllllllllllllIllllllllIllIlIlIll.width + 1.0f);
    }
    
    static {
        __OBFID = "CL_00001967";
    }
    
    public abstract PathPoint func_176161_a(final Entity p0);
    
    public abstract int func_176164_a(final PathPoint[] p0, final Entity p1, final PathPoint p2, final PathPoint p3, final float p4);
}
