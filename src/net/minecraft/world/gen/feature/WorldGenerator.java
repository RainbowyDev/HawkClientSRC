package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public abstract class WorldGenerator
{
    private final /* synthetic */ boolean doBlockNotify;
    
    public abstract boolean generate(final World p0, final Random p1, final BlockPos p2);
    
    public WorldGenerator(final boolean lllllllllllllllIlllIllIlIlllIlll) {
        this.doBlockNotify = lllllllllllllllIlllIllIlIlllIlll;
    }
    
    static {
        __OBFID = "CL_00000409";
    }
    
    protected void func_175903_a(final World lllllllllllllllIlllIllIlIlIlIIll, final BlockPos lllllllllllllllIlllIllIlIlIIlllI, final IBlockState lllllllllllllllIlllIllIlIlIIllIl) {
        if (this.doBlockNotify) {
            lllllllllllllllIlllIllIlIlIlIIll.setBlockState(lllllllllllllllIlllIllIlIlIIlllI, lllllllllllllllIlllIllIlIlIIllIl, 3);
        }
        else {
            lllllllllllllllIlllIllIlIlIlIIll.setBlockState(lllllllllllllllIlllIllIlIlIIlllI, lllllllllllllllIlllIllIlIlIIllIl, 2);
        }
    }
    
    public WorldGenerator() {
        this(false);
    }
    
    protected void func_175905_a(final World lllllllllllllllIlllIllIlIlIlllII, final BlockPos lllllllllllllllIlllIllIlIlIllIll, final Block lllllllllllllllIlllIllIlIlIllIlI, final int lllllllllllllllIlllIllIlIlIllllI) {
        this.func_175903_a(lllllllllllllllIlllIllIlIlIlllII, lllllllllllllllIlllIllIlIlIllIll, lllllllllllllllIlllIllIlIlIllIlI.getStateFromMeta(lllllllllllllllIlllIllIlIlIllllI));
    }
    
    public void func_175904_e() {
    }
    
    protected void func_175906_a(final World lllllllllllllllIlllIllIlIllIlIlI, final BlockPos lllllllllllllllIlllIllIlIllIlIIl, final Block lllllllllllllllIlllIllIlIllIllII) {
        this.func_175905_a(lllllllllllllllIlllIllIlIllIlIlI, lllllllllllllllIlllIllIlIllIlIIl, lllllllllllllllIlllIllIlIllIllII, 0);
    }
}
